package com.epegase.forms.immobilier;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.AppelCharge;
import com.epegase.systeme.classe.Bien;
import com.epegase.systeme.classe.BienBudgetEntete;
import com.epegase.systeme.classe.BienBudgetLigne;
import com.epegase.systeme.classe.BienTravauxEntete;
import com.epegase.systeme.classe.BienTravauxLigne;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.BlocImmeuble;
import com.epegase.systeme.dao.AppelChargeDao;
import com.epegase.systeme.dao.BienBudgetEnteteDao;
import com.epegase.systeme.dao.BienBudgetLigneDao;
import com.epegase.systeme.dao.BienDao;
import com.epegase.systeme.dao.BienTravauxEnteteDao;
import com.epegase.systeme.dao.BienTravauxLigneDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.ObjetLigneOnglet;
import com.epegase.systeme.xml.OptionVentes;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
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

public class FormBudgetImmobilier implements Serializable {
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
   private transient DataModel datamodelBudget = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private List listBudget = new ArrayList();
   private BienBudgetEnteteDao bienBudgetEnteteDao;
   private BienBudgetEntete bienBudgetEntete = new BienBudgetEntete();
   private transient DataModel datamodelPoste = new ListDataModel();
   private List listPoste = new ArrayList();
   private BienBudgetLigneDao bienBudgetLigneDao;
   private BienBudgetLigne bienBudgetLigne = new BienBudgetLigne();
   private Bien bien = new Bien();
   private BienDao bienDao;
   private boolean visibiliteBton = false;
   private boolean visibilitePoste = false;
   private boolean var_aff_detail_local = false;
   private boolean var_valide_doc = false;
   private List lesPeriodes = new ArrayList();
   private List mesBiensSyndics = new ArrayList();
   private boolean showModalPanelPoste = false;
   private long var_bienSyndic;
   private double var_reliquat;
   private double var_budget;
   private double var_depenses;
   private double var_depensesNomImpute;
   private double var_ecart;
   private float var_pourcentage;
   private List mesCoproprietaireItems;
   private TiersDao tiersDao;
   private Tiers tiers;
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
   private int inpEtat = 1;
   private int inpMode = 100;
   private int periode = 0;
   private boolean var_more_search = false;
   private List lesBlocsItems;
   private Users responsable;
   private long var_nom_commercial;
   private List mesSerieUserItem;
   private boolean showModalPanelPrint = false;
   private String montant_lettre;
   private String devisePrint;
   private float tauxPrint;
   private String filtre;
   private transient DataModel datamodelAppelCharges;
   private List listAppelCharges;
   private AppelChargeDao appelChargeDao;
   private AppelCharge appelCharge;
   private transient DataModel datamodelTravaux;
   private List listTravaux;
   private BienTravauxEnteteDao bienTravauxEnteteDao;
   private BienTravauxEntete bienTravauxEntete;
   private transient DataModel datamodelFactureTravaux;
   private List listFactureTravaux;
   private BienTravauxLigneDao bienTravauxLigneDao;
   private BienTravauxLigne bienTravauxLigne;

