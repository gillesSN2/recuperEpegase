package com.epegase.forms.administration;

import com.epegase.systeme.classe.DouanesPosition;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.DouanesPositionDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.ObjetFonction;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jdom.JDOMException;

public class FormDouanes implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private String lien;
   private UserDao userDao;
   private boolean codelibVide = false;
   private boolean existeCode = true;
   private boolean afficheAjDefaut;
   private List chapitreList = new ArrayList();
   private ObjetFonction fonction = new ObjetFonction();
   private transient DataModel datamodelChapitre = new ListDataModel();
   private List positionList = new ArrayList();
   private transient DataModel datamodelPosition = new ListDataModel();
   private DouanesPosition douanesPosition;
   private DouanesPosition douanesPositionMemo;
   private DouanesPositionDao douanesPositionDao;
   private boolean showmodelPanel = false;
   private boolean var_inactif = false;
   private boolean showModalPanelPosition = false;
   private boolean afficheBoutonChapitre = false;
   private boolean afficheBoutonPosition = false;
   private boolean showModalPanelListe = false;
   private transient DataModel dataModelListe = new ListDataModel();
   private boolean showModalPanelRecherche = false;
   private List recherchePoistionListe = new ArrayList();
   private transient DataModel dataModelRecherche = new ListDataModel();
   private String chaine;

   public void InstancesDaoUtilses() {
      this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.douanesPositionDao = new DouanesPositionDao(this.baseLog, this.utilInitHibernate);
   }

   public void lesChapitres(Session var1) throws HibernateException, NamingException {
      this.setLien(this.lien);
      new ArrayList();
      List var2 = this.douanesPositionDao.listeChapitre(this.structureLog.getStrzonecommerciale(), var1);
      this.chapitreList.clear();
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            this.fonction = new ObjetFonction();
            this.fonction.setCode(((DouanesPosition)var2.get(var3)).getDouposCodeChapitre());
            this.fonction.setNom_FR(((DouanesPosition)var2.get(var3)).getDouposChapitre());
            this.chapitreList.add(this.fonction);
         }
      }

      this.fonction = null;
      this.datamodelChapitre.setWrappedData(this.chapitreList);
      if (this.chapitreList.size() != 0) {
         this.afficheAjDefaut = false;
      } else {
         this.afficheAjDefaut = true;
      }

   }

   public void defaultAdd() throws JDOMException, IOException, HibernateException, NamingException {
      this.douanesPositionDao.ajoutParDefaut(this.structureLog.getStrzonecommerciale());
      this.lesChapitres((Session)null);
      this.afficheAjDefaut = false;
   }

   public void selectionChapitre() throws HibernateException, NamingException {
      if (this.datamodelChapitre.isRowAvailable()) {
         this.fonction = (ObjetFonction)this.datamodelChapitre.getRowData();
         this.positionList = this.douanesPositionDao.chargerLesPositions(this.structureLog.getStrzonecommerciale(), this.fonction.getCode(), (Session)null);
         this.datamodelPosition.setWrappedData(this.positionList);
         this.afficheBoutonChapitre = true;
         this.afficheBoutonPosition = false;
      }

   }

   public void selectionPosition() {
      if (this.datamodelPosition.isRowAvailable()) {
         this.douanesPosition = (DouanesPosition)this.datamodelPosition.getRowData();
         this.douanesPositionMemo = (DouanesPosition)this.datamodelPosition.getRowData();
         this.afficheBoutonPosition = true;
      }

   }

   public void selectionPositionSelection() {
      if (this.dataModelListe.isRowAvailable()) {
         this.douanesPosition = (DouanesPosition)this.dataModelListe.getRowData();
         this.douanesPositionMemo = (DouanesPosition)this.dataModelListe.getRowData();
         this.afficheBoutonPosition = true;
      }

   }

   public void miseAJour() throws HibernateException, NamingException {
      if (this.douanesPosition != null) {
         if (this.douanesPosition.getDouposUtil() == 0) {
            this.douanesPosition.setDouposUtil(1);
         } else {
            this.douanesPosition.setDouposUtil(0);
         }

         this.douanesPosition = this.douanesPositionDao.modif(this.douanesPosition);
      }

   }

   public void cocherLigne() throws HibernateException, NamingException {
      if (this.positionList.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DouanesPosition");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.positionList.size(); ++var3) {
               this.douanesPosition = (DouanesPosition)this.positionList.get(var3);
               this.douanesPosition.setDouposUtil(1);
               this.douanesPosition = this.douanesPositionDao.modif(this.douanesPosition, var1);
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
      }

   }

   public void deCocherLigne() throws HibernateException, NamingException {
      if (this.positionList.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DouanesPosition");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.positionList.size(); ++var3) {
               this.douanesPosition = (DouanesPosition)this.positionList.get(var3);
               this.douanesPosition.setDouposUtil(0);
               this.douanesPosition = this.douanesPositionDao.modif(this.douanesPosition, var1);
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
      }

   }

   public void deSelectionnerPosition() throws HibernateException, NamingException {
      this.positionList.clear();
      if (this.structureLog.getStrzonecommerciale() != null && !this.structureLog.getStrzonecommerciale().isEmpty()) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DouanesPosition");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            new ArrayList();
            List var3 = this.douanesPositionDao.recherchePosition(this.structureLog.getStrzonecommerciale(), "*", var1);
            if (var3.size() != 0) {
               for(int var4 = 0; var4 < var3.size(); ++var4) {
                  this.douanesPosition = (DouanesPosition)var3.get(var4);
                  this.douanesPosition.setDouposUtil(0);
                  this.douanesPosition = this.douanesPositionDao.modif(this.douanesPosition, var1);
               }

               var2.commit();
            }
         } catch (HibernateException var8) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var8;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void ajoutPosition() throws HibernateException, NamingException {
      if (this.fonction != null) {
         this.douanesPosition = new DouanesPosition();
         this.showModalPanelPosition = true;
      }

   }

   public void modificationPosition() throws HibernateException, NamingException {
      if (this.douanesPosition != null) {
         this.showModalPanelPosition = true;
      }

   }

   public void validePosition() throws HibernateException, NamingException {
      if (this.douanesPosition != null) {
         if (this.douanesPosition.getDouposId() == 0L) {
            this.douanesPosition.setDouposChapitre(this.douanesPositionMemo.getDouposChapitre());
            this.douanesPosition.setDouposCodeChapitre(this.douanesPositionMemo.getDouposCodeChapitre());
            this.douanesPosition.setDouposCodeSection(this.douanesPositionMemo.getDouposCodeSection());
            this.douanesPosition.setDouposSection(this.douanesPositionMemo.getDouposSection());
            this.douanesPosition.setDouposZone(this.douanesPositionMemo.getDouposZone());
            this.douanesPosition = this.douanesPositionDao.insert(this.douanesPosition);
            this.positionList.add(this.douanesPosition);
            this.datamodelPosition.setWrappedData(this.positionList);
         } else {
            this.douanesPosition = this.douanesPositionDao.modif(this.douanesPosition);
         }

         this.showModalPanelPosition = false;
      }

   }

   public void annulerPosition() throws HibernateException, NamingException {
      this.showModalPanelPosition = false;
   }

   public void listePosition() throws HibernateException, NamingException {
      new ArrayList();
      List var1 = this.douanesPositionDao.recherchePosition(this.structureLog.getStrzonecommerciale(), "*", (Session)null);
      this.dataModelListe.setWrappedData(var1);
      this.douanesPosition = null;
      this.showModalPanelListe = true;
      this.afficheBoutonPosition = false;
   }

   public void fermerListe() {
      this.showModalPanelListe = false;
   }

   public void recherchePosition() {
      this.chaine = "";
      this.recherchePoistionListe.clear();
      this.dataModelRecherche.setWrappedData(this.recherchePoistionListe);
      this.showModalPanelRecherche = true;
      this.afficheBoutonPosition = false;
   }

   public void rechercheCode() throws HibernateException, NamingException {
      this.afficheBoutonChapitre = false;
      this.afficheBoutonPosition = false;
      this.recherchePoistionListe.clear();
      if (this.chaine != null && !this.chaine.isEmpty()) {
         this.recherchePoistionListe = this.douanesPositionDao.rechercheChaine(this.structureLog.getStrzonecommerciale(), this.chaine, (Session)null);
      }

      this.dataModelRecherche.setWrappedData(this.recherchePoistionListe);
   }

   public void selectionCode() {
      if (this.dataModelRecherche.isRowAvailable()) {
         this.douanesPosition = (DouanesPosition)this.dataModelRecherche.getRowData();
         this.douanesPositionMemo = (DouanesPosition)this.dataModelRecherche.getRowData();
         this.afficheBoutonPosition = true;
      }

   }

   public void fermerRecherche() {
      this.showModalPanelRecherche = false;
   }

   public void recalculLibelleChapitre() throws HibernateException, NamingException {
      if (this.chapitreList.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DouanesPosition");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = "";
            this.douanesPositionMemo = new DouanesPosition();

            for(int var4 = 0; var4 < this.chapitreList.size(); ++var4) {
               this.fonction = (ObjetFonction)this.chapitreList.get(var4);
               if (this.fonction.getCode().length() <= 4) {
                  this.douanesPositionMemo = this.douanesPositionDao.trouverChapitre(this.structureLog.getStrzonecommerciale(), this.fonction.getCode(), var1);
                  if (this.douanesPositionMemo != null) {
                     var3 = this.douanesPositionMemo.getDouposLibFR();
                  }
               }

               this.positionList = this.douanesPositionDao.chargerLesPositions(this.structureLog.getStrzonecommerciale(), this.fonction.getCode(), var1);
               if (this.positionList.size() != 0) {
                  for(int var5 = 0; var5 < this.positionList.size(); ++var5) {
                     this.douanesPosition = (DouanesPosition)this.positionList.get(var5);
                     this.douanesPosition.setDouposChapitre(var3);
                     if (this.douanesPosition.getDouposCode().length() <= 4) {
                        this.douanesPosition.setDouposUtil(0);
                     } else {
                        this.douanesPosition.setDouposUtil(1);
                     }

                     this.douanesPosition = this.douanesPositionDao.modif(this.douanesPosition, var1);
                  }
               }
            }

            var2.commit();
         } catch (HibernateException var9) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var9;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.lesChapitres((Session)null);
   }

   public boolean isCodelibVide() {
      return this.codelibVide;
   }

   public void setCodelibVide(boolean var1) {
      this.codelibVide = var1;
   }

   public boolean isExisteCode() {
      return this.existeCode;
   }

   public void setExisteCode(boolean var1) {
      this.existeCode = var1;
   }

   public String getLien() {
      return this.lien;
   }

   public void setLien(String var1) {
      this.lien = var1;
   }

   public boolean isShowmodelPanel() {
      return this.showmodelPanel;
   }

   public void setShowmodelPanel(boolean var1) {
      this.showmodelPanel = var1;
   }

   public boolean isVar_inactif() {
      return this.var_inactif;
   }

   public void setVar_inactif(boolean var1) {
      this.var_inactif = var1;
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

   public DataModel getDatamodelChapitre() {
      return this.datamodelChapitre;
   }

   public void setDatamodelChapitre(DataModel var1) {
      this.datamodelChapitre = var1;
   }

   public DataModel getDatamodelPosition() {
      return this.datamodelPosition;
   }

   public void setDatamodelPosition(DataModel var1) {
      this.datamodelPosition = var1;
   }

   public boolean isShowModalPanelPosition() {
      return this.showModalPanelPosition;
   }

   public void setShowModalPanelPosition(boolean var1) {
      this.showModalPanelPosition = var1;
   }

   public DouanesPosition getDouanesPosition() {
      return this.douanesPosition;
   }

   public void setDouanesPosition(DouanesPosition var1) {
      this.douanesPosition = var1;
   }

   public List getPositionList() {
      return this.positionList;
   }

   public void setPositionList(List var1) {
      this.positionList = var1;
   }

   public DataModel getDataModelListe() {
      return this.dataModelListe;
   }

   public void setDataModelListe(DataModel var1) {
      this.dataModelListe = var1;
   }

   public boolean isShowModalPanelListe() {
      return this.showModalPanelListe;
   }

   public void setShowModalPanelListe(boolean var1) {
      this.showModalPanelListe = var1;
   }

   public DataModel getDataModelRecherche() {
      return this.dataModelRecherche;
   }

   public void setDataModelRecherche(DataModel var1) {
      this.dataModelRecherche = var1;
   }

   public boolean isShowModalPanelRecherche() {
      return this.showModalPanelRecherche;
   }

   public void setShowModalPanelRecherche(boolean var1) {
      this.showModalPanelRecherche = var1;
   }

   public String getChaine() {
      return this.chaine;
   }

   public void setChaine(String var1) {
      this.chaine = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public boolean isAfficheBoutonChapitre() {
      return this.afficheBoutonChapitre;
   }

   public void setAfficheBoutonChapitre(boolean var1) {
      this.afficheBoutonChapitre = var1;
   }

   public boolean isAfficheBoutonPosition() {
      return this.afficheBoutonPosition;
   }

   public void setAfficheBoutonPosition(boolean var1) {
      this.afficheBoutonPosition = var1;
   }

   public boolean isAfficheAjDefaut() {
      return this.afficheAjDefaut;
   }

   public void setAfficheAjDefaut(boolean var1) {
      this.afficheAjDefaut = var1;
   }
}
