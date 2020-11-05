package com.epegase.forms.immobilier;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.AppelCharge;
import com.epegase.systeme.classe.Bien;
import com.epegase.systeme.classe.BienBudgetEntete;
import com.epegase.systeme.classe.BonEncaissementVente;
import com.epegase.systeme.classe.CaissesCommerciales;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesCaisse;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.Reglements;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.TaxesVentes;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.EtatDocument;
import com.epegase.systeme.control.ObjetGraph;
import com.epegase.systeme.dao.AppelChargeDao;
import com.epegase.systeme.dao.BienBudgetEnteteDao;
import com.epegase.systeme.dao.BienDao;
import com.epegase.systeme.dao.BonEncaissementVenteDao;
import com.epegase.systeme.dao.CaissesCommercialesDao;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.ContactDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.ExercicesCaisseDao;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.HabilitationDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.ReglementsDao;
import com.epegase.systeme.dao.TaxesVentesDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilParapheur;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.LireLesoptionsCaisses;
import com.epegase.systeme.xml.ObjetLigneOnglet;
import com.epegase.systeme.xml.OptionCaisses;
import com.epegase.systeme.xml.OptionVentes;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
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

public class FormAppelChargeImmobilier implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private FormRecherche formRecherche;
   private int var_action = 0;
   private int var_memo_action = 0;
   private String pageIndex;
   private boolean var_aff_action = false;
   private int nature;
   private int categorie;
   private UsersChrono usersChrono;
   private UsersChronoDao usersChronoDao;
   private List mesOnglets;
   private OptionVentes optionsVentes;
   private ExercicesVentes exercicesVentes;
   private ExercicesVentes lastExoVentes;
   private EspionDao espionDao;
   private int var_timbre;
   private int var_nb_max = 100;
   private UtilDate utilDate = new UtilDate();
   private UtilNombre utilNombre = new UtilNombre();
   private CalculChrono calculChrono;
   private boolean var_acc_villa;
   private boolean var_acc_appartement;
   private boolean var_acc_immeuble;
   private boolean var_acc_bureau;
   private boolean var_acc_commerce;
   private boolean var_acc_garage;
   private boolean var_acc_hanger;
   private boolean var_acc_usine;
   private boolean var_acc_box;
   private boolean var_acc_terrain;
   private boolean var_acc_chambre;
   private boolean showModalPanelTransfert = false;
   private int var_imput_cat;
   private boolean showModalPanelImput = false;
   private String var_imput_serie;
   private Date var_date;
   private String var_heure;
   private String var_minute;
   private String var_seconde;
   private transient DataModel datamodelAdc = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private List listAdc = new ArrayList();
   private AppelCharge appelCharge = new AppelCharge();
   private AppelChargeDao appelChargeDao;
   private Bien bien;
   private BienDao bienDao;
   private boolean visibiliteBton = false;
   private Tiers proprietaire;
   private TiersDao tiersDao;
   private boolean var_aff_detail_proprietaire = false;
   private boolean var_aff_detail_local = false;
   private boolean var_valide_doc = false;
   private boolean showModalPanelValidationDocument = false;
   private boolean visibleOnglet = false;
   private Users responsable;
   private long var_nom_commercial;
   private List mesSerieUserItem;
   private List mesUsersItem = new ArrayList();
   private long var_nom_responsable;
   private ContactDao contactDao;
   private List mesContactItem = new ArrayList();
   private long var_nom_contact;
   private List mesCaissesItems;
   private BonEncaissementVente bonEncaissementVente;
   private BonEncaissementVenteDao bonEncaissementVenteDao;
   private double var_tot_bon_encaissement;
   private boolean var_affiche_dollar = false;
   private boolean var_affiche_be = false;
   private boolean var_affiche_valide = false;
   private double montantElmTotBonEnc;
   private double totalPayerTimbre;
   private ReglementsDao reglementsDao;
   private boolean afficheRecu;
   private transient DataModel datamodelRecu;
   private boolean var_verouxModReg;
   private boolean var_affichMontant;
   private String var_inputCaisse;
   private double var_netAPayer;
   private boolean showModalPanelPaye = false;
   private boolean showModalPanelPayeMultiple = false;
   private String var_nom_client;
   private String var_num_facture;
   private String var_montant;
   private boolean showModalPanelReglement = false;
   private List listFactureSelectionne;
   private Reglements reglements;
   private Reglements memoReglements;
   private boolean var_affiche_banque = false;
   private String var_type_reg;
   private int varTypeReg;
   private String var_objet;
   private String var_banque_tireur;
   private String var_num_cheque;
   private List mesModesleRecus;
   private String nomRepMod;
   private double val_timbre;
   private double var_ecart_reglement;
   private String var_banque_destination;
   private boolean var_affiche_banque_destination = false;
   private List mesBanquesItems;
   private CaissesCommerciales caissesCommerciales;
   private CaissesCommercialesDao caissesCommercialesDao;
   private boolean repartitionManuelle;
   private double totManuel;
   private double ecartManuel;
   private List lstReg;
   private boolean showModalPanelTrf = false;
   private transient DataModel datamodelTransfert;
   private List documentDetailTrf;
   private Date var_date_trf = null;
   private int var_type_trf;
   private String var_mode_trf;
   private String var_serie_trf;
   private String var_modele_trf;
   private boolean var_aff_trf = false;
   private List mesSeriesTrfItems;
   private List modeleTrfItems;
   private List documentTrfItems;
   private boolean valideLissage;
   private double var_montant_trf;
   private Date var_date_periode;
   private String var_lib_periode;
   private Habilitation habilitation;
   private UtilParapheur utilParapheur;
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
   private boolean affichagePump = false;
   private boolean existParapheur = false;
   private boolean var_exo_tva;
   private float taux_tva;
   private double montantTtc = 0.0D;
   private double montantSolde = 0.0D;
   private double montantReglement = 0.0D;
   private double montantTtcElmt = 0.0D;
   private double montantSoldeElmt = 0.0D;
   private double montantReglementElmt = 0.0D;
   private int var_nb_ligne = 0;
   private String inpSerie = "100";
   private int inpEtat = 1;
   private String periode = "100";
   private String inpNum = "";
   private String inpCat = "";
   private String inpClient = "";
   private String inpResponsable = "";
   private String inpDossier = "100";
   private Date inpDu = null;
   private Date inpAu = null;
   private boolean var_more_search = false;
   private List mesBiensRecItems;
   private transient DataModel dataModelEcriture;
   private boolean showModalPanelPrint = false;
   private String montant_lettre;
   private String devisePrint;
   private float tauxPrint;
   private String nomModeleDocument;
   private List documentImpressionItems;
   private String format;
   private Reglements reglementsRecu;
   private boolean showModalPanelImpressionRecu = false;
   private boolean visibleRecu = false;
   private double var_tot_reglement;
   private double var_solde;
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
   private String modeleFacture;
   private List mesImpressionsFacturesItems;
   private List mesPeriodesItems;
   private int choixSuppression;
   private boolean showModalPanelSuppression = false;
   private List mesBiensItems;
   private List mesBudgetsItems;
   private BienBudgetEnteteDao bienBudgetEnteteDao;
   private BienBudgetEntete bienBudgetEntete;
   private List lesAppartements;
   private transient DataModel dataModelAppartements;
   private double totalMillieme;
   private double totalBudget;
   private double totalBudgetTrim;
   private double totalBudgetTrimReliquat;
   private double puMillieme;
   private double puMilliemeReliquat;
   private TaxesVentesDao taxesVentesDao;
   private String periodeCode;
   private int var_mode;
   private long var_idImmeuble;
   private long var_idBudget;
   private String var_serie;
   private String var_modeleImp;
   private String var_codeTva;
   private boolean showModalPanelAnnuler = false;
   private transient DataModel datamodelTiers;
   private List lesTiers;
   private Tiers tiers;
   private boolean visibiliteFacture = false;
   private boolean visibiliteRecu = false;
   private double totFactureGlobal = 0.0D;
   private double totReglementGlobal = 0.0D;
   private double totTimbreGlobal = 0.0D;
   private double soldeGlobal = 0.0D;
   private transient DataModel datamodelFacture;
   private List listFacture;

   public FormAppelChargeImmobilier() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.datamodelRecu = new ListDataModel();
      this.dataModelEcriture = new ListDataModel();
      this.utilParapheur = new UtilParapheur(this.utilInitHibernate, this.structureLog, this.baseLog, this.usersLog);
      this.mesImpressionsFacturesItems = new ArrayList();
      this.mesPeriodesItems = new ArrayList();
      this.mesBiensItems = new ArrayList();
      this.mesBudgetsItems = new ArrayList();
      this.lesAppartements = new ArrayList();
      this.dataModelAppartements = new ListDataModel();
      this.mesBiensRecItems = new ArrayList();
      this.lstReg = new ArrayList();
      this.datamodelTransfert = new ListDataModel();
      this.mesSeriesTrfItems = new ArrayList();
      this.modeleTrfItems = new ArrayList();
      this.documentDetailTrf = new ArrayList();
      this.documentTrfItems = new ArrayList();
      this.listFactureSelectionne = new ArrayList();
      this.mesModesleRecus = new ArrayList();
      this.mesBanquesItems = new ArrayList();
      this.mesCaissesItems = new ArrayList();
      this.documentImpressionItems = new ArrayList();
      this.datamodelTiers = new ListDataModel();
      this.lesTiers = new ArrayList();
      this.tiers = new Tiers();
      this.datamodelFacture = new ListDataModel();
      this.listFacture = new ArrayList();
   }

   public void InstancesDaoUtilses() {
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.appelChargeDao = new AppelChargeDao(this.baseLog, this.utilInitHibernate);
      this.bienDao = new BienDao(this.baseLog, this.utilInitHibernate);
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      this.caissesCommercialesDao = new CaissesCommercialesDao(this.baseLog, this.utilInitHibernate);
      this.bienBudgetEnteteDao = new BienBudgetEnteteDao(this.baseLog, this.utilInitHibernate);
      this.taxesVentesDao = new TaxesVentesDao(this.baseLog, this.utilInitHibernate);
      this.reglementsDao = new ReglementsDao(this.baseLog, this.utilInitHibernate);
      this.bonEncaissementVenteDao = new BonEncaissementVenteDao(this.baseLog, this.utilInitHibernate);
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

      this.periode = this.optionsVentes.getAffichInGlobViewFAC();
      this.usersChrono = new UsersChrono();
      this.usersChrono = this.usersChronoDao.selectUnique("", this.nature, this.usersLog, var1);
      if (this.habilitation != null) {
         this.existParapheur = true;
      } else {
         this.existParapheur = false;
      }

      this.taux_tva = 0.0F;
      new TaxesVentes();
      if (this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
         TaxesVentes var2 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var1);
         if (var2 != null) {
            this.taux_tva = var2.getTaxvteTaux();
         }
      }

      this.mesBiensRecItems.clear();
      new ArrayList();
      List var3 = this.bienDao.chargeBien(1, 9, var1);
      if (var3.size() != 0) {
         for(int var4 = 0; var4 < var3.size(); ++var4) {
            if (((Bien)var3.get(var4)).getBieType() == 2) {
               this.mesBiensRecItems.add(new SelectItem(((Bien)var3.get(var4)).getBieNum() + ":" + ((Bien)var3.get(var4)).getBieNom()));
            }
         }
      }

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

   public void moreSearch() throws ParseException {
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
         this.inpResponsable = "";
      }

   }

   public void executerRequete() throws IOException, HibernateException, NamingException, ParseException {
      this.chargeListeDetail((Session)null);
   }

   public void chargeListeDetail(Session var1) throws HibernateException, NamingException, ParseException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
      }

      this.listAdc.clear();
      this.listFacture.clear();
      this.lesTiers.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      double var3 = 0.0D;
      double var5 = 0.0D;
      double var7 = 0.0D;
      double var9 = 0.0D;
      this.var_nb_ligne = 0;
      String var11 = "";
      String var12 = "";
      if (this.var_more_search) {
         if (this.inpDu != null) {
            var11 = this.utilDate.dateToStringSQLLight(this.inpDu);
         }

         if (this.inpAu != null) {
            var12 = this.utilDate.dateToStringSQLLight(this.inpAu);
         }
      } else {
         var11 = null;
         var12 = null;
      }

      if (this.inpNum != null && !this.inpNum.isEmpty()) {
         this.inpEtat = 100;
      }

      if (this.inpEtat != 50) {
         String var13 = "";
         if (this.inpClient != null && !this.inpClient.isEmpty() && this.inpClient.contains(":")) {
            String[] var14 = this.inpClient.split(":");
            var13 = var14[0];
         }

         this.listAdc = this.appelChargeDao.recherche(var1, this.exercicesVentes.getExevteId(), this.getInpNum(), var13, this.getInpEtat(), this.getInpSerie(), "100", this.getPeriode(), "100", this.usersLog.getUsrid(), this.usersLog.getUsrVentes(), "", this.getInpResponsable(), "", "100", var11, var12);
      }

      if (this.listAdc.size() > 0) {
         new AppelCharge();

         for(int var20 = 0; var20 < this.listAdc.size(); ++var20) {
            AppelCharge var19 = (AppelCharge)this.listAdc.get(var20);
            var3 += var19.getAppchaTotTtc();
            var5 += var19.getAppchaTotReglement();
            var7 += var19.getAppchaTotHt();
            var9 += var19.getAppchaTotTva();
            long var15 = var19.getAppchaIdTiers();
            if (this.lesTiers.size() == 0) {
               this.tiers = this.tiersDao.selectTierD(var15, var1);
               if (this.tiers != null) {
                  this.lesTiers.add(this.tiers);
               }
            } else {
               boolean var17 = false;

               for(int var18 = 0; var18 < this.lesTiers.size(); ++var18) {
                  if (((Tiers)this.lesTiers.get(var18)).getTieid() == var15) {
                     var17 = true;
                     break;
                  }
               }

               if (!var17) {
                  this.tiers = this.tiersDao.selectTierD(var15, var1);
                  if (this.tiers != null) {
                     this.lesTiers.add(this.tiers);
                  }
               }
            }
         }

         this.var_nb_ligne = this.listAdc.size();
      }

      this.datamodelAdc.setWrappedData(this.listAdc);
      this.datamodelTiers.setWrappedData(this.lesTiers);
      this.datamodelFacture.setWrappedData(this.listFacture);
      this.montantTtc = var3;
      this.montantReglement = var5;
      this.montantSolde = var3 - var5;
      this.visibiliteBton = false;
      this.totFactureGlobal = 0.0D;
      this.totReglementGlobal = 0.0D;
      this.soldeGlobal = 0.0D;
      this.totTimbreGlobal = 0.0D;
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

   }

   public void selectionAppelCharge() throws HibernateException, NamingException, ParseException {
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
            this.appelCharge = (AppelCharge)var1.get(0);
            this.var_date = this.appelCharge.getAppchaDate();
            if (this.appelCharge.getAppchaDate().getHours() <= 9) {
               this.var_heure = "0" + this.appelCharge.getAppchaDate().getHours();
            } else {
               this.var_heure = "" + this.appelCharge.getAppchaDate().getHours();
            }

            if (this.appelCharge.getAppchaDate().getMinutes() <= 9) {
               this.var_minute = "0" + this.appelCharge.getAppchaDate().getMinutes();
            } else {
               this.var_minute = "" + this.appelCharge.getAppchaDate().getMinutes();
            }

            if (this.appelCharge.getAppchaDate().getSeconds() <= 9) {
               this.var_seconde = "0" + this.appelCharge.getAppchaDate().getSeconds();
            } else {
               this.var_seconde = "" + this.appelCharge.getAppchaDate().getSeconds();
            }

            Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
            this.bien = this.bienDao.logBienNum(this.appelCharge.getAppchaBien(), var6);
            this.chargerElementBase(var6);
            this.chargerProprietaire(var6);
            double var4 = this.chargerBonEncaissement(var6);
            this.chargerTaxes();
            if (this.mesContactItem == null || this.mesContactItem.size() == 0) {
               this.mesContactItem.add(new SelectItem(0, ""));
               this.var_nom_contact = 0L;
            }

            if (this.mesUsersItem == null || this.mesUsersItem.size() == 0) {
               this.mesUsersItem.add(new SelectItem(0, ""));
               this.var_nom_responsable = 0L;
            }

            this.var_mode = this.appelCharge.getAppchaMode();
            this.mesPeriodesItems.clear();
            if (this.appelCharge.getAppchaObject() != null && !this.appelCharge.getAppchaObject().isEmpty()) {
               if (this.appelCharge.getAppchaObject().contains("1er")) {
                  this.mesPeriodesItems.add(new SelectItem("1", "1er trimestre"));
                  this.periode = "1";
               } else if (this.appelCharge.getAppchaObject().contains("2eme")) {
                  this.mesPeriodesItems.add(new SelectItem("2", "2eme trimestre"));
                  this.periode = "2";
               } else if (this.appelCharge.getAppchaObject().contains("3eme")) {
                  this.mesPeriodesItems.add(new SelectItem("3", "3eme trimestre"));
                  this.periode = "3";
               } else if (this.appelCharge.getAppchaObject().contains("4eme")) {
                  this.mesPeriodesItems.add(new SelectItem("4", "4eme trimestre"));
                  this.periode = "4";
               } else {
                  this.periode = "0";
               }
            } else {
               this.periode = "0";
            }

            this.var_idImmeuble = this.appelCharge.getAppchaIdImmeuble();
            this.mesBudgetsItems.clear();
            this.mesBudgetsItems.add(new SelectItem(this.appelCharge.getAppchaIdBudget(), this.appelCharge.getAppchaBudget()));
            this.var_idBudget = this.appelCharge.getAppchaIdBudget();
            this.var_serie = this.appelCharge.getAppchaSerie();
            this.var_modeleImp = this.appelCharge.getAppchaModeleImp();
            this.var_codeTva = this.appelCharge.getAppchaCodeTva();
            this.totalBudget = this.appelCharge.getAppchaTotAnnuel();
            this.totalBudgetTrim = this.appelCharge.getAppchaTotBudget();
            this.totalBudgetTrimReliquat = this.appelCharge.getAppchaTotReliquat();
            this.totalMillieme = (double)this.appelCharge.getAppchaMlImmeuble();
            this.utilInitHibernate.closeSession();
            this.appelCharge.setAppchaTotReglement(var4);
            if (var4 >= this.appelCharge.getAppchaTotTtc() + this.appelCharge.getAppchaTotTimbre()) {
               this.appelCharge.setAppchaSolde(1);
            } else {
               this.appelCharge.setAppchaSolde(0);
            }

            this.appelCharge = this.appelChargeDao.modif(this.appelCharge);
            this.visibiliteBton = true;
         } else {
            this.visibiliteBton = false;
         }
      } else {
         this.visibiliteBton = false;
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.appelCharge != null) {
         if (this.appelCharge.getAppchaEtat() == 0) {
            this.modifAppelCharge();
         } else {
            this.consultAppelCharge();
         }
      }

   }

   public void chargerElementBase(Session var1) throws HibernateException, NamingException, ParseException {
      this.mesBiensItems.clear();
      new ArrayList();
      List var2 = this.bienDao.chargeBien(1, 9, var1);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            if (((Bien)var2.get(var3)).getBieType() == 2 && ((Bien)var2.get(var3)).getBieGestion() == 0) {
               this.mesBiensItems.add(new SelectItem(((Bien)var2.get(var3)).getBieId(), ((Bien)var2.get(var3)).getBieNum() + ":" + ((Bien)var2.get(var3)).getBieNom()));
            }
         }
      }

      this.chargerModeleFactures();
   }

   public void chargerProprietaire(Session var1) throws HibernateException, NamingException {
      this.lesAppartements.clear();
      new ArrayList();
      String var3 = " appchaMode=" + this.appelCharge.getAppchaMode() + " and appchaPeriode='" + this.appelCharge.getAppchaPeriode() + "'";
      List var2 = this.appelChargeDao.rechercheFactureRequete(var3, var1);
      if (var2.size() != 0) {
         new AppelCharge();
         new Bien();

         for(int var6 = 0; var6 < var2.size(); ++var6) {
            AppelCharge var4 = (AppelCharge)var2.get(var6);
            Bien var5 = new Bien();
            if (var4.getAppchaIdBien() != 0L) {
               var5 = this.bienDao.logBienId(var4.getAppchaIdBien(), var1);
               if (var5 != null) {
                  var5.setBieNomTiers(var5.getBieNomTiers());
               } else {
                  var5.setBieNomTiers(var4.getAppchaNomTiers());
               }
            } else {
               var5.setBieNomTiers(var4.getAppchaNomTiers());
            }

            var5.setPu(var4.getAppchaPu());
            var5.setPtHt(var4.getAppchaTotHt());
            var5.setPtTaxe(var4.getAppchaTotTva());
            var5.setPtTtc(var4.getAppchaTotTtc());
            this.lesAppartements.add(var5);
         }
      }

      this.dataModelAppartements.setWrappedData(this.lesAppartements);
   }

   public double chargerBonEncaissement(Session var1) throws HibernateException, NamingException {
      this.var_tot_bon_encaissement = 0.0D;
      new ArrayList();
      List var2 = this.bonEncaissementVenteDao.rechercheBeByDoc(this.appelCharge.getAppchaId(), this.nature, var1);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            if (((BonEncaissementVente)var2.get(var3)).getBonEtat() == 0) {
               this.var_tot_bon_encaissement += ((BonEncaissementVente)var2.get(var3)).getBonAPayer();
            }
         }
      }

      this.lstReg.clear();
      this.lstReg = this.reglementsDao.reglementDocument(this.appelCharge.getAppchaId(), this.nature, var1);
      if (this.lstReg.size() != 0) {
         String var9 = "";
         new Reglements();

         for(int var5 = 0; var5 < this.lstReg.size(); ++var5) {
            Reglements var4 = (Reglements)this.lstReg.get(var5);
            if (var9 != null && !var9.isEmpty()) {
               var9 = var9 + "," + var4.getRglNum();
            } else {
               var9 = var4.getRglNum();
            }
         }

         if (var9 != null && !var9.isEmpty()) {
            this.lstReg.clear();
            this.lstReg = this.reglementsDao.reglementDocumentByRecu(var9, this.nature, var1);
         }
      }

      double var10 = 0.0D;
      double var11 = 0.0D;
      this.afficheRecu = false;
      if (this.lstReg.size() != 0) {
         this.afficheRecu = true;
         new Reglements();

         for(int var8 = 0; var8 < this.lstReg.size(); ++var8) {
            Reglements var7 = (Reglements)this.lstReg.get(var8);
            this.var_tot_bon_encaissement = this.var_tot_bon_encaissement + var7.getRglRecette() - var7.getRglDepense();
            var11 += ((Reglements)this.lstReg.get(var8)).getRglTimbre();
            var10 += ((Reglements)this.lstReg.get(var8)).getRglRecette();
         }
      }

      this.var_tot_reglement = var10 + var11;
      this.var_solde = this.appelCharge.getVar_reliquat();
      this.datamodelRecu.setWrappedData(this.lstReg);
      if (this.appelCharge.getVar_reliquat() > 0.0D) {
         if (this.usersLog.getUsrFactureCaisse() == 1) {
            this.var_affiche_be = true;
            this.var_affiche_dollar = false;
         } else if (this.usersLog.getUsrFactureCaisse() == 2) {
            this.var_affiche_be = false;
            this.var_affiche_dollar = true;
         } else if (this.usersLog.getUsrFactureCaisse() == 3) {
            this.var_affiche_be = true;
            this.var_affiche_dollar = true;
         } else {
            this.var_affiche_be = false;
            this.var_affiche_dollar = false;
         }
      } else {
         this.var_affiche_be = false;
         this.var_affiche_dollar = false;
      }

      return var10;
   }

   public void chargerTaxes() {
      if (this.appelCharge.getAppchaExoTva() == 1) {
         this.var_exo_tva = true;
         this.appelCharge.setAppchaTauxTva(0.0D);
      } else {
         this.var_exo_tva = false;
         this.appelCharge.setAppchaTauxTva((double)this.taux_tva);
      }

   }

   public void modifAppelCharge() {
      if (this.appelCharge != null) {
         this.var_action = 21;
         this.var_aff_detail_proprietaire = true;
         this.var_aff_action = true;
         this.visibleOnglet = true;
         this.var_memo_action = this.var_action;
      }

   }

   public void consultAppelCharge() {
      if (this.appelCharge != null) {
         this.var_action = 21;
         this.var_aff_detail_proprietaire = true;
         this.var_aff_action = true;
         this.visibleOnglet = true;
         this.var_memo_action = this.var_action;
      }

   }

   public void valideAppelCharge() throws HibernateException, NamingException {
      if (this.appelCharge != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.appelCharge.getAppchaEtat() == 0 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
               this.appelCharge.setAppchaEtat(1);
               this.appelCharge = this.appelChargeDao.modif(this.appelCharge, var1);
               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Validation manuelle appel charges (I.) N° " + this.appelCharge.getAppchaNum() + " du " + this.utilDate.dateToStringSQLLight(this.appelCharge.getAppchaDate()));
               this.espionDao.mAJEspion(var3);
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

   public void deValideAppelCharge() throws HibernateException, NamingException {
      if (this.appelCharge != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.appelCharge.getAppchaEtat() == 1 && this.appelCharge.getAppchaTotReglement() == 0.0D && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
               this.appelCharge.setAppchaEtat(0);
               this.appelCharge.setAppchaDateImp((Date)null);
               this.appelCharge = this.appelChargeDao.modif(this.appelCharge, var1);
               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Dévalidation manuelle appel charges (I.) N° " + this.appelCharge.getAppchaNum() + " du " + this.utilDate.dateToStringSQLLight(this.appelCharge.getAppchaDate()));
               this.espionDao.mAJEspion(var3);
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

   public void valideTout() throws HibernateException, NamingException {
      if (this.listFacture.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
               for(int var3 = 0; var3 < this.listFacture.size(); ++var3) {
                  this.appelCharge = (AppelCharge)this.listFacture.get(var3);
                  if (this.appelCharge.getAppchaEtat() == 0) {
                     this.appelCharge.setAppchaEtat(1);
                     this.appelCharge = this.appelChargeDao.modif(this.appelCharge, var1);
                  }
               }

               this.datamodelFacture.setWrappedData(this.listFacture);
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

      this.visibiliteBton = false;
   }

   public void deValideTout() throws HibernateException, NamingException {
      if (this.listFacture.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.habilitation == null) {
               for(int var3 = 0; var3 < this.listFacture.size(); ++var3) {
                  this.appelCharge = (AppelCharge)this.listFacture.get(var3);
                  if (this.appelCharge.getAppchaEtat() == 1 && this.appelCharge.getAppchaTotReglement() == 0.0D) {
                     this.appelCharge.setAppchaEtat(0);
                     this.appelCharge.setAppchaDateImp((Date)null);
                     this.appelCharge = this.appelChargeDao.modif(this.appelCharge, var1);
                  }
               }

               this.datamodelFacture.setWrappedData(this.listFacture);
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

      this.visibiliteBton = false;
   }

   public void supprimerAppelCharge() {
      this.choixSuppression = 0;
      this.showModalPanelSuppression = true;
   }

   public void validerSupprimer() throws HibernateException, NamingException {
      if (this.appelCharge != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.choixSuppression == 1) {
               String var13 = this.appelCharge.getAppchaNum();
               this.appelChargeDao.modif(this.appelCharge, var1);
               this.listFacture.remove(this.appelCharge);
               this.datamodelFacture.setWrappedData(this.listFacture);
               Espion var14 = new Espion();
               var14.setUsers(this.usersLog);
               var14.setEsptype(0);
               var14.setEspdtecreat(new Date());
               var14.setEspaction("Suppression Facture N° " + var13);
               this.espionDao.mAJEspion(var14, var1);
            } else if (this.choixSuppression == 2) {
               boolean var3 = false;
               if (this.listFacture.size() != 0) {
                  String var4 = this.utilDate.dateToPeriodeFr(((AppelCharge)this.listFacture.get(0)).getAppchaDateDebut());
                  String var5 = null;
                  new AppelCharge();

                  for(int var7 = 0; var7 < this.listFacture.size(); ++var7) {
                     AppelCharge var6 = (AppelCharge)this.listFacture.get(var7);
                     if (var6.getAppchaTotReglement() == 0.0D) {
                        var5 = this.utilDate.dateToPeriodeFr(var6.getAppchaDateFin());
                        this.appelChargeDao.modif(var6, var1);
                        this.listFacture.remove(var6);
                        this.datamodelFacture.setWrappedData(this.listFacture);
                        var3 = true;
                     }
                  }

                  if (var3) {
                     Espion var15 = new Espion();
                     var15.setUsers(this.usersLog);
                     var15.setEsptype(0);
                     var15.setEspdtecreat(new Date());
                     var15.setEspaction("Suppression Facture du " + var4 + " au " + var5);
                     this.espionDao.mAJEspion(var15, var1);
                  }
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

      this.showModalPanelSuppression = false;
   }

   public void annulerSupprimer() {
      this.showModalPanelSuppression = false;
   }

   public void annulerFacture() {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.visibleOnglet = false;
      this.visibiliteBton = false;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public Date CalculDateEcheance() throws ParseException {
      Date var1 = this.utilDate.CalculDateEcheance(this.appelCharge.getAppchaDate(), this.appelCharge.getAppchaTypeReg(), this.appelCharge.getAppchaNbJourReg(), this.appelCharge.getAppchaArrondiReg());
      return var1;
   }

   public void annulerDocument() {
      if (this.appelCharge != null) {
         this.appelCharge.setAppchaDateAnnule(new Date());
         this.appelCharge.setAppchaEtat(3);
         this.showModalPanelAnnuler = true;
      }

   }

   public void annuleAnnulation() {
      this.showModalPanelAnnuler = false;
   }

   public void miseajourAnnuler() throws HibernateException, NamingException {
      if (this.appelCharge != null) {
         if (this.appelCharge.getAppchaDateAnnule() == null) {
            this.appelCharge.setAppchaDateAnnule(new Date());
         }

         if (this.lstReg.size() != 0) {
            for(int var1 = 0; var1 < this.lstReg.size(); ++var1) {
               this.reglements = (Reglements)this.lstReg.get(var1);
               if (this.reglements.getRglRecette() > 0.0D) {
                  this.reglements.setRglDateReg(new Date());
                  String var2 = "";
                  if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
                     var2 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
                  } else {
                     var2 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
                  }

                  String var3 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
                  this.reglements.setRglPeriode(var2 + ":" + var3);
                  this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
                  String var4 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
                  this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var4);
                  this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
                  this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var4);
                  this.reglementsDao.avoirReg(this.reglements, (Session)null);
               }
            }
         }

         this.appelCharge = this.appelChargeDao.modif(this.appelCharge);
         Espion var5 = new Espion();
         var5.setUsers(this.usersLog);
         var5.setEsptype(0);
         var5.setEspdtecreat(new Date());
         var5.setEspaction("Annulation appel de charge N° " + this.appelCharge.getAppchaNum() + " pour " + this.appelCharge.getAppchaMotifAnnule());
         this.espionDao.mAJEspion(var5);
         this.listFacture.remove(this.appelCharge);
         this.datamodelFacture.setWrappedData(this.listFacture);
      }

      this.showModalPanelAnnuler = false;
      this.visibiliteBton = false;
   }

   public void reactiverDocument() throws HibernateException, NamingException {
      if (this.appelCharge != null) {
         this.appelCharge.setAppchaEtat(0);
         this.appelCharge.setAppchaDateAnnule((Date)null);
         this.appelCharge.setAppchaMotifAnnule("");
         this.appelCharge = this.appelChargeDao.modif(this.appelCharge);
         if (this.lstReg.size() != 0) {
            for(int var1 = 0; var1 < this.lstReg.size(); ++var1) {
               this.reglements = (Reglements)this.lstReg.get(var1);
               if (this.reglements.getRglRecette() < 0.0D) {
                  this.reglements.setRglDateReg(new Date());
                  String var2 = "";
                  if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
                     var2 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
                  } else {
                     var2 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
                  }

                  String var3 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
                  this.reglements.setRglPeriode(var2 + ":" + var3);
                  this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
                  String var4 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
                  this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var4);
                  this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
                  this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var4);
                  this.reglementsDao.avoirReg(this.reglements, (Session)null);
               }
            }
         }

         Espion var5 = new Espion();
         var5.setUsers(this.usersLog);
         var5.setEsptype(0);
         var5.setEspdtecreat(new Date());
         var5.setEspaction("Réactivation appel de charge N° " + this.appelCharge.getAppchaNum());
         this.espionDao.mAJEspion(var5);
      }

   }

   public void ajoutAppelCharge() throws HibernateException, NamingException, ParseException {
      this.bien = new Bien();
      this.appelCharge = new AppelCharge();
      this.proprietaire = new Tiers();
      this.appelCharge.setAppchaDate(new Date());
      this.var_aff_detail_proprietaire = false;
      this.var_aff_action = false;
      this.visibleOnglet = false;
      this.var_affiche_dollar = false;
      this.mesBudgetsItems.clear();
      this.chargerElementBase((Session)null);
      this.chargerPeriodes();
      this.lesAppartements.clear();
      this.dataModelAppartements.setWrappedData(this.lesAppartements);
      this.var_mode = 0;
      this.periode = "0";
      this.var_idImmeuble = 0L;
      this.var_idBudget = 0L;
      this.var_codeTva = "";
      this.totalBudget = 0.0D;
      this.totalBudgetTrim = 0.0D;
      this.totalBudgetTrimReliquat = 0.0D;
      this.totalMillieme = 0.0D;
      this.var_action = 1;
      this.var_memo_action = this.var_action;
   }

   public void selectionMode() {
      this.mesBudgetsItems.clear();
      this.lesAppartements.clear();
      this.dataModelAppartements.setWrappedData(this.lesAppartements);
      this.periode = "0";
      this.var_idImmeuble = 0L;
      this.var_idBudget = 0L;
      this.var_codeTva = "";
      this.totalBudget = 0.0D;
      this.totalBudgetTrim = 0.0D;
      this.totalBudgetTrimReliquat = 0.0D;
      this.totalMillieme = 0.0D;
      if (this.var_mode == 0) {
         this.var_date_periode = null;
         this.var_lib_periode = "";
      } else {
         this.var_date_periode = new Date();
         this.var_lib_periode = "";
         if (this.var_mode == 1) {
            this.periodeCode = "EXP" + (this.var_date_periode.getMonth() + 1) + ":" + (this.var_date_periode.getYear() + 1900);
         } else if (this.var_mode == 2) {
            this.periodeCode = "FDR" + (this.var_date_periode.getMonth() + 1) + ":" + (this.var_date_periode.getYear() + 1900);
         }
      }

   }

   public void annulerGeneAuto() {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
   }

   public void validerFacturation() throws HibernateException, NamingException, ParseException, IOException {
      if (this.periode != null && !this.periode.isEmpty()) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            double var3 = 0.0D;
            if (this.lesAppartements.size() != 0) {
               this.bienBudgetEntete = this.bienBudgetEnteteDao.pourParapheur(this.var_idBudget, var1);
               var3 = this.bienBudgetEntete.getBiebudentHonoraire();
               this.bien = this.bienDao.logBienId(this.var_idImmeuble, var1);
               this.calculeDates();
               new Bien();
               this.tiers = new Tiers();

               for(int var6 = 0; var6 < this.lesAppartements.size(); ++var6) {
                  Bien var5 = (Bien)this.lesAppartements.get(var6);
                  this.tiers = var5.getTiers();
                  if (this.tiers == null) {
                     this.tiers = new Tiers();
                  }

                  boolean var7 = false;
                  String var8 = "";
                  String var9 = "";
                  if (this.var_mode == 1) {
                     if (this.var_lib_periode == null || this.var_lib_periode.isEmpty()) {
                        this.var_lib_periode = "charges exceptionnelles";
                     }

                     if (this.var_date_periode.getMonth() + 1 <= 9) {
                        var9 = "0" + (this.var_date_periode.getMonth() + 1);
                     } else {
                        var9 = "" + (this.var_date_periode.getMonth() + 1);
                     }

                     this.periodeCode = "EXP:" + var9 + ":" + (this.var_date_periode.getYear() + 1900);
                  } else if (this.var_mode == 2) {
                     if (this.var_lib_periode == null || this.var_lib_periode.isEmpty()) {
                        this.var_lib_periode = "Fonds de roulement";
                     }

                     if (this.var_date_periode.getMonth() + 1 <= 9) {
                        var9 = "0" + (this.var_date_periode.getMonth() + 1);
                     } else {
                        var9 = "" + (this.var_date_periode.getMonth() + 1);
                     }

                     this.periodeCode = "FDR:" + var9 + ":" + (this.var_date_periode.getYear() + 1900);
                  }

                  this.appelCharge = this.appelChargeDao.pourParapheur(this.bien.getBieId(), this.tiers.getTieid(), this.periodeCode, var1);
                  if (this.appelCharge != null) {
                     if (this.appelCharge.getAppchaEtat() == 0) {
                        var8 = this.appelCharge.getAppchaNum();
                        this.appelChargeDao.delete(this.appelCharge, var1);
                        var7 = true;
                     } else {
                        var7 = false;
                     }
                  } else {
                     var7 = true;
                  }

                  if (var7) {
                     this.appelCharge = new AppelCharge();
                     if (this.tiers != null) {
                        this.proprietaire = this.tiersDao.selectTierD(this.tiers.getTieid(), var1);
                        if (this.proprietaire != null) {
                           this.appelCharge.setAppchaArrondiReg(this.proprietaire.getTienbarrondi());
                           this.appelCharge.setAppchaConditionReg(this.proprietaire.getTieconditionreg());
                           this.appelCharge.setAppchaIdTiers(this.proprietaire.getTieid());
                           this.appelCharge.setAppchaNbJourReg(this.proprietaire.getTienbecheance());
                           this.appelCharge.setAppchaTypeReg(this.proprietaire.getTietypereg());
                           this.appelCharge.setAppchaJournalReg(this.proprietaire.getTiejournalreg());
                           this.appelCharge.setAppchaModeReg(this.proprietaire.getTiemodereg());
                           this.appelCharge.setAppchaDateEcheReg(this.CalculDateEcheance());
                           this.appelCharge.setAppchaCivilTiers(this.proprietaire.getTiecivilite());
                           this.appelCharge.setAppchaNomTiers(this.proprietaire.getPatronymeLight());
                           this.appelCharge.setAppchaBanque((String)null);
                           this.appelCharge.setAppchaExoTva(this.proprietaire.getTieexotva());
                           this.appelCharge.setAppchaCivilContact((String)null);
                           this.appelCharge.setAppchaIdContact(0L);
                           this.appelCharge.setAppchaNomContact((String)null);
                        }
                     } else {
                        this.appelCharge.setAppchaArrondiReg(0);
                        this.appelCharge.setAppchaConditionReg((String)null);
                        this.appelCharge.setAppchaIdTiers(0L);
                        this.appelCharge.setAppchaNbJourReg(0);
                        this.appelCharge.setAppchaTypeReg(0);
                        this.appelCharge.setAppchaJournalReg((String)null);
                        this.appelCharge.setAppchaModeReg((String)null);
                        this.appelCharge.setAppchaDateEcheReg((Date)null);
                        this.appelCharge.setAppchaCivilTiers(var5.getBieCivilTiers());
                        this.appelCharge.setAppchaNomTiers(var5.getBieNomTiers());
                        this.appelCharge.setAppchaBanque((String)null);
                        this.appelCharge.setAppchaExoTva(0);
                        this.appelCharge.setAppchaCivilContact((String)null);
                        this.appelCharge.setAppchaIdContact(0L);
                        this.appelCharge.setAppchaNomContact((String)null);
                     }

                     if (this.appelCharge.getAppchaId() == 0L) {
                        if (this.bienBudgetEntete != null) {
                           this.appelCharge.setAppchaIdBudget(this.var_idBudget);
                           this.appelCharge.setAppchaBudget(this.bienBudgetEntete.getBiebudentNum());
                           this.appelCharge.setAppchaAnneeBudget("" + this.bienBudgetEntete.getBiebudentAnnee());
                           this.appelCharge.setAppchaTotAnnuel(this.totalBudget);
                           this.appelCharge.setAppchaTotBudget(this.totalBudgetTrim);
                           this.appelCharge.setAppchaTotReliquat(this.totalBudgetTrimReliquat);
                        } else {
                           this.appelCharge.setAppchaIdBudget(0L);
                           this.appelCharge.setAppchaBudget((String)null);
                           this.appelCharge.setAppchaAnneeBudget((String)null);
                           this.appelCharge.setAppchaTotAnnuel(0.0D);
                           this.appelCharge.setAppchaTotBudget(0.0D);
                           this.appelCharge.setAppchaTotReliquat(0.0D);
                        }

                        if (this.bien != null) {
                           this.appelCharge.setAppchaImmeuble(this.bien.getBieNum());
                           this.appelCharge.setAppchaIdImmeuble(this.var_idImmeuble);
                           this.appelCharge.setAppchaMlImmeuble((int)this.totalMillieme);
                        } else {
                           this.appelCharge.setAppchaImmeuble((String)null);
                           this.appelCharge.setAppchaIdImmeuble(0L);
                           this.appelCharge.setAppchaMlImmeuble(0);
                        }

                        this.appelCharge.setAppchaIdBien(var5.getBieId());
                        this.appelCharge.setAppchaMlBien(var5.getBieMillieme());
                        this.appelCharge.setAppchaBien(var5.getBieNum());
                        this.appelCharge.setAppchaObservation(var5.getNumlot());
                        this.appelCharge.setAppchaMode(this.var_mode);
                        this.appelCharge.setAppchaSerie(this.inpSerie);
                        this.appelCharge.setAppchaModeleImp(this.var_modeleImp);
                        if (this.var_mode == 0) {
                           this.appelCharge.setAppchaDateDebut(this.inpDu);
                           this.appelCharge.setAppchaDateFin(this.inpAu);
                           this.appelCharge.setAppchaDate(this.inpDu);
                           this.appelCharge.setAppchaObject(this.periode + " " + (this.inpDu.getYear() + 1900));
                        } else {
                           this.appelCharge.setAppchaDateDebut((Date)null);
                           this.appelCharge.setAppchaDateFin((Date)null);
                           this.appelCharge.setAppchaDate(this.var_date_periode);
                           this.appelCharge.setAppchaObject(this.var_lib_periode);
                        }

                        if (var8 != null && !var8.isEmpty()) {
                           this.appelCharge.setAppchaNum(var8);
                        } else if (this.appelCharge.getAppchaSerie() != null && !this.appelCharge.getAppchaSerie().equalsIgnoreCase("X") && !this.appelCharge.getAppchaSerie().isEmpty()) {
                           this.appelCharge.setAppchaNum(this.calculChrono.numCompose(this.appelCharge.getAppchaDate(), this.nature, this.appelCharge.getAppchaSerie(), var1));
                           boolean var21 = false;

                           label291:
                           while(true) {
                              while(true) {
                                 if (var21) {
                                    break label291;
                                 }

                                 new AppelCharge();
                                 AppelCharge var11 = this.appelChargeDao.pourParapheur(this.appelCharge.getAppchaNum(), this.appelCharge.getAppchaSerie(), var1);
                                 if (var11 != null) {
                                    long var12 = 100000000L * this.usersLog.getUsrid();

                                    for(long var14 = 0L; var14 < var12; ++var14) {
                                    }

                                    this.appelCharge.setAppchaNum(this.calculChrono.numCompose(this.appelCharge.getAppchaDate(), this.nature, this.appelCharge.getAppchaSerie(), var1));
                                    var21 = false;
                                 } else {
                                    var21 = true;
                                 }
                              }
                           }
                        } else {
                           long var10 = this.appelChargeDao.selectLastNum(var1);
                           this.appelCharge.setAppchaNum("" + var10);
                        }

                        this.appelCharge.setAppchaDateAnnule((Date)null);
                        this.appelCharge.setAppchaDateCreat(new Date());
                        this.appelCharge.setAppchaDateImp((Date)null);
                        this.appelCharge.setAppchaDateLastReg((Date)null);
                        this.appelCharge.setAppchaDateModif((Date)null);
                        this.appelCharge.setAppchaDateRelance((Date)null);
                        this.appelCharge.setAppchaDateTransfert((Date)null);
                        this.appelCharge.setAppchaDateTransforme((Date)null);
                        this.appelCharge.setAppchaDateValide((Date)null);
                        this.appelCharge.setAppchaDateValidite((Date)null);
                        this.appelCharge.setAppchaDateVisa((Date)null);
                        this.appelCharge.setAppchaDevise(this.structureLog.getStrdevise());
                        this.appelCharge.setAppchaEcheanceReliquat((Date)null);
                        this.appelCharge.setAppchaEtat(1);
                        this.appelCharge.setAppchaEtatVal(0);
                        this.appelCharge.setAppchaGele(0);
                        this.appelCharge.setAppchaIdCommercial(0L);
                        this.appelCharge.setAppchaIdCreateur(this.usersLog.getUsrid());
                        this.appelCharge.setAppchaIdResponsable(this.usersLog.getUsrid());
                        this.appelCharge.setAppchaIdModif(0L);
                        this.appelCharge.setAppchaMotifAnnule((String)null);
                        this.appelCharge.setAppchaMotifExo((String)null);
                        this.appelCharge.setAppchaNomCommercial((String)null);
                        this.appelCharge.setAppchaNomCreateur(this.usersLog.getUsrPatronyme());
                        this.appelCharge.setAppchaNomModif((String)null);
                        this.appelCharge.setAppchaNomResponsable(this.usersLog.getUsrPatronyme());
                        this.appelCharge.setAppchaNumAvoir((String)null);
                        this.appelCharge.setAppchaNumTrf((String)null);
                        this.appelCharge.setAppchaNumVisa((String)null);
                        this.appelCharge.setAppchaPeriode(this.periodeCode);
                        this.appelCharge.setAppchaRangeVisa((String)null);
                        this.appelCharge.setAppchaSolde(0);
                        this.appelCharge.setAppchaSource((String)null);
                        this.appelCharge.setAppchaTauxRemise(0.0D);
                        this.appelCharge.setAppchaTauxTva((double)this.taux_tva);
                        this.appelCharge.setAppchaCodeTva(this.var_codeTva);
                        this.appelCharge.setAppchaTotReglement(0.0D);
                        this.appelCharge.setAppchaTotRemise(0.0D);
                        this.appelCharge.setAppchaTotTc(0.0D);
                        this.appelCharge.setAppchaTotTimbre(0.0D);
                        this.appelCharge.setAppchaPu(this.utilNombre.myRoundDevise(var5.getPu(), this.structureLog.getStrdevise()));
                        this.appelCharge.setAppchaTotHt(this.utilNombre.myRoundDevise(var5.getPtHt(), this.structureLog.getStrdevise()));
                        this.appelCharge.setAppchaTotTva(this.utilNombre.myRoundDevise(var5.getPtTaxe(), this.structureLog.getStrdevise()));
                        this.appelCharge.setAppchaTotTtc(this.utilNombre.myRoundDevise(var5.getPtTtc(), this.structureLog.getStrdevise()));
                        this.appelCharge.setAppchaPuReliquat(this.utilNombre.myRoundDevise(var5.getPuReliquat(), this.structureLog.getStrdevise()));
                        this.appelCharge.setAppchaTotHtReliquat(this.utilNombre.myRoundDevise(var5.getPtHtReliquat(), this.structureLog.getStrdevise()));
                        this.appelCharge.setAppchaTotTvaReliquat(this.utilNombre.myRoundDevise(var5.getPtTaxeReliquat(), this.structureLog.getStrdevise()));
                        this.appelCharge.setAppchaTotTtcReliquat(this.utilNombre.myRoundDevise(var5.getPtTtcReliquat(), this.structureLog.getStrdevise()));
                        this.appelCharge.setAppchaTypeTransforme(0);
                        this.appelCharge.setAppchaContrat(var5.getBieId() + ":" + this.periodeCode);
                        this.appelCharge.setBien(this.bien);
                        this.appelCharge.setExerciceventes(this.exercicesVentes);
                        this.appelCharge.setUsers(this.usersLog);
                        this.appelCharge = this.appelChargeDao.insert(this.appelCharge, var1);
                     } else {
                        this.appelCharge = this.appelChargeDao.modif(this.appelCharge, var1);
                     }
                  }
               }

               if (this.var_mode == 0 && var3 != 0.0D) {
                  this.factureHonoraire(var1);
               }

               var2.commit();
            }
         } catch (HibernateException var19) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var19;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.executerRequete();
      }

      this.var_action = 0;
      this.var_memo_action = this.var_action;
   }

   public void factureHonoraire(Session var1) throws ParseException, HibernateException, NamingException {
      String var2 = "";
      boolean var3 = false;
      this.appelCharge = this.appelChargeDao.pourParapheur(this.bien.getBieId(), "F.HONO.", this.periodeCode, var1);
      if (this.appelCharge != null) {
         if (this.appelCharge.getAppchaEtat() == 0) {
            var2 = this.appelCharge.getAppchaNum();
            this.appelChargeDao.delete(this.appelCharge, var1);
            var3 = true;
         } else {
            var3 = false;
         }
      } else {
         var3 = true;
      }

      if (var3) {
         this.appelCharge = new AppelCharge();
         double var4 = this.utilNombre.myRoundDevise(this.bienBudgetEntete.getBiebudentHonoraire() / 4.0D, this.structureLog.getStrdevise());
         new Tiers();
         if (this.bienBudgetEntete.getBiebudentIdCoproprietaire() != 0L) {
            Tiers var6 = this.tiersDao.selectTierD(this.bienBudgetEntete.getBiebudentIdCoproprietaire(), var1);
            if (var6 != null) {
               this.appelCharge.setAppchaArrondiReg(var6.getTienbarrondi());
               this.appelCharge.setAppchaConditionReg(var6.getTieconditionreg());
               this.appelCharge.setAppchaIdTiers(var6.getTieid());
               this.appelCharge.setAppchaNbJourReg(var6.getTienbecheance());
               this.appelCharge.setAppchaTypeReg(var6.getTietypereg());
               this.appelCharge.setAppchaJournalReg(var6.getTiejournalreg());
               this.appelCharge.setAppchaModeReg(var6.getTiemodereg());
               this.appelCharge.setAppchaDateEcheReg(this.CalculDateEcheance());
               this.appelCharge.setAppchaCivilTiers(var6.getTiecivilite());
               this.appelCharge.setAppchaNomTiers(var6.getTieraisonsocialenom());
               this.appelCharge.setAppchaBanque((String)null);
               this.appelCharge.setAppchaExoTva(var6.getTieexotva());
               this.appelCharge.setAppchaCivilContact((String)null);
               this.appelCharge.setAppchaIdContact(0L);
               this.appelCharge.setAppchaNomContact((String)null);
            } else {
               this.appelCharge.setAppchaArrondiReg(0);
               this.appelCharge.setAppchaConditionReg((String)null);
               this.appelCharge.setAppchaIdTiers(0L);
               this.appelCharge.setAppchaNbJourReg(0);
               this.appelCharge.setAppchaTypeReg(0);
               this.appelCharge.setAppchaJournalReg((String)null);
               this.appelCharge.setAppchaModeReg((String)null);
               this.appelCharge.setAppchaDateEcheReg((Date)null);
               this.appelCharge.setAppchaCivilTiers((String)null);
               this.appelCharge.setAppchaNomTiers((String)null);
               this.appelCharge.setAppchaBanque((String)null);
               this.appelCharge.setAppchaExoTva(0);
               this.appelCharge.setAppchaCivilContact((String)null);
               this.appelCharge.setAppchaIdContact(0L);
               this.appelCharge.setAppchaNomContact((String)null);
            }
         } else {
            this.appelCharge.setAppchaArrondiReg(0);
            this.appelCharge.setAppchaConditionReg((String)null);
            this.appelCharge.setAppchaIdTiers(0L);
            this.appelCharge.setAppchaNbJourReg(0);
            this.appelCharge.setAppchaTypeReg(0);
            this.appelCharge.setAppchaJournalReg((String)null);
            this.appelCharge.setAppchaModeReg((String)null);
            this.appelCharge.setAppchaDateEcheReg((Date)null);
            this.appelCharge.setAppchaCivilTiers((String)null);
            this.appelCharge.setAppchaNomTiers((String)null);
            this.appelCharge.setAppchaBanque((String)null);
            this.appelCharge.setAppchaExoTva(0);
            this.appelCharge.setAppchaCivilContact((String)null);
            this.appelCharge.setAppchaIdContact(0L);
            this.appelCharge.setAppchaNomContact((String)null);
         }

         if (this.appelCharge.getAppchaId() == 0L) {
            if (this.bienBudgetEntete != null) {
               this.appelCharge.setAppchaIdBudget(this.var_idBudget);
               this.appelCharge.setAppchaBudget(this.bienBudgetEntete.getBiebudentNum());
               this.appelCharge.setAppchaAnneeBudget("" + this.bienBudgetEntete.getBiebudentAnnee());
               this.appelCharge.setAppchaTotAnnuel(this.totalBudget);
               this.appelCharge.setAppchaTotBudget(this.totalBudgetTrim);
               this.appelCharge.setAppchaTotReliquat(this.totalBudgetTrimReliquat);
            } else {
               this.appelCharge.setAppchaIdBudget(0L);
               this.appelCharge.setAppchaBudget((String)null);
               this.appelCharge.setAppchaAnneeBudget((String)null);
               this.appelCharge.setAppchaTotAnnuel(0.0D);
               this.appelCharge.setAppchaTotBudget(0.0D);
               this.appelCharge.setAppchaTotReliquat(0.0D);
            }

            if (this.bien != null) {
               this.appelCharge.setAppchaImmeuble(this.bien.getBieNum());
               this.appelCharge.setAppchaIdImmeuble(this.var_idImmeuble);
               this.appelCharge.setAppchaMlImmeuble((int)this.totalMillieme);
            } else {
               this.appelCharge.setAppchaImmeuble((String)null);
               this.appelCharge.setAppchaIdImmeuble(0L);
               this.appelCharge.setAppchaMlImmeuble(0);
            }

            this.appelCharge.setAppchaIdBien(0L);
            this.appelCharge.setAppchaMlBien(0);
            this.appelCharge.setAppchaBien("F.HONO.");
            this.appelCharge.setAppchaMode(this.var_mode);
            this.appelCharge.setAppchaSerie(this.inpSerie);
            this.appelCharge.setAppchaModeleImp(this.var_modeleImp + "_HONORAIRES");
            this.appelCharge.setAppchaDateDebut(this.inpDu);
            this.appelCharge.setAppchaDateFin(this.inpAu);
            this.appelCharge.setAppchaDate(this.inpDu);
            if (var2 != null && !var2.isEmpty()) {
               this.appelCharge.setAppchaNum(var2);
            } else if (this.appelCharge.getAppchaSerie() != null && !this.appelCharge.getAppchaSerie().equalsIgnoreCase("X") && !this.appelCharge.getAppchaSerie().isEmpty()) {
               this.appelCharge.setAppchaNum(this.calculChrono.numCompose(this.appelCharge.getAppchaDate(), this.nature, this.appelCharge.getAppchaSerie(), var1));
               boolean var13 = false;

               label64:
               while(true) {
                  while(true) {
                     if (var13) {
                        break label64;
                     }

                     new AppelCharge();
                     AppelCharge var8 = this.appelChargeDao.pourParapheur(this.appelCharge.getAppchaNum(), this.appelCharge.getAppchaSerie(), var1);
                     if (var8 != null) {
                        long var9 = 100000000L * this.usersLog.getUsrid();

                        for(long var11 = 0L; var11 < var9; ++var11) {
                        }

                        this.appelCharge.setAppchaNum(this.calculChrono.numCompose(this.appelCharge.getAppchaDate(), this.nature, this.appelCharge.getAppchaSerie(), var1));
                        var13 = false;
                     } else {
                        var13 = true;
                     }
                  }
               }
            } else {
               long var7 = this.appelChargeDao.selectLastNum(var1);
               this.appelCharge.setAppchaNum("" + var7);
            }

            this.appelCharge.setAppchaDateAnnule((Date)null);
            this.appelCharge.setAppchaDateCreat(new Date());
            this.appelCharge.setAppchaDateImp((Date)null);
            this.appelCharge.setAppchaDateLastReg((Date)null);
            this.appelCharge.setAppchaDateModif((Date)null);
            this.appelCharge.setAppchaDateRelance((Date)null);
            this.appelCharge.setAppchaDateTransfert((Date)null);
            this.appelCharge.setAppchaDateTransforme((Date)null);
            this.appelCharge.setAppchaDateValide((Date)null);
            this.appelCharge.setAppchaDateValidite((Date)null);
            this.appelCharge.setAppchaDateVisa((Date)null);
            this.appelCharge.setAppchaDevise(this.structureLog.getStrdevise());
            this.appelCharge.setAppchaEcheanceReliquat((Date)null);
            this.appelCharge.setAppchaEtat(1);
            this.appelCharge.setAppchaEtatVal(0);
            this.appelCharge.setAppchaGele(0);
            this.appelCharge.setAppchaIdCommercial(0L);
            this.appelCharge.setAppchaIdCreateur(this.usersLog.getUsrid());
            this.appelCharge.setAppchaIdResponsable(this.usersLog.getUsrid());
            this.appelCharge.setAppchaIdModif(0L);
            this.appelCharge.setAppchaMotifAnnule((String)null);
            this.appelCharge.setAppchaMotifExo((String)null);
            this.appelCharge.setAppchaNomCommercial((String)null);
            this.appelCharge.setAppchaNomCreateur(this.usersLog.getUsrPatronyme());
            this.appelCharge.setAppchaNomModif((String)null);
            this.appelCharge.setAppchaNomResponsable(this.usersLog.getUsrPatronyme());
            this.appelCharge.setAppchaNumAvoir((String)null);
            this.appelCharge.setAppchaNumTrf((String)null);
            this.appelCharge.setAppchaNumVisa((String)null);
            this.appelCharge.setAppchaObject(this.periode + " " + (this.inpDu.getYear() + 1900));
            this.appelCharge.setAppchaObservation((String)null);
            this.appelCharge.setAppchaPeriode(this.periodeCode);
            this.appelCharge.setAppchaRangeVisa((String)null);
            this.appelCharge.setAppchaSolde(0);
            this.appelCharge.setAppchaSource((String)null);
            this.appelCharge.setAppchaTauxRemise(0.0D);
            this.appelCharge.setAppchaTauxTva((double)this.taux_tva);
            this.appelCharge.setAppchaCodeTva(this.var_codeTva);
            this.appelCharge.setAppchaTotReglement(0.0D);
            this.appelCharge.setAppchaTotRemise(0.0D);
            this.appelCharge.setAppchaTotTc(0.0D);
            this.appelCharge.setAppchaTotTimbre(0.0D);
            this.appelCharge.setAppchaPu(var4);
            this.appelCharge.setAppchaTotHt(var4);
            double var14 = this.utilNombre.myRoundDevise(this.appelCharge.getAppchaTotHt() * this.appelCharge.getAppchaTauxTva() / 100.0D, this.structureLog.getStrdevise());
            this.appelCharge.setAppchaTotTva(var14);
            this.appelCharge.setAppchaTotTtc(this.utilNombre.myRoundDevise(this.appelCharge.getAppchaTotHt() + this.appelCharge.getAppchaTotTva(), this.structureLog.getStrdevise()));
            this.appelCharge.setAppchaTypeTransforme(0);
            this.appelCharge.setAppchaContrat("F.HONO.:" + this.periodeCode);
            this.appelCharge.setBien(this.bien);
            this.appelCharge.setExerciceventes(this.exercicesVentes);
            this.appelCharge.setUsers(this.usersLog);
            this.appelCharge = this.appelChargeDao.insert(this.appelCharge, var1);
         } else {
            this.appelCharge = this.appelChargeDao.modif(this.appelCharge, var1);
         }
      }

   }

   public void chargerModeleFactures() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "documentSyndic" + File.separator + "appel_charge" + File.separator;
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.mesImpressionsFacturesItems = new ArrayList();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            if (var3[var4].endsWith("jasper")) {
               String var5 = var3[var4].substring(0, var3[var4].indexOf("."));
               this.mesImpressionsFacturesItems.add(new SelectItem(var5));
            }
         }
      }

   }

   public void chargerPeriodes() throws ParseException {
      this.mesPeriodesItems.clear();
      this.mesPeriodesItems.add(new SelectItem("0", "Sélection période"));
      Date var1 = this.exercicesVentes.getExevteDateDebut();
      GregorianCalendar var2 = new GregorianCalendar();
      var2.setTime(var1);
      Date var3 = this.exercicesVentes.getExevteDateFin();
      GregorianCalendar var4 = new GregorianCalendar();
      var4.setTime(var3);
      var2.add(2, -1);
      var4.add(2, -1);
      Object var5 = null;
      this.mesPeriodesItems.add(new SelectItem("1er trimestre"));
      this.mesPeriodesItems.add(new SelectItem("2eme trimestre"));
      this.mesPeriodesItems.add(new SelectItem("3eme trimestre"));
      this.mesPeriodesItems.add(new SelectItem("4eme trimestre"));
      this.inpDu = var1;
      this.inpAu = var3;
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
            this.inpDu = this.utilDate.stringToDateSQLLight(var3 + "-" + var2 + "-" + "01");
            this.inpAu = this.utilDate.dateDernierJourMois(this.inpDu);
            this.periodeCode = var2 + ":" + var3;
         } else {
            int var4 = (new Date()).getYear() + 1900;
            if (this.periode.equals("1er trimestre")) {
               this.inpDu = this.utilDate.stringToDateSQLLight(var4 + "-" + "01" + "-" + "01");
               this.inpAu = this.utilDate.stringToDateSQLLight(var4 + "-" + "03" + "-" + "31");
               this.periodeCode = "01:" + var4;
            } else if (this.periode.equals("2eme trimestre")) {
               this.inpDu = this.utilDate.stringToDateSQLLight(var4 + "-" + "04" + "-" + "01");
               this.inpAu = this.utilDate.stringToDateSQLLight(var4 + "-" + "06" + "-" + "30");
               this.periodeCode = "04:" + var4;
            } else if (this.periode.equals("3eme trimestre")) {
               this.inpDu = this.utilDate.stringToDateSQLLight(var4 + "-" + "07" + "-" + "01");
               this.inpAu = this.utilDate.stringToDateSQLLight(var4 + "-" + "09" + "-" + "30");
               this.periodeCode = "07:" + var4;
            } else if (this.periode.equals("4eme trimestre")) {
               this.inpDu = this.utilDate.stringToDateSQLLight(var4 + "-" + "10" + "-" + "01");
               this.inpAu = this.utilDate.stringToDateSQLLight(var4 + "-" + "12" + "-" + "31");
               this.periodeCode = "10:" + var4;
            } else if (this.periode.equals("1er semestre")) {
               this.inpDu = this.utilDate.stringToDateSQLLight(var4 + "-" + "01" + "-" + "01");
               this.inpAu = this.utilDate.stringToDateSQLLight(var4 + "-" + "06" + "-" + "30");
               this.periodeCode = "01:" + var4;
            } else if (this.periode.equals("2eme semestre")) {
               this.inpDu = this.utilDate.stringToDateSQLLight(var4 + "-" + "07" + "-" + "01");
               this.inpAu = this.utilDate.stringToDateSQLLight(var4 + "-" + "12" + "-" + "31");
               this.periodeCode = "07:" + var4;
            } else if (this.periode.equals("Annuel")) {
               this.inpDu = this.utilDate.stringToDateSQLLight(var4 + "-" + "01" + "-" + "01");
               this.inpAu = this.utilDate.stringToDateSQLLight(var4 + "-" + "12" + "-" + "31");
               this.periodeCode = "01:" + var4;
            }
         }
      }

   }

   public void calculBudget() throws HibernateException, NamingException {
      this.calculBudget((Session)null);
   }

   public void calculBudget(Session var1) throws HibernateException, NamingException {
      this.mesBudgetsItems.clear();
      this.lesAppartements.clear();
      if (this.var_idImmeuble != 0L) {
         this.bien = this.bienDao.logBienId(this.var_idImmeuble, var1);
         if (this.bien != null) {
            this.bienBudgetEntete = new BienBudgetEntete();
            new ArrayList();
            List var2 = this.bienBudgetEnteteDao.chargerBudgetByBien(this.bien, this.var_mode, var1);
            if (var2.size() != 0) {
               for(int var3 = 0; var3 < var2.size(); ++var3) {
                  this.mesBudgetsItems.add(new SelectItem(((BienBudgetEntete)var2.get(var3)).getBiebudentId(), ((BienBudgetEntete)var2.get(var3)).getBiebudentNum() + ":" + ((BienBudgetEntete)var2.get(var3)).getBiebudentAnnee()));
               }
            }

            this.selectionBudget(var1);
            this.selectionTva(var1);
            this.puMillieme = this.totalBudget / this.totalMillieme;
            new ArrayList();
            List var11 = this.bienDao.chargeBienDetail(this.var_idImmeuble, var1);
            int var5;
            if (var11.size() != 0) {
               new Bien();

               for(var5 = 0; var5 < var11.size(); ++var5) {
                  Bien var4 = (Bien)var11.get(var5);
                  if (this.lesAppartements.size() == 0) {
                     var4.setNumlot(var4.getBieNum());
                     this.lesAppartements.add(var4);
                  } else {
                     boolean var6 = false;
                     int var7 = 0;
                     int var8 = 0;
                     String var9 = "";

                     for(int var10 = 0; var10 < this.lesAppartements.size(); ++var10) {
                        if (((Bien)this.lesAppartements.get(var10)).getTiers() != null && var4.getTiers() != null && ((Bien)this.lesAppartements.get(var10)).getTiers().getTieid() == var4.getTiers().getTieid()) {
                           var7 = ((Bien)this.lesAppartements.get(var10)).getBieMillieme();
                           var9 = ((Bien)this.lesAppartements.get(var10)).getBieNum();
                           var8 = var10;
                           var6 = true;
                           break;
                        }
                     }

                     if (!var6) {
                        var4.setNumlot(var4.getBieNum());
                        this.lesAppartements.add(var4);
                     } else {
                        String var16 = ((Bien)this.lesAppartements.get(var8)).getNumlot();
                        this.lesAppartements.remove(var8);
                        var4.setBieMillieme(var4.getBieMillieme() + var7);
                        if (var16 != null && !var16.isEmpty()) {
                           var16 = var16 + ", " + var9;
                        } else {
                           var16 = var9;
                        }

                        var4.setNumlot(var16);
                        this.lesAppartements.add(var4);
                     }
                  }
               }
            }

            if (this.lesAppartements.size() != 0) {
               int var12 = 0;

               for(var5 = 0; var5 < this.lesAppartements.size(); ++var5) {
                  var12 += ((Bien)this.lesAppartements.get(var5)).getBieMillieme();
               }

               this.totalMillieme = (double)var12;
               new Bien();

               for(int var14 = 0; var14 < this.lesAppartements.size(); ++var14) {
                  Bien var13 = (Bien)this.lesAppartements.get(var14);
                  if (var13.getTiers() == null) {
                     this.proprietaire = this.tiersDao.chargerLesTiers("0", var13.getBieNomTiers(), var1);
                     if (this.proprietaire != null) {
                        var13.setTiers(this.proprietaire);
                        var13.setBieTiers(this.proprietaire.getTiesigle());
                        var13 = this.bienDao.modif(var13);
                     }
                  }

                  var13.setPu(this.puMillieme);
                  var13.setPtHt((double)var13.getBieMillieme() * this.puMillieme);
                  if (this.appelCharge.getAppchaCodeTva() != null && !this.appelCharge.getAppchaCodeTva().isEmpty()) {
                     double var15 = this.utilNombre.myRoundDevise(var13.getPtHt() * this.appelCharge.getAppchaTauxTva() / 100.0D, this.structureLog.getStrdevise());
                     var13.setPtTaxe(var15);
                     var13.setPtTtc(var13.getPtHt() + var15);
                  } else {
                     var13.setPtTaxe(0.0D);
                     var13.setPtTtc(var13.getPtHt());
                  }
               }
            }
         }
      }

      this.dataModelAppartements.setWrappedData(this.lesAppartements);
   }

   public void selectionBudget() throws HibernateException, NamingException {
      this.selectionBudget((Session)null);
   }

   public void selectionBudget(Session var1) throws HibernateException, NamingException {
      this.totalBudget = 0.0D;
      this.selectionTva(var1);
      if (this.var_idBudget != 0L) {
         this.bienBudgetEntete = this.bienBudgetEnteteDao.pourParapheur(this.var_idBudget, var1);
         if (this.bienBudgetEntete != null) {
            this.appelCharge.setAppchaObject(this.bienBudgetEntete.getBiebudentObjet());
            this.totalBudget = this.bienBudgetEntete.getBiebudentTotal();
            this.totalBudgetTrimReliquat = 0.0D;
            if (this.var_mode == 0) {
               this.totalBudgetTrim = this.utilNombre.myRound(this.bienBudgetEntete.getBiebudentTotal() / 4.0D, 0);
               if (this.bienBudgetEntete.getBiebudentResteAnterieur() != 0.0D && this.periode.equals("2eme trimestre")) {
                  this.totalBudgetTrimReliquat = this.bienBudgetEntete.getBiebudentResteAnterieur() * -1.0D;
               }
            } else {
               this.totalBudgetTrim = this.utilNombre.myRound(this.bienBudgetEntete.getBiebudentTotal(), 0);
            }

            this.puMillieme = this.totalBudgetTrim / this.totalMillieme;
            this.puMilliemeReliquat = this.totalBudgetTrimReliquat / this.totalMillieme;
            if (this.lesAppartements.size() != 0) {
               new Bien();

               for(int var3 = 0; var3 < this.lesAppartements.size(); ++var3) {
                  Bien var2 = (Bien)this.lesAppartements.get(var3);
                  var2.setPu(this.puMillieme);
                  var2.setPuReliquat(this.puMilliemeReliquat);
                  var2.setPtHt((double)var2.getBieMillieme() * this.puMillieme);
                  var2.setPtHtReliquat((double)var2.getBieMillieme() * this.puMilliemeReliquat);
                  if (this.appelCharge.getAppchaCodeTva() != null && !this.appelCharge.getAppchaCodeTva().isEmpty()) {
                     double var4 = this.utilNombre.myRoundDevise(var2.getPtHt() * this.appelCharge.getAppchaTauxTva() / 100.0D, this.structureLog.getStrdevise());
                     var2.setPtTaxe(var4);
                     var2.setPtTtc(var2.getPtHt() + var4);
                     double var6 = this.utilNombre.myRoundDevise(var2.getPtHtReliquat() * this.appelCharge.getAppchaTauxTva() / 100.0D, this.structureLog.getStrdevise());
                     var2.setPtTaxeReliquat(var4);
                     var2.setPtTtcReliquat(var2.getPtHtReliquat() + var6);
                  } else {
                     var2.setPtTaxe(0.0D);
                     var2.setPtTtc(var2.getPtHt());
                     var2.setPtTaxeReliquat(0.0D);
                     var2.setPtTtcReliquat(var2.getPtHtReliquat());
                  }
               }
            }
         }
      }

   }

   public void selectionTva() throws HibernateException, NamingException {
      this.selectionTva((Session)null);
   }

   public void selectionTva(Session var1) throws HibernateException, NamingException {
      if (this.var_codeTva != null && !this.var_codeTva.isEmpty() && !this.var_codeTva.equals("0")) {
         new TaxesVentes();
         TaxesVentes var9 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), this.var_codeTva, var1);
         if (var9 != null) {
            this.appelCharge.setAppchaCodeTva(var9.getTaxvteCode());
            this.appelCharge.setAppchaTauxTva((double)var9.getTaxvteTaux());
            if (this.lesAppartements.size() != 0) {
               new Bien();

               for(int var4 = 0; var4 < this.lesAppartements.size(); ++var4) {
                  Bien var10 = (Bien)this.lesAppartements.get(var4);
                  var10.setPu(this.puMillieme);
                  var10.setPuReliquat(this.puMilliemeReliquat);
                  var10.setPtHt((double)var10.getBieMillieme() * this.puMillieme);
                  var10.setPtHtReliquat((double)var10.getBieMillieme() * this.puMilliemeReliquat);
                  if (this.appelCharge.getAppchaCodeTva() != null && !this.appelCharge.getAppchaCodeTva().isEmpty()) {
                     double var5 = this.utilNombre.myRoundDevise(var10.getPtHt() * this.appelCharge.getAppchaTauxTva() / 100.0D, this.structureLog.getStrdevise());
                     var10.setPtTaxe(var5);
                     var10.setPtTtc(var10.getPtHt() + var5);
                     double var7 = this.utilNombre.myRoundDevise(var10.getPtHtReliquat() * this.appelCharge.getAppchaTauxTva() / 100.0D, this.structureLog.getStrdevise());
                     var10.setPtTaxeReliquat(var7);
                     var10.setPtTtc(var10.getPtHtReliquat() + var7);
                  } else {
                     var10.setPtTaxe(0.0D);
                     var10.setPtTtc(var10.getPtHt());
                     var10.setPtTaxeReliquat(0.0D);
                     var10.setPtTtcReliquat(var10.getPtHtReliquat());
                  }
               }
            }
         }
      } else {
         this.appelCharge.setAppchaCodeTva("");
         this.appelCharge.setAppchaTauxTva(0.0D);
         if (this.lesAppartements.size() != 0) {
            new Bien();

            for(int var3 = 0; var3 < this.lesAppartements.size(); ++var3) {
               Bien var2 = (Bien)this.lesAppartements.get(var3);
               var2.setPu(this.puMillieme);
               var2.setPuReliquat(this.puMilliemeReliquat);
               var2.setPtHt((double)var2.getBieMillieme() * this.puMillieme);
               var2.setPtHtReliquat((double)var2.getBieMillieme() * this.puMilliemeReliquat);
               var2.setPtTaxe(0.0D);
               var2.setPtTtc(var2.getPtHt());
               var2.setPtTaxeReliquat(0.0D);
               var2.setPtTtcReliquat(var2.getPtHtReliquat());
            }
         }
      }

   }

   public void selectionTiers() throws HibernateException, NamingException, ParseException {
      if (this.datamodelTiers.isRowAvailable() && this.inpClient != null && !this.inpClient.isEmpty() && this.inpClient.contains(":")) {
         this.tiers = (Tiers)this.datamodelTiers.getRowData();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
         this.calculFactureTiers(var1);
         this.utilInitHibernate.closeSession();
         this.reglementsRecu = null;
         this.visibiliteFacture = false;
         this.visibiliteRecu = false;
      }

   }

   public void calculFactureTiers(Session var1) throws HibernateException, NamingException, ParseException {
      this.listFacture.clear();
      this.totFactureGlobal = 0.0D;
      this.totReglementGlobal = 0.0D;
      this.totTimbreGlobal = 0.0D;
      this.soldeGlobal = 0.0D;
      this.appelCharge = new AppelCharge();
      this.appelCharge.setAppchaIdTiers(this.tiers.getTieid());
      String[] var2 = this.inpClient.split(":");
      this.bien = this.bienDao.logBienNum(var2[0], var1);
      if (this.bien != null) {
         this.appelCharge.setAppchaIdImmeuble(this.bien.getBieId());
      } else {
         this.appelCharge.setAppchaIdImmeuble(0L);
      }

      this.appelCharge.setBien(this.bien);
      String var3 = "" + (this.exercicesVentes.getExevteDateFin().getYear() + 1900);
      if (this.periode.equals("5")) {
         this.inpDu = this.utilDate.stringToDateSQLLight(var3 + "-" + "01" + "-" + "01");
         this.inpAu = this.utilDate.stringToDateSQLLight(var3 + "-" + "03" + "-" + "31");
         this.periodeCode = "01:" + var3;
      } else if (this.periode.equals("6")) {
         this.inpDu = this.utilDate.stringToDateSQLLight(var3 + "-" + "04" + "-" + "01");
         this.inpAu = this.utilDate.stringToDateSQLLight(var3 + "-" + "06" + "-" + "30");
         this.periodeCode = "04:" + var3;
      } else if (this.periode.equals("7")) {
         this.inpDu = this.utilDate.stringToDateSQLLight(var3 + "-" + "07" + "-" + "01");
         this.inpAu = this.utilDate.stringToDateSQLLight(var3 + "-" + "09" + "-" + "30");
         this.periodeCode = "07:" + var3;
      } else if (this.periode.equals("8")) {
         this.inpDu = this.utilDate.stringToDateSQLLight(var3 + "-" + "10" + "-" + "01");
         this.inpAu = this.utilDate.stringToDateSQLLight(var3 + "-" + "12" + "-" + "31");
         this.periodeCode = "10:" + var3;
      } else if (this.periode.equals("9")) {
         this.inpDu = this.utilDate.stringToDateSQLLight(var3 + "-" + "01" + "-" + "01");
         this.inpAu = this.utilDate.stringToDateSQLLight(var3 + "-" + "06" + "-" + "30");
         this.periodeCode = "01:" + var3;
      } else if (this.periode.equals("10")) {
         this.inpDu = this.utilDate.stringToDateSQLLight(var3 + "-" + "07" + "-" + "01");
         this.inpAu = this.utilDate.stringToDateSQLLight(var3 + "-" + "12" + "-" + "31");
         this.periodeCode = "07:" + var3;
      } else if (this.periode.equals("11")) {
         this.inpDu = this.utilDate.stringToDateSQLLight(var3 + "-" + "01" + "-" + "01");
         this.inpAu = this.utilDate.stringToDateSQLLight(var3 + "-" + "12" + "-" + "31");
         this.periodeCode = "01:" + var3;
      }

      this.listFacture = this.calculeImpressionCommun(1, this.tiers, this.bien, this.inpDu, this.inpAu, var1);
      if (this.listFacture.size() != 0) {
         new AppelCharge();

         for(int var5 = 0; var5 < this.listFacture.size(); ++var5) {
            AppelCharge var4 = (AppelCharge)this.listFacture.get(var5);
            var4.setAppchaTotTtcReliquat(0.0D);
            if (var4.getAppchaNum() != null && !var4.getAppchaNum().isEmpty()) {
               var4.setAppchaTotReglement(0.0D);
               var4.setAppchaTotTimbre(0.0D);
            } else {
               var4.setAppchaTotTtc(0.0D);
            }

            this.totFactureGlobal = this.totFactureGlobal + var4.getAppchaTotTtc() + var4.getAppchaTotTtcReliquat();
            this.totReglementGlobal += var4.getAppchaTotReglement();
            this.totTimbreGlobal += var4.getAppchaTotTimbre();
         }

         this.soldeGlobal = this.totFactureGlobal - this.totReglementGlobal;
         if (this.soldeGlobal != 0.0D) {
            if (this.usersLog.getUsrFactureCaisse() == 1) {
               this.var_affiche_be = true;
               this.var_affiche_dollar = false;
            } else if (this.usersLog.getUsrFactureCaisse() == 2) {
               this.var_affiche_be = false;
               this.var_affiche_dollar = true;
            } else if (this.usersLog.getUsrFactureCaisse() == 3) {
               this.var_affiche_be = true;
               this.var_affiche_dollar = true;
            } else {
               this.var_affiche_be = false;
               this.var_affiche_dollar = false;
            }
         } else {
            this.var_affiche_be = false;
            this.var_affiche_dollar = false;
         }
      }

      this.datamodelFacture.setWrappedData(this.listFacture);
   }

   public void selectionElementTiers() {
      if (this.datamodelFacture.isRowAvailable()) {
         this.appelCharge = (AppelCharge)this.datamodelFacture.getRowData();
         this.reglementsRecu = null;
         this.var_date = this.appelCharge.getAppchaDate();
         if (this.appelCharge.getAppchaNum() != null && !this.appelCharge.getAppchaNum().isEmpty()) {
            this.visibiliteFacture = true;
            this.visibiliteRecu = false;
            if (this.appelCharge.getAppchaDate().getHours() <= 9) {
               this.var_heure = "0" + this.appelCharge.getAppchaDate().getHours();
            } else {
               this.var_heure = "" + this.appelCharge.getAppchaDate().getHours();
            }

            if (this.appelCharge.getAppchaDate().getMinutes() <= 9) {
               this.var_minute = "0" + this.appelCharge.getAppchaDate().getMinutes();
            } else {
               this.var_minute = "" + this.appelCharge.getAppchaDate().getMinutes();
            }

            if (this.appelCharge.getAppchaDate().getSeconds() <= 9) {
               this.var_seconde = "0" + this.appelCharge.getAppchaDate().getSeconds();
            } else {
               this.var_seconde = "" + this.appelCharge.getAppchaDate().getSeconds();
            }
         } else {
            this.visibiliteFacture = false;
            this.visibiliteRecu = true;
         }
      }

   }

   public void verifBonEncaissement() {
      if (this.montantElmTotBonEnc <= this.appelCharge.getAppchaTotTtc() - this.var_tot_bon_encaissement) {
         this.montantElmTotBonEnc = this.appelCharge.getAppchaTotTtc() - this.var_tot_bon_encaissement;
         this.var_affiche_valide = true;
      } else {
         this.var_affiche_valide = false;
      }

   }

   public void verifBonEncaissementMultiple() {
      if (this.montantElmTotBonEnc != 0.0D) {
         this.var_affiche_valide = true;
      } else {
         this.var_affiche_valide = false;
      }

      this.var_ecart_reglement = this.var_netAPayer - this.montantElmTotBonEnc;
   }

   public void payeDocument() throws HibernateException, NamingException {
      if (this.appelCharge != null) {
         this.bonEncaissementVente = new BonEncaissementVente();
         this.bonEncaissementVente.setBonCodeCaisse("");
         this.bonEncaissementVente.setBonLibCaisse("");
         this.bonEncaissementVente.setBonDate(new Date());
         this.var_nom_client = "";
         this.var_num_facture = "";
         this.var_montant = "";
         this.var_date_trf = new Date();
         this.listFactureSelectionne.clear();
         this.repartitionManuelle = false;
         this.totManuel = 0.0D;
         this.ecartManuel = 0.0D;
         this.chargerCaisseCommerciale();
         double var1 = 0.0D;
         int var3 = 0;

         for(int var4 = 0; var4 < this.listFacture.size(); ++var4) {
            new AppelCharge();
            AppelCharge var5 = (AppelCharge)this.listFacture.get(var4);
            if (var5.isVar_select_ligne() && var5.getAppchaTotReglement() < var5.getAppchaTotTtc()) {
               ++var3;
               var1 += var5.getAppchaTotTtc() - var5.getAppchaTotReglement();
               this.listFactureSelectionne.add(var5);
            }
         }

         if (var1 != 0.0D && var3 >= 2) {
            this.montantElmTotBonEnc = 0.0D;
            this.var_netAPayer = var1;
            this.datamodelTransfert.setWrappedData(this.listFactureSelectionne);
            this.showModalPanelPayeMultiple = true;
         } else {
            if (this.var_tot_bon_encaissement > this.appelCharge.getAppchaTotTtc()) {
               this.appelCharge.setAppchaTypeReg(4);
               this.var_verouxModReg = true;
               this.var_affichMontant = false;
               this.var_netAPayer = this.appelCharge.getAppchaTotTtc() - this.var_tot_bon_encaissement;
               this.verifBonEncaissement();
            } else {
               if (this.appelCharge.getAppchaTypeReg() == 5) {
                  this.montantElmTotBonEnc = this.var_tot_bon_encaissement;
                  if (this.appelCharge.getAppchaEtat() == 1) {
                     this.var_verouxModReg = true;
                  } else {
                     this.var_verouxModReg = false;
                  }

                  this.var_netAPayer = this.appelCharge.getAppchaTotTtc() - this.var_tot_bon_encaissement;
                  this.var_affiche_valide = true;
               } else {
                  this.appelCharge.setAppchaTypeReg(0);
                  this.var_verouxModReg = false;
                  this.var_netAPayer = this.appelCharge.getAppchaTotTtc() - this.var_tot_bon_encaissement;
                  this.verifBonEncaissement();
               }

               this.var_affichMontant = true;
            }

            this.var_aff_action = false;
            this.showModalPanelPaye = true;
         }
      }

   }

   public void chargerCaisseCommerciale() throws HibernateException, NamingException {
      this.mesCaissesItems.clear();
      if (this.appelCharge != null) {
         if (this.appelCharge.getAppchaSerie() != null && !this.appelCharge.getAppchaSerie().isEmpty()) {
            new Chrono();
            ChronoDao var2 = new ChronoDao(this.baseLog, this.utilInitHibernate);
            this.caissesCommercialesDao = new CaissesCommercialesDao(this.baseLog, this.utilInitHibernate);
            String var3 = "" + (this.appelCharge.getAppchaDate().getYear() + 1900);
            Chrono var1 = var2.chronoBySerieNat(this.appelCharge.getAppchaSerie(), this.nature, var3, (Session)null);
            if (var1 != null) {
               this.mesCaissesItems = this.caissesCommercialesDao.selectActifCaisseItems(this.usersLog.getUsrJrxReserve(), (Session)null);
            } else {
               this.mesCaissesItems.add(new SelectItem(""));
            }
         } else {
            this.mesCaissesItems.add(new SelectItem(""));
         }
      } else {
         this.mesCaissesItems.add(new SelectItem(""));
      }

   }

   public void annulePaye() {
      this.showModalPanelPaye = false;
   }

   public void annulePayeMultiple() {
      this.showModalPanelPayeMultiple = false;
   }

   public void chargerModReg() {
      if (this.appelCharge.getAppchaTypeReg() != 4 && this.appelCharge.getAppchaTypeReg() != 5) {
         this.montantElmTotBonEnc = this.var_netAPayer;
         this.var_affichMontant = true;
      } else {
         this.var_affichMontant = false;
      }

   }

   public void miseajourPaye() throws HibernateException, NamingException {
      Session var1;
      if (this.var_tot_bon_encaissement <= this.appelCharge.getAppchaTotTtc()) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SyndicAppelCharge");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.appelCharge.getAppchaTypeReg() == 5) {
               this.appelCharge = this.appelChargeDao.modif(this.appelCharge, var1);
               new Habilitation();
               HabilitationDao var15 = new HabilitationDao(this.baseLog, this.utilInitHibernate);
               var15.existenceHabilitation(this.nature, var1);
            } else {
               String var3 = this.calculChrono.numCompose(new Date(), 29, this.appelCharge.getAppchaSerie(), var1);
               if (var3 != null && !var3.isEmpty()) {
                  this.bonEncaissementVente = new BonEncaissementVente();
                  if (this.var_inputCaisse != null && !this.var_inputCaisse.isEmpty() && this.var_inputCaisse.contains(":")) {
                     String[] var4 = this.var_inputCaisse.split(":");
                     this.bonEncaissementVente.setBonCodeCaisse(var4[0]);
                     this.bonEncaissementVente.setBonLibCaisse(var4[1]);
                     new ExercicesCaisse();
                     ExercicesCaisseDao var6 = new ExercicesCaisseDao(this.baseLog, this.utilInitHibernate);
                     ExercicesCaisse var5 = var6.recupererLastExo(var1);
                     if (var5 != null) {
                        this.caissesCommerciales = new CaissesCommerciales();
                        this.caissesCommercialesDao = new CaissesCommercialesDao(this.baseLog, this.utilInitHibernate);
                        this.caissesCommerciales = this.caissesCommercialesDao.selectCaisseByCode(var4[0], var5, var1);
                        if (this.caissesCommerciales != null) {
                           if (this.caissesCommerciales.getCaiJrCheque() != null && !this.caissesCommerciales.getCaiJrCheque().isEmpty()) {
                              this.bonEncaissementVente.setBonTypeReg(1);
                           } else {
                              this.bonEncaissementVente.setBonTypeReg(0);
                           }
                        } else {
                           this.bonEncaissementVente.setBonTypeReg(0);
                        }
                     } else {
                        this.bonEncaissementVente.setBonTypeReg(0);
                     }
                  } else {
                     this.bonEncaissementVente.setBonCodeCaisse("");
                     this.bonEncaissementVente.setBonLibCaisse("");
                     this.bonEncaissementVente.setBonTypeReg(0);
                  }

                  this.bonEncaissementVente.setBonDateCreat(new Date());
                  this.bonEncaissementVente.setBonUserCreat(this.usersLog.getUsrid());
                  this.bonEncaissementVente.setBonActivite("");
                  this.bonEncaissementVente.setBonSite("");
                  this.bonEncaissementVente.setBonDepartement("");
                  this.bonEncaissementVente.setBonService("");
                  this.bonEncaissementVente.setBonRegion("");
                  this.bonEncaissementVente.setBonSecteur("");
                  this.bonEncaissementVente.setBonPdv("");
                  this.bonEncaissementVente.setBonDateEcheReg(this.appelCharge.getAppchaDateEcheReg());
                  this.bonEncaissementVente.setBonEtat(0);
                  this.bonEncaissementVente.setBonNatRef(this.nature);
                  this.bonEncaissementVente.setBonNomTiers(this.appelCharge.getAppchaNomTiers());
                  this.bonEncaissementVente.setBonIdTiers(this.appelCharge.getAppchaIdTiers());
                  this.bonEncaissementVente.setBonNomContact(this.appelCharge.getAppchaNomContact());
                  this.bonEncaissementVente.setBonIdContact(this.appelCharge.getAppchaIdContact());
                  this.bonEncaissementVente.setBonTypeTiers(0);
                  this.bonEncaissementVente.setBonLibelle("Règlement Facture N° " + this.appelCharge.getAppchaNum());
                  this.bonEncaissementVente.setBonRef(this.appelCharge.getAppchaNum());
                  this.bonEncaissementVente.setBonIdRef(this.appelCharge.getAppchaId());
                  this.bonEncaissementVente.setBonObject(this.appelCharge.getAppchaObject());
                  this.bonEncaissementVente.setBonObservation(this.appelCharge.getAppchaObservation());
                  this.bonEncaissementVente.setBonSerie(this.appelCharge.getAppchaSerie());
                  this.bonEncaissementVente.setBonDevise(this.appelCharge.getAppchaDevise());
                  this.bonEncaissementVente.setBonTotTtc(this.appelCharge.getAppchaTotTtc());
                  this.bonEncaissementVente.setBonAPayer(this.montantElmTotBonEnc);
                  this.bonEncaissementVente.setBonActif(0);
                  this.bonEncaissementVente.setBonNum(var3);
                  this.bonEncaissementVente.setBonDate(this.var_date_trf);
                  this.bonEncaissementVente.setBonIdResponsable(this.appelCharge.getAppchaIdResponsable());
                  this.bonEncaissementVente.setBonNomResponsable(this.appelCharge.getAppchaNomResponsable());
                  this.bonEncaissementVente.setBonIdCommercial(this.appelCharge.getAppchaIdCommercial());
                  this.bonEncaissementVente.setBonNomCommercial(this.appelCharge.getAppchaNomCommercial());
                  this.bonEncaissementVente.setBonIdEquipe(0L);
                  this.bonEncaissementVente.setBonNomEquipe("");
                  if (this.listFactureSelectionne.size() > 1) {
                     for(int var14 = 0; var14 < this.listFactureSelectionne.size(); ++var14) {
                        new AppelCharge();
                        AppelCharge var16 = (AppelCharge)this.listFactureSelectionne.get(var14);
                        if (var16.isVar_select_ligne()) {
                           this.var_nom_client = this.var_nom_client + ":" + var16.getAppchaNomTiers();
                           this.var_num_facture = this.var_num_facture + ":" + var16.getAppchaNum();
                           this.var_montant = this.var_montant + ":" + var16.getAppchaTotTtc();
                        }
                     }

                     this.bonEncaissementVente.setBonRef("");
                     this.bonEncaissementVente.setBonIdRef(0L);
                     this.bonEncaissementVente.setBonClient(this.var_nom_client + ":");
                     this.bonEncaissementVente.setBonFacture(this.var_num_facture + ":");
                     this.bonEncaissementVente.setBonMontant(this.var_montant + ":");
                     this.bonEncaissementVente.setBonLibelle(this.listFactureSelectionne.size() + " factures");
                     this.bonEncaissementVente.setBonNomTiers("Paiement groupé");
                     this.bonEncaissementVente.setBonIdTiers(0L);
                     this.bonEncaissementVente.setBonNomContact("");
                     this.bonEncaissementVente.setBonIdContact(0L);
                  } else {
                     this.bonEncaissementVente.setBonClient("");
                     this.bonEncaissementVente.setBonFacture("");
                     this.bonEncaissementVente.setBonMontant("");
                  }

                  this.bonEncaissementVenteDao.insert(this.bonEncaissementVente, var1);
               } else {
                  this.formRecherche.setMessageTexte("Le chrono du bon d`encaissement n`a pas été calculé. Peut être est-ce une question d'autorisation. Contactez votre administrateur pour plus d`informations.");
                  this.formRecherche.setShowModalPanelMessage(true);
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

      if (this.listFacture.size() != 0) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SyndicAppelCharge");

         for(int var12 = 0; var12 < this.listFacture.size(); ++var12) {
            this.appelCharge = (AppelCharge)this.listFacture.get(var12);
            if (this.appelCharge.isVar_select_ligne()) {
               long var13 = this.appelCharge.getAppchaId();
               this.appelCharge = new AppelCharge();
               this.appelCharge = this.appelChargeDao.pourParapheur(var13, var1);
               if (this.appelCharge != null) {
                  this.listFacture.remove(var12);
                  this.appelCharge.setVar_select_ligne(false);
                  this.listFacture.add(var12, this.appelCharge);
               }
            }
         }

         this.utilInitHibernate.closeSession();
         this.datamodelFacture.setWrappedData(this.listFacture);
      }

      this.showModalPanelPaye = false;
      this.showModalPanelPayeMultiple = false;
      this.visibiliteBton = false;
   }

   public void choixCaisse() {
      if (this.var_inputCaisse.equalsIgnoreCase("0")) {
         this.bonEncaissementVente.setBonCodeCaisse("");
         this.bonEncaissementVente.setBonLibCaisse("");
      } else {
         String[] var1 = this.var_inputCaisse.split(":");
         this.bonEncaissementVente.setBonCodeCaisse(var1[0]);
         this.bonEncaissementVente.setBonLibCaisse(var1[1]);
      }

   }

   public void supprimerReglement() throws HibernateException, NamingException {
      if (this.datamodelRecu.isRowAvailable()) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SyndicAppelCharge");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.reglements = (Reglements)this.datamodelRecu.getRowData();
            this.reglementsDao.delete(this.reglements, var1);
            new ArrayList();
            List var3 = this.reglementsDao.reglementDocument(this.appelCharge.getAppchaId(), this.nature, var1);
            double var4 = 0.0D;
            if (var3.size() != 0) {
               for(int var6 = 0; var6 < var3.size(); ++var6) {
                  var4 += ((Reglements)var3.get(var6)).getRglRecette();
               }
            }

            this.appelCharge.setAppchaTotReglement(var4);
            if (this.appelCharge.getAppchaTotReglement() >= this.appelCharge.getAppchaTotTtc()) {
               this.appelCharge.setAppchaSolde(1);
            } else {
               this.appelCharge.setAppchaSolde(0);
            }

            this.appelCharge = this.appelChargeDao.modif(this.appelCharge, var1);
            this.datamodelRecu.setWrappedData(var3);
            var2.commit();
         } catch (HibernateException var10) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var10;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.var_acc_reglement = true;
         this.visibleOnglet = true;
      }

   }

   public void payeXDocument() throws HibernateException, NamingException {
      this.caissesCommerciales = new CaissesCommerciales();
      this.caissesCommercialesDao = new CaissesCommercialesDao(this.baseLog, this.utilInitHibernate);
      this.var_inputCaisse = "0";
      this.var_ecart_reglement = 0.0D;
      this.var_type_reg = "0";
      this.var_objet = "";
      this.var_banque_tireur = "";
      this.var_num_cheque = "";
      this.var_banque_destination = "";
      this.var_affiche_banque = false;
      this.var_affiche_banque_destination = false;
      this.repartitionManuelle = false;
      this.totManuel = 0.0D;
      this.ecartManuel = 0.0D;
      this.val_timbre = 0.0D;
      this.totalPayerTimbre = 0.0D;
      this.var_date_trf = new Date();
      this.chargerCaisseCommerciale();
      if (this.listFacture.size() != 0) {
         this.listFactureSelectionne = new ArrayList();
         double var1 = 0.0D;
         double var3 = 0.0D;
         double var5 = 0.0D;
         long var7 = 0L;
         String var9 = "";
         double var10 = 0.0D;

         int var12;
         for(var12 = 0; var12 < this.listFacture.size(); ++var12) {
            if (((AppelCharge)this.listFacture.get(var12)).getAppchaObject() != null && !((AppelCharge)this.listFacture.get(var12)).getAppchaObject().isEmpty() && ((AppelCharge)this.listFacture.get(var12)).getAppchaObject().equals("Avoir") && ((AppelCharge)this.listFacture.get(var12)).getAppchaNumTrf() != null && !((AppelCharge)this.listFacture.get(var12)).getAppchaNumTrf().isEmpty()) {
               var10 = ((AppelCharge)this.listFacture.get(var12)).getAppchaTotReglement();
            }
         }

         for(var12 = 0; var12 < this.listFacture.size(); ++var12) {
            this.appelCharge = (AppelCharge)this.listFacture.get(var12);
            if (this.appelCharge.isVar_select_ligne()) {
               this.appelCharge = this.appelChargeDao.pourParapheur(this.appelCharge.getAppchaId(), (Session)null);
               if (this.appelCharge != null && (var7 == 0L || var7 != 0L && var7 == this.appelCharge.getAppchaIdTiers() && var9.equals(this.appelCharge.getAppchaNomTiers()))) {
                  double var13 = this.appelCharge.getAppchaTotTtc() + this.appelCharge.getAppchaTotTtcReliquat() + this.appelCharge.getAppchaTotTc() - this.appelCharge.getAppchaTotReglement();
                  if (var13 > 0.0D) {
                     var7 = this.appelCharge.getAppchaIdTiers();
                     var9 = this.appelCharge.getAppchaNomTiers();
                     var1 = var1 + this.appelCharge.getAppchaTotTtc() + this.appelCharge.getAppchaTotReliquat() + this.appelCharge.getAppchaTotTc();
                     var3 += this.appelCharge.getAppchaTotReglement();
                     var5 = var1 - var3;
                     if (var5 != var13) {
                        double var15 = this.appelCharge.getAppchaTotTtc() + this.appelCharge.getAppchaTotTtcReliquat() - var13;
                        this.appelCharge.setAppchaTotReglement(var15);
                     }

                     if (var10 != 0.0D) {
                        this.appelCharge.setVar_tot_avoir(var10);
                     }

                     this.listFactureSelectionne.add(this.appelCharge);
                  }
               }
            }
         }

         if (this.listFactureSelectionne.size() != 0) {
            this.datamodelTransfert.setWrappedData(this.listFactureSelectionne);
            this.reglements = new Reglements();
            this.var_date_trf = new Date();
            this.var_netAPayer = var1 - var3;
            this.montantElmTotBonEnc = 0.0D;
            this.varTypeReg = 0;
            this.choixTypeReglement();
            this.choixCaisseXReglement();
            this.var_aff_action = false;
            this.showModalPanelReglement = true;
         }
      }

   }

   public void choixCaisseXReglement() throws HibernateException, NamingException {
      if (this.var_inputCaisse.equalsIgnoreCase("0")) {
         this.reglements.setRglCodeCaiss("");
         this.reglements.setRglLibCaiss("");
      } else {
         this.selectionBanqueDestination();
      }

      this.verifValide();
   }

   public void selectionBanqueDestination() throws HibernateException, NamingException {
      this.var_affiche_banque_destination = false;
      if (this.var_inputCaisse != null && !this.var_inputCaisse.isEmpty() && this.var_inputCaisse.contains(":")) {
         String[] var1 = this.var_inputCaisse.split(":");
         this.reglements.setRglCodeCaiss(var1[0]);
         this.reglements.setRglLibCaiss(var1[1]);
         this.caissesCommerciales = this.caissesCommercialesDao.selectCaisse(0L, this.reglements.getRglCodeCaiss(), (Session)null);
         if (this.caissesCommerciales != null && this.caissesCommerciales.getCaiMvtCheBnq() == 1) {
            this.var_affiche_banque_destination = true;
         }
      }

   }

   public void verifValide() {
      this.var_affiche_valide = false;
      if (this.montantElmTotBonEnc != 0.0D) {
         this.var_affiche_valide = true;
      }

      this.calculValeurTimbre();
      this.controleEcartRepartitionManuelle();
   }

   public void calulNetPayer() {
      double var1 = 0.0D;
      double var3 = 0.0D;
      this.var_netAPayer = 0.0D;
      new AppelCharge();

      for(int var6 = 0; var6 < this.listFactureSelectionne.size(); ++var6) {
         AppelCharge var5 = (AppelCharge)this.listFactureSelectionne.get(var6);
         if (var5.isVar_select_ligne()) {
            var1 += var5.getAppchaTotTtc();
            var3 += var5.getAppchaTotReglement();
         }
      }

      this.var_netAPayer = var1 - var3;
   }

   public void choixTypeReglement() throws HibernateException, NamingException {
      if (this.var_type_reg != null && !this.var_type_reg.isEmpty() && this.var_type_reg.contains(":")) {
         String[] var1 = this.var_type_reg.split(":");
         this.varTypeReg = Integer.parseInt(var1[0]);
      } else {
         this.varTypeReg = 0;
      }

      if (this.varTypeReg != 1 && this.varTypeReg != 2 && this.varTypeReg != 3 && this.varTypeReg != 4 && this.varTypeReg != 6 && this.varTypeReg != 7) {
         this.var_affiche_banque = false;
      } else {
         this.var_affiche_banque = true;
         if (this.varTypeReg == 1) {
            this.mesBanquesItems.clear();
            new ExercicesComptable();
            ExercicesComptableDao var2 = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
            ExercicesComptable var4 = var2.recupererLastExo((Session)null);
            if (var4 != null) {
               JournauxComptablesDao var3 = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
               this.mesBanquesItems = var3.chargerLesJournaux(var4, 1, this.usersLog.getUsrJrxReserve(), (Session)null);
               this.selectionBanqueDestination();
            }
         }
      }

      this.calculeNomRep();
      this.calculValeurTimbre();
   }

   public void calculValeurTimbre() {
      this.var_netAPayer = 0.0D;
      this.val_timbre = 0.0D;
      this.totalPayerTimbre = 0.0D;
      double var1 = 0.0D;
      if (this.varTypeReg == 0) {
         double var3 = 0.0D;
         int var5 = this.var_date.getYear() + 1900;
         boolean var6 = false;
         if (this.listFactureSelectionne.size() == 1 && this.montantElmTotBonEnc != this.appelCharge.getVarTotTtcGlob()) {
            var1 = this.montantElmTotBonEnc - this.utilNombre.extractionTimbre(this.structureLog, this.appelCharge.getVarTotTtcGlob(), var5, this.structureLog.getStrdevise(), this.var_date);
            var3 = this.montantElmTotBonEnc;
            var6 = true;
         } else {
            var1 = this.montantElmTotBonEnc;
            var3 = var1;
            var6 = false;
         }

         this.val_timbre = this.utilNombre.calculTimbre(this.structureLog, var1, var5, this.structureLog.getStrdevise(), this.var_date);
         this.totalPayerTimbre = var1 + this.val_timbre;
         double var7 = 0.0D;
         if (this.listFactureSelectionne.size() != 0) {
            new AppelCharge();

            for(int var10 = 0; var10 < this.listFactureSelectionne.size(); ++var10) {
               AppelCharge var9 = (AppelCharge)this.listFactureSelectionne.get(var10);
               double var11 = var9.getVarTotTtcGlob();
               if (var6) {
                  var7 = var11 - (var11 - this.utilNombre.extractionTimbre(this.structureLog, var11, var5, this.structureLog.getStrdevise(), this.var_date));
               } else {
                  var7 = this.utilNombre.calculTimbre(this.structureLog, var11, var5, this.structureLog.getStrdevise(), var9.getAppchaDate());
               }

               var9.setVar_fac_timbre(this.utilNombre.myRoundDevise(var7, this.structureLog.getStrdevise()));
               this.var_netAPayer += var11 + var9.getVar_fac_timbre();
            }

            this.datamodelTransfert.setWrappedData(this.listFactureSelectionne);
         }

         if (var6) {
            this.var_ecart_reglement = this.var_netAPayer - (var3 + var7);
         } else {
            this.var_ecart_reglement = this.var_netAPayer - var1 - this.val_timbre;
         }
      } else if (this.varTypeReg != 0) {
         if (this.listFactureSelectionne.size() != 0) {
            new AppelCharge();

            for(int var4 = 0; var4 < this.listFactureSelectionne.size(); ++var4) {
               AppelCharge var13 = (AppelCharge)this.listFactureSelectionne.get(var4);
               var13.setVar_fac_timbre(0.0D);
               this.var_netAPayer += var13.getVarTotTtcGlob();
            }

            this.datamodelTransfert.setWrappedData(this.listFactureSelectionne);
         }

         this.var_ecart_reglement = this.var_netAPayer - this.montantElmTotBonEnc - this.val_timbre;
      }

   }

   public void fermerXReglement() {
      this.showModalPanelReglement = false;
   }

   public void validerXreglement() throws HibernateException, NamingException, ParseException {
      this.reglementsRecu = new Reglements();
      if (this.montantElmTotBonEnc != 0.0D && this.var_netAPayer != 0.0D) {
         new OptionCaisses();
         LireLesoptionsCaisses var2 = new LireLesoptionsCaisses();
         var2.setStrId(this.structureLog.getStrid());
         OptionCaisses var1 = var2.lancer();
         new ExercicesCaisse();
         ExercicesCaisseDao var4 = new ExercicesCaisseDao(this.baseLog, this.utilInitHibernate);
         ExercicesCaisse var3 = var4.recupererLastExo((Session)null);
         if (var3 != null) {
            Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "SyndicAppelCharge");
            Transaction var6 = null;

            try {
               var6 = var5.beginTransaction();
               String var7 = this.appelCharge.getAppchaSerie();
               String var8 = "";
               String var9 = "" + this.varTypeReg;
               if (var1.getChronoReglement() != null && !var1.getChronoReglement().isEmpty() && var1.getChronoReglement().equals("1")) {
                  String var10 = "";
                  if (this.var_inputCaisse.contains(";")) {
                     String[] var11 = this.var_inputCaisse.split(";");
                     var10 = var11[0];
                  }

                  if (var10 != null && !var10.isEmpty()) {
                     var8 = this.calculChrono.numComposeCaisse(this.var_date_trf, 61, var9, var7, var10, var5);
                  } else {
                     var8 = this.calculChrono.numCompose(this.var_date_trf, 61, var9, var7, var5);
                  }
               } else if (var1.getChronoReglement() != null && !var1.getChronoReglement().isEmpty() && var1.getChronoReglement().equals("2")) {
                  var8 = this.calculChrono.numCompose(this.var_date_trf, 61, var7, var5);
               } else {
                  var8 = this.calculChrono.numCompose(this.var_date_trf, 61, var7, var5);
               }

               double var31 = this.montantElmTotBonEnc;
               double var12 = 0.0D;
               double var14 = 0.0D;
               double var16 = 0.0D;
               double var18 = 0.0D;
               new AppelCharge();

               for(int var21 = 0; var21 < this.listFactureSelectionne.size(); ++var21) {
                  AppelCharge var20 = (AppelCharge)this.listFactureSelectionne.get(var21);
                  var16 = var20.getVar_fac_timbre();
                  var18 = var20.getMontantReglementManuel();
                  var12 = 0.0D;
                  long var22 = var20.getAppchaId();
                  var20 = this.appelChargeDao.pourParapheur(var22, var5);
                  if (var20 != null) {
                     if (this.repartitionManuelle) {
                        if (var18 != 0.0D) {
                           this.reglementsRecu = this.generationReglement(this.listFactureSelectionne.size(), var8, var18, var16, var20, var3, var5);
                           var31 -= var18;
                           if (var31 < 0.0D) {
                              var31 = 0.0D;
                              break;
                           }
                        }
                     } else {
                        var12 = var20.getAppchaTotTtc() + var20.getAppchaTotTtcReliquat() + var16 - var20.getAppchaTotReglement();
                        if (var31 <= 0.0D) {
                           break;
                        }

                        if (var12 <= var31) {
                           var14 = var12;
                        } else {
                           var14 = var31;
                        }

                        this.reglementsRecu = this.generationReglement(this.listFactureSelectionne.size(), var8, var14, var16, var20, var3, var5);
                        var31 -= var14;
                        if (var31 < 0.0D) {
                           var31 = 0.0D;
                           break;
                        }
                     }
                  }
               }

               if (var31 > 0.0D) {
                  this.reglements = new Reglements();
                  this.reglements.setRglDateReg(this.memoReglements.getRglDateReg());
                  this.reglements.setRglOperation("13");
                  this.reglements.setRglActivite(this.memoReglements.getRglActivite());
                  this.reglements.setRglBanqueTireur(this.memoReglements.getRglBanqueTireur());
                  this.reglements.setRglBudget(this.memoReglements.getRglBudget());
                  this.reglements.setRglBon(this.memoReglements.getRglBon());
                  this.reglements.setRglCategorie(this.memoReglements.getRglCategorie());
                  this.reglements.setRglCodeCaiss(this.memoReglements.getRglCodeCaiss());
                  this.reglements.setRglLibCaiss(this.memoReglements.getRglLibCaiss());
                  this.reglements.setRglCodeEmetrice(this.memoReglements.getRglCodeEmetrice());
                  this.reglements.setRglCodeReceptrice(this.memoReglements.getRglCodeReceptrice());
                  this.reglements.setRglDateCreation(this.memoReglements.getRglDateCreation());
                  this.reglements.setRglDateImp(this.memoReglements.getRglDateImp());
                  this.reglements.setRglDateTransfert(this.memoReglements.getRglDateTransfert());
                  this.reglements.setRglDateValeur(this.memoReglements.getRglDateValeur());
                  this.reglements.setRglDepartement(this.memoReglements.getRglDepartement());
                  this.reglements.setRglDepense(0.0D);
                  this.reglements.setRglDevise(this.memoReglements.getRglDevise());
                  this.reglements.setRglDossier(this.memoReglements.getRglDossier());
                  this.reglements.setRglFormatDevise(this.memoReglements.getRglFormatDevise());
                  this.reglements.setRglDocument("");
                  this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
                  this.reglements.setRglIdBon(this.memoReglements.getRglIdBon());
                  this.reglements.setRglIdDocument(0L);
                  this.reglements.setRglIdTiers(this.memoReglements.getRglIdTiers());
                  this.reglements.setRglDepotTiers(1);
                  this.reglements.setRglLibEmetrice(this.memoReglements.getRglLibEmetrice());
                  this.reglements.setRglLibReceptrice(this.memoReglements.getRglLibReceptrice());
                  this.reglements.setRglLibelle("(déposit) " + this.memoReglements.getRglLibelle());
                  this.reglements.setRglMode(this.memoReglements.getRglMode());
                  this.reglements.setRglModele(this.memoReglements.getRglModele());
                  this.reglements.setRglNumChqBdx(this.memoReglements.getRglNumChqBdx());
                  this.reglements.setRglNatureDoc(173);
                  this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
                  this.reglements.setRglNomTiers(this.memoReglements.getRglNomTiers());
                  this.reglements.setRglNum(this.memoReglements.getRglNum());
                  this.reglements.setRglObjet("(déposit) " + this.memoReglements.getRglObjet());
                  this.reglements.setRglParc(this.memoReglements.getRglParc());
                  this.reglements.setRglPdv(this.memoReglements.getRglPdv());
                  if (this.memoReglements.getRglTimbre() != 0.0D) {
                     int var23 = this.memoReglements.getRglDateReg().getYear() + 1900;
                     double var24 = this.utilNombre.extractionTimbre(this.structureLog, var31, var23, this.structureLog.getStrdevise(), this.memoReglements.getRglDateReg());
                     this.reglements.setRglTimbre(var24);
                     this.reglements.setRglRecette(var31 - var24);
                  } else {
                     this.reglements.setRglRecette(var31);
                     this.reglements.setRglTimbre(0.0D);
                  }

                  this.reglements.setRglRegion(this.memoReglements.getRglRegion());
                  this.reglements.setRglSecteur(this.memoReglements.getRglSecteur());
                  this.reglements.setRglSerie(this.memoReglements.getRglSerie());
                  this.reglements.setRglService(this.memoReglements.getRglService());
                  this.reglements.setRglSite(this.memoReglements.getRglSite());
                  this.reglements.setRglTrf(this.memoReglements.getRglTrf());
                  this.reglements.setRglTypeReg(this.memoReglements.getRglTypeReg());
                  this.reglements.setRglTypeTiers(this.memoReglements.getRglTypeTiers());
                  this.reglements.setRglUserCreat(this.memoReglements.getRglUserCreat());
                  this.reglements.setRglUserModif(this.memoReglements.getRglUserModif());
                  this.reglements.setRglIdResponsable(this.memoReglements.getRglIdResponsable());
                  this.reglements.setRglNomResponsable(this.memoReglements.getRglNomResponsable());
                  this.reglements.setRglIdCommercial(this.memoReglements.getRglIdCommercial());
                  this.reglements.setRglNomCommercial(this.memoReglements.getRglNomCommercial());
                  this.reglements.setRglIdEquipe(this.memoReglements.getRglIdEquipe());
                  this.reglements.setRglNomEquipe(this.memoReglements.getRglNomEquipe());
                  this.reglements.setRglPeriode(this.memoReglements.getRglPeriode());
                  this.reglements.setRglCle1(this.memoReglements.getRglCle1());
                  this.reglements.setRglCle2(this.memoReglements.getRglCle2());
                  this.reglements.setExercicesCaisse(this.memoReglements.getExercicesCaisse());
                  this.reglementsDao.insert(this.reglements, var5);
                  this.proprietaire = new Tiers();
                  this.proprietaire = this.tiersDao.selectTierD(this.memoReglements.getRglIdTiers(), var5);
                  if (this.proprietaire != null) {
                     double var32 = this.proprietaire.getTiedepotavance() + var31;
                     this.proprietaire.setTiedepotavance(var32);
                     this.tiersDao.modif(this.proprietaire, var5);
                  }
               }

               var6.commit();
            } catch (HibernateException var29) {
               if (var6 != null) {
                  var6.rollback();
               }

               throw var29;
            } finally {
               this.utilInitHibernate.closeSession();
            }

            this.calculFactureTiers((Session)null);
            this.showModalPanelReglement = false;
            if (this.reglementsRecu != null) {
               this.reglements = this.reglementsRecu;
               this.impressionRecu();
            }
         }
      }

   }

   public void controleEcartRepartitionManuelle() {
      if (this.montantElmTotBonEnc != 0.0D) {
         this.var_affiche_valide = false;
         if (this.listFactureSelectionne.size() != 0) {
            this.totManuel = 0.0D;

            for(int var1 = 0; var1 < this.listFactureSelectionne.size(); ++var1) {
               this.totManuel += ((AppelCharge)this.listFactureSelectionne.get(var1)).getMontantReglementManuel();
            }

            this.ecartManuel = this.montantElmTotBonEnc - this.totManuel;
            if (this.ecartManuel >= 0.0D) {
               this.var_affiche_valide = true;
            } else {
               this.var_affiche_valide = false;
            }
         }
      }

   }

   public Reglements generationReglement(int var1, String var2, double var3, double var5, AppelCharge var7, ExercicesCaisse var8, Session var9) throws HibernateException, NamingException {
      this.reglements = new Reglements();
      if (var3 >= var7.getAppchaTotTtc() + var5) {
         this.reglements.setRglOperation("01");
      } else {
         this.reglements.setRglOperation("02");
      }

      this.reglements.setRglActivite((String)null);
      this.reglements.setRglBudget((String)null);
      this.reglements.setRglBanqueTireur(this.var_banque_tireur);
      this.reglements.setRglBon("");
      this.reglements.setRglCategorie(20);
      String[] var10;
      if (this.var_inputCaisse != null && !this.var_inputCaisse.isEmpty() && this.var_inputCaisse.contains(":")) {
         var10 = this.var_inputCaisse.split(":");
         this.reglements.setRglCodeCaiss(var10[0]);
         this.reglements.setRglLibCaiss(var10[1]);
      } else {
         this.reglements.setRglCodeCaiss("");
         this.reglements.setRglLibCaiss("");
      }

      this.reglements.setRglCodeEmetrice("");
      this.reglements.setRglLibEmetrice("");
      if (this.varTypeReg == 1 && this.var_affiche_banque_destination && this.var_banque_destination != null && !this.var_banque_destination.isEmpty() && this.var_banque_destination.contains(":")) {
         var10 = this.var_banque_destination.split(":");
         this.reglements.setRglCodeEmetrice(var10[0]);
         this.reglements.setRglLibEmetrice(var10[1]);
      }

      this.reglements.setRglCodeReceptrice("");
      this.reglements.setRglLibReceptrice("");
      this.reglements.setRglDateCreation(new Date());
      this.reglements.setRglDateImp((Date)null);
      this.reglements.setRglDateTransfert((Date)null);
      this.reglements.setRglDateValeur((Date)null);
      this.reglements.setRglDateReg(this.var_date_trf);
      this.reglements.setRglDepartement("");
      this.reglements.setRglDepense(0.0D);
      this.reglements.setRglDevise(var7.getAppchaDevise());
      this.reglements.setRglDossier("");
      this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
      this.reglements.setRglDocument(var7.getAppchaNum());
      this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
      this.reglements.setRglIdBon(0L);
      this.reglements.setRglIdDocument(var7.getAppchaId());
      this.reglements.setRglIdTiers(var7.getAppchaIdTiers());
      this.reglements.setRglDepotTiers(0);
      this.reglements.setRglLibelle(var7.getAppchaObject());
      this.reglements.setRglMode("" + this.varTypeReg);
      this.reglements.setRglModele(this.var_modele_trf);
      this.reglements.setRglNatureDoc(this.nature);
      this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
      this.reglements.setRglNomTiers(var7.getAppchaNomTiers());
      if (this.optionsVentes.getDecrmtPrsChrStock() != null && this.optionsVentes.getDecrmtPrsChrStock().equals("2")) {
         this.reglements.setRglIdContact(var7.getAppchaIdContact());
         this.reglements.setRglNomContact(var7.getVar_nomContact());
      } else {
         this.reglements.setRglIdContact(0L);
         this.reglements.setRglNomContact("");
      }

      this.reglements.setRglNum(var2);
      this.reglements.setRglNumChqBdx(this.var_num_cheque);
      this.reglements.setRglObjet(this.var_objet);
      this.reglements.setRglParc("");
      this.reglements.setRglPdv("");
      double var17 = 0.0D;
      if (var1 == 1 && this.montantElmTotBonEnc > var7.getAppchaTotTtc()) {
         var17 = var3 - var5;
      } else {
         var17 = var3;
      }

      this.reglements.setRglRecette(var17);
      double var12 = 0.0D;
      if (var5 != 0.0D) {
         int var14 = var7.getAppchaDate().getYear() + 1900;
         var12 = this.utilNombre.calculTimbre(this.structureLog, var17, var14, this.structureLog.getStrdevise(), this.reglements.getRglDateReg());
         this.reglements.setRglTimbre(var12);
      } else {
         this.reglements.setRglTimbre(0.0D);
      }

      this.reglements.setRglRegion("");
      this.reglements.setRglSecteur("");
      this.reglements.setRglSerie(var7.getAppchaSerie());
      this.reglements.setRglService("");
      this.reglements.setRglSite("");
      this.reglements.setRglTrf(0);
      this.reglements.setRglTypeTiers(0);
      this.reglements.setRglTypeReg(this.varTypeReg);
      this.reglements.setRglUserCreat(this.usersLog.getUsrid());
      this.reglements.setRglUserModif(0L);
      this.reglements.setRglIdResponsable(var7.getAppchaIdResponsable());
      this.reglements.setRglNomResponsable(var7.getAppchaNomResponsable());
      this.reglements.setRglIdCommercial(var7.getAppchaIdCommercial());
      this.reglements.setRglNomCommercial(var7.getAppchaNomCommercial());
      this.reglements.setRglIdEquipe(0L);
      this.reglements.setRglNomEquipe((String)null);
      String var18 = "";
      if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
         var18 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
      } else {
         var18 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
      }

      String var15 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
      this.reglements.setRglPeriode(var18 + ":" + var15);
      this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
      String var16 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
      this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var16);
      this.reglements.setExercicesCaisse(var8);
      this.reglements.setTotalFacture(var7.getAppchaTotTtc());
      this.reglements = this.reglementsDao.insert(this.reglements, var9);
      this.memoReglements = this.reglements;
      if (var7 != null) {
         var7.setAppchaTotReglement(var7.getAppchaTotReglement() + var3);
         var7.setAppchaTotTimbre(var7.getAppchaTotTimbre() + var5);
         if (var7.getAppchaTotReglement() >= var7.getAppchaTotTtc()) {
            var7.setAppchaSolde(1);
         } else {
            var7.setAppchaSolde(0);
         }

         var7.setAppchaDateLastReg(this.reglements.getRglDateReg());
         this.appelChargeDao.modif(var7, var9);
      }

      return this.reglements;
   }

   public int calculformatDevise(String var1) {
      byte var2 = 0;
      if (!var1.equals("XAF") && !var1.equals("XOF")) {
         if (var1.equals("EUR") || var1.equals("CHF")) {
            var2 = 1;
         }
      } else {
         var2 = 2;
      }

      return var2;
   }

   public void calculeNomRep() {
      if (this.varTypeReg != 0 && this.varTypeReg != 11) {
         if (this.varTypeReg != 1 && this.varTypeReg != 10) {
            if (this.varTypeReg == 2) {
               this.nomRepMod = "virements";
            } else if (this.varTypeReg == 3) {
               this.nomRepMod = "traites";
            } else if (this.varTypeReg == 4) {
               this.nomRepMod = "cartes";
            } else if (this.varTypeReg == 5) {
               this.nomRepMod = "transferts";
            } else if (this.varTypeReg == 6) {
               this.nomRepMod = "epaiements";
            } else if (this.varTypeReg == 7) {
               this.nomRepMod = "credocs";
            } else if (this.varTypeReg == 8) {
               this.nomRepMod = "factors";
            } else if (this.varTypeReg == 9) {
               this.nomRepMod = "compenses";
            } else if (this.varTypeReg == 12) {
               this.nomRepMod = "lettres_garantie";
            } else if (this.varTypeReg == 13) {
               this.nomRepMod = "prelevements";
            } else if (this.varTypeReg == 14) {
               this.nomRepMod = "alcoins";
            } else {
               this.nomRepMod = "";
            }
         } else {
            this.nomRepMod = "cheques";
         }
      } else {
         this.nomRepMod = "especes";
      }

      this.chargerModeleDocument();
   }

   public void chargerModeleDocument() {
      this.mesModesleRecus = new ArrayList();
      if (this.nomRepMod != null && !this.nomRepMod.isEmpty()) {
         String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "documentsRecu" + File.separator + this.nomRepMod;
         File var2 = new File(var1);
         if (!var2.exists()) {
            var2.mkdir();
         }

         String[] var3 = var2.list();
         if (var3 != null) {
            var3 = this.triAlphabetique(var3, var3.length);

            for(int var4 = 0; var4 < var3.length; ++var4) {
               if (var3[var4].endsWith("jasper")) {
                  String var5 = var3[var4].substring(0, var3[var4].indexOf("."));
                  this.mesModesleRecus.add(new SelectItem(var5));
               }
            }
         }
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

   public String calculeCheminRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "documentSyndic" + File.separator + "appel_charge" + File.separator;
      return var2;
   }

   public String calculeCheminSousRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "sous_rapport" + File.separator;
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
            var4 = new File(this.calculeCheminSousRapport(var1) + "formatFacture.jpg");
            if (var4.exists()) {
               var3 = "formatFacture.jpg";
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
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatFacture.jpg");
         if (var4.exists()) {
            var3 = "formatFacture.jpg";
         }
      }

      return var3;
   }

   public List calculeImpressionCommun(int var1, Tiers var2, Bien var3, Date var4, Date var5, Session var6) throws HibernateException, NamingException {
      new ArrayList();
      ArrayList var8 = new ArrayList();
      new ArrayList();
      List var7;
      if (var1 == 0) {
         var7 = this.appelChargeDao.rechercheNonSoldeTiersMode(var2.getTieid(), var3.getBieId(), 99, (String)this.inpSerie, var4, var6);
      } else if (var4 != null && var5 != null) {
         var7 = this.appelChargeDao.rechercheNonSoldeTiersMode(var2.getTieid(), var3.getBieId(), 99, (Date)var4, var5, var6);
      } else {
         var7 = this.appelChargeDao.rechercheNonSoldeTiersMode(var2.getTieid(), var3.getBieId(), 99, var6);
      }

      AppelCharge var12;
      if (var7.size() != 0) {
         new AppelCharge();

         for(int var11 = 0; var11 < var7.size(); ++var11) {
            AppelCharge var10 = (AppelCharge)var7.get(var11);
            if (this.appelCharge.getAppchaDateFin() == null) {
               this.appelCharge.setAppchaDateFin(this.appelCharge.getAppchaDateDebut());
            }

            if (var10.getAppchaDateFin() == null) {
               var10.setAppchaDateFin(var10.getAppchaDateDebut());
            }

            if (this.appelCharge == null || this.appelCharge.getAppchaId() == 0L || this.exercicesVentes.getExevteDateDebut().compareTo(var10.getAppchaDate()) <= 0 && this.appelCharge.getAppchaDateFin().compareTo(var10.getAppchaDate()) >= 0) {
               var10.setMontantLettre(this.utilNombre.begin(var10.getAppchaTotTtc() + var10.getAppchaTotTtcReliquat(), var10.getAppchaDevise()));
               if (var10.getAppchaBien() != null && !var10.getAppchaBien().isEmpty() && var10.getAppchaBien().equals("AN")) {
                  var10.setAppchaBien("AN");
               } else {
                  var10.setAppchaBien(var3.getBieNum());
               }

               var10.setBieNom(var3.getBieNom());
               var10.setBieAdresse(var3.getBieAdresse());
               var10.setBieRue(var3.getBieRue());
               var10.setBieLot(var3.getBieLot());
               var10.setBieIlot(var3.getBieIlot());
               var10.setBieBatiment(var3.getBieBatiment());
               var10.setBiePorte(var3.getBiePorte());
               var10.setBieEtage(var3.getBieEtage());
               var10.setBieEscalier(var3.getBieEscalier());
               var10.setBieAscenseur(var3.getBieAscenseur());
               var10.setBieQuartier(var3.getBieQuartier());
               var10.setBieCommune(var3.getBieCommune());
               var10.setBieDepart(var3.getBieDepart());
               var10.setBieZone(var3.getBieZone());
               var10.setBieVille(var3.getBieVille());
               if (this.tiers != null) {
                  var10.setTieadresse(this.tiers.getTieadresse());
                  var10.setTierue(this.tiers.getTierue());
                  var10.setTielot(this.tiers.getTielot());
                  var10.setTiebatiment(this.tiers.getTiebatiment());
                  var10.setTieporte(this.tiers.getTieporte());
                  var10.setTieetage(this.tiers.getTieetage());
                  var10.setTiequartier(this.tiers.getTiequartier());
                  var10.setTiecommune(this.tiers.getTiecommune());
                  var10.setTiedepart(this.tiers.getTiedepart());
                  var10.setTiezone(this.tiers.getTiezone());
                  var10.setTieville(this.tiers.getTieville());
               } else {
                  var10.setTieadresse("");
                  var10.setTierue("");
                  var10.setTielot("");
                  var10.setTiebatiment("");
                  var10.setTieporte("");
                  var10.setTieetage("");
                  var10.setTiequartier("");
                  var10.setTiecommune("");
                  var10.setTiedepart("");
                  var10.setTiezone("");
                  var10.setTieville("");
               }

               if (var10.getAppchaBien() != null && !var10.getAppchaBien().isEmpty() && var10.getAppchaBien().equals("AN") && var10.getAppchaTotReglement() != 0.0D) {
                  var10.setAppchaTotTtc(var10.getAppchaTotReglement() * -1.0D);
                  var10.setAppchaTotReglement(0.0D);
               }

               var8.add(var10);
               if (var10.getAppchaTotTtcReliquat() != 0.0D && var10 != null) {
                  var12 = new AppelCharge();
                  var12.setAppchaAnneeBudget(var10.getAppchaAnneeBudget());
                  var12.setAppchaArrondiReg(var10.getAppchaArrondiReg());
                  var12.setAppchaAnneeBudget(var10.getAppchaAnneeBudget());
                  var12.setAppchaBanque(var10.getAppchaBanque());
                  var12.setAppchaBien(var10.getAppchaBien());
                  var12.setAppchaBudget(var10.getAppchaBudget());
                  var12.setAppchaCivilContact(var10.getAppchaCivilContact());
                  var12.setAppchaCivilTiers(var10.getAppchaCivilTiers());
                  var12.setAppchaCodeTva(var10.getAppchaCodeTva());
                  var12.setAppchaConditionReg(var10.getAppchaConditionReg());
                  var12.setAppchaContrat(var10.getAppchaContrat());
                  var12.setAppchaDate(var10.getAppchaDate());
                  var12.setAppchaDateDebut(var10.getAppchaDateDebut());
                  var12.setAppchaDateFin(var10.getAppchaDateFin());
                  var12.setAppchaDevise(var10.getAppchaDevise());
                  var12.setAppchaEtat(0);
                  var12.setAppchaId(var10.getAppchaId());
                  var12.setAppchaIdBien(var10.getAppchaIdBien());
                  var12.setAppchaIdBudget(var10.getAppchaIdBudget());
                  var12.setAppchaIdImmeuble(var10.getAppchaIdImmeuble());
                  var12.setAppchaIdTiers(var10.getAppchaIdTiers());
                  var12.setAppchaImmeuble(var10.getAppchaImmeuble());
                  var12.setAppchaMlBien(var10.getAppchaMlBien());
                  var12.setAppchaMlImmeuble(var10.getAppchaMlImmeuble());
                  var12.setAppchaMode(var10.getAppchaMode());
                  var12.setAppchaNomContact(var10.getAppchaNomContact());
                  var12.setAppchaNomTiers(var10.getAppchaNomTiers());
                  var12.setAppchaNum(var10.getAppchaNum());
                  var12.setAppchaNumTrf(var10.getAppchaNumTrf());
                  var12.setAppchaObject(var10.getAppchaObject());
                  var12.setAppchaPeriode(var10.getAppchaPeriode());
                  var12.setAppchaSerie(var10.getAppchaSerie());
                  var12.setAppchaSolde(var10.getAppchaSolde());
                  var12.setAppchaTotAnnuel(var10.getAppchaTotAnnuel());
                  var12.setAppchaTotBudget(var10.getAppchaTotBudget());
                  var12.setAppchaTotHt(var10.getAppchaTotHt());
                  var12.setAppchaTotHtReliquat(var10.getAppchaTotHtReliquat());
                  var12.setAppchaTotReglement(var10.getAppchaTotReglement());
                  var12.setAppchaTotTimbre(var10.getAppchaTotTimbre());
                  var12.setAppchaTotTtc(var10.getAppchaTotTtc());
                  var12.setAppchaTotTtcReliquat(var10.getAppchaTotTtcReliquat());
                  var12.setAppchaObject("Régularisation exercice " + (Integer.parseInt(var12.getAppchaAnneeBudget()) - 1));
                  if (var12.getAppchaTotTtcReliquat() < 0.0D) {
                     var12.setAppchaTotTtc(var12.getAppchaTotTtcReliquat());
                     var12.setAppchaTotReglement(0.0D);
                  } else {
                     var12.setAppchaTotTtc(var12.getAppchaTotTtcReliquat());
                     var12.setAppchaTotReglement(0.0D);
                  }

                  var8.add(var12);
               }
            }
         }
      }

      List var9 = this.reglementsDao.chargeDepositClient(var2.getTieid(), var4, var5, var6);
      if (var9.size() != 0) {
         String var16 = "";
         if (this.inpClient != null && !this.inpClient.isEmpty()) {
            String[] var17 = this.inpClient.split(":");
            var16 = var17[0];
         }

         new Reglements();
         new AppelCharge();
         boolean var13 = false;

         for(int var14 = 0; var14 < var9.size(); ++var14) {
            Reglements var18 = (Reglements)var9.get(var14);
            var13 = false;
            if (var18.getRglIdDocument() != 0L) {
               var12 = this.appelChargeDao.pourParapheur(var18.getRglIdDocument(), var6);
               if (var12 != null && (var16 == null || var16.isEmpty() || var12.getAppchaImmeuble().equals(var16))) {
                  var13 = true;
               }
            } else {
               var13 = true;
            }

            if (var13) {
               if (this.appelCharge.getAppchaDateFin() == null) {
                  this.appelCharge.setAppchaDateFin(this.appelCharge.getAppchaDateDebut());
               }

               if ((this.appelCharge == null || this.appelCharge.getAppchaId() == 0L || this.exercicesVentes.getExevteDateDebut().compareTo(var18.getRglDateReg()) <= 0 && this.appelCharge.getAppchaDateFin().compareTo(var18.getRglDateReg()) >= 0) && var18.getRglRecette() != 0.0D) {
                  AppelCharge var15 = new AppelCharge();
                  var15.setAppchaBien(var3.getBieNum());
                  var15.setBieNom(var3.getBieNom());
                  var15.setBieAdresse(var3.getBieAdresse());
                  var15.setBieRue(var3.getBieRue());
                  var15.setBieLot(var3.getBieLot());
                  var15.setBieIlot(var3.getBieIlot());
                  var15.setBieBatiment(var3.getBieBatiment());
                  var15.setBiePorte(var3.getBiePorte());
                  var15.setBieEtage(var3.getBieEtage());
                  var15.setBieEscalier(var3.getBieEscalier());
                  var15.setBieAscenseur(var3.getBieAscenseur());
                  var15.setBieQuartier(var3.getBieQuartier());
                  var15.setBieCommune(var3.getBieCommune());
                  var15.setBieDepart(var3.getBieDepart());
                  var15.setBieZone(var3.getBieZone());
                  var15.setBieVille(var3.getBieVille());
                  if (this.tiers != null) {
                     var15.setTieadresse(this.tiers.getTieadresse());
                     var15.setTierue(this.tiers.getTierue());
                     var15.setTielot(this.tiers.getTielot());
                     var15.setTiebatiment(this.tiers.getTiebatiment());
                     var15.setTieporte(this.tiers.getTieporte());
                     var15.setTieetage(this.tiers.getTieetage());
                     var15.setTiequartier(this.tiers.getTiequartier());
                     var15.setTiecommune(this.tiers.getTiecommune());
                     var15.setTiedepart(this.tiers.getTiedepart());
                     var15.setTiezone(this.tiers.getTiezone());
                     var15.setTieville(this.tiers.getTieville());
                  } else {
                     var15.setTieadresse("");
                     var15.setTierue("");
                     var15.setTielot("");
                     var15.setTiebatiment("");
                     var15.setTieporte("");
                     var15.setTieetage("");
                     var15.setTiequartier("");
                     var15.setTiecommune("");
                     var15.setTiedepart("");
                     var15.setTiezone("");
                     var15.setTieville("");
                  }

                  var15.setAppchaIdBien(var3.getBieId());
                  var15.setAppchaImmeuble(var3.getBieNom());
                  var15.setAppchaIdTiers(var2.getTieid());
                  var15.setAppchaNomTiers(var2.getPatronyme());
                  var15.setAppchaNumTrf(var18.getRglNum());
                  var15.setAppchaId(var18.getRglId());
                  var15.setAppchaNum("");
                  var15.setAppchaMode(var18.getRglTypeReg() + 20);
                  var15.setAppchaTotReglement(var18.getRglRecette());
                  var15.setAppchaTotTimbre(var18.getRglTimbre());
                  var15.setAppchaDate(var18.getRglDateReg());
                  var15.setAppchaDateDebut(var18.getRglDateReg());
                  if (var18.getRglDepotTiers() == 1) {
                     var15.setAppchaObject("Avoir");
                  } else {
                     var15.setAppchaObject(var18.getRglLibelle());
                  }

                  var8.add(var15);
               }
            }
         }
      }

      return var8;
   }

   public List optimisationImpression(List var1) {
      ArrayList var2 = new ArrayList();
      if (var1.size() != 0) {
         new AppelCharge();
         new AppelCharge();

         AppelCharge var4;
         int var5;
         for(var5 = 0; var5 < var1.size(); ++var5) {
            AppelCharge var3 = (AppelCharge)var1.get(var5);
            if (var3.getAppchaNum() != null && !var3.getAppchaNum().isEmpty()) {
               for(int var6 = 0; var6 < var1.size(); ++var6) {
                  var4 = (AppelCharge)var1.get(var6);
                  if (var4.getAppchaNumTrf() != null && !var4.getAppchaNumTrf().isEmpty() && var4.getAppchaTotReglement() == var3.getAppchaTotTtc()) {
                     var3.setAppchaTotReglement(var4.getAppchaTotReglement());
                     break;
                  }
               }

               var3.setIMPappchaAnneeBudget(this.appelCharge.getAppchaAnneeBudget());
               var3.setIMPappchaBanque(this.appelCharge.getAppchaBanque());
               var3.setIMPappchaBien(this.appelCharge.getAppchaBien());
               var3.setIMPappchaBudget(this.appelCharge.getAppchaBudget());
               var3.setIMPappchaCivilContact(this.appelCharge.getAppchaCivilContact());
               var3.setIMPappchaCivilTiers(this.appelCharge.getAppchaCivilTiers());
               var3.setIMPappchaCodeTva(this.appelCharge.getAppchaCodeTva());
               var3.setIMPappchaConditionReg(this.appelCharge.getAppchaConditionReg());
               var3.setIMPappchaContrat(this.appelCharge.getAppchaContrat());
               var3.setIMPappchaDate(this.appelCharge.getAppchaDate());
               var3.setIMPappchaDateDebut(this.appelCharge.getAppchaDateDebut());
               var3.setIMPappchaDateFin(this.appelCharge.getAppchaDateFin());
               var3.setIMPappchaDevise(this.appelCharge.getAppchaDevise());
               var3.setIMPappchaEtat(this.appelCharge.getAppchaEtat());
               var3.setIMPappchaExoTva(this.appelCharge.getAppchaExoTva());
               var3.setIMPappchaFormule1(this.appelCharge.getAppchaFormule1());
               var3.setIMPappchaFormule2(this.appelCharge.getAppchaFormule2());
               var3.setIMPappchaIdBien(this.appelCharge.getAppchaIdBien());
               var3.setIMPappchaIdBudget(this.appelCharge.getAppchaIdBudget());
               var3.setIMPappchaIdCommercial(this.appelCharge.getAppchaIdCommercial());
               var3.setIMPappchaIdContact(this.appelCharge.getAppchaIdContact());
               var3.setIMPappchaIdImmeuble(this.appelCharge.getAppchaIdImmeuble());
               var3.setIMPappchaIdResponsable(this.appelCharge.getAppchaIdResponsable());
               var3.setIMPappchaIdTiers(this.appelCharge.getAppchaIdTiers());
               var3.setIMPappchaInfo1(this.appelCharge.getAppchaInfo1());
               var3.setIMPappchaInfo10(this.appelCharge.getAppchaInfo10());
               var3.setIMPappchaInfo2(this.appelCharge.getAppchaInfo2());
               var3.setIMPappchaInfo3(this.appelCharge.getAppchaInfo3());
               var3.setIMPappchaInfo4(this.appelCharge.getAppchaInfo4());
               var3.setIMPappchaInfo5(this.appelCharge.getAppchaInfo5());
               var3.setIMPappchaInfo6(this.appelCharge.getAppchaInfo6());
               var3.setIMPappchaInfo7(this.appelCharge.getAppchaInfo7());
               var3.setIMPappchaInfo8(this.appelCharge.getAppchaInfo8());
               var3.setIMPappchaInfo9(this.appelCharge.getAppchaInfo9());
               var3.setIMPappchaJournalReg(this.appelCharge.getAppchaJournalReg());
               var3.setIMPappchaMlBien(this.appelCharge.getAppchaMlBien());
               var3.setIMPappchaMlImmeuble(this.appelCharge.getAppchaMlImmeuble());
               var3.setIMPappchaMode(this.appelCharge.getAppchaMode());
               var3.setIMPappchaModeReg(this.appelCharge.getAppchaModeReg());
               var3.setIMPappchaNbJourReg(this.appelCharge.getAppchaNbJourReg());
               var3.setIMPappchaNomCommercial(this.appelCharge.getAppchaNomCommercial());
               var3.setIMPappchaNomContact(this.appelCharge.getAppchaNomContact());
               var3.setIMPappchaNomResponsable(this.appelCharge.getAppchaNomResponsable());
               var3.setIMPappchaNomTiers(this.appelCharge.getAppchaNomTiers());
               var3.setIMPappchaNum(this.appelCharge.getAppchaNum());
               var3.setIMPappchaNumAvoir(this.appelCharge.getAppchaNumAvoir());
               var3.setIMPappchaNumTrf(this.appelCharge.getAppchaNumTrf());
               var3.setIMPappchaObject(this.appelCharge.getAppchaObject());
               var3.setIMPappchaObservation(this.appelCharge.getAppchaObservation());
               var3.setIMPappchaPeriode(this.appelCharge.getAppchaPeriode());
               var3.setIMPappchaPu(this.appelCharge.getAppchaPu());
               var3.setIMPappchaPuReliquat(this.appelCharge.getAppchaPuReliquat());
               var3.setIMPappchaSerie(this.appelCharge.getAppchaSerie());
               var3.setIMPappchaSolde(this.appelCharge.getAppchaSolde());
               var3.setIMPappchaSource(this.appelCharge.getAppchaSource());
               var3.setIMPappchaTauxRemise(this.appelCharge.getAppchaTauxRemise());
               var3.setIMPappchaTauxTva(this.appelCharge.getAppchaTauxTva());
               var3.setIMPappchaTotAnnuel(this.appelCharge.getAppchaTotAnnuel());
               var3.setIMPappchaTotBudget(this.appelCharge.getAppchaTotBudget());
               var3.setIMPappchaTotHt(this.appelCharge.getAppchaTotHt());
               var3.setIMPappchaTotHtReliquat(this.appelCharge.getAppchaTotHtReliquat());
               var3.setIMPappchaTotReglement(this.appelCharge.getAppchaTotReglement());
               var3.setIMPappchaTotReliquat(this.appelCharge.getAppchaTotReliquat());
               var3.setIMPappchaTotRemise(this.appelCharge.getAppchaTotRemise());
               var3.setIMPappchaTotTimbre(this.appelCharge.getAppchaTotTimbre());
               var3.setIMPappchaTotTc(this.appelCharge.getAppchaTotTc());
               var3.setIMPappchaTotTtc(this.appelCharge.getAppchaTotTtc());
               var3.setIMPappchaTotTtcReliquat(this.appelCharge.getAppchaTotTtcReliquat());
               var3.setIMPappchaTotTva(this.appelCharge.getAppchaTotTva());
               var3.setIMPappchaTotTvaReliquat(this.appelCharge.getAppchaTotTvaReliquat());
               var3.setIMPappchaTypeReg(this.appelCharge.getAppchaTypeReg());
               var2.add(var3);
            }
         }

         for(var5 = 0; var5 < var1.size(); ++var5) {
            var4 = (AppelCharge)var1.get(var5);
            if (var4.getAppchaObject() != null && !var4.getAppchaObject().isEmpty() && var4.getAppchaObject().equals("Avoir") && var4.getAppchaNumTrf() != null && !var4.getAppchaNumTrf().isEmpty()) {
               boolean var7 = false;
               if (!var7) {
                  var4.setIMPappchaAnneeBudget(this.appelCharge.getAppchaAnneeBudget());
                  var4.setIMPappchaBanque(this.appelCharge.getAppchaBanque());
                  var4.setIMPappchaBien(this.appelCharge.getAppchaBien());
                  var4.setIMPappchaBudget(this.appelCharge.getAppchaBudget());
                  var4.setIMPappchaCivilContact(this.appelCharge.getAppchaCivilContact());
                  var4.setIMPappchaCivilTiers(this.appelCharge.getAppchaCivilTiers());
                  var4.setIMPappchaCodeTva(this.appelCharge.getAppchaCodeTva());
                  var4.setIMPappchaConditionReg(this.appelCharge.getAppchaConditionReg());
                  var4.setIMPappchaContrat(this.appelCharge.getAppchaContrat());
                  var4.setIMPappchaDate(this.appelCharge.getAppchaDate());
                  var4.setIMPappchaDateDebut(this.appelCharge.getAppchaDateDebut());
                  var4.setIMPappchaDateFin(this.appelCharge.getAppchaDateFin());
                  var4.setIMPappchaDevise(this.appelCharge.getAppchaDevise());
                  var4.setIMPappchaEtat(this.appelCharge.getAppchaEtat());
                  var4.setIMPappchaExoTva(this.appelCharge.getAppchaExoTva());
                  var4.setIMPappchaFormule1(this.appelCharge.getAppchaFormule1());
                  var4.setIMPappchaFormule2(this.appelCharge.getAppchaFormule2());
                  var4.setIMPappchaIdBien(this.appelCharge.getAppchaIdBien());
                  var4.setIMPappchaIdBudget(this.appelCharge.getAppchaIdBudget());
                  var4.setIMPappchaIdCommercial(this.appelCharge.getAppchaIdCommercial());
                  var4.setIMPappchaIdContact(this.appelCharge.getAppchaIdContact());
                  var4.setIMPappchaIdImmeuble(this.appelCharge.getAppchaIdImmeuble());
                  var4.setIMPappchaIdResponsable(this.appelCharge.getAppchaIdResponsable());
                  var4.setIMPappchaIdTiers(this.appelCharge.getAppchaIdTiers());
                  var4.setIMPappchaInfo1(this.appelCharge.getAppchaInfo1());
                  var4.setIMPappchaInfo10(this.appelCharge.getAppchaInfo10());
                  var4.setIMPappchaInfo2(this.appelCharge.getAppchaInfo2());
                  var4.setIMPappchaInfo3(this.appelCharge.getAppchaInfo3());
                  var4.setIMPappchaInfo4(this.appelCharge.getAppchaInfo4());
                  var4.setIMPappchaInfo5(this.appelCharge.getAppchaInfo5());
                  var4.setIMPappchaInfo6(this.appelCharge.getAppchaInfo6());
                  var4.setIMPappchaInfo7(this.appelCharge.getAppchaInfo7());
                  var4.setIMPappchaInfo8(this.appelCharge.getAppchaInfo8());
                  var4.setIMPappchaInfo9(this.appelCharge.getAppchaInfo9());
                  var4.setIMPappchaJournalReg(this.appelCharge.getAppchaJournalReg());
                  var4.setIMPappchaMlBien(this.appelCharge.getAppchaMlBien());
                  var4.setIMPappchaMlImmeuble(this.appelCharge.getAppchaMlImmeuble());
                  var4.setIMPappchaMode(this.appelCharge.getAppchaMode());
                  var4.setIMPappchaModeReg(this.appelCharge.getAppchaModeReg());
                  var4.setIMPappchaNbJourReg(this.appelCharge.getAppchaNbJourReg());
                  var4.setIMPappchaNomCommercial(this.appelCharge.getAppchaNomCommercial());
                  var4.setIMPappchaNomContact(this.appelCharge.getAppchaNomContact());
                  var4.setIMPappchaNomResponsable(this.appelCharge.getAppchaNomResponsable());
                  var4.setIMPappchaNomTiers(this.appelCharge.getAppchaNomTiers());
                  var4.setIMPappchaNum(this.appelCharge.getAppchaNum());
                  var4.setIMPappchaNumAvoir(this.appelCharge.getAppchaNumAvoir());
                  var4.setIMPappchaNumTrf(this.appelCharge.getAppchaNumTrf());
                  var4.setIMPappchaObject(this.appelCharge.getAppchaObject());
                  var4.setIMPappchaObservation(this.appelCharge.getAppchaObservation());
                  var4.setIMPappchaPeriode(this.appelCharge.getAppchaPeriode());
                  var4.setIMPappchaPu(this.appelCharge.getAppchaPu());
                  var4.setIMPappchaPuReliquat(this.appelCharge.getAppchaPuReliquat());
                  var4.setIMPappchaSerie(this.appelCharge.getAppchaSerie());
                  var4.setIMPappchaSolde(this.appelCharge.getAppchaSolde());
                  var4.setIMPappchaSource(this.appelCharge.getAppchaSource());
                  var4.setIMPappchaTauxRemise(this.appelCharge.getAppchaTauxRemise());
                  var4.setIMPappchaTauxTva(this.appelCharge.getAppchaTauxTva());
                  var4.setIMPappchaTotAnnuel(this.appelCharge.getAppchaTotAnnuel());
                  var4.setIMPappchaTotBudget(this.appelCharge.getAppchaTotBudget());
                  var4.setIMPappchaTotHt(this.appelCharge.getAppchaTotHt());
                  var4.setIMPappchaTotHtReliquat(this.appelCharge.getAppchaTotHtReliquat());
                  var4.setIMPappchaTotReglement(this.appelCharge.getAppchaTotReglement());
                  var4.setIMPappchaTotReliquat(this.appelCharge.getAppchaTotReliquat());
                  var4.setIMPappchaTotRemise(this.appelCharge.getAppchaTotRemise());
                  var4.setIMPappchaTotTimbre(this.appelCharge.getAppchaTotTimbre());
                  var4.setIMPappchaTotTc(this.appelCharge.getAppchaTotTc());
                  var4.setIMPappchaTotTtc(this.appelCharge.getAppchaTotTtc());
                  var4.setIMPappchaTotTtcReliquat(this.appelCharge.getAppchaTotTtcReliquat());
                  var4.setIMPappchaTotTva(this.appelCharge.getAppchaTotTva());
                  var4.setIMPappchaTotTvaReliquat(this.appelCharge.getAppchaTotTvaReliquat());
                  var4.setIMPappchaTypeReg(this.appelCharge.getAppchaTypeReg());
                  var2.add(var4);
               }
            }
         }
      }

      return var2;
   }

   public boolean majDateImpression(String var1) throws HibernateException, NamingException {
      boolean var2 = false;
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         if (this.appelCharge.getAppchaDateImp() != null) {
            var2 = true;
         }

         this.appelCharge.setAppchaDateImp(new Date());
         if (this.appelCharge.getAppchaEtat() == 0 && this.appelCharge.getAppchaEtatVal() == 0 && this.usersChrono.getUsrchrValidation() == 1) {
            this.appelCharge.setAppchaEtat(1);
         }

         this.appelCharge.setAppchaModeleImp(var1);
         this.appelCharge = this.appelChargeDao.modif(this.appelCharge, var3);
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
            boolean var11 = false;
            new ArrayList();
            List var12 = this.calculeImpressionCommun(1, this.tiers, this.bien, (Date)null, (Date)null, (Session)null);
            JRBeanCollectionDataSource var13 = new JRBeanCollectionDataSource(this.optimisationImpression(var12));
            var1.setjRBeanCollectionDataSource(var13);
            var1.setRapport(var3);
            var1.setEntete("Impression facture");
            var1.setPageGarde((String)null);
            var1.setAnnexe1((String)null);
            var1.setAnnexe2((String)null);
            var1.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid()));
            var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid(), this.appelCharge.getAppchaEtat()));
            var1.setDuplicata("" + var11);
            var1.setInfoOrigineDoc((String)null);
            var1.setNbDecQte(this.optionsVentes.getNbDecQte());
            var1.setNbDecPu(this.optionsVentes.getNbDecPu());
            this.appelCharge.setAppchaDevise(this.structureLog.getStrdevise());
            if (!this.appelCharge.getAppchaDevise().equals("XOF") && !this.appelCharge.getAppchaDevise().equals("XAF")) {
               if (this.appelCharge.getAppchaDevise().equals("EUR")) {
                  var1.setNbCar(1);
               } else {
                  var1.setNbCar(0);
               }
            } else {
               var1.setNbCar(2);
            }

            if (this.appelCharge.getAppchaDevise().equals(this.structureLog.getStrdevise())) {
               var1.setTaux(1.0F);
            } else {
               var1.setTaux(this.tauxPrint);
               double var14 = this.utilNombre.myRound(this.appelCharge.getAppchaTotTtc() / (double)this.tauxPrint, 2);
               this.montant_lettre = this.utilNombre.begin(var14, this.devisePrint);
            }

            var1.setMontant_lettre("");
            var1.setFormat(var5);
            var1.setEmetteur(var6);
            var1.setDestinataire(var7);
            var1.setDestinataireCC(var8);
            var1.setDestinataireCCI(var9);
            var1.setCorpsMail(var10);
            var1.setIdResponsable(this.appelCharge.getAppchaIdResponsable());
            var1.setIdCommercial(this.appelCharge.getAppchaIdCommercial());
            var1.setTiersSelectionne((Tiers)null);
            var1.setNumDoc(this.appelCharge.getAppchaNum());
            var1.setNature(this.nature);
            var1.setId_doc(this.appelCharge.getAppchaId());
            var1.setParc((Parc)null);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      } else if (var2 == 1) {
         if (var4 != null && !var4.isEmpty()) {
            var1.setRapport(var4);
            var1.setEntete("Impression de la liste des factures");
            var1.setTotauxHt("");
            var1.setTotauxTaxe("");
            var1.setTotauxTtc("");
            var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "listeSyndic" + File.separator + "appel_charge" + File.separator);
            var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "sous_rapport" + File.separator);
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
            JRBeanCollectionDataSource var18 = new JRBeanCollectionDataSource(this.listFacture);
            var1.setjRBeanCollectionDataSource(var18);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      } else if (var2 == 2 && var3 != null && !var3.isEmpty()) {
         var1.setRapport(var3);
         var1.setEntete("Impression facture");
         var1.setMontant_lettre("");
         var1.setPageGarde("");
         var1.setAnnexe1("");
         var1.setAnnexe2("");
         var1.setDuplicata("");
         var1.setInfoOrigineDoc("");
         var1.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid()));
         var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
         var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid(), this.appelCharge.getAppchaEtat()));
         var1.setEmetteur("");
         var1.setDestinataire("");
         var1.setDestinataireCC("");
         var1.setDestinataireCCI("");
         var1.setId_doc(0L);
         if (this.lesTiers.size() != 0) {
            new AppelCharge();
            new Tiers();
            Tiers var20 = this.tiers;
            ArrayList var21 = new ArrayList();
            new ArrayList();
            AppelCharge var19 = this.appelCharge;
            Session var15 = (new UtilInitHibernate()).getOpenSession(this.baseLog, "BiensImmobilier");

            for(int var16 = 0; var16 < this.lesTiers.size(); ++var16) {
               this.tiers = (Tiers)this.lesTiers.get(var16);
               this.calculFactureTiers(var15);

               int var17;
               for(var17 = 0; var17 < this.listFacture.size(); ++var17) {
                  if (((AppelCharge)this.listFacture.get(var17)).getAppchaNum() != null && !((AppelCharge)this.listFacture.get(var17)).getAppchaNum().isEmpty()) {
                     if (this.periode.equals("5") && ((AppelCharge)this.listFacture.get(var17)).getAppchaPeriode().contains("01:")) {
                        this.appelCharge = (AppelCharge)this.listFacture.get(var17);
                        break;
                     }

                     if (this.periode.equals("6") && ((AppelCharge)this.listFacture.get(var17)).getAppchaPeriode().contains("04:")) {
                        this.appelCharge = (AppelCharge)this.listFacture.get(var17);
                        break;
                     }

                     if (this.periode.equals("7") && ((AppelCharge)this.listFacture.get(var17)).getAppchaPeriode().contains("07:")) {
                        this.appelCharge = (AppelCharge)this.listFacture.get(var17);
                        break;
                     }

                     if (this.periode.equals("8") && ((AppelCharge)this.listFacture.get(var17)).getAppchaPeriode().contains("10:")) {
                        this.appelCharge = (AppelCharge)this.listFacture.get(var17);
                        break;
                     }

                     if (this.periode.equals("9") && ((AppelCharge)this.listFacture.get(var17)).getAppchaPeriode().contains("01:")) {
                        this.appelCharge = (AppelCharge)this.listFacture.get(var17);
                        break;
                     }

                     if (this.periode.equals("10") && ((AppelCharge)this.listFacture.get(var17)).getAppchaPeriode().contains("07:")) {
                        this.appelCharge = (AppelCharge)this.listFacture.get(var17);
                        break;
                     }

                     if (this.periode.equals("11") && ((AppelCharge)this.listFacture.get(var17)).getAppchaPeriode().contains("01:")) {
                        this.appelCharge = (AppelCharge)this.listFacture.get(var17);
                        break;
                     }
                  }
               }

               List var22 = this.optimisationImpression(this.listFacture);
               if (var22.size() != 0) {
                  for(var17 = 0; var17 < var22.size(); ++var17) {
                     var21.add(var22.get(var17));
                  }
               }
            }

            this.tiers = var20;
            this.calculFactureTiers(var15);
            this.utilInitHibernate.closeSession();
            var1.setParc((Parc)null);
            var1.setNbDecQte(this.optionsVentes.getNbDecQte());
            var1.setNbDecPu(this.optionsVentes.getNbDecPu());
            var1.setIdResponsable(0L);
            var1.setIdCommercial(0L);
            var1.setTiersSelectionne((Tiers)null);
            var1.setNature(this.nature);
            JRBeanCollectionDataSource var23 = new JRBeanCollectionDataSource(var21);
            var1.setjRBeanCollectionDataSource(var23);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
            this.appelCharge = var19;
         }
      }

   }

   public AppelCharge dupAppelCharge(AppelCharge var1, AppelCharge var2) {
      var2.setAppchaAnneeBudget(var1.getAppchaAnneeBudget());
      var2.setAppchaArrondiReg(var1.getAppchaArrondiReg());
      var2.setAppchaBanque(var1.getAppchaBanque());
      var2.setAppchaBien(var1.getAppchaBien());
      var2.setAppchaBudget(var1.getAppchaBudget());
      var2.setAppchaCivilContact(var1.getAppchaCivilContact());
      var2.setAppchaCivilTiers(var1.getAppchaCivilTiers());
      var2.setAppchaCodeTva(var1.getAppchaCodeTva());
      var2.setAppchaConditionReg(var1.getAppchaConditionReg());
      var2.setAppchaContrat(var1.getAppchaContrat());
      var2.setAppchaDate(var1.getAppchaDate());
      var2.setAppchaDateDebut(var1.getAppchaDateDebut());
      var2.setAppchaDateFin(var1.getAppchaDateFin());
      var2.setAppchaDevise(var1.getAppchaDevise());
      var2.setAppchaEcheanceReliquat(var1.getAppchaEcheanceReliquat());
      var2.setAppchaIdBien(var1.getAppchaIdBien());
      var2.setAppchaIdBudget(var1.getAppchaIdBudget());
      var2.setAppchaIdImmeuble(var1.getAppchaIdImmeuble());
      var2.setAppchaIdTiers(var1.getAppchaIdTiers());
      var2.setAppchaMlBien(var1.getAppchaMlBien());
      var2.setAppchaMlImmeuble(var1.getAppchaMlImmeuble());
      var2.setAppchaMode(var1.getAppchaMode());
      var2.setAppchaNomTiers(var1.getAppchaNomTiers());
      var2.setAppchaNum(var1.getAppchaNum());
      var2.setAppchaObject(var1.getAppchaObject());
      var2.setAppchaPeriode(var1.getAppchaPeriode());
      var2.setAppchaTotReliquat(var1.getAppchaTotReliquat());
      var2.setAppchaTotTtcReliquat(var1.getAppchaTotTtcReliquat());
      return var2;
   }

   public void chagerRecu() {
      if (this.datamodelRecu.isRowAvailable()) {
         this.reglementsRecu = (Reglements)this.datamodelRecu.getRowData();
         this.visibleRecu = true;
      }

   }

   public void impressionRecu() throws HibernateException, NamingException {
      if (this.appelCharge != null) {
         if (this.reglementsRecu == null) {
            this.reglementsRecu = this.reglementsDao.pourParapheur(this.appelCharge.getAppchaId(), (Session)null);
         }

         if (this.reglementsRecu != null) {
            this.documentImpressionItems.clear();
            File var1 = new File(this.cheminRecu());
            if (!var1.exists()) {
               var1.mkdir();
            }

            String[] var2 = var1.list();
            if (var2 != null) {
               var2 = this.triAlphabetique(var2, var2.length);
               if (var2 != null) {
                  for(int var3 = 0; var3 < var2.length; ++var3) {
                     if (var2[var3].endsWith("jasper")) {
                        String var4 = var2[var3].substring(0, var2[var3].indexOf("."));
                        this.documentImpressionItems.add(new SelectItem(var4));
                     }
                  }
               }
            }

            this.showModalPanelImpressionRecu = true;
         }
      }

   }

   public void fermerImpressionRecu() {
      this.showModalPanelImpressionRecu = false;
   }

   public String cheminRecu() {
      String var1 = "";
      if (this.reglementsRecu.getRglTypeReg() != 0 && this.reglementsRecu.getRglTypeReg() != 10 && this.reglementsRecu.getRglTypeReg() != 11) {
         if (this.reglementsRecu.getRglTypeReg() == 1) {
            var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "documentsRecu" + File.separator + "cheques" + File.separator;
         } else if (this.reglementsRecu.getRglTypeReg() == 2) {
            var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "documentsRecu" + File.separator + "virements" + File.separator;
         } else if (this.reglementsRecu.getRglTypeReg() == 3) {
            var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "documentsRecu" + File.separator + "traites" + File.separator;
         } else if (this.reglementsRecu.getRglTypeReg() == 4) {
            var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "documentsRecu" + File.separator + "cartes" + File.separator;
         } else if (this.reglementsRecu.getRglTypeReg() == 5) {
            var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "documentsRecu" + File.separator + "transferts" + File.separator;
         } else if (this.reglementsRecu.getRglTypeReg() == 6) {
            var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "documentsRecu" + File.separator + "epaiements" + File.separator;
         } else if (this.reglementsRecu.getRglTypeReg() == 7) {
            var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "documentsRecu" + File.separator + "credocs" + File.separator;
         } else if (this.reglementsRecu.getRglTypeReg() == 8) {
            var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "documentsRecu" + File.separator + "factors" + File.separator;
         } else if (this.reglementsRecu.getRglTypeReg() == 9) {
            var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "documentsRecu" + File.separator + "compenses" + File.separator;
         } else if (this.reglementsRecu.getRglTypeReg() == 12) {
            var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "documentsRecu" + File.separator + "lettres_garantie" + File.separator;
         } else if (this.reglementsRecu.getRglTypeReg() == 13) {
            var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "documentsRecu" + File.separator + "prelevements" + File.separator;
         } else {
            var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "documentsRecu" + File.separator + "defaut" + File.separator;
         }
      } else {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "documentsRecu" + File.separator + "especes" + File.separator;
      }

      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      return var1;
   }

   public void imprimerPRT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "PRT";
      this.impression();
   }

   public void imprimerJRV() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "JRV";
      this.impression();
   }

   public void imprimerPDF() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "PDF";
      this.impression();
   }

   public void imprimerODT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "ODT";
      this.impression();
   }

   public void imprimerXLS() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "XLS";
      this.impression();
   }

   public void imprimerDOC() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "DOC";
      this.impression();
   }

   public void imprimerHTML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "HTML";
      this.impression();
   }

   public void imprimerXML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "XML";
      this.impression();
   }

   public void impression() throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      if (this.appelCharge != null && this.nomModeleDocument != null && !this.nomModeleDocument.isEmpty()) {
         UtilPrint var1 = new UtilPrint(this.utilInitHibernate);
         Session var2 = (new UtilInitHibernate()).getOpenSession(this.baseLog, "BiensImmobilier");
         if (this.reglementsRecu != null) {
            this.reglements = this.reglementsRecu;
         } else {
            this.reglements = this.reglementsDao.selectById(this.appelCharge.getAppchaId(), var2);
         }

         if (this.reglements != null) {
            long var3 = this.reglements.getRglIdDocument();
            new AppelCharge();
            AppelCharge var5 = this.appelChargeDao.pourParapheur(this.reglements.getRglIdDocument(), var2);
            double var6 = var5.getAppchaTotTtc() + var5.getAppchaTotTtcReliquat();
            double var8 = 0.0D;
            double var10 = 0.0D;
            new ArrayList();
            List var12 = this.reglementsDao.findRegByNatRecu(173, this.reglementsRecu.getRglNum(), var2);
            if (var12.size() != 0) {
               for(int var13 = 0; var13 < var12.size(); ++var13) {
                  var8 += ((Reglements)var12.get(var13)).getRglRecette();
                  var10 += ((Reglements)var12.get(var13)).getRglTimbre();
               }
            }

            double var19 = 0.0D;
            double var15 = 0.0D;
            var12 = this.reglementsDao.reglementDocument(var3, 173, var2);
            if (var12.size() != 0) {
               for(int var17 = 0; var17 < var12.size(); ++var17) {
                  if (((Reglements)var12.get(var17)).getRglId() != this.reglements.getRglId() && ((Reglements)var12.get(var17)).getRglDateReg().compareTo(this.reglements.getRglDateReg()) >= 0) {
                     var19 += ((Reglements)var12.get(var17)).getRglRecette();
                     var15 += ((Reglements)var12.get(var17)).getRglTimbre();
                  }
               }
            }

            this.utilInitHibernate.closeSession();
            ArrayList var20 = new ArrayList();
            this.reglementsRecu.setTotalFacture(var6);
            if (var6 - var8 < 0.0D) {
               this.reglementsRecu.setTotalReglement(var6 - var8);
               this.reglementsRecu.setTotalRecette(var8);
            } else if (this.soldeGlobal == 0.0D) {
               this.reglementsRecu.setTotalReglement(0.0D);
               this.reglementsRecu.setTotalFacture(var8);
               this.reglementsRecu.setTotalRecette(var8);
            } else {
               this.reglementsRecu.setTotalReglement(var6 - var8 - var19);
               this.reglementsRecu.setTotalRecette(var8);
            }

            this.reglementsRecu.setTotalTimbre(var10 + var15);
            var20.add(this.reglementsRecu);
            JRBeanCollectionDataSource var18 = new JRBeanCollectionDataSource(var20);
            var1.setjRBeanCollectionDataSource(var18);
            var1.setRapport(this.nomModeleDocument);
            var1.setEntete("Impression recu");
            var1.setCheminRapport(this.cheminRecu());
            var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "sous_rapport" + File.separator);
            var1.setNbDecQte(this.optionsVentes.getNbDecQte());
            var1.setNbDecPu(this.optionsVentes.getNbDecPu());
            var1.setMontant_lettre(this.utilNombre.begin(this.reglementsRecu.getRglRecette() + this.reglementsRecu.getRglTimbre(), this.reglementsRecu.getRglDevise()));
            var1.setFormat(this.format);
            var1.setIdResponsable(this.reglementsRecu.getRglIdResponsable());
            var1.setIdCommercial(this.reglementsRecu.getRglIdCommercial());
            var1.setTiersSelectionne((Tiers)null);
            var1.setNumDoc(this.reglementsRecu.getRglNum());
            var1.setNature(this.nature);
            var1.setId_doc(this.reglementsRecu.getRglId());
            var1.setParc((Parc)null);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      }

   }

   public void initGrapheur() {
      this.modeGraph = 0;
      this.valQteGraph = 0;
      this.timeDecoupage = 1;
      this.sousTitreGraph = "";
      this.uniteGraph = "";
      this.nbDecGraph = 0;
      this.deviseGraph = "";
      this.showModele = false;
      this.showModalPanelGraph = true;
   }

   public void hideModele() {
      this.showModele = false;
   }

   public void fermerGrapheur() {
      this.showModalPanelGraph = false;
   }

   public List grapher() throws HibernateException, NamingException, ParseException {
      Object var1 = new ArrayList();
      if (this.listFacture.size() != 0) {
         if (this.valQteGraph == 0) {
            this.uniteGraph = "FACTURES : Chiffre d'Affaire en " + this.structureLog.getStrdevise();
            this.deviseGraph = this.structureLog.getStrdevise();
            if (!this.structureLog.getStrdevise().equals("XOF") && !this.structureLog.getStrdevise().equals("XAF")) {
               this.nbDecGraph = 2;
            } else {
               this.nbDecGraph = 0;
            }
         } else if (this.valQteGraph == 1) {
            this.uniteGraph = "FACTURES : Nombre de documents";
            this.deviseGraph = "";
            this.nbDecGraph = 0;
         } else if (this.valQteGraph == 2) {
            this.uniteGraph = "FACTURES : Quantites";
            this.deviseGraph = "";
            this.nbDecGraph = Integer.parseInt(this.optionsVentes.getNbDecQte());
         }

         this.titreGraph = "Analyse des ventes : ";
         EtatDocument var2 = new EtatDocument();
         if (this.inpDu != null && this.inpAu != null) {
            String var3 = this.utilDate.dateToStringFr(this.inpDu);
            String var4 = this.utilDate.dateToStringFr(this.inpAu);
            this.titreGraph = this.titreGraph + " Du " + var3 + " au " + var4;
         } else if (this.periode.equals("100")) {
            this.titreGraph = this.titreGraph + " Toutes periodes";
         } else {
            this.titreGraph = this.titreGraph + " " + var2.calculeLibellePeriode(this.periode);
         }

         this.sousTitreGraph = "";
         if (this.inpCat.equals("100")) {
            this.sousTitreGraph = "Toutes les categories -";
         } else {
            this.sousTitreGraph = "Categorie: " + this.inpCat + " -";
         }

         this.sousTitreGraph = this.sousTitreGraph + " Serie:" + this.inpSerie + " -";
         if (this.inpEtat == 100) {
            this.sousTitreGraph = this.sousTitreGraph + " Tous les Etats";
         } else {
            this.sousTitreGraph = this.sousTitreGraph + " Etats: " + var2.calculeLibelleEtat(this.nature, this.inpEtat, 0);
         }

         if (this.modeGraph == 0) {
            this.sousTitreGraph = this.sousTitreGraph + " - En Global (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 1) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par responsable (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 2) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par commercial (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 3) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par equipe (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 4) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par societe (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 5) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par famille de produit (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 6) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par produit (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 7) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par source (" + this.uniteGraph + ")";
         }

         new AppelCharge();
         Session var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureLigne");
         String var5 = "";

         AppelCharge var12;
         for(int var6 = 0; var6 < this.listFacture.size(); ++var6) {
            var12 = (AppelCharge)this.listFacture.get(var6);
            if (var5.isEmpty()) {
               var5 = "'" + var12.getAppchaNum() + "'";
            } else {
               var5 = var5 + ",'" + var12.getAppchaNum() + "'";
            }
         }

         if (this.listFacture.size() != 0) {
            String var14 = "";
            long var7 = 0L;
            boolean var9 = false;
            int var10 = 0;

            while(true) {
               if (var10 >= this.listFacture.size()) {
                  var1 = this.calculePourcentage((List)var1);
                  break;
               }

               var12 = (AppelCharge)this.listFacture.get(var10);
               var14 = "";
               var7 = 0L;
               int var15 = 0;
               if (this.modeGraph == 0) {
                  int var11 = var12.getAppchaDate().getYear() + 1900;
                  var14 = "" + var11;
               } else if (this.modeGraph == 1) {
                  if (var12.getAppchaNomResponsable() != null && !var12.getAppchaNomResponsable().isEmpty()) {
                     var14 = var12.getAppchaNomResponsable();
                  } else {
                     var14 = "Sans Responsable";
                  }
               } else if (this.modeGraph == 2) {
                  if (var12.getAppchaNomCommercial() != null && !var12.getAppchaNomCommercial().isEmpty()) {
                     var14 = var12.getAppchaNomCommercial();
                  } else {
                     var14 = "Sans Commercial";
                  }
               } else if (this.modeGraph == 3) {
                  if (var12.getAppchaNomTiers() != null && !var12.getAppchaNomTiers().isEmpty()) {
                     var14 = var12.getAppchaNomTiers();
                  } else {
                     var14 = "Sans Locataire";
                  }
               } else if (this.modeGraph == 7) {
                  if (var12.getAppchaSource() != null && !var12.getAppchaSource().isEmpty()) {
                     var14 = var12.getAppchaSource();
                  } else {
                     var14 = "Sans Source";
                  }
               }

               if (this.valQteGraph == 0) {
                  var7 = (long)var12.getAppchaTotHt();
               } else if (this.valQteGraph == 1) {
                  ++var7;
               }

               if (this.timeDecoupage == 0) {
                  var15 = var12.getAppchaDate().getDate();
               } else if (this.timeDecoupage == 1) {
                  var15 = var12.getAppchaDate().getMonth() + 1;
               } else if (this.timeDecoupage == 2) {
                  if (var12.getAppchaDate().getMonth() + 1 >= 1 && var12.getAppchaDate().getMonth() + 1 <= 3) {
                     var15 = 1;
                  } else if (var12.getAppchaDate().getMonth() + 1 >= 4 && var12.getAppchaDate().getMonth() + 1 <= 6) {
                     var15 = 2;
                  } else if (var12.getAppchaDate().getMonth() + 1 >= 7 && var12.getAppchaDate().getMonth() + 1 <= 9) {
                     var15 = 3;
                  } else if (var12.getAppchaDate().getMonth() + 1 >= 10 && var12.getAppchaDate().getMonth() + 1 <= 12) {
                     var15 = 4;
                  }
               } else if (this.timeDecoupage == 3) {
                  if (var12.getAppchaDate().getMonth() + 1 >= 1 && var12.getAppchaDate().getMonth() + 1 <= 6) {
                     var15 = 1;
                  } else if (var12.getAppchaDate().getMonth() + 1 >= 7 && var12.getAppchaDate().getMonth() + 1 <= 12) {
                     var15 = 2;
                  }
               } else if (this.timeDecoupage == 4) {
                  var15 = 1;
               }

               var1 = this.calculeListe((List)var1, var14, var15, var7);
               ++var10;
            }
         }

         this.utilInitHibernate.closeSession();
      }

      this.showModele = true;
      return (List)var1;
   }

   public List calculeListe(List var1, String var2, int var3, long var4) {
      boolean var6 = false;
      boolean var7 = false;
      ObjetGraph var8 = new ObjetGraph();
      if (var1.size() == 0) {
         var6 = true;
      } else {
         for(int var9 = 0; var9 < var1.size(); ++var9) {
            var8 = (ObjetGraph)var1.get(var9);
            if (var2.equals(var8.getNomSerie())) {
               var7 = true;
               break;
            }
         }

         if (!var7) {
            var6 = true;
         }
      }

      if (var6) {
         ObjetGraph var10 = new ObjetGraph();
         var10.setNomSerie(var2);
         if (var3 == 1) {
            var10.setV01(var4);
         } else if (var3 == 2) {
            var10.setV02(var4);
         } else if (var3 == 3) {
            var10.setV03(var4);
         } else if (var3 == 4) {
            var10.setV04(var4);
         } else if (var3 == 5) {
            var10.setV05(var4);
         } else if (var3 == 6) {
            var10.setV06(var4);
         } else if (var3 == 7) {
            var10.setV07(var4);
         } else if (var3 == 8) {
            var10.setV08(var4);
         } else if (var3 == 9) {
            var10.setV09(var4);
         } else if (var3 == 10) {
            var10.setV10(var4);
         } else if (var3 == 11) {
            var10.setV11(var4);
         } else if (var3 == 12) {
            var10.setV12(var4);
         } else if (var3 == 13) {
            var10.setV13(var4);
         } else if (var3 == 14) {
            var10.setV14(var4);
         } else if (var3 == 15) {
            var10.setV15(var4);
         } else if (var3 == 16) {
            var10.setV16(var4);
         } else if (var3 == 17) {
            var10.setV17(var4);
         } else if (var3 == 18) {
            var10.setV18(var4);
         } else if (var3 == 19) {
            var10.setV19(var4);
         } else if (var3 == 20) {
            var10.setV20(var4);
         } else if (var3 == 21) {
            var10.setV21(var4);
         } else if (var3 == 22) {
            var10.setV22(var4);
         } else if (var3 == 23) {
            var10.setV23(var4);
         } else if (var3 == 24) {
            var10.setV24(var4);
         } else if (var3 == 25) {
            var10.setV25(var4);
         } else if (var3 == 26) {
            var10.setV26(var4);
         } else if (var3 == 27) {
            var10.setV27(var4);
         } else if (var3 == 28) {
            var10.setV28(var4);
         } else if (var3 == 29) {
            var10.setV29(var4);
         } else if (var3 == 30) {
            var10.setV30(var4);
         } else if (var3 == 31) {
            var10.setV31(var4);
         }

         var1.add(var10);
      } else if (var8 != null) {
         if (var3 == 1) {
            var8.setV01(var8.getV01() + var4);
         } else if (var3 == 2) {
            var8.setV02(var8.getV02() + var4);
         } else if (var3 == 3) {
            var8.setV03(var8.getV03() + var4);
         } else if (var3 == 4) {
            var8.setV04(var8.getV04() + var4);
         } else if (var3 == 5) {
            var8.setV05(var8.getV05() + var4);
         } else if (var3 == 6) {
            var8.setV06(var8.getV06() + var4);
         } else if (var3 == 7) {
            var8.setV07(var8.getV07() + var4);
         } else if (var3 == 8) {
            var8.setV08(var8.getV08() + var4);
         } else if (var3 == 9) {
            var8.setV09(var8.getV09() + var4);
         } else if (var3 == 10) {
            var8.setV10(var8.getV10() + var4);
         } else if (var3 == 11) {
            var8.setV11(var8.getV11() + var4);
         } else if (var3 == 12) {
            var8.setV12(var8.getV12() + var4);
         } else if (var3 == 13) {
            var8.setV13(var8.getV13() + var4);
         } else if (var3 == 14) {
            var8.setV14(var8.getV14() + var4);
         } else if (var3 == 15) {
            var8.setV15(var8.getV15() + var4);
         } else if (var3 == 16) {
            var8.setV16(var8.getV16() + var4);
         } else if (var3 == 17) {
            var8.setV17(var8.getV17() + var4);
         } else if (var3 == 18) {
            var8.setV18(var8.getV18() + var4);
         } else if (var3 == 19) {
            var8.setV19(var8.getV19() + var4);
         } else if (var3 == 20) {
            var8.setV20(var8.getV20() + var4);
         } else if (var3 == 21) {
            var8.setV21(var8.getV21() + var4);
         } else if (var3 == 22) {
            var8.setV22(var8.getV22() + var4);
         } else if (var3 == 23) {
            var8.setV23(var8.getV23() + var4);
         } else if (var3 == 24) {
            var8.setV24(var8.getV24() + var4);
         } else if (var3 == 25) {
            var8.setV25(var8.getV25() + var4);
         } else if (var3 == 26) {
            var8.setV26(var8.getV26() + var4);
         } else if (var3 == 27) {
            var8.setV27(var8.getV27() + var4);
         } else if (var3 == 28) {
            var8.setV28(var8.getV28() + var4);
         } else if (var3 == 29) {
            var8.setV29(var8.getV29() + var4);
         } else if (var3 == 30) {
            var8.setV30(var8.getV30() + var4);
         } else if (var3 == 31) {
            var8.setV31(var8.getV31() + var4);
         }
      }

      return var1;
   }

   public List calculePourcentage(List var1) {
      new ObjetGraph();
      float var3 = 0.0F;
      ObjetGraph var2;
      if (var1.size() != 0) {
         for(int var4 = 0; var4 < var1.size(); ++var4) {
            var2 = (ObjetGraph)var1.get(var4);
            var3 += (float)(var2.getV01() + var2.getV02() + var2.getV03() + var2.getV04() + var2.getV05() + var2.getV06() + var2.getV07() + var2.getV08() + var2.getV09() + var2.getV10() + var2.getV11() + var2.getV12() + var2.getV13() + var2.getV14() + var2.getV15() + var2.getV16() + var2.getV16() + var2.getV17() + var2.getV18() + var2.getV19() + var2.getV20() + var2.getV21() + var2.getV22() + var2.getV23() + var2.getV24() + var2.getV25() + var2.getV26() + var2.getV27() + var2.getV28() + var2.getV29() + var2.getV30() + var2.getV31());
         }
      }

      if (var1.size() != 0) {
         float var7 = 0.0F;
         float var5 = 0.0F;

         for(int var6 = 0; var6 < var1.size(); ++var6) {
            var2 = (ObjetGraph)var1.get(var6);
            var5 = (float)(var2.getV01() + var2.getV02() + var2.getV03() + var2.getV04() + var2.getV05() + var2.getV06() + var2.getV07() + var2.getV08() + var2.getV09() + var2.getV10() + var2.getV11() + var2.getV12() + var2.getV13() + var2.getV14() + var2.getV15() + var2.getV16() + var2.getV16() + var2.getV17() + var2.getV18() + var2.getV19() + var2.getV20() + var2.getV21() + var2.getV22() + var2.getV23() + var2.getV24() + var2.getV25() + var2.getV26() + var2.getV27() + var2.getV28() + var2.getV29() + var2.getV30() + var2.getV31());
            var7 = var5 / var3 * 100.0F;
            var2.setVpourcent(var7);
         }
      }

      return var1;
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

   public UsersChrono getUsersChrono() {
      return this.usersChrono;
   }

   public void setUsersChrono(UsersChrono var1) {
      this.usersChrono = var1;
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

   public boolean isVar_acc_appartement() {
      return this.var_acc_appartement;
   }

   public void setVar_acc_appartement(boolean var1) {
      this.var_acc_appartement = var1;
   }

   public boolean isVar_acc_box() {
      return this.var_acc_box;
   }

   public void setVar_acc_box(boolean var1) {
      this.var_acc_box = var1;
   }

   public boolean isVar_acc_bureau() {
      return this.var_acc_bureau;
   }

   public void setVar_acc_bureau(boolean var1) {
      this.var_acc_bureau = var1;
   }

   public boolean isVar_acc_commerce() {
      return this.var_acc_commerce;
   }

   public void setVar_acc_commerce(boolean var1) {
      this.var_acc_commerce = var1;
   }

   public boolean isVar_acc_garage() {
      return this.var_acc_garage;
   }

   public void setVar_acc_garage(boolean var1) {
      this.var_acc_garage = var1;
   }

   public boolean isVar_acc_hanger() {
      return this.var_acc_hanger;
   }

   public void setVar_acc_hanger(boolean var1) {
      this.var_acc_hanger = var1;
   }

   public boolean isVar_acc_immeuble() {
      return this.var_acc_immeuble;
   }

   public void setVar_acc_immeuble(boolean var1) {
      this.var_acc_immeuble = var1;
   }

   public boolean isVar_acc_terrain() {
      return this.var_acc_terrain;
   }

   public void setVar_acc_terrain(boolean var1) {
      this.var_acc_terrain = var1;
   }

   public boolean isVar_acc_usine() {
      return this.var_acc_usine;
   }

   public void setVar_acc_usine(boolean var1) {
      this.var_acc_usine = var1;
   }

   public boolean isVar_acc_villa() {
      return this.var_acc_villa;
   }

   public void setVar_acc_villa(boolean var1) {
      this.var_acc_villa = var1;
   }

   public boolean isVar_aff_action() {
      return this.var_aff_action;
   }

   public void setVar_aff_action(boolean var1) {
      this.var_aff_action = var1;
   }

   public boolean isVar_aff_detail_proprietaire() {
      return this.var_aff_detail_proprietaire;
   }

   public void setVar_aff_detail_proprietaire(boolean var1) {
      this.var_aff_detail_proprietaire = var1;
   }

   public boolean isVar_valide_doc() {
      return this.var_valide_doc;
   }

   public void setVar_valide_doc(boolean var1) {
      this.var_valide_doc = var1;
   }

   public Tiers getProprietaire() {
      return this.proprietaire;
   }

   public void setProprietaire(Tiers var1) {
      this.proprietaire = var1;
   }

   public boolean isShowModalPanelTransfert() {
      return this.showModalPanelTransfert;
   }

   public void setShowModalPanelTransfert(boolean var1) {
      this.showModalPanelTransfert = var1;
   }

   public int getVar_imput_cat() {
      return this.var_imput_cat;
   }

   public void setVar_imput_cat(int var1) {
      this.var_imput_cat = var1;
   }

   public Date getInpAu() {
      return this.inpAu;
   }

   public void setInpAu(Date var1) {
      this.inpAu = var1;
   }

   public String getInpClient() {
      return this.inpClient;
   }

   public void setInpClient(String var1) {
      this.inpClient = var1;
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

   public List getMesSerieUserItem() {
      return this.mesSerieUserItem;
   }

   public void setMesSerieUserItem(List var1) {
      this.mesSerieUserItem = var1;
   }

   public String getPeriode() {
      return this.periode;
   }

   public void setPeriode(String var1) {
      this.periode = var1;
   }

   public boolean isVar_more_search() {
      return this.var_more_search;
   }

   public void setVar_more_search(boolean var1) {
      this.var_more_search = var1;
   }

   public int getCategorie() {
      return this.categorie;
   }

   public void setCategorie(int var1) {
      this.categorie = var1;
   }

   public boolean isVar_exo_tva() {
      return this.var_exo_tva;
   }

   public void setVar_exo_tva(boolean var1) {
      this.var_exo_tva = var1;
   }

   public Bien getBien() {
      return this.bien;
   }

   public void setBien(Bien var1) {
      this.bien = var1;
   }

   public boolean isVar_aff_detail_local() {
      return this.var_aff_detail_local;
   }

   public void setVar_aff_detail_local(boolean var1) {
      this.var_aff_detail_local = var1;
   }

   public DataModel getDatamodelFacture() {
      return this.datamodelFacture;
   }

   public void setDatamodelFacture(DataModel var1) {
      this.datamodelFacture = var1;
   }

   public List getListFacture() {
      return this.listFacture;
   }

   public void setListFacture(List var1) {
      this.listFacture = var1;
   }

   public String getInpCat() {
      return this.inpCat;
   }

   public void setInpCat(String var1) {
      this.inpCat = var1;
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

   public String getDeviseGraph() {
      return this.deviseGraph;
   }

   public void setDeviseGraph(String var1) {
      this.deviseGraph = var1;
   }

   public boolean isShowModele() {
      return this.showModele;
   }

   public void setShowModele(boolean var1) {
      this.showModele = var1;
   }

   public boolean isShowModalPanelImput() {
      return this.showModalPanelImput;
   }

   public void setShowModalPanelImput(boolean var1) {
      this.showModalPanelImput = var1;
   }

   public String getVar_imput_serie() {
      return this.var_imput_serie;
   }

   public void setVar_imput_serie(String var1) {
      this.var_imput_serie = var1;
   }

   public AppelCharge getAppelCharge() {
      return this.appelCharge;
   }

   public void setAppelCharge(AppelCharge var1) {
      this.appelCharge = var1;
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

   public int getVar_nb_ligne() {
      return this.var_nb_ligne;
   }

   public void setVar_nb_ligne(int var1) {
      this.var_nb_ligne = var1;
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

   public DataModel getDataModelEcriture() {
      return this.dataModelEcriture;
   }

   public void setDataModelEcriture(DataModel var1) {
      this.dataModelEcriture = var1;
   }

   public boolean isShowModalPanelValidationDocument() {
      return this.showModalPanelValidationDocument;
   }

   public void setShowModalPanelValidationDocument(boolean var1) {
      this.showModalPanelValidationDocument = var1;
   }

   public DataModel getDatamodelRecu() {
      return this.datamodelRecu;
   }

   public void setDatamodelRecu(DataModel var1) {
      this.datamodelRecu = var1;
   }

   public boolean isVisibleOnglet() {
      return this.visibleOnglet;
   }

   public void setVisibleOnglet(boolean var1) {
      this.visibleOnglet = var1;
   }

   public List getMesContactItem() {
      return this.mesContactItem;
   }

   public void setMesContactItem(List var1) {
      this.mesContactItem = var1;
   }

   public long getVar_nom_contact() {
      return this.var_nom_contact;
   }

   public void setVar_nom_contact(long var1) {
      this.var_nom_contact = var1;
   }

   public long getVar_nom_commercial() {
      return this.var_nom_commercial;
   }

   public void setVar_nom_commercial(long var1) {
      this.var_nom_commercial = var1;
   }

   public List getMesUsersItem() {
      return this.mesUsersItem;
   }

   public void setMesUsersItem(List var1) {
      this.mesUsersItem = var1;
   }

   public long getVar_nom_responsable() {
      return this.var_nom_responsable;
   }

   public void setVar_nom_responsable(long var1) {
      this.var_nom_responsable = var1;
   }

   public boolean isVar_verrou_comm() {
      return this.var_verrou_comm;
   }

   public void setVar_verrou_comm(boolean var1) {
      this.var_verrou_comm = var1;
   }

   public boolean isAffichagePump() {
      return this.affichagePump;
   }

   public void setAffichagePump(boolean var1) {
      this.affichagePump = var1;
   }

   public UtilParapheur getUtilParapheur() {
      return this.utilParapheur;
   }

   public void setUtilParapheur(UtilParapheur var1) {
      this.utilParapheur = var1;
   }

   public String getDevisePrint() {
      return this.devisePrint;
   }

   public void setDevisePrint(String var1) {
      this.devisePrint = var1;
   }

   public float getTauxPrint() {
      return this.tauxPrint;
   }

   public void setTauxPrint(float var1) {
      this.tauxPrint = var1;
   }

   public boolean isVar_affiche_dollar() {
      return this.var_affiche_dollar;
   }

   public void setVar_affiche_dollar(boolean var1) {
      this.var_affiche_dollar = var1;
   }

   public DataModel getDatamodelTransfert() {
      return this.datamodelTransfert;
   }

   public void setDatamodelTransfert(DataModel var1) {
      this.datamodelTransfert = var1;
   }

   public List getMesBanquesItems() {
      return this.mesBanquesItems;
   }

   public void setMesBanquesItems(List var1) {
      this.mesBanquesItems = var1;
   }

   public List getMesModesleRecus() {
      return this.mesModesleRecus;
   }

   public void setMesModesleRecus(List var1) {
      this.mesModesleRecus = var1;
   }

   public boolean isShowModalPanelReglement() {
      return this.showModalPanelReglement;
   }

   public void setShowModalPanelReglement(boolean var1) {
      this.showModalPanelReglement = var1;
   }

   public Date getVar_date_trf() {
      return this.var_date_trf;
   }

   public void setVar_date_trf(Date var1) {
      this.var_date_trf = var1;
   }

   public String getVar_inputCaisse() {
      return this.var_inputCaisse;
   }

   public void setVar_inputCaisse(String var1) {
      this.var_inputCaisse = var1;
   }

   public String getVar_type_reg() {
      return this.var_type_reg;
   }

   public void setVar_type_reg(String var1) {
      this.var_type_reg = var1;
   }

   public String getNomRepMod() {
      return this.nomRepMod;
   }

   public void setNomRepMod(String var1) {
      this.nomRepMod = var1;
   }

   public String getVar_modele_trf() {
      return this.var_modele_trf;
   }

   public void setVar_modele_trf(String var1) {
      this.var_modele_trf = var1;
   }

   public boolean isVar_affiche_banque() {
      return this.var_affiche_banque;
   }

   public void setVar_affiche_banque(boolean var1) {
      this.var_affiche_banque = var1;
   }

   public boolean isVar_affiche_banque_destination() {
      return this.var_affiche_banque_destination;
   }

   public void setVar_affiche_banque_destination(boolean var1) {
      this.var_affiche_banque_destination = var1;
   }

   public double getMontantElmTotBonEnc() {
      return this.montantElmTotBonEnc;
   }

   public void setMontantElmTotBonEnc(double var1) {
      this.montantElmTotBonEnc = var1;
   }

   public double getVar_netAPayer() {
      return this.var_netAPayer;
   }

   public void setVar_netAPayer(double var1) {
      this.var_netAPayer = var1;
   }

   public String getVar_objet() {
      return this.var_objet;
   }

   public void setVar_objet(String var1) {
      this.var_objet = var1;
   }

   public boolean isRepartitionManuelle() {
      return this.repartitionManuelle;
   }

   public void setRepartitionManuelle(boolean var1) {
      this.repartitionManuelle = var1;
   }

   public double getVar_ecart_reglement() {
      return this.var_ecart_reglement;
   }

   public void setVar_ecart_reglement(double var1) {
      this.var_ecart_reglement = var1;
   }

   public double getEcartManuel() {
      return this.ecartManuel;
   }

   public void setEcartManuel(double var1) {
      this.ecartManuel = var1;
   }

   public String getVar_banque_destination() {
      return this.var_banque_destination;
   }

   public void setVar_banque_destination(String var1) {
      this.var_banque_destination = var1;
   }

   public String getVar_banque_tireur() {
      return this.var_banque_tireur;
   }

   public void setVar_banque_tireur(String var1) {
      this.var_banque_tireur = var1;
   }

   public String getVar_num_cheque() {
      return this.var_num_cheque;
   }

   public void setVar_num_cheque(String var1) {
      this.var_num_cheque = var1;
   }

   public boolean isVar_affiche_valide() {
      return this.var_affiche_valide;
   }

   public void setVar_affiche_valide(boolean var1) {
      this.var_affiche_valide = var1;
   }

   public int getVarTypeReg() {
      return this.varTypeReg;
   }

   public void setVarTypeReg(int var1) {
      this.varTypeReg = var1;
   }

   public List getMesImpressionsFacturesItems() {
      return this.mesImpressionsFacturesItems;
   }

   public void setMesImpressionsFacturesItems(List var1) {
      this.mesImpressionsFacturesItems = var1;
   }

   public List getMesPeriodesItems() {
      return this.mesPeriodesItems;
   }

   public void setMesPeriodesItems(List var1) {
      this.mesPeriodesItems = var1;
   }

   public String getModeleFacture() {
      return this.modeleFacture;
   }

   public void setModeleFacture(String var1) {
      this.modeleFacture = var1;
   }

   public int getChoixSuppression() {
      return this.choixSuppression;
   }

   public void setChoixSuppression(int var1) {
      this.choixSuppression = var1;
   }

   public boolean isShowModalPanelSuppression() {
      return this.showModalPanelSuppression;
   }

   public void setShowModalPanelSuppression(boolean var1) {
      this.showModalPanelSuppression = var1;
   }

   public int getVar_timbre() {
      return this.var_timbre;
   }

   public void setVar_timbre(int var1) {
      this.var_timbre = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public boolean isVar_acc_chambre() {
      return this.var_acc_chambre;
   }

   public void setVar_acc_chambre(boolean var1) {
      this.var_acc_chambre = var1;
   }

   public List getMesBiensItems() {
      return this.mesBiensItems;
   }

   public void setMesBiensItems(List var1) {
      this.mesBiensItems = var1;
   }

   public List getMesBudgetsItems() {
      return this.mesBudgetsItems;
   }

   public void setMesBudgetsItems(List var1) {
      this.mesBudgetsItems = var1;
   }

   public DataModel getDataModelAppartements() {
      return this.dataModelAppartements;
   }

   public void setDataModelAppartements(DataModel var1) {
      this.dataModelAppartements = var1;
   }

   public double getTotalBudget() {
      return this.totalBudget;
   }

   public void setTotalBudget(double var1) {
      this.totalBudget = var1;
   }

   public double getTotalMillieme() {
      return this.totalMillieme;
   }

   public void setTotalMillieme(double var1) {
      this.totalMillieme = var1;
   }

   public double getTotalBudgetTrim() {
      return this.totalBudgetTrim;
   }

   public void setTotalBudgetTrim(double var1) {
      this.totalBudgetTrim = var1;
   }

   public String getVar_codeTva() {
      return this.var_codeTva;
   }

   public void setVar_codeTva(String var1) {
      this.var_codeTva = var1;
   }

   public long getVar_idBudget() {
      return this.var_idBudget;
   }

   public void setVar_idBudget(long var1) {
      this.var_idBudget = var1;
   }

   public long getVar_idImmeuble() {
      return this.var_idImmeuble;
   }

   public void setVar_idImmeuble(long var1) {
      this.var_idImmeuble = var1;
   }

   public int getVar_mode() {
      return this.var_mode;
   }

   public void setVar_mode(int var1) {
      this.var_mode = var1;
   }

   public String getVar_modeleImp() {
      return this.var_modeleImp;
   }

   public void setVar_modeleImp(String var1) {
      this.var_modeleImp = var1;
   }

   public String getVar_serie() {
      return this.var_serie;
   }

   public void setVar_serie(String var1) {
      this.var_serie = var1;
   }

   public boolean isAfficheRecu() {
      return this.afficheRecu;
   }

   public void setAfficheRecu(boolean var1) {
      this.afficheRecu = var1;
   }

   public List getDocumentDetailTrf() {
      return this.documentDetailTrf;
   }

   public void setDocumentDetailTrf(List var1) {
      this.documentDetailTrf = var1;
   }

   public List getDocumentTrfItems() {
      return this.documentTrfItems;
   }

   public void setDocumentTrfItems(List var1) {
      this.documentTrfItems = var1;
   }

   public List getMesCaissesItems() {
      return this.mesCaissesItems;
   }

   public void setMesCaissesItems(List var1) {
      this.mesCaissesItems = var1;
   }

   public List getMesSeriesTrfItems() {
      return this.mesSeriesTrfItems;
   }

   public void setMesSeriesTrfItems(List var1) {
      this.mesSeriesTrfItems = var1;
   }

   public List getModeleTrfItems() {
      return this.modeleTrfItems;
   }

   public void setModeleTrfItems(List var1) {
      this.modeleTrfItems = var1;
   }

   public boolean isShowModalPanelPaye() {
      return this.showModalPanelPaye;
   }

   public void setShowModalPanelPaye(boolean var1) {
      this.showModalPanelPaye = var1;
   }

   public boolean isShowModalPanelPayeMultiple() {
      return this.showModalPanelPayeMultiple;
   }

   public void setShowModalPanelPayeMultiple(boolean var1) {
      this.showModalPanelPayeMultiple = var1;
   }

   public boolean isVar_verouxModReg() {
      return this.var_verouxModReg;
   }

   public void setVar_verouxModReg(boolean var1) {
      this.var_verouxModReg = var1;
   }

   public boolean isVar_affichMontant() {
      return this.var_affichMontant;
   }

   public void setVar_affichMontant(boolean var1) {
      this.var_affichMontant = var1;
   }

   public boolean isShowModalPanelImpressionRecu() {
      return this.showModalPanelImpressionRecu;
   }

   public void setShowModalPanelImpressionRecu(boolean var1) {
      this.showModalPanelImpressionRecu = var1;
   }

   public double getVal_timbre() {
      return this.val_timbre;
   }

   public void setVal_timbre(double var1) {
      this.val_timbre = var1;
   }

   public double getTotalPayerTimbre() {
      return this.totalPayerTimbre;
   }

   public void setTotalPayerTimbre(double var1) {
      this.totalPayerTimbre = var1;
   }

   public List getMesBiensRecItems() {
      return this.mesBiensRecItems;
   }

   public void setMesBiensRecItems(List var1) {
      this.mesBiensRecItems = var1;
   }

   public List getDocumentImpressionItems() {
      return this.documentImpressionItems;
   }

   public void setDocumentImpressionItems(List var1) {
      this.documentImpressionItems = var1;
   }

   public String getNomModeleDocument() {
      return this.nomModeleDocument;
   }

   public void setNomModeleDocument(String var1) {
      this.nomModeleDocument = var1;
   }

   public boolean isVisibleRecu() {
      return this.visibleRecu;
   }

   public void setVisibleRecu(boolean var1) {
      this.visibleRecu = var1;
   }

   public boolean isShowModalPanelAnnuler() {
      return this.showModalPanelAnnuler;
   }

   public void setShowModalPanelAnnuler(boolean var1) {
      this.showModalPanelAnnuler = var1;
   }

   public Date getVar_date_periode() {
      return this.var_date_periode;
   }

   public void setVar_date_periode(Date var1) {
      this.var_date_periode = var1;
   }

   public String getVar_lib_periode() {
      return this.var_lib_periode;
   }

   public void setVar_lib_periode(String var1) {
      this.var_lib_periode = var1;
   }

   public boolean isVar_affiche_be() {
      return this.var_affiche_be;
   }

   public void setVar_affiche_be(boolean var1) {
      this.var_affiche_be = var1;
   }

   public double getVar_tot_reglement() {
      return this.var_tot_reglement;
   }

   public void setVar_tot_reglement(double var1) {
      this.var_tot_reglement = var1;
   }

   public double getVar_solde() {
      return this.var_solde;
   }

   public void setVar_solde(double var1) {
      this.var_solde = var1;
   }

   public double getTotalBudgetTrimReliquat() {
      return this.totalBudgetTrimReliquat;
   }

   public void setTotalBudgetTrimReliquat(double var1) {
      this.totalBudgetTrimReliquat = var1;
   }

   public DataModel getDatamodelTiers() {
      return this.datamodelTiers;
   }

   public void setDatamodelTiers(DataModel var1) {
      this.datamodelTiers = var1;
   }

   public boolean isVisibiliteFacture() {
      return this.visibiliteFacture;
   }

   public void setVisibiliteFacture(boolean var1) {
      this.visibiliteFacture = var1;
   }

   public boolean isVisibiliteRecu() {
      return this.visibiliteRecu;
   }

   public void setVisibiliteRecu(boolean var1) {
      this.visibiliteRecu = var1;
   }

   public DataModel getDatamodelAdc() {
      return this.datamodelAdc;
   }

   public void setDatamodelAdc(DataModel var1) {
      this.datamodelAdc = var1;
   }

   public double getSoldeGlobal() {
      return this.soldeGlobal;
   }

   public void setSoldeGlobal(double var1) {
      this.soldeGlobal = var1;
   }

   public double getTotFactureGlobal() {
      return this.totFactureGlobal;
   }

   public void setTotFactureGlobal(double var1) {
      this.totFactureGlobal = var1;
   }

   public double getTotReglementGlobal() {
      return this.totReglementGlobal;
   }

   public void setTotReglementGlobal(double var1) {
      this.totReglementGlobal = var1;
   }

   public double getTotTimbreGlobal() {
      return this.totTimbreGlobal;
   }

   public void setTotTimbreGlobal(double var1) {
      this.totTimbreGlobal = var1;
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
}
