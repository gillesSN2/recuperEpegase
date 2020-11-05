package com.epegase.forms.comptabilite;

import com.epegase.systeme.classe.Budget;
import com.epegase.systeme.classe.BudgetLigne;
import com.epegase.systeme.classe.Ecritures;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.JournauxComptables;
import com.epegase.systeme.classe.PlanBudgetaireCompte;
import com.epegase.systeme.classe.PlanComptable;
import com.epegase.systeme.classe.PlansBudgetaires;
import com.epegase.systeme.classe.Racines;
import com.epegase.systeme.classe.RevueCompte;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.DocumentEntete;
import com.epegase.systeme.control.EcrituresBalance;
import com.epegase.systeme.dao.BudgetDao;
import com.epegase.systeme.dao.BudgetLigneDao;
import com.epegase.systeme.dao.EcrituresDao;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.PlanBudgetaireCompteDao;
import com.epegase.systeme.dao.PlanComptableDao;
import com.epegase.systeme.dao.PlansBudgetairesDao;
import com.epegase.systeme.dao.RacinesDao;
import com.epegase.systeme.dao.RevueCompteDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilDownload;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.LireLesoptionsCompta;
import com.epegase.systeme.xml.OptionComptabilite;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
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

public class FormImpressionGenerale implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private ExercicesComptable exoSelectionne;
   private OptionComptabilite optionComptabilite;
   private UtilDate utilDate;
   private List mesUsersItems = new ArrayList();
   private String pageIndex;
   private List lesRepImpression = new ArrayList();
   private transient DataModel dataModelImpgen = new ListDataModel();
   private List lesFichImpression = new ArrayList();
   private transient DataModel dataModelImpgenFichier = new ListDataModel();
   private boolean testafficheLigne = false;
   private String nomRepertoire;
   private String nomEtat = "";
   private String periode;
   private List mesPeriodesItems = new ArrayList();
   private boolean inclureJournauxS;
   private boolean inclureJournauxR;
   private String calculAmortissement;
   private String typeEcriture;
   private int typeClasse;
   private int nbreCaractere = 2;
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
   private String[] listJournal = new String[]{""};
   private String mois;
   private String etat;
   private long createur;
   private String var_entete;
   private String var_filtre;
   private String var_requete;
   private int budgetSelect;
   private int budgetMode;
   private UtilPrint utilPrint;
   private boolean affMail = false;
   private String format = "PDF";
   private String impDestinataire;
   private String impDestinataireCC;
   private String impDestinataireCCI;
   private String impEmetteur;
   private boolean var_ctrl_imp = false;
   private double var_solde_anterieur;
   private String var_journal;
   private String var_compte;
   private String var_centralisation;
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
   private boolean showModalPanelBalanceCompte = false;
   private boolean showModalPanelBalancePiece = false;
   private List listeBalance;
   private transient DataModel dataModelBalance;
   private Ecritures ecritures;
   private EcrituresDao ecrituresDao;
   private List listeCompte;
   private transient DataModel dataModelCompte;
   private transient DataModel dataModelDetailPiece;
   private double var_tot_debit;
   private double var_tot_credit;
   private double var_solde;
   private String var_piece;
   private double var_compte_debit;
   private double var_compte_credit;
   private double var_compte_solde;
   private int modeBalance = 0;
   private boolean moduleTransit = false;
   private String code;
   private String libelle;
   private List lesRacines;
   private List lesModelesAutorises;
   private int choixRacine;
   private String selecFiscalite;
   private boolean testafficheExport = false;
   private String formatExport;
   private String cheminExportOrigine;
   private String cheminExportDestination;
   private String urlExplorateur;
   private String nomFichier;
   private String fichierMine;
   private URL fichierUrl;
   private boolean afficheFichierExport;
   private List lesExportsCompta;
   private boolean showModalPanelImpressionInteractif = false;
   private List documentImpressionItems;
   private String nomRepertoireInteractif;
   private String var_revue;
   private RevueCompteDao revueCompteDao;
   private RevueCompte revueCompte;
   private List exercicesItems;
   private String exerciceSelectionne;
   private boolean showModalPanelRevue = false;
   private boolean showModalPanelInformation = false;
   private String nomCreation;
   private String nomModification;
   private boolean showModalPanelLpr = false;
   private boolean showModalPanelPJ = false;
   private int modePj;
   private boolean conditionPj;
   private String valueScanPj;
   private UtilDownload utilDownload;
   private String urlphotoProd;
   private int typeFichier;

   public FormImpressionGenerale() {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.utilDate = new UtilDate();
      this.listeBalance = new ArrayList();
      this.dataModelBalance = new ListDataModel();
      this.ecritures = new Ecritures();
      this.ecrituresBalance = new EcrituresBalance();
      this.listeCompte = new ArrayList();
      this.dataModelCompte = new ListDataModel();
      this.dataModelDetailPiece = new ListDataModel();
      this.lesRacines = new ArrayList();
      this.lesExportsCompta = new ArrayList();
      this.documentImpressionItems = new ArrayList();
      this.exercicesItems = new ArrayList();
   }

   public void InstancesDaoUtilses() {
      this.planComptableDao = new PlanComptableDao(this.baseLog, this.utilInitHibernate);
      this.journauxComptablesDao = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
      this.lesBalanceAgee = new ArrayList();
      this.ecrituresDao = new EcrituresDao(this.baseLog, this.utilInitHibernate);
      this.revueCompteDao = new RevueCompteDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerLesRepImpCompta(Session var1) throws IOException, HibernateException, NamingException {
      this.lesRepImpression.clear();
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "compta_gene";
      File var3 = new File(var2);
      if (!var3.exists()) {
         var3.mkdir();
      }

      String[] var4 = var3.list();
      if (var4 != null) {
         var4 = this.triAlphabetique(var4, var4.length);

         for(int var5 = 0; var5 < var4.length; ++var5) {
            if (!var4[var5].equalsIgnoreCase(".svn") && !var4[var5].equalsIgnoreCase("index.html") && !var4[var5].equalsIgnoreCase("budgetExploitation") && !var4[var5].equalsIgnoreCase("budgetTresorerie") && !var4[var5].startsWith("extrait") && !var4[var5].equalsIgnoreCase("journal_journalier") && !var4[var5].equalsIgnoreCase("journal_mensuel") && !var4[var5].equalsIgnoreCase("loyer")) {
               String var6 = "";
               var6 = var4[var5].toUpperCase();
               this.lesRepImpression.add(var6);
            }
         }
      }

      this.dataModelImpgen.setWrappedData(this.lesRepImpression);
      this.calculeCentralisation();
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

   public void calculeCentralisation() throws IOException {
      LireLesoptionsCompta var1 = new LireLesoptionsCompta(this.structureLog);
      var1.setStrId(this.structureLog.getStrid());
      this.optionComptabilite = var1.lancer();
      this.var_centralisation = "";
      if (this.optionComptabilite.getCen_c20().equals("true")) {
         this.var_centralisation = this.var_centralisation + "20:";
      } else {
         this.var_centralisation = this.var_centralisation + "0:";
      }

      if (this.optionComptabilite.getCen_c21().equals("true")) {
         this.var_centralisation = this.var_centralisation + "21:";
      } else {
         this.var_centralisation = this.var_centralisation + "0:";
      }

      if (this.optionComptabilite.getCen_c22().equals("true")) {
         this.var_centralisation = this.var_centralisation + "22:";
      } else {
         this.var_centralisation = this.var_centralisation + "0:";
      }

      if (this.optionComptabilite.getCen_c23().equals("true")) {
         this.var_centralisation = this.var_centralisation + "23:";
      } else {
         this.var_centralisation = this.var_centralisation + "0:";
      }

      if (this.optionComptabilite.getCen_c24().equals("true")) {
         this.var_centralisation = this.var_centralisation + "24:";
      } else {
         this.var_centralisation = this.var_centralisation + "0:";
      }

      if (this.optionComptabilite.getCen_c25().equals("true")) {
         this.var_centralisation = this.var_centralisation + "25:";
      } else {
         this.var_centralisation = this.var_centralisation + "0:";
      }

      if (this.optionComptabilite.getCen_c26().equals("true")) {
         this.var_centralisation = this.var_centralisation + "26:";
      } else {
         this.var_centralisation = this.var_centralisation + "0:";
      }

      if (this.optionComptabilite.getCen_c27().equals("true")) {
         this.var_centralisation = this.var_centralisation + "27:";
      } else {
         this.var_centralisation = this.var_centralisation + "0:";
      }

      if (this.optionComptabilite.getCen_c28().equals("true")) {
         this.var_centralisation = this.var_centralisation + "28:";
      } else {
         this.var_centralisation = this.var_centralisation + "0:";
      }

      if (this.optionComptabilite.getCen_c29().equals("true")) {
         this.var_centralisation = this.var_centralisation + "29:";
      } else {
         this.var_centralisation = this.var_centralisation + "0:";
      }

      if (this.optionComptabilite.getCen_c30().equals("true")) {
         this.var_centralisation = this.var_centralisation + "30:";
      } else {
         this.var_centralisation = this.var_centralisation + "0:";
      }

      if (this.optionComptabilite.getCen_c31().equals("true")) {
         this.var_centralisation = this.var_centralisation + "31:";
      } else {
         this.var_centralisation = this.var_centralisation + "0:";
      }

      if (this.optionComptabilite.getCen_c32().equals("true")) {
         this.var_centralisation = this.var_centralisation + "32:";
      } else {
         this.var_centralisation = this.var_centralisation + "0:";
      }

      if (this.optionComptabilite.getCen_c33().equals("true")) {
         this.var_centralisation = this.var_centralisation + "33:";
      } else {
         this.var_centralisation = this.var_centralisation + "0:";
      }

      if (this.optionComptabilite.getCen_c34().equals("true")) {
         this.var_centralisation = this.var_centralisation + "34:";
      } else {
         this.var_centralisation = this.var_centralisation + "0:";
      }

      if (this.optionComptabilite.getCen_c35().equals("true")) {
         this.var_centralisation = this.var_centralisation + "35:";
      } else {
         this.var_centralisation = this.var_centralisation + "0:";
      }

      if (this.optionComptabilite.getCen_c36().equals("true")) {
         this.var_centralisation = this.var_centralisation + "36:";
      } else {
         this.var_centralisation = this.var_centralisation + "0:";
      }

      if (this.optionComptabilite.getCen_c37().equals("true")) {
         this.var_centralisation = this.var_centralisation + "37:";
      } else {
         this.var_centralisation = this.var_centralisation + "0:";
      }

      if (this.optionComptabilite.getCen_c38().equals("true")) {
         this.var_centralisation = this.var_centralisation + "38:";
      } else {
         this.var_centralisation = this.var_centralisation + "0:";
      }

      if (this.optionComptabilite.getCen_c39().equals("true")) {
         this.var_centralisation = this.var_centralisation + "39:";
      } else {
         this.var_centralisation = this.var_centralisation + "0:";
      }

      if (this.optionComptabilite.getCen_c40().equals("true")) {
         this.var_centralisation = this.var_centralisation + "40:";
      } else {
         this.var_centralisation = this.var_centralisation + "0:";
      }

      if (this.optionComptabilite.getCen_c41().equals("true")) {
         this.var_centralisation = this.var_centralisation + "41:";
      } else {
         this.var_centralisation = this.var_centralisation + "0:";
      }

      if (this.optionComptabilite.getCen_c42().equals("true")) {
         this.var_centralisation = this.var_centralisation + "42:";
      } else {
         this.var_centralisation = this.var_centralisation + "0:";
      }

      if (this.optionComptabilite.getCen_c43().equals("true")) {
         this.var_centralisation = this.var_centralisation + "43:";
      } else {
         this.var_centralisation = this.var_centralisation + "0:";
      }

      if (this.optionComptabilite.getCen_c44().equals("true")) {
         this.var_centralisation = this.var_centralisation + "44:";
      } else {
         this.var_centralisation = this.var_centralisation + "0:";
      }

      if (this.optionComptabilite.getCen_c45().equals("true")) {
         this.var_centralisation = this.var_centralisation + "45:";
      } else {
         this.var_centralisation = this.var_centralisation + "0:";
      }

      if (this.optionComptabilite.getCen_c46().equals("true")) {
         this.var_centralisation = this.var_centralisation + "46:";
      } else {
         this.var_centralisation = this.var_centralisation + "0:";
      }

      if (this.optionComptabilite.getCen_c47().equals("true")) {
         this.var_centralisation = this.var_centralisation + "47:";
      } else {
         this.var_centralisation = this.var_centralisation + "0:";
      }

      if (this.optionComptabilite.getCen_c48().equals("true")) {
         this.var_centralisation = this.var_centralisation + "48:";
      } else {
         this.var_centralisation = this.var_centralisation + "0:";
      }

      if (this.optionComptabilite.getCen_c49().equals("true")) {
         this.var_centralisation = this.var_centralisation + "49";
      } else {
         this.var_centralisation = this.var_centralisation + "0";
      }

      if (this.var_centralisation.equals("0:0:0:0:0:0:0:0:0:0:0:0:0:0:0:0:0:0:0:0:0:0:0:0:0:0:0:0:0:0")) {
         this.var_centralisation = "0:0:0:0:0:0:0:0:0:0:0:0:0:0:0:0:0:0:0:0:40:41:42:43:44:45:46:47:48:49";
      }

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
      SelectItem var10 = new SelectItem("", var9);
      this.touslesjournauxComptablesItem.add(var10);

      for(int var11 = 0; var11 < this.touslesjournauxComptables.size(); ++var11) {
         JournauxComptables var12 = (JournauxComptables)this.touslesjournauxComptables.get(var11);
         String var13 = var12.getPljCode();
         String var7 = var12.getPljLibelleFr();
         SelectItem var8 = new SelectItem(var13.concat(":") + var7);
         this.touslesjournauxComptablesItem.add(var8);
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

   public void modeBalance() throws HibernateException, NamingException {
      this.modeBalance = 0;
      this.code = "Compte";
      this.libelle = "Libellé compte";
      this.listeBalance.clear();
      this.dataModelBalance.setWrappedData(this.listeBalance);
      this.calculerNumCpte();
   }

   public void modeBalance(Session var1) throws HibernateException, NamingException {
      this.modeBalance = 0;
      this.code = "Compte";
      this.libelle = "Libellé compte";
      this.listeBalance.clear();
      this.dataModelBalance.setWrappedData(this.listeBalance);
      this.calculerNumCpte(var1);
   }

   public void modeRacine() {
      this.modeBalance = 2;
      this.code = "Racine";
      this.libelle = "Libellé racine";
      this.listeBalance.clear();
      this.dataModelBalance.setWrappedData(this.listeBalance);
      this.filtreCompteDebut = "10";
      this.filtreCompteFin = "99";
   }

   public void modeTransit() {
      this.modeBalance = 1;
      this.typeClasse = 3;
      this.code = "Dossier";
      this.libelle = "Libellé dossier";
      this.listeBalance.clear();
      this.dataModelBalance.setWrappedData(this.listeBalance);
      this.filtreCompteDebut = "";
      this.filtreCompteFin = "";
   }

   public void recupererNomrep() throws HibernateException, NamingException {
      this.testafficheLigne = false;
      this.testafficheExport = false;
      if (this.dataModelImpgen.isRowAvailable()) {
         this.nomRepertoire = (String)this.dataModelImpgen.getRowData();
         this.nomRepertoire = this.nomRepertoire.toLowerCase();
         this.nomEtat = "";
         this.lesFichImpression.clear();
         String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "compta_gene" + File.separator + this.nomRepertoire;
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

         if (!this.nomRepertoire.equalsIgnoreCase("balance_generale") && !this.nomRepertoire.equalsIgnoreCase("balance_convertie") && !this.nomRepertoire.equalsIgnoreCase("grand_livre_general") && !this.nomRepertoire.equalsIgnoreCase("balance_clients") && !this.nomRepertoire.equalsIgnoreCase("balance_fournisseurs") && !this.nomRepertoire.equalsIgnoreCase("grand_livre_clients") && !this.nomRepertoire.equalsIgnoreCase("grand_livre_fournisseurs") && !this.nomRepertoire.equalsIgnoreCase("balance_personnels") && !this.nomRepertoire.equalsIgnoreCase("grand_livre_personnels") && !this.nomRepertoire.equalsIgnoreCase("synthese") && !this.nomRepertoire.equalsIgnoreCase("table")) {
            if (!this.nomRepertoire.equalsIgnoreCase("brouillard") && !this.nomRepertoire.equalsIgnoreCase("tresorerie") && !this.nomRepertoire.equalsIgnoreCase("controles") && !this.nomRepertoire.equalsIgnoreCase("utilisateur")) {
               if (!this.nomRepertoire.equalsIgnoreCase("balance_agee_clients") && !this.nomRepertoire.equalsIgnoreCase("echeancier_clients") && !this.nomRepertoire.equalsIgnoreCase("balance_agee_fournisseurs") && !this.nomRepertoire.equalsIgnoreCase("echeancier_fournisseurs")) {
                  if (this.nomRepertoire.equalsIgnoreCase("commissaires_comptes")) {
                     this.setTestaffiche("commissaires_comptes");
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
                  } else if (!this.nomRepertoire.equalsIgnoreCase("journal_general") && !this.nomRepertoire.equalsIgnoreCase("journal_journalier") && !this.nomRepertoire.equalsIgnoreCase("journal_mensuel")) {
                     if (this.nomRepertoire.equalsIgnoreCase("tva")) {
                        this.setTestaffiche("tva");
                     } else if (this.nomRepertoire.equalsIgnoreCase("brs")) {
                        this.setTestaffiche("brs");
                     } else if (this.nomRepertoire.equalsIgnoreCase("exportation")) {
                        this.setTestaffiche("balance");
                        this.setTestafficheTiers("balanceExt");
                        this.testafficheExport = true;
                        this.lesFichImpression.clear();
                        this.lesFichImpression.add("SAGE V16");
                        this.lesFichImpression.add("SAGE V17");
                     }
                  } else {
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
      this.calculerNumCpte((Session)null);
   }

   public void calculerNumCpte(Session var1) throws HibernateException, NamingException {
      String var2;
      if (this.nomRepertoire.contains("fournisseurs")) {
         var2 = "from PlanComptable where exercicesComptable=" + this.exoSelectionne.getExecpt_id() + " and plcNature=6 order by plcCompte ASC";
         this.lesplanComptablesTiers = this.planComptableDao.chargerPlanComptableImp(var2, var1);
      } else if (this.nomRepertoire.contains("clients")) {
         var2 = "from PlanComptable where exercicesComptable=" + this.exoSelectionne.getExecpt_id() + " and plcNature=7 order by plcCompte ASC";
         this.lesplanComptablesTiers = this.planComptableDao.chargerPlanComptableImp(var2, var1);
      } else if (this.nomRepertoire.contains("personnels")) {
         var2 = "from PlanComptable where exercicesComptable=" + this.exoSelectionne.getExecpt_id() + " and plcNature=8 order by plcCompte ASC";
         this.lesplanComptablesTiers = this.planComptableDao.chargerPlanComptableImp(var2, var1);
      } else if (this.nomRepertoire.contains("commissaires")) {
         var2 = "from PlanComptable where exercicesComptable=" + this.exoSelectionne.getExecpt_id() + " and (plcNature=6 or plcNature=7) order by plcCompte ASC";
         this.lesplanComptablesTiers = this.planComptableDao.chargerPlanComptableImp(var2, var1);
      } else {
         var2 = "from PlanComptable where exercicesComptable=" + this.exoSelectionne.getExecpt_id() + " order by plcCompte ASC";
         this.lesplanComptablesTiers = this.planComptableDao.chargerPlanComptableImp(var2, var1);
      }

      if (this.lesplanComptablesTiers.size() > 0) {
         new PlanComptable();
         PlanComptable var4 = (PlanComptable)this.lesplanComptablesTiers.get(0);
         this.filtreCompteDebut = var4.getPlcCompte();
         int var3 = this.lesplanComptablesTiers.size() - 1;
         var4 = (PlanComptable)this.lesplanComptablesTiers.get(var3);
         this.filtreCompteFin = var4.getPlcCompte();
      } else {
         this.filtreCompteDebut = "";
         this.filtreCompteFin = "";
      }

   }

   public void recupererNomfich() throws HibernateException, NamingException, ParseException {
      if (this.dataModelImpgenFichier.isRowAvailable()) {
         this.nomEtat = (String)this.dataModelImpgenFichier.getRowData();
         this.filtreDateDebut = this.exoSelectionne.getExecptDateDebut();
         this.filtreDateFin = this.exoSelectionne.getExecptDateFin();
         this.calculerNumCpte();
         this.calculeDates();
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
            this.filtreCompteFin = this.planComptable.getPlcCompte();
         } else {
            this.filtreCompteFin = this.planComptable.getPlcCompte();
         }
      } else {
         this.planComptable = null;
         if (!this.type_Compte) {
            this.filtreCompteDebut = "";
            this.filtreCompteFin = "";
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

   public void initBalancesInteractives(Session var1) throws HibernateException, NamingException {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.affMail = false;
      this.nomRepertoire = "balance_generale";
      this.modeBalance(var1);
      this.moduleTransit = this.rechercheModule(80600);
      this.exercicesItems.clear();
      ExercicesComptableDao var2 = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      List var3 = var2.selectExercicesCompta(var1);
      if (var3.size() != 0) {
         for(int var4 = 0; var4 < var3.size(); ++var4) {
            this.exercicesItems.add(new SelectItem(((ExercicesComptable)var3.get(var4)).getExecpt_id()));
         }

         this.exerciceSelectionne = "" + this.exoSelectionne.getExecpt_id();
      }

   }

   public void selectionExercice() throws HibernateException, NamingException, ParseException {
      if (this.exerciceSelectionne != null && !this.exerciceSelectionne.isEmpty()) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "RevueCompte");
         long var2 = Long.parseLong(this.exerciceSelectionne);
         ExercicesComptableDao var4 = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
         ExercicesComptable var5 = var4.recupererLExoSelect(var2, var1);
         if (var5 != null && this.modeBalance == 0) {
            Date var6 = this.utilDate.stringToDateSQLLight(var5.getExecpt_id() + "-01-01");
            Date var7 = this.utilDate.stringToDateSQLLight(var5.getExecpt_id() + "-12-31");
            this.calculeCompteBalance(var6, var7, var5, var1);
            this.dataModelCompte.setWrappedData(this.listeCompte);
            this.ecritures = null;
         }

         this.utilInitHibernate.closeSession();
      }

   }

   public void calculerBalance() throws HibernateException, NamingException, ParseException {
      this.selecFiscalite = this.structureLog.getStrzonefiscale();
      if (this.structureLog.getStrzonefiscale2() != null && !this.structureLog.getStrzonefiscale2().isEmpty()) {
         long var1 = (long)(this.exoSelectionne.getExecptDateFin().getYear() + 1900);
         if (this.structureLog.getStrdatefiscale2() != null && var1 >= (long)(this.structureLog.getStrdatefiscale2().getYear() + 1900)) {
            this.selecFiscalite = this.structureLog.getStrzonefiscale2();
         }
      }

      this.listeBalance.clear();
      if (this.modeBalance == 1) {
         this.calculeRequeteDossier();
         this.listeBalance = this.ecrituresDao.generationDossierTransit(this.var_requete, (Session)null);
      } else if (this.modeBalance == 2) {
         this.calculeRacine();
      } else {
         this.calculeRequete();
         this.listeBalance = this.ecrituresDao.generationBalance(this.var_requete, (Session)null);
         new ArrayList();
         List var4 = this.revueCompteDao.chargerRevue(this.exoSelectionne, (Session)null);
         if (var4.size() != 0) {
            this.revueCompte = new RevueCompte();

            for(int var2 = 0; var2 < var4.size(); ++var2) {
               this.revueCompte = (RevueCompte)var4.get(var2);

               for(int var3 = 0; var3 < this.listeBalance.size(); ++var3) {
                  if (this.revueCompte.getRevcptCompte() != null && !this.revueCompte.getRevcptCompte().isEmpty() && ((EcrituresBalance)this.listeBalance.get(var3)).getEcrBalCompte() != null && !((EcrituresBalance)this.listeBalance.get(var3)).getEcrBalCompte().isEmpty() && this.revueCompte.getRevcptCompte().equals(((EcrituresBalance)this.listeBalance.get(var3)).getEcrBalCompte())) {
                     ((EcrituresBalance)this.listeBalance.get(var3)).setRevueCompte(this.revueCompte.getRevcpObs());
                     break;
                  }
               }
            }
         }
      }

      this.dataModelBalance.setWrappedData(this.listeBalance);
      this.ecrituresBalance = null;
   }

   public void selectionCompte() throws HibernateException, NamingException {
      if (this.dataModelBalance.isRowAvailable()) {
         this.ecrituresBalance = (EcrituresBalance)this.dataModelBalance.getRowData();
         this.var_compte = this.ecrituresBalance.getEcrBalCompte();
         this.var_revue = "";
      }

   }

   public void consulterCompte() throws HibernateException, NamingException {
      if (this.ecrituresBalance != null && this.var_compte != null && !this.var_compte.isEmpty()) {
         this.listeCompte.clear();
         this.var_compte_debit = 0.0D;
         this.var_compte_credit = 0.0D;
         this.var_compte_solde = 0.0D;
         int var1;
         if (this.modeBalance == 1) {
            this.planComptable = null;
            this.listeCompte = this.ecrituresDao.chargerExtraitDossier(this.typeClasse, this.filtreDateDebut, this.filtreDateFin, this.ecrituresBalance.getEcrBalCompte());

            for(var1 = 0; var1 < this.listeCompte.size(); ++var1) {
               this.var_compte_debit += ((Ecritures)this.listeCompte.get(var1)).getEcrDebitSaisie();
               this.var_compte_credit += ((Ecritures)this.listeCompte.get(var1)).getEcrCreditSaisie();
            }

            this.var_compte_solde = this.var_compte_debit - this.var_compte_credit;
         } else if (this.modeBalance != 2) {
            Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "RevueCompte");
            this.planComptable = this.planComptableDao.chercherCompte((String)null, this.var_compte, this.exoSelectionne.getExecpt_id(), var2);
            if (this.planComptable != null) {
               this.calculeCompteBalance(this.filtreDateDebut, this.filtreDateFin, this.exoSelectionne, var2);
            }

            this.utilInitHibernate.closeSession();
         } else {
            this.planComptable = null;
            this.listeCompte = this.ecrituresDao.chargerExtraitStartWith(this.filtreDateDebut, this.filtreDateFin, this.ecrituresBalance.getEcrBalCompte());

            for(var1 = 0; var1 < this.listeCompte.size(); ++var1) {
               this.var_compte_debit += ((Ecritures)this.listeCompte.get(var1)).getEcrDebitSaisie();
               this.var_compte_credit += ((Ecritures)this.listeCompte.get(var1)).getEcrCreditSaisie();
            }

            this.var_compte_solde = this.var_compte_debit - this.var_compte_credit;
         }

         this.dataModelCompte.setWrappedData(this.listeCompte);
         this.ecritures = null;
         this.showModalPanelBalanceCompte = true;
      }

   }

   public void calculeCompteBalance(Date var1, Date var2, ExercicesComptable var3, Session var4) throws HibernateException, NamingException {
      this.var_compte_debit = 0.0D;
      this.var_compte_credit = 0.0D;
      this.listeCompte = this.ecrituresDao.chargerExtrait(var1, var2, this.ecrituresBalance.getEcrBalCompte(), var4);

      for(int var5 = 0; var5 < this.listeCompte.size(); ++var5) {
         this.var_compte_debit += ((Ecritures)this.listeCompte.get(var5)).getEcrDebitSaisie();
         this.var_compte_credit += ((Ecritures)this.listeCompte.get(var5)).getEcrCreditSaisie();
      }

      if (this.planComptable.getPlcSens() == 1) {
         this.var_compte_solde = this.var_compte_credit - this.var_compte_debit;
      } else {
         this.var_compte_solde = this.var_compte_debit - this.var_compte_credit;
      }

      this.var_revue = "";
      this.revueCompte = this.revueCompteDao.chargerRevue(var3, this.var_compte, var4);
      if (this.revueCompte != null) {
         this.var_revue = this.revueCompte.getRevcpObs();
      }

   }

   public void saisirRevue() {
      this.showModalPanelRevue = true;
   }

   public void fermerRevue() {
      this.showModalPanelRevue = false;
   }

   public void validerRevue() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "RevueCompte");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         new ExercicesComptable();
         ExercicesComptableDao var4 = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
         long var5 = Long.parseLong(this.exerciceSelectionne);
         ExercicesComptable var3 = var4.recupererLExoPrecis(var5, var1);
         if (var3 != null) {
            this.revueCompte = this.revueCompteDao.chargerRevue(var3, this.var_compte, var1);
            if (this.revueCompte == null) {
               this.revueCompte = new RevueCompte();
            }

            this.revueCompte.setRevcpObs(this.var_revue);
            this.revueCompte.setRevcptCompte(this.planComptable.getPlcCompte());
            this.revueCompte.setRevcptLibelle(this.planComptable.getPlcLibelleCpteFR());
            this.revueCompte.setRevcptZone(this.planComptable.getPlcFiscalite());
            if (this.revueCompte.getRevcpt_id() == 0L) {
               this.revueCompte.setExercicesComptable(var3);
               this.revueCompte.setRevcptDateCreat(new Date());
               this.revueCompte.setRevcptUserCreat(this.usersLog.getUsrid());
               this.revueCompte = this.revueCompteDao.insert(this.revueCompte, var1);
            } else {
               this.revueCompte.setRevcptDateModif(new Date());
               this.revueCompte.setRevcptUserModif(this.usersLog.getUsrid());
               this.revueCompte = this.revueCompteDao.modif(this.revueCompte, var1);
            }

            this.ecrituresBalance.setRevueCompte(this.var_revue);
         }

         var2.commit();
      } catch (HibernateException var10) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.showModalPanelRevue = false;
   }

   public void fermerCompte() {
      this.showModalPanelBalanceCompte = false;
   }

   public void selectionPiece() {
      if (this.dataModelCompte.isRowAvailable()) {
         this.ecritures = (Ecritures)this.dataModelCompte.getRowData();
         this.var_piece = this.ecritures.getEcrPiece();
      }

   }

   public void consulterPiece() throws HibernateException, NamingException {
      if (this.ecritures != null && this.ecritures.getEcrPiece() != null && !this.ecritures.getEcrPiece().isEmpty()) {
         new ArrayList();
         List var1 = this.ecrituresDao.selectPiece(this.ecritures.getEcrCode(), this.ecritures.getEcrPiece(), this.ecritures.getEcrPeriode());
         if (var1.size() != 0) {
            this.var_tot_debit = 0.0D;
            this.var_tot_credit = 0.0D;
            this.var_solde = 0.0D;

            for(int var2 = 0; var2 < var1.size(); ++var2) {
               this.var_tot_debit += ((Ecritures)var1.get(var2)).getEcrDebitSaisie();
               this.var_tot_credit += ((Ecritures)var1.get(var2)).getEcrCreditSaisie();
            }

            if (this.modeBalance == 1) {
               this.planComptable = null;
               this.var_solde = this.var_tot_debit - this.var_tot_credit;
            } else if (this.modeBalance == 2) {
               this.planComptable = null;
               this.var_solde = this.var_tot_debit - this.var_tot_credit;
            } else if (this.planComptable.getPlcSens() == 1) {
               this.var_solde = this.var_tot_credit - this.var_tot_debit;
            } else {
               this.var_solde = this.var_tot_debit - this.var_tot_credit;
            }

            this.dataModelDetailPiece.setWrappedData(var1);
         }

         this.showModalPanelBalancePiece = true;
      }

   }

   public void fermerPiece() {
      this.showModalPanelBalancePiece = false;
   }

   public void ouvrirDetailsAnalytique() {
   }

   public void initImpressionBalanceInteractive() {
      this.initImpression();
      this.documentImpressionItems.clear();
      this.nomRepertoireInteractif = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "compta_interactif" + File.separator;
      File var1 = new File(this.nomRepertoireInteractif);
      if (!var1.exists()) {
         var1.mkdir();
      }

      String[] var2 = var1.list();
      if (var2 != null) {
         var2 = this.triAlphabetique(var2, var2.length);

         for(int var3 = 0; var3 < var2.length; ++var3) {
            if (var2[var3].endsWith("jasper")) {
               String var4 = var2[var3];
               if (this.verificationAutorisation(var4)) {
                  String var5 = var2[var3].substring(0, var2[var3].indexOf("."));
                  this.documentImpressionItems.add(new SelectItem(var5));
               }
            }
         }
      }

      this.showModalPanelImpressionInteractif = true;
   }

   public void fermerImpressionBalanceInteractive() {
      this.showModalPanelImpressionInteractif = false;
   }

   public void imprimerInteractifEXP() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "EXP";
      this.impressionBalanceInteractive();
   }

   public void imprimerInteractifPRT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "PRT";
      this.impressionBalanceInteractive();
   }

   public void imprimerInteractifJRV() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "JRV";
      this.impressionBalanceInteractive();
   }

   public void imprimerInteractifPDF() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "PDF";
      this.impressionBalanceInteractive();
   }

   public void imprimerInteractifODT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "ODT";
      this.impressionBalanceInteractive();
   }

   public void imprimerInteractifXLS() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "XLS";
      this.impressionBalanceInteractive();
   }

   public void imprimerInteractifDOC() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "DOC";
      this.impressionBalanceInteractive();
   }

   public void imprimerInteractifHTML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "HTML";
      this.impressionBalanceInteractive();
   }

   public void imprimerInteractifXML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "XML";
      this.impressionBalanceInteractive();
   }

   public void imprimerInteractifCSV() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "CSV";
      this.impressionBalanceInteractive();
   }

   public void impressionBalanceInteractive() throws SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      if (this.listeBalance.size() != 0 && this.nomEtat != null && !this.nomEtat.isEmpty()) {
         this.var_ctrl_imp = true;
         this.utilPrint.setRapport(this.nomEtat);
         this.utilPrint.setCheminRapport(this.nomRepertoireInteractif);
         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "sous_rapport" + File.separator);
         this.utilPrint.setRequete("");
         ArrayList var1 = new ArrayList();
         if (this.listeBalance.size() != 0) {
            for(int var2 = 0; var2 < this.listeBalance.size(); ++var2) {
               if (((EcrituresBalance)this.listeBalance.get(var2)).getEcrBalCompte() != null && !((EcrituresBalance)this.listeBalance.get(var2)).getEcrBalCompte().isEmpty()) {
                  var1.add(this.listeBalance.get(var2));
               }
            }
         }

         JRBeanCollectionDataSource var3 = new JRBeanCollectionDataSource(var1);
         this.utilPrint.setjRBeanCollectionDataSource(var3);
         this.utilPrint.setDateDebUk(this.utilDate.dateToStringSQLLight(this.filtreDateDebut));
         this.utilPrint.setDateFinUk(this.utilDate.dateToStringSQLLight(this.filtreDateFin));
         this.utilPrint.setCentralisation(this.var_centralisation);
         this.utilPrint.setExercice(this.exoSelectionne.getExecpt_id());
         this.utilPrint.setFormat(this.format);
         this.utilPrint.setTiersSelectionne((Tiers)null);
         if (this.modeBalance == 0) {
            this.utilPrint.setEntete("Balance intéréactive sur compte du " + this.utilDate.dateToStringFrLg(this.filtreDateDebut) + " au " + this.utilDate.dateToStringFrLg(this.filtreDateFin));
            this.utilPrint.setFiltre("du compte " + this.filtreCompteDebut + " au compte " + this.filtreCompteFin);
            this.utilPrint.setNbCar(2);
         } else if (this.modeBalance == 1) {
            this.utilPrint.setEntete("Balance intéréactive sur Dossier du " + this.utilDate.dateToStringFrLg(this.filtreDateDebut) + " au " + this.utilDate.dateToStringFrLg(this.filtreDateFin));
            if (this.typeClasse == 0) {
               this.utilPrint.setFiltre("Toutes les classes");
            } else if (this.typeClasse == 1) {
               this.utilPrint.setFiltre("Classe 7");
            } else if (this.typeClasse == 2) {
               this.utilPrint.setFiltre("Classe 6");
            } else if (this.typeClasse == 3) {
               this.utilPrint.setFiltre("Classe 47 et 60");
            }

            this.utilPrint.setNbCar(2);
         } else if (this.modeBalance == 2) {
            this.utilPrint.setEntete("Balance intéréactive sur Racine du " + this.utilDate.dateToStringFrLg(this.filtreDateDebut) + " au " + this.utilDate.dateToStringFrLg(this.filtreDateFin));
            this.utilPrint.setFiltre("de la racine " + this.filtreCompteDebut + " à la racine " + this.filtreCompteFin);
            this.utilPrint.setNbCar(2);
         }

         this.utilPrint.setNature(this.modeBalance);
         this.utilPrint.setBaseLog(this.baseLog);
         this.utilPrint.setStructureLog(this.structureLog);
         this.utilPrint.setUsersLog(this.usersLog);
         this.utilPrint.imprimeRapport();
         this.var_ctrl_imp = false;
      }

   }

   public void selectionEcriture() throws HibernateException, NamingException {
      this.selectionEcriture((Session)null);
   }

   public void selectionEcriture(Session var1) throws HibernateException, NamingException {
      if (this.dataModelCompte.isRowAvailable()) {
         this.ecritures = (Ecritures)this.dataModelCompte.getRowData();
         this.conditionPj = false;
         if (this.ecritures != null && this.ecritures.getEcrPiece() != null && !this.ecritures.getEcrPiece().isEmpty()) {
            if (this.ecritures.getEcrNatureJrx() != 7 && this.ecritures.getEcrNatureJrx() != 8 && this.ecritures.getEcrNatureJrx() != 9 && this.ecritures.getEcrNatureJrx() != 10) {
               if (this.ecritures.getEcrCompte() != null && !this.ecritures.getEcrCompte().isEmpty() && (this.ecritures.getEcrCompte().startsWith("3") || this.ecritures.getEcrCompte().startsWith("4"))) {
                  this.conditionPj = true;
               }
            } else if (this.planComptable.getPlcNature() != 10 && this.planComptable.getPlcNature() != 11) {
               this.conditionPj = true;
            }
         }
      }

   }

   public void ouvrirLpr() throws HibernateException, NamingException {
      this.selectionEcriture();
      if (this.ecritures != null) {
         this.showModalPanelLpr = true;
      }

   }

   public void fermerLpr() {
      this.showModalPanelLpr = false;
   }

   public void informationPiece() throws HibernateException, NamingException {
      this.selectionEcriture();
      if (this.ecritures != null) {
         this.nomCreation = "";
         this.nomModification = "";
         new Users();
         UserDao var2 = new UserDao(this.baseLog, this.utilInitHibernate);
         Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         Users var1;
         if (this.ecritures.getEcrUserCreat() != 0L) {
            var1 = var2.selectUserD(this.ecritures.getEcrUserCreat(), var3);
            if (var1 != null) {
               this.nomCreation = var1.getUsrPatronyme();
            }
         }

         if (this.ecritures.getEcrUserModif() != 0L) {
            var1 = var2.selectUserD(this.ecritures.getEcrUserModif(), var3);
            if (var1 != null) {
               this.nomModification = var1.getUsrPatronyme();
            }
         }

         this.utilInitHibernate.closeSession();
         this.showModalPanelInformation = true;
      }

   }

   public void fermerInformationPiece() {
      this.showModalPanelInformation = false;
   }

   public void ouvrirPjConsultation() throws HibernateException, NamingException, MalformedURLException, IOException {
      this.selectionEcriture();
      if (this.ecritures != null && this.ecritures.getEcrPiece() != null && !this.ecritures.getEcrPiece().isEmpty()) {
         this.modePj = 2;
         String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanCompta" + this.ecritures.getExercicesComptable().getExecpt_id() + File.separator;
         File var2 = new File(var1);
         if (!var2.exists()) {
            var2.mkdir();
         }

         String var3 = this.ecritures.getEcrCode() + ":" + this.ecritures.getEcrPeriode() + ":" + this.ecritures.getEcrPiece().replaceAll("/", "_");
         File var4 = new File(var1 + var3 + ".pdf");
         if (var4.exists()) {
            this.typeFichier = 1;
            this.nomFichier = var3 + ".pdf";
         } else {
            this.typeFichier = 0;
            this.nomFichier = var3 + ".jpg";
         }

         if (this.typeFichier == 1) {
            this.utilDownload = new UtilDownload();
            this.fichierUrl = this.utilDownload.convertirFichierUtl(var1 + this.nomFichier, this.urlExplorateur);
            this.fichierMine = this.utilDownload.calculeTypeMine(this.nomFichier);
            this.typeFichier = 1;
         } else {
            this.urlphotoProd = "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanCompta" + this.ecritures.getExercicesComptable().getExecpt_id() + File.separator + this.nomFichier;
            this.typeFichier = 0;
         }

         this.showModalPanelPJ = true;
      }

   }

   public void fermerPj() {
      this.showModalPanelPJ = false;
   }

   public String getUrlIpProd() {
      return StaticModePegase.getUrlIp();
   }

   public void chargerPeriodes() throws ParseException {
      this.mesPeriodesItems.clear();
      this.mesPeriodesItems.add(new SelectItem(""));
      Date var1 = this.exoSelectionne.getExecptDateDebut();
      GregorianCalendar var2 = new GregorianCalendar();
      var2.setTime(var1);
      Date var3 = this.exoSelectionne.getExecptDateFin();
      GregorianCalendar var4 = new GregorianCalendar();
      var4.setTime(var3);
      var2.add(2, -1);
      var4.add(2, -1);
      String var5 = null;

      while(var2.compareTo(var4) < 0) {
         var2.add(2, 1);
         Date var6 = var2.getTime();
         var5 = this.formatPeriode(var6);
         this.mesPeriodesItems.add(new SelectItem(var5));
      }

      this.mesPeriodesItems.add(new SelectItem("1er trimestre"));
      this.mesPeriodesItems.add(new SelectItem("2eme trimestre"));
      this.mesPeriodesItems.add(new SelectItem("3eme trimestre"));
      this.mesPeriodesItems.add(new SelectItem("4eme trimestre"));
      this.mesPeriodesItems.add(new SelectItem("1er semestre"));
      this.mesPeriodesItems.add(new SelectItem("2eme semestre"));
      this.mesPeriodesItems.add(new SelectItem("Annuel"));
      this.filtreDateDebut = var1;
      this.filtreDateFin = var3;
   }

   public String formatPeriode(Date var1) {
      SimpleDateFormat var2 = new SimpleDateFormat("dd-MM-yyyy");
      var2.format(var1);
      String var3 = "" + var2.format(var1);
      String[] var4 = var3.split("-");
      String var5 = var4[0];
      String var6 = var4[1];
      String var7 = var4[2];
      String var8 = var6 + ":" + var7;
      return var8;
   }

   public void calculeDates() throws ParseException {
      if (this.periode != null && !this.periode.isEmpty()) {
         if (this.periode.contains(":")) {
            String[] var1 = this.periode.split(":");
            String var2 = var1[0];
            String var3 = var1[1];
            this.filtreDateDebut = this.utilDate.stringToDateSQLLight(var3 + "-" + var2 + "-" + "01");
            this.filtreDateFin = this.utilDate.dateDernierJourMois(this.filtreDateDebut);
         } else {
            int var4 = (new Date()).getYear() + 1900;
            if (this.periode.equals("1er trimestre")) {
               this.filtreDateDebut = this.utilDate.stringToDateSQLLight(var4 + "-" + "01" + "-" + "01");
               this.filtreDateFin = this.utilDate.stringToDateSQLLight(var4 + "-" + "03" + "-" + "31");
            } else if (this.periode.equals("2eme trimestre")) {
               this.filtreDateDebut = this.utilDate.stringToDateSQLLight(var4 + "-" + "04" + "-" + "01");
               this.filtreDateFin = this.utilDate.stringToDateSQLLight(var4 + "-" + "06" + "-" + "30");
            } else if (this.periode.equals("3eme trimestre")) {
               this.filtreDateDebut = this.utilDate.stringToDateSQLLight(var4 + "-" + "07" + "-" + "01");
               this.filtreDateFin = this.utilDate.stringToDateSQLLight(var4 + "-" + "09" + "-" + "30");
            } else if (this.periode.equals("4eme trimestre")) {
               this.filtreDateDebut = this.utilDate.stringToDateSQLLight(var4 + "-" + "10" + "-" + "01");
               this.filtreDateFin = this.utilDate.stringToDateSQLLight(var4 + "-" + "12" + "-" + "31");
            } else if (this.periode.equals("1er semestre")) {
               this.filtreDateDebut = this.utilDate.stringToDateSQLLight(var4 + "-" + "01" + "-" + "01");
               this.filtreDateFin = this.utilDate.stringToDateSQLLight(var4 + "-" + "06" + "-" + "30");
            } else if (this.periode.equals("2eme semestre")) {
               this.filtreDateDebut = this.utilDate.stringToDateSQLLight(var4 + "-" + "07" + "-" + "01");
               this.filtreDateFin = this.utilDate.stringToDateSQLLight(var4 + "-" + "12" + "-" + "31");
            } else if (this.periode.equals("Annuel")) {
               this.filtreDateDebut = this.utilDate.stringToDateSQLLight(var4 + "-" + "01" + "-" + "01");
               this.filtreDateFin = this.utilDate.stringToDateSQLLight(var4 + "-" + "12" + "-" + "31");
            }
         }
      }

   }

   public void initImpression() {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.affMail = false;
   }

   public boolean rechercheModule(int var1) {
      boolean var2 = false;
      ArrayList var3 = new ArrayList();
      if (this.structureLog.getStrmod1() != null && !this.structureLog.getStrmod1().isEmpty()) {
         var3.add(this.structureLog.getStrmod1());
      }

      if (this.structureLog.getStrmod2() != null && !this.structureLog.getStrmod2().isEmpty()) {
         var3.add(this.structureLog.getStrmod2());
      }

      if (this.structureLog.getStrmod3() != null && !this.structureLog.getStrmod3().isEmpty()) {
         var3.add(this.structureLog.getStrmod3());
      }

      if (this.structureLog.getStrmod4() != null && !this.structureLog.getStrmod4().isEmpty()) {
         var3.add(this.structureLog.getStrmod4());
      }

      if (this.structureLog.getStrmod5() != null && !this.structureLog.getStrmod5().isEmpty()) {
         var3.add(this.structureLog.getStrmod5());
      }

      if (this.structureLog.getStrmod6() != null && !this.structureLog.getStrmod6().isEmpty()) {
         var3.add(this.structureLog.getStrmod6());
      }

      if (this.structureLog.getStrmod7() != null && !this.structureLog.getStrmod7().isEmpty()) {
         var3.add(this.structureLog.getStrmod7());
      }

      if (this.structureLog.getStrmod8() != null && !this.structureLog.getStrmod8().isEmpty()) {
         var3.add(this.structureLog.getStrmod8());
      }

      if (this.structureLog.getStrmod9() != null && !this.structureLog.getStrmod8().isEmpty()) {
         var3.add(this.structureLog.getStrmod9());
      }

      if (this.structureLog.getStrmod10() != null && !this.structureLog.getStrmod10().isEmpty()) {
         var3.add(this.structureLog.getStrmod10());
      }

      for(int var4 = 0; var4 < var3.size(); ++var4) {
         String var5 = "" + var1;
         if (var5.contentEquals((CharSequence)var3.get(var4))) {
            var2 = true;
         }
      }

      return var2;
   }

   public void imprimerEXP() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "EXP";
      this.imprimer();
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
         if (this.nomEtat != null && !this.nomEtat.isEmpty() && (this.nomEtat.equals("SAGE V16") || this.nomEtat.equals("SAGE V17"))) {
            this.exportationEcritures();
         } else {
            JRBeanCollectionDataSource var1;
            if (this.nomEtat.contains("(convertie")) {
               this.utilPrint.setRequete("");
               var1 = new JRBeanCollectionDataSource(this.listeBalance);
               this.utilPrint.setjRBeanCollectionDataSource(var1);
            } else if (!this.nomRepertoire.equalsIgnoreCase("balance_agee_clients") && !this.nomRepertoire.equalsIgnoreCase("balance_agee_fournisseurs")) {
               if (this.nomRepertoire.equalsIgnoreCase("tva")) {
                  this.utilPrint.setRequete("");
                  var1 = new JRBeanCollectionDataSource(this.calculTva());
                  this.utilPrint.setjRBeanCollectionDataSource(var1);
               } else if (this.nomRepertoire.equalsIgnoreCase("brs")) {
                  this.utilPrint.setRequete("");
                  var1 = new JRBeanCollectionDataSource(this.calculBrs());
                  this.utilPrint.setjRBeanCollectionDataSource(var1);
               } else if (this.nomRepertoire.equalsIgnoreCase("budget")) {
                  this.utilPrint.setRequete("");
                  var1 = new JRBeanCollectionDataSource(this.calculBudget());
                  this.utilPrint.setjRBeanCollectionDataSource(var1);
               } else if (!this.nomEtat.contains("Syscohada") && !this.nomEtat.contains("Syscoa") && !this.nomEtat.contains("Ohada")) {
                  this.utilPrint.setRequete(this.var_requete);
                  ArrayList var3 = new ArrayList();
                  JRBeanCollectionDataSource var2 = new JRBeanCollectionDataSource(var3);
                  this.utilPrint.setjRBeanCollectionDataSource(var2);
               } else {
                  this.utilPrint.setRequete("");
                  var1 = new JRBeanCollectionDataSource(this.listeCompte);
                  this.utilPrint.setjRBeanCollectionDataSource(var1);
               }
            } else {
               this.utilPrint.setRequete("");
               var1 = new JRBeanCollectionDataSource(this.lesBalanceAgee);
               this.utilPrint.setjRBeanCollectionDataSource(var1);
            }

            this.utilPrint.setRapport(this.nomEtat);
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "compta_gene" + File.separator + this.nomRepertoire + File.separator);
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
            this.utilPrint.setCentralisation(this.var_centralisation);
            this.utilPrint.setCompte(this.var_compte);
            this.utilPrint.setTotauxTtc("" + this.var_solde_anterieur);
            this.utilPrint.setTotauxHt("0");
            if (this.nomRepertoire.equalsIgnoreCase("controles")) {
               this.utilPrint.setNbCar(Integer.parseInt(this.optionComptabilite.getNbcr()));
            } else {
               this.utilPrint.setNbCar(this.nbreCaractere);
            }

            this.utilPrint.setTypeEcriture(this.typeEcriture);
            this.utilPrint.setExercice(this.exoSelectionne.getExecpt_id());
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
         }
      }

      this.var_ctrl_imp = false;
   }

   public String filtreCompteExclus() throws HibernateException, NamingException {
      String var1 = "";
      ArrayList var2 = new ArrayList();
      if (this.usersLog.getUsrCptInterdit() != null && !this.usersLog.getUsrCptInterdit().isEmpty()) {
         int var4;
         if (!this.usersLog.getUsrCptInterdit().contains(",")) {
            var2.add(this.usersLog.getUsrCptInterdit().replace("'", ""));
         } else {
            String[] var3 = this.usersLog.getUsrCptInterdit().split(",");
            var4 = var3.length;

            for(int var5 = 0; var5 < var4; ++var5) {
               var2.add(var3[var5].replace("'", ""));
            }
         }

         if (var2.size() != 0) {
            new ArrayList();

            for(var4 = 0; var4 < var2.size(); ++var4) {
               String var8 = ((String)var2.get(var4)).toString();
               List var7 = this.planComptableDao.chargerQuiCommence(this.selecFiscalite, this.exoSelectionne.getExecpt_id(), var8, (Session)null);
               if (var7.size() != 0) {
                  for(int var6 = 0; var6 < var7.size(); ++var6) {
                     if (var1 != null && !var1.isEmpty()) {
                        var1 = var1 + ",'" + ((PlanComptable)var7.get(var6)).getPlcCompte() + "'";
                     } else {
                        var1 = "'" + ((PlanComptable)var7.get(var6)).getPlcCompte() + "'";
                     }
                  }
               }
            }
         }
      }

      return var1;
   }

   public void calculeRequete() throws HibernateException, NamingException, ParseException {
      this.var_entete = "";
      this.var_filtre = "";
      this.var_requete = "";
      this.var_solde_anterieur = 0.0D;
      this.var_journal = "";
      this.var_compte = "";
      String var1 = this.utilDate.dateToStringSQLLight(this.filtreDateDebut);
      String var2 = this.utilDate.dateToStringSQLLight(this.filtreDateFin);
      String var3 = this.utilDate.dateToStringFr(this.filtreDateDebut);
      String var4 = this.utilDate.dateToStringFr(this.filtreDateFin);
      String var5 = "";
      String[] var7;
      if (this.listJournal != null && this.listJournal.length != 0) {
         for(int var6 = 0; var6 < this.listJournal.length; ++var6) {
            if (this.listJournal[var6].contains(":")) {
               var7 = this.listJournal[var6].split(":");
               if (var5 != null && !var5.isEmpty()) {
                  var5 = var5 + ",'" + var7[0] + "'";
               } else {
                  var5 = "'" + var7[0] + "'";
               }
            }
         }

         if (var5 != null && !var5.isEmpty()) {
            var5 = "(" + var5 + ")";
         }
      } else {
         var5 = this.journal;
      }

      if (this.nomRepertoire.equalsIgnoreCase("amortissement")) {
         this.var_entete = "Amortissements calculés du " + var3 + " au " + var4;
         if (this.calculAmortissement.equalsIgnoreCase("0")) {
            this.var_filtre = "Calcul sur taux comptable";
         } else {
            this.var_filtre = "Calcul sur taux fiscal";
         }

         this.var_requete = "amo_compteAmo !='' and amo_inactif=0";
      } else {
         String var20;
         String var24;
         if (!this.nomRepertoire.equalsIgnoreCase("balance_generale") && !this.nomRepertoire.equalsIgnoreCase("balance_clients") && !this.nomRepertoire.equalsIgnoreCase("balance_fournisseurs") && !this.nomRepertoire.equalsIgnoreCase("balance_personnels") && !this.nomRepertoire.equalsIgnoreCase("grand_livre_general") && !this.nomRepertoire.equalsIgnoreCase("grand_livre_clients") && !this.nomRepertoire.equalsIgnoreCase("grand_livre_fournisseurs") && !this.nomRepertoire.equalsIgnoreCase("grand_livre_personnels") && !this.nomRepertoire.equalsIgnoreCase("synthese") && !this.nomRepertoire.equalsIgnoreCase("table") && !this.nomRepertoire.equalsIgnoreCase("exportation") && !this.nomRepertoire.equalsIgnoreCase("balance_convertie")) {
            if (!this.nomRepertoire.equalsIgnoreCase("balance_agee_clients") && !this.nomRepertoire.equalsIgnoreCase("balance_agee_fournisseurs")) {
               UserDao var22;
               Users var25;
               if (!this.nomRepertoire.equalsIgnoreCase("echeancier_clients") && !this.nomRepertoire.equalsIgnoreCase("echeancier_fournisseurs")) {
                  if (this.nomRepertoire.equalsIgnoreCase("controles")) {
                     if (this.nomEtat.contains("PrepaCloture")) {
                        this.var_entete = "Préparation cloture du " + var3 + " au " + var4;
                        this.var_requete = "ecr_date_saisie>='" + var1 + "' and  if((ecr_compte like '38%' or ecr_compte like '4%'or ecr_compte like '5%'), ecr_date_saisie<='" + this.utilDate.dateToStringSQLLight(this.exoSelectionne.getExecptDateFin()) + "', ecr_date_saisie<='" + var2 + "') and ecr_nature_jrx!=11 and ecr_nature_jrx!=12 and ecr_nature_jrx!=13";
                        this.var_requete = this.var_requete + " AND ecr_code<>'....'";
                     } else if (this.nomEtat.contains("EcrituresSaisies")) {
                        this.var_entete = "Ecritures saisies entre le" + var3 + " et le " + var4;
                        this.var_requete = "ecr_date_creat between '" + var1 + " 00:00:00" + "' AND '" + var2 + " 23:59:59" + "'";
                        this.var_requete = this.var_requete + " AND ecr_code<>'....'";
                     } else if (this.nomEtat.contains("Syscohada")) {
                        this.controleHorsSyscohada(var1, var2);
                     } else if (this.nomEtat.contains("Syscoa")) {
                        this.controleHorsSyscoa(var1, var2);
                     } else if (this.nomEtat.contains("Ohada")) {
                        this.controleHorsOhada(var1, var2);
                     } else {
                        this.var_entete = this.nomEtat + " du " + var3 + " au " + var4;
                        this.var_requete = "ecr_date_saisie between '" + var1 + "' AND '" + var2 + "'";
                        this.var_requete = this.var_requete + " AND ecr_code<>'....'";
                     }
                  } else {
                     String var23;
                     String[] var26;
                     if (!this.nomRepertoire.equalsIgnoreCase("brouillard") && !this.nomRepertoire.equalsIgnoreCase("utilisateur")) {
                        if (this.nomRepertoire.equalsIgnoreCase("budget")) {
                           var20 = "";
                           if (this.budgetMode == 0) {
                              var20 = "(initial)";
                           } else if (this.budgetMode == 1) {
                              var20 = "(réam1)";
                           } else if (this.budgetMode == 2) {
                              var20 = "(réam2)";
                           } else if (this.budgetMode == 3) {
                              var20 = "(réam3)";
                           }

                           if (this.budgetSelect == 1) {
                              this.var_entete = "Budget " + var20 + " Vente du ";
                           } else if (this.budgetSelect == 2) {
                              this.var_entete = "Budget " + var20 + " Achat du ";
                           } else if (this.budgetSelect == 3) {
                              this.var_entete = "Budget " + var20 + " Production du ";
                           } else if (this.budgetSelect == 4) {
                              this.var_entete = "Budget " + var20 + " Frais Généraux du ";
                           } else if (this.budgetSelect == 5) {
                              this.var_entete = "Budget " + var20 + " Investissement du ";
                           } else if (this.budgetSelect == 6) {
                              this.var_entete = "Budget " + var20 + " TVA du ";
                           } else if (this.budgetSelect == 7) {
                              this.var_entete = "Budget " + var20 + " Impôts et Taxes du ";
                           } else if (this.budgetSelect == 8) {
                              this.var_entete = "Budget " + var20 + " Personnel du ";
                           }

                           this.var_entete = this.var_entete + var3 + " au " + var4;
                           this.var_filtre = "";
                        } else if (this.nomRepertoire.equalsIgnoreCase("commissaires_comptes")) {
                           this.var_entete = "commissaires comptes jusqu'au " + var4;
                           this.var_filtre = "";
                           this.var_requete = "ecr_date_saisie between ' " + var1 + "' AND '" + var2 + "' AND ecr_compte>='" + this.filtreCompteDebut + "' AND ecr_compte<='" + this.filtreCompteFin + "'";
                           this.var_requete = this.var_requete + " AND ecr_nature_jrx<>11 and (ecr_lettrage='' or ecr_lettrage is null)";
                           this.var_requete = this.var_requete + " AND ecr_reserve=0";
                           this.var_requete = this.var_requete + " AND ecr_code<>'....'";
                        } else if (!this.nomRepertoire.equalsIgnoreCase("journal_general") && !this.nomRepertoire.equalsIgnoreCase("journal_journalier") && !this.nomRepertoire.equalsIgnoreCase("journal_mensuel")) {
                           if (this.nomRepertoire.equalsIgnoreCase("loyer")) {
                              this.var_entete = "Loyer " + var3 + " au " + var4;
                              this.var_filtre = "";
                              this.var_requete = "loy_date between  '" + var1 + "' AND ' " + var2 + "'";
                           } else if (this.nomRepertoire.equalsIgnoreCase("rapprochement")) {
                              this.var_entete = "rapprochement du " + var3 + " au " + var4;
                              this.var_filtre = "";
                              this.var_requete = "ecr_date_saisie between ' " + var1 + "'  AND ' " + var2 + "'";
                              if (this.journal.equalsIgnoreCase("Tous les journaux")) {
                                 this.var_requete = this.var_requete + " AND ecr_nature_jrx<>13";
                              } else {
                                 var26 = this.journal.split(":");
                                 var23 = var26[0];
                                 this.var_filtre = this.var_filtre + " Jr " + var23;
                                 this.var_requete = this.var_requete + " AND ecr_code='" + var23 + "'";
                              }

                              this.var_requete = this.var_requete + " AND ecr_code<>'....'";
                              if (this.usersLog.getUsrCptInterdit() != null && !this.usersLog.getUsrCptInterdit().isEmpty()) {
                                 this.var_filtre = this.var_filtre + " Cpt. Exclu(s)";
                                 this.var_requete = this.var_requete + " AND ecr_compte not in (" + this.filtreCompteExclus() + ")";
                              }

                              if (this.usersLog.getUsrJrxInterdit() != null && !this.usersLog.getUsrJrxInterdit().isEmpty()) {
                                 this.var_filtre = this.var_filtre + " Jr. Exclu(s)";
                                 this.var_requete = this.var_requete + " AND ecr_code not in (" + this.usersLog.getUsrJrxInterdit() + ")";
                              }
                           } else if (this.nomRepertoire.equalsIgnoreCase("tresorerie")) {
                              if (this.journal != null && this.journal.contains(":")) {
                                 Session var27 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
                                 var7 = this.journal.split(":");
                                 var24 = "";
                                 String var9 = "";
                                 if (this.exoSelectionne.getExecptDateDebut().getMonth() + 1 <= 9) {
                                    var9 = "0" + (this.exoSelectionne.getExecptDateDebut().getMonth() + 1);
                                 } else {
                                    var9 = "" + (this.exoSelectionne.getExecptDateDebut().getMonth() + 1);
                                 }

                                 String var10 = "" + (this.exoSelectionne.getExecptDateDebut().getYear() + 1900);
                                 String var11 = var9 + ":" + var10;
                                 new JournauxComptables();
                                 JournauxComptables var12 = this.journauxComptablesDao.chercherCode(var7[0], this.exoSelectionne.getExecpt_id(), var27);
                                 if (var12 != null && var12.getPljCompteTreso() != null) {
                                    var24 = var12.getPljCompteTreso();
                                    new ArrayList();
                                    List var13 = this.ecrituresDao.calculSoldeAnterieur(var11, var1, var24, var12.getPljCode(), this.exoSelectionne.getExecpt_id(), var27);
                                    double var14 = 0.0D;
                                    double var16 = 0.0D;
                                    if (var13.size() != 0) {
                                       for(int var18 = 0; var18 < var13.size(); ++var18) {
                                          Ecritures var19 = (Ecritures)var13.get(var18);
                                          var14 += var19.getEcrDebitPays();
                                          var16 += var19.getEcrCreditPays();
                                       }

                                       this.var_solde_anterieur = var14 - var16;
                                    }
                                 }

                                 this.utilInitHibernate.closeSession();
                                 this.var_entete = "Trésorerie du " + var3 + " au " + var4;
                                 this.var_filtre = this.journal;
                                 this.var_journal = var7[0];
                                 this.var_compte = var24;
                              }
                           } else if (this.nomRepertoire.equalsIgnoreCase("tva")) {
                              this.var_entete = "TVA du " + var3 + " au " + var4;
                              this.var_filtre = "";
                              this.var_requete = "ecr_date_saisie between '" + var1 + "'  AND '" + var2 + "' and (ecr_nature_jrx=1 or ecr_nature_jrx=2)";
                              if (!this.inclureJournauxS) {
                                 this.var_requete = this.var_requete + " AND ecr_nature_jrx<>11";
                              }

                              if (!this.inclureJournauxR) {
                                 this.var_requete = this.var_requete + " AND ecr_reserve=0";
                              }

                              this.var_requete = this.var_requete + " AND ecr_code<>'....'";
                              if (this.usersLog.getUsrCptInterdit() != null && !this.usersLog.getUsrCptInterdit().isEmpty()) {
                                 this.var_filtre = this.var_filtre + " Cpt. Exclu(s)";
                                 this.var_requete = this.var_requete + " AND ecr_compte not in (" + this.filtreCompteExclus() + ")";
                              }

                              if (this.usersLog.getUsrJrxInterdit() != null && !this.usersLog.getUsrJrxInterdit().isEmpty()) {
                                 this.var_filtre = this.var_filtre + " Jr. Exclu(s)";
                                 this.var_requete = this.var_requete + " AND ecr_code not in (" + this.usersLog.getUsrJrxInterdit() + ")";
                              }

                              if (this.createur != 0L) {
                                 new Users();
                                 var22 = new UserDao(this.baseLog, this.utilInitHibernate);
                                 var25 = var22.selectByIdUsers(this.createur, (Session)null);
                                 if (var25 != null) {
                                    this.var_filtre = this.var_filtre + " Createur" + var25.getUsrPatronyme();
                                    this.var_requete = this.var_requete + " AND ecr_user_creat  = " + this.createur;
                                 }
                              }
                           } else if (this.nomRepertoire.equalsIgnoreCase("brs")) {
                              this.var_entete = "BRS du " + var3 + " au " + var4;
                              this.var_filtre = "";
                              this.var_requete = "ecr_date_saisie between '" + var1 + "'  AND '" + var2 + "' and (ecr_nature_jrx=1 or ecr_nature_jrx=2)";
                              if (!this.inclureJournauxS) {
                                 this.var_requete = this.var_requete + " AND ecr_nature_jrx<>11";
                              }

                              if (!this.inclureJournauxR) {
                                 this.var_requete = this.var_requete + " AND ecr_reserve=0";
                              }

                              this.var_requete = this.var_requete + " AND ecr_code<>'....'";
                              if (this.usersLog.getUsrCptInterdit() != null && !this.usersLog.getUsrCptInterdit().isEmpty()) {
                                 this.var_filtre = this.var_filtre + " Cpt. Exclu(s)";
                                 this.var_requete = this.var_requete + " AND ecr_compte not in (" + this.filtreCompteExclus() + ")";
                              }

                              if (this.usersLog.getUsrJrxInterdit() != null && !this.usersLog.getUsrJrxInterdit().isEmpty()) {
                                 this.var_filtre = this.var_filtre + " Jr. Exclu(s)";
                                 this.var_requete = this.var_requete + " AND ecr_code not in (" + this.usersLog.getUsrJrxInterdit() + ")";
                              }

                              if (this.createur != 0L) {
                                 new Users();
                                 var22 = new UserDao(this.baseLog, this.utilInitHibernate);
                                 var25 = var22.selectByIdUsers(this.createur, (Session)null);
                                 if (var25 != null) {
                                    this.var_filtre = this.var_filtre + " Createur" + var25.getUsrPatronyme();
                                    this.var_requete = this.var_requete + " AND ecr_user_creat  = " + this.createur;
                                 }
                              }
                           }
                        } else {
                           this.var_entete = "Impression des journaux du " + var3 + " au " + var4;
                           this.var_filtre = "";
                           this.var_requete = "ecr_date_saisie between '" + var1 + "' AND '" + var2 + "'";
                           if (this.journal.equalsIgnoreCase("Tous les Journaux")) {
                              this.var_filtre = "Tous les journaux";
                              this.var_requete = this.var_requete + " AND ecr_nature_jrx<>13";
                           } else {
                              var26 = this.journal.split(":");
                              var23 = var26[0];
                              this.var_filtre = "Le journal : " + var23;
                              this.var_requete = this.var_requete + " AND ecr_code='" + var23 + "'";
                           }

                           this.var_requete = this.var_requete + " AND ecr_code<>'....'";
                           if (!this.inclureJournauxS) {
                              this.var_requete = this.var_requete + " AND ecr_nature_jrx<>11";
                           } else {
                              this.var_filtre = this.var_filtre + "(avec JR de situation)";
                           }

                           if (!this.inclureJournauxR) {
                              this.var_requete = this.var_requete + " AND ecr_reserve=0";
                           } else {
                              this.var_filtre = this.var_filtre + "(avec JR réservés)";
                           }

                           if (this.usersLog.getUsrCptInterdit() != null && !this.usersLog.getUsrCptInterdit().isEmpty()) {
                              this.var_filtre = this.var_filtre + " Cpt. Exclu(s)";
                              this.var_requete = this.var_requete + " AND ecr_compte not in (" + this.filtreCompteExclus() + ")";
                           }

                           if (this.usersLog.getUsrJrxInterdit() != null && !this.usersLog.getUsrJrxInterdit().isEmpty()) {
                              this.var_filtre = this.var_filtre + " Jr. Exclu(s)";
                              this.var_requete = this.var_requete + " AND ecr_code not in (" + this.usersLog.getUsrJrxInterdit() + ")";
                           }

                           if (this.createur != 0L) {
                              new Users();
                              var22 = new UserDao(this.baseLog, this.utilInitHibernate);
                              var25 = var22.selectByIdUsers(this.createur, (Session)null);
                              if (var25 != null) {
                                 this.var_filtre = this.var_filtre + " Createur" + var25.getUsrPatronyme();
                                 this.var_requete = this.var_requete + " AND ecr_user_creat  = " + this.createur;
                              }
                           }
                        }
                     } else {
                        this.var_entete = this.nomRepertoire + " du " + var3 + " au " + var4;
                        this.var_requete = "bro_date_saisie between '" + var1 + "' AND '" + var2 + "' AND cpt_ecritures.ecr_compte>='" + this.filtreCompteDebut + "' AND cpt_ecritures.ecr_compte<='" + this.filtreCompteFin + "'";
                        if (!this.inclureJournauxS) {
                           this.var_requete = this.var_requete + " AND bro_nature_jrx<>11";
                        }

                        if (!this.inclureJournauxR) {
                           this.var_requete = this.var_requete + " AND cpt_ecritures.ecr_reserve=0";
                        }

                        if (this.journal.equalsIgnoreCase("Tous les journaux")) {
                           this.var_requete = this.var_requete + " AND bro_nature_jrx<>13";
                        } else {
                           var26 = this.journal.split(":");
                           var23 = var26[0];
                           this.var_filtre = this.var_filtre + " Jr " + var23;
                           this.var_requete = this.var_requete + " AND bro_code='" + var23 + "'";
                        }

                        if (this.usersLog.getUsrCptInterdit() != null && !this.usersLog.getUsrCptInterdit().isEmpty()) {
                           this.var_filtre = this.var_filtre + " Cpt. Exclu(s)";
                           this.var_requete = this.var_requete + " AND bro_compte not in (" + this.filtreCompteExclus() + ")";
                        }

                        if (this.usersLog.getUsrJrxInterdit() != null && !this.usersLog.getUsrJrxInterdit().isEmpty()) {
                           this.var_filtre = this.var_filtre + " Jr. Exclu(s)";
                           this.var_requete = this.var_requete + " AND bro_code not in (" + this.usersLog.getUsrJrxInterdit() + ")";
                        }

                        if (this.createur != 0L) {
                           new Users();
                           var22 = new UserDao(this.baseLog, this.utilInitHibernate);
                           var25 = var22.selectByIdUsers(this.createur, (Session)null);
                           if (var25 != null) {
                              this.var_filtre = this.var_filtre + " Createur" + var25.getUsrPatronyme();
                              this.var_requete = this.var_requete + " AND ecr_user_creat  = " + this.createur;
                           }
                        }
                     }
                  }
               } else {
                  this.var_entete = "Relevé compte jusqu'au " + var4;
                  this.var_requete = "execpt_id=" + this.exoSelectionne.getExecpt_id();
                  this.var_requete = this.var_requete + " AND ecr_code<>'....'";
                  this.var_requete = this.var_requete + " and ecr_etat<>2 and ecr_nature_jrx<>13 and (ecr_lettrage='' or ecr_lettrage is null)";
                  this.var_filtre = "Calcul sur date echéance";
                  this.var_requete = this.var_requete + " and ((ecr_nature_jrx<>15 and ecr_date_echeance is not null and ecr_date_echeance>='" + this.utilDate.dateToStringSQLLight(this.exoSelectionne.getExecptDateDebut()) + "' and ecr_date_echeance<='" + var2 + "') or ((ecr_nature_jrx=15 or ecr_date_echeance is null) and ecr_date_saisie>='" + this.utilDate.dateToStringSQLLight(this.exoSelectionne.getExecptDateDebut()) + "' and ecr_date_saisie<='" + var2 + "'))";
                  this.var_requete = this.var_requete + " and ecr_compte>='" + this.filtreCompteDebut + "' and ecr_compte<='" + this.filtreCompteFin + "'";
                  if (!this.inclureJournauxS) {
                     this.var_requete = this.var_requete + " and ecr_nature_jrx<>11";
                  }

                  if (!this.inclureJournauxR) {
                     this.var_requete = this.var_requete + " and ecr_reserve=0";
                  }

                  if (this.usersLog.getUsrCptInterdit() != null && !this.usersLog.getUsrCptInterdit().isEmpty()) {
                     this.var_filtre = this.var_filtre + " Cpt. Exclu(s)";
                     this.var_requete = this.var_requete + " AND ecr_compte not in (" + this.filtreCompteExclus() + ")";
                  }

                  if (this.usersLog.getUsrJrxInterdit() != null && !this.usersLog.getUsrJrxInterdit().isEmpty()) {
                     this.var_filtre = this.var_filtre + " Jr. Exclu(s)";
                     this.var_requete = this.var_requete + " AND ecr_code not in (" + this.usersLog.getUsrJrxInterdit() + ")";
                  }

                  if (this.createur != 0L) {
                     new Users();
                     var22 = new UserDao(this.baseLog, this.utilInitHibernate);
                     var25 = var22.selectByIdUsers(this.createur, (Session)null);
                     if (var25 != null) {
                        this.var_filtre = this.var_filtre + " Createur" + var25.getUsrPatronyme();
                        this.var_requete = this.var_requete + " AND ecr_user_creat  = " + this.createur;
                     }
                  }
               }
            } else {
               this.calculBalanceAgee(var4, var2);
            }
         } else {
            if (this.nomEtat.equals("GrandLivreCompletAvecAnterieurCumule") || this.nomEtat.equals("GrandLivreClientsAvecAnterieurCumule") || this.nomEtat.equals("GrandLivreFournisseursAvecAnterieurCumule")) {
               var1 = this.utilDate.dateToStringSQLLight(this.exoSelectionne.getExecptDateDebut());
            }

            var20 = "";
            if (this.nomEtat.equals("BalanceComplete(convertieSYSCOHADA)")) {
               var20 = "Balance Complete (convertie SYSCOHADA)";
            } else if (this.nomEtat.startsWith("BalanceComplete")) {
               var20 = "Balance Complète";
            } else if (this.nomEtat.startsWith("BalanceCloture")) {
               var20 = "Balance de Cloture";
            } else if (this.nomEtat.startsWith("BalanceGenerale")) {
               var20 = "Balance Générale";
            } else if (this.nomEtat.startsWith("BalanceTresorerie")) {
               var20 = "Balance de Trésorerie";
            } else if (this.nomEtat.startsWith("GrandLivreGeneral")) {
               var20 = "Grand Livre Général";
            } else if (!this.nomEtat.startsWith("GrandLivreComplet") && !this.nomEtat.contains("SAGE")) {
               if (this.nomEtat.startsWith("GrandLivreTresorerie")) {
                  var20 = "Grand Livre de Trésorerie";
               } else {
                  var20 = this.nomRepertoire.toUpperCase();
               }
            } else {
               var20 = "Grand Livre Complet";
            }

            this.var_entete = var20 + " du " + var3 + " au " + var4;
            if (this.typeEcriture.equalsIgnoreCase("0")) {
               this.var_filtre = "Toutes les écritures du compte " + this.filtreCompteDebut + " au compte " + this.filtreCompteFin;
               this.var_requete = "(ecr_date_saisie>='" + var1 + "' AND ecr_date_saisie<='" + var2 + "')";
            } else if (this.typeEcriture.equalsIgnoreCase("1")) {
               this.var_filtre = "Ecritures non lettrées du compte " + this.filtreCompteDebut + " au compte " + this.filtreCompteFin;
               if (!this.filtreDateFin.equals(this.exoSelectionne.getExecptDateFin())) {
                  this.var_requete = "(ecr_date_saisie>='" + var1 + "' AND ecr_date_saisie<='" + var2 + "')";
               } else {
                  this.var_requete = "(ecr_date_saisie>='" + var1 + "' AND ecr_date_saisie<='" + var2 + "') AND (ecr_lettrage='' or ecr_lettrage is null)";
               }
            } else if (this.typeEcriture.equalsIgnoreCase("2")) {
               this.var_filtre = "Ecritures lettrées du compte " + this.filtreCompteDebut + " au compte " + this.filtreCompteFin;
               this.var_requete = "(ecr_date_saisie>='" + var1 + "' AND ecr_date_saisie<='" + var2 + "') AND (ecr_lettrage<>'' and ecr_lettrage is not null)";
            } else if (this.typeEcriture.equalsIgnoreCase("3")) {
               this.var_filtre = "Ecritures non pointées du compte " + this.filtreCompteDebut + " au compte " + this.filtreCompteFin;
               this.var_requete = "(ecr_date_saisie>='" + var1 + "' AND ecr_date_saisie<='" + var2 + "') AND (ecr_pointage='' or ecr_pointage is null)";
            } else if (this.typeEcriture.equalsIgnoreCase("4")) {
               this.var_filtre = "Ecritures pointées du compte " + this.filtreCompteDebut + " au compte " + this.filtreCompteFin;
               this.var_requete = "(ecr_date_saisie>='" + var1 + "' AND ecr_date_saisie<='" + var2 + "') AND (ecr_pointage<>'' and ecr_pointage is not null)";
            } else if (this.typeEcriture.equalsIgnoreCase("5")) {
               this.var_filtre = "Ecritures non lettrées et pointées du compte " + this.filtreCompteDebut + " au compte " + this.filtreCompteFin;
               this.var_requete = "(ecr_date_saisie>='" + var1 + "' AND ecr_date_saisie<='" + var2 + "') AND (ecr_lettrage='' or ecr_lettrage is null) AND (ecr_pointage<>'' and ecr_pointage is not null)";
            } else if (this.typeEcriture.equalsIgnoreCase("6")) {
               this.var_filtre = "Ecritures lettrées et pointées du compte " + this.filtreCompteDebut + " au compte " + this.filtreCompteFin;
               this.var_requete = "(ecr_date_saisie>='" + var1 + "' AND ecr_date_saisie<='" + var2 + "') AND (ecr_lettrage='' or ecr_lettrage is null) AND (ecr_pointage='' or ecr_pointage is null)";
            } else if (this.typeEcriture.equalsIgnoreCase("7")) {
               this.var_filtre = "Toutes les écritures du compte hors comptes soldés " + this.filtreCompteDebut + " au compte " + this.filtreCompteFin;
               this.var_requete = "(ecr_date_saisie>='" + var1 + "' AND ecr_date_saisie<='" + var2 + "')";
            }

            if (!this.nomRepertoire.equalsIgnoreCase("balance_fournisseurs") && !this.nomRepertoire.equalsIgnoreCase("grand_livre_fournisseurs")) {
               if (!this.nomRepertoire.equalsIgnoreCase("balance_clients") && !this.nomRepertoire.equalsIgnoreCase("grand_livre_clients")) {
                  this.var_requete = this.var_requete + " AND (ecr_compte>='" + this.filtreCompteDebut + "' AND ecr_compte<='" + this.filtreCompteFin + "')";
               } else {
                  this.var_requete = this.var_requete + " AND (ecr_nature=7) AND (ecr_compte>='" + this.filtreCompteDebut + "' AND ecr_compte<='" + this.filtreCompteFin + "')";
               }
            } else {
               this.var_requete = this.var_requete + " AND (ecr_nature=6) AND (ecr_compte>='" + this.filtreCompteDebut + "' AND ecr_compte<='" + this.filtreCompteFin + "')";
            }

            this.var_requete = this.var_requete + " AND ecr_code<>'....'";
            if (this.nomEtat.contains("Cloture")) {
               this.var_requete = this.var_requete + " and  ecr_nature_jrx<>13";
            } else {
               this.var_requete = this.var_requete + " and  ecr_nature_jrx<>13 and ecr_nature_jrx<>14";
            }

            if (!this.inclureJournauxS) {
               this.var_requete = this.var_requete + " AND ecr_nature_jrx<>11";
            }

            if (!this.inclureJournauxR) {
               this.var_requete = this.var_requete + " AND ecr_reserve=0";
            }

            if (this.usersLog.getUsrCptInterdit() != null && !this.usersLog.getUsrCptInterdit().isEmpty()) {
               this.var_filtre = this.var_filtre + " Cpt. Exclu(s)";
               this.var_requete = this.var_requete + " AND ecr_compte not in (" + this.filtreCompteExclus() + ")";
            }

            if (this.usersLog.getUsrJrxInterdit() != null && !this.usersLog.getUsrJrxInterdit().isEmpty()) {
               this.var_filtre = this.var_filtre + " Jr. Exclu(s)";
               this.var_requete = this.var_requete + " AND ecr_code not in (" + this.usersLog.getUsrJrxInterdit() + ")";
            }

            if (this.createur != 0L) {
               new Users();
               UserDao var8 = new UserDao(this.baseLog, this.utilInitHibernate);
               Users var21 = var8.selectByIdUsers(this.createur, (Session)null);
               if (var21 != null) {
                  this.var_filtre = this.var_filtre + " Createur" + var21.getUsrPatronyme();
                  this.var_requete = this.var_requete + " AND ecr_user_creat  = " + this.createur;
               }
            }

            if (var5 != null && !var5.isEmpty()) {
               if (var5.contains(":")) {
                  var7 = var5.split(":");
                  var24 = var7[0];
                  this.var_filtre = this.var_filtre + " Jr " + var24;
                  this.var_requete = this.var_requete + " AND ecr_code='" + var24 + "'";
               } else if (var5.contains("(")) {
                  this.var_filtre = this.var_filtre + " Jrx " + var5;
                  this.var_requete = this.var_requete + " AND ecr_code in" + var5;
               }
            }

            if (this.typeEcriture.equalsIgnoreCase("1") && !this.filtreDateFin.equals(this.exoSelectionne.getExecptDateFin())) {
               this.calculeEcrituresNonLettrees();
            } else if (this.typeEcriture.equalsIgnoreCase("2") && !this.filtreDateFin.equals(this.exoSelectionne.getExecptDateFin())) {
               this.calculeEcrituresLettrees();
            }

            if (this.nomEtat.contains("(convertie")) {
               this.calculBalanceConvertie();
            }
         }
      }

   }

   public void calculeRequeteDossier() throws HibernateException, NamingException, ParseException {
      this.var_entete = "";
      this.var_filtre = "";
      this.var_requete = "";
      this.var_solde_anterieur = 0.0D;
      this.var_journal = "";
      this.var_compte = "";
      String var1 = this.utilDate.dateToStringSQLLight(this.filtreDateDebut);
      String var2 = this.utilDate.dateToStringSQLLight(this.filtreDateFin);
      String var3 = this.utilDate.dateToStringFr(this.filtreDateDebut);
      String var4 = this.utilDate.dateToStringFr(this.filtreDateFin);
      this.var_filtre = "Toutes les écritures des dossiers ";
      this.var_requete = "(ecr_date_saisie>='" + var1 + "' AND ecr_date_saisie<='" + var2 + "')";
      this.var_requete = this.var_requete + " and ecr_dossier is not null and ecr_dossier <> '' ";
      String var5 = "";
      if (this.typeClasse == 0) {
         var5 = "Balance complète";
      } else if (this.typeClasse == 1) {
         var5 = "Balance des produits";
         this.var_requete = this.var_requete + " and ecr_compte like '7%'";
      } else if (this.typeClasse == 2) {
         var5 = "Balance des charges";
         this.var_requete = this.var_requete + " and ecr_compte like '6%'";
      } else if (this.typeClasse == 3) {
         var5 = "Balance des débours et des charges";
         this.var_requete = this.var_requete + " and (ecr_compte like '47%' or ecr_compte like '60%')";
      }

      this.var_entete = var5 + " du " + var3 + " au " + var4;
      this.var_requete = this.var_requete + " AND ecr_code<>'....'";
      if (this.nomEtat.contains("Cloture")) {
         this.var_requete = this.var_requete + " and  ecr_nature_jrx<>13";
      } else {
         this.var_requete = this.var_requete + " and  ecr_nature_jrx<>13 and ecr_nature_jrx<>14";
      }

      if (!this.inclureJournauxS) {
         this.var_requete = this.var_requete + " AND ecr_nature_jrx<>11";
      }

      if (!this.inclureJournauxR) {
         this.var_requete = this.var_requete + " AND ecr_reserve=0";
      }

      if (this.usersLog.getUsrCptInterdit() != null && !this.usersLog.getUsrCptInterdit().isEmpty()) {
         this.var_filtre = this.var_filtre + " Cpt. Exclu(s)";
         this.var_requete = this.var_requete + " AND ecr_compte not in (" + this.filtreCompteExclus() + ")";
      }

      if (this.usersLog.getUsrJrxInterdit() != null && !this.usersLog.getUsrJrxInterdit().isEmpty()) {
         this.var_filtre = this.var_filtre + " Jr. Exclu(s)";
         this.var_requete = this.var_requete + " AND ecr_code not in (" + this.usersLog.getUsrJrxInterdit() + ")";
      }

   }

   public void calculeRacine() throws HibernateException, NamingException, ParseException {
      this.var_entete = "";
      this.var_filtre = "";
      this.var_requete = "";
      this.var_solde_anterieur = 0.0D;
      this.var_journal = "";
      this.var_compte = "";
      String var1 = this.utilDate.dateToStringSQLLight(this.filtreDateDebut);
      String var2 = this.utilDate.dateToStringSQLLight(this.filtreDateFin);
      String var3 = this.utilDate.dateToStringFr(this.filtreDateDebut);
      String var4 = this.utilDate.dateToStringFr(this.filtreDateFin);
      String var5 = "";
      String[] var7;
      if (this.listJournal != null && this.listJournal.length != 0) {
         for(int var6 = 0; var6 < this.listJournal.length; ++var6) {
            if (this.listJournal[var6].contains(":")) {
               var7 = this.listJournal[var6].split(":");
               if (var5 != null && !var5.isEmpty()) {
                  var5 = var5 + ",'" + var7[0] + "'";
               } else {
                  var5 = "'" + var7[0] + "'";
               }
            }
         }

         if (var5 != null && !var5.isEmpty()) {
            var5 = "(" + var5 + ")";
         }
      } else {
         var5 = this.journal;
      }

      String var24 = "Balance sur Racines";
      this.var_entete = var24 + " du " + var3 + " au " + var4;
      if (this.typeEcriture.equalsIgnoreCase("0")) {
         this.var_filtre = "Toutes les écritures du compte " + this.filtreCompteDebut + " au compte " + this.filtreCompteFin;
         this.var_requete = "(ecr_date_saisie>='" + var1 + "' AND ecr_date_saisie<='" + var2 + "')";
      } else if (this.typeEcriture.equalsIgnoreCase("1")) {
         this.var_filtre = "Ecritures non lettrées du compte " + this.filtreCompteDebut + " au compte " + this.filtreCompteFin;
         if (!this.filtreDateFin.equals(this.exoSelectionne.getExecptDateFin())) {
            this.var_requete = "(ecr_date_saisie>='" + var1 + "' AND ecr_date_saisie<='" + var2 + "')";
         } else {
            this.var_requete = "(ecr_date_saisie>='" + var1 + "' AND ecr_date_saisie<='" + var2 + "') AND (ecr_lettrage='' or ecr_lettrage is null)";
         }
      } else if (this.typeEcriture.equalsIgnoreCase("2")) {
         this.var_filtre = "Ecritures lettrées du compte " + this.filtreCompteDebut + " au compte " + this.filtreCompteFin;
         this.var_requete = "(ecr_date_saisie>='" + var1 + "' AND ecr_date_saisie<='" + var2 + "') AND (ecr_lettrage<>'' and ecr_lettrage is not null)";
      } else if (this.typeEcriture.equalsIgnoreCase("3")) {
         this.var_filtre = "Ecritures non pointées du compte " + this.filtreCompteDebut + " au compte " + this.filtreCompteFin;
         this.var_requete = "(ecr_date_saisie>='" + var1 + "' AND ecr_date_saisie<='" + var2 + "') AND (ecr_pointage='' or ecr_pointage is null)";
      } else if (this.typeEcriture.equalsIgnoreCase("4")) {
         this.var_filtre = "Ecritures pointées du compte " + this.filtreCompteDebut + " au compte " + this.filtreCompteFin;
         this.var_requete = "(ecr_date_saisie>='" + var1 + "' AND ecr_date_saisie<='" + var2 + "') AND (ecr_pointage<>'' and ecr_pointage is not null)";
      } else if (this.typeEcriture.equalsIgnoreCase("5")) {
         this.var_filtre = "Ecritures non lettrées et pointées du compte " + this.filtreCompteDebut + " au compte " + this.filtreCompteFin;
         this.var_requete = "(ecr_date_saisie>='" + var1 + "' AND ecr_date_saisie<='" + var2 + "') AND (ecr_lettrage='' or ecr_lettrage is null) AND (ecr_pointage<>'' and ecr_pointage is not null)";
      } else if (this.typeEcriture.equalsIgnoreCase("6")) {
         this.var_filtre = "Ecritures lettrées et pointées du compte " + this.filtreCompteDebut + " au compte " + this.filtreCompteFin;
         this.var_requete = "(ecr_date_saisie>='" + var1 + "' AND ecr_date_saisie<='" + var2 + "') AND (ecr_lettrage='' or ecr_lettrage is null) AND (ecr_pointage='' or ecr_pointage is null)";
      } else if (this.typeEcriture.equalsIgnoreCase("7")) {
         this.var_filtre = "Toutes les écritures du compte hors comptes soldés " + this.filtreCompteDebut + " au compte " + this.filtreCompteFin;
         this.var_requete = "(ecr_date_saisie>='" + var1 + "' AND ecr_date_saisie<='" + var2 + "')";
      }

      this.var_requete = this.var_requete + " AND (ecr_compte>='" + this.filtreCompteDebut + "' AND ecr_compte<='" + this.filtreCompteFin + "')";
      this.var_requete = this.var_requete + " AND ecr_code<>'....'";
      if (this.nomEtat.contains("Cloture")) {
         this.var_requete = this.var_requete + " and  ecr_nature_jrx<>13";
      } else {
         this.var_requete = this.var_requete + " and  ecr_nature_jrx<>13 and ecr_nature_jrx<>14";
      }

      if (!this.inclureJournauxS) {
         this.var_requete = this.var_requete + " AND ecr_nature_jrx<>11";
      }

      if (!this.inclureJournauxR) {
         this.var_requete = this.var_requete + " AND ecr_reserve=0";
      }

      if (this.usersLog.getUsrCptInterdit() != null && !this.usersLog.getUsrCptInterdit().isEmpty()) {
         this.var_filtre = this.var_filtre + " Cpt. Exclu(s)";
         this.var_requete = this.var_requete + " AND ecr_compte not in (" + this.filtreCompteExclus() + ")";
      }

      if (this.usersLog.getUsrJrxInterdit() != null && !this.usersLog.getUsrJrxInterdit().isEmpty()) {
         this.var_filtre = this.var_filtre + " Jr. Exclu(s)";
         this.var_requete = this.var_requete + " AND ecr_code not in (" + this.usersLog.getUsrJrxInterdit() + ")";
      }

      if (this.createur != 0L) {
         new Users();
         UserDao var8 = new UserDao(this.baseLog, this.utilInitHibernate);
         Users var25 = var8.selectByIdUsers(this.createur, (Session)null);
         if (var25 != null) {
            this.var_filtre = this.var_filtre + " Createur" + var25.getUsrPatronyme();
            this.var_requete = this.var_requete + " AND ecr_user_creat  = " + this.createur;
         }
      }

      if (var5 != null && !var5.isEmpty()) {
         if (var5.contains(":")) {
            var7 = var5.split(":");
            String var27 = var7[0];
            this.var_filtre = this.var_filtre + " Jr " + var27;
            this.var_requete = this.var_requete + " AND ecr_code='" + var27 + "'";
         } else if (var5.contains("(")) {
            this.var_filtre = this.var_filtre + " Jrx " + var5;
            this.var_requete = this.var_requete + " AND ecr_code in" + var5;
         }
      }

      if (this.typeEcriture.equalsIgnoreCase("1") && !this.filtreDateFin.equals(this.exoSelectionne.getExecptDateFin())) {
         this.calculeEcrituresNonLettrees();
      } else if (this.typeEcriture.equalsIgnoreCase("2") && !this.filtreDateFin.equals(this.exoSelectionne.getExecptDateFin())) {
         this.calculeEcrituresLettrees();
      }

      this.listeCompte = new ArrayList();
      this.listeCompte = this.ecrituresDao.ChargerLesEcrituresRecherche(this.var_requete, (Session)null);
      this.listeBalance = new ArrayList();
      ArrayList var26 = new ArrayList();
      RacinesDao var28 = new RacinesDao(this.baseLog, this.structureLog, this.utilInitHibernate);
      this.lesRacines.clear();
      this.lesRacines = var28.chargerMesRacinesUtiles(this.selecFiscalite, (Session)null);
      if (this.lesRacines.size() != 0) {
         new Racines();
         this.ecrituresBalance = new EcrituresBalance();

         for(int var10 = 0; var10 < this.lesRacines.size(); ++var10) {
            Racines var9 = (Racines)this.lesRacines.get(var10);
            this.ecrituresBalance = new EcrituresBalance();
            this.ecrituresBalance.setEcrBalCompte(var9.getRacCode());
            this.ecrituresBalance.setEcrBalLibelle(var9.getRacLibelleFr());
            double var11 = 0.0D;
            double var13 = 0.0D;
            double var15 = 0.0D;
            double var17 = 0.0D;
            double var19 = 0.0D;
            double var21 = 0.0D;

            for(int var23 = 0; var23 < this.listeCompte.size(); ++var23) {
               this.ecritures = (Ecritures)this.listeCompte.get(var23);
               if (this.ecritures.getEcrCompte().startsWith(var9.getRacCode())) {
                  if (this.ecritures.getEcrNatureJrx() == 15) {
                     var11 += this.ecritures.getEcrDebitSaisie();
                     var13 += this.ecritures.getEcrCreditSaisie();
                  } else {
                     var15 += this.ecritures.getEcrDebitSaisie();
                     var17 += this.ecritures.getEcrCreditSaisie();
                  }
               }
            }

            if (var11 + var15 > var13 + var17) {
               var19 = var11 + var15 - (var13 + var17);
               var21 = 0.0D;
            } else {
               var19 = 0.0D;
               var21 = var13 + var17 - (var11 + var15);
            }

            this.ecrituresBalance.setEcrDebitAN(var11);
            this.ecrituresBalance.setEcrCreditAN(var13);
            this.ecrituresBalance.setEcrDebitMVTS(var15);
            this.ecrituresBalance.setEcrCreditMVTS(var17);
            this.ecrituresBalance.setEcrDebitSOLDE(var19);
            this.ecrituresBalance.setEcrCreditSOLDE(var21);
            if (var11 != 0.0D || var13 != 0.0D || var15 != 0.0D || var17 != 0.0D) {
               var26.add(this.ecrituresBalance);
            }
         }
      }

      this.mafBalance(this.compteComplet(var26));
   }

   public List compteComplet(List var1) {
      for(int var2 = 0; var2 < var1.size(); ++var2) {
         this.ecrituresBalance = (EcrituresBalance)var1.get(var2);
         String var3 = this.ecrituresBalance.getEcrBalCompte();
         int var4 = 8 - var3.length();
         if (var4 == 1) {
            var3 = var3 + "0";
         } else if (var4 == 2) {
            var3 = var3 + "00";
         } else if (var4 == 3) {
            var3 = var3 + "000";
         } else if (var4 == 4) {
            var3 = var3 + "0000";
         } else if (var4 == 5) {
            var3 = var3 + "00000";
         } else if (var4 == 6) {
            var3 = var3 + "000000";
         } else if (var4 == 7) {
            var3 = var3 + "0000000";
         } else if (var4 == 8) {
            var3 = var3 + "00000000";
         } else if (var4 == 9) {
            var3 = var3 + "000000000";
         } else if (var4 == 10) {
            var3 = var3 + "0000000000";
         }

         this.ecrituresBalance.setEcrBalCompte(var3);
      }

      return var1;
   }

   public void mafBalance(List var1) {
      if (var1.size() != 0) {
         double var2 = 0.0D;
         double var4 = 0.0D;
         double var6 = 0.0D;
         double var8 = 0.0D;
         double var10 = 0.0D;
         double var12 = 0.0D;
         double var14 = 0.0D;
         double var16 = 0.0D;
         String var18 = "";
         String var19 = ((EcrituresBalance)var1.get(0)).getEcrBalCompte().substring(0, 2);

         for(int var20 = 0; var20 < var1.size(); ++var20) {
            this.ecrituresBalance = (EcrituresBalance)var1.get(var20);
            var18 = this.ecrituresBalance.getEcrBalCompte();
            if (!this.ecrituresBalance.getEcrBalCompte().startsWith(var19)) {
               this.ecrituresBalance = new EcrituresBalance();
               this.ecrituresBalance.setEcrBalCompte("");
               this.ecrituresBalance.setEcrBalLibelle("Total classe " + var19);
               this.ecrituresBalance.setEcrDebitAN(var6);
               this.ecrituresBalance.setEcrCreditAN(var8);
               this.ecrituresBalance.setEcrDebitMVTS(var10);
               this.ecrituresBalance.setEcrCreditMVTS(var12);
               this.ecrituresBalance.setEcrDebitSOLDE(var14);
               this.ecrituresBalance.setEcrCreditSOLDE(var16);
               this.listeBalance.add(this.ecrituresBalance);
               var19 = var18.substring(0, 2);
               var6 = 0.0D;
               var8 = 0.0D;
               var10 = 0.0D;
               var12 = 0.0D;
               var14 = 0.0D;
               var16 = 0.0D;
            }

            this.ecrituresBalance = (EcrituresBalance)var1.get(var20);
            var2 = this.ecrituresBalance.getEcrDebitAN() + this.ecrituresBalance.getEcrDebitMVTS();
            var4 = this.ecrituresBalance.getEcrCreditAN() + this.ecrituresBalance.getEcrCreditMVTS();
            if (var2 > var4) {
               this.ecrituresBalance.setEcrDebitSOLDE(var2 - var4);
               this.ecrituresBalance.setEcrCreditSOLDE(0.0D);
            } else {
               this.ecrituresBalance.setEcrDebitSOLDE(0.0D);
               this.ecrituresBalance.setEcrCreditSOLDE(var4 - var2);
            }

            this.listeBalance.add(this.ecrituresBalance);
            var6 += this.ecrituresBalance.getEcrDebitAN();
            var8 += this.ecrituresBalance.getEcrCreditAN();
            var10 += this.ecrituresBalance.getEcrDebitMVTS();
            var12 += this.ecrituresBalance.getEcrCreditMVTS();
            var14 += this.ecrituresBalance.getEcrDebitSOLDE();
            var16 += this.ecrituresBalance.getEcrCreditSOLDE();
         }

         this.ecrituresBalance = new EcrituresBalance();
         this.ecrituresBalance.setEcrBalCompte("");
         this.ecrituresBalance.setEcrBalLibelle("Total classe " + var18);
         this.ecrituresBalance.setEcrDebitAN(var6);
         this.ecrituresBalance.setEcrCreditAN(var8);
         this.ecrituresBalance.setEcrDebitMVTS(var10);
         this.ecrituresBalance.setEcrCreditMVTS(var12);
         this.ecrituresBalance.setEcrDebitSOLDE(var14);
         this.ecrituresBalance.setEcrCreditSOLDE(var16);
         this.listeBalance.add(this.ecrituresBalance);
      }

   }

   public void calculeEcrituresLettrees() throws HibernateException, NamingException {
      new ArrayList();
      ArrayList var2 = new ArrayList();
      List var1 = this.ecrituresDao.ChargerLesEcrituresRecherche(this.var_requete, (Session)null);
      if (var1.size() != 0) {
         this.var_requete = "";
         ArrayList var3 = new ArrayList();

         int var7;
         for(int var4 = 0; var4 < var1.size(); ++var4) {
            String var5 = ((Ecritures)var1.get(var4)).getEcrCompte();
            if (var5 != null && !var5.isEmpty()) {
               if (var3.size() == 0) {
                  var3.add(var5);
               } else {
                  boolean var6 = false;

                  for(var7 = 0; var7 < var3.size(); ++var7) {
                     if (((String)var3.get(var7)).toString().equals(var5)) {
                        var6 = true;
                        break;
                     }
                  }

                  if (!var6) {
                     var3.add(var5);
                  }
               }
            }
         }

         if (var3.size() != 0) {
            ArrayList var15 = new ArrayList();
            ArrayList var16 = new ArrayList();

            for(int var17 = 0; var17 < var3.size(); ++var17) {
               String var19 = ((String)var3.get(var17)).toString();
               var15.clear();
               var16.clear();
               if (var19 != null && !var19.isEmpty()) {
                  int var8;
                  for(var8 = 0; var8 < var1.size(); ++var8) {
                     if (((Ecritures)var1.get(var8)).getEcrCompte().equals(var19)) {
                        var15.add(var1.get(var8));
                     }
                  }

                  if (var15.size() != 0) {
                     String var9;
                     for(var8 = 0; var8 < var15.size(); ++var8) {
                        var9 = ((Ecritures)var15.get(var8)).getEcrLettrage();
                        if (var16.size() == 0) {
                           var16.add(var9);
                        } else {
                           boolean var10 = false;

                           for(int var11 = 0; var11 < var16.size(); ++var11) {
                              if (((String)var16.get(var11)).toString().equals(var9)) {
                                 var10 = true;
                                 break;
                              }
                           }

                           if (!var10) {
                              var16.add(var9);
                           }
                        }
                     }

                     if (var16.size() != 0) {
                        for(var8 = 0; var8 < var16.size(); ++var8) {
                           var9 = (String)var16.get(var8);
                           double var20 = 0.0D;
                           double var12 = 0.0D;

                           int var14;
                           for(var14 = 0; var14 < var15.size(); ++var14) {
                              if (((Ecritures)var15.get(var14)).getEcrLettrage().equals(var9)) {
                                 var20 += ((Ecritures)var15.get(var14)).getEcrDebitSaisie();
                                 var12 += ((Ecritures)var15.get(var14)).getEcrCreditSaisie();
                              }
                           }

                           if (var20 == var12) {
                              for(var14 = 0; var14 < var15.size(); ++var14) {
                                 if (((Ecritures)var15.get(var14)).getEcrLettrage().equals(var9)) {
                                    var2.add(var15.get(var14));
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }

            String var18 = "";
            if (var2.size() != 0) {
               for(var7 = 0; var7 < var2.size(); ++var7) {
                  if (var18 != null && !var18.isEmpty()) {
                     var18 = var18 + "," + ((Ecritures)var2.get(var7)).getEcr_id();
                  } else {
                     var18 = "" + ((Ecritures)var2.get(var7)).getEcr_id();
                  }
               }
            }

            this.var_requete = "ecr_id in (" + var18 + ")";
         }
      }

   }

   public void calculeEcrituresNonLettrees() throws NamingException, ParseException {
      new ArrayList();
      ArrayList var2 = new ArrayList();
      List var1 = this.ecrituresDao.ChargerLesEcrituresRecherche(this.var_requete, (Session)null);
      if (var1.size() != 0) {
         this.var_requete = "";
         ArrayList var3 = new ArrayList();

         int var7;
         for(int var4 = 0; var4 < var1.size(); ++var4) {
            String var5 = ((Ecritures)var1.get(var4)).getEcrCompte();
            if (var5 != null && !var5.isEmpty()) {
               if (var3.size() == 0) {
                  var3.add(var5);
               } else {
                  boolean var6 = false;

                  for(var7 = 0; var7 < var3.size(); ++var7) {
                     if (((String)var3.get(var7)).toString().equals(var5)) {
                        var6 = true;
                        break;
                     }
                  }

                  if (!var6) {
                     var3.add(var5);
                  }
               }
            }
         }

         if (var3.size() != 0) {
            ArrayList var15 = new ArrayList();
            ArrayList var16 = new ArrayList();

            for(int var17 = 0; var17 < var3.size(); ++var17) {
               String var19 = ((String)var3.get(var17)).toString();
               var15.clear();
               var16.clear();
               if (var19 != null && !var19.isEmpty()) {
                  int var8;
                  for(var8 = 0; var8 < var1.size(); ++var8) {
                     if (((Ecritures)var1.get(var8)).getEcrCompte().equals(var19)) {
                        var15.add(var1.get(var8));
                     }
                  }

                  if (var15.size() != 0) {
                     String var9;
                     for(var8 = 0; var8 < var15.size(); ++var8) {
                        if (((Ecritures)var15.get(var8)).getEcrLettrage() != null && !((Ecritures)var15.get(var8)).getEcrLettrage().isEmpty()) {
                           var9 = ((Ecritures)var15.get(var8)).getEcrLettrage();
                           if (var16.size() == 0) {
                              var16.add(var9);
                           } else {
                              boolean var10 = false;

                              for(int var11 = 0; var11 < var16.size(); ++var11) {
                                 if (((String)var16.get(var11)).toString().equals(var9)) {
                                    var10 = true;
                                    break;
                                 }
                              }

                              if (!var10) {
                                 var16.add(var9);
                              }
                           }
                        }
                     }

                     if (var16.size() != 0) {
                        for(var8 = 0; var8 < var16.size(); ++var8) {
                           var9 = (String)var16.get(var8);
                           double var20 = 0.0D;
                           double var12 = 0.0D;

                           int var14;
                           for(var14 = 0; var14 < var15.size(); ++var14) {
                              if (((Ecritures)var15.get(var14)).getEcrLettrage() != null && !((Ecritures)var15.get(var14)).getEcrLettrage().isEmpty() && ((Ecritures)var15.get(var14)).getEcrLettrage().equals(var9)) {
                                 var20 += ((Ecritures)var15.get(var14)).getEcrDebitSaisie();
                                 var12 += ((Ecritures)var15.get(var14)).getEcrCreditSaisie();
                              }
                           }

                           if (var20 != var12) {
                              for(var14 = 0; var14 < var15.size(); ++var14) {
                                 if (((Ecritures)var15.get(var14)).getEcrLettrage() != null && !((Ecritures)var15.get(var14)).getEcrLettrage().isEmpty() && ((Ecritures)var15.get(var14)).getEcrLettrage().equals(var9)) {
                                    var2.add(var15.get(var14));
                                 }
                              }
                           }
                        }
                     }

                     for(var8 = 0; var8 < var15.size(); ++var8) {
                        if (((Ecritures)var15.get(var8)).getEcrLettrage() == null || ((Ecritures)var15.get(var8)).getEcrLettrage().isEmpty()) {
                           var2.add(var15.get(var8));
                        }
                     }
                  }
               }
            }

            String var18 = "";
            if (var2.size() != 0) {
               for(var7 = 0; var7 < var2.size(); ++var7) {
                  if (var18 != null && !var18.isEmpty()) {
                     var18 = var18 + "," + ((Ecritures)var2.get(var7)).getEcr_id();
                  } else {
                     var18 = "" + ((Ecritures)var2.get(var7)).getEcr_id();
                  }
               }
            }

            this.var_requete = "ecr_id in (" + var18 + ")";
         }
      }

   }

   public void calculBalanceConvertie() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
      this.listeBalance = new ArrayList();
      new ArrayList();
      this.planComptableDao = new PlanComptableDao(this.baseLog, this.utilInitHibernate);
      List var2 = this.planComptableDao.chargerLesPlanComptables(this.exoSelectionne.getExecpt_id(), var1);
      new ArrayList();
      List var3 = this.ecrituresDao.ChargerLesEcrituresRecherche(this.var_requete, var1);
      if (var2.size() != 0 && var2.size() != 0) {
         for(int var4 = 0; var4 < var2.size(); ++var4) {
            this.planComptable = (PlanComptable)var2.get(var4);
            if (this.planComptable.getPlcCompte() != null && !this.planComptable.getPlcCompte().isEmpty() && this.nomEtat.equals("BalanceComplete(convertieSYSCOHADA)")) {
               int var5;
               if (this.planComptable.getPlcCompteSyscohada() != null && !this.planComptable.getPlcCompteSyscohada().isEmpty()) {
                  for(var5 = 0; var5 < var3.size(); ++var5) {
                     this.ecritures = (Ecritures)var3.get(var5);
                     if (this.planComptable.getPlcCompte() != null && !this.planComptable.getPlcCompte().isEmpty() && this.planComptable.getPlcCompte().equals(this.ecritures.getEcrCompte())) {
                        this.ecritures.setEcrCompte(((PlanComptable)var2.get(var4)).getPlcCompteSyscohada());
                     }
                  }
               } else if (this.planComptable.getPlcCompteAutre() != null && !this.planComptable.getPlcCompteAutre().isEmpty()) {
                  for(var5 = 0; var5 < var3.size(); ++var5) {
                     this.ecritures = (Ecritures)var3.get(var5);
                     if (this.planComptable.getPlcCompte() != null && !this.planComptable.getPlcCompte().isEmpty() && this.planComptable.getPlcCompte().equals(this.ecritures.getEcrCompte())) {
                        this.ecritures.setEcrCompte(((PlanComptable)var2.get(var4)).getPlcCompteAutre());
                     }
                  }
               }
            }
         }

         this.listeBalance = this.calculeBalanceConvertie(var3);
      }

      this.utilInitHibernate.closeSession();
   }

   public List calculeBalanceConvertie(List var1) {
      ArrayList var2 = new ArrayList();
      new Ecritures();
      this.ecrituresBalance = new EcrituresBalance();
      String var4 = "";
      String var5 = "";
      double var6 = 0.0D;
      double var8 = 0.0D;
      boolean var10 = false;
      ArrayList var11 = new ArrayList();
      if (var1.size() != 0) {
         for(int var12 = 0; var12 < var1.size(); ++var12) {
            Ecritures var3 = (Ecritures)var1.get(var12);
            if (var3.getEcrCompte() != null && !var3.getEcrCompte().isEmpty()) {
               var4 = var3.getEcrCompte();
            } else {
               var4 = "ERREUR";
            }

            var5 = var3.getEcrLibCompte();
            var6 = var3.getEcrDebitPays();
            var8 = var3.getEcrCreditPays();
            var10 = false;
            if (var11.size() == 0) {
               this.ecrituresBalance = new EcrituresBalance();
               this.ecrituresBalance.setEcrBalCompte(var4);
               this.ecrituresBalance.setEcrBalLibelle(var5);
               if (var3.getEcrNatureJrx() == 15) {
                  this.ecrituresBalance.setEcrDebitAN(var6);
                  this.ecrituresBalance.setEcrCreditAN(var8);
               } else {
                  this.ecrituresBalance.setEcrDebitMVTS(var6);
                  this.ecrituresBalance.setEcrCreditMVTS(var8);
               }

               var11.add(this.ecrituresBalance);
            } else {
               var10 = false;

               for(int var13 = 0; var13 < var11.size(); ++var13) {
                  this.ecrituresBalance = new EcrituresBalance();
                  this.ecrituresBalance = (EcrituresBalance)var11.get(var13);
                  if (this.ecrituresBalance.getEcrBalCompte().equals(var4)) {
                     if (var3.getEcrNatureJrx() == 15) {
                        var6 += this.ecrituresBalance.getEcrDebitAN();
                        var8 += this.ecrituresBalance.getEcrCreditAN();
                        this.ecrituresBalance.setEcrDebitAN(var6);
                        this.ecrituresBalance.setEcrCreditAN(var8);
                     } else {
                        var6 += this.ecrituresBalance.getEcrDebitMVTS();
                        var8 += this.ecrituresBalance.getEcrCreditMVTS();
                        this.ecrituresBalance.setEcrDebitMVTS(var6);
                        this.ecrituresBalance.setEcrCreditMVTS(var8);
                     }

                     var10 = true;
                     break;
                  }
               }

               if (!var10) {
                  this.ecrituresBalance = new EcrituresBalance();
                  this.ecrituresBalance.setEcrBalCompte(var4);
                  this.ecrituresBalance.setEcrBalLibelle(var5);
                  if (var3.getEcrNatureJrx() == 15) {
                     this.ecrituresBalance.setEcrDebitAN(var6);
                     this.ecrituresBalance.setEcrCreditAN(var8);
                  } else {
                     this.ecrituresBalance.setEcrDebitMVTS(var6);
                     this.ecrituresBalance.setEcrCreditMVTS(var8);
                  }

                  var11.add(this.ecrituresBalance);
               }
            }
         }

         if (var11.size() != 0) {
            double var17 = 0.0D;
            double var14 = 0.0D;

            for(int var16 = 0; var16 < var11.size(); ++var16) {
               this.ecrituresBalance = (EcrituresBalance)var11.get(var16);
               var17 = this.ecrituresBalance.getEcrDebitAN() + this.ecrituresBalance.getEcrDebitMVTS();
               var14 = this.ecrituresBalance.getEcrCreditAN() + this.ecrituresBalance.getEcrCreditMVTS();
               if (var17 > var14) {
                  this.ecrituresBalance.setEcrDebitSOLDE(var17 - var14);
                  this.ecrituresBalance.setEcrCreditSOLDE(0.0D);
               } else {
                  this.ecrituresBalance.setEcrDebitSOLDE(0.0D);
                  this.ecrituresBalance.setEcrCreditSOLDE(var14 - var17);
               }

               var2.add(this.ecrituresBalance);
            }
         }
      }

      return var2;
   }

   public void calculBalanceAgee(String var1, String var2) throws NamingException, ParseException {
      this.m0DteDeb = this.utilDate.dateToStringSQLLight(this.utilDate.datePremierJourMois(this.filtreDateFin));
      this.m0DteFin = this.utilDate.dateToStringSQLLight(this.utilDate.dateDernierJourMois(this.filtreDateFin));
      Date var3 = this.utilDate.dateMoisPrecedent(this.filtreDateFin);
      this.m30DteDeb = this.utilDate.dateToStringSQLLight(this.utilDate.datePremierJourMois(var3));
      this.m30DteFin = this.utilDate.dateToStringSQLLight(this.utilDate.dateDernierJourMois(var3));
      Date var4 = this.utilDate.dateMoisPrecedent(var3);
      this.m60DteDeb = this.utilDate.dateToStringSQLLight(this.utilDate.datePremierJourMois(var4));
      this.m60DteFin = this.utilDate.dateToStringSQLLight(this.utilDate.dateDernierJourMois(var4));
      Date var5 = this.utilDate.dateMoisPrecedent(var4);
      this.m90DteDeb = this.utilDate.dateToStringSQLLight(this.utilDate.datePremierJourMois(var5));
      this.m90DteFin = this.utilDate.dateToStringSQLLight(this.utilDate.dateDernierJourMois(var5));
      Date var6 = this.utilDate.dateMoisPrecedent(var5);
      this.m120DteDeb = this.utilDate.dateToStringSQLLight(this.utilDate.datePremierJourMois(var6));
      Date var7 = null;
      if (!this.nomEtat.equals("BalanceAgeeParClientSurAN") && !this.nomEtat.equals("BalanceAgeeParFournisseurSurAN")) {
         this.var_entete = "Balance agée jusqu'au " + var1;
         var7 = this.exoSelectionne.getExecptDateDebut();
      } else {
         new ArrayList();
         List var8 = this.ecrituresDao.chargerLesEcrituresByCodeJr(this.exoSelectionne.getExecpt_id(), "AN", (Session)null);
         if (var8.size() != 0) {
            var7 = ((Ecritures)var8.get(0)).getEcrDateSaisie();
            String var9 = this.utilDate.dateToStringFr(var7);
            this.var_entete = "Balance agée du " + var9 + " jusqu'au " + var1;
         } else {
            this.var_entete = "Balance agée jusqu'au " + var1;
            var7 = this.exoSelectionne.getExecptDateDebut();
         }
      }

      this.lesBalanceAgee.clear();
      ArrayList var26 = new ArrayList();
      Object var27 = new ArrayList();
      this.var_filtre = "Calcul sur date d'échéance";
      this.var_requete = "execpt_id=" + this.exoSelectionne.getExecpt_id();
      this.var_requete = this.var_requete + " AND ecr_code<>'....'";
      ArrayList var10;
      int var15;
      boolean var16;
      int var17;
      if (this.filtreDateFin.equals(this.exoSelectionne.getExecptDateFin())) {
         this.var_requete = this.var_requete + " and ecr_etat<>2 and ecr_nature_jrx<>13 and (ecr_lettrage='' or ecr_lettrage is null)";
         this.var_requete = this.var_requete + " and ((ecr_date_saisie>='" + this.utilDate.dateToStringSQLLight(var7) + "' and ecr_date_saisie<='" + var2 + "') or (ecr_date_echeance>='" + this.utilDate.dateToStringSQLLight(var7) + "' and ecr_date_echeance<='" + var2 + "'))";
         this.var_requete = this.var_requete + " and (ecr_compte>='" + this.filtreCompteDebut + "' and ecr_compte<='" + this.filtreCompteFin + "')";
         if (!this.inclureJournauxS) {
            this.var_requete = this.var_requete + " and ecr_nature_jrx<>11";
         }

         if (!this.inclureJournauxR) {
            this.var_requete = this.var_requete + " and ecr_reserve=0";
         }

         var27 = this.ecrituresDao.ChargerLesEcrituresRecherche(this.var_requete, (Session)null);
      } else {
         this.var_requete = this.var_requete + " and ecr_etat<>2 and ecr_nature_jrx<>13";
         this.var_requete = this.var_requete + " and ((ecr_date_saisie>='" + this.utilDate.dateToStringSQLLight(var7) + "' and ecr_date_saisie<='" + var2 + "') or (ecr_date_echeance>='" + this.utilDate.dateToStringSQLLight(var7) + "' and ecr_date_echeance<='" + var2 + "'))";
         this.var_requete = this.var_requete + " and (ecr_compte>='" + this.filtreCompteDebut + "' and ecr_compte<='" + this.filtreCompteFin + "')";
         if (!this.inclureJournauxS) {
            this.var_requete = this.var_requete + " and ecr_nature_jrx<>11";
         }

         if (!this.inclureJournauxR) {
            this.var_requete = this.var_requete + " and ecr_reserve=0";
         }

         var10 = new ArrayList();
         new LinkedList();
         Object[] var12 = null;
         new Ecritures();
         ArrayList var14 = new ArrayList();
         List var11 = this.ecrituresDao.ChargerLesEcrituresLightRecherche(this.var_requete, (Session)null);
         if (var11.size() != 0) {
            for(var15 = 0; var15 < var11.size(); ++var15) {
               var12 = (Object[])((Object[])var11.get(var15));
               if (var12[0] != null && var12[0].toString() != null && !var12[0].toString().isEmpty()) {
                  if (var10.size() == 0) {
                     var10.add(var12[0].toString());
                  } else {
                     var16 = false;

                     for(var17 = 0; var17 < var10.size(); ++var17) {
                        if (((String)var10.get(var17)).equals(var12[0].toString())) {
                           var16 = true;
                           break;
                        }
                     }

                     if (!var16) {
                        var10.add(var12[0].toString());
                     }
                  }
               }
            }

            for(var15 = 0; var15 < var10.size(); ++var15) {
               String var36 = ((String)var10.get(var15)).toString();
               var14.clear();
               var12 = null;

               for(var17 = 0; var17 < var11.size(); ++var17) {
                  var12 = (Object[])((Object[])var11.get(var17));
                  if (var12[0].toString() != null && !var12[0].toString().isEmpty() && var12[0].toString().equals(var36) && var12[4] != null && var12[4].toString() != null && !var12[4].toString().isEmpty()) {
                     if (var14.size() == 0) {
                        var14.add(var12[4].toString());
                     } else {
                        boolean var18 = false;

                        for(int var19 = 0; var19 < var14.size(); ++var19) {
                           if (((String)var14.get(var19)).equals(var12[4].toString())) {
                              var18 = true;
                              break;
                           }
                        }

                        if (!var18) {
                           var14.add(var12[4].toString());
                        }
                     }
                  }
               }

               String var39 = "";
               var12 = null;
               int var40;
               if (var14.size() != 0) {
                  for(var40 = 0; var40 < var14.size(); ++var40) {
                     var39 = ((String)var14.get(var40)).toString();
                     double var42 = 0.0D;
                     double var21 = 0.0D;

                     int var23;
                     for(var23 = 0; var23 < var11.size(); ++var23) {
                        var12 = (Object[])((Object[])var11.get(var23));
                        if (var12[0].toString() != null && !var12[0].toString().isEmpty() && var12[0].toString().equals(var36) && var12[4] != null && var12[4].toString() != null && !var12[4].toString().isEmpty() && var12[4].toString().equals(var39)) {
                           var42 += Double.parseDouble(var12[2].toString());
                           var21 += Double.parseDouble(var12[3].toString());
                        }
                     }

                     if (var42 != var21) {
                        for(var23 = 0; var23 < var11.size(); ++var23) {
                           var12 = (Object[])((Object[])var11.get(var23));
                           if (var12[0].toString() != null && !var12[0].toString().isEmpty() && var12[0].toString().equals(var36) && var12[4] != null && var12[4].toString() != null && !var12[4].toString().isEmpty() && var12[4].toString().equals(var39)) {
                              var12[5] = "L:" + var12[4].toString();
                              var12[4] = null;
                           }
                        }
                     }
                  }
               }

               for(var40 = 0; var40 < var11.size(); ++var40) {
                  var12 = (Object[])((Object[])var11.get(var40));
                  if (var12[0].toString() != null && !var12[0].toString().isEmpty() && var12[0].toString().equals(var36) && (var12[4] == null || var12[4].toString() == null || var12[4].toString().isEmpty())) {
                     Ecritures var13 = new Ecritures();
                     var13.setEcrCompte(var12[0].toString());
                     var13.setEcrDateSaisie(this.utilDate.stringToDateSQLLight(var12[1].toString()));
                     var13.setEcrDebitPays(Double.parseDouble(var12[2].toString()));
                     var13.setEcrCreditPays(Double.parseDouble(var12[3].toString()));
                     var13.setEcrLettrage("");
                     if (var12[5] != null && var12[5].toString() != null && !var12[5].toString().isEmpty()) {
                        var13.setEcrPointage(var12[5].toString());
                     } else {
                        var13.setEcrPointage("");
                     }

                     if (var12[6] != null && var12[6].toString() != null && !var12[6].toString().isEmpty()) {
                        var13.setEcrDateEcheance(this.utilDate.stringToDateSQLLight(var12[6].toString()));
                     } else {
                        var13.setEcrDateEcheance((Date)null);
                     }

                     var13.setEcrNatureJrx(Integer.parseInt(var12[7].toString()));
                     if (var12[8] != null && var12[8].toString() != null && !var12[8].toString().isEmpty()) {
                        var13.setEcrLibCompte(var12[8].toString());
                     } else {
                        var13.setEcrLibCompte((String)null);
                     }

                     ((List)var27).add(var13);
                  }
               }
            }
         }
      }

      if (((List)var27).size() != 0) {
         var10 = null;
         double var29 = 0.0D;

         for(int var30 = 0; var30 < ((List)var27).size(); ++var30) {
            this.ecritures = (Ecritures)((List)var27).get(var30);
            if (var26.size() == 0) {
               var26.add(this.ecritures.getEcrCompte());
            } else {
               boolean var32 = false;

               for(var15 = 0; var15 < var26.size(); ++var15) {
                  if (((String)var26.get(var15)).toString().equals(this.ecritures.getEcrCompte())) {
                     var32 = true;
                     break;
                  }
               }

               if (!var32) {
                  var26.add(this.ecritures.getEcrCompte());
               }
            }

            Date var28;
            long var34;
            if (this.ecritures.getEcrCompte().startsWith("41") && this.ecritures.getEcrCreditPays() == 0.0D && this.ecritures.getEcrDebitPays() != 0.0D) {
               var29 = this.ecritures.getEcrDebitPays();
               var10 = null;
               if (this.ecritures.getEcrDateEcheance() != null) {
                  if (this.ecritures.getEcrNatureJrx() == 15) {
                     var28 = this.ecritures.getEcrDateSaisie();
                  } else {
                     var28 = this.ecritures.getEcrDateEcheance();
                  }
               } else {
                  var28 = this.ecritures.getEcrDateSaisie();
               }

               var34 = (this.filtreDateFin.getTime() - var28.getTime()) / 86400000L;
               if (this.lesBalanceAgee.size() == 0) {
                  this.ecrituresBalance = new EcrituresBalance();
                  this.ecrituresBalance.setEcrNbJour(var34);
                  this.ecrituresBalance.setEcrBalCompte(this.ecritures.getEcrCompte());
                  if (this.ecritures.getEcrCompte() == null || this.ecritures.getEcrCompte().isEmpty() || this.ecritures.getEcrLibCompte() != null && !this.ecritures.getEcrLibCompte().isEmpty()) {
                     this.ecrituresBalance.setEcrBalLibelle(this.ecritures.getEcrLibCompte());
                  } else {
                     this.planComptable = this.planComptableDao.chercherCompte((String)null, this.ecritures.getEcrCompte(), this.exoSelectionne.getExecpt_id(), (Session)null);
                     if (this.planComptable != null) {
                        this.ecrituresBalance.setEcrBalLibelle(this.planComptable.getPlcLibelleCpteFR());
                     } else {
                        this.ecrituresBalance.setEcrBalLibelle(this.ecritures.getEcrLibCompte());
                     }
                  }

                  if ((var28.after(this.utilDate.stringToDateSQLLight(this.m0DteDeb)) || var28.equals(this.utilDate.stringToDateSQLLight(this.m0DteDeb))) && (var28.before(this.utilDate.stringToDateSQLLight(this.m0DteFin)) || var28.equals(this.utilDate.stringToDateSQLLight(this.m0DteFin)))) {
                     this.ecrituresBalance.setEcrCol0(var29);
                  } else if (!var28.after(this.utilDate.stringToDateSQLLight(this.m30DteDeb)) && !var28.equals(this.utilDate.stringToDateSQLLight(this.m30DteDeb)) || !var28.before(this.utilDate.stringToDateSQLLight(this.m30DteFin)) && !var28.equals(this.utilDate.stringToDateSQLLight(this.m30DteFin))) {
                     if (!var28.after(this.utilDate.stringToDateSQLLight(this.m60DteDeb)) && !var28.equals(this.utilDate.stringToDateSQLLight(this.m60DteDeb)) || !var28.before(this.utilDate.stringToDateSQLLight(this.m60DteFin)) && !var28.equals(this.utilDate.stringToDateSQLLight(this.m60DteFin))) {
                        if ((var28.after(this.utilDate.stringToDateSQLLight(this.m90DteDeb)) || var28.equals(this.utilDate.stringToDateSQLLight(this.m90DteDeb))) && (var28.before(this.utilDate.stringToDateSQLLight(this.m90DteFin)) || var28.equals(this.utilDate.stringToDateSQLLight(this.m90DteFin)))) {
                           this.ecrituresBalance.setEcrCol90(var29);
                        } else if (!var28.after(this.utilDate.stringToDateSQLLight(this.m0DteDeb)) && !var28.equals(this.utilDate.stringToDateSQLLight(this.m0DteDeb))) {
                           this.ecrituresBalance.setEcrCol120(var29);
                        } else {
                           this.ecrituresBalance.setEcrColNonEchue(var29);
                        }
                     } else {
                        this.ecrituresBalance.setEcrCol60(var29);
                     }
                  } else {
                     this.ecrituresBalance.setEcrCol30(var29);
                  }

                  this.lesBalanceAgee.add(this.ecrituresBalance);
               } else {
                  var16 = false;

                  for(var17 = 0; var17 < this.lesBalanceAgee.size(); ++var17) {
                     this.ecrituresBalance = (EcrituresBalance)this.lesBalanceAgee.get(var17);
                     this.ecrituresBalance.setEcrNbJour(var34);
                     if (this.ecrituresBalance.getEcrBalCompte().equals(this.ecritures.getEcrCompte())) {
                        if (!var28.after(this.utilDate.stringToDateSQLLight(this.m0DteDeb)) && !var28.equals(this.utilDate.stringToDateSQLLight(this.m0DteDeb)) || !var28.before(this.utilDate.stringToDateSQLLight(this.m0DteFin)) && !var28.equals(this.utilDate.stringToDateSQLLight(this.m0DteFin))) {
                           if ((var28.after(this.utilDate.stringToDateSQLLight(this.m30DteDeb)) || var28.equals(this.utilDate.stringToDateSQLLight(this.m30DteDeb))) && (var28.before(this.utilDate.stringToDateSQLLight(this.m30DteFin)) || var28.equals(this.utilDate.stringToDateSQLLight(this.m30DteFin)))) {
                              this.ecrituresBalance.setEcrCol30(this.ecrituresBalance.getEcrCol30() + var29);
                           } else if (!var28.after(this.utilDate.stringToDateSQLLight(this.m60DteDeb)) && !var28.equals(this.utilDate.stringToDateSQLLight(this.m60DteDeb)) || !var28.before(this.utilDate.stringToDateSQLLight(this.m60DteFin)) && !var28.equals(this.utilDate.stringToDateSQLLight(this.m60DteFin))) {
                              if (!var28.after(this.utilDate.stringToDateSQLLight(this.m90DteDeb)) && !var28.equals(this.utilDate.stringToDateSQLLight(this.m90DteDeb)) || !var28.before(this.utilDate.stringToDateSQLLight(this.m90DteFin)) && !var28.equals(this.utilDate.stringToDateSQLLight(this.m90DteFin))) {
                                 if (!var28.after(this.utilDate.stringToDateSQLLight(this.m0DteDeb)) && !var28.equals(this.utilDate.stringToDateSQLLight(this.m0DteDeb))) {
                                    this.ecrituresBalance.setEcrCol120(this.ecrituresBalance.getEcrCol120() + var29);
                                 } else {
                                    this.ecrituresBalance.setEcrColNonEchue(this.ecrituresBalance.getEcrColNonEchue() + var29);
                                 }
                              } else {
                                 this.ecrituresBalance.setEcrCol90(this.ecrituresBalance.getEcrCol90() + var29);
                              }
                           } else {
                              this.ecrituresBalance.setEcrCol60(this.ecrituresBalance.getEcrCol60() + var29);
                           }
                        } else {
                           this.ecrituresBalance.setEcrCol0(this.ecrituresBalance.getEcrCol0() + var29);
                        }

                        var16 = true;
                        break;
                     }
                  }

                  if (!var16) {
                     this.ecrituresBalance = new EcrituresBalance();
                     this.ecrituresBalance.setEcrNbJour(var34);
                     this.ecrituresBalance.setEcrBalCompte(this.ecritures.getEcrCompte());
                     if (this.ecritures.getEcrCompte() == null || this.ecritures.getEcrCompte().isEmpty() || this.ecritures.getEcrLibCompte() != null && !this.ecritures.getEcrLibCompte().isEmpty()) {
                        this.ecrituresBalance.setEcrBalLibelle(this.ecritures.getEcrLibCompte());
                     } else {
                        this.planComptable = this.planComptableDao.chercherCompte((String)null, this.ecritures.getEcrCompte(), this.exoSelectionne.getExecpt_id(), (Session)null);
                        if (this.planComptable != null) {
                           this.ecrituresBalance.setEcrBalLibelle(this.planComptable.getPlcLibelleCpteFR());
                        } else {
                           this.ecrituresBalance.setEcrBalLibelle(this.ecritures.getEcrLibCompte());
                        }
                     }

                     if (!var28.after(this.utilDate.stringToDateSQLLight(this.m0DteDeb)) && !var28.equals(this.utilDate.stringToDateSQLLight(this.m0DteDeb)) || !var28.before(this.utilDate.stringToDateSQLLight(this.m0DteFin)) && !var28.equals(this.utilDate.stringToDateSQLLight(this.m0DteFin))) {
                        if (!var28.after(this.utilDate.stringToDateSQLLight(this.m30DteDeb)) && !var28.equals(this.utilDate.stringToDateSQLLight(this.m30DteDeb)) || !var28.before(this.utilDate.stringToDateSQLLight(this.m30DteFin)) && !var28.equals(this.utilDate.stringToDateSQLLight(this.m30DteFin))) {
                           if (!var28.after(this.utilDate.stringToDateSQLLight(this.m60DteDeb)) && !var28.equals(this.utilDate.stringToDateSQLLight(this.m60DteDeb)) || !var28.before(this.utilDate.stringToDateSQLLight(this.m60DteFin)) && !var28.equals(this.utilDate.stringToDateSQLLight(this.m60DteFin))) {
                              if (!var28.after(this.utilDate.stringToDateSQLLight(this.m90DteDeb)) && !var28.equals(this.utilDate.stringToDateSQLLight(this.m90DteDeb)) || !var28.before(this.utilDate.stringToDateSQLLight(this.m90DteFin)) && !var28.equals(this.utilDate.stringToDateSQLLight(this.m90DteFin))) {
                                 if (!var28.after(this.utilDate.stringToDateSQLLight(this.m0DteDeb)) && !var28.equals(this.utilDate.stringToDateSQLLight(this.m0DteDeb))) {
                                    this.ecrituresBalance.setEcrCol120(var29);
                                 } else {
                                    this.ecrituresBalance.setEcrColNonEchue(var29);
                                 }
                              } else {
                                 this.ecrituresBalance.setEcrCol90(var29);
                              }
                           } else {
                              this.ecrituresBalance.setEcrCol60(var29);
                           }
                        } else {
                           this.ecrituresBalance.setEcrCol30(var29);
                        }
                     } else {
                        this.ecrituresBalance.setEcrCol0(var29);
                     }

                     this.lesBalanceAgee.add(this.ecrituresBalance);
                  }
               }
            } else if (this.ecritures.getEcrCompte().startsWith("40") && this.ecritures.getEcrCreditPays() != 0.0D && this.ecritures.getEcrDebitPays() == 0.0D) {
               var29 = this.ecritures.getEcrCreditPays();
               var10 = null;
               if (this.ecritures.getEcrDateEcheance() != null) {
                  if (this.ecritures.getEcrNatureJrx() != 15) {
                     var28 = this.ecritures.getEcrDateEcheance();
                  } else {
                     var28 = this.ecritures.getEcrDateSaisie();
                  }
               } else {
                  var28 = this.ecritures.getEcrDateSaisie();
               }

               var34 = (this.filtreDateFin.getTime() - var28.getTime()) / 86400000L;
               if (this.lesBalanceAgee.size() == 0) {
                  this.ecrituresBalance = new EcrituresBalance();
                  this.ecrituresBalance.setEcrNbJour(var34);
                  this.ecrituresBalance.setEcrBalCompte(this.ecritures.getEcrCompte());
                  if (this.ecritures.getEcrCompte() != null && !this.ecritures.getEcrCompte().isEmpty() && (this.ecritures.getEcrLibCompte() == null || this.ecritures.getEcrLibCompte().isEmpty())) {
                     this.planComptable = this.planComptableDao.chercherCompte((String)null, this.ecritures.getEcrCompte(), this.exoSelectionne.getExecpt_id(), (Session)null);
                     if (this.planComptable != null) {
                        this.ecrituresBalance.setEcrBalLibelle(this.planComptable.getPlcLibelleCpteFR());
                     } else {
                        this.ecrituresBalance.setEcrBalLibelle(this.ecritures.getEcrLibCompte());
                     }
                  } else {
                     this.ecrituresBalance.setEcrBalLibelle(this.ecritures.getEcrLibCompte());
                  }

                  if (!var28.after(this.utilDate.stringToDateSQLLight(this.m0DteDeb)) && !var28.equals(this.utilDate.stringToDateSQLLight(this.m0DteDeb)) || !var28.before(this.utilDate.stringToDateSQLLight(this.m0DteFin)) && !var28.equals(this.utilDate.stringToDateSQLLight(this.m0DteFin))) {
                     if ((var28.after(this.utilDate.stringToDateSQLLight(this.m30DteDeb)) || var28.equals(this.utilDate.stringToDateSQLLight(this.m30DteDeb))) && (var28.before(this.utilDate.stringToDateSQLLight(this.m30DteFin)) || var28.equals(this.utilDate.stringToDateSQLLight(this.m30DteFin)))) {
                        this.ecrituresBalance.setEcrCol30(var29);
                     } else if (!var28.after(this.utilDate.stringToDateSQLLight(this.m60DteDeb)) && !var28.equals(this.utilDate.stringToDateSQLLight(this.m60DteDeb)) || !var28.before(this.utilDate.stringToDateSQLLight(this.m60DteFin)) && !var28.equals(this.utilDate.stringToDateSQLLight(this.m60DteFin))) {
                        if ((var28.after(this.utilDate.stringToDateSQLLight(this.m90DteDeb)) || var28.equals(this.utilDate.stringToDateSQLLight(this.m90DteDeb))) && (var28.before(this.utilDate.stringToDateSQLLight(this.m90DteFin)) || var28.equals(this.utilDate.stringToDateSQLLight(this.m90DteFin)))) {
                           this.ecrituresBalance.setEcrCol90(var29);
                        } else if (!var28.after(this.utilDate.stringToDateSQLLight(this.m0DteDeb)) && !var28.equals(this.utilDate.stringToDateSQLLight(this.m0DteDeb))) {
                           this.ecrituresBalance.setEcrCol120(var29);
                        } else {
                           this.ecrituresBalance.setEcrColNonEchue(var29);
                        }
                     } else {
                        this.ecrituresBalance.setEcrCol60(var29);
                     }
                  } else {
                     this.ecrituresBalance.setEcrCol0(var29);
                  }

                  this.lesBalanceAgee.add(this.ecrituresBalance);
               } else {
                  var16 = false;

                  for(var17 = 0; var17 < this.lesBalanceAgee.size(); ++var17) {
                     this.ecrituresBalance = (EcrituresBalance)this.lesBalanceAgee.get(var17);
                     this.ecrituresBalance.setEcrNbJour(var34);
                     if (this.ecrituresBalance.getEcrBalCompte().equals(this.ecritures.getEcrCompte())) {
                        if (!var28.after(this.utilDate.stringToDateSQLLight(this.m0DteDeb)) && !var28.equals(this.utilDate.stringToDateSQLLight(this.m0DteDeb)) || !var28.before(this.utilDate.stringToDateSQLLight(this.m0DteFin)) && !var28.equals(this.utilDate.stringToDateSQLLight(this.m0DteFin))) {
                           if (!var28.after(this.utilDate.stringToDateSQLLight(this.m30DteDeb)) && !var28.equals(this.utilDate.stringToDateSQLLight(this.m30DteDeb)) || !var28.before(this.utilDate.stringToDateSQLLight(this.m30DteFin)) && !var28.equals(this.utilDate.stringToDateSQLLight(this.m30DteFin))) {
                              if ((var28.after(this.utilDate.stringToDateSQLLight(this.m60DteDeb)) || var28.equals(this.utilDate.stringToDateSQLLight(this.m60DteDeb))) && (var28.before(this.utilDate.stringToDateSQLLight(this.m60DteFin)) || var28.equals(this.utilDate.stringToDateSQLLight(this.m60DteFin)))) {
                                 this.ecrituresBalance.setEcrCol60(this.ecrituresBalance.getEcrCol60() + var29);
                              } else if (!var28.after(this.utilDate.stringToDateSQLLight(this.m90DteDeb)) && !var28.equals(this.utilDate.stringToDateSQLLight(this.m90DteDeb)) || !var28.before(this.utilDate.stringToDateSQLLight(this.m90DteFin)) && !var28.equals(this.utilDate.stringToDateSQLLight(this.m90DteFin))) {
                                 if (!var28.after(this.utilDate.stringToDateSQLLight(this.m0DteDeb)) && !var28.equals(this.utilDate.stringToDateSQLLight(this.m0DteDeb))) {
                                    this.ecrituresBalance.setEcrCol120(this.ecrituresBalance.getEcrCol120() + var29);
                                 } else {
                                    this.ecrituresBalance.setEcrColNonEchue(this.ecrituresBalance.getEcrColNonEchue() + var29);
                                 }
                              } else {
                                 this.ecrituresBalance.setEcrCol90(this.ecrituresBalance.getEcrCol90() + var29);
                              }
                           } else {
                              this.ecrituresBalance.setEcrCol30(this.ecrituresBalance.getEcrCol30() + var29);
                           }
                        } else {
                           this.ecrituresBalance.setEcrCol0(this.ecrituresBalance.getEcrCol0() + var29);
                        }

                        var16 = true;
                        break;
                     }
                  }

                  if (!var16) {
                     this.ecrituresBalance = new EcrituresBalance();
                     this.ecrituresBalance.setEcrNbJour(var34);
                     this.ecrituresBalance.setEcrBalCompte(this.ecritures.getEcrCompte());
                     if (this.ecritures.getEcrCompte() != null && !this.ecritures.getEcrCompte().isEmpty() && (this.ecritures.getEcrLibCompte() == null || this.ecritures.getEcrLibCompte().isEmpty())) {
                        this.planComptable = this.planComptableDao.chercherCompte((String)null, this.ecritures.getEcrCompte(), this.exoSelectionne.getExecpt_id(), (Session)null);
                        if (this.planComptable != null) {
                           this.ecrituresBalance.setEcrBalLibelle(this.planComptable.getPlcLibelleCpteFR());
                        } else {
                           this.ecrituresBalance.setEcrBalLibelle(this.ecritures.getEcrLibCompte());
                        }
                     } else {
                        this.ecrituresBalance.setEcrBalLibelle(this.ecritures.getEcrLibCompte());
                     }

                     if (!var28.after(this.utilDate.stringToDateSQLLight(this.m0DteDeb)) && !var28.equals(this.utilDate.stringToDateSQLLight(this.m0DteDeb)) || !var28.before(this.utilDate.stringToDateSQLLight(this.m0DteFin)) && !var28.equals(this.utilDate.stringToDateSQLLight(this.m0DteFin))) {
                        if ((var28.after(this.utilDate.stringToDateSQLLight(this.m30DteDeb)) || var28.equals(this.utilDate.stringToDateSQLLight(this.m30DteDeb))) && (var28.before(this.utilDate.stringToDateSQLLight(this.m30DteFin)) || var28.equals(this.utilDate.stringToDateSQLLight(this.m30DteFin)))) {
                           this.ecrituresBalance.setEcrCol30(var29);
                        } else if ((var28.after(this.utilDate.stringToDateSQLLight(this.m60DteDeb)) || var28.equals(this.utilDate.stringToDateSQLLight(this.m60DteDeb))) && (var28.before(this.utilDate.stringToDateSQLLight(this.m60DteFin)) || var28.equals(this.utilDate.stringToDateSQLLight(this.m60DteFin)))) {
                           this.ecrituresBalance.setEcrCol60(var29);
                        } else if ((var28.after(this.utilDate.stringToDateSQLLight(this.m90DteDeb)) || var28.equals(this.utilDate.stringToDateSQLLight(this.m90DteDeb))) && (var28.before(this.utilDate.stringToDateSQLLight(this.m90DteFin)) || var28.equals(this.utilDate.stringToDateSQLLight(this.m90DteFin)))) {
                           this.ecrituresBalance.setEcrCol90(var29);
                        } else if (!var28.after(this.utilDate.stringToDateSQLLight(this.m0DteDeb)) && !var28.equals(this.utilDate.stringToDateSQLLight(this.m0DteDeb))) {
                           this.ecrituresBalance.setEcrCol120(var29);
                        } else {
                           this.ecrituresBalance.setEcrColNonEchue(var29);
                        }
                     } else {
                        this.ecrituresBalance.setEcrCol0(var29);
                     }

                     this.lesBalanceAgee.add(this.ecrituresBalance);
                  }
               }
            }
         }

         int var41;
         if (var26.size() != 0) {
            String var31 = "";

            for(int var35 = 0; var35 < var26.size(); ++var35) {
               var31 = (String)var26.get(var35);
               boolean var37 = false;

               for(var41 = 0; var41 < this.lesBalanceAgee.size(); ++var41) {
                  if (((EcrituresBalance)this.lesBalanceAgee.get(var41)).getEcrBalCompte().equals(var31)) {
                     var37 = true;
                     break;
                  }
               }

               if (!var37) {
                  this.ecrituresBalance = new EcrituresBalance();
                  this.ecrituresBalance.setEcrNbJour(0L);
                  this.ecrituresBalance.setEcrBalCompte(var31);
                  this.planComptable = new PlanComptable();
                  this.planComptable = this.planComptableDao.chercherCompte((String)null, var31, this.exoSelectionne.getExecpt_id(), (Session)null);
                  if (this.planComptable != null) {
                     this.ecrituresBalance.setEcrBalLibelle(this.planComptable.getPlcLibelleCpteFR());
                  } else {
                     this.ecrituresBalance.setEcrBalLibelle("???");
                  }

                  this.lesBalanceAgee.add(this.ecrituresBalance);
               }
            }
         }

         double var33 = 0.0D;
         if (var26.size() != 0 && this.lesBalanceAgee.size() != 0) {
            String var38 = "";

            for(var41 = 0; var41 < var26.size(); ++var41) {
               var38 = ((String)var26.get(var41)).toString();
               var33 = 0.0D;
               this.ecritures = new Ecritures();

               for(var17 = 0; var17 < ((List)var27).size(); ++var17) {
                  this.ecritures = (Ecritures)((List)var27).get(var17);
                  if (this.ecritures.getEcrCompte().equals(var38)) {
                     if (this.ecritures.getEcrCompte().startsWith("41") && this.ecritures.getEcrCreditPays() != 0.0D && this.ecritures.getEcrDebitPays() == 0.0D) {
                        var33 += this.ecritures.getEcrCreditPays();
                     } else if (this.ecritures.getEcrCompte().startsWith("40") && this.ecritures.getEcrCreditPays() == 0.0D && this.ecritures.getEcrDebitPays() != 0.0D) {
                        var33 += this.ecritures.getEcrDebitPays();
                     }
                  }
               }

               if (var33 != 0.0D) {
                  for(var17 = 0; var17 < this.lesBalanceAgee.size(); ++var17) {
                     this.ecrituresBalance = (EcrituresBalance)this.lesBalanceAgee.get(var17);
                     if (this.ecrituresBalance.getEcrBalCompte().equals(var38)) {
                        if (this.ecrituresBalance.getEcrCol120() < var33) {
                           double var43 = var33 - this.ecrituresBalance.getEcrCol120();
                           this.ecrituresBalance.setEcrCol120(0.0D);
                           if (this.ecrituresBalance.getEcrCol90() < var43) {
                              double var20 = var43 - this.ecrituresBalance.getEcrCol90();
                              this.ecrituresBalance.setEcrCol90(0.0D);
                              if (this.ecrituresBalance.getEcrCol60() < var20) {
                                 double var22 = var20 - this.ecrituresBalance.getEcrCol60();
                                 this.ecrituresBalance.setEcrCol60(0.0D);
                                 if (this.ecrituresBalance.getEcrCol30() < var22) {
                                    double var24 = var22 - this.ecrituresBalance.getEcrCol30();
                                    this.ecrituresBalance.setEcrCol30(0.0D);
                                    this.ecrituresBalance.setEcrCol0(this.ecrituresBalance.getEcrCol0() - var24);
                                 } else {
                                    this.ecrituresBalance.setEcrCol30(this.ecrituresBalance.getEcrCol30() - var22);
                                 }
                              } else {
                                 this.ecrituresBalance.setEcrCol60(this.ecrituresBalance.getEcrCol60() - var20);
                              }
                           } else {
                              this.ecrituresBalance.setEcrCol90(this.ecrituresBalance.getEcrCol90() - var43);
                           }
                        } else {
                           this.ecrituresBalance.setEcrCol120(this.ecrituresBalance.getEcrCol120() - var33);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   public List calculTva() throws HibernateException, NamingException {
      new DocumentEntete();
      ArrayList var2 = new ArrayList();
      new Tiers();
      new Ecritures();
      TiersDao var5 = new TiersDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      List var6 = this.ecrituresDao.ChargerLesEcrituresRecherche(this.var_requete, (Session)null);
      if (var6.size() != 0) {
         Session var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "Tiers");

         DocumentEntete var1;
         Ecritures var4;
         int var8;
         double var9;
         double var11;
         int var13;
         for(var8 = 0; var8 < var6.size(); ++var8) {
            this.ecritures = (Ecritures)var6.get(var8);
            if (this.ecritures.getEcrCompte() != null && !this.ecritures.getEcrCompte().isEmpty() && this.ecritures.getEcrPiece() != null && !this.ecritures.getEcrPiece().isEmpty() && (this.ecritures.getEcrCompte().startsWith("40") || this.ecritures.getEcrCompte().startsWith("481"))) {
               var1 = new DocumentEntete();
               Tiers var3 = var5.chargerTiersByCompte(this.ecritures.getEcrCompte(), var7);
               if (var3 != null && var3.getTienum1() != null && !var3.getTienum1().isEmpty()) {
                  var1.setDocCat("ACHAT");
                  var1.setDocNomTiers(var3.getTieraisonsocialenom());
                  var1.setDocObject(var3.getTienum1());
                  var1.setNumComptetier(this.ecritures.getEcrCompte());
                  var1.setDocTotTtc(this.ecritures.getEcrCreditPays() - this.ecritures.getEcrDebitPays());
                  var1.setDocDate(this.ecritures.getEcrDateSaisie());
                  var1.setDocNum(this.ecritures.getEcrPiece());
                  var1.setDocNumDocument(this.ecritures.getEcrReference1());
                  var1.setDocNumBon(this.ecritures.getEcrReference2());
                  var9 = 0.0D;
                  var11 = 0.0D;

                  for(var13 = 0; var13 < var6.size(); ++var13) {
                     var4 = (Ecritures)var6.get(var13);
                     if (var4.getEcrCompte() != null && !var4.getEcrCompte().isEmpty() && var4.getEcrPiece() != null && !var4.getEcrPiece().isEmpty() && var4.getEcrNatureJrx() == 1 && var4.getEcrPiece().equals(this.ecritures.getEcrPiece())) {
                        if (var4.getEcrCompte().startsWith("445")) {
                           var11 += var4.getEcrDebitPays() - var4.getEcrCreditPays();
                        } else if (var4.getEcrCompte().startsWith("2") || var4.getEcrCompte().startsWith("6") || var4.getEcrCompte().startsWith("8")) {
                           var9 += var4.getEcrDebitPays() - var4.getEcrCreditPays();
                        }
                     }
                  }

                  var1.setDocTotTva(var11);
                  var1.setDocTotHt(var9);
                  var2.add(var1);
               }
            }
         }

         for(var8 = 0; var8 < var6.size(); ++var8) {
            this.ecritures = (Ecritures)var6.get(var8);
            if (this.ecritures.getEcrCompte() != null && !this.ecritures.getEcrCompte().isEmpty() && this.ecritures.getEcrPiece() != null && !this.ecritures.getEcrPiece().isEmpty() && this.ecritures.getEcrCompte().startsWith("41")) {
               var1 = new DocumentEntete();
               var1.setDocCat("VENTE");
               var1.setDocNomTiers(this.ecritures.getEcrLibCompte());
               var1.setDocObject("");
               var1.setNumComptetier(this.ecritures.getEcrCompte());
               var1.setDocTotTtc(this.ecritures.getEcrDebitPays() - this.ecritures.getEcrCreditPays());
               var1.setDocDate(this.ecritures.getEcrDateSaisie());
               var1.setDocNum(this.ecritures.getEcrPiece());
               var1.setDocNumDocument(this.ecritures.getEcrReference1());
               var1.setDocNumBon(this.ecritures.getEcrReference2());
               var9 = 0.0D;
               var11 = 0.0D;

               for(var13 = 0; var13 < var6.size(); ++var13) {
                  var4 = (Ecritures)var6.get(var13);
                  if (var4.getEcrCompte() != null && !var4.getEcrCompte().isEmpty() && var4.getEcrPiece() != null && !var4.getEcrPiece().isEmpty() && var4.getEcrNatureJrx() == 2 && var4.getEcrPiece().equals(this.ecritures.getEcrPiece())) {
                     if (var4.getEcrCompte().startsWith("443")) {
                        var11 += var4.getEcrCreditPays() - var4.getEcrDebitPays();
                     } else if (var4.getEcrCompte().startsWith("7") || var4.getEcrCompte().startsWith("8")) {
                        var9 += var4.getEcrCreditPays() - var4.getEcrDebitPays();
                     }
                  }
               }

               var1.setDocTotTva(var11);
               var1.setDocTotHt(var9);
               var2.add(var1);
            }
         }
      }

      return var2;
   }

   public List calculBrs() throws HibernateException, NamingException {
      new DocumentEntete();
      ArrayList var2 = new ArrayList();
      new Tiers();
      new Ecritures();
      TiersDao var5 = new TiersDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      List var6 = this.ecrituresDao.ChargerLesEcrituresRecherche(this.var_requete, (Session)null);
      if (var6.size() != 0) {
         Session var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "Tiers");

         DocumentEntete var1;
         Ecritures var4;
         int var8;
         double var9;
         double var11;
         int var13;
         for(var8 = 0; var8 < var6.size(); ++var8) {
            this.ecritures = (Ecritures)var6.get(var8);
            if (this.ecritures.getEcrCompte() != null && !this.ecritures.getEcrCompte().isEmpty() && this.ecritures.getEcrPiece() != null && !this.ecritures.getEcrPiece().isEmpty() && this.ecritures.getEcrCompte().startsWith("40")) {
               var1 = new DocumentEntete();
               Tiers var3 = var5.chargerTiersByCompte(this.ecritures.getEcrCompte(), var7);
               if (var3 != null && var3.getTienum1() != null && !var3.getTienum1().isEmpty()) {
                  var1.setDocCat("ACHAT");
                  var1.setDocNomTiers(var3.getTieraisonsocialenom());
                  var1.setDocObject(var3.getTienum1());
                  var1.setNumComptetier(this.ecritures.getEcrCompte());
                  var1.setDocTotTtc(this.ecritures.getEcrCreditPays() - this.ecritures.getEcrDebitPays());
                  var1.setDocDate(this.ecritures.getEcrDateSaisie());
                  var1.setDocNum(this.ecritures.getEcrPiece());
                  var1.setDocNumDocument(this.ecritures.getEcrReference1());
                  var1.setDocNumBon(this.ecritures.getEcrReference2());
                  var9 = 0.0D;
                  var11 = 0.0D;

                  for(var13 = 0; var13 < var6.size(); ++var13) {
                     var4 = (Ecritures)var6.get(var13);
                     if (var4.getEcrCompte() != null && !var4.getEcrCompte().isEmpty() && var4.getEcrPiece() != null && !var4.getEcrPiece().isEmpty() && var4.getEcrNatureJrx() == 1 && var4.getEcrPiece().equals(this.ecritures.getEcrPiece())) {
                        if (var4.getEcrCompte().startsWith("4471")) {
                           var11 += var4.getEcrDebitPays() - var4.getEcrCreditPays();
                        } else if (var4.getEcrCompte().startsWith("6")) {
                           var9 += var4.getEcrDebitPays() - var4.getEcrCreditPays();
                        }
                     }
                  }

                  if (var11 != 0.0D) {
                     var1.setDocTotTva(var11);
                     var1.setDocTotHt(var9);
                     var2.add(var1);
                  }
               }
            }
         }

         for(var8 = 0; var8 < var6.size(); ++var8) {
            this.ecritures = (Ecritures)var6.get(var8);
            if (this.ecritures.getEcrCompte() != null && !this.ecritures.getEcrCompte().isEmpty() && this.ecritures.getEcrPiece() != null && !this.ecritures.getEcrPiece().isEmpty() && this.ecritures.getEcrCompte().startsWith("41")) {
               var1 = new DocumentEntete();
               var1.setDocCat("VENTE");
               var1.setDocNomTiers(this.ecritures.getEcrLibCompte());
               var1.setDocObject("");
               var1.setNumComptetier(this.ecritures.getEcrCompte());
               var1.setDocTotTtc(this.ecritures.getEcrDebitPays() - this.ecritures.getEcrCreditPays());
               var1.setDocDate(this.ecritures.getEcrDateSaisie());
               var1.setDocNum(this.ecritures.getEcrPiece());
               var1.setDocNumDocument(this.ecritures.getEcrReference1());
               var1.setDocNumBon(this.ecritures.getEcrReference2());
               var9 = 0.0D;
               var11 = 0.0D;

               for(var13 = 0; var13 < var6.size(); ++var13) {
                  var4 = (Ecritures)var6.get(var13);
                  if (var4.getEcrCompte() != null && !var4.getEcrCompte().isEmpty() && var4.getEcrPiece() != null && !var4.getEcrPiece().isEmpty() && var4.getEcrNatureJrx() == 2 && var4.getEcrPiece().equals(this.ecritures.getEcrPiece())) {
                     if (var4.getEcrCompte().startsWith("4471")) {
                        var11 += var4.getEcrCreditPays() - var4.getEcrDebitPays();
                     } else if (var4.getEcrCompte().startsWith("7")) {
                        var9 += var4.getEcrCreditPays() - var4.getEcrDebitPays();
                     }
                  }
               }

               if (var11 != 0.0D) {
                  var1.setDocTotTva(var11);
                  var1.setDocTotHt(var9);
                  var2.add(var1);
               }
            }
         }
      }

      return var2;
   }

   public List calculBudget() throws HibernateException, NamingException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlansBudgetaires");
      int var2 = this.filtreDateDebut.getMonth() + 1;
      int var3 = this.filtreDateFin.getMonth() + 1;
      double var4 = 0.0D;
      double var6 = 0.0D;
      ArrayList var8 = new ArrayList();
      new ArrayList();
      new BudgetLigne();
      new ArrayList();
      BudgetLigneDao var12 = new BudgetLigneDao(this.baseLog, this.utilInitHibernate);
      new Budget();
      BudgetDao var14 = new BudgetDao(this.baseLog, this.utilInitHibernate);
      new PlanBudgetaireCompte();
      new ArrayList();
      PlanBudgetaireCompteDao var17 = new PlanBudgetaireCompteDao(this.baseLog, this.utilInitHibernate);
      new PlansBudgetaires();
      new ArrayList();
      PlansBudgetairesDao var20 = new PlansBudgetairesDao(this.baseLog, this.utilInitHibernate);
      String var21 = "" + (this.filtreDateDebut.getYear() + 1900);
      String var22 = "" + this.budgetSelect;
      List var19 = var20.chargerLesPlansBudgetaires(this.exoSelectionne, 0, var22, var21, var1);
      if (var19.size() != 0) {
         for(int var23 = 0; var23 < var19.size(); ++var23) {
            PlansBudgetaires var18 = (PlansBudgetaires)var19.get(var23);
            double var24 = 0.0D;
            double var26 = 0.0D;
            List var11 = var12.chargerLigneBudget(var18.getPlbCode(), var1);
            int var28;
            if (var11.size() != 0) {
               for(var28 = 0; var28 < var11.size(); ++var28) {
                  BudgetLigne var10 = (BudgetLigne)var11.get(var28);
                  if (this.budgetMode == 0) {
                     var24 = var24 + var10.getBudlig01R1Val() + var10.getBudlig02R1Val() + var10.getBudlig03R1Val() + var10.getBudlig04R1Val() + var10.getBudlig05R1Val() + var10.getBudlig06R1Val() + var10.getBudlig07R1Val() + var10.getBudlig08R1Val() + var10.getBudlig09R1Val() + var10.getBudlig10R1Val() + var10.getBudlig11R1Val() + var10.getBudlig12R1Val();
                     if (1 >= var2 && 1 <= var3) {
                        var26 += var10.getBudlig01R1Val();
                     }

                     if (2 >= var2 && 2 <= var3) {
                        var26 += var10.getBudlig02R1Val();
                     }

                     if (3 >= var2 && 3 <= var3) {
                        var26 += var10.getBudlig03R1Val();
                     }

                     if (4 >= var2 && 4 <= var3) {
                        var26 += var10.getBudlig04R1Val();
                     }

                     if (5 >= var2 && 5 <= var3) {
                        var26 += var10.getBudlig05R1Val();
                     }

                     if (6 >= var2 && 6 <= var3) {
                        var26 += var10.getBudlig06R1Val();
                     }

                     if (7 >= var2 && 7 <= var3) {
                        var26 += var10.getBudlig07R1Val();
                     }

                     if (8 >= var2 && 8 <= var3) {
                        var26 += var10.getBudlig08R1Val();
                     }

                     if (9 >= var2 && 9 <= var3) {
                        var26 += var10.getBudlig09R1Val();
                     }

                     if (10 >= var2 && 10 <= var3) {
                        var26 += var10.getBudlig10R1Val();
                     }

                     if (11 >= var2 && 11 <= var3) {
                        var26 += var10.getBudlig11R1Val();
                     }

                     if (12 >= var2 && 12 <= var3) {
                        var26 += var10.getBudlig12R1Val();
                     }
                  } else if (this.budgetMode == 1) {
                     var24 = var24 + var10.getBudlig01R2Val() + var10.getBudlig02R2Val() + var10.getBudlig03R2Val() + var10.getBudlig04R2Val() + var10.getBudlig05R2Val() + var10.getBudlig06R2Val() + var10.getBudlig07R2Val() + var10.getBudlig08R2Val() + var10.getBudlig09R2Val() + var10.getBudlig10R2Val() + var10.getBudlig11R2Val() + var10.getBudlig12R2Val();
                     if (1 >= var2 && 1 <= var3) {
                        var26 += var10.getBudlig01R2Val();
                     }

                     if (2 >= var2 && 2 <= var3) {
                        var26 += var10.getBudlig02R2Val();
                     }

                     if (3 >= var2 && 3 <= var3) {
                        var26 += var10.getBudlig03R2Val();
                     }

                     if (4 >= var2 && 4 <= var3) {
                        var26 += var10.getBudlig04R2Val();
                     }

                     if (5 >= var2 && 5 <= var3) {
                        var26 += var10.getBudlig05R2Val();
                     }

                     if (6 >= var2 && 6 <= var3) {
                        var26 += var10.getBudlig06R2Val();
                     }

                     if (7 >= var2 && 7 <= var3) {
                        var26 += var10.getBudlig07R2Val();
                     }

                     if (8 >= var2 && 8 <= var3) {
                        var26 += var10.getBudlig08R2Val();
                     }

                     if (9 >= var2 && 9 <= var3) {
                        var26 += var10.getBudlig09R2Val();
                     }

                     if (10 >= var2 && 10 <= var3) {
                        var26 += var10.getBudlig10R2Val();
                     }

                     if (11 >= var2 && 11 <= var3) {
                        var26 += var10.getBudlig11R2Val();
                     }

                     if (12 >= var2 && 12 <= var3) {
                        var26 += var10.getBudlig12R2Val();
                     }
                  } else if (this.budgetMode == 2) {
                     var24 = var24 + var10.getBudlig01R3Val() + var10.getBudlig02R3Val() + var10.getBudlig03R3Val() + var10.getBudlig04R3Val() + var10.getBudlig05R3Val() + var10.getBudlig06R3Val() + var10.getBudlig07R3Val() + var10.getBudlig08R3Val() + var10.getBudlig09R3Val() + var10.getBudlig10R3Val() + var10.getBudlig11R3Val() + var10.getBudlig12R3Val();
                     if (1 >= var2 && 1 <= var3) {
                        var26 += var10.getBudlig01R3Val();
                     }

                     if (2 >= var2 && 2 <= var3) {
                        var26 += var10.getBudlig02R3Val();
                     }

                     if (3 >= var2 && 3 <= var3) {
                        var26 += var10.getBudlig03R3Val();
                     }

                     if (4 >= var2 && 4 <= var3) {
                        var26 += var10.getBudlig04R3Val();
                     }

                     if (5 >= var2 && 5 <= var3) {
                        var26 += var10.getBudlig05R3Val();
                     }

                     if (6 >= var2 && 6 <= var3) {
                        var26 += var10.getBudlig06R3Val();
                     }

                     if (7 >= var2 && 7 <= var3) {
                        var26 += var10.getBudlig07R3Val();
                     }

                     if (8 >= var2 && 8 <= var3) {
                        var26 += var10.getBudlig08R3Val();
                     }

                     if (9 >= var2 && 9 <= var3) {
                        var26 += var10.getBudlig09R3Val();
                     }

                     if (10 >= var2 && 10 <= var3) {
                        var26 += var10.getBudlig10R3Val();
                     }

                     if (11 >= var2 && 11 <= var3) {
                        var26 += var10.getBudlig11R3Val();
                     }

                     if (12 >= var2 && 12 <= var3) {
                        var26 += var10.getBudlig12R3Val();
                     }
                  } else if (this.budgetMode == 3) {
                     var24 = var24 + var10.getBudlig01R4Val() + var10.getBudlig02R4Val() + var10.getBudlig03R4Val() + var10.getBudlig04R4Val() + var10.getBudlig05R4Val() + var10.getBudlig06R4Val() + var10.getBudlig07R4Val() + var10.getBudlig08R4Val() + var10.getBudlig09R4Val() + var10.getBudlig10R4Val() + var10.getBudlig11R4Val() + var10.getBudlig12R4Val();
                     if (1 >= var2 && 1 <= var3) {
                        var26 += var10.getBudlig01R4Val();
                     }

                     if (2 >= var2 && 2 <= var3) {
                        var26 += var10.getBudlig02R4Val();
                     }

                     if (3 >= var2 && 3 <= var3) {
                        var26 += var10.getBudlig03R4Val();
                     }

                     if (4 >= var2 && 4 <= var3) {
                        var26 += var10.getBudlig04R4Val();
                     }

                     if (5 >= var2 && 5 <= var3) {
                        var26 += var10.getBudlig05R4Val();
                     }

                     if (6 >= var2 && 6 <= var3) {
                        var26 += var10.getBudlig06R4Val();
                     }

                     if (7 >= var2 && 7 <= var3) {
                        var26 += var10.getBudlig07R4Val();
                     }

                     if (8 >= var2 && 8 <= var3) {
                        var26 += var10.getBudlig08R4Val();
                     }

                     if (9 >= var2 && 9 <= var3) {
                        var26 += var10.getBudlig09R4Val();
                     }

                     if (10 >= var2 && 10 <= var3) {
                        var26 += var10.getBudlig10R4Val();
                     }

                     if (11 >= var2 && 11 <= var3) {
                        var26 += var10.getBudlig11R4Val();
                     }

                     if (12 >= var2 && 12 <= var3) {
                        var26 += var10.getBudlig12R4Val();
                     }
                  }
               }
            } else {
               Budget var13 = var14.rechercheBudget(var18.getPlbCode(), var1);
               if (var13 != null) {
                  if (this.budgetMode == 0) {
                     var24 = var24 + var13.getBud01R1Val() + var13.getBud02R1Val() + var13.getBud03R1Val() + var13.getBud04R1Val() + var13.getBud05R1Val() + var13.getBud06R1Val() + var13.getBud07R1Val() + var13.getBud08R1Val() + var13.getBud09R1Val() + var13.getBud10R1Val() + var13.getBud11R1Val() + var13.getBud12R1Val();
                     if (1 >= var2 && 1 <= var3) {
                        var26 += var13.getBud01R1Val();
                     }

                     if (2 >= var2 && 2 <= var3) {
                        var26 += var13.getBud02R1Val();
                     }

                     if (3 >= var2 && 3 <= var3) {
                        var26 += var13.getBud03R1Val();
                     }

                     if (4 >= var2 && 4 <= var3) {
                        var26 += var13.getBud04R1Val();
                     }

                     if (5 >= var2 && 5 <= var3) {
                        var26 += var13.getBud05R1Val();
                     }

                     if (6 >= var2 && 6 <= var3) {
                        var26 += var13.getBud06R1Val();
                     }

                     if (7 >= var2 && 7 <= var3) {
                        var26 += var13.getBud07R1Val();
                     }

                     if (8 >= var2 && 8 <= var3) {
                        var26 += var13.getBud08R1Val();
                     }

                     if (9 >= var2 && 9 <= var3) {
                        var26 += var13.getBud09R1Val();
                     }

                     if (10 >= var2 && 10 <= var3) {
                        var26 += var13.getBud10R1Val();
                     }

                     if (11 >= var2 && 11 <= var3) {
                        var26 += var13.getBud11R1Val();
                     }

                     if (12 >= var2 && 12 <= var3) {
                        var26 += var13.getBud12R1Val();
                     }
                  } else if (this.budgetMode == 1) {
                     var24 = var24 + var13.getBud01R2Val() + var13.getBud02R2Val() + var13.getBud03R2Val() + var13.getBud04R2Val() + var13.getBud05R2Val() + var13.getBud06R2Val() + var13.getBud07R2Val() + var13.getBud08R2Val() + var13.getBud09R2Val() + var13.getBud10R2Val() + var13.getBud11R2Val() + var13.getBud12R2Val();
                     if (1 >= var2 && 1 <= var3) {
                        var26 += var13.getBud01R2Val();
                     }

                     if (2 >= var2 && 2 <= var3) {
                        var26 += var13.getBud02R2Val();
                     }

                     if (3 >= var2 && 3 <= var3) {
                        var26 += var13.getBud03R2Val();
                     }

                     if (4 >= var2 && 4 <= var3) {
                        var26 += var13.getBud04R2Val();
                     }

                     if (5 >= var2 && 5 <= var3) {
                        var26 += var13.getBud05R2Val();
                     }

                     if (6 >= var2 && 6 <= var3) {
                        var26 += var13.getBud06R2Val();
                     }

                     if (7 >= var2 && 7 <= var3) {
                        var26 += var13.getBud07R2Val();
                     }

                     if (8 >= var2 && 8 <= var3) {
                        var26 += var13.getBud08R2Val();
                     }

                     if (9 >= var2 && 9 <= var3) {
                        var26 += var13.getBud09R2Val();
                     }

                     if (10 >= var2 && 10 <= var3) {
                        var26 += var13.getBud10R2Val();
                     }

                     if (11 >= var2 && 11 <= var3) {
                        var26 += var13.getBud11R2Val();
                     }

                     if (12 >= var2 && 12 <= var3) {
                        var26 += var13.getBud12R2Val();
                     }
                  } else if (this.budgetMode == 2) {
                     var24 = var24 + var13.getBud01R3Val() + var13.getBud02R3Val() + var13.getBud03R3Val() + var13.getBud04R3Val() + var13.getBud05R3Val() + var13.getBud06R3Val() + var13.getBud07R3Val() + var13.getBud08R3Val() + var13.getBud09R3Val() + var13.getBud10R3Val() + var13.getBud11R3Val() + var13.getBud12R3Val();
                     if (1 >= var2 && 1 <= var3) {
                        var26 += var13.getBud01R3Val();
                     }

                     if (2 >= var2 && 2 <= var3) {
                        var26 += var13.getBud02R3Val();
                     }

                     if (3 >= var2 && 3 <= var3) {
                        var26 += var13.getBud03R3Val();
                     }

                     if (4 >= var2 && 4 <= var3) {
                        var26 += var13.getBud04R3Val();
                     }

                     if (5 >= var2 && 5 <= var3) {
                        var26 += var13.getBud05R3Val();
                     }

                     if (6 >= var2 && 6 <= var3) {
                        var26 += var13.getBud06R3Val();
                     }

                     if (7 >= var2 && 7 <= var3) {
                        var26 += var13.getBud07R3Val();
                     }

                     if (8 >= var2 && 8 <= var3) {
                        var26 += var13.getBud08R3Val();
                     }

                     if (9 >= var2 && 9 <= var3) {
                        var26 += var13.getBud09R3Val();
                     }

                     if (10 >= var2 && 10 <= var3) {
                        var26 += var13.getBud10R3Val();
                     }

                     if (11 >= var2 && 11 <= var3) {
                        var26 += var13.getBud11R3Val();
                     }

                     if (12 >= var2 && 12 <= var3) {
                        var26 += var13.getBud12R3Val();
                     }
                  } else if (this.budgetMode == 3) {
                     var24 = var24 + var13.getBud01R4Val() + var13.getBud02R4Val() + var13.getBud03R4Val() + var13.getBud04R4Val() + var13.getBud05R4Val() + var13.getBud06R4Val() + var13.getBud07R4Val() + var13.getBud08R4Val() + var13.getBud09R4Val() + var13.getBud10R4Val() + var13.getBud11R4Val() + var13.getBud12R4Val();
                     if (1 >= var2 && 1 <= var3) {
                        var26 += var13.getBud01R4Val();
                     }

                     if (2 >= var2 && 2 <= var3) {
                        var26 += var13.getBud02R4Val();
                     }

                     if (3 >= var2 && 3 <= var3) {
                        var26 += var13.getBud03R4Val();
                     }

                     if (4 >= var2 && 4 <= var3) {
                        var26 += var13.getBud04R4Val();
                     }

                     if (5 >= var2 && 5 <= var3) {
                        var26 += var13.getBud05R4Val();
                     }

                     if (6 >= var2 && 6 <= var3) {
                        var26 += var13.getBud06R4Val();
                     }

                     if (7 >= var2 && 7 <= var3) {
                        var26 += var13.getBud07R4Val();
                     }

                     if (8 >= var2 && 8 <= var3) {
                        var26 += var13.getBud08R4Val();
                     }

                     if (9 >= var2 && 9 <= var3) {
                        var26 += var13.getBud09R4Val();
                     }

                     if (10 >= var2 && 10 <= var3) {
                        var26 += var13.getBud10R4Val();
                     }

                     if (11 >= var2 && 11 <= var3) {
                        var26 += var13.getBud11R4Val();
                     }

                     if (12 >= var2 && 12 <= var3) {
                        var26 += var13.getBud12R4Val();
                     }
                  }
               }
            }

            var4 += var24;
            var6 += var26;
            if (this.optionComptabilite.getTri_extrait() == null || this.optionComptabilite.getTri_extrait().isEmpty()) {
               this.optionComptabilite.setTri_extrait("0");
            }

            var28 = Integer.parseInt(this.optionComptabilite.getTri_extrait());
            List var16 = var17.chargerLesPlansBudgetaireCompte(var18.getPlb_id(), 0, 0, var1);
            if (var16.size() == 0) {
               this.ecrituresBalance = new EcrituresBalance();
               this.ecrituresBalance.setPoste(var18.getPlbCode());
               this.ecrituresBalance.setLibPoste(var18.getPlbLibelleFr());
               this.ecrituresBalance.setEcrBalCompte("");
               this.ecrituresBalance.setEcrBalLibelle("");
               this.ecrituresBalance.setEcrCol0(var24);
               this.ecrituresBalance.setEcrCol30(var26);
               this.ecrituresBalance.setEcrCol60(0.0D);
               this.ecrituresBalance.setEcrCol90(0.0D);
               this.ecrituresBalance.setEcartAN(0.0D);
               this.ecrituresBalance.setEcartMVTS(0.0D);
               var8.add(this.ecrituresBalance);
            } else {
               for(int var29 = 0; var29 < var16.size(); ++var29) {
                  PlanBudgetaireCompte var15 = (PlanBudgetaireCompte)var16.get(var29);
                  double var30 = 0.0D;
                  double var32 = 0.0D;
                  double var34 = 0.0D;
                  double var36 = 0.0D;
                  ArrayList var38 = new ArrayList();
                  Date var39 = this.utilDate.dateDernierJourAnnee(this.exoSelectionne.getExecptDateDebut());
                  List var9 = this.ecrituresDao.chargerExtraitCompte(this.exoSelectionne.getExecptDateDebut(), var39, var15.getPlbcptCompte(), this.inclureJournauxS, this.inclureJournauxR, "", "", "", "", "", "", var38, (List)null, "", 0.0D, this.usersLog.getUsrCptInterdit(), this.usersLog.getUsrJrxInterdit(), var28, var1);
                  if (var9.size() != 0) {
                     for(int var40 = 0; var40 < var9.size(); ++var40) {
                        var30 += ((Ecritures)var9.get(var40)).getEcrDebitPays();
                        var32 += ((Ecritures)var9.get(var40)).getEcrCreditPays();
                     }
                  }

                  var34 = 0.0D;
                  if (var30 > var32) {
                     var34 = var30 - var32;
                  } else {
                     var34 = var32 - var30;
                  }

                  var36 = var24 - var34;
                  double var49 = 0.0D;
                  double var42 = 0.0D;
                  double var44 = 0.0D;
                  double var46 = 0.0D;
                  var9 = this.ecrituresDao.chargerExtraitCompte(this.filtreDateDebut, this.filtreDateFin, var15.getPlbcptCompte(), this.inclureJournauxS, this.inclureJournauxR, "", "", "", "", "", "", var38, (List)null, "", 0.0D, this.usersLog.getUsrCptInterdit(), this.usersLog.getUsrJrxInterdit(), var28, var1);
                  if (var9.size() != 0) {
                     for(int var48 = 0; var48 < var9.size(); ++var48) {
                        var44 += ((Ecritures)var9.get(var48)).getEcrDebitPays();
                        var46 += ((Ecritures)var9.get(var48)).getEcrCreditPays();
                     }
                  }

                  var49 = 0.0D;
                  if (var44 > var46) {
                     var49 = var44 - var46;
                  } else {
                     var49 = var46 - var44;
                  }

                  var42 = var26 - var49;
                  this.ecrituresBalance = new EcrituresBalance();
                  this.ecrituresBalance.setPoste(var18.getPlbCode());
                  this.ecrituresBalance.setLibPoste(var18.getPlbLibelleFr());
                  this.ecrituresBalance.setEcrBalCompte(var15.getPlbcptCompte());
                  this.ecrituresBalance.setEcrBalLibelle(var15.getPlbcptLibelleFr());
                  this.ecrituresBalance.setEcrCol0(var24);
                  this.ecrituresBalance.setEcrCol30(var26);
                  this.ecrituresBalance.setEcrCol60(var34);
                  this.ecrituresBalance.setEcrCol90(var49);
                  this.ecrituresBalance.setEcartAN(var36);
                  this.ecrituresBalance.setEcartMVTS(var42);
                  var8.add(this.ecrituresBalance);
               }
            }
         }
      }

      this.utilPrint.setValeur1(var4);
      this.utilPrint.setValeur2(var6);
      this.utilInitHibernate.closeSession();
      return var8;
   }

   public void controleHorsSyscohada(String var1, String var2) throws HibernateException, NamingException {
      this.var_requete = "";
      this.listeCompte = new ArrayList();
      this.lesRacines = new ArrayList();
      RacinesDao var3 = new RacinesDao(this.baseLog, this.structureLog, this.utilInitHibernate);
      this.lesRacines = var3.chargerMesRacines("SYSCOHADA", (Session)null);
      new ArrayList();
      List var4 = this.ecrituresDao.ChargerLesEcrituresExtractCompte(var1, var2, (Session)null);
      this.controleHorsRacine(this.lesRacines, var4);
   }

   public void controleHorsSyscoa(String var1, String var2) throws HibernateException, NamingException {
      this.var_requete = "";
      this.listeCompte = new ArrayList();
      this.lesRacines = new ArrayList();
      RacinesDao var3 = new RacinesDao(this.baseLog, this.structureLog, this.utilInitHibernate);
      this.lesRacines = var3.chargerMesRacines("SYSCOA", (Session)null);
      new ArrayList();
      List var4 = this.ecrituresDao.ChargerLesEcrituresExtractCompte(var1, var2, (Session)null);
      this.controleHorsRacine(this.lesRacines, var4);
   }

   public void controleHorsOhada(String var1, String var2) throws HibernateException, NamingException {
      this.var_requete = "";
      this.listeCompte = new ArrayList();
      this.lesRacines = new ArrayList();
      RacinesDao var3 = new RacinesDao(this.baseLog, this.structureLog, this.utilInitHibernate);
      this.lesRacines = var3.chargerMesRacines("OHADA", (Session)null);
      new ArrayList();
      List var4 = this.ecrituresDao.ChargerLesEcrituresExtractCompte(var1, var2, (Session)null);
      this.controleHorsRacine(this.lesRacines, var4);
   }

   public void controleHorsRacine(List var1, List var2) {
      if (var2.size() != 0 && var1.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            this.ecritures = (Ecritures)var2.get(var3);
            boolean var4 = false;
            int var5 = this.ecritures.getEcrCompte().length();
            String var6 = "";
            int var7 = 0;

            for(int var8 = var5; var8 != 1; --var8) {
               ++var7;
               var6 = this.ecritures.getEcrCompte().substring(0, var5 - var7);

               for(int var9 = 0; var9 < var1.size(); ++var9) {
                  if (((Racines)var1.get(var9)).getRacUtil().equals("1") && ((Racines)var1.get(var9)).getRacCode().equals(var6)) {
                     var4 = true;
                     break;
                  }
               }

               if (var4) {
                  break;
               }
            }

            if (!var4) {
               this.listeCompte.add(this.ecritures);
            }
         }
      }

   }

   public void exportationEcritures() throws IOException, HibernateException, NamingException {
      this.lesExportsCompta = this.ecrituresDao.ChargerLesEcrituresRecherche(this.var_requete, (Session)null);
      this.afficheFichierExport = false;
      File var1 = null;
      String var2 = this.utilDate.dateToStringSQL(new Date());
      String[] var3 = var2.split(" ");
      String[] var4 = var3[1].split(":");
      String var5 = "EXPORT_" + var3[0] + "_" + var4[0] + "-" + var4[1] + "-" + var4[2] + ".TXT";
      String var6 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "export" + File.separator;
      this.verificationRepertoireOrigine(var6);
      this.cheminExportOrigine = var6 + var5;
      var1 = new File(this.cheminExportOrigine);
      if (var1.exists()) {
         var1.delete();
         var1 = new File(this.cheminExportOrigine);
      }

      this.verificationRepertoireDestination(this.optionComptabilite.getDossierExport(), var5);
      if (this.cheminExportOrigine != null && !this.cheminExportOrigine.isEmpty()) {
         if (this.nomEtat.equals("SAGE V16")) {
            this.exportSageV16(var1);
         } else if (this.formatExport.equals("SAGE V17")) {
            this.exportSageVI7(var1);
         }

         if (var5 != null && !var5.isEmpty()) {
            this.nomFichier = var5;
            this.utilDownload = new UtilDownload();
            String var7 = this.urlExplorateur + "epegase" + File.separator + "clients" + File.separator + this.baseLog + File.separator + "export" + File.separator + var5;
            this.fichierUrl = this.utilDownload.convertirFichierUtl(var7, this.urlExplorateur);
            this.fichierMine = this.utilDownload.calculeTypeMine(this.nomFichier);
            this.afficheFichierExport = true;
         }
      }

   }

   public void verificationRepertoireOrigine(String var1) {
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdirs();
      }

   }

   public void verificationRepertoireDestination(String var1, String var2) {
      if (var1 != null && !var1.isEmpty()) {
         if (!var1.endsWith(".TXT") && !var1.endsWith(".txt")) {
            if (var1.endsWith("/")) {
               this.cheminExportDestination = var1 + var2;
            } else {
               this.cheminExportDestination = var1 + File.separator + var2;
            }
         } else {
            this.cheminExportDestination = var1;
         }
      } else {
         var1 = "C:" + File.separator + "EXPORT" + File.separator;
         this.cheminExportDestination = var1 + var2;
      }

   }

   public String chiffreExport(long var1) {
      String var3 = "";
      String var4 = "" + var1;
      if (var4.contains(".")) {
         String var5 = "";
         boolean var6 = false;
         int var7 = var4.indexOf(".");
         var5 = var4.substring(0, var7);
         var3 = var5;
      } else {
         var3 = var4;
      }

      return var3;
   }

   public void exportSageV16(File var1) throws IOException, HibernateException, NamingException {
      new Tiers();
      TiersDao var3 = new TiersDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      List var4 = var3.selectTiers();
      int var5 = Integer.parseInt(this.optionComptabilite.getNbcrExport());
      if (this.lesExportsCompta.size() != 0) {
         UtilNombre var6 = new UtilNombre();
         PrintWriter var7 = new PrintWriter(new OutputStreamWriter(new FileOutputStream(var1), "UTF-8"));
         SimpleDateFormat var8 = new SimpleDateFormat("dd-MM-yyyy");
         var7.print("#FLG 000\r\n");
         var7.print("#VER 5\r\n");
         var7.print("#DEV\r\n");
         String var9 = "";
         String var10 = "";
         String var11 = "";
         String var12 = "";
         String var13 = "";
         String var14 = "";
         String var15 = "";
         String var16 = "";
         String var17 = "";
         String var18 = "";
         String var19 = "";
         String var20 = "";
         String var21 = "0";
         String var22 = "";
         String var23 = "0";
         String var24 = "0";
         String var25 = "0";
         String var26 = "";
         String var27 = "";
         String var28 = "";
         String var29 = "";
         String var30 = "";
         String var31 = "0";
         String var32 = "0";
         String var33 = "0";
         String var34 = "";
         String var35 = "";

         for(int var36 = 0; var36 < this.lesExportsCompta.size(); ++var36) {
            this.ecritures = (Ecritures)this.lesExportsCompta.get(var36);
            var9 = "#MECG";
            var10 = this.ecritures.getEcrCode();
            String var37 = "";
            if (this.ecritures.getEcrCompte() != null && !this.ecritures.getEcrCompte().isEmpty()) {
               var37 = this.ecritures.getEcrCompte();
               if (var37 != null && !var37.isEmpty()) {
                  var37 = var37.substring(0, var5);
               } else {
                  var37 = "4711000000".substring(0, var5);
               }

               if (!var37.startsWith("40") && !var37.startsWith("41")) {
                  var16 = var37;
                  var18 = "";
               } else {
                  var16 = var37;
                  if (var4.size() != 0) {
                     for(int var38 = 0; var38 < var4.size(); ++var38) {
                        if (((Tiers)var4.get(var38)).getTiecompte0() != null && !((Tiers)var4.get(var38)).getTiecompte0().isEmpty() && ((Tiers)var4.get(var38)).getTiecompte0().equals(var37)) {
                           if (((Tiers)var4.get(var38)).getTiecompteSage() != null && !((Tiers)var4.get(var38)).getTiecompteSage().isEmpty()) {
                              var16 = var37;
                              var18 = ((Tiers)var4.get(var38)).getTiecompteSage();
                              break;
                           }

                           var16 = var37;
                           var18 = "";
                           break;
                        }
                     }
                  } else {
                     var16 = var37;
                     var18 = "";
                  }
               }
            } else {
               var16 = "";
               var18 = "";
            }

            String var43;
            if (this.ecritures.getEcrDateSaisie() != null) {
               var8.format(this.ecritures.getEcrDateSaisie());
               var43 = "" + var8.format(this.ecritures.getEcrDateSaisie());
               String[] var39 = var43.split("-");
               var11 = var39[0] + var39[1] + (Integer.parseInt(var39[2]) - 2000);
            } else {
               var11 = "";
            }

            var43 = "";
            String var44 = "";
            long var40;
            if (this.ecritures.getEcrDebitSaisie() != 0.0D && this.ecritures.getEcrCreditSaisie() == 0.0D) {
               var40 = 0L;
               var40 = (long)var6.myRoundDevise(this.ecritures.getEcrDebitSaisie(), this.structureLog.getStrdevise());
               var43 = this.chiffreExport(var40);
               var44 = "";
               var26 = "0";
               var27 = var43;
            } else {
               var43 = "";
               var40 = 0L;
               var40 = (long)var6.myRoundDevise(this.ecritures.getEcrCreditSaisie(), this.structureLog.getStrdevise());
               var44 = this.chiffreExport(var40);
               var26 = "1";
               var27 = var44;
            }

            String var45 = this.ecritures.getEcrLibelle();
            var20 = var45;
            if (var45.length() >= 34) {
               var20 = var45.substring(0, 33);
            }

            if (this.ecritures.getEcrReference1() != null && !this.ecritures.getEcrReference1().isEmpty()) {
               var14 = this.ecritures.getEcrReference1();
            } else {
               var14 = "";
            }

            if (this.ecritures.getEcrDateEcheance() != null) {
               var8.format(this.ecritures.getEcrDateEcheance());
               String var41 = "" + var8.format(this.ecritures.getEcrDateEcheance());
               String[] var42 = var41.split("-");
               var22 = var42[0] + var42[1] + (Integer.parseInt(var42[2]) - 2000);
            } else {
               var22 = "";
            }

            var7.print(var9 + "\r\n");
            var7.print(var10 + "\r\n");
            var7.print(var11 + "\r\n");
            var7.print(var12 + "\r\n");
            var7.print(var13 + "\r\n");
            var7.print(var14 + "\r\n");
            var7.print(var15 + "\r\n");
            var7.print(var16 + "\r\n");
            var7.print(var17 + "\r\n");
            var7.print(var18 + "\r\n");
            var7.print(var19 + "\r\n");
            var7.print(var20 + "\r\n");
            var7.print(var21 + "\r\n");
            var7.print(var22 + "\r\n");
            var7.print(var23 + "\r\n");
            var7.print(var24 + "\r\n");
            var7.print(var25 + "\r\n");
            var7.print(var26 + "\r\n");
            var7.print(var27 + "\r\n");
            var7.print(var28 + "\r\n");
            var7.print(var29 + "\r\n");
            var7.print(var30 + "\r\n");
            var7.print(var31 + "\r\n");
            var7.print(var32 + "\r\n");
            var7.print(var33 + "\r\n");
            var7.print(var34 + "\r\n");
            var7.print(var35 + "\r\n");
         }

         var7.print("#FIN\r\n");
         var7.close();
      }

   }

   public void exportSageVI7(File var1) throws IOException, HibernateException, NamingException {
      new Tiers();
      TiersDao var3 = new TiersDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      List var4 = var3.selectTiers();
      int var5 = Integer.parseInt(this.optionComptabilite.getNbcrExport());
      if (this.lesExportsCompta.size() != 0) {
         UtilNombre var6 = new UtilNombre();
         PrintWriter var7 = new PrintWriter(new OutputStreamWriter(new FileOutputStream(var1), "UTF-8"));
         SimpleDateFormat var8 = new SimpleDateFormat("dd-MM-yyyy");
         var7.print("#FLG 000\r\n");
         var7.print("#VER 18\r\n");
         var7.print("#DEV\r\n");
         String var9 = "";
         String var10 = "";
         String var11 = "";
         String var12 = "";
         String var13 = "";
         String var14 = "";
         String var15 = "";
         String var16 = "";
         String var17 = "";
         String var18 = "";
         String var19 = "";
         String var20 = "";
         String var21 = "0";
         String var22 = "";
         String var23 = "0";
         String var24 = "0";
         String var25 = "0";
         String var26 = "";
         String var27 = "";
         String var28 = "";
         String var29 = "";
         String var30 = "";
         String var31 = "0";
         String var32 = "0";
         String var33 = "0";
         String var34 = "";
         String var35 = "";

         for(int var36 = 0; var36 < this.lesExportsCompta.size(); ++var36) {
            this.ecritures = (Ecritures)this.lesExportsCompta.get(var36);
            var9 = "#MECG";
            var10 = this.ecritures.getEcrCode();
            String var37 = "";
            if (this.ecritures.getEcrCompte() != null && !this.ecritures.getEcrCompte().isEmpty()) {
               var37 = this.ecritures.getEcrCompte();
               if (var37 != null && !var37.isEmpty()) {
                  var37 = var37.substring(0, var5);
               } else {
                  var37 = "4711000000".substring(0, var5);
               }

               if (!var37.startsWith("40") && !var37.startsWith("41")) {
                  var16 = var37;
                  var18 = "";
               } else {
                  var16 = var37;
                  if (var4.size() != 0) {
                     for(int var38 = 0; var38 < var4.size(); ++var38) {
                        if (((Tiers)var4.get(var38)).getTiecompte0() != null && !((Tiers)var4.get(var38)).getTiecompte0().isEmpty() && ((Tiers)var4.get(var38)).getTiecompte0().equals(var37)) {
                           if (((Tiers)var4.get(var38)).getTiecompteSage() != null && !((Tiers)var4.get(var38)).getTiecompteSage().isEmpty()) {
                              var16 = var37;
                              var18 = ((Tiers)var4.get(var38)).getTiecompteSage();
                              break;
                           }

                           var16 = var37;
                           var18 = "";
                           break;
                        }
                     }
                  } else {
                     var16 = var37;
                     var18 = "";
                  }
               }
            } else {
               var16 = "";
               var18 = "";
            }

            String var43;
            if (this.ecritures.getEcrDateSaisie() != null) {
               var8.format(this.ecritures.getEcrDateSaisie());
               var43 = "" + var8.format(this.ecritures.getEcrDateSaisie());
               String[] var39 = var43.split("-");
               var11 = var39[0] + var39[1] + (Integer.parseInt(var39[2]) - 2000);
            } else {
               var11 = "";
            }

            var43 = "";
            String var44 = "";
            long var40;
            if (this.ecritures.getEcrDebitSaisie() != 0.0D && this.ecritures.getEcrCreditSaisie() == 0.0D) {
               var40 = 0L;
               var40 = (long)var6.myRoundDevise(this.ecritures.getEcrDebitSaisie(), this.structureLog.getStrdevise());
               var43 = this.chiffreExport(var40);
               var44 = "";
               var26 = "0";
               var27 = var43;
            } else {
               var43 = "";
               var40 = 0L;
               var40 = (long)var6.myRoundDevise(this.ecritures.getEcrCreditSaisie(), this.structureLog.getStrdevise());
               var44 = this.chiffreExport(var40);
               var26 = "1";
               var27 = var44;
            }

            String var45 = this.ecritures.getEcrLibelle();
            var20 = var45;
            if (var45.length() >= 34) {
               var20 = var45.substring(0, 33);
            }

            if (this.ecritures.getEcrReference1() != null && !this.ecritures.getEcrReference1().isEmpty()) {
               var14 = this.ecritures.getEcrReference1();
            } else {
               var14 = "";
            }

            if (this.ecritures.getEcrDateEcheance() != null) {
               var8.format(this.ecritures.getEcrDateEcheance());
               String var41 = "" + var8.format(this.ecritures.getEcrDateEcheance());
               String[] var42 = var41.split("-");
               var22 = var42[0] + var42[1] + (Integer.parseInt(var42[2]) - 2000);
            } else {
               var22 = "";
            }

            var7.print(var9 + "\r\n");
            var7.print(var10 + "\r\n");
            var7.print(var11 + "\r\n");
            var7.print(var12 + "\r\n");
            var7.print(var13 + "\r\n");
            var7.print(var14 + "\r\n");
            var7.print(var15 + "\r\n");
            var7.print(var16 + "\r\n");
            var7.print(var17 + "\r\n");
            var7.print(var18 + "\r\n");
            var7.print(var19 + "\r\n");
            var7.print(var20 + "\r\n");
            var7.print(var21 + "\r\n");
            var7.print(var22 + "\r\n");
            var7.print(var23 + "\r\n");
            var7.print(var24 + "\r\n");
            var7.print(var25 + "\r\n");
            var7.print(var26 + "\r\n");
            var7.print(var27 + "\r\n");
            var7.print(var28 + "\r\n");
            var7.print(var29 + "\r\n");
            var7.print(var30 + "\r\n");
            var7.print(var31 + "\r\n");
            var7.print(var32 + "\r\n");
            var7.print(var33 + "\r\n");
            var7.print(var34 + "\r\n");
            var7.print(var35 + "\r\n");
         }

         var7.print("#FIN\r\n");
         var7.close();
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

   public boolean isShowModalPanelBalancePiece() {
      return this.showModalPanelBalancePiece;
   }

   public void setShowModalPanelBalancePiece(boolean var1) {
      this.showModalPanelBalancePiece = var1;
   }

   public boolean isShowModalPanelBalanceCompte() {
      return this.showModalPanelBalanceCompte;
   }

   public void setShowModalPanelBalanceCompte(boolean var1) {
      this.showModalPanelBalanceCompte = var1;
   }

   public DataModel getDataModelBalance() {
      return this.dataModelBalance;
   }

   public void setDataModelBalance(DataModel var1) {
      this.dataModelBalance = var1;
   }

   public String getVar_entete() {
      return this.var_entete;
   }

   public void setVar_entete(String var1) {
      this.var_entete = var1;
   }

   public String getVar_filtre() {
      return this.var_filtre;
   }

   public void setVar_filtre(String var1) {
      this.var_filtre = var1;
   }

   public String getVar_compte() {
      return this.var_compte;
   }

   public void setVar_compte(String var1) {
      this.var_compte = var1;
   }

   public DataModel getDataModelCompte() {
      return this.dataModelCompte;
   }

   public void setDataModelCompte(DataModel var1) {
      this.dataModelCompte = var1;
   }

   public PlanComptable getPlanComptable() {
      return this.planComptable;
   }

   public void setPlanComptable(PlanComptable var1) {
      this.planComptable = var1;
   }

   public String getVar_piece() {
      return this.var_piece;
   }

   public void setVar_piece(String var1) {
      this.var_piece = var1;
   }

   public double getVar_solde() {
      return this.var_solde;
   }

   public void setVar_solde(double var1) {
      this.var_solde = var1;
   }

   public double getVar_tot_credit() {
      return this.var_tot_credit;
   }

   public void setVar_tot_credit(double var1) {
      this.var_tot_credit = var1;
   }

   public double getVar_tot_debit() {
      return this.var_tot_debit;
   }

   public void setVar_tot_debit(double var1) {
      this.var_tot_debit = var1;
   }

   public DataModel getDataModelDetailPiece() {
      return this.dataModelDetailPiece;
   }

   public void setDataModelDetailPiece(DataModel var1) {
      this.dataModelDetailPiece = var1;
   }

   public double getVar_compte_credit() {
      return this.var_compte_credit;
   }

   public void setVar_compte_credit(double var1) {
      this.var_compte_credit = var1;
   }

   public double getVar_compte_debit() {
      return this.var_compte_debit;
   }

   public void setVar_compte_debit(double var1) {
      this.var_compte_debit = var1;
   }

   public double getVar_compte_solde() {
      return this.var_compte_solde;
   }

   public void setVar_compte_solde(double var1) {
      this.var_compte_solde = var1;
   }

   public List getMesPeriodesItems() {
      return this.mesPeriodesItems;
   }

   public void setMesPeriodesItems(List var1) {
      this.mesPeriodesItems = var1;
   }

   public String getPeriode() {
      return this.periode;
   }

   public void setPeriode(String var1) {
      this.periode = var1;
   }

   public int getBudgetMode() {
      return this.budgetMode;
   }

   public void setBudgetMode(int var1) {
      this.budgetMode = var1;
   }

   public int getBudgetSelect() {
      return this.budgetSelect;
   }

   public void setBudgetSelect(int var1) {
      this.budgetSelect = var1;
   }

   public String[] getListJournal() {
      return this.listJournal;
   }

   public void setListJournal(String[] var1) {
      this.listJournal = var1;
   }

   public String getVar_centralisation() {
      return this.var_centralisation;
   }

   public void setVar_centralisation(String var1) {
      this.var_centralisation = var1;
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

   public String getUrlExplorateur() {
      return this.urlExplorateur;
   }

   public void setUrlExplorateur(String var1) {
      this.urlExplorateur = var1;
   }

   public boolean isAfficheFichierExport() {
      return this.afficheFichierExport;
   }

   public void setAfficheFichierExport(boolean var1) {
      this.afficheFichierExport = var1;
   }

   public URL getFichierUrl() {
      return this.fichierUrl;
   }

   public void setFichierUrl(URL var1) {
      this.fichierUrl = var1;
   }

   public String getNomFichier() {
      return this.nomFichier;
   }

   public void setNomFichier(String var1) {
      this.nomFichier = var1;
   }

   public boolean isTestafficheExport() {
      return this.testafficheExport;
   }

   public void setTestafficheExport(boolean var1) {
      this.testafficheExport = var1;
   }

   public String getFichierMine() {
      return this.fichierMine;
   }

   public void setFichierMine(String var1) {
      this.fichierMine = var1;
   }

   public int getTypeClasse() {
      return this.typeClasse;
   }

   public void setTypeClasse(int var1) {
      this.typeClasse = var1;
   }

   public int getModeBalance() {
      return this.modeBalance;
   }

   public void setModeBalance(int var1) {
      this.modeBalance = var1;
   }

   public boolean isModuleTransit() {
      return this.moduleTransit;
   }

   public void setModuleTransit(boolean var1) {
      this.moduleTransit = var1;
   }

   public String getCode() {
      return this.code;
   }

   public void setCode(String var1) {
      this.code = var1;
   }

   public String getLibelle() {
      return this.libelle;
   }

   public void setLibelle(String var1) {
      this.libelle = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public boolean isShowModalPanelImpressionInteractif() {
      return this.showModalPanelImpressionInteractif;
   }

   public void setShowModalPanelImpressionInteractif(boolean var1) {
      this.showModalPanelImpressionInteractif = var1;
   }

   public String getNomRepertoireInteractif() {
      return this.nomRepertoireInteractif;
   }

   public void setNomRepertoireInteractif(String var1) {
      this.nomRepertoireInteractif = var1;
   }

   public List getDocumentImpressionItems() {
      return this.documentImpressionItems;
   }

   public void setDocumentImpressionItems(List var1) {
      this.documentImpressionItems = var1;
   }

   public String getVar_revue() {
      return this.var_revue;
   }

   public void setVar_revue(String var1) {
      this.var_revue = var1;
   }

   public List getExercicesItems() {
      return this.exercicesItems;
   }

   public void setExercicesItems(List var1) {
      this.exercicesItems = var1;
   }

   public String getExerciceSelectionne() {
      return this.exerciceSelectionne;
   }

   public void setExerciceSelectionne(String var1) {
      this.exerciceSelectionne = var1;
   }

   public boolean isShowModalPanelRevue() {
      return this.showModalPanelRevue;
   }

   public void setShowModalPanelRevue(boolean var1) {
      this.showModalPanelRevue = var1;
   }

   public boolean isConditionPj() {
      return this.conditionPj;
   }

   public void setConditionPj(boolean var1) {
      this.conditionPj = var1;
   }

   public boolean isShowModalPanelLpr() {
      return this.showModalPanelLpr;
   }

   public void setShowModalPanelLpr(boolean var1) {
      this.showModalPanelLpr = var1;
   }

   public Ecritures getEcritures() {
      return this.ecritures;
   }

   public void setEcritures(Ecritures var1) {
      this.ecritures = var1;
   }

   public String getNomCreation() {
      return this.nomCreation;
   }

   public void setNomCreation(String var1) {
      this.nomCreation = var1;
   }

   public String getNomModification() {
      return this.nomModification;
   }

   public void setNomModification(String var1) {
      this.nomModification = var1;
   }

   public boolean isShowModalPanelInformation() {
      return this.showModalPanelInformation;
   }

   public void setShowModalPanelInformation(boolean var1) {
      this.showModalPanelInformation = var1;
   }

   public boolean isShowModalPanelPJ() {
      return this.showModalPanelPJ;
   }

   public void setShowModalPanelPJ(boolean var1) {
      this.showModalPanelPJ = var1;
   }

   public int getModePj() {
      return this.modePj;
   }

   public void setModePj(int var1) {
      this.modePj = var1;
   }

   public String getValueScanPj() {
      return this.valueScanPj;
   }

   public void setValueScanPj(String var1) {
      this.valueScanPj = var1;
   }

   public int getTypeFichier() {
      return this.typeFichier;
   }

   public void setTypeFichier(int var1) {
      this.typeFichier = var1;
   }

   public String getUrlphotoProd() {
      return this.urlphotoProd;
   }

   public void setUrlphotoProd(String var1) {
      this.urlphotoProd = var1;
   }
}
