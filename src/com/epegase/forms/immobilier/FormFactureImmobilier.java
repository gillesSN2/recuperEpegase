package com.epegase.forms.immobilier;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.Bien;
import com.epegase.systeme.classe.BienBail;
import com.epegase.systeme.classe.BienFacture;
import com.epegase.systeme.classe.BienGeranceLigne;
import com.epegase.systeme.classe.CaissesCommerciales;
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
import com.epegase.systeme.dao.BienBailDao;
import com.epegase.systeme.dao.BienDao;
import com.epegase.systeme.dao.BienFactureDao;
import com.epegase.systeme.dao.BienGeranceLigneDao;
import com.epegase.systeme.dao.CaissesCommercialesDao;
import com.epegase.systeme.dao.ContactDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.ExercicesCaisseDao;
import com.epegase.systeme.dao.ExercicesComptableDao;
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

public class FormFactureImmobilier implements Serializable {
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
   private transient DataModel datamodelFacture = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private List listFacture = new ArrayList();
   private BienFacture bienFacture = new BienFacture();
   private BienFactureDao bienFactureDao;
   private Bien bien;
   private BienDao bienDao;
   private BienBail bienBail;
   private BienBailDao bienBailDao;
   private boolean visibiliteBton = false;
   private Tiers proprietaire;
   private Tiers locataire;
   private TiersDao tiersDao;
   private boolean var_aff_detail_locataire = false;
   private boolean var_aff_detail_proprietaire = false;
   private boolean var_aff_detail_local = false;
   private boolean var_valide_doc = false;
   private boolean showModalPanelValidationDocument = false;
   private boolean visibleOnglet = false;
   private boolean exo_tom;
   private boolean exo_tva;
   private String numeroBail;
   private Users responsable;
   private long var_nom_commercial;
   private List mesSerieUserItem;
   private List mesUsersItem = new ArrayList();
   private long var_nom_responsable;
   private ContactDao contactDao;
   private List mesContactItem = new ArrayList();
   private long var_nom_contact;
   private String var_modele_trf;
   private boolean var_affiche_valide = false;
   private transient DataModel datamodelRecu;
   private ReglementsDao reglementsDao;
   private boolean visibilitefactor = false;
   private boolean visibiliteterme = false;
   private boolean visibilitenbrjr = false;
   private boolean visibiliteencaissemt = false;
   private boolean showModalPanelHistoReglement = false;
   private boolean var_affiche_dollar = false;
   private Tiers tiers;
   private double var_netAPayer;
   private double montantElmTotBonEnc;
   private double totalPayerTimbre;
   private transient DataModel datamodelTransfert;
   private Date var_date_trf;
   private String var_inputCaisse;
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
   private List lesReglements;
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
   private boolean var_exo_tom;
   private boolean var_exo_tva;
   private boolean var_exo_irpp;
   private boolean var_exo_tlv;
   private float taux_tva;
   private float taux_tlv;
   private float taux_tom;
   private float taux_irpp;
   private double montantTtc = 0.0D;
   private double montantSolde = 0.0D;
   private double montantReglement = 0.0D;
   private double montantTtcElmt = 0.0D;
   private double montantSoldeElmt = 0.0D;
   private double montantReglementElmt = 0.0D;
   private int var_nb_ligne = 0;
   private String inpSerie = "100";
   private int inpEtat = 13;
   private String periode = "100";
   private String inpNum = "";
   private String inpCat = "";
   private String inpClient = "";
   private String inpProprietaire = "";
   private String inpBail = "";
   private String inpResponsable = "";
   private String inpDossier = "100";
   private Date inpDu = null;
   private Date inpAu = null;
   private boolean var_more_search = false;
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
   private boolean showModalPanelAuto = false;
   private String modeleFacture;
   private List mesImpressionsFacturesItems;
   private List mesPeriodesItems;
   private int choixSuppression;
   private boolean showModalPanelSuppression = false;
   private String nomProprietaire;
   private String nomLocataire;
   private boolean showModalPanelAnnuler = false;

