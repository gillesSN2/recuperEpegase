package com.epegase.forms.office;

import com.epegase.systeme.classe.AvoirEnteteVentes;
import com.epegase.systeme.classe.CommandeEnteteVentes;
import com.epegase.systeme.classe.Contacts;
import com.epegase.systeme.classe.DevisEnteteVentes;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.FactureEnteteVentes;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.LivraisonEnteteVentes;
import com.epegase.systeme.classe.NoteDebitEnteteVentes;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.Rdv;
import com.epegase.systeme.classe.RetourEnteteVentes;
import com.epegase.systeme.classe.ReunionAction;
import com.epegase.systeme.classe.ReunionEntete;
import com.epegase.systeme.classe.ReunionPresence;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.classe.UsersObjectifs;
import com.epegase.systeme.control.RdvSemaine;
import com.epegase.systeme.dao.AvoirEnteteVentesDao;
import com.epegase.systeme.dao.CommandeEnteteVentesDao;
import com.epegase.systeme.dao.ContactDao;
import com.epegase.systeme.dao.DevisEnteteVentesDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.FactureEnteteVentesDao;
import com.epegase.systeme.dao.LivraisonEnteteVentesDao;
import com.epegase.systeme.dao.NoteDebitEnteteVentesDao;
import com.epegase.systeme.dao.RdvDao;
import com.epegase.systeme.dao.RetourEnteteVentesDao;
import com.epegase.systeme.dao.ReunionActionDao;
import com.epegase.systeme.dao.ReunionEnteteDao;
import com.epegase.systeme.dao.ReunionPresenceDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.dao.UsersObjectifsDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.util.UtilTdt;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
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

