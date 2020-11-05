package com.epegase.forms.immobilier;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.Bien;
import com.epegase.systeme.classe.BienBudgetEntete;
import com.epegase.systeme.classe.BienBudgetLigne;
import com.epegase.systeme.classe.BienTravauxEntete;
import com.epegase.systeme.classe.BienTravauxLigne;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.Rdv;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.BlocImmeuble;
import com.epegase.systeme.control.RdvSemaine;
import com.epegase.systeme.dao.BienBudgetEnteteDao;
import com.epegase.systeme.dao.BienBudgetLigneDao;
import com.epegase.systeme.dao.BienDao;
import com.epegase.systeme.dao.BienTravauxEnteteDao;
import com.epegase.systeme.dao.BienTravauxLigneDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.RdvDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilDownload;
import com.epegase.systeme.util.UtilGoogleMap;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.ObjetLigneOnglet;
import com.epegase.systeme.xml.OptionVentes;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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

public class FormTravauxImmobilier implements Serializable {
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
   private int var_imput_cat;
   private transient DataModel datamodelOt = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private List listOt = new ArrayList();
   private BienTravauxEntete bienTravauxEntete = new BienTravauxEntete();
   private BienTravauxEnteteDao bienTravauxEnteteDao;
   private boolean visibiliteBton = false;
   private Tiers tiers;
   private Tiers fournisseur;
   private TiersDao tiersDao;
   private boolean var_aff_detail_tiers = false;
   private boolean var_aff_detail_fournisseur = false;
   private boolean var_valide_doc = false;
   private transient DataModel datamodelDetail = new ListDataModel();
   private List listDetail = new ArrayList();
   private BienTravauxLigne bienTravauxLigne;
   private BienTravauxLigneDao bienTravauxLigneDao;
   private boolean var_affiche_facture = false;
   private Bien bien;
   private BienDao bienDao;
   private boolean showModalPanelDetail = false;
   private boolean var_aff_detail_bien = false;
   private String referenceOt;
   private String referenceBien;
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
   private String inpBien = "";
   private Date inpDu = null;
   private Date inpAu = null;
   private boolean var_more_search = false;
   private List mesBiensRecItems;
   private Users responsable;
   private long var_nom_commercial;
   private List mesSerieUserItem;
   private UserDao userDao;
   private boolean showModalPanelPrint = false;
   private String montant_lettre;
   private boolean showModalGoogleMap = false;
   private URI uri;
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
   private List lesPostesItems;
   private BienBudgetEntete bienBudgetEntete;
   private BienBudgetEnteteDao bienBudgetEnteteDao;
   private BienBudgetLigne bienBudgetLigne;
   private BienBudgetLigneDao bienBudgetLigneDao;
   private List lesBlocsItems;
   private int modeRdv;
   private Date parMois;
   private Date parSemaine;
   private Date parJour;
   private Date jourDeb;
   private Date jourFin;
   private int valNatMois = 99;
   private int valStatutMois = 10;
   private int valNatSemaine = 99;
   private int valStatutSemaine = 10;
   private int valNatJour = 99;
   private int valStatutJour = 10;
   private int valNatListe = 99;
   private int valStatutListe = 10;
   private List listRdvMois;
   private List listRdvSemaine;
   private List listRdvJour;
   private List listRdv;
   private transient DataModel datamodelRdv;
   private transient DataModel datamodelLesRdvParJour;
   private transient DataModel datamodelLesRdvParSemaine;
   private transient DataModel datamodelLesRdvParMois;
   private String dateLun;
   private String dateMar;
   private String dateMer;
   private String dateJeu;
   private String dateVen;
   private String dateSam;
   private String dateDim;
   private boolean showModalPanelPlanning;
   private boolean afficheRdv;
   private RdvSemaine rdvSemaine;
   private List planningImpressionsItems;
   private boolean showModalPanelPrintPlanning;
   private Date memoDateLivraion;
   private Rdv rdv;
   private boolean showModalPanelRdv = true;
   private boolean compteRendu = false;
   private boolean rdvdetails = false;
   private RdvDao rdvDao;
   private boolean showModalPanelTiers = false;

