package com.epegase.forms.stock;

import com.epegase.systeme.classe.BonEntreeLigne;
import com.epegase.systeme.classe.BonSortieLigne;
import com.epegase.systeme.classe.CessionLigne;
import com.epegase.systeme.classe.Departement;
import com.epegase.systeme.classe.DepotAchats;
import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.FamillesProduitsAchats;
import com.epegase.systeme.classe.FamillesProduitsVentes;
import com.epegase.systeme.classe.InventaireLigne;
import com.epegase.systeme.classe.LivraisonLigneVentes;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.classe.PointDeVente;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsDepot;
import com.epegase.systeme.classe.ProduitsTarif;
import com.epegase.systeme.classe.ReceptionLigneAchats;
import com.epegase.systeme.classe.Region;
import com.epegase.systeme.classe.RetourLigneAchats;
import com.epegase.systeme.classe.RetourLigneVentes;
import com.epegase.systeme.classe.Secteur;
import com.epegase.systeme.classe.Service;
import com.epegase.systeme.classe.Site;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.EtatDocument;
import com.epegase.systeme.control.Stock;
import com.epegase.systeme.dao.AvoirLigneVentesDao;
import com.epegase.systeme.dao.BonEntreeLigneDao;
import com.epegase.systeme.dao.BonSortieLigneDao;
import com.epegase.systeme.dao.CessionLigneDao;
import com.epegase.systeme.dao.CommandeLigneAchatsDao;
import com.epegase.systeme.dao.DepartementDao;
import com.epegase.systeme.dao.DepotAchatsDao;
import com.epegase.systeme.dao.FactureLigneVentesDao;
import com.epegase.systeme.dao.FamillesProduitsAchatsDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.InventaireLigneDao;
import com.epegase.systeme.dao.LivraisonLigneVentesDao;
import com.epegase.systeme.dao.ParcDao;
import com.epegase.systeme.dao.PointDeVenteDao;
import com.epegase.systeme.dao.ProduitsAchsDao;
import com.epegase.systeme.dao.ProduitsDepotDao;
import com.epegase.systeme.dao.ProduitsTarifDao;
import com.epegase.systeme.dao.ProduitsVtesDao;
import com.epegase.systeme.dao.ReceptionLigneAchatsDao;
import com.epegase.systeme.dao.RegionDao;
import com.epegase.systeme.dao.RetourLigneAchatsDao;
import com.epegase.systeme.dao.RetourLigneVentesDao;
import com.epegase.systeme.dao.SecteurDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.SiteDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.util.CalculStock;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.LectureFamillesClients;
import com.epegase.systeme.xml.OptionAchats;
import com.epegase.systeme.xml.OptionStocks;
import com.epegase.systeme.xml.OptionVentes;
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

