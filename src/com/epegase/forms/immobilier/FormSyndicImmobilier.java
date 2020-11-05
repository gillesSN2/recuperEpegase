package com.epegase.forms.immobilier;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.Bien;
import com.epegase.systeme.classe.BienGeranceEntete;
import com.epegase.systeme.classe.BienGeranceLigne;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.ModelesCourriers;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.TaxesVentes;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.dao.BienGeranceEnteteDao;
import com.epegase.systeme.dao.BienGeranceLigneDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.ModelesCourriersDao;
import com.epegase.systeme.dao.TaxesVentesDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilGoogleMap;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.util.UtilTdt;
import com.epegase.systeme.xml.ObjetLigneOnglet;
import com.epegase.systeme.xml.OptionVentes;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
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

public class FormSyndicImmobilier implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private FormRecherche formRecherche;
   private int var_action = 0;
   private int var_action_detail = 0;
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
   private transient DataModel datamodelGerance = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private List listGerance = new ArrayList();
   private BienGeranceEntete bienGeranceEntete = new BienGeranceEntete();
   private BienGeranceEnteteDao bienGeranceEnteteDao;
   private boolean visibiliteBton = false;
   private Tiers tiers;
   private TiersDao tiersDao;
   private boolean var_aff_detail_tiers = false;
   private boolean var_valide_doc = false;
   private transient DataModel datamodelDetail = new ListDataModel();
   private List listDetail = new ArrayList();
   private BienGeranceLigne bienGeranceLigne;
   private BienGeranceLigneDao bienGeranceLigneDao;
   private boolean var_affiche_bien = false;
   private Bien bien;
   private boolean showModalPanelAnnexe = false;
   private boolean var_affiche_annexe = false;
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
   private String inpSerie = "100";
   private int inpEtat = 0;
   private String periode;
   private String inpNum = "";
   private String inpClient = "";
   private String inpResponsable = "";
   private String inpDossier = "100";
   private Date inpDu = null;
   private Date inpAu = null;
   private boolean var_more_search = false;
   private float taux_tva;
   private float taux_tlv;
   private float taux_tom;
   private float taux_irpp;
   private Users responsable;
   private long var_nom_commercial;
   private List mesSerieUserItem;
   private boolean showModalPanelPrint = false;
   private String montant_lettre;
   private String devisePrint;
   private float tauxPrint;
   private boolean showModalGoogleMap = false;
   private URI uri;
   private boolean afficheTexteContrat;
   private String var_code_modele;
   private List mesModelesItems;
   private UtilTdt utilTdt;

   public FormSyndicImmobilier() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.mesModelesItems = new ArrayList();
      this.utilTdt = new UtilTdt();
   }

   public void InstancesDaoUtilses() {
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.bienGeranceEnteteDao = new BienGeranceEnteteDao(this.baseLog, this.utilInitHibernate);
      this.bienGeranceLigneDao = new BienGeranceLigneDao(this.baseLog, this.utilInitHibernate);
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
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

      this.periode = this.optionsVentes.getAffichInGlobViewDEVIS();
      this.usersChrono = new UsersChrono();
      this.usersChrono = this.usersChronoDao.selectUnique("", this.nature, this.usersLog, var1);
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

      ModelesCourriersDao var4 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
      this.mesModelesItems = var4.chargerLesContratsVentesByType(6, var1);
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

   public void googleMapLocal() throws IOException, URISyntaxException {
      if (this.bien != null) {
         UtilGoogleMap var1 = new UtilGoogleMap(this.structureLog);
         this.uri = var1.calculMap(this.bien.getBieRue(), this.bien.getBieAdresse(), this.bien.getBieVille(), this.bien.getBieNomPays());
         this.showModalGoogleMap = true;
      }

   }

   public void googleMapProprietaire() throws IOException, URISyntaxException {
      if (this.tiers != null) {
         UtilGoogleMap var1 = new UtilGoogleMap(this.structureLog);
         this.uri = var1.calculMap(this.tiers.getTierue(), this.tiers.getTieadresse(), this.tiers.getTieville(), this.tiers.getTienompays());
         this.showModalGoogleMap = true;
      }

   }

   public void annuleGoogleMap() {
      this.showModalGoogleMap = false;
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
      this.listGerance.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      this.listDetail.clear();
      String var2 = "";
      String var3 = "";
      if (this.var_more_search) {
         if (this.inpDu != null) {
            var2 = this.utilDate.dateToStringSQLLight(this.inpDu);
         }

         if (this.inpAu != null) {
            var3 = this.utilDate.dateToStringSQLLight(this.inpAu);
         }
      } else {
         var2 = null;
         var3 = null;
      }

      if (this.inpNum != null && !this.inpNum.isEmpty()) {
         this.inpEtat = 100;
      }

      if (this.inpEtat != 50) {
         this.listGerance = this.bienGeranceEnteteDao.recherche(var1, this.exercicesVentes.getExevteId(), 1, this.getInpNum(), this.getInpClient(), this.getInpEtat(), this.getInpSerie(), this.getPeriode(), this.usersLog.getUsrid(), this.usersLog.getUsrVentes(), this.getInpResponsable(), var2, var3);
      }

      this.datamodelGerance.setWrappedData(this.listGerance);
      this.datamodelDetail.setWrappedData(this.listDetail);
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
            this.bienGeranceEntete = (BienGeranceEntete)var1.get(0);
            this.tiers = this.bienGeranceEntete.getTiers();
            this.bien = this.bienGeranceEntete.getBien();
            Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
            this.chargerDetail(var4);
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
      if (this.bienGeranceEntete != null) {
         if (this.bienGeranceEntete.getBiegerentEtat() == 0) {
            this.modifierGerance();
         } else {
            this.consulterGerance();
         }
      }

   }

   public void chargerDetail(Session var1) throws HibernateException, NamingException {
      this.listDetail.clear();
      this.listDetail = this.bienGeranceLigneDao.chargerDetail(this.bienGeranceEntete, var1);
      this.datamodelDetail.setWrappedData(this.listDetail);
   }

   public void ajouterGerance() throws HibernateException, NamingException {
      this.bienGeranceEntete = new BienGeranceEntete();
      this.bienGeranceLigne = new BienGeranceLigne();
      this.bien = new Bien();
      this.tiers = new Tiers();
      this.tiers.setTienompays(this.structureLog.getStrnompays());
      this.listDetail.clear();
      this.datamodelDetail.setWrappedData(this.listDetail);
      this.var_action = 1;
      this.var_aff_detail_tiers = false;
      this.var_aff_action = false;
      this.afficheTexteContrat = true;
      this.var_affiche_bien = false;
      this.var_affiche_annexe = false;
      this.var_memo_action = this.var_action;
   }

   public void modifierGerance() throws HibernateException, NamingException {
      if (this.bienGeranceEntete != null) {
         this.var_action = 1;
         this.var_aff_detail_tiers = true;
         this.var_aff_action = true;
         if (this.bienGeranceEntete.getBiegerentContrat() != null && !this.bienGeranceEntete.getBiegerentContrat().isEmpty()) {
            this.afficheTexteContrat = false;
         } else {
            this.afficheTexteContrat = true;
         }

         this.var_affiche_bien = false;
         this.var_affiche_annexe = false;
         this.var_memo_action = this.var_action;
      }

   }

   public void consulterGerance() {
      if (this.bienGeranceEntete != null) {
         this.var_action = 21;
         this.var_aff_detail_tiers = true;
         this.var_aff_action = true;
         this.afficheTexteContrat = false;
         this.var_affiche_bien = false;
         this.var_affiche_annexe = false;
         this.var_memo_action = this.var_action;
      }

   }

   public void supprimerGerance() throws HibernateException, NamingException {
      if (this.bienGeranceEntete != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.bienGeranceEntete.getBiegerentNum();
            if (this.listDetail.size() != 0) {
               for(int var4 = 0; var4 < this.listDetail.size(); ++var4) {
                  this.bienGeranceLigne = (BienGeranceLigne)this.listDetail.get(var4);
                  this.bienGeranceLigneDao.delete(this.bienGeranceLigne, var1);
               }
            }

            this.bienGeranceEnteteDao.delete(this.bienGeranceEntete, var1);
            this.listGerance.remove(this.bienGeranceEntete);
            this.datamodelGerance.setWrappedData(this.listGerance);
            this.listDetail.clear();
            this.datamodelDetail.setWrappedData(this.listDetail);
            Espion var10 = new Espion();
            var10.setUsers(this.usersLog);
            var10.setEsptype(0);
            var10.setEspdtecreat(new Date());
            var10.setEspaction("Suppression Syndic N° " + var3);
            this.espionDao.mAJEspion(var10, var1);
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

   }

   public void annulerGerance() {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.visibiliteBton = false;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public void validerGerance() throws HibernateException, NamingException {
      boolean var1 = false;
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         this.bienGeranceEntete.setBiegerentModule(1);
         if (this.tiers != null && this.tiers.getTieid() != 0L) {
            this.bienGeranceEntete.setTiers(this.tiers);
         } else {
            this.bienGeranceEntete.setTiers((Tiers)null);
         }

         if (this.bienGeranceEntete.getBiegerentDateDebut() == null) {
            this.bienGeranceEntete.setBiegerentDateDebut(new Date());
         }

         if (this.bienGeranceEntete.getBiegerentId() != 0L) {
            var1 = false;
            this.bienGeranceEntete.setBiegerentDateModif(new Date());
            this.bienGeranceEntete.setBiegerentUserModif(this.usersLog.getUsrid());
            this.bienGeranceEntete = this.bienGeranceEnteteDao.modif(this.bienGeranceEntete, var2);
         } else {
            var1 = true;
            if (this.bienGeranceEntete.getBiegerentNum() == null || this.bienGeranceEntete.getBiegerentNum().isEmpty()) {
               this.bienGeranceEntete.setBiegerentNum(this.calculChrono.numCompose(this.bienGeranceEntete.getBiegerentDateDebut(), this.nature, this.bienGeranceEntete.getBiegerentSerie(), var2));
            }

            this.bienGeranceEntete.setBiegerentDateCreat(new Date());
            this.bienGeranceEntete.setBiegerentUserCreat(this.usersLog.getUsrid());
            this.bienGeranceEntete = this.bienGeranceEnteteDao.insert(this.bienGeranceEntete, var2);
            this.listGerance.add(this.bienGeranceEntete);
            this.datamodelGerance.setWrappedData(this.listGerance);
         }

         if (this.listDetail.size() != 0) {
            for(int var4 = 0; var4 < this.listDetail.size(); ++var4) {
               this.bienGeranceLigne = (BienGeranceLigne)this.listDetail.get(var4);
               this.bienGeranceLigne.setBienGeranceEntete(this.bienGeranceEntete);
               this.bienGeranceLigne = this.bienGeranceLigneDao.maj(this.bienGeranceLigne, var2);
            }
         }

         var3.commit();
      } catch (HibernateException var8) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var8;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      if (!var1) {
         this.var_action = 0;
         this.var_memo_action = this.var_action;
      }

   }

   public void calculHonoraire() throws HibernateException, NamingException {
      double var1 = this.bienGeranceEntete.getBiegerentHonoraireHt();
      double var3 = 0.0D;
      if (this.bienGeranceEntete.getBiegerentCodeTva() != null && !this.bienGeranceEntete.getBiegerentCodeTva().isEmpty()) {
         new TaxesVentes();
         TaxesVentesDao var6 = new TaxesVentesDao(this.baseLog, this.utilInitHibernate);
         TaxesVentes var5 = var6.selectTva(this.exercicesVentes.getExevteId(), this.bienGeranceEntete.getBiegerentCodeTva(), (Session)null);
         if (var5 != null) {
            this.bienGeranceEntete.setBiegerentTauxTva(var5.getTaxvteTaux());
         } else {
            this.bienGeranceEntete.setBiegerentTauxTva(0.0F);
         }

         var3 = this.utilNombre.myRoundDevise(var1 * (double)this.bienGeranceEntete.getBiegerentTauxTva() / 100.0D, this.structureLog.getStrdevise());
         this.bienGeranceEntete.setBiegerentHonoraireTaxe(var3);
      } else {
         this.bienGeranceEntete.setBiegerentCodeTva((String)null);
         this.bienGeranceEntete.setBiegerentHonoraireTaxe(0.0D);
      }

      double var7 = var1 + var3;
      this.bienGeranceEntete.setBiegerentHonoraireTtc(var7);
   }

   public void historiqueGerance() {
      if (this.bienGeranceEntete != null) {
      }

   }

   public void valideDocument() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.bienGeranceEntete.getBiegerentEtat() == 0 && this.usersChrono.getUsrchrValidation() == 2) {
            this.bienGeranceEntete.setBiegerentEtat(1);
            this.bienGeranceEntete = this.bienGeranceEnteteDao.modif(this.bienGeranceEntete, var1);
            Espion var3 = new Espion();
            var3.setUsers(this.usersLog);
            var3.setEsptype(0);
            var3.setEspdtecreat(new Date());
            var3.setEspaction("Validation manuelle gérance (I.) N° " + this.bienGeranceEntete.getBiegerentNum() + " du " + this.utilDate.dateToStringSQLLight(this.bienGeranceEntete.getBiegerentDateDebut()));
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

   public void deValideDocument() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.bienGeranceEntete.getBiegerentEtat() == 1 && this.usersChrono.getUsrchrValidation() == 2) {
            this.bienGeranceEntete.setBiegerentEtat(0);
            this.bienGeranceEntete = this.bienGeranceEnteteDao.modif(this.bienGeranceEntete, var1);
            Espion var3 = new Espion();
            var3.setUsers(this.usersLog);
            var3.setEsptype(0);
            var3.setEspdtecreat(new Date());
            var3.setEspaction("Dévalidation manuelle gérance (I.) N° " + this.bienGeranceEntete.getBiegerentNum() + " du " + this.utilDate.dateToStringSQLLight(this.bienGeranceEntete.getBiegerentDateDebut()));
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

   public void selectionAnnexe() {
      if (this.datamodelDetail.isRowAvailable()) {
         this.bienGeranceLigne = (BienGeranceLigne)this.datamodelDetail.getRowData();
         this.var_affiche_annexe = true;
      }

   }

   public void ajouterAnnexe() throws HibernateException, NamingException {
      if (this.bienGeranceEntete != null) {
         this.bienGeranceLigne = new BienGeranceLigne();
         this.var_action_detail = 1;
         this.showModalPanelAnnexe = true;
      }

   }

   public void modifierAnnexe() throws HibernateException, NamingException {
      if (this.bienGeranceLigne != null) {
         this.var_action_detail = 1;
         this.showModalPanelAnnexe = true;
      }

   }

   public void consulterAnnexe() {
      if (this.bienGeranceLigne != null) {
         this.var_action_detail = 21;
         this.showModalPanelAnnexe = true;
      }

   }

   public void supprimerAnnexe() throws HibernateException, NamingException {
      if (this.bienGeranceLigne != null) {
         this.bienGeranceLigneDao.delete(this.bienGeranceLigne);
         this.listDetail.remove(this.bienGeranceLigne);
         this.datamodelDetail.setWrappedData(this.listDetail);
      }

   }

   public void fermerAnnexe() {
      this.var_action_detail = 0;
      this.showModalPanelAnnexe = false;
      this.var_affiche_annexe = false;
   }

   public void validerAnnexe() throws HibernateException, NamingException {
      if (this.bienGeranceEntete != null && this.bien != null) {
         if (this.bienGeranceLigne.getBiegerligId() == 0L) {
            this.bienGeranceLigne.setBienGeranceEntete(this.bienGeranceEntete);
            this.bienGeranceLigne.setBien((Bien)null);
            this.bienGeranceLigne = this.bienGeranceLigneDao.insert(this.bienGeranceLigne);
            this.listDetail.add(this.bienGeranceLigne);
            this.datamodelDetail.setWrappedData(this.listDetail);
         } else {
            this.bienGeranceLigne = this.bienGeranceLigneDao.modif(this.bienGeranceLigne);
         }
      }

      this.var_action_detail = 0;
      this.showModalPanelAnnexe = false;
      this.var_affiche_annexe = true;
   }

   public void rechercheTexteModeleContrat() throws HibernateException, NamingException {
      this.bienGeranceEntete.setBiegerentContrat("");
      ModelesCourriersDao var1 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
      if (this.var_code_modele != null && !this.var_code_modele.isEmpty()) {
         String var2 = "";
         if (this.var_code_modele.contains(":")) {
            String[] var3 = this.var_code_modele.split(":");
            var2 = var3[0];
         } else {
            var2 = this.var_code_modele;
         }

         new ModelesCourriers();
         ModelesCourriers var4 = var1.rechercheModeles(var2, (Session)null);
         if (var4 != null) {
            this.bienGeranceEntete.setBiegerentContrat(var4.getModTexte());
            this.calculeTexte();
         } else {
            this.bienGeranceEntete.setBiegerentContrat("Erreur modèle");
         }
      }

   }

   public void calculeTexte() throws HibernateException, NamingException {
      this.calculeZone((Session)null);
      if (this.bienGeranceEntete.getBiegerentContrat() != null && !this.bienGeranceEntete.getBiegerentContrat().isEmpty()) {
         this.bienGeranceEntete.setBiegerentContrat(this.utilTdt.analyseTexteCommercial(this.bienGeranceEntete.getBiegerentContrat(), this.usersLog, this.structureLog, this.tiers));
      } else {
         this.afficheTexteContrat = true;
      }

   }

   public void calculeZone(Session var1) throws HibernateException, NamingException {
   }

   public void rechercheTiers() throws JDOMException, IOException, HibernateException, NamingException {
      this.tiers = this.formRecherche.rechercheTiers(0, this.bienGeranceEntete.getBiegerentNomTiers(), this.nature);
      if (this.tiers != null) {
         if (this.tiers.getTieid() != 0L) {
            this.calculeTiers();
         } else {
            this.var_action = 15;
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
         this.bienGeranceEntete.setTiers(this.tiers);
         String var1 = "";
         if (!this.tiers.getTiegenre().equalsIgnoreCase("010") && !this.tiers.getTiegenre().equalsIgnoreCase("020") && !this.tiers.getTiegenre().equalsIgnoreCase("030") && !this.tiers.getTiegenre().equalsIgnoreCase("037") && !this.tiers.getTiegenre().equalsIgnoreCase("070") && !this.tiers.getTiegenre().equalsIgnoreCase("080")) {
            var1 = this.tiers.getTieraisonsocialenom();
            this.bienGeranceEntete.setBiegerentCivilTiers("");
         } else {
            var1 = this.tiers.getTieraisonsocialenom() + " " + this.tiers.getTieprenom();
            this.bienGeranceEntete.setBiegerentCivilTiers(this.bienGeranceEntete.getTiers().getTiecivilite());
         }

         this.bienGeranceEntete.setBiegerentTypeTiers(this.bienGeranceEntete.getTiers().getTieAssujettissement());
         this.bienGeranceEntete.setBiegerentNomTiers(var1);
      } else {
         this.annuleTiers();
      }

      this.controleSaisie();
      this.var_action = this.var_memo_action;
   }

   public void annuleTiers() {
      this.tiers = new Tiers();
      this.bienGeranceEntete.setTiers(this.tiers);
      this.bienGeranceEntete.setBiegerentNomTiers("");
      this.bienGeranceEntete.setBiegerentCivilTiers("");
      this.bienGeranceEntete.setBiegerentTypeTiers(0);
      this.controleSaisie();
      this.var_action = this.var_memo_action;
   }

   public void controleSaisie() {
      if (!this.bienGeranceEntete.getBiegerentNomTiers().equals("") && this.tiers.getTieid() != 0L) {
         this.var_valide_doc = true;
         this.var_aff_detail_tiers = true;
      } else {
         this.var_valide_doc = false;
         this.var_aff_detail_tiers = false;
      }

   }

   public void detailTiers() {
      this.formRecherche.setNature(this.nature);
      this.var_action = 16;
   }

   public void annuleDetailTiers() {
      this.var_action = this.var_memo_action;
   }

   public void modifTiers() {
      this.var_aff_detail_tiers = false;
   }

   public void rechercheBiens() throws JDOMException, IOException, HibernateException, NamingException {
      this.bien = this.formRecherche.rechercheBiens(this.bienGeranceEntete.getBiegerentLocal(), this.nature, this.categorie);
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
         this.bienGeranceEntete.setBien(this.bien);
         this.bienGeranceEntete.setBiegerentLocal(this.bien.getBieNum());
         this.tiers = new Tiers();
         if (!this.bien.isBieCopropriete() && this.bien.getTiers() != null) {
            this.tiers = this.bien.getTiers();
            this.bienGeranceEntete.setBiegerentCivilTiers(this.tiers.getTiecivilite());
            this.bienGeranceEntete.setBiegerentNomTiers(this.tiers.getTieraisonsocialenom());
            this.bienGeranceEntete.setBiegerentTypeTiers(this.tiers.getTieAssujettissement());
            this.var_aff_detail_tiers = true;
         } else {
            this.bienGeranceEntete.setBiegerentCivilTiers((String)null);
            this.bienGeranceEntete.setBiegerentNomTiers((String)null);
            this.bienGeranceEntete.setBiegerentTypeTiers(0);
            this.var_aff_detail_tiers = false;
         }
      } else {
         this.annuleBiens();
      }

      this.controleSaisieBiens();
      this.var_action = this.var_memo_action;
   }

   public void annuleBiens() {
      this.bien = null;
      this.tiers = null;
      this.bienGeranceEntete.setBien((Bien)null);
      this.bienGeranceEntete.setBiegerentLocal((String)null);
      this.bienGeranceEntete.setBiegerentCivilTiers((String)null);
      this.bienGeranceEntete.setBiegerentNomTiers((String)null);
      this.bienGeranceEntete.setBiegerentTypeTiers(0);
      this.var_aff_detail_tiers = false;
      this.controleSaisieBiens();
      this.var_action = this.var_memo_action;
   }

   public void controleSaisieBiens() {
      if (this.bienGeranceEntete.getBiegerentLocal() != null && !this.bienGeranceEntete.getBiegerentLocal().isEmpty() && this.bien.getBieId() != 0L) {
         this.var_valide_doc = true;
         this.var_affiche_bien = true;
      } else {
         this.var_valide_doc = false;
         this.var_affiche_bien = false;
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
      this.var_affiche_bien = false;
   }

   public String calculeCheminRapport(String var1, int var2) {
      String var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "documentSyndic" + File.separator + "syndic" + File.separator;
      return var3;
   }

   public String calculeCheminSousRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "sous_rapport" + File.separator;
      return var2;
   }

   public String calculeImageFond(String var1) throws HibernateException, NamingException {
      String var2 = "";
      File var3 = new File(this.calculeCheminSousRapport(var1) + "formatSyndic.jpg");
      if (var3.exists()) {
         var2 = "formatSyndic.jpg";
      }

      return var2;
   }

   public JRBeanCollectionDataSource calculeImpressionCommun() throws IOException {
      this.montant_lettre = this.utilNombre.begin(this.bienGeranceEntete.getBiegerentHonoraireTtc(), this.structureLog.getStrdevise());
      ArrayList var1 = new ArrayList();
      var1.add(this.bienGeranceEntete);
      JRBeanCollectionDataSource var2 = new JRBeanCollectionDataSource(var1);
      return var2;
   }

   public boolean majDateImpression(String var1) throws HibernateException, NamingException {
      boolean var2 = false;
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         if (this.bienGeranceEntete.getBiegerentDateImp() != null) {
            var2 = true;
         }

         this.bienGeranceEntete.setBiegerentDateImp(new Date());
         if (this.bienGeranceEntete.getBiegerentEtat() == 0 && this.bienGeranceEntete.getBiegerentEtatVal() == 0 && this.usersChrono.getUsrchrValidation() == 1) {
            this.bienGeranceEntete.setBiegerentEtat(1);
         }

         this.bienGeranceEntete.setBiegerentModeleImp(var1);
         this.bienGeranceEntete = this.bienGeranceEnteteDao.modif(this.bienGeranceEntete, var3);
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
            var1.setEntete("Impression syndic");
            var1.setPageGarde((String)null);
            var1.setAnnexe1((String)null);
            var1.setAnnexe2((String)null);
            var1.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid(), this.nature));
            var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid()));
            var1.setDuplicata("" + var11);
            var1.setInfoOrigineDoc((String)null);
            var1.setNbDecQte(this.optionsVentes.getNbDecQte());
            var1.setNbDecPu(this.optionsVentes.getNbDecPu());
            var1.setMontant_lettre(this.montant_lettre);
            var1.setFormat(var5);
            var1.setEmetteur(var6);
            var1.setDestinataire(var7);
            var1.setDestinataireCC(var8);
            var1.setDestinataireCCI(var9);
            var1.setCorpsMail(var10);
            var1.setIdResponsable(this.bienGeranceEntete.getBiegerentIdResponsable());
            var1.setIdCommercial(0L);
            var1.setTiersSelectionne(this.bienGeranceEntete.getTiers());
            var1.setNumDoc(this.bienGeranceEntete.getBiegerentNum());
            var1.setNature(this.nature);
            var1.setId_doc(this.bienGeranceEntete.getBiegerentId());
            var1.setParc((Parc)null);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      } else if (var2 == 1 && var4 != null && !var4.isEmpty()) {
         var1.setRapport(var4);
         var1.setEntete("Impression de la liste des syndics");
         var1.setTotauxHt("");
         var1.setTotauxTaxe("");
         var1.setTotauxTtc("");
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "listeSyndic" + File.separator + "syndic" + File.separator);
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
         JRBeanCollectionDataSource var12 = new JRBeanCollectionDataSource(this.listGerance);
         var1.setjRBeanCollectionDataSource(var12);
         var1.setBaseLog(this.baseLog);
         var1.setStructureLog(this.structureLog);
         var1.setUsersLog(this.usersLog);
         var1.imprimeRapport();
      }

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

   public BienGeranceEntete getBienGeranceEntete() {
      return this.bienGeranceEntete;
   }

   public void setBienGeranceEntete(BienGeranceEntete var1) {
      this.bienGeranceEntete = var1;
   }

   public DataModel getDatamodelGerance() {
      return this.datamodelGerance;
   }

   public void setDatamodelGerance(DataModel var1) {
      this.datamodelGerance = var1;
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

   public boolean isShowModalGoogleMap() {
      return this.showModalGoogleMap;
   }

   public void setShowModalGoogleMap(boolean var1) {
      this.showModalGoogleMap = var1;
   }

   public boolean isVar_aff_action() {
      return this.var_aff_action;
   }

   public void setVar_aff_action(boolean var1) {
      this.var_aff_action = var1;
   }

   public boolean isVar_aff_detail_tiers() {
      return this.var_aff_detail_tiers;
   }

   public void setVar_aff_detail_tiers(boolean var1) {
      this.var_aff_detail_tiers = var1;
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

   public boolean isAfficheTexteContrat() {
      return this.afficheTexteContrat;
   }

   public void setAfficheTexteContrat(boolean var1) {
      this.afficheTexteContrat = var1;
   }

   public DataModel getDatamodelDetail() {
      return this.datamodelDetail;
   }

   public void setDatamodelDetail(DataModel var1) {
      this.datamodelDetail = var1;
   }

   public List getMesModelesItems() {
      return this.mesModelesItems;
   }

   public void setMesModelesItems(List var1) {
      this.mesModelesItems = var1;
   }

   public String getVar_code_modele() {
      return this.var_code_modele;
   }

   public void setVar_code_modele(String var1) {
      this.var_code_modele = var1;
   }

   public boolean isVar_affiche_bien() {
      return this.var_affiche_bien;
   }

   public void setVar_affiche_bien(boolean var1) {
      this.var_affiche_bien = var1;
   }

   public int getVar_action_detail() {
      return this.var_action_detail;
   }

   public void setVar_action_detail(int var1) {
      this.var_action_detail = var1;
   }

   public BienGeranceLigne getBienGeranceLigne() {
      return this.bienGeranceLigne;
   }

   public void setBienGeranceLigne(BienGeranceLigne var1) {
      this.bienGeranceLigne = var1;
   }

   public URI getUri() {
      return this.uri;
   }

   public void setUri(URI var1) {
      this.uri = var1;
   }

   public Bien getBien() {
      return this.bien;
   }

   public void setBien(Bien var1) {
      this.bien = var1;
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

   public boolean isShowModalPanelAnnexe() {
      return this.showModalPanelAnnexe;
   }

   public void setShowModalPanelAnnexe(boolean var1) {
      this.showModalPanelAnnexe = var1;
   }

   public boolean isVar_affiche_annexe() {
      return this.var_affiche_annexe;
   }

   public void setVar_affiche_annexe(boolean var1) {
      this.var_affiche_annexe = var1;
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