   public FormTravauxImmobilier() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.utilDownload = new UtilDownload();
      this.lesPostesItems = new ArrayList();
      this.lesBlocsItems = new ArrayList();
      this.mesBiensRecItems = new ArrayList();
   }

   public void InstancesDaoUtilses() {
      this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.bienTravauxEnteteDao = new BienTravauxEnteteDao(this.baseLog, this.utilInitHibernate);
      this.bienTravauxLigneDao = new BienTravauxLigneDao(this.baseLog, this.utilInitHibernate);
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      this.bienBudgetEnteteDao = new BienBudgetEnteteDao(this.baseLog, this.utilInitHibernate);
      this.bienBudgetLigneDao = new BienBudgetLigneDao(this.baseLog, this.utilInitHibernate);
      this.bienDao = new BienDao(this.baseLog, this.utilInitHibernate);
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

      this.periode = this.optionsVentes.getAffichInGlobViewBLC();
      this.usersChrono = new UsersChrono();
      this.usersChrono = this.usersChronoDao.selectUnique("", this.nature, this.usersLog, var1);
      this.mesBiensRecItems.clear();
      new ArrayList();
      List var2 = this.bienDao.chargeBien(1, 9, var1);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            if (((Bien)var2.get(var3)).getBieType() == 2) {
               this.mesBiensRecItems.add(new SelectItem(((Bien)var2.get(var3)).getBieNum() + ":" + ((Bien)var2.get(var3)).getBieNom()));
            }
         }
      }

      String var5 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanFacture" + File.separator;
      File var4 = new File(var5);
      if (!var4.exists()) {
         var4.mkdir();
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

   public void googleMap() throws IOException, URISyntaxException {
      if (this.bien != null) {
         UtilGoogleMap var1 = new UtilGoogleMap(this.structureLog);
         this.uri = var1.calculMap(this.bien.getBieRue(), this.bien.getBieAdresse(), this.bien.getBieVille(), this.bien.getBieNomPays());
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
      this.listOt.clear();
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
         String var4 = "";
         if (this.inpClient != null && !this.inpClient.isEmpty() && this.inpClient.contains(":")) {
            String[] var5 = this.inpClient.split(":");
            var4 = var5[0];
         }

         if (this.nature == 163) {
            this.listOt = this.bienTravauxEnteteDao.recherche(var1, this.exercicesVentes.getExevteId(), this.getInpNum(), var4, this.getInpEtat(), this.getInpSerie(), this.getPeriode(), this.usersLog.getUsrid(), this.usersLog.getUsrVentes(), this.getInpResponsable(), var2, var3);
         } else if (this.nature == 164) {
            this.listDetail = this.bienTravauxLigneDao.recherche(var1, this.exercicesVentes.getExevteId(), this.getInpNum(), var4, this.getInpEtat(), this.getInpSerie(), this.getPeriode(), this.usersLog.getUsrid(), this.usersLog.getUsrVentes(), this.getInpResponsable(), var2, var3);
         }
      }

      this.datamodelOt.setWrappedData(this.listOt);
      this.datamodelDetail.setWrappedData(this.listDetail);
      this.visibiliteBton = false;
   }

   public void selectionLigneTravaux() throws HibernateException, NamingException {
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
            this.bienTravauxEntete = (BienTravauxEntete)var1.get(0);
            this.bien = this.bienTravauxEntete.getBien();
            Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
            this.chargerDetail(var4);
            this.chargerPosteBudgetGroupe(var4);
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
      if (this.bienTravauxEntete != null) {
         if (this.bienTravauxEntete.getBietraentEtat() == 0) {
            this.modifierOt();
         } else {
            this.consulterOt();
         }
      }

   }

   public void chargerDetail(Session var1) throws HibernateException, NamingException {
      this.listDetail.clear();
      this.listDetail = this.bienTravauxLigneDao.chargerDetail(this.bienTravauxEntete, var1);
      this.datamodelDetail.setWrappedData(this.listDetail);
   }

   public void chargerPosteBudgetGroupe(Session var1) throws HibernateException, NamingException {
      this.lesPostesItems.clear();
      if (this.bien != null) {
         this.bienBudgetEntete = new BienBudgetEntete();
         new ArrayList();
         new ArrayList();
         List var2 = this.bienBudgetEnteteDao.chargerBudgetByBien(this.bien, 0, var1);
         if (var2.size() != 0) {
            int var4;
            for(var4 = 0; var4 < var2.size(); ++var4) {
               if (((BienBudgetEntete)var2.get(var4)).getBiebudentEtat() == 1) {
                  this.bienBudgetEntete = (BienBudgetEntete)var2.get(var4);
               }
            }

            if (this.bienBudgetEntete.getBiebudentId() != 0L) {
               List var3 = this.bienBudgetLigneDao.chargerBudgetByBien(this.bienBudgetEntete, var1);
               if (var3.size() != 0) {
                  this.bienBudgetLigne = new BienBudgetLigne();

                  for(var4 = 0; var4 < var3.size(); ++var4) {
                     this.bienBudgetLigne = (BienBudgetLigne)var3.get(var4);
                     if (this.bienBudgetLigne.getBiebudligType() == 0 || this.bienBudgetLigne.getBiebudligType() == 1 || this.bienBudgetLigne.getBiebudligType() == 9) {
                        this.lesPostesItems.add(new SelectItem(this.bienBudgetLigne.getBiebudligCode(), this.bienBudgetLigne.getBiebudligCode() + ":" + this.bienBudgetLigne.getBiebudligLibelle()));
                     }
                  }
               }
            }
         }
      }

   }

   public void chargerBlocs() {
      this.lesBlocsItems.clear();
      if (this.bien.getBieType() == 2) {
         if (this.bien != null && this.bien.getBieType() == 2) {
            new BlocImmeuble();
            if (this.bien.getBieListeLocaux() != null && !this.bien.getBieListeLocaux().isEmpty()) {
               BlocImmeuble var1;
               String[] var2;
               if (!this.bien.getBieListeLocaux().contains("#")) {
                  if (this.bien.getBieListeLocaux().contains(":")) {
                     var2 = this.bien.getBieListeLocaux().split(":");
                     var1 = new BlocImmeuble();
                     var1.setIndice((long)Integer.parseInt(var2[0]));
                     var1.setCode(var2[1]);
                     var1.setMillieme(Integer.parseInt(var2[2]));
                     this.lesBlocsItems.add(new SelectItem(var1.getCode()));
                  }
               } else if (this.bien.getBieListeLocaux().contains(":")) {
                  var2 = this.bien.getBieListeLocaux().split("#");
                  int var3 = var2.length;

                  for(int var4 = 0; var4 < var3; ++var4) {
                     String[] var5 = var2[var4].split(":");
                     var1 = new BlocImmeuble();
                     var1.setIndice((long)Integer.parseInt(var5[0]));
                     var1.setCode(var5[1]);
                     var1.setMillieme(Integer.parseInt(var5[2]));
                     this.lesBlocsItems.add(new SelectItem(var1.getCode()));
                  }
               }
            }
         }
      } else if (this.bien.getBieType() == 1 && this.bien.getBieCodeBloc() != null && !this.bien.getBieCodeBloc().isEmpty()) {
         this.lesBlocsItems.add(new SelectItem(this.bien.getBieCodeBloc()));
      }

   }

   public void ajouterOt() throws HibernateException, NamingException {
      this.bienTravauxEntete = new BienTravauxEntete();
      this.bienTravauxEntete.setBietraentDateDebut(new Date());
      this.bienTravauxLigne = new BienTravauxLigne();
      this.bien = new Bien();
      this.listDetail.clear();
      this.datamodelDetail.setWrappedData(this.listDetail);
      this.var_action = 1;
      this.var_aff_action = false;
      this.var_affiche_facture = false;
      this.var_aff_detail_bien = false;
      this.controleSaisieBiens();
      this.var_memo_action = this.var_action;
      this.lesPostesItems.clear();
   }

   public void modifierOt() throws HibernateException, NamingException {
      if (this.bienTravauxEntete != null) {
         this.var_action = 1;
         this.var_aff_action = true;
         this.var_affiche_facture = false;
         this.controleSaisieBiens();
         this.var_memo_action = this.var_action;
      }

   }

   public void consulterOt() {
      if (this.bienTravauxEntete != null) {
         this.var_action = 21;
         this.var_aff_action = true;
         this.var_affiche_facture = false;
         this.controleSaisieBiens();
         this.var_memo_action = this.var_action;
      }

   }

   public void supprimerOt() throws HibernateException, NamingException {
      if (this.bienTravauxEntete != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.bienTravauxEntete.getBietraentNum() + ":" + this.bienTravauxEntete.getBietraentObjet();
            if (this.listDetail.size() != 0) {
               for(int var4 = 0; var4 < this.listDetail.size(); ++var4) {
                  this.bienTravauxLigne = (BienTravauxLigne)this.listDetail.get(var4);
                  this.bienTravauxLigneDao.delete(this.bienTravauxLigne, var1);
               }
            }

            this.bienTravauxEnteteDao.delete(this.bienTravauxEntete, var1);
            this.listOt.remove(this.bienTravauxEntete);
            this.datamodelOt.setWrappedData(this.listOt);
            this.listDetail.clear();
            this.datamodelDetail.setWrappedData(this.listDetail);
            Espion var10 = new Espion();
            var10.setUsers(this.usersLog);
            var10.setEsptype(0);
            var10.setEspdtecreat(new Date());
            var10.setEspaction("Suppression OT N° " + var3);
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

   public void annulerOt() {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.visibiliteBton = false;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public void validerOt() throws HibernateException, NamingException {
      boolean var1 = false;
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         if (this.bienTravauxEntete.getBietraentDateDebut() == null) {
            this.bienTravauxEntete.setBietraentDateDebut(new Date());
         }

         double var4 = 0.0D;
         int var6;
         if (this.listDetail.size() != 0) {
            for(var6 = 0; var6 < this.listDetail.size(); ++var6) {
               var4 += ((BienTravauxLigne)this.listDetail.get(var6)).getBietraligTtc();
            }
         }

         this.bienTravauxEntete.setBietraentCoutReel(var4);
         if (this.bienTravauxEntete.getBietraentIdCtrl() != 0L) {
            new Users();
            Users var12 = this.userDao.selectByIdUsers(this.bienTravauxEntete.getBietraentIdCtrl(), var2);
            if (var12 != null) {
               this.bienTravauxEntete.setBietraentNomCtrl(var12.getUsrPatronyme());
            } else {
               this.bienTravauxEntete.setBietraentNomCtrl("");
            }
         } else {
            this.bienTravauxEntete.setBietraentNomCtrl("");
         }

         if (this.bienTravauxEntete.getBietraentId() != 0L) {
            var1 = false;
            this.bienTravauxEntete.setBietraentDateModif(new Date());
            this.bienTravauxEntete.setBietraentUserModif(this.usersLog.getUsrid());
            this.bienTravauxEntete = this.bienTravauxEnteteDao.modif(this.bienTravauxEntete, var2);
         } else {
            var1 = true;
            if (this.bienTravauxEntete.getBietraentNum() == null || this.bienTravauxEntete.getBietraentNum().isEmpty()) {
               this.bienTravauxEntete.setBietraentNum(this.calculChrono.numCompose(this.bienTravauxEntete.getBietraentDateDebut(), this.nature, this.bienTravauxEntete.getBietraentSerie(), var2));
            }

            this.bienTravauxEntete.setBietraentDateCreat(new Date());
            this.bienTravauxEntete.setBietraentUserCreat(this.usersLog.getUsrid());
            this.bienTravauxEntete = this.bienTravauxEnteteDao.insert(this.bienTravauxEntete, var2);
            this.listOt.add(this.bienTravauxEntete);
            this.datamodelOt.setWrappedData(this.listOt);
         }

         if (this.listDetail.size() != 0) {
            for(var6 = 0; var6 < this.listDetail.size(); ++var6) {
               this.bienTravauxLigne = (BienTravauxLigne)this.listDetail.get(var6);
               this.bienTravauxLigne.setBienTravauxEntete(this.bienTravauxEntete);
               this.bienTravauxLigne = this.bienTravauxLigneDao.maj(this.bienTravauxLigne, var2);
            }
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

      if (!var1) {
         this.var_action = 0;
         this.var_memo_action = this.var_action;
      }

   }

   public void selectionFacture() throws HibernateException, NamingException, IOException, SQLException {
      if (this.datamodelDetail.isRowAvailable()) {
         this.bienTravauxLigne = (BienTravauxLigne)this.datamodelDetail.getRowData();
         this.tiers = this.tiersDao.selectTierD(this.bienTravauxLigne.getBietraligIdTiers());
         this.bien = this.bienTravauxEntete.getBien();
         if (this.tiers == null) {
            this.tiers = new Tiers();
         }

         this.affichePhotoProduit();
         this.var_affiche_facture = true;
      }

   }

   public void ajouterFacture() throws HibernateException, NamingException {
      if (this.bienTravauxEntete != null) {
         this.bienTravauxLigne = new BienTravauxLigne();
         this.tiers = new Tiers();
         this.bien = new Bien();
         this.urlphotoProd = null;
         this.var_aff_detail_tiers = false;
         this.var_action_detail = 1;
         this.var_affiche_facture = false;
         this.showModalPanelDetail = true;
      }

   }

   public void modifierFacture() {
      if (this.bienTravauxLigne != null) {
         this.var_action_detail = 1;
         this.controleSaisieTiers();
         this.showModalPanelDetail = true;
      }

   }

   public void consulterFacture() {
      if (this.bienTravauxLigne != null) {
         this.var_action_detail = 21;
         this.controleSaisieTiers();
         this.showModalPanelDetail = true;
      }

   }

   public void supprimerFacture() throws HibernateException, NamingException {
      if (this.bienTravauxLigne != null) {
         this.bienTravauxLigneDao.delete(this.bienTravauxLigne);
         this.listDetail.remove(this.bienTravauxLigne);
         this.datamodelDetail.setWrappedData(this.listDetail);
         if (this.bienTravauxLigne.getBietraligScanFacture() != null && !this.bienTravauxLigne.getBietraligScanFacture().isEmpty()) {
         }

         this.var_affiche_facture = false;
      }

   }

   public void fermerFacture() {
      this.showModalPanelDetail = false;
      this.visibiliteBton = false;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public void validerFacture() throws HibernateException, NamingException {
      if (this.bienTravauxEntete.getBietraentId() == 0L) {
         this.validerOt();
      }

      if (this.bienTravauxEntete == null && this.bienTravauxEntete.getBietraentId() == 0L) {
         this.bienTravauxLigne.setBienTravauxEntete((BienTravauxEntete)null);
      } else {
         this.bienTravauxLigne.setBienTravauxEntete(this.bienTravauxEntete);
      }

      this.bienTravauxLigne.setBien(this.bien);
      this.bienTravauxLigne.setBietraligIdBien(this.bien.getBieId());
      if (this.bien.getBieType() == 1) {
         this.bienTravauxLigne.setBietraligCodeGroupe(this.bien.getBieGroupe());
      } else if (this.bien.getBieType() == 2) {
         this.bienTravauxLigne.setBietraligCodeGroupe(this.bien.getBieNum());
      } else {
         this.bienTravauxLigne.setBietraligCodeGroupe("");
      }

      if (this.bienTravauxLigne.getBietraligId() == 0L) {
         this.bienTravauxLigne = this.bienTravauxLigneDao.insert(this.bienTravauxLigne);
         this.listDetail.add(this.bienTravauxLigne);
         this.datamodelDetail.setWrappedData(this.listDetail);
      } else {
         this.bienTravauxLigne = this.bienTravauxLigneDao.modif(this.bienTravauxLigne);
      }

      double var1 = 0.0D;
      if (this.listDetail.size() != 0) {
         for(int var3 = 0; var3 < this.listDetail.size(); ++var3) {
            var1 += ((BienTravauxLigne)this.listDetail.get(var3)).getBietraligTtc();
         }
      }

      if (this.bienTravauxEntete != null || this.bienTravauxEntete.getBietraentId() != 0L) {
         this.bienTravauxEntete.setBietraentCoutReel(var1);
         this.bienTravauxEntete = this.bienTravauxEnteteDao.modif(this.bienTravauxEntete);
      }

      this.controleSaisieTiers();
      this.showModalPanelDetail = false;
   }

   public void selectionFactureDirecte() throws HibernateException, NamingException, IOException, SQLException {
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

         this.bienTravauxLigne = (BienTravauxLigne)var1.get(0);
         this.bienTravauxEntete = this.bienTravauxLigne.getBienTravauxEntete();
         this.affichePhotoProduit();
         if (this.bienTravauxEntete != null) {
            this.referenceOt = this.bienTravauxEntete.getBietraentNum() + ":" + this.utilDate.dateToStringFr(this.bienTravauxEntete.getBietraentDateDebut());
         } else {
            this.referenceOt = "";
         }

         this.bien = this.bienTravauxLigne.getBien();
         if (this.bien != null) {
            this.referenceBien = this.bien.getBieNum() + ":" + this.bien.getBieNom();
         } else {
            this.referenceBien = "";
         }

         this.chargerBlocs();
         Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
         if (this.bienTravauxLigne.getBietraligIdTiers() != 0L) {
            this.fournisseur = this.tiersDao.selectTierD(this.bienTravauxLigne.getBietraligIdTiers(), var4);
         } else {
            this.fournisseur = null;
         }

         this.chargerPosteBudgetGroupe(var4);
         this.utilInitHibernate.closeSession();
      }

      this.visibiliteBton = true;
   }

   public void visualisationFactureDirectre() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.bienTravauxLigne != null) {
         if (this.bienTravauxLigne.getBietraligEtat() == 0) {
            this.modifierFactureDirecte();
         } else {
            this.consulterFactureDirecte();
         }
      }

   }

   public void ajouterFactureDirecte() throws HibernateException, NamingException, IOException, SQLException {
      this.bien = new Bien();
      this.bienTravauxLigne = new BienTravauxLigne();
      this.fournisseur = new Tiers();
      this.bienTravauxLigne.setBietraligDateFacture(new Date());
      this.referenceBien = "";
      this.referenceOt = "";
      this.urlphotoProd = null;
      this.var_aff_detail_tiers = false;
      this.var_action_detail = 1;
      this.var_affiche_facture = false;
      this.var_action = 31;
      this.var_memo_action = this.var_action;
   }

   public void modifierFactureDirecte() {
      if (this.bienTravauxLigne != null) {
         this.var_action_detail = 1;
         this.controleSaisieTravaux();
         this.var_action = 41;
         this.var_memo_action = this.var_action;
      }

   }

   public void consulterFactureDirecte() {
      if (this.bienTravauxLigne != null) {
         this.var_action_detail = 21;
         this.controleSaisieTravaux();
         this.var_action = 51;
         this.var_memo_action = this.var_action;
      }

   }

   public void supprimerFactureDirecte() throws HibernateException, NamingException {
      if (this.bienTravauxLigne != null) {
         this.bienTravauxLigneDao.delete(this.bienTravauxLigne);
         this.listDetail.remove(this.bienTravauxLigne);
         this.datamodelDetail.setWrappedData(this.listDetail);
         if (this.bienTravauxLigne.getBietraligScanFacture() != null && !this.bienTravauxLigne.getBietraligScanFacture().isEmpty()) {
            String var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanFacture") + File.separator + this.bienTravauxLigne.getBietraligScanFacture();
            File var2 = new File(var1);
            if (var2.exists()) {
               var2.delete();
            }
         }

         this.var_affiche_facture = false;
         this.visibiliteBton = false;
      }

   }

   public void fermerFactureDirecte() {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.visibiliteBton = false;
   }

   public void validerFactureDirecte() throws HibernateException, NamingException {
      if (this.bienTravauxEntete != null && this.bienTravauxEntete.getBietraentId() != 0L) {
         this.bienTravauxEntete = this.bienTravauxEnteteDao.pourParapheur(this.bienTravauxEntete.getBietraentId(), (Session)null);
         if (this.bienTravauxEntete != null) {
            this.bienTravauxLigne.setBienTravauxEntete(this.bienTravauxEntete);
         } else {
            this.bienTravauxLigne.setBienTravauxEntete((BienTravauxEntete)null);
         }
      } else {
         this.bienTravauxLigne.setBienTravauxEntete((BienTravauxEntete)null);
      }

      this.bienTravauxLigne.setBien(this.bien);
      this.bienTravauxLigne.setBietraligIdBien(this.bien.getBieId());
      if (this.bien.getBieType() == 1) {
         this.bienTravauxLigne.setBietraligCodeGroupe(this.bien.getBieGroupe());
      } else if (this.bien.getBieType() == 2) {
         this.bienTravauxLigne.setBietraligCodeGroupe(this.bien.getBieNum());
      } else {
         this.bienTravauxLigne.setBietraligCodeGroupe("");
      }

      if (this.lesPostesItems.size() != 0) {
         for(int var1 = 0; var1 < this.lesPostesItems.size(); ++var1) {
            if (((SelectItem)this.lesPostesItems.get(var1)).getValue().toString().equals(this.bienTravauxLigne.getBietraligPoste())) {
               this.bienTravauxLigne.setBietraligLibellePoste(((SelectItem)this.lesPostesItems.get(var1)).getLabel().toString());
               break;
            }
         }
      }

      if (this.bienTravauxLigne.getBietraligId() == 0L) {
         if (this.bienTravauxLigne.getBietraligDateFacture() == null) {
            this.bienTravauxLigne.setBietraligDateFacture(new Date());
         }

         this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
         String var4 = this.calculChrono.numCompose(this.bienTravauxLigne.getBietraligDateFacture(), 164, (String)null, (Session)null);
         this.bienTravauxLigne.setBietraligNumFacture(var4);
         this.bienTravauxLigne = this.bienTravauxLigneDao.insert(this.bienTravauxLigne);
         this.listDetail.add(this.bienTravauxLigne);
         this.datamodelDetail.setWrappedData(this.listDetail);
      } else {
         this.bienTravauxLigne = this.bienTravauxLigneDao.modif(this.bienTravauxLigne);
      }

      double var5 = 0.0D;
      if (this.listDetail.size() != 0) {
         for(int var3 = 0; var3 < this.listDetail.size(); ++var3) {
            var5 += ((BienTravauxLigne)this.listDetail.get(var3)).getBietraligTtc();
         }
      }

      if (this.bienTravauxEntete != null) {
         this.bienTravauxEntete = this.bienTravauxEnteteDao.pourParapheur(this.bienTravauxEntete.getBietraentId(), (Session)null);
         if (this.bienTravauxEntete != null) {
            this.bienTravauxEntete.setBietraentCoutReel(var5);
            this.bienTravauxEntete = this.bienTravauxEnteteDao.modif(this.bienTravauxEntete);
         }
      }

      this.controleSaisieFournisseurs();
      this.var_action = 0;
      this.var_memo_action = this.var_action;
   }

   public void calculTtc() {
      this.bienTravauxLigne.setBietraligTtc(this.bienTravauxLigne.getBietraligHt() + this.bienTravauxLigne.getBietraligTva());
   }

   public void validerDocDirecte() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.bienTravauxLigne.getBietraligEtat() == 0 && this.usersChrono.getUsrchrValidation() == 2) {
            this.bienTravauxLigne.setBietraligEtat(1);
            this.bienTravauxLigne = this.bienTravauxLigneDao.modif(this.bienTravauxLigne, var1);
            if (this.bienTravauxLigne.getBietraligPoste() != null && !this.bienTravauxLigne.getBietraligPoste().isEmpty() && this.bienTravauxLigne.getBien() != null) {
               new ArrayList();
               ArrayList var4 = new ArrayList();
               new ArrayList();
               List var5 = this.bienBudgetEnteteDao.chargerBudgetByBien(this.bienTravauxLigne.getBien(), 0, var1);
               if (var5.size() != 0) {
                  for(int var6 = 0; var6 < var5.size(); ++var6) {
                     this.bienBudgetEntete = (BienBudgetEntete)var5.get(var6);
                     if (this.bienBudgetEntete.getBiebudentEtat() == 1) {
                        double var7 = 0.0D;
                        double var9 = 0.0D;
                        List var3 = this.bienTravauxLigneDao.chargerDetailByBien(this.bienTravauxLigne.getBien(), this.bienTravauxLigne.getBietraligPoste(), this.bienBudgetEntete.getBiebudentDateDebut(), this.bienBudgetEntete.getBiebudentDateFin(), var1);
                        int var11;
                        if (var3.size() != 0) {
                           for(var11 = 0; var11 < var3.size(); ++var11) {
                              var7 += ((BienTravauxLigne)var3.get(var11)).getBietraligTtc();
                           }
                        }

                        var4.clear();
                        List var19 = this.bienBudgetLigneDao.chargerBudgetByBien(this.bienBudgetEntete, var1);
                        if (var19.size() != 0) {
                           for(var11 = 0; var11 < var19.size(); ++var11) {
                              this.bienBudgetLigne = (BienBudgetLigne)var19.get(var11);
                              if (this.bienBudgetLigne.getBiebudligCode().equals(this.bienTravauxLigne.getBietraligPoste())) {
                                 this.bienBudgetLigne.setBiebudligDepenses(var7);
                                 this.bienBudgetLigne.setBiebudligEcart(this.bienBudgetLigne.getBiebudligMontant() - this.bienBudgetLigne.getBiebudligDepenses() - this.bienBudgetLigne.getBiebudligDepensesNonImpute());
                                 float var12 = (float)this.utilNombre.myRound(this.bienBudgetLigne.getBiebudligDepenses() / this.bienBudgetLigne.getBiebudligMontant() * 100.0D, 2);
                                 this.bienBudgetLigne.setBiebudligRealisation(var12);
                                 this.bienBudgetLigne = this.bienBudgetLigneDao.modif(this.bienBudgetLigne, var1);
                              }

                              var9 += this.bienBudgetLigne.getBiebudligDepenses();
                           }
                        }

                        this.bienBudgetEntete = this.bienBudgetEnteteDao.pourParapheur(this.bienBudgetEntete.getBiebudentId(), var1);
                        if (this.bienBudgetEntete != null) {
                           this.bienBudgetEntete.setBiebudentDepenses(var9);
                           this.bienBudgetEntete.setBiebudentEcart(this.bienBudgetEntete.getBiebudentTotal() - this.bienBudgetEntete.getBiebudentDepenses() - this.bienBudgetEntete.getBiebudentDepensesNonImpute());
                           float var20 = (float)this.utilNombre.myRound(this.bienBudgetEntete.getBiebudentDepenses() / this.bienBudgetEntete.getBiebudentTotal() * 100.0D, 2);
                           this.bienBudgetEntete.setBiebudentRealisation(var20);
                           this.bienBudgetEntete = this.bienBudgetEnteteDao.modif(this.bienBudgetEntete, var1);
                        }
                        break;
                     }
                  }
               }
            }

            Espion var18 = new Espion();
            var18.setUsers(this.usersLog);
            var18.setEsptype(0);
            var18.setEspdtecreat(new Date());
            var18.setEspaction("Validation manuelle facture charge (I.) N° " + this.bienTravauxLigne.getBietraligNumFacture() + " du " + this.utilDate.dateToStringSQLLight(this.bienTravauxLigne.getBietraligDateFacture()));
            this.espionDao.mAJEspion(var18);
         }

         var2.commit();
      } catch (HibernateException var16) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var16;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void devaliderDocDirecte() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.bienTravauxLigne.getBietraligEtat() == 1 && this.usersChrono.getUsrchrValidation() == 2) {
            this.bienTravauxLigne.setBietraligEtat(0);
            this.bienTravauxLigne = this.bienTravauxLigneDao.modif(this.bienTravauxLigne, var1);
            Espion var3 = new Espion();
            var3.setUsers(this.usersLog);
            var3.setEsptype(0);
            var3.setEspdtecreat(new Date());
            var3.setEspaction("Dévalidation manuelle facture charge (I.) N° " + this.bienTravauxLigne.getBietraligNumFacture() + " du " + this.utilDate.dateToStringSQLLight(this.bienTravauxLigne.getBietraligDateFacture()));
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

   public void affichePhotoProduit() throws IOException, SQLException {
      if (this.bienTravauxLigne.getBietraligScanFacture() != null) {
         if (!this.bienTravauxLigne.getBietraligScanFacture().endsWith(".pdf") && !this.bienTravauxLigne.getBietraligScanFacture().endsWith(".PDF")) {
            this.urlphotoProd = "structure" + this.structureLog.getStrid() + "/photos/scanFacture/" + this.bienTravauxLigne.getBietraligScanFacture();
            this.typeFichier = 0;
         } else {
            String var1 = "epegase" + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanFacture" + File.separator;
            this.fichierUrl = this.utilDownload.convertirFichierUtl(var1 + this.bienTravauxLigne.getBietraligScanFacture(), this.urlExplorateur);
            this.fichierMine = this.utilDownload.calculeTypeMine(this.bienTravauxLigne.getBietraligScanFacture());
            this.typeFichier = 1;
         }
      } else {
         this.urlphotoProd = null;
      }

   }

   private static void close(Closeable var0) {
      if (var0 != null) {
         try {
            var0.close();
         } catch (IOException var2) {
            var2.printStackTrace();
         }
      }

   }

   public void ajoutPhoto() throws IOException, JDOMException, HibernateException, NamingException {
      if (this.bienTravauxLigne.getBietraligId() == 0L || this.bienTravauxLigne.getBietraligNumFacture() == null || this.bienTravauxLigne.getBietraligNumFacture().isEmpty()) {
         if (this.bienTravauxEntete != null && this.bienTravauxEntete.getBietraentId() != 0L) {
            this.bienTravauxEntete = this.bienTravauxEnteteDao.pourParapheur(this.bienTravauxEntete.getBietraentId(), (Session)null);
            if (this.bienTravauxEntete != null) {
               this.bienTravauxLigne.setBienTravauxEntete(this.bienTravauxEntete);
            } else {
               this.bienTravauxLigne.setBienTravauxEntete((BienTravauxEntete)null);
            }
         } else {
            this.bienTravauxLigne.setBienTravauxEntete((BienTravauxEntete)null);
         }

         this.bienTravauxLigne.setBien(this.bien);
         if (this.bienTravauxLigne.getBietraligDateFacture() == null) {
            this.bienTravauxLigne.setBietraligDateFacture(new Date());
         }

         this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
         String var1 = this.calculChrono.numCompose(this.bienTravauxLigne.getBietraligDateFacture(), 164, (String)null, (Session)null);
         this.bienTravauxLigne.setBietraligNumFacture(var1);
         this.bienTravauxLigne = this.bienTravauxLigneDao.insert(this.bienTravauxLigne);
         this.listDetail.add(this.bienTravauxLigne);
         this.datamodelDetail.setWrappedData(this.listDetail);
      }

      if (this.bienTravauxLigne.getBietraligNumFacture() != null && !this.bienTravauxLigne.getBietraligNumFacture().isEmpty()) {
         FacesContext var6 = FacesContext.getCurrentInstance();

         try {
            if (this.uploadedFile != null) {
               String var2;
               if (this.bienTravauxLigne.getBietraligScanFacture() != null && !this.bienTravauxLigne.getBietraligScanFacture().isEmpty()) {
                  var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanFacture") + File.separator + this.bienTravauxLigne.getBietraligScanFacture();
                  File var3 = new File(var2);
                  if (var3.exists()) {
                     var3.delete();
                  }
               }

               var2 = this.utilDownload.trimFilePath(this.uploadedFile.getName().trim());
               String var7 = var2.substring(var2.indexOf(".") + 1);
               var2 = this.bienTravauxLigne.getBietraligId() + "_" + this.bienTravauxLigne.getBietraligNumFacture() + "." + var7;
               File var4 = this.utilDownload.uniqueFile(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanFacture" + File.separator), var2);
               this.utilDownload.write(var4, this.uploadedFile.getInputStream());
               this.fileName = var2;
               var6.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "File upload succeed!", (String)null));
               this.bienTravauxLigne.setBietraligScanFacture(var2);
               this.urlphotoProd = "structure" + this.structureLog.getStrid() + "/photos/scanFacture/" + this.bienTravauxLigne.getBietraligScanFacture();
            }
         } catch (IOException var5) {
            this.bienTravauxLigne.setBietraligScanFacture(this.fileName);
            var6.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File upload failed with I/O error.", (String)null));
            var5.printStackTrace();
         }
      }

   }

   public void reInitPhoto() throws HibernateException, NamingException, IOException, SQLException {
      String var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanFacture") + File.separator + this.bienTravauxLigne.getBietraligScanFacture();
      File var2 = new File(var1);
      if (var2.exists()) {
         var2.delete();
      }

      this.affichePhotoProduit();
      this.bienTravauxLigne.setBietraligScanFacture((String)null);
      this.bienTravauxLigneDao.modif(this.bienTravauxLigne);
   }

   public void afficherScan() throws HibernateException, NamingException, IOException, SQLException {
      if (this.datamodelDetail.isRowAvailable()) {
         this.bienTravauxLigne = (BienTravauxLigne)this.datamodelDetail.getRowData();
         this.affichePhotoProduit();
      }

      if (this.bienTravauxLigne != null && this.bienTravauxLigne.getBietraligScanFacture() != null && !this.bienTravauxLigne.getBietraligScanFacture().isEmpty()) {
         this.showModalPanelScan = true;
      }

   }

   public void fermerScan() {
      this.showModalPanelScan = false;
   }

   public void rechercheTiers() throws JDOMException, IOException, HibernateException, NamingException {
      this.tiers = this.formRecherche.rechercheTiers(0, this.bienTravauxLigne.getBietraligNomTiers(), this.nature);
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
         String var1 = "";
         if (!this.tiers.getTiegenre().equalsIgnoreCase("010") && !this.tiers.getTiegenre().equalsIgnoreCase("020") && !this.tiers.getTiegenre().equalsIgnoreCase("030") && !this.tiers.getTiegenre().equalsIgnoreCase("037") && !this.tiers.getTiegenre().equalsIgnoreCase("070") && !this.tiers.getTiegenre().equalsIgnoreCase("080")) {
            var1 = this.tiers.getTieraisonsocialenom();
            this.bienTravauxLigne.setBietraligCivilTiers("");
            this.bienTravauxLigne.setBietraligTypeTiers(0);
         } else {
            var1 = this.tiers.getTieraisonsocialenom() + " " + this.tiers.getTieprenom();
            this.bienTravauxLigne.setBietraligCivilTiers(this.tiers.getTiecivilite());
            this.bienTravauxLigne.setBietraligTypeTiers(1);
         }

         this.bienTravauxLigne.setBietraligNomTiers(var1);
      } else {
         this.annuleTiers();
      }

      this.controleSaisieTiers();
      this.var_action = this.var_memo_action;
   }

   public void annuleTiers() {
      this.tiers = new Tiers();
      this.bienTravauxLigne.setBietraligNomTiers("");
      this.bienTravauxLigne.setBietraligCivilTiers("");
      this.controleSaisieTiers();
      this.var_action = this.var_memo_action;
   }

   public void controleSaisieTiers() {
      if (this.bienTravauxLigne != null && this.bienTravauxLigne.getBietraligNomTiers() != null && !this.bienTravauxLigne.getBietraligNomTiers().isEmpty() && this.tiers != null && this.tiers.getTieid() != 0L) {
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
      this.var_aff_detail_fournisseur = false;
   }

   public void rechercheFournisseurs() throws JDOMException, IOException, HibernateException, NamingException {
      this.fournisseur = this.formRecherche.rechercheTiers(0, this.bienTravauxLigne.getBietraligNomTiers(), this.nature);
      if (this.fournisseur != null) {
         if (this.fournisseur.getTieid() != 0L) {
            this.calculeFournisseurs();
         } else {
            this.var_action = 15;
         }
      } else if (this.fournisseur == null) {
         this.calculeFournisseurs();
      }

   }

   public void recuperationFournisseurs() throws JDOMException, IOException, HibernateException, NamingException {
      this.fournisseur = this.formRecherche.calculeTiers();
      this.calculeFournisseurs();
   }

   public void calculeFournisseurs() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.fournisseur != null) {
         String var1 = "";
         if (!this.fournisseur.getTiegenre().equalsIgnoreCase("010") && !this.fournisseur.getTiegenre().equalsIgnoreCase("020") && !this.fournisseur.getTiegenre().equalsIgnoreCase("030") && !this.fournisseur.getTiegenre().equalsIgnoreCase("037") && !this.fournisseur.getTiegenre().equalsIgnoreCase("070") && !this.fournisseur.getTiegenre().equalsIgnoreCase("080")) {
            var1 = this.fournisseur.getTieraisonsocialenom();
            this.bienTravauxLigne.setBietraligCivilTiers("");
            this.bienTravauxLigne.setBietraligTypeTiers(0);
         } else {
            var1 = this.fournisseur.getTieraisonsocialenom() + " " + this.fournisseur.getTieprenom();
            this.bienTravauxLigne.setBietraligCivilTiers(this.fournisseur.getTiecivilite());
            this.bienTravauxLigne.setBietraligTypeTiers(1);
         }

         this.bienTravauxLigne.setBietraligNomTiers(var1);
      } else {
         this.annuleFournisseurs();
      }

      this.controleSaisieFournisseurs();
      this.var_action = this.var_memo_action;
   }

   public void annuleFournisseurs() {
      this.fournisseur = new Tiers();
      this.bienTravauxLigne.setBietraligNomTiers("");
      this.bienTravauxLigne.setBietraligCivilTiers("");
      this.controleSaisieFournisseurs();
      this.var_action = this.var_memo_action;
   }

   public void controleSaisieFournisseurs() {
      if (this.bienTravauxLigne != null && this.bienTravauxLigne.getBietraligNomTiers() != null && !this.bienTravauxLigne.getBietraligNomTiers().isEmpty() && this.fournisseur != null && this.fournisseur.getTieid() != 0L) {
         this.var_valide_doc = true;
         this.var_aff_detail_fournisseur = true;
      } else {
         this.var_valide_doc = false;
         this.var_aff_detail_fournisseur = false;
      }

   }

   public void detailFournisseurs() {
      this.formRecherche.setNature(this.nature);
      this.var_action = 16;
   }

   public void annuleDetailFournisseurs() {
      this.var_action = this.var_memo_action;
   }

   public void modifFournisseurs() {
      this.var_aff_detail_fournisseur = false;
   }

   public void rechercheBiens() throws JDOMException, IOException, HibernateException, NamingException {
      this.bien = this.formRecherche.rechercheBiens(this.bienTravauxEntete.getBietraentCodeBien(), this.nature, this.categorie);
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

   public void rechercheBiensDirect() throws JDOMException, IOException, HibernateException, NamingException {
      this.bien = this.formRecherche.rechercheBiens(this.referenceBien, this.nature, this.categorie);
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
         this.referenceBien = this.bien.getBieNum() + ":" + this.bien.getBieNom();
         if (this.bienTravauxEntete != null) {
            this.bienTravauxEntete.setBien(this.bien);
            this.bienTravauxEntete.setBietraentCodeBien(this.bien.getBieNum());
         }

         this.chargerPosteBudgetGroupe((Session)null);
         this.chargerBlocs();
      } else {
         this.annuleBiens();
      }

      this.controleSaisieBiens();
      this.var_action = this.var_memo_action;
   }

   public void annuleBiens() {
      this.bien = null;
      this.referenceBien = "";
      if (this.bienTravauxEntete != null) {
         this.bienTravauxEntete.setBien((Bien)null);
         this.bienTravauxEntete.setBietraentCodeBien("");
      }

      this.lesBlocsItems.clear();
      this.controleSaisieBiens();
      this.var_action = this.var_memo_action;
      this.lesPostesItems.clear();
   }

   public void controleSaisieBiens() {
      if (this.bienTravauxEntete != null && this.bienTravauxEntete.getBietraentCodeBien() != null && !this.bienTravauxEntete.getBietraentCodeBien().isEmpty() && this.bien.getBieId() != 0L) {
         this.var_valide_doc = true;
         this.var_aff_detail_bien = true;
         this.var_aff_detail_tiers = true;
      } else {
         this.var_valide_doc = false;
         this.var_aff_detail_bien = false;
         this.var_aff_detail_tiers = false;
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
      this.var_aff_detail_bien = false;
   }

   public void rechercheTravauxDirect() throws JDOMException, IOException, HibernateException, NamingException {
      this.bienTravauxEntete = this.formRecherche.rechercheTravauxImmobilier(this.referenceOt, this.nature, this.categorie);
      if (this.bienTravauxEntete != null) {
         if (this.bienTravauxEntete.getBietraentId() != 0L) {
            this.calculeTravaux();
         } else {
            this.var_action = 19;
         }
      } else if (this.bienTravauxEntete == null) {
         this.calculeTravaux();
      }

   }

   public void recuperationTravaux() throws JDOMException, IOException, HibernateException, NamingException {
      this.bienTravauxEntete = this.formRecherche.calculeTravauxImmobilier();
      this.calculeTravaux();
   }

   public void calculeTravaux() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.bienTravauxEntete != null) {
         this.bien = this.bienTravauxEntete.getBien();
         this.referenceOt = this.bienTravauxEntete.getBietraentNum() + ":" + this.utilDate.dateToStringFr(this.bienTravauxEntete.getBietraentDateDebut());
         this.referenceBien = this.bien.getBieNum() + ":" + this.bien.getBieNom();
         this.chargerPosteBudgetGroupe((Session)null);
      } else {
         this.annuleTravaux();
      }

      this.controleSaisieTravaux();
      this.var_action = this.var_memo_action;
   }

   public void annuleTravaux() {
      this.bienTravauxEntete = null;
      this.referenceOt = "";
      this.bien = null;
      this.referenceBien = "";
      this.referenceBien = "";
      this.controleSaisieTravaux();
      this.var_action = this.var_memo_action;
      this.lesPostesItems.clear();
   }

   public void controleSaisieTravaux() {
      if (this.bienTravauxEntete != null && this.bienTravauxEntete.getBietraentCodeBien() != null && !this.bienTravauxEntete.getBietraentCodeBien().isEmpty() && this.bien.getBieId() != 0L) {
         this.var_valide_doc = true;
         this.var_aff_detail_bien = true;
      } else {
         this.var_valide_doc = false;
         this.var_aff_detail_bien = false;
      }

   }

   public void detailTravaux() {
      this.formRecherche.setNature(this.nature);
      this.var_action = 19;
   }

   public void annuleDetailTravaux() {
      this.var_action = this.var_memo_action;
   }

   public void modifTravaux() {
      this.var_aff_detail_bien = false;
   }

   public void planningDocument() {
      this.var_action = 19;
      this.var_memo_action = this.var_action;
      this.listRdvMois = new ArrayList();
      this.listRdvSemaine = new ArrayList();
      this.listRdvJour = new ArrayList();
      this.listRdv = new ArrayList();
      this.datamodelRdv = new ListDataModel();
      this.datamodelLesRdvParJour = new ListDataModel();
      this.datamodelLesRdvParSemaine = new ListDataModel();
      this.datamodelLesRdvParMois = new ListDataModel();
      this.showModalPanelPlanning = false;
      this.showModalPanelRdv = false;
      this.showModalPanelTiers = false;
      this.parMois = new Date();
      this.parSemaine = new Date();
      this.parJour = new Date();
      this.modeRdv = 0;
      this.planningImpressionsItems = new ArrayList();
      this.showModalPanelPrintPlanning = false;
      this.rdv = new Rdv();
      this.rdvDao = new RdvDao(this.baseLog, this.utilInitHibernate);
   }

   public void annule() throws IOException, JDOMException {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.setVisibiliteBton(false);
      this.visibiliteBton = false;
   }

   public void chargerLesDoc(Date var1, Date var2, int var3, int var4) throws HibernateException, NamingException, ParseException {
      Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "CommandesVentesPlanning");
      this.listRdv = this.bienTravauxEnteteDao.selectRdv(var1, var2, var3, var4, var5);
      new ArrayList();
      List var6 = this.rdvDao.selectRdv(var1, var2, var4, var5);
      if (var6.size() != 0) {
         for(int var7 = 0; var7 < var6.size(); ++var7) {
            this.bienTravauxEntete = new BienTravauxEntete();
            this.bienTravauxEntete.setBietraentIdEquipe(((Rdv)var6.get(var7)).getRdvId());
            this.bienTravauxEntete.setBietraentDateDebut(((Rdv)var6.get(var7)).getRdvDteDe());
            this.bienTravauxEntete.setBietraentDateLivraison(((Rdv)var6.get(var7)).getRdvDteDe());
            this.bienTravauxEntete.setBietraentObjet(((Rdv)var6.get(var7)).getRdvSujet());
            this.bienTravauxEntete.setBietraentDescriptif(((Rdv)var6.get(var7)).getRdvDescript());
            this.bienTravauxEntete.setBietraentEtatLivraison(((Rdv)var6.get(var7)).getRdvEtat());
            this.bienTravauxEntete.setBietraentNum("");
            this.bienTravauxEntete.setBietraentHoraireLivraison(0);
            this.bienTravauxEntete.setHeure("");
            this.bienTravauxEntete.setMinute("");
            boolean var8 = false;
            int var9;
            if (this.rdv.getRdvLieu() != null && !this.rdv.getRdvLieu().isEmpty()) {
               var9 = Integer.parseInt(this.rdv.getRdvLieu());
            } else {
               var9 = 0;
            }

            this.bienTravauxEntete.setBietraentModeLivraison(var9);
            this.listRdv.add(this.bienTravauxEntete);
         }
      }

      this.utilInitHibernate.closeSession();
   }

   public void modeMois() {
      this.modeRdv = 0;
   }

   public void modeSemaine() {
      this.modeRdv = 1;
   }

   public void modeJour() {
      this.modeRdv = 2;
   }

   public void modeListe() {
      this.modeRdv = 3;
   }

   public void chargerLesRdv() throws HibernateException, NamingException, ParseException {
      this.listRdvMois.clear();
      this.listRdvSemaine.clear();
      this.listRdvJour.clear();
      if (this.jourDeb != null && this.jourFin != null) {
         this.chargerLesDoc(this.jourDeb, this.jourFin, this.valNatListe, this.valStatutListe);
      }

      this.datamodelRdv.setWrappedData(this.listRdv);
   }

   public void chargerLesRdvByJourPrecedent() throws HibernateException, NamingException, ParseException {
      if (this.parJour == null) {
         this.parJour = new Date();
      }

      Date var1 = this.parJour;
      this.parJour = this.utilDate.dateJourPrecedent(var1);
      this.chargerLesRdvByJour();
   }

   public void chargerLesRdvByJourSuivant() throws HibernateException, NamingException, ParseException {
      if (this.parJour == null) {
         this.parJour = new Date();
      }

      Date var1 = this.parJour;
      this.parJour = this.utilDate.dateJourSuivant(var1);
      this.chargerLesRdvByJour();
   }

   public void chargerLesRdvByJour() throws HibernateException, NamingException, ParseException {
      if (this.parJour != null) {
         this.listRdv.clear();
         this.chargerLesDoc(this.parJour, this.parJour, this.valNatJour, this.valStatutJour);
         this.listRdvJour.clear();
         if (this.structureLog.getStrHrDeb() == null || this.structureLog.getStrHrDeb().isEmpty()) {
            this.structureLog.setStrHrDeb("00");
         }

         int var1 = Integer.parseInt(this.structureLog.getStrHrDeb());
         if (var1 == 0) {
            var1 = 8;
         }

         if (this.structureLog.getStrHrFin() == null || this.structureLog.getStrHrFin().isEmpty()) {
            this.structureLog.setStrHrFin("00");
         }

         int var2 = Integer.parseInt(this.structureLog.getStrHrFin());
         if (var2 == 0) {
            var2 = 19;
         }

         if (this.structureLog.getStrHrPas() == null || this.structureLog.getStrHrPas().isEmpty()) {
            this.structureLog.setStrHrPas("00");
         }

         int var3 = Integer.parseInt(this.structureLog.getStrHrPas());
         int var4 = var1 * 60;
         int var5 = var2 * 60;
         int var6 = var3 * 60;

         int var7;
         for(var7 = var4; var7 < var5; var7 += var6) {
            String var8 = "";
            if (Math.abs(var7 / 60) < 10) {
               var8 = "0" + Math.abs(var7 / 60);
            } else {
               var8 = "" + Math.abs(var7 / 60);
            }

            boolean var9 = false;

            for(int var10 = 0; var10 < this.listRdv.size(); ++var10) {
               this.bienTravauxEntete = (BienTravauxEntete)this.listRdv.get(var10);
               if (this.bienTravauxEntete.getBietraentHoraireLivraison() == 3) {
                  this.bienTravauxEntete.setHeure(this.bienTravauxEntete.getBietraentHeureLivraison());
                  this.bienTravauxEntete.setMinute("00");
                  if (this.bienTravauxEntete.getBietraentHeureLivraison().equalsIgnoreCase(var8)) {
                     this.listRdvJour.add(this.bienTravauxEntete);
                     var9 = true;
                  }
               }
            }

            if (!var9) {
               this.bienTravauxEntete = new BienTravauxEntete();
               this.bienTravauxEntete.setHeure(var8);
               this.bienTravauxEntete.setMinute("00");
               this.bienTravauxEntete.setBietraentHeureLivraison(var8);
               this.bienTravauxEntete.setBietraentHoraireLivraison(3);
               this.listRdvJour.add(this.bienTravauxEntete);
            }
         }

         for(var7 = 0; var7 < this.listRdv.size(); ++var7) {
            this.bienTravauxEntete = (BienTravauxEntete)this.listRdv.get(var7);
            if (this.bienTravauxEntete.getBietraentHoraireLivraison() == 0) {
               this.bienTravauxEntete.setHeure("00");
               this.bienTravauxEntete.setMinute("00");
            } else if (this.bienTravauxEntete.getBietraentHoraireLivraison() == 1) {
               this.bienTravauxEntete.setHeure("AM");
               this.bienTravauxEntete.setMinute("");
            } else if (this.bienTravauxEntete.getBietraentHoraireLivraison() == 2) {
               this.bienTravauxEntete.setHeure("PM");
               this.bienTravauxEntete.setMinute("");
            }

            if (this.bienTravauxEntete.getBietraentHoraireLivraison() == 0 || this.bienTravauxEntete.getBietraentHoraireLivraison() == 1 || this.bienTravauxEntete.getBietraentHoraireLivraison() == 2) {
               this.listRdvJour.add(this.bienTravauxEntete);
            }
         }

         this.datamodelLesRdvParJour.setWrappedData(this.listRdvJour);
      }

   }

   public void chargerLesRdvBySemaine() throws HibernateException, NamingException, ParseException {
      this.chargerLesRdvBySemaine((Session)null);
   }

   public void chargerLesRdvBySemainePrecedent() throws HibernateException, NamingException, ParseException {
      if (this.dateLun == null || this.dateLun.isEmpty()) {
         this.dateLun = this.utilDate.dateToStringFrLg(new Date());
      }

      this.parSemaine = this.utilDate.dateJourPrecedent(this.calculeDate(this.dateLun));
      this.chargerLesRdvBySemaine((Session)null);
   }

   public void chargerLesRdvBySemaineSuivant() throws HibernateException, NamingException, ParseException {
      if (this.dateDim == null || this.dateDim.isEmpty()) {
         this.dateDim = this.utilDate.dateToStringFrLg(new Date());
      }

      this.parSemaine = this.utilDate.dateJourSuivant(this.calculeDate(this.dateDim));
      this.chargerLesRdvBySemaine((Session)null);
   }

   public void chargerLesRdvBySemaine(Session var1) throws HibernateException, NamingException, ParseException {
      if (this.parSemaine != null) {
         Date var2 = null;
         Date var3 = null;
         Calendar var4 = Calendar.getInstance();
         var4.setTime(this.parSemaine);
         String var5 = "" + var4.getTime();
         if (var5.contains("Mon")) {
            var2 = var4.getTime();
            var4.add(7, 6);
            var3 = var4.getTime();
         } else if (var5.contains("Tue")) {
            var4.add(7, -1);
            var2 = var4.getTime();
            var4.add(7, 6);
            var3 = var4.getTime();
         } else if (var5.contains("Wed")) {
            var4.add(7, -2);
            var2 = var4.getTime();
            var4.add(7, 6);
            var3 = var4.getTime();
         } else if (var5.contains("Thu")) {
            var4.add(7, -3);
            var2 = var4.getTime();
            var4.add(7, 6);
            var3 = var4.getTime();
         } else if (var5.contains("Fri")) {
            var4.add(7, -4);
            var2 = var4.getTime();
            var4.add(7, 6);
            var3 = var4.getTime();
         } else if (var5.contains("Sat")) {
            var4.add(7, -5);
            var2 = var4.getTime();
            var4.add(7, 6);
            var3 = var4.getTime();
         } else if (var5.contains("Sun")) {
            var4.add(7, -6);
            var2 = var4.getTime();
            var4.add(7, 6);
            var3 = var4.getTime();
         }

         Calendar var6 = Calendar.getInstance();
         var6.setTime(var2);
         SimpleDateFormat var7 = new SimpleDateFormat("dd/MM/yy", Locale.FRANCE);
         this.dateLun = var7.format(var2);
         var6.add(7, 1);
         this.dateMar = var7.format(var6.getTime());
         var6.add(7, 1);
         this.dateMer = var7.format(var6.getTime());
         var6.add(7, 1);
         this.dateJeu = var7.format(var6.getTime());
         var6.add(7, 1);
         this.dateVen = var7.format(var6.getTime());
         var6.add(7, 1);
         this.dateSam = var7.format(var6.getTime());
         this.dateDim = var7.format(var3);
         this.jourDeb = var2;
         this.jourFin = var3;
         this.listRdv.clear();
         this.chargerLesDoc(this.jourDeb, this.jourFin, this.valNatSemaine, this.valStatutSemaine);
         this.listRdvSemaine.clear();
         if (this.structureLog.getStrHrDeb() == null || this.structureLog.getStrHrDeb().isEmpty()) {
            this.structureLog.setStrHrDeb("00");
         }

         int var8 = Integer.parseInt(this.structureLog.getStrHrDeb());
         if (var8 == 0) {
            var8 = 8;
         }

         if (this.structureLog.getStrHrFin() == null || this.structureLog.getStrHrFin().isEmpty()) {
            this.structureLog.setStrHrFin("00");
         }

         int var9 = Integer.parseInt(this.structureLog.getStrHrFin());
         if (var9 == 0) {
            var9 = 19;
         }

         if (this.structureLog.getStrHrPas() == null || this.structureLog.getStrHrPas().isEmpty()) {
            this.structureLog.setStrHrPas("00");
         }

         int var10 = Integer.parseInt(this.structureLog.getStrHrPas());
         if (this.structureLog.getStrMnPas() == null || this.structureLog.getStrMnPas().isEmpty()) {
            this.structureLog.setStrMnPas("00");
         }

         int var11 = var8 * 60;
         int var12 = var9 * 60;
         int var13 = var10 * 60;

         for(int var14 = var11; var14 < var12; var14 += var13) {
            String var15 = "";
            if (Math.abs(var14 / 60) < 10) {
               var15 = "0" + Math.abs(var14 / 60);
            } else {
               var15 = "" + Math.abs(var14 / 60);
            }

            boolean var16 = false;
            RdvSemaine var17 = new RdvSemaine();

            for(int var18 = 0; var18 < this.listRdv.size(); ++var18) {
               this.bienTravauxEntete = (BienTravauxEntete)this.listRdv.get(var18);
               if (this.bienTravauxEntete.getBietraentHoraireLivraison() == 3) {
                  this.bienTravauxEntete.setHeure(this.bienTravauxEntete.getBietraentHeureLivraison());
                  SimpleDateFormat var19 = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);
                  var19.format(this.bienTravauxEntete.getBietraentDateLivraison());
                  Calendar var21 = Calendar.getInstance();
                  var21.setTime(this.bienTravauxEntete.getBietraentDateLivraison());
                  String var22 = "" + var21.getTime();
                  var17.setHeure(this.bienTravauxEntete.getHeure());
                  if (this.bienTravauxEntete.getBietraentHeureLivraison().equalsIgnoreCase(var15)) {
                     if (var22.contains("Mon")) {
                        var17.setLundi(this.bienTravauxEntete.getVar_nom_tiers() + "\n" + this.bienTravauxEntete.getBietraentObjet() + "\n" + this.bienTravauxEntete.getBietraentNum());
                        var17.setRdvUsrLundi(this.bienTravauxEntete.getBien().getBieId());
                        var17.setRdvIdLundi(this.bienTravauxEntete.getBietraentId());
                        var17.setRdvEtatLundi(this.bienTravauxEntete.getBietraentPhase());
                        var17.setRdvErreurLundi(false);
                        var17.setRdvNature(this.bienTravauxEntete.getBietraentModeLivraison());
                     } else if (var22.contains("Tue")) {
                        var17.setMardi(this.bienTravauxEntete.getVar_nom_tiers() + "\n" + this.bienTravauxEntete.getBietraentObjet() + "\n" + this.bienTravauxEntete.getBietraentNum());
                        var17.setRdvUsrMardi(this.bienTravauxEntete.getBien().getBieId());
                        var17.setRdvIdMardi(this.bienTravauxEntete.getBietraentId());
                        var17.setRdvEtatMardi(this.bienTravauxEntete.getBietraentPhase());
                        var17.setRdvErreurMardi(false);
                        var17.setRdvNature(this.bienTravauxEntete.getBietraentModeLivraison());
                     } else if (var22.contains("Wed")) {
                        var17.setMercredi(this.bienTravauxEntete.getVar_nom_tiers() + "\n" + this.bienTravauxEntete.getBietraentObjet() + "\n" + this.bienTravauxEntete.getBietraentNum());
                        var17.setRdvUsrMercredi(this.bienTravauxEntete.getBien().getBieId());
                        var17.setRdvIdMercredi(this.bienTravauxEntete.getBietraentId());
                        var17.setRdvEtatMercredi(this.bienTravauxEntete.getBietraentPhase());
                        var17.setRdvErreurMercredi(false);
                        var17.setRdvNature(this.bienTravauxEntete.getBietraentModeLivraison());
                     } else if (var22.contains("Thu")) {
                        var17.setJeudi(this.bienTravauxEntete.getVar_nom_tiers() + "\n" + this.bienTravauxEntete.getBietraentObjet() + "\n" + this.bienTravauxEntete.getBietraentNum());
                        var17.setRdvUsrJeudi(this.bienTravauxEntete.getBien().getBieId());
                        var17.setRdvIdJeudi(this.bienTravauxEntete.getBietraentId());
                        var17.setRdvEtatJeudi(this.bienTravauxEntete.getBietraentPhase());
                        var17.setRdvErreurJeudi(false);
                        var17.setRdvNature(this.bienTravauxEntete.getBietraentModeLivraison());
                     } else if (var22.contains("Fri")) {
                        var17.setVendredi(this.bienTravauxEntete.getVar_nom_tiers() + "\n" + this.bienTravauxEntete.getBietraentObjet() + "\n" + this.bienTravauxEntete.getBietraentNum());
                        var17.setRdvUsrVendredi(this.bienTravauxEntete.getBien().getBieId());
                        var17.setRdvIdVendredi(this.bienTravauxEntete.getBietraentId());
                        var17.setRdvEtatVendredi(this.bienTravauxEntete.getBietraentPhase());
                        var17.setRdvErreurVendredi(false);
                        var17.setRdvNature(this.bienTravauxEntete.getBietraentModeLivraison());
                     } else if (var22.contains("Sat")) {
                        var17.setSamedi(this.bienTravauxEntete.getVar_nom_tiers() + "\n" + this.bienTravauxEntete.getBietraentObjet() + "\n" + this.bienTravauxEntete.getBietraentNum());
                        var17.setRdvUsrSamedi(this.bienTravauxEntete.getBien().getBieId());
                        var17.setRdvIdSamedi(this.bienTravauxEntete.getBietraentId());
                        var17.setRdvEtatSamedi(this.bienTravauxEntete.getBietraentPhase());
                        var17.setRdvErreurSamedi(false);
                        var17.setRdvNature(this.bienTravauxEntete.getBietraentModeLivraison());
                     } else if (var22.contains("Sun")) {
                        var17.setDimanche(this.bienTravauxEntete.getVar_nom_tiers() + "\n" + this.bienTravauxEntete.getBietraentObjet() + "\n" + this.bienTravauxEntete.getBietraentNum());
                        var17.setRdvUsrDimanche(this.bienTravauxEntete.getBien().getBieId());
                        var17.setRdvIdDimanche(this.bienTravauxEntete.getBietraentId());
                        var17.setRdvEtatDimanche(this.bienTravauxEntete.getBietraentPhase());
                        var17.setRdvErreurDimanche(false);
                        var17.setRdvNature(this.bienTravauxEntete.getBietraentModeLivraison());
                     }

                     var16 = true;
                  }
               }
            }

            if (!var16) {
               var17 = new RdvSemaine();
               var17.setHeure(var15);
            }

            this.listRdvSemaine.add(var17);
         }

         RdvSemaine var23 = new RdvSemaine();

         for(int var24 = 0; var24 < this.listRdv.size(); ++var24) {
            this.bienTravauxEntete = (BienTravauxEntete)this.listRdv.get(var24);
            if (this.bienTravauxEntete.getBietraentHoraireLivraison() == 0) {
               this.bienTravauxEntete.setHeure("??");
            } else if (this.bienTravauxEntete.getBietraentHoraireLivraison() == 1) {
               this.bienTravauxEntete.setHeure("AM");
            } else if (this.bienTravauxEntete.getBietraentHoraireLivraison() == 2) {
               this.bienTravauxEntete.setHeure("PM");
            }

            SimpleDateFormat var25 = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);
            var25.format(this.bienTravauxEntete.getBietraentDateLivraison());
            Calendar var26 = Calendar.getInstance();
            var26.setTime(this.bienTravauxEntete.getBietraentDateLivraison());
            String var27 = "" + var26.getTime();
            var23.setHeure(this.bienTravauxEntete.getHeure());
            if (this.bienTravauxEntete.getBietraentHoraireLivraison() == 0 || this.bienTravauxEntete.getBietraentHoraireLivraison() == 1 || this.bienTravauxEntete.getBietraentHoraireLivraison() == 2) {
               var23 = new RdvSemaine();
               if (var27.contains("Mon")) {
                  var23.setLundi(this.bienTravauxEntete.getVar_nom_tiers() + "\n" + this.bienTravauxEntete.getBietraentObjet() + "\n" + this.bienTravauxEntete.getBietraentNum());
                  var23.setRdvUsrLundi(this.bienTravauxEntete.getBien().getBieId());
                  var23.setRdvIdLundi(this.bienTravauxEntete.getBietraentId());
                  var23.setRdvEtatLundi(this.bienTravauxEntete.getBietraentPhase());
                  var23.setRdvErreurLundi(false);
                  var23.setRdvNature(this.bienTravauxEntete.getBietraentModeLivraison());
               } else if (var27.contains("Tue")) {
                  var23.setMardi(this.bienTravauxEntete.getVar_nom_tiers() + "\n" + this.bienTravauxEntete.getBietraentObjet() + "\n" + this.bienTravauxEntete.getBietraentNum());
                  var23.setRdvUsrMardi(this.bienTravauxEntete.getBien().getBieId());
                  var23.setRdvIdMardi(this.bienTravauxEntete.getBietraentId());
                  var23.setRdvEtatMardi(this.bienTravauxEntete.getBietraentPhase());
                  var23.setRdvErreurMardi(false);
                  var23.setRdvNature(this.bienTravauxEntete.getBietraentModeLivraison());
               } else if (var27.contains("Wed")) {
                  var23.setMercredi(this.bienTravauxEntete.getVar_nom_tiers() + "\n" + this.bienTravauxEntete.getBietraentObjet() + "\n" + this.bienTravauxEntete.getBietraentNum());
                  var23.setRdvUsrMercredi(this.bienTravauxEntete.getBien().getBieId());
                  var23.setRdvIdMercredi(this.bienTravauxEntete.getBietraentId());
                  var23.setRdvEtatMercredi(this.bienTravauxEntete.getBietraentPhase());
                  var23.setRdvErreurMercredi(false);
                  var23.setRdvNature(this.bienTravauxEntete.getBietraentModeLivraison());
               } else if (var27.contains("Thu")) {
                  var23.setJeudi(this.bienTravauxEntete.getVar_nom_tiers() + "\n" + this.bienTravauxEntete.getBietraentObjet() + "\n" + this.bienTravauxEntete.getBietraentNum());
                  var23.setRdvUsrJeudi(this.bienTravauxEntete.getBien().getBieId());
                  var23.setRdvIdJeudi(this.bienTravauxEntete.getBietraentId());
                  var23.setRdvEtatJeudi(this.bienTravauxEntete.getBietraentPhase());
                  var23.setRdvErreurJeudi(false);
                  var23.setRdvNature(this.bienTravauxEntete.getBietraentModeLivraison());
               } else if (var27.contains("Fri")) {
                  var23.setVendredi(this.bienTravauxEntete.getVar_nom_tiers() + "\n" + this.bienTravauxEntete.getBietraentObjet() + "\n" + this.bienTravauxEntete.getBietraentNum());
                  var23.setRdvUsrVendredi(this.bienTravauxEntete.getBien().getBieId());
                  var23.setRdvIdVendredi(this.bienTravauxEntete.getBietraentId());
                  var23.setRdvEtatVendredi(this.bienTravauxEntete.getBietraentPhase());
                  var23.setRdvErreurVendredi(false);
                  var23.setRdvNature(this.bienTravauxEntete.getBietraentModeLivraison());
               } else if (var27.contains("Sat")) {
                  var23.setSamedi(this.bienTravauxEntete.getVar_nom_tiers() + "\n" + this.bienTravauxEntete.getBietraentObjet() + "\n" + this.bienTravauxEntete.getBietraentNum());
                  var23.setRdvUsrSamedi(this.bienTravauxEntete.getBien().getBieId());
                  var23.setRdvIdSamedi(this.bienTravauxEntete.getBietraentId());
                  var23.setRdvEtatSamedi(this.bienTravauxEntete.getBietraentPhase());
                  var23.setRdvErreurSamedi(false);
                  var23.setRdvNature(this.bienTravauxEntete.getBietraentModeLivraison());
               } else if (var27.contains("Sun")) {
                  var23.setDimanche(this.bienTravauxEntete.getVar_nom_tiers() + "\n" + this.bienTravauxEntete.getBietraentObjet() + "\n" + this.bienTravauxEntete.getBietraentNum());
                  var23.setRdvUsrDimanche(this.bienTravauxEntete.getBien().getBieId());
                  var23.setRdvIdDimanche(this.bienTravauxEntete.getBietraentId());
                  var23.setRdvEtatDimanche(this.bienTravauxEntete.getBietraentPhase());
                  var23.setRdvErreurDimanche(false);
                  var23.setRdvNature(this.bienTravauxEntete.getBietraentModeLivraison());
               }

               this.listRdvSemaine.add(var23);
            }
         }

         this.datamodelLesRdvParSemaine.setWrappedData(this.listRdvSemaine);
      }

   }

   public Date calculeDate(String var1) throws ParseException {
      String[] var2 = var1.split("/");
      int var3 = 2000 + Integer.parseInt(var2[2]);
      Date var4 = this.utilDate.stringToDateSQLLight(var3 + "-" + var2[1] + "-" + var2[0]);
      return var4;
   }

   public void chargerLesRdvByMois() throws HibernateException, NamingException, ParseException {
      this.chargerLesRdvByMois((Session)null);
   }

   public void chargerLesRdvByMoisPrecedent() throws HibernateException, NamingException, ParseException {
      if (this.parMois == null) {
         this.parMois = new Date();
      }

      Date var1 = this.parMois;
      this.parMois = this.utilDate.dateMoisPrecedent(var1);
      this.chargerLesRdvByMois((Session)null);
   }

   public void chargerLesRdvByMoisSuivant() throws HibernateException, NamingException, ParseException {
      if (this.parMois == null) {
         this.parMois = new Date();
      }

      Date var1 = this.parMois;
      this.parMois = this.utilDate.dateMoisSuivant(var1);
      this.chargerLesRdvByMois((Session)null);
   }

   public void chargerLesRdvByMois(Session var1) throws HibernateException, NamingException, ParseException {
      if (this.parMois != null) {
         Date var2 = this.utilDate.dateToSQLLight(this.utilDate.datedevaleurTheo(new Date(), -7));
         Date var3 = this.parMois;
         Calendar var4 = Calendar.getInstance();
         var4.setTime(var3);
         var4.add(2, 1);
         SimpleDateFormat var5 = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);
         String var6 = var5.format(var4.getTime());
         String[] var7 = var6.split("-");
         String var8 = "01-" + var7[1] + "-" + var7[2];
         SimpleDateFormat var9 = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);
         Date var10 = var9.parse(var8);
         Calendar var11 = Calendar.getInstance();
         var11.setTime(var10);
         var11.add(2, -1);
         Date var12 = var11.getTime();
         var11.add(2, 1);
         var11.add(5, -1);
         Date var13 = var11.getTime();
         SimpleDateFormat var14 = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);
         String var15 = var14.format(var13);
         String[] var16 = var15.split("-");
         int var17 = Integer.parseInt(var16[0]);
         this.listRdv.clear();
         this.chargerLesDoc(var12, var13, this.valNatMois, this.valStatutMois);
         this.listRdvMois.clear();
         RdvSemaine var18 = new RdvSemaine();
         int var19 = 1;

         for(int var20 = 1; var20 <= var17; ++var20) {
            String var21 = var14.format(var12).substring(0, 2);
            String var22 = "" + var12;
            ListDataModel var23;
            if (var22.contains("Mon")) {
               if (!var21.equals("01")) {
                  ++var19;
               }

               var18.setNum_sem(var19);
               var18.setLundi(var21);
               var18.setLesCmdJourLundi(this.rechercherRDVMois(this.listRdv, var12));
               var23 = new ListDataModel();
               var23.setWrappedData(var18.getLesCmdJourLundi());
               if (!var12.after(var2) && !var12.equals(var2)) {
                  var18.setAffiche01(false);
               } else {
                  var18.setAffiche01(true);
               }

               var18.setDataModelLundi(var23);
            } else if (var22.contains("Tue")) {
               var18.setNum_sem(var19);
               var18.setMardi(var21);
               var18.setLesCmdJourMardi(this.rechercherRDVMois(this.listRdv, var12));
               var23 = new ListDataModel();
               var23.setWrappedData(var18.getLesCmdJourMardi());
               if (!var12.after(var2) && !var12.equals(var2)) {
                  var18.setAffiche02(false);
               } else {
                  var18.setAffiche02(true);
               }

               var18.setDataModelMardi(var23);
            } else if (var22.contains("Wed")) {
               var18.setNum_sem(var19);
               var18.setMercredi(var21);
               var18.setLesCmdJourMercredi(this.rechercherRDVMois(this.listRdv, var12));
               var23 = new ListDataModel();
               var23.setWrappedData(var18.getLesCmdJourMercredi());
               if (!var12.after(var2) && !var12.equals(var2)) {
                  var18.setAffiche03(false);
               } else {
                  var18.setAffiche03(true);
               }

               var18.setDataModelMercredi(var23);
            } else if (var22.contains("Thu")) {
               var18.setNum_sem(var19);
               var18.setJeudi(var21);
               var18.setLesCmdJourJeudi(this.rechercherRDVMois(this.listRdv, var12));
               var23 = new ListDataModel();
               var23.setWrappedData(var18.getLesCmdJourJeudi());
               if (!var12.after(var2) && !var12.equals(var2)) {
                  var18.setAffiche04(false);
               } else {
                  var18.setAffiche04(true);
               }

               var18.setDataModelJeudi(var23);
            } else if (var22.contains("Fri")) {
               var18.setNum_sem(var19);
               var18.setVendredi(var21);
               var18.setLesCmdJourVendredi(this.rechercherRDVMois(this.listRdv, var12));
               var23 = new ListDataModel();
               var23.setWrappedData(var18.getLesCmdJourVendredi());
               if (!var12.after(var2) && !var12.equals(var2)) {
                  var18.setAffiche05(false);
               } else {
                  var18.setAffiche05(true);
               }

               var18.setDataModelVendredi(var23);
            } else if (var22.contains("Sat")) {
               var18.setNum_sem(var19);
               var18.setSamedi(var21);
               var18.setLesCmdJourSamedi(this.rechercherRDVMois(this.listRdv, var12));
               var23 = new ListDataModel();
               var23.setWrappedData(var18.getLesCmdJourSamedi());
               if (!var12.after(var2) && !var12.equals(var2)) {
                  var18.setAffiche06(false);
               } else {
                  var18.setAffiche06(true);
               }

               var18.setDataModelSamedi(var23);
            } else if (var22.contains("Sun")) {
               var18.setNum_sem(var19);
               var18.setDimanche(var21);
               var18.setLesCmdJourDimanche(this.rechercherRDVMois(this.listRdv, var12));
               var23 = new ListDataModel();
               var23.setWrappedData(var18.getLesCmdJourDimanche());
               if (!var12.after(var2) && !var12.equals(var2)) {
                  var18.setAffiche07(false);
               } else {
                  var18.setAffiche07(true);
               }

               var18.setDataModelDimanche(var23);
               this.listRdvMois.add(var18);
               var18 = new RdvSemaine();
            }

            Calendar var24 = Calendar.getInstance();
            var24.setTime(var12);
            var24.add(5, 1);
            var12 = var24.getTime();
         }

         if (var19 == 6) {
            if (var18.getLundi() != null && !var18.getLundi().isEmpty()) {
               this.listRdvMois.add(var18);
            }
         } else if (var19 == 5 && var18.getLundi() != null && !var18.getLundi().isEmpty()) {
            this.listRdvMois.add(var18);
         }

         this.datamodelLesRdvParMois.setWrappedData(this.listRdvMois);
      }

   }

   public List rechercherRDVMois(List var1, Date var2) throws ParseException {
      ArrayList var3 = new ArrayList();
      SimpleDateFormat var4 = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);
      String var5 = var4.format(var2);

      for(int var6 = 0; var6 < var1.size(); ++var6) {
         this.bienTravauxEntete = (BienTravauxEntete)var1.get(var6);
         SimpleDateFormat var7 = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);
         String var8 = var7.format(this.bienTravauxEntete.getBietraentDateLivraison());
         if (var8.equals(var5)) {
            if (this.bienTravauxEntete.getBietraentHoraireLivraison() == 0) {
               this.bienTravauxEntete.setHeure("??");
               this.bienTravauxEntete.setMinute("");
            } else if (this.bienTravauxEntete.getBietraentHoraireLivraison() == 1) {
               this.bienTravauxEntete.setHeure("AM");
               this.bienTravauxEntete.setMinute("");
            } else if (this.bienTravauxEntete.getBietraentHoraireLivraison() == 2) {
               this.bienTravauxEntete.setHeure("PM");
               this.bienTravauxEntete.setMinute("");
            } else if (this.bienTravauxEntete.getBietraentHoraireLivraison() == 3) {
               this.bienTravauxEntete.setHeure(this.bienTravauxEntete.getBietraentHeureLivraison());
               this.bienTravauxEntete.setMinute("");
            }

            String var9 = this.bienTravauxEntete.getVar_nom_tiers() + "\n" + this.bienTravauxEntete.getBietraentObjet() + "\n" + this.bienTravauxEntete.getBietraentNum();
            this.bienTravauxEntete.setTexteAffiche(var9);
            var3.add(this.bienTravauxEntete);
         }
      }

      return var3;
   }

   public void selectionLigneJour() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.datamodelLesRdvParJour.isRowAvailable()) {
         this.bienTravauxEntete = (BienTravauxEntete)this.datamodelLesRdvParJour.getRowData();
         this.modifierDateCommande();
      }

   }

   public void selectionLigneListe() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.datamodelRdv.isRowAvailable()) {
         this.bienTravauxEntete = (BienTravauxEntete)this.datamodelRdv.getRowData();
         this.modifierDateCommande();
      }

   }

   public void modifDateCol01() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         if (this.rdvSemaine.getDataModelLundi().isRowAvailable()) {
            this.bienTravauxEntete = (BienTravauxEntete)this.rdvSemaine.getDataModelLundi().getRowData();
            this.modifierDateCommande();
         }
      }

   }

   public void modifDateCol02() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         if (this.rdvSemaine.getDataModelMardi().isRowAvailable()) {
            this.bienTravauxEntete = (BienTravauxEntete)this.rdvSemaine.getDataModelMardi().getRowData();
            this.modifierDateCommande();
         }
      }

   }

   public void modifDateCol03() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         if (this.rdvSemaine.getDataModelMercredi().isRowAvailable()) {
            this.bienTravauxEntete = (BienTravauxEntete)this.rdvSemaine.getDataModelMercredi().getRowData();
            this.modifierDateCommande();
         }
      }

   }

   public void modifDateCol04() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         if (this.rdvSemaine.getDataModelJeudi().isRowAvailable()) {
            this.bienTravauxEntete = (BienTravauxEntete)this.rdvSemaine.getDataModelJeudi().getRowData();
            this.modifierDateCommande();
         }
      }

   }

   public void modifDateCol05() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         if (this.rdvSemaine.getDataModelVendredi().isRowAvailable()) {
            this.bienTravauxEntete = (BienTravauxEntete)this.rdvSemaine.getDataModelVendredi().getRowData();
            this.modifierDateCommande();
         }
      }

   }

   public void modifDateCol06() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         if (this.rdvSemaine.getDataModelSamedi().isRowAvailable()) {
            this.bienTravauxEntete = (BienTravauxEntete)this.rdvSemaine.getDataModelSamedi().getRowData();
            this.modifierDateCommande();
         }
      }

   }

   public void modifDateCol07() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         if (this.rdvSemaine.getDataModelDimanche().isRowAvailable()) {
            this.bienTravauxEntete = (BienTravauxEntete)this.rdvSemaine.getDataModelDimanche().getRowData();
            this.modifierDateCommande();
         }
      }

   }

   public void modifierDateCommande() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.bienTravauxEntete != null) {
         if (this.bienTravauxEntete.getBietraentId() != 0L) {
            this.memoDateLivraion = this.bienTravauxEntete.getBietraentDateLivraison();
            this.listDetail.clear();
            this.listDetail = this.bienTravauxLigneDao.chargerDetail(this.bienTravauxEntete, (Session)null);
            this.datamodelDetail.setWrappedData(this.listDetail);
            this.showModalPanelPlanning = true;
         } else {
            this.tiers = new Tiers();
            this.rdv = new Rdv();
            this.rdv = this.rdvDao.logRdv(this.bienTravauxEntete.getBietraentIdEquipe());
            if (this.rdv != null) {
               this.showModalPanelRdv = true;
               this.compteRendu = true;
            }
         }
      }

   }

   public void fermerPlanning() {
      this.showModalPanelPlanning = false;
   }

   public void validerPlanning() throws HibernateException, NamingException, ParseException {
      if (this.bienTravauxEntete != null) {
         if (!this.memoDateLivraion.equals(this.bienTravauxEntete.getBietraentDateLivraison())) {
            this.bienTravauxEntete.setBietraentCompteurReport(this.bienTravauxEntete.getBietraentCompteurReport() + 1);
         }

         this.bienTravauxEntete = this.bienTravauxEnteteDao.modif(this.bienTravauxEntete);
         if (this.modeRdv == 0) {
            this.chargerLesRdvByMois();
         } else if (this.modeRdv == 1) {
            this.chargerLesRdvBySemaine();
         } else if (this.modeRdv == 2) {
            this.chargerLesRdvByJour();
         } else if (this.modeRdv == 3) {
            this.chargerLesRdv();
         }
      }

      this.showModalPanelPlanning = false;
   }

   public void ajouterRdvCol01() throws ParseException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         String var1 = "";
         if (this.parMois.getMonth() + 1 <= 9) {
            var1 = "0" + (this.parMois.getMonth() + 1);
         } else {
            var1 = "" + (this.parMois.getMonth() + 1);
         }

         int var2 = this.parMois.getYear() + 1900;
         Date var3 = this.utilDate.stringToDateSQLLight(var2 + "-" + var1 + "-" + this.rdvSemaine.getLundi());
         this.ajouterRdvMois(var3);
      }

   }

   public void ajouterRdvCol02() throws ParseException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         String var1 = "";
         if (this.parMois.getMonth() + 1 <= 9) {
            var1 = "0" + (this.parMois.getMonth() + 1);
         } else {
            var1 = "" + (this.parMois.getMonth() + 1);
         }

         int var2 = this.parMois.getYear() + 1900;
         Date var3 = this.utilDate.stringToDateSQLLight(var2 + "-" + var1 + "-" + this.rdvSemaine.getMardi());
         this.ajouterRdvMois(var3);
      }

   }

   public void ajouterRdvCol03() throws ParseException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         String var1 = "";
         if (this.parMois.getMonth() + 1 <= 9) {
            var1 = "0" + (this.parMois.getMonth() + 1);
         } else {
            var1 = "" + (this.parMois.getMonth() + 1);
         }

         int var2 = this.parMois.getYear() + 1900;
         Date var3 = this.utilDate.stringToDateSQLLight(var2 + "-" + var1 + "-" + this.rdvSemaine.getMercredi());
         this.ajouterRdvMois(var3);
      }

   }

   public void ajouterRdvCol04() throws ParseException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         String var1 = "";
         if (this.parMois.getMonth() + 1 <= 9) {
            var1 = "0" + (this.parMois.getMonth() + 1);
         } else {
            var1 = "" + (this.parMois.getMonth() + 1);
         }

         int var2 = this.parMois.getYear() + 1900;
         Date var3 = this.utilDate.stringToDateSQLLight(var2 + "-" + var1 + "-" + this.rdvSemaine.getJeudi());
         this.ajouterRdvMois(var3);
      }

   }

   public void ajouterRdvCol05() throws ParseException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         String var1 = "";
         if (this.parMois.getMonth() + 1 <= 9) {
            var1 = "0" + (this.parMois.getMonth() + 1);
         } else {
            var1 = "" + (this.parMois.getMonth() + 1);
         }

         int var2 = this.parMois.getYear() + 1900;
         Date var3 = this.utilDate.stringToDateSQLLight(var2 + "-" + var1 + "-" + this.rdvSemaine.getVendredi());
         this.ajouterRdvMois(var3);
      }

   }

   public void ajouterRdvCol06() throws ParseException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         String var1 = "";
         if (this.parMois.getMonth() + 1 <= 9) {
            var1 = "0" + (this.parMois.getMonth() + 1);
         } else {
            var1 = "" + (this.parMois.getMonth() + 1);
         }

         int var2 = this.parMois.getYear() + 1900;
         Date var3 = this.utilDate.stringToDateSQLLight(var2 + "-" + var1 + "-" + this.rdvSemaine.getSamedi());
         this.ajouterRdvMois(var3);
      }

   }

   public void ajouterRdvCol07() throws ParseException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         String var1 = "";
         if (this.parMois.getMonth() + 1 <= 9) {
            var1 = "0" + (this.parMois.getMonth() + 1);
         } else {
            var1 = "" + (this.parMois.getMonth() + 1);
         }

         int var2 = this.parMois.getYear() + 1900;
         Date var3 = this.utilDate.stringToDateSQLLight(var2 + "-" + var1 + "-" + this.rdvSemaine.getDimanche());
         this.ajouterRdvMois(var3);
      }

   }

   public void supprimerRdvCol01() throws HibernateException, NamingException, ParseException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         if (this.rdvSemaine.getDataModelLundi().isRowAvailable()) {
            this.rdv = this.rdvDao.logRdv(this.bienTravauxEntete.getBietraentIdEquipe());
            this.deleteEventRdv();
         }
      }

   }

   public void supprimerRdvCol02() throws HibernateException, NamingException, ParseException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         if (this.rdvSemaine.getDataModelMardi().isRowAvailable()) {
            this.bienTravauxEntete = (BienTravauxEntete)this.rdvSemaine.getDataModelMardi().getRowData();
            this.rdv = this.rdvDao.logRdv(this.bienTravauxEntete.getBietraentIdEquipe());
            this.deleteEventRdv();
         }
      }

   }

   public void supprimerRdvCol03() throws HibernateException, NamingException, ParseException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         if (this.rdvSemaine.getDataModelMercredi().isRowAvailable()) {
            this.rdv = this.rdvDao.logRdv(this.bienTravauxEntete.getBietraentIdEquipe());
            this.deleteEventRdv();
         }
      }

   }

   public void supprimerRdvCol04() throws HibernateException, NamingException, ParseException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         if (this.rdvSemaine.getDataModelJeudi().isRowAvailable()) {
            this.rdv = this.rdvDao.logRdv(this.bienTravauxEntete.getBietraentIdEquipe());
            this.deleteEventRdv();
         }
      }

   }

   public void supprimerRdvCol05() throws HibernateException, NamingException, ParseException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         if (this.rdvSemaine.getDataModelVendredi().isRowAvailable()) {
            this.rdv = this.rdvDao.logRdv(this.bienTravauxEntete.getBietraentIdEquipe());
            this.deleteEventRdv();
         }
      }

   }

   public void supprimerRdvCol06() throws HibernateException, NamingException, ParseException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         if (this.rdvSemaine.getDataModelSamedi().isRowAvailable()) {
            this.rdv = this.rdvDao.logRdv(this.bienTravauxEntete.getBietraentIdEquipe());
            this.deleteEventRdv();
         }
      }

   }

   public void supprimerRdvCol07() throws HibernateException, NamingException, ParseException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         if (this.rdvSemaine.getDataModelDimanche().isRowAvailable()) {
            this.rdv = this.rdvDao.logRdv(this.bienTravauxEntete.getBietraentIdEquipe());
            this.deleteEventRdv();
         }
      }

   }

   public void ajouterRdvMois(Date var1) {
      this.tiers = new Tiers();
      this.rdv = new Rdv();
      this.bienTravauxEntete = new BienTravauxEntete();
      this.rdv.setRdvDteDe(var1);
      this.rdv.setRdvNature(12);
      this.showModalPanelRdv = true;
      this.compteRendu = false;
   }

   public void annulerRdv() throws HibernateException, NamingException {
      this.showModalPanelRdv = false;
   }

   public void saveEventRdv() throws HibernateException, NamingException, ParseException {
      if (this.rdv.getRdvSujet() != null && !this.rdv.getRdvSujet().isEmpty()) {
         if (this.rdv.getRdvId() == 0L) {
            this.rdv.setUsers(this.usersLog);
            this.rdv.setRdvDateCreation(new Date());
            this.rdv = this.rdvDao.insert(this.rdv);
         } else {
            this.rdv = this.rdvDao.modif(this.rdv);
         }

         if (this.modeRdv == 0) {
            this.chargerLesRdvByMois();
         } else if (this.modeRdv == 1) {
            this.chargerLesRdvBySemaine();
         } else if (this.modeRdv == 2) {
            this.chargerLesRdvByJour();
         } else if (this.modeRdv == 3) {
            this.chargerLesRdv();
         }
      }

      this.showModalPanelRdv = false;
   }

   public void deleteEventRdv() throws HibernateException, NamingException, ParseException {
      if (this.rdv != null) {
         this.rdvDao.delete(this.rdv);
         if (this.modeRdv == 0) {
            this.chargerLesRdvByMois();
         } else if (this.modeRdv == 1) {
            this.chargerLesRdvBySemaine();
         } else if (this.modeRdv == 2) {
            this.chargerLesRdvByJour();
         } else if (this.modeRdv == 3) {
            this.chargerLesRdv();
         }
      }

   }

   public String calculeCheminRapport(String var1, int var2) {
      String var3 = "";
      if (var2 == 163) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "documentCommun" + File.separator + "ot" + File.separator;
      } else if (var2 == 164) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "documentCommun" + File.separator + "facture_charge" + File.separator;
      }

      return var3;
   }

   public String calculeCheminSousRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "sous_rapport" + File.separator;
      return var2;
   }

   public String calculeImageFond(String var1) throws HibernateException, NamingException {
      String var2 = "";
      File var3 = new File(this.calculeCheminSousRapport(var1) + "formatOt.jpg");
      if (var3.exists()) {
         var2 = "formatOt.jpg";
      }

      return var2;
   }

   public JRBeanCollectionDataSource calculeImpressionCommun(int var1) throws IOException {
      ArrayList var2 = new ArrayList();
      if (var1 == 163) {
         this.montant_lettre = this.utilNombre.begin(this.bienTravauxEntete.getBietraentCoutReel(), this.structureLog.getStrdevise());
         var2.add(this.bienTravauxLigne);
      } else if (var1 == 164) {
         this.montant_lettre = this.utilNombre.begin(this.bienTravauxLigne.getBietraligTtc(), this.structureLog.getStrdevise());
         var2.add(this.bienTravauxLigne);
      }

      JRBeanCollectionDataSource var3 = new JRBeanCollectionDataSource(var2);
      return var3;
   }

   public boolean majDateImpression(String var1, int var2) throws HibernateException, NamingException {
      boolean var3 = false;
      Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
      Transaction var5 = null;

      try {
         var5 = var4.beginTransaction();
         if (var2 == 163) {
            if (this.bienTravauxEntete.getBietraentDateImp() != null) {
               var3 = true;
            }

            this.bienTravauxEntete.setBietraentDateImp(new Date());
            if (this.bienTravauxEntete.getBietraentEtat() == 0 && this.usersChrono.getUsrchrValidation() == 1) {
               this.bienTravauxEntete.setBietraentEtat(1);
            }

            this.bienTravauxEntete.setBietraentModeleImp(var1);
            this.bienTravauxEntete = this.bienTravauxEnteteDao.modif(this.bienTravauxEntete, var4);
         } else if (var2 == 164) {
            if (this.bienTravauxLigne.getBietraligDateImp() != null) {
               var3 = true;
            }

            this.bienTravauxLigne.setBietraligDateImp(new Date());
            if (this.bienTravauxLigne.getBietraligEtat() == 0 && this.usersChrono.getUsrchrValidation() == 1) {
               this.bienTravauxLigne.setBietraligEtat(1);
            }

            this.bienTravauxLigne.setBietraligModeleImp(var1);
            this.bienTravauxLigne = this.bienTravauxLigneDao.modif(this.bienTravauxLigne, var4);
         }

         var5.commit();
      } catch (HibernateException var10) {
         if (var5 != null) {
            var5.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public void impression(UtilPrint var1, int var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10) throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      boolean var11;
      JRBeanCollectionDataSource var12;
      if (this.nature == 163) {
         if (var2 == 0) {
            if (var3 != null && !var3.isEmpty()) {
               var11 = this.majDateImpression(var3, this.nature);
               var1.setjRBeanCollectionDataSource(this.calculeImpressionCommun(this.nature));
               var1.setRapport(var3);
               var1.setEntete("Impression travaux");
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
               var1.setIdResponsable(this.bienTravauxEntete.getBietraentIdResponsable());
               var1.setIdCommercial(0L);
               var1.setTiersSelectionne((Tiers)null);
               var1.setNumDoc(this.bienTravauxEntete.getBietraentNum());
               var1.setNature(this.nature);
               var1.setId_doc(this.bienTravauxEntete.getBietraentId());
               var1.setParc((Parc)null);
               var1.setBaseLog(this.baseLog);
               var1.setStructureLog(this.structureLog);
               var1.setUsersLog(this.usersLog);
               var1.imprimeRapport();
            }
         } else if (var2 == 1 && var4 != null && !var4.isEmpty()) {
            var1.setRapport(var4);
            var1.setEntete("Impression de la liste des travaux");
            var1.setTotauxHt("");
            var1.setTotauxTaxe("");
            var1.setTotauxTtc("");
            var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "listeCommun" + File.separator + "ot" + File.separator);
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
            var12 = new JRBeanCollectionDataSource(this.listOt);
            var1.setjRBeanCollectionDataSource(var12);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      } else if (this.nature == 164) {
         if (var2 == 0) {
            if (var3 != null && !var3.isEmpty()) {
               var11 = this.majDateImpression(var3, this.nature);
               var1.setjRBeanCollectionDataSource(this.calculeImpressionCommun(this.nature));
               var1.setRapport(var3);
               var1.setEntete("Impression facture de charge");
               var1.setPageGarde((String)null);
               var1.setAnnexe1((String)null);
               var1.setAnnexe2((String)null);
               var1.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid(), this.nature));
               var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
               var1.setCheminScan(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanFacture" + File.separator);
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
               var1.setIdResponsable(0L);
               var1.setIdCommercial(0L);
               var1.setTiersSelectionne((Tiers)null);
               var1.setNumDoc(this.bienTravauxLigne.getBietraligNumFacture());
               var1.setNature(this.nature);
               var1.setId_doc(this.bienTravauxLigne.getBietraligId());
               var1.setParc((Parc)null);
               var1.setBaseLog(this.baseLog);
               var1.setStructureLog(this.structureLog);
               var1.setUsersLog(this.usersLog);
               var1.imprimeRapport();
            }
         } else if (var2 == 1 && var4 != null && !var4.isEmpty()) {
            var1.setRapport(var4);
            var1.setEntete("Impression de la liste des factures de charges");
            var1.setTotauxHt("");
            var1.setTotauxTaxe("");
            var1.setTotauxTtc("");
            var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "listeCommun" + File.separator + "facture_charge" + File.separator);
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
            var12 = new JRBeanCollectionDataSource(this.listDetail);
            var1.setjRBeanCollectionDataSource(var12);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
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

   public DataModel getDatamodelDetail() {
      return this.datamodelDetail;
   }

   public void setDatamodelDetail(DataModel var1) {
      this.datamodelDetail = var1;
   }

   public boolean isVar_affiche_facture() {
      return this.var_affiche_facture;
   }

   public void setVar_affiche_facture(boolean var1) {
      this.var_affiche_facture = var1;
   }

   public boolean isShowModalPanelDetail() {
      return this.showModalPanelDetail;
   }

   public void setShowModalPanelDetail(boolean var1) {
      this.showModalPanelDetail = var1;
   }

   public int getVar_action_detail() {
      return this.var_action_detail;
   }

   public void setVar_action_detail(int var1) {
      this.var_action_detail = var1;
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

   public BienTravauxEntete getBienTravauxEntete() {
      return this.bienTravauxEntete;
   }

   public void setBienTravauxEntete(BienTravauxEntete var1) {
      this.bienTravauxEntete = var1;
   }

   public BienTravauxLigne getBienTravauxLigne() {
      return this.bienTravauxLigne;
   }

   public void setBienTravauxLigne(BienTravauxLigne var1) {
      this.bienTravauxLigne = var1;
   }

   public DataModel getDatamodelOt() {
      return this.datamodelOt;
   }

   public void setDatamodelOt(DataModel var1) {
      this.datamodelOt = var1;
   }

   public boolean isVar_aff_detail_bien() {
      return this.var_aff_detail_bien;
   }

   public void setVar_aff_detail_bien(boolean var1) {
      this.var_aff_detail_bien = var1;
   }

   public String getUrlphotoProd() {
      return this.urlphotoProd;
   }

   public void setUrlphotoProd(String var1) {
      this.urlphotoProd = var1;
   }

   public UploadedFile getUploadedFile() {
      return this.uploadedFile;
   }

   public void setUploadedFile(UploadedFile var1) {
      this.uploadedFile = var1;
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

   public boolean isAfficheRdv() {
      return this.afficheRdv;
   }

   public void setAfficheRdv(boolean var1) {
      this.afficheRdv = var1;
   }

   public boolean isCompteRendu() {
      return this.compteRendu;
   }

   public void setCompteRendu(boolean var1) {
      this.compteRendu = var1;
   }

   public DataModel getDatamodelLesRdvParJour() {
      return this.datamodelLesRdvParJour;
   }

   public void setDatamodelLesRdvParJour(DataModel var1) {
      this.datamodelLesRdvParJour = var1;
   }

   public DataModel getDatamodelLesRdvParMois() {
      return this.datamodelLesRdvParMois;
   }

   public void setDatamodelLesRdvParMois(DataModel var1) {
      this.datamodelLesRdvParMois = var1;
   }

   public DataModel getDatamodelLesRdvParSemaine() {
      return this.datamodelLesRdvParSemaine;
   }

   public void setDatamodelLesRdvParSemaine(DataModel var1) {
      this.datamodelLesRdvParSemaine = var1;
   }

   public DataModel getDatamodelRdv() {
      return this.datamodelRdv;
   }

   public void setDatamodelRdv(DataModel var1) {
      this.datamodelRdv = var1;
   }

   public String getDateDim() {
      return this.dateDim;
   }

   public void setDateDim(String var1) {
      this.dateDim = var1;
   }

   public String getDateJeu() {
      return this.dateJeu;
   }

   public void setDateJeu(String var1) {
      this.dateJeu = var1;
   }

   public String getDateLun() {
      return this.dateLun;
   }

   public void setDateLun(String var1) {
      this.dateLun = var1;
   }

   public String getDateMar() {
      return this.dateMar;
   }

   public void setDateMar(String var1) {
      this.dateMar = var1;
   }

   public String getDateMer() {
      return this.dateMer;
   }

   public void setDateMer(String var1) {
      this.dateMer = var1;
   }

   public String getDateSam() {
      return this.dateSam;
   }

   public void setDateSam(String var1) {
      this.dateSam = var1;
   }

   public String getDateVen() {
      return this.dateVen;
   }

   public void setDateVen(String var1) {
      this.dateVen = var1;
   }

   public List getPlanningImpressionsItems() {
      return this.planningImpressionsItems;
   }

   public void setPlanningImpressionsItems(List var1) {
      this.planningImpressionsItems = var1;
   }

   public boolean isShowModalPanelPlanning() {
      return this.showModalPanelPlanning;
   }

   public void setShowModalPanelPlanning(boolean var1) {
      this.showModalPanelPlanning = var1;
   }

   public boolean isShowModalPanelPrintPlanning() {
      return this.showModalPanelPrintPlanning;
   }

   public void setShowModalPanelPrintPlanning(boolean var1) {
      this.showModalPanelPrintPlanning = var1;
   }

   public boolean isShowModalPanelRdv() {
      return this.showModalPanelRdv;
   }

   public void setShowModalPanelRdv(boolean var1) {
      this.showModalPanelRdv = var1;
   }

   public boolean isShowModalPanelTiers() {
      return this.showModalPanelTiers;
   }

   public void setShowModalPanelTiers(boolean var1) {
      this.showModalPanelTiers = var1;
   }

   public int getValNatJour() {
      return this.valNatJour;
   }

   public void setValNatJour(int var1) {
      this.valNatJour = var1;
   }

   public int getValNatListe() {
      return this.valNatListe;
   }

   public void setValNatListe(int var1) {
      this.valNatListe = var1;
   }

   public int getValNatMois() {
      return this.valNatMois;
   }

   public void setValNatMois(int var1) {
      this.valNatMois = var1;
   }

   public int getValNatSemaine() {
      return this.valNatSemaine;
   }

   public void setValNatSemaine(int var1) {
      this.valNatSemaine = var1;
   }

   public int getValStatutJour() {
      return this.valStatutJour;
   }

   public void setValStatutJour(int var1) {
      this.valStatutJour = var1;
   }

   public int getValStatutListe() {
      return this.valStatutListe;
   }

   public void setValStatutListe(int var1) {
      this.valStatutListe = var1;
   }

   public int getValStatutMois() {
      return this.valStatutMois;
   }

   public void setValStatutMois(int var1) {
      this.valStatutMois = var1;
   }

   public int getValStatutSemaine() {
      return this.valStatutSemaine;
   }

   public void setValStatutSemaine(int var1) {
      this.valStatutSemaine = var1;
   }

   public Date getJourDeb() {
      return this.jourDeb;
   }

   public void setJourDeb(Date var1) {
      this.jourDeb = var1;
   }

   public Date getJourFin() {
      return this.jourFin;
   }

   public void setJourFin(Date var1) {
      this.jourFin = var1;
   }

   public int getModeRdv() {
      return this.modeRdv;
   }

   public void setModeRdv(int var1) {
      this.modeRdv = var1;
   }

   public Date getParJour() {
      return this.parJour;
   }

   public void setParJour(Date var1) {
      this.parJour = var1;
   }

   public Date getParMois() {
      return this.parMois;
   }

   public void setParMois(Date var1) {
      this.parMois = var1;
   }

   public Date getParSemaine() {
      return this.parSemaine;
   }

   public void setParSemaine(Date var1) {
      this.parSemaine = var1;
   }

   public List getLesPostesItems() {
      return this.lesPostesItems;
   }

   public void setLesPostesItems(List var1) {
      this.lesPostesItems = var1;
   }

   public String getReferenceBien() {
      return this.referenceBien;
   }

   public void setReferenceBien(String var1) {
      this.referenceBien = var1;
   }

   public String getReferenceOt() {
      return this.referenceOt;
   }

   public void setReferenceOt(String var1) {
      this.referenceOt = var1;
   }

   public boolean isVar_aff_detail_fournisseur() {
      return this.var_aff_detail_fournisseur;
   }

   public void setVar_aff_detail_fournisseur(boolean var1) {
      this.var_aff_detail_fournisseur = var1;
   }

   public boolean isShowModalPanelScan() {
      return this.showModalPanelScan;
   }

   public void setShowModalPanelScan(boolean var1) {
      this.showModalPanelScan = var1;
   }

   public List getLesBlocsItems() {
      return this.lesBlocsItems;
   }

   public void setLesBlocsItems(List var1) {
      this.lesBlocsItems = var1;
   }

   public int getTypeFichier() {
      return this.typeFichier;
   }

   public void setTypeFichier(int var1) {
      this.typeFichier = var1;
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

   public String getUrlExplorateur() {
      return this.urlExplorateur;
   }

   public void setUrlExplorateur(String var1) {
      this.urlExplorateur = var1;
   }

   public List getMesBiensRecItems() {
      return this.mesBiensRecItems;
   }

   public void setMesBiensRecItems(List var1) {
      this.mesBiensRecItems = var1;
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
