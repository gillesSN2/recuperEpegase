package com.epegase.forms.paye;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.BulletinSalaire;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesPaye;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.Parapheur;
import com.epegase.systeme.classe.Salaries;
import com.epegase.systeme.classe.SalariesConges;
import com.epegase.systeme.classe.SalariesContrats;
import com.epegase.systeme.classe.SalariesHistorique;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.dao.BulletinSalaireDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.HabilitationDao;
import com.epegase.systeme.dao.ParapheurDao;
import com.epegase.systeme.dao.SalariesCongesDao;
import com.epegase.systeme.dao.SalariesContratsDao;
import com.epegase.systeme.dao.SalariesDao;
import com.epegase.systeme.dao.SalariesHistoriqueDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilMail;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.ObjetCompte;
import com.epegase.systeme.xml.ObjetLigneOnglet;
import com.epegase.systeme.xml.OptionPaye;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
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

public class FormConges implements Serializable {
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
   private UsersChrono usersChronoConge = new UsersChrono();
   private UsersChrono usersChronoAbsence = new UsersChrono();
   private UsersChronoDao usersChronoDao;
   private int var_nb_max = 100;
   private String nomSalarie;
   private boolean valideSalarie;
   private UtilDate utilDate = new UtilDate();
   private boolean ctrlNbJour;
   private boolean var_acc_conges = false;
   private boolean var_acc_absences = false;
   private boolean var_ajt = false;
   private boolean var_mod = false;
   private boolean var_sup = false;
   private boolean var_imp = false;
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
   private List mesFeuillesContratItems = new ArrayList();
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
   private int memoNature;
   private Salaries salaries;
   private SalariesDao salariesDao;
   private boolean var_affiche_bouton = false;
   private boolean showModalVisuEtat = false;
   private SalariesConges salariesConges = new SalariesConges();
   private SalariesCongesDao salariesCongesDao;
   private transient DataModel dataModelConges = new ListDataModel();
   private UIDataTable extDTableCp = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEnteteCp = new SimpleSelection();
   private List lesSalariesConges = new ArrayList();
   private boolean var_affiche_conges = false;
   private int var_action_conges;
   private String var_lib_cp;
   private Calendar cal = Calendar.getInstance();
   private boolean ajoutCp = false;
   private boolean showModalPanelDemandeConges = false;
   private SalariesConges salariesAbsences = new SalariesConges();
   private transient DataModel dataModelAbsences = new ListDataModel();
   private UIDataTable extDTableAb = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEnteteAb = new SimpleSelection();
   private List lesSalariesAbsences = new ArrayList();
   private boolean var_affiche_absences = false;
   private int var_action_absences;
   private boolean showModalPanelDemandeAbsences = false;
   private List lesOrganesMedicauxItems = new ArrayList();
   private List documentImpressionItems = new ArrayList();
   private List listeImpressionItems = new ArrayList();
   private boolean showModalPanelPrint = false;
   private int var_modele;
   private FormRecherche formRecherche;
   private transient DataModel dataModelLotConges = new ListDataModel();
   private List lesSalaries = new ArrayList();
   private Date dateDebut;
   private Date dateFin;
   private float dureeCalculee;
   private String observation;
   private String responsable;
   private float nbInit;
   private float nbAcquis;
   private float nbPris;
   private float nbRestant;
   private String messageNbJourDispo;
   private SalariesHistoriqueDao salariesHistoriqueDao;
   private List lesSalariesHistorique = new ArrayList();
   private List lesBulletins = new ArrayList();
   private BulletinSalaireDao bulletinSalaireDao;
   private boolean showModalPanelInformation = false;
   private String nomCreation;
   private String nomModification;
   private List lesContratsActifsItems = new ArrayList();
   private SalariesContratsDao salariesContratsDao;

   public FormConges() throws IOException {
   }

   public void InstancesDaoUtilses() {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.salariesDao = new SalariesDao(this.baseLog, this.utilInitHibernate);
      this.salariesCongesDao = new SalariesCongesDao(this.baseLog, this.utilInitHibernate);
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.salariesContratsDao = new SalariesContratsDao(this.baseLog, this.utilInitHibernate);
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.habilitationDao = new HabilitationDao(this.baseLog, this.utilInitHibernate);
      this.salariesHistoriqueDao = new SalariesHistoriqueDao(this.baseLog, this.utilInitHibernate);
      this.bulletinSalaireDao = new BulletinSalaireDao(this.baseLog, this.utilInitHibernate);
   }

   public void initialisationCp(Session var1) throws HibernateException, NamingException {
      if (this.optionPaye.getNbLigneMax() != null && !this.optionPaye.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionPaye.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      this.var_pret_rec = 100;
      this.usersChronoConge = this.usersChronoDao.chronoByUserNat(this.usersLog, 88, var1);
      this.accesResteintUser();
      this.accesResteintGroupe();
      this.autorisationConges();
      if (this.mesCodesEmploisItems != null && this.mesCodesEmploisItems.size() != 0) {
         this.afficheCodesEmplois = true;
      } else {
         this.afficheCodesEmplois = false;
      }

   }

   public void initialisationAbs(Session var1) throws HibernateException, NamingException {
      if (this.optionPaye.getNbLigneMax() != null && !this.optionPaye.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionPaye.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      this.var_pret_rec = 100;
      this.usersChronoAbsence = this.usersChronoDao.chronoByUserNat(this.usersLog, 89, var1);
      this.accesResteintUser();
      this.accesResteintGroupe();
      this.autorisationAbsences();
      if (this.mesCodesEmploisItems != null && this.mesCodesEmploisItems.size() != 0) {
         this.afficheCodesEmplois = true;
      } else {
         this.afficheCodesEmplois = false;
      }

      TiersDao var2 = new TiersDao(this.baseLog, this.utilInitHibernate);
      this.lesOrganesMedicauxItems = var2.chargerLesOrganesMedicauxItems(var1);
   }

   public void accesResteintUser() {
   }

   public void accesResteintGroupe() throws HibernateException, NamingException {
      this.var_acc_conges = false;
      this.var_acc_absences = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (!var1.getCode().equals("1") && !var1.getCode().equals("2") && !var1.getCode().equals("3") && !var1.getCode().equals("4") && !var1.getCode().equals("5")) {
               if (var1.getCode().equals("6")) {
                  if (this.usersChronoConge != null) {
                     this.var_acc_conges = true;
                  }
               } else if (var1.getCode().equals("7")) {
                  if (this.usersChronoAbsence != null) {
                     this.var_acc_absences = true;
                  }
               } else if (!var1.getCode().equals("8") && !var1.getCode().equals("9") && var1.getCode().equals("10")) {
               }
            }
         }
      }

   }

