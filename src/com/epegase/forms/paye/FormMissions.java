package com.epegase.forms.paye;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.Budget;
import com.epegase.systeme.classe.Ecritures;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.ExercicesPaye;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.Missions;
import com.epegase.systeme.classe.Salaries;
import com.epegase.systeme.classe.SalariesGrh;
import com.epegase.systeme.classe.SalariesMissions;
import com.epegase.systeme.classe.SalariesMissionsFrais;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.dao.BudgetDao;
import com.epegase.systeme.dao.EcrituresDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.HabilitationDao;
import com.epegase.systeme.dao.MissionsDao;
import com.epegase.systeme.dao.SalariesDao;
import com.epegase.systeme.dao.SalariesGrhDao;
import com.epegase.systeme.dao.SalariesMissionsDao;
import com.epegase.systeme.dao.SalariesMissionsFraisDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.ObjetLigneOnglet;
import com.epegase.systeme.xml.OptionPaye;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
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

public class FormMissions implements Serializable {
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
   private UsersChrono usersChrono;
   private int var_nb_max = 100;
   private List mesResponsablesItems;
   private long var_nom_responsable;
   private UserDao userDao;
   private boolean var_acc_identification = false;
   private boolean var_acc_complement = false;
   private boolean var_acc_familial = false;
   private boolean var_acc_contrat = false;
   private boolean var_ajt = false;
   private boolean var_mod = false;
   private boolean var_sup = false;
   private boolean var_imp = false;
   private boolean var_more_search = false;
   private List mesNatureAgentItems;
   private List mesServiceItems;
   private List mesPaysItems;
   private List lesPays;
   private List mesNationnalitesItems;
   private List mesLanguesItems;
   private List mesActiviteItems;
   private List mesBudgetItems;
   private List mesProjetItems;
   private String var_num_rec = "";
   private String var_service_rec = "100";
   private String var_activite_rec = "100";
   private String var_periode = "";
   private int var_etat_rec = 0;
   private int var_type_rec = 100;
   private Missions missions;
   private MissionsDao missionsDao;
   private List lesMissions = new ArrayList();
   private transient DataModel datamodelMissions = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private boolean var_affiche_bouton = false;
   private Salaries salaries;
   private SalariesMissions salariesMissions;
   private SalariesMissionsDao salariesMissionsDao;
   private List lesSalariesMissions = new ArrayList();
   private transient DataModel datamodelSalariesMissions = new ListDataModel();
   private boolean var_affiche_agents = false;
   private boolean showModalPanelSalariesMissions = false;
   private String nomSalarie;
   private boolean showModalPanelAgents = false;
   private List lesSalaries = new ArrayList();
   private transient DataModel dataModelLesSalaries = new ListDataModel();
   private SalariesDao salariesDao;
   private transient DataModel dataModelAccompagnant = new ListDataModel();
   private List lesAccompagnants = new ArrayList();
   private SalariesGrh salariesGrh;
   private SalariesGrhDao salariesGrhDao;
   private SalariesMissionsFrais salariesMissionsFrais;
   private SalariesMissionsFraisDao salariesMissionsFraisDao;
   private List lesSalariesMissionsFrais = new ArrayList();
   private transient DataModel datamodelSalariesMissionsFrais = new ListDataModel();
   private boolean var_affiche_frais = false;
   private boolean showModalPanelSalariesMissionsFrais = false;
   private List lesAgentsItems = new ArrayList();
   private List documentImpressionItems;
   private List listeImpressionItems;
   private boolean showModalPanelPrint = false;
   private FormRecherche formRecherche;
   private boolean showModalPanelInformation = false;
   private String nomCreation;
   private String nomModification;

   public FormMissions() throws IOException {
   }

   public void InstancesDaoUtilses() {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.missionsDao = new MissionsDao(this.baseLog, this.utilInitHibernate);
      this.salariesDao = new SalariesDao(this.baseLog, this.utilInitHibernate);
      this.salariesGrhDao = new SalariesGrhDao(this.baseLog, this.utilInitHibernate);
      this.salariesMissionsDao = new SalariesMissionsDao(this.baseLog, this.utilInitHibernate);
      this.salariesMissionsFraisDao = new SalariesMissionsFraisDao(this.baseLog, this.utilInitHibernate);
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.habilitationDao = new HabilitationDao(this.baseLog, this.utilInitHibernate);
      this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
   }

