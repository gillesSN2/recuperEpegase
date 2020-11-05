package com.epegase.forms.administration;

import com.epegase.systeme.classe.Contacts;
import com.epegase.systeme.classe.Devise;
import com.epegase.systeme.classe.Ecritures;
import com.epegase.systeme.classe.EcrituresAnalytique;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.JournauxComptables;
import com.epegase.systeme.classe.PlanComptable;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.ContactDao;
import com.epegase.systeme.dao.DeviseDao;
import com.epegase.systeme.dao.EcrituresAnalytiquesDao;
import com.epegase.systeme.dao.EcrituresDao;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.ProjetsDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilTrie;
import com.epegase.systeme.xml.LectureCivilites;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
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
import org.jdom.JDOMException;

public class FormJournauxComptables implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private String enteteModal;
   private boolean estModalModif;
   private String devisePays;
   private boolean libreChoiDev;
   private boolean afficheChoiDev;
   private Devise devise;
   private List mesdevises = new ArrayList();
   private List mesdevisesItem;
   private DeviseDao deviseDao;
   private int desactiveModif;
   private boolean inactifModif;
   private boolean inpInactifAj;
   private int inactif;
   private boolean existCod = true;
   private boolean afficheButtSupp;
   private boolean afficheButtModif;
   private boolean afficheReserve = false;
   private String langue;
   private JournauxComptables journauxComptables = new JournauxComptables();
   private List lesjournauxComptables = new ArrayList();
   private PlanComptable planComptable;
   private transient DataModel datamodel = new ListDataModel();
   private boolean testAffBSuppMod;
   private List lesComptesTresoItem = new ArrayList();
   private boolean testCompteTreso;
   private JournauxComptablesDao journauxComptablesDao;
   private ExercicesComptableDao exercicesComptableDao;
   private EcrituresDao ecrituresDao;
   private boolean afficheButtAjout;
   private ExercicesComptable exoSelectionne;
   private ExercicesComptable lastExercice;
   private boolean disable;
   private boolean testPljDv;
   private boolean modalPAjout;
   private boolean afficheAjDefaut = false;
   private List mesCivilitesItems;
   private List lesProjetsItems;
   private ProjetsDao projetsDao;
   private boolean projetActif = false;
   private int choixRacine;
   private String selecFiscalite;
   private List lesAnneesItems;
   private long annee;

   public FormJournauxComptables() {
      this.mesdevises = new ArrayList();
      this.mesdevisesItem = new ArrayList();
      this.testPljDv = false;
      this.lesProjetsItems = new ArrayList();
      this.mesCivilitesItems = new ArrayList();
      this.lesAnneesItems = new ArrayList();
   }

   public void InstancesDaoUtilses() {
      this.journauxComptablesDao = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
      this.exercicesComptableDao = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
      this.ecrituresDao = new EcrituresDao(this.baseLog, this.utilInitHibernate);
      this.deviseDao = new DeviseDao(this.baseLog, this.utilInitHibernate);
      this.projetsDao = new ProjetsDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerLesJournauxComptables(Session var1) throws HibernateException, NamingException, IOException {
      this.lesjournauxComptables.clear();
      this.lesjournauxComptables = this.journauxComptablesDao.chargerLesJournauxComptables(this.exoSelectionne.getExecpt_id(), this.usersLog.getUsrJrxReserve(), var1);
      this.datamodel.setWrappedData(this.lesjournauxComptables);
      new ArrayList();
      List var2 = this.exercicesComptableDao.selectExercicesCompta(var1);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            this.lesAnneesItems.add(new SelectItem(((ExercicesComptable)var2.get(var3)).getExecpt_id()));
         }
      }

      new ExercicesComptable();
      ExercicesComptable var6 = this.exercicesComptableDao.recupererLastExo(var1);
      if (var6 != null) {
         this.annee = var6.getExecpt_id();
         this.lastExercice = var6;
      } else {
         this.annee = 0L;
         this.lastExercice = null;
      }

      this.exoSelectionne = this.lastExercice;
      if (this.exoSelectionne.getExecpt_id() == this.exoSelectionne.getExecpt_id()) {
         this.afficheButtAjout = true;
      } else {
         this.afficheButtAjout = false;
      }

      if (this.usersLog.getUsrJrxReserve() == 0) {
         this.afficheReserve = true;
      } else {
         this.afficheReserve = false;
      }

      boolean var4 = false;
      Object var5 = var1.createQuery("SELECT COUNT(*) FROM JournauxComptables where exercice.execpt_id=" + this.lastExercice.getExecpt_id()).uniqueResult();
      int var7 = Integer.parseInt(var5.toString());
      if (var7 > 0) {
         this.afficheAjDefaut = false;
      } else {
         this.afficheAjDefaut = true;
      }

      this.projetActif = false;
      if (this.structureLog.getStrmod1() != null && !this.structureLog.getStrmod1().isEmpty() && this.structureLog.getStrmod1().equals("40300")) {
         this.projetActif = true;
      } else if (this.structureLog.getStrmod2() != null && !this.structureLog.getStrmod2().isEmpty() && this.structureLog.getStrmod2().equals("40300")) {
         this.projetActif = true;
      } else if (this.structureLog.getStrmod3() != null && !this.structureLog.getStrmod3().isEmpty() && this.structureLog.getStrmod3().equals("40300")) {
         this.projetActif = true;
      } else if (this.structureLog.getStrmod4() != null && !this.structureLog.getStrmod4().isEmpty() && this.structureLog.getStrmod4().equals("40300")) {
         this.projetActif = true;
      } else if (this.structureLog.getStrmod5() != null && !this.structureLog.getStrmod5().isEmpty() && this.structureLog.getStrmod5().equals("40300")) {
         this.projetActif = true;
      } else if (this.structureLog.getStrmod6() != null && !this.structureLog.getStrmod6().isEmpty() && this.structureLog.getStrmod6().equals("40300")) {
         this.projetActif = true;
      } else if (this.structureLog.getStrmod7() != null && !this.structureLog.getStrmod7().isEmpty() && this.structureLog.getStrmod7().equals("40300")) {
         this.projetActif = true;
      } else if (this.structureLog.getStrmod8() != null && !this.structureLog.getStrmod8().isEmpty() && this.structureLog.getStrmod8().equals("40300")) {
         this.projetActif = true;
      } else if (this.structureLog.getStrmod9() != null && !this.structureLog.getStrmod9().isEmpty() && this.structureLog.getStrmod9().equals("40300")) {
         this.projetActif = true;
      } else if (this.structureLog.getStrmod10() != null && !this.structureLog.getStrmod10().isEmpty() && this.structureLog.getStrmod10().equals("40300")) {
         this.projetActif = true;
      }

      if (this.projetActif) {
         this.lesProjetsItems = this.projetsDao.chargerLesProjets(0, var1);
      }

      this.recupererLesDevise(var1);
      this.recupererCivilitesItem();
   }

   public void selectionChargement() throws IOException, HibernateException, NamingException {
      if (this.annee == 0L) {
         this.annee = this.lastExercice.getExecpt_id();
      }

      this.exoSelectionne = this.exercicesComptableDao.recupererLExoSelect(this.annee, (Session)null);
      if (this.exoSelectionne == null) {
         this.exoSelectionne = this.lastExercice;
      }

      this.lesjournauxComptables.clear();
      this.lesjournauxComptables = this.journauxComptablesDao.chargerLesJournauxComptables(this.exoSelectionne.getExecpt_id(), this.usersLog.getUsrJrxReserve(), (Session)null);
      this.datamodel.setWrappedData(this.lesjournauxComptables);
      if (this.exoSelectionne == null) {
         this.afficheButtAjout = false;
      } else if (this.exoSelectionne.getExecptEtat() != 0) {
         this.afficheButtAjout = false;
      } else {
         this.afficheButtAjout = true;
      }

      if (this.lesjournauxComptables.size() != 0) {
         this.afficheAjDefaut = false;
      } else {
         this.afficheAjDefaut = true;
      }

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

   }

   public void recupererCivilitesItem() throws IOException {
      this.mesCivilitesItems = new ArrayList();
      LectureCivilites var1 = new LectureCivilites(0);
      this.mesCivilitesItems = var1.getMesCivilitesItems();
   }

   public void selectionLigne() throws HibernateException, NamingException {
      if (this.datamodel.isRowAvailable()) {
         this.journauxComptables = (JournauxComptables)this.datamodel.getRowData();
         this.inpInactifAj = this.recupererInactifModif();
         int var1 = this.journauxComptables.getPljInactif();
         if (this.exoSelectionne.getExecptEtat() == 0 && var1 == 0) {
            this.afficheButtModif = true;
         } else {
            this.afficheButtModif = false;
         }

         this.afficheButtSupp = this.verifMouvment();
      }

   }

   public boolean verifMouvment() throws HibernateException, NamingException {
      int var2 = this.journauxComptables.getPljInactif();
      boolean var1;
      if (var2 != 2) {
         var1 = this.ecrituresDao.verifMouvmentJr(this.journauxComptables.getPljCode(), this.exoSelectionne.getExecpt_id());
      } else {
         var1 = false;
      }

      return var1;
   }

   public void defaultAdd() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.journauxComptablesDao.ajoutParDefaut(this.exoSelectionne, this.structureLog.getStrzonefiscale(), this.structureLog, this.usersLog);
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "JournauxComptables");
      this.lesjournauxComptables.clear();
      this.lesjournauxComptables = this.journauxComptablesDao.chargerLesJournauxComptables(this.exoSelectionne.getExecpt_id(), this.usersLog.getUsrJrxReserve(), var1);
      this.datamodel.setWrappedData(this.lesjournauxComptables);
      this.utilInitHibernate.closeSession();
      this.afficheAjDefaut = false;
   }

   public void addJournal() throws HibernateException, NamingException {
      this.enteteModal = "Création d'un journal comptable";
      this.estModalModif = false;
      this.journauxComptables = new JournauxComptables();
      this.journauxComptables.setPljChoixDevise(this.devisePays);
      this.libreChoiDev = true;
      this.afficheChoiDev = true;
      this.inpInactifAj = false;
      this.modalPAjout = true;
      this.testCompteTreso = false;
   }

   public boolean verifierUniciterdecode() throws HibernateException, NamingException {
      this.existCod = this.journauxComptablesDao.existCode(this.journauxComptables.getPljCode(), this.exoSelectionne.getExecpt_id(), (Session)null);
      return this.existCod;
   }

   public void recupererLesDevise(Session var1) throws HibernateException, NamingException {
      this.mesdevisesItem = new ArrayList();
      this.mesdevisesItem = this.deviseDao.chargerLesDevisesUtiliseesItem(this.structureLog, var1);
   }

   public void modifJournal() throws HibernateException, NamingException {
      this.enteteModal = "Modification d'un journal comptable";
      this.modalPAjout = true;
      this.estModalModif = true;
      this.chargerLesComptesTreso();
      if (this.journauxComptables.getPljTypeDevise() == 1) {
         this.libreChoiDev = false;
      } else {
         this.libreChoiDev = true;
      }

      if (this.journauxComptables.getPljTypeDevise() == 2) {
         this.afficheChoiDev = false;
      } else {
         this.afficheChoiDev = true;
      }

      this.existCod = false;
   }

   public void removeSelectedJC() throws HibernateException, NamingException {
      this.journauxComptables = this.getJournauxComptables();
      this.journauxComptables.setPljInactif(2);
      this.journauxComptables = this.journauxComptablesDao.modif(this.journauxComptables);
   }

   public void chargerLesComptesTreso() throws HibernateException, NamingException {
      this.lesComptesTresoItem.clear();
      UtilTrie var1 = new UtilTrie();
      if (this.journauxComptables.getPljNature() != 7 && this.journauxComptables.getPljNature() != 8 && this.journauxComptables.getPljNature() != 9 && this.journauxComptables.getPljNature() != 10) {
         this.testCompteTreso = false;
      } else {
         Object var2 = new ArrayList();
         new ArrayList();
         if (this.journauxComptables.getPljCompteTreso() == null) {
            this.journauxComptables.setPljCompteTreso("");
         }

         this.testCompteTreso = true;
         List var3 = this.journauxComptablesDao.chargerLesComptesTreso(12, this.usersLog.getUsrJrxReserve(), this.exoSelectionne.getExecpt_id(), this.selecFiscalite, (Session)null);
         int var4;
         if (var3.size() != 0) {
            for(var4 = 0; var4 < var3.size(); ++var4) {
               ((List)var2).add(var3.get(var4));
            }
         }

         if (this.journauxComptables.getPljNature() != 7 && this.journauxComptables.getPljNature() != 8) {
            if (this.journauxComptables.getPljNature() == 9 || this.journauxComptables.getPljNature() == 10) {
               var3 = this.journauxComptablesDao.chargerLesComptesTreso(11, this.usersLog.getUsrJrxReserve(), this.exoSelectionne.getExecpt_id(), this.selecFiscalite, (Session)null);
               if (var3.size() != 0) {
                  for(var4 = 0; var4 < var3.size(); ++var4) {
                     ((List)var2).add(var3.get(var4));
                  }
               }
            }
         } else {
            var3 = this.journauxComptablesDao.chargerLesComptesTreso(10, this.usersLog.getUsrJrxReserve(), this.exoSelectionne.getExecpt_id(), this.selecFiscalite, (Session)null);
            if (var3.size() != 0) {
               for(var4 = 0; var4 < var3.size(); ++var4) {
                  ((List)var2).add(var3.get(var4));
               }
            }
         }

         if (((List)var2).size() != 0) {
            var2 = var1.triListeCompte((List)var2);
         }

         boolean var5;
         int var6;
         if (this.choixRacine <= 1) {
            for(var4 = 0; var4 < ((List)var2).size(); ++var4) {
               if (this.journauxComptables.getPljCompteTreso() != null && !this.journauxComptables.getPljCompteTreso().isEmpty() && this.journauxComptables.getPljCompteTreso().equalsIgnoreCase(((PlanComptable)((List)var2).get(var4)).getPlcCompte())) {
                  this.journauxComptables.setPljCompteTreso(((PlanComptable)((List)var2).get(var4)).getPlcCompte() + ":" + ((PlanComptable)((List)var2).get(var4)).getPlcLibelleCpteFR());
                  this.lesComptesTresoItem.add(new SelectItem(((PlanComptable)((List)var2).get(var4)).getPlcCompte() + ":" + ((PlanComptable)((List)var2).get(var4)).getPlcLibelleCpteFR()));
               } else {
                  var5 = false;
                  if (this.lesjournauxComptables.size() == 0) {
                     this.lesComptesTresoItem.add(new SelectItem(((PlanComptable)((List)var2).get(var4)).getPlcCompte() + ":" + ((PlanComptable)((List)var2).get(var4)).getPlcLibelleCpteFR()));
                  } else {
                     for(var6 = 0; var6 < this.lesjournauxComptables.size(); ++var6) {
                        if (((JournauxComptables)this.lesjournauxComptables.get(var6)).getPljCompteTreso() != null && !((JournauxComptables)this.lesjournauxComptables.get(var6)).getPljCompteTreso().isEmpty() && ((JournauxComptables)this.lesjournauxComptables.get(var6)).getPljCompteTreso().equalsIgnoreCase(((PlanComptable)((List)var2).get(var4)).getPlcCompte())) {
                           var5 = true;
                           break;
                        }
                     }

                     if (!var5) {
                        this.lesComptesTresoItem.add(new SelectItem(((PlanComptable)((List)var2).get(var4)).getPlcCompte() + ":" + ((PlanComptable)((List)var2).get(var4)).getPlcLibelleCpteFR()));
                     }
                  }
               }
            }
         } else {
            for(var4 = 0; var4 < ((List)var2).size(); ++var4) {
               if (this.journauxComptables.getPljCompteTresoNew() != null && !this.journauxComptables.getPljCompteTresoNew().isEmpty() && this.journauxComptables.getPljCompteTresoNew().equalsIgnoreCase(((PlanComptable)((List)var2).get(var4)).getPlcCompte())) {
                  this.journauxComptables.setPljCompteTresoNew(((PlanComptable)((List)var2).get(var4)).getPlcCompte() + ":" + ((PlanComptable)((List)var2).get(var4)).getPlcLibelleCpteFR());
                  this.lesComptesTresoItem.add(new SelectItem(((PlanComptable)((List)var2).get(var4)).getPlcCompte() + ":" + ((PlanComptable)((List)var2).get(var4)).getPlcLibelleCpteFR()));
               } else {
                  var5 = false;
                  if (this.lesjournauxComptables.size() == 0) {
                     this.lesComptesTresoItem.add(new SelectItem(((PlanComptable)((List)var2).get(var4)).getPlcCompte() + ":" + ((PlanComptable)((List)var2).get(var4)).getPlcLibelleCpteFR()));
                  } else {
                     for(var6 = 0; var6 < this.lesjournauxComptables.size(); ++var6) {
                        if (((JournauxComptables)this.lesjournauxComptables.get(var6)).getPljCompteTresoNew() != null && !((JournauxComptables)this.lesjournauxComptables.get(var6)).getPljCompteTresoNew().isEmpty() && ((JournauxComptables)this.lesjournauxComptables.get(var6)).getPljCompteTresoNew().equalsIgnoreCase(((PlanComptable)((List)var2).get(var4)).getPlcCompte())) {
                           var5 = true;
                           break;
                        }
                     }

                     if (!var5) {
                        this.lesComptesTresoItem.add(new SelectItem(((PlanComptable)((List)var2).get(var4)).getPlcCompte() + ":" + ((PlanComptable)((List)var2).get(var4)).getPlcLibelleCpteFR()));
                     }
                  }
               }
            }
         }
      }

      this.controleDatedeValeur();
   }

   public void controleDatedeValeur() {
      if (this.journauxComptables.getPljNature() != 7 && this.journauxComptables.getPljNature() != 8) {
         this.testPljDv = false;
      } else {
         this.testPljDv = true;
      }

   }

   public void valider() throws HibernateException, NamingException {
      this.journauxComptables.setPljCode(this.journauxComptables.getPljCode().toUpperCase());
      if (this.testCompteTreso) {
         String[] var1;
         if (this.choixRacine <= 1) {
            if (this.journauxComptables.getPljCompteTreso() != null && !this.journauxComptables.getPljCompteTreso().isEmpty() && this.journauxComptables.getPljCompteTreso().contains(":")) {
               var1 = this.journauxComptables.getPljCompteTreso().split(":");
               this.journauxComptables.setPljCompteTreso(var1[0]);
            } else {
               this.journauxComptables.setPljCompteTreso("");
            }
         } else if (this.journauxComptables.getPljCompteTresoNew() != null && !this.journauxComptables.getPljCompteTresoNew().isEmpty() && this.journauxComptables.getPljCompteTresoNew().contains(":")) {
            var1 = this.journauxComptables.getPljCompteTresoNew().split(":");
            this.journauxComptables.setPljCompteTresoNew(var1[0]);
         } else {
            this.journauxComptables.setPljCompteTresoNew("");
         }
      } else {
         this.journauxComptables.setPljCompteTreso("");
      }

      if (this.journauxComptables.getPljTypeDevise() == 2) {
         this.journauxComptables.setPljChoixDevise("");
         this.journauxComptables.setPljFormatDevise(0);
      } else if (this.journauxComptables.getPljChoixDevise() != null && !this.journauxComptables.getPljChoixDevise().isEmpty()) {
         if (this.journauxComptables.getPljChoixDevise().equalsIgnoreCase(this.structureLog.getStrdevise())) {
            this.journauxComptables.setPljFormatDevise(this.structureLog.getStrformatdevise());
         } else if (!this.journauxComptables.getPljChoixDevise().equalsIgnoreCase("XOF") && !this.journauxComptables.getPljChoixDevise().equalsIgnoreCase("XAF")) {
            if (!this.journauxComptables.getPljChoixDevise().equalsIgnoreCase("EUR") && !this.journauxComptables.getPljChoixDevise().equalsIgnoreCase("CHF")) {
               this.journauxComptables.setPljFormatDevise(0);
            } else {
               this.journauxComptables.setPljFormatDevise(1);
            }
         } else {
            this.journauxComptables.setPljFormatDevise(2);
         }
      } else {
         this.journauxComptables.setPljChoixDevise(this.structureLog.getStrdevise());
         this.journauxComptables.setPljFormatDevise(this.structureLog.getStrformatdevise());
      }

      if (this.journauxComptables.getPljId() == 0L) {
         this.journauxComptables.setPljDateCreat(new Date());
         this.journauxComptables.setPljUserCreat(this.usersLog.getUsrid());
         this.journauxComptables.setPljInactif(this.getInactif());
         this.journauxComptables.setExercice(this.exoSelectionne);
         this.journauxComptables = this.journauxComptablesDao.save(this.journauxComptables);
         this.lesjournauxComptables.add(this.journauxComptables);
         this.datamodel.setWrappedData(this.lesjournauxComptables);
      } else {
         this.journauxComptables.setPljDateModif(new Date());
         this.journauxComptables.setPljUserModif(this.usersLog.getUsrid());
         this.journauxComptables.setPljInactif(this.getDesactiveModif());
         this.journauxComptables = this.journauxComptablesDao.modif(this.journauxComptables);
      }

      TiersDao var2;
      if ((this.journauxComptables.getPljNature() == 7 || this.journauxComptables.getPljNature() == 8) && this.journauxComptables.getPljCodeBanque() != null && !this.journauxComptables.getPljCodeBanque().isEmpty()) {
         this.journauxComptables.setPljCodeBanque(this.journauxComptables.getPljCodeBanque().toUpperCase());
         new Tiers();
         var2 = new TiersDao(this.baseLog, this.utilInitHibernate);
         Tiers var13 = var2.selectTierSigle(this.journauxComptables.getPljCodeBanque(), (Session)null);
         if (var13 == null) {
            var13 = new Tiers();
            var13.setTiesigle(this.journauxComptables.getPljCodeBanque());
            var13.setTieraisonsocialenom(this.journauxComptables.getPljLibelleFr());
            var13.setTietype("0");
            var13.setTiegenre("001");
            var13.setTiecategorie("Banque");
            var13.setTieville(this.structureLog.getStrville());
            var13.setTienompays(this.structureLog.getStrnompays());
            var13.setTiecodepays(this.structureLog.getStrcodepays());
            var13.setTiedevise(this.structureLog.getStrdevise());
            var13.setTieFormatDevise(this.structureLog.getStrformatdevise());
            var13 = var2.insert(var13);
         }

         new Contacts();
         ContactDao var4 = new ContactDao(this.baseLog, this.utilInitHibernate);
         Contacts var3 = var4.chargerLesContactsbyJournal(this.journauxComptables.getPljCode(), (Session)null);
         if (var3 == null) {
            var3 = new Contacts();
         }

         var3.setTiers(var13);
         var3.setConJournal(this.journauxComptables.getPljCode());
         var3.setConnumbanque(this.journauxComptables.getPljCodeBanque());
         var3.setConguichetbanque(this.journauxComptables.getPljCodeGuichet());
         var3.setConcomptebanque(this.journauxComptables.getPljNumeroCompte());
         var3.setConclebanque(this.journauxComptables.getPljCleRib());
         var3.setConiban(this.journauxComptables.getPljIban());
         var3.setConswift(this.journauxComptables.getPljSwift());
         var3.setConcivilite(this.journauxComptables.getPljCiviliteGestionnaire());
         var3.setConnom(this.journauxComptables.getPljNomGestionnaire());
         var3.setConprenom(this.journauxComptables.getPljPrenomGestionnaire());
         var3.setContelbur(this.journauxComptables.getPljTelephoneGestionnaire());
         var3.setConmail1(this.journauxComptables.getPljMailGestionnaire());
         if (var3.getConid() == 0L) {
            var4.insert(var3);
         } else {
            var4.modif(var3);
         }
      }

      Session var15 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
      var2 = null;

      try {
         Transaction var14 = var15.beginTransaction();
         new ArrayList();
         EcrituresAnalytiquesDao var17 = new EcrituresAnalytiquesDao(this.baseLog, this.utilInitHibernate);
         List var16 = var17.chargerLesEcrituresAnalytiquesByJournal(this.exoSelectionne.getExecptDateDebut(), this.exoSelectionne.getExecptDateFin(), this.journauxComptables.getPljCode(), var15);
         if (var16.size() != 0) {
            new EcrituresAnalytique();

            for(int var6 = 0; var6 < var16.size(); ++var6) {
               EcrituresAnalytique var5 = (EcrituresAnalytique)var16.get(var6);
               var5.setEcranaNatureJrx(this.journauxComptables.getPljNature());
               var5.setEcranaReserve(this.journauxComptables.getPljReserve());
               var17.modifEcritureAnalytiques(var15, var5);
            }
         }

         new ArrayList();
         List var18 = this.ecrituresDao.chargerLesEcrituresByCodeJr(this.exoSelectionne.getExecpt_id(), this.journauxComptables.getPljCode(), var15);
         if (var18.size() != 0) {
            new Ecritures();

            for(int var7 = 0; var7 < var18.size(); ++var7) {
               Ecritures var19 = (Ecritures)var18.get(var7);
               var19.setEcrNatureJrx(this.journauxComptables.getPljNature());
               var19.setEcrReserve(this.journauxComptables.getPljReserve());
               this.ecrituresDao.modif(var19, var15);
            }
         }

         var14.commit();
      } catch (HibernateException var11) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var11;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.modalPAjout = false;
      this.afficheAjDefaut = false;
   }

   public void reactiverCompte() throws HibernateException, NamingException {
      this.journauxComptables = this.getJournauxComptables();
      this.journauxComptables.setPljInactif(0);
      this.journauxComptables = this.journauxComptablesDao.modif(this.journauxComptables);
      this.lesjournauxComptables = this.getLesjournauxComptables();
   }

   public void fermerModalPanelAjout() {
      this.modalPAjout = false;
   }

   public void chargerDevise() {
      if (this.journauxComptables.getPljTypeDevise() == 0) {
         this.journauxComptables.setPljChoixDevise(this.devisePays);
      }

      if (this.journauxComptables.getPljTypeDevise() == 1) {
         this.setLibreChoiDev(false);
      } else {
         this.setLibreChoiDev(true);
      }

      if (this.journauxComptables.getPljTypeDevise() == 2) {
         this.afficheChoiDev = false;
      } else {
         this.afficheChoiDev = true;
      }

   }

   public boolean isTestAffBSuppMod() {
      return this.testAffBSuppMod;
   }

   public void setTestAffBSuppMod(boolean var1) {
      this.testAffBSuppMod = var1;
   }

   public List getLesComptesTresoItem() {
      return this.lesComptesTresoItem;
   }

   public void setLesComptesTresoItem(List var1) {
      this.lesComptesTresoItem = var1;
   }

   public List getLesjournauxComptables() {
      return this.lesjournauxComptables;
   }

   public void setLesjournauxComptables(List var1) {
      this.lesjournauxComptables = var1;
   }

   public boolean isTestCompteTreso() {
      return this.testCompteTreso;
   }

   public void setTestCompteTreso(boolean var1) {
      this.testCompteTreso = var1;
   }

   public String getEnteteModal() {
      return this.enteteModal;
   }

   public void setEnteteModal(String var1) {
      this.enteteModal = var1;
   }

   public JournauxComptables getJournauxComptables() {
      return this.journauxComptables;
   }

   public void setJournauxComptables(JournauxComptables var1) {
      this.journauxComptables = var1;
   }

   public PlanComptable getPlanComptable() {
      return this.planComptable;
   }

   public void setPlanComptable(PlanComptable var1) {
      this.planComptable = var1;
   }

   public boolean isAfficheButtModif() {
      return this.afficheButtModif;
   }

   public void setAfficheButtModif(boolean var1) {
      this.afficheButtModif = var1;
   }

   public boolean isAfficheButtSupp() {
      return this.afficheButtSupp;
   }

   public void setAfficheButtSupp(boolean var1) {
      this.afficheButtSupp = var1;
   }

   public boolean existeCode(String var1) throws HibernateException, NamingException {
      return this.journauxComptablesDao.existCode(var1, this.exoSelectionne.getExecpt_id(), (Session)null);
   }

   public boolean isExistCod() {
      return this.existCod;
   }

   public void setExistCod(boolean var1) {
      this.existCod = var1;
   }

   public boolean isInpInactifAj() {
      return this.inpInactifAj;
   }

   public void setInpInactifAj(boolean var1) {
      this.inpInactifAj = var1;
   }

   public int getInactif() {
      this.inpInactifAj = this.isInpInactifAj();
      if (!this.inpInactifAj) {
         this.inactif = 0;
      } else {
         this.inactif = 1;
      }

      return this.inactif;
   }

   public void setInactif(int var1) {
      this.inactif = var1;
   }

   public boolean recupererInactifModif() {
      return this.journauxComptables.getPljInactif() != 0;
   }

   public boolean isInactifModif() {
      return this.inactifModif;
   }

   public void setInactifModif(boolean var1) {
      this.inactifModif = var1;
   }

   public int getDesactiveModif() {
      if (!this.inpInactifAj) {
         this.desactiveModif = 0;
      } else {
         this.desactiveModif = 1;
      }

      return this.desactiveModif;
   }

   public void setDesactiveModif(int var1) {
      this.desactiveModif = var1;
   }

   public List getMesdevises() {
      return this.mesdevises;
   }

   public void setMesdevises(List var1) {
      this.mesdevises = var1;
   }

   public List getMesdevisesItem() {
      return this.mesdevisesItem;
   }

   public void setMesdevisesItem(List var1) {
      this.mesdevisesItem = var1;
   }

   public boolean isAfficheButtAjout() {
      return this.afficheButtAjout;
   }

   public void setAfficheButtAjout(boolean var1) {
      this.afficheButtAjout = var1;
   }

   public ExercicesComptable getExoSelectionne() {
      return this.exoSelectionne;
   }

   public void setExoSelectionne(ExercicesComptable var1) {
      this.exoSelectionne = var1;
   }

   public boolean isDisable() {
      return this.disable;
   }

   public void setDisable(boolean var1) {
      this.disable = var1;
   }

   public boolean isTestPljDv() {
      return this.testPljDv;
   }

   public void setTestPljDv(boolean var1) {
      this.testPljDv = var1;
   }

   public boolean isModalPAjout() {
      return this.modalPAjout;
   }

   public void setModalPAjout(boolean var1) {
      this.modalPAjout = var1;
   }

   public Devise getDevise() {
      return this.devise;
   }

   public void setDevise(Devise var1) {
      this.devise = var1;
   }

   public boolean isLibreChoiDev() {
      return this.libreChoiDev;
   }

   public void setLibreChoiDev(boolean var1) {
      this.libreChoiDev = var1;
   }

   public String getDevisePays() {
      return this.devisePays;
   }

   public void setDevisePays(String var1) {
      this.devisePays = var1;
   }

   public boolean isAfficheChoiDev() {
      return this.afficheChoiDev;
   }

   public void setAfficheChoiDev(boolean var1) {
      this.afficheChoiDev = var1;
   }

   public boolean isEstModalModif() {
      return this.estModalModif;
   }

   public void setEstModalModif(boolean var1) {
      this.estModalModif = var1;
   }

   public DataModel getDatamodel() {
      return this.datamodel;
   }

   public void setDatamodel(DataModel var1) {
      this.datamodel = var1;
   }

   public ExercicesComptable getLastExercice() {
      return this.lastExercice;
   }

   public void setLastExercice(ExercicesComptable var1) {
      this.lastExercice = var1;
   }

   public String getLangue() {
      return this.langue;
   }

   public void setLangue(String var1) {
      this.langue = var1;
   }

   public boolean isAfficheReserve() {
      return this.afficheReserve;
   }

   public void setAfficheReserve(boolean var1) {
      this.afficheReserve = var1;
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

   public boolean isAfficheAjDefaut() {
      return this.afficheAjDefaut;
   }

   public void setAfficheAjDefaut(boolean var1) {
      this.afficheAjDefaut = var1;
   }

   public List getLesProjetsItems() {
      return this.lesProjetsItems;
   }

   public void setLesProjetsItems(List var1) {
      this.lesProjetsItems = var1;
   }

   public boolean isProjetActif() {
      return this.projetActif;
   }

   public void setProjetActif(boolean var1) {
      this.projetActif = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public List getMesCivilitesItems() {
      return this.mesCivilitesItems;
   }

   public void setMesCivilitesItems(List var1) {
      this.mesCivilitesItems = var1;
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

   public long getAnnee() {
      return this.annee;
   }

   public void setAnnee(long var1) {
      this.annee = var1;
   }

   public List getLesAnneesItems() {
      return this.lesAnneesItems;
   }

   public void setLesAnneesItems(List var1) {
      this.lesAnneesItems = var1;
   }
}
