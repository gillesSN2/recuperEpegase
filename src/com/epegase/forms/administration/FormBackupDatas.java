package com.epegase.forms.administration;

import com.epegase.systeme.classe.Bal;
import com.epegase.systeme.classe.PegScripts;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.StructurePeg;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.FileCtrl;
import com.epegase.systeme.control.InfosSysteme;
import com.epegase.systeme.control.ObjetTable;
import com.epegase.systeme.control.ProcessLauncher;
import com.epegase.systeme.dao.PegScriptsDao;
import com.epegase.systeme.dao.StructureDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilDownload;
import com.epegase.systeme.util.UtilFtp;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilMail;
import com.epegase.systeme.xml.LireVersion;
import com.epegase.systeme.xml.ObjetMessageSysteme;
import com.epegase.systeme.xml.Version;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.apache.myfaces.custom.fileupload.UploadedFile;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;
import org.xml.sax.SAXException;

public class FormBackupDatas implements Serializable {
   private String urlExplorateur;
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private UtilDate utilDate;
   private UtilDownload utilDownload;
   private UtilFtp utilFtp;
   private String pageIndex;
   private String fichierMine;
   private URL fichierUrl;
   private String nomFichier;
   private String fichierCode;
   private String adresseBase;
   private String adresseTelechargement;
   private transient DataModel datamodelBackup;
   private List lesBackup;
   private InfosSysteme infosSysteme;
   private boolean selectFile = false;
   private transient DataModel datamodelSousDossier;
   private List lesSousDossiers;
   private boolean selectSousDossier = false;
   private String baseSelected;
   private int memoLigneRepertoire;
   private URL repertoireUrl;
   private String nomRepertoire;
   private String adresseRepertoire;
   private transient DataModel datamodelRepertoire;
   private List lesRepertoires;
   private ObjetMessageSysteme objetMessageRepertoire;
   private boolean selectRepertoire = false;
   private transient DataModel datamodelFichier;
   private List lesFichiers;
   private ObjetMessageSysteme objetMessageFichier;
   private List lesFichiersTemporaires;
   private String memoRepertoire;
   private boolean showModalPanelAjoutFile = false;
   private UploadedFile uploadedFile;
   private String repertoireString;
   private String ongletActif = "tabBackup";
   private transient DataModel datamodelTable;
   private List lesTables;
   private InfosSysteme infosTables;
   private FormInfoSysteme formInfoSysteme;
   private transient DataModel datamodelColonnes;
   private List lesColonnes;
   private InfosSysteme infosColonnes;
   private ObjetTable objetTable;
   private List mesStructuresItems;
   private transient DataModel dataModelScripts;
   private List lesScripts;
   private PegScripts scripts;
   private PegScriptsDao scriptsDao;
   private boolean showModalPanelScripts = false;
   private boolean afficheBoutons = false;
   private List lesHeuresItems;
   private List lesMinutesItems;
   private int processComplete;
   private String processObservation;
   private boolean allBases = false;
   private String dbUserName = "";
   private String dbPassword = "";
   private int modeBakckup;
   private int type;
   private List listBases;
   private transient DataModel dataModelBases;
   private int etat;
   private int mode;
   private String pays;
   private String titre;
   private List listeImagesStartupDefaut;
   private transient DataModel dataModelImagesStartupDefaut;
   private List listeImagesStartupSpecif;
   private transient DataModel dataModelImagesStartupSpecif;
   private String imgeSelectionnee;
   private String fondDefaut;
   private String fondSpecifique;
   private boolean specifique;
   private FileCtrl fileCtrl;
   private ArrayList listFiles;
   private UploadItem item;
   private int uploadsAvailable;
   private List uploadData;

   public FormBackupDatas(UtilInitHibernate var1, UtilDate var2) {
      if (var2 == null) {
         var2 = new UtilDate();
      }

      this.utilDate = var2;
      this.utilDownload = new UtilDownload();
      this.utilFtp = new UtilFtp();
      this.datamodelBackup = new ListDataModel();
      this.lesBackup = new ArrayList();
      this.datamodelSousDossier = new ListDataModel();
      this.lesSousDossiers = new ArrayList();
      this.datamodelRepertoire = new ListDataModel();
      this.lesRepertoires = new ArrayList();
      this.datamodelFichier = new ListDataModel();
      this.lesFichiers = new ArrayList();
      this.lesFichiersTemporaires = new ArrayList();
      this.datamodelTable = new ListDataModel();
      this.lesTables = new ArrayList();
      this.formInfoSysteme = new FormInfoSysteme();
      this.datamodelColonnes = new ListDataModel();
      this.lesColonnes = new ArrayList();
      this.mesStructuresItems = new ArrayList();
      this.dataModelScripts = new ListDataModel();
      this.lesScripts = new ArrayList();
      this.lesHeuresItems = new ArrayList();
      this.lesMinutesItems = new ArrayList();
      this.listFiles = new ArrayList();
      this.uploadsAvailable = 10000;
      this.uploadData = new ArrayList();
      this.utilInitHibernate = var1;
      this.dbUserName = this.utilInitHibernate.getUser();
      this.dbPassword = this.utilInitHibernate.getPw();
   }

   public String url(String var1) {
      this.urlExplorateur = var1;
      return this.urlExplorateur;
   }

   public void chargerListeSauvegarde() throws MalformedURLException, IOException {
      this.chargerListeSauvegarde(this.urlExplorateur);
   }

   public void chargerListeSauvegarde(String var1) throws MalformedURLException, IOException {
      (new StringBuilder()).append("structure").append(this.structureLog.getStrid()).toString();
      this.urlExplorateur = var1;
      this.adresseBase = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "backup";
      this.adresseTelechargement = this.urlExplorateur + "epegase" + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "backup";
      this.lesBackup.clear();
      File var3 = new File(this.adresseBase);
      String[] var4 = var3.list();
      if (var4 != null) {
         for(int var5 = 0; var5 < var4.length; ++var5) {
            if (!var4[var5].equalsIgnoreCase(".svn")) {
               String var6 = "";
               this.infosSysteme = new InfosSysteme();
               var6 = var4[var5];
               this.infosSysteme.setModule(var6);
               this.infosSysteme.setNbRecords((long)var5);
               this.infosSysteme.setNomTable(this.adresseTelechargement);
               this.infosSysteme.setTaille(this.calculTaille(var6));
               this.lesBackup.add(this.infosSysteme);
            }
         }
      }

      this.datamodelBackup.setWrappedData(this.lesBackup);
   }

   public void selectionFichier() throws MalformedURLException, IOException {
      if (this.datamodelBackup.isRowAvailable()) {
         this.infosSysteme = (InfosSysteme)this.datamodelBackup.getRowData();
         this.nomFichier = this.infosSysteme.getModule();
         String var1 = this.adresseTelechargement + File.separator + this.nomFichier;
         this.fichierUrl = this.utilDownload.convertirFichierUtl(var1, this.urlExplorateur);
         this.fichierMine = this.utilDownload.calculeTypeMine(this.nomFichier);
         this.fichierCode = this.utilDownload.codeAdresse(this.fichierUrl);
         this.selectFile = true;
      }

   }

   public long calculTaille(String var1) throws MalformedURLException, IOException {
      File var2 = new File(this.adresseBase + File.separator + var1);
      String var3 = var2.getAbsolutePath();
      File var4 = new File(var3);
      long var5 = var4.length() / 1024L;
      return var5;
   }

   public boolean backupDB() throws IOException {
      String var1 = "structure" + this.structureLog.getStrid();
      this.processComplete = 0;
      ProcessLauncher var2 = new ProcessLauncher();
      String var3 = "";
      if (StaticModePegase.getAccesBase().contains(":")) {
         String[] var4 = StaticModePegase.getAccesBase().split(":");
         var3 = var4[0];
      } else {
         var3 = StaticModePegase.getAccesBase();
      }

      String var12 = this.utilDate.dateToStringSQL(new Date());
      String[] var5 = var12.split(" ");
      String[] var6 = var5[1].split(":");
      String var7 = var1 + "_" + var5[0] + "_" + var6[0] + "-" + var6[1] + "-" + var6[2] + ".SQL";
      String var8 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "backup" + File.separator + var7;
      String var9 = "";
      String var10 = "";
      if (StaticModePegase.getOsContext() == 0) {
         var9 = "/bin/sh";
         var10 = "-c";
      } else if (StaticModePegase.getOsContext() == 1) {
         var9 = "cmd.exe";
         var10 = "/C";
      } else if (StaticModePegase.getOsContext() == 2) {
         var9 = "/bin/sh";
         var10 = "-c";
      }

      String[] var11 = new String[]{var9, var10, "mysqldump -u" + this.dbUserName + " -p" + this.dbPassword + " --add-drop-database -B --opt -f " + var1 + " >" + var8};
      this.processComplete = var2.exec(var11);
      if (this.processComplete <= 1) {
         this.chargerListeSauvegarde(this.urlExplorateur);
         this.selectFile = false;
         return true;
      } else {
         this.selectFile = false;
         return false;
      }
   }

   public boolean backupDBModule(String var1) throws IOException {
      this.processComplete = 0;
      ProcessLauncher var2 = new ProcessLauncher();
      String var3 = "";
      if (StaticModePegase.getAccesBase().contains(":")) {
         String[] var4 = StaticModePegase.getAccesBase().split(":");
         var3 = var4[0];
      } else {
         var3 = StaticModePegase.getAccesBase();
      }

      String var13 = this.utilDate.dateToStringSQL(new Date());
      String[] var5 = var13.split(" ");
      String[] var6 = var5[1].split(":");
      String var7 = this.baseLog + "_" + var1 + var5[0] + "_" + var6[0] + "-" + var6[1] + "-" + var6[2] + ".SQL";
      String var8 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "backup" + File.separator + var7;
      String var9 = "";
      String var10 = "";
      if (StaticModePegase.getOsContext() == 0) {
         var9 = "/bin/sh";
         var10 = "-c";
      } else if (StaticModePegase.getOsContext() == 1) {
         var9 = "cmd.exe";
         var10 = "/C";
      } else if (StaticModePegase.getOsContext() == 2) {
         var9 = "/bin/sh";
         var10 = "-c";
      }

      String var11 = "";
      if (var1.equalsIgnoreCase("cpt_")) {
         var11 = "cpt_amortissements cpt_amortissements_reg cpt_amortissements_tab cpt_brouillard cpt_budget cpt_budget_ligne cpt_budget_tresorerie cpt_budget_tresorerie_ligne cpt_complement_informations cpt_ecritures cpt_ecritures_analytiques cpt_ecritures_analytiques_destroy cpt_ecritures_anterieur cpt_ecritures_destroy cpt_exercices_comptable cpt_journaux_comptables cpt_journaux_mois cpt_localisation_immobilisation cpt_loyer cpt_plan_budgetaire cpt_plan_bugetaire_compte cpt_plan_comptable cpt_plan_tresorerie cpt_racines cpt_tab_element cpt_tab_formule cpt_tab_nom cpt_tab_resultats";
      }

      String[] var12 = new String[]{var9, var10, "mysqldump -t -u" + this.dbUserName + " -p" + this.dbPassword + " " + this.baseLog + " " + var11 + " --quick --add-drop-table --add-locks --extended-insert --lock-tables  -f >" + var8};
      this.processComplete = var2.exec(var12);
      if (this.processComplete <= 1) {
         this.chargerListeSauvegarde(this.urlExplorateur);
         this.selectFile = false;
         return true;
      } else {
         this.selectFile = false;
         return false;
      }
   }

   public void zipperFichier() throws FileNotFoundException, IOException {
      if (this.infosSysteme != null) {
         String var1 = this.adresseBase + File.separator + this.nomFichier;
         String var2 = var1 + ".ZIP";
         FileOutputStream var3 = new FileOutputStream(var2);
         ZipOutputStream var4 = new ZipOutputStream(var3);
         FileInputStream var5 = new FileInputStream(var1);
         var4.putNextEntry(new ZipEntry(this.nomFichier));
         byte[] var6 = new byte[1024];
         boolean var7 = false;

         int var8;
         while((var8 = var5.read(var6)) > 0) {
            var4.write(var6, 0, var8);
         }

         var4.closeEntry();
         var4.close();
         var5.close();
         this.chargerListeSauvegarde(this.urlExplorateur);
         this.selectFile = false;
      }

   }

