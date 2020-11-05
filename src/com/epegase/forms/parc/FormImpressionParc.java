package com.epegase.forms.parc;

import com.epegase.systeme.classe.BonSortieEntete;
import com.epegase.systeme.classe.ExercicesParc;
import com.epegase.systeme.classe.FactureEnteteVentes;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.ParcOrEntete;
import com.epegase.systeme.classe.ReceptionEnteteAchats;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.DocumentEntete;
import com.epegase.systeme.control.EtatDocument;
import com.epegase.systeme.dao.BonSortieEnteteDao;
import com.epegase.systeme.dao.FactureEnteteVentesDao;
import com.epegase.systeme.dao.ParcDao;
import com.epegase.systeme.dao.ParcOrEnteteDao;
import com.epegase.systeme.dao.ReceptionEnteteAchatsDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.OptionParcs;
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

public class FormImpressionParc implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private ExercicesParc exoSelectionne;
   private OptionParcs optionParcs;
   private UtilDate utilDate;
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
   private List lesDocuments;
   private String periode;
   private List mesPeriodesItems = new ArrayList();
   private Date filtreDateDebut;
   private Date filtreDateFin;
   private String natureParc;
   private String famille;
   private String sousFamille;
   private String codeParc;
   private int etatParc;
   private String commercial;
   private String responsable;
   private String createur;
   private String var_entete;
   private String var_filtre;
   private String var_requete;
   private String activite;
   private List mesSeriesItems = new ArrayList();
   private List mesEtatsItems = new ArrayList();
   private List mesNaturesItems;
   private List mesFamillesItems;
   private List mesSousFamillesItems;
   private boolean var_anal_activite;
   private UtilPrint utilPrint;
   private boolean affMail = false;
   private String format = "PDF";
   private boolean var_affiche_impression = false;
   private String impDestinataire;
   private String impDestinataireCC;
   private String impDestinataireCCI;
   private String impEmetteur;
   private boolean var_ctrl_imp = false;
   private boolean showModalPanelParc = false;
   private Parc parc;
   private transient DataModel dataModelParc;
   private List lesModelesAutorises;
   private boolean decoupageActivite = false;
   private List laColonne1Items;
   private List laColonne2Items;
   private List laColonne3Items;
   private String var_colonne1;
   private String var_colonne2;
   private String var_colonne3;

   public FormImpressionParc() {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.utilDate = new UtilDate();
      this.dataModelParc = new ListDataModel();
      this.mesNaturesItems = new ArrayList();
      this.mesFamillesItems = new ArrayList();
      this.mesSousFamillesItems = new ArrayList();
   }

   public void InstancesDaoUtilses() {
   }

   public void chargerLesRepImpParc(Session var1) {
      this.lesRepImpression.clear();
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "parcs";
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
   }

   public boolean calculeVisible(String var1, Session var2) {
      boolean var3 = false;
      int var4 = 0;
      if (var1 != null && !var1.isEmpty()) {
         Object var5;
         if (var1.contains("PARC")) {
            var5 = var2.createQuery("SELECT COUNT(*) FROM Parc").uniqueResult();
            var4 = Integer.parseInt(var5.toString());
         } else if (var1.contains("CONSOMMATION")) {
            var5 = var2.createQuery("SELECT COUNT(*) FROM ParcConsommation").uniqueResult();
            var4 = Integer.parseInt(var5.toString());
         } else if (var1.contains("LOCALISATION")) {
            var5 = var2.createQuery("SELECT COUNT(*) FROM LocalisationGps").uniqueResult();
            var4 = Integer.parseInt(var5.toString());
         } else if (var1.contains("OR")) {
            var5 = var2.createQuery("SELECT COUNT(*) FROM ParcOrEntete").uniqueResult();
            var4 = Integer.parseInt(var5.toString());
         } else if (var1.contains("MANIFEST")) {
            var5 = var2.createQuery("SELECT COUNT(*) FROM ManifestEntete").uniqueResult();
            var4 = Integer.parseInt(var5.toString());
         } else if (var1.contains("DECAISSEMENT")) {
            var5 = var2.createQuery("SELECT COUNT(*) FROM BonSortieCaiss").uniqueResult();
            var4 = Integer.parseInt(var5.toString());
         } else if (var1.contains("SYNTHESE")) {
            var4 = 1;
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
      if (this.structureLog.isStrActivite()) {
         this.var_anal_activite = true;
      }

   }

   public void recupererNomrep() throws HibernateException, NamingException {
      this.testafficheLigne = false;
      this.testafficheDocument = false;
      if (this.dataModelImpgen.isRowAvailable()) {
         this.nomRepertoire = (String)this.dataModelImpgen.getRowData();
         this.nomRepertoire = this.nomRepertoire.toLowerCase();
         this.nomEtat = "";
         if (this.nomRepertoire.contains("parc")) {
            this.nature = 400;
         } else if (this.nomRepertoire.contains("inventaire")) {
            this.nature = 401;
         } else if (this.nomRepertoire.contains("transport_personnel")) {
            this.nature = 40;
         } else if (this.nomRepertoire.contains("transport_materiel")) {
            this.nature = 41;
         } else if (this.nomRepertoire.contains("travaux_public")) {
            this.nature = 42;
         } else if (this.nomRepertoire.contains("location")) {
            this.nature = 43;
         } else if (this.nomRepertoire.contains("localisation")) {
            this.nature = 44;
         } else if (this.nomRepertoire.contains("consommation")) {
            this.nature = 45;
         } else if (this.nomRepertoire.contains("or")) {
            this.nature = 46;
         } else if (this.nomRepertoire.contains("manifest")) {
            this.nature = 47;
         } else if (this.nomRepertoire.contains("decaissement")) {
            this.nature = 62;
         } else if (this.nomRepertoire.contains("synthese")) {
            this.testafficheDocument = true;
            this.nature = 499;
         } else {
            this.nature = 0;
         }

         this.lesFichImpression.clear();
         String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "parcs" + File.separator + this.nomRepertoire;
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
         this.filtreDateDebut = this.exoSelectionne.getExeprcDateDebut();
         this.filtreDateFin = this.exoSelectionne.getExeprcDateFin();
         this.var_affiche_impression = true;
         this.calculeDates();
      }

   }

   public void rechercheParc() throws HibernateException, NamingException {
      Object var1 = new ArrayList();
      if (this.codeParc != null && !this.codeParc.isEmpty()) {
         ParcDao var2 = new ParcDao(this.baseLog, this.utilInitHibernate);
         var1 = var2.selectParc(this.codeParc, (Session)null);
         this.showModalPanelParc = true;
      }

      this.dataModelParc.setWrappedData(var1);
   }

   public void selectionligneParc() throws JDOMException, IOException {
      if (this.dataModelParc.isRowAvailable()) {
         this.parc = (Parc)this.dataModelParc.getRowData();
      }

   }

   public void calculeParc() throws JDOMException, IOException {
      if (this.parc == null) {
         this.selectionligneParc();
      }

      if (this.parc != null) {
         this.codeParc = this.parc.getPrcImmatriculation();
      } else {
         this.parc = null;
         this.codeParc = "";
      }

      this.showModalPanelParc = false;
   }

   public void annuleParc() {
      this.parc = null;
      this.codeParc = "";
      this.showModalPanelParc = false;
   }

   public void chargerPeriodes() throws ParseException {
      this.mesPeriodesItems.clear();
      this.mesPeriodesItems.add(new SelectItem(""));
      Date var1 = this.exoSelectionne.getExeprcDateDebut();
      GregorianCalendar var2 = new GregorianCalendar();
      var2.setTime(var1);
      Date var3 = this.exoSelectionne.getExeprcDateFin();
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
         this.calculeRequete();
         this.utilPrint.setRapport(this.nomEtat);
         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "parcs" + File.separator + this.nomRepertoire + File.separator);
         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "sous_rapport" + File.separator);
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

         if (this.nomRepertoire.contains("synthese")) {
            this.utilPrint.setRequete("");
            JRBeanCollectionDataSource var1 = new JRBeanCollectionDataSource(this.lesDocuments);
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
      if (this.nomRepertoire.equalsIgnoreCase("parc")) {
         this.rechercheParcSql(var7, var8, var3, var6);
      } else if (this.nomRepertoire.equalsIgnoreCase("inventaire")) {
         this.rechercheInventaireSql(var7, var8, var3, var6);
      } else if (this.nomRepertoire.equalsIgnoreCase("consommation")) {
         this.rechercheConsommationSql(var7, var8, var2, var5);
      } else if (this.nomRepertoire.equalsIgnoreCase("localisation")) {
         this.rechercheLocalisationSql(var7, var8, var2, var5);
      } else if (this.nomRepertoire.equalsIgnoreCase("manifeste")) {
         this.rechercheManifesteSql(var7, var8, var2, var5);
      } else if (this.nomRepertoire.equalsIgnoreCase("or")) {
         this.rechercheOrSql(var7, var8, var3, var6);
      } else if (this.nomRepertoire.equalsIgnoreCase("decaissement")) {
         this.rechercheDecaissementSql(var7, var8, var3, var6);
      } else if (this.nomRepertoire.equalsIgnoreCase("synthese")) {
         this.rechercheSyntheseSql(var7, var8, var3, var6);
      }

   }

   public void rechercheParcSql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
   }

   public void rechercheInventaireSql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
   }

   public void rechercheLocalisationSql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
   }

   public void rechercheConsommationSql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
   }

   public void rechercheManifesteSql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
   }

   public void rechercheOrSql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
   }

   public void rechercheDecaissementSql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      String var5 = "";
      this.var_entete = var5 + " du " + var1 + " au " + var2;
      this.var_requete = "sort_parc is not null and sort_parc <> ''";
      this.var_requete = this.var_requete + " and sort_date>='" + var3 + "' and sort_date<='" + var4 + "'";
      if (this.codeParc != null && !this.codeParc.isEmpty()) {
         this.var_filtre = this.var_filtre + " Parc = " + this.codeParc;
         String var6 = "";
         if (this.codeParc.contains(":")) {
            String[] var7 = this.codeParc.split(":");
            var6 = var7[0];
         } else {
            var6 = this.codeParc;
         }

         this.var_requete = this.var_requete + " and sort_parc like '" + var6 + "%'";
      }

      if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
         this.var_filtre = this.var_filtre + " Activité = " + this.activite;
         this.var_requete = this.var_requete + " and sort_activite='" + this.activite + "'";
      }

      if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib1() + " = " + this.var_colonne1;
         this.var_requete = this.var_requete + " and sort_activite like '%" + this.var_colonne1 + "%'";
      }

      if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib2() + " = " + this.var_colonne2;
         this.var_requete = this.var_requete + " and sort_activite like '%" + this.var_colonne2 + "%'";
      }

      if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
         this.var_filtre = this.var_filtre + this.structureLog.getStrLib3() + " = " + this.var_colonne3;
         this.var_requete = this.var_requete + " and sort_activite like '%" + this.var_colonne3 + "%'";
      }

   }

   public void rechercheSyntheseSql(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      this.var_entete = "Synthèse du " + var1 + " au " + var2;
      if (this.codeParc != null && !this.codeParc.isEmpty()) {
         this.var_filtre = "Parc: " + this.codeParc;
      } else {
         this.var_filtre = "Tous les parcs";
      }

      this.lesDocuments = new ArrayList();
      Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "Parc_synthese");
      if (this.codeParc != null && !this.codeParc.isEmpty()) {
         this.rechercherSyntheseSuite(this.codeParc, var5);
      } else {
         new ArrayList();
         ParcDao var7 = new ParcDao(this.baseLog, this.utilInitHibernate);
         List var6 = var7.selectLesParcs(var5);
         if (var6.size() != 0) {
            for(int var8 = 0; var8 < var6.size(); ++var8) {
               this.parc = (Parc)var6.get(var8);
               this.rechercherSyntheseSuite(this.parc.getPrcImmatriculation(), var5);
            }
         }
      }

      this.utilInitHibernate.closeSession();
   }

   public void rechercherSyntheseSuite(String var1, Session var2) throws HibernateException, NamingException {
      new DocumentEntete();
      String var4 = this.utilDate.dateToStringSQLLight(this.filtreDateDebut) + " 00:00:00";
      String var5 = this.utilDate.dateToStringSQLLight(this.filtreDateFin) + " 23:59:59";
      new ArrayList();
      ReceptionEnteteAchatsDao var7 = new ReceptionEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      List var6 = var7.rechercheReceptionByDate(var1, var4, var5, var2);
      DocumentEntete var3;
      if (var6.size() != 0) {
         new ReceptionEnteteAchats();

         for(int var9 = 0; var9 < var6.size(); ++var9) {
            ReceptionEnteteAchats var8 = (ReceptionEnteteAchats)var6.get(var9);
            var3 = new DocumentEntete();
            var3.setDocId(var8.getRecId());
            var3.setDocNature(13);
            var3.setDocAnal2(var8.getRecAnal2());
            var3.setDocDate(var8.getRecDate());
            var3.setDocNum(var8.getRecNum());
            var3.setDocNomTiers(var8.getRecNomTiers());
            var3.setDocNomContact(var8.getRecNomContact());
            var3.setDocTotHt(var8.getRecTotHtLocal());
            var3.setDocTotTtc(0.0D);
            this.lesDocuments.add(var3);
         }
      }

      new ArrayList();
      BonSortieEnteteDao var17 = new BonSortieEnteteDao(this.baseLog, this.utilInitHibernate);
      List var16 = var17.rechercheBonSortieByDate(var1, var4, var5, var2);
      if (var16.size() != 0) {
         new BonSortieEntete();

         for(int var11 = 0; var11 < var16.size(); ++var11) {
            BonSortieEntete var10 = (BonSortieEntete)var16.get(var11);
            var3 = new DocumentEntete();
            var3.setDocId(var10.getBouId());
            var3.setDocNature(32);
            var3.setDocAnal2(var10.getBouAnal2());
            var3.setDocDate(var10.getBouDate());
            var3.setDocNum(var10.getBouNum());
            var3.setDocNomTiers("Bon de sortie");
            var3.setDocNomContact(var10.getBouNomResponsable());
            var3.setDocTotHt(var10.getBouTotPump());
            var3.setDocTotTtc(0.0D);
            this.lesDocuments.add(var3);
         }
      }

      new ArrayList();
      FactureEnteteVentesDao var19 = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      List var18 = var19.rechercheFactureByDate(var1, var4, var5, var2);
      if (var18.size() != 0) {
         new FactureEnteteVentes();

         for(int var13 = 0; var13 < var18.size(); ++var13) {
            FactureEnteteVentes var12 = (FactureEnteteVentes)var18.get(var13);
            var3 = new DocumentEntete();
            var3.setDocId(var12.getFacId());
            var3.setDocNature(25);
            var3.setDocAnal2(var12.getFacAnal2());
            var3.setDocDate(var12.getFacDate());
            var3.setDocNum(var12.getFacNum());
            var3.setDocNomTiers(var12.getFacNomTiers());
            var3.setDocNomContact(var12.getFacNomContact());
            var3.setDocTotHt(0.0D);
            var3.setDocTotTtc(var12.getFacTotHt());
            this.lesDocuments.add(var3);
         }
      }

      new ArrayList();
      ParcOrEnteteDao var21 = new ParcOrEnteteDao(this.baseLog, this.utilInitHibernate);
      List var20 = var21.rechercheFactureByDate(var1, var4, var5, var2);
      if (var20.size() != 0) {
         new ParcOrEntete();

         for(int var15 = 0; var15 < var20.size(); ++var15) {
            ParcOrEntete var14 = (ParcOrEntete)var20.get(var15);
            var3 = new DocumentEntete();
            var3.setDocId(var14.getPrcoreId());
            var3.setDocNature(46);
            var3.setDocAnal2(var14.getPrcoreAnal2());
            var3.setDocDate(var14.getPrcoreDate());
            var3.setDocNum(var14.getPrcoreNum());
            var3.setDocNomTiers(var14.getPrcoreNomClient());
            var3.setDocNomContact(var14.getPrcoreNomReceptionnaire());
            var3.setDocTotHt(var14.getPrcoreCoutPiece() + var14.getPrcoreCoutMo());
            var3.setDocTotTtc(0.0D);
            this.lesDocuments.add(var3);
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

   public UtilPrint getUtilPrint() {
      return this.utilPrint;
   }

   public void setUtilPrint(UtilPrint var1) {
      this.utilPrint = var1;
   }

   public ExercicesParc getExoSelectionne() {
      return this.exoSelectionne;
   }

   public void setExoSelectionne(ExercicesParc var1) {
      this.exoSelectionne = var1;
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

   public OptionParcs getOptionParcs() {
      return this.optionParcs;
   }

   public void setOptionParcs(OptionParcs var1) {
      this.optionParcs = var1;
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

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public DataModel getDataModelParc() {
      return this.dataModelParc;
   }

   public void setDataModelParc(DataModel var1) {
      this.dataModelParc = var1;
   }

   public int getEtatParc() {
      return this.etatParc;
   }

   public void setEtatParc(int var1) {
      this.etatParc = var1;
   }

   public String getFamille() {
      return this.famille;
   }

   public void setFamille(String var1) {
      this.famille = var1;
   }

   public List getMesFamillesItems() {
      return this.mesFamillesItems;
   }

   public void setMesFamillesItems(List var1) {
      this.mesFamillesItems = var1;
   }

   public List getMesNaturesItems() {
      return this.mesNaturesItems;
   }

   public void setMesNaturesItems(List var1) {
      this.mesNaturesItems = var1;
   }

   public List getMesSousFamillesItems() {
      return this.mesSousFamillesItems;
   }

   public void setMesSousFamillesItems(List var1) {
      this.mesSousFamillesItems = var1;
   }

   public String getNatureParc() {
      return this.natureParc;
   }

   public void setNatureParc(String var1) {
      this.natureParc = var1;
   }

   public Parc getParc() {
      return this.parc;
   }

   public void setParc(Parc var1) {
      this.parc = var1;
   }

   public boolean isShowModalPanelParc() {
      return this.showModalPanelParc;
   }

   public void setShowModalPanelParc(boolean var1) {
      this.showModalPanelParc = var1;
   }

   public String getSousFamille() {
      return this.sousFamille;
   }

   public void setSousFamille(String var1) {
      this.sousFamille = var1;
   }

   public String getCodeParc() {
      return this.codeParc;
   }

   public void setCodeParc(String var1) {
      this.codeParc = var1;
   }

   public List getLesModelesAutorises() {
      return this.lesModelesAutorises;
   }

   public void setLesModelesAutorises(List var1) {
      this.lesModelesAutorises = var1;
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

   public boolean isVar_anal_activite() {
      return this.var_anal_activite;
   }

   public void setVar_anal_activite(boolean var1) {
      this.var_anal_activite = var1;
   }

   public String getActivite() {
      return this.activite;
   }

   public void setActivite(String var1) {
      this.activite = var1;
   }
}
