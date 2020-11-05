package com.epegase.forms.paye;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.ContratEnteteVentes;
import com.epegase.systeme.classe.ExercicesPaye;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.Salaries;
import com.epegase.systeme.classe.SalariesPointage;
import com.epegase.systeme.classe.SalariesTaches;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Taches;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.ObjetGraph;
import com.epegase.systeme.dao.ContratEnteteVentesDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.HabilitationDao;
import com.epegase.systeme.dao.SalariesDao;
import com.epegase.systeme.dao.SalariesPointageDao;
import com.epegase.systeme.dao.SalariesTachesDao;
import com.epegase.systeme.dao.TachesDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.ObjetLigneOnglet;
import com.epegase.systeme.xml.OptionPaye;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
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

public class FormPointage implements Serializable {
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
   private UserDao userDao;
   private String periode;
   private List lesPeriodes = new ArrayList();
   private UtilDate utilDate = new UtilDate();
   private int etat;
   private int jour;
   private boolean var_aff_action;
   private boolean testsaisiePointage = false;
   private boolean var_acc_identification = false;
   private boolean var_acc_complement = false;
   private boolean var_acc_familial = false;
   private boolean var_acc_contrat = false;
   private boolean var_ajt = false;
   private boolean var_mod = false;
   private boolean var_sup = false;
   private boolean var_imp = false;
   private List mesServiceItems;
   private List mesActiviteItems;
   private List mesBudgetItems;
   private List mesProjetItems;
   private SalariesPointage salariesPointage;
   private SalariesPointageDao salariesPointageDao;
   private List lesSalariesPointage = new ArrayList();
   private transient DataModel datamodelSalariesPointage = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private boolean var_affiche_bouton = false;
   private boolean showModalPanelPointage = false;
   private List lesjoursItems = new ArrayList();
   private String tache;
   private List mesAgentsItems = new ArrayList();
   private long var_nom_agent;
   private Salaries salaries;
   private SalariesDao salariesDao;
   private List documentImpressionItems = new ArrayList();
   private List listeImpressionItems = new ArrayList();
   private boolean showModalPanelPrint = false;
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
   private FormRecherche formRecherche;
   private boolean showModalPanelInformation = false;
   private String nomCreation;
   private String nomModification;
   private List mesMissionsItems = new ArrayList();
   private List mesTachesItems = new ArrayList();
   private Tiers tiers;
   private SalariesTachesDao salariesTachesDao;
   private SalariesTaches salariesTaches;
   private Taches taches;
   private TachesDao tachesDao;
   private ContratEnteteVentes contratEnteteVentes;
   private ContratEnteteVentesDao contratEnteteVentesDao;
   private List lesContrats = new ArrayList();
   private List lesContratsActifsItems = new ArrayList();
   private List lesTaches = new ArrayList();
   private TiersDao tiersDao;

   public FormPointage() throws IOException {
   }

   public void InstancesDaoUtilses() {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.salariesPointageDao = new SalariesPointageDao(this.baseLog, this.utilInitHibernate);
      this.salariesDao = new SalariesDao(this.baseLog, this.utilInitHibernate);
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.habilitationDao = new HabilitationDao(this.baseLog, this.utilInitHibernate);
      this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.contratEnteteVentesDao = new ContratEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.salariesTachesDao = new SalariesTachesDao(this.baseLog, this.utilInitHibernate);
      this.tachesDao = new TachesDao(this.baseLog, this.utilInitHibernate);
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
   }

