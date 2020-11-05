package com.epegase.forms.medical;

import com.epegase.systeme.classe.ConsultationActes;
import com.epegase.systeme.classe.ConsultationEnteteGene;
import com.epegase.systeme.classe.ConsultationInfirmerie;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.HospitalisationActes;
import com.epegase.systeme.classe.HospitalisationLabo;
import com.epegase.systeme.classe.HospitalisationMedi;
import com.epegase.systeme.classe.HospitalisationPrest;
import com.epegase.systeme.classe.HospitalisationSejour;
import com.epegase.systeme.classe.LaboratoireEntete;
import com.epegase.systeme.classe.LaboratoireLigne;
import com.epegase.systeme.classe.PharmacieEntete;
import com.epegase.systeme.classe.PharmacieLigne;
import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.RapportMedical;
import com.epegase.systeme.classe.Reglements;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.DocumentMedical;
import com.epegase.systeme.control.EtatDocument;
import com.epegase.systeme.control.Statmedical;
import com.epegase.systeme.dao.ConsultationActesDao;
import com.epegase.systeme.dao.ConsultationEnteteGeneDao;
import com.epegase.systeme.dao.ConsultationInfirmerieDao;
import com.epegase.systeme.dao.HospitalisationActesDao;
import com.epegase.systeme.dao.HospitalisationLaboDao;
import com.epegase.systeme.dao.HospitalisationMediDao;
import com.epegase.systeme.dao.HospitalisationPrestDao;
import com.epegase.systeme.dao.HospitalisationSejourDao;
import com.epegase.systeme.dao.LaboratoireEnteteDao;
import com.epegase.systeme.dao.LaboratoireLigneDao;
import com.epegase.systeme.dao.PharmacieEnteteDao;
import com.epegase.systeme.dao.PharmacieLigneDao;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
import com.epegase.systeme.dao.ProduitsVtesDao;
import com.epegase.systeme.dao.RapportMedicalDao;
import com.epegase.systeme.dao.ReglementsDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.OptionMedical;
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