   public void autorisationConges() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("6")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

   }

   public void autorisationAbsences() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("7")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

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

   public void chargerUserChronoConge(Session var1) throws HibernateException, NamingException {
      this.usersChronoConge = this.usersChronoDao.selectUnique("", 88, this.usersLog, var1);
   }

   public void chargerUserChronoAbsence(Session var1) throws HibernateException, NamingException {
      this.usersChronoAbsence = this.usersChronoDao.selectUnique("", 89, this.usersLog, var1);
   }

   public void moreSearch() {
      if (!this.var_more_search) {
         this.var_more_search = true;
      } else {
         this.var_more_search = false;
         this.var_convention_rec = "100";
      }

   }

   public void selectionCp() throws HibernateException, NamingException {
      if (this.extDTableCp != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelectionEnteteCp.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTableCp.setRowKey(var3);
            if (this.extDTableCp.isRowAvailable()) {
               var1.add(this.extDTableCp.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.salariesConges = (SalariesConges)var1.get(0);
            this.salaries = this.salariesConges.getSalaries();
            this.var_lib_cp = this.salariesConges.getLib_nature();
            this.var_affiche_conges = true;
            this.memoNature = this.salariesConges.getSalcngNature();
            this.calculContrat((Session)null);
         } else {
            this.var_affiche_conges = false;
         }
      } else {
         this.var_affiche_conges = false;
      }

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

   public void visualisationCp() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.salariesConges != null) {
         if (this.salariesConges.getSalcngEtat() == 0) {
            this.modifierElementCp();
         } else {
            this.consulterElementCp();
         }
      }

   }

   public String matPeriodeConges() {
      String var1 = "";
      if (this.salariesConges != null) {
         String var2 = "";
         if (this.salariesConges.getSalcngDateDebut().getMonth() + 1 <= 9) {
            var2 = "0" + (this.salariesConges.getSalcngDateDebut().getMonth() + 1);
         } else {
            var2 = "" + (this.salariesConges.getSalcngDateDebut().getMonth() + 1);
         }

         String var3 = "" + (this.salariesConges.getSalcngDateDebut().getYear() + 1900);
         var1 = var2 + ":" + var3 + ":" + this.salariesConges.getSalaries().getSalMatricule();
      }

      return var1;
   }

   public void recupererCp() {
      this.lesSalariesConges.clear();
      this.dataModelConges.setWrappedData(this.lesSalariesConges);
      this.var_affiche_conges = false;
   }

   public void rechercherSalarieCp() throws HibernateException, NamingException {
      this.rechercherSalarieCp((Session)null);
   }

   public void rechercherSalarieCp(Session var1) throws HibernateException, NamingException {
      this.lesSalariesConges.clear();
      this.extDTableCp = new HtmlExtendedDataTable();
      this.simpleSelectionEnteteCp.clear();
      new ArrayList();
      List var2 = this.salariesCongesDao.chargerlesElementCp(this.inpDu, this.inpAu, this.var_nat_rec, this.var_valide_rec, this.var_etat_rec, this.var_feuille_rec, this.var_nature_rec, this.var_site_rec, this.var_departement_rec, this.var_service_rec, this.var_activite_rec, this.var_convention_rec, this.var_niveau_rec, this.var_classement_rec, this.var_grille_rec, this.var_centre_rec, this.exercicesPaye, var1);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            this.salariesConges = (SalariesConges)var2.get(var3);
            boolean var4 = false;
            if (this.salariesConges.getSalaries().getSalNature() != null && !this.salariesConges.getSalaries().getSalNature().isEmpty()) {
               for(int var5 = 0; var5 < this.mesNatureAgentItems.size(); ++var5) {
                  if (((SelectItem)this.mesNatureAgentItems.get(var5)).getValue().toString().equals(this.salariesConges.getSalaries().getSalNature())) {
                     var4 = true;
                     break;
                  }
               }
            }

            if (var4) {
               this.lesSalariesConges.add(this.salariesConges);
            }
         }
      }

      this.dataModelConges.setWrappedData(this.lesSalariesConges);
   }

   public void calculeConges() {
      this.lesSalariesConges.clear();
      this.dataModelConges.setWrappedData(this.lesSalariesConges);
      this.var_affiche_conges = false;
      if (this.var_nat_rec == 90) {
         this.ajoutCp = false;
      } else {
         this.ajoutCp = true;
      }

   }

   public void ajouterElementCp() throws HibernateException, NamingException {
      if (this.var_nat_rec >= 0 && this.var_nat_rec < 30) {
         this.salaries = new Salaries();
         this.salariesConges = new SalariesConges();
         this.salariesConges.setSalcngNature(this.var_nat_rec);
         this.var_lib_cp = this.salariesConges.getLib_nature();
         this.nomSalarie = "";
         this.var_action_conges = 1;
         this.var_action = 1;
         this.memoNature = 9999;
         this.ctrlNbJour = false;
         this.var_memo_action = this.var_action;
      }

   }

   public void modifierElementCp() throws HibernateException, NamingException {
      if (this.salariesConges != null) {
         this.var_action_conges = 2;
         this.var_action = 2;
         this.var_memo_action = this.var_action;
      }

   }

   public void consulterElementCp() throws HibernateException, NamingException {
      if (this.salariesConges != null) {
         this.var_action_conges = 3;
         this.var_action = 3;
         this.var_memo_action = this.var_action;
      }

   }

   public void supprimerElementCp() throws HibernateException, NamingException {
      if (this.salariesConges != null) {
         if (this.salariesConges != null) {
            Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
            Transaction var2 = null;

            try {
               var2 = var1.beginTransaction();
               Habilitation var3 = this.verifHabilitation(88, var1);
               if (var3 != null) {
                  new Parapheur();
                  ParapheurDao var5 = new ParapheurDao(this.baseLog, this.utilInitHibernate);
                  Parapheur var4 = var5.existenceParapheur(this.salariesConges.getSalcngId(), 88, var1);
                  if (var4 != null) {
                     var5.delete(var4, var1);
                  }
               }

               this.lesSalariesConges.remove(this.salariesConges);
               this.dataModelConges.setWrappedData(this.lesSalariesConges);
               this.salariesCongesDao.delete(this.salariesConges, var1);
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

         this.var_action = 0;
         this.extDTableCp = new HtmlExtendedDataTable();
         this.simpleSelectionEnteteCp.clear();
      }

   }

   public void annulerElementCp() {
      this.var_action = 0;
      this.showModalPanelDemandeConges = false;
      this.var_memo_action = this.var_action;
      this.simpleSelectionEnteteCp.clear();
      this.extDTableCp = new HtmlExtendedDataTable();
   }

   public void calculDureeConges() {
      float var1 = 0.0F;
      if (this.salariesConges.getSalcngDateDebut() != null && this.salariesConges.getSalcngDateFin() != null) {
         var1 = (float)((this.salariesConges.getSalcngDateFin().getTime() - this.salariesConges.getSalcngDateDebut().getTime()) / 86400000L + 1L) - this.salariesConges.getSalcngNbJoursExclus();
         this.salariesConges.setSalcngDuree(var1);
      } else {
         this.salariesConges.setSalcngDuree(0.0F);
      }

      this.messageNbJourDispo = "";
      if (this.var_nat_rec == 6) {
         if (var1 <= this.nbRestant) {
            this.ctrlNbJour = true;
         } else {
            this.messageNbJourDispo = "Nombre de jours demandés: " + var1 + ". Nombre de jours disponibles: " + this.nbRestant + ". Le nombre de jours est insuffisant";
            this.formRecherche.setMessageTexte(this.messageNbJourDispo);
            this.formRecherche.setShowModalPanelMessage(true);
            this.ctrlNbJour = false;
         }
      } else {
         this.ctrlNbJour = true;
      }

   }

   public void saveConges() throws HibernateException, NamingException, Exception {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.salariesConges.getSalcngDateDebut() != null && this.salariesConges.getSalcngDateFin() != null) {
            Habilitation var3 = this.verifHabilitation(88, var1);
            if (var3 != null) {
               this.salariesConges.setSalcngEtatVal(1);
               this.salariesConges.setSalcngEtat(0);
               this.salariesConges.setSalcngDateValide((Date)null);
            } else {
               this.salariesConges.setSalcngEtatVal(0);
               if (this.salariesConges.getSalcngDateImp() != null) {
                  if (this.salariesConges.getSalcngEtat() == 0) {
                     this.salariesConges.setSalcngEtat(1);
                     this.salariesConges.setSalcngDateValide(new Date());
                  }
               } else {
                  this.salariesConges.setSalcngEtat(0);
                  this.salariesConges.setSalcngDateValide((Date)null);
               }
            }

            this.salariesConges.setSalcngType(0);
            if (this.salariesConges.getSalcngNature() == 8) {
               this.salariesConges.setSalcngDateDebut(new Date());
               this.cal.setMinimalDaysInFirstWeek(4);
               this.cal.setTime(this.salariesConges.getSalcngDateDebut());
               this.salariesConges.setSalcngSemaineDebut(this.cal.get(3));
               if (this.salariesConges.getSalcngSemaineDebut() >= 53) {
                  this.salariesConges.setSalcngSemaineDebut(1);
               }
            } else {
               this.calculDureeConges();
               if (this.salariesConges.getSalcngDateDebut() != null) {
                  this.cal.setMinimalDaysInFirstWeek(4);
                  this.cal.setTime(this.salariesConges.getSalcngDateDebut());
                  this.salariesConges.setSalcngSemaineDebut(this.cal.get(3));
                  if (this.salariesConges.getSalcngSemaineDebut() >= 53) {
                     this.salariesConges.setSalcngSemaineDebut(1);
                  }
               } else {
                  this.salariesConges.setSalcngSemaineDebut(0);
               }

               if (this.salariesConges.getSalcngDateFin() != null) {
                  this.cal.setMinimalDaysInFirstWeek(4);
                  this.cal.setTime(this.salariesConges.getSalcngDateFin());
                  this.salariesConges.setSalcngSemaineFin(this.cal.get(3));
                  if (this.salariesConges.getSalcngSemaineFin() >= 53) {
                     this.salariesConges.setSalcngSemaineFin(1);
                  }
               } else {
                  this.salariesConges.setSalcngSemaineFin(0);
               }
            }

            if (this.salariesConges.getSalcngId() == 0L) {
               this.salariesConges.setSalaries(this.salaries);
               this.salariesConges.setSalcngDateCreat(new Date());
               this.salariesConges.setSalcngUserCreat(this.usersLog.getUsrid());
               this.salariesConges = this.salariesCongesDao.insert(this.salariesConges, var1);
               if (var3 != null) {
                  this.majParapheur(88, var3, var1);
               }

               this.lesSalariesConges.add(this.salariesConges);
               this.dataModelConges.setWrappedData(this.lesSalariesConges);
               this.simpleSelectionEnteteCp.clear();
               this.extDTableCp = new HtmlExtendedDataTable();
            } else {
               this.salariesConges.setSalcngDateModif(new Date());
               this.salariesConges.setSalcngUserModif(this.usersLog.getUsrid());
               this.salariesConges = this.salariesCongesDao.modif(this.salariesConges, var1);
            }

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

      this.var_action = 0;
      this.envoieMailConges();
      this.showModalPanelDemandeConges = false;
   }

   public void valideConges() throws HibernateException, NamingException {
      if (this.salariesConges != null) {
         this.salariesConges.setSalcngEtat(1);
         this.salariesConges = this.salariesCongesDao.modif(this.salariesConges);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         var1.setEspaction("Validation manuelle congés (P.) N° " + this.salariesConges.getSalcngId() + " du " + this.utilDate.dateToStringSQLLight(this.salariesConges.getSalcngDateDebut()));
         this.espionDao.mAJEspion(var1);
      }

   }

   public void deValideConge() throws HibernateException, NamingException {
      if (this.salariesConges != null) {
         this.salariesConges.setSalcngEtat(0);
         this.salariesConges = this.salariesCongesDao.modif(this.salariesConges);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         var1.setEspaction("Dévalidation manuelle congés (P.) N° " + this.salariesConges.getSalcngId() + " du " + this.utilDate.dateToStringSQLLight(this.salariesConges.getSalcngDateDebut()));
         this.espionDao.mAJEspion(var1);
      }

   }

   public void envoieMailConges() throws Exception {
      if (this.memoNature == 0 && this.memoNature != this.salariesConges.getSalcngNature()) {
         UtilMail var1 = new UtilMail(this.structureLog);
         var1.envoieMailCpAbs(this.structureLog, this.usersLog, this.salariesConges, this.utilDate);
      }

   }

   public void informationPieceCPS() throws HibernateException, NamingException {
      if (this.salariesConges != null) {
         this.nomCreation = "";
         this.nomModification = "";
         new Users();
         UserDao var2 = new UserDao(this.baseLog, this.utilInitHibernate);
         Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         Users var1;
         if (this.salariesConges.getSalcngUserCreat() != 0L) {
            var1 = var2.selectUserD(this.salariesConges.getSalcngUserCreat(), var3);
            if (var1 != null) {
               this.nomCreation = var1.getUsrPatronyme();
            }
         }

         if (this.salariesConges.getSalcngUserModif() != 0L) {
            var1 = var2.selectUserD(this.salariesConges.getSalcngUserModif(), var3);
            if (var1 != null) {
               this.nomModification = var1.getUsrPatronyme();
            }
         }

         this.utilInitHibernate.closeSession();
         this.showModalPanelInformation = true;
      }

   }

   public void informationPieceABS() throws HibernateException, NamingException {
      if (this.salariesAbsences != null) {
         this.nomCreation = "";
         this.nomModification = "";
         new Users();
         UserDao var2 = new UserDao(this.baseLog, this.utilInitHibernate);
         Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         Users var1;
         if (this.salariesAbsences.getSalcngUserCreat() != 0L) {
            var1 = var2.selectUserD(this.salariesAbsences.getSalcngUserCreat(), var3);
            if (var1 != null) {
               this.nomCreation = var1.getUsrPatronyme();
            }
         }

         if (this.salariesAbsences.getSalcngUserModif() != 0L) {
            var1 = var2.selectUserD(this.salariesAbsences.getSalcngUserModif(), var3);
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

   public void ajouterLotCp() {
      if (this.var_nat_rec >= 0 && this.var_nat_rec < 30) {
         this.salaries = new Salaries();
         this.salariesConges = new SalariesConges();
         this.var_lib_cp = this.salariesConges.getLib_nature();
         this.nomSalarie = "";
         this.var_action_conges = 10;
         this.var_action = 10;
         this.memoNature = 9999;
         this.lesSalaries.clear();
         this.dataModelLotConges.setWrappedData(this.lesSalaries);
         this.dateDebut = null;
         this.dateFin = null;
         this.dureeCalculee = 0.0F;
         this.observation = "";
         this.responsable = "";
         this.var_memo_action = this.var_action;
      }

   }

   public void calculDureeCalculee() {
      if (this.dateDebut != null && this.dateFin != null) {
         float var1 = 0.0F;
         var1 = (float)((this.dateFin.getTime() - this.dateDebut.getTime()) / 86400000L + 1L);
         this.dureeCalculee = var1;
      } else {
         this.dureeCalculee = 0.0F;
      }

   }

   public void annulerLotCp() {
      this.var_action = 0;
   }

   public void validerLotCp() throws HibernateException, NamingException {
      this.lesSalariesConges.clear();
      if (this.dateDebut != null && this.dateFin != null && this.dureeCalculee != 0.0F && this.lesSalaries.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.lesSalaries.size(); ++var3) {
               this.salaries = (Salaries)this.lesSalaries.get(var3);
               if (this.salaries.isSelect_agent()) {
                  this.salariesConges = new SalariesConges();
                  this.salariesConges.setSalcngDateCreat(new Date());
                  this.salariesConges.setSalcngDateDebut(this.dateDebut);
                  if (this.salariesConges.getSalcngDateDebut() != null) {
                     this.cal.setMinimalDaysInFirstWeek(4);
                     this.cal.setTime(this.salariesConges.getSalcngDateDebut());
                     this.salariesConges.setSalcngSemaineDebut(this.cal.get(3));
                     if (this.salariesConges.getSalcngSemaineDebut() >= 53) {
                        this.salariesConges.setSalcngSemaineDebut(1);
                     }
                  } else {
                     this.salariesConges.setSalcngSemaineDebut(0);
                  }

                  this.salariesConges.setSalcngDateFin(this.dateFin);
                  if (this.salariesConges.getSalcngDateFin() != null) {
                     this.cal.setMinimalDaysInFirstWeek(4);
                     this.cal.setTime(this.salariesConges.getSalcngDateFin());
                     this.salariesConges.setSalcngSemaineFin(this.cal.get(3));
                     if (this.salariesConges.getSalcngSemaineFin() >= 53) {
                        this.salariesConges.setSalcngSemaineFin(1);
                     }
                  } else {
                     this.salariesConges.setSalcngSemaineFin(0);
                  }

                  this.calculDureeCalculee();
                  this.salariesConges.setSalcngDuree(this.dureeCalculee);
                  this.salariesConges.setSalcngEtat(1);
                  this.salariesConges.setSalcngDateValide(new Date());
                  this.salariesConges.setSalcngNature(this.var_nat_rec);
                  this.salariesConges.setSalcngObjet(this.observation);
                  this.salariesConges.setSalcngResponsable(this.responsable);
                  this.salariesConges.setSalcngType(0);
                  this.salariesConges.setSalcngUserCreat(this.usersLog.getUsrid());
                  this.salariesConges.setSalaries(this.salaries);
                  this.salariesConges = this.salariesCongesDao.insert(this.salariesConges, var1);
                  this.lesSalariesConges.add(this.salariesConges);
               }
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

      this.dataModelConges.setWrappedData(this.lesSalariesConges);
      this.var_action = 0;
   }

   public void toutSelectionner() {
      if (this.lesSalaries.size() != 0) {
         for(int var1 = 0; var1 < this.lesSalaries.size(); ++var1) {
            this.salaries = (Salaries)this.lesSalaries.get(var1);
            this.salaries.setSelect_agent(true);
         }
      }

      this.dataModelLotConges.setWrappedData(this.lesSalaries);
   }

   public void rienSelectionner() {
      if (this.lesSalaries.size() != 0) {
         for(int var1 = 0; var1 < this.lesSalaries.size(); ++var1) {
            this.salaries = (Salaries)this.lesSalaries.get(var1);
            this.salaries.setSelect_agent(false);
         }
      }

      this.dataModelLotConges.setWrappedData(this.lesSalaries);
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

      this.lesSalaries.clear();
      Date var6 = null;
      Date var4 = null;
      if (this.exercicesPaye.getExepayId() != this.lastExoPaye.getExepayId()) {
         var6 = this.utilDate.stringToDateSQLLight("2000-01-01");
         var4 = this.exercicesPaye.getExepayDateDebut();
      }

      int var5 = Integer.parseInt(this.optionPaye.getTriAgents());
      this.lesSalaries = this.salariesDao.rechercheSalaries(false, var5, var2, this.var_etat_rec, this.var_immat_rec, this.var_nom_rec, this.var_feuille_rec, this.var_nature_rec, this.var_site_rec, this.var_departement_rec, this.var_service_rec, this.var_activite_rec, this.var_convention_rec, this.var_niveau_rec, this.var_classement_rec, this.var_grille_rec, this.var_centre_rec, var6, var4, var1);
      this.dataModelLotConges.setWrappedData(this.lesSalaries);
   }

   public void recupererAbs() {
      this.lesSalariesAbsences.clear();
      this.dataModelAbsences.setWrappedData(this.lesSalariesAbsences);
      this.var_affiche_absences = false;
   }

   public void rechercherSalarieAbs() throws HibernateException, NamingException {
      this.rechercherSalarieAbs((Session)null);
   }

   public void rechercherSalarieAbs(Session var1) throws HibernateException, NamingException {
      this.lesSalariesAbsences.clear();
      this.extDTableAb = new HtmlExtendedDataTable();
      this.simpleSelectionEnteteAb.clear();
      new ArrayList();
      List var2 = this.salariesCongesDao.chargerlesElementAbs(this.inpDu, this.inpAu, this.var_nat_rec, this.var_valide_rec, this.var_etat_rec, this.var_feuille_rec, this.var_nature_rec, this.var_site_rec, this.var_departement_rec, this.var_service_rec, this.var_activite_rec, this.var_convention_rec, this.var_niveau_rec, this.var_classement_rec, this.var_grille_rec, this.var_centre_rec, this.exercicesPaye, var1);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            this.salariesAbsences = (SalariesConges)var2.get(var3);
            boolean var4 = false;
            if (this.salariesAbsences.getSalaries().getSalNature() != null && !this.salariesAbsences.getSalaries().getSalNature().isEmpty()) {
               for(int var5 = 0; var5 < this.mesNatureAgentItems.size(); ++var5) {
                  if (((SelectItem)this.mesNatureAgentItems.get(var5)).getValue().toString().equals(this.salariesAbsences.getSalaries().getSalNature())) {
                     var4 = true;
                     break;
                  }
               }
            }

            if (var4) {
               this.lesSalariesAbsences.add(this.salariesAbsences);
            }
         }
      }

      this.dataModelAbsences.setWrappedData(this.lesSalariesAbsences);
   }

   public void selectionAbsences() {
      if (this.extDTableAb != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelectionEnteteAb.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTableAb.setRowKey(var3);
            if (this.extDTableAb.isRowAvailable()) {
               var1.add(this.extDTableAb.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.salariesAbsences = (SalariesConges)var1.get(0);
            this.salaries = this.salariesAbsences.getSalaries();
            this.var_lib_cp = this.salariesAbsences.getLib_nature();
            this.var_affiche_absences = true;
            this.memoNature = this.salariesAbsences.getSalcngNature();
         } else {
            this.var_affiche_absences = false;
         }
      } else {
         this.var_affiche_absences = false;
      }

   }

   public void visualisationAbsences() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.salariesAbsences != null) {
         if (this.salariesAbsences.getSalcngEtat() == 0) {
            this.modifierAbsences();
         } else {
            this.consulterAbsences();
         }
      }

   }

   public String matPeriodeAbsences() {
      String var1 = "";
      if (this.salariesAbsences != null) {
         String var2 = "";
         if (this.salariesAbsences.getSalcngDateDebut().getMonth() + 1 <= 9) {
            var2 = "0" + (this.salariesAbsences.getSalcngDateDebut().getMonth() + 1);
         } else {
            var2 = "" + (this.salariesAbsences.getSalcngDateDebut().getMonth() + 1);
         }

         String var3 = "" + (this.salariesAbsences.getSalcngDateDebut().getYear() + 1900);
         var1 = var2 + ":" + var3 + ":" + this.salariesAbsences.getSalaries().getSalMatricule();
      }

      return var1;
   }

   public void ajouterAbsences() {
      if (this.var_nat_rec >= 0 && this.var_nat_rec < 30) {
         this.salaries = new Salaries();
         this.salariesAbsences = new SalariesConges();
         this.salariesAbsences.setSalcngNature(this.var_nat_rec);
         this.var_lib_cp = this.salariesAbsences.getLib_nature();
         this.salariesAbsences.setSalcngDateDebut(new Date());
         this.salariesAbsences.setSalcngDateFin((Date)null);
         this.salariesAbsences.setSalcngNbJoursExclus(0.0F);
         this.nomSalarie = "";
         this.var_action_absences = 1;
         this.var_action = 1;
         this.memoNature = 9999;
         this.var_memo_action = this.var_action;
      }

   }

   public void modifierAbsences() {
      if (this.salariesAbsences != null) {
         this.var_action_absences = 2;
         this.var_action = 2;
         this.var_memo_action = this.var_action;
      }

   }

   public void consulterAbsences() {
      if (this.salariesAbsences != null) {
         this.var_action_absences = 3;
         this.var_action = 3;
         this.var_memo_action = this.var_action;
      }

   }

   public void supprimerAbsences() throws HibernateException, NamingException {
      if (this.salariesAbsences != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            Habilitation var3 = this.verifHabilitation(89, var1);
            if (var3 != null) {
               new Parapheur();
               ParapheurDao var5 = new ParapheurDao(this.baseLog, this.utilInitHibernate);
               Parapheur var4 = var5.existenceParapheur(this.salariesConges.getSalcngId(), 89, var1);
               if (var4 != null) {
                  var5.delete(var4, var1);
               }
            }

            this.lesSalariesAbsences.remove(this.salariesAbsences);
            this.dataModelAbsences.setWrappedData(this.lesSalariesAbsences);
            this.salariesCongesDao.delete(this.salariesAbsences, var1);
            var2.commit();
         } catch (HibernateException var9) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var9;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.var_action = 0;
         this.extDTableAb = new HtmlExtendedDataTable();
         this.simpleSelectionEnteteAb.clear();
      }

   }

   public void annulerAbsences() {
      this.var_affiche_absences = false;
      this.var_action = 0;
      this.showModalPanelDemandeAbsences = false;
      this.var_memo_action = this.var_action;
      this.simpleSelectionEnteteAb.clear();
      this.extDTableAb = new HtmlExtendedDataTable();
   }

   public void calculDureeAbsences() {
      float var1 = 0.0F;
      if (this.salariesAbsences.getSalcngNature() != 14 && this.salariesAbsences.getSalcngNature() != 15) {
         if (this.salariesAbsences.getSalcngDateDebut() != null && this.salariesAbsences.getSalcngDateFin() != null) {
            var1 = (float)((this.salariesAbsences.getSalcngDateFin().getTime() - this.salariesAbsences.getSalcngDateDebut().getTime()) / 86400000L);
         }

         if (this.salariesAbsences.isSalcngAm()) {
            var1 += 0.5F;
         }

         if (this.salariesAbsences.isSalcngPm()) {
            var1 += 0.5F;
         }
      }

      this.salariesAbsences.setSalcngDuree(var1);
      if (this.salariesAbsences.getSalcngDuree() == 0.0F) {
         this.salariesAbsences.setSalcngNbJoursExclus(0.0F);
      } else if (this.salariesAbsences.getSalcngNbJoursExclus() != 0.0F && this.salariesAbsences.getSalcngNbJoursExclus() > this.salariesAbsences.getSalcngDuree()) {
         this.salariesAbsences.setSalcngNbJoursExclus(this.salariesAbsences.getSalcngDuree());
      }

      this.ctrlNbJour = true;
   }

   public void saveAbsences() throws HibernateException, NamingException, Exception {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.salariesAbsences.getSalcngDateDebut() != null) {
            Habilitation var3 = this.verifHabilitation(89, var1);
            if (var3 != null) {
               this.salariesAbsences.setSalcngEtatVal(1);
               this.salariesAbsences.setSalcngEtat(0);
               this.salariesAbsences.setSalcngDateValide((Date)null);
            } else {
               this.salariesAbsences.setSalcngEtatVal(0);
               if (this.salariesAbsences.getSalcngDateImp() != null) {
                  if (this.salariesAbsences.getSalcngEtat() == 0) {
                     this.salariesAbsences.setSalcngEtat(1);
                     this.salariesAbsences.setSalcngDateValide(new Date());
                  }
               } else {
                  this.salariesAbsences.setSalcngEtat(0);
                  this.salariesAbsences.setSalcngDateValide((Date)null);
               }
            }

            this.salariesAbsences.setSalcngType(1);
            this.calculDureeAbsences();
            if (this.salariesAbsences.getSalcngDateDebut() != null) {
               this.cal.setMinimalDaysInFirstWeek(4);
               this.cal.setTime(this.salariesAbsences.getSalcngDateDebut());
               this.salariesAbsences.setSalcngSemaineDebut(this.cal.get(3));
               if (this.salariesAbsences.getSalcngSemaineDebut() >= 53) {
                  this.salariesAbsences.setSalcngSemaineDebut(1);
               }
            } else {
               this.salariesAbsences.setSalcngSemaineDebut(0);
            }

            if (this.salariesAbsences.getSalcngDateFin() != null) {
               this.cal.setMinimalDaysInFirstWeek(4);
               this.cal.setTime(this.salariesAbsences.getSalcngDateFin());
               this.salariesAbsences.setSalcngSemaineFin(this.cal.get(3));
               if (this.salariesAbsences.getSalcngSemaineFin() >= 53) {
                  this.salariesAbsences.setSalcngSemaineFin(1);
               }
            } else {
               this.salariesAbsences.setSalcngSemaineFin(0);
            }

            if (this.salariesAbsences.getSalcngId() == 0L) {
               this.salariesAbsences.setSalaries(this.salaries);
               this.salariesAbsences.setSalcngDateCreat(new Date());
               this.salariesAbsences.setSalcngUserCreat(this.usersLog.getUsrid());
               this.salariesAbsences = this.salariesCongesDao.insert(this.salariesAbsences, var1);
               if (var3 != null) {
                  this.majParapheur(89, var3, var1);
               }

               this.lesSalariesAbsences.add(this.salariesAbsences);
               this.dataModelAbsences.setWrappedData(this.lesSalariesAbsences);
               this.simpleSelectionEnteteAb.clear();
               this.extDTableAb = new HtmlExtendedDataTable();
            } else {
               this.salariesAbsences.setSalcngDateModif(new Date());
               this.salariesAbsences.setSalcngUserModif(this.usersLog.getUsrid());
               this.salariesAbsences = this.salariesCongesDao.modif(this.salariesAbsences, var1);
            }

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

      this.var_action = 0;
      this.envoieMailAbsences();
      this.showModalPanelDemandeAbsences = false;
   }

   public void valideAbsences() throws HibernateException, NamingException {
      if (this.salariesAbsences != null) {
         this.salariesAbsences.setSalcngEtat(1);
         this.salariesAbsences = this.salariesCongesDao.modif(this.salariesAbsences);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         var1.setEspaction("Validation manuelle absence (P.) N° " + this.salariesAbsences.getSalcngId() + " du " + this.utilDate.dateToStringSQLLight(this.salariesAbsences.getSalcngDateDebut()));
         this.espionDao.mAJEspion(var1);
      }

   }

   public void deValideAbsences() throws HibernateException, NamingException {
      if (this.salariesAbsences != null) {
         this.salariesAbsences.setSalcngEtat(0);
         this.salariesAbsences = this.salariesCongesDao.modif(this.salariesAbsences);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         var1.setEspaction("Dévalidation manuelle absence (P.) N° " + this.salariesAbsences.getSalcngId() + " du " + this.utilDate.dateToStringSQLLight(this.salariesAbsences.getSalcngDateDebut()));
         this.espionDao.mAJEspion(var1);
      }

   }

   public void envoieMailAbsences() throws Exception {
      if (this.memoNature == 0 && this.memoNature != this.salariesAbsences.getSalcngNature()) {
         UtilMail var1 = new UtilMail(this.structureLog);
         var1.envoieMailCpAbs(this.structureLog, this.usersLog, this.salariesAbsences, this.utilDate);
      }

   }

   public void historiqueCp(long var1, Session var3) throws HibernateException, NamingException {
      if (var1 != 0L) {
         this.nbInit = 0.0F;
         this.nbAcquis = 0.0F;
         this.nbPris = 0.0F;
         this.nbRestant = 0.0F;
         this.salaries = this.salariesDao.chercherIdSalaries(var1, var3);
         if (this.salaries != null) {
            this.lesSalariesConges.clear();
            this.lesSalariesConges = this.salariesCongesDao.chargerlesConges(this.salaries, var3);
            this.dataModelConges.setWrappedData(this.lesSalariesConges);
            this.lesSalariesHistorique.clear();
            this.lesSalariesHistorique.clear();
            this.lesSalariesHistorique = this.salariesHistoriqueDao.chargerlesHistoriquesBySalaries(this.salaries, "", this.exercicesPaye, var3);
            int var4;
            if (this.lesSalariesHistorique.size() != 0) {
               for(var4 = 0; var4 < this.lesSalariesHistorique.size(); ++var4) {
                  if (((SalariesHistorique)this.lesSalariesHistorique.get(var4)).getSalhisCode().equals("NBJS")) {
                     this.nbInit = (float)((SalariesHistorique)this.lesSalariesHistorique.get(var4)).getSalhisValeurColE();
                     break;
                  }
               }
            }

            this.lesBulletins.clear();
            this.lesBulletins = this.bulletinSalaireDao.chargerlesBulletinsbySalarieExercice(this.salaries, this.exercicesPaye, var3);
            if (this.lesBulletins.size() != 0) {
               for(var4 = 0; var4 < this.lesBulletins.size(); ++var4) {
                  this.nbAcquis += ((BulletinSalaire)this.lesBulletins.get(var4)).getBulsalNbCpAcquis();
                  this.nbPris += ((BulletinSalaire)this.lesBulletins.get(var4)).getBulsalNbCpPris();
               }
            }

            this.nbRestant = this.nbInit + this.nbAcquis - this.nbPris;
         }
      }

   }

   public void ajouterDemandeConges() {
      if (this.salaries != null) {
         this.salariesConges = new SalariesConges();
         this.salariesConges.setSalaries(this.salaries);
         this.salariesConges.setSalcngNature(0);
         this.var_action_conges = 1;
         this.showModalPanelDemandeConges = true;
         this.memoNature = 9999;
      }

   }

   public void historiqueAbsences(long var1, Session var3) throws HibernateException, NamingException {
      if (var1 != 0L) {
         this.salaries = this.salariesDao.chercherIdSalaries(var1, var3);
         if (this.salaries != null) {
            this.lesSalariesAbsences.clear();
            this.lesSalariesAbsences = this.salariesCongesDao.chargerlesAbsences(this.salaries, var3);
            this.dataModelAbsences.setWrappedData(this.lesSalariesAbsences);
         }
      }

   }

   public void ajouterDemandeAbsences() {
      this.salariesAbsences = new SalariesConges();
      this.salariesAbsences.setSalaries(this.salaries);
      this.salariesAbsences.setSalcngNature(10);
      this.var_action_absences = 1;
      this.showModalPanelDemandeAbsences = true;
      this.memoNature = 9999;
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
      var4.setPhrDocId(this.salariesConges.getSalcngId());
      var4.setPhrNum("" + this.salariesConges.getSalcngId());
      var4.setPhrDate(this.salariesConges.getSalcngDateDebut());
      if (var4.getPhrId() == 0L) {
         var5.insert(var4, var3);
      } else {
         var5.modif(var4, var3);
      }

   }

   public void rechercheSalarie() throws JDOMException, IOException, HibernateException, NamingException {
      this.salaries = this.formRecherche.rechercheSalarie(this.nomSalarie, this.nature, this.exercicesPaye.getExepayId());
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
         this.nomSalarie = "";
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         this.historiqueCp(this.salaries.getSalId(), var1);
         this.calculContrat(var1);
         this.utilInitHibernate.closeSession();
      } else {
         this.annuleSalarie();
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleSalarie() {
      this.salaries = new Salaries();
      this.nomSalarie = "";
      this.nbInit = 0.0F;
      this.nbAcquis = 0.0F;
      this.nbPris = 0.0F;
      this.nbRestant = 0.0F;
      this.lesSalariesHistorique.clear();
      this.lesBulletins.clear();
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
      String var1 = "";
      if (this.nature == 88) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "liste" + File.separator + "cp";
      } else if (this.nature == 89) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "liste" + File.separator + "abs";
      }

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

      if (this.nature == 88) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "document" + File.separator + "cp";
      } else if (this.nature == 89) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "document" + File.separator + "abs";
      }

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

   public void impression(UtilPrint var1, int var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10) throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      if (var3 != null && !var3.isEmpty() || var4 != null && !var4.isEmpty()) {
         if (var1 == null) {
            var1 = new UtilPrint(this.utilInitHibernate);
         }

         ArrayList var11;
         JRBeanCollectionDataSource var12;
         String var13;
         if (this.nature == 88) {
            if (var2 == 0) {
               var1.setRapport(var3);
               var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "document" + File.separator + "cp" + File.separator);
               var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "sous_rapport" + File.separator);
               var1.setEntete("Impression du congés N° : " + this.salariesConges.getSalcngId() + " Agent " + this.salaries.getSalMatricule() + " " + this.salaries.getSalNom());
               var1.setFormat(var5);
               var1.setMatricule(this.salaries.getSalMatricule());
               var1.setEmetteur(var6);
               var1.setDestinataire(var7);
               var1.setDestinataireCC(var8);
               var1.setDestinataireCCI(var9);
               var1.setCorpsMail(var10);
               var1.setTiersSelectionne((Tiers)null);
               var11 = new ArrayList();
               var11.add(this.salariesConges);
               var12 = new JRBeanCollectionDataSource(var11);
               var1.setjRBeanCollectionDataSource(var12);
               var1.setBaseLog(this.baseLog);
               var1.setStructureLog(this.structureLog);
               var1.setUsersLog(this.usersLog);
               var1.imprimeRapport();
            } else if (var2 == 1) {
               var1.setRapport(var4);
               var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "liste" + File.separator + "cp" + File.separator);
               var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "sous_rapport" + File.separator);
               var13 = "";
               if (this.var_nat_rec == 0) {
                  var13 = "Demande de Congés";
               } else if (this.var_nat_rec == 1) {
                  var13 = "Congés normaux (Solde total)";
               } else if (this.var_nat_rec == 2) {
                  var13 = "Bulletin de congés";
               } else if (this.var_nat_rec == 3) {
                  var13 = "Congés travaillés";
               } else if (this.var_nat_rec == 4) {
                  var13 = "Congés non calculés";
               } else if (this.var_nat_rec == 5) {
                  var13 = "Congés de Maternité";
               } else if (this.var_nat_rec == 6) {
                  var13 = "Congés normaux (Nb jours pris)";
               } else if (this.var_nat_rec == 7) {
                  var13 = "Mise à disposition";
               } else if (this.var_nat_rec == 8) {
                  var13 = "";
               } else if (this.var_nat_rec == 9) {
                  var13 = "Tous les congés";
               }

               var1.setEntete("Impression Liste : " + var13);
               var1.setFormat(var5);
               var1.setEmetteur(var6);
               var1.setDestinataire(var7);
               var1.setDestinataireCC(var8);
               var1.setDestinataireCCI(var9);
               var1.setCorpsMail(var10);
               var1.setTiersSelectionne((Tiers)null);
               var12 = new JRBeanCollectionDataSource(this.lesSalariesConges);
               var1.setjRBeanCollectionDataSource(var12);
               var1.setBaseLog(this.baseLog);
               var1.setStructureLog(this.structureLog);
               var1.setUsersLog(this.usersLog);
               var1.imprimeRapport();
            }
         } else if (this.nature == 89) {
            if (var2 == 0) {
               var1.setRapport(var3);
               var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "document" + File.separator + "abs" + File.separator);
               var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "sous_rapport" + File.separator);
               var1.setEntete("Impression absence N° : " + this.salariesAbsences.getSalcngId() + " Agent " + this.salaries.getSalMatricule() + " " + this.salaries.getSalNom());
               var1.setFormat(var5);
               var1.setMatricule(this.salaries.getSalMatricule());
               var1.setEmetteur(var6);
               var1.setDestinataire(var7);
               var1.setDestinataireCC(var8);
               var1.setDestinataireCCI(var9);
               var1.setCorpsMail(var10);
               var1.setTiersSelectionne((Tiers)null);
               var11 = new ArrayList();
               var11.add(this.salariesConges);
               var12 = new JRBeanCollectionDataSource(var11);
               var1.setjRBeanCollectionDataSource(var12);
               var1.setBaseLog(this.baseLog);
               var1.setStructureLog(this.structureLog);
               var1.setUsersLog(this.usersLog);
               var1.imprimeRapport();
            } else if (var2 == 1) {
               var1.setRapport(var4);
               var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "liste" + File.separator + "abs" + File.separator);
               var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "sous_rapport" + File.separator);
               var13 = "";
               if (this.var_nat_rec == 10) {
                  var13 = "Demande absence";
               } else if (this.var_nat_rec == 11) {
                  var13 = "Absence payée";
               } else if (this.var_nat_rec == 12) {
                  var13 = "Absence non payée";
               } else if (this.var_nat_rec == 13) {
                  var13 = "Absence payée à déduire su CP";
               } else if (this.var_nat_rec == 14) {
                  var13 = "Retard non payé";
               } else if (this.var_nat_rec == 15) {
                  var13 = "Retard payé";
               } else if (this.var_nat_rec == 16) {
                  var13 = "Absence payée pour repos médical";
               } else if (this.var_nat_rec == 17) {
                  var13 = "Absence payée pour visite médicale";
               }

               var1.setEntete("Impression Liste : " + var13);
               var1.setFormat(var5);
               var1.setEmetteur(var6);
               var1.setDestinataire(var7);
               var1.setDestinataireCC(var8);
               var1.setDestinataireCCI(var9);
               var1.setCorpsMail(var10);
               var1.setTiersSelectionne((Tiers)null);
               var12 = new JRBeanCollectionDataSource(this.lesSalariesAbsences);
               var1.setjRBeanCollectionDataSource(var12);
               var1.setBaseLog(this.baseLog);
               var1.setStructureLog(this.structureLog);
               var1.setUsersLog(this.usersLog);
               var1.imprimeRapport();
            }
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

   public SalariesConges getSalariesConges() {
      return this.salariesConges;
   }

   public void setSalariesConges(SalariesConges var1) {
      this.salariesConges = var1;
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

   public int getVar_pret_rec() {
      return this.var_pret_rec;
   }

   public void setVar_pret_rec(int var1) {
      this.var_pret_rec = var1;
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

   public DataModel getDataModelConges() {
      return this.dataModelConges;
   }

   public void setDataModelConges(DataModel var1) {
      this.dataModelConges = var1;
   }

   public boolean isShowModalPanelDemandeAbsences() {
      return this.showModalPanelDemandeAbsences;
   }

   public void setShowModalPanelDemandeAbsences(boolean var1) {
      this.showModalPanelDemandeAbsences = var1;
   }

   public boolean isShowModalPanelDemandeConges() {
      return this.showModalPanelDemandeConges;
   }

   public void setShowModalPanelDemandeConges(boolean var1) {
      this.showModalPanelDemandeConges = var1;
   }

   public boolean isAjoutCp() {
      return this.ajoutCp;
   }

   public void setAjoutCp(boolean var1) {
      this.ajoutCp = var1;
   }

   public boolean isVar_affiche_conges() {
      return this.var_affiche_conges;
   }

   public void setVar_affiche_conges(boolean var1) {
      this.var_affiche_conges = var1;
   }

   public String getVar_lib_cp() {
      return this.var_lib_cp;
   }

   public void setVar_lib_cp(String var1) {
      this.var_lib_cp = var1;
   }

   public UsersChrono getUsersChronoAbsence() {
      return this.usersChronoAbsence;
   }

   public void setUsersChronoAbsence(UsersChrono var1) {
      this.usersChronoAbsence = var1;
   }

   public UsersChrono getUsersChronoConge() {
      return this.usersChronoConge;
   }

   public void setUsersChronoConge(UsersChrono var1) {
      this.usersChronoConge = var1;
   }

   public boolean isVar_acc_absences() {
      return this.var_acc_absences;
   }

   public void setVar_acc_absences(boolean var1) {
      this.var_acc_absences = var1;
   }

   public boolean isVar_acc_conges() {
      return this.var_acc_conges;
   }

   public void setVar_acc_conges(boolean var1) {
      this.var_acc_conges = var1;
   }

   public int getVar_action_absences() {
      return this.var_action_absences;
   }

   public void setVar_action_absences(int var1) {
      this.var_action_absences = var1;
   }

   public int getVar_action_conges() {
      return this.var_action_conges;
   }

   public void setVar_action_conges(int var1) {
      this.var_action_conges = var1;
   }

   public boolean isVar_affiche_absences() {
      return this.var_affiche_absences;
   }

   public void setVar_affiche_absences(boolean var1) {
      this.var_affiche_absences = var1;
   }

   public List getLesSalariesAbsences() {
      return this.lesSalariesAbsences;
   }

   public void setLesSalariesAbsences(List var1) {
      this.lesSalariesAbsences = var1;
   }

   public DataModel getDataModelAbsences() {
      return this.dataModelAbsences;
   }

   public void setDataModelAbsences(DataModel var1) {
      this.dataModelAbsences = var1;
   }

   public SalariesConges getSalariesAbsences() {
      return this.salariesAbsences;
   }

   public void setSalariesAbsences(SalariesConges var1) {
      this.salariesAbsences = var1;
   }

   public float getNbAcquis() {
      return this.nbAcquis;
   }

   public void setNbAcquis(float var1) {
      this.nbAcquis = var1;
   }

   public float getNbInit() {
      return this.nbInit;
   }

   public void setNbInit(float var1) {
      this.nbInit = var1;
   }

   public float getNbPris() {
      return this.nbPris;
   }

   public void setNbPris(float var1) {
      this.nbPris = var1;
   }

   public float getNbRestant() {
      return this.nbRestant;
   }

   public void setNbRestant(float var1) {
      this.nbRestant = var1;
   }

   public DataModel getDataModelLotConges() {
      return this.dataModelLotConges;
   }

   public void setDataModelLotConges(DataModel var1) {
      this.dataModelLotConges = var1;
   }

   public Date getDateDebut() {
      return this.dateDebut;
   }

   public void setDateDebut(Date var1) {
      this.dateDebut = var1;
   }

   public Date getDateFin() {
      return this.dateFin;
   }

   public void setDateFin(Date var1) {
      this.dateFin = var1;
   }

   public float getDureeCalculee() {
      return this.dureeCalculee;
   }

   public void setDureeCalculee(float var1) {
      this.dureeCalculee = var1;
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

   public boolean isCtrlNbJour() {
      return this.ctrlNbJour;
   }

   public void setCtrlNbJour(boolean var1) {
      this.ctrlNbJour = var1;
   }

   public UIDataTable getExtDTableAb() {
      return this.extDTableAb;
   }

   public void setExtDTableAb(UIDataTable var1) {
      this.extDTableAb = var1;
   }

   public UIDataTable getExtDTableCp() {
      return this.extDTableCp;
   }

   public void setExtDTableCp(UIDataTable var1) {
      this.extDTableCp = var1;
   }

   public SimpleSelection getSimpleSelectionEnteteAb() {
      return this.simpleSelectionEnteteAb;
   }

   public void setSimpleSelectionEnteteAb(SimpleSelection var1) {
      this.simpleSelectionEnteteAb = var1;
   }

   public SimpleSelection getSimpleSelectionEnteteCp() {
      return this.simpleSelectionEnteteCp;
   }

   public void setSimpleSelectionEnteteCp(SimpleSelection var1) {
      this.simpleSelectionEnteteCp = var1;
   }

   public int getVar_valide_rec() {
      return this.var_valide_rec;
   }

   public void setVar_valide_rec(int var1) {
      this.var_valide_rec = var1;
   }

   public String getMessageNbJourDispo() {
      return this.messageNbJourDispo;
   }

   public void setMessageNbJourDispo(String var1) {
      this.messageNbJourDispo = var1;
   }

   public List getMesCentresSecuritesItems() {
      return this.mesCentresSecuritesItems;
   }

   public void setMesCentresSecuritesItems(List var1) {
      this.mesCentresSecuritesItems = var1;
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

   public List getLesOrganesMedicauxItems() {
      return this.lesOrganesMedicauxItems;
   }

   public void setLesOrganesMedicauxItems(List var1) {
      this.lesOrganesMedicauxItems = var1;
   }
}
