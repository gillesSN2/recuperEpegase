package com.epegase.forms.ventes;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.AvoirEnteteAchats;
import com.epegase.systeme.classe.AvoirEnteteVentes;
import com.epegase.systeme.classe.Bal;
import com.epegase.systeme.classe.CampagneActionVentes;
import com.epegase.systeme.classe.CampagneEnteteVentes;
import com.epegase.systeme.classe.CampagneMessageVentes;
import com.epegase.systeme.classe.CampagneParticipantVentes;
import com.epegase.systeme.classe.CommandeEnteteAchats;
import com.epegase.systeme.classe.CommandeEnteteVentes;
import com.epegase.systeme.classe.Contacts;
import com.epegase.systeme.classe.CotationEnteteAchats;
import com.epegase.systeme.classe.DevisEnteteVentes;
import com.epegase.systeme.classe.Equipes;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FactureEnteteAchats;
import com.epegase.systeme.classe.FactureEnteteVentes;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.LivraisonEnteteVentes;
import com.epegase.systeme.classe.NoteDebitEnteteAchats;
import com.epegase.systeme.classe.NoteDebitEnteteVentes;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.ReceptionEnteteAchats;
import com.epegase.systeme.classe.Reglements;
import com.epegase.systeme.classe.Sms;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.DocumentEntete;
import com.epegase.systeme.control.EcrituresAnalytiqueCtrl;
import com.epegase.systeme.control.ObjetGraph;
import com.epegase.systeme.dao.AvoirEnteteAchatsDao;
import com.epegase.systeme.dao.AvoirEnteteVentesDao;
import com.epegase.systeme.dao.CampagneActionVentesDao;
import com.epegase.systeme.dao.CampagneEnteteVentesDao;
import com.epegase.systeme.dao.CampagneMessageVentesDao;
import com.epegase.systeme.dao.CampagneParticipantVentesDao;
import com.epegase.systeme.dao.CommandeEnteteAchatsDao;
import com.epegase.systeme.dao.CommandeEnteteVentesDao;
import com.epegase.systeme.dao.ContactDao;
import com.epegase.systeme.dao.CotationEnteteAchatsDao;
import com.epegase.systeme.dao.DevisEnteteVentesDao;
import com.epegase.systeme.dao.DocumentTraceVentesDao;
import com.epegase.systeme.dao.EquipesDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.FactureEnteteAchatsDao;
import com.epegase.systeme.dao.FactureEnteteVentesDao;
import com.epegase.systeme.dao.LivraisonEnteteVentesDao;
import com.epegase.systeme.dao.NoteDebitEnteteAchatsDao;
import com.epegase.systeme.dao.NoteDebitEnteteVentesDao;
import com.epegase.systeme.dao.ReceptionEnteteAchatsDao;
import com.epegase.systeme.dao.ReglementsDao;
import com.epegase.systeme.dao.SmsDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilMail;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilParapheur;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.util.UtilSms;
import com.epegase.systeme.xml.LectureAppreciations;
import com.epegase.systeme.xml.LectureCategorieTiers;
import com.epegase.systeme.xml.ObjetLigneOnglet;
import com.epegase.systeme.xml.OptionVentes;
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

