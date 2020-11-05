package com.epegase.forms.caisse;

import com.epegase.systeme.classe.CaissesCommerciales;
import com.epegase.systeme.classe.CaissesJour;
import com.epegase.systeme.classe.ExercicesCaisse;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.JournauxComptables;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.Reglements;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.dao.CaissesCommercialesDao;
import com.epegase.systeme.dao.CaissesJourDao;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.ParcDao;
import com.epegase.systeme.dao.ReglementsDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.OptionCaisses;
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

public class FormImpressionCaisse implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private ExercicesCaisse exoSelectionne;
   private OptionCaisses optionCaisses;
   private UtilDate utilDate;
   private CaissesCommercialesDao caissesCommercialesDao;
   private CaissesCommerciales caissesCommerciales = new CaissesCommerciales();
   private List listCaisses;
   private List mesCaissesAutorisees;
   private List lesRepImpression = new ArrayList();
   private transient DataModel dataModelImpgen = new ListDataModel();
   private List lesFichImpression = new ArrayList();
   private transient DataModel dataModelImpgenFichier = new ListDataModel();
   private boolean testafficheLigne = false;
   private int nature;
   private String nomRepertoire;
   private String nomEtat = "";
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
   private String parc;
   private String activite;
   private String dossier;
   private String serie;
   private String etat;
   private String categorie;
   private String createur;
   private String caisse;
   private String var_entete;
   private String var_filtre;
   private String var_requete;
   private UtilPrint utilPrint;
   private boolean affMail = false;
   private String format = "PDF";
   private boolean var_affiche_impression = false;
   private String impDestinataire;
   private String impDestinataireCC;
   private String impDestinataireCCI;
   private String impEmetteur;
   private boolean var_ctrl_imp = false;
   private double var_solde_anterieur;
   private boolean moduleParc = false;
   private boolean showModalPanelParc;
   private transient DataModel datamodelParc;
   private Parc parcObj;
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
   private List lesReglements;
   private List lesModelesAutorises;
   private boolean showModalPanelTiers;
   private transient DataModel datamodelTiers;
   private Tiers tiers;

   public FormImpressionCaisse() {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.utilDate = new UtilDate();
      this.lesReglements = new ArrayList();
      this.datamodelParc = new ListDataModel();
      this.mesCaissesAutorisees = new ArrayList();
      this.datamodelTiers = new ListDataModel();
   }

   public void InstancesDaoUtilses() {
      this.caissesCommercialesDao = new CaissesCommercialesDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerLesRepImpCaisses() {
      this.lesRepImpression.clear();
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "operation";
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      String[] var3 = var2.list();
      int var4;
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(var4 = 0; var4 < var3.length; ++var4) {
            if (!var3[var4].equalsIgnoreCase(".svn") && !var3[var4].equalsIgnoreCase("index.html")) {
               String var5 = "";
               var5 = var3[var4].toUpperCase();
               this.lesRepImpression.add(var5);
            }
         }
      }

      this.dataModelImpgen.setWrappedData(this.lesRepImpression);
      this.mesCaissesAutorisees.clear();
      if (this.listCaisses.size() != 0) {
         for(var4 = 0; var4 < this.listCaisses.size(); ++var4) {
            if (((UsersChrono)this.listCaisses.get(var4)).getUsrchrCodeCaisse() != null && !((UsersChrono)this.listCaisses.get(var4)).getUsrchrCodeCaisse().isEmpty() && ((UsersChrono)this.listCaisses.get(var4)).getUsrchrNature() == 60 && ((UsersChrono)this.listCaisses.get(var4)).getUsrchrJournal() == 1) {
               this.mesCaissesAutorisees.add(new SelectItem(((UsersChrono)this.listCaisses.get(var4)).getUsrchrCodeCaisse() + ":" + ((UsersChrono)this.listCaisses.get(var4)).getUsrchrLib()));
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
      if (this.optionCaisses.getAxeActivite().equals("true")) {
         this.var_anal_activite = true;
      }

      if (this.optionCaisses.getAxeSite().equals("true")) {
         this.var_anal_site = true;
         this.var_anal_departement = true;
         this.var_anal_service = true;
      }

      if (this.optionCaisses.getAxeRegion().equals("true")) {
         this.var_anal_region = true;
         this.var_anal_secteur = true;
         this.var_anal_pdv = true;
      }

      this.var_anal_dossier = this.structureLog.getStrDossier();
      if (this.optionCaisses.getAxeParc().equals("true")) {
         this.var_anal_parc = true;
      }

      if (this.optionCaisses.getAxeAgent().equals("true")) {
         this.var_anal_agent = true;
      }

   }

   public void recupererNomrep() {
      this.testafficheLigne = false;
      if (this.dataModelImpgen.isRowAvailable()) {
         this.nomRepertoire = (String)this.dataModelImpgen.getRowData();
         this.nomRepertoire = this.nomRepertoire.toLowerCase();
         this.nomEtat = "";
         this.nature = 0;
         this.lesFichImpression.clear();
         String var1 = null;
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "operation" + File.separator + this.nomRepertoire;
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
                     this.lesFichImpression.add(var6);
                  }
               }
            }
         }

         this.dataModelImpgenFichier.setWrappedData(this.lesFichImpression);
         this.var_affiche_impression = true;
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
         this.filtreDateDebut = new Date();
         this.filtreDateFin = new Date();
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
         String var2 = "";
         boolean var3 = false;
         if (this.nomEtat.contains("_Clients")) {
            var2 = "(2,3)";
            var3 = true;
         } else if (this.nomEtat.contains("_Fournisseurs")) {
            var2 = "(0)";
            var3 = true;
         }

         if (var3) {
            TiersDao var4 = new TiersDao(this.baseLog, this.utilInitHibernate);
            var1 = var4.verifTiers(this.usersLog, var2, this.nomTiers, (Session)null);
            this.showModalPanelTiers = true;
         }
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
      Date var1 = this.exoSelectionne.getExecaiDateDebut();
      GregorianCalendar var2 = new GregorianCalendar();
      var2.setTime(var1);
      Date var3 = this.exoSelectionne.getExecaiDateFin();
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
         this.calculeRequete();
         if (this.var_requete != null && !this.var_requete.isEmpty()) {
            if (this.nomEtat.startsWith("RecapitulatifRemiseCheque")) {
               this.utilPrint.setRequete("");
               JRBeanCollectionDataSource var1 = new JRBeanCollectionDataSource(this.lesReglements);
               this.utilPrint.setjRBeanCollectionDataSource(var1);
            } else {
               this.utilPrint.setRequete(this.var_requete);
               ArrayList var3 = new ArrayList();
               JRBeanCollectionDataSource var2 = new JRBeanCollectionDataSource(var3);
               this.utilPrint.setjRBeanCollectionDataSource(var2);
            }

            this.utilPrint.setRapport(this.nomEtat);
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "operation" + File.separator + this.nomRepertoire + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "sous_rapport" + File.separator);
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
            this.utilPrint.setDateDebUk(this.utilDate.dateToStringSQLLight(this.filtreDateDebut) + " 00:00:00");
            this.utilPrint.setDateFinUk(this.utilDate.dateToStringSQLLight(this.filtreDateFin) + " 23:59:59");
            this.utilPrint.setJournal(this.caisse);
            if (this.caisse != null && !this.caisse.isEmpty() && this.caisse.contains(":")) {
               String[] var4 = this.caisse.split(":");
               this.utilPrint.setJournal(var4[0]);
            } else {
               this.utilPrint.setJournal("");
            }

            this.utilPrint.setCompte("");
            this.utilPrint.setValeur1(this.var_solde_anterieur);
            this.utilPrint.setNbCar(0);
            this.utilPrint.setFormat(this.format);
            this.utilPrint.setEmetteur(this.impEmetteur);
            this.utilPrint.setDestinataire(this.impDestinataire);
            this.utilPrint.setDestinataireCC(this.impDestinataireCC);
            this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
            this.utilPrint.setTiersSelectionne((Tiers)null);
            this.utilPrint.setBaseLog(this.baseLog);
            this.utilPrint.setStructureLog(this.structureLog);
            this.utilPrint.setUsersLog(this.usersLog);
            this.utilPrint.imprimeRapport();
         }

         this.var_ctrl_imp = false;
      }

   }

   public void calculeRequete() throws HibernateException, NamingException {
      this.var_entete = "";
      this.var_filtre = "";
      this.var_requete = "";
      this.var_solde_anterieur = 0.0D;
      String var1 = this.utilDate.dateToStringFr(this.filtreDateDebut);
      String var2 = this.utilDate.dateToStringFr(this.filtreDateFin);
      String var3 = this.utilDate.dateToStringSQLLight(this.filtreDateDebut);
      String var4 = this.utilDate.dateToStringSQLLight(this.filtreDateFin);
      Session var5;
      String[] var6;
      int var18;
      if (this.nomRepertoire.equalsIgnoreCase("journaux")) {
         if (this.caisse != null && this.caisse.contains(":")) {
            var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "Reglements");
            var6 = this.caisse.split(":");
            this.caissesCommerciales = this.caissesCommercialesDao.selectCaisseByCode(var6[0], this.exoSelectionne, var5);
            if (this.caissesCommerciales != null) {
               new ArrayList();
               double var8 = 0.0D;
               Date var10 = null;
               ReglementsDao var11 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
               new CaissesJour();
               CaissesJourDao var13 = new CaissesJourDao(this.baseLog, this.utilInitHibernate);
               CaissesJour var12 = var13.rechercheDernierJourCloture(var6[0], var3, this.exoSelectionne, var5);
               if (var12 != null) {
                  if (!this.nomEtat.equals("EtatCaisseEspeceCheque") && !this.nomEtat.equals("CaisseModePaiementLight")) {
                     var8 = var12.getCaijouSoldeCheque() + var12.getCaijouSoldeCompense() + var12.getCaijouSoldeCredoc() + var12.getCaijouSoldeEspece() + var12.getCaijouSoldeFactor() + var12.getCaijouSoldeTerme() + var12.getCaijouSoldeTpe() + var12.getCaijouSoldeTraite() + var12.getCaijouSoldeTransfert() + var12.getCaijouSoldeVirement() + var12.getCaijouSoldeePaiement();
                  } else {
                     var8 = var12.getCaijouEspeceTheorique();
                  }

                  var10 = var12.getCaijouDate();
               } else {
                  var8 = this.caissesCommerciales.getCaiMontantInit();
                  if (this.caissesCommerciales.getCaiDateInit() != null) {
                     var10 = this.caissesCommerciales.getCaiDateInit();
                  } else {
                     var10 = this.exoSelectionne.getExecaiDateDebut();
                  }
               }

               List var7;
               if (!this.nomEtat.equals("EtatCaisseEspeceCheque") && !this.nomEtat.equals("CaisseModePaiementLight")) {
                  var7 = var11.calculToutSoldeAnterieur(var6[0], var10, this.filtreDateDebut, var5);
               } else {
                  var7 = var11.calculSoldeAnterieurEspeceCheque(var6[0], var10, this.filtreDateDebut, var5);
               }

               double var14 = 0.0D;
               double var16 = 0.0D;
               if (var7.size() != 0) {
                  for(var18 = 0; var18 < var7.size(); ++var18) {
                     Reglements var19 = (Reglements)var7.get(var18);
                     if (var19.getRglOperation() != null && !var19.getRglOperation().isEmpty()) {
                        if (!var19.getRglOperation().equals("17") && !var19.getRglOperation().equals("25") && !var19.getRglOperation().equals("27")) {
                           var14 += var19.getRglDepense();
                           var16 += var19.getRglRecette();
                        }
                     } else {
                        var14 += var19.getRglDepense();
                        var16 += var19.getRglRecette();
                     }
                  }
               }

               this.var_solde_anterieur = var8 - var14 + var16;
            }

            this.utilInitHibernate.closeSession();
            this.var_entete = "Trésorerie du " + var1 + " au " + var2;
            this.var_filtre = this.caisse;
            if (!this.nomEtat.equals("EtatCaisseEspeceCheque") && !this.nomEtat.equals("CaisseModePaiementLight")) {
               this.var_requete = "rgl_date_reg between '" + var3 + "' and '" + var4 + "' and rgl_code_caisse='" + var6[0] + "' and rgl_imp=0";
            } else {
               this.var_requete = "rgl_date_reg between '" + var3 + "' and '" + var4 + "' and rgl_code_caisse='" + var6[0] + "' and rgl_imp=0 and (rgl_type_reg=0 or rgl_type_reg=1 or rgl_type_reg=11) and rgl_operation<>'17' and rgl_operation<>'25' and rgl_operation<>'27'";
            }

            if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
               this.var_filtre = this.var_filtre + " Activité = " + this.activite;
               this.var_requete = this.var_requete + " and rgl_activite='" + this.activite + "'";
            }

            if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
               this.var_filtre = this.var_filtre + this.structureLog.getStrLib1() + " = " + this.var_colonne1;
               this.var_requete = this.var_requete + " and rgl_activite like '%" + this.var_colonne1 + "%'";
            }

            if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
               this.var_filtre = this.var_filtre + this.structureLog.getStrLib2() + " = " + this.var_colonne2;
               this.var_requete = this.var_requete + " and rgl_activite like '%" + this.var_colonne2 + "%'";
            }

            if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
               this.var_filtre = this.var_filtre + this.structureLog.getStrLib3() + " = " + this.var_colonne3;
               this.var_requete = this.var_requete + " and rgl_activite like '%" + this.var_colonne3 + "%'";
            }

            if (this.parc != null && !this.parc.isEmpty()) {
               this.var_filtre = this.var_filtre + " Parc = " + this.parc;
               String var24 = "";
               if (this.parc.contains(":")) {
                  String[] var27 = this.parc.split(":");
                  var24 = var27[0];
               } else {
                  var24 = this.parc;
               }

               this.var_requete = this.var_requete + " and rgl_parc like '%" + var24 + "%'";
            }
         }
      } else {
         String var20;
         String[] var21;
         if (this.nomRepertoire.equalsIgnoreCase("mouvements")) {
            if (this.caisse != null && this.caisse.contains(":")) {
               var21 = this.caisse.split(":");
               this.var_entete = "Trésorerie du " + var1 + " au " + var2;
               this.var_filtre = this.caisse;
               this.var_requete = this.var_requete + "rgl_date_reg between '" + var3 + "' and '" + var4 + "' and rgl_imp=0 and rgl_code_caisse='" + var21[0] + "'";
            } else {
               this.var_entete = this.nomEtat + " " + var1 + " au " + var2;
               this.var_filtre = "Toutes les caisses autorisées";
               var20 = "";
               int var22 = 0;

               while(true) {
                  if (var22 >= this.mesCaissesAutorisees.size()) {
                     if (var20 != null && !var20.isEmpty()) {
                        this.var_requete = this.var_requete + "rgl_date_reg between '" + var3 + "' and '" + var4 + "' and rgl_imp=0 and rgl_code_caisse in (" + var20 + ")";
                        break;
                     }

                     this.var_requete = this.var_requete + "rgl_date_reg between '" + var3 + "' and '" + var4 + "' and rgl_imp=0 ";
                     break;
                  }

                  if (((SelectItem)this.mesCaissesAutorisees.get(var22)).getValue().toString() != null && !((SelectItem)this.mesCaissesAutorisees.get(var22)).getValue().toString().isEmpty()) {
                     String[] var25 = ((SelectItem)this.mesCaissesAutorisees.get(var22)).getValue().toString().split(":");
                     if (var20 != null && !var20.isEmpty()) {
                        var20 = var20 + ",'" + var25[0] + "'";
                     } else {
                        var20 = "'" + var25[0] + "'";
                     }
                  }

                  ++var22;
               }
            }

            if (this.nomEtat.contains("Ristourne")) {
               this.var_requete = this.var_requete + " or (rgl_code_caisse is null or rgl_code_caisse = '') ";
            }

            if (this.nomTiers != null && !this.nomTiers.isEmpty()) {
               this.var_filtre = this.var_filtre + " Tiers = " + this.nomTiers;
               this.var_requete = this.var_requete + " and rgl_nom_tiers = '" + this.nomTiers + "'";
            }

            if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
               this.var_filtre = this.var_filtre + " Activité = " + this.activite;
               this.var_requete = this.var_requete + " and rgl_activite='" + this.activite + "'";
            }

            if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
               this.var_filtre = this.var_filtre + this.structureLog.getStrLib1() + " = " + this.var_colonne1;
               this.var_requete = this.var_requete + " and rgl_activite like '%" + this.var_colonne1 + "%'";
            }

            if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
               this.var_filtre = this.var_filtre + this.structureLog.getStrLib2() + " = " + this.var_colonne2;
               this.var_requete = this.var_requete + " and rgl_activite like '%" + this.var_colonne2 + "%'";
            }

            if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
               this.var_filtre = this.var_filtre + this.structureLog.getStrLib3() + " = " + this.var_colonne3;
               this.var_requete = this.var_requete + " and rgl_activite like '%" + this.var_colonne3 + "%'";
            }

            if (this.parc != null && !this.parc.isEmpty()) {
               this.var_filtre = this.var_filtre + " Parc = " + this.parc;
               var20 = "";
               if (this.parc.contains(":")) {
                  var6 = this.parc.split(":");
                  var20 = var6[0];
               } else {
                  var20 = this.parc;
               }

               this.var_requete = this.var_requete + " and rgl_parc like '%" + var20 + "%'";
            }
         } else if (this.nomRepertoire.equalsIgnoreCase("rapport")) {
            if (this.caisse != null && this.caisse.contains(":")) {
               var21 = this.caisse.split(":");
               this.var_entete = "Trésorerie du " + var1 + " au " + var2;
               this.var_filtre = this.caisse;
               this.var_requete = "rgl_date_reg between '" + var3 + "' and '" + var4 + "' and rgl_code_caisse='" + var21[0] + "'";
            } else {
               this.var_entete = this.nomEtat + " " + var1 + " au " + var2;
               this.var_filtre = "Toutes les caisses";
               this.var_requete = "rgl_date_reg between '" + var3 + "' and '" + var4 + "'";
            }

            if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
               this.var_filtre = this.var_filtre + " Activité = " + this.activite;
               this.var_requete = this.var_requete + " and rgl_activite='" + this.activite + "'";
            }

            if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
               this.var_filtre = this.var_filtre + this.structureLog.getStrLib1() + " = " + this.var_colonne1;
               this.var_requete = this.var_requete + " and rgl_activite like '%" + this.var_colonne1 + "%'";
            }

            if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
               this.var_filtre = this.var_filtre + this.structureLog.getStrLib2() + " = " + this.var_colonne2;
               this.var_requete = this.var_requete + " and rgl_activite like '%" + this.var_colonne2 + "%'";
            }

            if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
               this.var_filtre = this.var_filtre + this.structureLog.getStrLib3() + " = " + this.var_colonne3;
               this.var_requete = this.var_requete + " and rgl_activite like '%" + this.var_colonne3 + "%'";
            }

            if (this.parc != null && !this.parc.isEmpty()) {
               this.var_filtre = this.var_filtre + " Parc = " + this.parc;
               var20 = "";
               if (this.parc.contains(":")) {
                  var6 = this.parc.split(":");
                  var20 = var6[0];
               } else {
                  var20 = this.parc;
               }

               this.var_requete = this.var_requete + " and rgl_parc like '%" + var20 + "%'";
            }

            if (this.nomEtat.startsWith("RecapitulatifRemiseCheque")) {
               var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "Reglements");
               new JournauxComptables();
               JournauxComptablesDao var26 = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
               new ExercicesComptable();
               ExercicesComptableDao var9 = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
               ExercicesComptable var28 = var9.recupererLastExo(var5);
               if (var28 == null) {
                  var28 = new ExercicesComptable();
               }

               this.lesReglements.clear();
               Object var30 = new ArrayList();
               this.var_requete = this.var_requete + " and rgl_imp=1";
               new ArrayList();
               ReglementsDao var31 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
               List var29 = var31.rechercheReglementsRequete(this.var_requete, var5);
               if (var29.size() != 0) {
                  new Reglements();

                  for(int var33 = 0; var33 < var29.size(); ++var33) {
                     Reglements var32 = (Reglements)var29.get(var33);
                     String var15 = var32.getRglNum();
                     JournauxComptables var23 = var26.chercherCode(var32.getRglCodeReceptrice(), var28.getExecpt_id(), var5);
                     ((List)var30).clear();
                     var30 = var31.chargeChequeBanqueImpression("", var15, var5);
                     if (((List)var30).size() != 0) {
                        new Reglements();

                        for(int var17 = 0; var17 < ((List)var30).size(); ++var17) {
                           Reglements var34 = (Reglements)((List)var30).get(var17);
                           if (var34.getRglDateEncaissement() != null) {
                              var34.setRglDocument(var32.getRglDocument());
                              var34.setRglNumChqBdx(var32.getRglNumChqBdx());
                              var34.setRglCodeReceptrice(var32.getRglCodeReceptrice());
                              var34.setRglRecette(var32.getRglRecette());
                              var34.setRglDateEncaissement(var32.getRglDateEncaissement());
                              var34.setBanqueDepot(var32.getRglLibReceptrice());
                              var34.setDateDepot(var32.getRglDateReg());
                              var34.setNumDepot(var32.getRglNum());
                              var18 = 0;
                              if (var23 != null) {
                                 if (var34.getBanqueDepot().equals(var34.getRglLibReceptrice())) {
                                    var18 = var23.getPljDvMbsp();
                                 } else if (var34.getBanqueDepot().equals(var34.getRglLibReceptrice())) {
                                    var18 = var23.getPljDvMbhp();
                                 } else if (!var34.getBanqueDepot().equals(var34.getRglLibReceptrice())) {
                                    var18 = var23.getPljDvAbsp();
                                 } else if (!var34.getBanqueDepot().equals(var34.getRglLibReceptrice())) {
                                    var18 = var23.getPljDvAbhp();
                                 }
                              }

                              if (var18 != 0) {
                                 var34.setDateValeur(this.utilDate.datedevaleurTheo(var34.getDateDepot(), var18));
                              } else {
                                 var34.setDateValeur((Date)null);
                              }

                              this.lesReglements.add(var34);
                           }
                        }
                     }
                  }
               }

               this.utilInitHibernate.closeSession();
            } else if (this.nomEtat.startsWith("SituationEncaissements")) {
               if (this.parc != null && !this.parc.isEmpty()) {
                  this.var_filtre = this.var_filtre + " Parc = " + this.parc;
                  var20 = "";
                  if (this.parc.contains(":")) {
                     var6 = this.parc.split(":");
                     var20 = var6[0];
                  } else {
                     var20 = this.parc;
                  }

                  this.var_requete = this.var_requete + " and rgl_parc like '%" + var20 + "%'";
               }
            } else {
               this.var_requete = this.var_requete + " and rgl_imp=0";
               if (this.parc != null && !this.parc.isEmpty()) {
                  this.var_filtre = this.var_filtre + " Parc = " + this.parc;
                  var20 = "";
                  if (this.parc.contains(":")) {
                     var6 = this.parc.split(":");
                     var20 = var6[0];
                  } else {
                     var20 = this.parc;
                  }

                  this.var_requete = this.var_requete + " and rgl_parc like '%" + var20 + "%'";
               }
            }
         }
      }

   }

   public ExercicesCaisse getExoSelectionne() {
      return this.exoSelectionne;
   }

   public void setExoSelectionne(ExercicesCaisse var1) {
      this.exoSelectionne = var1;
   }

   public OptionCaisses getOptionCaisses() {
      return this.optionCaisses;
   }

   public void setOptionCaisses(OptionCaisses var1) {
      this.optionCaisses = var1;
   }

   public String getCaisse() {
      return this.caisse;
   }

   public void setCaisse(String var1) {
      this.caisse = var1;
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

   public String getCreateur() {
      return this.createur;
   }

   public void setCreateur(String var1) {
      this.createur = var1;
   }

   public DataModel getDataModelImpgen() {
      return this.dataModelImpgen;
   }

   public void setDataModelImpgen(DataModel var1) {
      this.dataModelImpgen = var1;
   }

   public DataModel getDataModelImpgenFichier() {
      return this.dataModelImpgenFichier;
   }

   public void setDataModelImpgenFichier(DataModel var1) {
      this.dataModelImpgenFichier = var1;
   }

   public String getDepartement() {
      return this.departement;
   }

   public void setDepartement(String var1) {
      this.departement = var1;
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

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
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

   public boolean isTestafficheLigne() {
      return this.testafficheLigne;
   }

   public void setTestafficheLigne(boolean var1) {
      this.testafficheLigne = var1;
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

   public String getImpEmetteur() {
      return this.impEmetteur;
   }

   public void setImpEmetteur(String var1) {
      this.impEmetteur = var1;
   }

   public UtilPrint getUtilPrint() {
      return this.utilPrint;
   }

   public void setUtilPrint(UtilPrint var1) {
      this.utilPrint = var1;
   }

   public boolean isVar_ctrl_imp() {
      return this.var_ctrl_imp;
   }

   public void setVar_ctrl_imp(boolean var1) {
      this.var_ctrl_imp = var1;
   }

   public double getVar_solde_anterieur() {
      return this.var_solde_anterieur;
   }

   public void setVar_solde_anterieur(double var1) {
      this.var_solde_anterieur = var1;
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

   public boolean isDecoupageActivite() {
      return this.decoupageActivite;
   }

   public void setDecoupageActivite(boolean var1) {
      this.decoupageActivite = var1;
   }

   public boolean isVar_affiche_impression() {
      return this.var_affiche_impression;
   }

   public void setVar_affiche_impression(boolean var1) {
      this.var_affiche_impression = var1;
   }

   public boolean isVar_anal_activite() {
      return this.var_anal_activite;
   }

   public void setVar_anal_activite(boolean var1) {
      this.var_anal_activite = var1;
   }

   public boolean isVar_anal_agent() {
      return this.var_anal_agent;
   }

   public void setVar_anal_agent(boolean var1) {
      this.var_anal_agent = var1;
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

   public List getLesModelesAutorises() {
      return this.lesModelesAutorises;
   }

   public void setLesModelesAutorises(List var1) {
      this.lesModelesAutorises = var1;
   }

   public List getListCaisses() {
      return this.listCaisses;
   }

   public void setListCaisses(List var1) {
      this.listCaisses = var1;
   }

   public List getMesCaissesAutorisees() {
      return this.mesCaissesAutorisees;
   }

   public void setMesCaissesAutorisees(List var1) {
      this.mesCaissesAutorisees = var1;
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
}