   public void initialisation(Session var1) throws HibernateException, NamingException {
      if (this.optionPaye.getNbLigneMax() != null && !this.optionPaye.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionPaye.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

   }

   public void accesResteintUser() {
   }

   public void accesResteintGroupe() throws HibernateException, NamingException {
      this.var_acc_identification = false;
      this.var_acc_complement = false;
      this.var_acc_familial = false;
      this.var_acc_contrat = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("1")) {
               this.var_acc_identification = true;
            } else if (var1.getCode().equals("2")) {
               this.var_acc_complement = true;
            } else if (var1.getCode().equals("3")) {
               this.var_acc_familial = true;
            } else if (var1.getCode().equals("4")) {
               this.var_acc_contrat = true;
            }
         }
      }

   }

   public void autorisationIdentification() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("1")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

   }

   public void autorisationOrdreMission() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("2")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

   }

   public void autorisationAgent() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("3")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

   }

   public void autorisationRetour() throws HibernateException, NamingException {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("4")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

      if (this.missions.getMisDateDebutReel() == null) {
         this.missions.setMisDateDebutReel(this.missions.getMisDateDebut());
      }

      if (this.missions.getMisDateFinReel() == null) {
         this.missions.setMisDateFinReel(this.missions.getMisDateFin());
      }

      if (this.missions.getMisNbJourReel() == 0) {
         this.missions.setMisNbJourReel(this.missions.getMisNbJourTheo());
      }

      if (this.missions.getMisPerdiemReel() == 0.0D) {
         this.missions.setMisPerdiemReel(this.missions.getMisPerdiemTheo());
      }

   }

   public String getUrlIp() {
      return StaticModePegase.getUrlIp();
   }

   public Habilitation verifHabilitation(int var1, Session var2) throws HibernateException, NamingException {
      new Habilitation();
      Habilitation var3 = this.habilitationDao.existenceHabilitation(var1, var2);
      return var3;
   }

   public void recupererLesResponsablesItem(Session var1) throws HibernateException, NamingException {
      this.mesResponsablesItems = new ArrayList();
      this.mesResponsablesItems.add(new SelectItem(this.usersLog.getUsrid(), this.usersLog.getUsrNom() + ":" + this.usersLog.getUsrPrenom()));
   }

   public void moreSearch() {
      if (!this.var_more_search) {
         this.var_more_search = true;
      } else {
         this.var_more_search = false;
      }

   }

   public void rechercherMissions() throws HibernateException, NamingException {
      this.rechercherMissions((Session)null);
   }

   public void rechercherMissions(Session var1) throws HibernateException, NamingException {
      this.lesMissions.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      this.lesMissions = this.missionsDao.rechercheMissions(this.var_etat_rec, this.var_num_rec, this.var_type_rec, this.var_service_rec, this.var_activite_rec, var1);
      this.datamodelMissions.setWrappedData(this.lesMissions);
   }

   public void selectionMissions() throws IOException, SQLException, HibernateException, NamingException {
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
            this.missions = (Missions)var1.get(0);
            Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviRH");
            this.chargerListeAgents(var4);
            this.chargerListeFrais(var4);
            this.lesAccompagnants.clear();
            this.dataModelAccompagnant.setWrappedData(this.lesAccompagnants);
            this.utilInitHibernate.closeSession();
            this.var_affiche_bouton = true;
         } else {
            this.var_affiche_bouton = false;
         }
      } else {
         this.var_affiche_bouton = false;
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.missions != null) {
         if (this.missions.getMisEtat() == 0) {
            this.modifierMissions();
         } else {
            this.consulterMissions();
         }
      }

   }

   public void chargerListeAgents(Session var1) throws HibernateException, NamingException {
      this.lesSalariesMissions.clear();
      this.lesSalariesMissions = this.salariesMissionsDao.chargeSalariesMissions((Missions)this.missions, (Session)null);
      this.datamodelSalariesMissions.setWrappedData(this.lesSalariesMissions);
   }

   public void chargerListeFrais(Session var1) throws HibernateException, NamingException {
      this.lesSalariesMissionsFrais.clear();
      this.lesSalariesMissionsFrais = this.salariesMissionsFraisDao.chargeSalariesMissionsFrais(this.missions, (Session)null);
      this.datamodelSalariesMissionsFrais.setWrappedData(this.lesSalariesMissionsFrais);
   }

   public void ajouterMissions() {
      this.missions = new Missions();
      this.salaries = new Salaries();
      this.salariesMissions = new SalariesMissions();
      this.salariesMissionsFrais = new SalariesMissionsFrais();
      this.missions.setMisPays(this.structureLog.getStrnompays());
      this.var_action = 1;
   }

   public void modifierMissions() {
      if (this.missions != null) {
         this.var_action = 2;
      }

   }

   public void consulterMissions() {
      if (this.missions != null) {
         this.var_action = 3;
      }

   }

   public void supprimerMissions() throws HibernateException, NamingException {
      if (this.missions != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.lesMissions.remove(this.missions);
            this.datamodelMissions.setWrappedData(this.lesMissions);
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

      this.var_action = 0;
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
   }

   public void annulerMissions() {
      this.var_affiche_bouton = false;
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public void saveMissions() throws HibernateException, NamingException {
      this.missions.setMisIdResponsable(0L);
      this.missions.setMisNomResponsable("");
      if (this.var_nom_responsable != 0L) {
         new Users();
         if (this.var_nom_responsable == 0L && this.mesResponsablesItems.size() == 1) {
            this.var_nom_responsable = Long.parseLong(((SelectItem)this.mesResponsablesItems.get(0)).getValue().toString());
         }

         Users var1 = this.userDao.selectUserD(this.var_nom_responsable, (Session)null);
         if (var1 != null) {
            this.missions.setMisIdResponsable(var1.getUsrid());
            this.missions.setMisNomResponsable(var1.getUsrPatronyme());
         }
      }

      if (this.missions.getMisId() == 0L) {
         String var2 = this.calculChrono.numCompose(new Date(), this.nature, "", (Session)null);
         this.missions.setExercicesPaye(this.exercicesPaye);
         this.missions.setMisDateCreat(new Date());
         this.missions.setMisUserCreat(this.usersLog.getUsrid());
         this.missions.setMisNum(var2);
         this.missions = this.missionsDao.insert(this.missions);
         this.lesMissions.add(this.missions);
         this.datamodelMissions.setWrappedData(this.lesMissions);
         this.var_action = 2;
         this.simpleSelectionEntete.clear();
         this.extDTable = new HtmlExtendedDataTable();
      } else {
         this.missions.setMisDateModif(new Date());
         this.missions.setMisUserModif(this.usersLog.getUsrid());
         this.missions = this.missionsDao.modif(this.missions);
         this.var_action = 0;
      }

   }

   public void calculePays() {
      if (this.missions.getMisMode() == 0) {
         this.missions.setMisPays(this.structureLog.getStrnompays());
      }

   }

   public void calculeNbJoursTheo() {
      if (this.missions.getMisDateDebut() != null && this.missions.getMisDateFin() != null) {
         long var1 = (this.missions.getMisDateFin().getTime() - this.missions.getMisDateDebut().getTime()) / 86400000L;
         this.missions.setMisNbJourTheo((int)var1);
      } else {
         this.missions.setMisNbJourTheo(0);
      }

      this.calculePerdiemTheo();
   }

   public void calculePerdiemTheo() {
      this.missions.setMisPerdiemTheo(this.missions.getMisPuPerdiem() * (double)this.missions.getMisNbJourTheo());
   }

   public void calculeNbJoursReel() {
      if (this.missions.getMisDateDebut() != null && this.missions.getMisDateFin() != null) {
         long var1 = (this.missions.getMisDateFinReel().getTime() - this.missions.getMisDateDebutReel().getTime()) / 86400000L;
         this.missions.setMisNbJourReel((int)var1);
      } else {
         this.missions.setMisNbJourReel(0);
      }

      this.calculePerdiemReel();
   }

   public void calculePerdiemReel() {
      this.missions.setMisPerdiemTheo(this.missions.getMisPuPerdiem() * (double)this.missions.getMisNbJourReel());
   }

   public void calculeDsipoBudget() throws HibernateException, NamingException {
      this.missions.setMisBudgetDispo(0.0D);
      this.missions.setMisBudgetDispoMois(0.0D);
      this.missions.setMisBudgetTreso(0.0D);
      this.missions.setMisBudgetTresoMois(0.0D);
      if (this.missions.getMisBudget() != null && this.missions.getMisBudget().contains(":")) {
         String[] var1 = this.missions.getMisBudget().split(":");
         String var2 = null;
         if (this.missions.getMisActivite() != null && !this.missions.getMisActivite().isEmpty()) {
            String[] var3 = this.missions.getMisActivite().split(":");
            var2 = var3[0];
         }

         new ExercicesComptable();
         ExercicesComptableDao var4 = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
         ExercicesComptable var30 = var4.recupererLastExo((Session)null);
         if (var30 != null) {
            String var5 = "" + var30.getExecpt_id();
            int var6 = this.missions.getMisDateDebut().getMonth() + 1;
            double var7 = 0.0D;
            double var9 = 0.0D;
            BudgetDao var11 = new BudgetDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            List var12 = var11.chargerLesBudgets("2", var5, var2, var1[0], (Session)null);
            if (var12.size() != 0) {
               for(int var13 = 0; var13 < var12.size(); ++var13) {
                  new Budget();
                  Budget var14 = (Budget)var12.get(var13);
                  if (var14.getBudUtil() <= 1) {
                     if (var6 == 1) {
                        var9 += var14.getBud01R1Val();
                        var7 += var14.getBud01R1Val();
                     } else if (var6 == 2) {
                        var9 += var14.getBud02R1Val();
                        var7 = var7 + var14.getBud01R1Val() + var14.getBud02R1Val();
                     } else if (var6 == 3) {
                        var9 += var14.getBud03R1Val();
                        var7 = var7 + var14.getBud01R1Val() + var14.getBud02R1Val() + var14.getBud03R1Val();
                     } else if (var6 == 4) {
                        var9 += var14.getBud04R1Val();
                        var7 = var7 + var14.getBud01R1Val() + var14.getBud02R1Val() + var14.getBud03R1Val() + var14.getBud04R1Val();
                     } else if (var6 == 5) {
                        var9 += var14.getBud05R1Val();
                        var7 = var7 + var14.getBud01R1Val() + var14.getBud02R1Val() + var14.getBud03R1Val() + var14.getBud04R1Val() + var14.getBud05R1Val();
                     } else if (var6 == 6) {
                        var9 += var14.getBud06R1Val();
                        var7 = var7 + var14.getBud01R1Val() + var14.getBud02R1Val() + var14.getBud03R1Val() + var14.getBud04R1Val() + var14.getBud05R1Val() + var14.getBud06R1Val();
                     } else if (var6 == 7) {
                        var9 += var14.getBud07R1Val();
                        var7 = var7 + var14.getBud01R1Val() + var14.getBud02R1Val() + var14.getBud03R1Val() + var14.getBud04R1Val() + var14.getBud05R1Val() + var14.getBud06R1Val() + var14.getBud07R1Val();
                     } else if (var6 == 8) {
                        var9 += var14.getBud08R1Val();
                        var7 = var7 + var14.getBud01R1Val() + var14.getBud02R1Val() + var14.getBud03R1Val() + var14.getBud04R1Val() + var14.getBud05R1Val() + var14.getBud06R1Val() + var14.getBud07R1Val() + var14.getBud08R1Val();
                     } else if (var6 == 9) {
                        var9 += var14.getBud09R1Val();
                        var7 = var7 + var14.getBud01R1Val() + var14.getBud02R1Val() + var14.getBud03R1Val() + var14.getBud04R1Val() + var14.getBud05R1Val() + var14.getBud06R1Val() + var14.getBud07R1Val() + var14.getBud08R1Val() + var14.getBud09R1Val();
                     } else if (var6 == 10) {
                        var9 += var14.getBud10R1Val();
                        var7 = var7 + var14.getBud01R1Val() + var14.getBud02R1Val() + var14.getBud03R1Val() + var14.getBud04R1Val() + var14.getBud05R1Val() + var14.getBud06R1Val() + var14.getBud07R1Val() + var14.getBud08R1Val() + var14.getBud09R1Val() + var14.getBud10R1Val();
                     } else if (var6 == 11) {
                        var9 += var14.getBud11R1Val();
                        var7 = var7 + var14.getBud01R1Val() + var14.getBud02R1Val() + var14.getBud03R1Val() + var14.getBud04R1Val() + var14.getBud05R1Val() + var14.getBud06R1Val() + var14.getBud07R1Val() + var14.getBud08R1Val() + var14.getBud09R1Val() + var14.getBud10R1Val() + var14.getBud11R1Val();
                     } else if (var6 == 12) {
                        var9 += var14.getBud12R1Val();
                        var7 = var7 + var14.getBud01R1Val() + var14.getBud02R1Val() + var14.getBud03R1Val() + var14.getBud04R1Val() + var14.getBud05R1Val() + var14.getBud06R1Val() + var14.getBud07R1Val() + var14.getBud08R1Val() + var14.getBud09R1Val() + var14.getBud10R1Val() + var14.getBud11R1Val() + var14.getBud12R1Val();
                     }
                  } else if (var14.getBudUtil() == 2) {
                     if (var6 == 1) {
                        var9 += var14.getBud01R2Val();
                        var7 += var14.getBud01R2Val();
                     } else if (var6 == 2) {
                        var9 += var14.getBud02R2Val();
                        var7 = var7 + var14.getBud01R2Val() + var14.getBud02R2Val();
                     } else if (var6 == 3) {
                        var9 += var14.getBud03R2Val();
                        var7 = var7 + var14.getBud01R2Val() + var14.getBud02R2Val() + var14.getBud03R2Val();
                     } else if (var6 == 4) {
                        var9 += var14.getBud04R2Val();
                        var7 = var7 + var14.getBud01R2Val() + var14.getBud02R2Val() + var14.getBud03R2Val() + var14.getBud04R2Val();
                     } else if (var6 == 5) {
                        var9 += var14.getBud05R2Val();
                        var7 = var7 + var14.getBud01R2Val() + var14.getBud02R2Val() + var14.getBud03R2Val() + var14.getBud04R2Val() + var14.getBud05R2Val();
                     } else if (var6 == 6) {
                        var9 += var14.getBud06R2Val();
                        var7 = var7 + var14.getBud01R2Val() + var14.getBud02R2Val() + var14.getBud03R2Val() + var14.getBud04R2Val() + var14.getBud05R2Val() + var14.getBud06R2Val();
                     } else if (var6 == 7) {
                        var9 += var14.getBud07R2Val();
                        var7 = var7 + var14.getBud01R2Val() + var14.getBud02R2Val() + var14.getBud03R2Val() + var14.getBud04R2Val() + var14.getBud05R2Val() + var14.getBud06R2Val() + var14.getBud07R2Val();
                     } else if (var6 == 8) {
                        var9 += var14.getBud08R2Val();
                        var7 = var7 + var14.getBud01R2Val() + var14.getBud02R2Val() + var14.getBud03R2Val() + var14.getBud04R2Val() + var14.getBud05R2Val() + var14.getBud06R2Val() + var14.getBud07R2Val() + var14.getBud08R2Val();
                     } else if (var6 == 9) {
                        var9 += var14.getBud09R2Val();
                        var7 = var7 + var14.getBud01R2Val() + var14.getBud02R2Val() + var14.getBud03R2Val() + var14.getBud04R2Val() + var14.getBud05R2Val() + var14.getBud06R2Val() + var14.getBud07R2Val() + var14.getBud08R2Val() + var14.getBud09R2Val();
                     } else if (var6 == 10) {
                        var9 += var14.getBud10R2Val();
                        var7 = var7 + var14.getBud01R2Val() + var14.getBud02R2Val() + var14.getBud03R2Val() + var14.getBud04R2Val() + var14.getBud05R2Val() + var14.getBud06R2Val() + var14.getBud07R2Val() + var14.getBud08R2Val() + var14.getBud09R2Val() + var14.getBud10R2Val();
                     } else if (var6 == 11) {
                        var9 += var14.getBud11R2Val();
                        var7 = var7 + var14.getBud01R2Val() + var14.getBud02R2Val() + var14.getBud03R2Val() + var14.getBud04R2Val() + var14.getBud05R2Val() + var14.getBud06R2Val() + var14.getBud07R2Val() + var14.getBud08R2Val() + var14.getBud09R2Val() + var14.getBud10R2Val() + var14.getBud11R2Val();
                     } else if (var6 == 12) {
                        var9 += var14.getBud12R2Val();
                        var7 = var7 + var14.getBud01R2Val() + var14.getBud02R2Val() + var14.getBud03R2Val() + var14.getBud04R2Val() + var14.getBud05R2Val() + var14.getBud06R2Val() + var14.getBud07R2Val() + var14.getBud08R2Val() + var14.getBud09R2Val() + var14.getBud10R2Val() + var14.getBud11R2Val() + var14.getBud12R2Val();
                     }
                  } else if (var14.getBudUtil() == 2) {
                     if (var6 == 1) {
                        var9 += var14.getBud01R3Val();
                        var7 += var14.getBud01R3Val();
                     } else if (var6 == 2) {
                        var9 += var14.getBud02R3Val();
                        var7 = var7 + var14.getBud01R3Val() + var14.getBud02R3Val();
                     } else if (var6 == 3) {
                        var9 += var14.getBud03R3Val();
                        var7 = var7 + var14.getBud01R3Val() + var14.getBud02R3Val() + var14.getBud03R3Val();
                     } else if (var6 == 4) {
                        var9 += var14.getBud04R3Val();
                        var7 = var7 + var14.getBud01R3Val() + var14.getBud02R3Val() + var14.getBud03R3Val() + var14.getBud04R3Val();
                     } else if (var6 == 5) {
                        var9 += var14.getBud05R3Val();
                        var7 = var7 + var14.getBud01R3Val() + var14.getBud02R3Val() + var14.getBud03R3Val() + var14.getBud04R3Val() + var14.getBud05R3Val();
                     } else if (var6 == 6) {
                        var9 += var14.getBud06R3Val();
                        var7 = var7 + var14.getBud01R3Val() + var14.getBud02R3Val() + var14.getBud03R3Val() + var14.getBud04R3Val() + var14.getBud05R3Val() + var14.getBud06R3Val();
                     } else if (var6 == 7) {
                        var9 += var14.getBud07R3Val();
                        var7 = var7 + var14.getBud01R3Val() + var14.getBud02R3Val() + var14.getBud03R3Val() + var14.getBud04R3Val() + var14.getBud05R3Val() + var14.getBud06R3Val() + var14.getBud07R3Val();
                     } else if (var6 == 8) {
                        var9 += var14.getBud08R3Val();
                        var7 = var7 + var14.getBud01R3Val() + var14.getBud02R3Val() + var14.getBud03R3Val() + var14.getBud04R3Val() + var14.getBud05R3Val() + var14.getBud06R3Val() + var14.getBud07R3Val() + var14.getBud08R3Val();
                     } else if (var6 == 9) {
                        var9 += var14.getBud09R3Val();
                        var7 = var7 + var14.getBud01R3Val() + var14.getBud02R3Val() + var14.getBud03R3Val() + var14.getBud04R3Val() + var14.getBud05R3Val() + var14.getBud06R3Val() + var14.getBud07R3Val() + var14.getBud08R3Val() + var14.getBud09R3Val();
                     } else if (var6 == 10) {
                        var9 += var14.getBud10R3Val();
                        var7 = var7 + var14.getBud01R3Val() + var14.getBud02R3Val() + var14.getBud03R3Val() + var14.getBud04R3Val() + var14.getBud05R3Val() + var14.getBud06R3Val() + var14.getBud07R3Val() + var14.getBud08R3Val() + var14.getBud09R3Val() + var14.getBud10R3Val();
                     } else if (var6 == 11) {
                        var9 += var14.getBud11R3Val();
                        var7 = var7 + var14.getBud01R3Val() + var14.getBud02R3Val() + var14.getBud03R3Val() + var14.getBud04R3Val() + var14.getBud05R3Val() + var14.getBud06R3Val() + var14.getBud07R3Val() + var14.getBud08R3Val() + var14.getBud09R3Val() + var14.getBud10R3Val() + var14.getBud11R3Val();
                     } else if (var6 == 12) {
                        var9 += var14.getBud12R3Val();
                        var7 = var7 + var14.getBud01R3Val() + var14.getBud02R3Val() + var14.getBud03R3Val() + var14.getBud04R3Val() + var14.getBud05R3Val() + var14.getBud06R3Val() + var14.getBud07R3Val() + var14.getBud08R3Val() + var14.getBud09R3Val() + var14.getBud10R3Val() + var14.getBud11R3Val() + var14.getBud12R3Val();
                     }
                  } else if (var14.getBudUtil() == 2) {
                     if (var6 == 1) {
                        var9 += var14.getBud01R4Val();
                        var7 += var14.getBud01R4Val();
                     } else if (var6 == 2) {
                        var9 += var14.getBud02R4Val();
                        var7 = var7 + var14.getBud01R4Val() + var14.getBud02R4Val();
                     } else if (var6 == 3) {
                        var9 += var14.getBud03R4Val();
                        var7 = var7 + var14.getBud01R4Val() + var14.getBud02R4Val() + var14.getBud03R4Val();
                     } else if (var6 == 4) {
                        var9 += var14.getBud04R4Val();
                        var7 = var7 + var14.getBud01R4Val() + var14.getBud02R4Val() + var14.getBud03R4Val() + var14.getBud04R4Val();
                     } else if (var6 == 5) {
                        var9 += var14.getBud05R4Val();
                        var7 = var7 + var14.getBud01R4Val() + var14.getBud02R4Val() + var14.getBud03R4Val() + var14.getBud04R4Val() + var14.getBud05R4Val();
                     } else if (var6 == 6) {
                        var9 += var14.getBud06R4Val();
                        var7 = var7 + var14.getBud01R4Val() + var14.getBud02R4Val() + var14.getBud03R4Val() + var14.getBud04R4Val() + var14.getBud05R4Val() + var14.getBud06R4Val();
                     } else if (var6 == 7) {
                        var9 += var14.getBud07R4Val();
                        var7 = var7 + var14.getBud01R4Val() + var14.getBud02R4Val() + var14.getBud03R4Val() + var14.getBud04R4Val() + var14.getBud05R4Val() + var14.getBud06R4Val() + var14.getBud07R4Val();
                     } else if (var6 == 8) {
                        var9 += var14.getBud08R4Val();
                        var7 = var7 + var14.getBud01R4Val() + var14.getBud02R4Val() + var14.getBud03R4Val() + var14.getBud04R4Val() + var14.getBud05R4Val() + var14.getBud06R4Val() + var14.getBud07R4Val() + var14.getBud08R4Val();
                     } else if (var6 == 9) {
                        var9 += var14.getBud09R4Val();
                        var7 = var7 + var14.getBud01R4Val() + var14.getBud02R4Val() + var14.getBud03R4Val() + var14.getBud04R4Val() + var14.getBud05R4Val() + var14.getBud06R4Val() + var14.getBud07R4Val() + var14.getBud08R4Val() + var14.getBud09R4Val();
                     } else if (var6 == 10) {
                        var9 += var14.getBud10R4Val();
                        var7 = var7 + var14.getBud01R4Val() + var14.getBud02R4Val() + var14.getBud03R4Val() + var14.getBud04R4Val() + var14.getBud05R4Val() + var14.getBud06R4Val() + var14.getBud07R4Val() + var14.getBud08R4Val() + var14.getBud09R4Val() + var14.getBud10R4Val();
                     } else if (var6 == 11) {
                        var9 += var14.getBud11R4Val();
                        var7 = var7 + var14.getBud01R4Val() + var14.getBud02R4Val() + var14.getBud03R4Val() + var14.getBud04R4Val() + var14.getBud05R4Val() + var14.getBud06R4Val() + var14.getBud07R4Val() + var14.getBud08R4Val() + var14.getBud09R4Val() + var14.getBud10R4Val() + var14.getBud11R4Val();
                     } else if (var6 == 12) {
                        var9 += var14.getBud12R4Val();
                        var7 = var7 + var14.getBud01R4Val() + var14.getBud02R4Val() + var14.getBud03R4Val() + var14.getBud04R4Val() + var14.getBud05R4Val() + var14.getBud06R4Val() + var14.getBud07R4Val() + var14.getBud08R4Val() + var14.getBud09R4Val() + var14.getBud10R4Val() + var14.getBud11R4Val() + var14.getBud12R4Val();
                     }
                  }
               }
            }

            double var31 = 0.0D;
            double var15 = 0.0D;
            new ArrayList();
            List var17 = this.missionsDao.rechercheMissions(this.missions.getMisBudget(), this.missions.getMisActivite(), (Session)null);
            if (var17.size() != 0) {
               new Missions();

               for(int var19 = 0; var19 < var17.size(); ++var19) {
                  Missions var18 = (Missions)var17.get(var19);
                  if (var18.getMisDateDebut().getMonth() + 1 == var6) {
                     var15 += var18.getMisTotalCout();
                  }

                  var31 += var18.getMisTotalCout();
               }
            }

            double var32 = 0.0D;
            double var20 = 0.0D;
            double var22 = 0.0D;
            double var24 = 0.0D;
            EcrituresDao var26 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            List var27 = var26.selectLesDisponibilites(var30.getExecpt_id(), this.missions.getMisDateDebut(), (Session)null);
            if (var27.size() != 0) {
               new Ecritures();

               for(int var29 = 0; var29 < var27.size(); ++var29) {
                  Ecritures var28 = (Ecritures)var27.get(var29);
                  if (var28.getEcrDateSaisie().getMonth() + 1 == var6) {
                     var20 += var28.getEcrDebitPays();
                     var24 += var28.getEcrCreditPays();
                  }

                  var32 += var28.getEcrDebitPays();
                  var22 += var28.getEcrCreditPays();
               }
            }

            this.missions.setMisBudgetDispo(var7 - var31);
            this.missions.setMisBudgetDispoMois(var9 - var15);
            this.missions.setMisBudgetTreso(var32 - var22);
            this.missions.setMisBudgetTresoMois(var20 - var24);
         }
      }

   }

   public void informationPiece() throws HibernateException, NamingException {
      if (this.missions != null) {
         this.nomCreation = "";
         this.nomModification = "";
         new Users();
         UserDao var2 = new UserDao(this.baseLog, this.utilInitHibernate);
         Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         Users var1;
         if (this.missions.getMisUserCreat() != 0L) {
            var1 = var2.selectUserD(this.missions.getMisUserCreat(), var3);
            if (var1 != null) {
               this.nomCreation = var1.getUsrPatronyme();
            }
         }

         if (this.missions.getMisUserModif() != 0L) {
            var1 = var2.selectUserD(this.missions.getMisUserModif(), var3);
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

   public void selectionAgent() throws HibernateException, NamingException {
      if (this.datamodelSalariesMissions.isRowAvailable()) {
         this.salariesMissions = (SalariesMissions)this.datamodelSalariesMissions.getRowData();
         this.salaries = this.salariesMissions.getSalaries();
         if (this.salaries != null) {
            this.lesAccompagnants.clear();
            this.lesAccompagnants = this.salariesGrhDao.chargerlesElementRhFamille(this.salaries, (Session)null);
            if (this.salariesMissions.getSalmisAccompagnant() != null && !this.salariesMissions.getSalmisAccompagnant().isEmpty()) {
               long var1 = 0L;
               if (!this.salariesMissions.getSalmisAccompagnant().contains(":")) {
                  var1 = Long.parseLong(this.salariesMissions.getSalmisAccompagnant());

                  for(int var3 = 0; var3 < this.lesAccompagnants.size(); ++var3) {
                     this.salariesGrh = (SalariesGrh)this.lesAccompagnants.get(var3);
                     if (this.salariesGrh.getSalgrhId() == var1) {
                        this.salariesGrh.setRhSelect(true);
                        break;
                     }
                  }
               } else {
                  String[] var6 = this.salariesMissions.getSalmisAccompagnant().split(":");

                  for(int var4 = 0; var4 < var6.length; ++var4) {
                     var1 = Long.parseLong(var6[var4]);

                     for(int var5 = 0; var5 < this.lesAccompagnants.size(); ++var5) {
                        this.salariesGrh = (SalariesGrh)this.lesAccompagnants.get(var5);
                        if (this.salariesGrh.getSalgrhId() == var1) {
                           this.salariesGrh.setRhSelect(true);
                           break;
                        }
                     }
                  }
               }
            }

            this.dataModelAccompagnant.setWrappedData(this.lesAccompagnants);
         }

         this.var_affiche_agents = true;
      }

   }

   public void ajouterSalaries() throws HibernateException, NamingException {
      this.salariesMissions = new SalariesMissions();
      this.salariesMissions.setSalmisPerdiemTheo(this.missions.getMisPerdiemTheo());
      this.salaries = new Salaries();
      this.nomSalarie = "";
      this.lesAccompagnants.clear();
      this.lesAccompagnants = this.salariesGrhDao.chargerlesElementRhFamille(this.salaries, (Session)null);
      this.dataModelAccompagnant.setWrappedData(this.lesAccompagnants);
      this.showModalPanelSalariesMissions = true;
   }

   public void modifierSalaries() {
      if (this.salariesMissions != null) {
         this.salaries = this.salariesMissions.getSalaries();
         this.showModalPanelSalariesMissions = true;
      }

   }

   public void supprimerSalaries() {
      if (this.salariesMissions != null) {
         this.var_affiche_agents = false;
      }

   }

   public void fermerSalaries() {
      this.var_affiche_agents = false;
      this.showModalPanelSalariesMissions = false;
   }

   public void saveSalaries() throws HibernateException, NamingException {
      String var1 = "";
      if (this.missions.getMisMode() == 1 && this.lesAccompagnants.size() != 0) {
         this.salariesGrh = new SalariesGrh();
         boolean var2 = true;

         for(int var3 = 0; var3 < this.lesAccompagnants.size(); ++var3) {
            this.salariesGrh = (SalariesGrh)this.lesAccompagnants.get(var3);
            if (this.salariesGrh.isRhSelect()) {
               if (var2) {
                  var1 = "" + this.salariesGrh.getSalgrhId();
                  var2 = false;
               } else {
                  var1 = var1 + ":" + this.salariesGrh.getSalgrhId();
               }
            }
         }
      }

      this.salariesMissions.setSalmisAccompagnant(var1);
      if (this.salariesMissions.getSalmisId() == 0L) {
         this.salariesMissions.setSalaries(this.salaries);
         this.salariesMissions.setMissions(this.missions);
         this.salariesMissions = this.salariesMissionsDao.insert(this.salariesMissions);
         this.lesSalariesMissions.add(this.salariesMissions);
         this.datamodelSalariesMissions.setWrappedData(this.lesSalariesMissions);
      } else {
         this.salariesMissions = this.salariesMissionsDao.modif(this.salariesMissions);
      }

      this.var_affiche_agents = false;
      this.showModalPanelSalariesMissions = false;
   }

   public void selectionFrais() {
      if (this.datamodelSalariesMissionsFrais.isRowAvailable()) {
         this.salariesMissionsFrais = (SalariesMissionsFrais)this.datamodelSalariesMissionsFrais.getRowData();
         this.salaries = this.salariesMissionsFrais.getSalaries();
         this.var_affiche_frais = true;
      }

   }

   public void ajouterFrais() {
      this.salariesMissionsFrais = new SalariesMissionsFrais();
      this.salariesMissionsFrais.setSalmisfraMode(1);
      this.salariesMissionsFrais.setSalmisfraDate(this.missions.getMisDateFinReel());
      this.salaries = new Salaries();
      this.nomSalarie = "";
      this.lesAgentsItems.clear();
      if (this.lesSalariesMissions.size() != 0) {
         for(int var1 = 0; var1 < this.lesSalariesMissions.size(); ++var1) {
            this.salariesMissions = (SalariesMissions)this.lesSalariesMissions.get(var1);
            if (this.salariesMissions.getSalaries().getSalPrenom() != null && !this.salariesMissions.getSalaries().getSalPrenom().isEmpty()) {
               this.lesAgentsItems.add(new SelectItem(this.salariesMissions.getSalaries().getSalId(), this.salariesMissions.getSalaries().getSalNom() + " " + this.salariesMissions.getSalaries().getSalPrenom()));
            } else {
               this.lesAgentsItems.add(new SelectItem(this.salariesMissions.getSalaries().getSalId(), this.salariesMissions.getSalaries().getSalNom()));
            }
         }
      }

      this.showModalPanelSalariesMissionsFrais = true;
   }

   public void modifierFrais() {
      if (this.salariesMissionsFrais != null) {
         this.salaries = this.salariesMissionsFrais.getSalaries();
         this.showModalPanelSalariesMissionsFrais = true;
      }

   }

   public void supprimerFrais() {
      if (this.salariesMissionsFrais != null) {
         this.var_affiche_frais = false;
      }

   }

   public void fermerFrais() {
      this.var_affiche_frais = false;
      this.showModalPanelSalariesMissionsFrais = false;
   }

   public void saveFrais() throws HibernateException, NamingException {
      long var1 = 0L;
      if (this.nomSalarie != null && !this.nomSalarie.isEmpty()) {
         var1 = Long.parseLong(this.nomSalarie);
         this.salaries = this.salariesDao.chercherIdSalaries(var1, (Session)null);
      }

      if (var1 != 0L) {
         if (this.salariesMissionsFrais.getSalmisfraId() == 0L) {
            this.salariesMissionsFrais.setSalaries(this.salaries);
            this.salariesMissionsFrais.setMissions(this.missions);
            this.salariesMissionsFrais = this.salariesMissionsFraisDao.insert(this.salariesMissionsFrais);
            this.lesSalariesMissionsFrais.add(this.salariesMissionsFrais);
            this.datamodelSalariesMissionsFrais.setWrappedData(this.lesSalariesMissionsFrais);
         } else {
            this.salariesMissionsFrais = this.salariesMissionsFraisDao.modif(this.salariesMissionsFrais);
         }

         if (this.lesSalariesMissionsFrais.size() != 0 && this.lesSalariesMissions.size() != 0) {
            new SalariesMissions();
            new Salaries();

            for(int var5 = 0; var5 < this.lesSalariesMissions.size(); ++var5) {
               SalariesMissions var3 = (SalariesMissions)this.lesSalariesMissions.get(var5);
               Salaries var4 = var3.getSalaries();
               double var6 = 0.0D;
               double var8 = 0.0D;
               double var10 = 0.0D;
               double var12 = 0.0D;

               for(int var14 = 0; var14 < this.lesSalariesMissionsFrais.size(); ++var14) {
                  if (((SalariesMissionsFrais)this.lesSalariesMissionsFrais.get(var14)).getSalaries().getSalId() == var4.getSalId()) {
                     if (((SalariesMissionsFrais)this.lesSalariesMissionsFrais.get(var14)).getSalmisfraType() == 0) {
                        var6 += ((SalariesMissionsFrais)this.lesSalariesMissionsFrais.get(var14)).getSalmisfraCout();
                     } else if (((SalariesMissionsFrais)this.lesSalariesMissionsFrais.get(var14)).getSalmisfraType() == 1) {
                        var8 += ((SalariesMissionsFrais)this.lesSalariesMissionsFrais.get(var14)).getSalmisfraCout();
                     } else if (((SalariesMissionsFrais)this.lesSalariesMissionsFrais.get(var14)).getSalmisfraType() == 2) {
                        var10 += ((SalariesMissionsFrais)this.lesSalariesMissionsFrais.get(var14)).getSalmisfraCout();
                     } else if (((SalariesMissionsFrais)this.lesSalariesMissionsFrais.get(var14)).getSalmisfraType() == 3) {
                        var12 += ((SalariesMissionsFrais)this.lesSalariesMissionsFrais.get(var14)).getSalmisfraCout();
                     }
                  }
               }

               var3.setSalmisTitreTransport(var6);
               var3.setSalmisHebergement(var8);
               var3.setSalmisRestauration(var10);
               var3.setSalmisAutresFrais(var12);
               this.salariesMissionsDao.modif(var3);
            }
         }

         if (this.missions != null) {
            double var17 = 0.0D;
            double var18 = 0.0D;
            double var7 = 0.0D;
            double var9 = 0.0D;
            double var11 = 0.0D;
            double var13 = 0.0D;
            if (this.lesSalariesMissions.size() != 0) {
               new SalariesMissions();

               for(int var16 = 0; var16 < this.lesSalariesMissions.size(); ++var16) {
                  SalariesMissions var15 = (SalariesMissions)this.lesSalariesMissions.get(var16);
                  var17 += ((SalariesMissions)this.lesSalariesMissions.get(var16)).getSalmisPerdiemReel();
                  var18 += ((SalariesMissions)this.lesSalariesMissions.get(var16)).getSalmisVisa();
                  var7 = var7 + ((SalariesMissions)this.lesSalariesMissions.get(var16)).getSalmisTitreTransport() + ((SalariesMissions)this.lesSalariesMissions.get(var16)).getSalmisDeplacement1() + ((SalariesMissions)this.lesSalariesMissions.get(var16)).getSalmisDeplacement2();
                  var9 += ((SalariesMissions)this.lesSalariesMissions.get(var16)).getSalmisHebergement();
                  var11 += ((SalariesMissions)this.lesSalariesMissions.get(var16)).getSalmisRestauration();
                  var13 += ((SalariesMissions)this.lesSalariesMissions.get(var16)).getSalmisAutresFrais();
               }
            }

            this.missions.setMisTotalPerdiem(var17);
            this.missions.setMisTotalVisa(var18);
            this.missions.setMisTotalTransport(var7);
            this.missions.setMisTotalHebergement(var9);
            this.missions.setMisTotalRestauration(var11);
            this.missions.setMisTotalDivers(var13);
            this.missions.setMisTotalCout(var17 + var18 + var7 + var9 + var11 + var13);
            this.missions = this.missionsDao.modif(this.missions);
         }
      }

      this.var_affiche_frais = false;
      this.showModalPanelSalariesMissionsFrais = false;
   }

   public void rechercheSalarie() throws JDOMException, IOException, HibernateException, NamingException {
      this.lesSalaries = this.salariesDao.chargerlesSalariesActif(this.nomSalarie, (Session)null);
      if (this.lesSalaries.size() != 0) {
         if (this.lesSalaries.size() == 1) {
            this.salaries = (Salaries)this.lesSalaries.get(0);
            this.calculeSalarie();
         } else {
            this.dataModelLesSalaries.setWrappedData(this.lesSalaries);
            this.showModalPanelAgents = true;
         }
      } else {
         this.annuleSalarie();
      }

   }

   public void recuperationSalarie() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.dataModelLesSalaries.isRowAvailable()) {
         this.salaries = (Salaries)this.dataModelLesSalaries.getRowData();
      }

   }

   public void calculeSalarie() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.salaries != null) {
         boolean var1 = false;
         if (this.lesSalariesMissions.size() != 0) {
            new Salaries();

            for(int var3 = 0; var3 < this.lesSalariesMissions.size(); ++var3) {
               Salaries var2 = ((SalariesMissions)this.lesSalariesMissions.get(var3)).getSalaries();
               if (var2.getSalId() == this.salaries.getSalId()) {
                  var1 = true;
               }
            }
         }

         if (!var1) {
            this.nomSalarie = this.salaries.getSalMatricule();
         } else {
            this.annuleSalarie();
         }
      } else {
         this.annuleSalarie();
      }

      this.showModalPanelAgents = false;
   }

   public void annuleSalarie() {
      this.salaries = new Salaries();
      this.nomSalarie = "";
      this.showModalPanelAgents = false;
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
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "liste" + File.separator + "mission";
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

      var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "document" + File.separator + "mission";
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

         if (var2 == 0) {
            var1.setRapport(var3);
            var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "document" + File.separator + "mission" + File.separator);
            var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "sous_rapport" + File.separator);
            var1.setEntete("Impression ordre de mission");
            var1.setFormat(var5);
            var1.setEmetteur(var6);
            var1.setDestinataire(var7);
            var1.setDestinataireCC(var8);
            var1.setDestinataireCCI(var9);
            var1.setCorpsMail(var10);
            var1.setTiersSelectionne((Tiers)null);
            ArrayList var11 = new ArrayList();
            if (this.lesSalariesMissions.size() != 0) {
               for(int var12 = 0; var12 < this.lesSalariesMissions.size(); ++var12) {
                  this.salariesMissions = (SalariesMissions)this.lesSalariesMissions.get(var12);
                  var11.add(this.salariesMissions);
               }
            } else {
               var11.add(new SalariesMissions());
            }

            JRBeanCollectionDataSource var14 = new JRBeanCollectionDataSource(var11);
            var1.setjRBeanCollectionDataSource(var14);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         } else if (var2 == 1) {
            var1.setRapport(var4);
            var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "liste" + File.separator + "mission" + File.separator);
            var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "sous_rapport" + File.separator);
            var1.setEntete("Impression liste des missions");
            var1.setFormat(var5);
            var1.setEmetteur(var6);
            var1.setDestinataire(var7);
            var1.setDestinataireCC(var8);
            var1.setDestinataireCCI(var9);
            var1.setCorpsMail(var10);
            var1.setTiersSelectionne((Tiers)null);
            JRBeanCollectionDataSource var13 = new JRBeanCollectionDataSource(this.lesMissions);
            var1.setjRBeanCollectionDataSource(var13);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      }

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

   public Missions getMissions() {
      return this.missions;
   }

   public void setMissions(Missions var1) {
      this.missions = var1;
   }

   public boolean isVar_acc_contrat() {
      return this.var_acc_contrat;
   }

   public void setVar_acc_contrat(boolean var1) {
      this.var_acc_contrat = var1;
   }

   public boolean isVar_acc_complement() {
      return this.var_acc_complement;
   }

   public void setVar_acc_complement(boolean var1) {
      this.var_acc_complement = var1;
   }

   public boolean isVar_acc_familial() {
      return this.var_acc_familial;
   }

   public void setVar_acc_familial(boolean var1) {
      this.var_acc_familial = var1;
   }

   public boolean isVar_acc_identification() {
      return this.var_acc_identification;
   }

   public void setVar_acc_identification(boolean var1) {
      this.var_acc_identification = var1;
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

   public String getVar_service_rec() {
      return this.var_service_rec;
   }

   public void setVar_service_rec(String var1) {
      this.var_service_rec = var1;
   }

   public DataModel getDatamodelMissions() {
      return this.datamodelMissions;
   }

   public void setDatamodelMissions(DataModel var1) {
      this.datamodelMissions = var1;
   }

   public boolean isVar_affiche_bouton() {
      return this.var_affiche_bouton;
   }

   public void setVar_affiche_bouton(boolean var1) {
      this.var_affiche_bouton = var1;
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

   public String getVar_activite_rec() {
      return this.var_activite_rec;
   }

   public void setVar_activite_rec(String var1) {
      this.var_activite_rec = var1;
   }

   public String getVar_periode() {
      return this.var_periode;
   }

   public void setVar_periode(String var1) {
      this.var_periode = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public String getVar_num_rec() {
      return this.var_num_rec;
   }

   public void setVar_num_rec(String var1) {
      this.var_num_rec = var1;
   }

   public int getVar_type_rec() {
      return this.var_type_rec;
   }

   public void setVar_type_rec(int var1) {
      this.var_type_rec = var1;
   }

   public DataModel getDatamodelSalariesMissions() {
      return this.datamodelSalariesMissions;
   }

   public void setDatamodelSalariesMissions(DataModel var1) {
      this.datamodelSalariesMissions = var1;
   }

   public SalariesMissions getSalariesMissions() {
      return this.salariesMissions;
   }

   public void setSalariesMissions(SalariesMissions var1) {
      this.salariesMissions = var1;
   }

   public boolean isVar_affiche_agents() {
      return this.var_affiche_agents;
   }

   public void setVar_affiche_agents(boolean var1) {
      this.var_affiche_agents = var1;
   }

   public boolean isShowModalPanelSalariesMissions() {
      return this.showModalPanelSalariesMissions;
   }

   public void setShowModalPanelSalariesMissions(boolean var1) {
      this.showModalPanelSalariesMissions = var1;
   }

   public String getNomSalarie() {
      return this.nomSalarie;
   }

   public void setNomSalarie(String var1) {
      this.nomSalarie = var1;
   }

   public DataModel getDataModelLesSalaries() {
      return this.dataModelLesSalaries;
   }

   public void setDataModelLesSalaries(DataModel var1) {
      this.dataModelLesSalaries = var1;
   }

   public boolean isShowModalPanelAgents() {
      return this.showModalPanelAgents;
   }

   public void setShowModalPanelAgents(boolean var1) {
      this.showModalPanelAgents = var1;
   }

   public Salaries getSalaries() {
      return this.salaries;
   }

   public void setSalaries(Salaries var1) {
      this.salaries = var1;
   }

   public DataModel getDatamodelSalariesMissionsFrais() {
      return this.datamodelSalariesMissionsFrais;
   }

   public void setDatamodelSalariesMissionsFrais(DataModel var1) {
      this.datamodelSalariesMissionsFrais = var1;
   }

   public SalariesMissionsFrais getSalariesMissionsFrais() {
      return this.salariesMissionsFrais;
   }

   public void setSalariesMissionsFrais(SalariesMissionsFrais var1) {
      this.salariesMissionsFrais = var1;
   }

   public boolean isShowModalPanelSalariesMissionsFrais() {
      return this.showModalPanelSalariesMissionsFrais;
   }

   public void setShowModalPanelSalariesMissionsFrais(boolean var1) {
      this.showModalPanelSalariesMissionsFrais = var1;
   }

   public boolean isVar_affiche_frais() {
      return this.var_affiche_frais;
   }

   public void setVar_affiche_frais(boolean var1) {
      this.var_affiche_frais = var1;
   }

   public List getLesAgentsItems() {
      return this.lesAgentsItems;
   }

   public void setLesAgentsItems(List var1) {
      this.lesAgentsItems = var1;
   }

   public DataModel getDataModelAccompagnant() {
      return this.dataModelAccompagnant;
   }

   public void setDataModelAccompagnant(DataModel var1) {
      this.dataModelAccompagnant = var1;
   }

   public List getMesResponsablesItems() {
      return this.mesResponsablesItems;
   }

   public void setMesResponsablesItems(List var1) {
      this.mesResponsablesItems = var1;
   }

   public long getVar_nom_responsable() {
      return this.var_nom_responsable;
   }

   public void setVar_nom_responsable(long var1) {
      this.var_nom_responsable = var1;
   }

   public List getMesProjetItems() {
      return this.mesProjetItems;
   }

   public void setMesProjetItems(List var1) {
      this.mesProjetItems = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
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
}
