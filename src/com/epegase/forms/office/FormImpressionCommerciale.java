package com.epegase.forms.office;

import com.epegase.forms.achats.FormImpressionAchats;
import com.epegase.forms.caisse.FormImpressionCaisse;
import com.epegase.forms.stock.FormImpressionStock;
import com.epegase.forms.ventes.FormImpressionVentes;
import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.ExercicesCaisse;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.Rdv;
import com.epegase.systeme.classe.Responsable;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.DocumentStatistique;
import com.epegase.systeme.control.InfosSysteme;
import com.epegase.systeme.dao.CaissesCommercialesDao;
import com.epegase.systeme.dao.DepotAchatsDao;
import com.epegase.systeme.dao.ExercicesAchatsDao;
import com.epegase.systeme.dao.ExercicesCaisseDao;
import com.epegase.systeme.dao.ExercicesVentesDao;
import com.epegase.systeme.dao.FamillesProduitsAchatsDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.ProduitsAchsDao;
import com.epegase.systeme.dao.ProduitsVtesDao;
import com.epegase.systeme.dao.RdvDao;
import com.epegase.systeme.dao.ResponsableDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.LectureElementRdv;
import com.epegase.systeme.xml.LireLesoptionsAchats;
import com.epegase.systeme.xml.LireLesoptionsCaisses;
import com.epegase.systeme.xml.LireLesoptionsStocks;
import com.epegase.systeme.xml.LireLesoptionsVentes;
import com.epegase.systeme.xml.OptionAchats;
import com.epegase.systeme.xml.OptionCaisses;
import com.epegase.systeme.xml.OptionStocks;
import com.epegase.systeme.xml.OptionTiers;
import com.epegase.systeme.xml.OptionVentes;
import java.io.File;
import java.io.IOException;
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

public class FormImpressionCommerciale {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private OptionTiers optionTiers;
   private UtilDate utilDate = new UtilDate();
   private UtilPrint utilPrint;
   private boolean affMail = false;
   private String format = "PDF";
   private boolean var_affiche_impression = false;
   private String impDestinataire;
   private String impDestinataireCC;
   private String impDestinataireCCI;
   private String impEmetteur;
   private boolean var_ctrl_imp = false;
   private List lesFichImpression = new ArrayList();
   private InfosSysteme infosSysteme;
   private transient DataModel dataModelImpgenFichier = new ListDataModel();
   private String periode;
   private List mesPeriodesItems = new ArrayList();
   private boolean afficheProduitAch = false;
   private boolean afficheProduitStk = false;
   private boolean afficheProduitVte = false;
   private boolean afficheClient = false;
   private boolean afficheFourniseur = false;
   private boolean afficheStatistique = false;
   private boolean afficheCaisse = false;
   private Date filtreDateDebut;
   private Date filtreDateFin;
   private String nomTiers;
   private String produitDebut;
   private String produitFin;
   private String famille;
   private String depot;
   private String var_entete;
   private String var_filtre;
   private String caisse;
   private String var_requete;
   private List mesFamillesVentesItems = new ArrayList();
   private List mesFamillesAchatsItems = new ArrayList();
   private List mesDepotItems = new ArrayList();
   private List mesCaisseItems = new ArrayList();
   private FamillesProduitsAchatsDao famillesProduitsAchatsDao;
   private FamillesProduitsVentesDao famillesProduitsVentesDao;
   private CaissesCommercialesDao caissesCommercialesDao;
   private DepotAchatsDao depotAchatsDao;
   private List listDocument;
   private FormImpressionAchats formImpressionAchats;
   private FormImpressionStock formImpressionStock;
   private FormImpressionVentes formImpressionVentes;
   private FormImpressionCaisse formImpressionCaisse;
   private boolean showModalPanelTiers = false;
   private transient DataModel datamodelTiers = new ListDataModel();
   private Tiers tiers = new Tiers();
   private boolean showModalPanelProduits = false;
   private transient DataModel datamodelProduits = new ListDataModel();
   private Produits produits;
   private boolean var_produit_choix = false;
   private List lesModelesAutorises;
   private String action;
   private String observation;
   private String compteRendu;
   private String centreInteret;
   private String conclusion;
   private long conseiller;
   private List mesCentresInteretsItems = new ArrayList();
   private List mesConseillersItems = new ArrayList();
   private List mesConclusionsItems = new ArrayList();
   private List mesActionsItems = new ArrayList();

