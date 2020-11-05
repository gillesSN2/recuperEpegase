package com.epegase.forms.paye;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.CvAgents;
import com.epegase.systeme.classe.CvAgentsCriteres;
import com.epegase.systeme.classe.CvCriteres;
import com.epegase.systeme.classe.CvSession;
import com.epegase.systeme.classe.ExercicesPaye;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.FileCtrl;
import com.epegase.systeme.control.TransfertPaye;
import com.epegase.systeme.dao.CvAgentsCriteresDao;
import com.epegase.systeme.dao.CvAgentsDao;
import com.epegase.systeme.dao.CvAnalyseDao;
import com.epegase.systeme.dao.CvCriteresDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.HabilitationDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.ObjetLigneOnglet;
import com.epegase.systeme.xml.OptionPaye;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
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
import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;
import org.richfaces.model.selection.SimpleSelection;

public class FormCvAnalyse implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private int var_action = 0;
   private int var_memo_action = 0;
   private String pageIndex;
   private int nature;
   private List mesOnglets;
   private OptionPaye optionPaye;
   private ExercicesPaye exercicesPaye;
   private ExercicesPaye lastExoPaye;
   private EspionDao espionDao;
   private HabilitationDao habilitationDao;
   private CalculChrono calculChrono;
   private UsersChrono usersChrono;
   private int var_nb_max = 100;
   private UserDao userDao;
   private UtilDate utilDate = new UtilDate();
   private int etat;
   private int jour;
   private boolean var_aff_action;
   private boolean testsaisiePointage = false;
   private boolean var_acc_identification = false;
   private boolean var_acc_complement = false;
   private boolean var_acc_familial = false;
   private boolean var_acc_contrat = false;
   private boolean var_ajt = false;
   private boolean var_mod = false;
   private boolean var_sup = false;
   private boolean var_imp = false;
   private List documentImpressionItems = new ArrayList();
   private List listeImpressionItems = new ArrayList();
   private boolean showModalPanelPrint = false;
   private FormRecherche formRecherche;
   private boolean showModalPanelInformation = false;
   private String nomCreation;
   private String nomModification;
   private boolean showModalPanelAnalyseCv = false;
   private CvSession cvSession;
   private transient DataModel dataModelAnalyseCv = new ListDataModel();
   private List lesAnalysesCv = new ArrayList();
   private CvAnalyseDao cvAnalyseDao;
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private boolean var_affiche_bouton = false;
   private CvCriteres cvCriteres;
   private transient DataModel dataModelCriteres = new ListDataModel();
   private List lesCriteres = new ArrayList();
   private CvCriteresDao cvCriteresDao;
   private boolean var_affiche_critere = false;
   private boolean showModalPanelCritere = false;
   private CvAgents cvAgents;
   private transient DataModel dataModelAgents = new ListDataModel();
   private List lesAgents = new ArrayList();
   private CvAgentsDao cvAgentsDao;
   private boolean var_affiche_agents = false;
   private boolean showModalPanelAgents = false;
   private CvAgentsCriteres cvAgentsCriteres;
   private transient DataModel dataModelAgentsCriteres = new ListDataModel();
   private List lesAgentsCriteres = new ArrayList();
   private CvAgentsCriteresDao cvAgentsCriteresDao;
   private boolean showModalPanelImportation = false;
   private FileCtrl fileCtrl;
   private ArrayList listFiles = new ArrayList();
   private UploadItem item;
   private int uploadsAvailable = 1;
   private String numRecup;
   private List lesTransfertPaye = new ArrayList();
   private TransfertPaye transfertPaye;

   public FormCvAnalyse() throws IOException {
   }

   public void InstancesDaoUtilses() {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.habilitationDao = new HabilitationDao(this.baseLog, this.utilInitHibernate);
      this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.cvAnalyseDao = new CvAnalyseDao(this.baseLog, this.utilInitHibernate);
      this.cvCriteresDao = new CvCriteresDao(this.baseLog, this.utilInitHibernate);
      this.cvAgentsDao = new CvAgentsDao(this.baseLog, this.utilInitHibernate);
      this.cvAgentsCriteresDao = new CvAgentsCriteresDao(this.baseLog, this.utilInitHibernate);
   }

   public void initialisation(Session var1) throws HibernateException, NamingException {
      if (this.optionPaye.getNbLigneMax() != null && !this.optionPaye.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionPaye.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

   }

   public void accesResteintUser() {
   }

   public void accesResteintGroupe() throws HibernateException, NamingException {
      this.var_acc_identification = false;
      this.var_acc_complement = false;
      this.var_acc_familial = false;
      this.var_acc_contrat = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("1")) {
               this.var_acc_identification = true;
            } else if (var1.getCode().equals("2")) {
               this.var_acc_complement = true;
            } else if (var1.getCode().equals("3")) {
               this.var_acc_familial = true;
            } else if (var1.getCode().equals("4")) {
               this.var_acc_contrat = true;
            }
         }
      }

   }

   public void autorisationIdentification() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("1")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

   }

   public void autorisationOrdreMission() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("2")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

   }

   public void autorisationAgent() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("3")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

   }

   public void autorisationRetour() throws HibernateException, NamingException {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("4")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

   }

   public String getUrlIp() {
      return StaticModePegase.getUrlIp();
   }

   public Habilitation verifHabilitation(int var1, Session var2) throws HibernateException, NamingException {
      new Habilitation();
      Habilitation var3 = this.habilitationDao.existenceHabilitation(var1, var2);
      return var3;
   }

   public void chargerLesAnalyses() throws HibernateException, NamingException {
      this.chargerLesAnalyses((Session)null);
   }

   public void chargerLesAnalyses(Session var1) throws HibernateException, NamingException {
      this.lesAnalysesCv.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      this.lesAnalysesCv = this.cvAnalyseDao.chargerlesAnalyseCv((Date)null, (Date)null, var1);
      this.dataModelAnalyseCv.setWrappedData(this.lesAnalysesCv);
   }

   public void selectionAnalyse() throws IOException, SQLException, HibernateException, NamingException, ParseException {
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
            this.cvSession = (CvSession)var1.get(0);
            Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "AnalyseCv");
            this.chargerCritere(var4);
            this.chargerCv(var4);
            this.utilInitHibernate.closeSession();
            this.var_affiche_bouton = true;
         } else {
            this.var_affiche_bouton = false;
         }
      } else {
         this.var_affiche_bouton = false;
      }

      this.var_affiche_critere = false;
   }

   public void visualisationAnalyse() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.cvSession != null) {
         if (this.cvSession.getCvsId() == 0L) {
            this.modifierAnalyseCv();
         } else {
            this.consulterAnalyseCv();
         }
      }

   }

   public void chargerCritere(Session var1) throws HibernateException, NamingException {
      this.lesCriteres.clear();
      if (this.cvSession != null) {
         this.lesCriteres = this.cvCriteresDao.chargerlesCritereBySession(this.cvSession, var1);
      }

      this.dataModelCriteres.setWrappedData(this.lesCriteres);
   }

   public void chargerCv(Session var1) throws HibernateException, NamingException {
      this.lesAgents.clear();
      this.lesAgentsCriteres.clear();
      if (this.cvSession != null) {
         this.lesAgents = this.cvAgentsDao.chargerlesAgentsBySession(this.cvSession, var1);
      }

      this.dataModelAgents.setWrappedData(this.lesAgents);
      this.dataModelAgentsCriteres.setWrappedData(this.lesAgentsCriteres);
   }

   public void ajouterAnalyseCv() throws ParseException {
      this.cvSession = new CvSession();
      this.cvSession.setCvsDateDebut(new Date());
      this.cvSession.setCvsIdResponsable(this.usersLog.getUsrid());
      this.cvSession.setCvsNomResponsable(this.usersLog.getUsrPatronyme());
      this.var_aff_action = false;
      this.var_action = 1;
      this.var_memo_action = this.var_action;
   }

   public void modifierAnalyseCv() {
      if (this.cvSession != null) {
         this.var_aff_action = false;
         this.var_action = 2;
         this.var_memo_action = this.var_action;
      }

   }

   public void consulterAnalyseCv() {
      if (this.cvSession != null) {
         this.var_aff_action = true;
         this.var_action = 3;
         this.var_memo_action = this.var_action;
      }

   }

   public void supprimerAnalyseCv() throws HibernateException, NamingException {
      if (this.cvSession != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "AnalyseCv");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.cvAnalyseDao.delete(this.cvSession, var1);
            this.lesAnalysesCv.remove(this.cvSession);
            this.dataModelAnalyseCv.setWrappedData(this.lesAnalysesCv);
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

      this.var_affiche_bouton = false;
      this.var_action = 0;
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
   }

   public void annuleranalyseCv() {
      this.var_affiche_bouton = false;
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public void saveAnalyseCv() throws HibernateException, NamingException, ParseException {
      if (this.cvSession.getCvsId() == 0L) {
         String var1 = this.calculChrono.numCompose(new Date(), this.nature, "", (Session)null);
         this.cvSession.setExercicesPaye(this.exercicesPaye);
         this.cvSession.setCvsDateCreat(new Date());
         this.cvSession.setCvsUserCreat(this.usersLog.getUsrid());
         this.cvSession.setCvsCode(var1);
         this.cvSession = this.cvAnalyseDao.insert(this.cvSession);
         this.lesAnalysesCv.add(this.cvSession);
         this.dataModelAnalyseCv.setWrappedData(this.lesAnalysesCv);
         this.var_action = 2;
         this.simpleSelectionEntete.clear();
         this.extDTable = new HtmlExtendedDataTable();
      } else {
         this.cvSession.setCvsDateModif(new Date());
         this.cvSession.setCvsUserModif(this.usersLog.getUsrid());
         this.cvSession = this.cvAnalyseDao.modif(this.cvSession);
         this.var_action = 0;
      }

   }

   public void selectionnerCritere() {
      if (this.dataModelCriteres.isRowAvailable()) {
         this.cvCriteres = (CvCriteres)this.dataModelCriteres.getRowData();
         this.var_affiche_critere = true;
         this.var_affiche_agents = false;
      }

   }

   public void ajouterCritere() {
      if (this.cvSession != null) {
         this.cvCriteres = new CvCriteres();
         this.showModalPanelCritere = true;
      }

   }

   public void modifierCritere() {
      if (this.cvCriteres != null) {
         this.showModalPanelCritere = true;
      }

   }

   public void supprimerCritere() throws HibernateException, NamingException {
      if (this.cvCriteres != null) {
         this.cvCriteresDao.delete(this.cvCriteres);
         this.lesCriteres.remove(this.cvCriteres);
         this.dataModelCriteres.setWrappedData(this.lesCriteres);
         this.cvCriteres = null;
         this.var_affiche_critere = false;
      }

   }

   public void annulerCritere() {
      this.showModalPanelCritere = false;
      this.var_affiche_critere = false;
   }

   public void validerCritere() throws HibernateException, NamingException {
      if (this.cvCriteres != null) {
         if (this.cvCriteres.getCvcId() == 0L) {
            this.cvCriteres.setCvSession(this.cvSession);
            this.cvCriteres = this.cvCriteresDao.insert(this.cvCriteres);
            this.lesCriteres.add(this.cvCriteres);
            this.dataModelCriteres.setWrappedData(this.lesCriteres);
         } else {
            this.cvCriteres = this.cvCriteresDao.modif(this.cvCriteres);
         }
      }

      this.showModalPanelCritere = false;
      this.var_affiche_critere = true;
   }

   public void selectionnerAgent() throws HibernateException, NamingException {
      if (this.dataModelAgents.isRowAvailable()) {
         this.cvAgents = (CvAgents)this.dataModelAgents.getRowData();
         this.var_affiche_agents = true;
         this.lesAgentsCriteres = this.cvAgentsCriteresDao.chargerlesCritereByAgent(this.cvAgents, (Session)null);

         for(int var1 = 0; var1 < this.lesCriteres.size(); ++var1) {
            boolean var2 = false;

            for(int var3 = 0; var3 < this.lesAgentsCriteres.size(); ++var3) {
               if (((CvAgentsCriteres)this.lesAgentsCriteres.get(var3)).getCvacCritere().equals(((CvCriteres)this.lesCriteres.get(var1)).getCvcCritere())) {
                  var2 = true;
                  break;
               }
            }

            if (!var2) {
               this.cvAgentsCriteres = new CvAgentsCriteres();
               this.cvAgentsCriteres.setCvAgents(this.cvAgents);
               this.cvAgentsCriteres.setCvSession(this.cvSession);
               this.cvAgentsCriteres.setCvacCritere(((CvCriteres)this.lesCriteres.get(var1)).getCvcCritere());
               this.cvAgentsCriteres.setCvacPoints(((CvCriteres)this.lesCriteres.get(var1)).getCvcPoints());
               this.cvAgentsCriteres.setCvacSelect(false);
               this.lesAgentsCriteres.add(this.cvAgentsCriteres);
            }
         }

         this.dataModelAgentsCriteres.setWrappedData(this.lesAgentsCriteres);
      }

   }

   public void ajouterAgent() {
      if (this.cvSession != null) {
         this.lesAgentsCriteres.clear();

         for(int var1 = 0; var1 < this.lesCriteres.size(); ++var1) {
            this.cvAgentsCriteres = new CvAgentsCriteres();
            this.cvAgentsCriteres.setCvAgents(this.cvAgents);
            this.cvAgentsCriteres.setCvSession(this.cvSession);
            this.cvAgentsCriteres.setCvacCritere(((CvCriteres)this.lesCriteres.get(var1)).getCvcCritere());
            this.cvAgentsCriteres.setCvacPoints(((CvCriteres)this.lesCriteres.get(var1)).getCvcPoints());
            this.cvAgentsCriteres.setCvacSelect(false);
            this.lesAgentsCriteres.add(this.cvAgentsCriteres);
         }

         this.dataModelAgentsCriteres.setWrappedData(this.lesAgentsCriteres);
         this.cvAgents = new CvAgents();
         this.showModalPanelAgents = true;
      }

   }

   public void modifierAgent() {
      if (this.cvAgents != null) {
         this.showModalPanelAgents = true;
      }

   }

   public void supprimerAgent() throws HibernateException, NamingException {
      if (this.cvAgents != null) {
         this.cvAgentsDao.delete(this.cvAgents);
         this.lesAgents.remove(this.cvAgents);
         this.dataModelAgents.setWrappedData(this.lesAgents);
         this.cvAgents = null;
         this.var_affiche_agents = false;
      }

   }

   public void annulerAgent() {
      this.showModalPanelAgents = false;
      this.var_affiche_agents = false;
   }

   public void validerAgent() throws HibernateException, NamingException {
      if (this.cvAgents != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "AnalyseCv");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            float var3 = 0.0F;

            int var4;
            for(var4 = 0; var4 < this.lesAgentsCriteres.size(); ++var4) {
               if (((CvAgentsCriteres)this.lesAgentsCriteres.get(var4)).isCvacSelect()) {
                  var3 += (float)((CvAgentsCriteres)this.lesAgentsCriteres.get(var4)).getCvacPoints();
               }
            }

            if (this.cvAgents.getCvaId() == 0L) {
               this.cvAgents.setCvSession(this.cvSession);
               this.cvAgents.setCvaNote(var3);
               this.cvAgents = this.cvAgentsDao.insert(this.cvAgents, var1);
               this.lesAgents.add(this.cvAgents);
               this.dataModelAgents.setWrappedData(this.lesAgents);
            } else {
               this.cvAgents.setCvaNote(var3);
               this.cvAgents = this.cvAgentsDao.modif(this.cvAgents, var1);
            }

            if (this.lesAgentsCriteres.size() != 0) {
               for(var4 = 0; var4 < this.lesAgentsCriteres.size(); ++var4) {
                  this.cvAgentsCriteres = (CvAgentsCriteres)this.lesAgentsCriteres.get(var4);
                  if (this.cvAgentsCriteres.isCvacSelect()) {
                     if (this.cvAgentsCriteres.getCvacId() == 0L) {
                        this.cvAgentsCriteres.setCvAgents(this.cvAgents);
                        this.cvAgentsCriteres.setCvSession(this.cvSession);
                        this.cvAgentsCriteres = this.cvAgentsCriteresDao.insert(this.cvAgentsCriteres, var1);
                     } else {
                        this.cvAgentsCriteres = this.cvAgentsCriteresDao.modif(this.cvAgentsCriteres, var1);
                     }
                  } else if (this.cvAgentsCriteres.getCvacId() != 0L) {
                     this.cvAgentsCriteresDao.delete(this.cvAgentsCriteres, var1);
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

      this.showModalPanelAgents = false;
      this.var_affiche_agents = true;
   }

   public void importerAgent() {
      if (this.cvSession != null) {
         this.showModalPanelImportation = true;
      }

   }

   public void annulerImporterAgent() {
      this.var_affiche_agents = false;
      this.showModalPanelImportation = false;
   }

   public void listener(UploadEvent var1) throws NamingException, HibernateException, ParseException, groovyjarjarcommonscli.ParseException {
      this.item = var1.getUploadItem();
      this.fileCtrl = new FileCtrl();
      this.fileCtrl.setLength(this.item.getFileSize());
      this.fileCtrl.setName(this.item.getFileName());
      this.fileCtrl.setChemin(this.item.getFile().getPath().toString());
      this.fileCtrl.setData(this.item.getData());
      this.listFiles.add(this.fileCtrl);
      --this.uploadsAvailable;
      this.importationFichier();
   }

   public void importationFichier() throws NamingException, HibernateException, ParseException, groovyjarjarcommonscli.ParseException {
      try {
         ArrayList var1 = new ArrayList();
         if (this.listFiles.size() != 0) {
            for(int var2 = 0; var2 < this.listFiles.size(); ++var2) {
               this.fileCtrl = (FileCtrl)this.listFiles.get(var2);
               String var3 = ((FileCtrl)this.listFiles.get(var2)).getName();
               File var4 = new File(this.fileCtrl.getChemin());
               if (var4.exists()) {
                  FileReader var5 = new FileReader(var4);
                  BufferedReader var6 = new BufferedReader(var5);

                  for(String var7 = var6.readLine(); var7 != null; var7 = var6.readLine()) {
                     if (var7.contains("\"")) {
                        char[] var8 = var7.toCharArray();
                        String var9 = "";

                        for(int var10 = 0; var10 < var8.length; ++var10) {
                           if (var8[var10] != '"') {
                              var9 = var9 + var8[var10];
                           }
                        }

                        var7 = var9;
                     }

                     if (var7.contains("'")) {
                        var7.replace("'", "`");
                     }

                     var1.add(var7);
                  }

                  var6.close();
                  var5.close();
               }
            }
         }

         if (var1.size() != 0) {
            this.preparationTransfertImport(var1);
         }
      } catch (IOException var11) {
         var11.printStackTrace();
      }

   }

   public void preparationTransfertImport(List var1) throws ParseException, HibernateException, NamingException {
      this.lesTransfertPaye.clear();
      this.lesTransfertPaye = new ArrayList();
      String var3;
      int var14;
      if (var1.size() != 0) {
         for(int var2 = 0; var2 < var1.size(); ++var2) {
            var3 = (String)var1.get(var2);
            boolean var4 = false;
            String[] var5 = null;
            var5 = var3.split(",");
            var14 = var5.length;
            if (var14 == 7) {
               this.transfertPaye = new TransfertPaye();
               this.importCandidat(var5);
            }
         }
      }

      if (this.lesTransfertPaye.size() != 0) {
         Session var12 = this.utilInitHibernate.getOpenSession(this.baseLog, "AnalyseCv");
         var3 = null;

         try {
            Transaction var13 = var12.beginTransaction();

            for(var14 = 0; var14 < this.lesTransfertPaye.size(); ++var14) {
               this.transfertPaye = (TransfertPaye)this.lesTransfertPaye.get(var14);
               boolean var15 = false;

               for(int var6 = 0; var6 < this.lesAgents.size(); ++var6) {
                  if (((CvAgents)this.lesAgents.get(var6)).getCvaAgent().equals(this.transfertPaye.getTrfColT01())) {
                     var15 = true;
                     break;
                  }
               }

               if (!var15) {
                  this.cvAgents = new CvAgents();
                  this.cvAgents.setCvSession(this.cvSession);
                  this.cvAgents.setCvaAgent(this.transfertPaye.getTrfColT01());
                  if (this.transfertPaye.getTrfColT02() != null && !this.transfertPaye.getTrfColT02().isEmpty()) {
                     this.cvAgents.setCvaAge(Integer.parseInt(this.transfertPaye.getTrfColT02()));
                  } else {
                     this.cvAgents.setCvaAge(9);
                  }

                  this.cvAgents.setCvaGenre(this.transfertPaye.getTrfColT03());
                  this.cvAgents.setCvaNationalite(this.transfertPaye.getTrfColT04());
                  this.cvAgents.setCvaResidence(this.transfertPaye.getTrfColT05());
                  this.cvAgents.setCvaDiplomeMax(this.transfertPaye.getTrfColT06());
                  this.cvAgents.setCvaCommentaires(this.transfertPaye.getTrfColT07());
                  this.cvAgents.setCvaNote(0.0F);
                  this.cvAgents = this.cvAgentsDao.insert(this.cvAgents, var12);
                  this.lesAgents.add(this.cvAgents);
               }
            }

            var13.commit();
         } catch (HibernateException var10) {
            if (var3 != null) {
               var3.rollback();
            }

            throw var10;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.dataModelAgents.setWrappedData(this.lesAgents);
      }

   }

   public void importCandidat(String[] var1) throws ParseException {
      if (var1[0] != null && !var1[0].isEmpty()) {
         this.transfertPaye.setTrfColT01(var1[0]);
      }

      if (var1[1] != null && !var1[1].isEmpty()) {
         this.transfertPaye.setTrfColT02(var1[1]);
      }

      if (var1[2] != null && !var1[2].isEmpty()) {
         this.transfertPaye.setTrfColT03(var1[2]);
      }

      if (var1[3] != null && !var1[3].isEmpty()) {
         this.transfertPaye.setTrfColT04(var1[3]);
      }

      if (var1[4] != null && !var1[4].isEmpty()) {
         this.transfertPaye.setTrfColT05(var1[4]);
      }

      if (var1[5] != null && !var1[5].isEmpty()) {
         this.transfertPaye.setTrfColT06(var1[5]);
      }

      if (var1[6] != null && !var1[6].isEmpty()) {
         this.transfertPaye.setTrfColT07(var1[6]);
      }

      if (this.transfertPaye.getTrfColT01() != null && !this.transfertPaye.getTrfColT01().isEmpty()) {
         this.lesTransfertPaye.add(this.transfertPaye);
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

   public void chargerLesModelesImpresion() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "liste" + File.separator + "pointage";
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.listeImpressionItems = new ArrayList();
      String[] var3 = var2.list();
      int var4;
      String var5;
      int var6;
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(var4 = 0; var4 < var3.length; ++var4) {
            var5 = var3[var4];
            if (var5.endsWith("jasper")) {
               var6 = var5.indexOf(".");
               var5 = var5.substring(0, var6);
               this.listeImpressionItems.add(new SelectItem(var5));
            }
         }
      }

      var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "document" + File.separator + "pointage";
      var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);
         this.documentImpressionItems = new ArrayList();

         for(var4 = 0; var4 < var3.length; ++var4) {
            var5 = var3[var4];
            if (var5.endsWith("jasper")) {
               var6 = var5.indexOf(".");
               var5 = var5.substring(0, var6);
               this.documentImpressionItems.add(new SelectItem(var5));
            }
         }
      }

   }

   public void impression(UtilPrint var1, int var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9) throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      if (var3 != null && !var3.isEmpty()) {
         if (!var5.equals("MAIL")) {
            var1 = new UtilPrint(this.utilInitHibernate);
         }

         if (var2 == 0) {
            var1.setRapport(var3);
            var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "document" + File.separator + "pointage" + File.separator);
            var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "sous_rapport" + File.separator);
            var1.setEntete("Feuille de temps de ");
            var1.setFiltre("Période de ");
            var1.setFormat(var5);
            var1.setEmetteur(var6);
            var1.setDestinataire(var7);
            var1.setDestinataireCC(var7);
            var1.setDestinataireCCI(var7);
            var1.setTiersSelectionne((Tiers)null);
            JRBeanCollectionDataSource var10 = new JRBeanCollectionDataSource(this.lesAnalysesCv);
            var1.setjRBeanCollectionDataSource(var10);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      }

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

   public List getMesOnglets() {
      return this.mesOnglets;
   }

   public void setMesOnglets(List var1) {
      this.mesOnglets = var1;
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

   public boolean isVar_acc_contrat() {
      return this.var_acc_contrat;
   }

   public void setVar_acc_contrat(boolean var1) {
      this.var_acc_contrat = var1;
   }

   public boolean isVar_acc_complement() {
      return this.var_acc_complement;
   }

   public void setVar_acc_complement(boolean var1) {
      this.var_acc_complement = var1;
   }

   public boolean isVar_acc_familial() {
      return this.var_acc_familial;
   }

   public void setVar_acc_familial(boolean var1) {
      this.var_acc_familial = var1;
   }

   public boolean isVar_acc_identification() {
      return this.var_acc_identification;
   }

   public void setVar_acc_identification(boolean var1) {
      this.var_acc_identification = var1;
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

   public ExercicesPaye getExercicesPaye() {
      return this.exercicesPaye;
   }

   public void setExercicesPaye(ExercicesPaye var1) {
      this.exercicesPaye = var1;
   }

   public ExercicesPaye getLastExoPaye() {
      return this.lastExoPaye;
   }

   public void setLastExoPaye(ExercicesPaye var1) {
      this.lastExoPaye = var1;
   }

   public OptionPaye getOptionPaye() {
      return this.optionPaye;
   }

   public void setOptionPaye(OptionPaye var1) {
      this.optionPaye = var1;
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

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public int getEtat() {
      return this.etat;
   }

   public void setEtat(int var1) {
      this.etat = var1;
   }

   public boolean isTestsaisiePointage() {
      return this.testsaisiePointage;
   }

   public void setTestsaisiePointage(boolean var1) {
      this.testsaisiePointage = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public int getJour() {
      return this.jour;
   }

   public void setJour(int var1) {
      this.jour = var1;
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

   public boolean isVar_aff_action() {
      return this.var_aff_action;
   }

   public void setVar_aff_action(boolean var1) {
      this.var_aff_action = var1;
   }

   public CvSession getCvSession() {
      return this.cvSession;
   }

   public void setCvSession(CvSession var1) {
      this.cvSession = var1;
   }

   public boolean isShowModalPanelAnalyseCv() {
      return this.showModalPanelAnalyseCv;
   }

   public void setShowModalPanelAnalyseCv(boolean var1) {
      this.showModalPanelAnalyseCv = var1;
   }

   public DataModel getDataModelAnalyseCv() {
      return this.dataModelAnalyseCv;
   }

   public void setDataModelAnalyseCv(DataModel var1) {
      this.dataModelAnalyseCv = var1;
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

   public boolean isVar_affiche_bouton() {
      return this.var_affiche_bouton;
   }

   public void setVar_affiche_bouton(boolean var1) {
      this.var_affiche_bouton = var1;
   }

   public CvCriteres getCvCriteres() {
      return this.cvCriteres;
   }

   public void setCvCriteres(CvCriteres var1) {
      this.cvCriteres = var1;
   }

   public DataModel getDataModelCriteres() {
      return this.dataModelCriteres;
   }

   public void setDataModelCriteres(DataModel var1) {
      this.dataModelCriteres = var1;
   }

   public boolean isShowModalPanelCritere() {
      return this.showModalPanelCritere;
   }

   public void setShowModalPanelCritere(boolean var1) {
      this.showModalPanelCritere = var1;
   }

   public boolean isVar_affiche_critere() {
      return this.var_affiche_critere;
   }

   public void setVar_affiche_critere(boolean var1) {
      this.var_affiche_critere = var1;
   }

   public CvAgents getCvAgents() {
      return this.cvAgents;
   }

   public void setCvAgents(CvAgents var1) {
      this.cvAgents = var1;
   }

   public DataModel getDataModelAgents() {
      return this.dataModelAgents;
   }

   public void setDataModelAgents(DataModel var1) {
      this.dataModelAgents = var1;
   }

   public boolean isShowModalPanelAgents() {
      return this.showModalPanelAgents;
   }

   public void setShowModalPanelAgents(boolean var1) {
      this.showModalPanelAgents = var1;
   }

   public boolean isVar_affiche_agents() {
      return this.var_affiche_agents;
   }

   public void setVar_affiche_agents(boolean var1) {
      this.var_affiche_agents = var1;
   }

   public CvAgentsCriteres getCvAgentsCriteres() {
      return this.cvAgentsCriteres;
   }

   public void setCvAgentsCriteres(CvAgentsCriteres var1) {
      this.cvAgentsCriteres = var1;
   }

   public DataModel getDataModelAgentsCriteres() {
      return this.dataModelAgentsCriteres;
   }

   public void setDataModelAgentsCriteres(DataModel var1) {
      this.dataModelAgentsCriteres = var1;
   }

   public boolean isShowModalPanelImportation() {
      return this.showModalPanelImportation;
   }

   public void setShowModalPanelImportation(boolean var1) {
      this.showModalPanelImportation = var1;
   }

   public int getUploadsAvailable() {
      return this.uploadsAvailable;
   }

   public void setUploadsAvailable(int var1) {
      this.uploadsAvailable = var1;
   }
}
