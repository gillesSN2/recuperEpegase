package com.epegase.forms.ventes;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.Contacts;
import com.epegase.systeme.classe.DocumentTraceVentes;
import com.epegase.systeme.classe.Equipes;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FamillesProduitsVentes;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.ModelesCourriers;
import com.epegase.systeme.classe.Parapheur;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsDepot;
import com.epegase.systeme.classe.Region;
import com.epegase.systeme.classe.Responsable;
import com.epegase.systeme.classe.Secteur;
import com.epegase.systeme.classe.SimulationEnteteVentes;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.TaxesVentes;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.dao.ContactDao;
import com.epegase.systeme.dao.DocumentTraceVentesDao;
import com.epegase.systeme.dao.EquipesDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.MarquesDao;
import com.epegase.systeme.dao.ModelesCourriersDao;
import com.epegase.systeme.dao.ParapheurDao;
import com.epegase.systeme.dao.ParcDao;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
import com.epegase.systeme.dao.PointDeVenteDao;
import com.epegase.systeme.dao.ProduitsDepotDao;
import com.epegase.systeme.dao.ProduitsVtesDao;
import com.epegase.systeme.dao.RegionDao;
import com.epegase.systeme.dao.ResponsableDao;
import com.epegase.systeme.dao.SecteurDao;
import com.epegase.systeme.dao.SimulationEnteteVentesDao;
import com.epegase.systeme.dao.TaxesVentesDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilParapheur;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.util.UtilTdt;
import com.epegase.systeme.xml.ObjetFamilleTiers;
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

