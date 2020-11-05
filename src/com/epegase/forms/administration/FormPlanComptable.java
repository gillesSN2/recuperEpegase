package com.epegase.forms.administration;

import com.epegase.systeme.classe.Ecritures;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.JournauxComptables;
import com.epegase.systeme.classe.PlanComptable;
import com.epegase.systeme.classe.Racines;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.AmortissementsDao;
import com.epegase.systeme.dao.EcrituresDao;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.PlanComptableDao;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
import com.epegase.systeme.dao.RacinesDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureNatureCompte;
import com.epegase.systeme.xml.LectureRacines;
import com.epegase.systeme.xml.LireLesoptionsCompta;
import com.epegase.systeme.xml.ObjetCompte;
import com.epegase.systeme.xml.ObjetRacine;
import com.epegase.systeme.xml.OptionComptabilite;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class FormPlanComptable implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private ExercicesComptable exoLast;
   private ExercicesComptable exoSelect;
   private ExercicesComptableDao exercicesComptableDao;
   private String natureFiscale;
   private Racines racines;
   private String choixPC;
   private String mouvement = "0";
   private String zoneFiscal;
   private List lesNaturesFiscale = new ArrayList();
   private List naturFiscalItem = new ArrayList();
   private List racinesItems = new ArrayList();
   private List lesRacinesCompletes;
   private PlanComptable planComptable;
   private int compteDesactiveModif;
   private boolean inactif;
   private boolean affichTauxTaxe = false;
   private boolean affichRan = false;
   private boolean vhlibre = true;
   private boolean vhtt;
   private boolean vhcd;
   private boolean afficheAjout;
   private boolean afficheAjDefaut;
   private int nombrCaracter;
   private int nbcarmax;
   private String format;
   private PlanComptableDao planComptableDao;
   private RacinesDao racinesDao;
   private List maListe;
   private EcrituresDao ecrituresDao;
   private AmortissementsDao amortissementsDao;
   private transient DataModel madatamodel = new ListDataModel();
   private boolean afficheButtSup;
   private boolean afficheButtMod;
   private boolean disable;
   boolean existeCopteDeja = true;
   private String intituleNat;
   private boolean oneMenuModif;
   private String intituleRac;
   private boolean racModif;
   private String complNum;
   private String codRacine;
   private Element racine;
   private boolean var_affPanelCompte = false;
   private List mesClesAnalytiques;
   private String filtre;
   private String requete;
   private Document document;
   private Element racin;
   private int choixRacine;
   private String selecFiscalite;
   private List lesAnneesItems;
   private long annee;

   public FormPlanComptable() {
      this.madatamodel = new ListDataModel();
      this.maListe = new ArrayList();
      this.mesClesAnalytiques = new ArrayList();
      this.lesRacinesCompletes = new ArrayList();
      this.lesAnneesItems = new ArrayList();
   }

   public void InstancesDaoUtilses() {
      this.planComptableDao = new PlanComptableDao(this.baseLog, this.utilInitHibernate);
      this.amortissementsDao = new AmortissementsDao(this.baseLog, this.utilInitHibernate);
      this.ecrituresDao = new EcrituresDao(this.baseLog, this.utilInitHibernate);
      this.racinesDao = new RacinesDao(this.baseLog, this.structureLog, this.utilInitHibernate);
      this.exercicesComptableDao = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerNatureCompte() throws IOException, HibernateException, NamingException {
      this.lesNaturesFiscale = new ArrayList();
      this.naturFiscalItem = new ArrayList();
      LectureNatureCompte var1 = new LectureNatureCompte();
      this.lesNaturesFiscale = var1.getMesNatureCompte();
      this.naturFiscalItem = var1.getMesNatureCompteItems();
      new ArrayList();
      List var2 = this.exercicesComptableDao.selectExercicesCompta((Session)null);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            this.lesAnneesItems.add(new SelectItem(((ExercicesComptable)var2.get(var3)).getExecpt_id()));
         }
      }

      new ExercicesComptable();
      ExercicesComptable var4 = this.exercicesComptableDao.recupererLastExo((Session)null);
      if (var4 != null) {
         this.annee = var4.getExecpt_id();
         this.exoLast = var4;
      } else {
         this.annee = 0L;
         this.exoLast = null;
      }

      this.exoSelect = this.exoLast;
   }

   public void chargerMesracines() throws HibernateException, NamingException, IOException {
      if (this.structureLog.getStrzonefiscale2() != null && !this.structureLog.getStrzonefiscale2().isEmpty() && (this.choixRacine == 2 || this.choixRacine == 0)) {
         this.choixRacine = 1;
         this.selecFiscalite = this.structureLog.getStrzonefiscale();
      } else if (this.structureLog.getStrzonefiscale2() != null && !this.structureLog.getStrzonefiscale2().isEmpty() && this.choixRacine == 1) {
         this.choixRacine = 2;
         this.selecFiscalite = this.structureLog.getStrzonefiscale2();
      } else {
         this.choixRacine = 0;
         this.selecFiscalite = this.structureLog.getStrzonefiscale();
      }

      this.zoneFiscal = this.selecFiscalite;
      this.lesRacinesCompletes.clear();
      this.lesRacinesCompletes = this.racinesDao.chargerMesRacines(this.selecFiscalite, (Session)null);
      if (this.lesRacinesCompletes == null || this.lesRacinesCompletes.size() == 0) {
         LectureNatureCompte var1 = new LectureNatureCompte();
         new ArrayList();
         List var2 = var1.getMesNatureCompte();
         LectureRacines var3 = new LectureRacines(this.selecFiscalite);
         var3.setStructureLog(this.structureLog);
         var3.recupereRacines();
         new ArrayList();
         List var4 = var3.getMesRacines();
         if (var4.size() != 0) {
            for(int var5 = 0; var5 < var4.size(); ++var5) {
               Racines var6 = new Racines();
               var6.setRacCode(((ObjetRacine)var4.get(var5)).getCode());
               var6.setRacLibelleFr(((ObjetRacine)var4.get(var5)).getNom_FR());
               if (var6.getRacCode().length() == 1) {
                  var6.setAff_racine(((ObjetRacine)var4.get(var5)).getNom_FR());
                  var6.setRacLibelleUk(((ObjetRacine)var4.get(var5)).getNom_UK());
                  var6.setRacLibelleSp(((ObjetRacine)var4.get(var5)).getNom_SP());
               } else if (var6.getRacCode().length() == 2) {
                  var6.setAff_racine("          " + ((ObjetRacine)var4.get(var5)).getNom_FR());
                  var6.setRacLibelleUk("          " + ((ObjetRacine)var4.get(var5)).getNom_UK());
                  var6.setRacLibelleSp("          " + ((ObjetRacine)var4.get(var5)).getNom_SP());
               } else if (var6.getRacCode().length() == 3) {
                  var6.setAff_racine("                    " + ((ObjetRacine)var4.get(var5)).getNom_FR());
                  var6.setRacLibelleUk("                    " + ((ObjetRacine)var4.get(var5)).getNom_UK());
                  var6.setRacLibelleSp("                    " + ((ObjetRacine)var4.get(var5)).getNom_SP());
               } else if (var6.getRacCode().length() == 4) {
                  var6.setAff_racine("                              " + ((ObjetRacine)var4.get(var5)).getNom_FR());
                  var6.setRacLibelleUk("                              " + ((ObjetRacine)var4.get(var5)).getNom_UK());
                  var6.setRacLibelleSp("                              " + ((ObjetRacine)var4.get(var5)).getNom_SP());
               } else if (var6.getRacCode().length() == 5) {
                  var6.setAff_racine("                                        " + ((ObjetRacine)var4.get(var5)).getNom_FR());
                  var6.setRacLibelleUk("                                        " + ((ObjetRacine)var4.get(var5)).getNom_UK());
                  var6.setRacLibelleSp("                                        " + ((ObjetRacine)var4.get(var5)).getNom_SP());
               } else if (var6.getRacCode().length() == 6) {
                  var6.setAff_racine("                                                  " + ((ObjetRacine)var4.get(var5)).getNom_FR());
                  var6.setRacLibelleUk("                                                  " + ((ObjetRacine)var4.get(var5)).getNom_UK());
                  var6.setRacLibelleSp("                                                  " + ((ObjetRacine)var4.get(var5)).getNom_SP());
               } else if (var6.getRacCode().length() == 7) {
                  var6.setAff_racine("                                                            " + ((ObjetRacine)var4.get(var5)).getNom_FR());
                  var6.setRacLibelleUk("                                                            " + ((ObjetRacine)var4.get(var5)).getNom_UK());
                  var6.setRacLibelleSp("                                                            " + ((ObjetRacine)var4.get(var5)).getNom_SP());
               } else if (var6.getRacCode().length() == 8) {
                  var6.setAff_racine("                                                                      " + ((ObjetRacine)var4.get(var5)).getNom_FR());
                  var6.setRacLibelleUk("                                                                      " + ((ObjetRacine)var4.get(var5)).getNom_UK());
                  var6.setRacLibelleSp("                                                                      " + ((ObjetRacine)var4.get(var5)).getNom_SP());
               }

               var6.setRacCodenature(((ObjetRacine)var4.get(var5)).getNature());
               var6.setRacnature("");
               if (var2.size() != 0) {
                  for(int var7 = 0; var7 < var2.size(); ++var7) {
                     if (((ObjetCompte)var2.get(var7)).getCode().equals(var6.getRacCodenature())) {
                        var6.setRacnature(((ObjetCompte)var2.get(var7)).getNom_FR());
                        break;
                     }
                  }
               }

               var6.setRacUtil(((ObjetRacine)var4.get(var5)).getUtil());
               var6.setRactaux(0.0F);
               this.lesRacinesCompletes.add(var6);
            }
         }

         this.racinesDao.saveRacineComptable(this.selecFiscalite, this.lesRacinesCompletes);
      }

   }

   public void permutterMesracines() throws HibernateException, NamingException, IOException {
      this.chargerMesracines();
      this.selectionChargement();
   }

   public void chargerRacines(String var1) throws IOException, HibernateException, NamingException {
      new ArrayList();
      this.racinesItems = new ArrayList();
      List var2 = this.racinesDao.rechercherListeRacine(this.selecFiscalite, var1, (Session)null);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            new Racines();
            Racines var4 = (Racines)var2.get(var3);
            String var5 = var4.getRacCode() + ":" + var4.getRacLibelleFr();
            this.racinesItems.add(new SelectItem(var5));
         }
      }

   }

   public void testeFiscalite() throws IOException, HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlanComptable");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         boolean var3 = false;
         Object var4 = var1.createQuery("SELECT COUNT(*) FROM PlanComptable where (plcFiscalite is null or plcFiscalite='' or plcFiscalite='null')").uniqueResult();
         int var10 = Integer.parseInt(var4.toString());
         if (var10 > 0) {
            this.planComptableDao.updatePlanComptable(this.selecFiscalite, var1);
         }

         var2.commit();
      } catch (HibernateException var8) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var8;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void chargerPlanComtable(int var1, Session var2) throws IOException, HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlanComptable");
         var3 = true;
      }

      if (var1 == 0) {
         this.maListe.clear();
         this.filtre = "Tous les comptes";
      }

      boolean var4 = false;
      Object var5 = var2.createQuery("SELECT COUNT(*) FROM PlanComptable where plcFiscalite='" + this.selecFiscalite + "' and exercicesComptable.execpt_id=" + this.exoSelect.getExecpt_id()).uniqueResult();
      int var6 = Integer.parseInt(var5.toString());
      if (var6 > 0) {
         this.afficheAjDefaut = false;
         this.afficheAjout = true;
      } else {
         this.afficheAjDefaut = true;
         this.afficheAjout = false;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

   }

   public void selectionChargement() throws IOException, HibernateException, NamingException {
      if (this.natureFiscale == null || this.natureFiscale.isEmpty() || this.natureFiscale.equals("9999")) {
         this.natureFiscale = "0";
      }

      if (this.mouvement == null || this.mouvement.isEmpty()) {
         this.mouvement = "0";
      }

      if (this.annee == 0L) {
         this.annee = this.exoLast.getExecpt_id();
      }

      this.exoSelect = this.exercicesComptableDao.recupererLExoSelect(this.annee, (Session)null);
      if (this.exoSelect == null) {
         this.exoSelect = this.exoLast;
      }

      if (this.mouvement.equalsIgnoreCase("0")) {
         this.chargerTousComptes((Session)null);
      } else if (this.mouvement.equalsIgnoreCase("1")) {
         this.chargerPcMouvementes((Session)null);
      } else if (this.mouvement.equalsIgnoreCase("2")) {
         this.chargerPcNonMouvementes((Session)null);
      } else if (this.mouvement.equalsIgnoreCase("3")) {
         this.chargerTousComptesAnalytiques((Session)null);
      } else if (this.mouvement.equalsIgnoreCase("4")) {
         this.chargerTousComptesSage((Session)null);
      } else if (this.mouvement.equalsIgnoreCase("5")) {
         this.chargerTousComptesSYSCOHADA((Session)null);
      } else if (this.mouvement.equalsIgnoreCase("6")) {
         this.chargerTousComptesAutreFiscalite((Session)null);
      } else if (this.mouvement.equalsIgnoreCase("7")) {
         this.chargerComptesnonConvertis((Session)null);
      }

      if (this.maListe.size() != 0 && this.lesRacinesCompletes.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlanComptable");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.maListe.size(); ++var3) {
               this.planComptable = (PlanComptable)this.maListe.get(var3);
               if (this.planComptable.getPlcNature() == 0) {
                  boolean var4 = false;
               }

               if (this.planComptable.getPlcNature() == 0) {
                  new Racines();
                  Racines var10 = this.rechercheRacine(this.selecFiscalite, this.planComptable.getPlcCompte(), var1);
                  this.planComptable.setPlcCodeRacine(var10.getRacCode());
               }

               for(int var11 = 0; var11 < this.lesRacinesCompletes.size(); ++var11) {
                  if (this.planComptable.getPlcCodeRacine() != null && !this.planComptable.getPlcCodeRacine().isEmpty() && ((Racines)this.lesRacinesCompletes.get(var11)).getRacCode() != null && !((Racines)this.lesRacinesCompletes.get(var11)).getRacCode().isEmpty() && this.planComptable.getPlcCodeRacine().equals(((Racines)this.lesRacinesCompletes.get(var11)).getRacCode())) {
                     if (((Racines)this.lesRacinesCompletes.get(var11)).getRacCodenature() == null || ((Racines)this.lesRacinesCompletes.get(var11)).getRacCodenature().isEmpty()) {
                        ((Racines)this.lesRacinesCompletes.get(var11)).setRacCodenature("0");
                     }

                     this.planComptable.setPlcNature(Integer.parseInt(((Racines)this.lesRacinesCompletes.get(var11)).getRacCodenature()));
                     this.planComptable.setPlcLibelleNatureFR(((Racines)this.lesRacinesCompletes.get(var11)).getLib_nature());
                     this.planComptable.setPlcLibelleNatureSP(((Racines)this.lesRacinesCompletes.get(var11)).getLib_nature());
                     this.planComptable.setPlcLibelleNatureUK(((Racines)this.lesRacinesCompletes.get(var11)).getLib_nature());
                     this.planComptable.setPlcLibelleRacineFR(((Racines)this.lesRacinesCompletes.get(var11)).getRacLibelleFr());
                     this.planComptable.setPlcLibelleRacineSP(((Racines)this.lesRacinesCompletes.get(var11)).getRacLibelleSp());
                     this.planComptable.setPlcLibelleRacineUK(((Racines)this.lesRacinesCompletes.get(var11)).getRacLibelleUk());
                     this.planComptable = this.planComptableDao.modif(this.planComptable, var1);
                     break;
                  }
               }
            }

            var2.commit();
         } catch (HibernateException var8) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var8;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      if (this.exoSelect == null) {
         this.afficheAjout = false;
      } else if (this.exoSelect.getExecptEtat() != 0) {
         this.afficheAjout = false;
      } else {
         this.chargerPlanComtable(1, (Session)null);
         this.afficheAjout = true;
      }

   }

   public void chargerTousComptes(Session var1) throws HibernateException, NamingException {
      this.maListe.clear();
      String var2 = this.getNatureFiscale();
      if (var2.equalsIgnoreCase("0")) {
         this.filtre = "Tous les comptes";
         this.maListe = this.planComptableDao.chargerPlanComtableGene(this.selecFiscalite, this.annee, var1);
      } else {
         this.filtre = "Tous les comptes: " + this.natureFiscale;
         this.maListe = this.planComptableDao.chargerPlanComtableNature(this.selecFiscalite, this.annee, var2, var1);
      }

      this.madatamodel.setWrappedData(this.maListe);
   }

   public void chargerPcMouvementes(Session var1) throws HibernateException, NamingException {
      this.maListe.clear();
      String var2 = this.getNatureFiscale();
      if (var2.equalsIgnoreCase("0")) {
         this.filtre = "Tous les comptes mouvementés";
         this.maListe = this.planComptableDao.chargerPcMvmtes(this.selecFiscalite, this.annee, var1);
      } else {
         this.filtre = "Tous les comptes mouvementés: " + this.natureFiscale;
         this.maListe = this.planComptableDao.chargerNatueFiscMvmtes(this.selecFiscalite, this.annee, var2, var1);
      }

      this.madatamodel.setWrappedData(this.maListe);
   }

   public void chargerPcNonMouvementes(Session var1) throws HibernateException, NamingException {
      this.maListe.clear();
      String var2 = this.getNatureFiscale();
      if (var2.equalsIgnoreCase("0")) {
         this.filtre = "Tous les comptes non mouvementés";
         this.maListe = this.planComptableDao.chargerPcNonMvmtes(this.selecFiscalite, this.annee, var1);
      } else {
         this.filtre = "Tous les comptes non mouvementés: " + this.natureFiscale;
         this.maListe = this.planComptableDao.chargerNatueFiscNonMvmtes(this.selecFiscalite, this.annee, var2, var1);
      }

      this.madatamodel.setWrappedData(this.maListe);
   }

   public void chargerTousComptesAnalytiques(Session var1) throws HibernateException, NamingException {
      this.maListe.clear();
      String var2 = this.getNatureFiscale();
      if (var2.equalsIgnoreCase("0")) {
         this.filtre = "Tous les comptes avec imputation analytique";
         this.maListe = this.planComptableDao.chargerPlanComtableAnalytique(this.selecFiscalite, this.annee, var1);
      } else {
         this.filtre = "Tous les comptes avec imputation analytique: " + this.natureFiscale;
         this.maListe = this.planComptableDao.chargerPlanComtableAnalytique(this.selecFiscalite, this.annee, var2, var1);
      }

      this.madatamodel.setWrappedData(this.maListe);
   }

   public void chargerTousComptesSage(Session var1) throws HibernateException, NamingException {
      this.maListe.clear();
      new ArrayList();
      String var3 = this.getNatureFiscale();
      List var2;
      int var4;
      if (var3.equalsIgnoreCase("0")) {
         this.filtre = "Tous les comptes (SAGE)";
         var2 = this.planComptableDao.chargerPlanComtableGene(this.selecFiscalite, this.annee, var1);
         if (var2.size() != 0) {
            for(var4 = 0; var4 < var2.size(); ++var4) {
               if (((PlanComptable)var2.get(var4)).getPlcSage() != null && !((PlanComptable)var2.get(var4)).getPlcSage().isEmpty()) {
                  this.maListe.add(var2.get(var4));
               }
            }
         }
      } else {
         this.filtre = "Tous les comptes (SAGE): " + this.natureFiscale;
         var2 = this.planComptableDao.chargerPlanComtableNature(this.selecFiscalite, this.annee, var3, var1);
         if (var2.size() != 0) {
            for(var4 = 0; var4 < var2.size(); ++var4) {
               if (((PlanComptable)var2.get(var4)).getPlcSage() != null && !((PlanComptable)var2.get(var4)).getPlcSage().isEmpty()) {
                  this.maListe.add(var2.get(var4));
               }
            }
         }
      }

      this.madatamodel.setWrappedData(this.maListe);
   }

   public void chargerTousComptesSYSCOHADA(Session var1) throws HibernateException, NamingException {
      this.maListe.clear();
      new ArrayList();
      String var3 = this.getNatureFiscale();
      List var2;
      int var4;
      if (var3.equalsIgnoreCase("0")) {
         this.filtre = "Tous les comptes (SYSCOHADA)";
         var2 = this.planComptableDao.chargerPlanComtableGene(this.selecFiscalite, this.annee, var1);
         if (var2.size() != 0) {
            for(var4 = 0; var4 < var2.size(); ++var4) {
               if (((PlanComptable)var2.get(var4)).getPlcCompteSyscohada() != null && !((PlanComptable)var2.get(var4)).getPlcCompteSyscohada().isEmpty()) {
                  this.maListe.add(var2.get(var4));
               }
            }
         }
      } else {
         this.filtre = "Tous les comptes (SYSCOHADA): " + this.natureFiscale;
         var2 = this.planComptableDao.chargerPlanComtableNature(this.selecFiscalite, this.annee, var3, var1);
         if (var2.size() != 0) {
            for(var4 = 0; var4 < var2.size(); ++var4) {
               if (((PlanComptable)var2.get(var4)).getPlcCompteSyscohada() != null && !((PlanComptable)var2.get(var4)).getPlcCompteSyscohada().isEmpty()) {
                  this.maListe.add(var2.get(var4));
               }
            }
         }
      }

      this.madatamodel.setWrappedData(this.maListe);
   }

   public void chargerTousComptesAutreFiscalite(Session var1) throws HibernateException, NamingException {
      this.maListe.clear();
      new ArrayList();
      String var3 = this.getNatureFiscale();
      List var2;
      int var4;
      if (var3.equalsIgnoreCase("0")) {
         this.filtre = "Tous les comptes (autre fiscalité)";
         var2 = this.planComptableDao.chargerPlanComtableGene(this.selecFiscalite, this.annee, var1);
         if (var2.size() != 0) {
            for(var4 = 0; var4 < var2.size(); ++var4) {
               if (((PlanComptable)var2.get(var4)).getPlcCompteAutre() != null && !((PlanComptable)var2.get(var4)).getPlcCompteAutre().isEmpty()) {
                  this.maListe.add(var2.get(var4));
               }
            }
         }
      } else {
         this.filtre = "Tous les comptes (autre fiscalité): " + this.natureFiscale;
         var2 = this.planComptableDao.chargerPlanComtableNature(this.selecFiscalite, this.annee, var3, var1);
         if (var2.size() != 0) {
            for(var4 = 0; var4 < var2.size(); ++var4) {
               if (((PlanComptable)var2.get(var4)).getPlcCompteAutre() != null && !((PlanComptable)var2.get(var4)).getPlcCompteAutre().isEmpty()) {
                  this.maListe.add(var2.get(var4));
               }
            }
         }
      }

      this.madatamodel.setWrappedData(this.maListe);
   }

   public void chargerComptesnonConvertis(Session var1) throws HibernateException, NamingException {
      this.maListe.clear();
      this.filtre = "Comptes non convertis";
      if (this.structureLog.getStrzonefiscale() != null && !this.structureLog.getStrzonefiscale().isEmpty() && this.structureLog.getStrdatefiscale2() != null) {
         this.maListe = this.planComptableDao.chargerPlanComtableGene(this.structureLog.getStrzonefiscale(), (long)(this.structureLog.getStrdatefiscale2().getYear() + 1900), var1);
      }

      this.madatamodel.setWrappedData(this.maListe);
   }

   public void chargerLesCles(Session var1) throws HibernateException, NamingException {
      this.mesClesAnalytiques.clear();
      PlansAnalytiquesDao var2 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      this.mesClesAnalytiques = var2.chargerLesAnalytiques("9", var1);
   }

   public void defaultAdd() throws JDOMException, IOException, HibernateException, NamingException {
      this.planComptableDao.ajoutParDefaut(this.selecFiscalite, this.nombrCaracter, this.exoSelect);
      this.chargerPlanComtable(0, (Session)null);
      this.afficheAjDefaut = false;
   }

   public void ajoutCompte() throws JDOMException, IOException {
      this.naturFiscalItem.indexOf(0);
      this.racinesItems = new ArrayList();
      this.intituleNat = "";
      this.intituleRac = "";
      this.complNum = "";
      this.oneMenuModif = false;
      this.existeCopteDeja = true;
      this.affichRan = false;
      this.affichTauxTaxe = false;
      this.planComptable = new PlanComptable();
      this.racines = new Racines();
      this.var_affPanelCompte = true;
   }

   public void selectionLigne() throws HibernateException, NamingException, IOException {
      if (this.madatamodel.isRowAvailable()) {
         this.planComptable = (PlanComptable)this.madatamodel.getRowData();
         this.inactif = this.recupererInactifModif();
         this.afficheButtSup = this.verifMouvment();
         this.intituleNat = this.planComptable.getPlcNature() + ":" + this.planComptable.getPlcLibelleNatureFR();
         this.intituleRac = this.planComptable.getPlcCodeRacine() + ":" + this.planComptable.getPlcLibelleRacineFR();
         this.codRacine = this.planComptable.getPlcCodeRacine();
         int var1 = this.planComptable.getPlcInactif();
         if (this.exoSelect.getExecptEtat() == 0 && var1 == 0) {
            this.afficheButtMod = true;
         } else {
            this.afficheButtMod = false;
         }
      }

      this.var_affPanelCompte = false;
   }

   public void modifCompte() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.planComptable != null) {
         this.oneMenuModif = true;
         String var1 = this.planComptable.getPlcCompte();
         int var2 = this.planComptable.getPlcCodeRacine().length();
         this.complNum = this.planComptable.getPlcCompte().substring(var2);
         this.existeCopteDeja = false;
         this.vhlibre = false;
         if (this.planComptable.getPlcNature() != 6 && this.planComptable.getPlcNature() != 7 && this.planComptable.getPlcNature() != 8 && this.planComptable.getPlcNature() != 9 && this.planComptable.getPlcNature() != 13 && this.planComptable.getPlcNature() != 14 && this.planComptable.getPlcNature() != 15) {
            this.affichRan = false;
         } else {
            this.affichRan = true;
         }

         if (this.planComptable.getPlcNature() != 3 && this.planComptable.getPlcNature() != 13 && this.planComptable.getPlcNature() != 14 && this.planComptable.getPlcNature() != 15) {
            this.affichTauxTaxe = false;
         } else {
            this.affichTauxTaxe = true;
         }

         this.var_affPanelCompte = true;
         this.chargerRacines("" + this.planComptable.getPlcNature());
      }

   }

   public void removeSelectedPlanComptable() throws HibernateException, NamingException {
      if (this.planComptable != null) {
         this.planComptable.setPlcInactif(2);
         this.planComptable = this.planComptableDao.modif(this.planComptable);
      }

   }

   public void removeNonMouvementePlanComptable() throws HibernateException, NamingException {
      if (this.maListe.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlanComptable");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            boolean var3 = false;
            boolean var4 = false;

            for(int var5 = 0; var5 < this.maListe.size(); ++var5) {
               this.planComptable = (PlanComptable)this.maListe.get(var5);
               if (this.planComptable.getPlcInactif() != 2) {
                  var3 = false;
                  var4 = false;
                  var3 = this.ecrituresDao.verifMouvment(this.planComptable.getPlcCompte(), this.annee, var1);
                  var4 = this.amortissementsDao.verifMouvment(this.planComptable.getPlcCompte(), var1);
                  if (var3 && var4) {
                     this.planComptable.setPlcInactif(2);
                     this.planComptable = this.planComptableDao.modif(this.planComptable, var1);
                  }
               }
            }

            this.madatamodel.setWrappedData(this.maListe);
            var2.commit();
         } catch (HibernateException var9) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var9;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void reactivePlanComptable() throws HibernateException, NamingException {
      if (this.maListe.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlanComptable");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.maListe.size(); ++var3) {
               this.planComptable = (PlanComptable)this.maListe.get(var3);
               if (this.planComptable.getPlcInactif() == 2) {
                  this.planComptable.setPlcInactif(0);
                  this.planComptable = this.planComptableDao.modif(this.planComptable, var1);
               }
            }

            this.madatamodel.setWrappedData(this.maListe);
            var2.commit();
         } catch (HibernateException var7) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var7;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void recuperNatureFiscal() throws IOException, HibernateException, NamingException {
      this.affichRan = false;
      this.affichTauxTaxe = false;
      this.intituleRac = "";
      this.complNum = "";
      this.racines = new Racines();
      this.planComptable = new PlanComptable();
      this.intituleNat = this.getIntituleNat();
      if (this.intituleNat.contains(":")) {
         String[] var1 = this.intituleNat.split(":");
         String var2 = var1[0];
         if (this.lesNaturesFiscale.size() != 0) {
            for(int var3 = 0; var3 < this.lesNaturesFiscale.size(); ++var3) {
               new ObjetCompte();
               ObjetCompte var4 = (ObjetCompte)this.lesNaturesFiscale.get(var3);
               if (var4.getCode().contentEquals(var2)) {
                  this.planComptable.setPlcNature(Integer.parseInt(var4.getCode()));
                  this.planComptable.setPlcLibelleNatureFR(var4.getNom_FR());
                  this.planComptable.setPlcLibelleNatureSP(var4.getNom_SP());
                  this.planComptable.setPlcLibelleNatureUK(var4.getNom_SP());
                  this.planComptable.setPlcSens(Integer.parseInt(var4.getSens()));
                  if (this.planComptable.getPlcNature() != 6 && this.planComptable.getPlcNature() != 7 && this.planComptable.getPlcNature() != 8 && this.planComptable.getPlcNature() != 9 && this.planComptable.getPlcNature() != 13 && this.planComptable.getPlcNature() != 14 && this.planComptable.getPlcNature() != 15) {
                     this.affichRan = false;
                     this.planComptable.setPlcRanDetaille(false);
                  } else {
                     this.affichRan = true;
                     this.planComptable.setPlcRanDetaille(true);
                  }

                  if (this.planComptable.getPlcNature() != 3 && this.planComptable.getPlcNature() != 13 && this.planComptable.getPlcNature() != 14 && this.planComptable.getPlcNature() != 15) {
                     this.affichTauxTaxe = false;
                     break;
                  }

                  this.affichTauxTaxe = true;
                  break;
               }
            }

            this.chargerRacines(var2);
         }
      }

   }

   public void recuperRacine() throws IOException, HibernateException, NamingException {
      this.nbcarmax = 0;
      this.complNum = "";
      this.intituleRac = this.getIntituleRac();
      if (this.intituleRac.contains(":")) {
         String[] var1 = this.intituleRac.split(":");
         String var2 = var1[0];
         RacinesDao var3 = new RacinesDao(this.baseLog, this.structureLog, this.utilInitHibernate);
         this.racines = new Racines();
         this.racines = var3.rechercherCodeRacine(this.selecFiscalite, var2, (Session)null);
         if (this.racines != null) {
            this.planComptable.setPlcCodeRacine(var2);
            this.planComptable.setPlcLibelleRacineFR(this.racines.getRacLibelleFr());
            this.planComptable.setPlcLibelleRacineSP(this.racines.getRacLibelleSp());
            this.planComptable.setPlcLibelleRacineUK(this.racines.getRacLibelleSp());
            if (this.racines.getRacUtil().equalsIgnoreCase("1")) {
               this.vhlibre = false;
               this.existeCopteDeja = true;
               if (this.affichTauxTaxe) {
                  this.planComptable.setPlcTauxTaxe(this.racines.getRactaux());
               } else {
                  this.planComptable.setPlcTauxTaxe(0.0F);
               }

               this.planComptable.setPlcLibelleCpteFR(this.racines.getRacLibelleFr());
               this.planComptable.setPlcLibelleCpteSP(this.racines.getRacLibelleSp());
               this.planComptable.setPlcLibelleCpteUK(this.racines.getRacLibelleUk());
               this.complNum = "" + this.calculeProchainNum(this.racines.getRacCode());
               this.complNum = this.getComplementutil(this.complNum, this.racines.getRacCode());
               this.planComptable.setPlcCompte(this.racines.getRacCode().concat(this.complNum));
               this.compteExiste(this.planComptable.getPlcCompte());
               int var4 = var2.length();
               this.nbcarmax = this.nombrCaracter - var4;
            } else {
               this.vhlibre = true;
               this.existeCopteDeja = true;
            }
         }
      }

   }

   public boolean compteExiste(String var1) throws HibernateException, NamingException {
      this.existeCopteDeja = true;
      if (var1 != null && !var1.isEmpty()) {
         this.existeCopteDeja = this.planComptableDao.existeCompte(this.selecFiscalite, var1, this.exoSelect.getExecpt_id(), (Session)null);
      }

      return this.existeCopteDeja;
   }

   public String recupererNumero() throws HibernateException, NamingException {
      String var1 = this.racines.getRacCode();
      int var2 = var1.length();
      int var3 = this.getComplNum().length();
      String var4;
      if (this.nombrCaracter <= var2 + var3) {
         this.complNum = this.getComplNum().substring(0, this.nombrCaracter - var2);
      } else {
         var4 = "";
         int var5 = this.nombrCaracter - (var2 + var3);
         if (var5 > 0) {
            String[] var6 = new String[var5];

            for(int var7 = 0; var7 < var5; ++var7) {
               var6[var7] = "0";
               var4 = var4.concat(var6[var7]);
            }
         } else {
            var4 = "";
         }

         this.complNum = this.complNum.concat(var4);
      }

      var4 = var1.concat(this.complNum);
      this.existeCopteDeja = this.compteExiste(var4);
      if (!this.existeCopteDeja) {
         this.planComptable.setPlcCompte(var1.concat(this.complNum).toUpperCase());
      }

      return var1;
   }

   public String getComplementutil(String var1, String var2) {
      String var3 = var2.concat(var1);
      int var4 = this.nombrCaracter - var3.length();
      String var5 = "";
      String[] var6 = new String[var4];

      for(int var7 = 0; var7 < var4; ++var7) {
         var6[var7] = "0";
         var5 = var5 + var6[var7];
      }

      var5 = var5 + var1;
      return var5;
   }

   public int calculeProchainNum(String var1) throws HibernateException, NamingException, IOException {
      new OptionComptabilite();
      LireLesoptionsCompta var3 = new LireLesoptionsCompta(this.structureLog);
      var3.setStrId(this.structureLog.getStrid());
      var3.lancer();
      OptionComptabilite var2 = var3.getOptionComptabilite();
      int var4 = Integer.parseInt(var2.getNbcr());
      int var5 = 0;
      if (var2.getCalculCompte().equals("0")) {
         var5 = this.planComptableDao.calculeNbCompte(this.selecFiscalite, var1, this.exoSelect.getExecpt_id(), (Session)null) + 1;
      } else if (var2.getCalculCompte().equals("1")) {
         new ArrayList();
         List var6 = this.planComptableDao.chargeNumCpte(this.selecFiscalite, var1, this.exoSelect.getExecpt_id(), 0, (String)null, (Session)null);
         if (var6.size() != 0) {
            int var7 = var6.size() - 1;
            String var8 = ((PlanComptable)var6.get(var7)).getPlcCompte();
            String var9 = var8.substring(var1.length(), var4);
            if (this.estUnEntier(var9)) {
               var5 = Integer.parseInt(var9) + 1;
            } else {
               var5 = this.planComptableDao.calculeNbCompte(this.selecFiscalite, var1, this.exoSelect.getExecpt_id(), (Session)null) + 1;
            }
         }
      }

      return var5;
   }

   public boolean estUnEntier(String var1) {
      try {
         Integer.parseInt(var1);
         return true;
      } catch (NumberFormatException var3) {
         return false;
      }
   }

   public boolean recupererInactifModif() {
      return this.planComptable.getPlcInactif() != 0;
   }

   public boolean verifMouvment() throws HibernateException, NamingException {
      Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlanComptable");
      boolean var2 = this.ecrituresDao.verifMouvment(this.planComptable.getPlcCompte(), this.annee, var4);
      boolean var3 = this.amortissementsDao.verifMouvment(this.planComptable.getPlcCompte(), var4);
      this.utilInitHibernate.closeSession();
      boolean var1;
      if (var2 && var3 && this.planComptable.getPlcInactif() != 2) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public void reactiverCompte() throws HibernateException, NamingException, IOException {
      if (this.planComptable == null) {
         this.selectionLigne();
      }

      if (this.planComptable != null) {
         this.planComptable.setPlcInactif(0);
         this.planComptable = this.planComptableDao.modif(this.planComptable);
      }

   }

   public int getCompteDesactiveModif() {
      if (!this.inactif) {
         this.compteDesactiveModif = 0;
      } else {
         this.compteDesactiveModif = 1;
      }

      return this.compteDesactiveModif;
   }

   public void valider() throws HibernateException, NamingException {
      if (this.planComptable.getPlcId() == 0L) {
         this.planComptable.setPlcDateCreat(new Date());
         this.planComptable.setPlcUserCreat(this.usersLog.getUsrid());
         this.planComptable.setExercicesComptable(this.exoSelect);
         this.planComptable.setPlcFiscalite(this.selecFiscalite);
         this.planComptable = this.planComptableDao.insert(this.planComptable);
         this.maListe.add(this.planComptable);
         this.madatamodel.setWrappedData(this.maListe);
         if (this.planComptable.getPlcNature() == 6 || this.planComptable.getPlcNature() == 7) {
            Tiers var1 = new Tiers();
            TiersDao var2 = new TiersDao(this.baseLog, this.utilInitHibernate);
            var1.setTieraisonsocialenom(this.planComptable.getPlcLibelleCpteFR().toUpperCase());
            var1.setTiecompte0(this.planComptable.getPlcCompte());
            if (this.planComptable.getPlcNature() == 6) {
               var1.setTietype("0");
               var1.setTiegenre("001");
               var1.setTiecategorie("Fournisseur");
            } else if (this.planComptable.getPlcNature() == 7) {
               var1.setTietype("3");
               var1.setTiegenre("031");
               var1.setTiecategorie("Client société");
            }

            var1.setTiecodepays(this.structureLog.getStrcodepays());
            var1.setTiedevise(this.structureLog.getStrdevise());
            var1.setTieFormatDevise(this.structureLog.getStrformatdevise());
            if (var1.getTieid() == 0L) {
               var1.setTiedatecreat(new Date());
               var1.setTieusercreat(this.usersLog.getUsrid());
               var2.insert(var1);
            } else {
               var1.setTiedatemodif(new Date());
               var1.setTieusermodif(this.usersLog.getUsrid());
               var2.modif(var1);
            }
         }
      } else {
         this.planComptable.setPlcInactif(this.getCompteDesactiveModif());
         this.planComptable.setPlcFiscalite(this.selecFiscalite);
         this.planComptable = this.planComptableDao.modif(this.planComptable);
      }

      this.var_affPanelCompte = false;
   }

   public PlanComptable creationAuto(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException, IOException {
      String var5 = "0";
      if (var2 != null && !var2.isEmpty()) {
         if (var2.startsWith("40")) {
            var5 = "6";
         } else if (var2.startsWith("41")) {
            var5 = "7";
         }
      }

      new Racines();
      Racines var6 = this.rechercheRacine(var1, var2, var4);
      if (var6 != null) {
         this.exoLast = this.exercicesComptableDao.recupererLastExo(var4);
         boolean var7 = false;
         new ArrayList();
         List var8 = this.planComptableDao.chargerlesNumCpte(var1, var5, this.exoLast.getExecpt_id(), var4);
         int var12;
         if (var8.size() != 0) {
            var12 = var8.size() + 1;
         } else {
            var12 = 1;
         }

         String var9 = this.verificationLgCompte(var2.substring(0, var2.length() - 1) + var12);
         this.planComptable = new PlanComptable();
         this.planComptable = this.planComptableDao.chercherCompte(var1, var9, this.exoLast.getExecpt_id(), var4);
         if (this.planComptable == null) {
            PlanComptable var10 = new PlanComptable();
            var10.setExercicesComptable(this.exoLast);
            var10.setPlcCompte(var9);
            var10.setPlcFiscalite(var1);
            var10.setPlcCodeRacine(var6.getRacCode());
            var10.setPlcLibelleRacineFR(var6.getRacLibelleFr());
            var10.setPlcLibelleRacineSP(var6.getRacLibelleSp());
            var10.setPlcLibelleRacineUK(var6.getRacLibelleUk());
            if (var6.getRacCodenature() == null || var6.getRacCodenature().isEmpty()) {
               var6.setRacCodenature("0");
            }

            int var11 = Integer.parseInt(var6.getRacCodenature());
            var10.setPlcNature(var11);
            var10.setPlcLibelleNatureFR(var6.getRacnature());
            var10.setPlcLibre(this.calculPlcLibre(var9, var6.getRacCode()));
            if (var3 != null && !var3.isEmpty()) {
               var10.setPlcLibelleCpteFR(var3);
               var10.setPlcLibelleCpteSP(var3);
               var10.setPlcLibelleCpteUK(var3);
            } else {
               var10.setPlcLibelleCpteFR("compte à creer");
               var10.setPlcLibelleCpteSP("compte à creer");
               var10.setPlcLibelleCpteUK("compte à creer");
            }

            var10.setPlcUserCreat(this.usersLog.getUsrid());
            var10.setPlcDateCreat(new Date());
            this.planComptable = this.planComptableDao.insert(var10, var4);
         }
      } else {
         this.planComptable = null;
      }

      return this.planComptable;
   }

   public Racines rechercheRacine(String var1, String var2, Session var3) throws HibernateException, NamingException {
      Racines var4 = new Racines();
      if (var2 != null && !var2.isEmpty()) {
         int var5 = var2.length();
         String var6 = "";
         int var7 = 0;

         for(int var8 = var5; var8 != 1; --var8) {
            ++var7;
            var6 = var2.substring(0, var5 - var7);
            var4 = this.racinesDao.rechercherCodeRacine(var1, var6, var3);
            if (var4 != null) {
               break;
            }
         }

         if (var4 == null) {
            var4 = new Racines();
            var4.setRacCode("99999");
            var4.setRacLibelleFr("Racine Inconnue");
            var4.setRacLibelleSp("Unknown root");
            var4.setRacLibelleSp("Racina incognita");
         }
      } else {
         var4 = null;
      }

      return var4;
   }

   public String calculPlcLibre(String var1, String var2) {
      String var3 = null;
      if (var2 != null && !var2.isEmpty()) {
         int var4 = var2.length();
         var3 = var1.substring(var4);
      } else {
         var3 = var1;
      }

      return var3;
   }

   public String verificationLgCompte(String var1) throws IOException {
      LireLesoptionsCompta var2 = new LireLesoptionsCompta(this.structureLog);
      var2.setStrId(this.structureLog.getStrid());
      var2.lancer();
      int var3 = Integer.parseInt(var2.getOptionComptabilite().getNbcr()) - var1.length();
      String var4 = var1;
      if (var3 == 1) {
         var4 = var1 + "0";
      } else if (var3 == 2) {
         var4 = var1 + "00";
      } else if (var3 == 3) {
         var4 = var1 + "000";
      } else if (var3 == 4) {
         var4 = var1 + "0000";
      } else if (var3 == 5) {
         var4 = var1 + "00000";
      } else if (var3 == 6) {
         var4 = var1 + "000000";
      } else if (var3 == 7) {
         var4 = var1 + "0000000";
      } else if (var3 == 8) {
         var4 = var1 + "00000000";
      } else if (var3 == 9) {
         var4 = var1 + "000000000";
      } else if (var3 == 10) {
         var4 = var1 + "0000000000";
      } else if (var3 == 11) {
         var4 = var1 + "00000000000";
      } else if (var3 == 12) {
         var4 = var1 + "000000000000";
      } else if (var3 == 13) {
         var4 = var1 + "0000000000000";
      } else if (var3 == 14) {
         var4 = var1 + "00000000000000";
      } else if (var3 == 15) {
         var4 = var1 + "000000000000000";
      } else if (var3 == 16) {
         var4 = var1 + "0000000000000000";
      } else if (var3 == 17) {
         var4 = var1 + "00000000000000000";
      } else if (var3 == 18) {
         var4 = var1 + "000000000000000000";
      } else if (var3 == 19) {
         var4 = var1 + "0000000000000000000";
      }

      return var4;
   }

   public void exportXML() {
      new SAXBuilder();

      try {
         File var2 = File.createTempFile("test", ".xml");
         String var3 = var2.getAbsolutePath();
         this.racine = new Element("planComptable");
         this.document = new Document(this.racine);
         new PlanComptable();

         for(int var5 = 0; var5 < this.maListe.size(); ++var5) {
            PlanComptable var4 = (PlanComptable)this.maListe.get(var5);
            Element var6 = new Element("compte");
            Element var7 = new Element("code");
            var6.addContent(var7);
            var7.setText(var4.getPlcCompte());
            Element var8 = new Element("lib_FR");
            var6.addContent(var8);
            var8.setText("" + var4.getPlcLibelleCpteFR());
            Element var9 = new Element("lib_UK");
            var6.addContent(var9);
            var9.setText(var4.getPlcLibelleCpteUK());
            Element var10 = new Element("lib_SP");
            var6.addContent(var10);
            var10.setText(var4.getPlcLibelleCpteSP());
            Element var11 = new Element("nature");
            var6.addContent(var11);
            var11.setText("" + var4.getPlcNature());
            Element var12 = new Element("ran");
            var6.addContent(var12);
            if (var4.getPlcNature() != 6 && var4.getPlcNature() != 7) {
               var12.setText("0");
            } else {
               var12.setText("1");
            }

            Element var13 = new Element("racine");
            var6.addContent(var13);
            var13.setText("" + var4.getPlcCodeRacine());
            Element var14 = new Element("libre");
            var6.addContent(var14);
            var14.setText("" + var4.getPlcLibre());
            Element var15 = new Element("sens");
            var6.addContent(var15);
            var15.setText("" + var4.getPlcSens());
            Element var16 = new Element("lib_nat");
            var6.addContent(var16);
            var16.setText("" + var4.getPlcLibelleNatureFR());
            this.racine.addContent(var6);
         }

         this.enregistre(var2);
      } catch (Exception var17) {
      }

   }

   public void enregistre(File var1) {
      try {
         XMLOutputter var2 = new XMLOutputter(Format.getPrettyFormat());
         FileOutputStream var3 = new FileOutputStream(var1);
         var2.output(this.document, var3);
         var3.close();
      } catch (IOException var4) {
      }

   }

   public void fusionnerPlanComptable() throws HibernateException, NamingException {
      if (this.structureLog.getStrzonefiscale2() != null && !this.structureLog.getStrzonefiscale2().isEmpty() && this.structureLog.getStrdatefiscale2() != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlanComptable");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            new ArrayList();
            List var3 = this.racinesDao.chargerMesRacines(this.structureLog.getStrzonefiscale2(), var1);
            new ArrayList();
            List var4 = this.planComptableDao.chargerLesPlanComptables(this.structureLog.getStrzonefiscale2(), this.exoLast.getExecpt_id(), var1);
            new ArrayList();
            List var5 = this.planComptableDao.chargerLesPlanComptables(this.structureLog.getStrzonefiscale(), this.exoLast.getExecpt_id(), var1);
            if (var3.size() != 0 && var5.size() != 0) {
               new PlanComptable();
               PlanComptable var7 = new PlanComptable();
               Racines var8 = new Racines();

               for(int var9 = 0; var9 < var5.size(); ++var9) {
                  PlanComptable var6 = (PlanComptable)var5.get(var9);
                  boolean var10 = false;

                  for(int var11 = 0; var11 < var4.size(); ++var11) {
                     var7 = (PlanComptable)var4.get(var11);
                     if (var6.getPlcCompte().equals(var7.getPlcCompte())) {
                        var10 = true;
                        break;
                     }
                  }

                  if (var10) {
                     if (var7 != null) {
                        var7.setPlcDateModif(new Date());
                        var7.setPlcLibelleCpteFR(var6.getPlcLibelleCpteFR());
                        var7.setPlcLibelleCpteSP(var6.getPlcLibelleCpteSP());
                        var7.setPlcLibelleCpteUK(var6.getPlcLibelleCpteUK());
                        var7.setPlcLibelleNatureFR(var6.getPlcLibelleNatureFR());
                        var7.setPlcLibelleNatureSP(var6.getPlcLibelleNatureSP());
                        var7.setPlcLibelleNatureUK(var6.getPlcLibelleNatureUK());
                        var7.setPlcLibelleRacineFR(var6.getPlcLibelleRacineFR());
                        var7.setPlcLibelleRacineSP(var6.getPlcLibelleRacineSP());
                        var7.setPlcLibelleRacineUK(var6.getPlcLibelleRacineUK());
                        var7.setPlcFiscalite(this.structureLog.getStrzonefiscale2());
                        var7.setPlcUserModif(this.usersLog.getUsrid());
                        var7 = this.planComptableDao.modif(var7, var1);
                     }
                  } else {
                     boolean var18 = false;

                     for(int var12 = 0; var12 < var3.size(); ++var12) {
                        var8 = (Racines)var3.get(var12);
                        if (var6.getPlcCodeRacine().equals(var8.getRacCode()) && var8.getRacUtil().equals("1")) {
                           var18 = true;
                           break;
                        }
                     }

                     if (var18 && var6.getPlcCompte().startsWith(var8.getRacCode())) {
                        var7 = new PlanComptable();
                        var7.setExercicesComptable(this.exoLast);
                        var7.setPlcAnalCle1(var6.getPlcAnalCle1());
                        var7.setPlcAnalCle2(var6.getPlcAnalCle2());
                        var7.setPlcCodeRacine(var6.getPlcCodeRacine());
                        var7.setPlcCompte(var6.getPlcCompte());
                        var7.setPlcDateCreat(new Date());
                        var7.setPlcDateModif((Date)null);
                        var7.setPlcFiscalite(this.structureLog.getStrzonefiscale2());
                        var7.setPlcInactif(var6.getPlcInactif());
                        var7.setPlcLibelleCpteFR(var6.getPlcLibelleCpteFR());
                        var7.setPlcLibelleCpteSP(var6.getPlcLibelleCpteSP());
                        var7.setPlcLibelleCpteUK(var6.getPlcLibelleCpteUK());
                        var7.setPlcLibelleNatureFR(var6.getPlcLibelleNatureFR());
                        var7.setPlcLibelleNatureSP(var6.getPlcLibelleNatureSP());
                        var7.setPlcLibelleNatureUK(var6.getPlcLibelleNatureUK());
                        var7.setPlcLibelleRacineFR(var6.getPlcLibelleRacineFR());
                        var7.setPlcLibelleRacineSP(var6.getPlcLibelleRacineSP());
                        var7.setPlcLibelleRacineUK(var6.getPlcLibelleRacineUK());
                        var7.setPlcLibre(var6.getPlcLibre());
                        var7.setPlcNature(var6.getPlcNature());
                        var7.setPlcRanDetaille(var6.isPlcRanDetaille());
                        var7.setPlcSage(var6.getPlcSage());
                        var7.setPlcSens(var6.getPlcSens());
                        var7.setPlcTauxTaxe(var6.getPlcTauxTaxe());
                        var7.setPlcUserCreat(this.usersLog.getUsrid());
                        var7.setPlcUserModif(0L);
                        var7 = this.planComptableDao.insert(var7, var1);
                     }
                  }
               }
            }

            var2.commit();
         } catch (HibernateException var16) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var16;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void transformerPlanComptable() throws HibernateException, NamingException, IOException {
      if (this.structureLog.getStrzonefiscale2() != null && !this.structureLog.getStrzonefiscale2().isEmpty() && this.structureLog.getStrdatefiscale2() != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            new ArrayList();
            List var3 = this.racinesDao.chargerMesRacines(this.structureLog.getStrzonefiscale2(), var1);
            new ArrayList();
            List var4 = this.planComptableDao.chargerLesPlanComptables(this.structureLog.getStrzonefiscale2(), this.exoLast.getExecpt_id(), var1);
            new ArrayList();
            List var5 = this.planComptableDao.chargerLesPlanComptables(this.structureLog.getStrzonefiscale(), this.exoLast.getExecpt_id(), var1);
            if (var3.size() != 0 && var5.size() != 0) {
               new PlanComptable();
               PlanComptable var7 = new PlanComptable();
               Racines var8 = new Racines();

               for(int var9 = 0; var9 < var5.size(); ++var9) {
                  PlanComptable var6 = (PlanComptable)var5.get(var9);
                  String var10 = "";
                  String var11 = "";
                  String var12 = "";
                  if (var6.getPlcCodeRacine() != null && !var6.getPlcCodeRacine().isEmpty()) {
                     var12 = var6.getPlcCodeRacine();
                  }

                  if (var6.getPlcCompteSyscohada() != null && !var6.getPlcCompteSyscohada().isEmpty()) {
                     var10 = var6.getPlcCompte();
                     var11 = this.verificationLgCompte(var6.getPlcCompteSyscohada());
                  } else {
                     var10 = var6.getPlcCompte();
                     var11 = var6.getPlcCompte();
                  }

                  boolean var13;
                  if (var10 != null && !var10.isEmpty() && var11 != null && !var11.isEmpty() && var12 != null && !var12.isEmpty()) {
                     var13 = false;

                     for(int var14 = 0; var14 < var4.size(); ++var14) {
                        var7 = (PlanComptable)var4.get(var14);
                        if (var11.equals(var7.getPlcCompte())) {
                           var13 = true;
                           break;
                        }
                     }

                     if (var13) {
                        if (var7 != null) {
                           var7.setPlcDateModif(new Date());
                           var7.setPlcLibelleCpteFR(var6.getPlcLibelleCpteFR());
                           var7.setPlcLibelleCpteSP(var6.getPlcLibelleCpteSP());
                           var7.setPlcLibelleCpteUK(var6.getPlcLibelleCpteUK());
                           var7.setPlcLibelleNatureFR(var6.getPlcLibelleNatureFR());
                           var7.setPlcLibelleNatureSP(var6.getPlcLibelleNatureSP());
                           var7.setPlcLibelleNatureUK(var6.getPlcLibelleNatureUK());
                           var7.setPlcLibelleRacineFR(var6.getPlcLibelleRacineFR());
                           var7.setPlcLibelleRacineSP(var6.getPlcLibelleRacineSP());
                           var7.setPlcLibelleRacineUK(var6.getPlcLibelleRacineUK());
                           var7.setPlcCompteSyscohada("");
                           var7.setPlcFiscalite(this.structureLog.getStrzonefiscale2());
                           var7.setPlcUserModif(this.usersLog.getUsrid());
                           var7 = this.planComptableDao.modif(var7, var1);
                        }
                     } else {
                        boolean var24 = false;
                        String var15 = var11.substring(0, var12.length());

                        for(int var16 = 0; var16 < var3.size(); ++var16) {
                           var8 = (Racines)var3.get(var16);
                           if (var8.getRacCode() != null && !var8.getRacCode().isEmpty() && var15.equals(var8.getRacCode()) && var8.getRacUtil() != null && !var8.getRacUtil().isEmpty() && var8.getRacUtil().equals("1")) {
                              var24 = true;
                              break;
                           }
                        }

                        if (var24 && var8.getRacCode() != null && !var8.getRacCode().isEmpty() && var11.startsWith(var8.getRacCode())) {
                           this.planComptable = this.planComptableDao.chercherCompte((String)null, var10, this.exoLast.getExecpt_id(), var1);
                           if (this.planComptable != null) {
                              this.planComptable.setPlcDateModif(new Date());
                              this.planComptable.setPlcCompte(var11);
                              this.planComptable.setPlcCodeRacine(var15);
                              this.planComptable.setPlcLibelleCpteFR(var6.getPlcLibelleCpteFR());
                              this.planComptable.setPlcLibelleCpteSP(var6.getPlcLibelleCpteSP());
                              this.planComptable.setPlcLibelleCpteUK(var6.getPlcLibelleCpteUK());
                              this.planComptable.setPlcLibelleNatureFR(var6.getPlcLibelleNatureFR());
                              this.planComptable.setPlcLibelleNatureSP(var6.getPlcLibelleNatureSP());
                              this.planComptable.setPlcLibelleNatureUK(var6.getPlcLibelleNatureUK());
                              this.planComptable.setPlcLibelleRacineFR(var6.getPlcLibelleRacineFR());
                              this.planComptable.setPlcLibelleRacineSP(var6.getPlcLibelleRacineSP());
                              this.planComptable.setPlcLibelleRacineUK(var6.getPlcLibelleRacineUK());
                              this.planComptable.setPlcCompteSyscohada("");
                              this.planComptable.setPlcFiscalite(this.structureLog.getStrzonefiscale2());
                              this.planComptable.setPlcUserModif(this.usersLog.getUsrid());
                              this.planComptable = this.planComptableDao.modif(this.planComptable, var1);
                           } else {
                              var7 = new PlanComptable();
                              var7.setExercicesComptable(this.exoLast);
                              var7.setPlcAnalCle1(var6.getPlcAnalCle1());
                              var7.setPlcAnalCle2(var6.getPlcAnalCle2());
                              var7.setPlcCodeRacine(var6.getPlcCodeRacine());
                              var7.setPlcCompte(var11);
                              var7.setPlcDateCreat(new Date());
                              var7.setPlcDateModif((Date)null);
                              var7.setPlcFiscalite(this.structureLog.getStrzonefiscale2());
                              var7.setPlcInactif(var6.getPlcInactif());
                              var7.setPlcLibelleCpteFR(var6.getPlcLibelleCpteFR());
                              var7.setPlcLibelleCpteSP(var6.getPlcLibelleCpteSP());
                              var7.setPlcLibelleCpteUK(var6.getPlcLibelleCpteUK());
                              var7.setPlcLibelleNatureFR(var6.getPlcLibelleNatureFR());
                              var7.setPlcLibelleNatureSP(var6.getPlcLibelleNatureSP());
                              var7.setPlcLibelleNatureUK(var6.getPlcLibelleNatureUK());
                              var7.setPlcLibelleRacineFR(var6.getPlcLibelleRacineFR());
                              var7.setPlcLibelleRacineSP(var6.getPlcLibelleRacineSP());
                              var7.setPlcLibelleRacineUK(var6.getPlcLibelleRacineUK());
                              var7.setPlcLibre(var6.getPlcLibre());
                              var7.setPlcNature(var6.getPlcNature());
                              var7.setPlcRanDetaille(var6.isPlcRanDetaille());
                              var7.setPlcCompteSyscohada("");
                              var7.setPlcSage(var6.getPlcSage());
                              var7.setPlcSens(var6.getPlcSens());
                              var7.setPlcTauxTaxe(var6.getPlcTauxTaxe());
                              var7.setPlcUserCreat(this.usersLog.getUsrid());
                              var7.setPlcUserModif(0L);
                              var7 = this.planComptableDao.insert(var7, var1);
                           }

                           if (!var11.equals(var10)) {
                              if (var6.getPlcNature() >= 7 && var6.getPlcNature() <= 10) {
                                 new JournauxComptables();
                                 JournauxComptablesDao var17 = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
                                 JournauxComptables var25 = var17.rechercheJCByCompte(var10, this.exoLast.getExecpt_id(), var1);
                                 if (var25 != null) {
                                    var25.setPljCompteTreso(var11);
                                    var17.modif(var25, var1);
                                 }
                              }

                              new ArrayList();
                              List var26 = this.ecrituresDao.chargerEcrituresByCompte(this.exoLast.getExecpt_id(), var10, var1);
                              if (var26.size() != 0) {
                                 new Ecritures();

                                 for(int var18 = 0; var18 < var26.size(); ++var18) {
                                    Ecritures var27 = (Ecritures)var26.get(var18);
                                    var27.setEcrCompte(var11);
                                    this.ecrituresDao.modif(var27, var1);
                                 }
                              }
                           }
                        }
                     }
                  } else {
                     var13 = false;
                  }
               }
            }

            var2.commit();
         } catch (HibernateException var22) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var22;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public boolean isOneMenuModif() {
      return this.oneMenuModif;
   }

   public void setOneMenuModif(boolean var1) {
      this.oneMenuModif = var1;
   }

   public String annuler() {
      return null;
   }

   public List getLesNaturesFiscale() {
      return this.lesNaturesFiscale;
   }

   public void setLesNaturesFiscale(List var1) {
      this.lesNaturesFiscale = var1;
   }

   public Element getRacin() {
      return this.racin;
   }

   public void setRacin(Element var1) {
      this.racin = var1;
   }

   public List getMaListe() {
      return this.maListe;
   }

   public void setMaListe(List var1) {
      this.maListe = var1;
   }

   public boolean isRacModif() {
      return this.racModif;
   }

   public void setRacModif(boolean var1) {
      this.racModif = var1;
   }

   public boolean isAffichRan() {
      return this.affichRan;
   }

   public void setAffichRan(boolean var1) {
      this.affichRan = var1;
   }

   public boolean isAffichTauxTaxe() {
      return this.affichTauxTaxe;
   }

   public void setAffichTauxTaxe(boolean var1) {
      this.affichTauxTaxe = var1;
   }

   public boolean isVhcd() {
      return this.vhcd;
   }

   public void setVhcd(boolean var1) {
      this.vhcd = var1;
   }

   public boolean isVhlibre() {
      return this.vhlibre;
   }

   public void setVhlibre(boolean var1) {
      this.vhlibre = var1;
   }

   public boolean isVhtt() {
      return this.vhtt;
   }

   public void setVhtt(boolean var1) {
      this.vhtt = var1;
   }

   public boolean isDisable() {
      return this.disable;
   }

   public void setDisable(boolean var1) {
      this.disable = var1;
   }

   public String getIntituleNat() {
      return this.intituleNat;
   }

   public void setIntituleNat(String var1) {
      this.intituleNat = var1;
   }

   public String getIntituleRac() {
      return this.intituleRac;
   }

   public void setIntituleRac(String var1) {
      this.intituleRac = var1;
   }

   public String getComplNum() {
      return this.complNum;
   }

   public void setComplNum(String var1) {
      this.complNum = var1;
   }

   public boolean isExisteCopteDeja() {
      return this.existeCopteDeja;
   }

   public void setExisteCopteDeja(boolean var1) {
      this.existeCopteDeja = var1;
   }

   public String getChoixPC() {
      return this.choixPC;
   }

   public void setChoixPC(String var1) {
      this.choixPC = var1;
   }

   public String getFiltre() {
      return this.filtre;
   }

   public void setFiltre(String var1) {
      this.filtre = var1;
   }

   public String getMouvement() {
      return this.mouvement;
   }

   public void setMouvement(String var1) {
      this.mouvement = var1;
   }

   public String getRequete() {
      return this.requete;
   }

   public void setRequete(String var1) {
      this.requete = var1;
   }

   public boolean isAfficheAjDefaut() {
      return this.afficheAjDefaut;
   }

   public void setAfficheAjDefaut(boolean var1) {
      this.afficheAjDefaut = var1;
   }

   public boolean isAfficheButtMod() {
      return this.afficheButtMod;
   }

   public void setAfficheButtMod(boolean var1) {
      this.afficheButtMod = var1;
   }

   public boolean isAfficheButtSup() {
      return this.afficheButtSup;
   }

   public void setAfficheButtSup(boolean var1) {
      this.afficheButtSup = var1;
   }

   public DataModel getMadatamodel() {
      return this.madatamodel;
   }

   public void setMadatamodel(DataModel var1) {
      this.madatamodel = var1;
   }

   public List getNaturFiscalItem() {
      return this.naturFiscalItem;
   }

   public void setNaturFiscalItem(List var1) {
      this.naturFiscalItem = var1;
   }

   public List getRacinesItems() {
      return this.racinesItems;
   }

   public void setRacinesItems(List var1) {
      this.racinesItems = var1;
   }

   public String getZoneFiscal() {
      return this.zoneFiscal;
   }

   public void setZoneFiscal(String var1) {
      this.zoneFiscal = var1;
   }

   public PlanComptable getPlanComptable() {
      return this.planComptable;
   }

   public void setPlanComptable(PlanComptable var1) {
      this.planComptable = var1;
   }

   public boolean isInactif() {
      return this.inactif;
   }

   public void setInactif(boolean var1) {
      this.inactif = var1;
   }

   public boolean isAfficheAjout() {
      return this.afficheAjout;
   }

   public void setAfficheAjout(boolean var1) {
      this.afficheAjout = var1;
   }

   public String getNatureFiscale() {
      return this.natureFiscale;
   }

   public void setNatureFiscale(String var1) {
      this.natureFiscale = var1;
   }

   public int getNombrCaracter() {
      return this.nombrCaracter;
   }

   public void setNombrCaracter(int var1) {
      this.nombrCaracter = var1;
   }

   public String getFormat() {
      return this.format;
   }

   public void setFormat(String var1) {
      this.format = var1;
   }

   public String getCodRacine() {
      return this.codRacine;
   }

   public void setCodRacine(String var1) {
      this.codRacine = var1;
   }

   public ExercicesComptable getExoLast() {
      return this.exoLast;
   }

   public void setExoLast(ExercicesComptable var1) {
      this.exoLast = var1;
   }

   public Document getDocument() {
      return this.document;
   }

   public void setDocument(Document var1) {
      this.document = var1;
   }

   public Racines getRacines() {
      return this.racines;
   }

   public void setRacines(Racines var1) {
      this.racines = var1;
   }

   public boolean isVar_affPanelCompte() {
      return this.var_affPanelCompte;
   }

   public void setVar_affPanelCompte(boolean var1) {
      this.var_affPanelCompte = var1;
   }

   public List getMesClesAnalytiques() {
      return this.mesClesAnalytiques;
   }

   public void setMesClesAnalytiques(List var1) {
      this.mesClesAnalytiques = var1;
   }

   public int getNbcarmax() {
      return this.nbcarmax;
   }

   public void setNbcarmax(int var1) {
      this.nbcarmax = var1;
   }

   public String getBaseLog() {
      return this.baseLog;
   }

   public void setBaseLog(String var1) {
      this.baseLog = var1;
   }

   public Structure getStructureLog() {
      return this.structureLog;
   }

   public void setStructureLog(Structure var1) {
      this.structureLog = var1;
   }

   public Users getUsersLog() {
      return this.usersLog;
   }

   public void setUsersLog(Users var1) {
      this.usersLog = var1;
   }

   public UtilInitHibernate getutilInitHibernate() {
      return this.utilInitHibernate;
   }

   public void setutilInitHibernate(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public int getChoixRacine() {
      return this.choixRacine;
   }

   public void setChoixRacine(int var1) {
      this.choixRacine = var1;
   }

   public String getSelecFiscalite() {
      return this.selecFiscalite;
   }

   public void setSelecFiscalite(String var1) {
      this.selecFiscalite = var1;
   }

   public List getLesAnneesItems() {
      return this.lesAnneesItems;
   }

   public void setLesAnneesItems(List var1) {
      this.lesAnneesItems = var1;
   }

   public long getAnnee() {
      return this.annee;
   }

   public void setAnnee(long var1) {
      this.annee = var1;
   }
}
