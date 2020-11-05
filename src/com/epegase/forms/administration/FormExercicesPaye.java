package com.epegase.forms.administration;

import com.epegase.systeme.classe.BulletinLigne;
import com.epegase.systeme.classe.BulletinSalaire;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.ExercicesPaye;
import com.epegase.systeme.classe.FeuilleCalcul;
import com.epegase.systeme.classe.FeuilleCalculFormule;
import com.epegase.systeme.classe.FeuilleCalculRubrique;
import com.epegase.systeme.classe.PlanPaye;
import com.epegase.systeme.classe.Salaries;
import com.epegase.systeme.classe.SalariesContrats;
import com.epegase.systeme.classe.SalariesElements;
import com.epegase.systeme.classe.SalariesHistorique;
import com.epegase.systeme.classe.SalariesVariables;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.BulletinLigneDao;
import com.epegase.systeme.dao.BulletinSalaireDao;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.ExercicesPayeDao;
import com.epegase.systeme.dao.FeuilleCalculDao;
import com.epegase.systeme.dao.FeuilleCalculFormuleDao;
import com.epegase.systeme.dao.FeuilleCalculRubriqueDao;
import com.epegase.systeme.dao.PlanPayeDao;
import com.epegase.systeme.dao.SalariesContratsDao;
import com.epegase.systeme.dao.SalariesDao;
import com.epegase.systeme.dao.SalariesElementsDao;
import com.epegase.systeme.dao.SalariesHistoriqueDao;
import com.epegase.systeme.dao.SalariesVariablesDao;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
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

