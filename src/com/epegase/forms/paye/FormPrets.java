package com.epegase.forms.paye;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.BulletinLigne;
import com.epegase.systeme.classe.BulletinSalaire;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesPaye;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.Parapheur;
import com.epegase.systeme.classe.Salaries;
import com.epegase.systeme.classe.SalariesCapitalisation;
import com.epegase.systeme.classe.SalariesContrats;
import com.epegase.systeme.classe.SalariesPrets;
import com.epegase.systeme.classe.SalariesPretsLignes;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.dao.BulletinLigneDao;
import com.epegase.systeme.dao.BulletinSalaireDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.HabilitationDao;
import com.epegase.systeme.dao.ParapheurDao;
import com.epegase.systeme.dao.SalariesCapitalisationDao;
import com.epegase.systeme.dao.SalariesContratsDao;
import com.epegase.systeme.dao.SalariesDao;
import com.epegase.systeme.dao.SalariesPretsDao;
import com.epegase.systeme.dao.SalariesPretsLignesDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.utilitaires.FormUtilitaires;
import com.epegase.systeme.xml.LectureNaturePrets;
import com.epegase.systeme.xml.ObjetCompte;
import com.epegase.systeme.xml.ObjetLigneOnglet;
import com.epegase.systeme.xml.OptionPaye;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
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