   public FormBudgetImmobilier() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.datamodelAppelCharges = new ListDataModel();
      this.listAppelCharges = new ArrayList();
      this.appelCharge = new AppelCharge();
      this.datamodelTravaux = new ListDataModel();
      this.listTravaux = new ArrayList();
      this.bienTravauxEntete = new BienTravauxEntete();
      this.datamodelFactureTravaux = new ListDataModel();
      this.listFactureTravaux = new ArrayList();
      this.bienTravauxLigne = new BienTravauxLigne();
      this.mesCoproprietaireItems = new ArrayList();
      this.lesBlocsItems = new ArrayList();
   }

   public void InstancesDaoUtilses() {
      this.bienBudgetEnteteDao = new BienBudgetEnteteDao(this.baseLog, this.utilInitHibernate);
      this.bienBudgetLigneDao = new BienBudgetLigneDao(this.baseLog, this.utilInitHibernate);
      this.bienDao = new BienDao(this.baseLog, this.utilInitHibernate);
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.appelChargeDao = new AppelChargeDao(this.baseLog, this.utilInitHibernate);
      this.bienTravauxEnteteDao = new BienTravauxEnteteDao(this.baseLog, this.utilInitHibernate);
      this.bienTravauxLigneDao = new BienTravauxLigneDao(this.baseLog, this.utilInitHibernate);
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

      if (this.optionsVentes.getAffichInGlobViewBLC().equals("0")) {
         this.periode = 0;
      } else {
         this.periode = (new Date()).getYear() + 1900;
      }

      this.usersChrono = new UsersChrono();
      this.usersChrono = this.usersChronoDao.selectUnique("", this.nature, this.usersLog, var1);
      this.lesPeriodes.clear();
      new ArrayList();
      List var2 = this.bienBudgetEnteteDao.chargerBudgetPeriode(var1);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            this.lesPeriodes.add(new SelectItem(((BienBudgetEntete)var2.get(var3)).getBiebudentAnnee()));
         }
      }

      this.mesBiensSyndics.clear();
      new ArrayList();
      List var5 = this.bienDao.chargeBienSyndic(var1);
      if (var5.size() != 0) {
         for(int var4 = 0; var4 < var5.size(); ++var4) {
            this.bien = (Bien)var5.get(var4);
            if (this.bien.getBieType() == 2) {
               this.mesBiensSyndics.add(new SelectItem(this.bien.getBieId(), this.bien.getBieNum() + ":" + this.bien.getBieNom()));
            }
         }
      }

      this.mesCoproprietaireItems = this.tiersDao.chargerLesCoproprietairesItems(var1);
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

   public void moreSearch() throws ParseException {
      if (!this.var_more_search) {
         this.var_more_search = true;
         this.periode = 0;
      } else {
         this.var_more_search = false;
      }

   }

   public void executerRequete() throws IOException, HibernateException, NamingException, ParseException {
      this.chargeListeDetail((Session)null);
   }

   public void chargeListeDetail(Session var1) throws HibernateException, NamingException, ParseException {
      this.listBudget.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      this.listPoste.clear();
      this.listBudget = this.bienBudgetEnteteDao.recherche(var1, this.getInpEtat(), this.getInpMode(), this.getPeriode(), this.usersLog.getUsrid(), this.usersLog.getUsrVentes());
      this.datamodelBudget.setWrappedData(this.listBudget);
      this.datamodelPoste.setWrappedData(this.listPoste);
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
            this.bienBudgetEntete = (BienBudgetEntete)var1.get(0);
            this.bien = this.bienBudgetEntete.getBien();
            this.var_bienSyndic = this.bien.getBieId();
            this.listPoste.clear();
            this.listAppelCharges.clear();
            this.listTravaux.clear();
            this.listFactureTravaux.clear();
            if (this.bien != null) {
               Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
               this.listPoste = this.bienBudgetLigneDao.chargerBudgetByBien(this.bienBudgetEntete, var4);
               this.listAppelCharges = this.appelChargeDao.chargerAppelByBien(this.bien, this.bienBudgetEntete.getBiebudentDateDebut(), this.bienBudgetEntete.getBiebudentDateFin(), var4);
               this.listTravaux = this.bienTravauxEnteteDao.chargerTravauxByBien(this.bien, this.bienBudgetEntete.getBiebudentDateDebut(), this.bienBudgetEntete.getBiebudentDateFin(), var4);
               this.listFactureTravaux = this.bienTravauxLigneDao.chargerDetailByBien(this.bien, this.bienBudgetEntete.getBiebudentDateDebut(), this.bienBudgetEntete.getBiebudentDateFin(), var4);
               this.utilInitHibernate.closeSession();
            }

            this.datamodelPoste.setWrappedData(this.listPoste);
            this.datamodelAppelCharges.setWrappedData(this.listAppelCharges);
            this.datamodelTravaux.setWrappedData(this.listTravaux);
            this.datamodelFactureTravaux.setWrappedData(this.listFactureTravaux);
            this.visibiliteBton = true;
            this.visibilitePoste = false;
            this.showModalPanelPoste = false;
         } else {
            this.visibiliteBton = false;
         }
      } else {
         this.visibiliteBton = false;
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.bienBudgetEntete != null) {
         if (this.bienBudgetEntete.getBiebudentEtat() == 0) {
            this.modifierBudget();
         } else {
            this.consulterBudget();
         }
      }

   }

   public void ajouterBudget() throws HibernateException, NamingException {
      this.bien = new Bien();
      this.bienBudgetEntete = new BienBudgetEntete();
      this.var_bienSyndic = 0L;
      this.calculTotalBudgetPoste();
      this.var_action = 1;
      this.var_aff_action = false;
      this.var_memo_action = this.var_action;
      this.showModalPanelPoste = false;
   }

   public void modifierBudget() {
      if (this.bienBudgetEntete != null) {
         this.calculTotalBudgetPoste();
         this.var_action = 1;
         this.var_aff_action = true;
         this.var_memo_action = this.var_action;
         this.showModalPanelPoste = false;
      }

   }

   public void consulterBudget() {
      if (this.bienBudgetEntete != null) {
         this.calculTotalBudgetPoste();
         this.var_action = 21;
         this.var_aff_action = true;
         this.var_memo_action = this.var_action;
         this.showModalPanelPoste = false;
      }

   }

   public void supprimerBudget() throws HibernateException, NamingException {
      if (this.bienBudgetEntete != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.bienBudgetEntete.getBiebudentNum();
            if (this.listPoste.size() != 0) {
               for(int var4 = 0; var4 < this.listPoste.size(); ++var4) {
                  this.bienBudgetLigne = (BienBudgetLigne)this.listPoste.get(var4);
                  this.bienBudgetLigneDao.delete(this.bienBudgetLigne, var1);
               }

               this.listPoste.clear();
               this.datamodelPoste.setWrappedData(this.listPoste);
            }

            this.bienBudgetEnteteDao.delete(this.bienBudgetEntete, var1);
            this.listBudget.remove(this.bienBudgetEntete);
            this.datamodelBudget.setWrappedData(this.listBudget);
            Espion var10 = new Espion();
            var10.setUsers(this.usersLog);
            var10.setEsptype(0);
            var10.setEspdtecreat(new Date());
            var10.setEspaction("Suppression Budget N° " + var3);
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

   public void annulerBudget() {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.visibiliteBton = false;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public void calculBien() throws HibernateException, NamingException {
      if (this.var_bienSyndic != 0L) {
         this.bien = this.bienDao.logBienId(this.var_bienSyndic, (Session)null);
         if (this.bien == null) {
            this.bien = new Bien();
         }
      }

   }

   public void validerBudget() throws HibernateException, NamingException {
      this.validerBudgetSuite();
      this.var_action = 0;
      this.var_memo_action = this.var_action;
   }

   public void validerBudgetSuite() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.var_bienSyndic != 0L) {
            this.bien = this.bienDao.logBienId(this.var_bienSyndic, var1);
            if (this.bien != null) {
               this.bienBudgetEntete.setBien(this.bien);
            }
         }

         if (this.bienBudgetEntete.getBiebudentIdCoproprietaire() != 0L) {
            this.tiers = this.tiersDao.selectTierD(this.bienBudgetEntete.getBiebudentIdCoproprietaire(), var1);
            if (this.tiers != null) {
               this.bienBudgetEntete.setBiebudentNomCoproprietaire(this.tiers.getTieraisonsocialenom());
            } else {
               this.bienBudgetEntete.setBiebudentNomCoproprietaire("");
               this.bienBudgetEntete.setBiebudentIdCoproprietaire(0L);
            }
         } else {
            this.bienBudgetEntete.setBiebudentNomCoproprietaire("");
         }

         if (this.bien != null) {
            if (this.bienBudgetEntete.getBiebudentDateDebut() == null) {
               this.bienBudgetEntete.setBiebudentDateDebut(this.exercicesVentes.getExevteDateDebut());
            }

            if (this.bienBudgetEntete.getBiebudentDateFin() == null) {
               this.bienBudgetEntete.setBiebudentDateFin(this.exercicesVentes.getExevteDateFin());
            }

            if (this.bienBudgetEntete.getBiebudentAnnee() == 0) {
               this.bienBudgetEntete.setBiebudentAnnee(this.bienBudgetEntete.getBiebudentDateDebut().getYear() + 1900);
            }

            if (this.bienBudgetEntete.getBiebudentId() != 0L) {
               this.bienBudgetEntete.setBiebudentDateModif(new Date());
               this.bienBudgetEntete.setBiebudentUserModif(this.usersLog.getUsrid());
               this.bienBudgetEntete = this.bienBudgetEnteteDao.modif(this.bienBudgetEntete, var1);
            } else {
               if (this.bienBudgetEntete.getBiebudentNum() == null || this.bienBudgetEntete.getBiebudentNum().isEmpty()) {
                  this.bienBudgetEntete.setBiebudentNum(this.calculChrono.numCompose(this.bienBudgetEntete.getBiebudentDateDebut(), this.nature, (String)null, var1));
               }

               this.bienBudgetEntete.setBiebudentDateCreat(new Date());
               this.bienBudgetEntete.setBiebudentUserCreat(this.usersLog.getUsrid());
               this.bienBudgetEntete = this.bienBudgetEnteteDao.insert(this.bienBudgetEntete, var1);
               this.listBudget.add(this.bienBudgetEntete);
               this.datamodelBudget.setWrappedData(this.listBudget);
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

   }

   public void valideDocument() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.bienBudgetEntete.getBiebudentEtat() == 0 && this.usersChrono.getUsrchrValidation() == 2) {
            this.bienBudgetEntete.setBiebudentEtat(1);
            this.bienBudgetEntete = this.bienBudgetEnteteDao.modif(this.bienBudgetEntete, var1);
            Espion var3 = new Espion();
            var3.setUsers(this.usersLog);
            var3.setEsptype(0);
            var3.setEspdtecreat(new Date());
            var3.setEspaction("Validation manuelle budget (I.) N° " + this.bienBudgetEntete.getBiebudentNum() + " du " + this.utilDate.dateToStringSQLLight(this.bienBudgetEntete.getBiebudentDateDebut()));
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
         if (this.bienBudgetEntete.getBiebudentEtat() == 1 && this.usersChrono.getUsrchrValidation() == 2) {
            this.bienBudgetEntete.setBiebudentEtat(0);
            this.bienBudgetEntete = this.bienBudgetEnteteDao.modif(this.bienBudgetEntete, var1);
            Espion var3 = new Espion();
            var3.setUsers(this.usersLog);
            var3.setEsptype(0);
            var3.setEspdtecreat(new Date());
            var3.setEspaction("Dévalidation manuelle budget (I.) N° " + this.bienBudgetEntete.getBiebudentNum() + " du " + this.utilDate.dateToStringSQLLight(this.bienBudgetEntete.getBiebudentDateDebut()));
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

   public void cloturerDocument() throws ParseException, NamingException {
      if (this.bienBudgetEntete != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            new BienBudgetEntete();
            BienBudgetEntete var3 = this.bienBudgetEntete;
            this.bienBudgetEntete = new BienBudgetEntete();
            this.bienBudgetEntete.setBiebudentDateCreat(new Date());
            Date var4 = this.utilDate.dateJourSuivant(var3.getBiebudentDateFin());
            this.bienBudgetEntete.setBiebudentDateDebut(this.utilDate.datePremierJourAnnee(var4));
            this.bienBudgetEntete.setBiebudentDateFin(this.utilDate.dateDernierJourAnnee(var4));
            this.bienBudgetEntete.setBiebudentAnnee(var4.getYear() + 1900);
            this.bienBudgetEntete.setBiebudentEtat(0);
            this.bienBudgetEntete.setBiebudentHonoraire(var3.getBiebudentHonoraire());
            this.bienBudgetEntete.setBiebudentIdCoproprietaire(var3.getBiebudentIdCoproprietaire());
            this.bienBudgetEntete.setBiebudentMode(var3.getBiebudentMode());
            this.bienBudgetEntete.setBiebudentModeleImp(var3.getBiebudentModeleImp());
            this.bienBudgetEntete.setBiebudentNomCoproprietaire(var3.getBiebudentNomCoproprietaire());
            this.bienBudgetEntete.setBiebudentNum(this.calculChrono.numCompose(this.bienBudgetEntete.getBiebudentDateDebut(), this.nature, (String)null, var1));
            this.bienBudgetEntete.setBiebudentObjet(var3.getBiebudentObjet());
            this.bienBudgetEntete.setBiebudentResteAnterieur(var3.getBiebudentTotal() - var3.getBiebudentDepenses());
            this.bienBudgetEntete.setBiebudentUserCreat(this.usersLog.getUsrid());
            this.bienBudgetEntete.setBien(var3.getBien());
            this.bienBudgetEntete = this.bienBudgetEnteteDao.insert(this.bienBudgetEntete, var1);
            var3.setBiebudentEtat(4);
            this.bienBudgetEnteteDao.modif(var3, var1);
            if (this.listPoste.size() != 0) {
               new BienBudgetLigne();

               for(int var6 = 0; var6 < this.listPoste.size(); ++var6) {
                  BienBudgetLigne var5 = (BienBudgetLigne)this.listPoste.get(var6);
                  this.bienBudgetLigne = new BienBudgetLigne();
                  this.bienBudgetLigne.setBiebudligCode(var5.getBiebudligCode());
                  this.bienBudgetLigne.setBiebudligDepenses(0.0D);
                  this.bienBudgetLigne.setBiebudligDepensesNonImpute(0.0D);
                  this.bienBudgetLigne.setBiebudligEcart(0.0D);
                  this.bienBudgetLigne.setBiebudligLibelle(var5.getBiebudligLibelle());
                  this.bienBudgetLigne.setBiebudligMontant(var5.getBiebudligMontant());
                  this.bienBudgetLigne.setBiebudligRealisation(0.0F);
                  this.bienBudgetLigne.setBiebudligResteAnterieur(0.0D);
                  this.bienBudgetLigne.setBiebudligType(var5.getBiebudligType());
                  this.bienBudgetLigne.setBienBudgetEntete(this.bienBudgetEntete);
                  this.bienBudgetLigne = this.bienBudgetLigneDao.insert(this.bienBudgetLigne, var1);
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

   }

   public void selectionPoste() {
      if (this.datamodelPoste.isRowAvailable()) {
         this.bienBudgetLigne = (BienBudgetLigne)this.datamodelPoste.getRowData();
         this.visibilitePoste = true;
      }

   }

   public void ajouterPoste() {
      if (this.bien != null && this.bienBudgetEntete != null) {
         this.bienBudgetLigne = new BienBudgetLigne();
         this.showModalPanelPoste = true;
      }

   }

   public void modifierPoste() {
      if (this.bienBudgetLigne != null) {
         this.showModalPanelPoste = true;
      }

   }

   public void supprimerPoste() {
      if (this.bienBudgetLigne != null) {
         this.calculTotalBudgetPoste();
         this.showModalPanelPoste = true;
      }

   }

   public void annulerPoste() {
      this.showModalPanelPoste = false;
   }

   public void validerPoste() throws HibernateException, NamingException {
      if (this.bienBudgetEntete.getBiebudentId() == 0L) {
         this.validerBudgetSuite();
      }

      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.bienBudgetLigne.getBiebudligId() == 0L) {
            this.bienBudgetLigne.setBienBudgetEntete(this.bienBudgetEntete);
            this.bienBudgetLigne = this.bienBudgetLigneDao.insert(this.bienBudgetLigne, var1);
            this.listPoste.add(this.bienBudgetLigne);
            this.datamodelPoste.setWrappedData(this.listPoste);
         } else {
            this.bienBudgetLigne = this.bienBudgetLigneDao.modif(this.bienBudgetLigne, var1);
         }

         double var3 = this.bienBudgetLigne.getBiebudligMontant() - this.bienBudgetLigne.getBiebudligDepenses();
         this.bienBudgetLigne.setBiebudligEcart(var3);
         float var5 = (float)this.utilNombre.myRound(this.bienBudgetLigne.getBiebudligDepenses() / this.bienBudgetLigne.getBiebudligMontant() * 100.0D, 2);
         this.bienBudgetLigne.setBiebudligRealisation(var5);
         this.calculTotalBudgetPoste();
         this.bienBudgetEntete.setBiebudentTotal(this.var_budget);
         this.bienBudgetEntete.setBiebudentDepenses(this.var_depenses);
         this.bienBudgetEntete.setBiebudentEcart(this.var_ecart);
         this.bienBudgetEntete.setBiebudentRealisation(this.var_pourcentage);
         this.bienBudgetEntete = this.bienBudgetEnteteDao.modif(this.bienBudgetEntete, var1);
         var2.commit();
      } catch (HibernateException var9) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var9;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.calculTotalBudgetPoste();
      this.showModalPanelPoste = false;
   }

   public void calculTotalBudgetPoste() {
      double var1 = 0.0D;
      if (this.listFactureTravaux.size() != 0) {
         for(int var3 = 0; var3 < this.listFactureTravaux.size(); ++var3) {
            int var4 = ((BienTravauxLigne)this.listFactureTravaux.get(var3)).getBietraligDateFacture().getYear() + 1900;
            if (var4 == this.bienBudgetEntete.getBiebudentAnnee()) {
               var1 += ((BienTravauxLigne)this.listFactureTravaux.get(var3)).getBietraligTtc();
            }
         }
      }

      double var12 = 0.0D;
      double var5 = 0.0D;
      double var7 = 0.0D;
      double var9 = 0.0D;
      if (this.listPoste.size() != 0) {
         for(int var11 = 0; var11 < this.listPoste.size(); ++var11) {
            var12 += ((BienBudgetLigne)this.listPoste.get(var11)).getBiebudligResteAnterieur();
            var5 += ((BienBudgetLigne)this.listPoste.get(var11)).getBiebudligMontant();
            var7 += ((BienBudgetLigne)this.listPoste.get(var11)).getBiebudligDepenses();
            var9 += ((BienBudgetLigne)this.listPoste.get(var11)).getBiebudligDepensesNonImpute();
         }
      }

      this.var_reliquat = var12;
      this.var_budget = var5;
      this.var_depenses = var7;
      this.var_depensesNomImpute = var9;
      this.var_ecart = var5 - var7 - var9;
      this.var_pourcentage = (float)this.utilNombre.myRound(var7 / var5 * 100.0D, 2);
   }

   public void reclculerBudgets() throws HibernateException, NamingException {
      if (this.listBudget.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.listBudget.size(); ++var3) {
               this.bienBudgetEntete = (BienBudgetEntete)this.listBudget.get(var3);
               this.bien = this.bienBudgetEntete.getBien();
               this.var_bienSyndic = this.bien.getBieId();
               this.listPoste.clear();
               this.listFactureTravaux.clear();
               if (this.bien != null) {
                  this.listPoste = this.bienBudgetLigneDao.chargerBudgetByBien(this.bienBudgetEntete, var1);
                  this.listFactureTravaux = this.bienTravauxLigneDao.chargerDetailByBien(this.bien, this.bienBudgetEntete.getBiebudentDateDebut(), this.bienBudgetEntete.getBiebudentDateFin(), var1);
                  this.calculBudgetRealise(var1);
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

      this.visibiliteBton = false;
   }

   public void calculBudgetRealise(Session var1) throws HibernateException, NamingException {
      if (this.bienBudgetEntete != null) {
         double var2 = 0.0D;
         double var4 = 0.0D;
         if (this.listPoste.size() != 0) {
            for(int var6 = 0; var6 < this.listPoste.size(); ++var6) {
               this.bienBudgetLigne = (BienBudgetLigne)this.listPoste.get(var6);
               String var7 = this.bienBudgetLigne.getBiebudligCode();
               double var8 = 0.0D;
               double var10 = 0.0D;
               if (this.listFactureTravaux.size() != 0) {
                  for(int var12 = 0; var12 < this.listFactureTravaux.size(); ++var12) {
                     int var13 = ((BienTravauxLigne)this.listFactureTravaux.get(var12)).getBietraligDateFacture().getYear() + 1900;
                     if (var13 == this.bienBudgetEntete.getBiebudentAnnee()) {
                        if (var7 != null && !var7.isEmpty()) {
                           if (((BienTravauxLigne)this.listFactureTravaux.get(var12)).getBietraligPoste() != null && !((BienTravauxLigne)this.listFactureTravaux.get(var12)).getBietraligPoste().isEmpty() && ((BienTravauxLigne)this.listFactureTravaux.get(var12)).getBietraligPoste().equals(var7)) {
                              var2 += ((BienTravauxLigne)this.listFactureTravaux.get(var12)).getBietraligTtc();
                              var8 += ((BienTravauxLigne)this.listFactureTravaux.get(var12)).getBietraligTtc();
                           }
                        } else if (((BienTravauxLigne)this.listFactureTravaux.get(var12)).getBietraligPoste() == null || ((BienTravauxLigne)this.listFactureTravaux.get(var12)).getBietraligPoste().isEmpty()) {
                           var4 += ((BienTravauxLigne)this.listFactureTravaux.get(var12)).getBietraligTtc();
                           var10 += ((BienTravauxLigne)this.listFactureTravaux.get(var12)).getBietraligTtc();
                        }
                     }
                  }
               }

               this.bienBudgetLigne.setBiebudligDepenses(var8);
               this.bienBudgetLigne.setBiebudligDepensesNonImpute(var10);
               this.bienBudgetLigne.setBiebudligEcart(this.bienBudgetLigne.getBiebudligMontant() - this.bienBudgetLigne.getBiebudligDepenses() - this.bienBudgetLigne.getBiebudligDepensesNonImpute());
               float var15 = (float)this.utilNombre.myRound(this.bienBudgetLigne.getBiebudligDepenses() / this.bienBudgetLigne.getBiebudligMontant() * 100.0D, 2);
               this.bienBudgetLigne.setBiebudligRealisation(var15);
               this.bienBudgetLigne = this.bienBudgetLigneDao.modif(this.bienBudgetLigne, var1);
            }
         }

         this.bienBudgetEntete = this.bienBudgetEnteteDao.pourParapheur(this.bienBudgetEntete.getBiebudentId(), var1);
         if (this.bienBudgetEntete != null) {
            this.bienBudgetEntete.setBiebudentDepenses(var2);
            this.bienBudgetEntete.setBiebudentDepensesNonImpute(var4);
            this.bienBudgetEntete.setBiebudentEcart(this.bienBudgetEntete.getBiebudentTotal() - this.bienBudgetEntete.getBiebudentDepenses() - this.bienBudgetEntete.getBiebudentDepensesNonImpute());
            float var14 = (float)this.utilNombre.myRound(this.bienBudgetEntete.getBiebudentDepenses() / this.bienBudgetEntete.getBiebudentTotal() * 100.0D, 2);
            this.bienBudgetEntete.setBiebudentRealisation(var14);
            this.bienBudgetEntete = this.bienBudgetEnteteDao.modif(this.bienBudgetEntete, var1);
         }
      }

   }

   public String calculeCheminRapport(String var1, int var2) {
      String var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "documentSyndic" + File.separator + "budget" + File.separator;
      return var3;
   }

   public String calculeCheminSousRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "sous_rapport" + File.separator;
      return var2;
   }

   public String calculeImageFond(String var1) throws HibernateException, NamingException {
      String var2 = "";
      File var3 = new File(this.calculeCheminSousRapport(var1) + "formatBudget.jpg");
      if (var3.exists()) {
         var2 = "formatBudget.jpg";
      }

      return var2;
   }

   public JRBeanCollectionDataSource calculeImpressionCommun(String var1) throws IOException, HibernateException, NamingException, ParseException {
      this.montant_lettre = this.utilNombre.begin(this.bienBudgetEntete.getBiebudentTotal(), this.structureLog.getStrdevise());
      JRBeanCollectionDataSource var2 = null;
      if (var1.startsWith("DetailDepenses")) {
         this.filtre = "Etat par postes - Exercice " + this.exercicesVentes.getExevteId();
         new ArrayList();
         Date var4 = null;
         Date var5 = null;
         if (this.periode == 0) {
            var4 = this.bienBudgetEntete.getBiebudentDateDebut();
            var5 = this.bienBudgetEntete.getBiebudentDateFin();
         } else if (this.periode == 1) {
            var4 = this.utilDate.stringToDateSQLLight(this.bienBudgetEntete.getBiebudentDateFin().getYear() + 1900 + "-01-01");
            var5 = this.utilDate.stringToDateSQLLight(this.bienBudgetEntete.getBiebudentDateFin().getYear() + 1900 + "-03-31");
            this.filtre = this.filtre + " - 1er Trimestre";
         } else if (this.periode == 2) {
            var4 = this.utilDate.stringToDateSQLLight(this.bienBudgetEntete.getBiebudentDateFin().getYear() + 1900 + "-04-01");
            var5 = this.utilDate.stringToDateSQLLight(this.bienBudgetEntete.getBiebudentDateFin().getYear() + 1900 + "-06-30");
            this.filtre = this.filtre + " - 2eme Trimestre";
         } else if (this.periode == 3) {
            var4 = this.utilDate.stringToDateSQLLight(this.bienBudgetEntete.getBiebudentDateFin().getYear() + 1900 + "-07-01");
            var5 = this.utilDate.stringToDateSQLLight(this.bienBudgetEntete.getBiebudentDateFin().getYear() + 1900 + "-09-30");
            this.filtre = this.filtre + " - 3eme Trimestre";
         } else if (this.periode == 4) {
            var4 = this.utilDate.stringToDateSQLLight(this.bienBudgetEntete.getBiebudentDateFin().getYear() + 1900 + "-10-01");
            var5 = this.utilDate.stringToDateSQLLight(this.bienBudgetEntete.getBiebudentDateFin().getYear() + 1900 + "-12-31");
            this.filtre = this.filtre + " - 4eme Trimestre";
         }

         List var3 = this.bienTravauxLigneDao.chargerDetailByBien(this.bienBudgetEntete.getBien(), var4, var5, (Session)null);
         if (var3.size() != 0) {
            for(int var6 = 0; var6 < var3.size(); ++var6) {
               this.bienTravauxLigne = (BienTravauxLigne)var3.get(var6);

               for(int var7 = 0; var7 < this.listPoste.size(); ++var7) {
                  if (((BienBudgetLigne)this.listPoste.get(var7)).getBiebudligCode().equals(this.bienTravauxLigne.getBietraligPoste())) {
                     this.bienTravauxLigne.setNomPoste(((BienBudgetLigne)this.listPoste.get(var7)).getBiebudligLibelle());
                     if (this.periode == 0) {
                        this.bienTravauxLigne.setMontantPoste(((BienBudgetLigne)this.listPoste.get(var7)).getBiebudligMontant());
                     } else if (this.periode == 1) {
                        this.bienTravauxLigne.setMontantPoste(((BienBudgetLigne)this.listPoste.get(var7)).getBiebudligMontant());
                     } else if (this.periode == 2) {
                        this.bienTravauxLigne.setMontantPoste(((BienBudgetLigne)this.listPoste.get(var7)).getBiebudligMontant());
                     } else if (this.periode == 3) {
                        this.bienTravauxLigne.setMontantPoste(((BienBudgetLigne)this.listPoste.get(var7)).getBiebudligMontant());
                     } else if (this.periode == 4) {
                        this.bienTravauxLigne.setMontantPoste(((BienBudgetLigne)this.listPoste.get(var7)).getBiebudligMontant());
                     }
                     break;
                  }
               }
            }
         }

         var2 = new JRBeanCollectionDataSource(var3);
      } else {
         ArrayList var15;
         if (!var1.equals("DetailProprietaires") && !var1.equals("RapportProprietaires")) {
            if (var1.equals("BudgetProprietaires")) {
               this.filtre = "Budgets par propriétaires - Exercice " + this.exercicesVentes.getExevteId();
               var15 = new ArrayList();
               if (this.bienBudgetEntete != null) {
                  Session var17 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
                  long var18 = this.bienBudgetEntete.getBien().getBieId();
                  ArrayList var19 = new ArrayList();
                  new ArrayList();
                  List var8 = this.bienDao.chargeBienDetail(var18, var17);
                  int var10;
                  if (var8.size() != 0) {
                     new Bien();

                     for(var10 = 0; var10 < var8.size(); ++var10) {
                        Bien var9 = (Bien)var8.get(var10);
                        var9.setNumlot(var9.getBieNum());
                        var19.add(var9);
                     }
                  }

                  if (var19.size() != 0) {
                     int var20 = 0;

                     for(var10 = 0; var10 < var19.size(); ++var10) {
                        var20 += ((Bien)var19.get(var10)).getBieMillieme();
                     }

                     double var11 = this.bienBudgetEntete.getBiebudentTotal() / (double)var20;
                     new Bien();

                     for(int var14 = 0; var14 < var19.size(); ++var14) {
                        Bien var13 = (Bien)var19.get(var14);
                        var13.setPu(var11);
                        var13.setPtTtc((double)var13.getBieMillieme() * var11);
                        var13.setPtHt(this.bienBudgetEntete.getBiebudentTotal());
                        var15.add(var13);
                     }
                  }

                  this.utilInitHibernate.closeSession();
               }

               var2 = new JRBeanCollectionDataSource(var15);
            } else {
               this.filtre = "Exercice " + this.exercicesVentes.getExevteId();
               var2 = new JRBeanCollectionDataSource(this.listPoste);
            }
         } else {
            this.filtre = "Etat des propriétaires - Exercice " + this.exercicesVentes.getExevteId();
            var15 = new ArrayList();
            if (this.listAppelCharges.size() != 0) {
               for(int var16 = 0; var16 < this.listAppelCharges.size(); ++var16) {
                  if (((AppelCharge)this.listAppelCharges.get(var16)).getAppchaSolde() == 0) {
                     var15.add(this.listAppelCharges.get(var16));
                  }
               }
            }

            var2 = new JRBeanCollectionDataSource(var15);
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
         if (this.bienBudgetEntete.getBiebudentDateImp() != null) {
            var2 = true;
         }

         this.bienBudgetEntete.setBiebudentDateImp(new Date());
         this.bienBudgetEntete.setBiebudentModeleImp(var1);
         this.bienBudgetEntete = this.bienBudgetEnteteDao.modif(this.bienBudgetEntete, var3);
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
            var1.setjRBeanCollectionDataSource(this.calculeImpressionCommun(var3));
            var1.setRapport(var3);
            var1.setEntete("Budget " + this.bienBudgetEntete.getBien().getBieNum() + " " + this.bienBudgetEntete.getBien().getBieNom());
            var1.setPageGarde((String)null);
            if (this.bien.getBieListeLocaux() != null && !this.bien.getBieListeLocaux().isEmpty()) {
               this.chargerBlocs();
               if (this.lesBlocsItems.size() != 0) {
                  for(int var12 = 0; var12 < this.lesBlocsItems.size(); ++var12) {
                     if (var12 == 0) {
                        var1.setAnnexe1(((SelectItem)this.lesBlocsItems.get(var12)).getValue().toString());
                     } else if (var12 == 1) {
                        var1.setAnnexe2(((SelectItem)this.lesBlocsItems.get(var12)).getValue().toString());
                     }
                  }
               }
            } else {
               var1.setAnnexe1("");
               var1.setAnnexe2("");
            }

            var1.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid(), this.nature));
            var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid()));
            var1.setDuplicata("" + var11);
            var1.setInfoOrigineDoc((String)null);
            var1.setNbDecQte(this.optionsVentes.getNbDecQte());
            var1.setNbDecPu(this.optionsVentes.getNbDecPu());
            var1.setMontant_lettre(this.montant_lettre);
            var1.setFormat(var5);
            var1.setFiltre(this.filtre);
            var1.setEmetteur(var6);
            var1.setDestinataire(var7);
            var1.setDestinataireCC(var8);
            var1.setDestinataireCCI(var9);
            var1.setCorpsMail(var10);
            var1.setIdResponsable(0L);
            var1.setIdCommercial(0L);
            var1.setTiersSelectionne((Tiers)null);
            var1.setNumDoc(this.bienBudgetEntete.getBiebudentNum());
            var1.setNature(this.nature);
            var1.setId_doc(this.bienBudgetEntete.getBiebudentId());
            var1.setPlafond(this.bienBudgetEntete.getBiebudentTotal());
            var1.setParc((Parc)null);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      } else if (var2 == 1 && var4 != null && !var4.isEmpty()) {
         var1.setRapport(var4);
         var1.setEntete("Impression de la liste des budgets");
         var1.setTotauxHt("");
         var1.setTotauxTaxe("");
         var1.setTotauxTtc("");
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "listeSyndic" + File.separator + "budget" + File.separator);
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
         JRBeanCollectionDataSource var13 = new JRBeanCollectionDataSource(this.listBudget);
         var1.setjRBeanCollectionDataSource(var13);
         var1.setBaseLog(this.baseLog);
         var1.setStructureLog(this.structureLog);
         var1.setUsersLog(this.usersLog);
         var1.imprimeRapport();
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

   public DataModel getDatamodelBudget() {
      return this.datamodelBudget;
   }

   public void setDatamodelBudget(DataModel var1) {
      this.datamodelBudget = var1;
   }

   public DataModel getDatamodelPoste() {
      return this.datamodelPoste;
   }

   public void setDatamodelPoste(DataModel var1) {
      this.datamodelPoste = var1;
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

   public boolean isVar_valide_doc() {
      return this.var_valide_doc;
   }

   public void setVar_valide_doc(boolean var1) {
      this.var_valide_doc = var1;
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

   public int getInpEtat() {
      return this.inpEtat;
   }

   public void setInpEtat(int var1) {
      this.inpEtat = var1;
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

   public List getMesBiensSyndics() {
      return this.mesBiensSyndics;
   }

   public void setMesBiensSyndics(List var1) {
      this.mesBiensSyndics = var1;
   }

   public long getVar_bienSyndic() {
      return this.var_bienSyndic;
   }

   public void setVar_bienSyndic(long var1) {
      this.var_bienSyndic = var1;
   }

   public BienBudgetEntete getBienBudgetEntete() {
      return this.bienBudgetEntete;
   }

   public void setBienBudgetEntete(BienBudgetEntete var1) {
      this.bienBudgetEntete = var1;
   }

   public boolean isShowModalPanelPoste() {
      return this.showModalPanelPoste;
   }

   public void setShowModalPanelPoste(boolean var1) {
      this.showModalPanelPoste = var1;
   }

   public boolean isVisibilitePoste() {
      return this.visibilitePoste;
   }

   public void setVisibilitePoste(boolean var1) {
      this.visibilitePoste = var1;
   }

   public double getVar_budget() {
      return this.var_budget;
   }

   public void setVar_budget(double var1) {
      this.var_budget = var1;
   }

   public double getVar_depenses() {
      return this.var_depenses;
   }

   public void setVar_depenses(double var1) {
      this.var_depenses = var1;
   }

   public double getVar_ecart() {
      return this.var_ecart;
   }

   public void setVar_ecart(double var1) {
      this.var_ecart = var1;
   }

   public float getVar_pourcentage() {
      return this.var_pourcentage;
   }

   public void setVar_pourcentage(float var1) {
      this.var_pourcentage = var1;
   }

   public BienBudgetLigne getBienBudgetLigne() {
      return this.bienBudgetLigne;
   }

   public void setBienBudgetLigne(BienBudgetLigne var1) {
      this.bienBudgetLigne = var1;
   }

   public DataModel getDatamodelAppelCharges() {
      return this.datamodelAppelCharges;
   }

   public void setDatamodelAppelCharges(DataModel var1) {
      this.datamodelAppelCharges = var1;
   }

   public DataModel getDatamodelFactureTravaux() {
      return this.datamodelFactureTravaux;
   }

   public void setDatamodelFactureTravaux(DataModel var1) {
      this.datamodelFactureTravaux = var1;
   }

   public DataModel getDatamodelTravaux() {
      return this.datamodelTravaux;
   }

   public void setDatamodelTravaux(DataModel var1) {
      this.datamodelTravaux = var1;
   }

   public double getVar_reliquat() {
      return this.var_reliquat;
   }

   public void setVar_reliquat(double var1) {
      this.var_reliquat = var1;
   }

   public double getVar_depensesNomImpute() {
      return this.var_depensesNomImpute;
   }

   public void setVar_depensesNomImpute(double var1) {
      this.var_depensesNomImpute = var1;
   }

   public int getInpMode() {
      return this.inpMode;
   }

   public void setInpMode(int var1) {
      this.inpMode = var1;
   }

   public List getMesCoproprietaireItems() {
      return this.mesCoproprietaireItems;
   }

   public void setMesCoproprietaireItems(List var1) {
      this.mesCoproprietaireItems = var1;
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
