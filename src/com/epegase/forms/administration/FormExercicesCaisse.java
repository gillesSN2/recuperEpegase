package com.epegase.forms.administration;

import com.epegase.systeme.classe.CaissesCommerciales;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.ExercicesCaisse;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.CaissesCommercialesDao;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.ExercicesCaisseDao;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jdom.JDOMException;
import org.xml.sax.SAXException;

public class FormExercicesCaisse implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private transient DataModel madatamodel = new ListDataModel();
   private ExercicesCaisse exercicesCaisse = new ExercicesCaisse();
   private ExercicesCaisse exercicesNew;
   private List lesexercicesCaisse = new ArrayList();
   private boolean testDateAj = true;
   private boolean noExo = false;
   private ExercicesCaisseDao exoDao;
   private long leIdExo = 0L;
   private boolean disable;
   private List listExo = new ArrayList();
   private Date datecloture;
   private Date memoDateFin;

   public FormExercicesCaisse() throws IOException, JDOMException {
   }

   public void InstancesDaoUtilses() {
      this.exoDao = new ExercicesCaisseDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerLesExo() throws HibernateException, NamingException {
      this.lesexercicesCaisse = this.recupererLesexercices((Session)null);
      this.madatamodel.setWrappedData(this.lesexercicesCaisse);
   }

   public ExercicesCaisse recupererLastExo(Session var1) throws HibernateException, NamingException {
      ExercicesCaisse var2 = this.exoDao.recupererLastExo(var1);
      return var2;
   }



   public List recupererLesexercices(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         var2 = true;
      }

      new ArrayList();
      List var3 = this.exoDao.selectExercicesCaisse(var1);
      this.listExo = new ArrayList();
      if (var3.size() == 0) {
         this.noExo = true;
      } else {
         this.noExo = false;

         for(int var4 = 0; var4 < var3.size(); ++var4) {
            ExercicesCaisse var5 = (ExercicesCaisse)var3.get(var4);
            var5.setIndice(var4 + 1);
            String var6 = "dd-MM-yyyy";
            SimpleDateFormat var7 = new SimpleDateFormat(var6, Locale.FRANCE);
            String var8 = var7.format(var5.getExecaiDateDebut());
            String var9 = var7.format(var5.getExecaiDateFin());
            long var10 = var5.getExecaiId();
            this.listExo.add(new SelectItem(var10, var8 + "...................." + var9));
         }
      }

      this.setLesexercicesCaisse(var3);
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public String enregistrerexercicesCaisse() throws IOException, JDOMException, SAXException, HibernateException, NamingException {
      Date var1 = this.exercicesCaisse.getExecaiDateDebut();
      Date var2 = this.exercicesCaisse.getExecaiDateFin();
      if (var1.after(var2)) {
         this.testDateAj = false;
      } else {
         this.testDateAj = true;
         int var3 = var1.getYear() + 1900;
         this.exercicesCaisse.setExecaiId((long)var3);
         this.exercicesCaisse.setExecaiUserCreat(this.usersLog.getUsrid());
         this.exercicesCaisse.setExecaiUserModif(0L);
         this.exercicesCaisse.setExecaiDateCreat(new Date());
         this.exercicesCaisse.setExecaiDateModif((Date)null);
         Object var4 = new ArrayList();
         if (this.madatamodel.getRowCount() > 0) {
            var4 = (List)this.madatamodel.getWrappedData();
         }

         int var5 = this.madatamodel.getRowCount() + 2;
         this.exercicesCaisse.setIndice(var5);
         ((List)var4).add(this.exercicesCaisse);
         this.madatamodel.setWrappedData(var4);
         Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         Transaction var7 = null;

         try {
            var7 = var6.beginTransaction();
            this.exercicesCaisse = this.exoDao.insert(this.exercicesCaisse, var6);
            this.lesexercicesCaisse.add(this.exercicesCaisse);
            this.madatamodel.setWrappedData(this.lesexercicesCaisse);
            var7.commit();
         } catch (HibernateException var12) {
            if (var7 != null) {
               var7.rollback();
            }

            throw var12;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.noExo = false;
      }

      return "";
   }

   public void selectionLigneExercice() {
      if (this.madatamodel.isRowAvailable()) {
         this.exercicesCaisse = (ExercicesCaisse)this.madatamodel.getRowData();
         this.memoDateFin = this.exercicesCaisse.getExecaiDateFin();
      }

   }

   public void chargerDate() throws ParseException {
      this.exercicesCaisse.setExecaiDateDebut(this.debutinitial());
      this.exercicesCaisse.setExecaiDateFin(this.finalinitial());
   }

   public Date debutinitial() throws ParseException {
      Date var1 = new Date();
      int var2 = var1.getYear() + 1900;
      String var3 = "01-01-" + var2;
      UtilDate var4 = new UtilDate();
      Date var5 = var4.stringToDateFr(var3);
      return var5;
   }

   public Date finalinitial() throws ParseException {
      Date var1 = new Date();
      int var2 = var1.getYear() + 1900;
      String var3 = "31-12-" + var2;
      UtilDate var4 = new UtilDate();
      Date var5 = var4.stringToDateFr(var3);
      return var5;
   }

   public void modifier() throws HibernateException, NamingException, ParseException {
      String var1 = "dd-MM-yyyy";
      SimpleDateFormat var2 = new SimpleDateFormat(var1, Locale.FRANCE);
      String var3 = var2.format(this.exercicesCaisse.getExecaiDateDebut());
      Date var4 = var2.parse(var3);
      String var5 = var2.format(this.exercicesCaisse.getExecaiDateFin());
      Date var6 = var2.parse(var5);
      if (!var4.after(var6)) {
         Session var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         Transaction var8 = null;

         try {
            var8 = var7.beginTransaction();
            this.exercicesCaisse.setExecaiUserModif(this.usersLog.getUsrid());
            this.exercicesCaisse.setExecaiDateModif(new Date());
            this.exercicesCaisse = this.exoDao.modif(this.exercicesCaisse, var7);
            if (this.exercicesCaisse.getExecaiDateFin().getYear() + 1900 != this.memoDateFin.getYear() + 1900) {
               new ArrayList();
               ChronoDao var10 = new ChronoDao(this.baseLog, this.utilInitHibernate);
               List var9 = var10.selectListCaisses(0, var7);
               if (var9.size() != 0) {
                  new Chrono();

                  for(int var12 = 0; var12 < var9.size(); ++var12) {
                     Chrono var11 = (Chrono)var9.get(var12);
                     if (var11.getChrPeriode() != null && !var11.getChrPeriode().isEmpty()) {
                        String var13 = "" + (this.memoDateFin.getYear() + 1900);
                        if (var11.getChrPeriode().equals(var13)) {
                           Chrono var14 = new Chrono();
                           var14.setChrPeriode("" + (this.exercicesCaisse.getExecaiDateFin().getYear() + 1900));
                           var14.setChrFormat(var11.getChrFormat());
                           var14.setChrJournal(var11.getChrJournal());
                           var14.setChrMode(var11.getChrMode());
                           var14.setChrNature(var11.getChrNature());
                           var14.setChrNbCar(var11.getChrNbCar());
                           var14.setChrNom(var11.getChrNom());
                           var14.setChrPrefixe(var11.getChrPrefixe());
                           var14.setChrPrefixe_1(var11.getChrPrefixe_1());
                           var14.setChrPrefixe_2(var11.getChrPrefixe_2());
                           var14.setChrPrefixe_3(var11.getChrPrefixe_3());
                           var14.setChrPrefixe_4(var11.getChrPrefixe_4());
                           var14.setChrPrefixe_5(var11.getChrPrefixe_5());
                           var14.setChrPrefixe_6(var11.getChrPrefixe_6());
                           var14.setChrPrefixe_7(var11.getChrPrefixe_7());
                           var14.setChrPrefixe_8(var11.getChrPrefixe_8());
                           var14.setChrPrefixe_9(var11.getChrPrefixe_9());
                           var14.setChrPrefixe_A(var11.getChrPrefixe_A());
                           var14.setChrPrive(var11.getChrPrive());
                           var14.setChrSerie(var11.getChrSerie());
                           var14.setChrService(var11.getChrService());
                           var14.setChrSufixe(var11.getChrSufixe());
                           var14.setChrSufixe_1(var11.getChrSufixe_1());
                           var14.setChrSufixe_2(var11.getChrSufixe_2());
                           var14.setChrSufixe_3(var11.getChrSufixe_3());
                           var14.setChrSufixe_4(var11.getChrSufixe_4());
                           var14.setChrSufixe_5(var11.getChrSufixe_5());
                           var14.setChrSufixe_6(var11.getChrSufixe_6());
                           var14.setChrSufixe_7(var11.getChrSufixe_7());
                           var14.setChrSufixe_8(var11.getChrSufixe_8());
                           var14.setChrSufixe_9(var11.getChrSufixe_9());
                           var14.setChrSufixe_A(var11.getChrSufixe_A());
                           var14.setChrCodeCaisse(var11.getChrCodeCaisse());
                           var10.insertChrono(var14, var7);
                        }
                     }
                  }
               }
            }

            var8.commit();
         } catch (HibernateException var18) {
            if (var8 != null) {
               var8.rollback();
            }

            throw var18;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.lesexercicesCaisse = this.recupererLesexercices((Session)null);
      this.madatamodel.setWrappedData(this.lesexercicesCaisse);
   }

   public void cloturer() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      if (this.exercicesCaisse != null) {
         this.genererNvlExo();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviCommVte");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.recopieChronoVentes(var1);
            this.recopieCaisses(var1);
            var2.commit();
         } catch (HibernateException var7) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var7;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.exercicesCaisse = this.exercicesNew;
         this.leIdExo = this.exercicesCaisse.getExecaiId();
         this.chargerLesExo();
      }

   }

   public void genererNvlExo() throws HibernateException, NamingException, ParseException {
      this.exercicesCaisse.setExecaiDateCloture(new Date());
      this.exercicesCaisse.setExecaiEtat(1);
      this.exercicesCaisse.setExecaiUserCloture(this.usersLog.getUsrid());
      this.exercicesCaisse = this.exoDao.modif(this.exercicesCaisse);
      UtilDate var1 = new UtilDate();
      this.exercicesNew = new ExercicesCaisse();
      this.exercicesNew.setExecaiId(this.exercicesCaisse.getExecaiId() + 1L);
      this.exercicesNew.setExecaiDateCreat(new Date());
      this.exercicesNew.setExecaiUserCreat(this.usersLog.getUsrid());
      String var2 = var1.dateToStringSQLLight(this.exercicesCaisse.getExecaiDateDebut());
      String[] var3 = var2.split("-");
      String var4 = "";
      String var5 = "";
      long var6 = 0L;
      var4 = var3[2];
      var5 = var3[1];
      var6 = Long.parseLong(var3[0]) + 1L;
      var2 = var6 + "-" + var5 + "-" + var4;
      Date var8 = var1.stringToDateSQLLight(var2);
      this.exercicesNew.setExecaiDateDebut(var8);
      String var9 = var1.dateToStringSQLLight(this.exercicesCaisse.getExecaiDateFin());
      String[] var10 = var9.split("-");
      var4 = var10[2];
      var5 = var10[1];
      var6 = Long.parseLong(var10[0]) + 1L;
      var9 = var6 + "-" + var5 + "-" + var4;
      Date var11 = var1.stringToDateSQLLight(var9);
      this.exercicesNew.setExecaiDateFin(var11);
      this.exercicesNew = this.exoDao.insert(this.exercicesNew);
   }

   public void recopieChronoVentes(Session var1) throws HibernateException, NamingException {
      new ArrayList();
      ChronoDao var3 = new ChronoDao(this.baseLog, this.utilInitHibernate);
      List var2 = var3.selectListCaisses(0, var1);
      if (var2.size() != 0) {
         new Chrono();

         for(int var5 = 0; var5 < var2.size(); ++var5) {
            Chrono var4 = (Chrono)var2.get(var5);
            if (var4.getChrPeriode() != null && !var4.getChrPeriode().isEmpty()) {
               String var6 = "" + this.exercicesCaisse.getExecaiId();
               if (var4.getChrPeriode().equals(var6)) {
                  Chrono var7 = new Chrono();
                  var7.setChrCodeCaisse(var4.getChrCodeCaisse());
                  var7.setChrFormat(var4.getChrFormat());
                  var7.setChrJournal(var4.getChrJournal());
                  var7.setChrMode(var4.getChrMode());
                  var7.setChrNature(var4.getChrNature());
                  var7.setChrNbCar(var4.getChrNbCar());
                  var7.setChrNom(var4.getChrNom());
                  var7.setChrPeriode("" + this.exercicesNew.getExecaiId());
                  var7.setChrPrefixe(var4.getChrPrefixe());
                  var7.setChrPrive(var4.getChrPrive());
                  var7.setChrSerie(var4.getChrSerie());
                  var7.setChrService(var4.getChrService());
                  var7.setChrSufixe(var4.getChrSufixe());
                  var3.insertChrono(var7, var1);
               }
            }
         }
      }

   }

   public void recopieCaisses(Session var1) {
      new ArrayList();
      CaissesCommercialesDao var3 = new CaissesCommercialesDao(this.baseLog, this.utilInitHibernate);
      List var2 = var3.selectCaisseCommerciale(this.exercicesCaisse.getExecaiId(), 0, var1);
      if (var2.size() != 0) {
         for(int var4 = 0; var4 < var2.size(); ++var4) {
            new CaissesCommerciales();
            CaissesCommerciales var5 = (CaissesCommerciales)var2.get(var4);
            var5.setExercicesCaisse(this.exercicesNew);
            var3.insert(var5, var1);
         }
      }

   }














   public boolean isTestDateAj() {
      return this.testDateAj;
   }

   public void setTestDateAj(boolean var1) {
      this.testDateAj = var1;
   }

   public long getLeIdExo() {
      return this.leIdExo;
   }

   public void setLeIdExo(long var1) {
      this.leIdExo = var1;
   }

   public boolean isDisable() {
      return this.disable;
   }

   public void setDisable(boolean var1) {
      this.disable = var1;
   }

   public List getListExo() {
      return this.listExo;
   }

   public void setListExo(List var1) {
      this.listExo = var1;
   }

   public DataModel getMadatamodel() {
      return this.madatamodel;
   }

   public void setMadatamodel(DataModel var1) {
      this.madatamodel = var1;
   }

   public Date getDatecloture() {
      return this.datecloture;
   }

   public void setDatecloture(Date var1) {
      this.datecloture = var1;
   }

   public ExercicesCaisse getExercicesCaisse() {
      return this.exercicesCaisse;
   }

   public void setExercicesCaisse(ExercicesCaisse var1) {
      this.exercicesCaisse = var1;
   }

   public List getLesexercicesCaisse() {
      return this.lesexercicesCaisse;
   }

   public void setLesexercicesCaisse(List var1) {
      this.lesexercicesCaisse = var1;
   }

   public boolean isNoExo() {
      return this.noExo;
   }

   public void setNoExo(boolean var1) {
      this.noExo = var1;
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