   public void initialisationPointage(Session var1) throws HibernateException, NamingException {
      if (this.optionPaye.getNbLigneMax() != null && !this.optionPaye.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionPaye.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      this.mesMissionsItems.clear();
      this.mesTachesItems.clear();
      this.lesContratsActifsItems.clear();
      if (this.optionPaye.getTemps().equals("1")) {
         this.lesContrats = this.contratEnteteVentesDao.rechercheToutContrat(var1);
         this.lesTaches = this.tachesDao.selectTaches(var1);
      }

   }

   public void initialisationTemps(Session var1) throws HibernateException, NamingException {
      if (this.optionPaye.getNbLigneMax() != null && !this.optionPaye.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionPaye.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      this.mesMissionsItems.clear();
      this.mesTachesItems.clear();
      this.lesContratsActifsItems.clear();
      if (this.optionPaye.getTemps().equals("1")) {
         this.lesContrats = this.contratEnteteVentesDao.rechercheToutContrat(var1);
         this.lesTaches = this.tachesDao.selectTaches(var1);
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

   }

   public String getUrlIp() {
      return StaticModePegase.getUrlIp();
   }

   public Habilitation verifHabilitation(int var1, Session var2) throws HibernateException, NamingException {
      new Habilitation();
      Habilitation var3 = this.habilitationDao.existenceHabilitation(var1, var2);
      return var3;
   }

   public void recupererLesAgentsItem(Session var1) throws HibernateException, NamingException {
      this.mesAgentsItems.clear();
      if (this.usersLog.getUsrPayPointage() == 0) {
         this.pointageIndividuel(var1);
      } else {
         this.pointageGlobal(var1);
      }

   }

   public void pointageIndividuel(Session var1) throws HibernateException, NamingException {
      this.mesAgentsItems.clear();
      if (this.usersLog.getUsrIdSalarieGuest() != 0L) {
         this.salaries = this.salariesDao.chercherIdSalaries(this.usersLog.getUsrIdSalarieGuest(), var1);
      } else {
         this.salaries = this.salariesDao.chercherNomPrenomSalaries(this.usersLog.getUsrNom(), this.usersLog.getUsrPrenom(), var1);
      }

      if (this.salaries != null) {
         String var2 = "";
         if (this.salaries.getSalPrenom() != null && !this.salaries.getSalPrenom().isEmpty()) {
            var2 = this.salaries.getSalNom() + " " + this.salaries.getSalPrenom();
         } else {
            var2 = this.salaries.getSalNom();
         }

         this.mesAgentsItems.add(new SelectItem(this.salaries.getSalId(), this.salaries.getSalMatricule() + ":" + var2));
      }

   }

   public void pointageIndividuel(long var1, Session var3) throws HibernateException, NamingException {
      this.mesAgentsItems.clear();
      if (var1 != 0L) {
         this.salaries = this.salariesDao.chercherIdSalaries(var1, var3);
         if (this.salaries != null) {
            String var4 = "";
            if (this.salaries.getSalPrenom() != null && !this.salaries.getSalPrenom().isEmpty()) {
               var4 = this.salaries.getSalNom() + " " + this.salaries.getSalPrenom();
            } else {
               var4 = this.salaries.getSalNom();
            }

            this.mesAgentsItems.add(new SelectItem(this.salaries.getSalId(), this.salaries.getSalMatricule() + ":" + var4));
         }
      }

   }

   public void pointageGlobal(Session var1) throws HibernateException, NamingException {
      this.mesAgentsItems.clear();
      new ArrayList();
      List var2 = this.salariesDao.chargerlesSalariesActif("*", var1);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            String var4 = "";
            if (((Salaries)var2.get(var3)).getSalPrenom() != null && !((Salaries)var2.get(var3)).getSalPrenom().isEmpty()) {
               var4 = ((Salaries)var2.get(var3)).getSalNom() + " " + ((Salaries)var2.get(var3)).getSalPrenom();
            } else {
               var4 = ((Salaries)var2.get(var3)).getSalNom();
            }

            this.mesAgentsItems.add(new SelectItem(((Salaries)var2.get(var3)).getSalId(), ((Salaries)var2.get(var3)).getSalMatricule() + ":" + var4));
         }
      }

   }

   public void calculPeriode(Session var1) throws HibernateException, NamingException {
      this.lesPeriodes.clear();
      this.lesPeriodes.add(new SelectItem("Sélectionner une période"));
      Date var2 = this.exercicesPaye.getExepayDateDebut();
      GregorianCalendar var3 = new GregorianCalendar();
      var3.setTime(var2);
      Date var4 = this.exercicesPaye.getExepayDateFin();
      GregorianCalendar var5 = new GregorianCalendar();
      var5.setTime(var4);
      var3.add(2, -1);
      var5.add(2, -1);
      String var6 = null;

      while(var3.compareTo(var5) < 0) {
         var3.add(2, 1);
         Date var7 = var3.getTime();
         var6 = this.formatPeriode(var7);
         this.lesPeriodes.add(new SelectItem(var6));
      }

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

   public void razPointage() throws HibernateException, NamingException {
      this.lesSalariesPointage.clear();
      this.datamodelSalariesPointage.setWrappedData(this.lesSalariesPointage);
      if (this.var_nom_agent != 0L) {
         this.salaries = this.salariesDao.chercherIdSalaries(this.var_nom_agent, (Session)null);
      }

   }

   public void razTemps() throws HibernateException, NamingException {
      this.lesSalariesPointage.clear();
      this.datamodelSalariesPointage.setWrappedData(this.lesSalariesPointage);
      if (this.var_nom_agent != 0L) {
         this.salaries = this.salariesDao.chercherIdSalaries(this.var_nom_agent, (Session)null);
      }

   }

   public void chargerLesPointages() throws HibernateException, NamingException {
      this.chargerLesPointages((Session)null);
   }

   public void chargerLesPointages(Session var1) throws HibernateException, NamingException {
      this.lesSalariesPointage.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      if (this.periode != null && !this.periode.isEmpty() && this.periode.contains(":")) {
         this.salaries = this.salariesDao.chercherIdSalaries(this.var_nom_agent, var1);
         if (this.salaries != null) {
            if (!this.optionPaye.getTemps().equals("1")) {
               this.lesSalariesPointage = this.salariesPointageDao.chargerlesPointages(this.salaries, this.periode, this.etat, var1);
            } else {
               new ArrayList();
               List var2 = this.salariesPointageDao.chargerlesPointages(this.salaries, this.periode, this.etat, var1);
               if (var2.size() != 0) {
                  for(int var3 = 0; var3 < var2.size(); ++var3) {
                     this.salariesPointage = (SalariesPointage)var2.get(var3);
                     int var4;
                     if (this.salariesPointage.getSalpoiMission() != null && !this.salariesPointage.getSalpoiMission().isEmpty()) {
                        for(var4 = 0; var4 < this.lesContrats.size(); ++var4) {
                           if (((ContratEnteteVentes)this.lesContrats.get(var4)).getCrtNum().equals(this.salariesPointage.getSalpoiMission())) {
                              this.salariesPointage.setLibelleMission(((ContratEnteteVentes)this.lesContrats.get(var4)).getCrtNature());
                              break;
                           }
                        }
                     }

                     if (this.salariesPointage.getSalpoiTache() != null && !this.salariesPointage.getSalpoiTache().isEmpty()) {
                        for(var4 = 0; var4 < this.lesTaches.size(); ++var4) {
                           if (((Taches)this.lesTaches.get(var4)).getTacCode().equals(this.salariesPointage.getSalpoiTache())) {
                              this.salariesPointage.setLibelleTache(((Taches)this.lesTaches.get(var4)).getTacNomFr());
                              break;
                           }
                        }
                     }

                     this.lesSalariesPointage.add(this.salariesPointage);
                  }
               }
            }

            this.testsaisiePointage = true;
         } else {
            this.testsaisiePointage = false;
         }
      } else {
         this.testsaisiePointage = false;
      }

      this.datamodelSalariesPointage.setWrappedData(this.lesSalariesPointage);
   }

   public void selectionPointage() throws IOException, SQLException, HibernateException, NamingException, ParseException {
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
            this.salariesPointage = (SalariesPointage)var1.get(0);
            Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcontratEnteteLight");
            this.tiers = this.tiersDao.selectTierD(this.salariesPointage.getSalpoiIdTiers(), var5);
            if (this.tiers == null) {
               this.tiers = new Tiers();
            }

            if (this.salariesPointage.getSalpoiTache() != null && !this.salariesPointage.getSalpoiTache().isEmpty()) {
               if (this.salariesPointage.getSalpoiTache().contains(":")) {
                  String[] var4 = this.salariesPointage.getSalpoiTache().split(":");
                  this.tache = var4[0];
               } else {
                  this.tache = this.salariesPointage.getSalpoiTache();
               }
            } else {
               this.tache = "";
            }

            this.calculeMission(var5);
            this.calculeTache(var5);
            this.utilInitHibernate.closeSession();
            this.calculLesJourDunMois();
            this.jour = this.salariesPointage.getSalpoiDate().getDay();
            this.var_affiche_bouton = true;
         } else {
            this.var_affiche_bouton = false;
         }
      } else {
         this.var_affiche_bouton = false;
      }

   }

