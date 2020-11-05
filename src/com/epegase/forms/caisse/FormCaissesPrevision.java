package com.epegase.forms.caisse;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.CaissesPrevision;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesCaisse;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.dao.CaissesPrevisionDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.LectureTypeReglement;
import com.epegase.systeme.xml.ObjetCompte;
import com.epegase.systeme.xml.OptionCaisses;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
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

public class FormCaissesPrevision implements Serializable {
   private int typeVente;
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private FormRecherche formRecherche;
   private int var_action = 0;
   private int var_memo_action = 0;
   private String pageIndex;
   private int nature;
   private OptionCaisses optionCaisses;
   private ExercicesCaisse selectedExo;
   private ExercicesCaisse lastExo;
   private UtilNombre utilNombre = new UtilNombre();
   private UtilDate utilDate = new UtilDate();
   private List mesOnglets;
   private int var_nb_max = 100;
   private EspionDao espionDao;
   private int inpEtat = 0;
   private String periode;
   private CalculChrono calculChrono;
   private transient DataModel datamodelPrevision = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private List lesPrevisions = new ArrayList();
   private CaissesPrevisionDao caissesPrevisionDao;
   private CaissesPrevision caissesPrevision;
   private boolean visibiliteBton = false;
   private boolean var_affiche_valide = false;
   private LectureTypeReglement lectureTypeReglement;
   private List mesTypeReglement = new ArrayList();
   private boolean var_espece;
   private boolean var_cheque;
   private boolean var_virement;
   private boolean var_traite;
   private boolean var_tpe;
   private boolean var_transfert;
   private boolean var_epaiement;
   private boolean var_credoc;
   private boolean var_factor;
   private boolean var_compense;
   private boolean var_terme;
   private UsersChrono usersChrono = new UsersChrono();
   private UsersChronoDao usersChronoDao;
   private String format = "PDF";
   private int var_choix_modele = 0;
   private String nomModeleListe;
   private boolean visibleOptionMail = false;
   private UtilPrint utilPrint;
   private boolean affMail = false;
   private boolean affListeDoc = false;
   private String impEmetteur;
   private String impDestinataire;
   private String impDestinataireCC;
   private String impDestinataireCCI;
   private boolean showModalPanelPrint = false;

