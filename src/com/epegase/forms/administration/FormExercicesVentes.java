package com.epegase.forms.administration;

import com.epegase.systeme.classe.AvoirEnteteVentes;
import com.epegase.systeme.classe.BesoinEnteteVentes;
import com.epegase.systeme.classe.CampagneEnteteVentes;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.CommandeEnteteVentes;
import com.epegase.systeme.classe.CommissionEnteteVentes;
import com.epegase.systeme.classe.ContratEnteteVentes;
import com.epegase.systeme.classe.DevisEnteteVentes;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FactureEnteteVentes;
import com.epegase.systeme.classe.FactureInterneEnteteVentes;
import com.epegase.systeme.classe.FamillesProduitsVentes;
import com.epegase.systeme.classe.FormulesVentes;
import com.epegase.systeme.classe.LivraisonEnteteVentes;
import com.epegase.systeme.classe.NoteDebitEnteteVentes;
import com.epegase.systeme.classe.RetourEnteteVentes;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.SuiviLivraisonVentes;
import com.epegase.systeme.classe.TaxesVentes;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.AvoirEnteteVentesDao;
import com.epegase.systeme.dao.BesoinEnteteVentesDao;
import com.epegase.systeme.dao.CampagneEnteteVentesDao;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.CommandeEnteteVentesDao;
import com.epegase.systeme.dao.CommissionEnteteVentesDao;
import com.epegase.systeme.dao.ContratEnteteVentesDao;
import com.epegase.systeme.dao.DevisEnteteVentesDao;
import com.epegase.systeme.dao.ExercicesVentesDao;
import com.epegase.systeme.dao.FactureEnteteVentesDao;
import com.epegase.systeme.dao.FactureInterneEnteteVentesDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.FormulesVentesDao;
import com.epegase.systeme.dao.LivraisonEnteteVentesDao;
import com.epegase.systeme.dao.NoteDebitEnteteVentesDao;
import com.epegase.systeme.dao.RetourEnteteVentesDao;
import com.epegase.systeme.dao.SuiviLivraisonVentesDao;
import com.epegase.systeme.dao.TaxesVentesDao;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.ObjetMessageSysteme;
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

