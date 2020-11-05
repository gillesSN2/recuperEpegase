package com.epegase.forms.administration;

import com.epegase.systeme.classe.CentreImpot;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.CentreImpotDao;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureCentresSecuriteSociale;
import com.epegase.systeme.xml.LectureImmatriculation;
import com.epegase.systeme.xml.ObjetCompte;
import com.epegase.systeme.xml.ObjetImmatriculation;
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
import org.xml.sax.SAXException;

public class FormCentresSecuriteSociale implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private LectureCentresSecuriteSociale lectureCentresSecuriteSociale;
   private List listeCentresImpots;
   private ObjetCompte objetCompte = new ObjetCompte();
   private transient DataModel dataModel = new ListDataModel();
   private List listeCentreBd = new ArrayList();
   private CentreImpotDao centreImpotDao;
   private CentreImpot centreImpot = new CentreImpot();
   private boolean visibiliteBton = false;
   private boolean showModalPanelCentre = false;
   private int largeurColonne;
   private LectureImmatriculation lectureImmatriculation;
   private ObjetImmatriculation objetImmatriculation;

   public FormCentresSecuriteSociale() throws IOException {
   }

   public void InstancesDaoUtilses() {
      this.centreImpotDao = new CentreImpotDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerLesCentresImpots() throws SAXException, IOException, HibernateException, NamingException {
      this.lectureImmatriculation = new LectureImmatriculation(this.structureLog.getStrcodepays(), "pmoral");
      this.lectureImmatriculation.recupereImmatriculation(this.structureLog.getStrcodepays(), "pmoral");
      this.objetImmatriculation = new ObjetImmatriculation();
      this.objetImmatriculation = this.lectureImmatriculation.getImmatriculation();
      if (this.structureLog.getStrNumSecuMultiple() == 1) {
         this.largeurColonne = 20;
         this.listeCentreBd = this.centreImpotDao.chargerCentreSecuriteSociale((Session)null);
      } else {
         this.largeurColonne = 90;
      }

      this.lectureCentresSecuriteSociale = new LectureCentresSecuriteSociale();
      this.lectureCentresSecuriteSociale.setStructureLog(this.structureLog);
      this.lectureCentresSecuriteSociale.recuperePaye();
      this.listeCentresImpots = new ArrayList();
      this.listeCentresImpots = this.lectureCentresSecuriteSociale.getMesCentresImpots();
      if (this.listeCentreBd.size() != 0 && this.listeCentresImpots.size() != 0) {
         for(int var1 = 0; var1 < this.listeCentreBd.size(); ++var1) {
            this.centreImpot = (CentreImpot)this.listeCentreBd.get(var1);

            for(int var2 = 0; var2 < this.listeCentresImpots.size(); ++var2) {
               this.objetCompte = (ObjetCompte)this.listeCentresImpots.get(var2);
               if (this.objetCompte.getCode() != null && !this.objetCompte.getCode().isEmpty() && this.centreImpot.getCenimpCode().equals(this.objetCompte.getCode())) {
                  this.objetCompte.setCentreId(this.centreImpot.getCenimpId());
                  this.objetCompte.setCentreAdresse(this.centreImpot.getCenimpAdresse());
                  this.objetCompte.setCentreBP(this.centreImpot.getCenimpBP());
                  this.objetCompte.setCentreFax(this.centreImpot.getCenimpFax());
                  this.objetCompte.setCentreMail(this.centreImpot.getCenimpMail());
                  this.objetCompte.setCentreNomResponsable(this.centreImpot.getCenimpNomResponsable());
                  this.objetCompte.setCentreNumeroImmatriculation(this.centreImpot.getCenimpNumeroImmatriculation());
                  this.objetCompte.setCentreTel1(this.centreImpot.getCenimpTel1());
                  this.objetCompte.setCentreTel2(this.centreImpot.getCenimpTel2());
                  break;
               }
            }
         }
      }

      this.dataModel.setWrappedData(this.listeCentresImpots);
   }

   public void selectionLigne() throws HibernateException, NamingException {
      if (this.dataModel.isRowAvailable()) {
         this.objetCompte = (ObjetCompte)this.dataModel.getRowData();
         this.centreImpot = this.centreImpotDao.rechercheEntreImpotByCode(this.objetCompte.getCode(), 1, (Session)null);
         if (this.centreImpot != null) {
            this.objetCompte.setCentreId(this.centreImpot.getCenimpId());
            this.objetCompte.setCentreAdresse(this.centreImpot.getCenimpAdresse());
            this.objetCompte.setCentreBP(this.centreImpot.getCenimpBP());
            this.objetCompte.setCentreVille(this.centreImpot.getCenimpVille());
            this.objetCompte.setCentreFax(this.centreImpot.getCenimpFax());
            this.objetCompte.setCentreMail(this.centreImpot.getCenimpMail());
            this.objetCompte.setCentreNomResponsable(this.centreImpot.getCenimpNomResponsable());
            this.objetCompte.setCentreNumeroImmatriculation(this.centreImpot.getCenimpNumeroImmatriculation());
            this.objetCompte.setCentreTel1(this.centreImpot.getCenimpTel1());
            this.objetCompte.setCentreTel2(this.centreImpot.getCenimpTel2());
         } else {
            this.objetCompte.setCentreId(0L);
            this.objetCompte.setCentreAdresse("");
            this.objetCompte.setCentreBP("");
            this.objetCompte.setCentreVille("");
            this.objetCompte.setCentreFax("");
            this.objetCompte.setCentreMail("");
            this.objetCompte.setCentreNomResponsable("");
            this.objetCompte.setCentreNumeroImmatriculation("");
            this.objetCompte.setCentreTel1("");
            this.objetCompte.setCentreTel2("");
         }

         this.visibiliteBton = true;
      }

   }

   public void modifierCentre() throws HibernateException, NamingException {
      if (this.objetCompte != null) {
         this.showModalPanelCentre = true;
      }

   }

   public void effacerCentre() throws HibernateException, NamingException {
      if (this.objetCompte != null) {
         this.centreImpot = this.centreImpotDao.rechercheEntreImpotByCode(this.objetCompte.getCode(), 1, (Session)null);
         if (this.centreImpot != null) {
            this.objetCompte.setCentreId(0L);
            this.objetCompte.setCentreAdresse((String)null);
            this.objetCompte.setCentreBP((String)null);
            this.objetCompte.setCentreVille((String)null);
            this.objetCompte.setCentreFax((String)null);
            this.objetCompte.setCentreMail((String)null);
            this.objetCompte.setCentreNomResponsable((String)null);
            this.objetCompte.setCentreNumeroImmatriculation((String)null);
            this.objetCompte.setCentreTel1((String)null);
            this.objetCompte.setCentreTel2((String)null);
            this.centreImpotDao.delete(this.centreImpot);
         } else {
            this.objetCompte.setCentreId(0L);
            this.objetCompte.setCentreAdresse((String)null);
            this.objetCompte.setCentreBP((String)null);
            this.objetCompte.setCentreVille((String)null);
            this.objetCompte.setCentreFax((String)null);
            this.objetCompte.setCentreMail((String)null);
            this.objetCompte.setCentreNomResponsable((String)null);
            this.objetCompte.setCentreNumeroImmatriculation((String)null);
            this.objetCompte.setCentreTel1((String)null);
            this.objetCompte.setCentreTel2((String)null);
         }
      }

      this.visibiliteBton = false;
   }

   public void fermerCentre() {
      this.showModalPanelCentre = false;
   }

   public void validerCentre() throws HibernateException, NamingException {
      if (this.objetCompte != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "CentreImpot");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.centreImpot = this.centreImpotDao.rechercheEntreImpotByCode(this.objetCompte.getCode(), 1, var1);
            if (this.centreImpot == null) {
               this.centreImpot = new CentreImpot();
               this.centreImpot.setCenimpCode(this.objetCompte.getCode());
               this.centreImpot.setCenimpNom(this.objetCompte.getNom_FR());
               this.centreImpot.setCenimpId(this.objetCompte.getCentreId());
               this.centreImpot.setCenimpAdresse(this.objetCompte.getCentreAdresse());
               this.centreImpot.setCenimpBP(this.objetCompte.getCentreBP());
               this.centreImpot.setCenimpVille(this.objetCompte.getCentreVille());
               this.centreImpot.setCenimpFax(this.objetCompte.getCentreFax());
               this.centreImpot.setCenimpMail(this.objetCompte.getCentreMail());
               this.centreImpot.setCenimpNomResponsable(this.objetCompte.getCentreNomResponsable());
               this.centreImpot.setCenimpNumeroImmatriculation(this.objetCompte.getCentreNumeroImmatriculation());
               this.centreImpot.setCenimpTel1(this.objetCompte.getCentreTel1());
               this.centreImpot.setCenimpTel2(this.objetCompte.getCentreTel2());
               this.centreImpot.setCenimpType(1);
               this.centreImpot = this.centreImpotDao.insert(this.centreImpot, var1);
            } else {
               this.centreImpot.setCenimpCode(this.objetCompte.getCode());
               this.centreImpot.setCenimpNom(this.objetCompte.getNom_FR());
               this.centreImpot.setCenimpId(this.objetCompte.getCentreId());
               this.centreImpot.setCenimpAdresse(this.objetCompte.getCentreAdresse());
               this.centreImpot.setCenimpBP(this.objetCompte.getCentreBP());
               this.centreImpot.setCenimpVille(this.objetCompte.getCentreVille());
               this.centreImpot.setCenimpFax(this.objetCompte.getCentreFax());
               this.centreImpot.setCenimpMail(this.objetCompte.getCentreMail());
               this.centreImpot.setCenimpNomResponsable(this.objetCompte.getCentreNomResponsable());
               this.centreImpot.setCenimpNumeroImmatriculation(this.objetCompte.getCentreNumeroImmatriculation());
               this.centreImpot.setCenimpTel1(this.objetCompte.getCentreTel1());
               this.centreImpot.setCenimpTel2(this.objetCompte.getCentreTel2());
               this.centreImpot.setCenimpType(1);
               this.centreImpot = this.centreImpotDao.modif(this.centreImpot, var1);
            }

            this.objetCompte.setCentreId(this.centreImpot.getCenimpId());
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

      this.showModalPanelCentre = false;
   }

   public DataModel getDataModel() {
      return this.dataModel;
   }

   public void setDataModel(DataModel var1) {
      this.dataModel = var1;
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

   public List getListeCentresImpots() {
      return this.listeCentresImpots;
   }

   public void setListeCentresImpots(List var1) {
      this.listeCentresImpots = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public boolean isVisibiliteBton() {
      return this.visibiliteBton;
   }

   public void setVisibiliteBton(boolean var1) {
      this.visibiliteBton = var1;
   }

   public ObjetCompte getObjetCompte() {
      return this.objetCompte;
   }

   public void setObjetCompte(ObjetCompte var1) {
      this.objetCompte = var1;
   }

   public boolean isShowModalPanelCentre() {
      return this.showModalPanelCentre;
   }

   public void setShowModalPanelCentre(boolean var1) {
      this.showModalPanelCentre = var1;
   }

   public int getLargeurColonne() {
      return this.largeurColonne;
   }

   public void setLargeurColonne(int var1) {
      this.largeurColonne = var1;
   }

   public ObjetImmatriculation getObjetImmatriculation() {
      return this.objetImmatriculation;
   }

   public void setObjetImmatriculation(ObjetImmatriculation var1) {
      this.objetImmatriculation = var1;
   }
}