   public FormFactureImmobilier() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.datamodelRecu = new ListDataModel();
      this.dataModelEcriture = new ListDataModel();
      this.utilParapheur = new UtilParapheur(this.utilInitHibernate, this.structureLog, this.baseLog, this.usersLog);
      this.listFactureSelectionne = new ArrayList();
      this.mesModesleRecus = new ArrayList();
      this.mesBanquesItems = new ArrayList();
      this.datamodelTransfert = new ListDataModel();
      this.mesImpressionsFacturesItems = new ArrayList();
      this.mesPeriodesItems = new ArrayList();
      this.lesReglements = new ArrayList();
      this.documentImpressionItems = new ArrayList();
   }

   public void InstancesDaoUtilses() {
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.bienFactureDao = new BienFactureDao(this.baseLog, this.utilInitHibernate);
      this.bienDao = new BienDao(this.baseLog, this.utilInitHibernate);
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      this.reglementsDao = new ReglementsDao(this.baseLog, this.utilInitHibernate);
      this.caissesCommercialesDao = new CaissesCommercialesDao(this.baseLog, this.utilInitHibernate);
      this.bienBailDao = new BienBailDao(this.baseLog, this.utilInitHibernate);
   }

   public void configVentes(Session var1) throws HibernateException, NamingException, ParseException {
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
      if (this.usersChrono == null) {
         this.usersChrono = new UsersChrono();
      }

      if (this.habilitation != null) {
         this.existParapheur = true;
      } else {
         this.existParapheur = false;
      }

      this.taux_irpp = 0.0F;
      this.taux_tlv = 0.0F;
      this.taux_tom = 0.0F;
      this.taux_tva = 0.0F;
      new TaxesVentes();
      TaxesVentesDao var3 = new TaxesVentesDao(this.baseLog, this.utilInitHibernate);
      TaxesVentes var2;
      if (this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
         var2 = var3.selectTva(this.exercicesVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var1);
         if (var2 != null) {
            this.taux_tva = var2.getTaxvteTaux();
         }
      }

      if (this.optionsVentes.getTlvDefaut() != null && !this.optionsVentes.getTlvDefaut().isEmpty()) {
         var2 = var3.selectTva(this.exercicesVentes.getExevteId(), this.optionsVentes.getTlvDefaut(), var1);
         if (var2 != null) {
            this.taux_tlv = var2.getTaxvteTaux();
         }
      }

      if (this.optionsVentes.getTomDefaut() != null && !this.optionsVentes.getTomDefaut().isEmpty()) {
         var2 = var3.selectTva(this.exercicesVentes.getExevteId(), this.optionsVentes.getTomDefaut(), var1);
         if (var2 != null) {
            this.taux_tom = var2.getTaxvteTaux();
         }
      }

      if (this.optionsVentes.getIrppDefaut() != null && !this.optionsVentes.getIrppDefaut().isEmpty()) {
         var2 = var3.selectTva(this.exercicesVentes.getExevteId(), this.optionsVentes.getIrppDefaut(), var1);
         if (var2 != null) {
            this.taux_irpp = var2.getTaxvteTaux();
         }
      }

      this.chargerPeriodes();
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
         this.inpProprietaire = "";
         this.inpBail = "";
      }

   }

   public void executerRequete() throws IOException, HibernateException, NamingException, ParseException {
      this.chargeListeDetail((Session)null);
   }

   public void chargeListeDetail(Session var1) throws HibernateException, NamingException, ParseException {
      this.listFacture.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      double var2 = 0.0D;
      double var4 = 0.0D;
      double var6 = 0.0D;
      double var8 = 0.0D;
      double var10 = 0.0D;
      double var12 = 0.0D;
      double var14 = 0.0D;
      this.var_nb_ligne = 0;
      String var16 = "";
      String var17 = "";
      if (this.var_more_search) {
         if (this.inpDu != null) {
            var16 = this.utilDate.dateToStringSQLLight(this.inpDu);
         }

         if (this.inpAu != null) {
            var17 = this.utilDate.dateToStringSQLLight(this.inpAu);
         }
      } else {
         var16 = null;
         var17 = null;
      }

      if (this.inpNum != null && !this.inpNum.isEmpty()) {
         this.inpEtat = 100;
      }

      if (this.inpEtat != 50) {
         this.listFacture = this.bienFactureDao.recherche(var1, this.exercicesVentes.getExevteId(), this.getInpNum(), this.getInpClient(), this.getInpProprietaire(), this.getInpBail(), this.getInpEtat(), this.getInpSerie(), "100", this.getPeriode(), "100", this.usersLog.getUsrid(), this.usersLog.getUsrVentes(), "", this.getInpResponsable(), "", "100", var16, var17);
      }

      if (this.listFacture.size() > 0) {
         new BienFacture();

         for(int var19 = 0; var19 < this.listFacture.size(); ++var19) {
            BienFacture var18 = (BienFacture)this.listFacture.get(var19);
            var2 += var18.getBiefacTotTtc();
            var4 += var18.getBiefacTotReglement();
            var6 += var18.getBiefacTotHt();
            var8 += var18.getBiefacTotTva();
            var10 += var18.getBiefacTotalIrpp();
            var14 += var18.getBiefacTlv();
            var12 += var18.getBiefacTotalCom();
         }

         this.var_nb_ligne = this.listFacture.size();
      }

      this.datamodelFacture.setWrappedData(this.listFacture);
      this.montantTtc = var2;
      this.montantReglement = var4;
      this.montantSolde = var2 - var4;
      this.visibiliteBton = false;
   }

   public void selectionLigne() throws HibernateException, NamingException {
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
            this.bienFacture = (BienFacture)var1.get(0);
            this.var_date = this.bienFacture.getBiefacDate();
            if (this.bienFacture.getBiefacDate().getHours() <= 9) {
               this.var_heure = "0" + this.bienFacture.getBiefacDate().getHours();
            } else {
               this.var_heure = "" + this.bienFacture.getBiefacDate().getHours();
            }

            if (this.bienFacture.getBiefacDate().getMinutes() <= 9) {
               this.var_minute = "0" + this.bienFacture.getBiefacDate().getMinutes();
            } else {
               this.var_minute = "" + this.bienFacture.getBiefacDate().getMinutes();
            }

            if (this.bienFacture.getBiefacDate().getSeconds() <= 9) {
               this.var_seconde = "0" + this.bienFacture.getBiefacDate().getSeconds();
            } else {
               this.var_seconde = "" + this.bienFacture.getBiefacDate().getSeconds();
            }

            if (this.bienFacture.getBiefacExoTom() == 1) {
               this.exo_tom = true;
            } else {
               this.exo_tom = false;
            }

            if (this.bienFacture.getBiefacExoTva() == 1) {
               this.exo_tva = true;
            } else {
               this.exo_tva = false;
            }

            Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
            this.locataire = this.bienFacture.getTiers();
            this.proprietaire = this.tiersDao.selectTierD(this.bienFacture.getBiefacIdProprietaire(), var6);
            this.bien = this.bienDao.logBienNum(this.bienFacture.getBiefacBien(), var6);
            if (this.bienFacture.getBiefacBail() != null && !this.bienFacture.getBiefacBail().isEmpty()) {
               this.bienBail = this.bienBailDao.pourParapheur(this.bienFacture.getBiefacBail(), var6);
               if (this.bienBail == null) {
                  this.bienBail = new BienBail();
               } else if (this.bienBail.getBiebaiUsage() == 0) {
                  this.bienBail.setBiebaiExoTva(1);
               }
            } else {
               this.bienBail = new BienBail();
            }

            double var4 = this.chargerReglements(var6);
            this.chargerTaxes();
            if (this.mesContactItem == null || this.mesContactItem.size() == 0) {
               this.mesContactItem.add(new SelectItem(0, ""));
               this.var_nom_contact = 0L;
            }

            if (this.mesUsersItem == null || this.mesUsersItem.size() == 0) {
               this.mesUsersItem.add(new SelectItem(0, ""));
               this.var_nom_responsable = 0L;
            }

            this.utilInitHibernate.closeSession();
            this.bienFacture.setBiefacTotReglement(var4);
            if (var4 >= this.bienFacture.getBiefacTotTtc() + this.bienFacture.getBiefacTotTimbre()) {
               this.bienFacture.setBiefacSolde(1);
            } else {
               this.bienFacture.setBiefacSolde(0);
            }

            this.bienFacture = this.bienFactureDao.modif(this.bienFacture);
            this.visibiliteBton = true;
         } else {
            this.visibiliteBton = false;
         }
      } else {
         this.visibiliteBton = false;
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.bienFacture != null) {
         if (this.bienFacture.getBiefacEtat() == 0) {
            this.modifDocument();
         } else {
            this.consultDocument();
         }
      }

   }

   public double chargerReglements(Session var1) throws HibernateException, NamingException {
      this.lesReglements.clear();
      this.lesReglements = this.reglementsDao.reglementDocument(this.bienFacture.getBiefacId(), 165, var1);
      double var2 = 0.0D;
      if (this.lesReglements.size() != 0) {
         for(int var4 = 0; var4 < this.lesReglements.size(); ++var4) {
            var2 += ((Reglements)this.lesReglements.get(var4)).getRglRecette();
         }
      }

      if (var2 < this.bienFacture.getBiefacTotTtc()) {
         this.var_affiche_dollar = true;
      } else {
         this.var_affiche_dollar = false;
      }

      this.datamodelRecu.setWrappedData(this.lesReglements);
      return var2;
   }

   public void chargerTaxes() {
      if (this.bienFacture.getBiefacModeTlv() != 2) {
         this.var_exo_tlv = true;
         this.bienFacture.setBiefacTauxTlv(0.0D);
      } else {
         this.var_exo_tlv = false;
         this.bienFacture.setBiefacTauxTlv((double)this.taux_tlv);
      }

      if (this.bienFacture.getBiefacExoTva() == 1) {
         this.var_exo_tva = true;
         this.bienFacture.setBiefacTauxTva(0.0D);
      } else {
         this.var_exo_tva = false;
         this.bienFacture.setBiefacTauxTva((double)this.taux_tva);
      }

      if (this.bienFacture.getBiefacExoTom() == 1) {
         this.var_exo_tom = true;
         this.bienFacture.setBiefacTauxTom(0.0D);
      } else {
         this.var_exo_tom = false;
         this.bienFacture.setBiefacTauxTom((double)this.taux_tom);
      }

      if (this.proprietaire.getTieAssujettissement() != 1) {
         this.var_exo_irpp = true;
         this.bienFacture.setBiefacTauxIrpp(0.0D);
      } else {
         this.var_exo_irpp = false;
         this.bienFacture.setBiefacTauxIrpp((double)this.taux_irpp);
      }

   }

   public void ajoutDocument() throws HibernateException, NamingException {
      this.bien = new Bien();
      this.bienFacture = new BienFacture();
      this.proprietaire = new Tiers();
      this.locataire = new Tiers();
      this.bienFacture.setBiefacDate(new Date());
      this.var_action = 1;
      this.var_aff_detail_proprietaire = false;
      this.var_aff_detail_locataire = false;
      this.var_aff_action = false;
      this.visibleOnglet = false;
      this.var_affiche_dollar = false;
      this.var_memo_action = this.var_action;
   }

   public void modifDocument() {
      if (this.bienFacture != null) {
         this.var_action = 1;
         this.var_aff_detail_proprietaire = true;
         this.var_aff_detail_locataire = true;
         this.var_aff_action = false;
         this.var_valide_doc = true;
         this.visibleOnglet = true;
         this.var_memo_action = this.var_action;
      }

   }

   public void consultDocument() {
      if (this.bienFacture != null) {
         this.var_action = 21;
         this.var_aff_detail_proprietaire = true;
         this.var_aff_detail_locataire = true;
         this.var_aff_action = true;
         this.var_valide_doc = false;
         this.visibleOnglet = true;
         this.var_memo_action = this.var_action;
      }

   }

   public void valideDocument() throws HibernateException, NamingException {
      if (this.bienFacture != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.bienFacture.getBiefacEtat() == 0 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
               this.bienFacture.setBiefacEtat(1);
               this.bienFacture = this.bienFactureDao.modif(this.bienFacture, var1);
               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Validation manuelle facture (I.) N° " + this.bienFacture.getBiefacNum() + " du " + this.utilDate.dateToStringSQLLight(this.bienFacture.getBiefacDate()));
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

   public void deValideDocument() throws HibernateException, NamingException {
      if (this.bienFacture != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.bienFacture.getBiefacEtat() == 1 && this.bienFacture.getBiefacTotReglement() == 0.0D && this.habilitation == null) {
               this.bienFacture.setBiefacEtat(0);
               this.bienFacture.setBiefacDateImp((Date)null);
               this.bienFacture = this.bienFactureDao.modif(this.bienFacture, var1);
               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Dévalidation manuelle facture (I.) N° " + this.bienFacture.getBiefacNum() + " du " + this.utilDate.dateToStringSQLLight(this.bienFacture.getBiefacDate()));
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
                  this.bienFacture = (BienFacture)this.listFacture.get(var3);
                  if (this.bienFacture.getBiefacEtat() == 0) {
                     this.bienFacture.setBiefacEtat(1);
                     this.bienFacture = this.bienFactureDao.modif(this.bienFacture, var1);
                     Espion var4 = new Espion();
                     var4.setUsers(this.usersLog);
                     var4.setEsptype(0);
                     var4.setEspdtecreat(new Date());
                     var4.setEspaction("Validation manuelle facture (I.) N° " + this.bienFacture.getBiefacNum() + " du " + this.utilDate.dateToStringSQLLight(this.bienFacture.getBiefacDate()));
                     this.espionDao.mAJEspion(var4, var1);
                  }
               }

               this.datamodelFacture.setWrappedData(this.listFacture);
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
                  this.bienFacture = (BienFacture)this.listFacture.get(var3);
                  if (this.bienFacture.getBiefacEtat() == 1 && this.bienFacture.getBiefacTotReglement() == 0.0D) {
                     this.bienFacture.setBiefacEtat(0);
                     this.bienFacture.setBiefacDateImp((Date)null);
                     this.bienFacture = this.bienFactureDao.modif(this.bienFacture, var1);
                     Espion var4 = new Espion();
                     var4.setUsers(this.usersLog);
                     var4.setEsptype(0);
                     var4.setEspdtecreat(new Date());
                     var4.setEspaction("Dévalidation manuelle facture (I.) N° " + this.bienFacture.getBiefacNum() + " du " + this.utilDate.dateToStringSQLLight(this.bienFacture.getBiefacDate()));
                     this.espionDao.mAJEspion(var4, var1);
                  }
               }

               this.datamodelFacture.setWrappedData(this.listFacture);
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

      this.visibiliteBton = false;
   }

   public void supprimerDocument() {
      this.choixSuppression = 0;
      this.showModalPanelSuppression = true;
   }

   public void validerSupprimer() throws HibernateException, NamingException {
      if (this.bienFacture != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.choixSuppression == 1) {
               if (this.lesReglements.size() == 0) {
                  String var13 = this.bienFacture.getBiefacNum();
                  this.bienFactureDao.delete(this.bienFacture, var1);
                  this.listFacture.remove(this.bienFacture);
                  this.datamodelFacture.setWrappedData(this.listFacture);
                  Espion var14 = new Espion();
                  var14.setUsers(this.usersLog);
                  var14.setEsptype(0);
                  var14.setEspdtecreat(new Date());
                  var14.setEspaction("Suppression Facture N° " + var13);
                  this.espionDao.mAJEspion(var14, var1);
               }
            } else if (this.choixSuppression == 2) {
               boolean var3 = false;
               if (this.listFacture.size() != 0) {
                  String var4 = this.utilDate.dateToPeriodeFr(((BienFacture)this.listFacture.get(0)).getBiefacDateDebut());
                  String var5 = null;
                  new BienFacture();

                  for(int var7 = 0; var7 < this.listFacture.size(); ++var7) {
                     BienFacture var6 = (BienFacture)this.listFacture.get(var7);
                     if (var6.getBiefacTotReglement() == 0.0D) {
                        var5 = this.utilDate.dateToPeriodeFr(var6.getBiefacDateFin());
                        this.bienFactureDao.modif(var6, var1);
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
      Date var1 = this.utilDate.CalculDateEcheance(this.bienFacture.getBiefacDate(), this.bienFacture.getBiefacTypeReg(), this.bienFacture.getBiefacNbJourReg(), this.bienFacture.getBiefacArrondiReg());
      return var1;
   }

   public void validerFacture() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.locataire != null && this.locataire.getTieid() != 0L) {
            this.bienFacture.setTiers(this.locataire);
         } else {
            this.bienFacture.setTiers((Tiers)null);
         }

         if (this.var_timbre != 0) {
            int var3 = this.var_date.getYear() + 1900;
            double var4 = this.utilNombre.calculTimbre(this.structureLog, this.bienFacture.getBiefacTotTtc() + this.bienFacture.getBiefacTotTc(), var3, this.bienFacture.getBiefacDevise(), this.bienFacture.getBiefacDate());
            this.val_timbre = this.utilNombre.myRoundDevise(var4, this.bienFacture.getBiefacDevise());
            if (this.val_timbre != 0.0D) {
               String var6 = this.utilNombre.beginSimple(this.val_timbre, this.bienFacture.getBiefacDevise());
               this.bienFacture.setBiefacFormule2(this.utilNombre.texteTimbre(this.structureLog, var6, var3, this.bienFacture.getBiefacDevise(), this.bienFacture.getBiefacDate()));
            }
         }

         if (this.bienFacture.getBiefacId() == 0L) {
            if (this.bienFacture.getBiefacNum() == null || this.bienFacture.getBiefacNum().isEmpty()) {
               this.bienFacture.setBiefacNum(this.calculChrono.numCompose(this.bienFacture.getBiefacDate(), this.nature, this.bienFacture.getBiefacSerie(), var1));
            }

            this.bienFacture.setBiefacDateCreat(new Date());
            this.bienFacture.setBiefacIdCreateur(this.usersLog.getUsrid());
            this.bienFacture = this.bienFactureDao.insert(this.bienFacture, var1);
            this.listFacture.add(this.bienFacture);
            this.datamodelFacture.setWrappedData(this.listFacture);
         } else {
            this.bienFacture.setBiefacDateModif(new Date());
            this.bienFacture.setBiefacIdModif(this.usersLog.getUsrid());
            this.bienFacture = this.bienFactureDao.modif(this.bienFacture, var1);
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

      this.var_action = 0;
      this.var_memo_action = this.var_action;
   }

   public void exoTva() {
      if (this.var_exo_tva) {
         this.bienFacture.setBiefacExoTva(1);
      } else {
         this.bienFacture.setBiefacExoTva(0);
      }

      this.calculFacture();
   }

   public void exoTom() {
      if (this.var_exo_tom) {
         this.bienFacture.setBiefacExoTom(1);
      } else {
         this.bienFacture.setBiefacExoTom(0);
      }

      this.calculFacture();
   }

   public void calculFacture() {
      double var1 = 0.0D;
      double var3;
      if (this.bienFacture.getBiefacTauxCharges() != 0.0D) {
         var3 = this.utilNombre.myRoundDevise(this.bienFacture.getBiefacLoyerBrut() * this.bienFacture.getBiefacTauxCharges() / 100.0D, this.structureLog.getStrdevise());
         this.bienFacture.setBiefacChargesImmeuble(var3);
      }

      var1 = this.bienFacture.getBiefacLoyerBrut() + this.bienFacture.getBiefacChargesImmeuble() + this.bienFacture.getBiefacEau() + this.bienFacture.getBiefacElectricite() + this.bienFacture.getBiefacParking() + this.bienFacture.getBiefacGardiennage() + this.bienFacture.getBiefacJardinnier() + this.bienFacture.getBiefacDiversFrais() + this.bienFacture.getBiefacGroupeElectro() + this.bienFacture.getBiefacFraisComplement();
      if (this.bienFacture.getBiefacModeTlv() == 0) {
         this.bienFacture.setBiefacTlv(0.0D);
      } else {
         var3 = this.utilNombre.myRoundDevise((this.bienFacture.getBiefacLoyerBrut() + this.bienFacture.getBiefacChargesImmeuble()) * this.bienFacture.getBiefacTauxTlv() / 100.0D, this.structureLog.getStrdevise());
         this.bienFacture.setBiefacTlv(var3);
      }

      if (this.bienFacture.getBiefacExoTom() == 1) {
         this.bienFacture.setBiefacTom(0.0D);
      } else {
         var3 = this.utilNombre.myRoundDevise(this.bienFacture.getBiefacLoyerBrut() * this.bienFacture.getBiefacTauxTom() / 100.0D, this.structureLog.getStrdevise());
         this.bienFacture.setBiefacTom(var3);
      }

      double var5;
      if (this.bienFacture.getBiefacExoTva() == 1) {
         this.bienFacture.setBiefacTotTva(0.0D);
      } else if (this.bienFacture.getBiefacUsage() == 0) {
         this.bienFacture.setBiefacTotTva(0.0D);
      } else {
         var3 = 0.0D;
         if (this.bienFacture.getBiefacLoyerProf() != 0.0D) {
            var5 = this.bienFacture.getBiefacLoyerProf() / this.bienFacture.getBiefacLoyerBrut() * this.bienFacture.getBiefacChargesImmeuble();
            var3 = this.bienFacture.getBiefacLoyerProf() + var5;
         } else {
            var3 = this.bienFacture.getBiefacLoyerBrut() + this.bienFacture.getBiefacChargesImmeuble();
         }

         var5 = this.utilNombre.myRoundDevise(var3 * this.bienFacture.getBiefacTauxTva() / 100.0D, this.structureLog.getStrdevise());
         this.bienFacture.setBiefacTotTva(var5);
      }

      var3 = var1 + this.bienFacture.getBiefacTotTva() + this.bienFacture.getBiefacTom() + this.bienFacture.getBiefacTlv();
      this.bienFacture.setBiefacLoyerNet(var3);
      this.bienFacture.setBiefacTotTtc(var3);
      this.bienFacture.setBiefacTotHt(this.bienFacture.getBiefacTotTtc() - this.bienFacture.getBiefacTotTva());
      double var7;
      if (this.bienFacture.getBiefacTauxCom() != 0.0D) {
         var5 = this.utilNombre.myRoundDevise(this.bienFacture.getBiefacLoyerBrut() * this.bienFacture.getBiefacTauxCom() / 100.0D, this.structureLog.getStrdevise()) + this.bienFacture.getBiefacForfaitGerance();
         this.bienFacture.setBiefacTotalCom(var5);
         if (this.bienFacture.getBiefacTauxTvaCom() != 0.0F) {
            var7 = this.utilNombre.myRoundDevise(this.bienFacture.getBiefacTotalCom() * (double)this.bienFacture.getBiefacTauxTvaCom() / 100.0D, this.structureLog.getStrdevise());
            this.bienFacture.setBiefacTvaCom(var7);
         } else {
            this.bienFacture.setBiefacTvaCom(0.0D);
         }
      } else if (this.bienFacture.getBiefacForfaitGerance() != 0.0D) {
         var5 = this.bienFacture.getBiefacForfaitGerance();
         this.bienFacture.setBiefacTotalCom(var5);
         if (this.bienFacture.getBiefacTauxTvaCom() != 0.0F) {
            var7 = this.utilNombre.myRoundDevise(this.bienFacture.getBiefacTotalCom() * (double)this.bienFacture.getBiefacTauxTvaCom() / 100.0D, this.structureLog.getStrdevise());
            this.bienFacture.setBiefacTvaCom(var7);
         } else {
            this.bienFacture.setBiefacTvaCom(0.0D);
         }
      } else {
         this.bienFacture.setBiefacTotalCom(0.0D);
         this.bienFacture.setBiefacTvaCom(0.0D);
      }

      if (this.bienFacture.getBiefacTypeProprietaire() == 1 && this.bienFacture.getBiefacLoyerBrut() >= 150000.0D) {
         var5 = this.utilNombre.myRoundDevise(this.bienFacture.getBiefacLoyerBrut() * this.bienFacture.getBiefacTauxIrpp() / 100.0D, this.structureLog.getStrdevise());
         this.bienFacture.setBiefacTotalIrpp(var5);
      } else {
         this.bienFacture.setBiefacTotalIrpp(0.0D);
      }

   }

   public void annulerDocument() {
      if (this.bienFacture != null) {
         this.bienFacture.setBiefacDateAnnule(new Date());
         this.showModalPanelAnnuler = true;
      }

   }

   public void annuleAnnulation() {
      this.showModalPanelAnnuler = false;
   }

   public void miseajourAnnuler() throws HibernateException, NamingException {
      if (this.bienFacture != null) {
         if (this.bienFacture.getBiefacDateAnnule() == null) {
            this.bienFacture.setBiefacDateAnnule(new Date());
         }

         this.bienFacture.setBiefacEtat(3);
         this.bienFacture = this.bienFactureDao.modif(this.bienFacture);
         if (this.lesReglements.size() != 0) {
            for(int var1 = 0; var1 < this.lesReglements.size(); ++var1) {
               this.reglements = (Reglements)this.lesReglements.get(var1);
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

         Espion var5 = new Espion();
         var5.setUsers(this.usersLog);
         var5.setEsptype(0);
         var5.setEspdtecreat(new Date());
         var5.setEspaction("Annulation facture location N° " + this.bienFacture.getBiefacNum() + " pour " + this.bienFacture.getBiefacMotifAnnule());
         this.espionDao.mAJEspion(var5);
         this.listFacture.remove(this.bienFacture);
         this.datamodelFacture.setWrappedData(this.listFacture);
      }

      this.showModalPanelAnnuler = false;
      this.visibiliteBton = false;
   }

   public void reactiverDocument() throws HibernateException, NamingException {
      if (this.bienFacture != null) {
         this.bienFacture.setBiefacEtat(0);
         this.bienFacture.setBiefacDateAnnule((Date)null);
         this.bienFacture.setBiefacMotifAnnule("");
         this.bienFacture = this.bienFactureDao.modif(this.bienFacture);
         if (this.lesReglements.size() != 0) {
            for(int var1 = 0; var1 < this.lesReglements.size(); ++var1) {
               this.reglements = (Reglements)this.lesReglements.get(var1);
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
         var5.setEspaction("Réactivation facture location N° " + this.bienFacture.getBiefacNum());
         this.espionDao.mAJEspion(var5);
      }

   }

   public void ouvrirFacturation() throws ParseException {
      this.chargerPeriodes();
      this.chargerModeleFactures();
      this.numeroBail = "";
      this.periode = null;
      this.nomProprietaire = "";
      this.nomLocataire = "";
      this.showModalPanelAuto = true;
   }

   public void fermerFacturation() {
      this.showModalPanelAuto = false;
   }

   public void validerFacturation() throws HibernateException, NamingException, ParseException, IOException {
      if (this.periode != null && !this.periode.isEmpty()) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            Object var3 = null;
            Object var4 = null;
            String var5 = "";
            boolean var6 = false;
            int var15;
            if (this.optionsVentes.getNbrJrRelanceFAC() != null && !this.optionsVentes.getNbrJrRelanceFAC().isEmpty()) {
               var15 = Integer.parseInt(this.optionsVentes.getNbrJrRelanceFAC());
            } else {
               var15 = 0;
            }

            boolean var7 = false;
            int var16;
            if (this.optionsVentes.getNbrJrValidFAC() != null && !this.optionsVentes.getNbrJrValidFAC().isEmpty()) {
               var16 = Integer.parseInt(this.optionsVentes.getNbrJrValidFAC());
            } else {
               var16 = 0;
            }

            if (this.numeroBail != null && !this.numeroBail.isEmpty()) {
               this.bienBail = this.bienBailDao.pourParapheur(this.numeroBail, var1);
               if (this.bienBail != null) {
                  this.preparationCalcul((Date)var3, (Date)var4, var5, var15, var16, var1);
               }
            } else {
               new ArrayList();
               List var8 = this.bienBailDao.chargerBauxActifs(var1);
               if (var8.size() != 0) {
                  this.bienBail = new BienBail();

                  for(int var9 = 0; var9 < var8.size(); ++var9) {
                     this.bienBail = (BienBail)var8.get(var9);
                     this.preparationCalcul((Date)var3, (Date)var4, var5, var15, var16, var1);
                  }
               }
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

         this.executerRequete();
      }

      this.showModalPanelAuto = false;
   }

   public void preparationCalcul(Date var1, Date var2, String var3, int var4, int var5, Session var6) throws ParseException, HibernateException, NamingException {
      if (this.bienBail.getBiebaiDateDebut() == null) {
         this.bienBail.setBiebaiDateDebut(this.inpDu);
      }

      this.locataire = this.bienBail.getTiers();
      this.bien = this.bienBail.getBien();
      long var7 = 0L;
      long var9 = 0L;
      boolean var11 = false;
      if (this.bienBail.getBiebaiMode() != 0 && this.bienBail.getBiebaiMode() != 1) {
         int var12;
         String var13;
         if (this.bienBail.getBiebaiMode() == 2) {
            var12 = this.inpDu.getMonth() + 1;
            var13 = "";
            if (var12 <= 9) {
               var13 = "0" + var12;
            } else {
               var13 = "" + var12;
            }

            var1 = this.utilDate.stringToDateSQLLight(this.inpDu.getYear() + 1900 + "-" + var13 + "-" + "01");
            var2 = this.utilDate.dateDernierJourMois(var1);
            var3 = "Facturation du mois " + var13 + "/" + (this.inpDu.getYear() + 1900);
            var11 = true;
         } else {
            String var14;
            int var15;
            String var16;
            boolean var17;
            int var18;
            if (this.bienBail.getBiebaiMode() == 3) {
               var12 = this.inpDu.getMonth() + 1;
               var17 = false;
               if (this.bienBail.getBiebaiDateDebut().before(this.inpDu)) {
                  var18 = this.inpDu.getMonth() + 1;
               } else {
                  var18 = this.bienBail.getBiebaiDateDebut().getMonth() + 1;
               }

               if (var12 >= 1 && var12 <= 3 && var18 >= 1 && var18 <= 3) {
                  var12 = 1;
               } else if (var12 >= 4 && var12 <= 6 && var18 >= 4 && var18 <= 6) {
                  var12 = 4;
               } else if (var12 >= 7 && var12 <= 9 && var18 >= 7 && var18 <= 9) {
                  var12 = 7;
               } else if (var12 >= 10 && var12 <= 12 && var18 >= 10 && var18 <= 12) {
                  var12 = 10;
               }

               var14 = "";
               if (var12 <= 9) {
                  var14 = "0" + var12;
               } else {
                  var14 = "" + var12;
               }

               var1 = this.utilDate.stringToDateSQLLight(this.inpDu.getYear() + 1900 + "-" + var14 + "-" + "01");
               var15 = this.inpDu.getMonth() + 1;
               if (var15 >= 1 && var15 <= 3) {
                  var15 = 3;
               } else if (var15 >= 4 && var15 <= 6) {
                  var15 = 6;
               } else if (var15 >= 7 && var15 <= 9) {
                  var15 = 9;
               } else if (var15 >= 10 && var15 <= 12) {
                  var15 = 12;
               }

               var16 = "";
               if (var15 <= 9) {
                  var16 = "0" + var15;
               } else {
                  var16 = "" + var15;
               }

               var2 = this.utilDate.dateDernierJourMois(this.utilDate.stringToDateSQLLight(this.inpAu.getYear() + 1900 + "-" + var16 + "-" + "01"));
               if (var12 == this.inpDu.getMonth() + 1) {
                  if (this.inpDu.getMonth() + 1 >= 1 && this.inpDu.getMonth() + 1 <= 3) {
                     var3 = "Facture du 1er trimestre " + (this.inpDu.getYear() + 1900);
                  } else if (this.inpDu.getMonth() + 1 >= 4 && this.inpDu.getMonth() + 1 <= 6) {
                     var3 = "Facture du 2eme trimestre " + (this.inpDu.getYear() + 1900);
                  } else if (this.inpDu.getMonth() + 1 >= 7 && this.inpDu.getMonth() + 1 <= 9) {
                     var3 = "Facture du 3eme trimestre " + (this.inpDu.getYear() + 1900);
                  } else if (this.inpDu.getMonth() + 1 >= 10 && this.inpDu.getMonth() + 1 <= 12) {
                     var3 = "Facture du 4eme trimestre " + (this.inpDu.getYear() + 1900);
                  }

                  var11 = true;
               }
            } else if (this.bienBail.getBiebaiMode() == 4) {
               var12 = this.inpDu.getMonth() + 1;
               var17 = false;
               if (this.inpDu.before(this.bienBail.getBiebaiDateDebut())) {
                  var18 = this.inpDu.getMonth() + 1;
               } else {
                  var18 = this.bienBail.getBiebaiDateDebut().getMonth() + 1;
               }

               if (var12 >= 1 && var12 <= 6 && var18 >= 1 && var18 <= 6) {
                  var12 = 1;
               } else if (var12 >= 7 && var12 <= 12 && var18 >= 7 && var18 <= 12) {
                  var12 = 7;
               }

               var14 = "";
               if (var12 <= 9) {
                  var14 = "0" + var12;
               } else {
                  var14 = "" + var12;
               }

               var1 = this.utilDate.stringToDateSQLLight(this.inpDu.getYear() + 1900 + "-" + var14 + "-" + "01");
               var15 = this.bienBail.getBiebaiDateDebut().getMonth() + 1;
               if (var15 >= 1 && var15 <= 6) {
                  var15 = 6;
               } else if (var15 >= 7 && var15 <= 12) {
                  var15 = 12;
               }

               var16 = "";
               if (var15 <= 9) {
                  var16 = "0" + var15;
               } else {
                  var16 = "" + var15;
               }

               var2 = this.utilDate.dateDernierJourMois(this.utilDate.stringToDateSQLLight(this.inpAu.getYear() + 1900 + "-" + var16 + "-" + "01"));
               if (var12 == this.inpDu.getMonth() + 1) {
                  if (this.inpDu.getMonth() + 1 >= 1 && this.inpDu.getMonth() + 1 <= 6) {
                     var3 = "Facture du 1er semestre " + (this.inpDu.getYear() + 1900);
                  } else if (this.inpDu.getMonth() + 1 >= 7 && this.inpDu.getMonth() + 1 <= 12) {
                     var3 = "Facture du 2eme semestre " + (this.inpDu.getYear() + 1900);
                  }

                  var11 = true;
               }
            } else if (this.bienBail.getBiebaiMode() == 5) {
               var12 = this.inpDu.getMonth() + 1;
               var13 = "0" + var12;
               var1 = this.utilDate.stringToDateSQLLight(this.inpDu.getYear() + 1900 + "-" + var13 + "-" + "01");
               int var19 = this.inpAu.getMonth() + 1;
               String var20 = "" + var19;
               var2 = this.utilDate.dateDernierJourMois(this.utilDate.stringToDateSQLLight(this.inpAu.getYear() + 1900 + "-" + var20 + "-" + "01"));
               if (var12 == this.inpDu.getMonth() + 1) {
                  var3 = "Facturation de l'année " + (this.inpDu.getYear() + 1900);
                  var11 = true;
               }
            }
         }
      }

      if (var11 && this.locataire != null && (this.bienBail.getBiebaiDateFinFacture() == null || this.bienBail.getBiebaiDateFinFacture() != null && this.bienBail.getBiebaiDateFinFacture().getMonth() + 1 == var2.getMonth() + 1 && this.bienBail.getBiebaiDateFinFacture().getYear() + 1900 == var2.getYear() + 1900)) {
         this.validerFacturationSuite(0, var7, var9, var1, var2, var4, var5, var3, (Date)null, (Date)null, (String)null, var6);
         this.bienFacture = this.bienFactureDao.insert(this.bienFacture, var6);
      }

   }

   public void recalculFacture() throws HibernateException, NamingException, ParseException {
      if (this.bienFacture != null) {
         Object var1 = null;
         Object var2 = null;
         String var3 = this.bienFacture.getBiefacObject();
         Date var4 = this.bienFacture.getBiefacDateDebut();
         Date var5 = this.bienFacture.getBiefacDateFin();
         String var6 = this.bienFacture.getBiefacObject();
         boolean var7 = false;
         int var13;
         if (this.optionsVentes.getNbrJrRelanceFAC() != null && !this.optionsVentes.getNbrJrRelanceFAC().isEmpty()) {
            var13 = Integer.parseInt(this.optionsVentes.getNbrJrRelanceFAC());
         } else {
            var13 = 0;
         }

         boolean var8 = false;
         int var14;
         if (this.optionsVentes.getNbrJrValidFAC() != null && !this.optionsVentes.getNbrJrValidFAC().isEmpty()) {
            var14 = Integer.parseInt(this.optionsVentes.getNbrJrValidFAC());
         } else {
            var14 = 0;
         }

         long var9 = 0L;
         long var11 = 0L;
         this.validerFacturationSuite(1, var9, var11, var4, var5, var13, var14, var6, (Date)var1, (Date)var2, var3, (Session)null);
      }

   }

   public void validerFacturationSuite(int var1, long var2, long var4, Date var6, Date var7, int var8, int var9, String var10, Date var11, Date var12, String var13, Session var14) throws HibernateException, NamingException, ParseException {
      if (this.bienBail.getBiebaiMode() == 2) {
         var11 = this.utilDate.datePremierJourMois(var6);
         var12 = this.utilDate.dateDernierJourMois(var6);
      } else if (this.bienBail.getBiebaiMode() == 3) {
         if (var6.getMonth() + 1 != 1 && var6.getMonth() + 1 != 2 && var6.getMonth() + 1 != 3) {
            if (var6.getMonth() + 1 != 4 && var6.getMonth() + 1 != 5 && var6.getMonth() + 1 != 6) {
               if (var6.getMonth() + 1 != 7 && var6.getMonth() + 1 != 8 && var6.getMonth() + 1 != 9) {
                  if (var6.getMonth() + 1 == 10 || var6.getMonth() + 1 == 11 || var6.getMonth() + 1 == 12) {
                     var11 = this.utilDate.stringToDateSQLLight(var6.getYear() + 1900 + "-10-01");
                     var12 = this.utilDate.stringToDateSQLLight(var6.getYear() + 1900 + "-12-31");
                  }
               } else {
                  var11 = this.utilDate.stringToDateSQLLight(var6.getYear() + 1900 + "-07-01");
                  var12 = this.utilDate.stringToDateSQLLight(var6.getYear() + 1900 + "-09-30");
               }
            } else {
               var11 = this.utilDate.stringToDateSQLLight(var6.getYear() + 1900 + "-04-01");
               var12 = this.utilDate.stringToDateSQLLight(var6.getYear() + 1900 + "-06-30");
            }
         } else {
            var11 = this.utilDate.stringToDateSQLLight(var6.getYear() + 1900 + "-01-01");
            var12 = this.utilDate.stringToDateSQLLight(var6.getYear() + 1900 + "-03-31");
         }
      } else if (this.bienBail.getBiebaiMode() == 4) {
         if (var6.getMonth() + 1 >= 1 && var6.getMonth() + 1 <= 6) {
            var11 = this.utilDate.stringToDateSQLLight(var6.getYear() + 1900 + "-01-01");
            var12 = this.utilDate.stringToDateSQLLight(var6.getYear() + 1900 + "-06-30");
         } else if (var6.getMonth() + 1 >= 7 && var6.getMonth() + 1 <= 12) {
            var11 = this.utilDate.stringToDateSQLLight(var6.getYear() + 1900 + "-07-01");
            var12 = this.utilDate.stringToDateSQLLight(var6.getYear() + 1900 + "-12-31");
         }
      } else if (this.bienBail.getBiebaiMode() == 5) {
         var11 = this.utilDate.datePremierJourAnnee(var6);
         var12 = this.utilDate.dateDernierJourAnnee(var6);
      }

      if (var13 == null || var13.isEmpty()) {
         var13 = var10;
      }

      float var15 = 1.0F;
      var2 = (long)((var12.getYear() + 1900 - (var11.getYear() + 1900)) * 12 + (var12.getMonth() + 1 + 1 - (var11.getMonth() + 1)) * 30);
      var4 = (long)((var7.getYear() + 1900 - (var6.getYear() + 1900)) * 12 + (var7.getMonth() + 1 + 1 - (var6.getMonth() + 1)) * 30);
      if (this.bienBail.getBiebaiDateFinFacture() != null) {
         var7 = this.bienBail.getBiebaiDateFinFacture();
      }

      if (var11.before(this.bienBail.getBiebaiDateDebut())) {
         if (this.bienBail.getBiebaiDateDebut().getDate() != 1) {
            var4 -= (long)(this.bienBail.getBiebaiDateDebut().getDate() - 1);
         }

         if (var12.compareTo(var7) != 0) {
            var4 -= (long)(30 - var7.getDate());
         }
      } else {
         if (var6.getDate() != 1) {
            var4 -= (long)(var6.getDate() - 1);
         }

         if (var12.compareTo(var7) != 0) {
            var4 -= (long)(30 - var7.getDate());
         }
      }

      var15 = (float)var4 / (float)var2;
      if (var15 >= 1.0F) {
         var15 = 1.0F;
      }

      boolean var16 = false;
      String var17 = "";
      String var18 = this.utilDate.dateToStringSQLLight(var11);
      String var19 = this.utilDate.dateToStringSQLLight(var12);
      if (var1 == 0) {
         this.bienFacture = this.bienFactureDao.pourParapheurAutomatique(this.locataire.getTieid(), this.bien.getBieId(), this.bienBail.getBiebaiNum(), var18, var19, var14);
         if (this.bienFacture != null) {
            if (this.bienFacture.getBiefacEtat() == 0) {
               var17 = this.bienFacture.getBiefacNum();
               this.bienFactureDao.delete(this.bienFacture, var14);
               var16 = true;
            } else {
               var16 = false;
            }
         } else {
            var16 = true;
         }
      } else {
         var17 = this.bienFacture.getBiefacNum();
         var16 = true;
      }

      if (var16) {
         if (var1 == 0) {
            this.bienFacture = new BienFacture();
         }

         this.bienFacture.setExerciceventes(this.exercicesVentes);
         this.bienFacture.setBien(this.bien);
         this.bienFacture.setTiers(this.locataire);
         this.bienFacture.setUsers(this.usersLog);
         this.bienFacture.setBiefacBail(this.bienBail.getBiebaiNum());
         this.bienFacture.setBiefacBanque("");
         this.bienFacture.setBiefacBien(this.bienBail.getBien().getBieNum());
         this.bienFacture.setBiefacBudget("");
         this.bienFacture.setBiefacCat("");
         this.bienFacture.setBiefacChargesImmeuble(this.bienBail.getBiebaiCharges() * (double)var15);
         this.bienFacture.setBiefacCivilContact("");
         if (this.bienBail.getBiebaiCivilProprietaire() != null && !this.bienBail.getBiebaiCivilProprietaire().isEmpty()) {
            this.bienFacture.setBiefacCivilProprietaire(this.bienBail.getBiebaiCivilProprietaire());
         } else {
            this.bienFacture.setBiefacCivilProprietaire((String)null);
         }

         if (this.bienBail.getBiebaiCivilTiers() != null && !this.bienBail.getBiebaiCivilTiers().isEmpty()) {
            this.bienFacture.setBiefacCivilTiers(this.bienBail.getBiebaiCivilTiers());
         } else {
            this.bienFacture.setBiefacCivilTiers("");
         }

         int var20 = var6.getMonth() + 1;
         String var21 = "";
         if (var20 <= 9) {
            var21 = "0" + var20;
         } else {
            var21 = "" + var20;
         }

         this.bienFacture.setBiefacContrat(var21 + ":" + (var6.getYear() + 1900) + ":" + this.bienBail.getBiebaiNum());
         this.bienFacture.setBiefacDate(var11);
         this.bienFacture.setBiefacDateAnnule((Date)null);
         this.bienFacture.setBiefacDateCreat(new Date());
         this.bienFacture.setBiefacDateDebut(var6);
         this.bienFacture.setBiefacDateFin(var7);
         this.bienFacture.setBiefacDateImp((Date)null);
         this.bienFacture.setBiefacDateLastReg((Date)null);
         this.bienFacture.setBiefacDateModif((Date)null);
         this.bienFacture.setBiefacDateRelance(this.utilDate.datedevaleurTheo(var11, var8));
         this.bienFacture.setBiefacDateTransfert((Date)null);
         this.bienFacture.setBiefacDateTransforme((Date)null);
         this.bienFacture.setBiefacDateValide((Date)null);
         this.bienFacture.setBiefacDateValidite(this.utilDate.datedevaleurTheo(var11, var9));
         this.bienFacture.setBiefacDateVisa((Date)null);
         this.bienFacture.setBiefacDepartement((String)null);
         this.bienFacture.setBiefacDevise(this.structureLog.getStrdevise());
         this.bienFacture.setBiefacDiversFrais(this.bienBail.getBiebaiDiversFrais() * (double)var15);
         this.bienFacture.setBiefacEau(this.bienBail.getBiebaiEau() * (double)var15);
         this.bienFacture.setBiefacEcheanceReliquat((Date)null);
         this.bienFacture.setBiefacElectricite(this.bienBail.getBiebaiElectricite() * (double)var15);
         this.bienFacture.setBiefacEtat(1);
         this.bienFacture.setBiefacEtatVal(0);
         this.bienFacture.setBiefacExoTom(this.bienBail.getBiebaiExoTom());
         this.bienFacture.setBiefacExoTva(this.bienBail.getBiebaiExoTva());
         this.bienFacture.setBiefacFormule1((String)null);
         this.bienFacture.setBiefacFormule2((String)null);
         this.bienFacture.setBiefacFraisComplement(this.bienBail.getBiebaiFraisComplement() * (double)var15);
         this.bienFacture.setBiefacGardiennage(this.bienBail.getBiebaiGardiennage() * (double)var15);
         this.bienFacture.setBiefacGele(0);
         this.bienFacture.setBiefacGroupeElectro(this.bienBail.getBiebaiGroupeElectro() * (double)var15);
         this.bienFacture.setBiefacIdCommercial(0L);
         this.bienFacture.setBiefacIdContact(0L);
         this.bienFacture.setBiefacIdCreateur(this.usersLog.getUsrid());
         this.bienFacture.setBiefacIdModif(0L);
         this.bienFacture.setBiefacIdProprietaire(this.bienBail.getBiebaiIdProprietaire());
         this.bienFacture.setBiefacIdResponsable(this.bienBail.getBiebaiIdResponsable());
         this.bienFacture.setBiefacInfo1("");
         this.bienFacture.setBiefacInfo2("");
         this.bienFacture.setBiefacInfo3("");
         this.bienFacture.setBiefacInfo4("");
         this.bienFacture.setBiefacInfo5("");
         this.bienFacture.setBiefacInfo6("");
         this.bienFacture.setBiefacInfo7("");
         this.bienFacture.setBiefacInfo8("");
         this.bienFacture.setBiefacInfo9("");
         this.bienFacture.setBiefacInfo10("");
         this.bienFacture.setBiefacJardinnier(this.bienBail.getBiebaiJardinier() * (double)var15);
         this.bienFacture.setBiefacJournalReg(this.locataire.getTiejournalreg());
         this.bienFacture.setBiefacLibelleFrais(this.bienBail.getBiebaiLibelleFrais());
         this.bienFacture.setBiefacLoyerBrut(this.bienBail.getBiebaiLoyerBrut() * (double)var15);
         this.bienFacture.setBiefacLoyerNet(this.bienBail.getBiebaiLoyerNet() * (double)var15);
         this.bienFacture.setBiefacMode(this.bienBail.getBiebaiMode());
         this.bienFacture.setBiefacModeReg(this.locataire.getTiemodereg());
         this.bienFacture.setBiefacModeTlv(this.bienBail.getBiebaiModeTlv());
         this.bienFacture.setBiefacModeleImp(this.modeleFacture);
         this.bienFacture.setBiefacMotifAnnule((String)null);
         this.bienFacture.setBiefacMotifExo((String)null);
         this.bienFacture.setBiefacNbJourReg(this.locataire.getTienbecheance());
         this.bienFacture.setBiefacNetPayer(this.bienBail.getBiebaiLoyerNet() * (double)var15);
         this.bienFacture.setBiefacNomCommercial((String)null);
         this.bienFacture.setBiefacNomContact("");
         this.bienFacture.setBiefacNomCreateur(this.usersLog.getUsrPatronyme());
         this.bienFacture.setBiefacNomModif((String)null);
         if (this.bienBail.getBiebaiNomProprietaire() != null && !this.bienBail.getBiebaiNomProprietaire().isEmpty()) {
            this.bienFacture.setBiefacNomProprietaire(this.bienBail.getBiebaiNomProprietaire());
         } else {
            this.bienFacture.setBiefacNomProprietaire((String)null);
         }

         this.bienFacture.setBiefacNomResponsable(this.bienBail.getBiebaiNomResponsable());
         if (this.bienBail.getBiebaiNomTiers() != null && !this.bienBail.getBiebaiNomTiers().isEmpty()) {
            this.bienFacture.setBiefacNomTiers(this.bienBail.getBiebaiNomTiers());
         } else {
            this.bienFacture.setBiefacNomTiers((String)null);
         }

         String var22 = "";
         if (var17 != null && !var17.isEmpty()) {
            var22 = var17;
         } else {
            var22 = this.calculChrono.numCompose(this.bienFacture.getBiefacDate(), this.nature, this.bienFacture.getBiefacSerie(), var14);
         }

         this.bienFacture.setBiefacNum(var22);
         this.bienFacture.setBiefacNumAvoir((String)null);
         this.bienFacture.setBiefacNumTrf((String)null);
         this.bienFacture.setBiefacNumVisa((String)null);
         this.bienFacture.setBiefacObject(var13);
         this.bienFacture.setBiefacObservation("");
         this.bienFacture.setBiefacParking(this.bienBail.getBiebaiParking() * (double)var15);
         this.bienFacture.setBiefacPdv(this.locataire.getTiepdv());
         this.bienFacture.setBiefacRangeVisa((String)null);
         this.bienFacture.setBiefacRegion(this.locataire.getTieregion());
         this.bienFacture.setBiefacSecteur(this.locataire.getTiesecteur());
         this.bienFacture.setBiefacSerie(this.bienBail.getBiebaiSerie());
         this.bienFacture.setBiefacService((String)null);
         this.bienFacture.setBiefacSite((String)null);
         this.bienFacture.setBiefacSolde(0);
         this.bienFacture.setBiefacSource(this.locataire.getTiesource());
         this.bienFacture.setBiefacLoyerProf(this.bienBail.getBiebaiLoyerProf() * (double)var15);
         this.bienFacture.setBiefacTauxCharges((double)this.bienBail.getBiebaiTauxCharges());
         this.bienFacture.setBiefacTauxCom((double)this.bienBail.getBiebaiTauxGerance());
         this.bienFacture.setBiefacForfaitGerance(this.bienBail.getBiebaiForfaitGerance());
         this.bienFacture.setBiefacTauxIrpp((double)this.bienBail.getBiebaiTauxIrpp());
         this.bienFacture.setBiefacTauxRemise(0.0D);
         this.bienFacture.setBiefacTauxTlv((double)this.bienBail.getBiebaiTauxTlv());
         this.bienFacture.setBiefacTauxTom((double)this.bienBail.getBiebaiTauxTom());
         this.bienFacture.setBiefacTauxTva((double)this.bienBail.getBiebaiTauxTva());
         this.bienFacture.setBiefacTauxTvaCom(this.bienBail.getBiebaiTauxTva());
         this.bienFacture.setBiefacTlv(0.0D);
         this.bienFacture.setBiefacTom(0.0D);
         this.bienFacture.setBiefacTotHt(0.0D);
         this.bienFacture.setBiefacTotReglement(0.0D);
         this.bienFacture.setBiefacTotRemise(0.0D);
         this.bienFacture.setBiefacTotTimbre(0.0D);
         this.bienFacture.setBiefacTotTtc(0.0D);
         this.bienFacture.setBiefacTotTva(0.0D);
         this.bienFacture.setBiefacTotalCom(0.0D);
         this.bienFacture.setBiefacTvaCom(0.0D);
         this.bienFacture.setBiefacTotalIrpp(0.0D);
         this.bienFacture.setBiefacTypeProprietaire(this.bienBail.getBiebaiTypeProprietaire());
         this.bienFacture.setBiefacTypeReg(this.locataire.getTietypereg());
         this.bienFacture.setBiefacType(0);
         this.bienFacture.setBiefacTypeTransforme(0);
         this.bienFacture.setBiefacUsage(this.bienBail.getBiebaiUsage());
         this.bienFacture.setBiefacDateEcheReg(this.CalculDateEcheance());
         this.calculFacture();
      }

   }

   public void chargerModeleFactures() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "documentLocation" + File.separator + "location" + File.separator;
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
      this.mesPeriodesItems.add(new SelectItem(100, "Toutes Périodes"));
      Date var1 = this.exercicesVentes.getExevteDateDebut();
      GregorianCalendar var2 = new GregorianCalendar();
      var2.setTime(var1);
      Date var3 = this.exercicesVentes.getExevteDateFin();
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
         } else {
            int var4 = (new Date()).getYear() + 1900;
            if (this.periode.equals("1er trimestre")) {
               this.inpDu = this.utilDate.stringToDateSQLLight(var4 + "-" + "01" + "-" + "01");
               this.inpAu = this.utilDate.stringToDateSQLLight(var4 + "-" + "03" + "-" + "31");
            } else if (this.periode.equals("2eme trimestre")) {
               this.inpDu = this.utilDate.stringToDateSQLLight(var4 + "-" + "04" + "-" + "01");
               this.inpAu = this.utilDate.stringToDateSQLLight(var4 + "-" + "06" + "-" + "30");
            } else if (this.periode.equals("3eme trimestre")) {
               this.inpDu = this.utilDate.stringToDateSQLLight(var4 + "-" + "07" + "-" + "01");
               this.inpAu = this.utilDate.stringToDateSQLLight(var4 + "-" + "09" + "-" + "30");
            } else if (this.periode.equals("4eme trimestre")) {
               this.inpDu = this.utilDate.stringToDateSQLLight(var4 + "-" + "10" + "-" + "01");
               this.inpAu = this.utilDate.stringToDateSQLLight(var4 + "-" + "12" + "-" + "31");
            } else if (this.periode.equals("1er semestre")) {
               this.inpDu = this.utilDate.stringToDateSQLLight(var4 + "-" + "01" + "-" + "01");
               this.inpAu = this.utilDate.stringToDateSQLLight(var4 + "-" + "06" + "-" + "30");
            } else if (this.periode.equals("2eme semestre")) {
               this.inpDu = this.utilDate.stringToDateSQLLight(var4 + "-" + "07" + "-" + "01");
               this.inpAu = this.utilDate.stringToDateSQLLight(var4 + "-" + "12" + "-" + "31");
            } else if (this.periode.equals("Annuel")) {
               this.inpDu = this.utilDate.stringToDateSQLLight(var4 + "-" + "01" + "-" + "01");
               this.inpAu = this.utilDate.stringToDateSQLLight(var4 + "-" + "12" + "-" + "31");
            }
         }
      }

   }

   public void calculeBail() throws HibernateException, NamingException {
      this.nomProprietaire = "";
      this.nomLocataire = "";
      if (this.numeroBail != null && !this.numeroBail.isEmpty()) {
         this.bienBail = this.bienBailDao.pourParapheur(this.numeroBail, (Session)null);
         if (this.bienBail != null) {
            this.nomProprietaire = this.bienBail.getBiebaiNomProprietaire();
            this.nomLocataire = this.bienBail.getBiebaiNomTiers();
         }
      }

   }

   public void saveRefacturation() throws HibernateException, NamingException {
      if (this.bienFacture != null) {
         if (this.bienFacture.getBiefacId() == 0L) {
            this.bienFacture.setBiefacEtat(1);
            this.bienFacture.setBiefacDateCreat(new Date());
            this.bienFacture.setBiefacIdCreateur(this.usersLog.getUsrid());
            this.bienFacture = this.bienFactureDao.insert(this.bienFacture);
         } else {
            this.bienFacture.setBiefacEtat(1);
            this.bienFacture.setBiefacDateModif(new Date());
            this.bienFacture.setBiefacIdModif(this.usersLog.getUsrid());
            this.bienFacture = this.bienFactureDao.modif(this.bienFacture);
         }
      }

      this.var_action = 0;
      this.var_memo_action = this.var_action;
   }

   public void histoReglement() {
      if (this.bienFacture != null) {
         this.showModalPanelHistoReglement = true;
      }

   }

   public void fermerHistoReglement() {
      this.showModalPanelHistoReglement = false;
   }

   public void chargerEcritures() {
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
      if (this.listFacture.size() != 0) {
         this.listFactureSelectionne = new ArrayList();
         double var1 = 0.0D;
         double var3 = 0.0D;
         double var5 = 0.0D;
         long var7 = 0L;
         String var9 = "";

         for(int var10 = 0; var10 < this.listFacture.size(); ++var10) {
            new BienFacture();
            BienFacture var11 = (BienFacture)this.listFacture.get(var10);
            if (var11.isVar_select_ligne() && (var7 == 0L || var7 != 0L && var7 == var11.getTiers().getTieid() && var9.equals(var11.getBiefacNomTiers())) && var11.getBiefacSolde() == 0) {
               var7 = var11.getTiers().getTieid();
               var9 = var11.getBiefacNomTiers();
               var1 += var11.getBiefacTotTtc();
               var3 += var11.getBiefacTotReglement();
               var5 += var11.getVar_reliquat();
               this.listFactureSelectionne.add(var11);
            }
         }

         if (this.listFactureSelectionne.size() != 0) {
            this.datamodelTransfert.setWrappedData(this.listFactureSelectionne);
            this.reglements = new Reglements();
            this.var_date_trf = new Date();
            this.var_netAPayer = var5;
            this.montantElmTotBonEnc = 0.0D;
            this.varTypeReg = 0;
            this.choixTypeReglement();
            this.choixCaisseXReglement();
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
      new BienFacture();

      for(int var6 = 0; var6 < this.listFactureSelectionne.size(); ++var6) {
         BienFacture var5 = (BienFacture)this.listFactureSelectionne.get(var6);
         if (var5.isVar_select_ligne()) {
            var1 += var5.getBiefacTotTtc();
            var3 += var5.getBiefacTotReglement();
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
      if (this.varTypeReg == 0) {
         int var1 = this.var_date.getYear() + 1900;
         this.val_timbre = this.utilNombre.calculTimbre(this.structureLog, this.montantElmTotBonEnc, var1, this.structureLog.getStrdevise(), this.var_date);
         this.totalPayerTimbre = this.montantElmTotBonEnc + this.val_timbre;
         double var2 = 0.0D;
         double var4 = this.montantElmTotBonEnc;
         if (this.listFactureSelectionne.size() != 0) {
            new BienFacture();

            for(int var7 = 0; var7 < this.listFactureSelectionne.size(); ++var7) {
               BienFacture var6 = (BienFacture)this.listFactureSelectionne.get(var7);
               if (this.montantElmTotBonEnc != 0.0D && var4 < var6.getBiefacTotTtc() + var6.getBiefacTotTc() - var6.getBiefacTotReglement()) {
                  var2 = this.utilNombre.calculTimbre(this.structureLog, var6.getBiefacTotTtc() + var6.getBiefacTotTc() - var6.getBiefacTotReglement(), var1, this.structureLog.getStrdevise(), var6.getBiefacDate());
               } else {
                  var2 = this.utilNombre.calculTimbre(this.structureLog, var6.getBiefacTotTtc() + var6.getBiefacTotTc() - var6.getBiefacTotReglement(), var1, this.structureLog.getStrdevise(), var6.getBiefacDate());
                  var4 = var4 - var6.getBiefacTotTtc() + var6.getBiefacTotTc() - var6.getBiefacTotReglement();
               }

               var6.setVar_fac_timbre(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
               this.var_netAPayer += var6.getVar_reliquat();
            }

            this.datamodelTransfert.setWrappedData(this.listFactureSelectionne);
         }
      } else if (this.varTypeReg != 0 && this.listFactureSelectionne.size() != 0) {
         new BienFacture();

         for(int var9 = 0; var9 < this.listFactureSelectionne.size(); ++var9) {
            BienFacture var8 = (BienFacture)this.listFactureSelectionne.get(var9);
            var8.setVar_fac_timbre(0.0D);
            this.var_netAPayer += var8.getVar_reliquat();
         }

         this.datamodelTransfert.setWrappedData(this.listFactureSelectionne);
      }

      this.var_ecart_reglement = this.var_netAPayer - this.montantElmTotBonEnc - this.val_timbre;
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
         Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEncaissementVente");
         Transaction var4 = null;

         try {
            var4 = var3.beginTransaction();
            new ExercicesCaisse();
            ExercicesCaisseDao var6 = new ExercicesCaisseDao(this.baseLog, this.utilInitHibernate);
            ExercicesCaisse var5 = var6.recupererLastExo(var3);
            if (var5 != null) {
               String var7 = this.bienFacture.getBiefacSerie();
               String var8 = "";
               String var9 = "" + this.varTypeReg;
               if (var1.getChronoReglement() != null && !var1.getChronoReglement().isEmpty() && var1.getChronoReglement().equals("1")) {
                  String var10 = "";
                  if (this.var_inputCaisse.contains(";")) {
                     String[] var11 = this.var_inputCaisse.split(";");
                     var10 = var11[0];
                  }

                  if (var10 != null && !var10.isEmpty()) {
                     var8 = this.calculChrono.numComposeCaisse(this.var_date_trf, 61, var9, var7, var10, var3);
                  } else {
                     var8 = this.calculChrono.numCompose(this.var_date_trf, 61, var9, var7, var3);
                  }
               } else if (var1.getChronoReglement() != null && !var1.getChronoReglement().isEmpty() && var1.getChronoReglement().equals("2")) {
                  var8 = this.calculChrono.numCompose(this.var_date_trf, 61, var7, var3);
               } else {
                  var8 = this.calculChrono.numCompose(this.var_date_trf, 61, var7, var3);
               }

               double var32 = this.montantElmTotBonEnc;
               double var12 = 0.0D;
               double var14 = 0.0D;
               double var16 = 0.0D;
               double var18 = 0.0D;
               new BienFacture();

               for(int var21 = 0; var21 < this.listFactureSelectionne.size(); ++var21) {
                  BienFacture var20 = (BienFacture)this.listFactureSelectionne.get(var21);
                  var16 = var20.getVar_fac_timbre();
                  var18 = var20.getMontantReglementManuel();
                  var12 = 0.0D;
                  if (var20.isVar_select_ligne()) {
                     long var22 = var20.getBiefacId();
                     var20 = this.bienFactureDao.pourParapheur(var22, var3);
                     if (var20 != null) {
                        if (this.repartitionManuelle) {
                           if (var18 != 0.0D) {
                              this.reglementsRecu = this.generationReglement(var8, var18, var16, var20, var5, var3);
                              var32 -= var18;
                              if (var32 < 0.0D) {
                                 var32 = 0.0D;
                                 break;
                              }
                           }
                        } else {
                           var12 = var20.getBiefacTotTtc() + var16 - var20.getBiefacTotReglement();
                           if (var32 <= 0.0D) {
                              break;
                           }

                           if (var12 <= var32) {
                              var14 = var12;
                           } else {
                              var14 = var32;
                           }

                           this.reglementsRecu = this.generationReglement(var8, var14, var16, var20, var5, var3);
                           var32 -= var14;
                           if (var32 < 0.0D) {
                              var32 = 0.0D;
                              break;
                           }
                        }
                     }
                  }
               }

               if (var32 > 0.0D) {
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
                  this.reglements.setRglNatureDoc(this.memoReglements.getRglNatureDoc());
                  this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
                  this.reglements.setRglNomTiers(this.memoReglements.getRglNomTiers());
                  this.reglements.setRglNum(this.memoReglements.getRglNum());
                  this.reglements.setRglObjet("(déposit) " + this.memoReglements.getRglObjet());
                  this.reglements.setRglParc(this.memoReglements.getRglParc());
                  this.reglements.setRglPdv(this.memoReglements.getRglPdv());
                  this.reglements.setRglRecette(var32);
                  this.reglements.setRglTimbre(0.0D);
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
                  this.reglementsDao.insert(this.reglements, var3);
                  this.tiers = new Tiers();
                  this.tiers = this.tiersDao.selectTierD(this.memoReglements.getRglIdTiers(), var3);
                  if (this.tiers != null) {
                     double var33 = this.tiers.getTiedepotavance() + var32;
                     this.tiers.setTiedepotavance(var33);
                     this.tiersDao.modif(this.tiers, var3);
                  }
               }

               var4.commit();
            }
         } catch (HibernateException var27) {
            if (var4 != null) {
               var4.rollback();
            }

            throw var27;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      if (this.listFacture.size() != 0) {
         Session var29 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");

         for(int var30 = 0; var30 < this.listFacture.size(); ++var30) {
            this.bienFacture = (BienFacture)this.listFacture.get(var30);
            if (this.bienFacture.isVar_select_ligne()) {
               long var31 = this.bienFacture.getBiefacId();
               this.bienFacture = new BienFacture();
               this.bienFacture = this.bienFactureDao.pourParapheur(var31, var29);
               if (this.bienFacture != null) {
                  if (this.bienFacture.getBiefacSolde() == 1 && this.inpEtat == 13) {
                     this.listFacture.remove(var30);
                  } else {
                     this.listFacture.remove(var30);
                     this.bienFacture.setVar_select_ligne(false);
                     this.listFacture.add(var30, this.bienFacture);
                  }
               }
            }
         }

         this.utilInitHibernate.closeSession();
         this.datamodelFacture.setWrappedData(this.listFacture);
      }

      this.showModalPanelReglement = false;
      this.impressionRecu();
   }

   public void controleEcartRepartitionManuelle() {
      if (this.montantElmTotBonEnc != 0.0D) {
         this.var_affiche_valide = false;
         if (this.listFactureSelectionne.size() != 0) {
            this.totManuel = 0.0D;

            for(int var1 = 0; var1 < this.listFactureSelectionne.size(); ++var1) {
               this.totManuel += ((BienFacture)this.listFactureSelectionne.get(var1)).getMontantReglementManuel();
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

   public Reglements generationReglement(String var1, double var2, double var4, BienFacture var6, ExercicesCaisse var7, Session var8) throws HibernateException, NamingException {
      this.reglements = new Reglements();
      if (var2 >= var6.getBiefacTotTtc() + var4) {
         this.reglements.setRglOperation("01");
      } else {
         this.reglements.setRglOperation("02");
      }

      this.reglements.setRglActivite((String)null);
      this.reglements.setRglBudget((String)null);
      this.reglements.setRglBanqueTireur(this.var_banque_tireur);
      this.reglements.setRglBon("");
      this.reglements.setRglCategorie(20);
      String[] var9;
      if (this.var_inputCaisse != null && !this.var_inputCaisse.isEmpty() && this.var_inputCaisse.contains(":")) {
         var9 = this.var_inputCaisse.split(":");
         this.reglements.setRglCodeCaiss(var9[0]);
         this.reglements.setRglLibCaiss(var9[1]);
      } else {
         this.reglements.setRglCodeCaiss("");
         this.reglements.setRglLibCaiss("");
      }

      this.reglements.setRglCodeEmetrice("");
      this.reglements.setRglLibEmetrice("");
      if (this.varTypeReg == 1 && this.var_affiche_banque_destination && this.var_banque_destination != null && !this.var_banque_destination.isEmpty() && this.var_banque_destination.contains(":")) {
         var9 = this.var_banque_destination.split(":");
         this.reglements.setRglCodeEmetrice(var9[0]);
         this.reglements.setRglLibEmetrice(var9[1]);
      }

      this.reglements.setRglCodeReceptrice("");
      this.reglements.setRglLibReceptrice("");
      this.reglements.setRglDateCreation(new Date());
      this.reglements.setRglDateImp((Date)null);
      this.reglements.setRglDateTransfert((Date)null);
      this.reglements.setRglDateValeur((Date)null);
      this.reglements.setRglDateReg(this.var_date_trf);
      this.reglements.setRglDepartement(var6.getBiefacDepartement());
      this.reglements.setRglDepense(0.0D);
      this.reglements.setRglDevise(var6.getBiefacDevise());
      this.reglements.setRglDossier("");
      this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
      this.reglements.setRglDocument(var6.getBiefacNum());
      this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
      this.reglements.setRglIdBon(0L);
      this.reglements.setRglIdDocument(var6.getBiefacId());
      this.reglements.setRglIdTiers(var6.getTiers().getTieid());
      this.reglements.setRglDepotTiers(0);
      this.reglements.setRglLibelle(var6.getBiefacObject());
      this.reglements.setRglMode("" + this.varTypeReg);
      this.reglements.setRglModele(this.var_modele_trf);
      this.reglements.setRglNatureDoc(this.nature);
      this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
      this.reglements.setRglNomTiers(var6.getVar_nom_tiers());
      if (this.optionsVentes.getDecrmtPrsChrStock() != null && this.optionsVentes.getDecrmtPrsChrStock().equals("2")) {
         this.reglements.setRglIdContact(var6.getBiefacIdContact());
         this.reglements.setRglNomContact(var6.getVar_nomContact());
      } else {
         this.reglements.setRglIdContact(0L);
         this.reglements.setRglNomContact("");
      }

      this.reglements.setRglNum(var1);
      this.reglements.setRglNumChqBdx(this.var_num_cheque);
      this.reglements.setRglObjet(this.var_objet);
      this.reglements.setRglParc("");
      this.reglements.setRglPdv(var6.getBiefacPdv());
      this.reglements.setRglRecette(var2);
      double var14 = 0.0D;
      if (var4 != 0.0D) {
         int var11 = var6.getBiefacDate().getYear() + 1900;
         var14 = this.utilNombre.calculTimbre(this.structureLog, var2, var11, this.structureLog.getStrdevise(), this.reglements.getRglDateReg());
         this.reglements.setRglTimbre(var14);
      } else {
         this.reglements.setRglTimbre(0.0D);
      }

      this.reglements.setRglRegion(var6.getBiefacRegion());
      this.reglements.setRglSecteur(var6.getBiefacSecteur());
      this.reglements.setRglSerie(var6.getBiefacSerie());
      this.reglements.setRglService(var6.getBiefacService());
      this.reglements.setRglSite(var6.getBiefacSite());
      this.reglements.setRglTrf(0);
      this.reglements.setRglTypeTiers(0);
      this.reglements.setRglTypeReg(this.varTypeReg);
      this.reglements.setRglUserCreat(this.usersLog.getUsrid());
      this.reglements.setRglUserModif(0L);
      this.reglements.setRglIdResponsable(var6.getBiefacIdResponsable());
      this.reglements.setRglNomResponsable(var6.getBiefacNomResponsable());
      this.reglements.setRglIdCommercial(var6.getBiefacIdCommercial());
      this.reglements.setRglNomCommercial(var6.getBiefacNomCommercial());
      this.reglements.setRglIdEquipe(0L);
      this.reglements.setRglNomEquipe((String)null);
      String var15 = "";
      if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
         var15 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
      } else {
         var15 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
      }

      String var12 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
      this.reglements.setRglPeriode(var15 + ":" + var12);
      this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
      String var13 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
      this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var13);
      this.reglements.setExercicesCaisse(var7);
      this.reglements.setTotalFacture(var6.getBiefacTotTtc());
      this.reglements = this.reglementsDao.insert(this.reglements, var8);
      this.memoReglements = this.reglements;
      if (var6 != null) {
         var6.setBiefacTotReglement(var6.getBiefacTotReglement() + var2);
         var6.setBiefacTotTimbre(var6.getBiefacTotTimbre() + var14);
         if (var6.getBiefacTotReglement() >= var6.getBiefacTotTtc()) {
            var6.setBiefacSolde(1);
         } else {
            var6.setBiefacSolde(0);
         }

         var6.setBiefacDateLastReg(this.reglements.getRglDateReg());
         this.bienFactureDao.modif(var6, var8);
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

   public void rechercheTiers() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.locataire = this.formRecherche.rechercheTiers(3, this.bienFacture.getBiefacNomTiers(), this.nature);
      if (this.locataire != null) {
         if (this.locataire.getTieid() != 0L) {
            this.calculeTiers();
         } else {
            this.var_action = 15;
         }
      } else if (this.locataire == null) {
         this.calculeTiers();
      }

   }

   public void recuperationTiers() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.locataire = this.formRecherche.calculeTiers();
      this.calculeTiers();
   }

   public void calculeTiers() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      if (this.locataire != null) {
         this.bienFacture.setTiers(this.locataire);
         String var1 = "";
         if (!this.locataire.getTiegenre().equalsIgnoreCase("010") && !this.locataire.getTiegenre().equalsIgnoreCase("020") && !this.locataire.getTiegenre().equalsIgnoreCase("030") && !this.locataire.getTiegenre().equalsIgnoreCase("037") && !this.locataire.getTiegenre().equalsIgnoreCase("070") && !this.locataire.getTiegenre().equalsIgnoreCase("080")) {
            var1 = this.locataire.getTieraisonsocialenom();
            this.bienFacture.setBiefacCivilTiers("");
         } else {
            var1 = this.locataire.getTieraisonsocialenom() + " " + this.locataire.getTieprenom();
            this.bienFacture.setBiefacCivilTiers(this.bienFacture.getTiers().getTiecivilite());
         }

         this.bienFacture.setBiefacNomTiers(var1);
      } else {
         this.annuleTiers();
      }

      this.controleSaisie();
      this.var_action = this.var_memo_action;
   }

   public void annuleTiers() throws ParseException {
      this.locataire = null;
      this.bienFacture.setTiers(this.locataire);
      this.bienFacture.setBiefacNomTiers("");
      this.bienFacture.setBiefacCivilTiers("");
      this.controleSaisie();
      this.var_action = this.var_memo_action;
   }

   public void controleSaisie() throws ParseException {
      if (this.bienFacture.getBiefacNomTiers() != null && !this.bienFacture.getBiefacNomTiers().isEmpty()) {
         this.var_valide_doc = true;
         this.var_aff_detail_locataire = true;
         this.CalculDateEcheance();
      } else {
         this.var_valide_doc = false;
         this.var_aff_detail_locataire = false;
      }

   }

   public void detailTiersProprietaire() {
      this.formRecherche.setNature(this.nature);
      this.formRecherche.setTiers(this.proprietaire);
      this.var_action = 16;
   }

   public void detailTiersLocataire() {
      this.formRecherche.setNature(this.nature);
      this.formRecherche.setTiers(this.locataire);
      this.var_action = 16;
   }

   public void annuleDetailTiers() {
      this.var_action = this.var_memo_action;
   }

   public void modifTiers() {
      this.var_aff_detail_locataire = false;
   }

   public void rechercheBiens() throws JDOMException, IOException, HibernateException, NamingException {
      this.bien = this.formRecherche.rechercheBiens(this.bienFacture.getBiefacBien(), this.nature, this.categorie);
      if (this.bien != null) {
         if (this.bien.getBieId() != 0L) {
            this.calculeBiens();
         } else {
            this.var_action = 17;
         }
      } else if (this.bien == null) {
         this.calculeBiens();
      }

   }

   public void recuperationBiens() throws JDOMException, IOException, HibernateException, NamingException {
      this.bien = this.formRecherche.calculeBiens();
      this.calculeBiens();
   }

   public void calculeBiens() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.bien != null) {
         this.bienFacture.setBiefacBien(this.bien.getBieNum());
         this.proprietaire = this.bien.getTiers();
         String var1 = "";
         if (!this.proprietaire.getTiegenre().equalsIgnoreCase("010") && !this.proprietaire.getTiegenre().equalsIgnoreCase("020") && !this.proprietaire.getTiegenre().equalsIgnoreCase("030") && !this.proprietaire.getTiegenre().equalsIgnoreCase("037") && !this.proprietaire.getTiegenre().equalsIgnoreCase("070") && !this.proprietaire.getTiegenre().equalsIgnoreCase("080")) {
            var1 = this.proprietaire.getTieraisonsocialenom();
            this.bienFacture.setBiefacCivilProprietaire("");
         } else {
            var1 = this.proprietaire.getTieraisonsocialenom() + " " + this.proprietaire.getTieprenom();
            this.bienFacture.setBiefacCivilProprietaire(this.bien.getTiers().getTiecivilite());
         }

         this.bienFacture.setBiefacTypeProprietaire(this.proprietaire.getTieAssujettissement());
         this.bienFacture.setBiefacNomProprietaire(var1);
         BienGeranceLigneDao var2 = new BienGeranceLigneDao(this.baseLog, this.utilInitHibernate);
         new BienGeranceLigne();
         BienGeranceLigne var3 = var2.chargerDetail((String)this.bien.getBieNum(), (Session)null);
         if (var3 != null) {
         }

         this.calculFacture();
         this.var_aff_detail_proprietaire = true;
      } else {
         this.annuleBiens();
      }

      this.controleSaisieBiens();
      this.var_action = this.var_memo_action;
   }

   public void annuleBiens() {
      this.bien = null;
      this.bienFacture.setBiefacBien("");
      this.bienFacture.setBiefacNomProprietaire("");
      this.bienFacture.setBiefacCivilProprietaire("");
      this.bienFacture.setBiefacTypeProprietaire(0);
      this.var_aff_detail_proprietaire = false;
      this.controleSaisieBiens();
      this.var_action = this.var_memo_action;
   }

   public void controleSaisieBiens() {
      if (this.bienFacture.getBiefacBien() != null && !this.bienFacture.getBiefacBien().isEmpty() && this.bien.getBieId() != 0L) {
         this.var_valide_doc = true;
         this.var_aff_detail_local = true;
      } else {
         this.var_valide_doc = false;
         this.var_aff_detail_local = false;
      }

   }

   public void detailBiens() {
      this.formRecherche.setNature(this.nature);
      this.var_action = 18;
   }

   public void annuleDetailBiens() {
      this.var_action = this.var_memo_action;
   }

   public void modifBiens() {
      this.var_aff_detail_local = false;
   }

   public String calculeCheminRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "documentLocation" + File.separator + "location" + File.separator;
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

   public List calculeImpressionCommun(Session var1) throws HibernateException, NamingException, ParseException {
      new ArrayList();
      ArrayList var3 = new ArrayList();
      String var4 = null;
      if (this.var_more_search) {
         if (this.inpAu != null) {
            var4 = this.utilDate.dateToStringSQLLight(this.inpAu) + " 23:59:59";
         }
      } else {
         int var5 = this.exercicesVentes.getExevteDateFin().getYear() + 1900;
         if (this.periode != null && !this.periode.isEmpty() && this.periode.contains(":")) {
            String[] var6 = this.periode.split(":");
            String var7 = var6[0];
            String var8 = var6[1];
            Date var9 = this.utilDate.stringToDateSQL(var8 + "-" + var7 + "-" + "01 00:00:00");
            var4 = this.utilDate.dateToStringSQLLight(this.utilDate.dateDernierJourMois(var9)) + " 23:59:59";
         } else if (this.periode != null && !this.periode.isEmpty() && this.periode.equalsIgnoreCase("11")) {
            var4 = var5 + "-12-31";
         } else if (this.periode != null && !this.periode.isEmpty() && this.periode.equalsIgnoreCase("12")) {
            var4 = var5 - 1 + "-12-31";
         } else if (this.periode != null && !this.periode.isEmpty() && this.periode.equalsIgnoreCase("13")) {
            var4 = var5 + "-12-31";
         } else if (this.periode != null && !this.periode.isEmpty() && this.periode.equalsIgnoreCase("14")) {
            var4 = var5 - 1 + "-12-31";
         }
      }

      List var2 = this.bienFactureDao.rechercheNonSoldeTiersMode(this.bienFacture.getTiers().getTieid(), this.bienFacture.getBiefacBail(), this.inpSerie, var4, var1);
      if (var2.size() != 0) {
         new BienFacture();
         new Tiers();

         for(int var12 = 0; var12 < var2.size(); ++var12) {
            BienFacture var10 = (BienFacture)var2.get(var12);
            new Bien();
            var10.setBieNom(this.bienFacture.getBien().getBieNom());
            var10.setBieAdresse(this.bienFacture.getBien().getBieAdresse());
            var10.setBieRue(this.bienFacture.getBien().getBieRue());
            var10.setBieLot(this.bienFacture.getBien().getBieLot());
            var10.setBieIlot(this.bienFacture.getBien().getBieIlot());
            var10.setBieBatiment(this.bienFacture.getBien().getBieBatiment());
            var10.setBiePorte(this.bienFacture.getBien().getBiePorte());
            var10.setBieEtage(this.bienFacture.getBien().getBieEtage());
            var10.setBieEscalier(this.bienFacture.getBien().getBieEscalier());
            var10.setBieAscenseur(this.bienFacture.getBien().getBieAscenseur());
            var10.setBieQuartier(this.bienFacture.getBien().getBieQuartier());
            var10.setBieCommune(this.bienFacture.getBien().getBieCommune());
            var10.setBieDepart(this.bienFacture.getBien().getBieDepart());
            var10.setBieZone(this.bienFacture.getBien().getBieZone());
            var10.setBieVille(this.bienFacture.getBien().getBieVille());
            Tiers var11 = this.tiersDao.selectTierD(this.bienFacture.getTiers().getTieid(), var1);
            if (var11 != null) {
               var10.setTieadresse(var11.getTieadresse());
               var10.setTierue(var11.getTierue());
               var10.setTielot(var11.getTielot());
               var10.setTiebatiment(var11.getTiebatiment());
               var10.setTieporte(var11.getTieporte());
               var10.setTieetage(var11.getTieetage());
               var10.setTiequartier(var11.getTiequartier());
               var10.setTiecommune(var11.getTiecommune());
               var10.setTiedepart(var11.getTiedepart());
               var10.setTiezone(var11.getTiezone());
               var10.setTieville(var11.getTieville());
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

            var3.add(var10);
         }
      }

      return var3;
   }

   public boolean majDateImpression(String var1) throws HibernateException, NamingException {
      boolean var2 = false;
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         if (this.bienFacture.getBiefacDateImp() != null) {
            var2 = true;
         }

         this.bienFacture.setBiefacDateImp(new Date());
         if (this.bienFacture.getBiefacEtat() == 0 && this.bienFacture.getBiefacEtatVal() == 0 && this.usersChrono.getUsrchrValidation() == 1) {
            this.bienFacture.setBiefacEtat(1);
         }

         this.bienFacture.setBiefacModeleImp(var1);
         this.bienFacture = this.bienFactureDao.modif(this.bienFacture, var3);
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
      ArrayList var12;
      if (var2 == 0) {
         if (var3 != null && !var3.isEmpty()) {
            boolean var11 = this.majDateImpression(var3);
            var12 = new ArrayList();
            ArrayList var13 = new ArrayList();
            Session var14 = (new UtilInitHibernate()).getOpenSession(this.baseLog, "BiensImmobilier");
            if (this.bienFacture != null) {
               var12.clear();
               List var20 = this.calculeImpressionCommun(var14);
               if (var20.size() != 0) {
                  new BienFacture();

                  for(int var16 = 0; var16 < var20.size(); ++var16) {
                     BienFacture var15 = (BienFacture)var20.get(var16);
                     if (var20.size() == 1) {
                        var15.setAvecDetail(false);
                     } else {
                        var15.setAvecDetail(true);
                     }

                     var13.add(var15);
                  }
               }
            }

            this.utilInitHibernate.closeSession();
            JRBeanCollectionDataSource var24 = new JRBeanCollectionDataSource(var13);
            var1.setjRBeanCollectionDataSource(var24);
            var1.setRapport(var3);
            var1.setEntete("Impression facture");
            var1.setPageGarde((String)null);
            var1.setAnnexe1((String)null);
            var1.setAnnexe2((String)null);
            var1.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid()));
            var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid(), this.bienFacture.getBiefacEtat()));
            var1.setDuplicata("" + var11);
            var1.setInfoOrigineDoc((String)null);
            var1.setNbDecQte(this.optionsVentes.getNbDecQte());
            var1.setNbDecPu(this.optionsVentes.getNbDecPu());
            this.bienFacture.setBiefacDevise(this.structureLog.getStrdevise());
            if (!this.bienFacture.getBiefacDevise().equals("XOF") && !this.bienFacture.getBiefacDevise().equals("XAF")) {
               if (this.bienFacture.getBiefacDevise().equals("EUR")) {
                  var1.setNbCar(1);
               } else {
                  var1.setNbCar(0);
               }
            } else {
               var1.setNbCar(2);
            }

            if (this.bienFacture.getBiefacDevise().equals(this.structureLog.getStrdevise())) {
               var1.setTaux(1.0F);
            } else {
               var1.setTaux(this.tauxPrint);
               double var27 = this.utilNombre.myRound(this.bienFacture.getBiefacTotTtc() / (double)this.tauxPrint, 2);
               this.montant_lettre = this.utilNombre.begin(var27, this.devisePrint);
            }

            var1.setMontant_lettre("");
            var1.setFormat(var5);
            var1.setEmetteur(var6);
            var1.setDestinataire(var7);
            var1.setDestinataireCC(var8);
            var1.setDestinataireCCI(var9);
            var1.setCorpsMail(var10);
            var1.setIdResponsable(this.bienFacture.getBiefacIdResponsable());
            var1.setIdCommercial(this.bienFacture.getBiefacIdCommercial());
            var1.setTiersSelectionne((Tiers)null);
            var1.setNumDoc(this.bienFacture.getBiefacNum());
            var1.setNature(this.nature);
            var1.setId_doc(this.bienFacture.getBiefacId());
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
            var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "listeLocation" + File.separator + "location" + File.separator);
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
         Object var19 = new ArrayList();
         var12 = new ArrayList();
         Session var21 = (new UtilInitHibernate()).getOpenSession(this.baseLog, "BiensImmobilier");
         if (this.listFacture.size() != 0) {
            new BienFacture();
            BienFacture var22 = this.bienFacture;
            int var25 = 0;

            while(true) {
               if (var25 >= this.listFacture.size()) {
                  this.bienFacture = var22;
                  break;
               }

               this.bienFacture = (BienFacture)this.listFacture.get(var25);
               var1.setParc((Parc)null);
               if (this.bienFacture != null) {
                  ((List)var19).clear();
                  var19 = this.calculeImpressionCommun(var21);
                  if (((List)var19).size() != 0) {
                     new BienFacture();

                     for(int var17 = 0; var17 < ((List)var19).size(); ++var17) {
                        BienFacture var28 = (BienFacture)((List)var19).get(var17);
                        if (((List)var19).size() == 1) {
                           var28.setAvecDetail(false);
                        } else {
                           var28.setAvecDetail(true);
                        }

                        var12.add(var28);
                     }
                  }
               }

               ++var25;
            }
         }

         this.utilInitHibernate.closeSession();
         JRBeanCollectionDataSource var23 = new JRBeanCollectionDataSource(var12);
         var1.setjRBeanCollectionDataSource(var23);
         var1.setRapport(var3);
         var1.setEntete("Impression facture");
         var1.setPageGarde((String)null);
         var1.setAnnexe1((String)null);
         var1.setAnnexe2((String)null);
         var1.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid()));
         var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
         var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid(), this.bienFacture.getBiefacEtat()));
         var1.setInfoOrigineDoc((String)null);
         var1.setNbDecQte(this.optionsVentes.getNbDecQte());
         var1.setNbDecPu(this.optionsVentes.getNbDecPu());
         this.bienFacture.setBiefacDevise(this.structureLog.getStrdevise());
         if (!this.bienFacture.getBiefacDevise().equals("XOF") && !this.bienFacture.getBiefacDevise().equals("XAF")) {
            if (this.bienFacture.getBiefacDevise().equals("EUR")) {
               var1.setNbCar(1);
            } else {
               var1.setNbCar(0);
            }
         } else {
            var1.setNbCar(2);
         }

         if (this.bienFacture.getBiefacDevise().equals(this.structureLog.getStrdevise())) {
            var1.setTaux(1.0F);
         } else {
            var1.setTaux(this.tauxPrint);
            double var26 = this.utilNombre.myRound(this.bienFacture.getBiefacTotTtc() / (double)this.tauxPrint, 2);
            this.montant_lettre = this.utilNombre.begin(var26, this.devisePrint);
         }

         var1.setMontant_lettre("");
         var1.setFormat(var5);
         var1.setEmetteur(var6);
         var1.setDestinataire(var7);
         var1.setDestinataireCC(var8);
         var1.setDestinataireCCI(var9);
         var1.setCorpsMail(var10);
         var1.setIdResponsable(0L);
         var1.setIdCommercial(0L);
         var1.setTiersSelectionne((Tiers)null);
         var1.setNumDoc((String)null);
         var1.setNature(this.nature);
         var1.setId_doc(0L);
         var1.setParc((Parc)null);
         var1.setBaseLog(this.baseLog);
         var1.setStructureLog(this.structureLog);
         var1.setUsersLog(this.usersLog);
         var1.imprimeRapport();
      }

   }

   public void chagerRecu() {
      if (this.datamodelRecu.isRowAvailable()) {
         this.reglementsRecu = (Reglements)this.datamodelRecu.getRowData();
         this.visibleRecu = true;
      }

   }

   public void impressionRecu() {
      if (this.reglementsRecu != null) {
         this.documentImpressionItems.clear();
         File var1 = new File(this.cheminRecu());
         if (!var1.exists()) {
            var1.mkdir();
         }

         this.documentImpressionItems = new ArrayList();
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
      if (this.nomModeleDocument != null && !this.nomModeleDocument.isEmpty()) {
         UtilPrint var1 = new UtilPrint(this.utilInitHibernate);
         double var2 = 0.0D;
         new ArrayList();
         List var4 = this.reglementsDao.findRegByNatNum(165, this.bienFacture.getBiefacNum(), (Session)null);
         if (var4.size() != 0) {
            for(int var5 = 0; var5 < var4.size(); ++var5) {
               if (((Reglements)var4.get(var5)).getRglId() <= this.reglementsRecu.getRglId()) {
                  var2 += ((Reglements)var4.get(var5)).getRglRecette();
               }
            }
         }

         ArrayList var7 = new ArrayList();
         this.reglementsRecu.setTotalFacture(this.bienFacture.getBiefacTotTtc());
         this.reglementsRecu.setTotalReglement(var2);
         var7.add(this.reglementsRecu);
         JRBeanCollectionDataSource var6 = new JRBeanCollectionDataSource(var7);
         var1.setjRBeanCollectionDataSource(var6);
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

         if (this.timeDecoupage == 5) {
            this.titreGraph = this.titreGraph + " Par tranches horaires";
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

         new BienFacture();
         Session var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureLigne");
         String var5 = "";

         BienFacture var12;
         for(int var6 = 0; var6 < this.listFacture.size(); ++var6) {
            var12 = (BienFacture)this.listFacture.get(var6);
            if (var5.isEmpty()) {
               var5 = "'" + var12.getBiefacNum() + "'";
            } else {
               var5 = var5 + ",'" + var12.getBiefacNum() + "'";
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

               var12 = (BienFacture)this.listFacture.get(var10);
               var14 = "";
               var7 = 0L;
               int var15 = 0;
               if (this.modeGraph == 0) {
                  int var11 = var12.getBiefacDate().getYear() + 1900;
                  var14 = "" + var11;
               } else if (this.modeGraph == 1) {
                  if (var12.getBiefacNomResponsable() != null && !var12.getBiefacNomResponsable().isEmpty()) {
                     var14 = var12.getBiefacNomResponsable();
                  } else {
                     var14 = "Sans Responsable";
                  }
               } else if (this.modeGraph == 2) {
                  if (var12.getBiefacNomCommercial() != null && !var12.getBiefacNomCommercial().isEmpty()) {
                     var14 = var12.getBiefacNomCommercial();
                  } else {
                     var14 = "Sans Commercial";
                  }
               } else if (this.modeGraph == 3) {
                  if (var12.getBiefacNomTiers() != null && !var12.getBiefacNomTiers().isEmpty()) {
                     var14 = var12.getBiefacNomTiers();
                  } else {
                     var14 = "Sans Locataire";
                  }
               } else if (this.modeGraph == 4) {
                  if (var12.getBiefacNomProprietaire() != null && !var12.getBiefacNomProprietaire().isEmpty()) {
                     var14 = var12.getBiefacNomProprietaire();
                  } else {
                     var14 = "Sans Propriétaire";
                  }
               } else if (this.modeGraph == 7) {
                  if (var12.getBiefacSource() != null && !var12.getBiefacSource().isEmpty()) {
                     var14 = var12.getBiefacSource();
                  } else {
                     var14 = "Sans Source";
                  }
               }

               if (this.valQteGraph == 0) {
                  var7 = (long)var12.getBiefacTotHt();
               } else if (this.valQteGraph == 1) {
                  ++var7;
               }

               if (this.timeDecoupage == 0) {
                  var15 = var12.getBiefacDate().getDate();
               } else if (this.timeDecoupage == 1) {
                  var15 = var12.getBiefacDate().getMonth() + 1;
               } else if (this.timeDecoupage == 2) {
                  if (var12.getBiefacDate().getMonth() + 1 >= 1 && var12.getBiefacDate().getMonth() + 1 <= 3) {
                     var15 = 1;
                  } else if (var12.getBiefacDate().getMonth() + 1 >= 4 && var12.getBiefacDate().getMonth() + 1 <= 6) {
                     var15 = 2;
                  } else if (var12.getBiefacDate().getMonth() + 1 >= 7 && var12.getBiefacDate().getMonth() + 1 <= 9) {
                     var15 = 3;
                  } else if (var12.getBiefacDate().getMonth() + 1 >= 10 && var12.getBiefacDate().getMonth() + 1 <= 12) {
                     var15 = 4;
                  }
               } else if (this.timeDecoupage == 3) {
                  if (var12.getBiefacDate().getMonth() + 1 >= 1 && var12.getBiefacDate().getMonth() + 1 <= 6) {
                     var15 = 1;
                  } else if (var12.getBiefacDate().getMonth() + 1 >= 7 && var12.getBiefacDate().getMonth() + 1 <= 12) {
                     var15 = 2;
                  }
               } else if (this.timeDecoupage == 4) {
                  var15 = 1;
               } else if (this.timeDecoupage == 5) {
                  var15 = var12.getBiefacDate().getHours();
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

   public boolean isVar_aff_detail_locataire() {
      return this.var_aff_detail_locataire;
   }

   public void setVar_aff_detail_locataire(boolean var1) {
      this.var_aff_detail_locataire = var1;
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

   public Tiers getLocataire() {
      return this.locataire;
   }

   public void setLocataire(Tiers var1) {
      this.locataire = var1;
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

   public boolean isVar_exo_tom() {
      return this.var_exo_tom;
   }

   public void setVar_exo_tom(boolean var1) {
      this.var_exo_tom = var1;
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

   public BienFacture getBienFacture() {
      return this.bienFacture;
   }

   public void setBienFacture(BienFacture var1) {
      this.bienFacture = var1;
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

   public boolean isVisibilitenbrjr() {
      return this.visibilitenbrjr;
   }

   public void setVisibilitenbrjr(boolean var1) {
      this.visibilitenbrjr = var1;
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

   public boolean isVisibiliteterme() {
      return this.visibiliteterme;
   }

   public void setVisibiliteterme(boolean var1) {
      this.visibiliteterme = var1;
   }

   public UtilParapheur getUtilParapheur() {
      return this.utilParapheur;
   }

   public void setUtilParapheur(UtilParapheur var1) {
      this.utilParapheur = var1;
   }

   public boolean isShowModalPanelHistoReglement() {
      return this.showModalPanelHistoReglement;
   }

   public void setShowModalPanelHistoReglement(boolean var1) {
      this.showModalPanelHistoReglement = var1;
   }

   public boolean isVar_exo_irpp() {
      return this.var_exo_irpp;
   }

   public void setVar_exo_irpp(boolean var1) {
      this.var_exo_irpp = var1;
   }

   public boolean isVar_exo_tlv() {
      return this.var_exo_tlv;
   }

   public void setVar_exo_tlv(boolean var1) {
      this.var_exo_tlv = var1;
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

   public boolean isShowModalPanelAuto() {
      return this.showModalPanelAuto;
   }

   public void setShowModalPanelAuto(boolean var1) {
      this.showModalPanelAuto = var1;
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

   public double getTotalPayerTimbre() {
      return this.totalPayerTimbre;
   }

   public void setTotalPayerTimbre(double var1) {
      this.totalPayerTimbre = var1;
   }

   public double getVal_timbre() {
      return this.val_timbre;
   }

   public void setVal_timbre(double var1) {
      this.val_timbre = var1;
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

   public boolean isShowModalPanelImpressionRecu() {
      return this.showModalPanelImpressionRecu;
   }

   public void setShowModalPanelImpressionRecu(boolean var1) {
      this.showModalPanelImpressionRecu = var1;
   }

   public boolean isVisibleRecu() {
      return this.visibleRecu;
   }

   public void setVisibleRecu(boolean var1) {
      this.visibleRecu = var1;
   }

   public Habilitation getHabilitation() {
      return this.habilitation;
   }

   public void setHabilitation(Habilitation var1) {
      this.habilitation = var1;
   }

   public boolean isShowModalPanelAnnuler() {
      return this.showModalPanelAnnuler;
   }

   public void setShowModalPanelAnnuler(boolean var1) {
      this.showModalPanelAnnuler = var1;
   }

   public float getTaux_tom() {
      return this.taux_tom;
   }

   public void setTaux_tom(float var1) {
      this.taux_tom = var1;
   }

   public float getTaux_tva() {
      return this.taux_tva;
   }

   public void setTaux_tva(float var1) {
      this.taux_tva = var1;
   }

   public boolean isExo_tom() {
      return this.exo_tom;
   }

   public void setExo_tom(boolean var1) {
      this.exo_tom = var1;
   }

   public boolean isExo_tva() {
      return this.exo_tva;
   }

   public void setExo_tva(boolean var1) {
      this.exo_tva = var1;
   }

   public BienBail getBienBail() {
      return this.bienBail;
   }

   public void setBienBail(BienBail var1) {
      this.bienBail = var1;
   }

   public String getNumeroBail() {
      return this.numeroBail;
   }

   public void setNumeroBail(String var1) {
      this.numeroBail = var1;
   }

   public String getNomLocataire() {
      return this.nomLocataire;
   }

   public void setNomLocataire(String var1) {
      this.nomLocataire = var1;
   }

   public String getNomProprietaire() {
      return this.nomProprietaire;
   }

   public void setNomProprietaire(String var1) {
      this.nomProprietaire = var1;
   }

   public String getInpProprietaire() {
      return this.inpProprietaire;
   }

   public void setInpProprietaire(String var1) {
      this.inpProprietaire = var1;
   }

   public String getInpBail() {
      return this.inpBail;
   }

   public void setInpBail(String var1) {
      this.inpBail = var1;
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
