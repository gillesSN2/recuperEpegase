package com.epegase.forms.immobilier;

import com.epegase.systeme.classe.Bien;
import com.epegase.systeme.classe.BienBail;
import com.epegase.systeme.classe.BienFacture;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.classe.Reglements;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.EtatDocument;
import com.epegase.systeme.dao.BienBailDao;
import com.epegase.systeme.dao.BienDao;
import com.epegase.systeme.dao.BienFactureDao;
import com.epegase.systeme.dao.ReglementsDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilPrint;
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
import org.hibernate.Transaction;
import org.jdom.JDOMException;

public class FormImpressionImmobilier implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private ExercicesVentes exoSelectionne;
   private OptionVentes optionVentes;
   private UtilDate utilDate;
   private int typeImmobilier;
   private String libelleImmobilier;
   private String pageIndex;
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
   private Date filtreDateDebut;
   private Date filtreDateFin;
   private String nomLocataire;
   private String nomProprietaire;
   private String codeBien;
   private String serie;
   private String etat;
   private int etatBien;
   private String categorie;
   private String commercial;
   private String responsable;
   private String createur;
   private String var_entete;
   private String var_filtre;
   private String var_requete;
   private String var_num_bordereau;
   private List mesSeriesItems = new ArrayList();
   private List mesEtatsItems = new ArrayList();
   private List mesBiensRecItems;
   private UtilPrint utilPrint;
   private boolean affMail = false;
   private String format = "PDF";
   private boolean var_affiche_impression = false;
   private String impDestinataire;
   private String impDestinataireCC;
   private String impDestinataireCCI;
   private String impEmetteur;
   private boolean var_ctrl_imp = false;
   private boolean showModalPanelTiersLocataire = false;
   private boolean showModalPanelTiersProprietaire = false;
   private transient DataModel datamodelTiers = new ListDataModel();
   private Tiers tiers;
   private boolean showModalPanelDestinataire;
   private transient DataModel datamodelDestinataire = new ListDataModel();
   private PlansAnalytiques plansAnalytiques;
   private boolean showModalPanelBiens = false;
   private Bien bien;
   private transient DataModel dataModelBiens;
   private List lesModelesAutorises;

   public FormImpressionImmobilier() {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.utilDate = new UtilDate();
      this.dataModelBiens = new ListDataModel();
      this.mesBiensRecItems = new ArrayList();
   }

   public void InstancesDaoUtilses() {
   }

   public void chargerLesRepImpLocation(Session var1) throws HibernateException, NamingException {
      this.lesRepImpression.clear();
      String var2 = "";
      if (this.typeImmobilier == 1) {
         this.libelleImmobilier = "SYNDIC";
         var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "clientSyndic";
      } else if (this.typeImmobilier == 2) {
         this.libelleImmobilier = "NEGOCE";
         var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "clientNegoce";
      } else {
         this.libelleImmobilier = "LOCATION";
         var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "clientLocation";
      }

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
               boolean var7 = this.calculeVisible(var6, var1);
               if (var7) {
                  this.lesRepImpression.add(var6);
               }
            }
         }
      }

      this.dataModelImpgen.setWrappedData(this.lesRepImpression);
      this.mesBiensRecItems.clear();
      if (this.typeImmobilier == 1) {
         new ArrayList();
         BienDao var9 = new BienDao(this.baseLog, this.utilInitHibernate);
         List var8 = var9.chargeBien(1, 9, var1);
         if (var8.size() != 0) {
            for(int var10 = 0; var10 < var8.size(); ++var10) {
               if (((Bien)var8.get(var10)).getBieType() == 2) {
                  this.mesBiensRecItems.add(new SelectItem(((Bien)var8.get(var10)).getBieNum() + ":" + ((Bien)var8.get(var10)).getBieNom()));
               }
            }
         }
      }

   }

   public boolean calculeVisible(String var1, Session var2) {
      boolean var3 = false;
      int var4 = 0;
      if (var1 != null && !var1.isEmpty()) {
         Object var5;
         if (var1.contains("BAIL")) {
            var5 = var2.createQuery("SELECT COUNT(*) FROM BienBail").uniqueResult();
            var4 = Integer.parseInt(var5.toString());
         } else if (var1.contains("BIEN")) {
            var5 = var2.createQuery("SELECT COUNT(*) FROM Bien").uniqueResult();
            var4 = Integer.parseInt(var5.toString());
         } else if (var1.contains("FACTURE_CHARGE")) {
            var5 = var2.createQuery("SELECT COUNT(*) FROM BienTravauxLigne").uniqueResult();
            var4 = Integer.parseInt(var5.toString());
         } else if (!var1.contains("FACTURE_LOCATION") && !var1.contains("DECLARATION") && !var1.contains("IMPAYES")) {
            if (var1.contains("GERANCE")) {
               var5 = var2.createQuery("SELECT COUNT(*) FROM BienGeranceEntete").uniqueResult();
               var4 = Integer.parseInt(var5.toString());
            } else if (var1.contains("OT")) {
               var5 = var2.createQuery("SELECT COUNT(*) FROM BienTravauxEntete").uniqueResult();
               var4 = Integer.parseInt(var5.toString());
            } else if (var1.contains("BUDGET")) {
               var5 = var2.createQuery("SELECT COUNT(*) FROM BienBudgetEntete").uniqueResult();
               var4 = Integer.parseInt(var5.toString());
            } else if (var1.contains("APPEL_CHARGE")) {
               var5 = var2.createQuery("SELECT COUNT(*) FROM AppelCharge").uniqueResult();
               var4 = Integer.parseInt(var5.toString());
            } else if (var1.contains("ENCAISSEMENT_LOCATION")) {
               var5 = var2.createQuery("SELECT COUNT(*) FROM Reglements").uniqueResult();
               var4 = Integer.parseInt(var5.toString());
            }
         } else {
            var5 = var2.createQuery("SELECT COUNT(*) FROM BienFacture").uniqueResult();
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

   public void recupererNomrep() throws HibernateException, NamingException {
      this.testafficheLigne = false;
      this.testafficheDocument = false;
      if (this.dataModelImpgen.isRowAvailable()) {
         this.nomRepertoire = (String)this.dataModelImpgen.getRowData();
         this.nomRepertoire = this.nomRepertoire.toLowerCase();
         this.nomEtat = "";
         if (this.nomRepertoire.contains("bail")) {
            this.nature = 162;
         } else if (this.nomRepertoire.contains("bien")) {
            this.nature = 160;
         } else if (this.nomRepertoire.contains("facture")) {
            this.nature = 165;
         } else if (this.nomRepertoire.contains("impayes")) {
            this.nature = 165;
         } else if (this.nomRepertoire.contains("gerance")) {
            this.nature = 161;
         } else if (this.nomRepertoire.contains("ot")) {
            this.nature = 163;
         } else if (this.nomRepertoire.contains("encaissement")) {
            this.nature = 165;
         } else {
            this.nature = 0;
         }

         if (this.nomRepertoire.contains("_synthese")) {
            this.testafficheDocument = true;
         }

         this.lesFichImpression.clear();
         String var1 = null;
         if (this.typeImmobilier == 1) {
            var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "clientSyndic" + File.separator + this.nomRepertoire;
         } else if (this.typeImmobilier == 2) {
            var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "clientNegoce" + File.separator + this.nomRepertoire;
         } else {
            var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "clientLocation" + File.separator + this.nomRepertoire;
         }

         this.testafficheLigne = false;
         File var2 = new File(var1);
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

   public void rechercheTiersLocataire() throws HibernateException, NamingException {
      Object var1 = new ArrayList();
      if (this.nomLocataire != null && !this.nomLocataire.isEmpty()) {
         String var2 = "(2,3)";
         TiersDao var3 = new TiersDao(this.baseLog, this.utilInitHibernate);
         var1 = var3.verifTiers(this.usersLog, var2, this.nomLocataire, (Session)null);
         this.showModalPanelTiersLocataire = true;
      }

      this.datamodelTiers.setWrappedData(var1);
   }

   public void selectionligneTiersLocataire() throws JDOMException, IOException {
      if (this.datamodelTiers.isRowAvailable()) {
         this.tiers = (Tiers)this.datamodelTiers.getRowData();
      }

   }

   public void calculeTiersLocataire() throws JDOMException, IOException {
      if (this.tiers == null) {
         this.selectionligneTiersLocataire();
      }

      if (this.tiers != null) {
         this.nomLocataire = this.tiers.getTieraisonsocialenom();
      } else {
         this.tiers = null;
         this.nomLocataire = "";
      }

      this.showModalPanelTiersLocataire = false;
   }

   public void annuleTiersLocataire() {
      this.tiers = null;
      this.nomLocataire = "";
      this.showModalPanelTiersLocataire = false;
   }

   public void rechercheTiersProprietaire() throws HibernateException, NamingException {
      Object var1 = new ArrayList();
      if (this.nomProprietaire != null && !this.nomProprietaire.isEmpty()) {
         String var2 = "(0)";
         TiersDao var3 = new TiersDao(this.baseLog, this.utilInitHibernate);
         var1 = var3.verifTiers(this.usersLog, var2, this.nomProprietaire, (Session)null);
         this.showModalPanelTiersProprietaire = true;
      }

      this.datamodelTiers.setWrappedData(var1);
   }

   public void selectionligneTiersProprietaire() throws JDOMException, IOException {
      if (this.datamodelTiers.isRowAvailable()) {
         this.tiers = (Tiers)this.datamodelTiers.getRowData();
      }

   }

   public void calculeTiersProprietaire() throws JDOMException, IOException {
      if (this.tiers == null) {
         this.selectionligneTiersProprietaire();
      }

      if (this.tiers != null) {
         this.nomProprietaire = this.tiers.getTieraisonsocialenom();
      } else {
         this.tiers = null;
         this.nomProprietaire = "";
      }

      this.showModalPanelTiersProprietaire = false;
   }

   public void annuleTiersProprietaire() {
      this.tiers = null;
      this.nomProprietaire = "";
      this.showModalPanelTiersProprietaire = false;
   }

   public void rechercheBiens() throws HibernateException, NamingException {
      Object var1 = new ArrayList();
      if (this.codeBien != null && !this.codeBien.isEmpty()) {
         BienDao var2 = new BienDao(this.baseLog, this.utilInitHibernate);
         var1 = var2.chargeBien(this.typeImmobilier, 9, this.codeBien, (Session)null);
         this.showModalPanelBiens = true;
      }

      this.dataModelBiens.setWrappedData(var1);
   }

   public void selectionligneBiens() throws JDOMException, IOException {
      if (this.dataModelBiens.isRowAvailable()) {
         this.bien = (Bien)this.dataModelBiens.getRowData();
      }

   }

   public void calculeBiens() throws JDOMException, IOException {
      if (this.bien == null) {
         this.selectionligneBiens();
      }

      if (this.bien != null) {
         this.codeBien = this.bien.getBieNum() + ":" + this.bien.getBieNom();
      } else {
         this.bien = null;
         this.codeBien = "";
      }

      this.showModalPanelBiens = false;
   }

   public void annuleBiens() {
      this.bien = null;
      this.codeBien = "";
      this.showModalPanelBiens = false;
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
         this.calculeRequete();
         this.utilPrint.setRapport(this.nomEtat);
         if (this.typeImmobilier == 1) {
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "clientSyndic" + File.separator + this.nomRepertoire + File.separator);
         } else if (this.typeImmobilier == 2) {
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "clientNegoce" + File.separator + this.nomRepertoire + File.separator);
         } else {
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "clientLocation" + File.separator + this.nomRepertoire + File.separator);
         }

         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "sous_rapport" + File.separator);
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

         this.utilPrint.setDateDeb(this.filtreDateDebut);
         this.utilPrint.setDateFin(this.filtreDateFin);
         this.utilPrint.setCompte(this.var_num_bordereau);
         if (this.nomRepertoire.contains("synthese")) {
            this.utilPrint.setRequete("");
            JRBeanCollectionDataSource var1 = new JRBeanCollectionDataSource(this.listDocument);
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
         this.utilPrint.setAnnexe1(this.utilDate.dateToStringSQL(this.filtreDateFin));
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
      String var3 = var1.substring(6, 10) + "-" + var1.substring(3, 5) + "-" + var1.substring(0, 2);
      String var4 = this.utilDate.dateToStringFr(this.filtreDateFin);
      String var5 = var4.substring(6, 10) + "-" + var4.substring(3, 5) + "-" + var4.substring(0, 2) + " 23:59:59";
      String var6 = var4.substring(6, 10) + "-" + var4.substring(3, 5) + "-" + var4.substring(0, 2);
      String var7 = this.utilDate.dateToStringFr(this.filtreDateDebut);
      String var8 = this.utilDate.dateToStringFr(this.filtreDateFin);
      if (this.typeImmobilier == 0) {
         if (this.nomRepertoire.equalsIgnoreCase("bail")) {
            this.rechercheBailSql(var7, var8, var3, var6);
         } else if (this.nomRepertoire.equalsIgnoreCase("bien")) {
            this.calculBailByBien();
            this.rechercheBienSql(var7, var8);
         } else if (this.nomRepertoire.equalsIgnoreCase("facture_location")) {
            this.rechercheFactureLocationSql(var7, var8, var2, var5);
         } else if (this.nomRepertoire.contains("impaye")) {
            this.rechercheFactureLocationSql(var7, var8, var2, var5);
         } else if (this.nomRepertoire.equalsIgnoreCase("declaration")) {
            this.rechercheFactureLocationEncaisseeSql(var7, var8, var2, var5);
         } else if (this.nomRepertoire.equalsIgnoreCase("gerance")) {
            this.rechercheGeranceSql(var7, var8, var3, var6);
         } else if (this.nomRepertoire.equalsIgnoreCase("ot")) {
            this.rechercheOtSql(var7, var8, var2, var5);
         } else if (this.nomRepertoire.contains("encaissement_location")) {
            this.rechercheReglementLocationSql(var7, var8, var2, var5);
         }
      } else if (this.typeImmobilier == 1) {
         if (this.nomRepertoire.contains("impaye")) {
            this.rechercheAppelChargeSql(var7, var8, var2, var5);
         }
      } else if (this.typeImmobilier == 2) {
      }

   }

   public void calculBailByBien() throws HibernateException, NamingException {
      BienDao var1 = new BienDao(this.baseLog, this.utilInitHibernate);
      BienBailDao var2 = new BienBailDao(this.baseLog, this.utilInitHibernate);
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         new ArrayList();
         List var5 = var1.chargeBien(9, 9, var3);
         if (var5.size() != 0) {
            this.bien = new Bien();

            for(int var6 = 0; var6 < var5.size(); ++var6) {
               this.bien = (Bien)var5.get(var6);
               this.bien.setBieTmpBail("");
               this.bien.setBieTmpFacturation(0);
               this.bien.setBieTmpUsage(0);
               this.bien.setBieTmpLocataire("");
               this.bien.setBieTmpLoyer(0.0D);
               this.bien = var1.modif(this.bien, var3);
            }

            var3.flush();
         }

         new ArrayList();
         List var16 = var2.chargerBauxAvecFactures(var3);
         if (var5.size() != 0 && var16.size() != 0) {
            this.bien = new Bien();
            int var7 = 0;

            while(true) {
               if (var7 >= var5.size()) {
                  var3.flush();
                  break;
               }

               this.bien = (Bien)var5.get(var7);
               boolean var8 = false;
               BienBail var9 = new BienBail();

               for(int var10 = 0; var10 < var16.size(); ++var10) {
                  var9 = (BienBail)var16.get(var10);
                  if (var9.getBien().getBieId() == this.bien.getBieId()) {
                     var8 = true;
                     break;
                  }
               }

               var8 = true;
               if (true) {
                  this.bien.setBieTmpBail(var9.getBiebaiNum());
                  this.bien.setBieTmpFacturation(var9.getBiebaiMode());
                  this.bien.setBieTmpUsage(var9.getBiebaiUsage());
                  this.bien.setBieTmpLocataire(var9.getBiebaiNomTiers());
                  this.bien.setBieTmpLoyer(var9.getBiebaiLoyerNet());
                  this.bien = var1.modif(this.bien, var3);
               }

               ++var7;
            }
         }

         var4.commit();
      } catch (HibernateException var14) {
         if (var4 != null) {
            var4.rollback();
         }

         throw var14;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void rechercheBienSql(String var1, String var2) throws HibernateException, NamingException {
      if (this.etatBien == 0) {
         this.var_filtre = "Biens gérés par l'agence (Biens libres)";
      } else if (this.etatBien == 1) {
         this.var_filtre = "Biens gérés par l'agence (Biens occupés)";
      } else if (this.etatBien == 2) {
         this.var_filtre = "Biens gérés par l'agence (Tous les Biens)";
      } else if (this.etatBien == 8) {
         this.var_filtre = "Biens plus gérés par l'agence";
      } else {
         this.var_filtre = "???";
      }

      this.var_entete = "Liste des Biens ";
      if (this.etatBien == 0) {
         if (this.typeImmobilier == 0) {
            this.var_requete = "(bie_categorie=0 or bie_categorie=3 or bie_categorie=4 or bie_categorie=6) and bie_gestion=0 and bie_occupe=0";
         } else if (this.typeImmobilier == 1) {
            this.var_requete = "(bie_categorie=1 or bie_categorie=3 or bie_categorie=5 or bie_categorie=6) and bie_gestion=0 and bie_occupe=0";
         } else if (this.typeImmobilier == 2) {
            this.var_requete = "(bie_categorie=2 or bie_categorie=4 or bie_categorie=5 or bie_categorie=6) and bie_gestion=0 and bie_occupe=0";
         } else {
            this.var_requete = "bie_categorie>=0 and bie_categorie<=6 and bie_gestion=0 and bie_occupe=0";
         }
      } else if (this.etatBien == 1) {
         if (this.typeImmobilier == 0) {
            this.var_requete = "(bie_categorie=0 or bie_categorie=3 or bie_categorie=4 or bie_categorie=6) and bie_gestion=0 and bie_occupe=1";
         } else if (this.typeImmobilier == 1) {
            this.var_requete = "(bie_categorie=1 or bie_categorie=3 or bie_categorie=5 or bie_categorie=6) and bie_gestion=0 and bie_occupe=1";
         } else if (this.typeImmobilier == 2) {
            this.var_requete = "(bie_categorie=2 or bie_categorie=4 or bie_categorie=5 or bie_categorie=6) and bie_gestion=0 and bie_occupe=1";
         } else {
            this.var_requete = "bie_categorie>=0 and bie_categorie<=6 and bie_gestion=0 and bie_occupe=1";
         }
      } else if (this.etatBien == 2) {
         if (this.typeImmobilier == 0) {
            this.var_requete = "(bie_categorie=0 or bie_categorie=3 or bie_categorie=4 or bie_categorie=6) and bie_gestion=0";
         } else if (this.typeImmobilier == 1) {
            this.var_requete = "(bie_categorie=1 or bie_categorie=3 or bie_categorie=5 or bie_categorie=6) and bie_gestion=0";
         } else if (this.typeImmobilier == 2) {
            this.var_requete = "(bie_categorie=2 or bie_categorie=4 or bie_categorie=5 or bie_categorie=6) and bie_gestion=0";
         } else {
            this.var_requete = "bie_categorie>=0 and bie_categorie<=6 and bie_gestion=0";
         }
      } else if (this.etatBien == 8) {
         if (this.typeImmobilier == 0) {
            this.var_requete = "(bie_categorie=0 or bie_categorie=3 or bie_categorie=4 or bie_categorie=6) and bie_gestion=1";
         } else if (this.typeImmobilier == 1) {
            this.var_requete = "(bie_categorie=1 or bie_categorie=3 or bie_categorie=5 or bie_categorie=6) and bie_gestion=1";
         } else if (this.typeImmobilier == 2) {
            this.var_requete = "(bie_categorie=2 or bie_categorie=4 or bie_categorie=5 or bie_categorie=6) and bie_gestion=1";
         } else {
            this.var_requete = "bie_categorie>=0 and bie_categorie<=6 and bie_gestion=1";
         }
      }

      if (this.codeBien != null && !this.codeBien.isEmpty()) {
         this.var_filtre = this.var_filtre + " Bien = " + this.codeBien;
         String[] var3 = this.codeBien.split(":");
         this.var_requete = this.var_requete + " and bie_num='" + var3[0] + "'";
      }

      if (this.nomProprietaire != null && !this.nomProprietaire.isEmpty()) {
         this.var_filtre = this.var_filtre + " Propriétaire = " + this.nomProprietaire;
         this.var_requete = this.var_requete + " and bie_nom_tiers='" + this.nomProprietaire + "'";
      }

      if (this.createur != null && !this.createur.isEmpty() && !this.createur.equals("100")) {
         UserDao var5 = new UserDao(this.baseLog, this.utilInitHibernate);
         String var4 = var5.selectByIdUsers(Long.parseLong(this.createur), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Créateur = " + var4;
         this.var_requete = this.var_requete + " and bie_user_creat=" + Long.parseLong(this.createur);
      }

   }

   public void rechercheBailSql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      String var5 = "Liste des Baux";
      if (this.nomEtat.contains("Locatif")) {
         var5 = "Etat locatif";
      }

      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = var5 + " du " + var1 + " au " + var2 + " Série : Toutes";
         this.var_requete = "((biebai_date_fin is null) or (biebai_date_fin is not null and biebai_date_debut>='" + var3 + "' and biebai_date_debut<='" + var4 + "' and biebai_date_fin>='" + var3 + "' and biebai_date_fin<='" + var4 + "'))";
      } else {
         this.var_entete = var5 + " du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "((biebai_date_fin is null) or (biebai_date_fin is not null and biebai_date_debut>='" + var3 + "' and biebai_date_debut<='" + var4 + "' and biebai_date_fin>='" + var3 + "' and biebai_date_fin<='" + var4 + "')) and biebai_serie='" + this.serie + "'";
      }

      if (this.etat != null && !this.etat.isEmpty() && !this.etat.equals("100")) {
         int var6 = Integer.parseInt(this.etat);
         if (var6 == 0) {
            this.var_filtre = this.var_filtre + " Etat = En cours";
            this.var_requete = this.var_requete + " and biebai_etat=" + var6;
         } else if (var6 == 1) {
            this.var_filtre = this.var_filtre + " Etat = Validé";
            this.var_requete = this.var_requete + " and biebai_etat=" + var6;
         } else if (var6 == 2) {
            this.var_filtre = this.var_filtre + " Etat = Gelé";
            this.var_requete = this.var_requete + " and biebai_etat=" + var6;
         } else if (var6 == 3) {
            this.var_filtre = this.var_filtre + " Etat = Annulé";
            this.var_requete = this.var_requete + " and biebai_etat=" + var6;
         } else if (var6 == 11) {
            this.var_filtre = this.var_filtre + " Etat = Terminé";
            this.var_requete = this.var_requete + " and biebai_etat=" + var6;
         }
      }

      if (this.codeBien != null && !this.codeBien.isEmpty()) {
         this.var_filtre = this.var_filtre + " Bien = " + this.codeBien;
         String[] var8 = this.codeBien.split(":");
         this.var_requete = this.var_requete + " and biebai_local='" + var8[0] + "'";
      }

      if (this.nomLocataire != null && !this.nomLocataire.isEmpty()) {
         this.var_filtre = this.var_filtre + " Locataire = " + this.nomLocataire;
         this.var_requete = this.var_requete + " and biebai_nom_tiers='" + this.nomLocataire + "'";
      }

      if (this.nomProprietaire != null && !this.nomProprietaire.isEmpty()) {
         this.var_filtre = this.var_filtre + " Propriétaire = " + this.nomProprietaire;
         this.var_requete = this.var_requete + " and biebai_nom_proprietaire='" + this.nomProprietaire + "'";
      }

      String var7;
      UserDao var9;
      if (this.responsable != null && !this.responsable.isEmpty() && !this.responsable.equals("100")) {
         var9 = new UserDao(this.baseLog, this.utilInitHibernate);
         var7 = var9.selectByIdUsers(Long.parseLong(this.responsable), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Responsable = " + var7;
         this.var_requete = this.var_requete + " and biebai_id_responsable=" + this.responsable;
      }

      if (this.createur != null && !this.createur.isEmpty() && !this.createur.equals("100")) {
         var9 = new UserDao(this.baseLog, this.utilInitHibernate);
         var7 = var9.selectByIdUsers(Long.parseLong(this.createur), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Créateur = " + var7;
         this.var_requete = this.var_requete + " and biebai_user_creat=" + this.createur;
      }

   }

   public void rechercheGeranceSql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Liste des Gérances du " + var1 + " au " + var2 + " Série : Toutes";
         this.var_requete = "biegerent_date_debut>='" + var3 + "' and biegerent_date_debut<='" + var4 + "'";
      } else {
         this.var_entete = "Liste des Gérances du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "biegerent_date_debut>='" + var3 + "' and biegerent_date_debut<='" + var4 + "' and biegerent_serie='" + this.serie + "'";
      }

      if (this.etat != null && !this.etat.isEmpty() && !this.etat.equals("101")) {
         int var5 = Integer.parseInt(this.etat);
         if (var5 == 0) {
            this.var_filtre = this.var_filtre + " Etat = En cours";
            this.var_requete = this.var_requete + " and biegerent_etat=" + var5;
         } else if (var5 == 1) {
            this.var_filtre = this.var_filtre + " Etat = Validé";
            this.var_requete = this.var_requete + " and biegerent_etat=" + var5;
         } else if (var5 == 2) {
            this.var_filtre = this.var_filtre + " Etat = Gelé";
            this.var_requete = this.var_requete + " and biegerent_etat=" + var5;
         } else if (var5 == 3) {
            this.var_filtre = this.var_filtre + " Etat = Annulé";
            this.var_requete = this.var_requete + " and biegerent_etat=" + var5;
         } else if (var5 == 11) {
            this.var_filtre = this.var_filtre + " Etat = Terminé";
            this.var_requete = this.var_requete + " and biegerent_etat=" + var5;
         }
      }

      if (this.nomProprietaire != null && !this.nomProprietaire.isEmpty()) {
         this.var_filtre = this.var_filtre + " Propriétaire = " + this.nomProprietaire;
         this.var_requete = this.var_requete + " and biegerent_nom_tiers='" + this.nomProprietaire + "'";
      }

      String var6;
      UserDao var7;
      if (this.responsable != null && !this.responsable.isEmpty() && !this.responsable.equals("100")) {
         var7 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var7.selectByIdUsers(Long.parseLong(this.responsable), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Responsable = " + var6;
         this.var_requete = this.var_requete + " and biegerent_id_responsable=" + this.responsable;
      }

      if (this.createur != null && !this.createur.isEmpty() && !this.createur.equals("100")) {
         var7 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var7.selectByIdUsers(Long.parseLong(this.createur), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Créateur = " + var6;
         this.var_requete = this.var_requete + " and biegerent_user_creat=" + this.createur;
      }

   }

   public void rechercheFactureLocationSql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      String var5 = "Liste des Factures";
      if (this.nomEtat.contains("TOM")) {
         var5 = "Releve de TOM";
      } else if (this.nomEtat.contains("TLV")) {
         var5 = "Releve de TLV";
      } else if (this.nomEtat.contains("IRPP")) {
         var5 = "Releve IRPP";
      } else if (this.nomEtat.contains("TVA")) {
         var5 = "Releve de TVA";
      } else if (this.nomRepertoire.contains("impayes")) {
         var5 = "Impayés";
      } else if (this.nomEtat.contains("soldee")) {
         var5 = "Factures soldées";
      }

      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = var5 + " du " + var1 + " au " + var2 + " Série : Toutes";
         this.var_requete = "biefac_date>='" + var3 + "' and biefac_date<='" + var4 + "'";
      } else {
         this.var_entete = var5 + " du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "biefac_date>='" + var3 + "' and biefac_date<='" + var4 + "' and biefac_serie='" + this.serie + "'";
      }

      if (this.etat != null && !this.etat.isEmpty() && !this.etat.equals("101")) {
         int var6 = Integer.parseInt(this.etat);
         if (var6 == 0) {
            this.var_filtre = this.var_filtre + " Etat = En cours";
            this.var_requete = this.var_requete + " and biefac_etat=" + var6;
         } else if (var6 == 1) {
            this.var_filtre = this.var_filtre + " Etat = Validé";
            this.var_requete = this.var_requete + " and biefac_etat=" + var6;
         } else if (var6 == 2) {
            this.var_filtre = this.var_filtre + " Etat = Gelé";
            this.var_requete = this.var_requete + " and biefac_etat=" + var6;
         } else if (var6 == 3) {
            this.var_filtre = this.var_filtre + " Etat = Annulé";
            this.var_requete = this.var_requete + " and biefac_etat=" + var6;
         } else if (var6 == 11) {
            this.var_filtre = this.var_filtre + " Etat = Relancé";
            this.var_requete = this.var_requete + " and biefac_date_relance!=null";
         } else if (var6 == 12) {
            this.var_filtre = this.var_filtre + " Etat = Promotion";
            this.var_requete = this.var_requete + " and biefac_tot_ht=0";
         } else if (var6 == 13) {
            this.var_filtre = this.var_filtre + " Etat = Non payé";
            this.var_requete = this.var_requete + " and biefac_solde=0";
         } else if (var6 == 14) {
            this.var_filtre = this.var_filtre + " Etat = Payé";
            this.var_requete = this.var_requete + " and biefac_solde=1";
         } else if (var6 == 15) {
            this.var_filtre = this.var_filtre + " Etat = Exonéré";
            this.var_requete = this.var_requete + " and biefac_exo_tva=1";
         } else if (var6 == 16) {
            this.var_filtre = this.var_filtre + " Etat = Attente de visa";
            this.var_requete = this.var_requete + " and biefac_date_visa=null";
         } else if (var6 == 17) {
            this.var_filtre = this.var_filtre + " Trf = Transféré en compta";
            this.var_requete = this.var_requete + " and biefac_date_transfert!=null";
         } else if (var6 == 18) {
            this.var_filtre = this.var_filtre + " Trf = Non transféré en compta";
            this.var_requete = this.var_requete + " and biefac_date_transfert=null";
         }
      }

      if (this.codeBien != null && !this.codeBien.isEmpty()) {
         this.var_filtre = this.var_filtre + " Bien = " + this.codeBien;
         String[] var8 = this.codeBien.split(":");
         this.var_requete = this.var_requete + " and biefac_bien='" + var8[0] + "'";
      }

      if (this.nomLocataire != null && !this.nomLocataire.isEmpty()) {
         this.var_filtre = this.var_filtre + " Locataire = " + this.nomLocataire;
         this.var_requete = this.var_requete + " and biefac_nom_tiers='" + this.nomLocataire + "'";
      }

      if (this.nomProprietaire != null && !this.nomProprietaire.isEmpty()) {
         this.var_filtre = this.var_filtre + " Propriétaire = " + this.nomProprietaire;
         this.var_requete = this.var_requete + " and biefac_nom_proprietaire='" + this.nomProprietaire + "'";
      }

      if (this.createur != null && !this.createur.isEmpty() && !this.createur.equals("100")) {
         UserDao var9 = new UserDao(this.baseLog, this.utilInitHibernate);
         String var7 = var9.selectByIdUsers(Long.parseLong(this.createur), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Créateur = " + var7;
         this.var_requete = this.var_requete + " and biefac_id_createur=" + this.createur;
      }

   }

   public void rechercheFactureLocationEncaisseeSql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      String var5 = "Liste des Factures";
      if (this.nomEtat.contains("TOM")) {
         var5 = "Releve de TOM";
      } else if (this.nomEtat.contains("TLV")) {
         var5 = "Releve de TLV";
      } else if (this.nomEtat.contains("IRPP")) {
         var5 = "Releve IRPP";
      } else if (this.nomEtat.contains("TVA")) {
         var5 = "Releve de TVA";
      }

      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = var5 + " du " + var1 + " au " + var2 + " Série : Toutes";
         this.var_requete = "rgl_date_reg>='" + var3 + "' and rgl_date_reg<='" + var4 + "' and rgl_nature_doc=165 and rgl_id_document<>0";
      } else {
         this.var_entete = var5 + " du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "rgl_date_reg>='" + var3 + "' and rgl_date_reg<='" + var4 + "' and rgl_serie='" + this.serie + "' and rgl_nature_doc=165 and rgl_id_document<>0";
      }

      BienFactureDao var6 = new BienFactureDao(this.baseLog, this.utilInitHibernate);
      String var7 = "";
      Session var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
      Transaction var9 = null;

      try {
         var9 = var8.beginTransaction();
         new ArrayList();
         ReglementsDao var11 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
         List var10 = var11.rechercheReglementsRequete(this.var_requete, var8);
         if (var10.size() != 0) {
            for(int var12 = 0; var12 < var10.size(); ++var12) {
               if (var7 != null && !var7.isEmpty()) {
                  var7 = var7 + "," + ((Reglements)var10.get(var12)).getRglIdDocument();
               } else {
                  var7 = "" + ((Reglements)var10.get(var12)).getRglIdDocument();
               }
            }

            if (var7 != null && !var7.isEmpty()) {
               new ArrayList();
               String var13 = "biefac_id in (" + var7 + ")";
               List var26 = var6.rechercheFactureRequete(var13, var8);
               if (var26.size() != 0) {
                  new BienFacture();

                  BienFacture var14;
                  for(int var15 = 0; var15 < var26.size(); ++var15) {
                     var14 = (BienFacture)var26.get(var15);
                     var14.setBiefacRegTmp(0.0D);
                     var6.modif(var14, var8);
                  }

                  var8.flush();
                  new Reglements();

                  for(int var16 = 0; var16 < var10.size(); ++var16) {
                     Reglements var27 = (Reglements)var10.get(var16);
                     long var17 = var27.getRglIdDocument();
                     var14 = var6.pourParapheur(var17, var8);
                     if (var14 != null) {
                        var14.setBiefacRegTmp(var14.getBiefacRegTmp() + var27.getRglRecette());
                        var6.modif(var14, var8);
                     }
                  }

                  var8.flush();
               }
            }

            var9.commit();
         }
      } catch (HibernateException var22) {
         if (var9 != null) {
            var9.rollback();
         }

         throw var22;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      if (var7 != null && !var7.isEmpty()) {
         this.var_requete = "biefac_id in (" + var7 + ")";
         if (this.serie == null || this.serie.isEmpty() || !this.serie.equals("100")) {
            this.var_entete = "Série : " + this.serie;
            this.var_requete = this.var_requete + " and biefac_serie='" + this.serie + "'";
         }

         if (this.nomProprietaire != null && !this.nomProprietaire.isEmpty()) {
            this.var_filtre = this.var_filtre + " Propriétaire = " + this.nomProprietaire;
            this.var_requete = this.var_requete + " and biefac_nom_proprietaire='" + this.nomProprietaire + "'";
         }

         if (this.createur != null && !this.createur.isEmpty() && !this.createur.equals("100")) {
            UserDao var24 = new UserDao(this.baseLog, this.utilInitHibernate);
            String var25 = var24.selectByIdUsers(Long.parseLong(this.createur), (Session)null).getUsrPatronyme();
            this.var_filtre = this.var_filtre + " Créateur = " + var25;
            this.var_requete = this.var_requete + " and biefac_id_createur=" + this.createur;
         }
      } else {
         this.var_requete = "";
      }

   }

   public void rechercheOtSql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = "Liste des O.T. du " + var1 + " au " + var2 + " Série : Toutes";
         this.var_requete = "bietraent_date_debut>='" + var3 + "' and bietraent_date_debut<='" + var4 + "'";
      } else {
         this.var_entete = "Liste des O.T. du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "bietraent_date_debut>='" + var3 + "' and bietraent_date_debut<='" + var4 + "' and bietraent_serie='" + this.serie + "'";
      }

      if (this.etat != null && !this.etat.isEmpty() && !this.etat.equals("101")) {
         int var5 = Integer.parseInt(this.etat);
         if (var5 == 0) {
            this.var_filtre = this.var_filtre + " Etat = En cours";
            this.var_requete = this.var_requete + " and bietraent_etat=" + var5;
         } else if (var5 == 1) {
            this.var_filtre = this.var_filtre + " Etat = Validé";
            this.var_requete = this.var_requete + " and bietraent_etat=" + var5;
         } else if (var5 == 2) {
            this.var_filtre = this.var_filtre + " Etat = Gelé";
            this.var_requete = this.var_requete + " and bietraent_etat=" + var5;
         } else if (var5 == 3) {
            this.var_filtre = this.var_filtre + " Etat = Annulé";
            this.var_requete = this.var_requete + " and bietraent_etat=" + var5;
         } else if (var5 == 11) {
            this.var_filtre = this.var_filtre + " Etat = Terminé";
            this.var_requete = this.var_requete + " and bietraent_etat=" + var5;
         }
      }

      if (this.codeBien != null && !this.codeBien.isEmpty()) {
         this.var_filtre = this.var_filtre + " Bien = " + this.codeBien;
         String[] var7 = this.codeBien.split(":");
         this.var_requete = this.var_requete + " and bietraent_code_bien='" + var7[0] + "'";
      }

      String var6;
      UserDao var8;
      if (this.responsable != null && !this.responsable.isEmpty() && !this.responsable.equals("100")) {
         var8 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var8.selectByIdUsers(Long.parseLong(this.responsable), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Responsable = " + var6;
         this.var_requete = this.var_requete + " and bietraent_id_responsable=" + this.responsable;
      }

      if (this.createur != null && !this.createur.isEmpty() && !this.createur.equals("100")) {
         var8 = new UserDao(this.baseLog, this.utilInitHibernate);
         var6 = var8.selectByIdUsers(Long.parseLong(this.createur), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Créateur = " + var6;
         this.var_requete = this.var_requete + " and bietraent_user_creat=" + this.createur;
      }

   }

   public void rechercheReglementLocationSql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      String var5 = "Encaissements";
      this.var_entete = var5 + " du " + var1 + " au " + var2;
      String var6 = this.utilDate.dateToStringSQLLight(this.filtreDateDebut);
      String var7 = this.utilDate.dateToStringSQLLight(this.filtreDateFin);
      this.var_requete = "rgl_date_reg between '" + var6 + "' and '" + var7 + "' and rgl_imp=0";
   }

   public void rechercheAppelChargeSql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      String var5 = "Liste des Appels de charges";
      if (this.nomRepertoire.contains("impayes")) {
         var5 = "Impayés";
      }

      if (this.serie != null && !this.serie.isEmpty() && this.serie.equals("100")) {
         this.var_entete = var5 + " du " + var1 + " au " + var2 + " Série : Toutes";
         this.var_requete = "appcha_date>='" + var3 + "' and appcha_date<='" + var4 + "'";
      } else {
         this.var_entete = var5 + " du " + var1 + " au " + var2 + " Série : " + this.serie;
         this.var_requete = "appcha_date>='" + var3 + "' and appcha_date<='" + var4 + "' and appcha_serie='" + this.serie + "'";
      }

      if (this.etat != null && !this.etat.isEmpty() && !this.etat.equals("101")) {
         int var6 = Integer.parseInt(this.etat);
         if (var6 == 0) {
            this.var_filtre = this.var_filtre + " Etat = En cours";
            this.var_requete = this.var_requete + " and appcha_etat=" + var6;
         } else if (var6 == 1) {
            this.var_filtre = this.var_filtre + " Etat = Validé";
            this.var_requete = this.var_requete + " and appcha_etat=" + var6;
         } else if (var6 == 2) {
            this.var_filtre = this.var_filtre + " Etat = Gelé";
            this.var_requete = this.var_requete + " and appcha_etat=" + var6;
         } else if (var6 == 3) {
            this.var_filtre = this.var_filtre + " Etat = Annulé";
            this.var_requete = this.var_requete + " and appcha_etat=" + var6;
         } else if (var6 == 11) {
            this.var_filtre = this.var_filtre + " Etat = Relancé";
            this.var_requete = this.var_requete + " and appcha_date_relance!=null";
         } else if (var6 == 12) {
            this.var_filtre = this.var_filtre + " Etat = Promotion";
            this.var_requete = this.var_requete + " and appcha_tot_ht=0";
         } else if (var6 == 13) {
            this.var_filtre = this.var_filtre + " Etat = Non payé";
            this.var_requete = this.var_requete + " and appcha_solde=0";
         } else if (var6 == 14) {
            this.var_filtre = this.var_filtre + " Etat = Payé";
            this.var_requete = this.var_requete + " and appcha_solde=1";
         } else if (var6 == 15) {
            this.var_filtre = this.var_filtre + " Etat = Exonéré";
            this.var_requete = this.var_requete + " and appcha_exo_tva=1";
         } else if (var6 == 16) {
            this.var_filtre = this.var_filtre + " Etat = Attente de visa";
            this.var_requete = this.var_requete + " and appcha_date_visa=null";
         } else if (var6 == 17) {
            this.var_filtre = this.var_filtre + " Trf = Transféré en compta";
            this.var_requete = this.var_requete + " and biefac_date_transfert!=null";
         } else if (var6 == 18) {
            this.var_filtre = this.var_filtre + " Trf = Non transféré en compta";
            this.var_requete = this.var_requete + " and appcha_date_transfert=null";
         }
      }

      if (this.codeBien != null && !this.codeBien.isEmpty()) {
         this.var_filtre = this.var_filtre + " Immeuble = " + this.codeBien;
         String[] var8 = this.codeBien.split(":");
         this.var_requete = this.var_requete + " and appcha_immeuble='" + var8[0] + "'";
      }

      if (this.nomProprietaire != null && !this.nomProprietaire.isEmpty()) {
         this.var_filtre = this.var_filtre + " Propriétaire = " + this.nomProprietaire;
         this.var_requete = this.var_requete + " and appcha_nom_tiers='" + this.nomProprietaire + "'";
      }

      if (this.createur != null && !this.createur.isEmpty() && !this.createur.equals("100")) {
         UserDao var9 = new UserDao(this.baseLog, this.utilInitHibernate);
         String var7 = var9.selectByIdUsers(Long.parseLong(this.createur), (Session)null).getUsrPatronyme();
         this.var_filtre = this.var_filtre + " Créateur = " + var7;
         this.var_requete = this.var_requete + " and appcha_id_createur=" + this.createur;
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

   public OptionVentes getOptionVentes() {
      return this.optionVentes;
   }

   public void setOptionVentes(OptionVentes var1) {
      this.optionVentes = var1;
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

   public boolean isShowModalPanelTiersLocataire() {
      return this.showModalPanelTiersLocataire;
   }

   public void setShowModalPanelTiersLocataire(boolean var1) {
      this.showModalPanelTiersLocataire = var1;
   }

   public boolean isShowModalPanelTiersProprietaire() {
      return this.showModalPanelTiersProprietaire;
   }

   public void setShowModalPanelTiersProprietaire(boolean var1) {
      this.showModalPanelTiersProprietaire = var1;
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

   public String getEtat() {
      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
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

   public String getNomEtat() {
      return this.nomEtat;
   }

   public void setNomEtat(String var1) {
      this.nomEtat = var1;
   }

   public String getSerie() {
      return this.serie;
   }

   public void setSerie(String var1) {
      this.serie = var1;
   }

   public String getNomRepertoire() {
      return this.nomRepertoire;
   }

   public void setNomRepertoire(String var1) {
      this.nomRepertoire = var1;
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

   public String getNomLocataire() {
      return this.nomLocataire;
   }

   public void setNomLocataire(String var1) {
      this.nomLocataire = var1;
   }

   public String getNomProprietaire() {
      return this.nomProprietaire;
   }

   public void setNomProprietaire(String var1) {
      this.nomProprietaire = var1;
   }

   public String getLibelleImmobilier() {
      return this.libelleImmobilier;
   }

   public void setLibelleImmobilier(String var1) {
      this.libelleImmobilier = var1;
   }

   public int getTypeImmobilier() {
      return this.typeImmobilier;
   }

   public void setTypeImmobilier(int var1) {
      this.typeImmobilier = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public int getEtatBien() {
      return this.etatBien;
   }

   public void setEtatBien(int var1) {
      this.etatBien = var1;
   }

   public String getCodeBien() {
      return this.codeBien;
   }

   public void setCodeBien(String var1) {
      this.codeBien = var1;
   }

   public boolean isShowModalPanelBiens() {
      return this.showModalPanelBiens;
   }

   public void setShowModalPanelBiens(boolean var1) {
      this.showModalPanelBiens = var1;
   }

   public DataModel getDataModelBiens() {
      return this.dataModelBiens;
   }

   public void setDataModelBiens(DataModel var1) {
      this.dataModelBiens = var1;
   }

   public List getMesBiensRecItems() {
      return this.mesBiensRecItems;
   }

   public void setMesBiensRecItems(List var1) {
      this.mesBiensRecItems = var1;
   }

   public String getVar_num_bordereau() {
      return this.var_num_bordereau;
   }

   public void setVar_num_bordereau(String var1) {
      this.var_num_bordereau = var1;
   }

   public List getLesModelesAutorises() {
      return this.lesModelesAutorises;
   }

   public void setLesModelesAutorises(List var1) {
      this.lesModelesAutorises = var1;
   }
}
