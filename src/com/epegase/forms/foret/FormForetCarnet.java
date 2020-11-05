package com.epegase.forms.foret;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.Equipes;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.ForetGrume;
import com.epegase.systeme.classe.ForetInventaire;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.EtatDocument;
import com.epegase.systeme.control.ObjetGraph;
import com.epegase.systeme.dao.DocumentTraceVentesDao;
import com.epegase.systeme.dao.EquipesDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.ForetGrumeDao;
import com.epegase.systeme.dao.ForetInventaireDao;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilDownload;
import com.epegase.systeme.util.UtilGoogleMap;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilParapheur;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.util.UtilTdt;
import com.epegase.systeme.xml.ObjetLigneOnglet;
import com.epegase.systeme.xml.OptionParcs;
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
import org.apache.myfaces.custom.fileupload.UploadedFile;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jdom.JDOMException;
import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlExtendedDataTable;
import org.richfaces.model.selection.SimpleSelection;

public class FormForetCarnet implements Serializable {
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
   private OptionParcs optionParcs;
   private ExercicesVentes exercicesVentes;
   private ExercicesVentes lastExoVentes;
   private EspionDao espionDao;
   private int var_nb_max = 100;
   private UtilDate utilDate = new UtilDate();
   private UtilNombre utilNombre = new UtilNombre();
   private CalculChrono calculChrono;
   private int var_option_parc;
   private boolean showModalPanelAnnuler = false;
   private String nomCreateur;
   private String nomModification;
   private transient DataModel datamodelDocument = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private List lesInventaires = new ArrayList();
   private ForetInventaire foretInventaire = new ForetInventaire();
   private ForetInventaireDao foretInventaireDao;
   private boolean visibiliteBton = false;
   private boolean var_aff_action = false;
   private boolean var_valide_doc = false;
   private int var_etat;
   private List mesLieuxItem;
   private String var_imput_serie;
   private boolean showModalPanelImput = false;
   private List lesGrume = new ArrayList();
   private transient DataModel datamodelGrume = new ListDataModel();
   private ForetGrume foretGrume;
   private ForetGrumeDao foretGrumeDao;
   private List mesEssencesItem;
   private List mesClassementsItem;
   private boolean visibiliteBtonlig;
   private Date inpDate;
   private Date inpDu;
   private Date inpAu;
   private int inpEtat;
   private String periode;
   private String inpSerie;
   private String inpNum;
   private String inpLieu;
   private String inpEquipe;
   private long inpIdEquipe;
   private String inpResponsable;
   private long inpIdResponsable;
   private String inpCommercial;
   private long inpIdCommercial;
   private int totalArbre;
   private float totalCubage;
   private int var_nb_ligne;
   private List mesSerieUserItem;
   private boolean var_more_search = false;
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
   private PlansAnalytiques plansAnalytiques;
   private PlansAnalytiquesDao plansAnalytiquesDao;
   private Users responsable;
   private long var_nom_commercial;
   private List mesUsersItem = new ArrayList();
   private List mesPersonnelsItem = new ArrayList();
   private long var_nom_responsable;
   private UserDao usersDao;
   private long var_nom_equipe;
   private Equipes equipes;
   private EquipesDao equipesDao;
   private List mesEquipeItem = new ArrayList();
   private List lesEquipes;
   private UtilTdt utilTdt = new UtilTdt();
   private boolean showModalPanelPrint = false;
   private String infoOrigineDoc;
   private String devisePrint;
   private float tauxPrint;
   private String montant_lettre;
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
   private boolean showModalPanelPJ = false;
   private boolean showModalPanelAjoutPJ = false;
   private int modePj;
   private boolean conditionPj;
   private String valueScanPj;
   private UploadedFile uploadedFile;
   private UtilDownload utilDownload;
   private String urlphotoProd;
   private static final int DEFAULT_BUFFER_SIZE = 10240;
   private int typeFichier;
   private String fichierMine;
   private URL fichierUrl;
   private String urlExplorateur;
   private URI uri;
   private String coordonnees;
   private String origine;
   private String legende;

