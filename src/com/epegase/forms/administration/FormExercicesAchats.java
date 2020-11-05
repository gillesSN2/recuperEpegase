package com.epegase.forms.administration;

import com.epegase.systeme.classe.AvoirEnteteAchats;
import com.epegase.systeme.classe.BonEntreeEntete;
import com.epegase.systeme.classe.BonSortieEntete;
import com.epegase.systeme.classe.CessionEntete;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.CommandeEnteteAchats;
import com.epegase.systeme.classe.CotationEnteteAchats;
import com.epegase.systeme.classe.DemandeEnteteAchats;
import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.FabricationEnteteAchats;
import com.epegase.systeme.classe.FactureEnteteAchats;
import com.epegase.systeme.classe.FamillesProduitsAchats;
import com.epegase.systeme.classe.FormulesAchats;
import com.epegase.systeme.classe.FraisEnteteAchats;
import com.epegase.systeme.classe.InventaireEntete;
import com.epegase.systeme.classe.NoteDebitEnteteAchats;
import com.epegase.systeme.classe.ReceptionEnteteAchats;
import com.epegase.systeme.classe.RetourEnteteAchats;
import com.epegase.systeme.classe.SommierEnteteAchats;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.TaxesAchats;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.ValorisationEnteteAchats;
import com.epegase.systeme.dao.AvoirEnteteAchatsDao;
import com.epegase.systeme.dao.BonEntreeEnteteDao;
import com.epegase.systeme.dao.BonSortieEnteteDao;
import com.epegase.systeme.dao.CessionEnteteDao;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.CommandeEnteteAchatsDao;
import com.epegase.systeme.dao.CotationEnteteAchatsDao;
import com.epegase.systeme.dao.DemandeEnteteAchatsDao;
import com.epegase.systeme.dao.ExercicesAchatsDao;
import com.epegase.systeme.dao.FabricationEnteteAchatsDao;
import com.epegase.systeme.dao.FactureEnteteAchatsDao;
import com.epegase.systeme.dao.FamillesProduitsAchatsDao;
import com.epegase.systeme.dao.FormulesAchatsDao;
import com.epegase.systeme.dao.FraisEnteteAchatsDao;
import com.epegase.systeme.dao.InventaireEnteteDao;
import com.epegase.systeme.dao.NoteDebitEnteteAchatsDao;
import com.epegase.systeme.dao.ReceptionEnteteAchatsDao;
import com.epegase.systeme.dao.RetourEnteteAchatsDao;
import com.epegase.systeme.dao.SommierEnteteAchatsDao;
import com.epegase.systeme.dao.TaxesAchatsDao;
import com.epegase.systeme.dao.ValorisationEnteteAchatsDao;
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

