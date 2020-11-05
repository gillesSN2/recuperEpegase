package com.epegase.forms.accueil;

import com.epegase.systeme.classe.CommandeEnteteAchats;
import com.epegase.systeme.classe.CommandeEnteteVentes;
import com.epegase.systeme.classe.CommandeLigneAchats;
import com.epegase.systeme.classe.CommandeLigneVentes;
import com.epegase.systeme.classe.Contacts;
import com.epegase.systeme.classe.Ecritures;
import com.epegase.systeme.classe.FactureEnteteAchats;
import com.epegase.systeme.classe.FactureEnteteVentes;
import com.epegase.systeme.classe.FactureLigneAchats;
import com.epegase.systeme.classe.FactureLigneVentes;
import com.epegase.systeme.classe.Reglements;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.EtatDocument;
import com.epegase.systeme.dao.CommandeEnteteAchatsDao;
import com.epegase.systeme.dao.CommandeEnteteVentesDao;
import com.epegase.systeme.dao.ContactDao;
import com.epegase.systeme.dao.EcrituresDao;
import com.epegase.systeme.dao.FactureEnteteAchatsDao;
import com.epegase.systeme.dao.FactureEnteteVentesDao;
import com.epegase.systeme.dao.ReglementsDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.LireLesoptionsCompta;
import com.epegase.systeme.xml.OptionComptabilite;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.naming.NamingException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class FormGuest implements Serializable {
   private int typeVente;
   private String urlExplorateur;
   private int typePlateForme;
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private UtilDate utilDate = new UtilDate();
   private EtatDocument etatDocument = new EtatDocument();
   private int var_nb_max = 100;
   private String pageIndex;
   private double montantTtc = 0.0D;
   private double montantSolde = 0.0D;
   private double montantReglement = 0.0D;
   private double montantTtcElmt = 0.0D;
   private double montantSoldeElmt = 0.0D;
   private double montantReglementElmt = 0.0D;
   private int var_nb_ligne = 0;
   private String var_libcondest = "Contact";
   private Tiers tiers = new Tiers();
   private TiersDao tiersDao;
   private Date inpDu = null;
   private Date inpAu = null;
   private String inpNum = "";
   private String inpNumBCC = "";
   private int inpEtat = 0;
   private String inpService;
   private String inpSerie = "100";
   private String inpCat = "100";
   private List mesEtatsItems = new ArrayList();
   private List mesServicesItems = new ArrayList();
   private boolean visibiliteBton = false;
   private int typeTiers;
   private String refTiers;
   private int typeDocument;
   private Contacts contacts;
   private ContactDao contactDao;
   private transient DataModel datamodelContact;
   private List listContacts;
   private CommandeEnteteVentes commandeEnteteVentes;
   private CommandeLigneVentes commandeLigneVentes;
   private CommandeEnteteVentesDao commandeEnteteVentesDao;
   private transient DataModel datamodelCommandesVentes;
   private List listCommandesVentes;
   private CommandeEnteteAchats commandeEnteteAchats;
   private CommandeLigneAchats commandeLigneAchats;
   private CommandeEnteteAchatsDao commandeEnteteAchatsDao;
   private transient DataModel datamodelCommandesAchats;
   private List listComandeAchats;
   private FactureEnteteVentes factureEnteteVentes;
   private FactureLigneVentes factureLigneVentes;
   private FactureEnteteVentesDao factureEnteteVentesDao;
   private transient DataModel datamodelFacturesVentes;
   private List listFacturesVentes;
   private FactureEnteteAchats factureEnteteAchats;
   private FactureLigneAchats factureLigneAchats;
   private FactureEnteteAchatsDao factureEnteteAchatsDao;
   private transient DataModel datamodelFacturesAchats;
   private List listFacturesAchats;
   private Reglements reglements;
   private ReglementsDao reglementsDao;
   private transient DataModel datamodelReglements;
   private List listReglements;
   private Ecritures ecritures;
   private EcrituresDao ecrituresDao;
   private transient DataModel datamodelExtraits;
   private List listExtraits;
   private String compte;
   private OptionComptabilite optionComptabilite;
   private boolean showModalPanelPrint = false;
   private String format;
   private UtilPrint utilPrint;

   public FormGuest() throws UnknownHostException {
   }

   public void InstancesDaoUtilses() {
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
   }

   public void guest(Session var1, String var2, int var3) throws HibernateException, NamingException, IOException {
      this.urlExplorateur = var2;
      this.typePlateForme = var3;
   }

   public String getUrlIpProd() {
      return StaticModePegase.getUrlIp();
   }

   public void recupererServiceItem(Session var1) throws HibernateException, NamingException {
      this.mesServicesItems = new ArrayList();
      ServiceDao var2 = new ServiceDao(this.baseLog, this.utilInitHibernate);
      this.mesServicesItems = var2.chargerLesServicesItems(0, false, var1);
   }

   public void iniRib(Session var1) throws ParseException, HibernateException, NamingException {
      this.typeDocument = 0;
      this.contacts = new Contacts();
      this.datamodelContact = new ListDataModel();
      this.listContacts = new ArrayList();
      this.contactDao = new ContactDao(this.baseLog, this.utilInitHibernate);
      this.visibiliteBton = false;
      String var2 = "" + ((new Date()).getYear() + 1900);
      this.inpDu = this.utilDate.stringToDateSQLLight(var2 + "-01-01");
      this.inpAu = this.utilDate.stringToDateSQLLight(var2 + "-12-31");
      this.listContacts.clear();
      this.listContacts = this.contactDao.chargerLesContactsBq(var1);
      this.datamodelContact.setWrappedData(this.listContacts);
      this.recupererServiceItem(var1);
   }

   public void selectionRib() {
      if (this.datamodelContact.isRowAvailable()) {
         this.contacts = (Contacts)this.datamodelContact.getRowData();
         this.visibiliteBton = true;
      }

   }

   public void iniCommande(Session var1) throws ParseException, HibernateException, NamingException {
      this.commandeEnteteVentes = new CommandeEnteteVentes();
      this.commandeLigneVentes = new CommandeLigneVentes();
      this.datamodelCommandesVentes = new ListDataModel();
      this.listCommandesVentes = new ArrayList();
      this.commandeEnteteAchats = new CommandeEnteteAchats();
      this.commandeLigneAchats = new CommandeLigneAchats();
      this.datamodelCommandesAchats = new ListDataModel();
      this.listComandeAchats = new ArrayList();
      this.commandeEnteteVentesDao = new CommandeEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.commandeEnteteAchatsDao = new CommandeEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.visibiliteBton = false;
      String var2 = "" + ((new Date()).getYear() + 1900);
      this.inpDu = this.utilDate.stringToDateSQLLight(var2 + "-01-01");
      this.inpAu = this.utilDate.stringToDateSQLLight(var2 + "-12-31");
      this.tiers = this.tiersDao.selectTierD(this.usersLog.getUsrIdTiersGuest(), var1);
      if (this.tiers != null) {
         this.typeTiers = Integer.parseInt(this.tiers.getTietype());
         this.refTiers = this.tiers.getTieid() + ":" + this.tiers.getTieraisonsocialenom();
         this.listCommandesVentes.clear();
         this.datamodelCommandesVentes.setWrappedData(this.listCommandesVentes);
         this.listComandeAchats.clear();
         this.datamodelCommandesAchats.setWrappedData(this.listComandeAchats);
         if (this.typeTiers == 0) {
            this.typeDocument = 1;
            this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(12, 0);
         } else {
            this.typeDocument = 2;
            this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(22, 0);
         }

         this.recupererServiceItem(var1);
      }

   }

   public void rechercheCommande() throws HibernateException, NamingException, ParseException {
      this.listCommandesVentes.clear();
      this.listComandeAchats.clear();
      double var1 = 0.0D;
      double var3 = 0.0D;
      double var5 = 0.0D;
      double var7 = 0.0D;
      this.var_nb_ligne = 0;
      String var9 = "";
      String var10 = "";
      this.montantTtcElmt = 0.0D;
      this.montantReglementElmt = 0.0D;
      this.montantSoldeElmt = 0.0D;
      this.montantTtc = 0.0D;
      this.montantReglement = 0.0D;
      this.montantSolde = 0.0D;
      if (this.inpDu != null) {
         var9 = this.utilDate.dateToStringSQLLight(this.inpDu);
      }

      if (this.inpAu != null) {
         var10 = this.utilDate.dateToStringSQLLight(this.inpAu);
      }

      if (this.inpNum != null && !this.inpNum.isEmpty()) {
         this.inpEtat = 100;
      }

      int var12;
      if (this.typeTiers == 0) {
         this.listComandeAchats = this.commandeEnteteAchatsDao.recherche((Session)null, 0L, this.inpNum, this.tiers.getTieid(), this.refTiers, this.inpEtat, this.inpSerie, this.inpCat, "100", this.inpService, 0L, 0, "100", (String)null, "100", "", var9, var10);
         if (this.listComandeAchats.size() > 0) {
            new CommandeEnteteAchats();

            for(var12 = 0; var12 < this.listComandeAchats.size(); ++var12) {
               CommandeEnteteAchats var11 = (CommandeEnteteAchats)this.listComandeAchats.get(var12);
               var1 += var11.getCmdTotTtc();
               var3 += var11.getCmdTotReglement();
               var5 += var11.getCmdTotHt();
               var7 += var11.getCmdTotTva();
            }

            this.var_nb_ligne = this.listComandeAchats.size();
         }

         this.datamodelCommandesAchats.setWrappedData(this.listComandeAchats);
      } else if (this.typeTiers == 3) {
         this.listCommandesVentes = this.commandeEnteteVentesDao.recherche((Session)null, 0L, this.getInpNum(), this.getInpNumBCC(), (String)null, this.tiers.getTieid(), this.refTiers, this.getInpEtat(), this.getInpSerie(), this.getInpCat(), "100", 0L, 0, (String)null, (String)null, (String)null, "100", "", var9, var10, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, 99);
         if (this.listCommandesVentes.size() > 0) {
            new CommandeEnteteVentes();

            for(var12 = 0; var12 < this.listCommandesVentes.size(); ++var12) {
               CommandeEnteteVentes var13 = (CommandeEnteteVentes)this.listCommandesVentes.get(var12);
               var1 += var13.getBcmTotTtc();
               var3 += var13.getBcmTotReglement();
               var5 += var13.getBcmTotHt();
               var7 += var13.getBcmTotTva();
            }

            this.var_nb_ligne = this.listCommandesVentes.size();
         }

         this.datamodelCommandesVentes.setWrappedData(this.listCommandesVentes);
      }

      this.montantTtc = var1;
      this.montantReglement = var3;
      this.montantSolde = var1 - var3;
      this.visibiliteBton = false;
   }

   public void selectionCommandeAchats() {
      if (this.datamodelCommandesAchats.isRowAvailable()) {
         this.commandeEnteteAchats = (CommandeEnteteAchats)this.datamodelCommandesAchats.getRowData();
         this.montantTtcElmt = this.commandeEnteteAchats.getCmdTotTtc();
         this.montantReglementElmt = this.commandeEnteteAchats.getCmdTotReglement();
         this.montantSoldeElmt = this.commandeEnteteAchats.getVar_reliquat();
         this.visibiliteBton = true;
      }

   }

   public void selectionCommandeVentes() {
      if (this.datamodelCommandesVentes.isRowAvailable()) {
         this.commandeEnteteVentes = (CommandeEnteteVentes)this.datamodelCommandesVentes.getRowData();
         this.montantTtcElmt = this.commandeEnteteVentes.getBcmTotTtc();
         this.montantReglementElmt = this.commandeEnteteVentes.getBcmTotReglement();
         this.montantSoldeElmt = this.commandeEnteteVentes.getVar_reliquat();
         this.visibiliteBton = true;
      }

   }

   public void iniFacture(Session var1) throws ParseException, HibernateException, NamingException {
      this.factureEnteteVentes = new FactureEnteteVentes();
      this.factureLigneVentes = new FactureLigneVentes();
      this.datamodelFacturesVentes = new ListDataModel();
      this.listFacturesVentes = new ArrayList();
      this.factureEnteteAchats = new FactureEnteteAchats();
      this.factureLigneAchats = new FactureLigneAchats();
      this.datamodelFacturesAchats = new ListDataModel();
      this.listFacturesAchats = new ArrayList();
      this.factureEnteteVentesDao = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.factureEnteteAchatsDao = new FactureEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.visibiliteBton = false;
      String var2 = "" + ((new Date()).getYear() + 1900);
      this.inpDu = this.utilDate.stringToDateSQLLight(var2 + "-01-01");
      this.inpAu = this.utilDate.stringToDateSQLLight(var2 + "-12-31");
      this.tiers = this.tiersDao.selectTierD(this.usersLog.getUsrIdTiersGuest(), var1);
      if (this.tiers != null) {
         this.typeTiers = Integer.parseInt(this.tiers.getTietype());
         this.refTiers = this.tiers.getTieid() + ":" + this.tiers.getTieraisonsocialenom();
         this.listFacturesVentes.clear();
         this.datamodelFacturesVentes.setWrappedData(this.listFacturesVentes);
         this.listFacturesAchats.clear();
         this.datamodelFacturesAchats.setWrappedData(this.listFacturesAchats);
         if (this.typeTiers == 0) {
            this.typeDocument = 3;
            this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(15, 0);
         } else {
            this.typeDocument = 4;
            this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(25, 0);
         }

         this.recupererServiceItem(var1);
      }

   }

   public void rechercheFacture() throws HibernateException, NamingException, ParseException {
      this.listFacturesVentes.clear();
      this.listFacturesAchats.clear();
      double var1 = 0.0D;
      double var3 = 0.0D;
      double var5 = 0.0D;
      double var7 = 0.0D;
      this.var_nb_ligne = 0;
      String var9 = "";
      String var10 = "";
      this.montantTtcElmt = 0.0D;
      this.montantReglementElmt = 0.0D;
      this.montantSoldeElmt = 0.0D;
      this.montantTtc = 0.0D;
      this.montantReglement = 0.0D;
      this.montantSolde = 0.0D;
      if (this.inpDu != null) {
         var9 = this.utilDate.dateToStringSQLLight(this.inpDu);
      }

      if (this.inpAu != null) {
         var10 = this.utilDate.dateToStringSQLLight(this.inpAu);
      }

      if (this.inpNum != null && !this.inpNum.isEmpty()) {
         this.inpEtat = 100;
      }

      int var12;
      if (this.typeTiers == 0) {
         this.listFacturesAchats = this.factureEnteteAchatsDao.recherche((Session)null, 0L, this.inpNum, "", 0.0D, this.tiers.getTieid(), this.refTiers, this.inpEtat, this.inpSerie, this.inpCat, "100", this.inpService, 0L, 0, "100", (String)null, "100", var9, var10, "", "");
         if (this.listFacturesAchats.size() > 0) {
            new FactureEnteteAchats();

            for(var12 = 0; var12 < this.listFacturesAchats.size(); ++var12) {
               FactureEnteteAchats var11 = (FactureEnteteAchats)this.listFacturesAchats.get(var12);
               var1 += var11.getFcfTotTtc();
               var3 += var11.getFcfTotReglement();
               var5 += var11.getFcfTotHt();
               var7 += var11.getFcfTotTva();
            }

            this.var_nb_ligne = this.listFacturesAchats.size();
         }

         this.datamodelFacturesAchats.setWrappedData(this.listFacturesAchats);
      } else if (this.typeTiers == 3) {
         this.listFacturesVentes = this.factureEnteteVentesDao.recherche((Session)null, 0, 0L, this.getInpNum(), this.getInpNumBCC(), (String)null, this.tiers.getTieid(), this.refTiers, this.getInpEtat(), this.getInpSerie(), this.getInpCat(), "100", 0L, 0, (String)null, (String)null, (String)null, "100", "", var9, var10, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null);
         if (this.listFacturesVentes.size() > 0) {
            new FactureEnteteVentes();

            for(var12 = 0; var12 < this.listFacturesVentes.size(); ++var12) {
               FactureEnteteVentes var13 = (FactureEnteteVentes)this.listFacturesVentes.get(var12);
               var1 += var13.getFacTotTtc();
               var3 += var13.getFacTotReglement();
               var5 += var13.getFacTotHt();
               var7 += var13.getFacTotTva();
            }

            this.var_nb_ligne = this.listFacturesVentes.size();
         }

         this.datamodelFacturesVentes.setWrappedData(this.listFacturesVentes);
      }

      this.montantTtc = var1;
      this.montantReglement = var3;
      this.montantSolde = var1 - var3;
      this.visibiliteBton = false;
   }

   public void selectionFactureAchats() {
      if (this.datamodelFacturesAchats.isRowAvailable()) {
         this.factureEnteteAchats = (FactureEnteteAchats)this.datamodelFacturesAchats.getRowData();
         this.montantTtcElmt = this.factureEnteteAchats.getFcfTotTtc();
         this.montantReglementElmt = this.factureEnteteAchats.getFcfTotReglement();
         this.montantSoldeElmt = this.factureEnteteAchats.getVar_reliquat();
         this.visibiliteBton = true;
      }

   }

   public void selectionFactureVentes() {
      if (this.datamodelFacturesVentes.isRowAvailable()) {
         this.factureEnteteVentes = (FactureEnteteVentes)this.datamodelFacturesVentes.getRowData();
         this.montantTtcElmt = this.factureEnteteVentes.getFacTotTtc();
         this.montantReglementElmt = this.factureEnteteVentes.getFacTotReglement();
         this.montantSoldeElmt = this.factureEnteteVentes.getVar_reliquat();
         this.visibiliteBton = true;
      }

   }

   public void iniReglement(Session var1) throws ParseException, HibernateException, NamingException {
      this.typeDocument = 5;
      this.reglements = new Reglements();
      this.datamodelReglements = new ListDataModel();
      this.listReglements = new ArrayList();
      this.reglementsDao = new ReglementsDao(this.baseLog, this.utilInitHibernate);
      this.visibiliteBton = false;
      String var2 = "" + ((new Date()).getYear() + 1900);
      this.inpDu = this.utilDate.stringToDateSQLLight(var2 + "-01-01");
      this.inpAu = this.utilDate.stringToDateSQLLight(var2 + "-12-31");
      this.tiers = this.tiersDao.selectTierD(this.usersLog.getUsrIdTiersGuest(), var1);
      if (this.tiers != null) {
         this.typeTiers = Integer.parseInt(this.tiers.getTietype());
         this.refTiers = this.tiers.getTieid() + ":" + this.tiers.getTieraisonsocialenom();
         this.listReglements.clear();
         this.datamodelReglements.setWrappedData(this.listReglements);
         this.recupererServiceItem(var1);
      }

   }

   public void rechercheReglement() throws HibernateException, NamingException, ParseException {
      this.listReglements.clear();
      double var1 = 0.0D;
      double var3 = 0.0D;
      double var5 = 0.0D;
      double var7 = 0.0D;
      this.var_nb_ligne = 0;
      String var9 = "";
      String var10 = "";
      this.montantTtcElmt = 0.0D;
      this.montantReglementElmt = 0.0D;
      this.montantSoldeElmt = 0.0D;
      this.montantTtc = 0.0D;
      this.montantReglement = 0.0D;
      this.montantSolde = 0.0D;
      if (this.inpDu != null) {
         var9 = this.utilDate.dateToStringSQLLight(this.inpDu);
      }

      if (this.inpAu != null) {
         var10 = this.utilDate.dateToStringSQLLight(this.inpAu);
      }

      if (this.inpNum != null && !this.inpNum.isEmpty()) {
         this.inpEtat = 100;
      }

      this.listReglements = this.reglementsDao.rechercheHistoTiers(this.tiers.getTieid(), var9, var10, "", (Session)null);
      if (this.listReglements.size() > 0) {
         new Reglements();

         for(int var12 = 0; var12 < this.listReglements.size(); ++var12) {
            Reglements var11 = (Reglements)this.listReglements.get(var12);
            var1 += var11.getRglDepense();
            var5 += var11.getRglRecette();
            var7 += var11.getRglTimbre();
         }

         this.var_nb_ligne = this.listReglements.size();
      }

      this.datamodelReglements.setWrappedData(this.listReglements);
      this.montantTtc = var1;
      this.montantReglement = var5;
      this.montantSolde = var7;
      this.visibiliteBton = false;
   }

   public void selectionReglement() {
      if (this.datamodelReglements.isRowAvailable()) {
         this.reglements = (Reglements)this.datamodelReglements.getRowData();
         this.montantTtcElmt = this.reglements.getRglDepense();
         this.montantReglementElmt = this.reglements.getRglRecette();
         this.montantSoldeElmt = this.reglements.getRglTimbre();
         this.visibiliteBton = true;
      }

   }

   public void iniExtrait(Session var1) throws ParseException, HibernateException, NamingException, IOException {
      this.typeDocument = 6;
      this.optionComptabilite = new OptionComptabilite();
      LireLesoptionsCompta var2 = new LireLesoptionsCompta(this.structureLog);
      var2.setStrId(this.structureLog.getStrid());
      this.optionComptabilite = var2.lancer();
      this.ecritures = new Ecritures();
      this.ecritures.setVerrouImport(Integer.parseInt(this.optionComptabilite.getVerrouImport()));
      this.datamodelExtraits = new ListDataModel();
      this.listExtraits = new ArrayList();
      this.ecrituresDao = new EcrituresDao(this.baseLog, this.utilInitHibernate);
      this.visibiliteBton = false;
      String var3 = "" + ((new Date()).getYear() + 1900);
      this.inpDu = this.utilDate.stringToDateSQLLight(var3 + "-01-01");
      this.inpAu = this.utilDate.stringToDateSQLLight(var3 + "-12-31");
      this.tiers = this.tiersDao.selectTierD(this.usersLog.getUsrIdTiersGuest(), var1);
      if (this.tiers != null) {
         this.typeTiers = Integer.parseInt(this.tiers.getTietype());
         this.compte = this.tiers.getTiecompte0();
         this.refTiers = this.tiers.getTieid() + ":" + this.tiers.getTieraisonsocialenom();
         this.listExtraits.clear();
         this.datamodelExtraits.setWrappedData(this.listExtraits);
         this.recupererServiceItem(var1);
      }

   }

   public void rechercheExtrait() throws HibernateException, NamingException, ParseException {
      this.listExtraits.clear();
      double var1 = 0.0D;
      double var3 = 0.0D;
      double var5 = 0.0D;
      double var7 = 0.0D;
      this.var_nb_ligne = 0;
      String var9 = "";
      String var10 = "";
      this.montantTtcElmt = 0.0D;
      this.montantReglementElmt = 0.0D;
      this.montantSoldeElmt = 0.0D;
      this.montantTtc = 0.0D;
      this.montantReglement = 0.0D;
      this.montantSolde = 0.0D;
      if (this.inpDu != null) {
         var9 = this.utilDate.dateToStringSQLLight(this.inpDu);
      }

      if (this.inpAu != null) {
         var10 = this.utilDate.dateToStringSQLLight(this.inpAu);
      }

      if (this.inpNum != null && !this.inpNum.isEmpty()) {
         this.inpEtat = 100;
      }

      String var11 = " ecr_compte='" + this.compte + "' and ecr_date_saisie>='" + var9 + "' and ecr_date_saisie<='" + var10 + "'";
      this.listExtraits = this.ecrituresDao.ChargerLesEcrituresRecherche(var11, (Session)null);
      if (this.listExtraits.size() > 0) {
         new Ecritures();

         for(int var13 = 0; var13 < this.listExtraits.size(); ++var13) {
            Ecritures var12 = (Ecritures)this.listExtraits.get(var13);
            var1 += var12.getEcrDebitPays();
            var5 += var12.getEcrCreditPays();
            var7 = 0.0D;
         }

         this.var_nb_ligne = this.listExtraits.size();
         this.visibiliteBton = true;
      } else {
         this.visibiliteBton = false;
      }

      this.datamodelExtraits.setWrappedData(this.listExtraits);
      this.montantTtc = var1;
      this.montantReglement = var5;
      this.montantSolde = var7;
      this.visibiliteBton = false;
   }

   public void selectionExtrait() {
      if (this.datamodelExtraits.isRowAvailable()) {
         this.ecritures = (Ecritures)this.datamodelExtraits.getRowData();
         this.montantTtcElmt = this.ecritures.getEcrDebitPays();
         this.montantReglementElmt = this.ecritures.getEcrCreditPays();
         this.montantSoldeElmt = 0.0D;
      }

   }

   public void initImpression() {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.showModalPanelPrint = true;
   }

   public void fermerImpression() {
      this.showModalPanelPrint = false;
   }

   public void imprimerJRV() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "JRV";
      this.imprimer();
   }

   public void imprimerPDF() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "PDF";
      this.imprimer();
   }

   public void imprimer() throws SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      if (this.typeDocument == 0) {
         this.imprimerRib();
      } else if (this.typeDocument == 1) {
         this.imprimerCommandeFournisseur();
      } else if (this.typeDocument == 2) {
         this.imprimerCommandeClient();
      } else if (this.typeDocument == 3) {
         this.imprimerFactureFournisseur();
      } else if (this.typeDocument == 4) {
         this.imprimerFactureClient();
      } else if (this.typeDocument == 5) {
         this.imprimerReglement();
      } else if (this.typeDocument == 6) {
         this.imprimerExtrait();
      }

   }

   public void imprimerRib() throws SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "tiers" + File.separator + "rib" + File.separator;
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "tiers" + File.separator + "sous_rapport" + File.separator;
      String var3 = "RibCompte";
      if (var3 != null && !var3.isEmpty()) {
         String var4 = " cmm_contacts.`con_id`=" + this.contacts.getConid();
         this.utilPrint.setSource("");
         this.utilPrint.setRecordPath("");
         this.utilPrint.setRapport(var3);
         this.utilPrint.setRequete(var4);
         this.utilPrint.setFiltre("");
         this.utilPrint.setCheminRapport(var1);
         this.utilPrint.setCheminSousrapport(var2);
         this.utilPrint.setEntete("Impression RIB société");
         this.utilPrint.setFormat(this.format);
         this.utilPrint.setImageFondPage(var2);
         this.utilPrint.setIdResponsable(0L);
         this.utilPrint.setTiersSelectionne((Tiers)null);
         ArrayList var5 = new ArrayList();
         JRBeanCollectionDataSource var6 = new JRBeanCollectionDataSource(var5);
         this.utilPrint.setjRBeanCollectionDataSource(var6);
         this.utilPrint.setBaseLog(this.baseLog);
         this.utilPrint.setStructureLog(this.structureLog);
         this.utilPrint.setUsersLog(this.usersLog);
         this.utilPrint.imprimeRapport();
      }

   }

   public void imprimerCommandeFournisseur() {
   }

   public void imprimerCommandeClient() {
   }

   public void imprimerFactureFournisseur() {
   }

   public void imprimerFactureClient() {
   }

   public void imprimerReglement() {
   }

   public void imprimerExtrait() {
   }

   public String getBaseLog() {
      return this.baseLog;
   }

   public void setBaseLog(String var1) {
      this.baseLog = var1;
   }

   public DataModel getDatamodelFacturesVentes() {
      return this.datamodelFacturesVentes;
   }

   public void setDatamodelFacturesVentes(DataModel var1) {
      this.datamodelFacturesVentes = var1;
   }

   public Structure getStructureLog() {
      return this.structureLog;
   }

   public void setStructureLog(Structure var1) {
      this.structureLog = var1;
   }

   public String getUrlExplorateur() {
      return this.urlExplorateur;
   }

   public void setUrlExplorateur(String var1) {
      this.urlExplorateur = var1;
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

   public FactureEnteteVentes getFactureEnteteVentes() {
      return this.factureEnteteVentes;
   }

   public void setFactureEnteteVentes(FactureEnteteVentes var1) {
      this.factureEnteteVentes = var1;
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

   public String getInpService() {
      return this.inpService;
   }

   public void setInpService(String var1) {
      this.inpService = var1;
   }

   public List getMesEtatsItems() {
      return this.mesEtatsItems;
   }

   public void setMesEtatsItems(List var1) {
      this.mesEtatsItems = var1;
   }

   public List getMesServicesItems() {
      return this.mesServicesItems;
   }

   public void setMesServicesItems(List var1) {
      this.mesServicesItems = var1;
   }

   public int getVar_nb_max() {
      return this.var_nb_max;
   }

   public void setVar_nb_max(int var1) {
      this.var_nb_max = var1;
   }

   public double getMontantReglement() {
      return this.montantReglement;
   }

   public void setMontantReglement(double var1) {
      this.montantReglement = var1;
   }

   public double getMontantReglementElmt() {
      return this.montantReglementElmt;
   }

   public void setMontantReglementElmt(double var1) {
      this.montantReglementElmt = var1;
   }

   public double getMontantSolde() {
      return this.montantSolde;
   }

   public void setMontantSolde(double var1) {
      this.montantSolde = var1;
   }

   public double getMontantSoldeElmt() {
      return this.montantSoldeElmt;
   }

   public void setMontantSoldeElmt(double var1) {
      this.montantSoldeElmt = var1;
   }

   public double getMontantTtc() {
      return this.montantTtc;
   }

   public void setMontantTtc(double var1) {
      this.montantTtc = var1;
   }

   public double getMontantTtcElmt() {
      return this.montantTtcElmt;
   }

   public void setMontantTtcElmt(double var1) {
      this.montantTtcElmt = var1;
   }

   public int getVar_nb_ligne() {
      return this.var_nb_ligne;
   }

   public void setVar_nb_ligne(int var1) {
      this.var_nb_ligne = var1;
   }

   public String getVar_libcondest() {
      return this.var_libcondest;
   }

   public void setVar_libcondest(String var1) {
      this.var_libcondest = var1;
   }

   public Tiers getTiers() {
      return this.tiers;
   }

   public void setTiers(Tiers var1) {
      this.tiers = var1;
   }

   public boolean isVisibiliteBton() {
      return this.visibiliteBton;
   }

   public void setVisibiliteBton(boolean var1) {
      this.visibiliteBton = var1;
   }

   public String getInpCat() {
      return this.inpCat;
   }

   public void setInpCat(String var1) {
      this.inpCat = var1;
   }

   public String getInpSerie() {
      return this.inpSerie;
   }

   public void setInpSerie(String var1) {
      this.inpSerie = var1;
   }

   public int getTypeTiers() {
      return this.typeTiers;
   }

   public void setTypeTiers(int var1) {
      this.typeTiers = var1;
   }

   public DataModel getDatamodelFacturesAchats() {
      return this.datamodelFacturesAchats;
   }

   public void setDatamodelFacturesAchats(DataModel var1) {
      this.datamodelFacturesAchats = var1;
   }

   public DataModel getDatamodelCommandesAchats() {
      return this.datamodelCommandesAchats;
   }

   public void setDatamodelCommandesAchats(DataModel var1) {
      this.datamodelCommandesAchats = var1;
   }

   public DataModel getDatamodelCommandesVentes() {
      return this.datamodelCommandesVentes;
   }

   public void setDatamodelCommandesVentes(DataModel var1) {
      this.datamodelCommandesVentes = var1;
   }

   public DataModel getDatamodelReglements() {
      return this.datamodelReglements;
   }

   public void setDatamodelReglements(DataModel var1) {
      this.datamodelReglements = var1;
   }

   public DataModel getDatamodelExtraits() {
      return this.datamodelExtraits;
   }

   public void setDatamodelExtraits(DataModel var1) {
      this.datamodelExtraits = var1;
   }

   public String getCompte() {
      return this.compte;
   }

   public void setCompte(String var1) {
      this.compte = var1;
   }

   public OptionComptabilite getOptionComptabilite() {
      return this.optionComptabilite;
   }

   public void setOptionComptabilite(OptionComptabilite var1) {
      this.optionComptabilite = var1;
   }

   public DataModel getDatamodelContact() {
      return this.datamodelContact;
   }

   public void setDatamodelContact(DataModel var1) {
      this.datamodelContact = var1;
   }

   public boolean isShowModalPanelPrint() {
      return this.showModalPanelPrint;
   }

   public void setShowModalPanelPrint(boolean var1) {
      this.showModalPanelPrint = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public int getTypeVente() {
      return this.typeVente;
   }

   public void setTypeVente(int var1) {
      this.typeVente = var1;
   }

   public String getInpNumBCC() {
      return this.inpNumBCC;
   }

   public void setInpNumBCC(String var1) {
      this.inpNumBCC = var1;
   }
}