public class FormPrets implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private int var_action = 0;
   private int var_memo_action = 0;
   private String pageIndex;
   private int nature;
   private List mesOnglets;
   private OptionPaye optionPaye;
   private ExercicesPaye exercicesPaye;
   private ExercicesPaye lastExoPaye;
   private EspionDao espionDao;
   private HabilitationDao habilitationDao;
   private CalculChrono calculChrono;
   private UsersChrono usersChronoPret;
   private UsersChronoDao usersChronoDao;
   private int var_nb_max = 100;
   private String nomSalarie;
   private boolean valideSalarie;
   private boolean var_acc_prets = false;
   private boolean var_ajt = false;
   private boolean var_mod = false;
   private boolean var_sup = false;
   private boolean var_imp = false;
   private boolean accesPrets;
   private boolean accesInterim;
   private boolean var_more_search = false;
   private List mesNatureAgentItems;
   private List mesServiceItems;
   private List mesCentresImpotsItems;
   private List mesCentresSecuritesItems;
   private List mesClassementsItems;
   private List mesNiveauxEmploisItems;
   private List mesCodesEmploisItems;
   private List mesConventionsItems;
   private List mesGrillesItems = new ArrayList();
   private List lesGrilles = new ArrayList();
   private List mesCiviliteItems;
   private List lesCivilites;
   private List mesPaysUtilItems = new ArrayList();
   private List mesPaysItems;
   private List lesPays;
   private List mesNationnalitesItems;
   private List mesLanguesItems;
   private List mesActiviteItems;
   private List mesBudgetItems;
   private List mesProjetItems;
   private List mesParcItems;
   private List mesFeuillesItems;
   private List mesFeuillesContratItems;
   private List mesClesItems;
   private boolean afficheCodesEmplois;
   private Date parMois = new Date();
   private String var_immat_rec = "";
   private String var_nom_rec = "";
   private String var_feuille_rec = "100";
   private String var_nature_rec = "100";
   private String var_site_rec = "100";
   private String var_departement_rec = "100";
   private String var_service_rec = "100";
   private String var_activite_rec = "100";
   private String var_projet_rec = "100";
   private String var_convention_rec = "100";
   private String var_niveau_rec = "100";
   private String var_classement_rec = "100";
   private String var_grille_rec = "100";
   private String var_centre_rec = "100";
   private String var_pays_rec = "100";
   private String var_periode = "";
   private int var_etat_rec = 0;
   private int var_valide_rec = 100;
   private int var_rh_rec = 100;
   private int var_pret_rec = 100;
   private int var_nat_rec = 100;
   private String var_budget_rec;
   private String var_tiers_rec;
   private Date inpDu;
   private Date inpAu;
   private Salaries salaries;
   private SalariesDao salariesDao;
   private boolean var_affiche_bouton = false;
   private boolean showModalVisuEtat = false;
   private SalariesPrets salariesPrets;
   private SalariesPretsDao salariesPretsDao;
   private transient DataModel dataModelPrets;
   private UIDataTable extDTable;
   private SimpleSelection simpleSelectionEntete;
   private SalariesPretsLignes salariesPretsLignes;
   private SalariesPretsLignesDao salariesPretsLignesDao;
   private transient DataModel dataModelPretsLignes;
   private List lesSalariesPretsLignes;
   private List lesSalariesPrets;
   private boolean showModalPanelPretsLignes = false;
   private boolean var_affiche_prets = false;
   private int var_action_prets;
   private boolean var_affiche_lignes = false;
   private int var_action_ligne;
   private int var_choix_ligne;
   private double var_memo_echeance;
   private boolean var_change_echeance = false;
   private double total_pret;
   private double total_rmb;
   private double solde_pret;
   private String var_lib_pret;
   private int typePret;
   private boolean ajoutPret = false;
   private int numLignePret;
   private double var_montant_echeance;
   private SalariesCapitalisation salariesCapitalisation;
   private SalariesCapitalisationDao salariesCapitalisationDao;
   private List lesLignesCapitalisation;
   private transient DataModel dataModelCapitalisation;
   private double total_versement;
   private double total_retrait;
   private double solde_capitalisation;
   private boolean showModalPanelCapitalisation = false;
   private boolean capitalisationActive = false;
   private List documentImpressionItems = new ArrayList();
   private List listeImpressionItems = new ArrayList();
   private boolean showModalPanelPrint = false;
   private int var_modele;
   private FormRecherche formRecherche;
   private UtilDate utilDate;
   private BulletinLigne bulletinLigne;
   private BulletinLigneDao bulletinLigneDao;
   private BulletinSalaire bulletinSalaire;
   private BulletinSalaireDao bulletinSalaireDao;
   private transient DataModel dataModelLotPret;
   private List lesSalaries;
   private Date dateDebut;
   private Date dateFin;
   private double montantPret;
   private int naturePret;
   private Date dateDebutPret;
   private int nbEcheancePret;
   private String observation;
   private String responsable;
   private List mesNaturesPretsItems;
   private boolean showModalPanelInformation = false;
   private String nomCreation;
   private String nomModification;
   private List lesContratsActifsItems;
   private SalariesContratsDao salariesContratsDao;
   private List mesTiersItems;

   public FormPrets() throws IOException {
      this.salariesPrets = new SalariesPrets(this.mesNaturesPretsItems);
      this.dataModelPrets = new ListDataModel();
      this.simpleSelectionEntete = new SimpleSelection();
      this.extDTable = new HtmlExtendedDataTable();
      this.lesSalariesPrets = new ArrayList();
      this.dataModelPretsLignes = new ListDataModel();
      this.lesSalariesPretsLignes = new ArrayList();
      this.usersChronoPret = new UsersChrono();
      this.lesLignesCapitalisation = new ArrayList();
      this.dataModelCapitalisation = new ListDataModel();
      this.mesFeuillesContratItems = new ArrayList();
      this.utilDate = new UtilDate();
      this.dataModelLotPret = new ListDataModel();
      this.lesSalaries = new ArrayList();
      this.mesNaturesPretsItems = new ArrayList();
      this.mesTiersItems = new ArrayList();
      this.lesContratsActifsItems = new ArrayList();
   }

   public void InstancesDaoUtilses() {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.salariesDao = new SalariesDao(this.baseLog, this.utilInitHibernate);
      this.salariesCapitalisationDao = new SalariesCapitalisationDao(this.baseLog, this.utilInitHibernate);
      this.salariesPretsDao = new SalariesPretsDao(this.baseLog, this.utilInitHibernate);
      this.salariesPretsLignesDao = new SalariesPretsLignesDao(this.baseLog, this.utilInitHibernate);
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.salariesContratsDao = new SalariesContratsDao(this.baseLog, this.utilInitHibernate);
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.habilitationDao = new HabilitationDao(this.baseLog, this.utilInitHibernate);
      this.bulletinLigneDao = new BulletinLigneDao(this.baseLog, this.utilInitHibernate);
      this.bulletinSalaireDao = new BulletinSalaireDao(this.baseLog, this.utilInitHibernate);
   }

   public void initialisationPret(Session var1) throws HibernateException, NamingException, JDOMException, IOException {
      if (this.optionPaye.getNbLigneMax() != null && !this.optionPaye.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionPaye.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      if (this.optionPaye.getRubVersement() != null && !this.optionPaye.getRubVersement().isEmpty() && !this.optionPaye.getRubVersement().equals("null")) {
         this.capitalisationActive = true;
      } else {
         this.capitalisationActive = false;
      }

      this.var_pret_rec = 100;
      this.usersChronoPret = this.usersChronoDao.chronoByUserNat(this.usersLog, 87, var1);
      this.accesResteintUser();
      this.accesResteintGroupe();
      this.autorisationPrets();
      LectureNaturePrets var2 = new LectureNaturePrets();
      var2.setStrId(this.structureLog.getStrid());
      var2.setStructureLog(this.structureLog);
      this.mesNaturesPretsItems = var2.chargerMesNaturesPretsItems();
      if (this.mesCodesEmploisItems != null && this.mesCodesEmploisItems.size() != 0) {
         this.afficheCodesEmplois = true;
      } else {
         this.afficheCodesEmplois = false;
      }

   }

   public void accesResteintUser() {
   }

   public void accesResteintGroupe() throws HibernateException, NamingException {
      this.var_acc_prets = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (!var1.getCode().equals("1") && !var1.getCode().equals("2") && !var1.getCode().equals("3") && !var1.getCode().equals("4") && !var1.getCode().equals("5") && !var1.getCode().equals("6") && !var1.getCode().equals("7")) {
               if (var1.getCode().equals("8")) {
                  if (this.usersChronoPret != null) {
                     this.var_acc_prets = true;
                  }
               } else if (!var1.getCode().equals("9") && var1.getCode().equals("10")) {
               }
            }
         }
      }

   }

   public void autorisationPrets() throws HibernateException, NamingException {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("8")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

      this.salariesPrets = null;
      this.salariesPretsLignes = null;
      this.var_affiche_prets = false;
      this.var_affiche_lignes = false;
      this.lesSalariesPretsLignes.clear();
   }

   public int calculCivilite(String var1) {
      int var2 = 0;
      if (this.lesCivilites.size() != 0) {
         for(int var3 = 0; var3 < this.lesCivilites.size(); ++var3) {
            if (((ObjetCompte)this.lesCivilites.get(var3)).getNom_FR().equalsIgnoreCase(var1)) {
               var2 = Integer.parseInt(((ObjetCompte)this.lesCivilites.get(var3)).getSens());
               if (var2 == 2) {
                  var2 = 0;
               }
               break;
            }
         }
      }

      return var2;
   }

   public String getUrlIp() {
      return StaticModePegase.getUrlIp();
   }

   public Habilitation verifHabilitation(int var1, Session var2) throws HibernateException, NamingException {
      new Habilitation();
      Habilitation var3 = this.habilitationDao.existenceHabilitation(var1, var2);
      return var3;
   }

   public void chargerUserChronoPret(Session var1) throws HibernateException, NamingException {
      this.usersChronoPret = this.usersChronoDao.selectUnique("", 87, this.usersLog, var1);
   }

   public void moreSearch() {
      if (!this.var_more_search) {
         this.var_more_search = true;
      } else {
         this.var_more_search = false;
         this.var_convention_rec = "100";
      }

   }

   public void recupererPrets() {
      this.total_pret = 0.0D;
      this.total_rmb = 0.0D;
      this.solde_pret = 0.0D;
      this.lesSalariesPrets.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      this.dataModelPrets.setWrappedData(this.lesSalariesPrets);
      this.lesSalariesPretsLignes.clear();
      this.dataModelPretsLignes.setWrappedData(this.lesSalariesPretsLignes);
      this.var_affiche_prets = false;
   }

   public void rechercherSalariePret() throws HibernateException, NamingException, ParseException {
      if (this.var_pret_rec != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         long var2 = 0L;
         if (this.accesInterim) {
            if (this.var_tiers_rec != null && !this.var_tiers_rec.isEmpty() && this.var_tiers_rec.equals("100")) {
               var2 = 0L;
            } else if (this.var_tiers_rec != null && !this.var_tiers_rec.isEmpty() && this.var_tiers_rec.equals("101")) {
               var2 = -1L;
            } else if (this.var_tiers_rec != null && !this.var_tiers_rec.isEmpty() && !this.var_tiers_rec.equals("101") && !this.var_tiers_rec.equals("100")) {
               var2 = Long.parseLong(this.var_tiers_rec);
            } else {
               var2 = -1L;
            }
         }

         if (this.var_pret_rec == 1) {
            this.lesSalariesPrets.clear();
            this.lesSalariesPrets = this.salariesPretsDao.chargerTouslesPrets(var2, this.var_pret_rec, this.var_nat_rec, this.var_valide_rec, this.var_etat_rec, this.var_feuille_rec, this.var_nature_rec, this.var_site_rec, this.var_departement_rec, this.var_service_rec, this.var_activite_rec, this.var_convention_rec, this.var_niveau_rec, this.var_classement_rec, this.var_grille_rec, this.var_centre_rec, this.nomSalarie, var1);
            this.dataModelPrets.setWrappedData(this.lesSalariesPrets);
         } else if (this.var_pret_rec == 2) {
            this.lesSalariesPrets.clear();
            this.lesSalariesPrets = this.salariesPretsDao.chargerTouslesPrets(var2, this.var_pret_rec, this.var_nat_rec, this.var_valide_rec, this.var_etat_rec, this.var_feuille_rec, this.var_nature_rec, this.var_site_rec, this.var_departement_rec, this.var_service_rec, this.var_activite_rec, this.var_convention_rec, this.var_niveau_rec, this.var_classement_rec, this.var_grille_rec, this.var_centre_rec, this.nomSalarie, var1);
            this.dataModelPrets.setWrappedData(this.lesSalariesPrets);
         } else if (this.var_pret_rec == 3) {
            this.lesSalariesPrets.clear();
            this.lesSalariesPrets = this.salariesPretsDao.chargerTouslesPrets(var2, this.var_pret_rec, this.var_nat_rec, this.var_valide_rec, this.var_etat_rec, this.var_feuille_rec, this.var_nature_rec, this.var_site_rec, this.var_departement_rec, this.var_service_rec, this.var_activite_rec, this.var_convention_rec, this.var_niveau_rec, this.var_classement_rec, this.var_grille_rec, this.var_centre_rec, this.nomSalarie, var1);
            this.dataModelPrets.setWrappedData(this.lesSalariesPrets);
         } else if (this.var_pret_rec == 9) {
            this.lesSalariesPrets.clear();
            this.lesSalariesPrets = this.salariesPretsDao.chargerTouslesPrets(var2, 9, this.var_nat_rec, this.var_valide_rec, this.var_etat_rec, this.var_feuille_rec, this.var_nature_rec, this.var_site_rec, this.var_departement_rec, this.var_service_rec, this.var_activite_rec, this.var_convention_rec, this.var_niveau_rec, this.var_classement_rec, this.var_grille_rec, this.var_centre_rec, this.nomSalarie, var1);
            this.dataModelPrets.setWrappedData(this.lesSalariesPrets);
         } else if (this.var_pret_rec == 11) {
            this.lesSalariesPrets.clear();
            this.lesSalariesPrets = this.salariesPretsDao.chargerTouslesPrets(var2, this.var_pret_rec, this.var_nat_rec, this.var_valide_rec, this.var_etat_rec, this.var_feuille_rec, this.var_nature_rec, this.var_site_rec, this.var_departement_rec, this.var_service_rec, this.var_activite_rec, this.var_convention_rec, this.var_niveau_rec, this.var_classement_rec, this.var_grille_rec, this.var_centre_rec, this.nomSalarie, var1);
            this.dataModelPrets.setWrappedData(this.lesSalariesPrets);
         } else if (this.var_pret_rec == 12) {
            this.lesSalariesPrets.clear();
            this.lesSalariesPrets = this.salariesPretsDao.chargerTouslesPrets(var2, this.var_pret_rec, this.var_nat_rec, this.var_valide_rec, this.var_etat_rec, this.var_feuille_rec, this.var_nature_rec, this.var_site_rec, this.var_departement_rec, this.var_service_rec, this.var_activite_rec, this.var_convention_rec, this.var_niveau_rec, this.var_classement_rec, this.var_grille_rec, this.var_centre_rec, this.nomSalarie, var1);
            this.dataModelPrets.setWrappedData(this.lesSalariesPrets);
         } else if (this.var_pret_rec == 13) {
            this.lesSalariesPrets.clear();
            this.lesSalariesPrets = this.salariesPretsDao.chargerTouslesPrets(var2, this.var_pret_rec, this.var_nat_rec, this.var_valide_rec, this.var_etat_rec, this.var_feuille_rec, this.var_nature_rec, this.var_site_rec, this.var_departement_rec, this.var_service_rec, this.var_activite_rec, this.var_convention_rec, this.var_niveau_rec, this.var_classement_rec, this.var_grille_rec, this.var_centre_rec, this.nomSalarie, var1);
            this.dataModelPrets.setWrappedData(this.lesSalariesPrets);
         } else if (this.var_pret_rec == 19) {
            this.lesSalariesPrets.clear();
            this.lesSalariesPrets = this.salariesPretsDao.chargerTouslesPrets(var2, 19, this.var_nat_rec, this.var_valide_rec, this.var_etat_rec, this.var_feuille_rec, this.var_nature_rec, this.var_site_rec, this.var_departement_rec, this.var_service_rec, this.var_activite_rec, this.var_convention_rec, this.var_niveau_rec, this.var_classement_rec, this.var_grille_rec, this.var_centre_rec, this.nomSalarie, var1);
            this.dataModelPrets.setWrappedData(this.lesSalariesPrets);
         } else if (this.var_pret_rec == 21) {
            this.lesSalariesPrets.clear();
            this.lesSalariesPrets = this.salariesPretsDao.chargerTouslesPrets(var2, this.var_pret_rec, this.var_nat_rec, this.var_valide_rec, this.var_etat_rec, this.var_feuille_rec, this.var_nature_rec, this.var_site_rec, this.var_departement_rec, this.var_service_rec, this.var_activite_rec, this.var_convention_rec, this.var_niveau_rec, this.var_classement_rec, this.var_grille_rec, this.var_centre_rec, this.nomSalarie, var1);
            this.dataModelPrets.setWrappedData(this.lesSalariesPrets);
         } else if (this.var_pret_rec == 22) {
            this.lesSalariesPrets.clear();
            this.lesSalariesPrets = this.salariesPretsDao.chargerTouslesPrets(var2, this.var_pret_rec, this.var_nat_rec, this.var_valide_rec, this.var_etat_rec, this.var_feuille_rec, this.var_nature_rec, this.var_site_rec, this.var_departement_rec, this.var_service_rec, this.var_activite_rec, this.var_convention_rec, this.var_niveau_rec, this.var_classement_rec, this.var_grille_rec, this.var_centre_rec, this.nomSalarie, var1);
            this.dataModelPrets.setWrappedData(this.lesSalariesPrets);
         } else if (this.var_pret_rec == 23) {
            this.lesSalariesPrets.clear();
            this.lesSalariesPrets = this.salariesPretsDao.chargerTouslesPrets(var2, this.var_pret_rec, this.var_nat_rec, this.var_valide_rec, this.var_etat_rec, this.var_feuille_rec, this.var_nature_rec, this.var_site_rec, this.var_departement_rec, this.var_service_rec, this.var_activite_rec, this.var_convention_rec, this.var_niveau_rec, this.var_classement_rec, this.var_grille_rec, this.var_centre_rec, this.nomSalarie, var1);
            this.dataModelPrets.setWrappedData(this.lesSalariesPrets);
         } else if (this.var_pret_rec == 29) {
            this.lesSalariesPrets.clear();
            this.lesSalariesPrets = this.salariesPretsDao.chargerTouslesPrets(var2, 29, this.var_nat_rec, this.var_valide_rec, this.var_etat_rec, this.var_feuille_rec, this.var_nature_rec, this.var_site_rec, this.var_departement_rec, this.var_service_rec, this.var_activite_rec, this.var_convention_rec, this.var_niveau_rec, this.var_classement_rec, this.var_grille_rec, this.var_centre_rec, this.nomSalarie, var1);
            this.dataModelPrets.setWrappedData(this.lesSalariesPrets);
         } else {
            List var4;
            Date var5;
            Date var6;
            int var7;
            if (this.var_pret_rec == 31 && this.parMois != null) {
               this.lesSalariesPrets.clear();
               new ArrayList();
               if (this.parMois == null) {
                  this.parMois = new Date();
               }

               var5 = this.utilDate.datePremierJourMois(this.parMois);
               var6 = this.utilDate.dateDernierJourMois(this.parMois);
               var4 = this.salariesPretsLignesDao.chargerlesPretsLignesValidePeriode(var5, var6, 9, var1);
               this.lesSalariesPrets.clear();
               if (var4.size() != 0) {
                  for(var7 = 0; var7 < var4.size(); ++var7) {
                     this.salariesPretsLignes = (SalariesPretsLignes)var4.get(var7);
                     this.calculeEcheancePret();
                  }
               }

               this.dataModelPrets.setWrappedData(this.lesSalariesPrets);
            } else if (this.var_pret_rec == 32 && this.nomSalarie != null && !this.nomSalarie.isEmpty()) {
               this.lesSalariesPrets.clear();
               this.lesSalariesPrets = this.salariesPretsDao.chargerTouslesPrets(var2, 29, this.var_nat_rec, this.var_valide_rec, this.var_etat_rec, this.var_feuille_rec, this.var_nature_rec, this.var_site_rec, this.var_departement_rec, this.var_service_rec, this.var_activite_rec, this.var_convention_rec, this.var_niveau_rec, this.var_classement_rec, this.var_grille_rec, this.var_centre_rec, this.nomSalarie, var1);
               this.dataModelPrets.setWrappedData(this.lesSalariesPrets);
            } else if (this.var_pret_rec == 33 && this.parMois != null) {
               this.lesSalariesPrets.clear();
               new ArrayList();
               if (this.parMois == null) {
                  this.parMois = new Date();
               }

               var5 = this.utilDate.stringToDateSQLLight("2000-01-01");
               var6 = this.utilDate.dateDernierJourMois(this.parMois);
               var4 = this.salariesPretsLignesDao.chargerlesPretsLignesValidePeriode(var5, var6, 9, var1);
               this.lesSalariesPrets.clear();
               if (var4.size() != 0) {
                  for(var7 = 0; var7 < var4.size(); ++var7) {
                     this.salariesPretsLignes = (SalariesPretsLignes)var4.get(var7);
                     this.calculeEcheancePret();
                  }
               }

               this.dataModelPrets.setWrappedData(this.lesSalariesPrets);
            }
         }

         this.lesSalariesPretsLignes.clear();
         this.dataModelPretsLignes.setWrappedData(this.lesSalariesPretsLignes);
         this.utilInitHibernate.closeSession();
         this.var_affiche_prets = false;
      }

   }

   public void calculeEcheancePret() {
      this.salariesPrets = new SalariesPrets(this.mesNaturesPretsItems);
      this.salariesPrets.setLib_nature(this.salariesPretsLignes.getSalariesPrets().getLib_nature());
      this.salariesPrets.setLibelleEtat(this.salariesPretsLignes.getSalariesPrets().getLibelleEtat());
      this.salariesPrets.setSalaries(this.salariesPretsLignes.getSalariesPrets().getSalaries());
      this.salariesPrets.setSalpreDateCreat(this.salariesPretsLignes.getSalariesPrets().getSalpreDateCreat());
      this.salariesPrets.setSalpreDateDebut(this.salariesPretsLignes.getSalariesPrets().getSalpreDateDebut());
      this.salariesPrets.setSalpreDateImp(this.salariesPretsLignes.getSalariesPrets().getSalpreDateImp());
      this.salariesPrets.setSalpreDateModif(this.salariesPretsLignes.getSalariesPrets().getSalpreDateModif());
      this.salariesPrets.setSalpreDateSouscription(this.salariesPretsLignes.getSalariesPrets().getSalpreDateSouscription());
      this.salariesPrets.setSalpreDateValide(this.salariesPretsLignes.getSalariesPrets().getSalpreDateValide());
      this.salariesPrets.setSalpreDescriptif(this.salariesPretsLignes.getSalariesPrets().getSalpreDescriptif());
      this.salariesPrets.setSalpreEcheance(this.salariesPretsLignes.getSalariesPrets().getSalpreEcheance());
      this.salariesPrets.setSalpreEtat(this.salariesPretsLignes.getSalariesPrets().getSalpreEtat());
      this.salariesPrets.setSalpreEtatVal(this.salariesPretsLignes.getSalariesPrets().getSalpreEtatVal());
      this.salariesPrets.setSalpreId(this.salariesPretsLignes.getSalariesPrets().getSalpreId());
      this.salariesPrets.setSalpreJournal(this.salariesPretsLignes.getSalariesPrets().getSalpreJournal());
      this.salariesPrets.setSalpreMontant(this.salariesPretsLignes.getSalariesPrets().getSalpreMontant());
      this.salariesPrets.setSalpreNature(this.salariesPretsLignes.getSalariesPrets().getSalpreNature());
      this.salariesPrets.setSalpreNum(this.salariesPretsLignes.getSalariesPrets().getSalpreNum());
      this.salariesPrets.setSalpreObjet(this.salariesPretsLignes.getSalariesPrets().getSalpreObjet());
      this.salariesPrets.setSalpreReference(this.salariesPretsLignes.getSalariesPrets().getSalpreReference());
      this.salariesPrets.setSalpreResponsable(this.salariesPretsLignes.getSalariesPrets().getSalpreResponsable());
      this.salariesPrets.setSalpreRmb(this.salariesPretsLignes.getSalariesPrets().getSalpreRmb());
      this.salariesPrets.setSalpreService(this.salariesPretsLignes.getSalariesPrets().getSalpreService());
      this.salariesPrets.setSalpreType(this.salariesPretsLignes.getSalariesPrets().getSalpreType());
      this.salariesPrets.setSalpreUserCreat(this.salariesPretsLignes.getSalariesPrets().getSalpreUserCreat());
      this.salariesPrets.setSalpreUserModif(this.salariesPretsLignes.getSalariesPrets().getSalpreUserModif());
      this.salariesPrets.setDate_echeance(this.salariesPretsLignes.getSalpreligDateTheo());
      this.salariesPrets.setMontant_echeance(this.salariesPretsLignes.getSalpreligMontantTheo());
      this.lesSalariesPrets.add(this.salariesPrets);
   }

   public void calculePret() {
      this.lesSalariesPrets.clear();
      this.dataModelPrets.setWrappedData(this.lesSalariesPrets);
      this.lesSalariesPretsLignes.clear();
      this.dataModelPretsLignes.setWrappedData(this.lesSalariesPretsLignes);
      this.var_affiche_prets = false;
      if (this.var_pret_rec != 9 && this.var_pret_rec != 19 && this.var_pret_rec != 29 && this.var_pret_rec != 31 && this.var_pret_rec != 32 && this.var_pret_rec != 33) {
         this.ajoutPret = true;
      } else {
         this.ajoutPret = false;
      }

   }

   public void selectionPret() throws HibernateException, NamingException {
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
            this.salariesPrets = (SalariesPrets)var1.get(0);
            this.salaries = this.salariesPrets.getSalaries();
            if (this.var_pret_rec != 1 && this.var_pret_rec != 11 && this.var_pret_rec != 21) {
               if (this.var_pret_rec != 2 && this.var_pret_rec != 12 && this.var_pret_rec != 22) {
                  if (this.var_pret_rec == 3 || this.var_pret_rec == 13 || this.var_pret_rec == 23) {
                     this.var_lib_pret = "Prêt manuel";
                  }
               } else {
                  this.var_lib_pret = "Prêt externe";
               }
            } else {
               this.var_lib_pret = "Prêt interne";
            }

            this.lesSalariesPretsLignes.clear();
            this.lesSalariesPretsLignes = this.salariesPretsLignesDao.chargerlesPretsLignes(this.salariesPrets, (Session)null);
            this.calculTotalPret();
            this.dataModelPretsLignes.setWrappedData(this.lesSalariesPretsLignes);
            this.var_affiche_lignes = false;
            this.var_montant_echeance = 0.0D;
            if (this.salaries.getSalProtege() == 1) {
               if (this.usersLog.getUsrPaye() != 0 && this.usersLog.getUsrPaye() != 2 && this.usersLog.getUsrPaye() != 3) {
                  this.var_affiche_prets = false;
               } else {
                  this.var_affiche_prets = true;
               }
            } else {
               this.var_affiche_prets = true;
            }

            this.calculContrat((Session)null);
         } else {
            this.var_affiche_prets = false;
         }
      } else {
         this.var_affiche_prets = false;
      }

   }

   public void visualisationPret() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.salariesPrets != null) {
         if (this.salaries.getSalProtege() == 1) {
            if (this.usersLog.getUsrPaye() != 0 && this.usersLog.getUsrPaye() != 2 && this.usersLog.getUsrPaye() != 3) {
               this.var_affiche_prets = false;
            } else {
               this.var_affiche_prets = true;
            }
         } else {
            this.var_affiche_prets = true;
         }

         if (this.var_affiche_prets) {
            if (this.salariesPrets.getSalpreEtat() == 0) {
               this.modifierPret();
            } else {
               this.consulterPret();
            }
         }
      }

   }

   public void calculTotalPret() {
      this.total_pret = this.salariesPrets.getSalpreMontant();
      this.total_rmb = 0.0D;
      this.solde_pret = 0.0D;
      this.numLignePret = 0;
      if (this.lesSalariesPretsLignes.size() != 0) {
         for(int var1 = 0; var1 < this.lesSalariesPretsLignes.size(); ++var1) {
            this.total_rmb += ((SalariesPretsLignes)this.lesSalariesPretsLignes.get(var1)).getSalpreligMontantReel();
         }
      }

      this.solde_pret = this.total_pret - this.total_rmb;
   }

   public void calculContrat(Session var1) throws HibernateException, NamingException {
      if (this.salaries != null) {
         this.lesContratsActifsItems.clear();
         new ArrayList();
         List var2 = this.salariesContratsDao.chargerlesContrats(this.salaries, var1);
         if (var2.size() != 0) {
            new SalariesContrats();

            for(int var4 = 0; var4 < var2.size(); ++var4) {
               SalariesContrats var3 = (SalariesContrats)var2.get(var4);
               this.lesContratsActifsItems.add(new SelectItem(var3.getSalconNum(), var3.getSalconNum() + " - (Feuille N° " + var3.getSalconFeuille() + ")"));
            }
         }
      }

   }

   public void ajouterPret() throws HibernateException, NamingException, ParseException {
      this.nomSalarie = "";
      String var1;
      String[] var2;
      if (this.var_pret_rec != 1 && this.var_pret_rec != 11 && this.var_pret_rec != 21) {
         if (this.var_pret_rec != 2 && this.var_pret_rec != 12 && this.var_pret_rec != 22) {
            if (this.var_pret_rec == 3 || this.var_pret_rec == 13 || this.var_pret_rec == 23) {
               this.var_lib_pret = "Prêt manuel";
               this.salaries = new Salaries();
               this.salariesPrets = new SalariesPrets(this.mesNaturesPretsItems);
               this.salariesPrets.setSalpreType(2);
               this.salariesPrets.setSalpreDateSouscription(new Date());
               this.lesSalariesPretsLignes.clear();
               this.dataModelPretsLignes.setWrappedData(this.lesSalariesPretsLignes);
               if (this.nomSalarie != null && !this.nomSalarie.isEmpty()) {
                  var1 = "";
                  if (this.nomSalarie.contains(":")) {
                     var2 = this.nomSalarie.split(":");
                     var1 = var2[0];
                  } else {
                     var1 = this.nomSalarie;
                  }

                  this.salaries = this.salariesDao.chercherIdSalaries(var1, (Session)null);
                  if (this.salaries != null) {
                     this.nomSalarie = this.salaries.getSalMatricule() + ":" + this.salaries.getSalNom();
                  } else {
                     this.salaries = new Salaries();
                     this.nomSalarie = "";
                  }
               }

               this.calculContrat((Session)null);
               this.var_action = 1;
               this.var_memo_action = this.var_action;
            }
         } else {
            this.var_lib_pret = "Prêt externe";
            this.salaries = new Salaries();
            this.salariesPrets = new SalariesPrets(this.mesNaturesPretsItems);
            this.salariesPrets.setSalpreType(1);
            this.salariesPrets.setSalpreDateSouscription(new Date());
            this.lesSalariesPretsLignes.clear();
            this.dataModelPretsLignes.setWrappedData(this.lesSalariesPretsLignes);
            if (this.nomSalarie != null && !this.nomSalarie.isEmpty()) {
               var1 = "";
               if (this.nomSalarie.contains(":")) {
                  var2 = this.nomSalarie.split(":");
                  var1 = var2[0];
               } else {
                  var1 = this.nomSalarie;
               }

               this.salaries = this.salariesDao.chercherIdSalaries(var1, (Session)null);
               if (this.salaries != null) {
                  this.nomSalarie = this.salaries.getSalMatricule() + ":" + this.salaries.getSalNom();
               } else {
                  this.salaries = new Salaries();
                  this.nomSalarie = "";
               }
            }

            this.var_action = 1;
            this.var_memo_action = this.var_action;
         }
      } else {
         this.var_lib_pret = "Prêt interne";
         this.salaries = new Salaries();
         this.salariesPrets = new SalariesPrets(this.mesNaturesPretsItems);
         this.salariesPrets.setSalpreType(0);
         this.salariesPrets.setSalpreDateSouscription(new Date());
         this.salariesPrets.setSalpreDateDebut(this.utilDate.dateDernierJourMois(new Date()));
         this.lesSalariesPretsLignes.clear();
         this.dataModelPretsLignes.setWrappedData(this.lesSalariesPretsLignes);
         if (this.nomSalarie != null && !this.nomSalarie.isEmpty()) {
            var1 = "";
            if (this.nomSalarie.contains(":")) {
               var2 = this.nomSalarie.split(":");
               var1 = var2[0];
            } else {
               var1 = this.nomSalarie;
            }

            this.salaries = this.salariesDao.chercherIdSalaries(var1, (Session)null);
            if (this.salaries != null) {
               this.nomSalarie = this.salaries.getSalMatricule() + ":" + this.salaries.getSalNom();
            } else {
               this.salaries = new Salaries();
               this.nomSalarie = "";
            }
         }

         this.var_action = 1;
         this.var_memo_action = this.var_action;
      }

      this.total_pret = 0.0D;
      this.total_rmb = 0.0D;
      this.solde_pret = 0.0D;
      this.var_montant_echeance = 0.0D;
   }

   public void modifierPret() {
      if (this.salariesPrets != null) {
         if (this.salaries.getSalProtege() == 1) {
            if (this.usersLog.getUsrPaye() != 0 && this.usersLog.getUsrPaye() != 2 && this.usersLog.getUsrPaye() != 3) {
               this.var_affiche_prets = false;
            } else {
               this.var_affiche_prets = true;
            }
         } else {
            this.var_affiche_prets = true;
         }

         if (this.var_affiche_prets) {
            this.salaries = this.salariesPrets.getSalaries();
            this.var_lib_pret = this.salariesPrets.getLib_type();
            this.var_action = 2;
            this.var_memo_action = this.var_action;
         }
      }

   }

   public void consulterPret() {
      if (this.salariesPrets != null) {
         if (this.salaries.getSalProtege() == 1) {
            if (this.usersLog.getUsrPaye() != 0 && this.usersLog.getUsrPaye() != 2 && this.usersLog.getUsrPaye() != 3) {
               this.var_affiche_prets = false;
            } else {
               this.var_affiche_prets = true;
            }
         } else {
            this.var_affiche_prets = true;
         }

         if (this.var_affiche_prets) {
            this.salaries = this.salariesPrets.getSalaries();
            this.var_lib_pret = this.salariesPrets.getLib_type();
            this.var_action = 3;
            this.var_memo_action = this.var_action;
         }
      }

   }

   public void supprimerPret() throws HibernateException, NamingException {
      if (this.salariesPrets != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.lesSalariesPretsLignes.size() != 0) {
               this.salariesPretsLignesDao.deleteAllLigne(this.lesSalariesPretsLignes, var1);
               this.lesSalariesPretsLignes.clear();
               this.dataModelPretsLignes.setWrappedData(this.lesSalariesPretsLignes);
            }

            Habilitation var3 = this.verifHabilitation(87, var1);
            if (var3 != null) {
               new Parapheur();
               ParapheurDao var5 = new ParapheurDao(this.baseLog, this.utilInitHibernate);
               Parapheur var4 = var5.existenceParapheur(this.salariesPrets.getSalpreId(), 87, var1);
               if (var4 != null) {
                  var5.delete(var4, var1);
               }
            }

            this.lesSalariesPrets.remove(this.salariesPrets);
            this.dataModelPrets.setWrappedData(this.lesSalariesPrets);
            this.salariesPrets = this.salariesPretsDao.pourParapheur(this.salariesPrets.getSalpreId(), var1);
            if (this.salariesPrets != null) {
               this.salariesPretsDao.delete(this.salariesPrets, var1);
            }

            var2.commit();
         } catch (HibernateException var9) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var9;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.var_affiche_prets = false;
         this.extDTable = new HtmlExtendedDataTable();
         this.simpleSelectionEntete.clear();
      }

   }

   public void annulerPret() {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public void savePret() throws HibernateException, NamingException, ParseException {
      if (this.var_pret_rec != 1 && this.var_pret_rec != 11 && this.var_pret_rec != 21) {
         if (this.var_pret_rec != 2 && this.var_pret_rec != 12 && this.var_pret_rec != 22) {
            if (this.var_pret_rec != 3 && this.var_pret_rec != 13 && this.var_pret_rec != 23) {
               if (this.var_pret_rec == 9 || this.var_pret_rec == 19 || this.var_pret_rec == 29) {
                  if (this.salariesPrets.getSalpreType() == 0) {
                     this.savePretsInternes();
                  } else if (this.salariesPrets.getSalpreType() == 1) {
                     this.savePretsExternes();
                  } else if (this.salariesPrets.getSalpreType() == 2) {
                     this.savePretsManuels();
                  }
               }
            } else {
               this.savePretsManuels();
            }
         } else {
            this.savePretsExternes();
         }
      } else {
         this.savePretsInternes();
      }

      this.var_action = 0;
   }

   public void savePretsInternes() throws NamingException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         Habilitation var3 = this.verifHabilitation(87, var1);
         if (var3 != null) {
            this.salariesPrets.setSalpreEtatVal(1);
            this.salariesPrets.setSalpreEtat(0);
            this.salariesPrets.setSalpreDateValide((Date)null);
         } else {
            this.salariesPrets.setSalpreEtatVal(0);
            if (this.usersChronoPret != null) {
               if (this.usersChronoPret.getUsrchrValidation() == 0) {
                  this.salariesPrets.setSalpreEtat(1);
                  this.salariesPrets.setSalpreDateValide(new Date());
               } else if (this.usersChronoPret.getUsrchrValidation() != 1 && this.usersChronoPret.getUsrchrValidation() == 2) {
               }
            }
         }

         this.salariesPrets.setSalpreType(0);
         if (this.salariesPrets.getSalpreDateSouscription() == null) {
            this.salariesPrets.setSalpreDateSouscription(new Date());
         }

         this.salariesPrets.setSalpreEcheance(this.lesSalariesPretsLignes.size());
         if (this.salariesPrets.getSalpreId() == 0L) {
            String var4 = this.calculChrono.numCompose(this.salariesPrets.getSalpreDateSouscription(), 87, "", var1);
            this.salariesPrets.setSalaries(this.salaries);
            this.salariesPrets.setSalpreDateCreat(new Date());
            this.salariesPrets.setSalpreUserCreat(this.usersLog.getUsrid());
            this.salariesPrets.setSalpreNum(var4);
            this.salariesPrets = this.salariesPretsDao.insert(this.salariesPrets, var1);
            if (var3 != null) {
               this.majParapheur(87, var3, var1);
            }

            this.lesSalariesPrets.add(this.salariesPrets);
            this.dataModelPrets.setWrappedData(this.lesSalariesPrets);
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
         } else {
            this.salariesPrets.setSalpreRmb(this.total_rmb);
            this.salariesPrets.setSalpreDateModif(new Date());
            this.salariesPrets.setSalpreUserModif(this.usersLog.getUsrid());
            this.salariesPrets = this.salariesPretsDao.modif(this.salariesPrets, var1);
         }

         var1.flush();
         this.majPretLignes(var1);
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

   public void savePretsExternes() throws NamingException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         Habilitation var3 = this.verifHabilitation(87, var1);
         if (var3 != null) {
            this.salariesPrets.setSalpreEtatVal(1);
            this.salariesPrets.setSalpreEtat(0);
            this.salariesPrets.setSalpreDateValide((Date)null);
         } else {
            this.salariesPrets.setSalpreEtatVal(0);
            if (this.usersChronoPret != null) {
               if (this.usersChronoPret.getUsrchrValidation() == 0) {
                  this.salariesPrets.setSalpreEtat(1);
                  this.salariesPrets.setSalpreDateValide(new Date());
               } else if (this.usersChronoPret.getUsrchrValidation() != 1 && this.usersChronoPret.getUsrchrValidation() == 2) {
               }
            }
         }

         this.salariesPrets.setSalpreType(1);
         if (this.salariesPrets.getSalpreDateSouscription() == null) {
            this.salariesPrets.setSalpreDateSouscription(new Date());
         }

         this.salariesPrets.setSalpreEcheance(this.lesSalariesPretsLignes.size());
         if (this.salariesPrets.getSalpreId() == 0L) {
            String var4 = this.calculChrono.numCompose(this.salariesPrets.getSalpreDateSouscription(), 87, "", var1);
            this.salariesPrets.setSalaries(this.salaries);
            this.salariesPrets.setSalpreDateCreat(new Date());
            this.salariesPrets.setSalpreUserCreat(this.usersLog.getUsrid());
            this.salariesPrets.setSalpreNum(var4);
            this.salariesPrets = this.salariesPretsDao.insert(this.salariesPrets, var1);
            if (var3 != null) {
               this.majParapheur(87, var3, var1);
            }

            this.lesSalariesPrets.add(this.salariesPrets);
            this.dataModelPrets.setWrappedData(this.lesSalariesPrets);
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
         } else {
            this.salariesPrets.setSalpreRmb(this.total_rmb);
            this.salariesPrets.setSalpreDateModif(new Date());
            this.salariesPrets.setSalpreUserModif(this.usersLog.getUsrid());
            this.salariesPrets = this.salariesPretsDao.modif(this.salariesPrets, var1);
         }

         this.majPretLignes(var1);
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

   public void savePretsManuels() throws NamingException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         Habilitation var3 = this.verifHabilitation(87, var1);
         if (var3 != null) {
            this.salariesPrets.setSalpreEtatVal(1);
            this.salariesPrets.setSalpreEtat(0);
            this.salariesPrets.setSalpreDateValide((Date)null);
         } else {
            this.salariesPrets.setSalpreEtatVal(0);
            if (this.usersChronoPret != null) {
               if (this.usersChronoPret.getUsrchrValidation() == 0) {
                  this.salariesPrets.setSalpreEtat(1);
                  this.salariesPrets.setSalpreDateValide(new Date());
               } else if (this.usersChronoPret.getUsrchrValidation() != 1 && this.usersChronoPret.getUsrchrValidation() == 2) {
               }
            }
         }

         this.salariesPrets.setSalpreType(2);
         if (this.salariesPrets.getSalpreDateSouscription() == null) {
            this.salariesPrets.setSalpreDateSouscription(new Date());
         }

         this.salariesPrets.setSalpreEcheance(this.lesSalariesPretsLignes.size());
         if (this.salariesPrets.getSalpreId() == 0L) {
            String var4 = this.calculChrono.numCompose(this.salariesPrets.getSalpreDateSouscription(), 87, "", var1);
            this.salariesPrets.setSalaries(this.salaries);
            this.salariesPrets.setSalpreDateCreat(new Date());
            this.salariesPrets.setSalpreUserCreat(this.usersLog.getUsrid());
            this.salariesPrets.setSalpreNum(var4);
            this.salariesPrets = this.salariesPretsDao.insert(this.salariesPrets, var1);
            if (var3 != null) {
               this.majParapheur(87, var3, var1);
            }

            this.lesSalariesPrets.add(this.salariesPrets);
            this.dataModelPrets.setWrappedData(this.lesSalariesPrets);
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
         } else {
            this.salariesPrets.setSalpreRmb(this.total_rmb);
            this.salariesPrets.setSalpreDateModif(new Date());
            this.salariesPrets.setSalpreUserModif(this.usersLog.getUsrid());
            this.salariesPrets = this.salariesPretsDao.modif(this.salariesPrets, var1);
         }

         this.majPretLignes(var1);
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

   public void validePret() throws HibernateException, NamingException {
      boolean var1 = false;
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         Habilitation var4 = this.verifHabilitation(87, var2);
         if (this.salariesPrets.getSalpreEtat() == 0 && var4 == null && this.usersChronoPret.getUsrchrValidation() == 2) {
            this.salariesPrets.setSalpreEtat(1);
            this.salariesPrets = this.salariesPretsDao.modif(this.salariesPrets, var2);
            var1 = true;
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

      if (var1) {
         Espion var10 = new Espion();
         var10.setUsers(this.usersLog);
         var10.setEsptype(0);
         var10.setEspdtecreat(new Date());
         var10.setEspaction("Validation manuelle prêt (P.) N° " + this.salariesPrets.getSalpreNum() + " du " + this.utilDate.dateToStringSQLLight(this.salariesPrets.getSalpreDateSouscription()));
         this.espionDao.mAJEspion(var10);
      }

   }

   public void deValidePret() throws HibernateException, NamingException {
      boolean var1 = false;
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         Habilitation var4 = this.verifHabilitation(87, var2);
         if (this.salariesPrets.getSalpreEtat() == 1 && var4 == null && this.usersChronoPret.getUsrchrValidation() == 2) {
            this.salariesPrets.setSalpreEtat(0);
            this.salariesPrets.setSalpreDateImp((Date)null);
            this.salariesPrets = this.salariesPretsDao.modif(this.salariesPrets, var2);
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

      if (var1) {
         Espion var10 = new Espion();
         var10.setUsers(this.usersLog);
         var10.setEsptype(0);
         var10.setEspdtecreat(new Date());
         var10.setEspaction("Dévalidation manuelle prêt (P.) N° " + this.salariesPrets.getSalpreNum() + " du " + this.utilDate.dateToStringSQLLight(this.salariesPrets.getSalpreDateSouscription()));
         this.espionDao.mAJEspion(var10);
      }

   }

   public void transfererPrets() throws HibernateException, NamingException {
      if (this.salariesPrets != null) {
         if (this.salariesPrets.getSalpreType() == 0 || this.salariesPrets.getSalpreType() == 1) {
            if (this.salariesPrets.getSalpreType() == 0) {
               this.salariesPrets.setSalpreType(1);
            } else if (this.salariesPrets.getSalpreType() == 1) {
               this.salariesPrets.setSalpreType(0);
            }

            this.salariesPrets = this.salariesPretsDao.modif(this.salariesPrets);
            this.lesSalariesPrets.remove(this.salariesPrets);
            this.dataModelPrets.setWrappedData(this.lesSalariesPrets);
         }

         this.var_affiche_prets = false;
      }

   }

   public void reactualiserPret() throws IOException, JDOMException, ParseException, NamingException, SAXException {
      FormUtilitaires var1 = new FormUtilitaires();
      var1.setBaseLog(this.baseLog);
      var1.setStructureLog(this.structureLog);
      var1.setUsersLog(this.usersLog);
      var1.setutilInitHibernate(this.utilInitHibernate);
      var1.InstancesDaoUtilses();
      var1.recalculPrets();
      this.rechercherSalariePret();
      var1 = null;
   }

   public void gelerPret() throws HibernateException, NamingException {
      if (this.salariesPrets != null) {
         this.salariesPrets.setSalpreEtat(2);
         this.salariesPrets = this.salariesPretsDao.modif(this.salariesPrets);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         var1.setEspaction("Geler le prêt (M.) N° " + this.salariesPrets.getSalpreNum());
         this.espionDao.mAJEspion(var1);
      }

   }

   public void degelerPret() throws HibernateException, NamingException {
      if (this.salariesPrets != null) {
         this.salariesPrets.setSalpreEtat(1);
         this.salariesPrets = this.salariesPretsDao.modif(this.salariesPrets);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         var1.setEspaction("Dégeler le prêt (M.) N° " + this.salariesPrets.getSalpreNum());
         this.espionDao.mAJEspion(var1);
      }

   }

   public void informationPiece() throws HibernateException, NamingException {
      if (this.salariesPrets != null) {
         this.nomCreation = "";
         this.nomModification = "";
         new Users();
         UserDao var2 = new UserDao(this.baseLog, this.utilInitHibernate);
         Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         Users var1;
         if (this.salariesPrets.getSalpreUserCreat() != 0L) {
            var1 = var2.selectUserD(this.salariesPrets.getSalpreUserCreat(), var3);
            if (var1 != null) {
               this.nomCreation = var1.getUsrPatronyme();
            }
         }

         if (this.salariesPrets.getSalpreUserModif() != 0L) {
            var1 = var2.selectUserD(this.salariesPrets.getSalpreUserModif(), var3);
            if (var1 != null) {
               this.nomModification = var1.getUsrPatronyme();
            }
         }

         this.utilInitHibernate.closeSession();
         this.showModalPanelInformation = true;
      }

   }

   public void fermerInformationPiece() {
      this.showModalPanelInformation = false;
   }

   public void ajouterLotPret() {
      if (this.var_pret_rec >= 1 && this.var_pret_rec <= 29) {
         this.salaries = new Salaries();
         this.salariesPrets = new SalariesPrets(this.mesNaturesPretsItems);
         this.var_lib_pret = this.salariesPrets.getLib_nature();
         this.nomSalarie = "";
         this.var_action_prets = 10;
         this.var_action = 10;
         this.lesSalaries.clear();
         this.dataModelLotPret.setWrappedData(this.lesSalaries);
         this.dateDebut = null;
         this.dateFin = null;
         this.dateDebutPret = null;
         this.montantPret = 0.0D;
         this.nbEcheancePret = 0;
         this.naturePret = 0;
         this.observation = "";
         this.responsable = "";
         this.var_memo_action = this.var_action;
      }

   }

   public void annulerLotPret() {
      this.var_action = 0;
   }

   public void validerLotPret() throws HibernateException, NamingException, ParseException {
      this.lesSalariesPrets.clear();
      if (this.dateDebutPret != null && this.montantPret != 0.0D && this.nbEcheancePret != 0 && this.lesSalaries.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.lesSalaries.size(); ++var3) {
               this.salaries = (Salaries)this.lesSalaries.get(var3);
               if (this.salaries.isSelect_agent()) {
                  String var4 = this.calculChrono.numCompose(new Date(), 87, "", var1);
                  this.salariesPrets = new SalariesPrets(this.mesNaturesPretsItems);
                  this.salariesPrets.setSalpreEtatVal(0);
                  this.salariesPrets.setSalpreEtat(1);
                  this.salariesPrets.setSalpreDateValide(new Date());
                  this.salariesPrets.setSalaries(this.salaries);
                  this.salariesPrets.setSalpreArrondi(0);
                  this.salariesPrets.setSalpreCompte("");
                  this.salariesPrets.setSalpreDateCreat(new Date());
                  this.salariesPrets.setSalpreDateImp((Date)null);
                  this.salariesPrets.setSalpreDateModif((Date)null);
                  this.salariesPrets.setSalpreDateDebut(this.dateDebutPret);
                  this.salariesPrets.setSalpreDateSouscription(new Date());
                  this.salariesPrets.setSalpreDescriptif("");
                  this.salariesPrets.setSalpreEcheance(this.nbEcheancePret);
                  this.salariesPrets.setSalpreJournal("");
                  this.salariesPrets.setSalpreMontant(this.montantPret);
                  this.salariesPrets.setSalpreNature(this.naturePret);
                  this.salariesPrets.setSalpreNum(var4);
                  this.salariesPrets.setSalpreObjet(this.observation);
                  this.salariesPrets.setSalprePosSignature(0);
                  this.salariesPrets.setSalpreReference("");
                  this.salariesPrets.setSalpreResponsable(this.responsable);
                  this.salariesPrets.setSalpreRmb(0.0D);
                  if (this.var_pret_rec != 2 && this.var_pret_rec != 12 && this.var_pret_rec != 22) {
                     if (this.var_pret_rec != 3 && this.var_pret_rec != 13 && this.var_pret_rec != 23) {
                        this.salariesPrets.setSalpreType(0);
                     } else {
                        this.salariesPrets.setSalpreType(2);
                     }
                  } else {
                     this.salariesPrets.setSalpreType(1);
                  }

                  this.salariesPrets.setSalpreService("");
                  this.salariesPrets.setSalpreUserCreat(this.usersLog.getUsrid());
                  this.salariesPrets = this.salariesPretsDao.insert(this.salariesPrets, var1);
                  this.lesSalariesPrets.add(this.salariesPrets);
                  this.lesSalariesPretsLignes.clear();
                  this.calculEcheanceSuite();
                  this.majPretLignes(var1);
               }
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

      this.dataModelLotPret.setWrappedData(this.lesSalariesPrets);
      this.var_action = 0;
   }

   public void toutSelectionner() {
      if (this.lesSalaries.size() != 0) {
         for(int var1 = 0; var1 < this.lesSalaries.size(); ++var1) {
            this.salaries = (Salaries)this.lesSalaries.get(var1);
            this.salaries.setSelect_agent(true);
         }
      }

      this.dataModelLotPret.setWrappedData(this.lesSalaries);
   }

   public void rienSelectionner() {
      if (this.lesSalaries.size() != 0) {
         for(int var1 = 0; var1 < this.lesSalaries.size(); ++var1) {
            this.salaries = (Salaries)this.lesSalaries.get(var1);
            this.salaries.setSelect_agent(false);
         }
      }

      this.dataModelLotPret.setWrappedData(this.lesSalaries);
   }

   public void rechercherSalarie() throws HibernateException, NamingException, ParseException {
      this.rechercherSalarie((Session)null);
   }

   public void rechercherSalarie(Session var1) throws HibernateException, NamingException, ParseException {
      String var2 = "";
      if (this.mesNatureAgentItems.size() != 0) {
         for(int var3 = 0; var3 < this.mesNatureAgentItems.size(); ++var3) {
            if (((SelectItem)this.mesNatureAgentItems.get(var3)).getValue().toString() != null && !((SelectItem)this.mesNatureAgentItems.get(var3)).getValue().toString().isEmpty()) {
               if (var2 != null && !var2.isEmpty()) {
                  var2 = var2 + "," + "'" + ((SelectItem)this.mesNatureAgentItems.get(var3)).getValue().toString() + "'";
               } else {
                  var2 = "'" + ((SelectItem)this.mesNatureAgentItems.get(var3)).getValue().toString() + "'";
               }
            }
         }
      }

      long var8 = 0L;
      if (this.accesInterim) {
         if (this.var_tiers_rec != null && !this.var_tiers_rec.isEmpty() && this.var_tiers_rec.equals("100")) {
            var8 = 0L;
         } else if (this.var_tiers_rec != null && !this.var_tiers_rec.isEmpty() && this.var_tiers_rec.equals("101")) {
            var8 = -1L;
         } else if (this.var_tiers_rec != null && !this.var_tiers_rec.isEmpty() && !this.var_tiers_rec.equals("101") && !this.var_tiers_rec.equals("100")) {
            var8 = Long.parseLong(this.var_tiers_rec);
         } else {
            var8 = -1L;
         }
      }

      this.lesSalaries.clear();
      Date var5 = null;
      Date var6 = null;
      if (this.exercicesPaye.getExepayId() != this.lastExoPaye.getExepayId()) {
         var5 = this.utilDate.stringToDateSQLLight("2000-01-01");
         var6 = this.exercicesPaye.getExepayDateDebut();
      }

      int var7 = Integer.parseInt(this.optionPaye.getTriAgents());
      this.lesSalaries = this.salariesDao.rechercheSalaries(false, var7, var2, this.var_etat_rec, this.var_immat_rec, this.var_nom_rec, this.var_feuille_rec, this.var_nature_rec, this.var_site_rec, this.var_departement_rec, this.var_service_rec, this.var_activite_rec, this.var_convention_rec, this.var_niveau_rec, this.var_classement_rec, this.var_grille_rec, this.var_centre_rec, var8, var5, var6, var1);
      this.dataModelLotPret.setWrappedData(this.lesSalaries);
   }

   public void historiquePretInterne(long var1, Session var3) throws HibernateException, NamingException {
      if (var1 != 0L) {
         this.salaries = this.salariesDao.chercherIdSalaries(var1, var3);
         if (this.salaries != null) {
            this.lesSalariesPrets.clear();
            this.lesSalariesPrets = this.salariesPretsDao.chargerlesPretsInternes(this.salaries, var3);
            this.dataModelPrets.setWrappedData(this.lesSalariesPrets);
         }
      }

   }

   public void historiquePretExterne(long var1, Session var3) throws HibernateException, NamingException {
      if (var1 != 0L) {
         this.salaries = this.salariesDao.chercherIdSalaries(var1, var3);
         if (this.salaries != null) {
            this.lesSalariesPrets.clear();
            this.lesSalariesPrets = this.salariesPretsDao.chargerlesPretsExternes(this.salaries, var3);
            this.dataModelPrets.setWrappedData(this.lesSalariesPrets);
         }
      }

   }

   public void historiquePretManuel(long var1, Session var3) throws HibernateException, NamingException {
      if (var1 != 0L) {
         this.salaries = this.salariesDao.chercherIdSalaries(var1, var3);
         if (this.salaries != null) {
            this.lesSalariesPrets.clear();
            this.lesSalariesPrets = this.salariesPretsDao.chargerlesPretsManuels(this.salaries, var3);
            this.dataModelPrets.setWrappedData(this.lesSalariesPrets);
         }
      }

   }

   public void selectionPretsLignes() {
      if (this.dataModelPretsLignes.isRowAvailable()) {
         this.salariesPretsLignes = (SalariesPretsLignes)this.dataModelPretsLignes.getRowData();
         this.var_memo_echeance = this.salariesPretsLignes.getSalpreligMontantTheo();
         int var1 = 0;
         if (this.lesSalariesPretsLignes.size() != 0) {
            for(int var2 = 0; var2 < this.lesSalariesPretsLignes.size(); ++var2) {
               if (this.salariesPretsLignes.getSalpreligId() == ((SalariesPretsLignes)this.lesSalariesPretsLignes.get(var2)).getSalpreligId()) {
                  var1 = var2;
                  break;
               }
            }
         }

         this.numLignePret = var1 + 1;
         this.var_affiche_lignes = true;
      }

   }

   public void ajouterPretsLignes() {
      this.salariesPretsLignes = new SalariesPretsLignes();
      this.var_choix_ligne = 3;
      this.var_action_ligne = 2;
      this.var_change_echeance = false;
      this.showModalPanelPretsLignes = true;
   }

   public void modifierPretsLignes() {
      if (this.salariesPretsLignes != null) {
         this.var_choix_ligne = 0;
         this.var_action_ligne = 2;
         this.var_change_echeance = false;
         this.showModalPanelPretsLignes = true;
      }

   }

   public void consulterPretsLignes() {
      if (this.salariesPretsLignes != null) {
         this.var_choix_ligne = 0;
         this.var_action_ligne = 3;
         this.var_change_echeance = true;
         this.showModalPanelPretsLignes = true;
      }

   }

   public void verifierPretsLignes() throws HibernateException, NamingException {
      if (this.salariesPretsLignes != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3;
            String var4;
            String var5;
            List var6;
            boolean var7;
            int var8;
            if (this.salariesPretsLignes.getSalpreligDateReel() != null) {
               var3 = "";
               if (this.salariesPretsLignes.getSalpreligDateReel().getMonth() + 1 <= 9) {
                  var3 = "0" + (this.salariesPretsLignes.getSalpreligDateReel().getMonth() + 1);
               } else {
                  var3 = "" + (this.salariesPretsLignes.getSalpreligDateReel().getMonth() + 1);
               }

               var4 = "" + (this.salariesPretsLignes.getSalpreligDateReel().getYear() + 1900);
               var5 = var3 + ":" + var4;
               this.bulletinSalaire = this.bulletinSalaireDao.rechercheBulletinSalariePeriode(this.salariesPretsLignes.getSalaries().getSalMatricule(), var5, var1);
               if (this.bulletinSalaire == null) {
                  this.salariesPretsLignes.setSalpreligDateReel((Date)null);
                  this.salariesPretsLignes.setSalpreligMontantReel(0.0D);
                  this.salariesPretsLignes = this.salariesPretsLignesDao.modif(this.salariesPretsLignes, var1);
               } else {
                  new ArrayList();
                  var6 = this.bulletinLigneDao.chargerleslignesBulletin(this.bulletinSalaire, var1);
                  if (var6.size() != 0) {
                     var7 = false;

                     for(var8 = 0; var8 < var6.size(); ++var8) {
                        this.bulletinLigne = (BulletinLigne)var6.get(var8);
                        if (this.bulletinLigne.getBulligRubrique().equals("600200") || this.bulletinLigne.getBulligRubrique().equals("600300")) {
                           if (this.bulletinLigne.getBulligIdPretligne() != 0L && this.bulletinLigne.getBulligIdPretligne() == this.salariesPretsLignes.getSalpreligId()) {
                              var7 = true;
                              break;
                           }

                           if (Math.abs(this.bulletinLigne.getBulligValColE()) == this.salariesPretsLignes.getSalpreligMontantReel()) {
                              var7 = true;
                              break;
                           }
                        }
                     }

                     if (!var7) {
                        this.salariesPretsLignes.setSalpreligDateReel((Date)null);
                        this.salariesPretsLignes.setSalpreligMontantReel(0.0D);
                        this.salariesPretsLignes = this.salariesPretsLignesDao.modif(this.salariesPretsLignes, var1);
                     }
                  }
               }
            } else if (this.salariesPretsLignes.getSalpreligDateTheo() != null) {
               var3 = "";
               if (this.salariesPretsLignes.getSalpreligDateTheo().getMonth() + 1 <= 9) {
                  var3 = "0" + (this.salariesPretsLignes.getSalpreligDateTheo().getMonth() + 1);
               } else {
                  var3 = "" + (this.salariesPretsLignes.getSalpreligDateTheo().getMonth() + 1);
               }

               var4 = "" + (this.salariesPretsLignes.getSalpreligDateTheo().getYear() + 1900);
               var5 = var3 + ":" + var4;
               this.bulletinSalaire = this.bulletinSalaireDao.rechercheBulletinSalariePeriode(this.salariesPretsLignes.getSalaries().getSalMatricule(), var5, var1);
               if (this.bulletinSalaire != null) {
                  new ArrayList();
                  var6 = this.bulletinLigneDao.chargerleslignesBulletin(this.bulletinSalaire, var1);
                  if (var6.size() != 0) {
                     var7 = false;

                     for(var8 = 0; var8 < var6.size(); ++var8) {
                        this.bulletinLigne = (BulletinLigne)var6.get(var8);
                        if (this.bulletinLigne.getBulligRubrique().equals("600200") || this.bulletinLigne.getBulligRubrique().equals("600300")) {
                           if (this.bulletinLigne.getBulligIdPretligne() != 0L && this.bulletinLigne.getBulligIdPretligne() == this.salariesPretsLignes.getSalpreligId()) {
                              var7 = true;
                              break;
                           }

                           if (Math.abs(this.bulletinLigne.getBulligValColE()) == this.salariesPretsLignes.getSalpreligMontantTheo()) {
                              var7 = true;
                              break;
                           }
                        }
                     }

                     if (var7) {
                        this.salariesPretsLignes.setSalpreligDateReel(this.bulletinLigne.getBulletinSalaire().getBulsalDateDebut());
                        this.salariesPretsLignes.setSalpreligMontantReel(Math.abs(this.bulletinLigne.getBulligValColE()));
                        this.salariesPretsLignes = this.salariesPretsLignesDao.modif(this.salariesPretsLignes, var1);
                     }
                  }
               }
            }

            var2.commit();
         } catch (HibernateException var12) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var12;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.calculTotalPret();
      }

   }

   public String matPeriode() {
      String var1 = "";
      if (this.salariesPretsLignes != null) {
         String var2 = "";
         if (this.salariesPretsLignes.getSalpreligDateReel().getMonth() + 1 <= 9) {
            var2 = "0" + (this.salariesPretsLignes.getSalpreligDateReel().getMonth() + 1);
         } else {
            var2 = "" + (this.salariesPretsLignes.getSalpreligDateReel().getMonth() + 1);
         }

         String var3 = "" + (this.salariesPretsLignes.getSalpreligDateReel().getYear() + 1900);
         var1 = var2 + ":" + var3 + ":" + this.salariesPretsLignes.getSalaries().getSalMatricule();
      }

      return var1;
   }

   public void supprimerPretsLignes() {
      if (this.salariesPretsLignes != null) {
         this.var_choix_ligne = 0;
         this.var_action_ligne = 2;
         this.var_change_echeance = false;
         this.showModalPanelPretsLignes = true;
      }

   }

   public void changeEcheance() {
      if (this.salariesPrets.getSalpreDateDebut() != null) {
         this.var_change_echeance = true;
      } else {
         this.var_change_echeance = false;
      }

   }

   public void valideEcheance() {
      this.var_change_echeance = false;
   }

   public void annulerPretsLignes() {
      this.var_affiche_lignes = false;
      this.showModalPanelPretsLignes = false;
   }

   public void soldePretsLignes() {
      this.var_affiche_lignes = false;
      this.showModalPanelPretsLignes = false;
   }

   public void savePretsLignes() throws NamingException, ParseException {
      if (this.salariesPretsLignes != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.salariesPretsLignes.getSalpreligDateTheo() == null) {
               this.lesSalariesPretsLignes.clear();
               this.lesSalariesPretsLignes = this.salariesPretsLignesDao.chargerlesPretsLignes(this.salariesPrets, var1);
               this.dataModelPretsLignes.setWrappedData(this.lesSalariesPretsLignes);
            } else {
               if (this.salariesPretsLignes.getSalpreligId() == 0L) {
                  this.salariesPretsLignes.setSalaries(this.salaries);
                  this.salariesPretsLignes.setSalariesPrets(this.salariesPrets);
                  this.salariesPretsLignes.setSalpreligNum(this.salariesPrets.getSalpreNum());
                  this.salariesPretsLignes = this.salariesPretsLignesDao.insert(this.salariesPretsLignes, var1);
                  this.lesSalariesPretsLignes.add(this.salariesPretsLignes);
                  this.dataModelPretsLignes.setWrappedData(this.lesSalariesPretsLignes);
               } else {
                  this.salariesPretsLignes = this.salariesPretsLignesDao.modif(this.salariesPretsLignes, var1);
               }

               if (this.var_choix_ligne != 0) {
                  double var3;
                  if (this.var_choix_ligne == 1) {
                     var3 = 0.0D;
                     double var19 = this.var_memo_echeance - this.salariesPretsLignes.getSalpreligMontantTheo();
                     double var20 = var19 / (double)(this.lesSalariesPretsLignes.size() - this.numLignePret);
                     double var9 = 0.0D;
                     int var11;
                     if (this.salariesPrets.getSalpreArrondi() == 0) {
                        var9 = var20;
                     } else if (this.salariesPrets.getSalpreArrondi() == 1) {
                        var11 = (int)(var20 / 100.0D);
                        var9 = (double)(var11 * 100);
                     } else if (this.salariesPrets.getSalpreArrondi() == 2) {
                        var11 = (int)(var20 / 500.0D);
                        var9 = (double)(var11 * 500);
                     } else if (this.salariesPrets.getSalpreArrondi() == 3) {
                        var11 = (int)(var20 / 1000.0D);
                        var9 = (double)(var11 * 1000);
                     }

                     for(var11 = 0; var11 < this.numLignePret; ++var11) {
                        var3 += ((SalariesPretsLignes)this.lesSalariesPretsLignes.get(var11)).getSalpreligMontantTheo();
                     }

                     for(var11 = this.numLignePret; var11 < this.lesSalariesPretsLignes.size(); ++var11) {
                        this.salariesPretsLignes = (SalariesPretsLignes)this.lesSalariesPretsLignes.get(var11);
                        if (var11 == this.lesSalariesPretsLignes.size() - 1) {
                           this.salariesPretsLignes.setSalpreligMontantTheo(this.salariesPrets.getSalpreMontant() - var3);
                        } else {
                           this.salariesPretsLignes.setSalpreligMontantTheo(this.salariesPretsLignes.getSalpreligMontantTheo() + var9);
                           var3 += this.salariesPretsLignes.getSalpreligMontantTheo();
                        }

                        this.salariesPretsLignes = this.salariesPretsLignesDao.modif(this.salariesPretsLignes, var1);
                     }
                  } else {
                     int var6;
                     if (this.var_choix_ligne == 2) {
                        this.salariesPretsLignes = this.salariesPretsLignesDao.modif(this.salariesPretsLignes, var1);
                        new SalariesPretsLignes();
                        SalariesPretsLignes var17 = this.salariesPretsLignes;
                        this.salariesPretsLignes = new SalariesPretsLignes();
                        Date var4 = null;
                        Date var18 = null;
                        var6 = 0;

                        for(int var7 = 0; var7 < this.lesSalariesPretsLignes.size(); ++var7) {
                           var4 = ((SalariesPretsLignes)this.lesSalariesPretsLignes.get(var7)).getSalpreligDateTheo();
                           ++var6;
                        }

                        var18 = this.utilDate.dateMoisSuivant(var4);
                        this.salariesPretsLignes.setSalpreligDateTheo(this.utilDate.dateDernierJourMois(var18));
                        this.salariesPretsLignes.setSalpreligMontantTheo(this.var_memo_echeance - var17.getSalpreligMontantTheo());
                        if (this.salariesPretsLignes.getSalpreligMontantTheo() != 0.0D) {
                           this.salariesPretsLignes.setSalaries(var17.getSalaries());
                           this.salariesPretsLignes.setSalariesPrets(var17.getSalariesPrets());
                           this.salariesPretsLignes.setSalpreligNum(var17.getSalpreligNum());
                           this.salariesPretsLignes.setSalpreligReference(var17.getSalpreligReference());
                           this.salariesPretsLignes = this.salariesPretsLignesDao.insert(this.salariesPretsLignes, var1);
                           this.lesSalariesPretsLignes.add(this.salariesPretsLignes);
                           this.dataModelPretsLignes.setWrappedData(this.lesSalariesPretsLignes);
                           this.salariesPrets.setSalpreEcheance(var6);
                           this.salariesPrets = this.salariesPretsDao.modif(this.salariesPrets, var1);
                        }
                     } else if (this.var_choix_ligne == 3) {
                        var3 = 0.0D;
                        int var5 = 0;

                        for(var6 = 0; var6 < this.lesSalariesPretsLignes.size(); ++var6) {
                           var3 += ((SalariesPretsLignes)this.lesSalariesPretsLignes.get(var6)).getSalpreligMontantTheo();
                           ++var5;
                        }

                        this.salariesPrets.setSalpreMontant(var3);
                        this.salariesPrets.setSalpreEcheance(var5);
                        this.salariesPrets = this.salariesPretsDao.modif(this.salariesPrets, var1);
                     }
                  }
               }
            }

            var2.commit();
         } catch (HibernateException var15) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var15;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.total_pret = this.salariesPrets.getSalpreMontant();
      this.solde_pret = this.total_pret - this.total_rmb;
      this.showModalPanelPretsLignes = false;
   }

   public void ajouterCapitalisation() {
      this.salariesCapitalisation = new SalariesCapitalisation();
      this.showModalPanelCapitalisation = true;
   }

   public void modifierCapitalisation() {
      if (this.salariesCapitalisation != null) {
         this.showModalPanelCapitalisation = true;
      }

   }

   public void supprimerCapitalisation() throws HibernateException, NamingException {
      if (this.salariesCapitalisation != null) {
         this.salariesCapitalisationDao.delete(this.salariesCapitalisation);
         this.salariesCapitalisation = new SalariesCapitalisation();
      }

   }

   public void validerCapitalisation() throws HibernateException, NamingException {
      this.salariesCapitalisation.setSalcapRubVersement(this.optionPaye.getRubVersement());
      this.salariesCapitalisation.setSalcapRubSpontanee(this.optionPaye.getRubSpontanee());
      this.salariesCapitalisation.setSalcapRubRetrait(this.optionPaye.getRubRetrait());
      if (this.salariesCapitalisation.getSalcapId() == 0L) {
         this.salariesCapitalisation.setSalaries(this.salaries);
         this.salariesCapitalisation = this.salariesCapitalisationDao.insert(this.salariesCapitalisation);
      } else {
         this.salariesCapitalisation = this.salariesCapitalisationDao.modif(this.salariesCapitalisation);
      }

      this.total_versement = 0.0D;
      this.total_retrait = 0.0D;
      this.solde_capitalisation = 0.0D;
      if (this.lesLignesCapitalisation.size() != 0) {
         for(int var1 = 0; var1 < this.lesLignesCapitalisation.size(); ++var1) {
            this.total_versement += ((BulletinLigne)this.lesLignesCapitalisation.get(var1)).getRecette();
            this.total_retrait += ((BulletinLigne)this.lesLignesCapitalisation.get(var1)).getDepense();
         }
      }

      this.solde_capitalisation = this.salariesCapitalisation.getSalcapInitial() + this.total_versement + this.total_retrait;
      this.showModalPanelCapitalisation = false;
   }

   public void fermerCapitalisation() {
      this.showModalPanelCapitalisation = false;
   }

   public void historiqueEpargne(long var1, Session var3) throws HibernateException, NamingException {
      if (var1 != 0L) {
         this.salaries = this.salariesDao.chercherIdSalaries(var1, var3);
         if (this.salaries != null) {
            this.salariesCapitalisation = new SalariesCapitalisation();
            this.salariesCapitalisation = this.salariesCapitalisationDao.chargerleCapital(this.salaries, "", var3);
            if (this.salariesCapitalisation == null) {
               this.salariesCapitalisation = new SalariesCapitalisation();
            } else {
               this.total_versement = 0.0D;
               this.total_retrait = 0.0D;
               this.solde_capitalisation = 0.0D;
               this.lesLignesCapitalisation.clear();
               if (this.salariesCapitalisation.getSalcapRubVersement() != null && !this.salariesCapitalisation.getSalcapRubVersement().isEmpty() && this.salariesCapitalisation.getSalcapRubRetrait() != null && !this.salariesCapitalisation.getSalcapRubRetrait().isEmpty()) {
                  this.lesLignesCapitalisation = this.salariesCapitalisationDao.chargerlesMvts(this.salaries, this.salariesCapitalisation, var3);
                  if (this.lesLignesCapitalisation.size() != 0) {
                     for(int var4 = 0; var4 < this.lesLignesCapitalisation.size(); ++var4) {
                        this.total_versement += ((BulletinLigne)this.lesLignesCapitalisation.get(var4)).getDepense();
                        this.total_retrait += ((BulletinLigne)this.lesLignesCapitalisation.get(var4)).getRecette();
                     }
                  }

                  this.solde_capitalisation = this.salariesCapitalisation.getSalcapInitial() + this.total_versement - this.total_retrait;
               }

               this.dataModelCapitalisation.setWrappedData(this.lesLignesCapitalisation);
            }
         }
      }

   }

   public void majParapheur(int var1, Habilitation var2, Session var3) {
      Parapheur var4 = new Parapheur();
      ParapheurDao var5 = new ParapheurDao(this.baseLog, this.utilInitHibernate);
      var4.setPhrNature(var1);
      var4.setPhrMode(var2.getHabMode());
      var4.setPhrUser1Cat(var2.getHabUser1Cat());
      var4.setPhrUser1Id(var2.getHabUser1Id());
      var4.setPhrUser1Nom(var2.getHabUser1Nom());
      var4.setPhrUser2Cat(var2.getHabUser2Cat());
      var4.setPhrUser2Id(var2.getHabUser2Id());
      var4.setPhrUser2Nom(var2.getHabUser2Nom());
      var4.setPhrUser3Cat(var2.getHabUser3Cat());
      var4.setPhrUser3Id(var2.getHabUser3Id());
      var4.setPhrUser3Nom(var2.getHabUser3Nom());
      var4.setPhrUser4Cat(var2.getHabUser4Cat());
      var4.setPhrUser4Id(var2.getHabUser4Id());
      var4.setPhrUser4Nom(var2.getHabUser4Nom());
      var4.setPhrUser5Cat(var2.getHabUser5Cat());
      var4.setPhrUser5Id(var2.getHabUser5Id());
      var4.setPhrUser5Nom(var2.getHabUser5Nom());
      var4.setPhrUser6Cat(var2.getHabUser6Cat());
      var4.setPhrUser6Id(var2.getHabUser6Id());
      var4.setPhrUser6Nom(var2.getHabUser6Nom());
      var4.setPhrDocId(this.salariesPrets.getSalpreId());
      var4.setPhrNum(this.salariesPrets.getSalpreNum());
      var4.setPhrDate(this.salariesPrets.getSalpreDateDebut());
      if (var4.getPhrId() == 0L) {
         var5.insert(var4, var3);
      } else {
         var5.modif(var4, var3);
      }

   }

   public void majPretLignes(Session var1) throws NamingException, ParseException {
      if (this.lesSalariesPretsLignes.size() != 0) {
         double var2 = 0.0D;

         for(int var4 = 0; var4 < this.lesSalariesPretsLignes.size(); ++var4) {
            this.salariesPretsLignes = (SalariesPretsLignes)this.lesSalariesPretsLignes.get(var4);
            if (this.salariesPretsLignes.getSalpreligDateReel() == null && this.salariesPretsLignes.getSalpreligMontantTheo() != 0.0D) {
               if (var4 == this.lesSalariesPretsLignes.size() - 1) {
                  this.salariesPretsLignes.setSalpreligMontantTheo(this.salariesPrets.getSalpreMontant() - var2);
               } else {
                  double var5 = 0.0D;
                  if (this.salariesPrets.getSalpreArrondi() == 0) {
                     var5 = this.salariesPretsLignes.getSalpreligMontantTheo();
                  } else {
                     int var7;
                     if (this.salariesPrets.getSalpreArrondi() == 1) {
                        var7 = (int)(this.salariesPretsLignes.getSalpreligMontantTheo() / 100.0D);
                        var5 = (double)(var7 * 100);
                     } else if (this.salariesPrets.getSalpreArrondi() == 2) {
                        var7 = (int)(this.salariesPretsLignes.getSalpreligMontantTheo() / 500.0D);
                        var5 = (double)(var7 * 500);
                     } else if (this.salariesPrets.getSalpreArrondi() == 3) {
                        var7 = (int)(this.salariesPretsLignes.getSalpreligMontantTheo() / 1000.0D);
                        var5 = (double)(var7 * 1000);
                     }
                  }

                  this.salariesPretsLignes.setSalpreligMontantTheo(var5);
               }
            }

            var2 += this.salariesPretsLignes.getSalpreligMontantTheo();
            if (this.salariesPretsLignes.getSalpreligId() == 0L) {
               this.salariesPretsLignes = this.salariesPretsLignesDao.insert(this.salariesPretsLignes, var1);
            } else {
               this.salariesPretsLignes = this.salariesPretsLignesDao.modif(this.salariesPretsLignes, var1);
            }
         }

         var1.flush();
      }

   }

   public void calculEcheance() throws NamingException, ParseException {
      if (this.salariesPrets.getSalpreRmb() == 0.0D) {
         if (this.lesSalariesPretsLignes.size() != 0) {
            Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
            Transaction var2 = null;

            try {
               var2 = var1.beginTransaction();
               this.salariesPretsLignesDao.deleteAllLigne(this.lesSalariesPretsLignes, var1);
               var2.commit();
            } catch (HibernateException var7) {
               if (var2 != null) {
                  var2.rollback();
               }

               throw var7;
            } finally {
               this.utilInitHibernate.closeSession();
            }

            this.lesSalariesPretsLignes.clear();
         }

         this.calculEcheanceSuite();
      }

   }

   public void calculEcheanceSuite() throws NamingException, ParseException {
      if (this.salariesPrets.getSalpreRmb() == 0.0D) {
         if (this.salariesPrets.getSalpreDateDebut() != null && this.salariesPrets.getSalpreEcheance() != 0) {
            UtilNombre var10 = new UtilNombre();
            Date var2 = this.utilDate.dateDernierJourMois(this.salariesPrets.getSalpreDateDebut());
            double var12 = var10.myRoundFormat(this.salariesPrets.getSalpreMontant() / (double)this.salariesPrets.getSalpreEcheance(), this.structureLog.getStrformatdevise());
            double var13 = 0.0D;
            if (this.salariesPrets.getSalpreArrondi() == 0) {
               var13 = var12;
            } else {
               int var7;
               if (this.salariesPrets.getSalpreArrondi() == 1) {
                  var7 = (int)(var12 / 100.0D);
                  var13 = (double)(var7 * 100);
               } else if (this.salariesPrets.getSalpreArrondi() == 2) {
                  var7 = (int)(var12 / 500.0D);
                  var13 = (double)(var7 * 500);
               } else if (this.salariesPrets.getSalpreArrondi() == 3) {
                  var7 = (int)(var12 / 1000.0D);
                  var13 = (double)(var7 * 1000);
               }
            }

            double var14 = this.salariesPrets.getSalpreMontant() - var13 * (double)this.salariesPrets.getSalpreEcheance();

            for(int var9 = 0; var9 < this.salariesPrets.getSalpreEcheance(); ++var9) {
               this.salariesPretsLignes = new SalariesPretsLignes();
               this.salariesPretsLignes.setSalaries(this.salaries);
               this.salariesPretsLignes.setSalariesPrets(this.salariesPrets);
               this.salariesPretsLignes.setSalpreligNum(this.salariesPrets.getSalpreNum());
               this.salariesPretsLignes.setSalpreligDateTheo(var2);
               if (var9 == this.salariesPrets.getSalpreEcheance() - 1) {
                  this.salariesPretsLignes.setSalpreligMontantTheo(var13 + var14);
               } else {
                  this.salariesPretsLignes.setSalpreligMontantTheo(var13);
               }

               var2 = this.utilDate.dateMoisSuivant(var2);
               var2 = this.utilDate.dateDernierJourMois(var2);
               this.lesSalariesPretsLignes.add(this.salariesPretsLignes);
            }
         } else if (this.salariesPrets.getSalpreDateDebut() != null && this.var_montant_echeance != 0.0D) {
            double var1 = 0.0D;
            if (this.salariesPrets.getSalpreArrondi() == 0) {
               var1 = this.var_montant_echeance;
            } else {
               int var3;
               if (this.salariesPrets.getSalpreArrondi() == 1) {
                  var3 = (int)(this.var_montant_echeance / 100.0D);
                  var1 = (double)(var3 * 100);
               } else if (this.salariesPrets.getSalpreArrondi() == 2) {
                  var3 = (int)(this.var_montant_echeance / 500.0D);
                  var1 = (double)(var3 * 500);
               } else if (this.salariesPrets.getSalpreArrondi() == 3) {
                  var3 = (int)(this.var_montant_echeance / 1000.0D);
                  var1 = (double)(var3 * 1000);
               }
            }

            UtilNombre var11 = new UtilNombre();
            int var4 = (int)var11.myRoundFormat(this.salariesPrets.getSalpreMontant() / var1, this.structureLog.getStrformatdevise());
            Date var5 = this.utilDate.dateDernierJourMois(this.salariesPrets.getSalpreDateDebut());
            double var6 = this.salariesPrets.getSalpreMontant() - var1 * (double)var4;

            for(int var8 = 0; var8 < var4; ++var8) {
               this.salariesPretsLignes = new SalariesPretsLignes();
               this.salariesPretsLignes.setSalaries(this.salaries);
               this.salariesPretsLignes.setSalariesPrets(this.salariesPrets);
               this.salariesPretsLignes.setSalpreligNum(this.salariesPrets.getSalpreNum());
               this.salariesPretsLignes.setSalpreligDateTheo(var5);
               if (var8 == var4 - 1) {
                  this.salariesPretsLignes.setSalpreligMontantTheo(var1 + var6);
               } else {
                  this.salariesPretsLignes.setSalpreligMontantTheo(var1);
               }

               var5 = this.utilDate.dateMoisSuivant(var5);
               var5 = this.utilDate.dateDernierJourMois(var5);
               this.lesSalariesPretsLignes.add(this.salariesPretsLignes);
            }
         }
      }

   }

   public void rechercheSalarie() throws JDOMException, IOException, HibernateException, NamingException {
      this.var_memo_action = this.var_action;
      this.salaries = this.formRecherche.rechercheSalarie(this.nomSalarie, 812, this.exercicesPaye.getExepayId());
      if (this.salaries != null) {
         if (this.salaries.getSalId() != 0L) {
            this.calculeSalarie();
         } else {
            this.var_action = 9;
         }
      } else if (this.salaries == null) {
         this.annuleSalarie();
      }

   }

   public void recuperationSalarie() throws JDOMException, IOException, HibernateException, NamingException {
      this.salaries = this.formRecherche.calculeSalarie();
      this.calculeSalarie();
   }

   public void calculeSalarie() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.salaries != null) {
         this.nomSalarie = this.salaries.getSalMatricule();
         this.calculContrat((Session)null);
      } else {
         this.annuleSalarie();
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleSalarie() {
      this.salaries = new Salaries();
      this.nomSalarie = "";
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

   public void chargerLesModelesImpresion() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "liste" + File.separator + "pret";
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.listeImpressionItems = new ArrayList();
      String[] var3 = var2.list();
      int var4;
      String var5;
      int var6;
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(var4 = 0; var4 < var3.length; ++var4) {
            var5 = var3[var4];
            if (var5.endsWith("jasper")) {
               var6 = var5.indexOf(".");
               var5 = var5.substring(0, var6);
               this.listeImpressionItems.add(new SelectItem(var5));
            }
         }
      }

      var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "document" + File.separator + "pret";
      var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);
         this.documentImpressionItems = new ArrayList();

         for(var4 = 0; var4 < var3.length; ++var4) {
            var5 = var3[var4];
            if (var5.endsWith("jasper")) {
               var6 = var5.indexOf(".");
               var5 = var5.substring(0, var6);
               this.documentImpressionItems.add(new SelectItem(var5));
            }
         }
      }

   }

   public void recalculDateFin() throws HibernateException, NamingException {
      if (this.lesSalariesPrets.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            new ArrayList();

            for(int var4 = 0; var4 < this.lesSalariesPrets.size(); ++var4) {
               this.salariesPrets = (SalariesPrets)this.lesSalariesPrets.get(var4);
               List var3 = this.salariesPretsLignesDao.chargerlesPretsLignes(this.salariesPrets, var1);
               if (var3.size() != 0) {
                  int var5 = var3.size() - 1;
                  this.salariesPrets.setSalpreDateFin(((SalariesPretsLignes)var3.get(var5)).getSalpreligDateTheo());
                  this.salariesPrets = this.salariesPretsDao.pourParapheur(this.salariesPrets.getSalpreId(), var1);
                  if (this.salariesPrets != null) {
                     this.salariesPrets = this.salariesPretsDao.modif(this.salariesPrets, var1);
                  }
               }
            }

            var2.commit();
         } catch (HibernateException var9) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var9;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void impression(UtilPrint var1, int var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10) throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      if (var3 != null && !var3.isEmpty() || var4 != null && !var4.isEmpty()) {
         if (var1 == null) {
            var1 = new UtilPrint(this.utilInitHibernate);
         }

         String var11 = "";
         byte var12 = 100;
         if (this.var_pret_rec == 1) {
            var11 = "Prêt interne Non soldé";
            var12 = 0;
         } else if (this.var_pret_rec == 2) {
            var11 = "Prêt externe Non soldé";
            var12 = 1;
         } else if (this.var_pret_rec == 3) {
            var11 = "Prêt manuel Non soldé";
            var12 = 2;
         } else if (this.var_pret_rec == 9) {
            var11 = "TouT Prêt Non soldé";
         } else if (this.var_pret_rec == 11) {
            var11 = "Prêt interne solde";
            var12 = 0;
         } else if (this.var_pret_rec == 12) {
            var11 = "Prêt externe soldé";
            var12 = 1;
         } else if (this.var_pret_rec == 13) {
            var11 = "Prêt manuel soldé";
            var12 = 2;
         } else if (this.var_pret_rec == 19) {
            var11 = "Tout Prêt soldé";
         } else if (this.var_pret_rec == 21) {
            var11 = "Prêt interne (tous)";
            var12 = 0;
         } else if (this.var_pret_rec == 22) {
            var11 = "Prêt externe (tous)";
            var12 = 1;
         } else if (this.var_pret_rec == 23) {
            var11 = "Prêt manuel (tous)";
            var12 = 2;
         } else if (this.var_pret_rec == 29) {
            var11 = "Tout Prêt (Tous états)";
         } else if (this.var_pret_rec == 31) {
            var11 = "Prêt débité le...";
         }

         String var13 = "";
         if (this.var_nat_rec == 0) {
            var13 = "Non renseigné";
         } else if (this.var_nat_rec == 1) {
            var13 = "Avances exceptionnelles";
         } else if (this.var_nat_rec == 2) {
            var13 = "Soins Médicaux";
         } else if (this.var_nat_rec == 3) {
            var13 = "Cessions";
         } else if (this.var_nat_rec == 4) {
            var13 = "Traites";
         } else if (this.var_nat_rec == 5) {
            var13 = "Familiaux";
         } else if (this.var_nat_rec == 6) {
            var13 = "Religieux";
         } else if (this.var_nat_rec == 7) {
            var13 = "Avances étalées";
         } else {
            var13 = "Toutes natures";
         }

         JRBeanCollectionDataSource var14;
         if (var2 == 0) {
            var1.setRapport(var3);
            var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "document" + File.separator + "pret" + File.separator);
            var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "sous_rapport" + File.separator);
            if (this.salariesPrets.getSalpreNature() == 7) {
               var1.setEntete("Impression avance étalée N° : " + this.salariesPrets.getSalpreNum() + " Agent " + this.salaries.getSalMatricule() + " " + this.salaries.getSalNom());
            } else {
               var1.setEntete("Impression du prêt N° : " + this.salariesPrets.getSalpreNum() + " Agent " + this.salaries.getSalMatricule() + " " + this.salaries.getSalNom());
            }

            var1.setFormat(var5);
            var1.setFiltre(var13);
            var1.setMatricule(this.salaries.getSalMatricule());
            var1.setEmetteur(var6);
            var1.setDestinataire(var7);
            var1.setDestinataireCC(var8);
            var1.setDestinataireCCI(var9);
            var1.setCorpsMail(var10);
            var1.setTiersSelectionne((Tiers)null);
            var14 = new JRBeanCollectionDataSource(this.lesSalariesPretsLignes);
            var1.setjRBeanCollectionDataSource(var14);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         } else if (var2 == 1) {
            this.recalculDateFin();
            var1.setRapport(var4);
            var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "liste" + File.separator + "pret" + File.separator);
            var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "sous_rapport" + File.separator);
            var1.setEntete("Impression Liste : " + var11);
            var1.setFormat(var5);
            var1.setFiltre(var13);
            var1.setEmetteur(var6);
            var1.setDestinataire(var7);
            var1.setDestinataireCC(var8);
            var1.setDestinataireCCI(var9);
            var1.setCorpsMail(var10);
            var1.setTiersSelectionne((Tiers)null);
            if (!var4.contains("theorique")) {
               var1.setRequete((String)null);
               var14 = new JRBeanCollectionDataSource(this.lesSalariesPrets);
               var1.setjRBeanCollectionDataSource(var14);
            } else {
               String var19 = this.utilDate.dateToStringFr(this.exercicesPaye.getExepayDateDebut());
               String var15 = this.utilDate.dateToStringFr(this.exercicesPaye.getExepayDateFin());
               var1.setFiltre(var1.getFiltre() + " Période du " + var19 + " au " + var15);
               String var16 = "";
               var16 = "salprelig_date_theo>='" + this.exercicesPaye.getExepayDateDebut() + "' and salprelig_date_theo<='" + this.exercicesPaye.getExepayDateFin() + "'";
               if (var12 != 100) {
                  var16 = var16 + " and pay_salaries_prets.salpre_type=" + var12;
               }

               if (this.var_nat_rec != 100) {
                  var16 = var16 + " and pay_salaries_prets.salpre_nature=" + this.var_nat_rec;
               }

               if (this.lesSalariesPrets.size() != 0) {
                  String var17 = "";

                  for(int var18 = 0; var18 < this.lesSalariesPrets.size(); ++var18) {
                     if (var17 != null && !var17.isEmpty()) {
                        var17 = var17 + "," + ((SalariesPrets)this.lesSalariesPrets.get(var18)).getSalaries().getSalId();
                     } else {
                        var17 = "" + ((SalariesPrets)this.lesSalariesPrets.get(var18)).getSalaries().getSalId();
                     }
                  }

                  var16 = var16 + " and pay_salaries.sal_id in (" + var17 + ")";
               }

               var1.setRequete(var16);
               ArrayList var20 = new ArrayList();
               JRBeanCollectionDataSource var21 = new JRBeanCollectionDataSource(var20);
               var1.setjRBeanCollectionDataSource(var21);
            }

            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      }

   }

   public int getVar_modele() {
      return this.var_modele;
   }

   public void setVar_modele(int var1) {
      this.var_modele = var1;
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

   public List getMesOnglets() {
      return this.mesOnglets;
   }

   public void setMesOnglets(List var1) {
      this.mesOnglets = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
   }

   public int getVar_action() {
      return this.var_action;
   }

   public void setVar_action(int var1) {
      this.var_action = var1;
   }

   public Salaries getSalaries() {
      return this.salaries;
   }

   public void setSalaries(Salaries var1) {
      this.salaries = var1;
   }

   public boolean isVar_acc_prets() {
      return this.var_acc_prets;
   }

   public void setVar_acc_prets(boolean var1) {
      this.var_acc_prets = var1;
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

   public List getMesServiceItems() {
      return this.mesServiceItems;
   }

   public void setMesServiceItems(List var1) {
      this.mesServiceItems = var1;
   }

   public String getVar_nature_rec() {
      return this.var_nature_rec;
   }

   public void setVar_nature_rec(String var1) {
      this.var_nature_rec = var1;
   }

   public String getVar_service_rec() {
      return this.var_service_rec;
   }

   public void setVar_service_rec(String var1) {
      this.var_service_rec = var1;
   }

   public boolean isVar_affiche_bouton() {
      return this.var_affiche_bouton;
   }

   public void setVar_affiche_bouton(boolean var1) {
      this.var_affiche_bouton = var1;
   }

   public String getVar_convention_rec() {
      return this.var_convention_rec;
   }

   public void setVar_convention_rec(String var1) {
      this.var_convention_rec = var1;
   }

   public String getVar_departement_rec() {
      return this.var_departement_rec;
   }

   public void setVar_departement_rec(String var1) {
      this.var_departement_rec = var1;
   }

   public String getVar_feuille_rec() {
      return this.var_feuille_rec;
   }

   public void setVar_feuille_rec(String var1) {
      this.var_feuille_rec = var1;
   }

   public String getVar_immat_rec() {
      return this.var_immat_rec;
   }

   public void setVar_immat_rec(String var1) {
      this.var_immat_rec = var1;
   }

   public String getVar_site_rec() {
      return this.var_site_rec;
   }

   public void setVar_site_rec(String var1) {
      this.var_site_rec = var1;
   }

   public List getMesCentresImpotsItems() {
      return this.mesCentresImpotsItems;
   }

   public void setMesCentresImpotsItems(List var1) {
      this.mesCentresImpotsItems = var1;
   }

   public List getMesClassementsItems() {
      return this.mesClassementsItems;
   }

   public void setMesClassementsItems(List var1) {
      this.mesClassementsItems = var1;
   }

   public List getMesNiveauxEmploisItems() {
      return this.mesNiveauxEmploisItems;
   }

   public void setMesNiveauxEmploisItems(List var1) {
      this.mesNiveauxEmploisItems = var1;
   }

   public ExercicesPaye getExercicesPaye() {
      return this.exercicesPaye;
   }

   public void setExercicesPaye(ExercicesPaye var1) {
      this.exercicesPaye = var1;
   }

   public ExercicesPaye getLastExoPaye() {
      return this.lastExoPaye;
   }

   public void setLastExoPaye(ExercicesPaye var1) {
      this.lastExoPaye = var1;
   }

   public OptionPaye getOptionPaye() {
      return this.optionPaye;
   }

   public void setOptionPaye(OptionPaye var1) {
      this.optionPaye = var1;
   }

   public List getMesConventionsItems() {
      return this.mesConventionsItems;
   }

   public void setMesConventionsItems(List var1) {
      this.mesConventionsItems = var1;
   }

   public List getMesGrillesItems() {
      return this.mesGrillesItems;
   }

   public void setMesGrillesItems(List var1) {
      this.mesGrillesItems = var1;
   }

   public List getMesNatureAgentItems() {
      return this.mesNatureAgentItems;
   }

   public void setMesNatureAgentItems(List var1) {
      this.mesNatureAgentItems = var1;
   }

   public boolean isVar_more_search() {
      return this.var_more_search;
   }

   public void setVar_more_search(boolean var1) {
      this.var_more_search = var1;
   }

   public String getVar_nom_rec() {
      return this.var_nom_rec;
   }

   public void setVar_nom_rec(String var1) {
      this.var_nom_rec = var1;
   }

   public String getVar_classement_rec() {
      return this.var_classement_rec;
   }

   public void setVar_classement_rec(String var1) {
      this.var_classement_rec = var1;
   }

   public String getVar_grille_rec() {
      return this.var_grille_rec;
   }

   public void setVar_grille_rec(String var1) {
      this.var_grille_rec = var1;
   }

   public String getVar_niveau_rec() {
      return this.var_niveau_rec;
   }

   public void setVar_niveau_rec(String var1) {
      this.var_niveau_rec = var1;
   }

   public String getVar_centre_rec() {
      return this.var_centre_rec;
   }

   public void setVar_centre_rec(String var1) {
      this.var_centre_rec = var1;
   }

   public List getMesCiviliteItems() {
      return this.mesCiviliteItems;
   }

   public void setMesCiviliteItems(List var1) {
      this.mesCiviliteItems = var1;
   }

   public List getMesPaysItems() {
      return this.mesPaysItems;
   }

   public void setMesPaysItems(List var1) {
      this.mesPaysItems = var1;
   }

   public List getMesLanguesItems() {
      return this.mesLanguesItems;
   }

   public void setMesLanguesItems(List var1) {
      this.mesLanguesItems = var1;
   }

   public List getMesNationnalitesItems() {
      return this.mesNationnalitesItems;
   }

   public void setMesNationnalitesItems(List var1) {
      this.mesNationnalitesItems = var1;
   }

   public List getLesPays() {
      return this.lesPays;
   }

   public void setLesPays(List var1) {
      this.lesPays = var1;
   }

   public List getLesCivilites() {
      return this.lesCivilites;
   }

   public void setLesCivilites(List var1) {
      this.lesCivilites = var1;
   }

   public List getMesActiviteItems() {
      return this.mesActiviteItems;
   }

   public void setMesActiviteItems(List var1) {
      this.mesActiviteItems = var1;
   }

   public List getMesBudgetItems() {
      return this.mesBudgetItems;
   }

   public void setMesBudgetItems(List var1) {
      this.mesBudgetItems = var1;
   }

   public List getMesParcItems() {
      return this.mesParcItems;
   }

   public void setMesParcItems(List var1) {
      this.mesParcItems = var1;
   }

   public SalariesPrets getSalariesPrets() {
      return this.salariesPrets;
   }

   public void setSalariesPrets(SalariesPrets var1) {
      this.salariesPrets = var1;
   }

   public int getVar_action_prets() {
      return this.var_action_prets;
   }

   public void setVar_action_prets(int var1) {
      this.var_action_prets = var1;
   }

   public boolean isVar_affiche_prets() {
      return this.var_affiche_prets;
   }

   public void setVar_affiche_prets(boolean var1) {
      this.var_affiche_prets = var1;
   }

   public DataModel getDataModelPretsLignes() {
      return this.dataModelPretsLignes;
   }

   public void setDataModelPretsLignes(DataModel var1) {
      this.dataModelPretsLignes = var1;
   }

   public List getLesSalariesPretsLignes() {
      return this.lesSalariesPretsLignes;
   }

   public void setLesSalariesPretsLignes(List var1) {
      this.lesSalariesPretsLignes = var1;
   }

   public SalariesPretsLignes getSalariesPretsLignes() {
      return this.salariesPretsLignes;
   }

   public void setSalariesPretsLignes(SalariesPretsLignes var1) {
      this.salariesPretsLignes = var1;
   }

   public int getVar_action_ligne() {
      return this.var_action_ligne;
   }

   public void setVar_action_ligne(int var1) {
      this.var_action_ligne = var1;
   }

   public boolean isVar_affiche_lignes() {
      return this.var_affiche_lignes;
   }

   public void setVar_affiche_lignes(boolean var1) {
      this.var_affiche_lignes = var1;
   }

   public int getVar_choix_ligne() {
      return this.var_choix_ligne;
   }

   public void setVar_choix_ligne(int var1) {
      this.var_choix_ligne = var1;
   }

   public boolean isVar_change_echeance() {
      return this.var_change_echeance;
   }

   public void setVar_change_echeance(boolean var1) {
      this.var_change_echeance = var1;
   }

   public int getVar_nb_max() {
      return this.var_nb_max;
   }

   public void setVar_nb_max(int var1) {
      this.var_nb_max = var1;
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

   public int getVar_etat_rec() {
      return this.var_etat_rec;
   }

   public void setVar_etat_rec(int var1) {
      this.var_etat_rec = var1;
   }

   public boolean isShowModalVisuEtat() {
      return this.showModalVisuEtat;
   }

   public void setShowModalVisuEtat(boolean var1) {
      this.showModalVisuEtat = var1;
   }

   public String getVar_activite_rec() {
      return this.var_activite_rec;
   }

   public void setVar_activite_rec(String var1) {
      this.var_activite_rec = var1;
   }

   public double getSolde_pret() {
      return this.solde_pret;
   }

   public void setSolde_pret(double var1) {
      this.solde_pret = var1;
   }

   public double getTotal_pret() {
      return this.total_pret;
   }

   public void setTotal_pret(double var1) {
      this.total_pret = var1;
   }

   public double getTotal_rmb() {
      return this.total_rmb;
   }

   public void setTotal_rmb(double var1) {
      this.total_rmb = var1;
   }

   public List getMesFeuillesItems() {
      return this.mesFeuillesItems;
   }

   public void setMesFeuillesItems(List var1) {
      this.mesFeuillesItems = var1;
   }

   public String getVar_periode() {
      return this.var_periode;
   }

   public void setVar_periode(String var1) {
      this.var_periode = var1;
   }

   public List getMesClesItems() {
      return this.mesClesItems;
   }

   public void setMesClesItems(List var1) {
      this.mesClesItems = var1;
   }

   public UsersChrono getUsersChronoPret() {
      return this.usersChronoPret;
   }

   public void setUsersChronoPret(UsersChrono var1) {
      this.usersChronoPret = var1;
   }

   public int getVar_rh_rec() {
      return this.var_rh_rec;
   }

   public void setVar_rh_rec(int var1) {
      this.var_rh_rec = var1;
   }

   public String getNomSalarie() {
      return this.nomSalarie;
   }

   public void setNomSalarie(String var1) {
      this.nomSalarie = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public boolean isAccesPrets() {
      return this.accesPrets;
   }

   public void setAccesPrets(boolean var1) {
      this.accesPrets = var1;
   }

   public int getVar_pret_rec() {
      return this.var_pret_rec;
   }

   public void setVar_pret_rec(int var1) {
      this.var_pret_rec = var1;
   }

   public String getVar_lib_pret() {
      return this.var_lib_pret;
   }

   public void setVar_lib_pret(String var1) {
      this.var_lib_pret = var1;
   }

   public int getVar_nat_rec() {
      return this.var_nat_rec;
   }

   public void setVar_nat_rec(int var1) {
      this.var_nat_rec = var1;
   }

   public Date getInpAu() {
      return this.inpAu;
   }

   public void setInpAu(Date var1) {
      this.inpAu = var1;
   }

   public Date getInpDu() {
      return this.inpDu;
   }

   public void setInpDu(Date var1) {
      this.inpDu = var1;
   }

   public List getMesProjetItems() {
      return this.mesProjetItems;
   }

   public void setMesProjetItems(List var1) {
      this.mesProjetItems = var1;
   }

   public String getVar_projet_rec() {
      return this.var_projet_rec;
   }

   public void setVar_projet_rec(String var1) {
      this.var_projet_rec = var1;
   }

   public String getVar_pays_rec() {
      return this.var_pays_rec;
   }

   public void setVar_pays_rec(String var1) {
      this.var_pays_rec = var1;
   }

   public List getMesPaysUtilItems() {
      return this.mesPaysUtilItems;
   }

   public void setMesPaysUtilItems(List var1) {
      this.mesPaysUtilItems = var1;
   }

   public List getMesFeuillesContratItems() {
      return this.mesFeuillesContratItems;
   }

   public void setMesFeuillesContratItems(List var1) {
      this.mesFeuillesContratItems = var1;
   }

   public DataModel getDataModelCapitalisation() {
      return this.dataModelCapitalisation;
   }

   public void setDataModelCapitalisation(DataModel var1) {
      this.dataModelCapitalisation = var1;
   }

   public SalariesCapitalisation getSalariesCapitalisation() {
      return this.salariesCapitalisation;
   }

   public void setSalariesCapitalisation(SalariesCapitalisation var1) {
      this.salariesCapitalisation = var1;
   }

   public double getSolde_capitalisation() {
      return this.solde_capitalisation;
   }

   public void setSolde_capitalisation(double var1) {
      this.solde_capitalisation = var1;
   }

   public double getTotal_retrait() {
      return this.total_retrait;
   }

   public void setTotal_retrait(double var1) {
      this.total_retrait = var1;
   }

   public double getTotal_versement() {
      return this.total_versement;
   }

   public void setTotal_versement(double var1) {
      this.total_versement = var1;
   }

   public boolean isShowModalPanelCapitalisation() {
      return this.showModalPanelCapitalisation;
   }

   public void setShowModalPanelCapitalisation(boolean var1) {
      this.showModalPanelCapitalisation = var1;
   }

   public boolean isCapitalisationActive() {
      return this.capitalisationActive;
   }

   public void setCapitalisationActive(boolean var1) {
      this.capitalisationActive = var1;
   }

   public int getTypePret() {
      return this.typePret;
   }

   public void setTypePret(int var1) {
      this.typePret = var1;
   }

   public Date getParMois() {
      return this.parMois;
   }

   public void setParMois(Date var1) {
      this.parMois = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public String getVar_budget_rec() {
      return this.var_budget_rec;
   }

   public void setVar_budget_rec(String var1) {
      this.var_budget_rec = var1;
   }

   public String getVar_tiers_rec() {
      return this.var_tiers_rec;
   }

   public void setVar_tiers_rec(String var1) {
      this.var_tiers_rec = var1;
   }

   public boolean isValideSalarie() {
      return this.valideSalarie;
   }

   public void setValideSalarie(boolean var1) {
      this.valideSalarie = var1;
   }

   public boolean isAjoutPret() {
      return this.ajoutPret;
   }

   public void setAjoutPret(boolean var1) {
      this.ajoutPret = var1;
   }

   public DataModel getDataModelPrets() {
      return this.dataModelPrets;
   }

   public void setDataModelPrets(DataModel var1) {
      this.dataModelPrets = var1;
   }

   public boolean isShowModalPanelPretsLignes() {
      return this.showModalPanelPretsLignes;
   }

   public void setShowModalPanelPretsLignes(boolean var1) {
      this.showModalPanelPretsLignes = var1;
   }

   public double getVar_montant_echeance() {
      return this.var_montant_echeance;
   }

   public void setVar_montant_echeance(double var1) {
      this.var_montant_echeance = var1;
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

   public int getVar_valide_rec() {
      return this.var_valide_rec;
   }

   public void setVar_valide_rec(int var1) {
      this.var_valide_rec = var1;
   }

   public DataModel getDataModelLotPret() {
      return this.dataModelLotPret;
   }

   public void setDataModelLotPret(DataModel var1) {
      this.dataModelLotPret = var1;
   }

   public Date getDateDebutPret() {
      return this.dateDebutPret;
   }

   public void setDateDebutPret(Date var1) {
      this.dateDebutPret = var1;
   }

   public double getMontantPret() {
      return this.montantPret;
   }

   public void setMontantPret(double var1) {
      this.montantPret = var1;
   }

   public int getNaturePret() {
      return this.naturePret;
   }

   public void setNaturePret(int var1) {
      this.naturePret = var1;
   }

   public int getNbEcheancePret() {
      return this.nbEcheancePret;
   }

   public void setNbEcheancePret(int var1) {
      this.nbEcheancePret = var1;
   }

   public String getObservation() {
      return this.observation;
   }

   public void setObservation(String var1) {
      this.observation = var1;
   }

   public String getResponsable() {
      return this.responsable;
   }

   public void setResponsable(String var1) {
      this.responsable = var1;
   }

   public List getMesCentresSecuritesItems() {
      return this.mesCentresSecuritesItems;
   }

   public void setMesCentresSecuritesItems(List var1) {
      this.mesCentresSecuritesItems = var1;
   }

   public List getMesNaturesPretsItems() {
      return this.mesNaturesPretsItems;
   }

   public void setMesNaturesPretsItems(List var1) {
      this.mesNaturesPretsItems = var1;
   }

   public String getNomCreation() {
      return this.nomCreation;
   }

   public void setNomCreation(String var1) {
      this.nomCreation = var1;
   }

   public String getNomModification() {
      return this.nomModification;
   }

   public void setNomModification(String var1) {
      this.nomModification = var1;
   }

   public boolean isShowModalPanelInformation() {
      return this.showModalPanelInformation;
   }

   public void setShowModalPanelInformation(boolean var1) {
      this.showModalPanelInformation = var1;
   }

   public List getMesCodesEmploisItems() {
      return this.mesCodesEmploisItems;
   }

   public void setMesCodesEmploisItems(List var1) {
      this.mesCodesEmploisItems = var1;
   }

   public boolean isAfficheCodesEmplois() {
      return this.afficheCodesEmplois;
   }

   public void setAfficheCodesEmplois(boolean var1) {
      this.afficheCodesEmplois = var1;
   }

   public List getLesContratsActifsItems() {
      return this.lesContratsActifsItems;
   }

   public void setLesContratsActifsItems(List var1) {
      this.lesContratsActifsItems = var1;
   }

   public List getMesTiersItems() {
      return this.mesTiersItems;
   }

   public void setMesTiersItems(List var1) {
      this.mesTiersItems = var1;
   }

   public boolean isAccesInterim() {
      return this.accesInterim;
   }

   public void setAccesInterim(boolean var1) {
      this.accesInterim = var1;
   }
}
