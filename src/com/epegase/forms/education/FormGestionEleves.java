package com.epegase.forms.education;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.Eleves;
import com.epegase.systeme.classe.ElevesAppels;
import com.epegase.systeme.classe.ElevesInscription;
import com.epegase.systeme.classe.ElevesNote;
import com.epegase.systeme.classe.ElevesViolences;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FilieresEducation;
import com.epegase.systeme.classe.FilieresMatieres;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.DocumentEducation;
import com.epegase.systeme.dao.ElevesAppelsDao;
import com.epegase.systeme.dao.ElevesDao;
import com.epegase.systeme.dao.ElevesInscriptionDao;
import com.epegase.systeme.dao.ElevesNoteDao;
import com.epegase.systeme.dao.ElevesViolencesDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.FilieresEducationDao;
import com.epegase.systeme.dao.FilieresMatieresDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilDownload;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.ObjetLigneOnglet;
import com.epegase.systeme.xml.OptionVentes;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.myfaces.custom.fileupload.UploadedFile;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jdom.JDOMException;
import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlExtendedDataTable;
import org.richfaces.model.selection.SimpleSelection;

public class FormGestionEleves implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private FormRecherche formRecherche;
   private int var_action = 0;
   private int var_memo_action = 0;
   private String pageIndex;
   private int nature;
   private int natureGestionEleve;
   private UsersChrono usersChrono;
   private UsersChronoDao usersChronoDao;
   private List mesOnglets;
   private OptionVentes optionsVentes;
   private ExercicesVentes exercicesVentes;
   private ExercicesVentes lastExoVentes;
   private EspionDao espionDao;
   private int var_nb_max = 100;
   private UtilDate utilDate = new UtilDate();
   private UtilNombre utilNombre = new UtilNombre();
   private CalculChrono calculChrono;
   private double montantTtc = 0.0D;
   private double montantSolde = 0.0D;
   private double montantReglement = 0.0D;
   private double montantTtcElmt = 0.0D;
   private double montantSoldeElmt = 0.0D;
   private double montantReglementElmt = 0.0D;
   private int var_nb_ligne = 0;
   private transient DataModel datamodelDocument = new ListDataModel();
   private List listDocument = new ArrayList();
   private Eleves eleves = new Eleves();
   private ElevesDao elevesDao;
   private ElevesInscription elevesInscription = new ElevesInscription();
   private ElevesInscriptionDao elevesInscriptionDao;
   private List mesInscriptionsItems = new ArrayList();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private boolean visibiliteBton = false;
   private boolean showModalPanelDocument = false;
   private boolean var_valide_doc;
   private boolean var_aff_action;
   private FilieresEducationDao filieresEducationDao;
   private FilieresEducation filieresEducation;
   private FilieresMatieresDao filieresMatieresDao;
   private FilieresMatieres filieresMatieres;
   private boolean afficheListeEleve;
   private boolean var_more_search = false;
   private long inpClasse;
   private String inpMatricule;
   private String inpNom;
   private String inpSerie;
   private int inpEtat;
   private Date inpDate;
   private Date inpDateDebut;
   private Date inpDateFin;
   private long inpMatiere;
   private long inpProfesseur;
   private int inpType;
   private int inpMode;
   private double inpMax;
   private double inpCoef;
   private List mesClasseItems;
   private List mesMatiereresItems;
   private List mesProfesseursItems;
   private UserDao userDao;
   private boolean var_acc_document = false;
   private boolean var_acc_imputation = false;
   private boolean var_acc_complement = false;
   private boolean var_acc_reglement = false;
   private boolean var_acc_dre = false;
   private boolean var_acc_habilitation = false;
   private boolean var_acc_etat = false;
   private boolean var_acc_tracabilite = false;
   private boolean var_acc_exoneration = false;
   private boolean var_ajt = false;
   private boolean var_mod = false;
   private boolean var_sup = false;
   private boolean var_imp = false;
   private List documentImpressionItems = new ArrayList();
   private List listeImpressionItems = new ArrayList();
   private boolean showModalPanelPrint = false;
   private UtilDownload utilDownload;
   private String urlphotoProd;
   private String fileName;
   private UploadedFile uploadedFile;
   private static final int DEFAULT_BUFFER_SIZE = 10240;
   private boolean showModalPanelScan = false;
   private int typeFichier;
   private String fichierMine;
   private URL fichierUrl;
   private String urlExplorateur;
   private boolean showModalPanelGraph = false;
   private int timeDecoupage;
   private int modeGraph;
   private int valQteGraph;
   private String titreGraph;
   private String sousTitreGraph;
   private String uniteGraph;
   private int nbDecGraph;
   private String deviseGraph;
   private boolean showModele;
   private Habilitation habilitation;
   private ElevesAppels elevesAppels;
   private ElevesAppelsDao elevesAppelsDao;
   private List listAppels;
   private transient DataModel datamodelAppels;
   private boolean showModalPanelAnnuler = false;
   private Date dateAnnulation;
   private String motifAnnulation;
   private boolean showModalPanelPresence = false;
   private ElevesNote elevesNote;
   private ElevesNoteDao elevesNoteDao;
   private List listNotes;
   private transient DataModel datamodelNote;
   private boolean showModalPanelNote = false;
   private long choixInscription;
   private int choixMatiere;
   private Date dDeb1T;
   private Date dFin1T;
   private Date dDeb2T;
   private Date dFin2T;
   private Date dDeb3T;
   private Date dFin3T;
   private Date dDeb4T;
   private Date dFin4T;
   private ElevesViolences elevesViolences;
   private ElevesViolencesDao elevesViolencesDao;
   private List listViolences;
   private transient DataModel datamodelViolences;
   private boolean showModalPanelViolences = false;

   public FormGestionEleves() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.mesClasseItems = new ArrayList();
      this.utilDownload = new UtilDownload();
      this.mesMatiereresItems = new ArrayList();
      this.mesProfesseursItems = new ArrayList();
      this.listAppels = new ArrayList();
      this.datamodelAppels = new ListDataModel();
      this.listNotes = new ArrayList();
      this.datamodelNote = new ListDataModel();
      this.listViolences = new ArrayList();
      this.datamodelViolences = new ListDataModel();
   }

   public void InstancesDaoUtilses() {
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.filieresEducationDao = new FilieresEducationDao(this.baseLog, this.utilInitHibernate);
      this.filieresMatieresDao = new FilieresMatieresDao(this.baseLog, this.utilInitHibernate);
      this.elevesDao = new ElevesDao(this.baseLog, this.utilInitHibernate);
      this.elevesInscriptionDao = new ElevesInscriptionDao(this.baseLog, this.utilInitHibernate);
      this.elevesAppelsDao = new ElevesAppelsDao(this.baseLog, this.utilInitHibernate);
      this.elevesNoteDao = new ElevesNoteDao(this.baseLog, this.utilInitHibernate);
      this.elevesViolencesDao = new ElevesViolencesDao(this.baseLog, this.utilInitHibernate);
   }

   public void configVentes(Session var1) throws HibernateException, NamingException {
      if (this.structureLog.getStrtypeentreprise() == null || this.structureLog.getStrtypeentreprise().isEmpty()) {
         this.structureLog.setStrtypeentreprise("0");
      }

      if (this.optionsVentes.getDecrmtPrsChrStock() == null || this.optionsVentes.getDecrmtPrsChrStock().isEmpty()) {
         this.optionsVentes.setDecrmtPrsChrStock("0");
      }

      if (this.optionsVentes.getNbLigneMax() != null && !this.optionsVentes.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionsVentes.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
   }

   public void accesResteintUser() {
   }

   public void accesResteintGroupe() {
      this.var_acc_document = false;
      this.var_acc_imputation = false;
      this.var_acc_complement = false;
      this.var_acc_reglement = false;
      this.var_acc_dre = false;
      this.var_acc_habilitation = false;
      this.var_acc_etat = false;
      this.var_acc_tracabilite = false;
      this.var_acc_exoneration = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("51")) {
               this.var_acc_document = true;
            } else if (var1.getCode().equals("52")) {
               this.var_acc_imputation = true;
            } else if (var1.getCode().equals("53")) {
               this.var_acc_complement = true;
            } else if (var1.getCode().equals("54")) {
               this.var_acc_reglement = true;
            } else if (var1.getCode().equals("55")) {
               this.var_acc_dre = true;
            } else if (var1.getCode().equals("56")) {
               this.var_acc_habilitation = true;
            } else if (var1.getCode().equals("57")) {
               this.var_acc_etat = true;
            } else if (var1.getCode().equals("58")) {
               this.var_acc_tracabilite = true;
            } else if (var1.getCode().equals("59")) {
               this.var_acc_exoneration = true;
            }
         }
      }

   }

   public void autorisationDocument() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("51")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void autorisationImputation() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("52")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void autorisationComplement() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("53")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void autorisationReglement() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("54")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void autorisationDre() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("55")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void autorisationHabilitation() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("56")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void autorisationEtat() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("57")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void autorisationTracabilite() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("58")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void autorisationExoneration() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("59")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void moreSearch() throws ParseException {
      if (!this.var_more_search) {
         this.var_more_search = true;
      } else {
         this.var_more_search = false;
      }

   }

   public void executerRequete() throws NamingException, HibernateException, ParseException, groovyjarjarcommonscli.ParseException {
      this.executerRequete((Session)null);
   }

   public void executerRequete(Session var1) throws NamingException, HibernateException, ParseException, groovyjarjarcommonscli.ParseException {
      this.listDocument.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      this.var_nb_ligne = 0;
      this.listDocument = this.elevesDao.chargerListEleves(this.rechercherEleves(), 0L, (Session)null);
      if (this.listDocument.size() > 0) {
         this.var_nb_ligne = this.listDocument.size();
      } else {
         this.var_nb_ligne = 0;
      }

      this.datamodelDocument.setWrappedData(this.listDocument);
      this.visibiliteBton = false;
   }

   public String rechercherEleves() {
      String var1 = "";
      var1 = "from ElevesInscription where eleves.eleId>0";
      if (this.inpClasse != 0L) {
         var1 = var1 + " and filieresEducation.filId=" + this.inpClasse;
      }

      if (this.inpNom != null && !this.inpNom.isEmpty()) {
         var1 = var1 + " and eleves.eleNom LIKE '" + this.inpNom + "%'";
      }

      if (this.inpMatricule != null && !this.inpMatricule.isEmpty()) {
         var1 = var1 + " and eleves.eleDossier LIKE '%" + this.inpMatricule + "'";
      }

      if (this.inpEtat != 0) {
         var1 = var1 + " and eleinsEtat=" + this.inpEtat;
      }

      return var1;
   }

   public void selectionLigne() throws HibernateException, NamingException, IOException, SQLException {
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
            this.elevesInscription = (ElevesInscription)var1.get(0);
            this.eleves = this.elevesInscription.getEleves();
            Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "Eleves");
            this.chargerInscriptionByEleve(var4);
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
      if (this.eleves != null) {
         this.consultDocument();
      }

   }

   public void ajouterDocument() {
      this.eleves = new Eleves();
      this.var_action = 1;
      this.var_memo_action = this.var_action;
   }

   public void modifierDocument() {
      if (this.eleves != null) {
         this.var_action = 2;
         this.var_memo_action = this.var_action;
      }

   }

   public void consultDocument() {
      if (this.eleves != null) {
         this.var_action = 3;
         this.var_memo_action = this.var_action;
      }

   }

   public void chargerInscriptionByEleve(Session var1) throws HibernateException, NamingException {
      if (this.eleves != null) {
         new ArrayList();
         List var2 = this.elevesInscriptionDao.chargerLesElevesInscription(this.eleves, var1);
         if (var2.size() != 0) {
            for(int var3 = 0; var3 < var2.size(); ++var3) {
               this.mesInscriptionsItems.add(new SelectItem(((ElevesInscription)var2.get(var3)).getEleinsId(), ((ElevesInscription)var2.get(var3)).getEleinsAnnee() + ":" + ((ElevesInscription)var2.get(var3)).getFilieresEducation().getFilCode() + ":" + ((ElevesInscription)var2.get(var3)).getFilieresEducation().getFilLibelle()));
            }

            this.choixInscription = Long.parseLong(((SelectItem)this.mesInscriptionsItems.get(0)).getValue().toString());
         } else {
            this.choixInscription = 0L;
         }
      }

   }

   public void chargerMatieresByEleve(Session var1) throws HibernateException, NamingException {
      this.listNotes.clear();
      this.datamodelNote.setWrappedData(this.listNotes);
      this.mesMatiereresItems.clear();
      if (this.choixInscription != 0L) {
         this.elevesInscription = this.elevesInscriptionDao.chargerLesElevesById(this.choixInscription, var1);
         if (this.elevesInscription != null && this.elevesInscription.getFilieresEducation() != null) {
            this.filieresEducation = this.elevesInscription.getFilieresEducation();
         } else {
            this.filieresEducation = null;
         }

         if (this.eleves != null && this.elevesInscription != null && this.filieresEducation != null) {
            this.mesMatiereresItems = this.filieresMatieresDao.mesMatieresByFiliereItems(this.filieresEducation, var1);
         }
      }

   }

   public void chargerNotesByMatiere() throws HibernateException, NamingException {
      if (this.eleves != null && this.elevesInscription != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Eleves");
         if (this.choixMatiere != 0) {
            this.filieresMatieres = this.filieresMatieresDao.pourParapheur((long)this.choixMatiere, var1);
            if (this.filieresMatieres != null) {
               this.listNotes = this.elevesNoteDao.chargerLesElevesNote(this.eleves, this.elevesInscription, this.filieresMatieres, var1);
            } else {
               this.listNotes.clear();
            }
         } else {
            this.listNotes = this.elevesNoteDao.chargerLesElevesNote(this.eleves, this.elevesInscription, var1);
         }

         this.utilInitHibernate.closeSession();
         this.datamodelNote.setWrappedData(this.listNotes);
      }

   }

   public void chargerPresencesByMatiere() throws HibernateException, NamingException {
      if (this.eleves != null && this.elevesInscription != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Eleves");
         if (this.choixMatiere != 0) {
            this.filieresMatieres = this.filieresMatieresDao.pourParapheur((long)this.choixMatiere, var1);
            if (this.filieresMatieres != null) {
               this.listAppels = this.elevesAppelsDao.chargerLesElevesAppels(this.eleves, this.elevesInscription, this.filieresMatieres, var1);
            } else {
               this.listAppels.clear();
            }
         } else {
            this.listAppels = this.elevesAppelsDao.chargerLesElevesAppels(this.eleves, this.elevesInscription, var1);
         }

         this.utilInitHibernate.closeSession();
         this.datamodelAppels.setWrappedData(this.listAppels);
      }

   }

   public void chargerUserChrono(Session var1) throws HibernateException, NamingException {
      if (this.eleves != null) {
         this.usersChrono = this.usersChronoDao.selectUnique("", this.nature, this.usersLog, var1);
      }

   }

   public void annuleDocument() {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.visibiliteBton = false;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public void saveDocument() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ClassementMediatheque");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         var2.commit();
      } catch (HibernateException var7) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var7;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_action = 0;
      this.var_memo_action = this.var_action;
   }

   public void valideDocument() throws HibernateException, NamingException, ParseException {
      if (this.eleves != null) {
      }

   }

   public void deValideDocument() throws HibernateException, NamingException, ParseException {
      if (this.eleves != null) {
      }

   }

   public void executerRequeteAppels() throws NamingException, HibernateException, ParseException, groovyjarjarcommonscli.ParseException {
      this.executerRequeteAppels((Session)null);
   }

   public void executerRequeteAppels(Session var1) throws NamingException, HibernateException, ParseException, groovyjarjarcommonscli.ParseException {
      this.listAppels.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      this.var_nb_ligne = 0;
      this.listAppels = this.elevesAppelsDao.chargerLesElevesAppels(this.inpDateDebut, this.inpDateFin, this.inpClasse, this.inpMatiere, this.exercicesVentes, this.inpEtat, this.inpNom, this.inpMatricule, var1);
      if (this.listAppels.size() > 0) {
         this.var_nb_ligne = this.listAppels.size();
      } else {
         this.var_nb_ligne = 0;
      }

      this.datamodelAppels.setWrappedData(this.listAppels);
      this.visibiliteBton = false;
   }

   public void selectionLigneAppels() throws HibernateException, NamingException, IOException, SQLException {
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
            this.elevesAppels = (ElevesAppels)var1.get(0);
            this.visibiliteBton = true;
         } else {
            this.visibiliteBton = false;
         }
      } else {
         this.visibiliteBton = false;
      }

   }

   public void visualisationLigneAppels() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.datamodelAppels.isRowAvailable()) {
         this.elevesAppels = (ElevesAppels)this.datamodelAppels.getRowData();
      }

   }

   public void gestionAppels() {
   }

   public void selectionAppels() {
      if (this.datamodelAppels.isRowAvailable()) {
         this.elevesAppels = (ElevesAppels)this.datamodelAppels.getRowData();
         this.eleves = this.elevesAppels.getEleves();
      }

   }

   public void ajouterAppels() {
      this.inpDate = new Date();
      this.inpSerie = "";
      this.inpClasse = 0L;
      this.inpMatiere = 0L;
      this.mesMatiereresItems.clear();
      this.inpProfesseur = 0L;
      this.mesProfesseursItems.clear();
      this.afficheListeEleve = false;
      this.listAppels.clear();
      this.datamodelAppels.setWrappedData(this.listAppels);
      this.elevesAppels = new ElevesAppels();
      this.var_action = 1;
      this.var_valide_doc = false;
      this.var_aff_action = false;
   }

   public void modifierAppels() throws HibernateException, NamingException {
      if (this.elevesAppels != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Eleves");
         this.listDocument.clear();
         this.listDocument = this.elevesDao.chargerListEleves(this.rechercherEleves(), this.elevesAppels.getFilieresEducation().getFilId(), var1);
         this.inpDate = this.elevesAppels.getEleappDate();
         this.inpSerie = "";
         this.inpClasse = this.elevesAppels.getFilieresEducation().getFilId();
         this.inpMatiere = this.elevesAppels.getFilieresMatieres().getFilmatId();
         this.chargerMatieres(var1);
         this.inpProfesseur = this.elevesAppels.getEleappIdProfesseur();
         this.mesProfesseursItems.clear();
         this.selectionMatiere(var1);
         this.afficheListeEleve = true;
         this.listAppels.clear();
         this.listAppels = this.elevesAppelsDao.chargerLesElevesAppels(this.elevesAppels.getEleappNum(), this.elevesAppels.getExercicesVentes(), var1);
         if (this.listDocument.size() != 0) {
            for(int var2 = 0; var2 < this.listDocument.size(); ++var2) {
               this.eleves = (Eleves)this.listDocument.get(var2);
               boolean var3 = false;
               if (this.listAppels.size() != 0) {
                  for(int var4 = 0; var4 < this.listAppels.size(); ++var4) {
                     if (this.eleves.getEleId() == ((ElevesAppels)this.listAppels.get(var4)).getEleves().getEleId() && ((ElevesAppels)this.listAppels.get(var4)).getFilieresMatieres().getFilmatId() == this.inpMatiere) {
                        var3 = true;
                        break;
                     }
                  }
               }

               if (!var3) {
                  this.elevesAppels = new ElevesAppels();
                  this.elevesAppels.setEleves(this.eleves);
                  this.elevesAppels.setExercicesVentes(this.exercicesVentes);
                  this.elevesAppels.setFilieresEducation(this.filieresEducation);
                  this.elevesAppels.setFilieresMatieres(this.filieresMatieres);
                  this.listAppels.add(this.elevesAppels);
               }
            }
         }

         this.datamodelAppels.setWrappedData(this.listAppels);
         this.elevesAppels = new ElevesAppels();
         this.var_action = 2;
         this.var_valide_doc = true;
         this.var_aff_action = true;
         this.utilInitHibernate.closeSession();
      }

   }

   public void consulterAppels() throws HibernateException, NamingException {
      if (this.elevesAppels != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Eleves");
         this.inpDate = this.elevesAppels.getEleappDate();
         this.inpSerie = "";
         this.inpClasse = this.elevesAppels.getFilieresEducation().getFilId();
         this.inpMatiere = this.elevesAppels.getFilieresMatieres().getFilmatId();
         this.chargerMatieres(var1);
         this.inpProfesseur = this.elevesAppels.getEleappIdProfesseur();
         this.mesProfesseursItems.clear();
         this.selectionMatiere(var1);
         this.afficheListeEleve = true;
         this.listAppels.clear();
         this.listAppels = this.elevesAppelsDao.chargerLesElevesAppels((String)this.elevesAppels.getEleappNum(), (ExercicesVentes)this.elevesAppels.getExercicesVentes(), (Session)null);
         this.datamodelAppels.setWrappedData(this.listAppels);
         this.elevesAppels = new ElevesAppels();
         this.var_action = 3;
         this.var_valide_doc = false;
         this.var_aff_action = true;
         this.utilInitHibernate.closeSession();
      }

   }

   public void chargerMatieres() throws HibernateException, NamingException {
      this.chargerMatieres((Session)null);
   }

   public void chargerMatieres(Session var1) throws HibernateException, NamingException {
      if (this.inpClasse != 0L) {
         this.filieresEducation = this.filieresEducationDao.pourParapheur(this.inpClasse, var1);
         if (this.filieresEducation != null) {
            this.mesMatiereresItems = this.filieresMatieresDao.mesMatieresByFiliereItems(this.filieresEducation, var1);
            this.inpProfesseur = 0L;
            this.mesProfesseursItems.clear();
         } else {
            this.inpMatiere = 0L;
            this.mesMatiereresItems.clear();
            this.inpProfesseur = 0L;
            this.mesProfesseursItems.clear();
         }
      } else {
         this.inpMatiere = 0L;
         this.mesMatiereresItems.clear();
         this.inpProfesseur = 0L;
         this.mesProfesseursItems.clear();
      }

   }

   public void selectionMatiere() throws HibernateException, NamingException {
      this.selectionMatiere((Session)null);
   }

   public void selectionMatiere(Session var1) throws HibernateException, NamingException {
      if (this.inpMatiere != 0L) {
         this.filieresMatieres = this.filieresMatieresDao.pourParapheur(this.inpMatiere, var1);
         if (this.filieresMatieres != null) {
            this.inpMode = this.filieresMatieres.getFilmatMode();
            if (this.filieresMatieres.getFilmatIdProfesseur() != 0L) {
               this.mesProfesseursItems.add(new SelectItem(this.filieresMatieres.getFilmatIdProfesseur(), this.filieresMatieres.getFilmatNomProfesseur()));
            }
         } else {
            this.inpMode = 0;
            this.inpProfesseur = 0L;
            this.mesProfesseursItems.clear();
         }
      } else {
         this.inpMode = 0;
         this.inpProfesseur = 0L;
         this.mesProfesseursItems.clear();
      }

   }

   public void requeteElevesAppels() throws HibernateException, NamingException {
      this.listAppels.clear();
      this.listDocument.clear();
      this.listDocument = this.elevesDao.chargerListEleves(this.rechercherEleves(), this.inpClasse, (Session)null);
      this.listAppels = this.elevesAppelsDao.chargerLesElevesAppels(this.inpDate, this.filieresEducation, this.filieresMatieres, this.exercicesVentes, (Session)null);
      if (this.listDocument.size() != 0) {
         for(int var1 = 0; var1 < this.listDocument.size(); ++var1) {
            this.eleves = (Eleves)this.listDocument.get(var1);
            boolean var2 = false;
            if (this.listAppels.size() != 0) {
               for(int var3 = 0; var3 < this.listAppels.size(); ++var3) {
                  if (this.eleves.getEleId() == ((ElevesAppels)this.listAppels.get(var3)).getEleves().getEleId() && ((ElevesAppels)this.listAppels.get(var3)).getFilieresMatieres().getFilmatId() == this.inpMatiere) {
                     var2 = true;
                     break;
                  }
               }
            }

            if (!var2) {
               this.elevesAppels = new ElevesAppels();
               this.elevesAppels.setEleves(this.eleves);
               this.elevesAppels.setExercicesVentes(this.exercicesVentes);
               this.elevesAppels.setFilieresEducation(this.filieresEducation);
               this.elevesAppels.setFilieresMatieres(this.filieresMatieres);
               this.listAppels.add(this.elevesAppels);
            }
         }
      }

      if (this.listAppels.size() != 0) {
         this.datamodelAppels.setWrappedData(this.listAppels);
         this.afficheListeEleve = true;
         this.var_valide_doc = true;
         this.var_aff_action = false;
      }

   }

   public void annuleApels() {
      this.listAppels.clear();
      this.datamodelAppels.setWrappedData(this.listAppels);
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      this.visibiliteBton = false;
      this.var_action = 0;
   }

   public void saveAppels() throws HibernateException, NamingException {
      if (this.listAppels.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Eleves");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.calculChrono.numCompose(this.inpDate, this.nature, this.inpSerie, var1);
            new Users();
            String var5 = "";
            if (this.inpProfesseur != 0L) {
               Users var4 = this.userDao.selectByIdUsers(this.inpProfesseur, var1);
               if (var4 != null) {
                  var5 = var4.getUsrPatronyme();
               }
            }

            String var6 = this.exercicesVentes.getExevteDateDebut().getYear() + 1900 + "-" + (this.exercicesVentes.getExevteDateFin().getYear() + 1900);

            for(int var7 = 0; var7 < this.listAppels.size(); ++var7) {
               this.elevesAppels = (ElevesAppels)this.listAppels.get(var7);
               this.elevesAppels.setEleappAnnee(var6);
               this.elevesAppels.setEleappDate(this.inpDate);
               this.elevesAppels.setEleappDateValide((Date)null);
               this.elevesAppels.setEleappEtat(0);
               this.elevesAppels.setEleappFiliere(this.filieresEducation.getFilCode());
               this.elevesAppels.setEleappIdProfesseur(this.inpProfesseur);
               this.elevesAppels.setEleappMatiere(this.filieresMatieres.getFilmatCode());
               this.elevesAppels.setEleappNomProfesseur(var5);
               this.elevesAppels.setEleappNum(var3);
               if (this.elevesAppels.getEleappId() == 0L) {
                  this.elevesAppels.setEleappDateCreat(new Date());
                  this.elevesAppels.setEleappIdCreateur(this.usersLog.getUsrid());
                  this.elevesAppels = this.elevesAppelsDao.insert(this.elevesAppels, var1);
               } else {
                  this.elevesAppels.setEleappDateModif(new Date());
                  this.elevesAppels.setEleappIdModif(this.usersLog.getUsrid());
                  this.elevesAppels = this.elevesAppelsDao.modif(this.elevesAppels, var1);
               }
            }

            var2.commit();
         } catch (HibernateException var11) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var11;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.listAppels.clear();
      this.datamodelAppels.setWrappedData(this.listAppels);
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      this.visibiliteBton = false;
      this.var_action = 0;
   }

   public boolean verifieExistenceHabilitationAppels(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         this.elevesAppels.setEleappEtatVal(1);
         this.elevesAppels.setEleappEtat(0);
         this.elevesAppels.setEleappDateValide((Date)null);
         return true;
      } else {
         this.elevesAppels.setEleappEtatVal(0);
         this.chargerUserChrono(var1);
         if (this.usersChrono != null) {
            if (this.usersChrono.getUsrchrValidation() == 0) {
               this.elevesAppels.setEleappEtat(1);
               this.elevesAppels.setEleappDateValide(new Date());
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2 && this.usersChrono.getUsrchrValidation() == 3) {
               this.elevesAppels.setEleappEtat(0);
               this.elevesAppels.setEleappDateValide((Date)null);
            }
         }

         return false;
      }
   }

   public void valideDocumentAppels() throws HibernateException, NamingException {
      if (this.listAppels.size() != 0 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Eleves");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.listAppels.size(); ++var3) {
               this.elevesAppels = (ElevesAppels)this.listAppels.get(var3);
               if (this.elevesAppels.getEleappEtat() == 0) {
                  this.elevesAppels.setEleappEtat(1);
                  this.elevesAppels.setEleappDateValide(new Date());
                  this.elevesAppels = this.elevesAppelsDao.modif(this.elevesAppels, var1);
               }
            }

            Espion var9 = new Espion();
            var9.setUsers(this.usersLog);
            var9.setEsptype(0);
            var9.setEspdtecreat(new Date());
            var9.setEspaction("Validation manuelle appel N° " + this.elevesAppels.getEleappNum() + " du " + this.utilDate.dateToStringSQLLight(this.elevesAppels.getEleappDate()));
            this.espionDao.mAJEspion(var9, var1);
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

   public void deValideDocumentAppels() throws HibernateException, NamingException {
      if (this.listAppels.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Eleves");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.listAppels.size(); ++var3) {
               this.elevesAppels = (ElevesAppels)this.listAppels.get(var3);
               if (this.elevesAppels.getEleappEtat() == 1) {
                  this.elevesAppels.setEleappEtat(0);
                  this.elevesAppels.setEleappDateValide((Date)null);
                  this.elevesAppels = this.elevesAppelsDao.modif(this.elevesAppels, var1);
               }
            }

            Espion var9 = new Espion();
            var9.setUsers(this.usersLog);
            var9.setEsptype(0);
            var9.setEspdtecreat(new Date());
            var9.setEspaction("Dévalidation manuelle appel N° " + this.elevesAppels.getEleappNum() + " du " + this.utilDate.dateToStringSQLLight(this.elevesAppels.getEleappDate()));
            this.espionDao.mAJEspion(var9, var1);
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

   public void supprimerDocumentAppels() throws HibernateException, NamingException {
      if (this.elevesAppels != null) {
         this.elevesAppelsDao.delete(this.elevesAppels);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         var1.setEspaction("Suppression appel N° " + this.elevesAppels.getEleappNum() + " pour " + this.elevesAppels.getEleves().getEleDossier() + " le " + this.dateAnnulation);
         this.espionDao.mAJEspion(var1);
         this.listAppels.remove(this.elevesAppels);
         this.datamodelAppels.setWrappedData(this.listAppels);
      }

      this.visibiliteBton = false;
   }

   public void annulerDocumentAppels() {
      if (this.elevesAppels != null) {
         this.dateAnnulation = new Date();
         this.motifAnnulation = "";
         this.showModalPanelAnnuler = true;
      }

   }

   public void annuleAnnulationAppels() {
      this.showModalPanelAnnuler = false;
   }

   public void miseajourAnnulerAppels() throws HibernateException, NamingException {
      if (this.elevesAppels != null) {
         if (this.dateAnnulation == null) {
            this.dateAnnulation = new Date();
         }

         this.elevesAppels.setEleappEtat(2);
         this.elevesAppels.setEleappDateAnnule(this.dateAnnulation);
         this.elevesAppels.setEleappMotifAnnule(this.motifAnnulation);
         this.elevesAppels = this.elevesAppelsDao.modif(this.elevesAppels);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         var1.setEspaction("Annulation appel N° " + this.elevesAppels.getEleappNum() + " pour " + this.elevesAppels.getEleves().getEleDossier() + " le " + this.dateAnnulation);
         this.espionDao.mAJEspion(var1);
         this.listAppels.remove(this.elevesAppels);
         this.datamodelAppels.setWrappedData(this.listAppels);
      }

      this.showModalPanelAnnuler = false;
      this.visibiliteBton = false;
   }

   public void gestionPresence() throws HibernateException, NamingException {
      if (this.eleves != null) {
         this.chargerMatieresByEleve((Session)null);
         this.choixMatiere = 0;
         this.showModalPanelPresence = true;
      }

   }

   public void fermerGestionPresence() {
      this.showModalPanelPresence = false;
   }

   public void executerRequeteNote() throws NamingException, HibernateException, ParseException, groovyjarjarcommonscli.ParseException {
      this.executerRequeteNote((Session)null);
   }

   public void executerRequeteNote(Session var1) throws NamingException, HibernateException, ParseException, groovyjarjarcommonscli.ParseException {
      this.listNotes.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      this.var_nb_ligne = 0;
      this.listNotes = this.elevesNoteDao.chargerLesElevesNote(this.inpDateDebut, this.inpDateFin, this.inpClasse, this.inpMatiere, this.exercicesVentes, this.inpEtat, this.inpNom, this.inpMatricule, var1);
      if (this.listNotes.size() > 0) {
         this.var_nb_ligne = this.listNotes.size();
      } else {
         this.var_nb_ligne = 0;
      }

      this.datamodelNote.setWrappedData(this.listNotes);
      this.visibiliteBton = false;
   }

   public void selectionLigneNote() throws HibernateException, NamingException, IOException, SQLException {
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
            this.elevesNote = (ElevesNote)var1.get(0);
            this.visibiliteBton = true;
         } else {
            this.visibiliteBton = false;
         }
      } else {
         this.visibiliteBton = false;
      }

   }

   public void visualisationLigneNote() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.datamodelNote.isRowAvailable()) {
         this.elevesNote = (ElevesNote)this.datamodelNote.getRowData();
      }

   }

   public void gestionNote() {
   }

   public void selectionNote() {
      if (this.datamodelNote.isRowAvailable()) {
         this.elevesNote = (ElevesNote)this.datamodelNote.getRowData();
         this.eleves = this.elevesNote.getEleves();
      }

   }

   public void ajouterNote() {
      this.inpDate = new Date();
      this.inpSerie = "";
      this.inpClasse = 0L;
      this.inpMatiere = 0L;
      this.inpType = 0;
      this.inpMode = 0;
      this.inpCoef = 1.0D;
      this.inpMax = 20.0D;
      this.mesMatiereresItems.clear();
      this.inpProfesseur = 0L;
      this.mesProfesseursItems.clear();
      this.afficheListeEleve = false;
      this.listNotes.clear();
      this.datamodelNote.setWrappedData(this.listNotes);
      this.elevesNote = new ElevesNote();
      this.var_action = 1;
      this.var_valide_doc = false;
      this.var_aff_action = false;
   }

   public void modifierNote() throws HibernateException, NamingException {
      if (this.elevesNote != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Eleves");
         this.listDocument.clear();
         this.listDocument = this.elevesDao.chargerListEleves(this.rechercherEleves(), this.elevesNote.getFilieresEducation().getFilId(), var1);
         this.inpDate = this.elevesNote.getElenotDate();
         this.inpSerie = "";
         this.inpClasse = this.elevesNote.getFilieresEducation().getFilId();
         this.inpMatiere = this.elevesNote.getFilieresMatieres().getFilmatId();
         this.inpType = this.elevesNote.getElenotType();
         this.inpMode = this.elevesNote.getElenotMode();
         this.inpCoef = this.elevesNote.getElenotCoef();
         this.inpMax = this.elevesNote.getElenotValMax();
         this.chargerMatieres(var1);
         this.inpProfesseur = this.elevesNote.getElenotIdProfesseur();
         this.mesProfesseursItems.clear();
         this.selectionMatiere(var1);
         this.afficheListeEleve = true;
         this.listNotes.clear();
         this.listNotes = this.elevesNoteDao.chargerLesElevesNote(this.elevesNote.getElenotNum(), this.elevesNote.getExercicesVentes(), var1);
         if (this.listDocument.size() != 0) {
            for(int var2 = 0; var2 < this.listDocument.size(); ++var2) {
               this.eleves = (Eleves)this.listDocument.get(var2);
               boolean var3 = false;
               if (this.listNotes.size() != 0) {
                  for(int var4 = 0; var4 < this.listNotes.size(); ++var4) {
                     if (this.eleves.getEleId() == ((ElevesNote)this.listNotes.get(var4)).getEleves().getEleId() && ((ElevesNote)this.listNotes.get(var4)).getFilieresMatieres().getFilmatId() == this.inpMatiere) {
                        var3 = true;
                        break;
                     }
                  }
               }

               if (!var3) {
                  this.elevesNote = new ElevesNote();
                  this.elevesNote.setEleves(this.eleves);
                  this.elevesNote.setExercicesVentes(this.exercicesVentes);
                  this.elevesNote.setFilieresEducation(this.filieresEducation);
                  this.elevesNote.setFilieresMatieres(this.filieresMatieres);
                  this.listNotes.add(this.elevesNote);
               }
            }
         }

         this.datamodelNote.setWrappedData(this.listNotes);
         this.elevesNote = new ElevesNote();
         this.var_action = 2;
         this.var_valide_doc = true;
         this.var_aff_action = true;
         this.utilInitHibernate.closeSession();
      }

   }

   public void consulterNote() throws HibernateException, NamingException {
      if (this.elevesAppels != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Eleves");
         this.inpDate = this.elevesNote.getElenotDate();
         this.inpSerie = "";
         this.inpClasse = this.elevesNote.getFilieresEducation().getFilId();
         this.inpMatiere = this.elevesNote.getFilieresMatieres().getFilmatId();
         this.inpType = this.elevesNote.getElenotType();
         this.inpMode = this.elevesNote.getElenotMode();
         this.inpCoef = this.elevesNote.getElenotCoef();
         this.inpMax = this.elevesNote.getElenotValMax();
         this.chargerMatieres(var1);
         this.inpProfesseur = this.elevesNote.getElenotIdProfesseur();
         this.mesProfesseursItems.clear();
         this.selectionMatiere(var1);
         this.afficheListeEleve = true;
         this.listNotes.clear();
         this.listNotes = this.elevesNoteDao.chargerLesElevesNote((String)this.elevesAppels.getEleappNum(), (ExercicesVentes)this.elevesAppels.getExercicesVentes(), (Session)null);
         this.datamodelNote.setWrappedData(this.listNotes);
         this.elevesNote = new ElevesNote();
         this.var_action = 3;
         this.var_valide_doc = false;
         this.var_aff_action = true;
         this.utilInitHibernate.closeSession();
      }

   }

   public void requeteElevesNote() throws HibernateException, NamingException {
      this.listNotes.clear();
      this.listDocument.clear();
      this.listDocument = this.elevesDao.chargerListEleves(this.rechercherEleves(), this.inpClasse, (Session)null);
      this.listNotes = this.elevesNoteDao.chargerLesElevesNote(this.inpDate, this.filieresEducation, this.filieresMatieres, this.exercicesVentes, (Session)null);
      if (this.listDocument.size() != 0) {
         for(int var1 = 0; var1 < this.listDocument.size(); ++var1) {
            this.eleves = (Eleves)this.listDocument.get(var1);
            boolean var2 = false;
            if (this.listNotes.size() != 0) {
               for(int var3 = 0; var3 < this.listNotes.size(); ++var3) {
                  if (this.eleves.getEleId() == ((ElevesNote)this.listNotes.get(var3)).getEleves().getEleId() && ((ElevesNote)this.listNotes.get(var3)).getFilieresMatieres().getFilmatId() == this.inpMatiere) {
                     var2 = true;
                     break;
                  }
               }
            }

            if (!var2) {
               this.elevesNote = new ElevesNote();
               this.elevesNote.setEleves(this.eleves);
               this.elevesNote.setExercicesVentes(this.exercicesVentes);
               this.elevesNote.setFilieresEducation(this.filieresEducation);
               this.elevesNote.setFilieresMatieres(this.filieresMatieres);
               this.listNotes.add(this.elevesNote);
            }
         }
      }

      if (this.listNotes.size() != 0) {
         this.datamodelNote.setWrappedData(this.listNotes);
         this.afficheListeEleve = true;
         this.var_valide_doc = true;
         this.var_aff_action = false;
      }

   }

   public void annuleNote() {
      this.listNotes.clear();
      this.datamodelNote.setWrappedData(this.listNotes);
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      this.visibiliteBton = false;
      this.var_action = 0;
   }

   public void saveNote() throws HibernateException, NamingException {
      if (this.listNotes.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Eleves");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.calculChrono.numCompose(this.inpDate, this.nature, this.inpSerie, var1);
            new Users();
            String var5 = "";
            if (this.inpProfesseur != 0L) {
               Users var4 = this.userDao.selectByIdUsers(this.inpProfesseur, var1);
               if (var4 != null) {
                  var5 = var4.getUsrPatronyme();
               }
            }

            String var6 = this.exercicesVentes.getExevteDateDebut().getYear() + 1900 + "-" + (this.exercicesVentes.getExevteDateFin().getYear() + 1900);

            for(int var7 = 0; var7 < this.listNotes.size(); ++var7) {
               this.elevesNote = (ElevesNote)this.listNotes.get(var7);
               this.elevesNote.setElenotAnnee(var6);
               this.elevesNote.setElenotDate(this.inpDate);
               this.elevesNote.setElenotDateValide((Date)null);
               this.elevesNote.setElenotEtat(0);
               this.elevesNote.setElenotFiliere(this.filieresEducation.getFilCode());
               this.elevesNote.setElenotIdProfesseur(this.inpProfesseur);
               this.elevesNote.setElenotMatiere(this.filieresMatieres.getFilmatCode());
               this.elevesNote.setElenotNomProfesseur(var5);
               this.elevesNote.setElenotNum(var3);
               this.elevesNote.setElenotCoef(this.inpCoef);
               this.elevesNote.setElenotMode(this.inpMode);
               this.elevesNote.setElenotType(this.inpType);
               this.elevesNote.setElenotValMax(this.inpMax);
               if (this.elevesNote.getElenotId() == 0L) {
                  this.elevesNote.setElenotDateCreat(new Date());
                  this.elevesNote.setElenotIdCreateur(this.usersLog.getUsrid());
                  this.elevesNote = this.elevesNoteDao.insert(this.elevesNote, var1);
               } else {
                  this.elevesNote.setElenotDateModif(new Date());
                  this.elevesNote.setElenotIdModif(this.usersLog.getUsrid());
                  this.elevesNote = this.elevesNoteDao.modif(this.elevesNote, var1);
               }
            }

            var2.commit();
         } catch (HibernateException var11) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var11;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.listNotes.clear();
      this.datamodelNote.setWrappedData(this.listNotes);
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      this.visibiliteBton = false;
      this.var_action = 0;
   }

   public boolean verifieExistenceHabilitationNote(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         this.elevesNote.setElenotEtatVal(1);
         this.elevesNote.setElenotEtat(0);
         this.elevesNote.setElenotDateValide((Date)null);
         return true;
      } else {
         this.elevesNote.setElenotEtatVal(0);
         this.chargerUserChrono(var1);
         if (this.usersChrono != null) {
            if (this.usersChrono.getUsrchrValidation() == 0) {
               this.elevesNote.setElenotEtat(1);
               this.elevesNote.setElenotDateValide(new Date());
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2 && this.usersChrono.getUsrchrValidation() == 3) {
               this.elevesNote.setElenotEtat(0);
               this.elevesNote.setElenotDateValide((Date)null);
            }
         }

         return false;
      }
   }

   public void valideDocumentNote() throws HibernateException, NamingException {
      if (this.listNotes.size() != 0 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Eleves");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.listNotes.size(); ++var3) {
               this.elevesNote = (ElevesNote)this.listNotes.get(var3);
               if (this.elevesNote.getElenotEtat() == 0) {
                  this.elevesNote.setElenotEtat(1);
                  this.elevesNote.setElenotDateValide(new Date());
                  this.elevesNote = this.elevesNoteDao.modif(this.elevesNote, var1);
               }
            }

            Espion var9 = new Espion();
            var9.setUsers(this.usersLog);
            var9.setEsptype(0);
            var9.setEspdtecreat(new Date());
            var9.setEspaction("Validation manuelle note N° " + this.elevesNote.getElenotNum() + " du " + this.utilDate.dateToStringSQLLight(this.elevesNote.getElenotDate()));
            this.espionDao.mAJEspion(var9, var1);
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

   public void deValideDocumentNote() throws HibernateException, NamingException {
      if (this.listNotes.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Eleves");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.listNotes.size(); ++var3) {
               this.elevesNote = (ElevesNote)this.listNotes.get(var3);
               if (this.elevesNote.getElenotEtat() == 1) {
                  this.elevesNote.setElenotEtat(0);
                  this.elevesNote.setElenotDateValide((Date)null);
                  this.elevesNote = this.elevesNoteDao.modif(this.elevesNote, var1);
               }
            }

            Espion var9 = new Espion();
            var9.setUsers(this.usersLog);
            var9.setEsptype(0);
            var9.setEspdtecreat(new Date());
            var9.setEspaction("Dévalidation manuelle note N° " + this.elevesNote.getElenotNum() + " du " + this.utilDate.dateToStringSQLLight(this.elevesNote.getElenotDate()));
            this.espionDao.mAJEspion(var9, var1);
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

   public void supprimerDocumentNote() throws HibernateException, NamingException {
      if (this.elevesNote != null) {
         this.elevesNoteDao.delete(this.elevesNote);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         var1.setEspaction("Suppression note N° " + this.elevesNote.getElenotNum() + " pour " + this.elevesNote.getEleves().getEleDossier() + " le " + this.dateAnnulation);
         this.espionDao.mAJEspion(var1);
         this.listNotes.remove(this.elevesNote);
         this.datamodelNote.setWrappedData(this.listNotes);
      }

      this.visibiliteBton = false;
   }

   public void annulerDocumentNote() {
      if (this.elevesAppels != null) {
         this.dateAnnulation = new Date();
         this.motifAnnulation = "";
         this.showModalPanelAnnuler = true;
      }

   }

   public void annuleAnnulationNote() {
      this.showModalPanelAnnuler = false;
   }

   public void miseajourAnnulerNote() throws HibernateException, NamingException {
      if (this.elevesNote != null) {
         if (this.dateAnnulation == null) {
            this.dateAnnulation = new Date();
         }

         this.elevesNote.setElenotEtat(2);
         this.elevesNote.setElenotDateAnnule(this.dateAnnulation);
         this.elevesNote.setElenotMotifAnnule(this.motifAnnulation);
         this.elevesNote = this.elevesNoteDao.modif(this.elevesNote);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         var1.setEspaction("Annulation note N° " + this.elevesNote.getElenotNum() + " pour " + this.elevesNote.getEleves().getEleDossier() + " le " + this.dateAnnulation);
         this.espionDao.mAJEspion(var1);
         this.listNotes.remove(this.elevesNote);
         this.datamodelNote.setWrappedData(this.listNotes);
      }

      this.showModalPanelAnnuler = false;
      this.visibiliteBton = false;
   }

   public void gestionNotes() throws HibernateException, NamingException {
      if (this.eleves != null) {
         this.chargerMatieresByEleve((Session)null);
         this.chargerNotesByMatiere();
         this.choixMatiere = 0;
         this.showModalPanelNote = true;
      }

   }

   public void fermerGestionNotes() {
      this.showModalPanelNote = false;
   }

   public void majMoyenneClasse() throws HibernateException, NamingException, ParseException {
      if (this.inpClasse != 0L) {
         this.majMoyenneFiliere(this.inpClasse);
      } else {
         for(int var1 = 0; var1 < this.mesClasseItems.size(); ++var1) {
            long var2 = Long.parseLong(((SelectItem)this.mesClasseItems.get(var1)).getValue().toString());
            this.majMoyenneFiliere(var2);
         }
      }

   }

   public void majMoyenneFiliere(long var1) throws HibernateException, NamingException, ParseException {
      if (var1 != 0L) {
         this.filieresEducation = this.filieresEducationDao.pourParapheur(var1, (Session)null);
         if (this.filieresEducation != null && this.filieresEducation.getFilMoisDebut() != null && !this.filieresEducation.getFilMoisDebut().isEmpty()) {
            Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "Eleves");
            Transaction var4 = null;

            try {
               var4 = var3.beginTransaction();
               new ArrayList();
               List var5 = this.filieresMatieresDao.chargerMatiereByFiliere(this.filieresEducation, var3);
               this.gestionTRancheDate();
               if (this.filieresEducation.getFilnbTrimestre() == 1) {
                  this.majMoyenneTranche(1, this.filieresEducation, var5, this.dDeb1T, this.dFin1T, var3);
               } else if (this.filieresEducation.getFilnbTrimestre() == 2) {
                  this.majMoyenneTranche(1, this.filieresEducation, var5, this.dDeb1T, this.dFin1T, var3);
                  this.majMoyenneTranche(2, this.filieresEducation, var5, this.dDeb2T, this.dFin2T, var3);
               } else if (this.filieresEducation.getFilnbTrimestre() == 3) {
                  this.majMoyenneTranche(1, this.filieresEducation, var5, this.dDeb1T, this.dFin1T, var3);
                  this.majMoyenneTranche(2, this.filieresEducation, var5, this.dDeb2T, this.dFin2T, var3);
                  this.majMoyenneTranche(3, this.filieresEducation, var5, this.dDeb3T, this.dFin3T, var3);
               } else if (this.filieresEducation.getFilnbTrimestre() == 4) {
                  this.majMoyenneTranche(1, this.filieresEducation, var5, this.dDeb1T, this.dFin1T, var3);
                  this.majMoyenneTranche(2, this.filieresEducation, var5, this.dDeb2T, this.dFin2T, var3);
                  this.majMoyenneTranche(3, this.filieresEducation, var5, this.dDeb3T, this.dFin3T, var3);
                  this.majMoyenneTranche(4, this.filieresEducation, var5, this.dDeb4T, this.dFin4T, var3);
               }

               if (this.filieresEducation.getFilnbTrimestre() == 1) {
                  this.majAppelTranche(1, this.filieresEducation, var5, this.dDeb1T, this.dFin1T, var3);
               } else if (this.filieresEducation.getFilnbTrimestre() == 2) {
                  this.majAppelTranche(1, this.filieresEducation, var5, this.dDeb1T, this.dFin1T, var3);
                  this.majAppelTranche(2, this.filieresEducation, var5, this.dDeb2T, this.dFin2T, var3);
               } else if (this.filieresEducation.getFilnbTrimestre() == 3) {
                  this.majAppelTranche(1, this.filieresEducation, var5, this.dDeb1T, this.dFin1T, var3);
                  this.majAppelTranche(2, this.filieresEducation, var5, this.dDeb2T, this.dFin2T, var3);
                  this.majAppelTranche(3, this.filieresEducation, var5, this.dDeb3T, this.dFin3T, var3);
               } else if (this.filieresEducation.getFilnbTrimestre() == 4) {
                  this.majAppelTranche(1, this.filieresEducation, var5, this.dDeb1T, this.dFin1T, var3);
                  this.majAppelTranche(2, this.filieresEducation, var5, this.dDeb2T, this.dFin2T, var3);
                  this.majAppelTranche(3, this.filieresEducation, var5, this.dDeb3T, this.dFin3T, var3);
                  this.majAppelTranche(4, this.filieresEducation, var5, this.dDeb4T, this.dFin4T, var3);
               }

               if (this.filieresEducation.getFilnbTrimestre() == 1) {
                  this.majViolencesTranche(1, this.filieresEducation, var5, this.dDeb1T, this.dFin1T, var3);
               } else if (this.filieresEducation.getFilnbTrimestre() == 2) {
                  this.majViolencesTranche(1, this.filieresEducation, var5, this.dDeb1T, this.dFin1T, var3);
                  this.majViolencesTranche(2, this.filieresEducation, var5, this.dDeb2T, this.dFin2T, var3);
               } else if (this.filieresEducation.getFilnbTrimestre() == 3) {
                  this.majViolencesTranche(1, this.filieresEducation, var5, this.dDeb1T, this.dFin1T, var3);
                  this.majViolencesTranche(2, this.filieresEducation, var5, this.dDeb2T, this.dFin2T, var3);
                  this.majViolencesTranche(3, this.filieresEducation, var5, this.dDeb3T, this.dFin3T, var3);
               } else if (this.filieresEducation.getFilnbTrimestre() == 4) {
                  this.majViolencesTranche(1, this.filieresEducation, var5, this.dDeb1T, this.dFin1T, var3);
                  this.majViolencesTranche(2, this.filieresEducation, var5, this.dDeb2T, this.dFin2T, var3);
                  this.majViolencesTranche(3, this.filieresEducation, var5, this.dDeb3T, this.dFin3T, var3);
                  this.majViolencesTranche(4, this.filieresEducation, var5, this.dDeb4T, this.dFin4T, var3);
               }

               var4.commit();
            } catch (HibernateException var9) {
               if (var4 != null) {
                  var4.rollback();
               }

               throw var9;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }
      }

   }

   public void gestionTRancheDate() throws ParseException {
      Date var1 = this.utilDate.stringToDateSQLLight(this.exercicesVentes.getExevteDateDebut().getYear() + 1900 + "-" + this.filieresEducation.getFilMoisDebut() + "-" + "01");
      this.dDeb1T = null;
      this.dFin1T = null;
      this.dDeb2T = null;
      this.dFin2T = null;
      this.dDeb3T = null;
      this.dFin3T = null;
      this.dDeb4T = null;
      this.dFin4T = null;
      if (this.filieresEducation.getFilnbTrimestre() == 1) {
         this.dDeb1T = var1;
         this.dFin1T = this.utilDate.dateJourPrecedent(this.utilDate.datedevaleurMois(var1, 3));
      } else if (this.filieresEducation.getFilnbTrimestre() == 2) {
         this.dDeb1T = var1;
         this.dFin1T = this.utilDate.dateJourPrecedent(this.utilDate.datedevaleurMois(var1, 3));
         this.dDeb2T = this.utilDate.datedevaleurMois(var1, 3);
         this.dFin2T = this.utilDate.dateJourPrecedent(this.utilDate.datedevaleurMois(this.dDeb2T, 3));
      } else if (this.filieresEducation.getFilnbTrimestre() == 3) {
         this.dDeb1T = var1;
         this.dFin1T = this.utilDate.dateJourPrecedent(this.utilDate.datedevaleurMois(var1, 3));
         this.dDeb2T = this.utilDate.datedevaleurMois(var1, 3);
         this.dFin2T = this.utilDate.dateJourPrecedent(this.utilDate.datedevaleurMois(this.dDeb2T, 3));
         this.dDeb3T = this.utilDate.datedevaleurMois(this.dDeb2T, 3);
         this.dFin3T = this.utilDate.dateJourPrecedent(this.utilDate.datedevaleurMois(this.dDeb3T, 3));
      } else if (this.filieresEducation.getFilnbTrimestre() == 4) {
         this.dDeb1T = var1;
         this.dFin1T = this.utilDate.dateJourPrecedent(this.utilDate.datedevaleurMois(var1, 3));
         this.dDeb2T = this.utilDate.datedevaleurMois(var1, 3);
         this.dFin2T = this.utilDate.dateJourPrecedent(this.utilDate.datedevaleurMois(this.dDeb2T, 3));
         this.dDeb3T = this.utilDate.datedevaleurMois(this.dDeb2T, 3);
         this.dFin3T = this.utilDate.dateJourPrecedent(this.utilDate.datedevaleurMois(this.dDeb3T, 3));
         this.dDeb4T = this.utilDate.datedevaleurMois(this.dDeb3T, 3);
         this.dFin4T = this.utilDate.dateJourPrecedent(this.utilDate.datedevaleurMois(this.dDeb4T, 3));
      }

   }

   public void majMoyenneTranche(int var1, FilieresEducation var2, List var3, Date var4, Date var5, Session var6) throws HibernateException, NamingException {
      if (var2 != null && var3.size() != 0) {
         int var7 = 0;
         new ArrayList();
         String var9 = this.exercicesVentes.getExevteDateDebut().getYear() + 1900 + "-" + (this.exercicesVentes.getExevteDateFin().getYear() + 1900);
         List var8 = this.elevesInscriptionDao.chargerLesElevesInscription(var2, var9, var6);
         if (var8.size() != 0) {
            var7 = var8.size();
         }

         new ArrayList();

         for(int var11 = 0; var11 < var3.size(); ++var11) {
            int var12 = 0;
            float var13 = 0.0F;
            this.filieresMatieres = this.filieresMatieresDao.pourParapheur(((FilieresMatieres)var3.get(var11)).getFilmatId(), var6);
            if (this.filieresMatieres != null) {
               List var10 = this.elevesNoteDao.chargerLesElevesNote(var4, var5, var2.getFilId(), this.filieresMatieres.getFilmatId(), this.exercicesVentes, 100, (String)null, (String)null, var6);
               int var14;
               if (var10.size() != 0) {
                  for(var14 = 0; var14 < var10.size(); ++var14) {
                     if (((ElevesNote)var10.get(var14)).getElenotMode() == 1 && ((ElevesNote)var10.get(var14)).getElenotExcluMoy() == 0) {
                        ++var12;
                        var13 = (float)((double)var13 + ((ElevesNote)var10.get(var14)).getElenotValNote());
                     }
                  }
               }

               var14 = 0;
               if (var1 == 1 && var12 != 0) {
                  this.filieresMatieres.setFilmatMoy1T(var13 / (float)var12);
                  if (this.filieresMatieres.getFilmatMoy1T() != 0.0F) {
                     this.filieresMatieres.setFilmatNbEle1T(var7);
                     ++var14;
                  }
               } else if (var1 == 2 && var12 != 0) {
                  this.filieresMatieres.setFilmatMoy2T(var13 / (float)var12);
                  if (this.filieresMatieres.getFilmatMoy2T() != 0.0F) {
                     this.filieresMatieres.setFilmatNbEle2T(var7);
                     ++var14;
                  }
               } else if (var1 == 3 && var12 != 0) {
                  this.filieresMatieres.setFilmatMoy3T(var13 / (float)var12);
                  if (this.filieresMatieres.getFilmatMoy3T() != 0.0F) {
                     this.filieresMatieres.setFilmatNbEle3T(var7);
                     ++var14;
                  }
               } else if (var1 == 4 && var12 != 0) {
                  this.filieresMatieres.setFilmatMoy4T(var13 / (float)var12);
                  if (this.filieresMatieres.getFilmatMoy4T() != 0.0F) {
                     this.filieresMatieres.setFilmatNbEle4T(var7);
                     ++var14;
                  }
               }

               if (var14 != 0) {
                  this.filieresMatieres.setFilmatMoyG((this.filieresMatieres.getFilmatMoy1T() + this.filieresMatieres.getFilmatMoy2T() + this.filieresMatieres.getFilmatMoy3T() + this.filieresMatieres.getFilmatMoy4T()) / (float)var14);
               }

               this.filieresMatieres.setFilmatNbEleG(var7);
               this.filieresMatieres = this.filieresMatieresDao.modif(this.filieresMatieres, var6);
               var6.flush();
            }
         }
      }

   }

   public void majAppelTranche(int var1, FilieresEducation var2, List var3, Date var4, Date var5, Session var6) throws HibernateException, NamingException {
      if (var2 != null && var3.size() != 0) {
         new ArrayList();

         for(int var8 = 0; var8 < var3.size(); ++var8) {
            int var9 = 0;
            int var10 = 0;
            int var11 = 0;
            int var12 = 0;
            int var13 = 0;
            this.filieresMatieres = this.filieresMatieresDao.pourParapheur(((FilieresMatieres)var3.get(var8)).getFilmatId(), var6);
            if (this.filieresMatieres != null) {
               List var7 = this.elevesAppelsDao.chargerLesElevesAppels(var4, var5, var2.getFilId(), this.filieresMatieres.getFilmatId(), this.exercicesVentes, 100, (String)null, (String)null, var6);
               if (var7.size() != 0) {
                  for(int var14 = 0; var14 < var7.size(); ++var14) {
                     if (((ElevesAppels)var7.get(var14)).getEleappType() == 2) {
                        ++var12;
                     } else if (((ElevesAppels)var7.get(var14)).getEleappType() == 3) {
                        ++var13;
                     } else if (((ElevesAppels)var7.get(var14)).getEleappType() == 4) {
                        ++var9;
                     } else if (((ElevesAppels)var7.get(var14)).getEleappType() == 5) {
                        ++var10;
                     } else if (((ElevesAppels)var7.get(var14)).getEleappType() == 6) {
                        ++var11;
                     }
                  }
               }

               if (var1 == 1) {
                  this.filieresMatieres.setFilmatNbAbsJ1T((float)var9);
                  this.filieresMatieres.setFilmatNbAbsNJ1T((float)var10);
                  this.filieresMatieres.setFilmatNbAbsEX1T((float)var11);
                  this.filieresMatieres.setFilmatNbRetJ1T((float)var12);
                  this.filieresMatieres.setFilmatNbRetNJ1T((float)var13);
               } else if (var1 == 2) {
                  this.filieresMatieres.setFilmatNbAbsJ2T((float)var9);
                  this.filieresMatieres.setFilmatNbAbsNJ2T((float)var10);
                  this.filieresMatieres.setFilmatNbAbsEX2T((float)var11);
                  this.filieresMatieres.setFilmatNbRetJ2T((float)var12);
                  this.filieresMatieres.setFilmatNbRetNJ2T((float)var13);
               } else if (var1 == 3) {
                  this.filieresMatieres.setFilmatNbAbsJ3T((float)var9);
                  this.filieresMatieres.setFilmatNbAbsNJ3T((float)var10);
                  this.filieresMatieres.setFilmatNbAbsEX3T((float)var11);
                  this.filieresMatieres.setFilmatNbRetJ3T((float)var12);
                  this.filieresMatieres.setFilmatNbRetNJ3T((float)var13);
               } else if (var1 == 4) {
                  this.filieresMatieres.setFilmatNbAbsJ4T((float)var9);
                  this.filieresMatieres.setFilmatNbAbsNJ4T((float)var10);
                  this.filieresMatieres.setFilmatNbAbsEX4T((float)var11);
                  this.filieresMatieres.setFilmatNbRetJ1T((float)var12);
                  this.filieresMatieres.setFilmatNbRetNJ4T((float)var13);
               }

               this.filieresMatieres = this.filieresMatieresDao.modif(this.filieresMatieres, var6);
               var6.flush();
            }
         }
      }

   }

   public void majViolencesTranche(int var1, FilieresEducation var2, List var3, Date var4, Date var5, Session var6) throws HibernateException, NamingException {
      if (var2 != null && var3.size() != 0) {
         new ArrayList();
         int var8 = 0;
         int var9 = 0;
         List var7 = this.elevesViolencesDao.chargerLesElevesViolences(var4, var5, var2.getFilId(), 0L, this.exercicesVentes, 100, (String)null, (String)null, var6);
         if (var7.size() != 0) {
            for(int var10 = 0; var10 < var7.size(); ++var10) {
               if (((ElevesViolences)var7.get(var10)).getElevioTypeSubi() != 0) {
                  ++var8;
               }

               if (((ElevesViolences)var7.get(var10)).getElevioTypeCause() != 0) {
                  ++var9;
               }
            }
         }

         if (var1 == 1) {
            this.filieresMatieres.setFilmatNbViolSubi1T(var8);
            this.filieresMatieres.setFilmatNbViolCause1T(var9);
         } else if (var1 == 2) {
            this.filieresMatieres.setFilmatNbViolSubi2T(var8);
            this.filieresMatieres.setFilmatNbViolCause2T(var9);
         } else if (var1 == 3) {
            this.filieresMatieres.setFilmatNbViolSubi3T(var8);
            this.filieresMatieres.setFilmatNbViolCause3T(var9);
         } else if (var1 == 4) {
            this.filieresMatieres.setFilmatNbViolSubi4T(var8);
            this.filieresMatieres.setFilmatNbViolCause4T(var9);
         }

         this.filieresMatieres = this.filieresMatieresDao.modif(this.filieresMatieres, var6);
         var6.flush();
      }

   }

   public void executerRequeteViolences() throws NamingException, HibernateException, ParseException, groovyjarjarcommonscli.ParseException {
      this.executerRequeteAppels((Session)null);
   }

   public void executerRequeteViolences(Session var1) throws NamingException, HibernateException, ParseException, groovyjarjarcommonscli.ParseException {
      this.listViolences.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      this.var_nb_ligne = 0;
      this.listViolences = this.elevesViolencesDao.chargerLesElevesViolences(this.inpDateDebut, this.inpDateFin, this.inpClasse, this.inpMatiere, this.exercicesVentes, this.inpEtat, this.inpNom, this.inpMatricule, var1);
      if (this.listViolences.size() > 0) {
         this.var_nb_ligne = this.listViolences.size();
      } else {
         this.var_nb_ligne = 0;
      }

      this.datamodelViolences.setWrappedData(this.listViolences);
      this.visibiliteBton = false;
   }

   public void selectionLigneViolences() throws HibernateException, NamingException, IOException, SQLException {
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
            this.elevesViolences = (ElevesViolences)var1.get(0);
            this.visibiliteBton = true;
         } else {
            this.visibiliteBton = false;
         }
      } else {
         this.visibiliteBton = false;
      }

   }

   public void visualisationLigneViolences() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.datamodelViolences.isRowAvailable()) {
         this.elevesViolences = (ElevesViolences)this.datamodelViolences.getRowData();
      }

   }

   public void gestionViolences() throws HibernateException, NamingException {
      if (this.eleves != null) {
         this.chargerMatieresByEleve((Session)null);
         this.choixMatiere = 0;
         this.showModalPanelViolences = true;
      }

   }

   public void selectionViolences() {
      if (this.datamodelViolences.isRowAvailable()) {
         this.elevesViolences = (ElevesViolences)this.datamodelViolences.getRowData();
         this.eleves = this.elevesViolences.getEleves();
      }

   }

   public void ajouterViolences() {
   }

   public void modifierViolences() throws HibernateException, NamingException {
   }

   public void consulterViolences() throws HibernateException, NamingException {
   }

   public void requeteElevesViolences() throws HibernateException, NamingException {
      this.listViolences.clear();
      this.listDocument.clear();
      this.listDocument = this.elevesDao.chargerListEleves(this.rechercherEleves(), this.inpClasse, (Session)null);
      this.listViolences = this.elevesViolencesDao.chargerLesElevesViolences(this.inpDate, this.filieresEducation, this.filieresMatieres, this.exercicesVentes, (Session)null);
      if (this.listDocument.size() != 0) {
         for(int var1 = 0; var1 < this.listDocument.size(); ++var1) {
            this.eleves = (Eleves)this.listDocument.get(var1);
            boolean var2 = false;
            if (this.listAppels.size() != 0) {
               for(int var3 = 0; var3 < this.listViolences.size(); ++var3) {
                  if (this.eleves.getEleId() == ((ElevesViolences)this.listViolences.get(var3)).getEleves().getEleId() && ((ElevesViolences)this.listViolences.get(var3)).getFilieresMatieres().getFilmatId() == this.inpMatiere) {
                     var2 = true;
                     break;
                  }
               }
            }

            if (!var2) {
               this.elevesViolences = new ElevesViolences();
               this.elevesViolences.setEleves(this.eleves);
               this.elevesViolences.setExercicesVentes(this.exercicesVentes);
               this.elevesViolences.setFilieresEducation(this.filieresEducation);
               this.elevesViolences.setFilieresMatieres(this.filieresMatieres);
               this.listViolences.add(this.elevesViolences);
            }
         }
      }

      if (this.listViolences.size() != 0) {
         this.datamodelViolences.setWrappedData(this.listViolences);
         this.afficheListeEleve = true;
         this.var_valide_doc = true;
         this.var_aff_action = false;
      }

   }

   public void annuleViolences() {
      this.listViolences.clear();
      this.datamodelViolences.setWrappedData(this.listViolences);
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      this.visibiliteBton = false;
      this.var_action = 0;
   }

   public void saveViolences() throws HibernateException, NamingException {
   }

   public boolean verifieExistenceHabilitationViolences(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         this.elevesViolences.setElevioEtatVal(1);
         this.elevesViolences.setElevioEtat(0);
         this.elevesViolences.setElevioDateValide((Date)null);
         return true;
      } else {
         this.elevesViolences.setElevioEtatVal(0);
         this.chargerUserChrono(var1);
         if (this.usersChrono != null) {
            if (this.usersChrono.getUsrchrValidation() == 0) {
               this.elevesViolences.setElevioEtat(1);
               this.elevesViolences.setElevioDateValide(new Date());
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2 && this.usersChrono.getUsrchrValidation() == 3) {
               this.elevesViolences.setElevioEtat(0);
               this.elevesViolences.setElevioDateValide((Date)null);
            }
         }

         return false;
      }
   }

   public void valideDocumentViolences() throws HibernateException, NamingException {
      if (this.listViolences.size() != 0 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Eleves");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.listViolences.size(); ++var3) {
               this.elevesViolences = (ElevesViolences)this.listViolences.get(var3);
               if (this.elevesViolences.getElevioEtat() == 0) {
                  this.elevesViolences.setElevioEtat(1);
                  this.elevesViolences.setElevioDateValide(new Date());
                  this.elevesViolences = this.elevesViolencesDao.modif(this.elevesViolences, var1);
               }
            }

            Espion var9 = new Espion();
            var9.setUsers(this.usersLog);
            var9.setEsptype(0);
            var9.setEspdtecreat(new Date());
            var9.setEspaction("Validation manuelle violence N° " + this.elevesViolences.getElevioNum() + " du " + this.utilDate.dateToStringSQLLight(this.elevesViolences.getElevioDate()));
            this.espionDao.mAJEspion(var9, var1);
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

   public void deValideDocumentViolences() throws HibernateException, NamingException {
      if (this.listViolences.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Eleves");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.listViolences.size(); ++var3) {
               this.elevesViolences = (ElevesViolences)this.listViolences.get(var3);
               if (this.elevesViolences.getElevioEtat() == 1) {
                  this.elevesViolences.setElevioEtat(0);
                  this.elevesViolences.setElevioDateValide((Date)null);
                  this.elevesViolences = this.elevesViolencesDao.modif(this.elevesViolences, var1);
               }
            }

            Espion var9 = new Espion();
            var9.setUsers(this.usersLog);
            var9.setEsptype(0);
            var9.setEspdtecreat(new Date());
            var9.setEspaction("Dévalidation manuelle violence N° " + this.elevesViolences.getElevioNum() + " du " + this.utilDate.dateToStringSQLLight(this.elevesViolences.getElevioDate()));
            this.espionDao.mAJEspion(var9, var1);
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

   public void supprimerDocumentViolences() throws HibernateException, NamingException {
      if (this.elevesViolences != null) {
         this.elevesViolencesDao.delete(this.elevesViolences);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         var1.setEspaction("Suppression violence N° " + this.elevesViolences.getElevioNum() + " pour " + this.elevesViolences.getEleves().getEleDossier() + " le " + this.dateAnnulation);
         this.espionDao.mAJEspion(var1);
         this.listViolences.remove(this.elevesViolences);
         this.datamodelViolences.setWrappedData(this.listViolences);
      }

      this.visibiliteBton = false;
   }

   public void annulerDocumentViolences() {
      if (this.elevesViolences != null) {
         this.dateAnnulation = new Date();
         this.motifAnnulation = "";
         this.showModalPanelAnnuler = true;
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
      String var1 = "";
      this.listeImpressionItems = new ArrayList();
      this.documentImpressionItems = new ArrayList();
      if (this.showModalPanelNote) {
         var1 = "bulletin";
         this.natureGestionEleve = 104;
      } else if (this.showModalPanelPresence) {
         var1 = "appel";
         this.natureGestionEleve = 103;
      } else if (this.showModalPanelViolences) {
         var1 = "violence";
         this.natureGestionEleve = 105;
      } else {
         this.natureGestionEleve = 0;
      }

      if (var1 != null && !var1.isEmpty()) {
         String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator + "liste" + File.separator + var1;
         File var3 = new File(var2);
         if (!var3.exists()) {
            var3.mkdir();
         }

         String[] var4 = var3.list();
         int var5;
         String var6;
         int var7;
         if (var4 != null) {
            var4 = this.triAlphabetique(var4, var4.length);

            for(var5 = 0; var5 < var4.length; ++var5) {
               var6 = var4[var5];
               if (var6.endsWith("jasper")) {
                  var7 = var6.indexOf(".");
                  var6 = var6.substring(0, var7);
                  this.listeImpressionItems.add(new SelectItem(var6));
               }
            }
         }

         var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator + "document" + File.separator + var1;
         var3 = new File(var2);
         if (!var3.exists()) {
            var3.mkdir();
         }

         var4 = var3.list();
         if (var4 != null) {
            var4 = this.triAlphabetique(var4, var4.length);

            for(var5 = 0; var5 < var4.length; ++var5) {
               var6 = var4[var5];
               if (var6.endsWith("jasper")) {
                  var7 = var6.indexOf(".");
                  var6 = var6.substring(0, var7);
                  this.documentImpressionItems.add(new SelectItem(var6));
               }
            }
         }
      }

   }

   public String calculeCheminRapport(String var1) {
      String var2 = "";
      if (this.nature == 100 && this.natureGestionEleve == 0) {
         var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator + "document" + File.separator + "eleve" + File.separator;
      } else if (this.nature != 101 && this.natureGestionEleve != 101) {
         if (this.nature != 103 && this.natureGestionEleve != 103) {
            if (this.nature != 104 && this.natureGestionEleve != 104) {
               if (this.nature == 105 || this.natureGestionEleve == 105) {
                  var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator + "document" + File.separator + "violence" + File.separator;
               }
            } else {
               var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator + "document" + File.separator + "bulletin" + File.separator;
            }
         } else {
            var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator + "document" + File.separator + "appel" + File.separator;
         }
      } else {
         var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator + "document" + File.separator + "mediatheque" + File.separator;
      }

      return var2;
   }

   public String calculeCheminSousRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator + "sous_rapport" + File.separator;
      return var2;
   }

   public String calculeImageFond(String var1) throws HibernateException, NamingException {
      String var2 = "";
      File var3 = new File(this.calculeCheminSousRapport(var1) + "formatDocumentMediatheque.jpg");
      if (var3.exists()) {
         var2 = "formatDocumentMediatheque.jpg";
      }

      return var2;
   }

   public JRBeanCollectionDataSource calculeImpressionCommun(int var1) throws IOException, HibernateException, NamingException, ParseException {
      JRBeanCollectionDataSource var2 = null;
      if (this.nature == 100 && this.natureGestionEleve == 0) {
         ArrayList var9 = new ArrayList();
         if (this.eleves != null) {
            var9.add(this.eleves);
         }

         var2 = new JRBeanCollectionDataSource(var9);
      } else if (this.nature != 101 && this.nature != 103 && this.natureGestionEleve != 103) {
         if (this.nature != 104 && this.natureGestionEleve != 104) {
            if (this.nature != 105 && this.natureGestionEleve == 105) {
            }
         } else {
            Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "Eleves");
            Object var4 = new ArrayList();
            new ArrayList();
            new ArrayList();
            new ArrayList();
            if (this.eleves != null && this.filieresEducation != null) {
               new ArrayList();
               List var8 = this.filieresMatieresDao.chargerMatiereByFiliere(this.filieresEducation, var3);
               this.gestionTRancheDate();
               List var5;
               List var6;
               List var7;
               if (var1 == 1) {
                  var5 = this.elevesNoteDao.chargerLesElevesNote(this.dDeb1T, this.dFin1T, 0L, 0L, this.exercicesVentes, 100, (String)null, this.eleves.getEleDossier(), var3);
                  var6 = this.elevesAppelsDao.chargerLesElevesAppels(this.dDeb1T, this.dFin1T, 0L, 0L, this.exercicesVentes, 100, (String)null, this.eleves.getEleDossier(), var3);
                  var7 = this.elevesViolencesDao.chargerLesElevesViolences(this.dDeb1T, this.dFin1T, 0L, 0L, this.exercicesVentes, 100, (String)null, this.eleves.getEleDossier(), var3);
                  var4 = this.calculeMoyenneEleve(1, this.filieresEducation, var5, var8, var6, var7, (List)var4, var3);
               } else if (var1 == 2) {
                  var5 = this.elevesNoteDao.chargerLesElevesNote(this.dDeb2T, this.dFin2T, 0L, 0L, this.exercicesVentes, 100, (String)null, this.eleves.getEleDossier(), var3);
                  var6 = this.elevesAppelsDao.chargerLesElevesAppels(this.dDeb2T, this.dFin2T, 0L, 0L, this.exercicesVentes, 100, (String)null, this.eleves.getEleDossier(), var3);
                  var7 = this.elevesViolencesDao.chargerLesElevesViolences(this.dDeb2T, this.dFin2T, 0L, 0L, this.exercicesVentes, 100, (String)null, this.eleves.getEleDossier(), var3);
                  var4 = this.calculeMoyenneEleve(2, this.filieresEducation, var5, var8, var6, var7, (List)var4, var3);
               } else if (var1 == 3) {
                  var5 = this.elevesNoteDao.chargerLesElevesNote(this.dDeb3T, this.dFin3T, 0L, 0L, this.exercicesVentes, 100, (String)null, this.eleves.getEleDossier(), var3);
                  var6 = this.elevesAppelsDao.chargerLesElevesAppels(this.dDeb3T, this.dFin3T, 0L, 0L, this.exercicesVentes, 100, (String)null, this.eleves.getEleDossier(), var3);
                  var7 = this.elevesViolencesDao.chargerLesElevesViolences(this.dDeb3T, this.dFin3T, 0L, 0L, this.exercicesVentes, 100, (String)null, this.eleves.getEleDossier(), var3);
                  var4 = this.calculeMoyenneEleve(3, this.filieresEducation, var5, var8, var6, var7, (List)var4, var3);
               } else if (var1 == 4) {
                  var5 = this.elevesNoteDao.chargerLesElevesNote(this.dDeb4T, this.dFin4T, 0L, 0L, this.exercicesVentes, 100, (String)null, this.eleves.getEleDossier(), var3);
                  var6 = this.elevesAppelsDao.chargerLesElevesAppels(this.dDeb4T, this.dFin4T, 0L, 0L, this.exercicesVentes, 100, (String)null, this.eleves.getEleDossier(), var3);
                  var7 = this.elevesViolencesDao.chargerLesElevesViolences(this.dDeb4T, this.dFin4T, 0L, 0L, this.exercicesVentes, 100, (String)null, this.eleves.getEleDossier(), var3);
                  var4 = this.calculeMoyenneEleve(4, this.filieresEducation, var5, var8, var6, var7, (List)var4, var3);
               } else if (var1 == 0) {
                  var5 = this.elevesNoteDao.chargerLesElevesNote(this.dDeb1T, this.dFin4T, 0L, 0L, this.exercicesVentes, 100, (String)null, this.eleves.getEleDossier(), var3);
                  var6 = this.elevesAppelsDao.chargerLesElevesAppels(this.dDeb1T, this.dFin4T, 0L, 0L, this.exercicesVentes, 100, (String)null, this.eleves.getEleDossier(), var3);
                  var7 = this.elevesViolencesDao.chargerLesElevesViolences(this.dDeb1T, this.dFin4T, 0L, 0L, this.exercicesVentes, 100, (String)null, this.eleves.getEleDossier(), var3);
                  var4 = this.calculeMoyenneEleve(0, this.filieresEducation, var5, var8, var6, var7, (List)var4, var3);
               }
            }

            var2 = new JRBeanCollectionDataSource((Collection)var4);
            this.utilInitHibernate.closeSession();
         }
      }

      return var2;
   }

   public List calculeMoyenneEleve(int var1, FilieresEducation var2, List var3, List var4, List var5, List var6, List var7, Session var8) {
      if (var4.size() != 0 && var3.size() != 0) {
         new DocumentEducation();
         this.filieresMatieres = new FilieresMatieres();

         for(int var10 = 0; var10 < var4.size(); ++var10) {
            this.filieresMatieres = (FilieresMatieres)var4.get(var10);
            double var11 = 0.0D;
            int var13 = 0;
            double var14 = 0.0D;
            double var16 = 0.0D;
            int var18 = 0;
            int var19 = 0;

            for(int var20 = 0; var20 < var3.size(); ++var20) {
               this.elevesNote = (ElevesNote)var3.get(var20);
               if (this.elevesNote.getElenotMode() == 1 && this.elevesNote.getElenotExcluMoy() == 0 && this.elevesNote.getElenotMatiere() != null && !this.elevesNote.getElenotMatiere().isEmpty() && this.filieresMatieres.getFilmatCode() != null && !this.filieresMatieres.getFilmatCode().isEmpty() && this.filieresMatieres.getFilmatCode().equals(this.elevesNote.getElenotMatiere())) {
                  ++var13;
                  var11 += this.elevesNote.getElenotValNote();
                  var14 = this.elevesNote.getElenotCoef();
                  var16 = this.elevesNote.getElenotPoidsNote();
                  var18 = this.elevesNote.getElenotType();
                  var19 = this.elevesNote.getElenotMode();
               }
            }

            float var28 = 0.0F;
            float var21 = 0.0F;
            float var22 = 0.0F;
            float var23 = 0.0F;
            float var24 = 0.0F;

            int var25;
            for(var25 = 0; var25 < var5.size(); ++var25) {
               this.elevesAppels = (ElevesAppels)var5.get(var25);
               if (this.elevesAppels.getEleappType() != 0 && this.elevesAppels.getEleappMatiere() != null && !this.elevesAppels.getEleappMatiere().isEmpty() && this.filieresMatieres.getFilmatCode() != null && !this.filieresMatieres.getFilmatCode().isEmpty() && this.filieresMatieres.getFilmatCode().equals(this.elevesAppels.getEleappMatiere())) {
                  if (this.elevesAppels.getEleappType() == 6) {
                     ++var28;
                  } else if (this.elevesAppels.getEleappType() == 4) {
                     ++var21;
                  } else if (this.elevesAppels.getEleappType() == 5) {
                     ++var22;
                  } else if (this.elevesAppels.getEleappType() == 2) {
                     ++var23;
                  } else if (this.elevesAppels.getEleappType() == 3) {
                     ++var24;
                  }
               }
            }

            var25 = 0;
            int var26 = 0;

            for(int var27 = 0; var27 < var6.size(); ++var27) {
               this.elevesViolences = (ElevesViolences)var6.get(var27);
               if (this.elevesViolences.getElevioTypeSubi() != 0 && this.elevesViolences.getElevioMatiere() != null && !this.elevesViolences.getElevioMatiere().isEmpty() && this.filieresMatieres.getFilmatCode() != null && !this.filieresMatieres.getFilmatCode().isEmpty() && this.filieresMatieres.getFilmatCode().equals(this.elevesViolences.getElevioMatiere())) {
                  ++var25;
               }

               if (this.elevesViolences.getElevioTypeCause() != 0 && this.elevesViolences.getElevioMatiere() != null && !this.elevesViolences.getElevioMatiere().isEmpty() && this.filieresMatieres.getFilmatCode() != null && !this.filieresMatieres.getFilmatCode().isEmpty() && this.filieresMatieres.getFilmatCode().equals(this.elevesViolences.getElevioMatiere())) {
                  ++var26;
               }
            }

            DocumentEducation var9 = new DocumentEducation();
            var9.setDocAnnee(this.exercicesVentes.getExevteDateDebut().getYear() + 1900 + "-" + (this.exercicesVentes.getExevteDateFin().getYear() + 1900));
            var9.setDocDossier(this.eleves.getEleDossier());
            var9.setDocNomEleve(this.eleves.getEleNom());
            var9.setDocPrenomEleve(this.eleves.getElePrenom());
            var9.setDocCiviliteEleve(this.eleves.getEleCivilite());
            var9.setDocCodeFiliere(var2.getFilCode());
            var9.setDocCodeMatiere(this.filieresMatieres.getFilmatCode());
            var9.setDocCoefNote((float)var14);
            var9.setDocLibFiliere(var2.getFilLibelle());
            var9.setDocLibMatiere(this.filieresMatieres.getFilmatLibelle());
            var9.setDocModeNote(var19);
            var9.setDocNomProfesseur(this.filieresMatieres.getFilmatNomProfesseur());
            var9.setDocPoidsNote(var16);
            var9.setDocTypeNote(var18);
            var9.setDocValNote(var11);
            var9.setDocNbNote(var13);
            if (var13 != 0) {
               var9.setDocMoyNote(var11 / (double)var13);
            } else {
               var9.setDocMoyNote(0.0D);
            }

            var9.setDocNbAbsEX((double)var28);
            var9.setDocNbAbsJ((double)var21);
            var9.setDocNbAbsNJ((double)var22);
            var9.setDocNbRetJ((double)var23);
            var9.setDocNbRetNJ((double)var24);
            var9.setDocNbViolSub((double)var25);
            var9.setDocNbViolCau((double)var26);
            if (var1 == 1) {
               var9.setDocPeriode("BULLETIN 1er TRIMESTRE");
               var9.setDocMoyClasse((double)this.filieresMatieres.getFilmatMoy1T());
               var9.setDocNbAbsEXClasse((double)this.filieresMatieres.getFilmatNbAbsEX1T());
               var9.setDocNbAbsJClasse((double)this.filieresMatieres.getFilmatNbAbsJ1T());
               var9.setDocNbAbsNJClasse((double)this.filieresMatieres.getFilmatNbAbsNJ1T());
               var9.setDocNbRetJClasse((double)this.filieresMatieres.getFilmatNbRetJ1T());
               var9.setDocNbRetNJClasse((double)this.filieresMatieres.getFilmatNbRetNJ1T());
               var9.setDocNbViolSubClasse((double)this.filieresMatieres.getFilmatNbViolSubi1T());
               var9.setDocNbViolCauClasse((double)this.filieresMatieres.getFilmatNbViolCause1T());
            } else if (var1 == 2) {
               var9.setDocPeriode("BULLETIN 2eme TRIMESTRE");
               var9.setDocMoyClasse((double)this.filieresMatieres.getFilmatMoy2T());
               var9.setDocMoyClasse((double)this.filieresMatieres.getFilmatMoy2T());
               var9.setDocNbAbsEXClasse((double)this.filieresMatieres.getFilmatNbAbsEX2T());
               var9.setDocNbAbsJClasse((double)this.filieresMatieres.getFilmatNbAbsJ2T());
               var9.setDocNbAbsNJClasse((double)this.filieresMatieres.getFilmatNbAbsNJ2T());
               var9.setDocNbRetJClasse((double)this.filieresMatieres.getFilmatNbRetJ2T());
               var9.setDocNbRetNJClasse((double)this.filieresMatieres.getFilmatNbRetNJ2T());
               var9.setDocNbViolSubClasse((double)this.filieresMatieres.getFilmatNbViolSubi2T());
               var9.setDocNbViolCauClasse((double)this.filieresMatieres.getFilmatNbViolCause2T());
            } else if (var1 == 3) {
               var9.setDocPeriode("BULLETIN 3eme TRIMESTRE");
               var9.setDocMoyClasse((double)this.filieresMatieres.getFilmatMoy3T());
               var9.setDocMoyClasse((double)this.filieresMatieres.getFilmatMoy3T());
               var9.setDocNbAbsEXClasse((double)this.filieresMatieres.getFilmatNbAbsEX3T());
               var9.setDocNbAbsJClasse((double)this.filieresMatieres.getFilmatNbAbsJ3T());
               var9.setDocNbAbsNJClasse((double)this.filieresMatieres.getFilmatNbAbsNJ3T());
               var9.setDocNbRetJClasse((double)this.filieresMatieres.getFilmatNbRetJ3T());
               var9.setDocNbRetNJClasse((double)this.filieresMatieres.getFilmatNbRetNJ3T());
               var9.setDocNbViolSubClasse((double)this.filieresMatieres.getFilmatNbViolSubi3T());
               var9.setDocNbViolCauClasse((double)this.filieresMatieres.getFilmatNbViolCause3T());
            } else if (var1 == 4) {
               var9.setDocPeriode("BULLETIN 4eme TRIMESTRE");
               var9.setDocMoyClasse((double)this.filieresMatieres.getFilmatMoy4T());
               var9.setDocNbAbsEXClasse((double)this.filieresMatieres.getFilmatNbAbsEX4T());
               var9.setDocNbAbsJClasse((double)this.filieresMatieres.getFilmatNbAbsJ4T());
               var9.setDocNbAbsNJClasse((double)this.filieresMatieres.getFilmatNbAbsNJ4T());
               var9.setDocNbRetJClasse((double)this.filieresMatieres.getFilmatNbRetJ4T());
               var9.setDocNbRetNJClasse((double)this.filieresMatieres.getFilmatNbRetNJ4T());
               var9.setDocNbViolSubClasse((double)this.filieresMatieres.getFilmatNbViolSubi4T());
               var9.setDocNbViolCauClasse((double)this.filieresMatieres.getFilmatNbViolCause4T());
            } else if (var1 == 0) {
               var9.setDocPeriode("BULLETIN ANNUEL");
               var9.setDocMoyClasse((double)this.filieresMatieres.getFilmatMoyG());
               var9.setDocNbAbsEXClasse((double)(this.filieresMatieres.getFilmatNbAbsEX1T() + this.filieresMatieres.getFilmatNbAbsEX2T() + this.filieresMatieres.getFilmatNbAbsEX3T() + this.filieresMatieres.getFilmatNbAbsEX4T()));
               var9.setDocNbAbsJClasse((double)(this.filieresMatieres.getFilmatNbAbsJ1T() + this.filieresMatieres.getFilmatNbAbsJ2T() + this.filieresMatieres.getFilmatNbAbsJ3T() + this.filieresMatieres.getFilmatNbAbsJ4T()));
               var9.setDocNbAbsNJClasse((double)(this.filieresMatieres.getFilmatNbAbsNJ1T() + this.filieresMatieres.getFilmatNbAbsNJ2T() + this.filieresMatieres.getFilmatNbAbsNJ3T() + this.filieresMatieres.getFilmatNbAbsNJ4T()));
               var9.setDocNbRetJClasse((double)(this.filieresMatieres.getFilmatNbRetJ1T() + this.filieresMatieres.getFilmatNbRetJ2T() + this.filieresMatieres.getFilmatNbRetJ3T() + this.filieresMatieres.getFilmatNbRetJ4T()));
               var9.setDocNbRetNJClasse((double)(this.filieresMatieres.getFilmatNbRetNJ1T() + this.filieresMatieres.getFilmatNbRetNJ2T() + this.filieresMatieres.getFilmatNbRetNJ3T() + this.filieresMatieres.getFilmatNbRetNJ4T()));
               var9.setDocNbViolSubClasse((double)(this.filieresMatieres.getFilmatNbViolSubi1T() + this.filieresMatieres.getFilmatNbViolSubi2T() + this.filieresMatieres.getFilmatNbViolSubi3T() + this.filieresMatieres.getFilmatNbViolSubi4T()));
               var9.setDocNbViolCauClasse((double)(this.filieresMatieres.getFilmatNbViolCause1T() + this.filieresMatieres.getFilmatNbViolCause2T() + this.filieresMatieres.getFilmatNbViolCause3T() + this.filieresMatieres.getFilmatNbViolCause4T()));
            }

            var7.add(var9);
         }
      }

      return var7;
   }

   public boolean majDateImpression(String var1) throws HibernateException, NamingException {
      boolean var2 = false;
      return var2;
   }

   public void impression(UtilPrint var1, int var2, int var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10, String var11) throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      if (this.nature == 100 && this.natureGestionEleve == 0) {
         this.impressionEleve(var1, var2, var4, var5, var6, var7, var8, var9, var10, var11);
      } else if (this.nature == 102) {
         this.impressionInscription(var1, var2, var4, var5, var6, var7, var8, var9, var10, var11);
      } else if (this.nature != 103 && this.natureGestionEleve != 103) {
         if (this.nature != 104 && this.natureGestionEleve != 104) {
            if (this.nature == 105 || this.natureGestionEleve == 105) {
               this.impressionViolences(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11);
            }
         } else {
            this.impressionNotes(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11);
         }
      } else {
         this.impressionAppels(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11);
      }

   }

   public void impressionEleve(UtilPrint var1, int var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10) throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      if (var2 == 0) {
         if (var3 != null && !var3.isEmpty()) {
            boolean var11 = this.majDateImpression(var3);
            var1.setjRBeanCollectionDataSource(this.calculeImpressionCommun(9));
            var1.setRapport(var3);
            var1.setEntete("Impression document médiatheque");
            var1.setMontant_lettre("");
            var1.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid()));
            var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid()));
            var1.setDuplicata("" + var11);
            var1.setNbDecQte(this.optionsVentes.getNbDecQte());
            var1.setNbDecPu(this.optionsVentes.getNbDecPu());
            var1.setFormat(var5);
            var1.setEmetteur(var6);
            var1.setDestinataire(var7);
            var1.setDestinataireCC(var8);
            var1.setDestinataireCCI(var9);
            var1.setCorpsMail(var10);
            var1.setIdResponsable(0L);
            var1.setIdCommercial(0L);
            var1.setTiersSelectionne((Tiers)null);
            var1.setNature(this.nature);
            var1.setId_doc(this.eleves.getEleId());
            var1.setParc((Parc)null);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      } else if (var4 != null && !var4.isEmpty()) {
         var1.setRapport(var4);
         var1.setEntete("Impression de la liste des documents");
         var1.setTotauxTtc("");
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator + "liste" + File.separator + "mediatheque" + File.separator);
         var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator + "sous_rapport" + File.separator);
         var1.setFormat(var5);
         var1.setEmetteur(var6);
         var1.setDestinataire(var7);
         var1.setDestinataireCC(var8);
         var1.setDestinataireCCI(var9);
         var1.setCorpsMail(var10);
         var1.setIdResponsable(0L);
         var1.setTiersSelectionne((Tiers)null);
         var1.setNature(this.getNature());
         var1.setId_doc(0L);
         JRBeanCollectionDataSource var12 = new JRBeanCollectionDataSource(this.listDocument);
         var1.setjRBeanCollectionDataSource(var12);
         var1.setBaseLog(this.baseLog);
         var1.setStructureLog(this.structureLog);
         var1.setUsersLog(this.usersLog);
         var1.imprimeRapport();
      }

   }

   public void impressionInscription(UtilPrint var1, int var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10) throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      if (var2 == 0) {
         if (var3 != null && !var3.isEmpty()) {
            boolean var11 = this.majDateImpression(var3);
            var1.setjRBeanCollectionDataSource(this.calculeImpressionCommun(9));
            var1.setRapport(var3);
            var1.setEntete("Impression document médiatheque");
            var1.setMontant_lettre("");
            var1.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid()));
            var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid()));
            var1.setDuplicata("" + var11);
            var1.setNbDecQte(this.optionsVentes.getNbDecQte());
            var1.setNbDecPu(this.optionsVentes.getNbDecPu());
            var1.setFormat(var5);
            var1.setEmetteur(var6);
            var1.setDestinataire(var7);
            var1.setDestinataireCC(var8);
            var1.setDestinataireCCI(var9);
            var1.setCorpsMail(var10);
            var1.setIdResponsable(0L);
            var1.setIdCommercial(0L);
            var1.setTiersSelectionne((Tiers)null);
            var1.setNature(this.nature);
            var1.setId_doc(this.eleves.getEleId());
            var1.setParc((Parc)null);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      } else if (var4 != null && !var4.isEmpty()) {
         var1.setRapport(var4);
         var1.setEntete("Impression de la liste des documents");
         var1.setTotauxTtc("");
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator + "liste" + File.separator + "mediatheque" + File.separator);
         var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator + "sous_rapport" + File.separator);
         var1.setFormat(var5);
         var1.setEmetteur(var6);
         var1.setDestinataire(var7);
         var1.setDestinataireCC(var8);
         var1.setDestinataireCCI(var9);
         var1.setCorpsMail(var10);
         var1.setIdResponsable(0L);
         var1.setTiersSelectionne((Tiers)null);
         var1.setNature(this.getNature());
         var1.setId_doc(0L);
         JRBeanCollectionDataSource var12 = new JRBeanCollectionDataSource(this.listDocument);
         var1.setjRBeanCollectionDataSource(var12);
         var1.setBaseLog(this.baseLog);
         var1.setStructureLog(this.structureLog);
         var1.setUsersLog(this.usersLog);
         var1.imprimeRapport();
      }

   }

   public void impressionAppels(UtilPrint var1, int var2, int var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10, String var11) throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      if (var2 == 0) {
         if (var4 != null && !var4.isEmpty()) {
            boolean var12 = this.majDateImpression(var4);
            var1.setjRBeanCollectionDataSource(this.calculeImpressionCommun(var3));
            var1.setRapport(var4);
            var1.setEntete("Impression document médiatheque");
            var1.setMontant_lettre("");
            var1.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid()));
            var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid()));
            var1.setDuplicata("" + var12);
            var1.setNbDecQte(this.optionsVentes.getNbDecQte());
            var1.setNbDecPu(this.optionsVentes.getNbDecPu());
            var1.setFormat(var6);
            var1.setEmetteur(var7);
            var1.setDestinataire(var8);
            var1.setDestinataireCC(var9);
            var1.setDestinataireCCI(var10);
            var1.setCorpsMail(var11);
            var1.setIdResponsable(0L);
            var1.setIdCommercial(0L);
            var1.setTiersSelectionne((Tiers)null);
            var1.setNature(this.nature);
            var1.setId_doc(this.eleves.getEleId());
            var1.setParc((Parc)null);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      } else if (var5 != null && !var5.isEmpty()) {
         var1.setRapport(var5);
         var1.setEntete("Impression de la liste des documents");
         var1.setTotauxTtc("");
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator + "liste" + File.separator + "mediatheque" + File.separator);
         var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator + "sous_rapport" + File.separator);
         var1.setFormat(var6);
         var1.setEmetteur(var7);
         var1.setDestinataire(var8);
         var1.setDestinataireCC(var9);
         var1.setDestinataireCCI(var10);
         var1.setCorpsMail(var11);
         var1.setIdResponsable(0L);
         var1.setTiersSelectionne((Tiers)null);
         var1.setNature(this.getNature());
         var1.setId_doc(0L);
         JRBeanCollectionDataSource var13 = new JRBeanCollectionDataSource(this.listDocument);
         var1.setjRBeanCollectionDataSource(var13);
         var1.setBaseLog(this.baseLog);
         var1.setStructureLog(this.structureLog);
         var1.setUsersLog(this.usersLog);
         var1.imprimeRapport();
      }

   }

   public void impressionNotes(UtilPrint var1, int var2, int var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10, String var11) throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      if (var2 == 0 && var4 != null && !var4.isEmpty()) {
         boolean var12 = this.majDateImpression(var4);
         var1.setjRBeanCollectionDataSource(this.calculeImpressionCommun(var3));
         var1.setRapport(var4);
         var1.setEntete("Impression bulletin note");
         var1.setMontant_lettre("");
         var1.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid()));
         var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
         var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid()));
         var1.setDuplicata("" + var12);
         var1.setNbDecQte(this.optionsVentes.getNbDecQte());
         var1.setNbDecPu(this.optionsVentes.getNbDecPu());
         var1.setFormat(var6);
         var1.setEmetteur(var7);
         var1.setDestinataire(var8);
         var1.setDestinataireCC(var9);
         var1.setDestinataireCCI(var10);
         var1.setCorpsMail(var11);
         var1.setIdResponsable(0L);
         var1.setIdCommercial(0L);
         var1.setTiersSelectionne((Tiers)null);
         var1.setNature(this.nature);
         var1.setId_doc(this.eleves.getEleId());
         var1.setParc((Parc)null);
         var1.setBaseLog(this.baseLog);
         var1.setStructureLog(this.structureLog);
         var1.setUsersLog(this.usersLog);
         var1.imprimeRapport();
      }

   }

   public void impressionViolences(UtilPrint var1, int var2, int var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10, String var11) throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      if (var2 == 0) {
         if (var4 != null && !var4.isEmpty()) {
            boolean var12 = this.majDateImpression(var4);
            var1.setjRBeanCollectionDataSource(this.calculeImpressionCommun(var3));
            var1.setRapport(var4);
            var1.setEntete("Impression document médiatheque");
            var1.setMontant_lettre("");
            var1.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid()));
            var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid()));
            var1.setDuplicata("" + var12);
            var1.setNbDecQte(this.optionsVentes.getNbDecQte());
            var1.setNbDecPu(this.optionsVentes.getNbDecPu());
            var1.setFormat(var6);
            var1.setEmetteur(var7);
            var1.setDestinataire(var8);
            var1.setDestinataireCC(var9);
            var1.setDestinataireCCI(var10);
            var1.setCorpsMail(var11);
            var1.setIdResponsable(0L);
            var1.setIdCommercial(0L);
            var1.setTiersSelectionne((Tiers)null);
            var1.setNature(this.nature);
            var1.setId_doc(this.eleves.getEleId());
            var1.setParc((Parc)null);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      } else if (var5 != null && !var5.isEmpty()) {
         var1.setRapport(var5);
         var1.setEntete("Impression de la liste des documents");
         var1.setTotauxTtc("");
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator + "liste" + File.separator + "mediatheque" + File.separator);
         var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator + "sous_rapport" + File.separator);
         var1.setFormat(var6);
         var1.setEmetteur(var7);
         var1.setDestinataire(var8);
         var1.setDestinataireCC(var9);
         var1.setDestinataireCCI(var10);
         var1.setCorpsMail(var11);
         var1.setIdResponsable(0L);
         var1.setTiersSelectionne((Tiers)null);
         var1.setNature(this.getNature());
         var1.setId_doc(0L);
         JRBeanCollectionDataSource var13 = new JRBeanCollectionDataSource(this.listDocument);
         var1.setjRBeanCollectionDataSource(var13);
         var1.setBaseLog(this.baseLog);
         var1.setStructureLog(this.structureLog);
         var1.setUsersLog(this.usersLog);
         var1.imprimeRapport();
      }

   }

   public void initGrapheur() {
   }

   public String getUrlIpProd() {
      return StaticModePegase.getUrlIp();
   }

   public String getBaseLog() {
      return this.baseLog;
   }

   public void setBaseLog(String var1) {
      this.baseLog = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
   }

   public OptionVentes getOptionsVentes() {
      return this.optionsVentes;
   }

   public void setOptionsVentes(OptionVentes var1) {
      this.optionsVentes = var1;
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

   public int getVar_action() {
      return this.var_action;
   }

   public void setVar_action(int var1) {
      this.var_action = var1;
   }

   public int getVar_nb_max() {
      return this.var_nb_max;
   }

   public void setVar_nb_max(int var1) {
      this.var_nb_max = var1;
   }

   public ExercicesVentes getExercicesVentes() {
      return this.exercicesVentes;
   }

   public void setExercicesVentes(ExercicesVentes var1) {
      this.exercicesVentes = var1;
   }

   public ExercicesVentes getLastExoVentes() {
      return this.lastExoVentes;
   }

   public void setLastExoVentes(ExercicesVentes var1) {
      this.lastExoVentes = var1;
   }

   public boolean isShowModalPanelPrint() {
      return this.showModalPanelPrint;
   }

   public void setShowModalPanelPrint(boolean var1) {
      this.showModalPanelPrint = var1;
   }

   public DataModel getDatamodelDocument() {
      return this.datamodelDocument;
   }

   public void setDatamodelDocument(DataModel var1) {
      this.datamodelDocument = var1;
   }

   public UsersChrono getUsersChrono() {
      return this.usersChrono;
   }

   public void setUsersChrono(UsersChrono var1) {
      this.usersChrono = var1;
   }

   public Eleves getEleves() {
      return this.eleves;
   }

   public void setEleves(Eleves var1) {
      this.eleves = var1;
   }

   public boolean isShowModalPanelDocument() {
      return this.showModalPanelDocument;
   }

   public void setShowModalPanelDocument(boolean var1) {
      this.showModalPanelDocument = var1;
   }

   public boolean isVar_acc_complement() {
      return this.var_acc_complement;
   }

   public void setVar_acc_complement(boolean var1) {
      this.var_acc_complement = var1;
   }

   public boolean isVar_acc_document() {
      return this.var_acc_document;
   }

   public void setVar_acc_document(boolean var1) {
      this.var_acc_document = var1;
   }

   public boolean isVar_acc_dre() {
      return this.var_acc_dre;
   }

   public void setVar_acc_dre(boolean var1) {
      this.var_acc_dre = var1;
   }

   public boolean isVar_acc_etat() {
      return this.var_acc_etat;
   }

   public void setVar_acc_etat(boolean var1) {
      this.var_acc_etat = var1;
   }

   public boolean isVar_acc_exoneration() {
      return this.var_acc_exoneration;
   }

   public void setVar_acc_exoneration(boolean var1) {
      this.var_acc_exoneration = var1;
   }

   public boolean isVar_acc_habilitation() {
      return this.var_acc_habilitation;
   }

   public void setVar_acc_habilitation(boolean var1) {
      this.var_acc_habilitation = var1;
   }

   public boolean isVar_acc_imputation() {
      return this.var_acc_imputation;
   }

   public void setVar_acc_imputation(boolean var1) {
      this.var_acc_imputation = var1;
   }

   public boolean isVar_acc_reglement() {
      return this.var_acc_reglement;
   }

   public void setVar_acc_reglement(boolean var1) {
      this.var_acc_reglement = var1;
   }

   public boolean isVar_acc_tracabilite() {
      return this.var_acc_tracabilite;
   }

   public void setVar_acc_tracabilite(boolean var1) {
      this.var_acc_tracabilite = var1;
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

   public List getMesOnglets() {
      return this.mesOnglets;
   }

   public void setMesOnglets(List var1) {
      this.mesOnglets = var1;
   }

   public boolean isVisibiliteBton() {
      return this.visibiliteBton;
   }

   public void setVisibiliteBton(boolean var1) {
      this.visibiliteBton = var1;
   }

   public int getVar_nb_ligne() {
      return this.var_nb_ligne;
   }

   public void setVar_nb_ligne(int var1) {
      this.var_nb_ligne = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public long getInpClasse() {
      return this.inpClasse;
   }

   public void setInpClasse(long var1) {
      this.inpClasse = var1;
   }

   public boolean isVar_more_search() {
      return this.var_more_search;
   }

   public void setVar_more_search(boolean var1) {
      this.var_more_search = var1;
   }

   public List getMesClasseItems() {
      return this.mesClasseItems;
   }

   public void setMesClasseItems(List var1) {
      this.mesClasseItems = var1;
   }

   public List getMesProfesseursItems() {
      return this.mesProfesseursItems;
   }

   public void setMesProfesseursItems(List var1) {
      this.mesProfesseursItems = var1;
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

   public String getFileName() {
      return this.fileName;
   }

   public void setFileName(String var1) {
      this.fileName = var1;
   }

   public boolean isShowModalPanelScan() {
      return this.showModalPanelScan;
   }

   public void setShowModalPanelScan(boolean var1) {
      this.showModalPanelScan = var1;
   }

   public UploadedFile getUploadedFile() {
      return this.uploadedFile;
   }

   public void setUploadedFile(UploadedFile var1) {
      this.uploadedFile = var1;
   }

   public String getUrlExplorateur() {
      return this.urlExplorateur;
   }

   public void setUrlExplorateur(String var1) {
      this.urlExplorateur = var1;
   }

   public String getUrlphotoProd() {
      return this.urlphotoProd;
   }

   public void setUrlphotoProd(String var1) {
      this.urlphotoProd = var1;
   }

   public int getTypeFichier() {
      return this.typeFichier;
   }

   public void setTypeFichier(int var1) {
      this.typeFichier = var1;
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

   public String getDeviseGraph() {
      return this.deviseGraph;
   }

   public void setDeviseGraph(String var1) {
      this.deviseGraph = var1;
   }

   public int getModeGraph() {
      return this.modeGraph;
   }

   public void setModeGraph(int var1) {
      this.modeGraph = var1;
   }

   public int getNbDecGraph() {
      return this.nbDecGraph;
   }

   public void setNbDecGraph(int var1) {
      this.nbDecGraph = var1;
   }

   public boolean isShowModalPanelGraph() {
      return this.showModalPanelGraph;
   }

   public void setShowModalPanelGraph(boolean var1) {
      this.showModalPanelGraph = var1;
   }

   public boolean isShowModele() {
      return this.showModele;
   }

   public void setShowModele(boolean var1) {
      this.showModele = var1;
   }

   public String getSousTitreGraph() {
      return this.sousTitreGraph;
   }

   public void setSousTitreGraph(String var1) {
      this.sousTitreGraph = var1;
   }

   public int getTimeDecoupage() {
      return this.timeDecoupage;
   }

   public void setTimeDecoupage(int var1) {
      this.timeDecoupage = var1;
   }

   public String getTitreGraph() {
      return this.titreGraph;
   }

   public void setTitreGraph(String var1) {
      this.titreGraph = var1;
   }

   public String getUniteGraph() {
      return this.uniteGraph;
   }

   public void setUniteGraph(String var1) {
      this.uniteGraph = var1;
   }

   public int getValQteGraph() {
      return this.valQteGraph;
   }

   public void setValQteGraph(int var1) {
      this.valQteGraph = var1;
   }

   public int getInpEtat() {
      return this.inpEtat;
   }

   public void setInpEtat(int var1) {
      this.inpEtat = var1;
   }

   public String getInpMatricule() {
      return this.inpMatricule;
   }

   public void setInpMatricule(String var1) {
      this.inpMatricule = var1;
   }

   public String getInpNom() {
      return this.inpNom;
   }

   public void setInpNom(String var1) {
      this.inpNom = var1;
   }

   public double getMontantReglement() {
      return this.montantReglement;
   }

   public void setMontantReglement(double var1) {
      this.montantReglement = var1;
   }

   public double getMontantReglementElmt() {
      return this.montantReglementElmt;
   }

   public void setMontantReglementElmt(double var1) {
      this.montantReglementElmt = var1;
   }

   public double getMontantSolde() {
      return this.montantSolde;
   }

   public void setMontantSolde(double var1) {
      this.montantSolde = var1;
   }

   public double getMontantSoldeElmt() {
      return this.montantSoldeElmt;
   }

   public void setMontantSoldeElmt(double var1) {
      this.montantSoldeElmt = var1;
   }

   public double getMontantTtc() {
      return this.montantTtc;
   }

   public void setMontantTtc(double var1) {
      this.montantTtc = var1;
   }

   public double getMontantTtcElmt() {
      return this.montantTtcElmt;
   }

   public void setMontantTtcElmt(double var1) {
      this.montantTtcElmt = var1;
   }

   public boolean isVar_aff_action() {
      return this.var_aff_action;
   }

   public void setVar_aff_action(boolean var1) {
      this.var_aff_action = var1;
   }

   public boolean isVar_valide_doc() {
      return this.var_valide_doc;
   }

   public void setVar_valide_doc(boolean var1) {
      this.var_valide_doc = var1;
   }

   public DataModel getDatamodelAppels() {
      return this.datamodelAppels;
   }

   public void setDatamodelAppels(DataModel var1) {
      this.datamodelAppels = var1;
   }

   public DataModel getDatamodelNote() {
      return this.datamodelNote;
   }

   public void setDatamodelNote(DataModel var1) {
      this.datamodelNote = var1;
   }

   public Date getInpDate() {
      return this.inpDate;
   }

   public void setInpDate(Date var1) {
      this.inpDate = var1;
   }

   public long getInpMatiere() {
      return this.inpMatiere;
   }

   public void setInpMatiere(long var1) {
      this.inpMatiere = var1;
   }

   public List getMesMatiereresItems() {
      return this.mesMatiereresItems;
   }

   public void setMesMatiereresItems(List var1) {
      this.mesMatiereresItems = var1;
   }

   public long getInpProfesseur() {
      return this.inpProfesseur;
   }

   public void setInpProfesseur(long var1) {
      this.inpProfesseur = var1;
   }

   public boolean isAfficheListeEleve() {
      return this.afficheListeEleve;
   }

   public void setAfficheListeEleve(boolean var1) {
      this.afficheListeEleve = var1;
   }

   public Date getInpDateDebut() {
      return this.inpDateDebut;
   }

   public void setInpDateDebut(Date var1) {
      this.inpDateDebut = var1;
   }

   public Date getInpDateFin() {
      return this.inpDateFin;
   }

   public void setInpDateFin(Date var1) {
      this.inpDateFin = var1;
   }

   public String getInpSerie() {
      return this.inpSerie;
   }

   public void setInpSerie(String var1) {
      this.inpSerie = var1;
   }

   public boolean isShowModalPanelAnnuler() {
      return this.showModalPanelAnnuler;
   }

   public void setShowModalPanelAnnuler(boolean var1) {
      this.showModalPanelAnnuler = var1;
   }

   public Date getDateAnnulation() {
      return this.dateAnnulation;
   }

   public void setDateAnnulation(Date var1) {
      this.dateAnnulation = var1;
   }

   public String getMotifAnnulation() {
      return this.motifAnnulation;
   }

   public void setMotifAnnulation(String var1) {
      this.motifAnnulation = var1;
   }

   public Habilitation getHabilitation() {
      return this.habilitation;
   }

   public void setHabilitation(Habilitation var1) {
      this.habilitation = var1;
   }

   public double getInpCoef() {
      return this.inpCoef;
   }

   public void setInpCoef(double var1) {
      this.inpCoef = var1;
   }

   public int getInpType() {
      return this.inpType;
   }

   public void setInpType(int var1) {
      this.inpType = var1;
   }

   public double getInpMax() {
      return this.inpMax;
   }

   public void setInpMax(double var1) {
      this.inpMax = var1;
   }

   public int getInpMode() {
      return this.inpMode;
   }

   public void setInpMode(int var1) {
      this.inpMode = var1;
   }

   public ElevesNote getElevesNote() {
      return this.elevesNote;
   }

   public void setElevesNote(ElevesNote var1) {
      this.elevesNote = var1;
   }

   public boolean isShowModalPanelNote() {
      return this.showModalPanelNote;
   }

   public void setShowModalPanelNote(boolean var1) {
      this.showModalPanelNote = var1;
   }

   public int getChoixMatiere() {
      return this.choixMatiere;
   }

   public void setChoixMatiere(int var1) {
      this.choixMatiere = var1;
   }

   public List getMesInscriptionsItems() {
      return this.mesInscriptionsItems;
   }

   public void setMesInscriptionsItems(List var1) {
      this.mesInscriptionsItems = var1;
   }

   public long getChoixInscription() {
      return this.choixInscription;
   }

   public void setChoixInscription(long var1) {
      this.choixInscription = var1;
   }

   public boolean isShowModalPanelPresence() {
      return this.showModalPanelPresence;
   }

   public void setShowModalPanelPresence(boolean var1) {
      this.showModalPanelPresence = var1;
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

   public DataModel getDatamodelViolences() {
      return this.datamodelViolences;
   }

   public void setDatamodelViolences(DataModel var1) {
      this.datamodelViolences = var1;
   }

   public boolean isShowModalPanelViolences() {
      return this.showModalPanelViolences;
   }

   public void setShowModalPanelViolences(boolean var1) {
      this.showModalPanelViolences = var1;
   }
}
