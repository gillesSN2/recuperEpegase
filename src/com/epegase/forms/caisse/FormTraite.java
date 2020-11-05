package com.epegase.forms.caisse;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.Departement;
import com.epegase.systeme.classe.Devise;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesCaisse;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.JournauxComptables;
import com.epegase.systeme.classe.Parapheur;
import com.epegase.systeme.classe.PointDeVente;
import com.epegase.systeme.classe.Region;
import com.epegase.systeme.classe.Secteur;
import com.epegase.systeme.classe.Service;
import com.epegase.systeme.classe.Site;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.TraiteEntete;
import com.epegase.systeme.classe.TraiteLigne;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.dao.DepartementDao;
import com.epegase.systeme.dao.DeviseDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.HabilitationDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.ParapheurDao;
import com.epegase.systeme.dao.PointDeVenteDao;
import com.epegase.systeme.dao.RegionDao;
import com.epegase.systeme.dao.SecteurDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.SiteDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.TraiteEnteteDao;
import com.epegase.systeme.dao.TraiteLigneDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.LectureDevises;
import com.epegase.systeme.xml.ObjetDevises;
import com.epegase.systeme.xml.OptionCaisses;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jdom.JDOMException;
import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlExtendedDataTable;
import org.richfaces.model.selection.SimpleSelection;

public class FormTraite implements Serializable {
   private int typeVente;
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private FormRecherche formRecherche;
   private int var_action = 0;
   private int var_memo_action = 0;
   private String pageIndex;
   private int nature;
   private OptionCaisses optionCaisses;
   private ExercicesCaisse selectedExo;
   private ExercicesCaisse lastExo;
   private UtilNombre utilNombre = new UtilNombre();
   private UtilDate utilDate = new UtilDate();
   private List mesOnglets;
   private int var_nb_max = 100;
   private String var_intitule;
   private String userCreateur;
   private String userModification;
   private long userResponsable;
   private UserDao userDao;
   private boolean deviseLocale = true;
   private EspionDao espionDao;
   private int inpEtat = 0;
   private Date dateDebut;
   private Date dateFin;
   private Date dateDepot;
   private Date dateRetour;
   private Date dateRepport;
   private String var_bordereau;
   private String var_motif;
   private String inpService = "100";
   private String dte1Affichage;
   private String dte2Affichage;
   private CalculChrono calculChrono;
   private String var_banque;
   private String var_compte;
   private String var_nomBanque;
   private String var_nomBanquier;
   private String var_adresseBanque;
   private String var_villeBanque;
   private String var_adresseFounisseur;
   private String var_banqueFournisseur;
   private String var_compteFournisseur;
   private String var_nomBanqueFournisseur;
   private String var_adresseBanqueFournisseur;
   private String var_ibanBanqueFournisseur;
   private String var_swiftBanqueFournisseur;
   private String var_tvaFournisseur;
   private String var_fonctionResponsable;
   private transient DataModel datamodelTraite = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private List lesTraites = new ArrayList();
   private TraiteEnteteDao traiteEnteteDao;
   private TraiteEntete traiteEntete;
   private boolean visibiliteBton = false;
   private List mesTypeTiers = new ArrayList();
   private boolean var_affiche_valide = false;
   private String var_modeReglement;
   private int nbDejaPaye;
   private double montantPaye;
   private double montantReste;
   private double montantPayeLocal;
   private double montantResteLocal;
   private transient DataModel dataModelEcheance = new ListDataModel();
   private List lesEcheances = new ArrayList();
   private TraiteLigneDao traiteLigneDao;
   private Tiers tiers;
   private TiersDao tiersDao;
   private String inputTypReglment;
   private UsersChrono usersChrono = new UsersChrono();
   private UsersChronoDao usersChronoDao;
   private boolean champCltVide = false;
   private boolean var_acc_descriptif = false;
   private boolean var_ajt = false;
   private boolean var_mod = false;
   private boolean var_sup = false;
   private boolean var_imp = false;
   private boolean visibleOnglet = false;
   private transient DataModel dataModelDepot;
   private List lesDepots;
   private List mesSecteursItems = new ArrayList();
   private List mesPdvItems = new ArrayList();
   private List mesDepartementsItems = new ArrayList();
   private List mesServicesItems = new ArrayList();
   private boolean var_site;
   private boolean var_departement;
   private boolean var_service;
   private boolean var_region;
   private boolean var_secteur;
   private boolean var_pdv;
   private boolean var_activite;
   private boolean var_dossier;
   private boolean var_parc;
   private boolean var_cle;
   private boolean var_budget;
   private String requete;
   private String filtre;
   private String format = "PDF";
   private int var_choix_modele = 0;
   private String nomModeleDocument;
   private String nomModeleListe;
   private String nomRepMod;
   private boolean visibleOptionMail = false;
   private UtilPrint utilPrint;
   private boolean affMail = false;
   private boolean affListeDoc = false;
   private String impEmetteur;
   private String impDestinataire;
   private String impDestinataireCC;
   private String impDestinataireCCI;
   private boolean showModalPanelPrint = false;
   private Habilitation habilitation;
   private HabilitationDao habilitationDao;
   private Parapheur parapheur;
   private ParapheurDao parapheurDao;

