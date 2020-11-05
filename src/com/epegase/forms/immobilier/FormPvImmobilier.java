package com.epegase.forms.immobilier;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.Bien;
import com.epegase.systeme.classe.BienPv;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.dao.BienDao;
import com.epegase.systeme.dao.BienPvDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilParapheur;
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

public class FormPvImmobilier implements Serializable {
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
   private transient DataModel datamodelPv = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private List listPv = new ArrayList();
   private BienPv bienPv = new BienPv();
   private BienPvDao bienPvDao;
   private Bien bien;
   private BienDao bienDao;
   private boolean visibiliteBton = false;
   private Tiers proprietaire;
   private TiersDao tiersDao;
   private boolean var_aff_detail_proprietaire = false;
   private boolean var_aff_detail_local = false;
   private boolean var_valide_doc = false;
   private boolean showModalPanelValidationDocument = false;
   private boolean visibleOnglet = false;
   private List mesBiensItems = new ArrayList();
   private long var_idImmeuble;
   private String var_serie;
   private Users responsable;
   private long var_nom_commercial;
   private List mesSerieUserItem;
   private List mesUsersItem = new ArrayList();
   private long var_nom_responsable;
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
   private int var_nb_ligne = 0;
   private String inpSerie = "100";
   private int inpEtat = 1;
   private String periode = "100";
   private String inpNum = "";
   private String inpCat = "";
   private String inpClient = "";
   private String inpResponsable = "";
   private String inpDossier = "100";
   private Date inpDu = null;
   private Date inpAu = null;
   private boolean var_more_search = false;
   private boolean showModalPanelPrint = false;
   private String devisePrint;
   private float tauxPrint;

