package com.epegase.systeme.menu;

import com.epegase.forms.accueil.FormEspaceClient;
import com.epegase.forms.administration.FormBackupDatas;
import com.epegase.forms.administration.FormUsers;
import com.epegase.forms.commun.FormDocumentsOfficiels;
import com.epegase.forms.commun.FormRecherche;
import com.epegase.forms.tiers.FormPatients;
import com.epegase.systeme.classe.ConsultationEnteteGene;
import com.epegase.systeme.classe.Devise;
import com.epegase.systeme.classe.Groupe;
import com.epegase.systeme.classe.HospitalisationEntete;
import com.epegase.systeme.classe.LaboratoireEntete;
import com.epegase.systeme.classe.Patients;
import com.epegase.systeme.classe.PegScripts;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.StructurePeg;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.ObjetGraph;
import com.epegase.systeme.dao.DeviseDao;
import com.epegase.systeme.dao.GroupeDao;
import com.epegase.systeme.dao.HospitalisationEnteteDao;
import com.epegase.systeme.dao.PegScriptsDao;
import com.epegase.systeme.dao.StructureDao;
import com.epegase.systeme.dao.TachesDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.formbakingbeans.FormBakingBeanAccueil;
import com.epegase.systeme.formbakingbeans.FormBakingBeanAchats;
import com.epegase.systeme.formbakingbeans.FormBakingBeanAdministration;
import com.epegase.systeme.formbakingbeans.FormBakingBeanCaisse;
import com.epegase.systeme.formbakingbeans.FormBakingBeanComptabilite;
import com.epegase.systeme.formbakingbeans.FormBakingBeanEducation;
import com.epegase.systeme.formbakingbeans.FormBakingBeanFondation;
import com.epegase.systeme.formbakingbeans.FormBakingBeanForet;
import com.epegase.systeme.formbakingbeans.FormBakingBeanImmobilier;
import com.epegase.systeme.formbakingbeans.FormBakingBeanMedical;
import com.epegase.systeme.formbakingbeans.FormBakingBeanMicroFinance;
import com.epegase.systeme.formbakingbeans.FormBakingBeanOffice;
import com.epegase.systeme.formbakingbeans.FormBakingBeanParcs;
import com.epegase.systeme.formbakingbeans.FormBakingBeanPartiPolitique;
import com.epegase.systeme.formbakingbeans.FormBakingBeanPaye;
import com.epegase.systeme.formbakingbeans.FormBakingBeanReporting;
import com.epegase.systeme.formbakingbeans.FormBakingBeanSysteme;
import com.epegase.systeme.formbakingbeans.FormBakingBeanTemple;
import com.epegase.systeme.formbakingbeans.FormBakingBeanTiers;
import com.epegase.systeme.formbakingbeans.FormBakingBeanVentes;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.LectureMessageVocalCommun;
import com.epegase.systeme.xml.LectureMessageVocalUser;
import com.epegase.systeme.xml.LireLesoptionsGroupe;
import com.epegase.systeme.xml.LireVersion;
import com.epegase.systeme.xml.ObjetLigneMenu;
import com.epegase.systeme.xml.ObjetMessageVocalCommun;
import com.epegase.systeme.xml.ObjetMessageVocalUser;
import com.epegase.systeme.xml.OptionGroupe;
import com.epegase.systeme.xml.Version;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import net.sf.jasperreports.engine.JRException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlExtendedDataTable;
import org.richfaces.json.JSONException;
import org.richfaces.model.selection.SimpleSelection;
import org.springframework.context.annotation.Scope;
import org.xml.sax.SAXException;

@Scope("session")
public class MenuModuleHorizontalCtrl implements Serializable {
   private String urlDocument;
   private int typePlateForme;
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private StructureDao structureDao;
   private transient DataModel dataModelMenuHorizontal;
   private MenuModule menuModule;
   private List menuListe;
   private String moduleAffiche;
   private String moduleFree;
   private String moduleCompta;
   private String moduleCommercial;
   private boolean var_aff_maj = false;
   private boolean var_aff_copie = false;
   private Date detadujour = new Date();
   private String detajour;
   private String dteJ;
   private boolean var_invisible;
   private List mesHeuresGlobalItems;
   private List mesMinutesGlobalItems;
   private String var_lib_base;
   private List mesCollaborateurItems;
   private List mesTachesItems;
   private boolean rw = false;
   private int typeVente;
   private String var_type_os_serveur_local = System.getProperty("os.name") + " " + System.getProperty("os.version");
   private String choixServeur;
   private boolean showMoalPanelExit = false;
   private boolean var_affiche_liste_societe = false;
   private boolean showModalPanelSelectionSociete = false;
   private transient DataModel dataModelSociete;
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private StructurePeg structurePeg;
   private String var_nom_master;
   private long var_id_master;
   private boolean strSelec = false;
   private FormBakingBeanSysteme formBakingBeanSysteme;
   private FormBakingBeanAdministration formBakingBeanAdministration;
   private FormBakingBeanAccueil formBakingBeanAccueil;
   private FormBakingBeanTiers formBakingBeanTiers;
   private FormBakingBeanMedical formBakingBeanMedical;
   private FormBakingBeanAchats formBakingBeanAchats;
   private FormBakingBeanVentes formBakingBeanVentes;
   private FormBakingBeanImmobilier formBakingBeanImmobilier;
   private FormBakingBeanMicroFinance formBakingBeanMicroFinance;
   private FormBakingBeanComptabilite formBakingBeanComptabilite;
   private FormBakingBeanParcs formBakingBeanParcs;
   private FormBakingBeanCaisse formBakingBeanCaisse;
   private FormBakingBeanPaye formBakingBeanPaye;
   private FormBakingBeanEducation formBakingBeanEducation;
   private FormBakingBeanForet formBakingBeanForet;
   private FormBakingBeanOffice formBakingBeanOffice;
   private FormBakingBeanFondation formBakingBeanFondation;
   private FormBakingBeanReporting formBakingBeanReporting;
   private FormRecherche formRecherche;
   private FormPatients formPatients;
   private FormDocumentsOfficiels formDocumentsOfficiels;
   private FormEspaceClient formEspaceClient;
   private FormBakingBeanTemple formBakingBeanTemple;
   private FormBakingBeanPartiPolitique formBakingBeanPartiPolitique;
   private int var_societe_cabinet;
   private List listeSocieteCabinet;
   private String var_memo_nom_master;
   private long var_memo_id_master;
   private long var_memo_id_user;
   private boolean affiche_nom = false;
   private String affichePage;
   private boolean controlePanLeft = true;
   private boolean startupSpecial = true;
   private MenudroitFreeCtrl menudroitFreeCtrl;
   private UtilPrint utilPrint;
   private boolean affMail = false;
   private boolean affListeDoc = false;
   private String format;
   private String impEmetteur;
   private String impDestinataire;
   private String impDestinataireCC;
   private String impDestinataireCCI;
   private String impCorpsMail;
   private int var_choix_modele;
   private int var_choix_periode;
   private int var_choix_poids;
   private String nomModeleDocument;
   private String nomModeleListe;
   private String avenantListe;
   private List documentImpressionItems;
   private List listeImpressionItems;
   private List avenantImpressionItems;
   private int nature;
   private long strImpFactGlobale;
   private boolean message_affiche;
   private String message_texte;
   private int var_currentValue = 0;
   private boolean var_showBarProgMaj = false;
   private String texteTitre;
   private String texteSousTitre;
   private String unite;
   private List lesSeries = new ArrayList();
   private int nbDec;
   private String devise;
   private float tauxDevise;
   private String listeDatas;
   private String listeDatasCamembert;
   private String timeDecoupage;
   private List lesDevisesItems;
   private List lesScripts;
   private FormBackupDatas formBackupDatas;
   private Calendar calendar = new GregorianCalendar();
   private DateFormatSymbols symbols = new DateFormatSymbols();
   private List lesBasesCopies;
   private String basesCopies;
   private boolean baseVerrou = false;
   private String message_vocal;
   private List lesMessagesVocauxCommun = new ArrayList();
   private List lesMessagesVocauxUser = new ArrayList();
   private LectureMessageVocalUser lectureMessageVocalUser = new LectureMessageVocalUser();
   private boolean messageScan = false;
   private ObjetMessageVocalCommun objetMessageVocalCommun = new ObjetMessageVocalCommun();
   private String dateExecution;
   private UtilDate utilDate = new UtilDate();
   private boolean showModalPanelHelpDesk = false;

   public MenuModuleHorizontalCtrl() throws IOException, JDOMException, SAXException, SQLException {
   }

   public void collaborateursItems(Session var1) throws HibernateException, NamingException {
      this.mesCollaborateurItems = new ArrayList();
      UserDao var2 = new UserDao(this.baseLog, this.utilInitHibernate);
      this.mesCollaborateurItems = var2.chargerLesUsersItem(var1);
   }

   public void tachesItems(Session var1) throws HibernateException, NamingException {
      this.mesTachesItems = new ArrayList();
      TachesDao var2 = new TachesDao(this.baseLog, this.utilInitHibernate);
      this.mesTachesItems = var2.selectTachesActifItem(var1);
   }

   public void calculHeures() {
      this.mesHeuresGlobalItems = new ArrayList();
      if (this.structureLog.getStrHrDeb() == null || this.structureLog.getStrHrDeb().isEmpty()) {
         this.structureLog.setStrHrDeb("00");
      }

      int var1 = Integer.parseInt(this.structureLog.getStrHrDeb());
      if (this.structureLog.getStrHrFin() == null || this.structureLog.getStrHrFin().isEmpty()) {
         this.structureLog.setStrHrFin("23");
      }

      int var2 = Integer.parseInt(this.structureLog.getStrHrFin());
      if (var2 == 0) {
         var2 = 23;
      }

      int var3;
      for(var3 = var1; var3 <= var2; ++var3) {
         if (var3 <= 9) {
            this.mesHeuresGlobalItems.add(new SelectItem("0" + var3));
         } else {
            this.mesHeuresGlobalItems.add(new SelectItem(var3));
         }
      }

      this.mesMinutesGlobalItems = new ArrayList();
      if (this.structureLog.getStrMnPas() == null || this.structureLog.getStrMnPas().isEmpty()) {
         this.structureLog.setStrMnPas("0");
      }

      var3 = Integer.parseInt(this.structureLog.getStrMnPas());
      if (var3 == 0) {
         var3 = 1;
      }

      for(int var4 = 0; var4 <= 59; var4 += var3) {
         if (var4 <= 9) {
            this.mesMinutesGlobalItems.add(new SelectItem("0" + var4));
         } else {
            this.mesMinutesGlobalItems.add(new SelectItem(var4));
         }
      }

   }

   public void fermePanelGauche() {
      this.controlePanLeft = false;
   }

   public void ouvrePanelGauche() {
      this.controlePanLeft = true;
   }

   public void fermerMessage() {
      this.message_affiche = false;
      StaticModePegase.setAffiche_message(false);
   }

   public void razMemoire(String var1) {
      if (var1 != null && !var1.isEmpty()) {
         if (!var1.equals("formBakingBeanAchats")) {
            this.formBakingBeanAchats = null;
         }

         if (!var1.equals("formBakingBeanAdministration")) {
            this.formBakingBeanAdministration = null;
         }

         if (!var1.equals("formBakingBeanCaisse")) {
            this.formBakingBeanCaisse = null;
         }

         if (!var1.equals("formBakingBeanComptabilite")) {
            this.formBakingBeanComptabilite = null;
         }

         if (!var1.equals("formBakingBeanEducation")) {
            this.formBakingBeanEducation = null;
         }

         if (!var1.equals("formBakingBeanFondation")) {
            this.formBakingBeanFondation = null;
         }

         if (!var1.equals("formBakingBeanForet")) {
            this.formBakingBeanForet = null;
         }

         if (!var1.equals("formBakingBeanImmobilier")) {
            this.formBakingBeanImmobilier = null;
         }

         if (!var1.equals("formBakingBeanMedical")) {
            this.formBakingBeanMedical = null;
         }

         if (!var1.equals("formBakingBeanMicroFinance")) {
            this.formBakingBeanMicroFinance = null;
         }

         if (!var1.equals("formBakingBeanOffice")) {
            this.formBakingBeanOffice = null;
         }

         if (!var1.equals("formBakingBeanParcs")) {
            this.formBakingBeanParcs = null;
         }

         if (!var1.equals("formBakingBeanPartiPolitique")) {
            this.formBakingBeanPartiPolitique = null;
         }

         if (!var1.equals("formBakingBeanPaye")) {
            this.formBakingBeanPaye = null;
         }

         if (!var1.equals("formBakingBeanSysteme")) {
            this.formBakingBeanSysteme = null;
         }

         if (!var1.equals("formBakingBeanTiers") && !var1.equals("formBakingBeanMedical")) {
            this.formBakingBeanTiers = null;
         }

         if (!var1.equals("formBakingBeanTemple")) {
            this.formBakingBeanTemple = null;
         }

         if (!var1.equals("formBakingBeanVentes")) {
            this.formBakingBeanVentes = null;
         }

         if (!var1.equals("formBakingBeanReporting")) {
            this.formBakingBeanReporting = null;
         }

         if (!var1.equals("formRecherche")) {
            this.formRecherche = null;
         }

         if (!var1.equals("formDocumentsOfficiels")) {
            this.formDocumentsOfficiels = null;
         }

         if (!var1.equals("formEspaceClient")) {
            this.formEspaceClient = null;
         }

         if (!var1.equals("utilDate")) {
            this.utilDate = null;
         }

         if (!var1.equals("utilPrint")) {
            this.utilPrint = null;
         }
      } else {
         this.formBakingBeanAccueil = null;
         this.formBakingBeanAchats = null;
         this.formBakingBeanAdministration = null;
         this.formBakingBeanCaisse = null;
         this.formBakingBeanComptabilite = null;
         this.formBakingBeanEducation = null;
         this.formBakingBeanFondation = null;
         this.formBakingBeanForet = null;
         this.formBakingBeanImmobilier = null;
         this.formBakingBeanMedical = null;
         this.formBakingBeanMicroFinance = null;
         this.formBakingBeanOffice = null;
         this.formBakingBeanParcs = null;
         this.formBakingBeanPartiPolitique = null;
         this.formBakingBeanPaye = null;
         this.formBakingBeanReporting = null;
         this.formBakingBeanSysteme = null;
         this.formBakingBeanTemple = null;
         this.formBakingBeanTiers = null;
         this.formBakingBeanVentes = null;
         this.formRecherche = null;
         this.formPatients = null;
         this.formDocumentsOfficiels = null;
         this.formEspaceClient = null;
         this.utilDate = null;
         this.utilPrint = null;
      }

   }

   public void exit() {
      this.showMoalPanelExit = true;
   }

   public void annulerExit() {
      this.showMoalPanelExit = false;
   }

   public void chargerListeMessage() {
      LectureMessageVocalCommun var1 = new LectureMessageVocalCommun();
      this.lesMessagesVocauxCommun.clear();
      this.lesMessagesVocauxCommun = var1.getLesMessagesVaocauxComun();
   }

   public void messageVocal() throws IOException, JDOMException {
      this.message_vocal = "";
      if (StaticModePegase.getInternet_actif() != 0 && this.usersLog.getUsrAssistant() != 0) {
         int var1 = (new Date()).getHours();
         String var2 = "";
         if ((new Date()).getHours() <= 9) {
            var2 = "0" + (new Date()).getHours();
         } else {
            var2 = "" + (new Date()).getHours();
         }

         if ((new Date()).getMinutes() <= 9) {
            var2 = var2 + ":0" + (new Date()).getMinutes();
         } else {
            var2 = var2 + ":" + (new Date()).getMinutes();
         }

         String var3 = "";
         String var4 = "";
         this.lesMessagesVocauxUser.clear();
         this.lesMessagesVocauxUser = this.lectureMessageVocalUser.recupererMessageVocalUser(this.structureLog.getStrid(), this.usersLog.getUsrid(), this.dteJ);
         if (this.lesMessagesVocauxUser == null) {
            this.lesMessagesVocauxUser = new ArrayList();
         }

         if (this.lesMessagesVocauxCommun.size() != 0) {
            for(int var5 = 0; var5 < this.lesMessagesVocauxCommun.size(); ++var5) {
               this.objetMessageVocalCommun = (ObjetMessageVocalCommun)this.lesMessagesVocauxCommun.get(var5);
               if (var1 >= this.objetMessageVocalCommun.getHeureDebut() && var1 <= this.objetMessageVocalCommun.getHeureFin() && this.objetMessageVocalCommun.getCondit1() != null && !this.objetMessageVocalCommun.getCondit1().isEmpty() && this.objetMessageVocalCommun.getCondit1().equals("Accueil")) {
                  var3 = "Accueil";
                  if (!this.chercheUnicite(this.objetMessageVocalCommun, var3)) {
                     this.message_vocal = this.calculeTexte(this.objetMessageVocalCommun.getMessage());
                     break;
                  }
               } else if (var1 >= this.objetMessageVocalCommun.getHeureDebut() && var1 <= this.objetMessageVocalCommun.getHeureFin() && this.objetMessageVocalCommun.getCondit1() != null && !this.objetMessageVocalCommun.getCondit1().isEmpty() && this.objetMessageVocalCommun.getCondit1().equals("Accueil")) {
                  var3 = "Accueil";
                  if (!this.chercheUnicite(this.objetMessageVocalCommun, var3)) {
                     this.message_vocal = this.calculeTexte(this.objetMessageVocalCommun.getMessage());
                     break;
                  }
               } else if (var1 >= this.objetMessageVocalCommun.getHeureDebut() && var1 <= this.objetMessageVocalCommun.getHeureFin() && this.objetMessageVocalCommun.getCondit1() != null && !this.objetMessageVocalCommun.getCondit1().isEmpty() && this.objetMessageVocalCommun.getCondit1().equals("Repas")) {
                  var3 = "Repas";
                  if (!this.chercheUnicite(this.objetMessageVocalCommun, var3)) {
                     this.message_vocal = this.calculeTexte(this.objetMessageVocalCommun.getMessage());
                     break;
                  }
               } else if (var1 >= this.objetMessageVocalCommun.getHeureDebut() && var1 <= this.objetMessageVocalCommun.getHeureFin() && this.objetMessageVocalCommun.getCondit1() != null && !this.objetMessageVocalCommun.getCondit1().isEmpty() && this.objetMessageVocalCommun.getCondit1().equals("Goutter")) {
                  var3 = "Goutter";
                  if (!this.chercheUnicite(this.objetMessageVocalCommun, var3)) {
                     this.message_vocal = this.calculeTexte(this.objetMessageVocalCommun.getMessage());
                     break;
                  }
               } else if (var1 >= this.objetMessageVocalCommun.getHeureDebut() && var1 <= this.objetMessageVocalCommun.getHeureFin() && this.objetMessageVocalCommun.getCondit1() != null && !this.objetMessageVocalCommun.getCondit1().isEmpty() && this.objetMessageVocalCommun.getCondit1().equals("FinTravail")) {
                  var3 = "FinTravail";
                  if (!this.chercheUnicite(this.objetMessageVocalCommun, var3)) {
                     this.message_vocal = this.calculeTexte(this.objetMessageVocalCommun.getMessage());
                     break;
                  }
               }
            }
         }

         if (this.message_vocal != null && !this.message_vocal.isEmpty()) {
            String var6 = "" + var1;
            this.lectureMessageVocalUser.ecritureMessageUser(this.structureLog.getStrid(), this.usersLog.getUsrid(), var3, var4, this.dteJ, var6, var2, this.message_vocal, this.lesMessagesVocauxUser);
         } else if (!this.messageScan) {
            this.lectureMessageAccueil();
         }
      }

   }

   public void scanMessage() throws IOException, JDOMException {
      if (this.usersLog != null) {
         this.messageScan = true;
         this.messageVocal();
      }

   }

   public void lectureDernierMessage() {
      this.message_vocal = "";
      if (this.lesMessagesVocauxUser.size() != 0) {
         int var1 = this.lesMessagesVocauxUser.size() - 1;
         this.message_vocal = ((ObjetMessageVocalUser)this.lesMessagesVocauxUser.get(var1)).getMessage();
      }

   }

   public void lectureMessageAccueil() {
      this.message_vocal = "";
      if (this.lesMessagesVocauxUser.size() != 0) {
         for(int var1 = 0; var1 < this.lesMessagesVocauxUser.size(); ++var1) {
            if (((ObjetMessageVocalUser)this.lesMessagesVocauxUser.get(var1)).getCondit1().equals("Accueil")) {
               this.message_vocal = ((ObjetMessageVocalUser)this.lesMessagesVocauxUser.get(var1)).getMessage();
            }
         }
      }

   }

   public boolean chercheUnicite(ObjetMessageVocalCommun var1, String var2) {
      boolean var3 = false;
      if (this.lesMessagesVocauxUser.size() != 0) {
         for(int var4 = 0; var4 < this.lesMessagesVocauxUser.size(); ++var4) {
            if (((ObjetMessageVocalUser)this.lesMessagesVocauxUser.get(var4)).getCondit1() != null && !((ObjetMessageVocalUser)this.lesMessagesVocauxUser.get(var4)).getCondit1().isEmpty() && ((ObjetMessageVocalUser)this.lesMessagesVocauxUser.get(var4)).getCondit1().equals(var2)) {
               boolean var5 = false;
               int var6;
               if (((ObjetMessageVocalUser)this.lesMessagesVocauxUser.get(var4)).getHeure() != null && !((ObjetMessageVocalUser)this.lesMessagesVocauxUser.get(var4)).getHeure().isEmpty()) {
                  var6 = Integer.parseInt(((ObjetMessageVocalUser)this.lesMessagesVocauxUser.get(var4)).getHeure());
               } else {
                  var6 = (new Date()).getHours();
               }

               if (var6 >= var1.getHeureDebut() && var6 <= var1.getHeureFin()) {
                  var3 = true;
               }
            }
         }
      }

      return var3;
   }

   public String calculeTexte(String var1) {
      String var2 = var1;

      while(true) {
         while(true) {
            while(var2.contains("[")) {
               int var3 = 0;
               int var4 = 0;

               for(int var5 = 0; var5 < var2.length(); ++var5) {
                  if (var2.substring(var5, var5 + 1).equals("[")) {
                     var3 = var5 + 1;
                  }

                  if (var2.substring(var5, var5 + 1).equals("]")) {
                     var4 = var5;
                     break;
                  }
               }

               String var8 = var2.substring(var3, var4);
               String var6 = "[" + var8 + "]";
               String var7 = "";
               if (var8 != null && !var8.isEmpty()) {
                  if (var8.contains("usr_")) {
                     var7 = this.usersLog.getUsrPrenom();
                  } else if (var8.contains("dte_")) {
                     var7 = this.detajour;
                  } else if (var8.contains("rdv_jour")) {
                     if (this.formBakingBeanAccueil != null && this.formBakingBeanAccueil.getFormAccueil().getDatamodelRdv().getRowCount() != 0) {
                        var7 = "Vous avez " + this.formBakingBeanAccueil.getFormAccueil().getDatamodelRdv().getRowCount() + " rendez-vous.";
                     } else {
                        var7 = "";
                     }
                  } else if (var8.contains("rdv_todo")) {
                     if (this.formBakingBeanAccueil != null && this.formBakingBeanAccueil.getFormAccueil().getDatamodelTdo().getRowCount() != 0) {
                        var7 = "Vous avez " + this.formBakingBeanAccueil.getFormAccueil().getDatamodelTdo().getRowCount() + " toudou en attente.";
                     } else {
                        var7 = "";
                     }
                  } else if (var8.contains("rdv_reste")) {
                     if (this.formBakingBeanAccueil != null && this.formBakingBeanAccueil.getFormAccueil().getDatamodelRdv().getRowCount() != 0) {
                        var7 = "Il vous reste " + this.formBakingBeanAccueil.getFormAccueil().getDatamodelRdv().getRowCount() + " rendez-vous non traités.";
                     } else {
                        var7 = "";
                     }
                  } else if (var8.contains("rdv_alerte")) {
                     if (this.formBakingBeanAccueil != null && this.formBakingBeanAccueil.getFormAccueil().getDatamodelRdv().getRowCount() != 0) {
                        var7 = "Attention, vous avez " + this.formBakingBeanAccueil.getFormAccueil().getDatamodelAnniv().getRowCount() + " alertes.";
                     } else {
                        var7 = "";
                     }
                  }

                  if (var7 != null && !var7.isEmpty() && !var7.equals("null")) {
                     var2 = var2.replace(var6, var7);
                  } else {
                     var2 = var2.replace(var6, "");
                  }
               } else {
                  var2 = var2.replace(var6, "");
               }
            }

            return var2;
         }
      }
   }

   public void scanScript() throws ParseException {
      if (this.lesScripts.size() != 0) {
         this.utilDate = new UtilDate();
         new PegScripts();
         PegScripts var1;
         if ((new Date()).getHours() == 23 && ((new Date()).getMinutes() >= 50 || (new Date()).getMinutes() <= 59)) {
            for(int var2 = 0; var2 < this.lesScripts.size(); ++var2) {
               var1 = (PegScripts)this.lesScripts.get(var2);
               var1.setDateExecution((String)null);
               var1.setExecutee(false);
            }
         }

         boolean var13 = false;
         String var3 = "";
         if ((new Date()).getHours() <= 9) {
            var3 = "0" + (new Date()).getHours();
         } else {
            var3 = "" + (new Date()).getHours();
         }

         boolean var4 = false;
         int var14 = (new Date()).getMinutes();
         this.calendar = new GregorianCalendar();
         int var5 = this.calendar.get(7);
         String var6 = this.symbols.getShortWeekdays()[var5];

         for(int var7 = 0; var7 < this.lesScripts.size(); ++var7) {
            var1 = (PegScripts)this.lesScripts.get(var7);
            boolean var8 = false;
            if (var1.getScrDateDebut() != null && var1.getScrDateFin() != null) {
               Date var9 = this.utilDate.dateToSQLLight(new Date());
               Date var10 = this.utilDate.dateToSQLLight(var1.getScrDateDebut());
               Date var11 = this.utilDate.dateToSQLLight(var1.getScrDateFin());
               if ((var10.after(var9) || var10.equals(var9)) && (var11.before(var9) || var11.equals(var9))) {
                  var8 = true;
               }
            } else {
               var8 = true;
            }

            if (!var1.isExecutee() && var8) {
               int var15;
               int var16;
               if (var1.isScrLundi() && var6.equalsIgnoreCase("lun.")) {
                  if (var1.getScrHeureLundi().equals(var3)) {
                     var15 = Integer.parseInt(var1.getScrMinuteLundi());
                     var16 = Integer.parseInt(var1.getScrMinuteLundi()) + 15;
                     if (var14 >= var15 && var14 < var16) {
                        var13 = true;
                     }
                  }
               } else if (var1.isScrMardi() && var6.equalsIgnoreCase("mar.")) {
                  if (var1.getScrHeureMardi().equals(var3)) {
                     var15 = Integer.parseInt(var1.getScrMinuteMardi());
                     var16 = Integer.parseInt(var1.getScrMinuteMardi()) + 15;
                     if (var14 >= var15 && var14 < var16) {
                        var13 = true;
                     }
                  }
               } else if (var1.isScrMercredi() && var6.equalsIgnoreCase("mer.")) {
                  if (var1.getScrHeureMercredi().equals(var3)) {
                     var15 = Integer.parseInt(var1.getScrMinuteMercredi());
                     var16 = Integer.parseInt(var1.getScrMinuteMercredi()) + 15;
                     if (var14 >= var15 && var14 < var16) {
                        var13 = true;
                     }
                  }
               } else if (var1.isScrJeudi() && var6.equalsIgnoreCase("jeu.")) {
                  if (var1.getScrHeureJeudi().equals(var3)) {
                     var15 = Integer.parseInt(var1.getScrMinuteJeudi());
                     var16 = Integer.parseInt(var1.getScrMinuteJeudi()) + 15;
                     if (var14 >= var15 && var14 < var16) {
                        var13 = true;
                     }
                  }
               } else if (var1.isScrVendredi() && var6.equalsIgnoreCase("ven.")) {
                  if (var1.getScrHeureVendredi().equals(var3)) {
                     var15 = Integer.parseInt(var1.getScrMinuteVendredi());
                     var16 = Integer.parseInt(var1.getScrMinuteVendredi()) + 15;
                     if (var14 >= var15 && var14 < var16) {
                        var13 = true;
                     }
                  }
               } else if (var1.isScrSamedi() && var6.equalsIgnoreCase("sam.")) {
                  if (var1.getScrHeureSamedi().equals(var3)) {
                     var15 = Integer.parseInt(var1.getScrMinuteSamedi());
                     var16 = Integer.parseInt(var1.getScrMinuteSamedi()) + 15;
                     if (var14 >= var15 && var14 < var16) {
                        var13 = true;
                     }
                  }
               } else if (var1.isScrDimanche() && var6.equalsIgnoreCase("dim.") && var1.getScrHeureDimanche().equals(var3)) {
                  var15 = Integer.parseInt(var1.getScrMinuteDimanche());
                  var16 = Integer.parseInt(var1.getScrMinuteDimanche()) + 15;
                  if (var14 >= var15 && var14 < var16) {
                     var13 = true;
                  }
               }

               if (var13) {
                  this.dateExecution = this.utilDate.dateToStringSQLLight(new Date());
                  var1.setExecutee(true);
                  var1.setDateExecution(this.utilDate.dateToStringSQLLight(new Date()));

                  try {
                     this.formBackupDatas.setScripts(var1);
                     this.formBackupDatas.executerScripts();
                  } catch (Exception var12) {
                     Logger.getLogger(FormBackupDatas.class.getName()).log(Level.SEVERE, (String)null, var12);
                  }
               }
            }
         }
      }

   }

   public void recupererModule(Session var1) throws IOException, SAXException, JDOMException, HibernateException, NamingException {
      this.moduleAffiche = "";
      this.moduleFree = "";
      this.moduleCommercial = "";
      this.moduleCompta = "";
      if (!StaticModePegase.getAccesBase().contains("192.") && !StaticModePegase.getAccesBase().contains("127.") && !StaticModePegase.getAccesBase().contains("10.")) {
         if (StaticModePegase.getAccesBase().contains("localhost:")) {
            this.var_lib_base = "(Base Locale)";
         } else {
            this.var_lib_base = "(Base On-line)";
         }
      } else {
         this.var_lib_base = "(Base Distante)";
      }

      if (StaticModePegase.isLocalApplication()) {
         this.rw = true;
         this.var_lib_base = this.var_lib_base + " (rw on)";
      } else if (this.structureLog.getStrmode() == 0) {
         this.rw = true;
         this.var_lib_base = this.var_lib_base + " (rw on)";
      } else if (this.structureLog.getStrmode() == 1) {
         this.rw = false;
         this.var_lib_base = this.var_lib_base + " (rw off)";
      } else if (this.structureLog.getStrmode() == 2) {
         this.rw = false;
         this.var_lib_base = this.var_lib_base + " (rw off)";
      } else if (this.structureLog.getStrmode() == 3) {
         this.rw = false;
         this.var_lib_base = this.var_lib_base + " (rw off)";
      }

      this.listeSocieteCabinet = new ArrayList();
      this.dataModelSociete = new ListDataModel();
      if (this.var_id_master == 0L) {
         this.var_id_master = 0L;
         this.var_nom_master = "";
         this.affiche_nom = false;
         if (this.structureLog != null && this.structureLog.getStrmaitrecabinet() != 0) {
            this.dataModelSociete.setWrappedData(this.listeSocieteCabinet);
            this.var_affiche_liste_societe = true;
         } else {
            this.var_affiche_liste_societe = false;
         }
      } else {
         this.var_affiche_liste_societe = true;
      }

      if (this.var_affiche_liste_societe) {
         if (this.structureLog.getStrmaitrecabinet() == 1) {
            this.var_lib_base = this.var_lib_base + " (Version Cabinet)";
         } else if (this.structureLog.getStrmaitrecabinet() == 2) {
            this.var_lib_base = this.var_lib_base + " (Version Groupe)";
         } else if (this.structureLog.getStrmaitrecabinet() == 3) {
            this.var_lib_base = this.var_lib_base + " (Version Franchise)";
         } else if (this.structureLog.getStrmaitrecabinet() == 4) {
            this.var_lib_base = this.var_lib_base + " (Version Formation)";
         } else if (this.structureLog.getStrmaitrecabinet() == 5) {
            this.var_lib_base = this.var_lib_base + " (Version Distributeur)";
         }
      }

      this.calculeModuleVente();
      if (this.typeVente != 0) {
         if (this.typeVente == 801) {
            this.var_lib_base = this.var_lib_base + " (V.ST)";
         } else if (this.typeVente == 802) {
            this.var_lib_base = this.var_lib_base + " (V.CPT)";
         } else if (this.typeVente == 803) {
            this.var_lib_base = this.var_lib_base + " (FOND.)";
         } else if (this.typeVente == 804) {
            this.var_lib_base = this.var_lib_base + " (INTERIM)";
         } else if (this.typeVente == 805) {
            this.var_lib_base = this.var_lib_base + " (CABINET)";
         } else if (this.typeVente == 806) {
            this.var_lib_base = this.var_lib_base + " (TRANSPORT)";
         } else if (this.typeVente == 807) {
            this.var_lib_base = this.var_lib_base + " (M.F.)";
         } else if (this.typeVente == 808) {
            this.var_lib_base = this.var_lib_base + " (MONET.)";
         } else if (this.typeVente == 809) {
            this.var_lib_base = this.var_lib_base + " (EDUC.)";
         } else if (this.typeVente == 810) {
            this.var_lib_base = this.var_lib_base + " (ABN)";
         } else if (this.typeVente == 811) {
            this.var_lib_base = this.var_lib_base + " (PECH.)";
         } else if (this.typeVente == 812) {
            this.var_lib_base = this.var_lib_base + " (TMPL.)";
         } else if (this.typeVente == 813) {
            this.var_lib_base = this.var_lib_base + " (P.B.)";
         } else if (this.typeVente == 814) {
            this.var_lib_base = this.var_lib_base + " (FORET)";
         } else if (this.typeVente == 815) {
            this.var_lib_base = this.var_lib_base + " (MEDICAL)";
         } else if (this.typeVente == 816) {
            this.var_lib_base = this.var_lib_base + " (IMMOB.)";
         } else if (this.typeVente == 817) {
            this.var_lib_base = this.var_lib_base + " (HOTEL.)";
         }
      }

      if (this.typePlateForme == 0) {
         this.var_lib_base = this.var_lib_base + " (Bur.)";
      } else if (this.typePlateForme == 1) {
         this.var_lib_base = this.var_lib_base + " (Tab.)";
      } else if (this.typePlateForme == 2) {
         this.var_lib_base = this.var_lib_base + " (Mob.)";
      }

      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         var2 = true;
      }

      if (this.structureLog != null && this.structureLog.getStrmode() == null) {
         new Structure();
         this.structureDao = new StructureDao(this.baseLog, this.utilInitHibernate);
         Structure var3 = this.structureDao.logStructureId(this.structureLog.getStrid(), var1);
         if (var3 != null) {
            var3.setStrmode(0);
            this.structureDao.modStructure(var3, var1);
         }
      }

      if (this.usersLog.getGroupe() == null || this.usersLog.getGroupe().getGrpCode() != null && !this.usersLog.getGroupe().getGrpCode().isEmpty()) {
         if (this.usersLog.getGroupe() == null) {
            new Groupe();
            GroupeDao var4 = new GroupeDao(this.baseLog, this.utilInitHibernate);
            Groupe var11 = var4.groupeByCode("ADM", var1);
            if (var11 == null) {
               var11 = new Groupe();
               var11.setGrpCode("ADM");
               var11.setGrpLibelle("Administrateur");
               var11.setGrpModuleAch(1);
               var11.setGrpModuleAch(1);
               var11.setGrpModuleCai(1);
               var11.setGrpModuleCpt(1);
               var11.setGrpModuleMed(1);
               var11.setGrpModuleOff(1);
               var11.setGrpModulePay(1);
               var11.setGrpModulePrc(1);
               var11.setGrpModuleStk(1);
               var11.setGrpModuleTie(1);
               var11.setGrpModuleVte(1);
               var11.setGrpModuleEdu(1);
               var11.setGrpModuleMef(1);
               var11.setGrpModuleRep(1);
               var11.setGrpModuleFree(0);
               var11 = var4.insertGroupe(var11, var1);
            }

            this.usersLog.setGroupe(var11);
         }
      } else {
         this.usersLog.getGroupe().setGrpCode("ADM");
      }

      if (this.usersLog.getGroupe().getGrpCode().equals("ADM")) {
         this.usersLog.getGroupe().setGrpModuleAch(1);
         this.usersLog.getGroupe().setGrpModuleCai(1);
         this.usersLog.getGroupe().setGrpModuleCpt(1);
         this.usersLog.getGroupe().setGrpModuleMed(1);
         this.usersLog.getGroupe().setGrpModuleOff(1);
         this.usersLog.getGroupe().setGrpModulePay(1);
         this.usersLog.getGroupe().setGrpModulePrc(1);
         this.usersLog.getGroupe().setGrpModuleStk(1);
         this.usersLog.getGroupe().setGrpModuleTie(1);
         this.usersLog.getGroupe().setGrpModuleVte(1);
         this.usersLog.getGroupe().setGrpModuleEdu(1);
         this.usersLog.getGroupe().setGrpModuleMef(1);
         this.usersLog.getGroupe().setGrpModuleRep(1);
         this.usersLog.getGroupe().setGrpModuleFree(0);
         this.usersLog.getGroupe().setGrpModuleGuest(0);
      }

      if (StaticModePegase.getVersion_distante() != null && !StaticModePegase.getVersion_distante().isEmpty() && !StaticModePegase.getVersion_distante().equalsIgnoreCase(StaticModePegase.getCompil_version())) {
         this.var_aff_maj = true;
      } else {
         this.var_aff_maj = false;
      }

      if (this.structureLog != null && this.structureLog.getStrmode() != 0) {
         this.var_aff_copie = true;
      } else {
         this.var_aff_copie = false;
      }

      boolean var13 = false;
      boolean var12 = false;
      boolean var5 = false;
      boolean var6 = false;
      boolean var7 = false;
      File var8 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "groupe" + File.separator + "configuration" + File.separator + "optionsGroupe_" + this.structureLog.getStrid() + ".xml");
      if (var8.exists()) {
         LireLesoptionsGroupe var9 = new LireLesoptionsGroupe();
         var9.setStrId(this.structureLog.getStrid());
         new OptionGroupe();
         OptionGroupe var10 = var9.lancerExploitation();
         if (var10.getSynchroTiers().equals("1")) {
            var12 = true;
         }

         if (var10.getSynchroOffice().equals("1")) {
            var5 = true;
         }

         if (var10.getSynchroProduits().equals("1")) {
            var6 = true;
         }

         if (var10.getCentralisationCompta().equals("1")) {
            var7 = true;
         }

         var13 = true;
      }

      this.menuListe = new ArrayList();
      this.dataModelMenuHorizontal = new ListDataModel();
      if (this.usersLog.getGroupe().getGrpModuleGuest() == 1) {
         if (this.structureLog != null) {
            this.calculStr(var13, var12, var5, var6, var7, var1);
         }
      } else {
         this.menuModule = new MenuModule();
         this.menuModule.setCode(10000);
         this.menuModule.setLibelle("Accueil");
         this.menuModule.setAction("accueil");
         this.menuModule.setAffiche(this.afficheModuleGroupe(var13, var12, var5, var6, var7, 10000));
         this.menuListe.add(this.menuModule);
         if (this.structureLog != null) {
            if (this.usersLog.getGroupe().getGrpModuleFree() == 1) {
               this.menuModule = new MenuModule();
               this.menuModule.setCode(10500);
               this.menuModule.setLibelle("Travail");
               this.menuModule.setAction("travail");
               this.menuModule.setAffiche(this.afficheModuleGroupe(var13, var12, var5, var6, var7, 10500));
               this.menuListe.add(this.menuModule);
            } else {
               this.menuModule = new MenuModule();
               this.menuModule.setCode(30000);
               this.menuModule.setLibelle("Tiers");
               this.menuModule.setAction("gestionTiers");
               this.menuModule.setAffiche(this.afficheModuleGroupe(var13, var12, var5, var6, var7, 30000));
               if (this.usersLog.getGroupe().getGrpModuleTie() == 1) {
                  this.menuListe.add(this.menuModule);
               }

               this.menuModule = new MenuModule();
               this.menuModule.setCode(20000);
               this.menuModule.setLibelle("Office");
               this.menuModule.setAction("office");
               this.menuModule.setAffiche(this.afficheModuleGroupe(var13, var12, var5, var6, var7, 20000));
               if (this.usersLog.getGroupe().getGrpModuleOff() == 1) {
                  this.menuListe.add(this.menuModule);
               }

               this.moduleCompta = "";
               if (this.usersLog.getGroupe().getGrpModulePay() == 2 && this.usersLog.getUsrIdSalarieGuest() != 0L) {
                  this.menuModule = new MenuModule();
                  this.menuModule.setCode(50100);
                  this.menuModule.setLibelle("Paye");
                  this.menuModule.setAction("paye");
                  this.menuModule.setAffiche(this.afficheModuleGroupe(var13, var12, var5, var6, var7, 50100));
                  this.menuListe.add(this.menuModule);
               }

               if (this.usersLog.getGroupe().getGrpModuleCai() == 2 && this.usersLog.getUsrCaissier() == 1 && this.usersLog.getGroupe().getGrpModuleCai() == 2) {
                  this.menuModule = new MenuModule();
                  this.menuModule.setCode(90100);
                  this.menuModule.setLibelle("Tresorerie");
                  this.menuModule.setAction("caisse");
                  this.menuModule.setAffiche(this.afficheModuleGroupe(var13, var12, var5, var6, var7, 90100));
                  this.menuListe.add(this.menuModule);
               }

               this.calculStr(var13, var12, var5, var6, var7, var1);
            }
         }
      }

      this.dataModelMenuHorizontal.setWrappedData(this.menuListe);
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      if (this.detajour == null || !this.detajour.isEmpty()) {
         if (this.utilDate == null) {
            this.utilDate = new UtilDate();
         }

         this.detajour = this.utilDate.dateToStringFrCpt(this.detadujour);
         this.dteJ = this.utilDate.dateToStringSQLLight(this.detadujour);
      }

   }

   public void chargerScripts() throws HibernateException, NamingException {
      this.lesScripts = new ArrayList();
      if (StaticModePegase.isLocalApplication() && this.structureLog.getStrappDropbox() != null && !this.structureLog.getStrappDropbox().isEmpty() && !this.structureLog.getStrappDropbox().equals("0")) {
         PegScriptsDao var1 = new PegScriptsDao(this.utilInitHibernate);
         this.lesScripts = var1.selectScripts();
      }

   }

   public void calculStr(boolean var1, boolean var2, boolean var3, boolean var4, boolean var5, Session var6) throws IOException, SAXException, JDOMException {
      int var7;
      if (this.structureLog.getStrmod1() != null && !this.structureLog.getStrmod1().isEmpty()) {
         var7 = Integer.parseInt(this.structureLog.getStrmod1());
         this.rechercheModule(var7, var1, var2, var3, var4, var5, var6);
      }

      if (this.structureLog.getStrmod2() != null && !this.structureLog.getStrmod2().isEmpty()) {
         var7 = Integer.parseInt(this.structureLog.getStrmod2());
         this.rechercheModule(var7, var1, var2, var3, var4, var5, var6);
      }

      if (this.structureLog.getStrmod3() != null && !this.structureLog.getStrmod3().isEmpty()) {
         var7 = Integer.parseInt(this.structureLog.getStrmod3());
         this.rechercheModule(var7, var1, var2, var3, var4, var5, var6);
      }

      if (this.structureLog.getStrmod4() != null && !this.structureLog.getStrmod4().isEmpty()) {
         var7 = Integer.parseInt(this.structureLog.getStrmod4());
         this.rechercheModule(var7, var1, var2, var3, var4, var5, var6);
      }

      if (this.structureLog.getStrmod5() != null && !this.structureLog.getStrmod5().isEmpty()) {
         var7 = Integer.parseInt(this.structureLog.getStrmod5());
         this.rechercheModule(var7, var1, var2, var3, var4, var5, var6);
      }

      if (this.structureLog.getStrmod6() != null && !this.structureLog.getStrmod6().isEmpty()) {
         var7 = Integer.parseInt(this.structureLog.getStrmod6());
         this.rechercheModule(var7, var1, var2, var3, var4, var5, var6);
      }

      if (this.structureLog.getStrmod7() != null && !this.structureLog.getStrmod7().isEmpty()) {
         var7 = Integer.parseInt(this.structureLog.getStrmod7());
         this.rechercheModule(var7, var1, var2, var3, var4, var5, var6);
      }

      if (this.structureLog.getStrmod8() != null && !this.structureLog.getStrmod8().isEmpty()) {
         var7 = Integer.parseInt(this.structureLog.getStrmod8());
         this.rechercheModule(var7, var1, var2, var3, var4, var5, var6);
      }

      if (this.structureLog.getStrmod9() != null && !this.structureLog.getStrmod9().isEmpty()) {
         var7 = Integer.parseInt(this.structureLog.getStrmod9());
         this.rechercheModule(var7, var1, var2, var3, var4, var5, var6);
      }

      if (this.structureLog.getStrmod10() != null && !this.structureLog.getStrmod10().isEmpty()) {
         var7 = Integer.parseInt(this.structureLog.getStrmod10());
         this.rechercheModule(var7, var1, var2, var3, var4, var5, var6);
      }

   }

   public void rechercheModule(int var1, boolean var2, boolean var3, boolean var4, boolean var5, boolean var6, Session var7) throws IOException, SAXException, JDOMException {
      this.menuModule = new MenuModule();
      this.menuModule.setCode(var1);
      boolean var8 = false;
      boolean var9 = false;
      if (var1 == 40100) {
         this.moduleCompta = "40100";
         this.menuModule.setLibelle("Comptabilite");
         if (this.calculeInfosTables("ExercicesComptable", var7) != 0) {
            this.menuModule.setEtat(false);
         } else {
            this.menuModule.setEtat(true);
            this.menuModule.setAlert("Pas d'exercice");
         }

         if (this.usersLog.getGroupe().getGrpModuleCpt() == 1) {
            var8 = true;
         } else {
            var8 = false;
         }
      } else if (var1 == 40200) {
         this.moduleCompta = "40200";
         this.menuModule.setLibelle("Comptabilite");
         if (this.calculeInfosTables("ExercicesComptable", var7) != 0) {
            this.menuModule.setEtat(false);
         } else {
            this.menuModule.setEtat(true);
            this.menuModule.setAlert("Pas d'exercice");
         }

         if (this.usersLog.getGroupe().getGrpModuleCpt() == 1) {
            var8 = true;
         } else {
            var8 = false;
         }
      } else if (var1 == 40300) {
         this.moduleCompta = "40300";
         this.menuModule.setLibelle("Comptabilite");
         if (this.calculeInfosTables("ExercicesComptable", var7) != 0) {
            this.menuModule.setEtat(false);
         } else {
            this.menuModule.setEtat(true);
            this.menuModule.setAlert("Pas d'exercice");
         }

         if (this.usersLog.getGroupe().getGrpModuleCpt() == 1) {
            var8 = true;
         } else {
            var8 = false;
         }
      } else if (var1 != 50000 && var1 != 50200 && var1 != 50300) {
         if (var1 != 60000 && var1 != 60010 && var1 != 60020) {
            if (var1 == 70000) {
               this.menuModule.setLibelle("Parcs");
               if (this.calculeInfosTables("ExercicesParc", var7) != 0) {
                  this.menuModule.setEtat(false);
               } else {
                  this.menuModule.setEtat(true);
                  this.menuModule.setAlert("Pas d'exercice");
               }

               if (this.usersLog.getGroupe().getGrpModulePrc() == 1) {
                  var8 = true;
               } else {
                  var8 = false;
               }
            } else if (var1 == 80100) {
               this.moduleCommercial = "80100";
               this.menuModule.setLibelle("Ventes");
               if (this.calculeInfosTables("ExercicesVentes", var7) != 0) {
                  this.menuModule.setEtat(false);
               } else {
                  this.menuModule.setEtat(true);
                  this.menuModule.setAlert("Pas d'exercice");
               }

               if (this.usersLog.getGroupe().getGrpModuleVte() != 1 && this.usersLog.getGroupe().getGrpModuleVte() != 2) {
                  var8 = false;
               } else {
                  var8 = true;
               }
            } else if (var1 == 80200) {
               this.moduleCommercial = "80200";
               this.menuModule.setLibelle("Ventes");
               if (this.calculeInfosTables("ExercicesVentes", var7) != 0) {
                  this.menuModule.setEtat(false);
               } else {
                  this.menuModule.setEtat(true);
                  this.menuModule.setAlert("Pas d'exercice");
               }

               if (this.usersLog.getGroupe().getGrpModuleVte() == 1) {
                  var8 = true;
               } else {
                  var8 = false;
               }
            } else if (var1 == 80300) {
               this.moduleCommercial = "80300";
               this.menuModule.setLibelle("Fondation");
               if (this.calculeInfosTables("ExercicesVentes", var7) != 0) {
                  this.menuModule.setEtat(false);
               } else {
                  this.menuModule.setEtat(true);
                  this.menuModule.setAlert("Pas d'exercice");
               }

               if (this.usersLog.getGroupe().getGrpModuleVte() == 1) {
                  var8 = true;
               } else {
                  var8 = false;
               }
            } else if (var1 == 80400) {
               this.moduleCommercial = "80400";
               this.menuModule.setLibelle("Intérim");
               if (this.calculeInfosTables("ExercicesVentes", var7) != 0) {
                  this.menuModule.setEtat(false);
               } else {
                  this.menuModule.setEtat(true);
                  this.menuModule.setAlert("Pas d'exercice");
               }

               if (this.usersLog.getGroupe().getGrpModuleVte() == 1) {
                  var8 = true;
               } else {
                  var8 = false;
               }
            } else if (var1 == 80500) {
               this.moduleCommercial = "80500";
               this.menuModule.setLibelle("Cabinet");
               if (this.calculeInfosTables("ExercicesVentes", var7) != 0) {
                  this.menuModule.setEtat(false);
               } else {
                  this.menuModule.setEtat(true);
                  this.menuModule.setAlert("Pas d'exercice");
               }

               if (this.usersLog.getGroupe().getGrpModuleVte() == 1) {
                  var8 = true;
               } else {
                  var8 = false;
               }
            } else if (var1 == 80600) {
               this.moduleCommercial = "80600";
               this.menuModule.setLibelle("Transport");
               if (this.calculeInfosTables("ExercicesVentes", var7) != 0) {
                  this.menuModule.setEtat(false);
               } else {
                  this.menuModule.setEtat(true);
                  this.menuModule.setAlert("Pas d'exercice");
               }

               if (this.usersLog.getGroupe().getGrpModuleVte() != 1 && this.usersLog.getGroupe().getGrpModuleVte() != 2) {
                  var8 = false;
               } else {
                  var8 = true;
               }
            } else if (var1 == 80700) {
               this.moduleCommercial = "80700";
               this.menuModule.setLibelle("Microfinance");
               if (this.calculeInfosTables("ExercicesVentes", var7) != 0) {
                  this.menuModule.setEtat(false);
               } else {
                  this.menuModule.setEtat(true);
                  this.menuModule.setAlert("Pas d'exercice");
               }

               if (this.usersLog.getGroupe().getGrpModuleMef() == 1) {
                  var8 = true;
               } else {
                  var8 = false;
               }
            } else if (var1 == 80800) {
               this.moduleCommercial = "80800";
               this.menuModule.setLibelle("Change Monétaire");
            } else if (var1 == 80900) {
               this.moduleCommercial = "80900";
               this.menuModule.setLibelle("Education");
               if (this.calculeInfosTables("ExercicesVentes", var7) != 0) {
                  this.menuModule.setEtat(false);
               } else {
                  this.menuModule.setEtat(true);
                  this.menuModule.setAlert("Pas d'exercice");
               }

               if (this.usersLog.getGroupe().getGrpModuleEdu() == 1) {
                  var8 = true;
               } else {
                  var8 = false;
               }
            } else if (var1 == 81000) {
               this.moduleCommercial = "81000";
               this.menuModule.setLibelle("Ventes ABN");
               if (this.calculeInfosTables("ExercicesVentes", var7) != 0) {
                  this.menuModule.setEtat(false);
               } else {
                  this.menuModule.setEtat(true);
                  this.menuModule.setAlert("Pas d'exercice");
               }

               if (this.usersLog.getGroupe().getGrpModuleVte() != 1 && this.usersLog.getGroupe().getGrpModuleVte() != 2) {
                  var8 = false;
               } else {
                  var8 = true;
               }
            } else if (var1 == 81100) {
               this.menuModule.setLibelle("Pêcheries");
            } else if (var1 == 81200) {
               this.moduleCommercial = "81100";
               this.menuModule.setLibelle("Temples");
            } else if (var1 == 81300) {
               this.moduleCommercial = "81300";
               this.menuModule.setLibelle("Polit-Buro");
               if (this.calculeInfosTables("ExercicesVentes", var7) != 0) {
                  this.menuModule.setEtat(false);
               } else {
                  this.menuModule.setEtat(true);
                  this.menuModule.setAlert("Pas d'exercice");
               }

               if (this.usersLog.getGroupe().getGrpModuleVte() == 1) {
                  var8 = true;
               } else {
                  var8 = false;
               }
            } else if (var1 != 81400 && var1 != 81410 && var1 != 81420 && var1 != 81430) {
               if (var1 != 81500 && var1 != 81510 && var1 != 81520 && var1 != 81530 && var1 != 81540 && var1 != 81550) {
                  if (var1 != 81600 && var1 != 81610 && var1 != 81620 && var1 != 81630 && var1 != 81640 && var1 != 81650 && var1 != 81660) {
                     if (var1 != 81700 && var1 != 81710) {
                        if (var1 != 90000 && var1 != 90100) {
                           if (var1 == 91000) {
                              this.menuModule.setLibelle("Reporting");
                              if (this.usersLog.getGroupe().getGrpModuleRep() == 1) {
                                 var8 = true;
                              } else {
                                 var8 = false;
                              }
                           }
                        } else {
                           this.menuModule.setLibelle("Tresorerie");
                           if (this.calculeInfosTables("ExercicesCaisse", var7) != 0) {
                              this.menuModule.setEtat(false);
                           } else {
                              this.menuModule.setEtat(true);
                              this.menuModule.setAlert("Pas d'exercice");
                           }

                           if (this.usersLog.getGroupe().getGrpModuleCai() == 1) {
                              var8 = true;
                           } else {
                              var8 = false;
                           }
                        }
                     } else {
                        if (var1 == 81700) {
                           this.moduleCommercial = "81700";
                           this.menuModule.setLibelle("Restaurant");
                        } else if (var1 == 81710) {
                           this.moduleCommercial = "81710";
                           this.menuModule.setLibelle("Hôtellerie");
                        }

                        if (this.calculeInfosTables("ExercicesVentes", var7) != 0) {
                           this.menuModule.setEtat(false);
                        } else {
                           this.menuModule.setEtat(true);
                           this.menuModule.setAlert("Pas d'exercice");
                        }

                        if (this.usersLog.getGroupe().getGrpModuleVte() != 1 && this.usersLog.getGroupe().getGrpModuleVte() != 2) {
                           var8 = false;
                        } else {
                           var8 = true;
                        }
                     }
                  } else {
                     if (var1 != 81600 && var1 != 81640 && var1 != 81650) {
                        if (var1 == 81610) {
                           this.moduleCommercial = "81610";
                           this.menuModule.setLibelle("Syndic");
                        } else if (var1 == 81620) {
                           this.moduleCommercial = "81620";
                           this.menuModule.setLibelle("Négoce");
                        } else if (var1 == 81630) {
                           this.moduleCommercial = "81630";
                           this.menuModule.setLibelle("Promoteur");
                        }
                     } else {
                        this.moduleCommercial = "81600";
                        this.menuModule.setLibelle("Location");
                     }

                     if (this.calculeInfosTables("ExercicesVentes", var7) != 0) {
                        this.menuModule.setEtat(false);
                     } else {
                        this.menuModule.setEtat(true);
                        this.menuModule.setAlert("Pas d'exercice");
                     }

                     if (this.usersLog.getGroupe().getGrpModuleVte() == 1) {
                        var8 = true;
                     } else {
                        var8 = false;
                     }
                  }
               } else {
                  if (var1 == 81500) {
                     this.moduleCommercial = "81500";
                     this.menuModule.setLibelle("Infirmerie");
                     var9 = true;
                  } else if (var1 == 81510) {
                     this.moduleCommercial = "81510";
                     this.menuModule.setLibelle("Cabinet");
                  } else if (var1 == 81520) {
                     this.moduleCommercial = "81520";
                     this.menuModule.setLibelle("Laboratoire");
                  } else if (var1 == 81530) {
                     this.moduleCommercial = "81530";
                     this.menuModule.setLibelle("Pgharmacie");
                  } else if (var1 == 81540) {
                     this.moduleCommercial = "81540";
                     this.menuModule.setLibelle("Clinique");
                  } else if (var1 == 81550) {
                     this.moduleCommercial = "81550";
                     this.menuModule.setLibelle("Hopital");
                  }

                  if (this.calculeInfosTables("ExercicesVentes", var7) != 0) {
                     this.menuModule.setEtat(false);
                  } else {
                     this.menuModule.setEtat(true);
                     this.menuModule.setAlert("Pas d'exercice");
                  }

                  if (this.usersLog.getGroupe().getGrpModuleMed() == 1) {
                     var8 = true;
                  } else {
                     var8 = false;
                  }
               }
            } else {
               if (var1 == 81400) {
                  this.moduleCommercial = "81400";
                  this.menuModule.setLibelle("Forêt");
                  var9 = true;
               } else if (var1 == 81410) {
                  this.moduleCommercial = "81410";
                  this.menuModule.setLibelle("Usine Déroulage");
               } else if (var1 == 81420) {
                  this.moduleCommercial = "81420";
                  this.menuModule.setLibelle("Usine Plaquage");
               } else if (var1 == 81430) {
                  this.moduleCommercial = "81430";
                  this.menuModule.setLibelle("Usine Sciage");
               }

               if (this.calculeInfosTables("ExercicesVentes", var7) != 0) {
                  this.menuModule.setEtat(false);
               } else {
                  this.menuModule.setEtat(true);
                  this.menuModule.setAlert("Pas d'exercice");
               }

               if (this.usersLog.getGroupe().getGrpModuleVte() == 1) {
                  var8 = true;
               } else {
                  var8 = false;
               }
            }
         } else if (this.structureLog.getStrmaitrecabinet() == 2) {
            this.menuModule.setLibelle("Produits");
            if (this.calculeInfosTables("ExercicesAchats", var7) != 0) {
               this.menuModule.setEtat(false);
            } else {
               this.menuModule.setEtat(true);
               this.menuModule.setAlert("Pas d'exercice");
            }

            var8 = true;
         } else {
            this.menuModule.setLibelle("Achats");
            if (this.calculeInfosTables("ExercicesAchats", var7) != 0) {
               this.menuModule.setEtat(false);
            } else {
               this.menuModule.setEtat(true);
               this.menuModule.setAlert("Pas d'exercice");
            }

            if (this.usersLog.getGroupe().getGrpModuleAch() == 1) {
               var8 = true;
            } else {
               var8 = false;
            }
         }
      } else {
         this.menuModule.setLibelle("Paye");
         if (this.calculeInfosTables("ExercicesPaye", var7) != 0) {
            this.menuModule.setEtat(false);
         } else {
            this.menuModule.setEtat(true);
            this.menuModule.setAlert("Pas d'exercice");
         }

         if (this.usersLog.getGroupe().getGrpModulePay() == 1) {
            var8 = true;
         } else {
            var8 = false;
         }

         if (var1 == 50200) {
            var8 = false;
         }
      }

      if (var1 != 0) {
         if (var8) {
            this.menuModule.setAffiche(this.afficheModuleGroupe(var2, var3, var4, var5, var6, var1));
            this.menuListe.add(this.menuModule);
         }

         if (var1 == 50200) {
            this.menuModule = new MenuModule();
            char var10 = '썐';
            this.menuModule.setCode(var10);
            this.menuModule.setLibelle("Paye");
            this.menuModule.setEtat(false);
            if (this.usersLog.getGroupe().getGrpModulePay() == 1) {
               this.menuModule.setAffiche(this.afficheModuleGroupe(var2, var3, var4, var5, var6, var10));
               this.menuListe.add(this.menuModule);
            }

            this.menuModule = new MenuModule();
            var1 = 50200;
            this.menuModule.setCode(var1);
            this.menuModule.setLibelle("Temps");
            this.menuModule.setEtat(false);
            if (this.usersLog.getGroupe().getGrpModulePay() == 1) {
               this.menuModule.setAffiche(this.afficheModuleGroupe(var2, var3, var4, var5, var6, var1));
               this.menuListe.add(this.menuModule);
            }
         }

         if ((var1 == 60000 || var1 == 60010 || var1 == 60020) && this.structureLog.getStrmaitrecabinet() != 2 && this.structureLog.getStrtypeentreprise() != null && !this.structureLog.getStrtypeentreprise().isEmpty() && (this.structureLog.getStrtypeentreprise().equals("0") || this.structureLog.getStrtypeentreprise().equals("2"))) {
            this.menuModule = new MenuModule();
            var1 = 60100;
            this.menuModule.setCode(var1);
            this.menuModule.setLibelle("Stock");
            this.menuModule.setEtat(false);
            if (this.usersLog.getGroupe().getGrpModuleStk() == 1) {
               this.menuModule.setAffiche(this.afficheModuleGroupe(var2, var3, var4, var5, var6, var1));
               this.menuListe.add(this.menuModule);
            }
         }

         if (var1 == 81640) {
            this.menuModule = new MenuModule();
            var1 = 81610;
            this.menuModule.setCode(var1);
            this.menuModule.setLibelle("Syndic");
            this.menuModule.setEtat(false);
            if (this.usersLog.getGroupe().getGrpModuleVte() == 1) {
               this.menuModule.setAffiche(this.afficheModuleGroupe(var2, var3, var4, var5, var6, var1));
               this.menuListe.add(this.menuModule);
            }
         } else if (var1 == 81650) {
            this.menuModule = new MenuModule();
            var1 = 81610;
            this.menuModule.setCode(var1);
            this.menuModule.setLibelle("Syndic");
            this.menuModule.setEtat(false);
            if (this.usersLog.getGroupe().getGrpModuleVte() == 1) {
               this.menuModule.setAffiche(this.afficheModuleGroupe(var2, var3, var4, var5, var6, var1));
               this.menuListe.add(this.menuModule);
            }

            this.menuModule = new MenuModule();
            var1 = 81620;
            this.menuModule.setCode(var1);
            this.menuModule.setLibelle("Négoce");
            this.menuModule.setEtat(false);
            if (this.usersLog.getGroupe().getGrpModuleVte() == 1) {
               this.menuModule.setAffiche(this.afficheModuleGroupe(var2, var3, var4, var5, var6, var1));
               this.menuListe.add(this.menuModule);
            }
         } else if (var1 == 81650) {
            this.menuModule = new MenuModule();
            var1 = 81630;
            this.menuModule.setCode(var1);
            this.menuModule.setLibelle("Promoteur");
            this.menuModule.setEtat(false);
            if (this.usersLog.getGroupe().getGrpModuleVte() == 1) {
               this.menuModule.setAffiche(this.afficheModuleGroupe(var2, var3, var4, var5, var6, var1));
               this.menuListe.add(this.menuModule);
            }
         }

         if (!var9 && var1 == 81500) {
            this.menuModule = new MenuModule();
            var1 = 81500;
            this.menuModule.setCode(var1);
            this.menuModule.setLibelle("Infirmerie");
            this.menuModule.setEtat(false);
            if (this.usersLog.getGroupe().getGrpModuleVte() == 1) {
               this.menuModule.setAffiche(this.afficheModuleGroupe(var2, var3, var4, var5, var6, var1));
               this.menuListe.add(this.menuModule);
            }
         }
      }

   }

   public boolean afficheModuleGroupe(boolean var1, boolean var2, boolean var3, boolean var4, boolean var5, int var6) {
      boolean var7 = true;
      if (var1) {
         if ((var6 < 50000 || var6 > 59999) && (var6 < 70000 || var6 > 99999)) {
            if (var6 == 20000 && !var3) {
               var7 = false;
            } else if (var6 == 30000 && !var2) {
               var7 = false;
            } else if ((var6 == 60000 || var6 == 60010 || var6 == 60020 || var6 == 60100) && !var4) {
               var7 = false;
            } else if (var6 >= 40000 && var6 <= 49999 && !var5) {
               var7 = false;
            }
         } else {
            var7 = false;
         }
      }

      return var7;
   }

   public int calculeInfosTables(String var1, Session var2) {
      Object var3 = var2.createQuery("SELECT COUNT(*) FROM " + var1).uniqueResult();
      boolean var4 = false;
      int var5 = Integer.parseInt(var3.toString());
      return var5;
   }

   public void calculeModuleVente() {
      this.typeVente = 0;
      if (this.structureLog.getStrmod1() != null && !this.structureLog.getStrmod1().isEmpty() && this.structureLog.getStrmod1().startsWith("8")) {
         this.typeVente = Integer.parseInt(this.structureLog.getStrmod1().substring(0, 3));
      } else if (this.structureLog.getStrmod2() != null && !this.structureLog.getStrmod2().isEmpty() && this.structureLog.getStrmod2().startsWith("8")) {
         this.typeVente = Integer.parseInt(this.structureLog.getStrmod2().substring(0, 3));
      } else if (this.structureLog.getStrmod3() != null && !this.structureLog.getStrmod3().isEmpty() && this.structureLog.getStrmod3().startsWith("8")) {
         this.typeVente = Integer.parseInt(this.structureLog.getStrmod3().substring(0, 3));
      } else if (this.structureLog.getStrmod4() != null && !this.structureLog.getStrmod4().isEmpty() && this.structureLog.getStrmod4().startsWith("8")) {
         this.typeVente = Integer.parseInt(this.structureLog.getStrmod4().substring(0, 3));
      } else if (this.structureLog.getStrmod5() != null && !this.structureLog.getStrmod5().isEmpty() && this.structureLog.getStrmod5().startsWith("8")) {
         this.typeVente = Integer.parseInt(this.structureLog.getStrmod5().substring(0, 3));
      } else if (this.structureLog.getStrmod6() != null && !this.structureLog.getStrmod6().isEmpty() && this.structureLog.getStrmod6().startsWith("8")) {
         this.typeVente = Integer.parseInt(this.structureLog.getStrmod6().substring(0, 3));
      } else if (this.structureLog.getStrmod7() != null && !this.structureLog.getStrmod7().isEmpty() && this.structureLog.getStrmod7().startsWith("8")) {
         this.typeVente = Integer.parseInt(this.structureLog.getStrmod7().substring(0, 3));
      } else if (this.structureLog.getStrmod8() != null && !this.structureLog.getStrmod8().isEmpty() && this.structureLog.getStrmod8().startsWith("8")) {
         this.typeVente = Integer.parseInt(this.structureLog.getStrmod8().substring(0, 3));
      } else if (this.structureLog.getStrmod9() != null && !this.structureLog.getStrmod9().isEmpty() && this.structureLog.getStrmod9().startsWith("8")) {
         this.typeVente = Integer.parseInt(this.structureLog.getStrmod9().substring(0, 3));
      } else if (this.structureLog.getStrmod10() != null && !this.structureLog.getStrmod10().isEmpty() && this.structureLog.getStrmod10().startsWith("8")) {
         this.typeVente = Integer.parseInt(this.structureLog.getStrmod10().substring(0, 3));
      }

   }

   public void calculBaseCopie(Session var1) throws MalformedURLException, IOException, HibernateException, SQLException, NamingException {
      this.baseVerrou = false;
      this.lesBasesCopies = new ArrayList();
      if (this.formBackupDatas == null) {
         this.formBackupDatas = new FormBackupDatas(this.utilInitHibernate, this.utilDate);
      }

      this.formBackupDatas.setBaseLog(this.baseLog);
      this.formBackupDatas.setStructureLog(this.structureLog);
      this.formBackupDatas.url(this.urlDocument);
      if (this.usersLog.getUsrBaseCopie() == 1) {
         this.lesBasesCopies = this.formBackupDatas.chargerListeSousDossier(var1);
      }

   }

   public void calculNomBaseCopie() throws HibernateException, NamingException, SQLException, ClassNotFoundException, SAXException, IOException, JDOMException, ParseException {
      if (this.usersLog.getUsrBaseCopie() == 1 && this.lesBasesCopies.size() != 0) {
         this.baseLog = this.basesCopies;
         if (this.formBakingBeanAccueil != null) {
            this.formBakingBeanAccueil.setBaseLog(this.baseLog);
         }

         if (this.formBakingBeanAchats != null) {
            this.formBakingBeanAchats.setBaseLog(this.baseLog);
         }

         if (this.formBakingBeanAdministration != null) {
            this.formBakingBeanAdministration.setBaseLog(this.baseLog);
         }

         if (this.formBakingBeanCaisse != null) {
            this.formBakingBeanCaisse.setBaseLog(this.baseLog);
         }

         if (this.formBakingBeanComptabilite != null) {
            this.formBakingBeanComptabilite.setBaseLog(this.baseLog);
         }

         if (this.formBakingBeanEducation != null) {
            this.formBakingBeanEducation.setBaseLog(this.baseLog);
         }

         if (this.formBakingBeanFondation != null) {
            this.formBakingBeanFondation.setBaseLog(this.baseLog);
         }

         if (this.formBakingBeanForet != null) {
            this.formBakingBeanForet.setBaseLog(this.baseLog);
         }

         if (this.formBakingBeanImmobilier != null) {
            this.formBakingBeanImmobilier.setBaseLog(this.baseLog);
         }

         if (this.formBakingBeanMedical != null) {
            this.formBakingBeanMedical.setBaseLog(this.baseLog);
         }

         if (this.formBakingBeanMicroFinance != null) {
            this.formBakingBeanMicroFinance.setBaseLog(this.baseLog);
         }

         if (this.formBakingBeanOffice != null) {
            this.formBakingBeanOffice.setBaseLog(this.baseLog);
         }

         if (this.formBakingBeanParcs != null) {
            this.formBakingBeanParcs.setBaseLog(this.baseLog);
         }

         if (this.formBakingBeanPartiPolitique != null) {
            this.formBakingBeanPartiPolitique.setBaseLog(this.baseLog);
         }

         if (this.formBakingBeanPaye != null) {
            this.formBakingBeanPaye.setBaseLog(this.baseLog);
         }

         if (this.formBakingBeanReporting != null) {
            this.formBakingBeanReporting.setBaseLog(this.baseLog);
         }

         if (this.formBakingBeanSysteme != null) {
            this.formBakingBeanSysteme.setBaseLog(this.baseLog);
         }

         if (this.formBakingBeanTemple != null) {
            this.formBakingBeanTemple.setBaseLog(this.baseLog);
         }

         if (this.formBakingBeanTiers != null) {
            this.formBakingBeanTiers.setBaseLog(this.baseLog);
         }

         if (this.formBakingBeanVentes != null) {
            this.formBakingBeanVentes.setBaseLog(this.baseLog);
         }

         if (this.formDocumentsOfficiels != null) {
            this.formDocumentsOfficiels.setBaseLog(this.baseLog);
         }

         if (this.formEspaceClient != null) {
            this.formEspaceClient.setBaseLog(this.baseLog);
         }

         this.utilInitHibernate.getOpenSession(this.baseLog, 0);
         this.utilInitHibernate.closeSession();
      }

   }

   public void controleMenuHorizontal() throws SAXException, HibernateException, NamingException, IOException, JDOMException, SQLException, ParseException, org.apache.velocity.runtime.parser.ParseException {
      if (this.dataModelMenuHorizontal.isRowAvailable()) {
         this.message_vocal = "";
         this.menuModule = (MenuModule)this.dataModelMenuHorizontal.getRowData();
         if (this.menuModule.getCode() == 10000) {
            try {
               Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Accueil");
               this.accueil(var1, this.urlDocument, this.typePlateForme, true);
            } catch (HibernateException var9) {
               throw var9;
            } catch (IOException var10) {
               throw var10;
            } catch (NamingException var11) {
               throw var11;
            } catch (SAXException var12) {
               throw var12;
            } catch (SQLException var13) {
               throw var13;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         } else if (this.menuModule.getCode() == 10500) {
            this.free();
         } else if (this.menuModule.getCode() == 20000) {
            this.office();
         } else if (this.menuModule.getCode() == 30000) {
            this.tiers();
         } else if (this.menuModule.getCode() != 40100 && this.menuModule.getCode() != 40200 && this.menuModule.getCode() != 40300) {
            if (this.menuModule.getCode() != 50000 && this.menuModule.getCode() != 50100 && this.menuModule.getCode() != 50300) {
               if (this.menuModule.getCode() == 50200) {
                  this.temps();
               } else if (this.menuModule.getCode() == 60000) {
                  this.achats();
               } else if (this.menuModule.getCode() == 60010) {
                  this.achatsPapier();
               } else if (this.menuModule.getCode() == 60020) {
                  this.achatsPoulet();
               } else if (this.menuModule.getCode() == 60100) {
                  this.stock();
               } else if (this.menuModule.getCode() == 70000) {
                  this.parcs();
               } else if (this.menuModule.getCode() != 80100 && this.menuModule.getCode() != 80500 && this.menuModule.getCode() != 80600 && this.menuModule.getCode() != 81000) {
                  if (this.menuModule.getCode() == 80200) {
                     this.ventesTicket(this.menuModule.getCode());
                  } else if (this.menuModule.getCode() == 80300) {
                     this.fondation(this.menuModule.getCode());
                  } else if (this.menuModule.getCode() == 80400) {
                     this.ventesInterim(this.menuModule.getCode());
                  } else if (this.menuModule.getCode() == 80700) {
                     this.microfinance();
                  } else if (this.menuModule.getCode() == 80900) {
                     this.education();
                  } else if (this.menuModule.getCode() == 81200) {
                     this.temple();
                  } else if (this.menuModule.getCode() == 81300) {
                     this.politBuro();
                  } else if (this.menuModule.getCode() != 81400 && this.menuModule.getCode() != 81410 && this.menuModule.getCode() != 81420 && this.menuModule.getCode() != 81430) {
                     if (this.menuModule.getCode() != 81500 && this.menuModule.getCode() != 81510 && this.menuModule.getCode() != 81520 && this.menuModule.getCode() != 81530 && this.menuModule.getCode() != 81540 && this.menuModule.getCode() != 81550) {
                        if (this.menuModule.getCode() == 81600) {
                           this.location();
                        } else if (this.menuModule.getCode() == 81610) {
                           this.syndic();
                        } else if (this.menuModule.getCode() == 81620) {
                           this.negoce();
                        } else if (this.menuModule.getCode() == 81630) {
                           this.promoteur();
                        } else if (this.menuModule.getCode() == 81700) {
                           this.ventesRestaurant(this.menuModule.getCode());
                        } else if (this.menuModule.getCode() == 81710) {
                           this.ventesHotelerie(this.menuModule.getCode());
                        } else if (this.menuModule.getCode() != 90000 && this.menuModule.getCode() != 90100) {
                           if (this.menuModule.getCode() == 91000) {
                              this.reporting();
                           }
                        } else {
                           this.caisse();
                        }
                     } else {
                        this.medical(this.menuModule.getCode());
                     }
                  } else {
                     this.foret(this.menuModule.getCode());
                  }
               } else {
                  this.ventes(this.menuModule.getCode());
               }
            } else {
               this.paye();
            }
         } else {
            this.comptabilite(true);
         }
      }

   }

   public void choixSociete() throws HibernateException, NamingException, IOException, JDOMException, SAXException, SQLException, ParseException, org.apache.velocity.runtime.parser.ParseException {
      if (this.var_id_master != 0L) {
         this.masterSociete();
      } else {
         this.strSelec = false;
         if (this.listeSocieteCabinet.size() == 0) {
            this.chargeStructureSocieteSuite();
         }

         if (this.listeSocieteCabinet.size() != 0) {
            this.dataModelSociete.setWrappedData(this.listeSocieteCabinet);
            this.showModalPanelSelectionSociete = true;
         }
      }

   }

   public void chargeStructureSocieteSuite() throws HibernateException, NamingException {
      if (this.var_memo_id_master != 0L && this.var_memo_id_master != 0L && this.var_societe_cabinet != 0) {
         Session var1 = this.utilInitHibernate.getLoginEpegase();
         new ArrayList();
         Object var3 = new ArrayList();
         Query var4 = var1.createQuery("from StructurePeg where strId=:idStr").setLong("idStr", this.var_memo_id_master);
         List var2 = var4.list();
         if (var2.size() != 0) {
            long var5 = ((StructurePeg)var2.get(0)).getCabinetPeg().getCabId();
            if (var5 != 0L) {
               var4 = var1.createQuery("from StructurePeg where cabinetPeg.cabId=:idCab and (strmaitrecabinet=0 or strmaitrecabinet=12)").setLong("idCab", var5);
               var3 = var4.list();
            }
         }

         this.listeSocieteCabinet = (List)var3;
         this.utilInitHibernate.closeSession();
      }

   }

   public void femerSociete() throws IOException, SAXException, SQLException, HibernateException, NamingException, JDOMException, ParseException, org.apache.velocity.runtime.parser.ParseException {
      this.retourAdmnistration();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      this.showModalPanelSelectionSociete = false;
   }

   public void selectionSociete() {
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
            this.structurePeg = (StructurePeg)var1.get(0);
            this.strSelec = true;
         } else {
            this.structurePeg = null;
            this.strSelec = false;
         }
      } else {
         this.structurePeg = null;
         this.strSelec = false;
      }

   }

   public void validationSociete() throws HibernateException, NamingException, IOException, JDOMException, SAXException, SQLException, ParseException, org.apache.velocity.runtime.parser.ParseException {
      this.var_id_master = this.var_memo_id_master;
      if (this.structurePeg != null && this.structureLog.getStrmaitrecabinet() != 0) {
         this.var_nom_master = "(" + this.var_memo_nom_master + "):";
         new Structure();
         Structure var1 = this.structureLog;
         new Users();
         Users var2 = this.usersLog;
         String var3 = this.baseLog;
         this.baseLog = "structure" + this.structurePeg.getStrId();
         Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, this.usersLog.getUsrSysteme());
         this.structureLog = new Structure();
         this.structureDao = new StructureDao(this.baseLog, this.utilInitHibernate);
         this.structureLog = this.structureDao.logStructureId(this.structurePeg.getStrId(), var4);
         UserDao var5;
         if (this.structureLog != null) {
            this.usersLog = new Users();
            var5 = new UserDao(this.baseLog, this.utilInitHibernate);
            this.usersLog = var5.selectByMailUsers(var2.getUsrMail(), var4);
            if (this.usersLog == null) {
               StaticModePegase.setAffiche_message(true);
               StaticModePegase.setTexte_message("Vous n'avez pas accès à cette structure...");
               this.structureLog = var1;
               this.baseLog = var3;
               this.usersLog = var2;
               this.var_id_master = 0L;
               this.var_nom_master = "";
               this.affiche_nom = false;
               this.utilInitHibernate.closeSession();
               this.retourAdmnistration();
               this.showModalPanelSelectionSociete = false;
            } else if (this.usersLog.getUsrEtat() == 0) {
               StaticModePegase.setAffiche_message(true);
               StaticModePegase.setTexte_message("Votre compte a été désactivé pour cette structure...");
               this.structureLog = var1;
               this.baseLog = var3;
               this.usersLog = var2;
               this.var_id_master = 0L;
               this.var_nom_master = "";
               this.affiche_nom = false;
               this.utilInitHibernate.closeSession();
               this.retourAdmnistration();
               this.showModalPanelSelectionSociete = false;
            } else {
               this.utilInitHibernate.closeSession();
               this.retourAdmnistration();
               this.showModalPanelSelectionSociete = false;
            }
         } else {
            StaticModePegase.setAffiche_message(true);
            StaticModePegase.setTexte_message("La structure demandée est inaccessible...");
            this.utilInitHibernate.closeSession();
            this.baseLog = "structure" + var1.getStrid();
            var4 = this.utilInitHibernate.getOpenSession(this.baseLog, this.usersLog.getUsrSysteme());
            this.structureLog = new Structure();
            this.structureDao = new StructureDao(this.baseLog, this.utilInitHibernate);
            this.structureLog = this.structureDao.logStructureId(this.structurePeg.getStrId(), var4);
            this.usersLog = new Users();
            var5 = new UserDao(this.baseLog, this.utilInitHibernate);
            this.usersLog = var5.selectByMailUsers(var2.getUsrMail(), var4);
            this.utilInitHibernate.closeSession();
            this.retourAdmnistration();
         }

         if (this.structureLog != null && this.structureLog.getStrdescriptif() != null && !this.structureLog.getStrdescriptif().isEmpty()) {
            this.affiche_nom = true;
         } else {
            this.affiche_nom = false;
         }
      } else {
         this.retourAdmnistration();
         this.showModalPanelSelectionSociete = false;
      }

   }

   public void masterSociete() throws HibernateException, NamingException, IOException, JDOMException, SAXException, SQLException, ParseException, org.apache.velocity.runtime.parser.ParseException {
      this.var_id_master = 0L;
      this.var_nom_master = "";
      this.affiche_nom = false;
      this.baseLog = "structure" + this.var_memo_id_master;
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
      this.structureLog = new Structure();
      this.structureDao = new StructureDao(this.baseLog, this.utilInitHibernate);
      this.structureLog = this.structureDao.logStructureId(this.var_memo_id_master, var1);
      this.usersLog = new Users();
      UserDao var2 = new UserDao(this.baseLog, this.utilInitHibernate);
      this.usersLog = var2.selectByIdUsers(this.var_memo_id_user, var1);
      this.utilInitHibernate.closeSession();
      this.retourAdmnistration();
      this.showModalPanelSelectionSociete = false;
      if (this.structureLog.getStrdescriptif() != null && !this.structureLog.getStrdescriptif().isEmpty()) {
         this.affiche_nom = true;
      } else {
         this.affiche_nom = false;
      }

   }

   public void accueil(Session var1, String var2, int var3, boolean var4) throws IOException, SAXException, SQLException, HibernateException, NamingException, JDOMException, ParseException, org.apache.velocity.runtime.parser.ParseException {
      this.baseVerrou = false;
      this.urlDocument = var2;
      this.typePlateForme = var3;
      boolean var5 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Accueil");
         var5 = true;
      }

      this.razMemoire((String)null);
      this.formBakingBeanAccueil = new FormBakingBeanAccueil();
      this.formBakingBeanAccueil.setutilInitHibernate(this.utilInitHibernate);
      this.formBakingBeanAccueil.setBaseLog(this.baseLog);
      this.formBakingBeanAccueil.setStructureLog(this.structureLog);
      this.formBakingBeanAccueil.setUsersLog(this.usersLog);
      this.formBakingBeanAccueil.InstancesDaoUtilses();
      this.formBakingBeanAccueil.menuGaucheAccueil();
      this.formBakingBeanAccueil.accueil(var1, this.urlDocument, this.typePlateForme);
      this.formBakingBeanAccueil.setTypeVente(this.typeVente);
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      if (var4) {
         this.startupAutomatique(var1);
      } else {
         this.moduleAffiche = "accueil";
         this.moduleFree = "";
         this.affichePage = "/accueil/accueil.jsp";
         this.formBakingBeanAccueil.setAffichePage(this.affichePage);
      }

   }

   public void startupAutomatique(Session var1) throws IOException, SAXException, HibernateException, NamingException, JDOMException, ParseException, org.apache.velocity.runtime.parser.ParseException {
      if (this.usersLog.getUsrStartup() != null && !this.usersLog.getUsrStartup().isEmpty() && this.usersLog.getUsrStartup().equals("TICKET")) {
         this.controlePanLeft = false;
         this.startupSpecial = true;
         if (var1 != null) {
            this.utilInitHibernate.closeSession();
         }

         this.ventes(80200);
         this.formBakingBeanVentes.gestionCaisseAuto();
         this.moduleAffiche = "ventes";
         this.moduleFree = "";
         this.affichePage = "/ventes/TicketInit.jsp";
      } else {
         this.controlePanLeft = true;
         this.startupSpecial = false;
         this.moduleAffiche = "accueil";
         this.moduleFree = "";
         this.affichePage = "/accueil/accueil.jsp";
         this.formBakingBeanAccueil.setAffichePage(this.affichePage);
      }

   }

   public void accueilAction() throws IOException, SAXException, HibernateException, NamingException, JDOMException {
      this.moduleAffiche = "accueil";
      this.message_vocal = "";
      this.formBakingBeanAccueil.gestionAccueil();
   }

   public void activerLifeChat() throws HibernateException, NamingException {
      if (this.usersLog != null) {
         this.usersLog.setUsrMyLifeChat(true);
         UserDao var1 = new UserDao(this.baseLog, this.utilInitHibernate);
         this.usersLog = var1.modUser(this.usersLog);
      }

   }

   public void desactiverLifeChat() throws HibernateException, NamingException {
      if (this.usersLog != null) {
         this.usersLog.setUsrMyLifeChat(false);
         UserDao var1 = new UserDao(this.baseLog, this.utilInitHibernate);
         this.usersLog = var1.modUser(this.usersLog);
      }

   }

   public void guest(Session var1, String var2, int var3) throws HibernateException, NamingException, IOException, JDOMException, SAXException, SQLException, ParseException {
      this.baseVerrou = true;
      this.urlDocument = var2;
      this.typePlateForme = var3;
      boolean var4 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Accueil");
         var4 = true;
      }

      this.razMemoire((String)null);
      this.formBakingBeanAccueil = new FormBakingBeanAccueil();
      this.formBakingBeanAccueil.setutilInitHibernate(this.utilInitHibernate);
      this.formBakingBeanAccueil.setBaseLog(this.baseLog);
      this.formBakingBeanAccueil.setStructureLog(this.structureLog);
      this.formBakingBeanAccueil.setUsersLog(this.usersLog);
      this.formBakingBeanAccueil.InstancesDaoUtilses();
      this.formBakingBeanAccueil.menuGaucheGuest();
      this.formBakingBeanAccueil.guest(var1, this.urlDocument, this.typePlateForme);
      this.formBakingBeanAccueil.setTypeVente(this.typeVente);
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      this.moduleAffiche = "guest";
      this.affichePage = "/guest/guest.jsp";
      this.formBakingBeanAccueil.setAffichePage(this.affichePage);
   }

   public void gestionGuest() throws JDOMException, IOException, SAXException, HibernateException, NamingException, UnknownHostException, ParseException {
      this.moduleAffiche = "guest";
      this.message_vocal = "";
      this.formBakingBeanAccueil.gestionGuest();
   }

   public void compte() throws IOException, JDOMException, SAXException, SQLException, ParseException, HibernateException, NamingException {
      this.baseVerrou = true;
      this.razMemoire((String)null);
      if (this.formBakingBeanAccueil == null) {
         this.formBakingBeanAccueil = new FormBakingBeanAccueil();
         this.formBakingBeanAccueil.setutilInitHibernate(this.utilInitHibernate);
         this.formBakingBeanAccueil.setBaseLog(this.baseLog);
         this.formBakingBeanAccueil.setStructureLog(this.structureLog);
         this.formBakingBeanAccueil.setUsersLog(this.usersLog);
         this.formBakingBeanAccueil.InstancesDaoUtilses();
         this.formBakingBeanAccueil.setUrlExplorateur(this.urlDocument);
      }

      this.chargeStructureSocieteSuite();
      this.formBakingBeanAccueil.setLesStructuresPeg(this.listeSocieteCabinet);
      this.formBakingBeanAccueil.monCompte((Session)null);
      this.moduleAffiche = "accueil";
      this.affichePage = "/accueil/compte.jsp";
   }

   public void tiers() throws IOException, SAXException, HibernateException, NamingException, JDOMException, ParseException {
      this.razMemoire((String)null);
      int var1 = 0;
      if (this.formBakingBeanTiers == null) {
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Tiers");
         this.formBakingBeanTiers = new FormBakingBeanTiers();
         this.formBakingBeanTiers.setutilInitHibernate(this.utilInitHibernate);
         this.formBakingBeanTiers.setBaseLog(this.baseLog);
         this.formBakingBeanTiers.setStructureLog(this.structureLog);
         this.formBakingBeanTiers.setUsersLog(this.usersLog);
         this.formBakingBeanTiers.InstancesDaoUtilses();
         var1 = this.rechercheModuleComplet(this.typeVente);
         this.formBakingBeanTiers.setTypeVente(this.typeVente);
         this.formBakingBeanTiers.setModule(var1);
         this.formBakingBeanTiers.recupererTousLesItems(var2);
         this.formBakingBeanTiers.setUrlExplorateur(this.urlDocument);
         this.formBakingBeanTiers.setVar_memo_id_master(this.var_memo_id_master);
         this.utilInitHibernate.closeSession();
      }

      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      this.formBakingBeanTiers.menuGaucheTiers(var1);
      this.formBakingBeanTiers.setFormRecherche(this.formRecherche);
      this.affichePage = "/tiers/Vide.jsp";
      this.moduleAffiche = "tiers";
      this.formBakingBeanTiers.setAffichePage(this.affichePage);
   }

   public void tiersAction() throws IOException, JDOMException, HibernateException, NamingException, SAXException, ParseException {
      this.moduleAffiche = "tiers";
      this.formBakingBeanTiers.gestionTiers();
   }

   public void transfertImportTiersLibre() throws HibernateException, NamingException, ParseException, Exception {
      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      this.formBakingBeanTiers.setFormRecherche(this.formRecherche);
      this.formBakingBeanTiers.getFormTransfertTiers().importTiersLibre();
   }

   public void free() throws IOException, SAXException, HibernateException, NamingException {
      this.razMemoire((String)null);
      if (this.menudroitFreeCtrl == null) {
         this.menudroitFreeCtrl = new MenudroitFreeCtrl();
         this.menudroitFreeCtrl.setStrId(this.structureLog.getStrid());
         if (this.usersLog.getUsrCollaboration() == null || this.usersLog.getUsrCollaboration().isEmpty()) {
            this.usersLog.setUsrCollaboration("ADM");
         }

         this.menudroitFreeCtrl.chargerMenudroitFreeXml(this.usersLog.getUsrCollaboration());
      }

      this.moduleAffiche = "free";
      this.moduleFree = "free";
      this.affichePage = "/Vide.jsp";
   }

   public void gestionFree() throws JDOMException, SAXException, NamingException, IOException, HibernateException, ParseException, org.apache.taglibs.standard.extra.spath.ParseException, org.apache.commons.el.parser.ParseException, org.apache.velocity.runtime.parser.ParseException {
      this.moduleAffiche = "free";
      this.moduleFree = "free";
      new ObjetLigneMenu();
      if (this.menudroitFreeCtrl.getDataModelMenudroitFreeXmlList().isRowAvailable()) {
         ObjetLigneMenu var1 = (ObjetLigneMenu)this.menudroitFreeCtrl.getDataModelMenudroitFreeXmlList().getRowData();
         if (var1.getLibelle_FR() != null && !var1.getLibelle_FR().isEmpty()) {
            if (var1.getCommande().startsWith("2")) {
               this.office();
               this.formBakingBeanOffice.gestionOfficeFree(var1);
            } else if (var1.getCommande().startsWith("3")) {
               this.tiers();
               this.formBakingBeanTiers.gestionTiersFree(var1);
            } else if (var1.getCommande().startsWith("4")) {
               this.comptabilite(true);
               this.formBakingBeanComptabilite.gestionComptaFree(var1);
            } else if (var1.getCommande().startsWith("5")) {
               this.paye();
               this.formBakingBeanPaye.gestionPayeFree(var1);
            } else if (var1.getCommande().startsWith("600")) {
               this.achats();
               this.formBakingBeanAchats.gestionAchatsFree(var1);
            } else if (var1.getCommande().startsWith("601")) {
               this.stock();
               this.formBakingBeanAchats.gestionStockFree(var1);
            } else if (var1.getCommande().startsWith("7")) {
               this.parcs();
               this.formBakingBeanParcs.gestionParcFree(var1);
            } else if (var1.getCommande().startsWith("801")) {
               this.ventes(Integer.parseInt("801"));
               this.formBakingBeanVentes.gestionVentesFree(var1);
            } else if (var1.getCommande().startsWith("807")) {
               this.microfinance();
            } else if (var1.getCommande().startsWith("815")) {
               this.medical(Integer.parseInt("815"));
               this.formBakingBeanMedical.gestionMedicalFree(var1);
            } else if (var1.getCommande().startsWith("8160")) {
               this.location();
               this.formBakingBeanImmobilier.gestionLocationFree(var1);
            } else if (var1.getCommande().startsWith("8161")) {
               this.syndic();
               this.formBakingBeanImmobilier.gestionSyndicFree(var1);
            } else if (var1.getCommande().startsWith("8162")) {
               this.negoce();
               this.formBakingBeanImmobilier.gestionNegoceFree(var1);
            } else if (var1.getCommande().startsWith("9")) {
               this.caisse();
               this.formBakingBeanCaisse.gestionCaisseFree(var1);
            }
         }
      }

   }

   public void office() throws IOException, JDOMException, HibernateException, NamingException {
      this.baseVerrou = true;
      this.razMemoire((String)null);
      if (this.formBakingBeanOffice == null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviOffice");
         this.formBakingBeanOffice = new FormBakingBeanOffice();
         this.formBakingBeanOffice.setutilInitHibernate(this.utilInitHibernate);
         this.formBakingBeanOffice.setBaseLog(this.baseLog);
         this.formBakingBeanOffice.setStructureLog(this.structureLog);
         this.formBakingBeanOffice.setUsersLog(this.usersLog);
         this.formBakingBeanOffice.InstancesDaoUtilses();
         this.formBakingBeanOffice.recupererTousLesItems(var1);
         this.formBakingBeanOffice.setUrlExplorateur(this.urlDocument);
         this.utilInitHibernate.closeSession();
      }

      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      this.formBakingBeanOffice.menuGaucheOffice();
      this.formBakingBeanOffice.setFormRecherche(this.formRecherche);
      this.affichePage = "/office/Vide.jsp";
      this.moduleAffiche = "office";
      this.formBakingBeanOffice.setAffichePage(this.affichePage);
   }

   public void gestionOffice() throws IOException, HibernateException, NamingException, JDOMException, ParseException {
      this.moduleAffiche = "office";
      this.formBakingBeanOffice.gestionOffice();
   }

   public void comptabilite(boolean var1) throws IOException, JDOMException, NamingException {
      this.baseVerrou = true;
      if (var1) {
         this.razMemoire((String)null);
      }

      if (this.formBakingBeanComptabilite == null) {
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Analytique");
         this.formBakingBeanComptabilite = new FormBakingBeanComptabilite();
         this.formBakingBeanComptabilite.setutilInitHibernate(this.utilInitHibernate);
         this.formBakingBeanComptabilite.setBaseLog(this.baseLog);
         this.formBakingBeanComptabilite.setStructureLog(this.structureLog);
         this.formBakingBeanComptabilite.setUsersLog(this.usersLog);
         this.formBakingBeanComptabilite.InstancesDaoUtilses();
         if (this.rechercheModule(40300)) {
            this.formBakingBeanComptabilite.setModulesCode("40300");
         } else if (!this.rechercheModule(40100)) {
            this.formBakingBeanComptabilite.setModulesCode("40200");
         } else {
            this.formBakingBeanComptabilite.setModulesCode("40100");
         }

         this.formBakingBeanComptabilite.recupererOptionsCompta();
         this.formBakingBeanComptabilite.recupererExercices(var2);
         if (this.formBakingBeanComptabilite.getExoselectionne() != null && this.formBakingBeanComptabilite.getExoselectionne().getExecpt_id() != 0L) {
            this.formBakingBeanComptabilite.recupererTousLesItems(var2);
         }

         this.formBakingBeanComptabilite.setUrlExplorateur(this.urlDocument);
         this.formBakingBeanComptabilite.setTypeVente(this.typeVente);
         this.utilInitHibernate.closeSession();
      }

      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      if (this.formDocumentsOfficiels == null) {
         this.formDocumentsOfficiels = new FormDocumentsOfficiels(this.baseLog, this.structureLog, this.usersLog, 50, this.urlDocument, this.utilInitHibernate);
      }

      this.formBakingBeanComptabilite.setFormDocumentsOfficiels(this.formDocumentsOfficiels);
      this.formBakingBeanComptabilite.menuGaucheComptabilite();
      this.formBakingBeanComptabilite.setFormRecherche(this.formRecherche);
      this.moduleAffiche = "compta";
      this.affichePage = "/comptabilite/Vide.jsp";
      this.formBakingBeanComptabilite.setAffichePage(this.affichePage);
   }

   public void gestionComptabilite() throws JDOMException, SAXException, NamingException, IOException, HibernateException, org.apache.taglibs.standard.extra.spath.ParseException, ParseException {
      this.moduleAffiche = "compta";
      this.formBakingBeanComptabilite.gestionComptabilite();
   }

   public void retourExocompta() throws ParseException {
      this.moduleAffiche = "admin";
      this.affichePage = "/administration/Vide.jsp";
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

   public int rechercheModuleComplet(int var1) {
      int var2 = var1;
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
         if (((String)var3.get(var4)).startsWith(var5)) {
            var2 = Integer.parseInt((String)var3.get(var4));
            break;
         }
      }

      return var2;
   }

   public void achats() throws IOException, SAXException, HibernateException, NamingException, JDOMException, ParseException {
      this.baseVerrou = true;
      this.razMemoire((String)null);
      if (this.formBakingBeanAchats == null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviCommAch");
         this.formBakingBeanAchats = new FormBakingBeanAchats();
         this.formBakingBeanAchats.setutilInitHibernate(this.utilInitHibernate);
         this.formBakingBeanAchats.setBaseLog(this.baseLog);
         this.formBakingBeanAchats.setStructureLog(this.structureLog);
         this.formBakingBeanAchats.setUsersLog(this.usersLog);
         this.formBakingBeanAchats.InstancesDaoUtilses();
         this.formBakingBeanAchats.recupererExercices(var1);
         if (this.formBakingBeanAchats.getExoselectionne() != null && this.formBakingBeanAchats.getExoselectionne().getExeachId() != 0L) {
            this.formBakingBeanAchats.recupererTousLesItems(var1);
         }

         this.formBakingBeanAchats.setUrlExplorateur(this.urlDocument);
         this.formBakingBeanAchats.setTypeVente(this.typeVente);
         this.formBakingBeanAchats.setVar_memo_id_master(this.var_memo_id_master);
         this.utilInitHibernate.closeSession();
      }

      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      this.formBakingBeanAchats.menuGaucheAchats();
      this.formBakingBeanAchats.setFormRecherche(this.formRecherche);
      this.moduleAffiche = "achats";
      this.affichePage = "/achats/Vide.jsp";
      this.formBakingBeanAchats.setAffichePage(this.affichePage);
   }

   public void gestionAchats() throws JDOMException, SAXException, NamingException, org.apache.commons.el.parser.ParseException, IOException, ParseException, org.apache.taglibs.standard.extra.spath.ParseException {
      this.moduleAffiche = "achats";
      this.formBakingBeanAchats.gestionAchats();
   }

   public void achatsPapier() throws IOException, SAXException, HibernateException, NamingException, JDOMException, ParseException {
      this.baseVerrou = true;
      this.razMemoire((String)null);
      if (this.formBakingBeanAchats == null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviCommAch");
         this.formBakingBeanAchats = new FormBakingBeanAchats();
         this.formBakingBeanAchats.setutilInitHibernate(this.utilInitHibernate);
         this.formBakingBeanAchats.setBaseLog(this.baseLog);
         this.formBakingBeanAchats.setStructureLog(this.structureLog);
         this.formBakingBeanAchats.setUsersLog(this.usersLog);
         this.formBakingBeanAchats.InstancesDaoUtilses();
         this.formBakingBeanAchats.recupererExercices(var1);
         if (this.formBakingBeanAchats.getExoselectionne() != null && this.formBakingBeanAchats.getExoselectionne().getExeachId() != 0L) {
            this.formBakingBeanAchats.recupererTousLesItems(var1);
         }

         this.formBakingBeanAchats.setUrlExplorateur(this.urlDocument);
         this.formBakingBeanAchats.setTypeVente(this.typeVente);
         this.utilInitHibernate.closeSession();
      }

      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      this.formBakingBeanAchats.menuGaucheAchatsPapier();
      this.formBakingBeanAchats.setFormRecherche(this.formRecherche);
      this.moduleAffiche = "achats";
      this.affichePage = "/achats/Vide.jsp";
      this.formBakingBeanAchats.setAffichePage(this.affichePage);
   }

   public void achatsPoulet() throws IOException, SAXException, HibernateException, NamingException, JDOMException, ParseException {
      this.baseVerrou = true;
      this.razMemoire((String)null);
      if (this.formBakingBeanAchats == null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviCommAch");
         this.formBakingBeanAchats = new FormBakingBeanAchats();
         this.formBakingBeanAchats.setutilInitHibernate(this.utilInitHibernate);
         this.formBakingBeanAchats.setBaseLog(this.baseLog);
         this.formBakingBeanAchats.setStructureLog(this.structureLog);
         this.formBakingBeanAchats.setUsersLog(this.usersLog);
         this.formBakingBeanAchats.InstancesDaoUtilses();
         this.formBakingBeanAchats.recupererExercices(var1);
         if (this.formBakingBeanAchats.getExoselectionne() != null && this.formBakingBeanAchats.getExoselectionne().getExeachId() != 0L) {
            this.formBakingBeanAchats.recupererTousLesItems(var1);
         }

         this.formBakingBeanAchats.setUrlExplorateur(this.urlDocument);
         this.formBakingBeanAchats.setTypeVente(this.typeVente);
         this.utilInitHibernate.closeSession();
      }

      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      this.formBakingBeanAchats.menuGaucheAchatsPoulet();
      this.formBakingBeanAchats.setFormRecherche(this.formRecherche);
      this.moduleAffiche = "achats";
      this.affichePage = "/achats/Vide.jsp";
      this.formBakingBeanAchats.setAffichePage(this.affichePage);
   }

   public void retourExoAchat() throws JDOMException {
      this.moduleAffiche = "admin";
      this.affichePage = "/administration/Vide.jsp";
   }

   public void transfertComptaAchats() throws IOException, SAXException, HibernateException, NamingException, JDOMException, ParseException {
      this.comptabilite(false);
      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      if (this.formBakingBeanComptabilite == null) {
         this.formBakingBeanComptabilite = new FormBakingBeanComptabilite();
         this.formBakingBeanComptabilite.setutilInitHibernate(this.utilInitHibernate);
         this.formBakingBeanComptabilite.setBaseLog(this.baseLog);
         this.formBakingBeanComptabilite.setStructureLog(this.structureLog);
         this.formBakingBeanComptabilite.setUsersLog(this.usersLog);
         this.formBakingBeanComptabilite.InstancesDaoUtilses();
         if (this.rechercheModule(40300)) {
            this.formBakingBeanComptabilite.setModulesCode("40300");
         } else if (!this.rechercheModule(40100)) {
            this.formBakingBeanComptabilite.setModulesCode("40200");
         } else {
            this.formBakingBeanComptabilite.setModulesCode("40100");
         }

         this.formBakingBeanComptabilite.recupererOptionsCompta();
         this.formBakingBeanComptabilite.recupererExercices((Session)null);
         if (this.formBakingBeanComptabilite.getExoselectionne() != null && this.formBakingBeanComptabilite.getExoselectionne().getExecpt_id() != 0L) {
            this.formBakingBeanComptabilite.recupererTousLesItems((Session)null);
         }

         this.formBakingBeanComptabilite.setUrlExplorateur(this.urlDocument);
         this.formBakingBeanComptabilite.setTypeVente(this.typeVente);
      }

      this.formBakingBeanComptabilite.setFormRecherche(this.formRecherche);
      this.formBakingBeanComptabilite.preparationTransfertAchats(this.formBakingBeanAchats.getFormTransfertAchats().getListDocument());
   }

   public void stock() throws IOException, SAXException, HibernateException, NamingException, JDOMException, ParseException {
      this.baseVerrou = true;
      this.razMemoire((String)null);
      if (this.formBakingBeanAchats == null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviCommAch");
         this.formBakingBeanAchats = new FormBakingBeanAchats();
         this.formBakingBeanAchats.setutilInitHibernate(this.utilInitHibernate);
         this.formBakingBeanAchats.setBaseLog(this.baseLog);
         this.formBakingBeanAchats.setStructureLog(this.structureLog);
         this.formBakingBeanAchats.setUsersLog(this.usersLog);
         this.formBakingBeanAchats.InstancesDaoUtilses();
         this.formBakingBeanAchats.recupererExercices(var1);
         if (this.formBakingBeanAchats.getExoselectionne() != null && this.formBakingBeanAchats.getExoselectionne().getExeachId() != 0L) {
            this.formBakingBeanAchats.recupererTousLesItems(var1);
         }

         this.formBakingBeanAchats.setUrlExplorateur(this.urlDocument);
         this.formBakingBeanAchats.setTypeVente(this.typeVente);
         this.formBakingBeanAchats.setVar_memo_id_master(this.var_memo_id_master);
         this.utilInitHibernate.closeSession();
      }

      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      this.formBakingBeanAchats.menuGaucheStock();
      this.formBakingBeanAchats.setFormRecherche(this.formRecherche);
      this.affichePage = "/stock/Vide.jsp";
      this.moduleAffiche = "stock";
      this.formBakingBeanAchats.setAffichePage(this.affichePage);
   }

   public void gestionStock() throws JDOMException, SAXException, NamingException, IOException, ParseException {
      this.moduleAffiche = "stock";
      this.formBakingBeanAchats.gestionStock();
   }

   public void retourExoStock() throws JDOMException {
      this.moduleAffiche = "admin";
      this.affichePage = "/administration/Vide.jsp";
   }

   public void ventes(int var1) throws IOException, SAXException, HibernateException, NamingException, JDOMException, ParseException {
      this.baseVerrou = true;
      this.razMemoire((String)null);
      if (this.formBakingBeanVentes == null) {
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviCommVte");
         this.formBakingBeanVentes = new FormBakingBeanVentes();
         this.formBakingBeanVentes.setutilInitHibernate(this.utilInitHibernate);
         this.formBakingBeanVentes.setBaseLog(this.baseLog);
         this.formBakingBeanVentes.setStructureLog(this.structureLog);
         this.formBakingBeanVentes.setUsersLog(this.usersLog);
         this.formBakingBeanVentes.InstancesDaoUtilses();
         this.formBakingBeanVentes.recupererExercices(var2);
         if (this.formBakingBeanVentes.getExoselectionne() != null && this.formBakingBeanVentes.getExoselectionne().getExevteId() != 0L) {
            this.formBakingBeanVentes.recupererTousLesItems(var2);
         }

         this.formBakingBeanVentes.setUrlExplorateur(this.urlDocument);
         this.formBakingBeanVentes.setTypeVente(this.typeVente);
         this.formBakingBeanVentes.setVar_memo_id_master(this.var_memo_id_master);
         this.utilInitHibernate.closeSession();
      }

      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      this.formBakingBeanVentes.menuGaucheVentes(var1);
      this.formBakingBeanVentes.setFormRecherche(this.formRecherche);
      this.moduleAffiche = "ventes";
      if (this.formBakingBeanVentes.getLeIdExo() == 0L || this.usersLog.getUsrStartup() != null && !this.usersLog.getUsrStartup().isEmpty() && this.usersLog.getUsrStartup().equals("Sans") || this.usersLog.getUsrStartup() == null || this.usersLog.getUsrStartup().isEmpty()) {
         this.affichePage = "/ventes/Vide.jsp";
         this.formBakingBeanVentes.setAffichePage(this.affichePage);
      }

   }

   public void gestionVentes() throws IOException, SAXException, NamingException, JDOMException, HibernateException, org.apache.velocity.runtime.parser.ParseException, ParseException {
      this.moduleAffiche = "ventes";
      this.formBakingBeanVentes.gestionVentes();
   }

   public void retourExoVente() throws JDOMException {
      this.moduleAffiche = "admin";
      this.affichePage = "/administration/Vide.jsp";
   }

   public void transfertComptaVentes() throws IOException, SAXException, HibernateException, NamingException, JDOMException, ParseException {
      this.comptabilite(false);
      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      if (this.formBakingBeanComptabilite == null) {
         this.formBakingBeanComptabilite = new FormBakingBeanComptabilite();
         this.formBakingBeanComptabilite.setutilInitHibernate(this.utilInitHibernate);
         this.formBakingBeanComptabilite.setBaseLog(this.baseLog);
         this.formBakingBeanComptabilite.setStructureLog(this.structureLog);
         this.formBakingBeanComptabilite.setUsersLog(this.usersLog);
         this.formBakingBeanComptabilite.InstancesDaoUtilses();
         if (this.rechercheModule(40300)) {
            this.formBakingBeanComptabilite.setModulesCode("40300");
         } else if (!this.rechercheModule(40100)) {
            this.formBakingBeanComptabilite.setModulesCode("40200");
         } else {
            this.formBakingBeanComptabilite.setModulesCode("40100");
         }

         this.formBakingBeanComptabilite.recupererOptionsCompta();
         this.formBakingBeanComptabilite.recupererExercices((Session)null);
         if (this.formBakingBeanComptabilite.getExoselectionne() != null && this.formBakingBeanComptabilite.getExoselectionne().getExecpt_id() != 0L) {
            this.formBakingBeanComptabilite.recupererTousLesItems((Session)null);
         }

         this.formBakingBeanComptabilite.setUrlExplorateur(this.urlDocument);
         this.formBakingBeanComptabilite.setTypeVente(this.typeVente);
      }

      this.formBakingBeanComptabilite.setFormRecherche(this.formRecherche);
      this.formBakingBeanComptabilite.preparationTransfertVentes(this.formBakingBeanVentes.getFormTransfertVentes().getListDocument());
   }

   public void transfertImportLibreVentes() throws HibernateException, NamingException, ParseException, JDOMException, IOException {
      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      this.formBakingBeanVentes.setFormRecherche(this.formRecherche);
      String var1 = this.formBakingBeanVentes.getFormTransfertVentes().testImportLibre();
      if (var1.equals("PRODUITS")) {
         this.formBakingBeanVentes.getFormTransfertVentes().importProduitLibre();
      } else if (var1.equals("DEVIS")) {
         this.formBakingBeanVentes.getFormTransfertVentes().importDevisLibre();
      } else if (var1.equals("COMMANDES")) {
         this.formBakingBeanVentes.getFormTransfertVentes().importCommandeLibre();
      } else if (var1.equals("LIVRAISONS")) {
         this.formBakingBeanVentes.getFormTransfertVentes().importLivraisonLibre();
      } else if (!var1.equals("RETOURS")) {
         if (var1.equals("FACTURES")) {
            this.formBakingBeanVentes.getFormTransfertVentes().importFactureLibre();
         } else if (!var1.equals("FACTURESINTERNES") && !var1.equals("NOTESDEDEBIT") && var1.equals("AVOIRS")) {
         }
      }

   }

   public void ventesTicket(int var1) throws IOException, SAXException, HibernateException, NamingException, JDOMException, ParseException {
      this.razMemoire((String)null);
      if (this.formBakingBeanVentes == null) {
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviCommVte");
         this.formBakingBeanVentes = new FormBakingBeanVentes();
         this.formBakingBeanVentes.setutilInitHibernate(this.utilInitHibernate);
         this.formBakingBeanVentes.setBaseLog(this.baseLog);
         this.formBakingBeanVentes.setStructureLog(this.structureLog);
         this.formBakingBeanVentes.setUsersLog(this.usersLog);
         this.formBakingBeanVentes.InstancesDaoUtilses();
         this.formBakingBeanVentes.recupererExercices(var2);
         if (this.formBakingBeanVentes.getExoselectionne() != null && this.formBakingBeanVentes.getExoselectionne().getExevteId() != 0L) {
            this.formBakingBeanVentes.recupererTousLesItems(var2);
         }

         this.formBakingBeanVentes.setUrlExplorateur(this.urlDocument);
         this.formBakingBeanVentes.setTypeVente(this.typeVente);
         this.formBakingBeanVentes.setVar_memo_id_master(this.var_memo_id_master);
         this.utilInitHibernate.closeSession();
      }

      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      this.formBakingBeanVentes.menuGaucheVentes(var1);
      this.formBakingBeanVentes.setFormRecherche(this.formRecherche);
      this.affichePage = "/ventes/Vide.jsp";
      this.moduleAffiche = "ventesTicket";
      this.formBakingBeanVentes.setAffichePage(this.affichePage);
   }

   public void gestionVentesTicket() throws IOException, SAXException, NamingException, JDOMException, HibernateException, org.apache.velocity.runtime.parser.ParseException, ParseException {
      this.formBakingBeanVentes.gestionVentesTicket();
      if (this.formBakingBeanVentes.getNature() == 6) {
         this.controlePanLeft = false;
      }

      this.moduleAffiche = "ventesTicket";
   }

   public void quitterTicket() throws IOException, SAXException, SQLException, HibernateException, NamingException, JDOMException, ParseException, org.apache.velocity.runtime.parser.ParseException {
      this.controlePanLeft = true;
      this.formBakingBeanVentes.getFormTicketVentes().validerSession();
      this.retourAdmnistration();
   }

   public void ventesInterim(int var1) throws IOException, SAXException, HibernateException, NamingException, JDOMException, ParseException {
      this.razMemoire((String)null);
      if (this.formBakingBeanVentes == null) {
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviCommVte");
         this.formBakingBeanVentes = new FormBakingBeanVentes();
         this.formBakingBeanVentes.setutilInitHibernate(this.utilInitHibernate);
         this.formBakingBeanVentes.setBaseLog(this.baseLog);
         this.formBakingBeanVentes.setStructureLog(this.structureLog);
         this.formBakingBeanVentes.setUsersLog(this.usersLog);
         this.formBakingBeanVentes.InstancesDaoUtilses();
         this.formBakingBeanVentes.recupererExercices(var2);
         if (this.formBakingBeanVentes.getExoselectionne() != null && this.formBakingBeanVentes.getExoselectionne().getExevteId() != 0L) {
            this.formBakingBeanVentes.recupererTousLesItems(var2);
         }

         this.formBakingBeanVentes.setUrlExplorateur(this.urlDocument);
         this.formBakingBeanVentes.setTypeVente(this.typeVente);
         this.formBakingBeanVentes.setVar_memo_id_master(this.var_memo_id_master);
         this.utilInitHibernate.closeSession();
      }

      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      this.formBakingBeanVentes.menuGaucheVentes(var1);
      this.formBakingBeanVentes.setFormRecherche(this.formRecherche);
      this.affichePage = "/interim/Vide.jsp";
      this.moduleAffiche = "ventesInterim";
      this.formBakingBeanVentes.setAffichePage(this.affichePage);
   }

   public void gestionVentesInterim() throws IOException, SAXException, NamingException, JDOMException, HibernateException, org.apache.velocity.runtime.parser.ParseException, ParseException {
      this.formBakingBeanVentes.gestionVentesInterim();
      this.moduleAffiche = "ventesInterim";
   }

   public void ventesRestaurant(int var1) throws IOException, SAXException, HibernateException, NamingException, JDOMException, ParseException {
      this.razMemoire((String)null);
      if (this.formBakingBeanVentes == null) {
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviCommVte");
         this.formBakingBeanVentes = new FormBakingBeanVentes();
         this.formBakingBeanVentes.setutilInitHibernate(this.utilInitHibernate);
         this.formBakingBeanVentes.setBaseLog(this.baseLog);
         this.formBakingBeanVentes.setStructureLog(this.structureLog);
         this.formBakingBeanVentes.setUsersLog(this.usersLog);
         this.formBakingBeanVentes.InstancesDaoUtilses();
         this.formBakingBeanVentes.recupererExercices(var2);
         if (this.formBakingBeanVentes.getExoselectionne() != null && this.formBakingBeanVentes.getExoselectionne().getExevteId() != 0L) {
            this.formBakingBeanVentes.recupererTousLesItems(var2);
         }

         this.formBakingBeanVentes.setUrlExplorateur(this.urlDocument);
         this.formBakingBeanVentes.setTypeVente(this.typeVente);
         this.formBakingBeanVentes.setVar_memo_id_master(this.var_memo_id_master);
         this.utilInitHibernate.closeSession();
      }

      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      this.formBakingBeanVentes.menuGaucheVentes(var1);
      this.formBakingBeanVentes.setFormRecherche(this.formRecherche);
      this.affichePage = "/restaurant/Vide.jsp";
      this.moduleAffiche = "ventesRestaurant";
      this.formBakingBeanVentes.setAffichePage(this.affichePage);
   }

   public void gestionRestaurant() throws IOException, SAXException, NamingException, JDOMException, HibernateException, org.apache.velocity.runtime.parser.ParseException, ParseException {
      this.formBakingBeanVentes.gestionRestaurant();
      this.moduleAffiche = "ventesRestaurant";
   }

   public void ventesHotelerie(int var1) throws IOException, SAXException, HibernateException, NamingException, JDOMException, ParseException {
      this.razMemoire((String)null);
      if (this.formBakingBeanVentes == null) {
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviCommVte");
         this.formBakingBeanVentes = new FormBakingBeanVentes();
         this.formBakingBeanVentes.setutilInitHibernate(this.utilInitHibernate);
         this.formBakingBeanVentes.setBaseLog(this.baseLog);
         this.formBakingBeanVentes.setStructureLog(this.structureLog);
         this.formBakingBeanVentes.setUsersLog(this.usersLog);
         this.formBakingBeanVentes.InstancesDaoUtilses();
         this.formBakingBeanVentes.recupererExercices(var2);
         if (this.formBakingBeanVentes.getExoselectionne() != null && this.formBakingBeanVentes.getExoselectionne().getExevteId() != 0L) {
            this.formBakingBeanVentes.recupererTousLesItems(var2);
         }

         this.formBakingBeanVentes.setUrlExplorateur(this.urlDocument);
         this.formBakingBeanVentes.setTypeVente(this.typeVente);
         this.formBakingBeanVentes.setVar_memo_id_master(this.var_memo_id_master);
         this.utilInitHibernate.closeSession();
      }

      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      this.formBakingBeanVentes.menuGaucheVentes(var1);
      this.formBakingBeanVentes.setFormRecherche(this.formRecherche);
      this.affichePage = "/hotelerie/Vide.jsp";
      this.moduleAffiche = "ventesHotelerie";
      this.formBakingBeanVentes.setAffichePage(this.affichePage);
   }

   public void gestionHotelerie() throws IOException, SAXException, NamingException, JDOMException, HibernateException, org.apache.velocity.runtime.parser.ParseException, ParseException {
      this.formBakingBeanVentes.gestionHotelerie();
      this.moduleAffiche = "ventesHotelerie";
   }

   public void fondation(int var1) throws IOException, SAXException, HibernateException, NamingException, JDOMException, ParseException {
      this.baseVerrou = true;
      this.razMemoire((String)null);
      if (this.formBakingBeanFondation == null) {
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviFondation");
         this.formBakingBeanFondation = new FormBakingBeanFondation();
         this.formBakingBeanFondation.setutilInitHibernate(this.utilInitHibernate);
         this.formBakingBeanFondation.setBaseLog(this.baseLog);
         this.formBakingBeanFondation.setStructureLog(this.structureLog);
         this.formBakingBeanFondation.setUsersLog(this.usersLog);
         this.formBakingBeanFondation.InstancesDaoUtilses();
         this.formBakingBeanFondation.recupererExercices(var2);
         if (this.formBakingBeanFondation.getExoselectionne() != null && this.formBakingBeanFondation.getExoselectionne().getExevteId() != 0L) {
            this.formBakingBeanFondation.recupererTousLesItems(var2);
         }

         this.formBakingBeanFondation.setUrlExplorateur(this.urlDocument);
         this.formBakingBeanFondation.setTypeVente(this.typeVente);
         this.utilInitHibernate.closeSession();
      }

      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      this.formBakingBeanFondation.menuGaucheFondation(var1);
      this.formBakingBeanFondation.setFormRecherche(this.formRecherche);
      this.moduleAffiche = "fondation";
      if (this.formBakingBeanFondation.getLeIdExo() == 0L || this.usersLog.getUsrStartup() != null && !this.usersLog.getUsrStartup().isEmpty() && this.usersLog.getUsrStartup().equals("Sans") || this.usersLog.getUsrStartup() == null || this.usersLog.getUsrStartup().isEmpty()) {
         this.affichePage = "/fondation/Vide.jsp";
         this.formBakingBeanFondation.setAffichePage(this.affichePage);
      }

   }

   public void gestionFondation() throws IOException, SAXException, NamingException, JDOMException, HibernateException, org.apache.velocity.runtime.parser.ParseException, ParseException {
      this.formBakingBeanFondation.gestionFondation();
      this.moduleAffiche = "fondation";
   }

   public void retourExoFondation() throws JDOMException {
      this.moduleAffiche = "admin";
      this.affichePage = "/administration/Vide.jsp";
   }

   public void transfertComptaFondation() throws IOException, SAXException, HibernateException, NamingException, JDOMException {
      this.comptabilite(false);
      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      if (this.formBakingBeanComptabilite == null) {
         this.formBakingBeanComptabilite = new FormBakingBeanComptabilite();
         this.formBakingBeanComptabilite.setutilInitHibernate(this.utilInitHibernate);
         this.formBakingBeanComptabilite.setBaseLog(this.baseLog);
         this.formBakingBeanComptabilite.setStructureLog(this.structureLog);
         this.formBakingBeanComptabilite.setUsersLog(this.usersLog);
         this.formBakingBeanComptabilite.InstancesDaoUtilses();
         if (this.rechercheModule(40300)) {
            this.formBakingBeanComptabilite.setModulesCode("40300");
         } else if (!this.rechercheModule(40100)) {
            this.formBakingBeanComptabilite.setModulesCode("40200");
         } else {
            this.formBakingBeanComptabilite.setModulesCode("40100");
         }

         this.formBakingBeanComptabilite.recupererOptionsCompta();
         this.formBakingBeanComptabilite.recupererExercices((Session)null);
         if (this.formBakingBeanComptabilite.getExoselectionne() != null && this.formBakingBeanComptabilite.getExoselectionne().getExecpt_id() != 0L) {
            this.formBakingBeanComptabilite.recupererTousLesItems((Session)null);
         }

         this.formBakingBeanComptabilite.setUrlExplorateur(this.urlDocument);
         this.formBakingBeanComptabilite.setTypeVente(this.typeVente);
      }

      this.formBakingBeanComptabilite.setFormRecherche(this.formRecherche);
   }

   public void medical(int var1) throws JDOMException, HibernateException, NamingException, IOException, ParseException {
      this.baseVerrou = true;
      this.razMemoire((String)null);
      if (this.formBakingBeanMedical == null) {
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviMedical");
         this.formBakingBeanMedical = new FormBakingBeanMedical();
         this.formBakingBeanMedical.setutilInitHibernate(this.utilInitHibernate);
         this.formBakingBeanMedical.setBaseLog(this.baseLog);
         this.formBakingBeanMedical.setStructureLog(this.structureLog);
         this.formBakingBeanMedical.setUsersLog(this.usersLog);
         this.formBakingBeanMedical.instanceOptionMedical();
         this.formBakingBeanMedical.recupererExercices(var2);
         if (this.formBakingBeanMedical.getExoselectionne() != null && this.formBakingBeanMedical.getExoselectionne().getExevteId() != 0L) {
            this.formBakingBeanMedical.recupererTousLesItems(var2);
         }

         this.formBakingBeanMedical.setUrlExplorateur(this.urlDocument);
         this.formBakingBeanMedical.setTypeVente(this.typeVente);
         this.formBakingBeanMedical.setVar_memo_id_master(this.var_memo_id_master);
         this.utilInitHibernate.closeSession();
      }

      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      this.formBakingBeanMedical.setFormRecherche(this.formRecherche);
      if (this.formPatients == null) {
         this.formPatients = new FormPatients(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
         this.formPatients.InstancesDaoUtilses();
         this.formPatients.recupererCivilitesItem();
         this.formPatients.recupererPaysItem();
         this.formPatients.recupererPecItem();
         this.formPatients.recupererReglementClient();
         this.formPatients.recupererFamillesClientsItem();
         this.formPatients.recupererUserItem();
      }

      this.formBakingBeanMedical.setFormPatients(this.formPatients);
      if (this.formDocumentsOfficiels == null) {
         this.formDocumentsOfficiels = new FormDocumentsOfficiels(this.baseLog, this.structureLog, this.usersLog, 150, this.urlDocument, this.utilInitHibernate);
      }

      this.formBakingBeanMedical.setFormDocumentsOfficiels(this.formDocumentsOfficiels);
      this.formBakingBeanMedical.menuGaucheMedical(var1);
      this.moduleAffiche = "medical";
      this.affichePage = "/medical/Vide.jsp";
      this.formBakingBeanMedical.setAffichePage(this.affichePage);
   }

   public void gestionMedical() throws IOException, NamingException, JDOMException, HibernateException, ParseException, SAXException {
      this.moduleAffiche = "medical";
      this.formBakingBeanMedical.gestionMedical();
   }

   public void retourExoMedical() throws JDOMException {
      this.moduleAffiche = "admin";
      this.affichePage = "/administration/Vide.jsp";
   }

   public void transfertComptaMedical() throws IOException, SAXException, HibernateException, NamingException, JDOMException, ParseException {
      this.comptabilite(false);
      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      if (this.formBakingBeanComptabilite == null) {
         this.formBakingBeanComptabilite = new FormBakingBeanComptabilite();
         this.formBakingBeanComptabilite.setutilInitHibernate(this.utilInitHibernate);
         this.formBakingBeanComptabilite.setBaseLog(this.baseLog);
         this.formBakingBeanComptabilite.setStructureLog(this.structureLog);
         this.formBakingBeanComptabilite.setUsersLog(this.usersLog);
         this.formBakingBeanComptabilite.InstancesDaoUtilses();
         if (this.rechercheModule(40300)) {
            this.formBakingBeanComptabilite.setModulesCode("40300");
         } else if (!this.rechercheModule(40100)) {
            this.formBakingBeanComptabilite.setModulesCode("40200");
         } else {
            this.formBakingBeanComptabilite.setModulesCode("40100");
         }

         this.formBakingBeanComptabilite.recupererOptionsCompta();
         this.formBakingBeanComptabilite.recupererExercices((Session)null);
         if (this.formBakingBeanComptabilite.getExoselectionne() != null && this.formBakingBeanComptabilite.getExoselectionne().getExecpt_id() != 0L) {
            this.formBakingBeanComptabilite.recupererTousLesItems((Session)null);
         }

         this.formBakingBeanComptabilite.setUrlExplorateur(this.urlDocument);
         this.formBakingBeanComptabilite.setTypeVente(this.typeVente);
      }

      this.formBakingBeanComptabilite.setFormRecherche(this.formRecherche);
      this.formBakingBeanComptabilite.preparationTransfertMedical(this.formBakingBeanMedical.getFormTransfertMedical().getListDocument());
   }

   public void ajouterConsultationDirecte() throws JDOMException, IOException, HibernateException, NamingException, ParseException, SAXException {
      if (this.formBakingBeanTiers.getFormPatients().getPatients() != null) {
         this.baseVerrou = true;
         new Patients();
         Patients var1 = this.formBakingBeanTiers.getFormPatients().getPatients();
         this.razMemoire("formBakingBeanMedical");
         if (this.formBakingBeanMedical == null) {
            Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviMedical");
            this.formBakingBeanMedical = new FormBakingBeanMedical();
            this.formBakingBeanMedical.setutilInitHibernate(this.utilInitHibernate);
            this.formBakingBeanMedical.setBaseLog(this.baseLog);
            this.formBakingBeanMedical.setStructureLog(this.structureLog);
            this.formBakingBeanMedical.setUsersLog(this.usersLog);
            this.formBakingBeanMedical.instanceOptionMedical();
            this.formBakingBeanMedical.recupererExercices(var2);
            this.formBakingBeanMedical.recupererTousLesItems(var2);
            this.formBakingBeanMedical.setUrlExplorateur(this.urlDocument);
            this.formBakingBeanMedical.setTypeVente(this.typeVente);
            this.utilInitHibernate.closeSession();
         }

         if (this.formPatients == null) {
            this.formPatients = new FormPatients(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
            this.formPatients.InstancesDaoUtilses();
            this.formPatients.recupererCivilitesItem();
            this.formPatients.recupererPaysItem();
            this.formPatients.recupererPecItem();
            this.formPatients.recupererReglementClient();
            this.formPatients.recupererFamillesClientsItem();
            this.formPatients.recupererUserItem();
         }

         this.formBakingBeanMedical.menuGaucheMedical(this.menuModule.getCode());
         this.formBakingBeanMedical.setFormPatients(this.formPatients);
         this.moduleAffiche = "medical";
         this.affichePage = "/medical/Vide.jsp";
         this.formBakingBeanMedical.setAffichePage(this.affichePage);
         ObjetLigneMenu var3 = new ObjetLigneMenu();
         var3.setCommande("81500:02");
         var3.setPagemenu("CGENE");
         var3.setAdd(true);
         var3.setMaj(true);
         var3.setSup(true);
         var3.setDup(true);
         var3.setClo(true);
         var3.setTrf(true);
         var3.setImp(true);
         this.formBakingBeanMedical.setPatientsEnCours(var1);
         this.formBakingBeanMedical.gestionMedicalFree(var3);
      }

   }

   public void ajouterPharmacieDirecte() throws JDOMException, IOException, HibernateException, NamingException, ParseException, SAXException {
      if (this.formBakingBeanTiers.getFormPatients().getPatients() != null) {
         this.baseVerrou = true;
         new Patients();
         Patients var1 = this.formBakingBeanTiers.getFormPatients().getPatients();
         this.razMemoire("formBakingBeanMedical");
         if (this.formBakingBeanMedical == null) {
            Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviMedical");
            this.formBakingBeanMedical = new FormBakingBeanMedical();
            this.formBakingBeanMedical.setutilInitHibernate(this.utilInitHibernate);
            this.formBakingBeanMedical.setBaseLog(this.baseLog);
            this.formBakingBeanMedical.setStructureLog(this.structureLog);
            this.formBakingBeanMedical.setUsersLog(this.usersLog);
            this.formBakingBeanMedical.instanceOptionMedical();
            this.formBakingBeanMedical.recupererExercices(var2);
            this.formBakingBeanMedical.recupererTousLesItems(var2);
            this.formBakingBeanMedical.setUrlExplorateur(this.urlDocument);
            this.formBakingBeanMedical.setTypeVente(this.typeVente);
            this.utilInitHibernate.closeSession();
         }

         if (this.formPatients == null) {
            this.formPatients = new FormPatients(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
            this.formPatients.InstancesDaoUtilses();
            this.formPatients.recupererCivilitesItem();
            this.formPatients.recupererPaysItem();
            this.formPatients.recupererPecItem();
            this.formPatients.recupererReglementClient();
            this.formPatients.recupererFamillesClientsItem();
            this.formPatients.recupererUserItem();
         }

         this.formBakingBeanMedical.menuGaucheMedical(this.menuModule.getCode());
         this.formBakingBeanMedical.setFormPatients(this.formPatients);
         this.moduleAffiche = "medical";
         this.affichePage = "/medical/Vide.jsp";
         this.formBakingBeanMedical.setAffichePage(this.affichePage);
         ObjetLigneMenu var3 = new ObjetLigneMenu();
         var3.setCommande("81500:04");
         var3.setPagemenu("PHARMACIE");
         var3.setAdd(true);
         var3.setMaj(true);
         var3.setSup(true);
         var3.setDup(true);
         var3.setClo(true);
         var3.setTrf(true);
         var3.setImp(true);
         this.formBakingBeanMedical.setPatientsEnCours(var1);
         this.formBakingBeanMedical.gestionMedicalFree(var3);
      }

   }

   public void ajouterLaboratoireDirecte() throws JDOMException, IOException, HibernateException, NamingException, ParseException, SAXException {
      if (this.formBakingBeanTiers.getFormPatients().getPatients() != null) {
         this.baseVerrou = true;
         new Patients();
         Patients var1 = this.formBakingBeanTiers.getFormPatients().getPatients();
         this.razMemoire("formBakingBeanMedical");
         if (this.formBakingBeanMedical == null) {
            Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviMedical");
            this.formBakingBeanMedical = new FormBakingBeanMedical();
            this.formBakingBeanMedical.setutilInitHibernate(this.utilInitHibernate);
            this.formBakingBeanMedical.setBaseLog(this.baseLog);
            this.formBakingBeanMedical.setStructureLog(this.structureLog);
            this.formBakingBeanMedical.setUsersLog(this.usersLog);
            this.formBakingBeanMedical.instanceOptionMedical();
            this.formBakingBeanMedical.recupererExercices(var2);
            this.formBakingBeanMedical.recupererTousLesItems(var2);
            this.formBakingBeanMedical.setUrlExplorateur(this.urlDocument);
            this.formBakingBeanMedical.setTypeVente(this.typeVente);
            this.utilInitHibernate.closeSession();
         }

         if (this.formPatients == null) {
            this.formPatients = new FormPatients(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
            this.formPatients.InstancesDaoUtilses();
            this.formPatients.recupererCivilitesItem();
            this.formPatients.recupererPaysItem();
            this.formPatients.recupererPecItem();
            this.formPatients.recupererReglementClient();
            this.formPatients.recupererFamillesClientsItem();
            this.formPatients.recupererUserItem();
         }

         this.formBakingBeanMedical.menuGaucheMedical(this.menuModule.getCode());
         this.formBakingBeanMedical.setFormPatients(this.formPatients);
         this.moduleAffiche = "medical";
         this.affichePage = "/medical/Vide.jsp";
         this.formBakingBeanMedical.setAffichePage(this.affichePage);
         ObjetLigneMenu var3 = new ObjetLigneMenu();
         var3.setCommande("81500:05");
         var3.setPagemenu("LABORATOIRE");
         var3.setAdd(true);
         var3.setMaj(true);
         var3.setSup(true);
         var3.setDup(true);
         var3.setClo(true);
         var3.setTrf(true);
         var3.setImp(true);
         this.formBakingBeanMedical.setPatientsEnCours(var1);
         this.formBakingBeanMedical.gestionMedicalFree(var3);
      }

   }

   public void ajouterLaboratoireConsultation() throws JDOMException, IOException, HibernateException, NamingException, ParseException, SAXException {
      if (this.formBakingBeanMedical.getFormConsultationGene().getPatients() != null) {
         this.baseVerrou = true;
         new Patients();
         Patients var1 = this.formBakingBeanMedical.getFormConsultationGene().getPatients();
         new ConsultationEnteteGene();
         ConsultationEnteteGene var2 = this.formBakingBeanMedical.getFormConsultationGene().getConsultationEnteteGene();
         this.razMemoire("formBakingBeanMedical");
         if (this.formBakingBeanMedical == null) {
            Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviMedical");
            this.formBakingBeanMedical = new FormBakingBeanMedical();
            this.formBakingBeanMedical.setutilInitHibernate(this.utilInitHibernate);
            this.formBakingBeanMedical.setBaseLog(this.baseLog);
            this.formBakingBeanMedical.setStructureLog(this.structureLog);
            this.formBakingBeanMedical.setUsersLog(this.usersLog);
            this.formBakingBeanMedical.instanceOptionMedical();
            this.formBakingBeanMedical.recupererExercices(var3);
            this.formBakingBeanMedical.recupererTousLesItems(var3);
            this.formBakingBeanMedical.setUrlExplorateur(this.urlDocument);
            this.formBakingBeanMedical.setTypeVente(this.typeVente);
            this.utilInitHibernate.closeSession();
         }

         if (this.formPatients == null) {
            this.formPatients = new FormPatients(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
            this.formPatients.InstancesDaoUtilses();
            this.formPatients.recupererCivilitesItem();
            this.formPatients.recupererPaysItem();
            this.formPatients.recupererPecItem();
            this.formPatients.recupererReglementClient();
            this.formPatients.recupererFamillesClientsItem();
            this.formPatients.recupererUserItem();
         }

         this.formBakingBeanMedical.menuGaucheMedical(this.menuModule.getCode());
         this.formBakingBeanMedical.setFormPatients(this.formPatients);
         this.moduleAffiche = "medical";
         this.affichePage = "/medical/Vide.jsp";
         this.formBakingBeanMedical.setAffichePage(this.affichePage);
         ObjetLigneMenu var4 = new ObjetLigneMenu();
         var4.setCommande("81500:05");
         var4.setPagemenu("LABORATOIRE");
         var4.setAdd(true);
         var4.setMaj(true);
         var4.setSup(true);
         var4.setDup(true);
         var4.setClo(true);
         var4.setTrf(true);
         var4.setImp(true);
         this.formBakingBeanMedical.setPatientsEnCours(var1);
         this.formBakingBeanMedical.gestionMedicalFree(var4);
      }

   }

   public void ajouterConsultationLaboratoire() throws JDOMException, IOException, HibernateException, NamingException, ParseException, SAXException {
      if (this.formBakingBeanMedical.getFormLaboratoire().getPatients() != null) {
         this.baseVerrou = true;
         new Patients();
         Patients var1 = this.formBakingBeanMedical.getFormLaboratoire().getPatients();
         new LaboratoireEntete();
         LaboratoireEntete var2 = this.formBakingBeanMedical.getFormLaboratoire().getLaboratoireEntete();
         this.razMemoire("formBakingBeanMedical");
         if (this.formBakingBeanMedical == null) {
            Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviMedical");
            this.formBakingBeanMedical = new FormBakingBeanMedical();
            this.formBakingBeanMedical.setutilInitHibernate(this.utilInitHibernate);
            this.formBakingBeanMedical.setBaseLog(this.baseLog);
            this.formBakingBeanMedical.setStructureLog(this.structureLog);
            this.formBakingBeanMedical.setUsersLog(this.usersLog);
            this.formBakingBeanMedical.instanceOptionMedical();
            this.formBakingBeanMedical.recupererExercices(var3);
            this.formBakingBeanMedical.recupererTousLesItems(var3);
            this.formBakingBeanMedical.setUrlExplorateur(this.urlDocument);
            this.formBakingBeanMedical.setTypeVente(this.typeVente);
            this.utilInitHibernate.closeSession();
         }

         if (this.formPatients == null) {
            this.formPatients = new FormPatients(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
            this.formPatients.InstancesDaoUtilses();
            this.formPatients.recupererCivilitesItem();
            this.formPatients.recupererPaysItem();
            this.formPatients.recupererPecItem();
            this.formPatients.recupererReglementClient();
            this.formPatients.recupererFamillesClientsItem();
            this.formPatients.recupererUserItem();
         }

         this.formBakingBeanMedical.menuGaucheMedical(this.menuModule.getCode());
         this.formBakingBeanMedical.setFormPatients(this.formPatients);
         this.moduleAffiche = "medical";
         this.affichePage = "/medical/Vide.jsp";
         this.formBakingBeanMedical.setAffichePage(this.affichePage);
         ObjetLigneMenu var4 = new ObjetLigneMenu();
         var4.setCommande("81500:02");
         var4.setPagemenu("CGENE");
         var4.setAdd(true);
         var4.setMaj(true);
         var4.setSup(true);
         var4.setDup(true);
         var4.setClo(true);
         var4.setTrf(true);
         var4.setImp(true);
         this.formBakingBeanMedical.setPatientsEnCours(var1);
         this.formBakingBeanMedical.gestionMedicalFree(var4);
      }

   }

   public void ajouterHospitalisationDirecte() throws JDOMException, IOException, HibernateException, NamingException, ParseException, SAXException {
      if (this.formBakingBeanTiers.getFormPatients().getPatients() != null) {
         this.baseVerrou = true;
         new Patients();
         Patients var1 = this.formBakingBeanTiers.getFormPatients().getPatients();
         this.razMemoire("formBakingBeanMedical");
         if (this.formBakingBeanMedical == null) {
            Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviMedical");
            this.formBakingBeanMedical = new FormBakingBeanMedical();
            this.formBakingBeanMedical.setutilInitHibernate(this.utilInitHibernate);
            this.formBakingBeanMedical.setBaseLog(this.baseLog);
            this.formBakingBeanMedical.setStructureLog(this.structureLog);
            this.formBakingBeanMedical.setUsersLog(this.usersLog);
            this.formBakingBeanMedical.instanceOptionMedical();
            this.formBakingBeanMedical.recupererExercices(var2);
            this.formBakingBeanMedical.recupererTousLesItems(var2);
            this.formBakingBeanMedical.setUrlExplorateur(this.urlDocument);
            this.formBakingBeanMedical.setTypeVente(this.typeVente);
            this.utilInitHibernate.closeSession();
         }

         if (this.formPatients == null) {
            this.formPatients = new FormPatients(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
            this.formPatients.InstancesDaoUtilses();
            this.formPatients.recupererCivilitesItem();
            this.formPatients.recupererPaysItem();
            this.formPatients.recupererPecItem();
            this.formPatients.recupererReglementClient();
            this.formPatients.recupererFamillesClientsItem();
            this.formPatients.recupererUserItem();
         }

         if (this.formRecherche == null) {
            this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
         }

         this.formBakingBeanMedical.setFormRecherche(this.formRecherche);
         boolean var6 = false;
         if (var1 != null) {
            HospitalisationEnteteDao var3 = new HospitalisationEnteteDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            List var4 = var3.chargerLesMvtsPatients(var1, (Session)null);
            if (var4.size() != 0) {
               for(int var5 = 0; var5 < var4.size(); ++var5) {
                  if (((HospitalisationEntete)var4.get(var5)).getHosEtat() != 2 && ((HospitalisationEntete)var4.get(var5)).getHosEtat() != 3 && ((HospitalisationEntete)var4.get(var5)).getHosDateSortie() == null) {
                     var6 = true;
                     break;
                  }
               }
            }
         }

         if (!var6) {
            this.formBakingBeanMedical.menuGaucheMedical(this.menuModule.getCode());
            this.formBakingBeanMedical.setFormPatients(this.formPatients);
            this.moduleAffiche = "medical";
            this.affichePage = "/medical/Vide.jsp";
            this.formBakingBeanMedical.setAffichePage(this.affichePage);
            ObjetLigneMenu var7 = new ObjetLigneMenu();
            var7.setCommande("81500:07");
            var7.setPagemenu("HOSPITALISATION");
            var7.setAdd(true);
            var7.setMaj(true);
            var7.setSup(true);
            var7.setDup(true);
            var7.setClo(true);
            var7.setTrf(true);
            var7.setImp(true);
            this.formBakingBeanMedical.setPatientsEnCours(var1);
            this.formBakingBeanMedical.gestionMedicalFree(var7);
         } else {
            this.formRecherche.setMessageTexte("La dernière hospitalisation n'est pas cloturée. Une nouvelle hospitalisation sur ce patient est impossible. Veuillez vous rapprocher du bureau des entrées pour statuer sur la dernière hospitalisation.");
            this.formRecherche.setShowModalPanelMessage(true);
         }
      }

   }

   public void education() throws JDOMException, HibernateException, NamingException, IOException, ParseException {
      this.baseVerrou = true;
      this.razMemoire((String)null);
      if (this.formBakingBeanEducation == null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviEducation");
         this.formBakingBeanEducation = new FormBakingBeanEducation();
         this.formBakingBeanEducation.setutilInitHibernate(this.utilInitHibernate);
         this.formBakingBeanEducation.setBaseLog(this.baseLog);
         this.formBakingBeanEducation.setStructureLog(this.structureLog);
         this.formBakingBeanEducation.setUsersLog(this.usersLog);
         this.formBakingBeanEducation.instanceOptionEducation();
         this.formBakingBeanEducation.recupererExercices(var1);
         if (this.formBakingBeanEducation.getExoselectionne() != null && this.formBakingBeanEducation.getExoselectionne().getExevteId() != 0L) {
            this.formBakingBeanEducation.recupererTousLesItems(var1);
         }

         this.formBakingBeanEducation.setUrlExplorateur(this.urlDocument);
         this.formBakingBeanEducation.setTypeVente(this.typeVente);
         this.formBakingBeanEducation.setVar_memo_id_master(this.var_memo_id_master);
         this.utilInitHibernate.closeSession();
      }

      if (this.formDocumentsOfficiels == null) {
         this.formDocumentsOfficiels = new FormDocumentsOfficiels(this.baseLog, this.structureLog, this.usersLog, 100, this.urlDocument, this.utilInitHibernate);
      }

      this.formBakingBeanEducation.setFormDocumentsOfficiels(this.formDocumentsOfficiels);
      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      this.formBakingBeanEducation.setFormRecherche(this.formRecherche);
      this.formBakingBeanEducation.menuGaucheEducation();
      this.moduleAffiche = "education";
      this.affichePage = "/education/Vide.jsp";
      this.formBakingBeanEducation.setAffichePage(this.affichePage);
   }

   public void gestionEducation() throws IOException, NamingException, JDOMException, ParseException {
      this.moduleAffiche = "education";
      this.formBakingBeanEducation.gestionEducation();
   }

   public void retourExoEducation() throws JDOMException {
      this.moduleAffiche = "admin";
      this.affichePage = "/administration/Vide.jsp";
   }

   public void microfinance() throws IOException, HibernateException, NamingException, ParseException, JDOMException {
      this.baseVerrou = true;
      this.razMemoire((String)null);
      if (this.formBakingBeanMicroFinance == null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviMicrofinance");
         this.formBakingBeanMicroFinance = new FormBakingBeanMicroFinance();
         this.formBakingBeanMicroFinance.setutilInitHibernate(this.utilInitHibernate);
         this.formBakingBeanMicroFinance.setBaseLog(this.baseLog);
         this.formBakingBeanMicroFinance.setStructureLog(this.structureLog);
         this.formBakingBeanMicroFinance.setUsersLog(this.usersLog);
         this.formBakingBeanMicroFinance.instanceOptionMicrofinance();
         this.formBakingBeanMicroFinance.recupererExercices(var1);
         if (this.formBakingBeanMicroFinance.getExoselectionne() != null && this.formBakingBeanMicroFinance.getExoselectionne().getExevteId() != 0L) {
            this.formBakingBeanMicroFinance.recupererTousLesItems(var1);
         }

         this.formBakingBeanMicroFinance.setUrlExplorateur(this.urlDocument);
         this.formBakingBeanMicroFinance.setTypeVente(this.typeVente);
         this.utilInitHibernate.closeSession();
      }

      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      this.formBakingBeanMicroFinance.menuGaucheMicroFinance();
      this.formBakingBeanMicroFinance.setFormRecherche(this.formRecherche);
      this.moduleAffiche = "microfinance";
      this.affichePage = "/microfinance/Vide.jsp";
      this.formBakingBeanMicroFinance.setAffichePage(this.affichePage);
   }

   public void gestionMicrofinance() throws IOException, NamingException, JDOMException {
      this.moduleAffiche = "microfinance";
      this.formBakingBeanMicroFinance.gestionMicroFinance();
   }

   public void retourExoMicrofinance() throws ParseException {
      this.moduleAffiche = "admin";
      this.affichePage = "/administration/Vide.jsp";
   }

   public void parcs() throws IOException, SAXException, HibernateException, NamingException, JDOMException {
      this.baseVerrou = true;
      this.razMemoire((String)null);
      if (this.formBakingBeanParcs == null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviParcs");
         this.formBakingBeanParcs = new FormBakingBeanParcs();
         this.formBakingBeanParcs.setutilInitHibernate(this.utilInitHibernate);
         this.formBakingBeanParcs.setBaseLog(this.baseLog);
         this.formBakingBeanParcs.setStructureLog(this.structureLog);
         this.formBakingBeanParcs.setUsersLog(this.usersLog);
         this.formBakingBeanParcs.InstancesDaoUtilses();
         this.formBakingBeanParcs.recupererExercices(var1);
         if (this.formBakingBeanParcs.getExoselectionne() != null && this.formBakingBeanParcs.getExoselectionne().getExeprcId() != 0L) {
            this.formBakingBeanParcs.recupererTousLesItems(var1);
         }

         this.formBakingBeanParcs.setUrlExplorateur(this.urlDocument);
         this.formBakingBeanParcs.setTypeVente(this.typeVente);
         this.formBakingBeanParcs.setVar_memo_id_master(this.var_memo_id_master);
         this.utilInitHibernate.closeSession();
      }

      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      this.formBakingBeanParcs.menuGaucheParcs();
      this.formBakingBeanParcs.setFormRecherche(this.formRecherche);
      this.affichePage = "/parc/Vide.jsp";
      this.moduleAffiche = "parcs";
      this.formBakingBeanParcs.setAffichePage(this.affichePage);
   }

   public void gestionParcs() throws IOException, SAXException, NamingException, JDOMException, HibernateException, ParseException {
      this.moduleAffiche = "parcs";
      this.formBakingBeanParcs.gestionParc();
   }

   public void retourExoParcs() throws ParseException {
      this.moduleAffiche = "admin";
      this.affichePage = "/administration/Vide.jsp";
   }

   public void caisse() throws IOException, SAXException, HibernateException, NamingException, JDOMException {
      this.baseVerrou = true;
      this.razMemoire((String)null);
      if (this.usersLog.getUsrCaissier() == 1 && this.usersLog.getGroupe().getGrpModuleCai() != 0) {
         if (this.formBakingBeanCaisse == null) {
            Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviCaisse");
            this.formBakingBeanCaisse = new FormBakingBeanCaisse();
            this.formBakingBeanCaisse.setutilInitHibernate(this.utilInitHibernate);
            this.formBakingBeanCaisse.setBaseLog(this.baseLog);
            this.formBakingBeanCaisse.setStructureLog(this.structureLog);
            this.formBakingBeanCaisse.setUsersLog(this.usersLog);
            this.formBakingBeanCaisse.InstancesDaoUtilses();
            this.formBakingBeanCaisse.recupererExercices(var1);
            if (this.formBakingBeanCaisse.getExoselectionne() != null && this.formBakingBeanCaisse.getExoselectionne().getExecaiId() != 0L) {
               this.formBakingBeanCaisse.recupererTousLesItems(var1);
            }

            this.formBakingBeanCaisse.setUrlExplorateur(this.urlDocument);
            this.formBakingBeanCaisse.setTypeVente(this.typeVente);
            this.utilInitHibernate.closeSession();
         }

         if (this.formRecherche == null) {
            this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
         }

         if ((this.menuModule.getCode() == 90000 || this.menuModule.getCode() == 90100) && this.usersLog.getUsrCaissier() == 1 && this.usersLog.getGroupe().getGrpModuleCai() == 1) {
            this.formBakingBeanCaisse.menuGaucheCaisse();
         } else if ((this.menuModule.getCode() == 90000 || this.menuModule.getCode() == 90100) && this.usersLog.getUsrCaissier() == 1 && this.usersLog.getGroupe().getGrpModuleCai() == 2) {
            this.menuModule.setCode(90100);
            this.formBakingBeanCaisse.menuGaucheCaisseGuest();
         }

         this.formBakingBeanCaisse.setFormRecherche(this.formRecherche);
         this.moduleAffiche = "caisse";
         this.affichePage = "/caisse/Vide.jsp";
         this.formBakingBeanCaisse.setAffichePage(this.affichePage);
      } else {
         this.formBakingBeanCaisse = new FormBakingBeanCaisse();
         this.formBakingBeanCaisse.setutilInitHibernate(this.utilInitHibernate);
         this.formBakingBeanCaisse.setBaseLog(this.baseLog);
         this.formBakingBeanCaisse.setStructureLog(this.structureLog);
         this.formBakingBeanCaisse.setUsersLog(this.usersLog);
         this.formBakingBeanCaisse.InstancesDaoUtilses();
         this.moduleAffiche = "caisse";
         this.affichePage = "/caisse/Vide.jsp";
         this.formBakingBeanCaisse.setAffichePage(this.affichePage);
      }

   }

   public void gestionCaisse() throws IOException, SAXException, HibernateException, NamingException, JDOMException, ParseException {
      this.moduleAffiche = "caisse";
      this.formBakingBeanCaisse.gestionCaisse();
   }

   public void retourExoCaisse() throws ParseException {
      this.moduleAffiche = "admin";
      this.affichePage = "/administration/Vide.jsp";
   }

   public void transfertComptaCaisse() throws IOException, SAXException, HibernateException, NamingException, JDOMException, ParseException {
      this.comptabilite(false);
      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      if (this.formBakingBeanComptabilite == null) {
         this.formBakingBeanComptabilite = new FormBakingBeanComptabilite();
         this.formBakingBeanComptabilite.setutilInitHibernate(this.utilInitHibernate);
         this.formBakingBeanComptabilite.setBaseLog(this.baseLog);
         this.formBakingBeanComptabilite.setStructureLog(this.structureLog);
         this.formBakingBeanComptabilite.setUsersLog(this.usersLog);
         this.formBakingBeanComptabilite.InstancesDaoUtilses();
         if (this.rechercheModule(40300)) {
            this.formBakingBeanComptabilite.setModulesCode("40300");
         } else if (!this.rechercheModule(40100)) {
            this.formBakingBeanComptabilite.setModulesCode("40200");
         } else {
            this.formBakingBeanComptabilite.setModulesCode("40100");
         }

         this.formBakingBeanComptabilite.recupererOptionsCompta();
         this.formBakingBeanComptabilite.recupererExercices((Session)null);
         if (this.formBakingBeanComptabilite.getExoselectionne() != null && this.formBakingBeanComptabilite.getExoselectionne().getExecpt_id() != 0L) {
            this.formBakingBeanComptabilite.recupererTousLesItems((Session)null);
         }

         this.formBakingBeanComptabilite.setUrlExplorateur(this.urlDocument);
         this.formBakingBeanComptabilite.setTypeVente(this.typeVente);
      }

      this.formBakingBeanComptabilite.setFormRecherche(this.formRecherche);
      this.formBakingBeanComptabilite.preparationTransfertCaisse(this.formBakingBeanCaisse.getFormTransfertCaisse().getListDocument());
   }

   public void paye() throws IOException, SAXException, HibernateException, NamingException, JDOMException {
      this.baseVerrou = true;
      this.razMemoire((String)null);
      if (this.formBakingBeanPaye == null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviPaye");
         this.formBakingBeanPaye = new FormBakingBeanPaye();
         this.formBakingBeanPaye.setutilInitHibernate(this.utilInitHibernate);
         this.formBakingBeanPaye.setBaseLog(this.baseLog);
         this.formBakingBeanPaye.setStructureLog(this.structureLog);
         this.formBakingBeanPaye.setUsersLog(this.usersLog);
         this.formBakingBeanPaye.InstancesDaoUtilses();
         this.formBakingBeanPaye.recupererExercices(var1);
         if (this.formBakingBeanPaye.getExoselectionne() != null && this.formBakingBeanPaye.getExoselectionne().getExepayId() != 0L) {
            this.formBakingBeanPaye.recupererTousLesItems(var1);
         }

         this.formBakingBeanPaye.setUrlExplorateur(this.urlDocument);
         this.formBakingBeanPaye.setTypeVente(this.typeVente);
         this.utilInitHibernate.closeSession();
      }

      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      if (this.formDocumentsOfficiels == null) {
         this.formDocumentsOfficiels = new FormDocumentsOfficiels(this.baseLog, this.structureLog, this.usersLog, 80, this.urlDocument, this.utilInitHibernate);
      }

      this.formBakingBeanPaye.setFormDocumentsOfficiels(this.formDocumentsOfficiels);
      if (this.usersLog.getUsrIdSalarieGuest() != 0L) {
         this.menuModule.setCode(50100);
         this.formBakingBeanPaye.menuGauchePayeGuest();
      } else if (this.menuModule.getCode() == 50000) {
         this.formBakingBeanPaye.menuGauchePaye();
      } else if (this.menuModule.getCode() == 50300) {
         this.formBakingBeanPaye.menuGauchePayeRoster();
      }

      this.formBakingBeanPaye.setFormRecherche(this.formRecherche);
      this.affichePage = "/paye/Vide.jsp";
      this.moduleAffiche = "paye";
      this.formBakingBeanPaye.setAffichePage(this.affichePage);
   }

   public void temps() throws IOException, SAXException, HibernateException, NamingException, JDOMException {
      this.baseVerrou = true;
      this.razMemoire((String)null);
      if (this.formBakingBeanPaye == null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviPaye");
         this.formBakingBeanPaye = new FormBakingBeanPaye();
         this.formBakingBeanPaye.setutilInitHibernate(this.utilInitHibernate);
         this.formBakingBeanPaye.setBaseLog(this.baseLog);
         this.formBakingBeanPaye.setStructureLog(this.structureLog);
         this.formBakingBeanPaye.setUsersLog(this.usersLog);
         this.formBakingBeanPaye.InstancesDaoUtilses();
         this.formBakingBeanPaye.recupererExercices(var1);
         if (this.formBakingBeanPaye.getExoselectionne() != null && this.formBakingBeanPaye.getExoselectionne().getExepayId() != 0L) {
            this.formBakingBeanPaye.recupererTousLesItems(var1);
         }

         this.formBakingBeanPaye.setUrlExplorateur(this.urlDocument);
         this.formBakingBeanPaye.setTypeVente(this.typeVente);
         this.utilInitHibernate.closeSession();
      }

      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      if (this.formDocumentsOfficiels == null) {
         this.formDocumentsOfficiels = new FormDocumentsOfficiels(this.baseLog, this.structureLog, this.usersLog, 80, this.urlDocument, this.utilInitHibernate);
      }

      this.formBakingBeanPaye.setFormDocumentsOfficiels(this.formDocumentsOfficiels);
      this.formBakingBeanPaye.menuGauchePayeTemps();
      this.formBakingBeanPaye.setFormRecherche(this.formRecherche);
      this.affichePage = "/paye/Vide.jsp";
      this.moduleAffiche = "paye";
      this.formBakingBeanPaye.setAffichePage(this.affichePage);
   }

   public void gestionPaye() throws IOException, SAXException, NamingException, JDOMException, HibernateException, ParseException {
      this.moduleAffiche = "paye";
      this.formBakingBeanPaye.gestionPaye();
   }

   public void retourExoPaye() throws ParseException {
      this.moduleAffiche = "admin";
      this.affichePage = "/administration/Vide.jsp";
   }

   public void transfertComptaPaye() throws IOException, SAXException, HibernateException, NamingException, JDOMException, ParseException {
      this.comptabilite(false);
      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      if (this.formBakingBeanComptabilite == null) {
         this.formBakingBeanComptabilite = new FormBakingBeanComptabilite();
         this.formBakingBeanComptabilite.setutilInitHibernate(this.utilInitHibernate);
         this.formBakingBeanComptabilite.setBaseLog(this.baseLog);
         this.formBakingBeanComptabilite.setStructureLog(this.structureLog);
         this.formBakingBeanComptabilite.setUsersLog(this.usersLog);
         this.formBakingBeanComptabilite.InstancesDaoUtilses();
         if (this.rechercheModule(40300)) {
            this.formBakingBeanComptabilite.setModulesCode("40300");
         } else if (!this.rechercheModule(40100)) {
            this.formBakingBeanComptabilite.setModulesCode("40200");
         } else {
            this.formBakingBeanComptabilite.setModulesCode("40100");
         }

         this.formBakingBeanComptabilite.recupererOptionsCompta();
         this.formBakingBeanComptabilite.recupererExercices((Session)null);
         if (this.formBakingBeanComptabilite.getExoselectionne() != null && this.formBakingBeanComptabilite.getExoselectionne().getExecpt_id() != 0L) {
            this.formBakingBeanComptabilite.recupererTousLesItems((Session)null);
         }

         this.formBakingBeanComptabilite.setUrlExplorateur(this.urlDocument);
         this.formBakingBeanComptabilite.setTypeVente(this.typeVente);
      }

      this.formBakingBeanComptabilite.setFormRecherche(this.formRecherche);
      this.formBakingBeanComptabilite.preparationTransfertPaye(this.formBakingBeanPaye.getFormTransfertBulletin().getListDocument());
   }

   public void transfertVariablePaye() throws IOException, SAXException, HibernateException, NamingException, JDOMException {
      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      this.formBakingBeanPaye.setFormRecherche(this.formRecherche);
      this.formBakingBeanPaye.getFormTransfertBulletin().importerVariables();
   }

   public void transfertRubriquePaye() throws IOException, SAXException, HibernateException, NamingException, JDOMException, ParseException {
      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      this.formBakingBeanPaye.setFormRecherche(this.formRecherche);
      this.formBakingBeanPaye.getFormTransfertBulletin().importerRubrique();
   }

   public void transfertImportLibre() throws IOException, SAXException, HibernateException, NamingException, JDOMException, ParseException {
      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      this.formBakingBeanPaye.setFormRecherche(this.formRecherche);
      this.formBakingBeanPaye.getFormTransfertBulletin().importLibre();
   }

   public void transfertImportPointageOmega() throws IOException, SAXException, HibernateException, NamingException, JDOMException, ParseException {
      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      this.formBakingBeanPaye.setFormRecherche(this.formRecherche);
      this.formBakingBeanPaye.getFormTransfertBulletin().transfertImportPointageOmega();
   }

   public void location() throws IOException, SAXException, HibernateException, NamingException, JDOMException, ParseException {
      this.baseVerrou = true;
      this.razMemoire((String)null);
      this.formBakingBeanAchats = null;
      if (this.formBakingBeanImmobilier == null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviCommImm");
         this.formBakingBeanImmobilier = new FormBakingBeanImmobilier();
         this.formBakingBeanImmobilier.setutilInitHibernate(this.utilInitHibernate);
         this.formBakingBeanImmobilier.setBaseLog(this.baseLog);
         this.formBakingBeanImmobilier.setStructureLog(this.structureLog);
         this.formBakingBeanImmobilier.setUsersLog(this.usersLog);
         this.formBakingBeanImmobilier.InstancesDaoUtilses();
         this.formBakingBeanImmobilier.setCategorie(0);
         this.formBakingBeanImmobilier.recupererExercices(var1);
         if (this.formBakingBeanImmobilier.getExoselectionne() != null && this.formBakingBeanImmobilier.getExoselectionne().getExevteId() != 0L) {
            this.formBakingBeanImmobilier.recupererTousLesItems(var1);
         }

         this.formBakingBeanImmobilier.setUrlExplorateur(this.urlDocument);
         this.formBakingBeanImmobilier.setTypeVente(this.typeVente);
         this.utilInitHibernate.closeSession();
      }

      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      if (this.formDocumentsOfficiels == null) {
         this.formDocumentsOfficiels = new FormDocumentsOfficiels(this.baseLog, this.structureLog, this.usersLog, 160, this.urlDocument, this.utilInitHibernate);
      }

      this.formBakingBeanImmobilier.menuGaucheLocation();
      this.formBakingBeanImmobilier.setFormRecherche(this.formRecherche);
      this.formBakingBeanImmobilier.setFormDocumentsOfficiels(this.formDocumentsOfficiels);
      this.affichePage = "/immobilier/Vide.jsp";
      this.moduleAffiche = "immobilierLocation";
      this.formBakingBeanImmobilier.setAffichePage(this.affichePage);
   }

   public void gestionLocation() throws IOException, SAXException, NamingException, JDOMException, HibernateException, org.apache.velocity.runtime.parser.ParseException, ParseException {
      this.formBakingBeanImmobilier.gestionLocation();
      this.moduleAffiche = "immobilierLocation";
   }

   public void syndic() throws IOException, SAXException, HibernateException, NamingException, JDOMException, ParseException {
      this.baseVerrou = true;
      this.razMemoire((String)null);
      this.formBakingBeanAchats = null;
      if (this.formBakingBeanImmobilier == null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviCommImm");
         this.formBakingBeanImmobilier = new FormBakingBeanImmobilier();
         this.formBakingBeanImmobilier.setutilInitHibernate(this.utilInitHibernate);
         this.formBakingBeanImmobilier.setBaseLog(this.baseLog);
         this.formBakingBeanImmobilier.setStructureLog(this.structureLog);
         this.formBakingBeanImmobilier.setUsersLog(this.usersLog);
         this.formBakingBeanImmobilier.InstancesDaoUtilses();
         this.formBakingBeanImmobilier.setCategorie(1);
         this.formBakingBeanImmobilier.recupererExercices(var1);
         if (this.formBakingBeanImmobilier.getExoselectionne() != null && this.formBakingBeanImmobilier.getExoselectionne().getExevteId() != 0L) {
            this.formBakingBeanImmobilier.recupererTousLesItems(var1);
         }

         this.formBakingBeanImmobilier.setUrlExplorateur(this.urlDocument);
         this.formBakingBeanImmobilier.setTypeVente(this.typeVente);
         this.utilInitHibernate.closeSession();
      }

      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      if (this.formDocumentsOfficiels == null) {
         this.formDocumentsOfficiels = new FormDocumentsOfficiels(this.baseLog, this.structureLog, this.usersLog, 170, this.urlDocument, this.utilInitHibernate);
      }

      this.formBakingBeanImmobilier.menuGaucheSyndic();
      this.formBakingBeanImmobilier.setFormRecherche(this.formRecherche);
      this.formBakingBeanImmobilier.setFormDocumentsOfficiels(this.formDocumentsOfficiels);
      this.affichePage = "/immobilier/Vide.jsp";
      this.moduleAffiche = "immobilierSyndic";
      this.formBakingBeanImmobilier.setAffichePage(this.affichePage);
   }

   public void gestionSyndic() throws IOException, SAXException, NamingException, JDOMException, HibernateException, org.apache.velocity.runtime.parser.ParseException, ParseException {
      this.formBakingBeanImmobilier.gestionSyndic();
      this.moduleAffiche = "immobilierSyndic";
   }

   public void negoce() throws IOException, SAXException, HibernateException, NamingException, JDOMException, ParseException {
      this.baseVerrou = true;
      this.razMemoire((String)null);
      this.formBakingBeanAchats = null;
      if (this.formBakingBeanImmobilier == null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviCommImm");
         this.formBakingBeanImmobilier = new FormBakingBeanImmobilier();
         this.formBakingBeanImmobilier.setutilInitHibernate(this.utilInitHibernate);
         this.formBakingBeanImmobilier.setBaseLog(this.baseLog);
         this.formBakingBeanImmobilier.setStructureLog(this.structureLog);
         this.formBakingBeanImmobilier.setUsersLog(this.usersLog);
         this.formBakingBeanImmobilier.InstancesDaoUtilses();
         this.formBakingBeanImmobilier.setCategorie(2);
         this.formBakingBeanImmobilier.recupererExercices(var1);
         if (this.formBakingBeanImmobilier.getExoselectionne() != null && this.formBakingBeanImmobilier.getExoselectionne().getExevteId() != 0L) {
            this.formBakingBeanImmobilier.recupererTousLesItems(var1);
         }

         this.formBakingBeanImmobilier.setUrlExplorateur(this.urlDocument);
         this.formBakingBeanImmobilier.setTypeVente(this.typeVente);
         this.utilInitHibernate.closeSession();
      }

      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      if (this.formDocumentsOfficiels == null) {
         this.formDocumentsOfficiels = new FormDocumentsOfficiels(this.baseLog, this.structureLog, this.usersLog, 180, this.urlDocument, this.utilInitHibernate);
      }

      this.formBakingBeanImmobilier.menuGaucheNegoce();
      this.formBakingBeanImmobilier.setFormRecherche(this.formRecherche);
      this.formBakingBeanImmobilier.setFormDocumentsOfficiels(this.formDocumentsOfficiels);
      this.affichePage = "/immobilier/Vide.jsp";
      this.moduleAffiche = "immobilierNegoce";
      this.formBakingBeanImmobilier.setAffichePage(this.affichePage);
   }

   public void gestionNegoce() throws IOException, SAXException, NamingException, JDOMException, HibernateException, org.apache.velocity.runtime.parser.ParseException, ParseException {
      this.formBakingBeanImmobilier.gestionNegoce();
      this.moduleAffiche = "immobilierNegoce";
   }

   public void promoteur() throws IOException, SAXException, HibernateException, NamingException, JDOMException, ParseException {
      this.baseVerrou = true;
      this.razMemoire((String)null);
      this.formBakingBeanAchats = null;
      if (this.formBakingBeanImmobilier == null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviCommImm");
         this.formBakingBeanImmobilier = new FormBakingBeanImmobilier();
         this.formBakingBeanImmobilier.setutilInitHibernate(this.utilInitHibernate);
         this.formBakingBeanImmobilier.setBaseLog(this.baseLog);
         this.formBakingBeanImmobilier.setStructureLog(this.structureLog);
         this.formBakingBeanImmobilier.setUsersLog(this.usersLog);
         this.formBakingBeanImmobilier.InstancesDaoUtilses();
         this.formBakingBeanImmobilier.setCategorie(3);
         this.formBakingBeanImmobilier.recupererExercices(var1);
         if (this.formBakingBeanImmobilier.getExoselectionne() != null && this.formBakingBeanImmobilier.getExoselectionne().getExevteId() != 0L) {
            this.formBakingBeanImmobilier.recupererTousLesItems(var1);
         }

         this.formBakingBeanImmobilier.setUrlExplorateur(this.urlDocument);
         this.formBakingBeanImmobilier.setTypeVente(this.typeVente);
         this.utilInitHibernate.closeSession();
      }

      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      if (this.formDocumentsOfficiels == null) {
         this.formDocumentsOfficiels = new FormDocumentsOfficiels(this.baseLog, this.structureLog, this.usersLog, 180, this.urlDocument, this.utilInitHibernate);
      }

      this.formBakingBeanImmobilier.menuGauchePromotion();
      this.formBakingBeanImmobilier.setFormRecherche(this.formRecherche);
      this.formBakingBeanImmobilier.setFormDocumentsOfficiels(this.formDocumentsOfficiels);
      this.affichePage = "/immobilier/Vide.jsp";
      this.moduleAffiche = "immobilierPromoteur";
      this.formBakingBeanImmobilier.setAffichePage(this.affichePage);
   }

   public void gestionPromoteur() throws IOException, SAXException, NamingException, JDOMException, HibernateException, org.apache.velocity.runtime.parser.ParseException, ParseException {
      this.formBakingBeanImmobilier.gestionPromotion();
      this.moduleAffiche = "immobilierPromoteur";
   }

   public void retourExoImmobilier() throws JDOMException {
      this.moduleAffiche = "admin";
      this.affichePage = "/administration/Vide.jsp";
   }

   public void transfertComptaImmobilier() throws IOException, SAXException, HibernateException, NamingException, JDOMException, ParseException {
      this.comptabilite(false);
      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      if (this.formBakingBeanComptabilite == null) {
         this.formBakingBeanComptabilite = new FormBakingBeanComptabilite();
         this.formBakingBeanComptabilite.setutilInitHibernate(this.utilInitHibernate);
         this.formBakingBeanComptabilite.setBaseLog(this.baseLog);
         this.formBakingBeanComptabilite.setStructureLog(this.structureLog);
         this.formBakingBeanComptabilite.setUsersLog(this.usersLog);
         this.formBakingBeanComptabilite.InstancesDaoUtilses();
         if (this.rechercheModule(40300)) {
            this.formBakingBeanComptabilite.setModulesCode("40300");
         } else if (!this.rechercheModule(40100)) {
            this.formBakingBeanComptabilite.setModulesCode("40200");
         } else {
            this.formBakingBeanComptabilite.setModulesCode("40100");
         }

         this.formBakingBeanComptabilite.recupererOptionsCompta();
         this.formBakingBeanComptabilite.recupererExercices((Session)null);
         if (this.formBakingBeanComptabilite.getExoselectionne() != null && this.formBakingBeanComptabilite.getExoselectionne().getExecpt_id() != 0L) {
            this.formBakingBeanComptabilite.recupererTousLesItems((Session)null);
         }

         this.formBakingBeanComptabilite.setUrlExplorateur(this.urlDocument);
         this.formBakingBeanComptabilite.setTypeVente(this.typeVente);
      }

      this.formBakingBeanComptabilite.setFormRecherche(this.formRecherche);
      this.formBakingBeanComptabilite.preparationTransfertImmobilier(this.formBakingBeanImmobilier.getFormTransfertImmobilier().getListDocument());
   }

   public void temple() throws IOException, SAXException, HibernateException, NamingException, JDOMException {
      this.baseVerrou = true;
      this.razMemoire((String)null);
      if (this.formBakingBeanTemple == null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviTemple");
         this.formBakingBeanTemple = new FormBakingBeanTemple();
         this.formBakingBeanTemple.setutilInitHibernate(this.utilInitHibernate);
         this.formBakingBeanTemple.setBaseLog(this.baseLog);
         this.formBakingBeanTemple.setStructureLog(this.structureLog);
         this.formBakingBeanTemple.setUsersLog(this.usersLog);
         this.formBakingBeanTemple.InstancesDaoUtilses();
         this.formBakingBeanTemple.recupererExercices(var1);
         if (this.formBakingBeanTemple.getExoselectionne() != null && this.formBakingBeanTemple.getExoselectionne().getExevteId() != 0L) {
            this.formBakingBeanTemple.recupererTousLesItems(var1);
         }

         this.formBakingBeanTemple.setUrlExplorateur(this.urlDocument);
         this.formBakingBeanTemple.setTypeVente(this.typeVente);
         this.utilInitHibernate.closeSession();
      }

      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      this.formBakingBeanTemple.menuGaucheTemple();
      this.formBakingBeanTemple.setFormRecherche(this.formRecherche);
      this.affichePage = "/temple/Vide.jsp";
      this.moduleAffiche = "temple";
      this.formBakingBeanTemple.setAffichePage(this.affichePage);
   }

   public void gestionTemple() throws IOException, SAXException, NamingException, JDOMException, HibernateException, ParseException {
      this.moduleAffiche = "temple";
      this.formBakingBeanTemple.gestionTemple();
   }

   public void retourExoTemple() throws ParseException {
      this.moduleAffiche = "admin";
      this.affichePage = "/administration/Vide.jsp";
   }

   public void politBuro() throws IOException, SAXException, HibernateException, NamingException, JDOMException {
      this.baseVerrou = true;
      this.razMemoire((String)null);
      if (this.formBakingBeanPartiPolitique == null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviParti");
         this.formBakingBeanPartiPolitique = new FormBakingBeanPartiPolitique();
         this.formBakingBeanPartiPolitique.setutilInitHibernate(this.utilInitHibernate);
         this.formBakingBeanPartiPolitique.setBaseLog(this.baseLog);
         this.formBakingBeanPartiPolitique.setStructureLog(this.structureLog);
         this.formBakingBeanPartiPolitique.setUsersLog(this.usersLog);
         this.formBakingBeanPartiPolitique.InstancesDaoUtilses();
         this.formBakingBeanPartiPolitique.recupererExercices(var1);
         if (this.formBakingBeanPartiPolitique.getExoselectionne() != null && this.formBakingBeanPartiPolitique.getExoselectionne().getExevteId() != 0L) {
            this.formBakingBeanPartiPolitique.recupererTousLesItems(var1);
         }

         this.formBakingBeanPartiPolitique.setUrlExplorateur(this.urlDocument);
         this.formBakingBeanPartiPolitique.setTypeVente(this.typeVente);
         this.utilInitHibernate.closeSession();
      }

      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      this.formBakingBeanPartiPolitique.menuGauchePartiPolitique();
      this.formBakingBeanPartiPolitique.setFormRecherche(this.formRecherche);
      this.affichePage = "/politburo/Vide.jsp";
      this.moduleAffiche = "politburo";
      this.formBakingBeanPartiPolitique.setAffichePage(this.affichePage);
   }

   public void gestionPolitBuro() throws IOException, SAXException, NamingException, JDOMException, HibernateException, ParseException {
      this.moduleAffiche = "politburo";
      this.formBakingBeanPartiPolitique.gestionPartiPolitique();
   }

   public void retourExoPolitBuro() throws ParseException {
      this.moduleAffiche = "admin";
      this.affichePage = "/administration/Vide.jsp";
   }

   public void foret(int var1) throws JDOMException, HibernateException, NamingException, IOException, ParseException {
      this.baseVerrou = true;
      this.razMemoire((String)null);
      if (this.formBakingBeanForet == null) {
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "ForetLight");
         this.formBakingBeanForet = new FormBakingBeanForet();
         this.formBakingBeanForet.setutilInitHibernate(this.utilInitHibernate);
         this.formBakingBeanForet.setBaseLog(this.baseLog);
         this.formBakingBeanForet.setStructureLog(this.structureLog);
         this.formBakingBeanForet.setUsersLog(this.usersLog);
         this.formBakingBeanForet.instanceOptionForet();
         this.formBakingBeanForet.recupererExercices(var2);
         if (this.formBakingBeanForet.getExoselectionne() != null && this.formBakingBeanForet.getExoselectionne().getExevteId() != 0L) {
            this.formBakingBeanForet.recupererTousLesItems(var2);
         }

         this.formBakingBeanForet.setUrlExplorateur(this.urlDocument);
         this.formBakingBeanForet.setTypeVente(this.typeVente);
         this.utilInitHibernate.closeSession();
      }

      if (this.formDocumentsOfficiels == null) {
         this.formDocumentsOfficiels = new FormDocumentsOfficiels(this.baseLog, this.structureLog, this.usersLog, 100, this.urlDocument, this.utilInitHibernate);
      }

      this.formBakingBeanForet.setFormDocumentsOfficiels(this.formDocumentsOfficiels);
      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      this.formBakingBeanForet.setFormRecherche(this.formRecherche);
      this.formBakingBeanForet.menuGaucheForet(var1);
      this.moduleAffiche = "foret";
      this.affichePage = "/foret/Vide.jsp";
      this.formBakingBeanForet.setAffichePage(this.affichePage);
   }

   public void gestionForet() throws IOException, NamingException, JDOMException, ParseException {
      this.moduleAffiche = "foret";
      this.formBakingBeanForet.gestionForet();
   }

   public void retourExoForet() throws JDOMException {
      this.moduleAffiche = "admin";
      this.affichePage = "/administration/Vide.jsp";
   }

   public void reporting() throws IOException, SAXException, HibernateException, NamingException, JDOMException, ParseException {
      this.baseVerrou = true;
      this.razMemoire((String)null);
      if (this.formBakingBeanReporting == null) {
         this.formBakingBeanReporting = new FormBakingBeanReporting();
         this.formBakingBeanReporting.setutilInitHibernate(this.utilInitHibernate);
         this.formBakingBeanReporting.setBaseLog(this.baseLog);
         this.formBakingBeanReporting.setStructureLog(this.structureLog);
         this.formBakingBeanReporting.setUsersLog(this.usersLog);
         this.formBakingBeanReporting.InstancesDaoUtilses();
         this.formBakingBeanReporting.recupererOptionsCompta();
         this.formBakingBeanReporting.recupererExercices((Session)null);
         this.formBakingBeanReporting.recupererTousLesItems();
         this.formBakingBeanReporting.setUrlExplorateur(this.urlDocument);
         this.formBakingBeanReporting.setTypeVente(this.typeVente);
      }

      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      this.formBakingBeanReporting.menuGaucheReporting();
      this.formBakingBeanReporting.setFormRecherche(this.formRecherche);
      this.moduleAffiche = "reporting";
      this.affichePage = "/reporting/Vide.jsp";
      this.formBakingBeanReporting.setAffichePage(this.affichePage);
   }

   public void gestionReporting() throws IOException, NamingException, JDOMException, ParseException {
      this.moduleAffiche = "reporting";
      this.formBakingBeanReporting.gestionReporting();
   }

   public void administration() throws IOException, JDOMException, SAXException, ParseException, HibernateException, NamingException {
      this.baseVerrou = true;
      this.razMemoire((String)null);
      this.formBakingBeanAdministration = new FormBakingBeanAdministration();
      this.formBakingBeanAdministration.setutilInitHibernate(this.utilInitHibernate);
      this.formBakingBeanAdministration.setBaseLog(this.baseLog);
      this.formBakingBeanAdministration.setStructureLog(this.structureLog);
      this.formBakingBeanAdministration.setUsersLog(this.usersLog);
      this.formBakingBeanAdministration.InstancesDaoUtilses();
      this.formBakingBeanAdministration.setUrlExplorateur(this.urlDocument);
      this.formBakingBeanAdministration.setTypeVente(this.typeVente);
      this.formBakingBeanAdministration.setLesStructuresPeg(this.listeSocieteCabinet);
      this.chargeStructureSocieteSuite();
      this.formBakingBeanAdministration.setLesStructuresPeg(this.listeSocieteCabinet);
      if (this.usersLog.getUsrSysteme() == 1) {
         this.formBakingBeanAdministration.menuGaucheCoAdministration();
         this.moduleAffiche = "coadmin";
      } else if (this.usersLog.getUsrSysteme() >= 2) {
         ArrayList var1 = new ArrayList();
         if (this.menuListe.size() != 0) {
            new MenuModule();
            boolean var3 = false;
            boolean var4 = false;

            for(int var5 = 0; var5 < this.menuListe.size(); ++var5) {
               MenuModule var2 = (MenuModule)this.menuListe.get(var5);
               if (var2.getCode() != 60000 && var2.getCode() != 60010 && var2.getCode() != 60020) {
                  if (var2.getCode() == 60100) {
                     var2.setLibelle("Achat et Stock");
                     var3 = false;
                  } else if (var2.getCode() != 81600 && var2.getCode() != 81610 && var2.getCode() != 81620 && var2.getCode() != 81630 && var2.getCode() != 81640) {
                     var3 = true;
                  } else {
                     var2.setLibelle("Immobilier");
                     var2.setCode(81600);
                     if (!var4) {
                        var3 = true;
                        var4 = true;
                     } else {
                        var3 = false;
                     }
                  }
               } else {
                  var2.setLibelle("Achat et Stock");
                  var3 = true;
               }

               if (var3) {
                  var1.add(var2);
               }
            }
         }

         ListDataModel var6 = new ListDataModel();
         var6.setWrappedData(var1);
         this.formBakingBeanAdministration.setDataModelMenuHorizontal(var6);
         this.formBakingBeanAdministration.menuGaucheAdministration();
         this.moduleAffiche = "admin";
      }

      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      this.formBakingBeanAdministration.setFormRecherche(this.formRecherche);
      this.formBakingBeanAdministration.setChoixModule("");
      this.formBakingBeanAdministration.setChoixLigne("");
      this.affichePage = "/administration/Vide.jsp";
      this.formBakingBeanAdministration.setAffichePage(this.affichePage);
      if (this.structureLog.getStrmode() == 0) {
         this.choixServeur = "ePegase";
      } else {
         this.choixServeur = "du client";
      }

   }

   public void administrationAction() throws IOException, JDOMException, HibernateException, NamingException, SQLException, ClassNotFoundException, SAXException, ParseException {
      this.moduleAffiche = "admin";
      this.formBakingBeanAdministration.gestionAdministration(this.urlDocument);
   }

   public void coAdministrationAction() throws IOException, JDOMException, HibernateException, NamingException, SQLException, SAXException, ParseException, ClassNotFoundException, MalformedURLException, groovyjarjarcommonscli.ParseException {
      this.baseVerrou = true;
      this.moduleAffiche = "coadmin";
      this.formBakingBeanAdministration.gestionCoAdministration(this.urlDocument);
   }

   public void retourAdminstrationGenerale() {
      this.moduleAffiche = "admin";
      this.affichePage = "/administration/Vide.jsp";
      this.formBakingBeanAdministration.setAffichePage(this.affichePage);
      if (this.formBakingBeanAdministration != null && this.formBakingBeanAdministration.getFormUsers() != null) {
         this.formBakingBeanAdministration.setFormUsers((FormUsers)null);
      }

   }

   public void retourAdmnistration() throws IOException, SAXException, SQLException, HibernateException, NamingException, JDOMException, ParseException, org.apache.velocity.runtime.parser.ParseException {
      if (this.formBakingBeanAdministration != null && this.formBakingBeanAdministration.getFormUsers() != null) {
         this.retourAdminstrationGenerale();
         this.formBakingBeanAdministration.setFormUsers((FormUsers)null);
      } else {
         this.moduleAffiche = "";
         this.moduleFree = "";
         this.moduleCommercial = "";
         this.moduleCompta = "";
         this.razMemoire((String)null);
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Accueil");
         this.structureDao = new StructureDao(this.baseLog, this.utilInitHibernate);
         this.structureLog = this.structureDao.logStructureId(this.structureLog.getStrid(), var1);
         UserDao var2 = new UserDao(this.baseLog, this.utilInitHibernate);
         this.usersLog = var2.selectUserD(this.usersLog.getUsrid(), var1);
         this.recupererModule(var1);
         this.formBakingBeanAccueil = null;
         this.accueil(var1, this.urlDocument, this.typePlateForme, false);
         this.calculBaseCopie(var1);
         this.utilInitHibernate.closeSession();
         this.listeSocieteCabinet.clear();
         this.dataModelSociete.setWrappedData(this.listeSocieteCabinet);
         this.chargerScripts();
         this.startupAutomatique((Session)null);
         this.message_vocal = "";
      }

   }

   public void installationMiseAJour() throws MalformedURLException, IOException {
      this.var_currentValue = 0;
      this.var_showBarProgMaj = true;
      UtilNombre var1 = new UtilNombre();
      InputStream var2 = null;
      RandomAccessFile var3 = null;
      String var4 = "";
      if (StaticModePegase.getOsContext() == 0) {
         var4 = File.separator + "opt" + File.separator + "glassfish" + File.separator + "domains" + File.separator + "domain1" + File.separator + "autodeploy" + File.separator;
      } else if (StaticModePegase.getOsContext() == 1) {
         var4 = "C:" + File.separator + "Sun" + File.separator + "AppServer" + File.separator + "domains" + File.separator + "domain1" + File.separator + "autodeploy" + File.separator;
      } else if (StaticModePegase.getOsContext() == 2) {
         var4 = File.separator + "opt" + File.separator + "glassfish" + File.separator + "domains" + File.separator + "domain1" + File.separator + "autodeploy" + File.separator;
      } else {
         var4 = File.separator + "usr" + File.separator + "local" + File.separator + "SUNWappserver" + File.separator + "domains" + File.separator + "domain1" + File.separator + "autodeploy" + File.separator;
      }

      File var5 = new File(var4);
      if (var5.exists()) {
         double var6 = 0.0D;
         double var8 = 0.0D;

         try {
            URL var10 = new URL("http://" + StaticModePegase.getIpServeur() + ":8080" + File.separator + StaticModePegase.getCheminContext() + File.separator + "update" + File.separator + "epegase.war");
            URLConnection var11 = var10.openConnection();
            int var12 = var11.getContentLength();
            if (var12 == -1) {
               this.var_showBarProgMaj = false;
               StaticModePegase.setTexte_message("La mise à jour demandee est introuvable...");
               StaticModePegase.setAffiche_message(true);
            } else {
               var2 = var11.getInputStream();
               String var13 = var10.getFile().substring(var10.getFile().lastIndexOf(47) + 1);
               File var14 = new File(var4 + var13);
               if (var14.exists()) {
                  var14.delete();
               }

               File var15 = new File(var4 + var13 + "_deployed");
               if (var15.exists()) {
                  var15.delete();
               }

               var3 = new RandomAccessFile(var4 + var13, "rw");
               byte[] var16 = new byte[1024];

               int var17;
               for(int var18 = 0; (var17 = var2.read(var16)) > 0; var3.write(var16, 0, var17)) {
                  ++var18;
                  if (var18 != 0) {
                     var6 = (double)var1.myRound((float)(var12 / 100 / var18), 4);
                     var8 = var1.myRound(100.0D / var6, 2);
                     this.var_currentValue = (int)var8;
                  }
               }
            }
         } catch (IOException var27) {
            this.var_showBarProgMaj = false;
            StaticModePegase.setTexte_message("Erreur pendant le telechargement de la mise a jour...");
            StaticModePegase.setAffiche_message(true);
            var27.printStackTrace();
         } finally {
            if (var3 != null) {
               try {
                  var3.close();
                  var2.close();
               } catch (IOException var26) {
                  var26.printStackTrace();
               }

               this.majVersion();
               this.var_showBarProgMaj = false;
               StaticModePegase.setTexte_message("La mise a jour s'est déroulee avec succes... Veuillez quitter ePegase et vous reconnecter. Après la reconexion, veuillez exécuter Information systèmes dans Administration pour terminer la mise à jour.");
               StaticModePegase.setAffiche_message(true);
            }

         }
      } else {
         this.var_showBarProgMaj = false;
         StaticModePegase.setTexte_message("Le répertoire de mise à jour est introuvable...");
         StaticModePegase.setAffiche_message(true);
      }

   }

   public void majVersion() throws FileNotFoundException, IOException {
      new Version();
      LireVersion var2 = new LireVersion();
      Version var1 = var2.lancer();
      String var3 = var1.getVersion_internet();
      String var4 = var1.getVersion_os();
      String var5 = var1.getVersion_base();
      String var6 = var1.getVersion_serveur();
      String var7 = var1.getVersion_imageStartup();
      Element var8 = new Element("version");
      Document var9 = new Document(var8);
      var8.removeContent();
      Element var10 = new Element("numero");
      var8.addContent(var10);
      var10.setText(StaticModePegase.getVersion_distante());
      Element var11 = new Element("date");
      var8.addContent(var11);
      var11.setText(StaticModePegase.getDate_distante());
      Element var12 = new Element("internet");
      var8.addContent(var12);
      var12.setText(var3);
      Element var13 = new Element("os");
      var8.addContent(var13);
      var13.setText(var4);
      Element var14 = new Element("base");
      var8.addContent(var14);
      var14.setText(var5);
      Element var15 = new Element("serveur");
      var8.addContent(var15);
      var15.setText(var6);
      Element var16 = new Element("imageStartup");
      var8.addContent(var16);
      var16.setText(var7);
      XMLOutputter var17 = new XMLOutputter(Format.getPrettyFormat());
      var17.output(var9, new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "update" + File.separator + "version.xml"));
   }

   public void systeme() throws IOException, JDOMException, SAXException, ParseException {
      this.baseVerrou = true;
      this.razMemoire((String)null);
      this.formBakingBeanSysteme = new FormBakingBeanSysteme();
      this.formBakingBeanSysteme.setUtilInitHibernate(this.utilInitHibernate);
      this.formBakingBeanSysteme.setBaseLog(this.baseLog);
      this.formBakingBeanSysteme.setStructureLog(this.structureLog);
      this.formBakingBeanSysteme.setUsersLog(this.usersLog);
      this.formBakingBeanSysteme.recupererTousLesItems();
      this.formBakingBeanSysteme.setTypeVente(this.typeVente);
      this.formBakingBeanSysteme.menuGaucheSysteme();
      if (this.formRecherche == null) {
         this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      }

      this.formBakingBeanSysteme.setFormRecherche(this.formRecherche);
      this.affichePage = "/systeme/Vide.jsp";
      this.moduleAffiche = "systeme";
      this.formBakingBeanSysteme.setAffichePage(this.affichePage);
   }

   public void gestionSystem() throws SAXException, JDOMException, IOException, HibernateException, NamingException, SQLException, ClassNotFoundException, ParseException {
      this.moduleAffiche = "systeme";
      this.formBakingBeanSysteme.gestionSystem();
   }

   public void sessionHelpDesk() {
      this.showModalPanelHelpDesk = true;
   }

   public void fermeHelpDesk() {
      this.showModalPanelHelpDesk = false;
   }

   public void espaceClient() throws HibernateException, NamingException, ParseException {
      this.baseVerrou = true;
      this.razMemoire((String)null);
      Session var1 = this.utilInitHibernate.getLoginPlanetePegase();
      this.formEspaceClient = new FormEspaceClient();
      this.formEspaceClient.setUtilInitHibernate(this.utilInitHibernate);
      this.formEspaceClient.setBaseLog(this.baseLog);
      this.formEspaceClient.setStructureLog(this.structureLog);
      this.formEspaceClient.setUsersLog(this.usersLog);
      this.formEspaceClient.InstancesDaoUtilses();
      this.formEspaceClient.verifConnexion(var1);
      this.formEspaceClient.setTypeVente(this.typeVente);
      if (this.formEspaceClient.isAccesEspaceClient()) {
         this.formEspaceClient.rechercheElementStructure(var1);
         this.affichePage = "/accueil/espaceClient.jsp";
         this.moduleAffiche = "espaceClient";
      }

      this.utilInitHibernate.closeSession();
   }

   public void initImpression() {
      this.nature = 0;
      this.strImpFactGlobale = 0L;
      this.affMail = false;
      if (this.utilPrint == null) {
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
      }

      this.utilPrint.setPoidsAff(false);
      this.utilPrint.setCertification(false);
      boolean var1 = false;
      this.devise = this.structureLog.getStrdevise();
      this.tauxDevise = 1.0F;
      this.lesDevisesItems = new ArrayList();
      this.lesDevisesItems.add(new SelectItem(this.devise));
      if (this.formBakingBeanAchats != null) {
         this.nature = this.formBakingBeanAchats.getNature();
         this.lesDevisesItems = this.formBakingBeanAchats.getMesdevisesItem();
         var1 = true;
      } else if (this.formBakingBeanVentes != null) {
         this.nature = this.formBakingBeanVentes.getNature();
         this.strImpFactGlobale = Long.parseLong(this.formBakingBeanVentes.getOptionsVentes().getGestionImpressionFac());
         this.lesDevisesItems = this.formBakingBeanVentes.getMesdevisesItem();
         this.utilPrint.setPoidsAff(this.formBakingBeanVentes.isPoidsAff());
         var1 = true;
      } else if (this.formBakingBeanOffice != null) {
         this.nature = this.formBakingBeanOffice.getNature();
         var1 = true;
      } else if (this.formBakingBeanMedical != null) {
         this.nature = this.formBakingBeanMedical.getNature();
         var1 = true;
      } else if (this.formBakingBeanImmobilier != null) {
         this.nature = this.formBakingBeanImmobilier.getNature();
         var1 = true;
      } else if (this.formBakingBeanComptabilite != null) {
         this.nature = this.formBakingBeanComptabilite.getNature();
         var1 = true;
      } else if (this.formBakingBeanPaye != null) {
         this.nature = this.formBakingBeanPaye.getNature();
         var1 = true;
      } else if (this.formBakingBeanParcs != null) {
         this.nature = this.formBakingBeanParcs.getNature();
         var1 = true;
      } else if (this.formBakingBeanMicroFinance != null) {
         this.nature = this.formBakingBeanMicroFinance.getNature();
         var1 = true;
      } else if (this.formBakingBeanEducation != null) {
         this.nature = this.formBakingBeanEducation.getNature();
         var1 = true;
      } else if (this.formBakingBeanFondation != null) {
         this.nature = this.formBakingBeanFondation.getNature();
         var1 = true;
      } else if (this.formBakingBeanForet != null) {
         this.nature = this.formBakingBeanForet.getNature();
         var1 = true;
      }

      if (var1) {
         this.documentImpressionItems = new ArrayList();
         this.listeImpressionItems = new ArrayList();
         this.var_choix_modele = 0;
         this.var_choix_periode = 0;
         this.nomModeleDocument = "";
         if (this.nature == 5) {
            if (this.formBakingBeanOffice.getFormReunion().getReunionEntete().getReuEtat() == 0) {
               this.nomModeleDocument = this.formBakingBeanOffice.getFormReunion().getReunionEntete().getReuModeleImp();
            } else {
               this.nomModeleDocument = this.formBakingBeanOffice.getFormReunion().getReunionEntete().getReuModeleCRImp();
            }
         } else if (this.nature == 120) {
            this.nomModeleDocument = this.formBakingBeanOffice.getFormReunion().getReunionEntete().getReuModeleImp();
         } else if (this.nature == 121) {
            this.nomModeleDocument = this.formBakingBeanOffice.getFormReunion().getReunionEntete().getReuModeleImp();
         } else if (this.nature == 122) {
            this.nomModeleDocument = "";
         } else if (this.nature == 10) {
            this.nomModeleDocument = this.formBakingBeanAchats.getFormDemandeAchats().getDemandeEnteteAchats().getDemModeleImp();
         } else if (this.nature == 11) {
            this.nomModeleDocument = this.formBakingBeanAchats.getFormCotationAchats().getCotationEnteteAchats().getCotModeleImp();
         } else if (this.nature == 12) {
            this.nomModeleDocument = this.formBakingBeanAchats.getFormCommandeAchats().getCommandeEnteteAchats().getCmdModeleImp();
         } else if (this.nature == 13) {
            this.nomModeleDocument = this.formBakingBeanAchats.getFormReceptionAchats().getReceptionEnteteAchats().getRecModeleImp();
         } else if (this.nature == 14) {
            this.nomModeleDocument = this.formBakingBeanAchats.getFormRetourAchats().getRetourEnteteAchats().getBrfModeleImp();
         } else if (this.nature == 15) {
            this.nomModeleDocument = this.formBakingBeanAchats.getFormFactureAchats().getFactureEnteteAchats().getFcfModeleImp();
         } else if (this.nature == 16) {
            this.nomModeleDocument = this.formBakingBeanAchats.getFormAvoirAchats().getAvoirEnteteAchats().getAvfModeleImp();
         } else if (this.nature == 17) {
            this.nomModeleDocument = this.formBakingBeanAchats.getFormNoteDebitAchats().getNoteDebitEnteteAchats().getNdfModeleImp();
         } else if (this.nature == 18) {
            this.nomModeleDocument = this.formBakingBeanAchats.getFormFraisAchats().getFraisEnteteAchats().getFsfModeleImp();
         } else if (this.nature == 20) {
            this.nomModeleDocument = this.formBakingBeanVentes.getFormBesoinVentes().getBesoinEnteteVentes().getBesModeleImp();
         } else if (this.nature == 7 && this.formBakingBeanVentes != null) {
            this.nomModeleDocument = this.formBakingBeanVentes.getFormCommissionsVentes().getCommissionEnteteVentes().getComModeleImp();
         } else if (this.nature == 7 && this.formBakingBeanMedical != null) {
            this.nomModeleDocument = this.formBakingBeanMedical.getFormCommissionsMedicales().getCommissionEnteteVentes().getComModeleImp();
         } else if (this.nature == 8) {
            this.nomModeleDocument = this.formBakingBeanVentes.getFormSimulContratVentes().getSimulationEnteteVentes().getSimcrtModeleImp();
         } else if (this.nature == 21) {
            this.nomModeleDocument = this.formBakingBeanVentes.getFormDevisVentes().getDevisEnteteVentes().getDvsModeleImp();
         } else if (this.nature == 22) {
            this.nomModeleDocument = this.formBakingBeanVentes.getFormCommandeVentes().getCommandeEnteteVentes().getBcmModeleImp();
         } else if (this.nature == 23) {
            this.nomModeleDocument = this.formBakingBeanVentes.getFormLivraisonVentes().getLivraisonEnteteVentes().getBlvModeleImp();
         } else if (this.nature == 24) {
            this.nomModeleDocument = this.formBakingBeanVentes.getFormRetourVentes().getRetourEnteteVentes().getBrtModeleImp();
         } else if (this.nature == 25) {
            this.nomModeleDocument = this.formBakingBeanVentes.getFormFactureVentes().getFactureEnteteVentes().getFacModeleImp();
         } else if (this.nature == 26) {
            this.nomModeleDocument = this.formBakingBeanVentes.getFormAvoirVentes().getAvoirEnteteVentes().getAvrModeleImp();
         } else if (this.nature == 27) {
            this.nomModeleDocument = this.formBakingBeanVentes.getFormNoteDebitVentes().getNoteDebitEnteteVentes().getNdbModeleImp();
         } else if (this.nature == 127 && this.formBakingBeanVentes != null) {
            this.nomModeleDocument = this.formBakingBeanVentes.getFormAffaires().getPlansAnalytiques().getAnaAffaireMdeleImp();
         } else if (this.nature == 140) {
            this.nomModeleDocument = this.formBakingBeanVentes.getFormContratVentes().getContratEnteteVentes().getCrtModeleImp();
         } else if (this.nature == 141) {
            this.nomModeleDocument = this.formBakingBeanVentes.getFormCampagneVentes().getCampagneEnteteVentes().getCamModeleImp();
         } else if (this.nature == 142) {
            this.nomModeleDocument = this.formBakingBeanVentes.getFormFactureInterneVentes().getFactureInterneEnteteVentes().getFitModeleImp();
         } else if (this.nature == 28) {
            this.nomModeleDocument = this.formBakingBeanVentes.getFormChargementVentes().getChargementEntete().getChamobModeleImp();
         } else if (this.nature == 30) {
            this.nomModeleDocument = this.formBakingBeanAchats.getFormInventaire().getInventaireEntete().getInvModeleImp();
         } else if (this.nature == 31) {
            this.nomModeleDocument = this.formBakingBeanAchats.getFormBonEntree().getBonEntreeEntete().getBinModeleImp();
         } else if (this.nature == 32) {
            this.nomModeleDocument = this.formBakingBeanAchats.getFormBonSortie().getBonSortieEntete().getBouModeleImp();
         } else if (this.nature == 33) {
            this.nomModeleDocument = this.formBakingBeanAchats.getFormCession().getCessionEntete().getCesModeleImp();
         } else if (this.nature == 34) {
            this.nomModeleDocument = this.formBakingBeanAchats.getFormProduction().getFabricationEnteteAchats().getFabModeleImp();
         } else if (this.nature == 35) {
            this.nomModeleDocument = this.formBakingBeanAchats.getFormValorisationAchats().getValorisationEnteteAchats().getValModeleImp();
         } else if (this.nature == 47) {
            this.nomModeleDocument = this.formBakingBeanParcs.getFormManifestePrc().getManifestEntete().getVtemanModeleImp();
         } else if (this.nature != 36) {
            if (this.nature == 37) {
               this.formBakingBeanAchats.getFormExtraitBudget().chargerLesModelesImpresion();
            } else if (this.nature == 50) {
               this.formBakingBeanComptabilite.getFormLoyers().chargerLesModelesImpresion();
            } else if (this.nature == 51) {
               this.formBakingBeanComptabilite.getFormAmortissements().chargerLesModelesImpresion();
            } else if (this.nature == 52) {
               this.formBakingBeanComptabilite.getFormBudget().chargerLesModelesImpresion();
            } else if (this.nature == 53) {
               this.formBakingBeanComptabilite.getFormJournauxComptables().chargerLesModelesImpresion();
            } else if (this.nature == 531) {
               this.formBakingBeanComptabilite.getFormBrouillardMois().chargerLesModelesImpresion();
            } else if (this.nature == 532) {
               this.formBakingBeanComptabilite.getFormBrouillardMois().chargerLesModelesImpresion();
            } else if (this.nature == 534) {
               this.formBakingBeanComptabilite.getFormExtraitCompte().chargerLesModelesImpresion();
            } else if (this.nature == 535) {
               this.formBakingBeanComptabilite.getFormExtraitAnalList().chargerLesModelesImpresion();
            } else if (this.nature == 538) {
               this.formBakingBeanComptabilite.getFormExtraitClasse().chargerLesModelesImpresion();
            } else if (this.nature == 539) {
               this.formBakingBeanComptabilite.getFormExtraitProjet().chargerLesModelesImpresion();
            } else if (this.nature == 540) {
               this.formBakingBeanComptabilite.getFormExtraitBudget().chargerLesModelesImpresion();
            } else if (this.nature == 54) {
               this.formBakingBeanComptabilite.getFormBudgetTresorerie().chargerLesModelesImpresion();
            } else if (this.nature == 56) {
               this.formBakingBeanComptabilite.getFormRapprochement().chargerLesModelesImpresion();
            } else if (this.nature == 71) {
               this.nomModeleDocument = this.formBakingBeanMedical.getFormConsultationGene().getConsultationEnteteGene().getCsgModeleImp();
            } else if (this.nature != 72) {
               if (this.nature == 73) {
                  this.nomModeleDocument = this.formBakingBeanMedical.getFormPharmacie().getPharmacieEntete().getPhaModeleImp();
               } else if (this.nature == 74) {
                  this.nomModeleDocument = this.formBakingBeanMedical.getFormLaboratoire().getLaboratoireEntete().getLabModeleImp();
               } else if (this.nature == 741) {
                  this.nomModeleDocument = this.formBakingBeanMedical.getFormLaboratoire().getLaboratoireEntete().getLabModeleImp();
               } else if (this.nature == 76) {
                  this.nomModeleDocument = this.formBakingBeanMedical.getFormHospitalisation().getHospitalisationEntete().getHosModeleImp();
               } else if (this.nature == 77) {
                  this.nomModeleDocument = this.formBakingBeanMedical.getFormDevisMedical().getDevisEnteteMedical().getDvsModeleImp();
               } else if (this.nature == 78) {
                  this.formBakingBeanMedical.getFormRefacturation().chargerLesModelesImpresion();
                  this.nomModeleDocument = this.formBakingBeanMedical.getFormRefacturation().getFactureEnteteMedical().getFacModeleImp();
               } else if (this.nature == 182) {
                  this.nomModeleDocument = this.formBakingBeanMedical.getFormRefacturation().getRecapitulatifMedical().getFacrecModeleImp();
               } else if (this.nature == 81) {
                  this.formBakingBeanPaye.getFormFicheSalarie().chargerLesModelesImpresion();
               } else if (this.nature != 82 && this.nature != 83 && this.nature != 84 && this.nature != 85 && this.nature != 86 && this.nature != 93) {
                  if (this.nature == 87) {
                     this.formBakingBeanPaye.getFormPrets().chargerLesModelesImpresion();
                  } else if (this.nature != 88 && this.nature != 89) {
                     if (this.nature == 91) {
                        this.formBakingBeanPaye.getFormMissions().chargerLesModelesImpresion();
                     } else if (this.nature == 92) {
                        this.formBakingBeanPaye.getFormPointage().chargerLesModelesImpresion();
                     } else if (this.nature == 94) {
                        this.formBakingBeanPaye.getFormPointage().chargerLesModelesImpresion();
                     } else if (this.nature == 100) {
                        this.formBakingBeanEducation.getFormGestionEleves().chargerLesModelesImpresion();
                     } else if (this.nature != 101 && this.nature != 102 && this.nature != 103 && this.nature != 104 && this.nature != 160) {
                        if (this.nature == 161) {
                           this.nomModeleDocument = this.formBakingBeanImmobilier.getFormGeranceImmobilier().getBienGeranceEntete().getBiegerentModeleImp();
                        } else if (this.nature == 162) {
                           this.nomModeleDocument = this.formBakingBeanImmobilier.getFormBailImmobilier().getBienBail().getBiebaiModeleImp();
                        } else if (this.nature == 163) {
                           this.nomModeleDocument = this.formBakingBeanImmobilier.getFormTravauxImmobilier().getBienTravauxEntete().getBietraentModeleImp();
                        } else if (this.nature == 164) {
                           this.nomModeleDocument = this.formBakingBeanImmobilier.getFormTravauxImmobilier().getBienTravauxLigne().getBietraligModeleImp();
                        } else if (this.nature == 165) {
                           this.nomModeleDocument = this.formBakingBeanImmobilier.getFormFactureImmobilier().getBienFacture().getBiefacModeleImp();
                        } else if (this.nature == 171) {
                           this.nomModeleDocument = this.formBakingBeanImmobilier.getFormSyndicImmobilier().getBienGeranceEntete().getBiegerentModeleImp();
                        } else if (this.nature == 172) {
                           this.nomModeleDocument = this.formBakingBeanImmobilier.getFormBudgetImmobilier().getBienBudgetEntete().getBiebudentModeleImp();
                        } else if (this.nature == 173) {
                           this.nomModeleDocument = this.formBakingBeanImmobilier.getFormAppelChargeImmobilier().getAppelCharge().getAppchaModeleImp();
                        } else if (this.nature == 181) {
                           this.nomModeleDocument = this.formBakingBeanMedical.getFormNoteDebitMedical().getNoteDebitEnteteVentes().getNdbModeleImp();
                        } else if (this.nature == 250) {
                           this.nomModeleDocument = this.formBakingBeanForet.getFormForetInventaire().getForetInventaire().getForinvModeleImp();
                        }
                     }
                  } else {
                     this.formBakingBeanPaye.getFormConges().chargerLesModelesImpresion();
                  }
               } else {
                  this.formBakingBeanPaye.getFormFicheSalarie().chargerLesModelesImpresion();
               }
            }
         }

         this.affMail = false;
         this.listeDocImp();
         if (this.nature != 0) {
            if (this.nature != 5 && this.nature != 120 && this.nature != 121) {
               if (this.nature == 122) {
                  this.formBakingBeanOffice.getFormSms().setShowModalPanelPrint(true);
               } else if (this.nature == 10) {
                  this.formBakingBeanAchats.getFormDemandeAchats().setShowModalPanelPrint(true);
               } else if (this.nature == 11) {
                  this.formBakingBeanAchats.getFormCotationAchats().setShowModalPanelPrint(true);
               } else if (this.nature == 12) {
                  this.formBakingBeanAchats.getFormCommandeAchats().setShowModalPanelPrint(true);
               } else if (this.nature == 13) {
                  this.formBakingBeanAchats.getFormReceptionAchats().setShowModalPanelPrint(true);
               } else if (this.nature == 14) {
                  this.formBakingBeanAchats.getFormRetourAchats().setShowModalPanelPrint(true);
               } else if (this.nature == 15) {
                  this.formBakingBeanAchats.getFormFactureAchats().setShowModalPanelPrint(true);
               } else if (this.nature == 16) {
                  this.formBakingBeanAchats.getFormAvoirAchats().setShowModalPanelPrint(true);
               } else if (this.nature == 17) {
                  this.formBakingBeanAchats.getFormNoteDebitAchats().setShowModalPanelPrint(true);
               } else if (this.nature == 18) {
                  this.formBakingBeanAchats.getFormFraisAchats().setShowModalPanelPrint(true);
               } else if (this.nature == 20) {
                  this.formBakingBeanVentes.getFormBesoinVentes().setShowModalPanelPrint(true);
               } else if (this.nature == 7 && this.formBakingBeanVentes != null) {
                  this.formBakingBeanVentes.getFormCommissionsVentes().setShowModalPanelPrint(true);
               } else if (this.nature == 7 && this.formBakingBeanMedical != null) {
                  this.formBakingBeanMedical.getFormCommissionsMedicales().setShowModalPanelPrint(true);
               } else if (this.nature == 8) {
                  this.formBakingBeanVentes.getFormSimulContratVentes().setShowModalPanelPrint(true);
               } else if (this.nature == 21) {
                  this.formBakingBeanVentes.getFormDevisVentes().setShowModalPanelPrint(true);
               } else if (this.nature == 22) {
                  this.formBakingBeanVentes.getFormCommandeVentes().setShowModalPanelPrint(true);
               } else if (this.nature == 23) {
                  this.formBakingBeanVentes.getFormLivraisonVentes().setShowModalPanelPrint(true);
               } else if (this.nature == 24) {
                  this.formBakingBeanVentes.getFormRetourVentes().setShowModalPanelPrint(true);
               } else if (this.nature == 25) {
                  this.formBakingBeanVentes.getFormFactureVentes().setShowModalPanelPrint(true);
               } else if (this.nature == 26) {
                  this.formBakingBeanVentes.getFormAvoirVentes().setShowModalPanelPrint(true);
               } else if (this.nature == 27) {
                  this.formBakingBeanVentes.getFormNoteDebitVentes().setShowModalPanelPrint(true);
               } else if (this.nature == 127 && this.formBakingBeanVentes != null) {
                  this.formBakingBeanVentes.getFormAffaires().setShowModalPanelPrint(true);
               } else if (this.nature == 140) {
                  this.formBakingBeanVentes.getFormContratVentes().setShowModalPanelPrint(true);
               } else if (this.nature == 141) {
                  this.formBakingBeanVentes.getFormCampagneVentes().setShowModalPanelPrint(true);
               } else if (this.nature == 142) {
                  this.formBakingBeanVentes.getFormFactureInterneVentes().setShowModalPanelPrint(true);
               } else if (this.nature == 28) {
                  this.formBakingBeanVentes.getFormChargementVentes().setShowModalPanelPrint(true);
               } else if (this.nature == 30) {
                  this.formBakingBeanAchats.getFormInventaire().setShowModalPanelPrint(true);
               } else if (this.nature == 31) {
                  this.formBakingBeanAchats.getFormBonEntree().setShowModalPanelPrint(true);
               } else if (this.nature == 32) {
                  this.formBakingBeanAchats.getFormBonSortie().setShowModalPanelPrint(true);
               } else if (this.nature == 33) {
                  this.formBakingBeanAchats.getFormCession().setShowModalPanelPrint(true);
               } else if (this.nature == 34) {
                  this.formBakingBeanAchats.getFormProduction().setShowModalPanelPrint(true);
               } else if (this.nature == 35) {
                  this.formBakingBeanAchats.getFormValorisationAchats().setShowModalPanelPrint(true);
               } else if (this.nature != 36) {
                  if (this.nature == 37) {
                     this.formBakingBeanAchats.getFormExtraitBudget().setShowModalPanelPrint(true);
                  } else if (this.nature == 47) {
                     this.formBakingBeanParcs.getFormManifestePrc().setShowModalPanelPrint(true);
                  } else if (this.nature == 50) {
                     this.formBakingBeanComptabilite.getFormLoyers().setShowModalPanelPrint(true);
                  } else if (this.nature == 51) {
                     this.formBakingBeanComptabilite.getFormAmortissements().setShowModalPanelPrint(true);
                  } else if (this.nature == 52) {
                     this.formBakingBeanComptabilite.getFormBudget().setShowModalPanelPrint(true);
                  } else if (this.nature == 53) {
                     this.formBakingBeanComptabilite.getFormJournauxComptables().setShowModalPanelPrint(true);
                  } else if (this.nature == 531) {
                     this.formBakingBeanComptabilite.getFormBrouillardMois().setShowModalPanelPrint(true);
                  } else if (this.nature == 532) {
                     this.formBakingBeanComptabilite.getFormBrouillardMois().setShowModalPanelPrint(true);
                  } else if (this.nature == 534) {
                     this.formBakingBeanComptabilite.getFormExtraitCompte().setShowModalPanelPrint(true);
                  } else if (this.nature == 535) {
                     this.formBakingBeanComptabilite.getFormExtraitAnalList().setShowModalPanelPrint(true);
                  } else if (this.nature == 538) {
                     this.formBakingBeanComptabilite.getFormExtraitClasse().setShowModalPanelPrint(true);
                  } else if (this.nature == 539) {
                     this.formBakingBeanComptabilite.getFormExtraitProjet().setShowModalPanelPrint(true);
                  } else if (this.nature == 540) {
                     this.formBakingBeanComptabilite.getFormExtraitBudget().setShowModalPanelPrint(true);
                  } else if (this.nature == 54) {
                     this.formBakingBeanComptabilite.getFormBudgetTresorerie().setShowModalPanelPrint(true);
                  } else if (this.nature == 56) {
                     this.formBakingBeanComptabilite.getFormRapprochement().setShowModalPanelPrint(true);
                  } else if (this.nature == 71) {
                     this.formBakingBeanMedical.getFormConsultationGene().setShowModalPanelPrint(true);
                  } else if (this.nature != 72) {
                     if (this.nature == 73) {
                        this.formBakingBeanMedical.getFormPharmacie().setShowModalPanelPrint(true);
                     } else if (this.nature == 74) {
                        this.formBakingBeanMedical.getFormLaboratoire().setShowModalPanelPrint(true);
                     } else if (this.nature == 741) {
                        this.formBakingBeanMedical.getFormLaboratoire().setShowModalPanelPrint(true);
                     } else if (this.nature == 76) {
                        this.formBakingBeanMedical.getFormHospitalisation().setShowModalPanelPrint(true);
                     } else if (this.nature == 77) {
                        this.formBakingBeanMedical.getFormDevisMedical().setShowModalPanelPrint(true);
                     } else if (this.nature == 78) {
                        this.formBakingBeanMedical.getFormRefacturation().setShowModalPanelPrint(true);
                     } else if (this.nature == 182) {
                        this.formBakingBeanMedical.getFormRefacturation().setShowModalPanelPrint(true);
                     } else if (this.nature == 81) {
                        this.formBakingBeanPaye.getFormFicheSalarie().setShowModalPanelPrint(true);
                     } else if (this.nature != 82 && this.nature != 83 && this.nature != 84 && this.nature != 85 && this.nature != 86 && this.nature != 93) {
                        if (this.nature == 87) {
                           this.formBakingBeanPaye.getFormPrets().setShowModalPanelPrint(true);
                        } else if (this.nature != 88 && this.nature != 89) {
                           if (this.nature == 91) {
                              this.formBakingBeanPaye.getFormMissions().setShowModalPanelPrint(true);
                           } else if (this.nature == 92) {
                              this.formBakingBeanPaye.getFormPointage().setShowModalPanelPrint(true);
                           } else if (this.nature == 94) {
                              this.formBakingBeanPaye.getFormPointage().setShowModalPanelPrint(true);
                           } else if (this.nature == 100) {
                              this.formBakingBeanEducation.getFormGestionEleves().setShowModalPanelPrint(true);
                           } else if (this.nature == 101) {
                              this.formBakingBeanEducation.getFormDocumentMediatheque().setShowModalPanelPrint(true);
                           } else if (this.nature == 102) {
                              this.formBakingBeanEducation.getFormGestionEleves().setShowModalPanelPrint(true);
                           } else if (this.nature == 103) {
                              this.formBakingBeanEducation.getFormGestionEleves().setShowModalPanelPrint(true);
                           } else if (this.nature == 104) {
                              this.formBakingBeanEducation.getFormGestionEleves().setShowModalPanelPrint(true);
                           } else if (this.nature == 160) {
                              this.formBakingBeanImmobilier.getFormBiensImmobilier().setShowModalPanelPrint(true);
                           } else if (this.nature == 161) {
                              this.formBakingBeanImmobilier.getFormGeranceImmobilier().setShowModalPanelPrint(true);
                           } else if (this.nature == 162) {
                              this.formBakingBeanImmobilier.getFormBailImmobilier().setShowModalPanelPrint(true);
                           } else if (this.nature == 163) {
                              this.formBakingBeanImmobilier.getFormTravauxImmobilier().setShowModalPanelPrint(true);
                           } else if (this.nature == 164) {
                              this.formBakingBeanImmobilier.getFormTravauxImmobilier().setShowModalPanelPrint(true);
                           } else if (this.nature == 165) {
                              this.formBakingBeanImmobilier.getFormFactureImmobilier().setShowModalPanelPrint(true);
                           } else if (this.nature == 171) {
                              this.formBakingBeanImmobilier.getFormSyndicImmobilier().setShowModalPanelPrint(true);
                           } else if (this.nature == 172) {
                              this.formBakingBeanImmobilier.getFormBudgetImmobilier().setShowModalPanelPrint(true);
                           } else if (this.nature == 173) {
                              this.formBakingBeanImmobilier.getFormAppelChargeImmobilier().setShowModalPanelPrint(true);
                           } else if (this.nature == 181) {
                              this.formBakingBeanMedical.getFormNoteDebitMedical().setShowModalPanelPrint(true);
                           } else if (this.nature == 250) {
                              this.formBakingBeanForet.getFormForetInventaire().setShowModalPanelPrint(true);
                           }
                        } else {
                           this.formBakingBeanPaye.getFormConges().setShowModalPanelPrint(true);
                        }
                     } else {
                        this.formBakingBeanPaye.getFormFicheSalarie().setShowModalPanelPrint(true);
                     }
                  }
               }
            } else {
               this.formBakingBeanOffice.getFormReunion().setShowModalPanelPrint(true);
            }
         }
      }

   }

   public void closeImpression() {
      if (this.nature != 5 && this.nature != 120 && this.nature != 121) {
         if (this.nature == 122) {
            this.formBakingBeanOffice.getFormSms().setShowModalPanelPrint(false);
         } else if (this.nature == 10) {
            this.formBakingBeanAchats.getFormDemandeAchats().setShowModalPanelPrint(false);
         } else if (this.nature == 11) {
            this.formBakingBeanAchats.getFormCotationAchats().setShowModalPanelPrint(false);
         } else if (this.nature == 12) {
            this.formBakingBeanAchats.getFormCommandeAchats().setShowModalPanelPrint(false);
         } else if (this.nature == 13) {
            this.formBakingBeanAchats.getFormReceptionAchats().setShowModalPanelPrint(false);
         } else if (this.nature == 14) {
            this.formBakingBeanAchats.getFormRetourAchats().setShowModalPanelPrint(false);
         } else if (this.nature == 15) {
            this.formBakingBeanAchats.getFormFactureAchats().setShowModalPanelPrint(false);
         } else if (this.nature == 16) {
            this.formBakingBeanAchats.getFormAvoirAchats().setShowModalPanelPrint(false);
         } else if (this.nature == 17) {
            this.formBakingBeanAchats.getFormNoteDebitAchats().setShowModalPanelPrint(false);
         } else if (this.nature == 18) {
            this.formBakingBeanAchats.getFormFraisAchats().setShowModalPanelPrint(false);
         } else if (this.nature == 20) {
            this.formBakingBeanVentes.getFormBesoinVentes().setShowModalPanelPrint(false);
         } else if (this.nature == 7 && this.formBakingBeanVentes != null) {
            this.formBakingBeanVentes.getFormCommissionsVentes().setShowModalPanelPrint(false);
         } else if (this.nature == 7 && this.formBakingBeanMedical != null) {
            this.formBakingBeanMedical.getFormCommissionsMedicales().setShowModalPanelPrint(false);
         } else if (this.nature == 8) {
            this.formBakingBeanVentes.getFormSimulContratVentes().setShowModalPanelPrint(false);
         } else if (this.nature == 21) {
            this.formBakingBeanVentes.getFormDevisVentes().setShowModalPanelPrint(false);
         } else if (this.nature == 22) {
            this.formBakingBeanVentes.getFormCommandeVentes().setShowModalPanelPrint(false);
         } else if (this.nature == 23) {
            this.formBakingBeanVentes.getFormLivraisonVentes().setShowModalPanelPrint(false);
         } else if (this.nature == 24) {
            this.formBakingBeanVentes.getFormRetourVentes().setShowModalPanelPrint(false);
         } else if (this.nature == 25) {
            this.formBakingBeanVentes.getFormFactureVentes().setShowModalPanelPrint(false);
         } else if (this.nature == 26) {
            this.formBakingBeanVentes.getFormAvoirVentes().setShowModalPanelPrint(false);
         } else if (this.nature == 27) {
            this.formBakingBeanVentes.getFormNoteDebitVentes().setShowModalPanelPrint(false);
         } else if (this.nature == 127 && this.formBakingBeanVentes != null) {
            this.formBakingBeanVentes.getFormAffaires().setShowModalPanelPrint(false);
         } else if (this.nature == 140) {
            this.formBakingBeanVentes.getFormContratVentes().setShowModalPanelPrint(false);
         } else if (this.nature == 141) {
            this.formBakingBeanVentes.getFormCampagneVentes().setShowModalPanelPrint(false);
         } else if (this.nature == 142) {
            this.formBakingBeanVentes.getFormFactureInterneVentes().setShowModalPanelPrint(false);
         } else if (this.nature == 28) {
            this.formBakingBeanVentes.getFormChargementVentes().setShowModalPanelPrint(false);
         } else if (this.nature == 30) {
            this.formBakingBeanAchats.getFormInventaire().setShowModalPanelPrint(false);
         } else if (this.nature == 31) {
            this.formBakingBeanAchats.getFormBonEntree().setShowModalPanelPrint(false);
         } else if (this.nature == 32) {
            this.formBakingBeanAchats.getFormBonSortie().setShowModalPanelPrint(false);
         } else if (this.nature == 33) {
            this.formBakingBeanAchats.getFormCession().setShowModalPanelPrint(false);
         } else if (this.nature == 34) {
            this.formBakingBeanAchats.getFormProduction().setShowModalPanelPrint(false);
         } else if (this.nature == 35) {
            this.formBakingBeanAchats.getFormValorisationAchats().setShowModalPanelPrint(false);
         } else if (this.nature != 36) {
            if (this.nature == 37) {
               this.formBakingBeanAchats.getFormExtraitBudget().setShowModalPanelPrint(false);
            } else if (this.nature == 47) {
               this.formBakingBeanParcs.getFormManifestePrc().setShowModalPanelPrint(false);
            } else if (this.nature == 50) {
               this.formBakingBeanComptabilite.getFormLoyers().setShowModalPanelPrint(false);
            } else if (this.nature == 51) {
               this.formBakingBeanComptabilite.getFormAmortissements().setShowModalPanelPrint(false);
            } else if (this.nature == 52) {
               this.formBakingBeanComptabilite.getFormBudget().setShowModalPanelPrint(false);
            } else if (this.nature == 53) {
               this.formBakingBeanComptabilite.getFormJournauxComptables().setShowModalPanelPrint(false);
            } else if (this.nature == 531) {
               this.formBakingBeanComptabilite.getFormBrouillardMois().setShowModalPanelPrint(false);
            } else if (this.nature == 532) {
               this.formBakingBeanComptabilite.getFormBrouillardMois().setShowModalPanelPrint(false);
            } else if (this.nature == 534) {
               this.formBakingBeanComptabilite.getFormExtraitCompte().setShowModalPanelPrint(false);
            } else if (this.nature == 535) {
               this.formBakingBeanComptabilite.getFormExtraitAnalList().setShowModalPanelPrint(false);
            } else if (this.nature == 538) {
               this.formBakingBeanComptabilite.getFormExtraitClasse().setShowModalPanelPrint(false);
            } else if (this.nature == 539) {
               this.formBakingBeanComptabilite.getFormExtraitProjet().setShowModalPanelPrint(false);
            } else if (this.nature == 540) {
               this.formBakingBeanComptabilite.getFormExtraitBudget().setShowModalPanelPrint(false);
            } else if (this.nature == 54) {
               this.formBakingBeanComptabilite.getFormBudgetTresorerie().setShowModalPanelPrint(false);
            } else if (this.nature == 56) {
               this.formBakingBeanComptabilite.getFormRapprochement().setShowModalPanelPrint(false);
            } else if (this.nature == 71) {
               this.formBakingBeanMedical.getFormConsultationGene().setShowModalPanelPrint(false);
            } else if (this.nature != 72) {
               if (this.nature == 73) {
                  this.formBakingBeanMedical.getFormPharmacie().setShowModalPanelPrint(false);
               } else if (this.nature == 74) {
                  this.formBakingBeanMedical.getFormLaboratoire().setShowModalPanelPrint(false);
               } else if (this.nature == 741) {
                  this.formBakingBeanMedical.getFormLaboratoire().setShowModalPanelPrint(false);
               } else if (this.nature == 76) {
                  this.formBakingBeanMedical.getFormHospitalisation().setShowModalPanelPrint(false);
               } else if (this.nature == 77) {
                  this.formBakingBeanMedical.getFormDevisMedical().setShowModalPanelPrint(false);
               } else if (this.nature == 78) {
                  this.formBakingBeanMedical.getFormRefacturation().setShowModalPanelPrint(false);
               } else if (this.nature == 182) {
                  this.formBakingBeanMedical.getFormRefacturation().setShowModalPanelPrint(false);
               } else if (this.nature == 81) {
                  this.formBakingBeanPaye.getFormFicheSalarie().setShowModalPanelPrint(false);
               } else if (this.nature != 82 && this.nature != 83 && this.nature != 84 && this.nature != 85 && this.nature != 86 && this.nature != 93) {
                  if (this.nature == 87) {
                     this.formBakingBeanPaye.getFormPrets().setShowModalPanelPrint(false);
                  } else if (this.nature != 88 && this.nature != 89) {
                     if (this.nature == 91) {
                        this.formBakingBeanPaye.getFormMissions().setShowModalPanelPrint(false);
                     } else if (this.nature == 92) {
                        this.formBakingBeanPaye.getFormPointage().setShowModalPanelPrint(false);
                     } else if (this.nature == 94) {
                        this.formBakingBeanPaye.getFormPointage().setShowModalPanelPrint(false);
                     } else if (this.nature == 100) {
                        this.formBakingBeanEducation.getFormGestionEleves().setShowModalPanelPrint(false);
                     } else if (this.nature == 101) {
                        this.formBakingBeanEducation.getFormDocumentMediatheque().setShowModalPanelPrint(false);
                     } else if (this.nature == 102) {
                        this.formBakingBeanEducation.getFormGestionEleves().setShowModalPanelPrint(false);
                     } else if (this.nature == 103) {
                        this.formBakingBeanEducation.getFormGestionEleves().setShowModalPanelPrint(false);
                     } else if (this.nature == 104) {
                        this.formBakingBeanEducation.getFormGestionEleves().setShowModalPanelPrint(false);
                     } else if (this.nature == 160) {
                        this.formBakingBeanImmobilier.getFormBiensImmobilier().setShowModalPanelPrint(false);
                     } else if (this.nature == 161) {
                        this.formBakingBeanImmobilier.getFormGeranceImmobilier().setShowModalPanelPrint(false);
                     } else if (this.nature == 162) {
                        this.formBakingBeanImmobilier.getFormBailImmobilier().setShowModalPanelPrint(false);
                     } else if (this.nature == 163) {
                        this.formBakingBeanImmobilier.getFormTravauxImmobilier().setShowModalPanelPrint(false);
                     } else if (this.nature == 164) {
                        this.formBakingBeanImmobilier.getFormTravauxImmobilier().setShowModalPanelPrint(false);
                     } else if (this.nature == 165) {
                        this.formBakingBeanImmobilier.getFormFactureImmobilier().setShowModalPanelPrint(false);
                     } else if (this.nature == 171) {
                        this.formBakingBeanImmobilier.getFormSyndicImmobilier().setShowModalPanelPrint(false);
                     } else if (this.nature == 172) {
                        this.formBakingBeanImmobilier.getFormBudgetImmobilier().setShowModalPanelPrint(false);
                     } else if (this.nature == 173) {
                        this.formBakingBeanImmobilier.getFormAppelChargeImmobilier().setShowModalPanelPrint(false);
                     } else if (this.nature == 181) {
                        this.formBakingBeanMedical.getFormNoteDebitMedical().setShowModalPanelPrint(false);
                     } else if (this.nature == 250) {
                        this.formBakingBeanForet.getFormForetInventaire().setShowModalPanelPrint(false);
                     }
                  } else {
                     this.formBakingBeanPaye.getFormConges().setShowModalPanelPrint(false);
                  }
               } else {
                  this.formBakingBeanPaye.getFormFicheSalarie().setShowModalPanelPrint(false);
               }
            }
         }
      } else {
         this.formBakingBeanOffice.getFormReunion().setShowModalPanelPrint(false);
      }

   }

   public void calculeTauxDevise() throws HibernateException, NamingException {
      if (this.devise.equals(this.structureLog.getStrdevise())) {
         this.tauxDevise = 1.0F;
      } else {
         new Devise();
         DeviseDao var2 = new DeviseDao(this.baseLog, this.utilInitHibernate);
         Devise var1 = var2.chargerLesDevises(this.devise, (Session)null);
         if (var1 != null) {
            this.tauxDevise = var1.getDevTaux2();
            if (this.tauxDevise == 0.0F) {
               this.tauxDevise = 1.0F;
            }
         } else {
            this.tauxDevise = 1.0F;
         }
      }

   }

   public void listeDocImp() {
      if (this.var_choix_modele != 0 && this.var_choix_modele != 2 && this.var_choix_modele != 3) {
         this.affListeDoc = true;
         if (this.nature == 5) {
            if (this.formBakingBeanOffice.getFormReunion().getReunionEntete().getReuEtat() == 0) {
               this.documentImpressionItems = this.formBakingBeanOffice.getFormReunion().getListeConvocationImpressionItems();
            } else {
               this.documentImpressionItems = this.formBakingBeanOffice.getFormReunion().getListeResultatImpressionItems();
            }
         } else if (this.nature == 120) {
            this.documentImpressionItems = this.formBakingBeanOffice.getFormReunion().getListeResultatImpressionItems();
         } else if (this.nature == 121) {
            this.documentImpressionItems = this.formBakingBeanOffice.getFormReunion().getListeResultatImpressionItems();
         } else if (this.nature == 122) {
            this.documentImpressionItems = this.formBakingBeanOffice.getFormSms().getListeImpressionItems();
         } else if (this.nature == 35 || this.nature >= 10 && this.nature <= 19) {
            this.listeImpressionItems = this.formBakingBeanAchats.getListeImpressionItems();
         } else if ((this.nature != 7 || this.formBakingBeanVentes == null) && this.nature != 8 && (this.nature < 20 || this.nature > 29) && this.nature != 140 && this.nature != 141 && this.nature != 142 && this.nature != 143) {
            if (this.nature == 127 && this.formBakingBeanVentes != null) {
               this.listeImpressionItems = this.formBakingBeanVentes.getListeImpressionItems();
            } else if (this.nature == 7 && this.formBakingBeanMedical != null) {
               this.listeImpressionItems = this.formBakingBeanMedical.getListeImpressionItems();
            } else if ((this.nature < 30 || this.nature > 34) && (this.nature < 36 || this.nature > 39)) {
               if (this.nature != 50 && this.nature != 51 && this.nature != 52 && this.nature != 53 && this.nature != 531 && this.nature != 532 && this.nature != 534 && this.nature != 535 && this.nature != 538 && this.nature != 539 && this.nature != 540 && this.nature != 54 && this.nature != 56) {
                  if ((this.nature < 70 || this.nature > 79) && this.nature != 181 && this.nature != 741) {
                     if (this.nature == 182) {
                        this.listeImpressionItems = this.formBakingBeanMedical.getListeImpressionItems();
                     } else if (this.nature == 81) {
                        this.listeImpressionItems = this.formBakingBeanPaye.getFormFicheSalarie().getListeImpressionItems();
                     } else if (this.nature != 82 && this.nature != 83 && this.nature != 84 && this.nature != 85 && this.nature != 86 && this.nature != 93) {
                        if (this.nature == 87) {
                           this.listeImpressionItems = this.formBakingBeanPaye.getFormPrets().getListeImpressionItems();
                        } else if (this.nature != 88 && this.nature != 89) {
                           if (this.nature == 91) {
                              this.listeImpressionItems = this.formBakingBeanPaye.getFormMissions().getListeImpressionItems();
                           } else if (this.nature == 92) {
                              this.listeImpressionItems = this.formBakingBeanPaye.getFormPointage().getListeImpressionItems();
                           } else if (this.nature == 94) {
                              this.listeImpressionItems = this.formBakingBeanPaye.getFormPointage().getListeImpressionItems();
                           } else if (this.nature == 100) {
                              this.documentImpressionItems = this.formBakingBeanEducation.getFormGestionEleves().getListeImpressionItems();
                           } else if (this.nature == 101) {
                              this.documentImpressionItems = this.formBakingBeanEducation.getFormGestionEleves().getListeImpressionItems();
                           } else if (this.nature == 102) {
                              this.documentImpressionItems = this.formBakingBeanEducation.getFormGestionEleves().getListeImpressionItems();
                           } else if (this.nature == 103) {
                              this.documentImpressionItems = this.formBakingBeanEducation.getFormGestionEleves().getListeImpressionItems();
                           } else if (this.nature == 104) {
                              this.documentImpressionItems = this.formBakingBeanEducation.getFormGestionEleves().getListeImpressionItems();
                           } else if (this.nature == 105) {
                              this.documentImpressionItems = this.formBakingBeanEducation.getFormGestionEleves().getListeImpressionItems();
                           } else if (this.nature >= 160 && this.nature <= 179) {
                              this.listeImpressionItems = this.formBakingBeanImmobilier.getListeImpressionItems();
                           } else if (this.nature == 250) {
                              this.listeImpressionItems = this.formBakingBeanForet.getListeImpressionItems();
                           }
                        } else {
                           this.listeImpressionItems = this.formBakingBeanPaye.getFormConges().getListeImpressionItems();
                        }
                     } else {
                        this.listeImpressionItems = this.formBakingBeanPaye.getFormFicheSalarie().getListeImpressionItems();
                     }
                  } else {
                     this.listeImpressionItems = this.formBakingBeanMedical.getListeImpressionItems();
                  }
               }
            } else {
               this.listeImpressionItems = this.formBakingBeanAchats.getListeImpressionItems();
            }
         } else {
            this.listeImpressionItems = this.formBakingBeanVentes.getListeImpressionItems();
         }
      } else {
         this.affListeDoc = false;
         if (this.nature == 5) {
            if (this.formBakingBeanOffice.getFormReunion().getReunionEntete().getReuEtat() == 0) {
               this.documentImpressionItems = this.formBakingBeanOffice.getFormReunion().getDocumentConvocationImpressionItems();
            } else {
               this.documentImpressionItems = this.formBakingBeanOffice.getFormReunion().getDocumentResultatImpressionItems();
            }
         } else if (this.nature == 120) {
            this.documentImpressionItems = this.formBakingBeanOffice.getFormReunion().getDocumentResultatImpressionItems();
         } else if (this.nature == 121) {
            this.documentImpressionItems = this.formBakingBeanOffice.getFormReunion().getDocumentResultatImpressionItems();
         } else if (this.nature == 122) {
            this.documentImpressionItems = this.formBakingBeanOffice.getFormSms().getDocumentImpressionItems();
         } else if ((this.nature != 7 || this.formBakingBeanVentes == null) && this.nature != 8 && (this.nature < 20 || this.nature > 29) && this.nature != 140 && this.nature != 141 && this.nature != 142) {
            if (this.nature == 127 && this.formBakingBeanVentes != null) {
               this.documentImpressionItems = this.formBakingBeanVentes.getDocumentImpressionItems();
            } else if (this.nature == 7 && this.formBakingBeanMedical != null) {
               this.documentImpressionItems = this.formBakingBeanMedical.getDocumentImpressionItems();
            } else if ((this.nature < 30 || this.nature > 34) && (this.nature < 38 || this.nature > 39)) {
               if (this.nature == 35 || this.nature >= 10 && this.nature <= 19) {
                  this.documentImpressionItems = this.formBakingBeanAchats.getDocumentImpressionItems();
               } else if (this.nature != 36) {
                  if (this.nature == 37) {
                     this.documentImpressionItems = this.formBakingBeanAchats.getFormExtraitBudget().getLesModelsimpression();
                  } else if (this.nature == 47) {
                     if (this.var_choix_modele == 2) {
                        this.documentImpressionItems = this.formBakingBeanParcs.recupererModeleLettreVoiture();
                     } else {
                        this.documentImpressionItems = this.formBakingBeanParcs.recupererModeleFicheProduit();
                     }
                  } else if (this.nature == 50) {
                     this.documentImpressionItems = this.formBakingBeanComptabilite.getFormLoyers().getLesModelsimpression();
                  } else if (this.nature == 51) {
                     this.documentImpressionItems = this.formBakingBeanComptabilite.getFormAmortissements().getImpressionStandardsItems();
                  } else if (this.nature == 52) {
                     this.documentImpressionItems = this.formBakingBeanComptabilite.getFormBudget().getLesModelsimpression();
                  } else if (this.nature == 53) {
                     this.documentImpressionItems = this.formBakingBeanComptabilite.getFormJournauxComptables().getLesModelsimpression();
                  } else if (this.nature == 531) {
                     this.documentImpressionItems = this.formBakingBeanComptabilite.getFormBrouillardMois().getLesModelsimpression();
                  } else if (this.nature == 532) {
                     this.documentImpressionItems = this.formBakingBeanComptabilite.getFormBrouillardMois().getLesModelsimpression();
                  } else if (this.nature == 534) {
                     this.documentImpressionItems = this.formBakingBeanComptabilite.getFormExtraitCompte().getLesModelsimpression();
                  } else if (this.nature == 535) {
                     this.documentImpressionItems = this.formBakingBeanComptabilite.getFormExtraitAnalList().getLesModelsimpression();
                  } else if (this.nature == 538) {
                     this.documentImpressionItems = this.formBakingBeanComptabilite.getFormExtraitClasse().getLesModelsimpression();
                  } else if (this.nature == 539) {
                     this.documentImpressionItems = this.formBakingBeanComptabilite.getFormExtraitProjet().getLesModelsimpression();
                  } else if (this.nature == 540) {
                     this.documentImpressionItems = this.formBakingBeanComptabilite.getFormExtraitBudget().getLesModelsimpression();
                  } else if (this.nature == 54) {
                     this.documentImpressionItems = this.formBakingBeanComptabilite.getFormBudgetTresorerie().getLesModelsimpression();
                  } else if (this.nature == 56) {
                     this.documentImpressionItems = this.formBakingBeanComptabilite.getFormRapprochement().getLesModelsimpression();
                  } else if ((this.nature < 70 || this.nature > 77) && this.nature != 79 && this.nature != 181 && this.nature != 741) {
                     if (this.nature == 78) {
                        this.documentImpressionItems = this.formBakingBeanMedical.getFormRefacturation().chargerLesModelesImpresion();
                     } else if (this.nature == 182) {
                        this.documentImpressionItems = this.formBakingBeanMedical.getDocumentImpressionItems();
                     } else if (this.nature == 81) {
                        this.documentImpressionItems = this.formBakingBeanPaye.getFormFicheSalarie().getDocumentImpressionItems();
                     } else if (this.nature != 82 && this.nature != 83 && this.nature != 84 && this.nature != 85 && this.nature != 86 && this.nature != 93) {
                        if (this.nature == 87) {
                           this.documentImpressionItems = this.formBakingBeanPaye.getFormPrets().getDocumentImpressionItems();
                        } else if (this.nature != 88 && this.nature != 89) {
                           if (this.nature == 91) {
                              this.documentImpressionItems = this.formBakingBeanPaye.getFormMissions().getDocumentImpressionItems();
                           } else if (this.nature == 92) {
                              this.documentImpressionItems = this.formBakingBeanPaye.getFormPointage().getDocumentImpressionItems();
                           } else if (this.nature == 94) {
                              this.documentImpressionItems = this.formBakingBeanPaye.getFormPointage().getDocumentImpressionItems();
                           } else if (this.nature == 100) {
                              this.documentImpressionItems = this.formBakingBeanEducation.getFormGestionEleves().getDocumentImpressionItems();
                           } else if (this.nature == 101) {
                              this.documentImpressionItems = this.formBakingBeanEducation.getFormGestionEleves().getDocumentImpressionItems();
                           } else if (this.nature == 102) {
                              this.documentImpressionItems = this.formBakingBeanEducation.getFormGestionEleves().getDocumentImpressionItems();
                           } else if (this.nature == 103) {
                              this.documentImpressionItems = this.formBakingBeanEducation.getFormGestionEleves().getDocumentImpressionItems();
                           } else if (this.nature == 104) {
                              this.documentImpressionItems = this.formBakingBeanEducation.getFormGestionEleves().getDocumentImpressionItems();
                           } else if (this.nature == 105) {
                              this.documentImpressionItems = this.formBakingBeanEducation.getFormGestionEleves().getDocumentImpressionItems();
                           } else if (this.nature >= 160 && this.nature <= 179) {
                              this.documentImpressionItems = this.formBakingBeanImmobilier.getDocumentImpressionItems();
                           } else if (this.nature == 250) {
                              this.documentImpressionItems = this.formBakingBeanForet.getDocumentImpressionItems();
                           }
                        } else {
                           this.documentImpressionItems = this.formBakingBeanPaye.getFormConges().getDocumentImpressionItems();
                        }
                     } else {
                        this.documentImpressionItems = this.formBakingBeanPaye.getFormFicheSalarie().getDocumentImpressionItems();
                        this.avenantImpressionItems = this.formBakingBeanPaye.getFormFicheSalarie().getListeAvenantItems();
                     }
                  } else {
                     this.documentImpressionItems = this.formBakingBeanMedical.getDocumentImpressionItems();
                  }
               }
            } else {
               this.documentImpressionItems = this.formBakingBeanAchats.getDocumentImpressionItems();
            }
         } else {
            if (this.nature == 28) {
               if (this.var_choix_modele == 2) {
                  this.formBakingBeanVentes.recupererModeleRechargement();
               } else if (this.var_choix_modele == 3) {
                  this.formBakingBeanVentes.recupererModeleDechargement();
               } else {
                  this.formBakingBeanVentes.recupererModeleDocument();
               }
            }

            if (this.formBakingBeanVentes.getDocumentImpressionItems() != null && this.formBakingBeanVentes.getDocumentImpressionItems().size() != 0) {
               this.documentImpressionItems = this.formBakingBeanVentes.getDocumentImpressionItems();
            } else {
               this.documentImpressionItems = new ArrayList();
            }
         }
      }

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

   public void imprimerMAIL() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      if (this.impEmetteur != null && !this.impEmetteur.isEmpty() && (this.impDestinataire != null && !this.impDestinataire.isEmpty() || this.impDestinataireCC != null && !this.impDestinataireCC.isEmpty() || this.impDestinataireCCI != null && !this.impDestinataireCCI.isEmpty())) {
         this.format = "MAIL";
         this.imprimer();
      }

   }

   public void envoieMAIL() throws SQLException, JRException, IOException, HibernateException, NamingException {
      if (!this.affMail) {
         if (this.utilPrint == null) {
            this.utilPrint = new UtilPrint(this.utilInitHibernate);
         }

         this.utilPrint.setNature(this.nature);
         this.impCorpsMail = this.utilPrint.calcultexte();
         if (this.nature == 10) {
            this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, (Tiers)null, "");
         } else if (this.nature == 11) {
            this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, this.formBakingBeanAchats.getFormCotationAchats().getCotationEnteteAchats().getTiers(), this.formBakingBeanAchats.getFormCotationAchats().getCotationEnteteAchats().getCotDiversMail());
         } else if (this.nature == 12) {
            this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, this.formBakingBeanAchats.getFormCommandeAchats().getCommandeEnteteAchats().getTiers(), this.formBakingBeanAchats.getFormCommandeAchats().getCommandeEnteteAchats().getCmdDiversMail());
         } else if (this.nature == 13) {
            this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, this.formBakingBeanAchats.getFormReceptionAchats().getReceptionEnteteAchats().getTiers(), this.formBakingBeanAchats.getFormReceptionAchats().getReceptionEnteteAchats().getRecDiversMail());
         } else if (this.nature == 14) {
            this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, this.formBakingBeanAchats.getFormRetourAchats().getRetourEnteteAchats().getTiers(), this.formBakingBeanAchats.getFormRetourAchats().getRetourEnteteAchats().getBrfDiversMail());
         } else if (this.nature == 15) {
            this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, this.formBakingBeanAchats.getFormFactureAchats().getFactureEnteteAchats().getTiers(), this.formBakingBeanAchats.getFormFactureAchats().getFactureEnteteAchats().getFcfDiversMail());
         } else if (this.nature == 16) {
            this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, this.formBakingBeanAchats.getFormAvoirAchats().getAvoirEnteteAchats().getTiers(), this.formBakingBeanAchats.getFormAvoirAchats().getAvoirEnteteAchats().getAvfDiversMail());
         } else if (this.nature == 17) {
            this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, this.formBakingBeanAchats.getFormNoteDebitAchats().getNoteDebitEnteteAchats().getTiers(), this.formBakingBeanAchats.getFormNoteDebitAchats().getNoteDebitEnteteAchats().getNdfDiversMail());
         } else if (this.nature == 18) {
            this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, this.formBakingBeanAchats.getFormFraisAchats().getFraisEnteteAchats().getTiers(), this.formBakingBeanAchats.getFormFraisAchats().getFraisEnteteAchats().getFsfDiversMail());
         } else if (this.nature == 35) {
            this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, (Tiers)null, "");
         } else if (this.nature == 20) {
            this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, this.formBakingBeanVentes.getFormBesoinVentes().getBesoinEnteteVentes().getTiers(), this.formBakingBeanVentes.getFormBesoinVentes().getBesoinEnteteVentes().getBesDiversMail());
         } else if (this.nature == 7) {
            this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, (Tiers)null, "");
         } else if (this.nature == 8) {
            this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, this.formBakingBeanVentes.getFormSimulContratVentes().getSimulationEnteteVentes().getTiers(), this.formBakingBeanVentes.getFormSimulContratVentes().getSimulationEnteteVentes().getSimcrtDiversMail());
         } else if (this.nature == 21) {
            this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, this.formBakingBeanVentes.getFormDevisVentes().getDevisEnteteVentes().getTiers(), this.formBakingBeanVentes.getFormDevisVentes().getDevisEnteteVentes().getDvsDiversMail());
         } else if (this.nature == 22) {
            this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, this.formBakingBeanVentes.getFormCommandeVentes().getCommandeEnteteVentes().getTiers(), this.formBakingBeanVentes.getFormCommandeVentes().getCommandeEnteteVentes().getBcmDiversMail());
         } else if (this.nature == 23) {
            this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, this.formBakingBeanVentes.getFormLivraisonVentes().getLivraisonEnteteVentes().getTiers(), this.formBakingBeanVentes.getFormLivraisonVentes().getLivraisonEnteteVentes().getBlvDiversMail());
         } else if (this.nature == 24) {
            this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, this.formBakingBeanVentes.getFormRetourVentes().getRetourEnteteVentes().getTiers(), this.formBakingBeanVentes.getFormRetourVentes().getRetourEnteteVentes().getBrtDiversMail());
         } else if (this.nature == 25) {
            this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, this.formBakingBeanVentes.getFormFactureVentes().getFactureEnteteVentes().getTiers(), this.formBakingBeanVentes.getFormFactureVentes().getFactureEnteteVentes().getFacDiversMail());
         } else if (this.nature == 26) {
            this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, this.formBakingBeanVentes.getFormAvoirVentes().getAvoirEnteteVentes().getTiers(), this.formBakingBeanVentes.getFormAvoirVentes().getAvoirEnteteVentes().getAvrDiversMail());
         } else if (this.nature == 27) {
            this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, this.formBakingBeanVentes.getFormNoteDebitVentes().getNoteDebitEnteteVentes().getTiers(), this.formBakingBeanVentes.getFormNoteDebitVentes().getNoteDebitEnteteVentes().getNdbDiversMail());
         } else if (this.nature == 71) {
            this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, this.formBakingBeanMedical.getFormConsultationGene().getPatients());
         } else if (this.nature == 73) {
            this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, this.formBakingBeanMedical.getFormPharmacie().getPatients());
         } else if (this.nature == 74) {
            this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, this.formBakingBeanMedical.getFormLaboratoire().getPatients());
         } else if (this.nature == 76) {
            this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, this.formBakingBeanMedical.getFormHospitalisation().getPatients());
         } else if (this.nature != 80 && this.nature != 81 && this.nature != 82 && this.nature != 83 && this.nature != 84 && this.nature != 85 && this.nature != 87 && this.nature != 93 && this.nature != 99) {
            if (this.nature != 88 && this.nature != 89) {
               if (this.nature == 90) {
                  this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, this.formBakingBeanPaye.getFormCalculBulletin().getSalaries());
               } else if (this.nature == 91) {
                  this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, this.formBakingBeanPaye.getFormMissions().getSalaries());
               } else if (this.nature == 92) {
                  this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, this.formBakingBeanPaye.getFormPointage().getSalaries());
               } else {
                  this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, (Tiers)null, "");
               }
            } else {
               this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, this.formBakingBeanPaye.getFormConges().getSalaries());
            }
         } else {
            this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, this.formBakingBeanPaye.getFormFicheSalarie().getSalaries());
         }

         if (this.utilPrint.getLesbalEmetteursItems().size() != 0) {
            this.affMail = true;
         } else {
            this.affMail = false;
         }
      } else {
         this.affMail = false;
      }

   }

   public void listener() {
   }

   public void imprimer() throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      if (this.utilPrint == null) {
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
      }

      if (this.nature != 5 && this.nature != 120 && this.nature != 121) {
         if (this.nature == 122) {
            this.formBakingBeanOffice.getFormSms().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
         } else if (this.nature == 10) {
            this.formBakingBeanAchats.getFormDemandeAchats().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
         } else if (this.nature == 11) {
            this.formBakingBeanAchats.getFormCotationAchats().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
         } else if (this.nature == 12) {
            this.formBakingBeanAchats.getFormCommandeAchats().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
         } else if (this.nature == 13) {
            this.formBakingBeanAchats.getFormReceptionAchats().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
         } else if (this.nature == 14) {
            this.formBakingBeanAchats.getFormRetourAchats().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
         } else if (this.nature == 15) {
            this.formBakingBeanAchats.getFormFactureAchats().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
         } else if (this.nature == 16) {
            this.formBakingBeanAchats.getFormAvoirAchats().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
         } else if (this.nature == 17) {
            this.formBakingBeanAchats.getFormNoteDebitAchats().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
         } else if (this.nature == 18) {
            this.formBakingBeanAchats.getFormFraisAchats().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
         } else if (this.nature == 20) {
            this.formBakingBeanVentes.getFormBesoinVentes().impression(this.utilPrint, this.var_choix_modele, this.var_choix_poids, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
         } else if (this.nature == 7 && this.formBakingBeanVentes != null) {
            this.formBakingBeanVentes.getFormCommissionsVentes().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
         } else if (this.nature == 7 && this.formBakingBeanMedical != null) {
            this.formBakingBeanMedical.getFormCommissionsMedicales().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
         } else if (this.nature == 8) {
            this.formBakingBeanVentes.getFormSimulContratVentes().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
         } else if (this.nature == 21) {
            this.formBakingBeanVentes.getFormDevisVentes().choixDeviseImpression(this.devise, this.tauxDevise);
            this.formBakingBeanVentes.getFormDevisVentes().impression(this.utilPrint, this.var_choix_modele, this.var_choix_poids, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
         } else if (this.nature == 22) {
            this.formBakingBeanVentes.getFormCommandeVentes().choixDeviseImpression(this.devise, this.tauxDevise);
            this.formBakingBeanVentes.getFormCommandeVentes().impression(this.utilPrint, this.var_choix_modele, this.var_choix_poids, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
         } else if (this.nature == 23) {
            this.formBakingBeanVentes.getFormLivraisonVentes().choixDeviseImpression(this.devise, this.tauxDevise);
            this.formBakingBeanVentes.getFormLivraisonVentes().impression(this.utilPrint, this.var_choix_modele, this.var_choix_poids, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
         } else if (this.nature == 24) {
            this.formBakingBeanVentes.getFormRetourVentes().choixDeviseImpression(this.devise, this.tauxDevise);
            this.formBakingBeanVentes.getFormRetourVentes().impression(this.utilPrint, this.var_choix_modele, this.var_choix_poids, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
         } else if (this.nature == 25) {
            this.formBakingBeanVentes.getFormFactureVentes().choixDeviseImpression(this.devise, this.tauxDevise);
            this.formBakingBeanVentes.getFormFactureVentes().impression(this.utilPrint, this.var_choix_modele, this.var_choix_poids, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
         } else if (this.nature == 26) {
            this.formBakingBeanVentes.getFormAvoirVentes().choixDeviseImpression(this.devise, this.tauxDevise);
            this.formBakingBeanVentes.getFormAvoirVentes().impression(this.utilPrint, this.var_choix_modele, this.var_choix_poids, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
         } else if (this.nature == 27) {
            this.formBakingBeanVentes.getFormNoteDebitVentes().choixDeviseImpression(this.devise, this.tauxDevise);
            this.formBakingBeanVentes.getFormNoteDebitVentes().impression(this.utilPrint, this.var_choix_modele, this.var_choix_poids, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
         } else if (this.nature == 127 && this.formBakingBeanVentes != null) {
            this.formBakingBeanVentes.getFormAffaires().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
         } else if (this.nature == 140) {
            this.formBakingBeanVentes.getFormContratVentes().impression(this.utilPrint, this.var_choix_modele, this.var_choix_poids, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
         } else if (this.nature == 141) {
            this.formBakingBeanVentes.getFormCampagneVentes().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
         } else if (this.nature == 142) {
            this.formBakingBeanVentes.getFormFactureInterneVentes().choixDeviseImpression(this.devise, this.tauxDevise);
            this.formBakingBeanVentes.getFormFactureInterneVentes().impression(this.utilPrint, this.var_choix_modele, this.var_choix_poids, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
         } else if (this.nature == 28) {
            this.formBakingBeanVentes.getFormChargementVentes().impression(this.utilPrint, this.var_choix_modele, this.var_choix_poids, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
         } else if (this.nature == 30) {
            this.formBakingBeanAchats.getFormInventaire().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
         } else if (this.nature == 31) {
            this.formBakingBeanAchats.getFormBonEntree().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
         } else if (this.nature == 32) {
            this.formBakingBeanAchats.getFormBonSortie().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
         } else if (this.nature == 33) {
            this.formBakingBeanAchats.getFormCession().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
         } else if (this.nature == 34) {
            this.formBakingBeanAchats.getFormProduction().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
         } else if (this.nature == 35) {
            this.formBakingBeanAchats.getFormValorisationAchats().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
         } else if (this.nature != 36) {
            if (this.nature == 37) {
               this.formBakingBeanAchats.getFormExtraitBudget().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
            } else if (this.nature == 47) {
               this.formBakingBeanParcs.getFormManifestePrc().impression(this.utilPrint, this.var_choix_modele, this.var_choix_poids, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
            } else if (this.nature == 50) {
               this.formBakingBeanComptabilite.getFormLoyers().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
            } else if (this.nature == 51) {
               this.formBakingBeanComptabilite.getFormAmortissements().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
            } else if (this.nature == 52) {
               this.formBakingBeanComptabilite.getFormBudget().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
            } else if (this.nature == 53) {
               this.formBakingBeanComptabilite.getFormJournauxComptables().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
            } else if (this.nature == 531) {
               this.formBakingBeanComptabilite.getFormBrouillardMois().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
            } else if (this.nature == 532) {
               this.formBakingBeanComptabilite.getFormBrouillardMois().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
            } else if (this.nature == 534) {
               this.formBakingBeanComptabilite.getFormExtraitCompte().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
            } else if (this.nature == 535) {
               this.formBakingBeanComptabilite.getFormExtraitAnalList().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
            } else if (this.nature == 538) {
               this.formBakingBeanComptabilite.getFormExtraitClasse().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
            } else if (this.nature == 539) {
               this.formBakingBeanComptabilite.getFormExtraitProjet().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
            } else if (this.nature == 540) {
               this.formBakingBeanComptabilite.getFormExtraitBudget().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
            } else if (this.nature == 54) {
               this.formBakingBeanComptabilite.getFormBudgetTresorerie().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
            } else if (this.nature == 56) {
               this.formBakingBeanComptabilite.getFormRapprochement().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
            } else if (this.nature == 71) {
               this.formBakingBeanMedical.getFormConsultationGene().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
            } else if (this.nature != 72) {
               if (this.nature == 73) {
                  this.formBakingBeanMedical.getFormPharmacie().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
               } else if (this.nature == 74) {
                  this.formBakingBeanMedical.getFormLaboratoire().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
               } else if (this.nature == 741) {
                  this.formBakingBeanMedical.getFormLaboratoire().initImpressionResultat(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
               } else if (this.nature == 76) {
                  this.formBakingBeanMedical.getFormHospitalisation().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
               } else if (this.nature == 77) {
                  this.formBakingBeanMedical.getFormDevisMedical().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
               } else if (this.nature == 78) {
                  this.formBakingBeanMedical.getFormRefacturation().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
               } else if (this.nature == 182) {
                  this.formBakingBeanMedical.getFormRefacturation().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
               } else if (this.nature == 81) {
                  this.formBakingBeanPaye.getFormFicheSalarie().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
               } else if (this.nature == 82) {
                  this.formBakingBeanPaye.getFormFicheSalarie().impressionContrat(this.utilPrint, this.var_choix_modele, this.avenantListe, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
               } else if (this.nature != 83 && this.nature != 84 && this.nature != 85 && this.nature != 86 && this.nature != 93) {
                  if (this.nature == 87) {
                     this.formBakingBeanPaye.getFormPrets().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
                  } else if (this.nature != 88 && this.nature != 89) {
                     if (this.nature == 91) {
                        this.formBakingBeanPaye.getFormMissions().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
                     } else if (this.nature == 92) {
                        this.formBakingBeanPaye.getFormPointage().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
                     } else if (this.nature == 94) {
                        this.formBakingBeanPaye.getFormPointage().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
                     } else if (this.nature == 100) {
                        this.formBakingBeanEducation.getFormGestionEleves().impression(this.utilPrint, this.var_choix_modele, this.var_choix_periode, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
                     } else if (this.nature == 101) {
                        this.formBakingBeanEducation.getFormDocumentMediatheque().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
                     } else if (this.nature == 102) {
                        this.formBakingBeanEducation.getFormGestionEleves().impression(this.utilPrint, this.var_choix_modele, this.var_choix_periode, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
                     } else if (this.nature == 103) {
                        this.formBakingBeanEducation.getFormGestionEleves().impression(this.utilPrint, this.var_choix_modele, this.var_choix_periode, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
                     } else if (this.nature == 104) {
                        this.formBakingBeanEducation.getFormGestionEleves().impression(this.utilPrint, this.var_choix_modele, this.var_choix_periode, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
                     } else if (this.nature == 105) {
                        this.formBakingBeanEducation.getFormGestionEleves().impression(this.utilPrint, this.var_choix_modele, this.var_choix_periode, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
                     } else if (this.nature == 160) {
                        this.formBakingBeanImmobilier.getFormBiensImmobilier().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
                     } else if (this.nature == 161) {
                        this.formBakingBeanImmobilier.getFormGeranceImmobilier().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
                     } else if (this.nature == 162) {
                        this.formBakingBeanImmobilier.getFormBailImmobilier().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
                     } else if (this.nature == 163) {
                        this.formBakingBeanImmobilier.getFormTravauxImmobilier().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
                     } else if (this.nature == 164) {
                        this.formBakingBeanImmobilier.getFormTravauxImmobilier().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
                     } else if (this.nature == 165) {
                        this.formBakingBeanImmobilier.getFormFactureImmobilier().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
                     } else if (this.nature == 171) {
                        this.formBakingBeanImmobilier.getFormSyndicImmobilier().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
                     } else if (this.nature == 172) {
                        this.formBakingBeanImmobilier.getFormBudgetImmobilier().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
                     } else if (this.nature == 173) {
                        this.formBakingBeanImmobilier.getFormAppelChargeImmobilier().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
                     } else if (this.nature == 181) {
                        this.formBakingBeanMedical.getFormNoteDebitMedical().choixDeviseImpression(this.devise, this.tauxDevise);
                        this.formBakingBeanMedical.getFormNoteDebitMedical().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
                     } else if (this.nature == 250) {
                        this.formBakingBeanForet.getFormForetInventaire().choixDeviseImpression(this.devise, this.tauxDevise);
                        this.formBakingBeanForet.getFormForetInventaire().impression(this.utilPrint, this.var_choix_modele, this.var_choix_poids, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
                     }
                  } else {
                     this.formBakingBeanPaye.getFormConges().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
                  }
               } else {
                  this.formBakingBeanPaye.getFormFicheSalarie().impressionRh(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
               }
            }
         }
      } else {
         this.formBakingBeanOffice.getFormReunion().impression(this.utilPrint, this.var_choix_modele, this.nomModeleDocument, this.nomModeleListe, this.format, this.impEmetteur, this.impDestinataire, this.impDestinataireCC, this.impDestinataireCCI, this.impCorpsMail);
      }

   }

   public void grapher() throws HibernateException, NamingException, JSONException, ParseException, IOException {
      this.nature = 0;
      boolean var1 = false;
      if (this.formBakingBeanAchats != null) {
         this.nature = this.formBakingBeanAchats.getNature();
         var1 = true;
      } else if (this.formBakingBeanVentes != null) {
         this.nature = this.formBakingBeanVentes.getNature();
         var1 = true;
      } else if (this.formBakingBeanOffice != null) {
         this.nature = this.formBakingBeanOffice.getNature();
         var1 = true;
      } else if (this.formBakingBeanComptabilite != null) {
         this.nature = this.formBakingBeanComptabilite.getNature();
         var1 = true;
      } else if (this.formBakingBeanParcs != null) {
         this.nature = this.formBakingBeanParcs.getNature();
         var1 = true;
      } else if (this.formBakingBeanMedical != null) {
         this.nature = this.formBakingBeanMedical.getNature();
         var1 = true;
      } else if (this.formBakingBeanImmobilier != null) {
         this.nature = this.formBakingBeanImmobilier.getNature();
         var1 = true;
      } else if (this.formBakingBeanPaye != null) {
         this.nature = this.formBakingBeanPaye.getNature();
         var1 = true;
      } else if (this.formBakingBeanEducation != null) {
         this.nature = this.formBakingBeanEducation.getNature();
         var1 = true;
      } else if (this.formBakingBeanFondation != null) {
         this.nature = this.formBakingBeanFondation.getNature();
         var1 = true;
      } else if (this.formBakingBeanForet != null) {
         this.nature = this.formBakingBeanForet.getNature();
         var1 = true;
      } else if (this.formBakingBeanTiers != null) {
         this.nature = 0;
         var1 = true;
      }

      if (var1) {
         Object var2 = new ArrayList();
         if (this.nature == 0) {
            var2 = this.formBakingBeanTiers.grapher();
            this.texteTitre = this.formBakingBeanTiers.getTitreGraph();
            this.texteSousTitre = this.formBakingBeanTiers.getSousTitreGraph();
            this.unite = "";
            this.nbDec = 0;
            this.devise = "";
            this.timeDecoupage = "5";
         } else if (this.nature != 5 && this.nature != 120 && this.nature != 121) {
            if (this.nature == 122) {
               var2 = this.formBakingBeanOffice.getFormSms().grapher();
               this.texteTitre = this.formBakingBeanOffice.getFormSms().getTitreGraph();
               this.texteSousTitre = this.formBakingBeanOffice.getFormSms().getSousTitreGraph();
               this.unite = this.formBakingBeanOffice.getFormSms().getUniteGraph();
               this.nbDec = this.formBakingBeanOffice.getFormSms().getNbDecGraph();
               this.devise = this.formBakingBeanOffice.getFormSms().getDeviseGraph();
               this.timeDecoupage = "" + this.formBakingBeanOffice.getFormSms().getTimeDecoupage();
            } else if (this.nature != 10) {
               if (this.nature == 11) {
                  var2 = this.formBakingBeanAchats.getFormCotationAchats().grapher();
                  this.texteTitre = this.formBakingBeanAchats.getFormCotationAchats().getTitreGraph();
                  this.texteSousTitre = this.formBakingBeanAchats.getFormCotationAchats().getSousTitreGraph();
                  this.unite = this.formBakingBeanAchats.getFormCotationAchats().getUniteGraph();
                  this.nbDec = this.formBakingBeanAchats.getFormCotationAchats().getNbDecGraph();
                  this.devise = this.formBakingBeanAchats.getFormCotationAchats().getDeviseGraph();
                  this.timeDecoupage = "" + this.formBakingBeanAchats.getFormCotationAchats().getTimeDecoupage();
               } else if (this.nature == 12) {
                  var2 = this.formBakingBeanAchats.getFormCommandeAchats().grapher();
                  this.texteTitre = this.formBakingBeanAchats.getFormCommandeAchats().getTitreGraph();
                  this.texteSousTitre = this.formBakingBeanAchats.getFormCommandeAchats().getSousTitreGraph();
                  this.unite = this.formBakingBeanAchats.getFormCommandeAchats().getUniteGraph();
                  this.nbDec = this.formBakingBeanAchats.getFormCommandeAchats().getNbDecGraph();
                  this.devise = this.formBakingBeanAchats.getFormCommandeAchats().getDeviseGraph();
                  this.timeDecoupage = "" + this.formBakingBeanAchats.getFormCommandeAchats().getTimeDecoupage();
               } else if (this.nature == 13) {
                  var2 = this.formBakingBeanAchats.getFormReceptionAchats().grapher();
                  this.texteTitre = this.formBakingBeanAchats.getFormReceptionAchats().getTitreGraph();
                  this.texteSousTitre = this.formBakingBeanAchats.getFormReceptionAchats().getSousTitreGraph();
                  this.unite = this.formBakingBeanAchats.getFormReceptionAchats().getUniteGraph();
                  this.nbDec = this.formBakingBeanAchats.getFormReceptionAchats().getNbDecGraph();
                  this.devise = this.formBakingBeanAchats.getFormReceptionAchats().getDeviseGraph();
                  this.timeDecoupage = "" + this.formBakingBeanAchats.getFormReceptionAchats().getTimeDecoupage();
               } else if (this.nature == 14) {
                  var2 = this.formBakingBeanAchats.getFormRetourAchats().grapher();
                  this.texteTitre = this.formBakingBeanAchats.getFormRetourAchats().getTitreGraph();
                  this.texteSousTitre = this.formBakingBeanAchats.getFormRetourAchats().getSousTitreGraph();
                  this.unite = this.formBakingBeanAchats.getFormRetourAchats().getUniteGraph();
                  this.nbDec = this.formBakingBeanAchats.getFormRetourAchats().getNbDecGraph();
                  this.devise = this.formBakingBeanAchats.getFormRetourAchats().getDeviseGraph();
                  this.timeDecoupage = "" + this.formBakingBeanAchats.getFormRetourAchats().getTimeDecoupage();
               } else if (this.nature == 15) {
                  var2 = this.formBakingBeanAchats.getFormFactureAchats().grapher();
                  this.texteTitre = this.formBakingBeanAchats.getFormFactureAchats().getTitreGraph();
                  this.texteSousTitre = this.formBakingBeanAchats.getFormFactureAchats().getSousTitreGraph();
                  this.unite = this.formBakingBeanAchats.getFormFactureAchats().getUniteGraph();
                  this.nbDec = this.formBakingBeanAchats.getFormFactureAchats().getNbDecGraph();
                  this.devise = this.formBakingBeanAchats.getFormFactureAchats().getDeviseGraph();
                  this.timeDecoupage = "" + this.formBakingBeanAchats.getFormFactureAchats().getTimeDecoupage();
               } else if (this.nature == 16) {
                  var2 = this.formBakingBeanAchats.getFormAvoirAchats().grapher();
                  this.texteTitre = this.formBakingBeanAchats.getFormAvoirAchats().getTitreGraph();
                  this.texteSousTitre = this.formBakingBeanAchats.getFormAvoirAchats().getSousTitreGraph();
                  this.unite = this.formBakingBeanAchats.getFormAvoirAchats().getUniteGraph();
                  this.nbDec = this.formBakingBeanAchats.getFormAvoirAchats().getNbDecGraph();
                  this.devise = this.formBakingBeanAchats.getFormAvoirAchats().getDeviseGraph();
                  this.timeDecoupage = "" + this.formBakingBeanAchats.getFormAvoirAchats().getTimeDecoupage();
               } else if (this.nature == 17) {
                  var2 = this.formBakingBeanAchats.getFormNoteDebitAchats().grapher();
                  this.texteTitre = this.formBakingBeanAchats.getFormNoteDebitAchats().getTitreGraph();
                  this.texteSousTitre = this.formBakingBeanAchats.getFormNoteDebitAchats().getSousTitreGraph();
                  this.unite = this.formBakingBeanAchats.getFormNoteDebitAchats().getUniteGraph();
                  this.nbDec = this.formBakingBeanAchats.getFormNoteDebitAchats().getNbDecGraph();
                  this.devise = this.formBakingBeanAchats.getFormNoteDebitAchats().getDeviseGraph();
                  this.timeDecoupage = "" + this.formBakingBeanAchats.getFormNoteDebitAchats().getTimeDecoupage();
               } else if (this.nature == 18) {
                  var2 = this.formBakingBeanAchats.getFormFraisAchats().grapher();
                  this.texteTitre = this.formBakingBeanAchats.getFormFraisAchats().getTitreGraph();
                  this.texteSousTitre = this.formBakingBeanAchats.getFormFraisAchats().getSousTitreGraph();
                  this.unite = this.formBakingBeanAchats.getFormFraisAchats().getUniteGraph();
                  this.nbDec = this.formBakingBeanAchats.getFormFraisAchats().getNbDecGraph();
                  this.devise = this.formBakingBeanAchats.getFormFraisAchats().getDeviseGraph();
                  this.timeDecoupage = "" + this.formBakingBeanAchats.getFormFraisAchats().getTimeDecoupage();
               } else if (this.nature != 20 && this.nature != 7 && this.nature != 8) {
                  if (this.nature == 21) {
                     var2 = this.formBakingBeanVentes.getFormDevisVentes().grapher();
                     this.texteTitre = this.formBakingBeanVentes.getFormDevisVentes().getTitreGraph();
                     this.texteSousTitre = this.formBakingBeanVentes.getFormDevisVentes().getSousTitreGraph();
                     this.unite = this.formBakingBeanVentes.getFormDevisVentes().getUniteGraph();
                     this.nbDec = this.formBakingBeanVentes.getFormDevisVentes().getNbDecGraph();
                     this.devise = this.formBakingBeanVentes.getFormDevisVentes().getDeviseGraph();
                     this.timeDecoupage = "" + this.formBakingBeanVentes.getFormDevisVentes().getTimeDecoupage();
                  } else if (this.nature == 22) {
                     var2 = this.formBakingBeanVentes.getFormCommandeVentes().grapher();
                     this.texteTitre = this.formBakingBeanVentes.getFormCommandeVentes().getTitreGraph();
                     this.texteSousTitre = this.formBakingBeanVentes.getFormCommandeVentes().getSousTitreGraph();
                     this.unite = this.formBakingBeanVentes.getFormCommandeVentes().getUniteGraph();
                     this.nbDec = this.formBakingBeanVentes.getFormCommandeVentes().getNbDecGraph();
                     this.devise = this.formBakingBeanVentes.getFormCommandeVentes().getDeviseGraph();
                     this.timeDecoupage = "" + this.formBakingBeanVentes.getFormCommandeVentes().getTimeDecoupage();
                  } else if (this.nature == 23) {
                     var2 = this.formBakingBeanVentes.getFormLivraisonVentes().grapher();
                     this.texteTitre = this.formBakingBeanVentes.getFormLivraisonVentes().getTitreGraph();
                     this.texteSousTitre = this.formBakingBeanVentes.getFormLivraisonVentes().getSousTitreGraph();
                     this.unite = this.formBakingBeanVentes.getFormLivraisonVentes().getUniteGraph();
                     this.nbDec = this.formBakingBeanVentes.getFormLivraisonVentes().getNbDecGraph();
                     this.devise = this.formBakingBeanVentes.getFormLivraisonVentes().getDeviseGraph();
                     this.timeDecoupage = "" + this.formBakingBeanVentes.getFormLivraisonVentes().getTimeDecoupage();
                  } else if (this.nature == 24) {
                     var2 = this.formBakingBeanVentes.getFormRetourVentes().grapher();
                     this.texteTitre = this.formBakingBeanVentes.getFormRetourVentes().getTitreGraph();
                     this.texteSousTitre = this.formBakingBeanVentes.getFormRetourVentes().getSousTitreGraph();
                     this.unite = this.formBakingBeanVentes.getFormRetourVentes().getUniteGraph();
                     this.nbDec = this.formBakingBeanVentes.getFormRetourVentes().getNbDecGraph();
                     this.devise = this.formBakingBeanVentes.getFormRetourVentes().getDeviseGraph();
                     this.timeDecoupage = "" + this.formBakingBeanVentes.getFormRetourVentes().getTimeDecoupage();
                  } else if (this.nature == 25) {
                     var2 = this.formBakingBeanVentes.getFormFactureVentes().grapher();
                     this.texteTitre = this.formBakingBeanVentes.getFormFactureVentes().getTitreGraph();
                     this.texteSousTitre = this.formBakingBeanVentes.getFormFactureVentes().getSousTitreGraph();
                     this.unite = this.formBakingBeanVentes.getFormFactureVentes().getUniteGraph();
                     this.nbDec = this.formBakingBeanVentes.getFormFactureVentes().getNbDecGraph();
                     this.devise = this.formBakingBeanVentes.getFormFactureVentes().getDeviseGraph();
                     this.timeDecoupage = "" + this.formBakingBeanVentes.getFormFactureVentes().getTimeDecoupage();
                  } else if (this.nature == 26) {
                     var2 = this.formBakingBeanVentes.getFormAvoirVentes().grapher();
                     this.texteTitre = this.formBakingBeanVentes.getFormAvoirVentes().getTitreGraph();
                     this.texteSousTitre = this.formBakingBeanVentes.getFormAvoirVentes().getSousTitreGraph();
                     this.unite = this.formBakingBeanVentes.getFormAvoirVentes().getUniteGraph();
                     this.nbDec = this.formBakingBeanVentes.getFormAvoirVentes().getNbDecGraph();
                     this.devise = this.formBakingBeanVentes.getFormAvoirVentes().getDeviseGraph();
                     this.timeDecoupage = "" + this.formBakingBeanVentes.getFormAvoirVentes().getTimeDecoupage();
                  } else if (this.nature == 27) {
                     var2 = this.formBakingBeanVentes.getFormNoteDebitVentes().grapher();
                     this.texteTitre = this.formBakingBeanVentes.getFormNoteDebitVentes().getTitreGraph();
                     this.texteSousTitre = this.formBakingBeanVentes.getFormNoteDebitVentes().getSousTitreGraph();
                     this.unite = this.formBakingBeanVentes.getFormNoteDebitVentes().getUniteGraph();
                     this.nbDec = this.formBakingBeanVentes.getFormNoteDebitVentes().getNbDecGraph();
                     this.devise = this.formBakingBeanVentes.getFormNoteDebitVentes().getDeviseGraph();
                     this.timeDecoupage = "" + this.formBakingBeanVentes.getFormNoteDebitVentes().getTimeDecoupage();
                  } else if (this.nature == 127 && this.formBakingBeanVentes != null) {
                     var2 = this.formBakingBeanVentes.getFormAffaires().grapher();
                     this.texteTitre = this.formBakingBeanVentes.getFormAffaires().getTitreGraph();
                     this.texteSousTitre = this.formBakingBeanVentes.getFormAffaires().getSousTitreGraph();
                     this.unite = this.formBakingBeanVentes.getFormAffaires().getUniteGraph();
                     this.nbDec = this.formBakingBeanVentes.getFormAffaires().getNbDecGraph();
                     this.devise = this.formBakingBeanVentes.getFormAffaires().getDeviseGraph();
                     this.timeDecoupage = "" + this.formBakingBeanVentes.getFormAffaires().getTimeDecoupage();
                  } else if (this.nature != 28) {
                     if (this.nature == 30) {
                        var2 = this.formBakingBeanAchats.getFormInventaire().grapher();
                        this.texteTitre = this.formBakingBeanAchats.getFormInventaire().getTitreGraph();
                        this.texteSousTitre = this.formBakingBeanAchats.getFormInventaire().getSousTitreGraph();
                        this.unite = this.formBakingBeanAchats.getFormInventaire().getUniteGraph();
                        this.nbDec = this.formBakingBeanAchats.getFormInventaire().getNbDecGraph();
                        this.devise = this.formBakingBeanAchats.getFormInventaire().getDeviseGraph();
                        this.timeDecoupage = "" + this.formBakingBeanAchats.getFormInventaire().getTimeDecoupage();
                     } else if (this.nature == 31) {
                        var2 = this.formBakingBeanAchats.getFormBonEntree().grapher();
                        this.texteTitre = this.formBakingBeanAchats.getFormBonEntree().getTitreGraph();
                        this.texteSousTitre = this.formBakingBeanAchats.getFormBonEntree().getSousTitreGraph();
                        this.unite = this.formBakingBeanAchats.getFormBonEntree().getUniteGraph();
                        this.nbDec = this.formBakingBeanAchats.getFormBonEntree().getNbDecGraph();
                        this.devise = this.formBakingBeanAchats.getFormBonEntree().getDeviseGraph();
                        this.timeDecoupage = "" + this.formBakingBeanAchats.getFormBonEntree().getTimeDecoupage();
                     } else if (this.nature == 32) {
                        var2 = this.formBakingBeanAchats.getFormBonSortie().grapher();
                        this.texteTitre = this.formBakingBeanAchats.getFormBonSortie().getTitreGraph();
                        this.texteSousTitre = this.formBakingBeanAchats.getFormBonSortie().getSousTitreGraph();
                        this.unite = this.formBakingBeanAchats.getFormBonSortie().getUniteGraph();
                        this.nbDec = this.formBakingBeanAchats.getFormBonSortie().getNbDecGraph();
                        this.devise = this.formBakingBeanAchats.getFormBonSortie().getDeviseGraph();
                        this.timeDecoupage = "" + this.formBakingBeanAchats.getFormBonSortie().getTimeDecoupage();
                     } else if (this.nature == 33) {
                        var2 = this.formBakingBeanAchats.getFormCession().grapher();
                        this.texteTitre = this.formBakingBeanAchats.getFormCession().getTitreGraph();
                        this.texteSousTitre = this.formBakingBeanAchats.getFormCession().getSousTitreGraph();
                        this.unite = this.formBakingBeanAchats.getFormCession().getUniteGraph();
                        this.nbDec = this.formBakingBeanAchats.getFormCession().getNbDecGraph();
                        this.devise = this.formBakingBeanAchats.getFormCession().getDeviseGraph();
                        this.timeDecoupage = "" + this.formBakingBeanAchats.getFormCession().getTimeDecoupage();
                     } else if (this.nature == 34) {
                        var2 = this.formBakingBeanAchats.getFormProduction().grapher();
                        this.texteTitre = this.formBakingBeanAchats.getFormProduction().getTitreGraph();
                        this.texteSousTitre = this.formBakingBeanAchats.getFormProduction().getSousTitreGraph();
                        this.unite = this.formBakingBeanAchats.getFormProduction().getUniteGraph();
                        this.nbDec = this.formBakingBeanAchats.getFormProduction().getNbDecGraph();
                        this.devise = this.formBakingBeanAchats.getFormProduction().getDeviseGraph();
                        this.timeDecoupage = "" + this.formBakingBeanAchats.getFormProduction().getTimeDecoupage();
                     } else if (this.nature != 35 && this.nature != 36 && this.nature != 37) {
                        if (this.nature == 500) {
                           var2 = this.formBakingBeanAchats.getFormProduitsAchs().grapher();
                           this.texteTitre = this.formBakingBeanAchats.getFormProduitsAchs().getTitreGraph();
                           this.texteSousTitre = this.formBakingBeanAchats.getFormProduitsAchs().getSousTitreGraph();
                           this.unite = this.formBakingBeanAchats.getFormProduitsAchs().getUniteGraph();
                           this.nbDec = this.formBakingBeanAchats.getFormProduitsAchs().getNbDecGraph();
                           this.devise = this.formBakingBeanAchats.getFormProduitsAchs().getDeviseGraph();
                           this.timeDecoupage = "" + this.formBakingBeanAchats.getFormProduitsAchs().getTimeDecoupage();
                        } else if (this.nature == 600) {
                           var2 = this.formBakingBeanVentes.getFormProduitsVtes().grapher();
                           this.texteTitre = this.formBakingBeanVentes.getFormProduitsVtes().getTitreGraph();
                           this.texteSousTitre = this.formBakingBeanVentes.getFormProduitsVtes().getSousTitreGraph();
                           this.unite = this.formBakingBeanVentes.getFormProduitsVtes().getUniteGraph();
                           this.nbDec = this.formBakingBeanVentes.getFormProduitsVtes().getNbDecGraph();
                           this.devise = this.formBakingBeanVentes.getFormProduitsVtes().getDeviseGraph();
                           this.timeDecoupage = "" + this.formBakingBeanVentes.getFormProduitsVtes().getTimeDecoupage();
                        } else if (this.nature != 700) {
                           if (this.nature == 51) {
                              var2 = this.formBakingBeanComptabilite.getFormAmortissements().grapher();
                              this.texteTitre = this.formBakingBeanComptabilite.getFormAmortissements().getTitreGraph();
                              this.texteSousTitre = this.formBakingBeanComptabilite.getFormAmortissements().getSousTitreGraph();
                              this.unite = this.formBakingBeanComptabilite.getFormAmortissements().getUniteGraph();
                              this.nbDec = this.formBakingBeanComptabilite.getFormAmortissements().getNbDecGraph();
                              this.devise = this.formBakingBeanComptabilite.getFormAmortissements().getDeviseGraph();
                              this.timeDecoupage = "" + this.formBakingBeanComptabilite.getFormAmortissements().getTimeDecoupage();
                           } else if (this.nature != 53 && this.nature != 534) {
                              if (this.nature == 538) {
                                 var2 = this.formBakingBeanComptabilite.getFormExtraitClasse().grapher();
                                 this.texteTitre = this.formBakingBeanComptabilite.getFormExtraitClasse().getTitreGraph();
                                 this.texteSousTitre = this.formBakingBeanComptabilite.getFormExtraitClasse().getSousTitreGraph();
                                 this.unite = this.formBakingBeanComptabilite.getFormExtraitClasse().getUniteGraph();
                                 this.nbDec = this.formBakingBeanComptabilite.getFormExtraitClasse().getNbDecGraph();
                                 this.devise = this.formBakingBeanComptabilite.getFormExtraitClasse().getDeviseGraph();
                                 this.timeDecoupage = "" + this.formBakingBeanComptabilite.getFormExtraitClasse().getTimeDecoupage();
                              } else if (this.nature == 535) {
                                 var2 = this.formBakingBeanComptabilite.getFormExtraitAnalList().grapher();
                                 this.texteTitre = this.formBakingBeanComptabilite.getFormExtraitAnalList().getTitreGraph();
                                 this.texteSousTitre = this.formBakingBeanComptabilite.getFormExtraitAnalList().getSousTitreGraph();
                                 this.unite = this.formBakingBeanComptabilite.getFormExtraitAnalList().getUniteGraph();
                                 this.nbDec = this.formBakingBeanComptabilite.getFormExtraitAnalList().getNbDecGraph();
                                 this.devise = this.formBakingBeanComptabilite.getFormExtraitAnalList().getDeviseGraph();
                                 this.timeDecoupage = "" + this.formBakingBeanComptabilite.getFormExtraitAnalList().getTimeDecoupage();
                              } else if (this.nature == 71) {
                                 var2 = this.formBakingBeanMedical.getFormConsultationGene().grapher();
                                 this.texteTitre = this.formBakingBeanMedical.getFormConsultationGene().getTitreGraph();
                                 this.texteSousTitre = this.formBakingBeanMedical.getFormConsultationGene().getSousTitreGraph();
                                 this.unite = this.formBakingBeanMedical.getFormConsultationGene().getUniteGraph();
                                 this.nbDec = this.formBakingBeanMedical.getFormConsultationGene().getNbDecGraph();
                                 this.devise = this.formBakingBeanMedical.getFormConsultationGene().getDeviseGraph();
                                 this.timeDecoupage = "" + this.formBakingBeanMedical.getFormConsultationGene().getTimeDecoupage();
                              } else if (this.nature != 72) {
                                 if (this.nature == 73) {
                                    var2 = this.formBakingBeanMedical.getFormPharmacie().grapher();
                                    this.texteTitre = this.formBakingBeanMedical.getFormPharmacie().getTitreGraph();
                                    this.texteSousTitre = this.formBakingBeanMedical.getFormPharmacie().getSousTitreGraph();
                                    this.unite = this.formBakingBeanMedical.getFormPharmacie().getUniteGraph();
                                    this.nbDec = this.formBakingBeanMedical.getFormPharmacie().getNbDecGraph();
                                    this.devise = this.formBakingBeanMedical.getFormPharmacie().getDeviseGraph();
                                    this.timeDecoupage = "" + this.formBakingBeanMedical.getFormPharmacie().getTimeDecoupage();
                                 } else if (this.nature == 74) {
                                    var2 = this.formBakingBeanMedical.getFormLaboratoire().grapher();
                                    this.texteTitre = this.formBakingBeanMedical.getFormLaboratoire().getTitreGraph();
                                    this.texteSousTitre = this.formBakingBeanMedical.getFormLaboratoire().getSousTitreGraph();
                                    this.unite = this.formBakingBeanMedical.getFormLaboratoire().getUniteGraph();
                                    this.nbDec = this.formBakingBeanMedical.getFormLaboratoire().getNbDecGraph();
                                    this.devise = this.formBakingBeanMedical.getFormLaboratoire().getDeviseGraph();
                                    this.timeDecoupage = "" + this.formBakingBeanMedical.getFormLaboratoire().getTimeDecoupage();
                                 } else if (this.nature == 75) {
                                    var2 = this.formBakingBeanMedical.getFormLaboratoire().grapher();
                                    this.texteTitre = this.formBakingBeanMedical.getFormLaboratoire().getTitreGraph();
                                    this.texteSousTitre = this.formBakingBeanMedical.getFormLaboratoire().getSousTitreGraph();
                                    this.unite = this.formBakingBeanMedical.getFormLaboratoire().getUniteGraph();
                                    this.nbDec = this.formBakingBeanMedical.getFormLaboratoire().getNbDecGraph();
                                    this.devise = this.formBakingBeanMedical.getFormLaboratoire().getDeviseGraph();
                                    this.timeDecoupage = "" + this.formBakingBeanMedical.getFormLaboratoire().getTimeDecoupage();
                                 } else if (this.nature == 76) {
                                    var2 = this.formBakingBeanMedical.getFormHospitalisation().grapher();
                                    this.texteTitre = this.formBakingBeanMedical.getFormHospitalisation().getTitreGraph();
                                    this.texteSousTitre = this.formBakingBeanMedical.getFormHospitalisation().getSousTitreGraph();
                                    this.unite = this.formBakingBeanMedical.getFormHospitalisation().getUniteGraph();
                                    this.nbDec = this.formBakingBeanMedical.getFormHospitalisation().getNbDecGraph();
                                    this.devise = this.formBakingBeanMedical.getFormHospitalisation().getDeviseGraph();
                                    this.timeDecoupage = "" + this.formBakingBeanMedical.getFormHospitalisation().getTimeDecoupage();
                                 } else if (this.nature != 77 && this.nature != 78 && this.nature != 103 && this.nature != 104) {
                                    if (this.nature == 165) {
                                       var2 = this.formBakingBeanImmobilier.getFormFactureImmobilier().grapher();
                                       this.texteTitre = this.formBakingBeanImmobilier.getFormFactureImmobilier().getTitreGraph();
                                       this.texteSousTitre = this.formBakingBeanImmobilier.getFormFactureImmobilier().getSousTitreGraph();
                                       this.unite = this.formBakingBeanImmobilier.getFormFactureImmobilier().getUniteGraph();
                                       this.nbDec = this.formBakingBeanImmobilier.getFormFactureImmobilier().getNbDecGraph();
                                       this.devise = this.formBakingBeanImmobilier.getFormFactureImmobilier().getDeviseGraph();
                                       this.timeDecoupage = "" + this.formBakingBeanImmobilier.getFormFactureImmobilier().getTimeDecoupage();
                                    } else if (this.nature == 81) {
                                       var2 = this.formBakingBeanPaye.getFormFicheSalarie().grapher();
                                       this.texteTitre = this.formBakingBeanPaye.getFormFicheSalarie().getTitreGraph();
                                       this.texteSousTitre = this.formBakingBeanPaye.getFormFicheSalarie().getSousTitreGraph();
                                       this.unite = this.formBakingBeanPaye.getFormFicheSalarie().getUniteGraph();
                                       this.nbDec = this.formBakingBeanPaye.getFormFicheSalarie().getNbDecGraph();
                                       this.devise = this.formBakingBeanPaye.getFormFicheSalarie().getDeviseGraph();
                                       this.timeDecoupage = "" + this.formBakingBeanPaye.getFormFicheSalarie().getTimeDecoupage();
                                    } else if (this.nature == 94) {
                                       var2 = this.formBakingBeanPaye.getFormPointage().grapher();
                                       this.texteTitre = this.formBakingBeanPaye.getFormPointage().getTitreGraph();
                                       this.texteSousTitre = this.formBakingBeanPaye.getFormPointage().getSousTitreGraph();
                                       this.unite = this.formBakingBeanPaye.getFormPointage().getUniteGraph();
                                       this.nbDec = this.formBakingBeanPaye.getFormPointage().getNbDecGraph();
                                       this.devise = this.formBakingBeanPaye.getFormPointage().getDeviseGraph();
                                       this.timeDecoupage = "" + this.formBakingBeanPaye.getFormPointage().getTimeDecoupage();
                                    } else if (this.nature == 181) {
                                       var2 = this.formBakingBeanMedical.getFormNoteDebitMedical().grapher();
                                       this.texteTitre = this.formBakingBeanMedical.getFormNoteDebitMedical().getTitreGraph();
                                       this.texteSousTitre = this.formBakingBeanMedical.getFormNoteDebitMedical().getSousTitreGraph();
                                       this.unite = this.formBakingBeanMedical.getFormNoteDebitMedical().getUniteGraph();
                                       this.nbDec = this.formBakingBeanMedical.getFormNoteDebitMedical().getNbDecGraph();
                                       this.devise = this.formBakingBeanMedical.getFormNoteDebitMedical().getDeviseGraph();
                                       this.timeDecoupage = "" + this.formBakingBeanMedical.getFormNoteDebitMedical().getTimeDecoupage();
                                    } else if (this.nature == 250) {
                                       var2 = this.formBakingBeanForet.getFormForetInventaire().grapher();
                                       this.texteTitre = this.formBakingBeanForet.getFormForetInventaire().getTitreGraph();
                                       this.texteSousTitre = this.formBakingBeanForet.getFormForetInventaire().getSousTitreGraph();
                                       this.unite = this.formBakingBeanForet.getFormForetInventaire().getUniteGraph();
                                       this.nbDec = this.formBakingBeanForet.getFormForetInventaire().getNbDecGraph();
                                       this.devise = this.formBakingBeanForet.getFormForetInventaire().getDeviseGraph();
                                       this.timeDecoupage = "" + this.formBakingBeanForet.getFormForetInventaire().getTimeDecoupage();
                                    }
                                 }
                              }
                           } else if (this.formBakingBeanComptabilite.getFormJournauxComptables() != null) {
                              var2 = this.formBakingBeanComptabilite.getFormJournauxComptables().getFormExtraitCompte().grapher();
                              this.texteTitre = this.formBakingBeanComptabilite.getFormJournauxComptables().getFormExtraitCompte().getTitreGraph();
                              this.texteSousTitre = this.formBakingBeanComptabilite.getFormJournauxComptables().getFormExtraitCompte().getSousTitreGraph();
                              this.unite = this.formBakingBeanComptabilite.getFormJournauxComptables().getFormExtraitCompte().getUniteGraph();
                              this.nbDec = this.formBakingBeanComptabilite.getFormJournauxComptables().getFormExtraitCompte().getNbDecGraph();
                              this.devise = this.formBakingBeanComptabilite.getFormJournauxComptables().getFormExtraitCompte().getDeviseGraph();
                              this.timeDecoupage = "" + this.formBakingBeanComptabilite.getFormJournauxComptables().getFormExtraitCompte().getTimeDecoupage();
                           } else {
                              var2 = this.formBakingBeanComptabilite.getFormExtraitCompte().grapher();
                              this.texteTitre = this.formBakingBeanComptabilite.getFormExtraitCompte().getTitreGraph();
                              this.texteSousTitre = this.formBakingBeanComptabilite.getFormExtraitCompte().getSousTitreGraph();
                              this.unite = this.formBakingBeanComptabilite.getFormExtraitCompte().getUniteGraph();
                              this.nbDec = this.formBakingBeanComptabilite.getFormExtraitCompte().getNbDecGraph();
                              this.devise = this.formBakingBeanComptabilite.getFormExtraitCompte().getDeviseGraph();
                              this.timeDecoupage = "" + this.formBakingBeanComptabilite.getFormExtraitCompte().getTimeDecoupage();
                           }
                        }
                     }
                  }
               }
            }
         }

         new ObjetGraph();
         this.listeDatas = null;
         ObjetGraph var3;
         String var4;
         int var5;
         if (((List)var2).size() != 0) {
            var4 = "";
            var5 = 0;

            while(true) {
               if (var5 >= ((List)var2).size()) {
                  this.listeDatas = "[" + var4 + "]";
                  break;
               }

               var3 = (ObjetGraph)((List)var2).get(var5);
               if (var3.getNomSerie() == null || var3.getNomSerie().isEmpty()) {
                  var3.setNomSerie("???");
               }

               if (var4.isEmpty()) {
                  var4 = "{name: '" + var3.getNomSerie() + "' ,";
               } else {
                  var4 = var4 + "," + "{name: '" + var3.getNomSerie() + "' ,";
               }

               if (this.timeDecoupage.equals("0")) {
                  var4 = var4 + "data: [" + var3.getV01() + "," + var3.getV02() + "," + var3.getV03() + "," + var3.getV04() + "," + var3.getV05() + "," + var3.getV06() + "," + var3.getV07() + "," + var3.getV08() + "," + var3.getV09() + "," + var3.getV10() + "," + var3.getV11() + "," + var3.getV12() + "," + var3.getV13() + "," + var3.getV14() + "," + var3.getV15() + "," + var3.getV16() + "," + var3.getV17() + "," + var3.getV18() + "," + var3.getV19() + "," + var3.getV20() + "," + var3.getV21() + "," + var3.getV22() + "," + var3.getV23() + "," + var3.getV24() + "," + var3.getV25() + "," + var3.getV26() + "," + var3.getV27() + "," + var3.getV28() + "," + var3.getV29() + "," + var3.getV30() + "," + var3.getV31() + "]}";
               } else if (this.timeDecoupage.equals("1")) {
                  var4 = var4 + "data: [" + var3.getV01() + "," + var3.getV02() + "," + var3.getV03() + "," + var3.getV04() + "," + var3.getV05() + "," + var3.getV06() + "," + var3.getV07() + "," + var3.getV08() + "," + var3.getV09() + "," + var3.getV10() + "," + var3.getV11() + "," + var3.getV12() + "]}";
               } else if (this.timeDecoupage.equals("2")) {
                  var4 = var4 + "data: [" + var3.getV01() + "," + var3.getV02() + "," + var3.getV03() + "," + var3.getV04() + "]}";
               } else if (this.timeDecoupage.equals("3")) {
                  var4 = var4 + "data: [" + var3.getV01() + "," + var3.getV02() + "]}";
               } else if (this.timeDecoupage.equals("4")) {
                  var4 = var4 + "data: [" + var3.getV01() + "]}";
               } else if (this.timeDecoupage.equals("5")) {
                  var4 = var4 + "data: [" + var3.getV01() + "," + var3.getV02() + "," + var3.getV03() + "," + var3.getV04() + "," + var3.getV05() + "," + var3.getV06() + "," + var3.getV07() + "," + var3.getV08() + "," + var3.getV09() + "," + var3.getV10() + "," + var3.getV11() + "," + var3.getV12() + "," + var3.getV13() + "," + var3.getV14() + "," + var3.getV15() + "," + var3.getV16() + "," + var3.getV17() + "," + var3.getV18() + "," + var3.getV19() + "," + var3.getV20() + "," + var3.getV21() + "," + var3.getV22() + "," + var3.getV23() + "," + var3.getV24() + "]}";
               }

               ++var5;
            }
         }

         this.listeDatasCamembert = null;
         if (((List)var2).size() != 0) {
            var4 = "";

            for(var5 = 0; var5 < ((List)var2).size(); ++var5) {
               var3 = (ObjetGraph)((List)var2).get(var5);
               if (var3.getNomSerie() == null || var3.getNomSerie().isEmpty()) {
                  var3.setNomSerie("???");
               }

               if (var4.isEmpty()) {
                  var4 = "{name: '" + var3.getNomSerie() + "' ,";
                  var4 = var4 + "y: " + var3.getVpourcent() + "}";
               } else {
                  var4 = var4 + ", {name: '" + var3.getNomSerie() + "' ,";
                  var4 = var4 + "y: " + var3.getVpourcent() + "}";
               }
            }

            this.listeDatasCamembert = "[" + var4 + "]";
         }
      }

   }

   public boolean getLocalApplication() {
      return StaticModePegase.isLocalApplication();
   }

   public int getInternetActif() {
      return StaticModePegase.getInternet_actif();
   }

   public String getUrlIpProd() {
      return StaticModePegase.getUrlIp();
   }

   public String getIpServeur() {
      return StaticModePegase.getIpServeur();
   }

   public String getVersionLocale() {
      return StaticModePegase.getCompil_version();
   }

   public String getDateVersionLocale() {
      return StaticModePegase.getCompil_date();
   }

   public String getVersionDistante() {
      return StaticModePegase.getVersion_distante();
   }

   public String getDateVersionDistante() {
      return StaticModePegase.getDate_distante();
   }

   public Date getDetadujour() {
      return this.detadujour;
   }

   public void setDetadujour(Date var1) {
      this.detadujour = var1;
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

   public String getModuleAffiche() {
      return this.moduleAffiche;
   }

   public void setModuleAffiche(String var1) {
      this.moduleAffiche = var1;
   }

   public DataModel getDataModelMenuHorizontal() {
      return this.dataModelMenuHorizontal;
   }

   public void setDataModelMenuHorizontal(DataModel var1) {
      this.dataModelMenuHorizontal = var1;
   }

   public boolean isVar_aff_maj() {
      return this.var_aff_maj;
   }

   public void setVar_aff_maj(boolean var1) {
      this.var_aff_maj = var1;
   }

   public List getMesHeuresGlobalItems() {
      return this.mesHeuresGlobalItems;
   }

   public void setMesHeuresGlobalItems(List var1) {
      this.mesHeuresGlobalItems = var1;
   }

   public List getMesMinutesGlobalItems() {
      return this.mesMinutesGlobalItems;
   }

   public void setMesMinutesGlobalItems(List var1) {
      this.mesMinutesGlobalItems = var1;
   }

   public String getVar_lib_base() {
      return this.var_lib_base;
   }

   public void setVar_lib_base(String var1) {
      this.var_lib_base = var1;
   }

   public boolean isVar_affiche_liste_societe() {
      return this.var_affiche_liste_societe;
   }

   public void setVar_affiche_liste_societe(boolean var1) {
      this.var_affiche_liste_societe = var1;
   }

   public boolean isShowModalPanelSelectionSociete() {
      return this.showModalPanelSelectionSociete;
   }

   public void setShowModalPanelSelectionSociete(boolean var1) {
      this.showModalPanelSelectionSociete = var1;
   }

   public DataModel getDataModelSociete() {
      return this.dataModelSociete;
   }

   public void setDataModelSociete(DataModel var1) {
      this.dataModelSociete = var1;
   }

   public String getVar_nom_master() {
      return this.var_nom_master;
   }

   public void setVar_nom_master(String var1) {
      this.var_nom_master = var1;
   }

   public long getVar_id_master() {
      return this.var_id_master;
   }

   public void setVar_id_master(long var1) {
      this.var_id_master = var1;
   }

   public boolean isVar_aff_copie() {
      return this.var_aff_copie;
   }

   public void setVar_aff_copie(boolean var1) {
      this.var_aff_copie = var1;
   }

   public String getBaseLog() {
      return this.baseLog;
   }

   public void setBaseLog(String var1) {
      this.baseLog = var1;
   }

   public List getListeSocieteCabinet() {
      return this.listeSocieteCabinet;
   }

   public void setListeSocieteCabinet(List var1) {
      this.listeSocieteCabinet = var1;
   }

   public long getVar_memo_id_master() {
      return this.var_memo_id_master;
   }

   public void setVar_memo_id_master(long var1) {
      this.var_memo_id_master = var1;
   }

   public String getVar_memo_nom_master() {
      return this.var_memo_nom_master;
   }

   public void setVar_memo_nom_master(String var1) {
      this.var_memo_nom_master = var1;
   }

   public long getVar_memo_id_user() {
      return this.var_memo_id_user;
   }

   public void setVar_memo_id_user(long var1) {
      this.var_memo_id_user = var1;
   }

   public int getVar_societe_cabinet() {
      return this.var_societe_cabinet;
   }

   public void setVar_societe_cabinet(int var1) {
      this.var_societe_cabinet = var1;
   }

   public UtilInitHibernate getInitHibernateSessionFactory_2() {
      return this.utilInitHibernate;
   }

   public void setutilInitHibernate(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
   }

   public boolean isControlePanLeft() {
      return this.controlePanLeft;
   }

   public void setControlePanLeft(boolean var1) {
      this.controlePanLeft = var1;
   }

   public String getAffichePage() {
      return this.affichePage;
   }

   public void setAffichePage(String var1) {
      this.affichePage = var1;
   }

   public List getMesCollaborateurItems() {
      return this.mesCollaborateurItems;
   }

   public void setMesCollaborateurItems(List var1) {
      this.mesCollaborateurItems = var1;
   }

   public List getMesTachesItems() {
      return this.mesTachesItems;
   }

   public void setMesTachesItems(List var1) {
      this.mesTachesItems = var1;
   }

   public MenudroitFreeCtrl getMenudroitFreeCtrl() {
      return this.menudroitFreeCtrl;
   }

   public void setMenudroitFreeCtrl(MenudroitFreeCtrl var1) {
      this.menudroitFreeCtrl = var1;
   }

   public String getModuleFree() {
      return this.moduleFree;
   }

   public void setModuleFree(String var1) {
      this.moduleFree = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
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

   public UtilPrint getUtilPrint() {
      return this.utilPrint;
   }

   public void setUtilPrint(UtilPrint var1) {
      this.utilPrint = var1;
   }

   public boolean isAffListeDoc() {
      return this.affListeDoc;
   }

   public void setAffListeDoc(boolean var1) {
      this.affListeDoc = var1;
   }

   public List getDocumentImpressionItems() {
      return this.documentImpressionItems;
   }

   public void setDocumentImpressionItems(List var1) {
      this.documentImpressionItems = var1;
   }

   public List getListeImpressionItems() {
      return this.listeImpressionItems;
   }

   public void setListeImpressionItems(List var1) {
      this.listeImpressionItems = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
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

   public String getUrlDocument() {
      return this.urlDocument;
   }

   public void setUrlDocument(String var1) {
      this.urlDocument = var1;
   }

   public boolean isMessage_affiche() {
      this.message_affiche = StaticModePegase.isAffiche_message();
      return this.message_affiche;
   }

   public void setMessage_affiche(boolean var1) {
      this.message_affiche = var1;
   }

   public String getMessage_texte() {
      this.message_texte = StaticModePegase.getTexte_message();
      return this.message_texte;
   }

   public void setMessage_texte(String var1) {
      this.message_texte = var1;
   }

   public boolean isStrSelec() {
      return this.strSelec;
   }

   public void setStrSelec(boolean var1) {
      this.strSelec = var1;
   }

   public boolean isVar_invisible() {
      return this.var_invisible;
   }

   public void setVar_invisible(boolean var1) {
      this.var_invisible = var1;
   }

   public int getVar_currentValue() {
      return this.var_currentValue;
   }

   public void setVar_currentValue(int var1) {
      this.var_currentValue = var1;
   }

   public boolean isVar_showBarProgMaj() {
      return this.var_showBarProgMaj;
   }

   public void setVar_showBarProgMaj(boolean var1) {
      this.var_showBarProgMaj = var1;
   }

   public String getTexteSousTitre() {
      return this.texteSousTitre;
   }

   public void setTexteSousTitre(String var1) {
      this.texteSousTitre = var1;
   }

   public String getTexteTitre() {
      return this.texteTitre;
   }

   public void setTexteTitre(String var1) {
      this.texteTitre = var1;
   }

   public String getUnite() {
      return this.unite;
   }

   public void setUnite(String var1) {
      this.unite = var1;
   }

   public String getDevise() {
      return this.devise;
   }

   public void setDevise(String var1) {
      this.devise = var1;
   }

   public int getNbDec() {
      return this.nbDec;
   }

   public void setNbDec(int var1) {
      this.nbDec = var1;
   }

   public List getLesSeries() {
      return this.lesSeries;
   }

   public void setLesSeries(List var1) {
      this.lesSeries = var1;
   }

   public boolean isRw() {
      return this.rw;
   }

   public void setRw(boolean var1) {
      this.rw = var1;
   }

   public String getListeDatas() {
      return this.listeDatas;
   }

   public void setListeDatas(String var1) {
      this.listeDatas = var1;
   }

   public String getTimeDecoupage() {
      return this.timeDecoupage;
   }

   public void setTimeDecoupage(String var1) {
      this.timeDecoupage = var1;
   }

   public List getLesDevisesItems() {
      return this.lesDevisesItems;
   }

   public void setLesDevisesItems(List var1) {
      this.lesDevisesItems = var1;
   }

   public float getTauxDevise() {
      return this.tauxDevise;
   }

   public void setTauxDevise(float var1) {
      this.tauxDevise = var1;
   }

   public String getVar_type_os_serveur_local() {
      return this.var_type_os_serveur_local;
   }

   public void setVar_type_os_serveur_local(String var1) {
      this.var_type_os_serveur_local = var1;
   }

   public String getChoixServeur() {
      return this.choixServeur;
   }

   public void setChoixServeur(String var1) {
      this.choixServeur = var1;
   }

   public boolean isStartupSpecial() {
      return this.startupSpecial;
   }

   public void setStartupSpecial(boolean var1) {
      this.startupSpecial = var1;
   }

   public List getLesBasesCopies() {
      return this.lesBasesCopies;
   }

   public void setLesBasesCopies(List var1) {
      this.lesBasesCopies = var1;
   }

   public String getBasesCopies() {
      return this.basesCopies;
   }

   public void setBasesCopies(String var1) {
      this.basesCopies = var1;
   }

   public boolean isBaseVerrou() {
      return this.baseVerrou;
   }

   public void setBaseVerrou(boolean var1) {
      this.baseVerrou = var1;
   }

   public FormBackupDatas getFormBackupDatas() {
      return this.formBackupDatas;
   }

   public void setFormBackupDatas(FormBackupDatas var1) {
      this.formBackupDatas = var1;
   }

   public FormBakingBeanAccueil getFormBakingBeanAccueil() {
      return this.formBakingBeanAccueil;
   }

   public void setFormBakingBeanAccueil(FormBakingBeanAccueil var1) {
      this.formBakingBeanAccueil = var1;
   }

   public FormBakingBeanAchats getFormBakingBeanAchats() {
      return this.formBakingBeanAchats;
   }

   public void setFormBakingBeanAchats(FormBakingBeanAchats var1) {
      this.formBakingBeanAchats = var1;
   }

   public FormBakingBeanAdministration getFormBakingBeanAdministration() {
      return this.formBakingBeanAdministration;
   }

   public void setFormBakingBeanAdministration(FormBakingBeanAdministration var1) {
      this.formBakingBeanAdministration = var1;
   }

   public FormBakingBeanCaisse getFormBakingBeanCaisse() {
      return this.formBakingBeanCaisse;
   }

   public void setFormBakingBeanCaisse(FormBakingBeanCaisse var1) {
      this.formBakingBeanCaisse = var1;
   }

   public FormBakingBeanComptabilite getFormBakingBeanComptabilite() {
      return this.formBakingBeanComptabilite;
   }

   public void setFormBakingBeanComptabilite(FormBakingBeanComptabilite var1) {
      this.formBakingBeanComptabilite = var1;
   }

   public FormBakingBeanEducation getFormBakingBeanEducation() {
      return this.formBakingBeanEducation;
   }

   public void setFormBakingBeanEducation(FormBakingBeanEducation var1) {
      this.formBakingBeanEducation = var1;
   }

   public FormBakingBeanImmobilier getFormBakingBeanImmobilier() {
      return this.formBakingBeanImmobilier;
   }

   public void setFormBakingBeanImmobilier(FormBakingBeanImmobilier var1) {
      this.formBakingBeanImmobilier = var1;
   }

   public FormBakingBeanMedical getFormBakingBeanMedical() {
      return this.formBakingBeanMedical;
   }

   public void setFormBakingBeanMedical(FormBakingBeanMedical var1) {
      this.formBakingBeanMedical = var1;
   }

   public FormBakingBeanMicroFinance getFormBakingBeanMicroFinance() {
      return this.formBakingBeanMicroFinance;
   }

   public void setFormBakingBeanMicroFinance(FormBakingBeanMicroFinance var1) {
      this.formBakingBeanMicroFinance = var1;
   }

   public FormBakingBeanOffice getFormBakingBeanOffice() {
      return this.formBakingBeanOffice;
   }

   public void setFormBakingBeanOffice(FormBakingBeanOffice var1) {
      this.formBakingBeanOffice = var1;
   }

   public FormBakingBeanParcs getFormBakingBeanParcs() {
      return this.formBakingBeanParcs;
   }

   public void setFormBakingBeanParcs(FormBakingBeanParcs var1) {
      this.formBakingBeanParcs = var1;
   }

   public FormBakingBeanPartiPolitique getFormBakingBeanPartiPolitique() {
      return this.formBakingBeanPartiPolitique;
   }

   public void setFormBakingBeanPartiPolitique(FormBakingBeanPartiPolitique var1) {
      this.formBakingBeanPartiPolitique = var1;
   }

   public FormBakingBeanPaye getFormBakingBeanPaye() {
      return this.formBakingBeanPaye;
   }

   public void setFormBakingBeanPaye(FormBakingBeanPaye var1) {
      this.formBakingBeanPaye = var1;
   }

   public FormBakingBeanSysteme getFormBakingBeanSysteme() {
      return this.formBakingBeanSysteme;
   }

   public void setFormBakingBeanSysteme(FormBakingBeanSysteme var1) {
      this.formBakingBeanSysteme = var1;
   }

   public FormBakingBeanTemple getFormBakingBeanTemple() {
      return this.formBakingBeanTemple;
   }

   public void setFormBakingBeanTemple(FormBakingBeanTemple var1) {
      this.formBakingBeanTemple = var1;
   }

   public FormBakingBeanTiers getFormBakingBeanTiers() {
      return this.formBakingBeanTiers;
   }

   public void setFormBakingBeanTiers(FormBakingBeanTiers var1) {
      this.formBakingBeanTiers = var1;
   }

   public FormBakingBeanVentes getFormBakingBeanVentes() {
      return this.formBakingBeanVentes;
   }

   public void setFormBakingBeanVentes(FormBakingBeanVentes var1) {
      this.formBakingBeanVentes = var1;
   }

   public FormDocumentsOfficiels getFormDocumentsOfficiels() {
      return this.formDocumentsOfficiels;
   }

   public void setFormDocumentsOfficiels(FormDocumentsOfficiels var1) {
      this.formDocumentsOfficiels = var1;
   }

   public FormEspaceClient getFormEspaceClient() {
      return this.formEspaceClient;
   }

   public void setFormEspaceClient(FormEspaceClient var1) {
      this.formEspaceClient = var1;
   }

   public boolean isShowMoalPanelExit() {
      return this.showMoalPanelExit;
   }

   public void setShowMoalPanelExit(boolean var1) {
      this.showMoalPanelExit = var1;
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

   public String getDetajour() {
      return this.detajour;
   }

   public void setDetajour(String var1) {
      this.detajour = var1;
   }

   public String getMessage_vocal() throws IOException, JDOMException {
      return this.message_vocal;
   }

   public void setMessage_vocal(String var1) {
      this.message_vocal = var1;
   }

   public String getListeDatasCamembert() {
      return this.listeDatasCamembert;
   }

   public void setListeDatasCamembert(String var1) {
      this.listeDatasCamembert = var1;
   }

   public FormBakingBeanForet getFormBakingBeanForet() {
      return this.formBakingBeanForet;
   }

   public void setFormBakingBeanForet(FormBakingBeanForet var1) {
      this.formBakingBeanForet = var1;
   }

   public boolean isAffiche_nom() {
      return this.affiche_nom;
   }

   public void setAffiche_nom(boolean var1) {
      this.affiche_nom = var1;
   }

   public FormBakingBeanFondation getFormBakingBeanFondation() {
      return this.formBakingBeanFondation;
   }

   public void setFormBakingBeanFondation(FormBakingBeanFondation var1) {
      this.formBakingBeanFondation = var1;
   }

   public int getVar_choix_poids() {
      return this.var_choix_poids;
   }

   public void setVar_choix_poids(int var1) {
      this.var_choix_poids = var1;
   }

   public FormBakingBeanReporting getFormBakingBeanReporting() {
      return this.formBakingBeanReporting;
   }

   public void setFormBakingBeanReporting(FormBakingBeanReporting var1) {
      this.formBakingBeanReporting = var1;
   }

   public long getStrImpFactGlobale() {
      return this.strImpFactGlobale;
   }

   public void setStrImpFactGlobale(long var1) {
      this.strImpFactGlobale = var1;
   }

   public int getVar_choix_periode() {
      return this.var_choix_periode;
   }

   public void setVar_choix_periode(int var1) {
      this.var_choix_periode = var1;
   }

   public String getImpCorpsMail() {
      return this.impCorpsMail;
   }

   public void setImpCorpsMail(String var1) {
      this.impCorpsMail = var1;
   }

   public List getLesScripts() {
      return this.lesScripts;
   }

   public void setLesScripts(List var1) {
      this.lesScripts = var1;
   }

   public boolean isShowModalPanelHelpDesk() {
      return this.showModalPanelHelpDesk;
   }

   public void setShowModalPanelHelpDesk(boolean var1) {
      this.showModalPanelHelpDesk = var1;
   }

   public List getAvenantImpressionItems() {
      return this.avenantImpressionItems;
   }

   public void setAvenantImpressionItems(List var1) {
      this.avenantImpressionItems = var1;
   }

   public String getAvenantListe() {
      return this.avenantListe;
   }

   public void setAvenantListe(String var1) {
      this.avenantListe = var1;
   }
}
