package com.epegase.forms.achats;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.Contacts;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.ModelesCourriers;
import com.epegase.systeme.classe.Parapheur;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsFournisseur;
import com.epegase.systeme.classe.ReacheminementEnteteAchats;
import com.epegase.systeme.classe.ReacheminementLigneAchats;
import com.epegase.systeme.classe.ReceptionEnteteAchats;
import com.epegase.systeme.classe.ReceptionLigneAchats;
import com.epegase.systeme.classe.Responsable;
import com.epegase.systeme.classe.RetourEnteteAchats;
import com.epegase.systeme.classe.RetourLigneAchats;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.classe.ValorisationEnteteAchats;
import com.epegase.systeme.dao.ContactDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.HabilitationDao;
import com.epegase.systeme.dao.ModelesCourriersDao;
import com.epegase.systeme.dao.ParapheurDao;
import com.epegase.systeme.dao.ProduitsAchsDao;
import com.epegase.systeme.dao.ProduitsFournisseurDao;
import com.epegase.systeme.dao.ReacheminementEnteteAchatsDao;
import com.epegase.systeme.dao.ReacheminementLigneAchatsDao;
import com.epegase.systeme.dao.ReceptionEnteteAchatsDao;
import com.epegase.systeme.dao.ReceptionLigneAchatsDao;
import com.epegase.systeme.dao.ResponsableDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.dao.ValorisationEnteteAchatsDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.CalculStock;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilParapheur;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.util.UtilTdt;
import com.epegase.systeme.xml.ObjetFamilleTiers;
import com.epegase.systeme.xml.ObjetIncoterm;
import com.epegase.systeme.xml.ObjetLigneOnglet;
import com.epegase.systeme.xml.OptionAchats;
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
import org.xml.sax.SAXException;