public class FormReunion implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private int var_action = 0;
   private String pageIndex;
   private int nature;
   private List mesOnglets;
   private EspionDao espionDao;
   private CalculChrono calculChrono;
   private ReunionEntete reunionEntete;
   private ReunionEnteteDao reunionEnteteDao;
   private List lesReunionEntetes = new ArrayList();
   private transient DataModel dataModelReunion = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private UtilDate utilDate = new UtilDate();
   private boolean visibiliteBton = false;
   private boolean var_aff_action = false;
   private boolean var_valide_doc = false;
   private List mesHeuresDebItems;
   private List mesMinutesDebItems;
   private List mesHeuresFinItems;
   private List mesMinutesFinItems;
   private UsersChrono usersChrono = new UsersChrono();
   private UsersChronoDao usersChronoDao;
   private String inpService = "100";
   private String inpResponsable = "";
   private String inpTiers = "";
   private int inpEtat = 0;
   private int inpType = 100;
   private String periode;
   private String inpNum = "";
   private String inpActivite = "100";
   private Date inpDu = null;
   private Date inpAu = null;
   private int var_nb_ligne;
   private transient DataModel datamodelResponsable;
   private List lesUsers = new ArrayList();
   private List lesCommerciaux = new ArrayList();
   private List lesReunionPresence = new ArrayList();
   private transient DataModel dataModelPresence = new ListDataModel();
   private ReunionPresence reunionPresence;
   private ReunionPresenceDao reunionPresenceDao;
   private List mesUsersPresentsItem;
   private List lesUsersActifs = new ArrayList();
   private transient DataModel dataModelActifs = new ListDataModel();
   private String nomAgentAnalyse;
   private transient DataModel dataModelActionOld = new ListDataModel();
   private List lesReunionActionOld = new ArrayList();
   private UserDao userDao;
   private Users userAnalyse = new Users();
   private boolean afficheButtonActionNew = false;
   private boolean afficheButtonActionOld = false;
   private transient DataModel dataModelActionNew = new ListDataModel();
   private List lesReunionActionNew = new ArrayList();
   private ReunionAction reunionAction;
   private ReunionActionDao reunionActionDao;
   private boolean showModalPanelActionNew = false;
   private boolean showModalPanelActionOld = false;
   private String var_qui;
   private String var_president;
   private String var_secretaire;
   private List mesPresidentsItem;
   private List mesSecretairesItem;
   private List mesAgentsPresentsItem;
   private UtilTdt utilTdt = new UtilTdt();
   private boolean showModalPanelPrint = false;
   private String var_inpModeleImp;
   private List documentConvocationImpressionItems;
   private List documentResultatImpressionItems;
   private List listeConvocationImpressionItems;
   private List listeResultatImpressionItems;
   private UtilNombre utilNombre;
   private List lesDevis;
   private List lesCommandes;
   private List lesLivraisons;
   private List lesRetours;
   private List lesFactures;
   private List lesNdb;
   private List lesAvoirs;
   private boolean showModalPanelVente = false;
   private transient DataModel dataModelLesDevis;
   private transient DataModel dataModelLesCommandes;
   private transient DataModel dataModelLesLivraison;
   private transient DataModel dataModelLesRetours;
   private transient DataModel dataModelLesFactures;
   private transient DataModel dataModelLesNdb;
   private transient DataModel dataModelesAvoirs;
   private double caHt;
   private int nbDoc;
   private double caMoyen;
   private int nbTrf;
   private double caTrf;
   private float tauxTrf;
   private int nbJour;
   private double caJour;
   private float tauxJour;
   private int nbClients;
   private double clientMoyen;
   private float tauxClient;
   private double totalGlobalHt;
   private int nbDocGlobal;
   private double moyenneGlobale;
   private int sansSources;
   private boolean showModalPanelRdv = false;
   private List lesRdv;
   private transient DataModel dataModeLesRdv;
   private List lesRapportsRdv;
   private transient DataModel dataModelRaportRdv;
   private boolean showModalPanelTiers = false;
   private transient DataModel datamodelTiers;
   private List lesTiersRecherche;
   private Tiers tiers;
   private TiersDao tiersDao;
   private List lesContacts;
   private List lesContactsItems;
   private ContactDao contactDao;
   private String var_contact;
   private String var_frontOffice;
   private String var_backOffice;
   private double objectifHt;
   private double ecartHt;
   private UsersObjectifs usersObjectifs;
   private UsersObjectifsDao usersObjectifsDao;
   private Habilitation habilitation;
   private RdvDao rdvDao;

   public FormReunion() {
      this.utilTdt = new UtilTdt();
      this.mesPresidentsItem = new ArrayList();
      this.mesSecretairesItem = new ArrayList();
      this.mesUsersPresentsItem = new ArrayList();
      this.documentConvocationImpressionItems = new ArrayList();
      this.documentResultatImpressionItems = new ArrayList();
      this.listeConvocationImpressionItems = new ArrayList();
      this.listeResultatImpressionItems = new ArrayList();
      this.lesDevis = new ArrayList();
      this.lesCommandes = new ArrayList();
      this.lesLivraisons = new ArrayList();
      this.lesRetours = new ArrayList();
      this.lesFactures = new ArrayList();
      this.lesNdb = new ArrayList();
      this.lesAvoirs = new ArrayList();
      this.dataModelLesDevis = new ListDataModel();
      this.dataModelLesCommandes = new ListDataModel();
      this.dataModelLesLivraison = new ListDataModel();
      this.dataModelLesRetours = new ListDataModel();
      this.dataModelLesFactures = new ListDataModel();
      this.dataModelLesNdb = new ListDataModel();
      this.dataModelesAvoirs = new ListDataModel();
      this.lesRdv = new ArrayList();
      this.dataModeLesRdv = new ListDataModel();
      this.lesRapportsRdv = new ArrayList();
      this.dataModelRaportRdv = new ListDataModel();
      this.utilNombre = new UtilNombre();
      this.lesTiersRecherche = new ArrayList();
      this.datamodelTiers = new ListDataModel();
      this.lesContacts = new ArrayList();
      this.lesContactsItems = new ArrayList();
      this.mesAgentsPresentsItem = new ArrayList();
      this.usersObjectifs = new UsersObjectifs();
   }

   public void InstancesDaoUtilses() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.reunionEnteteDao = new ReunionEnteteDao(this.baseLog, this.utilInitHibernate);
      this.reunionActionDao = new ReunionActionDao(this.baseLog, this.utilInitHibernate);
      this.reunionPresenceDao = new ReunionPresenceDao(this.baseLog, this.utilInitHibernate);
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      this.contactDao = new ContactDao(this.baseLog, this.utilInitHibernate);
      this.usersObjectifsDao = new UsersObjectifsDao(this.baseLog, this.utilInitHibernate);
      this.rdvDao = new RdvDao(this.baseLog, this.utilInitHibernate);
   }

   public void initPage() throws ParseException {
      this.var_action = 0;
      this.inpNum = "";
      this.inpService = "100";
      this.inpActivite = "100";
      this.inpResponsable = "";
      this.inpEtat = 0;
      this.inpType = 100;
      this.inpDu = this.utilDate.datePremierJourMois(new Date());
      this.inpAu = this.utilDate.dateDernierJourMois(new Date());
      this.lesReunionEntetes.clear();
      int var1 = 0;
      if (this.structureLog.getStrHrDeb() != null) {
         var1 = Integer.parseInt(this.structureLog.getStrHrDeb());
      }

      if (var1 == 0) {
         var1 = 8;
      }

      int var2 = 0;
      if (this.structureLog.getStrHrFin() != null) {
         var2 = Integer.parseInt(this.structureLog.getStrHrFin());
      }

      if (var2 == 0) {
         var2 = 19;
      }

      int var3 = 0;
      if (this.structureLog.getStrHrPas() != null) {
         var3 = Integer.parseInt(this.structureLog.getStrHrPas());
      }

      if (var3 == 0) {
         var3 = 1;
      }

      this.mesHeuresDebItems = new ArrayList();

      int var4;
      for(var4 = var1; var4 <= var2; var4 += var3) {
         if (var4 <= 9) {
            this.mesHeuresDebItems.add(new SelectItem("0" + var4));
         } else {
            this.mesHeuresDebItems.add(new SelectItem(var4));
         }
      }

      this.mesHeuresFinItems = this.mesHeuresDebItems;
      var4 = 0;
      if (this.structureLog.getStrMnDeb() != null) {
         var4 = Integer.parseInt(this.structureLog.getStrMnDeb());
      }

      if (var4 == 0) {
         var4 = 0;
      }

      int var5 = 0;
      if (this.structureLog.getStrMnFin() != null) {
         var5 = Integer.parseInt(this.structureLog.getStrMnFin());
      }

      if (var5 == 0) {
         var5 = 59;
      }

      int var6 = 0;
      if (this.structureLog.getStrMnPas() != null) {
         var6 = Integer.parseInt(this.structureLog.getStrMnPas());
      }

      if (var6 == 0) {
         var6 = 30;
      }

      this.mesMinutesDebItems = new ArrayList();

      for(int var7 = var4; var7 <= var5; var7 += var6) {
         if (var7 <= 9) {
            this.mesMinutesDebItems.add(new SelectItem("0" + var7));
         } else {
            this.mesMinutesDebItems.add(new SelectItem(var7));
         }
      }

      this.mesMinutesFinItems = this.mesMinutesDebItems;
      this.recupererModeleDocumentConvocation();
      this.recupererModeleDocumentResultat();
      this.recupererModeleListeConvocation();
      this.recupererModeleListeResultat();
   }

   public void executerRequete() throws IOException, HibernateException, NamingException, ParseException {
      this.chargerLesReunions((Session)null);
   }

   public void chargerLesReunions(Session var1) throws HibernateException, NamingException, ParseException {
      this.lesReunionEntetes.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      this.var_nb_ligne = 0;
      String var2 = "";
      String var3 = "";
      if (this.inpDu != null) {
         var2 = this.utilDate.dateToStringSQLLight(this.inpDu);
      }

      if (this.inpAu != null) {
         var3 = this.utilDate.dateToStringSQLLight(this.inpAu);
      }

      this.lesReunionEntetes = this.reunionEnteteDao.recherche(var1, this.nature, this.inpNum, this.inpEtat, this.inpType, this.inpService, this.usersLog.getUsrid(), 0, this.inpResponsable, this.inpActivite, var2, var3, this.inpTiers);
      this.dataModelReunion.setWrappedData(this.lesReunionEntetes);
   }

   public void chargerUserChrono(Session var1) throws HibernateException, NamingException {
      if (this.reunionEntete != null) {
         this.usersChrono = this.usersChronoDao.selectUnique("", this.nature, this.usersLog, var1);
      }

   }

   public void chargerUserService() throws HibernateException, NamingException {
      this.chargerUserService((Session)null);
   }

   public void chargerUserService(Session var1) throws HibernateException, NamingException {
      if (this.reunionEntete.getReuService() != null && !this.reunionEntete.getReuService().isEmpty()) {
         this.lesUsers.clear();
         this.lesUsers = this.userDao.chargerLesUsersByServices(this.reunionEntete.getReuService(), var1);
         ArrayList var2 = new ArrayList();
         if (this.lesUsers.size() != 0) {
            for(int var3 = 0; var3 < this.lesUsers.size(); ++var3) {
               new Users();
               Users var4 = (Users)this.lesUsers.get(var3);
               var2.add(new SelectItem(var4.getUsrid(), var4.getUsrNom() + ":" + var4.getUsrPrenom()));
               if (var4.getUsrVendeur() == 1) {
                  this.lesCommerciaux.add(var4);
               }
            }
         }

         this.mesPresidentsItem = var2;
         this.mesSecretairesItem = var2;
      }

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
            this.reunionEntete = (ReunionEntete)var1.get(0);
            Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReunionEntete");
            this.var_president = "" + this.reunionEntete.getReuIdPresident();
            if (this.reunionEntete.getReuIdSecretaire() != 0L) {
               this.var_secretaire = "" + this.reunionEntete.getReuIdSecretaire();
            } else {
               this.var_secretaire = "";
            }

            if (this.reunionEntete.getReuIdContact() != 0L) {
               this.var_contact = "" + this.reunionEntete.getReuIdContact();
            } else {
               this.var_contact = "";
            }

            if (this.reunionEntete.getReuIdTiers() != 0L) {
               this.tiers = this.tiersDao.selectTierD(this.reunionEntete.getReuIdTiers(), var4);
               this.chargerContactTiers(var4);
            } else {
               this.tiers = new Tiers();
            }

            if (this.reunionEntete.getReuIdFrontOffice() != 0L) {
               this.var_frontOffice = "" + this.reunionEntete.getReuIdFrontOffice();
            } else {
               this.var_frontOffice = "";
            }

            if (this.reunionEntete.getReuIdBackOffice() != 0L) {
               this.var_backOffice = "" + this.reunionEntete.getReuIdBackOffice();
            } else {
               this.var_backOffice = "";
            }

            this.chargerUserService(var4);
            this.chargerPresence(var4);
            this.chargerActionNew(var4);
            this.chargerActionOld(var4);
            this.chargerUserChrono(var4);
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
      if (this.reunionEntete != null) {
         if (this.reunionEntete.getReuEtat() == 0) {
            this.modifDocument();
         } else {
            this.consultDocument();
         }
      }

   }

   public void chargerPresence(Session var1) throws HibernateException, NamingException {
      this.lesReunionPresence.clear();
      this.mesUsersPresentsItem.clear();
      this.lesReunionPresence = this.reunionPresenceDao.selectReunionPresence(this.reunionEntete, var1);
      int var2;
      Users var3;
      boolean var4;
      int var5;
      ReunionPresence var6;
      if (this.nature == 121) {
         if (this.lesCommerciaux.size() != 0) {
            for(var2 = 0; var2 < this.lesCommerciaux.size(); ++var2) {
               new Users();
               var3 = (Users)this.lesCommerciaux.get(var2);
               var4 = false;
               if (this.lesReunionPresence.size() != 0) {
                  for(var5 = 0; var5 < this.lesReunionPresence.size(); ++var5) {
                     new ReunionPresence();
                     var6 = (ReunionPresence)this.lesReunionPresence.get(var5);
                     if (var3.getUsrid() == var6.getReupreIdUser()) {
                        var4 = true;
                     }
                  }
               }

               if (!var4) {
                  this.reunionPresence = new ReunionPresence();
                  this.reunionPresence.setReupreCiviliteUser(var3.getUsrCivilite());
                  this.reunionPresence.setReupreIdUser(var3.getUsrid());
                  this.reunionPresence.setReupreMotif("");
                  this.reunionPresence.setReupreNomUser(var3.getUsrNom());
                  this.reunionPresence.setReupreNum(this.reunionEntete.getReuNum());
                  this.reunionPresence.setReuprePrenomUser(var3.getUsrPrenom());
                  this.reunionPresence.setReupreSansStatut(true);
                  this.reunionPresence.setReupreConvoquer(false);
                  this.reunionPresence.setReuprePresent(false);
                  this.reunionPresence.setReupreAbsentAutorise(false);
                  this.reunionPresence.setReupreAbsentInterdit(false);
                  this.reunionPresence.setReunionEntete(this.reunionEntete);
                  this.lesReunionPresence.add(this.reunionPresence);
               }
            }

            for(var2 = 0; var2 < this.lesReunionPresence.size(); ++var2) {
               if (((ReunionPresence)this.lesReunionPresence.get(var2)).isReupreConvoquer()) {
                  this.mesUsersPresentsItem.add(new SelectItem(((ReunionPresence)this.lesReunionPresence.get(var2)).getReupreIdUser(), ((ReunionPresence)this.lesReunionPresence.get(var2)).getReupreNomUser() + ":" + ((ReunionPresence)this.lesReunionPresence.get(var2)).getReuprePrenomUser()));
               }
            }
         }
      } else if (this.lesUsers.size() != 0) {
         for(var2 = 0; var2 < this.lesUsers.size(); ++var2) {
            new Users();
            var3 = (Users)this.lesUsers.get(var2);
            var4 = false;
            if (this.lesReunionPresence.size() != 0) {
               for(var5 = 0; var5 < this.lesReunionPresence.size(); ++var5) {
                  new ReunionPresence();
                  var6 = (ReunionPresence)this.lesReunionPresence.get(var5);
                  if (var3.getUsrid() == var6.getReupreIdUser()) {
                     var4 = true;
                  }
               }
            }

            if (!var4) {
               this.reunionPresence = new ReunionPresence();
               this.reunionPresence.setReupreCiviliteUser(var3.getUsrCivilite());
               this.reunionPresence.setReupreIdUser(var3.getUsrid());
               this.reunionPresence.setReupreMotif("");
               this.reunionPresence.setReupreNomUser(var3.getUsrNom());
               this.reunionPresence.setReupreNum(this.reunionEntete.getReuNum());
               this.reunionPresence.setReuprePrenomUser(var3.getUsrPrenom());
               this.reunionPresence.setReupreSansStatut(true);
               this.reunionPresence.setReupreConvoquer(false);
               this.reunionPresence.setReuprePresent(false);
               this.reunionPresence.setReupreAbsentAutorise(false);
               this.reunionPresence.setReupreAbsentInterdit(false);
               this.reunionPresence.setReunionEntete(this.reunionEntete);
               this.lesReunionPresence.add(this.reunionPresence);
            }
         }

         for(var2 = 0; var2 < this.lesReunionPresence.size(); ++var2) {
            if (((ReunionPresence)this.lesReunionPresence.get(var2)).isReupreConvoquer()) {
               this.mesUsersPresentsItem.add(new SelectItem(((ReunionPresence)this.lesReunionPresence.get(var2)).getReupreIdUser(), ((ReunionPresence)this.lesReunionPresence.get(var2)).getReupreNomUser() + ":" + ((ReunionPresence)this.lesReunionPresence.get(var2)).getReuprePrenomUser()));
            }
         }
      }

      this.dataModelPresence.setWrappedData(this.lesReunionPresence);
   }

   public void chargerActionNew(Session var1) throws HibernateException, NamingException {
      this.lesReunionActionNew.clear();
      this.lesReunionActionNew = this.reunionActionDao.selectReunionActionNew(this.reunionEntete, var1);
      this.dataModelActionNew.setWrappedData(this.lesReunionActionNew);
   }

   public void chargerActionOld(Session var1) throws HibernateException, NamingException {
      this.lesReunionActionOld.clear();
      this.lesReunionActionOld = this.reunionActionDao.selectReunionActionOld(this.reunionEntete, var1);
      this.dataModelActionOld.setWrappedData(this.lesReunionActionOld);
   }

   public void ajoutDocument() {
      this.reunionEntete = new ReunionEntete();
      this.reunionEntete.setReuDate(new Date());
      this.var_aff_action = false;
      this.var_valide_doc = false;
      this.var_president = "";
      this.var_secretaire = "";
      this.var_contact = "";
      this.var_frontOffice = "";
      this.var_backOffice = "";
      this.lesContactsItems.add(new SelectItem(""));
      this.tiers = null;
      this.var_action = 1;
   }

   public void modifDocument() {
      if (this.reunionEntete != null) {
         this.var_aff_action = false;
         this.var_valide_doc = true;
         this.var_action = 2;
      }

   }

   public void consultDocument() {
      if (this.reunionEntete != null) {
         this.var_aff_action = true;
         this.var_valide_doc = false;
         this.var_action = 3;
      }

   }

   public void supprimerDocument() throws HibernateException, NamingException {
      if (this.reunionEntete != null) {
         if (this.lesReunionActionNew.size() != 0) {
            this.reunionActionDao.deleteListe(this.lesReunionActionNew);
         }

         if (this.lesReunionPresence.size() != 0) {
            this.reunionPresenceDao.deleteListe(this.lesReunionPresence);
         }

         this.lesReunionEntetes.remove(this.reunionEntete);
         this.dataModelReunion.setWrappedData(this.lesReunionEntetes);
         this.reunionEnteteDao.delete(this.reunionEntete);
         this.visibiliteBton = false;
         this.extDTable = new HtmlExtendedDataTable();
         this.simpleSelectionEntete.clear();
      }

   }

   public void selectionLigneCommercial() throws HibernateException, NamingException {
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

         this.reunionEntete = (ReunionEntete)var1.get(0);
         Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReunionEntete");
         this.var_president = "" + this.reunionEntete.getReuIdPresident();
         if (this.reunionEntete.getReuIdSecretaire() != 0L) {
            this.var_secretaire = "" + this.reunionEntete.getReuIdSecretaire();
         } else {
            this.var_secretaire = "";
         }

         this.chargerUserService(var5);
         this.chargerPresence(var5);
         this.chargerActionNew(var5);
         this.chargerActionOld(var5);
         this.chargerUserChrono(var5);
         this.lesUsersActifs.clear();
         if (this.lesReunionPresence.size() != 0) {
            for(int var4 = 0; var4 < this.lesReunionPresence.size(); ++var4) {
               if (((ReunionPresence)this.lesReunionPresence.get(var4)).isReuprePresent()) {
                  this.lesUsersActifs.add(this.lesReunionPresence.get(var4));
               }
            }
         }

         this.dataModelActifs.setWrappedData(this.lesUsersActifs);
         this.utilInitHibernate.closeSession();
         this.visibiliteBton = true;
      }

   }

   public void visualisationLigneCommercial() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.reunionEntete != null) {
         if (this.reunionEntete.getReuEtat() == 0) {
            this.modifDocumentCommercial();
         } else {
            this.consultDocumentCommercial();
         }
      }

   }

   public void ajoutDocumentCommercial() {
      this.reunionEntete = new ReunionEntete();
      this.reunionEntete.setReuDate(new Date());
      this.var_aff_action = false;
      this.var_valide_doc = false;
      this.var_president = "";
      this.var_secretaire = "";
      this.var_action = 1;
   }

   public void modifDocumentCommercial() {
      if (this.reunionEntete != null) {
         this.var_aff_action = false;
         this.var_valide_doc = true;
         this.var_action = 2;
      }

   }

   public void consultDocumentCommercial() {
      if (this.reunionEntete != null) {
         this.var_aff_action = true;
         this.var_valide_doc = false;
         this.var_action = 3;
      }

   }

   public void supprimerDocumentCommercial() throws HibernateException, NamingException {
      if (this.reunionEntete != null) {
         if (this.lesReunionActionNew.size() != 0) {
            this.reunionActionDao.deleteListe(this.lesReunionActionNew);
         }

         if (this.lesReunionPresence.size() != 0) {
            this.reunionPresenceDao.deleteListe(this.lesReunionPresence);
         }

         this.lesReunionEntetes.remove(this.reunionEntete);
         this.dataModelReunion.setWrappedData(this.lesReunionEntetes);
         this.reunionEnteteDao.delete(this.reunionEntete);
         this.visibiliteBton = false;
      }

   }

   public void verifPresenceConvocation() {
      if (this.lesReunionPresence.size() != 0 && this.reunionEntete.getReuEtat() == 0) {
         for(int var1 = 0; var1 < this.lesReunionPresence.size(); ++var1) {
            this.reunionPresence = (ReunionPresence)this.lesReunionPresence.get(var1);
            if (this.reunionPresence.getReupreIdUser() == this.reunionEntete.getReuIdPresident()) {
               this.reunionPresence.setReupreSansStatut(false);
               this.reunionPresence.setReupreConvoquer(true);
               this.reunionPresence.setReupreAbsentInterdit(true);
            } else if (this.reunionPresence.getReupreIdUser() == this.reunionEntete.getReuIdSecretaire()) {
               this.reunionPresence.setReupreSansStatut(false);
               this.reunionPresence.setReupreConvoquer(true);
               this.reunionPresence.setReupreAbsentInterdit(true);
            }
         }
      }

   }

   public void annule() {
      this.visibiliteBton = false;
      this.var_action = 0;
      this.visibiliteBton = false;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public void save() throws HibernateException, NamingException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReunionEntete");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         boolean var3 = false;
         if (this.var_president != null && !this.var_president.isEmpty() && !this.var_president.equals("0")) {
            long var4 = Long.parseLong(this.var_president);
            new Users();
            Users var6 = this.userDao.selectByIdUsers(var4, var1);
            if (var6 != null) {
               var3 = true;
               this.reunionEntete.setReuNomPresident(var6.getUsrPatronyme());
               this.reunionEntete.setReuIdPresident(var6.getUsrid());
               this.reunionEntete.setReuCivilPresident(var6.getUsrCivilite());
               long var7;
               Users var9;
               if (this.var_secretaire != null && !this.var_secretaire.isEmpty() && !this.var_secretaire.equals("0")) {
                  var7 = Long.parseLong(this.var_secretaire);
                  new Users();
                  var9 = this.userDao.selectByIdUsers(var7, var1);
                  if (var9 != null) {
                     this.reunionEntete.setReuNomSecretaire(var9.getUsrPatronyme());
                     this.reunionEntete.setReuIdSecretaire(var9.getUsrid());
                     this.reunionEntete.setReuCivilSecretaire(var9.getUsrCivilite());
                  } else {
                     this.reunionEntete.setReuNomSecretaire("");
                     this.reunionEntete.setReuIdSecretaire(0L);
                     this.reunionEntete.setReuCivilSecretaire("");
                  }
               } else {
                  this.reunionEntete.setReuNomSecretaire("");
                  this.reunionEntete.setReuIdSecretaire(0L);
                  this.reunionEntete.setReuCivilSecretaire("");
               }

               if (this.reunionEntete.getReuIdTiers() != 0L) {
                  this.tiers = this.tiersDao.selectTierD(this.reunionEntete.getReuIdTiers(), var1);
                  if (this.tiers != null) {
                     this.chargerContactTiers(var1);
                  }
               } else {
                  this.tiers = null;
               }

               if (this.var_contact != null && !this.var_contact.isEmpty() && !this.var_contact.equals("0")) {
                  var7 = Long.parseLong(this.var_contact);
                  new Contacts();
                  Contacts var21 = this.contactDao.chargerLesContactsById(var7, var1);
                  if (var21 != null) {
                     this.reunionEntete.setReuNomContact(var21.getConpatronyme());
                     this.reunionEntete.setReuIdContact(var21.getConid());
                     this.reunionEntete.setReuCivilContact(var21.getConcivilite());
                  } else {
                     this.reunionEntete.setReuNomContact("");
                     this.reunionEntete.setReuIdContact(0L);
                     this.reunionEntete.setReuCivilContact("");
                  }
               } else {
                  this.reunionEntete.setReuNomContact("");
                  this.reunionEntete.setReuIdContact(0L);
                  this.reunionEntete.setReuCivilContact("");
               }

               if (this.var_frontOffice != null && !this.var_frontOffice.isEmpty() && !this.var_frontOffice.equals("0")) {
                  var7 = Long.parseLong(this.var_frontOffice);
                  new Users();
                  var9 = this.userDao.selectByIdUsers(var7, var1);
                  if (var9 != null) {
                     this.reunionEntete.setReuNomFrontOffice(var9.getUsrPatronyme());
                     this.reunionEntete.setReuIdFrontOffice(var9.getUsrid());
                     this.reunionEntete.setReuCivilFrontOffice(var9.getUsrCivilite());
                  } else {
                     this.reunionEntete.setReuNomFrontOffice("");
                     this.reunionEntete.setReuIdFrontOffice(0L);
                     this.reunionEntete.setReuCivilFrontOffice("");
                  }
               } else {
                  this.reunionEntete.setReuNomFrontOffice("");
                  this.reunionEntete.setReuIdFrontOffice(0L);
                  this.reunionEntete.setReuCivilFrontOffice("");
               }

               if (this.var_backOffice != null && !this.var_backOffice.isEmpty() && !this.var_backOffice.equals("0")) {
                  var7 = Long.parseLong(this.var_backOffice);
                  new Users();
                  var9 = this.userDao.selectByIdUsers(var7, var1);
                  if (var9 != null) {
                     this.reunionEntete.setReuNomBackOffice(var9.getUsrPatronyme());
                     this.reunionEntete.setReuIdBackOffice(var9.getUsrid());
                     this.reunionEntete.setReuCivilBackOffice(var9.getUsrCivilite());
                  } else {
                     this.reunionEntete.setReuNomBackOffice("");
                     this.reunionEntete.setReuIdBackOffice(0L);
                     this.reunionEntete.setReuCivilBackOffice("");
                  }
               } else {
                  this.reunionEntete.setReuNomBackOffice("");
                  this.reunionEntete.setReuIdBackOffice(0L);
                  this.reunionEntete.setReuCivilBackOffice("");
               }

               if ((this.reunionEntete.getReuService() == null || this.reunionEntete.getReuService().isEmpty()) && !this.reunionEntete.getReuService().contains(":")) {
                  this.reunionEntete.setReuService("");
               } else if (this.reunionEntete.getReuService().equals("100")) {
                  this.reunionEntete.setReuService("100");
               }

               if (this.reunionEntete.getReuActivite() == null || !this.reunionEntete.getReuActivite().contains(":")) {
                  this.reunionEntete.setReuActivite("");
               }

               if (this.reunionEntete.getReuDateDebut() == null) {
                  this.reunionEntete.setReuDateDebut(this.utilDate.datePremierJourMois(this.reunionEntete.getReuDate()));
               }

               if (this.reunionEntete.getReuDateFin() == null) {
                  this.reunionEntete.setReuDateFin(this.utilDate.dateDernierJourMois(this.reunionEntete.getReuDate()));
               }

               if (this.reunionEntete.getReuId() == 0L) {
                  String var19 = this.calculChrono.numCompose(new Date(), this.nature, "", var1);
                  boolean var8 = false;

                  while(true) {
                     while(!var8) {
                        new ReunionEntete();
                        ReunionEntete var22 = this.reunionEnteteDao.pourParapheur(var19, var1);
                        if (var22 != null) {
                           long var10 = 100000000L * this.usersLog.getUsrid();

                           for(long var12 = 0L; var12 < var10; ++var12) {
                           }

                           var19 = this.calculChrono.numCompose(new Date(), this.nature, "", var1);
                           var8 = false;
                        } else {
                           var8 = true;
                        }
                     }

                     this.reunionEntete.setReuNum(var19);
                     this.reunionEntete.setReuNature(this.nature);
                     this.reunionEntete = this.reunionEnteteDao.insert(this.reunionEntete, var1);
                     this.reunionEntete.setReuDateCreat(new Date());
                     this.reunionEntete.setReuIdCreateur(this.usersLog.getUsrid());
                     this.reunionEntete.setReuNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
                     this.lesReunionEntetes.add(this.reunionEntete);
                     this.dataModelReunion.setWrappedData(this.lesReunionEntetes);
                     if (this.nature == 5) {
                        this.chargerPresence(var1);
                     } else if (this.nature == 121) {
                        this.chargerPresence(var1);
                     } else if (this.nature == 120) {
                        this.chargerPresence(var1);
                     }

                     this.var_action = 2;
                     this.simpleSelectionEntete.clear();
                     this.extDTable = new HtmlExtendedDataTable();
                     break;
                  }
               } else {
                  this.reunionEntete.setReuDateModif(new Date());
                  this.reunionEntete.setReuIdModif(this.usersLog.getUsrid());
                  this.reunionEntete.setReuNomModif(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
                  this.reunionEntete = this.reunionEnteteDao.modif(this.reunionEntete, var1);
                  this.reunionPresenceDao.updateListe(this.lesReunionPresence, this.reunionEntete, var1);
                  this.var_action = 0;
               }

               if (this.lesReunionPresence.size() != 0) {
                  for(int var20 = 0; var20 < this.lesReunionPresence.size(); ++var20) {
                     this.reunionPresence = (ReunionPresence)this.lesReunionPresence.get(var20);
                     if (this.reunionPresence.getReupreId() == 0L) {
                        this.reunionPresence.setReunionEntete(this.reunionEntete);
                        this.reunionPresence.setReupreNum(this.reunionEntete.getReuNum());
                        if (this.reunionPresence.isReuprePresent()) {
                           this.reunionPresence.setReupreSansStatut(false);
                        } else {
                           this.reunionPresence.setReupreSansStatut(true);
                        }

                        this.reunionPresence = this.reunionPresenceDao.insert(this.reunionPresence, var1);
                     } else {
                        this.reunionPresence = this.reunionPresenceDao.trouveReunion(this.reunionPresence.getReupreId(), var1);
                        if (this.reunionPresence != null) {
                           this.reunionPresence = this.reunionPresenceDao.modif(this.reunionPresence, var1);
                        }
                     }
                  }
               }
            }
         }

         if (var3) {
            var2.commit();
         }
      } catch (HibernateException var17) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var17;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void controleSaisie() {
      if (this.nature == 5) {
         if (this.var_president != null && !this.var_president.isEmpty()) {
            if (this.reunionEntete.getReuObject() != null && !this.reunionEntete.getReuObject().isEmpty()) {
               this.var_valide_doc = true;
            } else {
               this.var_valide_doc = false;
            }
         } else {
            this.var_valide_doc = false;
         }
      } else if (this.nature == 120) {
         if (this.var_president != null && !this.var_president.isEmpty()) {
            if (this.reunionEntete.getReuNomTiers() != null && !this.reunionEntete.getReuNomTiers().isEmpty()) {
               this.var_valide_doc = true;
            } else {
               this.var_valide_doc = false;
            }
         } else {
            this.var_valide_doc = false;
         }
      } else if (this.nature == 121) {
         if (this.var_president != null && !this.var_president.isEmpty()) {
            this.var_valide_doc = true;
         } else {
            this.var_valide_doc = false;
         }
      }

   }

   public void selectPresence() {
      if (this.dataModelPresence.isRowAvailable()) {
         this.reunionPresence = (ReunionPresence)this.dataModelPresence.getRowData();
      }

   }

   public void presenceNonStatut() {
      this.selectPresence();
      this.reunionPresence.setReupreSansStatut(true);
      this.reunionPresence.setReupreConvoquer(false);
      this.reunionPresence.setReuprePresent(false);
      this.reunionPresence.setReupreAbsentAutorise(false);
      this.reunionPresence.setReupreAbsentInterdit(false);
   }

   public void presenceConvoquer() {
      this.selectPresence();
      this.reunionPresence.setReupreSansStatut(false);
      this.reunionPresence.setReupreConvoquer(true);
      this.reunionPresence.setReuprePresent(false);
      this.reunionPresence.setReupreAbsentAutorise(false);
      this.reunionPresence.setReupreAbsentInterdit(false);
   }

   public void presencePresent() {
      this.selectPresence();
      this.reunionPresence.setReupreSansStatut(false);
      this.reunionPresence.setReuprePresent(true);
   }

   public void presenceAbsentAuto() {
      this.selectPresence();
      this.reunionPresence.setReupreAbsentAutorise(true);
      this.reunionPresence.setReupreAbsentInterdit(false);
   }

   public void presenceAbsentInter() {
      this.selectPresence();
      this.reunionPresence.setReupreAbsentAutorise(false);
      this.reunionPresence.setReupreAbsentInterdit(true);
   }

   public void valideDocument() throws HibernateException, NamingException {
      if (this.reunionEntete != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReunionEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.reunionEntete.getReuEtat() == 0 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
               this.reunionEntete.setReuEtat(2);
               this.reunionEntete = this.reunionEnteteDao.modif(this.reunionEntete, var1);
               if (this.lesReunionActionNew.size() != 0) {
                  for(int var3 = 0; var3 < this.lesReunionActionNew.size(); ++var3) {
                     this.reunionAction = (ReunionAction)this.lesReunionActionNew.get(var3);
                     if (this.reunionAction.getReuactDate() != null) {
                        new Rdv();
                        Rdv var4 = this.rdvDao.chargerRdvUser(2, this.usersLog.getUsrid(), this.reunionAction.getReuactDate(), var1);
                        if (var4 == null) {
                           var4 = new Rdv();
                        }

                        var4.setRdvNature(2);
                        var4.setRdvDteDe(this.reunionAction.getReuactDate());
                        var4.setRdvSujet("Action Réunion N° " + this.reunionEntete.getReuNum());
                        var4.setRdvDescript("");
                        if (this.reunionAction.getReuactQuoi() != null && !this.reunionAction.getReuactQuoi().isEmpty()) {
                           var4.setRdvDescript(var4.getRdvDescript() + "Quoi: " + this.reunionAction.getReuactQuoi() + "\n");
                        }

                        if (this.reunionAction.getReuactQuoi() != null && !this.reunionAction.getReuactQuoi().isEmpty()) {
                           var4.setRdvDescript(var4.getRdvDescript() + "Ou: " + this.reunionAction.getReuactOu() + "\n");
                        }

                        if (this.reunionAction.getReuactQuoi() != null && !this.reunionAction.getReuactQuoi().isEmpty()) {
                           var4.setRdvDescript(var4.getRdvDescript() + "Quand: " + this.reunionAction.getReuactQuand() + "\n");
                        }

                        var4.setUsers(this.usersLog);
                        if (var4.getRdvId() == 0L) {
                           var4.setRdvEtat(0);
                           this.rdvDao.insert(var4, var1);
                        } else {
                           this.rdvDao.modif(var4, var1);
                        }
                     }
                  }
               }

               Espion var10 = new Espion();
               var10.setUsers(this.usersLog);
               var10.setEsptype(0);
               var10.setEspdtecreat(new Date());
               var10.setEspaction("Validation manuelle réunion (O.) N° " + this.reunionEntete.getReuNum() + " du " + this.utilDate.dateToStringSQLLight(this.reunionEntete.getReuDate()));
               this.espionDao.mAJEspion(var10, var1);
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

   }

   public void deValideDocument() throws HibernateException, NamingException {
      if (this.reunionEntete != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReunionEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.reunionEntete.getReuEtat() == 2) {
               this.reunionEntete.setReuEtat(0);
               this.reunionEntete = this.reunionEnteteDao.modif(this.reunionEntete, var1);
               if (this.lesReunionActionNew.size() != 0) {
                  for(int var3 = 0; var3 < this.lesReunionActionNew.size(); ++var3) {
                     this.reunionAction = (ReunionAction)this.lesReunionActionNew.get(var3);
                     if (this.reunionAction.getReuactDate() != null) {
                        new Rdv();
                        Rdv var4 = this.rdvDao.chargerRdvUser(2, this.usersLog.getUsrid(), this.reunionAction.getReuactDate(), var1);
                        if (var4 != null) {
                           this.rdvDao.delete(var4, var1);
                        }
                     }
                  }
               }

               Espion var10 = new Espion();
               var10.setUsers(this.usersLog);
               var10.setEsptype(0);
               var10.setEspdtecreat(new Date());
               var10.setEspaction("Dévalidation manuelle réunion (O.) N° " + this.reunionEntete.getReuNum() + " du " + this.utilDate.dateToStringSQLLight(this.reunionEntete.getReuDate()));
               this.espionDao.mAJEspion(var10, var1);
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

   }

   public void selectionAgent() {
      if (this.reunionPresence != null) {
         if (this.reunionPresence.isReuprePresent()) {
            this.reunionPresence.setReupreSansStatut(false);
         } else {
            this.reunionPresence.setReupreSansStatut(true);
         }

         this.lesUsersActifs.clear();
         if (this.lesReunionPresence.size() != 0) {
            for(int var1 = 0; var1 < this.lesReunionPresence.size(); ++var1) {
               if (((ReunionPresence)this.lesReunionPresence.get(var1)).isReuprePresent()) {
                  this.lesUsersActifs.add(this.lesReunionPresence.get(var1));
               }
            }
         }

         this.dataModelActifs.setWrappedData(this.lesUsersActifs);
      }

   }

   public void selectActif() {
      if (this.dataModelActifs.isRowAvailable()) {
         this.reunionPresence = (ReunionPresence)this.dataModelActifs.getRowData();
      }

   }

   public void analyseVente() throws HibernateException, NamingException, ParseException {
      if (this.reunionPresence == null) {
         this.selectActif();
      }

      if (this.reunionPresence != null) {
         this.caHt = 0.0D;
         this.objectifHt = 0.0D;
         this.ecartHt = 0.0D;
         this.nbDoc = 0;
         this.caMoyen = 0.0D;
         this.caTrf = 0.0D;
         this.nbTrf = 0;
         this.tauxTrf = 0.0F;
         this.nbJour = 0;
         this.caJour = 0.0D;
         this.sansSources = 0;
         this.tauxJour = 0.0F;
         this.nbClients = 0;
         this.clientMoyen = 0.0D;
         this.tauxClient = 0.0F;
         this.totalGlobalHt = 0.0D;
         this.nbDocGlobal = 0;
         this.moyenneGlobale = 0.0D;
         if (this.reunionPresence.getReupreIdUser() != 0L) {
            this.userAnalyse = this.userDao.selectByIdUsers(this.reunionPresence.getReupreIdUser(), (Session)null);
            if (this.userAnalyse != null) {
               this.nomAgentAnalyse = this.userAnalyse.getUsrPatronyme();
               Date var1 = this.utilDate.stringToDateSQLLight(this.reunionEntete.getReuDateDebut().getYear() + 1900 + "-01-01");
               String var2 = this.utilDate.dateToStringSQLLight(var1) + " 00:00:00";
               String var3 = this.utilDate.dateToStringSQLLight(this.reunionEntete.getReuDateDebut()) + " 00:00:00";
               String var4 = this.utilDate.dateToStringSQLLight(this.reunionEntete.getReuDateFin()) + " 23:59:59";
               Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
               String var6 = "";
               Transaction var7 = null;

               try {
                  var7 = var5.beginTransaction();
                  this.lesDevis.clear();
                  DevisEnteteVentesDao var8 = new DevisEnteteVentesDao(this.baseLog, this.utilInitHibernate);
                  var6 = " (dvsIdCommercial=" + this.userAnalyse.getUsrid() + " or dvsIdResponsable=" + this.userAnalyse.getUsrid() + ") and dvsDate>='" + var3 + "' and dvsDate<='" + var4 + "'";
                  this.lesDevis = var8.rechercheDevisRequete(var6, var5);
                  this.dataModelLesDevis.setWrappedData(this.lesDevis);
                  this.statistiqueDevis(var5);
                  this.reunionPresence.setReupreCaDevis(this.caHt);
                  this.reunionPresence.setReupreNbDocDevis(this.nbDoc);
                  this.reunionPresence.setReupreCaTrfDevis(this.caTrf);
                  this.reunionPresence.setReupreNbTrfDevis(this.nbTrf);
                  this.reunionPresence.setReupreNbJourDevis(this.nbJour);
                  this.reunionPresence.setReupreCaJourDevis(this.caJour);
                  this.reunionPresence.setReupreNbClientDevis(this.nbClients);
                  this.reunionPresence.setReupreCaClientDevis(this.clientMoyen);
                  this.reunionPresence.setReupreSansSourceDevis(this.sansSources);
                  this.lesCommandes.clear();
                  CommandeEnteteVentesDao var9 = new CommandeEnteteVentesDao(this.baseLog, this.utilInitHibernate);
                  var6 = " (bcmIdCommercial=" + this.userAnalyse.getUsrid() + " or bcmIdResponsable=" + this.userAnalyse.getUsrid() + ") and bcmDate>='" + var3 + "' and bcmDate<='" + var4 + "'";
                  this.lesCommandes = var9.rechercheCommandeRequete(var6, var5);
                  this.dataModelLesCommandes.setWrappedData(this.lesCommandes);
                  this.statistiqueCommande(var5);
                  this.reunionPresence.setReupreCaBc(this.caHt);
                  this.reunionPresence.setReupreNbDocBc(this.nbDoc);
                  this.reunionPresence.setReupreCaTrfBc(this.caTrf);
                  this.reunionPresence.setReupreNbTrfBc(this.nbTrf);
                  this.reunionPresence.setReupreNbJourBc(this.nbJour);
                  this.reunionPresence.setReupreCaJourBc(this.caJour);
                  this.reunionPresence.setReupreNbClientBc(this.nbClients);
                  this.reunionPresence.setReupreCaClientBc(this.clientMoyen);
                  this.reunionPresence.setReupreSansSourceBc(this.sansSources);
                  this.lesLivraisons.clear();
                  LivraisonEnteteVentesDao var10 = new LivraisonEnteteVentesDao(this.baseLog, this.utilInitHibernate);
                  var6 = " (blvIdCommercial=" + this.userAnalyse.getUsrid() + " or blvIdResponsable=" + this.userAnalyse.getUsrid() + ") and blvDate>='" + var3 + "' and blvDate<='" + var4 + "'";
                  this.lesLivraisons = var10.rechercheLivraisonRequete(var6, var5);
                  this.dataModelLesLivraison.setWrappedData(this.lesLivraisons);
                  this.statistiqueLivraison(var5);
                  this.reunionPresence.setReupreCaBl(this.caHt);
                  this.reunionPresence.setReupreNbDocBl(this.nbDoc);
                  this.reunionPresence.setReupreCaTrfBl(this.caTrf);
                  this.reunionPresence.setReupreNbTrfBl(this.nbTrf);
                  this.reunionPresence.setReupreNbJourBl(this.nbJour);
                  this.reunionPresence.setReupreCaJourBl(this.caJour);
                  this.reunionPresence.setReupreNbClientBl(this.nbClients);
                  this.reunionPresence.setReupreCaClientBl(this.clientMoyen);
                  this.reunionPresence.setReupreSansSourceBl(this.sansSources);
                  this.lesRetours.clear();
                  RetourEnteteVentesDao var11 = new RetourEnteteVentesDao(this.baseLog, this.utilInitHibernate);
                  var6 = " (brtIdCommercial=" + this.userAnalyse.getUsrid() + " or brtIdResponsable=" + this.userAnalyse.getUsrid() + ") and brtDate>='" + var3 + "' and brtDate<='" + var4 + "'";
                  this.lesRetours = var11.rechercheRetourRequete(var6, var5);
                  this.dataModelLesRetours.setWrappedData(this.lesRetours);
                  this.statistiqueRetour(var5);
                  this.reunionPresence.setReupreCaBr(this.caHt);
                  this.reunionPresence.setReupreNbDocBr(this.nbDoc);
                  this.reunionPresence.setReupreCaTrfBr(this.caTrf);
                  this.reunionPresence.setReupreNbTrfBr(this.nbTrf);
                  this.reunionPresence.setReupreNbJourBr(this.nbJour);
                  this.reunionPresence.setReupreCaJourBr(this.caJour);
                  this.reunionPresence.setReupreNbClientBr(this.nbClients);
                  this.reunionPresence.setReupreCaClientBr(this.clientMoyen);
                  this.reunionPresence.setReupreSansSourceBr(this.sansSources);
                  this.lesFactures.clear();
                  FactureEnteteVentesDao var12 = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
                  var6 = " (facIdCommercial=" + this.userAnalyse.getUsrid() + " or facIdResponsable=" + this.userAnalyse.getUsrid() + ") and facDate>='" + var3 + "' and facDate<='" + var4 + "'";
                  this.lesFactures = var12.rechercheFactureRequete(var6, var5);
                  this.dataModelLesFactures.setWrappedData(this.lesFactures);
                  this.statistiqueFacture(var5);
                  this.reunionPresence.setReupreCaFa(this.caHt);
                  this.reunionPresence.setReupreNbDocFa(this.nbDoc);
                  this.reunionPresence.setReupreCaTrfFa(this.caTrf);
                  this.reunionPresence.setReupreNbTrfFa(this.nbTrf);
                  this.reunionPresence.setReupreNbJourFa(this.nbJour);
                  this.reunionPresence.setReupreCaJourFa(this.caJour);
                  this.reunionPresence.setReupreNbClientFa(this.nbClients);
                  this.reunionPresence.setReupreCaClientFa(this.clientMoyen);
                  this.reunionPresence.setReupreSansSourceFa(this.sansSources);
                  this.lesNdb.clear();
                  NoteDebitEnteteVentesDao var13 = new NoteDebitEnteteVentesDao(this.baseLog, this.utilInitHibernate);
                  var6 = " (ndbIdCommercial=" + this.userAnalyse.getUsrid() + " or ndbIdResponsable=" + this.userAnalyse.getUsrid() + ") and ndbDate>='" + var3 + "' and ndbDate<='" + var4 + "'";
                  this.lesNdb = var13.rechercheNoteDebitRequete(var6, var5);
                  this.dataModelLesNdb.setWrappedData(this.lesNdb);
                  this.statistiqueNoteDebit(var5);
                  this.reunionPresence.setReupreCaNd(this.caHt);
                  this.reunionPresence.setReupreNbDocNd(this.nbDoc);
                  this.reunionPresence.setReupreCaTrfNd(this.caTrf);
                  this.reunionPresence.setReupreNbTrfNd(this.nbTrf);
                  this.reunionPresence.setReupreNbJourNd(this.nbJour);
                  this.reunionPresence.setReupreCaJourNd(this.caJour);
                  this.reunionPresence.setReupreNbClientNd(this.nbClients);
                  this.reunionPresence.setReupreCaClientNd(this.clientMoyen);
                  this.reunionPresence.setReupreSansSourceNd(this.sansSources);
                  this.lesAvoirs.clear();
                  AvoirEnteteVentesDao var14 = new AvoirEnteteVentesDao(this.baseLog, this.utilInitHibernate);
                  var6 = " (avrIdCommercial=" + this.userAnalyse.getUsrid() + " or avrIdResponsable=" + this.userAnalyse.getUsrid() + ") and avrDate>='" + var3 + "' and avrDate<='" + var4 + "'";
                  this.lesAvoirs = var14.rechercheAvoirRequete(var6, var5);
                  this.dataModelesAvoirs.setWrappedData(this.lesAvoirs);
                  this.statistiqueAvoir(var5);
                  this.reunionPresence.setReupreCaAv(this.caHt);
                  this.reunionPresence.setReupreNbDocAv(this.nbDoc);
                  this.reunionPresence.setReupreCaTrfAv(this.caTrf);
                  this.reunionPresence.setReupreNbTrfAv(this.nbTrf);
                  this.reunionPresence.setReupreNbJourAv(this.nbJour);
                  this.reunionPresence.setReupreCaJourAv(this.caJour);
                  this.reunionPresence.setReupreNbClientAv(this.nbClients);
                  this.reunionPresence.setReupreCaClientAv(this.clientMoyen);
                  this.reunionPresence.setReupreSansSourceAv(this.sansSources);
                  this.reunionPresence = this.reunionPresenceDao.modif(this.reunionPresence, var5);
                  var7.commit();
               } catch (HibernateException var18) {
                  if (var7 != null) {
                     var7.rollback();
                  }

                  throw var18;
               } finally {
                  this.utilInitHibernate.closeSession();
               }

               this.statistiqueDevis((Session)null);
               this.showModalPanelVente = true;
            }
         }
      }

      this.reunionPresence = null;
   }

   public void fermerVente() {
      this.showModalPanelVente = false;
   }

   public void statistiqueDevis() throws HibernateException, NamingException {
      this.statistiqueDevis((Session)null);
   }

   public void statistiqueDevis(Session var1) throws HibernateException, NamingException {
      this.caHt = 0.0D;
      this.objectifHt = 0.0D;
      this.ecartHt = 0.0D;
      this.nbDoc = 0;
      this.caMoyen = 0.0D;
      this.caTrf = 0.0D;
      this.nbTrf = 0;
      this.tauxTrf = 0.0F;
      this.nbJour = 0;
      this.caJour = 0.0D;
      this.tauxJour = 0.0F;
      this.nbClients = 0;
      this.clientMoyen = 0.0D;
      this.tauxClient = 0.0F;
      this.sansSources = 0;
      Date var2 = this.reunionEntete.getReuDateDebut();
      Calendar var3 = Calendar.getInstance();
      var3.setTime(var2);
      int var4 = var3.get(6);
      Date var5 = this.reunionEntete.getReuDateFin();
      Calendar var6 = Calendar.getInstance();
      var6.setTime(var5);
      int var7 = var6.get(6);
      String var8 = "" + (this.reunionEntete.getReuDateFin().getYear() + 1900);
      this.usersObjectifs = this.usersObjectifsDao.chargerUsersObjectifs(this.userAnalyse, var8, 21, var1);
      if (this.usersObjectifs != null) {
         int var9 = this.reunionEntete.getReuDateDebut().getMonth() + 1;
         int var10 = this.reunionEntete.getReuDateFin().getMonth() + 1;
         if (1 >= var9 && 1 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa01();
         }

         if (2 >= var9 && 2 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa02();
         }

         if (3 >= var9 && 3 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa03();
         }

         if (4 >= var9 && 4 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa04();
         }

         if (5 >= var9 && 5 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa05();
         }

         if (6 >= var9 && 6 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa06();
         }

         if (7 >= var9 && 7 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa07();
         }

         if (8 >= var9 && 8 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa08();
         }

         if (9 >= var9 && 9 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa09();
         }

         if (10 >= var9 && 10 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa10();
         }

         if (11 >= var9 && 11 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa11();
         }

         if (12 >= var9 && 12 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa12();
         }
      }

      if (this.lesDevis.size() != 0) {
         ArrayList var14 = new ArrayList();
         new DevisEnteteVentes();

         for(int var11 = 0; var11 < this.lesDevis.size(); ++var11) {
            DevisEnteteVentes var15 = (DevisEnteteVentes)this.lesDevis.get(var11);
            this.caHt += var15.getDvsTotHt();
            ++this.nbDoc;
            if (var15.getDvsSource() == null || var15.getDvsSource().isEmpty()) {
               ++this.sansSources;
            }

            if (var15.getDvsEtat() == 4 || var15.getDvsEtat() == 5) {
               this.caTrf += var15.getDvsTotHt();
               ++this.nbTrf;
            }

            if (var14.size() == 0) {
               var14.add(var15.getDvsNomTiers());
            } else {
               boolean var12 = false;

               for(int var13 = 0; var13 < var14.size(); ++var13) {
                  if (((String)var14.get(var13)).toString().equals(var15.getDvsNomTiers())) {
                     var12 = true;
                     break;
                  }
               }

               if (!var12) {
                  var14.add(var15.getDvsNomTiers());
               }
            }
         }

         this.ecartHt = this.caHt - this.objectifHt;
         this.caMoyen = this.utilNombre.myRoundDevise(this.caHt / (double)this.nbDoc, this.structureLog.getStrdevise());
         double var16 = (double)this.nbDoc;
         float var17 = (float)((double)this.nbTrf / var16 * 100.0D);
         this.tauxTrf = this.utilNombre.myRound(var17, 2);
         this.nbJour = var7 - var4;
         this.caJour = this.utilNombre.myRoundDevise(this.caHt / (double)this.nbJour, this.structureLog.getStrdevise());
         this.tauxJour = (float)this.utilNombre.myRound(this.caJour / this.caHt * 100.0D, 2);
         this.nbClients = var14.size();
         this.clientMoyen = this.utilNombre.myRoundDevise(this.caHt / (double)this.nbClients, this.structureLog.getStrdevise());
         this.tauxClient = (float)this.utilNombre.myRound(this.clientMoyen / this.caHt * 100.0D, 2);
      }

   }

   public void statistiqueCommande() throws HibernateException, NamingException {
      this.statistiqueCommande((Session)null);
   }

   public void statistiqueCommande(Session var1) throws HibernateException, NamingException {
      this.caHt = 0.0D;
      this.objectifHt = 0.0D;
      this.ecartHt = 0.0D;
      this.nbDoc = 0;
      this.caMoyen = 0.0D;
      this.caTrf = 0.0D;
      this.nbTrf = 0;
      this.tauxTrf = 0.0F;
      this.nbJour = 0;
      this.caJour = 0.0D;
      this.tauxJour = 0.0F;
      this.nbClients = 0;
      this.clientMoyen = 0.0D;
      this.tauxClient = 0.0F;
      this.sansSources = 0;
      Date var2 = this.reunionEntete.getReuDateDebut();
      Calendar var3 = Calendar.getInstance();
      var3.setTime(var2);
      int var4 = var3.get(6);
      Date var5 = this.reunionEntete.getReuDateFin();
      Calendar var6 = Calendar.getInstance();
      var6.setTime(var5);
      int var7 = var6.get(6);
      String var8 = "" + (this.reunionEntete.getReuDateFin().getYear() + 1900);
      this.usersObjectifs = this.usersObjectifsDao.chargerUsersObjectifs(this.userAnalyse, var8, 22, var1);
      if (this.usersObjectifs != null) {
         int var9 = this.reunionEntete.getReuDateDebut().getMonth() + 1;
         int var10 = this.reunionEntete.getReuDateFin().getMonth() + 1;
         if (1 >= var9 && 1 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa01();
         }

         if (2 >= var9 && 2 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa02();
         }

         if (3 >= var9 && 3 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa03();
         }

         if (4 >= var9 && 4 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa04();
         }

         if (5 >= var9 && 5 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa05();
         }

         if (6 >= var9 && 6 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa06();
         }

         if (7 >= var9 && 7 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa07();
         }

         if (8 >= var9 && 8 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa08();
         }

         if (9 >= var9 && 9 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa09();
         }

         if (10 >= var9 && 10 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa10();
         }

         if (11 >= var9 && 11 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa11();
         }

         if (12 >= var9 && 12 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa12();
         }
      }

      if (this.lesCommandes.size() != 0) {
         ArrayList var14 = new ArrayList();
         new CommandeEnteteVentes();

         for(int var11 = 0; var11 < this.lesCommandes.size(); ++var11) {
            CommandeEnteteVentes var15 = (CommandeEnteteVentes)this.lesCommandes.get(var11);
            this.caHt += var15.getBcmTotHt();
            ++this.nbDoc;
            if (var15.getBcmSource() == null || var15.getBcmSource().isEmpty()) {
               ++this.sansSources;
            }

            if (var15.getBcmEtat() == 4 || var15.getBcmEtat() == 5) {
               this.caTrf += var15.getBcmTotHt();
               ++this.nbTrf;
            }

            if (var14.size() == 0) {
               var14.add(var15.getBcmNomTiers());
            } else {
               boolean var12 = false;

               for(int var13 = 0; var13 < var14.size(); ++var13) {
                  if (((String)var14.get(var13)).toString().equals(var15.getBcmNomTiers())) {
                     var12 = true;
                     break;
                  }
               }

               if (!var12) {
                  var14.add(var15.getBcmNomTiers());
               }
            }
         }

         this.ecartHt = this.caHt - this.objectifHt;
         this.caMoyen = this.utilNombre.myRoundDevise(this.caHt / (double)this.nbDoc, this.structureLog.getStrdevise());
         double var16 = (double)this.nbDoc;
         float var17 = (float)((double)this.nbTrf / var16 * 100.0D);
         this.tauxTrf = this.utilNombre.myRound(var17, 2);
         this.nbJour = var7 - var4;
         this.caJour = this.utilNombre.myRoundDevise(this.caHt / (double)this.nbJour, this.structureLog.getStrdevise());
         this.tauxJour = (float)this.utilNombre.myRound(this.caJour / this.caHt * 100.0D, 2);
         this.nbClients = var14.size();
         this.clientMoyen = this.utilNombre.myRoundDevise(this.caHt / (double)this.nbClients, this.structureLog.getStrdevise());
         this.tauxClient = (float)this.utilNombre.myRound(this.clientMoyen / this.caHt * 100.0D, 2);
      }

   }

   public void statistiqueLivraison() throws HibernateException, NamingException {
      this.statistiqueLivraison((Session)null);
   }

   public void statistiqueLivraison(Session var1) throws HibernateException, NamingException {
      this.caHt = 0.0D;
      this.objectifHt = 0.0D;
      this.ecartHt = 0.0D;
      this.nbDoc = 0;
      this.caMoyen = 0.0D;
      this.caTrf = 0.0D;
      this.nbTrf = 0;
      this.tauxTrf = 0.0F;
      this.nbJour = 0;
      this.caJour = 0.0D;
      this.tauxJour = 0.0F;
      this.nbClients = 0;
      this.clientMoyen = 0.0D;
      this.tauxClient = 0.0F;
      this.sansSources = 0;
      Date var2 = this.reunionEntete.getReuDateDebut();
      Calendar var3 = Calendar.getInstance();
      var3.setTime(var2);
      int var4 = var3.get(6);
      Date var5 = this.reunionEntete.getReuDateFin();
      Calendar var6 = Calendar.getInstance();
      var6.setTime(var5);
      int var7 = var6.get(6);
      String var8 = "" + (this.reunionEntete.getReuDateFin().getYear() + 1900);
      this.usersObjectifs = this.usersObjectifsDao.chargerUsersObjectifs(this.userAnalyse, var8, 23, var1);
      if (this.usersObjectifs != null) {
         int var9 = this.reunionEntete.getReuDateDebut().getMonth() + 1;
         int var10 = this.reunionEntete.getReuDateFin().getMonth() + 1;
         if (1 >= var9 && 1 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa01();
         }

         if (2 >= var9 && 2 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa02();
         }

         if (3 >= var9 && 3 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa03();
         }

         if (4 >= var9 && 4 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa04();
         }

         if (5 >= var9 && 5 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa05();
         }

         if (6 >= var9 && 6 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa06();
         }

         if (7 >= var9 && 7 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa07();
         }

         if (8 >= var9 && 8 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa08();
         }

         if (9 >= var9 && 9 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa09();
         }

         if (10 >= var9 && 10 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa10();
         }

         if (11 >= var9 && 11 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa11();
         }

         if (12 >= var9 && 12 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa12();
         }
      }

      if (this.lesLivraisons.size() != 0) {
         ArrayList var14 = new ArrayList();
         new LivraisonEnteteVentes();

         for(int var11 = 0; var11 < this.lesLivraisons.size(); ++var11) {
            LivraisonEnteteVentes var15 = (LivraisonEnteteVentes)this.lesLivraisons.get(var11);
            this.caHt += var15.getBlvTotHt();
            ++this.nbDoc;
            if (var15.getBlvSource() == null || var15.getBlvSource().isEmpty()) {
               ++this.sansSources;
            }

            if (var15.getBlvEtat() == 4 || var15.getBlvEtat() == 5) {
               this.caTrf += var15.getBlvTotHt();
               ++this.nbTrf;
            }

            if (var14.size() == 0) {
               var14.add(var15.getBlvNomTiers());
            } else {
               boolean var12 = false;

               for(int var13 = 0; var13 < var14.size(); ++var13) {
                  if (((String)var14.get(var13)).toString().equals(var15.getBlvNomTiers())) {
                     var12 = true;
                     break;
                  }
               }

               if (!var12) {
                  var14.add(var15.getBlvNomTiers());
               }
            }
         }

         this.ecartHt = this.caHt - this.objectifHt;
         this.caMoyen = this.utilNombre.myRoundDevise(this.caHt / (double)this.nbDoc, this.structureLog.getStrdevise());
         double var16 = (double)this.nbDoc;
         float var17 = (float)((double)this.nbTrf / var16 * 100.0D);
         this.tauxTrf = this.utilNombre.myRound(var17, 2);
         this.nbJour = var7 - var4;
         this.caJour = this.utilNombre.myRoundDevise(this.caHt / (double)this.nbJour, this.structureLog.getStrdevise());
         this.tauxJour = (float)this.utilNombre.myRound(this.caJour / this.caHt * 100.0D, 2);
         this.nbClients = var14.size();
         this.clientMoyen = this.utilNombre.myRoundDevise(this.caHt / (double)this.nbClients, this.structureLog.getStrdevise());
         this.tauxClient = (float)this.utilNombre.myRound(this.clientMoyen / this.caHt * 100.0D, 2);
      }

   }

   public void statistiqueRetour() throws HibernateException, NamingException {
      this.statistiqueRetour((Session)null);
   }

   public void statistiqueRetour(Session var1) throws HibernateException, NamingException {
      this.caHt = 0.0D;
      this.objectifHt = 0.0D;
      this.ecartHt = 0.0D;
      this.nbDoc = 0;
      this.caMoyen = 0.0D;
      this.caTrf = 0.0D;
      this.nbTrf = 0;
      this.tauxTrf = 0.0F;
      this.nbJour = 0;
      this.caJour = 0.0D;
      this.tauxJour = 0.0F;
      this.nbClients = 0;
      this.clientMoyen = 0.0D;
      this.tauxClient = 0.0F;
      this.sansSources = 0;
      Date var2 = this.reunionEntete.getReuDateDebut();
      Calendar var3 = Calendar.getInstance();
      var3.setTime(var2);
      int var4 = var3.get(6);
      Date var5 = this.reunionEntete.getReuDateFin();
      Calendar var6 = Calendar.getInstance();
      var6.setTime(var5);
      int var7 = var6.get(6);
      String var8 = "" + (this.reunionEntete.getReuDateFin().getYear() + 1900);
      this.usersObjectifs = this.usersObjectifsDao.chargerUsersObjectifs(this.userAnalyse, var8, 24, var1);
      if (this.usersObjectifs != null) {
         int var9 = this.reunionEntete.getReuDateDebut().getMonth() + 1;
         int var10 = this.reunionEntete.getReuDateFin().getMonth() + 1;
         if (1 >= var9 && 1 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa01();
         }

         if (2 >= var9 && 2 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa02();
         }

         if (3 >= var9 && 3 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa03();
         }

         if (4 >= var9 && 4 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa04();
         }

         if (5 >= var9 && 5 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa05();
         }

         if (6 >= var9 && 6 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa06();
         }

         if (7 >= var9 && 7 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa07();
         }

         if (8 >= var9 && 8 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa08();
         }

         if (9 >= var9 && 9 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa09();
         }

         if (10 >= var9 && 10 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa10();
         }

         if (11 >= var9 && 11 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa11();
         }

         if (12 >= var9 && 12 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa12();
         }
      }

      if (this.lesRetours.size() != 0) {
         ArrayList var14 = new ArrayList();
         new RetourEnteteVentes();

         for(int var11 = 0; var11 < this.lesRetours.size(); ++var11) {
            RetourEnteteVentes var15 = (RetourEnteteVentes)this.lesRetours.get(var11);
            this.caHt += var15.getBrtTotHt();
            ++this.nbDoc;
            if (var15.getBrtSource() == null || var15.getBrtSource().isEmpty()) {
               ++this.sansSources;
            }

            if (var15.getBrtEtat() == 4 || var15.getBrtEtat() == 5) {
               this.caTrf += var15.getBrtTotHt();
               ++this.nbTrf;
            }

            if (var14.size() == 0) {
               var14.add(var15.getBrtNomTiers());
            } else {
               boolean var12 = false;

               for(int var13 = 0; var13 < var14.size(); ++var13) {
                  if (((String)var14.get(var13)).toString().equals(var15.getBrtNomTiers())) {
                     var12 = true;
                     break;
                  }
               }

               if (!var12) {
                  var14.add(var15.getBrtNomTiers());
               }
            }
         }

         this.ecartHt = this.caHt - this.objectifHt;
         this.caMoyen = this.utilNombre.myRoundDevise(this.caHt / (double)this.nbDoc, this.structureLog.getStrdevise());
         double var16 = (double)this.nbDoc;
         float var17 = (float)((double)this.nbTrf / var16 * 100.0D);
         this.tauxTrf = this.utilNombre.myRound(var17, 2);
         this.nbJour = var7 - var4;
         this.caJour = this.utilNombre.myRoundDevise(this.caHt / (double)this.nbJour, this.structureLog.getStrdevise());
         this.tauxJour = (float)this.utilNombre.myRound(this.caJour / this.caHt * 100.0D, 2);
         this.nbClients = var14.size();
         this.clientMoyen = this.utilNombre.myRoundDevise(this.caHt / (double)this.nbClients, this.structureLog.getStrdevise());
         this.tauxClient = (float)this.utilNombre.myRound(this.clientMoyen / this.caHt * 100.0D, 2);
      }

   }

   public void statistiqueFacture() throws HibernateException, NamingException {
      this.statistiqueFacture((Session)null);
   }

   public void statistiqueFacture(Session var1) throws HibernateException, NamingException {
      this.caHt = 0.0D;
      this.objectifHt = 0.0D;
      this.ecartHt = 0.0D;
      this.nbDoc = 0;
      this.caMoyen = 0.0D;
      this.caTrf = 0.0D;
      this.nbTrf = 0;
      this.tauxTrf = 0.0F;
      this.nbJour = 0;
      this.caJour = 0.0D;
      this.tauxJour = 0.0F;
      this.nbClients = 0;
      this.clientMoyen = 0.0D;
      this.tauxClient = 0.0F;
      this.sansSources = 0;
      Date var2 = this.reunionEntete.getReuDateDebut();
      Calendar var3 = Calendar.getInstance();
      var3.setTime(var2);
      int var4 = var3.get(6);
      Date var5 = this.reunionEntete.getReuDateFin();
      Calendar var6 = Calendar.getInstance();
      var6.setTime(var5);
      int var7 = var6.get(6);
      String var8 = "" + (this.reunionEntete.getReuDateFin().getYear() + 1900);
      this.usersObjectifs = this.usersObjectifsDao.chargerUsersObjectifs(this.userAnalyse, var8, 25, var1);
      if (this.usersObjectifs != null) {
         int var9 = this.reunionEntete.getReuDateDebut().getMonth() + 1;
         int var10 = this.reunionEntete.getReuDateFin().getMonth() + 1;
         if (1 >= var9 && 1 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa01();
         }

         if (2 >= var9 && 2 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa02();
         }

         if (3 >= var9 && 3 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa03();
         }

         if (4 >= var9 && 4 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa04();
         }

         if (5 >= var9 && 5 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa05();
         }

         if (6 >= var9 && 6 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa06();
         }

         if (7 >= var9 && 7 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa07();
         }

         if (8 >= var9 && 8 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa08();
         }

         if (9 >= var9 && 9 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa09();
         }

         if (10 >= var9 && 10 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa10();
         }

         if (11 >= var9 && 11 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa11();
         }

         if (12 >= var9 && 12 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa12();
         }
      }

      if (this.lesFactures.size() != 0) {
         ArrayList var14 = new ArrayList();
         new FactureEnteteVentes();

         for(int var11 = 0; var11 < this.lesFactures.size(); ++var11) {
            FactureEnteteVentes var15 = (FactureEnteteVentes)this.lesFactures.get(var11);
            this.caHt += var15.getFacTotHt();
            ++this.nbDoc;
            if (var15.getFacSource() == null || var15.getFacSource().isEmpty()) {
               ++this.sansSources;
            }

            if (var15.getFacEtat() == 4 || var15.getFacEtat() == 5) {
               this.caTrf += var15.getFacTotHt();
               ++this.nbTrf;
            }

            if (var14.size() == 0) {
               var14.add(var15.getFacNomTiers());
            } else {
               boolean var12 = false;

               for(int var13 = 0; var13 < var14.size(); ++var13) {
                  if (((String)var14.get(var13)).toString().equals(var15.getFacNomTiers())) {
                     var12 = true;
                     break;
                  }
               }

               if (!var12) {
                  var14.add(var15.getFacNomTiers());
               }
            }
         }

         this.ecartHt = this.caHt - this.objectifHt;
         this.caMoyen = this.utilNombre.myRoundDevise(this.caHt / (double)this.nbDoc, this.structureLog.getStrdevise());
         double var16 = (double)this.nbDoc;
         float var17 = (float)((double)this.nbTrf / var16 * 100.0D);
         this.tauxTrf = this.utilNombre.myRound(var17, 2);
         this.nbJour = var7 - var4;
         this.caJour = this.utilNombre.myRoundDevise(this.caHt / (double)this.nbJour, this.structureLog.getStrdevise());
         this.tauxJour = (float)this.utilNombre.myRound(this.caJour / this.caHt * 100.0D, 2);
         this.nbClients = var14.size();
         this.clientMoyen = this.utilNombre.myRoundDevise(this.caHt / (double)this.nbClients, this.structureLog.getStrdevise());
         this.tauxClient = (float)this.utilNombre.myRound(this.clientMoyen / this.caHt * 100.0D, 2);
      }

   }

   public void statistiqueNoteDebit() throws HibernateException, NamingException {
      this.statistiqueNoteDebit((Session)null);
   }

   public void statistiqueNoteDebit(Session var1) throws HibernateException, NamingException {
      this.caHt = 0.0D;
      this.objectifHt = 0.0D;
      this.ecartHt = 0.0D;
      this.nbDoc = 0;
      this.caMoyen = 0.0D;
      this.caTrf = 0.0D;
      this.nbTrf = 0;
      this.tauxTrf = 0.0F;
      this.nbJour = 0;
      this.caJour = 0.0D;
      this.tauxJour = 0.0F;
      this.nbClients = 0;
      this.clientMoyen = 0.0D;
      this.tauxClient = 0.0F;
      this.sansSources = 0;
      Date var2 = this.reunionEntete.getReuDateDebut();
      Calendar var3 = Calendar.getInstance();
      var3.setTime(var2);
      int var4 = var3.get(6);
      Date var5 = this.reunionEntete.getReuDateFin();
      Calendar var6 = Calendar.getInstance();
      var6.setTime(var5);
      int var7 = var6.get(6);
      String var8 = "" + (this.reunionEntete.getReuDateFin().getYear() + 1900);
      this.usersObjectifs = this.usersObjectifsDao.chargerUsersObjectifs(this.userAnalyse, var8, 26, var1);
      if (this.usersObjectifs != null) {
         int var9 = this.reunionEntete.getReuDateDebut().getMonth() + 1;
         int var10 = this.reunionEntete.getReuDateFin().getMonth() + 1;
         if (1 >= var9 && 1 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa01();
         }

         if (2 >= var9 && 2 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa02();
         }

         if (3 >= var9 && 3 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa03();
         }

         if (4 >= var9 && 4 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa04();
         }

         if (5 >= var9 && 5 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa05();
         }

         if (6 >= var9 && 6 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa06();
         }

         if (7 >= var9 && 7 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa07();
         }

         if (8 >= var9 && 8 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa08();
         }

         if (9 >= var9 && 9 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa09();
         }

         if (10 >= var9 && 10 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa10();
         }

         if (11 >= var9 && 11 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa11();
         }

         if (12 >= var9 && 12 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa12();
         }
      }

      if (this.lesNdb.size() != 0) {
         ArrayList var14 = new ArrayList();
         new NoteDebitEnteteVentes();

         for(int var11 = 0; var11 < this.lesNdb.size(); ++var11) {
            NoteDebitEnteteVentes var15 = (NoteDebitEnteteVentes)this.lesNdb.get(var11);
            this.caHt += var15.getNdbTotHt();
            ++this.nbDoc;
            if (var15.getNdbSource() == null || var15.getNdbSource().isEmpty()) {
               ++this.sansSources;
            }

            if (var15.getNdbEtat() == 4 || var15.getNdbEtat() == 5) {
               this.caTrf += var15.getNdbTotHt();
               ++this.nbTrf;
            }

            if (var14.size() == 0) {
               var14.add(var15.getNdbNomTiers());
            } else {
               boolean var12 = false;

               for(int var13 = 0; var13 < var14.size(); ++var13) {
                  if (((String)var14.get(var13)).toString().equals(var15.getNdbNomTiers())) {
                     var12 = true;
                     break;
                  }
               }

               if (!var12) {
                  var14.add(var15.getNdbNomTiers());
               }
            }
         }

         this.ecartHt = this.caHt - this.objectifHt;
         this.caMoyen = this.utilNombre.myRoundDevise(this.caHt / (double)this.nbDoc, this.structureLog.getStrdevise());
         double var16 = (double)this.nbDoc;
         float var17 = (float)((double)this.nbTrf / var16 * 100.0D);
         this.tauxTrf = this.utilNombre.myRound(var17, 2);
         this.nbJour = var7 - var4;
         this.caJour = this.utilNombre.myRoundDevise(this.caHt / (double)this.nbJour, this.structureLog.getStrdevise());
         this.tauxJour = (float)this.utilNombre.myRound(this.caJour / this.caHt * 100.0D, 2);
         this.nbClients = var14.size();
         this.clientMoyen = this.utilNombre.myRoundDevise(this.caHt / (double)this.nbClients, this.structureLog.getStrdevise());
         this.tauxClient = (float)this.utilNombre.myRound(this.clientMoyen / this.caHt * 100.0D, 2);
      }

   }

   public void statistiqueAvoir() throws HibernateException, NamingException {
      this.statistiqueAvoir((Session)null);
   }

   public void statistiqueAvoir(Session var1) throws HibernateException, NamingException {
      this.caHt = 0.0D;
      this.objectifHt = 0.0D;
      this.ecartHt = 0.0D;
      this.nbDoc = 0;
      this.caMoyen = 0.0D;
      this.caTrf = 0.0D;
      this.nbTrf = 0;
      this.tauxTrf = 0.0F;
      this.nbJour = 0;
      this.caJour = 0.0D;
      this.tauxJour = 0.0F;
      this.nbClients = 0;
      this.clientMoyen = 0.0D;
      this.tauxClient = 0.0F;
      this.sansSources = 0;
      Date var2 = this.reunionEntete.getReuDateDebut();
      Calendar var3 = Calendar.getInstance();
      var3.setTime(var2);
      int var4 = var3.get(6);
      Date var5 = this.reunionEntete.getReuDateFin();
      Calendar var6 = Calendar.getInstance();
      var6.setTime(var5);
      int var7 = var6.get(6);
      String var8 = "" + (this.reunionEntete.getReuDateFin().getYear() + 1900);
      this.usersObjectifs = this.usersObjectifsDao.chargerUsersObjectifs(this.userAnalyse, var8, 27, var1);
      if (this.usersObjectifs != null) {
         int var9 = this.reunionEntete.getReuDateDebut().getMonth() + 1;
         int var10 = this.reunionEntete.getReuDateFin().getMonth() + 1;
         if (1 >= var9 && 1 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa01();
         }

         if (2 >= var9 && 2 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa02();
         }

         if (3 >= var9 && 3 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa03();
         }

         if (4 >= var9 && 4 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa04();
         }

         if (5 >= var9 && 5 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa05();
         }

         if (6 >= var9 && 6 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa06();
         }

         if (7 >= var9 && 7 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa07();
         }

         if (8 >= var9 && 8 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa08();
         }

         if (9 >= var9 && 9 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa09();
         }

         if (10 >= var9 && 10 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa10();
         }

         if (11 >= var9 && 11 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa11();
         }

         if (12 >= var9 && 12 <= var10) {
            this.objectifHt += this.usersObjectifs.getUsrobjCa12();
         }
      }

      if (this.lesAvoirs.size() != 0) {
         ArrayList var14 = new ArrayList();
         new AvoirEnteteVentes();

         for(int var11 = 0; var11 < this.lesAvoirs.size(); ++var11) {
            AvoirEnteteVentes var15 = (AvoirEnteteVentes)this.lesAvoirs.get(var11);
            this.caHt += var15.getAvrTotHt();
            ++this.nbDoc;
            if (var15.getAvrSource() == null || var15.getAvrSource().isEmpty()) {
               ++this.sansSources;
            }

            if (var15.getAvrEtat() == 4 || var15.getAvrEtat() == 5) {
               this.caTrf += var15.getAvrTotHt();
               ++this.nbTrf;
            }

            if (var14.size() == 0) {
               var14.add(var15.getAvrNomTiers());
            } else {
               boolean var12 = false;

               for(int var13 = 0; var13 < var14.size(); ++var13) {
                  if (((String)var14.get(var13)).toString().equals(var15.getAvrNomTiers())) {
                     var12 = true;
                     break;
                  }
               }

               if (!var12) {
                  var14.add(var15.getAvrNomTiers());
               }
            }
         }

         this.ecartHt = this.caHt - this.objectifHt;
         this.caMoyen = this.utilNombre.myRoundDevise(this.caHt / (double)this.nbDoc, this.structureLog.getStrdevise());
         double var16 = (double)this.nbDoc;
         float var17 = (float)((double)this.nbTrf / var16 * 100.0D);
         this.tauxTrf = this.utilNombre.myRound(var17, 2);
         this.nbJour = var7 - var4;
         this.caJour = this.utilNombre.myRoundDevise(this.caHt / (double)this.nbJour, this.structureLog.getStrdevise());
         this.tauxJour = (float)this.utilNombre.myRound(this.caJour / this.caHt * 100.0D, 2);
         this.nbClients = var14.size();
         this.clientMoyen = this.utilNombre.myRoundDevise(this.caHt / (double)this.nbClients, this.structureLog.getStrdevise());
         this.tauxClient = (float)this.utilNombre.myRound(this.clientMoyen / this.caHt * 100.0D, 2);
      }

   }

   public void analyseRdv() throws HibernateException, NamingException {
      if (this.reunionPresence == null) {
         this.selectActif();
      }

      if (this.reunionPresence != null && this.reunionEntete.getReuDateDebut() != null && this.reunionEntete.getReuDateFin() != null) {
         this.userAnalyse = this.userDao.selectByIdUsers(this.reunionPresence.getReupreIdUser(), (Session)null);
         if (this.userAnalyse != null) {
            String var1 = this.utilDate.dateToStringSQLLight(this.reunionEntete.getReuDateDebut());
            String var2 = this.utilDate.dateToStringSQLLight(this.reunionEntete.getReuDateFin());
            String var3 = "";
            Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "Tiers");
            Transaction var5 = null;

            try {
               var5 = var4.beginTransaction();
               this.lesRdv.clear();
               var3 = " (rdv_usr_de=" + this.userAnalyse.getUsrid() + " or usr_id=" + this.userAnalyse.getUsrid() + ") and rdv_dte_de>='" + var1 + "' and rdv_dte_de<='" + var2 + "'";
               this.lesRdv = this.rdvDao.rechercheRdvRequete(var3, var4);
               this.dataModeLesRdv.setWrappedData(this.lesRdv);
               this.statistiqueRdv(var4);
               int var6 = 0;
               int var7 = 0;
               int var8 = 0;
               int var9 = 0;
               int var10 = 0;
               if (this.lesRapportsRdv.size() != 0) {
                  new RdvSemaine();

                  for(int var12 = 0; var12 < this.lesRapportsRdv.size(); ++var12) {
                     RdvSemaine var11 = (RdvSemaine)this.lesRapportsRdv.get(var12);
                     ++var6;
                     var7 += var11.getNbFait();
                     var8 += var11.getNbNonFait();
                     var9 += var11.getNbReporte();
                     var10 += var11.getNbAnnule();
                  }
               }

               this.reunionPresence.setReupreNbRdv(var6);
               this.reunionPresence.setReupreNbRdvFait(var7);
               this.reunionPresence.setReupreNbRdvNonFait(var8);
               this.reunionPresence.setReupreNbRdvReport(var9);
               this.reunionPresence.setReupreNbRdvAnnule(var10);
               this.reunionPresence = this.reunionPresenceDao.modif(this.reunionPresence, var4);
               var5.commit();
            } catch (HibernateException var16) {
               if (var5 != null) {
                  var5.rollback();
               }

               throw var16;
            } finally {
               this.utilInitHibernate.closeSession();
            }

            this.showModalPanelRdv = true;
         }
      }

      this.reunionPresence = null;
   }

   public void statistiqueRdv(Session var1) {
      this.lesRapportsRdv.clear();
      if (this.lesRdv.size() != 0) {
         new Rdv();
         new RdvSemaine();

         RdvSemaine var3;
         int var4;
         for(var4 = 0; var4 < this.lesRdv.size(); ++var4) {
            Rdv var2 = (Rdv)this.lesRdv.get(var4);
            if (this.lesRapportsRdv.size() == 0) {
               var3 = new RdvSemaine();
               var3.setRdvNature(var2.getRdvNature());
               var3.setNbRdv(1);
               if (var2.getRdvEtat() == 0) {
                  var3.setNbNonFait(1);
               } else if (var2.getRdvEtat() == 1) {
                  var3.setNbFait(1);
               } else if (var2.getRdvEtat() == 2) {
                  var3.setNbReporte(1);
               } else if (var2.getRdvEtat() == 3) {
                  var3.setNbAnnule(1);
               }

               this.lesRapportsRdv.add(var3);
            } else {
               boolean var5 = false;

               for(int var6 = 0; var6 < this.lesRapportsRdv.size(); ++var6) {
                  var3 = (RdvSemaine)this.lesRapportsRdv.get(var6);
                  if (var3.getRdvNature() == var2.getRdvNature()) {
                     this.lesRapportsRdv.remove(var3);
                     var3.setRdvNature(var2.getRdvNature());
                     var3.setNbRdv(var3.getNbRdv() + 1);
                     if (var2.getRdvEtat() == 0) {
                        var3.setNbNonFait(var3.getNbNonFait() + 1);
                     } else if (var2.getRdvEtat() == 1) {
                        var3.setNbFait(var3.getNbFait() + 1);
                     } else if (var2.getRdvEtat() == 2) {
                        var3.setNbReporte(var3.getNbReporte() + 1);
                     } else if (var2.getRdvEtat() == 3) {
                        var3.setNbAnnule(var3.getNbAnnule() + 1);
                     }

                     this.lesRapportsRdv.add(var3);
                     var5 = true;
                     break;
                  }
               }

               if (!var5) {
                  var3 = new RdvSemaine();
                  var3.setRdvNature(var2.getRdvNature());
                  var3.setNbRdv(1);
                  if (var2.getRdvEtat() == 0) {
                     var3.setNbNonFait(1);
                  } else if (var2.getRdvEtat() == 1) {
                     var3.setNbFait(1);
                  } else if (var2.getRdvEtat() == 2) {
                     var3.setNbReporte(1);
                  } else if (var2.getRdvEtat() == 3) {
                     var3.setNbAnnule(1);
                  }

                  this.lesRapportsRdv.add(var3);
               }
            }
         }

         if (this.lesRapportsRdv.size() != 0) {
            for(var4 = 0; var4 < this.lesRapportsRdv.size(); ++var4) {
               var3 = (RdvSemaine)this.lesRapportsRdv.get(var4);
               float var8 = (float)var3.getNbFait();
               float var9 = (float)var3.getNbRdv();
               float var7 = var8 / var9 * 100.0F;
               var3.setTauxSucces(var7);
            }
         }
      }

      this.dataModelRaportRdv.setWrappedData(this.lesRapportsRdv);
   }

   public void fermerRdv() {
      this.showModalPanelRdv = false;
   }

   public void selectActionOld() {
      if (this.dataModelActionOld.isRowAvailable()) {
         this.reunionAction = (ReunionAction)this.dataModelActionOld.getRowData();
         this.afficheButtonActionOld = true;
         this.afficheButtonActionNew = false;
      }

   }

   public void modifActionOld() {
      if (this.reunionAction != null) {
         this.var_qui = this.reunionAction.getReuactNomUser();
         this.reunionAction.setReuactNumExecution(this.reunionEntete.getReuNum());
         this.afficheButtonActionOld = false;
         this.showModalPanelActionOld = true;
      }

   }

   public void annuleActionOld() {
      this.showModalPanelActionOld = false;
      this.afficheButtonActionOld = false;
   }

   public void saveActionOld() throws HibernateException, NamingException {
      if (this.reunionAction != null && this.reunionAction.getReuactId() != 0L) {
         this.reunionAction.setReuactNumExecution(this.reunionEntete.getReuNum());
         this.reunionAction = this.reunionActionDao.modif(this.reunionAction);
      }

      this.showModalPanelActionOld = false;
   }

   public void selectActionNew() {
      if (this.dataModelActionNew.isRowAvailable()) {
         this.reunionAction = (ReunionAction)this.dataModelActionNew.getRowData();
         this.var_qui = "" + this.reunionAction.getReuactIdUser();
         this.afficheButtonActionNew = true;
         this.afficheButtonActionOld = false;
      }

   }

   public void ajoutAction() {
      this.reunionAction = new ReunionAction();
      this.mesAgentsPresentsItem.clear();
      if (this.lesReunionPresence.size() != 0) {
         for(int var1 = 0; var1 < this.lesReunionPresence.size(); ++var1) {
            if (((ReunionPresence)this.lesReunionPresence.get(var1)).isReuprePresent()) {
               if (((ReunionPresence)this.lesReunionPresence.get(var1)).getReuprePrenomUser() != null && !((ReunionPresence)this.lesReunionPresence.get(var1)).getReuprePrenomUser().isEmpty()) {
                  this.mesAgentsPresentsItem.add(new SelectItem(((ReunionPresence)this.lesReunionPresence.get(var1)).getReupreIdUser(), ((ReunionPresence)this.lesReunionPresence.get(var1)).getReupreNomUser() + " " + ((ReunionPresence)this.lesReunionPresence.get(var1)).getReuprePrenomUser()));
               } else {
                  this.mesAgentsPresentsItem.add(new SelectItem(((ReunionPresence)this.lesReunionPresence.get(var1)).getReupreIdUser(), ((ReunionPresence)this.lesReunionPresence.get(var1)).getReupreNomUser()));
               }
            }
         }
      }

      this.showModalPanelActionNew = true;
   }

   public void modifAction() {
      if (this.reunionAction != null) {
         this.showModalPanelActionNew = true;
      }

   }

   public void deleteAction() throws HibernateException, NamingException {
      if (this.reunionAction != null) {
         this.lesReunionActionNew.remove(this.reunionAction);
         this.dataModelActionNew.setWrappedData(this.lesReunionActionNew);
         this.reunionActionDao.delete(this.reunionAction);
         this.afficheButtonActionNew = false;
      }

   }

   public void annuleAction() {
      this.afficheButtonActionNew = false;
      this.showModalPanelActionNew = false;
   }

   public void saveAction() throws HibernateException, NamingException {
      if (this.var_qui != null && !this.var_qui.equals("0")) {
         long var1 = Long.parseLong(this.var_qui);
         new Users();
         Users var3 = this.userDao.selectByIdUsers(var1, (Session)null);
         if (var3 != null) {
            this.reunionAction.setReuactCiviliteUser(var3.getUsrCivilite());
            this.reunionAction.setReuactFonctionUser(var3.getUsrFonction());
            this.reunionAction.setReuactNomUser(var3.getUsrNom());
            this.reunionAction.setReuactPrenomUser(var3.getUsrPrenom());
            this.reunionAction.setReuactIdUser(var3.getUsrid());
            if (this.reunionAction.getReuactId() == 0L) {
               this.reunionAction.setReunionEntete(this.reunionEntete);
               this.reunionAction.setReuactNum(this.reunionEntete.getReuNum());
               this.reunionAction = this.reunionActionDao.insert(this.reunionAction);
               this.lesReunionActionNew.add(this.reunionAction);
               this.dataModelActionNew.setWrappedData(this.lesReunionActionNew);
            } else {
               this.reunionAction = this.reunionActionDao.modif(this.reunionAction);
            }
         }
      }

      this.afficheButtonActionNew = false;
      this.showModalPanelActionNew = false;
   }

   public void rechercheTiers() throws HibernateException, NamingException {
      this.lesTiersRecherche = new ArrayList();
      if (this.reunionEntete.getReuNomTiers() != null && !this.reunionEntete.getReuNomTiers().isEmpty()) {
         this.lesTiersRecherche = this.tiersDao.verifTiers(this.usersLog, "", this.reunionEntete.getReuNomTiers(), (Session)null);
         if (this.lesTiersRecherche.size() != 0) {
            this.datamodelTiers.setWrappedData(this.lesTiersRecherche);
            this.showModalPanelTiers = true;
         } else {
            this.tiers = null;
            this.reunionEntete.setReuNomTiers("");
            this.reunionEntete.setReuIdTiers(0L);
         }
      }

   }

   public void selectionTiers() {
      if (this.datamodelTiers.isRowAvailable()) {
         this.tiers = (Tiers)this.datamodelTiers.getRowData();
      }

   }

   public void calculeTiers() throws HibernateException, NamingException {
      if (this.lesTiersRecherche.size() != 0) {
         if (this.tiers != null) {
            this.reunionEntete.setReuNomTiers(this.tiers.getTieraisonsocialenom());
            this.reunionEntete.setReuIdTiers(this.tiers.getTieid());
            this.reunionEntete.setReuCivilTiers(this.tiers.getTiecivilite());
            this.chargerContactTiers((Session)null);
         } else {
            this.annuleTiers();
         }
      } else {
         this.annuleTiers();
      }

      this.showModalPanelTiers = false;
   }

   public void annuleTiers() {
      this.tiers = null;
      this.reunionEntete.setReuNomTiers("");
      this.reunionEntete.setReuIdTiers(0L);
      this.reunionEntete.setReuCivilTiers("");
      this.lesContacts.clear();
      this.lesContactsItems.clear();
      this.showModalPanelTiers = false;
   }

   public void chargerContactTiers(Session var1) throws HibernateException, NamingException {
      if (this.tiers != null) {
         this.lesContacts.clear();
         this.lesContactsItems.clear();
         this.lesContacts = this.contactDao.listContactByTiersMail(this.tiers, var1);
         if (this.lesContacts.size() != 0) {
            if (this.lesContacts.size() != 0) {
               for(int var2 = 0; var2 < this.lesContacts.size(); ++var2) {
                  Contacts var3 = (Contacts)this.lesContacts.get(var2);
                  if (var3.getConpatronyme() != null && !var3.getConpatronyme().isEmpty()) {
                     this.lesContactsItems.add(new SelectItem(var3.getConid(), var3.getConpatronyme()));
                  }
               }
            } else {
               this.lesContactsItems.add(new SelectItem(0, ""));
            }
         } else {
            this.lesContactsItems.add(new SelectItem(0, ""));
         }
      }

   }

   public void recupererModeleDocumentConvocation() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "document" + File.separator + "reunion_convocation" + File.separator;
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.documentConvocationImpressionItems.clear();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            if (var3[var4].endsWith("jasper")) {
               String var5 = var3[var4].substring(0, var3[var4].indexOf("."));
               this.documentConvocationImpressionItems.add(new SelectItem(var5));
            }
         }
      }

   }

   public void recupererModeleListeConvocation() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "liste" + File.separator + "reunion_convocation" + File.separator;
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.listeConvocationImpressionItems.clear();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            if (var3[var4].endsWith("jasper")) {
               String var5 = var3[var4].substring(0, var3[var4].indexOf("."));
               this.listeConvocationImpressionItems.add(new SelectItem(var5));
            }
         }
      }

   }

   public void recupererModeleDocumentResultat() {
      String var1 = "";
      if (this.nature == 5) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "document" + File.separator + "reunion_resultat" + File.separator;
      } else if (this.nature == 120) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "document" + File.separator + "reunion_tiers" + File.separator;
      } else if (this.nature == 121) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "document" + File.separator + "reunion_commerciale" + File.separator;
      }

      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.documentResultatImpressionItems.clear();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            if (var3[var4].endsWith("jasper")) {
               String var5 = var3[var4].substring(0, var3[var4].indexOf("."));
               this.documentResultatImpressionItems.add(new SelectItem(var5));
            }
         }
      }

   }

   public void recupererModeleListeResultat() {
      String var1 = "";
      if (this.nature == 5) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "liste" + File.separator + "reunion_resultat" + File.separator;
      } else if (this.nature == 120) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "liste" + File.separator + "reunion_tiers" + File.separator;
      } else if (this.nature == 121) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "liste" + File.separator + "reunion_commerciale" + File.separator;
      }

      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.listeResultatImpressionItems.clear();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            if (var3[var4].endsWith("jasper")) {
               String var5 = var3[var4].substring(0, var3[var4].indexOf("."));
               this.listeResultatImpressionItems.add(new SelectItem(var5));
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

   public String calculeCheminRapportConvocation(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "document" + File.separator + "reunion_convocation" + File.separator;
      return var2;
   }

   public String calculeCheminRapportCompteRendu(String var1) {
      String var2 = "";
      if (this.nature == 5) {
         var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "document" + File.separator + "reunion_resultat" + File.separator;
      } else if (this.nature == 120) {
         var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "document" + File.separator + "reunion_tiers" + File.separator;
      } else if (this.nature == 121) {
         var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "document" + File.separator + "reunion_commerciale" + File.separator;
      }

      return var2;
   }

   public String calculeCheminSousRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "sous_rapport" + File.separator;
      return var2;
   }

   public String calculeImageFond(String var1) throws HibernateException, NamingException {
      String var2 = "";
      File var3 = new File(this.calculeCheminSousRapport(var1) + "formatReunion.jpg");
      if (var3.exists()) {
         var2 = "formatReunion.jpg";
      }

      return var2;
   }

   public JRBeanCollectionDataSource calculeImpressionCommun() throws IOException {
      ArrayList var1 = new ArrayList();
      if (this.reunionEntete != null) {
         String var2 = "";
         String var3 = "";
         String var4 = "";
         String var5 = "";
         if (this.lesReunionPresence.size() != 0) {
            for(int var6 = 0; var6 < this.lesReunionPresence.size(); ++var6) {
               this.reunionPresence = (ReunionPresence)this.lesReunionPresence.get(var6);
               if (this.reunionPresence.isReupreConvoquer()) {
                  if (var2 != null && !var2.isEmpty()) {
                     if (this.reunionPresence.getReuprePrenomUser() != null && !this.reunionPresence.getReuprePrenomUser().isEmpty()) {
                        var2 = var2 + "\n" + this.reunionPresence.getReupreNomUser() + " " + this.reunionPresence.getReuprePrenomUser();
                     } else {
                        var2 = var2 + "\n" + this.reunionPresence.getReupreNomUser();
                     }
                  } else if (this.reunionPresence.getReuprePrenomUser() != null && !this.reunionPresence.getReuprePrenomUser().isEmpty()) {
                     var2 = this.reunionPresence.getReupreNomUser() + " " + this.reunionPresence.getReuprePrenomUser();
                  } else {
                     var2 = this.reunionPresence.getReupreNomUser();
                  }

                  if (this.reunionPresence.isReupreAbsentInterdit()) {
                     var2 = var2 + "(Présence OBLIGATOIRE)";
                  }
               }

               if (this.reunionPresence.isReuprePresent()) {
                  if (var3 != null && !var3.isEmpty()) {
                     if (this.reunionPresence.getReuprePrenomUser() != null && !this.reunionPresence.getReuprePrenomUser().isEmpty()) {
                        var3 = var3 + "\n" + this.reunionPresence.getReupreNomUser() + " " + this.reunionPresence.getReuprePrenomUser();
                     } else {
                        var3 = var3 + "\n" + this.reunionPresence.getReupreNomUser();
                     }
                  } else if (this.reunionPresence.getReuprePrenomUser() != null && !this.reunionPresence.getReuprePrenomUser().isEmpty()) {
                     var3 = this.reunionPresence.getReupreNomUser() + " " + this.reunionPresence.getReuprePrenomUser();
                  } else {
                     var3 = this.reunionPresence.getReupreNomUser();
                  }
               }

               if (this.reunionPresence.isReuprePresent()) {
                  if (var5 != null && !var5.isEmpty()) {
                     if (this.reunionPresence.getReuprePrenomUser() != null && !this.reunionPresence.getReuprePrenomUser().isEmpty()) {
                        var5 = var5 + "\n" + this.reunionPresence.getReupreNomUser() + " " + this.reunionPresence.getReuprePrenomUser() + " : CA Facture : " + this.utilNombre.beginSimple(this.reunionPresence.getReupreCaFa(), this.structureLog.getStrdevise());
                     } else {
                        var5 = var5 + "\n" + this.reunionPresence.getReupreNomUser() + " : CA Facture : " + this.utilNombre.beginSimple(this.reunionPresence.getReupreCaFa(), this.structureLog.getStrdevise());
                     }
                  } else if (this.reunionPresence.getReuprePrenomUser() != null && !this.reunionPresence.getReuprePrenomUser().isEmpty()) {
                     var5 = this.reunionPresence.getReupreNomUser() + " " + this.reunionPresence.getReuprePrenomUser() + " : CA Facture : " + this.utilNombre.beginSimple(this.reunionPresence.getReupreCaFa(), this.structureLog.getStrdevise());
                  } else {
                     var5 = this.reunionPresence.getReupreNomUser() + " : CA Facture : " + this.utilNombre.beginSimple(this.reunionPresence.getReupreCaFa(), this.structureLog.getStrdevise());
                  }
               }

               if (this.reunionPresence.isReupreConvoquer() && !this.reunionPresence.isReuprePresent()) {
                  if (var4 != null && !var4.isEmpty()) {
                     if (this.reunionPresence.getReuprePrenomUser() != null && !this.reunionPresence.getReuprePrenomUser().isEmpty()) {
                        var4 = var4 + "\n" + this.reunionPresence.getReupreNomUser() + " " + this.reunionPresence.getReuprePrenomUser();
                     } else {
                        var4 = var4 + "\n" + this.reunionPresence.getReupreNomUser();
                     }
                  } else if (this.reunionPresence.getReuprePrenomUser() != null && !this.reunionPresence.getReuprePrenomUser().isEmpty()) {
                     var4 = this.reunionPresence.getReupreNomUser() + " " + this.reunionPresence.getReuprePrenomUser();
                  } else {
                     var4 = this.reunionPresence.getReupreNomUser();
                  }

                  if (this.reunionPresence.getReupreMotif() != null && !this.reunionPresence.getReupreMotif().isEmpty()) {
                     var4 = var4 + " " + this.reunionPresence.getReupreMotif();
                  }
               }
            }
         }

         this.reunionEntete.setListeConvocation(var2);
         this.reunionEntete.setListeParticipant(var3);
         this.reunionEntete.setListeAbsent(var4);
         this.reunionEntete.setListeAnalyse(var5);
         String var10 = "";
         if (this.lesReunionActionOld.size() != 0) {
            for(int var7 = 0; var7 < this.lesReunionActionOld.size(); ++var7) {
               this.reunionAction = (ReunionAction)this.lesReunionActionOld.get(var7);
               if (var10 != null && !var10.isEmpty()) {
                  var10 = var10 + "\n-----\n==> ACTION N°" + (var7 + 1) + "\n";
               } else {
                  var10 = "==> ACTION N°" + (var7 + 1) + "\n";
               }

               var10 = var10 + "Qui: " + this.reunionAction.getReuactNomUser() + "\n";
               if (this.reunionAction.getReuactQuoi() != null && !this.reunionAction.getReuactQuoi().isEmpty()) {
                  var10 = var10 + "Quoi: " + this.reunionAction.getReuactQuoi() + "\n";
               }

               if (this.reunionAction.getReuactQuand() != null && !this.reunionAction.getReuactQuand().isEmpty()) {
                  var10 = var10 + "Quand: " + this.reunionAction.getReuactQuand() + "\n";
               }

               if (this.reunionAction.getReuactDate() != null) {
                  var10 = var10 + "Deadline: " + this.reunionAction.getReuactDate() + "\n";
               }

               if (this.reunionAction.getReuactOu() != null && !this.reunionAction.getReuactOu().isEmpty()) {
                  var10 = var10 + "Ou: " + this.reunionAction.getReuactOu() + "\n";
               }

               if (this.reunionAction.getReuactEtat() >= 0) {
                  if (this.reunionAction.getReuactEtat() == 1) {
                     var10 = var10 + "Action traitée avec succès\n";
                  } else if (this.reunionAction.getReuactEtat() == 2) {
                     var10 = var10 + "Action traitée avec échec\n";
                  } else if (this.reunionAction.getReuactEtat() == 3) {
                     var10 = var10 + "Action non traitée\n";
                  } else if (this.reunionAction.getReuactEtat() == 3) {
                     var10 = var10 + "Action non traitée/annulée\n";
                  } else if (this.reunionAction.getReuactEtat() == 4) {
                     var10 = var10 + "Action reportée\n";
                  }

                  if (this.reunionAction.getReuactObsExecution() != null && !this.reunionAction.getReuactObsExecution().isEmpty()) {
                     var10 = var10 + "Commentaire: " + this.reunionAction.getReuactObsExecution() + "\n";
                  }
               }
            }
         }

         this.reunionEntete.setListeActionOld(var10);
         String var11 = "";
         if (this.lesReunionActionNew.size() != 0) {
            for(int var8 = 0; var8 < this.lesReunionActionNew.size(); ++var8) {
               this.reunionAction = (ReunionAction)this.lesReunionActionNew.get(var8);
               if (var11 != null && !var11.isEmpty()) {
                  var11 = var11 + "\n-----\nAction N°" + var8 + "\n";
               } else {
                  var11 = "Action N°" + var8 + "\n";
               }

               var11 = var11 + "Qui: " + this.reunionAction.getReuactNomUser() + "\n";
               if (this.reunionAction.getReuactQuoi() != null && !this.reunionAction.getReuactQuoi().isEmpty()) {
                  var11 = var11 + "Quoi: " + this.reunionAction.getReuactQuoi() + "\n";
               }

               if (this.reunionAction.getReuactQuand() != null && !this.reunionAction.getReuactQuand().isEmpty()) {
                  var11 = var11 + "Quand: " + this.reunionAction.getReuactQuand() + "\n";
               }

               if (this.reunionAction.getReuactDate() != null) {
                  var11 = var11 + "Deadline: " + this.reunionAction.getReuactDate() + "\n";
               }

               if (this.reunionAction.getReuactOu() != null && !this.reunionAction.getReuactOu().isEmpty()) {
                  var11 = var11 + "Ou: " + this.reunionAction.getReuactOu() + "\n";
               }
            }
         }

         this.reunionEntete.setListeActionNew(var11);
         var1.add(this.reunionEntete);
      }

      JRBeanCollectionDataSource var9 = new JRBeanCollectionDataSource(var1);
      return var9;
   }

   public boolean majDateImpression(String var1) throws HibernateException, NamingException {
      boolean var2 = false;
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReunionEntete");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         if (this.reunionEntete.getReuDateImp() != null) {
            var2 = true;
         }

         this.reunionEntete.setReuDateImp(new Date());
         if (this.reunionEntete.getReuEtat() == 0 && this.reunionEntete.getReuEtatVal() == 0 && this.usersChrono.getUsrchrValidation() == 0) {
            this.reunionEntete.setReuEtat(1);
         }

         this.reunionEntete.setReuModeleImp(var1);
         this.reunionEntete = this.reunionEnteteDao.modif(this.reunionEntete, var3);
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
            var1.setEntete("Impression réunion");
            if (this.nature == 5) {
               if (this.reunionEntete.getReuEtat() == 0) {
                  var1.setCheminRapport(this.calculeCheminRapportConvocation("structure" + this.structureLog.getStrid()));
               } else {
                  var1.setCheminRapport(this.calculeCheminRapportCompteRendu("structure" + this.structureLog.getStrid()));
               }
            } else if (this.nature == 120) {
               var1.setCheminRapport(this.calculeCheminRapportCompteRendu("structure" + this.structureLog.getStrid()));
            } else if (this.nature == 121) {
               var1.setCheminRapport(this.calculeCheminRapportCompteRendu("structure" + this.structureLog.getStrid()));
            }

            var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid()));
            var1.setDuplicata("" + var11);
            var1.setFormat(var5);
            var1.setEmetteur(var6);
            var1.setDestinataire(var7);
            var1.setDestinataireCC(var8);
            var1.setDestinataireCCI(var9);
            var1.setCorpsMail(var10);
            var1.setIdResponsable(this.reunionEntete.getReuIdPresident());
            var1.setTiersSelectionne((Tiers)null);
            var1.setNature(this.nature);
            var1.setId_doc(this.reunionEntete.getReuId());
            var1.setParc((Parc)null);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      } else if (var4 != null && !var4.isEmpty()) {
         var1.setRapport(var4);
         var1.setEntete("Impression de la liste des réunions");
         if (this.reunionEntete.getReuEtat() == 0) {
            var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "reunion" + File.separator + "liste" + File.separator + "reunion_convocation" + File.separator);
         } else {
            var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "reunion" + File.separator + "liste" + File.separator + "reunion_resultat" + File.separator);
         }

         var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "reunion" + File.separator + "sous_rapport" + File.separator);
         var1.setFormat(var5);
         var1.setEmetteur(var6);
         var1.setDestinataire(var7);
         var1.setDestinataireCC(var8);
         var1.setDestinataireCCI(var9);
         var1.setCorpsMail(var10);
         var1.setIdResponsable(0L);
         var1.setTiersSelectionne((Tiers)null);
         var1.setNature(this.nature);
         var1.setId_doc(0L);
         JRBeanCollectionDataSource var12 = new JRBeanCollectionDataSource(this.lesReunionEntetes);
         var1.setjRBeanCollectionDataSource(var12);
         var1.setBaseLog(this.baseLog);
         var1.setStructureLog(this.structureLog);
         var1.setUsersLog(this.usersLog);
         var1.imprimeRapport();
      }

   }

   public void envoieConvocation() throws HibernateException, NamingException, IOException, SQLException, JRException, ClassNotFoundException, MalformedURLException, Exception {
      if (this.reunionEntete != null && this.reunionEntete.getReuEtat() == 0 && this.reunionEntete.getReuModeleImp() != null && !this.reunionEntete.getReuModeleImp().isEmpty() && this.lesReunionPresence.size() != 0) {
         UtilPrint var1 = new UtilPrint(this.utilInitHibernate);
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReunionEntete");
         String var3 = "";
         new Users();

         for(int var5 = 0; var5 < this.lesReunionPresence.size(); ++var5) {
            this.reunionPresence = (ReunionPresence)this.lesReunionPresence.get(var5);
            if (this.reunionPresence.isReupreConvoquer() || this.reunionPresence.isReuprePresent()) {
               Users var4 = this.userDao.selectByIdUsers(this.reunionPresence.getReupreIdUser(), var2);
               if (var4 != null && var4.getUsrMail() != null && !var4.getUsrMail().isEmpty()) {
                  if (var3 != null && !var3.isEmpty()) {
                     var3 = var3 + "," + var4.getUsrMail();
                  } else {
                     var3 = var4.getUsrMail();
                  }
               }
            }
         }

         Transaction var12 = null;

         try {
            var12 = var2.beginTransaction();
            if (var3 != null && !var3.isEmpty()) {
               this.reunionEntete.setReuDateEnvoie(new Date());
               this.reunionEntete = this.reunionEnteteDao.modif(this.reunionEntete, var2);
               var12.commit();
            }
         } catch (HibernateException var10) {
            if (var12 != null) {
               var12.rollback();
            }

            throw var10;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         if (var3 != null && !var3.isEmpty()) {
            var1.setjRBeanCollectionDataSource(this.calculeImpressionCommun());
            var1.setRapport(this.reunionEntete.getReuModeleImp());
            var1.setEntete("Impression convocation");
            var1.setCheminRapport(this.calculeCheminRapportConvocation("structure" + this.structureLog.getStrid()));
            var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid()));
            var1.setFormat("MAIL");
            var1.setEmetteur("infos@e-pegase.biz");
            var1.setDestinataire(var3);
            var1.setDestinataireCC("");
            var1.setDestinataireCCI("");
            var1.setIdResponsable(this.reunionEntete.getReuIdPresident());
            var1.setTiersSelectionne((Tiers)null);
            var1.setNature(this.nature);
            var1.setId_doc(this.reunionEntete.getReuId());
            var1.setParc((Parc)null);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      }

   }

   public void envoieCompteRendu() throws HibernateException, NamingException, IOException, SQLException, JRException, ClassNotFoundException, MalformedURLException, Exception {
      if (this.reunionEntete != null && this.reunionEntete.getReuEtat() >= 1 && this.reunionEntete.getReuModeleCRImp() != null && !this.reunionEntete.getReuModeleCRImp().isEmpty() && this.lesReunionPresence.size() != 0) {
         UtilPrint var1 = new UtilPrint(this.utilInitHibernate);
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReunionEntete");
         String var3 = "";
         new Users();

         for(int var5 = 0; var5 < this.lesReunionPresence.size(); ++var5) {
            this.reunionPresence = (ReunionPresence)this.lesReunionPresence.get(var5);
            if (this.reunionPresence.isReupreConvoquer() || this.reunionPresence.isReuprePresent()) {
               Users var4 = this.userDao.selectByIdUsers(this.reunionPresence.getReupreIdUser(), var2);
               if (var4 != null && var4.getUsrMail() != null && !var4.getUsrMail().isEmpty()) {
                  if (var3 != null && !var3.isEmpty()) {
                     var3 = var3 + "," + var4.getUsrMail();
                  } else {
                     var3 = var4.getUsrMail();
                  }
               }
            }
         }

         Transaction var12 = null;

         try {
            var12 = var2.beginTransaction();
            if (var3 != null && !var3.isEmpty()) {
               this.reunionEntete.setReuDateCRImp(new Date());
               this.reunionEntete = this.reunionEnteteDao.modif(this.reunionEntete, var2);
               var12.commit();
            }
         } catch (HibernateException var10) {
            if (var12 != null) {
               var12.rollback();
            }

            throw var10;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         if (var3 != null && !var3.isEmpty()) {
            var1.setjRBeanCollectionDataSource(this.calculeImpressionCommun());
            var1.setRapport(this.reunionEntete.getReuModeleCRImp());
            var1.setEntete("Impression compte rendu");
            var1.setCheminRapport(this.calculeCheminRapportCompteRendu("structure" + this.structureLog.getStrid()));
            var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid()));
            var1.setFormat("MAIL");
            var1.setEmetteur("infos@e-pegase.biz");
            var1.setDestinataire(var3);
            var1.setDestinataireCC("");
            var1.setDestinataireCCI("");
            var1.setIdResponsable(this.reunionEntete.getReuIdPresident());
            var1.setTiersSelectionne((Tiers)null);
            var1.setNature(this.nature);
            var1.setId_doc(this.reunionEntete.getReuId());
            var1.setParc((Parc)null);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      }

   }

   public void envoieCompteRenduCommercial() throws HibernateException, NamingException, IOException, SQLException, JRException, ClassNotFoundException, MalformedURLException, Exception {
      if (this.reunionEntete != null && this.reunionEntete.getReuEtat() >= 1 && this.reunionEntete.getReuModeleCRImp() != null && !this.reunionEntete.getReuModeleCRImp().isEmpty() && this.lesReunionPresence.size() != 0) {
         UtilPrint var1 = new UtilPrint(this.utilInitHibernate);
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReunionEntete");
         String var3 = "";
         new Users();

         for(int var5 = 0; var5 < this.lesReunionPresence.size(); ++var5) {
            this.reunionPresence = (ReunionPresence)this.lesReunionPresence.get(var5);
            if (this.reunionPresence.isReupreConvoquer() || this.reunionPresence.isReuprePresent()) {
               Users var4 = this.userDao.selectByIdUsers(this.reunionPresence.getReupreIdUser(), var2);
               if (var4 != null && var4.getUsrMail() != null && !var4.getUsrMail().isEmpty()) {
                  if (var3 != null && !var3.isEmpty()) {
                     var3 = var3 + "," + var4.getUsrMail();
                  } else {
                     var3 = var4.getUsrMail();
                  }
               }
            }
         }

         Transaction var12 = null;

         try {
            var12 = var2.beginTransaction();
            if (var3 != null && !var3.isEmpty()) {
               this.reunionEntete.setReuDateCRImp(new Date());
               this.reunionEntete = this.reunionEnteteDao.modif(this.reunionEntete, var2);
               var12.commit();
            }
         } catch (HibernateException var10) {
            if (var12 != null) {
               var12.rollback();
            }

            throw var10;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         if (var3 != null && !var3.isEmpty()) {
            var1.setjRBeanCollectionDataSource(this.calculeImpressionCommun());
            var1.setRapport(this.reunionEntete.getReuModeleCRImp());
            var1.setEntete("Impression compte rendu");
            var1.setCheminRapport(this.calculeCheminRapportCompteRendu("structure" + this.structureLog.getStrid()));
            var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid()));
            var1.setFormat("MAIL");
            var1.setEmetteur("infos@e-pegase.biz");
            var1.setDestinataire(var3);
            var1.setDestinataireCC("");
            var1.setDestinataireCCI("");
            var1.setIdResponsable(this.reunionEntete.getReuIdPresident());
            var1.setTiersSelectionne((Tiers)null);
            var1.setNature(this.nature);
            var1.setId_doc(this.reunionEntete.getReuId());
            var1.setParc((Parc)null);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      }

   }

   public String getUrlIpProd() {
      return StaticModePegase.getUrlIp();
   }

   public DataModel getDataModelReunion() {
      return this.dataModelReunion;
   }

   public void setDataModelReunion(DataModel var1) {
      this.dataModelReunion = var1;
   }

   public String getInpActivite() {
      return this.inpActivite;
   }

   public void setInpActivite(String var1) {
      this.inpActivite = var1;
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

   public String getInpService() {
      return this.inpService;
   }

   public void setInpService(String var1) {
      this.inpService = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
   }

   public ReunionEntete getReunionEntete() {
      return this.reunionEntete;
   }

   public void setReunionEntete(ReunionEntete var1) {
      this.reunionEntete = var1;
   }

   public int getVar_action() {
      return this.var_action;
   }

   public void setVar_action(int var1) {
      this.var_action = var1;
   }

   public int getVar_nb_ligne() {
      return this.var_nb_ligne;
   }

   public void setVar_nb_ligne(int var1) {
      this.var_nb_ligne = var1;
   }

   public DataModel getDatamodelResponsable() {
      return this.datamodelResponsable;
   }

   public void setDatamodelResponsable(DataModel var1) {
      this.datamodelResponsable = var1;
   }

   public boolean isVisibiliteBton() {
      return this.visibiliteBton;
   }

   public void setVisibiliteBton(boolean var1) {
      this.visibiliteBton = var1;
   }

   public int getInpType() {
      return this.inpType;
   }

   public void setInpType(int var1) {
      this.inpType = var1;
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

   public boolean isAfficheButtonActionNew() {
      return this.afficheButtonActionNew;
   }

   public void setAfficheButtonActionNew(boolean var1) {
      this.afficheButtonActionNew = var1;
   }

   public DataModel getDataModelActionNew() {
      return this.dataModelActionNew;
   }

   public void setDataModelActionNew(DataModel var1) {
      this.dataModelActionNew = var1;
   }

   public DataModel getDataModelActionOld() {
      return this.dataModelActionOld;
   }

   public void setDataModelActionOld(DataModel var1) {
      this.dataModelActionOld = var1;
   }

   public boolean isShowModalPanelActionNew() {
      return this.showModalPanelActionNew;
   }

   public void setShowModalPanelActionNew(boolean var1) {
      this.showModalPanelActionNew = var1;
   }

   public ReunionAction getReunionAction() {
      return this.reunionAction;
   }

   public void setReunionAction(ReunionAction var1) {
      this.reunionAction = var1;
   }

   public String getVar_qui() {
      return this.var_qui;
   }

   public void setVar_qui(String var1) {
      this.var_qui = var1;
   }

   public String getVar_president() {
      return this.var_president;
   }

   public void setVar_president(String var1) {
      this.var_president = var1;
   }

   public String getVar_secretaire() {
      return this.var_secretaire;
   }

   public void setVar_secretaire(String var1) {
      this.var_secretaire = var1;
   }

   public DataModel getDataModelPresence() {
      return this.dataModelPresence;
   }

   public void setDataModelPresence(DataModel var1) {
      this.dataModelPresence = var1;
   }

   public List getLesUsers() {
      return this.lesUsers;
   }

   public void setLesUsers(List var1) {
      this.lesUsers = var1;
   }

   public List getMesHeuresDebItems() {
      return this.mesHeuresDebItems;
   }

   public void setMesHeuresDebItems(List var1) {
      this.mesHeuresDebItems = var1;
   }

   public List getMesHeuresFinItems() {
      return this.mesHeuresFinItems;
   }

   public void setMesHeuresFinItems(List var1) {
      this.mesHeuresFinItems = var1;
   }

   public List getMesMinutesDebItems() {
      return this.mesMinutesDebItems;
   }

   public void setMesMinutesDebItems(List var1) {
      this.mesMinutesDebItems = var1;
   }

   public List getMesMinutesFinItems() {
      return this.mesMinutesFinItems;
   }

   public void setMesMinutesFinItems(List var1) {
      this.mesMinutesFinItems = var1;
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

   public List getMesPresidentsItem() {
      return this.mesPresidentsItem;
   }

   public void setMesPresidentsItem(List var1) {
      this.mesPresidentsItem = var1;
   }

   public List getMesSecretairesItem() {
      return this.mesSecretairesItem;
   }

   public void setMesSecretairesItem(List var1) {
      this.mesSecretairesItem = var1;
   }

   public List getMesUsersPresentsItem() {
      return this.mesUsersPresentsItem;
   }

   public void setMesUsersPresentsItem(List var1) {
      this.mesUsersPresentsItem = var1;
   }

   public boolean isShowModalPanelActionOld() {
      return this.showModalPanelActionOld;
   }

   public void setShowModalPanelActionOld(boolean var1) {
      this.showModalPanelActionOld = var1;
   }

   public boolean isAfficheButtonActionOld() {
      return this.afficheButtonActionOld;
   }

   public void setAfficheButtonActionOld(boolean var1) {
      this.afficheButtonActionOld = var1;
   }

   public List getDocumentConvocationImpressionItems() {
      return this.documentConvocationImpressionItems;
   }

   public void setDocumentConvocationImpressionItems(List var1) {
      this.documentConvocationImpressionItems = var1;
   }

   public List getDocumentResultatImpressionItems() {
      return this.documentResultatImpressionItems;
   }

   public void setDocumentResultatImpressionItems(List var1) {
      this.documentResultatImpressionItems = var1;
   }

   public List getListeConvocationImpressionItems() {
      return this.listeConvocationImpressionItems;
   }

   public void setListeConvocationImpressionItems(List var1) {
      this.listeConvocationImpressionItems = var1;
   }

   public List getListeResultatImpressionItems() {
      return this.listeResultatImpressionItems;
   }

   public void setListeResultatImpressionItems(List var1) {
      this.listeResultatImpressionItems = var1;
   }

   public DataModel getDataModelActifs() {
      return this.dataModelActifs;
   }

   public void setDataModelActifs(DataModel var1) {
      this.dataModelActifs = var1;
   }

   public boolean isShowModalPanelVente() {
      return this.showModalPanelVente;
   }

   public void setShowModalPanelVente(boolean var1) {
      this.showModalPanelVente = var1;
   }

   public DataModel getDataModelLesCommandes() {
      return this.dataModelLesCommandes;
   }

   public void setDataModelLesCommandes(DataModel var1) {
      this.dataModelLesCommandes = var1;
   }

   public DataModel getDataModelLesDevis() {
      return this.dataModelLesDevis;
   }

   public void setDataModelLesDevis(DataModel var1) {
      this.dataModelLesDevis = var1;
   }

   public DataModel getDataModelLesFactures() {
      return this.dataModelLesFactures;
   }

   public void setDataModelLesFactures(DataModel var1) {
      this.dataModelLesFactures = var1;
   }

   public DataModel getDataModelLesLivraison() {
      return this.dataModelLesLivraison;
   }

   public void setDataModelLesLivraison(DataModel var1) {
      this.dataModelLesLivraison = var1;
   }

   public DataModel getDataModelLesNdb() {
      return this.dataModelLesNdb;
   }

   public void setDataModelLesNdb(DataModel var1) {
      this.dataModelLesNdb = var1;
   }

   public DataModel getDataModelLesRetours() {
      return this.dataModelLesRetours;
   }

   public void setDataModelLesRetours(DataModel var1) {
      this.dataModelLesRetours = var1;
   }

   public DataModel getDataModelesAvoirs() {
      return this.dataModelesAvoirs;
   }

   public void setDataModelesAvoirs(DataModel var1) {
      this.dataModelesAvoirs = var1;
   }

   public double getCaHt() {
      return this.caHt;
   }

   public void setCaHt(double var1) {
      this.caHt = var1;
   }

   public double getCaJour() {
      return this.caJour;
   }

   public void setCaJour(double var1) {
      this.caJour = var1;
   }

   public double getCaMoyen() {
      return this.caMoyen;
   }

   public void setCaMoyen(double var1) {
      this.caMoyen = var1;
   }

   public double getCaTrf() {
      return this.caTrf;
   }

   public void setCaTrf(double var1) {
      this.caTrf = var1;
   }

   public double getClientMoyen() {
      return this.clientMoyen;
   }

   public void setClientMoyen(double var1) {
      this.clientMoyen = var1;
   }

   public int getNbClients() {
      return this.nbClients;
   }

   public void setNbClients(int var1) {
      this.nbClients = var1;
   }

   public int getNbDoc() {
      return this.nbDoc;
   }

   public void setNbDoc(int var1) {
      this.nbDoc = var1;
   }

   public int getNbJour() {
      return this.nbJour;
   }

   public void setNbJour(int var1) {
      this.nbJour = var1;
   }

   public int getNbTrf() {
      return this.nbTrf;
   }

   public void setNbTrf(int var1) {
      this.nbTrf = var1;
   }

   public float getTauxClient() {
      return this.tauxClient;
   }

   public void setTauxClient(float var1) {
      this.tauxClient = var1;
   }

   public float getTauxJour() {
      return this.tauxJour;
   }

   public void setTauxJour(float var1) {
      this.tauxJour = var1;
   }

   public float getTauxTrf() {
      return this.tauxTrf;
   }

   public void setTauxTrf(float var1) {
      this.tauxTrf = var1;
   }

   public DataModel getDataModeLesRdv() {
      return this.dataModeLesRdv;
   }

   public void setDataModeLesRdv(DataModel var1) {
      this.dataModeLesRdv = var1;
   }

   public boolean isShowModalPanelRdv() {
      return this.showModalPanelRdv;
   }

   public void setShowModalPanelRdv(boolean var1) {
      this.showModalPanelRdv = var1;
   }

   public DataModel getDataModelRaportRdv() {
      return this.dataModelRaportRdv;
   }

   public void setDataModelRaportRdv(DataModel var1) {
      this.dataModelRaportRdv = var1;
   }

   public DataModel getDatamodelTiers() {
      return this.datamodelTiers;
   }

   public void setDatamodelTiers(DataModel var1) {
      this.datamodelTiers = var1;
   }

   public boolean isShowModalPanelTiers() {
      return this.showModalPanelTiers;
   }

   public void setShowModalPanelTiers(boolean var1) {
      this.showModalPanelTiers = var1;
   }

   public List getLesContactsItems() {
      return this.lesContactsItems;
   }

   public void setLesContactsItems(List var1) {
      this.lesContactsItems = var1;
   }

   public String getVar_contact() {
      return this.var_contact;
   }

   public void setVar_contact(String var1) {
      this.var_contact = var1;
   }

   public String getVar_backOffice() {
      return this.var_backOffice;
   }

   public void setVar_backOffice(String var1) {
      this.var_backOffice = var1;
   }

   public String getVar_frontOffice() {
      return this.var_frontOffice;
   }

   public void setVar_frontOffice(String var1) {
      this.var_frontOffice = var1;
   }

   public String getInpTiers() {
      return this.inpTiers;
   }

   public void setInpTiers(String var1) {
      this.inpTiers = var1;
   }

   public String getNomAgentAnalyse() {
      return this.nomAgentAnalyse;
   }

   public void setNomAgentAnalyse(String var1) {
      this.nomAgentAnalyse = var1;
   }

   public double getMoyenneGlobale() {
      return this.moyenneGlobale;
   }

   public void setMoyenneGlobale(double var1) {
      this.moyenneGlobale = var1;
   }

   public int getNbDocGlobal() {
      return this.nbDocGlobal;
   }

   public void setNbDocGlobal(int var1) {
      this.nbDocGlobal = var1;
   }

   public double getTotalGlobalHt() {
      return this.totalGlobalHt;
   }

   public void setTotalGlobalHt(double var1) {
      this.totalGlobalHt = var1;
   }

   public List getMesAgentsPresentsItem() {
      return this.mesAgentsPresentsItem;
   }

   public void setMesAgentsPresentsItem(List var1) {
      this.mesAgentsPresentsItem = var1;
   }

   public double getEcartHt() {
      return this.ecartHt;
   }

   public void setEcartHt(double var1) {
      this.ecartHt = var1;
   }

   public double getObjectifHt() {
      return this.objectifHt;
   }

   public void setObjectifHt(double var1) {
      this.objectifHt = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public int getSansSources() {
      return this.sansSources;
   }

   public void setSansSources(int var1) {
      this.sansSources = var1;
   }

   public Habilitation getHabilitation() {
      return this.habilitation;
   }

   public void setHabilitation(Habilitation var1) {
      this.habilitation = var1;
   }

   public UsersChrono getUsersChrono() {
      return this.usersChrono;
   }

   public void setUsersChrono(UsersChrono var1) {
      this.usersChrono = var1;
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
