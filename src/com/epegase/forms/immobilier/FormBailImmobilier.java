package com.epegase.forms.immobilier;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.Bien;
import com.epegase.systeme.classe.BienBail;
import com.epegase.systeme.classe.BienFacture;
import com.epegase.systeme.classe.BienGeranceLigne;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.ModelesCourriers;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.TaxesVentes;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.dao.BienBailDao;
import com.epegase.systeme.dao.BienDao;
import com.epegase.systeme.dao.BienFactureDao;
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

public class FormBailImmobilier implements Serializable {
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
   private int var_onglet;
   private Habilitation habilitation;
   private transient DataModel datamodelBail1 = new ListDataModel();
   private transient DataModel datamodelBail2 = new ListDataModel();
   private transient DataModel datamodelBail3 = new ListDataModel();
   private UIDataTable extDTable1 = new HtmlExtendedDataTable();
   private UIDataTable extDTable2 = new HtmlExtendedDataTable();
   private UIDataTable extDTable3 = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete1 = new SimpleSelection();
   private SimpleSelection simpleSelectionEntete2 = new SimpleSelection();
   private SimpleSelection simpleSelectionEntete3 = new SimpleSelection();
   private List listBail = new ArrayList();
   private BienBail bienBail = new BienBail();
   private Bien bien;
   private BienBailDao bienBailDao;
   private BienDao bienDao;
   private boolean visibiliteBton = false;
   private Tiers proprietaire;
   private Tiers locataire;
   private TiersDao tiersDao;
   private boolean var_aff_detail_locataire = false;
   private boolean var_aff_detail_proprietaire = false;
   private boolean var_aff_detail_local = false;
   private boolean var_valide_doc = false;
   private boolean var_code_unique = false;
   private List lesPeriodes = new ArrayList();
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
   private boolean var_exo_tom;
   private boolean var_exo_tva;
   private float taux_tva;
   private float taux_tlv;
   private float taux_tom;
   private float taux_irpp;
   private String inpSerie = "100";
   private int inpEtat = 1;
   private int periode = 0;
   private String inpNum = "";
   private String inpClient = "";
   private String inpResponsable = "";
   private String inpDossier = "100";
   private Date inpDu = null;
   private Date inpAu = null;
   private boolean var_more_search = false;
   private Date datePeremption;
   private boolean affaicheDatePermption;
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
   private transient DataModel dataModelHistorique;
   private List lesHistoriques;
   private BienFactureDao bienFactureDao;
   private double montantTtc;
   private double montantReglement;
   private double montantSolde;
   private int var_nb_ligne;
   private boolean showModalPanelAnnuler = false;