   public boolean restoreDB() {
      if (this.infosSysteme != null) {
         if (!this.nomFichier.endsWith(".ZIP")) {
            String var1 = "";
            String var2 = "";
            if (StaticModePegase.getOsContext() == 0) {
               var1 = "/bin/sh";
               var2 = "-c";
            } else if (StaticModePegase.getOsContext() == 1) {
               var1 = "cmd.exe";
               var2 = "/C";
            } else if (StaticModePegase.getOsContext() == 2) {
               var1 = "/bin/sh";
               var2 = "-c";
            }

            String var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "backup" + File.separator + this.nomFichier;
            String[] var4 = new String[]{var1, var2, "mysql -u" + this.dbUserName + " -p" + this.dbPassword + " " + this.baseLog + " <" + var3};

            try {
               Process var5 = Runtime.getRuntime().exec(var4);
               this.processComplete = var5.waitFor();
               if (this.processComplete == 0) {
                  this.selectFile = false;
                  return true;
               }
            } catch (Exception var7) {
               var7.printStackTrace();
            }

            this.selectFile = false;
            return false;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public void supprimerFichier() throws MalformedURLException, IOException {
      if (this.infosSysteme != null) {
         String var1 = this.adresseBase + File.separator + this.nomFichier;
         File var2 = new File(var1);
         var2.delete();
         this.chargerListeSauvegarde(this.urlExplorateur);
         this.selectFile = false;
      }

   }

   public void ajouterExterne() {
      this.uploadedFile = null;
      this.nomFichier = null;
      this.showModalPanelAjoutFile = true;
   }

   public void annulerExterne() {
      this.showModalPanelAjoutFile = false;
   }

   public void validerExeterne() {
      try {
         if (this.uploadedFile != null) {
            String var1 = this.utilDownload.trimFilePath(this.uploadedFile.getName().trim());
            if (var1.toString().contains(".")) {
               if (var1.toString().contains(" ")) {
                  String var2 = var1.toString();
                  String var3 = "";

                  for(int var4 = 0; var4 < var2.length(); ++var4) {
                     String var5 = var2.substring(var4, var4 + 1);
                     if (var5.equals(" ")) {
                        var3 = var3 + "_";
                     } else {
                        var3 = var3 + var2.substring(var4, var4 + 1);
                     }
                  }

                  var1 = var3;
               }

               this.nomFichier = var1;
               File var7 = new File(this.adresseBase + File.separator + this.nomFichier);
               var7.delete();
               File var8 = this.utilDownload.uniqueFile(new File(this.adresseBase + File.separator), this.nomFichier);
               this.utilDownload.write(var8, this.uploadedFile.getInputStream());
               this.infosSysteme = new InfosSysteme();
               this.infosSysteme.setModule(this.nomFichier);
               this.infosSysteme.setNbRecords((long)this.lesBackup.size());
               this.infosSysteme.setNomTable(this.adresseBase);
               this.infosSysteme.setTaille(this.calculTaille(this.nomFichier));
               this.lesBackup.add(this.infosSysteme);
               this.datamodelBackup.setWrappedData(this.lesBackup);
            }
         }
      } catch (IOException var6) {
      }

      this.showModalPanelAjoutFile = false;
   }

   public List chargerListeSousDossier(Session var1) throws MalformedURLException, IOException, HibernateException, NamingException, SQLException {
      this.lesSousDossiers = new ArrayList();
      ArrayList var2 = new ArrayList();
      this.baseSelected = "";
      boolean var3 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         var3 = true;
      }

      List var4 = var1.createSQLQuery("SHOW DATABASES LIKE '" + this.baseLog + "_" + "%'").list();
      if (var4 != null) {
         for(int var5 = 0; var5 < var4.size(); ++var5) {
            if (var4.get(var5).toString().startsWith(this.baseLog + "_")) {
               this.lesSousDossiers.add(var4.get(var5).toString());
               var2.add(new SelectItem(var4.get(var5).toString()));
            }
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      this.datamodelSousDossier = new ListDataModel();
      this.datamodelSousDossier.setWrappedData(this.lesSousDossiers);
      this.selectSousDossier = false;
      return var2;
   }

   public void selectionSousDossier() throws MalformedURLException, IOException {
      if (this.datamodelSousDossier.isRowAvailable()) {
         this.baseSelected = (String)this.datamodelSousDossier.getRowData();
         this.selectSousDossier = true;
      }

   }

   public void creerSousDossier() throws IOException, MalformedURLException, HibernateException, NamingException, SQLException {
      String var1 = "structure" + this.structureLog.getStrid();
      boolean var2 = false;
      ProcessLauncher var3 = new ProcessLauncher();
      String var4 = this.utilDate.dateToStringSQL(new Date());
      String[] var5 = var4.split(" ");
      String[] var6 = var5[1].split(":");
      String[] var7 = var5[0].split("-");
      String var8 = var1 + "_" + var5[0] + "_" + var6[0] + "-" + var6[1] + "-" + var6[2] + ".SQL";
      String var9 = var1 + "_sd_" + var7[0] + var7[1] + var7[2];
      String var10 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "backup" + File.separator + var8;
      String var11 = "";
      String var12 = "";
      if (StaticModePegase.getOsContext() == 0) {
         var11 = "/bin/sh";
         var12 = "-c";
      } else if (StaticModePegase.getOsContext() == 1) {
         var11 = "cmd.exe";
         var12 = "/C";
      } else if (StaticModePegase.getOsContext() == 2) {
         var11 = "/bin/sh";
         var12 = "-c";
      }

      boolean var13 = true;
      Session var14 = this.utilInitHibernate.getLoginEpegase();
      Transaction var15 = null;

      try {
         var15 = var14.beginTransaction();
         SQLQuery var16 = var14.createSQLQuery("CREATE DATABASE IF NOT EXISTS " + var9);
         var16.executeUpdate();
         var15.commit();
      } catch (HibernateException var24) {
         var13 = false;
         if (var15 != null) {
            var15.rollback();
         }

         throw var24;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      if (var13) {
         String[] var27 = new String[]{var11, var12, "mysqldump -u" + this.dbUserName + " -p" + this.dbPassword + " --add-drop-database --opt -f " + var1 + " >" + var10};
         int var26 = var3.exec(var27);
         if (var26 <= 1) {
            this.utilInitHibernate.getOpenSessionVide(var9);
            String[] var17 = new String[]{var11, var12, "mysql -u" + this.dbUserName + " -p" + this.dbPassword + " " + var9 + " <" + var10};

            try {
               Process var18 = Runtime.getRuntime().exec(var17);
               this.processComplete = var18.waitFor();
               if (this.processComplete == 0) {
                  this.chargerListeSauvegarde(this.urlExplorateur);
                  this.chargerListeSousDossier((Session)null);
               }
            } catch (Exception var23) {
               var23.printStackTrace();
            }

            this.utilInitHibernate.closeSession();
         } else {
            this.selectSousDossier = false;
         }
      } else {
         this.selectSousDossier = false;
      }

   }

   public void supprimerSousDossier() throws HibernateException, NamingException, MalformedURLException, IOException, SQLException {
      if (this.baseSelected != null && !this.baseSelected.isEmpty()) {
         Session var1 = this.utilInitHibernate.getLoginEpegase();
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            var1.createSQLQuery("DROP DATABASE " + this.baseSelected).executeUpdate();
            var2.commit();
         } catch (HibernateException var7) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var7;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.chargerListeSousDossier((Session)null);
      }

      this.baseSelected = "";
      this.selectSousDossier = false;
   }

   public void chargerListeBaseLocalhost() throws HibernateException, NamingException {
      this.listBases = new ArrayList();
      this.dataModelBases = new ListDataModel();
      this.dataModelBases.setWrappedData(this.listBases);
      this.etat = 9;
      this.mode = 9;
      this.pays = "0";
      this.type = 0;
      this.titre = "COPIE DES BD de LOCALHOST => serveur ePegase (SYSTEME)";
   }

   public void chargerListeBaseEPegase() throws HibernateException, NamingException {
      this.listBases = new ArrayList();
      this.dataModelBases = new ListDataModel();
      this.dataModelBases.setWrappedData(this.listBases);
      this.etat = 9;
      this.mode = 9;
      this.pays = "0";
      this.type = 1;
      this.titre = "COPIE DES BD de serveur ePegase => serveur Kheweul (SYSTEME)";
   }

   public void chargerLesSocietes() throws HibernateException, NamingException {
      String var1 = " where strId> 0";
      if (this.etat != 9) {
         var1 = var1 + " and  stretat=" + this.etat;
      }

      if (this.mode != 9) {
         var1 = var1 + " and  strmode=" + this.mode;
      }

      if (!this.pays.equals("0")) {
         var1 = var1 + " and  strnompays=" + "'" + this.pays + "'";
      }

      StructureDao var2 = new StructureDao(this.utilInitHibernate);
      this.listBases.clear();
      this.listBases = var2.selectStructurePeg(var1);
      this.dataModelBases.setWrappedData(this.listBases);
   }

   public void toutSelectionner() {
      new StructurePeg();

      for(int var2 = 0; var2 < this.listBases.size(); ++var2) {
         StructurePeg var1 = (StructurePeg)this.listBases.get(var2);
         var1.setSelectStructure(true);
      }

   }

   public void rienSelectionner() {
      new StructurePeg();

      for(int var2 = 0; var2 < this.listBases.size(); ++var2) {
         StructurePeg var1 = (StructurePeg)this.listBases.get(var2);
         var1.setSelectStructure(false);
      }

   }

   public void copyBases() throws IOException, HibernateException, NamingException, Exception {
      if (this.listBases.size() != 0) {
         String var1 = "structure" + this.structureLog.getStrid();
         this.processComplete = 100;
         this.processObservation = "";
         ProcessLauncher var2 = new ProcessLauncher();
         String var3 = "";
         String var4 = "";
         if (StaticModePegase.getOsContext() == 0) {
            var3 = "/bin/sh";
            var4 = "-c";
         } else if (StaticModePegase.getOsContext() == 1) {
            var3 = "cmd.exe";
            var4 = "/C";
         } else if (StaticModePegase.getOsContext() == 2) {
            var3 = "/bin/sh";
            var4 = "-c";
         }

         new StructurePeg();
         String var6 = "";

         for(int var7 = 0; var7 < this.listBases.size(); ++var7) {
            StructurePeg var5 = (StructurePeg)this.listBases.get(var7);
            if (var5.isSelectStructure()) {
               var6 = var6 + " " + "structure" + var5.getStrId();
            }
         }

         if (var6 != null && !var6.isEmpty()) {
            if (this.type == 0) {
               String[] var14 = new String[]{var3, var4, "mysqldump --opt  --databases " + var6 + " -u" + this.dbUserName + " -p" + this.dbPassword + " --add-drop-table -C -f | mysql -uePegaseEXT -pePegaseEXT -h " + StaticModePegase.getIpServeur()};
               this.processComplete = var2.exec(var14);
            } else if (this.type == 1) {
               String var15 = this.utilDate.dateToStringSQL(new Date());
               String[] var8 = var15.split(" ");
               String[] var9 = var8[1].split(":");
               String var10 = "backup_" + var8[0] + "_" + var9[0] + "-" + var9[1] + "-" + var9[2] + ".SQL.bz2";
               String var11 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "backup" + File.separator + var10;
               String[] var12 = new String[]{var3, var4, "mysqldump -u" + this.dbUserName + " -p" + this.dbPassword + " --add-drop-database -B --opt -f " + var6 + " | bzip2 -cq9 >" + var11};
               this.processComplete = var2.exec(var12);
               if (this.processComplete == 0) {
                  String var13 = File.separator + "basesDonnees" + File.separator;
                  this.processObservation = this.utilFtp.sendFile(var11, var10, var13, 21);
               }
            }

            if (this.processComplete != 0) {
               this.processObservation = "Error DUMP " + this.processComplete;
            }

            UtilMail var16 = new UtilMail(this.structureLog);
            new Bal();
            Bal var17 = var16.calculBalEmetteur(this.usersLog.getUsrMail(), 11);
            String var18 = "";
            if (this.type == 0) {
               if (this.processObservation != null && !this.processObservation.isEmpty()) {
                  var18 = "Bases non copiées " + var6 + " rapport : échec = " + this.processComplete + " " + this.processObservation;
               } else {
                  var18 = "Bases copiées " + var6 + " rapport : réussi";
               }

               var16.sendMail(var18, "gillesdecruzel@gmail.com", (String)null, (String)null, var17.getBaladressemail(), (String)null, "Copie bases locahost vers serveur ePegase", var17);
            } else if (this.type == 1) {
               if (this.processObservation != null && !this.processObservation.isEmpty()) {
                  var18 = "Backup Bases " + var6 + " rapport : échec = " + this.processComplete + " " + this.processObservation;
               } else {
                  var18 = "Backup Bases " + var6 + " rapport : réussi";
               }

               var16.sendMail(var18, "gillesdecruzel@gmail.com", (String)null, (String)null, var17.getBaladressemail(), (String)null, "Backup bases serveur ePegase vers serveur Kheweul", var17);
            }
         }
      }

   }

   public void chargerListeRepertoires() throws MalformedURLException, IOException {
      (new StringBuilder()).append("structure").append(this.structureLog.getStrid()).toString();
      this.adresseRepertoire = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog;
      this.lesRepertoires.clear();
      File var2 = new File(this.adresseRepertoire);
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            if (!var3[var4].equalsIgnoreCase(".svn")) {
               String var5 = "";
               this.objetMessageRepertoire = new ObjetMessageSysteme();
               var5 = var3[var4];
               this.objetMessageRepertoire.setTexte(var5);
               this.objetMessageRepertoire.setIndice(var4);
               this.objetMessageRepertoire.setAdresse(this.adresseRepertoire);
               this.objetMessageRepertoire.setTaille(this.calculTaille(var5));
               this.objetMessageRepertoire.setEtat(0);
               this.lesRepertoires.add(this.objetMessageRepertoire);
            }
         }
      }

      this.datamodelRepertoire.setWrappedData(this.lesRepertoires);
      this.lesFichiers.clear();
      this.datamodelFichier.setWrappedData(this.lesFichiers);
   }

   public void selectionRepertoire() throws MalformedURLException, IOException {
      if (this.datamodelRepertoire.isRowAvailable()) {
         this.objetMessageRepertoire = (ObjetMessageSysteme)this.datamodelRepertoire.getRowData();
         int var1 = 0;
         if (this.lesRepertoires.size() != 0) {
            for(int var2 = 0; var2 < this.lesRepertoires.size(); ++var2) {
               if (this.objetMessageRepertoire.getIndice() == ((ObjetMessageSysteme)this.lesRepertoires.get(var2)).getIndice()) {
                  var1 = var2;
                  break;
               }
            }
         }

         this.memoLigneRepertoire = var1;
         this.nomRepertoire = this.objetMessageRepertoire.getTexte();
         if (this.objetMessageRepertoire.getEtat() == 0) {
            this.objetMessageRepertoire.setEtat(1);
         } else {
            this.objetMessageRepertoire.setEtat(0);
         }

         String var8 = "";
         if (this.objetMessageRepertoire.getMemoRepertoire() != null && !this.objetMessageRepertoire.getMemoRepertoire().isEmpty()) {
            var8 = this.adresseRepertoire + File.separator + this.objetMessageRepertoire.getMemoRepertoire() + File.separator + this.nomRepertoire;
            this.memoRepertoire = this.objetMessageRepertoire.getMemoRepertoire() + File.separator + this.nomRepertoire;
         } else {
            var8 = this.adresseRepertoire + File.separator + this.nomRepertoire;
            this.memoRepertoire = this.nomRepertoire;
         }

         this.repertoireUrl = this.utilDownload.convertirFichierUtl(var8, this.urlExplorateur);
         this.selectRepertoire = true;
         new ObjetMessageSysteme();
         ObjetMessageSysteme var3 = this.objetMessageRepertoire;
         int var4;
         if (this.objetMessageRepertoire.getEtat() == 0) {
            for(var4 = 0; var4 < this.lesRepertoires.size(); ++var4) {
               new ObjetMessageSysteme();
               ObjetMessageSysteme var9 = (ObjetMessageSysteme)this.lesRepertoires.get(var4);
               if (var9.getMemoRepertoire() != null && !var9.getMemoRepertoire().isEmpty() && var9.getMemoRepertoire().contains(this.nomRepertoire)) {
                  this.lesRepertoires.remove(var9);
                  --var4;
               }
            }

            this.lesFichiers.clear();
            this.datamodelFichier.setWrappedData(this.lesFichiers);
            this.memoRepertoire = "";
            this.selectFile = false;
            this.selectRepertoire = false;
         } else {
            this.chargerListeFichiers(var8);
            if (this.lesFichiersTemporaires.size() != 0) {
               var4 = this.memoLigneRepertoire;

               for(int var5 = 0; var5 < this.lesFichiersTemporaires.size(); ++var5) {
                  new ObjetMessageSysteme();
                  ObjetMessageSysteme var6 = (ObjetMessageSysteme)this.lesFichiersTemporaires.get(var5);
                  String var7 = "";
                  if (this.objetMessageRepertoire.getMemoRepertoire() != null && !this.objetMessageRepertoire.getMemoRepertoire().isEmpty()) {
                     var7 = this.objetMessageRepertoire.getMemoRepertoire() + File.separator + this.nomRepertoire;
                  } else {
                     var7 = this.nomRepertoire;
                  }

                  var6.setMemoRepertoire(var7);
                  ++var4;
                  this.lesRepertoires.add(var4, var6);
               }
            }
         }

         this.objetMessageRepertoire = var3;
      }

   }

   public void chargerListeFichiers(String var1) throws MalformedURLException, IOException {
      this.lesFichiers.clear();
      this.lesFichiersTemporaires.clear();
      File var2 = new File(var1);
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            if (!var3[var4].equalsIgnoreCase(".svn")) {
               String var5 = "";
               this.objetMessageFichier = new ObjetMessageSysteme();
               var5 = var3[var4];
               this.objetMessageFichier.setTexte(var5);
               this.objetMessageFichier.setIndice(var4);
               this.objetMessageFichier.setAdresse(var1);
               this.objetMessageFichier.setTaille(this.calculTailleFichier(var5));
               this.objetMessageFichier.setSelection(false);
               if (var5.contains(".")) {
                  this.lesFichiers.add(this.objetMessageFichier);
               } else {
                  this.lesFichiersTemporaires.add(this.objetMessageFichier);
               }
            }
         }
      }

      this.datamodelFichier.setWrappedData(this.lesFichiers);
   }

