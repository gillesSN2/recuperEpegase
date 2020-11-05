package com.epegase.forms.accueil;

import com.epegase.systeme.classe.AvoirEnteteVentes;
import com.epegase.systeme.classe.Contacts;
import com.epegase.systeme.classe.DevisEnteteVentes;
import com.epegase.systeme.classe.FactureEnteteVentes;
import com.epegase.systeme.classe.NoteDebitEnteteVentes;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.AvoirEnteteVentesDao;
import com.epegase.systeme.dao.ContactDao;
import com.epegase.systeme.dao.DevisEnteteVentesDao;
import com.epegase.systeme.dao.FactureEnteteVentesDao;
import com.epegase.systeme.dao.NoteDebitEnteteVentesDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.naming.NamingException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class FormEspaceClient implements Serializable {
   private int typeVente;
   private int var_action;
   private UtilInitHibernate utilInitHibernate;
   private Structure structureLog;
   private Users usersLog;
   private String baseLog;
   private String pageIndex;
   private String basePlanetePegase = "structure1";
   private Contacts contactsClient;
   private ContactDao contactDao;
   private Tiers TiersClient;
   private TiersDao tiersDao;
   private boolean accesEspaceClient;
   private String format = "PDF";
   private UtilPrint utilPrint;
   private boolean showModalPanelPrint = false;
   private DevisEnteteVentes devisEnteteVentes;
   private List lesDevisEntete;
   private transient DataModel dataModelDevisEntete;
   private DevisEnteteVentesDao devisEnteteVentesDao;
   private FactureEnteteVentes factureEnteteVentes;
   private static List lesFacturesEntete;
   private transient DataModel dataModelFacturesEntete;
   private FactureEnteteVentesDao factureEnteteVentesDao;
   private AvoirEnteteVentes avoirEnteteVentes;
   private List lesAvoirsEntete;
   private transient DataModel dataModelAvoirsEntete;
   private AvoirEnteteVentesDao avoirEnteteVentesDao;
   private NoteDebitEnteteVentes noteDebitEnteteVentes;
   private static List lesNoteDebitEntete;
   private transient DataModel dataModelNoteDebitEntete;
   private NoteDebitEnteteVentesDao noteDebitEnteteVentesDao;
   private double montantTtc;
   private double montantTtcElmt;
   private double montantReglement;
   private double montantReglementElmt;
   private double montantSolde;
   private double montantSoldeElmt;
   private double var_nb_ligne;
   private boolean showModalPanelPaiement = false;
   private String referenceFacture;
   private String commentaire;
   private String totalPayer;
   private String resultat;
   private static long idUser;
   private static String nomUser;
   private static String result;

   public FormEspaceClient() {
      this.lesDevisEntete = new ArrayList();
      this.dataModelDevisEntete = new ListDataModel();
      lesFacturesEntete = new ArrayList();
      this.dataModelFacturesEntete = new ListDataModel();
      this.lesAvoirsEntete = new ArrayList();
      this.dataModelAvoirsEntete = new ListDataModel();
      lesNoteDebitEntete = new ArrayList();
      this.dataModelNoteDebitEntete = new ListDataModel();
   }

   public FormEspaceClient(String var1) {
      this.resultat = var1;
   }

   public void InstancesDaoUtilses() {
      this.devisEnteteVentesDao = new DevisEnteteVentesDao(this.basePlanetePegase, this.utilInitHibernate);
      this.factureEnteteVentesDao = new FactureEnteteVentesDao(this.basePlanetePegase, this.utilInitHibernate);
      this.avoirEnteteVentesDao = new AvoirEnteteVentesDao(this.basePlanetePegase, this.utilInitHibernate);
      this.noteDebitEnteteVentesDao = new NoteDebitEnteteVentesDao(this.basePlanetePegase, this.utilInitHibernate);
      this.contactDao = new ContactDao(this.basePlanetePegase, this.utilInitHibernate);
      this.tiersDao = new TiersDao(this.basePlanetePegase, this.utilInitHibernate);
   }

   public void verifConnexion(Session var1) throws HibernateException, NamingException {
      this.accesEspaceClient = false;
      this.TiersClient = this.tiersDao.selectTierEspaceClient(this.structureLog.getStrid(), var1);
      if (this.TiersClient != null) {
         this.contactsClient = this.contactDao.selectContactsEspaceClient(this.usersLog.getUsrMail(), this.usersLog.getUsrPwEspaceClient(), var1);
         if (this.contactsClient != null) {
            this.accesEspaceClient = true;
         }
      }

   }

   public void rechercheElementStructure(Session var1) throws HibernateException, NamingException, ParseException {
      this.lesDevisEntete.clear();
      String var2 = "tiers.tieid=" + this.TiersClient.getTieid();
      this.lesDevisEntete = this.devisEnteteVentesDao.rechercheDevisRequete(var2, var1);
      this.dataModelDevisEntete.setWrappedData(this.lesDevisEntete);
      lesFacturesEntete.clear();
      var2 = "tiers.tieid=" + this.TiersClient.getTieid();
      lesFacturesEntete = this.factureEnteteVentesDao.rechercheFactureRequete(var2, var1);
      this.dataModelFacturesEntete.setWrappedData(lesFacturesEntete);
      this.lesAvoirsEntete.clear();
      var2 = "tiers.tieid=" + this.TiersClient.getTieid();
      lesNoteDebitEntete = this.noteDebitEnteteVentesDao.rechercheNoteDebitRequete(var2, var1);
      this.dataModelNoteDebitEntete.setWrappedData(lesNoteDebitEntete);
      this.lesAvoirsEntete.clear();
      var2 = "tiers.tieid=" + this.TiersClient.getTieid();
      this.lesAvoirsEntete = this.avoirEnteteVentesDao.rechercheAvoirRequete(var2, var1);
      this.dataModelAvoirsEntete.setWrappedData(this.lesAvoirsEntete);
      this.var_nb_ligne = 0.0D;
      this.montantTtc = 0.0D;
      this.montantTtcElmt = 0.0D;
      this.montantReglement = 0.0D;
      this.montantReglementElmt = 0.0D;
      this.montantSolde = 0.0D;
      this.montantSoldeElmt = 0.0D;
      int var3;
      if (lesFacturesEntete.size() != 0) {
         for(var3 = 0; var3 < lesFacturesEntete.size(); ++var3) {
            this.montantTtc += ((FactureEnteteVentes)lesFacturesEntete.get(var3)).getFacTotTtc();
            this.montantReglement += ((FactureEnteteVentes)lesFacturesEntete.get(var3)).getFacTotReglement();
         }
      }

      if (lesNoteDebitEntete.size() != 0) {
         for(var3 = 0; var3 < lesNoteDebitEntete.size(); ++var3) {
            this.montantTtc += ((NoteDebitEnteteVentes)lesNoteDebitEntete.get(var3)).getNdbTotTtc();
            this.montantReglement += ((NoteDebitEnteteVentes)lesNoteDebitEntete.get(var3)).getNdbTotReglement();
         }
      }

      this.var_nb_ligne = (double)(lesFacturesEntete.size() + lesNoteDebitEntete.size());
      this.montantSolde = this.montantTtc - this.montantReglement;
   }

   public void calculTotal() {
      this.montantTtcElmt = 0.0D;
      this.montantReglementElmt = 0.0D;
      this.montantSoldeElmt = 0.0D;
      this.referenceFacture = "";
      this.commentaire = "";
      if (lesFacturesEntete.size() != 0) {
         for(int var1 = 0; var1 < lesFacturesEntete.size(); ++var1) {
            this.montantTtcElmt += ((FactureEnteteVentes)lesFacturesEntete.get(var1)).getFacTotTtc();
            this.montantReglementElmt += ((FactureEnteteVentes)lesFacturesEntete.get(var1)).getFacTotReglement();
            this.referenceFacture = this.referenceFacture + " " + ((FactureEnteteVentes)lesFacturesEntete.get(var1)).getFacNum();
         }

         this.montantSoldeElmt = this.montantTtcElmt - this.montantReglementElmt;
      }

   }

   public void selectionLigneDevis() {
      if (this.dataModelDevisEntete.isRowAvailable()) {
         this.devisEnteteVentes = (DevisEnteteVentes)this.dataModelDevisEntete.getRowData();
      }

   }

   public void selectionLigneFacture() {
      if (this.dataModelFacturesEntete.isRowAvailable()) {
         this.factureEnteteVentes = (FactureEnteteVentes)this.dataModelFacturesEntete.getRowData();
      }

   }

   public void selectionLigneAvoir() {
      if (this.dataModelAvoirsEntete.isRowAvailable()) {
         this.avoirEnteteVentes = (AvoirEnteteVentes)this.dataModelAvoirsEntete.getRowData();
      }

   }

   public void ajouterPaiement() {
      if (this.montantSoldeElmt != 0.0D) {
         UtilNombre var1 = new UtilNombre();
         this.totalPayer = var1.beginSimple(this.montantSoldeElmt, "");
         idUser = this.usersLog.getUsrid();
         nomUser = this.usersLog.getUsrPatronyme();
         result = this.resultat;
         this.showModalPanelPaiement = true;
      }

   }

   public void fermerPaiement() {
      this.showModalPanelPaiement = false;
   }

   public void initImpression() {
      if (this.utilPrint == null) {
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
      }

      this.showModalPanelPrint = true;
   }

   public void closeImpression() {
      this.showModalPanelPrint = false;
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

   public JRBeanCollectionDataSource calculeImpressionCommun() throws IOException {
      ArrayList var1 = new ArrayList();
      var1.add((FactureEnteteVentes)lesFacturesEntete);
      JRBeanCollectionDataSource var2 = new JRBeanCollectionDataSource(var1);
      return var2;
   }

   public void imprimer() throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "entete" + File.separator + "PegTicketFiche";
      if (var1 != null && !var1.isEmpty()) {
         this.utilPrint.setjRBeanCollectionDataSource(this.calculeImpressionCommun());
         this.utilPrint.setRapport(var1);
         this.utilPrint.setEntete("Impression du ticket");
         this.utilPrint.setMontant_lettre("");
         this.utilPrint.setFormat(this.format);
         this.utilPrint.setBaseLog(this.baseLog);
         this.utilPrint.setStructureLog(this.structureLog);
         this.utilPrint.setUsersLog(this.usersLog);
         this.utilPrint.imprimeRapport();
      }

      this.var_action = 0;
   }

   public String getBaseLog() {
      return this.baseLog;
   }

   public void setBaseLog(String var1) {
      this.baseLog = var1;
   }

   public DataModel getDataModelDevisEntete() {
      return this.dataModelDevisEntete;
   }

   public void setDataModelDevisEntete(DataModel var1) {
      this.dataModelDevisEntete = var1;
   }

   public DataModel getDataModelFacturesEntete() {
      return this.dataModelFacturesEntete;
   }

   public void setDataModelFacturesEntete(DataModel var1) {
      this.dataModelFacturesEntete = var1;
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

   public UtilInitHibernate getUtilInitHibernate() {
      return this.utilInitHibernate;
   }

   public void setUtilInitHibernate(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
   }

   public boolean isShowModalPanelPrint() {
      return this.showModalPanelPrint;
   }

   public void setShowModalPanelPrint(boolean var1) {
      this.showModalPanelPrint = var1;
   }

   public boolean isAccesEspaceClient() {
      return this.accesEspaceClient;
   }

   public void setAccesEspaceClient(boolean var1) {
      this.accesEspaceClient = var1;
   }

   public DataModel getDataModelAvoirsEntete() {
      return this.dataModelAvoirsEntete;
   }

   public void setDataModelAvoirsEntete(DataModel var1) {
      this.dataModelAvoirsEntete = var1;
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

   public double getVar_nb_ligne() {
      return this.var_nb_ligne;
   }

   public void setVar_nb_ligne(double var1) {
      this.var_nb_ligne = var1;
   }

   public boolean isShowModalPanelPaiement() {
      return this.showModalPanelPaiement;
   }

   public void setShowModalPanelPaiement(boolean var1) {
      this.showModalPanelPaiement = var1;
   }

   public String getReferenceFacture() {
      return this.referenceFacture;
   }

   public void setReferenceFacture(String var1) {
      this.referenceFacture = var1;
   }

   public String getCommentaire() {
      return this.commentaire;
   }

   public void setCommentaire(String var1) {
      this.commentaire = var1;
   }

   public DataModel getDataModelNoteDebitEntete() {
      return this.dataModelNoteDebitEntete;
   }

   public void setDataModelNoteDebitEntete(DataModel var1) {
      this.dataModelNoteDebitEntete = var1;
   }

   public String getTotalPayer() {
      return this.totalPayer;
   }

   public void setTotalPayer(String var1) {
      this.totalPayer = var1;
   }

   public String getResultat() {
      return this.resultat;
   }

   public void setResultat(String var1) {
      this.resultat = var1;
   }

   public static List getLesFacturesEntete() {
      return lesFacturesEntete;
   }

   public static void setLesFacturesEntete(List var0) {
      lesFacturesEntete = var0;
   }

   public static List getLesNoteDebitEntete() {
      return lesNoteDebitEntete;
   }

   public static void setLesNoteDebitEntete(List var0) {
      lesNoteDebitEntete = var0;
   }

   public static long getIdUser() {
      return idUser;
   }

   public static void setIdUser(long var0) {
      idUser = var0;
   }

   public static String getNomUser() {
      return nomUser;
   }

   public static void setNomUser(String var0) {
      nomUser = var0;
   }

   public static String getResult() {
      return result;
   }

   public static void setResult(String var0) {
      result = var0;
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
}