public class FormExercicesPaye implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private transient DataModel madatamodel = new ListDataModel();
   private ExercicesPaye exercicesPaye = new ExercicesPaye();
   private ExercicesPaye exercicesNew;
   private List lesexercicesPaye = new ArrayList();
   private boolean testDateAj = true;
   private boolean noExo = false;
   private ExercicesPayeDao exoDao;
   private long leIdExo = 0L;
   private boolean disable;
   List listExo = new ArrayList();
   private Date datecloture;
   private UtilDate utilDate = new UtilDate();

   public FormExercicesPaye() throws ParseException {
   }

   public void InstancesDaoUtilses() {
      this.exoDao = new ExercicesPayeDao(this.baseLog, this.utilInitHibernate);
   }

   public void enregistrerExercicesPaye() throws HibernateException, NamingException {
      Date var1 = this.exercicesPaye.getExepayDateDebut();
      Date var2 = this.exercicesPaye.getExepayDateFin();
      if (var1.after(var2)) {
         this.testDateAj = false;
      } else {
         this.testDateAj = true;
         int var3 = var1.getYear() + 1900;
         this.exercicesPaye.setExepayId((long)var3);
         this.exercicesPaye.setExepayUserCreat(this.usersLog.getUsrid());
         this.exercicesPaye.setExepayUserModif(0L);
         this.exercicesPaye.setExepayDateCreat(new Date());
         this.exercicesPaye.setExepayDateModif((Date)null);
         Object var4 = new ArrayList();
         if (this.madatamodel.getRowCount() > 0) {
            var4 = (List)this.madatamodel.getWrappedData();
         }

         int var5 = this.madatamodel.getRowCount() + 2;
         this.exercicesPaye.setIndice(var5);
         ((List)var4).add(this.exercicesPaye);
         this.madatamodel.setWrappedData(var4);
         Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         Transaction var7 = null;

         try {
            var7 = var6.beginTransaction();
            this.exercicesPaye = this.exoDao.insert(this.exercicesPaye, var6);
            this.lesexercicesPaye.add(this.exercicesPaye);
            this.madatamodel.setWrappedData(this.lesexercicesPaye);
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

   public ExercicesPaye recupererLastExo(Session var1) throws HibernateException, NamingException {
      ExercicesPaye var2 = this.exoDao.recupererLastExo(var1);
      return var2;
   }

   public void selectionLigneExercice() {
      if (this.madatamodel.isRowAvailable()) {
         this.exercicesPaye = (ExercicesPaye)this.madatamodel.getRowData();
      }

   }

   public void chargerDate() throws ParseException {
      this.exercicesPaye = new ExercicesPaye();
      this.exercicesPaye.setExepayDateDebut(this.utilDate.datePremierJourAnnee(new Date()));
      this.exercicesPaye.setExepayDateFin(this.utilDate.dateDernierJourAnnee(new Date()));
   }

   public void modifier() throws HibernateException, NamingException, ParseException {
      String var1 = "dd-MM-yyyy";
      SimpleDateFormat var2 = new SimpleDateFormat(var1, Locale.FRANCE);
      String var3 = var2.format(this.exercicesPaye.getExepayDateDebut());
      Date var4 = var2.parse(var3);
      String var5 = var2.format(this.exercicesPaye.getExepayDateFin());
      Date var6 = var2.parse(var5);
      if (!var4.after(var6)) {
         Session var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         Transaction var8 = null;

         try {
            var8 = var7.beginTransaction();
            this.exercicesPaye.setExepayUserModif(this.usersLog.getUsrid());
            this.exercicesPaye.setExepayDateModif(new Date());
            this.exercicesPaye = this.exoDao.modif(this.exercicesPaye, var7);
            var8.commit();
         } catch (HibernateException var13) {
            if (var8 != null) {
               var8.rollback();
            }

            throw var13;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.lesexercicesPaye = this.recupererLesexercices((Session)null);
      this.madatamodel.setWrappedData(this.lesexercicesPaye);
   }

   public List recupererLesexercices(Session var1) throws HibernateException, NamingException {
      new ArrayList();
      List var2 = this.exoDao.selectExercicesPaye(var1);
      this.listExo = new ArrayList();
      if (var2.size() == 0) {
         this.noExo = true;
      } else {
         this.noExo = false;

         for(int var3 = 0; var3 < var2.size(); ++var3) {
            ExercicesPaye var4 = (ExercicesPaye)var2.get(var3);
            var4.setIndice(var3 + 1);
            String var5 = "dd-MM-yyyy";
            SimpleDateFormat var6 = new SimpleDateFormat(var5, Locale.FRANCE);
            String var7 = var6.format(var4.getExepayDateDebut());
            String var8 = var6.format(var4.getExepayDateFin());
            long var9 = var4.getExepayId();
            this.listExo.add(new SelectItem(var9, var7 + "...................." + var8));
         }
      }

      this.setLesexercicesPaye(var2);
      return var2;
   }

   public void cloturer() throws HibernateException, NamingException, ParseException {
      if (this.exercicesPaye != null) {
         this.genererNvlExo();
         boolean var1 = false;
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var3 = null;

         try {
            var3 = var2.beginTransaction();
            this.recopieChronoPaye(var2);
            this.recopiePlanPaye(var2);
            this.recopieFeuilleCalcul(var2);
            var1 = true;
            var3.commit();
         } catch (HibernateException var49) {
            if (var3 != null) {
               var3.rollback();
            }

            throw var49;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         if (var1) {
            boolean var4 = false;
            var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
            Transaction var5 = null;

            try {
               var5 = var2.beginTransaction();
               this.recopieRubrique(var2);
               var4 = true;
               var5.commit();
            } catch (HibernateException var43) {
               if (var5 != null) {
                  var5.rollback();
               }

               throw var43;
            } finally {
               this.utilInitHibernate.closeSession();
            }

            if (var4) {
               boolean var6 = false;
               var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
               Transaction var7 = null;

               try {
                  var7 = var2.beginTransaction();
                  this.recopieFormule(var2);
                  var6 = true;
                  var7.commit();
               } catch (HibernateException var45) {
                  if (var7 != null) {
                     var7.rollback();
                  }

                  throw var45;
               } finally {
                  this.utilInitHibernate.closeSession();
               }

               if (var6) {
                  var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
                  Transaction var8 = null;

                  try {
                     var8 = var2.beginTransaction();
                     this.calculHistorique(var2);
                     this.verificationContratActif(var2);
                     this.recopieVariables(var2);
                     var8.commit();
                  } catch (HibernateException var47) {
                     if (var8 != null) {
                        var8.rollback();
                     }

                     throw var47;
                  } finally {
                     this.utilInitHibernate.closeSession();
                  }
               }
            }
         }

         this.exercicesPaye = this.exercicesNew;
         this.leIdExo = this.exercicesPaye.getExepayId();
         this.chargerLesExo();
      }

   }

   public void genererNvlExo() throws HibernateException, NamingException, ParseException {
      this.exercicesPaye.setExepayDateCloture(new Date());
      this.exercicesPaye.setExepayEtat(1);
      this.exercicesPaye.setExepayUserCloture(this.usersLog.getUsrid());
      this.exercicesPaye = this.exoDao.modif(this.exercicesPaye);
      this.exercicesNew = new ExercicesPaye();
      this.exercicesNew.setExepayId(this.exercicesPaye.getExepayId() + 1L);
      this.exercicesNew.setExepayDateCreat(new Date());
      this.exercicesNew.setExepayUserCreat(this.usersLog.getUsrid());
      String var1 = this.utilDate.dateToStringSQLLight(this.exercicesPaye.getExepayDateDebut());
      String[] var2 = var1.split("-");
      String var3 = "";
      String var4 = "";
      long var5 = 0L;
      var3 = var2[2];
      var4 = var2[1];
      var5 = Long.parseLong(var2[0]) + 1L;
      var1 = var5 + "-" + var4 + "-" + var3;
      Date var7 = this.utilDate.stringToDateSQLLight(var1);
      this.exercicesNew.setExepayDateDebut(var7);
      String var8 = this.utilDate.dateToStringSQLLight(this.exercicesPaye.getExepayDateFin());
      String[] var9 = var8.split("-");
      var3 = var9[2];
      var4 = var9[1];
      var5 = Long.parseLong(var9[0]) + 1L;
      var8 = var5 + "-" + var4 + "-" + var3;
      Date var10 = this.utilDate.stringToDateSQLLight(var8);
      this.exercicesNew.setExepayDateFin(var10);
      this.exercicesNew = this.exoDao.insert(this.exercicesNew);
   }

   public void recopieChronoPaye(Session var1) throws HibernateException, NamingException {
      new ArrayList();
      ChronoDao var3 = new ChronoDao(this.baseLog, this.utilInitHibernate);
      List var2 = var3.selectListPaye(0, var1);
      if (var2.size() != 0) {
         for(int var4 = 0; var4 < var2.size(); ++var4) {
            new Chrono();
            Chrono var6 = new Chrono();
            Chrono var5 = (Chrono)var2.get(var4);
            if (var5.getChrPeriode() != null && !var5.getChrPeriode().isEmpty()) {
               String var7 = "" + this.exercicesPaye.getExepayId();
               if (var5.getChrPeriode().equals(var7)) {
                  var6.setChrPeriode("" + this.exercicesNew.getExepayId());
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

   public void recopiePlanPaye(Session var1) throws HibernateException, NamingException {
      new ArrayList();
      PlanPayeDao var3 = new PlanPayeDao(this.baseLog, this.utilInitHibernate);
      List var2 = var3.chargerPlanPaye(this.exercicesPaye.getExepayId(), var1);
      if (var2.size() != 0) {
         new PlanPaye();
         PlanPaye var5 = null;

         for(int var6 = 0; var6 < var2.size(); ++var6) {
            PlanPaye var4 = (PlanPaye)var2.get(var6);
            var5 = new PlanPaye();
            var5.setExercicesPaye(this.exercicesNew);
            var5.setPlpAnalytique(var4.getPlpAnalytique());
            var5.setPlpBaseAutre(var4.isPlpBaseAutre());
            var5.setPlpBaseFiscale(var4.isPlpBaseFiscale());
            var5.setPlpBasePatronale(var4.isPlpBasePatronale());
            var5.setPlpBaseSociale(var4.isPlpBaseSociale());
            var5.setPlpCode(var4.getPlpCode());
            var5.setPlpCommentaire(var4.getPlpCommentaire());
            var5.setPlpCompteNormal(var4.getPlpCompteNormal());
            var5.setPlpComptePrestataire(var4.getPlpComptePrestataire());
            var5.setPlpCpNormal(var4.getPlpCpNormal());
            var5.setPlpCpPrestataire(var4.getPlpCpPrestataire());
            var5.setPlpDateCreat(new Date());
            var5.setPlpDateModif((Date)null);
            var5.setPlpFormuleFiscale(var4.getPlpFormuleFiscale());
            var5.setPlpFormulePatronale(var4.getPlpFormulePatronale());
            var5.setPlpFormuleSociale(var4.getPlpFormuleSociale());
            var5.setPlpGroupe(var4.getPlpGroupe());
            var5.setPlpInactif(var4.getPlpInactif());
            var5.setPlpLibelleFR(var4.getPlpLibelleFR());
            var5.setPlpLibelleNatureFR(var4.getPlpLibelleNatureFR());
            var5.setPlpLibelleSP(var4.getPlpLibelleSP());
            var5.setPlpLibelleUK(var4.getPlpLibelleUK());
            var5.setPlpNature(var4.getPlpNature());
            var5.setPlpOption(var4.getPlpOption());
            var5.setPlpProtege(var4.getPlpProtege());
            var5.setPlpRan(var4.getPlpRan());
            var5.setPlpSens(var4.getPlpSens());
            var5.setPlpTauxFiscale(var4.getPlpTauxFiscale());
            var5.setPlpTauxPatronal(var4.getPlpTauxPatronal());
            var5.setPlpTauxSociale(var4.getPlpTauxSociale());
            var5.setPlpCalculBase(var4.getPlpCalculBase());
            var5.setPlpUserCreat(this.usersLog.getUsrid());
            var5.setPlpUserModif(0L);
            var3.insert(var5, var1);
         }
      }

   }

   public void recopieFeuilleCalcul(Session var1) throws HibernateException, NamingException {
      new ArrayList();
      FeuilleCalculDao var3 = new FeuilleCalculDao(this.baseLog, this.utilInitHibernate);
      List var2 = var3.chargerFeuilles(this.exercicesPaye.getExepayId(), var1);
      new FeuilleCalcul();
      FeuilleCalcul var5 = null;
      if (var2.size() != 0) {
         for(int var6 = 0; var6 < var2.size(); ++var6) {
            FeuilleCalcul var4 = (FeuilleCalcul)var2.get(var6);
            var5 = new FeuilleCalcul();
            var5.setExercicesPaye(this.exercicesNew);
            var5.setFeuCode(var4.getFeuCode());
            var5.setFeuCompte(var4.getFeuCompte());
            var5.setFeuDateCreat(new Date());
            var5.setFeuDateModif((Date)null);
            var5.setFeuDecale(var4.getFeuDecale());
            var5.setFeuInactif(var4.getFeuInactif());
            var5.setFeuJournal(var4.getFeuJournal());
            var5.setFeuLibelleFr(var4.getFeuLibelleFr());
            var5.setFeuLibelleSp(var4.getFeuLibelleSp());
            var5.setFeuLibelleUk(var4.getFeuLibelleUk());
            var5.setFeuModele(var4.getFeuModele());
            var5.setFeuNature(var4.getFeuNature());
            var5.setFeuUserCreat(this.usersLog.getUsrid());
            var5.setFeuUserModif(0L);
            var3.insert(var5, var1);
         }
      }

   }

   public void recopieRubrique(Session var1) throws HibernateException, NamingException {
      new PlanPaye();
      PlanPayeDao var3 = new PlanPayeDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      FeuilleCalculRubriqueDao var5 = new FeuilleCalculRubriqueDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      FeuilleCalculDao var7 = new FeuilleCalculDao(this.baseLog, this.utilInitHibernate);
      List var6 = var7.chargerFeuilles(this.exercicesPaye.getExepayId(), var1);
      if (var6.size() != 0) {
         new FeuilleCalcul();
         new FeuilleCalcul();
         new FeuilleCalculRubrique();
         FeuilleCalculRubrique var11 = null;

         for(int var12 = 0; var12 < var6.size(); ++var12) {
            FeuilleCalcul var8 = (FeuilleCalcul)var6.get(var12);
            List var4 = var5.chargerRubriqueFeuille(var8, var1);
            if (var4.size() != 0) {
               FeuilleCalcul var9 = var7.chercherCode(var8.getFeuCode(), this.exercicesNew.getExepayId(), var1);
               if (var9 != null) {
                  for(int var13 = 0; var13 < var4.size(); ++var13) {
                     FeuilleCalculRubrique var10 = (FeuilleCalculRubrique)var4.get(var13);
                     var11 = new FeuilleCalculRubrique();
                     var11.setFeuilleCalcul(var9);
                     PlanPaye var2 = var3.chercherCode(var10.getPlanPaye().getPlpCode(), this.exercicesNew.getExepayId(), var1);
                     if (var2 != null) {
                        var11.setPlanPaye(var2);
                        var11.setFeurubActif(var10.isFeurubActif());
                        var11.setFeurubCode(var10.getFeurubCode());
                        var11.setFeurubColA(var10.isFeurubColA());
                        var11.setFeurubColARaz(var10.isFeurubColARaz());
                        var11.setFeurubColB(var10.isFeurubColB());
                        var11.setFeurubColBRaz(var10.isFeurubColBRaz());
                        var11.setFeurubColC(var10.isFeurubColC());
                        var11.setFeurubColCRaz(var10.isFeurubColCRaz());
                        var11.setFeurubColD(var10.isFeurubColD());
                        var11.setFeurubColDRaz(var10.isFeurubColDRaz());
                        var11.setFeurubColE(var10.isFeurubColE());
                        var11.setFeurubColERaz(var10.isFeurubColERaz());
                        var11.setFeurubCompte(var10.getFeurubCompte());
                        var11.setFeurubVariableA(var10.isFeurubVariableA());
                        var11.setFeurubVariableB(var10.isFeurubVariableB());
                        var11.setFeurubVariableC(var10.isFeurubVariableC());
                        var11.setFeurubVariableD(var10.isFeurubVariableD());
                        var11.setFeurubVariableE(var10.isFeurubVariableE());
                        var5.insert(var11, var1);
                     }
                  }
               }
            }
         }
      }

   }

   public void recopieFormule(Session var1) throws HibernateException, NamingException {
      new ArrayList();
      FeuilleCalculFormuleDao var3 = new FeuilleCalculFormuleDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      FeuilleCalculRubriqueDao var5 = new FeuilleCalculRubriqueDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      FeuilleCalculDao var7 = new FeuilleCalculDao(this.baseLog, this.utilInitHibernate);
      List var6 = var7.chargerFeuilles(this.exercicesPaye.getExepayId(), var1);
      if (var6.size() != 0) {
         new FeuilleCalcul();
         new FeuilleCalcul();
         new FeuilleCalculRubrique();
         new FeuilleCalculRubrique();
         new FeuilleCalculFormule();
         FeuilleCalculFormule var13 = null;

         for(int var14 = 0; var14 < var6.size(); ++var14) {
            FeuilleCalcul var8 = (FeuilleCalcul)var6.get(var14);
            List var4 = var5.chargerRubriqueFeuille(var8, var1);
            if (var4.size() != 0) {
               FeuilleCalcul var9 = var7.chercherCode(var8.getFeuCode(), this.exercicesNew.getExepayId(), var1);
               if (var9 != null) {
                  for(int var15 = 0; var15 < var4.size(); ++var15) {
                     FeuilleCalculRubrique var10 = (FeuilleCalculRubrique)var4.get(var15);
                     List var2 = var3.chargerRubriqueFeuille(var10, var1);
                     if (var2.size() != 0) {
                        FeuilleCalculRubrique var11 = var5.chargerRubriqueFeuille((FeuilleCalcul)var9, var10.getFeurubCode(), 1, var1);
                        if (var11 != null) {
                           for(int var16 = 0; var16 < var2.size(); ++var16) {
                              FeuilleCalculFormule var12 = (FeuilleCalculFormule)var2.get(var16);
                              var13 = new FeuilleCalculFormule();
                              var13.setFeuilleCalcul(var9);
                              var13.setFeuilleCalculRubrique(var11);
                              var13.setFeurubforCode(var12.getFeurubforCode());
                              var13.setFeurubforColonne(var12.getFeurubforColonne());
                              var13.setFeurubforFormule(var12.getFeurubforFormule());
                              var3.insert(var13, var1);
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   public void calculHistorique(Session var1) throws HibernateException, NamingException, ParseException {
      double var2 = 0.0D;
      float var4 = 0.0F;
      double var5 = 0.0D;
      Date var7 = this.exercicesNew.getExepayDateDebut();
      new ArrayList();
      new BulletinLigne();
      BulletinLigneDao var10 = new BulletinLigneDao(this.baseLog, this.utilInitHibernate);
      Object var11 = new ArrayList();
      new SalariesContrats();
      SalariesContratsDao var13 = new SalariesContratsDao(this.baseLog, this.utilInitHibernate);
      new SalariesHistorique();
      SalariesHistoriqueDao var15 = new SalariesHistoriqueDao(this.baseLog, this.utilInitHibernate);
      ArrayList var16 = new ArrayList();
      Object var17 = new ArrayList();
      new BulletinSalaire();
      BulletinSalaireDao var19 = new BulletinSalaireDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      new Salaries();
      SalariesDao var22 = new SalariesDao(this.baseLog, this.utilInitHibernate);
      List var20 = var22.chargerlesSalariesActif("*", var1);
      if (var20.size() != 0) {
         for(int var23 = 0; var23 < var20.size(); ++var23) {
            Salaries var21 = (Salaries)var20.get(var23);
            ((List)var17).clear();
            var17 = var19.chargerlesBulletinsbySalarieExercice(var21, this.exercicesPaye, var1);
            if (((List)var17).size() != 0) {
               ((List)var11).clear();
               var11 = var13.chargerlesContrats(var21, var1);
               if (((List)var11).size() != 0) {
                  for(int var24 = 0; var24 < ((List)var11).size(); ++var24) {
                     SalariesContrats var12 = (SalariesContrats)((List)var11).get(var24);
                     var16.clear();

                     BulletinSalaire var18;
                     int var25;
                     for(var25 = 0; var25 < ((List)var17).size(); ++var25) {
                        var18 = (BulletinSalaire)((List)var17).get(var25);
                        if (var18.getBulsalContrat().equals(var12.getSalconNum())) {
                           var16.add(var18);
                        }
                     }

                     var2 = 0.0D;
                     var4 = 0.0F;
                     var5 = 0.0D;
                     if (var16.size() != 0) {
                        var25 = var16.size() - 1;
                        var18 = (BulletinSalaire)var16.get(var25);
                        var2 = var18.getBulsalBrut();
                        var4 = var18.getBulsalNbDispo();
                        List var8 = var10.chargerleslignesBulletin(var18, var1);
                        if (var8.size() != 0) {
                           for(int var26 = 0; var26 < var8.size(); ++var26) {
                              BulletinLigne var9 = (BulletinLigne)var8.get(var26);
                              if (var9.getBulligRubrique().equals("609100")) {
                                 var5 = var9.getBulligValColE();
                              }
                           }
                        }
                     }

                     SalariesHistorique var14;
                     if (var2 != 0.0D) {
                        var14 = new SalariesHistorique();
                        var14.setExercicesPaye(this.exercicesNew);
                        var14.setSalaries(var21);
                        var14.setSalhisCode("BRUT");
                        var14.setSalhisContrat(var12.getSalconNum());
                        var14.setSalhisDate(var7);
                        var14.setSalhisLibelle("Salaire Brut");
                        var14.setSalhisValeurColE(var2);
                        var15.insert(var14, var1);
                     }

                     if (var4 != 0.0F) {
                        var14 = new SalariesHistorique();
                        var14.setExercicesPaye(this.exercicesNew);
                        var14.setSalaries(var21);
                        var14.setSalhisCode("NBJS");
                        var14.setSalhisContrat(var12.getSalconNum());
                        var14.setSalhisDate(var7);
                        var14.setSalhisLibelle("Nombre de jours de congés acquis");
                        var14.setSalhisValeurColE((double)var4);
                        var15.insert(var14, var1);
                     }

                     if (var5 != 0.0D) {
                        var14 = new SalariesHistorique();
                        var14.setExercicesPaye(this.exercicesNew);
                        var14.setSalaries(var21);
                        var14.setSalhisCode("ADM");
                        var14.setSalhisContrat(var12.getSalconNum());
                        var14.setSalhisDate(var7);
                        var14.setSalhisLibelle("Appoint dernier mois");
                        var14.setSalhisValeurColE(var5);
                        var15.insert(var14, var1);
                     }
                  }
               }
            }
         }
      }

   }

   public void verificationContratActif(Session var1) throws HibernateException, NamingException {
      new ArrayList();
      new SalariesContrats();
      SalariesContratsDao var4 = new SalariesContratsDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      new Salaries();
      SalariesDao var7 = new SalariesDao(this.baseLog, this.utilInitHibernate);
      List var2 = var4.chargerlesContrats(var1);
      SalariesContrats var3;
      Salaries var6;
      int var8;
      if (var2.size() != 0) {
         for(var8 = 0; var8 < var2.size(); ++var8) {
            var3 = (SalariesContrats)var2.get(var8);
            var6 = var3.getSalaries();
            if (var3.getSalconEtat() <= 1 && var3.getSalconDateFin() != null && var3.getSalconDateFin().compareTo(this.exercicesPaye.getExepayDateFin()) <= 0) {
               var3.setSalconEtat(6);
               var4.modif(var3, var1);
            }
         }
      }

      List var5 = var7.chargerlesSalariesActif("*", var1);
      if (var5.size() != 0) {
         for(var8 = 0; var8 < var5.size(); ++var8) {
            var6 = (Salaries)var5.get(var8);
            var2 = var4.chargerlesContrats(var6, var1);
            if (var2.size() != 0) {
               boolean var9 = false;

               for(int var10 = 0; var10 < var2.size(); ++var10) {
                  var3 = (SalariesContrats)var2.get(var10);
                  if (var3.getSalconEtat() <= 1) {
                     var9 = true;
                     break;
                  }
               }

               if (!var9) {
                  var6.setSalEtat(6);
                  var7.modif(var6, var1);
               }
            }
         }
      }

   }

   public void recopieVariables(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      if (this.exercicesPaye.getExepayDateFin().getMonth() + 1 <= 9) {
         var2 = "0" + (this.exercicesPaye.getExepayDateFin().getMonth() + 1);
      } else {
         var2 = "" + (this.exercicesPaye.getExepayDateFin().getMonth() + 1);
      }

      String var3 = "" + (this.exercicesPaye.getExepayDateFin().getYear() + 1900);
      String var4 = var2 + ":" + var3;
      String var5 = "";
      if (this.exercicesNew.getExepayDateDebut().getMonth() + 1 <= 9) {
         var5 = "0" + (this.exercicesNew.getExepayDateDebut().getMonth() + 1);
      } else {
         var5 = "" + (this.exercicesNew.getExepayDateDebut().getMonth() + 1);
      }

      String var6 = "" + (this.exercicesNew.getExepayDateDebut().getYear() + 1900);
      String var7 = var5 + ":" + var6;
      new ArrayList();
      PlanPayeDao var9 = new PlanPayeDao(this.baseLog, this.utilInitHibernate);
      List var8 = var9.chargerPlanPaye(this.exercicesNew.getExepayId(), var1);
      new ArrayList();
      SalariesVariablesDao var11 = new SalariesVariablesDao(this.baseLog, this.utilInitHibernate);
      List var10 = var11.chargerlesVariables(var4, var1);
      if (var10.size() != 0) {
         new SalariesVariables();
         new SalariesVariables();

         for(int var14 = 0; var14 < var10.size(); ++var14) {
            SalariesVariables var13 = (SalariesVariables)var10.get(var14);
            SalariesVariables var12 = new SalariesVariables();
            var12.setPlanPaye((PlanPaye)null);
            if (var8.size() != 0) {
               for(int var15 = 0; var15 < var8.size(); ++var15) {
                  if (((PlanPaye)var8.get(var15)).getPlpCode().equals(var13.getSalvarCode())) {
                     var12.setPlanPaye((PlanPaye)var8.get(var15));
                     break;
                  }
               }
            }

            if (var12.getPlanPaye() != null) {
               var12.setSalaries(var13.getSalaries());
               var12.setSalvarCode(var13.getSalvarCode());
               var12.setSalvarContrat(var13.getSalvarContrat());
               var12.setSalvarFeuille(var13.getSalvarFeuille());
               var12.setSalvarJour((Date)null);
               var12.setSalvarPeriode(var7);
               var12.setSalvarValeurColA(var13.getSalvarValeurColA());
               var12.setSalvarValeurColB(var13.getSalvarValeurColB());
               var12.setSalvarValeurColC(var13.getSalvarValeurColC());
               var12.setSalvarValeurColD(var13.getSalvarValeurColD());
               var12.setSalvarValeurColE(var13.getSalvarValeurColE());
               var12.setSalvarVariableA(var13.isSalvarVariableA());
               var12.setSalvarVariableB(var13.isSalvarVariableB());
               var12.setSalvarVariableC(var13.isSalvarVariableC());
               var12.setSalvarVariableD(var13.isSalvarVariableD());
               var12.setSalvarVariableE(var13.isSalvarVariableE());
               var11.insert(var12, var1);
            }
         }
      }

      new ArrayList();
      SalariesElementsDao var18 = new SalariesElementsDao(this.baseLog, this.utilInitHibernate);
      List var17 = var18.chargerlesElements(var4, var1);
      if (var17.size() != 0) {
         new SalariesElements();
         new SalariesElements();

         for(int var16 = 0; var16 < var17.size(); ++var16) {
            SalariesElements var20 = (SalariesElements)var17.get(var16);
            SalariesElements var19 = new SalariesElements();
            var19.setEffectue(var20.isEffectue());
            var19.setSalaries(var20.getSalaries());
            var19.setSaleleActivite(var20.getSaleleActivite());
            var19.setSaleleBudget(var20.getSaleleBudget());
            var19.setSaleleCentresImpots(var20.getSaleleCentresImpots());
            var19.setSaleleCentresSecurite(var20.getSaleleCentresSecurite());
            var19.setSaleleCivilite(var20.getSaleleCivilite());
            var19.setSaleleClassement(var20.getSaleleClassement());
            var19.setSaleleCle1Anal(var20.getSaleleCle1Anal());
            var19.setSaleleCle2Anal(var20.getSaleleCle2Anal());
            var19.setSaleleCleBanque(var20.getSaleleCleBanque());
            var19.setSaleleCompteBanque(var20.getSaleleCompteBanque());
            var19.setSaleleCompteMembre(var20.getSaleleCompteMembre());
            var19.setSaleleContrat(var20.getSaleleContrat());
            var19.setSaleleConvention(var20.getSaleleConvention());
            var19.setSaleleDateConcubinage(var20.getSaleleDateConcubinage());
            var19.setSaleleDateDivorce(var20.getSaleleDateDivorce());
            var19.setSaleleDateEntree(var20.getSaleleDateEntree());
            var19.setSaleleDateMarie(var20.getSaleleDateMarie());
            var19.setSaleleDatePacs(var20.getSaleleDatePacs());
            var19.setSaleleDateSortie(var20.getSaleleDateSortie());
            var19.setSaleleDateVeuf(var20.getSaleleDateVeuf());
            var19.setSaleleDepartement(var20.getSaleleDepartement());
            var19.setSaleleDureeJour(var20.getSaleleDureeJour());
            var19.setSaleleEtat(var20.getSaleleEtat());
            var19.setSaleleFeuille(var20.getSaleleFeuille());
            var19.setSaleleFonction(var20.getSaleleFonction());
            var19.setSaleleGenre(var20.getSaleleGenre());
            var19.setSaleleGrille(var20.getSaleleGrille());
            var19.setSaleleGuichetBanque(var20.getSaleleGuichetBanque());
            var19.setSaleleIban(var20.getSaleleIban());
            var19.setSaleleJour(var20.getSaleleJour());
            var19.setSaleleLibCentresImpots(var20.getSaleleLibCentresImpots());
            var19.setSaleleLibCentresSecurite(var20.getSaleleLibCentresSecurite());
            var19.setSaleleLibClassement(var20.getSaleleLibClassement());
            var19.setSaleleLibCle1Anal(var20.getSaleleLibCle1Anal());
            var19.setSaleleLibCle2Anal(var20.getSaleleLibCle2Anal());
            var19.setSaleleLibConvention(var20.getSaleleLibConvention());
            var19.setSaleleLibGrille(var20.getSaleleLibGrille());
            var19.setSaleleLibNivEmploi(var20.getSaleleLibNivEmploi());
            var19.setSaleleLibService(var20.getSaleleLibService());
            var19.setSaleleLocalisation(var20.getSaleleLocalisation());
            var19.setSaleleMatricule(var20.getSaleleMatricule());
            var19.setSaleleModeReglement(var20.getSaleleModeReglement());
            var19.setSaleleModeSolde(var20.getSaleleModeSolde());
            var19.setSaleleMotifSortie(var20.getSaleleMotifSortie());
            var19.setSaleleNature(var20.getSaleleNature());
            var19.setSaleleNbEnfant(var20.getSaleleNbEnfant());
            var19.setSaleleNbFemme(var20.getSaleleNbFemme());
            var19.setSaleleNbJourCp(var20.getSaleleNbJourCp());
            var19.setSaleleNbJourTr(var20.getSaleleNbJourTr());
            var19.setSaleleNbPartFiscal(var20.getSaleleNbPartFiscal());
            var19.setSaleleNbPartTrimf(var20.getSaleleNbPartTrimf());
            var19.setSaleleNivEmploi(var20.getSaleleNivEmploi());
            var19.setSaleleNumBanque(var20.getSaleleNumBanque());
            var19.setSaleleParc(var20.getSaleleParc());
            var19.setSalelePeriode(var7);
            var19.setSaleleService(var20.getSaleleService());
            var19.setSaleleSitFamille(var20.getSaleleSitFamille());
            var19.setSaleleSite(var20.getSaleleSite());
            var19.setSaleleSwift(var20.getSaleleSwift());
            var18.insert(var19, var1);
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

   public void chargerLesExo() throws HibernateException, NamingException {
      this.lesexercicesPaye = this.recupererLesexercices((Session)null);
      this.madatamodel.setWrappedData(this.lesexercicesPaye);
   }

   public Date getDatecloture() {
      return this.datecloture;
   }

   public void setDatecloture(Date var1) {
      this.datecloture = var1;
   }

   public ExercicesPaye getExercicesPaye() {
      return this.exercicesPaye;
   }

   public void setExercicesPaye(ExercicesPaye var1) {
      this.exercicesPaye = var1;
   }

   public List getLesexercicesPaye() {
      return this.lesexercicesPaye;
   }

   public void setLesexercicesPaye(List var1) {
      this.lesexercicesPaye = var1;
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
