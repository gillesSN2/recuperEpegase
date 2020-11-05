package com.epegase.forms.administration;

import com.epegase.systeme.classe.MotifEntreeMedical;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.ExercicesVentesDao;
import com.epegase.systeme.dao.MotifEntreeMedicalDao;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FormMotifentreeConsultMedical implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private boolean afficheButtModif;
   private boolean inactifModif;
   private int desactiveModif;
   private boolean showPanAdd;
   private boolean showPanModif;
   private List lesMotifEntreeMedical;
   private transient DataModel madatamodel = new ListDataModel();
   private MotifEntreeMedical motifEntreeMedical;
   private MotifEntreeMedicalDao motifEntreeMedicalDao;
   private long exomedIdSelect;
   private boolean var_conGene;
   private boolean var_conSpe;
   private boolean var_lab;
   private boolean var_pha;
   private boolean var_hosp;
   private boolean var_convSoc;
   private boolean var_convAss;
   private boolean var_at;
   private boolean var_vaccin;
   private boolean var_audio;
   private boolean var_vme;
   private boolean var_vma;
   private boolean var_tubertest;
   private boolean infirmerie;

   public void instanceDaoUtilises() {
      this.motifEntreeMedicalDao = new MotifEntreeMedicalDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerMotifEntreeConsultMedical(Session var1) throws HibernateException, NamingException {
      this.infirmerie = this.rechercheModule(81500);
      this.lesMotifEntreeMedical = this.motifEntreeMedicalDao.selectMotifEntreeMedical(this.exomedIdSelect, var1);
      this.madatamodel = new ListDataModel();
      this.madatamodel.setWrappedData(this.lesMotifEntreeMedical);
   }

   public boolean rechercheModule(int var1) {
      boolean var2 = false;
      ArrayList var3 = new ArrayList();
      if (this.structureLog.getStrmod1() != null && !this.structureLog.getStrmod1().isEmpty()) {
         var3.add(this.structureLog.getStrmod1());
      }

      if (this.structureLog.getStrmod2() != null && !this.structureLog.getStrmod2().isEmpty()) {
         var3.add(this.structureLog.getStrmod2());
      }

      if (this.structureLog.getStrmod3() != null && !this.structureLog.getStrmod3().isEmpty()) {
         var3.add(this.structureLog.getStrmod3());
      }

      if (this.structureLog.getStrmod4() != null && !this.structureLog.getStrmod4().isEmpty()) {
         var3.add(this.structureLog.getStrmod4());
      }

      if (this.structureLog.getStrmod5() != null && !this.structureLog.getStrmod5().isEmpty()) {
         var3.add(this.structureLog.getStrmod5());
      }

      if (this.structureLog.getStrmod6() != null && !this.structureLog.getStrmod6().isEmpty()) {
         var3.add(this.structureLog.getStrmod6());
      }

      if (this.structureLog.getStrmod7() != null && !this.structureLog.getStrmod7().isEmpty()) {
         var3.add(this.structureLog.getStrmod7());
      }

      if (this.structureLog.getStrmod8() != null && !this.structureLog.getStrmod8().isEmpty()) {
         var3.add(this.structureLog.getStrmod8());
      }

      if (this.structureLog.getStrmod9() != null && !this.structureLog.getStrmod8().isEmpty()) {
         var3.add(this.structureLog.getStrmod9());
      }

      if (this.structureLog.getStrmod10() != null && !this.structureLog.getStrmod10().isEmpty()) {
         var3.add(this.structureLog.getStrmod10());
      }

      for(int var4 = 0; var4 < var3.size(); ++var4) {
         String var5 = "" + var1;
         if (var5.contentEquals((CharSequence)var3.get(var4))) {
            var2 = true;
         }
      }

      return var2;
   }

   public void confirmer() {
      if (this.madatamodel.isRowAvailable()) {
         this.motifEntreeMedical = (MotifEntreeMedical)this.getRowData();
         this.inactifModif = this.recupererInactifModif();
         if (this.motifEntreeMedical.getMteAT() == 1) {
            this.setVar_at(true);
         } else {
            this.setVar_at(false);
         }

         if (this.motifEntreeMedical.getMteVaccin() == 1) {
            this.setVar_vaccin(true);
         } else {
            this.setVar_vaccin(false);
         }

         if (this.motifEntreeMedical.getMteAudio() == 1) {
            this.setVar_audio(true);
         } else {
            this.setVar_audio(false);
         }

         if (this.motifEntreeMedical.getMteVme() == 1) {
            this.setVar_vme(true);
         } else {
            this.setVar_vme(false);
         }

         if (this.motifEntreeMedical.getMteVma() == 1) {
            this.setVar_vma(true);
         } else {
            this.setVar_vma(false);
         }

         if (this.motifEntreeMedical.getMteTubertest() == 1) {
            this.setVar_tubertest(true);
         } else {
            this.setVar_tubertest(false);
         }

         if (this.motifEntreeMedical.getMteConGene() == 1) {
            this.setVar_conGene(true);
         } else {
            this.setVar_conGene(false);
         }

         if (this.motifEntreeMedical.getMteConSpe() == 1) {
            this.setVar_conSpe(true);
         } else {
            this.setVar_conSpe(false);
         }

         if (this.motifEntreeMedical.getMteLab() == 1) {
            this.setVar_lab(true);
         } else {
            this.setVar_lab(false);
         }

         if (this.motifEntreeMedical.getMtePha() == 1) {
            this.setVar_pha(true);
         } else {
            this.setVar_pha(false);
         }

         if (this.motifEntreeMedical.getMteHosp() == 1) {
            this.setVar_hosp(true);
         } else {
            this.setVar_hosp(false);
         }

         if (this.motifEntreeMedical.getMteConv() == 1) {
            this.setVar_convSoc(true);
         } else {
            this.setVar_convSoc(false);
         }

         if (this.motifEntreeMedical.getMteConvAss() == 1) {
            this.setVar_convAss(true);
         } else {
            this.setVar_convAss(false);
         }

         int var1 = this.motifEntreeMedical.getMteInactif();
         if (var1 != 2) {
            this.afficheButtModif = true;
         } else {
            this.afficheButtModif = false;
         }
      }

   }

   public void chargerPanAdd() {
      this.motifEntreeMedical = new MotifEntreeMedical();
      this.showPanModif = false;
      this.showPanAdd = true;
      if (this.infirmerie) {
         this.var_conGene = true;
      } else {
         this.var_conGene = false;
      }

      this.var_at = false;
      this.var_vaccin = false;
      this.var_audio = false;
      this.var_vme = false;
      this.var_vma = false;
      this.var_tubertest = false;
   }

   public void chargerPanAModif() {
      this.showPanAdd = false;
      this.showPanModif = true;
   }

   public void saveMotifEntreeMedical() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "MotifEntreeMedical");
      ExercicesVentesDao var2 = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
      this.motifEntreeMedical.setExerciceventes(var2.recupererLExoSelect(this.exomedIdSelect, var1));
      Transaction var3 = null;

      try {
         var3 = var1.beginTransaction();
         this.motifEntreeMedical.setMteUserCreation(this.usersLog.getUsrid());
         this.motifEntreeMedical.setMteDateCreation(new Date());
         if (this.isVar_at()) {
            this.motifEntreeMedical.setMteAT(1);
         } else {
            this.motifEntreeMedical.setMteAT(0);
         }

         if (this.isVar_vaccin()) {
            this.motifEntreeMedical.setMteVaccin(1);
         } else {
            this.motifEntreeMedical.setMteVaccin(0);
         }

         if (this.isVar_audio()) {
            this.motifEntreeMedical.setMteAudio(1);
         } else {
            this.motifEntreeMedical.setMteAudio(0);
         }

         if (this.isVar_vme()) {
            this.motifEntreeMedical.setMteVme(1);
         } else {
            this.motifEntreeMedical.setMteVme(0);
         }

         if (this.isVar_vma()) {
            this.motifEntreeMedical.setMteVma(1);
         } else {
            this.motifEntreeMedical.setMteVma(0);
         }

         if (this.isVar_tubertest()) {
            this.motifEntreeMedical.setMteTubertest(1);
         } else {
            this.motifEntreeMedical.setMteTubertest(0);
         }

         if (this.infirmerie) {
            this.var_conGene = true;
         }

         if (this.isVar_conGene()) {
            this.motifEntreeMedical.setMteConGene(1);
         } else {
            this.motifEntreeMedical.setMteConGene(0);
         }

         if (this.isVar_conSpe()) {
            this.motifEntreeMedical.setMteConSpe(1);
         } else {
            this.motifEntreeMedical.setMteConSpe(0);
         }

         if (this.isVar_lab()) {
            this.motifEntreeMedical.setMteLab(1);
         } else {
            this.motifEntreeMedical.setMteLab(0);
         }

         if (this.isVar_pha()) {
            this.motifEntreeMedical.setMtePha(1);
         } else {
            this.motifEntreeMedical.setMtePha(0);
         }

         if (this.isVar_hosp()) {
            this.motifEntreeMedical.setMteHosp(1);
         } else {
            this.motifEntreeMedical.setMteHosp(0);
         }

         if (this.isVar_convSoc()) {
            this.motifEntreeMedical.setMteConv(1);
         } else {
            this.motifEntreeMedical.setMteConv(0);
         }

         if (this.isVar_convAss()) {
            this.motifEntreeMedical.setMteConvAss(1);
         } else {
            this.motifEntreeMedical.setMteConvAss(0);
         }

         this.motifEntreeMedical = this.motifEntreeMedicalDao.insert(this.motifEntreeMedical, var1);
         this.lesMotifEntreeMedical.add(this.motifEntreeMedical);
         this.madatamodel.setWrappedData(this.lesMotifEntreeMedical);
         var3.commit();
      } catch (HibernateException var8) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var8;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.setShowPanAdd(false);
      this.setShowPanModif(false);
   }

   public void upDateMotifEntreeMedical() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "MotifEntreeMedical");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.motifEntreeMedical.setMteUserModif(this.usersLog.getUsrid());
         this.motifEntreeMedical.setMteInactif(this.getDesactiveModif());
         if (this.isVar_at()) {
            this.motifEntreeMedical.setMteAT(1);
         } else {
            this.motifEntreeMedical.setMteAT(0);
         }

         if (this.isVar_vaccin()) {
            this.motifEntreeMedical.setMteVaccin(1);
         } else {
            this.motifEntreeMedical.setMteVaccin(0);
         }

         if (this.isVar_audio()) {
            this.motifEntreeMedical.setMteAudio(1);
         } else {
            this.motifEntreeMedical.setMteAudio(0);
         }

         if (this.isVar_vme()) {
            this.motifEntreeMedical.setMteVme(1);
         } else {
            this.motifEntreeMedical.setMteVme(0);
         }

         if (this.isVar_vma()) {
            this.motifEntreeMedical.setMteVma(1);
         } else {
            this.motifEntreeMedical.setMteVma(0);
         }

         if (this.isVar_tubertest()) {
            this.motifEntreeMedical.setMteTubertest(1);
         } else {
            this.motifEntreeMedical.setMteTubertest(0);
         }

         if (this.infirmerie) {
            this.var_conGene = true;
         }

         if (this.isVar_conGene()) {
            this.motifEntreeMedical.setMteConGene(1);
         } else {
            this.motifEntreeMedical.setMteConGene(0);
         }

         if (this.isVar_conSpe()) {
            this.motifEntreeMedical.setMteConSpe(1);
         } else {
            this.motifEntreeMedical.setMteConSpe(0);
         }

         if (this.isVar_lab()) {
            this.motifEntreeMedical.setMteLab(1);
         } else {
            this.motifEntreeMedical.setMteLab(0);
         }

         if (this.isVar_pha()) {
            this.motifEntreeMedical.setMtePha(1);
         } else {
            this.motifEntreeMedical.setMtePha(0);
         }

         if (this.isVar_hosp()) {
            this.motifEntreeMedical.setMteHosp(1);
         } else {
            this.motifEntreeMedical.setMteHosp(0);
         }

         if (this.isVar_convSoc()) {
            this.motifEntreeMedical.setMteConv(1);
         } else {
            this.motifEntreeMedical.setMteConv(0);
         }

         if (this.isVar_convAss()) {
            this.motifEntreeMedical.setMteConvAss(1);
         } else {
            this.motifEntreeMedical.setMteConvAss(0);
         }

         this.motifEntreeMedical = this.motifEntreeMedicalDao.modif(this.motifEntreeMedical, var1);
         var2.commit();
      } catch (HibernateException var7) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var7;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.setShowPanAdd(false);
      this.setShowPanModif(false);
   }

   public void deleteMotifEntreeMedical() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "MotifEntreeMedical");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.motifEntreeMedical.setMteInactif(2);
         this.motifEntreeMedical = this.motifEntreeMedicalDao.modif(this.motifEntreeMedical, var1);
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
      return this.motifEntreeMedical.getMteInactif() != 0;
   }

   public void reactiverMotifentreeMedical() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "MotifEntreeMedical");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.motifEntreeMedical.setMteInactif(0);
         this.motifEntreeMedical = this.motifEntreeMedicalDao.modif(this.motifEntreeMedical, var1);
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

   public boolean isShowPanAdd() {
      return this.showPanAdd;
   }

   public void setShowPanAdd(boolean var1) {
      this.showPanAdd = var1;
   }

   public boolean isShowPanModif() {
      return this.showPanModif;
   }

   public void setShowPanModif(boolean var1) {
      this.showPanModif = var1;
   }

   public Object getRowData() {
      return this.madatamodel.getRowData();
   }

   public List getLesMotifEntreeMedical() {
      return this.lesMotifEntreeMedical;
   }

   public void setLesMotifEntreeMedical(List var1) {
      this.lesMotifEntreeMedical = var1;
   }

   public MotifEntreeMedical getMotifEntreeMedical() {
      return this.motifEntreeMedical;
   }

   public void setMotifEntreeMedical(MotifEntreeMedical var1) {
      this.motifEntreeMedical = var1;
   }

   public long getExomedIdSelect() {
      return this.exomedIdSelect;
   }

   public void setExomedIdSelect(long var1) {
      this.exomedIdSelect = var1;
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

   public boolean isVar_at() {
      return this.var_at;
   }

   public void setVar_at(boolean var1) {
      this.var_at = var1;
   }

   public boolean isVar_conGene() {
      return this.var_conGene;
   }

   public void setVar_conGene(boolean var1) {
      this.var_conGene = var1;
   }

   public boolean isVar_conSpe() {
      return this.var_conSpe;
   }

   public void setVar_conSpe(boolean var1) {
      this.var_conSpe = var1;
   }

   public boolean isVar_hosp() {
      return this.var_hosp;
   }

   public void setVar_hosp(boolean var1) {
      this.var_hosp = var1;
   }

   public boolean isVar_lab() {
      return this.var_lab;
   }

   public void setVar_lab(boolean var1) {
      this.var_lab = var1;
   }

   public boolean isVar_pha() {
      return this.var_pha;
   }

   public void setVar_pha(boolean var1) {
      this.var_pha = var1;
   }

   public boolean isVar_vaccin() {
      return this.var_vaccin;
   }

   public void setVar_vaccin(boolean var1) {
      this.var_vaccin = var1;
   }

   public boolean isVar_audio() {
      return this.var_audio;
   }

   public void setVar_audio(boolean var1) {
      this.var_audio = var1;
   }

   public boolean isVar_tubertest() {
      return this.var_tubertest;
   }

   public void setVar_tubertest(boolean var1) {
      this.var_tubertest = var1;
   }

   public boolean isVar_vma() {
      return this.var_vma;
   }

   public void setVar_vma(boolean var1) {
      this.var_vma = var1;
   }

   public boolean isVar_vme() {
      return this.var_vme;
   }

   public void setVar_vme(boolean var1) {
      this.var_vme = var1;
   }

   public boolean isInfirmerie() {
      return this.infirmerie;
   }

   public void setInfirmerie(boolean var1) {
      this.infirmerie = var1;
   }

   public boolean isVar_convAss() {
      return this.var_convAss;
   }

   public void setVar_convAss(boolean var1) {
      this.var_convAss = var1;
   }

   public boolean isVar_convSoc() {
      return this.var_convSoc;
   }

   public void setVar_convSoc(boolean var1) {
      this.var_convSoc = var1;
   }
}