public class FormCampagneVentes implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private FormRecherche formRecherche;
   private int var_action = 0;
   private int var_memo_action = 0;
   private String pageIndex;
   private int nature;
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
   private int var_option_parc;
   private DocumentEntete documentEntete = new DocumentEntete();
   private boolean showModalPanelAnnuler = false;
   private transient DataModel datamodelCampagne = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private List listCampagne = new ArrayList();
   private CampagneEnteteVentes campagneEnteteVentes = new CampagneEnteteVentes();
   private CampagneEnteteVentesDao campagneEnteteVentesDao;
   private boolean visibiliteBton = false;
   private boolean var_aff_action = false;
   private boolean var_valide_doc = false;
   private int var_etat;
   private List listActions = new ArrayList();
   private transient DataModel datamodelActions = new ListDataModel();
   private CampagneActionVentes campagneActionVentes;
   private CampagneActionVentesDao campagneActionVentesDao;
   private boolean showModalPanelActions = false;
   private boolean visibiliteBtonActions = false;
   private CotationEnteteAchatsDao cotationEnteteAchatsDao;
   private CommandeEnteteAchatsDao commandeEnteteAchatsDao;
   private ReceptionEnteteAchatsDao receptionEnteteAchatsDao;
   private FactureEnteteAchatsDao factureEnteteAchatsDao;
   private NoteDebitEnteteAchatsDao noteDebitEnteteAchatsDao;
   private AvoirEnteteAchatsDao avoirEnteteAchatsDao;
   private ReglementsDao reglementsDao;
   private List lesDepenses = new ArrayList();
   private transient DataModel dataModelDepenses = new ListDataModel();
   private double totalDepenses;
   private DevisEnteteVentesDao devisEnteteVentesDao;
   private CommandeEnteteVentesDao commandeEnteteVentesDao;
   private LivraisonEnteteVentesDao livraisonEnteteVentesDao;
   private FactureEnteteVentesDao factureEnteteVentesDao;
   private NoteDebitEnteteVentesDao noteDebitEnteteVentesDao;
   private AvoirEnteteVentesDao avoirEnteteVentesDao;
   private List lesRecettes = new ArrayList();
   private transient DataModel dataModelRecettes = new ListDataModel();
   private double totalRecettes;
   private double totalMarge;
   private double totalEcartBudget;
   private boolean visibiliteBtonParticipant = false;
   private CampagneParticipantVentes campagneParticipantVentes;
   private CampagneParticipantVentesDao campagneParticipantVentesDao;
   private transient DataModel dataModelParticipants;
   private List lesParticipants;
   private boolean showModalPanelParticipant = false;
   private boolean showModalPanelGroupe = false;
   private Tiers tiers;
   private String var_participant;
   private Contacts contacts;
   private int nbParticipants;
   private boolean visibiliteBtonMail = false;
   private boolean visibiliteBtonSms = false;
   private CampagneMessageVentes campagneMessageVentesMail;
   private CampagneMessageVentes campagneMessageVentesSms;
   private CampagneMessageVentesDao campagneMessageVentesDao;
   private transient DataModel dataModelMail;
   private transient DataModel dataModelSms;
   private List lesMails;
   private List lesSms;
   private boolean showModalPanelMessageMail = false;
   private boolean showModalPanelMessageSMS = false;
   private Date inpDate;
   private Date inpDu;
   private Date inpAu;
   private int inpNb;
   private int inpEtat;
   private String periode;
   private String inpNum;
   private String inpService;
   private String inpActivite;
   private String inpResponsable;
   private long inpIdResponsable;
   private String inpCommercial;
   private long inpIdCommercial;
   private double montantDepenses;
   private double montantRecettes;
   private double montantMarge;
   private int var_nb_ligne;
   private List mesSerieUserItem;
   private Date var_date;
   private String var_heure;
   private String var_minute;
   private String var_seconde;
   private boolean affichagePump = false;
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
   private boolean var_verrou_comm = false;
   private boolean visibleOnglet = false;
   private Habilitation habilitation;
   private DocumentTraceVentesDao documentTraceVentesDao;
   private UtilParapheur utilParapheur;
   private boolean existParapheur;
   private int var_anal_dossier;
   private boolean var_anal_parc = false;
   private Users responsable;
   private long var_nom_commercial;
   private List mesUsersItem = new ArrayList();
   private List mesPersonnelsItem = new ArrayList();
   private long var_nom_responsable;
   private UserDao usersDao;
   private long var_nom_equipe;
   private Equipes equipes;
   private EquipesDao equipesDao;
   private List mesEquipeItem;
   private List lesEquipes;
   private String montant_lettre;
   private boolean showModalPanelPrint = false;
   private boolean var_anal_activite;
   private boolean decoupageActivite = false;
   private List laColonne1Items;
   private List laColonne2Items;
   private List laColonne3Items;
   private EcrituresAnalytiqueCtrl ecrituresAnalytiqueCtrl;
   private List lesDecoupagesActivites;
   private transient DataModel dataModelDecoupageActivtes;
   private String var_colonne1;
   private String var_colonne2;
   private String var_colonne3;
   private double totalImputation;
   private double soldeImputation;
   private ContactDao contactDao;
   private String nomRec;
   private String villeRec;
   private String fonctionRec;
   private String categorieRec;
   private String familleRec = "100";
   private String pdvRec = "100";
   private String appreciationRec = "100";
   private String activitesRec = "100";
   private String observationsRec = "100";
   private String paysRec = "100";
   private String mailRec = "";
   private List mesActivitesSocietesItems;
   private List mesObservationsItems;
   private List mesPaysItems;
   private List mesAppreciationsItems;
   private List mesCategoriesItems;
   private List lesGroupesParticipants;
   private transient DataModel dataModelGroupe;
   private List resumeCommercial;
   private ObjetGraph objetGraph;

   public FormCampagneVentes() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.lesDecoupagesActivites = new ArrayList();
      this.dataModelDecoupageActivtes = new ListDataModel();
      this.dataModelParticipants = new ListDataModel();
      this.lesParticipants = new ArrayList();
      this.mesActivitesSocietesItems = new ArrayList();
      this.mesObservationsItems = new ArrayList();
      this.mesPaysItems = new ArrayList();
      this.mesAppreciationsItems = new ArrayList();
      this.mesCategoriesItems = new ArrayList();
      this.lesGroupesParticipants = new ArrayList();
      this.dataModelGroupe = new ListDataModel();
      this.dataModelMail = new ListDataModel();
      this.dataModelSms = new ListDataModel();
      this.lesMails = new ArrayList();
      this.lesSms = new ArrayList();
      this.resumeCommercial = new ArrayList();
   }

   public void InstancesDaoUtilses() {
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.campagneEnteteVentesDao = new CampagneEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.campagneMessageVentesDao = new CampagneMessageVentesDao(this.baseLog, this.utilInitHibernate);
      this.campagneActionVentesDao = new CampagneActionVentesDao(this.baseLog, this.utilInitHibernate);
      this.usersDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.equipesDao = new EquipesDao(this.baseLog, this.utilInitHibernate);
      this.cotationEnteteAchatsDao = new CotationEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.commandeEnteteAchatsDao = new CommandeEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.receptionEnteteAchatsDao = new ReceptionEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.factureEnteteAchatsDao = new FactureEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.noteDebitEnteteAchatsDao = new NoteDebitEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.avoirEnteteAchatsDao = new AvoirEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.reglementsDao = new ReglementsDao(this.baseLog, this.utilInitHibernate);
      this.devisEnteteVentesDao = new DevisEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.commandeEnteteVentesDao = new CommandeEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.livraisonEnteteVentesDao = new LivraisonEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.factureEnteteVentesDao = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.noteDebitEnteteVentesDao = new NoteDebitEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.avoirEnteteVentesDao = new AvoirEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.campagneParticipantVentesDao = new CampagneParticipantVentesDao(this.baseLog, this.utilInitHibernate);
      this.contactDao = new ContactDao(this.baseLog, this.utilInitHibernate);
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

      if (this.optionsVentes.getAxeActivite().equals("true")) {
         this.var_anal_activite = true;
      } else {
         this.var_anal_activite = false;
      }

      if (this.optionsVentes.getAxeParc().equals("true")) {
         this.var_anal_parc = true;
      } else {
         this.var_anal_parc = false;
      }

      this.periode = this.optionsVentes.getAffichInGlobViewCAMPAGNE();
      if (this.habilitation != null) {
         this.existParapheur = true;
      } else {
         this.existParapheur = false;
      }

      this.utilParapheur = new UtilParapheur(this.utilInitHibernate, this.structureLog, this.baseLog, this.usersLog);
      this.usersChrono = new UsersChrono();
      this.usersChrono = this.usersChronoDao.selectUnique("", this.nature, this.usersLog, var1);
      this.mesPersonnelsItem = this.usersDao.chargerTousLesActifsItems(var1);
   }

   public void accesResteintUser() {
      if (this.usersLog.getUsrAffPump() == 0) {
         this.affichagePump = false;
      } else {
         this.affichagePump = true;
      }

      if (this.usersLog.getUsrCommVentes() == 2) {
         this.var_verrou_comm = false;
      } else {
         this.var_verrou_comm = true;
      }

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

   public void chargerLesUsers(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      if (this.optionsVentes.getResponsable().equals("0")) {
         Object var2 = new ArrayList();
         if (this.usersLog.getUsrCommVentes() == 0) {
            var2 = this.usersDao.chargerLesUsers(var1);
         } else if (this.usersLog.getUsrCommVentes() == 1) {
            var2 = this.usersDao.chargerLesSignataires("Ventes", var1);
         } else {
            ((List)var2).add(this.usersLog);
         }

         if (((List)var2).size() == 0) {
            ((List)var2).add(this.usersLog);
         }

         this.mesUsersItem.clear();
         if (this.usersLog.getUsrCommVentes() != 0 && this.usersLog.getUsrCommVentes() != 1) {
            this.mesUsersItem.add(new SelectItem(this.usersLog.getUsrid(), this.usersLog.getUsrPatronyme()));
         } else {
            for(int var3 = 0; var3 < ((List)var2).size(); ++var3) {
               Users var4 = (Users)((List)var2).get(var3);
               if (var4.getUsrVendeur() == 1 && var4.getUsrPatronyme() != null && !var4.getUsrPatronyme().isEmpty()) {
                  this.mesUsersItem.add(new SelectItem(var4.getUsrid(), var4.getUsrPatronyme()));
               }
            }

            if (this.mesUsersItem.size() == 0) {
               this.mesUsersItem.add(new SelectItem(this.usersLog.getUsrid(), this.usersLog.getUsrPatronyme()));
            }
         }
      }

   }

   public void chargerCommerciauxResponsable(Session var1) throws HibernateException, NamingException {
      if (this.optionsVentes.getResponsable().equals("1") || this.optionsVentes.getResponsable().equals("2")) {
         new ArrayList();
         List var2 = this.usersDao.chargerLesSignataires("Ventes", var1);
         this.mesUsersItem.clear();
         if (var2.size() != 0) {
            this.mesUsersItem.add(new SelectItem(0, ""));

            for(int var3 = 0; var3 < var2.size(); ++var3) {
               Users var4 = (Users)var2.get(var3);
               if (var4.getUsrVendeur() == 1 && var4.getUsrPatronyme() != null && !var4.getUsrPatronyme().isEmpty()) {
                  this.mesUsersItem.add(new SelectItem(var4.getUsrid(), var4.getUsrPatronyme()));
               }
            }
         }
      }

   }

   public void chargerUserChrono(Session var1) throws HibernateException, NamingException {
      if (this.campagneEnteteVentes != null && this.campagneEnteteVentes.getCamSerie() != null && !this.campagneEnteteVentes.getCamSerie().isEmpty()) {
         this.usersChrono = this.usersChronoDao.selectUnique(this.campagneEnteteVentes.getCamSerie(), this.nature, this.usersLog, var1);
      }

   }

   public List recupererCategorieItem(String var1) throws IOException {
      this.mesCategoriesItems = new ArrayList();
      LectureCategorieTiers var2 = new LectureCategorieTiers(var1);
      this.mesCategoriesItems = var2.getMesCategoriesTiersItems();
      return this.mesCategoriesItems;
   }

   public void recupererAppreciationItem() throws IOException {
      this.mesAppreciationsItems = new ArrayList();
      LectureAppreciations var1 = new LectureAppreciations();
      this.mesAppreciationsItems = var1.getMesAppreciationItems();
   }

   public void executerRequete() throws NamingException, HibernateException, ParseException {
      this.executerRequete((Session)null);
   }

   public void executerRequete(Session var1) throws NamingException, HibernateException, ParseException {
      this.listCampagne.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      this.var_nb_ligne = 0;
      this.inpNum = "";
      this.inpService = "100";
      this.inpActivite = "100";
      Object var2 = null;
      Object var3 = null;
      double var4 = 0.0D;
      double var6 = 0.0D;
      if (this.inpNum != null && !this.inpNum.isEmpty()) {
         this.inpEtat = 100;
      }

      this.listCampagne = this.campagneEnteteVentesDao.recherche(var1, this.exercicesVentes.getExevteId(), this.inpNum, this.inpEtat, this.periode, this.inpService, this.usersLog.getUsrid(), this.usersLog.getUsrVentes(), this.inpResponsable, this.inpCommercial, this.inpActivite, (String)var2, (String)var3);
      if (this.listCampagne.size() > 0) {
         new CampagneEnteteVentes();

         for(int var9 = 0; var9 < this.listCampagne.size(); ++var9) {
            CampagneEnteteVentes var8 = (CampagneEnteteVentes)this.listCampagne.get(var9);
            var4 += var8.getCamTotDepense();
            var6 += var8.getCamTotRecette();
         }

         this.var_nb_ligne = this.listCampagne.size();
      }

      this.datamodelCampagne.setWrappedData(this.listCampagne);
      this.montantDepenses = var4;
      this.montantRecettes = var6;
      this.montantMarge = this.montantDepenses - this.montantRecettes;
      this.visibiliteBton = false;
   }

   public void selectionLigne() throws HibernateException, NamingException, ParseException, JDOMException, IOException {
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
            this.campagneEnteteVentes = (CampagneEnteteVentes)var1.get(0);
            this.visibiliteBtonActions = false;
            this.visibiliteBtonMail = false;
            this.visibiliteBtonParticipant = false;
            this.visibiliteBtonSms = false;
            this.var_etat = this.campagneEnteteVentes.getCamEtat();
            this.var_date = this.campagneEnteteVentes.getCamDate();
            if (this.campagneEnteteVentes.getCamDate().getHours() <= 9) {
               this.var_heure = "0" + this.campagneEnteteVentes.getCamDate().getHours();
            } else {
               this.var_heure = "" + this.campagneEnteteVentes.getCamDate().getHours();
            }

            if (this.campagneEnteteVentes.getCamDate().getMinutes() <= 9) {
               this.var_minute = "0" + this.campagneEnteteVentes.getCamDate().getMinutes();
            } else {
               this.var_minute = "" + this.campagneEnteteVentes.getCamDate().getMinutes();
            }

            if (this.campagneEnteteVentes.getCamDate().getSeconds() <= 9) {
               this.var_seconde = "0" + this.campagneEnteteVentes.getCamDate().getSeconds();
            } else {
               this.var_seconde = "" + this.campagneEnteteVentes.getCamDate().getSeconds();
            }

            Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "CampagneEntete");
            this.chargerLesActions(var4);
            this.chargerLesDepenses(var4);
            this.chargerLesRecettes(var4);
            this.chargerLesParticipants(var4);
            this.chargerLesMessages(var4);
            this.chargerLesUsers(var4);
            this.chargerCommerciauxResponsable(var4);
            this.var_nom_responsable = this.campagneEnteteVentes.getCamIdResponsable();
            this.var_nom_commercial = this.campagneEnteteVentes.getCamIdCommercial();
            if (this.decoupageActivite) {
               this.chargerDetailanalytique();
               this.controleEcartAnalytique();
            }

            this.totalEcartBudget = this.campagneEnteteVentes.getCamTotBudget() - this.totalDepenses;
            this.totalMarge = this.totalRecettes - this.totalDepenses;
            this.calculRepartitionCommercial();
            this.utilInitHibernate.closeSession();
            this.visibiliteBton = true;
         } else {
            this.visibiliteBtonActions = false;
            this.visibiliteBtonMail = false;
            this.visibiliteBtonParticipant = false;
            this.visibiliteBtonSms = false;
            this.visibiliteBton = false;
         }
      } else {
         this.visibiliteBtonActions = false;
         this.visibiliteBtonMail = false;
         this.visibiliteBtonParticipant = false;
         this.visibiliteBtonSms = false;
         this.visibiliteBton = false;
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException, ParseException {
      if (this.campagneEnteteVentes != null) {
         if (this.campagneEnteteVentes.getCamEtat() == 0) {
            this.modifDocument();
         } else {
            this.consultDocument();
         }
      }

   }

   public void chargerLesActions(Session var1) throws HibernateException, NamingException {
      this.listActions.clear();
      if (this.campagneEnteteVentes != null) {
         this.listActions = this.campagneActionVentesDao.rechercheCampagne(this.campagneEnteteVentes, var1);
      }

      this.datamodelActions.setWrappedData(this.listActions);
   }

   public void chargerLesDepenses(Session var1) throws HibernateException, NamingException {
      this.totalDepenses = 0.0D;
      this.lesDepenses.clear();
      String var2 = this.utilDate.dateToStringSQLLight(this.campagneEnteteVentes.getCamDateDebut()) + " 00:00:00";
      String var3 = this.utilDate.dateToStringSQLLight(this.campagneEnteteVentes.getCamDateFin()) + " 23:59:59";
      String var4 = this.campagneEnteteVentes.getCamNum() + ":";
      new ArrayList();
      List var5 = this.cotationEnteteAchatsDao.rechercheCotationCampagne(var4, var1);
      if (var5.size() != 0) {
         new CotationEnteteAchats();

         for(int var7 = 0; var7 < var5.size(); ++var7) {
            CotationEnteteAchats var6 = (CotationEnteteAchats)var5.get(var7);
            this.documentEntete = new DocumentEntete();
            this.documentEntete.setVar_lib_nat("Cotation");
            this.documentEntete.setDocNum(var6.getCotNum());
            this.documentEntete.setDocSerie(var6.getCotSerie());
            this.documentEntete.setDocDate(var6.getCotDate());
            this.documentEntete.setDocCat(var6.getCotCat());
            this.documentEntete.setDocEtat(var6.getCotEtat());
            this.documentEntete.setDocNomTiers(var6.getCotNomTiers());
            this.documentEntete.setDocNomResponsable(var6.getCotNomResponsable());
            this.documentEntete.setDocNomCommercial("");
            this.documentEntete.setDocNomContact(var6.getCotNomContact());
            this.documentEntete.setDocObject(var6.getCotObject());
            this.documentEntete.setDocTotHt(var6.getCotTotHt());
            this.documentEntete.setDocTotReglement(0.0D);
            this.documentEntete.setDocTotTc(var6.getCotTotTc());
            this.documentEntete.setDocTotTtc(var6.getCotTotTtc());
            this.documentEntete.setDocTotTva(var6.getCotTotTva());
            this.lesDepenses.add(this.documentEntete);
         }
      }

      new ArrayList();
      List var14 = this.commandeEnteteAchatsDao.rechercheCommandeCampagne(var4, var1);
      if (var14.size() != 0) {
         new CommandeEnteteAchats();

         for(int var8 = 0; var8 < var14.size(); ++var8) {
            CommandeEnteteAchats var15 = (CommandeEnteteAchats)var14.get(var8);
            this.documentEntete = new DocumentEntete();
            this.documentEntete.setVar_lib_nat("Commande");
            this.documentEntete.setDocNum(var15.getCmdNum());
            this.documentEntete.setDocSerie(var15.getCmdSerie());
            this.documentEntete.setDocDate(var15.getCmdDate());
            this.documentEntete.setDocCat(var15.getCmdCat());
            this.documentEntete.setDocEtat(var15.getCmdEtat());
            this.documentEntete.setDocNomTiers(var15.getCmdNomTiers());
            this.documentEntete.setDocNomResponsable(var15.getCmdNomResponsable());
            this.documentEntete.setDocNomCommercial("");
            this.documentEntete.setDocNomContact(var15.getCmdNomContact());
            this.documentEntete.setDocObject(var15.getCmdObject());
            this.documentEntete.setDocTotHt(var15.getCmdTotHt());
            this.documentEntete.setDocTotReglement(var15.getCmdTotReglement());
            this.documentEntete.setDocTotTc(var15.getCmdTotTc());
            this.documentEntete.setDocTotTtc(var15.getCmdTotTtc());
            this.documentEntete.setDocTotTva(var15.getCmdTotTva());
            this.lesDepenses.add(this.documentEntete);
         }
      }

      new ArrayList();
      List var16 = this.receptionEnteteAchatsDao.rechercheReceptionCampagne(var4, var1);
      if (var16.size() != 0) {
         new ReceptionEnteteAchats();

         for(int var9 = 0; var9 < var16.size(); ++var9) {
            ReceptionEnteteAchats var17 = (ReceptionEnteteAchats)var16.get(var9);
            this.documentEntete = new DocumentEntete();
            this.documentEntete.setVar_lib_nat("Réception");
            this.documentEntete.setDocNum(var17.getRecNum());
            this.documentEntete.setDocSerie(var17.getRecSerie());
            this.documentEntete.setDocDate(var17.getRecDate());
            this.documentEntete.setDocCat(var17.getRecCat());
            this.documentEntete.setDocEtat(var17.getRecEtat());
            this.documentEntete.setDocNomTiers(var17.getRecNomTiers());
            this.documentEntete.setDocNomResponsable(var17.getRecNomResponsable());
            this.documentEntete.setDocNomCommercial("");
            this.documentEntete.setDocNomContact(var17.getRecNomContact());
            this.documentEntete.setDocObject(var17.getRecObject());
            this.documentEntete.setDocTotHt(var17.getRecTotHt());
            this.documentEntete.setDocTotReglement(var17.getRecTotReglement());
            this.documentEntete.setDocTotTc(var17.getRecTotTc());
            this.documentEntete.setDocTotTtc(var17.getRecTotTtc());
            this.documentEntete.setDocTotTva(var17.getRecTotTva());
            this.lesDepenses.add(this.documentEntete);
         }
      }

      new ArrayList();
      List var18 = this.factureEnteteAchatsDao.rechercheFactureCampagne(var4, var1);
      if (var18.size() != 0) {
         new FactureEnteteAchats();

         for(int var10 = 0; var10 < var18.size(); ++var10) {
            FactureEnteteAchats var19 = (FactureEnteteAchats)var18.get(var10);
            this.documentEntete = new DocumentEntete();
            this.documentEntete.setVar_lib_nat("Facture");
            this.documentEntete.setDocNum(var19.getFcfNum());
            this.documentEntete.setDocSerie(var19.getFcfSerie());
            this.documentEntete.setDocDate(var19.getFcfDate());
            this.documentEntete.setDocCat(var19.getFcfCat());
            this.documentEntete.setDocEtat(var19.getFcfEtat());
            this.documentEntete.setDocNomTiers(var19.getFcfNomTiers());
            this.documentEntete.setDocNomResponsable(var19.getFcfNomResponsable());
            this.documentEntete.setDocNomCommercial("");
            this.documentEntete.setDocNomContact(var19.getFcfNomContact());
            this.documentEntete.setDocObject(var19.getFcfObject());
            this.documentEntete.setDocTotHt(var19.getFcfTotHt());
            this.documentEntete.setDocTotReglement(var19.getFcfTotReglement());
            this.documentEntete.setDocTotTc(var19.getFcfTotTc());
            this.documentEntete.setDocTotTtc(var19.getFcfTotTtc());
            this.documentEntete.setDocTotTva(var19.getFcfTotTva());
            this.lesDepenses.add(this.documentEntete);
         }
      }

      new ArrayList();
      List var20 = this.noteDebitEnteteAchatsDao.rechercheNoteDebitCampagne(var4, var1);
      if (var20.size() != 0) {
         new NoteDebitEnteteAchats();

         for(int var11 = 0; var11 < var20.size(); ++var11) {
            NoteDebitEnteteAchats var21 = (NoteDebitEnteteAchats)var20.get(var11);
            this.documentEntete = new DocumentEntete();
            this.documentEntete.setVar_lib_nat("Note Débit");
            this.documentEntete.setDocNum(var21.getNdfNum());
            this.documentEntete.setDocSerie(var21.getNdfSerie());
            this.documentEntete.setDocDate(var21.getNdfDate());
            this.documentEntete.setDocCat(var21.getNdfCat());
            this.documentEntete.setDocEtat(var21.getNdfEtat());
            this.documentEntete.setDocNomTiers(var21.getNdfNomTiers());
            this.documentEntete.setDocNomResponsable(var21.getNdfNomResponsable());
            this.documentEntete.setDocNomCommercial("");
            this.documentEntete.setDocNomContact(var21.getNdfNomContact());
            this.documentEntete.setDocObject(var21.getNdfObject());
            this.documentEntete.setDocTotHt(var21.getNdfTotHt());
            this.documentEntete.setDocTotReglement(var21.getNdfTotReglement());
            this.documentEntete.setDocTotTc(var21.getNdfTotTc());
            this.documentEntete.setDocTotTtc(var21.getNdfTotTtc());
            this.documentEntete.setDocTotTva(var21.getNdfTotTva());
            this.lesDepenses.add(this.documentEntete);
         }
      }

      new ArrayList();
      List var22 = this.avoirEnteteAchatsDao.rechercheAvoirCampagne(var4, var1);
      int var12;
      if (var22.size() != 0) {
         new AvoirEnteteAchats();

         for(var12 = 0; var12 < var22.size(); ++var12) {
            AvoirEnteteAchats var23 = (AvoirEnteteAchats)var22.get(var12);
            this.documentEntete = new DocumentEntete();
            this.documentEntete.setVar_lib_nat("Avoir");
            this.documentEntete.setDocNum(var23.getAvfNum());
            this.documentEntete.setDocSerie(var23.getAvfSerie());
            this.documentEntete.setDocDate(var23.getAvfDate());
            this.documentEntete.setDocCat(var23.getAvfCat());
            this.documentEntete.setDocEtat(var23.getAvfEtat());
            this.documentEntete.setDocNomTiers(var23.getAvfNomTiers());
            this.documentEntete.setDocNomResponsable(var23.getAvfNomResponsable());
            this.documentEntete.setDocNomCommercial("");
            this.documentEntete.setDocNomContact(var23.getAvfNomContact());
            this.documentEntete.setDocObject(var23.getAvfObject());
            this.documentEntete.setDocTotHt(var23.getAvfTotHt() * -1.0D);
            this.documentEntete.setDocTotReglement(var23.getAvfTotReglement());
            this.documentEntete.setDocTotTc(var23.getAvfTotTc() * -1.0D);
            this.documentEntete.setDocTotTtc(var23.getAvfTotTtc() * -1.0D);
            this.documentEntete.setDocTotTva(var23.getAvfTotTva() * -1.0D);
            this.lesDepenses.add(this.documentEntete);
         }
      }

      new ArrayList();
      List var24 = this.reglementsDao.rechercheReglementCampagne(var4, var1);
      if (var24.size() != 0) {
         new Reglements();

         for(int var13 = 0; var13 < var24.size(); ++var13) {
            Reglements var25 = (Reglements)var24.get(var13);
            this.documentEntete = new DocumentEntete();
            this.documentEntete.setVar_lib_nat("Réglement");
            this.documentEntete.setDocNum(var25.getRglNum());
            this.documentEntete.setDocSerie(var25.getRglSerie());
            this.documentEntete.setDocDate(var25.getRglDateReg());
            this.documentEntete.setDocCat("" + var25.getRglCategorie());
            this.documentEntete.setDocEtat(0);
            this.documentEntete.setDocNomTiers(var25.getRglNomTiers());
            this.documentEntete.setDocNomResponsable(var25.getRglNomResponsable());
            this.documentEntete.setDocNomCommercial("");
            this.documentEntete.setDocNomContact("");
            this.documentEntete.setDocObject(var25.getRglObjet());
            this.documentEntete.setDocTotHt(0.0D);
            this.documentEntete.setDocTotReglement(var25.getRglDepense());
            this.documentEntete.setDocTotTc(0.0D);
            this.documentEntete.setDocTotTtc(0.0D);
            this.documentEntete.setDocTotTva(0.0D);
            this.lesDepenses.add(this.documentEntete);
         }
      }

      if (this.lesDepenses.size() != 0) {
         for(var12 = 0; var12 < this.lesDepenses.size(); ++var12) {
            if (((DocumentEntete)this.lesDepenses.get(var12)).getVar_lib_nat().equals("Facture") || ((DocumentEntete)this.lesDepenses.get(var12)).getVar_lib_nat().equals("Note Débit") || ((DocumentEntete)this.lesDepenses.get(var12)).getVar_lib_nat().equals("Avoir")) {
               this.totalDepenses += ((DocumentEntete)this.lesDepenses.get(var12)).getDocTotTtc();
            }
         }
      }

      this.dataModelDepenses.setWrappedData(this.lesDepenses);
   }

   public void chargerLesRecettes(Session var1) throws HibernateException, NamingException, ParseException {
      this.totalRecettes = 0.0D;
      this.lesRecettes.clear();
      String var2 = this.utilDate.dateToStringSQLLight(this.campagneEnteteVentes.getCamDateDebut()) + " 00:00:00";
      String var3 = this.utilDate.dateToStringSQLLight(this.campagneEnteteVentes.getCamDateFin()) + " 23:59:59";
      String var4 = this.campagneEnteteVentes.getCamNum() + ":";
      new ArrayList();
      List var5 = this.devisEnteteVentesDao.rechercheDevisCampagne(var2, var3, var4, var1);
      if (var5.size() != 0) {
         new DevisEnteteVentes();

         for(int var7 = 0; var7 < var5.size(); ++var7) {
            DevisEnteteVentes var6 = (DevisEnteteVentes)var5.get(var7);
            this.documentEntete = new DocumentEntete();
            this.documentEntete.setVar_lib_nat("Devis");
            this.documentEntete.setDocNum(var6.getDvsNum());
            this.documentEntete.setDocSerie(var6.getDvsSerie());
            this.documentEntete.setDocDate(var6.getDvsDate());
            this.documentEntete.setDocCat(var6.getDvsCat());
            this.documentEntete.setDocEtat(var6.getDvsEtat());
            this.documentEntete.setDocNomTiers(var6.getDvsNomTiers());
            this.documentEntete.setDocNomResponsable(var6.getDvsNomResponsable());
            this.documentEntete.setDocNomCommercial(var6.getDvsNomCommercial());
            this.documentEntete.setDocNomContact(var6.getDvsNomContact());
            this.documentEntete.setDocObject(var6.getDvsObject());
            this.documentEntete.setDocTotHt(var6.getDvsTotHt());
            this.documentEntete.setDocTotReglement(var6.getDvsTotReglement());
            this.documentEntete.setDocTotTc(var6.getDvsTotTc());
            this.documentEntete.setDocTotTtc(var6.getDvsTotTtc());
            this.documentEntete.setDocTotTva(var6.getDvsTotTva());
            this.lesRecettes.add(this.documentEntete);
         }
      }

      new ArrayList();
      List var13 = this.commandeEnteteVentesDao.rechercheCommandeCampagne(var2, var3, var4, var1);
      if (var13.size() != 0) {
         new CommandeEnteteVentes();

         for(int var8 = 0; var8 < var13.size(); ++var8) {
            CommandeEnteteVentes var14 = (CommandeEnteteVentes)var13.get(var8);
            this.documentEntete = new DocumentEntete();
            this.documentEntete.setVar_lib_nat("Commande");
            this.documentEntete.setDocNum(var14.getBcmNum());
            this.documentEntete.setDocSerie(var14.getBcmSerie());
            this.documentEntete.setDocDate(var14.getBcmDate());
            this.documentEntete.setDocCat(var14.getBcmCat());
            this.documentEntete.setDocEtat(var14.getBcmEtat());
            this.documentEntete.setDocNomTiers(var14.getBcmNomTiers());
            this.documentEntete.setDocNomResponsable(var14.getBcmNomResponsable());
            this.documentEntete.setDocNomCommercial(var14.getBcmNomCommercial());
            this.documentEntete.setDocNomContact(var14.getBcmNomContact());
            this.documentEntete.setDocObject(var14.getBcmObject());
            this.documentEntete.setDocTotHt(var14.getBcmTotHt());
            this.documentEntete.setDocTotReglement(var14.getBcmTotReglement());
            this.documentEntete.setDocTotTc(var14.getBcmTotTc());
            this.documentEntete.setDocTotTtc(var14.getBcmTotTtc());
            this.documentEntete.setDocTotTva(var14.getBcmTotTva());
            this.lesRecettes.add(this.documentEntete);
         }
      }

      new ArrayList();
      List var15 = this.livraisonEnteteVentesDao.rechercheLivraisonCampagne(var2, var3, var4, var1);
      if (var15.size() != 0) {
         new LivraisonEnteteVentes();

         for(int var9 = 0; var9 < var15.size(); ++var9) {
            LivraisonEnteteVentes var16 = (LivraisonEnteteVentes)var15.get(var9);
            this.documentEntete = new DocumentEntete();
            this.documentEntete.setVar_lib_nat("Livraison");
            this.documentEntete.setDocNum(var16.getBlvNum());
            this.documentEntete.setDocSerie(var16.getBlvSerie());
            this.documentEntete.setDocDate(var16.getBlvDate());
            this.documentEntete.setDocCat(var16.getBlvCat());
            this.documentEntete.setDocEtat(var16.getBlvEtat());
            this.documentEntete.setDocNomTiers(var16.getBlvNomTiers());
            this.documentEntete.setDocNomResponsable(var16.getBlvNomResponsable());
            this.documentEntete.setDocNomCommercial(var16.getBlvNomCommercial());
            this.documentEntete.setDocNomContact(var16.getBlvNomContact());
            this.documentEntete.setDocObject(var16.getBlvObject());
            this.documentEntete.setDocTotHt(var16.getBlvTotHt());
            this.documentEntete.setDocTotReglement(var16.getBlvTotReglement());
            this.documentEntete.setDocTotTc(var16.getBlvTotTc());
            this.documentEntete.setDocTotTtc(var16.getBlvTotTtc());
            this.documentEntete.setDocTotTva(var16.getBlvTotTva());
            this.lesRecettes.add(this.documentEntete);
         }
      }

      new ArrayList();
      List var17 = this.factureEnteteVentesDao.rechercheFactureCampagne(var2, var3, var4, var1);
      if (var17.size() != 0) {
         new FactureEnteteVentes();

         for(int var10 = 0; var10 < var17.size(); ++var10) {
            FactureEnteteVentes var18 = (FactureEnteteVentes)var17.get(var10);
            this.documentEntete = new DocumentEntete();
            this.documentEntete.setVar_lib_nat("Facture");
            this.documentEntete.setDocNum(var18.getFacNum());
            this.documentEntete.setDocSerie(var18.getFacSerie());
            this.documentEntete.setDocDate(var18.getFacDate());
            this.documentEntete.setDocCat(var18.getFacCat());
            this.documentEntete.setDocEtat(var18.getFacEtat());
            this.documentEntete.setDocNomTiers(var18.getFacNomTiers());
            this.documentEntete.setDocNomResponsable(var18.getFacNomResponsable());
            this.documentEntete.setDocNomCommercial(var18.getFacNomCommercial());
            this.documentEntete.setDocNomContact(var18.getFacNomContact());
            this.documentEntete.setDocObject(var18.getFacObject());
            this.documentEntete.setDocTotHt(var18.getFacTotHt());
            this.documentEntete.setDocTotReglement(var18.getFacTotReglement());
            this.documentEntete.setDocTotTc(var18.getFacTotTc());
            this.documentEntete.setDocTotTtc(var18.getFacTotTtc());
            this.documentEntete.setDocTotTva(var18.getFacTotTva());
            this.lesRecettes.add(this.documentEntete);
         }
      }

      new ArrayList();
      List var19 = this.noteDebitEnteteVentesDao.rechercheNoteDebitCampagne(var2, var3, var4, var1);
      int var11;
      if (var19.size() != 0) {
         new NoteDebitEnteteVentes();

         for(var11 = 0; var11 < var19.size(); ++var11) {
            NoteDebitEnteteVentes var20 = (NoteDebitEnteteVentes)var19.get(var11);
            this.documentEntete = new DocumentEntete();
            this.documentEntete.setVar_lib_nat("Note Débit");
            this.documentEntete.setDocNum(var20.getNdbNum());
            this.documentEntete.setDocSerie(var20.getNdbSerie());
            this.documentEntete.setDocDate(var20.getNdbDate());
            this.documentEntete.setDocCat(var20.getNdbCat());
            this.documentEntete.setDocEtat(var20.getNdbEtat());
            this.documentEntete.setDocNomTiers(var20.getNdbNomTiers());
            this.documentEntete.setDocNomResponsable(var20.getNdbNomResponsable());
            this.documentEntete.setDocNomCommercial(var20.getNdbNomCommercial());
            this.documentEntete.setDocNomContact(var20.getNdbNomContact());
            this.documentEntete.setDocObject(var20.getNdbObject());
            this.documentEntete.setDocTotHt(var20.getNdbTotHt());
            this.documentEntete.setDocTotReglement(var20.getNdbTotReglement());
            this.documentEntete.setDocTotTc(var20.getNdbTotTc());
            this.documentEntete.setDocTotTtc(var20.getNdbTotTtc());
            this.documentEntete.setDocTotTva(var20.getNdbTotTva());
            this.lesRecettes.add(this.documentEntete);
         }
      }

      new ArrayList();
      List var21 = this.avoirEnteteVentesDao.rechercheAvoirCampagne(var2, var3, var4, var1);
      if (var19.size() != 0) {
         new AvoirEnteteVentes();

         for(int var12 = 0; var12 < var21.size(); ++var12) {
            AvoirEnteteVentes var22 = (AvoirEnteteVentes)var21.get(var12);
            this.documentEntete = new DocumentEntete();
            this.documentEntete.setVar_lib_nat("Avoir");
            this.documentEntete.setDocNum(var22.getAvrNum());
            this.documentEntete.setDocSerie(var22.getAvrSerie());
            this.documentEntete.setDocDate(var22.getAvrDate());
            this.documentEntete.setDocCat(var22.getAvrCat());
            this.documentEntete.setDocEtat(var22.getAvrEtat());
            this.documentEntete.setDocNomTiers(var22.getAvrNomTiers());
            this.documentEntete.setDocNomResponsable(var22.getAvrNomResponsable());
            this.documentEntete.setDocNomCommercial(var22.getAvrNomCommercial());
            this.documentEntete.setDocNomContact(var22.getAvrNomContact());
            this.documentEntete.setDocObject(var22.getAvrObject());
            this.documentEntete.setDocTotHt(var22.getAvrTotHt() * -1.0D);
            this.documentEntete.setDocTotReglement(var22.getAvrTotReglement());
            this.documentEntete.setDocTotTc(var22.getAvrTotTc() * -1.0D);
            this.documentEntete.setDocTotTtc(var22.getAvrTotTtc() * -1.0D);
            this.documentEntete.setDocTotTva(var22.getAvrTotTva() * -1.0D);
            this.lesRecettes.add(this.documentEntete);
         }
      }

      if (this.lesRecettes.size() != 0) {
         for(var11 = 0; var11 < this.lesRecettes.size(); ++var11) {
            if (((DocumentEntete)this.lesRecettes.get(var11)).getVar_lib_nat().equals("Facture") || ((DocumentEntete)this.lesRecettes.get(var11)).getVar_lib_nat().equals("Note Débit") || ((DocumentEntete)this.lesRecettes.get(var11)).getVar_lib_nat().equals("Avoir")) {
               this.totalRecettes += ((DocumentEntete)this.lesRecettes.get(var11)).getDocTotTtc();
            }
         }
      }

      this.dataModelRecettes.setWrappedData(this.lesRecettes);
   }

   public void chargerLesParticipants(Session var1) throws HibernateException, NamingException {
      this.nbParticipants = 0;
      this.lesParticipants.clear();
      if (this.campagneEnteteVentes != null) {
         this.lesParticipants = this.campagneParticipantVentesDao.rechercheCampagneParticipant(this.campagneEnteteVentes, var1);
         this.nbParticipants = this.lesParticipants.size();
      }

      this.dataModelParticipants.setWrappedData(this.lesParticipants);
   }

   public void chargerLesMessages(Session var1) throws HibernateException, NamingException {
      this.lesMails.clear();
      this.lesSms.clear();
      if (this.campagneEnteteVentes != null) {
         new ArrayList();
         List var2 = this.campagneMessageVentesDao.rechercheCampagne(this.campagneEnteteVentes, var1);
         if (var2.size() != 0) {
            new CampagneMessageVentes();

            for(int var4 = 0; var4 < var2.size(); ++var4) {
               CampagneMessageVentes var3 = (CampagneMessageVentes)var2.get(var4);
               if (var3.getCammesType() == 1) {
                  this.lesMails.add(var3);
               } else if (var3.getCammesType() == 2) {
                  this.lesSms.add(var3);
               }
            }
         }
      }

      this.dataModelMail.setWrappedData(this.lesMails);
      this.dataModelSms.setWrappedData(this.lesSms);
   }

   public void ajoutDocument() throws ParseException, HibernateException, NamingException, JDOMException, IOException {
      this.campagneEnteteVentes = new CampagneEnteteVentes();
      this.var_date = new Date();
      if ((new Date()).getHours() <= 9) {
         this.var_heure = "0" + (new Date()).getHours();
      } else {
         this.var_heure = "" + (new Date()).getHours();
      }

      if ((new Date()).getMinutes() <= 9) {
         this.var_minute = "0" + (new Date()).getMinutes();
      } else {
         this.var_minute = "" + (new Date()).getMinutes();
      }

      if ((new Date()).getSeconds() <= 9) {
         this.var_seconde = "0" + (new Date()).getSeconds();
      } else {
         this.var_seconde = "" + (new Date()).getSeconds();
      }

      if (this.inpDu == null) {
         this.inpDu = this.utilDate.datePremierJourMois(new Date());
      }

      if (this.inpAu == null) {
         this.inpAu = this.utilDate.dateDernierJourMois(new Date());
      }

      this.var_aff_action = false;
      this.var_valide_doc = false;
      this.visibleOnglet = false;
      this.inpResponsable = "";
      this.inpCommercial = "";
      this.chargerCommerciauxResponsable((Session)null);
      this.chargerLesUsers((Session)null);
      this.lesDecoupagesActivites.clear();
      if (this.decoupageActivite) {
         this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
         this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
      }

      this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
      this.lesParticipants.clear();
      this.dataModelParticipants.setWrappedData(this.lesParticipants);
      this.lesDepenses.clear();
      this.dataModelDepenses.setWrappedData(this.lesDepenses);
      this.lesRecettes.clear();
      this.dataModelRecettes.setWrappedData(this.lesRecettes);
      this.lesMails.clear();
      this.lesSms.clear();
      this.dataModelMail.setWrappedData(this.lesMails);
      this.dataModelSms.setWrappedData(this.lesSms);
      this.var_action = 1;
      this.var_memo_action = this.var_action;
   }

   public void modifDocument() throws ParseException {
      if (this.campagneEnteteVentes != null) {
         this.var_action = 2;
         this.var_aff_action = false;
         this.var_valide_doc = true;
         this.visibleOnglet = true;
         this.var_memo_action = this.var_action;
      }

   }

   public void consultDocument() {
      if (this.campagneEnteteVentes != null) {
         this.var_action = 3;
         this.var_aff_action = true;
         this.var_valide_doc = true;
         this.visibleOnglet = true;
         this.var_memo_action = this.var_action;
      }

   }

   public void annuleDocument() {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.visibleOnglet = false;
      this.visibiliteBton = false;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public void save() throws IOException, NamingException, Exception {
      this.majAnalytique();
      this.verifieExistenceHabilitation((Session)null);
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "CampagneEntete");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.campagneEnteteVentes.setCamDate(this.utilDate.dateToSQL(this.var_date, this.var_heure, this.var_minute, this.var_seconde));
         if (this.campagneEnteteVentes.getCamDateDebut() == null) {
            this.campagneEnteteVentes.setCamDateDebut(new Date());
         }

         if (this.campagneEnteteVentes.getCamDateFin() == null) {
            this.campagneEnteteVentes.setCamDateFin(this.campagneEnteteVentes.getCamDateDebut());
         }

         if (this.campagneEnteteVentes.getUsers() == null) {
            this.campagneEnteteVentes.setUsers(this.usersLog);
         }

         this.campagneEnteteVentes.setCamIdResponsable(0L);
         this.campagneEnteteVentes.setCamNomResponsable("");
         new Users();
         if (this.var_nom_responsable == 0L && this.mesUsersItem.size() == 1) {
            this.var_nom_responsable = Long.parseLong(((SelectItem)this.mesUsersItem.get(0)).getValue().toString());
         }

         Users var3 = this.usersDao.selectUserD(this.var_nom_responsable, var1);
         if (var3 != null) {
            this.campagneEnteteVentes.setCamIdResponsable(var3.getUsrid());
            this.campagneEnteteVentes.setCamNomResponsable(var3.getUsrPatronyme());
         }

         this.campagneEnteteVentes.setCamIdCommercial(0L);
         this.campagneEnteteVentes.setCamNomCommercial("");
         if (this.optionsVentes.getResponsable().equals("1") || this.optionsVentes.getResponsable().equals("2")) {
            new Users();
            Users var4 = this.usersDao.selectUserD(this.var_nom_commercial, var1);
            if (var4 != null) {
               this.campagneEnteteVentes.setCamIdCommercial(var4.getUsrid());
               this.campagneEnteteVentes.setCamNomCommercial(var4.getUsrPatronyme());
            }
         }

         this.campagneEnteteVentes.setCamIdEquipe(0L);
         this.campagneEnteteVentes.setCamNomEquipe("");
         if (this.optionsVentes.getResponsable().equals("1")) {
            this.equipes = this.equipesDao.rechercheEquipes(this.campagneEnteteVentes.getCamIdResponsable(), var1);
            if (this.equipes != null) {
               this.campagneEnteteVentes.setCamIdEquipe(this.equipes.getEquId());
               this.campagneEnteteVentes.setCamNomEquipe(this.equipes.getEquNomFr());
            }
         }

         if (this.campagneEnteteVentes.getCamId() != 0L) {
            this.campagneEnteteVentes.setCamDateModif(new Date());
            this.campagneEnteteVentes.setCamIdModif(this.usersLog.getUsrid());
            this.campagneEnteteVentes.setCamNomModif(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.campagneEnteteVentes = this.campagneEnteteVentesDao.modif(this.campagneEnteteVentes, var1);
            this.var_action = 0;
            this.var_memo_action = this.var_action;
            this.visibleOnglet = false;
         } else {
            this.campagneEnteteVentes.setExerciceventes(this.exercicesVentes);
            this.campagneEnteteVentes.setCamDateCreat(new Date());
            this.campagneEnteteVentes.setCamIdCreateur(this.usersLog.getUsrid());
            this.campagneEnteteVentes.setCamNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            if (!this.campagneEnteteVentes.getCamSerie().equalsIgnoreCase("X") && !this.campagneEnteteVentes.getCamSerie().isEmpty()) {
               this.campagneEnteteVentes.setCamNum(this.calculChrono.numCompose(this.campagneEnteteVentes.getCamDate(), this.nature, this.campagneEnteteVentes.getCamSerie(), var1));
               boolean var16 = false;

               label212:
               while(true) {
                  while(true) {
                     if (var16) {
                        break label212;
                     }

                     new CampagneEnteteVentes();
                     CampagneEnteteVentes var5 = this.campagneEnteteVentesDao.pourParapheur(this.campagneEnteteVentes.getCamNum(), this.campagneEnteteVentes.getCamSerie(), var1);
                     if (var5 != null) {
                        long var6 = 100000000L * this.usersLog.getUsrid();

                        for(long var8 = 0L; var8 < var6; ++var8) {
                        }

                        this.campagneEnteteVentes.setCamNum(this.calculChrono.numCompose(this.campagneEnteteVentes.getCamDate(), this.nature, this.campagneEnteteVentes.getCamSerie(), var1));
                        var16 = false;
                     } else {
                        var16 = true;
                     }
                  }
               }
            } else {
               long var15 = this.campagneEnteteVentesDao.selectLastNum(var1);
               this.campagneEnteteVentes.setCamNum("" + var15);
            }

            this.campagneEnteteVentes.setCamEtat(0);
            this.campagneEnteteVentes.setCamEtatVal(0);
            this.campagneEnteteVentes.setCamDateValide((Date)null);
            this.campagneEnteteVentes = this.campagneEnteteVentesDao.insert(this.campagneEnteteVentes, var1);
            this.visibleOnglet = true;
            this.var_action = 1;
            this.var_memo_action = this.var_action;
            this.listCampagne.add(this.campagneEnteteVentes);
            this.datamodelCampagne.setWrappedData(this.listCampagne);
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
         }

         if (this.habilitation != null && this.var_action == 0) {
            this.utilParapheur.majParapheur(this.nature, this.habilitation, this.campagneEnteteVentes.getCamId(), this.campagneEnteteVentes.getCamNum(), this.campagneEnteteVentes.getCamNomResponsable(), this.campagneEnteteVentes.getCamDate(), this.structureLog.getStrdevise(), this.campagneEnteteVentes.getCamTotBudget(), this.campagneEnteteVentes.getCamModeleImp(), (Tiers)null, this.calculeCheminRapport(this.baseLog, this.nature), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(), (String)null, this.structureLog.getStrformatdevise(), 0, var1);
         }

         var2.commit();
      } catch (HibernateException var13) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var13;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void majAnalytique() throws HibernateException, NamingException {
      this.campagneEnteteVentes.setCamSite(this.usersLog.getUsrSite());
      this.campagneEnteteVentes.setCamDepartement(this.usersLog.getUsrDepartement());
      this.campagneEnteteVentes.setCamService(this.usersLog.getUsrService());
      if (!this.var_anal_activite) {
         this.campagneEnteteVentes.setCamActivite("");
      } else if (this.optionsVentes.getActiviteEnteteLigne().equals("0")) {
         if (this.decoupageActivite) {
            String var1 = "";
            boolean var2 = true;
            if (this.lesDecoupagesActivites.size() != 0) {
               for(int var3 = 0; var3 < this.lesDecoupagesActivites.size(); ++var3) {
                  this.ecrituresAnalytiqueCtrl = (EcrituresAnalytiqueCtrl)this.lesDecoupagesActivites.get(var3);
                  if (this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie() != 0.0D) {
                     if (var2) {
                        var1 = this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
                        var2 = false;
                     } else {
                        var1 = var1 + "#" + this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
                     }
                  }
               }
            }

            this.campagneEnteteVentes.setCamActivite(var1);
         }
      } else {
         this.campagneEnteteVentes.setCamActivite("");
      }

      if (this.var_anal_dossier == 0) {
         this.campagneEnteteVentes.setCamAnal4("");
      } else if (this.campagneEnteteVentes.getCamAnal4() != null && this.campagneEnteteVentes.getCamAnal4().length() <= 2) {
         this.campagneEnteteVentes.setCamAnal4("");
      }

      if (!this.var_anal_parc) {
         this.campagneEnteteVentes.setCamAnal2("");
      } else if (this.campagneEnteteVentes.getCamAnal2() != null && this.campagneEnteteVentes.getCamAnal2().length() <= 2) {
         this.campagneEnteteVentes.setCamAnal2("");
      }

   }

   public void supprimerDocument() throws ParseException {
      if (this.campagneEnteteVentes != null) {
      }

   }

   public void valideDocument() throws HibernateException, NamingException, ParseException {
      if (this.campagneEnteteVentes != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "CampagneEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.campagneEnteteVentes.getCamEtat() == 0 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
               this.campagneEnteteVentes.setCamEtat(1);
               this.campagneEnteteVentes = this.campagneEnteteVentesDao.modif(this.campagneEnteteVentes, var1);
               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Validation manuelle campagne (C.) N° " + this.campagneEnteteVentes.getCamNum() + " du " + this.utilDate.dateToStringSQLLight(this.campagneEnteteVentes.getCamDate()));
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

   public void deValideDocument() throws HibernateException, NamingException, ParseException {
      if (this.campagneEnteteVentes != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "CampagneEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.campagneEnteteVentes.getCamEtat() == 1) {
               this.campagneEnteteVentes.setCamEtat(0);
               this.campagneEnteteVentes.setCamDateImp((Date)null);
               this.campagneEnteteVentes = this.campagneEnteteVentesDao.modif(this.campagneEnteteVentes, var1);
               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Dévalidation manuelle campagne (C.) N° " + this.campagneEnteteVentes.getCamNum() + " du " + this.utilDate.dateToStringSQLLight(this.campagneEnteteVentes.getCamDate()));
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

   public void clotureCampagne() throws IOException, NamingException, Exception {
      if (this.campagneEnteteVentes != null && this.var_aff_action) {
         this.var_etat = this.campagneEnteteVentes.getCamEtat();
         this.campagneEnteteVentes.setCamEtat(this.var_etat);
         this.campagneEnteteVentes = this.campagneEnteteVentesDao.modif(this.campagneEnteteVentes);
         this.var_action = 0;
         this.var_memo_action = this.var_action;
         this.visibleOnglet = false;
         this.visibiliteBton = false;
      }

   }

   public void chargerDetailanalytique() {
      this.totalImputation = 0.0D;
      this.soldeImputation = 0.0D;
      this.lesDecoupagesActivites.clear();
      if (this.decoupageActivite && this.campagneEnteteVentes.getCamActivite() != null && !this.campagneEnteteVentes.getCamActivite().isEmpty() && this.campagneEnteteVentes.getCamActivite().contains(":")) {
         String[] var1 = null;
         if (!this.campagneEnteteVentes.getCamActivite().contains("#")) {
            var1 = this.campagneEnteteVentes.getCamActivite().split(":");
            if (var1.length == 8) {
               this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
               this.ecrituresAnalytiqueCtrl.setEcranaActivite(var1[0]);
               this.ecrituresAnalytiqueCtrl.setEcranaActiviteLib(var1[1]);
               this.ecrituresAnalytiqueCtrl.setZoneActivite(this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib());
               this.ecrituresAnalytiqueCtrl.setEcranaAnal1(var1[2]);
               this.ecrituresAnalytiqueCtrl.setEcranaAnal1Lib(var1[3]);
               this.ecrituresAnalytiqueCtrl.setZoneAnal1(this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib());
               this.ecrituresAnalytiqueCtrl.setEcranaAnal3(var1[4]);
               this.ecrituresAnalytiqueCtrl.setEcranaAnal3Lib(var1[5]);
               this.ecrituresAnalytiqueCtrl.setZoneAnal3(this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib());
               this.ecrituresAnalytiqueCtrl.setEcranaPourcentage(Float.parseFloat(var1[6]));
               this.ecrituresAnalytiqueCtrl.setEcranaMontantSaisie(Double.parseDouble(var1[7]));
               this.totalImputation += this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
               this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
            }
         } else {
            String[] var2 = this.campagneEnteteVentes.getCamActivite().split("#");

            for(int var3 = 0; var3 < var2.length; ++var3) {
               var1 = var2[var3].split(":");
               if (var1.length == 8) {
                  this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
                  this.ecrituresAnalytiqueCtrl.setEcranaActivite(var1[0]);
                  this.ecrituresAnalytiqueCtrl.setEcranaActiviteLib(var1[1]);
                  this.ecrituresAnalytiqueCtrl.setZoneActivite(this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib());
                  this.ecrituresAnalytiqueCtrl.setEcranaAnal1(var1[2]);
                  this.ecrituresAnalytiqueCtrl.setEcranaAnal1Lib(var1[3]);
                  this.ecrituresAnalytiqueCtrl.setZoneAnal1(this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib());
                  this.ecrituresAnalytiqueCtrl.setEcranaAnal3(var1[4]);
                  this.ecrituresAnalytiqueCtrl.setEcranaAnal3Lib(var1[5]);
                  this.ecrituresAnalytiqueCtrl.setZoneAnal3(this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib());
                  this.ecrituresAnalytiqueCtrl.setEcranaPourcentage(Float.parseFloat(var1[6]));
                  this.ecrituresAnalytiqueCtrl.setEcranaMontantSaisie(Double.parseDouble(var1[7]));
                  this.totalImputation += this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
                  this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
               }
            }
         }
      }

      this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
   }

   public void selectionAnalytique() {
      if (this.dataModelDecoupageActivtes.isRowAvailable()) {
         this.ecrituresAnalytiqueCtrl = (EcrituresAnalytiqueCtrl)this.dataModelDecoupageActivtes.getRowData();
      }

   }

   public void valideColonne1() {
      if (this.ecrituresAnalytiqueCtrl.getZoneActivite() != null && !this.ecrituresAnalytiqueCtrl.getZoneActivite().isEmpty() && this.ecrituresAnalytiqueCtrl.getZoneActivite().contains(":")) {
         String[] var1 = this.ecrituresAnalytiqueCtrl.getZoneActivite().split(":");
         this.ecrituresAnalytiqueCtrl.setEcranaActivite(var1[0]);
         this.ecrituresAnalytiqueCtrl.setEcranaActiviteLib(var1[1]);
      }

   }

   public void valideColonne2() {
      if (this.ecrituresAnalytiqueCtrl.getZoneAnal1() != null && !this.ecrituresAnalytiqueCtrl.getZoneAnal1().isEmpty() && this.ecrituresAnalytiqueCtrl.getZoneAnal1().contains(":")) {
         String[] var1 = this.ecrituresAnalytiqueCtrl.getZoneAnal1().split(":");
         this.ecrituresAnalytiqueCtrl.setEcranaAnal1(var1[0]);
         this.ecrituresAnalytiqueCtrl.setEcranaAnal1Lib(var1[1]);
      }

   }

   public void valideColonne3() {
      if (this.ecrituresAnalytiqueCtrl.getZoneAnal3() != null && !this.ecrituresAnalytiqueCtrl.getZoneAnal3().isEmpty() && this.ecrituresAnalytiqueCtrl.getZoneAnal3().contains(":")) {
         String[] var1 = this.ecrituresAnalytiqueCtrl.getZoneAnal3().split(":");
         this.ecrituresAnalytiqueCtrl.setEcranaAnal3(var1[0]);
         this.ecrituresAnalytiqueCtrl.setEcranaAnal3Lib(var1[1]);
      }

   }

   public void calculPourcentage() {
      if (this.ecrituresAnalytiqueCtrl != null && this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() != 0.0F) {
         double var1 = this.utilNombre.myRoundDevise((this.campagneEnteteVentes.getCamTotDepense() - this.campagneEnteteVentes.getCamTotRecette()) * (double)this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() / 100.0D, this.structureLog.getStrdevise());
         this.ecrituresAnalytiqueCtrl.setEcranaMontantSaisie(var1);
      }

   }

   public void supprimerAnalytique() {
      if (this.ecrituresAnalytiqueCtrl == null) {
         this.selectionAnalytique();
      }

      if (this.ecrituresAnalytiqueCtrl != null) {
         this.lesDecoupagesActivites.remove(this.ecrituresAnalytiqueCtrl);
         this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
         this.ecrituresAnalytiqueCtrl = null;
      }

      if (this.lesDecoupagesActivites.size() == 0) {
         this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
         this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
         this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
      }

   }

   public void controleEcartAnalytique() {
      this.totalImputation = 0.0D;
      this.soldeImputation = 0.0D;
      float var1 = 0.0F;
      if (this.lesDecoupagesActivites.size() != 0) {
         for(int var2 = 0; var2 < this.lesDecoupagesActivites.size(); ++var2) {
            this.totalImputation += ((EcrituresAnalytiqueCtrl)this.lesDecoupagesActivites.get(var2)).getEcranaMontantSaisie();
            var1 += ((EcrituresAnalytiqueCtrl)this.lesDecoupagesActivites.get(var2)).getEcranaPourcentage();
         }
      }

      this.soldeImputation = this.campagneEnteteVentes.getCamTotDepense() - this.campagneEnteteVentes.getCamTotRecette() - this.totalImputation;
      if (this.soldeImputation > 0.0D) {
         this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
         if (var1 != 0.0F) {
            this.ecrituresAnalytiqueCtrl.setEcranaPourcentage(100.0F - var1);
         }

         this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
         this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
      }

   }

   public void annulerDocument() {
      if (this.campagneEnteteVentes != null) {
         this.campagneEnteteVentes.setCamDateAnnule(new Date());
         this.showModalPanelAnnuler = true;
      }

   }

   public void annuleAnnulation() {
      this.showModalPanelAnnuler = false;
   }

   public void miseajourAnnuler() throws HibernateException, NamingException {
      if (this.campagneEnteteVentes != null) {
         if (this.campagneEnteteVentes.getCamDateAnnule() == null) {
            this.campagneEnteteVentes.setCamDateAnnule(new Date());
         }

         this.campagneEnteteVentes.setCamEtat(3);
         this.campagneEnteteVentes = this.campagneEnteteVentesDao.modif(this.campagneEnteteVentes);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         var1.setEspaction("Annulation campagne vente N° " + this.campagneEnteteVentes.getCamNum() + " le " + this.campagneEnteteVentes.getCamDateAnnule());
         this.espionDao.mAJEspion(var1);
         this.listCampagne.remove(this.campagneEnteteVentes);
         this.datamodelCampagne.setWrappedData(this.listCampagne);
      }

      this.showModalPanelAnnuler = false;
      this.visibiliteBton = false;
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
   }

   public void selectionAction() {
      if (this.datamodelActions.isRowAvailable()) {
         this.campagneActionVentes = (CampagneActionVentes)this.datamodelActions.getRowData();
         this.visibiliteBtonActions = true;
      }

   }

   public void ajouterAction() {
      this.campagneActionVentes = new CampagneActionVentes();
      this.campagneActionVentes.setCamactIdCreateur(this.usersLog.getUsrid());
      this.campagneActionVentes.setCamactNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.campagneActionVentes.setCamactDate(new Date());
      this.showModalPanelActions = true;
   }

   public void modifierAction() {
      if (this.campagneActionVentes != null) {
         this.showModalPanelActions = true;
      }

   }

   public void consulterAction() {
      if (this.campagneActionVentes != null) {
         this.showModalPanelActions = true;
      }

   }

   public void supprimerAction() throws HibernateException, NamingException {
      if (this.campagneActionVentes != null) {
         this.campagneActionVentesDao.delete(this.campagneActionVentes);
         this.listActions.remove(this.campagneActionVentes);
         this.datamodelActions.setWrappedData(this.listActions);
         this.visibiliteBtonActions = false;
      }

   }

   public void fermerAction() {
      this.visibiliteBtonActions = false;
      this.showModalPanelActions = false;
   }

   public void validerAction() throws HibernateException, NamingException {
      this.campagneActionVentes.setCamactNomCommercial((String)null);
      if (this.campagneActionVentes.getCamactIdCommercial() != 0L) {
         new Users();
         Users var1 = this.usersDao.selectLeUserId(this.campagneActionVentes.getCamactIdCommercial(), (Session)null);
         if (var1 != null) {
            this.campagneActionVentes.setCamactNomCommercial(var1.getUsrPatronyme());
         }
      }

      if (this.campagneActionVentes.getCamactId() == 0L) {
         this.campagneActionVentes.setCamactDateCreat(new Date());
         this.campagneActionVentes.setCamactNomCreateur(this.usersLog.getUsrPatronyme());
         this.campagneActionVentes.setCampagneEnteteVentes(this.campagneEnteteVentes);
         this.campagneActionVentes = this.campagneActionVentesDao.insert(this.campagneActionVentes);
         this.listActions.add(this.campagneActionVentes);
         this.datamodelActions.setWrappedData(this.listActions);
      } else {
         this.campagneActionVentes.setCamactDateModif(new Date());
         this.campagneActionVentes.setCamactNomModif(this.usersLog.getUsrPatronyme());
         this.campagneActionVentes = this.campagneActionVentesDao.modif(this.campagneActionVentes);
      }

      this.showModalPanelActions = false;
   }

   public void selectionParticipant() {
      if (this.dataModelParticipants.isRowAvailable()) {
         this.campagneParticipantVentes = (CampagneParticipantVentes)this.dataModelParticipants.getRowData();
         this.var_date = this.campagneParticipantVentes.getCamparDate();
         this.tiers = this.campagneParticipantVentes.getContacts().getTiers();
         this.contacts = this.campagneParticipantVentes.getContacts();
         this.var_participant = this.contacts.getConcivilite() + " " + this.contacts.getConpatronyme();
         if (this.campagneParticipantVentes.getCamparDate().getHours() <= 9) {
            this.var_heure = "0" + this.campagneParticipantVentes.getCamparDate().getHours();
         } else {
            this.var_heure = "" + this.campagneParticipantVentes.getCamparDate().getHours();
         }

         if (this.campagneParticipantVentes.getCamparDate().getMinutes() <= 9) {
            this.var_minute = "0" + this.campagneParticipantVentes.getCamparDate().getMinutes();
         } else {
            this.var_minute = "" + this.campagneParticipantVentes.getCamparDate().getMinutes();
         }

         if (this.campagneParticipantVentes.getCamparDate().getSeconds() <= 9) {
            this.var_seconde = "0" + this.campagneParticipantVentes.getCamparDate().getSeconds();
         } else {
            this.var_seconde = "" + this.campagneParticipantVentes.getCamparDate().getSeconds();
         }

         this.visibiliteBtonParticipant = true;
      }

   }

   public void ajouterParticipant() {
      this.tiers = new Tiers();
      this.contacts = new Contacts();
      this.campagneParticipantVentes = new CampagneParticipantVentes();
      this.campagneParticipantVentes.setCamparIdCreateur(this.usersLog.getUsrid());
      this.campagneParticipantVentes.setCamparNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.campagneParticipantVentes.setCamparDate(new Date());
      this.var_date = new Date();
      if ((new Date()).getHours() <= 9) {
         this.var_heure = "0" + (new Date()).getHours();
      } else {
         this.var_heure = "" + (new Date()).getHours();
      }

      if ((new Date()).getMinutes() <= 9) {
         this.var_minute = "0" + (new Date()).getMinutes();
      } else {
         this.var_minute = "" + (new Date()).getMinutes();
      }

      if ((new Date()).getSeconds() <= 9) {
         this.var_seconde = "0" + (new Date()).getSeconds();
      } else {
         this.var_seconde = "" + (new Date()).getSeconds();
      }

      this.var_participant = "";
      this.showModalPanelParticipant = true;
   }

   public void modifierParticipant() {
      if (this.campagneParticipantVentes != null) {
         this.showModalPanelParticipant = true;
      }

   }

   public void consulterParticipant() {
      if (this.campagneParticipantVentes != null) {
         this.showModalPanelParticipant = true;
      }

   }

   public void supprimerParticipant() throws HibernateException, NamingException {
      if (this.campagneParticipantVentes != null) {
         this.campagneParticipantVentesDao.delete(this.campagneParticipantVentes);
         this.lesParticipants.remove(this.campagneParticipantVentes);
         this.dataModelParticipants.setWrappedData(this.lesParticipants);
         if (this.lesParticipants.size() != 0) {
            this.nbParticipants = this.lesParticipants.size();
         } else {
            this.nbParticipants = 0;
         }

         this.visibiliteBtonParticipant = false;
      }

   }

   public void supprimerGroupeParticipant() throws HibernateException, NamingException {
      if (this.lesParticipants.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "CampagneEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            int var3 = 0;

            while(true) {
               if (var3 >= this.lesParticipants.size()) {
                  var2.commit();
                  break;
               }

               this.campagneParticipantVentes = (CampagneParticipantVentes)this.lesParticipants.get(var3);
               this.campagneParticipantVentesDao.delete(this.campagneParticipantVentes, var1);
               ++var3;
            }
         } catch (HibernateException var7) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var7;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.lesParticipants.clear();
         this.dataModelParticipants.setWrappedData(this.lesParticipants);
         this.calculRepartitionCommercial();
      }

   }

   public void fermerParticipant() {
      this.visibiliteBtonParticipant = false;
      this.showModalPanelParticipant = false;
      this.showModalPanelGroupe = false;
   }

   public void validerParticipant() throws HibernateException, NamingException, ParseException {
      this.campagneParticipantVentes.setCamparIdTiers(this.campagneParticipantVentes.getContacts().getTiers().getTieid());
      this.campagneParticipantVentes.setCamparNomTiers(this.campagneParticipantVentes.getContacts().getTiers().getTieraisonsocialenom());
      this.campagneParticipantVentes.setCamparDate(this.utilDate.dateToSQL(this.var_date, this.var_heure, this.var_minute, this.var_seconde));
      if (this.campagneParticipantVentes.getCamparIdCommercial() != 0L) {
         new Users();
         Users var1 = this.usersDao.selectByIdUsers(this.campagneParticipantVentes.getCamparIdCommercial(), (Session)null);
         if (var1 != null) {
            this.campagneParticipantVentes.setCamparNomCommercial(var1.getUsrPatronyme());
         } else {
            this.campagneParticipantVentes.setCamparNomCommercial((String)null);
         }
      } else {
         this.campagneParticipantVentes.setCamparNomCommercial((String)null);
      }

      if (this.campagneParticipantVentes.getCamparId() == 0L) {
         this.campagneParticipantVentes.setCamparDateCreat(new Date());
         this.campagneParticipantVentes.setCamparNomCreateur(this.usersLog.getUsrPatronyme());
         this.campagneParticipantVentes.setCampagneEnteteVentes(this.campagneEnteteVentes);
         this.campagneParticipantVentes = this.campagneParticipantVentesDao.insert(this.campagneParticipantVentes);
         this.lesParticipants.add(this.campagneParticipantVentes);
         this.dataModelParticipants.setWrappedData(this.lesParticipants);
         this.nbParticipants = this.lesParticipants.size();
      } else {
         this.campagneParticipantVentes.setCamparDateModif(new Date());
         this.campagneParticipantVentes.setCamparNomModif(this.usersLog.getUsrPatronyme());
         this.campagneParticipantVentes = this.campagneParticipantVentesDao.modif(this.campagneParticipantVentes);
      }

      this.calculRepartitionCommercial();
      this.visibiliteBtonParticipant = false;
      this.showModalPanelParticipant = false;
   }

   public void controleSaisie() {
   }

   public void ajouterGroupe() throws IOException, HibernateException, NamingException {
      this.nomRec = "";
      this.villeRec = "";
      this.mailRec = "";
      this.lesGroupesParticipants.clear();
      this.dataModelGroupe.setWrappedData(this.lesGroupesParticipants);
      this.recupererCategorieItem("XXX");
      this.recupererAppreciationItem();
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
      TiersDao var2 = new TiersDao(this.baseLog, this.utilInitHibernate);
      this.mesActivitesSocietesItems.clear();
      this.mesActivitesSocietesItems = var2.chargerLesActivitesUtilisees(7, false, var1);
      this.mesObservationsItems.clear();
      this.mesObservationsItems = var2.chargerLesObservationsUtilisees(7, false, var1);
      this.mesPaysItems.clear();
      this.mesPaysItems = var2.chargerLesPaysUtilisees(7, false, var1);
      this.utilInitHibernate.closeSession();
      this.showModalPanelGroupe = true;
   }

   public void validerGroupe() throws HibernateException, NamingException {
      if (this.campagneEnteteVentes != null && this.lesGroupesParticipants.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "CampagneEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.lesGroupesParticipants.size(); ++var3) {
               this.contacts = (Contacts)this.lesGroupesParticipants.get(var3);
               if (this.contacts.isSelect()) {
                  this.campagneParticipantVentes = new CampagneParticipantVentes();
                  this.campagneParticipantVentes.setCampagneEnteteVentes(this.campagneEnteteVentes);
                  this.campagneParticipantVentes.setContacts(this.contacts);
                  this.campagneParticipantVentes.setCamparDateCreat(new Date());
                  this.campagneParticipantVentes.setCamparIdCreateur(this.usersLog.getUsrid());
                  this.campagneParticipantVentes.setCamparNomCreateur(this.usersLog.getUsrPatronyme());
                  this.campagneParticipantVentes.setCamparIdTiers(this.contacts.getTiers().getTieid());
                  this.campagneParticipantVentes.setCamparNomTiers(this.contacts.getTiers().getTieraisonsocialenom());
                  this.campagneParticipantVentes.setCamparDate(new Date());
                  this.campagneParticipantVentes = this.campagneParticipantVentesDao.insert(this.campagneParticipantVentes, var1);
                  this.lesParticipants.add(this.campagneParticipantVentes);
               }
            }

            this.dataModelParticipants.setWrappedData(this.lesParticipants);
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

      this.showModalPanelGroupe = false;
   }

   public void chargerLesTiers() throws HibernateException, NamingException {
      this.lesGroupesParticipants.clear();
      this.lesGroupesParticipants = this.contactDao.listeContacts(this.rechercherContacts(), (Session)null);
      this.dataModelGroupe.setWrappedData(this.lesGroupesParticipants);
   }

   public String rechercherContacts() {
      String var1 = "from Contacts where ((connom is not null and connom<>'') or (conservice is not null and conservice<>'')) and connom<>'*' and connom<>'**' and connom<>'-' and connom<>'--' and connom<>'.' and connom<>'..'";
      var1 = var1 + " and (tiers.tietype='1' or tiers.tietype='2' or tiers.tietype='3')";
      var1 = var1 + "and tiers.tieetat=0";
      if (this.nomRec != null && !this.nomRec.isEmpty()) {
         var1 = var1 + " and tiers.tieraisonsocialenom LIKE" + "'%" + this.nomRec + "%'";
      }

      if (this.villeRec != null && !this.villeRec.isEmpty()) {
         var1 = var1 + " and tiers.tieville like '" + this.villeRec + "%' or conville like '" + this.villeRec + "%'";
      }

      if (this.fonctionRec != null && !this.fonctionRec.isEmpty()) {
         var1 = var1 + " and confonction LIKE '%" + this.fonctionRec + "%'";
      }

      if (this.paysRec != null && !this.paysRec.isEmpty() && !this.paysRec.equals("100")) {
         var1 = var1 + " and tiers.tienompays= '" + this.paysRec + "' or connompays ='" + this.paysRec + "'";
      }

      if (this.activitesRec != null && !this.activitesRec.isEmpty() && !this.activitesRec.equals("100")) {
         var1 = var1 + " and tiers.tieactivite1= '" + this.activitesRec + "'";
      }

      if (this.observationsRec != null && !this.observationsRec.isEmpty() && !this.observationsRec.equals("100")) {
         var1 = var1 + " and tiers.tieobservations= '" + this.observationsRec + "'";
      }

      if (this.appreciationRec != null && !this.appreciationRec.isEmpty() && !this.appreciationRec.equals("100")) {
         var1 = var1 + " and tienotemban= '" + this.appreciationRec + "' or conappreciation= '" + this.appreciationRec + "'";
      }

      if (this.categorieRec != null && !this.categorieRec.isEmpty() && !this.categorieRec.equals("100")) {
         var1 = var1 + " and tiers.tiecategorie= '" + this.categorieRec + "'";
      }

      if (this.familleRec != null && !this.familleRec.isEmpty() && !this.familleRec.equals("100")) {
         var1 = var1 + " and tiers.tienomfamille= '" + this.familleRec + "'";
      }

      if (this.pdvRec != null && !this.pdvRec.isEmpty() && !this.pdvRec.equals("100")) {
         var1 = var1 + " and tiers.tiepdv= '" + this.pdvRec + "'";
      }

      if (this.mailRec != null && !this.mailRec.isEmpty()) {
         var1 = var1 + " and (conmail1 LIKE '%" + this.mailRec + "%' or conmail2 LIKE '%" + this.mailRec + "%' or conmail3 LIKE '%" + this.mailRec + "%' or conmail4 LIKE '%" + this.mailRec + "%' or conmail5 LIKE '%" + this.mailRec + "%')";
      }

      return var1;
   }

   public void selectionGroupe() {
   }

   public void toutSelectionner() {
      if (this.lesGroupesParticipants.size() != 0) {
         for(int var1 = 0; var1 < this.lesGroupesParticipants.size(); ++var1) {
            this.contacts = (Contacts)this.lesGroupesParticipants.get(var1);
            this.contacts.setSelect(true);
         }

         this.dataModelGroupe.setWrappedData(this.lesGroupesParticipants);
      }

   }

   public void toutSelectionnerMail() {
      if (this.lesGroupesParticipants.size() != 0) {
         for(int var1 = 0; var1 < this.lesGroupesParticipants.size(); ++var1) {
            this.contacts = (Contacts)this.lesGroupesParticipants.get(var1);
            if (this.contacts.getConmail1() != null && !this.contacts.getConmail1().isEmpty()) {
               this.contacts.setSelect(true);
            }
         }

         this.dataModelGroupe.setWrappedData(this.lesGroupesParticipants);
      }

   }

   public void toutSelectionnerMobile() {
      if (this.lesGroupesParticipants.size() != 0) {
         for(int var1 = 0; var1 < this.lesGroupesParticipants.size(); ++var1) {
            this.contacts = (Contacts)this.lesGroupesParticipants.get(var1);
            if (this.contacts.getConcel1() != null && !this.contacts.getConcel1().isEmpty()) {
               this.contacts.setSelect(true);
            }
         }

         this.dataModelGroupe.setWrappedData(this.lesGroupesParticipants);
      }

   }

   public void rienSelectionner() {
      if (this.lesGroupesParticipants.size() != 0) {
         for(int var1 = 0; var1 < this.lesGroupesParticipants.size(); ++var1) {
            this.contacts = (Contacts)this.lesGroupesParticipants.get(var1);
            this.contacts.setSelect(false);
         }

         this.dataModelGroupe.setWrappedData(this.lesGroupesParticipants);
      }

   }

   public void calculRepartitionCommercial() {
      this.resumeCommercial.clear();
      if (this.lesParticipants.size() != 0) {
         for(int var1 = 0; var1 < this.lesParticipants.size(); ++var1) {
            if (this.resumeCommercial.size() == 0) {
               this.objetGraph = new ObjetGraph();
               this.objetGraph.setNomSerie(((CampagneParticipantVentes)this.lesParticipants.get(var1)).getCamparNomCommercial());
               this.objetGraph.setV01(((CampagneParticipantVentes)this.lesParticipants.get(var1)).getCamparIdCommercial());
               this.objetGraph.setV02(1L);
               this.resumeCommercial.add(this.objetGraph);
            } else {
               boolean var2 = false;

               for(int var3 = 0; var3 < this.resumeCommercial.size(); ++var3) {
                  this.objetGraph = (ObjetGraph)this.resumeCommercial.get(var3);
                  if (this.objetGraph.getV01() == ((CampagneParticipantVentes)this.lesParticipants.get(var1)).getCamparIdCommercial()) {
                     var2 = true;
                     break;
                  }
               }

               if (var2 && this.objetGraph != null) {
                  this.objetGraph.setV02(this.objetGraph.getV02() + 1L);
               } else {
                  this.objetGraph = new ObjetGraph();
                  this.objetGraph.setNomSerie(((CampagneParticipantVentes)this.lesParticipants.get(var1)).getCamparNomCommercial());
                  this.objetGraph.setV01(((CampagneParticipantVentes)this.lesParticipants.get(var1)).getCamparIdCommercial());
                  this.objetGraph.setV02(1L);
                  this.resumeCommercial.add(this.objetGraph);
               }
            }
         }

         if (this.resumeCommercial.size() != 0) {
            float var5 = (float)this.lesParticipants.size();

            for(int var6 = 0; var6 < this.resumeCommercial.size(); ++var6) {
               this.objetGraph = (ObjetGraph)this.resumeCommercial.get(var6);
               float var7 = (float)this.objetGraph.getV02();
               float var4 = var7 / var5 * 100.0F;
               this.objetGraph.setVpourcent(var4);
            }
         }
      }

   }

   public void selectionMail() {
      if (this.dataModelMail.isRowAvailable()) {
         this.campagneMessageVentesMail = (CampagneMessageVentes)this.dataModelMail.getRowData();
         this.visibiliteBtonMail = true;
      }

   }

   public void ajouterMail() {
      this.campagneMessageVentesMail = new CampagneMessageVentes();
      this.campagneMessageVentesMail.setCammesDate(new Date());
      this.var_aff_action = false;
      this.showModalPanelMessageMail = true;
   }

   public void modifierMail() {
      if (this.campagneMessageVentesMail != null) {
         this.var_aff_action = false;
         this.showModalPanelMessageMail = true;
      }

   }

   public void consulterMail() {
      if (this.campagneMessageVentesMail != null) {
         this.var_aff_action = true;
         this.showModalPanelMessageMail = true;
      }

   }

   public void supprimerMail() throws HibernateException, NamingException {
      if (this.campagneMessageVentesMail != null) {
         this.campagneMessageVentesDao.delete(this.campagneMessageVentesMail);
         this.lesMails.remove(this.campagneMessageVentesMail);
         this.dataModelMail.setWrappedData(this.lesMails);
         this.visibiliteBtonMail = false;
      }

   }

   public void fermerMail() {
      this.visibiliteBtonMail = false;
      this.showModalPanelMessageMail = false;
   }

   public void validerMail() throws HibernateException, NamingException {
      if (this.campagneMessageVentesMail.getCammesId() == 0L) {
         this.campagneMessageVentesMail.setCampagneEnteteVentes(this.campagneEnteteVentes);
         this.campagneMessageVentesMail.setCammesDateCreat(new Date());
         this.campagneMessageVentesMail.setCammesIdCreateur(this.usersLog.getUsrid());
         this.campagneMessageVentesMail.setCammesType(1);
         this.campagneMessageVentesMail = this.campagneMessageVentesDao.insert(this.campagneMessageVentesMail);
         this.lesMails.add(this.campagneMessageVentesMail);
         this.dataModelMail.setWrappedData(this.lesMails);
      } else {
         this.campagneMessageVentesMail.setCammesDateModif(new Date());
         this.campagneMessageVentesMail.setCammesIdModif(this.usersLog.getUsrid());
         this.campagneMessageVentesMail = this.campagneMessageVentesDao.modif(this.campagneMessageVentesMail);
      }

      this.visibiliteBtonMail = false;
      this.showModalPanelMessageMail = false;
   }

   public void envoyerMail() throws HibernateException, NamingException, Exception {
      if (this.campagneMessageVentesMail != null) {
         if (this.lesParticipants.size() != 0) {
            UtilMail var1 = new UtilMail(this.structureLog);
            String var2 = "";
            new Bal();
            Bal var3 = var1.calculBalEmetteur((String)null, 0);
            String var4 = var3.getBaladressemail();
            int var5 = 0;

            while(true) {
               if (var5 >= this.lesParticipants.size()) {
                  var1.sendMail(this.campagneMessageVentesMail.getCammesMessage(), (String)null, (String)null, var2, var4, (String)null, this.campagneMessageVentesMail.getCammesObjet(), var3);
                  this.campagneMessageVentesSms.setCammesEtat(1);
                  this.campagneMessageVentesSms = this.campagneMessageVentesDao.modif(this.campagneMessageVentesSms);
                  break;
               }

               this.campagneParticipantVentes = (CampagneParticipantVentes)this.lesParticipants.get(var5);
               if (this.campagneParticipantVentes.getContacts().getConmail1() != null && !this.campagneParticipantVentes.getContacts().getConmail1().isEmpty()) {
                  if (var2 == null && var2.isEmpty()) {
                     var2 = this.campagneParticipantVentes.getContacts().getConmail1();
                  } else {
                     var2 = var2 + "," + this.campagneParticipantVentes.getContacts().getConmail1();
                  }
               }

               ++var5;
            }
         }

         this.visibiliteBtonMail = false;
      }

   }

   public void selectionSms() {
      if (this.dataModelSms.isRowAvailable()) {
         this.campagneMessageVentesSms = (CampagneMessageVentes)this.dataModelSms.getRowData();
         this.visibiliteBtonSms = true;
      }

   }

   public void ajouterSms() {
      this.campagneMessageVentesSms = new CampagneMessageVentes();
      this.campagneMessageVentesSms.setCammesDate(new Date());
      this.var_aff_action = false;
      this.showModalPanelMessageSMS = true;
   }

   public void modifierSms() {
      if (this.campagneMessageVentesSms != null) {
         this.var_aff_action = false;
         this.showModalPanelMessageSMS = true;
      }

   }

   public void consulterSms() {
      if (this.campagneMessageVentesSms != null) {
         this.var_aff_action = true;
         this.showModalPanelMessageSMS = true;
      }

   }

   public void supprimerSms() throws HibernateException, NamingException {
      if (this.campagneMessageVentesSms != null) {
         this.campagneMessageVentesDao.delete(this.campagneMessageVentesSms);
         this.lesSms.remove(this.campagneMessageVentesSms);
         this.dataModelSms.setWrappedData(this.lesSms);
         this.visibiliteBtonSms = false;
      }

   }

   public void fermerSms() {
      this.visibiliteBtonSms = false;
      this.showModalPanelMessageSMS = false;
   }

   public void validerSms() throws HibernateException, NamingException {
      if (this.campagneMessageVentesSms.getCammesId() == 0L) {
         this.campagneMessageVentesSms.setCampagneEnteteVentes(this.campagneEnteteVentes);
         this.campagneMessageVentesSms.setCammesDateCreat(new Date());
         this.campagneMessageVentesSms.setCammesIdCreateur(this.usersLog.getUsrid());
         this.campagneMessageVentesSms.setCammesType(2);
         this.campagneMessageVentesSms = this.campagneMessageVentesDao.insert(this.campagneMessageVentesSms);
         this.lesSms.add(this.campagneMessageVentesSms);
         this.dataModelSms.setWrappedData(this.lesSms);
      } else {
         this.campagneMessageVentesSms.setCammesDateModif(new Date());
         this.campagneMessageVentesSms.setCammesIdModif(this.usersLog.getUsrid());
         this.campagneMessageVentesSms = this.campagneMessageVentesDao.modif(this.campagneMessageVentesSms);
      }

      this.visibiliteBtonSms = false;
      this.showModalPanelMessageSMS = false;
   }

   public void envoyerSms() throws IOException, HibernateException, NamingException, SQLException {
      if (this.campagneMessageVentesSms != null) {
         if (this.lesParticipants.size() != 0) {
            UtilSms var1 = new UtilSms(this.utilInitHibernate, this.structureLog, this.usersLog, this.baseLog);
            SmsDao var2 = new SmsDao(this.baseLog, this.utilInitHibernate);
            Sms var3 = new Sms();
            ArrayList var4 = new ArrayList();
            String var5 = "";
            Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "Sms");
            Transaction var7 = null;

            try {
               var7 = var6.beginTransaction();
               int var8 = 0;

               while(true) {
                  if (var8 >= this.lesParticipants.size()) {
                     String var14 = var1.sendSmsListe(this.campagneMessageVentesSms.getCammesMessage(), var5);
                     var1.majStatut(var4, var14, var3, var2, var6);
                     this.campagneMessageVentesSms.setCammesEtat(1);
                     this.campagneMessageVentesSms = this.campagneMessageVentesDao.modif(this.campagneMessageVentesSms, var6);
                     var7.commit();
                     break;
                  }

                  this.campagneParticipantVentes = (CampagneParticipantVentes)this.lesParticipants.get(var8);
                  if (this.campagneParticipantVentes.getContacts().getConcel1() != null && !this.campagneParticipantVentes.getContacts().getConcel1().isEmpty()) {
                     if (var5 == null && var5.isEmpty()) {
                        var5 = this.campagneParticipantVentes.getContacts().getConcel1();
                     } else {
                        var5 = var5 + "," + this.campagneParticipantVentes.getContacts().getConcel1();
                     }

                     var3 = new Sms();
                     var3 = var1.enregistrementSms(var3, var2, this.campagneMessageVentesSms.getCammesMessage(), this.campagneParticipantVentes.getContacts().getConcel1(), this.campagneParticipantVentes.getContacts().getConpatronyme(), this.campagneParticipantVentes.getContacts().getConcivilite(), this.campagneParticipantVentes.getContacts().getConid(), this.campagneParticipantVentes.getCamparNomTiers(), this.campagneParticipantVentes.getCamparIdTiers(), 0, var6);
                     var4.add(var3);
                  }

                  ++var8;
               }
            } catch (HibernateException var12) {
               if (var7 != null) {
                  var7.rollback();
               }

               throw var12;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }

         this.visibiliteBtonSms = false;
      }

   }

   public List calculListeUsersByUser(List var1, List var2, Session var3) throws HibernateException, NamingException {
      new Users();
      UserDao var5 = new UserDao(this.baseLog, this.utilInitHibernate);
      Users var4;
      int var6;
      long var7;
      boolean var9;
      int var10;
      if (this.optionsVentes.getResponsable().equals("1")) {
         for(var6 = 0; var6 < var1.size(); ++var6) {
            var7 = ((DocumentEntete)var1.get(var6)).getDocIdCommercial();
            if (var7 != 0L) {
               if (var2.size() == 0) {
                  new Users();
                  var4 = var5.selectByIdUsers(var7, var3);
                  if (var4 != null && (this.inpIdCommercial == 0L || this.inpIdCommercial != 0L && this.inpIdCommercial == var4.getUsrid()) && var4.getUsrCommType() >= 3) {
                     var2.add(var4);
                  }
               } else {
                  var9 = false;

                  for(var10 = 0; var10 < var2.size(); ++var10) {
                     if (((Users)var2.get(var10)).getUsrid() == var7) {
                        var9 = true;
                        break;
                     }
                  }

                  if (!var9) {
                     new Users();
                     var4 = var5.selectByIdUsers(var7, var3);
                     if (var4 != null && (this.inpIdCommercial == 0L || this.inpIdCommercial != 0L && this.inpIdCommercial == var4.getUsrid()) && var4.getUsrCommType() >= 3) {
                        var2.add(var4);
                     }
                  }
               }
            }
         }
      } else {
         for(var6 = 0; var6 < var1.size(); ++var6) {
            var7 = ((DocumentEntete)var1.get(var6)).getDocIdResponsable();
            if (var7 != 0L) {
               if (var2.size() == 0) {
                  new Users();
                  var4 = var5.selectByIdUsers(var7, var3);
                  if (var4 != null && (this.inpIdResponsable == 0L || this.inpIdResponsable != 0L && this.inpIdResponsable == var4.getUsrid()) && var4.getUsrCommType() >= 3) {
                     var2.add(var4);
                  }
               } else {
                  var9 = false;

                  for(var10 = 0; var10 < var2.size(); ++var10) {
                     if (((Users)var2.get(var10)).getUsrid() == var7) {
                        var9 = true;
                        break;
                     }
                  }

                  if (!var9) {
                     new Users();
                     var4 = var5.selectByIdUsers(var7, var3);
                     if (var4 != null && (this.inpIdResponsable == 0L || this.inpIdResponsable != 0L && this.inpIdResponsable == var4.getUsrid()) && var4.getUsrCommType() >= 3) {
                        var2.add(var4);
                     }
                  }
               }
            }
         }
      }

      return var2;
   }

   public List calculListeUsersByProduit(List var1, List var2, Session var3) throws HibernateException, NamingException {
      new Users();
      UserDao var5 = new UserDao(this.baseLog, this.utilInitHibernate);
      Users var4;
      int var6;
      long var7;
      boolean var9;
      int var10;
      if (this.optionsVentes.getResponsable().equals("1")) {
         for(var6 = 0; var6 < var1.size(); ++var6) {
            var7 = ((DocumentEntete)var1.get(var6)).getDocIdCommercial();
            if (var7 != 0L) {
               if (var2.size() == 0) {
                  new Users();
                  var4 = var5.selectByIdUsers(var7, var3);
                  if (var4 != null && (this.inpIdCommercial == 0L || this.inpIdCommercial != 0L && this.inpIdCommercial == var4.getUsrid())) {
                     var2.add(var4);
                  }
               } else {
                  var9 = false;

                  for(var10 = 0; var10 < var2.size(); ++var10) {
                     if (((Users)var2.get(var10)).getUsrid() == var7) {
                        var9 = true;
                        break;
                     }
                  }

                  if (!var9) {
                     new Users();
                     var4 = var5.selectByIdUsers(var7, var3);
                     if (var4 != null && (this.inpIdCommercial == 0L || this.inpIdCommercial != 0L && this.inpIdCommercial == var4.getUsrid())) {
                        var2.add(var4);
                     }
                  }
               }
            }
         }
      } else {
         for(var6 = 0; var6 < var1.size(); ++var6) {
            var7 = ((DocumentEntete)var1.get(var6)).getDocIdResponsable();
            if (var7 != 0L) {
               if (var2.size() == 0) {
                  new Users();
                  var4 = var5.selectByIdUsers(var7, var3);
                  if (var4 != null && (this.inpIdResponsable == 0L || this.inpIdResponsable != 0L && this.inpIdResponsable == var4.getUsrid())) {
                     var2.add(var4);
                  }
               } else {
                  var9 = false;

                  for(var10 = 0; var10 < var2.size(); ++var10) {
                     if (((Users)var2.get(var10)).getUsrid() == var7) {
                        var9 = true;
                        break;
                     }
                  }

                  if (!var9) {
                     new Users();
                     var4 = var5.selectByIdUsers(var7, var3);
                     if (var4 != null && (this.inpIdResponsable == 0L || this.inpIdResponsable != 0L && this.inpIdResponsable == var4.getUsrid())) {
                        var2.add(var4);
                     }
                  }
               }
            }
         }
      }

      return var2;
   }

   public void verifValide() {
      if (this.campagneEnteteVentes.getCamObjet() != null && !this.campagneEnteteVentes.getCamObjet().isEmpty()) {
         this.var_valide_doc = true;
      } else {
         this.var_valide_doc = false;
      }

   }

   public boolean verifieExistenceHabilitation(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         this.campagneEnteteVentes.setCamEtatVal(1);
         this.campagneEnteteVentes.setCamEtat(0);
         this.campagneEnteteVentes.setCamDateValide((Date)null);
         return true;
      } else {
         this.campagneEnteteVentes.setCamEtatVal(0);
         this.chargerUserChrono(var1);
         if (this.usersChrono != null) {
            if (this.usersChrono.getUsrchrValidation() == 0) {
               this.campagneEnteteVentes.setCamEtat(1);
               this.campagneEnteteVentes.setCamDateValide(new Date());
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2 && this.usersChrono.getUsrchrValidation() == 3) {
               this.campagneEnteteVentes.setCamEtat(0);
               this.campagneEnteteVentes.setCamDateValide((Date)null);
            }
         }

         return false;
      }
   }

   public void rechercheResponsable() throws JDOMException, IOException, HibernateException, NamingException {
      this.responsable = this.formRecherche.rechercheResponsable(this.inpResponsable, this.nature);
      if (this.responsable != null) {
         if (this.responsable.getUsrid() != 0L) {
            this.calculeResponsable();
         } else {
            this.var_action = 11;
         }
      } else if (this.responsable == null) {
         this.calculeResponsable();
      }

   }

   public void recuperationResponsable() throws JDOMException, IOException, HibernateException, NamingException {
      this.responsable = this.formRecherche.calculeResponsable();
      this.calculeResponsable();
   }

   public void calculeResponsable() throws JDOMException, IOException {
      if (this.responsable != null) {
         this.inpResponsable = this.responsable.getUsrPatronyme();
         this.inpIdResponsable = this.responsable.getUsrid();
      } else {
         this.inpResponsable = "";
         this.inpIdResponsable = 0L;
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleResponsable() {
      this.inpResponsable = "";
      this.inpIdResponsable = 0L;
      this.var_action = this.var_memo_action;
   }

   public void rechercheCommercial() throws JDOMException, IOException, HibernateException, NamingException {
      this.responsable = this.formRecherche.rechercheCommercial(this.inpCommercial, this.nature);
      if (this.responsable != null) {
         if (this.responsable.getUsrid() != 0L) {
            this.calculeCommercial();
         } else {
            this.var_action = 17;
         }
      } else if (this.responsable == null) {
         this.calculeCommercial();
      }

   }

   public void recuperationCommercial() throws JDOMException, IOException, HibernateException, NamingException {
      this.responsable = this.formRecherche.calculeCommercial();
      this.calculeCommercial();
   }

   public void calculeCommercial() throws JDOMException, IOException {
      if (this.responsable != null) {
         this.inpCommercial = this.responsable.getUsrPatronyme();
         this.inpIdCommercial = this.responsable.getUsrid();
      } else {
         this.inpCommercial = "";
         this.inpIdCommercial = 0L;
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleCommercial() {
      this.inpCommercial = "";
      this.inpIdCommercial = 0L;
      this.var_action = this.var_memo_action;
   }

   public void rechercheContacts() throws JDOMException, IOException, HibernateException, NamingException {
      this.contacts = this.formRecherche.rechercheContacts(this.var_participant, this.nature);
      if (this.contacts != null) {
         if (this.contacts.getConid() != 0L) {
            this.calculeContacts();
         } else {
            this.var_action = 20;
         }
      } else if (this.contacts == null) {
         this.calculeContacts();
      }

   }

   public void recuperationContacts() throws JDOMException, IOException, HibernateException, NamingException {
      this.contacts = this.formRecherche.calculeContacts();
      this.calculeContacts();
   }

   public void calculeContacts() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.contacts != null) {
         this.tiers = this.contacts.getTiers();
         this.campagneParticipantVentes.setContacts(this.contacts);
         this.campagneParticipantVentes.setCamparIdTiers(this.tiers.getTieid());
         this.campagneParticipantVentes.setCamparNomTiers(this.tiers.getTieraisonsocialenom());
         this.var_participant = this.contacts.getConcivilite() + " " + this.contacts.getConpatronyme();
      } else {
         this.annuleContacts();
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleContacts() {
      this.contacts = null;
      this.tiers = null;
      this.campagneParticipantVentes.setContacts(this.contacts);
      this.campagneParticipantVentes.setCamparIdTiers(0L);
      this.campagneParticipantVentes.setCamparNomTiers("");
      this.var_participant = "";
      this.var_action = this.var_memo_action;
   }

   public String calculeCheminRapport(String var1, int var2) {
      String var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "campagne" + File.separator;
      return var3;
   }

   public String calculeCheminSousRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport" + File.separator;
      return var2;
   }

   public String calculeImageFond(String var1, int var2) throws HibernateException, NamingException {
      String var3 = "";
      File var4;
      if (var2 == 0) {
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatEncours.jpg");
         if (var4.exists()) {
            var3 = "formatEncours.jpg";
         } else {
            var4 = new File(this.calculeCheminSousRapport(var1) + "formatCampagne.jpg");
            if (var4.exists()) {
               var3 = "formatCampagne.jpg";
            }
         }
      } else if (var2 == 20) {
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatParapheur.jpg");
         if (var4.exists()) {
            var3 = "formatParapheur.jpg";
         }
      } else if (var2 == 30) {
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatCaisse.jpg");
         if (var4.exists()) {
            var3 = "formatCaisse.jpg";
         }
      } else {
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatCampagne.jpg");
         if (var4.exists()) {
            var3 = "formatCampagne.jpg";
         }
      }

      return var3;
   }

   public JRBeanCollectionDataSource calculeImpressionCommun() throws IOException {
      ArrayList var1 = new ArrayList();
      this.montant_lettre = this.utilNombre.begin(this.campagneEnteteVentes.getCamTotDepense() - this.campagneEnteteVentes.getCamTotRecette(), this.structureLog.getStrdevise());
      JRBeanCollectionDataSource var2 = new JRBeanCollectionDataSource(var1);
      return var2;
   }

   public boolean majDateImpression(String var1) throws HibernateException, NamingException {
      boolean var2 = false;
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "CampagneEntete");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         if (this.campagneEnteteVentes.getCamDateImp() != null) {
            var2 = true;
         }

         this.campagneEnteteVentes.setCamDateImp(new Date());
         if (this.campagneEnteteVentes.getCamEtat() == 0 && this.campagneEnteteVentes.getCamEtatVal() == 0 && this.usersChrono.getUsrchrValidation() == 1) {
            this.campagneEnteteVentes.setCamEtat(1);
         }

         this.campagneEnteteVentes.setCamModeleImp(var1);
         this.campagneEnteteVentes = this.campagneEnteteVentesDao.modif(this.campagneEnteteVentes, var3);
         var4.commit();
      } catch (HibernateException var9) {
         if (var4 != null) {
            var4.rollback();
         }

         throw var9;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var2;
   }

   public void impression(UtilPrint var1, int var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10) throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      if (var2 == 0) {
         if (var3 != null && !var3.isEmpty()) {
            boolean var11 = this.majDateImpression(var3);
            var1.setjRBeanCollectionDataSource(this.calculeImpressionCommun());
            var1.setRapport(var3);
            var1.setEntete("Impression campagne");
            var1.setMontant_lettre(this.montant_lettre);
            var1.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid(), this.nature));
            var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid(), this.campagneEnteteVentes.getCamEtat()));
            var1.setDuplicata("" + var11);
            var1.setNbDecQte(this.optionsVentes.getNbDecQte());
            var1.setNbDecPu(this.optionsVentes.getNbDecPu());
            var1.setFormat(var5);
            var1.setEmetteur(var6);
            var1.setDestinataire(var7);
            var1.setDestinataireCC(var8);
            var1.setDestinataireCCI(var9);
            var1.setCorpsMail(var10);
            var1.setIdResponsable(this.campagneEnteteVentes.getCamIdResponsable());
            var1.setIdCommercial(this.campagneEnteteVentes.getCamIdCommercial());
            var1.setTiersSelectionne((Tiers)null);
            var1.setNature(this.nature);
            var1.setId_doc(this.campagneEnteteVentes.getCamId());
            if (this.campagneEnteteVentes.getCamAnal2() != null && !this.campagneEnteteVentes.getCamAnal2().isEmpty()) {
               String var12 = "";
               if (this.campagneEnteteVentes.getCamAnal2().contains(":")) {
                  String[] var13 = this.campagneEnteteVentes.getCamAnal2().split(":");
                  var12 = var13[0];
               } else {
                  var12 = this.campagneEnteteVentes.getCamAnal2();
               }
            }

            var1.setParc((Parc)null);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      } else if (var4 != null && !var4.isEmpty()) {
         var1.setRapport(var4);
         var1.setEntete("Impression de la liste des campagne");
         var1.setTotauxTtc("" + (this.montantDepenses - this.montantRecettes));
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste" + File.separator + "campagne" + File.separator);
         var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport" + File.separator);
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
         JRBeanCollectionDataSource var14 = new JRBeanCollectionDataSource(this.listCampagne);
         var1.setjRBeanCollectionDataSource(var14);
         var1.setBaseLog(this.baseLog);
         var1.setStructureLog(this.structureLog);
         var1.setUsersLog(this.usersLog);
         var1.imprimeRapport();
      }

      this.showModalPanelPrint = false;
   }

   public void initGrapheur() {
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

   public Date getInpAu() {
      return this.inpAu;
   }

   public void setInpAu(Date var1) {
      this.inpAu = var1;
   }

   public String getInpCommercial() {
      return this.inpCommercial;
   }

   public void setInpCommercial(String var1) {
      this.inpCommercial = var1;
   }

   public Date getInpDu() {
      return this.inpDu;
   }

   public void setInpDu(Date var1) {
      this.inpDu = var1;
   }

   public int getInpNb() {
      return this.inpNb;
   }

   public void setInpNb(int var1) {
      this.inpNb = var1;
   }

   public String getInpResponsable() {
      return this.inpResponsable;
   }

   public void setInpResponsable(String var1) {
      this.inpResponsable = var1;
   }

   public boolean isShowModalPanelPrint() {
      return this.showModalPanelPrint;
   }

   public void setShowModalPanelPrint(boolean var1) {
      this.showModalPanelPrint = var1;
   }

   public DataModel getDatamodelCampagne() {
      return this.datamodelCampagne;
   }

   public void setDatamodelCampagne(DataModel var1) {
      this.datamodelCampagne = var1;
   }

   public UsersChrono getUsersChrono() {
      return this.usersChrono;
   }

   public void setUsersChrono(UsersChrono var1) {
      this.usersChrono = var1;
   }

   public CampagneEnteteVentes getCampagneEnteteVentes() {
      return this.campagneEnteteVentes;
   }

   public void setCampagneEnteteVentes(CampagneEnteteVentes var1) {
      this.campagneEnteteVentes = var1;
   }

   public int getInpEtat() {
      return this.inpEtat;
   }

   public void setInpEtat(int var1) {
      this.inpEtat = var1;
   }

   public String getPeriode() {
      return this.periode;
   }

   public void setPeriode(String var1) {
      this.periode = var1;
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

   public Habilitation getHabilitation() {
      return this.habilitation;
   }

   public void setHabilitation(Habilitation var1) {
      this.habilitation = var1;
   }

   public String getInpActivite() {
      return this.inpActivite;
   }

   public void setInpActivite(String var1) {
      this.inpActivite = var1;
   }

   public String getInpNum() {
      return this.inpNum;
   }

   public void setInpNum(String var1) {
      this.inpNum = var1;
   }

   public String getInpService() {
      return this.inpService;
   }

   public void setInpService(String var1) {
      this.inpService = var1;
   }

   public boolean isVisibiliteBton() {
      return this.visibiliteBton;
   }

   public void setVisibiliteBton(boolean var1) {
      this.visibiliteBton = var1;
   }

   public double getMontantDepenses() {
      return this.montantDepenses;
   }

   public void setMontantDepenses(double var1) {
      this.montantDepenses = var1;
   }

   public double getMontantMarge() {
      return this.montantMarge;
   }

   public void setMontantMarge(double var1) {
      this.montantMarge = var1;
   }

   public double getMontantRecettes() {
      return this.montantRecettes;
   }

   public void setMontantRecettes(double var1) {
      this.montantRecettes = var1;
   }

   public int getVar_nb_ligne() {
      return this.var_nb_ligne;
   }

   public void setVar_nb_ligne(int var1) {
      this.var_nb_ligne = var1;
   }

   public Date getInpDate() {
      return this.inpDate;
   }

   public void setInpDate(Date var1) {
      this.inpDate = var1;
   }

   public DataModel getDataModelDecoupageActivtes() {
      return this.dataModelDecoupageActivtes;
   }

   public void setDataModelDecoupageActivtes(DataModel var1) {
      this.dataModelDecoupageActivtes = var1;
   }

   public boolean isDecoupageActivite() {
      return this.decoupageActivite;
   }

   public void setDecoupageActivite(boolean var1) {
      this.decoupageActivite = var1;
   }

   public List getLaColonne1Items() {
      return this.laColonne1Items;
   }

   public void setLaColonne1Items(List var1) {
      this.laColonne1Items = var1;
   }

   public List getLaColonne2Items() {
      return this.laColonne2Items;
   }

   public void setLaColonne2Items(List var1) {
      this.laColonne2Items = var1;
   }

   public List getLaColonne3Items() {
      return this.laColonne3Items;
   }

   public void setLaColonne3Items(List var1) {
      this.laColonne3Items = var1;
   }

   public boolean isVar_anal_activite() {
      return this.var_anal_activite;
   }

   public void setVar_anal_activite(boolean var1) {
      this.var_anal_activite = var1;
   }

   public String getVar_colonne1() {
      return this.var_colonne1;
   }

   public void setVar_colonne1(String var1) {
      this.var_colonne1 = var1;
   }

   public String getVar_colonne2() {
      return this.var_colonne2;
   }

   public void setVar_colonne2(String var1) {
      this.var_colonne2 = var1;
   }

   public String getVar_colonne3() {
      return this.var_colonne3;
   }

   public void setVar_colonne3(String var1) {
      this.var_colonne3 = var1;
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

   public Date getVar_date() {
      return this.var_date;
   }

   public void setVar_date(Date var1) {
      this.var_date = var1;
   }

   public String getVar_heure() {
      return this.var_heure;
   }

   public void setVar_heure(String var1) {
      this.var_heure = var1;
   }

   public String getVar_minute() {
      return this.var_minute;
   }

   public void setVar_minute(String var1) {
      this.var_minute = var1;
   }

   public String getVar_seconde() {
      return this.var_seconde;
   }

   public void setVar_seconde(String var1) {
      this.var_seconde = var1;
   }

   public List getMesSerieUserItem() {
      return this.mesSerieUserItem;
   }

   public void setMesSerieUserItem(List var1) {
      this.mesSerieUserItem = var1;
   }

   public List getMesUsersItem() {
      return this.mesUsersItem;
   }

   public void setMesUsersItem(List var1) {
      this.mesUsersItem = var1;
   }

   public boolean isVar_verrou_comm() {
      return this.var_verrou_comm;
   }

   public void setVar_verrou_comm(boolean var1) {
      this.var_verrou_comm = var1;
   }

   public long getVar_nom_commercial() {
      return this.var_nom_commercial;
   }

   public void setVar_nom_commercial(long var1) {
      this.var_nom_commercial = var1;
   }

   public long getVar_nom_responsable() {
      return this.var_nom_responsable;
   }

   public void setVar_nom_responsable(long var1) {
      this.var_nom_responsable = var1;
   }

   public boolean isVisibleOnglet() {
      return this.visibleOnglet;
   }

   public void setVisibleOnglet(boolean var1) {
      this.visibleOnglet = var1;
   }

   public int getVar_anal_dossier() {
      return this.var_anal_dossier;
   }

   public void setVar_anal_dossier(int var1) {
      this.var_anal_dossier = var1;
   }

   public boolean isVar_anal_parc() {
      return this.var_anal_parc;
   }

   public void setVar_anal_parc(boolean var1) {
      this.var_anal_parc = var1;
   }

   public long getVar_nom_equipe() {
      return this.var_nom_equipe;
   }

   public void setVar_nom_equipe(long var1) {
      this.var_nom_equipe = var1;
   }

   public double getTotalDepenses() {
      return this.totalDepenses;
   }

   public void setTotalDepenses(double var1) {
      this.totalDepenses = var1;
   }

   public double getTotalEcartBudget() {
      return this.totalEcartBudget;
   }

   public void setTotalEcartBudget(double var1) {
      this.totalEcartBudget = var1;
   }

   public double getTotalMarge() {
      return this.totalMarge;
   }

   public void setTotalMarge(double var1) {
      this.totalMarge = var1;
   }

   public double getTotalRecettes() {
      return this.totalRecettes;
   }

   public void setTotalRecettes(double var1) {
      this.totalRecettes = var1;
   }

   public DataModel getDataModelDepenses() {
      return this.dataModelDepenses;
   }

   public void setDataModelDepenses(DataModel var1) {
      this.dataModelDepenses = var1;
   }

   public DataModel getDataModelRecettes() {
      return this.dataModelRecettes;
   }

   public void setDataModelRecettes(DataModel var1) {
      this.dataModelRecettes = var1;
   }

   public int getVar_etat() {
      return this.var_etat;
   }

   public void setVar_etat(int var1) {
      this.var_etat = var1;
   }

   public boolean isVisibiliteBtonParticipant() {
      return this.visibiliteBtonParticipant;
   }

   public void setVisibiliteBtonParticipant(boolean var1) {
      this.visibiliteBtonParticipant = var1;
   }

   public DataModel getDataModelParticipants() {
      return this.dataModelParticipants;
   }

   public void setDataModelParticipants(DataModel var1) {
      this.dataModelParticipants = var1;
   }

   public boolean isShowModalPanelParticipant() {
      return this.showModalPanelParticipant;
   }

   public void setShowModalPanelParticipant(boolean var1) {
      this.showModalPanelParticipant = var1;
   }

   public CampagneParticipantVentes getCampagneParticipantVentes() {
      return this.campagneParticipantVentes;
   }

   public void setCampagneParticipantVentes(CampagneParticipantVentes var1) {
      this.campagneParticipantVentes = var1;
   }

   public String getVar_participant() {
      return this.var_participant;
   }

   public void setVar_participant(String var1) {
      this.var_participant = var1;
   }

   public int getNbParticipants() {
      return this.nbParticipants;
   }

   public void setNbParticipants(int var1) {
      this.nbParticipants = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public boolean isShowModalPanelGroupe() {
      return this.showModalPanelGroupe;
   }

   public void setShowModalPanelGroupe(boolean var1) {
      this.showModalPanelGroupe = var1;
   }

   public String getActivitesRec() {
      return this.activitesRec;
   }

   public void setActivitesRec(String var1) {
      this.activitesRec = var1;
   }

   public String getAppreciationRec() {
      return this.appreciationRec;
   }

   public void setAppreciationRec(String var1) {
      this.appreciationRec = var1;
   }

   public String getCategorieRec() {
      return this.categorieRec;
   }

   public void setCategorieRec(String var1) {
      this.categorieRec = var1;
   }

   public String getFamilleRec() {
      return this.familleRec;
   }

   public void setFamilleRec(String var1) {
      this.familleRec = var1;
   }

   public String getMailRec() {
      return this.mailRec;
   }

   public void setMailRec(String var1) {
      this.mailRec = var1;
   }

   public List getMesActivitesSocietesItems() {
      return this.mesActivitesSocietesItems;
   }

   public void setMesActivitesSocietesItems(List var1) {
      this.mesActivitesSocietesItems = var1;
   }

   public List getMesAppreciationsItems() {
      return this.mesAppreciationsItems;
   }

   public void setMesAppreciationsItems(List var1) {
      this.mesAppreciationsItems = var1;
   }

   public List getMesCategoriesItems() {
      return this.mesCategoriesItems;
   }

   public void setMesCategoriesItems(List var1) {
      this.mesCategoriesItems = var1;
   }

   public List getMesEquipeItem() {
      return this.mesEquipeItem;
   }

   public void setMesEquipeItem(List var1) {
      this.mesEquipeItem = var1;
   }

   public List getMesObservationsItems() {
      return this.mesObservationsItems;
   }

   public void setMesObservationsItems(List var1) {
      this.mesObservationsItems = var1;
   }

   public List getMesPaysItems() {
      return this.mesPaysItems;
   }

   public void setMesPaysItems(List var1) {
      this.mesPaysItems = var1;
   }

   public String getNomRec() {
      return this.nomRec;
   }

   public void setNomRec(String var1) {
      this.nomRec = var1;
   }

   public String getObservationsRec() {
      return this.observationsRec;
   }

   public void setObservationsRec(String var1) {
      this.observationsRec = var1;
   }

   public String getPaysRec() {
      return this.paysRec;
   }

   public void setPaysRec(String var1) {
      this.paysRec = var1;
   }

   public String getPdvRec() {
      return this.pdvRec;
   }

   public void setPdvRec(String var1) {
      this.pdvRec = var1;
   }

   public String getVilleRec() {
      return this.villeRec;
   }

   public void setVilleRec(String var1) {
      this.villeRec = var1;
   }

   public DataModel getDataModelGroupe() {
      return this.dataModelGroupe;
   }

   public void setDataModelGroupe(DataModel var1) {
      this.dataModelGroupe = var1;
   }

   public CampagneMessageVentes getCampagneMessageVentesMail() {
      return this.campagneMessageVentesMail;
   }

   public void setCampagneMessageVentesMail(CampagneMessageVentes var1) {
      this.campagneMessageVentesMail = var1;
   }

   public CampagneMessageVentes getCampagneMessageVentesSms() {
      return this.campagneMessageVentesSms;
   }

   public void setCampagneMessageVentesSms(CampagneMessageVentes var1) {
      this.campagneMessageVentesSms = var1;
   }

   public DataModel getDataModelMail() {
      return this.dataModelMail;
   }

   public void setDataModelMail(DataModel var1) {
      this.dataModelMail = var1;
   }

   public DataModel getDataModelSms() {
      return this.dataModelSms;
   }

   public void setDataModelSms(DataModel var1) {
      this.dataModelSms = var1;
   }

   public boolean isShowModalPanelMessageMail() {
      return this.showModalPanelMessageMail;
   }

   public void setShowModalPanelMessageMail(boolean var1) {
      this.showModalPanelMessageMail = var1;
   }

   public boolean isShowModalPanelMessageSMS() {
      return this.showModalPanelMessageSMS;
   }

   public void setShowModalPanelMessageSMS(boolean var1) {
      this.showModalPanelMessageSMS = var1;
   }

   public boolean isVisibiliteBtonMail() {
      return this.visibiliteBtonMail;
   }

   public void setVisibiliteBtonMail(boolean var1) {
      this.visibiliteBtonMail = var1;
   }

   public boolean isVisibiliteBtonSms() {
      return this.visibiliteBtonSms;
   }

   public void setVisibiliteBtonSms(boolean var1) {
      this.visibiliteBtonSms = var1;
   }

   public boolean isShowModalPanelAnnuler() {
      return this.showModalPanelAnnuler;
   }

   public void setShowModalPanelAnnuler(boolean var1) {
      this.showModalPanelAnnuler = var1;
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

   public List getResumeCommercial() {
      return this.resumeCommercial;
   }

   public void setResumeCommercial(List var1) {
      this.resumeCommercial = var1;
   }

   public List getMesPersonnelsItem() {
      return this.mesPersonnelsItem;
   }

   public void setMesPersonnelsItem(List var1) {
      this.mesPersonnelsItem = var1;
   }

   public DataModel getDatamodelActions() {
      return this.datamodelActions;
   }

   public void setDatamodelActions(DataModel var1) {
      this.datamodelActions = var1;
   }

   public boolean isShowModalPanelActions() {
      return this.showModalPanelActions;
   }

   public void setShowModalPanelActions(boolean var1) {
      this.showModalPanelActions = var1;
   }

   public boolean isVisibiliteBtonActions() {
      return this.visibiliteBtonActions;
   }

   public void setVisibiliteBtonActions(boolean var1) {
      this.visibiliteBtonActions = var1;
   }

   public CampagneActionVentes getCampagneActionVentes() {
      return this.campagneActionVentes;
   }

   public void setCampagneActionVentes(CampagneActionVentes var1) {
      this.campagneActionVentes = var1;
   }
}