   public void visualisationPointage() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.salariesPointage != null) {
         if (this.salariesPointage.getSalpoiEtat() == 0) {
            this.modifierPointage();
         } else {
            this.consulterPointage();
         }
      }

   }

   public void calculLesJourDunMois() throws ParseException {
      this.lesjoursItems = new ArrayList();
      String[] var1 = this.periode.split(":");
      String var2 = var1[0];
      String var3 = var1[1];
      Date var4 = this.utilDate.stringToDateFr("01-" + var2 + "-" + var3);
      GregorianCalendar var5 = new GregorianCalendar();
      var5.setTime(var4);
      Date var6 = this.utilDate.dateDernierJourMois(var4);
      GregorianCalendar var7 = new GregorianCalendar();
      var7.setTime(var6);
      int var8 = 1;

      for(boolean var9 = false; var5.compareTo(var7) <= 0; ++var8) {
         var5.add(5, 1);
         if (!var9) {
            this.lesjoursItems.add(new SelectItem(var8));
         }
      }

   }

   public boolean chercheDateUnique(int var1) {
      boolean var2 = false;
      if (this.lesSalariesPointage.size() != 0) {
         for(int var3 = 0; var3 < this.lesSalariesPointage.size(); ++var3) {
            this.salariesPointage = (SalariesPointage)this.lesSalariesPointage.get(var3);
            if (this.salariesPointage.getVar_jour() == var1) {
               break;
            }
         }
      }

      return var2;
   }

   public void ajouterPointage() throws ParseException {
      this.salariesPointage = new SalariesPointage();
      this.mesMissionsItems.clear();
      this.mesTachesItems.clear();
      this.tache = "";
      this.calculLesJourDunMois();
      this.var_aff_action = false;
      this.var_action = 1;
      this.var_memo_action = this.var_action;
   }

   public void modifierPointage() {
      if (this.salariesPointage != null) {
         this.var_aff_action = false;
         this.var_action = 2;
         this.var_memo_action = this.var_action;
      }

   }

   public void consulterPointage() {
      if (this.salariesPointage != null) {
         this.var_aff_action = true;
         this.var_action = 3;
         this.var_memo_action = this.var_action;
      }

   }

   public void supprimerPointage() throws HibernateException, NamingException {
      if (this.salariesPointage != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.salariesPointageDao.delete(this.salariesPointage, var1);
            this.lesSalariesPointage.remove(this.salariesPointage);
            this.datamodelSalariesPointage.setWrappedData(this.lesSalariesPointage);
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

      this.var_affiche_bouton = false;
      this.var_action = 0;
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
   }

   public void annulerPointage() {
      this.var_affiche_bouton = false;
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public void savePointage() throws HibernateException, NamingException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SalarieTache");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.salariesPointage.setSalpoiPeriode(this.periode);
         String var3 = "";
         String[] var4 = this.periode.split(":");
         String var5 = "";
         if (this.jour <= 9) {
            var5 = "0" + this.jour;
         } else {
            var5 = "" + this.jour;
         }

         var3 = var4[1] + "-" + var4[0] + "-" + var5;
         this.salariesPointage.setSalpoiDate(this.utilDate.stringToDateSQLLight(var3));
         if (this.tache != null && !this.tache.isEmpty()) {
            this.taches = this.tachesDao.rechercheTache(this.tache, var1);
            if (this.taches != null) {
               this.salariesPointage.setSalpoiTache(this.taches.getTacCode() + ":" + this.taches.getTacNomFr());
               this.salariesPointage.setLibelleTache(this.taches.getTacNomFr());
               this.salariesTaches = this.salariesTachesDao.selectUsersTaches(this.salariesPointage.getSalpoiTache(), this.salaries, var1);
               if (this.salariesTaches != null) {
                  this.salariesPointage.setSalpoiPr((double)this.salariesTaches.getSaltacValPr());
                  this.salariesPointage.setSalpoiPv((double)this.salariesTaches.getSaltacValPv());
               } else {
                  this.salariesPointage.setSalpoiPr((double)this.taches.getTacValPr());
                  this.salariesPointage.setSalpoiPv((double)this.taches.getTacValPv());
               }

               if (this.salariesPointage.getSalpoiPr() == 0.0D || this.salariesPointage.getSalpoiPv() == 0.0D) {
                  new Users();
                  Users var6 = this.userDao.selectLeUserIdByAgent(this.salaries.getSalId(), var1);
                  if (var6 != null) {
                     if (this.salariesPointage.getSalpoiPr() == 0.0D) {
                        this.salariesPointage.setSalpoiPr(var6.getUsrPr());
                     }

                     if (this.salariesPointage.getSalpoiPv() == 0.0D) {
                        this.salariesPointage.setSalpoiPv(var6.getUsrPv());
                     }
                  }
               }
            }
         } else {
            this.salariesPointage.setSalpoiPr(0.0D);
            this.salariesPointage.setSalpoiPv(0.0D);
         }

         if (this.salariesPointage.getSalpoiMission() != null && !this.salariesPointage.getSalpoiMission().isEmpty()) {
            for(int var12 = 0; var12 < this.lesContrats.size(); ++var12) {
               if (((ContratEnteteVentes)this.lesContrats.get(var12)).getCrtNum().equals(this.salariesPointage.getSalpoiMission())) {
                  this.salariesPointage.setLibelleMission(((ContratEnteteVentes)this.lesContrats.get(var12)).getCrtNature());
                  break;
               }
            }
         } else {
            this.salariesPointage.setLibelleMission("");
         }

         if (this.salariesPointage.getSalpoiId() == 0L) {
            String var13 = this.calculChrono.numCompose(new Date(), this.nature, "", var1);
            this.salariesPointage.setExercicesPaye(this.exercicesPaye);
            this.salariesPointage.setSalaries(this.salaries);
            this.salariesPointage.setSalpoiNature(0);
            this.salariesPointage.setSalpoiDateCreat(new Date());
            this.salariesPointage.setSalpoiUserCreat(this.usersLog.getUsrid());
            this.salariesPointage.setSalpoiNum(var13);
            this.salariesPointage = this.salariesPointageDao.insert(this.salariesPointage, var1);
            this.lesSalariesPointage.add(this.salariesPointage);
            this.datamodelSalariesPointage.setWrappedData(this.lesSalariesPointage);
            this.var_action = 0;
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
         } else {
            this.salariesPointage.setSalpoiDateModif(new Date());
            this.salariesPointage.setSalpoiUserModif(this.usersLog.getUsrid());
            this.salariesPointage = this.salariesPointageDao.modif(this.salariesPointage, var1);
            this.var_action = 0;
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

   public void calculeMission() throws HibernateException, NamingException, ParseException {
      this.calculeMission((Session)null);
   }

   public void calculeMission(Session var1) throws HibernateException, NamingException, ParseException {
      this.mesMissionsItems.clear();
      if (this.optionPaye.getTemps().equals("1")) {
         String[] var2 = this.periode.split(":");
         String var3 = var2[0];
         String var4 = var2[1];
         Date var5 = this.utilDate.stringToDateSQLLight(var4 + "-" + var3 + "-" + this.jour);
         new ArrayList();
         List var6 = this.contratEnteteVentesDao.rechercheByTiers(this.tiers, var1);
         if (var6.size() != 0) {
            this.contratEnteteVentes = new ContratEnteteVentes();

            for(int var7 = 0; var7 < var6.size(); ++var7) {
               this.contratEnteteVentes = (ContratEnteteVentes)var6.get(var7);
               if (this.contratEnteteVentes.getCrtEtat() == 1) {
                  boolean var8 = false;
                  if (this.contratEnteteVentes.getCrtDateButoire() != null) {
                     if (var5.compareTo(this.contratEnteteVentes.getCrtDateButoire()) <= 0) {
                        var8 = true;
                     }
                  } else if (this.contratEnteteVentes.getCrtDateFin() != null) {
                     if (var5.compareTo(this.contratEnteteVentes.getCrtDateFin()) <= 0) {
                        var8 = true;
                     }
                  } else {
                     var8 = true;
                  }

                  if (var8) {
                     if (this.contratEnteteVentes.getCrtDateButoire() != null) {
                        this.mesMissionsItems.add(new SelectItem(this.contratEnteteVentes.getCrtNum(), this.contratEnteteVentes.getCrtNum() + ":" + (this.contratEnteteVentes.getCrtDateFin().getYear() + 1900)));
                     } else if (this.contratEnteteVentes.getCrtDateFin() != null) {
                        this.mesMissionsItems.add(new SelectItem(this.contratEnteteVentes.getCrtNum(), this.contratEnteteVentes.getCrtNum() + ":" + (this.contratEnteteVentes.getCrtDateFin().getYear() + 1900)));
                     } else if (this.contratEnteteVentes.getCrtDateDebut() != null) {
                        this.mesMissionsItems.add(new SelectItem(this.contratEnteteVentes.getCrtNum(), this.contratEnteteVentes.getCrtNum() + ":" + (this.contratEnteteVentes.getCrtDateDebut().getYear() + 1900)));
                     } else {
                        this.mesMissionsItems.add(new SelectItem(this.contratEnteteVentes.getCrtNum(), this.contratEnteteVentes.getCrtNum()));
                     }
                  }
               }
            }
         }
      }

   }

   public void calculeTache() throws HibernateException, NamingException {
      this.calculeTache((Session)null);
   }

   public void calculeTache(Session var1) throws HibernateException, NamingException {
      this.mesTachesItems.clear();
      if (this.optionPaye.getTemps().equals("1")) {
         if (this.salariesPointage.getSalpoiMission() != null && !this.salariesPointage.getSalpoiMission().isEmpty()) {
            this.contratEnteteVentes = this.contratEnteteVentesDao.pourParapheur(this.salariesPointage.getSalpoiMission(), var1);
         } else {
            this.contratEnteteVentes = null;
         }

         if (this.contratEnteteVentes != null && this.contratEnteteVentes.getCrtNature() != null && !this.contratEnteteVentes.getCrtNature().isEmpty()) {
            new ArrayList();
            List var2 = this.tachesDao.selectMissionTaches(this.contratEnteteVentes.getCrtNature(), var1);
            if (var2.size() != 0) {
               for(int var3 = 0; var3 < var2.size(); ++var3) {
                  this.mesTachesItems.add(new SelectItem(((Taches)var2.get(var3)).getTacCode(), ((Taches)var2.get(var3)).getTacCode() + ":" + ((Taches)var2.get(var3)).getTacNomFr()));
               }
            }
         }
      }

   }

   public void chargerLesTemps() throws HibernateException, NamingException {
      this.chargerLesTemps((Session)null);
   }

   public void chargerLesTemps(Session var1) throws HibernateException, NamingException {
      if (this.salaries != null) {
         new ArrayList();
         List var2 = this.salariesTachesDao.selectUsersTaches(this.salaries, var1);
         if (var2.size() != 0) {
            for(int var3 = 0; var3 < var2.size(); ++var3) {
               this.mesTachesItems.add(new SelectItem(((SalariesTaches)var2.get(var3)).getSaltacCode(), ((SalariesTaches)var2.get(var3)).getSaltacLib()));
            }
         }
      }

      this.lesSalariesPointage.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      if (this.periode != null && !this.periode.isEmpty() && this.periode.contains(":")) {
         this.salaries = this.salariesDao.chercherIdSalaries(this.var_nom_agent, var1);
         if (this.salaries != null) {
            this.lesSalariesPointage = this.salariesPointageDao.chargerlesPointages(this.salaries, this.periode, this.etat, var1);
            this.testsaisiePointage = true;
         } else {
            this.testsaisiePointage = false;
         }
      } else {
         this.testsaisiePointage = false;
      }

      this.datamodelSalariesPointage.setWrappedData(this.lesSalariesPointage);
   }

   public void annulerTemps() {
      this.var_affiche_bouton = false;
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public void saveTemps() throws HibernateException, NamingException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SalarieTache");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.salariesPointage.setSalpoiPeriode(this.periode);
         String[] var3 = this.periode.split(":");
         String var4 = "";
         if (this.jour <= 9) {
            var4 = "0" + this.jour;
         } else {
            var4 = "" + this.jour;
         }

         String var5 = var3[1] + "-" + var3[0] + "-" + var4;
         this.salariesPointage.setSalpoiDate(this.utilDate.stringToDateSQLLight(var5));
         if (this.tache != null && !this.tache.isEmpty()) {
            this.taches = this.tachesDao.rechercheTache(this.tache, var1);
            if (this.taches != null) {
               this.salariesPointage.setSalpoiTache(this.taches.getTacCode() + ":" + this.taches.getTacNomFr());
               this.salariesPointage.setLibelleTache(this.taches.getTacNomFr());
               this.salariesTaches = this.salariesTachesDao.selectUsersTaches(this.salariesPointage.getSalpoiTache(), this.salaries, var1);
               if (this.salariesTaches != null) {
                  this.salariesPointage.setSalpoiPr((double)this.salariesTaches.getSaltacValPr());
                  this.salariesPointage.setSalpoiPv((double)this.salariesTaches.getSaltacValPv());
               } else {
                  this.salariesPointage.setSalpoiPr((double)this.taches.getTacValPr());
                  this.salariesPointage.setSalpoiPv((double)this.taches.getTacValPv());
               }

               if (this.salariesPointage.getSalpoiPr() == 0.0D || this.salariesPointage.getSalpoiPv() == 0.0D) {
                  new Users();
                  Users var6 = this.userDao.selectLeUserIdByAgent(this.salaries.getSalId(), var1);
                  if (var6 != null) {
                     if (this.salariesPointage.getSalpoiPr() == 0.0D) {
                        this.salariesPointage.setSalpoiPr(var6.getUsrPr());
                     }

                     if (this.salariesPointage.getSalpoiPv() == 0.0D) {
                        this.salariesPointage.setSalpoiPv(var6.getUsrPv());
                     }
                  }
               }
            }
         } else {
            this.salariesPointage.setSalpoiPr(0.0D);
            this.salariesPointage.setSalpoiPv(0.0D);
         }

         if (this.salariesPointage.getSalpoiMission() != null && !this.salariesPointage.getSalpoiMission().isEmpty()) {
            for(int var12 = 0; var12 < this.lesContrats.size(); ++var12) {
               if (((ContratEnteteVentes)this.lesContrats.get(var12)).getCrtNum().equals(this.salariesPointage.getSalpoiMission())) {
                  this.salariesPointage.setLibelleMission(((ContratEnteteVentes)this.lesContrats.get(var12)).getCrtNature());
                  break;
               }
            }
         } else {
            this.salariesPointage.setLibelleMission("");
         }

         if (this.salariesPointage.getSalpoiId() == 0L) {
            String var13 = this.calculChrono.numCompose(new Date(), this.nature, "", var1);
            this.salariesPointage.setExercicesPaye(this.exercicesPaye);
            this.salariesPointage.setSalaries(this.salaries);
            this.salariesPointage.setSalpoiNature(1);
            this.salariesPointage.setSalpoiDateCreat(new Date());
            this.salariesPointage.setSalpoiUserCreat(this.usersLog.getUsrid());
            this.salariesPointage.setSalpoiNum(var13);
            this.salariesPointage = this.salariesPointageDao.insert(this.salariesPointage, var1);
            this.lesSalariesPointage.add(this.salariesPointage);
            this.datamodelSalariesPointage.setWrappedData(this.lesSalariesPointage);
            this.var_action = 0;
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
         } else {
            this.salariesPointage.setSalpoiDateModif(new Date());
            this.salariesPointage.setSalpoiUserModif(this.usersLog.getUsrid());
            this.salariesPointage = this.salariesPointageDao.modif(this.salariesPointage, var1);
            this.var_action = 0;
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

   public void rechercheTiers() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.var_memo_action = this.var_action;
      this.tiers = this.formRecherche.rechercheTiers(3, this.salariesPointage.getSalpoiNomTiers(), this.nature);
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

   public void recuperationTiers() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.tiers = this.formRecherche.calculeTiers();
      this.calculeTiers();
   }

   public void calculeTiers() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.mesMissionsItems.clear();
      this.mesTachesItems.clear();
      if (this.tiers != null) {
         String var1 = "";
         if (this.tiers.getTiegenre() == null || this.tiers.getTiegenre().isEmpty() || !this.tiers.getTiegenre().equalsIgnoreCase("010") && !this.tiers.getTiegenre().equalsIgnoreCase("020") && !this.tiers.getTiegenre().equalsIgnoreCase("030") && !this.tiers.getTiegenre().equalsIgnoreCase("037")) {
            var1 = this.tiers.getTieraisonsocialenom();
            this.salariesPointage.setSalpoiNomTiers(var1);
            this.salariesPointage.setSalpoiIdTiers(this.tiers.getTieid());
         } else {
            if (this.tiers.getTieprenom() != null && !this.tiers.getTieprenom().isEmpty()) {
               var1 = this.tiers.getTieraisonsocialenom() + " " + this.tiers.getTieprenom();
            } else {
               var1 = this.tiers.getTieraisonsocialenom();
            }

            this.salariesPointage.setSalpoiNomTiers(var1);
            this.salariesPointage.setSalpoiIdTiers(this.tiers.getTieid());
         }

         this.calculeMission();
      } else {
         this.annuleTiers();
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleTiers() throws ParseException {
      this.tiers = null;
      this.salariesPointage.setSalpoiNomTiers((String)null);
      this.salariesPointage.setSalpoiIdTiers(0L);
      this.mesMissionsItems.clear();
      this.mesTachesItems.clear();
      this.var_action = this.var_memo_action;
   }

   public void informationPiece() throws HibernateException, NamingException {
      if (this.salariesPointage != null) {
         this.nomCreation = "";
         this.nomModification = "";
         new Users();
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "SalarieTache");
         Users var1;
         if (this.salariesPointage.getSalpoiUserCreat() != 0L) {
            var1 = this.userDao.selectUserD(this.salariesPointage.getSalpoiUserCreat(), var2);
            if (var1 != null) {
               this.nomCreation = var1.getUsrPatronyme();
            }
         }

         if (this.salariesPointage.getSalpoiUserModif() != 0L) {
            var1 = this.userDao.selectUserD(this.salariesPointage.getSalpoiUserModif(), var2);
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
      if (this.nature == 94) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "liste" + File.separator + "temps";
      } else {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "liste" + File.separator + "pointage";
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

      if (this.nature == 94) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "document" + File.separator + "temps";
      } else {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "document" + File.separator + "pointage";
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
      if (var3 != null && !var3.isEmpty()) {
         if (!var5.equals("MAIL")) {
            var1 = new UtilPrint(this.utilInitHibernate);
         }

         if (var2 == 0) {
            var1.setRapport(var3);
            String var11 = "";
            if (this.nature == 94) {
               var11 = "temps";
            } else {
               var11 = "pointage";
            }

            var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "document" + File.separator + var11 + File.separator);
            var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "sous_rapport" + File.separator);
            var1.setEntete("Feuille de temps de " + this.salaries.getPatronyme());
            var1.setFiltre("Période de " + this.periode);
            var1.setFormat(var5);
            var1.setEmetteur(var6);
            var1.setDestinataire(var7);
            var1.setDestinataireCC(var8);
            var1.setDestinataireCCI(var9);
            var1.setCorpsMail(var10);
            var1.setTiersSelectionne((Tiers)null);
            JRBeanCollectionDataSource var12 = new JRBeanCollectionDataSource(this.lesSalariesPointage);
            var1.setjRBeanCollectionDataSource(var12);
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
      if (this.lesSalariesPointage.size() != 0) {
         if (this.valQteGraph == 0) {
            this.uniteGraph = "TEMPS : Duree en HH,MM";
            this.deviseGraph = "";
            this.nbDecGraph = 2;
         } else if (this.valQteGraph == 1) {
            this.uniteGraph = "TEMPS : P.V. en " + this.structureLog.getStrdevise();
            this.deviseGraph = this.structureLog.getStrdevise();
            if (!this.structureLog.getStrdevise().equals("XOF") && !this.structureLog.getStrdevise().equals("XAF")) {
               this.nbDecGraph = 2;
            } else {
               this.nbDecGraph = 0;
            }
         } else {
            this.uniteGraph = "TEMPS : P.R. en " + this.structureLog.getStrdevise();
            this.deviseGraph = this.structureLog.getStrdevise();
            if (!this.structureLog.getStrdevise().equals("XOF") && !this.structureLog.getStrdevise().equals("XAF")) {
               this.nbDecGraph = 2;
            } else {
               this.nbDecGraph = 0;
            }
         }

         this.titreGraph = "Analyse des temps : ";
         this.titreGraph = this.titreGraph + " Periode " + this.periode;
         this.sousTitreGraph = "";
         if (this.modeGraph == 0) {
            this.sousTitreGraph = this.sousTitreGraph + " - En Global (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 1) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par client (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 2) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par mission (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 3) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par tache (" + this.uniteGraph + ")";
         }

         new SalariesPointage();
         if (this.lesSalariesPointage.size() != 0) {
            String var3 = "";
            long var4 = 0L;
            boolean var6 = false;
            int var7 = 0;

            while(true) {
               if (var7 >= this.lesSalariesPointage.size()) {
                  var1 = this.calculePourcentage((List)var1);
                  break;
               }

               SalariesPointage var2 = (SalariesPointage)this.lesSalariesPointage.get(var7);
               var3 = "";
               var4 = 0L;
               int var9 = 0;
               if (this.modeGraph == 0) {
                  int var8 = var2.getSalpoiDate().getDay() + 1;
                  var3 = "" + var8;
               } else if (this.modeGraph == 1) {
                  if (var2.getSalpoiNomTiers() != null && !var2.getSalpoiNomTiers().isEmpty()) {
                     var3 = var2.getSalpoiNomTiers();
                  } else {
                     var3 = "Sans Client";
                  }
               } else if (this.modeGraph == 2) {
                  if (var2.getSalpoiMission() != null && !var2.getSalpoiMission().isEmpty()) {
                     var3 = var2.getSalpoiMission();
                  } else {
                     var3 = "Sans Mission";
                  }
               } else if (this.modeGraph == 3) {
                  if (var2.getSalpoiTache() != null && !var2.getSalpoiTache().isEmpty()) {
                     var3 = var2.getSalpoiTache();
                  } else {
                     var3 = "Sans Tache";
                  }
               }

               if (this.valQteGraph == 0) {
                  var4 = (long)((float)var4 + var2.getSalpoiDuree());
               } else if (this.valQteGraph == 1) {
                  var4 = (long)((double)var4 + var2.getSalpoiPv());
               } else if (this.valQteGraph == 2) {
                  var4 = (long)((double)var4 + var2.getSalpoiPr());
               }

               if (this.timeDecoupage == 0) {
                  var9 = var2.getSalpoiDate().getDay() + 1;
               }

               var1 = this.calculeListe((List)var1, var3, var9, var4);
               ++var7;
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

   public SalariesPointage getSalariesPointage() {
      return this.salariesPointage;
   }

   public void setSalariesPointage(SalariesPointage var1) {
      this.salariesPointage = var1;
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

   public DataModel getDatamodelSalariesPointage() {
      return this.datamodelSalariesPointage;
   }

   public void setDatamodelSalariesPointage(DataModel var1) {
      this.datamodelSalariesPointage = var1;
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

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public List getMesProjetItems() {
      return this.mesProjetItems;
   }

   public void setMesProjetItems(List var1) {
      this.mesProjetItems = var1;
   }

   public List getLesPeriodes() {
      return this.lesPeriodes;
   }

   public void setLesPeriodes(List var1) {
      this.lesPeriodes = var1;
   }

   public String getPeriode() {
      return this.periode;
   }

   public void setPeriode(String var1) {
      this.periode = var1;
   }

   public int getEtat() {
      return this.etat;
   }

   public void setEtat(int var1) {
      this.etat = var1;
   }

   public List getMesAgentsItems() {
      return this.mesAgentsItems;
   }

   public void setMesAgentsItems(List var1) {
      this.mesAgentsItems = var1;
   }

   public boolean isShowModalPanelPointage() {
      return this.showModalPanelPointage;
   }

   public void setShowModalPanelPointage(boolean var1) {
      this.showModalPanelPointage = var1;
   }

   public long getVar_nom_agent() {
      return this.var_nom_agent;
   }

   public void setVar_nom_agent(long var1) {
      this.var_nom_agent = var1;
   }

   public Salaries getSalaries() {
      return this.salaries;
   }

   public void setSalaries(Salaries var1) {
      this.salaries = var1;
   }

   public boolean isTestsaisiePointage() {
      return this.testsaisiePointage;
   }

   public void setTestsaisiePointage(boolean var1) {
      this.testsaisiePointage = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public int getJour() {
      return this.jour;
   }

   public void setJour(int var1) {
      this.jour = var1;
   }

   public List getLesjoursItems() {
      return this.lesjoursItems;
   }

   public void setLesjoursItems(List var1) {
      this.lesjoursItems = var1;
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

   public boolean isVar_aff_action() {
      return this.var_aff_action;
   }

   public void setVar_aff_action(boolean var1) {
      this.var_aff_action = var1;
   }

   public List getMesMissionsItems() {
      return this.mesMissionsItems;
   }

   public void setMesMissionsItems(List var1) {
      this.mesMissionsItems = var1;
   }

   public List getMesTachesItems() {
      return this.mesTachesItems;
   }

   public void setMesTachesItems(List var1) {
      this.mesTachesItems = var1;
   }

   public List getLesContratsActifsItems() {
      return this.lesContratsActifsItems;
   }

   public void setLesContratsActifsItems(List var1) {
      this.lesContratsActifsItems = var1;
   }

   public String getTache() {
      return this.tache;
   }

   public void setTache(String var1) {
      this.tache = var1;
   }

   public String getDeviseGraph() {
      return this.deviseGraph;
   }

   public void setDeviseGraph(String var1) {
      this.deviseGraph = var1;
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

   public boolean isShowModele() {
      return this.showModele;
   }

   public void setShowModele(boolean var1) {
      this.showModele = var1;
   }
}