   public long calculTailleFichier(String var1) throws MalformedURLException, IOException {
      File var2 = new File(this.adresseRepertoire + File.separator + this.memoRepertoire + File.separator + var1);
      String var3 = var2.getAbsolutePath();
      File var4 = new File(var3);
      long var5 = var4.length() / 1024L;
      return var5;
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

   public void selectionFichierDossier() throws MalformedURLException, IOException {
      if (this.datamodelFichier.isRowAvailable()) {
         this.objetMessageRepertoire = (ObjetMessageSysteme)this.datamodelFichier.getRowData();
         this.nomFichier = this.objetMessageFichier.getTexte();
         this.selectFile = true;
      }

   }

   public void ajouterFichierDossier() throws MalformedURLException, IOException {
      if (this.nomRepertoire != null && !this.nomRepertoire.isEmpty()) {
         String var1 = "";
         if (this.objetMessageRepertoire.getMemoRepertoire() != null && !this.objetMessageRepertoire.getMemoRepertoire().isEmpty()) {
            var1 = this.adresseRepertoire + File.separator + this.objetMessageRepertoire.getMemoRepertoire() + File.separator + this.nomRepertoire;
            this.memoRepertoire = this.objetMessageRepertoire.getMemoRepertoire() + File.separator + this.nomRepertoire;
         } else {
            var1 = this.adresseRepertoire + File.separator + this.nomRepertoire;
            this.memoRepertoire = this.nomRepertoire;
         }

         this.repertoireUrl = this.utilDownload.convertirFichierUtl(var1, this.urlExplorateur);
         this.repertoireString = this.repertoireUrl.toString() + File.separator;
         this.uploadedFile = null;
      }

      this.showModalPanelAjoutFile = true;
   }

   public void annulerFichierDossier() {
      this.showModalPanelAjoutFile = false;
   }

   public void validerFichierDossier() {
      try {
         if (this.uploadedFile != null) {
            String var1 = this.utilDownload.trimFilePath(this.uploadedFile.getName().trim());
            if (var1.toString().contains(".")) {
               if (var1.toString().contains(" ")) {
                  String var2 = var1.toString();
                  String var3 = "";

                  for(int var4 = 0; var4 < var2.length(); ++var4) {
                     String var5 = var2.substring(var4, var4 + 1);
                     if (var5.equals(" ")) {
                        var3 = var3 + "_";
                     } else {
                        var3 = var3 + var2.substring(var4, var4 + 1);
                     }
                  }

                  var1 = var3;
               }

               File var7 = new File(this.adresseRepertoire + File.separator + this.memoRepertoire + File.separator + var1);
               var7.delete();
               File var8 = this.utilDownload.uniqueFile(new File(this.adresseRepertoire + File.separator + this.memoRepertoire + File.separator), var1);
               this.utilDownload.write(var8, this.uploadedFile.getInputStream());
               this.objetMessageFichier = new ObjetMessageSysteme();
               this.objetMessageFichier.setTexte(var1);
               this.objetMessageFichier.setAdresse(this.adresseRepertoire + File.separator + this.memoRepertoire);
               this.objetMessageFichier.setTaille(this.calculTailleFichier(var1));
               this.objetMessageFichier.setSelection(false);
               this.lesFichiers.add(this.objetMessageFichier);
               this.datamodelFichier.setWrappedData(this.lesFichiers);
            }
         }
      } catch (IOException var6) {
      }

      this.ongletActif = "tabRepertoire";
      this.showModalPanelAjoutFile = false;
   }

   public void suppressionFichierDossier() throws MalformedURLException, IOException {
      if (this.lesFichiers.size() != 0) {
         for(int var1 = 0; var1 < this.lesFichiers.size(); ++var1) {
            new ObjetMessageSysteme();
            ObjetMessageSysteme var2 = (ObjetMessageSysteme)this.lesFichiers.get(var1);
            if (var2.isSelection()) {
               String var3 = var2.getAdresse() + File.separator + var2.getTexte();
               File var4 = new File(var3);
               var4.delete();
               this.lesFichiers.remove(var2);
               --var1;
            }
         }

         this.selectFile = false;
      }

   }

   public void chargerListeTablesSql() throws HibernateException, NamingException, SQLException, ClassNotFoundException, SAXException, IOException {
      (new StringBuilder()).append("structure").append(this.structureLog.getStrid()).toString();
      this.formInfoSysteme.setutilInitHibernate(this.utilInitHibernate);
      this.formInfoSysteme.setBaseLog(this.baseLog);
      this.formInfoSysteme.setStructureLog(this.structureLog);
      this.formInfoSysteme.setUsersLog(this.usersLog);
      this.lesTables = this.formInfoSysteme.chargerListeTable(false, 0);
      this.datamodelTable.setWrappedData(this.lesTables);
      this.lesColonnes.clear();
      this.datamodelColonnes.setWrappedData(this.lesColonnes);
   }

   public void selectionTable() throws HibernateException, NamingException {
      if (this.datamodelTable.isRowAvailable()) {
         this.infosTables = (InfosSysteme)this.datamodelTable.getRowData();
         this.lesColonnes.clear();
         String var1 = this.infosTables.getModule();
         Session var2 = this.utilInitHibernate.getOpenSessionModule(this.baseLog, var1);
         List var3 = var2.createSQLQuery("SELECT COLUMN_NAME FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME='" + this.infosTables.getNomReel() + "'").list();
         List var4 = var2.createSQLQuery("SELECT COLUMN_COMMENT FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME='" + this.infosTables.getNomReel() + "'").list();
         List var5 = var2.createSQLQuery("SELECT DATA_TYPE FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME='" + this.infosTables.getNomReel() + "'").list();
         List var6 = var2.createSQLQuery("SELECT NUMERIC_PRECISION FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME='" + this.infosTables.getNomReel() + "'").list();
         List var7 = var2.createSQLQuery("SELECT CHARACTER_MAXIMUM_LENGTH FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME='" + this.infosTables.getNomReel() + "'").list();
         if (var3.size() != 0 && var4.size() != 0 && var5.size() != 0 && var7.size() != 0) {
            for(int var8 = 0; var8 < var3.size(); ++var8) {
               String var9 = var3.get(var8).toString();
               String var10 = var4.get(var8).toString();
               String var11 = var5.get(var8).toString();
               String var12 = "";
               String var13 = "";
               if (!var11.equalsIgnoreCase("int") && !var11.equalsIgnoreCase("bigint") && !var11.equalsIgnoreCase("float") && !var11.equalsIgnoreCase("double")) {
                  if (var11.equalsIgnoreCase("varchar") || var11.equalsIgnoreCase("text")) {
                     var13 = var7.get(var8).toString();
                  }
               } else {
                  var12 = var6.get(var8).toString();
               }

               ObjetTable var14 = new ObjetTable();
               var14.setIndice(var8);
               var14.setColumn_name(var9);
               var14.setColumn_comment(var10);
               var14.setColumn_type(var11);
               var14.setColumn_numeric(var12);
               var14.setColumn_nbCar(var13);
               this.lesColonnes.add(var14);
            }
         }

         this.datamodelColonnes.setWrappedData(this.lesColonnes);
         this.utilInitHibernate.closeSession();
      }

   }

   public void chergerlesStructures() throws HibernateException, NamingException {
      this.mesStructuresItems.clear();
      StructureDao var1 = new StructureDao(this.utilInitHibernate);
      String var2 = "";
      new ArrayList();
      List var3 = var1.selectStructurePeg(var2);
      if (var3.size() != 0) {
         for(int var4 = 0; var4 < var3.size(); ++var4) {
            this.mesStructuresItems.add(new SelectItem(((StructurePeg)var3.get(var4)).getStrId(), ((StructurePeg)var3.get(var4)).getStrId() + ":" + ((StructurePeg)var3.get(var4)).getStrraisonsociale()));
         }
      }

   }

   public void chargerListeScripts() throws HibernateException, NamingException {
      this.lesScripts.clear();
      this.scriptsDao = new PegScriptsDao(this.utilInitHibernate);
      this.lesScripts = this.scriptsDao.selectScripts();
      this.dataModelScripts.setWrappedData(this.lesScripts);
      this.scripts = new PegScripts();
      this.afficheBoutons = false;
      this.calculHeures();
   }

   public void calculHeures() {
      this.lesHeuresItems.clear();
      int var1 = Integer.parseInt("00");
      int var2 = Integer.parseInt("23");

      for(int var3 = var1; var3 <= var2; ++var3) {
         if (var3 <= 9) {
            this.lesHeuresItems.add(new SelectItem("0" + var3));
         } else {
            this.lesHeuresItems.add(new SelectItem(var3));
         }
      }

      this.lesMinutesItems.clear();
      this.lesMinutesItems.add(new SelectItem("00"));
      this.lesMinutesItems.add(new SelectItem("15"));
      this.lesMinutesItems.add(new SelectItem("30"));
      this.lesMinutesItems.add(new SelectItem("45"));
   }

   public void selectionScript() {
      if (this.dataModelScripts.isRowAvailable()) {
         this.scripts = (PegScripts)this.dataModelScripts.getRowData();
         this.afficheBoutons = true;
      }

   }

   public void ajouterScripts() {
      this.scripts = new PegScripts();
      this.showModalPanelScripts = true;
   }

   public void modifierScripts() {
      if (this.scripts != null) {
         this.showModalPanelScripts = true;
      }

   }

   public void duppliquerScripts() {
      if (this.scripts != null) {
         new PegScripts();
         PegScripts var1 = this.scripts;
         this.scripts = new PegScripts();
         this.scripts.setScrDateCreat(new Date());
         this.scripts.setScrDateDebut(var1.getScrDateDebut());
         this.scripts.setScrDateFin(var1.getScrDateFin());
         this.scripts.setScrDateModif((Date)null);
         this.scripts.setScrDescription(var1.getScrDescription());
         this.scripts.setScrDimanche(var1.isScrDimanche());
         this.scripts.setScrLundi(var1.isScrLundi());
         this.scripts.setScrMardi(var1.isScrMardi());
         this.scripts.setScrMercredi(var1.isScrMercredi());
         this.scripts.setScrJeudi(var1.isScrJeudi());
         this.scripts.setScrVendredi(var1.isScrVendredi());
         this.scripts.setScrSamedi(var1.isScrSamedi());
         this.scripts.setScrHeureDimanche(var1.getScrHeureDimanche());
         this.scripts.setScrHeureJeudi(var1.getScrHeureJeudi());
         this.scripts.setScrHeureLundi(var1.getScrHeureLundi());
         this.scripts.setScrHeureMardi(var1.getScrHeureMardi());
         this.scripts.setScrHeureMercredi(var1.getScrHeureMercredi());
         this.scripts.setScrHeureSamedi(var1.getScrHeureSamedi());
         this.scripts.setScrHeureVendredi(var1.getScrHeureVendredi());
         this.scripts.setScrIdStructure(var1.getScrIdStructure());
         this.scripts.setScrInactif(var1.getScrInactif());
         this.scripts.setScrLibelle(var1.getScrLibelle());
         this.scripts.setScrLogin(var1.getScrLogin());
         this.scripts.setScrMail(var1.getScrMail());
         this.scripts.setScrMethode(var1.getScrMethode());
         this.scripts.setScrMinuteDimanche(var1.getScrMinuteDimanche());
         this.scripts.setScrMinuteJeudi(var1.getScrMinuteJeudi());
         this.scripts.setScrMinuteLundi(var1.getScrMinuteLundi());
         this.scripts.setScrMinuteMardi(var1.getScrMinuteMardi());
         this.scripts.setScrMinuteMercredi(var1.getScrMinuteMercredi());
         this.scripts.setScrMinuteSamedi(var1.getScrMinuteMercredi());
         this.scripts.setScrMinuteVendredi(var1.getScrMinuteVendredi());
         this.scripts.setScrNomStructure(var1.getScrNomStructure());
         this.scripts.setScrParametreChemin(var1.getScrParametreChemin());
         this.scripts.setScrPw(var1.getScrPw());
         this.scripts.setScrType(var1.getScrType());
         this.scripts.setScrUrl(var1.getScrUrl());
         this.scripts.setScrUserCreat(this.usersLog.getUsrid());
         this.scripts.setScrUserModif(0L);
         this.showModalPanelScripts = true;
      }

   }

   public void supprimerScripts() throws HibernateException, NamingException {
      if (this.scripts != null) {
         this.lesScripts.remove(this.scripts);
         this.scriptsDao.delete(this.scripts);
         this.dataModelScripts.setWrappedData(this.lesScripts);
         this.afficheBoutons = false;
      }

   }

   public void validerScripts() throws HibernateException, NamingException {
      if (this.scripts.getScrIdStructure() != 0L) {
         for(int var1 = 0; var1 < this.mesStructuresItems.size(); ++var1) {
            if (Long.parseLong(((SelectItem)this.mesStructuresItems.get(var1)).getValue().toString()) == this.scripts.getScrIdStructure()) {
               String[] var2 = ((SelectItem)this.mesStructuresItems.get(var1)).getLabel().toString().split(":");
               this.scripts.setScrNomStructure(var2[1]);
               break;
            }
         }
      }

      if (this.scripts.getScrLibelle() != null && !this.scripts.getScrLibelle().isEmpty()) {
         if (this.scripts.getScrId() == 0L) {
            this.scripts.setScrDateCreat(new Date());
            this.scripts.setScrUserCreat(this.usersLog.getUsrid());
            this.scripts = this.scriptsDao.insert(this.scripts);
            this.lesScripts.add(this.scripts);
            if (this.allBases && this.mesStructuresItems.size() != 0) {
               new PegScripts();

               for(int var10 = 0; var10 < this.mesStructuresItems.size(); ++var10) {
                  long var3 = Long.parseLong(((SelectItem)this.mesStructuresItems.get(var10)).getValue().toString());
                  String var5 = ((SelectItem)this.mesStructuresItems.get(var10)).getLabel().toString();
                  String[] var6 = var5.split(":");
                  PegScripts var9 = new PegScripts();
                  var9.setScrIdStructure(var3);
                  var9.setScrNomStructure(var6[1]);
                  var9.setScrDateCreat(this.scripts.getScrDateCreat());
                  var9.setScrDateDebut(this.scripts.getScrDateDebut());
                  var9.setScrDateFin(this.scripts.getScrDateFin());
                  var9.setScrDateModif((Date)null);
                  var9.setScrDescription(this.scripts.getScrDescription());
                  var9.setScrLibelle(this.scripts.getScrLibelle());
                  var9.setScrLogin(this.scripts.getScrLogin());
                  var9.setScrMail(this.scripts.getScrMail());
                  var9.setScrMethode(this.scripts.getScrMethode());
                  var9.setScrInactif(this.scripts.getScrInactif());
                  var9.setScrParametreChemin(this.scripts.getScrParametreChemin());
                  var9.setScrPw(this.scripts.getScrPw());
                  var9.setScrType(this.scripts.getScrType());
                  var9.setScrUrl(this.scripts.getScrUrl());
                  var9.setScrHeureDimanche(this.scripts.getScrHeureDimanche());
                  var9.setScrHeureJeudi(this.scripts.getScrHeureJeudi());
                  var9.setScrHeureLundi(this.scripts.getScrHeureLundi());
                  var9.setScrHeureMardi(this.scripts.getScrHeureMardi());
                  var9.setScrHeureMercredi(this.scripts.getScrMinuteMercredi());
                  var9.setScrHeureSamedi(this.scripts.getScrHeureSamedi());
                  var9.setScrHeureVendredi(this.scripts.getScrHeureVendredi());
                  var9.setScrMinuteDimanche(this.scripts.getScrMinuteDimanche());
                  var9.setScrMinuteJeudi(this.scripts.getScrMinuteJeudi());
                  var9.setScrMinuteLundi(this.scripts.getScrMinuteLundi());
                  var9.setScrMinuteMardi(this.scripts.getScrMinuteMardi());
                  var9.setScrMinuteMercredi(this.scripts.getScrMinuteMercredi());
                  var9.setScrMinuteSamedi(this.scripts.getScrMinuteSamedi());
                  var9.setScrMinuteVendredi(this.scripts.getScrMinuteVendredi());
                  var9.setScrDimanche(this.scripts.isScrDimanche());
                  var9.setScrJeudi(this.scripts.isScrJeudi());
                  var9.setScrLundi(this.scripts.isScrLundi());
                  var9.setScrMardi(this.scripts.isScrMardi());
                  var9.setScrMercredi(this.scripts.isScrMercredi());
                  var9.setScrSamedi(this.scripts.isScrSamedi());
                  var9.setScrVendredi(this.scripts.isScrVendredi());
                  boolean var7 = false;

                  for(int var8 = 0; var8 < this.lesScripts.size(); ++var8) {
                     if (((PegScripts)this.lesScripts.get(var8)).getScrIdStructure() == var9.getScrIdStructure() && ((PegScripts)this.lesScripts.get(var8)).getScrType() == var9.getScrType()) {
                        var7 = true;
                        break;
                     }
                  }

                  if (!var7) {
                     var9 = this.scriptsDao.insert(var9);
                     this.lesScripts.add(var9);
                  }
               }
            }

            this.dataModelScripts.setWrappedData(this.lesScripts);
         } else {
            this.scripts.setScrDateModif(new Date());
            this.scripts.setScrUserModif(this.usersLog.getUsrid());
            this.scripts = this.scriptsDao.modif(this.scripts);
         }
      }

      this.afficheBoutons = true;
      this.showModalPanelScripts = false;
   }

   public void fermerScripts() {
      this.scripts = null;
      this.afficheBoutons = false;
      this.showModalPanelScripts = false;
   }

   public void executerScriptsDirect() throws Exception {
      this.structureLog.setStrappDropbox("3");
      this.executerScripts();
   }

   public void executerScripts() throws Exception {
      if (this.scripts != null) {
         System.out.println("Execution Script " + this.scripts.getScrLibelle());
         String var1 = "structure" + this.scripts.getScrIdStructure();
         this.processComplete = 100;
         this.processObservation = "";
         ProcessLauncher var2 = new ProcessLauncher();
         String var3 = "";
         if (StaticModePegase.getAccesBase().contains(":")) {
            String[] var4 = StaticModePegase.getAccesBase().split(":");
            var3 = var4[0];
         } else {
            var3 = StaticModePegase.getAccesBase();
         }

         String var9 = "";
         String var5 = "";
         if (StaticModePegase.getOsContext() == 0) {
            var9 = "/bin/sh";
            var5 = "-c";
         } else if (StaticModePegase.getOsContext() == 1) {
            var9 = "cmd.exe";
            var5 = "/C";
         } else if (StaticModePegase.getOsContext() == 2) {
            var9 = "/bin/sh";
            var5 = "-c";
         }

         if (this.structureLog.getStrappDropbox() != null && !this.structureLog.getStrappDropbox().isEmpty()) {
            if (this.structureLog.getStrappDropbox().equals("1")) {
               this.modeBakckup = 1;
            } else if (this.structureLog.getStrappDropbox().equals("2")) {
               this.modeBakckup = 2;
            } else if (this.structureLog.getStrappDropbox().equals("3")) {
               this.modeBakckup = 3;
            } else {
               this.modeBakckup = 0;
            }
         } else {
            this.modeBakckup = 0;
         }

         if (this.scripts.getScrType() == 1) {
            this.methode1(var9, var5, var1, var2);
         } else if (this.scripts.getScrType() == 2) {
            this.methode2(var9, var5, var1, var2);
         } else if (this.scripts.getScrType() == 3) {
            this.methode3();
         } else if (this.scripts.getScrType() == 4) {
            this.methode4(var9, var5, var1, var2);
         } else if (this.scripts.getScrType() == 5) {
            this.methode5(var9, var5, var1, var2);
         } else if (this.scripts.getScrType() == 6) {
            this.methode6();
         } else if (this.scripts.getScrType() == 7) {
            this.methode7();
         } else if (this.scripts.getScrType() == 8) {
            this.methode8();
         } else if (this.scripts.getScrType() == 9) {
            this.methode9();
         } else if (this.scripts.getScrType() == 10) {
            this.methode10();
         } else if (this.scripts.getScrType() == 11) {
            this.methode11();
         } else if (this.scripts.getScrType() == 21) {
            this.methode21(var9, var5, var1, var2);
         } else if (this.scripts.getScrType() == 22) {
            this.methode22();
         } else if (this.scripts.getScrType() == 23) {
            this.methode23();
         } else if (this.scripts.getScrType() == 99) {
            this.methode99();
         }

         if (this.modeBakckup != 0 && this.scripts.getScrMail() != null && !this.scripts.getScrMail().isEmpty()) {
            UtilMail var6 = new UtilMail();
            new Bal();
            Bal var7 = var6.calculBalEmetteur(this.scripts.getScrMail(), 11);
            String var8 = "";
            if (this.processObservation != null && !this.processObservation.isEmpty()) {
               var8 = "Script " + this.scripts.getScrLibelle() + " rapport : échec = " + this.processComplete + " " + this.processObservation;
            } else {
               var8 = "Script " + this.scripts.getScrLibelle() + " rapport : réussi";
            }

            var6.sendMail(var8, this.scripts.getScrMail(), (String)null, (String)null, var7.getBaladressemail(), (String)null, "Script ePegase " + this.scripts.getScrLibelle() + " : " + this.scripts.getScrNomStructure(), var7);
         }
      }

   }

   public void methode1(String var1, String var2, String var3, ProcessLauncher var4) throws IOException {
      String[] var5 = new String[]{var1, var2, "mysqldump -u" + this.dbUserName + " -p" + this.dbPassword + " --add-drop-database -B --opt -f " + var3 + " | mysql -uePegaseEXT -pePegaseEXT## -h " + StaticModePegase.getIpServeur() + var3};
      this.processComplete = var4.exec(var5);
      if (this.processComplete != 0) {
         this.processObservation = "Error DUMP " + this.processComplete;
      }

   }

   public void methode2(String var1, String var2, String var3, ProcessLauncher var4) throws IOException {
      String var5 = this.utilDate.dateToStringSQL(new Date());
      String[] var6 = var5.split(" ");
      String[] var7 = var6[1].split(":");
      String var8 = "";
      if (this.modeBakckup != 0) {
         if (this.modeBakckup == 1) {
            var8 = var3 + "_" + var6[0] + ".SQL.bz2";
         } else if (this.modeBakckup == 2) {
            var8 = var3 + "_" + var6[0] + "_" + var7[0] + ".SQL.bz2";
         } else if (this.modeBakckup == 3) {
            var8 = var3 + "_" + var6[0] + "_" + var7[0] + "-" + var7[1] + ".SQL.bz2";
         }

         String var9 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.scripts.getScrIdStructure() + File.separator + "backup" + File.separator + var8;
         String[] var10 = new String[]{var1, var2, "mysqldump -u" + this.dbUserName + " -p" + this.dbPassword + " --add-drop-database -B --opt -f " + var3 + " | bzip2 -cq9 >" + var9};
         this.processComplete = var4.exec(var10);
         if (this.processComplete == 0) {
            String var11 = File.separator + "clients" + File.separator + "structure" + this.scripts.getScrIdStructure() + File.separator + "backup" + File.separator;
            this.processObservation = this.utilFtp.sendFile(var9, var8, var11, 0);
         } else {
            this.processObservation = "Error DUMP " + this.processComplete;
         }
      } else {
         this.processObservation = "Backup non pris en charge";
      }

   }

   public void methode3() {
      this.processObservation = "Méthode non implémentée";
   }

   public void methode4(String var1, String var2, String var3, ProcessLauncher var4) throws IOException {
      if (this.scripts.getScrParametreChemin() != null && !this.scripts.getScrParametreChemin().isEmpty()) {
         String var5 = this.utilDate.dateToStringSQL(new Date());
         String[] var6 = var5.split(" ");
         String[] var7 = var6[1].split(":");
         String var8 = "";
         if (this.modeBakckup != 0) {
            if (this.modeBakckup == 1) {
               var8 = var3 + "_" + var6[0] + ".SQL.bz2";
            } else if (this.modeBakckup == 2) {
               var8 = var3 + "_" + var6[0] + "_" + var7[0] + ".SQL.bz2";
            } else if (this.modeBakckup == 3) {
               var8 = var3 + "_" + var6[0] + "_" + var7[0] + "-" + var7[1] + ".SQL.bz2";
            }

            String var9 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.scripts.getScrIdStructure() + File.separator + "backup" + File.separator + var8;
            String[] var10 = new String[]{var1, var2, "mysqldump -u" + this.dbUserName + " -p" + this.dbPassword + " --add-drop-database -B --opt -f " + var3 + " | bzip2 -cq9 >" + var9};
            this.processComplete = var4.exec(var10);
            if (this.processComplete == 0) {
               File var11 = new File(var9);
               String var12 = "";
               if (!this.scripts.getScrParametreChemin().endsWith("/") && !this.scripts.getScrParametreChemin().equals(":")) {
                  var12 = this.scripts.getScrParametreChemin() + File.separator + var8;
               } else {
                  var12 = this.scripts.getScrParametreChemin() + var8;
               }

               File var13 = new File(var12);
               this.utilDownload.copy(var11, var13);
            } else {
               this.processObservation = "Error DUMP " + this.processComplete;
            }
         } else {
            this.processObservation = "Le chemin de destination n`est pas spécifié...";
         }
      } else {
         this.processObservation = "Backup non pris en charge";
      }

   }

   public void methode5(String var1, String var2, String var3, ProcessLauncher var4) throws IOException {
      if (this.scripts.getScrParametreChemin() != null && !this.scripts.getScrParametreChemin().isEmpty()) {
         String var5 = this.utilDate.dateToStringSQL(new Date());
         String[] var6 = var5.split(" ");
         String[] var7 = var6[1].split(":");
         String var8 = "";
         if (this.modeBakckup != 0) {
            if (this.modeBakckup == 1) {
               var8 = var3 + "_" + var6[0] + ".SQL.bz2";
            } else if (this.modeBakckup == 2) {
               var8 = var3 + "_" + var6[0] + "_" + var7[0] + ".SQL.bz2";
            } else if (this.modeBakckup == 3) {
               var8 = var3 + "_" + var6[0] + "_" + var7[0] + "-" + var7[1] + ".SQL.bz2";
            }

            String var9 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.scripts.getScrIdStructure() + File.separator + "backup" + File.separator + var8;
            String[] var10 = new String[]{var1, var2, "mysqldump -u" + this.dbUserName + " -p" + this.dbPassword + " --add-drop-database -B --opt -f " + var3 + " | bzip2 -cq9 >" + var9};
            this.processComplete = var4.exec(var10);
            if (this.processComplete == 0) {
               String var11 = this.scripts.getScrParametreChemin();
               this.utilFtp.setFtpHostIPParam(this.scripts.getScrUrl());
               this.utilFtp.setUsernameParam(this.scripts.getScrLogin());
               this.utilFtp.setPasswordParam(this.scripts.getScrPw());
               this.utilFtp.setPortParam(21);
               this.processObservation = this.utilFtp.sendFile(var9, var8, var11, 3);
            } else {
               this.processObservation = "Error DUMP " + this.processComplete;
            }
         } else {
            this.processObservation = "Le chemin de destination n`est pas spécifié...";
         }
      } else {
         this.processObservation = "Backup non pris en charge";
      }

   }

   public void methode6() throws UnknownHostException, SocketException, IOException {
      String var1 = this.utilDate.dateToStringSQL(new Date());
      String[] var2 = var1.split(" ");
      String[] var3 = var2[1].split(":");
      String var4 = "";
      var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.scripts.getScrIdStructure();
      String var5 = "";
      if (this.modeBakckup != 0) {
         if (this.modeBakckup == 1) {
            var5 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.scripts.getScrIdStructure() + File.separator + "str" + "_" + this.scripts.getScrIdStructure() + "_" + var2[0] + ".ZIP";
         } else if (this.modeBakckup == 2) {
            var5 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.scripts.getScrIdStructure() + File.separator + "str" + "_" + this.scripts.getScrIdStructure() + "_" + var2[0] + "_" + var3[0] + "-" + var3[1] + ".ZIP";
         } else if (this.modeBakckup == 3) {
            var5 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.scripts.getScrIdStructure() + File.separator + "str" + "_" + this.scripts.getScrIdStructure() + "_" + var2[0] + "_" + var3[0] + "-" + var3[1] + "-" + var3[2] + ".ZIP";
         }

         short var6 = 2048;

         try {
            ArrayList var7 = new ArrayList();
            this.listeRepertoire(new File(var4), var7);
            BufferedInputStream var8 = null;
            FileOutputStream var9 = new FileOutputStream(var5);
            ZipOutputStream var10 = new ZipOutputStream(new BufferedOutputStream(var9));
            byte[] var11 = new byte[var6];

            for(int var12 = 0; var12 < var7.size(); ++var12) {
               int var13 = ((String)var7.get(var12)).toString().indexOf("structure" + this.scripts.getScrIdStructure());
               int var14 = ((String)var7.get(var12)).toString().length();
               String var15 = ((String)var7.get(var12)).toString().substring(var13, var14);
               FileInputStream var16 = new FileInputStream((String)var7.get(var12));
               var8 = new BufferedInputStream(var16, var6);
               if (var15.contains(".")) {
                  ZipEntry var17 = new ZipEntry(var15);
                  var10.putNextEntry(var17);

                  int var18;
                  while((var18 = var8.read(var11, 0, var6)) != -1) {
                     var10.write(var11, 0, var18);
                  }

                  var8.close();
               }
            }

            var10.close();
         } catch (Exception var19) {
            var19.printStackTrace();
         }

         File var20 = new File(var5);
         String var21 = File.separator + "clients" + File.separator + "structure" + this.scripts.getScrIdStructure() + File.separator + "backup" + File.separator;
         this.processObservation = this.utilFtp.sendFile(var5, var20.getName(), var21, 10);
         var20.delete();
      } else {
         this.processObservation = "Backup non pris en charge";
      }

   }

   public void methode7() throws IOException {
      if (this.scripts.getScrParametreChemin() != null && !this.scripts.getScrParametreChemin().isEmpty()) {
         String var1 = this.utilDate.dateToStringSQL(new Date());
         String[] var2 = var1.split(" ");
         String[] var3 = var2[1].split(":");
         String var4 = "";
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.scripts.getScrIdStructure();
         String var5 = "";
         if (this.modeBakckup != 0) {
            if (this.modeBakckup == 1) {
               var5 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.scripts.getScrIdStructure() + File.separator + "str" + "_" + this.scripts.getScrIdStructure() + "_" + var2[0] + ".ZIP";
            } else if (this.modeBakckup == 2) {
               var5 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.scripts.getScrIdStructure() + File.separator + "str" + "_" + this.scripts.getScrIdStructure() + "_" + var2[0] + "_" + var3[0] + "-" + var3[1] + ".ZIP";
            } else if (this.modeBakckup == 3) {
               var5 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.scripts.getScrIdStructure() + File.separator + "str" + "_" + this.scripts.getScrIdStructure() + "_" + var2[0] + "_" + var3[0] + "-" + var3[1] + "-" + var3[2] + ".ZIP";
            }

            short var6 = 2048;

            try {
               ArrayList var7 = new ArrayList();
               this.listeRepertoire(new File(var4), var7);
               BufferedInputStream var8 = null;
               FileOutputStream var9 = new FileOutputStream(var5);
               ZipOutputStream var10 = new ZipOutputStream(new BufferedOutputStream(var9));
               byte[] var11 = new byte[var6];

               for(int var12 = 0; var12 < var7.size(); ++var12) {
                  int var13 = ((String)var7.get(var12)).toString().indexOf("structure" + this.scripts.getScrIdStructure());
                  int var14 = ((String)var7.get(var12)).toString().length();
                  String var15 = ((String)var7.get(var12)).toString().substring(var13, var14);
                  FileInputStream var16 = new FileInputStream((String)var7.get(var12));
                  var8 = new BufferedInputStream(var16, var6);
                  if (var15.contains(".")) {
                     ZipEntry var17 = new ZipEntry(var15);
                     var10.putNextEntry(var17);

                     int var18;
                     while((var18 = var8.read(var11, 0, var6)) != -1) {
                        var10.write(var11, 0, var18);
                     }

                     var8.close();
                  }
               }

               var10.close();
            } catch (Exception var19) {
               var19.printStackTrace();
            }

            File var20 = new File(var5);
            String var21 = "";
            if (!this.scripts.getScrParametreChemin().endsWith("/") && !this.scripts.getScrParametreChemin().equals(":")) {
               var21 = this.scripts.getScrParametreChemin() + File.separator + var20.getName();
            } else {
               var21 = this.scripts.getScrParametreChemin() + var20.getName();
            }

            File var22 = new File(var21);
            this.utilDownload.copy(var20, var22);
            var20.delete();
         } else {
            this.processObservation = "Le chemin de destination n`est pas spécifié...";
         }
      } else {
         this.processObservation = "Backup non pris en charge";
      }

   }

   public void methode8() throws UnknownHostException, SocketException, IOException {
      if (this.scripts.getScrParametreChemin() != null && !this.scripts.getScrParametreChemin().isEmpty()) {
         String var1 = this.utilDate.dateToStringSQL(new Date());
         String[] var2 = var1.split(" ");
         String[] var3 = var2[1].split(":");
         String var4 = "";
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.scripts.getScrIdStructure();
         String var5 = "";
         if (this.modeBakckup != 0) {
            if (this.modeBakckup == 1) {
               var5 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.scripts.getScrIdStructure() + File.separator + "str" + "_" + this.scripts.getScrIdStructure() + "_" + var2[0] + ".ZIP";
            } else if (this.modeBakckup == 2) {
               var5 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.scripts.getScrIdStructure() + File.separator + "str" + "_" + this.scripts.getScrIdStructure() + "_" + var2[0] + "_" + var3[0] + "-" + var3[1] + ".ZIP";
            } else if (this.modeBakckup == 3) {
               var5 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.scripts.getScrIdStructure() + File.separator + "str" + "_" + this.scripts.getScrIdStructure() + "_" + var2[0] + "_" + var3[0] + "-" + var3[1] + "-" + var3[2] + ".ZIP";
            }

            short var6 = 2048;

            try {
               ArrayList var7 = new ArrayList();
               this.listeRepertoire(new File(var4), var7);
               BufferedInputStream var8 = null;
               FileOutputStream var9 = new FileOutputStream(var5);
               ZipOutputStream var10 = new ZipOutputStream(new BufferedOutputStream(var9));
               byte[] var11 = new byte[var6];

               for(int var12 = 0; var12 < var7.size(); ++var12) {
                  int var13 = ((String)var7.get(var12)).toString().indexOf("structure" + this.scripts.getScrIdStructure());
                  int var14 = ((String)var7.get(var12)).toString().length();
                  String var15 = ((String)var7.get(var12)).toString().substring(var13, var14);
                  FileInputStream var16 = new FileInputStream((String)var7.get(var12));
                  var8 = new BufferedInputStream(var16, var6);
                  if (var15.contains(".")) {
                     ZipEntry var17 = new ZipEntry(var15);
                     var10.putNextEntry(var17);

                     int var18;
                     while((var18 = var8.read(var11, 0, var6)) != -1) {
                        var10.write(var11, 0, var18);
                     }

                     var8.close();
                  }
               }

               var10.close();
            } catch (Exception var19) {
               var19.printStackTrace();
            }

            File var20 = new File(var5);
            String var21 = "";
            if (!this.scripts.getScrParametreChemin().endsWith("/") && !this.scripts.getScrParametreChemin().equals(":")) {
               var21 = this.scripts.getScrParametreChemin() + File.separator + var20.getName();
            } else {
               var21 = this.scripts.getScrParametreChemin() + var20.getName();
            }

            this.utilFtp.setFtpHostIPParam(this.scripts.getScrUrl());
            this.utilFtp.setUsernameParam(this.scripts.getScrLogin());
            this.utilFtp.setPasswordParam(this.scripts.getScrPw());
            this.utilFtp.setPortParam(21);
            this.processObservation = this.utilFtp.sendFile(var5, var20.getName(), var21, 3);
            var20.delete();
         } else {
            this.processObservation = "Le chemin de destination n`est pas spécifié...";
         }
      } else {
         this.processObservation = "Backup non pris en charge";
      }

   }

   public void methode9() throws UnknownHostException, SocketException, IOException {
      String var1 = this.utilDate.dateToStringSQL(new Date());
      String[] var2 = var1.split(" ");
      String[] var3 = var2[1].split(":");
      String var4 = "";
      var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.scripts.getScrIdStructure() + File.separator + "photos";
      String var5 = "";
      if (this.modeBakckup != 0) {
         if (this.modeBakckup == 1) {
            var5 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.scripts.getScrIdStructure() + File.separator + "ged" + "_" + this.scripts.getScrIdStructure() + "_" + var2[0] + ".ZIP";
         } else if (this.modeBakckup == 2) {
            var5 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.scripts.getScrIdStructure() + File.separator + "ged" + "_" + this.scripts.getScrIdStructure() + "_" + var2[0] + "_" + var3[0] + "-" + var3[1] + ".ZIP";
         } else if (this.modeBakckup == 3) {
            var5 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.scripts.getScrIdStructure() + File.separator + "ged" + "_" + this.scripts.getScrIdStructure() + "_" + var2[0] + "_" + var3[0] + "-" + var3[1] + "-" + var3[2] + ".ZIP";
         }

         short var6 = 2048;

         try {
            ArrayList var7 = new ArrayList();
            this.listeRepertoire(new File(var4), var7);
            BufferedInputStream var8 = null;
            FileOutputStream var9 = new FileOutputStream(var5);
            ZipOutputStream var10 = new ZipOutputStream(new BufferedOutputStream(var9));
            byte[] var11 = new byte[var6];

            for(int var12 = 0; var12 < var7.size(); ++var12) {
               int var13 = ((String)var7.get(var12)).toString().indexOf("structure" + this.scripts.getScrIdStructure());
               int var14 = ((String)var7.get(var12)).toString().length();
               String var15 = ((String)var7.get(var12)).toString().substring(var13, var14) + File.separator + "photos";
               FileInputStream var16 = new FileInputStream((String)var7.get(var12));
               var8 = new BufferedInputStream(var16, var6);
               if (var15.contains(".")) {
                  ZipEntry var17 = new ZipEntry(var15);
                  var10.putNextEntry(var17);

                  int var18;
                  while((var18 = var8.read(var11, 0, var6)) != -1) {
                     var10.write(var11, 0, var18);
                  }

                  var8.close();
               }
            }

            var10.close();
         } catch (Exception var19) {
            var19.printStackTrace();
         }

         File var20 = new File(var5);
         String var21 = File.separator + "clients" + File.separator + "structure" + this.scripts.getScrIdStructure() + File.separator + "backup" + File.separator;
         this.processObservation = this.utilFtp.sendFile(var5, var20.getName(), var21, 10);
         var20.delete();
      } else {
         this.processObservation = "Backup non pris en charge";
      }

   }

   public void methode10() throws IOException {
      if (this.scripts.getScrParametreChemin() != null && !this.scripts.getScrParametreChemin().isEmpty()) {
         String var1 = this.utilDate.dateToStringSQL(new Date());
         String[] var2 = var1.split(" ");
         String[] var3 = var2[1].split(":");
         String var4 = "";
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.scripts.getScrIdStructure() + File.separator + "photos";
         String var5 = "";
         if (this.modeBakckup != 0) {
            if (this.modeBakckup == 1) {
               var5 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.scripts.getScrIdStructure() + File.separator + "ged" + "_" + this.scripts.getScrIdStructure() + "_" + var2[0] + ".ZIP";
            } else if (this.modeBakckup == 2) {
               var5 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.scripts.getScrIdStructure() + File.separator + "ged" + "_" + this.scripts.getScrIdStructure() + "_" + var2[0] + "_" + var3[0] + "-" + var3[1] + ".ZIP";
            } else if (this.modeBakckup == 3) {
               var5 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.scripts.getScrIdStructure() + File.separator + "ged" + "_" + this.scripts.getScrIdStructure() + "_" + var2[0] + "_" + var3[0] + "-" + var3[1] + "-" + var3[2] + ".ZIP";
            }

            short var6 = 2048;

            try {
               ArrayList var7 = new ArrayList();
               this.listeRepertoire(new File(var4), var7);
               BufferedInputStream var8 = null;
               FileOutputStream var9 = new FileOutputStream(var5);
               ZipOutputStream var10 = new ZipOutputStream(new BufferedOutputStream(var9));
               byte[] var11 = new byte[var6];

               for(int var12 = 0; var12 < var7.size(); ++var12) {
                  int var13 = ((String)var7.get(var12)).toString().indexOf("structure" + this.scripts.getScrIdStructure());
                  int var14 = ((String)var7.get(var12)).toString().length();
                  String var15 = ((String)var7.get(var12)).toString().substring(var13, var14) + File.separator + "photos";
                  FileInputStream var16 = new FileInputStream((String)var7.get(var12));
                  var8 = new BufferedInputStream(var16, var6);
                  if (var15.contains(".")) {
                     ZipEntry var17 = new ZipEntry(var15);
                     var10.putNextEntry(var17);

                     int var18;
                     while((var18 = var8.read(var11, 0, var6)) != -1) {
                        var10.write(var11, 0, var18);
                     }

                     var8.close();
                  }
               }

               var10.close();
            } catch (Exception var19) {
               var19.printStackTrace();
            }

            File var20 = new File(var5);
            String var21 = "";
            if (!this.scripts.getScrParametreChemin().endsWith("/") && !this.scripts.getScrParametreChemin().equals(":")) {
               var21 = this.scripts.getScrParametreChemin() + File.separator + var20.getName();
            } else {
               var21 = this.scripts.getScrParametreChemin() + var20.getName();
            }

            File var22 = new File(var21);
            this.utilDownload.copy(var20, var22);
            var20.delete();
         } else {
            this.processObservation = "Le chemin de destination n`est pas spécifié...";
         }
      } else {
         this.processObservation = "Backup non pris en charge";
      }

   }

   public void methode11() throws UnknownHostException, SocketException, IOException {
      if (this.scripts.getScrParametreChemin() != null && !this.scripts.getScrParametreChemin().isEmpty()) {
         String var1 = this.utilDate.dateToStringSQL(new Date());
         String[] var2 = var1.split(" ");
         String[] var3 = var2[1].split(":");
         String var4 = "";
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.scripts.getScrIdStructure() + File.separator + "photos";
         String var5 = "";
         if (this.modeBakckup != 0) {
            if (this.modeBakckup == 1) {
               var5 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.scripts.getScrIdStructure() + File.separator + "ged" + "_" + this.scripts.getScrIdStructure() + "_" + var2[0] + ".ZIP";
            } else if (this.modeBakckup == 2) {
               var5 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.scripts.getScrIdStructure() + File.separator + "ged" + "_" + this.scripts.getScrIdStructure() + "_" + var2[0] + "_" + var3[0] + "-" + var3[1] + ".ZIP";
            } else if (this.modeBakckup == 3) {
               var5 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.scripts.getScrIdStructure() + File.separator + "ged" + "_" + this.scripts.getScrIdStructure() + "_" + var2[0] + "_" + var3[0] + "-" + var3[1] + "-" + var3[2] + ".ZIP";
            }

            short var6 = 2048;

            try {
               ArrayList var7 = new ArrayList();
               this.listeRepertoire(new File(var4), var7);
               BufferedInputStream var8 = null;
               FileOutputStream var9 = new FileOutputStream(var5);
               ZipOutputStream var10 = new ZipOutputStream(new BufferedOutputStream(var9));
               byte[] var11 = new byte[var6];

               for(int var12 = 0; var12 < var7.size(); ++var12) {
                  int var13 = ((String)var7.get(var12)).toString().indexOf("structure" + this.scripts.getScrIdStructure());
                  int var14 = ((String)var7.get(var12)).toString().length();
                  String var15 = ((String)var7.get(var12)).toString().substring(var13, var14) + File.separator + "photos";
                  FileInputStream var16 = new FileInputStream((String)var7.get(var12));
                  var8 = new BufferedInputStream(var16, var6);
                  if (var15.contains(".")) {
                     ZipEntry var17 = new ZipEntry(var15);
                     var10.putNextEntry(var17);

                     int var18;
                     while((var18 = var8.read(var11, 0, var6)) != -1) {
                        var10.write(var11, 0, var18);
                     }

                     var8.close();
                  }
               }

               var10.close();
            } catch (Exception var19) {
               var19.printStackTrace();
            }

            File var20 = new File(var5);
            String var21 = "";
            if (!this.scripts.getScrParametreChemin().endsWith("/") && !this.scripts.getScrParametreChemin().equals(":")) {
               var21 = this.scripts.getScrParametreChemin() + File.separator + var20.getName();
            } else {
               var21 = this.scripts.getScrParametreChemin() + var20.getName();
            }

            this.utilFtp.setFtpHostIPParam(this.scripts.getScrUrl());
            this.utilFtp.setUsernameParam(this.scripts.getScrLogin());
            this.utilFtp.setPasswordParam(this.scripts.getScrPw());
            this.utilFtp.setPortParam(21);
            this.processObservation = this.utilFtp.sendFile(var5, var20.getName(), var21, 3);
            var20.delete();
         } else {
            this.processObservation = "Le chemin de destination n`est pas spécifié...";
         }
      } else {
         this.processObservation = "Backup non pris en charge";
      }

   }

   public void methode21(String var1, String var2, String var3, ProcessLauncher var4) throws IOException {
      String var5 = this.utilDate.dateToStringSQL(new Date());
      String[] var6 = var5.split(" ");
      String[] var7 = var6[1].split(":");
      String var8 = "";
      if (this.modeBakckup != 0) {
         if (this.modeBakckup == 1) {
            var8 = var3 + "_" + var6[0] + ".SQL.bz2";
         } else if (this.modeBakckup == 2) {
            var8 = var3 + "_" + var6[0] + "_" + var7[0] + ".SQL.bz2";
         } else if (this.modeBakckup == 3) {
            var8 = var3 + "_" + var6[0] + "_" + var7[0] + "-" + var7[1] + ".SQL.bz2";
         }

         String var9 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.scripts.getScrIdStructure() + File.separator + "backup" + File.separator + var8;
         String[] var10 = new String[]{var1, var2, "mysqldump -u" + this.dbUserName + " -p" + this.dbPassword + " --add-drop-database -B --opt -f " + var3 + " | bzip2 -cq9 >" + var9};
         this.processComplete = var4.exec(var10);
         if (this.processComplete == 0) {
            String var11 = File.separator + "clients" + File.separator + "structure" + this.scripts.getScrIdStructure() + File.separator + "backup" + File.separator;
            this.processObservation = this.utilFtp.sendFile(var9, var8, var11, 21);
         } else {
            this.processObservation = "Error DUMP " + this.processComplete;
         }
      } else {
         this.processObservation = "Backup non pris en charge";
      }

   }

   public void methode22() throws UnknownHostException, SocketException, IOException {
      String var1 = this.utilDate.dateToStringSQL(new Date());
      String[] var2 = var1.split(" ");
      String[] var3 = var2[1].split(":");
      String var4 = "";
      var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.scripts.getScrIdStructure();
      String var5 = "";
      if (this.modeBakckup != 0) {
         if (this.modeBakckup == 1) {
            var5 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.scripts.getScrIdStructure() + File.separator + "str" + "_" + this.scripts.getScrIdStructure() + "_" + var2[0] + ".ZIP";
         } else if (this.modeBakckup == 2) {
            var5 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.scripts.getScrIdStructure() + File.separator + "str" + "_" + this.scripts.getScrIdStructure() + "_" + var2[0] + "_" + var3[0] + "-" + var3[1] + ".ZIP";
         } else if (this.modeBakckup == 3) {
            var5 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.scripts.getScrIdStructure() + File.separator + "str" + "_" + this.scripts.getScrIdStructure() + "_" + var2[0] + "_" + var3[0] + "-" + var3[1] + "-" + var3[2] + ".ZIP";
         }

         short var6 = 2048;

         try {
            ArrayList var7 = new ArrayList();
            this.listeRepertoire(new File(var4), var7);
            BufferedInputStream var8 = null;
            FileOutputStream var9 = new FileOutputStream(var5);
            ZipOutputStream var10 = new ZipOutputStream(new BufferedOutputStream(var9));
            byte[] var11 = new byte[var6];

            for(int var12 = 0; var12 < var7.size(); ++var12) {
               int var13 = ((String)var7.get(var12)).toString().indexOf("structure" + this.scripts.getScrIdStructure());
               int var14 = ((String)var7.get(var12)).toString().length();
               String var15 = ((String)var7.get(var12)).toString().substring(var13, var14);
               FileInputStream var16 = new FileInputStream((String)var7.get(var12));
               var8 = new BufferedInputStream(var16, var6);
               if (var15.contains(".")) {
                  ZipEntry var17 = new ZipEntry(var15);
                  var10.putNextEntry(var17);

                  int var18;
                  while((var18 = var8.read(var11, 0, var6)) != -1) {
                     var10.write(var11, 0, var18);
                  }

                  var8.close();
               }
            }

            var10.close();
         } catch (Exception var19) {
            var19.printStackTrace();
         }

         File var20 = new File(var5);
         String var21 = File.separator + "clients" + File.separator + "structure" + this.scripts.getScrIdStructure() + File.separator + "backup" + File.separator;
         this.processObservation = this.utilFtp.sendFile(var5, var20.getName(), var21, 22);
         var20.delete();
      } else {
         this.processObservation = "Backup non pris en charge";
      }

   }

   public void methode23() throws UnknownHostException, SocketException, IOException {
      String var1 = this.utilDate.dateToStringSQL(new Date());
      String[] var2 = var1.split(" ");
      String[] var3 = var2[1].split(":");
      String var4 = "";
      var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.scripts.getScrIdStructure() + File.separator + "photos";
      String var5 = "";
      if (this.modeBakckup != 0) {
         if (this.modeBakckup == 1) {
            var5 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.scripts.getScrIdStructure() + File.separator + "ged" + "_" + this.scripts.getScrIdStructure() + "_" + var2[0] + ".ZIP";
         } else if (this.modeBakckup == 2) {
            var5 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.scripts.getScrIdStructure() + File.separator + "ged" + "_" + this.scripts.getScrIdStructure() + "_" + var2[0] + "_" + var3[0] + "-" + var3[1] + ".ZIP";
         } else if (this.modeBakckup == 3) {
            var5 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.scripts.getScrIdStructure() + File.separator + "ged" + "_" + this.scripts.getScrIdStructure() + "_" + var2[0] + "_" + var3[0] + "-" + var3[1] + "-" + var3[2] + ".ZIP";
         }

         short var6 = 2048;

         try {
            ArrayList var7 = new ArrayList();
            this.listeRepertoire(new File(var4), var7);
            BufferedInputStream var8 = null;
            FileOutputStream var9 = new FileOutputStream(var5);
            ZipOutputStream var10 = new ZipOutputStream(new BufferedOutputStream(var9));
            byte[] var11 = new byte[var6];

            for(int var12 = 0; var12 < var7.size(); ++var12) {
               int var13 = ((String)var7.get(var12)).toString().indexOf("structure" + this.scripts.getScrIdStructure());
               int var14 = ((String)var7.get(var12)).toString().length();
               String var15 = ((String)var7.get(var12)).toString().substring(var13, var14) + File.separator + "photos";
               FileInputStream var16 = new FileInputStream((String)var7.get(var12));
               var8 = new BufferedInputStream(var16, var6);
               if (var15.contains(".")) {
                  ZipEntry var17 = new ZipEntry(var15);
                  var10.putNextEntry(var17);

                  int var18;
                  while((var18 = var8.read(var11, 0, var6)) != -1) {
                     var10.write(var11, 0, var18);
                  }

                  var8.close();
               }
            }

            var10.close();
         } catch (Exception var19) {
            var19.printStackTrace();
         }

         File var20 = new File(var5);
         String var21 = File.separator + "clients" + File.separator + "structure" + this.scripts.getScrIdStructure() + File.separator + "backup" + File.separator;
         this.processObservation = this.utilFtp.sendFile(var5, var20.getName(), var21, 22);
         var20.delete();
      } else {
         this.processObservation = "Backup non pris en charge";
      }

   }

   public void methode99() {
      this.processObservation = "Cette méthode n`est pas encore définie...";
   }

   public void listeRepertoire(File var1, List var2) {
      if (var1.isDirectory()) {
         File[] var3 = var1.listFiles();
         if (var3 != null) {
            for(int var4 = 0; var4 < var3.length; ++var4) {
               this.listeRepertoire(var3[var4], var2);
            }
         }
      } else {
         String var5 = var1.getAbsolutePath();
         var2.add(var5);
      }

   }

   public void initImageStartup() {
      LireVersion var2 = new LireVersion();
      Version var1 = var2.lancer();
      this.listeImagesStartupDefaut = new ArrayList();
      this.listeImagesStartupSpecif = new ArrayList();
      this.fondDefaut = null;
      this.fondSpecifique = null;
      if (var1.getVersion_imageStartup() != null && !var1.getVersion_imageStartup().isEmpty()) {
         this.specifique = true;
      } else {
         this.specifique = false;
      }

      String var3 = "epegase" + File.separator + "web" + File.separator + "images" + File.separator + "startup" + File.separator;
      File var4 = new File(var3);
      String[] var5 = var4.list();
      int var6;
      if (var5 != null) {
         var5 = this.triAlphabetique(var5, var5.length);

         for(var6 = 0; var6 < var5.length; ++var6) {
            if (var5[var6].endsWith("png")) {
               if (var5[var6].equals("fondecran.jpg")) {
                  this.fondDefaut = "fondecran.jpg";
               } else {
                  this.listeImagesStartupDefaut.add(var5[var6].toString());
               }
            }
         }
      }

      var3 = "epegase" + File.separator + "web" + File.separator + "images" + File.separator + "startup" + this.structureLog.getStrid() + File.separator;
      var4 = new File(var3);
      if (var4.exists()) {
         var5 = var4.list();
         if (var5 != null) {
            var5 = this.triAlphabetique(var5, var5.length);

            for(var6 = 0; var6 < var5.length; ++var6) {
               if (var5[var6].endsWith("png")) {
                  if (var5[var6].equals("fondecran.jpg")) {
                     this.fondSpecifique = "fondecran.jpg";
                  } else {
                     this.listeImagesStartupSpecif.add(var5[var6].toString());
                  }
               }
            }
         }
      }

      this.dataModelImagesStartupDefaut = new ListDataModel();
      this.dataModelImagesStartupDefaut.setWrappedData(this.listeImagesStartupDefaut);
      this.dataModelImagesStartupSpecif = new ListDataModel();
      this.dataModelImagesStartupSpecif.setWrappedData(this.listeImagesStartupSpecif);
      this.afficheBoutons = false;
      this.imgeSelectionnee = "";
   }

   public void ajouterImage() {
      this.afficheBoutons = false;
      this.uploadedFile = null;
      this.showModalPanelAjoutFile = true;
   }

   public void supprimerImage() {
      if (this.imgeSelectionnee != null && !this.imgeSelectionnee.isEmpty()) {
         String var1 = "epegase" + File.separator + "web" + File.separator + "images" + File.separator + "startup" + this.structureLog.getStrid() + File.separator + this.imgeSelectionnee;
         File var2 = new File(var1);
         if (var2.exists()) {
            File var3 = new File(var1);
            var3.delete();
            this.listeImagesStartupSpecif.remove(this.imgeSelectionnee);
            this.dataModelImagesStartupSpecif.setWrappedData(this.listeImagesStartupSpecif);
            this.imgeSelectionnee = "";
         }
      }

      this.afficheBoutons = false;
   }

   public void selectionImage() {
      if (this.dataModelImagesStartupSpecif.isRowAvailable()) {
         this.imgeSelectionnee = (String)this.dataModelImagesStartupSpecif.getRowData();
         this.afficheBoutons = true;
      }

   }

   public void validerDocument() {
      try {
         if (this.uploadedFile != null) {
            String var1 = this.utilDownload.trimFilePath(this.uploadedFile.getName().trim());
            if (var1.toString().contains(".")) {
               var1 = "epegase_" + this.listeImagesStartupSpecif.size() + ".png";
               Object var2 = null;
               String var3 = "epegase" + File.separator + "web" + File.separator + "images" + File.separator + "startup" + this.structureLog.getStrid() + File.separator;
               File var4 = new File(var3);
               if (!var4.exists()) {
                  var4.mkdir();
               }

               new File(var3 + File.separator + var1);
               File var5 = this.utilDownload.uniqueFile(new File(var3 + File.separator), var1);
               this.utilDownload.write(var5, this.uploadedFile.getInputStream());
               this.listeImagesStartupSpecif.add(var1);
               this.dataModelImagesStartupSpecif.setWrappedData(this.listeImagesStartupSpecif);
            }
         }
      } catch (IOException var6) {
      }

      this.showModalPanelAjoutFile = false;
   }

   public void annulerDocument() {
      this.showModalPanelAjoutFile = false;
   }

   public void activerImage() throws FileNotFoundException, IOException {
      this.majVersion("startup" + this.structureLog.getStrid());
      this.specifique = true;
   }

   public void desactiverImage() throws FileNotFoundException, IOException {
      this.majVersion("");
      this.specifique = false;
   }

   public void majVersion(String var1) throws FileNotFoundException, IOException {
      new Version();
      LireVersion var3 = new LireVersion();
      Version var2 = var3.lancer();
      String var4 = var2.getVersion_internet();
      String var5 = var2.getVersion_os();
      String var6 = var2.getVersion_base();
      String var7 = var2.getVersion_serveur();
      String var9 = var2.getVersion_pageStartup();
      Element var10 = new Element("version");
      Document var11 = new Document(var10);
      var10.removeContent();
      Element var12 = new Element("numero");
      var10.addContent(var12);
      var12.setText(StaticModePegase.getVersion_distante());
      Element var13 = new Element("date");
      var10.addContent(var13);
      var13.setText(StaticModePegase.getDate_distante());
      Element var14 = new Element("internet");
      var10.addContent(var14);
      var14.setText(var4);
      Element var15 = new Element("os");
      var10.addContent(var15);
      var15.setText(var5);
      Element var16 = new Element("base");
      var10.addContent(var16);
      var16.setText(var6);
      Element var17 = new Element("serveur");
      var10.addContent(var17);
      var17.setText(var7);
      Element var18 = new Element("imageStartup");
      var10.addContent(var18);
      var18.setText(var1);
      Element var19 = new Element("pageAccueil");
      var10.addContent(var19);
      var19.setText(var9);
      XMLOutputter var20 = new XMLOutputter(Format.getPrettyFormat());
      var20.output(var11, new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "update" + File.separator + "version.xml"));
      if (var2.getVersion_imageStartup() != null && !var2.getVersion_imageStartup().isEmpty()) {
         this.specifique = true;
      } else {
         this.specifique = false;
      }

   }