   public FormForetCarnet() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.utilDownload = new UtilDownload();
   }

   public void InstancesDaoUtilses() {
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.foretInventaireDao = new ForetInventaireDao(this.baseLog, this.utilInitHibernate);
      this.foretGrumeDao = new ForetGrumeDao(this.baseLog, this.utilInitHibernate);
      this.usersDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.equipesDao = new EquipesDao(this.baseLog, this.utilInitHibernate);
      this.plansAnalytiquesDao = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
   }

   public void configVentes(Session var1) throws HibernateException, NamingException, JDOMException, IOException {
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
      this.chargerLesUsers(var1);
      this.chargerCommerciauxResponsable(var1);
      this.chargerLesEquipes(var1);
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

   public void chargerLesUsers(Session var1) throws HibernateException, NamingException {
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

   public void chargerCommerciauxResponsable(Session var1) throws HibernateException, NamingException {
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

   public void chargerLesEquipes(Session var1) throws HibernateException, NamingException {
      this.mesEquipeItem = this.equipesDao.chargerLesEquipes(var1);
   }

   public void chargerUserChrono(Session var1) throws HibernateException, NamingException {
      if (this.foretInventaire != null && this.foretInventaire.getForinvSerie() != null && !this.foretInventaire.getForinvSerie().isEmpty()) {
         this.usersChrono = this.usersChronoDao.selectUnique(this.foretInventaire.getForinvSerie(), this.nature, this.usersLog, var1);
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
         this.inpCommercial = "";
      }

   }

   public void executerRequete() throws NamingException, HibernateException, ParseException {
      this.executerRequete((Session)null);
   }

   public void executerRequete(Session var1) throws NamingException, HibernateException, ParseException {
      this.lesInventaires.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      this.var_nb_ligne = 0;
      this.inpNum = "";
      Object var2 = null;
      Object var3 = null;
      int var4 = 0;
      float var5 = 0.0F;
      if (this.inpNum != null && !this.inpNum.isEmpty()) {
         this.inpEtat = 100;
      }

      this.lesInventaires = this.foretInventaireDao.recherche(var1, this.exercicesVentes.getExevteId(), this.inpNum, this.inpEtat, this.periode, this.usersLog.getUsrid(), this.usersLog.getUsrVentes(), this.inpResponsable, this.inpCommercial, this.inpLieu, (String)var2, (String)var3);
      if (this.lesInventaires.size() > 0) {
         new ForetInventaire();

         for(int var7 = 0; var7 < this.lesInventaires.size(); ++var7) {
            ForetInventaire var6 = (ForetInventaire)this.lesInventaires.get(var7);
            var4 += var6.getForinvTotArbre();
            var5 += var6.getForinvTotCub();
         }

         this.var_nb_ligne = this.lesInventaires.size();
      }

      this.datamodelDocument.setWrappedData(this.lesInventaires);
      this.totalArbre = var4;
      this.totalCubage = var5;
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
            this.foretInventaire = (ForetInventaire)var1.get(0);
            this.var_etat = this.foretInventaire.getForinvEtat();
            this.var_date = this.foretInventaire.getForinvDate();
            this.var_nom_responsable = this.foretInventaire.getForinvIdResponsable();
            this.var_nom_commercial = this.foretInventaire.getForinvIdCommercial();
            this.var_nom_equipe = this.foretInventaire.getForinvIdEquipe();
            if (this.foretInventaire.getForinvDate().getHours() <= 9) {
               this.var_heure = "0" + this.foretInventaire.getForinvDate().getHours();
            } else {
               this.var_heure = "" + this.foretInventaire.getForinvDate().getHours();
            }

            if (this.foretInventaire.getForinvDate().getMinutes() <= 9) {
               this.var_minute = "0" + this.foretInventaire.getForinvDate().getMinutes();
            } else {
               this.var_minute = "" + this.foretInventaire.getForinvDate().getMinutes();
            }

            if (this.foretInventaire.getForinvDate().getSeconds() <= 9) {
               this.var_seconde = "0" + this.foretInventaire.getForinvDate().getSeconds();
            } else {
               this.var_seconde = "" + this.foretInventaire.getForinvDate().getSeconds();
            }

            Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "ForetEntete");
            this.chargerLesGrumes(var5);
            this.plansAnalytiques = this.plansAnalytiquesDao.rechercheAnal("7", this.foretInventaire.getForinvChantier(), var5);
            if (this.plansAnalytiques == null) {
               this.plansAnalytiques = new PlansAnalytiques();
            }

            new Users();
            this.nomCreateur = "";
            Users var4;
            if (this.foretInventaire.getForinvUserCreat() != 0L) {
               var4 = this.usersDao.selectUserD(this.foretInventaire.getForinvUserCreat(), var5);
               if (var4 != null) {
                  this.nomCreateur = var4.getUsrPatronyme();
               }
            }

            this.nomModification = "";
            if (this.foretInventaire.getForinvUserModif() != 0L) {
               var4 = this.usersDao.selectUserD(this.foretInventaire.getForinvUserModif(), var5);
               if (var4 != null) {
                  this.nomModification = var4.getUsrPatronyme();
               }
            }

            this.utilInitHibernate.closeSession();
            this.visibiliteBton = true;
         } else {
            this.visibiliteBton = false;
         }
      } else {
         this.visibiliteBton = false;
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException, ParseException {
      if (this.foretInventaire != null) {
         if (this.foretInventaire.getForinvEtat() == 0) {
            this.modifDocument();
         } else {
            this.consultDocument();
         }
      }

   }

   public void chargerLesGrumes(Session var1) throws HibernateException, NamingException {
      this.lesGrume.clear();
      if (this.foretInventaire != null) {
         this.lesGrume = this.foretGrumeDao.rechercheByInventaire(this.foretInventaire, var1);
      }

      this.datamodelGrume.setWrappedData(this.lesGrume);
   }

   public void ajoutDocument() throws ParseException, HibernateException, NamingException, JDOMException, IOException {
      this.plansAnalytiques = new PlansAnalytiques();
      this.foretInventaire = new ForetInventaire();
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
      this.inpEquipe = "";
      this.inpCommercial = "";
      this.nomCreateur = "";
      this.nomModification = "";
      this.lesGrume.clear();
      this.datamodelGrume.setWrappedData(this.lesGrume);
      this.var_action = 1;
      this.var_aff_action = false;
      this.var_memo_action = this.var_action;
      this.autorisationDocument();
      this.addLigne();
   }

   public void modifDocument() throws ParseException {
      if (this.foretInventaire != null) {
         this.var_action = 2;
         this.var_aff_action = false;
         this.var_valide_doc = true;
         this.visibleOnglet = true;
         this.var_memo_action = this.var_action;
         this.autorisationDocument();
         this.addLigne();
      }

   }

   public void consultDocument() {
      if (this.foretInventaire != null) {
         this.var_action = 3;
         this.var_aff_action = true;
         this.var_valide_doc = true;
         this.visibleOnglet = true;
         this.var_memo_action = this.var_action;
         this.autorisationDocument();
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

   public void selectionChantier() throws HibernateException, NamingException {
      if (this.foretInventaire != null) {
         if (this.foretInventaire.getForinvChantier() != null && !this.foretInventaire.getForinvChantier().isEmpty()) {
            this.plansAnalytiques = this.plansAnalytiquesDao.rechercheAnal("7", this.foretInventaire.getForinvChantier(), (Session)null);
            if (this.plansAnalytiques != null) {
               this.foretInventaire.setForinvMarteau(this.plansAnalytiques.getAnaMarteau());
               this.foretInventaire.setForinvRegion(this.plansAnalytiques.getAnaRegion());
               this.var_valide_doc = true;
            } else {
               this.foretInventaire.setForinvMarteau((String)null);
               this.foretInventaire.setForinvRegion((String)null);
               this.var_valide_doc = false;
            }
         } else {
            this.foretInventaire.setForinvMarteau((String)null);
            this.foretInventaire.setForinvRegion((String)null);
            this.var_valide_doc = false;
         }
      } else {
         this.var_valide_doc = false;
      }

      this.visibiliteBtonlig = true;
   }

   public void save() throws IOException, NamingException, Exception {
      this.majAnalytique();
      this.verifieExistenceHabilitation((Session)null);
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ForetEntete");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.foretInventaire.setForinvDate(this.utilDate.dateToSQL(this.var_date, this.var_heure, this.var_minute, this.var_seconde));
         this.foretInventaire.setForinvIdResponsable(0L);
         this.foretInventaire.setForinvNomResponsable("");
         new Users();
         if (this.var_nom_responsable == 0L && this.mesUsersItem.size() == 1) {
            this.var_nom_responsable = Long.parseLong(((SelectItem)this.mesUsersItem.get(0)).getValue().toString());
         }

         Users var3 = this.usersDao.selectUserD(this.var_nom_responsable, var1);
         if (var3 != null) {
            this.foretInventaire.setForinvIdResponsable(var3.getUsrid());
            this.foretInventaire.setForinvNomResponsable(var3.getUsrPatronyme());
         }

         this.foretInventaire.setForinvIdCommercial(0L);
         this.foretInventaire.setForinvNomCommercial("");
         if (this.optionsVentes.getResponsable().equals("1") || this.optionsVentes.getResponsable().equals("2")) {
            new Users();
            Users var4 = this.usersDao.selectUserD(this.var_nom_commercial, var1);
            if (var4 != null) {
               this.foretInventaire.setForinvIdCommercial(var4.getUsrid());
               this.foretInventaire.setForinvNomCommercial(var4.getUsrPatronyme());
            }
         }

         this.foretInventaire.setForinvIdEquipe(0L);
         this.foretInventaire.setForinvNomEquipe("");
         if (this.optionsVentes.getResponsable().equals("1")) {
            this.equipes = this.equipesDao.rechercheEquipes(this.foretInventaire.getForinvIdResponsable(), var1);
            if (this.equipes != null) {
               this.foretInventaire.setForinvIdEquipe(this.equipes.getEquId());
               this.foretInventaire.setForinvNomEquipe(this.equipes.getEquNomFr());
            }
         }

         if (this.foretInventaire.getForinvId() != 0L) {
            this.foretInventaire.setForinvDateModif(new Date());
            this.foretInventaire.setForinvUserModif(this.usersLog.getUsrid());
            this.foretInventaire = this.foretInventaireDao.modif(this.foretInventaire, var1);
            this.var_action = 0;
            this.var_memo_action = this.var_action;
            this.visibleOnglet = false;
         } else {
            this.foretInventaire.setExercicesVentes(this.exercicesVentes);
            this.foretInventaire.setForinvDateCreat(new Date());
            this.foretInventaire.setForinvUserCreat(this.usersLog.getUsrid());
            if (!this.foretInventaire.getForinvSerie().equalsIgnoreCase("X") && !this.foretInventaire.getForinvSerie().isEmpty()) {
               this.foretInventaire.setForinvNum(this.calculChrono.numCompose(this.foretInventaire.getForinvDate(), this.nature, this.foretInventaire.getForinvSerie(), var1));
               boolean var16 = false;

               label182:
               while(true) {
                  while(true) {
                     if (var16) {
                        break label182;
                     }

                     new ForetInventaire();
                     ForetInventaire var5 = this.foretInventaireDao.pourParapheur(this.foretInventaire.getForinvNum(), this.foretInventaire.getForinvSerie(), var1);
                     if (var5 != null) {
                        long var6 = 100000000L * this.usersLog.getUsrid();

                        for(long var8 = 0L; var8 < var6; ++var8) {
                        }

                        this.foretInventaire.setForinvNum(this.calculChrono.numCompose(this.foretInventaire.getForinvDate(), this.nature, this.foretInventaire.getForinvSerie(), var1));
                        var16 = false;
                     } else {
                        var16 = true;
                     }
                  }
               }
            } else {
               long var15 = this.foretInventaireDao.selectLastNum(var1);
               this.foretInventaire.setForinvNum("" + var15);
            }

            this.foretInventaire.setForinvEtat(0);
            this.foretInventaire.setForinvEtatVal(0);
            this.foretInventaire.setForinvDateValide((Date)null);
            this.foretInventaire = this.foretInventaireDao.insert(this.foretInventaire, var1);
            this.visibleOnglet = true;
            this.var_action = 1;
            this.var_memo_action = this.var_action;
            this.lesInventaires.add(this.foretInventaire);
            this.datamodelDocument.setWrappedData(this.lesGrume);
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
         }

         if (this.habilitation != null && this.var_action == 0) {
            this.utilParapheur.majParapheur(this.nature, this.habilitation, this.foretInventaire.getForinvId(), this.foretInventaire.getForinvNum(), this.foretInventaire.getForinvNomResponsable(), this.foretInventaire.getForinvDate(), this.structureLog.getStrdevise(), 0.0D, this.foretInventaire.getForinvModeleImp(), (Tiers)null, this.calculeCheminRapport(this.baseLog, this.nature), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(), (String)null, this.structureLog.getStrformatdevise(), 0, var1);
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
         this.foretInventaire.setForinvEtatVal(1);
         this.foretInventaire.setForinvEtat(0);
         this.foretInventaire.setForinvDateValide((Date)null);
         return true;
      } else {
         this.foretInventaire.setForinvEtatVal(0);
         this.chargerUserChrono(var1);
         if (this.usersChrono != null) {
            if (this.usersChrono.getUsrchrValidation() == 0) {
               this.foretInventaire.setForinvEtat(1);
               this.foretInventaire.setForinvDateValide(new Date());
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2 && this.usersChrono.getUsrchrValidation() == 3) {
               this.foretInventaire.setForinvEtat(0);
               this.foretInventaire.setForinvDateValide((Date)null);
            }
         }

         return false;
      }
   }

   public void majAnalytique() throws HibernateException, NamingException {
   }

   public void supprimerDocument() throws ParseException {
      if (this.foretInventaire != null) {
      }

   }

   public void valideDocument() throws HibernateException, NamingException, ParseException {
      if (this.foretInventaire != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ForetEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.foretInventaire.getForinvEtat() == 0 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
               this.foretInventaire.setForinvEtat(1);
               this.foretInventaire = this.foretInventaireDao.modif(this.foretInventaire, var1);
               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Validation manuelle inventaire chantier (C.) N° " + this.foretInventaire.getForinvNum() + " du " + this.utilDate.dateToStringSQLLight(this.foretInventaire.getForinvDate()));
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
      if (this.foretInventaire != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ForetEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.foretInventaire.getForinvEtat() == 1) {
               this.foretInventaire.setForinvEtat(0);
               this.foretInventaire.setForinvDateImp((Date)null);
               this.foretInventaire = this.foretInventaireDao.modif(this.foretInventaire, var1);
               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Dévalidation manuelle inventaire chantier (C.) N° " + this.foretInventaire.getForinvNum() + " du " + this.utilDate.dateToStringSQLLight(this.foretInventaire.getForinvDate()));
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

   public void annulerDocument() {
      if (this.foretInventaire != null) {
         this.foretInventaire.setForinvDateAnnule(new Date());
         this.showModalPanelAnnuler = true;
      }

   }

   public void annuleAnnulation() {
      this.showModalPanelAnnuler = false;
   }

   public void miseajourAnnuler() throws HibernateException, NamingException {
      if (this.foretInventaire != null) {
         if (this.foretInventaire.getForinvDateAnnule() == null) {
            this.foretInventaire.setForinvDateAnnule(new Date());
         }

         this.foretInventaire.setForinvEtat(3);
         this.foretInventaire = this.foretInventaireDao.modif(this.foretInventaire);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         var1.setEspaction("Annulation inventaire chantier vente N° " + this.foretInventaire.getForinvNum() + " le " + this.foretInventaire.getForinvDateAnnule());
         this.espionDao.mAJEspion(var1);
         this.lesInventaires.remove(this.foretInventaire);
         this.datamodelDocument.setWrappedData(this.lesInventaires);
      }

      this.showModalPanelAnnuler = false;
      this.visibiliteBton = false;
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
   }

   public void addLigne() {
      this.foretGrume = new ForetGrume();
   }

   public void selectionLigneDetail() {
      if (this.datamodelGrume.isRowAvailable()) {
         this.foretGrume = (ForetGrume)this.datamodelGrume.getRowData();
      }

   }

   public void supprimerLigne() throws HibernateException, NamingException {
   }

   public void saveOneLigne() throws HibernateException, NamingException, IOException, Exception {
      if (this.foretInventaire.getForinvId() == 0L) {
         this.save();
      }

      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ForetEntete");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.calculCubage();
         this.foretGrume.setGruChantier(this.foretInventaire.getForinvChantier());
         this.foretGrume.setGruMarteau(this.foretInventaire.getForinvMarteau());
         this.foretGrume.setGruDateInv(this.foretInventaire.getForinvDate());
         this.foretGrume.setGruNumInv(this.foretInventaire.getForinvNum());
         if (this.foretGrume.getGruId() == 0L) {
            this.foretGrume.setForetInventaire(this.foretInventaire);
            this.foretGrume = this.foretGrumeDao.insert(this.foretGrume, var1);
            this.lesGrume.add(this.foretGrume);
            this.datamodelGrume.setWrappedData(this.lesGrume);
         } else {
            this.foretGrume = this.foretGrumeDao.modif(this.foretGrume, var1);
         }

         float var3 = 0.0F;
         int var4 = 0;

         while(true) {
            if (var4 >= this.lesGrume.size()) {
               this.foretInventaire.setForinvTotArbre(this.lesGrume.size());
               this.foretInventaire.setForinvTotCub(var3);
               this.foretInventaire = this.foretInventaireDao.modif(this.foretInventaire, var1);
               var2.commit();
               break;
            }

            var3 += ((ForetGrume)this.lesGrume.get(var4)).getGruCubInv();
            ++var4;
         }
      } catch (HibernateException var8) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var8;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.addLigne();
   }

   public void calculCubage() {
      if (this.foretGrume != null) {
         if (this.foretGrume.getGruDiamBasInv() != 0 && this.foretGrume.getGruDiamHauInv() != 0) {
            int var1 = (this.foretGrume.getGruDiamBasInv() + this.foretGrume.getGruDiamHauInv()) / 2;
            this.foretGrume.setGruDiamMoyInv(var1);
         } else {
            this.foretGrume.setGruDiamMoyInv(this.foretGrume.getGruDiamBasInv());
         }

         float var2 = (float)this.utilNombre.myRound(0.7853981633974483D * (double)(this.foretGrume.getGruDiamMoyInv() * this.foretGrume.getGruDiamMoyInv()) * (double)this.foretGrume.getGruLongInv() / 1000.0D / 1000.0D, 3);
         if (this.foretGrume.getGruLongInv() < 400 && this.foretGrume.getGruDiamMoyInv() != 0 && this.foretGrume.getGruLongInv() != 0) {
            var2 = (float)((double)var2 - 0.001D);
         }

         this.foretGrume.setGruCubInv(var2);
      }

   }

   public void calculGeloc() throws URISyntaxException {
      if (this.lesGrume.size() != 0) {
         UtilGoogleMap var1 = new UtilGoogleMap(this.structureLog);
         this.coordonnees = var1.calculForetMapBox(this.lesGrume);
         int var2 = this.lesGrume.size() - 1;
         this.origine = ((ForetGrume)this.lesGrume.get(var2)).getGruLocX() + "," + ((ForetGrume)this.lesGrume.get(var2)).getGruLocY();
      }

   }

   public void verifUnicite() throws HibernateException, NamingException {
      if (this.foretGrume != null) {
         new ForetGrume();
         ForetGrume var1 = this.foretGrumeDao.rechercheArbre(this.foretGrume.getGruArbre(), this.foretGrume.getGruChantier(), this.foretGrume.getGruEssence(), (Session)null);
         if (var1 != null) {
            this.foretGrume = new ForetGrume();
         }
      }

   }

   public void ouvrirPj() throws HibernateException, NamingException, MalformedURLException, IOException {
      if (this.foretGrume != null && this.foretGrume.getGruArbre() != null && !this.foretGrume.getGruArbre().isEmpty() && !this.foretGrume.isGruPhoto()) {
         this.modePj = 1;
         this.uploadedFile = null;
         this.typeFichier = 0;
         this.valueScanPj = "";
         this.showModalPanelPJ = false;
         this.showModalPanelAjoutPJ = true;
      } else if (this.foretGrume != null && this.foretGrume.getGruArbre() != null && !this.foretGrume.getGruArbre().isEmpty() && this.foretGrume.isGruPhoto()) {
         this.ouvrirPjConsultation();
      }

   }

   public void ouvrirPjConsultation() throws HibernateException, NamingException, MalformedURLException, IOException {
      if (this.foretGrume != null && this.foretGrume.getGruArbre() != null && !this.foretGrume.getGruArbre().isEmpty()) {
         this.modePj = 2;
         String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "arbre" + this.exercicesVentes.getExevteId() + File.separator;
         File var2 = new File(var1);
         if (!var2.exists()) {
            var2.mkdir();
         }

         String var3 = this.foretGrume.getGruChantier() + ":" + this.foretGrume.getGruEssence() + ":" + this.foretGrume.getGruArbre().replaceAll("/", "_");
         File var4 = new File(var1 + var3 + ".pdf");
         if (var4.exists()) {
            this.typeFichier = 1;
            var3 = var3 + ".pdf";
         } else {
            this.typeFichier = 0;
            var3 = var3 + ".jpg";
         }

         if (this.typeFichier == 1) {
            this.fichierUrl = this.utilDownload.convertirFichierUtl(var1 + var3, this.urlExplorateur);
            this.fichierMine = this.utilDownload.calculeTypeMine(var3);
            this.typeFichier = 1;
         } else {
            this.urlphotoProd = "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "arbre" + this.exercicesVentes.getExevteId() + File.separator + var3;
            this.typeFichier = 0;
         }

         this.showModalPanelPJ = true;
      }

   }

   public void fermerPj() {
      this.showModalPanelPJ = false;
      this.showModalPanelAjoutPJ = false;
   }

   public void validerPj() throws IOException, NamingException, JDOMException, ParseException, HibernateException, Exception {
      if (this.foretGrume.getGruId() == 0L) {
         this.saveOneLigne();
      }

      String var1 = "";
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "photos" + File.separator + "arbre" + this.exercicesVentes.getExevteId();
      File var3 = new File(var2);
      if (!var3.exists()) {
         var3.mkdir();
      }

      try {
         if (this.uploadedFile != null && this.foretGrume != null && this.foretGrume.getGruArbre() != null && !this.foretGrume.getGruArbre().isEmpty()) {
            var1 = this.foretGrume.getGruChantier() + ":" + this.foretGrume.getGruEssence() + ":" + this.foretGrume.getGruArbre().replaceAll("/", "_");
            String var5 = "";
            if (!this.uploadedFile.getName().endsWith("pdf") && !this.uploadedFile.getName().endsWith("PDF")) {
               var5 = ".jpg";
            } else {
               var5 = ".pdf";
            }

            File var4 = new File(var2 + File.separator + var1 + var5);
            var4.delete();
            File var6 = this.utilDownload.uniqueFile(new File(var2 + File.separator), var1 + var5);
            this.utilDownload.write(var6, this.uploadedFile.getInputStream());
         }
      } catch (IOException var7) {
      }

      if (var1 != null && !var1.isEmpty()) {
         this.foretGrume.setGruPhoto(true);
      } else {
         this.foretGrume.setGruPhoto(false);
      }

      this.showModalPanelPJ = false;
      this.showModalPanelAjoutPJ = false;
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

   public void reInitPj() {
      if (this.foretGrume != null) {
         String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "arbre" + this.exercicesVentes.getExevteId() + File.separator;
         String var2 = this.foretGrume.getGruChantier() + ":" + this.foretGrume.getGruEssence() + ":" + this.foretGrume.getGruArbre().replaceAll("/", "_");
         File var3 = new File(var1 + var2 + ".pdf");
         if (var3.exists()) {
            var3.delete();
         } else {
            var3 = new File(var1 + var2 + ".jpg");
            if (var3.exists()) {
               var3.delete();
            }
         }

         this.foretGrume.setGruPhoto(false);
      }

      this.showModalPanelPJ = false;
      this.showModalPanelAjoutPJ = false;
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
      this.var_imput_serie = this.foretInventaire.getForinvSerie();
      this.showModalPanelImput = true;
   }

   public void miseajourImput() throws IOException, JDOMException, HibernateException, NamingException, ParseException {
      if (!this.var_imput_serie.equalsIgnoreCase("X")) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ForetEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.foretInventaire.getForinvNum();
            this.foretInventaire.setForinvSerie(this.var_imput_serie);
            this.foretInventaire.setForinvNum(this.calculChrono.numCompose(this.foretInventaire.getForinvDate(), this.nature, this.foretInventaire.getForinvSerie(), var1));
            this.foretInventaireDao.modif(this.foretInventaire, var1);
            Espion var4 = new Espion();
            var4.setUsers(this.usersLog);
            var4.setEsptype(0);
            var4.setEspdtecreat(new Date());
            var4.setEspaction("Imputation Inventaire X N° " + var3 + " en Inventaire " + this.foretInventaire.getForinvSerie() + " N° " + this.foretInventaire.getForinvNum());
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

      this.annuleImputSerie();
      this.executerRequete();
   }

   public void annuleImputSerie() {
      this.setShowModalPanelImput(false);
   }

   public String calculeCheminRapport(String var1, int var2) {
      String var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "foret" + File.separator + "document" + File.separator + "inventaire" + File.separator;
      return var3;
   }

   public String calculeCheminSousRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "foret" + File.separator + "sous_rapport" + File.separator;
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

   public String calculeCheminImageProduit(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "photos" + File.separator + "arbre" + this.exercicesVentes.getExevteId() + File.separator;
      return var2;
   }

   public JRBeanCollectionDataSource calculeImpressionCommun() throws IOException {
      ArrayList var1 = new ArrayList();

      for(int var2 = 0; var2 < this.lesGrume.size(); ++var2) {
         this.foretGrume = (ForetGrume)this.lesGrume.get(var2);
         this.foretGrume.setChemin(this.calculeCheminImageProduit(this.baseLog));
         var1.add(this.foretGrume);
      }

      this.montant_lettre = this.utilNombre.begin(0.0D, this.structureLog.getStrdevise());
      JRBeanCollectionDataSource var3 = new JRBeanCollectionDataSource(var1);
      return var3;
   }

   public boolean majDateImpression(String var1) throws HibernateException, NamingException {
      boolean var2 = false;
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "ForetEntete");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         if (this.foretInventaire.getForinvDateImp() != null) {
            var2 = true;
         }

         this.foretInventaire.setForinvDateImp(new Date());
         if (this.foretInventaire.getForinvEtat() == 0 && this.foretInventaire.getForinvEtatVal() == 0 && this.usersChrono.getUsrchrValidation() == 1) {
            this.foretInventaire.setForinvEtat(1);
         }

         this.foretInventaire.setForinvModeleImp(var1);
         this.foretInventaire = this.foretInventaireDao.modif(this.foretInventaire, var3);
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

   public void impression(UtilPrint var1, int var2, int var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10, String var11) throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      if (var2 == 0) {
         if (var4 != null && !var4.isEmpty()) {
            boolean var12 = this.majDateImpression(var4);
            var1.setjRBeanCollectionDataSource(this.calculeImpressionCommun());
            var1.setRapport(var4);
            var1.setEntete("Impression inventaire chantier");
            var1.setMontant_lettre(this.montant_lettre);
            var1.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid(), this.nature));
            var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid(), this.foretInventaire.getForinvEtat()));
            var1.setDuplicata("" + var12);
            var1.setNbDecQte(this.optionsVentes.getNbDecQte());
            var1.setNbDecPu(this.optionsVentes.getNbDecPu());
            var1.setFormat(var6);
            var1.setEmetteur(var7);
            var1.setDestinataire(var8);
            var1.setDestinataireCC(var9);
            var1.setDestinataireCCI(var10);
            var1.setCorpsMail(var11);
            var1.setIdResponsable(this.foretInventaire.getForinvIdResponsable());
            var1.setIdCommercial(this.foretInventaire.getForinvIdCommercial());
            var1.setTiersSelectionne((Tiers)null);
            var1.setNature(this.nature);
            var1.setId_doc(this.foretInventaire.getForinvId());
            var1.setParc((Parc)null);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      } else if (var5 != null && !var5.isEmpty()) {
         var1.setRapport(var5);
         var1.setEntete("Impression de la liste des inventaires chantiers");
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "foret" + File.separator + "liste" + File.separator + "inventaire" + File.separator);
         var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "foret" + File.separator + "sous_rapport" + File.separator);
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
         JRBeanCollectionDataSource var13 = new JRBeanCollectionDataSource(this.lesInventaires);
         var1.setjRBeanCollectionDataSource(var13);
         var1.setBaseLog(this.baseLog);
         var1.setStructureLog(this.structureLog);
         var1.setUsersLog(this.usersLog);
         var1.imprimeRapport();
      }

      this.showModalPanelPrint = false;
   }

   public void choixDeviseImpression(String var1, float var2) {
      this.devisePrint = var1;
      this.tauxPrint = var2;
   }

   public String getUrlIpProd() {
      return StaticModePegase.getUrlIp();
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
      if (this.lesInventaires.size() != 0) {
         if (this.valQteGraph == 0) {
            this.uniteGraph = "INVENTAIRE FORET : Nombre d`arbre";
            this.deviseGraph = "";
            this.nbDecGraph = 0;
         } else if (this.valQteGraph == 1) {
            this.uniteGraph = "INVENTAIRE FORET : Nombre de documents";
            this.deviseGraph = "";
            this.nbDecGraph = 0;
         } else if (this.valQteGraph == 2) {
            this.uniteGraph = "INVENTAIRE FORET : Cubage";
            this.deviseGraph = "";
            this.nbDecGraph = 3;
         }

         this.titreGraph = "Analyse des invetnaires : ";
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
            this.sousTitreGraph = this.sousTitreGraph + " - Par equipe (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 3) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par commercial (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 4) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par série (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 5) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par chantier (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 6) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par marteau (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 15) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par essence (" + this.uniteGraph + ")";
         }

         new ForetInventaire();
         new ForetGrume();
         Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "ForetEntete");
         String var6 = "";

         ForetInventaire var14;
         for(int var7 = 0; var7 < this.lesInventaires.size(); ++var7) {
            var14 = (ForetInventaire)this.lesInventaires.get(var7);
            if (var6.isEmpty()) {
               var6 = "'" + var14.getForinvNum() + "'";
            } else {
               var6 = var6 + ",'" + var14.getForinvNum() + "'";
            }
         }

         int var11;
         int var12;
         if (this.modeGraph == 20) {
            new ArrayList();
            List var20 = this.foretGrumeDao.chargerLesLignesInventaires(var6, var5);
            if (var20.size() != 0) {
               String var17 = "";
               long var9 = 0L;
               boolean var19 = false;
               var12 = 0;

               while(true) {
                  if (var12 >= var20.size()) {
                     var1 = this.calculePourcentage((List)var1);
                     break;
                  }

                  ForetGrume var15 = (ForetGrume)var20.get(var12);
                  var17 = "";
                  var9 = 0L;
                  var11 = 0;
                  if (this.modeGraph == 0) {
                     int var13 = var15.getForetInventaire().getForinvDate().getYear() + 1900;
                     var17 = "" + var13;
                  } else if (this.modeGraph == 1) {
                     if (var15.getForetInventaire().getForinvNomResponsable() != null && !var15.getForetInventaire().getForinvNomResponsable().isEmpty()) {
                        var17 = var15.getForetInventaire().getForinvNomResponsable();
                     } else {
                        var17 = "Sans Responsable";
                     }
                  } else if (this.modeGraph == 2) {
                     if (var15.getForetInventaire().getForinvNomResponsable() != null && !var15.getForetInventaire().getForinvNomResponsable().isEmpty()) {
                        var17 = var15.getForetInventaire().getForinvNomResponsable();
                     } else {
                        var17 = "Sans Equipe";
                     }
                  } else if (this.modeGraph == 3) {
                     if (var15.getForetInventaire().getForinvNomResponsable() != null && !var15.getForetInventaire().getForinvNomResponsable().isEmpty()) {
                        var17 = var15.getForetInventaire().getForinvNomResponsable();
                     } else {
                        var17 = "Sans Commercial";
                     }
                  } else if (this.modeGraph == 4) {
                     if (var15.getForetInventaire().getForinvSerie() != null && !var15.getForetInventaire().getForinvSerie().isEmpty()) {
                        var17 = var15.getForetInventaire().getForinvSerie();
                     } else {
                        var17 = "Sans Série";
                     }
                  } else if (this.modeGraph == 5) {
                     if (var15.getGruChantier() != null && !var15.getGruChantier().isEmpty()) {
                        var17 = var15.getGruChantier();
                     } else {
                        var17 = "Sans Chantier";
                     }
                  } else if (this.modeGraph == 6) {
                     if (var15.getGruMarteau() != null && !var15.getGruMarteau().isEmpty()) {
                        var17 = var15.getGruMarteau();
                     } else {
                        var17 = "Sans Marteau";
                     }
                  } else if (this.modeGraph == 20) {
                     if (var15.getGruEssence() != null && !var15.getGruEssence().isEmpty()) {
                        var17 = var15.getGruEssence();
                     } else {
                        var17 = "Sans Essence";
                     }
                  }

                  if (this.valQteGraph == 0) {
                     ++var9;
                  } else if (this.valQteGraph == 2) {
                     ++var9;
                  } else if (this.valQteGraph == 2) {
                     var9 = (long)this.utilNombre.myRound(var15.getGruCubInv(), 3);
                  }

                  if (this.timeDecoupage == 0) {
                     var11 = var15.getGruDateInv().getDate();
                  } else if (this.timeDecoupage == 1) {
                     var11 = var15.getGruDateInv().getMonth() + 1;
                  } else if (this.timeDecoupage == 2) {
                     if (var15.getGruDateInv().getMonth() + 1 >= 1 && var15.getGruDateInv().getMonth() + 1 <= 3) {
                        var11 = 1;
                     } else if (var15.getGruDateInv().getMonth() + 1 >= 4 && var15.getGruDateInv().getMonth() + 1 <= 6) {
                        var11 = 2;
                     } else if (var15.getGruDateInv().getMonth() + 1 >= 7 && var15.getGruDateInv().getMonth() + 1 <= 9) {
                        var11 = 3;
                     } else if (var15.getGruDateInv().getMonth() + 1 >= 10 && var15.getGruDateInv().getMonth() + 1 <= 12) {
                        var11 = 4;
                     }
                  } else if (this.timeDecoupage == 3) {
                     if (var15.getGruDateInv().getMonth() + 1 >= 1 && var15.getGruDateInv().getMonth() + 1 <= 6) {
                        var11 = 1;
                     } else if (var15.getGruDateInv().getMonth() + 1 >= 7 && var15.getGruDateInv().getMonth() + 1 <= 12) {
                        var11 = 2;
                     }
                  } else if (this.timeDecoupage == 4) {
                     var11 = 1;
                  } else if (this.timeDecoupage == 5) {
                     var11 = var15.getGruDateInv().getHours();
                  }

                  var1 = this.calculeListe((List)var1, var17, var11, var9);
                  ++var12;
               }
            }
         } else if (this.lesInventaires.size() != 0) {
            String var16 = "";
            long var8 = 0L;
            boolean var10 = false;
            var11 = 0;

            while(true) {
               if (var11 >= this.lesInventaires.size()) {
                  var1 = this.calculePourcentage((List)var1);
                  break;
               }

               var14 = (ForetInventaire)this.lesInventaires.get(var11);
               var16 = "";
               var8 = 0L;
               int var18 = 0;
               if (this.modeGraph == 0) {
                  var12 = var14.getForinvDate().getYear() + 1900;
                  var16 = "" + var12;
               } else if (this.modeGraph == 1) {
                  if (var14.getForinvNomResponsable() != null && !var14.getForinvNomResponsable().isEmpty()) {
                     var16 = var14.getForinvNomResponsable();
                  } else {
                     var16 = "Sans Responsable";
                  }
               } else if (this.modeGraph == 2) {
                  if (var14.getForinvNomResponsable() != null && !var14.getForinvNomResponsable().isEmpty()) {
                     var16 = var14.getForinvNomResponsable();
                  } else {
                     var16 = "Sans Equipe";
                  }
               } else if (this.modeGraph == 3) {
                  if (var14.getForinvNomResponsable() != null && !var14.getForinvNomResponsable().isEmpty()) {
                     var16 = var14.getForinvNomResponsable();
                  } else {
                     var16 = "Sans Commercial";
                  }
               } else if (this.modeGraph == 4) {
                  if (var14.getForinvSerie() != null && !var14.getForinvSerie().isEmpty()) {
                     var16 = var14.getForinvSerie();
                  } else {
                     var16 = "Sans Série";
                  }
               } else if (this.modeGraph == 5) {
                  if (var14.getForinvChantier() != null && !var14.getForinvChantier().isEmpty()) {
                     var16 = var14.getForinvChantier();
                  } else {
                     var16 = "Sans Chantier";
                  }
               } else if (this.modeGraph == 6) {
                  if (var14.getForinvMarteau() != null && !var14.getForinvMarteau().isEmpty()) {
                     var16 = var14.getForinvMarteau();
                  } else {
                     var16 = "Sans Marteau";
                  }
               }

               if (this.valQteGraph == 0) {
                  var8 = (long)this.utilNombre.myRound((float)var14.getForinvTotArbre(), 0);
               } else if (this.valQteGraph == 1) {
                  ++var8;
               } else if (this.valQteGraph == 2) {
                  var8 = (long)this.utilNombre.myRound(var14.getForinvTotCub(), 3);
               }

               if (this.timeDecoupage == 0) {
                  var18 = var14.getForinvDate().getDate();
               } else if (this.timeDecoupage == 1) {
                  var18 = var14.getForinvDate().getMonth() + 1;
               } else if (this.timeDecoupage == 2) {
                  if (var14.getForinvDate().getMonth() + 1 >= 1 && var14.getForinvDate().getMonth() + 1 <= 3) {
                     var18 = 1;
                  } else if (var14.getForinvDate().getMonth() + 1 >= 4 && var14.getForinvDate().getMonth() + 1 <= 6) {
                     var18 = 2;
                  } else if (var14.getForinvDate().getMonth() + 1 >= 7 && var14.getForinvDate().getMonth() + 1 <= 9) {
                     var18 = 3;
                  } else if (var14.getForinvDate().getMonth() + 1 >= 10 && var14.getForinvDate().getMonth() + 1 <= 12) {
                     var18 = 4;
                  }
               } else if (this.timeDecoupage == 3) {
                  if (var14.getForinvDate().getMonth() + 1 >= 1 && var14.getForinvDate().getMonth() + 1 <= 6) {
                     var18 = 1;
                  } else if (var14.getForinvDate().getMonth() + 1 >= 7 && var14.getForinvDate().getMonth() + 1 <= 12) {
                     var18 = 2;
                  }
               } else if (this.timeDecoupage == 4) {
                  var18 = 1;
               } else if (this.timeDecoupage == 5) {
                  var18 = var14.getForinvDate().getHours();
               }

               var1 = this.calculeListe((List)var1, var16, var18, var8);
               ++var11;
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

   public UsersChrono getUsersChrono() {
      return this.usersChrono;
   }

   public void setUsersChrono(UsersChrono var1) {
      this.usersChrono = var1;
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

   public String getInpNum() {
      return this.inpNum;
   }

   public void setInpNum(String var1) {
      this.inpNum = var1;
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

   public Date getInpDate() {
      return this.inpDate;
   }

   public void setInpDate(Date var1) {
      this.inpDate = var1;
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

   public int getVar_etat() {
      return this.var_etat;
   }

   public void setVar_etat(int var1) {
      this.var_etat = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public List getMesEquipeItem() {
      return this.mesEquipeItem;
   }

   public void setMesEquipeItem(List var1) {
      this.mesEquipeItem = var1;
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

   public List getMesPersonnelsItem() {
      return this.mesPersonnelsItem;
   }

   public void setMesPersonnelsItem(List var1) {
      this.mesPersonnelsItem = var1;
   }

   public OptionParcs getOptionParcs() {
      return this.optionParcs;
   }

   public void setOptionParcs(OptionParcs var1) {
      this.optionParcs = var1;
   }

   public int getVar_option_parc() {
      return this.var_option_parc;
   }

   public void setVar_option_parc(int var1) {
      this.var_option_parc = var1;
   }

   public DataModel getDatamodelGrume() {
      return this.datamodelGrume;
   }

   public void setDatamodelGrume(DataModel var1) {
      this.datamodelGrume = var1;
   }

   public ForetInventaire getForetInventaire() {
      return this.foretInventaire;
   }

   public void setForetInventaire(ForetInventaire var1) {
      this.foretInventaire = var1;
   }

   public List getMesClassementsItem() {
      return this.mesClassementsItem;
   }

   public void setMesClassementsItem(List var1) {
      this.mesClassementsItem = var1;
   }

   public List getMesEssencesItem() {
      return this.mesEssencesItem;
   }

   public void setMesEssencesItem(List var1) {
      this.mesEssencesItem = var1;
   }

   public List getMesLieuxItem() {
      return this.mesLieuxItem;
   }

   public void setMesLieuxItem(List var1) {
      this.mesLieuxItem = var1;
   }

   public String getInpSerie() {
      return this.inpSerie;
   }

   public void setInpSerie(String var1) {
      this.inpSerie = var1;
   }

   public DataModel getDatamodelDocument() {
      return this.datamodelDocument;
   }

   public void setDatamodelDocument(DataModel var1) {
      this.datamodelDocument = var1;
   }

   public String getInpEquipe() {
      return this.inpEquipe;
   }

   public void setInpEquipe(String var1) {
      this.inpEquipe = var1;
   }

   public long getInpIdCommercial() {
      return this.inpIdCommercial;
   }

   public void setInpIdCommercial(long var1) {
      this.inpIdCommercial = var1;
   }

   public long getInpIdEquipe() {
      return this.inpIdEquipe;
   }

   public void setInpIdEquipe(long var1) {
      this.inpIdEquipe = var1;
   }

   public long getInpIdResponsable() {
      return this.inpIdResponsable;
   }

   public void setInpIdResponsable(long var1) {
      this.inpIdResponsable = var1;
   }

   public String getInpLieu() {
      return this.inpLieu;
   }

   public void setInpLieu(String var1) {
      this.inpLieu = var1;
   }

   public int getTotalArbre() {
      return this.totalArbre;
   }

   public void setTotalArbre(int var1) {
      this.totalArbre = var1;
   }

   public float getTotalCubage() {
      return this.totalCubage;
   }

   public void setTotalCubage(float var1) {
      this.totalCubage = var1;
   }

   public boolean isAffichagePump() {
      return this.affichagePump;
   }

   public void setAffichagePump(boolean var1) {
      this.affichagePump = var1;
   }

   public boolean isVar_more_search() {
      return this.var_more_search;
   }

   public void setVar_more_search(boolean var1) {
      this.var_more_search = var1;
   }

   public String getDeviseGraph() {
      return this.deviseGraph;
   }

   public void setDeviseGraph(String var1) {
      this.deviseGraph = var1;
   }

   public String getDevisePrint() {
      return this.devisePrint;
   }

   public void setDevisePrint(String var1) {
      this.devisePrint = var1;
   }

   public ForetGrume getForetGrume() {
      return this.foretGrume;
   }

   public void setForetGrume(ForetGrume var1) {
      this.foretGrume = var1;
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

   public float getTauxPrint() {
      return this.tauxPrint;
   }

   public void setTauxPrint(float var1) {
      this.tauxPrint = var1;
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

   public boolean isShowModele() {
      return this.showModele;
   }

   public void setShowModele(boolean var1) {
      this.showModele = var1;
   }

   public String getVar_imput_serie() {
      return this.var_imput_serie;
   }

   public void setVar_imput_serie(String var1) {
      this.var_imput_serie = var1;
   }

   public boolean isShowModalPanelImput() {
      return this.showModalPanelImput;
   }

   public void setShowModalPanelImput(boolean var1) {
      this.showModalPanelImput = var1;
   }

   public boolean isVisibiliteBtonlig() {
      return this.visibiliteBtonlig;
   }

   public void setVisibiliteBtonlig(boolean var1) {
      this.visibiliteBtonlig = var1;
   }

   public String getNomCreateur() {
      return this.nomCreateur;
   }

   public void setNomCreateur(String var1) {
      this.nomCreateur = var1;
   }

   public String getNomModification() {
      return this.nomModification;
   }

   public void setNomModification(String var1) {
      this.nomModification = var1;
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

   public int getModePj() {
      return this.modePj;
   }

   public void setModePj(int var1) {
      this.modePj = var1;
   }

   public boolean isShowModalPanelAjoutPJ() {
      return this.showModalPanelAjoutPJ;
   }

   public void setShowModalPanelAjoutPJ(boolean var1) {
      this.showModalPanelAjoutPJ = var1;
   }

   public boolean isShowModalPanelPJ() {
      return this.showModalPanelPJ;
   }

   public void setShowModalPanelPJ(boolean var1) {
      this.showModalPanelPJ = var1;
   }

   public int getTypeFichier() {
      return this.typeFichier;
   }

   public void setTypeFichier(int var1) {
      this.typeFichier = var1;
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

   public String getValueScanPj() {
      return this.valueScanPj;
   }

   public void setValueScanPj(String var1) {
      this.valueScanPj = var1;
   }

   public boolean isConditionPj() {
      return this.conditionPj;
   }

   public void setConditionPj(boolean var1) {
      this.conditionPj = var1;
   }

   public String getCoordonnees() {
      return this.coordonnees;
   }

   public void setCoordonnees(String var1) {
      this.coordonnees = var1;
   }

   public String getOrigine() {
      return this.origine;
   }

   public void setOrigine(String var1) {
      this.origine = var1;
   }
}