public class FormSimulContratVentes implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private FormRecherche formRecherche;
   private int var_action = 0;
   private int var_memo_action = 0;
   private String pageIndex;
   private int nature;
   private List mesOnglets;
   private OptionVentes optionsVentes;
   private int var_option_parc;
   private ExercicesVentes exercicesVentes;
   private ExercicesVentes lastExoVentes;
   private EspionDao espionDao;
   private CalculChrono calculChrono;
   private int var_timbre;
   private int var_tc_type;
   private String var_tc_libelle;
   private float var_tc_taux;
   private boolean var_tc_calcul;
   private int var_nb_max = 100;
   private List mesSerieUserItem;
   private Date var_date;
   private String var_heure;
   private String var_minute;
   private String var_seconde;
   private boolean visibleOnglet = false;
   private String var_libcondest;
   private boolean contDest = false;
   private boolean var_sansstock = false;
   private boolean var_pr_pv = false;
   private boolean var_aff_detail_prod = false;
   private boolean var_aff_detail_tiers = false;
   private boolean var_typeTiers = true;
   private boolean gestionParapheur = false;
   private Tiers tiers;
   private String nomTier;
   private List lesFamilleClientsListe;
   private String informationsTiers;
   private PlansAnalytiques plansAnalytiques = new PlansAnalytiques();
   private Users responsable;
   private long var_nom_commercial;
   private List mesCommercialItem;
   private long var_nom_equipe;
   private Equipes equipes;
   private EquipesDao equipesDao;
   private List mesEquipeItem = new ArrayList();
   private List lesEquipes = new ArrayList();
   private UsersChrono usersChrono = new UsersChrono();
   private UsersChronoDao usersChronoDao;
   private UserDao usersDao;
   private List mesUsersItem = new ArrayList();
   private ContactDao contactDao;
   private List mesContactItem = new ArrayList();
   private SimulationEnteteVentes simulationEnteteVentes = new SimulationEnteteVentes();
   private SimulationEnteteVentesDao simulationEnteteVentesDao;
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
   private double montantTtc = 0.0D;
   private double montantTtcElmt = 0.0D;
   private int var_nb_ligne = 0;
   private UtilDate utilDate = new UtilDate();
   private String conditRegtier;
   private boolean showModalPanelImput = false;
   private String var_imput_serie;
   private String var_imput_cat;
   private transient DataModel datamodelDocumentTrace = new ListDataModel();
   private List mesParcsItems = new ArrayList();
   private long var_nom_responsable;
   private long var_nom_contact;
   private boolean griserchamps = false;
   private Produits produits;
   private ProduitsVtesDao produitsDao;
   private TaxesVentesDao taxesVentesDao;
   private FamillesProduitsVentesDao famillesProduitsVentesDao;
   private FamillesProduitsVentes famillesProduitsVentes;
   private double prixUnitaires;
   private List mesTaxesVentesItems;
   private List mesTaxesVentesProduits = new ArrayList();
   private List mesTypeContratItems;
   private List mesMarquesItems = new ArrayList();
   private List mesGammesItems = new ArrayList();
   private List mesProduitsItems = new ArrayList();
   private String var_famille_produit;
   private String var_code_produit;
   private String urlphotoProd;
   private List mesProduitsDepotsItems = new ArrayList();
   private String var_depotProd;
   private ProduitsDepot produitsDepot;
   private ProduitsDepotDao produitsDepotDao;
   private ModelesCourriers modelesCourriers;
   private ModelesCourriersDao modelesCourriersDao;
   private String inpNomTiersEnCours = "";
   private long inpIdTiersEnCours = 0L;
   private String inpNomDestinataire = "";
   private String inpSerie = "100";
   private String inpCat = "100";
   private long inpUser = 0L;
   private int inpEtat = 0;
   private String periode;
   private String inpNum = "";
   private String inpClient = "";
   private String inpDestinataire = "";
   private String inpActivite = "100";
   private String inpParc = "100";
   private String inpDossier = "100";
   private String inpRegion = "";
   private String inpSecteur = "";
   private String inpPdv = "";
   private Date inpDu = null;
   private Date inpAu = null;
   private boolean selectDestinataire = false;
   private boolean var_more_search = false;
   private List mesSecteursItems = new ArrayList();
   private List mesPdvItems = new ArrayList();
   private String montant_lettre;
   private UtilNombre utilNombre = new UtilNombre();
   private int var_format_devise;
   private float var_coef_devise;
   private boolean verrouRemRab = false;
   private boolean verrouPrvente = false;
   private boolean affichagePump = false;
   private String verrouDepotUser;
   private boolean accesProduits;
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
   private Habilitation habilitation;
   private DocumentTraceVentesDao documentTraceVentesDao;
   private UtilParapheur utilParapheur;
   private ParapheurDao parapheurDao;
   private Parapheur parapheur;
   private UtilTdt utilTdt = new UtilTdt();
   private UtilPrint utilPrint;
   private boolean affMail = false;
   private boolean affListeDoc = false;
   private String requete;
   private String filtre;
   private String format = "PDF";
   private int var_choix_modele = 0;
   private String nomModeleListe;
   private String nomModeleDocument;
   private String impEmetteur;
   private String impDestinataire;
   private boolean showModalPanelPrint = false;
   private boolean var_anal_activite = false;
   private boolean var_anal_dossier = false;
   private boolean var_anal_parc = false;
   private boolean accesAffaires = false;
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

   public void InstancesDaoUtilses() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.simulationEnteteVentesDao = new SimulationEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.contactDao = new ContactDao(this.baseLog, this.utilInitHibernate);
      this.usersDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.equipesDao = new EquipesDao(this.baseLog, this.utilInitHibernate);
      this.famillesProduitsVentesDao = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
      this.produitsDao = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
      this.taxesVentesDao = new TaxesVentesDao(this.baseLog, this.utilInitHibernate);
      this.produitsDepotDao = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
      this.modelesCourriersDao = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
      this.documentTraceVentesDao = new DocumentTraceVentesDao(this.baseLog, this.utilInitHibernate);
   }

   public void configVentes() {
      if (!this.structureLog.getStrtypeentreprise().contentEquals("1") && !this.structureLog.getStrtypeentreprise().contentEquals("3")) {
         this.var_sansstock = true;
      } else {
         this.var_sansstock = false;
      }

      if (this.optionsVentes.getDecrmtPrsChrStock().equalsIgnoreCase("1")) {
         this.contDest = false;
         this.var_libcondest = "Contact";
      } else if (this.optionsVentes.getDecrmtPrsChrStock().equalsIgnoreCase("2")) {
         this.contDest = true;
         this.var_libcondest = "Destinataire";
      }

      if (!this.optionsVentes.getLib1ENTETE().isEmpty() && !this.optionsVentes.getLib2ENTETE().isEmpty() && !this.optionsVentes.getLib3ENTETE().isEmpty() && !this.optionsVentes.getLib4ENTETE().isEmpty() && !this.optionsVentes.getLib5ENTETE().isEmpty() && !this.optionsVentes.getLib6ENTETE().isEmpty() && !this.optionsVentes.getLib7ENTETE().isEmpty() && !this.optionsVentes.getLib8ENTETE().isEmpty() && !this.optionsVentes.getLib9ENTETE().isEmpty() && !this.optionsVentes.getLib10ENTETE().isEmpty()) {
         this.visibleOngleEntete = false;
      } else {
         this.visibleOngleEntete = true;
      }

      if (this.optionsVentes.getNbLigneMax() != null && !this.optionsVentes.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionsVentes.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      if (this.optionsVentes.getFamilleProduitSIMUL() != null && !this.optionsVentes.getFamilleProduitSIMUL().isEmpty() && this.optionsVentes.getFamilleProduitSIMUL().contains(":")) {
         this.var_famille_produit = this.optionsVentes.getFamilleProduitSIMUL();
      } else {
         this.var_famille_produit = "";
      }

      if (this.optionsVentes.getAxeActivite().equals("true")) {
         this.var_anal_activite = true;
      } else {
         this.var_anal_activite = false;
      }

      if (this.optionsVentes.getAxeDossier().equals("1")) {
         this.var_anal_dossier = true;
         this.accesAffaires = false;
      } else if (this.optionsVentes.getAxeDossier().equals("2")) {
         this.accesAffaires = true;
         this.var_anal_dossier = false;
      } else {
         this.accesAffaires = false;
         this.var_anal_dossier = false;
      }

      if (this.optionsVentes.getAxeParc().equals("true")) {
         this.var_anal_parc = true;
      } else {
         this.var_anal_parc = false;
      }

      this.periode = this.optionsVentes.getAffichInGlobViewAVOIR();
      if (this.habilitation != null) {
         this.gestionParapheur = true;
      } else {
         this.gestionParapheur = false;
      }

      this.initPage();
      this.utilParapheur = new UtilParapheur(this.utilInitHibernate, this.structureLog, this.baseLog, this.usersLog);
   }

   public void accesResteintUser() {
      if (this.usersLog.getUsrVerRemise() == 0) {
         this.verrouRemRab = false;
      } else {
         this.verrouRemRab = true;
      }

      if (this.usersLog.getUsrVerPv() == 0) {
         this.verrouPrvente = false;
      } else {
         this.verrouPrvente = true;
      }

      if (this.usersLog.getUsrAffPump() == 0) {
         this.affichagePump = false;
      } else {
         this.affichagePump = true;
      }

      if (this.usersLog.getUsrProdService() == 0) {
         this.accesProduits = false;
      } else {
         this.accesProduits = true;
      }

      this.visibiliteBton = false;
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

   public void initPage() {
      this.selectDestinataire = false;
      this.var_action = 0;
      this.montantTtc = 0.0D;
      this.montantTtcElmt = 0.0D;
      this.inpSerie = "100";
      this.inpCat = "100";
      this.inpEtat = 0;
      this.var_code_produit = "";
      this.lesEntetesList.clear();
   }

   public void chargerLesUsers(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      if (this.optionsVentes.getResponsable().equals("0")) {
         Object var2 = new ArrayList();
         if (this.usersLog.getUsrCommVentes() == 0) {
            var2 = this.usersDao.chargerLesUsers(var1);
         } else if (this.usersLog.getUsrCommVentes() == 1) {
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
                     ((List)var2).add(var7);
                  }
               }
            } else {
               var2 = this.usersDao.chargerLesSignataires("Ventes", var1);
            }
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
            for(int var8 = 0; var8 < ((List)var2).size(); ++var8) {
               Users var9 = (Users)((List)var2).get(var8);
               if (var9.getUsrPatronyme() != null && !var9.getUsrPatronyme().isEmpty()) {
                  this.mesUsersItem.add(new SelectItem(var9.getUsrid(), var9.getUsrPatronyme()));
               }
            }

            if (this.mesUsersItem.size() == 0) {
               this.mesUsersItem.add(new SelectItem(this.usersLog.getUsrid(), this.usersLog.getUsrPatronyme()));
            }
         }
      }

   }

   public void chargerCommerciauxResponsable(Session var1) throws HibernateException, NamingException {
      this.lesEquipes.clear();
      this.lesEquipes = this.equipesDao.selectEquipes(var1);
      this.mesEquipeItem.clear();
      if (this.lesEquipes.size() != 0) {
         this.mesEquipeItem.add(new SelectItem(0, ""));

         for(int var2 = 0; var2 < this.lesEquipes.size(); ++var2) {
            this.mesEquipeItem.add(new SelectItem(((Equipes)this.lesEquipes.get(var2)).getEquCode() + ":" + ((Equipes)this.lesEquipes.get(var2)).getEquNomFr()));
         }
      }

      if (this.optionsVentes.getResponsable().equals("1") || this.optionsVentes.getResponsable().equals("2")) {
         new ArrayList();
         List var6 = this.usersDao.chargerLesSignataires("Ventes", var1);
         this.mesUsersItem.clear();
         if (var6.size() != 0) {
            this.mesUsersItem.add(new SelectItem(0, ""));

            for(int var3 = 0; var3 < var6.size(); ++var3) {
               Users var4 = (Users)var6.get(var3);
               if (var4.getUsrPatronyme() != null && !var4.getUsrPatronyme().isEmpty()) {
                  this.mesUsersItem.add(new SelectItem(var4.getUsrid(), var4.getUsrPatronyme()));
               }
            }
         }

         new ArrayList();
         List var7 = this.usersDao.chargerLesCommerciaux(var1);
         this.mesCommercialItem.clear();
         if (var7.size() != 0) {
            this.mesCommercialItem.add(new SelectItem(0, ""));

            for(int var8 = 0; var8 < var7.size(); ++var8) {
               Users var5 = (Users)var7.get(var8);
               if (var5.getUsrPatronyme() != null && !var5.getUsrPatronyme().isEmpty()) {
                  this.mesCommercialItem.add(new SelectItem(var5.getUsrid(), var5.getUsrPatronyme()));
               }
            }
         }
      }

   }

   public void recupererTypeContrat(Session var1) throws HibernateException, NamingException {
      this.mesTypeContratItems = this.modelesCourriersDao.chargerLesContratsVentes(var1);
   }

   public void recupererMarque(Session var1) throws HibernateException, NamingException {
      this.mesMarquesItems.clear();
      this.mesGammesItems.clear();
      this.mesProduitsItems.clear();
      this.mesTaxesVentesProduits.clear();
      this.mesProduitsDepotsItems.clear();
      this.produits = new Produits();
      MarquesDao var2 = new MarquesDao(this.baseLog, this.utilInitHibernate);
      this.mesMarquesItems = var2.chargerLesMarques(var1);
   }

   public void recupererGamme() throws HibernateException, NamingException {
      this.mesGammesItems.clear();
      this.mesProduitsItems.clear();
      this.mesTaxesVentesProduits.clear();
      this.mesProduitsDepotsItems.clear();
      this.produits = new Produits();
      String[] var1 = this.var_famille_produit.split(":");
      new ArrayList();
      List var2 = this.produitsDao.chargerLesProduitsVentesByGamme(var1[0], this.simulationEnteteVentes.getSimcrtMarque(), (Session)null);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            this.produits = new Produits();
            this.produits = (Produits)var2.get(var3);
            this.mesGammesItems.add(new SelectItem(this.produits.getProVteCode(), this.produits.getProVteLib()));
         }
      }

   }

   public void recupererProduit() throws HibernateException, NamingException {
      this.mesProduitsItems.clear();
      this.mesTaxesVentesProduits.clear();
      this.mesProduitsDepotsItems.clear();
      this.produits = new Produits();
      new ArrayList();
      List var1 = this.produitsDao.chargerLesProduitsVentesByModele(this.simulationEnteteVentes.getSimcrtMarque(), this.simulationEnteteVentes.getSimcrtGamme(), (Session)null);
      if (var1.size() != 0) {
         this.mesProduitsItems.add(new SelectItem(0, "Sélection modèle"));

         for(int var2 = 0; var2 < var1.size(); ++var2) {
            this.produits = new Produits();
            this.produits = (Produits)var1.get(var2);
            this.mesProduitsItems.add(new SelectItem(this.produits.getProCode() + ":" + this.produits.getProLibClient()));
         }
      }

   }

   public void chargerLesSecteurs() throws HibernateException, NamingException {
      this.mesSecteursItems.clear();
      this.mesPdvItems.clear();
      if (this.inpRegion != null && !this.inpRegion.isEmpty()) {
         new Region();
         RegionDao var2 = new RegionDao(this.baseLog, this.utilInitHibernate);
         String[] var3 = this.inpRegion.split(":");
         Region var1 = var2.rechercheRegion(var3[0], (Session)null);
         if (var1 != null) {
            SecteurDao var4 = new SecteurDao(this.baseLog, this.utilInitHibernate);
            this.mesSecteursItems = var4.listSecteurByRegionItem(var1, (Session)null);
         }
      }

   }

   public void chargerLesPdv() throws HibernateException, NamingException {
      this.mesPdvItems.clear();
      if (this.inpSecteur != null && !this.inpSecteur.isEmpty()) {
         new Secteur();
         SecteurDao var2 = new SecteurDao(this.baseLog, this.utilInitHibernate);
         String[] var3 = this.inpSecteur.split(":");
         Secteur var1 = var2.rechercheSecteur(var3[0], (Session)null);
         if (var1 != null) {
            PointDeVenteDao var4 = new PointDeVenteDao(this.baseLog, this.utilInitHibernate);
            this.mesPdvItems = var4.listPdvBySecteurItem(var1, (Session)null);
         }
      }

   }

   public void moreSearch() throws ParseException {
      this.selectDestinataire = false;
      this.inpRegion = "";
      this.inpSecteur = "";
      this.inpPdv = "";
      if (!this.var_more_search) {
         this.var_more_search = true;
         this.periode = "100";
         String var1 = (new Date()).getYear() + 1900 + "-01-01";
         this.inpDu = this.utilDate.stringToDateSQLLight(var1);
         String var2 = (new Date()).getYear() + 1900 + "-12-31";
         this.inpAu = this.utilDate.stringToDateSQLLight(var2);
      } else {
         this.var_more_search = false;
         this.inpDu = null;
         this.inpAu = null;
         this.inpDestinataire = "";
         this.inpActivite = "100";
      }

   }

   public void executerRequete() throws IOException, HibernateException, NamingException, ParseException {
      this.inpIdTiersEnCours = 0L;
      this.inpNomTiersEnCours = "";
      this.inpNomDestinataire = "";
      this.chargeListeDetail((Session)null);
   }

   public void executerRequeteTiers() throws IOException, HibernateException, NamingException, ParseException {
      this.inpNomDestinataire = "";
      this.chargeListeDetail((Session)null);
   }

   public void executerRequeteDestinataire() throws IOException, HibernateException, NamingException, ParseException {
      this.inpIdTiersEnCours = 0L;
      this.inpNomTiersEnCours = "";
      this.inpDestinataire = this.inpNomDestinataire;
      this.chargeListeDetail((Session)null);
   }

   public void chargeListeDetail(Session var1) throws HibernateException, NamingException, ParseException {
      this.lesEntetesList.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      double var2 = 0.0D;
      double var4 = 0.0D;
      double var6 = 0.0D;
      this.var_nb_ligne = 0;
      String var8 = "";
      String var9 = "";
      if (this.var_more_search) {
         if (this.inpDu != null) {
            var8 = this.utilDate.dateToStringSQLLight(this.inpDu);
         }

         if (this.inpAu != null) {
            var9 = this.utilDate.dateToStringSQLLight(this.inpAu);
         }
      } else {
         var8 = null;
         var9 = null;
      }

      if (this.inpNum != null && !this.inpNum.isEmpty()) {
         this.inpEtat = 100;
      }

      if (this.inpEtat != 50) {
         this.lesEntetesList = this.simulationEnteteVentesDao.recherche(var1, this.exercicesVentes.getExevteId(), this.getInpNum(), this.getInpIdTiersEnCours(), this.getInpClient(), this.getInpEtat(), this.getInpSerie(), this.getInpCat(), this.getPeriode(), this.getInpUser(), this.usersLog.getUsrid(), this.usersLog.getUsrVentes(), this.getInpDestinataire(), this.getInpActivite(), var8, var9, this.inpRegion, this.inpSecteur, this.inpPdv);
      }

      if (this.lesEntetesList.size() > 0) {
         this.datamodelEntete = new ListDataModel();
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
         new SimulationEnteteVentes();

         for(int var11 = 0; var11 < this.lesEntetesList.size(); ++var11) {
            SimulationEnteteVentes var10 = (SimulationEnteteVentes)this.lesEntetesList.get(var11);
            var2 += var10.getSimcrtTotTtc();
            var4 += var10.getSimcrtTotHt();
            var6 += var10.getSimcrtTotTva();
         }

         this.var_nb_ligne = this.lesEntetesList.size();
      }

      this.datamodelEntete.setWrappedData(this.lesEntetesList);
      this.montantTtc = var2;
      this.visibiliteBton = false;
      this.inpNomTiersEnCours = "";
      this.inpIdTiersEnCours = 0L;
      this.inpNomDestinataire = "";
      this.inpDestinataire = "";
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
            this.simulationEnteteVentes = (SimulationEnteteVentes)var1.get(0);
            this.inpNomTiersEnCours = this.simulationEnteteVentes.getSimcrtNomTiers();
            this.inpIdTiersEnCours = this.simulationEnteteVentes.getTiers().getTieid();
            this.inpNomDestinataire = this.simulationEnteteVentes.getSimcrtNomContact();
            this.var_date = this.simulationEnteteVentes.getSimcrtDate();
            if (this.simulationEnteteVentes.getSimcrtDate().getHours() <= 9) {
               this.var_heure = "0" + this.simulationEnteteVentes.getSimcrtDate().getHours();
            } else {
               this.var_heure = "" + this.simulationEnteteVentes.getSimcrtDate().getHours();
            }

            if (this.simulationEnteteVentes.getSimcrtDate().getMinutes() <= 9) {
               this.var_minute = "0" + this.simulationEnteteVentes.getSimcrtDate().getMinutes();
            } else {
               this.var_minute = "" + this.simulationEnteteVentes.getSimcrtDate().getMinutes();
            }

            if (this.simulationEnteteVentes.getSimcrtDate().getSeconds() <= 9) {
               this.var_seconde = "0" + this.simulationEnteteVentes.getSimcrtDate().getSeconds();
            } else {
               this.var_seconde = "" + this.simulationEnteteVentes.getSimcrtDate().getSeconds();
            }

            this.tiers = this.simulationEnteteVentes.getTiers();
            this.formRecherche.setTiers(this.tiers);
            if (!this.simulationEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("010") && !this.simulationEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("020") && !this.simulationEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("030") && !this.simulationEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("037")) {
               this.var_typeTiers = true;
            } else {
               this.var_typeTiers = false;
            }

            this.calculMessageLitige();
            this.var_nom_contact = this.simulationEnteteVentes.getSimcrtIdContact();
            this.var_nom_responsable = this.simulationEnteteVentes.getSimcrtIdResponsable();
            this.var_nom_commercial = this.simulationEnteteVentes.getSimcrtIdCommercial();
            this.calculDevise();
            Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "SimulEnteteLight");
            this.chargerDocumentTrace(var4);
            this.chargerLesContactsItem(var4);
            this.chargerProduit(var4);
            this.chargerContrat(var4);
            this.chargerLesUsers(var4);
            this.chargerParapheur(var4);
            this.chargerLesParcs(var4);
            this.mesGammesItems.clear();
            this.mesProduitsItems.clear();
            this.mesTaxesVentesProduits.clear();
            this.mesGammesItems.add(new SelectItem(this.simulationEnteteVentes.getSimcrtGamme()));
            this.mesProduitsItems.add(new SelectItem(this.simulationEnteteVentes.getSimcrtCode() + ":" + this.simulationEnteteVentes.getSimcrtModele()));
            this.mesTaxesVentesProduits.add(new SelectItem(this.simulationEnteteVentes.getSimcrtTaxe() + ":" + this.simulationEnteteVentes.getSimcrtTauxTaxe()));
            if (this.mesContactItem == null || this.mesContactItem.size() == 0) {
               this.mesContactItem.add(new SelectItem(0, ""));
               this.var_nom_contact = 0L;
            }

            if (this.mesUsersItem == null || this.mesUsersItem.size() == 0) {
               this.mesUsersItem.add(new SelectItem(0, ""));
               this.var_nom_responsable = 0L;
            }

            this.setMontantTtcElmt(this.simulationEnteteVentes.getSimcrtTotTtc());
            this.format = "PDF";
            this.var_choix_modele = 0;
            this.verrouNum = true;
            this.visibiliteBton = true;
            if (this.simulationEnteteVentes.getSimcrtTotTc() != 0.0D) {
               this.var_tc_calcul = true;
            } else {
               this.var_tc_calcul = false;
            }

            this.utilInitHibernate.closeSession();
         } else {
            this.visibiliteBton = false;
         }
      } else {
         this.visibiliteBton = false;
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.simulationEnteteVentes != null) {
         if (this.simulationEnteteVentes.getSimcrtEtat() == 0) {
            this.modifDocument();
         } else {
            this.consultDocument();
         }
      }

   }

   public void calculDevise() {
      if (this.simulationEnteteVentes.getSimcrtDevise() != null) {
         this.var_format_devise = this.utilNombre.formatDevise(this.simulationEnteteVentes.getSimcrtDevise());
      }

   }

   public void chargerProduit(Session var1) throws HibernateException, NamingException {
      this.produits = new Produits();
      if (this.simulationEnteteVentes.getSimcrtCode() != null && !this.simulationEnteteVentes.getSimcrtCode().isEmpty()) {
         this.produits = this.produitsDao.chargeProduit(this.simulationEnteteVentes.getSimcrtCode(), var1);
      }

   }

   public void chargerContrat(Session var1) throws HibernateException, NamingException {
      this.modelesCourriers = new ModelesCourriers();
      if (this.simulationEnteteVentes.getSimcrtTypeContrat() != null && !this.simulationEnteteVentes.getSimcrtTypeContrat().isEmpty() && this.simulationEnteteVentes.getSimcrtTypeContrat().contains(":")) {
         String[] var2 = this.simulationEnteteVentes.getSimcrtTypeContrat().split(":");
         this.modelesCourriers = this.modelesCourriersDao.rechercheModeles(var2[0], var1);
      }

   }

   public void chargerDocumentTrace(Session var1) throws HibernateException, NamingException {
      this.datamodelDocumentTrace = new ListDataModel();
      Object var2 = new ArrayList();
      if (this.simulationEnteteVentes.getSimcrtId() > 0L) {
         var2 = this.documentTraceVentesDao.chargerLesDocumentsTrace(this.simulationEnteteVentes.getSimcrtId(), this.nature, var1);
      }

      this.datamodelDocumentTrace.setWrappedData(var2);
   }

   public void chargerUserChrono(Session var1) throws HibernateException, NamingException {
      if (this.simulationEnteteVentes != null && this.simulationEnteteVentes.getSimcrtSerie() != null && !this.simulationEnteteVentes.getSimcrtSerie().isEmpty()) {
         this.usersChrono = this.usersChronoDao.selectUnique(this.simulationEnteteVentes.getSimcrtSerie(), this.nature, this.usersLog, var1);
      }

   }

   public void ajoutDocument() throws IOException, JDOMException, HibernateException, NamingException {
      this.simulationEnteteVentes = new SimulationEnteteVentes();
      this.produits = new Produits();
      this.produitsDepot = new ProduitsDepot();
      this.modelesCourriers = new ModelesCourriers();
      this.mesGammesItems.clear();
      this.mesProduitsItems.clear();
      this.mesTaxesVentesProduits.clear();
      this.var_code_produit = "";
      this.simulationEnteteVentes.setUsers(this.usersLog);
      this.simulationEnteteVentes.setSimcrtIdCreateur(this.usersLog.getUsrid());
      this.simulationEnteteVentes.setSimcrtNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.simulationEnteteVentes.setSimcrtIdResponsable(this.usersLog.getUsrid());
      this.simulationEnteteVentes.setSimcrtNomResponsable(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.simulationEnteteVentes.setSimcrtDate(new Date());
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
      if (this.optionsVentes.getNbrJrRelanceDEVIS() != null && !this.optionsVentes.getNbrJrRelanceDEVIS().isEmpty()) {
         var3 = Integer.parseInt(this.optionsVentes.getNbrJrRelanceDEVIS());
      } else {
         var3 = 0;
      }

      boolean var2 = false;
      int var4;
      if (this.optionsVentes.getNbrJrValidDEVIS() != null && !this.optionsVentes.getNbrJrValidDEVIS().isEmpty()) {
         var4 = Integer.parseInt(this.optionsVentes.getNbrJrValidDEVIS());
      } else {
         var4 = 0;
      }

      this.simulationEnteteVentes.setSimcrtDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var3));
      this.simulationEnteteVentes.setSimcrtDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var4));
      this.simulationEnteteVentes.setSimcrtDateLivraison((Date)null);
      this.var_nom_responsable = 0L;
      this.calculSimulation();
      this.mesContactItem.clear();
      this.mesContactItem.add(new SelectItem(0, ""));
      if (this.optionsVentes.getResponsable().equals("0")) {
         this.mesUsersItem.clear();
         this.mesUsersItem.add(new SelectItem(0, ""));
      }

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
      this.selectDestinataire = true;
      if (this.var_tc_type == 7) {
         this.var_tc_calcul = true;
      } else {
         this.var_tc_calcul = false;
      }

      this.autorisationDocument();
   }

   public void modifDocument() throws JDOMException, IOException {
      if (this.simulationEnteteVentes != null) {
         this.var_action = 1;
         this.var_memo_action = this.var_action;
         this.var_aff_action = false;
         this.visibleOnglet = true;
         this.var_valide_doc = true;
         this.var_aff_detail_tiers = true;
         this.selectDestinataire = true;
         if (this.usersLog.getUsrSignatureVentes() != 1 && this.var_nom_responsable != 0L) {
            this.mesUsersItem.clear();
            this.mesUsersItem.add(new SelectItem(this.simulationEnteteVentes.getSimcrtIdResponsable(), this.simulationEnteteVentes.getSimcrtNomResponsable()));
         }

         this.autorisationDocument();
      }

   }

   public void consultDocument() throws JDOMException, IOException {
      if (this.simulationEnteteVentes != null) {
         this.var_action = 2;
         this.var_memo_action = this.var_action;
         this.var_aff_action = true;
         this.visibleOnglet = true;
         this.var_valide_doc = true;
         this.var_aff_detail_tiers = true;
         this.selectDestinataire = true;
         this.mesUsersItem.clear();
         this.mesUsersItem.add(new SelectItem(this.simulationEnteteVentes.getSimcrtIdResponsable(), this.simulationEnteteVentes.getSimcrtNomResponsable()));
         this.autorisationDocument();
      }

   }

   public void valideDocument() throws HibernateException, NamingException {
      if (this.simulationEnteteVentes != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SimulEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.simulationEnteteVentes.getSimcrtEtat() == 0 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
               this.simulationEnteteVentes.setSimcrtEtat(1);
               this.simulationEnteteVentes.setSimcrtDateValide(new Date());
               this.simulationEnteteVentes = this.simulationEnteteVentesDao.modif(this.simulationEnteteVentes, var1);
               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Validation manuelle simulation (C.) N° " + this.simulationEnteteVentes.getSimcrtNum() + " du " + this.utilDate.dateToStringSQLLight(this.simulationEnteteVentes.getSimcrtDate()));
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

   public void deValideDocument() throws HibernateException, NamingException {
      if (this.simulationEnteteVentes != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SimulEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.simulationEnteteVentes.getSimcrtEtat() == 1) {
               this.simulationEnteteVentes.setSimcrtEtat(0);
               this.simulationEnteteVentes.setSimcrtDateValide((Date)null);
               this.simulationEnteteVentes = this.simulationEnteteVentesDao.modif(this.simulationEnteteVentes, var1);
               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Dévalidation manuelle simulation (C.) N° " + this.simulationEnteteVentes.getSimcrtNum() + " du " + this.utilDate.dateToStringSQLLight(this.simulationEnteteVentes.getSimcrtDate()));
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

   public void supprimerDocument() throws HibernateException, NamingException {
      if (this.simulationEnteteVentes != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SimulEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.simulationEnteteVentes.getSimcrtNum();
            Date var4 = this.simulationEnteteVentes.getSimcrtDate();
            new DocumentTraceVentes();
            DocumentTraceVentes var5 = this.documentTraceVentesDao.chercherDestinationTrace(this.simulationEnteteVentes.getSimcrtId(), this.nature, var1);
            if (var5 != null) {
               long var6 = var5.getDoctraOrgId();
               this.documentTraceVentesDao.delete(var5, var1);
            }

            this.lesEntetesList.remove(this.simulationEnteteVentes);
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
            this.utilParapheur.supprimerParapheur(this.simulationEnteteVentes.getSimcrtId(), this.nature, var1);
            this.simulationEnteteVentesDao.delete(this.simulationEnteteVentes.getSimcrtId(), var1);
            Espion var13 = new Espion();
            var13.setUsers(this.usersLog);
            var13.setEsptype(0);
            var13.setEspdtecreat(new Date());
            var13.setEspaction("Suppression Simulation contrat N° " + var3 + " du " + var4);
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
      }

      this.visibiliteBton = false;
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
   }

   public void duppliquerDocument() throws HibernateException, NamingException, Exception {
      if (this.simulationEnteteVentes.getSimcrtId() >= 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SimulEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            ArrayList var3 = new ArrayList();
            this.simulationEnteteVentes.setUsers(this.usersLog);
            this.simulationEnteteVentes.setSimcrtIdCreateur(this.usersLog.getUsrid());
            this.simulationEnteteVentes.setSimcrtNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.simulationEnteteVentes.setSimcrtDate(new Date());
            this.simulationEnteteVentes.setSimcrtDateCreat(new Date());
            this.simulationEnteteVentes.setSimcrtDateModif((Date)null);
            this.simulationEnteteVentes.setSimcrtIdModif(0L);
            this.simulationEnteteVentes.setSimcrtNomModif("");
            this.simulationEnteteVentes.setSimcrtNum("");
            this.simulationEnteteVentes.setSimcrtIdResponsable(this.usersLog.getUsrid());
            this.simulationEnteteVentes.setSimcrtNomResponsable(this.usersLog.getUsrPatronyme());
            boolean var4 = false;
            int var13;
            if (this.optionsVentes.getNbrJrRelanceDEVIS() != null && !this.optionsVentes.getNbrJrRelanceDEVIS().isEmpty()) {
               var13 = Integer.parseInt(this.optionsVentes.getNbrJrRelanceDEVIS());
            } else {
               var13 = 0;
            }

            boolean var5 = false;
            int var14;
            if (this.optionsVentes.getNbrJrValidDEVIS() != null && !this.optionsVentes.getNbrJrValidDEVIS().isEmpty()) {
               var14 = Integer.parseInt(this.optionsVentes.getNbrJrValidDEVIS());
            } else {
               var14 = 0;
            }

            this.simulationEnteteVentes.setSimcrtDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var13));
            this.simulationEnteteVentes.setSimcrtDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var14));
            this.simulationEnteteVentes.setSimcrtDateLivraison((Date)null);
            if (!this.simulationEnteteVentes.getSimcrtSerie().equalsIgnoreCase("X") && !this.simulationEnteteVentes.getSimcrtSerie().isEmpty()) {
               this.simulationEnteteVentes.setSimcrtNum(this.calculChrono.numCompose(this.simulationEnteteVentes.getSimcrtDate(), this.nature, this.simulationEnteteVentes.getSimcrtSerie(), var1));
            } else {
               long var6 = this.simulationEnteteVentesDao.selectLastNum(var1);
               this.simulationEnteteVentes.setSimcrtNum("" + var6);
            }

            this.verifieExistenceHabilitation(var1);
            this.simulationEnteteVentes.setSimcrtDateAnnule((Date)null);
            this.simulationEnteteVentes.setSimcrtMotifAnnule("");
            this.simulationEnteteVentes.setSimcrtDateImp((Date)null);
            this.simulationEnteteVentes.setSimcrtDateTransforme((Date)null);
            this.simulationEnteteVentes.setSimcrtEtat(0);
            var3.add(this.simulationEnteteVentes);
            this.simulationEnteteVentes = this.simulationEnteteVentesDao.insert((SimulationEnteteVentes)var3.get(0), var1);
            if (this.habilitation != null) {
               this.utilParapheur.majParapheur(this.nature, this.habilitation, this.simulationEnteteVentes.getSimcrtId(), this.simulationEnteteVentes.getSimcrtNum(), this.simulationEnteteVentes.getSimcrtNomTiers(), this.simulationEnteteVentes.getSimcrtDate(), this.simulationEnteteVentes.getSimcrtDevise(), this.simulationEnteteVentes.getSimcrtTotTtc() + this.simulationEnteteVentes.getSimcrtTotTc(), this.simulationEnteteVentes.getSimcrtModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(), this.calculeParc(var1), this.simulationEnteteVentes.getVar_format_devise(), 0, var1);
            }

            this.chargeListeDetail(var1);
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

   }

   public void reactiverDocument() throws HibernateException, NamingException {
      if (this.simulationEnteteVentes != null) {
         this.simulationEnteteVentes.setSimcrtEtat(0);
         this.simulationEnteteVentes.setSimcrtDateAnnule((Date)null);
         this.simulationEnteteVentes.setSimcrtMotifAnnule("");
         this.simulationEnteteVentes = this.simulationEnteteVentesDao.modif(this.simulationEnteteVentes);
      }

   }

   public void transformerDocument() throws HibernateException, NamingException {
   }

   public void calculContrat() throws HibernateException, NamingException {
      if (this.simulationEnteteVentes.getSimcrtTypeContrat() != null && !this.simulationEnteteVentes.getSimcrtTypeContrat().isEmpty() && this.simulationEnteteVentes.getSimcrtTypeContrat().contains(":")) {
         String[] var1 = this.simulationEnteteVentes.getSimcrtTypeContrat().split(":");
         this.modelesCourriers = this.modelesCourriersDao.rechercheModeles(var1[0], (Session)null);
         if (this.modelesCourriers != null) {
            this.simulationEnteteVentes.setSimcrtDureeMin(this.modelesCourriers.getModDureeMin());
            this.simulationEnteteVentes.setSimcrtDureeMax(this.modelesCourriers.getModDureeMax());
            this.simulationEnteteVentes.setSimcrtTauxValeurResiduelle(this.modelesCourriers.getModTauxValeurResiduelle());
            this.simulationEnteteVentes.setSimcrtTauxAmortissement(this.modelesCourriers.getModTauxAmortissement());
            this.simulationEnteteVentes.setSimcrtTauxAssurance(this.modelesCourriers.getModTauxAssurance());
            this.simulationEnteteVentes.setSimcrtTauxEntretien(this.modelesCourriers.getModTauxContratEntretien());
            this.simulationEnteteVentes.setSimcrtTauxFraisFinancier(this.modelesCourriers.getModTauxFraisFinancier());
            this.simulationEnteteVentes.setSimcrtTauxFraisStructure(this.modelesCourriers.getModTauxFraisStructure());
            this.simulationEnteteVentes.setSimcrtTauxFranchise(this.modelesCourriers.getModTauxFranchise());
            this.simulationEnteteVentes.setSimcrtTauxMarge(this.modelesCourriers.getModTauxMarge());
            this.simulationEnteteVentes.setSimcrtTauxRemplacement(this.modelesCourriers.getModTauxRemplacement());
            this.simulationEnteteVentes.setSimcrtTauxRemplissage(this.modelesCourriers.getModTauxRemplissage());
         } else {
            this.modelesCourriers = null;
         }
      }

   }

   public void calculProduit() throws HibernateException, NamingException {
      if (this.var_code_produit != null && !this.var_code_produit.isEmpty() && this.var_code_produit.contains(":")) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisLigne");
         String[] var2 = this.var_code_produit.split(":");
         this.produits = this.produitsDao.chargeProduit(var2[0], var1);
         if (this.produits == null) {
            this.produits = null;
         } else {
            this.simulationEnteteVentes.setSimcrtCode(this.produits.getProCode());
            this.simulationEnteteVentes.setSimcrtModele(this.produits.getProLibClient());
            this.mesTaxesVentesProduits.clear();
            if (this.produits.getProVteTva() != null && !this.produits.getProVteTva().isEmpty()) {
               this.mesTaxesVentesProduits.add(new SelectItem(this.produits.getProVteTva()));
               this.simulationEnteteVentes.setSimcrtTaxe(this.produits.getProVteTva());
            } else {
               new FamillesProduitsVentes();
               FamillesProduitsVentes var3 = this.famillesProduitsVentesDao.rechercheFamilleByProd(this.exercicesVentes.getExevteId(), this.produits, var1);
               if (var3 != null && var3.getFamvteCode() != null) {
                  this.mesTaxesVentesProduits.add(new SelectItem(var3.getFamvteTaxe()));
                  this.simulationEnteteVentes.setSimcrtTaxe(var3.getFamvteTaxe());
               } else {
                  this.mesTaxesVentesProduits.add(new SelectItem(""));
                  this.simulationEnteteVentes.setSimcrtTaxe("");
               }
            }

            int var8 = 0;
            if (this.lesFamilleClientsListe.size() != 0) {
               for(int var4 = 0; var4 < this.lesFamilleClientsListe.size(); ++var4) {
                  if (this.simulationEnteteVentes.getSimcrtCat() != null && !this.simulationEnteteVentes.getSimcrtCat().isEmpty() && this.simulationEnteteVentes.getSimcrtCat().equalsIgnoreCase(((ObjetFamilleTiers)this.lesFamilleClientsListe.get(var4)).getLibelle())) {
                     var8 = var4;
                     break;
                  }
               }
            }

            double var9 = 0.0D;
            if (var8 == 1) {
               this.simulationEnteteVentes.setSimcrtPrc(this.produits.getProPrcExoP());
            } else if (var8 == 2) {
               this.simulationEnteteVentes.setSimcrtPrc(this.produits.getProPrcExoT());
            } else {
               this.simulationEnteteVentes.setSimcrtPrc(this.produits.getProPrcHt());
            }

            double var6 = 0.0D;
            if (var8 == 1) {
               this.simulationEnteteVentes.setSimcrtPrg(this.produits.getProPrgExoP());
            } else if (var8 == 2) {
               this.simulationEnteteVentes.setSimcrtPrg(this.produits.getProPrgExoT());
            } else {
               this.simulationEnteteVentes.setSimcrtPrg(this.produits.getProPrgHt());
            }

            this.selectionDepot(var1);
            this.calculSimulation();
         }

         this.utilInitHibernate.closeSession();
      }

   }

   public void selectionDepot(Session var1) throws HibernateException, NamingException {
      if (this.produits != null) {
         this.mesProduitsDepotsItems.clear();
         new ArrayList();
         List var2 = this.produitsDepotDao.selectProdDepByprod(this.produits, this.nature, var1);
         if (var2.size() != 0) {
            for(int var3 = 0; var3 < var2.size(); ++var3) {
               this.produitsDepot = new ProduitsDepot();
               this.produitsDepot = (ProduitsDepot)var2.get(var3);
               float var4 = this.produitsDepot.getProdepQteStk() - this.produitsDepot.getProdepQteAttVte();
               if (this.produitsDepot.getProdepCasier() != null && !this.produitsDepot.getProdepCasier().isEmpty()) {
                  this.mesProduitsDepotsItems.add(new SelectItem(this.produitsDepot.getDepot().getDpoCode() + ":" + this.produitsDepot.getProdepCasier() + "=" + var4));
               } else {
                  this.mesProduitsDepotsItems.add(new SelectItem(this.produitsDepot.getDepot().getDpoCode() + "=" + var4));
               }
            }
         }
      }

   }

   public void calculSimulation() throws HibernateException, NamingException {
      if (this.produits != null) {
         String var1 = this.simulationEnteteVentes.getSimcrtDevise();
         if (var1 == null || var1.isEmpty()) {
            var1 = this.structureLog.getStrdevise();
         }

         float var2 = 0.0F;
         if (this.simulationEnteteVentes.getSimcrtTaxe() != null && !this.simulationEnteteVentes.getSimcrtTaxe().isEmpty()) {
            new TaxesVentes();
            TaxesVentes var3 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), this.simulationEnteteVentes.getSimcrtTaxe(), (Session)null);
            if (var3 != null) {
               var2 = var3.getTaxvteTaux();
            }
         }

         int var48 = this.simulationEnteteVentes.getSimcrtNbMois();
         if (var48 == 0) {
            var48 = 1;
         }

         double var4 = 0.0D;
         double var6 = 0.0D;
         if (this.simulationEnteteVentes.getSimcrtPrg() != 0.0D) {
            var4 = this.simulationEnteteVentes.getSimcrtPrc();
            var6 = this.simulationEnteteVentes.getSimcrtPrg();
         } else {
            int var8 = 0;
            if (this.lesFamilleClientsListe.size() != 0) {
               for(int var9 = 0; var9 < this.lesFamilleClientsListe.size(); ++var9) {
                  if (this.simulationEnteteVentes.getSimcrtCat() != null && !this.simulationEnteteVentes.getSimcrtCat().isEmpty() && this.simulationEnteteVentes.getSimcrtCat().equalsIgnoreCase(((ObjetFamilleTiers)this.lesFamilleClientsListe.get(var9)).getLibelle())) {
                     var8 = var9;
                     break;
                  }
               }
            }

            if (var8 == 1) {
               var4 = this.produits.getProPrcExoP();
            } else if (var8 == 2) {
               var4 = this.produits.getProPrcExoT();
            } else {
               var4 = this.produits.getProPrcHt();
            }

            if (var8 == 1) {
               var6 = this.produits.getProPrgExoP();
            } else if (var8 == 2) {
               var6 = this.produits.getProPrgExoT();
            } else {
               var6 = this.produits.getProPrgHt();
            }
         }

         double var49 = 0.0D;
         if (this.simulationEnteteVentes.getSimcrtTauxRemise() != 0.0F) {
            var49 = this.utilNombre.myRoundDevise(var6 * (double)this.simulationEnteteVentes.getSimcrtTauxRemise() / 100.0D, var1);
         }

         double var10 = var6 - var49 + this.simulationEnteteVentes.getSimcrtAccessoire();
         double var12 = this.utilNombre.myRoundDevise(var10 * (double)(this.simulationEnteteVentes.getSimcrtTauxAmortissement() * (float)var48) / 100.0D, var1);
         double var14 = this.utilNombre.myRoundDevise((var6 - this.simulationEnteteVentes.getSimcrtAcompte()) * (double)(this.simulationEnteteVentes.getSimcrtTauxFraisFinancier() / 12.0F * (float)var48) / 100.0D, var1);
         double var16 = this.utilNombre.myRoundDevise(var6 * (double)(this.simulationEnteteVentes.getSimcrtTauxEntretien() / 12.0F * (float)var48) / 100.0D, var1);
         double var18 = this.utilNombre.myRoundDevise(var6 * (double)(this.simulationEnteteVentes.getSimcrtTauxAssurance() / 12.0F * (float)var48) / 100.0D, var1);
         double var20 = this.utilNombre.myRoundDevise(var6 * (double)(this.simulationEnteteVentes.getSimcrtTauxFranchise() / 12.0F * (float)var48) / 100.0D, var1);
         double var22 = this.utilNombre.myRoundDevise(var6 * (double)(this.simulationEnteteVentes.getSimcrtTauxFraisStructure() / 12.0F * (float)var48) / 100.0D, var1);
         double var24 = this.utilNombre.myRoundDevise(var6 * (double)(this.simulationEnteteVentes.getSimcrtTauxRemplacement() / 12.0F * (float)var48) / 100.0D, var1);
         double var26 = this.utilNombre.myRoundDevise(var6 * (double)(this.simulationEnteteVentes.getSimcrtTauxRemplissage() / 12.0F * (float)var48) / 100.0D, var1);
         double var28 = var6 - this.simulationEnteteVentes.getSimcrtAcompte() + var12 + var14 + var16 + var18 + var20 + var22 + var24 + var26;
         double var30 = this.utilNombre.myRoundDevise(var6 * (double)this.simulationEnteteVentes.getSimcrtTauxValeurResiduelle() / 100.0D, var1);
         double var32 = var28 - this.simulationEnteteVentes.getSimcrtValeurResiduelleReelle();
         double var34 = var32 + this.simulationEnteteVentes.getSimcrtAcompte() + this.simulationEnteteVentes.getSimcrtValeurResiduelleReelle();
         double var36 = this.utilNombre.myRoundDevise(var34 * (double)var2 / 100.0D, var1);
         double var38 = var34 + var36;
         double var40 = var38 - this.simulationEnteteVentes.getSimcrtAcompte() - this.simulationEnteteVentes.getSimcrtValeurResiduelleReelle();
         double var42 = this.utilNombre.myRoundDevise(var40 / (double)var48, var1);
         double var44 = this.utilNombre.myRoundDevise(var42 / (double)(1.0F + var2 / 100.0F), var1);
         double var46 = var42 - var44;
         this.simulationEnteteVentes.setSimcrtPrc(var4);
         this.simulationEnteteVentes.setSimcrtPrg(var6);
         this.simulationEnteteVentes.setSimcrtRemise(var49);
         this.simulationEnteteVentes.setSimcrtBase(var10);
         this.simulationEnteteVentes.setSimcrtAmortissement(var12);
         this.simulationEnteteVentes.setSimcrtFraisFinancier(var14);
         this.simulationEnteteVentes.setSimcrtEntretien(var16);
         this.simulationEnteteVentes.setSimcrtAssurance(var18);
         this.simulationEnteteVentes.setSimcrtFranchise(var20);
         this.simulationEnteteVentes.setSimcrtFraisStructure(var22);
         this.simulationEnteteVentes.setSimcrtRemplacement(var24);
         this.simulationEnteteVentes.setSimcrtRemplissage(var26);
         this.simulationEnteteVentes.setSimcrtPr(var28);
         this.simulationEnteteVentes.setSimcrtValeurResiduelleTheo(var30);
         this.simulationEnteteVentes.setSimcrtValeurRachat(var32);
         this.simulationEnteteVentes.setSimcrtThMois(var44);
         this.simulationEnteteVentes.setSimcrtTxMois(var46);
         this.simulationEnteteVentes.setSimcrtTtMois(var42);
         this.simulationEnteteVentes.setSimcrtTotHt(var34);
         this.simulationEnteteVentes.setSimcrtTotTva(var36);
         this.simulationEnteteVentes.setSimcrtTotTtc(var38);
         this.simulationEnteteVentes.setSimcrtCumulEcheance(var40);
      }

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
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SimulEnteteLight");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.majAnalytique(var1);
         this.simulationEnteteVentes.setSimcrtDate(this.utilDate.dateToSQL(this.var_date, this.var_heure, this.var_minute, this.var_seconde));
         if (this.simulationEnteteVentes.getUsers() == null) {
            this.simulationEnteteVentes.setUsers(this.usersLog);
         }

         if (this.tiers.getTietype().equals("1")) {
            this.tiers.setTietype("2");
            if (this.tiers.getTiegenre().equals("010")) {
               this.tiers.setTiegenre("020");
            } else if (this.tiers.getTiegenre().equals("011")) {
               this.tiers.setTiegenre("021");
            }

            TiersDao var3 = new TiersDao(this.baseLog, this.utilInitHibernate);
            this.tiers = var3.modif(this.tiers, var1);
         }

         this.simulationEnteteVentes.setTiers(this.tiers);
         if ((this.simulationEnteteVentes.getSimcrtCat() == null || this.simulationEnteteVentes.getSimcrtCat().isEmpty()) && this.simulationEnteteVentes.getTiers().getTienomfamille() != null && !this.simulationEnteteVentes.getTiers().getTienomfamille().isEmpty()) {
            this.simulationEnteteVentes.setSimcrtCat(this.simulationEnteteVentes.getTiers().getTienomfamille());
         }

         if (!this.simulationEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("010") && !this.simulationEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("020") && !this.simulationEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("030") && !this.simulationEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("037")) {
            this.simulationEnteteVentes.setSimcrtCivilTiers("");
         } else {
            this.simulationEnteteVentes.setSimcrtCivilTiers(this.simulationEnteteVentes.getTiers().getTiecivilite());
         }

         if (!this.contDest) {
            if (this.simulationEnteteVentes.getSimcrtDiversTiers() == 99) {
               this.simulationEnteteVentes.setSimcrtIdContact(0L);
               this.simulationEnteteVentes.setSimcrtNomContact("");
               this.simulationEnteteVentes.setSimcrtCivilContact("");
            } else {
               new Contacts();
               Contacts var15 = this.contactDao.recupererContacts(this.var_nom_contact, var1);
               if (var15 != null) {
                  this.simulationEnteteVentes.setSimcrtIdContact(var15.getConid());
                  if (var15.getConpatronyme() != null && !var15.getConpatronyme().isEmpty()) {
                     this.simulationEnteteVentes.setSimcrtNomContact(var15.getConpatronyme());
                     this.simulationEnteteVentes.setSimcrtCivilContact(var15.getConcivilite());
                  } else if (var15.getConservice() != null && !var15.getConservice().isEmpty()) {
                     this.simulationEnteteVentes.setSimcrtNomContact(var15.getConservice());
                     this.simulationEnteteVentes.setSimcrtCivilContact("SERVICE/SITE:");
                  } else {
                     this.simulationEnteteVentes.setSimcrtIdContact(0L);
                     this.simulationEnteteVentes.setSimcrtNomContact("");
                     this.simulationEnteteVentes.setSimcrtCivilContact("");
                  }
               } else {
                  this.simulationEnteteVentes.setSimcrtIdContact(0L);
                  this.simulationEnteteVentes.setSimcrtNomContact("");
                  this.simulationEnteteVentes.setSimcrtCivilContact("");
               }
            }
         }

         this.simulationEnteteVentes.setSimcrtIdResponsable(0L);
         this.simulationEnteteVentes.setSimcrtNomResponsable("");
         new Users();
         if (this.var_nom_responsable == 0L && this.mesUsersItem.size() == 1) {
            this.var_nom_responsable = Long.parseLong(((SelectItem)this.mesUsersItem.get(0)).getValue().toString());
         }

         Users var16 = this.usersDao.selectUserD(this.var_nom_responsable, var1);
         if (var16 != null) {
            this.simulationEnteteVentes.setSimcrtIdResponsable(var16.getUsrid());
            this.simulationEnteteVentes.setSimcrtNomResponsable(var16.getUsrPatronyme());
         }

         this.simulationEnteteVentes.setSimcrtIdCommercial(0L);
         this.simulationEnteteVentes.setSimcrtNomCommercial("");
         if (this.optionsVentes.getResponsable().equals("1") || this.optionsVentes.getResponsable().equals("2")) {
            new Users();
            if (this.var_nom_commercial == 0L && this.mesCommercialItem.size() == 1) {
               this.var_nom_commercial = Long.parseLong(((SelectItem)this.mesCommercialItem.get(0)).getValue().toString());
            }

            Users var4 = this.usersDao.selectUserD(this.var_nom_commercial, var1);
            if (var4 != null) {
               this.simulationEnteteVentes.setSimcrtIdCommercial(var4.getUsrid());
               this.simulationEnteteVentes.setSimcrtNomCommercial(var4.getUsrPatronyme());
            }
         }

         this.simulationEnteteVentes.setSimcrtIdEquipe(0L);
         this.simulationEnteteVentes.setSimcrtNomEquipe("");
         if (this.optionsVentes.getResponsable().equals("1")) {
            this.equipes = this.equipesDao.rechercheEquipes(this.simulationEnteteVentes.getSimcrtIdResponsable(), var1);
            if (this.equipes != null) {
               this.simulationEnteteVentes.setSimcrtIdEquipe(this.equipes.getEquId());
               this.simulationEnteteVentes.setSimcrtNomEquipe(this.equipes.getEquNomFr());
            }
         }

         if (this.var_timbre != 0) {
            int var17 = this.var_date.getYear() + 1900;
            double var5 = this.utilNombre.calculTimbre(this.structureLog, this.simulationEnteteVentes.getSimcrtTotTtc() + this.simulationEnteteVentes.getSimcrtTotTc(), var17, this.simulationEnteteVentes.getSimcrtDevise(), this.simulationEnteteVentes.getSimcrtDate());
            double var7 = this.utilNombre.myRoundDevise(var5, this.simulationEnteteVentes.getSimcrtDevise());
            if (var7 != 0.0D) {
               String var9 = this.utilNombre.beginSimple(var7, this.simulationEnteteVentes.getSimcrtDevise());
               this.simulationEnteteVentes.setSimcrtFormule2(this.utilNombre.texteTimbre(this.structureLog, var9, var17, this.simulationEnteteVentes.getSimcrtDevise(), this.simulationEnteteVentes.getSimcrtDate()));
            }
         }

         if (this.simulationEnteteVentes.getSimcrtId() != 0L) {
            if (this.simulationEnteteVentes.getSimcrtEtat() == 6) {
               if (this.simulationEnteteVentes.getSimcrtEtatVal() == 1) {
                  this.simulationEnteteVentes.setSimcrtEtat(0);
               } else {
                  this.simulationEnteteVentes.setSimcrtEtat(0);
               }
            }

            this.simulationEnteteVentes.setSimcrtDateModif(new Date());
            this.simulationEnteteVentes.setSimcrtIdModif(this.usersLog.getUsrid());
            this.simulationEnteteVentes.setSimcrtNomModif(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.simulationEnteteVentes = this.simulationEnteteVentesDao.modif(this.simulationEnteteVentes, var1);
            this.var_action = 0;
            this.var_memo_action = this.var_action;
            this.visibleOnglet = false;
         } else {
            this.simulationEnteteVentes.setExerciceventes(this.exercicesVentes);
            this.simulationEnteteVentes.setSimcrtDateCreat(new Date());
            this.simulationEnteteVentes.setSimcrtIdCreateur(this.usersLog.getUsrid());
            this.simulationEnteteVentes.setSimcrtNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            if (this.simulationEnteteVentes.getSimcrtSerie() != null && !this.simulationEnteteVentes.getSimcrtSerie().equalsIgnoreCase("X") && !this.simulationEnteteVentes.getSimcrtSerie().isEmpty()) {
               this.simulationEnteteVentes.setSimcrtNum(this.calculChrono.numCompose(this.simulationEnteteVentes.getSimcrtDate(), this.nature, this.simulationEnteteVentes.getSimcrtSerie(), var1));
               boolean var19 = false;

               label368:
               while(true) {
                  while(true) {
                     if (var19) {
                        break label368;
                     }

                     new SimulationEnteteVentes();
                     SimulationEnteteVentes var20 = this.simulationEnteteVentesDao.pourParapheur(this.simulationEnteteVentes.getSimcrtNum(), this.simulationEnteteVentes.getSimcrtSerie(), var1);
                     if (var20 != null) {
                        long var6 = 100000000L * this.usersLog.getUsrid();

                        for(long var8 = 0L; var8 < var6; ++var8) {
                        }

                        this.simulationEnteteVentes.setSimcrtNum(this.calculChrono.numCompose(this.simulationEnteteVentes.getSimcrtDate(), this.nature, this.simulationEnteteVentes.getSimcrtSerie(), var1));
                        var19 = false;
                     } else {
                        var19 = true;
                     }
                  }
               }
            } else {
               long var18 = this.simulationEnteteVentesDao.selectLastNum(var1);
               this.simulationEnteteVentes.setSimcrtNum("" + var18);
            }

            this.simulationEnteteVentes.setSimcrtEtat(0);
            this.simulationEnteteVentes.setSimcrtEtatVal(0);
            this.simulationEnteteVentes.setSimcrtDateValide((Date)null);
            this.simulationEnteteVentes = this.simulationEnteteVentesDao.insert(this.simulationEnteteVentes, var1);
            this.visibleOnglet = true;
            this.var_action = 0;
            this.var_memo_action = this.var_action;
            this.lesEntetesList.add(this.simulationEnteteVentes);
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
         }

         if (this.habilitation != null && this.var_action == 0) {
            this.utilParapheur.majParapheur(this.nature, this.habilitation, this.simulationEnteteVentes.getSimcrtId(), this.simulationEnteteVentes.getSimcrtNum(), this.simulationEnteteVentes.getSimcrtNomTiers(), this.simulationEnteteVentes.getSimcrtDate(), this.simulationEnteteVentes.getSimcrtDevise(), this.simulationEnteteVentes.getSimcrtTotTtc() + this.simulationEnteteVentes.getSimcrtTotTc(), this.simulationEnteteVentes.getSimcrtModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(), this.calculeParc(var1), this.simulationEnteteVentes.getVar_format_devise(), 0, var1);
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

   public void majAnalytique(Session var1) throws HibernateException, NamingException {
      this.simulationEnteteVentes.setSimcrtSite(this.usersLog.getUsrSite());
      this.simulationEnteteVentes.setSimcrtDepartement(this.usersLog.getUsrDepartement());
      this.simulationEnteteVentes.setSimcrtService(this.usersLog.getUsrService());
      if (this.contDest) {
         this.simulationEnteteVentes.setSimcrtIdContact(0L);
         this.plansAnalytiques = this.formRecherche.rechercheDestinataire(this.plansAnalytiques, (PlansAnalytiquesDao)null, this.simulationEnteteVentes.getSimcrtNomContact(), var1);
         if (this.plansAnalytiques != null) {
            this.simulationEnteteVentes.setSimcrtRegion(this.plansAnalytiques.getAnaTiersRegion());
            this.simulationEnteteVentes.setSimcrtSecteur(this.plansAnalytiques.getAnaTiersSecteur());
            this.simulationEnteteVentes.setSimcrtPdv(this.plansAnalytiques.getAnaTiersPdv());
         } else {
            this.simulationEnteteVentes.setSimcrtRegion(this.tiers.getTieregion());
            this.simulationEnteteVentes.setSimcrtSecteur(this.tiers.getTiesecteur());
            this.simulationEnteteVentes.setSimcrtPdv(this.tiers.getTiepdv());
         }
      } else {
         this.simulationEnteteVentes.setSimcrtRegion(this.tiers.getTieregion());
         this.simulationEnteteVentes.setSimcrtSecteur(this.tiers.getTiesecteur());
         this.simulationEnteteVentes.setSimcrtPdv(this.tiers.getTiepdv());
      }

      if (!this.var_anal_activite) {
         this.simulationEnteteVentes.setSimcrtActivite("");
      }

      if (!this.var_anal_dossier && !this.accesAffaires) {
         this.simulationEnteteVentes.setSimcrtAnal4("");
      } else if ((this.var_anal_dossier || this.accesAffaires) && this.simulationEnteteVentes.getSimcrtAnal4() != null && this.simulationEnteteVentes.getSimcrtAnal4().length() <= 2) {
         this.simulationEnteteVentes.setSimcrtAnal4("");
      }

      this.simulationEnteteVentes.setSimcrtAnal2("");
   }

   public boolean verifieExistenceHabilitation(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         this.simulationEnteteVentes.setSimcrtEtatVal(1);
         this.simulationEnteteVentes.setSimcrtEtat(0);
         this.simulationEnteteVentes.setSimcrtDateValide((Date)null);
         return true;
      } else {
         this.simulationEnteteVentes.setSimcrtEtatVal(0);
         this.chargerUserChrono(var1);
         if (this.usersChrono != null) {
            if (this.usersChrono.getUsrchrValidation() == 0) {
               this.simulationEnteteVentes.setSimcrtEtat(1);
               this.simulationEnteteVentes.setSimcrtDateValide(new Date());
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2 && this.usersChrono.getUsrchrValidation() == 3) {
               this.simulationEnteteVentes.setSimcrtEtat(0);
               this.simulationEnteteVentes.setSimcrtDateValide((Date)null);
            }
         }

         if (this.simulationEnteteVentes.getSimcrtDateImp() != null) {
            if (this.simulationEnteteVentes.getSimcrtEtat() == 0) {
               this.simulationEnteteVentes.setSimcrtEtat(1);
               this.simulationEnteteVentes.setSimcrtDateValide(new Date());
            }
         } else {
            this.simulationEnteteVentes.setSimcrtEtat(0);
            this.simulationEnteteVentes.setSimcrtDateValide((Date)null);
         }

         return false;
      }
   }

   public void rechercheTiers() throws JDOMException, IOException, HibernateException, NamingException {
      this.tiers = this.formRecherche.rechercheTiers(3, this.simulationEnteteVentes.getSimcrtNomTiers(), this.nature);
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
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Tiers");
         boolean var2 = false;
         if (this.tiers.getTieserie() != null && !this.tiers.getTieserie().isEmpty()) {
            if (this.tiers.getTieserie().equals("X")) {
               var2 = true;
            } else {
               for(int var3 = 0; var3 < this.mesSerieUserItem.size(); ++var3) {
                  if (((SelectItem)this.mesSerieUserItem.get(var3)).getValue().toString().equals(this.tiers.getTieserie())) {
                     var2 = true;
                     this.simulationEnteteVentes.setSimcrtSerie(this.tiers.getTieserie());
                     break;
                  }
               }
            }
         } else {
            var2 = true;
         }

         if (!var2) {
            this.annuleTiers();
         } else {
            this.simulationEnteteVentes.setTiers(this.tiers);
            if (!this.tiers.getTiegenre().equalsIgnoreCase("010") && !this.tiers.getTiegenre().equalsIgnoreCase("020") && !this.tiers.getTiegenre().equalsIgnoreCase("030") && !this.tiers.getTiegenre().equalsIgnoreCase("037")) {
               this.nomTier = this.tiers.getTieraisonsocialenom();
               this.simulationEnteteVentes.setSimcrtCivilTiers("");
               this.var_typeTiers = true;
            } else {
               this.nomTier = this.tiers.getTieraisonsocialenom() + " " + this.tiers.getTieprenom();
               this.simulationEnteteVentes.setSimcrtCivilTiers(this.simulationEnteteVentes.getTiers().getTiecivilite());
               this.var_typeTiers = false;
            }

            this.simulationEnteteVentes.setSimcrtNomTiers(this.nomTier);
            this.simulationEnteteVentes.setSimcrtCat(this.tiers.getTienomfamille());
            this.simulationEnteteVentes.setSimcrtExoDouane(this.tiers.getTieexodouane());
            this.simulationEnteteVentes.setSimcrtExoTva(this.tiers.getTieexotva());
            this.calculMessageLitige();
            if (this.tiers.getTiefacpr() == 2) {
               this.simulationEnteteVentes.setSimcrtExoTva(1);
            }

            if (this.tiers.getTiecategorie().equalsIgnoreCase("Client Divers")) {
               this.simulationEnteteVentes.setSimcrtDiversTiers(99);
               this.var_pr_pv = false;
            } else {
               this.simulationEnteteVentes.setSimcrtDiversTiers(0);
               this.simulationEnteteVentes.setSimcrtDiversNom("");
               this.simulationEnteteVentes.setSimcrtDiversAdresse("");
               this.simulationEnteteVentes.setSimcrtDiversVille("");
               this.chargerLesUsers(var1);
               this.simulationEnteteVentes.setSimcrtDiversTel("");
               this.simulationEnteteVentes.setSimcrtDiversMail("");
               if (this.tiers.getTiefacpr() == 0) {
                  this.var_pr_pv = false;
               } else {
                  this.var_pr_pv = true;
               }
            }

            if (!"".equals(this.tiers.getTiedevise()) && this.tiers.getTiedevise() != null) {
               this.simulationEnteteVentes.setSimcrtDevise(this.tiers.getTiedevise());
            } else {
               this.simulationEnteteVentes.setSimcrtDevise(this.structureLog.getStrdevise());
            }

            this.mesContactItem.clear();
            if (!this.contDest) {
               this.chargerLesUsers(var1);
               this.chargerLesContactsItem(var1);
            } else if (this.contDest) {
            }

            this.chargerLesUsers(var1);
            this.chargerLesParcs(var1);
         }

         this.utilInitHibernate.closeSession();
      } else {
         this.annuleTiers();
      }

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

   public void annuleTiers() {
      this.tiers = null;
      this.informationsTiers = null;
      this.simulationEnteteVentes.setTiers(this.tiers);
      this.simulationEnteteVentes.setSimcrtNomTiers("");
      this.simulationEnteteVentes.setSimcrtCivilTiers("");
      this.mesContactItem.clear();
      this.mesContactItem.add(new SelectItem(0, ""));
      if (this.optionsVentes.getResponsable().equals("0")) {
         this.mesUsersItem.clear();
         this.mesUsersItem.add(new SelectItem(0, ""));
      }

      this.controleSaisie();
      this.var_action = this.var_memo_action;
   }

   public void chargerLesContactsItem(Session var1) throws HibernateException, NamingException {
      this.mesContactItem = new ArrayList();
      this.mesContactItem = this.contactDao.chargerLesContactsItems(this.tiers.getTieid(), var1);
   }

   public void chargerLesParcs(Session var1) throws HibernateException, NamingException {
      if (this.var_anal_parc) {
         ParcDao var2 = new ParcDao(this.baseLog, this.utilInitHibernate);
         if (this.var_option_parc == 1 || this.var_option_parc == 2) {
            this.mesParcsItems.clear();
            this.mesParcsItems = var2.chargerLesParcs(this.tiers.getTieid(), var1);
         }
      }

   }

   public void chargerParapheur(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         if (this.parapheurDao == null) {
            this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
         }

         this.parapheur = this.parapheurDao.existenceParapheur(this.simulationEnteteVentes.getSimcrtId(), this.nature, var1);
         if (this.parapheur == null) {
            this.parapheur = new Parapheur();
         }
      } else {
         this.parapheur = new Parapheur();
      }

   }

   public void controleSaisie() {
      if (!this.simulationEnteteVentes.getSimcrtNomTiers().equals("") && this.tiers.getTieid() != 0L) {
         this.var_valide_doc = true;
         this.var_aff_detail_tiers = true;
      } else {
         this.var_valide_doc = false;
         this.var_aff_detail_tiers = false;
      }

   }

   public void recupererEltCat() throws HibernateException, NamingException {
      String var1 = "";
      String var2 = "";
      if (this.lesFamilleClientsListe.size() != 0) {
         for(int var3 = 0; var3 < this.lesFamilleClientsListe.size(); ++var3) {
            if (this.simulationEnteteVentes.getSimcrtCat().equalsIgnoreCase(((ObjetFamilleTiers)this.lesFamilleClientsListe.get(var3)).getLibelle())) {
               var1 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(var3)).getExoTva();
               var2 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(var3)).getExoDouane();
               break;
            }
         }
      }

      if (!var1.equalsIgnoreCase("true") && this.tiers.getTiefacpr() != 2) {
         this.simulationEnteteVentes.setSimcrtExoTva(0);
      } else {
         this.simulationEnteteVentes.setSimcrtExoTva(1);
      }

      if (var2.equalsIgnoreCase("true")) {
         this.simulationEnteteVentes.setSimcrtExoDouane(1);
      } else {
         this.simulationEnteteVentes.setSimcrtExoDouane(0);
      }

      this.calculSimulation();
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

   public String conversionGarde() throws HibernateException, NamingException {
      String var1 = null;
      if (this.simulationEnteteVentes.getSimcrtGarde() != null && !this.simulationEnteteVentes.getSimcrtGarde().isEmpty() && this.simulationEnteteVentes.getSimcrtGarde().contains(":")) {
         String[] var2 = this.simulationEnteteVentes.getSimcrtGarde().split(":");
         this.modelesCourriers = new ModelesCourriers();
         this.modelesCourriers = this.modelesCourriersDao.rechercheModeles(var2[0], (Session)null);
         if (this.modelesCourriers != null) {
            if (this.modelesCourriers.getModTexte().contains("[")) {
               var1 = this.utilTdt.analyseTexteCommercial(this.modelesCourriers.getModTexte(), this.simulationEnteteVentes.getUsers(), this.structureLog, this.simulationEnteteVentes.getTiers());
            } else {
               var1 = this.modelesCourriers.getModTexte();
            }

            if (this.usersLog.getUsrSignature() != null && !this.usersLog.getUsrSignature().isEmpty()) {
               String var3 = "http://" + this.getUrlIpProd() + "/epegase/imageServlet/" + "structure" + this.structureLog.getStrid() + "/photos/Users/" + this.usersLog.getUsrSignature();
               var1 = var1 + "<p>&nbsp;</p><p>&nbsp;</p><p><img style=" + "display: block; margin-left: auto; margin-right: auto;" + " title=" + "signature" + " src=" + var3 + " alt=" + "signature /></p>";
            }
         }
      }

      return var1;
   }

   public String conversionAnnexe1() throws HibernateException, NamingException {
      String var1 = null;
      if (this.simulationEnteteVentes.getSimcrtAnnexe1() != null && !this.simulationEnteteVentes.getSimcrtAnnexe1().isEmpty() && this.simulationEnteteVentes.getSimcrtAnnexe1().contains(":")) {
         String[] var2 = this.simulationEnteteVentes.getSimcrtAnnexe1().split(":");
         this.modelesCourriers = new ModelesCourriers();
         this.modelesCourriers = this.modelesCourriersDao.rechercheModeles(var2[0], (Session)null);
         if (this.modelesCourriers != null) {
            if (this.modelesCourriers.getModTexte().contains("[")) {
               var1 = this.utilTdt.analyseTexteCommercial(this.modelesCourriers.getModTexte(), this.simulationEnteteVentes.getUsers(), this.structureLog, this.simulationEnteteVentes.getTiers());
            } else {
               var1 = this.modelesCourriers.getModTexte();
            }

            if (this.usersLog.getUsrSignature() != null && !this.usersLog.getUsrSignature().isEmpty()) {
               String var3 = "http://" + this.getUrlIpProd() + "/epegase/imageServlet/" + "structure" + this.structureLog.getStrid() + "/photos/Users/" + this.usersLog.getUsrSignature();
               var1 = var1 + "<p>&nbsp;</p><p>&nbsp;</p><p><img style=" + "display: block; margin-left: auto; margin-right: auto;" + " title=" + "signature" + " src=" + var3 + " alt=" + "signature /></p>";
            }
         }
      }

      return var1;
   }

   public String conversionAnnexe2() throws HibernateException, NamingException {
      String var1 = null;
      if (this.simulationEnteteVentes.getSimcrtAnnexe2() != null && !this.simulationEnteteVentes.getSimcrtAnnexe2().isEmpty() && this.simulationEnteteVentes.getSimcrtAnnexe2().contains(":")) {
         String[] var2 = this.simulationEnteteVentes.getSimcrtAnnexe2().split(":");
         this.modelesCourriers = new ModelesCourriers();
         this.modelesCourriers = this.modelesCourriersDao.rechercheModeles(var2[0], (Session)null);
         if (this.modelesCourriers != null) {
            if (this.modelesCourriers.getModTexte().contains("[")) {
               var1 = this.utilTdt.analyseTexteCommercial(this.modelesCourriers.getModTexte(), this.simulationEnteteVentes.getUsers(), this.structureLog, this.simulationEnteteVentes.getTiers());
            } else {
               var1 = this.modelesCourriers.getModTexte();
            }

            if (this.usersLog.getUsrSignature() != null && !this.usersLog.getUsrSignature().isEmpty()) {
               String var3 = "http://" + this.getUrlIpProd() + "/epegase/imageServlet/" + "structure" + this.structureLog.getStrid() + "/photos/Users/" + this.usersLog.getUsrSignature();
               var1 = var1 + "<p>&nbsp;</p><p>&nbsp;</p><p><img style=" + "display: block; margin-left: auto; margin-right: auto;" + " title=" + "signature" + " src=" + var3 + " alt=" + "signature /></p>";
            }
         }
      }

      return var1;
   }

   public String calculeCheminRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "simulation" + File.separator;
      return var2;
   }

   public String calculeCheminSousRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport" + File.separator;
      return var2;
   }

   public String calculeCheminImageProduit(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "photos" + File.separator + "produits" + File.separator + "photo" + File.separator;
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
            var4 = new File(this.calculeCheminSousRapport(var1) + "formatSimulation.jpg");
            if (var4.exists()) {
               var3 = "formatSimulation.jpg";
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
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatSimulation.jpg");
         if (var4.exists()) {
            var3 = "formatSimulation.jpg";
         }
      }

      return var3;
   }

   public JRBeanCollectionDataSource calculeImpressionCommun() throws IOException {
      if (this.produits.getProPhoto() != null && !this.produits.getProPhoto().isEmpty()) {
         this.simulationEnteteVentes.setVar_photo(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "produits" + File.separator + "photo" + File.separator + this.produits.getProPhoto());
      } else {
         this.simulationEnteteVentes.setVar_photo((String)null);
      }

      this.simulationEnteteVentes.setVar_descriptif(this.produits.getProDescrip());
      this.simulationEnteteVentes.setVar_suite(this.modelesCourriers.getModOption());
      this.simulationEnteteVentes.setVar_condition(this.modelesCourriers.getModConditionPaiement());
      this.montant_lettre = this.utilNombre.begin(this.simulationEnteteVentes.getSimcrtTotTtc() + this.simulationEnteteVentes.getSimcrtTotTc(), this.simulationEnteteVentes.getSimcrtDevise());
      ArrayList var1 = new ArrayList();
      var1.add(this.simulationEnteteVentes);
      JRBeanCollectionDataSource var2 = new JRBeanCollectionDataSource(var1);
      return var2;
   }

   public String calculeParc(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      new Parc();
      Parc var3;
      if (this.simulationEnteteVentes.getSimcrtAnal2() != null && !this.simulationEnteteVentes.getSimcrtAnal2().isEmpty()) {
         String var4 = "";
         if (this.simulationEnteteVentes.getSimcrtAnal2().contains(":")) {
            String[] var5 = this.simulationEnteteVentes.getSimcrtAnal2().split(":");
            var4 = var5[0];
         } else {
            var4 = this.simulationEnteteVentes.getSimcrtAnal2();
         }

         ParcDao var6 = new ParcDao(this.baseLog, this.utilInitHibernate);
         var3 = var6.rechercheParc(var4, var1);
         if (var3 != null) {
            var2 = var3.getPrcImmatriculation();
         }
      } else {
         var3 = null;
      }

      return var2;
   }

   public boolean majDateImpression(String var1) throws HibernateException, NamingException {
      boolean var2 = false;
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "SimulEnteteLight");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         if (this.simulationEnteteVentes.getSimcrtDateImp() != null) {
            var2 = true;
         }

         this.simulationEnteteVentes.setSimcrtDateImp(new Date());
         if (this.simulationEnteteVentes.getSimcrtEtat() == 0 && this.simulationEnteteVentes.getSimcrtEtatVal() == 0 && this.usersChrono.getUsrchrValidation() == 1) {
            this.simulationEnteteVentes.setSimcrtEtat(1);
         }

         this.simulationEnteteVentes.setSimcrtModeleImp(var1);
         this.simulationEnteteVentes = this.simulationEnteteVentesDao.modif(this.simulationEnteteVentes, var3);
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
            var1.setEntete("Impression simulation");
            var1.setMontant_lettre(this.montant_lettre);
            var1.setPageGarde(this.conversionGarde());
            var1.setAnnexe1(this.conversionAnnexe1());
            var1.setAnnexe2(this.conversionAnnexe2());
            var1.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid()));
            var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid(), this.simulationEnteteVentes.getSimcrtEtat()));
            var1.setDuplicata("" + var11);
            var1.setFormat(var5);
            var1.setEmetteur(var6);
            var1.setDestinataire(var7);
            var1.setDestinataireCC(var8);
            var1.setDestinataireCCI(var9);
            var1.setCorpsMail(var10);
            var1.setIdResponsable(this.simulationEnteteVentes.getSimcrtIdResponsable());
            var1.setIdCommercial(this.simulationEnteteVentes.getSimcrtIdCommercial());
            var1.setTiersSelectionne(this.simulationEnteteVentes.getTiers());
            var1.setNumDoc(this.simulationEnteteVentes.getSimcrtNum());
            var1.setNature(this.nature);
            var1.setId_doc(this.simulationEnteteVentes.getSimcrtId());
            if (this.simulationEnteteVentes.getSimcrtAnal2() != null && !this.simulationEnteteVentes.getSimcrtAnal2().isEmpty()) {
               String var12 = "";
               if (this.simulationEnteteVentes.getSimcrtAnal2().contains(":")) {
                  String[] var13 = this.simulationEnteteVentes.getSimcrtAnal2().split(":");
                  var12 = var13[0];
               } else {
                  var12 = this.simulationEnteteVentes.getSimcrtAnal2();
               }

               new Parc();
               ParcDao var14 = new ParcDao(this.baseLog, this.utilInitHibernate);
               Parc var16 = var14.rechercheParc(var12, (Session)null);
               if (var16 != null) {
                  var1.setParc(var16);
               } else {
                  var1.setParc((Parc)null);
               }
            } else {
               var1.setParc((Parc)null);
            }

            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      } else if (var4 != null && !var4.isEmpty()) {
         var1.setRapport(var4);
         var1.setEntete("Impression de la liste des simulations");
         var1.setTotauxHt("");
         var1.setTotauxTaxe("");
         var1.setTotauxTtc("" + this.montantTtc);
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste" + File.separator + "simulation" + File.separator);
         var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport" + File.separator);
         var1.setFormat(var5);
         var1.setEmetteur(var6);
         var1.setDestinataire(var7);
         var1.setDestinataireCC(var8);
         var1.setDestinataireCCI(var9);
         var1.setCorpsMail(var10);
         var1.setIdResponsable(0L);
         var1.setTiersSelectionne((Tiers)null);
         var1.setNature(this.nature);
         var1.setId_doc(0L);
         JRBeanCollectionDataSource var15 = new JRBeanCollectionDataSource(this.lesEntetesList);
         var1.setjRBeanCollectionDataSource(var15);
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

   public UtilInitHibernate getUtilInitHibernate() {
      return this.utilInitHibernate;
   }

   public void setUtilInitHibernate(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
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

   public Users getUsersLog() {
      return this.usersLog;
   }

   public void setUsersLog(Users var1) {
      this.usersLog = var1;
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

   public int getVar_action() {
      return this.var_action;
   }

   public void setVar_action(int var1) {
      this.var_action = var1;
   }

   public boolean isVar_more_search() {
      return this.var_more_search;
   }

   public void setVar_more_search(boolean var1) {
      this.var_more_search = var1;
   }

   public String getInpActivite() {
      return this.inpActivite;
   }

   public void setInpActivite(String var1) {
      this.inpActivite = var1;
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

   public String getInpClient() {
      return this.inpClient;
   }

   public void setInpClient(String var1) {
      this.inpClient = var1;
   }

   public String getInpDestinataire() {
      return this.inpDestinataire;
   }

   public void setInpDestinataire(String var1) {
      this.inpDestinataire = var1;
   }

   public String getInpDossier() {
      return this.inpDossier;
   }

   public void setInpDossier(String var1) {
      this.inpDossier = var1;
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

   public String getInpParc() {
      return this.inpParc;
   }

   public void setInpParc(String var1) {
      this.inpParc = var1;
   }

   public String getInpSerie() {
      return this.inpSerie;
   }

   public void setInpSerie(String var1) {
      this.inpSerie = var1;
   }

   public long getInpUser() {
      return this.inpUser;
   }

   public void setInpUser(long var1) {
      this.inpUser = var1;
   }

   public String getPeriode() {
      return this.periode;
   }

   public void setPeriode(String var1) {
      this.periode = var1;
   }

   public int getVar_option_parc() {
      return this.var_option_parc;
   }

   public void setVar_option_parc(int var1) {
      this.var_option_parc = var1;
   }

   public int getVar_timbre() {
      return this.var_timbre;
   }

   public void setVar_timbre(int var1) {
      this.var_timbre = var1;
   }

   public List getLesFamilleClientsListe() {
      return this.lesFamilleClientsListe;
   }

   public void setLesFamilleClientsListe(List var1) {
      this.lesFamilleClientsListe = var1;
   }

   public List getMesTaxesVentesItems() {
      return this.mesTaxesVentesItems;
   }

   public void setMesTaxesVentesItems(List var1) {
      this.mesTaxesVentesItems = var1;
   }

   public List getMesParcsItems() {
      return this.mesParcsItems;
   }

   public void setMesParcsItems(List var1) {
      this.mesParcsItems = var1;
   }

   public DataModel getDatamodelDocumentTrace() {
      return this.datamodelDocumentTrace;
   }

   public void setDatamodelDocumentTrace(DataModel var1) {
      this.datamodelDocumentTrace = var1;
   }

   public DataModel getDatamodelEntete() {
      return this.datamodelEntete;
   }

   public void setDatamodelEntete(DataModel var1) {
      this.datamodelEntete = var1;
   }

   public UsersChrono getUsersChrono() {
      return this.usersChrono;
   }

   public void setUsersChrono(UsersChrono var1) {
      this.usersChrono = var1;
   }

   public boolean isVisibiliteBton() {
      return this.visibiliteBton;
   }

   public void setVisibiliteBton(boolean var1) {
      this.visibiliteBton = var1;
   }

   public boolean isShowModalPanelImput() {
      return this.showModalPanelImput;
   }

   public void setShowModalPanelImput(boolean var1) {
      this.showModalPanelImput = var1;
   }

   public boolean isShowModalPanelPrint() {
      return this.showModalPanelPrint;
   }

   public void setShowModalPanelPrint(boolean var1) {
      this.showModalPanelPrint = var1;
   }

   public SimulationEnteteVentes getSimulationEnteteVentes() {
      return this.simulationEnteteVentes;
   }

   public void setSimulationEnteteVentes(SimulationEnteteVentes var1) {
      this.simulationEnteteVentes = var1;
   }

   public int getVar_nb_max() {
      return this.var_nb_max;
   }

   public void setVar_nb_max(int var1) {
      this.var_nb_max = var1;
   }

   public boolean isVar_anal_activite() {
      return this.var_anal_activite;
   }

   public void setVar_anal_activite(boolean var1) {
      this.var_anal_activite = var1;
   }

   public boolean isAccesAffaires() {
      return this.accesAffaires;
   }

   public void setAccesAffaires(boolean var1) {
      this.accesAffaires = var1;
   }

   public boolean isVar_anal_dossier() {
      return this.var_anal_dossier;
   }

   public void setVar_anal_dossier(boolean var1) {
      this.var_anal_dossier = var1;
   }

   public boolean isVar_anal_parc() {
      return this.var_anal_parc;
   }

   public void setVar_anal_parc(boolean var1) {
      this.var_anal_parc = var1;
   }

   public int getVar_choix_modele() {
      return this.var_choix_modele;
   }

   public void setVar_choix_modele(int var1) {
      this.var_choix_modele = var1;
   }

   public String getVar_libcondest() {
      return this.var_libcondest;
   }

   public void setVar_libcondest(String var1) {
      this.var_libcondest = var1;
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

   public int getVar_nb_ligne() {
      return this.var_nb_ligne;
   }

   public void setVar_nb_ligne(int var1) {
      this.var_nb_ligne = var1;
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

   public boolean isAffichagePump() {
      return this.affichagePump;
   }

   public void setAffichagePump(boolean var1) {
      this.affichagePump = var1;
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

   public boolean isContDest() {
      return this.contDest;
   }

   public void setContDest(boolean var1) {
      this.contDest = var1;
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

   public boolean isVar_acc_etat() {
      return this.var_acc_etat;
   }

   public void setVar_acc_etat(boolean var1) {
      this.var_acc_etat = var1;
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

   public boolean isVar_acc_tracabilite() {
      return this.var_acc_tracabilite;
   }

   public void setVar_acc_tracabilite(boolean var1) {
      this.var_acc_tracabilite = var1;
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

   public boolean isVar_typeTiers() {
      return this.var_typeTiers;
   }

   public void setVar_typeTiers(boolean var1) {
      this.var_typeTiers = var1;
   }

   public List getMesProduitsItems() {
      return this.mesProduitsItems;
   }

   public void setMesProduitsItems(List var1) {
      this.mesProduitsItems = var1;
   }

   public List getMesTypeContratItems() {
      return this.mesTypeContratItems;
   }

   public void setMesTypeContratItems(List var1) {
      this.mesTypeContratItems = var1;
   }

   public Produits getProduits() {
      return this.produits;
   }

   public void setProduits(Produits var1) {
      this.produits = var1;
   }

   public String getUrlphotoProd() {
      return this.urlphotoProd;
   }

   public void setUrlphotoProd(String var1) {
      this.urlphotoProd = var1;
   }

   public boolean isVisibleOnglet() {
      return this.visibleOnglet;
   }

   public void setVisibleOnglet(boolean var1) {
      this.visibleOnglet = var1;
   }

   public boolean isVar_verrou_comm() {
      return this.var_verrou_comm;
   }

   public void setVar_verrou_comm(boolean var1) {
      this.var_verrou_comm = var1;
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

   public boolean isVar_valide_doc() {
      return this.var_valide_doc;
   }

   public void setVar_valide_doc(boolean var1) {
      this.var_valide_doc = var1;
   }

   public Tiers getTiers() {
      return this.tiers;
   }

   public void setTiers(Tiers var1) {
      this.tiers = var1;
   }

   public boolean isVar_mod() {
      return this.var_mod;
   }

   public void setVar_mod(boolean var1) {
      this.var_mod = var1;
   }

   public boolean isGriserchamps() {
      return this.griserchamps;
   }

   public void setGriserchamps(boolean var1) {
      this.griserchamps = var1;
   }

   public boolean isVar_sansstock() {
      return this.var_sansstock;
   }

   public void setVar_sansstock(boolean var1) {
      this.var_sansstock = var1;
   }

   public List getMesTaxesVentesProduits() {
      return this.mesTaxesVentesProduits;
   }

   public void setMesTaxesVentesProduits(List var1) {
      this.mesTaxesVentesProduits = var1;
   }

   public List getMesProduitsDepotsItems() {
      return this.mesProduitsDepotsItems;
   }

   public void setMesProduitsDepotsItems(List var1) {
      this.mesProduitsDepotsItems = var1;
   }

   public boolean isVerrouPrvente() {
      return this.verrouPrvente;
   }

   public void setVerrouPrvente(boolean var1) {
      this.verrouPrvente = var1;
   }

   public boolean isVerrouRemRab() {
      return this.verrouRemRab;
   }

   public void setVerrouRemRab(boolean var1) {
      this.verrouRemRab = var1;
   }

   public List getMesMarquesItems() {
      return this.mesMarquesItems;
   }

   public void setMesMarquesItems(List var1) {
      this.mesMarquesItems = var1;
   }

   public String getVar_depotProd() {
      return this.var_depotProd;
   }

   public void setVar_depotProd(String var1) {
      this.var_depotProd = var1;
   }

   public String getVar_code_produit() {
      return this.var_code_produit;
   }

   public void setVar_code_produit(String var1) {
      this.var_code_produit = var1;
   }

   public ModelesCourriers getModelesCourriers() {
      return this.modelesCourriers;
   }

   public void setModelesCourriers(ModelesCourriers var1) {
      this.modelesCourriers = var1;
   }

   public List getMesGammesItems() {
      return this.mesGammesItems;
   }

   public void setMesGammesItems(List var1) {
      this.mesGammesItems = var1;
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

   public List getMesCommercialItem() {
      return this.mesCommercialItem;
   }

   public void setMesCommercialItem(List var1) {
      this.mesCommercialItem = var1;
   }

   public long getVar_nom_commercial() {
      return this.var_nom_commercial;
   }

   public void setVar_nom_commercial(long var1) {
      this.var_nom_commercial = var1;
   }

   public List getMesSerieUserItem() {
      return this.mesSerieUserItem;
   }

   public void setMesSerieUserItem(List var1) {
      this.mesSerieUserItem = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public String getInformationsTiers() {
      return this.informationsTiers;
   }

   public void setInformationsTiers(String var1) {
      this.informationsTiers = var1;
   }

   public long getInpIdTiersEnCours() {
      return this.inpIdTiersEnCours;
   }

   public void setInpIdTiersEnCours(long var1) {
      this.inpIdTiersEnCours = var1;
   }

   public String getInpNomDestinataire() {
      return this.inpNomDestinataire;
   }

   public void setInpNomDestinataire(String var1) {
      this.inpNomDestinataire = var1;
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

   public String getVerrouDepotUser() {
      return this.verrouDepotUser;
   }

   public void setVerrouDepotUser(String var1) {
      this.verrouDepotUser = var1;
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

   public String getInpPdv() {
      return this.inpPdv;
   }

   public void setInpPdv(String var1) {
      this.inpPdv = var1;
   }

   public String getInpRegion() {
      return this.inpRegion;
   }

   public void setInpRegion(String var1) {
      this.inpRegion = var1;
   }

   public String getInpSecteur() {
      return this.inpSecteur;
   }

   public void setInpSecteur(String var1) {
      this.inpSecteur = var1;
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

   public String getVar_tc_libelle() {
      return this.var_tc_libelle;
   }

   public void setVar_tc_libelle(String var1) {
      this.var_tc_libelle = var1;
   }

   public float getVar_tc_taux() {
      return this.var_tc_taux;
   }

   public void setVar_tc_taux(float var1) {
      this.var_tc_taux = var1;
   }

   public int getVar_tc_type() {
      return this.var_tc_type;
   }

   public void setVar_tc_type(int var1) {
      this.var_tc_type = var1;
   }

   public boolean isVar_tc_calcul() {
      return this.var_tc_calcul;
   }

   public void setVar_tc_calcul(boolean var1) {
      this.var_tc_calcul = var1;
   }
}