   public void listener(UploadEvent var1) throws NamingException, HibernateException, ParseException {
      this.uploadData.size();
      this.item = var1.getUploadItem();
      this.fileCtrl = new FileCtrl();
      this.fileCtrl.setLength(this.item.getFileSize());
      this.fileCtrl.setName(this.item.getFileName());
      this.fileCtrl.setChemin(this.item.getFile().getPath().toString());
      this.fileCtrl.setData(this.item.getData());
      this.listFiles.add(this.fileCtrl);
      --this.uploadsAvailable;
      this.restauratioDump(this.fileCtrl, (File)this.uploadData);
   }

   public boolean restauratioDump(FileCtrl var1, File var2) {
      boolean var3 = true;
      return var3;
   }

   public void eteindreServeur() throws Exception {
      String var2 = System.getProperty("os.name");
      String var1;
      if (var2.startsWith("Windows")) {
         var1 = "shutdown.exe -s -t 0";
      } else {
         if (!var2.startsWith("Linux") && !var2.startsWith("Mac OS X")) {
            throw new RuntimeException("Impossible d'éteindre cet Ordinateur");
         }

         var1 = "shutdown -h now";
      }

      Runtime.getRuntime().exec(var1);
      System.exit(0);
   }

   public void rebootServeur() throws Exception {
      String var2 = System.getProperty("os.name");
      String var1;
      if (var2.startsWith("Windows")) {
         var1 = "shutdown.exe -r -t 0 -f";
      } else {
         if (!var2.startsWith("Linux") && !var2.startsWith("Mac OS X")) {
            throw new RuntimeException("Impossible de rebooter cet Ordinateur");
         }

         var1 = "reboot";
      }

      Runtime.getRuntime().exec(var1);
      System.exit(0);
   }