public class FormImpressionStock implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private ExercicesAchats exoSelectionne;
   private OptionAchats optionAchats;
   private OptionStocks optionStocks;
   private OptionVentes optionVentes;
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
   private List lesProduits;
   private Date date_ante;
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
   private String dossier;
   private String serie;
   private String etatRec;
   private String categorie;
   private String commercial;
   private String createur;
   private String famille;
   private String depot;
   private String var_entete;
   private String var_filtre;
   private String var_requete;
   private boolean var_inv;
   private boolean var_bout;
   private boolean var_bin;
   private boolean var_ces;
   private boolean var_prod;
   private boolean var_rec;
   private boolean var_sav;
   private boolean var_bc;
   private boolean var_bl;
   private boolean var_fac;
   private boolean var_br;
   private boolean testafficheDocument = false;
   private List mesSeriesItems = new ArrayList();
   private List mesEtatsItems = new ArrayList();
   private List mesSecteursItems = new ArrayList();
   private List mesPdvItems = new ArrayList();
   private List mesDepartementsItems = new ArrayList();
   private List mesServicesItems = new ArrayList();
   private int stocknull = 1;
   private int stockQteVal = 0;
   private int stockAnterieur = 0;
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
   private boolean decoupageActivite = false;
   private List laColonne1Items;
   private List laColonne2Items;
   private List laColonne3Items;
   private String var_colonne1;
   private String var_colonne2;
   private String var_colonne3;
   private int var_currentValue;
   private boolean var_showBarProg = false;
   private String depot_encours;
   private String produit_encours;
   private UtilPrint utilPrint;
   private boolean affMail = false;
   private String format = "PDF";
   private boolean var_affiche_impression = false;
   private String impDestinataire;
   private String impDestinataireCC;
   private String impDestinataireCCI;
   private String impEmetteur;
   private boolean var_ctrl_imp = false;
   private boolean showModalPanelTiers;
   private transient DataModel datamodelTiers = new ListDataModel();
   private Tiers tiers;
   private PlansAnalytiques plansAnalytiques;
   private boolean showModalPanelProduits;
   private transient DataModel datamodelProduits = new ListDataModel();
   private Produits produits;
   private boolean var_produit_choix = false;
   private ProduitsDepot produitsDepot = new ProduitsDepot();
   private ProduitsAchsDao produitsAchsDao;
   private boolean showModalPanelParc;
   private transient DataModel datamodelParc = new ListDataModel();
   private Parc parcObj;
   private int etat;
   private String num;
   private long idEquipe;
   private String nomDivers;
   private Date date;
   private String devise;
   private long idDoc;
   private int typeChg;
   private String nomDepot;
   private String code;
   private String nomFamille;
   private String libelle;
   private float qteLig;
   private float qteUtilLig;
   private double puLig;
   private double ptLig;
   private double prLig;
   private double pumpLig;
   private float coefDevise;
   private float coefPr;
   private double prKgrLig;
   private float poidsBrut;
   private List lesModelesAutorises;

   public FormImpressionStock() {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.utilDate = new UtilDate();
   }

   public void InstancesDaoUtilses() {
      this.produitsAchsDao = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerLesRepImpStocks(Session var1) {
      this.lesRepImpression.clear();
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "stock";
      File var3 = new File(var2);
      if (!var3.exists()) {
         var3.mkdir();
      }

      String[] var4 = var3.list();
      if (var4 != null) {
         var4 = this.triAlphabetique(var4, var4.length);

         for(int var5 = 0; var5 < var4.length; ++var5) {
            if (!var4[var5].equalsIgnoreCase(".svn") && !var4[var5].equalsIgnoreCase("index.html")) {
               String var6 = "";
               var6 = var4[var5].toUpperCase();
               this.lesRepImpression.add(var6);
            }
         }
      }

      this.dataModelImpgen.setWrappedData(this.lesRepImpression);
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
      this.var_anal_dossier = 0;
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

      this.var_anal_dossier = this.structureLog.getStrDossier();
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
         if (this.nomRepertoire.contains("catalogue")) {
            this.nature = 37;
         } else if (this.nomRepertoire.contains("consommation")) {
            this.nature = 38;
         } else if (this.nomRepertoire.contains("etat_stock")) {
            this.nature = 39;
         } else if (this.nomRepertoire.contains("reapprovisionnement")) {
            this.nature = 40;
         } else {
            this.nature = 0;
         }

         if (this.nomRepertoire.contains("consommation")) {
            this.testafficheDocument = true;
         } else {
            this.testafficheDocument = false;
         }

         this.lesFichImpression.clear();
         String var1 = null;
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "stock" + File.separator + this.nomRepertoire;
         this.testafficheLigne = false;
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
                     if (this.optionVentes.getProduitGenerique().equals("1")) {
                        this.lesFichImpression.add(var6);
                     } else if (!var6.contains("Generique")) {
                        this.lesFichImpression.add(var6);
                     }
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
         List var8 = this.usersChronoDao.selectListByUserComm(this.usersLog, (Session)null);
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
         this.calculeTiers();
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

   public void rechercheProduitsDebut() throws HibernateException, NamingException, JDOMException, IOException {
      this.lesProduits = new ArrayList();
      if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
         this.var_produit_choix = false;
         this.lesProduits = this.produitsAchsDao.chargerTousProduitsAchatsVentes(this.produitDebut, (Session)null);
         if (this.lesProduits.size() == 1) {
            this.produits = (Produits)this.lesProduits.get(0);
            this.calculeProduits();
         } else if (this.lesProduits.size() >= 2) {
            this.showModalPanelProduits = true;
            this.datamodelProduits.setWrappedData(this.lesProduits);
         }
      }

   }

   public void rechercheProduitsFin() throws HibernateException, NamingException, JDOMException, IOException {
      this.lesProduits = new ArrayList();
      if (this.produitFin != null && !this.produitFin.isEmpty()) {
         this.var_produit_choix = true;
         this.lesProduits = this.produitsAchsDao.chargerTousProduitsAchatsVentes(this.produitFin, (Session)null);
         if (this.lesProduits.size() == 1) {
            this.produits = (Produits)this.lesProduits.get(0);
            this.calculeProduits();
         } else if (this.lesProduits.size() >= 2) {
            this.showModalPanelProduits = true;
            this.datamodelProduits.setWrappedData(this.lesProduits);
         }
      }

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
            this.produitFin = this.produits.getProCode();
         } else {
            this.produitFin = this.produits.getProCode();
         }
      } else {
         this.produits = null;
         if (!this.var_produit_choix) {
            this.produitDebut = "";
            this.produitFin = "";
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
      this.parc = "";
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
      if (this.structureLog.getStrCode1() != null && !this.structureLog.getStrCode1().isEmpty()) {
         this.decoupageActivite = true;
      } else {
         this.decoupageActivite = false;
      }

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
         this.lesProduits = new ArrayList();
         this.calculeRequete();
         this.utilPrint.setRapport(this.nomEtat);
         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "stock" + File.separator + this.nomRepertoire + File.separator);
         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "sous_rapport" + File.separator);
         if (this.var_entete != null && !this.var_entete.isEmpty()) {
            this.utilPrint.setEntete(this.var_entete.replace("_", " "));
         } else {
            this.utilPrint.setEntete("");
         }

         if (this.stocknull == 0) {
            this.var_filtre = this.var_filtre + " (Sans les Qte à 0)";
         }

         if (this.stockQteVal == 1) {
            this.var_filtre = this.var_filtre + " (Avec les documents En Cours + Validés)";
         }

         this.utilPrint.setFiltre(this.var_filtre);
         this.utilPrint.setFormat(this.format);
         this.utilPrint.setDateDeb(this.date_ante);
         this.utilPrint.setDateFin(this.filtreDateFin);
         this.utilPrint.setEmetteur(this.impEmetteur);
         this.utilPrint.setDestinataire(this.impDestinataire);
         this.utilPrint.setDestinataireCC(this.impDestinataireCC);
         this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
         this.utilPrint.setTiersSelectionne((Tiers)null);
         this.utilPrint.setNbCar(this.stocknull);
         this.utilPrint.setEtat_init(Integer.parseInt(this.optionAchats.getNbDecQte()));
         JRBeanCollectionDataSource var1 = null;
         ArrayList var2;
         if (this.nomEtat.equals("Export_tarif")) {
            this.utilPrint.setRequete(this.var_requete);
            var2 = new ArrayList();
            var1 = new JRBeanCollectionDataSource(var2);
         } else if (!this.nomRepertoire.equalsIgnoreCase("cessions") && !this.nomRepertoire.equalsIgnoreCase("bons_entree") && !this.nomRepertoire.equalsIgnoreCase("bons_sortie") && !this.nomRepertoire.equalsIgnoreCase("inventaires")) {
            this.utilPrint.setRequete("");
            if (this.nomRepertoire.equalsIgnoreCase("catalogue")) {
               var1 = new JRBeanCollectionDataSource(this.lesProduits);
            } else {
               var1 = new JRBeanCollectionDataSource(this.listDocument);
            }
         } else {
            this.utilPrint.setRequete(this.var_requete);
            var2 = new ArrayList();
            var1 = new JRBeanCollectionDataSource(var2);
         }

         this.utilPrint.setjRBeanCollectionDataSource(var1);
         this.utilPrint.setBaseLog(this.baseLog);
         this.utilPrint.setStructureLog(this.structureLog);
         this.utilPrint.setUsersLog(this.usersLog);
         this.utilPrint.setDateDeb(this.filtreDateDebut);
         this.utilPrint.setDateFin(this.filtreDateFin);
         this.utilPrint.imprimeRapport();
         this.var_ctrl_imp = false;
      }

   }

   public void calculeRequete() throws HibernateException, NamingException, ParseException, JDOMException, IOException {
      this.var_entete = "";
      this.var_filtre = "";
      this.var_requete = "";
      String var1 = this.utilDate.dateToStringFr(this.filtreDateDebut);
      String var2 = var1.substring(6, 10) + "-" + var1.substring(3, 5) + "-" + var1.substring(0, 2) + " 00:00:00";
      String var3 = var1.substring(6, 10) + "-" + var1.substring(3, 5) + "-" + var1.substring(0, 2) + " 23:59:59";
      String var4 = this.utilDate.dateToStringFr(this.filtreDateFin);
      String var5 = var4.substring(6, 10) + "-" + var4.substring(3, 5) + "-" + var4.substring(0, 2) + " 23:59:59";
      String var6 = this.utilDate.dateToStringFr(this.filtreDateDebut);
      String var7 = this.utilDate.dateToStringFr(this.filtreDateFin);
      this.var_filtre = "";
      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_filtre = this.var_filtre + " Activité = " + this.activite;
      }

      if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib1() + " = " + this.var_colonne1;
      }

      if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib2() + " = " + this.var_colonne2;
      }

      if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib3() + " = " + this.var_colonne3;
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_filtre = this.var_filtre + " Dossier = " + this.dossier;
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_filtre = this.var_filtre + " Parc = " + this.parc;
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_filtre = this.var_filtre + " Site = " + this.site;
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_filtre = this.var_filtre + " Département = " + this.departement;
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
      }

      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_filtre = this.var_filtre + " Région = " + this.region;
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_filtre = this.var_filtre + " Secteur = " + this.secteur;
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_filtre = this.var_filtre + " PDV = " + this.pdv;
      }

      if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
         this.var_filtre = this.var_filtre + " du Produit = " + this.produitDebut;
      }

      if (this.produitFin != null && !this.produitFin.isEmpty()) {
         this.var_filtre = this.var_filtre + " au Produit = " + this.produitFin;
      }

      if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
         this.var_filtre = this.var_filtre + " famille = " + this.famille;
      }

      if (this.depot != null && !this.depot.isEmpty() && this.depot.contains(":")) {
         this.var_filtre = this.var_filtre + " depot = " + this.depot;
      } else {
         this.var_filtre = this.var_filtre + " TOUS DEPOTS";
      }

      String[] var8;
      if (this.nomRepertoire.equalsIgnoreCase("catalogue")) {
         if (!this.nomEtat.equals("Export_tarif")) {
            this.var_requete = "produits.pro_id <> 0";
            if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
               this.var_requete = this.var_requete + " and produits.pro_activite='" + this.activite + "'";
            }

            if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
               this.var_requete = this.var_requete + " and produits.pro_code>='" + this.produitDebut + "'";
            }

            if (this.produitFin != null && !this.produitFin.isEmpty()) {
               this.var_requete = this.var_requete + " and produits.pro_code<='" + this.produitFin + "'";
            }

            if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
               var8 = this.famille.split(":");
               this.var_requete = this.var_requete + " and (produits.pro_ach_code='" + var8[0] + "' or produits.pro_vte_code='" + var8[0] + "')";
            }
         } else {
            this.var_requete = "pro_id <> 0";
            if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
               this.var_requete = this.var_requete + " and pro_activite='" + this.activite + "'";
            }

            if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
               this.var_requete = this.var_requete + " and pro_code>='" + this.produitDebut + "'";
            }

            if (this.produitFin != null && !this.produitFin.isEmpty()) {
               this.var_requete = this.var_requete + " and pro_code<='" + this.produitFin + "'";
            }

            if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
               var8 = this.famille.split(":");
               this.var_requete = this.var_requete + " and (pro_ach_code='" + var8[0] + "' or pro_vte_code='" + var8[0] + "')";
            }

            this.calculCatalogue();
         }
      } else if (this.nomRepertoire.equalsIgnoreCase("consommation")) {
         if (this.serie != null && !this.serie.isEmpty()) {
            this.var_entete = "Consommation du " + var6 + " au " + var7 + " Série : " + this.serie;
         } else {
            this.var_entete = "Consommation du " + var6 + " au " + var7;
         }

         if (this.activite == null || this.activite.isEmpty() || !this.activite.contains(":")) {
            this.activite = "";
         }

         if (this.dossier == null || this.dossier.isEmpty() || !this.dossier.contains(":")) {
            this.dossier = "";
         }

         if (this.parc == null || this.parc.isEmpty()) {
            this.parc = "";
         }

         if (this.site == null || this.site.isEmpty() || !this.site.contains(":")) {
            this.site = "";
         }

         if (this.departement == null || this.departement.isEmpty() || !this.departement.contains(":")) {
            this.departement = "";
         }

         if (this.service == null || this.service.isEmpty() || !this.service.contains(":")) {
            this.service = "";
         }

         if (this.region == null || this.region.isEmpty() || !this.region.contains(":")) {
            this.region = "";
         }

         if (this.secteur == null || this.secteur.isEmpty() || !this.secteur.contains(":")) {
            this.secteur = "";
         }

         if (this.pdv == null || this.pdv.isEmpty() || !this.pdv.contains(":")) {
            this.pdv = "";
         }

         if (this.produitDebut == null || this.produitDebut.isEmpty()) {
            this.produitDebut = "";
         }

         if (this.produitFin == null || this.produitFin.isEmpty()) {
            this.produitFin = "";
         }

         if (this.famille == null || this.famille.isEmpty() || !this.famille.contains(":")) {
            this.famille = "";
         }

         if (this.depot == null || this.depot.isEmpty() || !this.depot.contains(":")) {
            this.depot = "";
         }

         this.calculConsommation(var6, var7, var2, var5);
      } else if (this.nomRepertoire.equalsIgnoreCase("etat_stock")) {
         if (this.serie != null && !this.serie.isEmpty()) {
            this.var_entete = "Etat des stocks du " + var6 + " au " + var7 + " Série : " + this.serie;
         } else {
            this.var_entete = "Etat des stocks du " + var6 + " au " + var7;
         }

         if (this.activite == null || this.activite.isEmpty() || !this.activite.contains(":")) {
            this.activite = "";
         }

         if (this.service == null || this.service.isEmpty() || !this.service.contains(":")) {
            this.service = "";
         }

         if (this.produitDebut == null || this.produitDebut.isEmpty()) {
            this.produitDebut = "";
         }

         if (this.produitFin == null || this.produitFin.isEmpty()) {
            this.produitFin = "";
         }

         if (this.famille == null || this.famille.isEmpty() || !this.famille.contains(":")) {
            this.famille = "";
         }

         if (this.depot == null || this.depot.isEmpty() || !this.depot.contains(":")) {
            this.depot = "";
         }

         if (!this.nomEtat.equalsIgnoreCase("SyntheseGenerique") && !this.nomEtat.equalsIgnoreCase("SyntheseGeneriqueDetaille")) {
            if (!this.nomEtat.equalsIgnoreCase("SyntheseFamille") && !this.nomEtat.equalsIgnoreCase("SyntheseFamilleDetaille")) {
               if (!this.nomEtat.equalsIgnoreCase("SyntheseProduit") && !this.nomEtat.equalsIgnoreCase("SyntheseProduitDetaille")) {
                  this.calculEtatStock(var6, var7, var3, var2, var5);
               } else {
                  this.rechercheSyntheseProduit(var6, var7, var3, var2, var5);
               }
            } else {
               this.rechercheSyntheseFamille(var6, var7, var3, var2, var5);
            }
         } else {
            this.rechercheSyntheseGenerique(var6, var7, var3, var2, var5);
         }
      } else if (this.nomRepertoire.equalsIgnoreCase("reapprovisionnement")) {
         if (this.serie != null && !this.serie.isEmpty()) {
            this.var_entete = "Réapprovisionnement du " + var6 + " au " + var7 + " Série : " + this.serie;
         } else {
            this.var_entete = "Réapprovisionnement du " + var6 + " au " + var7;
         }

         if (this.activite == null || this.activite.isEmpty() || !this.activite.contains(":")) {
            this.activite = "";
         }

         if (this.service == null || this.service.isEmpty() || !this.service.contains(":")) {
            this.service = "";
         }

         if (this.produitDebut == null || this.produitDebut.isEmpty()) {
            this.produitDebut = "";
         }

         if (this.produitFin == null || this.produitFin.isEmpty()) {
            this.produitFin = "";
         }

         if (this.famille == null || this.famille.isEmpty() || !this.famille.contains(":")) {
            this.famille = "";
         }

         if (this.depot == null || this.depot.isEmpty() || !this.depot.contains(":")) {
            this.depot = "";
         }

         if (this.nomEtat.contains("Preparation")) {
            this.var_requete = "pro_id <> 0";
            if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
               this.var_requete = this.var_requete + " and pro_activite='" + this.activite + "'";
            }

            if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
               this.var_requete = this.var_requete + " and pro_code>='" + this.produitDebut + "'";
            }

            if (this.produitFin != null && !this.produitFin.isEmpty()) {
               this.var_requete = this.var_requete + " and pro_code<='" + this.produitFin + "'";
            }

            if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
               var8 = this.famille.split(":");
               this.var_requete = this.var_requete + " and (pro_ach_code like'" + var8[0] + "%' or pro_vte_code like '" + var8[0] + "%')";
            }

            this.calculPreparation();
         } else {
            this.calculReappro(var6, var7, var3, var2, var5);
         }
      } else if (this.nomRepertoire.equalsIgnoreCase("cessions")) {
         this.rechercheCessionSql(var6, var7, var2, var5);
      } else if (this.nomRepertoire.equalsIgnoreCase("bons_entree")) {
         this.rechercheBEntreeSql(var6, var7, var2, var5);
      } else if (this.nomRepertoire.equalsIgnoreCase("bons_sortie")) {
         this.rechercheBSortieSql(var6, var7, var2, var5);
      } else if (this.nomRepertoire.equalsIgnoreCase("inventaires")) {
         this.rechercheInventaireSql(var6, var7, var2, var5);
      }

   }

   public void rechercheProduitDepotHql() {
      this.var_requete = "depot.dpoInactif=0 ";
      if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
         this.var_requete = this.var_requete + " and produits.proCode>='" + this.produitDebut + "'";
      }

      if (this.produitFin != null && !this.produitFin.isEmpty()) {
         this.var_requete = this.var_requete + " and produits.proCode<='" + this.produitFin + "'";
      }

      String[] var1;
      if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
         var1 = this.famille.split(":");
         this.var_requete = this.var_requete + " and (produits.proAchCode like'" + var1[0] + "%' or produits.proVteCode like'" + var1[0] + "%')";
      }

      if (this.depot != null && !this.depot.isEmpty() && this.depot.contains(":")) {
         var1 = this.depot.split(":");
         this.var_requete = this.var_requete + " and depot.dpoCode ='" + var1[0] + "'";
      }

   }

   public void rechercheInventaireHql(String var1, String var2, String var3, String var4) {
      if (this.serie != null && !this.serie.isEmpty()) {
         this.var_requete = "inventaireEntete.invDate>='" + var3 + "' and inventaireEntete.invDate<='" + var4 + "' and inventaireEntete.invSerie='" + this.serie + "'";
      } else {
         this.var_requete = "inventaireEntete.invDate>='" + var3 + "' and inventaireEntete.invDate<='" + var4 + "'";
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_requete = this.var_requete + " and inventaireEntete.invActivite='" + this.activite + "'";
      }

      if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
         this.var_requete = this.var_requete + " and inventaireEntete.invActivite like '%" + this.var_colonne1 + "%'";
      }

      if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
         this.var_requete = this.var_requete + " and inventaireEntete.invActivite like '%" + this.var_colonne2 + "%'";
      }

      if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
         this.var_requete = this.var_requete + " and inventaireEntete.invActivite like '%" + this.var_colonne3 + "%'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_requete = this.var_requete + " and inventaireEntete.invAnal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_requete = this.var_requete + " and inventaireEntete.invAnal2='" + this.parc + "'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_requete = this.var_requete + " and inventaireEntete.invSite='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_requete = this.var_requete + " and inventaireEntete.invDepartement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_requete = this.var_requete + " and inventaireEntete.invService='" + this.service + "'";
      }

      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_requete = this.var_requete + " and inventaireEntete.invRegion='" + this.region + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_requete = this.var_requete + " and inventaireEntete.invSecteur='" + this.secteur + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_requete = this.var_requete + " and inventaireEntete.invPdv='" + this.pdv + "'";
      }

      if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
         this.var_requete = this.var_requete + " and invligCode>='" + this.produitDebut + "'";
      }

      if (this.produitFin != null && !this.produitFin.isEmpty()) {
         this.var_requete = this.var_requete + " and invligCode<='" + this.produitFin + "'";
      }

      String[] var5;
      if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
         var5 = this.famille.split(":");
         this.var_requete = this.var_requete + " and invligFamille like'" + var5[0] + "%'";
      }

      if (this.depot != null && !this.depot.isEmpty() && this.depot.contains(":")) {
         var5 = this.depot.split(":");
         this.var_requete = this.var_requete + " and invligDepot like'" + var5[0] + "%'";
      } else {
         this.var_requete = this.var_requete + " and (invligDepot is not null or invligDepot<>'')";
      }

   }

   public void rechercheBEntreeHql(String var1, String var2, String var3, String var4) {
      if (this.serie != null && !this.serie.isEmpty()) {
         this.var_requete = "bonEntreeEntete.binDate>='" + var3 + "' and bonEntreeEntete.binDate<='" + var4 + "' and bonEntreeEntete.binSerie='" + this.serie + "'";
      } else {
         this.var_requete = "bonEntreeEntete.binDate>='" + var3 + "' and bonEntreeEntete.binDate<='" + var4 + "'";
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_requete = this.var_requete + " and bonEntreeEntete.binActivite='" + this.activite + "'";
      }

      if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
         this.var_requete = this.var_requete + " and bonEntreeEntete.binActivite like '%" + this.var_colonne1 + "%'";
      }

      if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
         this.var_requete = this.var_requete + " and bonEntreeEntete.binActivite like '%" + this.var_colonne2 + "%'";
      }

      if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
         this.var_requete = this.var_requete + " and bonEntreeEntete.binActivite like '%" + this.var_colonne3 + "%'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_requete = this.var_requete + " and bonEntreeEntete.binAnal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_requete = this.var_requete + " and bonEntreeEntete.binAnal2='" + this.parc + "'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_requete = this.var_requete + " and bonEntreeEntete.binSite='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_requete = this.var_requete + " and bonEntreeEntete.binDepartement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_requete = this.var_requete + " and bonEntreeEntete.binService='" + this.service + "'";
      }

      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_requete = this.var_requete + " and bonEntreeEntete.binRegion='" + this.region + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_requete = this.var_requete + " and bonEntreeEntete.binSecteur='" + this.secteur + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_requete = this.var_requete + " and bonEntreeEntete.binPdv='" + this.pdv + "'";
      }

      if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
         this.var_requete = this.var_requete + " and binligCode>='" + this.produitDebut + "'";
      }

      if (this.produitFin != null && !this.produitFin.isEmpty()) {
         this.var_requete = this.var_requete + " and binligCode<='" + this.produitFin + "'";
      }

      String[] var5;
      if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
         var5 = this.famille.split(":");
         this.var_requete = this.var_requete + " and binligFamille like'" + var5[0] + "%'";
      }

      if (this.depot != null && !this.depot.isEmpty() && this.depot.contains(":")) {
         var5 = this.depot.split(":");
         this.var_requete = this.var_requete + " and binligDepot like'" + var5[0] + "%'";
      } else {
         this.var_requete = this.var_requete + " and (binligDepot is not null or binligDepot<>'')";
      }

   }

   public void rechercheBSortieHql(String var1, String var2, String var3, String var4) {
      if (this.serie != null && !this.serie.isEmpty()) {
         this.var_requete = "bonSortieEntete.bouDate>='" + var3 + "' and bonSortieEntete.bouDate<='" + var4 + "' and bonSortieEntete.bouSerie='" + this.serie + "'";
      } else {
         this.var_requete = "bonSortieEntete.bouDate>='" + var3 + "' and bonSortieEntete.bouDate<='" + var4 + "'";
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_requete = this.var_requete + " and bonSortieEntete.bouActivite='" + this.activite + "'";
      }

      if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
         this.var_requete = this.var_requete + " and bonSortieEntete.bouActivite like '%" + this.var_colonne1 + "%'";
      }

      if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
         this.var_requete = this.var_requete + " and bonSortieEntete.bouActivite like '%" + this.var_colonne2 + "%'";
      }

      if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
         this.var_requete = this.var_requete + " and bonSortieEntete.bouActivite like '%" + this.var_colonne3 + "%'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_requete = this.var_requete + " and bonSortieEntete.bouAnal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_requete = this.var_requete + " and bonSortieEntete.bouAnal2='" + this.parc + "'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_requete = this.var_requete + " and bonSortieEntete.bouSite='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_requete = this.var_requete + " and bonSortieEntete.bouDepartement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_requete = this.var_requete + " and bonSortieEntete.bouService='" + this.service + "'";
      }

      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_requete = this.var_requete + " and bonSortieEntete.bouRegion='" + this.region + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_requete = this.var_requete + " and bonSortieEntete.bouSecteur='" + this.secteur + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_requete = this.var_requete + " and bonSortieEntete.bouPdv='" + this.pdv + "'";
      }

      if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
         this.var_requete = this.var_requete + " and bouligCode>='" + this.produitDebut + "'";
      }

      if (this.produitFin != null && !this.produitFin.isEmpty()) {
         this.var_requete = this.var_requete + " and bouligCode<='" + this.produitFin + "'";
      }

      String[] var5;
      if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
         var5 = this.famille.split(":");
         this.var_requete = this.var_requete + " and bouligFamille like'" + var5[0] + "%'";
      }

      if (this.depot != null && !this.depot.isEmpty() && this.depot.contains(":")) {
         var5 = this.depot.split(":");
         this.var_requete = this.var_requete + " and bouligDepot like'" + var5[0] + "%'";
      } else {
         this.var_requete = this.var_requete + " and (bouligDepot is not null or bouligDepot<>'')";
      }

   }

   public void rechercheCessionHql(String var1, String var2, String var3, String var4) {
      if (this.serie != null && !this.serie.isEmpty()) {
         this.var_requete = "cessionEntete.cesDate>='" + var3 + "' and cessionEntete.cesDate<='" + var4 + "' and cessionEntete.cesSerie='" + this.serie + "'";
      } else {
         this.var_requete = "cessionEntete.cesDate>='" + var3 + "' and cessionEntete.cesDate<='" + var4 + "'";
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_requete = this.var_requete + " and cessionEntete.cesActivite='" + this.activite + "'";
      }

      if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
         this.var_requete = this.var_requete + " and cessionEntete.cesActivite like '%" + this.var_colonne1 + "%'";
      }

      if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
         this.var_requete = this.var_requete + " and cessionEntete.cesActivite like '%" + this.var_colonne2 + "%'";
      }

      if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
         this.var_requete = this.var_requete + " and cessionEntete.cesActivite like '%" + this.var_colonne3 + "%'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_requete = this.var_requete + " and cessionEntete.cesAnal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_requete = this.var_requete + " and cessionEntete.cesAnal2='" + this.parc + "'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_requete = this.var_requete + " and cessionEntete.cesSite='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_requete = this.var_requete + " and cessionEntete.cesDepartement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_requete = this.var_requete + " and cessionEntete.cesService='" + this.service + "'";
      }

      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_requete = this.var_requete + " and cessionEntete.cesRegion='" + this.region + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_requete = this.var_requete + " and cessionEntete.cesSecteur='" + this.secteur + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_requete = this.var_requete + " and cessionEntete.cesPdv='" + this.pdv + "'";
      }

      if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
         this.var_requete = this.var_requete + " and cesligCode>='" + this.produitDebut + "'";
      }

      if (this.produitFin != null && !this.produitFin.isEmpty()) {
         this.var_requete = this.var_requete + " and cesligCode<='" + this.produitFin + "'";
      }

      String[] var5;
      if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
         var5 = this.famille.split(":");
         this.var_requete = this.var_requete + " and cesligFamille like'" + var5[0] + "%'";
      }

      if (this.depot != null && !this.depot.isEmpty() && this.depot.contains(":")) {
         var5 = this.depot.split(":");
         this.var_requete = this.var_requete + " and cesligDepotOrigine like'" + var5[0] + "%' or cesligDepotDestination like'" + var5[0] + "%'";
      } else {
         this.var_requete = this.var_requete + " and (cesligDepotOrigine is not null or cesligDepotOrigine<>'') and (cesligDepotDestination is not null or cesligDepotDestination<>'')";
      }

   }

   public void rechercheInventaireSql(String var1, String var2, String var3, String var4) {
      if (this.serie != null && !this.serie.isEmpty()) {
         this.var_requete = "ach_inventaire_entete.inv_date>='" + var3 + "' and ach_inventaire_entete.inv_date<='" + var4 + "' and ach_inventaire_entete.inv_serie='" + this.serie + "'";
      } else {
         this.var_requete = "ach_inventaire_entete.inv_date>='" + var3 + "' and ach_inventaire_entete.inv_date<='" + var4 + "'";
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_requete = this.var_requete + " and ach_inventaire_entete.inv_activite='" + this.activite + "'";
      }

      if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
         this.var_requete = this.var_requete + " and ach_inventaire_entete.inv_activite like '%" + this.var_colonne1 + "%'";
      }

      if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
         this.var_requete = this.var_requete + " and ach_inventaire_entete.inv_activite like '%" + this.var_colonne2 + "%'";
      }

      if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
         this.var_requete = this.var_requete + " and ach_inventaire_entete.inv_activite like '%" + this.var_colonne3 + "%'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_requete = this.var_requete + " and ach_inventaire_entete.inv_anal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_requete = this.var_requete + " and ach_inventaire_entete.inv_anal2='" + this.parc + "'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_requete = this.var_requete + " and ach_inventaire_entete.inv_site='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_requete = this.var_requete + " and ach_inventaire_entete.inv_departement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_requete = this.var_requete + " and ach_inventaire_entete.inv_service='" + this.service + "'";
      }

      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_requete = this.var_requete + " and ach_inventaire_entete.inv_region='" + this.region + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_requete = this.var_requete + " and ach_inventaire_entete.inv_secteur='" + this.secteur + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_requete = this.var_requete + " and ach_inventaire_entete.inv_pdv='" + this.pdv + "'";
      }

      if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
         this.var_requete = this.var_requete + " and invlig_code>='" + this.produitDebut + "'";
      }

      if (this.produitFin != null && !this.produitFin.isEmpty()) {
         this.var_requete = this.var_requete + " and invlig_code<='" + this.produitFin + "'";
      }

      String[] var5;
      if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
         var5 = this.famille.split(":");
         this.var_requete = this.var_requete + " and invlig_famille like'" + var5[0] + "%'";
      }

      if (this.depot != null && !this.depot.isEmpty() && this.depot.contains(":")) {
         var5 = this.depot.split(":");
         this.var_requete = this.var_requete + " and invlig_depot like'" + var5[0] + "%'";
      } else {
         this.var_requete = this.var_requete + " and (invlig_depot is not null or invlig_depot<>'')";
      }

   }

   public void rechercheBEntreeSql(String var1, String var2, String var3, String var4) {
      if (this.serie != null && !this.serie.isEmpty()) {
         this.var_requete = "ach_bon_entree_entete.bin_date>='" + var3 + "' and ach_bon_entree_entete.bin_date<='" + var4 + "' and ach_bon_entree_entete.bin_serie='" + this.serie + "'";
      } else {
         this.var_requete = "ach_bon_entree_entete.bin_date>='" + var3 + "' and ach_bon_entree_entete.bin_date<='" + var4 + "'";
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_requete = this.var_requete + " and ach_bon_entree_entete.bin_activite='" + this.activite + "'";
      }

      if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
         this.var_requete = this.var_requete + " and ach_bon_entree_entete.bin_activite like '%" + this.var_colonne1 + "%'";
      }

      if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
         this.var_requete = this.var_requete + " and ach_bon_entree_entete.bin_activite like '%" + this.var_colonne2 + "%'";
      }

      if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
         this.var_requete = this.var_requete + " and ach_bon_entree_entete.bin_activite like '%" + this.var_colonne3 + "%'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_requete = this.var_requete + " and ach_bon_entree_entete.bin_anal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_requete = this.var_requete + " and ach_bon_entree_entete.bin_anal2='" + this.parc + "'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_requete = this.var_requete + " and ach_bon_entree_entete.bin_site='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_requete = this.var_requete + " and ach_bon_entree_entete.bin_departement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_requete = this.var_requete + " and ach_bon_entree_entete.bin_service='" + this.service + "'";
      }

      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_requete = this.var_requete + " and ach_bon_entree_entete.bin_region='" + this.region + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_requete = this.var_requete + " and ach_bon_entree_entete.bin_secteur='" + this.secteur + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_requete = this.var_requete + " and ach_bon_entree_entete.bin_pdv='" + this.pdv + "'";
      }

      if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
         this.var_requete = this.var_requete + " and binlig_code>='" + this.produitDebut + "'";
      }

      if (this.produitFin != null && !this.produitFin.isEmpty()) {
         this.var_requete = this.var_requete + " and binlig_code<='" + this.produitFin + "'";
      }

      String[] var5;
      if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
         var5 = this.famille.split(":");
         this.var_requete = this.var_requete + " and binlig_famille like'" + var5[0] + "%'";
      }

      if (this.depot != null && !this.depot.isEmpty() && this.depot.contains(":")) {
         var5 = this.depot.split(":");
         this.var_requete = this.var_requete + " and binlig_depot like'" + var5[0] + "%'";
      } else {
         this.var_requete = this.var_requete + " and (binlig_depot is not null or binlig_depot<>'')";
      }

   }

   public void rechercheBSortieSql(String var1, String var2, String var3, String var4) {
      if (this.serie != null && !this.serie.isEmpty()) {
         this.var_requete = "ach_bon_sortie_entete.bou_date>='" + var3 + "' and ach_bon_sortie_entete.bou_date<='" + var4 + "' and ach_bon_sortie_entete.bou_serie='" + this.serie + "'";
      } else {
         this.var_requete = "ach_bon_sortie_entete.bou_date>='" + var3 + "' and ach_bon_sortie_entete.bou_date<='" + var4 + "'";
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_requete = this.var_requete + " and ach_bon_sortie_entete.bou_activite='" + this.activite + "'";
      }

      if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
         this.var_requete = this.var_requete + " and ach_bon_sortie_entete.bou_activite like '%" + this.var_colonne1 + "%'";
      }

      if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
         this.var_requete = this.var_requete + " and ach_bon_sortie_entete.bou_activite like '%" + this.var_colonne2 + "%'";
      }

      if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
         this.var_requete = this.var_requete + " and ach_bon_sortie_entete.bou_activite like '%" + this.var_colonne3 + "%'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_requete = this.var_requete + " and ach_bon_sortie_entete.bou_anal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_requete = this.var_requete + " and ach_bon_sortie_entete.bou_anal2='" + this.parc + "'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_requete = this.var_requete + " and ach_bon_sortie_entete.bou_site='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_requete = this.var_requete + " and ach_bon_sortie_entete.bou_departement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_requete = this.var_requete + " and ach_bon_sortie_entete.bou_service='" + this.service + "'";
      }

      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_requete = this.var_requete + " and ach_bon_sortie_entete.bou_region='" + this.region + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_requete = this.var_requete + " and ach_bon_sortie_entete.bou_secteur='" + this.secteur + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_requete = this.var_requete + " and ach_bon_sortie_entete.bou_pdv='" + this.pdv + "'";
      }

      if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
         this.var_requete = this.var_requete + " and boulig_code>='" + this.produitDebut + "'";
      }

      if (this.produitFin != null && !this.produitFin.isEmpty()) {
         this.var_requete = this.var_requete + " and boulig_code<='" + this.produitFin + "'";
      }

      String[] var5;
      if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
         var5 = this.famille.split(":");
         this.var_requete = this.var_requete + " and boulig_famille like'" + var5[0] + "%'";
      }

      if (this.depot != null && !this.depot.isEmpty() && this.depot.contains(":")) {
         var5 = this.depot.split(":");
         this.var_requete = this.var_requete + " and boulig_depot like'" + var5[0] + "%'";
      } else {
         this.var_requete = this.var_requete + " and (boulig_depot is not null or boulig_depot<>'')";
      }

   }

   public void rechercheCessionSql(String var1, String var2, String var3, String var4) {
      if (this.serie != null && !this.serie.isEmpty()) {
         this.var_requete = "ach_cession_entete.ces_date>='" + var3 + "' and ach_cession_entete.ces_date<='" + var4 + "' and ach_cession_entete.ces_serie='" + this.serie + "'";
      } else {
         this.var_requete = "ach_cession_entete.ces_date>='" + var3 + "' and ach_cession_entete.ces_date<='" + var4 + "'";
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_requete = this.var_requete + " and ach_cession_entete.ces_activite='" + this.activite + "'";
      }

      if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
         this.var_requete = this.var_requete + " and ach_cession_entete.ces_activite like '%" + this.var_colonne1 + "%'";
      }

      if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
         this.var_requete = this.var_requete + " and ach_cession_entete.ces_activite like '%" + this.var_colonne2 + "%'";
      }

      if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
         this.var_requete = this.var_requete + " and ach_cession_entete.ces_activite like '%" + this.var_colonne3 + "%'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_requete = this.var_requete + " and ach_cession_entete.ces_anal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_requete = this.var_requete + " and ach_cession_entete.ces_anal2='" + this.parc + "'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_requete = this.var_requete + " and ach_cession_entete.ces_site='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_requete = this.var_requete + " and ach_cession_entete.ces_departement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_requete = this.var_requete + " and ach_cession_entete.ces_service='" + this.service + "'";
      }

      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_requete = this.var_requete + " and ach_cession_entete.ces_region='" + this.region + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_requete = this.var_requete + " and cessionEntete.ces_secteur='" + this.secteur + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_requete = this.var_requete + " and ach_cession_entete.ces_pdv='" + this.pdv + "'";
      }

      if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
         this.var_requete = this.var_requete + " and ceslig_code>='" + this.produitDebut + "'";
      }

      if (this.produitFin != null && !this.produitFin.isEmpty()) {
         this.var_requete = this.var_requete + " and ceslig_code<='" + this.produitFin + "'";
      }

      String[] var5;
      if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
         var5 = this.famille.split(":");
         this.var_requete = this.var_requete + " and ceslig_famille like'" + var5[0] + "%'";
      }

      if (this.depot != null && !this.depot.isEmpty() && this.depot.contains(":")) {
         var5 = this.depot.split(":");
         this.var_requete = this.var_requete + " and ceslig_depot_origine like'" + var5[0] + "%' or ceslig_depot_destination like'" + var5[0] + "%'";
      } else {
         this.var_requete = this.var_requete + " and (ceslig_depot_origine is not null or ceslig_depot_origine<>'') and (ceslig_depot_destination is not null or ceslig_depot_destination<>'')";
      }

   }

   public void rechercheReceptionHql(String var1, String var2, String var3, String var4) {
      if (this.serie != null && !this.serie.isEmpty()) {
         this.var_requete = "receptionEnteteAchats.recDate>='" + var3 + "' and receptionEnteteAchats.recDate<='" + var4 + "' and receptionEnteteAchats.recSerie='" + this.serie + "'";
      } else {
         this.var_requete = "receptionEnteteAchats.recDate>='" + var3 + "' and receptionEnteteAchats.recDate<='" + var4 + "'";
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_requete = this.var_requete + " and receptionEnteteAchats.recActivite='" + this.activite + "'";
      }

      if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
         this.var_requete = this.var_requete + " and receptionEnteteAchats.recActivite like '%" + this.var_colonne1 + "%'";
      }

      if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
         this.var_requete = this.var_requete + " and receptionEnteteAchats.recActivite like '%" + this.var_colonne2 + "%'";
      }

      if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
         this.var_requete = this.var_requete + " and receptionEnteteAchats.recActivite like '%" + this.var_colonne3 + "%'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_requete = this.var_requete + " and receptionEnteteAchats.recAnal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_requete = this.var_requete + " and receptionEnteteAchats.recAnal2='" + this.parc + "'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_requete = this.var_requete + " and receptionEnteteAchats.recSite='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_requete = this.var_requete + " and receptionEnteteAchats.recDepartement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_requete = this.var_requete + " and receptionEnteteAchats.recService='" + this.service + "'";
      }

      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_requete = this.var_requete + " and receptionEnteteAchats.recRegion='" + this.region + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_requete = this.var_requete + " and receptionEnteteAchats.recSecteur='" + this.secteur + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_requete = this.var_requete + " and receptionEnteteAchats.recPdv='" + this.pdv + "'";
      }

      if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
         this.var_requete = this.var_requete + " and recligCode>='" + this.produitDebut + "'";
      }

      if (this.produitFin != null && !this.produitFin.isEmpty()) {
         this.var_requete = this.var_requete + " and recligCode<='" + this.produitFin + "'";
      }

      String[] var5;
      if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
         var5 = this.famille.split(":");
         this.var_requete = this.var_requete + " and recligFamille like'" + var5[0] + "%'";
      }

      if (this.depot != null && !this.depot.isEmpty() && this.depot.contains(":")) {
         var5 = this.depot.split(":");
         this.var_requete = this.var_requete + " and recligDepot like'" + var5[0] + "%'";
      } else {
         this.var_requete = this.var_requete + " and (recligDepot is not null or recligDepot<>'')";
      }

   }

   public void rechercheSavHql(String var1, String var2, String var3, String var4) {
      if (this.var_br) {
         if (this.serie != null && !this.serie.isEmpty()) {
            this.var_requete = "retourEnteteAchats.brfDate>='" + var3 + "' and retourEnteteAchats.brfDate<='" + var4 + "' and retourEnteteAchats.brfSerie='" + this.serie + "'";
         } else {
            this.var_requete = "retourEnteteAchats.brfDate>='" + var3 + "' and retourEnteteAchats.brfDate<='" + var4 + "'";
         }

         if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
            this.var_requete = this.var_requete + " and retourEnteteAchats.brfActivite='" + this.activite + "'";
         }

         if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
            this.var_requete = this.var_requete + " and retourEnteteAchats.brfActivite like '%" + this.var_colonne1 + "%'";
         }

         if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
            this.var_requete = this.var_requete + " and retourEnteteAchats.brfActivite like '%" + this.var_colonne2 + "%'";
         }

         if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
            this.var_requete = this.var_requete + " and retourEnteteAchats.brfActivite like '%" + this.var_colonne3 + "%'";
         }

         if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
            this.var_requete = this.var_requete + " and retourEnteteAchats.brfAnal4='" + this.dossier + "'";
         }

         if (this.parc != null && !this.parc.isEmpty()) {
            this.var_requete = this.var_requete + " and retourEnteteAchats.brfAnal2='" + this.parc + "'";
         }

         if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
            this.var_requete = this.var_requete + " and retourEnteteAchats.brfSite='" + this.site + "'";
         }

         if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
            this.var_requete = this.var_requete + " and retourEnteteAchats.brfDepartement='" + this.departement + "'";
         }

         if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
            this.var_requete = this.var_requete + " and retourEnteteAchats.brfService='" + this.service + "'";
         }

         if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
            this.var_requete = this.var_requete + " and retourEnteteAchats.brfRegion='" + this.region + "'";
         }

         if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
            this.var_requete = this.var_requete + " and retourEnteteAchats.brfSecteur='" + this.secteur + "'";
         }

         if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
            this.var_requete = this.var_requete + " and retourEnteteAchats.brfPdv='" + this.pdv + "'";
         }

         if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
            this.var_requete = this.var_requete + " and brfligCode>='" + this.produitDebut + "'";
         }

         if (this.produitFin != null && !this.produitFin.isEmpty()) {
            this.var_requete = this.var_requete + " and brfligCode<='" + this.produitFin + "'";
         }

         String[] var5;
         if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
            var5 = this.famille.split(":");
            this.var_requete = this.var_requete + " and brfligFamille like'" + var5[0] + "%'";
         }

         if (this.depot != null && !this.depot.isEmpty() && this.depot.contains(":")) {
            var5 = this.depot.split(":");
            this.var_requete = this.var_requete + " and brfligDepot like'" + var5[0] + "%'";
         } else {
            this.var_requete = this.var_requete + " and (brfligDepot is not null or brfligDepot<>'')";
         }
      }

   }

   public void rechercheCommandeHql(String var1, String var2, String var3, String var4) {
      if (this.serie != null && !this.serie.isEmpty()) {
         this.var_requete = "commandeEnteteVentes.bcmDate>='" + var3 + "' and commandeEnteteVentes.bcmDate<='" + var4 + "' and commandeEnteteVentes.bcmSerie='" + this.serie + "'";
      } else {
         this.var_requete = "commandeEnteteVentes.bcmDate>='" + var3 + "' and commandeEnteteVentes.bcmDate<='" + var4 + "'";
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmActivite='" + this.activite + "'";
      }

      if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
         this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmActivite like '%" + this.var_colonne1 + "%'";
      }

      if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
         this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmActivite like '%" + this.var_colonne2 + "%'";
      }

      if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
         this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmActivite like '%" + this.var_colonne3 + "%'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmAnal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmAnal2='" + this.parc + "'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmSite='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmDepartement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmService='" + this.service + "'";
      }

      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmRegion='" + this.region + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmSecteur='" + this.secteur + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_requete = this.var_requete + " and commandeEnteteVentes.bcmPdv='" + this.pdv + "'";
      }

      if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
         this.var_requete = this.var_requete + " and bcmligCode>='" + this.produitDebut + "'";
      }

      if (this.produitFin != null && !this.produitFin.isEmpty()) {
         this.var_requete = this.var_requete + " and bcmligCode<='" + this.produitFin + "'";
      }

      String[] var5;
      if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
         var5 = this.famille.split(":");
         this.var_requete = this.var_requete + " and bcmligFamille like'" + var5[0] + "%'";
      }

      if (this.depot != null && !this.depot.isEmpty() && this.depot.contains(":")) {
         var5 = this.depot.split(":");
         this.var_requete = this.var_requete + " and bcmligDepot like'" + var5[0] + "%'";
      } else {
         this.var_requete = this.var_requete + " and (bcmligDepot is not null or bcmligDepot<>'')";
      }

   }

   public void rechercheLivraisonHql(String var1, String var2, String var3, String var4) {
      if (this.serie != null && !this.serie.isEmpty()) {
         this.var_requete = "livraisonEnteteVentes.blvDate>='" + var3 + "' and livraisonEnteteVentes.blvDate<='" + var4 + "' and livraisonEnteteVentes.blvSerie='" + this.serie + "'";
      } else {
         this.var_requete = "livraisonEnteteVentes.blvDate>='" + var3 + "' and livraisonEnteteVentes.blvDate<='" + var4 + "'";
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_requete = this.var_requete + " and livraisonEnteteVentes.blvActivite='" + this.activite + "'";
      }

      if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
         this.var_requete = this.var_requete + " and livraisonEnteteVentes.blvActivite like '%" + this.var_colonne1 + "%'";
      }

      if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
         this.var_requete = this.var_requete + " and livraisonEnteteVentes.blvActivite like '%" + this.var_colonne2 + "%'";
      }

      if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
         this.var_requete = this.var_requete + " and livraisonEnteteVentes.blvActivite like '%" + this.var_colonne3 + "%'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_requete = this.var_requete + " and livraisonEnteteVentes.blvAnal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_requete = this.var_requete + " and livraisonEnteteVentes.blvAnal2='" + this.parc + "'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_requete = this.var_requete + " and livraisonEnteteVentes.blvSite='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_requete = this.var_requete + " and livraisonEnteteVentes.blvDepartement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_requete = this.var_requete + " and livraisonEnteteVentes.blvService='" + this.service + "'";
      }

      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_requete = this.var_requete + " and livraisonEnteteVentes.blvRegion='" + this.region + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_requete = this.var_requete + " and livraisonEnteteVentes.blvSecteur='" + this.secteur + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_requete = this.var_requete + " and livraisonEnteteVentes.blvPdv='" + this.pdv + "'";
      }

      if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
         this.var_requete = this.var_requete + " and blvligCode>='" + this.produitDebut + "'";
      }

      if (this.produitFin != null && !this.produitFin.isEmpty()) {
         this.var_requete = this.var_requete + " and blvligCode<='" + this.produitFin + "'";
      }

      String[] var5;
      if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
         var5 = this.famille.split(":");
         this.var_requete = this.var_requete + " and blvligFamille like'" + var5[0] + "%'";
      }

      if (this.depot != null && !this.depot.isEmpty() && this.depot.contains(":")) {
         var5 = this.depot.split(":");
         this.var_requete = this.var_requete + " and blvligDepot like'" + var5[0] + "%'";
      } else {
         this.var_requete = this.var_requete + " and (blvligDepot is not null or blvligDepot<>'')";
      }

   }

   public void rechercheFactureHql(String var1, String var2, String var3, String var4) {
      if (this.serie != null && !this.serie.isEmpty()) {
         this.var_requete = "factureEnteteVentes.facDate>='" + var3 + "' and factureEnteteVentes.facDate<='" + var4 + "' and factureEnteteVentes.facSerie='" + this.serie + "'";
      } else {
         this.var_requete = "factureEnteteVentes.facDate>='" + var3 + "' and factureEnteteVentes.facDate<='" + var4 + "'";
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_requete = this.var_requete + " and factureEnteteVentes.facActivite='" + this.activite + "'";
      }

      if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
         this.var_requete = this.var_requete + " and factureEnteteVentes.facActivite like '%" + this.var_colonne1 + "%'";
      }

      if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
         this.var_requete = this.var_requete + " and factureEnteteVentes.facActivite like '%" + this.var_colonne2 + "%'";
      }

      if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
         this.var_requete = this.var_requete + " and factureEnteteVentes.facActivite like '%" + this.var_colonne3 + "%'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_requete = this.var_requete + " and factureEnteteVentes.facAnal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_requete = this.var_requete + " and factureEnteteVentes.facAnal2='" + this.parc + "'";
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         this.var_requete = this.var_requete + " and factureEnteteVentes.facSite='" + this.site + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         this.var_requete = this.var_requete + " and factureEnteteVentes.facDepartement='" + this.departement + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_requete = this.var_requete + " and factureEnteteVentes.facService='" + this.service + "'";
      }

      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         this.var_requete = this.var_requete + " and factureEnteteVentes.facRegion='" + this.region + "'";
      }

      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         this.var_requete = this.var_requete + " and factureEnteteVentes.facSecteur='" + this.secteur + "'";
      }

      if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
         this.var_requete = this.var_requete + " and factureEnteteVentes.facPdv='" + this.pdv + "'";
      }

      if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
         this.var_requete = this.var_requete + " and facligCode>='" + this.produitDebut + "'";
      }

      if (this.produitFin != null && !this.produitFin.isEmpty()) {
         this.var_requete = this.var_requete + " and facligCode<='" + this.produitFin + "'";
      }

      String[] var5;
      if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
         var5 = this.famille.split(":");
         this.var_requete = this.var_requete + " and facligFamille like'" + var5[0] + "%'";
      }

      if (this.depot != null && !this.depot.isEmpty() && this.depot.contains(":")) {
         var5 = this.depot.split(":");
         this.var_requete = this.var_requete + " and facligDepot like'" + var5[0] + "%'";
      } else {
         this.var_requete = this.var_requete + " and (facligDepot is not null or facligDepot<>'')";
      }

   }

   public void rechercheRetourHql(String var1, String var2, String var3, String var4) {
      if (this.var_br) {
         if (this.serie != null && !this.serie.isEmpty()) {
            this.var_requete = "retourEnteteVentes.brtDate>='" + var3 + "' and retourEnteteVentes.brtDate<='" + var4 + "' and retourEnteteVentes.brtSerie='" + this.serie + "'";
         } else {
            this.var_requete = "retourEnteteVentes.brtDate>='" + var3 + "' and retourEnteteVentes.brtDate<='" + var4 + "'";
         }

         if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
            this.var_requete = this.var_requete + " and retourEnteteVentes.brtActivite='" + this.activite + "'";
         }

         if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
            this.var_requete = this.var_requete + " and retourEnteteVentes.brtActivite like '%" + this.var_colonne1 + "%'";
         }

         if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
            this.var_requete = this.var_requete + " and retourEnteteVentes.brtActivite like '%" + this.var_colonne2 + "%'";
         }

         if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
            this.var_requete = this.var_requete + " and retourEnteteVentes.brtActivite like '%" + this.var_colonne3 + "%'";
         }

         if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
            this.var_requete = this.var_requete + " and retourEnteteVentes.brtAnal4='" + this.dossier + "'";
         }

         if (this.parc != null && !this.parc.isEmpty()) {
            this.var_requete = this.var_requete + " and retourEnteteVentes.brtAnal2='" + this.parc + "'";
         }

         if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
            this.var_requete = this.var_requete + " and retourEnteteVentes.brtSite='" + this.site + "'";
         }

         if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
            this.var_requete = this.var_requete + " and retourEnteteVentes.brtDepartement='" + this.departement + "'";
         }

         if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
            this.var_requete = this.var_requete + " and retourEnteteVentes.brtService='" + this.service + "'";
         }

         if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
            this.var_requete = this.var_requete + " and retourEnteteVentes.brtRegion='" + this.region + "'";
         }

         if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
            this.var_requete = this.var_requete + " and retourEnteteVentes.brtSecteur='" + this.secteur + "'";
         }

         if (this.pdv != null && !this.pdv.isEmpty() && this.pdv.contains(":")) {
            this.var_requete = this.var_requete + " and retourEnteteVentes.brtPdv='" + this.pdv + "'";
         }

         if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
            this.var_requete = this.var_requete + " and brtligCode>='" + this.produitDebut + "'";
         }

         if (this.produitFin != null && !this.produitFin.isEmpty()) {
            this.var_requete = this.var_requete + " and brtligCode<='" + this.produitFin + "'";
         }

         String[] var5;
         if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
            var5 = this.famille.split(":");
            this.var_requete = this.var_requete + " and brtligFamille like'" + var5[0] + "%'";
         }

         if (this.depot != null && !this.depot.isEmpty() && this.depot.contains(":")) {
            var5 = this.depot.split(":");
            this.var_requete = this.var_requete + " and brtligDepot like'" + var5[0] + "%'";
         } else {
            this.var_requete = this.var_requete + " and (brtligDepot is not null or brtligDepot<>'')";
         }
      }

   }

   public String calculPeriode(Date var1) {
      String var2 = "";
      String var3 = "";
      if (var1.getDay() <= 9) {
         var3 = "0" + var1.getDay();
      } else {
         var3 = "" + var1.getDay();
      }

      String var4 = "";
      if (var1.getMonth() + 1 <= 9) {
         var4 = "0" + (var1.getMonth() + 1);
      } else {
         var4 = "" + (var1.getMonth() + 1);
      }

      if (this.filtreDateDebut.getMonth() == this.filtreDateFin.getMonth()) {
         var2 = var3 + ":" + var4;
      } else {
         var2 = var4;
      }

      return var2;
   }

   public void calculCatalogue() throws HibernateException, NamingException, JDOMException, IOException {
      LectureFamillesClients var1 = new LectureFamillesClients();
      var1.setStrId(this.structureLog.getStrid());
      var1.setStructureLog(this.structureLog);
      String var2 = var1.tarifDefaut();
      UtilNombre var3 = new UtilNombre();
      new ProduitsTarif();
      new ArrayList();
      ProduitsTarifDao var6 = new ProduitsTarifDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      ProduitsDepotDao var8 = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
      Session var9 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsTarif");
      List var7 = this.produitsAchsDao.chargerLesProduitsByRequete(this.var_requete, var9);
      if (var7.size() != 0) {
         for(int var10 = 0; var10 < var7.size(); ++var10) {
            this.produits = (Produits)var7.get(var10);
            String var11;
            if (this.produits.getProPhoto() != null && !this.produits.getProPhoto().isEmpty()) {
               var11 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "produits" + File.separator + "photo" + File.separator + this.produits.getProPhoto();
               File var12 = new File(var11);
               if (var12.exists()) {
                  this.produits.setPhoto(var11);
               } else {
                  this.produits.setPhoto((String)null);
               }
            } else {
               this.produits.setPhoto((String)null);
            }

            List var5 = var6.selectProdTarifByprod(this.produits, var9);
            var11 = "";
            String var17 = "";
            if (var5.size() == 0) {
               var17 = "0";
            } else if (((ProduitsTarif)var5.get(0)).getProtarTarifQte() != null && !((ProduitsTarif)var5.get(0)).getProtarTarifQte().isEmpty() && ((ProduitsTarif)var5.get(0)).getProtarTarifQte().contains("#")) {
               String[] var13 = ((ProduitsTarif)var5.get(0)).getProtarTarifQte().split("#");
               int var14 = var13.length;

               for(int var15 = 0; var15 < var14; ++var15) {
                  String[] var16 = var13[var15].split(":");
                  if (var11 != null && !var11.isEmpty()) {
                     var11 = var11 + "\n" + "de " + var16[0] + " à " + var16[1];
                     var17 = var17 + "\n" + var3.myConvertString(Double.parseDouble(var16[2]), this.structureLog.getStrformatdevise());
                  } else {
                     var11 = "de " + var16[0] + " à " + var16[1];
                     var17 = var3.myConvertString(Double.parseDouble(var16[2]), this.structureLog.getStrformatdevise());
                  }
               }
            } else {
               var17 = "" + var3.myConvertString(((ProduitsTarif)var5.get(0)).getProtarPv(), this.structureLog.getStrformatdevise());
            }

            this.produits.setNomTarif(var11);
            this.produits.setPrixTarif(var17);
            if (this.produits.getProCode() != null && !this.produits.getProCode().isEmpty()) {
               if (this.depot != null && !this.depot.isEmpty() && this.depot.contains(":")) {
                  String var18 = "";
                  if (this.depot.contains(":")) {
                     String[] var19 = this.depot.split(":");
                     var18 = var19[0];
                  } else {
                     var18 = this.depot;
                  }

                  this.produitsDepot = var8.produitDepByprod(this.produits.getProCode(), var18, var9);
                  if (this.produitsDepot != null) {
                     this.lesProduits.add(this.produits);
                  }
               } else {
                  this.lesProduits.add(this.produits);
               }
            }
         }
      }

      this.utilInitHibernate.closeSession();
   }

   public void calculConsommation(String var1, String var2, String var3, String var4) throws NamingException, ParseException {
      this.listDocument = new ArrayList();
      if (this.parc != null && this.parc.equals("100")) {
         this.parc = null;
      }

      List var5;
      int var7;
      Stock var8;
      String[] var10;
      if (this.var_inv) {
         this.rechercheInventaireHql(var1, var2, var3, var4);
         new ArrayList();
         InventaireLigneDao var6 = new InventaireLigneDao(this.baseLog, this.utilInitHibernate);
         var5 = var6.rechercheInventaireRequete(this.var_requete, (Session)null);
         if (var5.size() != 0) {
            for(var7 = 0; var7 < var5.size(); ++var7) {
               var8 = new Stock();
               new InventaireLigne();
               InventaireLigne var9 = (InventaireLigne)var5.get(var7);
               if (var9.getInvligDepot() != null && !var9.getInvligDepot().isEmpty() && var9.getInvligCode() != null && !var9.getInvligCode().isEmpty() && var9.getInvligCode().length() >= 2) {
                  var8.setStk_type(30);
                  var8.setStk_date_mvt(var9.getInventaireEntete().getInvDate());
                  var8.setStk_numero(this.calculPeriode(var9.getInventaireEntete().getInvDate()));
                  var8.setStk_pv(var9.getInvligPump() * (double)var9.getInvligQteUtil());
                  var8.setStk_pump(var9.getInvligPump() * (double)var9.getInvligQteUtil());
                  var8.setStk_pa(0.0D);
                  var8.setStk_qte_in(var9.getInvligQteUtil());
                  var8.setStk_qte_out(0.0F);
                  var8.setStk_code_produit(var9.getInvligCode());
                  var8.setStkLibelle(var9.getInvligLibelle());
                  var8.setStkFamille(var9.getInvligFamille());
                  if (var8.getStkFamille() != null && !var8.getStkFamille().isEmpty() && var8.getStkFamille().contains(":")) {
                     var10 = var8.getStkFamille().split(":");
                     var8.setStkFamille(var10[0]);
                  }

                  var8.setStk_code_depot(var9.getInvligDepot());
                  var8.setStk_etat("" + var9.getInventaireEntete().getInvEtat());
                  this.listDocument.add(var8);
               }
            }
         }
      }

      if (this.var_bin) {
         this.rechercheBEntreeHql(var1, var2, var3, var4);
         new ArrayList();
         BonEntreeLigneDao var11 = new BonEntreeLigneDao(this.baseLog, this.utilInitHibernate);
         var5 = var11.rechercheBEntreeRequete(this.var_requete, (Session)null);
         if (var5.size() != 0) {
            for(var7 = 0; var7 < var5.size(); ++var7) {
               var8 = new Stock();
               new BonEntreeLigne();
               BonEntreeLigne var18 = (BonEntreeLigne)var5.get(var7);
               if (var18.getBinligDepot() != null && !var18.getBinligDepot().isEmpty() && var18.getBinligCode() != null && !var18.getBinligCode().isEmpty() && var18.getBinligCode().length() >= 2) {
                  var8.setStk_type(31);
                  var8.setStk_date_mvt(var18.getBonEntreeEntete().getBinDate());
                  var8.setStk_numero(this.calculPeriode(var18.getBonEntreeEntete().getBinDate()));
                  var8.setStk_pv(var18.getBinligPump() * (double)var18.getBinligQteUtil());
                  var8.setStk_pump(var18.getBinligPump() * (double)var18.getBinligQteUtil());
                  var8.setStk_pa(0.0D);
                  var8.setStk_qte_in(var18.getBinligQteUtil());
                  var8.setStk_qte_out(0.0F);
                  var8.setStk_code_produit(var18.getBinligCode());
                  var8.setStkLibelle(var18.getBinligLibelle());
                  var8.setStkFamille(var18.getBinligFamille());
                  if (var8.getStkFamille() != null && !var8.getStkFamille().isEmpty() && var8.getStkFamille().contains(":")) {
                     var10 = var8.getStkFamille().split(":");
                     var8.setStkFamille(var10[0]);
                  }

                  var8.setStk_code_depot(var18.getBinligDepot());
                  var8.setStk_etat("" + var18.getBonEntreeEntete().getBinEtat());
                  this.listDocument.add(var8);
               }
            }
         }
      }

      if (this.var_bout) {
         this.rechercheBSortieHql(var1, var2, var3, var4);
         new ArrayList();
         BonSortieLigneDao var12 = new BonSortieLigneDao(this.baseLog, this.utilInitHibernate);
         var5 = var12.rechercheBSortieRequete(this.var_requete, (Session)null);
         if (var5.size() != 0) {
            for(var7 = 0; var7 < var5.size(); ++var7) {
               var8 = new Stock();
               new BonSortieLigne();
               BonSortieLigne var19 = (BonSortieLigne)var5.get(var7);
               if (var19.getBouligDepot() != null && !var19.getBouligDepot().isEmpty() && var19.getBouligCode() != null && !var19.getBouligCode().isEmpty() && var19.getBouligCode().length() >= 2) {
                  var8.setStk_type(32);
                  var8.setStk_date_mvt(var19.getBonSortieEntete().getBouDate());
                  var8.setStk_numero(this.calculPeriode(var19.getBonSortieEntete().getBouDate()));
                  var8.setStk_pv(var19.getBouligPump() * (double)var19.getBouligQteUtil());
                  var8.setStk_pump(var19.getBouligPump() * (double)var19.getBouligQteUtil());
                  var8.setStk_pa(0.0D);
                  var8.setStk_qte_in(0.0F);
                  var8.setStk_qte_out(var19.getBouligQteUtil());
                  var8.setStk_code_produit(var19.getBouligCode());
                  var8.setStkLibelle(var19.getBouligLibelle());
                  var8.setStkFamille(var19.getBouligFamille());
                  if (var8.getStkFamille() != null && !var8.getStkFamille().isEmpty() && var8.getStkFamille().contains(":")) {
                     var10 = var8.getStkFamille().split(":");
                     var8.setStkFamille(var10[0]);
                  }

                  var8.setStk_code_depot(var19.getBouligDepot());
                  var8.setStk_etat("" + var19.getBonSortieEntete().getBouEtat());
                  this.listDocument.add(var8);
               }
            }
         }
      }

      if (this.var_ces) {
         this.rechercheCessionHql(var1, var2, var3, var4);
         new ArrayList();
         CessionLigneDao var13 = new CessionLigneDao(this.baseLog, this.utilInitHibernate);
         var5 = var13.rechercheCessionRequete(this.var_requete, (Session)null);
         if (var5.size() != 0) {
            for(var7 = 0; var7 < var5.size(); ++var7) {
               var8 = new Stock();
               new CessionLigne();
               CessionLigne var20 = (CessionLigne)var5.get(var7);
               if (var20.getCesligDepotOrigine() != null && !var20.getCesligDepotOrigine().isEmpty() && var20.getCesligCode() != null && !var20.getCesligCode().isEmpty() && var20.getCesligCode().length() >= 2) {
                  var8.setStk_type(33);
                  var8.setStk_date_mvt(var20.getCessionEntete().getCesDate());
                  var8.setStk_numero(this.calculPeriode(var20.getCessionEntete().getCesDate()));
                  var8.setStk_pv(var20.getCesligPump() * (double)var20.getCesligQteUtil());
                  var8.setStk_pump(var20.getCesligPump() * (double)var20.getCesligQteUtil());
                  var8.setStk_pa(0.0D);
                  var8.setStk_qte_in(0.0F);
                  var8.setStk_qte_out(var20.getCesligQteUtil());
                  var8.setStk_code_produit(var20.getCesligCode());
                  var8.setStkLibelle(var20.getCesligLibelle());
                  var8.setStkFamille(var20.getCesligFamille());
                  if (var8.getStkFamille() != null && !var8.getStkFamille().isEmpty() && var8.getStkFamille().contains(":")) {
                     var10 = var8.getStkFamille().split(":");
                     var8.setStkFamille(var10[0]);
                  }

                  var8.setStk_code_depot(var20.getCesligDepotOrigine());
                  var8.setStk_etat("" + var20.getCessionEntete().getCesEtat());
                  this.listDocument.add(var8);
               }

               if (var20.getCesligDepotDestination() != null && !var20.getCesligDepotDestination().isEmpty() && var20.getCesligCode() != null && !var20.getCesligCode().isEmpty() && var20.getCesligCode().length() >= 2) {
                  var8.setStk_type(33);
                  var8.setStk_date_mvt(var20.getCessionEntete().getCesDate());
                  var8.setStk_numero(this.calculPeriode(var20.getCessionEntete().getCesDate()));
                  var8.setStk_pv(var20.getCesligPump() * (double)var20.getCesligQteUtil());
                  var8.setStk_pump(var20.getCesligPump() * (double)var20.getCesligQteUtil());
                  var8.setStk_pa(0.0D);
                  var8.setStk_qte_in(var20.getCesligQteUtil());
                  var8.setStk_qte_out(0.0F);
                  var8.setStk_code_produit(var20.getCesligCode());
                  var8.setStkLibelle(var20.getCesligLibelle());
                  var8.setStkFamille(var20.getCesligFamille());
                  if (var8.getStkFamille() != null && !var8.getStkFamille().isEmpty() && var8.getStkFamille().contains(":")) {
                     var10 = var8.getStkFamille().split(":");
                     var8.setStkFamille(var10[0]);
                  }

                  var8.setStk_code_depot(var20.getCesligDepotDestination());
                  var8.setStk_etat("" + var20.getCessionEntete().getCesEtat());
                  this.listDocument.add(var8);
               }
            }
         }
      }

      if (this.var_prod) {
      }

      if (this.var_rec) {
         this.rechercheReceptionHql(var1, var2, var3, var4);
         new ArrayList();
         ReceptionLigneAchatsDao var14 = new ReceptionLigneAchatsDao(this.baseLog, this.utilInitHibernate);
         var5 = var14.rechercheReceptionRequete(this.var_requete, (Session)null);
         if (var5.size() != 0) {
            for(var7 = 0; var7 < var5.size(); ++var7) {
               var8 = new Stock();
               new ReceptionLigneAchats();
               ReceptionLigneAchats var21 = (ReceptionLigneAchats)var5.get(var7);
               if (var21.getRecligDepot() != null && !var21.getRecligDepot().isEmpty() && var21.getRecligCode() != null && !var21.getRecligCode().isEmpty() && var21.getRecligCode().length() >= 2) {
                  var8.setStk_type(13);
                  var8.setStk_date_mvt(var21.getReceptionEnteteAchats().getRecDate());
                  var8.setStk_numero(this.calculPeriode(var21.getReceptionEnteteAchats().getRecDate()));
                  var8.setStk_pv(var21.getRecligPt());
                  var8.setStk_pump(var21.getRecligPump() * (double)var21.getRecligQteUtil());
                  var8.setStk_pa(var8.getStk_pv() - var8.getStk_pump());
                  var8.setStk_qte_in(var21.getRecligQteUtil());
                  var8.setStk_qte_out(0.0F);
                  var8.setStk_code_produit(var21.getRecligCode());
                  var8.setStkLibelle(var21.getRecligLibelle());
                  var8.setStkFamille(var21.getRecligFamille());
                  if (var8.getStkFamille() != null && !var8.getStkFamille().isEmpty() && var8.getStkFamille().contains(":")) {
                     var10 = var8.getStkFamille().split(":");
                     var8.setStkFamille(var10[0]);
                  }

                  var8.setStk_code_depot(var21.getRecligDepot());
                  var8.setStk_etat("" + var21.getReceptionEnteteAchats().getRecEtat());
                  this.listDocument.add(var8);
               }
            }
         }
      }

      if (this.var_sav) {
         this.rechercheSavHql(var1, var2, var3, var4);
         new ArrayList();
         RetourLigneAchatsDao var15 = new RetourLigneAchatsDao(this.baseLog, this.utilInitHibernate);
         var5 = var15.rechercheRetourRequete(this.var_requete, (Session)null);
         if (var5.size() != 0) {
            for(var7 = 0; var7 < var5.size(); ++var7) {
               var8 = new Stock();
               new RetourLigneAchats();
               RetourLigneAchats var22 = (RetourLigneAchats)var5.get(var7);
               if (var22.getBrfligDepot() != null && !var22.getBrfligDepot().isEmpty() && var22.getBrfligCode() != null && !var22.getBrfligCode().isEmpty() && var22.getBrfligCode().length() >= 2) {
                  var8.setStk_type(14);
                  var8.setStk_date_mvt(var22.getRetourEnteteAchats().getBrfDate());
                  var8.setStk_numero(this.calculPeriode(var22.getRetourEnteteAchats().getBrfDate()));
                  var8.setStk_pv(var22.getBrfligPt() * -1.0D);
                  var8.setStk_pump(var22.getBrfligPump() * (double)var22.getBrfligQteUtil() * -1.0D);
                  var8.setStk_pa(var8.getStk_pv() - var8.getStk_pump());
                  var8.setStk_qte_in(0.0F);
                  var8.setStk_qte_out(var22.getBrfligQteUtil() * -1.0F);
                  var8.setStk_code_produit(var22.getBrfligCode());
                  var8.setStkLibelle(var22.getBrfligLibelle());
                  var8.setStkFamille(var22.getBrfligFamille());
                  if (var8.getStkFamille() != null && !var8.getStkFamille().isEmpty() && var8.getStkFamille().contains(":")) {
                     var10 = var8.getStkFamille().split(":");
                     var8.setStkFamille(var10[0]);
                  }

                  var8.setStk_code_depot(var22.getBrfligDepot());
                  var8.setStk_etat("" + var22.getRetourEnteteAchats().getBrfEtat());
                  this.listDocument.add(var8);
               }
            }
         }
      }

      if (this.var_bl) {
         this.rechercheLivraisonHql(var1, var2, var3, var4);
         new ArrayList();
         LivraisonLigneVentesDao var16 = new LivraisonLigneVentesDao(this.baseLog, this.utilInitHibernate);
         var5 = var16.rechercheLivraisonRequete(this.var_requete, (Session)null);
         if (var5.size() != 0) {
            for(var7 = 0; var7 < var5.size(); ++var7) {
               var8 = new Stock();
               new LivraisonLigneVentes();
               LivraisonLigneVentes var23 = (LivraisonLigneVentes)var5.get(var7);
               if (var23.getBlvligDepot() != null && !var23.getBlvligDepot().isEmpty() && var23.getBlvligCode() != null && !var23.getBlvligCode().isEmpty() && var23.getBlvligCode().length() >= 2) {
                  var8.setStk_type(23);
                  var8.setStk_date_mvt(var23.getLivraisonEnteteVentes().getBlvDate());
                  var8.setStk_numero(this.calculPeriode(var23.getLivraisonEnteteVentes().getBlvDate()));
                  var8.setStk_pv(var23.getBlvligPt());
                  var8.setStk_pump(var23.getBlvligPump() * (double)var23.getBlvligQteUtil());
                  var8.setStk_pa(var8.getStk_pv() - var8.getStk_pump());
                  var8.setStk_qte_in(0.0F);
                  var8.setStk_qte_out(var23.getBlvligQteUtil());
                  var8.setStk_code_produit(var23.getBlvligCode());
                  var8.setStkLibelle(var23.getBlvligLibelle());
                  var8.setStkFamille(var23.getBlvligFamille());
                  if (var8.getStkFamille() != null && !var8.getStkFamille().isEmpty() && var8.getStkFamille().contains(":")) {
                     var10 = var8.getStkFamille().split(":");
                     var8.setStkFamille(var10[0]);
                  }

                  var8.setStk_code_depot(var23.getBlvligDepot());
                  var8.setStk_etat("" + var23.getLivraisonEnteteVentes().getBlvEtat());
                  this.listDocument.add(var8);
               }
            }
         }
      }

      if (this.var_br) {
         this.rechercheRetourHql(var1, var2, var3, var4);
         new ArrayList();
         RetourLigneVentesDao var17 = new RetourLigneVentesDao(this.baseLog, this.utilInitHibernate);
         var5 = var17.rechercheRetourRequete(this.var_requete, (Session)null);
         if (var5.size() != 0) {
            for(var7 = 0; var7 < var5.size(); ++var7) {
               var8 = new Stock();
               new RetourLigneVentes();
               RetourLigneVentes var24 = (RetourLigneVentes)var5.get(var7);
               if (var24.getBrtligDepot() != null && !var24.getBrtligDepot().isEmpty() && var24.getBrtligCode() != null && !var24.getBrtligCode().isEmpty() && var24.getBrtligCode().length() >= 2) {
                  var8.setStk_type(24);
                  var8.setStk_date_mvt(var24.getRetourEnteteVentes().getBrtDate());
                  var8.setStk_numero(this.calculPeriode(var24.getRetourEnteteVentes().getBrtDate()));
                  var8.setStk_pv(var24.getBrtligPt() * -1.0D);
                  var8.setStk_pump(var24.getBrtligPump() * (double)var24.getBrtligQteUtil() * -1.0D);
                  var8.setStk_pa(var8.getStk_pv() - var8.getStk_pump());
                  var8.setStk_qte_in(var24.getBrtligQteUtil() * -1.0F);
                  var8.setStk_qte_out(0.0F);
                  var8.setStk_code_produit(var24.getBrtligCode());
                  var8.setStkLibelle(var24.getBrtligLibelle());
                  var8.setStkFamille(var24.getBrtligFamille());
                  if (var8.getStkFamille() != null && !var8.getStkFamille().isEmpty() && var8.getStkFamille().contains(":")) {
                     var10 = var8.getStkFamille().split(":");
                     var8.setStkFamille(var10[0]);
                  }

                  var8.setStk_code_depot(var24.getBrtligDepot());
                  var8.setStk_etat("" + var24.getRetourEnteteVentes().getBrtEtat());
                  this.listDocument.add(var8);
               }
            }
         }
      }

      if (this.var_inv || this.var_bin || this.var_bout || this.var_ces || this.var_prod || this.var_rec || this.var_sav || this.var_bl || this.var_br) {
         this.var_filtre = this.var_filtre + " Analyse = ";
         if (this.var_inv) {
            this.var_filtre = this.var_filtre + "INV,";
         }

         if (this.var_bin) {
            this.var_filtre = this.var_filtre + "BIN,";
         }

         if (this.var_bout) {
            this.var_filtre = this.var_filtre + "BOUT,";
         }

         if (this.var_ces) {
            this.var_filtre = this.var_filtre + "CES,";
         }

         if (this.var_prod) {
         }

         if (this.var_rec) {
            this.var_filtre = this.var_filtre + "REC,";
         }

         if (this.var_sav) {
            this.var_filtre = this.var_filtre + "RET,";
         }

         if (this.var_bl) {
            this.var_filtre = this.var_filtre + "BLV,";
         }

         if (this.var_br) {
            this.var_filtre = this.var_filtre + "RET,";
         }
      }

   }

   public void calculEtatStock(String var1, String var2, String var3, String var4, String var5) throws NamingException, ParseException {
      this.listDocument = new ArrayList();
      this.var_currentValue = 0;
      this.depot_encours = this.depot;
      this.produit_encours = "Chargement des produits...";
      Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "CalculMouvementStock");
      InventaireLigneDao var7 = new InventaireLigneDao(this.baseLog, this.utilInitHibernate);
      UtilNombre var8 = new UtilNombre();
      CalculStock var9 = new CalculStock();
      this.rechercheProduitDepotHql();
      new ArrayList();
      ProduitsDepotDao var11 = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
      List var10 = var11.rechercheProduitDepotRequete(this.var_requete, var6);
      if (var10.size() != 0) {
         String var12 = "";

         for(int var13 = 0; var13 < var10.size(); ++var13) {
            String var14 = ((ProduitsDepot)var10.get(var13)).getProduits().getProCode();
            if (var14 != null && !var14.isEmpty() && (var12 == null || var12.isEmpty() || var12 != null && !var12.isEmpty() && !var12.contains(var14)) && (this.serie == null || this.serie.isEmpty() || this.serie != null && !this.serie.isEmpty() && (((ProduitsDepot)var10.get(var13)).getProduits().getProSerie() == null || ((ProduitsDepot)var10.get(var13)).getProduits().getProSerie().isEmpty() || ((ProduitsDepot)var10.get(var13)).getProduits().getProSerie() != null && !((ProduitsDepot)var10.get(var13)).getProduits().getProSerie().isEmpty() && ((ProduitsDepot)var10.get(var13)).getProduits().getProSerie().equals(this.serie)))) {
               if (((ProduitsDepot)var10.get(var13)).getProduits().getProSerie() != null && !((ProduitsDepot)var10.get(var13)).getProduits().getProSerie().isEmpty() && ((ProduitsDepot)var10.get(var13)).getProduits().getProSerie().equals(this.serie)) {
                  this.serie = "";
               }

               if (var12 != null && !var12.isEmpty()) {
                  var12 = var12 + "," + "'" + var14 + "'";
               } else {
                  var12 = "'" + var14 + "'";
               }
            }
         }

         var12 = "(" + var12 + ")";
         new ArrayList();
         ArrayList var35 = new ArrayList();
         Object var15 = new ArrayList();
         new DepotAchats();
         DepotAchats var16;
         if (this.depot != null && !this.depot.isEmpty() && this.depot.contains(":")) {
            String[] var36 = this.depot.split(":");
            this.depot = var36[0];
            var16 = new DepotAchats();
            var16.setDpoCode(this.depot);
            ((List)var15).add(var16);
         } else if (this.depot == null || this.depot.isEmpty() || this.depot != null && !this.depot.isEmpty() && this.depot.equals("XXXX")) {
            this.depot = null;
            DepotAchatsDao var17 = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
            var15 = var17.selectAllDepotActif(var6);
         }

         int var37;
         for(var37 = 0; var37 < ((List)var15).size(); ++var37) {
            var16 = (DepotAchats)((List)var15).get(var37);
            if (var16.getDpoInactif() == 0) {
               this.depot = var16.getDpoCode();
               if (var37 != 0) {
                  double var18 = (double)((List)var15).size();
                  double var20 = var8.myRound(var18 / (double)var37, 4);
                  double var22 = var8.myRound(100.0D / var20, 2);
                  this.var_currentValue = (int)var22;
               }

               this.produit_encours = "Depot en cours : " + var16.getDpoCode() + " " + var16.getDpoLibelle();
               new ArrayList();
               List var38 = var7.chargerLesMvts(var12, this.depot, var6);
               byte var19 = 1;
               if (this.stockQteVal == 1) {
                  var19 = 3;
               }

               List var34 = var9.chargerMouvements(var19, this.serie, "", var12, (String)null, this.depot, 0L, this.activite, this.service, this.filtreDateDebut, this.filtreDateFin, false, false, true, true, false, false, false, true, true, true, true, false, false, true, true, false, false, false, true, false, true, this.optionVentes.getGestionStockBc(), this.baseLog, this.structureLog, var6);

               for(int var42 = 0; var42 < var10.size(); ++var42) {
                  this.produitsDepot = (ProduitsDepot)var10.get(var42);
                  String var21 = this.produitsDepot.getProduits().getProCode();
                  float var43 = 0.0F;
                  float var23 = 0.0F;
                  float var24 = 0.0F;
                  float var25 = 0.0F;
                  float var26 = 0.0F;
                  double var27 = 0.0D;
                  Date var29 = null;
                  var29 = this.utilDate.stringToDateSQL("2000-01-01 00:00:00");
                  new InventaireLigne();

                  int var31;
                  for(var31 = 0; var31 < var38.size(); ++var31) {
                     InventaireLigne var30 = (InventaireLigne)var38.get(var31);
                     if (var30.getInvligCode() != null && !var30.getInvligCode().isEmpty() && var30.getInvligCode().equals(var21) && (var29 == null || var30.getInventaireEntete().getInvDate().compareTo(var29) > 0)) {
                        var26 = var30.getInvligQte();
                        var29 = var30.getInventaireEntete().getInvDate();
                        Stock var32 = new Stock();
                        var32.setStk_lib_type("Inventaire");
                        var32.setStk_type(30);
                        var32.setStk_etat("Validé");
                        var32.setStk_code_depot(var30.getInvligDepot());
                        var32.setStk_code_produit(var30.getInvligCode());
                        var32.setStkLibelle(var30.getInvligLibelle());
                        var32.setStkFamille(var30.getInvligFamille());
                        if (var32.getStkFamille() != null && !var32.getStkFamille().isEmpty() && var32.getStkFamille().contains(":")) {
                           String[] var33 = var32.getStkFamille().split(":");
                           var32.setStkFamille(var33[0]);
                        }

                        var32.setStk_numero(var30.getInventaireEntete().getInvNum());
                        var32.setStk_serie(var30.getInventaireEntete().getInvSerie());
                        var32.setStk_tiers("Inventaire");
                        var32.setStk_activite(var30.getInventaireEntete().getInvActivite());
                        var32.setStk_date_mvt(var30.getInventaireEntete().getInvDate());
                        var32.setStk_pa(0.0D);
                        var32.setStkDevise(this.structureLog.getStrdevise());
                        var32.setStk_format_devise(var8.formatDevise(var32.getStkDevise()));
                        var32.setStk_pv(0.0D);
                        var32.setStk_pump(var30.getInvligPump());
                        var27 = var32.getStk_pump();
                        var32.setStk_qte_in(var30.getInvligQteUtil());
                        var32.setStk_qte_out(0.0F);
                        var35.add(var32);
                     }
                  }

                  for(var31 = 0; var31 < var34.size(); ++var31) {
                     if (((Stock)var34.get(var31)).getStk_code_produit() != null && !((Stock)var34.get(var31)).getStk_code_produit().isEmpty() && ((Stock)var34.get(var31)).getStk_code_produit().equals(var21)) {
                        if ((var29 == null || ((Stock)var34.get(var31)).getStk_date_mvt().compareTo(var29) >= 0) && ((Stock)var34.get(var31)).getStk_type() != 10 && ((Stock)var34.get(var31)).getStk_type() != 11 && ((Stock)var34.get(var31)).getStk_type() != 12) {
                           if (((Stock)var34.get(var31)).getStk_pump() == 0.0D && var27 != 0.0D) {
                              ((Stock)var34.get(var31)).setStk_pump(var27);
                           }

                           var26 += ((Stock)var34.get(var31)).getStk_qte_in() - ((Stock)var34.get(var31)).getStk_qte_out();
                        }

                        var35.add(var34.get(var31));
                     }
                  }
               }
            }
         }

         if (this.stocknull == 0 && var35.size() != 0) {
            float var40 = 0.0F;
            float var39 = 0.0F;

            int var41;
            for(var41 = 0; var41 < var35.size(); ++var41) {
               var40 += ((Stock)var35.get(var41)).getStk_qte_in();
               var39 += ((Stock)var35.get(var41)).getStk_qte_out();
            }

            if (var40 - var39 != 0.0F && var35.size() != 0) {
               for(var41 = 0; var41 < var35.size(); ++var41) {
                  this.listDocument.add(var35.get(var41));
               }
            }
         } else if (this.stocknull == 1 && var35.size() != 0) {
            for(var37 = 0; var37 < var35.size(); ++var37) {
               this.listDocument.add(var35.get(var37));
            }
         }

         if (this.listDocument.size() != 0 && this.nomEtat.endsWith("Mandarine")) {
            this.achatMandarine(var6);
         }

         this.utilInitHibernate.closeSession();
      }

   }

   public void achatMandarine(Session var1) throws HibernateException, NamingException {
      if (this.listDocument.size() != 0) {
         ArrayList var2 = new ArrayList();
         new ArrayList();
         ReceptionLigneAchatsDao var4 = new ReceptionLigneAchatsDao(this.baseLog, this.utilInitHibernate);
         new Stock();

         int var6;
         for(var6 = 0; var6 < this.listDocument.size(); ++var6) {
            Stock var5 = (Stock)this.listDocument.get(var6);
            if (var5.getStk_code_produit() != null && !var5.getStk_code_produit().isEmpty()) {
               List var3 = var4.chargerLesMvts(var5.getStk_code_produit(), var1);
               if (var3.size() != 0) {
                  int var7 = var3.size() - 1;
                  var5.setStkDevise(((ReceptionLigneAchats)var3.get(var7)).getReceptionEnteteAchats().getRecDevise());
                  var5.setStk_devise(((ReceptionLigneAchats)var3.get(var7)).getRecligCoefPr());
                  var5.setStk_qte_mini(((ReceptionLigneAchats)var3.get(var7)).getRecligQte());
                  var5.setStkRabais(((ReceptionLigneAchats)var3.get(var7)).getRecligPu());
                  var5.setStkTc(((ReceptionLigneAchats)var3.get(var7)).getRecligPr());
                  var2.add(var5);
               } else {
                  var2.add(var5);
               }
            } else {
               var2.add(var5);
            }
         }

         this.listDocument.clear();

         for(var6 = 0; var6 < var2.size(); ++var6) {
            this.listDocument.add(var2.get(var6));
         }
      }

   }

   public void calculPreparation() throws HibernateException, NamingException, JDOMException, IOException, ParseException {
      this.var_entete = "Préparation Inventaire";
      this.listDocument = new ArrayList();
      new ArrayList();
      ProduitsDepotDao var2 = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      FamillesProduitsAchatsDao var4 = new FamillesProduitsAchatsDao(this.baseLog, this.utilInitHibernate);
      FamillesProduitsVentesDao var5 = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
      new FamillesProduitsAchats();
      new FamillesProduitsVentes();
      UtilNombre var8 = new UtilNombre();
      new Stock();
      String var10 = "";
      if (this.depot != null && !this.depot.isEmpty()) {
         if (this.depot.contains(":")) {
            String[] var11 = this.depot.split(":");
            var10 = var11[0];
         } else {
            var10 = this.depot;
         }
      }

      Session var19 = this.utilInitHibernate.getOpenSession(this.baseLog, "CalculMouvementStock");
      this.var_requete = this.var_requete + " and pro_inactif = 0";
      List var1 = this.produitsAchsDao.chargerLesProduitsByRequete(this.var_requete, var19);
      if (var1.size() != 0) {
         for(int var12 = 0; var12 < var1.size(); ++var12) {
            this.produits = (Produits)var1.get(var12);
            if (this.produits.getProCode() != null && !this.produits.getProCode().isEmpty()) {
               this.depot_encours = "";
               this.produit_encours = this.produits.getProCode() + " " + this.produits.getProLibClient();
               if (var12 != 0) {
                  double var13 = (double)var1.size();
                  double var15 = var8.myRound(var13 / (double)var12, 4);
                  double var17 = var8.myRound(100.0D / var15, 2);
                  this.var_currentValue = (int)var17;
               }

               Stock var9 = new Stock();
               var9.setStk_code_produit(this.produits.getProCode());
               var9.setStkLibelle(this.produits.getProLibClient());
               if (this.produits != null) {
                  if (this.produits.getProPhoto() != null && !this.produits.getProPhoto().isEmpty()) {
                     String var20 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "produits" + File.separator + "photo" + File.separator + this.produits.getProPhoto();
                     File var14 = new File(var20);
                     if (var14.exists()) {
                        var9.setStk_divers(var20);
                     } else {
                        var9.setStk_divers((String)null);
                     }
                  } else {
                     var9.setStk_divers((String)null);
                  }
               } else {
                  var9.setStk_divers((String)null);
               }

               if (this.produits.getProVteCode() != null && !this.produits.getProVteCode().isEmpty()) {
                  FamillesProduitsVentes var7 = var5.rechercheFamilleByCode(0L, this.produits.getProVteCode(), var19);
                  if (var7 != null) {
                     var9.setStkFamille(this.produits.getProVteCode() + " - " + var7.getFamvteLibelleFr());
                  } else {
                     var9.setStkFamille(this.produits.getProVteCode());
                  }
               } else if (this.produits.getProAchCode() != null && !this.produits.getProAchCode().isEmpty()) {
                  FamillesProduitsAchats var6 = var4.rechercheFamilleByCode(0L, this.produits.getProAchCode(), var19);
                  if (var6 != null) {
                     var9.setStkFamille(this.produits.getProAchCode() + " - " + var6.getFamachLibelleFr());
                  } else {
                     var9.setStkFamille(this.produits.getProAchCode());
                  }
               } else {
                  var9.setStkFamille("");
               }

               List var3 = var2.selectProdDepByprod(this.produits, var19);
               if (var3.size() == 0) {
                  var9.setStk_code_depot("");
                  var9.setStkReference("");
                  this.listDocument.add(var9);
               } else {
                  for(int var21 = 0; var21 < var3.size(); ++var21) {
                     if (var10 != null && !var10.isEmpty()) {
                        if (((ProduitsDepot)var3.get(var21)).getDepot().getDpoCode().equals(var10)) {
                           var9.setStk_code_depot(((ProduitsDepot)var3.get(var21)).getDepot().getDpoCode());
                           var9.setStkReference(((ProduitsDepot)var3.get(var21)).getProdepCasier());
                           this.listDocument.add(var9);
                        }
                     } else {
                        var9.setStk_code_depot(((ProduitsDepot)var3.get(var21)).getDepot().getDpoCode());
                        var9.setStkReference(((ProduitsDepot)var3.get(var21)).getProdepCasier());
                        this.listDocument.add(var9);
                     }
                  }
               }
            }
         }
      }

      this.utilInitHibernate.closeSession();
   }

   public void calculReappro(String var1, String var2, String var3, String var4, String var5) throws HibernateException, NamingException, ParseException {
      this.listDocument = new ArrayList();
      if (this.depot != null && !this.depot.isEmpty()) {
         UtilNombre var6 = new UtilNombre();
         CalculStock var7 = new CalculStock();
         Date var8 = null;
         Session var9 = this.utilInitHibernate.getOpenSession(this.baseLog, "CalculMouvementStock");
         new ArrayList();
         ProduitsDepotDao var11 = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
         List var10 = var11.rechercheReaoppro(this.categorie, var9);
         if (var10.size() != 0) {
            for(int var12 = 0; var12 < var10.size(); ++var12) {
               this.produitsDepot = (ProduitsDepot)var10.get(var12);
               this.produits = this.produitsDepot.getProduits();
               if (var12 != 0) {
                  double var13 = (double)var10.size();
                  double var15 = var6.myRound(var13 / (double)var12, 4);
                  double var17 = var6.myRound(100.0D / var15, 2);
                  this.var_currentValue = (int)var17;
               }

               this.depot_encours = this.produitsDepot.getDepot().getDpoCode();
               this.produit_encours = this.produitsDepot.getProduits().getProCode() + " " + this.produitsDepot.getProduits().getProLibClient();
               new InventaireLigne();
               String var14 = this.utilDate.dateToStringSQLLight(this.filtreDateDebut) + " 00:00:00";
               String var23 = this.utilDate.dateToStringSQLLight(this.filtreDateFin) + " 23:59:59";
               InventaireLigne var22 = var7.localisationInventaire(this.serie, var14, var23, this.produitsDepot.getProduits().getProCode(), this.produitsDepot.getDepot().getDpoCode(), 0L, this.baseLog, var9);
               if (var22 == null) {
                  var8 = this.utilDate.stringToDateSQL("2000-01-01 00:00:00");
               } else {
                  var8 = var22.getInventaireEntete().getInvDate();
                  Stock var16 = new Stock();
                  var16.setStk_lib_type("Inventaire");
                  var16.setStk_type(30);
                  var16.setStk_etat("Validé");
                  var16.setStk_code_depot(var22.getInvligDepot());
                  var16.setStk_code_produit(var22.getInvligCode());
                  var16.setStkLibelle(var22.getInvligLibelle());
                  var16.setStkFamille(var22.getInvligFamille());
                  if (var16.getStkFamille() != null && !var16.getStkFamille().isEmpty() && var16.getStkFamille().contains(":")) {
                     String[] var25 = var16.getStkFamille().split(":");
                     var16.setStkFamille(var25[0]);
                  }

                  var16.setStk_numero(var22.getInventaireEntete().getInvNum());
                  var16.setStk_tiers("Inventaire");
                  var16.setStk_activite(var22.getInventaireEntete().getInvActivite());
                  var16.setStk_date_mvt(var22.getInventaireEntete().getInvDate());
                  var16.setStk_pa(0.0D);
                  var16.setStkDevise(this.structureLog.getStrdevise());
                  var16.setStk_format_devise(var6.formatDevise(var16.getStkDevise()));
                  var16.setStk_pv(0.0D);
                  var16.setStk_pump(var22.getInvligPump());
                  var16.setStk_qte_in(var22.getInvligQteUtil());
                  var16.setStk_qte_out(0.0F);
                  var16.setStk_qte_mini(this.produitsDepot.getProdepQteMini());
                  var16.setStk_qte_maxi(this.produitsDepot.getProdepQteMaxi());
                  this.listDocument.add(var16);
               }

               String var24 = this.utilDate.dateToStringSQLLight(this.utilDate.dateJourPrecedent(this.filtreDateDebut)) + " 23:59:59";
               this.date_ante = this.utilDate.stringToDateSQL(var24);
               new ArrayList();
               String var18 = "";
               if (this.produitsDepot.getProduits().getProVteNat() != null && !this.produitsDepot.getProduits().getProVteNat().isEmpty()) {
                  var18 = this.produitsDepot.getProduits().getProVteNat();
               } else {
                  var18 = this.produitsDepot.getProduits().getProAchNat();
               }

               List var26 = var7.chargerMouvements(1, this.serie, var18, this.produitsDepot.getProduits().getProCode(), this.produitsDepot.getProduits().getProLibTech(), this.depot_encours, 0L, this.activite, this.service, var8, this.filtreDateFin, false, false, true, true, false, false, false, true, true, true, true, false, false, true, true, false, false, false, true, false, true, this.optionVentes.getGestionStockBc(), this.baseLog, this.structureLog, var9);
               if (var26.size() != 0) {
                  new Stock();

                  for(int var20 = 0; var20 < var26.size(); ++var20) {
                     Stock var19 = (Stock)var26.get(var20);
                     if (var19.getStkFamille() != null && !var19.getStkFamille().isEmpty() && var19.getStkFamille().contains(":")) {
                        String[] var21 = var19.getStkFamille().split(":");
                        var19.setStkFamille(var21[0]);
                     }

                     var19.setStk_qte_mini(this.produitsDepot.getProdepQteMini());
                     var19.setStk_qte_maxi(this.produitsDepot.getProdepQteMaxi());
                     this.listDocument.add(var19);
                  }
               }
            }
         }

         this.utilInitHibernate.closeSession();
      }

   }

   public void rechercheSyntheseGenerique(String var1, String var2, String var3, String var4, String var5) throws HibernateException, NamingException, ParseException {
      Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "CalculMouvementStock");
      new FamillesProduitsAchats();
      new FamillesProduitsAchatsDao(this.baseLog, this.utilInitHibernate);
      UtilNombre var9 = new UtilNombre();
      UtilDate var10 = new UtilDate();
      new CalculStock();
      CalculStock var11 = new CalculStock();
      var11.setutilInitHibernate(this.utilInitHibernate);
      var11.setBaseLog(this.baseLog);
      var11.setStructureLog(this.structureLog);
      this.listDocument = new ArrayList();
      this.var_currentValue = 0;
      this.depot_encours = this.depot;
      this.produit_encours = "Chargement des produits generiques...";
      this.date_ante = this.filtreDateDebut;
      new ArrayList();
      ProduitsVtesDao var13 = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
      ProduitsDepotDao var14 = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
      List var12 = var13.verifProduitsGenerique(this.produitDebut, var6);
      if (var12.size() != 0) {
         for(int var15 = 0; var15 < var12.size(); ++var15) {
            if (var15 != 0) {
               double var16 = (double)var12.size();
               double var18 = var9.myRound(var16 / (double)var15, 4);
               double var20 = var9.myRound(100.0D / var18, 2);
               this.var_currentValue = (int)var20;
            }

            new Produits();
            Produits var26 = (Produits)var12.get(var15);
            this.depot_encours = this.depot;
            this.produit_encours = var26.getProCode() + " " + var26.getProLibClient();
            this.lesProduits = new ArrayList();
            this.lesProduits = var13.chargerLesProduitsVentesByGenerique(var26.getProCode(), var6);
            if (this.lesProduits.size() != 0) {
               for(int var17 = 0; var17 < this.lesProduits.size(); ++var17) {
                  this.produits = (Produits)this.lesProduits.get(var17);
                  Date var27 = null;
                  String var19 = "";
                  if (this.depot != null && !this.depot.isEmpty() && this.depot.contains(":")) {
                     String[] var29 = this.depot.split(":");
                     var19 = var29[0];
                     var27 = this.chargeMvtsProduitDepot(this.lesProduits, var19, var27, var11, var26, var6);
                  } else {
                     new ArrayList();
                     List var28 = var14.selectProdDepByprod(this.produits, var6);
                     if (var28.size() != 0) {
                        for(int var21 = 0; var21 < var28.size(); ++var21) {
                           var27 = this.chargeMvtsProduitDepot(this.lesProduits, ((ProduitsDepot)var28.get(var21)).getDepot().getDpoCode(), var27, var11, var26, var6);
                        }
                     }
                  }

                  Date var24 = var10.stringToDateSQL(var10.dateToStringSQLLight(this.filtreDateDebut) + " 00:00:00");
                  Date var25 = var10.stringToDateSQL(var10.dateToStringSQLLight(this.filtreDateFin) + " 23:59:59");
                  String var22 = var10.dateToStringSQL(var24);
                  String var23 = var10.dateToStringSQL(var25);
                  this.chargeCmdFournisseur(var27, var9, var22, var23, var26, var6);
                  this.chargeFactureClient(var9, var22, var23, var26, var6);
                  this.chargeAvoirClient(var9, var22, var23, var26, var6);
               }
            }
         }

         this.calculTotauxSynthese();
      }

      this.utilInitHibernate.closeSession();
   }

   public void rechercheSyntheseFamille(String var1, String var2, String var3, String var4, String var5) throws HibernateException, NamingException, ParseException {
      Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "CalculMouvementStock");
      new FamillesProduitsAchats();
      new FamillesProduitsAchatsDao(this.baseLog, this.utilInitHibernate);
      UtilNombre var9 = new UtilNombre();
      UtilDate var10 = new UtilDate();
      new CalculStock();
      CalculStock var11 = new CalculStock();
      var11.setutilInitHibernate(this.utilInitHibernate);
      var11.setBaseLog(this.baseLog);
      var11.setStructureLog(this.structureLog);
      this.listDocument = new ArrayList();
      this.var_currentValue = 0;
      this.depot_encours = this.depot;
      this.produit_encours = "Chargement des familles...";
      this.date_ante = this.filtreDateDebut;
      Produits var12 = new Produits();
      ProduitsDepotDao var13 = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      FamillesProduitsAchatsDao var8 = new FamillesProduitsAchatsDao(this.baseLog, this.utilInitHibernate);
      List var14 = var8.selectAllFamillByCode(this.exoSelectionne.getExeachId(), this.famille, var6);
      if (var14.size() != 0) {
         for(int var15 = 0; var15 < var14.size(); ++var15) {
            if (var15 != 0) {
               double var16 = (double)var14.size();
               double var18 = var9.myRound(var16 / (double)var15, 4);
               double var20 = var9.myRound(100.0D / var18, 2);
               this.var_currentValue = (int)var20;
            }

            FamillesProduitsAchats var7 = (FamillesProduitsAchats)var14.get(var15);
            this.depot_encours = this.depot;
            this.produit_encours = var7.getFamachCode() + " " + var7.getFamachLibelleFr();
            this.lesProduits = new ArrayList();
            this.lesProduits = this.produitsAchsDao.chargerLesProduitsAchatsByFamille(var7.getFamachCode(), var6);
            if (this.lesProduits.size() != 0) {
               for(int var24 = 0; var24 < this.lesProduits.size(); ++var24) {
                  this.produits = (Produits)this.lesProduits.get(var24);
                  Date var17 = null;
                  String var25 = "";
                  if (this.depot != null && !this.depot.isEmpty() && this.depot.contains(":")) {
                     String[] var26 = this.depot.split(":");
                     var25 = var26[0];
                     var17 = this.chargeMvtsProduitDepot(this.lesProduits, var25, var17, var11, var12, var6);
                  } else {
                     new ArrayList();
                     List var19 = var13.selectProdDepByprod(this.produits, var6);
                     if (var19.size() != 0) {
                        for(int var28 = 0; var28 < var19.size(); ++var28) {
                           var17 = this.chargeMvtsProduitDepot(this.lesProduits, ((ProduitsDepot)var19.get(var28)).getDepot().getDpoCode(), var17, var11, var12, var6);
                        }
                     }
                  }

                  Date var27 = var10.stringToDateSQL(var10.dateToStringSQLLight(this.filtreDateDebut) + " 00:00:00");
                  Date var23 = var10.stringToDateSQL(var10.dateToStringSQLLight(this.filtreDateFin) + " 23:59:59");
                  String var21 = var10.dateToStringSQL(var27);
                  String var22 = var10.dateToStringSQL(var23);
                  this.chargeCmdFournisseur(var17, var9, var21, var22, var12, var6);
                  this.chargeFactureClient(var9, var21, var22, var12, var6);
                  this.chargeAvoirClient(var9, var21, var22, var12, var6);
               }
            }
         }

         this.calculTotauxSynthese();
      }

      this.utilInitHibernate.closeSession();
   }

   public void rechercheSyntheseProduit(String var1, String var2, String var3, String var4, String var5) throws HibernateException, NamingException, ParseException {
      Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "CalculMouvementStock");
      UtilNombre var7 = new UtilNombre();
      UtilDate var8 = new UtilDate();
      new CalculStock();
      CalculStock var9 = new CalculStock();
      var9.setutilInitHibernate(this.utilInitHibernate);
      var9.setBaseLog(this.baseLog);
      var9.setStructureLog(this.structureLog);
      this.listDocument = new ArrayList();
      this.var_currentValue = 0;
      this.depot_encours = this.depot;
      this.produit_encours = "Chargement des produits...";
      this.date_ante = this.filtreDateDebut;
      Produits var10 = new Produits();
      ProduitsDepotDao var11 = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
      this.lesProduits = new ArrayList();
      this.lesProduits = this.produitsAchsDao.selectFindProduit(this.produitDebut, this.produitFin, this.famille, var6);
      if (this.lesProduits.size() != 0) {
         for(int var12 = 0; var12 < this.lesProduits.size(); ++var12) {
            if (var12 != 0) {
               double var13 = (double)this.lesProduits.size();
               double var15 = var7.myRound(var13 / (double)var12, 4);
               double var17 = var7.myRound(100.0D / var15, 2);
               this.var_currentValue = (int)var17;
            }

            this.produits = (Produits)this.lesProduits.get(var12);
            this.depot_encours = this.depot;
            this.produit_encours = this.produits.getProCode() + " " + this.produits.getProLibClient();
            Date var19 = null;
            String var14 = "";
            if (this.depot != null && !this.depot.isEmpty() && this.depot.contains(":")) {
               String[] var21 = this.depot.split(":");
               var14 = var21[0];
               var19 = this.chargeMvtsProduitDepot(this.lesProduits, var14, var19, var9, var10, var6);
            } else {
               new ArrayList();
               List var20 = var11.selectProdDepByprod(this.produits, var6);
               if (var20.size() != 0) {
                  for(int var16 = 0; var16 < var20.size(); ++var16) {
                     var19 = this.chargeMvtsProduitDepot(this.lesProduits, ((ProduitsDepot)var20.get(var16)).getDepot().getDpoCode(), var19, var9, var10, var6);
                  }
               }
            }

            Date var22 = var8.stringToDateSQL(var8.dateToStringSQLLight(this.filtreDateDebut) + " 00:00:00");
            Date var23 = var8.stringToDateSQL(var8.dateToStringSQLLight(this.filtreDateFin) + " 23:59:59");
            String var24 = var8.dateToStringSQL(var22);
            String var18 = var8.dateToStringSQL(var23);
            this.chargeCmdFournisseur(var19, var7, var24, var18, var10, var6);
            this.chargeFactureClient(var7, var24, var18, var10, var6);
            this.chargeAvoirClient(var7, var24, var18, var10, var6);
         }

         this.calculTotauxSynthese();
      }

      this.utilInitHibernate.closeSession();
   }

   public Date chargeMvtsProduitDepot(List var1, String var2, Date var3, CalculStock var4, Produits var5, Session var6) throws HibernateException, NamingException, ParseException {
      ArrayList var7 = new ArrayList();
      new InventaireLigne();
      String var9 = this.utilDate.dateToStringSQLLight(this.filtreDateDebut) + " 00:00:00";
      String var10 = this.utilDate.dateToStringSQLLight(this.filtreDateFin) + " 23:59:59";
      InventaireLigne var8 = var4.localisationInventaire(this.serie, var9, var10, this.produits.getProCode(), var2, 0L, this.baseLog, var6);
      if (var8 == null) {
         var3 = this.utilDate.stringToDateSQL("2000-01-01 00:00:00");
      } else {
         var3 = var8.getInventaireEntete().getInvDate();
         Stock var11 = new Stock();
         var11.setStk_code_produit(var8.getInvligCode());
         var11.setStkLibelle(var8.getInvligLibelle());
         var11.setStkFamille(var8.getInvligFamille());
         var11.setStk_date_mvt(var8.getInventaireEntete().getInvDate());
         var11.setStk_qte_in(var8.getInvligQteUtil());
         var11.setStk_lib_type("Inventaire");
         var11.setStk_type(30);
         this.listDocument.add(var11);
      }

      var7.clear();
      String var19 = "";
      if (this.produits.getProVteNat() != null && !this.produits.getProVteNat().isEmpty()) {
         var19 = this.produits.getProVteNat();
      } else {
         var19 = this.produits.getProAchNat();
      }

      List var18 = var4.chargerMouvements(1, this.serie, var19, this.produits.getProCode(), var5.getProCode(), var2, 0L, this.activite, this.service, var3, this.filtreDateFin, false, false, true, true, false, false, false, true, true, true, true, false, false, true, true, false, false, false, true, false, true, this.optionVentes.getGestionStockBc(), this.baseLog, this.structureLog, var6);
      if (var18.size() != 0) {
         double var12 = 0.0D;
         new Stock();

         Stock var14;
         for(int var15 = 0; var15 < var18.size(); ++var15) {
            var14 = (Stock)var18.get(var15);
            if (var14.getStk_pa() != 0.0D) {
               var12 = var14.getStk_pa();
               break;
            }
         }

         double var20 = 0.0D;

         for(int var17 = 0; var17 < var18.size(); ++var17) {
            var14 = (Stock)var18.get(var17);
            if (var14.getStk_pa() != 0.0D) {
               var20 = var14.getStk_pa();
            } else {
               var14.setStk_pa(var20);
            }

            if (var14.getStk_pa() == 0.0D) {
               var14.setStk_pa(var12);
            }

            var14.setStk_qte_progress((float)var1.size());
            this.listDocument.add(var14);
         }
      }

      return var3;
   }

   public void chargeCmdFournisseur(Date var1, UtilNombre var2, String var3, String var4, Produits var5, Session var6) throws ParseException {
      new ArrayList();
      CommandeLigneAchatsDao var8 = new CommandeLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      List var7 = var8.chargerLesMvts(this.serie, this.produits.getProCode(), this.activite, this.service, this.depot, var3, var4, var6);
      if (var7.size() != 0) {
         Object[] var9 = null;

         for(int var10 = 0; var10 < var7.size(); ++var10) {
            Stock var11 = new Stock();
            var9 = (Object[])((Object[])var7.get(var10));
            this.calculeLigneAchat(var9);
            var11.setStk_lib_type("F.Commande");
            var11.setStk_id(this.idDoc);
            var11.setStk_type(12);
            if (this.etat == 0) {
               var11.setStk_etat("En cours");
            } else if (this.etat == 1) {
               var11.setStk_etat("Validé");
            } else if (this.etat == 2) {
               var11.setStk_etat("Gelé");
            } else if (this.etat == 3) {
               var11.setStk_etat("Annulé");
            } else if (this.etat == 4) {
               var11.setStk_etat("Trf partiel");
            } else if (this.etat == 5) {
               var11.setStk_etat("Trf total");
            } else {
               var11.setStk_etat("????");
            }

            var11.setStk_code_depot("");
            var11.setStk_code_produit(this.code);
            var11.setStk_code_generique("");
            var11.setStkLibelle(this.libelle);
            if (this.nomFamille != null && !this.nomFamille.isEmpty()) {
               if (this.nomFamille.contains(":")) {
                  String[] var12 = this.nomFamille.split(":");
                  var11.setStkFamille(var12[0]);
               } else {
                  var11.setStkFamille(this.nomFamille);
               }
            } else {
               var11.setStkFamille("");
            }

            var11.setStk_numero(this.num);
            if (this.nomDivers != null && !this.nomDivers.isEmpty()) {
               var11.setStk_divers("FD");
               var11.setStk_tiers(this.nomDivers);
            } else {
               var11.setStk_divers("FO");
               var11.setStk_tiers(this.nomTiers);
            }

            var11.setStk_activite("");
            var11.setStk_dossier("");
            var11.setStk_date_mvt(this.date);
            var11.setStk_pa(0.0D);
            var11.setStkDevise(this.devise);
            var11.setStk_format_devise(var2.formatDevise(var11.getStkDevise()));
            var11.setStk_devise(0.0F);
            var11.setStk_pv(0.0D);
            var11.setStk_pump(this.pumpLig);
            var11.setStk_coefPr(this.coefPr);
            var11.setStk_qte_in(this.qteUtilLig);
            var11.setStk_qte_out(0.0F);
            this.listDocument.add(var11);
         }
      }

   }

   public void chargeFactureClient(UtilNombre var1, String var2, String var3, Produits var4, Session var5) throws ParseException {
      new ArrayList();
      FactureLigneVentesDao var7 = new FactureLigneVentesDao(this.baseLog, this.utilInitHibernate);
      List var6 = var7.chargerLesMvts(this.serie, this.produits.getProCode(), "", 0L, this.activite, this.service, var2, var3, "", var5);
      if (var6.size() != 0) {
         Object[] var8 = null;

         for(int var9 = 0; var9 < var6.size(); ++var9) {
            var8 = (Object[])((Object[])var6.get(var9));
            Stock var10 = new Stock();
            this.calculeLigneVente(var8);
            var10.setStk_lib_type("C.Facture Directe");
            var10.setStk_id(this.idDoc);
            var10.setStk_type(25);
            if (this.etat == 0) {
               var10.setStk_etat("En cours");
            } else if (this.etat == 1) {
               var10.setStk_etat("Validé");
            } else if (this.etat == 2) {
               var10.setStk_etat("Gelé");
            } else if (this.etat == 3) {
               var10.setStk_etat("Annulé");
            } else if (this.etat == 4) {
               var10.setStk_etat("Trf partiel");
            } else if (this.etat == 5) {
               var10.setStk_etat("Trf total");
            } else {
               var10.setStk_etat("????");
            }

            var10.setFactureDirecte(0);
            var10.setStk_code_depot("");
            var10.setStk_code_produit(this.code);
            var10.setStk_code_generique("");
            var10.setStkLibelle(this.libelle);
            if (this.nomFamille != null && !this.nomFamille.isEmpty()) {
               if (this.nomFamille.contains(":")) {
                  String[] var11 = this.nomFamille.split(":");
                  var10.setStkFamille(var11[0]);
               } else {
                  var10.setStkFamille(this.nomFamille);
               }
            } else {
               var10.setStkFamille("");
            }

            var10.setStk_numero(this.num);
            var10.setStk_equipe(this.idEquipe);
            if (this.nomDivers != null && !this.nomDivers.isEmpty()) {
               var10.setStk_divers("CD");
               var10.setStk_tiers(this.nomDivers);
            } else {
               var10.setStk_divers("CL");
               var10.setStk_tiers(this.nomTiers);
            }

            var10.setStk_activite("");
            var10.setStk_dossier("");
            var10.setStk_date_mvt(this.date);
            var10.setStk_pa(0.0D);
            var10.setStkDevise(this.devise);
            var10.setStk_format_devise(var1.formatDevise(var10.getStkDevise()));
            var10.setStk_devise(1.0F);
            if (this.qteUtilLig != this.qteLig) {
               double var13 = var1.myRoundDevise(this.ptLig / (double)this.qteUtilLig, var10.getStkDevise());
               var10.setStk_pv(var13);
            } else {
               var10.setStk_pv(this.puLig);
            }

            var10.setStk_pump(this.pumpLig);
            var10.setStk_qte_in(0.0F);
            var10.setStk_qte_out(this.qteUtilLig);
            this.listDocument.add(var10);
         }
      }

   }

   public void chargeAvoirClient(UtilNombre var1, String var2, String var3, Produits var4, Session var5) throws ParseException {
      new ArrayList();
      AvoirLigneVentesDao var7 = new AvoirLigneVentesDao(this.baseLog, this.utilInitHibernate);
      List var6 = var7.chargerLesMvts(this.serie, this.produits.getProCode(), 0L, this.activite, this.service, var2, var3, "", var5);
      if (var6.size() != 0) {
         Object[] var8 = null;

         for(int var9 = 0; var9 < var6.size(); ++var9) {
            Stock var10 = new Stock();
            var8 = (Object[])((Object[])var6.get(var9));
            this.calculeLigneVente(var8);
            var10.setStk_lib_type("C.Avoir");
            var10.setStk_id(this.idDoc);
            var10.setStk_type(26);
            if (this.etat == 0) {
               var10.setStk_etat("En cours");
            } else if (this.etat == 1) {
               var10.setStk_etat("Validé");
            } else if (this.etat == 2) {
               var10.setStk_etat("Gelé");
            } else if (this.etat == 3) {
               var10.setStk_etat("Annulé");
            } else if (this.etat == 4) {
               var10.setStk_etat("Trf partiel");
            } else if (this.etat == 5) {
               var10.setStk_etat("Trf total");
            } else {
               var10.setStk_etat("????");
            }

            var10.setStk_code_depot("");
            var10.setStk_code_produit(this.code);
            var10.setStk_code_generique("");
            var10.setStkLibelle(this.libelle);
            if (this.nomFamille != null && !this.nomFamille.isEmpty()) {
               if (this.nomFamille.contains(":")) {
                  String[] var11 = this.nomFamille.split(":");
                  var10.setStkFamille(var11[0]);
               } else {
                  var10.setStkFamille(this.nomFamille);
               }
            } else {
               var10.setStkFamille("");
            }

            var10.setStk_numero(this.num);
            var10.setStk_equipe(this.idEquipe);
            if (this.nomDivers != null && !this.nomDivers.isEmpty()) {
               var10.setStk_divers("CD");
               var10.setStk_tiers(this.nomDivers);
            } else {
               var10.setStk_divers("CL");
               var10.setStk_tiers(this.nomTiers);
            }

            var10.setStk_activite("");
            var10.setStk_dossier("");
            var10.setStk_date_mvt(this.date);
            var10.setStk_pa(0.0D);
            var10.setStkDevise(this.devise);
            var10.setStk_format_devise(var1.formatDevise(var10.getStkDevise()));
            var10.setStk_devise(1.0F);
            if (this.qteUtilLig != this.qteLig) {
               double var13 = var1.myRoundDevise(this.ptLig / (double)this.qteUtilLig, var10.getStkDevise());
               var10.setStk_pv(var13);
            } else {
               var10.setStk_pv(this.puLig);
            }

            var10.setStk_pump(this.pumpLig);
            var10.setStk_qte_in(this.qteUtilLig);
            var10.setStk_qte_out(0.0F);
            this.listDocument.add(var10);
         }
      }

   }

   public void calculeLigneAchat(Object[] var1) throws ParseException {
      if (var1[0] != null) {
         this.etat = Integer.parseInt(var1[0].toString());
      } else {
         this.etat = 0;
      }

      if (var1[1] != null) {
         this.num = var1[1].toString();
      } else {
         this.num = "";
      }

      if (var1[2] != null) {
         this.nomDivers = var1[2].toString();
      } else {
         this.nomDivers = "";
      }

      if (var1[3] != null) {
         this.nomTiers = var1[3].toString();
      } else {
         this.nomTiers = "";
      }

      if (var1[4] != null) {
         this.date = this.utilDate.stringToDateSQL(var1[4].toString());
      } else {
         this.date = null;
      }

      if (var1[5] != null) {
         this.devise = var1[5].toString();
      } else {
         this.devise = "";
      }

      if (var1[6] != null) {
         this.idDoc = Long.parseLong(var1[6].toString());
      } else {
         this.idDoc = 0L;
      }

      if (var1[7] != null) {
         this.nomDepot = var1[7].toString();
      } else {
         this.nomDepot = "";
      }

      if (var1[8] != null) {
         this.code = var1[8].toString();
      } else {
         this.code = "";
      }

      if (var1[9] != null) {
         this.nomFamille = var1[9].toString();
      } else {
         this.nomFamille = "";
      }

      if (var1[10] != null) {
         this.libelle = var1[10].toString();
      } else {
         this.libelle = "";
      }

      if (var1[11] != null) {
         this.qteLig = Float.parseFloat(var1[11].toString());
      } else {
         this.qteLig = 0.0F;
      }

      if (var1[12] != null) {
         this.qteUtilLig = Float.parseFloat(var1[12].toString());
      } else {
         this.qteUtilLig = 0.0F;
      }

      if (var1[13] != null) {
         this.puLig = Double.parseDouble(var1[13].toString());
      } else {
         this.puLig = 0.0D;
      }

      if (var1[14] != null) {
         this.ptLig = Double.parseDouble(var1[14].toString());
      } else {
         this.ptLig = 0.0D;
      }

      if (var1[15] != null) {
         this.prLig = Double.parseDouble(var1[15].toString());
      } else {
         this.prLig = 0.0D;
      }

      if (var1[16] != null) {
         this.pumpLig = Double.parseDouble(var1[16].toString());
      } else {
         this.pumpLig = 0.0D;
      }

      if (var1[17] != null) {
         this.poidsBrut = Float.parseFloat(var1[17].toString());
      } else {
         this.poidsBrut = 0.0F;
      }

      if (var1.length >= 19) {
         if (var1[18] != null) {
            this.dossier = var1[18].toString();
         } else {
            this.dossier = "";
         }

         if (var1[19] != null) {
            this.coefDevise = Float.parseFloat(var1[19].toString());
         } else {
            this.coefDevise = 0.0F;
         }

         if (var1[20] != null) {
            this.coefPr = Float.parseFloat(var1[20].toString());
         } else {
            this.coefPr = 0.0F;
         }

         if (var1[21] != null) {
            this.prKgrLig = (double)Float.parseFloat(var1[21].toString());
         } else {
            this.prKgrLig = 0.0D;
         }
      }

   }

   public void calculeLigneVente(Object[] var1) throws ParseException {
      if (var1[0] != null) {
         this.etat = Integer.parseInt(var1[0].toString());
      } else {
         this.etat = 0;
      }

      if (var1[1] != null) {
         this.num = var1[1].toString();
      } else {
         this.num = "";
      }

      if (var1[2] != null) {
         this.idEquipe = Long.parseLong(var1[2].toString());
      } else {
         this.idEquipe = 0L;
      }

      if (var1[3] != null) {
         this.nomDivers = var1[3].toString();
      } else {
         this.nomDivers = "";
      }

      if (var1[4] != null) {
         this.nomTiers = var1[4].toString();
      } else {
         this.nomTiers = "";
      }

      if (var1[5] != null) {
         this.date = this.utilDate.stringToDateSQL(var1[5].toString());
      } else {
         this.date = null;
      }

      if (var1[6] != null) {
         this.devise = var1[6].toString();
      } else {
         this.devise = "";
      }

      if (var1[7] != null) {
         this.idDoc = Long.parseLong(var1[7].toString());
      } else {
         this.idDoc = 0L;
      }

      if (var1[8] != null) {
         this.nomDepot = var1[8].toString();
      } else {
         this.nomDepot = "";
      }

      if (var1[9] != null) {
         this.code = var1[9].toString();
      } else {
         this.code = "";
      }

      if (var1[10] != null) {
         this.nomFamille = var1[10].toString();
      } else {
         this.nomFamille = "";
      }

      if (var1[11] != null) {
         this.libelle = var1[11].toString();
      } else {
         this.libelle = "";
      }

      if (var1[12] != null) {
         this.qteLig = Float.parseFloat(var1[12].toString());
      } else {
         this.qteLig = 0.0F;
      }

      if (var1[13] != null) {
         this.qteUtilLig = Float.parseFloat(var1[13].toString());
      } else {
         this.qteUtilLig = 0.0F;
      }

      if (var1[14] != null) {
         this.puLig = Double.parseDouble(var1[14].toString());
      } else {
         this.puLig = 0.0D;
      }

      if (var1[15] != null) {
         this.ptLig = Double.parseDouble(var1[15].toString());
      } else {
         this.ptLig = 0.0D;
      }

      if (var1[16] != null) {
         this.pumpLig = Double.parseDouble(var1[16].toString());
      } else {
         this.pumpLig = 0.0D;
      }

      if (var1[17] != null) {
         this.poidsBrut = Float.parseFloat(var1[17].toString());
      } else {
         this.poidsBrut = 0.0F;
      }

   }

   public void calculTotauxSynthese() {
      float var1 = 0.0F;
      float var2 = 0.0F;
      double var3 = 0.0D;
      float var5 = 0.0F;
      float var6 = 0.0F;
      double var7 = 0.0D;
      double var9 = 0.0D;
      new Stock();

      for(int var12 = 0; var12 < this.listDocument.size(); ++var12) {
         Stock var11 = (Stock)this.listDocument.get(var12);
         if (var11.getStk_type() == 30 || var11.getStk_type() == 31 || var11.getStk_type() == 32 || var11.getStk_type() == 33 || var11.getStk_type() == 34 || var11.getStk_type() == 13 || var11.getStk_type() == 14 || var11.getStk_type() == 23 || var11.getStk_type() == 24 || var11.getStk_type() == 25 && var11.getFactureDirecte() == 1 || var11.getStk_type() == 28) {
            var1 += var11.getStk_qte_in() - var11.getStk_qte_out();
         }

         if (var11.getStk_type() == 25 && var11.getFactureDirecte() == 0 || var11.getStk_type() == 26) {
            float var13 = var11.getStk_qte_out() - var11.getStk_qte_in();
            var2 += var13;
            var3 += (double)var13 * var11.getStk_pump();
            var7 += (double)var13 * var11.getStk_pv();
         }

         if (var11.getStk_type() == 12) {
            var5 += var11.getStk_qte_in();
         }

         if (var11.getStk_type() == 13) {
            var6 += var11.getStk_qte_in();
         }
      }

      var9 = var7 - var3;
      this.utilPrint.setM30DteDeb("" + var1);
      this.utilPrint.setM30DteFin("" + var2);
      this.utilPrint.setM60DteDeb("" + var5);
      this.utilPrint.setM60DteFin("" + var6);
      this.utilPrint.setM90DteDeb("" + var7);
      this.utilPrint.setM90DteFin("" + var9);
      this.utilPrint.setM120DteDeb("" + var3);
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

   public OptionStocks getOptionStocks() {
      return this.optionStocks;
   }

   public void setOptionStocks(OptionStocks var1) {
      this.optionStocks = var1;
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

   public String getEtatRec() {
      return this.etatRec;
   }

   public void setEtatRec(String var1) {
      this.etatRec = var1;
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

   public boolean isVar_bin() {
      return this.var_bin;
   }

   public void setVar_bin(boolean var1) {
      this.var_bin = var1;
   }

   public boolean isVar_bl() {
      return this.var_bl;
   }

   public void setVar_bl(boolean var1) {
      this.var_bl = var1;
   }

   public boolean isVar_bout() {
      return this.var_bout;
   }

   public void setVar_bout(boolean var1) {
      this.var_bout = var1;
   }

   public boolean isVar_br() {
      return this.var_br;
   }

   public void setVar_br(boolean var1) {
      this.var_br = var1;
   }

   public boolean isVar_ces() {
      return this.var_ces;
   }

   public void setVar_ces(boolean var1) {
      this.var_ces = var1;
   }

   public boolean isVar_inv() {
      return this.var_inv;
   }

   public void setVar_inv(boolean var1) {
      this.var_inv = var1;
   }

   public boolean isVar_rec() {
      return this.var_rec;
   }

   public void setVar_rec(boolean var1) {
      this.var_rec = var1;
   }

   public boolean isVar_sav() {
      return this.var_sav;
   }

   public void setVar_sav(boolean var1) {
      this.var_sav = var1;
   }

   public boolean isVar_prod() {
      return this.var_prod;
   }

   public void setVar_prod(boolean var1) {
      this.var_prod = var1;
   }

   public boolean isTestafficheDocument() {
      return this.testafficheDocument;
   }

   public void setTestafficheDocument(boolean var1) {
      this.testafficheDocument = var1;
   }

   public int getVar_currentValue() {
      return this.var_currentValue;
   }

   public void setVar_currentValue(int var1) {
      this.var_currentValue = var1;
   }

   public boolean isVar_showBarProg() {
      return this.var_showBarProg;
   }

   public void setVar_showBarProg(boolean var1) {
      this.var_showBarProg = var1;
   }

   public String getDepot_encours() {
      return this.depot_encours;
   }

   public void setDepot_encours(String var1) {
      this.depot_encours = var1;
   }

   public String getProduit_encours() {
      return this.produit_encours;
   }

   public void setProduit_encours(String var1) {
      this.produit_encours = var1;
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

   public OptionVentes getOptionVentes() {
      return this.optionVentes;
   }

   public void setOptionVentes(OptionVentes var1) {
      this.optionVentes = var1;
   }

   public String getFormat() {
      return this.format;
   }

   public void setFormat(String var1) {
      this.format = var1;
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

   public boolean isDecoupageActivite() {
      return this.decoupageActivite;
   }

   public void setDecoupageActivite(boolean var1) {
      this.decoupageActivite = var1;
   }

   public List getLaColonne1Items() {
      return this.laColonne1Items;
   }

   public void setLaColonne1Items(List var1) {
      this.laColonne1Items = var1;
   }

   public List getLaColonne2Items() {
      return this.laColonne2Items;
   }

   public void setLaColonne2Items(List var1) {
      this.laColonne2Items = var1;
   }

   public List getLaColonne3Items() {
      return this.laColonne3Items;
   }

   public void setLaColonne3Items(List var1) {
      this.laColonne3Items = var1;
   }

   public String getVar_colonne1() {
      return this.var_colonne1;
   }

   public void setVar_colonne1(String var1) {
      this.var_colonne1 = var1;
   }

   public String getVar_colonne2() {
      return this.var_colonne2;
   }

   public void setVar_colonne2(String var1) {
      this.var_colonne2 = var1;
   }

   public String getVar_colonne3() {
      return this.var_colonne3;
   }

   public void setVar_colonne3(String var1) {
      this.var_colonne3 = var1;
   }

   public int getStocknull() {
      return this.stocknull;
   }

   public void setStocknull(int var1) {
      this.stocknull = var1;
   }

   public List getLesModelesAutorises() {
      return this.lesModelesAutorises;
   }

   public void setLesModelesAutorises(List var1) {
      this.lesModelesAutorises = var1;
   }

   public int getStockQteVal() {
      return this.stockQteVal;
   }

   public void setStockQteVal(int var1) {
      this.stockQteVal = var1;
   }

   public int getStockAnterieur() {
      return this.stockAnterieur;
   }

   public void setStockAnterieur(int var1) {
      this.stockAnterieur = var1;
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

   public boolean isVar_bc() {
      return this.var_bc;
   }

   public void setVar_bc(boolean var1) {
      this.var_bc = var1;
   }

   public boolean isVar_fac() {
      return this.var_fac;
   }

   public void setVar_fac(boolean var1) {
      this.var_fac = var1;
   }
}