   public void InstancesDaoUtilses() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.traiteEnteteDao = new TraiteEnteteDao(this.baseLog, this.utilInitHibernate);
      this.traiteLigneDao = new TraiteLigneDao(this.baseLog, this.utilInitHibernate);
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.habilitationDao = new HabilitationDao(this.baseLog, this.utilInitHibernate);
      this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
   }

   public void configCaisses(Session var1) {
      this.visibiliteBton = false;
      boolean var2 = false;
      boolean var3 = false;
      boolean var4 = false;
      this.mesTypeTiers = new ArrayList();
      boolean var5 = false;
      Object var6 = null;
      if (this.optionCaisses.getNbLigneMax() != null && !this.optionCaisses.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionCaisses.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      if (this.typeVente == 815) {
         var2 = true;
      } else {
         var2 = false;
      }

      var5 = false;
      var6 = var1.createQuery("SELECT COUNT(*) FROM ExercicesPaye").uniqueResult();
      int var7 = Integer.parseInt(var6.toString());
      if (var7 > 0) {
         var4 = true;
      } else {
         var4 = false;
      }

      if (var2) {
         this.mesTypeTiers.add(new SelectItem("4", "Patient"));
         this.mesTypeTiers.add(new SelectItem("1", "Fournisseur"));
         if (var4) {
            this.mesTypeTiers.add(new SelectItem("2", "Agent"));
         }

         this.mesTypeTiers.add(new SelectItem("3", "Plan comptable"));
      } else if (var3) {
         this.mesTypeTiers.add(new SelectItem("5", "Elève"));
         this.mesTypeTiers.add(new SelectItem("1", "Fournisseur"));
         if (var4) {
            this.mesTypeTiers.add(new SelectItem("2", "Agent"));
         }

         this.mesTypeTiers.add(new SelectItem("3", "Plan comptable"));
      } else {
         this.mesTypeTiers.add(new SelectItem("0", "Client"));
         this.mesTypeTiers.add(new SelectItem("1", "Fournisseur"));
         if (var4) {
            this.mesTypeTiers.add(new SelectItem("2", "Agent"));
         }

         this.mesTypeTiers.add(new SelectItem("3", "Plan comptable"));
      }

      this.inpEtat = 0;
      if (this.optionCaisses.getAxeSite().equals("true")) {
         this.var_site = true;
         this.var_departement = true;
         this.var_service = true;
      }

      if (this.optionCaisses.getAxeRegion().equals("true")) {
         this.var_region = true;
         this.var_secteur = true;
         this.var_pdv = true;
      }

      if (this.optionCaisses.getAxeActivite().equals("true")) {
         this.var_activite = true;
      } else {
         this.var_activite = false;
      }

      if (this.optionCaisses.getAxeParc().equals("true")) {
         this.var_parc = true;
      } else {
         this.var_parc = false;
      }

      if (this.optionCaisses.getAxeCles().equals("true")) {
         this.var_cle = true;
      } else {
         this.var_cle = false;
      }

      if (!this.optionCaisses.getAxeSite().equals("1") && !this.optionCaisses.getAxeSite().equals("2")) {
         this.var_dossier = false;
      } else {
         this.var_dossier = true;
      }

      this.var_budget = false;
   }

   public void recupererMoisEnCours(Session var1) throws NamingException, ParseException {
      this.dateDebut = this.utilDate.datePremierJourMois(new Date());
      this.chargerFind(var1);
   }

   public void accesResteintUser() {
   }

   public void accesResteintGroupe() {
   }

   public ObjetDevises calculerLibelleDevise(String var1) throws IOException {
      LectureDevises var2 = new LectureDevises();
      new ArrayList();
      List var3 = var2.getMesDevises();
      ObjetDevises var4 = new ObjetDevises();
      if (var3.size() != 0) {
         for(int var5 = 0; var5 < var3.size(); ++var5) {
            if (((ObjetDevises)var3.get(var5)).getCode().equalsIgnoreCase(var1)) {
               var4 = (ObjetDevises)var3.get(var5);
               break;
            }
         }
      }

      return var4;
   }

   public void razListe() {
      this.visibiliteBton = false;
      this.lesTraites.clear();
      this.datamodelTraite.setWrappedData(this.lesTraites);
   }

   public void chargerSecteur() throws HibernateException, NamingException {
      this.mesSecteursItems.clear();
      this.mesPdvItems.clear();
      if (this.traiteEntete.getTrtRegion() != null && !this.traiteEntete.getTrtRegion().isEmpty() && this.traiteEntete.getTrtRegion().contains(":")) {
         new ArrayList();
         String[] var2 = this.traiteEntete.getTrtRegion().split(":");
         new Region();
         RegionDao var4 = new RegionDao(this.baseLog, this.utilInitHibernate);
         Region var3 = var4.rechercheRegion(var2[0], (Session)null);
         if (var3 != null) {
            SecteurDao var5 = new SecteurDao(this.baseLog, this.utilInitHibernate);
            List var1 = var5.listSecteurByRegion((Region)var3, (Session)null);
            if (var1.size() != 0) {
               for(int var6 = 0; var6 < var1.size(); ++var6) {
                  this.mesSecteursItems.add(new SelectItem(((Secteur)var1.get(var6)).getSecCode() + ":" + ((Secteur)var1.get(var6)).getSecNomFr()));
               }
            }
         }
      }

   }

   public void chargerPdv() throws HibernateException, NamingException {
      this.mesPdvItems.clear();
      if (this.traiteEntete.getTrtSecteur() != null && !this.traiteEntete.getTrtSecteur().isEmpty() && this.traiteEntete.getTrtSecteur().contains(":")) {
         new ArrayList();
         String[] var2 = this.traiteEntete.getTrtSecteur().split(":");
         new Secteur();
         SecteurDao var4 = new SecteurDao(this.baseLog, this.utilInitHibernate);
         Secteur var3 = var4.rechercheSecteur(var2[0], (Session)null);
         if (var3 != null) {
            PointDeVenteDao var5 = new PointDeVenteDao(this.baseLog, this.utilInitHibernate);
            List var1 = var5.listPdvBySecteur((Secteur)var3, (Session)null);
            if (var1.size() != 0) {
               for(int var6 = 0; var6 < var1.size(); ++var6) {
                  this.mesPdvItems.add(new SelectItem(((PointDeVente)var1.get(var6)).getPdvCode() + ":" + ((PointDeVente)var1.get(var6)).getPdvNomFr()));
               }
            }
         }
      }

   }

   public void chargerDepartement() throws HibernateException, NamingException {
      this.mesDepartementsItems.clear();
      this.mesServicesItems.clear();
      if (this.traiteEntete.getTrtSite() != null && !this.traiteEntete.getTrtSite().isEmpty() && this.traiteEntete.getTrtSite().contains(":")) {
         new ArrayList();
         String[] var2 = this.traiteEntete.getTrtSite().split(":");
         new Site();
         SiteDao var4 = new SiteDao(this.baseLog, this.utilInitHibernate);
         Site var3 = var4.rechercheSite(var2[0], (Session)null);
         if (var3 != null) {
            DepartementDao var5 = new DepartementDao(this.baseLog, this.utilInitHibernate);
            List var1 = var5.listDepartementBySit((Site)var3, (Session)null);
            if (var1.size() != 0) {
               for(int var6 = 0; var6 < var1.size(); ++var6) {
                  this.mesDepartementsItems.add(new SelectItem(((Departement)var1.get(var6)).getDepCode() + ":" + ((Departement)var1.get(var6)).getDepNomFr()));
               }
            }
         }
      }

   }

   public void chargerService() throws HibernateException, NamingException {
      this.mesServicesItems.clear();
      if (this.traiteEntete.getTrtDepartement() != null && !this.traiteEntete.getTrtDepartement().isEmpty() && this.traiteEntete.getTrtDepartement().contains(":")) {
         new ArrayList();
         String[] var2 = this.traiteEntete.getTrtDepartement().split(":");
         new Departement();
         DepartementDao var4 = new DepartementDao(this.baseLog, this.utilInitHibernate);
         Departement var3 = var4.rechercheDepartement(var2[0], (Session)null);
         if (var3 != null) {
            ServiceDao var5 = new ServiceDao(this.baseLog, this.utilInitHibernate);
            List var1 = var5.listServiceByDep((Departement)var3, (Session)null);
            if (var1.size() != 0) {
               for(int var6 = 0; var6 < var1.size(); ++var6) {
                  this.mesServicesItems.add(new SelectItem(((Service)var1.get(var6)).getSerCode() + ":" + ((Service)var1.get(var6)).getSerNomFr()));
               }
            }
         }
      }

   }

   public void chargerFind() throws HibernateException, NamingException {
      this.chargerFind((Session)null);
   }

   public void chargerFind(Session var1) throws HibernateException, NamingException {
      this.lesTraites.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      if (this.dateDebut == null) {
         this.dateDebut = this.selectedExo.getExecaiDateDebut();
      }

      String var2 = "";
      if (this.dateDebut.getDate() <= 9) {
         var2 = "0" + this.dateDebut.getDate();
      } else {
         var2 = "" + this.dateDebut.getDate();
      }

      String var3 = "";
      if (this.dateDebut.getMonth() + 1 <= 9) {
         var3 = "0" + (this.dateDebut.getMonth() + 1);
      } else {
         var3 = "" + (this.dateDebut.getMonth() + 1);
      }

      String var4 = "" + (this.dateDebut.getYear() + 1900);
      (new StringBuilder()).append(var4).append("-").append(var3).append("-").append(var2).toString();
      this.lesTraites = this.traiteEnteteDao.selectFind(this.inpEtat, this.nature, this.inpService, var1);
      this.datamodelTraite.setWrappedData(this.lesTraites);
      this.traiteEntete = new TraiteEntete();
   }

   public void selectionLigne() throws HibernateException, NamingException {
      if (this.extDTable != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelectionEntete.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTable.setRowKey(var3);
            if (this.extDTable.isRowAvailable()) {
               var1.add(this.extDTable.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.traiteEntete = (TraiteEntete)var1.get(0);
            this.var_banque = this.traiteEntete.getTrtBanque();
            Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "Traites");
            if (this.traiteEntete.getTrtIdTiers() != 0L) {
               this.tiers = this.tiersDao.selectTierD(this.traiteEntete.getTrtIdTiers(), var5);
            } else {
               this.tiers = null;
            }

            this.userCreateur = "";
            Users var4;
            if (this.traiteEntete.getTrtUserCreat() != 0L) {
               new Users();
               var4 = this.userDao.selectUserD(this.traiteEntete.getTrtUserCreat(), var5);
               if (var4 != null) {
                  this.userCreateur = var4.getUsrPatronyme();
               }
            }

            this.userModification = "";
            if (this.traiteEntete.getTrtUserModif() != 0L) {
               new Users();
               var4 = this.userDao.selectUserD(this.traiteEntete.getTrtUserModif(), var5);
               if (var4 != null) {
                  this.userModification = var4.getUsrPatronyme();
               }
            }

            if (this.traiteEntete.getTrtDevise() != null && !this.traiteEntete.getTrtDevise().isEmpty()) {
               if (this.traiteEntete.getTrtDevise().equals(this.structureLog.getStrdevise())) {
                  this.deviseLocale = true;
               } else {
                  this.deviseLocale = false;
               }
            } else {
               this.deviseLocale = true;
            }

            if (this.traiteEntete.getTrtCoef() == 0.0F) {
               this.traiteEntete.setTrtCoef(1.0F);
            }

            this.montantPaye = this.traiteEntete.getTrtTotalReglement();
            this.montantPayeLocal = this.traiteEntete.getTrtTotalReglementLocal();
            this.montantReste = this.traiteEntete.getTrtMontant() - this.montantPaye;
            this.montantResteLocal = this.traiteEntete.getTrtMontantLocal() - this.montantPayeLocal;
            this.chargerLesEcheances(var5);
            this.chargerUserChrono(var5);
            this.utilInitHibernate.closeSession();
            this.visibiliteBton = true;
         } else {
            this.visibiliteBton = false;
         }
      } else {
         this.visibiliteBton = false;
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.traiteEntete != null) {
         if (this.traiteEntete.getTrtEtat() == 0) {
            this.modifierTraite();
         } else {
            this.consulterTraite();
         }
      }

   }

   public void chargerLesEcheances(Session var1) throws HibernateException, NamingException {
      this.lesEcheances.clear();
      int var2 = 0;
      if (this.traiteEntete != null) {
         this.lesEcheances = this.traiteLigneDao.chargerLigneTraite(this.traiteEntete, var1);
         if (this.lesEcheances.size() != 0) {
            for(int var3 = 0; var3 < this.lesEcheances.size(); ++var3) {
               if (((TraiteLigne)this.lesEcheances.get(var3)).getTrtligDateDepot() != null && ((TraiteLigne)this.lesEcheances.get(var3)).getTrtligDateRetour() == null) {
                  ++var2;
               }
            }
         }

         this.nbDejaPaye = var2;
      }

      this.dataModelEcheance.setWrappedData(this.lesEcheances);
   }

   public void chargerUserChrono(Session var1) throws HibernateException, NamingException {
      if (this.traiteEntete != null) {
         this.usersChrono = this.usersChronoDao.selectUnique("", this.nature, this.usersLog, var1);
      }

   }

   public void ajouterTraite() {
      this.traiteEntete = new TraiteEntete();
      this.traiteEntete.setTrtDateCreat(new Date());
      this.traiteEntete.setTrtNomResponsable(this.usersLog.getUsrPrenom() + " " + this.usersLog.getUsrNom());
      this.userResponsable = this.usersLog.getUsrid();
      this.traiteEntete.setTrtDevise(this.structureLog.getStrdevise());
      this.lesEcheances.clear();
      this.dataModelEcheance.setWrappedData(this.lesEcheances);
      this.var_action = 1;
      this.userCreateur = "";
      this.userModification = "";
      this.userResponsable = 0L;
      this.deviseLocale = true;
      this.traiteEntete.setTrtDevise(this.structureLog.getStrdevise());
      this.traiteEntete.setTrtCoef(1.0F);
      this.var_memo_action = this.var_action;
   }

   public void modifierTraite() {
      if (this.traiteEntete != null) {
         this.var_affiche_valide = true;
         this.var_action = 2;
         this.var_memo_action = this.var_action;
      }

   }

   public void consulterTraite() {
      if (this.traiteEntete != null) {
         this.var_affiche_valide = false;
         this.var_action = 3;
         this.var_memo_action = this.var_action;
      }

   }

   public void valideTraite() throws HibernateException, NamingException {
      if (this.traiteEntete != null && this.traiteEntete.getTrtMontantLocal() > 0.0D && this.traiteEntete.getTrtNomTiers() != null && !this.traiteEntete.getTrtNomTiers().isEmpty()) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Traites");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.traiteEntete.getTrtEtat() == 0 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
               this.traiteEntete.setTrtEtat(1);
               this.traiteEntete = this.traiteEnteteDao.modif(this.traiteEntete, var1);
               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Validation manuelle traite (T.) N° " + this.traiteEntete.getTrtNum() + " du " + this.utilDate.dateToStringSQLLight(this.traiteEntete.getTrtDateDebut()));
               this.espionDao.mAJEspion(var3, var1);
            }

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

   public void deValideTraite() throws HibernateException, NamingException {
      if (this.traiteEntete != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Traites");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.traiteEntete.getTrtEtat() == 1 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
               this.traiteEntete.setTrtEtat(0);
               this.traiteEntete = this.traiteEnteteDao.modif(this.traiteEntete, var1);
               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Dévalidation manuelle traite (T.) N° " + this.traiteEntete.getTrtNum() + " du " + this.utilDate.dateToStringSQLLight(this.traiteEntete.getTrtDateDebut()));
               this.espionDao.mAJEspion(var3, var1);
            }

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

   public void supprimerTraite() throws HibernateException, NamingException {
      if (this.traiteEntete != null) {
         this.lesTraites.remove(this.traiteEntete);
         this.datamodelTraite.setWrappedData(this.lesTraites);
         this.traiteEnteteDao.delete(this.traiteEntete);
      }

      this.visibiliteBton = false;
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
   }

   public void annuleSaisie() {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.visibleOnglet = false;
      this.visibiliteBton = false;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public void saveTraite() throws HibernateException, NamingException {
      boolean var1 = true;
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Traites");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         if (this.userResponsable != 0L) {
            new Users();
            Users var4 = this.userDao.selectLeUserId(this.userResponsable, var2);
            if (var4 != null) {
               this.traiteEntete.setTrtIdResponsable(this.userResponsable);
               this.traiteEntete.setTrtNomResponsable(var4.getUsrPatronyme());
            } else {
               this.traiteEntete.setTrtIdResponsable(0L);
               this.traiteEntete.setTrtNomResponsable("");
            }
         } else {
            this.traiteEntete.setTrtIdResponsable(0L);
            this.traiteEntete.setTrtNomResponsable("");
         }

         this.traiteEntete.setTrtBanque(this.var_banque);
         if (this.traiteEntete.getTrtSite() != null && this.traiteEntete.getTrtSite().contains("0")) {
            this.traiteEntete.setTrtSite("");
         }

         if (this.traiteEntete.getTrtDepartement() != null && this.traiteEntete.getTrtDepartement().contains("0")) {
            this.traiteEntete.setTrtDepartement("");
         }

         if (this.traiteEntete.getTrtService() != null && this.traiteEntete.getTrtService().contains("0")) {
            this.traiteEntete.setTrtService("");
         }

         if (this.traiteEntete.getTrtRegion() != null && this.traiteEntete.getTrtRegion().contains("0")) {
            this.traiteEntete.setTrtRegion("");
         }

         if (this.traiteEntete.getTrtSecteur() != null && this.traiteEntete.getTrtSecteur().contains("0")) {
            this.traiteEntete.setTrtSecteur("");
         }

         if (this.traiteEntete.getTrtPdv() != null && this.traiteEntete.getTrtPdv().contains("0")) {
            this.traiteEntete.setTrtPdv("");
         }

         if (this.traiteEntete.getTrtActivite() != null && this.traiteEntete.getTrtActivite().contains("0")) {
            this.traiteEntete.setTrtActivite("");
         }

         if (this.traiteEntete.getTrtDossier() != null && this.traiteEntete.getTrtDossier().contains("0")) {
            this.traiteEntete.setTrtDossier("");
         }

         if (this.traiteEntete.getTrtBudget() != null && this.traiteEntete.getTrtBudget().contains("0")) {
            this.traiteEntete.setTrtBudget("");
         }

         if (this.traiteEntete.getTrtId() == 0L) {
            this.traiteEntete.setExercicesCaisse(this.selectedExo);
            this.traiteEntete.setTrtNature(this.nature);
            String var21 = this.calculChrono.numCompose(this.traiteEntete.getTrtDateDebut(), this.nature, "", var2);
            this.traiteEntete.setTrtNum(var21);
            this.traiteEntete.setTrtDateCreat(new Date());
            this.traiteEntete.setTrtUserCreat(this.usersLog.getUsrid());
            this.traiteEntete = this.traiteEnteteDao.insert(this.traiteEntete, var2);
            this.lesTraites.add(this.traiteEntete);
            this.datamodelTraite.setWrappedData(this.lesTraites);
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
         } else {
            this.traiteEntete.setTrtDateModif(new Date());
            this.traiteEntete.setTrtUserModif(this.usersLog.getUsrid());
            this.traiteEntete = this.traiteEnteteDao.modif(this.traiteEntete, var2);
         }

         var3.commit();
      } catch (HibernateException var19) {
         var1 = false;
         if (var3 != null) {
            var3.rollback();
         }

         throw var19;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      if (var1 && this.lesEcheances.size() != 0) {
         Session var22 = this.utilInitHibernate.getOpenSession(this.baseLog, "Traites");
         Transaction var5 = null;

         try {
            var5 = var22.beginTransaction();

            for(int var6 = 0; var6 < this.lesEcheances.size(); ++var6) {
               new TraiteLigne();
               TraiteLigne var7 = (TraiteLigne)this.lesEcheances.get(var6);
               if (var7.getTrtligId() == 0L) {
                  var7.setTraiteEntete(this.traiteEntete);
                  this.traiteLigneDao.insert(var7, var22);
               } else {
                  this.traiteLigneDao.modif(var7, var22);
               }
            }

            var5.commit();
         } catch (HibernateException var17) {
            if (var5 != null) {
               var5.rollback();
            }

            throw var17;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_action = 0;
      this.var_memo_action = this.var_action;
   }

   public void calculNbTraite() throws ParseException, HibernateException, NamingException {
      this.traiteEntete.setTrtNbMoisEcheanceGene(this.traiteEntete.getTrtDuree() - 1);
      this.calculMontant();
   }

   public void calculMontant() throws ParseException, HibernateException, NamingException {
      this.calculDevise();
      double var1 = (double)this.traiteEntete.getTrtNbMoisEcheanceGene() * this.traiteEntete.getTrtMontantGeneLocal();
      double var3 = this.traiteEntete.getTrtMontantLocal() - var1;
      this.traiteEntete.setTrtMontantFinalLocal(var3);
      this.montantResteLocal = this.traiteEntete.getTrtMontantLocal() - this.montantPayeLocal;
      if (!this.deviseLocale) {
         double var5 = (double)this.traiteEntete.getTrtNbMoisEcheanceGene() * this.traiteEntete.getTrtMontantGene();
         double var7 = this.traiteEntete.getTrtMontant() - var5;
         this.traiteEntete.setTrtMontantFinal(var7);
         this.montantReste = this.traiteEntete.getTrtMontant() - this.montantPaye;
      } else {
         this.traiteEntete.setTrtMontant(0.0D);
         this.traiteEntete.setTrtMontantFinal(0.0D);
         this.traiteEntete.setTrtMontantGene(0.0D);
      }

      this.calculLesEcheances();
      this.controleValidation();
   }

   public void calculLesEcheances() throws ParseException {
      if ((this.montantPayeLocal == 0.0D || this.montantPaye == 0.0D) && (this.traiteEntete.getTrtMontantLocal() != 0.0D || this.traiteEntete.getTrtMontant() != 0.0D) && this.traiteEntete.getTrtDateDebut() != null && this.traiteEntete.getTrtDuree() != 0) {
         this.lesEcheances.clear();
         Date var1 = this.traiteEntete.getTrtDateDebut();
         int var2 = this.traiteEntete.getTrtDateDebut().getDate();
         boolean var3 = false;

         for(int var4 = 0; var4 < this.traiteEntete.getTrtDuree(); ++var4) {
            if (var3) {
               if (this.traiteEntete.getTrtPeriodicite() == 0) {
                  var1 = this.utilDate.datedevaleurTheo(var1, 7);
               } else if (this.traiteEntete.getTrtPeriodicite() == 1) {
                  var1 = this.utilDate.dateMoisSuivant(var1, var2);
               } else if (this.traiteEntete.getTrtPeriodicite() != 2 && this.traiteEntete.getTrtPeriodicite() != 3 && this.traiteEntete.getTrtPeriodicite() == 4) {
               }
            }

            var3 = true;
            TraiteLigne var5 = new TraiteLigne();
            var5.setTrtligOrdre(var4 + 1);
            var5.setTrtligBordereau("");
            var5.setTrtligDateDepot((Date)null);
            var5.setTrtligDateReport((Date)null);
            var5.setTrtligDateRetour((Date)null);
            var5.setTrtligDateTheorique(var1);
            var5.setTrtligEtat(0);
            if (var5.getTrtligOrdre() == this.traiteEntete.getTrtDuree()) {
               var5.setTrtligMontantLocal(this.traiteEntete.getTrtMontantFinalLocal());
            } else {
               var5.setTrtligMontantLocal(this.traiteEntete.getTrtMontantGeneLocal());
            }

            if (!this.deviseLocale) {
               if (var5.getTrtligOrdre() == this.traiteEntete.getTrtDuree()) {
                  var5.setTrtligMontant(this.traiteEntete.getTrtMontantFinal());
               } else {
                  var5.setTrtligMontant(this.traiteEntete.getTrtMontantGene());
               }
            }

            var5.setTrtligMotif("");
            var5.setTrtligTypet(0);
            this.lesEcheances.add(var5);
         }

         this.dataModelEcheance.setWrappedData(this.lesEcheances);
      }

   }

   public void controleValidation() {
      if ((this.traiteEntete.getTrtMontantLocal() > 0.0D || this.traiteEntete.getTrtMontant() > 0.0D) && this.traiteEntete.getTrtNomTiers() != null && !this.traiteEntete.getTrtNomTiers().isEmpty()) {
         this.var_affiche_valide = true;
      } else {
         this.var_affiche_valide = false;
      }

   }

   public void calculDevise() throws HibernateException, NamingException {
      if (this.traiteEntete.getTrtDevise() != null && !this.traiteEntete.getTrtDevise().isEmpty()) {
         if (!this.traiteEntete.getTrtDevise().equals(this.structureLog.getStrdevise())) {
            double var1;
            double var3;
            double var5;
            Devise var7;
            DeviseDao var8;
            if (this.traiteEntete.getTrtMontant() != 0.0D) {
               var1 = this.traiteEntete.getTrtMontant();
               var3 = this.traiteEntete.getTrtMontantFinal();
               var5 = this.traiteEntete.getTrtMontantGene();
               new Devise();
               var8 = new DeviseDao(this.baseLog, this.utilInitHibernate);
               var7 = var8.chargerLesDevises(this.traiteEntete.getTrtDevise(), (Session)null);
               if (var7 != null) {
                  this.traiteEntete.setTrtCoef(var7.getDevTaux2());
               } else {
                  this.traiteEntete.setTrtCoef(1.0F);
               }

               this.traiteEntete.setTrtMontantLocal(var1 * (double)this.traiteEntete.getTrtCoef());
               this.traiteEntete.setTrtMontantFinalLocal(var3 * (double)this.traiteEntete.getTrtCoef());
               this.traiteEntete.setTrtMontantGeneLocal(var5 * (double)this.traiteEntete.getTrtCoef());
            } else {
               var1 = this.traiteEntete.getTrtMontantLocal();
               var3 = this.traiteEntete.getTrtMontantFinalLocal();
               var5 = this.traiteEntete.getTrtMontantGeneLocal();
               new Devise();
               var8 = new DeviseDao(this.baseLog, this.utilInitHibernate);
               var7 = var8.chargerLesDevises(this.traiteEntete.getTrtDevise(), (Session)null);
               if (var7 != null) {
                  this.traiteEntete.setTrtCoef(var7.getDevTaux2());
               } else {
                  this.traiteEntete.setTrtCoef(1.0F);
               }

               this.traiteEntete.setTrtMontant(var1 / (double)this.traiteEntete.getTrtCoef());
               this.traiteEntete.setTrtMontantFinal(var3 / (double)this.traiteEntete.getTrtCoef());
               this.traiteEntete.setTrtMontantGene(var5 / (double)this.traiteEntete.getTrtCoef());
            }

            this.deviseLocale = false;
         } else {
            this.traiteEntete.setTrtCoef(1.0F);
            this.deviseLocale = true;
         }
      } else {
         this.traiteEntete.setTrtCoef(1.0F);
         this.deviseLocale = true;
      }

   }

   public void calculSolde() throws HibernateException, NamingException {
      if (this.lesDepots.size() != 0) {
         ArrayList var1 = new ArrayList();
         new TraiteEntete();

         int var5;
         for(int var3 = 0; var3 < this.lesDepots.size(); ++var3) {
            TraiteEntete var2 = ((TraiteLigne)this.lesDepots.get(var3)).getTraiteEntete();
            if (var1.size() == 0) {
               var1.add(var2);
            } else {
               boolean var4 = false;

               for(var5 = 0; var5 < var1.size(); ++var5) {
                  if (var2.getTrtId() == ((TraiteEntete)var1.get(var5)).getTrtId()) {
                     var4 = true;
                     break;
                  }
               }

               if (!var4) {
                  var1.add(var2);
               }
            }
         }

         if (var1.size() != 0) {
            Session var19 = this.utilInitHibernate.getOpenSession(this.baseLog, "Traites");
            Transaction var20 = null;

            try {
               var20 = var19.beginTransaction();

               for(var5 = 0; var5 < var1.size(); ++var5) {
                  this.traiteEntete = (TraiteEntete)var1.get(var5);
                  long var6 = this.traiteEntete.getTrtId();
                  double var8 = 0.0D;
                  double var10 = 0.0D;
                  new ArrayList();
                  List var12 = this.traiteLigneDao.chargerLigneTraite(this.traiteEntete, var19);
                  if (var12.size() != 0) {
                     for(int var13 = 0; var13 < var12.size(); ++var13) {
                        if (((TraiteLigne)var12.get(var13)).getTrtligDateDepot() != null && ((TraiteLigne)var12.get(var13)).getTrtligDateRetour() == null) {
                           var10 += ((TraiteLigne)var12.get(var13)).getTrtligMontantLocal();
                           var8 += ((TraiteLigne)var12.get(var13)).getTrtligMontant();
                        }
                     }
                  }

                  this.traiteEntete = this.traiteEnteteDao.selectById(var6, var19);
                  if (this.traiteEntete != null) {
                     this.traiteEntete.setTrtTotalReglementLocal(var10);
                     this.traiteEntete.setTrtTotalReglement(var8);
                     if (this.traiteEntete.getTrtMontantLocal() == this.traiteEntete.getTrtTotalReglementLocal()) {
                        this.traiteEntete.setTrtEtat(4);
                     }

                     this.traiteEntete = this.traiteEnteteDao.modif(this.traiteEntete, var19);
                  }
               }

               var20.commit();
            } catch (HibernateException var17) {
               if (var20 != null) {
                  var20.rollback();
               }

               throw var17;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }
      }

   }

   public void depotMensuel() throws HibernateException, NamingException, ParseException {
      this.dataModelDepot = new ListDataModel();
      this.lesDepots = new ArrayList();
      if (this.dateDebut == null) {
         this.dateDebut = this.utilDate.datePremierJourMois(new Date());
      }

      this.dateFin = this.utilDate.dateDernierJourMois(this.dateDebut);
      this.dateDepot = new Date();
      String var1 = this.utilDate.dateToStringSQLLight(this.dateDebut);
      Date var2 = this.utilDate.stringToDateSQLLight(var1);
      this.dte1Affichage = this.utilDate.dateToStringFr(this.dateDebut);
      this.dte2Affichage = this.utilDate.dateToStringFr(this.dateFin);
      this.lesDepots = this.traiteLigneDao.chargerLigneDepot(this.nature, var2, (Session)null);
      this.dataModelDepot.setWrappedData(this.lesDepots);
      this.var_action = 5;
      this.var_memo_action = this.var_action;
   }

   public void validerDepotMensuel() throws HibernateException, NamingException {
      if (this.lesDepots.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Traites");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            new TraiteLigne();

            for(int var4 = 0; var4 < this.lesDepots.size(); ++var4) {
               TraiteLigne var3 = (TraiteLigne)this.lesDepots.get(var4);
               if (this.dateDepot == null) {
                  this.dateDepot = new Date();
               }

               var3.setTrtligDateDepot(this.dateDepot);
               var3.setTrtligBordereau(this.var_bordereau);
               this.traiteLigneDao.modif(var3, var1);
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

         this.calculSolde();
      }

      this.retourDepotMensuel();
   }

   public void retourDepotMensuel() {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
   }

   public void retourMensuel() throws HibernateException, NamingException, ParseException {
      this.dataModelDepot = new ListDataModel();
      this.lesDepots = new ArrayList();
      if (this.dateDebut == null) {
         this.dateDebut = this.utilDate.datePremierJourMois(new Date());
      }

      this.dateFin = this.utilDate.dateDernierJourMois(this.dateDebut);
      this.dateDepot = new Date();
      String var1 = this.utilDate.dateToStringSQLLight(this.dateDebut);
      Date var2 = this.utilDate.stringToDateSQLLight(var1);
      this.dte1Affichage = this.utilDate.dateToStringFr(this.dateDebut);
      this.dte2Affichage = this.utilDate.dateToStringFr(this.dateFin);
      this.lesDepots = this.traiteLigneDao.chargerLigneDepot(this.nature, var2, (Session)null);
      this.dataModelDepot.setWrappedData(this.lesDepots);
      this.var_action = 6;
      this.var_memo_action = this.var_action;
   }

   public void validerRetourMensuel() throws HibernateException, NamingException {
      if (this.lesDepots.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Traites");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            new TraiteLigne();
            int var4 = 0;

            while(true) {
               if (var4 >= this.lesDepots.size()) {
                  var2.commit();
                  break;
               }

               TraiteLigne var3 = (TraiteLigne)this.lesDepots.get(var4);
               this.traiteLigneDao.modif(var3, var1);
               ++var4;
            }
         } catch (HibernateException var8) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var8;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.calculSolde();
      }

      this.retourRetourMensuel();
   }

   public void retourRetourMensuel() {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
   }

   public void rechercheTiers() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      if (this.nature == 67) {
         this.tiers = this.formRecherche.rechercheTiers(0, this.traiteEntete.getTrtNomTiers(), this.nature);
      } else {
         this.tiers = this.formRecherche.rechercheTiers(3, this.traiteEntete.getTrtNomTiers(), this.nature);
      }

      if (this.tiers != null) {
         if (this.tiers.getTieid() != 0L) {
            this.calculeTiers();
         } else {
            this.var_action = 9;
         }
      } else if (this.tiers == null) {
         this.calculeTiers();
      }

   }

   public void recuperationTiers() throws JDOMException, IOException, HibernateException, NamingException {
      this.tiers = this.formRecherche.calculeTiers();
      this.calculeTiers();
   }

   public void calculeTiers() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.tiers != null) {
         if (this.traiteEntete.getTrtTypeTiers() == 0) {
            this.traiteEntete.setTrtIdTiers(this.tiers.getTieid());
            if (this.tiers.getTieprenom() != null && !this.tiers.getTieprenom().isEmpty()) {
               this.traiteEntete.setTrtNomTiers(this.tiers.getTieraisonsocialenom() + " " + this.tiers.getTieprenom());
            } else {
               this.traiteEntete.setTrtNomTiers(this.tiers.getTieraisonsocialenom());
            }
         } else if (this.traiteEntete.getTrtTypeTiers() == 1) {
            this.traiteEntete.setTrtIdTiers(this.tiers.getTieid());
            if (this.tiers.getTieprenom() != null && !this.tiers.getTieprenom().isEmpty()) {
               this.traiteEntete.setTrtNomTiers(this.tiers.getTieraisonsocialenom() + " " + this.tiers.getTieprenom());
            } else {
               this.traiteEntete.setTrtNomTiers(this.tiers.getTieraisonsocialenom());
            }
         }

         this.controleValidation();
      } else {
         this.annuleTiers();
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleTiers() {
      this.tiers = null;
      this.traiteEntete.setTrtNomTiers("");
      this.traiteEntete.setTrtIdTiers(0L);
      this.var_action = this.var_memo_action;
   }

   public void initImpression() {
      if (this.utilPrint == null) {
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
      }

      this.var_choix_modele = 0;
      this.ListeDocImp();
      this.showModalPanelPrint = true;
   }

   public void closeImpression() {
      this.showModalPanelPrint = false;
   }

   public String[] triAlphabetique(String[] var1, int var2) {
      int var3 = var2;
      boolean var4;
      if (var2 != 0) {
         do {
            var4 = false;

            for(int var5 = 0; var5 < var3 - 1; ++var5) {
               if (var1[var5].compareToIgnoreCase(var1[var5 + 1]) > 0) {
                  this.echanger(var1, var5, var5 + 1);
                  var4 = true;
               }
            }

            --var3;
         } while(var4);
      }

      return var1;
   }

   public void echanger(String[] var1, int var2, int var3) {
      String var4 = var1[var2];
      var1[var2] = var1[var3];
      var1[var3] = var4;
   }

   public void OptionMail() {
      if (this.format.equalsIgnoreCase("MAIL")) {
         this.visibleOptionMail = true;
      } else {
         this.visibleOptionMail = false;
      }

   }

   public void envoieMAIL() throws SQLException, JRException, IOException, HibernateException, NamingException {
      if (!this.affMail) {
         this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, (Tiers)null, "");
         if (this.utilPrint.getLesbalEmetteursItems().size() != 0 && this.utilPrint.getLesbalDestinatairesItems().size() != 0) {
            this.affMail = true;
         } else {
            this.affMail = false;
         }
      } else {
         this.affMail = false;
      }

   }

   public void imprimerPRT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "PRT";
      this.imprimer();
   }

   public void imprimerJRV() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "JRV";
      this.imprimer();
   }

   public void imprimerPDF() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "PDF";
      this.imprimer();
   }

   public void imprimerODT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "ODT";
      this.imprimer();
   }

   public void imprimerXLS() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "XLS";
      this.imprimer();
   }

   public void imprimerDOC() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "DOC";
      this.imprimer();
   }

   public void imprimerHTML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "HTML";
      this.imprimer();
   }

   public void imprimerXML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "XML";
      this.imprimer();
   }

   public void imprimerMAIL() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      if (this.impEmetteur != null && !this.impEmetteur.isEmpty() && (this.impDestinataire != null && !this.impDestinataire.isEmpty() || this.impDestinataireCC != null && !this.impDestinataireCC.isEmpty() || this.impDestinataireCCI != null && !this.impDestinataireCCI.isEmpty())) {
         this.format = "MAIL";
         this.imprimer();
      }

   }

   public void ListeDocImp() {
      if (this.var_choix_modele == 0) {
         this.affListeDoc = false;
      } else {
         this.affListeDoc = true;
      }

   }

   public String calculeCheminRapport(String var1, String var2) {
      String var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "documentsTraites" + File.separator + var2 + File.separator;
      return var3;
   }

   public String calculeCheminSousRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "sous_rapport" + File.separator;
      return var2;
   }

   public String calculeImageFond(String var1, int var2) throws HibernateException, NamingException {
      String var3 = "";
      if (var2 == 0) {
         File var4 = new File(this.calculeCheminSousRapport(var1) + "formatEncours.jpg");
         if (var4.exists()) {
            var3 = "formatEncours.jpg";
         }
      }

      return var3;
   }

   public JRBeanCollectionDataSource calculeImpressionCommun() throws IOException {
      ArrayList var1 = new ArrayList();
      if (this.lesEcheances.size() != 0) {
         new TraiteLigne();

         for(int var3 = 0; var3 < this.lesEcheances.size(); ++var3) {
            TraiteLigne var2 = (TraiteLigne)this.lesEcheances.get(var3);
            this.traiteEntete = var2.getTraiteEntete();
            this.traiteEntete.setVar_compte(this.var_compte);
            this.traiteEntete.setVar_banque(this.var_nomBanque);
            this.traiteEntete.setVar_nomBanquier(this.var_nomBanquier);
            this.traiteEntete.setVar_adresseBanque(this.var_adresseBanque);
            this.traiteEntete.setVar_villeBanque(this.var_villeBanque);
            this.traiteEntete.setVar_adresseFournisseur(this.var_adresseFounisseur);
            this.traiteEntete.setVar_compteFournisseur(this.var_compteFournisseur);
            this.traiteEntete.setVar_nomBanqueFournisseur(this.var_nomBanqueFournisseur);
            this.traiteEntete.setVar_adresseBanqueFournisseur(this.var_adresseBanqueFournisseur);
            this.traiteEntete.setVar_fonctionResponsable(this.var_fonctionResponsable);
            this.traiteEntete.setVar_ibanBanqueFournisseur(this.var_ibanBanqueFournisseur);
            this.traiteEntete.setVar_swiftBanqueFournisseur(this.var_swiftBanqueFournisseur);
            this.traiteEntete.setVar_tvaFournisseur(this.var_tvaFournisseur);
            var1.add(var2);
         }
      }

      JRBeanCollectionDataSource var4 = new JRBeanCollectionDataSource(var1);
      return var4;
   }

   public String calculeParc(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      return var2;
   }

   public void imprimer() throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      if (this.var_choix_modele == 0) {
         if (this.nomModeleDocument != null && !this.nomModeleDocument.isEmpty()) {
            Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Traites");
            this.var_compte = "";
            this.var_nomBanque = "";
            this.var_nomBanquier = "";
            this.var_adresseBanque = "";
            this.var_villeBanque = "";
            this.var_adresseFounisseur = "";
            this.var_compteFournisseur = "";
            this.var_nomBanqueFournisseur = "";
            this.var_adresseBanqueFournisseur = "";
            this.var_fonctionResponsable = "";
            this.var_ibanBanqueFournisseur = "";
            this.var_swiftBanqueFournisseur = "";
            this.var_tvaFournisseur = "";
            String[] var2;
            if (this.traiteEntete.getTrtBanque() != null && !this.traiteEntete.getTrtBanque().isEmpty() && this.traiteEntete.getTrtBanque().contains(":")) {
               var2 = this.traiteEntete.getTrtBanque().split(":");
               new ExercicesComptable();
               ExercicesComptableDao var4 = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
               ExercicesComptable var3 = var4.recupererLastExo(var1);
               if (var3 != null) {
                  new JournauxComptables();
                  JournauxComptablesDao var6 = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
                  JournauxComptables var5 = var6.chercherCode(var2[0], var3.getExecpt_id(), var1);
                  if (var5 != null) {
                     new Tiers();
                     Tiers var7 = this.tiersDao.selectTierSigle(var5.getPljCodeBanque(), var1);
                     if (var7 != null) {
                        this.var_compte = var5.getPljCodeBanque() + " " + var5.getPljCodeGuichet() + " " + var5.getPljNumeroCompte() + " " + var5.getPljCleRib();
                        this.var_nomBanque = var7.getTieraisonsocialenom();
                        this.var_nomBanquier = var5.getPljCiviliteGestionnaire() + " " + var5.getPljNomGestionnaire();
                        this.var_adresseBanque = var7.getTieadresse();
                        this.var_villeBanque = var7.getTieville();
                     }
                  }
               }
            }

            if (this.tiers != null) {
               this.var_adresseFounisseur = this.tiers.getTieadresse();
               this.var_compteFournisseur = this.tiers.getTienumbanque() + " " + this.tiers.getTieguichetbanque() + " " + this.tiers.getTiecomptebanque() + " " + this.tiers.getTieclebanque();
               this.var_nomBanqueFournisseur = this.tiers.getTienombanque();
               this.var_adresseBanqueFournisseur = this.tiers.getTieadressebanque();
               this.var_ibanBanqueFournisseur = this.tiers.getTieiban();
               this.var_swiftBanqueFournisseur = this.tiers.getTieswift();
               this.var_tvaFournisseur = this.tiers.getTienum6();
            }

            if (this.traiteEntete.getTrtIdResponsable() != 0L) {
               new Users();
               Users var14 = this.userDao.selectLeUserId(this.traiteEntete.getTrtIdResponsable(), var1);
               if (var14 != null) {
                  this.var_fonctionResponsable = var14.getUsrFonction();
               }
            }

            var2 = null;

            try {
               Transaction var15 = var1.beginTransaction();
               this.traiteEntete.setTrtDateImpression(new Date());
               if (this.traiteEntete.getTrtEtat() == 0 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 1) {
                  this.traiteEntete.setTrtEtat(1);
               }

               this.traiteEntete.setTrtModeleImp(this.nomModeleDocument);
               this.traiteEntete = this.traiteEnteteDao.modif(this.traiteEntete, var1);
               var15.commit();
            } catch (HibernateException var11) {
               if (var2 != null) {
                  var2.rollback();
               }

               throw var11;
            } finally {
               this.utilInitHibernate.closeSession();
            }

            this.utilPrint.setjRBeanCollectionDataSource(this.calculeImpressionCommun());
            String var16 = this.utilNombre.begin(this.traiteEntete.getTrtMontant(), this.traiteEntete.getTrtDevise());
            String var17 = this.utilNombre.begin(this.traiteEntete.getTrtMontantLocal(), this.structureLog.getStrdevise());
            this.utilPrint.setRapport(this.nomModeleDocument);
            this.utilPrint.setEntete("Impression de la traite");
            this.utilPrint.setMontant_lettre(var16);
            this.utilPrint.setMontant_lettre_local(var17);
            this.utilPrint.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid(), this.nomRepMod));
            this.utilPrint.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            this.utilPrint.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid(), this.traiteEntete.getTrtEtat()));
            this.utilPrint.setFormat(this.format);
            this.utilPrint.setEmetteur(this.impEmetteur);
            this.utilPrint.setDestinataire(this.impDestinataire);
            this.utilPrint.setDestinataireCC(this.impDestinataireCC);
            this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
            this.utilPrint.setTiersSelectionne(this.tiers);
            this.utilPrint.setBaseLog(this.baseLog);
            this.utilPrint.setStructureLog(this.structureLog);
            this.utilPrint.setUsersLog(this.usersLog);
            this.utilPrint.imprimeRapport();
         }
      } else if (this.nomModeleListe != null && !this.nomModeleListe.isEmpty()) {
         this.utilPrint.setRapport(this.nomModeleListe);
         this.utilPrint.setEntete("Impression de la liste des traites");
         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "liste" + File.separator);
         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "sous_rapport" + File.separator);
         this.utilPrint.setFormat(this.format);
         this.utilPrint.setEmetteur(this.impEmetteur);
         this.utilPrint.setDestinataire(this.impDestinataire);
         this.utilPrint.setDestinataireCC(this.impDestinataireCC);
         this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
         this.utilPrint.setIdResponsable(0L);
         this.utilPrint.setTiersSelectionne((Tiers)null);
         this.utilPrint.setNature(this.nature);
         this.utilPrint.setId_doc(0L);
         JRBeanCollectionDataSource var13 = new JRBeanCollectionDataSource(this.lesTraites);
         this.utilPrint.setjRBeanCollectionDataSource(var13);
         this.utilPrint.setBaseLog(this.baseLog);
         this.utilPrint.setStructureLog(this.structureLog);
         this.utilPrint.setUsersLog(this.usersLog);
         this.utilPrint.imprimeRapport();
      }

   }

   public Date getDateDebut() {
      return this.dateDebut;
   }

   public void setDateDebut(Date var1) {
      this.dateDebut = var1;
   }

   public int getInpEtat() {
      return this.inpEtat;
   }

   public void setInpEtat(int var1) {
      this.inpEtat = var1;
   }

   public String getInpService() {
      return this.inpService;
   }

   public void setInpService(String var1) {
      this.inpService = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
   }

   public int getVar_action() {
      return this.var_action;
   }

   public void setVar_action(int var1) {
      this.var_action = var1;
   }

   public boolean isVar_ajt() {
      return this.var_ajt;
   }

   public void setVar_ajt(boolean var1) {
      this.var_ajt = var1;
   }

   public boolean isVar_imp() {
      return this.var_imp;
   }

   public void setVar_imp(boolean var1) {
      this.var_imp = var1;
   }

   public boolean isVar_mod() {
      return this.var_mod;
   }

   public void setVar_mod(boolean var1) {
      this.var_mod = var1;
   }

   public boolean isVar_sup() {
      return this.var_sup;
   }

   public void setVar_sup(boolean var1) {
      this.var_sup = var1;
   }

   public boolean isVisibiliteBton() {
      return this.visibiliteBton;
   }

   public void setVisibiliteBton(boolean var1) {
      this.visibiliteBton = var1;
   }

   public boolean isVisibleOnglet() {
      return this.visibleOnglet;
   }

   public void setVisibleOnglet(boolean var1) {
      this.visibleOnglet = var1;
   }

   public boolean isVar_affiche_valide() {
      return this.var_affiche_valide;
   }

   public void setVar_affiche_valide(boolean var1) {
      this.var_affiche_valide = var1;
   }

   public Tiers getTiers() {
      return this.tiers;
   }

   public void setTiers(Tiers var1) {
      this.tiers = var1;
   }

   public boolean isChampCltVide() {
      return this.champCltVide;
   }

   public void setChampCltVide(boolean var1) {
      this.champCltVide = var1;
   }

   public String getInputTypReglment() {
      return this.inputTypReglment;
   }

   public void setInputTypReglment(String var1) {
      this.inputTypReglment = var1;
   }

   public ExercicesCaisse getLastExo() {
      return this.lastExo;
   }

   public void setLastExo(ExercicesCaisse var1) {
      this.lastExo = var1;
   }

   public List getMesOnglets() {
      return this.mesOnglets;
   }

   public void setMesOnglets(List var1) {
      this.mesOnglets = var1;
   }

   public OptionCaisses getOptionCaisses() {
      return this.optionCaisses;
   }

   public void setOptionCaisses(OptionCaisses var1) {
      this.optionCaisses = var1;
   }

   public ExercicesCaisse getSelectedExo() {
      return this.selectedExo;
   }

   public void setSelectedExo(ExercicesCaisse var1) {
      this.selectedExo = var1;
   }

   public boolean isVar_acc_descriptif() {
      return this.var_acc_descriptif;
   }

   public void setVar_acc_descriptif(boolean var1) {
      this.var_acc_descriptif = var1;
   }

   public boolean isAffListeDoc() {
      return this.affListeDoc;
   }

   public void setAffListeDoc(boolean var1) {
      this.affListeDoc = var1;
   }

   public boolean isAffMail() {
      return this.affMail;
   }

   public void setAffMail(boolean var1) {
      this.affMail = var1;
   }

   public String getImpDestinataire() {
      return this.impDestinataire;
   }

   public void setImpDestinataire(String var1) {
      this.impDestinataire = var1;
   }

   public String getImpEmetteur() {
      return this.impEmetteur;
   }

   public void setImpEmetteur(String var1) {
      this.impEmetteur = var1;
   }

   public UtilPrint getUtilPrint() {
      return this.utilPrint;
   }

   public void setUtilPrint(UtilPrint var1) {
      this.utilPrint = var1;
   }

   public boolean isVisibleOptionMail() {
      return this.visibleOptionMail;
   }

   public void setVisibleOptionMail(boolean var1) {
      this.visibleOptionMail = var1;
   }

   public List getMesTypeTiers() {
      return this.mesTypeTiers;
   }

   public void setMesTypeTiers(List var1) {
      this.mesTypeTiers = var1;
   }

   public String getVar_modeReglement() {
      return this.var_modeReglement;
   }

   public void setVar_modeReglement(String var1) {
      this.var_modeReglement = var1;
   }

   public TraiteEntete getTraites() {
      return this.traiteEntete;
   }

   public void setTraites(TraiteEntete var1) {
      this.traiteEntete = var1;
   }

   public String getNomModeleDocument() {
      return this.nomModeleDocument;
   }

   public void setNomModeleDocument(String var1) {
      this.nomModeleDocument = var1;
   }

   public String getNomModeleListe() {
      return this.nomModeleListe;
   }

   public void setNomModeleListe(String var1) {
      this.nomModeleListe = var1;
   }

   public int getVar_choix_modele() {
      return this.var_choix_modele;
   }

   public void setVar_choix_modele(int var1) {
      this.var_choix_modele = var1;
   }

   public String getNomRepMod() {
      return this.nomRepMod;
   }

   public void setNomRepMod(String var1) {
      this.nomRepMod = var1;
   }

   public UsersChrono getUsersChrono() {
      return this.usersChrono;
   }

   public void setUsersChrono(UsersChrono var1) {
      this.usersChrono = var1;
   }

   public int getVar_nb_max() {
      return this.var_nb_max;
   }

   public void setVar_nb_max(int var1) {
      this.var_nb_max = var1;
   }

   public boolean isShowModalPanelPrint() {
      return this.showModalPanelPrint;
   }

   public void setShowModalPanelPrint(boolean var1) {
      this.showModalPanelPrint = var1;
   }

   public List getMesDepartementsItems() {
      return this.mesDepartementsItems;
   }

   public void setMesDepartementsItems(List var1) {
      this.mesDepartementsItems = var1;
   }

   public List getMesPdvItems() {
      return this.mesPdvItems;
   }

   public void setMesPdvItems(List var1) {
      this.mesPdvItems = var1;
   }

   public List getMesSecteursItems() {
      return this.mesSecteursItems;
   }

   public void setMesSecteursItems(List var1) {
      this.mesSecteursItems = var1;
   }

   public List getMesServicesItems() {
      return this.mesServicesItems;
   }

   public void setMesServicesItems(List var1) {
      this.mesServicesItems = var1;
   }

   public boolean isVar_activite() {
      return this.var_activite;
   }

   public void setVar_activite(boolean var1) {
      this.var_activite = var1;
   }

   public boolean isVar_budget() {
      return this.var_budget;
   }

   public void setVar_budget(boolean var1) {
      this.var_budget = var1;
   }

   public boolean isVar_departement() {
      return this.var_departement;
   }

   public void setVar_departement(boolean var1) {
      this.var_departement = var1;
   }

   public boolean isVar_dossier() {
      return this.var_dossier;
   }

   public void setVar_dossier(boolean var1) {
      this.var_dossier = var1;
   }

   public boolean isVar_parc() {
      return this.var_parc;
   }

   public void setVar_parc(boolean var1) {
      this.var_parc = var1;
   }

   public boolean isVar_pdv() {
      return this.var_pdv;
   }

   public void setVar_pdv(boolean var1) {
      this.var_pdv = var1;
   }

   public boolean isVar_region() {
      return this.var_region;
   }

   public void setVar_region(boolean var1) {
      this.var_region = var1;
   }

   public boolean isVar_secteur() {
      return this.var_secteur;
   }

   public void setVar_secteur(boolean var1) {
      this.var_secteur = var1;
   }

   public boolean isVar_service() {
      return this.var_service;
   }

   public void setVar_service(boolean var1) {
      this.var_service = var1;
   }

   public boolean isVar_site() {
      return this.var_site;
   }

   public void setVar_site(boolean var1) {
      this.var_site = var1;
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

   public String getImpDestinataireCC() {
      return this.impDestinataireCC;
   }

   public void setImpDestinataireCC(String var1) {
      this.impDestinataireCC = var1;
   }

   public String getImpDestinataireCCI() {
      return this.impDestinataireCCI;
   }

   public void setImpDestinataireCCI(String var1) {
      this.impDestinataireCCI = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public TraiteEntete getTraiteEntete() {
      return this.traiteEntete;
   }

   public void setTraiteEntete(TraiteEntete var1) {
      this.traiteEntete = var1;
   }

   public double getMontantPaye() {
      return this.montantPaye;
   }

   public void setMontantPaye(double var1) {
      this.montantPaye = var1;
   }

   public double getMontantReste() {
      return this.montantReste;
   }

   public void setMontantReste(double var1) {
      this.montantReste = var1;
   }

   public int getNbDejaPaye() {
      return this.nbDejaPaye;
   }

   public void setNbDejaPaye(int var1) {
      this.nbDejaPaye = var1;
   }

   public DataModel getDataModelEcheance() {
      return this.dataModelEcheance;
   }

   public void setDataModelEcheance(DataModel var1) {
      this.dataModelEcheance = var1;
   }

   public DataModel getDatamodelTraite() {
      return this.datamodelTraite;
   }

   public void setDatamodelTraite(DataModel var1) {
      this.datamodelTraite = var1;
   }

   public String getVar_intitule() {
      return this.var_intitule;
   }

   public void setVar_intitule(String var1) {
      this.var_intitule = var1;
   }

   public DataModel getDataModelDepot() {
      return this.dataModelDepot;
   }

   public void setDataModelDepot(DataModel var1) {
      this.dataModelDepot = var1;
   }

   public String getDte1Affichage() {
      return this.dte1Affichage;
   }

   public void setDte1Affichage(String var1) {
      this.dte1Affichage = var1;
   }

   public String getDte2Affichage() {
      return this.dte2Affichage;
   }

   public void setDte2Affichage(String var1) {
      this.dte2Affichage = var1;
   }

   public int getTypeVente() {
      return this.typeVente;
   }

   public void setTypeVente(int var1) {
      this.typeVente = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public String getVar_banque() {
      return this.var_banque;
   }

   public void setVar_banque(String var1) {
      this.var_banque = var1;
   }

   public Date getDateDepot() {
      return this.dateDepot;
   }

   public void setDateDepot(Date var1) {
      this.dateDepot = var1;
   }

   public Date getDateFin() {
      return this.dateFin;
   }

   public void setDateFin(Date var1) {
      this.dateFin = var1;
   }

   public Date getDateRepport() {
      return this.dateRepport;
   }

   public void setDateRepport(Date var1) {
      this.dateRepport = var1;
   }

   public Date getDateRetour() {
      return this.dateRetour;
   }

   public void setDateRetour(Date var1) {
      this.dateRetour = var1;
   }

   public String getVar_bordereau() {
      return this.var_bordereau;
   }

   public void setVar_bordereau(String var1) {
      this.var_bordereau = var1;
   }

   public String getVar_motif() {
      return this.var_motif;
   }

   public void setVar_motif(String var1) {
      this.var_motif = var1;
   }

   public String getUserCreateur() {
      return this.userCreateur;
   }

   public void setUserCreateur(String var1) {
      this.userCreateur = var1;
   }

   public String getUserModification() {
      return this.userModification;
   }

   public void setUserModification(String var1) {
      this.userModification = var1;
   }

   public long getUserResponsable() {
      return this.userResponsable;
   }

   public void setUserResponsable(long var1) {
      this.userResponsable = var1;
   }

   public boolean isDeviseLocale() {
      return this.deviseLocale;
   }

   public void setDeviseLocale(boolean var1) {
      this.deviseLocale = var1;
   }

   public double getMontantPayeLocal() {
      return this.montantPayeLocal;
   }

   public void setMontantPayeLocal(double var1) {
      this.montantPayeLocal = var1;
   }

   public double getMontantResteLocal() {
      return this.montantResteLocal;
   }

   public void setMontantResteLocal(double var1) {
      this.montantResteLocal = var1;
   }

   public boolean isVar_cle() {
      return this.var_cle;
   }

   public void setVar_cle(boolean var1) {
      this.var_cle = var1;
   }

   public UIDataTable getExtDTable() {
      return this.extDTable;
   }

   public void setExtDTable(UIDataTable var1) {
      this.extDTable = var1;
   }

   public SimpleSelection getSimpleSelectionEntete() {
      return this.simpleSelectionEntete;
   }

   public void setSimpleSelectionEntete(SimpleSelection var1) {
      this.simpleSelectionEntete = var1;
   }
}
