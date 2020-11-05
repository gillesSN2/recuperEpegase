package com.epegase.forms.administration;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.Baremes;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.BaremesDao;
import com.epegase.systeme.dao.ExercicesVentesDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.OptionVentes;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.jdom.JDOMException;

public class FormCommissionsMedecins implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private int var_action;
   private int var_memo_action;
   private String pageIndex;
   private Baremes baremes = new Baremes();
   private BaremesDao baremesDao;
   private List baremesList = new ArrayList();
   private transient DataModel datamodelBaremes = new ListDataModel();
   private Users medecins;
   private UserDao userDao;
   private List medecinsList = new ArrayList();
   private transient DataModel datamodelMedecins = new ListDataModel();
   private boolean visibiliteBton = false;
   private boolean visibiliteMedecin = false;
   private String var_medecin;
   private boolean showModalPanelBaremes = false;
   private List mesFamilleVentestems = new ArrayList();
   private String var_famille_produit;
   private Produits produits = new Produits();
   private FormRecherche formRecherche;
   private boolean testRemise = false;

   public FormCommissionsMedecins() throws ParseException {
   }

   public void InstancesDaoUtilses() {
      this.baremesDao = new BaremesDao(this.baseLog, this.utilInitHibernate);
      this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
   }

   public void lesMedecins(Session var1) throws HibernateException, NamingException {
      this.medecinsList = this.userDao.chargerLesMedecins(var1);
      this.datamodelMedecins.setWrappedData(this.medecinsList);
      this.var_medecin = "";
   }

   public void lesFamillesProduits(Session var1) throws HibernateException, NamingException {
      this.mesFamilleVentestems.clear();
      FamillesProduitsVentesDao var2 = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
      new ExercicesVentes();
      ExercicesVentesDao var4 = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
      ExercicesVentes var3 = var4.recupererLastExo(var1);
      if (var3 != null) {
         this.mesFamilleVentestems = var2.chargerFamilleProduitActesItems(var3.getExevteId(), var1);
      }

   }

   public void lesBaremes(Session var1) throws HibernateException, NamingException {
      this.baremesList.clear();
      if (this.medecins != null) {
         this.baremesList = this.baremesDao.listBaremesByMedecins(this.medecins.getUsrid(), var1);
      }

      this.datamodelBaremes.setWrappedData(this.baremesList);
   }

   public void selectionMedecin() throws HibernateException, NamingException {
      if (this.datamodelMedecins.isRowAvailable()) {
         this.medecins = (Users)this.datamodelMedecins.getRowData();
         this.visibiliteMedecin = true;
         this.var_medecin = this.medecins.getUsrCivilite() + " " + this.medecins.getUsrPatronyme();
         this.lesBaremes((Session)null);
      }

   }

   public void selectionBareme() {
      if (this.datamodelBaremes.isRowAvailable()) {
         this.baremes = (Baremes)this.datamodelBaremes.getRowData();
         this.visibiliteBton = true;
      }

   }

   public void ajouterBareme() {
      if (this.medecins != null) {
         this.baremes = new Baremes();
         this.baremes.setBarType(2);
         this.var_action = 1;
         this.showModalPanelBaremes = true;
      }

   }

   public void modifierBareme() {
      if (this.baremes != null) {
         this.var_action = 2;
         this.showModalPanelBaremes = true;
      }

   }

   public void supprimerBareme() throws HibernateException, NamingException {
      if (this.baremes != null) {
         this.baremesDao.delete(this.baremes);
         this.baremesList.remove(this.baremes);
         this.datamodelBaremes.setWrappedData(this.baremesList);
         this.visibiliteBton = false;
      }

   }

   public void annuleBareme() {
      this.showModalPanelBaremes = false;
   }

   public void saveBareme() throws HibernateException, NamingException {
      if (this.medecins != null) {
         if (this.baremes.getBarType() == 4) {
            this.baremes.setBarLibelleProduit("Consultation");
            this.baremes.setBarCodeProduit("");
            this.baremes.setBarCodeVte("");
            this.baremes.setBarLibelleVte("");
            this.baremes.setBarPrix(0.0D);
            this.baremes.setBarRabais(0.0D);
         } else if (this.baremes.getBarType() == 5) {
            this.baremes.setBarLibelleProduit("Pharmacie");
            this.baremes.setBarCodeProduit("");
            this.baremes.setBarCodeVte("");
            this.baremes.setBarLibelleVte("");
            this.baremes.setBarPrix(0.0D);
            this.baremes.setBarRabais(0.0D);
         } else if (this.baremes.getBarType() == 6) {
            this.baremes.setBarLibelleProduit("Laboratoire");
            this.baremes.setBarCodeProduit("");
            this.baremes.setBarCodeVte("");
            this.baremes.setBarLibelleVte("");
            this.baremes.setBarPrix(0.0D);
            this.baremes.setBarRabais(0.0D);
         } else if (this.baremes.getBarType() == 7) {
            this.baremes.setBarLibelleProduit("Hospitalisation");
            this.baremes.setBarCodeProduit("");
            this.baremes.setBarCodeVte("");
            this.baremes.setBarLibelleVte("");
            this.baremes.setBarPrix(0.0D);
            this.baremes.setBarRabais(0.0D);
         } else if (this.baremes.getBarType() == 8) {
            this.baremes.setBarLibelleProduit("Actes Prives (CASH)");
            this.baremes.setBarCodeProduit("");
            this.baremes.setBarCodeVte("");
            this.baremes.setBarLibelleVte("");
            this.baremes.setBarPrix(0.0D);
            this.baremes.setBarRabais(0.0D);
         } else if (this.baremes.getBarType() == 9) {
            this.baremes.setBarLibelleProduit("Actes Pris en charge (Tiers payeurs)");
            this.baremes.setBarCodeProduit("");
            this.baremes.setBarCodeVte("");
            this.baremes.setBarLibelleVte("");
            this.baremes.setBarPrix(0.0D);
            this.baremes.setBarRabais(0.0D);
         } else {
            this.baremes.setBarCodeProduit(this.produits.getProCode());
            this.baremes.setBarCodeVte(this.produits.getProVteCode());
            this.baremes.setBarLibelleProduit(this.produits.getProLibClient());
            this.baremes.setBarLibelleVte(this.produits.getProVteLib());
         }

         if (this.baremes.getBarId() == 0L) {
            this.baremes.setBarDateCreat(new Date());
            this.baremes.setBarUserCreat(this.usersLog.getUsrid());
            this.baremes.setBarIdMedecin(this.medecins.getUsrid());
            this.baremes.setBarNomTiers(this.medecins.getUsrPatronyme());
            this.baremes = this.baremesDao.insert(this.baremes);
            this.baremesList.add(this.baremes);
            this.datamodelBaremes.setWrappedData(this.baremesList);
         } else {
            this.baremes.setBarDateModif(new Date());
            this.baremes.setBarUserModif(this.usersLog.getUsrid());
            this.baremes = this.baremesDao.modif(this.baremes);
         }
      }

      this.showModalPanelBaremes = false;
   }

   public void rechercheProduits() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.baremes.getBarCodeProduit() != null && !this.baremes.getBarCodeProduit().isEmpty()) {
         this.produits = this.formRecherche.rechercheProduitVente(this.baremes.getBarCodeProduit(), 2, (OptionVentes)null);
         if (this.produits != null) {
            if (this.produits.getProId() != 0L) {
               this.calculeProduits();
            } else {
               this.var_action = 15;
            }
         } else if (this.produits == null) {
            this.calculeProduits();
         }
      }

   }

   public void recuperationProduit() throws JDOMException, IOException, HibernateException, NamingException {
      this.produits = this.formRecherche.calculeProduit();
      this.calculeProduits();
   }

   public void calculeProduits() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.produits != null) {
         this.baremes.setBarCodeProduit(this.produits.getProCode());
         this.baremes.setBarLibelleProduit(this.produits.getProLibClient());
      } else {
         this.annuleProduits();
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleProduits() {
      this.produits = null;
      this.baremes.setBarCodeProduit("");
      this.baremes.setBarLibelleProduit("");
      this.var_action = this.var_memo_action;
   }

   public boolean isVisibiliteBton() {
      return this.visibiliteBton;
   }

   public void setVisibiliteBton(boolean var1) {
      this.visibiliteBton = var1;
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

   public Baremes getBaremes() {
      return this.baremes;
   }

   public void setBaremes(Baremes var1) {
      this.baremes = var1;
   }

   public DataModel getDatamodelBaremes() {
      return this.datamodelBaremes;
   }

   public void setDatamodelBaremes(DataModel var1) {
      this.datamodelBaremes = var1;
   }

   public DataModel getDatamodelMedecins() {
      return this.datamodelMedecins;
   }

   public void setDatamodelMedecins(DataModel var1) {
      this.datamodelMedecins = var1;
   }

   public Users getMedecins() {
      return this.medecins;
   }

   public void setMedecins(Users var1) {
      this.medecins = var1;
   }

   public boolean isShowModalPanelBaremes() {
      return this.showModalPanelBaremes;
   }

   public void setShowModalPanelBaremes(boolean var1) {
      this.showModalPanelBaremes = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public List getMesFamilleVentestems() {
      return this.mesFamilleVentestems;
   }

   public void setMesFamilleVentestems(List var1) {
      this.mesFamilleVentestems = var1;
   }

   public Produits getProduits() {
      return this.produits;
   }

   public void setProduits(Produits var1) {
      this.produits = var1;
   }

   public boolean isVisibiliteMedecin() {
      return this.visibiliteMedecin;
   }

   public void setVisibiliteMedecin(boolean var1) {
      this.visibiliteMedecin = var1;
   }

   public boolean isTestRemise() {
      return this.testRemise;
   }

   public void setTestRemise(boolean var1) {
      this.testRemise = var1;
   }

   public String getVar_famille_produit() {
      return this.var_famille_produit;
   }

   public void setVar_famille_produit(String var1) {
      this.var_famille_produit = var1;
   }

   public int getVar_action() {
      return this.var_action;
   }

   public void setVar_action(int var1) {
      this.var_action = var1;
   }

   public List getBaremesList() {
      return this.baremesList;
   }

   public void setBaremesList(List var1) {
      this.baremesList = var1;
   }

   public String getVar_medecin() {
      return this.var_medecin;
   }

   public void setVar_medecin(String var1) {
      this.var_medecin = var1;
   }
}