public class FormExercicesAchats implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private transient DataModel madatamodel;
   private ExercicesAchats exercicesAchats;
   private ExercicesAchats exercicesNew;
   private List lesexercicesAchats;
   private boolean testDateAj;
   private boolean noExo;
   Locale locale = Locale.getDefault();
   DateFormat dateFormat;
   private ExercicesAchatsDao exoDao;
   private long leIdExo;
   private boolean disable;
   List listExo;
   private Date datecloture;
   private Date memoDateFin;
   private ObjetMessageSysteme obm;
   private boolean var_showBarProg;
   private int var_currentValue;
   private int var_valueMax;

   public FormExercicesAchats() throws IOException, JDOMException {
      this.dateFormat = DateFormat.getDateInstance(0, this.locale);
      this.leIdExo = 0L;
      this.var_showBarProg = false;
      this.var_valueMax = 22;
      this.exercicesAchats = new ExercicesAchats();
      this.lesexercicesAchats = new ArrayList();
      this.testDateAj = true;
      this.listExo = new ArrayList();
      this.noExo = false;
      this.madatamodel = new ListDataModel();
      this.obm = new ObjetMessageSysteme();
   }

   public void InstancesDaoUtilses() {
      this.exoDao = new ExercicesAchatsDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerLesExo() throws HibernateException, NamingException { //List
      this.lesexercicesAchats = this.recupererLesexercices((Session)null);
      this.madatamodel.setWrappedData(this.lesexercicesAchats);
   }

   public ExercicesAchats recupererLastExo(Session var1) throws HibernateException, NamingException {
      ExercicesAchats var2 = this.exoDao.recupererLastExo(var1);
      return var2;
   }

   public List recupererLesexercices(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         var2 = true;
      }

      new ArrayList();
      List var3 = this.exoDao.selectExercicesAchats(var1);
      this.listExo = new ArrayList();
      if (var3.size() == 0) {
         this.noExo = true;
      } else {
         this.noExo = false;

         for(int var4 = 0; var4 < var3.size(); ++var4) {
            ExercicesAchats var5 = (ExercicesAchats)var3.get(var4);
            var5.setIndice(var4 + 1);
            String var6 = "dd-MM-yyyy";
            SimpleDateFormat var7 = new SimpleDateFormat(var6, Locale.FRANCE);
            String var8 = var7.format(var5.getExeachDateDebut());
            String var9 = var7.format(var5.getExeachDateFin());
            long var10 = var5.getExeachId();
            this.listExo.add(new SelectItem(var10, var8 + "...................." + var9));
         }
      }

      this.setLesexercicesAchats(var3);
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public void enregistrerExercicesAchats() throws IOException, JDOMException, SAXException, HibernateException, NamingException {
      Date var1 = this.exercicesAchats.getExeachDateDebut();
      Date var2 = this.exercicesAchats.getExeachDateFin();
      if (var1.after(var2)) {
         this.testDateAj = false;
      } else {
         this.testDateAj = true;
         int var3 = var1.getYear() + 1900;
         this.exercicesAchats.setExeachId((long)var3);
         this.exercicesAchats.setExeachUserCreat(this.usersLog.getUsrid());
         this.exercicesAchats.setExeachUserModif(0L);
         this.exercicesAchats.setExeachDateCreat(new Date());
         this.exercicesAchats.setExeachDateModif((Date)null);
         Object var4 = new ArrayList();
         if (this.madatamodel.getRowCount() > 0) {
            var4 = (List)this.madatamodel.getWrappedData();
         }

         int var5 = this.madatamodel.getRowCount() + 2;
         this.exercicesAchats.setIndice(var5);
         ((List)var4).add(this.exercicesAchats);
         this.madatamodel.setWrappedData(var4);
         Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         Transaction var7 = null;

         try {
            var7 = var6.beginTransaction();
            this.exercicesAchats = this.exoDao.insert(this.exercicesAchats, var6);
            this.lesexercicesAchats.add(this.exercicesAchats);
            this.madatamodel.setWrappedData(this.lesexercicesAchats);
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
         this.exercicesAchats = (ExercicesAchats)this.madatamodel.getRowData();
         this.memoDateFin = this.exercicesAchats.getExeachDateFin();
      }

   }

   public void chargerDate() throws ParseException {
      this.exercicesAchats.setExeachDateDebut(this.debutinitial());
      this.exercicesAchats.setExeachDateFin(this.finalinitial());
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
      String var3 = var2.format(this.exercicesAchats.getExeachDateDebut());
      Date var4 = var2.parse(var3);
      String var5 = var2.format(this.exercicesAchats.getExeachDateFin());
      Date var6 = var2.parse(var5);
      if (!var4.after(var6)) {
         Session var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         Transaction var8 = null;

         try {
            var8 = var7.beginTransaction();
            this.exercicesAchats.setExeachUserModif(this.usersLog.getUsrid());
            this.exercicesAchats.setExeachDateModif(new Date());
            this.exercicesAchats = this.exoDao.modif(this.exercicesAchats, var7);
            if (this.exercicesAchats.getExeachDateFin().getYear() + 1900 != this.memoDateFin.getYear() + 1900) {
               new ArrayList();
               ChronoDao var10 = new ChronoDao(this.baseLog, this.utilInitHibernate);
               List var9 = var10.selectListAchat(0, var7);
               if (var9.size() != 0) {
                  new Chrono();

                  for(int var12 = 0; var12 < var9.size(); ++var12) {
                     Chrono var11 = (Chrono)var9.get(var12);
                     if (var11.getChrPeriode() != null && !var11.getChrPeriode().isEmpty()) {
                        String var13 = "" + (this.memoDateFin.getYear() + 1900);
                        if (var11.getChrPeriode().equals(var13)) {
                           Chrono var14 = new Chrono();
                           var14.setChrPeriode("" + (this.exercicesAchats.getExeachDateFin().getYear() + 1900));
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

      this.lesexercicesAchats = this.recupererLesexercices((Session)null);
      this.madatamodel.setWrappedData(this.lesexercicesAchats);
   }

   public void cloturer() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      if (this.exercicesAchats != null) {
         this.obm = new ObjetMessageSysteme();
         this.obm.setTexte("Initialisation de la cloture...");
         ++this.var_currentValue;
         this.genererNvlExo();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertAch");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.recopieChronoAchats(var1);
            this.recopieFamilles(var1);
            this.recopieFormuleAchats(var1);
            this.recopieTaxesAchats(var1);
            this.changeExerciceDemande(var1);
            this.changeExerciceCotation(var1);
            this.changeExerciceCommande(var1);
            this.changeExerciceReception(var1);
            this.changeExerciceRetour(var1);
            this.changeExerciceFacure(var1);
            this.changeExerciceNdf(var1);
            this.changeExerciceAvoir(var1);
            this.changeExerciceFrais(var1);
            this.changeExerciceValorisation(var1);
            this.changeExerciceSommier(var1);
            this.changeExerciceInventaire(var1);
            this.changeExerciceBEntree(var1);
            this.changeExerciceBSortie(var1);
            this.changeExerciceCession(var1);
            this.changeExerciceProduction(var1);
            var2.commit();
         } catch (HibernateException var7) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var7;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.exercicesAchats = this.exercicesNew;
         this.leIdExo = this.exercicesAchats.getExeachId();
         this.chargerLesExo();
      }

   }

   public void genererNvlExo() throws HibernateException, NamingException, ParseException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Creaton nouvel exercice...");
      ++this.var_currentValue;
      UtilDate var1 = new UtilDate();
      this.exercicesAchats.setExeachDateCloture(new Date());
      this.exercicesAchats.setExeachEtat(1);
      this.exercicesAchats.setExeachUserCloture(this.usersLog.getUsrid());
      this.exercicesAchats.setExeachDateFin(var1.dateDernierJourAnnee(this.exercicesAchats.getExeachDateDebut()));
      this.exercicesAchats = this.exoDao.modif(this.exercicesAchats);
      this.exercicesNew = new ExercicesAchats();
      this.exercicesNew.setExeachId(this.exercicesAchats.getExeachId() + 1L);
      this.exercicesNew.setExeachDateCreat(new Date());
      this.exercicesNew.setExeachUserCreat(this.usersLog.getUsrid());
      String var2 = var1.dateToStringSQLLight(this.exercicesAchats.getExeachDateDebut());
      String[] var3 = var2.split("-");
      String var4 = "";
      String var5 = "";
      long var6 = 0L;
      var4 = var3[2];
      var5 = var3[1];
      var6 = Long.parseLong(var3[0]) + 1L;
      var2 = var6 + "-" + var5 + "-" + var4;
      Date var8 = var1.stringToDateSQLLight(var2);
      this.exercicesNew.setExeachDateDebut(var8);
      this.exercicesNew.setExeachDateFin(var1.dateDernierJourAnnee(this.exercicesNew.getExeachDateDebut()));
      this.exercicesNew = this.exoDao.insert(this.exercicesNew);
   }

   public void recopieChronoAchats(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Recopie des chronos...");
      ++this.var_currentValue;
      new ArrayList();
      ChronoDao var3 = new ChronoDao(this.baseLog, this.utilInitHibernate);
      List var2 = var3.selectListAchat(0, var1);
      if (var2.size() != 0) {
         new Chrono();

         for(int var5 = 0; var5 < var2.size(); ++var5) {
            Chrono var4 = (Chrono)var2.get(var5);
            if (var4.getChrPeriode() != null && !var4.getChrPeriode().isEmpty()) {
               String var6 = "" + this.exercicesAchats.getExeachId();
               if (var4.getChrPeriode().equals(var6)) {
                  Chrono var7 = new Chrono();
                  var7.setChrPeriode("" + this.exercicesNew.getExeachId());
                  var7.setChrFormat(var4.getChrFormat());
                  var7.setChrJournal(var4.getChrJournal());
                  var7.setChrMode(var4.getChrMode());
                  var7.setChrNature(var4.getChrNature());
                  var7.setChrNbCar(var4.getChrNbCar());
                  var7.setChrNom(var4.getChrNom());
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

   public void recopieFamilles(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Recopie des familles...");
      ++this.var_currentValue;
      new ArrayList();
      FamillesProduitsAchatsDao var3 = new FamillesProduitsAchatsDao(this.baseLog, this.utilInitHibernate);
      List var2 = var3.selectAllFamillProd(this.exercicesAchats.getExeachId(), var1);
      if (var2.size() != 0) {
         new FamillesProduitsAchats();

         for(int var5 = 0; var5 < var2.size(); ++var5) {
            FamillesProduitsAchats var6 = new FamillesProduitsAchats();
            FamillesProduitsAchats var4 = (FamillesProduitsAchats)var2.get(var5);
            var6.setExercicesAchats(this.exercicesNew);
            var6.setFamachActivite(var4.getFamachActivite());
            var6.setFamachAnal2(var4.getFamachAnal2());
            var6.setFamachAnal4(var4.getFamachAnal4());
            var6.setFamachBudget(var4.getFamachBudget());
            var6.setFamachCat(var4.getFamachCat());
            var6.setFamachCode(var4.getFamachCode());
            var6.setFamachCompteExterieur(var4.getFamachCompteExterieur());
            var6.setFamachCompteLocal(var4.getFamachCompteLocal());
            var6.setFamachCompteCharge(var4.getFamachCompteCharge());
            var6.setFamachCompteStock(var4.getFamachCompteStock());
            var6.setFamachCompteZone(var4.getFamachCompteZone());
            var6.setFamachDateCreation(new Date());
            var6.setFamachDateModif((Date)null);
            var6.setFamachDepotAch(var4.getFamachDepotAch());
            var6.setFamachDepotPrd(var4.getFamachDepotPrd());
            var6.setFamachDouane(var4.getFamachDouane());
            var6.setFamachInactif(0);
            var6.setFamachLibNature(var4.getFamachLibNature());
            var6.setFamachLibelleFr(var4.getFamachLibelleFr());
            var6.setFamachLibelleSp(var4.getFamachLibelleSp());
            var6.setFamachLibelleUk(var4.getFamachLibelleUk());
            var6.setFamachNature(var4.getFamachNature());
            var6.setFamachService(var4.getFamachService());
            var6.setFamachStock(var4.getFamachStock());
            var6.setFamachTaxe(var4.getFamachTaxe());
            var6.setFamachUserCreation(this.usersLog.getUsrid());
            var6.setFamachUserModif(0L);
            var3.insert(var6, var1);
         }
      }

   }

   public void recopieFormuleAchats(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Recopie des formules...");
      ++this.var_currentValue;
      new ArrayList();
      FormulesAchatsDao var3 = new FormulesAchatsDao(this.baseLog, this.utilInitHibernate);
      List var2 = var3.selectFormulesAchats(this.exercicesAchats.getExeachId(), var1);
      if (var2.size() != 0) {
         for(int var4 = 0; var4 < var2.size(); ++var4) {
            new FormulesAchats();
            FormulesAchats var6 = new FormulesAchats();
            FormulesAchats var5 = (FormulesAchats)var2.get(var4);
            if (var5.getForachInactif() == 0) {
               var6.setExercicesAchats(this.exercicesNew);
               var6.setForachDateCreation(new Date());
               var6.setForachDateModif((Date)null);
               var6.setForachInactif(0);
               var6.setForachLibelleFr(var5.getForachLibelleFr());
               var6.setForachLibelleSp(var5.getForachLibelleSp());
               var6.setForachLibelleUk(var5.getForachLibelleUk());
               var6.setForachUserCreation(this.usersLog.getUsrid());
               var6.setForachUserModif(0L);
               var3.insert(var6, var1);
            }
         }
      }

   }

   public void recopieTaxesAchats(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Recopie des taxes...");
      ++this.var_currentValue;
      new ArrayList();
      TaxesAchatsDao var3 = new TaxesAchatsDao(this.baseLog, this.utilInitHibernate);
      List var2 = var3.selectTaxesAchats(this.exercicesAchats.getExeachId(), var1);
      if (var2.size() != 0) {
         for(int var4 = 0; var4 < var2.size(); ++var4) {
            new TaxesAchats();
            TaxesAchats var6 = new TaxesAchats();
            TaxesAchats var5 = (TaxesAchats)var2.get(var4);
            if (var5.getTaxachInactif() == 0) {
               var6.setExercicesachats(this.exercicesNew);
               var6.setTaxachCode(var5.getTaxachCode());
               var6.setTaxachCompte(var5.getTaxachCompte());
               var6.setTaxachDateCreation(new Date());
               var6.setTaxachDateModif((Date)null);
               var6.setTaxachInactif(0);
               var6.setTaxachLibelleFr(var5.getTaxachLibelleFr());
               var6.setTaxachLibelleSp(var5.getTaxachLibelleSp());
               var6.setTaxachLibelleUk(var5.getTaxachLibelleUk());
               var6.setTaxachTaux(var5.getTaxachTaux());
               var6.setTaxachTc(var5.getTaxachTc());
               var6.setTaxachTimbre(var5.getTaxachTimbre());
               var6.setTaxachType(var5.getTaxachType());
               var6.setTaxachUserCreation(this.usersLog.getUsrid());
               var6.setTaxachUserModif(0L);
               var3.insert(var6, var1);
            }
         }
      }

   }

   public void changeExerciceDemande(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Change exercice des demandes achats...");
      ++this.var_currentValue;
      new ArrayList();
      DemandeEnteteAchatsDao var3 = new DemandeEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      new DemandeEnteteAchats();
      List var2 = var3.rechercheDemandeByDate(this.exercicesNew.getExeachDateDebut(), this.exercicesNew.getExeachDateFin(), var1);
      if (var2.size() != 0) {
         for(int var5 = 0; var5 < var2.size(); ++var5) {
            DemandeEnteteAchats var4 = (DemandeEnteteAchats)var2.get(var5);
            var4.setExercicesAchats(this.exercicesNew);
            var3.modif(var4, var1);
         }
      }

      var1.flush();
   }

   public void changeExerciceCotation(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Change exercice des cotations...");
      ++this.var_currentValue;
      new ArrayList();
      CotationEnteteAchatsDao var3 = new CotationEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      new CotationEnteteAchats();
      List var2 = var3.rechercheCotationByDate(this.exercicesNew.getExeachDateDebut(), this.exercicesNew.getExeachDateFin(), var1);
      if (var2.size() != 0) {
         for(int var5 = 0; var5 < var2.size(); ++var5) {
            CotationEnteteAchats var4 = (CotationEnteteAchats)var2.get(var5);
            var4.setExercicesAchats(this.exercicesNew);
            var3.modif(var4, var1);
         }
      }

      var1.flush();
   }

   public void changeExerciceCommande(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Change exercice des commandes...");
      ++this.var_currentValue;
      new ArrayList();
      CommandeEnteteAchatsDao var3 = new CommandeEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      new CommandeEnteteAchats();
      List var2 = var3.rechercheCommandeByDate(this.exercicesNew.getExeachDateDebut(), this.exercicesNew.getExeachDateFin(), var1);
      if (var2.size() != 0) {
         for(int var5 = 0; var5 < var2.size(); ++var5) {
            CommandeEnteteAchats var4 = (CommandeEnteteAchats)var2.get(var5);
            var4.setExercicesAchats(this.exercicesNew);
            var3.modif(var4, var1);
         }
      }

      var1.flush();
   }

   public void changeExerciceReception(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Change exercice des réceptions...");
      ++this.var_currentValue;
      new ArrayList();
      ReceptionEnteteAchatsDao var3 = new ReceptionEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      new ReceptionEnteteAchats();
      UtilDate var5 = new UtilDate();
      String var6 = var5.dateToStringSQLLight(this.exercicesNew.getExeachDateDebut()) + " 00:00:00";
      String var7 = var5.dateToStringSQLLight(this.exercicesNew.getExeachDateFin()) + " 23:59:59";
      List var2 = var3.rechercheReceptionByDate(var6, var7, var1);
      if (var2.size() != 0) {
         for(int var8 = 0; var8 < var2.size(); ++var8) {
            ReceptionEnteteAchats var4 = (ReceptionEnteteAchats)var2.get(var8);
            var4.setExercicesAchats(this.exercicesNew);
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
      RetourEnteteAchatsDao var3 = new RetourEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      new RetourEnteteAchats();
      List var2 = var3.rechercheRetourByDate(this.exercicesNew.getExeachDateDebut(), this.exercicesNew.getExeachDateFin(), var1);
      if (var2.size() != 0) {
         for(int var5 = 0; var5 < var2.size(); ++var5) {
            RetourEnteteAchats var4 = (RetourEnteteAchats)var2.get(var5);
            var4.setExercicesAchats(this.exercicesNew);
            var3.modif(var4, var1);
         }
      }

      var1.flush();
   }

   public void changeExerciceFacure(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Change exercice des factures...");
      ++this.var_currentValue;
      new ArrayList();
      FactureEnteteAchatsDao var3 = new FactureEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      new FactureEnteteAchats();
      List var2 = var3.rechercheFactureByDate(this.exercicesNew.getExeachDateDebut(), this.exercicesNew.getExeachDateFin(), var1);
      if (var2.size() != 0) {
         for(int var5 = 0; var5 < var2.size(); ++var5) {
            FactureEnteteAchats var4 = (FactureEnteteAchats)var2.get(var5);
            var4.setExercicesAchats(this.exercicesNew);
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
      NoteDebitEnteteAchatsDao var3 = new NoteDebitEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      new NoteDebitEnteteAchats();
      List var2 = var3.rechercheNoteDebitByDate(this.exercicesNew.getExeachDateDebut(), this.exercicesNew.getExeachDateFin(), var1);
      if (var2.size() != 0) {
         for(int var5 = 0; var5 < var2.size(); ++var5) {
            NoteDebitEnteteAchats var4 = (NoteDebitEnteteAchats)var2.get(var5);
            var4.setExercicesAchats(this.exercicesNew);
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
      AvoirEnteteAchatsDao var3 = new AvoirEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      new AvoirEnteteAchats();
      List var2 = var3.rechercheAvoirByDate(this.exercicesNew.getExeachDateDebut(), this.exercicesNew.getExeachDateFin(), var1);
      if (var2.size() != 0) {
         for(int var5 = 0; var5 < var2.size(); ++var5) {
            AvoirEnteteAchats var4 = (AvoirEnteteAchats)var2.get(var5);
            var4.setExercicesAchats(this.exercicesNew);
            var3.modif(var4, var1);
         }
      }

      var1.flush();
   }

   public void changeExerciceFrais(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Change exercice des frais...");
      ++this.var_currentValue;
      new ArrayList();
      FraisEnteteAchatsDao var3 = new FraisEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      new FraisEnteteAchats();
      List var2 = var3.rechercheFraisByDate(this.exercicesNew.getExeachDateDebut(), this.exercicesNew.getExeachDateFin(), var1);
      if (var2.size() != 0) {
         for(int var5 = 0; var5 < var2.size(); ++var5) {
            FraisEnteteAchats var4 = (FraisEnteteAchats)var2.get(var5);
            var4.setExercicesAchats(this.exercicesNew);
            var3.modif(var4, var1);
         }
      }

      var1.flush();
   }

   public void changeExerciceValorisation(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Change exercice des valorisations...");
      ++this.var_currentValue;
      new ArrayList();
      ValorisationEnteteAchatsDao var3 = new ValorisationEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      new ValorisationEnteteAchats();
      List var2 = var3.rechercheValorisationByDate(this.exercicesNew.getExeachDateDebut(), this.exercicesNew.getExeachDateFin(), var1);
      if (var2.size() != 0) {
         for(int var5 = 0; var5 < var2.size(); ++var5) {
            ValorisationEnteteAchats var4 = (ValorisationEnteteAchats)var2.get(var5);
            var4.setExercicesAchats(this.exercicesNew);
            var3.modif(var4, var1);
         }
      }

      var1.flush();
   }

   public void changeExerciceSommier(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Change exercice des sommiers...");
      ++this.var_currentValue;
      new ArrayList();
      SommierEnteteAchatsDao var3 = new SommierEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      new SommierEnteteAchats();
      List var2 = var3.rechercheSommierByDate(this.exercicesNew.getExeachDateDebut(), this.exercicesNew.getExeachDateFin(), var1);
      if (var2.size() != 0) {
         for(int var5 = 0; var5 < var2.size(); ++var5) {
            SommierEnteteAchats var4 = (SommierEnteteAchats)var2.get(var5);
            var4.setExercicesAchats(this.exercicesNew);
            var3.modif(var4, var1);
         }
      }

      var1.flush();
   }

   public void changeExerciceInventaire(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Change exercice des inventaires...");
      ++this.var_currentValue;
      new ArrayList();
      InventaireEnteteDao var3 = new InventaireEnteteDao(this.baseLog, this.utilInitHibernate);
      new InventaireEntete();
      List var2 = var3.rechercheInventaireByDate(this.exercicesNew.getExeachDateDebut(), this.exercicesNew.getExeachDateFin(), var1);
      if (var2.size() != 0) {
         for(int var5 = 0; var5 < var2.size(); ++var5) {
            InventaireEntete var4 = (InventaireEntete)var2.get(var5);
            var4.setExercicesAchats(this.exercicesNew);
            var3.modif(var4, var1);
         }
      }

      var1.flush();
   }

   public void changeExerciceBEntree(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Change exercice des bons entrées...");
      ++this.var_currentValue;
      new ArrayList();
      BonEntreeEnteteDao var3 = new BonEntreeEnteteDao(this.baseLog, this.utilInitHibernate);
      new BonEntreeEntete();
      List var2 = var3.rechercheBonEntreeByDate(this.exercicesNew.getExeachDateDebut(), this.exercicesNew.getExeachDateFin(), var1);
      if (var2.size() != 0) {
         for(int var5 = 0; var5 < var2.size(); ++var5) {
            BonEntreeEntete var4 = (BonEntreeEntete)var2.get(var5);
            var4.setExercicesAchats(this.exercicesNew);
            var3.modif(var4, var1);
         }
      }

      var1.flush();
   }

   public void changeExerciceBSortie(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Change exercice des bns de sorties...");
      ++this.var_currentValue;
      new ArrayList();
      BonSortieEnteteDao var3 = new BonSortieEnteteDao(this.baseLog, this.utilInitHibernate);
      new BonSortieEntete();
      UtilDate var5 = new UtilDate();
      String var6 = var5.dateToStringSQLLight(this.exercicesNew.getExeachDateDebut()) + " 00:00:00";
      String var7 = var5.dateToStringSQLLight(this.exercicesNew.getExeachDateFin()) + " 23:59:59";
      List var2 = var3.rechercheBonSortieByDate(var6, var7, var1);
      if (var2.size() != 0) {
         for(int var8 = 0; var8 < var2.size(); ++var8) {
            BonSortieEntete var4 = (BonSortieEntete)var2.get(var8);
            var4.setExercicesAchats(this.exercicesNew);
            var3.modif(var4, var1);
         }
      }

      var1.flush();
   }

   public void changeExerciceCession(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Change exercice des cessions...");
      ++this.var_currentValue;
      new ArrayList();
      CessionEnteteDao var3 = new CessionEnteteDao(this.baseLog, this.utilInitHibernate);
      new CessionEntete();
      List var2 = var3.rechercheCessionsByDate(this.exercicesNew.getExeachDateDebut(), this.exercicesNew.getExeachDateFin(), var1);
      if (var2.size() != 0) {
         for(int var5 = 0; var5 < var2.size(); ++var5) {
            CessionEntete var4 = (CessionEntete)var2.get(var5);
            var4.setExercicesAchats(this.exercicesNew);
            var3.modif(var4, var1);
         }
      }

      var1.flush();
   }

   public void changeExerciceProduction(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Change exercice des productions...");
      ++this.var_currentValue;
      new ArrayList();
      FabricationEnteteAchatsDao var3 = new FabricationEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      new FabricationEnteteAchats();
      List var2 = var3.rechercheProductionByDate(this.exercicesNew.getExeachDateDebut(), this.exercicesNew.getExeachDateFin(), var1);
      if (var2.size() != 0) {
         for(int var5 = 0; var5 < var2.size(); ++var5) {
            FabricationEnteteAchats var4 = (FabricationEnteteAchats)var2.get(var5);
            var4.setExercicesAchats(this.exercicesNew);
            var3.modif(var4, var1);
         }
      }

      var1.flush();
   }


   ///
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

   public ExercicesAchats getExercicesAchats() {
      return this.exercicesAchats;
   }

   public void setExercicesAchats(ExercicesAchats var1) {
      this.exercicesAchats = var1;
   }

   public List getLesexercicesAchats() {
      return this.lesexercicesAchats;
   }

   public void setLesexercicesAchats(List var1) {
      this.lesexercicesAchats = var1;
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