   public void InstancesDaoUtilses() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.caissesPrevisionDao = new CaissesPrevisionDao(this.baseLog, this.utilInitHibernate);
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
   }

   public void configCaisses(Session var1) throws HibernateException, NamingException {
      this.visibiliteBton = false;
      this.var_espece = false;
      this.var_cheque = false;
      this.var_virement = false;
      this.var_traite = false;
      this.var_tpe = false;
      this.var_transfert = false;
      this.var_epaiement = false;
      this.var_credoc = false;
      this.var_factor = false;
      this.var_compense = false;
      this.var_terme = false;
      this.lectureTypeReglement = new LectureTypeReglement(this.baseLog);
      this.mesTypeReglement = this.lectureTypeReglement.getMesTypeReglement();
      if (this.mesTypeReglement.size() != 0) {
         this.var_espece = ((ObjetCompte)this.mesTypeReglement.get(0)).isValide();
         this.var_cheque = ((ObjetCompte)this.mesTypeReglement.get(1)).isValide();
         this.var_virement = ((ObjetCompte)this.mesTypeReglement.get(2)).isValide();
         this.var_traite = ((ObjetCompte)this.mesTypeReglement.get(3)).isValide();
         this.var_tpe = ((ObjetCompte)this.mesTypeReglement.get(4)).isValide();
         this.var_transfert = ((ObjetCompte)this.mesTypeReglement.get(5)).isValide();
         this.var_epaiement = ((ObjetCompte)this.mesTypeReglement.get(6)).isValide();
         this.var_credoc = ((ObjetCompte)this.mesTypeReglement.get(7)).isValide();
         this.var_factor = ((ObjetCompte)this.mesTypeReglement.get(8)).isValide();
         this.var_compense = ((ObjetCompte)this.mesTypeReglement.get(9)).isValide();
         this.var_terme = ((ObjetCompte)this.mesTypeReglement.get(10)).isValide();
      }

   }

   public void accesResteintUser() throws HibernateException, NamingException {
      this.usersChrono = this.usersChronoDao.selectUnique((String)null, this.nature, this.usersLog, (Session)null);
   }

   public void accesResteintGroupe() {
   }

   public void razListe() {
      this.visibiliteBton = false;
      this.lesPrevisions.clear();
      this.datamodelPrevision.setWrappedData(this.lesPrevisions);
   }

   public void chargerFind() throws HibernateException, NamingException, ParseException {
      this.chargerFind((Session)null);
   }

   public void chargerFind(Session var1) throws HibernateException, NamingException, ParseException {
      this.lesPrevisions.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      Date var2 = null;
      Date var3 = null;
      Date var4 = new Date();
      Calendar var5 = Calendar.getInstance();
      UtilDate var6 = new UtilDate();
      String var7 = var6.dateToStringFr(var4);
      String var8 = var7.substring(6, 10) + "-" + var7.substring(3, 5) + "-" + var7.substring(0, 2);
      var2 = var6.stringToDateSQLLight(var8);
      var3 = var6.stringToDateSQLLight(var8);
      int var9 = var4.getYear() + 1900;
      if (this.periode != null && !this.periode.isEmpty()) {
         if (this.periode.equals("100")) {
            var2 = null;
            var3 = null;
         } else if (!this.periode.equals("0")) {
            String var10;
            if (this.periode.equals("1")) {
               var10 = "" + var5.getTime();
               if (var10.contains("Mon")) {
                  var2 = var5.getTime();
               } else if (var10.contains("Tue")) {
                  var5.add(7, -1);
                  var2 = var5.getTime();
               } else if (var10.contains("Wed")) {
                  var5.add(7, -2);
                  var2 = var5.getTime();
               } else if (var10.contains("Thu")) {
                  var5.add(7, -3);
                  var2 = var5.getTime();
               } else if (var10.contains("Fri")) {
                  var5.add(7, -4);
                  var2 = var5.getTime();
               } else if (var10.contains("Sat")) {
                  var5.add(7, -5);
                  var2 = var5.getTime();
               } else if (var10.contains("Sun")) {
                  var5.add(7, -6);
                  var2 = var5.getTime();
               }

               var7 = var6.dateToStringFr(var2);
               var8 = var7.substring(6, 10) + "-" + var7.substring(3, 5) + "-" + var7.substring(0, 2);
               var2 = var6.stringToDateSQLLight(var8);
            } else {
               String var11;
               int var12;
               if (this.periode.equals("2")) {
                  var12 = var5.get(2) + 1;
                  var11 = var9 + "-" + var12 + "-01";
                  var2 = var6.stringToDateSQLLight(var11);
               } else if (this.periode.equals("3")) {
                  var12 = var5.get(2);
                  var5.add(5, -var12);
                  if (var12 <= 3) {
                     var11 = var9 + "-01-01";
                     var2 = var6.stringToDateSQLLight(var11);
                  } else if (var12 >= 4 && var12 <= 6) {
                     var11 = var9 + "-04-01";
                     var2 = var6.stringToDateSQLLight(var11);
                  } else if (var12 >= 7 && var12 <= 9) {
                     var11 = var9 + "-07-01";
                     var2 = var6.stringToDateSQLLight(var11);
                  } else if (var12 >= 10) {
                     var11 = var9 + "-10-01";
                     var2 = var6.stringToDateSQLLight(var11);
                  }
               } else if (this.periode.equals("4")) {
                  var12 = var5.get(2);
                  var5.add(5, -var12);
                  if (var12 <= 6) {
                     var11 = var9 + "-01-01";
                     var2 = var6.stringToDateSQLLight(var11);
                  } else {
                     var11 = var9 + "-07-01";
                     var2 = var6.stringToDateSQLLight(var11);
                  }
               } else if (this.periode.equals("11")) {
                  var10 = var9 + "-01-01";
                  var2 = var6.stringToDateSQLLight(var10);
                  var11 = var9 + "-12-31";
                  var3 = var6.stringToDateSQLLight(var11);
               } else if (this.periode.equals("5")) {
                  var10 = var9 + "-01-01";
                  var2 = var6.stringToDateSQLLight(var10);
                  var11 = var9 + "-03-31";
                  var3 = var6.stringToDateSQLLight(var11);
               } else if (this.periode.equals("6")) {
                  var10 = var9 + "-04-01";
                  var2 = var6.stringToDateSQLLight(var10);
                  var11 = var9 + "-06-30";
                  var3 = var6.stringToDateSQLLight(var11);
               } else if (this.periode.equals("7")) {
                  var10 = var9 + "-07-01";
                  var2 = var6.stringToDateSQLLight(var10);
                  var11 = var9 + "-09-30";
                  var3 = var6.stringToDateSQLLight(var11);
               } else if (this.periode.equals("8")) {
                  var10 = var9 + "-10-01";
                  var2 = var6.stringToDateSQLLight(var10);
                  var11 = var9 + "-12-31";
                  var3 = var6.stringToDateSQLLight(var11);
               } else if (this.periode.equals("9")) {
                  var10 = var9 + "-01-01";
                  var2 = var6.stringToDateSQLLight(var10);
                  var11 = var9 + "-06-30";
                  var3 = var6.stringToDateSQLLight(var11);
               } else if (this.periode.equals("10")) {
                  var10 = var9 + "-07-01";
                  var2 = var6.stringToDateSQLLight(var10);
                  var11 = var9 + "-12-31";
                  var3 = var6.stringToDateSQLLight(var11);
               } else if (this.periode.equals("12")) {
                  var10 = "1980-01-01";
                  var2 = var6.stringToDateSQLLight(var10);
                  var11 = var9 - 1 + "-12-31";
                  var3 = var6.stringToDateSQLLight(var11);
               } else if (this.periode.equals("20")) {
               }
            }
         }
      }

      this.lesPrevisions = this.caissesPrevisionDao.listePrevision(this.inpEtat, var2, var3, var1);
      this.datamodelPrevision.setWrappedData(this.lesPrevisions);
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
            this.caissesPrevision = (CaissesPrevision)var1.get(0);
            this.visibiliteBton = true;
         } else {
            this.visibiliteBton = false;
         }
      } else {
         this.visibiliteBton = false;
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.caissesPrevision != null) {
         if (this.caissesPrevision.getCaipreEtat() == 0) {
            this.modifierPrevisionnel();
         } else {
            this.consulterPrevisionnel();
         }
      }

   }

   public void ajouterPrevisionnel() throws HibernateException, NamingException {
      this.caissesPrevision = new CaissesPrevision();
      this.var_action = 1;
      this.var_memo_action = this.var_action;
      this.var_affiche_valide = true;
   }

   public void modifierPrevisionnel() throws HibernateException, NamingException {
      if (this.caissesPrevision != null) {
         this.var_action = 2;
         this.var_memo_action = this.var_action;
         this.var_affiche_valide = true;
      }

   }

   public void consulterPrevisionnel() {
      if (this.caissesPrevision != null) {
         this.var_action = 3;
         this.var_memo_action = this.var_action;
         this.var_affiche_valide = false;
      }

   }

   public void valideDocument() throws HibernateException, NamingException {
      if (this.caissesPrevision != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "CaisseCommerciale");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.caissesPrevision.setCaipreEtat(1);
            this.caissesPrevision = this.caissesPrevisionDao.modif(this.caissesPrevision, var1);
            Espion var3 = new Espion();
            var3.setUsers(this.usersLog);
            var3.setEsptype(0);
            var3.setEspdtecreat(new Date());
            var3.setEspaction("Validation manuelle prévision caisse (T.) N° " + this.caissesPrevision.getCaipreId() + " du " + this.utilDate.dateToStringSQLLight(this.caissesPrevision.getCaipreDateDebut()));
            this.espionDao.mAJEspion(var3, var1);
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
      if (this.caissesPrevision != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "CaisseCommerciale");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.caissesPrevision.setCaipreEtat(0);
            this.caissesPrevision = this.caissesPrevisionDao.modif(this.caissesPrevision, var1);
            Espion var3 = new Espion();
            var3.setUsers(this.usersLog);
            var3.setEsptype(0);
            var3.setEspdtecreat(new Date());
            var3.setEspaction("Dévalidation manuelle prévision caisse (T.) N° " + this.caissesPrevision.getCaipreId() + " du " + this.utilDate.dateToStringSQLLight(this.caissesPrevision.getCaipreDateDebut()));
            this.espionDao.mAJEspion(var3, var1);
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

   public void supprimerPrevisionnel() throws HibernateException, NamingException {
      if (this.caissesPrevision != null) {
         this.caissesPrevisionDao.delete(this.caissesPrevision);
         this.lesPrevisions.remove(this.caissesPrevision);
         this.datamodelPrevision.setWrappedData(this.lesPrevisions);
      }

      this.visibiliteBton = false;
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
   }

   public void annulePrevision() {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.visibiliteBton = false;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public void savePrevision() throws HibernateException, NamingException, Exception {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "CaisseCommerciale");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.caissesPrevision.getCaipreDateDebut() == null) {
            this.caissesPrevision.setCaipreDateDebut(new Date());
         }

         if (this.caissesPrevision.getCaipreDateFin() == null) {
            this.caissesPrevision.setCaipreDateFin(this.caissesPrevision.getCaipreDateDebut());
         }

         this.caissesPrevision.setCaiprePeriode(this.formatPeriode(this.caissesPrevision.getCaipreDateDebut()));
         if (this.caissesPrevision.getCaipreId() == 0L) {
            this.caissesPrevision.setExercicesCaisse(this.lastExo);
            this.caissesPrevision.setCaipreUserIdCreation(this.usersLog.getUsrid());
            this.caissesPrevision.setCaipreDateCreation(new Date());
            this.caissesPrevision = this.caissesPrevisionDao.insert(this.caissesPrevision, var1);
            this.lesPrevisions.add(this.caissesPrevision);
            this.datamodelPrevision.setWrappedData(this.lesPrevisions);
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
         } else {
            this.caissesPrevision.setCaipreUserIdModif(this.usersLog.getUsrid());
            this.caissesPrevision.setCaipreDateModif(new Date());
            this.caissesPrevision = this.caissesPrevisionDao.modif(this.caissesPrevision, var1);
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

      this.var_action = 0;
      this.var_memo_action = this.var_action;
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

   public void initImpression() {
      if (this.utilPrint == null) {
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
      }

      this.var_choix_modele = 0;
      this.ListeDocImp();
      this.showModalPanelPrint = true;
   }

   public void closeImpression() {
      this.showModalPanelPrint = false;
   }

   public void OptionMail() {
      if (this.format.equalsIgnoreCase("MAIL")) {
         this.visibleOptionMail = true;
      } else {
         this.visibleOptionMail = false;
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

   public void ListeDocImp() {
      if (this.var_choix_modele == 0) {
         this.affListeDoc = false;
      } else {
         this.affListeDoc = true;
      }

   }

   public void imprimer() throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      if (this.nomModeleListe != null && !this.nomModeleListe.isEmpty()) {
         this.utilPrint.setRapport(this.nomModeleListe);
         this.utilPrint.setEntete("Impression de la liste des prévisions de trésorerie");
         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "liste" + File.separator + "previsionnel" + File.separator);
         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "sous_rapport" + File.separator);
         this.utilPrint.setFormat(this.format);
         this.utilPrint.setEmetteur(this.impEmetteur);
         this.utilPrint.setDestinataire(this.impDestinataire);
         this.utilPrint.setDestinataireCC(this.impDestinataireCC);
         this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
         this.utilPrint.setIdResponsable(0L);
         this.utilPrint.setTiersSelectionne((Tiers)null);
         this.utilPrint.setNature(this.nature);
         this.utilPrint.setId_doc(0L);
         JRBeanCollectionDataSource var1 = new JRBeanCollectionDataSource(this.lesPrevisions);
         this.utilPrint.setjRBeanCollectionDataSource(var1);
         this.utilPrint.setBaseLog(this.baseLog);
         this.utilPrint.setStructureLog(this.structureLog);
         this.utilPrint.setUsersLog(this.usersLog);
         this.utilPrint.imprimeRapport();
      }

   }

   public int getInpEtat() {
      return this.inpEtat;
   }

   public void setInpEtat(int var1) {
      this.inpEtat = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
   }

   public String getNomModeleListe() {
      return this.nomModeleListe;
   }

   public void setNomModeleListe(String var1) {
      this.nomModeleListe = var1;
   }

   public int getVar_action() {
      return this.var_action;
   }

   public void setVar_action(int var1) {
      this.var_action = var1;
   }

   public boolean isVisibiliteBton() {
      return this.visibiliteBton;
   }

   public void setVisibiliteBton(boolean var1) {
      this.visibiliteBton = var1;
   }

   public boolean isVar_affiche_valide() {
      return this.var_affiche_valide;
   }

   public void setVar_affiche_valide(boolean var1) {
      this.var_affiche_valide = var1;
   }

   public ExercicesCaisse getLastExo() {
      return this.lastExo;
   }

   public void setLastExo(ExercicesCaisse var1) {
      this.lastExo = var1;
   }

   public List getMesOnglets() {
      return this.mesOnglets;
   }

   public void setMesOnglets(List var1) {
      this.mesOnglets = var1;
   }

   public OptionCaisses getOptionCaisses() {
      return this.optionCaisses;
   }

   public void setOptionCaisses(OptionCaisses var1) {
      this.optionCaisses = var1;
   }

   public ExercicesCaisse getSelectedExo() {
      return this.selectedExo;
   }

   public void setSelectedExo(ExercicesCaisse var1) {
      this.selectedExo = var1;
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

   public boolean isVisibleOptionMail() {
      return this.visibleOptionMail;
   }

   public void setVisibleOptionMail(boolean var1) {
      this.visibleOptionMail = var1;
   }

   public int getVar_choix_modele() {
      return this.var_choix_modele;
   }

   public void setVar_choix_modele(int var1) {
      this.var_choix_modele = var1;
   }

   public UsersChrono getUsersChrono() {
      return this.usersChrono;
   }

   public void setUsersChrono(UsersChrono var1) {
      this.usersChrono = var1;
   }

   public int getVar_nb_max() {
      return this.var_nb_max;
   }

   public void setVar_nb_max(int var1) {
      this.var_nb_max = var1;
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

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public int getTypeVente() {
      return this.typeVente;
   }

   public void setTypeVente(int var1) {
      this.typeVente = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public CaissesPrevision getCaissesPrevision() {
      return this.caissesPrevision;
   }

   public void setCaissesPrevision(CaissesPrevision var1) {
      this.caissesPrevision = var1;
   }

   public DataModel getDatamodelPrevision() {
      return this.datamodelPrevision;
   }

   public void setDatamodelPrevision(DataModel var1) {
      this.datamodelPrevision = var1;
   }

   public String getPeriode() {
      return this.periode;
   }

   public void setPeriode(String var1) {
      this.periode = var1;
   }

   public LectureTypeReglement getLectureTypeReglement() {
      return this.lectureTypeReglement;
   }

   public void setLectureTypeReglement(LectureTypeReglement var1) {
      this.lectureTypeReglement = var1;
   }

   public boolean isVar_cheque() {
      return this.var_cheque;
   }

   public void setVar_cheque(boolean var1) {
      this.var_cheque = var1;
   }

   public boolean isVar_compense() {
      return this.var_compense;
   }

   public void setVar_compense(boolean var1) {
      this.var_compense = var1;
   }

   public boolean isVar_credoc() {
      return this.var_credoc;
   }

   public void setVar_credoc(boolean var1) {
      this.var_credoc = var1;
   }

   public boolean isVar_epaiement() {
      return this.var_epaiement;
   }

   public void setVar_epaiement(boolean var1) {
      this.var_epaiement = var1;
   }

   public boolean isVar_espece() {
      return this.var_espece;
   }

   public void setVar_espece(boolean var1) {
      this.var_espece = var1;
   }

   public boolean isVar_factor() {
      return this.var_factor;
   }

   public void setVar_factor(boolean var1) {
      this.var_factor = var1;
   }

   public boolean isVar_terme() {
      return this.var_terme;
   }

   public void setVar_terme(boolean var1) {
      this.var_terme = var1;
   }

   public boolean isVar_traite() {
      return this.var_traite;
   }

   public void setVar_traite(boolean var1) {
      this.var_traite = var1;
   }

   public boolean isVar_transfert() {
      return this.var_transfert;
   }

   public void setVar_transfert(boolean var1) {
      this.var_transfert = var1;
   }

   public boolean isVar_virement() {
      return this.var_virement;
   }

   public void setVar_virement(boolean var1) {
      this.var_virement = var1;
   }

   public boolean isVar_tpe() {
      return this.var_tpe;
   }

   public void setVar_tpe(boolean var1) {
      this.var_tpe = var1;
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
