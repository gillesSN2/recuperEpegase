package com.epegase.forms.administration;

import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.ExercicesParc;
import com.epegase.systeme.classe.LocalisationGps;
import com.epegase.systeme.classe.ManifestEntete;
import com.epegase.systeme.classe.ParcConsommation;
import com.epegase.systeme.classe.ParcOrEntete;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.ExercicesParcsDao;
import com.epegase.systeme.dao.LocalisationGpsDao;
import com.epegase.systeme.dao.ManifestEnteteDao;
import com.epegase.systeme.dao.ParcConsommationDao;
import com.epegase.systeme.dao.ParcOrEnteteDao;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.ObjetMessageSysteme;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
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

public class FormExercicesParcs implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private transient DataModel madatamodel;
   private ExercicesParc exercicesParc;
   private ExercicesParc exercicesNew;
   private List lesexercicesParc;
   private boolean testDateAj;
   private boolean noExo;
   Locale locale = Locale.getDefault();
   DateFormat dateFormat;
   private ExercicesParcsDao exoDao;
   private long leIdExo;
   private boolean disable;
   List listExo;
   private Date datecloture;
   private Date memoDateFin;
   private ObjetMessageSysteme obm;
   private boolean var_showBarProg;
   private int var_currentValue;
   private int var_valueMax;

   public FormExercicesParcs() throws IOException, JDOMException {
      this.dateFormat = DateFormat.getDateInstance(0, this.locale);
      this.leIdExo = 0L;
      this.var_showBarProg = false;
      this.var_valueMax = 20;
      this.exercicesParc = new ExercicesParc();
      this.lesexercicesParc = new ArrayList();
      this.testDateAj = true;
      this.listExo = new ArrayList();
      this.noExo = false;
      this.madatamodel = new ListDataModel();
      this.obm = new ObjetMessageSysteme();
   }

   public void InstancesDaoUtilses() {
      this.exoDao = new ExercicesParcsDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerLesExo() throws HibernateException, NamingException {
      this.lesexercicesParc = this.recupererLesexercices((Session)null);
      this.madatamodel.setWrappedData(this.lesexercicesParc);
   }

   public ExercicesParc recupererLastExo(Session var1) throws HibernateException, NamingException {
      ExercicesParc var2 = this.exoDao.recupererLastExo(var1);
      return var2;
   }

   public List recupererLesexercices(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         var2 = true;
      }

      new ArrayList();
      List var3 = this.exoDao.selectExercicesParcs(var1);
      this.listExo = new ArrayList();
      if (var3.size() == 0) {
         this.noExo = true;
      } else {
         this.noExo = false;

         for(int var4 = 0; var4 < var3.size(); ++var4) {
            ExercicesParc var5 = (ExercicesParc)var3.get(var4);
            var5.setIndice(var4 + 1);
            String var6 = "dd-MM-yyyy";
            SimpleDateFormat var7 = new SimpleDateFormat(var6, Locale.FRANCE);
            String var8 = var7.format(var5.getExeprcDateDebut());
            String var9 = var7.format(var5.getExeprcDateFin());
            long var10 = var5.getExeprcId();
            this.listExo.add(new SelectItem(var10, var8 + "...................." + var9));
         }
      }

      this.setLesexercicesParc(var3);
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public void enregistrerExercicesParcs() throws IOException, JDOMException, SAXException, HibernateException, NamingException {
      Date var1 = this.exercicesParc.getExeprcDateDebut();
      Date var2 = this.exercicesParc.getExeprcDateFin();
      if (var1.after(var2)) {
         this.testDateAj = false;
      } else {
         this.testDateAj = true;
         int var3 = var1.getYear() + 1900;
         this.exercicesParc.setExeprcId((long)var3);
         this.exercicesParc.setExeprcUserCreat(this.usersLog.getUsrid());
         this.exercicesParc.setExeprcUserModif(0L);
         this.exercicesParc.setExeprcDateCreat(new Date());
         this.exercicesParc.setExeprcDateModif((Date)null);
         Object var4 = new ArrayList();
         if (this.madatamodel.getRowCount() > 0) {
            var4 = (List)this.madatamodel.getWrappedData();
         }

         int var5 = this.madatamodel.getRowCount() + 2;
         this.exercicesParc.setIndice(var5);
         ((List)var4).add(this.exercicesParc);
         this.madatamodel.setWrappedData(var4);
         Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         Transaction var7 = null;

         try {
            var7 = var6.beginTransaction();
            this.exercicesParc = this.exoDao.insert(this.exercicesParc, var6);
            this.lesexercicesParc.add(this.exercicesParc);
            this.madatamodel.setWrappedData(this.lesexercicesParc);
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

   }

   public void selectionLigneExercice() {
      if (this.madatamodel.isRowAvailable()) {
         this.exercicesParc = (ExercicesParc)this.madatamodel.getRowData();
         this.memoDateFin = this.exercicesParc.getExeprcDateFin();
      }

   }

   public void chargerDate() throws ParseException {
      this.exercicesParc.setExeprcDateDebut(this.debutinitial());
      this.exercicesParc.setExeprcDateFin(this.finalinitial());
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
      String var3 = var2.format(this.exercicesParc.getExeprcDateDebut());
      Date var4 = var2.parse(var3);
      String var5 = var2.format(this.exercicesParc.getExeprcDateFin());
      Date var6 = var2.parse(var5);
      if (!var4.after(var6)) {
         Session var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         Transaction var8 = null;

         try {
            var8 = var7.beginTransaction();
            this.exercicesParc.setExeprcUserModif(this.usersLog.getUsrid());
            this.exercicesParc.setExeprcDateModif(new Date());
            this.exercicesParc = this.exoDao.modifierExercicesParcs(this.exercicesParc, var7);
            if (this.exercicesParc.getExeprcDateFin().getYear() + 1900 != this.memoDateFin.getYear() + 1900) {
               new ArrayList();
               ChronoDao var10 = new ChronoDao(this.baseLog, this.utilInitHibernate);
               List var9 = var10.selectListVente(0, var7);
               if (var9.size() != 0) {
                  new Chrono();

                  for(int var12 = 0; var12 < var9.size(); ++var12) {
                     Chrono var11 = (Chrono)var9.get(var12);
                     if (var11.getChrPeriode() != null && !var11.getChrPeriode().isEmpty()) {
                        String var13 = "" + (this.memoDateFin.getYear() + 1900);
                        if (var11.getChrPeriode().equals(var13)) {
                           Chrono var14 = new Chrono();
                           var14.setChrPeriode("" + (this.exercicesParc.getExeprcDateFin().getYear() + 1900));
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

      this.lesexercicesParc = this.recupererLesexercices((Session)null);
      this.madatamodel.setWrappedData(this.lesexercicesParc);
   }

   public void cloturer() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      if (this.exercicesParc != null) {
         this.obm = new ObjetMessageSysteme();
         this.obm.setTexte("Initialisation de la cloture...");
         ++this.var_currentValue;
         this.genererNvlExo();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.recopieChronoParcs(var1);
            this.changeExerciceLocalisation(var1);
            this.changeExerciceManifeste(var1);
            this.changeExerciceConsommation(var1);
            this.changeExerciceOr(var1);
            var2.commit();
         } catch (HibernateException var7) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var7;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.exercicesParc = this.exercicesNew;
         this.leIdExo = this.exercicesParc.getExeprcId();
         this.chargerLesExo();
      }

   }

   public void genererNvlExo() throws HibernateException, NamingException, ParseException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Creaton nouvel exercice...");
      ++this.var_currentValue;
      UtilDate var1 = new UtilDate();
      this.exercicesParc.setExeprcDateCloture(new Date());
      this.exercicesParc.setExeprcEtat(1);
      this.exercicesParc.setExeprcUserCloture(this.usersLog.getUsrid());
      this.exercicesParc.setExeprcDateFin(var1.dateDernierJourAnnee(this.exercicesParc.getExeprcDateDebut()));
      this.exercicesParc = this.exoDao.modifierExercicesParcs(this.exercicesParc);
      this.exercicesNew = new ExercicesParc();
      this.exercicesNew.setExeprcId(this.exercicesParc.getExeprcId() + 1L);
      this.exercicesNew.setExeprcDateCreat(new Date());
      this.exercicesNew.setExeprcUserCreat(this.usersLog.getUsrid());
      String var2 = var1.dateToStringSQLLight(this.exercicesParc.getExeprcDateDebut());
      String[] var3 = var2.split("-");
      String var4 = "";
      String var5 = "";
      long var6 = 0L;
      var4 = var3[2];
      var5 = var3[1];
      var6 = Long.parseLong(var3[0]) + 1L;
      var2 = var6 + "-" + var5 + "-" + var4;
      Date var8 = var1.stringToDateSQLLight(var2);
      this.exercicesNew.setExeprcDateDebut(var8);
      this.exercicesNew.setExeprcDateFin(var1.dateDernierJourAnnee(this.exercicesNew.getExeprcDateDebut()));
      this.exercicesNew = this.exoDao.insert(this.exercicesNew);
   }

   public void recopieChronoParcs(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Recopie des chronos...");
      ++this.var_currentValue;
      new ArrayList();
      ChronoDao var3 = new ChronoDao(this.baseLog, this.utilInitHibernate);
      List var2 = var3.selectListVente(0, var1);
      if (var2.size() != 0) {
         for(int var4 = 0; var4 < var2.size(); ++var4) {
            new Chrono();
            Chrono var6 = new Chrono();
            Chrono var5 = (Chrono)var2.get(var4);
            if (var5.getChrPeriode() != null && !var5.getChrPeriode().isEmpty()) {
               String var7 = "" + this.exercicesParc.getExeprcId();
               if (var5.getChrPeriode().equals(var7)) {
                  var6.setChrPeriode("" + this.exercicesNew.getExeprcId());
                  var6.setChrFormat(var5.getChrFormat());
                  var6.setChrJournal(var5.getChrJournal());
                  var6.setChrMode(var5.getChrMode());
                  var6.setChrNature(var5.getChrNature());
                  var6.setChrNbCar(var5.getChrNbCar());
                  var6.setChrNom(var5.getChrNom());
                  var6.setChrPrefixe(var5.getChrPrefixe());
                  var6.setChrPrive(var5.getChrPrive());
                  var6.setChrSerie(var5.getChrSerie());
                  var6.setChrService(var5.getChrService());
                  var6.setChrSufixe(var5.getChrSufixe());
                  var3.insertChrono(var6, var1);
               }
            }
         }
      }

   }

   public void changeExerciceLocalisation(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Change exercice des geolicalisations...");
      ++this.var_currentValue;
      new ArrayList();
      LocalisationGpsDao var3 = new LocalisationGpsDao(this.baseLog, this.utilInitHibernate);
      new LocalisationGps();
      List var2 = var3.rechercheLocalisation(this.exercicesNew.getExeprcDateDebut(), this.exercicesNew.getExeprcDateFin(), var1);
      if (var2.size() != 0) {
         for(int var5 = 0; var5 < var2.size(); ++var5) {
            LocalisationGps var4 = (LocalisationGps)var2.get(var5);
            var4.setExercicesParc(this.exercicesNew);
            var3.modif(var4, var1);
         }
      }

      var1.flush();
   }

   public void changeExerciceManifeste(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Change exercice des manifestes...");
      ++this.var_currentValue;
      new ArrayList();
      ManifestEnteteDao var3 = new ManifestEnteteDao(this.baseLog, this.utilInitHibernate);
      new ManifestEntete();
      List var2 = var3.rechercheFactureByDate(this.exercicesNew.getExeprcDateDebut(), this.exercicesNew.getExeprcDateFin(), var1);
      if (var2.size() != 0) {
         for(int var5 = 0; var5 < var2.size(); ++var5) {
            ManifestEntete var4 = (ManifestEntete)var2.get(var5);
            var4.setExercicesParc(this.exercicesNew);
            var3.modif(var4, var1);
         }
      }

      var1.flush();
   }

   public void changeExerciceConsommation(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Change exercice des consommations...");
      ++this.var_currentValue;
      new ArrayList();
      ParcConsommationDao var3 = new ParcConsommationDao(this.baseLog, this.utilInitHibernate);
      new ParcConsommation();
      List var2 = var3.rechercheConsommationByDate(this.exercicesNew.getExeprcDateDebut(), this.exercicesNew.getExeprcDateFin(), var1);
      if (var2.size() != 0) {
         for(int var5 = 0; var5 < var2.size(); ++var5) {
            ParcConsommation var4 = (ParcConsommation)var2.get(var5);
            var4.setExercicesParc(this.exercicesNew);
            var3.modif(var4, var1);
         }
      }

      var1.flush();
   }

   public void changeExerciceOr(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Change exercice des OR...");
      ++this.var_currentValue;
      new ArrayList();
      ParcOrEnteteDao var3 = new ParcOrEnteteDao(this.baseLog, this.utilInitHibernate);
      new ParcOrEntete();
      List var2 = var3.rechercheFactureByDate(this.exercicesNew.getExeprcDateDebut(), this.exercicesNew.getExeprcDateFin(), var1);
      if (var2.size() != 0) {
         for(int var5 = 0; var5 < var2.size(); ++var5) {
            ParcOrEntete var4 = (ParcOrEntete)var2.get(var5);
            var4.setExercicesParc(this.exercicesNew);
            var3.modif(var4, var1);
         }
      }

      var1.flush();
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

   public Date getDatecloture() {
      return this.datecloture;
   }

   public void setDatecloture(Date var1) {
      this.datecloture = var1;
   }

   public ExercicesParc getExercicesParc() {
      return this.exercicesParc;
   }

   public void setExercicesParc(ExercicesParc var1) {
      this.exercicesParc = var1;
   }

   public List getLesexercicesParc() {
      return this.lesexercicesParc;
   }

   public void setLesexercicesParc(List var1) {
      this.lesexercicesParc = var1;
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

   public ObjetMessageSysteme getObm() {
      return this.obm;
   }

   public void setObm(ObjetMessageSysteme var1) {
      this.obm = var1;
   }

   public int getVar_currentValue() {
      return this.var_currentValue;
   }

   public void setVar_currentValue(int var1) {
      this.var_currentValue = var1;
   }

   public boolean isVar_showBarProg() {
      return this.var_showBarProg;
   }

   public void setVar_showBarProg(boolean var1) {
      this.var_showBarProg = var1;
   }

   public int getVar_valueMax() {
      return this.var_valueMax;
   }

   public void setVar_valueMax(int var1) {
      this.var_valueMax = var1;
   }
}