public class FormExercicesVentes implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private transient DataModel madatamodel = new ListDataModel();
   private ExercicesVentes exercicesVentes = new ExercicesVentes();
   private ExercicesVentes exercicesNew;
   private List lesexercicesVentes = new ArrayList();
   private boolean testDateAj = true;
   private boolean noExo = false;
   private ExercicesVentesDao exoDao;
   private long leIdExo = 0L;
   private boolean disable;
   private List listExo = new ArrayList();
   private Date datecloture;
   private Date memoDateFin;
   private ObjetMessageSysteme obm = new ObjetMessageSysteme();
   private boolean var_showBarProg = false;
   private int var_currentValue;
   private int var_valueMax = 20;

   public FormExercicesVentes() throws IOException, JDOMException {
   }

   public void InstancesDaoUtilses() {
      this.exoDao = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerLesExo() throws HibernateException, NamingException {
      this.lesexercicesVentes = this.recupererLesexercices((Session)null);
      this.madatamodel.setWrappedData(this.lesexercicesVentes);
   }

   public ExercicesVentes recupererLastExo(Session var1) throws HibernateException, NamingException {
      ExercicesVentes var2 = this.exoDao.recupererLastExo(var1);
      return var2;
   }

   public List recupererLesexercices(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         var2 = true;
      }

      new ArrayList();
      List var3 = this.exoDao.selectExercicesVentes(var1);
      this.listExo = new ArrayList();
      if (var3.size() == 0) {
         this.noExo = true;
      } else {
         this.noExo = false;

         for(int var4 = 0; var4 < var3.size(); ++var4) {
            ExercicesVentes var5 = (ExercicesVentes)var3.get(var4);
            var5.setIndice(var4 + 1);
            String var6 = "dd-MM-yyyy";
            SimpleDateFormat var7 = new SimpleDateFormat(var6, Locale.FRANCE);
            String var8 = var7.format(var5.getExevteDateDebut());
            String var9 = var7.format(var5.getExevteDateFin());
            long var10 = var5.getExevteId();
            this.listExo.add(new SelectItem(var10, var8 + "...................." + var9));
         }
      }

      this.setLesexercicesVentes(var3);
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public void enregistrerExercicesVentes() throws IOException, JDOMException, SAXException, HibernateException, NamingException {
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

   }

   public void selectionLigneExercice() {
      if (this.madatamodel.isRowAvailable()) {
         this.exercicesVentes = (ExercicesVentes)this.madatamodel.getRowData();
         this.memoDateFin = this.exercicesVentes.getExevteDateFin();
      }

   }

   public void chargerDate() throws ParseException {
      this.exercicesVentes.setExevteDateDebut(this.debutinitial());
      this.exercicesVentes.setExevteDateFin(this.finalinitial());
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
               List var9 = var10.selectListVente(0, var7);
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
   }

   public void cloturer() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      if (this.exercicesVentes != null) {
         this.obm = new ObjetMessageSysteme();
         this.obm.setTexte("Initialisation de la cloture...");
         ++this.var_currentValue;
         this.genererNvlExo();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.recopieChronoVentes(var1);
            this.recopieFamilles(var1);
            this.recopieFormuleVentes(var1);
            this.recopieSuiviVentes(var1);
            this.recopieTaxesVentes(var1);
            this.changeExerciceCampagne(var1);
            this.changeExerciceBesoin(var1);
            this.changeExerciceDevis(var1);
            this.changeExerciceBc(var1);
            this.changeExerciceBl(var1);
            this.changeExerciceRetour(var1);
            this.changeExerciceFacture(var1);
            this.changeExerciceFactureInterne(var1);
            this.changeExerciceNdf(var1);
            this.changeExerciceAvoir(var1);
            this.changeExerciceContrat(var1);
            this.changeExerciceCommission(var1);
            var2.commit();
         } catch (HibernateException var7) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var7;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.exercicesVentes = this.exercicesNew;
         this.leIdExo = this.exercicesVentes.getExevteId();
         this.chargerLesExo();
      }

   }

   public void genererNvlExo() throws HibernateException, NamingException, ParseException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Creaton nouvel exercice...");
      ++this.var_currentValue;
      UtilDate var1 = new UtilDate();
      this.exercicesVentes.setExevteDateCloture(new Date());
      this.exercicesVentes.setExevteEtat(1);
      this.exercicesVentes.setExevteUserCloture(this.usersLog.getUsrid());
      this.exercicesVentes.setExevteDateFin(var1.dateDernierJourAnnee(this.exercicesVentes.getExevteDateDebut()));
      this.exercicesVentes = this.exoDao.modif(this.exercicesVentes);
      this.exercicesNew = new ExercicesVentes();
      this.exercicesNew.setExevteId(this.exercicesVentes.getExevteId() + 1L);
      this.exercicesNew.setExevteDateCreat(new Date());
      this.exercicesNew.setExevteUserCreat(this.usersLog.getUsrid());
      String var2 = var1.dateToStringSQLLight(this.exercicesVentes.getExevteDateDebut());
      String[] var3 = var2.split("-");
      String var4 = "";
      String var5 = "";
      long var6 = 0L;
      var4 = var3[2];
      var5 = var3[1];
      var6 = Long.parseLong(var3[0]) + 1L;
      var2 = var6 + "-" + var5 + "-" + var4;
      Date var8 = var1.stringToDateSQLLight(var2);
      this.exercicesNew.setExevteDateDebut(var8);
      this.exercicesNew.setExevteDateFin(var1.dateDernierJourAnnee(this.exercicesNew.getExevteDateDebut()));
      this.exercicesNew = this.exoDao.insert(this.exercicesNew);
   }

   public void recopieChronoVentes(Session var1) throws HibernateException, NamingException {
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
               String var7 = "" + this.exercicesVentes.getExevteId();
               if (var5.getChrPeriode().equals(var7)) {
                  var6.setChrPeriode("" + this.exercicesNew.getExevteId());
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

   public void recopieFamilles(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Recopie des familles...");
      ++this.var_currentValue;
      new ArrayList();
      FamillesProduitsVentesDao var3 = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
      List var2 = var3.selectAllFamillProd(this.exercicesVentes.getExevteId(), var1);
      if (var2.size() != 0) {
         new FamillesProduitsVentes();

         for(int var5 = 0; var5 < var2.size(); ++var5) {
            FamillesProduitsVentes var6 = new FamillesProduitsVentes();
            FamillesProduitsVentes var4 = (FamillesProduitsVentes)var2.get(var5);
            var6.setExerciceventes(this.exercicesNew);
            var6.setFamvteActivite(var4.getFamvteActivite());
            var6.setFamvteAnal2(var4.getFamvteAnal2());
            var6.setFamvteAnal4(var4.getFamvteAnal4());
            var6.setFamvteBudget(var4.getFamvteBudget());
            var6.setFamvteCat(var4.getFamvteCat());
            var6.setFamvteCode(var4.getFamvteCode());
            var6.setFamvteCompteExterieur(var4.getFamvteCompteExterieur());
            var6.setFamvteCompteLocal(var4.getFamvteCompteLocal());
            var6.setFamvteCompteProduit(var4.getFamvteCompteProduit());
            var6.setFamvteCompteStock(var4.getFamvteCompteStock());
            var6.setFamvteCompteZone(var4.getFamvteCompteZone());
            var6.setFamvteDateCreation(new Date());
            var6.setFamvteDateModif((Date)null);
            var6.setFamvteDepotVte(var4.getFamvteDepotVte());
            var6.setFamvteDouane(var4.getFamvteDouane());
            var6.setFamvteInactif(0);
            var6.setFamvteLibNature(var4.getFamvteLibNature());
            var6.setFamvteLibelleFr(var4.getFamvteLibelleFr());
            var6.setFamvteLibelleSp(var4.getFamvteLibelleSp());
            var6.setFamvteLibelleUk(var4.getFamvteLibelleUk());
            var6.setFamvteNature(var4.getFamvteNature());
            var6.setFamvteService(var4.getFamvteService());
            var6.setFamvteStock(var4.getFamvteStock());
            var6.setFamvteTaxe(var4.getFamvteTaxe());
            var6.setFamvteUserCreation(this.usersLog.getUsrid());
            var6.setFamvteUserModif(0L);
            var3.insert(var6, var1);
         }
      }

   }

   public void recopieFormuleVentes(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Recopie des formules...");
      ++this.var_currentValue;
      new ArrayList();
      FormulesVentesDao var3 = new FormulesVentesDao(this.baseLog, this.utilInitHibernate);
      List var2 = var3.selectFormulesVentes(this.exercicesVentes.getExevteId(), var1);
      if (var2.size() != 0) {
         for(int var4 = 0; var4 < var2.size(); ++var4) {
            new FormulesVentes();
            FormulesVentes var6 = new FormulesVentes();
            FormulesVentes var5 = (FormulesVentes)var2.get(var4);
            if (var5.getForvteInactif() == 0) {
               var6.setExerciceventes(this.exercicesNew);
               var6.setForvteDateCreation(new Date());
               var6.setForvteDateModif((Date)null);
               var6.setForvteInactif(0);
               var6.setForvteLibelleFr(var5.getForvteLibelleFr());
               var6.setForvteLibelleSp(var5.getForvteLibelleSp());
               var6.setForvteLibelleUk(var5.getForvteLibelleUk());
               var6.setForvteUserCreation(this.usersLog.getUsrid());
               var6.setForvteUserModif(0L);
               var3.insert(var6, var1);
            }
         }
      }

   }

   public void recopieSuiviVentes(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Recopie des suivis...");
      ++this.var_currentValue;
      new ArrayList();
      SuiviLivraisonVentesDao var3 = new SuiviLivraisonVentesDao(this.baseLog, this.utilInitHibernate);
      List var2 = var3.selectSuiviLivraisonVentes(this.exercicesVentes.getExevteId(), var1);
      if (var2.size() != 0) {
         for(int var4 = 0; var4 < var2.size(); ++var4) {
            new SuiviLivraisonVentes();
            SuiviLivraisonVentes var6 = new SuiviLivraisonVentes();
            SuiviLivraisonVentes var5 = (SuiviLivraisonVentes)var2.get(var4);
            if (var5.getSuivteInactif() == 0) {
               var6.setExerciceventes(this.exercicesNew);
               var6.setSuivteAerien(var5.isSuivteAerien());
               var6.setSuivteAutreTransit(var5.isSuivteAutreTransit());
               var6.setSuivteCode(var5.getSuivteCode());
               var6.setSuivteDateCreation(new Date());
               var6.setSuivteDateModif((Date)null);
               var6.setSuivteExpress(var5.isSuivteExpress());
               var6.setSuivteInactif(0);
               var6.setSuivteLibelleFr(var5.getSuivteLibelleFr());
               var6.setSuivteLibelleSp(var5.getSuivteLibelleSp());
               var6.setSuivteLibelleUk(var5.getSuivteLibelleUk());
               var6.setSuivteMaritime(var5.isSuivteMaritime());
               var6.setSuivteRoute(var5.isSuivteRoute());
               var6.setSuivteUserCreation(this.usersLog.getUsrid());
               var6.setSuivteUserModif(0L);
               var3.insert(var6, var1);
            }
         }
      }

   }

   public void recopieTaxesVentes(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Recopie des taxes...");
      ++this.var_currentValue;
      new ArrayList();
      TaxesVentesDao var3 = new TaxesVentesDao(this.baseLog, this.utilInitHibernate);
      List var2 = var3.selectTaxesVentes(this.exercicesVentes.getExevteId(), var1);
      if (var2.size() != 0) {
         for(int var4 = 0; var4 < var2.size(); ++var4) {
            new TaxesVentes();
            TaxesVentes var6 = new TaxesVentes();
            TaxesVentes var5 = (TaxesVentes)var2.get(var4);
            if (var5.getTaxvteInactif() == 0) {
               var6.setExerciceventes(this.exercicesNew);
               var6.setTaxvteCode(var5.getTaxvteCode());
               var6.setTaxvteCompte(var5.getTaxvteCompte());
               var6.setTaxvteDateCreation(new Date());
               var6.setTaxvteDateModif((Date)null);
               var6.setTaxvteInactif(0);
               var6.setTaxvteLibelleFr(var5.getTaxvteLibelleFr());
               var6.setTaxvteLibelleSp(var5.getTaxvteLibelleSp());
               var6.setTaxvteLibelleUk(var5.getTaxvteLibelleUk());
               var6.setTaxvteTaux(var5.getTaxvteTaux());
               var6.setTaxvteTc(var5.getTaxvteTc());
               var6.setTaxvteTimbre(var5.getTaxvteTimbre());
               var6.setTaxvteType(var5.getTaxvteType());
               var6.setTaxvteUserCreation(this.usersLog.getUsrid());
               var6.setTaxvteUserModif(0L);
               var3.insert(var6, var1);
            }
         }
      }

   }

   public void changeExerciceCampagne(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Change exercice des campagnes...");
      ++this.var_currentValue;
      new ArrayList();
      CampagneEnteteVentesDao var3 = new CampagneEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      new CampagneEnteteVentes();
      List var2 = var3.rechercheCampagneByDate(this.exercicesNew.getExevteDateDebut(), this.exercicesNew.getExevteDateFin(), var1);
      if (var2.size() != 0) {
         for(int var5 = 0; var5 < var2.size(); ++var5) {
            CampagneEnteteVentes var4 = (CampagneEnteteVentes)var2.get(var5);
            var4.setExerciceventes(this.exercicesNew);
            var3.modif(var4, var1);
         }
      }

      var1.flush();
   }

   public void changeExerciceBesoin(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Change exercice des besoins...");
      ++this.var_currentValue;
      new ArrayList();
      BesoinEnteteVentesDao var3 = new BesoinEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      new BesoinEnteteVentes();
      List var2 = var3.rechercheBesoinByDate(this.exercicesNew.getExevteDateDebut(), this.exercicesNew.getExevteDateFin(), var1);
      if (var2.size() != 0) {
         for(int var5 = 0; var5 < var2.size(); ++var5) {
            BesoinEnteteVentes var4 = (BesoinEnteteVentes)var2.get(var5);
            var4.setExerciceventes(this.exercicesNew);
            var3.modif(var4, var1);
         }
      }

      var1.flush();
   }

   public void changeExerciceDevis(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Change exercice des devis...");
      ++this.var_currentValue;
      new ArrayList();
      DevisEnteteVentesDao var3 = new DevisEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      new DevisEnteteVentes();
      List var2 = var3.rechercheDevisByDate(this.exercicesNew.getExevteDateDebut(), this.exercicesNew.getExevteDateFin(), var1);
      if (var2.size() != 0) {
         for(int var5 = 0; var5 < var2.size(); ++var5) {
            DevisEnteteVentes var4 = (DevisEnteteVentes)var2.get(var5);
            var4.setExerciceventes(this.exercicesNew);
            var3.modif(var4, var1);
         }
      }

      var1.flush();
   }

   public void changeExerciceBc(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Change exercice des commandes...");
      ++this.var_currentValue;
      new ArrayList();
      CommandeEnteteVentesDao var3 = new CommandeEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      new CommandeEnteteVentes();
      List var2 = var3.rechercheCommandeByDate(this.exercicesNew.getExevteDateDebut(), this.exercicesNew.getExevteDateFin(), var1);
      if (var2.size() != 0) {
         for(int var5 = 0; var5 < var2.size(); ++var5) {
            CommandeEnteteVentes var4 = (CommandeEnteteVentes)var2.get(var5);
            var4.setExerciceventes(this.exercicesNew);
            var3.modif(var4, var1);
         }
      }

      var1.flush();
   }

   public void changeExerciceBl(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Change exercice des livraisons...");
      ++this.var_currentValue;
      new ArrayList();
      LivraisonEnteteVentesDao var3 = new LivraisonEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      new LivraisonEnteteVentes();
      List var2 = var3.rechercheLivraisonByDate(this.exercicesNew.getExevteDateDebut(), this.exercicesNew.getExevteDateFin(), var1);
      if (var2.size() != 0) {
         for(int var5 = 0; var5 < var2.size(); ++var5) {
            LivraisonEnteteVentes var4 = (LivraisonEnteteVentes)var2.get(var5);
            var4.setExerciceventes(this.exercicesNew);
            var3.modif(var4, var1);
         }
      }

      var1.flush();
   }

   public void changeExerciceRetour(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Change exercice des retours...");
      ++this.var_currentValue;
      new ArrayList();
      RetourEnteteVentesDao var3 = new RetourEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      new RetourEnteteVentes();
      List var2 = var3.rechercheRetourByDate(this.exercicesNew.getExevteDateDebut(), this.exercicesNew.getExevteDateFin(), var1);
      if (var2.size() != 0) {
         for(int var5 = 0; var5 < var2.size(); ++var5) {
            RetourEnteteVentes var4 = (RetourEnteteVentes)var2.get(var5);
            var4.setExerciceventes(this.exercicesNew);
            var3.modif(var4, var1);
         }
      }

      var1.flush();
   }

   public void changeExerciceFacture(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Change exercice des factures...");
      ++this.var_currentValue;
      new ArrayList();
      FactureEnteteVentesDao var3 = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      new FactureEnteteVentes();
      UtilDate var5 = new UtilDate();
      String var6 = var5.dateToStringSQLLight(this.exercicesNew.getExevteDateDebut()) + " 00:00:00";
      String var7 = var5.dateToStringSQLLight(this.exercicesNew.getExevteDateFin()) + " 23:59:59";
      List var2 = var3.rechercheFactureByDate(var6, var7, var1);
      if (var2.size() != 0) {
         for(int var8 = 0; var8 < var2.size(); ++var8) {
            FactureEnteteVentes var4 = (FactureEnteteVentes)var2.get(var8);
            var4.setExerciceventes(this.exercicesNew);
            var3.modif(var4, var1);
         }
      }

      var1.flush();
   }

   public void changeExerciceFactureInterne(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Change exercice des factures internes...");
      ++this.var_currentValue;
      new ArrayList();
      FactureInterneEnteteVentesDao var3 = new FactureInterneEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      new FactureInterneEnteteVentes();
      List var2 = var3.rechercheFactureInterneByDate(this.exercicesNew.getExevteDateDebut(), this.exercicesNew.getExevteDateFin(), var1);
      if (var2.size() != 0) {
         for(int var5 = 0; var5 < var2.size(); ++var5) {
            FactureInterneEnteteVentes var4 = (FactureInterneEnteteVentes)var2.get(var5);
            var4.setExerciceventes(this.exercicesNew);
            var3.modif(var4, var1);
         }
      }

      var1.flush();
   }

   public void changeExerciceNdf(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Change exercice des notes de debit...");
      ++this.var_currentValue;
      new ArrayList();
      NoteDebitEnteteVentesDao var3 = new NoteDebitEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      new NoteDebitEnteteVentes();
      List var2 = var3.rechercheNoteDebitByDate(this.exercicesNew.getExevteDateDebut(), this.exercicesNew.getExevteDateFin(), var1);
      if (var2.size() != 0) {
         for(int var5 = 0; var5 < var2.size(); ++var5) {
            NoteDebitEnteteVentes var4 = (NoteDebitEnteteVentes)var2.get(var5);
            var4.setExerciceventes(this.exercicesNew);
            var3.modif(var4, var1);
         }
      }

      var1.flush();
   }

   public void changeExerciceAvoir(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Change exercice des avoirs...");
      ++this.var_currentValue;
      new ArrayList();
      AvoirEnteteVentesDao var3 = new AvoirEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      new AvoirEnteteVentes();
      List var2 = var3.rechercheAvoirByDate(this.exercicesNew.getExevteDateDebut(), this.exercicesNew.getExevteDateFin(), var1);
      if (var2.size() != 0) {
         for(int var5 = 0; var5 < var2.size(); ++var5) {
            AvoirEnteteVentes var4 = (AvoirEnteteVentes)var2.get(var5);
            var4.setExerciceventes(this.exercicesNew);
            var3.modif(var4, var1);
         }
      }

      var1.flush();
   }

   public void changeExerciceContrat(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Change exercice des contrats...");
      ++this.var_currentValue;
      new ArrayList();
      ContratEnteteVentesDao var3 = new ContratEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      new ContratEnteteVentes();
      List var2 = var3.rechercheFactureByDate(this.exercicesNew.getExevteDateDebut(), this.exercicesNew.getExevteDateFin(), var1);
      if (var2.size() != 0) {
         for(int var5 = 0; var5 < var2.size(); ++var5) {
            ContratEnteteVentes var4 = (ContratEnteteVentes)var2.get(var5);
            var4.setExerciceventes(this.exercicesNew);
            var3.modif(var4, var1);
         }
      }

      var1.flush();
   }

   public void changeExerciceCommission(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Change exercice des commissions...");
      ++this.var_currentValue;
      new ArrayList();
      CommissionEnteteVentesDao var3 = new CommissionEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      new CommissionEnteteVentes();
      List var2 = var3.rechercheCommissionByDate(this.exercicesNew.getExevteDateDebut(), this.exercicesNew.getExevteDateFin(), var1);
      if (var2.size() != 0) {
         for(int var5 = 0; var5 < var2.size(); ++var5) {
            CommissionEnteteVentes var4 = (CommissionEnteteVentes)var2.get(var5);
            var4.setExerciceventes(this.exercicesNew);
            var3.modif(var4, var1);
         }
      }

      var1.flush();
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