public class FormImpressionMedicales implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private ExercicesVentes exoSelectionne;
   private OptionMedical optionMedical;
   private UtilDate utilDate;
   private List lesRepImpression = new ArrayList();
   private transient DataModel dataModelImpgen = new ListDataModel();
   private List lesFichImpression = new ArrayList();
   private transient DataModel dataModelImpgenFichier = new ListDataModel();
   private boolean testafficheLigne = false;
   private boolean testafficheDocument = false;
   private UsersChronoDao usersChronoDao;
   private int nature;
   private String nomRepertoire;
   private String nomEtat = "";
   private List listDocument;
   private String periode;
   private List mesPeriodesItems = new ArrayList();
   private List mesServicesItems;
   private List mesMedecinsItems;
   private Date filtreDateDebut;
   private Date filtreDateFin;
   private String nomTiers;
   private long idTiers = 0L;
   private String nomSigle;
   private String nomDestinataire;
   private String laboratoire;
   private String pharmacie;
   private String service = "100";
   private String produitDebut;
   private String produitFin;
   private String parc;
   private String activite;
   private String dossier;
   private String site;
   private String serie = "100";
   private String etat = "100";
   private int typeTiers = 100;
   private String categorie;
   private String commercial;
   private String responsable;
   private String createur;
   private String famille;
   private String depot;
   private String var_entete;
   private String var_filtre;
   private String var_requete;
   private String var_requete_hql;
   private String var_requete_directe;
   private long medecin;
   private List mesSeriesItems = new ArrayList();
   private List mesEtatsItems = new ArrayList();
   private boolean calculFiltre = false;
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
   private boolean showModalPanelDestinataire;
   private transient DataModel datamodelDestinataire = new ListDataModel();
   private PlansAnalytiques plansAnalytiques;
   private boolean showModalPanelProduits;
   private transient DataModel datamodelProduits = new ListDataModel();
   private Produits produits;
   private boolean var_produit_choix = false;
   private List lesStatMedical;
   private List lesSyntheses;
   private List lesModelesAutorises;
   private boolean infirmerie;

   public FormImpressionMedicales() {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.utilDate = new UtilDate();
      this.mesMedecinsItems = new ArrayList();
   }

   public void InstancesDaoUtilses() {
   }

   public void chargerLesRepImpMedical(Session var1) {
      this.lesRepImpression.clear();
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "patient";
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

      var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "produit";
      var3 = new File(var2);
      var4 = var3.list();
      if (var4 != null) {
         var4 = this.triAlphabetique(var4, var4.length);

         for(var5 = 0; var5 < var4.length; ++var5) {
            if (!var4[var5].equalsIgnoreCase(".svn") && !var4[var5].equalsIgnoreCase("index.html")) {
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
      this.infirmerie = this.rechercheModule(81500);
      if (this.infirmerie && this.usersLog.getUsrSite() != null && !this.usersLog.getUsrSite().isEmpty()) {
         this.site = this.usersLog.getUsrSite();
      }

   }

   public boolean rechercheModule(int var1) {
      boolean var2 = false;
      ArrayList var3 = new ArrayList();
      if (this.structureLog.getStrmod1() != null && !this.structureLog.getStrmod1().isEmpty()) {
         var3.add(this.structureLog.getStrmod1());
      }

      if (this.structureLog.getStrmod2() != null && !this.structureLog.getStrmod2().isEmpty()) {
         var3.add(this.structureLog.getStrmod2());
      }

      if (this.structureLog.getStrmod3() != null && !this.structureLog.getStrmod3().isEmpty()) {
         var3.add(this.structureLog.getStrmod3());
      }

      if (this.structureLog.getStrmod4() != null && !this.structureLog.getStrmod4().isEmpty()) {
         var3.add(this.structureLog.getStrmod4());
      }

      if (this.structureLog.getStrmod5() != null && !this.structureLog.getStrmod5().isEmpty()) {
         var3.add(this.structureLog.getStrmod5());
      }

      if (this.structureLog.getStrmod6() != null && !this.structureLog.getStrmod6().isEmpty()) {
         var3.add(this.structureLog.getStrmod6());
      }

      if (this.structureLog.getStrmod7() != null && !this.structureLog.getStrmod7().isEmpty()) {
         var3.add(this.structureLog.getStrmod7());
      }

      if (this.structureLog.getStrmod8() != null && !this.structureLog.getStrmod8().isEmpty()) {
         var3.add(this.structureLog.getStrmod8());
      }

      if (this.structureLog.getStrmod9() != null && !this.structureLog.getStrmod8().isEmpty()) {
         var3.add(this.structureLog.getStrmod9());
      }

      if (this.structureLog.getStrmod10() != null && !this.structureLog.getStrmod10().isEmpty()) {
         var3.add(this.structureLog.getStrmod10());
      }

      for(int var4 = 0; var4 < var3.size(); ++var4) {
         String var5 = "" + var1;
         if (var5.contentEquals((CharSequence)var3.get(var4))) {
            var2 = true;
         }
      }

      return var2;
   }

   public boolean calculeVisible(String var1, Session var2) {
      boolean var3 = false;
      int var4 = 0;
      if (var1 != null && !var1.isEmpty()) {
         if (var1.equals("CONVENTION")) {
            var4 = 1;
         } else {
            Object var5;
            if (var1.contains("CONSULTATIONGENE")) {
               var5 = var2.createQuery("SELECT COUNT(*) FROM ConsultationEnteteGene").uniqueResult();
               var4 = Integer.parseInt(var5.toString());
            } else if (var1.contains("DEVIS")) {
               var5 = var2.createQuery("SELECT COUNT(*) FROM DevisEnteteMedical").uniqueResult();
               var4 = Integer.parseInt(var5.toString());
            } else if (var1.contains("LABORATOIRE")) {
               var5 = var2.createQuery("SELECT COUNT(*) FROM LaboratoireEntete").uniqueResult();
               var4 = Integer.parseInt(var5.toString());
            } else if (var1.contains("PHARMACIE")) {
               var5 = var2.createQuery("SELECT COUNT(*) FROM PharmacieEntete").uniqueResult();
               var4 = Integer.parseInt(var5.toString());
            } else if (var1.contains("HOSPITALISATION")) {
               var5 = var2.createQuery("SELECT COUNT(*) FROM HospitalisationEntete").uniqueResult();
               var4 = Integer.parseInt(var5.toString());
            } else if (var1.contains("REFACTURATION")) {
               var5 = var2.createQuery("SELECT COUNT(*) FROM FactureEnteteMedical").uniqueResult();
               var4 = Integer.parseInt(var5.toString());
            } else if (!var1.contains("ACCUEIL")) {
               if (var1.contains("SYNTHESE")) {
                  var4 = 1;
               } else if (var1.contains("CONTROLE")) {
                  var4 = 1;
               }
            }
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

   public void recupererNomrep() throws HibernateException, NamingException {
      this.testafficheLigne = false;
      this.testafficheDocument = false;
      if (this.dataModelImpgen.isRowAvailable()) {
         this.nomRepertoire = (String)this.dataModelImpgen.getRowData();
         this.nomRepertoire = this.nomRepertoire.toLowerCase();
         this.nomEtat = "";
         if (this.nomRepertoire.contains("consultationgene")) {
            this.nature = 71;
         } else if (this.nomRepertoire.contains("consultationspe")) {
            this.nature = 72;
         } else if (this.nomRepertoire.contains("pharmacie")) {
            this.nature = 73;
         } else if (this.nomRepertoire.contains("laboratoire")) {
            this.nature = 74;
         } else if (this.nomRepertoire.contains("paillasse")) {
            this.nature = 75;
         } else if (this.nomRepertoire.contains("hospitalisation")) {
            this.nature = 76;
         } else if (this.nomRepertoire.contains("devis")) {
            this.nature = 77;
         } else if (this.nomRepertoire.contains("refacturation")) {
            this.nature = 78;
         } else {
            this.nature = 0;
         }

         if (this.nomRepertoire.contains("synthese")) {
            this.testafficheDocument = false;
            this.nature = 71;
         }

         this.lesFichImpression.clear();
         String var1 = null;
         if (this.nomRepertoire.contains("produit_")) {
            var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "produits" + File.separator + this.nomRepertoire;
            this.testafficheLigne = true;
         } else {
            var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "patient" + File.separator + this.nomRepertoire;
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
         this.etat = "1";
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
         this.filtreDateDebut = this.exoSelectionne.getExevteDateDebut();
         this.filtreDateFin = this.exoSelectionne.getExevteDateFin();
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
         String var2 = "(2,3)";
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
         this.idTiers = this.tiers.getTieid();
      } else {
         this.tiers = null;
         this.nomTiers = "";
         this.idTiers = 0L;
      }

      this.showModalPanelTiers = false;
   }

   public void annuleTiers() {
      this.tiers = null;
      this.nomTiers = "";
      this.idTiers = 0L;
      this.showModalPanelTiers = false;
   }

   public void rechercheDestinataire() throws HibernateException, NamingException {
      Object var1 = new ArrayList();
      if (this.nomDestinataire != null && !this.nomDestinataire.isEmpty()) {
         PlansAnalytiquesDao var2 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
         var1 = var2.selectAnal("7", this.nomDestinataire, "", this.nature, (Session)null);
         this.showModalPanelDestinataire = true;
      }

      this.datamodelDestinataire.setWrappedData(var1);
   }

   public void selectionligneDestinataire() throws JDOMException, IOException {
      if (this.datamodelDestinataire.isRowAvailable()) {
         this.plansAnalytiques = (PlansAnalytiques)this.datamodelDestinataire.getRowData();
      }

   }

   public void calculeDestinataire() throws JDOMException, IOException {
      if (this.plansAnalytiques == null) {
         this.selectionligneDestinataire();
      }

      if (this.plansAnalytiques != null) {
         this.nomDestinataire = this.plansAnalytiques.getAnaNomFr();
      } else {
         this.plansAnalytiques = null;
         this.nomDestinataire = "";
      }

      this.showModalPanelDestinataire = false;
   }

   public void annuleDestinataire() {
      this.plansAnalytiques = null;
      this.nomDestinataire = "";
      this.showModalPanelDestinataire = false;
   }

   public void rechercheProduitsDebut() throws HibernateException, NamingException {
      new ArrayList();
      if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
         ProduitsVtesDao var2 = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
         List var1 = var2.verifProduits(this.produitDebut, (Session)null);
         this.datamodelProduits.setWrappedData(var1);
         this.var_produit_choix = false;
         this.showModalPanelProduits = true;
      }

   }

   public void rechercheProduitsFin() throws HibernateException, NamingException {
      new ArrayList();
      if (this.produitFin != null && !this.produitFin.isEmpty()) {
         ProduitsVtesDao var2 = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
         List var1 = var2.verifProduits(this.produitFin, (Session)null);
         this.datamodelProduits.setWrappedData(var1);
         this.var_produit_choix = true;
         this.showModalPanelProduits = true;
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

   public void chargerPeriodes() throws ParseException {
      this.mesPeriodesItems.clear();
      this.mesPeriodesItems.add(new SelectItem(""));
      Date var1 = this.exoSelectionne.getExevteDateDebut();
      GregorianCalendar var2 = new GregorianCalendar();
      var2.setTime(var1);
      Date var3 = this.exoSelectionne.getExevteDateFin();
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
         this.lesStatMedical = new ArrayList();
         this.lesSyntheses = new ArrayList();
         this.calculeRequete();
         this.utilPrint.setRapport(this.nomEtat);
         if (this.nomRepertoire.contains("actes_")) {
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "produits" + File.separator + this.nomRepertoire + File.separator);
         } else {
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "patient" + File.separator + this.nomRepertoire + File.separator);
         }

         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "sous_rapport" + File.separator);
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
         if (this.nomEtat.equalsIgnoreCase("Synthese_consultation")) {
            this.utilPrint.setRequete("");
            var1 = new JRBeanCollectionDataSource(this.lesStatMedical);
            this.utilPrint.setjRBeanCollectionDataSource(var1);
         } else if (!this.nomRepertoire.equalsIgnoreCase("Synthese") && !this.nomRepertoire.equalsIgnoreCase("Controle")) {
            if (this.nomRepertoire.equalsIgnoreCase("Hospitalisation")) {
               this.utilPrint.setRequete("");
               var1 = new JRBeanCollectionDataSource(this.lesSyntheses);
               this.utilPrint.setjRBeanCollectionDataSource(var1);
            } else {
               this.utilPrint.setRequete(this.var_requete);
               ArrayList var3 = new ArrayList();
               JRBeanCollectionDataSource var2 = new JRBeanCollectionDataSource(var3);
               this.utilPrint.setjRBeanCollectionDataSource(var2);
            }
         } else {
            this.utilPrint.setRequete("");
            var1 = new JRBeanCollectionDataSource(this.lesSyntheses);
            this.utilPrint.setjRBeanCollectionDataSource(var1);
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
         this.utilPrint.setAnnexe1(this.utilDate.dateToStringSQL(this.filtreDateFin));
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
      this.var_requete_hql = "";
      this.var_requete_directe = "";
      String var1 = this.utilDate.dateToStringFr(this.filtreDateDebut);
      String var2 = var1.substring(6, 10) + "-" + var1.substring(3, 5) + "-" + var1.substring(0, 2) + " 00:00:00";
      String var3 = this.utilDate.dateToStringFr(this.filtreDateFin);
      String var4 = var3.substring(6, 10) + "-" + var3.substring(3, 5) + "-" + var3.substring(0, 2) + " 23:59:59";
      String var5 = this.utilDate.dateToStringFr(this.filtreDateDebut);
      String var6 = this.utilDate.dateToStringFr(this.filtreDateFin);
      if (this.nomRepertoire.equalsIgnoreCase("synthese")) {
         if (this.nomEtat.startsWith("Synthese_paiement")) {
            this.rechercheSynthesePaiementSql(var5, var6, var2, var4);
         } else {
            this.rechercheSyntheseSql(var5, var6, var2, var4);
         }
      } else if (this.nomRepertoire.equalsIgnoreCase("consultationGene")) {
         if (this.nomEtat.startsWith("Synthese_consultation")) {
            this.statInfirmerie(var5, var6, var2, var4);
         } else if (!this.nomEtat.startsWith("Vaccin_relance") && !this.nomEtat.startsWith("Vaccin_relance")) {
            this.rechercheConsultationGeneSql(var5, var6, var2, var4, (Session)null);
         }
      } else if (this.nomRepertoire.equalsIgnoreCase("consultationSpe")) {
         this.rechercheConsultationSpeSql(var5, var6, var2, var4, (Session)null);
      } else if (this.nomRepertoire.equalsIgnoreCase("devis")) {
         this.rechercheDevisSql(var5, var6, var2, var4, (Session)null);
      } else if (this.nomRepertoire.equalsIgnoreCase("hospitalisation")) {
         this.rechercheHospitalisationSql(var5, var6, var2, var4, 0, (Session)null);
      } else if (this.nomRepertoire.equalsIgnoreCase("laboratoire")) {
         this.rechercheLaboratoireSql(var5, var6, var2, var4, (Session)null);
      } else if (this.nomRepertoire.equalsIgnoreCase("paillasse")) {
         this.recherchePaillasseSql(var5, var6, var2, var4, (Session)null);
      } else if (this.nomRepertoire.equalsIgnoreCase("pharmacie")) {
         this.recherchePharmacieSql(var5, var6, var2, var4, (Session)null);
      } else if (this.nomRepertoire.equalsIgnoreCase("refacturation")) {
         this.rechercheRefacturationSql(var5, var6, var2, var4, (Session)null);
      } else if (this.nomRepertoire.equalsIgnoreCase("controle")) {
         if (this.nomEtat.contains("consultation")) {
            this.rechercheControleConsultation(var5, var6, var2, var4, (Session)null);
         } else if (this.nomEtat.contains("laboratoire")) {
            this.rechercheControleLaboratoire(var5, var6, var2, var4, (Session)null);
         } else if (this.nomEtat.contains("pharmacie")) {
            this.rechercheControlePharmacie(var5, var6, var2, var4, (Session)null);
         } else if (this.nomEtat.contains("hospitalisation")) {
            this.rechercheControleHospitalisation(var5, var6, var2, var4, (Session)null);
         }
      }

   }

   public void statInfirmerie(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      this.lesStatMedical.clear();
      Statmedical var5 = new Statmedical();
      byte var6 = 0;
      byte var7 = 0;
      int var8 = 0;
      int var9 = 0;
      int var10 = 0;
      int var11 = 0;
      int var12 = 0;
      int var13 = 0;
      int var14 = 0;
      int var15 = 0;
      int var16 = 0;
      int var17 = 0;
      int var18 = 0;
      int var19 = 0;
      int var20 = 0;
      int var21 = 0;
      int var22 = 0;
      int var23 = 0;
      int var24 = 0;
      int var25 = 0;
      int var26 = 0;
      int var27 = 0;
      int var28 = 0;
      int var29 = 0;
      int var30 = 0;
      int var31 = 0;
      int var32 = 0;
      int var33 = 0;
      int var34 = 0;
      int var35 = 0;
      int var36 = 0;
      int var37 = 0;
      int var38 = 0;
      int var39 = 0;
      int var40 = 0;
      int var41 = 0;
      int var42 = 0;
      int var43 = 0;
      int var44 = 0;
      int var45 = 0;
      int var46 = 0;
      int var47 = 0;
      int var48 = 0;
      int var49 = 0;
      int var50 = 0;
      int var51 = 0;
      int var52 = 0;
      int var53 = 0;
      int var54 = 0;
      int var55 = 0;
      int var56 = 0;
      int var57 = 0;
      int var58 = 0;
      int var59 = 0;
      int var60 = 0;
      int var61 = 0;
      int var62 = 0;
      int var63 = 0;
      int var64 = 0;
      int var65 = 0;
      int var66 = 0;
      int var67 = 0;
      int var68 = 0;
      int var69 = 0;
      int var70 = 0;
      int var71 = 0;
      int var72 = 0;
      int var73 = 0;
      int var74 = 0;
      int var75 = 0;
      int var76 = 0;
      int var77 = 0;
      int var78 = 0;
      int var79 = 0;
      int var80 = 0;
      int var81 = 0;
      int var82 = 0;
      int var83 = 0;
      int var84 = 0;
      int var85 = 0;
      int var86 = 0;
      int var87 = 0;
      int var88 = 0;
      int var89 = 0;
      Session var90 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertMed");
      new ArrayList();
      ConsultationEnteteGeneDao var92 = new ConsultationEnteteGeneDao(this.baseLog, this.utilInitHibernate);
      List var91;
      if (this.site != null && !this.site.isEmpty()) {
         var91 = var92.rechercheConsultationInfirmerie(this.site, var3, var4, 0L, var90);
      } else {
         var91 = var92.rechercheConsultationPeriode(var3, var4, 0L, (String)null, var90);
      }

      if (var91.size() != 0) {
         new ConsultationEnteteGene();

         for(int var94 = 0; var94 < var91.size(); ++var94) {
            ConsultationEnteteGene var93 = (ConsultationEnteteGene)var91.get(var94);
            if (var93.getCsgEtat() <= 1) {
               if (var93.getPatients().getPatPorte() != null && !var93.getPatients().getPatPorte().isEmpty() && var93.getPatients().getPatPorte().equals("EMB")) {
                  ++var8;
                  if (var93.getPatients().getPatSexe() == 0) {
                     ++var15;
                  } else {
                     ++var22;
                  }
               } else if (var93.getPatients().getPatPorte() != null && !var93.getPatients().getPatPorte().isEmpty() && var93.getPatients().getPatPorte().equals("TMP")) {
                  ++var9;
                  if (var93.getPatients().getPatSexe() == 0) {
                     ++var16;
                  } else {
                     ++var23;
                  }
               } else if (var93.getPatients().getPatPorte() != null && !var93.getPatients().getPatPorte().isEmpty() && var93.getPatients().getPatPorte().startsWith("PRE")) {
                  ++var10;
                  if (var93.getPatients().getPatSexe() == 0) {
                     ++var17;
                  } else {
                     ++var24;
                  }
               } else if (var93.getPatients().getPatPorte() != null && !var93.getPatients().getPatPorte().isEmpty() && var93.getPatients().getPatPorte().startsWith("STA")) {
                  ++var11;
                  if (var93.getPatients().getPatSexe() == 0) {
                     ++var18;
                  } else {
                     ++var25;
                  }
               } else if (var93.getPatients().getPatPorte() != null && !var93.getPatients().getPatPorte().isEmpty() && var93.getPatients().getPatPorte().startsWith("CAJ")) {
                  ++var12;
                  if (var93.getPatients().getPatSexe() == 0) {
                     ++var19;
                  } else {
                     ++var26;
                  }
               } else if (var93.getPatients().getPatPorte() != null && !var93.getPatients().getPatPorte().isEmpty() && var93.getPatients().getPatPorte().startsWith("VIS")) {
                  ++var13;
                  if (var93.getPatients().getPatSexe() == 0) {
                     ++var20;
                  } else {
                     ++var27;
                  }
               } else {
                  ++var14;
                  if (var93.getPatients().getPatSexe() == 0) {
                     ++var21;
                  } else {
                     ++var28;
                  }
               }

               if (var93.getCsgEntree() != null && !var93.getCsgEntree().isEmpty() && var93.getCsgEntree().startsWith("A:")) {
                  ++var29;
                  if (var93.getPatients().getPatSexe() == 0) {
                     ++var40;
                  } else {
                     ++var51;
                  }
               } else if (var93.getCsgEntree() != null && !var93.getCsgEntree().isEmpty() && var93.getCsgEntree().startsWith("B:")) {
                  ++var30;
                  if (var93.getPatients().getPatSexe() == 0) {
                     ++var41;
                  } else {
                     ++var52;
                  }
               } else if (var93.getCsgEntree() != null && !var93.getCsgEntree().isEmpty() && var93.getCsgEntree().startsWith("C:")) {
                  ++var31;
                  if (var93.getPatients().getPatSexe() == 0) {
                     ++var42;
                  } else {
                     ++var53;
                  }
               } else if (var93.getCsgEntree() != null && !var93.getCsgEntree().isEmpty() && var93.getCsgEntree().startsWith("D:")) {
                  ++var32;
                  if (var93.getPatients().getPatSexe() == 0) {
                     ++var43;
                  } else {
                     ++var54;
                  }

                  if (var93.getPatients().getPatPorte() != null && !var93.getPatients().getPatPorte().isEmpty() && var93.getPatients().getPatPorte().equals("EMB")) {
                     ++var62;
                     if (var93.getPatients().getPatSexe() == 0) {
                        ++var69;
                     } else {
                        ++var76;
                     }
                  } else if (var93.getPatients().getPatPorte() != null && !var93.getPatients().getPatPorte().isEmpty() && var93.getPatients().getPatPorte().equals("TMP")) {
                     ++var63;
                     if (var93.getPatients().getPatSexe() == 0) {
                        ++var70;
                     } else {
                        ++var77;
                     }
                  } else if (var93.getPatients().getPatPorte() != null && !var93.getPatients().getPatPorte().isEmpty() && var93.getPatients().getPatPorte().startsWith("PRE")) {
                     ++var64;
                     if (var93.getPatients().getPatSexe() == 0) {
                        ++var71;
                     } else {
                        ++var78;
                     }
                  } else if (var93.getPatients().getPatPorte() != null && !var93.getPatients().getPatPorte().isEmpty() && var93.getPatients().getPatPorte().startsWith("STA")) {
                     ++var65;
                     if (var93.getPatients().getPatSexe() == 0) {
                        ++var72;
                     } else {
                        ++var79;
                     }
                  } else if (var93.getPatients().getPatPorte() != null && !var93.getPatients().getPatPorte().isEmpty() && var93.getPatients().getPatPorte().startsWith("CAJ")) {
                     ++var66;
                     if (var93.getPatients().getPatSexe() == 0) {
                        ++var73;
                     } else {
                        ++var80;
                     }
                  } else if (var93.getPatients().getPatPorte() != null && !var93.getPatients().getPatPorte().isEmpty() && var93.getPatients().getPatPorte().startsWith("VIS")) {
                     ++var67;
                     if (var93.getPatients().getPatSexe() == 0) {
                        ++var74;
                     } else {
                        ++var81;
                     }
                  } else {
                     ++var68;
                     if (var93.getPatients().getPatSexe() == 0) {
                        ++var75;
                     } else {
                        ++var82;
                     }
                  }
               } else if (var93.getCsgEntree() != null && !var93.getCsgEntree().isEmpty() && var93.getCsgEntree().startsWith("E:")) {
                  ++var33;
                  if (var93.getPatients().getPatSexe() == 0) {
                     ++var44;
                  } else {
                     ++var55;
                  }
               } else if (var93.getCsgEntree() != null && !var93.getCsgEntree().isEmpty() && var93.getCsgEntree().startsWith("F:")) {
                  ++var36;
                  if (var93.getPatients().getPatSexe() == 0) {
                     ++var47;
                  } else {
                     ++var58;
                  }
               } else if (var93.getCsgEntree() != null && !var93.getCsgEntree().isEmpty() && var93.getCsgEntree().startsWith("G:")) {
                  ++var35;
                  if (var93.getPatients().getPatSexe() == 0) {
                     ++var46;
                  } else {
                     ++var57;
                  }
               } else if (var93.getCsgEntree() != null && !var93.getCsgEntree().isEmpty() && var93.getCsgEntree().startsWith("H:")) {
                  ++var38;
                  if (var93.getPatients().getPatSexe() == 0) {
                     ++var49;
                  } else {
                     ++var60;
                  }
               } else if (var93.getCsgEntree() != null && !var93.getCsgEntree().isEmpty() && var93.getCsgEntree().startsWith("I:")) {
                  ++var39;
                  if (var93.getPatients().getPatSexe() == 0) {
                     ++var50;
                  } else {
                     ++var61;
                  }
               } else if (var93.getCsgEntree() != null && !var93.getCsgEntree().isEmpty() && var93.getCsgEntree().startsWith("J:")) {
                  ++var37;
                  if (var93.getPatients().getPatSexe() == 0) {
                     ++var48;
                  } else {
                     ++var59;
                  }
               } else if (var93.getCsgEntree() != null && !var93.getCsgEntree().isEmpty() && var93.getCsgEntree().startsWith("K:")) {
                  ++var38;
                  if (var93.getPatients().getPatSexe() == 0) {
                     ++var49;
                  } else {
                     ++var60;
                  }
               } else if (var93.getCsgEntree() != null && !var93.getCsgEntree().isEmpty() && var93.getCsgEntree().startsWith("L:")) {
                  ++var39;
                  if (var93.getPatients().getPatSexe() == 0) {
                     ++var50;
                  } else {
                     ++var61;
                  }
               } else if (var93.getCsgEntree() != null && !var93.getCsgEntree().isEmpty() && var93.getCsgEntree().startsWith("M:")) {
                  ++var34;
                  if (var93.getPatients().getPatSexe() == 0) {
                     ++var45;
                  } else {
                     ++var56;
                  }
               } else {
                  ++var29;
                  if (var93.getPatients().getPatSexe() == 0) {
                     ++var40;
                  } else {
                     ++var51;
                  }
               }
            }
         }
      }

      var5.setNbFemme(var6);
      var5.setNbHomme(var7);
      var5.setNbEmbauche(var8);
      var5.setNbTemporaire(var9);
      var5.setNbPrestataire(var10);
      var5.setNbStagiaire(var11);
      var5.setNbSyndicat(var12);
      var5.setNbComite(var13);
      var5.setNbAutre(var14);
      var5.setNbEmbaucheF(var15);
      var5.setNbTemporaireF(var16);
      var5.setNbPrestataireF(var17);
      var5.setNbStagiaireF(var18);
      var5.setNbSyndicatF(var19);
      var5.setNbComiteF(var20);
      var5.setNbAutreF(var21);
      var5.setNbEmbaucheH(var22);
      var5.setNbTemporaireH(var23);
      var5.setNbPrestataireH(var24);
      var5.setNbStagiaireH(var25);
      var5.setNbSyndicatH(var26);
      var5.setNbComiteH(var27);
      var5.setNbAutreH(var28);
      var5.setNbMaladie(var29);
      var5.setNbVme(var30);
      var5.setNbVma(var31);
      var5.setNbAt(var32);
      var5.setNbVaccination(var33);
      var5.setNbDeparasitage(var34);
      var5.setNbAudiometrie(var35);
      var5.setNbTubertest(var36);
      var5.setNbSuiteat(var37);
      var5.setNbResulVme(var38);
      var5.setNbResulVma(var39);
      var5.setNbMaladieF(var40);
      var5.setNbVmeF(var41);
      var5.setNbVmaF(var42);
      var5.setNbAtF(var43);
      var5.setNbVaccinationF(var44);
      var5.setNbDeparasitageF(var45);
      var5.setNbAudiometrieF(var46);
      var5.setNbTubertestF(var47);
      var5.setNbSuiteatF(var48);
      var5.setNbResulVmeF(var49);
      var5.setNbResulVmaF(var50);
      var5.setNbMaladieH(var51);
      var5.setNbVmeH(var52);
      var5.setNbVmaH(var53);
      var5.setNbAtH(var54);
      var5.setNbVaccinationH(var55);
      var5.setNbDeparasitageH(var56);
      var5.setNbAudiometrieH(var57);
      var5.setNbTubertestH(var58);
      var5.setNbSuiteatH(var59);
      var5.setNbResulVmeH(var60);
      var5.setNbResulVmaH(var61);
      var5.setNbProtocoles(0);
      var5.setChapitre(0);
      var5.setType(0);
      var5.setLibelle("");
      var5.setDepot("");
      var5.setSite(this.site);
      this.lesStatMedical.add(var5);
      new ArrayList();
      ConsultationActesDao var103 = new ConsultationActesDao(this.baseLog, this.utilInitHibernate);
      List var102;
      if (this.site != null && !this.site.isEmpty()) {
         var102 = var103.chargerLesMvtsInfirmerieDate(this.site, var3, var4, var90);
      } else {
         var102 = var103.chargerLesMvtsDate(var3, var4, var90);
      }

      Statmedical var96;
      int var97;
      boolean var98;
      int var99;
      if (var102.size() != 0) {
         new ConsultationActes();
         var96 = new Statmedical();

         for(var97 = 0; var97 < var102.size(); ++var97) {
            ConsultationActes var95 = (ConsultationActes)var102.get(var97);
            if (var95.getConsultationEnteteGene().getCsgEtat() <= 1) {
               var98 = false;

               for(var99 = 0; var99 < this.lesStatMedical.size(); ++var99) {
                  var96 = (Statmedical)this.lesStatMedical.get(var99);
                  if (var95.getCslactLibelle() != null && !var95.getCslactLibelle().isEmpty() && var96.getLibelle() != null && !var96.getLibelle().isEmpty() && var96.getType() == 1 && var96.getLibelle().equals(var95.getCslactLibelle())) {
                     var98 = true;
                     break;
                  }
               }

               if (!var98) {
                  var5 = new Statmedical();
                  var5.setNbFemme(var6);
                  var5.setNbHomme(var7);
                  var5.setNbEmbauche(var8);
                  var5.setNbTemporaire(var9);
                  var5.setNbPrestataire(var10);
                  var5.setNbStagiaire(var11);
                  var5.setNbSyndicat(var12);
                  var5.setNbComite(var13);
                  var5.setNbAutre(var14);
                  var5.setNbEmbaucheF(var15);
                  var5.setNbTemporaireF(var16);
                  var5.setNbPrestataireF(var17);
                  var5.setNbStagiaireF(var18);
                  var5.setNbSyndicatF(var19);
                  var5.setNbComiteF(var20);
                  var5.setNbAutreF(var21);
                  var5.setNbEmbaucheH(var22);
                  var5.setNbTemporaireH(var23);
                  var5.setNbPrestataireH(var24);
                  var5.setNbStagiaireH(var25);
                  var5.setNbSyndicatH(var26);
                  var5.setNbComiteH(var27);
                  var5.setNbAutreH(var28);
                  var5.setNbMaladie(var29);
                  var5.setNbVme(var30);
                  var5.setNbVma(var31);
                  var5.setNbAt(var32);
                  var5.setNbVaccination(var33);
                  var5.setNbDeparasitage(var34);
                  var5.setNbAudiometrie(var35);
                  var5.setNbTubertest(var36);
                  var5.setNbSuiteat(var37);
                  var5.setNbResulVme(var38);
                  var5.setNbResulVma(var39);
                  var5.setNbMaladieF(var40);
                  var5.setNbVmeF(var41);
                  var5.setNbVmaF(var42);
                  var5.setNbAtF(var43);
                  var5.setNbVaccinationF(var44);
                  var5.setNbDeparasitageF(var45);
                  var5.setNbAudiometrieF(var46);
                  var5.setNbTubertestF(var47);
                  var5.setNbSuiteatF(var48);
                  var5.setNbResulVmeF(var49);
                  var5.setNbResulVmaF(var50);
                  var5.setNbMaladieH(var51);
                  var5.setNbVmeH(var52);
                  var5.setNbVmaH(var53);
                  var5.setNbAtH(var54);
                  var5.setNbVaccinationH(var55);
                  var5.setNbDeparasitageH(var56);
                  var5.setNbAudiometrieH(var57);
                  var5.setNbTubertestH(var58);
                  var5.setNbSuiteatH(var59);
                  var5.setNbResulVmeH(var60);
                  var5.setNbResulVmaH(var61);
                  var5.setNbProtocoles(0);
                  var5.setChapitre(0);
                  var5.setType(1);
                  var5.setLibelle(var95.getCslactLibelle());
                  var5.setNbActes(1);
                  var5.setDepot("");
                  var5.setSite(this.site);
                  if (var5.getLibelle() != null && !var5.getLibelle().isEmpty()) {
                     this.lesStatMedical.add(var5);
                  }
               } else {
                  this.lesStatMedical.remove(var96);
                  var96.setNbActes(var96.getNbActes() + 1);
                  this.lesStatMedical.add(var96);
               }
            }
         }
      }

      if (var91.size() != 0) {
         new ConsultationEnteteGene();
         var96 = new Statmedical();

         for(var97 = 0; var97 < var91.size(); ++var97) {
            ConsultationEnteteGene var104 = (ConsultationEnteteGene)var91.get(var97);
            if (var104.getCsgEtat() <= 1) {
               if (var104.getCsgPathologie() != null && !var104.getCsgPathologie().isEmpty() && var104.getCsgPathologie().equals("100")) {
                  var104.setCsgPathologie("NON RENSEIGNE");
               } else if (var104.getCsgPathologie() == null || var104.getCsgPathologie().isEmpty()) {
                  var104.setCsgPathologie("NON RENSEIGNE");
               }

               var98 = false;

               for(var99 = 0; var99 < this.lesStatMedical.size(); ++var99) {
                  var96 = (Statmedical)this.lesStatMedical.get(var99);
                  if (var104.getCsgPathologie() != null && !var104.getCsgPathologie().isEmpty() && !var104.getCsgPathologie().equals("100") && var96.getLibelle() != null && !var96.getLibelle().isEmpty() && var96.getType() == 2 && var96.getLibelle().equals(var104.getCsgPathologie())) {
                     var98 = true;
                     break;
                  }
               }

               if (!var98) {
                  var5.setNbFemme(var6);
                  var5.setNbHomme(var7);
                  var5 = new Statmedical();
                  var5.setNbEmbauche(var8);
                  var5.setNbTemporaire(var9);
                  var5.setNbPrestataire(var10);
                  var5.setNbStagiaire(var11);
                  var5.setNbSyndicat(var12);
                  var5.setNbComite(var13);
                  var5.setNbAutre(var14);
                  var5.setNbEmbaucheF(var15);
                  var5.setNbTemporaireF(var16);
                  var5.setNbPrestataireF(var17);
                  var5.setNbStagiaireF(var18);
                  var5.setNbSyndicatF(var19);
                  var5.setNbComiteF(var20);
                  var5.setNbAutreF(var21);
                  var5.setNbEmbaucheH(var22);
                  var5.setNbTemporaireH(var23);
                  var5.setNbPrestataireH(var24);
                  var5.setNbStagiaireH(var25);
                  var5.setNbSyndicatH(var26);
                  var5.setNbComiteH(var27);
                  var5.setNbAutreH(var28);
                  var5.setNbMaladie(var29);
                  var5.setNbVme(var30);
                  var5.setNbVma(var31);
                  var5.setNbAt(var32);
                  var5.setNbVaccination(var33);
                  var5.setNbDeparasitage(var34);
                  var5.setNbAudiometrie(var35);
                  var5.setNbTubertest(var36);
                  var5.setNbSuiteat(var37);
                  var5.setNbResulVme(var38);
                  var5.setNbResulVma(var39);
                  var5.setNbMaladieF(var40);
                  var5.setNbVmeF(var41);
                  var5.setNbVmaF(var42);
                  var5.setNbAtF(var43);
                  var5.setNbVaccinationF(var44);
                  var5.setNbDeparasitageF(var45);
                  var5.setNbAudiometrieF(var46);
                  var5.setNbTubertestF(var47);
                  var5.setNbSuiteatF(var48);
                  var5.setNbResulVmeF(var49);
                  var5.setNbResulVmaF(var50);
                  var5.setNbMaladieH(var51);
                  var5.setNbVmeH(var52);
                  var5.setNbVmaH(var53);
                  var5.setNbAtH(var54);
                  var5.setNbVaccinationH(var55);
                  var5.setNbDeparasitageH(var56);
                  var5.setNbAudiometrieH(var57);
                  var5.setNbTubertestH(var58);
                  var5.setNbSuiteatH(var59);
                  var5.setNbResulVmeH(var60);
                  var5.setNbResulVmaH(var61);
                  var5.setChapitre(0);
                  var5.setType(2);
                  var5.setLibelle(var104.getCsgPathologie());
                  var5.setNbProtocoles(1);
                  var5.setDepot("");
                  var5.setSite(this.site);
                  if (var5.getLibelle() != null && !var5.getLibelle().isEmpty()) {
                     this.lesStatMedical.add(var5);
                  }
               } else {
                  this.lesStatMedical.remove(var96);
                  var96.setNbProtocoles(var96.getNbProtocoles() + 1);
                  this.lesStatMedical.add(var96);
               }
            }
         }
      }

      new ArrayList();
      ConsultationInfirmerieDao var106 = new ConsultationInfirmerieDao(this.baseLog, this.utilInitHibernate);
      List var105;
      if (this.site != null && !this.site.isEmpty()) {
         var105 = var106.chargerLesMvtsInfirmerieDate(this.site, var3, var4, var90);
      } else {
         var105 = var106.chargerLesMvtsDate(var3, var4, var90);
      }

      if (var105.size() != 0) {
         new ConsultationInfirmerie();
         new ConsultationEnteteGene();

         for(var99 = 0; var99 < var105.size(); ++var99) {
            ConsultationInfirmerie var107 = (ConsultationInfirmerie)var105.get(var99);
            ConsultationEnteteGene var110 = var107.getConsultationEnteteGene();
            if (var110.getCsgEtat() <= 1 && var110.getCsgEntree() != null && !var110.getCsgEntree().isEmpty() && var110.getCsgEntree().startsWith("D:")) {
               if (var110.getPatients().getPatPorte() != null && !var110.getPatients().getPatPorte().isEmpty() && var110.getPatients().getPatPorte().equals("EMB")) {
                  var84 += var107.getCslaccNbJourRepos();
               } else if (var110.getPatients().getPatPorte() != null && !var110.getPatients().getPatPorte().isEmpty() && var110.getPatients().getPatPorte().equals("TMP")) {
                  var83 += var107.getCslaccNbJourRepos();
               } else if (var110.getPatients().getPatPorte() != null && !var110.getPatients().getPatPorte().isEmpty() && var110.getPatients().getPatPorte().startsWith("PRE")) {
                  var85 += var107.getCslaccNbJourRepos();
               } else if (var110.getPatients().getPatPorte() != null && !var110.getPatients().getPatPorte().isEmpty() && var110.getPatients().getPatPorte().startsWith("STA")) {
                  var86 += var107.getCslaccNbJourRepos();
               } else if (var110.getPatients().getPatPorte() != null && !var110.getPatients().getPatPorte().isEmpty() && var110.getPatients().getPatPorte().startsWith("CAJ")) {
                  var87 += var107.getCslaccNbJourRepos();
               } else if (var110.getPatients().getPatPorte() != null && !var110.getPatients().getPatPorte().isEmpty() && var110.getPatients().getPatPorte().startsWith("VIS")) {
                  var88 += var107.getCslaccNbJourRepos();
               } else {
                  var89 += var107.getCslaccNbJourRepos();
               }
            }
         }

         var5 = new Statmedical();
         var5.setNbFemme(var6);
         var5.setNbHomme(var7);
         var5.setNbEmbauche(var8);
         var5.setNbTemporaire(var9);
         var5.setNbPrestataire(var10);
         var5.setNbStagiaire(var11);
         var5.setNbSyndicat(var12);
         var5.setNbComite(var13);
         var5.setNbAutre(var14);
         var5.setNbEmbaucheF(var15);
         var5.setNbTemporaireF(var16);
         var5.setNbPrestataireF(var17);
         var5.setNbStagiaireF(var18);
         var5.setNbSyndicatF(var19);
         var5.setNbComiteF(var20);
         var5.setNbAutreF(var21);
         var5.setNbEmbaucheH(var22);
         var5.setNbTemporaireH(var23);
         var5.setNbPrestataireH(var24);
         var5.setNbStagiaireH(var25);
         var5.setNbSyndicatH(var26);
         var5.setNbComiteH(var27);
         var5.setNbAutreH(var28);
         var5.setNbMaladie(var29);
         var5.setNbVme(var30);
         var5.setNbVma(var31);
         var5.setNbAt(var32);
         var5.setNbVaccination(var33);
         var5.setNbDeparasitage(var34);
         var5.setNbAudiometrie(var35);
         var5.setNbTubertest(var36);
         var5.setNbSuiteat(var37);
         var5.setNbResulVme(var38);
         var5.setNbResulVma(var39);
         var5.setNbMaladieF(var40);
         var5.setNbVmeF(var41);
         var5.setNbVmaF(var42);
         var5.setNbAtF(var43);
         var5.setNbVaccinationF(var44);
         var5.setNbDeparasitageF(var45);
         var5.setNbAudiometrieF(var46);
         var5.setNbTubertestF(var47);
         var5.setNbSuiteatF(var48);
         var5.setNbResulVmeF(var49);
         var5.setNbResulVmaF(var50);
         var5.setNbMaladieH(var51);
         var5.setNbVmeH(var52);
         var5.setNbVmaH(var53);
         var5.setNbAtH(var54);
         var5.setNbVaccinationH(var55);
         var5.setNbDeparasitageH(var56);
         var5.setNbAudiometrieH(var57);
         var5.setNbTubertestH(var58);
         var5.setNbSuiteatH(var59);
         var5.setNbResulVmeH(var60);
         var5.setNbResulVmaH(var61);
         var5.setNbProtocoles(0);
         var5.setChapitre(1);
         var5.setType(3);
         var5.setLibelle("Somme des jours d`arrêt de travail");
         var5.setNbATEmbauche(var62);
         var5.setNbATTemporaire(var63);
         var5.setNbATPrestataire(var64);
         var5.setNbATStagiaire(var65);
         var5.setNbATSyndicat(var66);
         var5.setNbATComite(var67);
         var5.setNbATAutre(var68);
         var5.setNbATEmbaucheF(var69);
         var5.setNbATTemporaireF(var70);
         var5.setNbATPrestataireF(var71);
         var5.setNbATStagiaireF(var72);
         var5.setNbATSyndicatF(var73);
         var5.setNbATComiteF(var74);
         var5.setNbATAutreF(var75);
         var5.setNbATEmbaucheH(var76);
         var5.setNbATTemporaireH(var77);
         var5.setNbATPrestataireH(var78);
         var5.setNbATStagiaireH(var79);
         var5.setNbATSyndicatH(var80);
         var5.setNbATComiteH(var81);
         var5.setNbATAutreH(var82);
         var5.setNbJoursArretEmb(var84);
         var5.setNbJoursArretTmp(var83);
         var5.setNbJoursArretPrestataire(var85);
         var5.setNbJoursArretStagiaire(var86);
         var5.setNbJoursArretSyndicat(var87);
         var5.setNbJoursArretComite(var88);
         var5.setNbJoursArretAutre(var89);
         var5.setDepot("");
         var5.setSite(this.site);
         this.lesStatMedical.add(var5);
      }

      int var101;
      if (var91.size() != 0) {
         new ConsultationEnteteGene();
         Statmedical var111 = new Statmedical();

         for(var99 = 0; var99 < var91.size(); ++var99) {
            ConsultationEnteteGene var108 = (ConsultationEnteteGene)var91.get(var99);
            if (var108.getCsgEtat() <= 1 && var108.getCsgEntree() != null && !var108.getCsgEntree().isEmpty() && var108.getCsgEntree().startsWith("D:")) {
               boolean var100 = false;

               for(var101 = 0; var101 < this.lesStatMedical.size(); ++var101) {
                  var111 = (Statmedical)this.lesStatMedical.get(var101);
                  if (var108.getPatients().getPatCommune() == null || var108.getPatients().getPatCommune().isEmpty()) {
                     var108.getPatients().setPatCommune("Non renseigné");
                  }

                  if (var108.getPatients().getPatCommune() != null && !var108.getPatients().getPatCommune().isEmpty() && var111.getLibelle() != null && !var111.getLibelle().isEmpty() && var111.getType() == 4 && var111.getLibelle().equals(var108.getPatients().getPatCommune())) {
                     var100 = true;
                     break;
                  }
               }

               if (var100) {
                  this.lesStatMedical.remove(var111);
                  var111.setNbProtocoles(var111.getNbProtocoles() + 1);
                  this.lesStatMedical.add(var111);
               } else {
                  var5.setNbFemme(var6);
                  var5.setNbHomme(var7);
                  var5 = new Statmedical();
                  var5.setNbEmbauche(var8);
                  var5.setNbTemporaire(var9);
                  var5.setNbPrestataire(var10);
                  var5.setNbStagiaire(var11);
                  var5.setNbSyndicat(var12);
                  var5.setNbComite(var13);
                  var5.setNbAutre(var14);
                  var5.setNbEmbaucheF(var15);
                  var5.setNbTemporaireF(var16);
                  var5.setNbPrestataireF(var17);
                  var5.setNbStagiaireF(var18);
                  var5.setNbSyndicatF(var19);
                  var5.setNbComiteF(var20);
                  var5.setNbAutreF(var21);
                  var5.setNbEmbaucheH(var22);
                  var5.setNbTemporaireH(var23);
                  var5.setNbPrestataireH(var24);
                  var5.setNbStagiaireH(var25);
                  var5.setNbSyndicatH(var26);
                  var5.setNbComiteH(var27);
                  var5.setNbAutreH(var28);
                  var5.setNbMaladie(var29);
                  var5.setNbVme(var30);
                  var5.setNbVma(var31);
                  var5.setNbAt(var32);
                  var5.setNbVaccination(var33);
                  var5.setNbDeparasitage(var34);
                  var5.setNbAudiometrie(var35);
                  var5.setNbTubertest(var36);
                  var5.setNbSuiteat(var37);
                  var5.setNbResulVme(var38);
                  var5.setNbResulVma(var39);
                  var5.setNbMaladieF(var40);
                  var5.setNbVmeF(var41);
                  var5.setNbVmaF(var42);
                  var5.setNbAtF(var43);
                  var5.setNbVaccinationF(var44);
                  var5.setNbDeparasitageF(var45);
                  var5.setNbAudiometrieF(var46);
                  var5.setNbTubertestF(var47);
                  var5.setNbSuiteatF(var48);
                  var5.setNbResulVmeF(var49);
                  var5.setNbResulVmaF(var50);
                  var5.setNbMaladieH(var51);
                  var5.setNbVmeH(var52);
                  var5.setNbVmaH(var53);
                  var5.setNbAtH(var54);
                  var5.setNbVaccinationH(var55);
                  var5.setNbDeparasitageH(var56);
                  var5.setNbAudiometrieH(var57);
                  var5.setNbTubertestH(var58);
                  var5.setNbSuiteatH(var59);
                  var5.setNbResulVmeH(var60);
                  var5.setNbResulVmaH(var61);
                  var5.setChapitre(1);
                  var5.setType(4);
                  if (var108.getPatients().getPatLot() != null && !var108.getPatients().getPatLot().isEmpty()) {
                     var5.setLibelle(var108.getPatients().getPatLot());
                  } else if (var108.getPatients().getPatZone() != null && !var108.getPatients().getPatZone().isEmpty()) {
                     var5.setLibelle(var108.getPatients().getPatZone());
                  } else {
                     var5.setLibelle("N.R.");
                  }

                  var5.setNbProtocoles(1);
                  var5.setDepot("");
                  var5.setSite(this.site);
                  if (var5.getLibelle() != null && !var5.getLibelle().isEmpty()) {
                     this.lesStatMedical.add(var5);
                  }
               }
            }
         }
      }

      new ArrayList();
      RapportMedicalDao var113 = new RapportMedicalDao(this.baseLog, this.utilInitHibernate);
      List var109;
      if (this.site != null && !this.site.isEmpty()) {
         var109 = var113.chargerLesMvtsInfirmerieDate(this.site, var3, var4, var90);
      } else {
         var109 = var113.chargerLesMvtsDate(var3, var4, var90);
      }

      if (var109.size() != 0) {
         String var114 = "";
         new RapportMedical();

         for(var101 = 0; var101 < var109.size(); ++var101) {
            RapportMedical var112 = (RapportMedical)var109.get(var101);
            if (var114 != null && !var114.isEmpty()) {
               var114 = var114 + "\n" + "---------------------------------------------------------" + "\n" + var112.getRapmedRapport() + "\n" + "Responsable:  " + var112.getRapmedNomMedecin();
            } else {
               var114 = var112.getRapmedRapport() + "\n" + "Responsable:" + var112.getRapmedNomMedecin();
            }
         }

         var5 = new Statmedical();
         var5.setNbFemme(var6);
         var5.setNbHomme(var7);
         var5.setNbEmbauche(var8);
         var5.setNbTemporaire(var9);
         var5.setNbPrestataire(var10);
         var5.setNbStagiaire(var11);
         var5.setNbSyndicat(var12);
         var5.setNbComite(var13);
         var5.setNbAutre(var14);
         var5.setNbEmbaucheF(var15);
         var5.setNbTemporaireF(var16);
         var5.setNbPrestataireF(var17);
         var5.setNbStagiaireF(var18);
         var5.setNbSyndicatF(var19);
         var5.setNbComiteF(var20);
         var5.setNbAutreF(var21);
         var5.setNbEmbaucheH(var22);
         var5.setNbTemporaireH(var23);
         var5.setNbPrestataireH(var24);
         var5.setNbStagiaireH(var25);
         var5.setNbSyndicatH(var26);
         var5.setNbComiteH(var27);
         var5.setNbAutreH(var28);
         var5.setNbMaladie(var29);
         var5.setNbVme(var30);
         var5.setNbVma(var31);
         var5.setNbAt(var32);
         var5.setNbVaccination(var33);
         var5.setNbDeparasitage(var34);
         var5.setNbAudiometrie(var35);
         var5.setNbTubertest(var36);
         var5.setNbSuiteat(var37);
         var5.setNbResulVme(var38);
         var5.setNbResulVma(var39);
         var5.setNbMaladieF(var40);
         var5.setNbVmeF(var41);
         var5.setNbVmaF(var42);
         var5.setNbAtF(var43);
         var5.setNbVaccinationF(var44);
         var5.setNbDeparasitageF(var45);
         var5.setNbAudiometrieF(var46);
         var5.setNbTubertestF(var47);
         var5.setNbSuiteatF(var48);
         var5.setNbResulVmeF(var49);
         var5.setNbResulVmaF(var50);
         var5.setNbMaladieH(var51);
         var5.setNbVmeH(var52);
         var5.setNbVmaH(var53);
         var5.setNbAtH(var54);
         var5.setNbVaccinationH(var55);
         var5.setNbDeparasitageH(var56);
         var5.setNbAudiometrieH(var57);
         var5.setNbTubertestH(var58);
         var5.setNbSuiteatH(var59);
         var5.setNbResulVmeH(var60);
         var5.setNbResulVmaH(var61);
         var5.setChapitre(2);
         var5.setType(5);
         var5.setLibelle("Rapport médical");
         var5.setNbATEmbauche(var62);
         var5.setNbATTemporaire(var63);
         var5.setNbATPrestataire(var64);
         var5.setNbATStagiaire(var65);
         var5.setNbATSyndicat(var66);
         var5.setNbATComite(var67);
         var5.setNbATAutre(var68);
         var5.setNbATEmbaucheF(var69);
         var5.setNbATTemporaireF(var70);
         var5.setNbATPrestataireF(var71);
         var5.setNbATStagiaireF(var72);
         var5.setNbATSyndicatF(var73);
         var5.setNbATComiteF(var74);
         var5.setNbATAutreF(var75);
         var5.setNbATEmbaucheH(var76);
         var5.setNbATTemporaireH(var77);
         var5.setNbATPrestataireH(var78);
         var5.setNbATStagiaireH(var79);
         var5.setNbATSyndicatH(var80);
         var5.setNbATComiteH(var81);
         var5.setNbATAutreH(var82);
         var5.setNbJoursArretEmb(var84);
         var5.setNbJoursArretTmp(var83);
         var5.setNbJoursArretPrestataire(var85);
         var5.setNbJoursArretStagiaire(var86);
         var5.setNbJoursArretSyndicat(var87);
         var5.setNbJoursArretComite(var88);
         var5.setNbJoursArretAutre(var89);
         var5.setDepot("");
         var5.setSite(this.site);
         var5.setRapport(var114);
         this.lesStatMedical.add(var5);
      }

      this.utilInitHibernate.closeSession();
   }

   public void rechercheSyntheseSql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException, ParseException {
      this.lesSyntheses.clear();
      new DocumentMedical();
      Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertMed");
      this.rechercheConsultationGeneSql(var1, var2, var3, var4, var6);
      ConsultationActesDao var7 = new ConsultationActesDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      List var8 = var7.chargerConsultationByRequete(this.var_requete_hql, var6);
      DocumentMedical var5;
      if (var8.size() != 0) {
         new ConsultationActes();

         for(int var10 = 0; var10 < var8.size(); ++var10) {
            ConsultationActes var9 = (ConsultationActes)var8.get(var10);
            var5 = new DocumentMedical();
            var5.setDocId(var9.getConsultationEnteteGene().getCsgId());
            var5.setDocNature(71);
            var5.setDocLibelleNature("Consultations");
            var5.setDocIdCreateur(var9.getConsultationEnteteGene().getCsgIdCreateur());
            var5.setDocNomCreateur(var9.getConsultationEnteteGene().getCsgNomCreateur());
            var5.setDocNum(var9.getConsultationEnteteGene().getCsgNum());
            var5.setDocDate(this.utilDate.dateToSQLLight(var9.getConsultationEnteteGene().getCsgDate()));
            var5.setDocNomPatient(var9.getConsultationEnteteGene().getCsgNomPatient());
            var5.setDocNomMedecin(this.calculMedecin(var9.getConsultationEnteteGene().getCsgIdMedecin()));
            var5.setDocNomTiersSociete(var9.getConsultationEnteteGene().getCsgNomSociete());
            var5.setDocNomTiersAssurance(var9.getConsultationEnteteGene().getCsgNomAssurance());
            var5.setDocNomTiersComplementaire(var9.getConsultationEnteteGene().getCsgNomComplemtaire());
            var5.setDocService(var9.getConsultationEnteteGene().getCsgService());
            var5.setDocCode(var9.getCslactProduit());
            var5.setDocProduit(var9.getCslactLibelle());
            var5.setDocQte(var9.getCslactQte());
            var5.setDocTotPatient(var9.getCslactPatientHt());
            var5.setDocRegPatient(var9.getCslactRegPatient());
            var5.setDocTotTiers(var9.getCslactAssuranceHt() + var9.getCslactSocieteHt() + var9.getCslactComplementaireHt());
            var5.setDocRegTiers(var9.getCslactRegTiers());
            this.lesSyntheses.add(var5);
         }
      }

      this.recherchePharmacieSql(var1, var2, var3, var4, var6);
      PharmacieLigneDao var15 = new PharmacieLigneDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      List var16 = var15.chargerPharmacieByRequete(this.var_requete_hql, var6);
      if (var16.size() != 0) {
         new PharmacieLigne();

         for(int var12 = 0; var12 < var16.size(); ++var12) {
            PharmacieLigne var11 = (PharmacieLigne)var16.get(var12);
            var5 = new DocumentMedical();
            var5.setDocId(var11.getPharmacieEntete().getPhaId());
            var5.setDocNature(73);
            var5.setDocLibelleNature("Pharmacie");
            var5.setDocIdCreateur(var11.getPharmacieEntete().getPhaIdCreateur());
            var5.setDocNomCreateur(var11.getPharmacieEntete().getPhaNomCreateur());
            var5.setDocNum(var11.getPharmacieEntete().getPhaNum());
            var5.setDocDate(this.utilDate.dateToSQLLight(var11.getPharmacieEntete().getPhaDate()));
            var5.setDocNomPatient(var11.getPharmacieEntete().getPhaNomPatient());
            var5.setDocNomMedecin(this.calculMedecin(var11.getPharmacieEntete().getPhaIdMedecin()));
            var5.setDocNomTiersSociete(var11.getPharmacieEntete().getPhaNomSociete());
            var5.setDocNomTiersAssurance(var11.getPharmacieEntete().getPhaNomAssurance());
            var5.setDocNomTiersComplementaire(var11.getPharmacieEntete().getPhaNomComplemtaire());
            var5.setDocService(var11.getPharmacieEntete().getPhaService());
            var5.setDocCode(var11.getPhaligProduit());
            var5.setDocProduit(var11.getPhaligLibelle());
            var5.setDocQte(var11.getPhaligQte());
            var5.setDocTotPatient(var11.getPhaligPatientHt());
            var5.setDocRegPatient(var11.getPhaligRegPatient());
            var5.setDocTotTiers(var11.getPhaligAssuranceHt() + var11.getPhaligSocieteHt() + var11.getPhaligComplementaireHt());
            var5.setDocRegTiers(var11.getPhaligRegTiers());
            this.lesSyntheses.add(var5);
         }
      }

      this.rechercheLaboratoireSql(var1, var2, var3, var4, var6);
      LaboratoireLigneDao var17 = new LaboratoireLigneDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      List var18 = var17.chargerLaboratoireByRequete(this.var_requete_hql, var6);
      int var14;
      if (var18.size() != 0) {
         new LaboratoireLigne();

         for(var14 = 0; var14 < var18.size(); ++var14) {
            LaboratoireLigne var13 = (LaboratoireLigne)var18.get(var14);
            var5 = new DocumentMedical();
            var5.setDocId(var13.getLaboratoireEntete().getLabId());
            var5.setDocNature(74);
            var5.setDocLibelleNature("Laboratoire");
            var5.setDocIdCreateur(var13.getLaboratoireEntete().getLabIdCreateur());
            var5.setDocNomCreateur(var13.getLaboratoireEntete().getLabNomCreateur());
            var5.setDocNum(var13.getLaboratoireEntete().getLabNum());
            var5.setDocDate(this.utilDate.dateToSQLLight(var13.getLaboratoireEntete().getLabDate()));
            var5.setDocNomPatient(var13.getLaboratoireEntete().getLabNomPatient());
            var5.setDocNomMedecin(this.calculMedecin(var13.getLaboratoireEntete().getLabIdMedecin()));
            var5.setDocNomTiersSociete(var13.getLaboratoireEntete().getLabNomSociete());
            var5.setDocNomTiersAssurance(var13.getLaboratoireEntete().getLabNomAssurance());
            var5.setDocNomTiersComplementaire(var13.getLaboratoireEntete().getLabNomComplemtaire());
            var5.setDocService(var13.getLabligLaboratoire());
            var5.setDocCode(var13.getLabligProduit());
            var5.setDocProduit(var13.getLabligLibelle());
            var5.setDocQte(var13.getLabligQte());
            var5.setDocTotPatient(var13.getLabligPatientHt());
            var5.setDocRegPatient(var13.getLabligRegPatient());
            var5.setDocTotTiers(var13.getLabligAssuranceHt() + var13.getLabligSocieteHt() + var13.getLabligComplementaireHt());
            var5.setDocRegTiers(var13.getLabligRegTiers());
            this.lesSyntheses.add(var5);
         }
      }

      this.rechercheHospitalisationSql(var1, var2, var3, var4, 1, var6);
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Activités méducales du " + var1 + " au " + var2 + " Série : Toutes";
      } else {
         this.var_entete = "Activités médicales du " + var1 + " au " + var2 + " Série : " + this.serie;
      }

      this.var_filtre = "";
      if (this.etat != null && !this.etat.isEmpty() && !this.etat.equals("100")) {
         int var19 = Integer.parseInt(this.etat);
         if (var19 == 0) {
            this.var_filtre = this.var_filtre + " Etat = En cours";
         } else if (var19 == 1) {
            this.var_filtre = this.var_filtre + " Etat = Validé ou Controlé ou Refacturé";
         } else if (var19 == 2) {
            this.var_filtre = this.var_filtre + " Etat = Gelé";
         } else if (var19 == 3) {
            this.var_filtre = this.var_filtre + " Etat = Annulé";
         } else if (var19 == 5) {
            this.var_filtre = this.var_filtre + " Etat = Controle";
         } else if (var19 == 13) {
            this.var_filtre = this.var_filtre + " Etat = Non payé Patient";
         } else if (var19 == 14) {
            this.var_filtre = this.var_filtre + " Etat = Payé Patient";
         } else if (var19 == 15) {
            this.var_filtre = this.var_filtre + " Etat = Non payé Tiers";
         } else if (var19 == 16) {
            this.var_filtre = this.var_filtre + " Etat = Payé Tiers";
         }
      }

      if (this.idTiers != 0L) {
         if (this.nomTiers != null && !this.nomTiers.isEmpty() && this.nomTiers.equalsIgnoreCase("CNAMGS")) {
            this.var_filtre = this.var_filtre + " Tiers payeur = CNAMGS";
         } else {
            this.var_filtre = this.var_filtre + " Tiers payeur = " + this.nomTiers;
         }
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
      }

      if (this.medecin != 0L) {
         String var20 = "";

         for(var14 = 0; var14 < this.mesMedecinsItems.size(); ++var14) {
            if (Long.parseLong(((SelectItem)this.mesMedecinsItems.get(var14)).getValue().toString()) == this.medecin) {
               var20 = ((SelectItem)this.mesMedecinsItems.get(var14)).getLabel().toString();
            }
         }

         this.var_filtre = this.var_filtre + " Medecin = " + var20;
      }

      if (this.createur != null && !this.createur.isEmpty() && !this.createur.equals("100")) {
         UserDao var21 = new UserDao(this.baseLog, this.utilInitHibernate);
         String var22 = var21.selectByIdUsers(Long.parseLong(this.createur), var6).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Créateur = " + var22;
      }

      if (this.typeTiers != 100) {
         if (this.typeTiers == 1) {
            this.var_filtre = this.var_filtre + " Type = Assurances";
         } else if (this.typeTiers == 2) {
            this.var_filtre = this.var_filtre + " Type = Sociétés";
         } else if (this.typeTiers == 3) {
            this.var_filtre = this.var_filtre + " Type = Complémentaires";
         } else if (this.typeTiers == 4) {
            this.var_filtre = this.var_filtre + " Type = CNAMGS";
         }
      }

      this.utilInitHibernate.closeSession();
   }

   public void rechercheSynthesePaiementSql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException, ParseException {
      this.lesSyntheses.clear();
      ReglementsDao var5 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
      Object var6 = new ArrayList();
      new DocumentMedical();
      Session var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertMed");
      this.rechercheConsultationGeneSql(var1, var2, var3, var4, var8);
      ConsultationEnteteGeneDao var9 = new ConsultationEnteteGeneDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      List var10 = var9.chargerConsultationByRequete(this.var_requete_directe, var8);
      DocumentMedical var7;
      int var15;
      if (var10.size() != 0) {
         new ConsultationEnteteGene();

         for(int var12 = 0; var12 < var10.size(); ++var12) {
            ConsultationEnteteGene var11 = (ConsultationEnteteGene)var10.get(var12);
            var7 = new DocumentMedical();
            var7.setDocId(var11.getCsgId());
            var7.setDocNature(71);
            var7.setDocLibelleNature("Consultations");
            var7.setDocIdCreateur(var11.getCsgIdCreateur());
            var7.setDocNomCreateur(var11.getCsgNomCreateur());
            var7.setDocNum(var11.getCsgNum());
            var7.setDocDate(this.utilDate.dateToSQLLight(var11.getCsgDate()));
            var7.setDocNomPatient(var11.getCsgNomPatient());
            var7.setDocNomMedecin(this.calculMedecin(var11.getCsgIdMedecin()));
            var7.setDocNomTiersSociete(var11.getCsgNomSociete());
            var7.setDocNomTiersAssurance(var11.getCsgNomAssurance());
            var7.setDocNomTiersComplementaire(var11.getCsgNomComplemtaire());
            var7.setDocService(var11.getCsgService());
            var7.setDocCode("");
            var7.setDocProduit("");
            var7.setDocQte(0.0F);
            var7.setDocTotPatient(var11.getCsgTotPatient());
            var7.setDocTotTiers(var11.getCsgTotAssurance() + var11.getCsgTotComplmentaire() + var11.getCsgTotSociete());
            ((List)var6).clear();
            var6 = var5.findRegByNatNum(var7.getDocNature(), var7.getDocNum(), var8);
            if (((List)var6).size() == 0) {
               var7.setDocDateTransfert((Date)null);
               var7.setDocRegTiers(0.0D);
            } else {
               double var13 = 0.0D;

               for(var15 = 0; var15 < ((List)var6).size(); ++var15) {
                  var13 += ((Reglements)((List)var6).get(var15)).getRglRecette();
                  var7.setDocDateTransfert(((Reglements)((List)var6).get(var15)).getRglDateReg());
               }

               var7.setDocRegTiers(var13);
            }

            this.lesSyntheses.add(var7);
         }
      }

      this.recherchePharmacieSql(var1, var2, var3, var4, var8);
      PharmacieEnteteDao var20 = new PharmacieEnteteDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      List var21 = var20.chargerPharmacieByRequete(this.var_requete_directe, var8);
      if (var21.size() != 0) {
         new PharmacieEntete();

         for(int var14 = 0; var14 < var21.size(); ++var14) {
            PharmacieEntete var22 = (PharmacieEntete)var21.get(var14);
            var7 = new DocumentMedical();
            var7.setDocId(var22.getPhaId());
            var7.setDocNature(73);
            var7.setDocLibelleNature("Pharmacie");
            var7.setDocIdCreateur(var22.getPhaIdCreateur());
            var7.setDocNomCreateur(var22.getPhaNomCreateur());
            var7.setDocNum(var22.getPhaNum());
            var7.setDocDate(this.utilDate.dateToSQLLight(var22.getPhaDate()));
            var7.setDocNomPatient(var22.getPhaNomPatient());
            var7.setDocNomMedecin(this.calculMedecin(var22.getPhaIdMedecin()));
            var7.setDocNomTiersSociete(var22.getPhaNomSociete());
            var7.setDocNomTiersAssurance(var22.getPhaNomAssurance());
            var7.setDocNomTiersComplementaire(var22.getPhaNomComplemtaire());
            var7.setDocService(var22.getPhaService());
            var7.setDocCode("");
            var7.setDocProduit("");
            var7.setDocQte(0.0F);
            var7.setDocTotPatient(var22.getPhaTotPatient());
            var7.setDocTotTiers(var22.getPhaTotAssurance() + (double)var22.getPhaIdComplementaire() + var22.getPhaTotSociete());
            ((List)var6).clear();
            var6 = var5.findRegByNatNum(var7.getDocNature(), var7.getDocNum(), var8);
            if (((List)var6).size() == 0) {
               var7.setDocDateTransfert((Date)null);
               var7.setDocRegTiers(0.0D);
            } else {
               double var25 = 0.0D;

               for(int var17 = 0; var17 < ((List)var6).size(); ++var17) {
                  var25 += ((Reglements)((List)var6).get(var17)).getRglRecette();
                  var7.setDocDateTransfert(((Reglements)((List)var6).get(var17)).getRglDateReg());
               }

               var7.setDocRegTiers(var25);
            }

            this.lesSyntheses.add(var7);
         }
      }

      this.rechercheLaboratoireSql(var1, var2, var3, var4, var8);
      LaboratoireEnteteDao var23 = new LaboratoireEnteteDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      List var24 = var23.chargerLaboratoireByRequete(this.var_requete_directe, var8);
      int var16;
      if (var24.size() != 0) {
         new LaboratoireEntete();

         for(var16 = 0; var16 < var24.size(); ++var16) {
            LaboratoireEntete var26 = (LaboratoireEntete)var24.get(var16);
            var7 = new DocumentMedical();
            var7.setDocId(var26.getLabId());
            var7.setDocNature(74);
            var7.setDocLibelleNature("Laboratoire");
            var7.setDocIdCreateur(var26.getLabIdCreateur());
            var7.setDocNomCreateur(var26.getLabNomCreateur());
            var7.setDocNum(var26.getLabNum());
            var7.setDocDate(this.utilDate.dateToSQLLight(var26.getLabDate()));
            var7.setDocNomPatient(var26.getLabNomPatient());
            var7.setDocNomMedecin(this.calculMedecin(var26.getLabIdMedecin()));
            var7.setDocNomTiersSociete(var26.getLabNomSociete());
            var7.setDocNomTiersAssurance(var26.getLabNomAssurance());
            var7.setDocNomTiersComplementaire(var26.getLabNomComplemtaire());
            var7.setDocService(var26.getLabLaboratoire());
            var7.setDocCode("");
            var7.setDocProduit("");
            var7.setDocQte(0.0F);
            var7.setDocTotPatient(var26.getLabTotPatient());
            var7.setDocTotTiers(var26.getLabTotAssurance() + var26.getLabTotComplmentaire() + var26.getLabTotSociete());
            ((List)var6).clear();
            var6 = var5.findRegByNatNum(var7.getDocNature(), var7.getDocNum(), var8);
            if (((List)var6).size() == 0) {
               var7.setDocDateTransfert((Date)null);
               var7.setDocRegTiers(0.0D);
            } else {
               double var29 = 0.0D;

               for(int var19 = 0; var19 < ((List)var6).size(); ++var19) {
                  var29 += ((Reglements)((List)var6).get(var19)).getRglRecette();
                  var7.setDocDateTransfert(((Reglements)((List)var6).get(var19)).getRglDateReg());
               }

               var7.setDocRegTiers(var29);
            }

            this.lesSyntheses.add(var7);
         }
      }

      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Activités méducales du " + var1 + " au " + var2 + " Série : Toutes";
      } else {
         this.var_entete = "Activités médicales du " + var1 + " au " + var2 + " Série : " + this.serie;
      }

      this.var_filtre = "";
      if (this.etat != null && !this.etat.isEmpty() && !this.etat.equals("100")) {
         var15 = Integer.parseInt(this.etat);
         if (var15 == 0) {
            this.var_filtre = this.var_filtre + " Etat = En cours";
         } else if (var15 == 1) {
            this.var_filtre = this.var_filtre + " Etat = Validé ou Controlé ou Refacturé";
         } else if (var15 == 2) {
            this.var_filtre = this.var_filtre + " Etat = Gelé";
         } else if (var15 == 3) {
            this.var_filtre = this.var_filtre + " Etat = Annulé";
         } else if (var15 == 5) {
            this.var_filtre = this.var_filtre + " Etat = Controle";
         } else if (var15 == 13) {
            this.var_filtre = this.var_filtre + " Etat = Non payé Patient";
         } else if (var15 == 14) {
            this.var_filtre = this.var_filtre + " Etat = Payé Patient";
         } else if (var15 == 15) {
            this.var_filtre = this.var_filtre + " Etat = Non payé Tiers";
         } else if (var15 == 16) {
            this.var_filtre = this.var_filtre + " Etat = Payé Tiers";
         }
      }

      if (this.idTiers != 0L) {
         if (this.nomTiers != null && !this.nomTiers.isEmpty() && this.nomTiers.equalsIgnoreCase("CNAMGS")) {
            this.var_filtre = this.var_filtre + " Tiers payeur = CNAMGS";
         } else {
            this.var_filtre = this.var_filtre + " Tiers payeur = " + this.nomTiers;
         }
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
      }

      if (this.medecin != 0L) {
         String var27 = "";

         for(var16 = 0; var16 < this.mesMedecinsItems.size(); ++var16) {
            if (Long.parseLong(((SelectItem)this.mesMedecinsItems.get(var16)).getValue().toString()) == this.medecin) {
               var27 = ((SelectItem)this.mesMedecinsItems.get(var16)).getLabel().toString();
            }
         }

         this.var_filtre = this.var_filtre + " Medecin = " + var27;
      }

      if (this.createur != null && !this.createur.isEmpty() && !this.createur.equals("100")) {
         UserDao var30 = new UserDao(this.baseLog, this.utilInitHibernate);
         String var28 = var30.selectByIdUsers(Long.parseLong(this.createur), var8).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Créateur = " + var28;
      }

      if (this.typeTiers != 100) {
         if (this.typeTiers == 1) {
            this.var_filtre = this.var_filtre + " Type = Assurances";
         } else if (this.typeTiers == 2) {
            this.var_filtre = this.var_filtre + " Type = Sociétés";
         } else if (this.typeTiers == 3) {
            this.var_filtre = this.var_filtre + " Type = Complémentaires";
         } else if (this.typeTiers == 4) {
            this.var_filtre = this.var_filtre + " Type = CNAMGS";
         }
      }

      this.utilInitHibernate.closeSession();
   }

   public void rechercheDevisSql(String var1, String var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Liste des Devis du " + var1 + " au " + var2 + " Série : Toutes";
         this.var_requete = "dvs_date>='" + var3 + "' and dvs_date<='" + var4 + "'";
      } else {
         this.var_entete = "Liste des Devis du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "dvs_date>='" + var3 + "' and dvs_date<='" + var4 + "' and dvs_serie='" + this.serie + "'";
      }

      if (this.etat != null && !this.etat.isEmpty() && !this.etat.equals("100")) {
         int var6 = Integer.parseInt(this.etat);
         if (var6 == 0) {
            this.var_filtre = this.var_filtre + " Etat = En cours";
            this.var_requete = this.var_requete + " and dvs_etat=" + var6;
         } else if (var6 == 1) {
            this.var_filtre = this.var_filtre + " Etat = Validé";
            this.var_requete = this.var_requete + " and dvs_etat=" + var6;
         } else if (var6 == 2) {
            this.var_filtre = this.var_filtre + " Etat = Gelé";
            this.var_requete = this.var_requete + " and dvs_etat=" + var6;
         } else if (var6 == 3) {
            this.var_filtre = this.var_filtre + " Etat = Annulé";
            this.var_requete = this.var_requete + " and dvs_etat=" + var6;
         } else if (var6 == 4) {
            this.var_filtre = this.var_filtre + " Etat = Transformation patielle";
            this.var_requete = this.var_requete + " and dvs_etat=" + var6;
         } else if (var6 == 5) {
            this.var_filtre = this.var_filtre + " Etat = Transformation totale";
            this.var_requete = this.var_requete + " and dvs_etat=" + var6;
         } else if (var6 == 11) {
            this.var_filtre = this.var_filtre + " Etat = Relancé";
            this.var_requete = this.var_requete + " and dvs_date_relance!=null";
         } else if (var6 == 12) {
            this.var_filtre = this.var_filtre + " Etat = Promotion";
            this.var_requete = this.var_requete + " and dvs_tot_ht=0";
         } else if (var6 == 13) {
            this.var_filtre = this.var_filtre + " Etat = Non payé";
            this.var_requete = this.var_requete + " and dvs_solde=0";
         } else if (var6 == 14) {
            this.var_filtre = this.var_filtre + " Etat = Payé";
            this.var_requete = this.var_requete + " and dvs_solde=1";
         } else if (var6 == 15) {
            this.var_filtre = this.var_filtre + " Etat = Exonéré";
            this.var_requete = this.var_requete + " and dvs_exo_tva=1";
         }
      }

      if (this.nomTiers != null && !this.nomTiers.isEmpty()) {
         this.var_filtre = this.var_filtre + " Société = " + this.nomTiers;
         this.var_requete = this.var_requete + " and dvs_nom_tier='" + this.nomTiers + "'";
      }

      if (this.nomSigle != null && !this.nomSigle.isEmpty()) {
         this.var_filtre = this.var_filtre + " Sigle/Appartenance = " + this.nomSigle;
         this.var_requete = this.var_requete + " and cmm_tiers.tie_sigle like '" + this.nomSigle + "%'";
      }

      if (this.nomDestinataire != null && !this.nomDestinataire.isEmpty()) {
         if (this.structureLog.getStrtypeContact() == 2) {
            this.var_filtre = this.var_filtre + " Destinataire = " + this.nomDestinataire;
            this.var_requete = this.var_requete + " and dvs_nom_contact='" + this.nomDestinataire + "'";
         } else {
            this.var_filtre = this.var_filtre + " Contact = " + this.nomDestinataire;
            this.var_requete = this.var_requete + " and dvs_nom_contact like '" + this.nomDestinataire + "%'";
         }
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_filtre = this.var_filtre + " Activité = " + this.activite;
         this.var_requete = this.var_requete + " and dvs_activite='" + this.activite + "'";
      }

      if (this.dossier != null && !this.dossier.isEmpty() && this.dossier.contains(":")) {
         this.var_filtre = this.var_filtre + " Dossier = " + this.dossier;
         this.var_requete = this.var_requete + " and dvs_anal4='" + this.dossier + "'";
      }

      if (this.parc != null && !this.parc.isEmpty()) {
         this.var_filtre = this.var_filtre + " Parc = " + this.parc;
         this.var_requete = this.var_requete + " and dvs_anal2='" + this.parc + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and dvs_service='" + this.service + "'";
      }

      if (this.categorie != null && !this.categorie.isEmpty() && !this.categorie.equals("100")) {
         this.var_filtre = this.var_filtre + " Catégorie = " + this.categorie;
         this.var_requete = this.var_requete + " and dvs_cat='" + this.categorie + "'";
      }

      String var7;
      UserDao var8;
      if (this.responsable != null && !this.responsable.isEmpty() && !this.responsable.equals("100")) {
         var8 = new UserDao(this.baseLog, this.utilInitHibernate);
         var7 = var8.selectByIdUsers(Long.parseLong(this.responsable), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Responsable = " + var7;
         this.var_requete = this.var_requete + " and dvs_id_responsable=" + this.responsable;
      }

      if (this.commercial != null && !this.commercial.isEmpty() && !this.commercial.equals("100")) {
         var8 = new UserDao(this.baseLog, this.utilInitHibernate);
         var7 = var8.selectByIdUsers(Long.parseLong(this.commercial), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Commercial = " + var7;
         this.var_requete = this.var_requete + " and dvs_id_commercial=" + this.commercial;
      }

      if (this.createur != null && !this.createur.isEmpty() && !this.createur.equals("100")) {
         var8 = new UserDao(this.baseLog, this.utilInitHibernate);
         var7 = var8.selectByIdUsers(Long.parseLong(this.createur), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Créateur = " + var7;
         this.var_requete = this.var_requete + " and dvs_id_createur=" + this.createur;
      }

      if (this.nomRepertoire.equalsIgnoreCase("ligne_devis")) {
         if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
            this.var_filtre = this.var_filtre + " du Produit = " + this.produitDebut;
            this.var_requete = this.var_requete + " and dvslig_code>='" + this.produitDebut + "'";
         }

         if (this.produitFin != null && !this.produitFin.isEmpty()) {
            this.var_filtre = this.var_filtre + " au Produit = " + this.produitFin;
            this.var_requete = this.var_requete + " and dvslig_code<='" + this.produitFin + "'";
         }

         if (this.famille != null && !this.famille.isEmpty() && this.famille.contains(":")) {
            this.var_filtre = this.var_filtre + " famille = " + this.famille;
            String[] var9 = this.famille.split(":");
            this.var_requete = this.var_requete + " and dvslig_famille like'" + var9[0] + "%'";
         }
      }

   }

   public void rechercheConsultationGeneSql(String var1, String var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      this.var_filtre = "";
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Liste des Consultations du " + var1 + " au " + var2 + " Série : Toutes";
         this.var_requete = "med_consultation_entete_gene.csg_date>='" + var3 + "' and med_consultation_entete_gene.csg_date<='" + var4 + "'";
         this.var_requete_hql = "ConsultationEnteteGene.csgDate>='" + var3 + "' and ConsultationEnteteGene.csgDate<='" + var4 + "'";
         this.var_requete_directe = "csgDate>='" + var3 + "' and csgDate<='" + var4 + "'";
      } else {
         this.var_entete = "Liste des Consultations du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "med_consultation_entete_gene.csg_date>='" + var3 + "' and med_consultation_entete_gene.csg_date<='" + var4 + "' and med_consultation_entete_gene.csg_serie='" + this.serie + "'";
         this.var_requete_hql = "ConsultationEnteteGene.csgDate>='" + var3 + "' and ConsultationEnteteGene.csgDate<='" + var4 + "' and ConsultationEnteteGene.csgSerie='" + this.serie + "'";
         this.var_requete_directe = "csgDate>='" + var3 + "' and csgDate<='" + var4 + "' and csgSerie='" + this.serie + "'";
      }

      if (this.etat != null && !this.etat.isEmpty() && !this.etat.equals("100")) {
         int var6 = Integer.parseInt(this.etat);
         if (var6 == 0) {
            this.var_filtre = this.var_filtre + " Etat = En cours";
            this.var_requete = this.var_requete + " and med_consultation_entete_gene.csg_etat=" + var6;
            this.var_requete_hql = this.var_requete_hql + " and ConsultationEnteteGene.csgEtat=" + var6;
            this.var_requete_directe = this.var_requete_directe + " and csgEtat=" + var6;
         } else if (var6 == 1) {
            this.var_filtre = this.var_filtre + " Etat = Validé";
            this.var_requete = this.var_requete + " and med_consultation_entete_gene.csg_etat=" + var6;
            this.var_requete_hql = this.var_requete_hql + " and ConsultationEnteteGene.csgEtat=" + var6;
            this.var_requete_directe = this.var_requete_directe + " and csgEtat=" + var6;
         } else if (var6 == 2) {
            this.var_filtre = this.var_filtre + " Etat = Gelé";
            this.var_requete = this.var_requete + " and med_consultation_entete_gene.csg_etat=" + var6;
            this.var_requete_hql = this.var_requete_hql + " and ConsultationEnteteGene.csgEtat=" + var6;
            this.var_requete_directe = this.var_requete_directe + " and csgEtat=" + var6;
         } else if (var6 == 3) {
            this.var_filtre = this.var_filtre + " Etat = Annulé";
            this.var_requete = this.var_requete + " and med_consultation_entete_gene.csg_etat=" + var6;
            this.var_requete_hql = this.var_requete_hql + " and ConsultationEnteteGene.csgEtat=" + var6;
            this.var_requete_directe = this.var_requete_directe + " and csgEtat=" + var6;
         } else if (var6 == 5) {
            this.var_filtre = this.var_filtre + " Etat = Controle";
            this.var_requete = this.var_requete + " and med_consultation_entete_gene.csg_etat=" + var6;
            this.var_requete_hql = this.var_requete_hql + " and ConsultationEnteteGene.csgEtat=" + var6;
            this.var_requete_directe = this.var_requete_directe + " and csgEtat=" + var6;
         } else if (var6 == 13) {
            this.var_filtre = this.var_filtre + " Etat = Non payé Patient";
            this.var_requete = this.var_requete + " and med_consultation_entete_gene.csg_solde_patient=0";
            this.var_requete_hql = this.var_requete_hql + " and ConsultationEnteteGene.csgSoldePatient=0";
            this.var_requete_directe = this.var_requete_directe + " and csgSoldePatient=0";
         } else if (var6 == 14) {
            this.var_filtre = this.var_filtre + " Etat = Payé Patient";
            this.var_requete = this.var_requete + " and med_consultation_entete_gene.csg_solde_patient=1";
            this.var_requete_hql = this.var_requete_hql + " and ConsultationEnteteGene.csgSoldePatient=1";
            this.var_requete_directe = this.var_requete_directe + " and csgSoldePatient=1";
         } else if (var6 == 15) {
            this.var_filtre = this.var_filtre + " Etat = Non payé Tiers";
            this.var_requete = this.var_requete + " and med_consultation_entete_gene.csg_solde_tiers=0";
            this.var_requete_hql = this.var_requete_hql + " and ConsultationEnteteGene.csgSoldeTiers=0";
            this.var_requete_directe = this.var_requete_directe + " and csgSoldeTiers=0";
         } else if (var6 == 16) {
            this.var_filtre = this.var_filtre + " Etat = Payé Tiers";
            this.var_requete = this.var_requete + " and med_consultation_entete_gene.csg_solde_tiers=1";
            this.var_requete_hql = this.var_requete_hql + " and ConsultationEnteteGene.csgSoldeTiers=1";
            this.var_requete_directe = this.var_requete_directe + " and csgSoldeTiers=1";
         } else if (var6 == 17) {
            this.var_filtre = this.var_filtre + " Etat = Transféré en compta";
            this.var_requete = this.var_requete + " and med_consultation_entete_gene.csg_date_transfert is not null";
            this.var_requete_hql = this.var_requete_hql + " and ConsultationEnteteGene.csgDateTransfert is not null";
            this.var_requete_directe = this.var_requete_directe + " and csgEtat=" + var6;
         } else if (var6 == 18) {
            this.var_filtre = this.var_filtre + " Etat = Non transféré en compta";
            this.var_requete = this.var_requete + " and med_consultation_entete_gene.csg_date_transfert is null";
            this.var_requete_hql = this.var_requete_hql + " and ConsultationEnteteGene.csgDateTransfert is null";
            this.var_requete_directe = this.var_requete_directe + " and csgDateTransfert is null";
         } else if (var6 == 19) {
            this.var_filtre = this.var_filtre + " Etat = Validé ou Contrôlé";
            this.var_requete = this.var_requete + " and (med_consultation_entete_gene.csg_etat=1 or med_consultation_entete_gene.csg_etat=5)";
            this.var_requete_hql = this.var_requete_hql + " and (ConsultationEnteteGene.csgEtat=1 or ConsultationEnteteGene.csgEtat=5)";
            this.var_requete_directe = this.var_requete_directe + " and (csgEtat=1 or csgEtat=5)";
         } else if (var6 == 20) {
            this.var_filtre = this.var_filtre + " Etat = Validé, Contrôlé, Cloturé ou Refacturé";
            this.var_requete = this.var_requete + " and (med_consultation_entete_gene.csg_etat=1 or med_consultation_entete_gene.csg_etat=5 or med_consultation_entete_gene.csg_etat=6 or med_consultation_entete_gene.csg_etat=7)";
            this.var_requete_hql = this.var_requete_hql + " and (ConsultationEnteteGene.csgEtat=1 or ConsultationEnteteGene.csgEtat=5 or ConsultationEnteteGene.csgEtat=6 or ConsultationEnteteGene.csgEtat=7)";
            this.var_requete_directe = this.var_requete_directe + " and (csgEtat=1 or csgEtat=5 or csgEtat=6 or csgEtat=7)";
         } else if (var6 == 21) {
            this.var_filtre = this.var_filtre + " Etat = En cours ou validé (Infirmerie)";
            this.var_requete = this.var_requete + " and (med_consultation_entete_gene.csg_etat=0 or med_consultation_entete_gene.csg_etat=1)";
            this.var_requete_hql = this.var_requete_hql + " and (ConsultationEnteteGene.csgEtat=0 or ConsultationEnteteGene.csgEtat=1)";
            this.var_requete_directe = this.var_requete_directe + " and (csgEtat=0 or csgEtat=1)";
         }
      }

      if (this.idTiers != 0L) {
         if (this.nomTiers != null && !this.nomTiers.isEmpty() && this.nomTiers.equalsIgnoreCase("CNAMGS")) {
            this.var_filtre = this.var_filtre + " Tiers payeur = CNAMGS";
            this.var_requete = this.var_requete + " and med_consultation_entete_gene.csg_pec_cnamgs<>0";
            this.var_requete_hql = this.var_requete_hql + " and ConsultationEnteteGene.csgPecCnamgs<>0";
            this.var_requete_directe = this.var_requete_directe + " and csgPecCnamgs<>0";
         } else {
            this.var_filtre = this.var_filtre + " Tiers payeur = " + this.nomTiers;
            this.var_requete = this.var_requete + " and (med_consultation_entete_gene.csg_id_assurance=" + this.idTiers + " or med_consultation_entete_gene.csg_id_societe=" + this.idTiers + " or med_consultation_entete_gene.csg_id_complementaire=" + this.idTiers + ")";
            this.var_requete_hql = this.var_requete_hql + " and (ConsultationEnteteGene.csgIdAssurance=" + this.idTiers + " or ConsultationEnteteGene.csgIdSociete=" + this.idTiers + " or ConsultationEnteteGene.csgIdComplementaire=" + this.idTiers + ")";
            this.var_requete_directe = this.var_requete_directe + " and (csgIdAssurance=" + this.idTiers + " or csgIdSociete=" + this.idTiers + " or csgIdComplementaire=" + this.idTiers + ")";
         }
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and med_consultation_entete_gene.csg_service='" + this.service + "'";
         this.var_requete_hql = this.var_requete_hql + " and ConsultationEnteteGene.csgService='" + this.service + "'";
         this.var_requete_directe = this.var_requete_directe + " and csgService='" + this.service + "'";
      }

      if (this.medecin != 0L) {
         String var8 = "";

         for(int var7 = 0; var7 < this.mesMedecinsItems.size(); ++var7) {
            if (Long.parseLong(((SelectItem)this.mesMedecinsItems.get(var7)).getValue().toString()) == this.medecin) {
               var8 = ((SelectItem)this.mesMedecinsItems.get(var7)).getLabel().toString();
            }
         }

         this.var_filtre = this.var_filtre + " Medecin = " + var8;
         this.var_requete = this.var_requete + " and med_consultation_entete_gene.csg_id_medecin=" + this.medecin;
         this.var_requete_hql = this.var_requete_hql + " and ConsultationEnteteGene.csgIdMedecin=" + this.medecin;
         this.var_requete_directe = this.var_requete_directe + " and csgIdMedecin=" + this.medecin;
      }

      if (this.createur != null && !this.createur.isEmpty() && !this.createur.equals("100")) {
         UserDao var9 = new UserDao(this.baseLog, this.utilInitHibernate);
         String var10 = var9.selectByIdUsers(Long.parseLong(this.createur), var5).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Créateur = " + var10;
         this.var_requete = this.var_requete + " and med_consultation_entete_gene.csg_id_createur=" + this.createur;
         this.var_requete_hql = this.var_requete_hql + " and ConsultationEnteteGene.csgIdCreateur=" + this.createur;
         this.var_requete_directe = this.var_requete_directe + " and csgIdCreateur=" + this.createur;
      }

      if (this.typeTiers != 100) {
         if (this.typeTiers == 1) {
            this.var_filtre = this.var_filtre + " Type = Assurances";
            this.var_requete = this.var_requete + " and med_consultation_entete_gene.csg_id_assurance<>0";
            this.var_requete_hql = this.var_requete_hql + " and ConsultationEnteteGene.csgIdAssurance<>0";
            this.var_requete_directe = this.var_requete_directe + " and csgIdAssurance<>0";
         } else if (this.typeTiers == 2) {
            this.var_filtre = this.var_filtre + " Type = Sociétés";
            this.var_requete = this.var_requete + " and med_consultation_entete_gene.csg_id_societe<>0";
            this.var_requete_hql = this.var_requete_hql + " and ConsultationEnteteGene.csgIdSociete<>0";
            this.var_requete_directe = this.var_requete_directe + " and csgIdSociete<>0";
         } else if (this.typeTiers == 3) {
            this.var_filtre = this.var_filtre + " Type = Complémentaires";
            this.var_requete = this.var_requete + " and med_consultation_entete_gene.csg_id_complementaire<>0";
            this.var_requete_hql = this.var_requete_hql + " and ConsultationEnteteGene.csgIdComplementaire<>0";
            this.var_requete_directe = this.var_requete_directe + " and csgIdComplementaire<>0";
         } else if (this.typeTiers == 4) {
            this.var_filtre = this.var_filtre + " Type = CNMAGS";
            this.var_requete = this.var_requete + " and med_consultation_entete_gene.csg_pec_cnamgs<>0";
            this.var_requete_hql = this.var_requete_hql + " and ConsultationEnteteGene.csgPecCnamgs<>0";
            this.var_requete_directe = this.var_requete_directe + " and csgPecCnamgs<>0";
         }
      }

   }

   public void rechercheConsultationSpeSql(String var1, String var2, String var3, String var4, Session var5) {
   }

   public void recherchePharmacieSql(String var1, String var2, String var3, String var4, Session var5) throws NamingException {
      this.var_filtre = "";
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Liste des Produits Pharmaceutiques du " + var1 + " au " + var2 + " Série : Toutes";
         this.var_requete = "med_pharmacie_entete.pha_date>='" + var3 + "' and med_pharmacie_entete.pha_date<='" + var4 + "'";
         this.var_requete_hql = "pharmacieEntete.phaDate>='" + var3 + "' and pharmacieEntete.phaDate<='" + var4 + "'";
         this.var_requete_directe = "phaDate>='" + var3 + "' and phaDate<='" + var4 + "'";
      } else {
         this.var_entete = "Liste des Produits Pharmaceutiques du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "med_pharmacie_entete.pha_date>='" + var3 + "' and med_pharmacie_entete.pha_date<='" + var4 + "' and med_pharmacie_entete.pha_serie='" + this.serie + "'";
         this.var_requete_hql = "pharmacieEntete.phaDate>='" + var3 + "' and pharmacieEntete.phaDate<='" + var4 + "' and pharmacieEntete.phaSerie='" + this.serie + "'";
         this.var_requete_directe = "phaDate>='" + var3 + "' and phaDate<='" + var4 + "' and phaSerie='" + this.serie + "'";
      }

      if (this.etat != null && !this.etat.isEmpty() && !this.etat.equals("100")) {
         int var6 = Integer.parseInt(this.etat);
         if (var6 == 0) {
            this.var_filtre = this.var_filtre + " Etat = En cours";
            this.var_requete = this.var_requete + " and med_pharmacie_entete.pha_etat=" + var6;
            this.var_requete_hql = this.var_requete_hql + " and pharmacieEntete.phaEtat=" + var6;
            this.var_requete_directe = this.var_requete_directe + " and phaEtat=" + var6;
         } else if (var6 == 1) {
            this.var_filtre = this.var_filtre + " Etat = Validé";
            this.var_requete = this.var_requete + " and med_pharmacie_entete.pha_etat=" + var6;
            this.var_requete_hql = this.var_requete_hql + " and pharmacieEntete.phaEtat=" + var6;
            this.var_requete_directe = this.var_requete_directe + " and phaEtat=" + var6;
         } else if (var6 == 2) {
            this.var_filtre = this.var_filtre + " Etat = Gelé";
            this.var_requete = this.var_requete + " and med_pharmacie_entete.pha_etat=" + var6;
            this.var_requete_hql = this.var_requete_hql + " and pharmacieEntete.phaEtat=" + var6;
            this.var_requete_directe = this.var_requete_directe + " and phaEtat=" + var6;
         } else if (var6 == 3) {
            this.var_filtre = this.var_filtre + " Etat = Annulé";
            this.var_requete = this.var_requete + " and med_pharmacie_entete.pha_etat=" + var6;
            this.var_requete_hql = this.var_requete_hql + " and pharmacieEntete.phaEtat=" + var6;
            this.var_requete_directe = this.var_requete_directe + " and phaEtat=" + var6;
         } else if (var6 == 5) {
            this.var_filtre = this.var_filtre + " Etat = Refacturée";
            this.var_requete = this.var_requete + " and med_pharmacie_entete.pha_etat=" + var6;
            this.var_requete_hql = this.var_requete_hql + " and pharmacieEntete.phaEtat=" + var6;
            this.var_requete_directe = this.var_requete_directe + " and phaEtat=" + var6;
         } else if (var6 == 13) {
            this.var_filtre = this.var_filtre + " Etat = Non payé Patient";
            this.var_requete = this.var_requete + " and med_pharmacie_entete.pha_solde_patient=0";
            this.var_requete_hql = this.var_requete_hql + " and pharmacieEntete.phaSoldePatient=0";
            this.var_requete_directe = this.var_requete_directe + " and pharmacieEntete.phaSoldePatient=0";
         } else if (var6 == 14) {
            this.var_filtre = this.var_filtre + " Etat = Payé Patient";
            this.var_requete = this.var_requete + " and med_pharmacie_entete.pha_solde_patient=1";
            this.var_requete_hql = this.var_requete_hql + " and pharmacieEntete.phaSoldePatient=1";
            this.var_requete_directe = this.var_requete_directe + " and phaSoldePatient=1";
         } else if (var6 == 15) {
            this.var_filtre = this.var_filtre + " Etat = Non payé Tiers";
            this.var_requete = this.var_requete + " and med_pharmacie_entete.pha_solde_tiers=0";
            this.var_requete_hql = this.var_requete_hql + " and pharmacieEntete.phaSoldeTiers=0";
            this.var_requete_directe = this.var_requete_directe + " and phaSoldeTiers=0";
         } else if (var6 == 16) {
            this.var_filtre = this.var_filtre + " Etat = Payé Tiers";
            this.var_requete = this.var_requete + " and med_pharmacie_entete.pha_solde_tiers=1";
            this.var_requete_hql = this.var_requete_hql + " and pharmacieEntete.phaSoldeTiers=1";
            this.var_requete_directe = this.var_requete_directe + " and phaSoldeTiers=1";
         } else if (var6 == 17) {
            this.var_filtre = this.var_filtre + " Etat = Transféré en compta";
            this.var_requete = this.var_requete + " and med_pharmacie_entete.pha_date_transfert is not null";
            this.var_requete_hql = this.var_requete_hql + " and pharmacieEntete.phaDateTransfert is not null";
            this.var_requete_directe = this.var_requete_directe + " and phaDateTransfert is not null";
         } else if (var6 == 18) {
            this.var_filtre = this.var_filtre + " Etat = Non transféré en compta";
            this.var_requete = this.var_requete + " and med_pharmacie_entete.pha_date_transfert is null";
            this.var_requete_hql = this.var_requete_hql + " and pharmacieEntete.phaDateTransfert is null";
            this.var_requete_directe = this.var_requete_directe + " and phaDateTransfert is null";
         } else if (var6 == 19) {
            this.var_filtre = this.var_filtre + " Etat = Validé et Contrôlé";
            this.var_requete = this.var_requete + " and (med_pharmacie_entete.pha_etat=1 or med_pharmacie_entete.pha_etat=5)";
            this.var_requete_hql = this.var_requete_hql + " and (pharmacieEntete.phaEtat=1 or pharmacieEntete.phaEtat=5)";
            this.var_requete_directe = this.var_requete_directe + " and (phaEtat=1 or phaEtat=5)";
         } else if (var6 == 20) {
            this.var_filtre = this.var_filtre + " Etat = Validé, Contrôlé, Cloturé ou Refacturé";
            this.var_requete = this.var_requete + " and (med_pharmacie_entete.pha_etat=1 or med_pharmacie_entete.pha_etat=5 or med_pharmacie_entete.pha_etat=6 or med_pharmacie_entete.pha_etat=7)";
            this.var_requete_hql = this.var_requete_hql + " and (pharmacieEntete.phaEtat=1 or pharmacieEntete.phaEtat=5 or pharmacieEntete.phaEtat=6 or pharmacieEntete.phaEtat=7)";
            this.var_requete_directe = this.var_requete_directe + " and (phaEtat=1 or phaEtat=5 or phaEtat=6 or phaEtat=7)";
         }
      }

      if (this.idTiers != 0L) {
         if (this.nomTiers != null && !this.nomTiers.isEmpty() && this.nomTiers.equalsIgnoreCase("CNAMGS")) {
            this.var_filtre = this.var_filtre + " Tiers payeur = CNAMGS";
            this.var_requete = this.var_requete + " and med_pharmacie_entete.pha_pec_cnamgs<>0";
            this.var_requete_hql = this.var_requete_hql + " and pharmacieEntete.phaPecCnamgs<>0";
            this.var_requete_directe = this.var_requete_directe + " and phaPecCnamgs<>0";
         } else {
            this.var_filtre = this.var_filtre + " Tiers payeur = " + this.nomTiers;
            this.var_requete = this.var_requete + " and (med_pharmacie_entete.pha_id_assurance=" + this.idTiers + " or med_pharmacie_entete.pha_id_societe=" + this.idTiers + " or med_pharmacie_entete.pha_id_complementaire=" + this.idTiers + ")";
            this.var_requete_hql = this.var_requete_hql + " and (pharmacieEntete.phaIdAssurance=" + this.idTiers + " or pharmacieEntete.phaIdSociete=" + this.idTiers + " or pharmacieEntete.phaIdComplementaire=" + this.idTiers + ")";
            this.var_requete_directe = this.var_requete_directe + " and (phaIdAssurance=" + this.idTiers + " or phaIdSociete=" + this.idTiers + " or phaIdComplementaire=" + this.idTiers + ")";
         }
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and med_pharmacie_entete.pha_service='" + this.service + "'";
         this.var_requete_hql = this.var_requete_hql + " and pharmacieEntete.phaService='" + this.service + "'";
         this.var_requete_directe = this.var_requete_directe + " and phaService='" + this.service + "'";
      }

      if (this.medecin != 0L) {
         String var8 = "";

         for(int var7 = 0; var7 < this.mesMedecinsItems.size(); ++var7) {
            if (Long.parseLong(((SelectItem)this.mesMedecinsItems.get(var7)).getValue().toString()) == this.medecin) {
               var8 = ((SelectItem)this.mesMedecinsItems.get(var7)).getLabel().toString();
            }
         }

         this.var_filtre = this.var_filtre + " Medecin = " + var8;
         this.var_requete = this.var_requete + " and med_pharmacie_entete.pha_id_medecin=" + this.medecin;
         this.var_requete_hql = this.var_requete_hql + " and pharmacieEntete.phaIdMedecin=" + this.medecin;
         this.var_requete_directe = this.var_requete_directe + " and phaIdMedecin=" + this.medecin;
      }

      if (this.createur != null && !this.createur.isEmpty() && !this.createur.equals("100")) {
         UserDao var9 = new UserDao(this.baseLog, this.utilInitHibernate);
         String var10 = var9.selectByIdUsers(Long.parseLong(this.createur), var5).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Créateur = " + var10;
         this.var_requete = this.var_requete + " and med_pharmacie_entete.pha_id_createur=" + this.createur;
         this.var_requete_hql = this.var_requete_hql + " and pharmacieEntete.phaIdCreateur=" + this.createur;
         this.var_requete_directe = this.var_requete_directe + " and phaIdCreateur=" + this.createur;
      }

      if (this.typeTiers != 100) {
         if (this.typeTiers == 1) {
            this.var_filtre = this.var_filtre + " Type = Assurances";
            this.var_requete = this.var_requete + " and med_pharmacie_entete.pha_id_assurance<>0";
            this.var_requete_hql = this.var_requete_hql + " and pharmacieEntete.phaIdAssurance<>0";
            this.var_requete_directe = this.var_requete_directe + " and phaIdAssurance<>0";
         } else if (this.typeTiers == 2) {
            this.var_filtre = this.var_filtre + " Type = Sociétés";
            this.var_requete = this.var_requete + " and med_pharmacie_entete.pha_id_societe<>0";
            this.var_requete_hql = this.var_requete_hql + " and pharmacieEntete.phaIdSociete<>0";
            this.var_requete_directe = this.var_requete_directe + " and phaIdSociete<>0";
         } else if (this.typeTiers == 3) {
            this.var_filtre = this.var_filtre + " Type = Complémentaires";
            this.var_requete = this.var_requete + " and med_pharmacie_entete.pha_id_complementaire<>0";
            this.var_requete_hql = this.var_requete_hql + " and pharmacieEntete.phaIdComplementaire<>0";
            this.var_requete_directe = this.var_requete_directe + " and phaIdComplementaire<>0";
         } else if (this.typeTiers == 4) {
            this.var_filtre = this.var_filtre + " Type = CNAMGS";
            this.var_requete = this.var_requete + " and med_pharmacie_entete.pha_pec_cnamgs<>0";
            this.var_requete_hql = this.var_requete_hql + " and pharmacieEntete.phaPecCnamgs<>0";
            this.var_requete_directe = this.var_requete_directe + " and phaPecCnamgs<>0";
         }
      }

   }

   public void rechercheLaboratoireSql(String var1, String var2, String var3, String var4, Session var5) throws NamingException {
      this.var_filtre = "";
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Liste des Examens de Laboratoires du " + var1 + " au " + var2 + " Série : Toutes";
         this.var_requete = "med_laboratoire_entete.lab_date>='" + var3 + "' and med_laboratoire_entete.lab_date<='" + var4 + "'";
         this.var_requete_hql = "laboratoireEntete.labDate>='" + var3 + "' and laboratoireEntete.labDate<='" + var4 + "'";
         this.var_requete_directe = "labDate>='" + var3 + "' and labDate<='" + var4 + "'";
      } else {
         this.var_entete = "Liste des Examens de Laboratoires du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "med_laboratoire_entete.lab_date>='" + var3 + "' and med_laboratoire_entete.lab_date<='" + var4 + "' and med_laboratoire_entete.lab_serie='" + this.serie + "'";
         this.var_requete_hql = "laboratoireEntete.labDate>='" + var3 + "' and laboratoireEntete.labDate<='" + var4 + "' and laboratoireEntete.labSerie='" + this.serie + "'";
         this.var_requete_directe = "labDate>='" + var3 + "' and labDate<='" + var4 + "' and labSerie='" + this.serie + "'";
      }

      if (this.etat != null && !this.etat.isEmpty() && !this.etat.equals("100")) {
         int var6 = Integer.parseInt(this.etat);
         if (var6 == 0) {
            this.var_filtre = this.var_filtre + " Etat = En cours";
            this.var_requete = this.var_requete + " and med_laboratoire_entete.lab_etat=" + var6;
            this.var_requete_hql = this.var_requete_hql + " and laboratoireEntete.labEtat=" + var6;
            this.var_requete_directe = this.var_requete_directe + " and labEtat=" + var6;
         } else if (var6 == 1) {
            this.var_filtre = this.var_filtre + " Etat = Validé";
            this.var_requete = this.var_requete + " and med_laboratoire_entete.lab_etat=" + var6;
            this.var_requete_hql = this.var_requete_hql + " and laboratoireEntete.labEtat=" + var6;
            this.var_requete_directe = this.var_requete_directe + " and labEtat=" + var6;
         } else if (var6 == 2) {
            this.var_filtre = this.var_filtre + " Etat = Gelé";
            this.var_requete = this.var_requete + " and med_laboratoire_entete.lab_etat=" + var6;
            this.var_requete_hql = this.var_requete_hql + " and laboratoireEntete.labEtat=" + var6;
            this.var_requete_directe = this.var_requete_directe + " and labEtat=" + var6;
         } else if (var6 == 3) {
            this.var_filtre = this.var_filtre + " Etat = Annulé";
            this.var_requete = this.var_requete + " and med_laboratoire_entete.lab_etat=" + var6;
            this.var_requete_hql = this.var_requete_hql + " and laboratoireEntete.labEtat=" + var6;
            this.var_requete_directe = this.var_requete_directe + " and labEtat=" + var6;
         } else if (var6 == 4) {
            this.var_filtre = this.var_filtre + " Etat = Cloturé";
            this.var_requete = this.var_requete + " and med_laboratoire_entete.lab_etat=" + var6;
            this.var_requete_hql = this.var_requete_hql + " and laboratoireEntete.labEtat=" + var6;
            this.var_requete_directe = this.var_requete_directe + " and labEtat=" + var6;
         } else if (var6 == 5) {
            this.var_filtre = this.var_filtre + " Etat = Refacturée";
            this.var_requete = this.var_requete + " and med_laboratoire_entete.lab_etat=" + var6;
            this.var_requete_hql = this.var_requete_hql + " and laboratoireEntete.labEtat=" + var6;
            this.var_requete_directe = this.var_requete_directe + " and labEtat=" + var6;
         } else if (var6 == 13) {
            this.var_filtre = this.var_filtre + " Etat = Non payé Patient";
            this.var_requete = this.var_requete + " and med_laboratoire_entete.lab_solde_patient=0";
            this.var_requete_hql = this.var_requete_hql + " and laboratoireEntete.labSoldePatient=0";
            this.var_requete_directe = this.var_requete_directe + " and labSoldePatient=0";
         } else if (var6 == 14) {
            this.var_filtre = this.var_filtre + " Etat = Payé Patient";
            this.var_requete = this.var_requete + " and med_laboratoire_entete.lab_solde_patient=1";
            this.var_requete_hql = this.var_requete_hql + " and laboratoireEntete.labSoldePatient=1";
            this.var_requete_directe = this.var_requete_directe + " and labSoldePatient=1";
         } else if (var6 == 15) {
            this.var_filtre = this.var_filtre + " Etat = Non payé Tiers";
            this.var_requete = this.var_requete + " and med_laboratoire_entete.lab_solde_tiers=0";
            this.var_requete_hql = this.var_requete_hql + " and laboratoireEntete.labSoldeTiers=0";
            this.var_requete_directe = this.var_requete_directe + " and labSoldeTiers=0";
         } else if (var6 == 16) {
            this.var_filtre = this.var_filtre + " Etat = Payé Tiers";
            this.var_requete = this.var_requete + " and med_laboratoire_entete.lab_solde_tiers=1";
            this.var_requete_hql = this.var_requete_hql + " and laboratoireEntete.labSoldeTiers=1";
            this.var_requete_directe = this.var_requete_directe + " and labSoldeTiers=1";
         } else if (var6 == 17) {
            this.var_filtre = this.var_filtre + " Etat = Transféré en compta";
            this.var_requete = this.var_requete + " and med_laboratoire_entete.lab_date_transfert is not null";
            this.var_requete_hql = this.var_requete_hql + " and laboratoireEntete.labDateTransfert is not null";
            this.var_requete_directe = this.var_requete_directe + " and labDateTransfert is not null";
         } else if (var6 == 18) {
            this.var_filtre = this.var_filtre + " Etat = Non transféré en compta";
            this.var_requete = this.var_requete + " and med_laboratoire_entete.lab_date_transfert is null";
            this.var_requete_hql = this.var_requete_hql + " and laboratoireEntete.labDateTransfert is null";
            this.var_requete_directe = this.var_requete_directe + " and labDateTransfert is null";
         } else if (var6 == 19) {
            this.var_filtre = this.var_filtre + " Etat = Validé et Contrôlé";
            this.var_requete = this.var_requete + " and (med_laboratoire_entete.lab_etat=1 or med_laboratoire_entete.lab_etat=5)";
            this.var_requete_hql = this.var_requete_hql + " and (laboratoireEntete.labEtat=1 or laboratoireEntete.labEtat=5)";
            this.var_requete_directe = this.var_requete_directe + " and (labEtat=1 or labEtat=5)";
         } else if (var6 == 20) {
            this.var_filtre = this.var_filtre + " Etat = Validé, Contrôlé, Cloturé ou Refacturé";
            this.var_requete = this.var_requete + " and (med_laboratoire_entete.lab_etat=1 or med_laboratoire_entete.lab_etat=5 or med_laboratoire_entete.lab_etat=6 or med_laboratoire_entete.lab_etat=7)";
            this.var_requete_hql = this.var_requete_hql + " and (laboratoireEntete.labEtat=1 or laboratoireEntete.labEtat=5 or laboratoireEntete.labEtat=6 or laboratoireEntete.labEtat=7)";
            this.var_requete_directe = this.var_requete_directe + " and (labEtat=1 or labEtat=5 or labEtat=6 or labEtat=7)";
         }
      }

      if (this.idTiers != 0L) {
         if (this.nomTiers != null && !this.nomTiers.isEmpty() && this.nomTiers.equalsIgnoreCase("CNAMGS")) {
            this.var_filtre = this.var_filtre + " Tiers payeur = CNAMGS";
            this.var_requete = this.var_requete + " and med_laboratoire_entete.lab_pec_cnamgs<>0";
            this.var_requete_hql = this.var_requete_hql + " and laboratoireEntete.labPecCnamgs<>0";
            this.var_requete_directe = this.var_requete_directe + " and labPecCnamgs<>0";
         } else {
            this.var_filtre = this.var_filtre + " Tiers payeur = " + this.nomTiers;
            this.var_requete = this.var_requete + " and (med_laboratoire_entete.lab_id_assurance=" + this.idTiers + " or med_laboratoire_entete.lab_id_societe=" + this.idTiers + " or med_laboratoire_entete.lab_id_complementaire=" + this.idTiers + ")";
            this.var_requete_hql = this.var_requete_hql + " and (laboratoireEntete.labIdAssurance=" + this.idTiers + " or laboratoireEntete.labIdSociete=" + this.idTiers + " or laboratoireEntete.labIdComplementaire=" + this.idTiers + ")";
            this.var_requete_directe = this.var_requete_directe + " and (labIdAssurance=" + this.idTiers + " or labIdSociete=" + this.idTiers + " or labIdComplementaire=" + this.idTiers + ")";
         }
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and med_laboratoire_entete.lab_laboratoire='" + this.service + "'";
         this.var_requete_hql = this.var_requete_hql + " and laboratoireEntete.labLaboratoire='" + this.service + "'";
         this.var_requete_directe = this.var_requete_directe + " and labLaboratoire='" + this.service + "'";
      }

      if (this.medecin != 0L) {
         String var8 = "";

         for(int var7 = 0; var7 < this.mesMedecinsItems.size(); ++var7) {
            if (Long.parseLong(((SelectItem)this.mesMedecinsItems.get(var7)).getValue().toString()) == this.medecin) {
               var8 = ((SelectItem)this.mesMedecinsItems.get(var7)).getLabel().toString();
            }
         }

         this.var_filtre = this.var_filtre + " Medecin = " + var8;
         this.var_requete = this.var_requete + " and med_laboratoire_entete.lab_id_medecin=" + this.medecin;
         this.var_requete_hql = this.var_requete_hql + " and laboratoireEntete.labIdMedecin=" + this.medecin;
         this.var_requete_directe = this.var_requete_directe + " and labIdMedecin=" + this.medecin;
      }

      if (this.createur != null && !this.createur.isEmpty() && !this.createur.equals("100")) {
         UserDao var9 = new UserDao(this.baseLog, this.utilInitHibernate);
         String var10 = var9.selectByIdUsers(Long.parseLong(this.createur), var5).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Créateur = " + var10;
         this.var_requete = this.var_requete + " and med_laboratoire_entete.lab_id_createur=" + this.createur;
         this.var_requete_hql = this.var_requete_hql + " and laboratoireEntete.labIdCreateur=" + this.createur;
         this.var_requete_directe = this.var_requete_directe + " and labIdCreateur=" + this.createur;
      }

      if (this.typeTiers != 100) {
         if (this.typeTiers == 1) {
            this.var_filtre = this.var_filtre + " Type = Assurances";
            this.var_requete = this.var_requete + " and med_laboratoire_entete.lab_id_assurance<>0";
            this.var_requete_hql = this.var_requete_hql + " and laboratoireEntete.labIdAssurance<>0";
            this.var_requete_directe = this.var_requete_directe + " and labIdAssurance<>0";
         } else if (this.typeTiers == 2) {
            this.var_filtre = this.var_filtre + " Type = Sociétés";
            this.var_requete = this.var_requete + " and med_laboratoire_entete.lab_id_societe<>0";
            this.var_requete_hql = this.var_requete_hql + " and laboratoireEntete.labIdSociete<>0";
            this.var_requete_directe = this.var_requete_directe + " and labIdSociete<>0";
         } else if (this.typeTiers == 3) {
            this.var_filtre = this.var_filtre + " Type = Complémentaires";
            this.var_requete = this.var_requete + " and med_laboratoire_entete.lab_id_complementaire<>0";
            this.var_requete_hql = this.var_requete_hql + " and laboratoireEntete.labIdComplementaire<>0";
            this.var_requete_directe = this.var_requete_directe + " and labIdComplementaire<>0";
         } else if (this.typeTiers == 4) {
            this.var_filtre = this.var_filtre + " Type = CNMAGS";
            this.var_requete = this.var_requete + " and med_laboratoire_entete.lab_pec_cnamgs<>0";
            this.var_requete_hql = this.var_requete_hql + " and laboratoireEntete.labPecCnamgs<>0";
            this.var_requete_directe = this.var_requete_directe + " and labPecCnamgs<>0";
         }
      }

   }

   public void recherchePaillasseSql(String var1, String var2, String var3, String var4, Session var5) {
   }

   public void rechercheHospitalisationSql(String var1, String var2, String var3, String var4, int var5, Session var6) throws NamingException, ParseException {
      this.var_filtre = "";
      if (var5 == 1) {
         if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
            this.var_entete = "Liste des activités du " + var1 + " au " + var2 + " Série : Toutes";
         } else {
            this.var_entete = "Liste des activités du " + var1 + " au " + var2 + " Série : " + this.serie;
         }
      } else if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Liste des Hospitalisations du " + var1 + " au " + var2 + " Série : Toutes";
      } else {
         this.var_entete = "Liste des Hospitalisations du " + var1 + " au " + var2 + " Série : " + this.serie;
      }

      String var7 = "";
      new DocumentMedical();
      new ArrayList();
      HospitalisationSejourDao var10 = new HospitalisationSejourDao(this.baseLog, this.utilInitHibernate);
      var7 = "hossejDateCreat >='" + var3 + "' and hossejDateCreat <='" + var4 + "'";
      if (this.etat != null && !this.etat.isEmpty() && !this.etat.equals("100")) {
         int var11 = Integer.parseInt(this.etat);
         if (var11 == 0) {
            var7 = var7 + " and HospitalisationEntete.hosEtat=" + var11;
            this.var_filtre = this.var_filtre + " Etat = En cours";
         } else if (var11 == 1) {
            var7 = var7 + " and HospitalisationEntete.hosEtat=" + var11;
            this.var_filtre = this.var_filtre + " Etat = Validé";
         } else if (var11 == 2) {
            var7 = var7 + " and HospitalisationEntete.hosEtat=" + var11;
            this.var_filtre = this.var_filtre + " Etat = Gelé";
         } else if (var11 == 3) {
            var7 = var7 + " and HospitalisationEntete.hosEtat=" + var11;
            this.var_filtre = this.var_filtre + " Etat = Annulé";
         } else if (var11 == 4) {
            var7 = var7 + " and HospitalisationEntete.hosEtat=" + var11;
            this.var_filtre = this.var_filtre + " Etat = Cloturé";
         } else if (var11 == 5) {
            var7 = var7 + " and HospitalisationEntete.hosEtat=" + var11;
            this.var_filtre = this.var_filtre + " Etat = Refacturé";
         } else if (var11 == 13) {
            var7 = var7 + " and HospitalisationEntete.hosSoldePatient=0";
            this.var_filtre = this.var_filtre + " Etat = Patient non soldé";
         } else if (var11 == 14) {
            var7 = var7 + " and HospitalisationEntete.hosSoldePatient=1";
            this.var_filtre = this.var_filtre + " Etat = Patient soldé";
         } else if (var11 == 15) {
            var7 = var7 + " and HospitalisationEntete.hosSoldeTiers=0";
            this.var_filtre = this.var_filtre + " Etat = Tiers non soldé";
         } else if (var11 == 16) {
            var7 = var7 + " and HospitalisationEntete.hosSoldeTiers=1";
            this.var_filtre = this.var_filtre + " Etat = Tiers soldé";
         } else if (var11 == 17) {
            this.var_filtre = this.var_filtre + " Etat = Transféré en compta";
            var7 = var7 + " and HospitalisationEntete.hosDateTransfert is not null";
         } else if (var11 == 18) {
            this.var_filtre = this.var_filtre + " Etat = Non transféré en compta";
            var7 = var7 + " and HospitalisationEntete.hosDateTransfert is null";
         } else if (var11 == 19) {
            this.var_filtre = this.var_filtre + " Etat = Validé et Contrôlé";
            var7 = var7 + " and (HospitalisationEntete.hosEtat=1 or HospitalisationEntete.hosEtat=5)";
         } else if (var11 == 20) {
            this.var_filtre = this.var_filtre + " Etat = Validé, Contrôlé, Cloturé ou Refacturé";
            var7 = var7 + " and (HospitalisationEntete.hosEtat=1 or HospitalisationEntete.hosEtat=5 or HospitalisationEntete.hosEtat=6 or HospitalisationEntete.hosEtat=7)";
         }
      }

      if (this.idTiers != 0L) {
         if (this.nomTiers != null && !this.nomTiers.isEmpty() && this.nomTiers.equalsIgnoreCase("CNAMGS")) {
            this.var_filtre = this.var_filtre + " Tiers payeur = CNAMGS";
            var7 = var7 + " and HospitalisationEntete.hosPecCnamgs<>0";
         } else {
            this.var_filtre = this.var_filtre + " Tiers payeur = " + this.nomTiers;
            var7 = var7 + " and (HospitalisationEntete.hosIdAssurance=" + this.idTiers + " or HospitalisationEntete.hosIdSociete=" + this.idTiers + " or HospitalisationEntete.hosIdComplementaire=" + this.idTiers + ")";
         }
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         var7 = var7 + " and hossejService='" + this.service + "'";
      }

      int var12;
      if (this.medecin != 0L) {
         String var21 = "";

         for(var12 = 0; var12 < this.mesMedecinsItems.size(); ++var12) {
            if (Long.parseLong(((SelectItem)this.mesMedecinsItems.get(var12)).getValue().toString()) == this.medecin) {
               var21 = ((SelectItem)this.mesMedecinsItems.get(var12)).getLabel().toString();
            }
         }

         this.var_filtre = this.var_filtre + " Medecin = " + var21;
         var7 = var7 + " and hossejIdMedecin=" + this.medecin;
      }

      if (this.createur != null && !this.createur.isEmpty() && !this.createur.equals("100")) {
         UserDao var22 = new UserDao(this.baseLog, this.utilInitHibernate);
         String var24 = var22.selectByIdUsers(Long.parseLong(this.createur), var6).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Créateur = " + var24;
         var7 = var7 + " and hossejUserCreat=" + this.createur;
      }

      if (this.typeTiers != 100) {
         if (this.typeTiers == 1) {
            this.var_filtre = this.var_filtre + " Type = Assurances";
            var7 = var7 + " and HospitalisationEntete.hosIdAssurance<>0";
         } else if (this.typeTiers == 2) {
            this.var_filtre = this.var_filtre + " Type = Sociétés";
            var7 = var7 + " and HospitalisationEntete.hosIdSociete<>0";
         } else if (this.typeTiers == 3) {
            this.var_filtre = this.var_filtre + " Type = Complémentaires";
            var7 = var7 + " and HospitalisationEntete.hosIdComplementaire<>0";
         } else if (this.typeTiers == 4) {
            this.var_filtre = this.var_filtre + " Type = CNAMGS";
            var7 = var7 + " and HospitalisationEntete.hosPecCnamgs<>0";
         }
      }

      List var9 = var10.chargerSejourByRequete(var7, var6);
      DocumentMedical var8;
      if (var9.size() != 0) {
         new HospitalisationSejour();

         for(var12 = 0; var12 < var9.size(); ++var12) {
            HospitalisationSejour var23 = (HospitalisationSejour)var9.get(var12);
            var8 = new DocumentMedical();
            var8.setDocCode(var23.getHossejLit());
            var8.setDocDate(this.utilDate.dateToSQLLight(var23.getHossejDateCreat()));
            var8.setDocNature(0);
            var8.setDocLibelleNature("Sejour");
            var8.setDocNomMedecin(this.calculMedecin(var23.getHossejIdMedecin()));
            var8.setDocNomPatient(var23.getHospitalisationEntete().getHosNomPatient());
            var8.setDocNomTiersAssurance(var23.getHospitalisationEntete().getHosNomAssurance());
            var8.setDocNomTiersComplementaire(var23.getHospitalisationEntete().getHosNomComplemtaire());
            var8.setDocNomTiersSociete(var23.getHospitalisationEntete().getHosNomSociete());
            var8.setDocNum(var23.getHospitalisationEntete().getHosNum());
            var8.setDocProduit(var23.getHossejLibelle());
            var8.setDocQte((float)var23.getHossejNbJour());
            var8.setDocRegPatient(var23.getHossejRegPatient());
            var8.setDocRegTiers(var23.getHossejRegTiers());
            var8.setDocService(var23.getHossejService());
            var8.setDocTotPatient(var23.getHossejPatientHt() + var23.getHossejPatientTaxe());
            var8.setDocTotTiers(var23.getHossejAssuranceHt() + var23.getHossejAssuranceTaxe() + var23.getHossejSocieteHt() + var23.getHossejSocieteTaxe() + var23.getHossejComplementaireHt() + var23.getHossejComplementaireTaxe());
            this.lesSyntheses.add(var8);
         }
      }

      new ArrayList();
      HospitalisationActesDao var27 = new HospitalisationActesDao(this.baseLog, this.utilInitHibernate);
      var7 = "";
      var7 = "hosactDateCreat >='" + var3 + "' and hosactDateCreat <='" + var4 + "'";
      if (this.etat != null && !this.etat.isEmpty() && !this.etat.equals("100")) {
         int var13 = Integer.parseInt(this.etat);
         if (var13 == 0) {
            var7 = var7 + " and HospitalisationEntete.hosEtat=" + var13;
         } else if (var13 == 1) {
            var7 = var7 + " and HospitalisationEntete.hosEtat=" + var13;
         } else if (var13 == 2) {
            var7 = var7 + " and HospitalisationEntete.hosEtat=" + var13;
         } else if (var13 == 3) {
            var7 = var7 + " and HospitalisationEntete.hosEtat=" + var13;
         } else if (var13 == 4) {
            var7 = var7 + " and HospitalisationEntete.hosEtat=" + var13;
         } else if (var13 == 5) {
            var7 = var7 + " and HospitalisationEntete.hosEtat=" + var13;
         } else if (var13 == 13) {
            var7 = var7 + " and HospitalisationEntete.hosSoldePatient=0";
         } else if (var13 == 14) {
            var7 = var7 + " and HospitalisationEntete.hosSoldePatient=1";
         } else if (var13 == 15) {
            var7 = var7 + " and HospitalisationEntete.hosSoldeTiers=0";
         } else if (var13 == 16) {
            var7 = var7 + " and HospitalisationEntete.hosSoldeTiers=1";
         } else if (var13 == 17) {
            var7 = var7 + " and HospitalisationEntete.hosDateTransfert is not null";
         } else if (var13 == 18) {
            var7 = var7 + " and HospitalisationEntete.hosDateTransfert is null";
         } else if (var13 == 19) {
            var7 = var7 + " and (HospitalisationEntete.hosEtat=1 or HospitalisationEntete.hosEtat=5)";
         } else if (var13 == 20) {
            var7 = var7 + " and (HospitalisationEntete.hosEtat=1 or HospitalisationEntete.hosEtat=5 or HospitalisationEntete.hosEtat=6 or HospitalisationEntete.hosEtat=7)";
         }
      }

      if (this.idTiers != 0L) {
         if (this.nomTiers != null && !this.nomTiers.isEmpty() && this.nomTiers.equalsIgnoreCase("CNAMGS")) {
            this.var_filtre = this.var_filtre + " Tiers payeur = CNAMGS";
            var7 = var7 + " and HospitalisationEntete.hosPecCnamgs<>0";
         } else {
            this.var_filtre = this.var_filtre + " Tiers payeur = " + this.nomTiers;
            var7 = var7 + " and (HospitalisationEntete.hosIdAssurance=" + this.idTiers + " or HospitalisationEntete.hosIdSociete=" + this.idTiers + " or HospitalisationEntete.hosIdComplementaire=" + this.idTiers + ")";
         }
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         var7 = var7 + " and hosactService='" + this.service + "'";
      }

      if (this.medecin != 0L) {
         var7 = var7 + " and hosactIdMedecin=" + this.medecin;
      }

      if (this.createur != null && !this.createur.isEmpty() && !this.createur.equals("100")) {
         var7 = var7 + " and hosactUserCreat=" + this.createur;
      }

      if (this.typeTiers != 100) {
         if (this.typeTiers == 1) {
            this.var_filtre = this.var_filtre + " Type = Assurances";
            var7 = var7 + " and HospitalisationEntete.hosIdAssurance<>0";
         } else if (this.typeTiers == 2) {
            this.var_filtre = this.var_filtre + " Type = Sociétés";
            var7 = var7 + " and HospitalisationEntete.hosIdSociete<>0";
         } else if (this.typeTiers == 3) {
            this.var_filtre = this.var_filtre + " Type = Complémentaires";
            var7 = var7 + " and HospitalisationEntete.hosIdComplementaire<>0";
         } else if (this.typeTiers == 4) {
            this.var_filtre = this.var_filtre + " Type = CNAMGS";
            var7 = var7 + " and HospitalisationEntete.hosPecCnamgs<>0";
         }
      }

      List var25 = var27.chargerActesByRequete(var7, var6);
      if (var25.size() != 0) {
         new HospitalisationActes();

         for(int var14 = 0; var14 < var25.size(); ++var14) {
            HospitalisationActes var26 = (HospitalisationActes)var25.get(var14);
            var8 = new DocumentMedical();
            var8.setDocCode(var26.getHosactProduit());
            var8.setDocDate(this.utilDate.dateToSQLLight(var26.getHosactDateCreat()));
            var8.setDocNature(1);
            var8.setDocLibelleNature("Actes");
            var8.setDocNomMedecin(this.calculMedecin(var26.getHosactIdMedecin()));
            var8.setDocNomPatient(var26.getHospitalisationEntete().getHosNomPatient());
            var8.setDocNomTiersAssurance(var26.getHospitalisationEntete().getHosNomAssurance());
            var8.setDocNomTiersComplementaire(var26.getHospitalisationEntete().getHosNomComplemtaire());
            var8.setDocNomTiersSociete(var26.getHospitalisationEntete().getHosNomSociete());
            var8.setDocNum(var26.getHospitalisationEntete().getHosNum());
            var8.setDocProduit(var26.getHosactLibelle());
            var8.setDocQte(var26.getHosactQte());
            var8.setDocRegPatient(var26.getHosactRegPatient());
            var8.setDocRegTiers(var26.getHosactRegTiers());
            var8.setDocService(var26.getHosactService());
            var8.setDocTotPatient(var26.getHosactPatientHt() + var26.getHosactPatientTaxe());
            var8.setDocTotTiers(var26.getHosactAssuranceHt() + var26.getHosactAssuranceTaxe() + var26.getHosactSocieteHt() + var26.getHosactSocieteTaxe() + var26.getHosactComplementaireHt() + var26.getHosactComplementaireTaxe());
            this.lesSyntheses.add(var8);
         }
      }

      new ArrayList();
      HospitalisationLaboDao var29 = new HospitalisationLaboDao(this.baseLog, this.utilInitHibernate);
      var7 = "";
      var7 = "hoslabDateCreat >='" + var3 + "' and hoslabDateCreat <='" + var4 + "'";
      if (this.etat != null && !this.etat.isEmpty() && !this.etat.equals("100")) {
         int var15 = Integer.parseInt(this.etat);
         if (var15 == 0) {
            var7 = var7 + " and HospitalisationEntete.hosEtat=" + var15;
         } else if (var15 == 1) {
            var7 = var7 + " and HospitalisationEntete.hosEtat=" + var15;
         } else if (var15 == 2) {
            var7 = var7 + " and HospitalisationEntete.hosEtat=" + var15;
         } else if (var15 == 3) {
            var7 = var7 + " and HospitalisationEntete.hosEtat=" + var15;
         } else if (var15 == 4) {
            var7 = var7 + " and HospitalisationEntete.hosEtat=" + var15;
         } else if (var15 == 5) {
            var7 = var7 + " and HospitalisationEntete.hosEtat=" + var15;
         } else if (var15 == 13) {
            var7 = var7 + " and HospitalisationEntete.hosSoldePatient=0";
         } else if (var15 == 14) {
            var7 = var7 + " and HospitalisationEntete.hosSoldePatient=1";
         } else if (var15 == 15) {
            var7 = var7 + " and HospitalisationEntete.hosSoldeTiers=0";
         } else if (var15 == 16) {
            var7 = var7 + " and HospitalisationEntete.hosSoldeTiers=1";
         } else if (var15 == 17) {
            var7 = var7 + " and HospitalisationEntete.hosDateTransfert is not null";
         } else if (var15 == 18) {
            var7 = var7 + " and HospitalisationEntete.hosDateTransfert is null";
         } else if (var15 == 19) {
            var7 = var7 + " and (HospitalisationEntete.hosEtat=1 or HospitalisationEntete.hosEtat=5)";
         } else if (var15 == 20) {
            var7 = var7 + " and (HospitalisationEntete.hosEtat=1 or HospitalisationEntete.hosEtat=5 or HospitalisationEntete.hosEtat=6 or HospitalisationEntete.hosEtat=7)";
         }
      }

      if (this.idTiers != 0L) {
         if (this.nomTiers != null && !this.nomTiers.isEmpty() && this.nomTiers.equalsIgnoreCase("CNAMGS")) {
            this.var_filtre = this.var_filtre + " Tiers payeur = CNAMGS";
            var7 = var7 + " and HospitalisationEntete.hosPecCnamgs<>0";
         } else {
            this.var_filtre = this.var_filtre + " Tiers payeur = " + this.nomTiers;
            var7 = var7 + " and (HospitalisationEntete.hosIdAssurance=" + this.idTiers + " or HospitalisationEntete.hosIdSociete=" + this.idTiers + " or HospitalisationEntete.hosIdComplementaire=" + this.idTiers + ")";
         }
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         var7 = var7 + " and hoslabService='" + this.service + "'";
      }

      if (this.medecin != 0L) {
         var7 = var7 + " and hoslabIdMedecin=" + this.medecin;
      }

      if (this.createur != null && !this.createur.isEmpty() && !this.createur.equals("100")) {
         var7 = var7 + " and hoslabUserCreat=" + this.createur;
      }

      if (this.typeTiers != 100) {
         if (this.typeTiers == 1) {
            this.var_filtre = this.var_filtre + " Type = Assurances";
            var7 = var7 + " and HospitalisationEntete.hosIdAssurance<>0";
         } else if (this.typeTiers == 2) {
            this.var_filtre = this.var_filtre + " Type = Sociétés";
            var7 = var7 + " and HospitalisationEntete.hosIdSociete<>0";
         } else if (this.typeTiers == 3) {
            this.var_filtre = this.var_filtre + " Type = Complémentaires";
            var7 = var7 + " and HospitalisationEntete.hosIdComplementaire<>0";
         } else if (this.typeTiers == 4) {
            this.var_filtre = this.var_filtre + " Type = CNAMGS";
            var7 = var7 + " and HospitalisationEntete.hosPecCnamgs<>0";
         }
      }

      List var28 = var29.chargerLaboByRequete(var7, var6);
      if (var28.size() != 0) {
         new HospitalisationLabo();

         for(int var16 = 0; var16 < var28.size(); ++var16) {
            HospitalisationLabo var30 = (HospitalisationLabo)var28.get(var16);
            var8 = new DocumentMedical();
            var8.setDocCode(var30.getHoslabProduit());
            var8.setDocDate(this.utilDate.dateToSQLLight(var30.getHoslabDateCreat()));
            var8.setDocNature(2);
            var8.setDocLibelleNature("Laboratoire");
            var8.setDocNomMedecin(this.calculMedecin(var30.getHoslabIdMedecin()));
            var8.setDocNomPatient(var30.getHospitalisationEntete().getHosNomPatient());
            var8.setDocNomTiersAssurance(var30.getHospitalisationEntete().getHosNomAssurance());
            var8.setDocNomTiersComplementaire(var30.getHospitalisationEntete().getHosNomComplemtaire());
            var8.setDocNomTiersSociete(var30.getHospitalisationEntete().getHosNomSociete());
            var8.setDocNum(var30.getHospitalisationEntete().getHosNum());
            var8.setDocProduit(var30.getHoslabLibelle());
            var8.setDocQte(var30.getHoslabQte());
            var8.setDocRegPatient(var30.getHoslabRegPatient());
            var8.setDocRegTiers(var30.getHoslabRegTiers());
            var8.setDocService(var30.getHoslabLaboratoire());
            var8.setDocTotPatient(var30.getHoslabPatientHt() + var30.getHoslabPatientTaxe());
            var8.setDocTotTiers(var30.getHoslabAssuranceHt() + var30.getHoslabAssuranceTaxe() + var30.getHoslabSocieteHt() + var30.getHoslabSocieteTaxe() + var30.getHoslabComplementaireHt() + var30.getHoslabComplementaireTaxe());
            this.lesSyntheses.add(var8);
         }
      }

      new ArrayList();
      HospitalisationMediDao var32 = new HospitalisationMediDao(this.baseLog, this.utilInitHibernate);
      var7 = "";
      var7 = "hosmedDateCreat >='" + var3 + "' and hosmedDateCreat <='" + var4 + "'";
      if (this.etat != null && !this.etat.isEmpty() && !this.etat.equals("100")) {
         int var17 = Integer.parseInt(this.etat);
         if (var17 == 0) {
            var7 = var7 + " and HospitalisationEntete.hosEtat=" + var17;
         } else if (var17 == 1) {
            var7 = var7 + " and HospitalisationEntete.hosEtat=" + var17;
         } else if (var17 == 2) {
            var7 = var7 + " and HospitalisationEntete.hosEtat=" + var17;
         } else if (var17 == 3) {
            var7 = var7 + " and HospitalisationEntete.hosEtat=" + var17;
         } else if (var17 == 4) {
            var7 = var7 + " and HospitalisationEntete.hosEtat=" + var17;
         } else if (var17 == 5) {
            var7 = var7 + " and HospitalisationEntete.hosEtat=" + var17;
         } else if (var17 == 13) {
            var7 = var7 + " and HospitalisationEntete.hosSoldePatient=0";
         } else if (var17 == 14) {
            var7 = var7 + " and HospitalisationEntete.hosSoldePatient=1";
         } else if (var17 == 15) {
            var7 = var7 + " and HospitalisationEntete.hosSoldeTiers=0";
         } else if (var17 == 16) {
            var7 = var7 + " and HospitalisationEntete.hosSoldeTiers=1";
         } else if (var17 == 17) {
            var7 = var7 + " and HospitalisationEntete.hosDateTransfert is not null";
         } else if (var17 == 18) {
            var7 = var7 + " and HospitalisationEntete.hosDateTransfert is null";
         } else if (var17 == 19) {
            var7 = var7 + " and (HospitalisationEntete.hosEtat=1 or HospitalisationEntete.hosEtat=5)";
         } else if (var17 == 20) {
            var7 = var7 + " and (HospitalisationEntete.hosEtat=1 or HospitalisationEntete.hosEtat=5 or HospitalisationEntete.hosEtat=6 or HospitalisationEntete.hosEtat=7)";
         }
      }

      if (this.idTiers != 0L) {
         if (this.nomTiers != null && !this.nomTiers.isEmpty() && this.nomTiers.equalsIgnoreCase("CNAMGS")) {
            this.var_filtre = this.var_filtre + " Tiers payeur = CNAMGS";
            var7 = var7 + " and HospitalisationEntete.hosPecCnamgs<>0";
         } else {
            this.var_filtre = this.var_filtre + " Tiers payeur = " + this.nomTiers;
            var7 = var7 + " and (HospitalisationEntete.hosIdAssurance=" + this.idTiers + " or HospitalisationEntete.hosIdSociete=" + this.idTiers + " or HospitalisationEntete.hosIdComplementaire=" + this.idTiers + ")";
         }
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         var7 = var7 + " and hosmedService='" + this.service + "'";
      }

      if (this.medecin != 0L) {
         var7 = var7 + " and hosmedIdMedecin=" + this.medecin;
      }

      if (this.createur != null && !this.createur.isEmpty() && !this.createur.equals("100")) {
         var7 = var7 + " and hosmedUserCreat=" + this.createur;
      }

      if (this.typeTiers != 100) {
         if (this.typeTiers == 1) {
            this.var_filtre = this.var_filtre + " Type = Assurances";
            var7 = var7 + " and HospitalisationEntete.hosIdAssurance<>0";
         } else if (this.typeTiers == 2) {
            this.var_filtre = this.var_filtre + " Type = Sociétés";
            var7 = var7 + " and HospitalisationEntete.hosIdSociete<>0";
         } else if (this.typeTiers == 3) {
            this.var_filtre = this.var_filtre + " Type = Complémentaires";
            var7 = var7 + " and HospitalisationEntete.hosIdComplementaire<>0";
         } else if (this.typeTiers == 4) {
            this.var_filtre = this.var_filtre + " Type = CNAMGS";
            var7 = var7 + " and HospitalisationEntete.hosPecCnamgs<>0";
         }
      }

      List var31 = var32.chargerMediByRequete(var7, var6);
      if (var31.size() != 0) {
         new HospitalisationMedi();

         for(int var18 = 0; var18 < var31.size(); ++var18) {
            HospitalisationMedi var33 = (HospitalisationMedi)var31.get(var18);
            var8 = new DocumentMedical();
            var8.setDocCode(var33.getHosmedProduit());
            var8.setDocDate(this.utilDate.dateToSQLLight(var33.getHosmedDateCreat()));
            var8.setDocNature(3);
            var8.setDocLibelleNature("Pharmacie");
            var8.setDocNomMedecin(this.calculMedecin(var33.getHosmedIdMedecin()));
            var8.setDocNomPatient(var33.getHospitalisationEntete().getHosNomPatient());
            var8.setDocNomTiersAssurance(var33.getHospitalisationEntete().getHosNomAssurance());
            var8.setDocNomTiersComplementaire(var33.getHospitalisationEntete().getHosNomComplemtaire());
            var8.setDocNomTiersSociete(var33.getHospitalisationEntete().getHosNomSociete());
            var8.setDocNum(var33.getHospitalisationEntete().getHosNum());
            var8.setDocProduit(var33.getHosmedLibelle());
            var8.setDocQte(var33.getHosmedQte());
            var8.setDocRegPatient(var33.getHosmedRegPatient());
            var8.setDocRegTiers(var33.getHosmedRegTiers());
            var8.setDocService(var33.getHosmedService());
            var8.setDocTotPatient(var33.getHosmedPatientHt() + var33.getHosmedPatientTaxe());
            var8.setDocTotTiers(var33.getHosmedAssuranceHt() + var33.getHosmedAssuranceTaxe() + var33.getHosmedSocieteHt() + var33.getHosmedSocieteTaxe() + var33.getHosmedComplementaireHt() + var33.getHosmedComplementaireTaxe());
            this.lesSyntheses.add(var8);
         }
      }

      new ArrayList();
      HospitalisationPrestDao var35 = new HospitalisationPrestDao(this.baseLog, this.utilInitHibernate);
      var7 = "";
      var7 = "hosprtDateCreat >='" + var3 + "' and hosprtDateCreat <='" + var4 + "'";
      if (this.etat != null && !this.etat.isEmpty() && !this.etat.equals("100")) {
         int var19 = Integer.parseInt(this.etat);
         if (var19 == 0) {
            var7 = var7 + " and HospitalisationEntete.hosEtat=" + var19;
         } else if (var19 == 1) {
            var7 = var7 + " and HospitalisationEntete.hosEtat=" + var19;
         } else if (var19 == 2) {
            var7 = var7 + " and HospitalisationEntete.hosEtat=" + var19;
         } else if (var19 == 3) {
            var7 = var7 + " and HospitalisationEntete.hosEtat=" + var19;
         } else if (var19 == 4) {
            var7 = var7 + " and HospitalisationEntete.hosEtat=" + var19;
         } else if (var19 == 5) {
            var7 = var7 + " and HospitalisationEntete.hosEtat=" + var19;
         } else if (var19 == 13) {
            var7 = var7 + " and HospitalisationEntete.hosSoldePatient=0";
         } else if (var19 == 14) {
            var7 = var7 + " and HospitalisationEntete.hosSoldePatient=1";
         } else if (var19 == 15) {
            var7 = var7 + " and HospitalisationEntete.hosSoldeTiers=0";
         } else if (var19 == 16) {
            var7 = var7 + " and HospitalisationEntete.hosSoldeTiers=1";
         } else if (var19 == 17) {
            var7 = var7 + " and HospitalisationEntete.hosDateTransfert is not null";
         } else if (var19 == 18) {
            var7 = var7 + " and HospitalisationEntete.hosDateTransfert is null";
         } else if (var19 == 19) {
            var7 = var7 + " and (HospitalisationEntete.hosEtat=1 or HospitalisationEntete.hosEtat=5)";
         } else if (var19 == 20) {
            var7 = var7 + " and (HospitalisationEntete.hosEtat=1 or HospitalisationEntete.hosEtat=5 or HospitalisationEntete.hosEtat=6 or HospitalisationEntete.hosEtat=7)";
         }
      }

      if (this.idTiers != 0L) {
         if (this.nomTiers != null && !this.nomTiers.isEmpty() && this.nomTiers.equalsIgnoreCase("CNAMGS")) {
            this.var_filtre = this.var_filtre + " Tiers payeur = CNAMGS";
            var7 = var7 + " and HospitalisationEntete.hosPecCnamgs<>0";
         } else {
            this.var_filtre = this.var_filtre + " Tiers payeur = " + this.nomTiers;
            var7 = var7 + " and (HospitalisationEntete.hosIdAssurance=" + this.idTiers + " or HospitalisationEntete.hosIdSociete=" + this.idTiers + " or HospitalisationEntete.hosIdComplementaire=" + this.idTiers + ")";
         }
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         var7 = var7 + " and hosprtService='" + this.service + "'";
      }

      if (this.medecin != 0L) {
         var7 = var7 + " and hosprtIdMedecin=" + this.medecin;
      }

      if (this.createur != null && !this.createur.isEmpty() && !this.createur.equals("100")) {
         var7 = var7 + " and hosprtUserCreat=" + this.createur;
      }

      if (this.typeTiers != 100) {
         if (this.typeTiers == 1) {
            this.var_filtre = this.var_filtre + " Type = Assurances";
            var7 = var7 + " and HospitalisationEntete.hosIdAssurance<>0";
         } else if (this.typeTiers == 2) {
            this.var_filtre = this.var_filtre + " Type = Sociétés";
            var7 = var7 + " and HospitalisationEntete.hosIdSociete<>0";
         } else if (this.typeTiers == 3) {
            this.var_filtre = this.var_filtre + " Type = Complémentaires";
            var7 = var7 + " and HospitalisationEntete.hosIdComplementaire<>0";
         } else if (this.typeTiers == 4) {
            this.var_filtre = this.var_filtre + " Type = CNAMGS";
            var7 = var7 + " and HospitalisationEntete.hosPecCnamgs<>0";
         }
      }

      List var34 = var35.chargerPrestByRequete(var7, var6);
      if (var34.size() != 0) {
         new HospitalisationPrest();

         for(int var20 = 0; var20 < var34.size(); ++var20) {
            HospitalisationPrest var36 = (HospitalisationPrest)var34.get(var20);
            var8 = new DocumentMedical();
            var8.setDocCode(var36.getHosprtProduit());
            var8.setDocDate(this.utilDate.dateToSQLLight(var36.getHosprtDateCreat()));
            var8.setDocNature(4);
            var8.setDocLibelleNature("Prestations");
            var8.setDocNomMedecin(this.calculMedecin(var36.getHosprtIdMedecin()));
            var8.setDocNomPatient(var36.getHospitalisationEntete().getHosNomPatient());
            var8.setDocNomTiersAssurance(var36.getHospitalisationEntete().getHosNomAssurance());
            var8.setDocNomTiersComplementaire(var36.getHospitalisationEntete().getHosNomComplemtaire());
            var8.setDocNomTiersSociete(var36.getHospitalisationEntete().getHosNomSociete());
            var8.setDocNum(var36.getHospitalisationEntete().getHosNum());
            var8.setDocProduit(var36.getHosprtLibelle());
            var8.setDocQte(var36.getHosprtQte());
            var8.setDocRegPatient(var36.getHosprtRegPatient());
            var8.setDocRegTiers(var36.getHosprtRegTiers());
            var8.setDocService(var36.getHosprtService());
            var8.setDocTotPatient(var36.getHosprtPatientHt() + var36.getHosprtPatientTaxe());
            var8.setDocTotTiers(var36.getHosprtAssuranceHt() + var36.getHosprtAssuranceTaxe() + var36.getHosprtSocieteHt() + var36.getHosprtSocieteTaxe() + var36.getHosprtComplementaireHt() + var36.getHosprtComplementaireTaxe());
            this.lesSyntheses.add(var8);
         }
      }

   }

   public void rechercheRefacturationSql(String var1, String var2, String var3, String var4, Session var5) throws NamingException {
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Liste de la Refacturation du " + var1 + " au " + var2 + " Série : Toutes";
         this.var_requete = "med_facture_entete.fac_date>='" + var3 + "' and med_facture_entete.fac_date<='" + var4 + "'";
      } else {
         this.var_entete = "Liste de la Refacturation du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "med_facture_entete.fac_date>='" + var3 + "' and med_facture_entete.fac_date<='" + var4 + "' and med_facture_entete.fac_serie='" + this.serie + "'";
      }

      if (this.etat != null && !this.etat.isEmpty() && !this.etat.equals("100")) {
         int var6 = Integer.parseInt(this.etat);
         if (var6 == 0) {
            this.var_filtre = this.var_filtre + " Etat = En cours";
            this.var_requete = this.var_requete + " and med_facture_entete.fac_etat=" + var6;
         } else if (var6 == 1) {
            this.var_filtre = this.var_filtre + " Etat = Validé";
            this.var_requete = this.var_requete + " and (med_facture_entete.fac_etat=1 or med_facture_entete.fac_etat=19)";
         } else if (var6 == 2) {
            this.var_filtre = this.var_filtre + " Etat = Gelé";
            this.var_requete = this.var_requete + " and med_facture_entete.fac_etat=" + var6;
         } else if (var6 == 3) {
            this.var_filtre = this.var_filtre + " Etat = Annulé";
            this.var_requete = this.var_requete + " and med_facture_entete.fac_etat=" + var6;
         } else if (var6 == 13) {
            this.var_filtre = this.var_filtre + " Etat = Non payé";
            this.var_requete = this.var_requete + " and med_facture_entete.fac_solde=0";
         } else if (var6 == 14) {
            this.var_filtre = this.var_filtre + " Etat = Payé";
            this.var_requete = this.var_requete + " and med_facture_entete.fac_solde=1";
         } else if (var6 == 17) {
            this.var_filtre = this.var_filtre + " Etat = Non Transféré Compta";
            this.var_requete = this.var_requete + " and med_facture_entete.fac_date_transfert=null";
         } else if (var6 == 18) {
            this.var_filtre = this.var_filtre + " Etat = Transféré Compta";
            this.var_requete = this.var_requete + " and med_facture_entete.fac_date_transfert<>null";
         }
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         this.var_filtre = this.var_filtre + " Service = " + this.service;
         this.var_requete = this.var_requete + " and med_facture_entete.fac_service='" + this.service + "'";
      }

      if (this.createur != null && !this.createur.isEmpty() && !this.createur.equals("100")) {
         UserDao var8 = new UserDao(this.baseLog, this.utilInitHibernate);
         String var7 = var8.selectByIdUsers(Long.parseLong(this.createur), var5).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Créateur = " + var7;
         this.var_requete = this.var_requete + " and med_facture_entete.fac_id_createur=" + this.createur;
      }

      if (this.idTiers != 0L) {
         this.var_filtre = this.var_filtre + " Tier = " + this.tiers.getTieraisonsocialenom();
         this.var_requete = this.var_requete + " and med_facture_entete.fac_nom_tiers='" + this.tiers.getTieraisonsocialenom() + "'";
      }

   }

   public void rechercheControleConsultation(String var1, String var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      this.lesSyntheses = new ArrayList();
      ArrayList var6 = new ArrayList();
      new ArrayList();
      this.rechercheConsultationGeneSql(var1, var2, var3, var4, var5);
      ConsultationEnteteGeneDao var8 = new ConsultationEnteteGeneDao(this.baseLog, this.utilInitHibernate);
      this.var_requete_hql = this.var_requete_hql.replace("ConsultationEnteteGene.", "");
      this.var_requete_hql = this.var_requete_hql + " and csgFeuille is not null and csgFeuille<>''";
      List var7 = var8.chargerConsultationByRequete(this.var_requete_hql, var5);
      this.var_entete = "Doublon des feuilles sur Consultations";
      if (var7.size() != 0) {
         new ConsultationEnteteGene();

         int var11;
         for(int var10 = 0; var10 < var7.size(); ++var10) {
            ConsultationEnteteGene var9 = (ConsultationEnteteGene)var7.get(var10);
            if (var9.getCsgFeuille() != null && !var9.getCsgFeuille().isEmpty()) {
               for(var11 = 0; var11 < var7.size(); ++var11) {
                  if (((ConsultationEnteteGene)var7.get(var11)).getCsgId() != var9.getCsgId() && ((ConsultationEnteteGene)var7.get(var11)).getCsgFeuille() != null && !((ConsultationEnteteGene)var7.get(var11)).getCsgFeuille().isEmpty() && ((ConsultationEnteteGene)var7.get(var11)).getCsgFeuille().equals(var9.getCsgFeuille())) {
                     var6.add(var9);
                     var6.add(var7.get(var11));
                  }
               }
            }
         }

         if (var6.size() != 0) {
            new DocumentMedical();

            for(var11 = 0; var11 < var6.size(); ++var11) {
               boolean var12 = false;

               for(int var13 = 0; var13 < this.lesSyntheses.size(); ++var13) {
                  if (((ConsultationEnteteGene)var6.get(var11)).getCsgId() == ((DocumentMedical)this.lesSyntheses.get(var13)).getDocId()) {
                     var12 = true;
                     break;
                  }
               }

               if (!var12) {
                  DocumentMedical var14 = new DocumentMedical();
                  var14.setDocId(((ConsultationEnteteGene)var6.get(var11)).getCsgId());
                  var14.setDocDate(((ConsultationEnteteGene)var6.get(var11)).getCsgDate());
                  var14.setDocNum(((ConsultationEnteteGene)var6.get(var11)).getCsgNum());
                  var14.setDocFeuille(((ConsultationEnteteGene)var6.get(var11)).getCsgFeuille());
                  var14.setDocNomPatient(((ConsultationEnteteGene)var6.get(var11)).getCsgNomPatient());
                  var14.setDocEtat(((ConsultationEnteteGene)var6.get(var11)).getCsgEtat());
                  this.lesSyntheses.add(var14);
               }
            }
         }
      }

   }

   public void rechercheControleLaboratoire(String var1, String var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      this.lesSyntheses = new ArrayList();
      ArrayList var6 = new ArrayList();
      new ArrayList();
      this.rechercheLaboratoireSql(var1, var2, var3, var4, var5);
      LaboratoireEnteteDao var8 = new LaboratoireEnteteDao(this.baseLog, this.utilInitHibernate);
      this.var_requete_hql = this.var_requete_hql.replace("laboratoireEntete.", "");
      this.var_requete_hql = this.var_requete_hql + " and labFeuille is not null and labFeuille<>''";
      List var7 = var8.chargerLaboratoireByRequete(this.var_requete_hql, var5);
      this.var_entete = "Doublon des feuilles sur Laboratoires";
      if (var7.size() != 0) {
         new LaboratoireEntete();

         int var11;
         for(int var10 = 0; var10 < var7.size(); ++var10) {
            LaboratoireEntete var9 = (LaboratoireEntete)var7.get(var10);
            if (var9.getLabFeuille() != null && !var9.getLabFeuille().isEmpty()) {
               for(var11 = 0; var11 < var7.size(); ++var11) {
                  if (((LaboratoireEntete)var7.get(var11)).getLabId() != var9.getLabId() && ((LaboratoireEntete)var7.get(var11)).getLabFeuille() != null && !((LaboratoireEntete)var7.get(var11)).getLabFeuille().isEmpty() && ((LaboratoireEntete)var7.get(var11)).getLabFeuille().equals(var9.getLabFeuille())) {
                     var6.add(var9);
                     var6.add(var7.get(var11));
                  }
               }
            }
         }

         if (var6.size() != 0) {
            new DocumentMedical();

            for(var11 = 0; var11 < var6.size(); ++var11) {
               boolean var12 = false;

               for(int var13 = 0; var13 < this.lesSyntheses.size(); ++var13) {
                  if (((LaboratoireEntete)var6.get(var11)).getLabId() == ((DocumentMedical)this.lesSyntheses.get(var13)).getDocId()) {
                     var12 = true;
                     break;
                  }
               }

               if (!var12) {
                  DocumentMedical var14 = new DocumentMedical();
                  var14.setDocId(((LaboratoireEntete)var6.get(var11)).getLabId());
                  var14.setDocDate(((LaboratoireEntete)var6.get(var11)).getLabDate());
                  var14.setDocNum(((LaboratoireEntete)var6.get(var11)).getLabNum());
                  var14.setDocFeuille(((LaboratoireEntete)var6.get(var11)).getLabFeuille());
                  var14.setDocNomPatient(((LaboratoireEntete)var6.get(var11)).getLabNomPatient());
                  var14.setDocEtat(((LaboratoireEntete)var6.get(var11)).getLabEtat());
                  this.lesSyntheses.add(var14);
               }
            }
         }
      }

   }

   public void rechercheControlePharmacie(String var1, String var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      this.lesSyntheses = new ArrayList();
      ArrayList var6 = new ArrayList();
      new ArrayList();
      this.recherchePharmacieSql(var1, var2, var3, var4, var5);
      PharmacieEnteteDao var8 = new PharmacieEnteteDao(this.baseLog, this.utilInitHibernate);
      this.var_requete_hql = this.var_requete_hql.replace("pharmacieEntete.", "");
      this.var_requete_hql = this.var_requete_hql + " and phaFeuille is not null and phaFeuille<>''";
      List var7 = var8.chargerPharmacieByRequete(this.var_requete_hql, var5);
      this.var_entete = "Doublon des feuilles sur Pharmacies";
      if (var7.size() != 0) {
         new PharmacieEntete();

         int var11;
         for(int var10 = 0; var10 < var7.size(); ++var10) {
            PharmacieEntete var9 = (PharmacieEntete)var7.get(var10);
            if (var9.getPhaFeuille() != null && !var9.getPhaFeuille().isEmpty()) {
               for(var11 = 0; var11 < var7.size(); ++var11) {
                  if (((PharmacieEntete)var7.get(var11)).getPhaId() != var9.getPhaId() && ((PharmacieEntete)var7.get(var11)).getPhaFeuille() != null && !((PharmacieEntete)var7.get(var11)).getPhaFeuille().isEmpty() && ((PharmacieEntete)var7.get(var11)).getPhaFeuille().equals(var9.getPhaFeuille())) {
                     var6.add(var9);
                     var6.add(var7.get(var11));
                  }
               }
            }
         }

         if (var6.size() != 0) {
            new DocumentMedical();

            for(var11 = 0; var11 < var6.size(); ++var11) {
               boolean var12 = false;

               for(int var13 = 0; var13 < this.lesSyntheses.size(); ++var13) {
                  if (((PharmacieEntete)var6.get(var11)).getPhaId() == ((DocumentMedical)this.lesSyntheses.get(var13)).getDocId()) {
                     var12 = true;
                     break;
                  }
               }

               if (!var12) {
                  DocumentMedical var14 = new DocumentMedical();
                  var14.setDocId(((PharmacieEntete)var6.get(var11)).getPhaId());
                  var14.setDocDate(((PharmacieEntete)var6.get(var11)).getPhaDate());
                  var14.setDocNum(((PharmacieEntete)var6.get(var11)).getPhaNum());
                  var14.setDocFeuille(((PharmacieEntete)var6.get(var11)).getPhaFeuille());
                  var14.setDocNomPatient(((PharmacieEntete)var6.get(var11)).getPhaNomPatient());
                  var14.setDocEtat(((PharmacieEntete)var6.get(var11)).getPhaEtat());
                  this.lesSyntheses.add(var14);
               }
            }
         }
      }

   }

   public void rechercheControleHospitalisation(String var1, String var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      this.lesSyntheses = new ArrayList();
      ArrayList var6 = new ArrayList();
      new ArrayList();
      this.rechercheLaboratoireSql(var1, var2, var3, var4, var5);
      LaboratoireEnteteDao var8 = new LaboratoireEnteteDao(this.baseLog, this.utilInitHibernate);
      this.var_requete_hql = this.var_requete_hql.replace("laboratoireEntete.", "");
      this.var_requete_hql = this.var_requete_hql + " and labFeuille is not null and labFeuille<>''";
      List var7 = var8.chargerLaboratoireByRequete(this.var_requete_hql, var5);
      this.var_entete = "Doublon des feuilles sur Hospitalisations";
      if (var7.size() != 0) {
         new LaboratoireEntete();

         int var11;
         for(int var10 = 0; var10 < var7.size(); ++var10) {
            LaboratoireEntete var9 = (LaboratoireEntete)var7.get(var10);
            if (var9.getLabFeuille() != null && !var9.getLabFeuille().isEmpty()) {
               for(var11 = 0; var11 < var7.size(); ++var11) {
                  if (((LaboratoireEntete)var7.get(var11)).getLabId() != var9.getLabId() && ((LaboratoireEntete)var7.get(var11)).getLabFeuille() != null && !((LaboratoireEntete)var7.get(var11)).getLabFeuille().isEmpty() && ((LaboratoireEntete)var7.get(var11)).getLabFeuille().equals(var9.getLabFeuille())) {
                     var6.add(var9);
                     var6.add(var7.get(var11));
                  }
               }
            }
         }

         if (var6.size() != 0) {
            new DocumentMedical();

            for(var11 = 0; var11 < var6.size(); ++var11) {
               boolean var12 = false;

               for(int var13 = 0; var13 < this.lesSyntheses.size(); ++var13) {
                  if (((LaboratoireEntete)var6.get(var11)).getLabId() == ((DocumentMedical)this.lesSyntheses.get(var13)).getDocId()) {
                     var12 = true;
                     break;
                  }
               }

               if (!var12) {
                  DocumentMedical var14 = new DocumentMedical();
                  var14.setDocId(((LaboratoireEntete)var6.get(var11)).getLabId());
                  var14.setDocDate(((LaboratoireEntete)var6.get(var11)).getLabDate());
                  var14.setDocNum(((LaboratoireEntete)var6.get(var11)).getLabNum());
                  var14.setDocFeuille(((LaboratoireEntete)var6.get(var11)).getLabFeuille());
                  var14.setDocNomPatient(((LaboratoireEntete)var6.get(var11)).getLabNomPatient());
                  var14.setDocEtat(((LaboratoireEntete)var6.get(var11)).getLabEtat());
                  this.lesSyntheses.add(var14);
               }
            }
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

   public String calculMedecin(long var1) {
      String var3 = "???";

      for(int var4 = 0; var4 < this.mesMedecinsItems.size(); ++var4) {
         if (Long.parseLong(((SelectItem)this.mesMedecinsItems.get(var4)).getValue().toString()) == var1) {
            var3 = ((SelectItem)this.mesMedecinsItems.get(var4)).getLabel().toString();
            break;
         }
      }

      return var3;
   }

   public ExercicesVentes getExoSelectionne() {
      return this.exoSelectionne;
   }

   public void setExoSelectionne(ExercicesVentes var1) {
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

   public OptionMedical getOptionMedical() {
      return this.optionMedical;
   }

   public void setOptionMedical(OptionMedical var1) {
      this.optionMedical = var1;
   }

   public List getMesEtatsItems() {
      return this.mesEtatsItems;
   }

   public void setMesEtatsItems(List var1) {
      this.mesEtatsItems = var1;
   }

   public List getMesSeriesItems() {
      return this.mesSeriesItems;
   }

   public void setMesSeriesItems(List var1) {
      this.mesSeriesItems = var1;
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

   public DataModel getDatamodelDestinataire() {
      return this.datamodelDestinataire;
   }

   public void setDatamodelDestinataire(DataModel var1) {
      this.datamodelDestinataire = var1;
   }

   public boolean isShowModalPanelDestinataire() {
      return this.showModalPanelDestinataire;
   }

   public void setShowModalPanelDestinataire(boolean var1) {
      this.showModalPanelDestinataire = var1;
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

   public String getParc() {
      return this.parc;
   }

   public void setParc(String var1) {
      this.parc = var1;
   }

   public String getNomTiers() {
      return this.nomTiers;
   }

   public void setNomTiers(String var1) {
      this.nomTiers = var1;
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

   public String getNomRepertoire() {
      return this.nomRepertoire;
   }

   public void setNomRepertoire(String var1) {
      this.nomRepertoire = var1;
   }

   public String getNomSigle() {
      return this.nomSigle;
   }

   public void setNomSigle(String var1) {
      this.nomSigle = var1;
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

   public boolean isTestafficheDocument() {
      return this.testafficheDocument;
   }

   public void setTestafficheDocument(boolean var1) {
      this.testafficheDocument = var1;
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

   public String getResponsable() {
      return this.responsable;
   }

   public void setResponsable(String var1) {
      this.responsable = var1;
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

   public String getFormat() {
      return this.format;
   }

   public void setFormat(String var1) {
      this.format = var1;
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

   public String getLaboratoire() {
      return this.laboratoire;
   }

   public void setLaboratoire(String var1) {
      this.laboratoire = var1;
   }

   public String getPharmacie() {
      return this.pharmacie;
   }

   public void setPharmacie(String var1) {
      this.pharmacie = var1;
   }

   public List getLesModelesAutorises() {
      return this.lesModelesAutorises;
   }

   public void setLesModelesAutorises(List var1) {
      this.lesModelesAutorises = var1;
   }

   public List getMesServicesItems() {
      return this.mesServicesItems;
   }

   public void setMesServicesItems(List var1) {
      this.mesServicesItems = var1;
   }

   public String getSite() {
      return this.site;
   }

   public void setSite(String var1) {
      this.site = var1;
   }

   public boolean isInfirmerie() {
      return this.infirmerie;
   }

   public void setInfirmerie(boolean var1) {
      this.infirmerie = var1;
   }

   public List getMesMedecinsItems() {
      return this.mesMedecinsItems;
   }

   public void setMesMedecinsItems(List var1) {
      this.mesMedecinsItems = var1;
   }

   public long getMedecin() {
      return this.medecin;
   }

   public void setMedecin(long var1) {
      this.medecin = var1;
   }

   public int getTypeTiers() {
      return this.typeTiers;
   }

   public void setTypeTiers(int var1) {
      this.typeTiers = var1;
   }
}
