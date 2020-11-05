package com.epegase.forms.administration;

import com.epegase.systeme.classe.Caracteristique;
import com.epegase.systeme.classe.FamillesParc1;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.CaracteristiqueDao;
import com.epegase.systeme.dao.FamillesParc1Dao;
import com.epegase.systeme.dao.FamillesParc2Dao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilPrint;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.sql.SQLException;
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

public class FormCaracteristiquesParcs implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private FamillesParc1 famillesParc1 = new FamillesParc1();
   private FamillesParc1Dao famillesParc1Dao;
   private List lesFamilles = new ArrayList();
   private transient DataModel dataModelFamilles = new ListDataModel();
   private List mesSousFamillesItem = new ArrayList();
   private FamillesParc2Dao famillesParc2Dao;
   private String sousFamille;
   private Caracteristique caracteristique = new Caracteristique();
   private CaracteristiqueDao caracteristiqueDao;
   private List lesCaracteristiques = new ArrayList();
   private transient DataModel dataModelCaracteristiques = new ListDataModel();
   private boolean showModalPanelCaracteristique = false;
   private boolean afficheBoutonCaracteristique = false;
   private Caracteristique inventaire = new Caracteristique();
   private List lesInventaires = new ArrayList();
   private transient DataModel dataModelInventaires = new ListDataModel();
   private boolean showModalPanelInventaire = false;
   private boolean afficheBoutonInventaire = false;
   private String format;
   private UtilPrint utilPrint;

   public void InstancesDaoUtilses() {
      this.famillesParc1Dao = new FamillesParc1Dao(this.baseLog, this.utilInitHibernate);
      this.famillesParc2Dao = new FamillesParc2Dao(this.baseLog, this.utilInitHibernate);
      this.caracteristiqueDao = new CaracteristiqueDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerLesFamilles(Session var1) throws HibernateException, NamingException {
      this.lesFamilles = this.famillesParc1Dao.selectFamille(var1);
      this.dataModelFamilles.setWrappedData(this.lesFamilles);
   }

   public void selectionFamille() throws HibernateException, NamingException {
      this.lesCaracteristiques.clear();
      this.lesInventaires.clear();
      this.mesSousFamillesItem.clear();
      if (this.dataModelFamilles.isRowAvailable()) {
         this.famillesParc1 = (FamillesParc1)this.dataModelFamilles.getRowData();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FamilleParc");
         this.lesCaracteristiques = this.caracteristiqueDao.selectCaracteristiques(this.famillesParc1.getFamprc1Code(), "", var1);
         this.lesInventaires = this.caracteristiqueDao.selectInventaires(this.famillesParc1.getFamprc1Code(), "", var1);
         this.mesSousFamillesItem = this.famillesParc2Dao.chargerLesSousFamilles(this.famillesParc1, var1);
         this.utilInitHibernate.closeSession();
      }

      this.dataModelCaracteristiques.setWrappedData(this.lesCaracteristiques);
      this.dataModelInventaires.setWrappedData(this.lesInventaires);
      this.afficheBoutonCaracteristique = false;
      this.afficheBoutonInventaire = false;
   }

   public void selectionCaracteristique() {
      if (this.dataModelCaracteristiques.isRowAvailable()) {
         this.caracteristique = (Caracteristique)this.dataModelCaracteristiques.getRowData();
         this.afficheBoutonCaracteristique = true;
      }

   }

   public void ajouterCaracteristique() {
      if (this.famillesParc1 != null) {
         this.caracteristique = new Caracteristique();
         this.inventaire = new Caracteristique();
         this.showModalPanelCaracteristique = true;
      }

   }

   public void modifierCaracteristique() {
      if (this.caracteristique != null) {
         this.showModalPanelCaracteristique = true;
      }

   }

   public void supprimerCaracteristique() throws HibernateException, NamingException {
      if (this.caracteristique != null) {
         this.lesCaracteristiques.remove(this.caracteristique);
         this.dataModelCaracteristiques.setWrappedData(this.lesCaracteristiques);
         this.caracteristiqueDao.delete(this.caracteristique);
         this.afficheBoutonCaracteristique = false;
      }

   }

   public void annulerCaracteristique() {
      this.showModalPanelCaracteristique = false;
      this.afficheBoutonCaracteristique = false;
   }

   public void saveCaracteristique() throws HibernateException, NamingException {
      if (this.famillesParc1 != null) {
         this.caracteristique.setFamillesParc1(this.famillesParc1);
         this.caracteristique.setCarNature(this.famillesParc1.getFamprc1Nature());
         this.caracteristique.setCarLibNature(this.famillesParc1.getFamprc1LibNature());
         this.caracteristique.setCarFamille(this.famillesParc1.getFamprc1Code());
         this.caracteristique.setCarLibFamille(this.famillesParc1.getFamprc1LibelleFr());
         if (this.sousFamille.contains(":")) {
            String[] var1 = this.sousFamille.split(":");
            this.caracteristique.setCarSousFamille(var1[0]);
            this.caracteristique.setCarLibSousFamille(var1[1]);
         } else {
            this.caracteristique.setCarSousFamille("");
            this.caracteristique.setCarLibSousFamille("");
         }

         this.caracteristique.setCarType(0);
         if (this.caracteristique.getCarId() == 0L) {
            this.caracteristique.setCarDateCreat(new Date());
            this.caracteristique.setCarUserCreat(this.usersLog.getUsrid());
            this.caracteristique = this.caracteristiqueDao.insert(this.caracteristique);
            this.lesCaracteristiques.add(this.inventaire);
            this.dataModelCaracteristiques.setWrappedData(this.lesCaracteristiques);
         } else {
            this.caracteristique.setCarDateModif(new Date());
            this.caracteristique.setCarUserModif(this.usersLog.getUsrid());
            this.caracteristique = this.caracteristiqueDao.modif(this.caracteristique);
         }
      }

      this.showModalPanelCaracteristique = false;
      this.afficheBoutonCaracteristique = true;
   }

   public void selectionInventaire() {
      if (this.dataModelInventaires.isRowAvailable()) {
         this.inventaire = (Caracteristique)this.dataModelInventaires.getRowData();
         this.afficheBoutonInventaire = true;
      }

   }

   public void ajouterInventaire() {
      if (this.famillesParc1 != null) {
         this.inventaire = new Caracteristique();
         this.caracteristique = new Caracteristique();
         this.showModalPanelInventaire = true;
      }

   }

   public void modifierInventaire() {
      if (this.inventaire != null) {
         this.showModalPanelInventaire = true;
      }

   }

   public void supprimerInventaire() throws HibernateException, NamingException {
      if (this.inventaire != null) {
         this.lesInventaires.remove(this.inventaire);
         this.dataModelCaracteristiques.setWrappedData(this.lesInventaires);
         this.caracteristiqueDao.delete(this.inventaire);
         this.afficheBoutonInventaire = false;
      }

   }

   public void annulerInventaire() {
      this.showModalPanelInventaire = false;
      this.afficheBoutonInventaire = false;
   }

   public void saveInventaire() throws HibernateException, NamingException {
      if (this.famillesParc1 != null) {
         this.inventaire.setFamillesParc1(this.famillesParc1);
         this.inventaire.setCarNature(this.famillesParc1.getFamprc1Nature());
         this.inventaire.setCarLibNature(this.famillesParc1.getFamprc1LibNature());
         this.inventaire.setCarFamille(this.famillesParc1.getFamprc1Code());
         this.inventaire.setCarLibFamille(this.famillesParc1.getFamprc1LibelleFr());
         this.inventaire.setCarType(1);
         if (this.sousFamille.contains(":")) {
            String[] var1 = this.sousFamille.split(":");
            this.inventaire.setCarSousFamille(var1[0]);
            this.inventaire.setCarLibSousFamille(var1[1]);
         } else {
            this.inventaire.setCarSousFamille("");
            this.inventaire.setCarLibSousFamille("");
         }

         if (this.inventaire.getCarId() == 0L) {
            this.inventaire.setCarDateCreat(new Date());
            this.inventaire.setCarUserCreat(this.usersLog.getUsrid());
            this.inventaire = this.caracteristiqueDao.insert(this.inventaire);
            this.lesInventaires.add(this.inventaire);
            this.dataModelInventaires.setWrappedData(this.lesInventaires);
         } else {
            this.inventaire.setCarDateModif(new Date());
            this.inventaire.setCarUserModif(this.usersLog.getUsrid());
            this.inventaire = this.caracteristiqueDao.modif(this.inventaire);
         }
      }

      this.showModalPanelInventaire = false;
      this.afficheBoutonInventaire = true;
   }

   public void imprimerCarJRV() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "JRV";
      this.imprimerCar();
   }

   public void imprimerCarPDF() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "PDF";
      this.imprimerCar();
   }

   public void imprimerCarODT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "ODT";
      this.imprimerCar();
   }

   public void imprimerCarXLS() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "XLS";
      this.imprimerCar();
   }

   public void imprimerCarDOC() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "DOC";
      this.imprimerCar();
   }

   public void imprimerCarHTML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "HTML";
      this.imprimerCar();
   }

   public void imprimerCarXML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "XML";
      this.imprimerCar();
   }

   public void imprimerCar() throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.utilPrint.setRapport("ParcCaracteristique");
      this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "parc" + File.separator);
      this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "parc" + File.separator + "sous_rapport" + File.separator);
      this.utilPrint.setEntete("Caractéristiques des parcs");
      this.utilPrint.setFormat(this.getFormat());
      JRBeanCollectionDataSource var1 = new JRBeanCollectionDataSource(this.lesCaracteristiques);
      this.utilPrint.setjRBeanCollectionDataSource(var1);
      this.utilPrint.setBaseLog(this.baseLog);
      this.utilPrint.setStructureLog(this.structureLog);
      this.utilPrint.setUsersLog(this.usersLog);
      this.utilPrint.imprimeRapport();
   }

   public void imprimerInvJRV() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "JRV";
      this.imprimerInv();
   }

   public void imprimerInvPDF() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "PDF";
      this.imprimerInv();
   }

   public void imprimerInvODT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "ODT";
      this.imprimerInv();
   }

   public void imprimerInvXLS() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "XLS";
      this.imprimerInv();
   }

   public void imprimerInvDOC() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "DOC";
      this.imprimerInv();
   }

   public void imprimerInvHTML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "HTML";
      this.imprimerInv();
   }

   public void imprimerInvXML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "XML";
      this.imprimerInv();
   }

   public void imprimerInv() throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.utilPrint.setRapport("ParcInventaire");
      this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "parc" + File.separator);
      this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "parc" + File.separator + "sous_rapport" + File.separator);
      this.utilPrint.setEntete("Inventaire des parcs");
      this.utilPrint.setFormat(this.getFormat());
      JRBeanCollectionDataSource var1 = new JRBeanCollectionDataSource(this.lesInventaires);
      this.utilPrint.setjRBeanCollectionDataSource(var1);
      this.utilPrint.setBaseLog(this.baseLog);
      this.utilPrint.setStructureLog(this.structureLog);
      this.utilPrint.setUsersLog(this.usersLog);
      this.utilPrint.imprimeRapport();
   }

   public DataModel getDataModelCaracteristiques() {
      return this.dataModelCaracteristiques;
   }

   public void setDataModelCaracteristiques(DataModel var1) {
      this.dataModelCaracteristiques = var1;
   }

   public DataModel getDataModelFamilles() {
      return this.dataModelFamilles;
   }

   public void setDataModelFamilles(DataModel var1) {
      this.dataModelFamilles = var1;
   }

   public FamillesParc1 getFamillesParc1() {
      return this.famillesParc1;
   }

   public void setFamillesParc1(FamillesParc1 var1) {
      this.famillesParc1 = var1;
   }

   public List getLesFamilles() {
      return this.lesFamilles;
   }

   public void setLesFamilles(List var1) {
      this.lesFamilles = var1;
   }

   public boolean isAfficheBoutonInventaire() {
      return this.afficheBoutonInventaire;
   }

   public void setAfficheBoutonInventaire(boolean var1) {
      this.afficheBoutonInventaire = var1;
   }

   public DataModel getDataModelInventaires() {
      return this.dataModelInventaires;
   }

   public void setDataModelInventaires(DataModel var1) {
      this.dataModelInventaires = var1;
   }

   public Caracteristique getInventaire() {
      return this.inventaire;
   }

   public void setInventaire(Caracteristique var1) {
      this.inventaire = var1;
   }

   public List getLesInventaires() {
      return this.lesInventaires;
   }

   public void setLesInventaires(List var1) {
      this.lesInventaires = var1;
   }

   public List getMesSousFamillesItem() {
      return this.mesSousFamillesItem;
   }

   public void setMesSousFamillesItem(List var1) {
      this.mesSousFamillesItem = var1;
   }

   public boolean isShowModalPanelInventaire() {
      return this.showModalPanelInventaire;
   }

   public void setShowModalPanelInventaire(boolean var1) {
      this.showModalPanelInventaire = var1;
   }

   public Caracteristique getCaracteristique() {
      return this.caracteristique;
   }

   public void setCaracteristique(Caracteristique var1) {
      this.caracteristique = var1;
   }

   public List getLesCaracteristiques() {
      return this.lesCaracteristiques;
   }

   public void setLesCaracteristiques(List var1) {
      this.lesCaracteristiques = var1;
   }

   public boolean isShowModalPanelCaracteristique() {
      return this.showModalPanelCaracteristique;
   }

   public void setShowModalPanelCaracteristique(boolean var1) {
      this.showModalPanelCaracteristique = var1;
   }

   public boolean isAfficheBoutonCaracteristique() {
      return this.afficheBoutonCaracteristique;
   }

   public void setAfficheBoutonCaracteristique(boolean var1) {
      this.afficheBoutonCaracteristique = var1;
   }

   public String getSousFamille() {
      return this.sousFamille;
   }

   public void setSousFamille(String var1) {
      this.sousFamille = var1;
   }

   public String getFormat() {
      return this.format;
   }

   public void setFormat(String var1) {
      this.format = var1;
   }

   public UtilPrint getUtilPrint() {
      return this.utilPrint;
   }

   public void setUtilPrint(UtilPrint var1) {
      this.utilPrint = var1;
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

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }
}
