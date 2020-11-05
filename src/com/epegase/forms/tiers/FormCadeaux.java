package com.epegase.forms.tiers;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.Cadeaux;
import com.epegase.systeme.classe.Contacts;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsDepot;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Unite;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.EtatDocument;
import com.epegase.systeme.dao.CadeauxDao;
import com.epegase.systeme.dao.ContactDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.ProduitsAchsDao;
import com.epegase.systeme.dao.ProduitsDepotDao;
import com.epegase.systeme.dao.UniteDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.util.CalculStock;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.LireLesoptionsVentes;
import com.epegase.systeme.xml.ObjetLigneOnglet;
import com.epegase.systeme.xml.OptionTiers;
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

public class FormCadeaux implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private FormRecherche formRecherche;
   private int var_action = 0;
   private int var_memo_action = 0;
   private String pageIndex;
   private int nature;
   private List mesOnglets;
   private EspionDao espionDao;
   private int var_nb_max = 100;
   private UtilDate utilDate = new UtilDate();
   private UtilNombre utilNombre = new UtilNombre();
   private int var_option_parc;
   private boolean showModalPanelAnnuler = false;
   private OptionTiers optionTiers;
   private List mesPeriodesItems = new ArrayList();
   private EtatDocument etatDocument = new EtatDocument();
   private boolean valide_doc = false;
   private transient DataModel datamodelCadeaux = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private List listCadeaux = new ArrayList();
   private Cadeaux cadeaux = new Cadeaux();
   private CadeauxDao cadeauxDao;
   private boolean visibiliteBton = false;
   private boolean var_aff_action = false;
   private boolean var_valide_doc = false;
   private int var_etat;
   private String inpResponsable;
   private String inpCommercial;
   private long inpIdResponsable;
   private long inpIdCommercial;
   private Date inpDu;
   private Date inpAu;
   private int typeRec = 100;
   private String periode;
   private String tiersRec;
   private String contactRec;
   private String produitRec;
   private String commercialRec;
   private int var_nb_ligne;
   private Date var_date;
   private String var_heure;
   private String var_minute;
   private String var_seconde;
   private boolean affichagePump = false;
   private boolean var_acc_document = false;
   private boolean var_ajt = false;
   private boolean var_mod = false;
   private boolean var_sup = false;
   private boolean var_imp = false;
   private boolean var_verrou_comm = false;
   private boolean visibleOnglet = false;
   private Tiers tiers;
   private Contacts contacts;
   private long var_nom_contat;
   private ContactDao contactDao;
   private List mesContactsItem = new ArrayList();
   private Users commercial;
   private long var_nom_commercial;
   private List mesCommercialItem = new ArrayList();
   private UserDao usersDao;
   private UtilPrint utilPrint;
   private List lesmodelesImpressions = new ArrayList();
   private List documentImpressionItems = new ArrayList();
   private boolean affMail = false;
   private String nomModeleDocument;
   private String nomModeleListe;
   private String format = "PDF";
   private String requete;
   private String impEmetteur;
   private String impDestinataire;
   private String impDestinataireCC;
   private String impDestinataireCCI;
   private boolean visibleOptionMail = false;
   private int var_choix_modele;
   private boolean affListeDoc = false;
   private boolean showModalPanelPrint = false;
   private Produits produits;
   private ProduitsAchsDao produitsAchsDao;
   private OptionVentes optionVentes;
   private ProduitsDepot produitsDepot;
   private List mesUnitesProduits = new ArrayList();
   private List mesConditionnementsProduits = new ArrayList();
   private List mesProduitsDepotsItems = new ArrayList();
   private ProduitsDepotDao produitsDepotDao;
   private CalculStock calculStock = new CalculStock();
   private List listeProduitDepot = new ArrayList();
   private Unite unite;
   private UniteDao uniteDao;
   private List mesConditionnementsItems = new ArrayList();
   private String var_depot;

   public void InstancesDaoUtilses() {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.cadeauxDao = new CadeauxDao(this.baseLog, this.utilInitHibernate);
      this.usersDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.contactDao = new ContactDao(this.baseLog, this.utilInitHibernate);
      this.produitsDepotDao = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
      this.produitsAchsDao = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
      this.uniteDao = new UniteDao(this.baseLog, this.utilInitHibernate);
   }

   public void configCadeaux(Session var1) throws HibernateException, NamingException {
      if (this.optionTiers.getNbLigneMaxCad() != null && !this.optionTiers.getNbLigneMaxCad().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionTiers.getNbLigneMaxCad());
      } else {
         this.var_nb_max = 100;
      }

      this.periode = this.optionTiers.getAffCadeaux();
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      this.optionVentes = new OptionVentes();
      LireLesoptionsVentes var2 = new LireLesoptionsVentes();
      var2.setStrId(this.structureLog.getStrid());
      this.optionVentes = var2.lancer();
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
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("51")) {
               this.var_acc_document = true;
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

   public void chargerLesUsers(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      new ArrayList();
      List var2 = this.usersDao.chargerLesUsers(var1);
      this.mesCommercialItem.clear();

      for(int var3 = 0; var3 < var2.size(); ++var3) {
         Users var4 = (Users)var2.get(var3);
         if (var4.getUsrVendeur() == 1 && var4.getUsrPatronyme() != null && !var4.getUsrPatronyme().isEmpty()) {
            this.mesCommercialItem.add(new SelectItem(var4.getUsrid(), var4.getUsrPatronyme()));
         }
      }

      this.var_nom_commercial = this.usersLog.getUsrid();
   }

   public void executerRequete() throws NamingException, HibernateException, ParseException {
      this.executerRequete((Session)null);
   }

   public void executerRequete(Session var1) throws NamingException, HibernateException, ParseException {
      this.listCadeaux.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      this.var_nb_ligne = 0;
      Object var2 = null;
      Object var3 = null;
      this.listCadeaux = this.cadeauxDao.recherche(var1, this.typeRec, this.periode, this.usersLog.getUsrid(), this.tiersRec, this.commercialRec, this.contactRec, this.produitRec, (String)var2, (String)var3);
      if (this.listCadeaux.size() > 0) {
         this.var_nb_ligne = this.listCadeaux.size();
      }

      this.datamodelCadeaux.setWrappedData(this.listCadeaux);
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
            this.cadeaux = (Cadeaux)var1.get(0);
            double var6 = this.cadeaux.getCadPump();
            this.var_date = this.cadeaux.getCadDate();
            if (this.cadeaux.getCadDate().getHours() <= 9) {
               this.var_heure = "0" + this.cadeaux.getCadDate().getHours();
            } else {
               this.var_heure = "" + this.cadeaux.getCadDate().getHours();
            }

            if (this.cadeaux.getCadDate().getMinutes() <= 9) {
               this.var_minute = "0" + this.cadeaux.getCadDate().getMinutes();
            } else {
               this.var_minute = "" + this.cadeaux.getCadDate().getMinutes();
            }

            if (this.cadeaux.getCadDate().getSeconds() <= 9) {
               this.var_seconde = "0" + this.cadeaux.getCadDate().getSeconds();
            } else {
               this.var_seconde = "" + this.cadeaux.getCadDate().getSeconds();
            }

            Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "Cadeaux");
            this.chargerLesUsers(var5);
            this.mesProduitsDepotsItems.clear();
            this.var_nom_commercial = this.cadeaux.getCadIdCommercial();
            this.var_depot = this.cadeaux.getCadDepot();
            this.produits = this.produitsAchsDao.chargeToutProduit(this.cadeaux.getCadCode(), var5);
            if (this.produits != null) {
               this.mefConditionnementDepot(var5);
               this.cadeaux.setCadPump(var6);
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
      if (this.cadeaux != null) {
         if (this.cadeaux.getCadEtat() == 0) {
            this.modifDocument();
         } else {
            this.consultDocument();
         }
      }

   }

   public void valideDocument() throws HibernateException, NamingException {
      if (this.cadeaux != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Cadeaux");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.cadeaux.setCadEtat(1);
            this.cadeaux = this.cadeauxDao.modif(this.cadeaux, var1);
            if (this.cadeaux.getCadCode() != null && !this.cadeaux.getCadCode().isEmpty() && this.cadeaux.getCadDepot() != null && !this.cadeaux.getCadDepot().isEmpty()) {
               this.calculStock.majCadeauxVentesVAL(this.cadeaux, 1, this.baseLog, var1);
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
      if (this.cadeaux != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Cadeaux");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.cadeaux.setCadEtat(0);
            this.cadeaux = this.cadeauxDao.modif(this.cadeaux, var1);
            if (this.cadeaux.getCadCode() != null && !this.cadeaux.getCadCode().isEmpty() && this.cadeaux.getCadDepot() != null && !this.cadeaux.getCadDepot().isEmpty()) {
               this.calculStock.majCadeauxVentesVAL(this.cadeaux, 0, this.baseLog, var1);
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

   public void ajoutDocument() throws ParseException, HibernateException, NamingException, JDOMException, IOException {
      this.cadeaux = new Cadeaux();
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
      this.var_nom_commercial = 0L;
      this.var_nom_contat = 0L;
      this.mesContactsItem.clear();
      this.mesContactsItem.add(new SelectItem(0, ""));
      this.chargerLesUsers((Session)null);
      this.var_depot = "";
      this.mesProduitsDepotsItems.clear();
      this.valide_doc = false;
      this.var_action = 1;
      this.var_memo_action = this.var_action;
   }

   public void modifDocument() throws ParseException, HibernateException, NamingException {
      if (this.cadeaux != null) {
         this.var_action = 2;
         this.var_aff_action = false;
         this.var_valide_doc = true;
         this.visibleOnglet = true;
         this.var_memo_action = this.var_action;
      }

   }

   public void consultDocument() {
      if (this.cadeaux != null) {
         this.var_action = 3;
         this.var_aff_action = true;
         this.var_valide_doc = true;
         this.visibleOnglet = true;
         this.var_memo_action = this.var_action;
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

   public void save() throws IOException, NamingException, Exception {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Cadeaux");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.cadeaux.setCadDate(this.utilDate.dateToSQL(this.var_date, this.var_heure, this.var_minute, this.var_seconde));
         this.cadeaux.setCadIdResponsable(0L);
         this.cadeaux.setCadNomResponsable("");
         new Users();
         if (this.var_nom_commercial == 0L && this.mesCommercialItem.size() == 1) {
            this.var_nom_commercial = Long.parseLong(((SelectItem)this.mesCommercialItem.get(0)).getValue().toString());
         }

         Users var3 = this.usersDao.selectUserD(this.var_nom_commercial, var1);
         if (var3 != null) {
            this.cadeaux.setCadIdCommercial(var3.getUsrid());
            this.cadeaux.setCadNomCommercial(var3.getUsrPatronyme());
         } else {
            this.cadeaux.setCadIdCommercial(0L);
            this.cadeaux.setCadNomCommercial("");
         }

         new Contacts();
         if (this.var_nom_contat == 0L && this.mesContactsItem.size() == 1) {
            this.var_nom_contat = Long.parseLong(((SelectItem)this.mesContactsItem.get(0)).getValue().toString());
         }

         Contacts var4 = this.contactDao.chargerLesContactsById(this.var_nom_contat, var1);
         if (var4 != null) {
            this.cadeaux.setCadIdContact(var4.getConid());
            this.cadeaux.setCadNomContact(var4.getConpatronyme());
         } else {
            this.cadeaux.setCadIdContact(0L);
            this.cadeaux.setCadNomContact("");
         }

         if (this.var_depot != null && this.var_depot.contains("=")) {
            String[] var5;
            if (this.var_depot.contains(":")) {
               var5 = this.var_depot.split(":");
               this.cadeaux.setCadDepot(var5[0]);
            } else {
               var5 = this.var_depot.split("=");
               this.cadeaux.setCadDepot(var5[0]);
            }
         } else {
            this.cadeaux.setCadDepot("");
         }

         this.cadeaux.setCadQteUtil(this.cadeaux.getCadQte());
         if (this.cadeaux.getCadId() == 0L) {
            this.cadeaux.setCadDateCreat(new Date());
            this.cadeaux.setCadIdCreateur(this.usersLog.getUsrid());
            this.cadeaux.setCadNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.cadeaux = this.cadeauxDao.insert(this.cadeaux, var1);
            this.visibleOnglet = true;
            this.var_action = 0;
            this.var_memo_action = this.var_action;
            this.listCadeaux.add(this.cadeaux);
            this.datamodelCadeaux.setWrappedData(this.listCadeaux);
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
         } else {
            this.cadeaux.setCadDateModif(new Date());
            this.cadeaux.setCadIdModif(this.usersLog.getUsrid());
            this.cadeaux.setCadNomModif(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.cadeaux = this.cadeauxDao.modif(this.cadeaux, var1);
            this.var_action = 0;
            this.var_memo_action = this.var_action;
            this.visibleOnglet = false;
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

   public void supprimerDocument() throws ParseException, HibernateException, NamingException {
      if (this.cadeaux != null && this.cadeaux.getCadEtat() == 0) {
         this.cadeauxDao.delete(this.cadeaux);
         this.listCadeaux.remove(this.cadeaux);
         this.datamodelCadeaux.setWrappedData(this.listCadeaux);
         this.visibiliteBton = false;
         this.extDTable = new HtmlExtendedDataTable();
         this.simpleSelectionEntete.clear();
      }

   }

   public void annuleAnnulation() {
      this.showModalPanelAnnuler = false;
   }

   public void controleValidation() {
      if (this.cadeaux.getCadCode() != null && !this.cadeaux.getCadCode().isEmpty() && this.cadeaux.getCadNomTiers() != null && !this.cadeaux.getCadNomTiers().isEmpty()) {
         this.valide_doc = true;
      } else {
         this.valide_doc = false;
      }

   }

   public void rechercheTiers() throws JDOMException, IOException, HibernateException, NamingException {
      this.tiers = this.formRecherche.rechercheTiers(9, this.cadeaux.getCadNomTiers(), 100);
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

   public void recuperationTiers() throws JDOMException, IOException, HibernateException, NamingException {
      this.tiers = this.formRecherche.calculeTiers();
      this.calculeTiers();
   }

   public void calculeTiers() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.tiers != null) {
         String var1 = "";
         if (!this.tiers.getTiegenre().equalsIgnoreCase("010") && !this.tiers.getTiegenre().equalsIgnoreCase("020") && !this.tiers.getTiegenre().equalsIgnoreCase("030") && !this.tiers.getTiegenre().equalsIgnoreCase("037")) {
            var1 = this.tiers.getTieraisonsocialenom();
            this.cadeaux.setCadCivilTiers("");
         } else {
            var1 = this.tiers.getTieraisonsocialenom() + " " + this.tiers.getTieprenom();
            this.cadeaux.setCadCivilTiers(this.tiers.getTiecivilite());
         }

         this.cadeaux.setCadTypeTiers(Integer.parseInt(this.tiers.getTietype()));
         this.cadeaux.setCadNomTiers(var1);
         this.chargerLesContactsItem((Session)null);
         this.controleValidation();
      } else {
         this.annuleTiers();
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleTiers() {
      this.tiers = null;
      this.cadeaux.setCadIdTiers(0L);
      this.cadeaux.setCadNomTiers("");
      this.cadeaux.setCadCivilTiers("");
      this.cadeaux.setCadTypeTiers(0);
      this.controleValidation();
      this.var_action = this.var_memo_action;
   }

   public void chargerLesContactsItem(Session var1) throws HibernateException, NamingException {
      this.mesContactsItem = new ArrayList();
      this.mesContactsItem = this.contactDao.chargerLesContactsItems(this.tiers.getTieid(), var1);
   }

   public void rechercheCommercial() throws JDOMException, IOException, HibernateException, NamingException {
      this.commercial = this.formRecherche.rechercheCommercial(this.inpCommercial, this.nature);
      if (this.commercial != null) {
         if (this.commercial.getUsrid() != 0L) {
            this.calculeCommercial();
         } else {
            this.var_action = 17;
         }
      } else if (this.commercial == null) {
         this.calculeCommercial();
      }

   }

   public void recuperationCommercial() throws JDOMException, IOException, HibernateException, NamingException {
      this.commercial = this.formRecherche.calculeCommercial();
      this.calculeCommercial();
   }

   public void calculeCommercial() throws JDOMException, IOException {
      if (this.commercial != null) {
         this.inpCommercial = this.commercial.getUsrPatronyme();
         this.inpIdCommercial = this.commercial.getUsrid();
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

   public void rechercheProduits() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.cadeaux.getCadCode() != null && !this.cadeaux.getCadCode().isEmpty() && !this.cadeaux.getCadCode().equals("-") && !this.cadeaux.getCadCode().equals("=")) {
         if (this.tiers != null && this.tiers.getTiedepot() != null && !this.tiers.getTiedepot().isEmpty() && this.tiers.getTiedepot().contains(":")) {
            this.produits = this.formRecherche.rechercheProduitVenteHorsGenerique(this.tiers.getTiedepot(), this.cadeaux.getCadCode(), 100, this.optionVentes);
         } else {
            this.produits = this.formRecherche.rechercheProduitVenteHorsGenerique(this.cadeaux.getCadCode(), 100, (OptionVentes)this.optionVentes);
         }

         if (this.produits != null) {
            if (this.produits.getProId() != 0L) {
               this.calculeProduits();
            } else {
               this.var_action = 15;
            }
         } else if (this.produits == null) {
            this.calculeProduits();
         }
      }

   }

   public void recuperationProduit() throws JDOMException, IOException, HibernateException, NamingException {
      this.produits = this.formRecherche.calculeProduit();
      this.calculeProduits();
   }

   public void calculeProduits() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.produits != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Cadeaux");
         this.cadeaux.setCadCode(this.produits.getProCode());
         this.cadeaux.setCadLibelle(this.produits.getProLibClient());
         this.cadeaux.setCadFamille(this.produits.getProVteCode());
         this.cadeaux.setCadLarg(this.produits.getProLargeur());
         this.cadeaux.setCadLong(this.produits.getProLongueur());
         this.cadeaux.setCadPoidsBrut(this.produits.getProPoidsBrut());
         this.cadeaux.setCadPoidsNet(this.produits.getProPoidsNet());
         this.cadeaux.setCadVolume(this.produits.getProVolume());
         this.cadeaux.setCadHaut(this.produits.getProEpaisseur());
         this.mefConditionnementDepot(var1);
         this.selectionDepot(var1);
         if (this.produitsDepot != null) {
            this.mesUnitesProduits = this.chargerUniteProduit(var1);
            if (this.produitsDepot.getProdepUnite() != null && !this.produitsDepot.getProdepUnite().isEmpty()) {
               this.cadeaux.setCadUnite(this.produitsDepot.getProdepUnite());
            } else {
               this.cadeaux.setCadUnite("");
            }
         } else {
            this.produitsDepot = null;
            this.mesUnitesProduits.clear();
            this.cadeaux.setCadUnite("");
         }

         this.mesConditionnementsProduits = this.chargerConditionnementProduit(var1);
         this.cadeaux.setCadCondition("");
         if (this.mesConditionnementsProduits.size() != 0) {
            this.cadeaux.setCadCondition(((SelectItem)this.mesConditionnementsProduits.get(0)).getLabel().toString());
            this.selectionDepot(var1);
         }

         this.controleValidation();
         this.utilInitHibernate.closeSession();
      } else {
         this.annuleProduits();
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleProduits() {
      this.produits = null;
      this.produitsDepot = null;
      this.cadeaux.setCadCode("");
      this.cadeaux.setCadLibelle("");
      this.mesProduitsDepotsItems.clear();
      this.mesConditionnementsProduits.clear();
      this.mesUnitesProduits.clear();
      this.controleValidation();
      this.var_action = this.var_memo_action;
   }

   public void selectionDepot() throws HibernateException, NamingException {
      this.selectionDepot((Session)null);
      this.mesUnitesProduits = this.chargerUniteProduit((Session)null);
      this.cadeaux.setCadUnite(this.produitsDepot.getProdepUnite());
   }

   public void selectionDepot(Session var1) throws HibernateException, NamingException {
      if (this.produits != null) {
         if (this.mesProduitsDepotsItems.size() != 0) {
            if (this.cadeaux.getCadDepot() == null || this.cadeaux.getCadDepot().isEmpty()) {
               this.cadeaux.setCadDepot(((SelectItem)this.mesProduitsDepotsItems.get(0)).getLabel());
            }

            String[] var2 = null;
            if (this.cadeaux.getCadDepot().contains(":")) {
               var2 = this.cadeaux.getCadDepot().split(":");
            } else {
               var2 = this.cadeaux.getCadDepot().split("=");
            }

            String var3 = var2[0];
            this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.produits.getProCode(), var3, var1);
            if (this.produitsDepot == null) {
               this.produitsDepot = null;
               this.cadeaux.setCadDepot("");
               this.cadeaux.setCadUnite("0");
            } else {
               this.cadeaux.setCadUnite("" + this.produitsDepot.getProdepEchelle());
            }
         } else {
            this.produitsDepot = null;
            this.cadeaux.setCadDepot("");
            this.cadeaux.setCadUnite("0");
         }
      } else {
         this.produitsDepot = null;
         this.cadeaux.setCadDepot("");
         this.cadeaux.setCadUnite("0");
      }

      if (this.produitsDepot != null) {
         double var9 = 0.0D;
         float var4;
         if (this.cadeaux.getCadCondition() != null && !this.cadeaux.getCadCondition().isEmpty() && this.cadeaux.getCadCondition().contains(":")) {
            var4 = this.calculStock.calculCoefConversion(this.produitsDepot.getProdepEchelle(), this.cadeaux.getCadEchelle());
            float var5 = 1.0F;
            if (this.cadeaux.getCadCondition().contains("/")) {
               String[] var6 = this.cadeaux.getCadCondition().split("/");
               String var7 = var6[1];
               String[] var8 = var7.split(":");
               var5 = Float.parseFloat(var8[0]);
            }

            var9 = this.utilNombre.myRound(this.produitsDepot.getProdepPump() / (double)var4 * (double)var5, 2);
         } else if (this.cadeaux.getCadCondition() != null && !this.cadeaux.getCadCondition().isEmpty() && !this.cadeaux.getCadCondition().contains(":")) {
            var4 = this.calculStock.calculCoefConversion(this.produitsDepot.getProdepEchelle(), this.cadeaux.getCadEchelle());
            var9 = this.utilNombre.myRound(this.produitsDepot.getProdepPump() / (double)var4, 2);
         } else {
            var9 = this.produitsDepot.getProdepPump();
         }

         this.cadeaux.setCadPump(var9);
      } else {
         this.cadeaux.setCadPump(0.0D);
      }

   }

   public void selectionConditionnement() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Cadeaux");
      this.mefConditionnementDepot(var1);
      this.selectionDepot(var1);
      this.utilInitHibernate.closeSession();
   }

   public void mefConditionnementDepot(Session var1) throws HibernateException, NamingException {
      this.mesProduitsDepotsItems.clear();
      this.listeProduitDepot.clear();
      if (this.produits.getProStock() != 0) {
         String var2 = this.cadeaux.getCadCondition();
         if (var2 != null && !var2.isEmpty() && var2.contains(":")) {
            if (var2.contains("/")) {
               String[] var3 = var2.split("/");
               String var4 = var3[1];
               String[] var5 = var4.split(":");
               this.unite = this.uniteDao.selectUnite(var5[1], var1);
               if (this.unite != null) {
                  this.cadeaux.setCadEchelle(this.unite.getUniEchelle());
               } else {
                  this.cadeaux.setCadEchelle(this.produitsDepot.getProdepEchelle());
               }
            } else {
               this.cadeaux.setCadEchelle(this.produitsDepot.getProdepEchelle());
            }
         } else if (var2 != null && !var2.isEmpty() && !var2.contains(":")) {
            this.cadeaux.setCadEchelle(Integer.parseInt(var2));
         } else {
            this.cadeaux.setCadEchelle(0);
         }

         this.listeProduitDepot = this.produitsDepotDao.selectProdDepByprod(this.produits, this.nature, var1);
         if (this.listeProduitDepot.size() != 0) {
            for(int var8 = 0; var8 < this.listeProduitDepot.size(); ++var8) {
               ProduitsDepot var9 = (ProduitsDepot)this.listeProduitDepot.get(var8);
               float var10 = 0.0F;
               if (this.optionVentes.getChoixStock().equals("1")) {
                  var10 = var9.getProdepQteStk() - var9.getProdepQteAttVte();
               } else {
                  var10 = var9.getProdepQteStk();
               }

               String var6 = "";
               int var7;
               if (var2 != null && !var2.isEmpty() && var2.contains(":")) {
                  var10 = this.calculStock.calculQteUtilMultiple(this.produits, this.produitsDepot, var2, var10, this.cadeaux.getCadLong(), this.cadeaux.getCadLarg(), this.cadeaux.getCadHaut(), this.cadeaux.getCadDiam(), this.cadeaux.getCadNb(), this.baseLog, var1);
                  var7 = (int)var10;
                  var6 = "" + var7;
               } else if (var2 != null && !var2.isEmpty() && !var2.contains(":")) {
                  var10 = this.calculStock.calculQteUtilMultiple(this.produits, this.produitsDepot, var2, var10, this.cadeaux.getCadLong(), this.cadeaux.getCadLarg(), this.cadeaux.getCadHaut(), this.cadeaux.getCadDiam(), this.cadeaux.getCadNb(), this.baseLog, var1);
                  var7 = (int)var10;
                  var6 = "" + var7;
               } else {
                  var6 = "" + var10;
               }

               if (this.tiers != null && this.tiers.getTiedepot() != null && !this.tiers.getTiedepot().isEmpty() && this.tiers.getTiedepot().contains(":")) {
                  String[] var11 = this.tiers.getTiedepot().split(":");
                  if (var9.getDepot().getDpoCode().equals(var11[0])) {
                     if (var9.getProdepCasier() != null && !var9.getProdepCasier().isEmpty()) {
                        this.mesProduitsDepotsItems.add(new SelectItem(var9.getDepot().getDpoCode() + ":" + var9.getProdepCasier() + "=" + var6));
                     } else {
                        this.mesProduitsDepotsItems.add(new SelectItem(var9.getDepot().getDpoCode() + "=" + var6));
                     }
                  }
               } else if (var9.getProdepCasier() != null && !var9.getProdepCasier().isEmpty()) {
                  this.mesProduitsDepotsItems.add(new SelectItem(var9.getDepot().getDpoCode() + ":" + var9.getProdepCasier() + "=" + var6));
               } else {
                  this.mesProduitsDepotsItems.add(new SelectItem(var9.getDepot().getDpoCode() + "=" + var6));
               }
            }
         }
      }

   }

   public List chargerUniteProduit(Session var1) {
      this.mesUnitesProduits.clear();
      if (this.produits != null && this.produitsDepot != null && this.produitsDepot.getProdepUnite() != null && !this.produitsDepot.getProdepUnite().isEmpty()) {
         this.mesUnitesProduits.add(new SelectItem(this.produitsDepot.getProdepUnite()));
      }

      return this.mesUnitesProduits;
   }

   public List chargerConditionnementProduit(Session var1) {
      this.mesConditionnementsProduits.clear();
      this.mesConditionnementsProduits = this.calculStock.calculConditionnementVentes(this.mesConditionnementsItems, this.produits, this.produitsDepot, var1);
      return this.mesConditionnementsProduits;
   }

   public void initImpression() {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.var_choix_modele = 0;
      this.visibleOptionMail = false;
      this.affMail = false;
      this.listeDocImp();
      this.showModalPanelPrint = true;
   }

   public void closeImpression() {
      this.showModalPanelPrint = false;
   }

   public void listeDocImp() {
      String var1 = "";
      this.lesmodelesImpressions.clear();
      this.documentImpressionItems.clear();
      File var2;
      String[] var3;
      int var4;
      String var5;
      String var6;
      if (this.var_choix_modele == 0) {
         this.affListeDoc = false;
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "cadeaux" + File.separator;
         var2 = new File(var1);
         if (!var2.exists()) {
            var2.mkdir();
         }

         this.documentImpressionItems = new ArrayList();
         var3 = var2.list();
         if (var3 != null) {
            var3 = this.triAlphabetique(var3, var3.length);

            for(var4 = 0; var4 < var3.length; ++var4) {
               if (var3[var4].endsWith("jasper")) {
                  var5 = var3[var4];
                  if (this.verificationAutorisation(var5)) {
                     var6 = var3[var4].substring(0, var3[var4].indexOf("."));
                     this.documentImpressionItems.add(new SelectItem(var6));
                  }
               }
            }
         }
      } else {
         this.affListeDoc = true;
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste" + File.separator + "cadeaux" + File.separator;
         var2 = new File(var1);
         if (!var2.exists()) {
            var2.mkdir();
         }

         this.lesmodelesImpressions = new ArrayList();
         var3 = var2.list();
         if (var3 != null) {
            var3 = this.triAlphabetique(var3, var3.length);

            for(var4 = 0; var4 < var3.length; ++var4) {
               if (var3[var4].endsWith("jasper")) {
                  var5 = var3[var4];
                  if (this.verificationAutorisation(var5)) {
                     var6 = var3[var4].substring(0, var3[var4].indexOf("."));
                     this.lesmodelesImpressions.add(new SelectItem(var6));
                  }
               }
            }
         }
      }

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

   public boolean verificationAutorisation(String var1) {
      boolean var2 = true;
      return var2;
   }

   public void OptionMail() {
      if (this.format.equalsIgnoreCase("MAIL")) {
         this.visibleOptionMail = true;
      } else {
         this.visibleOptionMail = false;
      }

   }

   public void imprimerPRT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "PRT";
      this.imprimer();
   }

   public void imprimerJRV() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "JRV";
      this.imprimer();
   }

   public void imprimerPDF() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "PDF";
      this.imprimer();
   }

   public void imprimerODT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "ODT";
      this.imprimer();
   }

   public void imprimerXLS() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "XLS";
      this.imprimer();
   }

   public void imprimerDOC() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "DOC";
      this.imprimer();
   }

   public void imprimerHTML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "HTML";
      this.imprimer();
   }

   public void imprimerXML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "XML";
      this.imprimer();
   }

   public void imprimerMAIL() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      if (this.impEmetteur != null && !this.impEmetteur.isEmpty() && (this.impDestinataire != null && !this.impDestinataire.isEmpty() || this.impDestinataireCC != null && !this.impDestinataireCC.isEmpty() || this.impDestinataireCCI != null && !this.impDestinataireCCI.isEmpty())) {
         this.format = "MAIL";
         this.imprimer();
      }

   }

   public void envoieMAIL() throws SQLException, JRException, IOException, HibernateException, NamingException {
      if (!this.affMail) {
         this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, (Tiers)null, "");
         if (this.utilPrint.getLesbalEmetteursItems().size() != 0 && this.utilPrint.getLesbalDestinatairesItems().size() != 0) {
            this.affMail = true;
         } else {
            this.affMail = false;
         }
      } else {
         this.affMail = false;
      }

   }

   public String calculeCheminRapport(String var1, int var2) {
      String var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "cadeaux" + File.separator;
      return var3;
   }

   public String calculeCheminSousRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport" + File.separator;
      return var2;
   }

   public String calculeImageFond(String var1) throws HibernateException, NamingException {
      String var2 = "";
      File var3 = new File(this.calculeCheminSousRapport(var1) + "formatCadeaux.jpg");
      if (var3.exists()) {
         var2 = "formatCadeaux.jpg";
      }

      return var2;
   }

   public JRBeanCollectionDataSource calculeImpressionCommun() throws IOException {
      ArrayList var1 = new ArrayList();
      JRBeanCollectionDataSource var2 = new JRBeanCollectionDataSource(var1);
      return var2;
   }

   public boolean majDateImpression(String var1) throws HibernateException, NamingException {
      boolean var2 = false;
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "Cadeaux");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         this.cadeaux.setCadModele(var1);
         this.cadeaux = this.cadeauxDao.modif(this.cadeaux, var3);
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

   public void imprimer() throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      if (this.var_choix_modele == 0) {
         if (this.nomModeleDocument != null && !this.nomModeleDocument.isEmpty()) {
            boolean var1 = this.majDateImpression(this.nomModeleDocument);
            this.utilPrint.setjRBeanCollectionDataSource(this.calculeImpressionCommun());
            this.utilPrint.setRapport(this.nomModeleDocument);
            this.utilPrint.setEntete("Impression cadeaux");
            this.utilPrint.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid(), this.nature));
            this.utilPrint.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            this.utilPrint.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid()));
            this.utilPrint.setDuplicata("" + var1);
            this.utilPrint.setFormat(this.format);
            this.utilPrint.setEmetteur(this.impEmetteur);
            this.utilPrint.setDestinataire(this.impDestinataire);
            this.utilPrint.setDestinataireCC(this.impDestinataireCC);
            this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
            this.utilPrint.setIdResponsable(this.cadeaux.getCadIdResponsable());
            this.utilPrint.setIdCommercial(this.cadeaux.getCadIdCommercial());
            this.utilPrint.setTiersSelectionne((Tiers)null);
            this.utilPrint.setNature(this.nature);
            this.utilPrint.setId_doc(this.cadeaux.getCadId());
            ArrayList var2 = new ArrayList();
            var2.add(this.cadeaux);
            JRBeanCollectionDataSource var3 = new JRBeanCollectionDataSource(var2);
            this.utilPrint.setjRBeanCollectionDataSource(var3);
            this.utilPrint.setParc((Parc)null);
            this.utilPrint.setBaseLog(this.baseLog);
            this.utilPrint.setStructureLog(this.structureLog);
            this.utilPrint.setUsersLog(this.usersLog);
            this.utilPrint.imprimeRapport();
         }
      } else if (this.nomModeleListe != null && !this.nomModeleListe.isEmpty()) {
         this.utilPrint.setRapport(this.nomModeleListe);
         this.utilPrint.setEntete("Impression de la liste des cadeaux");
         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste" + File.separator + "cadeaux" + File.separator);
         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport" + File.separator);
         this.utilPrint.setFormat(this.format);
         this.utilPrint.setEmetteur(this.impEmetteur);
         this.utilPrint.setDestinataire(this.impDestinataire);
         this.utilPrint.setDestinataireCC(this.impDestinataireCC);
         this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
         this.utilPrint.setIdResponsable(0L);
         this.utilPrint.setTiersSelectionne((Tiers)null);
         this.utilPrint.setNature(this.getNature());
         this.utilPrint.setId_doc(0L);
         JRBeanCollectionDataSource var4 = new JRBeanCollectionDataSource(this.listCadeaux);
         this.utilPrint.setjRBeanCollectionDataSource(var4);
         this.utilPrint.setBaseLog(this.baseLog);
         this.utilPrint.setStructureLog(this.structureLog);
         this.utilPrint.setUsersLog(this.usersLog);
         this.utilPrint.imprimeRapport();
      }

      this.showModalPanelPrint = false;
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

   public String getPeriode() {
      return this.periode;
   }

   public void setPeriode(String var1) {
      this.periode = var1;
   }

   public boolean isVar_acc_document() {
      return this.var_acc_document;
   }

   public void setVar_acc_document(boolean var1) {
      this.var_acc_document = var1;
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

   public int getVar_nb_ligne() {
      return this.var_nb_ligne;
   }

   public void setVar_nb_ligne(int var1) {
      this.var_nb_ligne = var1;
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

   public boolean isVisibleOnglet() {
      return this.visibleOnglet;
   }

   public void setVisibleOnglet(boolean var1) {
      this.visibleOnglet = var1;
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

   public boolean isShowModalPanelAnnuler() {
      return this.showModalPanelAnnuler;
   }

   public void setShowModalPanelAnnuler(boolean var1) {
      this.showModalPanelAnnuler = var1;
   }

   public boolean isAffichagePump() {
      return this.affichagePump;
   }

   public void setAffichagePump(boolean var1) {
      this.affichagePump = var1;
   }

   public Cadeaux getCadeaux() {
      return this.cadeaux;
   }

   public void setCadeaux(Cadeaux var1) {
      this.cadeaux = var1;
   }

   public DataModel getDatamodelCadeaux() {
      return this.datamodelCadeaux;
   }

   public void setDatamodelCadeaux(DataModel var1) {
      this.datamodelCadeaux = var1;
   }

   public String getCommercialRec() {
      return this.commercialRec;
   }

   public void setCommercialRec(String var1) {
      this.commercialRec = var1;
   }

   public String getContactRec() {
      return this.contactRec;
   }

   public void setContactRec(String var1) {
      this.contactRec = var1;
   }

   public String getProduitRec() {
      return this.produitRec;
   }

   public void setProduitRec(String var1) {
      this.produitRec = var1;
   }

   public String getTiersRec() {
      return this.tiersRec;
   }

   public void setTiersRec(String var1) {
      this.tiersRec = var1;
   }

   public int getTypeRec() {
      return this.typeRec;
   }

   public void setTypeRec(int var1) {
      this.typeRec = var1;
   }

   public OptionTiers getOptionTiers() {
      return this.optionTiers;
   }

   public void setOptionTiers(OptionTiers var1) {
      this.optionTiers = var1;
   }

   public List getMesPeriodesItems() {
      return this.mesPeriodesItems;
   }

   public void setMesPeriodesItems(List var1) {
      this.mesPeriodesItems = var1;
   }

   public List getMesContactsItem() {
      return this.mesContactsItem;
   }

   public void setMesContactsItem(List var1) {
      this.mesContactsItem = var1;
   }

   public List getMesCommercialItem() {
      return this.mesCommercialItem;
   }

   public void setMesCommercialItem(List var1) {
      this.mesCommercialItem = var1;
   }

   public long getVar_nom_contat() {
      return this.var_nom_contat;
   }

   public void setVar_nom_contat(long var1) {
      this.var_nom_contat = var1;
   }

   public List getMesProduitsDepotsItems() {
      return this.mesProduitsDepotsItems;
   }

   public void setMesProduitsDepotsItems(List var1) {
      this.mesProduitsDepotsItems = var1;
   }

   public String getVar_depot() {
      return this.var_depot;
   }

   public void setVar_depot(String var1) {
      this.var_depot = var1;
   }

   public boolean isValide_doc() {
      return this.valide_doc;
   }

   public void setValide_doc(boolean var1) {
      this.valide_doc = var1;
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

   public boolean isAffListeDoc() {
      return this.affListeDoc;
   }

   public void setAffListeDoc(boolean var1) {
      this.affListeDoc = var1;
   }

   public boolean isAffMail() {
      return this.affMail;
   }

   public void setAffMail(boolean var1) {
      this.affMail = var1;
   }

   public String getImpDestinataire() {
      return this.impDestinataire;
   }

   public void setImpDestinataire(String var1) {
      this.impDestinataire = var1;
   }

   public String getImpDestinataireCC() {
      return this.impDestinataireCC;
   }

   public void setImpDestinataireCC(String var1) {
      this.impDestinataireCC = var1;
   }

   public String getImpDestinataireCCI() {
      return this.impDestinataireCCI;
   }

   public void setImpDestinataireCCI(String var1) {
      this.impDestinataireCCI = var1;
   }

   public String getImpEmetteur() {
      return this.impEmetteur;
   }

   public void setImpEmetteur(String var1) {
      this.impEmetteur = var1;
   }

   public List getLesmodelesImpressions() {
      return this.lesmodelesImpressions;
   }

   public void setLesmodelesImpressions(List var1) {
      this.lesmodelesImpressions = var1;
   }

   public String getNomModeleDocument() {
      return this.nomModeleDocument;
   }

   public void setNomModeleDocument(String var1) {
      this.nomModeleDocument = var1;
   }

   public String getNomModeleListe() {
      return this.nomModeleListe;
   }

   public void setNomModeleListe(String var1) {
      this.nomModeleListe = var1;
   }

   public int getVar_choix_modele() {
      return this.var_choix_modele;
   }

   public void setVar_choix_modele(int var1) {
      this.var_choix_modele = var1;
   }

   public boolean isVisibleOptionMail() {
      return this.visibleOptionMail;
   }

   public void setVisibleOptionMail(boolean var1) {
      this.visibleOptionMail = var1;
   }

   public List getDocumentImpressionItems() {
      return this.documentImpressionItems;
   }

   public void setDocumentImpressionItems(List var1) {
      this.documentImpressionItems = var1;
   }
}