   public String getUrlHost() {
      return StaticModePegase.getUrlHost();
   }

   public String getUrlProtocole() {
      return StaticModePegase.getUrlProtocole();
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

   public UtilInitHibernate getUtilInitHibernate() {
      return this.utilInitHibernate;
   }

   public void setUtilInitHibernate(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
   }

   public DataModel getDatamodelBackup() {
      return this.datamodelBackup;
   }

   public void setDatamodelBackup(DataModel var1) {
      this.datamodelBackup = var1;
   }

   public boolean isSelectFile() {
      return this.selectFile;
   }

   public void setSelectFile(boolean var1) {
      this.selectFile = var1;
   }

   public String getFichierMine() {
      return this.fichierMine;
   }

   public void setFichierMine(String var1) {
      this.fichierMine = var1;
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

   public String getFichierCode() {
      return this.fichierCode;
   }

   public void setFichierCode(String var1) {
      this.fichierCode = var1;
   }

   public DataModel getDatamodelFichier() {
      return this.datamodelFichier;
   }

   public void setDatamodelFichier(DataModel var1) {
      this.datamodelFichier = var1;
   }

   public DataModel getDatamodelRepertoire() {
      return this.datamodelRepertoire;
   }

   public void setDatamodelRepertoire(DataModel var1) {
      this.datamodelRepertoire = var1;
   }

   public String getNomRepertoire() {
      return this.nomRepertoire;
   }

   public void setNomRepertoire(String var1) {
      this.nomRepertoire = var1;
   }

   public URL getRepertoireUrl() {
      return this.repertoireUrl;
   }

   public void setRepertoireUrl(URL var1) {
      this.repertoireUrl = var1;
   }

   public String getMemoRepertoire() {
      return this.memoRepertoire;
   }

   public void setMemoRepertoire(String var1) {
      this.memoRepertoire = var1;
   }

   public boolean isSelectRepertoire() {
      return this.selectRepertoire;
   }

   public void setSelectRepertoire(boolean var1) {
      this.selectRepertoire = var1;
   }

   public boolean isShowModalPanelAjoutFile() {
      return this.showModalPanelAjoutFile;
   }

   public void setShowModalPanelAjoutFile(boolean var1) {
      this.showModalPanelAjoutFile = var1;
   }

   public UploadedFile getUploadedFile() {
      return this.uploadedFile;
   }

   public void setUploadedFile(UploadedFile var1) {
      this.uploadedFile = var1;
   }

   public String getRepertoireString() {
      return this.repertoireString;
   }

   public void setRepertoireString(String var1) {
      this.repertoireString = var1;
   }

   public String getOngletActif() {
      return this.ongletActif;
   }

   public void setOngletActif(String var1) {
      this.ongletActif = var1;
   }

   public DataModel getDatamodelTable() {
      return this.datamodelTable;
   }

   public void setDatamodelTable(DataModel var1) {
      this.datamodelTable = var1;
   }

   public DataModel getDatamodelColonnes() {
      return this.datamodelColonnes;
   }

   public void setDatamodelColonnes(DataModel var1) {
      this.datamodelColonnes = var1;
   }

   public DataModel getDataModelScripts() {
      return this.dataModelScripts;
   }

   public void setDataModelScripts(DataModel var1) {
      this.dataModelScripts = var1;
   }

   public boolean isShowModalPanelScripts() {
      return this.showModalPanelScripts;
   }

   public void setShowModalPanelScripts(boolean var1) {
      this.showModalPanelScripts = var1;
   }

   public PegScripts getScripts() {
      return this.scripts;
   }

   public void setScripts(PegScripts var1) {
      this.scripts = var1;
   }

   public boolean isAfficheBoutons() {
      return this.afficheBoutons;
   }

   public void setAfficheBoutons(boolean var1) {
      this.afficheBoutons = var1;
   }

   public ObjetTable getObjetTable() {
      return this.objetTable;
   }

   public void setObjetTable(ObjetTable var1) {
      this.objetTable = var1;
   }

   public UtilFtp getUtilFtp() {
      return this.utilFtp;
   }

   public void setUtilFtp(UtilFtp var1) {
      this.utilFtp = var1;
   }

   public List getLesHeuresItems() {
      return this.lesHeuresItems;
   }

   public void setLesHeuresItems(List var1) {
      this.lesHeuresItems = var1;
   }

   public List getLesMinutesItems() {
      return this.lesMinutesItems;
   }

   public void setLesMinutesItems(List var1) {
      this.lesMinutesItems = var1;
   }

   public DataModel getDataModelBases() {
      return this.dataModelBases;
   }

   public void setDataModelBases(DataModel var1) {
      this.dataModelBases = var1;
   }

   public int getEtat() {
      return this.etat;
   }

   public void setEtat(int var1) {
      this.etat = var1;
   }

   public int getMode() {
      return this.mode;
   }

   public void setMode(int var1) {
      this.mode = var1;
   }

   public String getPays() {
      return this.pays;
   }

   public void setPays(String var1) {
      this.pays = var1;
   }

   public String getTitre() {
      return this.titre;
   }

   public void setTitre(String var1) {
      this.titre = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public DataModel getDataModelImagesStartupDefaut() {
      return this.dataModelImagesStartupDefaut;
   }

   public void setDataModelImagesStartupDefaut(DataModel var1) {
      this.dataModelImagesStartupDefaut = var1;
   }

   public DataModel getDataModelImagesStartupSpecif() {
      return this.dataModelImagesStartupSpecif;
   }

   public void setDataModelImagesStartupSpecif(DataModel var1) {
      this.dataModelImagesStartupSpecif = var1;
   }

   public String getFondDefaut() {
      return this.fondDefaut;
   }

   public void setFondDefaut(String var1) {
      this.fondDefaut = var1;
   }

   public String getFondSpecifique() {
      return this.fondSpecifique;
   }

   public void setFondSpecifique(String var1) {
      this.fondSpecifique = var1;
   }

   public boolean isSpecifique() {
      return this.specifique;
   }

   public void setSpecifique(boolean var1) {
      this.specifique = var1;
   }

   public DataModel getDatamodelSousDossier() {
      return this.datamodelSousDossier;
   }

   public void setDatamodelSousDossier(DataModel var1) {
      this.datamodelSousDossier = var1;
   }

   public boolean isSelectSousDossier() {
      return this.selectSousDossier;
   }

   public void setSelectSousDossier(boolean var1) {
      this.selectSousDossier = var1;
   }

   public int getUploadsAvailable() {
      return this.uploadsAvailable;
   }

   public void setUploadsAvailable(int var1) {
      this.uploadsAvailable = var1;
   }

   public ArrayList getListFiles() {
      return this.listFiles;
   }

   public void setListFiles(ArrayList var1) {
      this.listFiles = var1;
   }

   public List getUploadData() {
      return this.uploadData;
   }

   public void setUploadData(List var1) {
      this.uploadData = var1;
   }

   public List getMesStructuresItems() {
      return this.mesStructuresItems;
   }

   public void setMesStructuresItems(List var1) {
      this.mesStructuresItems = var1;
   }

   public boolean isAllBases() {
      return this.allBases;
   }

   public void setAllBases(boolean var1) {
      this.allBases = var1;
   }
}