   public FormBailImmobilier() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.mesModelesItems = new ArrayList();
      this.utilTdt = new UtilTdt();
      this.dataModelHistorique = new ListDataModel();
      this.lesHistoriques = new ArrayList();
   }

   public void InstancesDaoUtilses() {
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.bienBailDao = new BienBailDao(this.baseLog, this.utilInitHibernate);
      this.bienDao = new BienDao(this.baseLog, this.utilInitHibernate);
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      this.bienFactureDao = new BienFactureDao(this.baseLog, this.utilInitHibernate);
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

      if (this.optionsVentes.getAffichInGlobViewBLC().equals("0")) {
         this.periode = 0;
      } else {
         this.periode = (new Date()).getYear() + 1900;
      }

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
      this.mesModelesItems = var4.chargerLesContratsVentesByType(4, var1);
      this.lesPeriodes.clear();
      new ArrayList();
      List var5 = this.bienBailDao.chargerBauxPeriode(var1);
      if (var5.size() != 0) {
         for(int var6 = 0; var6 < var5.size(); ++var6) {
            this.lesPeriodes.add(new SelectItem(((BienBail)var5.get(var6)).getBiebaiDate().getYear() + 1900));
         }
      }

      this.datePeremption = this.utilDate.dateDernierJourMois(this.utilDate.dateMoisSuivant(new Date()));
   }

   public void calculeDatePeremption() {
      if (this.inpEtat == 5) {
         this.affaicheDatePermption = true;
         this.periode = 0;
      } else {
         this.affaicheDatePermption = false;
      }

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
      if (this.proprietaire != null) {
         UtilGoogleMap var1 = new UtilGoogleMap(this.structureLog);
         this.uri = var1.calculMap(this.proprietaire.getTierue(), this.proprietaire.getTieadresse(), this.proprietaire.getTieville(), this.proprietaire.getTienompays());
         this.showModalGoogleMap = true;
      }

   }

   public void googleMapLocataire() throws IOException, URISyntaxException {
      if (this.locataire != null) {
         UtilGoogleMap var1 = new UtilGoogleMap(this.structureLog);
         this.uri = var1.calculMap(this.locataire.getTierue(), this.locataire.getTieadresse(), this.locataire.getTieville(), this.locataire.getTienompays());
         this.showModalGoogleMap = true;
      }

   }

   public void annuleGoogleMap() {
      this.showModalGoogleMap = false;
   }

   public void selectionPays() {
   }

   public void moreSearch() throws ParseException {
      if (!this.var_more_search) {
         this.var_more_search = true;
         this.periode = 0;
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
      this.listBail.clear();
      this.extDTable1 = new HtmlExtendedDataTable();
      this.simpleSelectionEntete1.clear();
      this.extDTable2 = new HtmlExtendedDataTable();
      this.simpleSelectionEntete2.clear();
      this.extDTable3 = new HtmlExtendedDataTable();
      this.simpleSelectionEntete3.clear();
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
         this.listBail = this.bienBailDao.recherche(var1, this.getInpNum(), this.getInpClient(), this.getInpEtat(), this.getInpSerie(), this.getPeriode(), this.usersLog.getUsrid(), this.usersLog.getUsrVentes(), this.getInpResponsable(), var2, var3, this.datePeremption);
      }

      this.datamodelBail1.setWrappedData(this.listBail);
      this.datamodelBail2.setWrappedData(this.listBail);
      this.datamodelBail3.setWrappedData(this.listBail);
      this.visibiliteBton = false;
   }

   public void option1() {
      this.var_onglet = 0;
   }

   public void option2() {
      this.var_onglet = 1;
   }

   public void option3() {
      this.var_onglet = 2;
   }

   public void selectionLigne1() throws HibernateException, NamingException {
      if (this.extDTable1 != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelectionEntete1.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTable1.setRowKey(var3);
            if (this.extDTable1.isRowAvailable()) {
               var1.add(this.extDTable1.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.bienBail = (BienBail)var1.get(0);
            this.selectionLigne();
            this.visibiliteBton = true;
         } else {
            this.visibiliteBton = false;
         }
      } else {
         this.visibiliteBton = false;
      }

   }

   public void visualisationLigne1() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.bienBail != null) {
         if (this.bienBail.getBiebaiEtat() == 0) {
            this.modifierBail();
         } else {
            this.consulterBail();
         }
      }

   }

   public void selectionLigne2() throws HibernateException, NamingException {
      if (this.extDTable2 != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelectionEntete2.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTable2.setRowKey(var3);
            if (this.extDTable2.isRowAvailable()) {
               var1.add(this.extDTable2.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.bienBail = (BienBail)var1.get(0);
            this.selectionLigne();
            this.visibiliteBton = true;
         } else {
            this.visibiliteBton = false;
         }
      } else {
         this.visibiliteBton = false;
      }

   }

   public void visualisationLigne2() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.bienBail != null) {
         if (this.bienBail.getBiebaiEtat() == 0) {
            this.modifierBail();
         } else {
            this.consulterBail();
         }
      }

   }

   public void selectionLigne3() throws HibernateException, NamingException {
      if (this.extDTable3 != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelectionEntete3.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTable3.setRowKey(var3);
            if (this.extDTable3.isRowAvailable()) {
               var1.add(this.extDTable3.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.bienBail = (BienBail)var1.get(0);
            this.selectionLigne();
            this.visibiliteBton = true;
         } else {
            this.visibiliteBton = false;
         }
      } else {
         this.visibiliteBton = false;
      }

   }

   public void visualisationLigne3() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.bienBail != null) {
         if (this.bienBail.getBiebaiEtat() == 0) {
            this.modifierBail();
         } else {
            this.consulterBail();
         }
      }

   }

   public void selectionLigne() throws HibernateException, NamingException {
      this.bien = this.bienBail.getBien();
      this.locataire = this.bienBail.getTiers();
      this.proprietaire = this.tiersDao.selectTierD(this.bienBail.getBiebaiIdProprietaire());
      if (this.proprietaire != null) {
         if (this.bienBail.getBiebaiExoTva() == 1) {
            this.var_exo_tva = true;
         } else {
            this.var_exo_tva = false;
         }

         if (this.bienBail.getBiebaiExoTom() == 1) {
            this.var_exo_tom = true;
         } else {
            this.var_exo_tom = false;
         }

         this.bienBail.setBiebaiTauxTva(this.taux_tva);
         this.bienBail.setBiebaiTauxTlv(this.taux_tlv);
         this.bienBail.setBiebaiTauxTom(this.taux_tom);
         this.bienBail.setBiebaiTauxIrpp(this.taux_irpp);
         String var1 = "";
         if (!this.proprietaire.getTiegenre().equalsIgnoreCase("010") && !this.proprietaire.getTiegenre().equalsIgnoreCase("020") && !this.proprietaire.getTiegenre().equalsIgnoreCase("030") && !this.proprietaire.getTiegenre().equalsIgnoreCase("037") && !this.proprietaire.getTiegenre().equalsIgnoreCase("070") && !this.proprietaire.getTiegenre().equalsIgnoreCase("080")) {
            var1 = this.proprietaire.getTieraisonsocialenom();
            this.bienBail.setBiebaiCivilTiers("");
         } else {
            if (this.proprietaire.getTieprenom() != null && !this.proprietaire.getTieprenom().isEmpty()) {
               var1 = this.proprietaire.getTieraisonsocialenom() + " " + this.proprietaire.getTieprenom();
            } else {
               var1 = this.proprietaire.getTieraisonsocialenom();
            }

            if (this.proprietaire != null && this.proprietaire.getTiecivilite() != null && !this.proprietaire.getTiecivilite().isEmpty()) {
               this.bienBail.setBiebaiCivilTiers(this.proprietaire.getTiecivilite());
            } else {
               this.bienBail.setBiebaiCivilTiers("");
            }
         }

         this.bienBail.setBiebaiTypeProprietaire(this.proprietaire.getTieAssujettissement());
         this.bienBail.setBiebaiNomProprietaire(var1);
         this.bienBail.setBiebaiProprietaire(this.proprietaire.getTiesigle());
         this.bienBail.setBiebaiIdProprietaire(this.proprietaire.getTieid());
      }

      this.calculBail();
   }

   public void ajouterBail() throws HibernateException, NamingException {
      this.bien = new Bien();
      this.bienBail = new BienBail();
      this.proprietaire = new Tiers();
      this.locataire = new Tiers();
      this.bienBail.setBiebaiTauxIrpp(this.taux_irpp);
      this.bienBail.setBiebaiTauxTlv(this.taux_tlv);
      this.bienBail.setBiebaiTauxTom(this.taux_tom);
      this.bienBail.setBiebaiTauxTva(this.taux_tva);
      this.bienBail.setBiebaiTauxGerance(0.0F);
      this.bienBail.setBiebaiDate(new Date());
      this.var_action = 1;
      this.var_aff_detail_proprietaire = false;
      this.var_aff_detail_locataire = false;
      this.var_aff_action = false;
      this.afficheTexteContrat = true;
      this.var_memo_action = this.var_action;
   }

   public void modifierBail() {
      if (this.bienBail != null) {
         this.var_action = 2;
         this.var_aff_detail_proprietaire = true;
         this.var_aff_detail_locataire = true;
         this.var_aff_action = true;
         if (this.bienBail.getBiebaiContrat() != null && !this.bienBail.getBiebaiContrat().isEmpty()) {
            this.afficheTexteContrat = false;
         } else {
            this.afficheTexteContrat = true;
         }

         this.calculBail();
         this.var_memo_action = this.var_action;
      }

   }

   public void consulterBail() {
      if (this.bienBail != null) {
         this.var_action = 21;
         this.var_aff_detail_proprietaire = true;
         this.var_aff_detail_locataire = true;
         this.var_aff_action = true;
         this.afficheTexteContrat = false;
         this.var_memo_action = this.var_action;
      }

   }

   public void supprimerBail() throws HibernateException, NamingException {
      if (this.bienBail != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.bienBail.getBiebaiNum();
            this.bienBailDao.delete(this.bienBail, var1);
            this.listBail.remove(this.bienBail);
            this.datamodelBail1.setWrappedData(this.listBail);
            this.datamodelBail2.setWrappedData(this.listBail);
            this.datamodelBail3.setWrappedData(this.listBail);
            Espion var4 = new Espion();
            var4.setUsers(this.usersLog);
            var4.setEsptype(0);
            var4.setEspdtecreat(new Date());
            var4.setEspaction("Suppression Bail N° " + var3);
            this.espionDao.mAJEspion(var4, var1);
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

   public void annulerBail() {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.visibiliteBton = false;
      this.simpleSelectionEntete1.clear();
      this.extDTable1 = new HtmlExtendedDataTable();
      this.simpleSelectionEntete2.clear();
      this.extDTable2 = new HtmlExtendedDataTable();
      this.simpleSelectionEntete3.clear();
      this.extDTable3 = new HtmlExtendedDataTable();
   }

   public void validerBail() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.locataire != null && this.locataire.getTieid() != 0L) {
            this.bienBail.setTiers(this.locataire);
         } else {
            this.bienBail.setTiers((Tiers)null);
         }

         this.bienBail.setBiebaiAnnee(this.bienBail.getBiebaiDate().getYear() + 1900);
         if (this.bienBail.getBiebaiId() == 0L) {
            if (this.bienBail.getBiebaiNum() == null || this.bienBail.getBiebaiNum().isEmpty()) {
               this.bienBail.setBiebaiNum(this.calculChrono.numCompose(this.bienBail.getBiebaiDateDebut(), this.nature, this.bienBail.getBiebaiSerie(), var1));
            }

            this.bienBail.setBiebaiDateCreat(new Date());
            this.bienBail.setBiebaiUserCreat(this.usersLog.getUsrid());
            this.bienBail = this.bienBailDao.insert(this.bienBail, var1);
            this.listBail.add(this.bienBail);
            this.datamodelBail1.setWrappedData(this.listBail);
            this.datamodelBail2.setWrappedData(this.listBail);
            this.datamodelBail3.setWrappedData(this.listBail);
         } else {
            this.bienBail.setBiebaiDateModif(new Date());
            this.bienBail.setBiebaiUserModif(this.usersLog.getUsrid());
            this.bienBail = this.bienBailDao.modif(this.bienBail, var1);
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

      this.var_action = 0;
      this.var_memo_action = this.var_action;
   }

   public void exoTva() {
      if (this.var_exo_tva) {
         this.bienBail.setBiebaiExoTva(1);
      } else {
         this.bienBail.setBiebaiExoTva(0);
      }

      this.calculBail();
   }

   public void exoTom() {
      if (this.var_exo_tom) {
         this.bienBail.setBiebaiExoTom(1);
      } else {
         this.bienBail.setBiebaiExoTom(0);
      }

      this.calculBail();
   }

   public void calculBail() {
      double var1 = 0.0D;
      double var3;
      if (this.bienBail.getBiebaiTauxCharges() != 0.0F) {
         var3 = this.utilNombre.myRoundDevise(this.bienBail.getBiebaiLoyerBrut() * (double)this.bienBail.getBiebaiTauxCharges() / 100.0D, this.structureLog.getStrdevise());
         this.bienBail.setBiebaiCharges(var3);
      }

      var1 = this.bienBail.getBiebaiLoyerBrut() + this.bienBail.getBiebaiCharges() + this.bienBail.getBiebaiEau() + this.bienBail.getBiebaiElectricite() + this.bienBail.getBiebaiParking() + this.bienBail.getBiebaiGardiennage() + this.bienBail.getBiebaiJardinier() + this.bienBail.getBiebaiDiversFrais() + this.bienBail.getBiebaiGroupeElectro() + this.bienBail.getBiebaiFraisComplement();
      if (this.bienBail.getBiebaiModeTlv() == 0) {
         this.bienBail.setBiebaiTlv(0.0D);
      } else {
         var3 = this.utilNombre.myRoundDevise((this.bienBail.getBiebaiLoyerBrut() + this.bienBail.getBiebaiCharges()) * (double)this.bienBail.getBiebaiTauxTlv() / 100.0D, this.structureLog.getStrdevise());
         this.bienBail.setBiebaiTlv(var3);
      }

      if (this.bienBail.getBiebaiExoTom() == 1) {
         this.bienBail.setBiebaiTom(0.0D);
      } else {
         var3 = this.utilNombre.myRoundDevise(this.bienBail.getBiebaiLoyerBrut() * (double)this.bienBail.getBiebaiTauxTom() / 100.0D, this.structureLog.getStrdevise());
         this.bienBail.setBiebaiTom(var3);
      }

      double var5;
      if (this.bienBail.getBiebaiExoTva() == 1) {
         this.bienBail.setBiebaiTva(0.0D);
      } else if (this.bienBail.getBiebaiUsage() == 0) {
         this.bienBail.setBiebaiTva(0.0D);
      } else {
         var3 = 0.0D;
         if (this.bienBail.getBiebaiLoyerProf() != 0.0D) {
            var5 = this.bienBail.getBiebaiLoyerProf() / this.bienBail.getBiebaiLoyerBrut() * this.bienBail.getBiebaiCharges();
            var3 = this.bienBail.getBiebaiLoyerProf() + var5;
         } else {
            var3 = this.bienBail.getBiebaiLoyerBrut() + this.bienBail.getBiebaiCharges();
         }

         var5 = this.utilNombre.myRoundDevise(var3 * (double)this.bienBail.getBiebaiTauxTva() / 100.0D, this.structureLog.getStrdevise());
         this.bienBail.setBiebaiTva(var5);
      }

      var3 = var1 + this.bienBail.getBiebaiTva() + this.bienBail.getBiebaiTom() + this.bienBail.getBiebaiTlv();
      this.bienBail.setBiebaiLoyerNet(var3);
      this.bienBail.setBiebaiBaseGerance(this.bienBail.getBiebaiLoyerBrut());
      double var7;
      if (this.bienBail.getBiebaiTauxGerance() != 0.0F) {
         var5 = this.utilNombre.myRoundDevise(this.bienBail.getBiebaiBaseGerance() * (double)this.bienBail.getBiebaiTauxGerance() / 100.0D, this.structureLog.getStrdevise()) + this.bienBail.getBiebaiForfaitGerance();
         this.bienBail.setBiebaiComGerance(var5);
         if (this.bienBail.getBiebaiTauxTva() != 0.0F) {
            var7 = this.utilNombre.myRoundDevise(this.bienBail.getBiebaiComGerance() * (double)this.bienBail.getBiebaiTauxTva() / 100.0D, this.structureLog.getStrdevise());
            this.bienBail.setBiebaiTvaGerance(var7);
         } else {
            this.bienBail.setBiebaiTvaGerance(0.0D);
         }
      } else if (this.bienBail.getBiebaiForfaitGerance() != 0.0D) {
         var5 = this.bienBail.getBiebaiForfaitGerance();
         this.bienBail.setBiebaiComGerance(var5);
         if (this.bienBail.getBiebaiTauxTva() != 0.0F) {
            var7 = this.utilNombre.myRoundDevise(this.bienBail.getBiebaiComGerance() * (double)this.bienBail.getBiebaiTauxTva() / 100.0D, this.structureLog.getStrdevise());
            this.bienBail.setBiebaiTvaGerance(var7);
         } else {
            this.bienBail.setBiebaiTvaGerance(0.0D);
         }
      } else {
         this.bienBail.setBiebaiComGerance(0.0D);
         this.bienBail.setBiebaiTvaGerance(0.0D);
      }

      if (this.bienBail.getBiebaiTypeProprietaire() == 1 && this.bienBail.getBiebaiLoyerBrut() >= 150000.0D) {
         var5 = this.utilNombre.myRoundDevise(this.bienBail.getBiebaiLoyerBrut() * (double)this.bienBail.getBiebaiTauxIrpp() / 100.0D, this.structureLog.getStrdevise());
         this.bienBail.setBiebaiIrpp(var5);
      } else {
         this.bienBail.setBiebaiIrpp(0.0D);
      }

   }

   public void historiqueBail() throws HibernateException, NamingException {
      this.lesHistoriques.clear();
      this.lesHistoriques = this.bienFactureDao.rechercheByBail(this.bienBail.getBiebaiNum(), (Session)null);
      this.montantTtc = 0.0D;
      this.montantReglement = 0.0D;
      this.montantSolde = 0.0D;
      this.var_nb_ligne = 0;
      if (this.lesHistoriques.size() != 0) {
         for(int var1 = 0; var1 < this.lesHistoriques.size(); ++var1) {
            this.montantTtc += ((BienFacture)this.lesHistoriques.get(var1)).getBiefacTotTtc();
            this.montantReglement += ((BienFacture)this.lesHistoriques.get(var1)).getBiefacTotReglement();
         }

         this.var_nb_ligne = this.lesHistoriques.size();
         this.montantSolde = this.montantTtc - this.montantReglement;
      }

      this.dataModelHistorique.setWrappedData(this.lesHistoriques);
      this.var_action = 14;
      this.var_memo_action = this.var_action;
   }

   public void retourListeBail() {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
   }

   public void valideDocument() throws HibernateException, NamingException {
      if (this.bienBail != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.bienBail.getBiebaiEtat() == 0 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
               this.bienBail.setBiebaiEtat(1);
               this.bienBail = this.bienBailDao.modif(this.bienBail, var1);
               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Validation manuelle bail (I.) N° " + this.bienBail.getBiebaiNum() + " du " + this.utilDate.dateToStringSQLLight(this.bienBail.getBiebaiDate()));
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
      if (this.bienBail != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.bienBail.getBiebaiEtat() == 1) {
               this.bienBail.setBiebaiEtat(0);
               this.bienBail.setBiebaiDateImp((Date)null);
               this.bienBail = this.bienBailDao.modif(this.bienBail, var1);
               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Dévalidation manuelle bail (I.) N° " + this.bienBail.getBiebaiNum() + " du " + this.utilDate.dateToStringSQLLight(this.bienBail.getBiebaiDate()));
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

   public void annulerDocument() {
      if (this.bienBail != null) {
         this.bienBail.setBiebaiDateAnnule(new Date());
         this.bienBail.setBiebaiEtat(3);
         this.showModalPanelAnnuler = true;
      }

   }

   public void annuleAnnulation() {
      this.showModalPanelAnnuler = false;
   }

   public void miseajourAnnuler() throws HibernateException, NamingException {
      if (this.bienBail != null) {
         if (this.bienBail.getBiebaiDateAnnule() == null) {
            this.bienBail.setBiebaiDateAnnule(new Date());
         }

         this.bienBail = this.bienBailDao.modif(this.bienBail);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         var1.setEspaction("Annulation bail locatif N° " + this.bienBail.getBiebaiNum() + " pour " + this.bienBail.getBiebaiMotifAnnule());
         this.espionDao.mAJEspion(var1);
         this.listBail.remove(this.bienBail);
         this.datamodelBail1.setWrappedData(this.listBail);
         this.datamodelBail2.setWrappedData(this.listBail);
         this.datamodelBail3.setWrappedData(this.listBail);
      }

      this.showModalPanelAnnuler = false;
      this.visibiliteBton = false;
   }

   public void reactiverDocument() throws HibernateException, NamingException {
      if (this.bienBail != null) {
         this.bienBail.setBiebaiEtat(0);
         this.bienBail.setBiebaiDateAnnule((Date)null);
         this.bienBail.setBiebaiMotifAnnule("");
         this.bienBail.setBiebaiDateFinFacture((Date)null);
         this.bienBail = this.bienBailDao.modif(this.bienBail);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         var1.setEspaction("Réactivation bail locatif N° " + this.bienBail.getBiebaiNum());
         this.espionDao.mAJEspion(var1);
         this.var_action = 0;
         this.var_memo_action = this.var_action;
      }

   }

   public void rechercheTexteModeleContrat() throws HibernateException, NamingException {
      this.bienBail.setBiebaiContrat("");
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
            this.bienBail.setBiebaiContrat(var4.getModTexte());
            this.calculeTexte();
         } else {
            this.bienBail.setBiebaiContrat("Erreur modèle");
         }
      }

   }

   public void calculeTexte() throws HibernateException, NamingException {
      this.calculeZone((Session)null);
      if (this.bienBail.getBiebaiContrat() != null && !this.bienBail.getBiebaiContrat().isEmpty()) {
         this.bienBail.setBiebaiContrat(this.utilTdt.analyseTexteCommercial(this.bienBail.getBiebaiContrat(), this.usersLog, this.structureLog, this.locataire, this.bienBail));
      } else {
         this.afficheTexteContrat = true;
      }

   }

   public void calculeZone(Session var1) throws HibernateException, NamingException {
   }

   public void rechercheTiers() throws JDOMException, IOException, HibernateException, NamingException {
      this.locataire = this.formRecherche.rechercheTiers(3, this.bienBail.getBiebaiNomTiers(), this.nature);
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

   public void recuperationTiers() throws JDOMException, IOException, HibernateException, NamingException {
      this.locataire = this.formRecherche.calculeTiers();
      this.calculeTiers();
   }

   public void calculeTiers() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.locataire != null) {
         this.bienBail.setTiers(this.locataire);
         String var1 = "";
         if (!this.locataire.getTiegenre().equalsIgnoreCase("010") && !this.locataire.getTiegenre().equalsIgnoreCase("020") && !this.locataire.getTiegenre().equalsIgnoreCase("030") && !this.locataire.getTiegenre().equalsIgnoreCase("037") && !this.locataire.getTiegenre().equalsIgnoreCase("070") && !this.locataire.getTiegenre().equalsIgnoreCase("080")) {
            var1 = this.locataire.getTieraisonsocialenom();
            this.bienBail.setBiebaiCivilTiers("");
         } else {
            var1 = this.locataire.getTieraisonsocialenom() + " " + this.locataire.getTieprenom();
            this.bienBail.setBiebaiCivilTiers(this.bienBail.getTiers().getTiecivilite());
         }

         this.bienBail.setBiebaiNomTiers(var1);
         this.bienBail.setBiebaiLocataire(this.locataire.getTiesigle());
      } else {
         this.annuleTiers();
      }

      this.controleSaisie();
      this.var_action = this.var_memo_action;
   }

   public void annuleTiers() {
      this.locataire = new Tiers();
      this.bienBail.setTiers(this.locataire);
      this.bienBail.setBiebaiNomTiers("");
      this.bienBail.setBiebaiLocataire("");
      this.bienBail.setBiebaiCivilTiers("");
      this.controleSaisie();
      this.var_action = this.var_memo_action;
   }

   public void controleSaisie() {
      if (this.bienBail.getBiebaiNomTiers() != null && !this.bienBail.getBiebaiNomTiers().isEmpty() && this.locataire.getTieid() != 0L) {
         this.var_aff_detail_locataire = true;
         if (this.var_code_unique) {
            this.var_valide_doc = true;
         } else {
            this.var_valide_doc = false;
         }
      } else {
         this.var_valide_doc = false;
         this.var_aff_detail_locataire = false;
      }

   }

   public void uniciteCodeBien() throws HibernateException, NamingException {
      this.var_code_unique = this.bienDao.logMailExiste(this.bien.getBieNum(), (Session)null);
      if (!this.var_code_unique) {
         this.bien.setBieNum("");
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
      this.bien = this.formRecherche.rechercheBiens(this.bienBail.getBiebaiLocal(), this.nature, this.categorie);
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
         this.bienBail.setBien(this.bien);
         this.bienBail.setBiebaiLocal(this.bien.getBieNum());
         this.proprietaire = this.bien.getTiers();
         if (this.proprietaire != null) {
            String var1 = "";
            if (this.proprietaire != null && this.proprietaire.getTiegenre() != null && !this.proprietaire.getTiegenre().isEmpty() && (this.proprietaire.getTiegenre().equalsIgnoreCase("010") || this.proprietaire.getTiegenre().equalsIgnoreCase("020") || this.proprietaire.getTiegenre().equalsIgnoreCase("030") || this.proprietaire.getTiegenre().equalsIgnoreCase("037") || this.proprietaire.getTiegenre().equalsIgnoreCase("070") || this.proprietaire.getTiegenre().equalsIgnoreCase("080"))) {
               if (this.proprietaire.getTieprenom() != null && !this.proprietaire.getTieprenom().isEmpty()) {
                  var1 = this.proprietaire.getTieraisonsocialenom() + " " + this.proprietaire.getTieprenom();
               } else {
                  var1 = this.proprietaire.getTieraisonsocialenom();
               }

               if (this.proprietaire != null && this.proprietaire.getTiecivilite() != null && !this.proprietaire.getTiecivilite().isEmpty()) {
                  this.bienBail.setBiebaiCivilTiers(this.proprietaire.getTiecivilite());
               } else {
                  this.bienBail.setBiebaiCivilTiers("");
               }
            } else {
               var1 = this.proprietaire.getTieraisonsocialenom();
               this.bienBail.setBiebaiCivilTiers("");
            }

            this.bienBail.setBiebaiTypeProprietaire(this.proprietaire.getTieAssujettissement());
            this.bienBail.setBiebaiNomProprietaire(var1);
            this.bienBail.setBiebaiProprietaire(this.proprietaire.getTiesigle());
            this.bienBail.setBiebaiIdProprietaire(this.proprietaire.getTieid());
            BienGeranceLigneDao var2 = new BienGeranceLigneDao(this.baseLog, this.utilInitHibernate);
            new BienGeranceLigne();
            BienGeranceLigne var3 = var2.chargerDetail((String)this.bien.getBieNum(), (Session)null);
            if (var3 != null) {
               this.bienBail.setBiebaiCharges(var3.getBiegerligChargesImmeuble());
               this.bienBail.setBiebaiTauxCharges(var3.getBiegerligTauxCharges());
               this.bienBail.setBiebaiDiversFrais(var3.getBiegerligDiversFrais());
               this.bienBail.setBiebaiEau(var3.getBiegerligEau());
               this.bienBail.setBiebaiElectricite(var3.getBiegerligElectricite());
               this.bienBail.setBiebaiGardiennage(var3.getBiegerligGardiennage());
               this.bienBail.setBiebaiIrpp(0.0D);
               this.bienBail.setBiebaiLoyerBrut(var3.getBiegerligLoyerBrut());
               this.bienBail.setBiebaiLoyerNet(0.0D);
               this.bienBail.setBiebaiLoyerProf(var3.getBiegerligLoyerProfessionnel());
               this.bienBail.setBiebaiMode(var3.getBiegerligMode());
               this.bienBail.setBiebaiMontantCaution(var3.getBiegerligMontantCaution());
               this.bienBail.setBiebaiParking(var3.getBiegerligParking());
               this.bienBail.setBiebaiTauxGerance(var3.getBiegerligTauxCommission());
               this.bienBail.setBiebaiTauxIrpp(var3.getBiegerligTauxIrpp());
               this.bienBail.setBiebaiTauxTlv(var3.getBiegerligTauxTlv());
               this.bienBail.setBiebaiTauxTom(var3.getBiegerligTauxTom());
               this.bienBail.setBiebaiTauxTva(var3.getBiegerligTauxTva());
               this.bienBail.setBiebaiModeTlv(var3.getBiegerligModeTlv());
               this.bienBail.setBiebaiTlv(0.0D);
               this.bienBail.setBiebaiTom(0.0D);
               this.bienBail.setBiebaiTva(0.0D);
               this.bienBail.setBiebaiTvaGerance(0.0D);
               this.bienBail.setBiebaiType(0);
               this.bienBail.setBiebaiUsage(var3.getBiegerligUsage());
            } else {
               this.bienBail.setBiebaiCharges(this.bien.getBieCharges());
               this.bienBail.setBiebaiTauxCharges(0.0F);
               this.bienBail.setBiebaiDiversFrais(0.0D);
               this.bienBail.setBiebaiEau(0.0D);
               this.bienBail.setBiebaiElectricite(0.0D);
               this.bienBail.setBiebaiGardiennage(0.0D);
               this.bienBail.setBiebaiIrpp(0.0D);
               this.bienBail.setBiebaiLoyerBrut(this.bien.getBieBaseLoyer());
               this.bienBail.setBiebaiLoyerNet(0.0D);
               this.bienBail.setBiebaiLoyerProf(0.0D);
               this.bienBail.setBiebaiMode(2);
               this.bienBail.setBiebaiMontantCaution(0.0D);
               this.bienBail.setBiebaiParking(0.0D);
               this.bienBail.setBiebaiTauxIrpp(this.taux_irpp);
               this.bienBail.setBiebaiTauxTlv(this.taux_tlv);
               this.bienBail.setBiebaiTauxTom(this.taux_tom);
               this.bienBail.setBiebaiTauxTva(this.taux_tva);
               this.bienBail.setBiebaiModeTlv(0);
               this.bienBail.setBiebaiTlv(0.0D);
               this.bienBail.setBiebaiTom(0.0D);
               this.bienBail.setBiebaiTva(0.0D);
               this.bienBail.setBiebaiTvaGerance(0.0D);
               this.bienBail.setBiebaiType(0);
               this.bienBail.setBiebaiUsage(0);
            }

            this.calculBail();
            this.var_aff_detail_proprietaire = true;
         }
      } else {
         this.annuleBiens();
      }

      this.controleSaisieBiens();
      this.var_action = this.var_memo_action;
   }

   public void annuleBiens() {
      this.bien = new Bien();
      this.bienBail.setBiebaiLocal("");
      this.bienBail.setBiebaiNomProprietaire("");
      this.bienBail.setBiebaiProprietaire("");
      this.bienBail.setBiebaiCivilProprietaire("");
      this.bienBail.setBiebaiTypeProprietaire(0);
      this.bienBail.setBiebaiIdProprietaire(0L);
      this.var_aff_detail_proprietaire = false;
      this.controleSaisieBiens();
      this.var_action = this.var_memo_action;
   }

   public void controleSaisieBiens() {
      if (this.bienBail.getBiebaiLocal() != null && !this.bienBail.getBiebaiLocal().isEmpty() && this.bien.getBieId() != 0L) {
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

   public String calculeCheminRapport(String var1, int var2) {
      String var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "documentLocation" + File.separator + "bail" + File.separator;
      return var3;
   }

   public String calculeCheminSousRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "sous_rapport" + File.separator;
      return var2;
   }

   public String calculeImageFond(String var1) throws HibernateException, NamingException {
      String var2 = "";
      File var3 = new File(this.calculeCheminSousRapport(var1) + "formatBail.jpg");
      if (var3.exists()) {
         var2 = "formatBail.jpg";
      }

      return var2;
   }

   public JRBeanCollectionDataSource calculeImpressionCommun() throws IOException {
      this.montant_lettre = this.utilNombre.begin(this.bienBail.getBiebaiLoyerNet(), this.structureLog.getStrdevise());
      ArrayList var1 = new ArrayList();
      JRBeanCollectionDataSource var2 = new JRBeanCollectionDataSource(var1);
      return var2;
   }

   public boolean majDateImpression(String var1) throws HibernateException, NamingException {
      boolean var2 = false;
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         if (this.bienBail.getBiebaiDateImp() != null) {
            var2 = true;
         }

         this.bienBail.setBiebaiDateImp(new Date());
         if (this.bienBail.getBiebaiEtat() == 0 && this.bienBail.getBiebaiEtatVal() == 0 && this.usersChrono.getUsrchrValidation() == 1) {
            this.bienBail.setBiebaiEtat(1);
         }

         this.bienBail.setBiebaiModeleImp(var1);
         this.bienBail = this.bienBailDao.modif(this.bienBail, var3);
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
            var1.setEntete("Impression bail");
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
            var1.setIdResponsable(this.bienBail.getBiebaiIdResponsable());
            var1.setIdCommercial(0L);
            var1.setTiersSelectionne(this.bienBail.getTiers());
            var1.setNumDoc(this.bienBail.getBiebaiNum());
            var1.setNature(this.nature);
            var1.setId_doc(this.bienBail.getBiebaiId());
            var1.setParc((Parc)null);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      } else if (var2 == 1 && var4 != null && !var4.isEmpty()) {
         var1.setRapport(var4);
         var1.setEntete("Impression de la liste des baux");
         var1.setTotauxHt("");
         var1.setTotauxTaxe("");
         var1.setTotauxTtc("");
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "listeLocation" + File.separator + "bail" + File.separator);
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
         JRBeanCollectionDataSource var12 = new JRBeanCollectionDataSource(this.listBail);
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

   public BienBail getBienBail() {
      return this.bienBail;
   }

   public void setBienBail(BienBail var1) {
      this.bienBail = var1;
   }

   public DataModel getDatamodelBail1() {
      return this.datamodelBail1;
   }

   public void setDatamodelBail1(DataModel var1) {
      this.datamodelBail1 = var1;
   }

   public DataModel getDatamodelBail2() {
      return this.datamodelBail2;
   }

   public void setDatamodelBail2(DataModel var1) {
      this.datamodelBail2 = var1;
   }

   public DataModel getDatamodelBail3() {
      return this.datamodelBail3;
   }

   public void setDatamodelBail3(DataModel var1) {
      this.datamodelBail3 = var1;
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

   public int getPeriode() {
      return this.periode;
   }

   public void setPeriode(int var1) {
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

   public URI getUri() {
      return this.uri;
   }

   public void setUri(URI var1) {
      this.uri = var1;
   }

   public boolean isAfficheTexteContrat() {
      return this.afficheTexteContrat;
   }

   public void setAfficheTexteContrat(boolean var1) {
      this.afficheTexteContrat = var1;
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

   public boolean isVar_aff_detail_local() {
      return this.var_aff_detail_local;
   }

   public void setVar_aff_detail_local(boolean var1) {
      this.var_aff_detail_local = var1;
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

   public List getLesPeriodes() {
      return this.lesPeriodes;
   }

   public void setLesPeriodes(List var1) {
      this.lesPeriodes = var1;
   }

   public Habilitation getHabilitation() {
      return this.habilitation;
   }

   public void setHabilitation(Habilitation var1) {
      this.habilitation = var1;
   }

   public DataModel getDataModelHistorique() {
      return this.dataModelHistorique;
   }

   public void setDataModelHistorique(DataModel var1) {
      this.dataModelHistorique = var1;
   }

   public double getMontantReglement() {
      return this.montantReglement;
   }

   public void setMontantReglement(double var1) {
      this.montantReglement = var1;
   }

   public double getMontantSolde() {
      return this.montantSolde;
   }

   public void setMontantSolde(double var1) {
      this.montantSolde = var1;
   }

   public double getMontantTtc() {
      return this.montantTtc;
   }

   public void setMontantTtc(double var1) {
      this.montantTtc = var1;
   }

   public int getVar_nb_ligne() {
      return this.var_nb_ligne;
   }

   public void setVar_nb_ligne(int var1) {
      this.var_nb_ligne = var1;
   }

   public Date getDatePeremption() {
      return this.datePeremption;
   }

   public void setDatePeremption(Date var1) {
      this.datePeremption = var1;
   }

   public boolean isAffaicheDatePermption() {
      return this.affaicheDatePermption;
   }

   public void setAffaicheDatePermption(boolean var1) {
      this.affaicheDatePermption = var1;
   }

   public boolean isShowModalPanelAnnuler() {
      return this.showModalPanelAnnuler;
   }

   public void setShowModalPanelAnnuler(boolean var1) {
      this.showModalPanelAnnuler = var1;
   }

   public UIDataTable getExtDTable1() {
      return this.extDTable1;
   }

   public void setExtDTable1(UIDataTable var1) {
      this.extDTable1 = var1;
   }

   public UIDataTable getExtDTable2() {
      return this.extDTable2;
   }

   public void setExtDTable2(UIDataTable var1) {
      this.extDTable2 = var1;
   }

   public UIDataTable getExtDTable3() {
      return this.extDTable3;
   }

   public void setExtDTable3(UIDataTable var1) {
      this.extDTable3 = var1;
   }

   public SimpleSelection getSimpleSelectionEntete1() {
      return this.simpleSelectionEntete1;
   }

   public void setSimpleSelectionEntete1(SimpleSelection var1) {
      this.simpleSelectionEntete1 = var1;
   }

   public SimpleSelection getSimpleSelectionEntete2() {
      return this.simpleSelectionEntete2;
   }

   public void setSimpleSelectionEntete2(SimpleSelection var1) {
      this.simpleSelectionEntete2 = var1;
   }

   public SimpleSelection getSimpleSelectionEntete3() {
      return this.simpleSelectionEntete3;
   }

   public void setSimpleSelectionEntete3(SimpleSelection var1) {
      this.simpleSelectionEntete3 = var1;
   }
}
