package com.epegase.forms.administration;

import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.ExercicesVentesDao;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
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

public class FormExercicesEducation implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private transient DataModel madatamodel;
   private ExercicesVentes exercicesVentes;
   private List lesexercicesVentes;
   private boolean testDateAj;
   private boolean noExo;
   Locale locale = Locale.getDefault();
   DateFormat dateFormat;
   private ExercicesVentesDao exoDao;
   private long leIdExo;
   private boolean disable;
   List listExo;
   private Date datecloture;
   private Date memoDateFin;

   public FormExercicesEducation() throws IOException, JDOMException {
      this.dateFormat = DateFormat.getDateInstance(0, this.locale);
      this.leIdExo = 0L;
      this.exercicesVentes = new ExercicesVentes();
      this.lesexercicesVentes = new ArrayList();
      this.testDateAj = true;
      this.listExo = new ArrayList();
      this.noExo = false;
      this.madatamodel = new ListDataModel();
   }

   public void InstancesDaoUtilses() {
      this.exoDao = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
   }

   public String enregistrerExercicesVentes() throws IOException, JDOMException, SAXException, HibernateException, NamingException {
      Date var1 = this.exercicesVentes.getExevteDateDebut();
      Date var2 = this.exercicesVentes.getExevteDateFin();
      if (var1.after(var2)) {
         this.testDateAj = false;
      } else {
         this.testDateAj = true;
         int var3 = var1.getYear() + 1900;
         this.exercicesVentes.setExevteId((long)var3);
         this.exercicesVentes.setExevteUserCreat(this.usersLog.getUsrid());
         this.exercicesVentes.setExevteUserModif(0L);
         this.exercicesVentes.setExevteDateCreat(new Date());
         this.exercicesVentes.setExevteDateModif((Date)null);
         Object var4 = new ArrayList();
         if (this.madatamodel.getRowCount() > 0) {
            var4 = (List)this.madatamodel.getWrappedData();
         }

         int var5 = this.madatamodel.getRowCount() + 2;
         this.exercicesVentes.setIndice(var5);
         ((List)var4).add(this.exercicesVentes);
         this.madatamodel.setWrappedData(var4);
         Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         Transaction var7 = null;

         try {
            var7 = var6.beginTransaction();
            this.exercicesVentes = this.exoDao.insert(this.exercicesVentes, var6);
            this.lesexercicesVentes.add(this.exercicesVentes);
            this.madatamodel.setWrappedData(this.lesexercicesVentes);
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

   public ExercicesVentes recupererLastExo(Session var1) throws HibernateException, NamingException {
      ExercicesVentes var2 = this.exoDao.recupererLastExo(var1);
      return var2;
   }

   public void selectionLigneExercice() {
      if (this.madatamodel.isRowAvailable()) {
         this.exercicesVentes = (ExercicesVentes)this.madatamodel.getRowData();
         this.memoDateFin = this.exercicesVentes.getExevteDateFin();
      }

   }

   public String chargerDate() throws ParseException {
      this.exercicesVentes.setExevteDateDebut(this.debutinitial());
      this.exercicesVentes.setExevteDateFin(this.finalinitial());
      return null;
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

   public String modifier() throws HibernateException, NamingException, ParseException {
      String var1 = "dd-MM-yyyy";
      SimpleDateFormat var2 = new SimpleDateFormat(var1, Locale.FRANCE);
      String var3 = var2.format(this.exercicesVentes.getExevteDateDebut());
      Date var4 = var2.parse(var3);
      String var5 = var2.format(this.exercicesVentes.getExevteDateFin());
      Date var6 = var2.parse(var5);
      if (!var4.after(var6)) {
         Session var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         Transaction var8 = null;

         try {
            var8 = var7.beginTransaction();
            this.exercicesVentes.setExevteUserModif(this.usersLog.getUsrid());
            this.exercicesVentes.setExevteDateModif(new Date());
            this.exercicesVentes = this.exoDao.modif(this.exercicesVentes, var7);
            if (this.exercicesVentes.getExevteDateFin().getYear() + 1900 != this.memoDateFin.getYear() + 1900) {
               new ArrayList();
               ChronoDao var10 = new ChronoDao(this.baseLog, this.utilInitHibernate);
               List var9 = var10.selectListEducation(0, var7);
               if (var9.size() != 0) {
                  new Chrono();

                  for(int var12 = 0; var12 < var9.size(); ++var12) {
                     Chrono var11 = (Chrono)var9.get(var12);
                     if (var11.getChrPeriode() != null && !var11.getChrPeriode().isEmpty()) {
                        String var13 = "" + (this.memoDateFin.getYear() + 1900);
                        if (var11.getChrPeriode().equals(var13)) {
                           Chrono var14 = new Chrono();
                           var14.setChrPeriode("" + (this.exercicesVentes.getExevteDateFin().getYear() + 1900));
                           var14.setChrFormat(var11.getChrFormat());
                           var14.setChrJournal(var11.getChrJournal());
                           var14.setChrMode(var11.getChrMode());
                           var14.setChrNature(var11.getChrNature());
                           var14.setChrNbCar(var11.getChrNbCar());
                           var14.setChrNom(var11.getChrNom());
                           var14.setChrPrefixe(var11.getChrPrefixe());
                           var14.setChrPrive(var11.getChrPrive());
                           var14.setChrSerie(var11.getChrSerie());
                           var14.setChrService(var11.getChrService());
                           var14.setChrSufixe(var11.getChrSufixe());
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

      this.lesexercicesVentes = this.recupererLesexercices((Session)null);
      this.madatamodel.setWrappedData(this.lesexercicesVentes);
      return null;
   }

   public List recupererLesexercices(Session var1) throws HibernateException, NamingException {
      new ArrayList();
      List var2 = this.exoDao.selectExercicesVentes(var1);
      this.listExo = new ArrayList();
      if (var2.size() == 0) {
         this.noExo = true;
      } else {
         this.noExo = false;

         for(int var3 = 0; var3 < var2.size(); ++var3) {
            ExercicesVentes var4 = (ExercicesVentes)var2.get(var3);
            var4.setIndice(var3 + 1);
            String var5 = "dd-MM-yyyy";
            SimpleDateFormat var6 = new SimpleDateFormat(var5, Locale.FRANCE);
            String var7 = var6.format(var4.getExevteDateDebut());
            String var8 = var6.format(var4.getExevteDateFin());
            long var9 = var4.getExevteId();
            this.listExo.add(new SelectItem(var9, var7 + "...................." + var8));
         }
      }

      this.setLesexercicesVentes(var2);
      return var2;
   }

   public String genererNvlExo(Session var1) throws HibernateException, NamingException {
      ExercicesVentes var2 = this.exoDao.recupererLastExo(var1);
      var2.setExevteDateCloture(new Date());
      var2.setExevteEtat(1);
      var2.setExevteDateFin(this.datecloture);
      var2.setExevteUserCloture(this.usersLog.getUsrid());
      this.exoDao.modif(var2, var1);
      GregorianCalendar var3 = new GregorianCalendar();
      var3.setTime(this.datecloture);
      var3.add(5, 1);
      Date var4 = var3.getTime();
      ExercicesVentes var5 = new ExercicesVentes();
      var5.setExevteDateDebut(var4);
      var5.setExevteId(var2.getExevteId() + 1L);
      var3.add(2, 12);
      var3.add(5, -1);
      Date var6 = var3.getTime();
      var5.setExevteDateFin(var6);
      this.exoDao.insert(var5, var1);
      return "";
   }

   public String cloturer(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.genererNvlExo(var1);
      this.lesexercicesVentes = this.recupererLesexercices(var1);
      return "";
   }

   public DateFormat getDateFormat() {
      return this.dateFormat;
   }

   public void setDateFormat(DateFormat var1) {
      this.dateFormat = var1;
   }

   public Locale getLocale() {
      return this.locale;
   }

   public void setLocale(Locale var1) {
      this.locale = var1;
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

   public String chargerLesExo() throws HibernateException, NamingException {
      this.lesexercicesVentes = this.recupererLesexercices((Session)null);
      this.madatamodel.setWrappedData(this.lesexercicesVentes);
      return null;
   }

   public Date getDatecloture() {
      return this.datecloture;
   }

   public void setDatecloture(Date var1) {
      this.datecloture = var1;
   }

   public ExercicesVentes getExercicesVentes() {
      return this.exercicesVentes;
   }

   public void setExercicesVentes(ExercicesVentes var1) {
      this.exercicesVentes = var1;
   }

   public List getLesexercicesVentes() {
      return this.lesexercicesVentes;
   }

   public void setLesexercicesVentes(List var1) {
      this.lesexercicesVentes = var1;
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
