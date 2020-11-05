package com.epegase.forms.achats;

import com.epegase.systeme.classe.Departement;
import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.FamillesProduitsAchats;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.classe.PointDeVente;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.Region;
import com.epegase.systeme.classe.Secteur;
import com.epegase.systeme.classe.Service;
import com.epegase.systeme.classe.Site;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.EtatDocument;
import com.epegase.systeme.dao.DepartementDao;
import com.epegase.systeme.dao.ExercicesAchatsDao;
import com.epegase.systeme.dao.FamillesProduitsAchatsDao;
import com.epegase.systeme.dao.ParcDao;
import com.epegase.systeme.dao.PointDeVenteDao;
import com.epegase.systeme.dao.ProduitsAchsDao;
import com.epegase.systeme.dao.RegionDao;
import com.epegase.systeme.dao.SecteurDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.SiteDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.OptionAchats;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.jdom.JDOMException;

public class FormImpressionAchats implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private ExercicesAchats exoSelectionne;
   private OptionAchats optionAchats;
   private UtilDate utilDate;
   private List lesRepImpression = new ArrayList();
   private transient DataModel dataModelImpgen = new ListDataModel();
   private List lesFichImpression = new ArrayList();
   private transient DataModel dataModelImpgenFichier = new ListDataModel();
   private boolean testafficheLigne = false;
   private UsersChronoDao usersChronoDao;
   private int nature;
   private String nomRepertoire;
   private String nomEtat = "";
   private List listDocument;
   private List listProduits;
   private String periode;
   private List mesPeriodesItems = new ArrayList();
   private Date filtreDateDebut;
   private Date filtreDateFin;
   private String nomTiers;
   private String nomDestinataire;
   private String region;
   private String secteur;
   private String pdv;
   private String site;
   private String departement;
   private String service;
   private String produitDebut;
   private String produitFin;
   private String parc;
   private String activite;
   private String document;
   private String dossier;
   private String serie;
   private String etat;
   private String categorie;
   private String commercial;
   private String createur;
   private String famille;
   private String depot;
   private String var_entete;
   private String var_filtre;
   private String var_requete;
   private List mesSeriesItems = new ArrayList();
   private List mesEtatsItems = new ArrayList();
   private List mesSecteursItems = new ArrayList();
   private List mesPdvItems = new ArrayList();
   private List mesDepartementsItems = new ArrayList();
   private List mesServicesItems = new ArrayList();
   private boolean var_anal_activite = false;
   private int var_anal_dossier;
   private boolean var_anal_parc = false;
   private boolean var_anal_site = false;
   private boolean var_anal_departement = false;
   private boolean var_anal_service = false;
   private boolean var_anal_region = false;
   private boolean var_anal_secteur = false;
   private boolean var_anal_pdv = false;
   private boolean var_anal_agent = false;
   private boolean var_ctrl_imp = false;
   private UtilPrint utilPrint;
   private boolean affMail = false;
   private String format = "PDF";
   private boolean var_affiche_impression = false;
   private String impDestinataire;
   private String impDestinataireCC;
   private String impDestinataireCCI;
   private String impEmetteur;
   private boolean showModalPanelPrint = false;
   private boolean showModalPanelTiers;
   private transient DataModel datamodelTiers = new ListDataModel();
   private Tiers tiers;
   private PlansAnalytiques plansAnalytiques;
   private boolean showModalPanelProduits;
   private transient DataModel datamodelProduits = new ListDataModel();
   private Produits produits;
   private boolean var_produit_choix = false;
   private boolean showModalPanelParc;
   private transient DataModel datamodelParc = new ListDataModel();
   private Parc parcObj;
   private String m0DteDeb;
   private String m0DteFin;
   private String m30DteDeb;
   private String m30DteFin;
   private String m60DteDeb;
   private String m60DteFin;
   private String m90DteDeb;
   private String m90DteFin;
   private String m120DteDeb;
   private List lesModelesAutorises;

   public FormImpressionAchats() {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.utilDate = new UtilDate();
   }

   public void InstancesDaoUtilses() {
   }

   public void chargerLesRepImpAchats(Session var1) {
      this.lesRepImpression.clear();
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "fournisseur";
      File var3 = new File(var2);
      if (!var3.exists()) {
         var3.mkdir();
      }

      String[] var4 = var3.list();
      int var5;
      if (var4 != null) {
         var4 = this.triAlphabetique(var4, var4.length);

         for(var5 = 0; var5 < var4.length; ++var5) {
            if (!var4[var5].equalsIgnoreCase(".svn") && !var4[var5].equalsIgnoreCase("index.html")) {
               String var6 = "";
               var6 = var4[var5].toUpperCase();
               boolean var7 = this.calculeVisible(var6, var1);
               if (var7) {
                  this.lesRepImpression.add(var6);
               }
            }
         }
      }

      var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "produits";
      var3 = new File(var2);
      var4 = var3.list();
      if (var4 != null) {
         var4 = this.triAlphabetique(var4, var4.length);

         for(var5 = 0; var5 < var4.length; ++var5) {
            if (!var4[var5].equalsIgnoreCase(".svn")) {
               this.nomRepertoire = "";
               this.nomRepertoire = var4[var5].toUpperCase();
               boolean var8 = this.calculeVisible(this.nomRepertoire, var1);
               if (var8) {
                  this.lesRepImpression.add(this.nomRepertoire);
               }
            }
         }
      }

      this.dataModelImpgen.setWrappedData(this.lesRepImpression);
   }

   public boolean calculeVisible(String var1, Session var2) {
      boolean var3 = false;
      int var4 = 0;
      if (var1 != null && !var1.isEmpty()) {
         Object var5;
         if (var1.contains("_AVOIR")) {
            var5 = var2.createQuery("SELECT COUNT(*) FROM AvoirEnteteAchats").uniqueResult();
            var4 = Integer.parseInt(var5.toString());
         } else if (var1.contains("_COMMANDE")) {
            var5 = var2.createQuery("SELECT COUNT(*) FROM CommandeEnteteAchats").uniqueResult();
            var4 = Integer.parseInt(var5.toString());
         } else if (var1.contains("_COTATION")) {
            var5 = var2.createQuery("SELECT COUNT(*) FROM CotationEnteteAchats").uniqueResult();
            var4 = Integer.parseInt(var5.toString());
         } else if (var1.contains("_DA")) {
            var5 = var2.createQuery("SELECT COUNT(*) FROM DemandeEnteteAchats").uniqueResult();
            var4 = Integer.parseInt(var5.toString());
         } else if (!var1.contains("_FACTURE") && !var1.contains("_BALANCEAGEE") && !var1.contains("_ECHEANCIER")) {
            if (var1.contains("_FRAIS")) {
               var5 = var2.createQuery("SELECT COUNT(*) FROM FraisEnteteAchats").uniqueResult();
               var4 = Integer.parseInt(var5.toString());
            } else if (var1.contains("_NOTE_DE_DEBIT")) {
               var5 = var2.createQuery("SELECT COUNT(*) FROM NoteDebitEnteteAchats").uniqueResult();
               var4 = Integer.parseInt(var5.toString());
            } else if (var1.contains("_RECEPTION")) {
               var5 = var2.createQuery("SELECT COUNT(*) FROM ReceptionEnteteAchats").uniqueResult();
               var4 = Integer.parseInt(var5.toString());
            } else if (var1.contains("_RETOUR")) {
               var5 = var2.createQuery("SELECT COUNT(*) FROM RetourEnteteAchats").uniqueResult();
               var4 = Integer.parseInt(var5.toString());
            } else if (var1.contains("_Valorisation")) {
               var5 = var2.createQuery("SELECT COUNT(*) FROM ValorisationEnteteAchats").uniqueResult();
               var4 = Integer.parseInt(var5.toString());
            } else if (var1.contains("PRODUIT")) {
               var4 = 1;
            }
         } else {
            var5 = var2.createQuery("SELECT COUNT(*) FROM FactureEnteteAchats").uniqueResult();
            var4 = Integer.parseInt(var5.toString());
         }
      }

      if (var4 != 0) {
         var3 = true;
      }

      return var3;
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

   public void calculeAnalytique() {
      this.var_anal_activite = false;
      this.var_anal_site = false;
      this.var_anal_departement = false;
      this.var_anal_service = false;
      this.var_anal_region = false;
      this.var_anal_secteur = false;
      this.var_anal_pdv = false;
      this.var_anal_parc = false;
      this.var_anal_agent = false;
      if (this.optionAchats.getAxeActivite().equals("true")) {
         this.var_anal_activite = true;
      }

      if (this.optionAchats.getAxeSite().equals("true")) {
         this.var_anal_site = true;
         this.var_anal_departement = true;
         this.var_anal_service = true;
      }

      if (this.optionAchats.getAxeRegion().equals("true")) {
         this.var_anal_region = true;
         this.var_anal_secteur = true;
         this.var_anal_pdv = true;
      }

      if (this.optionAchats.getAxeParc().equals("true")) {
         this.var_anal_parc = true;
      }

      if (this.optionAchats.getAxeAgent().equals("true")) {
         this.var_anal_agent = true;
      }

   }

   public void chargerSecteur() throws HibernateException, NamingException {
      this.mesSecteursItems.clear();
      this.mesPdvItems.clear();
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         new ArrayList();
         String[] var2 = this.region.split(":");
         new Region();
         RegionDao var4 = new RegionDao(this.baseLog, this.utilInitHibernate);
         Region var3 = var4.rechercheRegion(var2[0], (Session)null);
         if (var3 != null) {
            SecteurDao var5 = new SecteurDao(this.baseLog, this.utilInitHibernate);
            List var1 = var5.listSecteurByRegion((Region)var3, (Session)null);
            if (var1.size() != 0) {
               for(int var6 = 0; var6 < var1.size(); ++var6) {
                  this.mesSecteursItems.add(new SelectItem(((Secteur)var1.get(var6)).getSecCode() + ":" + ((Secteur)var1.get(var6)).getSecNomFr()));
               }
            }
         }
      }

   }

   public void chargerPdv() throws HibernateException, NamingException {
      this.mesPdvItems.clear();
      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         new ArrayList();
         String[] var2 = this.secteur.split(":");
         new Secteur();
         SecteurDao var4 = new SecteurDao(this.baseLog, this.utilInitHibernate);
         Secteur var3 = var4.rechercheSecteur(var2[0], (Session)null);
         if (var3 != null) {
            PointDeVenteDao var5 = new PointDeVenteDao(this.baseLog, this.utilInitHibernate);
            List var1 = var5.listPdvBySecteur((Secteur)var3, (Session)null);
            if (var1.size() != 0) {
               for(int var6 = 0; var6 < var1.size(); ++var6) {
                  this.mesPdvItems.add(new SelectItem(((PointDeVente)var1.get(var6)).getPdvCode() + ":" + ((PointDeVente)var1.get(var6)).getPdvNomFr()));
               }
            }
         }
      }

   }

   public void chargerDepartement() throws HibernateException, NamingException {
      this.mesDepartementsItems.clear();
      this.mesServicesItems.clear();
      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         new ArrayList();
         String[] var2 = this.site.split(":");
         new Site();
         SiteDao var4 = new SiteDao(this.baseLog, this.utilInitHibernate);
         Site var3 = var4.rechercheSite(var2[0], (Session)null);
         if (var3 != null) {
            DepartementDao var5 = new DepartementDao(this.baseLog, this.utilInitHibernate);
            List var1 = var5.listDepartementBySit((Site)var3, (Session)null);
            if (var1.size() != 0) {
               for(int var6 = 0; var6 < var1.size(); ++var6) {
                  this.mesDepartementsItems.add(new SelectItem(((Departement)var1.get(var6)).getDepCode() + ":" + ((Departement)var1.get(var6)).getDepNomFr()));
               }
            }
         }
      }

   }

   public void chargerService() throws HibernateException, NamingException {
      this.mesServicesItems.clear();
      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         new ArrayList();
         String[] var2 = this.departement.split(":");
         new Departement();
         DepartementDao var4 = new DepartementDao(this.baseLog, this.utilInitHibernate);
         Departement var3 = var4.rechercheDepartement(var2[0], (Session)null);
         if (var3 != null) {
            ServiceDao var5 = new ServiceDao(this.baseLog, this.utilInitHibernate);
            List var1 = var5.listServiceByDep((Departement)var3, (Session)null);
            if (var1.size() != 0) {
               for(int var6 = 0; var6 < var1.size(); ++var6) {
                  this.mesServicesItems.add(new SelectItem(((Service)var1.get(var6)).getSerCode() + ":" + ((Service)var1.get(var6)).getSerNomFr()));
               }
            }
         }
      }

   }

   public void recupererNomrep() throws HibernateException, NamingException {
      this.testafficheLigne = false;
      if (this.dataModelImpgen.isRowAvailable()) {
         this.nomRepertoire = (String)this.dataModelImpgen.getRowData();
         this.nomRepertoire = this.nomRepertoire.toLowerCase();
         this.nomEtat = "";
         if (this.nomRepertoire.contains("da")) {
            this.nature = 10;
         } else if (this.nomRepertoire.contains("cotation")) {
            this.nature = 11;
         } else if (this.nomRepertoire.contains("commande")) {
            this.nature = 12;
         } else if (this.nomRepertoire.contains("reception")) {
            this.nature = 13;
         } else if (this.nomRepertoire.contains("retour")) {
            this.nature = 14;
         } else if (!this.nomRepertoire.contains("facture") && !this.nomRepertoire.contains("balanceagee")) {
            if (this.nomRepertoire.contains("avoir")) {
               this.nature = 16;
            } else if (this.nomRepertoire.contains("note_de_debit")) {
               this.nature = 17;
            } else if (this.nomRepertoire.contains("frais")) {
               this.nature = 18;
            } else {
               this.nature = 0;
            }
         } else {
            this.nature = 15;
         }

         this.lesFichImpression.clear();
         String var1 = null;
         if (this.nomRepertoire.contains("ligne_")) {
            var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "produits" + File.separator + this.nomRepertoire;
            this.testafficheLigne = true;
         } else {
            var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "fournisseur" + File.separator + this.nomRepertoire;
            this.testafficheLigne = false;
         }

         File var2 = new File(var1);
         if (!var2.exists()) {
            var2.mkdir();
         }

         String[] var3 = var2.list();
         if (var3 != null) {
            var3 = this.triAlphabetique(var3, var3.length);

            for(int var4 = 0; var4 < var3.length; ++var4) {
               if (var3[var4].endsWith("jasper")) {
                  String var5 = var3[var4];
                  if (this.verificationAutorisation(var5)) {
                     String var6 = var3[var4].substring(0, var3[var4].indexOf("."));
                     this.lesFichImpression.add(var6);
                  }
               }
            }
         }

         this.dataModelImpgenFichier.setWrappedData(this.lesFichImpression);
         this.var_affiche_impression = true;
         this.mesEtatsItems.clear();
         EtatDocument var7 = new EtatDocument();
         this.mesEtatsItems = var7.calculelisteEtatsItems(this.nature, 0);
         this.mesSeriesItems.clear();
         this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
         List var8 = this.usersChronoDao.selectListByUserNat(this.usersLog, this.nature, (Session)null);
         if (var8.size() != 0) {
            for(int var9 = 0; var9 < var8.size(); ++var9) {
               if (this.usersLog.getUsrJrxReserve() == 1) {
                  if (((UsersChrono)var8.get(var9)).getUsrchrPrive() == 0) {
                     this.mesSeriesItems.add(new SelectItem(((UsersChrono)var8.get(var9)).getUsrchrSerie()));
                  }
               } else {
                  this.mesSeriesItems.add(new SelectItem(((UsersChrono)var8.get(var9)).getUsrchrSerie()));
               }
            }
         }
      }

   }

   public boolean verificationAutorisation(String var1) {
      boolean var2 = false;
      if (this.lesModelesAutorises != null && this.lesModelesAutorises.size() != 0) {
         for(int var3 = 0; var3 < this.lesModelesAutorises.size(); ++var3) {
            if (((String)this.lesModelesAutorises.get(var3)).toString().toLowerCase().contains(var1.toLowerCase())) {
               var2 = true;
               break;
            }
         }
      } else {
         var2 = true;
      }

      return var2;
   }

   public void recupererNomfich() throws ParseException {
      if (this.dataModelImpgenFichier.isRowAvailable()) {
         this.nomEtat = (String)this.dataModelImpgenFichier.getRowData();
         this.filtreDateDebut = this.exoSelectionne.getExeachDateDebut();
         this.filtreDateFin = this.exoSelectionne.getExeachDateFin();
         this.var_affiche_impression = true;
         this.calculeDates();
      }

   }

   public List getMesTiersItems() {
      ArrayList var1 = new ArrayList();
      ArrayList var2 = new ArrayList();

      for(int var3 = 0; var3 < var1.size(); ++var3) {
         var2.add(new SelectItem(((Tiers)var1.get(var3)).getTieid(), ((Tiers)var1.get(var3)).getTieprenom()));
      }

      return var2;
   }

   public void rechercheTiers() throws HibernateException, NamingException {
      Object var1 = new ArrayList();
      if (this.nomTiers != null && !this.nomTiers.isEmpty()) {
         String var2 = "(0,1)";
         TiersDao var3 = new TiersDao(this.baseLog, this.utilInitHibernate);
         var1 = var3.verifTiers(this.usersLog, var2, this.nomTiers, (Session)null);
         this.showModalPanelTiers = true;
      }

      this.datamodelTiers.setWrappedData(var1);
   }

   public void selectionligneTiers() throws JDOMException, IOException {
      if (this.datamodelTiers.isRowAvailable()) {
         this.tiers = (Tiers)this.datamodelTiers.getRowData();
      }

   }

   public void calculeTiers() throws JDOMException, IOException {
      if (this.tiers == null) {
         this.selectionligneTiers();
      }

      if (this.tiers != null) {
         this.nomTiers = this.tiers.getTieraisonsocialenom();
      } else {
         this.tiers = null;
         this.nomTiers = "";
      }

      this.showModalPanelTiers = false;
   }

   public void annuleTiers() {
      this.tiers = null;
      this.nomTiers = "";
      this.showModalPanelTiers = false;
   }

   public void rechercheProduitsDebut() throws HibernateException, NamingException {
      Object var1 = new ArrayList();
      if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
         ProduitsAchsDao var2 = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
         var1 = var2.verifProduits(this.produitDebut, (Session)null);
         this.var_produit_choix = false;
         this.showModalPanelProduits = true;
      }

      this.datamodelProduits.setWrappedData(var1);
   }

   public void rechercheProduitsFin() throws HibernateException, NamingException {
      Object var1 = new ArrayList();
      if (this.produitFin != null && !this.produitFin.isEmpty()) {
         ProduitsAchsDao var2 = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
         var1 = var2.verifProduits(this.produitFin, (Session)null);
         this.var_produit_choix = true;
         this.showModalPanelProduits = true;
      }

      this.datamodelProduits.setWrappedData(var1);
   }

   public void selectionProduits() throws JDOMException, IOException {
      if (this.datamodelProduits.isRowAvailable()) {
         this.produits = (Produits)this.datamodelProduits.getRowData();
      }

   }

   public void calculeProduits() throws JDOMException, IOException {
      if (this.produits == null) {
         this.selectionProduits();
      }

      if (this.produits != null) {
         if (!this.var_produit_choix) {
            this.produitDebut = this.produits.getProCode();
         } else {
            this.produitFin = this.produits.getProCode();
         }
      } else {
         this.produits = null;
         if (!this.var_produit_choix) {
            this.produitDebut = "";
         } else {
            this.produitFin = "";
         }
      }

      this.showModalPanelProduits = false;
   }

   public void annuleProduits() {
      this.produits = null;
      if (!this.var_produit_choix) {
         this.produitDebut = "";
      } else {
         this.produitFin = "";
      }

      this.showModalPanelProduits = false;
   }

   public void rechercheParc() throws HibernateException, NamingException {
      Object var1 = new ArrayList();
      if (this.parc != null && !this.parc.isEmpty()) {
         ParcDao var2 = new ParcDao(this.baseLog, this.utilInitHibernate);
         var1 = var2.rechercheParc(this.parc, "", "", "100", "100", "", (Session)null);
         this.showModalPanelParc = true;
      }

      this.datamodelParc.setWrappedData(var1);
   }

   public void selectionParc() throws JDOMException, IOException {
      if (this.datamodelParc.isRowAvailable()) {
         this.parcObj = (Parc)this.datamodelParc.getRowData();
      }

   }

   public void calculeParc() throws JDOMException, IOException {
      if (this.parcObj == null) {
         this.selectionParc();
      }

      if (this.parcObj != null) {
         this.parc = this.parcObj.getPrcImmatriculation();
      } else {
         this.parcObj = null;
         this.parc = "";
      }

      this.showModalPanelParc = false;
   }

   public void annuleParc() {
      this.parcObj = null;
      this.showModalPanelParc = false;
   }

   public void chargerPeriodes() throws ParseException {
      this.mesPeriodesItems.clear();
      this.mesPeriodesItems.add(new SelectItem(""));
      Date var1 = this.exoSelectionne.getExeachDateDebut();
      GregorianCalendar var2 = new GregorianCalendar();
      var2.setTime(var1);
      Date var3 = this.exoSelectionne.getExeachDateFin();
      GregorianCalendar var4 = new GregorianCalendar();
      var4.setTime(var3);
      var2.add(2, -1);
      var4.add(2, -1);
      String var5 = null;

      while(var2.compareTo(var4) < 0) {
         var2.add(2, 1);
         Date var6 = var2.getTime();
         var5 = this.formatPeriode(var6);
         this.mesPeriodesItems.add(new SelectItem(var5));
      }

      this.mesPeriodesItems.add(new SelectItem("1er trimestre"));
      this.mesPeriodesItems.add(new SelectItem("2eme trimestre"));
      this.mesPeriodesItems.add(new SelectItem("3eme trimestre"));
      this.mesPeriodesItems.add(new SelectItem("4eme trimestre"));
      this.mesPeriodesItems.add(new SelectItem("1er semestre"));
      this.mesPeriodesItems.add(new SelectItem("2eme semestre"));
      this.mesPeriodesItems.add(new SelectItem("Annuel"));
      this.filtreDateDebut = var1;
      this.filtreDateFin = var3;
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

   public void calculeDates() throws ParseException {
      if (this.periode != null && !this.periode.isEmpty()) {
         if (this.periode.contains(":")) {
            String[] var1 = this.periode.split(":");
            String var2 = var1[0];
            String var3 = var1[1];
            this.filtreDateDebut = this.utilDate.stringToDateSQLLight(var3 + "-" + var2 + "-" + "01");
            this.filtreDateFin = this.utilDate.dateDernierJourMois(this.filtreDateDebut);
         } else {
            int var4 = (new Date()).getYear() + 1900;
            if (this.periode.equals("1er trimestre")) {
               this.filtreDateDebut = this.utilDate.stringToDateSQLLight(var4 + "-" + "01" + "-" + "01");
               this.filtreDateFin = this.utilDate.stringToDateSQLLight(var4 + "-" + "03" + "-" + "31");
            } else if (this.periode.equals("2eme trimestre")) {
               this.filtreDateDebut = this.utilDate.stringToDateSQLLight(var4 + "-" + "04" + "-" + "01");
               this.filtreDateFin = this.utilDate.stringToDateSQLLight(var4 + "-" + "06" + "-" + "30");
            } else if (this.periode.equals("3eme trimestre")) {
               this.filtreDateDebut = this.utilDate.stringToDateSQLLight(var4 + "-" + "07" + "-" + "01");
               this.filtreDateFin = this.utilDate.stringToDateSQLLight(var4 + "-" + "09" + "-" + "30");
            } else if (this.periode.equals("4eme trimestre")) {
               this.filtreDateDebut = this.utilDate.stringToDateSQLLight(var4 + "-" + "10" + "-" + "01");
               this.filtreDateFin = this.utilDate.stringToDateSQLLight(var4 + "-" + "12" + "-" + "31");
            } else if (this.periode.equals("1er semestre")) {
               this.filtreDateDebut = this.utilDate.stringToDateSQLLight(var4 + "-" + "01" + "-" + "01");
               this.filtreDateFin = this.utilDate.stringToDateSQLLight(var4 + "-" + "06" + "-" + "30");
            } else if (this.periode.equals("2eme semestre")) {
               this.filtreDateDebut = this.utilDate.stringToDateSQLLight(var4 + "-" + "07" + "-" + "01");
               this.filtreDateFin = this.utilDate.stringToDateSQLLight(var4 + "-" + "12" + "-" + "31");
            } else if (this.periode.equals("Annuel")) {
               this.filtreDateDebut = this.utilDate.stringToDateSQLLight(var4 + "-" + "01" + "-" + "01");
               this.filtreDateFin = this.utilDate.stringToDateSQLLight(var4 + "-" + "12" + "-" + "31");
            }
         }
      }

   }

   public void initImpression() {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.affMail = false;
   }

   public void imprimerPRT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "PRT";
      this.imprimer();
   }

   public void imprimerJRV() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "JRV";
      this.imprimer();
   }

   public void imprimerPDF() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "PDF";
      this.imprimer();
   }

   public void imprimerODT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "ODT";
      this.imprimer();
   }

   public void imprimerXLS() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "XLS";
      this.imprimer();
   }

   public void imprimerDOC() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "DOC";
      this.imprimer();
   }

   public void imprimerHTML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "HTML";
      this.imprimer();
   }

   public void imprimerXML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "XML";
      this.imprimer();
   }

   public void imprimerCSV() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "CSV";
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

   public void imprimer() throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      if (this.nomRepertoire != null && !this.nomRepertoire.isEmpty() && this.nomEtat != null && !this.nomEtat.isEmpty()) {
         this.var_ctrl_imp = true;
         this.listDocument = new ArrayList();
         this.listProduits = new ArrayList();
         this.calculeRequete();
         this.utilPrint.setSource("");
         this.utilPrint.setRecordPath("");
         this.utilPrint.setRapport(this.nomEtat);
         if (this.nomRepertoire.contains("ligne_")) {
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "produits" + File.separator + this.nomRepertoire + File.separator);
         } else {
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "fournisseur" + File.separator + this.nomRepertoire + File.separator);
         }

         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "sous_rapport" + File.separator);
         if (this.var_entete != null && !this.var_entete.isEmpty()) {
            this.utilPrint.setEntete(this.var_entete.replace("_", " "));
         } else {
            this.utilPrint.setEntete("");
         }

         if (this.var_filtre != null && !this.var_filtre.isEmpty()) {
            this.utilPrint.setFiltre(this.var_filtre.replace("_", " "));
         } else {
            this.utilPrint.setFiltre("");
         }

         JRBeanCollectionDataSource var1;
         if (this.nomRepertoire.contains("_synthese")) {
            this.utilPrint.setRequete("");
            var1 = new JRBeanCollectionDataSource(this.listDocument);
            this.utilPrint.setjRBeanCollectionDataSource(var1);
         } else if (this.nomRepertoire.equals("produit")) {
            this.utilPrint.setFiltre("Controle produit");
            this.utilPrint.setRequete("");
            var1 = new JRBeanCollectionDataSource(this.listProduits);
            this.utilPrint.setjRBeanCollectionDataSource(var1);
         } else {
            this.utilPrint.setRequete(this.var_requete);
            ArrayList var3 = new ArrayList();
            JRBeanCollectionDataSource var2 = new JRBeanCollectionDataSource(var3);
            this.utilPrint.setjRBeanCollectionDataSource(var2);
         }

         this.utilPrint.setFormat(this.format);
         this.utilPrint.setEmetteur(this.impEmetteur);
         this.utilPrint.setDestinataire(this.impDestinataire);
         this.utilPrint.setDestinataireCC(this.impDestinataireCC);
         this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
         this.utilPrint.setTiersSelectionne((Tiers)null);
         this.utilPrint.setBaseLog(this.baseLog);
         this.utilPrint.setStructureLog(this.structureLog);
         this.utilPrint.setUsersLog(this.usersLog);
         this.utilPrint.setM0DteDeb(this.m0DteDeb);
         this.utilPrint.setM0DteFin(this.m0DteFin);
         this.utilPrint.setM30DteDeb(this.m30DteDeb);
         this.utilPrint.setM0DteDeb(this.m0DteDeb);
         this.utilPrint.setM0DteFin(this.m0DteFin);
         this.utilPrint.setM30DteDeb(this.m30DteDeb);
         this.utilPrint.setM30DteFin(this.m30DteFin);
         this.utilPrint.setM60DteDeb(this.m60DteDeb);
         this.utilPrint.setM60DteFin(this.m60DteFin);
         this.utilPrint.setM90DteDeb(this.m90DteDeb);
         this.utilPrint.setM90DteFin(this.m90DteFin);
         this.utilPrint.setM120DteDeb(this.m120DteDeb);
         this.utilPrint.setM30DteFin(this.m30DteFin);
         this.utilPrint.setM60DteDeb(this.m60DteDeb);
         this.utilPrint.setM60DteFin(this.m60DteFin);
         this.utilPrint.setM90DteDeb(this.m90DteDeb);
         this.utilPrint.setM90DteFin(this.m90DteFin);
         this.utilPrint.setM120DteDeb(this.m120DteDeb);
         this.utilPrint.setDateDeb(this.filtreDateDebut);
         this.utilPrint.setDateFin(this.filtreDateFin);
         this.utilPrint.imprimeRapport();
         this.var_ctrl_imp = false;
      }

   }

   public void calculeRequete() throws HibernateException, NamingException, ParseException {
      this.var_entete = "";
      this.var_filtre = "";
      this.var_requete = "";
      String var1 = this.utilDate.dateToStringFr(this.filtreDateDebut);
      String var2 = var1.substring(6, 10) + "-" + var1.substring(3, 5) + "-" + var1.substring(0, 2) + " 00:00:00";
      String var3 = this.utilDate.dateToStringFr(this.filtreDateFin);
      String var4 = var3.substring(6, 10) + "-" + var3.substring(3, 5) + "-" + var3.substring(0, 2) + " 23:59:59";
      String var5 = this.utilDate.dateToStringFr(this.filtreDateDebut);
      String var6 = this.utilDate.dateToStringFr(this.filtreDateFin);
      if (this.nomRepertoire.equalsIgnoreCase("entete_balanceagee")) {
         this.rechercheBalanceAgeeSql(var5, var6, var2, var4);
      } else if (this.nomRepertoire.equalsIgnoreCase("entete_echeancier")) {
         this.rechercheEcheancierSql(var5, var6, var2, var4);
      } else if (!this.nomRepertoire.equalsIgnoreCase("entete_da") && !this.nomRepertoire.equalsIgnoreCase("ligne_da")) {
         if (!this.nomRepertoire.equalsIgnoreCase("entete_cotation") && !this.nomRepertoire.equalsIgnoreCase("ligne_cotation")) {
            if (!this.nomRepertoire.equalsIgnoreCase("entete_commande") && !this.nomRepertoire.equalsIgnoreCase("ligne_commande")) {
               if (!this.nomRepertoire.equalsIgnoreCase("entete_reception") && !this.nomRepertoire.equalsIgnoreCase("ligne_reception")) {
                  if (!this.nomRepertoire.equalsIgnoreCase("entete_retour") && !this.nomRepertoire.equalsIgnoreCase("ligne_retour")) {
                     if (!this.nomRepertoire.equalsIgnoreCase("entete_facture") && !this.nomRepertoire.equalsIgnoreCase("ligne_facture")) {
                        if (!this.nomRepertoire.equalsIgnoreCase("entete_avoir") && !this.nomRepertoire.equalsIgnoreCase("ligne_avoir")) {
                           if (!this.nomRepertoire.equalsIgnoreCase("entete_note_de_debit") && !this.nomRepertoire.equalsIgnoreCase("ligne_note_de_debit")) {
                              if (!this.nomRepertoire.equalsIgnoreCase("entete_frais") && !this.nomRepertoire.equalsIgnoreCase("ligne_frais")) {
                                 if (!this.nomRepertoire.equalsIgnoreCase("entete_valorisation") && this.nomRepertoire.equalsIgnoreCase("produit")) {
                                    this.rechercheProduitSql();
                                 }
                              } else {
                                 this.rechercheFraisSql(var5, var6, var2, var4);
                              }
                           }
                        } else {
                           this.rechercheAvoirSql(var5, var6, var2, var4);
                        }
                     } else {
                        this.rechercheFactureSql(var5, var6, var2, var4);
                     }
                  } else {
                     this.rechercheRetourSql(var5, var6, var2, var4);
                  }
               } else {
                  this.rechercheReceptionSql(var5, var6, var2, var4);
               }
            } else {
               this.rechercheCommandeSql(var5, var6, var2, var4);
            }
         } else {
            this.rechercheCotationSql(var5, var6, var2, var4);
         }
      }

   }

   public void rechercheBalanceAgeeSql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException, ParseException {
      this.m0DteDeb = this.utilDate.dateToStringSQLLight(this.utilDate.datePremierJourMois(this.filtreDateFin)) + " 00:00:00";
      this.m0DteFin = this.utilDate.dateToStringSQLLight(this.utilDate.dateDernierJourMois(this.filtreDateFin)) + " 23:59:59";
      Date var5 = this.utilDate.dateMoisPrecedent(this.filtreDateFin);
      this.m30DteDeb = this.utilDate.dateToStringSQLLight(this.utilDate.datePremierJourMois(var5)) + " 00:00:00";
      this.m30DteFin = this.utilDate.dateToStringSQLLight(this.utilDate.dateDernierJourMois(var5)) + " 23:59:59";
      Date var6 = this.utilDate.dateMoisPrecedent(var5);
      this.m60DteDeb = this.utilDate.dateToStringSQLLight(this.utilDate.datePremierJourMois(var6)) + " 00:00:00";
      this.m60DteFin = this.utilDate.dateToStringSQLLight(this.utilDate.dateDernierJourMois(var6)) + " 23:59:59";
      Date var7 = this.utilDate.dateMoisPrecedent(var6);
      this.m90DteDeb = this.utilDate.dateToStringSQLLight(this.utilDate.datePremierJourMois(var7)) + " 00:00:00";
      this.m90DteFin = this.utilDate.dateToStringSQLLight(this.utilDate.dateDernierJourMois(var7)) + " 23:59:59";
      Date var8 = this.utilDate.dateMoisPrecedent(var7);
      this.m120DteDeb = this.utilDate.dateToStringSQLLight(this.utilDate.datePremierJourMois(var8)) + " 00:00:00";
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Balance Agée client au " + var2;
         this.var_requete = "fcf_date_eche_reg<='" + var4 + "'";
      } else {
         this.var_entete = "Balance Agée client au " + var2 + " Série : " + this.serie;
         this.var_requete = "fcf_date_eche_reg<='" + var4 + "' and fcf_serie='" + this.serie + "'";
      }

      this.var_filtre = this.var_filtre + " Etat = Non Soldé";
      this.var_requete = this.var_requete + " and fcf_solde=0";
      if (this.nomTiers != null && !this.nomTiers.isEmpty()) {
         this.var_filtre = this.var_filtre + " Société = " + this.nomTiers;
         this.var_requete = this.var_requete + " and ach_facture_entete.tie_id=" + this.tiers.getTieid();
      }

      if (this.nomDestinataire != null && !this.nomDestinataire.isEmpty()) {
         this.var_filtre = this.var_filtre + " Contact = " + this.nomDestinataire;
         this.var_requete = this.var_requete + " and fcf_nom_contact like '" + this.nomDestinataire + "%'";
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_filtre = this.var_filtre + " Activité = " + this.activite;
         this.var_requete = this.var_requete + " and fcf_activite='" + this.activite + "'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_filtre = this.var_filtre + " Dossier = " + this.dossier;
         this.var_requete = this.var_requete + " and fcf_anal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_filtre = this.var_filtre + " Parc = " + this.parc;
         this.var_requete = this.var_requete + " and fcf_anal2='" + this.parc + "'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_filtre = this.var_filtre + " Site = " + this.site;
         this.var_requete = this.var_requete + " and fcf_site='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_filtre = this.var_filtre + " Département = " + this.departement;
         this.var_requete = this.var_requete + " and fcf_departement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and fcf_service='" + this.service + "'";
      }

      String[] var9;
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_filtre = this.var_filtre + " Région = " + this.region;
         var9 = this.region.split(":");
         this.var_requete = this.var_requete + " and fcf_region='" + var9[0] + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_filtre = this.var_filtre + " Secteur = " + this.secteur;
         var9 = this.secteur.split(":");
         this.var_requete = this.var_requete + " and fcf_secteur='" + var9[0] + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_filtre = this.var_filtre + " PDV = " + this.pdv;
         var9 = this.pdv.split(":");
         this.var_requete = this.var_requete + " and fcf_pdv='" + var9[0] + "'";
      }

      if (this.categorie != null && !this.categorie.isEmpty() && !this.categorie.equals("100")) {
         this.var_filtre = this.var_filtre + " Catégorie = " + this.categorie;
         this.var_requete = this.var_requete + " and fcf_cat='" + this.categorie + "'";
      }

      String var10;
      UserDao var11;
      if (this.commercial != null && !this.commercial.isEmpty() && !this.commercial.equals("100")) {
         var11 = new UserDao(this.baseLog, this.utilInitHibernate);
         var10 = var11.selectByIdUsers(Long.parseLong(this.commercial), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Responsable = " + var10;
         this.var_requete = this.var_requete + " and fcf_id_responsable=" + this.commercial;
      }

      if (this.createur != null && !this.createur.isEmpty() && !this.createur.equals("100")) {
         var11 = new UserDao(this.baseLog, this.utilInitHibernate);
         var10 = var11.selectByIdUsers(Long.parseLong(this.createur), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Créateur = " + var10;
         this.var_requete = this.var_requete + " and fcf_id_createur=" + this.createur;
      }

   }

   public void rechercheEcheancierSql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Echéancier fournisseur au " + var2;
         this.var_requete = "fcf_date_eche_reg<='" + this.exoSelectionne.getExeachDateFin() + "'";
      } else {
         this.var_entete = "Echéancier fournisseur au " + var2 + " Série : " + this.serie;
         this.var_requete = "fcf_date_eche_reg<='" + this.exoSelectionne.getExeachDateFin() + "' and fcf_serie='" + this.serie + "'";
      }

      this.var_filtre = this.var_filtre + " Etat = Non Soldé";
      this.var_requete = this.var_requete + " and fcf_solde=0";
      if (this.nomTiers != null && !this.nomTiers.isEmpty()) {
         this.var_filtre = this.var_filtre + " Société = " + this.nomTiers;
         this.var_requete = this.var_requete + " and ach_facture_entete.tie_id=" + this.tiers.getTieid();
      }

      if (this.nomDestinataire != null && !this.nomDestinataire.isEmpty()) {
         this.var_filtre = this.var_filtre + " Contact = " + this.nomDestinataire;
         this.var_requete = this.var_requete + " and fcf_nom_contact like '" + this.nomDestinataire + "%'";
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_filtre = this.var_filtre + " Activité = " + this.activite;
         this.var_requete = this.var_requete + " and fcf_activite='" + this.activite + "'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_filtre = this.var_filtre + " Dossier = " + this.dossier;
         this.var_requete = this.var_requete + " and fcf_anal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_filtre = this.var_filtre + " Parc = " + this.parc;
         this.var_requete = this.var_requete + " and fcf_anal2='" + this.parc + "'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_filtre = this.var_filtre + " Site = " + this.site;
         this.var_requete = this.var_requete + " and fcf_site='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_filtre = this.var_filtre + " Département = " + this.departement;
         this.var_requete = this.var_requete + " and fcf_departement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and fcf_service='" + this.service + "'";
      }

      String[] var5;
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_filtre = this.var_filtre + " Région = " + this.region;
         var5 = this.region.split(":");
         this.var_requete = this.var_requete + " and fcf_region='" + var5[0] + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_filtre = this.var_filtre + " Secteur = " + this.secteur;
         var5 = this.secteur.split(":");
         this.var_requete = this.var_requete + " and fcf_secteur='" + var5[0] + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_filtre = this.var_filtre + " PDV = " + this.pdv;
         var5 = this.pdv.split(":");
         this.var_requete = this.var_requete + " and fcf_pdv='" + var5[0] + "'";
      }

      if (this.categorie != null && !this.categorie.isEmpty() && !this.categorie.equals("100")) {
         this.var_filtre = this.var_filtre + " Catégorie = " + this.categorie;
         this.var_requete = this.var_requete + " and fcf_cat='" + this.categorie + "'";
      }

      String var6;
      UserDao var7;
      if (this.commercial != null && !this.commercial.isEmpty() && !this.commercial.equals("100")) {
         var7 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var7.selectByIdUsers(Long.parseLong(this.commercial), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Responsable = " + var6;
         this.var_requete = this.var_requete + " and fcf_id_responsable=" + this.commercial;
      }

      if (this.createur != null && !this.createur.isEmpty() && !this.createur.equals("100")) {
         var7 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var7.selectByIdUsers(Long.parseLong(this.createur), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Créateur = " + var6;
         this.var_requete = this.var_requete + " and fcf_id_createur=" + this.createur;
      }

   }

   public void rechercheCotationSql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Liste des Cotations du " + var1 + " au " + var2;
         this.var_requete = "cot_date>='" + var3 + "' and cot_date<='" + var4 + "'";
      } else {
         this.var_entete = "Liste des Cotation du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "cot_date>='" + var3 + "' and cot_date<='" + var4 + "' and cot_serie='" + this.serie + "'";
      }

      if (this.etat != null && !this.etat.isEmpty() && !this.etat.equals("100")) {
         int var5 = Integer.parseInt(this.etat);
         if (var5 == 0) {
            this.var_filtre = this.var_filtre + " Etat = En cours";
            this.var_requete = this.var_requete + " and cot_etat=" + var5;
         } else if (var5 == 1) {
            this.var_filtre = this.var_filtre + " Etat = Validé";
            this.var_requete = this.var_requete + " and cot_etat=" + var5;
         } else if (var5 == 2) {
            this.var_filtre = this.var_filtre + " Etat = Gelé";
            this.var_requete = this.var_requete + " and cot_etat=" + var5;
         } else if (var5 == 3) {
            this.var_filtre = this.var_filtre + " Etat = Annulé";
            this.var_requete = this.var_requete + " and cot_etat=" + var5;
         } else if (var5 == 4) {
            this.var_filtre = this.var_filtre + " Etat = Transformation patielle";
            this.var_requete = this.var_requete + " and cot_etat=" + var5;
         } else if (var5 == 5) {
            this.var_filtre = this.var_filtre + " Etat = Transformation totale";
            this.var_requete = this.var_requete + " and cot_etat=" + var5;
         } else if (var5 == 11) {
            this.var_filtre = this.var_filtre + " Etat = Relancé";
            this.var_requete = this.var_requete + " and cot_date_relance!=null";
         } else if (var5 == 12) {
            this.var_filtre = this.var_filtre + " Etat = Promotion";
            this.var_requete = this.var_requete + " and cot_tot_ht=0";
         } else if (var5 == 13) {
            this.var_filtre = this.var_filtre + " Etat = Non payé";
            this.var_requete = this.var_requete + " and cot_solde=0";
         } else if (var5 == 14) {
            this.var_filtre = this.var_filtre + " Etat = Payé";
            this.var_requete = this.var_requete + " and cot_solde=1";
         } else if (var5 == 15) {
            this.var_filtre = this.var_filtre + " Etat = Exonéré";
            this.var_requete = this.var_requete + " and cot_exo_tva=1";
         }
      }

      if (this.document != null && !this.document.isEmpty()) {
         this.var_filtre = this.var_filtre + " N° Cotation = " + this.document;
         this.var_requete = this.var_requete + " and ach_cotation_entete.cot_num='" + this.document + "'";
      }

      if (this.nomTiers != null && !this.nomTiers.isEmpty()) {
         this.var_filtre = this.var_filtre + " Société = " + this.nomTiers;
         this.var_requete = this.var_requete + " and ach_cotation_entete.tie_id=" + this.tiers.getTieid();
      }

      if (this.nomDestinataire != null && !this.nomDestinataire.isEmpty()) {
         this.var_filtre = this.var_filtre + " Contact = " + this.nomDestinataire;
         this.var_requete = this.var_requete + " and cot_nom_contact like '" + this.nomDestinataire + "%'";
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_filtre = this.var_filtre + " Activité = " + this.activite;
         this.var_requete = this.var_requete + " and cot_activite='" + this.activite + "'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_filtre = this.var_filtre + " Dossier = " + this.dossier;
         this.var_requete = this.var_requete + " and cot_anal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_filtre = this.var_filtre + " Parc = " + this.parc;
         this.var_requete = this.var_requete + " and cot_anal2='" + this.parc + "'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_filtre = this.var_filtre + " Site = " + this.site;
         this.var_requete = this.var_requete + " and cot_site='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_filtre = this.var_filtre + " Département = " + this.departement;
         this.var_requete = this.var_requete + " and cot_departement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and cot_service='" + this.service + "'";
      }

      String[] var7;
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_filtre = this.var_filtre + " Région = " + this.region;
         var7 = this.region.split(":");
         this.var_requete = this.var_requete + " and cot_region='" + var7[0] + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_filtre = this.var_filtre + " Secteur = " + this.secteur;
         var7 = this.secteur.split(":");
         this.var_requete = this.var_requete + " and cot_secteur='" + var7[0] + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_filtre = this.var_filtre + " PDV = " + this.pdv;
         var7 = this.pdv.split(":");
         this.var_requete = this.var_requete + " and cot_pdv='" + var7[0] + "'";
      }

      if (this.categorie != null && !this.categorie.isEmpty() && !this.categorie.equals("100")) {
         this.var_filtre = this.var_filtre + " Catégorie = " + this.categorie;
         this.var_requete = this.var_requete + " and cot_cat='" + this.categorie + "'";
      }

      String var6;
      UserDao var8;
      if (this.commercial != null && !this.commercial.isEmpty() && !this.commercial.equals("100")) {
         var8 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var8.selectByIdUsers(Long.parseLong(this.commercial), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Responsable = " + var6;
         this.var_requete = this.var_requete + " and cot_id_responsable=" + this.commercial;
      }

      if (this.createur != null && !this.createur.isEmpty() && !this.createur.equals("100")) {
         var8 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var8.selectByIdUsers(Long.parseLong(this.createur), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Créateur = " + var6;
         this.var_requete = this.var_requete + " and cot_id_createur=" + this.createur;
      }

      if (this.nomRepertoire.equalsIgnoreCase("ligne_cotation")) {
         if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
            this.var_filtre = this.var_filtre + " du Produit = " + this.produitDebut;
            this.var_requete = this.var_requete + " and cotlig_code>='" + this.produitDebut + "'";
         }

         if (this.produitFin != null && !this.produitFin.isEmpty()) {
            this.var_filtre = this.var_filtre + " au Produit = " + this.produitFin;
            this.var_requete = this.var_requete + " and cotlig_code<='" + this.produitFin + "'";
         }

         if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
            this.var_filtre = this.var_filtre + " famille = " + this.famille;
            var7 = this.famille.split(":");
            this.var_requete = this.var_requete + " and cotlig_famille like'" + var7[0] + "%'";
         }
      }

   }

   public void rechercheCotationHql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Liste des Cotations du " + var1 + " au " + var2;
         this.var_requete = "cotationEnteteAchats.cotDate>='" + var3 + "' and cotationEnteteAchats.cotDate<='" + var4 + "'";
      } else {
         this.var_entete = "Liste des Cotations du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "cotationEnteteAchats.cotDate>='" + var3 + "' and cotationEnteteAchats.cotDate<='" + var4 + "' and cotationEnteteAchats.cotSerie='" + this.serie + "'";
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_filtre = this.var_filtre + " Activité = " + this.activite;
         this.var_requete = this.var_requete + " and cotationEnteteAchats.cotActivite='" + this.activite + "'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_filtre = this.var_filtre + " Dossier = " + this.dossier;
         this.var_requete = this.var_requete + " and cotationEnteteAchats.cotAnal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_filtre = this.var_filtre + " Parc = " + this.parc;
         this.var_requete = this.var_requete + " and cotationEnteteAchats.cotAnal2='" + this.parc + "'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_filtre = this.var_filtre + " Site = " + this.site;
         this.var_requete = this.var_requete + " and cotationEnteteAchats.cotSite='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_filtre = this.var_filtre + " Département = " + this.departement;
         this.var_requete = this.var_requete + " and cotationEnteteAchats.cotDepartement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and cotationEnteteAchats.cotService='" + this.service + "'";
      }

      String[] var5;
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_filtre = this.var_filtre + " Région = " + this.region;
         var5 = this.region.split(":");
         this.var_requete = this.var_requete + " and cotationEnteteAchats.cotRegion='" + var5[0] + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_filtre = this.var_filtre + " Secteur = " + this.secteur;
         var5 = this.secteur.split(":");
         this.var_requete = this.var_requete + " and cotationEnteteAchats.cotSecteur='" + var5[0] + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_filtre = this.var_filtre + " PDV = " + this.pdv;
         var5 = this.pdv.split(":");
         this.var_requete = this.var_requete + " and cotationEnteteAchats.cotPdv='" + var5[0] + "'";
      }

      if (this.categorie != null && !this.categorie.isEmpty() && !this.categorie.equals("100")) {
         this.var_filtre = this.var_filtre + " Catégorie = " + this.categorie;
         this.var_requete = this.var_requete + " and cotationEnteteAchats.cotCat='" + this.categorie + "'";
      }

      if (this.nomRepertoire.equalsIgnoreCase("ligne_cotation") || this.nomRepertoire.equalsIgnoreCase("ligne_synthese")) {
         if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
            this.var_filtre = this.var_filtre + " du Produit = " + this.produitDebut;
            this.var_requete = this.var_requete + " and cotligCode>='" + this.produitDebut + "'";
         }

         if (this.produitFin != null && !this.produitFin.isEmpty()) {
            this.var_filtre = this.var_filtre + " au Produit = " + this.produitFin;
            this.var_requete = this.var_requete + " and cotligCode<='" + this.produitFin + "'";
         }

         if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
            this.var_filtre = this.var_filtre + " famille = " + this.famille;
            var5 = this.famille.split(":");
            this.var_requete = this.var_requete + " and cotligFamille like'" + var5[0] + "%'";
         }
      }

   }

   public void rechercheCommandeSql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Liste des Commandes du " + var1 + " au " + var2;
         this.var_requete = "cmd_date>='" + var3 + "' and cmd_date<='" + var4 + "'";
      } else {
         this.var_entete = "Liste des Commandes du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "cmd_date>='" + var3 + "' and cmd_date<='" + var4 + "' and cmd_serie='" + this.serie + "'";
      }

      if (this.etat != null && !this.etat.isEmpty() && !this.etat.equals("100")) {
         int var5 = Integer.parseInt(this.etat);
         if (var5 == 0) {
            this.var_filtre = this.var_filtre + " Etat = En cours";
            this.var_requete = this.var_requete + " and cmd_etat=" + var5;
         } else if (var5 == 1) {
            this.var_filtre = this.var_filtre + " Etat = Validé";
            this.var_requete = this.var_requete + " and cmd_etat=" + var5;
         } else if (var5 == 2) {
            this.var_filtre = this.var_filtre + " Etat = Gelé";
            this.var_requete = this.var_requete + " and cmd_etat=" + var5;
         } else if (var5 == 3) {
            this.var_filtre = this.var_filtre + " Etat = Annulé";
            this.var_requete = this.var_requete + " and cmd_etat=" + var5;
         } else if (var5 == 4) {
            this.var_filtre = this.var_filtre + " Etat = Transformation patielle";
            this.var_requete = this.var_requete + " and cmd_etat=" + var5;
         } else if (var5 == 5) {
            this.var_filtre = this.var_filtre + " Etat = Transformation totale";
            this.var_requete = this.var_requete + " and cmd_etat=" + var5;
         } else if (var5 == 11) {
            this.var_filtre = this.var_filtre + " Etat = Relancé";
            this.var_requete = this.var_requete + " and cmd_date_relance!=null";
         } else if (var5 == 12) {
            this.var_filtre = this.var_filtre + " Etat = Promotion";
            this.var_requete = this.var_requete + " and cmd_tot_ht=0";
         } else if (var5 == 13) {
            this.var_filtre = this.var_filtre + " Etat = Non payé";
            this.var_requete = this.var_requete + " and cmd_solde=0";
         } else if (var5 == 14) {
            this.var_filtre = this.var_filtre + " Etat = Payé";
            this.var_requete = this.var_requete + " and cmd_solde=1";
         } else if (var5 == 15) {
            this.var_filtre = this.var_filtre + " Etat = Exonéré";
            this.var_requete = this.var_requete + " and cmd_exo_tva=1";
         }
      }

      if (this.document != null && !this.document.isEmpty()) {
         this.var_filtre = this.var_filtre + " N° Commande = " + this.document;
         this.var_requete = this.var_requete + " and ach_commande_entete.cmd_num='" + this.document + "'";
      }

      if (this.nomTiers != null && !this.nomTiers.isEmpty()) {
         this.var_filtre = this.var_filtre + " Société = " + this.nomTiers;
         this.var_requete = this.var_requete + " and ach_commande_entete.tie_id=" + this.tiers.getTieid();
      }

      if (this.nomDestinataire != null && !this.nomDestinataire.isEmpty()) {
         this.var_filtre = this.var_filtre + " Contact = " + this.nomDestinataire;
         this.var_requete = this.var_requete + " and cmd_nom_contact like '" + this.nomDestinataire + "%'";
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_filtre = this.var_filtre + " Activité = " + this.activite;
         this.var_requete = this.var_requete + " and cmd_activite='" + this.activite + "'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_filtre = this.var_filtre + " Dossier = " + this.dossier;
         this.var_requete = this.var_requete + " and cmd_anal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_filtre = this.var_filtre + " Parc = " + this.parc;
         this.var_requete = this.var_requete + " and cmd_anal2='" + this.parc + "'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_filtre = this.var_filtre + " Site = " + this.site;
         this.var_requete = this.var_requete + " and cmd_site='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_filtre = this.var_filtre + " Département = " + this.departement;
         this.var_requete = this.var_requete + " and cmd_departement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and cmd_service='" + this.service + "'";
      }

      String[] var7;
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_filtre = this.var_filtre + " Région = " + this.region;
         var7 = this.region.split(":");
         this.var_requete = this.var_requete + " and cmd_region='" + var7[0] + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_filtre = this.var_filtre + " Secteur = " + this.secteur;
         var7 = this.secteur.split(":");
         this.var_requete = this.var_requete + " and cmd_secteur='" + var7[0] + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_filtre = this.var_filtre + " PDV = " + this.pdv;
         var7 = this.pdv.split(":");
         this.var_requete = this.var_requete + " and cmd_pdv='" + var7[0] + "'";
      }

      if (this.categorie != null && !this.categorie.isEmpty() && !this.categorie.equals("100")) {
         this.var_filtre = this.var_filtre + " Catégorie = " + this.categorie;
         this.var_requete = this.var_requete + " and cmd_cat='" + this.categorie + "'";
      }

      String var6;
      UserDao var8;
      if (this.commercial != null && !this.commercial.isEmpty() && !this.commercial.equals("100")) {
         var8 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var8.selectByIdUsers(Long.parseLong(this.commercial), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Responsable = " + var6;
         this.var_requete = this.var_requete + " and cmd_id_responsable=" + this.commercial;
      }

      if (this.createur != null && !this.createur.isEmpty() && !this.createur.equals("100")) {
         var8 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var8.selectByIdUsers(Long.parseLong(this.createur), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Créateur = " + var6;
         this.var_requete = this.var_requete + " and cmd_id_createur=" + this.createur;
      }

      if (this.nomRepertoire.equalsIgnoreCase("ligne_commande")) {
         if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
            this.var_filtre = this.var_filtre + " du Produit = " + this.produitDebut;
            this.var_requete = this.var_requete + " and cmdlig_code>='" + this.produitDebut + "'";
         }

         if (this.produitFin != null && !this.produitFin.isEmpty()) {
            this.var_filtre = this.var_filtre + " au Produit = " + this.produitFin;
            this.var_requete = this.var_requete + " and cmdlig_code<='" + this.produitFin + "'";
         }

         if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
            this.var_filtre = this.var_filtre + " famille = " + this.famille;
            var7 = this.famille.split(":");
            this.var_requete = this.var_requete + " and cmdlig_famille like'" + var7[0] + "%'";
         }
      }

   }

   public void rechercheCommandeHql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Liste des Commandes du " + var1 + " au " + var2;
         this.var_requete = "commandeEnteteAchats.cmdDate>='" + var3 + "' and commandeEnteteAchats.cmdDate<='" + var4 + "'";
      } else {
         this.var_entete = "Liste des Commandes du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "commandeEnteteAchats.cmdDate>='" + var3 + "' and commandeEnteteAchats.cmdDate<='" + var4 + "' and commandeEnteteAchats.cmdSerie='" + this.serie + "'";
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_filtre = this.var_filtre + " Activité = " + this.activite;
         this.var_requete = this.var_requete + " and commandeEnteteAchats.cmdActivite='" + this.activite + "'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_filtre = this.var_filtre + " Dossier = " + this.dossier;
         this.var_requete = this.var_requete + " and commandeEnteteAchats.cmdAnal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_filtre = this.var_filtre + " Parc = " + this.parc;
         this.var_requete = this.var_requete + " and commandeEnteteAchats.cmdAnal2='" + this.parc + "'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_filtre = this.var_filtre + " Site = " + this.site;
         this.var_requete = this.var_requete + " and commandeEnteteAchats.cmdSite='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_filtre = this.var_filtre + " Département = " + this.departement;
         this.var_requete = this.var_requete + " and commandeEnteteAchats.cmdDepartement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and commandeEnteteAchats.cmdService='" + this.service + "'";
      }

      String[] var5;
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_filtre = this.var_filtre + " Région = " + this.region;
         var5 = this.region.split(":");
         this.var_requete = this.var_requete + " and commandeEnteteAchats.cmdRegion='" + var5[0] + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_filtre = this.var_filtre + " Secteur = " + this.secteur;
         var5 = this.secteur.split(":");
         this.var_requete = this.var_requete + " and commandeEnteteAchats.cmdSecteur='" + var5[0] + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_filtre = this.var_filtre + " PDV = " + this.pdv;
         var5 = this.pdv.split(":");
         this.var_requete = this.var_requete + " and commandeEnteteAchats.cmdPdv='" + var5[0] + "'";
      }

      if (this.categorie != null && !this.categorie.isEmpty() && !this.categorie.equals("100")) {
         this.var_filtre = this.var_filtre + " Catégorie = " + this.categorie;
         this.var_requete = this.var_requete + " and commandeEnteteAchats.cmdCat='" + this.categorie + "'";
      }

      if (this.nomRepertoire.equalsIgnoreCase("ligne_commande") || this.nomRepertoire.equalsIgnoreCase("ligne_synthese")) {
         if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
            this.var_filtre = this.var_filtre + " du Produit = " + this.produitDebut;
            this.var_requete = this.var_requete + " and cmdligCode>='" + this.produitDebut + "'";
         }

         if (this.produitFin != null && !this.produitFin.isEmpty()) {
            this.var_filtre = this.var_filtre + " au Produit = " + this.produitFin;
            this.var_requete = this.var_requete + " and cmdligCode<='" + this.produitFin + "'";
         }

         if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
            this.var_filtre = this.var_filtre + " famille = " + this.famille;
            var5 = this.famille.split(":");
            this.var_requete = this.var_requete + " and cmdligFamille like'" + var5[0] + "%'";
         }
      }

   }

   public void rechercheReceptionSql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Liste des Réceptions du " + var1 + " au " + var2;
         this.var_requete = "rec_date>='" + var3 + "' and rec_date<='" + var4 + "'";
      } else {
         this.var_entete = "Liste des Réceptions du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "rec_date>='" + var3 + "' and rec_date<='" + var4 + "' and rec_serie='" + this.serie + "'";
      }

      if (this.etat != null && !this.etat.isEmpty() && !this.etat.equals("100")) {
         int var5 = Integer.parseInt(this.etat);
         if (var5 == 0) {
            this.var_filtre = this.var_filtre + " Etat = En cours";
            this.var_requete = this.var_requete + " and rec_etat=" + var5;
         } else if (var5 == 1) {
            this.var_filtre = this.var_filtre + " Etat = Validé";
            this.var_requete = this.var_requete + " and rec_etat=" + var5;
         } else if (var5 == 2) {
            this.var_filtre = this.var_filtre + " Etat = Gelé";
            this.var_requete = this.var_requete + " and rec_etat=" + var5;
         } else if (var5 == 3) {
            this.var_filtre = this.var_filtre + " Etat = Annulé";
            this.var_requete = this.var_requete + " and rec_etat=" + var5;
         } else if (var5 == 4) {
            this.var_filtre = this.var_filtre + " Etat = Transformation patielle";
            this.var_requete = this.var_requete + " and rec_etat=" + var5;
         } else if (var5 == 5) {
            this.var_filtre = this.var_filtre + " Etat = Transformation totale";
            this.var_requete = this.var_requete + " and rec_etat=" + var5;
         } else if (var5 == 11) {
            this.var_filtre = this.var_filtre + " Etat = Relancé";
            this.var_requete = this.var_requete + " and rec_date_relance!=null";
         } else if (var5 == 12) {
            this.var_filtre = this.var_filtre + " Etat = Promotion";
            this.var_requete = this.var_requete + " and rec_tot_ht=0";
         } else if (var5 == 13) {
            this.var_filtre = this.var_filtre + " Etat = Non payé";
            this.var_requete = this.var_requete + " and rec_solde=0";
         } else if (var5 == 14) {
            this.var_filtre = this.var_filtre + " Etat = Payé";
            this.var_requete = this.var_requete + " and rec_solde=1";
         } else if (var5 == 15) {
            this.var_filtre = this.var_filtre + " Etat = Exonéré";
            this.var_requete = this.var_requete + " and rec_exo_tva=1";
         }
      }

      if (this.document != null && !this.document.isEmpty()) {
         this.var_filtre = this.var_filtre + " N° Réception = " + this.document;
         this.var_requete = this.var_requete + " and ach_reception_entete.rec_num='" + this.document + "'";
      }

      if (this.nomTiers != null && !this.nomTiers.isEmpty()) {
         this.var_filtre = this.var_filtre + " Société = " + this.nomTiers;
         this.var_requete = this.var_requete + " and ach_reception_entete.tie_id=" + this.tiers.getTieid();
      }

      if (this.nomDestinataire != null && !this.nomDestinataire.isEmpty()) {
         this.var_filtre = this.var_filtre + " Contact = " + this.nomDestinataire;
         this.var_requete = this.var_requete + " and rec_nom_contact like '" + this.nomDestinataire + "%'";
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_filtre = this.var_filtre + " Activité = " + this.activite;
         this.var_requete = this.var_requete + " and rec_activite='" + this.activite + "'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_filtre = this.var_filtre + " Dossier = " + this.dossier;
         this.var_requete = this.var_requete + " and rec_anal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_filtre = this.var_filtre + " Parc = " + this.parc;
         this.var_requete = this.var_requete + " and rec_anal2='" + this.parc + "'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_filtre = this.var_filtre + " Site = " + this.site;
         this.var_requete = this.var_requete + " and rec_site='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_filtre = this.var_filtre + " Département = " + this.departement;
         this.var_requete = this.var_requete + " and rec_departement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and rec_service='" + this.service + "'";
      }

      String[] var7;
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_filtre = this.var_filtre + " Région = " + this.region;
         var7 = this.region.split(":");
         this.var_requete = this.var_requete + " and rec_region='" + var7[0] + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_filtre = this.var_filtre + " Secteur = " + this.secteur;
         var7 = this.secteur.split(":");
         this.var_requete = this.var_requete + " and rec_secteur='" + var7[0] + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_filtre = this.var_filtre + " PDV = " + this.pdv;
         var7 = this.pdv.split(":");
         this.var_requete = this.var_requete + " and rec_pdv='" + var7[0] + "'";
      }

      if (this.categorie != null && !this.categorie.isEmpty() && !this.categorie.equals("100")) {
         this.var_filtre = this.var_filtre + " Catégorie = " + this.categorie;
         this.var_requete = this.var_requete + " and rec_cat='" + this.categorie + "'";
      }

      String var6;
      UserDao var8;
      if (this.commercial != null && !this.commercial.isEmpty() && !this.commercial.equals("100")) {
         var8 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var8.selectByIdUsers(Long.parseLong(this.commercial), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Responsable = " + var6;
         this.var_requete = this.var_requete + " and rec_id_responsable=" + this.commercial;
      }

      if (this.createur != null && !this.createur.isEmpty() && !this.createur.equals("100")) {
         var8 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var8.selectByIdUsers(Long.parseLong(this.createur), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Créateur = " + var6;
         this.var_requete = this.var_requete + " and rec_id_createur=" + this.createur;
      }

      if (this.nomRepertoire.equalsIgnoreCase("ligne_reception")) {
         if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
            this.var_filtre = this.var_filtre + " du Produit = " + this.produitDebut;
            this.var_requete = this.var_requete + " and reclig_code>='" + this.produitDebut + "'";
         }

         if (this.produitFin != null && !this.produitFin.isEmpty()) {
            this.var_filtre = this.var_filtre + " au Produit = " + this.produitFin;
            this.var_requete = this.var_requete + " and reclig_code<='" + this.produitFin + "'";
         }

         if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
            this.var_filtre = this.var_filtre + " famille = " + this.famille;
            var7 = this.famille.split(":");
            this.var_requete = this.var_requete + " and reclig_famille like'" + var7[0] + "%'";
         }
      }

   }

   public void rechercheReceptionHql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Liste des Réceptions du " + var1 + " au " + var2;
         this.var_requete = "receptionEnteteAchats.recDate>='" + var3 + "' and receptionEnteteAchats.recDate<='" + var4 + "'";
      } else {
         this.var_entete = "Liste des Réceptions du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "receptionEnteteAchats.recDate>='" + var3 + "' and receptionEnteteAchats.recDate<='" + var4 + "' and receptionEnteteAchats.recSerie='" + this.serie + "'";
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_filtre = this.var_filtre + " Activité = " + this.activite;
         this.var_requete = this.var_requete + " and receptionEnteteAchats.recActivite='" + this.activite + "'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_filtre = this.var_filtre + " Dossier = " + this.dossier;
         this.var_requete = this.var_requete + " and receptionEnteteAchats.recAnal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_filtre = this.var_filtre + " Parc = " + this.parc;
         this.var_requete = this.var_requete + " and receptionEnteteAchats.recAnal2='" + this.parc + "'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_filtre = this.var_filtre + " Site = " + this.site;
         this.var_requete = this.var_requete + " and receptionEnteteAchats.recSite='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_filtre = this.var_filtre + " Département = " + this.departement;
         this.var_requete = this.var_requete + " and receptionEnteteAchats.recDepartement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and receptionEnteteAchats.recService='" + this.service + "'";
      }

      String[] var5;
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_filtre = this.var_filtre + " Région = " + this.region;
         var5 = this.region.split(":");
         this.var_requete = this.var_requete + " and receptionEnteteAchats.recRegion='" + var5[0] + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_filtre = this.var_filtre + " Secteur = " + this.secteur;
         var5 = this.secteur.split(":");
         this.var_requete = this.var_requete + " and receptionEnteteAchats.recSecteur='" + var5[0] + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_filtre = this.var_filtre + " PDV = " + this.pdv;
         var5 = this.pdv.split(":");
         this.var_requete = this.var_requete + " and receptionEnteteAchats.recPdv='" + var5[0] + "'";
      }

      if (this.categorie != null && !this.categorie.isEmpty() && !this.categorie.equals("100")) {
         this.var_filtre = this.var_filtre + " Catégorie = " + this.categorie;
         this.var_requete = this.var_requete + " and receptionEnteteAchats.recCat='" + this.categorie + "'";
      }

      if (this.nomRepertoire.equalsIgnoreCase("ligne_reception") || this.nomRepertoire.equalsIgnoreCase("ligne_synthese")) {
         if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
            this.var_filtre = this.var_filtre + " du Produit = " + this.produitDebut;
            this.var_requete = this.var_requete + " and recligCode>='" + this.produitDebut + "'";
         }

         if (this.produitFin != null && !this.produitFin.isEmpty()) {
            this.var_filtre = this.var_filtre + " au Produit = " + this.produitFin;
            this.var_requete = this.var_requete + " and recligCode<='" + this.produitFin + "'";
         }

         if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
            this.var_filtre = this.var_filtre + " famille = " + this.famille;
            var5 = this.famille.split(":");
            this.var_requete = this.var_requete + " and recligFamille like'" + var5[0] + "%'";
         }
      }

   }

   public void rechercheRetourSql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Liste des Retours du " + var1 + " au " + var2;
         this.var_requete = "brf_date>='" + var3 + "' and brf_date<='" + var4 + "'";
      } else {
         this.var_entete = "Liste des Retours du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "brf_date>='" + var3 + "' and brf_date<='" + var4 + "' and brf_serie='" + this.serie + "'";
      }

      if (this.etat != null && !this.etat.isEmpty() && !this.etat.equals("100")) {
         int var5 = Integer.parseInt(this.etat);
         if (var5 == 0) {
            this.var_filtre = this.var_filtre + " Etat = En cours";
            this.var_requete = this.var_requete + " and brf_etat=" + var5;
         } else if (var5 == 1) {
            this.var_filtre = this.var_filtre + " Etat = Validé";
            this.var_requete = this.var_requete + " and brf_etat=" + var5;
         } else if (var5 == 2) {
            this.var_filtre = this.var_filtre + " Etat = Gelé";
            this.var_requete = this.var_requete + " and brf_etat=" + var5;
         } else if (var5 == 3) {
            this.var_filtre = this.var_filtre + " Etat = Annulé";
            this.var_requete = this.var_requete + " and brf_etat=" + var5;
         } else if (var5 == 4) {
            this.var_filtre = this.var_filtre + " Etat = Transformation patielle";
            this.var_requete = this.var_requete + " and brf_etat=" + var5;
         } else if (var5 == 5) {
            this.var_filtre = this.var_filtre + " Etat = Transformation totale";
            this.var_requete = this.var_requete + " and brf_etat=" + var5;
         } else if (var5 == 11) {
            this.var_filtre = this.var_filtre + " Etat = Relancé";
            this.var_requete = this.var_requete + " and brf_date_relance!=null";
         } else if (var5 == 12) {
            this.var_filtre = this.var_filtre + " Etat = Promotion";
            this.var_requete = this.var_requete + " and brf_tot_ht=0";
         } else if (var5 == 13) {
            this.var_filtre = this.var_filtre + " Etat = Non payé";
            this.var_requete = this.var_requete + " and brf_solde=0";
         } else if (var5 == 14) {
            this.var_filtre = this.var_filtre + " Etat = Payé";
            this.var_requete = this.var_requete + " and brf_solde=1";
         } else if (var5 == 15) {
            this.var_filtre = this.var_filtre + " Etat = Exonéré";
            this.var_requete = this.var_requete + " and brf_exo_tva=1";
         }
      }

      if (this.document != null && !this.document.isEmpty()) {
         this.var_filtre = this.var_filtre + " N° Retour = " + this.document;
         this.var_requete = this.var_requete + " and ach_retour_entete.brf_num='" + this.document + "'";
      }

      if (this.nomTiers != null && !this.nomTiers.isEmpty()) {
         this.var_filtre = this.var_filtre + " Société = " + this.nomTiers;
         this.var_requete = this.var_requete + " and ach_retour_entete.tie_id=" + this.tiers.getTieid();
      }

      if (this.nomDestinataire != null && !this.nomDestinataire.isEmpty()) {
         this.var_filtre = this.var_filtre + " Contact = " + this.nomDestinataire;
         this.var_requete = this.var_requete + " and brf_nom_contact like '" + this.nomDestinataire + "%'";
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_filtre = this.var_filtre + " Activité = " + this.activite;
         this.var_requete = this.var_requete + " and brf_activite='" + this.activite + "'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_filtre = this.var_filtre + " Dossier = " + this.dossier;
         this.var_requete = this.var_requete + " and brf_anal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_filtre = this.var_filtre + " Parc = " + this.parc;
         this.var_requete = this.var_requete + " and brf_anal2='" + this.parc + "'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_filtre = this.var_filtre + " Site = " + this.site;
         this.var_requete = this.var_requete + " and brf_site='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_filtre = this.var_filtre + " Département = " + this.departement;
         this.var_requete = this.var_requete + " and brf_departement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and brf_service='" + this.service + "'";
      }

      String[] var7;
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_filtre = this.var_filtre + " Région = " + this.region;
         var7 = this.region.split(":");
         this.var_requete = this.var_requete + " and brf_region='" + var7[0] + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_filtre = this.var_filtre + " Secteur = " + this.secteur;
         var7 = this.secteur.split(":");
         this.var_requete = this.var_requete + " and brf_secteur='" + var7[0] + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_filtre = this.var_filtre + " PDV = " + this.pdv;
         var7 = this.pdv.split(":");
         this.var_requete = this.var_requete + " and brf_pdv='" + var7[0] + "'";
      }

      if (this.categorie != null && !this.categorie.isEmpty() && !this.categorie.equals("100")) {
         this.var_filtre = this.var_filtre + " Catégorie = " + this.categorie;
         this.var_requete = this.var_requete + " and brf_cat='" + this.categorie + "'";
      }

      String var6;
      UserDao var8;
      if (this.commercial != null && !this.commercial.isEmpty() && !this.commercial.equals("100")) {
         var8 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var8.selectByIdUsers(Long.parseLong(this.commercial), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Responsable = " + var6;
         this.var_requete = this.var_requete + " and brf_id_responsable=" + this.commercial;
      }

      if (this.createur != null && !this.createur.isEmpty() && !this.createur.equals("100")) {
         var8 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var8.selectByIdUsers(Long.parseLong(this.createur), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Créateur = " + var6;
         this.var_requete = this.var_requete + " and brf_id_createur=" + this.createur;
      }

      if (this.nomRepertoire.equalsIgnoreCase("ligne_retour")) {
         if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
            this.var_filtre = this.var_filtre + " du Produit = " + this.produitDebut;
            this.var_requete = this.var_requete + " and brflig_code>='" + this.produitDebut + "'";
         }

         if (this.produitFin != null && !this.produitFin.isEmpty()) {
            this.var_filtre = this.var_filtre + " au Produit = " + this.produitFin;
            this.var_requete = this.var_requete + " and brflig_code<='" + this.produitFin + "'";
         }

         if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
            this.var_filtre = this.var_filtre + " famille = " + this.famille;
            var7 = this.famille.split(":");
            this.var_requete = this.var_requete + " and brflig_famille like'" + var7[0] + "%'";
         }
      }

   }

   public void rechercheRetourHql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Liste des Retours du " + var1 + " au " + var2;
         this.var_requete = "retourEnteteAchats.brfDate>='" + var3 + "' and retourEnteteAchats.brfDate<='" + var4 + "'";
      } else {
         this.var_entete = "Liste des Retours du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "retourEnteteAchats.brfDate>='" + var3 + "' and retourEnteteAchats.brfDate<='" + var4 + "' and retourEnteteAchats.brfSerie='" + this.serie + "'";
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_filtre = this.var_filtre + " Activité = " + this.activite;
         this.var_requete = this.var_requete + " and retourEnteteAchats.brfActivite='" + this.activite + "'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_filtre = this.var_filtre + " Dossier = " + this.dossier;
         this.var_requete = this.var_requete + " and retourEnteteAchats.brfAnal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_filtre = this.var_filtre + " Parc = " + this.parc;
         this.var_requete = this.var_requete + " and retourEnteteAchats.brfAnal2='" + this.parc + "'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_filtre = this.var_filtre + " Site = " + this.site;
         this.var_requete = this.var_requete + " and retourEnteteAchats.brfSite='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_filtre = this.var_filtre + " Département = " + this.departement;
         this.var_requete = this.var_requete + " and retourEnteteAchats.brfDepartement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and retourEnteteAchats.brfService='" + this.service + "'";
      }

      String[] var5;
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_filtre = this.var_filtre + " Région = " + this.region;
         var5 = this.region.split(":");
         this.var_requete = this.var_requete + " and retourEnteteAchats.brfRegion='" + var5[0] + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_filtre = this.var_filtre + " Secteur = " + this.secteur;
         var5 = this.secteur.split(":");
         this.var_requete = this.var_requete + " and retourEnteteAchats.brfSecteur='" + var5[0] + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_filtre = this.var_filtre + " PDV = " + this.pdv;
         var5 = this.pdv.split(":");
         this.var_requete = this.var_requete + " and retourEnteteAchats.brfPdv='" + var5[0] + "'";
      }

      if (this.categorie != null && !this.categorie.isEmpty() && !this.categorie.equals("100")) {
         this.var_filtre = this.var_filtre + " Catégorie = " + this.categorie;
         this.var_requete = this.var_requete + " and retourEnteteAchats.brfCat='" + this.categorie + "'";
      }

      if (this.nomRepertoire.equalsIgnoreCase("ligne_retour") || this.nomRepertoire.equalsIgnoreCase("ligne_synthese")) {
         if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
            this.var_filtre = this.var_filtre + " du Produit = " + this.produitDebut;
            this.var_requete = this.var_requete + " and brfligCode>='" + this.produitDebut + "'";
         }

         if (this.produitFin != null && !this.produitFin.isEmpty()) {
            this.var_filtre = this.var_filtre + " au Produit = " + this.produitFin;
            this.var_requete = this.var_requete + " and brfligCode<='" + this.produitFin + "'";
         }

         if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
            this.var_filtre = this.var_filtre + " famille = " + this.famille;
            var5 = this.famille.split(":");
            this.var_requete = this.var_requete + " and brfligFamille like'" + var5[0] + "%'";
         }
      }

   }

   public void rechercheFactureSql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Liste des Factures du " + var1 + " au " + var2;
         this.var_requete = "fcf_date>='" + var3 + "' and fcf_date<='" + var4 + "'";
      } else {
         this.var_entete = "Liste des Factures du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "fcf_date>='" + var3 + "' and fcf_date<='" + var4 + "' and fcf_serie='" + this.serie + "'";
      }

      if (this.etat != null && !this.etat.isEmpty() && !this.etat.equals("100")) {
         int var5 = Integer.parseInt(this.etat);
         if (var5 == 0) {
            this.var_filtre = this.var_filtre + " Etat = En cours";
            this.var_requete = this.var_requete + " and fcf_etat=" + var5;
         } else if (var5 == 1) {
            this.var_filtre = this.var_filtre + " Etat = Validé";
            this.var_requete = this.var_requete + " and fcf_etat=" + var5;
         } else if (var5 == 2) {
            this.var_filtre = this.var_filtre + " Etat = Gelé";
            this.var_requete = this.var_requete + " and fcf_etat=" + var5;
         } else if (var5 == 3) {
            this.var_filtre = this.var_filtre + " Etat = Annulé";
            this.var_requete = this.var_requete + " and fcf_etat=" + var5;
         } else if (var5 == 4) {
            this.var_filtre = this.var_filtre + " Etat = Transformation patielle";
            this.var_requete = this.var_requete + " and fcf_etat=" + var5;
         } else if (var5 == 5) {
            this.var_filtre = this.var_filtre + " Etat = Transformation totale";
            this.var_requete = this.var_requete + " and fcf_etat=" + var5;
         } else if (var5 == 11) {
            this.var_filtre = this.var_filtre + " Etat = Relancé";
            this.var_requete = this.var_requete + " and fcf_date_relance!=null";
         } else if (var5 == 12) {
            this.var_filtre = this.var_filtre + " Etat = Promotion";
            this.var_requete = this.var_requete + " and fcf_tot_ht=0";
         } else if (var5 == 13) {
            this.var_filtre = this.var_filtre + " Etat = Non payé";
            this.var_requete = this.var_requete + " and fcf_solde=0";
         } else if (var5 == 14) {
            this.var_filtre = this.var_filtre + " Etat = Payé";
            this.var_requete = this.var_requete + " and fcf_solde=1";
         } else if (var5 == 15) {
            this.var_filtre = this.var_filtre + " Etat = Exonéré";
            this.var_requete = this.var_requete + " and fcf_exo_tva=1";
         }
      }

      if (this.document != null && !this.document.isEmpty()) {
         this.var_filtre = this.var_filtre + " N° Facture = " + this.document;
         this.var_requete = this.var_requete + " and ach_facture_entete.fcf_num='" + this.document + "'";
      }

      if (this.nomTiers != null && !this.nomTiers.isEmpty()) {
         this.var_filtre = this.var_filtre + " Société = " + this.nomTiers;
         this.var_requete = this.var_requete + " and ach_facture_entete.tie_id=" + this.tiers.getTieid();
      }

      if (this.nomDestinataire != null && !this.nomDestinataire.isEmpty()) {
         this.var_filtre = this.var_filtre + " Contact = " + this.nomDestinataire;
         this.var_requete = this.var_requete + " and fcf_nom_contact like '" + this.nomDestinataire + "%'";
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_filtre = this.var_filtre + " Activité = " + this.activite;
         this.var_requete = this.var_requete + " and fcf_activite='" + this.activite + "'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_filtre = this.var_filtre + " Dossier = " + this.dossier;
         this.var_requete = this.var_requete + " and fcf_anal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_filtre = this.var_filtre + " Parc = " + this.parc;
         this.var_requete = this.var_requete + " and fcf_anal2='" + this.parc + "'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_filtre = this.var_filtre + " Site = " + this.site;
         this.var_requete = this.var_requete + " and fcf_site='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_filtre = this.var_filtre + " Département = " + this.departement;
         this.var_requete = this.var_requete + " and fcf_departement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and fcf_service='" + this.service + "'";
      }

      String[] var7;
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_filtre = this.var_filtre + " Région = " + this.region;
         var7 = this.region.split(":");
         this.var_requete = this.var_requete + " and fcf_region='" + var7[0] + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_filtre = this.var_filtre + " Secteur = " + this.secteur;
         var7 = this.secteur.split(":");
         this.var_requete = this.var_requete + " and fcf_secteur='" + var7[0] + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_filtre = this.var_filtre + " PDV = " + this.pdv;
         var7 = this.pdv.split(":");
         this.var_requete = this.var_requete + " and fcf_pdv='" + var7[0] + "'";
      }

      if (this.categorie != null && !this.categorie.isEmpty() && !this.categorie.equals("100")) {
         this.var_filtre = this.var_filtre + " Catégorie = " + this.categorie;
         this.var_requete = this.var_requete + " and fcf_cat='" + this.categorie + "'";
      }

      String var6;
      UserDao var8;
      if (this.commercial != null && !this.commercial.isEmpty() && !this.commercial.equals("100")) {
         var8 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var8.selectByIdUsers(Long.parseLong(this.commercial), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Responsable = " + var6;
         this.var_requete = this.var_requete + " and fcf_id_responsable=" + this.commercial;
      }

      if (this.createur != null && !this.createur.isEmpty() && !this.createur.equals("100")) {
         var8 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var8.selectByIdUsers(Long.parseLong(this.createur), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Créateur = " + var6;
         this.var_requete = this.var_requete + " and fcf_id_createur=" + this.createur;
      }

      if (this.nomRepertoire.equalsIgnoreCase("ligne_facture")) {
         if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
            this.var_filtre = this.var_filtre + " du Produit = " + this.produitDebut;
            this.var_requete = this.var_requete + " and fcflig_code>='" + this.produitDebut + "'";
         }

         if (this.produitFin != null && !this.produitFin.isEmpty()) {
            this.var_filtre = this.var_filtre + " au Produit = " + this.produitFin;
            this.var_requete = this.var_requete + " and fcflig_code<='" + this.produitFin + "'";
         }

         if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
            this.var_filtre = this.var_filtre + " famille = " + this.famille;
            var7 = this.famille.split(":");
            this.var_requete = this.var_requete + " and fcflig_famille like'" + var7[0] + "%'";
         }
      }

   }

   public void rechercheFactureHql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Liste des Factures du " + var1 + " au " + var2;
         this.var_requete = "factureEnteteAchats.fcfDate>='" + var3 + "' and factureEnteteAchats.fcfDate<='" + var4 + "'";
      } else {
         this.var_entete = "Liste des Factures du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "factureEnteteAchats.fcfDate>='" + var3 + "' and factureEnteteAchats.fcfDate<='" + var4 + "' and factureEnteteAchats.fcfSerie='" + this.serie + "'";
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_filtre = this.var_filtre + " Activité = " + this.activite;
         this.var_requete = this.var_requete + " and factureEnteteAchats.fcfActivite='" + this.activite + "'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_filtre = this.var_filtre + " Dossier = " + this.dossier;
         this.var_requete = this.var_requete + " and factureEnteteAchats.fcfAnal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_filtre = this.var_filtre + " Parc = " + this.parc;
         this.var_requete = this.var_requete + " and factureEnteteAchats.fcfAnal2='" + this.parc + "'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_filtre = this.var_filtre + " Site = " + this.site;
         this.var_requete = this.var_requete + " and factureEnteteAchats.fcfSite='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_filtre = this.var_filtre + " Département = " + this.departement;
         this.var_requete = this.var_requete + " and factureEnteteAchats.fcfDepartement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and factureEnteteAchats.fcfService='" + this.service + "'";
      }

      String[] var5;
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_filtre = this.var_filtre + " Région = " + this.region;
         var5 = this.region.split(":");
         this.var_requete = this.var_requete + " and factureEnteteAchats.fcfRegion='" + var5[0] + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_filtre = this.var_filtre + " Secteur = " + this.secteur;
         var5 = this.secteur.split(":");
         this.var_requete = this.var_requete + " and factureEnteteAchats.fcfSecteur='" + var5[0] + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_filtre = this.var_filtre + " PDV = " + this.pdv;
         var5 = this.pdv.split(":");
         this.var_requete = this.var_requete + " and factureEnteteAchats.fcfPdv='" + var5[0] + "'";
      }

      if (this.categorie != null && !this.categorie.isEmpty() && !this.categorie.equals("100")) {
         this.var_filtre = this.var_filtre + " Catégorie = " + this.categorie;
         this.var_requete = this.var_requete + " and factureEnteteAchats.fcfCat='" + this.categorie + "'";
      }

      if (this.nomRepertoire.equalsIgnoreCase("ligne_facture") || this.nomRepertoire.equalsIgnoreCase("ligne_synthese")) {
         if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
            this.var_filtre = this.var_filtre + " du Produit = " + this.produitDebut;
            this.var_requete = this.var_requete + " and fcfligCode>='" + this.produitDebut + "'";
         }

         if (this.produitFin != null && !this.produitFin.isEmpty()) {
            this.var_filtre = this.var_filtre + " au Produit = " + this.produitFin;
            this.var_requete = this.var_requete + " and fcfligCode<='" + this.produitFin + "'";
         }

         if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
            this.var_filtre = this.var_filtre + " famille = " + this.famille;
            var5 = this.famille.split(":");
            this.var_requete = this.var_requete + " and fcfligFamille like'" + var5[0] + "%'";
         }
      }

   }

   public void rechercheAvoirSql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Liste des Avoirs du " + var1 + " au " + var2;
         this.var_requete = "avf_date>='" + var3 + "' and avf_date<='" + var4 + "'";
      } else {
         this.var_entete = "Liste des Avoirs du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "avf_date>='" + var3 + "' and avf_date<='" + var4 + "' and avf_serie='" + this.serie + "'";
      }

      if (this.etat != null && !this.etat.isEmpty() && !this.etat.equals("100")) {
         int var5 = Integer.parseInt(this.etat);
         if (var5 == 0) {
            this.var_filtre = this.var_filtre + " Etat = En cours";
            this.var_requete = this.var_requete + " and avf_etat=" + var5;
         } else if (var5 == 1) {
            this.var_filtre = this.var_filtre + " Etat = Validé";
            this.var_requete = this.var_requete + " and avf_etat=" + var5;
         } else if (var5 == 2) {
            this.var_filtre = this.var_filtre + " Etat = Gelé";
            this.var_requete = this.var_requete + " and avf_etat=" + var5;
         } else if (var5 == 3) {
            this.var_filtre = this.var_filtre + " Etat = Annulé";
            this.var_requete = this.var_requete + " and avf_etat=" + var5;
         } else if (var5 == 4) {
            this.var_filtre = this.var_filtre + " Etat = Transformation patielle";
            this.var_requete = this.var_requete + " and avf_etat=" + var5;
         } else if (var5 == 5) {
            this.var_filtre = this.var_filtre + " Etat = Transformation totale";
            this.var_requete = this.var_requete + " and avf_etat=" + var5;
         } else if (var5 == 11) {
            this.var_filtre = this.var_filtre + " Etat = Relancé";
            this.var_requete = this.var_requete + " and avf_date_relance!=null";
         } else if (var5 == 12) {
            this.var_filtre = this.var_filtre + " Etat = Promotion";
            this.var_requete = this.var_requete + " and avf_tot_ht=0";
         } else if (var5 == 13) {
            this.var_filtre = this.var_filtre + " Etat = Non payé";
            this.var_requete = this.var_requete + " and avf_solde=0";
         } else if (var5 == 14) {
            this.var_filtre = this.var_filtre + " Etat = Payé";
            this.var_requete = this.var_requete + " and avf_solde=1";
         } else if (var5 == 15) {
            this.var_filtre = this.var_filtre + " Etat = Exonéré";
            this.var_requete = this.var_requete + " and avf_exo_tva=1";
         }
      }

      if (this.document != null && !this.document.isEmpty()) {
         this.var_filtre = this.var_filtre + " N° Avoir = " + this.document;
         this.var_requete = this.var_requete + " and ach_avoir_entete.avf_num='" + this.document + "'";
      }

      if (this.nomTiers != null && !this.nomTiers.isEmpty()) {
         this.var_filtre = this.var_filtre + " Société = " + this.nomTiers;
         this.var_requete = this.var_requete + " and ach_avoir_entete.tie_id=" + this.tiers.getTieid();
      }

      if (this.nomDestinataire != null && !this.nomDestinataire.isEmpty()) {
         this.var_filtre = this.var_filtre + " Contact = " + this.nomDestinataire;
         this.var_requete = this.var_requete + " and avf_nom_contact like '" + this.nomDestinataire + "%'";
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_filtre = this.var_filtre + " Activité = " + this.activite;
         this.var_requete = this.var_requete + " and avf_activite='" + this.activite + "'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_filtre = this.var_filtre + " Dossier = " + this.dossier;
         this.var_requete = this.var_requete + " and avf_anal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_filtre = this.var_filtre + " Parc = " + this.parc;
         this.var_requete = this.var_requete + " and avf_anal2='" + this.parc + "'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_filtre = this.var_filtre + " Site = " + this.site;
         this.var_requete = this.var_requete + " and avf_site='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_filtre = this.var_filtre + " Département = " + this.departement;
         this.var_requete = this.var_requete + " and avf_departement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and avf_service='" + this.service + "'";
      }

      String[] var7;
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_filtre = this.var_filtre + " Région = " + this.region;
         var7 = this.region.split(":");
         this.var_requete = this.var_requete + " and avf_region='" + var7[0] + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_filtre = this.var_filtre + " Secteur = " + this.secteur;
         var7 = this.secteur.split(":");
         this.var_requete = this.var_requete + " and avf_secteur='" + var7[0] + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_filtre = this.var_filtre + " PDV = " + this.pdv;
         var7 = this.pdv.split(":");
         this.var_requete = this.var_requete + " and avf_pdv='" + var7[0] + "'";
      }

      if (this.categorie != null && !this.categorie.isEmpty() && !this.categorie.equals("100")) {
         this.var_filtre = this.var_filtre + " Catégorie = " + this.categorie;
         this.var_requete = this.var_requete + " and avf_cat='" + this.categorie + "'";
      }

      String var6;
      UserDao var8;
      if (this.commercial != null && !this.commercial.isEmpty() && !this.commercial.equals("100")) {
         var8 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var8.selectByIdUsers(Long.parseLong(this.commercial), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Responsable = " + var6;
         this.var_requete = this.var_requete + " and avf_id_responsable=" + this.commercial;
      }

      if (this.createur != null && !this.createur.isEmpty() && !this.createur.equals("100")) {
         var8 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var8.selectByIdUsers(Long.parseLong(this.createur), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Créateur = " + var6;
         this.var_requete = this.var_requete + " and avf_id_createur=" + this.createur;
      }

      if (this.nomRepertoire.equalsIgnoreCase("ligne_avoir")) {
         if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
            this.var_filtre = this.var_filtre + " du Produit = " + this.produitDebut;
            this.var_requete = this.var_requete + " and avflig_code>='" + this.produitDebut + "'";
         }

         if (this.produitFin != null && !this.produitFin.isEmpty()) {
            this.var_filtre = this.var_filtre + " au Produit = " + this.produitFin;
            this.var_requete = this.var_requete + " and avflig_code<='" + this.produitFin + "'";
         }

         if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
            this.var_filtre = this.var_filtre + " famille = " + this.famille;
            var7 = this.famille.split(":");
            this.var_requete = this.var_requete + " and avflig_famille like'" + var7[0] + "%'";
         }
      }

   }

   public void rechercheAvoirHql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Liste des Avoirs du " + var1 + " au " + var2;
         this.var_requete = "avoirEnteteAchats.avfDate>='" + var3 + "' and avoirEnteteAchats.avfDate<='" + var4 + "'";
      } else {
         this.var_entete = "Liste des Avoirs du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "avoirEnteteAchats.avfDate>='" + var3 + "' and avoirEnteteAchats.avfDate<='" + var4 + "' and avoirEnteteAchats.avfSerie='" + this.serie + "'";
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_filtre = this.var_filtre + " Activité = " + this.activite;
         this.var_requete = this.var_requete + " and avoirEnteteAchats.avfActivite='" + this.activite + "'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_filtre = this.var_filtre + " Dossier = " + this.dossier;
         this.var_requete = this.var_requete + " and avoirEnteteAchats.avfAnal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_filtre = this.var_filtre + " Parc = " + this.parc;
         this.var_requete = this.var_requete + " and avoirEnteteAchats.avfAnal2='" + this.parc + "'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_filtre = this.var_filtre + " Site = " + this.site;
         this.var_requete = this.var_requete + " and avoirEnteteAchats.avfSite='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_filtre = this.var_filtre + " Département = " + this.departement;
         this.var_requete = this.var_requete + " and avoirEnteteAchats.avfDepartement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and avoirEnteteAchats.avfService='" + this.service + "'";
      }

      String[] var5;
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_filtre = this.var_filtre + " Région = " + this.region;
         var5 = this.region.split(":");
         this.var_requete = this.var_requete + " and avoirEnteteAchats.avfRegion='" + var5[0] + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_filtre = this.var_filtre + " Secteur = " + this.secteur;
         var5 = this.secteur.split(":");
         this.var_requete = this.var_requete + " and avoirEnteteAchats.avfSecteur='" + var5[0] + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_filtre = this.var_filtre + " PDV = " + this.pdv;
         var5 = this.pdv.split(":");
         this.var_requete = this.var_requete + " and avoirEnteteAchats.avfPdv='" + var5[0] + "'";
      }

      if (this.categorie != null && !this.categorie.isEmpty() && !this.categorie.equals("100")) {
         this.var_filtre = this.var_filtre + " Catégorie = " + this.categorie;
         this.var_requete = this.var_requete + " and avoirEnteteAchats.avfCat='" + this.categorie + "'";
      }

      if (this.nomRepertoire.equalsIgnoreCase("ligne_avoir") || this.nomRepertoire.equalsIgnoreCase("ligne_synthese")) {
         if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
            this.var_filtre = this.var_filtre + " du Produit = " + this.produitDebut;
            this.var_requete = this.var_requete + " and avfligCode>='" + this.produitDebut + "'";
         }

         if (this.produitFin != null && !this.produitFin.isEmpty()) {
            this.var_filtre = this.var_filtre + " au Produit = " + this.produitFin;
            this.var_requete = this.var_requete + " and avfligCode<='" + this.produitFin + "'";
         }

         if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
            this.var_filtre = this.var_filtre + " famille = " + this.famille;
            var5 = this.famille.split(":");
            this.var_requete = this.var_requete + " and avfligFamille like'" + var5[0] + "%'";
         }
      }

   }

   public void rechercheFraisSql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Liste des Frais du " + var1 + " au " + var2;
         this.var_requete = "fsf_date>='" + var3 + "' and fsf_date<='" + var4 + "'";
      } else {
         this.var_entete = "Liste des Frais du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "fsf_date>='" + var3 + "' and fsf_date<='" + var4 + "' and fsf_serie='" + this.serie + "'";
      }

      if (this.etat != null && !this.etat.isEmpty() && !this.etat.equals("100")) {
         int var5 = Integer.parseInt(this.etat);
         if (var5 == 0) {
            this.var_filtre = this.var_filtre + " Etat = En cours";
            this.var_requete = this.var_requete + " and fsf_etat=" + var5;
         } else if (var5 == 1) {
            this.var_filtre = this.var_filtre + " Etat = Validé";
            this.var_requete = this.var_requete + " and fsf_etat=" + var5;
         } else if (var5 == 2) {
            this.var_filtre = this.var_filtre + " Etat = Gelé";
            this.var_requete = this.var_requete + " and afsf_etat=" + var5;
         } else if (var5 == 3) {
            this.var_filtre = this.var_filtre + " Etat = Annulé";
            this.var_requete = this.var_requete + " and fsf_etat=" + var5;
         } else if (var5 == 4) {
            this.var_filtre = this.var_filtre + " Etat = Transformation patielle";
            this.var_requete = this.var_requete + " and fsf_etat=" + var5;
         } else if (var5 == 5) {
            this.var_filtre = this.var_filtre + " Etat = Transformation totale";
            this.var_requete = this.var_requete + " and fsf_etat=" + var5;
         } else if (var5 == 13) {
            this.var_filtre = this.var_filtre + " Etat = Non payé";
            this.var_requete = this.var_requete + " and fsf_solde=0";
         } else if (var5 == 14) {
            this.var_filtre = this.var_filtre + " Etat = Payé";
            this.var_requete = this.var_requete + " and fsf_solde=1";
         } else if (var5 == 15) {
            this.var_filtre = this.var_filtre + " Etat = Exonéré";
            this.var_requete = this.var_requete + " and fsf_exo_tva=1";
         }
      }

      if (this.document != null && !this.document.isEmpty()) {
         this.var_filtre = this.var_filtre + " N° Frais = " + this.document;
         this.var_requete = this.var_requete + " and ach_frais_entete.fsf_num='" + this.document + "'";
      }

      if (this.nomTiers != null && !this.nomTiers.isEmpty()) {
         this.var_filtre = this.var_filtre + " Société = " + this.nomTiers;
         this.var_requete = this.var_requete + " and ach_frais_entete.tie_id=" + this.tiers.getTieid();
      }

      if (this.nomDestinataire != null && !this.nomDestinataire.isEmpty()) {
         this.var_filtre = this.var_filtre + " Contact = " + this.nomDestinataire;
         this.var_requete = this.var_requete + " and fsf_nom_contact like '" + this.nomDestinataire + "%'";
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_filtre = this.var_filtre + " Activité = " + this.activite;
         this.var_requete = this.var_requete + " and fsf_activite='" + this.activite + "'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_filtre = this.var_filtre + " Dossier = " + this.dossier;
         this.var_requete = this.var_requete + " and fsf_anal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_filtre = this.var_filtre + " Parc = " + this.parc;
         this.var_requete = this.var_requete + " and fsf_anal2='" + this.parc + "'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_filtre = this.var_filtre + " Site = " + this.site;
         this.var_requete = this.var_requete + " and fsf_site='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_filtre = this.var_filtre + " Département = " + this.departement;
         this.var_requete = this.var_requete + " and fsf_departement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and fsf_service='" + this.service + "'";
      }

      String[] var7;
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_filtre = this.var_filtre + " Région = " + this.region;
         var7 = this.region.split(":");
         this.var_requete = this.var_requete + " and fsf_region='" + var7[0] + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_filtre = this.var_filtre + " Secteur = " + this.secteur;
         var7 = this.secteur.split(":");
         this.var_requete = this.var_requete + " and fsf_secteur='" + var7[0] + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_filtre = this.var_filtre + " PDV = " + this.pdv;
         var7 = this.pdv.split(":");
         this.var_requete = this.var_requete + " and fsf_pdv='" + var7[0] + "'";
      }

      if (this.categorie != null && !this.categorie.isEmpty() && !this.categorie.equals("100")) {
         this.var_filtre = this.var_filtre + " Catégorie = " + this.categorie;
         this.var_requete = this.var_requete + " and fsf_cat='" + this.categorie + "'";
      }

      String var6;
      UserDao var8;
      if (this.commercial != null && !this.commercial.isEmpty() && !this.commercial.equals("100")) {
         var8 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var8.selectByIdUsers(Long.parseLong(this.commercial), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Responsable = " + var6;
         this.var_requete = this.var_requete + " and fsf_id_responsable=" + this.commercial;
      }

      if (this.createur != null && !this.createur.isEmpty() && !this.createur.equals("100")) {
         var8 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var8.selectByIdUsers(Long.parseLong(this.createur), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Créateur = " + var6;
         this.var_requete = this.var_requete + " and fsf_id_createur=" + this.createur;
      }

      if (this.nomRepertoire.equalsIgnoreCase("ligne_frais")) {
         if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
            this.var_filtre = this.var_filtre + " du Produit = " + this.produitDebut;
            this.var_requete = this.var_requete + " and fsflig_code>='" + this.produitDebut + "'";
         }

         if (this.produitFin != null && !this.produitFin.isEmpty()) {
            this.var_filtre = this.var_filtre + " au Produit = " + this.produitFin;
            this.var_requete = this.var_requete + " and fsflig_code<='" + this.produitFin + "'";
         }

         if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
            this.var_filtre = this.var_filtre + " famille = " + this.famille;
            var7 = this.famille.split(":");
            this.var_requete = this.var_requete + " and fsflig_famille like'" + var7[0] + "%'";
         }
      }

   }

   public void rechercheFraisHql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Liste des Frais du " + var1 + " au " + var2;
         this.var_requete = "fraisEnteteAchats.fsfDate>='" + var3 + "' and fraisEnteteAchats.fsfDate<='" + var4 + "'";
      } else {
         this.var_entete = "Liste des Frais du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "fraisEnteteAchats.fsfDate>='" + var3 + "' and fraisEnteteAchats.fsfDate<='" + var4 + "' and fraisEnteteAchats.fsfSerie='" + this.serie + "'";
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_filtre = this.var_filtre + " Activité = " + this.activite;
         this.var_requete = this.var_requete + " and fraisEnteteAchats.fsfActivite='" + this.activite + "'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_filtre = this.var_filtre + " Dossier = " + this.dossier;
         this.var_requete = this.var_requete + " and fraisEnteteAchats.fsfAnal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_filtre = this.var_filtre + " Parc = " + this.parc;
         this.var_requete = this.var_requete + " and fraisEnteteAchats.fsfAnal2='" + this.parc + "'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_filtre = this.var_filtre + " Site = " + this.site;
         this.var_requete = this.var_requete + " and fraisEnteteAchats.fsfSite='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_filtre = this.var_filtre + " Département = " + this.departement;
         this.var_requete = this.var_requete + " and fraisEnteteAchats.fsfDepartement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and fraisEnteteAchats.fsfService='" + this.service + "'";
      }

      String[] var5;
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_filtre = this.var_filtre + " Région = " + this.region;
         var5 = this.region.split(":");
         this.var_requete = this.var_requete + " and fraisEnteteAchats.fsfRegion='" + var5[0] + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_filtre = this.var_filtre + " Secteur = " + this.secteur;
         var5 = this.secteur.split(":");
         this.var_requete = this.var_requete + " and fraisEnteteAchats.fsfSecteur='" + var5[0] + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_filtre = this.var_filtre + " PDV = " + this.pdv;
         var5 = this.pdv.split(":");
         this.var_requete = this.var_requete + " and fraisEnteteAchats.fsfPdv='" + var5[0] + "'";
      }

      if (this.categorie != null && !this.categorie.isEmpty() && !this.categorie.equals("100")) {
         this.var_filtre = this.var_filtre + " Catégorie = " + this.categorie;
         this.var_requete = this.var_requete + " and fraisEnteteAchats.fsfCat='" + this.categorie + "'";
      }

      if (this.nomRepertoire.equalsIgnoreCase("ligne_frais")) {
         if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
            this.var_filtre = this.var_filtre + " du Produit = " + this.produitDebut;
            this.var_requete = this.var_requete + " and fsfligCode>='" + this.produitDebut + "'";
         }

         if (this.produitFin != null && !this.produitFin.isEmpty()) {
            this.var_filtre = this.var_filtre + " au Produit = " + this.produitFin;
            this.var_requete = this.var_requete + " and fsfligCode<='" + this.produitFin + "'";
         }

         if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
            this.var_filtre = this.var_filtre + " famille = " + this.famille;
            var5 = this.famille.split(":");
            this.var_requete = this.var_requete + " and fsfligFamille like'" + var5[0] + "%'";
         }
      }

   }

   public void rechercheProduitSql() throws HibernateException, NamingException {
      this.var_entete = "Controle des produits ACHATS";
      this.var_requete = "";
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsAchs");
      new ArrayList();
      new ExercicesAchats();
      ExercicesAchatsDao var4 = new ExercicesAchatsDao(this.baseLog, this.utilInitHibernate);
      ExercicesAchats var3 = var4.recupererLastExo(var1);
      if (var3 != null) {
         new FamillesProduitsAchats();
         FamillesProduitsAchatsDao var6 = new FamillesProduitsAchatsDao(this.baseLog, this.utilInitHibernate);
         ProduitsAchsDao var7 = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
         List var2 = var7.chargerLesProduitsAchats(var1);
         if (var2.size() != 0) {
            for(int var8 = 0; var8 < var2.size(); ++var8) {
               this.produits = (Produits)var2.get(var8);
               if (this.produits.getProCode() == null || this.produits.getProCode().isEmpty()) {
                  this.produits.setCommentaire("Absence du code produit");
                  this.listProduits.add(this.produits);
               }

               if (this.produits.getProAchNat() != null && !this.produits.getProAchNat().isEmpty()) {
                  if (this.produits.getProAchNat().equals("0000")) {
                     this.produits.setCommentaire("Nature achat erronée");
                     this.listProduits.add(this.produits);
                  }
               } else {
                  this.produits.setCommentaire("Absence de la nature achat");
                  this.listProduits.add(this.produits);
               }

               if (this.produits.getProAchCode() == null && this.produits.getProAchCode().isEmpty()) {
                  this.produits.setCommentaire("Absence de la famille achat");
                  this.listProduits.add(this.produits);
               } else {
                  FamillesProduitsAchats var5 = var6.rechercheFamilleByProd(var3.getExeachId(), this.produits, var1);
                  if (var5 == null) {
                     this.produits.setCommentaire("Famille achat introuvable");
                     this.listProduits.add(this.produits);
                  }
               }
            }
         }
      }

      this.utilInitHibernate.closeSession();
   }

   public ExercicesAchats getExoSelectionne() {
      return this.exoSelectionne;
   }

   public void setExoSelectionne(ExercicesAchats var1) {
      this.exoSelectionne = var1;
   }

   public UtilPrint getUtilPrint() {
      return this.utilPrint;
   }

   public void setUtilPrint(UtilPrint var1) {
      this.utilPrint = var1;
   }

   public boolean isTestafficheLigne() {
      return this.testafficheLigne;
   }

   public void setTestafficheLigne(boolean var1) {
      this.testafficheLigne = var1;
   }

   public DataModel getDataModelImpgenFichier() {
      return this.dataModelImpgenFichier;
   }

   public void setDataModelImpgenFichier(DataModel var1) {
      this.dataModelImpgenFichier = var1;
   }

   public DataModel getDataModelImpgen() {
      return this.dataModelImpgen;
   }

   public void setDataModelImpgen(DataModel var1) {
      this.dataModelImpgen = var1;
   }

   public OptionAchats getOptionAchats() {
      return this.optionAchats;
   }

   public void setOptionAchats(OptionAchats var1) {
      this.optionAchats = var1;
   }

   public List getMesDepartementsItems() {
      return this.mesDepartementsItems;
   }

   public void setMesDepartementsItems(List var1) {
      this.mesDepartementsItems = var1;
   }

   public List getMesEtatsItems() {
      return this.mesEtatsItems;
   }

   public void setMesEtatsItems(List var1) {
      this.mesEtatsItems = var1;
   }

   public List getMesPdvItems() {
      return this.mesPdvItems;
   }

   public void setMesPdvItems(List var1) {
      this.mesPdvItems = var1;
   }

   public List getMesSecteursItems() {
      return this.mesSecteursItems;
   }

   public void setMesSecteursItems(List var1) {
      this.mesSecteursItems = var1;
   }

   public List getMesSeriesItems() {
      return this.mesSeriesItems;
   }

   public void setMesSeriesItems(List var1) {
      this.mesSeriesItems = var1;
   }

   public List getMesServicesItems() {
      return this.mesServicesItems;
   }

   public void setMesServicesItems(List var1) {
      this.mesServicesItems = var1;
   }

   public boolean isVar_affiche_impression() {
      return this.var_affiche_impression;
   }

   public void setVar_affiche_impression(boolean var1) {
      this.var_affiche_impression = var1;
   }

   public boolean isAffMail() {
      return this.affMail;
   }

   public void setAffMail(boolean var1) {
      this.affMail = var1;
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

   public DataModel getDatamodelProduits() {
      return this.datamodelProduits;
   }

   public void setDatamodelProduits(DataModel var1) {
      this.datamodelProduits = var1;
   }

   public boolean isShowModalPanelProduits() {
      return this.showModalPanelProduits;
   }

   public void setShowModalPanelProduits(boolean var1) {
      this.showModalPanelProduits = var1;
   }

   public boolean isVar_anal_activite() {
      return this.var_anal_activite;
   }

   public void setVar_anal_activite(boolean var1) {
      this.var_anal_activite = var1;
   }

   public boolean isVar_anal_departement() {
      return this.var_anal_departement;
   }

   public void setVar_anal_departement(boolean var1) {
      this.var_anal_departement = var1;
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

   public boolean isVar_anal_pdv() {
      return this.var_anal_pdv;
   }

   public void setVar_anal_pdv(boolean var1) {
      this.var_anal_pdv = var1;
   }

   public boolean isVar_anal_region() {
      return this.var_anal_region;
   }

   public void setVar_anal_region(boolean var1) {
      this.var_anal_region = var1;
   }

   public boolean isVar_anal_secteur() {
      return this.var_anal_secteur;
   }

   public void setVar_anal_secteur(boolean var1) {
      this.var_anal_secteur = var1;
   }

   public boolean isVar_anal_service() {
      return this.var_anal_service;
   }

   public void setVar_anal_service(boolean var1) {
      this.var_anal_service = var1;
   }

   public boolean isVar_anal_site() {
      return this.var_anal_site;
   }

   public void setVar_anal_site(boolean var1) {
      this.var_anal_site = var1;
   }

   public String getImpDestinataire() {
      return this.impDestinataire;
   }

   public void setImpDestinataire(String var1) {
      this.impDestinataire = var1;
   }

   public String getImpEmetteur() {
      return this.impEmetteur;
   }

   public void setImpEmetteur(String var1) {
      this.impEmetteur = var1;
   }

   public boolean isShowModalPanelPrint() {
      return this.showModalPanelPrint;
   }

   public void setShowModalPanelPrint(boolean var1) {
      this.showModalPanelPrint = var1;
   }

   public String getActivite() {
      return this.activite;
   }

   public void setActivite(String var1) {
      this.activite = var1;
   }

   public String getCategorie() {
      return this.categorie;
   }

   public void setCategorie(String var1) {
      this.categorie = var1;
   }

   public String getCommercial() {
      return this.commercial;
   }

   public void setCommercial(String var1) {
      this.commercial = var1;
   }

   public String getCreateur() {
      return this.createur;
   }

   public void setCreateur(String var1) {
      this.createur = var1;
   }

   public String getDepartement() {
      return this.departement;
   }

   public void setDepartement(String var1) {
      this.departement = var1;
   }

   public String getDepot() {
      return this.depot;
   }

   public void setDepot(String var1) {
      this.depot = var1;
   }

   public String getDossier() {
      return this.dossier;
   }

   public void setDossier(String var1) {
      this.dossier = var1;
   }

   public String getEtat() {
      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public String getFamille() {
      return this.famille;
   }

   public void setFamille(String var1) {
      this.famille = var1;
   }

   public Date getFiltreDateDebut() {
      return this.filtreDateDebut;
   }

   public void setFiltreDateDebut(Date var1) {
      this.filtreDateDebut = var1;
   }

   public Date getFiltreDateFin() {
      return this.filtreDateFin;
   }

   public void setFiltreDateFin(Date var1) {
      this.filtreDateFin = var1;
   }

   public String getFormat() {
      return this.format;
   }

   public void setFormat(String var1) {
      this.format = var1;
   }

   public String getNomDestinataire() {
      return this.nomDestinataire;
   }

   public void setNomDestinataire(String var1) {
      this.nomDestinataire = var1;
   }

   public String getNomEtat() {
      return this.nomEtat;
   }

   public void setNomEtat(String var1) {
      this.nomEtat = var1;
   }

   public String getNomRepertoire() {
      return this.nomRepertoire;
   }

   public void setNomRepertoire(String var1) {
      this.nomRepertoire = var1;
   }

   public String getNomTiers() {
      return this.nomTiers;
   }

   public void setNomTiers(String var1) {
      this.nomTiers = var1;
   }

   public String getParc() {
      return this.parc;
   }

   public void setParc(String var1) {
      this.parc = var1;
   }

   public String getPdv() {
      return this.pdv;
   }

   public void setPdv(String var1) {
      this.pdv = var1;
   }

   public String getProduitDebut() {
      return this.produitDebut;
   }

   public void setProduitDebut(String var1) {
      this.produitDebut = var1;
   }

   public String getProduitFin() {
      return this.produitFin;
   }

   public void setProduitFin(String var1) {
      this.produitFin = var1;
   }

   public String getRegion() {
      return this.region;
   }

   public void setRegion(String var1) {
      this.region = var1;
   }

   public String getSecteur() {
      return this.secteur;
   }

   public void setSecteur(String var1) {
      this.secteur = var1;
   }

   public String getSerie() {
      return this.serie;
   }

   public void setSerie(String var1) {
      this.serie = var1;
   }

   public String getService() {
      return this.service;
   }

   public void setService(String var1) {
      this.service = var1;
   }

   public String getSite() {
      return this.site;
   }

   public void setSite(String var1) {
      this.site = var1;
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

   public DataModel getDatamodelParc() {
      return this.datamodelParc;
   }

   public void setDatamodelParc(DataModel var1) {
      this.datamodelParc = var1;
   }

   public boolean isShowModalPanelParc() {
      return this.showModalPanelParc;
   }

   public void setShowModalPanelParc(boolean var1) {
      this.showModalPanelParc = var1;
   }

   public String getDocument() {
      return this.document;
   }

   public void setDocument(String var1) {
      this.document = var1;
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

   public String getVar_entete() {
      return this.var_entete;
   }

   public void setVar_entete(String var1) {
      this.var_entete = var1;
   }

   public String getVar_filtre() {
      return this.var_filtre;
   }

   public void setVar_filtre(String var1) {
      this.var_filtre = var1;
   }

   public Tiers getTiers() {
      return this.tiers;
   }

   public void setTiers(Tiers var1) {
      this.tiers = var1;
   }

   public List getMesPeriodesItems() {
      return this.mesPeriodesItems;
   }

   public void setMesPeriodesItems(List var1) {
      this.mesPeriodesItems = var1;
   }

   public String getPeriode() {
      return this.periode;
   }

   public void setPeriode(String var1) {
      this.periode = var1;
   }

   public List getLesModelesAutorises() {
      return this.lesModelesAutorises;
   }

   public void setLesModelesAutorises(List var1) {
      this.lesModelesAutorises = var1;
   }
}
