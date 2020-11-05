package com.epegase.forms.comptabilite;

import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.JournauxComptables;
import com.epegase.systeme.classe.PlanComptable;
import com.epegase.systeme.classe.Projets;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.EcrituresBalance;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.PlanComptableDao;
import com.epegase.systeme.dao.ProjetsDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.OptionComptabilite;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.jdom.JDOMException;

public class FormImpressionProjet implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private ExercicesComptable exoSelectionne;
   private OptionComptabilite optionComptabilite;
   private UtilDate utilDate;
   private List mesUsersItems = new ArrayList();
   private List lesRepImpression = new ArrayList();
   private transient DataModel dataModelImpgen = new ListDataModel();
   private List lesFichImpression = new ArrayList();
   private transient DataModel dataModelImpgenFichier = new ListDataModel();
   private boolean testafficheLigne = false;
   private String nomRepertoire;
   private String nomEtat = "";
   private boolean inclureJournauxS;
   private boolean inclureJournauxR;
   private String calculAmortissement;
   private String typeEcriture;
   private int nbreCaractere;
   private Date filtreDateDebut;
   private Date filtreDateFin;
   private String region;
   private String secteur;
   private String pdv;
   private String site;
   private String departement;
   private String service;
   private String filtreCompteDebut;
   private String filtreCompteFin;
   private String parc;
   private String activite;
   private String dossier;
   private String journal;
   private String mois;
   private String etat;
   private long createur;
   private String var_entete;
   private String var_filtre;
   private String var_requete;
   private UtilPrint utilPrint;
   private boolean affMail = false;
   private String format = "PDF";
   private boolean var_affiche_impression = false;
   private String impDestinataire;
   private String impDestinataireCC;
   private String impDestinataireCCI;
   private String impEmetteur;
   private boolean var_ctrl_imp = false;
   private double var_solde_anterieur;
   private String var_journal;
   private String var_compte;
   private boolean showModalPanelComptes = false;
   private transient DataModel datamodelComptes = new ListDataModel();
   private PlanComptable planComptable;
   private boolean type_Compte = false;
   private String testaffiche;
   private String testafficheTiers;
   private List lesplanComptables = new ArrayList();
   private PlanComptableDao planComptableDao;
   private List lesjournauxTresorerie = new ArrayList();
   private List touslesjournauxComptables = new ArrayList();
   private JournauxComptablesDao journauxComptablesDao;
   private List mesProjetsItems = new ArrayList();
   private List lesProjets = new ArrayList();
   private ProjetsDao projetsDao;
   private String projet;
   private List lesplanComptablesTiers;
   private List lesjournauxTresorerieItem = new ArrayList();
   private List touslesjournauxComptablesItem = new ArrayList();
   private List touslesMoisItem = new ArrayList();
   private List lesBalanceAgee;
   private EcrituresBalance ecrituresBalance;
   private String m0DteDeb;
   private String m0DteFin;
   private String m30DteDeb;
   private String m30DteFin;
   private String m60DteDeb;
   private String m60DteFin;
   private String m90DteDeb;
   private String m90DteFin;
   private String m120DteDeb;
   private List lesModelesAutorises;
   private int choixRacine;
   private String selecFiscalite;

   public FormImpressionProjet() {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.utilDate = new UtilDate();
   }

   public void InstancesDaoUtilses() {
      this.planComptableDao = new PlanComptableDao(this.baseLog, this.utilInitHibernate);
      this.journauxComptablesDao = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
      this.lesBalanceAgee = new ArrayList();
      this.projetsDao = new ProjetsDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerLesRepImpCompta(Session var1) throws HibernateException, NamingException {
      this.lesRepImpression.clear();
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "compta_projet";
      File var3 = new File(var2);
      if (!var3.exists()) {
         var3.mkdir();
      }

      String[] var4 = var3.list();
      if (var4 != null) {
         var4 = this.triAlphabetique(var4, var4.length);

         for(int var5 = 0; var5 < var4.length; ++var5) {
            if (!var4[var5].equalsIgnoreCase(".svn") && !var4[var5].equalsIgnoreCase("index.html") && !var4[var5].startsWith("extrait") && !var4[var5].equalsIgnoreCase("journal_journalier") && !var4[var5].equalsIgnoreCase("journal_mensuel") && !var4[var5].equalsIgnoreCase("loyer")) {
               String var6 = "";
               var6 = var4[var5].toUpperCase();
               this.lesRepImpression.add(var6);
            }
         }
      }

      this.dataModelImpgen.setWrappedData(this.lesRepImpression);
      this.selecFiscalite = this.structureLog.getStrzonefiscale();
      if (this.structureLog.getStrzonefiscale2() != null && !this.structureLog.getStrzonefiscale2().isEmpty()) {
         long var9 = (long)(this.exoSelectionne.getExecptDateDebut().getYear() + 1900);
         long var7 = (long)(this.exoSelectionne.getExecptDateFin().getYear() + 1900);
         if (this.structureLog.getStrdatefiscale2() != null && var9 >= (long)(this.structureLog.getStrdatefiscale2().getYear() + 1900) && var7 >= (long)(this.structureLog.getStrdatefiscale2().getYear() + 1900)) {
            this.selecFiscalite = this.structureLog.getStrzonefiscale2();
         } else if (this.structureLog.getStrdatefiscale2() != null && var9 < (long)(this.structureLog.getStrdatefiscale2().getYear() + 1900) && var7 < (long)(this.structureLog.getStrdatefiscale2().getYear() + 1900)) {
            this.selecFiscalite = this.structureLog.getStrzonefiscale();
         } else {
            this.selecFiscalite = null;
         }
      }

      this.mesUsersItems.clear();
      UserDao var10 = new UserDao(this.baseLog, this.utilInitHibernate);
      this.mesUsersItems = var10.chargerLesComptablesItems(var1);
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

   public void chargerLesPCetJC(Session var1) throws HibernateException, NamingException {
      this.lesplanComptables.clear();
      this.lesplanComptables = this.planComptableDao.chargerLesPlcComptables(this.selecFiscalite, this.exoSelectionne.getExecpt_id(), this.usersLog.getUsrCptInterdit(), var1);
      this.lesjournauxTresorerie.clear();
      this.lesjournauxTresorerie = this.journauxComptablesDao.mesjournauxTresorerieActifs(this.exoSelectionne.getExecpt_id(), this.usersLog.getUsrJrxInterdit(), this.usersLog.getUsrJrxReserve(), var1);
      this.lesjournauxTresorerieItem.clear();

      for(int var2 = 0; var2 < this.lesjournauxTresorerie.size(); ++var2) {
         JournauxComptables var3 = (JournauxComptables)this.lesjournauxTresorerie.get(var2);
         String var4 = var3.getPljCode();
         String var5 = var3.getPljLibelleFr();
         SelectItem var6 = new SelectItem(var4.concat(":") + var5);
         this.lesjournauxTresorerieItem.add(var6);
      }

      this.touslesjournauxComptables.clear();
      this.touslesjournauxComptables = this.journauxComptablesDao.mesjournauxActifs(this.exoSelectionne.getExecpt_id(), this.usersLog.getUsrJrxInterdit(), this.usersLog.getUsrJrxReserve(), var1);
      String var9 = "Tous les Journaux";
      this.touslesjournauxComptablesItem.clear();
      SelectItem var10 = new SelectItem(var9);
      this.touslesjournauxComptablesItem.add(var10);

      int var11;
      for(var11 = 0; var11 < this.touslesjournauxComptables.size(); ++var11) {
         JournauxComptables var12 = (JournauxComptables)this.touslesjournauxComptables.get(var11);
         String var13 = var12.getPljCode();
         String var7 = var12.getPljLibelleFr();
         SelectItem var8 = new SelectItem(var13.concat(":") + var7);
         this.touslesjournauxComptablesItem.add(var8);
      }

      this.lesProjets.clear();
      this.lesProjets = this.projetsDao.selectAllProjets(0, var1);
      this.mesProjetsItems.clear();
      if (this.lesProjets.size() != 0) {
         for(var11 = 0; var11 < this.lesProjets.size(); ++var11) {
            this.mesProjetsItems.add(new SelectItem(((Projets)this.lesProjets.get(var11)).getProCode() + ":" + ((Projets)this.lesProjets.get(var11)).getProNomFR()));
         }
      }

   }

   public void calculerMoisExercice(Session var1) {
      this.touslesMoisItem.clear();
      this.filtreDateDebut = this.exoSelectionne.getExecptDateDebut();
      this.filtreDateFin = this.exoSelectionne.getExecptDateFin();
      Date var2 = this.exoSelectionne.getExecptDateDebut();
      Date var3 = this.exoSelectionne.getExecptDateFin();
      int var4 = var2.getYear();
      int var5 = var3.getYear();
      int var6 = var2.getMonth();
      int var7 = var3.getMonth();
      String var8 = "0";

      for(int var9 = var4; var9 <= var5; ++var9) {
         if (var5 > var4 && var8.equalsIgnoreCase("0")) {
            var7 = 11;
         }

         if (var5 > var4 && var8.equalsIgnoreCase("1")) {
            var7 = var3.getMonth();
         }

         for(int var10 = var6; var10 <= var7; ++var10) {
            int var11 = var10 + 1;
            String var12 = this.convertirIntMois(var11);
            int var13 = this.convrtirAnne(var9);
            String var14 = "" + var12 + ":" + var13;
            SelectItem var15 = new SelectItem(var14);
            this.touslesMoisItem.add(var15);
            var6 = 0;
            var8 = "1";
         }
      }

   }

   public String convertirIntMois(int var1) {
      String var2 = "" + var1;
      if (var1 < 10) {
         var2 = "0" + var1;
      }

      return var2;
   }

   public int convrtirAnne(int var1) {
      int var2 = var1 - 100 + 2000;
      return var2;
   }

   public void recupererNomrep() throws HibernateException, NamingException {
      this.testafficheLigne = false;
      if (this.dataModelImpgen.isRowAvailable()) {
         this.nomRepertoire = (String)this.dataModelImpgen.getRowData();
         this.nomRepertoire = this.nomRepertoire.toLowerCase();
         this.nomEtat = "";
         this.lesFichImpression.clear();
         String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "compta_projet" + File.separator + this.nomRepertoire;
         this.testafficheLigne = false;
         File var2 = new File(var1);
         if (!var2.exists()) {
            var2.mkdir();
         }

         String[] var3 = var2.list();
         if (var3 != null) {
            var3 = this.triAlphabetique(var3, var3.length);

            for(int var4 = 0; var4 < var3.length; ++var4) {
               if (var3[var4].endsWith("jasper")) {
                  String var5 = var3[var4];
                  if (this.verificationAutorisation(var5)) {
                     String var6 = var3[var4].substring(0, var3[var4].indexOf("."));
                     this.lesFichImpression.add(var6);
                  }
               }
            }
         }

         if (!this.nomRepertoire.equalsIgnoreCase("balance_generale") && !this.nomRepertoire.equalsIgnoreCase("grand_livre_general") && !this.nomRepertoire.equalsIgnoreCase("balance_clients") && !this.nomRepertoire.equalsIgnoreCase("balance_fournisseurs") && !this.nomRepertoire.equalsIgnoreCase("grand_livre_clients") && !this.nomRepertoire.equalsIgnoreCase("grand_livre_fournisseurs") && !this.nomRepertoire.equalsIgnoreCase("balance_personnels") && !this.nomRepertoire.equalsIgnoreCase("grand_livre_personnels") && !this.nomRepertoire.equalsIgnoreCase("synthese") && !this.nomRepertoire.equalsIgnoreCase("table")) {
            if (!this.nomRepertoire.equalsIgnoreCase("brouillard") && !this.nomRepertoire.equalsIgnoreCase("tresorerie") && !this.nomRepertoire.equalsIgnoreCase("controles") && !this.nomRepertoire.equalsIgnoreCase("utilisateur")) {
               if (!this.nomRepertoire.equalsIgnoreCase("balance_agee_clients") && !this.nomRepertoire.equalsIgnoreCase("echeancier_clients") && !this.nomRepertoire.equalsIgnoreCase("balance_agee_fournisseurs") && !this.nomRepertoire.equalsIgnoreCase("echeancier_fournisseurs")) {
                  if (this.nomRepertoire.equalsIgnoreCase("commissaires_comptes")) {
                     this.setTestaffiche("commissaires comptes");
                  } else if (this.nomRepertoire.equalsIgnoreCase("budget")) {
                     this.setTestaffiche("budget");
                  } else if (this.nomRepertoire.equalsIgnoreCase("amortissement")) {
                     this.setTestaffiche("amortissement");
                  } else if (this.nomRepertoire.equalsIgnoreCase("loyer")) {
                     this.setTestaffiche("loyer");
                  } else if (this.nomRepertoire.equalsIgnoreCase("rapprochement")) {
                     this.setTestaffiche("rapprochement");
                  } else if (this.nomRepertoire.equalsIgnoreCase("bilan")) {
                     this.setTestaffiche("bilan");
                  } else if (this.nomRepertoire.equalsIgnoreCase("journal_general") || this.nomRepertoire.equalsIgnoreCase("journal_journalier") || this.nomRepertoire.equalsIgnoreCase("journal_mensuel")) {
                     this.setTestaffiche("journal");
                  }
               } else {
                  this.setTestaffiche("balance_agee");
                  if (!this.nomRepertoire.equalsIgnoreCase("balance_agee_clients") && !this.nomRepertoire.equalsIgnoreCase("echeancier_clients") && !this.nomRepertoire.equalsIgnoreCase("balance_agee_fournisseurs") && !this.nomRepertoire.equalsIgnoreCase("echeancier_fournisseurs")) {
                     this.setTestafficheTiers("balanceageeExt");
                  } else {
                     this.setTestafficheTiers("agee");
                  }
               }
            } else {
               this.setTestaffiche("brouillard");
               if (this.nomRepertoire.equalsIgnoreCase("tresorerie")) {
                  this.setTestafficheTiers("treso");
               } else {
                  this.setTestafficheTiers("tresoExt");
               }
            }
         } else {
            this.setTestaffiche("balance");
            if (!this.nomRepertoire.equalsIgnoreCase("balance_clients") && !this.nomRepertoire.equalsIgnoreCase("grand_livre_clients") && !this.nomRepertoire.equalsIgnoreCase("balance_fournisseurs") && !this.nomRepertoire.equalsIgnoreCase("grand_livre_fournisseurs") && !this.nomRepertoire.equalsIgnoreCase("balance_personnels") && !this.nomRepertoire.equalsIgnoreCase("grand_livre_personnels")) {
               this.setTestafficheTiers("balanceExt");
            } else {
               this.setTestafficheTiers("tiers");
            }
         }

         this.filtreDateDebut = this.exoSelectionne.getExecptDateDebut();
         this.filtreDateFin = this.exoSelectionne.getExecptDateFin();
         this.calculerNumCpte();
         this.dataModelImpgenFichier.setWrappedData(this.lesFichImpression);
         this.var_affiche_impression = true;
      }

   }

   public boolean verificationAutorisation(String var1) {
      boolean var2 = false;
      if (this.lesModelesAutorises != null && this.lesModelesAutorises.size() != 0) {
         for(int var3 = 0; var3 < this.lesModelesAutorises.size(); ++var3) {
            if (((String)this.lesModelesAutorises.get(var3)).toString().toLowerCase().contains(var1.toLowerCase())) {
               var2 = true;
               break;
            }
         }
      } else {
         var2 = true;
      }

      return var2;
   }

   public void calculerNumCpte() throws HibernateException, NamingException {
      String var1;
      if (this.nomRepertoire.contains("fournisseurs")) {
         var1 = "from PlanComptable where exercicesComptable=" + this.exoSelectionne.getExecpt_id() + " and plcNature=6 order by plcCompte ASC";
         this.lesplanComptablesTiers = this.planComptableDao.chargerPlanComptableImp(var1, (Session)null);
      } else if (this.nomRepertoire.contains("clients")) {
         var1 = "from PlanComptable where exercicesComptable=" + this.exoSelectionne.getExecpt_id() + " and plcNature=7 order by plcCompte ASC";
         this.lesplanComptablesTiers = this.planComptableDao.chargerPlanComptableImp(var1, (Session)null);
      } else if (this.nomRepertoire.contains("personnels")) {
         var1 = "from PlanComptable where exercicesComptable=" + this.exoSelectionne.getExecpt_id() + " and plcNature=8 order by plcCompte ASC";
         this.lesplanComptablesTiers = this.planComptableDao.chargerPlanComptableImp(var1, (Session)null);
      } else {
         var1 = "from PlanComptable where exercicesComptable=" + this.exoSelectionne.getExecpt_id() + " order by plcCompte ASC";
         this.lesplanComptablesTiers = this.planComptableDao.chargerPlanComptableImp(var1, (Session)null);
      }

      if (this.lesplanComptablesTiers.size() > 0) {
         new PlanComptable();
         PlanComptable var3 = (PlanComptable)this.lesplanComptablesTiers.get(0);
         this.filtreCompteDebut = var3.getPlcCompte();
         int var2 = this.lesplanComptablesTiers.size() - 1;
         var3 = (PlanComptable)this.lesplanComptablesTiers.get(var2);
         this.filtreCompteFin = var3.getPlcCompte();
      } else {
         this.filtreCompteDebut = "";
         this.filtreCompteFin = "";
      }

   }

   public void recupererNomfich() throws HibernateException, NamingException {
      if (this.dataModelImpgenFichier.isRowAvailable()) {
         this.nomEtat = (String)this.dataModelImpgenFichier.getRowData();
         this.filtreDateDebut = this.exoSelectionne.getExecptDateDebut();
         this.filtreDateFin = this.exoSelectionne.getExecptDateFin();
         this.calculerNumCpte();
         this.var_affiche_impression = true;
      }

   }

   public void rechercheComptesDebut() throws ClassCastException, HibernateException, NamingException, JDOMException, IOException {
      new ArrayList();
      if (this.filtreCompteDebut != null && !this.filtreCompteDebut.isEmpty()) {
         String var2 = "";
         List var1 = this.planComptableDao.chargerlesNumCpte("", this.filtreCompteDebut, this.exoSelectionne.getExecpt_id(), this.usersLog.getUsrCptInterdit(), (Session)null);
         if (var1.size() != 0) {
            if (var1.size() == 1) {
               this.planComptable = (PlanComptable)var1.get(0);
               this.filtreCompteDebut = this.planComptable.getPlcCompte();
            } else {
               this.type_Compte = false;
               this.datamodelComptes.setWrappedData(var1);
               this.showModalPanelComptes = true;
            }
         }
      }

   }

   public void rechercheComptesFin() throws ClassCastException, HibernateException, NamingException, JDOMException, IOException {
      new ArrayList();
      if (this.filtreCompteFin != null && !this.filtreCompteFin.isEmpty()) {
         String var2 = "";
         List var1 = this.planComptableDao.chargerlesNumCpte("", this.filtreCompteFin, this.exoSelectionne.getExecpt_id(), this.usersLog.getUsrCptInterdit(), (Session)null);
         if (var1.size() != 0) {
            if (var1.size() == 1) {
               this.planComptable = (PlanComptable)var1.get(0);
               this.filtreCompteFin = this.planComptable.getPlcCompte();
            } else {
               this.type_Compte = true;
               this.datamodelComptes.setWrappedData(var1);
               this.showModalPanelComptes = true;
            }
         }
      }

   }

   public void selectionligneCompte() throws JDOMException, IOException {
      if (this.datamodelComptes.isRowAvailable()) {
         this.planComptable = (PlanComptable)this.datamodelComptes.getRowData();
      }

   }

   public void calculeCompte() throws JDOMException, IOException {
      if (this.planComptable == null) {
         this.selectionligneCompte();
      }

      if (this.planComptable != null) {
         if (!this.type_Compte) {
            this.filtreCompteDebut = this.planComptable.getPlcCompte();
         } else {
            this.filtreCompteFin = this.planComptable.getPlcCompte();
         }
      } else {
         this.planComptable = null;
         if (!this.type_Compte) {
            this.filtreCompteDebut = "";
         } else {
            this.filtreCompteFin = "";
         }
      }

      this.showModalPanelComptes = false;
   }

   public void annuleCompte() {
      this.planComptable = null;
      if (!this.type_Compte) {
         this.filtreCompteDebut = "";
      } else {
         this.filtreCompteFin = "";
      }

      this.showModalPanelComptes = false;
   }

   public void initImpression() {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.affMail = false;
   }

   public void imprimerPRT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "PRT";
      this.imprimer();
   }

   public void imprimerJRV() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "JRV";
      this.imprimer();
   }

   public void imprimerPDF() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "PDF";
      this.imprimer();
   }

   public void imprimerODT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "ODT";
      this.imprimer();
   }

   public void imprimerXLS() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "XLS";
      this.imprimer();
   }

   public void imprimerDOC() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "DOC";
      this.imprimer();
   }

   public void imprimerHTML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "HTML";
      this.imprimer();
   }

   public void imprimerXML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "XML";
      this.imprimer();
   }

   public void imprimerCSV() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "CSV";
      this.imprimer();
   }

   public void imprimerMAIL() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      if (this.impEmetteur != null && !this.impEmetteur.isEmpty() && (this.impDestinataire != null && !this.impDestinataire.isEmpty() || this.impDestinataireCC != null && !this.impDestinataireCC.isEmpty() || this.impDestinataireCCI != null && !this.impDestinataireCCI.isEmpty())) {
         this.format = "MAIL";
         this.imprimer();
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

   public void imprimer() throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      if (this.nomRepertoire != null && !this.nomRepertoire.isEmpty() && this.nomEtat != null && !this.nomEtat.isEmpty()) {
         this.var_ctrl_imp = true;
         this.calculeRequete();
         System.out.println("Requete " + this.var_requete);
         if (!this.nomRepertoire.equalsIgnoreCase("balance_agee_clients") && !this.nomRepertoire.equalsIgnoreCase("balance_agee_fournisseurs")) {
            this.utilPrint.setRequete(this.var_requete);
            ArrayList var3 = new ArrayList();
            JRBeanCollectionDataSource var2 = new JRBeanCollectionDataSource(var3);
            this.utilPrint.setjRBeanCollectionDataSource(var2);
         } else {
            this.utilPrint.setRequete("");
            JRBeanCollectionDataSource var1 = new JRBeanCollectionDataSource(this.lesBalanceAgee);
            this.utilPrint.setjRBeanCollectionDataSource(var1);
         }

         this.utilPrint.setRapport(this.nomEtat);
         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "compta_projet" + File.separator + this.nomRepertoire + File.separator);
         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "sous_rapport" + File.separator);
         if (this.var_entete != null && !this.var_entete.isEmpty()) {
            this.utilPrint.setEntete(this.var_entete.replace("_", " "));
         } else {
            this.utilPrint.setEntete("");
         }

         if (this.var_filtre != null && !this.var_filtre.isEmpty()) {
            this.utilPrint.setFiltre(this.var_filtre.replace("_", " "));
         } else {
            this.utilPrint.setFiltre("");
         }

         this.utilPrint.setDateDebUk(this.utilDate.dateToStringSQLLight(this.filtreDateDebut));
         this.utilPrint.setDateFinUk(this.utilDate.dateToStringSQLLight(this.filtreDateFin));
         this.utilPrint.setJournal(this.var_journal);
         this.utilPrint.setCompte(this.var_compte);
         this.utilPrint.setTotauxTtc("" + this.var_solde_anterieur);
         this.utilPrint.setTotauxHt("0");
         this.utilPrint.setNbCar(this.nbreCaractere);
         this.utilPrint.setFormat(this.format);
         this.utilPrint.setEmetteur(this.impEmetteur);
         this.utilPrint.setDestinataire(this.impDestinataire);
         this.utilPrint.setDestinataireCC(this.impDestinataireCC);
         this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
         this.utilPrint.setTiersSelectionne((Tiers)null);
         this.utilPrint.setBaseLog(this.baseLog);
         this.utilPrint.setStructureLog(this.structureLog);
         this.utilPrint.setUsersLog(this.usersLog);
         this.utilPrint.setAnnexe1(this.utilDate.dateToStringSQL(this.filtreDateFin));
         this.utilPrint.setAnnexe2(this.utilDate.dateToStringSQL(this.exoSelectionne.getExecptDateDebut()));
         this.utilPrint.setM0DteDeb(this.m0DteDeb);
         this.utilPrint.setM0DteFin(this.m0DteFin);
         this.utilPrint.setM30DteDeb(this.m30DteDeb);
         this.utilPrint.setM30DteFin(this.m30DteFin);
         this.utilPrint.setM60DteDeb(this.m60DteDeb);
         this.utilPrint.setM60DteFin(this.m60DteFin);
         this.utilPrint.setM90DteDeb(this.m90DteDeb);
         this.utilPrint.setM90DteFin(this.m90DteFin);
         this.utilPrint.setM120DteDeb(this.m120DteDeb);
         this.utilPrint.imprimeRapport();
         this.var_ctrl_imp = false;
      }

   }

   public void calculeRequete() throws HibernateException, NamingException {
      this.var_entete = "";
      this.var_filtre = "";
      this.var_requete = "";
      this.var_solde_anterieur = 0.0D;
      this.var_journal = "";
      this.var_compte = "";
      String var1 = "";
      String var2 = "";
      if (this.projet != null && !this.projet.isEmpty() && this.projet.contains(":")) {
         String[] var3 = this.projet.split(":");
         var1 = var3[0];
         var2 = var3[1];
      }

      String var10 = this.utilDate.dateToStringSQLLight(this.filtreDateDebut);
      String var4 = this.utilDate.dateToStringSQLLight(this.filtreDateFin);
      String var5 = this.utilDate.dateToStringFr(this.filtreDateDebut);
      String var6 = this.utilDate.dateToStringFr(this.filtreDateFin);
      String var7 = this.journal;
      if (!this.nomRepertoire.equalsIgnoreCase("balance_generale") && !this.nomRepertoire.equalsIgnoreCase("balance_clients") && !this.nomRepertoire.equalsIgnoreCase("balance_fournisseurs") && !this.nomRepertoire.equalsIgnoreCase("balance_personnels") && !this.nomRepertoire.equalsIgnoreCase("grand_livre_general") && !this.nomRepertoire.equalsIgnoreCase("grand_livre_clients") && !this.nomRepertoire.equalsIgnoreCase("grand_livre_fournisseurs") && !this.nomRepertoire.equalsIgnoreCase("grand_livre_personnels")) {
         if (this.nomRepertoire.equalsIgnoreCase("rapports_bailleurs")) {
            this.var_entete = "Etat récapitulatif des charges du " + var5 + " au " + var6;
            if (var1 != null && !var1.isEmpty()) {
               this.var_filtre = "PROJET " + var1;
               this.var_requete = "ecr_budget_treso='" + var1 + "' and (ecr_date_saisie>='" + var10 + "' AND ecr_date_saisie<='" + var4 + "')";
            } else {
               this.var_filtre = "TOUS PROJETS ";
               this.var_requete = "ecr_budget_treso is not null && ecr_budget_treso<>'' && (ecr_date_saisie>='" + var10 + "' AND ecr_date_saisie<='" + var4 + "')";
            }

            this.var_requete = this.var_requete + "and  ecr_nature_jrx<>13 and ecr_nature_jrx<>14";
            if (!this.inclureJournauxS) {
               this.var_requete = this.var_requete + " AND ecr_nature_jrx<>11";
            }

            if (!this.inclureJournauxR) {
               this.var_requete = this.var_requete + " AND ecr_reserve=0";
            }
         }
      } else {
         if (this.nomEtat.equals("GrandLivreCompletAvecAnterieurCumule") || this.nomEtat.equals("GrandLivreClientsAvecAnterieurCumule") || this.nomEtat.equals("GrandLivreFournisseursAvecAnterieurCumule")) {
            var10 = this.utilDate.dateToStringSQLLight(this.exoSelectionne.getExecptDateDebut());
         }

         this.var_entete = this.nomRepertoire.toUpperCase() + " du " + var5 + " au " + var6;
         if (var1 != null && !var1.isEmpty()) {
            if (this.typeEcriture.equalsIgnoreCase("0")) {
               this.var_filtre = "PROJET " + var1 + " " + "Toutes les écritures du compte " + this.filtreCompteDebut + " au compte " + this.filtreCompteFin;
               this.var_requete = "ecr_budget_treso='" + var1 + "' and (ecr_date_saisie>='" + var10 + "' AND ecr_date_saisie<='" + var4 + "') AND  (ecr_compte>='" + this.filtreCompteDebut + "' AND ecr_compte<='" + this.filtreCompteFin + "')";
            } else if (this.typeEcriture.equalsIgnoreCase("1")) {
               this.var_filtre = "PROJET " + var1 + " " + "Ecritures non lettrées du compte " + this.filtreCompteDebut + " au compte " + this.filtreCompteFin;
               this.var_requete = "ecr_budget_treso='" + var1 + "' and (ecr_date_saisie>='" + var10 + "' AND ecr_date_saisie<='" + var4 + "') AND (ecr_compte>='" + this.filtreCompteDebut + "' AND ecr_compte<='" + this.filtreCompteFin + "') AND (ecr_lettrage='' or ecr_lettrage is null)";
            } else if (this.typeEcriture.equalsIgnoreCase("2")) {
               this.var_filtre = "PROJET " + var1 + " " + "Ecritures lettrées du compte " + this.filtreCompteDebut + " au compte " + this.filtreCompteFin;
               this.var_requete = "ecr_budget_treso='" + var1 + "' and (ecr_date_saisie>='" + var10 + "' AND ecr_date_saisie<='" + var4 + "') AND (ecr_compte>='" + this.filtreCompteDebut + "' AND ecr_compte<='" + this.filtreCompteFin + "') AND (ecr_lettrage<>'' or ecr_lettrage is not null)";
            } else if (this.typeEcriture.equalsIgnoreCase("3")) {
               this.var_filtre = "PROJET " + var1 + " " + "Ecritures non pointées du compte " + this.filtreCompteDebut + " au compte " + this.filtreCompteFin;
               this.var_requete = "ecr_budget_treso='" + var1 + "' and (ecr_date_saisie>='" + var10 + "' AND ecr_date_saisie<='" + var4 + "') AND (ecr_compte>='" + this.filtreCompteDebut + "' AND ecr_compte<='" + this.filtreCompteFin + "') AND (ecr_pointage='' or ecr_pointage is null)";
            } else if (this.typeEcriture.equalsIgnoreCase("4")) {
               this.var_filtre = "PROJET " + var1 + " " + "Ecritures pointées du compte " + this.filtreCompteDebut + " au compte " + this.filtreCompteFin;
               this.var_requete = "ecr_budget_treso='" + var1 + "' and (ecr_date_saisie>='" + var10 + "' AND ecr_date_saisie<='" + var4 + "') AND (ecr_compte>='" + this.filtreCompteDebut + "' AND ecr_compte<='" + this.filtreCompteFin + "') AND (ecr_pointage<>'' or ecr_pointage is not null)";
            } else if (this.typeEcriture.equalsIgnoreCase("5")) {
               this.var_filtre = "PROJET " + var1 + " " + "Ecritures non lettrées et pointées du compte " + this.filtreCompteDebut + " au compte " + this.filtreCompteFin;
               this.var_requete = "ecr_budget_treso='" + var1 + "' and (ecr_date_saisie>='" + var10 + "' AND ecr_date_saisie<='" + var4 + "') AND  (ecr_compte>='" + this.filtreCompteDebut + "' AND ecr_compte<='" + this.filtreCompteFin + "') AND (ecr_lettrage='' or ecr_lettrage is null) AND (ecr_pointage<>'' or ecr_pointage is not null)";
            } else if (this.typeEcriture.equalsIgnoreCase("6")) {
               this.var_filtre = "PROJET " + var1 + " " + "Ecritures lettrées et pointées du compte " + this.filtreCompteDebut + " au compte " + this.filtreCompteFin;
               this.var_requete = "ecr_budget_treso='" + var1 + "' and (ecr_date_saisie>='" + var10 + "' AND ecr_date_saisie<='" + var4 + "') AND (ecr_compte>='" + this.filtreCompteDebut + "' AND ecr_compte<='" + this.filtreCompteFin + "') AND (ecr_lettrage='' or ecr_lettrage is null) AND (ecr_pointage='' or ecr_pointage is null)";
            }
         } else if (this.typeEcriture.equalsIgnoreCase("0")) {
            this.var_filtre = "TOUS PROJETS Toutes les écritures du compte " + this.filtreCompteDebut + " au compte " + this.filtreCompteFin;
            this.var_requete = "(ecr_date_saisie>='" + var10 + "' AND ecr_date_saisie<='" + var4 + "') AND  (ecr_compte>='" + this.filtreCompteDebut + "' AND ecr_compte<='" + this.filtreCompteFin + "')";
         } else if (this.typeEcriture.equalsIgnoreCase("1")) {
            this.var_filtre = "TOUS PROJETS Ecritures non lettrées du compte " + this.filtreCompteDebut + " au compte " + this.filtreCompteFin;
            this.var_requete = "(ecr_date_saisie>='" + var10 + "' AND ecr_date_saisie<='" + var4 + "') AND (ecr_compte>='" + this.filtreCompteDebut + "' AND ecr_compte<='" + this.filtreCompteFin + "') AND (ecr_lettrage='' or ecr_lettrage is null)";
         } else if (this.typeEcriture.equalsIgnoreCase("2")) {
            this.var_filtre = "TOUS PROJETS Ecritures lettrées du compte " + this.filtreCompteDebut + " au compte " + this.filtreCompteFin;
            this.var_requete = "(ecr_date_saisie>='" + var10 + "' AND ecr_date_saisie<='" + var4 + "') AND (ecr_compte>='" + this.filtreCompteDebut + "' AND ecr_compte<='" + this.filtreCompteFin + "') AND (ecr_lettrage<>'' or ecr_lettrage is not null)";
         } else if (this.typeEcriture.equalsIgnoreCase("3")) {
            this.var_filtre = "TOUS PROJETS Ecritures non pointées du compte " + this.filtreCompteDebut + " au compte " + this.filtreCompteFin;
            this.var_requete = "(ecr_date_saisie>='" + var10 + "' AND ecr_date_saisie<='" + var4 + "') AND (ecr_compte>='" + this.filtreCompteDebut + "' AND ecr_compte<='" + this.filtreCompteFin + "') AND (ecr_pointage='' or ecr_pointage is null)";
         } else if (this.typeEcriture.equalsIgnoreCase("4")) {
            this.var_filtre = "TOUS PROJETS Ecritures pointées du compte " + this.filtreCompteDebut + " au compte " + this.filtreCompteFin;
            this.var_requete = "(ecr_date_saisie>='" + var10 + "' AND ecr_date_saisie<='" + var4 + "') AND (ecr_compte>='" + this.filtreCompteDebut + "' AND ecr_compte<='" + this.filtreCompteFin + "') AND (ecr_pointage<>'' or ecr_pointage is not null)";
         } else if (this.typeEcriture.equalsIgnoreCase("5")) {
            this.var_filtre = "TOUS PROJETS Ecritures non lettrées et pointées du compte " + this.filtreCompteDebut + " au compte " + this.filtreCompteFin;
            this.var_requete = "(ecr_date_saisie>='" + var10 + "' AND ecr_date_saisie<='" + var4 + "') AND  (ecr_compte>='" + this.filtreCompteDebut + "' AND ecr_compte<='" + this.filtreCompteFin + "') AND (ecr_lettrage='' or ecr_lettrage is null) AND (ecr_pointage<>'' or ecr_pointage is not null)";
         } else if (this.typeEcriture.equalsIgnoreCase("6")) {
            this.var_filtre = "TOUS PROJETS Ecritures lettrées et pointées du compte " + this.filtreCompteDebut + " au compte " + this.filtreCompteFin;
            this.var_requete = "(ecr_date_saisie>='" + var10 + "' AND ecr_date_saisie<='" + var4 + "') AND (ecr_compte>='" + this.filtreCompteDebut + "' AND ecr_compte<='" + this.filtreCompteFin + "') AND (ecr_lettrage='' or ecr_lettrage is null) AND (ecr_pointage='' or ecr_pointage is null)";
         }

         this.var_requete = this.var_requete + "and  ecr_nature_jrx<>13 and ecr_nature_jrx<>14";
         if (!this.inclureJournauxS) {
            this.var_requete = this.var_requete + " AND ecr_nature_jrx<>11";
         }

         if (!this.inclureJournauxR) {
            this.var_requete = this.var_requete + " AND ecr_reserve=0";
         }

         if (!this.journal.equalsIgnoreCase("Tous les journaux")) {
            String[] var8 = this.journal.split(":");
            String var9 = var8[0];
            this.var_requete = this.var_requete + " AND ecr_code='" + var9 + "'";
         }
      }

   }

   public OptionComptabilite getOptionComptabilite() {
      return this.optionComptabilite;
   }

   public void setOptionComptabilite(OptionComptabilite var1) {
      this.optionComptabilite = var1;
   }

   public ExercicesComptable getExoSelectionne() {
      return this.exoSelectionne;
   }

   public void setExoSelectionne(ExercicesComptable var1) {
      this.exoSelectionne = var1;
   }

   public String getTestaffiche() {
      return this.testaffiche;
   }

   public void setTestaffiche(String var1) {
      this.testaffiche = var1;
   }

   public String getTestafficheTiers() {
      return this.testafficheTiers;
   }

   public void setTestafficheTiers(String var1) {
      this.testafficheTiers = var1;
   }

   public boolean isAffMail() {
      return this.affMail;
   }

   public void setAffMail(boolean var1) {
      this.affMail = var1;
   }

   public DataModel getDataModelImpgen() {
      return this.dataModelImpgen;
   }

   public void setDataModelImpgen(DataModel var1) {
      this.dataModelImpgen = var1;
   }

   public DataModel getDataModelImpgenFichier() {
      return this.dataModelImpgenFichier;
   }

   public void setDataModelImpgenFichier(DataModel var1) {
      this.dataModelImpgenFichier = var1;
   }

   public UtilPrint getUtilPrint() {
      return this.utilPrint;
   }

   public void setUtilPrint(UtilPrint var1) {
      this.utilPrint = var1;
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

   public List getLesjournauxTresorerieItem() {
      return this.lesjournauxTresorerieItem;
   }

   public void setLesjournauxTresorerieItem(List var1) {
      this.lesjournauxTresorerieItem = var1;
   }

   public List getTouslesjournauxComptablesItem() {
      return this.touslesjournauxComptablesItem;
   }

   public void setTouslesjournauxComptablesItem(List var1) {
      this.touslesjournauxComptablesItem = var1;
   }

   public DataModel getDatamodelComptes() {
      return this.datamodelComptes;
   }

   public void setDatamodelComptes(DataModel var1) {
      this.datamodelComptes = var1;
   }

   public boolean isShowModalPanelComptes() {
      return this.showModalPanelComptes;
   }

   public void setShowModalPanelComptes(boolean var1) {
      this.showModalPanelComptes = var1;
   }

   public List getTouslesMoisItem() {
      return this.touslesMoisItem;
   }

   public void setTouslesMoisItem(List var1) {
      this.touslesMoisItem = var1;
   }

   public boolean isVar_ctrl_imp() {
      return this.var_ctrl_imp;
   }

   public void setVar_ctrl_imp(boolean var1) {
      this.var_ctrl_imp = var1;
   }

   public String getActivite() {
      return this.activite;
   }

   public void setActivite(String var1) {
      this.activite = var1;
   }

   public String getCalculAmortissement() {
      return this.calculAmortissement;
   }

   public void setCalculAmortissement(String var1) {
      this.calculAmortissement = var1;
   }

   public long getCreateur() {
      return this.createur;
   }

   public void setCreateur(long var1) {
      this.createur = var1;
   }

   public String getDepartement() {
      return this.departement;
   }

   public void setDepartement(String var1) {
      this.departement = var1;
   }

   public String getDossier() {
      return this.dossier;
   }

   public void setDossier(String var1) {
      this.dossier = var1;
   }

   public String getEtat() {
      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public String getFiltreCompteDebut() {
      return this.filtreCompteDebut;
   }

   public void setFiltreCompteDebut(String var1) {
      this.filtreCompteDebut = var1;
   }

   public String getFiltreCompteFin() {
      return this.filtreCompteFin;
   }

   public void setFiltreCompteFin(String var1) {
      this.filtreCompteFin = var1;
   }

   public Date getFiltreDateDebut() {
      return this.filtreDateDebut;
   }

   public void setFiltreDateDebut(Date var1) {
      this.filtreDateDebut = var1;
   }

   public Date getFiltreDateFin() {
      return this.filtreDateFin;
   }

   public void setFiltreDateFin(Date var1) {
      this.filtreDateFin = var1;
   }

   public boolean isInclureJournauxR() {
      return this.inclureJournauxR;
   }

   public void setInclureJournauxR(boolean var1) {
      this.inclureJournauxR = var1;
   }

   public boolean isInclureJournauxS() {
      return this.inclureJournauxS;
   }

   public void setInclureJournauxS(boolean var1) {
      this.inclureJournauxS = var1;
   }

   public String getJournal() {
      return this.journal;
   }

   public void setJournal(String var1) {
      this.journal = var1;
   }

   public int getNbreCaractere() {
      return this.nbreCaractere;
   }

   public void setNbreCaractere(int var1) {
      this.nbreCaractere = var1;
   }

   public String getNomRepertoire() {
      return this.nomRepertoire;
   }

   public void setNomRepertoire(String var1) {
      this.nomRepertoire = var1;
   }

   public String getNomEtat() {
      return this.nomEtat;
   }

   public void setNomEtat(String var1) {
      this.nomEtat = var1;
   }

   public String getParc() {
      return this.parc;
   }

   public void setParc(String var1) {
      this.parc = var1;
   }

   public String getPdv() {
      return this.pdv;
   }

   public void setPdv(String var1) {
      this.pdv = var1;
   }

   public String getRegion() {
      return this.region;
   }

   public void setRegion(String var1) {
      this.region = var1;
   }

   public String getSecteur() {
      return this.secteur;
   }

   public void setSecteur(String var1) {
      this.secteur = var1;
   }

   public String getService() {
      return this.service;
   }

   public void setService(String var1) {
      this.service = var1;
   }

   public String getSite() {
      return this.site;
   }

   public void setSite(String var1) {
      this.site = var1;
   }

   public String getTypeEcriture() {
      return this.typeEcriture;
   }

   public void setTypeEcriture(String var1) {
      this.typeEcriture = var1;
   }

   public String getMois() {
      return this.mois;
   }

   public void setMois(String var1) {
      this.mois = var1;
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

   public List getMesProjetsItems() {
      return this.mesProjetsItems;
   }

   public void setMesProjetsItems(List var1) {
      this.mesProjetsItems = var1;
   }

   public String getProjet() {
      return this.projet;
   }

   public void setProjet(String var1) {
      this.projet = var1;
   }

   public List getLesModelesAutorises() {
      return this.lesModelesAutorises;
   }

   public void setLesModelesAutorises(List var1) {
      this.lesModelesAutorises = var1;
   }

   public List getMesUsersItems() {
      return this.mesUsersItems;
   }

   public void setMesUsersItems(List var1) {
      this.mesUsersItems = var1;
   }
}