public class FormReacheminementAchats implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private FormRecherche formRecherche;
   private int var_action = 0;
   private int var_memo_action = 0;
   private String pageIndex;
   private int nature;
   private String urlphotoProd;
   private List mesOnglets;
   private OptionAchats optionAchats;
   private int var_option_parc;
   private ExercicesAchats exercicesAchats;
   private ExercicesAchats lastExoAchats;
   private ExercicesComptable lastExoCompta;
   private EspionDao espionDao;
   private CalculChrono calculChrono;
   private int var_timbre;
   private int var_nb_max = 100;
   private int modeReception;
   private String libelleModeReception;
   private String urlExplorateur;
   private UtilNombre utilNombre = new UtilNombre();
   private Date var_date;
   private String var_heure;
   private String var_minute;
   private String var_seconde;
   private boolean visibleOnglet = false;
   private boolean var_sansstock = false;
   private boolean var_aff_detail_prod = false;
   private boolean var_aff_detail_tiers = false;
   private boolean var_typeTiers = true;
   private boolean existParapheur = false;
   private Tiers tiers;
   private TiersDao tiersDao;
   private String nomTier;
   private List lesFamilleFournisseursListe;
   private String informationsTiers;
   private Users responsable;
   private UsersChrono usersChrono = new UsersChrono();
   private UsersChronoDao usersChronoDao;
   private UserDao usersDao;
   private List mesUsersItem = new ArrayList();
   private List lesUsers = new ArrayList();
   private ContactDao contactDao;
   private List mesContactItem = new ArrayList();
   private Contacts contacts;
   private ReacheminementEnteteAchats reacheminementEnteteAchats = new ReacheminementEnteteAchats();
   private ReacheminementEnteteAchatsDao reacheminementEnteteAchatsDao;
   private List lesEntetesList = new ArrayList();
   private boolean verrouNum = false;
   private transient DataModel datamodelEntete = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private boolean visibiliteBton = false;
   private boolean visibiliteBtonlig = true;
   private boolean visibleOngleEntete;
   private boolean var_aff_action = false;
   private boolean var_valide_doc = false;
   private int var_nb_ligne = 0;
   private boolean visibilitefactor = false;
   private boolean visibiliteterme = false;
   private boolean visibilitenbrjr = false;
   private boolean visibiliteencaissemt = false;
   private ObjetIncoterm incoterms;
   private UtilDate utilDate = new UtilDate();
   private boolean showModalPanelImput = false;
   private String var_imput_serie;
   private String var_imput_cat;
   private transient DataModel datamodelDocumentTrace = new ListDataModel();
   private long var_nom_responsable;
   private long var_nom_contact;
   private ReacheminementLigneAchats reacheminementLigneAchats = new ReacheminementLigneAchats();
   private ReacheminementLigneAchatsDao reacheminementLigneAchatsDao;
   private transient DataModel datamodelLigne = new ListDataModel();
   private List lesLignesList = new ArrayList();
   private String var_depotProd;
   private double totauxBrut = 0.0D;
   private double totauxNet = 0.0D;
   private int totauxSac = 0;
   private int totauxCamion = 0;
   private double totauxBrutGlobal = 0.0D;
   private double totauxNetGlobal = 0.0D;
   private boolean griserchamps = false;
   private float var_memo_qte;
   private boolean affiche_ligne;
   private Produits produits;
   private ProduitsAchsDao produitsDao;
   private CalculStock calculStock = new CalculStock();
   private boolean verrou_libelle = false;
   private String inpNomTiersEnCours = "";
   private long inpIdTiersEnCours = 0L;
   private String inpSerie = "100";
   private String inpCat = "100";
   private int inpEtat = 0;
   private String periode;
   private String inpNum = "";
   private String inpFournisseur = "";
   private String inpResponsable = "";
   private String inpDossier = "";
   private String inpAnnonce = "";
   private Date inpDu = null;
   private Date inpAu = null;
   private boolean var_more_search = false;
   private boolean showModalPanelReception = false;
   private transient DataModel dataModelReceptions = new ListDataModel();
   private List lesReceptions = new ArrayList();
   private ReceptionEnteteAchats receptionEnteteAchats;
   private ReceptionEnteteAchatsDao receptionEnteteAchatsDao;
   private Date receptionDu = null;
   private Date receptionAu = null;
   private List lesReceptionsSelectionnees = new ArrayList();
   private ReceptionLigneAchats receptionLigneAchats;
   private ReceptionLigneAchatsDao receptionLigneAchatsDao;
   private List mesReceptionsLignesItems = new ArrayList();
   private boolean verrouRemise = false;
   private boolean verrouRabais = false;
   private boolean verrouPrvente = false;
   private boolean affichagePump = false;
   private boolean verrouPump = false;
   private String verrouDepotUser;
   private boolean accesProduits;
   private boolean var_acc_document = false;
   private boolean var_acc_imputation = false;
   private boolean var_acc_complement = false;
   private boolean var_acc_reglement = false;
   private boolean var_acc_special = false;
   private boolean var_acc_habilitation = false;
   private boolean var_acc_etat = false;
   private boolean var_acc_tracabilite = false;
   private boolean var_acc_prp = false;
   private boolean var_ajt = false;
   private boolean var_mod = false;
   private boolean var_sup = false;
   private boolean var_imp = false;
   private boolean var_verrou_comm = false;
   private Habilitation habilitation;
   private UtilParapheur utilParapheur;
   private ParapheurDao parapheurDao;
   private Parapheur parapheur;
   private UtilTdt utilTdt = new UtilTdt();
   private boolean showModalPanelPrint = false;
   private boolean showModalPanelAnnuler = false;
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

   public FormReacheminementAchats() throws IOException, SAXException, JDOMException {
   }

   public void InstancesDaoUtilses() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.reacheminementEnteteAchatsDao = new ReacheminementEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.reacheminementLigneAchatsDao = new ReacheminementLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      this.contactDao = new ContactDao(this.baseLog, this.utilInitHibernate);
      this.usersDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      this.produitsDao = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
      this.receptionEnteteAchatsDao = new ReceptionEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.receptionLigneAchatsDao = new ReceptionLigneAchatsDao(this.baseLog, this.utilInitHibernate);
   }

   public void configAchats() {
      if (this.structureLog.getStrtypeentreprise() == null || this.structureLog.getStrtypeentreprise().isEmpty()) {
         this.structureLog.setStrtypeentreprise("0");
      }

      if (!this.structureLog.getStrtypeentreprise().contentEquals("1") && !this.structureLog.getStrtypeentreprise().contentEquals("3")) {
         this.var_sansstock = true;
      } else {
         this.var_sansstock = false;
      }

      if (!this.optionAchats.getLib1().isEmpty() && !this.optionAchats.getLib2().isEmpty() && !this.optionAchats.getLib3().isEmpty() && !this.optionAchats.getLib4().isEmpty() && !this.optionAchats.getLib5().isEmpty() && !this.optionAchats.getLib6().isEmpty() && !this.optionAchats.getLib7().isEmpty() && !this.optionAchats.getLib8().isEmpty() && !this.optionAchats.getLib9().isEmpty() && !this.optionAchats.getLib10().isEmpty()) {
         this.visibleOngleEntete = false;
      } else {
         this.visibleOngleEntete = true;
      }

      if (this.optionAchats.getNbLigneMax() != null && !this.optionAchats.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionAchats.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      this.periode = this.optionAchats.getAffichInGlobViewREC();
      if (this.habilitation != null) {
         this.existParapheur = true;
      } else {
         this.existParapheur = false;
      }

      this.initPage();
      this.utilParapheur = new UtilParapheur(this.utilInitHibernate, this.structureLog, this.baseLog, this.usersLog);
      this.modeReception = 0;
      this.libelleModeReception = "";
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
            break;
         }
      }

      return var2;
   }

   public void accesResteintUser() {
      if (this.usersLog.getUsrVerRemiseAch() == 0) {
         this.verrouRemise = true;
      } else {
         this.verrouRemise = false;
      }

      if (this.usersLog.getUsrVerRabaisAch() == 0) {
         this.verrouRabais = true;
      } else {
         this.verrouRabais = false;
      }

      if (this.usersLog.getUsrVerPaAch() == 0) {
         this.verrouPrvente = false;
      } else {
         this.verrouPrvente = true;
      }

      if (this.usersLog.getUsrAchPump() == 0) {
         this.affichagePump = false;
         this.verrouPump = false;
      } else {
         this.affichagePump = true;
         if (this.usersLog.getUsrAchPump() == 2) {
            this.verrouPump = true;
         } else {
            this.verrouPump = false;
         }
      }

      if (this.usersLog.getUsrProdServiceAch() == 0) {
         this.accesProduits = false;
      } else {
         this.accesProduits = true;
      }

      this.visibiliteBton = false;
      if (this.usersLog.getUsrCommAchats() == 2) {
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
      this.var_acc_special = false;
      this.var_acc_habilitation = false;
      this.var_acc_etat = false;
      this.var_acc_tracabilite = false;
      this.var_acc_prp = false;
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
               this.var_acc_special = true;
            } else if (var1.getCode().equals("56")) {
               this.var_acc_habilitation = true;
            } else if (var1.getCode().equals("57")) {
               this.var_acc_etat = true;
            } else if (var1.getCode().equals("58")) {
               this.var_acc_tracabilite = true;
            } else if (var1.getCode().equals("60")) {
               this.var_acc_prp = true;
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

   public void autorisationSpecial() {
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

   public void autorisationPrp() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("60")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void initPage() {
      this.var_action = 0;
      this.totauxBrut = 0.0D;
      this.totauxNet = 0.0D;
      this.inpSerie = "100";
      this.inpCat = "100";
      this.inpEtat = 0;
      this.inpDossier = "";
      this.inpAnnonce = "";
      this.lesEntetesList.clear();
      this.lesLignesList.clear();
   }

   public void chargerLesUsers(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      Object var2 = new ArrayList();
      if (this.usersLog.getUsrCommAchats() == 0) {
         var2 = this.usersDao.chargerLesUsers(var1);
      } else if (this.usersLog.getUsrCommAchats() == 1) {
         ResponsableDao var3 = new ResponsableDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         List var4 = var3.chargerLesResponsablesDocument(this.tiers, var1);
         if (var4.size() != 0) {
            new Responsable();

            for(int var6 = 0; var6 < var4.size(); ++var6) {
               Responsable var5 = (Responsable)var4.get(var6);
               new Users();
               Users var7 = this.usersDao.selectByIdUsers(var5.getRpbuserid(), var1);
               if (var7 != null) {
                  this.lesUsers.add(var7);
               }
            }
         } else {
            var2 = this.usersDao.chargerLesSignataires("Achats", var1);
         }
      } else {
         ((List)var2).add(this.usersLog);
      }

      if (((List)var2).size() == 0) {
         ((List)var2).add(this.usersLog);
      }

      this.mesUsersItem.clear();
      if (this.usersLog.getUsrCommAchats() != 0 && this.usersLog.getUsrCommAchats() != 1) {
         this.mesUsersItem.add(new SelectItem(this.usersLog.getUsrid(), this.usersLog.getUsrPatronyme()));
      } else {
         for(int var8 = 0; var8 < ((List)var2).size(); ++var8) {
            Users var9 = (Users)((List)var2).get(var8);
            if (var9.getUsrAcheteur() == 1 && var9.getUsrPatronyme() != null && !var9.getUsrPatronyme().isEmpty()) {
               this.mesUsersItem.add(new SelectItem(var9.getUsrid(), var9.getUsrPatronyme()));
            }
         }

         if (this.mesUsersItem.size() == 0) {
            this.mesUsersItem.add(new SelectItem(this.usersLog.getUsrid(), this.usersLog.getUsrPatronyme()));
         }
      }

   }

   public void moreSearch() throws ParseException {
      if (!this.var_more_search) {
         this.var_more_search = true;
         this.periode = "100";
         this.inpDossier = "";
         String var1 = (new Date()).getYear() + 1900 + "-01-01";
         this.inpDu = this.utilDate.stringToDateSQLLight(var1);
         String var2 = (new Date()).getYear() + 1900 + "-12-31";
         this.inpAu = this.utilDate.stringToDateSQLLight(var2);
      } else {
         this.var_more_search = false;
         this.inpDu = null;
         this.inpAu = null;
         this.inpResponsable = "";
         this.inpDossier = "";
      }

   }

   public void executerRequete() throws IOException, HibernateException, NamingException, ParseException {
      this.inpIdTiersEnCours = 0L;
      this.inpNomTiersEnCours = "";
      this.chargeListeDetail((Session)null);
   }

   public void executerRequeteTiers() throws IOException, HibernateException, NamingException, ParseException {
      this.chargeListeDetail((Session)null);
   }

   public void chargeListeDetail(Session var1) throws HibernateException, NamingException, ParseException {
      this.lesEntetesList.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      double var2 = 0.0D;
      double var4 = 0.0D;
      this.var_nb_ligne = 0;
      String var6 = "";
      String var7 = "";
      if (this.var_more_search) {
         if (this.inpDu != null) {
            var6 = this.utilDate.dateToStringSQLLight(this.inpDu);
         }

         if (this.inpAu != null) {
            var7 = this.utilDate.dateToStringSQLLight(this.inpAu);
         }
      } else {
         var6 = null;
         var7 = null;
      }

      if (this.inpNum != null && !this.inpNum.isEmpty()) {
         this.inpEtat = 100;
      }

      if (this.inpEtat != 50) {
         this.lesEntetesList = this.reacheminementEnteteAchatsDao.recherche(var1, this.exercicesAchats.getExeachId(), this.inpNum, this.inpIdTiersEnCours, this.inpFournisseur, this.inpEtat, this.inpSerie, this.inpCat, this.periode, this.usersLog.getUsrid(), this.usersLog.getUsrAchats(), this.inpResponsable, this.inpDossier, var6, var7);
      }

      if (this.lesEntetesList.size() > 0) {
         this.datamodelEntete = new ListDataModel();
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
         new ReacheminementEnteteAchats();

         for(int var9 = 0; var9 < this.lesEntetesList.size(); ++var9) {
            ReacheminementEnteteAchats var8 = (ReacheminementEnteteAchats)this.lesEntetesList.get(var9);
            var2 += (double)var8.getReaTotPoidsBrut();
            var4 += (double)var8.getReaTotPoidsNet();
         }

         this.var_nb_ligne = this.lesEntetesList.size();
      }

      this.totauxBrutGlobal = var2;
      this.totauxNetGlobal = var4;
      this.visibiliteBton = false;
      this.inpNomTiersEnCours = "";
      this.inpIdTiersEnCours = 0L;
   }

   public void selectionLigne() throws JDOMException, IOException, HibernateException, NamingException {
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
            this.reacheminementEnteteAchats = (ReacheminementEnteteAchats)var1.get(0);
            this.inpNomTiersEnCours = this.reacheminementEnteteAchats.getReaNomTiers();
            this.inpIdTiersEnCours = this.reacheminementEnteteAchats.getTiers().getTieid();
            this.var_date = this.reacheminementEnteteAchats.getReaDate();
            if (this.reacheminementEnteteAchats.getReaDate().getHours() <= 9) {
               this.var_heure = "0" + this.reacheminementEnteteAchats.getReaDate().getHours();
            } else {
               this.var_heure = "" + this.reacheminementEnteteAchats.getReaDate().getHours();
            }

            if (this.reacheminementEnteteAchats.getReaDate().getMinutes() <= 9) {
               this.var_minute = "0" + this.reacheminementEnteteAchats.getReaDate().getMinutes();
            } else {
               this.var_minute = "" + this.reacheminementEnteteAchats.getReaDate().getMinutes();
            }

            if (this.reacheminementEnteteAchats.getReaDate().getSeconds() <= 9) {
               this.var_seconde = "0" + this.reacheminementEnteteAchats.getReaDate().getSeconds();
            } else {
               this.var_seconde = "" + this.reacheminementEnteteAchats.getReaDate().getSeconds();
            }

            this.tiers = this.reacheminementEnteteAchats.getTiers();
            this.formRecherche.setTiers(this.tiers);
            if (!this.reacheminementEnteteAchats.getTiers().getTiegenre().equalsIgnoreCase("010") && !this.reacheminementEnteteAchats.getTiers().getTiegenre().equalsIgnoreCase("020") && !this.reacheminementEnteteAchats.getTiers().getTiegenre().equalsIgnoreCase("030") && !this.reacheminementEnteteAchats.getTiers().getTiegenre().equalsIgnoreCase("037")) {
               this.var_typeTiers = true;
            } else {
               this.var_typeTiers = false;
            }

            this.calculMessageLitige();
            this.var_nom_contact = this.reacheminementEnteteAchats.getReaIdContact();
            this.var_nom_responsable = this.reacheminementEnteteAchats.getReaIdResponsable();
            Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReacheminementEntete");
            this.chargerDocumentLigne(var4);
            this.chargerReception(var4);
            this.chargerLesContactsItem(var4);
            this.chargerUserChrono(var4);
            this.chargerLesUsers(var4);
            this.chargerParapheur(var4);
            if (this.mesContactItem == null || this.mesContactItem.size() == 0) {
               this.mesContactItem.add(new SelectItem(0, ""));
               this.var_nom_contact = 0L;
            }

            if (this.mesUsersItem == null || this.mesUsersItem.size() == 0) {
               this.mesUsersItem.add(new SelectItem(0, ""));
               this.var_nom_responsable = 0L;
            }

            this.utilInitHibernate.closeSession();
            this.verrouNum = true;
            this.visibiliteBton = true;
         } else {
            this.visibiliteBton = false;
         }
      } else {
         this.visibiliteBton = false;
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException, ParseException {
      if (this.reacheminementEnteteAchats != null) {
         if (this.reacheminementEnteteAchats.getReaEtat() == 0) {
            this.modifDocument();
         } else {
            this.consultDocument();
         }
      }

   }

   public void chargerDocumentLigne(Session var1) throws HibernateException, NamingException {
      this.lesLignesList.clear();
      if (this.reacheminementEnteteAchats.getReaId() > 0L) {
         this.lesLignesList = this.reacheminementLigneAchatsDao.chargerLesLignes(this.reacheminementEnteteAchats, var1);
      }

      this.datamodelLigne.setWrappedData(this.lesLignesList);
   }

   public void chargerReception(Session var1) throws HibernateException, NamingException {
      if (this.reacheminementEnteteAchats.getReaId() > 0L) {
         this.mesReceptionsLignesItems.clear();
         ArrayList var2 = new ArrayList();
         new ArrayList();
         if (this.reacheminementEnteteAchats.getReaAnal4() != null && !this.reacheminementEnteteAchats.getReaAnal4().isEmpty()) {
            List var3;
            String[] var4;
            int var5;
            if (this.reacheminementEnteteAchats.getReaAnal4().contains(",")) {
               var4 = this.reacheminementEnteteAchats.getReaAnal4().split(":");
               this.receptionEnteteAchats = this.receptionEnteteAchatsDao.pourParapheur(var4[0], "", var1);
               if (this.receptionEnteteAchats != null) {
                  var3 = this.receptionLigneAchatsDao.chargerLesLignes(this.receptionEnteteAchats, var1);
                  if (var3.size() != 0) {
                     for(var5 = 0; var5 < var3.size(); ++var5) {
                        if (((ReceptionLigneAchats)var3.get(var5)).getRecligCode() != null && !((ReceptionLigneAchats)var3.get(var5)).getRecligCode().isEmpty() && ((ReceptionLigneAchats)var3.get(var5)).getRecligQteUtil() != 0.0F) {
                           var2.add(var3.get(var5));
                        }
                     }
                  }
               }
            } else {
               var4 = this.reacheminementEnteteAchats.getReaAnal4().split(",");
               var5 = var4.length;

               for(int var6 = 0; var6 < var4.length; ++var6) {
                  String[] var7 = var4[var6].split(":");
                  this.receptionEnteteAchats = this.receptionEnteteAchatsDao.pourParapheur(var7[0], "", var1);
                  if (this.receptionEnteteAchats != null) {
                     var3 = this.receptionLigneAchatsDao.chargerLesLignes(this.receptionEnteteAchats, var1);
                     if (var3.size() != 0) {
                        for(int var8 = 0; var8 < var3.size(); ++var8) {
                           if (((ReceptionLigneAchats)var3.get(var8)).getRecligCode() != null && !((ReceptionLigneAchats)var3.get(var8)).getRecligCode().isEmpty() && ((ReceptionLigneAchats)var3.get(var8)).getRecligQteUtil() != 0.0F) {
                              var2.add(var3.get(var8));
                           }
                        }
                     }
                  }
               }
            }

            if (var2.size() != 0) {
               for(int var9 = 0; var9 < var2.size(); ++var9) {
                  this.receptionLigneAchats = (ReceptionLigneAchats)var2.get(var9);
                  this.mesReceptionsLignesItems.add(new SelectItem(this.receptionLigneAchats.getRecligId(), this.receptionLigneAchats.getRecligCode() + ":" + this.receptionLigneAchats.getRecligLibelle() + "=" + this.receptionLigneAchats.getRecligQteUtil()));
               }
            }
         }
      }

   }

   public void chargerUserChrono(Session var1) throws HibernateException, NamingException {
      if (this.reacheminementEnteteAchats != null && this.reacheminementEnteteAchats.getReaSerie() != null && !this.reacheminementEnteteAchats.getReaSerie().isEmpty()) {
         this.usersChrono = this.usersChronoDao.selectUnique(this.reacheminementEnteteAchats.getReaSerie(), this.nature, this.usersLog, var1);
      }

   }

   public void chargerParapheur(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         if (this.parapheurDao == null) {
            this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
         }

         this.parapheur = this.parapheurDao.existenceParapheur(this.reacheminementEnteteAchats.getReaId(), this.nature, var1);
         if (this.parapheur == null) {
            this.parapheur = new Parapheur();
         }
      } else {
         this.parapheur = new Parapheur();
      }

   }

   public void ajoutDocument() throws IOException, JDOMException, HibernateException, NamingException {
      this.reacheminementEnteteAchats = new ReacheminementEnteteAchats();
      this.reacheminementLigneAchats = new ReacheminementLigneAchats();
      this.reacheminementEnteteAchats.setUsers(this.usersLog);
      this.reacheminementEnteteAchats.setReaIdCreateur(this.usersLog.getUsrid());
      this.reacheminementEnteteAchats.setReaNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.reacheminementEnteteAchats.setReaIdResponsable(this.usersLog.getUsrid());
      this.reacheminementEnteteAchats.setReaNomResponsable(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.reacheminementEnteteAchats.setReaDate(new Date());
      this.reacheminementEnteteAchats.setReaCat("Local");
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

      boolean var1 = false;
      int var3;
      if (this.optionAchats.getNbrJrRelanceREC() != null && !this.optionAchats.getNbrJrRelanceREC().isEmpty()) {
         var3 = Integer.parseInt(this.optionAchats.getNbrJrRelanceREC());
      } else {
         var3 = 0;
      }

      boolean var2 = false;
      int var4;
      if (this.optionAchats.getNbrJrValidREC() != null && !this.optionAchats.getNbrJrValidREC().isEmpty()) {
         var4 = Integer.parseInt(this.optionAchats.getNbrJrValidREC());
      } else {
         var4 = 0;
      }

      this.reacheminementEnteteAchats.setReaDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var3));
      this.reacheminementEnteteAchats.setReaDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var4));
      this.reacheminementEnteteAchats.setReaDateLivraison((Date)null);
      this.var_nom_responsable = 0L;
      this.lesLignesList.clear();
      this.mesContactItem.clear();
      this.mesContactItem.add(new SelectItem(0, ""));
      this.lesUsers.clear();
      this.mesUsersItem.clear();
      this.mesUsersItem.add(new SelectItem(0, ""));
      this.lesReceptions.clear();
      this.dataModelReceptions.setWrappedData(this.lesReceptions);
      this.lesReceptionsSelectionnees.clear();
      this.var_action = 1;
      this.informationsTiers = null;
      this.var_memo_action = this.var_action;
      this.var_aff_action = false;
      this.var_valide_doc = false;
      this.var_aff_detail_tiers = false;
      this.verrouNum = false;
      this.var_typeTiers = true;
      this.visibleOnglet = false;
      this.visibiliteBtonlig = true;
      this.visibilitefactor = false;
      this.visibiliteterme = false;
      this.visibilitenbrjr = false;
      this.visibiliteencaissemt = false;
      this.affiche_ligne = false;
      this.totauxBrut = 0.0D;
      this.totauxNet = 0.0D;
      this.totauxSac = 0;
      this.totauxCamion = 0;
      this.autorisationDocument();
   }

   public void modifDocument() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      if (this.reacheminementEnteteAchats != null) {
         this.reacheminementEnteteAchats = this.reacheminementEnteteAchatsDao.modif(this.reacheminementEnteteAchats);
         this.var_action = 1;
         this.var_memo_action = this.var_action;
         this.var_aff_action = false;
         this.visibleOnglet = true;
         this.var_valide_doc = true;
         this.var_aff_detail_tiers = true;
         if (this.usersLog.getUsrSignatureAchats() != 1 && this.var_nom_responsable != 0L) {
            this.mesUsersItem.clear();
            this.mesUsersItem.add(new SelectItem(this.reacheminementEnteteAchats.getReaIdResponsable(), this.reacheminementEnteteAchats.getReaNomResponsable()));
         }

         this.autorisationDocument();
         this.genereCamion();
      }

   }

   public void consultDocument() throws JDOMException, IOException {
      if (this.reacheminementEnteteAchats != null) {
         this.var_action = 2;
         this.var_memo_action = this.var_action;
         this.var_aff_action = true;
         this.visibleOnglet = true;
         this.var_valide_doc = true;
         this.var_aff_detail_tiers = true;
         this.mesUsersItem.clear();
         this.mesUsersItem.add(new SelectItem(this.reacheminementEnteteAchats.getReaIdResponsable(), this.reacheminementEnteteAchats.getReaNomResponsable()));
         this.autorisationDocument();
         this.cumulPrix();
      }

   }

   public void valideDocument() throws HibernateException, NamingException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "CalculMouvementStock");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         long var3 = this.reacheminementEnteteAchats.getTiers().getTieid();
         if (this.reacheminementEnteteAchats.getReaEtat() == 0 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
            this.reacheminementEnteteAchats.setReaEtat(1);
            if (this.reacheminementEnteteAchats.getReaAnal4() != null && !this.reacheminementEnteteAchats.getReaAnal4().isEmpty()) {
               new ValorisationEnteteAchats();
               ValorisationEnteteAchatsDao var6 = new ValorisationEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
               ValorisationEnteteAchats var5 = var6.rechercheByDossier(this.reacheminementEnteteAchats.getReaAnal4(), var1);
               if (var5 != null) {
                  this.reacheminementEnteteAchats.setReaValo(var5.getValNum());
               }
            }

            this.reacheminementEnteteAchats = this.reacheminementEnteteAchatsDao.modif(this.reacheminementEnteteAchats, var1);
            this.calculStock.majReacheminementAchatsVAL(this.lesLignesList, 1, this.baseLog, var1);
            Espion var12 = new Espion();
            var12.setUsers(this.usersLog);
            var12.setEsptype(0);
            var12.setEspdtecreat(new Date());
            var12.setEspaction("Validation manuelle réacheminement N° " + this.reacheminementEnteteAchats.getReaNum() + " du " + this.utilDate.dateToStringSQLLight(this.reacheminementEnteteAchats.getReaDate()));
            this.espionDao.mAJEspion(var12, var1);
         }

         if (this.tiers.getTieDteDocument3() == null || this.reacheminementEnteteAchats.getReaDate().after(this.tiers.getTieDteDocument3())) {
            this.tiers = this.tiersDao.selectTierD(var3, var1);
            if (this.tiers != null) {
               this.tiers.setTieDteDocument3(this.reacheminementEnteteAchats.getReaDate());
               this.tiers = this.tiersDao.modif(this.tiers, var1);
            }
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

   }

   public void deValideDocument() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "CalculMouvementStock");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.reacheminementEnteteAchats.getReaEtat() == 1) {
            this.reacheminementEnteteAchats.setReaEtat(0);
            this.reacheminementEnteteAchats.setReaDateImp((Date)null);
            this.reacheminementEnteteAchats = this.reacheminementEnteteAchatsDao.modif(this.reacheminementEnteteAchats, var1);
         }

         this.calculStock.majReacheminementAchatsVAL(this.lesLignesList, 2, this.baseLog, var1);
         Espion var3 = new Espion();
         var3.setUsers(this.usersLog);
         var3.setEsptype(0);
         var3.setEspdtecreat(new Date());
         var3.setEspaction("Dévalidation manuelle réacheminement N° " + this.reacheminementEnteteAchats.getReaNum() + " du " + this.utilDate.dateToStringSQLLight(this.reacheminementEnteteAchats.getReaDate()));
         this.espionDao.mAJEspion(var3, var1);
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

   public void reactiverDocument() throws HibernateException, NamingException {
      if (this.reacheminementEnteteAchats != null) {
         this.reacheminementEnteteAchats.setReaEtat(0);
         this.reacheminementEnteteAchats.setReaDateAnnule((Date)null);
         this.reacheminementEnteteAchats.setReaMotifAnnule("");
         this.reacheminementEnteteAchats = this.reacheminementEnteteAchatsDao.modif(this.reacheminementEnteteAchats);
      }

   }

   public void supprimerDocument() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertAch");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.lesEntetesList.remove(this.reacheminementEnteteAchats);
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
         long var3 = this.reacheminementEnteteAchats.getReaId();
         String var5 = this.reacheminementEnteteAchats.getReaNum();
         Date var6 = this.reacheminementEnteteAchats.getReaDate();
         if (this.lesLignesList.size() != 0) {
            for(int var7 = 0; var7 < this.lesLignesList.size(); ++var7) {
               this.reacheminementLigneAchats = new ReacheminementLigneAchats();
               this.reacheminementLigneAchats = (ReacheminementLigneAchats)this.lesLignesList.get(var7);
            }
         }

         this.reacheminementLigneAchatsDao.deleteAllLigne(this.reacheminementEnteteAchats, var1);
         this.utilParapheur.supprimerParapheur(this.reacheminementEnteteAchats.getReaId(), this.nature, var1);
         this.reacheminementEnteteAchatsDao.delete(this.reacheminementEnteteAchats.getReaId(), var1);
         Espion var13 = new Espion();
         var13.setUsers(this.usersLog);
         var13.setEsptype(0);
         var13.setEspdtecreat(new Date());
         var13.setEspaction("Suppression réacheminement N° " + var5 + " du " + var6);
         this.espionDao.mAJEspion(var13, var1);
         var2.commit();
      } catch (HibernateException var11) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var11;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.visibiliteBton = false;
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
   }

   public void annule() throws IOException, JDOMException {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.visibleOnglet = false;
      this.visibiliteBton = false;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public void save() throws IOException, HibernateException, NamingException, Exception {
      this.verifieExistenceHabilitation((Session)null);
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReacheminementEntete");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.cumulPrix();
         this.reacheminementEnteteAchats.setReaDate(this.utilDate.dateToSQL(this.var_date, this.var_heure, this.var_minute, this.var_seconde));
         if (this.reacheminementEnteteAchats.getUsers() == null) {
            this.reacheminementEnteteAchats.setUsers(this.usersLog);
         }

         this.reacheminementEnteteAchats.setTiers(this.tiers);
         if ((this.reacheminementEnteteAchats.getReaCat() == null || this.reacheminementEnteteAchats.getReaCat().isEmpty()) && this.reacheminementEnteteAchats.getTiers().getTienomfamille() != null && !this.reacheminementEnteteAchats.getTiers().getTienomfamille().isEmpty()) {
            this.reacheminementEnteteAchats.setReaCat(this.reacheminementEnteteAchats.getTiers().getTienomfamille());
         }

         if (!this.reacheminementEnteteAchats.getTiers().getTiegenre().equalsIgnoreCase("010") && !this.reacheminementEnteteAchats.getTiers().getTiegenre().equalsIgnoreCase("020") && !this.reacheminementEnteteAchats.getTiers().getTiegenre().equalsIgnoreCase("030") && !this.reacheminementEnteteAchats.getTiers().getTiegenre().equalsIgnoreCase("037")) {
            this.reacheminementEnteteAchats.setReaCivilTiers("");
         } else {
            this.reacheminementEnteteAchats.setReaCivilTiers(this.reacheminementEnteteAchats.getTiers().getTiecivilite());
         }

         if (this.reacheminementEnteteAchats.getReaDiversTiers() == 99) {
            this.reacheminementEnteteAchats.setReaIdContact(0L);
            this.reacheminementEnteteAchats.setReaNomContact("");
            this.reacheminementEnteteAchats.setReaCivilContact("");
         } else {
            new Contacts();
            Contacts var3 = this.contactDao.recupererContacts(this.var_nom_contact, var1);
            if (var3 != null) {
               this.reacheminementEnteteAchats.setReaIdContact(var3.getConid());
               this.reacheminementEnteteAchats.setReaNomContact(var3.getConpatronyme());
               this.reacheminementEnteteAchats.setReaCivilContact(var3.getConcivilite());
            } else {
               this.reacheminementEnteteAchats.setReaIdContact(0L);
               this.reacheminementEnteteAchats.setReaNomContact("");
               this.reacheminementEnteteAchats.setReaCivilContact("");
            }
         }

         new Users();
         if (this.var_nom_responsable == 0L && this.mesUsersItem.size() == 1) {
            this.var_nom_responsable = Long.parseLong(((SelectItem)this.mesUsersItem.get(0)).getValue().toString());
         }

         Users var15 = this.usersDao.selectLeUserPatronyme(this.reacheminementEnteteAchats.getReaNomResponsable(), var1);
         if (var15 != null) {
            this.reacheminementEnteteAchats.setReaIdResponsable(var15.getUsrid());
            this.reacheminementEnteteAchats.setReaNomResponsable(var15.getUsrPatronyme());
         } else {
            this.reacheminementEnteteAchats.setReaIdResponsable(0L);
            this.reacheminementEnteteAchats.setReaNomResponsable("");
         }

         if (this.reacheminementEnteteAchats.getReaValorisation() == 0 && this.reacheminementEnteteAchats.getReaCoefValo() == 0.0F) {
            this.reacheminementEnteteAchats.setReaCoefValo(1.0F);
         }

         if (this.reacheminementEnteteAchats.getReaId() != 0L) {
            this.reacheminementEnteteAchats.setReaDateModif(new Date());
            this.reacheminementEnteteAchats.setReaIdModif(this.usersLog.getUsrid());
            this.reacheminementEnteteAchats.setReaNomModif(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.reacheminementEnteteAchats = this.reacheminementEnteteAchatsDao.modif(this.reacheminementEnteteAchats, var1);
            this.var_action = 0;
            this.var_memo_action = this.var_action;
            this.visibleOnglet = false;
         } else {
            this.reacheminementEnteteAchats.setExercicesAchats(this.exercicesAchats);
            this.reacheminementEnteteAchats.setReaDateCreat(new Date());
            this.reacheminementEnteteAchats.setReaIdCreateur(this.usersLog.getUsrid());
            this.reacheminementEnteteAchats.setReaNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            if (this.reacheminementEnteteAchats.getReaSerie() != null && !this.reacheminementEnteteAchats.getReaSerie().equalsIgnoreCase("X") && !this.reacheminementEnteteAchats.getReaSerie().isEmpty()) {
               this.reacheminementEnteteAchats.setReaNum(this.calculChrono.numCompose(this.reacheminementEnteteAchats.getReaDate(), this.nature, this.reacheminementEnteteAchats.getReaSerie(), var1));
               boolean var16 = false;

               label266:
               while(true) {
                  while(true) {
                     if (var16) {
                        break label266;
                     }

                     new ReacheminementEnteteAchats();
                     ReacheminementEnteteAchats var5 = this.reacheminementEnteteAchatsDao.pourParapheur(this.reacheminementEnteteAchats.getReaNum(), this.reacheminementEnteteAchats.getReaSerie(), var1);
                     if (var5 != null) {
                        long var6 = 100000000L * this.usersLog.getUsrid();

                        for(long var8 = 0L; var8 < var6; ++var8) {
                        }

                        this.reacheminementEnteteAchats.setReaNum(this.calculChrono.numCompose(this.reacheminementEnteteAchats.getReaDate(), this.nature, this.reacheminementEnteteAchats.getReaSerie(), var1));
                        var16 = false;
                     } else {
                        var16 = true;
                     }
                  }
               }
            } else {
               long var4 = this.reacheminementEnteteAchatsDao.selectLastNum(var1);
               this.reacheminementEnteteAchats.setReaNum("" + var4);
            }

            this.reacheminementEnteteAchats.setReaEtat(0);
            this.reacheminementEnteteAchats.setReaEtatVal(0);
            this.reacheminementEnteteAchats.setReaDateValide((Date)null);
            this.reacheminementEnteteAchats = this.reacheminementEnteteAchatsDao.insert(this.reacheminementEnteteAchats, var1);
            this.visibleOnglet = true;
            this.var_action = 1;
            this.var_memo_action = this.var_action;
            this.lesEntetesList.add(this.reacheminementEnteteAchats);
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
         }

         if (this.lesLignesList.size() != 0) {
            for(int var17 = 0; var17 < this.lesLignesList.size(); ++var17) {
               this.reacheminementLigneAchats = (ReacheminementLigneAchats)this.lesLignesList.get(var17);
               if (this.reacheminementLigneAchats.getRealigId() == 0L) {
                  this.reacheminementLigneAchats.setReacheminementEnteteAchats(this.reacheminementEnteteAchats);
                  this.reacheminementLigneAchats = this.reacheminementLigneAchatsDao.insertLigne(this.reacheminementLigneAchats, var1);
               }
            }
         }

         if (this.habilitation != null && this.var_action == 0) {
            this.utilParapheur.majParapheur(this.nature, this.habilitation, this.reacheminementEnteteAchats.getReaId(), this.reacheminementEnteteAchats.getReaNum(), this.reacheminementEnteteAchats.getReaNomTiers(), this.reacheminementEnteteAchats.getReaDate(), this.structureLog.getStrdevise(), this.reacheminementEnteteAchats.getReaTotTtc() + this.reacheminementEnteteAchats.getReaTotTc(), this.reacheminementEnteteAchats.getReaModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, this.nature), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(var1), (String)null, this.reacheminementEnteteAchats.getVar_format_devise(), 0, var1);
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

   public boolean verifieExistenceHabilitation(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         this.reacheminementEnteteAchats.setReaEtatVal(1);
         this.reacheminementEnteteAchats.setReaEtat(0);
         this.reacheminementEnteteAchats.setReaDateValide((Date)null);
         return true;
      } else {
         this.reacheminementEnteteAchats.setReaEtatVal(0);
         this.chargerUserChrono(var1);
         if (this.usersChrono != null) {
            if (this.usersChrono.getUsrchrValidation() == 0) {
               this.reacheminementEnteteAchats.setReaEtat(1);
               this.reacheminementEnteteAchats.setReaDateValide(new Date());
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2 && this.usersChrono.getUsrchrValidation() == 3) {
               this.reacheminementEnteteAchats.setReaEtat(0);
               this.reacheminementEnteteAchats.setReaDateValide((Date)null);
            }
         }

         return false;
      }
   }

   public void annulerDocument() {
      if (this.reacheminementEnteteAchats != null) {
         this.reacheminementEnteteAchats.setReaDateAnnule(new Date());
         this.showModalPanelAnnuler = true;
      }

   }

   public void annuleAnnulation() {
      this.showModalPanelAnnuler = false;
   }

   public void miseajourAnnuler() throws HibernateException, NamingException {
      if (this.reacheminementEnteteAchats != null) {
         if (this.reacheminementEnteteAchats.getReaDateAnnule() == null) {
            this.reacheminementEnteteAchats.setReaDateAnnule(new Date());
         }

         this.reacheminementEnteteAchats.setReaEtat(3);
         this.reacheminementEnteteAchats = this.reacheminementEnteteAchatsDao.modif(this.reacheminementEnteteAchats);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         var1.setEspaction("Annulation réacheminement achat N° " + this.reacheminementEnteteAchats.getReaNum() + " le " + this.reacheminementEnteteAchats.getReaDateAnnule());
         this.espionDao.mAJEspion(var1);
         this.lesEntetesList.remove(this.reacheminementEnteteAchats);
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
      }

      this.showModalPanelAnnuler = false;
      this.visibiliteBton = false;
   }

   public void ouvrirSelection() throws HibernateException, NamingException {
      this.lesReceptions.clear();
      this.dataModelReceptions.setWrappedData(this.lesReceptions);
      this.mesReceptionsLignesItems.clear();
      this.receptionDu = this.exercicesAchats.getExeachDateDebut();
      this.receptionAu = this.exercicesAchats.getExeachDateFin();
      if (this.lesReceptionsSelectionnees.size() != 0) {
         for(int var1 = 0; var1 < this.lesReceptionsSelectionnees.size(); ++var1) {
            String[] var2 = ((String)this.lesReceptionsSelectionnees.get(var1)).toString().split(":");
            this.receptionEnteteAchats = this.receptionEnteteAchatsDao.pourParapheur(var2[0], "", (Session)null);
            if (this.receptionEnteteAchats != null) {
               this.receptionEnteteAchats.setVar_select_ligne(true);
               this.lesReceptions.add(this.receptionEnteteAchats);
            }
         }
      }

      this.showModalPanelReception = true;
   }

   public void fermerSelection() {
      this.showModalPanelReception = false;
   }

   public void selectionReception() throws HibernateException, NamingException {
      this.lesReceptions.clear();
      String var1 = this.utilDate.dateToStringSQLLight(this.receptionDu) + " 00:00:00";
      String var2 = this.utilDate.dateToStringSQLLight(this.receptionAu) + " 23:59:59";
      this.lesReceptions = this.receptionEnteteAchatsDao.rechercheReceptionByDate(var1, var2, (Session)null);
      this.dataModelReceptions.setWrappedData(this.lesReceptions);
      if (this.lesReceptionsSelectionnees.size() != 0) {
         for(int var3 = 0; var3 < this.lesReceptionsSelectionnees.size(); ++var3) {
            String[] var4 = ((String)this.lesReceptionsSelectionnees.get(var3)).toString().split(":");
            this.receptionEnteteAchats = this.receptionEnteteAchatsDao.pourParapheur(var4[0], "", (Session)null);
            if (this.receptionEnteteAchats != null) {
               boolean var5 = false;

               for(int var6 = 0; var6 < this.lesReceptions.size(); ++var6) {
                  if (((ReceptionEnteteAchats)this.lesReceptions.get(var6)).getRecNum().equals(var4[0])) {
                     this.receptionEnteteAchats = (ReceptionEnteteAchats)this.lesReceptions.get(var6);
                     var5 = true;
                     break;
                  }
               }

               if (!var5) {
                  this.receptionEnteteAchats.setVar_select_ligne(true);
                  this.lesReceptions.add(this.receptionEnteteAchats);
               } else {
                  this.receptionEnteteAchats.setVar_select_ligne(true);
                  this.lesReceptions.remove(this.receptionEnteteAchats);
                  this.lesReceptions.add(this.receptionEnteteAchats);
               }
            }
         }
      }

   }

   public void validerSelection() throws HibernateException, NamingException {
      String var1 = "";
      ArrayList var2 = new ArrayList();
      new ArrayList();
      if (this.lesReceptions.size() != 0) {
         int var4;
         for(var4 = 0; var4 < this.lesReceptions.size(); ++var4) {
            this.receptionEnteteAchats = (ReceptionEnteteAchats)this.lesReceptions.get(var4);
            if (this.receptionEnteteAchats.isVar_select_ligne()) {
               this.lesReceptionsSelectionnees.add(this.receptionEnteteAchats.getRecNum() + ":" + this.receptionEnteteAchats.getRecAnal4());
               if (var1 != null && !var1.isEmpty()) {
                  var1 = var1 + "," + this.receptionEnteteAchats.getRecNum() + ":" + this.receptionEnteteAchats.getRecAnal4();
               } else {
                  var1 = this.receptionEnteteAchats.getRecNum() + ":" + this.receptionEnteteAchats.getRecAnal4();
               }

               List var3 = this.receptionLigneAchatsDao.chargerLesLignes((ReceptionEnteteAchats)this.receptionEnteteAchats, (Session)null);
               if (var3.size() != 0) {
                  for(int var5 = 0; var5 < var3.size(); ++var5) {
                     if (((ReceptionLigneAchats)var3.get(var5)).getRecligCode() != null && !((ReceptionLigneAchats)var3.get(var5)).getRecligCode().isEmpty() && ((ReceptionLigneAchats)var3.get(var5)).getRecligQteUtil() != 0.0F) {
                        var2.add(var3.get(var5));
                     }
                  }
               }
            }
         }

         if (var2.size() != 0) {
            for(var4 = 0; var4 < var2.size(); ++var4) {
               this.receptionLigneAchats = (ReceptionLigneAchats)var2.get(var4);
               this.mesReceptionsLignesItems.add(new SelectItem(this.receptionLigneAchats.getRecligId(), this.receptionLigneAchats.getRecligCode() + ":" + this.receptionLigneAchats.getRecligLibelle() + "=" + this.receptionLigneAchats.getRecligQteUtil()));
            }
         }
      }

      this.reacheminementEnteteAchats.setReaAnal4(var1);
      this.showModalPanelReception = false;
   }

   public void genereCamion() {
      int var1 = this.lesLignesList.size();
      int var2;
      if (var1 < this.reacheminementEnteteAchats.getReaTotNbCamion()) {
         for(var2 = var1; var2 < this.reacheminementEnteteAchats.getReaTotNbCamion(); ++var2) {
            this.reacheminementLigneAchats = new ReacheminementLigneAchats();
            this.reacheminementLigneAchats.setRealigOrdre(var2 + 1);
            this.lesLignesList.add(this.reacheminementLigneAchats);
         }
      } else if (var1 != this.reacheminementEnteteAchats.getReaTotNbCamion() && var1 > this.reacheminementEnteteAchats.getReaTotNbCamion()) {
         for(var2 = this.lesLignesList.size(); var2 == 0; --var2) {
            if (this.lesLignesList.size() > this.reacheminementEnteteAchats.getReaTotNbCamion()) {
               this.lesLignesList.remove(var2);
            }
         }
      }

      this.datamodelLigne.setWrappedData(this.lesLignesList);
      if (this.lesLignesList.size() != 0) {
         this.affiche_ligne = true;
      } else {
         this.affiche_ligne = false;
      }

      this.cumulPrix();
   }

   public void cumulPrix() {
      float var1 = 0.0F;
      float var2 = 0.0F;
      int var3 = 0;
      int var4 = 0;
      new ReacheminementLigneAchats();

      for(int var6 = 0; var6 < this.lesLignesList.size(); ++var6) {
         ReacheminementLigneAchats var5 = (ReacheminementLigneAchats)this.lesLignesList.get(var6);
         var1 += var5.getRealigDestPoidsBrut();
         var2 += var5.getRealigDestPoidsNet();
         var3 += var5.getRealigDestNbSac();
         ++var4;
      }

      this.reacheminementEnteteAchats.setReaTotPoidsBrut(var1);
      this.reacheminementEnteteAchats.setReaTotPoidsNet(var2);
      this.reacheminementEnteteAchats.setReaTotNbSac(var3);
      this.reacheminementEnteteAchats.setReaTotNbCamion(var4);
      this.totauxBrut = (double)this.reacheminementEnteteAchats.getReaTotPoidsBrut();
      this.totauxNet = (double)this.reacheminementEnteteAchats.getReaTotPoidsNet();
      this.totauxSac = this.reacheminementEnteteAchats.getReaTotNbSac();
      this.totauxCamion = this.reacheminementEnteteAchats.getReaTotNbCamion();
   }

   public void selectionLigneDetail() throws HibernateException, NamingException {
      if (this.datamodelLigne.isRowAvailable()) {
         this.reacheminementLigneAchats = (ReacheminementLigneAchats)this.datamodelLigne.getRowData();
         this.affiche_ligne = true;
         if (this.reacheminementLigneAchats.getRealigOrigDate() == null) {
            this.reacheminementLigneAchats.setRealigOrigDate(new Date());
         }
      }

   }

   public void calculeSelectionLigneReception() throws HibernateException, NamingException {
      if (this.reacheminementLigneAchats.getRealigIdRec() != 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReceptionEntete");
         this.receptionLigneAchats = this.receptionLigneAchatsDao.rechercheReception(this.reacheminementLigneAchats.getRealigIdRec(), var1);
         if (this.receptionLigneAchats != null) {
            this.reacheminementLigneAchats.setRealigCode(this.receptionLigneAchats.getRecligCode());
            this.reacheminementLigneAchats.setRealigCondition(this.receptionLigneAchats.getRecligCondition());
            this.reacheminementLigneAchats.setRealigCouleur(this.receptionLigneAchats.getRecligCouleur());
            this.reacheminementLigneAchats.setRealigDescription(this.receptionLigneAchats.getRecligDescription());
            this.reacheminementLigneAchats.setRealigDouane(this.receptionLigneAchats.getRecligDouane());
            this.reacheminementLigneAchats.setRealigDiam(this.receptionLigneAchats.getRecligDiam());
            this.reacheminementLigneAchats.setRealigEchelle(this.receptionLigneAchats.getRecligEchelle());
            this.reacheminementLigneAchats.setRealigFamille(this.receptionLigneAchats.getRecligFamille());
            this.reacheminementLigneAchats.setRealigGr(this.receptionLigneAchats.getRecligGr());
            this.reacheminementLigneAchats.setRealigHaut(this.receptionLigneAchats.getRecligHaut());
            this.reacheminementLigneAchats.setRealigLarg(this.receptionLigneAchats.getRecligLarg());
            this.reacheminementLigneAchats.setRealigLibelle(this.receptionLigneAchats.getRecligLibelle());
            this.reacheminementLigneAchats.setRealigMode(this.receptionLigneAchats.getRecligMode());
            this.reacheminementLigneAchats.setRealigNb(this.receptionLigneAchats.getRecligNb());
            this.reacheminementLigneAchats.setRealigOrigDate(new Date());
            this.reacheminementLigneAchats.setRealigOrigDepot(this.receptionLigneAchats.getRecligCode());
            float var2 = 0.0F;
            var2 = this.reacheminementLigneAchatsDao.chargerLesReliquatsReceptionAchs(this.receptionLigneAchats.getRecligId(), this.reacheminementEnteteAchats.getReaTypeMarchandise(), var1);
            if (this.reacheminementEnteteAchats.getReaTypeMarchandise() == 0) {
               this.reacheminementLigneAchats.setRealigOrigPoidsBrut(this.receptionLigneAchats.getRecligQteUtil() - var2);
            } else if (this.reacheminementEnteteAchats.getReaTypeMarchandise() == 1) {
               this.reacheminementLigneAchats.setRealigOrigNbSac((int)(this.receptionLigneAchats.getRecligQteUtil() - var2));
            } else if (this.reacheminementEnteteAchats.getReaTypeMarchandise() == 2) {
               this.reacheminementLigneAchats.setRealigOrigQte(this.receptionLigneAchats.getRecligQteUtil() - var2);
            }

            this.reacheminementLigneAchats.setRealigPr(this.receptionLigneAchats.getRecligPr());
            this.reacheminementLigneAchats.setRealigPump(this.receptionLigneAchats.getRecligPump());
            this.reacheminementLigneAchats.setRealigStock(this.receptionLigneAchats.getRecligStock());
            this.reacheminementLigneAchats.setRealigSommier(this.receptionLigneAchats.getRecligSommier());
            this.reacheminementLigneAchats.setRealigTauxDouane(this.receptionLigneAchats.getRecligTauxDouane());
            this.reacheminementLigneAchats.setRealigUnite(this.receptionLigneAchats.getRecligUnite());
            this.reacheminementLigneAchats.setRealigVolume(this.receptionLigneAchats.getRecligVolume());
         }

         this.utilInitHibernate.closeSession();
      }

   }

   public void calculPoidsNet() {
      float var1 = 0.12F;
      if (this.reacheminementEnteteAchats.getReaTypeMarchandise() == 0) {
         this.reacheminementLigneAchats.setRealigOrigPoidsNet(this.reacheminementLigneAchats.getRealigOrigPoidsBrut() * (float)this.reacheminementLigneAchats.getRealigOrigNbSac() + (float)this.reacheminementLigneAchats.getRealigOrigNbSac() * var1);
      } else if (this.reacheminementEnteteAchats.getReaTypeMarchandise() == 1) {
         this.reacheminementLigneAchats.setRealigOrigPoidsBrut(this.reacheminementLigneAchats.getRealigOrigPoidsBrut() * (float)this.reacheminementLigneAchats.getRealigOrigNbSac() - (float)this.reacheminementLigneAchats.getRealigOrigNbSac() * var1);
      } else if (this.reacheminementEnteteAchats.getReaTypeMarchandise() == 2) {
         this.reacheminementLigneAchats.setRealigOrigPoidsNet(this.reacheminementLigneAchats.getRealigOrigPoidsBrut() * (float)this.reacheminementLigneAchats.getRealigOrigNbSac());
      }

   }

   public void saveOneLigneAnnonce() throws IOException, HibernateException, NamingException, Exception {
      if (this.reacheminementEnteteAchats.getReaId() == 0L) {
         this.save();
      }

      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReacheminementEntete");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.reacheminementLigneAchats.getRealigOrigQteUtil() == 0.0F) {
            this.reacheminementLigneAchats.setRealigOrigQteUtil(this.reacheminementLigneAchats.getRealigOrigQte());
         }

         if (this.reacheminementLigneAchats.getRealigId() == 0L) {
            this.reacheminementLigneAchats.setReacheminementEnteteAchats(this.reacheminementEnteteAchats);
            this.reacheminementLigneAchats = this.reacheminementLigneAchatsDao.insertLigne(this.reacheminementLigneAchats, var1);
            this.lesLignesList.add(this.reacheminementLigneAchats);
            this.datamodelLigne.setWrappedData(this.lesLignesList);
         } else {
            this.reacheminementLigneAchats = this.reacheminementLigneAchatsDao.modifLigne(this.reacheminementLigneAchats, var1);
         }

         this.cumulPrix();
         this.reacheminementEnteteAchats = this.reacheminementEnteteAchatsDao.modif(this.reacheminementEnteteAchats, var1);
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

   public void rechercheTiers() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.tiers = this.formRecherche.rechercheTiers(0, this.reacheminementEnteteAchats.getReaNomTiers(), this.nature);
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

   public void recuperationTiers() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.tiers = this.formRecherche.calculeTiers();
      this.calculeTiers();
   }

   public void calculeTiers() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      if (this.tiers != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Tiers");
         this.reacheminementEnteteAchats.setTiers(this.tiers);
         if (!this.tiers.getTiegenre().equalsIgnoreCase("010") && !this.tiers.getTiegenre().equalsIgnoreCase("020") && !this.tiers.getTiegenre().equalsIgnoreCase("030") && !this.tiers.getTiegenre().equalsIgnoreCase("037")) {
            this.nomTier = this.tiers.getTieraisonsocialenom();
            this.reacheminementEnteteAchats.setReaCivilTiers("");
            this.var_typeTiers = true;
         } else {
            this.nomTier = this.tiers.getTieraisonsocialenom() + " " + this.tiers.getTieprenom();
            this.reacheminementEnteteAchats.setReaCivilTiers(this.reacheminementEnteteAchats.getTiers().getTiecivilite());
            this.var_typeTiers = false;
         }

         this.reacheminementEnteteAchats.setReaNomTiers(this.nomTier);
         this.calculMessageLitige();
         String var2 = "";
         if (this.tiers.getTiemodereg() != null && !this.tiers.getTiemodereg().isEmpty() && this.tiers.getTiemodereg().contains(":")) {
            String[] var3 = this.tiers.getTiemodereg().split(":");
            var2 = var3[0];
         } else if (this.tiers.getTiemodereg() != null && !this.tiers.getTiemodereg().isEmpty() && !this.tiers.getTiemodereg().contains(":")) {
            var2 = this.tiers.getTiemodereg();
         }

         this.reacheminementEnteteAchats.setReaJournalReg(this.tiers.getTiejournalreg());
         this.reacheminementEnteteAchats.setReaCat(this.tiers.getTienomfamille());
         this.reacheminementEnteteAchats.setReaExoDouane(this.tiers.getTieexodouane());
         this.reacheminementEnteteAchats.setReaExoTva(this.tiers.getTieexotva());
         if (this.tiers.getTiecategorie().equalsIgnoreCase("Fournisseur Divers")) {
            this.reacheminementEnteteAchats.setReaDiversTiers(99);
         } else {
            this.reacheminementEnteteAchats.setReaDiversTiers(0);
            this.reacheminementEnteteAchats.setReaDiversNom("");
            this.reacheminementEnteteAchats.setReaDiversAdresse("");
            this.reacheminementEnteteAchats.setReaDiversVille("");
            this.reacheminementEnteteAchats.setReaDiversTel("");
            this.reacheminementEnteteAchats.setReaDiversMail("");
         }

         if (this.tiers.getTiedevise() != null && !this.tiers.getTiedevise().isEmpty()) {
            this.reacheminementEnteteAchats.setReaDevise(this.tiers.getTiedevise());
         } else {
            this.reacheminementEnteteAchats.setReaDevise(this.structureLog.getStrdevise());
         }

         if (this.tiers.getTiecodepays().equalsIgnoreCase(this.structureLog.getStrcodepays())) {
            this.reacheminementEnteteAchats.setReaCat("Local");
            this.reacheminementEnteteAchats.setReaValorisation(0);
            this.reacheminementEnteteAchats.setReaCoefValo(1.0F);
         } else {
            this.reacheminementEnteteAchats.setReaCat("Import");
            this.reacheminementEnteteAchats.setReaValorisation(1);
            this.reacheminementEnteteAchats.setReaCoefValo(0.0F);
         }

         this.mesContactItem.clear();
         this.chargerLesContactsItem(var1);
         this.chargerLesUsers(var1);
         this.utilInitHibernate.closeSession();
      } else {
         this.annuleTiers();
      }

      this.calculDeviseCategorie();
      this.controleSaisie();
      this.var_action = this.var_memo_action;
   }

   public void calculMessageLitige() {
      this.informationsTiers = null;
      if (this.tiers != null) {
         if (this.tiers.getTiecomptebloque() == 1) {
            this.informationsTiers = "***   COMPTE BLOQUE   ***";
         } else if (this.tiers.getTiechequeinterdit() == 1) {
            this.informationsTiers = "***   CHEQUE INTERDIT   ***";
         }

         if (this.tiers.getTieobservations() != null && !this.tiers.getTieobservations().isEmpty()) {
            this.informationsTiers = this.informationsTiers + "   (" + this.tiers.getTieobservations() + ")";
         }
      }

   }

   public void annuleTiers() throws ParseException {
      this.tiers = null;
      this.informationsTiers = null;
      this.reacheminementEnteteAchats.setTiers(this.tiers);
      this.reacheminementEnteteAchats.setReaNomTiers("");
      this.reacheminementEnteteAchats.setReaCivilTiers("");
      this.mesContactItem.clear();
      this.mesContactItem.add(new SelectItem(0, ""));
      this.lesUsers.clear();
      this.mesUsersItem.clear();
      this.mesUsersItem.add(new SelectItem(0, ""));
      this.controleSaisie();
      this.var_action = this.var_memo_action;
   }

   public void calculDeviseCategorie() throws HibernateException, NamingException {
      String var1 = "";
      String var2 = "";
      if (this.lesFamilleFournisseursListe.size() != 0) {
         for(int var3 = 0; var3 < this.lesFamilleFournisseursListe.size(); ++var3) {
            if (this.reacheminementEnteteAchats.getReaCat().equalsIgnoreCase(((ObjetFamilleTiers)this.lesFamilleFournisseursListe.get(var3)).getLibelle())) {
               var1 = ((ObjetFamilleTiers)this.lesFamilleFournisseursListe.get(var3)).getExoTva();
               var2 = ((ObjetFamilleTiers)this.lesFamilleFournisseursListe.get(var3)).getExoDouane();
               break;
            }
         }
      }

      if (var1.equalsIgnoreCase("true")) {
         this.reacheminementEnteteAchats.setReaExoTva(1);
      } else {
         this.reacheminementEnteteAchats.setReaExoTva(0);
      }

      if (var2.equalsIgnoreCase("true")) {
         this.reacheminementEnteteAchats.setReaExoDouane(1);
      } else {
         this.reacheminementEnteteAchats.setReaExoDouane(0);
      }

   }

   public void chargerLesContactsItem(Session var1) throws HibernateException, NamingException {
      this.mesContactItem = new ArrayList();
      this.mesContactItem = this.contactDao.chargerLesContactsItems(this.tiers.getTieid(), var1);
      if (this.mesContactItem.size() == 0) {
         this.mesContactItem.add(new SelectItem(0, ""));
      }

   }

   public void controleSaisie() throws ParseException {
      if (!this.reacheminementEnteteAchats.getReaNomTiers().equals("") && this.tiers.getTieid() != 0L) {
         this.var_valide_doc = true;
         this.var_aff_detail_tiers = true;
         if (this.reacheminementEnteteAchats.getReaCat() != null && !this.reacheminementEnteteAchats.getReaCat().isEmpty()) {
            if (this.reacheminementEnteteAchats.getReaCat().equalsIgnoreCase("Local")) {
               this.var_valide_doc = true;
               this.reacheminementEnteteAchats.setReaValorisation(0);
            } else {
               if (this.reacheminementEnteteAchats.getReaAnal4() != null && !this.reacheminementEnteteAchats.getReaAnal4().isEmpty()) {
                  this.var_valide_doc = true;
               } else {
                  this.var_valide_doc = false;
               }

               this.reacheminementEnteteAchats.setReaValorisation(1);
            }
         } else {
            this.var_valide_doc = false;
         }
      } else {
         this.var_valide_doc = false;
         this.var_aff_detail_tiers = false;
         this.reacheminementEnteteAchats.setReaValorisation(0);
      }

   }

   public void recupererEltCat() throws HibernateException, NamingException, ParseException {
      this.calculDeviseCategorie();
      if (this.lesLignesList.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReacheminementEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.reacheminementLigneAchats = new ReacheminementLigneAchats();
               this.reacheminementLigneAchats = (ReacheminementLigneAchats)this.lesLignesList.get(var3);
               this.reacheminementLigneAchats = this.reacheminementLigneAchatsDao.modifLigne(this.reacheminementLigneAchats, var1);
            }

            if (this.reacheminementEnteteAchats.getReaId() != 0L) {
               this.reacheminementEnteteAchats = this.reacheminementEnteteAchatsDao.modif(this.reacheminementEnteteAchats, var1);
               var2.commit();
            }
         } catch (HibernateException var7) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var7;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.chargerDocumentLigne((Session)null);
         this.cumulPrix();
      }

      this.controleSaisie();
   }

   public void detailTiers() {
      this.formRecherche.setNature(this.nature);
      this.var_action = 12;
   }

   public void annuleDetailTiers() {
      this.var_action = this.var_memo_action;
   }

   public void modifTiers() {
      this.var_aff_detail_tiers = false;
   }

   public void ajouterContact() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.tiers != null && this.tiers.getTieid() != 0L) {
         this.formRecherche.rechercheContacts(this.tiers, this.nature);
         this.var_action = 16;
      }

   }

   public void annulerContact() {
      this.var_action = this.var_memo_action;
   }

   public void recuperationContact() throws JDOMException, IOException {
      this.mesContactItem = this.formRecherche.calculeContactItems();
      if (this.mesContactItem == null || this.mesContactItem.size() == 0) {
         this.mesContactItem.clear();
         this.mesContactItem.add(new SelectItem(0, ""));
      }

      this.var_action = this.var_memo_action;
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
      } else {
         this.inpResponsable = "";
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleResponsable() {
      this.inpResponsable = "";
      this.var_action = this.var_memo_action;
   }

   public void serieSelectTrf() throws HibernateException, NamingException, ParseException {
      this.modeleSelectTrf();
      this.utilInitHibernate.closeSession();
   }

   public void modeleSelectTrf() throws ParseException {
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

   public void accesImputSerie() {
      this.var_imput_serie = this.reacheminementEnteteAchats.getReaSerie();
      this.var_imput_cat = this.reacheminementEnteteAchats.getReaCat();
      this.showModalPanelImput = true;
   }

   public void miseajourImput() throws IOException, JDOMException, HibernateException, NamingException, ParseException {
      if (!this.var_imput_serie.equalsIgnoreCase("X")) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReacheminementEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.reacheminementEnteteAchats.getReaNum();
            this.reacheminementEnteteAchats.setReaSerie(this.var_imput_serie);
            this.reacheminementEnteteAchats.setReaCat(this.var_imput_cat);
            this.reacheminementEnteteAchats.setReaNum(this.calculChrono.numCompose(this.reacheminementEnteteAchats.getReaDate(), this.nature, this.reacheminementEnteteAchats.getReaSerie(), var1));
            this.reacheminementEnteteAchatsDao.modif(this.reacheminementEnteteAchats, var1);
            new ArrayList();
            if (this.parapheurDao == null) {
               this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
            }

            ArrayList var4 = (ArrayList)this.parapheurDao.parapheurDocument(this.reacheminementEnteteAchats.getReaId(), this.nature, var1);
            if (var4 != null) {
               for(int var5 = 0; var5 < var4.size(); ++var5) {
                  new Parapheur();
                  Parapheur var6 = (Parapheur)var4.get(var5);
                  var6.setPhrNum(this.reacheminementEnteteAchats.getReaNum());
                  this.parapheurDao.modif(var6, var1);
               }
            }

            Espion var12 = new Espion();
            var12.setUsers(this.usersLog);
            var12.setEsptype(0);
            var12.setEspdtecreat(new Date());
            var12.setEspaction("Imputation Réacheminement achat X N° " + var3 + " en Réacheminement achat " + this.reacheminementEnteteAchats.getReaSerie() + " N° " + this.reacheminementEnteteAchats.getReaNum());
            this.espionDao.mAJEspion(var12, var1);
            var2.commit();
         } catch (HibernateException var10) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var10;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.annuleImputSerie();
      this.annule();
      this.chargeListeDetail((Session)null);
   }

   public void annuleImputSerie() {
   }

   public void annuleTrf() {
   }

   public void qteTrfQteOrg() throws HibernateException, NamingException {
      this.qteTrfQteOrg((Session)null);
   }

   public void qteTrfQteOrg(Session var1) throws HibernateException, NamingException {
   }

   public void razQteTrf() throws ParseException {
   }

   public void transformerMaj() throws HibernateException, NamingException, Exception {
   }

   public void trfRet() throws HibernateException, NamingException, Exception {
   }

   public JRBeanCollectionDataSource calculeImpressionTRFRET(List var1, RetourEnteteAchats var2) throws IOException {
      ArrayList var3 = new ArrayList();
      if (var1.size() != 0) {
         new RetourLigneAchats();
         boolean var5 = false;
         String var6 = "";
         double var7 = 0.0D;
         double var9 = 0.0D;

         for(int var11 = 0; var11 < var1.size(); ++var11) {
            RetourLigneAchats var4 = (RetourLigneAchats)var1.get(var11);
            if (var4.getBrfligCode() != null && !var4.getBrfligCode().isEmpty() && var4.getBrfligCode().equals("-")) {
               var5 = true;
               var6 = var4.getBrfligLibelle();
            }

            if (var5) {
               var7 += var4.getBrfligPt();
               var9 = var4.getBrfligTtc();
            }

            if (var4.getBrfligCode() != null && !var4.getBrfligCode().isEmpty() && var4.getBrfligCode().equals("=") && var5) {
               var4 = new RetourLigneAchats();
               var4.setRetourEnteteAchats(var2);
               var4.setBrfligCode("=");
               var4.setBrfligLibelle(var6);
               var4.setBrfligPt(var7);
               var4.setBrfligTtc(var9);
               var3.add(var4);
               var7 = 0.0D;
               var9 = 0.0D;
               var5 = false;
            } else {
               var3.add(var4);
            }
         }
      }

      JRBeanCollectionDataSource var12 = new JRBeanCollectionDataSource(var3);
      return var12;
   }

   public Habilitation verifieExistenceHabilitationRetour(RetourEnteteAchats var1, Session var2) throws HibernateException, NamingException {
      HabilitationDao var3 = new HabilitationDao(this.baseLog, this.utilInitHibernate);
      Habilitation var4 = var3.existenceHabilitation(0, var2);
      if (var4 != null) {
         var1.setBrfEtatVal(1);
         var1.setBrfEtat(0);
         var1.setBrfDateValide((Date)null);
      } else {
         var1.setBrfEtatVal(0);
         if (var1.getBrfDateImp() != null) {
            if (var1.getBrfEtat() == 0) {
               var1.setBrfEtat(1);
               var1.setBrfDateValide(new Date());
            }
         } else {
            var1.setBrfEtat(0);
            var1.setBrfDateValide((Date)null);
         }
      }

      return var4;
   }

   public String conversionAnnexe1() throws HibernateException, NamingException {
      String var1 = null;
      if (this.reacheminementEnteteAchats.getReaAnnexe1() != null && !this.reacheminementEnteteAchats.getReaAnnexe1().isEmpty() && this.reacheminementEnteteAchats.getReaAnnexe1().contains(":")) {
         String[] var2 = this.reacheminementEnteteAchats.getReaAnnexe1().split(":");
         new ModelesCourriers();
         ModelesCourriersDao var4 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
         ModelesCourriers var3 = var4.rechercheModeles(var2[0], (Session)null);
         if (var3 != null) {
            if (var3.getModTexte().contains("[")) {
               var1 = this.utilTdt.analyseTexteCommercial(var3.getModTexte(), this.reacheminementEnteteAchats.getUsers(), this.structureLog, this.reacheminementEnteteAchats.getTiers());
            } else {
               var1 = var3.getModTexte();
            }

            if (this.usersLog.getUsrSignature() != null && !this.usersLog.getUsrSignature().isEmpty()) {
               String var5 = "http://" + this.getUrlIpProd() + "/epegase/imageServlet/" + this.baseLog + "/photos/Users/" + this.usersLog.getUsrSignature();
               var1 = var1 + "<p>&nbsp;</p><p>&nbsp;</p><p><img style=" + "display: block; margin-left: auto; margin-right: auto;" + " title=" + "signature" + " src=" + var5 + " alt=" + "signature /></p>";
            }
         }
      }

      return var1;
   }

   public String conversionAnnexe2() throws HibernateException, NamingException {
      String var1 = null;
      if (this.reacheminementEnteteAchats.getReaAnnexe2() != null && !this.reacheminementEnteteAchats.getReaAnnexe2().isEmpty() && this.reacheminementEnteteAchats.getReaAnnexe2().contains(":")) {
         String[] var2 = this.reacheminementEnteteAchats.getReaAnnexe2().split(":");
         new ModelesCourriers();
         ModelesCourriersDao var4 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
         ModelesCourriers var3 = var4.rechercheModeles(var2[0], (Session)null);
         if (var3 != null) {
            if (var3.getModTexte().contains("[")) {
               var1 = this.utilTdt.analyseTexteCommercial(var3.getModTexte(), this.reacheminementEnteteAchats.getUsers(), this.structureLog, this.reacheminementEnteteAchats.getTiers());
            } else {
               var1 = var3.getModTexte();
            }

            if (this.usersLog.getUsrSignature() != null && !this.usersLog.getUsrSignature().isEmpty()) {
               String var5 = "http://" + this.getUrlIpProd() + "/epegase/imageServlet/" + this.baseLog + "/photos/Users/" + this.usersLog.getUsrSignature();
               var1 = var1 + "<p>&nbsp;</p><p>&nbsp;</p><p><img style=" + "display: block; margin-left: auto; margin-right: auto;" + " title=" + "signature" + " src=" + var5 + " alt=" + "signature /></p>";
            }
         }
      }

      return var1;
   }

   public String calculeCheminRapport(String var1, int var2) {
      String var3 = "";
      if (var2 == 10) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "da" + File.separator;
      } else if (var2 == 11) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "cotation" + File.separator;
      } else if (var2 == 12) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "commande" + File.separator;
      } else if (var2 == 13) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "reception" + File.separator;
      } else if (var2 == 14) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "retour" + File.separator;
      } else if (var2 == 15) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "facture" + File.separator;
      } else if (var2 == 16) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "avoir" + File.separator;
      } else if (var2 == 17) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "note_de_debit" + File.separator;
      } else if (var2 == 18) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "frais" + File.separator;
      } else if (var2 == 19) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "bon_decaissement" + File.separator;
      } else if (var2 == 35) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "valorisation" + File.separator;
      } else if (var2 == 30) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "document" + File.separator + "inventaire" + File.separator;
      } else if (var2 == 31) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "document" + File.separator + "bon_entree" + File.separator;
      } else if (var2 == 32) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "document" + File.separator + "bon_sortie" + File.separator;
      } else if (var2 == 33) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "document" + File.separator + "cession" + File.separator;
      } else if (var2 == 34) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "document" + File.separator + "production" + File.separator;
      } else if (var2 == 35) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "valorisation" + File.separator;
      } else if (var2 == 36) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "sommier" + File.separator;
      } else if (var2 == 150) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "reacheminement" + File.separator;
      }

      return var3;
   }

   public String calculeCheminSousRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "sous_rapport" + File.separator;
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
            var4 = new File(this.calculeCheminSousRapport(var1) + "formatReception.jpg");
            if (var4.exists()) {
               var3 = "formatReception.jpg";
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
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatReception.jpg");
         if (var4.exists()) {
            var3 = "formatReception.jpg";
         }
      }

      return var3;
   }

   public JRBeanCollectionDataSource calculeImpressionCommun(Session var1) throws IOException, HibernateException, NamingException {
      ArrayList var2 = new ArrayList();
      if (this.lesLignesList.size() != 0) {
         if (var1 == null) {
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReacheminementEntete");
            Transaction var3 = null;

            try {
               var3 = var1.beginTransaction();

               for(int var4 = 0; var4 < this.lesLignesList.size(); ++var4) {
                  this.reacheminementLigneAchats = (ReacheminementLigneAchats)this.lesLignesList.get(var4);
                  if (this.reacheminementLigneAchats.getRealigCode() != null && !this.reacheminementLigneAchats.getRealigCode().isEmpty()) {
                     this.produits = this.produitsDao.chargeProduit(this.reacheminementLigneAchats.getRealigCode(), var1);
                     if (this.produits != null) {
                        new ProduitsFournisseur();
                        ProduitsFournisseurDao var6 = new ProduitsFournisseurDao(this.baseLog, this.utilInitHibernate);
                        ProduitsFournisseur var5 = var6.selectProdFourByprodFic(this.produits, this.tiers, var1);
                        if (var5 != null) {
                           this.reacheminementLigneAchats = this.reacheminementLigneAchatsDao.modifLigne(this.reacheminementLigneAchats, var1);
                        }
                     }
                  }

                  var2.add(this.reacheminementLigneAchats);
               }

               var3.commit();
            } catch (HibernateException var10) {
               if (var3 != null) {
                  var3.rollback();
               }

               throw var10;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         } else {
            for(int var12 = 0; var12 < this.lesLignesList.size(); ++var12) {
               this.reacheminementLigneAchats = (ReacheminementLigneAchats)this.lesLignesList.get(var12);
               if (this.reacheminementLigneAchats.getRealigCode() != null && !this.reacheminementLigneAchats.getRealigCode().isEmpty()) {
                  this.produits = this.produitsDao.chargeProduit(this.reacheminementLigneAchats.getRealigCode(), var1);
                  if (this.produits != null) {
                     new ProduitsFournisseur();
                     ProduitsFournisseurDao var15 = new ProduitsFournisseurDao(this.baseLog, this.utilInitHibernate);
                     ProduitsFournisseur var14 = var15.selectProdFourByprodFic(this.produits, this.tiers, var1);
                     if (var14 != null) {
                        this.reacheminementLigneAchats = this.reacheminementLigneAchatsDao.modifLigne(this.reacheminementLigneAchats, var1);
                     }
                  }
               }

               var2.add(this.reacheminementLigneAchats);
            }
         }
      }

      JRBeanCollectionDataSource var13 = new JRBeanCollectionDataSource(var2);
      return var13;
   }

   public boolean majDateImpression(String var1) throws HibernateException, NamingException, ParseException {
      boolean var2 = false;
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReacheminementEntete");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         boolean var5 = false;
         long var6 = this.reacheminementEnteteAchats.getTiers().getTieid();
         if (this.reacheminementEnteteAchats.getReaDateImp() != null) {
            var2 = true;
         }

         this.reacheminementEnteteAchats.setReaDateImp(new Date());
         if (this.reacheminementEnteteAchats.getReaEtat() == 0 && this.reacheminementEnteteAchats.getReaEtatVal() == 0 && this.usersChrono.getUsrchrValidation() == 1) {
            this.reacheminementEnteteAchats.setReaEtat(1);
            var5 = true;
         }

         this.reacheminementEnteteAchats.setReaModeleImp(var1);
         this.reacheminementEnteteAchats = this.reacheminementEnteteAchatsDao.modif(this.reacheminementEnteteAchats, var3);
         if (var5) {
            if (this.reacheminementEnteteAchats.getReaAnal4() != null && !this.reacheminementEnteteAchats.getReaAnal4().isEmpty()) {
               new ValorisationEnteteAchats();
               ValorisationEnteteAchatsDao var9 = new ValorisationEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
               ValorisationEnteteAchats var8 = var9.rechercheByDossier(this.reacheminementEnteteAchats.getReaAnal4(), var3);
               if (var8 != null) {
                  this.reacheminementEnteteAchats.setReaValo(var8.getValNum());
                  this.reacheminementEnteteAchats = this.reacheminementEnteteAchatsDao.modif(this.reacheminementEnteteAchats, var3);
               }
            }

            if ((this.reacheminementEnteteAchats.getReaValorisation() != 0 || this.reacheminementEnteteAchats.getReaCoefValo() == 0.0F) && this.reacheminementEnteteAchats.getReaValorisation() != 1 && this.reacheminementEnteteAchats.getReaValorisation() == 2) {
            }

            this.calculStock.majReacheminementAchatsVAL(this.lesLignesList, 1, this.baseLog, var3);
            if (this.tiers.getTieDteDocument3() == null || this.reacheminementEnteteAchats.getReaDate().after(this.tiers.getTieDteDocument3())) {
               this.tiers = this.tiersDao.selectTierD(var6, var3);
               if (this.tiers != null) {
                  this.tiers.setTieDteDocument3(this.reacheminementEnteteAchats.getReaDate());
                  this.tiers = this.tiersDao.modif(this.tiers, var3);
               }
            }
         }

         this.contacts = new Contacts();
         if (this.reacheminementEnteteAchats.getReaIdContact() != 0L) {
            this.contacts = this.contactDao.chargerLesContactsById(this.reacheminementEnteteAchats.getReaIdContact(), var3);
         }

         var4.commit();
      } catch (HibernateException var13) {
         if (var4 != null) {
            var4.rollback();
         }

         throw var13;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var2;
   }

   public void impression(UtilPrint var1, int var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9) throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      if (var2 == 0) {
         if (var3 != null && !var3.isEmpty()) {
            boolean var10 = this.majDateImpression(var3);
            var1.setjRBeanCollectionDataSource(this.calculeImpressionCommun((Session)null));
            var1.setRapport(var3);
            var1.setEntete("Impression réacheminement");
            var1.setMontant_lettre("");
            var1.setAnnexe1(this.conversionAnnexe1());
            var1.setAnnexe2(this.conversionAnnexe2());
            var1.setCheminRapport(this.calculeCheminRapport(this.baseLog, this.nature));
            var1.setCheminSousrapport(this.calculeCheminSousRapport(this.baseLog));
            var1.setImageFondPage(this.calculeImageFond(this.baseLog, this.reacheminementEnteteAchats.getReaEtat()));
            var1.setDuplicata("" + var10);
            var1.setNbDecQte(this.optionAchats.getNbDecQte());
            var1.setFormat(var5);
            var1.setEmetteur(var6);
            var1.setDestinataire(var7);
            var1.setDestinataireCC(var8);
            var1.setDestinataireCCI(var9);
            var1.setIdResponsable(this.reacheminementEnteteAchats.getReaIdResponsable());
            var1.setTiersSelectionne(this.reacheminementEnteteAchats.getTiers());
            if (this.contacts == null) {
               this.contacts = new Contacts();
            }

            var1.setContact(this.contacts);
            var1.setNumDoc(this.reacheminementEnteteAchats.getReaNum());
            var1.setNature(this.nature);
            var1.setId_doc(this.reacheminementEnteteAchats.getReaId());
            var1.setParc((Parc)null);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      } else if (var4 != null && !var4.isEmpty()) {
         var1.setRapport(var4);
         var1.setEntete("Impression de la liste des réacheminements");
         var1.setTotauxHt("");
         var1.setTotauxTaxe("");
         var1.setTotauxTtc("");
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "liste" + File.separator + "reception" + File.separator);
         var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "sous_rapport" + File.separator);
         var1.setFormat(var5);
         var1.setEmetteur(var6);
         var1.setDestinataire(var7);
         var1.setDestinataireCC(var8);
         var1.setDestinataireCCI(var9);
         var1.setIdResponsable(0L);
         var1.setTiersSelectionne((Tiers)null);
         var1.setNature(this.nature);
         var1.setId_doc(0L);
         JRBeanCollectionDataSource var11 = new JRBeanCollectionDataSource(this.lesEntetesList);
         var1.setjRBeanCollectionDataSource(var11);
         var1.setBaseLog(this.baseLog);
         var1.setStructureLog(this.structureLog);
         var1.setUsersLog(this.usersLog);
         var1.imprimeRapport();
      }

   }

   public String getUrlIpProd() {
      return StaticModePegase.getUrlIp();
   }

   public boolean isAccesProduits() {
      return this.accesProduits;
   }

   public void setAccesProduits(boolean var1) {
      this.accesProduits = var1;
   }

   public boolean isAffichagePump() {
      return this.affichagePump;
   }

   public void setAffichagePump(boolean var1) {
      this.affichagePump = var1;
   }

   public boolean isVar_valide_doc() {
      return this.var_valide_doc;
   }

   public void setVar_valide_doc(boolean var1) {
      this.var_valide_doc = var1;
   }

   public DataModel getDatamodelDocumentTrace() {
      return this.datamodelDocumentTrace;
   }

   public void setDatamodelDocumentTrace(DataModel var1) {
      this.datamodelDocumentTrace = var1;
   }

   public ReacheminementEnteteAchats getReacheminementEnteteAchats() {
      return this.reacheminementEnteteAchats;
   }

   public void setReacheminementEnteteAchats(ReacheminementEnteteAchats var1) {
      this.reacheminementEnteteAchats = var1;
   }

   public ReacheminementLigneAchats getReacheminementLigneAchats() {
      return this.reacheminementLigneAchats;
   }

   public void setReacheminementLigneAchats(ReacheminementLigneAchats var1) {
      this.reacheminementLigneAchats = var1;
   }

   public boolean isGriserchamps() {
      return this.griserchamps;
   }

   public void setGriserchamps(boolean var1) {
      this.griserchamps = var1;
   }

   public Date getInpAu() {
      return this.inpAu;
   }

   public void setInpAu(Date var1) {
      this.inpAu = var1;
   }

   public String getInpCat() {
      return this.inpCat;
   }

   public void setInpCat(String var1) {
      this.inpCat = var1;
   }

   public String getInpFournisseur() {
      return this.inpFournisseur;
   }

   public void setInpFournisseur(String var1) {
      this.inpFournisseur = var1;
   }

   public Date getInpDu() {
      return this.inpDu;
   }

   public void setInpDu(Date var1) {
      this.inpDu = var1;
   }

   public int getInpEtat() {
      return this.inpEtat;
   }

   public void setInpEtat(int var1) {
      this.inpEtat = var1;
   }

   public String getInpNum() {
      return this.inpNum;
   }

   public void setInpNum(String var1) {
      this.inpNum = var1;
   }

   public String getInpResponsable() {
      return this.inpResponsable;
   }

   public void setInpResponsable(String var1) {
      this.inpResponsable = var1;
   }

   public String getInpSerie() {
      return this.inpSerie;
   }

   public void setInpSerie(String var1) {
      this.inpSerie = var1;
   }

   public List getMesContactItem() {
      return this.mesContactItem;
   }

   public void setMesContactItem(List var1) {
      this.mesContactItem = var1;
   }

   public List getMesUsersItem() {
      return this.mesUsersItem;
   }

   public void setMesUsersItem(List var1) {
      this.mesUsersItem = var1;
   }

   public OptionAchats getOptionAchats() {
      return this.optionAchats;
   }

   public void setOptionAchats(OptionAchats var1) {
      this.optionAchats = var1;
   }

   public String getPeriode() {
      return this.periode;
   }

   public void setPeriode(String var1) {
      this.periode = var1;
   }

   public Produits getProduits() {
      return this.produits;
   }

   public void setProduits(Produits var1) {
      this.produits = var1;
   }

   public boolean isShowModalPanelImput() {
      return this.showModalPanelImput;
   }

   public void setShowModalPanelImput(boolean var1) {
      this.showModalPanelImput = var1;
   }

   public Tiers getTiers() {
      return this.tiers;
   }

   public void setTiers(Tiers var1) {
      this.tiers = var1;
   }

   public String getUrlphotoProd() {
      return this.urlphotoProd;
   }

   public void setUrlphotoProd(String var1) {
      this.urlphotoProd = var1;
   }

   public boolean isVar_acc_complement() {
      return this.var_acc_complement;
   }

   public void setVar_acc_complement(boolean var1) {
      this.var_acc_complement = var1;
   }

   public boolean isVar_acc_etat() {
      return this.var_acc_etat;
   }

   public void setVar_acc_etat(boolean var1) {
      this.var_acc_etat = var1;
   }

   public boolean isVar_acc_prp() {
      return this.var_acc_prp;
   }

   public void setVar_acc_prp(boolean var1) {
      this.var_acc_prp = var1;
   }

   public boolean isVar_acc_special() {
      return this.var_acc_special;
   }

   public void setVar_acc_special(boolean var1) {
      this.var_acc_special = var1;
   }

   public boolean isVar_acc_habilitation() {
      return this.var_acc_habilitation;
   }

   public void setVar_acc_habilitation(boolean var1) {
      this.var_acc_habilitation = var1;
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

   public int getVar_action() {
      return this.var_action;
   }

   public void setVar_action(int var1) {
      this.var_action = var1;
   }

   public boolean isVar_aff_action() {
      return this.var_aff_action;
   }

   public void setVar_aff_action(boolean var1) {
      this.var_aff_action = var1;
   }

   public boolean isVar_aff_detail_prod() {
      return this.var_aff_detail_prod;
   }

   public void setVar_aff_detail_prod(boolean var1) {
      this.var_aff_detail_prod = var1;
   }

   public boolean isVar_aff_detail_tiers() {
      return this.var_aff_detail_tiers;
   }

   public void setVar_aff_detail_tiers(boolean var1) {
      this.var_aff_detail_tiers = var1;
   }

   public boolean isVar_ajt() {
      return this.var_ajt;
   }

   public void setVar_ajt(boolean var1) {
      this.var_ajt = var1;
   }

   public String getVar_depotProd() {
      return this.var_depotProd;
   }

   public void setVar_depotProd(String var1) {
      this.var_depotProd = var1;
   }

   public boolean isVar_imp() {
      return this.var_imp;
   }

   public void setVar_imp(boolean var1) {
      this.var_imp = var1;
   }

   public String getVar_imput_cat() {
      return this.var_imput_cat;
   }

   public void setVar_imput_cat(String var1) {
      this.var_imput_cat = var1;
   }

   public String getVar_imput_serie() {
      return this.var_imput_serie;
   }

   public void setVar_imput_serie(String var1) {
      this.var_imput_serie = var1;
   }

   public boolean isVar_mod() {
      return this.var_mod;
   }

   public void setVar_mod(boolean var1) {
      this.var_mod = var1;
   }

   public boolean isVar_more_search() {
      return this.var_more_search;
   }

   public void setVar_more_search(boolean var1) {
      this.var_more_search = var1;
   }

   public int getVar_nb_ligne() {
      return this.var_nb_ligne;
   }

   public void setVar_nb_ligne(int var1) {
      this.var_nb_ligne = var1;
   }

   public boolean isVar_sansstock() {
      return this.var_sansstock;
   }

   public void setVar_sansstock(boolean var1) {
      this.var_sansstock = var1;
   }

   public boolean isVar_sup() {
      return this.var_sup;
   }

   public void setVar_sup(boolean var1) {
      this.var_sup = var1;
   }

   public boolean isVar_typeTiers() {
      return this.var_typeTiers;
   }

   public void setVar_typeTiers(boolean var1) {
      this.var_typeTiers = var1;
   }

   public boolean isVar_verrou_comm() {
      return this.var_verrou_comm;
   }

   public void setVar_verrou_comm(boolean var1) {
      this.var_verrou_comm = var1;
   }

   public String getVerrouDepotUser() {
      return this.verrouDepotUser;
   }

   public void setVerrouDepotUser(String var1) {
      this.verrouDepotUser = var1;
   }

   public boolean isVerrouNum() {
      return this.verrouNum;
   }

   public void setVerrouNum(boolean var1) {
      this.verrouNum = var1;
   }

   public boolean isVerrouPrvente() {
      return this.verrouPrvente;
   }

   public void setVerrouPrvente(boolean var1) {
      this.verrouPrvente = var1;
   }

   public boolean isVerrouRabais() {
      return this.verrouRabais;
   }

   public void setVerrouRabais(boolean var1) {
      this.verrouRabais = var1;
   }

   public boolean isVerrouRemise() {
      return this.verrouRemise;
   }

   public void setVerrouRemise(boolean var1) {
      this.verrouRemise = var1;
   }

   public boolean isVisibiliteBton() {
      return this.visibiliteBton;
   }

   public void setVisibiliteBton(boolean var1) {
      this.visibiliteBton = var1;
   }

   public boolean isVisibiliteencaissemt() {
      return this.visibiliteencaissemt;
   }

   public void setVisibiliteencaissemt(boolean var1) {
      this.visibiliteencaissemt = var1;
   }

   public boolean isVisibilitefactor() {
      return this.visibilitefactor;
   }

   public void setVisibilitefactor(boolean var1) {
      this.visibilitefactor = var1;
   }

   public boolean isVisibilitenbrjr() {
      return this.visibilitenbrjr;
   }

   public void setVisibilitenbrjr(boolean var1) {
      this.visibilitenbrjr = var1;
   }

   public boolean isVisibiliteterme() {
      return this.visibiliteterme;
   }

   public void setVisibiliteterme(boolean var1) {
      this.visibiliteterme = var1;
   }

   public boolean isVisibleOnglet() {
      return this.visibleOnglet;
   }

   public void setVisibleOnglet(boolean var1) {
      this.visibleOnglet = var1;
   }

   public String getInpDossier() {
      return this.inpDossier;
   }

   public void setInpDossier(String var1) {
      this.inpDossier = var1;
   }

   public boolean isVisibiliteBtonlig() {
      return this.visibiliteBtonlig;
   }

   public void setVisibiliteBtonlig(boolean var1) {
      this.visibiliteBtonlig = var1;
   }

   public boolean isVisibleOngleEntete() {
      return this.visibleOngleEntete;
   }

   public void setVisibleOngleEntete(boolean var1) {
      this.visibleOngleEntete = var1;
   }

   public DataModel getDatamodelEntete() {
      return this.datamodelEntete;
   }

   public void setDatamodelEntete(DataModel var1) {
      this.datamodelEntete = var1;
   }

   public DataModel getDatamodelLigne() {
      return this.datamodelLigne;
   }

   public void setDatamodelLigne(DataModel var1) {
      this.datamodelLigne = var1;
   }

   public boolean isVar_acc_document() {
      return this.var_acc_document;
   }

   public void setVar_acc_document(boolean var1) {
      this.var_acc_document = var1;
   }

   public boolean isVar_acc_imputation() {
      return this.var_acc_imputation;
   }

   public void setVar_acc_imputation(boolean var1) {
      this.var_acc_imputation = var1;
   }

   public ExercicesAchats getExercicesAchats() {
      return this.exercicesAchats;
   }

   public void setExercicesAchats(ExercicesAchats var1) {
      this.exercicesAchats = var1;
   }

   public Habilitation getHabilitation() {
      return this.habilitation;
   }

   public void setHabilitation(Habilitation var1) {
      this.habilitation = var1;
   }

   public ExercicesAchats getLastExoAchats() {
      return this.lastExoAchats;
   }

   public void setLastExoAchats(ExercicesAchats var1) {
      this.lastExoAchats = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
   }

   public List getMesOnglets() {
      return this.mesOnglets;
   }

   public void setMesOnglets(List var1) {
      this.mesOnglets = var1;
   }

   public ExercicesComptable getLastExoCompta() {
      return this.lastExoCompta;
   }

   public void setLastExoCompta(ExercicesComptable var1) {
      this.lastExoCompta = var1;
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

   public Date getVar_date() {
      return this.var_date;
   }

   public void setVar_date(Date var1) {
      this.var_date = var1;
   }

   public UsersChrono getUsersChrono() {
      return this.usersChrono;
   }

   public void setUsersChrono(UsersChrono var1) {
      this.usersChrono = var1;
   }

   public List getLesFamilleFournisseursListe() {
      return this.lesFamilleFournisseursListe;
   }

   public void setLesFamilleFournisseursListe(List var1) {
      this.lesFamilleFournisseursListe = var1;
   }

   public int getVar_option_parc() {
      return this.var_option_parc;
   }

   public void setVar_option_parc(int var1) {
      this.var_option_parc = var1;
   }

   public long getVar_nom_contact() {
      return this.var_nom_contact;
   }

   public void setVar_nom_contact(long var1) {
      this.var_nom_contact = var1;
   }

   public long getVar_nom_responsable() {
      return this.var_nom_responsable;
   }

   public void setVar_nom_responsable(long var1) {
      this.var_nom_responsable = var1;
   }

   public boolean isVerrou_libelle() {
      return this.verrou_libelle;
   }

   public void setVerrou_libelle(boolean var1) {
      this.verrou_libelle = var1;
   }

   public boolean isVerrouPump() {
      return this.verrouPump;
   }

   public void setVerrouPump(boolean var1) {
      this.verrouPump = var1;
   }

   public int getVar_nb_max() {
      return this.var_nb_max;
   }

   public void setVar_nb_max(int var1) {
      this.var_nb_max = var1;
   }

   public int getVar_timbre() {
      return this.var_timbre;
   }

   public void setVar_timbre(int var1) {
      this.var_timbre = var1;
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

   public UtilParapheur getUtilParapheur() {
      return this.utilParapheur;
   }

   public void setUtilParapheur(UtilParapheur var1) {
      this.utilParapheur = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
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

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public boolean isShowModalPanelAnnuler() {
      return this.showModalPanelAnnuler;
   }

   public void setShowModalPanelAnnuler(boolean var1) {
      this.showModalPanelAnnuler = var1;
   }

   public String getInformationsTiers() {
      return this.informationsTiers;
   }

   public void setInformationsTiers(String var1) {
      this.informationsTiers = var1;
   }

   public int getModeReception() {
      return this.modeReception;
   }

   public void setModeReception(int var1) {
      this.modeReception = var1;
   }

   public String getLibelleModeReception() {
      return this.libelleModeReception;
   }

   public void setLibelleModeReception(String var1) {
      this.libelleModeReception = var1;
   }

   public long getInpIdTiersEnCours() {
      return this.inpIdTiersEnCours;
   }

   public void setInpIdTiersEnCours(long var1) {
      this.inpIdTiersEnCours = var1;
   }

   public String getInpNomTiersEnCours() {
      return this.inpNomTiersEnCours;
   }

   public void setInpNomTiersEnCours(String var1) {
      this.inpNomTiersEnCours = var1;
   }

   public Parapheur getParapheur() {
      return this.parapheur;
   }

   public void setParapheur(Parapheur var1) {
      this.parapheur = var1;
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

   public double getTotauxBrut() {
      return this.totauxBrut;
   }

   public void setTotauxBrut(double var1) {
      this.totauxBrut = var1;
   }

   public double getTotauxNet() {
      return this.totauxNet;
   }

   public void setTotauxNet(double var1) {
      this.totauxNet = var1;
   }

   public String getUrlExplorateur() {
      return this.urlExplorateur;
   }

   public void setUrlExplorateur(String var1) {
      this.urlExplorateur = var1;
   }

   public int getTotauxCamion() {
      return this.totauxCamion;
   }

   public void setTotauxCamion(int var1) {
      this.totauxCamion = var1;
   }

   public int getTotauxSac() {
      return this.totauxSac;
   }

   public void setTotauxSac(int var1) {
      this.totauxSac = var1;
   }

   public DataModel getDataModelReceptions() {
      return this.dataModelReceptions;
   }

   public void setDataModelReceptions(DataModel var1) {
      this.dataModelReceptions = var1;
   }

   public Date getReceptionAu() {
      return this.receptionAu;
   }

   public void setReceptionAu(Date var1) {
      this.receptionAu = var1;
   }

   public Date getReceptionDu() {
      return this.receptionDu;
   }

   public void setReceptionDu(Date var1) {
      this.receptionDu = var1;
   }

   public boolean isShowModalPanelReception() {
      return this.showModalPanelReception;
   }

   public void setShowModalPanelReception(boolean var1) {
      this.showModalPanelReception = var1;
   }

   public List getMesReceptionsLignesItems() {
      return this.mesReceptionsLignesItems;
   }

   public void setMesReceptionsLignesItems(List var1) {
      this.mesReceptionsLignesItems = var1;
   }

   public boolean isAffiche_ligne() {
      return this.affiche_ligne;
   }

   public void setAffiche_ligne(boolean var1) {
      this.affiche_ligne = var1;
   }

   public String getInpAnnonce() {
      return this.inpAnnonce;
   }

   public void setInpAnnonce(String var1) {
      this.inpAnnonce = var1;
   }

   public double getTotauxBrutGlobal() {
      return this.totauxBrutGlobal;
   }

   public void setTotauxBrutGlobal(double var1) {
      this.totauxBrutGlobal = var1;
   }

   public double getTotauxNetGlobal() {
      return this.totauxNetGlobal;
   }

   public void setTotauxNetGlobal(double var1) {
      this.totauxNetGlobal = var1;
   }
}