   public FormPvImmobilier() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.utilParapheur = new UtilParapheur(this.utilInitHibernate, this.structureLog, this.baseLog, this.usersLog);
   }

   public void InstancesDaoUtilses() {
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.bienPvDao = new BienPvDao(this.baseLog, this.utilInitHibernate);
      this.bienDao = new BienDao(this.baseLog, this.utilInitHibernate);
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
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
      if (this.habilitation != null) {
         this.existParapheur = true;
      } else {
         this.existParapheur = false;
      }

      this.chargerElementBase(var1);
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
      }

   }

   public void executerRequete() throws IOException, HibernateException, NamingException, ParseException {
      this.chargeListeDetail((Session)null);
   }

   public void chargeListeDetail(Session var1) throws HibernateException, NamingException, ParseException {
      this.listPv.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      double var2 = 0.0D;
      double var4 = 0.0D;
      double var6 = 0.0D;
      double var8 = 0.0D;
      this.var_nb_ligne = 0;
      String var10 = "";
      String var11 = "";
      if (this.var_more_search) {
         if (this.inpDu != null) {
            var10 = this.utilDate.dateToStringSQLLight(this.inpDu);
         }

         if (this.inpAu != null) {
            var11 = this.utilDate.dateToStringSQLLight(this.inpAu);
         }
      } else {
         var10 = null;
         var11 = null;
      }

      if (this.inpNum != null && !this.inpNum.isEmpty()) {
         this.inpEtat = 100;
      }

      if (this.inpEtat != 50) {
         this.listPv = this.bienPvDao.recherche(var1, this.exercicesVentes.getExevteId(), this.getInpNum(), this.getInpClient(), this.getInpEtat(), this.getInpSerie(), "100", this.getPeriode(), "100", this.usersLog.getUsrid(), this.usersLog.getUsrVentes(), "", this.getInpResponsable(), "", "100", var10, var11);
      }

      if (this.listPv.size() > 0) {
         this.var_nb_ligne = this.listPv.size();
      }

      this.datamodelPv.setWrappedData(this.listPv);
      this.visibiliteBton = false;
   }

   public void selectionPv() throws HibernateException, NamingException, ParseException {
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
            this.bienPv = (BienPv)var1.get(0);
            this.var_date = this.bienPv.getBiepvDate();
            if (this.bienPv.getBiepvDate().getHours() <= 9) {
               this.var_heure = "0" + this.bienPv.getBiepvDate().getHours();
            } else {
               this.var_heure = "" + this.bienPv.getBiepvDate().getHours();
            }

            if (this.bienPv.getBiepvDate().getMinutes() <= 9) {
               this.var_minute = "0" + this.bienPv.getBiepvDate().getMinutes();
            } else {
               this.var_minute = "" + this.bienPv.getBiepvDate().getMinutes();
            }

            if (this.bienPv.getBiepvDate().getSeconds() <= 9) {
               this.var_seconde = "0" + this.bienPv.getBiepvDate().getSeconds();
            } else {
               this.var_seconde = "" + this.bienPv.getBiepvDate().getSeconds();
            }

            this.var_serie = this.bienPv.getBiepvSerie();
            Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "SyndicPv");
            this.bien = this.bienDao.logBienNum(this.bienPv.getBiepvBien(), var4);
            if (this.mesUsersItem == null || this.mesUsersItem.size() == 0) {
               this.mesUsersItem.add(new SelectItem(0, ""));
               this.var_nom_responsable = 0L;
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

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.bienPv != null) {
         if (this.bienPv.getBiepvEtat() == 0) {
            this.modifierPv();
         } else {
            this.consulterPv();
         }
      }

   }

   public void chargerElementBase(Session var1) throws HibernateException, NamingException, ParseException {
      this.mesBiensItems.clear();
      new ArrayList();
      List var2 = this.bienDao.chargeBien(1, 9, var1);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            if (((Bien)var2.get(var3)).getBieType() == 2) {
               this.mesBiensItems.add(new SelectItem(((Bien)var2.get(var3)).getBieId(), ((Bien)var2.get(var3)).getBieNum() + ":" + ((Bien)var2.get(var3)).getBieNom()));
            }
         }
      }

   }

   public void ajouterPv() {
      this.bienPv = new BienPv();
      this.var_date = new Date();
      this.var_action = 1;
      this.var_aff_detail_proprietaire = false;
      this.var_aff_action = false;
      this.visibleOnglet = false;
      this.var_memo_action = this.var_action;
   }

   public void modifierPv() {
      if (this.bienPv != null) {
         this.var_action = 2;
         this.var_aff_detail_proprietaire = true;
         this.var_aff_action = true;
         this.visibleOnglet = true;
         this.var_memo_action = this.var_action;
      }

   }

   public void consulterPv() {
      if (this.bienPv != null) {
         this.var_action = 3;
         this.var_aff_detail_proprietaire = true;
         this.var_aff_action = true;
         this.visibleOnglet = true;
         this.var_memo_action = this.var_action;
      }

   }

   public void validerPv() throws HibernateException, NamingException {
      if (this.bienPv != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SyndicPv");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.bienPv.getBiepvEtat() == 0 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
               this.bienPv.setBiepvEtat(1);
               this.bienPv = this.bienPvDao.modif(this.bienPv, var1);
               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Validation manuelle P.V. (I.) N° " + this.bienPv.getBiepvNum() + " du " + this.utilDate.dateToStringSQLLight(this.bienPv.getBiepvDate()));
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

   public void deValiderPv() throws HibernateException, NamingException {
      if (this.bienPv != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SyndicPv");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.bienPv.getBiepvEtat() == 1 && this.habilitation == null) {
               this.bienPv.setBiepvEtat(0);
               this.bienPv.setBiepvDateImp((Date)null);
               this.bienPv = this.bienPvDao.modif(this.bienPv, var1);
               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Dévalidation manuelle P.V. (I.) N° " + this.bienPv.getBiepvNum() + " du " + this.utilDate.dateToStringSQLLight(this.bienPv.getBiepvDate()));
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

   public void supprimerPv() throws HibernateException, NamingException {
      if (this.bienPv != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SyndicPv");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.bienPv.getBiepvNum();
            this.bienPvDao.modif(this.bienPv, var1);
            this.listPv.remove(this.bienPv);
            this.datamodelPv.setWrappedData(this.listPv);
            Espion var4 = new Espion();
            var4.setUsers(this.usersLog);
            var4.setEsptype(0);
            var4.setEspdtecreat(new Date());
            var4.setEspaction("Suppression PV N° " + var3);
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

   public void annulerPv() {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.visibleOnglet = false;
      this.visibiliteBton = false;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public void savePv() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SyndicPv");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.var_idImmeuble != 0L) {
            this.bien = this.bienDao.logBienId(this.var_idImmeuble, var1);
            if (this.bien != null) {
               this.bienPv.getBiepvBien();
               this.bienPv.setBiepvCivilProprietaire(this.bien.getTiers().getTiecivilite());
               this.bienPv.setBiepvIdProprietaire(this.bien.getTiers().getTieid());
               this.bienPv.setBiepvNomProprietaire(this.bien.getTiers().getTieraisonsocialenom());
               this.bienPv.setBiepvProprietaire(this.bien.getTiers().getTieraisonsocialenom());
            } else {
               this.bienPv.setBiepvCivilProprietaire("");
               this.bienPv.setBiepvIdProprietaire(0L);
               this.bienPv.setBiepvNomProprietaire("");
               this.bienPv.setBiepvProprietaire("");
            }
         } else {
            this.bien = new Bien();
            this.bienPv.setBiepvCivilProprietaire("");
            this.bienPv.setBiepvIdProprietaire(0L);
            this.bienPv.setBiepvNomProprietaire("");
            this.bienPv.setBiepvProprietaire("");
         }

         if (this.bienPv.getBiepvId() == 0L) {
            if (this.bienPv.getBiepvNum() == null || this.bienPv.getBiepvNum().isEmpty()) {
               this.bienPv.setBiepvNum(this.calculChrono.numCompose(this.bienPv.getBiepvDate(), this.nature, this.bienPv.getBiepvSerie(), var1));
            }

            this.bienPv.setUsers(this.usersLog);
            this.bienPv.setExerciceventes(this.exercicesVentes);
            this.bienPv.setBiepvDateCreat(new Date());
            this.bienPv.setBiepvIdCreateur(this.usersLog.getUsrid());
            this.bienPv = this.bienPvDao.insert(this.bienPv, var1);
            this.listPv.add(this.bienPv);
            this.datamodelPv.setWrappedData(this.listPv);
         } else {
            this.bienPv.setBiepvDateModif(new Date());
            this.bienPv.setBiepvIdModif(this.usersLog.getUsrid());
            this.bienPv = this.bienPvDao.modif(this.bienPv, var1);
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

   public String calculeCheminRapport(String var1, int var2) {
      String var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "documentSyndic" + File.separator + "preparation_pv" + File.separator;
      return var3;
   }

   public String calculeCheminSousRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "sous_rapport" + File.separator;
      return var2;
   }

   public String calculeImageFond(String var1) throws HibernateException, NamingException {
      String var2 = "";
      File var3 = new File(this.calculeCheminSousRapport(var1) + "formatPv.jpg");
      if (var3.exists()) {
         var2 = "formatPv.jpg";
      }

      return var2;
   }

   public boolean majDateImpression(String var1) throws HibernateException, NamingException {
      boolean var2 = false;
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "SyndicPv");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         if (this.bienPv.getBiepvDateImp() != null) {
            var2 = true;
         }

         this.bienPv.setBiepvDateImp(new Date());
         if (this.bienPv.getBiepvEtat() == 0 && this.bienPv.getBiepvEtatVal() == 0 && this.usersChrono.getUsrchrValidation() == 1) {
            this.bienPv.setBiepvEtat(1);
         }

         this.bienPv.setBiepvModeleImp(var1);
         this.bienPv = this.bienPvDao.modif(this.bienPv, var3);
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
            ArrayList var12 = new ArrayList();
            JRBeanCollectionDataSource var13 = new JRBeanCollectionDataSource(var12);
            var1.setjRBeanCollectionDataSource(var13);
            var1.setRapport(var3);
            var1.setEntete("Impression PV");
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
            var1.setTaux(1.0F);
            var1.setMontant_lettre("");
            var1.setFormat(var5);
            var1.setEmetteur(var6);
            var1.setDestinataire(var7);
            var1.setDestinataireCC(var8);
            var1.setDestinataireCCI(var9);
            var1.setCorpsMail(var10);
            var1.setIdResponsable(this.bienPv.getBiepvIdResponsable());
            var1.setIdCommercial(this.bienPv.getBiepvIdCommercial());
            var1.setTiersSelectionne((Tiers)null);
            var1.setNumDoc(this.bienPv.getBiepvNum());
            var1.setNature(this.nature);
            var1.setId_doc(this.bienPv.getBiepvId());
            var1.setParc((Parc)null);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      } else if (var2 == 1 && var4 != null && !var4.isEmpty()) {
         var1.setRapport(var4);
         var1.setEntete("Impression de la liste des PV");
         var1.setTotauxHt("");
         var1.setTotauxTaxe("");
         var1.setTotauxTtc("");
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "listeSyndic" + File.separator + "preparation_pv" + File.separator);
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
         JRBeanCollectionDataSource var14 = new JRBeanCollectionDataSource(this.listPv);
         var1.setjRBeanCollectionDataSource(var14);
         var1.setBaseLog(this.baseLog);
         var1.setStructureLog(this.structureLog);
         var1.setUsersLog(this.usersLog);
         var1.imprimeRapport();
      }

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

   public String getInpCat() {
      return this.inpCat;
   }

   public void setInpCat(String var1) {
      this.inpCat = var1;
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

   public boolean isShowModalPanelValidationDocument() {
      return this.showModalPanelValidationDocument;
   }

   public void setShowModalPanelValidationDocument(boolean var1) {
      this.showModalPanelValidationDocument = var1;
   }

   public boolean isVisibleOnglet() {
      return this.visibleOnglet;
   }

   public void setVisibleOnglet(boolean var1) {
      this.visibleOnglet = var1;
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

   public UtilParapheur getUtilParapheur() {
      return this.utilParapheur;
   }

   public void setUtilParapheur(UtilParapheur var1) {
      this.utilParapheur = var1;
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

   public BienPv getBienPv() {
      return this.bienPv;
   }

   public void setBienPv(BienPv var1) {
      this.bienPv = var1;
   }

   public DataModel getDatamodelPv() {
      return this.datamodelPv;
   }

   public void setDatamodelPv(DataModel var1) {
      this.datamodelPv = var1;
   }

   public List getMesBiensItems() {
      return this.mesBiensItems;
   }

   public void setMesBiensItems(List var1) {
      this.mesBiensItems = var1;
   }

   public long getVar_idImmeuble() {
      return this.var_idImmeuble;
   }

   public void setVar_idImmeuble(long var1) {
      this.var_idImmeuble = var1;
   }

   public String getVar_serie() {
      return this.var_serie;
   }

   public void setVar_serie(String var1) {
      this.var_serie = var1;
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
