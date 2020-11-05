package com.epegase.forms.administration;

import com.epegase.systeme.classe.Conditionnement;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Unite;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.ConditionnementDao;
import com.epegase.systeme.dao.UniteDao;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FormConditionnement implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private boolean afficheButtModif;
   private boolean inactifModif;
   private int desactiveModif;
   private boolean showModalPanel;
   private List lesConditionnement;
   private transient DataModel madatamodel = new ListDataModel();
   private Conditionnement conditionnement;
   private ConditionnementDao conditionnementDao;
   private List mesUnites = new ArrayList();
   private Unite unite;
   private UniteDao uniteDao;
   private String var_unite1;
   private String var_unite2;
   private int var_code_unite;

   public void instanceDaoUtilises() {
      this.conditionnementDao = new ConditionnementDao(this.baseLog, this.utilInitHibernate);
      this.uniteDao = new UniteDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerConditionnement(Session var1) throws HibernateException, NamingException {
      this.lesConditionnement = this.conditionnementDao.selectAll(var1);
      this.madatamodel = new ListDataModel();
      this.madatamodel.setWrappedData(this.lesConditionnement);
   }

   public void chargerUnite(Session var1) throws HibernateException, NamingException {
      new ArrayList();
      List var2 = this.uniteDao.selectAll(var1);
      this.mesUnites = new ArrayList();
      this.mesUnites.add(new SelectItem(""));
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            String var4 = ((Unite)var2.get(var3)).getUniLibelle() + ":" + ((Unite)var2.get(var3)).getVar_lib_echelle();
            this.mesUnites.add(new SelectItem(var4));
         }
      }

   }

   public void selectionContitionnement() {
      if (this.madatamodel.isRowAvailable()) {
         this.conditionnement = (Conditionnement)this.getRowData();
         this.inactifModif = this.recupererInactifModif();
         if (this.conditionnement.getCdtCodeUnite1() != null && !this.conditionnement.getCdtCodeUnite1().isEmpty()) {
            this.var_unite1 = this.conditionnement.getCdtCodeUnite1() + ":" + this.conditionnement.getCdtUnite1();
         } else {
            this.var_unite1 = "";
         }

         if (this.conditionnement.getCdtCodeUnite2() != null && !this.conditionnement.getCdtCodeUnite2().isEmpty()) {
            this.var_unite2 = this.conditionnement.getCdtCodeUnite2() + ":" + this.conditionnement.getCdtUnite2();
         } else {
            this.var_unite2 = "";
         }

         int var1 = this.conditionnement.getCdtInactif();
         if (var1 != 2) {
            this.afficheButtModif = true;
         } else {
            this.afficheButtModif = false;
         }
      }

   }

   public void chargerPanAdd() {
      this.conditionnement = new Conditionnement();
      this.var_code_unite = 0;
      this.showModalPanel = true;
   }

   public void chargerPanAModif() throws HibernateException, NamingException {
      this.controleUnite();
      this.showModalPanel = true;
   }

   public void annule() {
      this.showModalPanel = false;
      this.afficheButtModif = false;
   }

   public void controleUnite() throws HibernateException, NamingException {
      if (this.var_unite2 != null && !this.var_unite2.isEmpty() && this.var_unite2.contains(":")) {
         String[] var1 = this.var_unite2.split(":");
         String var2 = var1[0];
         this.var_code_unite = this.uniteDao.selectUnite(var2, (Session)null).getUniEchelle();
      } else {
         this.var_code_unite = 0;
      }

   }

   public void saveUnite() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Unite");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         String[] var3;
         if (this.var_unite1 != null && !this.var_unite1.isEmpty() && this.var_unite1.contains(":")) {
            var3 = this.var_unite1.split(":");
            this.conditionnement.setCdtCodeUnite1(var3[0]);
            this.conditionnement.setCdtUnite1(var3[1]);
         } else {
            this.conditionnement.setCdtCodeUnite1("");
            this.conditionnement.setCdtUnite1("");
         }

         if (this.var_unite2 != null && !this.var_unite2.isEmpty() && this.var_unite2.contains(":")) {
            var3 = this.var_unite2.split(":");
            this.conditionnement.setCdtCodeUnite2(var3[0]);
            this.conditionnement.setCdtUnite2(var3[1]);
         } else {
            this.conditionnement.setCdtCodeUnite2("");
            this.conditionnement.setCdtUnite2("");
         }

         if (this.conditionnement.getCdtId() == 0L) {
            this.conditionnement.setCdtDateCreation(new Date());
            this.conditionnement.setCdtUserCreation(this.usersLog.getUsrid());
            this.conditionnement = this.conditionnementDao.insert(this.conditionnement, var1);
            this.lesConditionnement.add(this.conditionnement);
            this.madatamodel.setWrappedData(this.lesConditionnement);
         } else {
            this.conditionnement.setCdtDateModif(new Date());
            this.conditionnement.setCdtUserModif(this.usersLog.getUsrid());
            this.conditionnement = this.conditionnementDao.modif(this.conditionnement, var1);
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

      this.showModalPanel = false;
   }

   public void deleteUnite() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Unite");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.lesConditionnement.remove(this.conditionnement);
         this.madatamodel.setWrappedData(this.lesConditionnement);
         this.conditionnementDao.delete(this.conditionnement, var1);
         var2.commit();
      } catch (HibernateException var7) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var7;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.afficheButtModif = false;
   }

   public boolean recupererInactifModif() {
      return this.conditionnement.getCdtInactif() != 0;
   }

   public void reactiverUnite() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Unite");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.conditionnement.setCdtInactif(0);
         this.conditionnement = this.conditionnementDao.modif(this.conditionnement, var1);
         var2.commit();
      } catch (HibernateException var7) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var7;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.afficheButtModif = true;
   }

   public boolean isInactifModif() {
      return this.inactifModif;
   }

   public void setInactifModif(boolean var1) {
      this.inactifModif = var1;
   }

   public boolean isAfficheButtModif() {
      return this.afficheButtModif;
   }

   public void setAfficheButtModif(boolean var1) {
      this.afficheButtModif = var1;
   }

   public int getDesactiveModif() {
      if (!this.inactifModif) {
         this.desactiveModif = 0;
      } else {
         this.desactiveModif = 1;
      }

      return this.desactiveModif;
   }

   public void setDesactiveModif(int var1) {
      this.desactiveModif = var1;
   }

   public DataModel getMadatamodel() {
      return this.madatamodel;
   }

   public void setMadatamodel(DataModel var1) {
      this.madatamodel = var1;
   }

   public Object getRowData() {
      return this.madatamodel.getRowData();
   }

   public List getMesUnites() {
      return this.mesUnites;
   }

   public void setMesUnites(List var1) {
      this.mesUnites = var1;
   }

   public Conditionnement getConditionnement() {
      return this.conditionnement;
   }

   public void setConditionnement(Conditionnement var1) {
      this.conditionnement = var1;
   }

   public List getLesConditionnement() {
      return this.lesConditionnement;
   }

   public void setLesConditionnement(List var1) {
      this.lesConditionnement = var1;
   }

   public Unite getUnite() {
      return this.unite;
   }

   public void setUnite(Unite var1) {
      this.unite = var1;
   }

   public String getVar_unite1() {
      return this.var_unite1;
   }

   public void setVar_unite1(String var1) {
      this.var_unite1 = var1;
   }

   public String getVar_unite2() {
      return this.var_unite2;
   }

   public void setVar_unite2(String var1) {
      this.var_unite2 = var1;
   }

   public boolean isShowModalPanel() {
      return this.showModalPanel;
   }

   public void setShowModalPanel(boolean var1) {
      this.showModalPanel = var1;
   }

   public int getVar_code_unite() {
      return this.var_code_unite;
   }

   public void setVar_code_unite(int var1) {
      this.var_code_unite = var1;
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