   public void InstancesDaoUtilses() {
      this.famillesProduitsAchatsDao = new FamillesProduitsAchatsDao(this.baseLog, this.utilInitHibernate);
      this.famillesProduitsVentesDao = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
      this.depotAchatsDao = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
      this.caissesCommercialesDao = new CaissesCommercialesDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerPeriodes() throws ParseException {
      this.mesPeriodesItems.clear();
      this.mesPeriodesItems.add(new SelectItem(""));
      Date var1 = this.utilDate.stringToDateSQLLight((new Date()).getYear() + 1900 + "-" + "01-01");
      GregorianCalendar var2 = new GregorianCalendar();
      var2.setTime(var1);
      Date var3 = this.utilDate.stringToDateSQLLight((new Date()).getYear() + 1900 + "-" + "12-31");
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
            } else if (this.periode.equals("Annuel")) {
               this.filtreDateDebut = this.utilDate.stringToDateSQLLight(var4 + "-" + "01" + "-" + "01");
               this.filtreDateFin = this.utilDate.stringToDateSQLLight(var4 + "-" + "12" + "-" + "31");
            } else if (this.periode.equals("1er semestre")) {
               this.filtreDateDebut = this.utilDate.stringToDateSQLLight(var4 + "-" + "01" + "-" + "01");
               this.filtreDateFin = this.utilDate.stringToDateSQLLight(var4 + "-" + "06" + "-" + "30");
            } else if (this.periode.equals("2eme semestre")) {
               this.filtreDateDebut = this.utilDate.stringToDateSQLLight(var4 + "-" + "07" + "-" + "01");
               this.filtreDateFin = this.utilDate.stringToDateSQLLight(var4 + "-" + "12" + "-" + "31");
            }
         }
      }

   }

   public void initImpression() throws NamingException, ParseException, JDOMException, IOException {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.filtreDateDebut = this.utilDate.datePremierJourMois(new Date());
      this.filtreDateFin = this.utilDate.dateDernierJourMois(new Date());
      if (this.optionTiers != null) {
         if (this.optionTiers.getModeleAch1() != null && !this.optionTiers.getModeleAch1().isEmpty()) {
            this.calculLigneAchat(this.optionTiers.getModeleAch1(), this.optionTiers.getLibAch1());
         }

         if (this.optionTiers.getModeleAch2() != null && !this.optionTiers.getModeleAch2().isEmpty()) {
            this.calculLigneAchat(this.optionTiers.getModeleAch2(), this.optionTiers.getLibAch2());
         }

         if (this.optionTiers.getModeleAch3() != null && !this.optionTiers.getModeleAch3().isEmpty()) {
            this.calculLigneAchat(this.optionTiers.getModeleAch3(), this.optionTiers.getLibAch3());
         }

         if (this.optionTiers.getModeleAch4() != null && !this.optionTiers.getModeleAch4().isEmpty()) {
            this.calculLigneAchat(this.optionTiers.getModeleAch4(), this.optionTiers.getLibAch4());
         }

         if (this.optionTiers.getModeleAch5() != null && !this.optionTiers.getModeleAch5().isEmpty()) {
            this.calculLigneAchat(this.optionTiers.getModeleAch5(), this.optionTiers.getLibAch5());
         }

         if (this.optionTiers.getModeleAch6() != null && !this.optionTiers.getModeleAch6().isEmpty()) {
            this.calculLigneAchat(this.optionTiers.getModeleAch6(), this.optionTiers.getLibAch6());
         }

         if (this.optionTiers.getModeleAch7() != null && !this.optionTiers.getModeleAch7().isEmpty()) {
            this.calculLigneAchat(this.optionTiers.getModeleAch7(), this.optionTiers.getLibAch7());
         }

         if (this.optionTiers.getModeleAch8() != null && !this.optionTiers.getModeleAch8().isEmpty()) {
            this.calculLigneAchat(this.optionTiers.getModeleAch8(), this.optionTiers.getLibAch8());
         }

         if (this.optionTiers.getModeleAch9() != null && !this.optionTiers.getModeleAch9().isEmpty()) {
            this.calculLigneAchat(this.optionTiers.getModeleAch9(), this.optionTiers.getLibAch9());
         }

         if (this.optionTiers.getModeleAch10() != null && !this.optionTiers.getModeleAch10().isEmpty()) {
            this.calculLigneAchat(this.optionTiers.getModeleAch10(), this.optionTiers.getLibAch10());
         }

         if (this.optionTiers.getModeleStk1() != null && !this.optionTiers.getModeleStk1().isEmpty()) {
            this.calculLigneStock(this.optionTiers.getModeleStk1(), this.optionTiers.getLibStk1());
         }

         if (this.optionTiers.getModeleStk2() != null && !this.optionTiers.getModeleStk2().isEmpty()) {
            this.calculLigneStock(this.optionTiers.getModeleStk2(), this.optionTiers.getLibStk2());
         }

         if (this.optionTiers.getModeleStk3() != null && !this.optionTiers.getModeleStk3().isEmpty()) {
            this.calculLigneStock(this.optionTiers.getModeleStk3(), this.optionTiers.getLibStk3());
         }

         if (this.optionTiers.getModeleStk4() != null && !this.optionTiers.getModeleStk4().isEmpty()) {
            this.calculLigneStock(this.optionTiers.getModeleStk4(), this.optionTiers.getLibStk4());
         }

         if (this.optionTiers.getModeleStk5() != null && !this.optionTiers.getModeleStk5().isEmpty()) {
            this.calculLigneStock(this.optionTiers.getModeleStk5(), this.optionTiers.getLibStk5());
         }

         if (this.optionTiers.getModeleStk6() != null && !this.optionTiers.getModeleStk6().isEmpty()) {
            this.calculLigneStock(this.optionTiers.getModeleStk6(), this.optionTiers.getLibStk6());
         }

         if (this.optionTiers.getModeleStk7() != null && !this.optionTiers.getModeleStk7().isEmpty()) {
            this.calculLigneStock(this.optionTiers.getModeleStk7(), this.optionTiers.getLibStk7());
         }

         if (this.optionTiers.getModeleStk8() != null && !this.optionTiers.getModeleStk8().isEmpty()) {
            this.calculLigneStock(this.optionTiers.getModeleStk8(), this.optionTiers.getLibStk8());
         }

         if (this.optionTiers.getModeleStk9() != null && !this.optionTiers.getModeleStk9().isEmpty()) {
            this.calculLigneStock(this.optionTiers.getModeleStk9(), this.optionTiers.getLibStk9());
         }

         if (this.optionTiers.getModeleStk10() != null && !this.optionTiers.getModeleStk10().isEmpty()) {
            this.calculLigneStock(this.optionTiers.getModeleStk10(), this.optionTiers.getLibStk10());
         }

         if (this.optionTiers.getModeleVte1() != null && !this.optionTiers.getModeleVte1().isEmpty()) {
            this.calculLigneVente(this.optionTiers.getModeleVte1(), this.optionTiers.getLibVte1());
         }

         if (this.optionTiers.getModeleVte2() != null && !this.optionTiers.getModeleVte2().isEmpty()) {
            this.calculLigneVente(this.optionTiers.getModeleVte2(), this.optionTiers.getLibVte2());
         }

         if (this.optionTiers.getModeleVte3() != null && !this.optionTiers.getModeleVte3().isEmpty()) {
            this.calculLigneVente(this.optionTiers.getModeleVte3(), this.optionTiers.getLibVte3());
         }

         if (this.optionTiers.getModeleVte4() != null && !this.optionTiers.getModeleVte4().isEmpty()) {
            this.calculLigneVente(this.optionTiers.getModeleVte4(), this.optionTiers.getLibVte4());
         }

         if (this.optionTiers.getModeleVte5() != null && !this.optionTiers.getModeleVte5().isEmpty()) {
            this.calculLigneVente(this.optionTiers.getModeleVte5(), this.optionTiers.getLibVte5());
         }

         if (this.optionTiers.getModeleVte6() != null && !this.optionTiers.getModeleVte6().isEmpty()) {
            this.calculLigneVente(this.optionTiers.getModeleVte6(), this.optionTiers.getLibVte6());
         }

         if (this.optionTiers.getModeleVte7() != null && !this.optionTiers.getModeleVte7().isEmpty()) {
            this.calculLigneVente(this.optionTiers.getModeleVte7(), this.optionTiers.getLibVte7());
         }

         if (this.optionTiers.getModeleVte8() != null && !this.optionTiers.getModeleVte8().isEmpty()) {
            this.calculLigneVente(this.optionTiers.getModeleVte8(), this.optionTiers.getLibVte8());
         }

         if (this.optionTiers.getModeleVte9() != null && !this.optionTiers.getModeleVte9().isEmpty()) {
            this.calculLigneVente(this.optionTiers.getModeleVte9(), this.optionTiers.getLibVte9());
         }

         if (this.optionTiers.getModeleVte10() != null && !this.optionTiers.getModeleVte10().isEmpty()) {
            this.calculLigneVente(this.optionTiers.getModeleVte10(), this.optionTiers.getLibVte10());
         }

         if (this.optionTiers.getModeleTre1() != null && !this.optionTiers.getModeleTre1().isEmpty()) {
            this.calculLigneTreso(this.optionTiers.getModeleTre1(), this.optionTiers.getLibTre1());
         }

         if (this.optionTiers.getModeleTre2() != null && !this.optionTiers.getModeleTre2().isEmpty()) {
            this.calculLigneTreso(this.optionTiers.getModeleTre2(), this.optionTiers.getLibTre2());
         }

         if (this.optionTiers.getModeleTre3() != null && !this.optionTiers.getModeleTre3().isEmpty()) {
            this.calculLigneTreso(this.optionTiers.getModeleTre3(), this.optionTiers.getLibTre3());
         }

         if (this.optionTiers.getModeleTre4() != null && !this.optionTiers.getModeleTre4().isEmpty()) {
            this.calculLigneTreso(this.optionTiers.getModeleTre4(), this.optionTiers.getLibTre4());
         }

         if (this.optionTiers.getModeleTre5() != null && !this.optionTiers.getModeleTre5().isEmpty()) {
            this.calculLigneTreso(this.optionTiers.getModeleTre5(), this.optionTiers.getLibTre5());
         }
      }

      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "statistiques";
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            if (var3[var4].endsWith("jasper")) {
               String var5 = var3[var4].substring(0, var3[var4].indexOf("."));
               this.calculLigneStatistique("Statistique", var5);
            }
         }
      }

      this.dataModelImpgenFichier.setWrappedData(this.lesFichImpression);
      Session var15 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsAchs");
      new ExercicesAchats();
      ExercicesAchatsDao var6 = new ExercicesAchatsDao(this.baseLog, this.utilInitHibernate);
      ExercicesAchats var16 = var6.recupererLastExo(var15);
      if (var16 != null) {
         this.mesFamillesAchatsItems = this.famillesProduitsAchatsDao.chargerFamilleProduitAchatsItems(var16.getExeachId(), var15);
         this.mesDepotItems = this.depotAchatsDao.selectActifDepotItems(0, var15);
      }

      new ExercicesVentes();
      ExercicesVentesDao var8 = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
      ExercicesVentes var7 = var8.recupererLastExo(var15);
      if (var7 != null) {
         this.mesFamillesVentesItems = this.famillesProduitsVentesDao.chargerFamilleProduitVentesItems(var7.getExevteId(), var15);
      }

      new ExercicesCaisse();
      ExercicesCaisseDao var10 = new ExercicesCaisseDao(this.baseLog, this.utilInitHibernate);
      ExercicesCaisse var9 = var10.recupererLastExo(var15);
      if (var9 != null) {
         UsersChronoDao var11 = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
         this.mesCaisseItems = new ArrayList();
         new ArrayList();
         List var12 = var11.selectListOfficeByUser(this.usersLog, var15);
         if (var12.size() > 1) {
            this.mesCaisseItems.add(new SelectItem(100, "Toutes les caisses"));
         }

         if (var12.size() != 0) {
            for(int var13 = 0; var13 < var12.size(); ++var13) {
               String var14 = ((UsersChrono)var12.get(var13)).getUsrchrCodeCaisse() + ":" + ((UsersChrono)var12.get(var13)).getUsrchrLib();
               this.mesCaisseItems.add(new SelectItem(var14));
            }
         }
      }

      LectureElementRdv var17 = new LectureElementRdv();
      var17.setStrId(this.structureLog.getStrid());
      var17.setStructureLog(this.structureLog);
      var17.chargerMesCentreInteret();
      this.mesCentresInteretsItems = var17.getMesElementsItems();
      var17.chargerMesConclusionRdv();
      this.mesConclusionsItems = var17.getMesElementsItems();
      var17.chargerMesActionRdv();
      this.mesActionsItems = var17.getMesElementsItems();
      UserDao var18 = new UserDao(this.baseLog, this.utilInitHibernate);
      this.mesConseillersItems = var18.chargerLesCommerciauxItems(var15);
      this.utilInitHibernate.closeSession();
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

   public void calculLigneAchat(String var1, String var2) {
      this.infosSysteme = new InfosSysteme();
      this.infosSysteme.setType("Achat");
      String[] var3 = var1.split(":");
      this.infosSysteme.setModule(var3[0]);
      this.infosSysteme.setNomrepertoire(var3[1]);
      this.infosSysteme.setNomTable(var3[2]);
      if (var2 != null && !var2.isEmpty()) {
         this.infosSysteme.setNomReel(var2);
      } else {
         this.infosSysteme.setNomReel(this.infosSysteme.getNomTable());
      }

      this.lesFichImpression.add(this.infosSysteme);
   }

   public void calculLigneStock(String var1, String var2) {
      this.infosSysteme = new InfosSysteme();
      this.infosSysteme.setType("Stock");
      String[] var3 = var1.split(":");
      this.infosSysteme.setModule(var3[0]);
      this.infosSysteme.setNomrepertoire(var3[1]);
      this.infosSysteme.setNomTable(var3[2]);
      if (var2 != null && !var2.isEmpty()) {
         this.infosSysteme.setNomReel(var2);
      } else {
         this.infosSysteme.setNomReel(this.infosSysteme.getNomTable());
      }

      this.lesFichImpression.add(this.infosSysteme);
   }

   public void calculLigneVente(String var1, String var2) {
      this.infosSysteme = new InfosSysteme();
      this.infosSysteme.setType("Vente");
      String[] var3 = var1.split(":");
      this.infosSysteme.setModule(var3[0]);
      this.infosSysteme.setNomrepertoire(var3[1]);
      this.infosSysteme.setNomTable(var3[2]);
      if (var2 != null && !var2.isEmpty()) {
         this.infosSysteme.setNomReel(var2);
      } else {
         this.infosSysteme.setNomReel(this.infosSysteme.getNomTable());
      }

      this.lesFichImpression.add(this.infosSysteme);
   }

   public void calculLigneTreso(String var1, String var2) {
      this.infosSysteme = new InfosSysteme();
      this.infosSysteme.setType("Trésorerie");
      String[] var3 = var1.split(":");
      this.infosSysteme.setModule(var3[0]);
      this.infosSysteme.setNomrepertoire(var3[1]);
      this.infosSysteme.setNomTable(var3[2]);
      if (var2 != null && !var2.isEmpty()) {
         this.infosSysteme.setNomReel(var2);
      } else {
         this.infosSysteme.setNomReel(this.infosSysteme.getNomTable());
      }

      this.lesFichImpression.add(this.infosSysteme);
   }

   public void calculLigneStatistique(String var1, String var2) {
      this.infosSysteme = new InfosSysteme();
      this.infosSysteme.setType("Statistiques");
      this.infosSysteme.setModule("Office");
      this.infosSysteme.setNomrepertoire("statistiques");
      this.infosSysteme.setNomTable(var2);
      if (var2 != null && !var2.isEmpty()) {
         this.infosSysteme.setNomReel(var2);
      } else {
         this.infosSysteme.setNomReel(this.infosSysteme.getNomTable());
      }

      this.lesFichImpression.add(this.infosSysteme);
   }

   public void rechercheFournisseur() throws HibernateException, NamingException {
      Object var1 = new ArrayList();
      if (this.nomTiers != null && !this.nomTiers.isEmpty()) {
         String var2 = "(0,1)";
         TiersDao var3 = new TiersDao(this.baseLog, this.utilInitHibernate);
         var1 = var3.verifTiers(this.usersLog, var2, this.nomTiers, (Session)null);
         this.showModalPanelTiers = true;
      }

      this.datamodelTiers.setWrappedData(var1);
   }

   public void rechercheClient() throws HibernateException, NamingException {
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

   public void rechercheProduitsAchatDebut() throws HibernateException, NamingException {
      Object var1 = new ArrayList();
      if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
         ProduitsAchsDao var2 = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
         var1 = var2.verifProduits(this.produitDebut, (Session)null);
         this.var_produit_choix = false;
         this.showModalPanelProduits = true;
      }

      this.datamodelProduits.setWrappedData(var1);
   }

   public void rechercheProduitsAchatFin() throws HibernateException, NamingException {
      Object var1 = new ArrayList();
      if (this.produitFin != null && !this.produitFin.isEmpty()) {
         ProduitsAchsDao var2 = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
         var1 = var2.verifProduits(this.produitFin, (Session)null);
         this.var_produit_choix = true;
         this.showModalPanelProduits = true;
      }

      this.datamodelProduits.setWrappedData(var1);
   }

   public void rechercheProduitsStockDebut() throws HibernateException, NamingException {
      Object var1 = new ArrayList();
      if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
         ProduitsVtesDao var2 = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
         var1 = var2.verifProduits(this.produitDebut, (Session)null);
         this.var_produit_choix = false;
         this.showModalPanelProduits = true;
      }

      this.datamodelProduits.setWrappedData(var1);
   }

   public void rechercheProduitsStockFin() throws HibernateException, NamingException {
      Object var1 = new ArrayList();
      if (this.produitFin != null && !this.produitFin.isEmpty()) {
         ProduitsVtesDao var2 = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
         var1 = var2.verifProduits(this.produitFin, (Session)null);
         this.var_produit_choix = true;
         this.showModalPanelProduits = true;
      }

      this.datamodelProduits.setWrappedData(var1);
   }

   public void rechercheProduitsVenteDebut() throws HibernateException, NamingException {
      new ArrayList();
      if (this.produitDebut != null && !this.produitDebut.isEmpty()) {
         ProduitsVtesDao var2 = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
         List var1 = var2.verifProduits(this.produitDebut, (Session)null);
         this.datamodelProduits.setWrappedData(var1);
         this.var_produit_choix = false;
         this.showModalPanelProduits = true;
      }

   }

   public void rechercheProduitsVenteFin() throws HibernateException, NamingException {
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

   public void recupererNomfich() throws ParseException {
      this.nomTiers = "";
      this.tiers = null;
      this.afficheClient = false;
      this.afficheFourniseur = false;
      this.afficheProduitAch = false;
      this.afficheProduitStk = false;
      this.afficheProduitVte = false;
      this.afficheCaisse = false;
      this.afficheStatistique = false;
      if (this.dataModelImpgenFichier.isRowAvailable()) {
         this.infosSysteme = (InfosSysteme)this.dataModelImpgenFichier.getRowData();
         if (this.infosSysteme.getModule().contains("produit")) {
            if (this.infosSysteme.getType().contains("Vente")) {
               this.afficheProduitVte = true;
            } else if (this.infosSysteme.getType().equals("Achat")) {
               this.afficheProduitAch = true;
            }
         } else if (this.infosSysteme.getModule().contains("stock")) {
            this.afficheProduitStk = true;
         }

         if (this.infosSysteme.getType().contains("Vente")) {
            this.afficheClient = true;
         }

         if (this.infosSysteme.getType().equals("Achat")) {
            this.afficheFourniseur = true;
         }

         if (this.infosSysteme.getType().equals("Trésorerie")) {
            if (this.infosSysteme.getNomTable().contains("Client")) {
               this.afficheClient = true;
            }

            if (this.infosSysteme.getNomTable().contains("Fournisseur")) {
               this.afficheFourniseur = true;
            }

            this.afficheCaisse = true;
         }

         if (this.infosSysteme.getType().contains("Statistiques")) {
            this.afficheStatistique = true;
         }

         this.calculeDates();
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
         if (this.tiers != null) {
            this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, this.tiers, "");
         } else {
            this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, (Tiers)null, "");
         }

         if (this.utilPrint.getLesbalEmetteursItems().size() != 0) {
            this.affMail = true;
         } else {
            this.affMail = false;
         }
      } else {
         this.affMail = false;
      }

   }

   public void imprimer() throws SQLException, JRException, IOException, NamingException, ClassNotFoundException, Exception {
      if (this.infosSysteme != null) {
         ExercicesAchats var1;
         ExercicesAchatsDao var2;
         if (this.infosSysteme.getType().equals("Achat")) {
            new ExercicesAchats();
            var2 = new ExercicesAchatsDao(this.baseLog, this.utilInitHibernate);
            var1 = var2.recupererLastExo((Session)null);
            if (var1 != null) {
               LireLesoptionsAchats var3 = new LireLesoptionsAchats();
               new OptionAchats();
               OptionAchats var4 = var3.lancer();
               this.formImpressionAchats = new FormImpressionAchats();
               this.formImpressionAchats.setutilInitHibernate(this.utilInitHibernate);
               this.formImpressionAchats.setBaseLog(this.baseLog);
               this.formImpressionAchats.setStructureLog(this.structureLog);
               this.formImpressionAchats.setUsersLog(this.usersLog);
               this.formImpressionAchats.InstancesDaoUtilses();
               this.formImpressionAchats.setExoSelectionne(var1);
               this.formImpressionAchats.setOptionAchats(var4);
               this.utilPrint = new UtilPrint(this.utilInitHibernate);
               this.formImpressionAchats.setUtilPrint(this.utilPrint);
               this.formImpressionAchats.setNomRepertoire(this.infosSysteme.getNomrepertoire());
               this.formImpressionAchats.setNomEtat(this.infosSysteme.getNomTable());
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

               this.formImpressionAchats.setFormat(this.format);
               this.formImpressionAchats.setImpEmetteur(this.impEmetteur);
               this.formImpressionAchats.setImpDestinataire(this.impDestinataire);
               this.formImpressionAchats.setImpDestinataireCC(this.impDestinataireCC);
               this.formImpressionAchats.setImpDestinataireCCI(this.impDestinataireCCI);
               this.formImpressionAchats.setUsersLog(this.usersLog);
               this.formImpressionAchats.setFiltreDateDebut(this.filtreDateDebut);
               this.formImpressionAchats.setFiltreDateFin(this.filtreDateFin);
               this.formImpressionAchats.setEtat("100");
               this.formImpressionAchats.setSerie("A");
               this.formImpressionAchats.setNomTiers(this.nomTiers);
               this.formImpressionAchats.setTiers(this.tiers);
               this.formImpressionAchats.setProduitDebut(this.produitDebut);
               this.formImpressionAchats.setProduitFin(this.produitFin);
               this.formImpressionAchats.setFamille(this.famille);
               this.formImpressionAchats.setDepot(this.depot);
               this.formImpressionAchats.imprimer();
            }
         } else if (this.infosSysteme.getType().equals("Stock")) {
            new ExercicesAchats();
            var2 = new ExercicesAchatsDao(this.baseLog, this.utilInitHibernate);
            var1 = var2.recupererLastExo((Session)null);
            if (var1 != null) {
               LireLesoptionsStocks var11 = new LireLesoptionsStocks();
               new OptionStocks();
               OptionStocks var15 = var11.lancer();
               this.formImpressionStock = new FormImpressionStock();
               this.formImpressionStock.setutilInitHibernate(this.utilInitHibernate);
               this.formImpressionStock.setBaseLog(this.baseLog);
               this.formImpressionStock.setStructureLog(this.structureLog);
               this.formImpressionStock.setUsersLog(this.usersLog);
               this.formImpressionStock.InstancesDaoUtilses();
               this.formImpressionStock.setExoSelectionne(var1);
               this.formImpressionStock.setOptionStocks(var15);
               this.utilPrint = new UtilPrint(this.utilInitHibernate);
               this.formImpressionStock.setUtilPrint(this.utilPrint);
               this.formImpressionStock.setNomRepertoire(this.infosSysteme.getNomrepertoire());
               this.formImpressionStock.setNomEtat(this.infosSysteme.getNomTable());
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

               this.formImpressionStock.setFormat(this.format);
               this.formImpressionStock.setImpEmetteur(this.impEmetteur);
               this.formImpressionStock.setImpDestinataire(this.impDestinataire);
               this.formImpressionStock.setImpDestinataireCC(this.impDestinataireCC);
               this.formImpressionStock.setImpDestinataireCCI(this.impDestinataireCCI);
               this.formImpressionStock.setUsersLog(this.usersLog);
               this.formImpressionStock.setFiltreDateDebut(this.filtreDateDebut);
               this.formImpressionStock.setFiltreDateFin(this.filtreDateFin);
               this.formImpressionStock.setEtatRec("100");
               this.formImpressionStock.setSerie("A");
               this.formImpressionStock.setNomTiers("");
               this.formImpressionStock.setProduitDebut(this.produitDebut);
               this.formImpressionStock.setProduitFin(this.produitFin);
               this.formImpressionStock.setFamille(this.famille);
               this.formImpressionStock.setDepot(this.depot);
               this.formImpressionStock.setDepot_encours(this.depot);
               this.formImpressionStock.imprimer();
            }
         } else if (this.infosSysteme.getType().equals("Vente")) {
            new ExercicesVentes();
            ExercicesVentesDao var8 = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
            ExercicesVentes var5 = var8.recupererLastExo((Session)null);
            if (var5 != null) {
               LireLesoptionsVentes var13 = new LireLesoptionsVentes();
               new OptionVentes();
               OptionVentes var16 = var13.lancer();
               this.formImpressionVentes = new FormImpressionVentes();
               this.formImpressionVentes.setutilInitHibernate(this.utilInitHibernate);
               this.formImpressionVentes.setBaseLog(this.baseLog);
               this.formImpressionVentes.setStructureLog(this.structureLog);
               this.formImpressionVentes.setUsersLog(this.usersLog);
               this.formImpressionVentes.InstancesDaoUtilses();
               this.formImpressionVentes.setExoSelectionne(var5);
               this.formImpressionVentes.setOptionVentes(var16);
               this.utilPrint = new UtilPrint(this.utilInitHibernate);
               this.formImpressionVentes.setUtilPrint(this.utilPrint);
               this.formImpressionVentes.setNomRepertoire(this.infosSysteme.getNomrepertoire());
               this.formImpressionVentes.setNomEtat(this.infosSysteme.getNomTable());
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

               this.formImpressionVentes.setFormat(this.format);
               this.formImpressionVentes.setImpEmetteur(this.impEmetteur);
               this.formImpressionVentes.setImpDestinataire(this.impDestinataire);
               this.formImpressionVentes.setImpDestinataireCC(this.impDestinataireCC);
               this.formImpressionVentes.setImpDestinataireCCI(this.impDestinataireCCI);
               this.formImpressionVentes.setUsersLog(this.usersLog);
               this.formImpressionVentes.setFiltreDateDebut(this.filtreDateDebut);
               this.formImpressionVentes.setFiltreDateFin(this.filtreDateFin);
               this.formImpressionVentes.setEtat("100");
               this.formImpressionVentes.setSerie("A");
               this.formImpressionVentes.setVar_devis(false);
               this.formImpressionVentes.setVar_bc(false);
               this.formImpressionVentes.setVar_bl(false);
               this.formImpressionVentes.setVar_br(false);
               this.formImpressionVentes.setVar_facture(true);
               this.formImpressionVentes.setVar_noteDebit(true);
               this.formImpressionVentes.setVar_avoir(true);
               this.formImpressionVentes.setVar_bs(false);
               this.formImpressionVentes.setVar_be(false);
               this.formImpressionVentes.setVar_cessionIn(false);
               this.formImpressionVentes.setVar_cessionOut(false);
               this.formImpressionVentes.setNomTiers(this.nomTiers);
               this.formImpressionVentes.setTiers(this.tiers);
               this.formImpressionVentes.setProduitDebut(this.produitDebut);
               this.formImpressionVentes.setProduitFin(this.produitFin);
               this.formImpressionVentes.setFamille(this.famille);
               this.formImpressionVentes.imprimer();
            }
         } else if (this.infosSysteme.getType().equals("Trésorerie")) {
            new ExercicesCaisse();
            ExercicesCaisseDao var10 = new ExercicesCaisseDao(this.baseLog, this.utilInitHibernate);
            ExercicesCaisse var6 = var10.recupererLastExo((Session)null);
            if (var6 != null) {
               LireLesoptionsCaisses var14 = new LireLesoptionsCaisses();
               new OptionCaisses();
               OptionCaisses var17 = var14.lancer();
               this.formImpressionCaisse = new FormImpressionCaisse();
               this.formImpressionCaisse.setutilInitHibernate(this.utilInitHibernate);
               this.formImpressionCaisse.setBaseLog(this.baseLog);
               this.formImpressionCaisse.setStructureLog(this.structureLog);
               this.formImpressionCaisse.setUsersLog(this.usersLog);
               this.formImpressionCaisse.InstancesDaoUtilses();
               this.formImpressionCaisse.setExoSelectionne(var6);
               this.formImpressionCaisse.setOptionCaisses(var17);
               this.utilPrint = new UtilPrint(this.utilInitHibernate);
               this.formImpressionCaisse.setUtilPrint(this.utilPrint);
               this.formImpressionCaisse.setNomRepertoire(this.infosSysteme.getNomrepertoire());
               this.formImpressionCaisse.setNomEtat(this.infosSysteme.getNomTable());
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

               this.formImpressionCaisse.setFormat(this.format);
               this.formImpressionCaisse.setImpEmetteur(this.impEmetteur);
               this.formImpressionCaisse.setImpDestinataire(this.impDestinataire);
               this.formImpressionCaisse.setImpDestinataireCC(this.impDestinataireCC);
               this.formImpressionCaisse.setImpDestinataireCCI(this.impDestinataireCCI);
               this.formImpressionCaisse.setUsersLog(this.usersLog);
               this.formImpressionCaisse.setFiltreDateDebut(this.filtreDateDebut);
               this.formImpressionCaisse.setFiltreDateFin(this.filtreDateFin);
               this.formImpressionCaisse.setEtat("100");
               this.formImpressionCaisse.setSerie("A");
               this.formImpressionCaisse.setNomTiers(this.nomTiers);
               this.formImpressionCaisse.setCaisse(this.caisse);
               this.formImpressionCaisse.imprimer();
            }
         } else if (this.infosSysteme.getType().equals("Statistiques")) {
            this.var_ctrl_imp = true;
            this.listDocument = new ArrayList();
            this.calculeRequete();
            this.utilPrint.setRapport(this.infosSysteme.getNomTable());
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + this.infosSysteme.getNomrepertoire() + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "sous_rapport" + File.separator);
            this.var_entete = this.infosSysteme.getNomTable();
            if (this.var_entete != null && !this.var_entete.isEmpty()) {
               this.utilPrint.setEntete(this.var_entete.replace("_", " "));
            } else {
               this.utilPrint.setEntete("");
            }

            this.var_filtre = "Activités du " + this.utilDate.dateToStringFrLg(this.filtreDateDebut) + " au " + this.utilDate.dateToStringFrLg(this.filtreDateFin) + " " + this.var_filtre;
            if (this.var_filtre != null && !this.var_filtre.isEmpty()) {
               this.utilPrint.setFiltre(this.var_filtre.replace("_", " "));
            } else {
               this.utilPrint.setFiltre("");
            }

            if (this.infosSysteme.getNomTable().equalsIgnoreCase("Statistiques_Prospects")) {
               this.utilPrint.setRequete("");
               JRBeanCollectionDataSource var7 = new JRBeanCollectionDataSource(this.listDocument);
               this.utilPrint.setjRBeanCollectionDataSource(var7);
            } else {
               this.utilPrint.setRequete(this.var_requete);
               ArrayList var9 = new ArrayList();
               JRBeanCollectionDataSource var12 = new JRBeanCollectionDataSource(var9);
               this.utilPrint.setjRBeanCollectionDataSource(var12);
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

   }

   public void calculeRequete() throws HibernateException, NamingException {
      UserDao var1 = new UserDao(this.baseLog, this.utilInitHibernate);
      new Users();
      new ArrayList();
      List var3 = var1.chargerLesUsers((Session)null);
      Users var2;
      int var11;
      if (this.infosSysteme.getNomTable().equalsIgnoreCase("Statistiques_Prospects")) {
         Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "Office");
         new DocumentStatistique();
         ResponsableDao var6 = new ResponsableDao(this.baseLog, this.utilInitHibernate);
         if (var3.size() != 0) {
            ArrayList var7 = new ArrayList();
            TiersDao var8 = new TiersDao(this.baseLog, this.utilInitHibernate);
            Object var9 = new ArrayList();
            RdvDao var10 = new RdvDao(this.baseLog, this.utilInitHibernate);
            var11 = 0;

            while(true) {
               DocumentStatistique var5;
               int var12;
               int var15;
               int var17;
               if (var11 >= var3.size()) {
                  var11 = 0;
                  var12 = 0;
                  new ArrayList();
                  List var60 = var8.chargerLesTiers("2", var4);
                  new ArrayList();
                  List var61 = var6.selectResponsable(var4);

                  for(var15 = 0; var15 < var60.size(); ++var15) {
                     boolean var62 = false;

                     for(var17 = 0; var17 < var61.size(); ++var17) {
                        if (((Responsable)var61.get(var17)).getTiers().getTieid() == ((Tiers)var60.get(var15)).getTieid()) {
                           var62 = true;
                           break;
                        }
                     }

                     if (!var62) {
                        if (((Tiers)var60.get(var15)).getTiedatecreat().compareTo(this.filtreDateDebut) >= 0 && ((Tiers)var60.get(var15)).getTiedatecreat().compareTo(this.filtreDateFin) <= 0) {
                           ++var11;
                        } else {
                           ++var12;
                        }
                     }
                  }

                  var5 = new DocumentStatistique();
                  var5.setNomConseiller("Tiers non imputés à un conseiller");
                  var5.setIdConseiller(0L);
                  var5.setNbTiersPeriode(0);
                  var5.setNbTiersHorsPeriode(0);
                  var5.setNbTiersNonAffectePeriode(var11);
                  var5.setNbTiersNonAffecteHorsPeriode(var12);
                  var5.setNbRappelPeriode(0);
                  var5.setNbRappelHorsPeriode(0);
                  var5.setNbRdvPeriode(0);
                  var5.setNbRdvHorsPeriode(0);
                  var5.setNbToDoPeriode(0);
                  var5.setNbToDoHorsPeriode(0);
                  var5.setNbEmploiTPeriode(0);
                  var5.setNbEmploiTHorsPeriode(0);
                  var5.setNbVisitePeriode(0);
                  var5.setNbVisiteHorsPeriode(0);
                  var5.setNbInterventionPeriode(0);
                  var5.setNbInterventionHorsPeriode(0);
                  var5.setNbAppelPeriode(0);
                  var5.setNbAppelHorsPeriode(0);
                  var5.setNbPointagePeriode(0);
                  var5.setNbPointageHorsPeriode(0);
                  var5.setNbReunionPeriode(0);
                  var5.setNbReunionHorsPeriode(0);
                  var5.setNbMessagePeriode(0);
                  var5.setNbMessageHorsPeriode(0);
                  var5.setNbPostitPeriode(0);
                  var5.setNbPostitHorsPeriode(0);
                  var5.setNbCalendrierPeriode(0);
                  var5.setNbCalendrierHorsPeriode(0);
                  var5.setNbCmdPeriode(0);
                  var5.setNbCmdHorsPeriode(0);
                  var5.setNbMailsPeriode(0);
                  var5.setNbMailsHorsPeriode(0);
                  var5.setNbRondePeriode(0);
                  var5.setNbRondeHorsPeriode(0);
                  this.listDocument.add(var5);
                  break;
               }

               var2 = (Users)var3.get(var11);
               if (var2.getUsrVendeur() == 1) {
                  var12 = 0;
                  int var13 = 0;
                  int var14 = 0;
                  var15 = 0;
                  int var16 = 0;
                  var17 = 0;
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
                  var7.clear();
                  new ArrayList();
                  List var44 = var6.chargerLesResponsables(var2.getUsrid(), var4);
                  int var45;
                  if (var44.size() != 0) {
                     for(var45 = 0; var45 < var44.size(); ++var45) {
                        if (((Responsable)var44.get(var45)).getTiers().getTietype() != null && !((Responsable)var44.get(var45)).getTiers().getTietype().isEmpty() && ((Responsable)var44.get(var45)).getTiers().getTietype().equals("2")) {
                           if (((Responsable)var44.get(var45)).getTiers().getTiedatecreat().compareTo(this.filtreDateDebut) >= 0 && ((Responsable)var44.get(var45)).getTiers().getTiedatecreat().compareTo(this.filtreDateFin) <= 0) {
                              ++var12;
                           } else {
                              ++var13;
                           }
                        }
                     }
                  }

                  ((List)var9).clear();
                  var9 = var10.selectEvenements(var2.getUsrid(), var4);
                  if (((List)var9).size() != 0) {
                     for(var45 = 0; var45 < ((List)var9).size(); ++var45) {
                        if (((Rdv)((List)var9).get(var45)).getRdvDteDe() == null) {
                           ((Rdv)((List)var9).get(var45)).setRdvDteDe(((Rdv)((List)var9).get(var45)).getRdvDateCreation());
                        }

                        boolean var46 = false;
                        boolean var47 = false;
                        if (((Rdv)((List)var9).get(var45)).getRdvTieIdDe() != 0L && (this.observation != null && !this.observation.isEmpty() || this.centreInteret != null && !this.centreInteret.isEmpty())) {
                           this.tiers = var8.selectTierD(((Rdv)((List)var9).get(var45)).getRdvTieIdDe(), var4);
                           if (this.tiers != null) {
                              if (this.observation != null && !this.observation.isEmpty()) {
                                 if (this.tiers.getTieobservations() != null && !this.tiers.getTieobservations().isEmpty() && this.tiers.getTieobservations().contains(this.observation)) {
                                    var46 = true;
                                 }
                              } else {
                                 var46 = true;
                              }

                              if (this.centreInteret != null && !this.centreInteret.isEmpty()) {
                                 if (this.tiers.getTieinteret() != null && !this.tiers.getTieinteret().isEmpty() && this.tiers.getTieinteret().contains(this.centreInteret)) {
                                    var47 = true;
                                 }
                              } else {
                                 var47 = true;
                              }
                           }
                        } else {
                           var46 = true;
                           var47 = true;
                        }

                        boolean var48 = false;
                        if (this.action != null && !this.action.isEmpty()) {
                           if (((Rdv)((List)var9).get(var45)).getRdvTache() != null && !((Rdv)((List)var9).get(var45)).getRdvTache().isEmpty() && ((Rdv)((List)var9).get(var45)).getRdvTache().equalsIgnoreCase(this.action)) {
                              var48 = true;
                           }
                        } else {
                           var48 = true;
                        }

                        boolean var49 = false;
                        if (this.compteRendu != null && !this.compteRendu.isEmpty()) {
                           if (((Rdv)((List)var9).get(var45)).getRdvCr() != null && !((Rdv)((List)var9).get(var45)).getRdvCr().isEmpty() && ((Rdv)((List)var9).get(var45)).getRdvCr().contains(this.compteRendu)) {
                              var49 = true;
                           }
                        } else {
                           var49 = true;
                        }

                        boolean var50 = false;
                        if (this.conclusion != null && !this.conclusion.isEmpty()) {
                           if (((Rdv)((List)var9).get(var45)).getRdvConclusion() != null && !((Rdv)((List)var9).get(var45)).getRdvConclusion().isEmpty() && ((Rdv)((List)var9).get(var45)).getRdvConclusion().equalsIgnoreCase(this.conclusion)) {
                              var50 = true;
                           }
                        } else {
                           var50 = true;
                        }

                        boolean var51 = false;
                        if (this.conseiller != 0L) {
                           if (((Rdv)((List)var9).get(var45)).getRdvUsrDe() == this.conseiller) {
                              var51 = true;
                           }
                        } else {
                           var51 = true;
                        }

                        if (var47 && var46 && var48 && var49 && var50 && var51) {
                           if (((Rdv)((List)var9).get(var45)).getRdvDteDe().compareTo(this.filtreDateDebut) >= 0 && ((Rdv)((List)var9).get(var45)).getRdvDteDe().compareTo(this.filtreDateFin) <= 0) {
                              if (((Rdv)((List)var9).get(var45)).getRdvNature() == 0) {
                                 ++var14;
                              } else if (((Rdv)((List)var9).get(var45)).getRdvNature() == 1) {
                                 ++var16;
                              } else if (((Rdv)((List)var9).get(var45)).getRdvNature() == 2) {
                                 ++var18;
                              } else if (((Rdv)((List)var9).get(var45)).getRdvNature() == 3) {
                                 ++var20;
                              } else if (((Rdv)((List)var9).get(var45)).getRdvNature() == 4) {
                                 ++var22;
                              } else if (((Rdv)((List)var9).get(var45)).getRdvNature() == 5) {
                                 ++var24;
                              } else if (((Rdv)((List)var9).get(var45)).getRdvNature() == 6) {
                                 ++var26;
                              } else if (((Rdv)((List)var9).get(var45)).getRdvNature() == 7) {
                                 ++var28;
                              } else if (((Rdv)((List)var9).get(var45)).getRdvNature() == 8) {
                                 ++var30;
                              } else if (((Rdv)((List)var9).get(var45)).getRdvNature() == 9) {
                                 ++var32;
                              } else if (((Rdv)((List)var9).get(var45)).getRdvNature() == 10) {
                                 ++var34;
                              } else if (((Rdv)((List)var9).get(var45)).getRdvNature() == 11) {
                                 ++var36;
                              } else if (((Rdv)((List)var9).get(var45)).getRdvNature() == 12) {
                                 ++var38;
                              } else if (((Rdv)((List)var9).get(var45)).getRdvNature() == 13) {
                                 ++var40;
                              } else if (((Rdv)((List)var9).get(var45)).getRdvNature() == 14) {
                                 ++var42;
                              }
                           } else if (((Rdv)((List)var9).get(var45)).getRdvNature() == 0) {
                              ++var15;
                           } else if (((Rdv)((List)var9).get(var45)).getRdvNature() == 1) {
                              ++var17;
                           } else if (((Rdv)((List)var9).get(var45)).getRdvNature() == 2) {
                              ++var19;
                           } else if (((Rdv)((List)var9).get(var45)).getRdvNature() == 3) {
                              ++var21;
                           } else if (((Rdv)((List)var9).get(var45)).getRdvNature() == 4) {
                              ++var23;
                           } else if (((Rdv)((List)var9).get(var45)).getRdvNature() == 5) {
                              ++var25;
                           } else if (((Rdv)((List)var9).get(var45)).getRdvNature() == 6) {
                              ++var27;
                           } else if (((Rdv)((List)var9).get(var45)).getRdvNature() == 7) {
                              ++var29;
                           } else if (((Rdv)((List)var9).get(var45)).getRdvNature() == 8) {
                              ++var31;
                           } else if (((Rdv)((List)var9).get(var45)).getRdvNature() == 9) {
                              ++var33;
                           } else if (((Rdv)((List)var9).get(var45)).getRdvNature() == 10) {
                              ++var35;
                           } else if (((Rdv)((List)var9).get(var45)).getRdvNature() == 11) {
                              ++var37;
                           } else if (((Rdv)((List)var9).get(var45)).getRdvNature() == 12) {
                              ++var39;
                           } else if (((Rdv)((List)var9).get(var45)).getRdvNature() == 13) {
                              ++var41;
                           } else if (((Rdv)((List)var9).get(var45)).getRdvNature() == 14) {
                              ++var43;
                           }
                        }
                     }
                  }

                  var5 = new DocumentStatistique();
                  var5.setNomConseiller(var2.getUsrPatronyme());
                  var5.setIdConseiller(var2.getUsrid());
                  var5.setNbTiersPeriode(var12);
                  var5.setNbTiersHorsPeriode(var13);
                  var5.setNbTiersNonAffectePeriode(0);
                  var5.setNbTiersNonAffecteHorsPeriode(0);
                  var5.setNbRappelPeriode(var14);
                  var5.setNbRappelHorsPeriode(var15);
                  var5.setNbRdvPeriode(var16);
                  var5.setNbRdvHorsPeriode(var17);
                  var5.setNbToDoPeriode(var18);
                  var5.setNbToDoHorsPeriode(var19);
                  var5.setNbEmploiTPeriode(var20);
                  var5.setNbEmploiTHorsPeriode(var21);
                  var5.setNbVisitePeriode(var22);
                  var5.setNbVisiteHorsPeriode(var23);
                  var5.setNbInterventionPeriode(var24);
                  var5.setNbInterventionHorsPeriode(var25);
                  var5.setNbAppelPeriode(var26);
                  var5.setNbAppelHorsPeriode(var27);
                  var5.setNbPointagePeriode(var28);
                  var5.setNbPointageHorsPeriode(var29);
                  var5.setNbReunionPeriode(var30);
                  var5.setNbReunionHorsPeriode(var31);
                  var5.setNbMessagePeriode(var32);
                  var5.setNbMessageHorsPeriode(var33);
                  var5.setNbPostitPeriode(var34);
                  var5.setNbPostitHorsPeriode(var35);
                  var5.setNbCalendrierPeriode(var36);
                  var5.setNbCalendrierHorsPeriode(var37);
                  var5.setNbCmdPeriode(var38);
                  var5.setNbCmdHorsPeriode(var39);
                  var5.setNbMailsPeriode(var40);
                  var5.setNbMailsHorsPeriode(var41);
                  var5.setNbRondePeriode(var42);
                  var5.setNbRondeHorsPeriode(var43);
                  this.listDocument.add(var5);
               }

               ++var11;
            }
         }

         this.utilInitHibernate.closeSession();
      } else if (this.infosSysteme.getNomTable().equalsIgnoreCase("Rapport_Conseillers") || this.infosSysteme.getNomTable().equalsIgnoreCase("Evolution_Conseillers")) {
         String var52 = "";

         for(int var53 = 0; var53 < var3.size(); ++var53) {
            var2 = (Users)var3.get(var53);
            if (var2.getUsrVendeur() == 1) {
               if (var52 != null && !var52.isEmpty()) {
                  var52 = var52 + "," + var2.getUsrid();
               } else {
                  var52 = "" + var2.getUsrid();
               }
            }

            if (var52 == null || var52.isEmpty()) {
               var52 = "0";
            }
         }

         String var54 = "";
         if (this.observation != null && !this.observation.isEmpty() || this.centreInteret != null && !this.centreInteret.isEmpty()) {
            boolean var55 = false;
            boolean var56 = false;
            String var57 = "";
            new ArrayList();
            TiersDao var59 = new TiersDao(this.baseLog, this.utilInitHibernate);
            List var58 = var59.chargerLesTiers("2", (Session)null);
            if (var58.size() != 0) {
               var11 = 0;

               while(true) {
                  if (var11 >= var58.size()) {
                     if (var57 == null || var57.isEmpty()) {
                        var57 = "0";
                     }

                     var54 = var54 + " and rdv_tiers_de in (" + var57 + ")";
                     break;
                  }

                  if (this.observation != null && !this.observation.isEmpty()) {
                     if (((Tiers)var58.get(var11)).getTieobservations() != null && !((Tiers)var58.get(var11)).getTieobservations().isEmpty() && ((Tiers)var58.get(var11)).getTieobservations().contains(this.observation)) {
                        var55 = true;
                     }
                  } else {
                     var55 = true;
                  }

                  if (this.centreInteret != null && !this.centreInteret.isEmpty()) {
                     if (((Tiers)var58.get(var11)).getTieinteret() != null && !((Tiers)var58.get(var11)).getTieinteret().isEmpty() && ((Tiers)var58.get(var11)).getTieinteret().contains(this.centreInteret)) {
                        var56 = true;
                     }
                  } else {
                     var56 = true;
                  }

                  if (var55 && var56) {
                     if (var57 != null && !var57.isEmpty()) {
                        var57 = var57 + "," + ((Tiers)var58.get(var11)).getTieid();
                     } else {
                        var57 = "" + ((Tiers)var58.get(var11)).getTieid();
                     }
                  }

                  ++var11;
               }
            }
         }

         if (this.action != null && !this.action.isEmpty()) {
            var54 = var54 + " and rdv_tache = '" + this.action + "'";
         }

         if (this.compteRendu != null && !this.compteRendu.isEmpty()) {
            var54 = var54 + " and rdv_cr like '%" + this.compteRendu + "%'";
         }

         if (this.conclusion != null && !this.conclusion.isEmpty()) {
            var54 = var54 + " and rdv_conclusion = '" + this.conclusion + "'";
         }

         if (this.conseiller != 0L) {
            var54 = var54 + " and rdv_user_de = " + this.conseiller;
         }

         this.var_requete = "rdv_dte_de>='" + this.utilDate.dateToStringSQLLight(this.filtreDateDebut) + "' and rdv_dte_de<='" + this.utilDate.dateToStringSQLLight(this.filtreDateFin) + "' and rdv_usr_de in (" + var52 + var54 + ")";
      }

      this.var_filtre = "";
      if (this.observation != null && !this.observation.isEmpty()) {
         this.var_filtre = this.var_filtre + "Observation= " + this.observation;
      }

      if (this.centreInteret != null && !this.centreInteret.isEmpty()) {
         this.var_filtre = this.var_filtre + "Centre Intéret= " + this.centreInteret;
      }

      if (this.action != null && !this.action.isEmpty()) {
         this.var_filtre = this.var_filtre + "Action= " + this.action;
      }

      if (this.compteRendu != null && !this.compteRendu.isEmpty()) {
         this.var_filtre = this.var_filtre + "Compte rendu= " + this.compteRendu;
      }

      if (this.conclusion != null && !this.conclusion.isEmpty()) {
         this.var_filtre = this.var_filtre + "Conclusion= " + this.conclusion;
      }

      if (this.conseiller != 0L) {
         this.var_filtre = this.var_filtre + "Conseillier= " + this.conseiller;
      }

   }

   public String getBaseLog() {
      return this.baseLog;
   }

   public void setBaseLog(String var1) {
      this.baseLog = var1;
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

   public Structure getStructureLog() {
      return this.structureLog;
   }

   public void setStructureLog(Structure var1) {
      this.structureLog = var1;
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

   public OptionTiers getOptionTiers() {
      return this.optionTiers;
   }

   public void setOptionTiers(OptionTiers var1) {
      this.optionTiers = var1;
   }

   public DataModel getDataModelImpgenFichier() {
      return this.dataModelImpgenFichier;
   }

   public void setDataModelImpgenFichier(DataModel var1) {
      this.dataModelImpgenFichier = var1;
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

   public boolean isAfficheClient() {
      return this.afficheClient;
   }

   public void setAfficheClient(boolean var1) {
      this.afficheClient = var1;
   }

   public boolean isAfficheFourniseur() {
      return this.afficheFourniseur;
   }

   public void setAfficheFourniseur(boolean var1) {
      this.afficheFourniseur = var1;
   }

   public boolean isAfficheProduitAch() {
      return this.afficheProduitAch;
   }

   public void setAfficheProduitAch(boolean var1) {
      this.afficheProduitAch = var1;
   }

   public boolean isAfficheProduitVte() {
      return this.afficheProduitVte;
   }

   public void setAfficheProduitVte(boolean var1) {
      this.afficheProduitVte = var1;
   }

   public String getNomTiers() {
      return this.nomTiers;
   }

   public void setNomTiers(String var1) {
      this.nomTiers = var1;
   }

   public String getDepot() {
      return this.depot;
   }

   public void setDepot(String var1) {
      this.depot = var1;
   }

   public String getFamille() {
      return this.famille;
   }

   public void setFamille(String var1) {
      this.famille = var1;
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

   public List getMesDepotItems() {
      return this.mesDepotItems;
   }

   public void setMesDepotItems(List var1) {
      this.mesDepotItems = var1;
   }

   public List getMesFamillesAchatsItems() {
      return this.mesFamillesAchatsItems;
   }

   public void setMesFamillesAchatsItems(List var1) {
      this.mesFamillesAchatsItems = var1;
   }

   public List getMesFamillesVentesItems() {
      return this.mesFamillesVentesItems;
   }

   public void setMesFamillesVentesItems(List var1) {
      this.mesFamillesVentesItems = var1;
   }

   public String getCaisse() {
      return this.caisse;
   }

   public void setCaisse(String var1) {
      this.caisse = var1;
   }

   public List getMesCaisseItems() {
      return this.mesCaisseItems;
   }

   public void setMesCaisseItems(List var1) {
      this.mesCaisseItems = var1;
   }

   public boolean isAfficheCaisse() {
      return this.afficheCaisse;
   }

   public void setAfficheCaisse(boolean var1) {
      this.afficheCaisse = var1;
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

   public Tiers getTiers() {
      return this.tiers;
   }

   public void setTiers(Tiers var1) {
      this.tiers = var1;
   }

   public DataModel getDatamodelProduits() {
      return this.datamodelProduits;
   }

   public void setDatamodelProduits(DataModel var1) {
      this.datamodelProduits = var1;
   }

   public Produits getProduits() {
      return this.produits;
   }

   public void setProduits(Produits var1) {
      this.produits = var1;
   }

   public boolean isShowModalPanelProduits() {
      return this.showModalPanelProduits;
   }

   public void setShowModalPanelProduits(boolean var1) {
      this.showModalPanelProduits = var1;
   }

   public boolean isAfficheProduitStk() {
      return this.afficheProduitStk;
   }

   public void setAfficheProduitStk(boolean var1) {
      this.afficheProduitStk = var1;
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

   public UtilPrint getUtilPrint() {
      return this.utilPrint;
   }

   public void setUtilPrint(UtilPrint var1) {
      this.utilPrint = var1;
   }

   public List getLesModelesAutorises() {
      return this.lesModelesAutorises;
   }

   public void setLesModelesAutorises(List var1) {
      this.lesModelesAutorises = var1;
   }

   public boolean isAfficheStatistique() {
      return this.afficheStatistique;
   }

   public void setAfficheStatistique(boolean var1) {
      this.afficheStatistique = var1;
   }

   public String getAction() {
      return this.action;
   }

   public void setAction(String var1) {
      this.action = var1;
   }

   public String getCentreInteret() {
      return this.centreInteret;
   }

   public void setCentreInteret(String var1) {
      this.centreInteret = var1;
   }

   public String getCompteRendu() {
      return this.compteRendu;
   }

   public void setCompteRendu(String var1) {
      this.compteRendu = var1;
   }

   public long getConseiller() {
      return this.conseiller;
   }

   public void setConseiller(long var1) {
      this.conseiller = var1;
   }

   public List getMesCentresInteretsItems() {
      return this.mesCentresInteretsItems;
   }

   public void setMesCentresInteretsItems(List var1) {
      this.mesCentresInteretsItems = var1;
   }

   public List getMesConseillersItems() {
      return this.mesConseillersItems;
   }

   public void setMesConseillersItems(List var1) {
      this.mesConseillersItems = var1;
   }

   public String getObservation() {
      return this.observation;
   }

   public void setObservation(String var1) {
      this.observation = var1;
   }

   public String getConclusion() {
      return this.conclusion;
   }

   public void setConclusion(String var1) {
      this.conclusion = var1;
   }

   public List getMesConclusionsItems() {
      return this.mesConclusionsItems;
   }

   public void setMesConclusionsItems(List var1) {
      this.mesConclusionsItems = var1;
   }

   public List getMesActionsItems() {
      return this.mesActionsItems;
   }

   public void setMesActionsItems(List var1) {
      this.mesActionsItems = var1;
   }
}
