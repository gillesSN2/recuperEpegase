package com.epegase.forms.administration;

import com.epegase.systeme.classe.AvoirLigneAchats;
import com.epegase.systeme.classe.AvoirLigneVentes;
import com.epegase.systeme.classe.BonEntreeLigne;
import com.epegase.systeme.classe.BonSortieLigne;
import com.epegase.systeme.classe.CessionLigne;
import com.epegase.systeme.classe.CommandeLigneAchats;
import com.epegase.systeme.classe.CommandeLigneVentes;
import com.epegase.systeme.classe.CotationLigneAchats;
import com.epegase.systeme.classe.DepotAchats;
import com.epegase.systeme.classe.DevisLigneVentes;
import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FabricationEnteteAchats;
import com.epegase.systeme.classe.FabricationLigneAchats;
import com.epegase.systeme.classe.FactureInterneLigneVentes;
import com.epegase.systeme.classe.FactureLigneAchats;
import com.epegase.systeme.classe.FactureLigneVentes;
import com.epegase.systeme.classe.FamillesProduitsAchats;
import com.epegase.systeme.classe.FamillesProduitsVentes;
import com.epegase.systeme.classe.FraisLigneAchats;
import com.epegase.systeme.classe.InventaireLigne;
import com.epegase.systeme.classe.LivraisonLigneVentes;
import com.epegase.systeme.classe.NoteDebitLigneAchats;
import com.epegase.systeme.classe.NoteDebitLigneVentes;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsDepot;
import com.epegase.systeme.classe.ProduitsServices;
import com.epegase.systeme.classe.ReceptionLigneAchats;
import com.epegase.systeme.classe.RetourLigneAchats;
import com.epegase.systeme.classe.Service;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.TaxesAchats;
import com.epegase.systeme.classe.Unite;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.EcrituresAnalytiqueCtrl;
import com.epegase.systeme.dao.ActivitesDao;
import com.epegase.systeme.dao.AvoirLigneAchatsDao;
import com.epegase.systeme.dao.AvoirLigneVentesDao;
import com.epegase.systeme.dao.BonEntreeLigneDao;
import com.epegase.systeme.dao.BonSortieLigneDao;
import com.epegase.systeme.dao.BudgetDao;
import com.epegase.systeme.dao.CessionLigneDao;
import com.epegase.systeme.dao.CommandeLigneAchatsDao;
import com.epegase.systeme.dao.CommandeLigneVentesDao;
import com.epegase.systeme.dao.ConditionnementDao;
import com.epegase.systeme.dao.CotationLigneAchatsDao;
import com.epegase.systeme.dao.DepotAchatsDao;
import com.epegase.systeme.dao.DevisLigneVentesDao;
import com.epegase.systeme.dao.DouanesPositionDao;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.ExercicesVentesDao;
import com.epegase.systeme.dao.FabricationEnteteAchatsDao;
import com.epegase.systeme.dao.FabricationLigneAchatsDao;
import com.epegase.systeme.dao.FactureInterneLigneVentesDao;
import com.epegase.systeme.dao.FactureLigneAchatsDao;
import com.epegase.systeme.dao.FactureLigneVentesDao;
import com.epegase.systeme.dao.FamillesProduitsAchatsDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.FraisLigneAchatsDao;
import com.epegase.systeme.dao.InventaireLigneDao;
import com.epegase.systeme.dao.LivraisonLigneVentesDao;
import com.epegase.systeme.dao.MarquesDao;
import com.epegase.systeme.dao.NoteDebitLigneAchatsDao;
import com.epegase.systeme.dao.NoteDebitLigneVentesDao;
import com.epegase.systeme.dao.PlanComptableDao;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
import com.epegase.systeme.dao.ProduitsAchsDao;
import com.epegase.systeme.dao.ProduitsDepotDao;
import com.epegase.systeme.dao.ProduitsServicesDao;
import com.epegase.systeme.dao.ReceptionLigneAchatsDao;
import com.epegase.systeme.dao.RetourLigneAchatsDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.TaxesAchatsDao;
import com.epegase.systeme.dao.UniteDao;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureNatureAchats;
import com.epegase.systeme.xml.LectureNatureMedical;
import com.epegase.systeme.xml.LireLesoptionsAchats;
import com.epegase.systeme.xml.ObjetCompte;
import com.epegase.systeme.xml.OptionAchats;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
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
import org.jdom.JDOMException;

public class FormFamilleProduitsAchats implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private ExercicesAchats exercicesAchats;
   private FamillesProduitsAchats famillesProduitsAchats = new FamillesProduitsAchats();
   private FamillesProduitsAchatsDao famillesProduitsAchatsDao;
   private List famillesProduitsAchatsList = new ArrayList();
   private long famachIdSelect;
   private transient DataModel datamodel = new ListDataModel();
   private String valAjt = "false";
   private String valMod = "false";
   private String valSup = "false";
   private String valImp = "false";
   private boolean inactif;
   private int convertionInactif;
   private boolean visibiliteBton;
   private boolean showModalPanel;
   private LectureNatureAchats naturesFamillesProdAchats;
   private List lesNaturesFamillesProdAchats = new ArrayList();
   private List mesnaturesItems = new ArrayList();
   private List mesTaxesItems;
   private List mesAchLocalItems;
   private List mesAchZoneItems;
   private List mesAchHorsZoneItems;
   private List mesAchStockItems;
   private List mesAchProduitItems;
   private List mesDouanesItems;
   private List mesUnitesItems = new ArrayList();
   private List mesConditionnementsItems = new ArrayList();
   private boolean existCod = true;
   private String inpNatureModif;
   private String inpNature;
   private String var_onglet;
   private LireLesoptionsAchats lireLesoptionsAchats;
   private OptionAchats optionAchats;
   private List mesParcsItems;
   private List mesActivitesItems;
   private List mesServicesItems;
   private List mesMarquesItems;
   private List mesBudgetsItems;
   private List mesDossiersItems;
   private List mesClesItems;
   private List lesProduits = new ArrayList();
   private boolean var_maj_prod = false;
   private boolean var_aff_maj = false;
   private ProduitsAchsDao produitsAchsDao;
   private List mesDepotsAchats = new ArrayList();
   private List mesDepotsProduction = new ArrayList();
   private String inpPosTarif;
   private String inpPosTarifModif;
   private UniteDao uniteDao;
   private Unite unite = new Unite();
   private boolean decoupageActivite = false;
   private List laColonne1Items = new ArrayList();
   private List laColonne2Items = new ArrayList();
   private List laColonne3Items = new ArrayList();
   private EcrituresAnalytiqueCtrl ecrituresAnalytiqueCtrl;
   private List lesDecoupagesActivites = new ArrayList();
   private transient DataModel dataModelDecoupageActivtes = new ListDataModel();
   private String var_colonne1;
   private String var_colonne2;
   private String var_colonne3;
   private double totalImputation;
   private double soldeImputation;
   private int choixRacine;
   private String selecFiscalite;
   private boolean chgFamille = false;
   private List mesFamillesAchats = new ArrayList();
   private String newFamille;

   public FormFamilleProduitsAchats() throws JDOMException, IOException {
   }

   public void InstancesDaoUtilses() {
      this.famillesProduitsAchatsDao = new FamillesProduitsAchatsDao(this.baseLog, this.utilInitHibernate);
      this.produitsAchsDao = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
      this.uniteDao = new UniteDao(this.baseLog, this.utilInitHibernate);
   }

   public void lesFamillesProduitsAchats(Session var1) throws IOException, JDOMException, HibernateException, NamingException, ParseException {
      this.famillesProduitsAchatsList.clear();
      this.famillesProduitsAchatsList = this.famillesProduitsAchatsDao.selectAllFamillProd(this.exercicesAchats.getExeachId(), var1);
      this.recupererMesnaturesItems();
      this.recupererMesDepotsItems(var1);
      this.recupererActivitesItems(var1);
      this.recupererClesItems(var1);
      this.recupererServicesItems(var1);
      this.recupererMarquesItems(var1);
      this.recupererBudgetItem(var1);
      this.recupererDossierItem(var1);
      this.recupererParcItem(var1);
      this.recupererTaxesItem(var1);
      this.recupererComptesItem(var1);
      this.recupererDouanesItem(var1);
      this.recupererUniteItem(var1);
      this.recupererConditionnementItem(var1);
      this.recupOptionsAchats();
      String var2 = "";
      if (this.famillesProduitsAchatsList.size() != 0) {
         for(int var3 = 0; var3 < this.famillesProduitsAchatsList.size(); ++var3) {
            this.famillesProduitsAchats = (FamillesProduitsAchats)this.famillesProduitsAchatsList.get(var3);
            if (this.famillesProduitsAchats.getFamachCat() == 99) {
               var2 = this.famillesProduitsAchats.getFamachCode();
            } else {
               this.famillesProduitsAchats.setFamachOrigine(var2);
               this.famillesProduitsAchats = this.famillesProduitsAchatsDao.modif(this.famillesProduitsAchats, var1);
            }
         }
      }

      this.datamodel.setWrappedData(this.famillesProduitsAchatsList);
   }

   public void recupererMesnaturesItems() throws JDOMException, IOException {
      LectureNatureAchats var1 = new LectureNatureAchats();
      this.mesnaturesItems = var1.getMesNatureAchatsItems();
      if (this.rechercheModule("815")) {
         LectureNatureMedical var2 = new LectureNatureMedical();
         new ArrayList();
         List var3 = var2.getMesNatureMedical();
         if (var3.size() != 0) {
            for(int var4 = 0; var4 < var3.size(); ++var4) {
               this.mesnaturesItems.add(new SelectItem(((ObjetCompte)var3.get(var4)).getCode() + ":" + ((ObjetCompte)var3.get(var4)).getNom_FR()));
            }
         }
      }

   }

   public boolean rechercheModule(String var1) {
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
         if (((String)var3.get(var4)).startsWith(var1)) {
            var2 = true;
         }
      }

      return var2;
   }

   public void recupererMesDepotsItems(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.mesDepotsAchats.clear();
      this.mesDepotsProduction.clear();
      DepotAchatsDao var2 = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
      this.mesDepotsAchats = var2.selectActifDepotItems(13, var1);
      this.mesDepotsProduction = var2.selectActifDepotItems(34, var1);
   }

   public void recupOptionsAchats() throws IOException {
      this.lireLesoptionsAchats = new LireLesoptionsAchats();
      this.lireLesoptionsAchats.setStrId(this.structureLog.getStrid());
      this.lireLesoptionsAchats.lancer();
      this.optionAchats = this.lireLesoptionsAchats.getOptionAchats();
   }

   public void recupererActivitesItems(Session var1) throws HibernateException, NamingException {
      this.mesActivitesItems = new ArrayList();
      this.laColonne1Items = new ArrayList();
      this.laColonne2Items = new ArrayList();
      this.laColonne3Items = new ArrayList();
      if (this.structureLog.getStrCode1() != null && !this.structureLog.getStrCode1().isEmpty()) {
         this.decoupageActivite = true;
      } else {
         this.decoupageActivite = false;
      }

      ActivitesDao var2 = new ActivitesDao(this.baseLog, this.utilInitHibernate);
      if (this.decoupageActivite) {
         if (this.structureLog.getStrCode1() != null && !this.structureLog.getStrCode1().isEmpty()) {
            this.laColonne1Items = var2.chargerLesDecoupages(this.structureLog.getStrCode1(), var1);
         }

         if (this.structureLog.getStrCode2() != null && !this.structureLog.getStrCode2().isEmpty()) {
            this.laColonne2Items = var2.chargerLesDecoupages(this.structureLog.getStrCode2(), var1);
         }

         if (this.structureLog.getStrCode3() != null && !this.structureLog.getStrCode3().isEmpty()) {
            this.laColonne3Items = var2.chargerLesDecoupages(this.structureLog.getStrCode3(), var1);
         }
      } else {
         this.mesActivitesItems = var2.chargerLesActivites(var1);
      }

   }

   public void recupererClesItems(Session var1) throws HibernateException, NamingException {
      this.mesClesItems = new ArrayList();
      PlansAnalytiquesDao var2 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      this.mesClesItems = var2.chargerLesAnalytiques("9", var1);
   }

   public void recupererServicesItems(Session var1) throws HibernateException, NamingException {
      this.mesServicesItems = new ArrayList();
      ServiceDao var2 = new ServiceDao(this.baseLog, this.utilInitHibernate);
      this.mesServicesItems = var2.chargerLesServicesItems(1, false, var1);
   }

   public void recupererMarquesItems(Session var1) throws HibernateException, NamingException {
      this.mesMarquesItems = new ArrayList();
      MarquesDao var2 = new MarquesDao(this.baseLog, this.utilInitHibernate);
      this.mesMarquesItems = var2.chargerLesMarques(var1);
   }

   public void recupererUniteItem(Session var1) throws HibernateException, NamingException {
      this.mesUnitesItems = new ArrayList();
      this.mesUnitesItems = this.uniteDao.chargerLesUnitesItems(var1);
   }

   public void recupererConditionnementItem(Session var1) throws HibernateException, NamingException {
      this.mesConditionnementsItems = new ArrayList();
      ConditionnementDao var2 = new ConditionnementDao(this.baseLog, this.utilInitHibernate);
      this.mesConditionnementsItems = var2.chargerLesConditionnements(var1);
   }

   public void recupererBudgetItem(Session var1) throws HibernateException, NamingException {
      this.mesBudgetsItems = new ArrayList();
      BudgetDao var2 = new BudgetDao(this.baseLog, this.utilInitHibernate);
      this.mesBudgetsItems = var2.selectAllBudget(this.exercicesAchats.getExeachId(), var1);
   }

   public void recupererDossierItem(Session var1) throws HibernateException, NamingException {
      this.mesDossiersItems = new ArrayList();
      PlansAnalytiquesDao var2 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      this.mesDossiersItems = var2.chargerLesAnalytiques("6", var1);
   }

   public void recupererParcItem(Session var1) throws HibernateException, NamingException {
      this.mesParcsItems = new ArrayList();
      PlansAnalytiquesDao var2 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      this.mesParcsItems = var2.chargerLesAnalytiques("8", var1);
   }

   public void recupererTaxesItem(Session var1) throws HibernateException, NamingException {
      this.mesTaxesItems = new ArrayList();
      TaxesAchatsDao var2 = new TaxesAchatsDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      List var3 = var2.selectActifTaxes(this.exercicesAchats.getExeachId(), var1);
      if (var3.size() != 0) {
         for(int var4 = 0; var4 < var3.size(); ++var4) {
            TaxesAchats var5 = (TaxesAchats)var3.get(var4);
            if (var5.getTaxachCode() != null && !var5.getTaxachCode().isEmpty()) {
               this.mesTaxesItems.add(new SelectItem(var5.getTaxachCode(), var5.getTaxachCode() + ":" + var5.getTaxachTaux()));
            }
         }
      }

   }

   public void recupererComptesItem(Session var1) throws HibernateException, NamingException, ParseException {
      this.mesAchLocalItems = new ArrayList();
      this.mesAchZoneItems = new ArrayList();
      this.mesAchHorsZoneItems = new ArrayList();
      this.mesAchStockItems = new ArrayList();
      this.mesAchProduitItems = new ArrayList();
      new ExercicesComptable();
      ExercicesComptableDao var3 = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
      ExercicesComptable var2 = var3.recupererLastExo(var1);
      if (var2 != null) {
         PlanComptableDao var4 = new PlanComptableDao(this.baseLog, this.utilInitHibernate);
         this.selecFiscalite = this.structureLog.getStrzonefiscale();
         if (this.structureLog.getStrzonefiscale2() != null && !this.structureLog.getStrzonefiscale2().isEmpty()) {
            long var5 = (long)(var2.getExecptDateDebut().getYear() + 1900);
            long var7 = (long)(var2.getExecptDateFin().getYear() + 1900);
            if (this.structureLog.getStrdatefiscale2() != null && var5 >= (long)(this.structureLog.getStrdatefiscale2().getYear() + 1900) && var7 >= (long)(this.structureLog.getStrdatefiscale2().getYear() + 1900)) {
               this.selecFiscalite = this.structureLog.getStrzonefiscale2();
            } else if (this.structureLog.getStrdatefiscale2() != null && var5 < (long)(this.structureLog.getStrdatefiscale2().getYear() + 1900) && var7 < (long)(this.structureLog.getStrdatefiscale2().getYear() + 1900)) {
               this.selecFiscalite = this.structureLog.getStrzonefiscale();
            } else {
               this.selecFiscalite = null;
            }
         }

         this.mesAchLocalItems = var4.chargerPlanCmptItems(this.selecFiscalite, var2.getExecpt_id(), "(3,9,13,16)", 0, var1);
         this.mesAchZoneItems = var4.chargerPlanCmptItems(this.selecFiscalite, var2.getExecpt_id(), "(3,9,13,16)", 0, var1);
         this.mesAchHorsZoneItems = var4.chargerPlanCmptItems(this.selecFiscalite, var2.getExecpt_id(), "(3,9,13,16)", 0, var1);
         this.mesAchStockItems = var4.chargerPlanCmptItems(this.selecFiscalite, var2.getExecpt_id(), "(5,9,16,13)", 0, var1);
         this.mesAchProduitItems = var4.chargerPlanCmptItems(this.selecFiscalite, var2.getExecpt_id(), "(3,9,13,16)", 0, var1);
      }

   }

   public void recupererDouanesItem(Session var1) throws HibernateException, NamingException {
      this.mesDouanesItems = new ArrayList();
      DouanesPositionDao var2 = new DouanesPositionDao(this.baseLog, this.utilInitHibernate);
      this.mesDouanesItems = var2.listePositionsItems(this.structureLog.getStrzonecommerciale(), var1);
   }

   public void chargerDetailanalytique() {
      this.totalImputation = 0.0D;
      this.soldeImputation = 0.0D;
      this.lesDecoupagesActivites.clear();
      if (this.decoupageActivite && this.famillesProduitsAchats.getFamachActivite() != null && !this.famillesProduitsAchats.getFamachActivite().isEmpty() && this.famillesProduitsAchats.getFamachActivite().contains(":")) {
         String[] var1 = null;
         if (!this.famillesProduitsAchats.getFamachActivite().contains("#")) {
            var1 = this.famillesProduitsAchats.getFamachActivite().split(":");
            if (var1.length == 7) {
               this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
               this.ecrituresAnalytiqueCtrl.setEcranaActivite(var1[0]);
               this.ecrituresAnalytiqueCtrl.setEcranaActiviteLib(var1[1]);
               this.ecrituresAnalytiqueCtrl.setZoneActivite(this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib());
               this.ecrituresAnalytiqueCtrl.setEcranaAnal1(var1[2]);
               this.ecrituresAnalytiqueCtrl.setEcranaAnal1Lib(var1[3]);
               this.ecrituresAnalytiqueCtrl.setZoneAnal1(this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib());
               this.ecrituresAnalytiqueCtrl.setEcranaAnal3(var1[4]);
               this.ecrituresAnalytiqueCtrl.setEcranaAnal3Lib(var1[5]);
               this.ecrituresAnalytiqueCtrl.setZoneAnal3(this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib());
               this.ecrituresAnalytiqueCtrl.setEcranaPourcentage(Float.parseFloat(var1[6]));
               this.totalImputation += this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
               this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
            }
         } else {
            String[] var2 = this.famillesProduitsAchats.getFamachActivite().split("#");

            for(int var3 = 0; var3 < var2.length; ++var3) {
               var1 = var2[var3].split(":");
               if (var1.length == 7) {
                  this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
                  this.ecrituresAnalytiqueCtrl.setEcranaActivite(var1[0]);
                  this.ecrituresAnalytiqueCtrl.setEcranaActiviteLib(var1[1]);
                  this.ecrituresAnalytiqueCtrl.setZoneActivite(this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib());
                  this.ecrituresAnalytiqueCtrl.setEcranaAnal1(var1[2]);
                  this.ecrituresAnalytiqueCtrl.setEcranaAnal1Lib(var1[3]);
                  this.ecrituresAnalytiqueCtrl.setZoneAnal1(this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib());
                  this.ecrituresAnalytiqueCtrl.setEcranaAnal3(var1[4]);
                  this.ecrituresAnalytiqueCtrl.setEcranaAnal3Lib(var1[5]);
                  this.ecrituresAnalytiqueCtrl.setZoneAnal3(this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib());
                  this.ecrituresAnalytiqueCtrl.setEcranaPourcentage(Float.parseFloat(var1[6]));
                  this.totalImputation += this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
                  this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
               }
            }
         }
      }

      this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
   }

   public void selectionAnalytique() {
      if (this.dataModelDecoupageActivtes.isRowAvailable()) {
         this.ecrituresAnalytiqueCtrl = (EcrituresAnalytiqueCtrl)this.dataModelDecoupageActivtes.getRowData();
      }

   }

   public void valideColonne1() {
      if (this.ecrituresAnalytiqueCtrl.getZoneActivite() != null && !this.ecrituresAnalytiqueCtrl.getZoneActivite().isEmpty() && this.ecrituresAnalytiqueCtrl.getZoneActivite().contains(":")) {
         String[] var1 = this.ecrituresAnalytiqueCtrl.getZoneActivite().split(":");
         this.ecrituresAnalytiqueCtrl.setEcranaActivite(var1[0]);
         this.ecrituresAnalytiqueCtrl.setEcranaActiviteLib(var1[1]);
      }

   }

   public void valideColonne2() {
      if (this.ecrituresAnalytiqueCtrl.getZoneAnal1() != null && !this.ecrituresAnalytiqueCtrl.getZoneAnal1().isEmpty() && this.ecrituresAnalytiqueCtrl.getZoneAnal1().contains(":")) {
         String[] var1 = this.ecrituresAnalytiqueCtrl.getZoneAnal1().split(":");
         this.ecrituresAnalytiqueCtrl.setEcranaAnal1(var1[0]);
         this.ecrituresAnalytiqueCtrl.setEcranaAnal1Lib(var1[1]);
      }

   }

   public void valideColonne3() {
      if (this.ecrituresAnalytiqueCtrl.getZoneAnal3() != null && !this.ecrituresAnalytiqueCtrl.getZoneAnal3().isEmpty() && this.ecrituresAnalytiqueCtrl.getZoneAnal3().contains(":")) {
         String[] var1 = this.ecrituresAnalytiqueCtrl.getZoneAnal3().split(":");
         this.ecrituresAnalytiqueCtrl.setEcranaAnal3(var1[0]);
         this.ecrituresAnalytiqueCtrl.setEcranaAnal3Lib(var1[1]);
      }

   }

   public void supprimerAnalytique() {
      if (this.ecrituresAnalytiqueCtrl == null) {
         this.selectionAnalytique();
      }

      if (this.ecrituresAnalytiqueCtrl != null) {
         this.lesDecoupagesActivites.remove(this.ecrituresAnalytiqueCtrl);
         this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
         this.ecrituresAnalytiqueCtrl = null;
      }

      if (this.lesDecoupagesActivites.size() == 0) {
         this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
         this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
         this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
      }

   }

   public void controleEcartAnalytique() {
      this.totalImputation = 0.0D;
      this.soldeImputation = 0.0D;
      if (this.lesDecoupagesActivites.size() != 0) {
         for(int var1 = 0; var1 < this.lesDecoupagesActivites.size(); ++var1) {
            this.totalImputation += (double)((EcrituresAnalytiqueCtrl)this.lesDecoupagesActivites.get(var1)).getEcranaPourcentage();
         }
      }

      this.soldeImputation = 100.0D - this.totalImputation;
      if (this.soldeImputation > 0.0D) {
         this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
         this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
         this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
      }

   }

   public void visibleAjt() throws JDOMException, IOException {
      this.famillesProduitsAchats = new FamillesProduitsAchats();
      this.inactif = false;
      this.existCod = false;
      this.inpNature = "";
      this.var_aff_maj = false;
      this.var_maj_prod = false;
      this.var_onglet = "general";
      this.lesDecoupagesActivites.clear();
      this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
      this.setShowModalPanel(true);
   }

   public void visibleMod() throws JDOMException, IOException {
      if (this.famillesProduitsAchats != null) {
         this.existCod = true;
         this.var_aff_maj = false;
         this.var_maj_prod = false;
         this.var_onglet = "general";
         this.setShowModalPanel(true);
      }

   }

   public void reactiverCompte() throws HibernateException, NamingException {
      if (this.famillesProduitsAchats == null) {
         this.selectionFamille();
      }

      if (this.famillesProduitsAchats != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FamillesProduitsAchats");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.famillesProduitsAchats.setFamachDateModif(new Date());
            this.famillesProduitsAchats.setFamachUserModif(this.usersLog.getUsrid());
            this.famillesProduitsAchats.setFamachInactif(0);
            this.famillesProduitsAchats = this.famillesProduitsAchatsDao.modif(this.famillesProduitsAchats, var1);
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

      this.visibiliteBton = false;
   }

   public void removeCompte() throws HibernateException, NamingException {
      if (this.famillesProduitsAchats != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FamillesProduitsAchats");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.lesProduits = new ArrayList();
            this.lesProduits = this.produitsAchsDao.chargerLesProduitsAchatsByFamille(this.famillesProduitsAchats.getFamachCode(), var1);
            if (this.lesProduits.size() == 0) {
               this.famillesProduitsAchatsDao.delete(this.famillesProduitsAchats, var1);
               this.famillesProduitsAchatsList.remove(this.famillesProduitsAchats);
            } else {
               this.famillesProduitsAchats.setFamachDateModif(new Date());
               this.famillesProduitsAchats.setFamachUserModif(this.usersLog.getUsrid());
               this.famillesProduitsAchats.setFamachInactif(2);
               this.famillesProduitsAchats = this.famillesProduitsAchatsDao.modif(this.famillesProduitsAchats, var1);
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

         this.visibiliteBton = false;
      }

   }

   public void annule() {
      this.setShowModalPanel(false);
      this.setValImp("false");
   }

   public void selectionFamille() {
      this.chgFamille = false;
      this.famillesProduitsAchats = new FamillesProduitsAchats();
      this.annule();
      if (this.datamodel.isRowAvailable()) {
         this.famillesProduitsAchats = (FamillesProduitsAchats)this.datamodel.getRowData();
         this.famachIdSelect = this.famillesProduitsAchats.getFamachId();
         this.inpNature = this.famillesProduitsAchats.getFamachNature() + ":" + this.famillesProduitsAchats.getFamachLibNature();
         String[] var1;
         if (this.famillesProduitsAchats.getFamachCompteCharge() != null && !this.famillesProduitsAchats.getFamachCompteCharge().isEmpty() && this.famillesProduitsAchats.getFamachCompteCharge().contains(":")) {
            var1 = this.famillesProduitsAchats.getFamachCompteCharge().split(":");
            this.famillesProduitsAchats.setFamachCompteCharge(var1[0]);
         }

         if (this.famillesProduitsAchats.getFamachCompteEncours() != null && !this.famillesProduitsAchats.getFamachCompteEncours().isEmpty() && this.famillesProduitsAchats.getFamachCompteEncours().contains(":")) {
            var1 = this.famillesProduitsAchats.getFamachCompteEncours().split(":");
            this.famillesProduitsAchats.setFamachCompteEncours(var1[0]);
         }

         if (this.famillesProduitsAchats.getFamachCompteExterieur() != null && !this.famillesProduitsAchats.getFamachCompteExterieur().isEmpty() && this.famillesProduitsAchats.getFamachCompteExterieur().contains(":")) {
            var1 = this.famillesProduitsAchats.getFamachCompteExterieur().split(":");
            this.famillesProduitsAchats.setFamachCompteExterieur(var1[0]);
         }

         if (this.famillesProduitsAchats.getFamachCompteLocal() != null && !this.famillesProduitsAchats.getFamachCompteLocal().isEmpty() && this.famillesProduitsAchats.getFamachCompteLocal().contains(":")) {
            var1 = this.famillesProduitsAchats.getFamachCompteLocal().split(":");
            this.famillesProduitsAchats.setFamachCompteLocal(var1[0]);
         }

         if (this.famillesProduitsAchats.getFamachCompteStock() != null && !this.famillesProduitsAchats.getFamachCompteStock().isEmpty() && this.famillesProduitsAchats.getFamachCompteStock().contains(":")) {
            var1 = this.famillesProduitsAchats.getFamachCompteStock().split(":");
            this.famillesProduitsAchats.setFamachCompteStock(var1[0]);
         }

         if (this.famillesProduitsAchats.getFamachCompteZone() != null && !this.famillesProduitsAchats.getFamachCompteZone().isEmpty() && this.famillesProduitsAchats.getFamachCompteZone().contains(":")) {
            var1 = this.famillesProduitsAchats.getFamachCompteZone().split(":");
            this.famillesProduitsAchats.setFamachCompteZone(var1[0]);
         }

         if (this.famillesProduitsAchats.getFamachInactif() == 2) {
            this.visibiliteBton = false;
         } else {
            this.visibiliteBton = true;
         }

         this.lesProduits.clear();
         if (this.decoupageActivite) {
            this.chargerDetailanalytique();
            this.controleEcartAnalytique();
         }
      }

   }

   public void listeProduit() throws HibernateException, NamingException {
      this.chgFamille = false;
      this.lesProduits.clear();
      if (this.famillesProduitsAchats.getFamachCode() != null && !this.famillesProduitsAchats.getFamachCode().isEmpty()) {
         this.lesProduits = this.produitsAchsDao.chargerLesProduitsAchatsByFamille(this.famillesProduitsAchats.getFamachCode(), (Session)null);
      }

      if (this.lesProduits.size() != 0) {
         this.var_aff_maj = true;
         this.var_maj_prod = false;
      }

   }

   public void recalculMvts() throws HibernateException, NamingException {
      if (this.lesProduits.size() != 0) {
         UtilDate var1 = new UtilDate();
         var1.dateToStringSQL(this.exercicesAchats.getExeachDateDebut());
         var1.dateToStringSQL(this.exercicesAchats.getExeachDateFin());
         Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "CalculMouvementStock");
         Transaction var5 = null;

         try {
            var5 = var4.beginTransaction();

            for(int var6 = 0; var6 < this.lesProduits.size(); ++var6) {
               new Produits();
               Produits var7 = (Produits)this.lesProduits.get(var6);
               this.recalculListeMvts(this.famillesProduitsAchats.isFamachLieeVte(), var7, (String)null, (String)null, var4);
            }

            var5.commit();
         } catch (HibernateException var11) {
            if (var5 != null) {
               var5.rollback();
            }

            throw var11;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void chgFamille() {
      int var2;
      Produits var3;
      if (!this.chgFamille) {
         this.chgFamille = true;
         this.mesFamillesAchats.clear();
         if (this.famillesProduitsAchatsList.size() != 0) {
            for(int var1 = 0; var1 < this.famillesProduitsAchatsList.size(); ++var1) {
               if (!this.famillesProduitsAchats.getFamachCode().equals(((FamillesProduitsAchats)this.famillesProduitsAchatsList.get(var1)).getFamachCode())) {
                  if (((FamillesProduitsAchats)this.famillesProduitsAchatsList.get(var1)).getFamachLibelleFr() != null && !((FamillesProduitsAchats)this.famillesProduitsAchatsList.get(var1)).getFamachLibelleFr().isEmpty()) {
                     this.mesFamillesAchats.add(new SelectItem(((FamillesProduitsAchats)this.famillesProduitsAchatsList.get(var1)).getFamachCode() + ":" + ((FamillesProduitsAchats)this.famillesProduitsAchatsList.get(var1)).getFamachLibelleFr()));
                  } else {
                     this.mesFamillesAchats.add(new SelectItem(((FamillesProduitsAchats)this.famillesProduitsAchatsList.get(var1)).getFamachCode() + ":" + "???"));
                  }
               }
            }
         }

         if (this.lesProduits.size() != 0) {
            new Produits();

            for(var2 = 0; var2 < this.lesProduits.size(); ++var2) {
               var3 = (Produits)this.lesProduits.get(var2);
               var3.setVar_select(true);
            }
         }
      } else {
         this.chgFamille = false;
         this.mesFamillesAchats.clear();
         if (this.lesProduits.size() != 0) {
            new Produits();

            for(var2 = 0; var2 < this.lesProduits.size(); ++var2) {
               var3 = (Produits)this.lesProduits.get(var2);
               var3.setVar_select(false);
            }
         }
      }

   }

   public void valideFamille() throws HibernateException, NamingException {
      if (this.lesProduits.size() != 0 && this.newFamille != null && !this.newFamille.isEmpty() && this.newFamille.contains(":")) {
         String[] var1 = this.newFamille.split(":");
         String var2 = var1[0];
         String var3 = var1[1];
         Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "CalculMouvementStock");
         Transaction var5 = null;

         try {
            var5 = var4.beginTransaction();
            new Produits();
            int var7 = 0;

            while(true) {
               if (var7 >= this.lesProduits.size()) {
                  this.lesProduits = this.produitsAchsDao.chargerLesProduitsAchatsByFamille(this.famillesProduitsAchats.getFamachCode(), var4);
                  var5.commit();
                  break;
               }

               Produits var6 = (Produits)this.lesProduits.get(var7);
               if (var6.isVar_select()) {
                  var6.setProAchCode(var2);
                  var6.setProAchLib(var3);
                  if (this.famillesProduitsAchats.isFamachLieeVte()) {
                     var6.setProVteCode(var2);
                     var6.setProVteLib(var3);
                  }

                  var6 = this.produitsAchsDao.modif(var6, var4);
                  this.recalculListeMvts(this.famillesProduitsAchats.isFamachLieeVte(), var6, (String)null, (String)null, var4);
               }

               ++var7;
            }
         } catch (HibernateException var11) {
            if (var5 != null) {
               var5.rollback();
            }

            throw var11;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         if (this.lesProduits.size() != 0) {
            this.chgFamille = false;
         } else {
            this.famillesProduitsAchatsDao.delete(this.famillesProduitsAchats);
            this.famillesProduitsAchatsList = this.famillesProduitsAchatsDao.selectAllFamillProd(this.exercicesAchats.getExeachId(), (Session)null);
            this.datamodel.setWrappedData(this.famillesProduitsAchatsList);
            this.setShowModalPanel(false);
         }
      }

   }

   public void recalculListeMvts(boolean var1, Produits var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      new CotationLigneAchats();
      new ArrayList();
      CotationLigneAchatsDao var8 = new CotationLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      List var7 = var8.chargerLesMvts("", var2.getProCode(), "", "", var3, var4, var5);
      if (var7.size() != 0) {
         new CotationLigneAchats();

         for(int var9 = 0; var9 < var7.size(); ++var9) {
            CotationLigneAchats var6 = (CotationLigneAchats)var7.get(var9);
            var6.setCotligFamille(var2.getProAchCode());
            var8.modifLigne(var6, var5);
         }
      }

      new CommandeLigneAchats();
      new ArrayList();
      CommandeLigneAchatsDao var11 = new CommandeLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      List var10 = var11.chargerLesMvts("", var2.getProCode(), "", "", "", var3, var4, var5);
      if (var10.size() != 0) {
         new CommandeLigneAchats();

         for(int var12 = 0; var12 < var10.size(); ++var12) {
            CommandeLigneAchats var70 = (CommandeLigneAchats)var10.get(var12);
            var70.setCmdligFamille(var2.getProAchCode());
            var11.modifLigne(var70, var5);
         }
      }

      new ReceptionLigneAchats();
      new ArrayList();
      ReceptionLigneAchatsDao var14 = new ReceptionLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      List var13 = var14.chargerLesMvts("", var2.getProCode(), "", "", "", var3, var4, var5);
      if (var13.size() != 0) {
         new ReceptionLigneAchats();

         for(int var15 = 0; var15 < var13.size(); ++var15) {
            ReceptionLigneAchats var71 = (ReceptionLigneAchats)var13.get(var15);
            var71.setRecligFamille(var2.getProAchCode());
            var14.modifLigne(var71, var5);
         }
      }

      new RetourLigneAchats();
      new ArrayList();
      RetourLigneAchatsDao var17 = new RetourLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      List var16 = var17.chargerLesMvts("", var2.getProCode(), "", "", "", var3, var4, var5);
      if (var16.size() != 0) {
         new RetourLigneAchats();

         for(int var18 = 0; var18 < var16.size(); ++var18) {
            RetourLigneAchats var72 = (RetourLigneAchats)var16.get(var18);
            var72.setBrfligFamille(var2.getProAchCode());
            var17.modifLigne(var72, var5);
         }
      }

      new FactureLigneAchats();
      new ArrayList();
      FactureLigneAchatsDao var20 = new FactureLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      List var19 = var20.chargerLesMvts("", var2.getProCode(), "", "", var3, var4, "", var5);
      if (var19.size() != 0) {
         new FactureLigneAchats();

         for(int var21 = 0; var21 < var19.size(); ++var21) {
            FactureLigneAchats var73 = (FactureLigneAchats)var19.get(var21);
            var73.setFcfligFamille(var2.getProAchCode());
            var20.modifLigne(var73, var5);
         }
      }

      new NoteDebitLigneAchats();
      new ArrayList();
      NoteDebitLigneAchatsDao var23 = new NoteDebitLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      List var22 = var23.chargerLesMvts("", var2.getProCode(), "", "", var3, var4, var5);
      if (var22.size() != 0) {
         new NoteDebitLigneAchats();

         for(int var24 = 0; var24 < var22.size(); ++var24) {
            NoteDebitLigneAchats var74 = (NoteDebitLigneAchats)var22.get(var24);
            var74.setNdfligFamille(var2.getProAchCode());
            var23.modifLigne(var74, var5);
         }
      }

      new AvoirLigneAchats();
      new ArrayList();
      AvoirLigneAchatsDao var26 = new AvoirLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      List var25 = var26.chargerLesMvts("", var2.getProCode(), "", "", var3, var4, var5);
      if (var25.size() != 0) {
         new AvoirLigneAchats();

         for(int var27 = 0; var27 < var25.size(); ++var27) {
            AvoirLigneAchats var75 = (AvoirLigneAchats)var25.get(var27);
            var75.setAvfligFamille(var2.getProAchCode());
            var26.modifLigne(var75, var5);
         }
      }

      new FraisLigneAchats();
      new ArrayList();
      FraisLigneAchatsDao var29 = new FraisLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      List var28 = var29.chargerLesMvts("", var2.getProCode(), "", "", var3, var4, var5);
      if (var28.size() != 0) {
         new FraisLigneAchats();

         for(int var30 = 0; var30 < var28.size(); ++var30) {
            FraisLigneAchats var76 = (FraisLigneAchats)var28.get(var30);
            var76.setFsfligFamille(var2.getProAchCode());
            var29.modifLigne(var76, var5);
         }
      }

      new InventaireLigne();
      new ArrayList();
      InventaireLigneDao var32 = new InventaireLigneDao(this.baseLog, this.utilInitHibernate);
      List var31 = var32.chargerLesMvts("", var2.getProCode(), "", 0L, "", "", var3, var4, var5);
      if (var31.size() != 0) {
         new InventaireLigne();

         for(int var33 = 0; var33 < var31.size(); ++var33) {
            InventaireLigne var77 = (InventaireLigne)var31.get(var33);
            var77.setInvligFamille(var2.getProAchCode());
            var32.modifLigne(var77, var5);
         }
      }

      new BonEntreeLigne();
      new ArrayList();
      BonEntreeLigneDao var35 = new BonEntreeLigneDao(this.baseLog, this.utilInitHibernate);
      List var34 = var35.chargerLesMvts("", var2.getProCode(), "", 0L, "", "", var3, var4, var5);
      if (var34.size() != 0) {
         new BonEntreeLigne();

         for(int var36 = 0; var36 < var31.size(); ++var36) {
            BonEntreeLigne var78 = (BonEntreeLigne)var34.get(var36);
            var78.setBinligFamille(var2.getProAchCode());
            var35.modifLigne(var78, var5);
         }
      }

      new BonSortieLigne();
      new ArrayList();
      BonSortieLigneDao var38 = new BonSortieLigneDao(this.baseLog, this.utilInitHibernate);
      List var37 = var38.chargerLesMvts("", var2.getProCode(), "", 0L, "", "", var3, var4, var5);
      if (var37.size() != 0) {
         new BonSortieLigne();

         for(int var39 = 0; var39 < var37.size(); ++var39) {
            BonSortieLigne var79 = (BonSortieLigne)var37.get(var39);
            var79.setBouligFamille(var2.getProAchCode());
            var38.modifLigne(var79, var5);
         }
      }

      new CessionLigne();
      new ArrayList();
      CessionLigneDao var41 = new CessionLigneDao(this.baseLog, this.utilInitHibernate);
      List var40 = var41.chargerLesMvtsOrigine("", var2.getProCode(), "", 0L, "", "", var3, var4, var5);
      int var42;
      CessionLigne var80;
      if (var40.size() != 0) {
         new CessionLigne();

         for(var42 = 0; var42 < var40.size(); ++var42) {
            var80 = (CessionLigne)var40.get(var42);
            var80.setCesligFamille(var2.getProAchCode());
            var41.modifLigne(var80, var5);
         }
      }

      new ArrayList();
      var40 = var41.chargerLesMvtsDestination("", var2.getProCode(), "", 0L, "", "", var3, var4, var5);
      if (var40.size() != 0) {
         new CessionLigne();

         for(var42 = 0; var42 < var40.size(); ++var42) {
            var80 = (CessionLigne)var40.get(var42);
            var80.setCesligFamille(var2.getProAchCode());
            var41.modifLigne(var80, var5);
         }
      }

      new FabricationEnteteAchats();
      new ArrayList();
      FabricationEnteteAchatsDao var44 = new FabricationEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      List var43 = var44.chargerLesMvts((String)null, var2.getProCode(), (String)null, 0L, (String)null, (String)null, var3, var4, var5);
      if (var43.size() != 0) {
         new FabricationEnteteAchats();

         for(int var45 = 0; var45 < var43.size(); ++var45) {
            FabricationEnteteAchats var81 = (FabricationEnteteAchats)var43.get(var45);
            var81.setFabFamille(var2.getProAchCode());
            var44.modif(var81, var5);
         }
      }

      new FabricationLigneAchats();
      new ArrayList();
      FabricationLigneAchatsDao var47 = new FabricationLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      List var46 = var47.chargerLesLignesFabricationValorisation(var2.getProCode(), (String)null, (Date)null, (Date)null, var5);
      if (var46.size() != 0) {
         new FabricationLigneAchats();

         for(int var48 = 0; var48 < var46.size(); ++var48) {
            FabricationLigneAchats var82 = (FabricationLigneAchats)var46.get(var48);
            var82.setFabligFamille(var2.getProAchCode());
            var47.modifLigne(var82, var5);
         }
      }

      if (var1) {
         new DevisLigneVentes();
         new ArrayList();
         DevisLigneVentesDao var50 = new DevisLigneVentesDao(this.baseLog, this.utilInitHibernate);
         List var49 = var50.chargerLesMvts("", var2.getProCode(), 0L, "", "", var3, var4, var5);
         if (var49.size() != 0) {
            new DevisLigneVentes();

            for(int var51 = 0; var51 < var49.size(); ++var51) {
               DevisLigneVentes var83 = (DevisLigneVentes)var49.get(var51);
               var83.setDvsligFamille(var2.getProVteCode());
               var50.modifLigne(var83, var5);
            }
         }

         new CommandeLigneVentes();
         new ArrayList();
         CommandeLigneVentesDao var53 = new CommandeLigneVentesDao(this.baseLog, this.utilInitHibernate);
         List var52 = var53.chargerLesMvts("", var2.getProCode(), "", 0L, "", "", var3, var4, var5);
         if (var52.size() != 0) {
            new CommandeLigneVentes();

            for(int var54 = 0; var54 < var52.size(); ++var54) {
               CommandeLigneVentes var84 = (CommandeLigneVentes)var52.get(var54);
               var84.setBcmligFamille(var2.getProVteCode());
               var53.modifLigne(var84, var5);
            }
         }

         new LivraisonLigneVentes();
         new ArrayList();
         LivraisonLigneVentesDao var56 = new LivraisonLigneVentesDao(this.baseLog, this.utilInitHibernate);
         List var55 = var56.chargerLesMvts("", var2.getProCode(), "", 0L, "", "", var3, var4, "", var5);
         if (var55.size() != 0) {
            new LivraisonLigneVentes();

            for(int var57 = 0; var57 < var55.size(); ++var57) {
               LivraisonLigneVentes var85 = (LivraisonLigneVentes)var55.get(var57);
               var85.setBlvligFamille(var2.getProVteCode());
               var56.modif(var85, var5);
            }
         }

         new FactureLigneVentes();
         new ArrayList();
         FactureLigneVentesDao var59 = new FactureLigneVentesDao(this.baseLog, this.utilInitHibernate);
         List var58 = var59.chargerLesMvts("", var2.getProCode(), "", 0L, "", "", var3, var4, "", var5);
         if (var58.size() != 0) {
            new FactureLigneVentes();

            for(int var60 = 0; var60 < var58.size(); ++var60) {
               FactureLigneVentes var86 = (FactureLigneVentes)var58.get(var60);
               var86.setFacligFamille(var2.getProVteCode());
               var59.modifLigne(var86, var5);
            }
         }

         new FactureInterneLigneVentes();
         new ArrayList();
         FactureInterneLigneVentesDao var62 = new FactureInterneLigneVentesDao(this.baseLog, this.utilInitHibernate);
         List var61 = var62.chargerLesMvts(var2.getProCode(), 0L, "", "", var3, var4, "", var5);
         if (var61.size() != 0) {
            new FactureInterneLigneVentes();

            for(int var63 = 0; var63 < var61.size(); ++var63) {
               FactureInterneLigneVentes var87 = (FactureInterneLigneVentes)var61.get(var63);
               var87.setFitligFamille(var2.getProVteCode());
               var62.modifLigne(var87, var5);
            }
         }

         new NoteDebitLigneVentes();
         new ArrayList();
         NoteDebitLigneVentesDao var65 = new NoteDebitLigneVentesDao(this.baseLog, this.utilInitHibernate);
         List var64 = var65.chargerLesMvts("", var2.getProCode(), 0L, "", "", var3, var4, "", var5);
         if (var64.size() != 0) {
            new NoteDebitLigneVentes();

            for(int var66 = 0; var66 < var64.size(); ++var66) {
               NoteDebitLigneVentes var88 = (NoteDebitLigneVentes)var64.get(var66);
               var88.setNdbligFamille(var2.getProVteCode());
               var65.modifLigne(var88, var5);
            }
         }

         new AvoirLigneVentes();
         new ArrayList();
         AvoirLigneVentesDao var68 = new AvoirLigneVentesDao(this.baseLog, this.utilInitHibernate);
         List var67 = var68.chargerLesMvts("", var2.getProCode(), 0L, "", "", var3, var4, "", var5);
         if (var67.size() != 0) {
            new AvoirLigneVentes();

            for(int var69 = 0; var69 < var67.size(); ++var69) {
               AvoirLigneVentes var89 = (AvoirLigneVentes)var67.get(var69);
               var89.setAvrligFamille(var2.getProVteCode());
               var68.modifLigne(var89, var5);
            }
         }
      }

   }

   public void saveFamilles() throws HibernateException, NamingException {
      this.annule();
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FamillesProduitsAchats");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.decoupageCode();
         if (this.famillesProduitsAchats.getFamachCat() <= 2 && this.famillesProduitsAchats.getFamachStock() == 0 && (this.famillesProduitsAchats.getFamachDepotAch() != null && !this.famillesProduitsAchats.getFamachDepotAch().isEmpty() && this.famillesProduitsAchats.getFamachDepotAch().contains(":") || this.famillesProduitsAchats.getFamachDepotPrd() != null && !this.famillesProduitsAchats.getFamachDepotPrd().isEmpty() && this.famillesProduitsAchats.getFamachDepotPrd().contains(":"))) {
            this.famillesProduitsAchats.setFamachStock(1);
         } else if (this.famillesProduitsAchats.getFamachCat() == 3) {
            this.famillesProduitsAchats.setFamachStock(0);
            this.famillesProduitsAchats.setFamachDepotAch("");
            this.famillesProduitsAchats.setFamachDepotPrd("");
         }

         if (this.famillesProduitsAchats.getFamachUnite() != null && !this.famillesProduitsAchats.getFamachUnite().isEmpty() && this.famillesProduitsAchats.getFamachUnite().contains(":")) {
            String[] var3 = this.famillesProduitsAchats.getFamachUnite().split(":");
            this.unite = this.uniteDao.selectUnite(var3[0], var1);
            if (this.unite != null) {
               this.famillesProduitsAchats.setFamachEchelle(this.unite.getUniEchelle());
            } else {
               this.famillesProduitsAchats.setFamachEchelle(0);
            }
         } else {
            this.famillesProduitsAchats.setFamachEchelle(0);
         }

         if (this.decoupageActivite) {
            String var15 = "";
            boolean var4 = true;
            if (this.lesDecoupagesActivites.size() != 0) {
               for(int var5 = 0; var5 < this.lesDecoupagesActivites.size(); ++var5) {
                  this.ecrituresAnalytiqueCtrl = (EcrituresAnalytiqueCtrl)this.lesDecoupagesActivites.get(var5);
                  if (this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() != 0.0F) {
                     if (var4) {
                        var15 = this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaPourcentage();
                        var4 = false;
                     } else {
                        var15 = var15 + "#" + this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaPourcentage();
                     }
                  }
               }
            }

            this.famillesProduitsAchats.setFamachActivite(var15);
         }

         if (this.famillesProduitsAchats.getFamachNature().equals("0111")) {
            this.famillesProduitsAchats.setFamachCat(4);
         }

         if (this.famillesProduitsAchats.getFamachId() == 0L) {
            this.famillesProduitsAchats.setExercicesAchats(this.exercicesAchats);
            this.famillesProduitsAchats.setFamachDateCreation(new Date());
            this.famillesProduitsAchats.setFamachUserCreation(this.usersLog.getUsrid());
            this.famillesProduitsAchats.setFamachInactif(this.getConvertionInactif());
            this.famillesProduitsAchats = this.famillesProduitsAchatsDao.insert(this.famillesProduitsAchats, var1);
            this.famillesProduitsAchatsList.add(this.famillesProduitsAchats);
            this.datamodel.setWrappedData(this.famillesProduitsAchatsList);
         } else {
            this.famillesProduitsAchats.setFamachDateModif(new Date());
            this.famillesProduitsAchats.setFamachUserModif(this.usersLog.getUsrid());
            this.famillesProduitsAchats.setFamachInactif(this.getConvertionInactif());
            this.famillesProduitsAchats = this.famillesProduitsAchatsDao.modif(this.famillesProduitsAchats, var1);
         }

         if (this.var_maj_prod && this.lesProduits.size() != 0) {
            int var16 = 0;

            label647:
            while(true) {
               if (var16 >= this.lesProduits.size()) {
                  ProduitsDepotDao var6;
                  ProduitsDepot var7;
                  int var8;
                  Produits var9;
                  DepotAchatsDao var18;
                  DepotAchats var19;
                  String[] var20;
                  if (this.famillesProduitsAchats.getFamachDepotAch() != null && !this.famillesProduitsAchats.getFamachDepotAch().isEmpty() && this.famillesProduitsAchats.getFamachDepotAch().contains(":")) {
                     new DepotAchats();
                     var18 = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
                     var20 = this.famillesProduitsAchats.getFamachDepotAch().split(":");
                     var19 = var18.trouveDepot(var20[0], var1);
                     if (var19 != null) {
                        var6 = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
                        new ProduitsDepot();

                        for(var8 = 0; var8 < this.lesProduits.size(); ++var8) {
                           new Produits();
                           var9 = (Produits)this.lesProduits.get(var8);
                           var7 = var6.produitDepByprod(var9.getProCode(), var20[0], var1);
                           if (var7 == null) {
                              var7 = new ProduitsDepot();
                              var7.setProduits(var9);
                              var7.setUnite((Unite)null);
                              var7.setDepot(var19);
                              var7.setProdepCle(var19.getDpoCode() + ":" + var9.getProCode());
                              var7.setProdepCle2(var7.getProdepGroupe() + ":" + var9.getProCode());
                              var6.insert(var7, var1);
                           }
                        }
                     }
                  }

                  if (this.famillesProduitsAchats.getFamachDepotPrd() != null && !this.famillesProduitsAchats.getFamachDepotPrd().isEmpty() && this.famillesProduitsAchats.getFamachDepotPrd().contains(":")) {
                     new DepotAchats();
                     var18 = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
                     var20 = this.famillesProduitsAchats.getFamachDepotPrd().split(":");
                     var19 = var18.trouveDepot(var20[0], var1);
                     if (var19 != null) {
                        var6 = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
                        new ProduitsDepot();

                        for(var8 = 0; var8 < this.lesProduits.size(); ++var8) {
                           new Produits();
                           var9 = (Produits)this.lesProduits.get(var8);
                           var7 = var6.produitDepByprod(var9.getProCode(), var20[0], var1);
                           if (var7 == null) {
                              var7 = new ProduitsDepot();
                              var7.setProduits(var9);
                              var7.setUnite((Unite)null);
                              var7.setDepot(var19);
                              var7.setProdepCle(var19.getDpoCode() + ":" + var9.getProCode());
                              var7.setProdepCle2(var7.getProdepGroupe() + ":" + var9.getProCode());
                              var6.insert(var7, var1);
                           }
                        }
                     }
                  }

                  if (this.famillesProduitsAchats.getFamachService() == null || this.famillesProduitsAchats.getFamachService().isEmpty() || !this.famillesProduitsAchats.getFamachService().contains(":")) {
                     break;
                  }

                  new Service();
                  ServiceDao var21 = new ServiceDao(this.baseLog, this.utilInitHibernate);
                  var20 = this.famillesProduitsAchats.getFamachService().split(":");
                  Service var22 = var21.chargerLeServiceCode(var20[0], var1);
                  if (var22 == null) {
                     break;
                  }

                  ProduitsServicesDao var26 = new ProduitsServicesDao(this.baseLog, this.utilInitHibernate);
                  new ProduitsServices();
                  var8 = 0;

                  while(true) {
                     if (var8 >= this.lesProduits.size()) {
                        break label647;
                     }

                     new Produits();
                     var9 = (Produits)this.lesProduits.get(var8);
                     ProduitsServices var28 = var26.selectCode(var9, var20[0], var1);
                     if (var28 == null) {
                        var28 = new ProduitsServices();
                        var28.setProduits(var9);
                        var28.setServices(var22);
                        var28.setProserCode(var22.getSerCode());
                        var28.setProserNomFr(var22.getSerNomFr());
                        var26.insert(var28, var1);
                     }

                     ++var8;
                  }
               }

               new Produits();
               Produits var17 = (Produits)this.lesProduits.get(var16);
               var17.setProAchNat(this.famillesProduitsAchats.getFamachNature());
               var17.setProAchLib(this.famillesProduitsAchats.getFamachLibelleFr());
               var17.setProAchDouane(this.famillesProduitsAchats.getFamachDouane());
               var17.setProStock(this.famillesProduitsAchats.getFamachStock());
               var17.setProAchCpteCh(this.famillesProduitsAchats.getFamachCompteCharge());
               var17.setProAchCpteHz(this.famillesProduitsAchats.getFamachCompteExterieur());
               var17.setProAchCpteLoc(this.famillesProduitsAchats.getFamachCompteLocal());
               var17.setProAchCpteSt(this.famillesProduitsAchats.getFamachCompteStock());
               var17.setProAchCpteZ(this.famillesProduitsAchats.getFamachCompteZone());
               var17.setProDepotAch(this.famillesProduitsAchats.getFamachDepotAch());
               var17.setProDepotPrd(this.famillesProduitsAchats.getFamachDepotPrd());
               var17.setProAchTva(this.famillesProduitsAchats.getFamachTaxe());
               if (this.famillesProduitsAchats.getFamachMarque() == null || this.famillesProduitsAchats.getFamachMarque().isEmpty()) {
                  var17.setProMarque(this.famillesProduitsAchats.getFamachMarque());
               }

               if (this.famillesProduitsAchats.getFamachCondition1() == null || this.famillesProduitsAchats.getFamachCondition1().isEmpty()) {
                  var17.setProCondition1(this.famillesProduitsAchats.getFamachCondition1());
               }

               if (this.famillesProduitsAchats.getFamachCondition2() == null || this.famillesProduitsAchats.getFamachCondition2().isEmpty()) {
                  var17.setProCondition2(this.famillesProduitsAchats.getFamachCondition2());
               }

               if (this.famillesProduitsAchats.getFamachCondition3() == null || this.famillesProduitsAchats.getFamachCondition3().isEmpty()) {
                  var17.setProCondition3(this.famillesProduitsAchats.getFamachCondition3());
               }

               if (this.famillesProduitsAchats.getFamachCondition4() == null || this.famillesProduitsAchats.getFamachCondition4().isEmpty()) {
                  var17.setProCondition4(this.famillesProduitsAchats.getFamachCondition4());
               }

               if (this.famillesProduitsAchats.getFamachCondition5() == null || this.famillesProduitsAchats.getFamachCondition5().isEmpty()) {
                  var17.setProCondition5(this.famillesProduitsAchats.getFamachCondition5());
               }

               this.produitsAchsDao.modif(var17, var1);
               ++var16;
            }
         }

         if (this.famillesProduitsAchats.isFamachLieeVte() && !this.famillesProduitsAchats.getFamachNature().equals("0111")) {
            new ExercicesVentes();
            ExercicesVentesDao var23 = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
            ExercicesVentes var24 = var23.recupererLastExo(var1);
            if (var24 != null) {
               new FamillesProduitsVentes();
               FamillesProduitsVentesDao var27 = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
               FamillesProduitsVentes var25 = var27.rechercheFamilleByCode(var24.getExevteId(), this.famillesProduitsAchats.getFamachCode(), var1);
               if (var25 != null) {
                  var25.setFamvteDateModif(new Date());
                  var25.setFamvteUserModif(this.usersLog.getUsrid());
                  var25.setFamvteLibelleFr(this.famillesProduitsAchats.getFamachLibelleFr());
                  var25.setFamvteLibelleUk(this.famillesProduitsAchats.getFamachLibelleUk());
                  var25.setFamvteLibelleSp(this.famillesProduitsAchats.getFamachLibelleSp());
                  var25.setFamvteDouane(this.famillesProduitsAchats.getFamachDouane());
                  if (this.famillesProduitsAchats.getFamachNature().equals("0101")) {
                     var25.setFamvteNature("1601");
                  } else if (this.famillesProduitsAchats.getFamachNature().equals("0102")) {
                     var25.setFamvteNature("1602");
                  } else if (this.famillesProduitsAchats.getFamachNature().equals("0103")) {
                     var25.setFamvteNature("1603");
                  } else if (this.famillesProduitsAchats.getFamachNature().equals("0104")) {
                     var25.setFamvteNature("1604");
                  } else if (this.famillesProduitsAchats.getFamachNature().equals("0105")) {
                     var25.setFamvteNature("1605");
                  } else if (this.famillesProduitsAchats.getFamachNature().equals("0106")) {
                     var25.setFamvteNature("1606");
                  } else if (this.famillesProduitsAchats.getFamachNature().equals("0110")) {
                     var25.setFamvteNature("1610");
                  } else if (this.famillesProduitsAchats.getFamachNature().equals("0112")) {
                     var25.setFamvteNature("1612");
                  } else if (this.famillesProduitsAchats.getFamachNature().equals("0113")) {
                     var25.setFamvteNature("1613");
                  } else if (this.famillesProduitsAchats.getFamachNature().equals("0114")) {
                     var25.setFamvteNature("1614");
                  } else if (this.famillesProduitsAchats.getFamachNature().equals("0115")) {
                     var25.setFamvteNature("1615");
                  } else if (this.famillesProduitsAchats.getFamachNature().equals("1101")) {
                     var25.setFamvteNature("1101");
                  } else if (this.famillesProduitsAchats.getFamachNature().equals("1104")) {
                     var25.setFamvteNature("1104");
                  } else if (this.famillesProduitsAchats.getFamachNature().equals("1105")) {
                     var25.setFamvteNature("1105");
                  } else if (this.famillesProduitsAchats.getFamachNature().equals("1106")) {
                     var25.setFamvteNature("1106");
                  } else if (this.famillesProduitsAchats.getFamachNature().equals("1107")) {
                     var25.setFamvteNature("1107");
                  } else {
                     var25.setFamvteNature(this.famillesProduitsAchats.getFamachNature());
                  }

                  var25.setFamvteLibNature(this.famillesProduitsAchats.getFamachLibNature());
                  var25.setFamvteCat(this.famillesProduitsAchats.getFamachCat());
                  var25.setFamvteStock(this.famillesProduitsAchats.getFamachStock());
                  var25.setFamvteActivite(this.famillesProduitsAchats.getFamachActivite());
                  var25.setFamvteMarque(this.famillesProduitsAchats.getFamachMarque());
                  var25.setFamvteInactif(this.famillesProduitsAchats.getFamachInactif());
                  var25.setExerciceventes(var24);
                  var27.modif(var25, var1);
               } else {
                  var25 = new FamillesProduitsVentes();
                  var25.setFamvteDateCreation(new Date());
                  var25.setFamvteUserCreation(this.usersLog.getUsrid());
                  var25.setFamvteCode(this.famillesProduitsAchats.getFamachCode());
                  var25.setFamvteLibelleFr(this.famillesProduitsAchats.getFamachLibelleFr());
                  var25.setFamvteLibelleUk(this.famillesProduitsAchats.getFamachLibelleUk());
                  var25.setFamvteLibelleSp(this.famillesProduitsAchats.getFamachLibelleSp());
                  var25.setFamvteDouane(this.famillesProduitsAchats.getFamachDouane());
                  if (this.famillesProduitsAchats.getFamachNature().equals("0101")) {
                     var25.setFamvteNature("1601");
                  } else if (this.famillesProduitsAchats.getFamachNature().equals("0102")) {
                     var25.setFamvteNature("1602");
                  } else if (this.famillesProduitsAchats.getFamachNature().equals("0103")) {
                     var25.setFamvteNature("1603");
                  } else if (this.famillesProduitsAchats.getFamachNature().equals("0104")) {
                     var25.setFamvteNature("1604");
                  } else if (this.famillesProduitsAchats.getFamachNature().equals("0105")) {
                     var25.setFamvteNature("1605");
                  } else if (this.famillesProduitsAchats.getFamachNature().equals("0106")) {
                     var25.setFamvteNature("1606");
                  } else if (this.famillesProduitsAchats.getFamachNature().equals("0110")) {
                     var25.setFamvteNature("1610");
                  } else if (this.famillesProduitsAchats.getFamachNature().equals("0112")) {
                     var25.setFamvteNature("1612");
                  } else if (this.famillesProduitsAchats.getFamachNature().equals("0113")) {
                     var25.setFamvteNature("1613");
                  } else if (this.famillesProduitsAchats.getFamachNature().equals("0114")) {
                     var25.setFamvteNature("1614");
                  } else if (this.famillesProduitsAchats.getFamachNature().equals("0115")) {
                     var25.setFamvteNature("1615");
                  }

                  var25.setFamvteLibNature(this.famillesProduitsAchats.getFamachLibNature());
                  var25.setFamvteCat(this.famillesProduitsAchats.getFamachCat());
                  var25.setFamvteStock(this.famillesProduitsAchats.getFamachStock());
                  var25.setFamvteActivite(this.famillesProduitsAchats.getFamachActivite());
                  var25.setFamvteMarque(this.famillesProduitsAchats.getFamachMarque());
                  var25.setFamvteInactif(this.famillesProduitsAchats.getFamachInactif());
                  var25.setExerciceventes(var24);
                  var27.insert(var25, var1);
               }
            }
         }

         var2.commit();
      } catch (HibernateException var13) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var13;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.setVisibiliteBton(false);
      this.setShowModalPanel(false);
   }

   public void supprimerFamillesProduitsAchats() throws IOException, JDOMException, HibernateException, NamingException, ParseException {
      this.annule();
      if (this.famillesProduitsAchats != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FamillesProduitsAchats");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.famillesProduitsAchatsDao.delFamilleProd(this.famillesProduitsAchats, var1);
            if (this.famillesProduitsAchats.isFamachLieeVte() && !this.famillesProduitsAchats.getFamachNature().equals("0111")) {
               new ExercicesVentes();
               ExercicesVentesDao var4 = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
               ExercicesVentes var3 = var4.recupererLastExo(var1);
               if (var3 != null) {
                  new FamillesProduitsVentes();
                  FamillesProduitsVentesDao var6 = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
                  FamillesProduitsVentes var5 = var6.rechercheFamilleByCode(var3.getExevteId(), this.famillesProduitsAchats.getFamachCode(), var1);
                  if (var5 != null) {
                     var6.deletFamillesProduitsVentes(var5.getFamvteId(), var1);
                  }
               }
            }

            var2.commit();
         } catch (HibernateException var10) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var10;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.lesFamillesProduitsAchats((Session)null);
      }

      this.visibiliteBton = false;
   }

   public void decoupageCode() {
      if (this.getInpNature() != null && !this.getInpNature().isEmpty() && this.getInpNature().contains(":")) {
         String[] var1 = this.getInpNature().split(":");
         this.famillesProduitsAchats.setFamachNature(var1[0]);
         this.famillesProduitsAchats.setFamachLibNature(var1[1]);
      }

   }

   public void verifCode() throws HibernateException, NamingException {
      if (this.famillesProduitsAchats.getFamachCode().equalsIgnoreCase("")) {
         this.existCod = false;
      } else {
         this.existCod = this.famillesProduitsAchatsDao.existCode(this.exercicesAchats.getExeachId(), this.famillesProduitsAchats.getFamachCode(), (Session)null);
      }

   }

   public void verifFouConditionnement1() {
      if (this.famillesProduitsAchats.getFamachCondition1() != null && !this.famillesProduitsAchats.getFamachCondition1().isEmpty()) {
         if (this.famillesProduitsAchats.getFamachCondition2() != null && !this.famillesProduitsAchats.getFamachCondition2().isEmpty() && this.famillesProduitsAchats.getFamachCondition1().contentEquals(this.famillesProduitsAchats.getFamachCondition2())) {
            this.famillesProduitsAchats.setFamachCondition1("");
         }

         if (this.famillesProduitsAchats.getFamachCondition3() != null && !this.famillesProduitsAchats.getFamachCondition3().isEmpty() && this.famillesProduitsAchats.getFamachCondition1().contentEquals(this.famillesProduitsAchats.getFamachCondition3())) {
            this.famillesProduitsAchats.setFamachCondition1("");
         }

         if (this.famillesProduitsAchats.getFamachCondition4() != null && !this.famillesProduitsAchats.getFamachCondition4().isEmpty() && this.famillesProduitsAchats.getFamachCondition1().contentEquals(this.famillesProduitsAchats.getFamachCondition4())) {
            this.famillesProduitsAchats.setFamachCondition1("");
         }

         if (this.famillesProduitsAchats.getFamachCondition5() != null && !this.famillesProduitsAchats.getFamachCondition5().isEmpty() && this.famillesProduitsAchats.getFamachCondition1().contentEquals(this.famillesProduitsAchats.getFamachCondition5())) {
            this.famillesProduitsAchats.setFamachCondition1("");
         }
      }

   }

   public void verifFouConditionnement2() {
      if (this.famillesProduitsAchats.getFamachCondition2() != null && !this.famillesProduitsAchats.getFamachCondition2().isEmpty()) {
         if (this.famillesProduitsAchats.getFamachCondition1() != null && !this.famillesProduitsAchats.getFamachCondition1().isEmpty() && this.famillesProduitsAchats.getFamachCondition2().contentEquals(this.famillesProduitsAchats.getFamachCondition1())) {
            this.famillesProduitsAchats.setFamachCondition2("");
         }

         if (this.famillesProduitsAchats.getFamachCondition3() != null && !this.famillesProduitsAchats.getFamachCondition3().isEmpty() && this.famillesProduitsAchats.getFamachCondition2().contentEquals(this.famillesProduitsAchats.getFamachCondition3())) {
            this.famillesProduitsAchats.setFamachCondition2("");
         }

         if (this.famillesProduitsAchats.getFamachCondition4() != null && !this.famillesProduitsAchats.getFamachCondition4().isEmpty() && this.famillesProduitsAchats.getFamachCondition2().contentEquals(this.famillesProduitsAchats.getFamachCondition4())) {
            this.famillesProduitsAchats.setFamachCondition2("");
         }

         if (this.famillesProduitsAchats.getFamachCondition5() != null && !this.famillesProduitsAchats.getFamachCondition5().isEmpty() && this.famillesProduitsAchats.getFamachCondition2().contentEquals(this.famillesProduitsAchats.getFamachCondition5())) {
            this.famillesProduitsAchats.setFamachCondition2("");
         }
      }

   }

   public void verifFouConditionnement3() {
      if (this.famillesProduitsAchats.getFamachCondition3() != null && !this.famillesProduitsAchats.getFamachCondition3().isEmpty()) {
         if (this.famillesProduitsAchats.getFamachCondition1() != null && !this.famillesProduitsAchats.getFamachCondition1().isEmpty() && this.famillesProduitsAchats.getFamachCondition3().contentEquals(this.famillesProduitsAchats.getFamachCondition1())) {
            this.famillesProduitsAchats.setFamachCondition3("");
         }

         if (this.famillesProduitsAchats.getFamachCondition2() != null && !this.famillesProduitsAchats.getFamachCondition2().isEmpty() && this.famillesProduitsAchats.getFamachCondition3().contentEquals(this.famillesProduitsAchats.getFamachCondition2())) {
            this.famillesProduitsAchats.setFamachCondition3("");
         }

         if (this.famillesProduitsAchats.getFamachCondition4() != null && !this.famillesProduitsAchats.getFamachCondition4().isEmpty() && this.famillesProduitsAchats.getFamachCondition3().contentEquals(this.famillesProduitsAchats.getFamachCondition4())) {
            this.famillesProduitsAchats.setFamachCondition3("");
         }

         if (this.famillesProduitsAchats.getFamachCondition5() != null && !this.famillesProduitsAchats.getFamachCondition5().isEmpty() && this.famillesProduitsAchats.getFamachCondition3().contentEquals(this.famillesProduitsAchats.getFamachCondition5())) {
            this.famillesProduitsAchats.setFamachCondition3("");
         }
      }

   }

   public void verifFouConditionnement4() {
      if (this.famillesProduitsAchats.getFamachCondition4() != null && !this.famillesProduitsAchats.getFamachCondition4().isEmpty()) {
         if (this.famillesProduitsAchats.getFamachCondition1() != null && !this.famillesProduitsAchats.getFamachCondition1().isEmpty() && this.famillesProduitsAchats.getFamachCondition4().contentEquals(this.famillesProduitsAchats.getFamachCondition1())) {
            this.famillesProduitsAchats.setFamachCondition4("");
         }

         if (this.famillesProduitsAchats.getFamachCondition2() != null && !this.famillesProduitsAchats.getFamachCondition2().isEmpty() && this.famillesProduitsAchats.getFamachCondition4().contentEquals(this.famillesProduitsAchats.getFamachCondition2())) {
            this.famillesProduitsAchats.setFamachCondition4("");
         }

         if (this.famillesProduitsAchats.getFamachCondition3() != null && !this.famillesProduitsAchats.getFamachCondition3().isEmpty() && this.famillesProduitsAchats.getFamachCondition4().contentEquals(this.famillesProduitsAchats.getFamachCondition3())) {
            this.famillesProduitsAchats.setFamachCondition4("");
         }

         if (this.famillesProduitsAchats.getFamachCondition5() != null && !this.famillesProduitsAchats.getFamachCondition5().isEmpty() && this.famillesProduitsAchats.getFamachCondition4().contentEquals(this.famillesProduitsAchats.getFamachCondition5())) {
            this.famillesProduitsAchats.setFamachCondition4("");
         }
      }

   }

   public void verifFouConditionnement5() {
      if (this.famillesProduitsAchats.getFamachCondition5() != null && !this.famillesProduitsAchats.getFamachCondition5().isEmpty()) {
         if (this.famillesProduitsAchats.getFamachCondition1() != null && !this.famillesProduitsAchats.getFamachCondition1().isEmpty() && this.famillesProduitsAchats.getFamachCondition5().contentEquals(this.famillesProduitsAchats.getFamachCondition1())) {
            this.famillesProduitsAchats.setFamachCondition5("");
         }

         if (this.famillesProduitsAchats.getFamachCondition2() != null && !this.famillesProduitsAchats.getFamachCondition2().isEmpty() && this.famillesProduitsAchats.getFamachCondition5().contentEquals(this.famillesProduitsAchats.getFamachCondition2())) {
            this.famillesProduitsAchats.setFamachCondition5("");
         }

         if (this.famillesProduitsAchats.getFamachCondition3() != null && !this.famillesProduitsAchats.getFamachCondition3().isEmpty() && this.famillesProduitsAchats.getFamachCondition5().contentEquals(this.famillesProduitsAchats.getFamachCondition3())) {
            this.famillesProduitsAchats.setFamachCondition5("");
         }

         if (this.famillesProduitsAchats.getFamachCondition4() != null && !this.famillesProduitsAchats.getFamachCondition4().isEmpty() && this.famillesProduitsAchats.getFamachCondition4().contentEquals(this.famillesProduitsAchats.getFamachCondition5())) {
            this.famillesProduitsAchats.setFamachCondition5("");
         }
      }

   }

   public int getConvertionInactif() {
      if (!this.inactif) {
         this.convertionInactif = 0;
      } else {
         this.convertionInactif = 1;
      }

      return this.convertionInactif;
   }

   public void setConvertionInactif(int var1) {
      this.convertionInactif = var1;
   }

   public boolean isInactif() {
      return this.inactif;
   }

   public void setInactif(boolean var1) {
      this.inactif = var1;
   }

   public boolean isVisibiliteBton() {
      return this.visibiliteBton;
   }

   public void setVisibiliteBton(boolean var1) {
      this.visibiliteBton = var1;
   }

   public DataModel getDatamodel() {
      return this.datamodel;
   }

   public void setDatamodel(DataModel var1) {
      this.datamodel = var1;
   }

   public String getValAjt() {
      return this.valAjt;
   }

   public void setValAjt(String var1) {
      this.valAjt = var1;
   }

   public String getValImp() {
      return this.valImp;
   }

   public void setValImp(String var1) {
      this.valImp = var1;
   }

   public String getValMod() {
      return this.valMod;
   }

   public void setValMod(String var1) {
      this.valMod = var1;
   }

   public String getValSup() {
      return this.valSup;
   }

   public void setValSup(String var1) {
      this.valSup = var1;
   }

   public FamillesProduitsAchats getFamillesProduitsAchats() {
      return this.famillesProduitsAchats;
   }

   public void setFamillesProduitsAchats(FamillesProduitsAchats var1) {
      this.famillesProduitsAchats = var1;
   }

   public List getFamillesProduitsAchatsList() {
      return this.famillesProduitsAchatsList;
   }

   public void setFamillesProduitsAchatsList(List var1) {
      this.famillesProduitsAchatsList = var1;
   }

   public List getMesnaturesItems() {
      return this.mesnaturesItems;
   }

   public void setMesnaturesItems(List var1) {
      this.mesnaturesItems = var1;
   }

   public List getLesNaturesFamillesProdAchats() {
      return this.lesNaturesFamillesProdAchats;
   }

   public void setLesNaturesFamillesProdAchats(List var1) {
      this.lesNaturesFamillesProdAchats = var1;
   }

   public boolean isExistCod() {
      return this.existCod;
   }

   public void setExistCod(boolean var1) {
      this.existCod = var1;
   }

   public String getInpNature() {
      return this.inpNature;
   }

   public void setInpNature(String var1) {
      this.inpNature = var1;
   }

   public String getInpNatureModif() {
      return this.inpNatureModif;
   }

   public void setInpNatureModif(String var1) {
      this.inpNatureModif = var1;
   }

   public String getInpPosTarif() {
      return this.inpPosTarif;
   }

   public void setInpPosTarif(String var1) {
      this.inpPosTarif = var1;
   }

   public String getInpPosTarifModif() {
      return this.inpPosTarifModif;
   }

   public void setInpPosTarifModif(String var1) {
      this.inpPosTarifModif = var1;
   }

   public ExercicesAchats getExercicesAchats() {
      return this.exercicesAchats;
   }

   public void setExercicesAchats(ExercicesAchats var1) {
      this.exercicesAchats = var1;
   }

   public LireLesoptionsAchats getLireLesoptionsAchats() {
      return this.lireLesoptionsAchats;
   }

   public void setLireLesoptionsAchats(LireLesoptionsAchats var1) {
      this.lireLesoptionsAchats = var1;
   }

   public LectureNatureAchats getNaturesFamillesProdAchats() {
      return this.naturesFamillesProdAchats;
   }

   public void setNaturesFamillesProdAchats(LectureNatureAchats var1) {
      this.naturesFamillesProdAchats = var1;
   }

   public boolean isShowModalPanel() {
      return this.showModalPanel;
   }

   public void setShowModalPanel(boolean var1) {
      this.showModalPanel = var1;
   }

   public OptionAchats getOptionAchats() {
      return this.optionAchats;
   }

   public void setOptionAchats(OptionAchats var1) {
      this.optionAchats = var1;
   }

   public List getMesActivitesItems() {
      return this.mesActivitesItems;
   }

   public void setMesActivitesItems(List var1) {
      this.mesActivitesItems = var1;
   }

   public List getMesBudgetsItems() {
      return this.mesBudgetsItems;
   }

   public void setMesBudgetsItems(List var1) {
      this.mesBudgetsItems = var1;
   }

   public List getMesDossiersItems() {
      return this.mesDossiersItems;
   }

   public void setMesDossiersItems(List var1) {
      this.mesDossiersItems = var1;
   }

   public List getMesParcsItems() {
      return this.mesParcsItems;
   }

   public void setMesParcsItems(List var1) {
      this.mesParcsItems = var1;
   }

   public List getMesTaxesItems() {
      return this.mesTaxesItems;
   }

   public void setMesTaxesItems(List var1) {
      this.mesTaxesItems = var1;
   }

   public long getFamachIdSelect() {
      return this.famachIdSelect;
   }

   public void setFamachIdSelect(long var1) {
      this.famachIdSelect = var1;
   }

   public List getMesAchHorsZoneItems() {
      return this.mesAchHorsZoneItems;
   }

   public void setMesAchHorsZoneItems(List var1) {
      this.mesAchHorsZoneItems = var1;
   }

   public List getMesAchLocalItems() {
      return this.mesAchLocalItems;
   }

   public void setMesAchLocalItems(List var1) {
      this.mesAchLocalItems = var1;
   }

   public List getMesAchProduitItems() {
      return this.mesAchProduitItems;
   }

   public void setMesAchProduitItems(List var1) {
      this.mesAchProduitItems = var1;
   }

   public List getMesAchStockItems() {
      return this.mesAchStockItems;
   }

   public void setMesAchStockItems(List var1) {
      this.mesAchStockItems = var1;
   }

   public List getMesAchZoneItems() {
      return this.mesAchZoneItems;
   }

   public void setMesAchZoneItems(List var1) {
      this.mesAchZoneItems = var1;
   }

   public List getLesProduits() {
      return this.lesProduits;
   }

   public void setLesProduits(List var1) {
      this.lesProduits = var1;
   }

   public boolean isVar_aff_maj() {
      return this.var_aff_maj;
   }

   public void setVar_aff_maj(boolean var1) {
      this.var_aff_maj = var1;
   }

   public boolean isVar_maj_prod() {
      return this.var_maj_prod;
   }

   public void setVar_maj_prod(boolean var1) {
      this.var_maj_prod = var1;
   }

   public List getMesDepotsAchats() {
      return this.mesDepotsAchats;
   }

   public void setMesDepotsAchats(List var1) {
      this.mesDepotsAchats = var1;
   }

   public List getMesDepotsProduction() {
      return this.mesDepotsProduction;
   }

   public void setMesDepotsProduction(List var1) {
      this.mesDepotsProduction = var1;
   }

   public List getMesServicesItems() {
      return this.mesServicesItems;
   }

   public void setMesServicesItems(List var1) {
      this.mesServicesItems = var1;
   }

   public String getVar_onglet() {
      return this.var_onglet;
   }

   public void setVar_onglet(String var1) {
      this.var_onglet = var1;
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

   public List getMesMarquesItems() {
      return this.mesMarquesItems;
   }

   public void setMesMarquesItems(List var1) {
      this.mesMarquesItems = var1;
   }

   public List getMesDouanesItems() {
      return this.mesDouanesItems;
   }

   public void setMesDouanesItems(List var1) {
      this.mesDouanesItems = var1;
   }

   public List getMesConditionnementsItems() {
      return this.mesConditionnementsItems;
   }

   public void setMesConditionnementsItems(List var1) {
      this.mesConditionnementsItems = var1;
   }

   public List getMesUnitesItems() {
      return this.mesUnitesItems;
   }

   public void setMesUnitesItems(List var1) {
      this.mesUnitesItems = var1;
   }

   public List getMesClesItems() {
      return this.mesClesItems;
   }

   public void setMesClesItems(List var1) {
      this.mesClesItems = var1;
   }

   public DataModel getDataModelDecoupageActivtes() {
      return this.dataModelDecoupageActivtes;
   }

   public void setDataModelDecoupageActivtes(DataModel var1) {
      this.dataModelDecoupageActivtes = var1;
   }

   public boolean isDecoupageActivite() {
      return this.decoupageActivite;
   }

   public void setDecoupageActivite(boolean var1) {
      this.decoupageActivite = var1;
   }

   public List getLaColonne1Items() {
      return this.laColonne1Items;
   }

   public void setLaColonne1Items(List var1) {
      this.laColonne1Items = var1;
   }

   public List getLaColonne2Items() {
      return this.laColonne2Items;
   }

   public void setLaColonne2Items(List var1) {
      this.laColonne2Items = var1;
   }

   public List getLaColonne3Items() {
      return this.laColonne3Items;
   }

   public void setLaColonne3Items(List var1) {
      this.laColonne3Items = var1;
   }

   public String getVar_colonne1() {
      return this.var_colonne1;
   }

   public void setVar_colonne1(String var1) {
      this.var_colonne1 = var1;
   }

   public String getVar_colonne2() {
      return this.var_colonne2;
   }

   public void setVar_colonne2(String var1) {
      this.var_colonne2 = var1;
   }

   public String getVar_colonne3() {
      return this.var_colonne3;
   }

   public void setVar_colonne3(String var1) {
      this.var_colonne3 = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public boolean isChgFamille() {
      return this.chgFamille;
   }

   public void setChgFamille(boolean var1) {
      this.chgFamille = var1;
   }

   public List getMesFamillesAchats() {
      return this.mesFamillesAchats;
   }

   public void setMesFamillesAchats(List var1) {
      this.mesFamillesAchats = var1;
   }

   public String getNewFamille() {
      return this.newFamille;
   }

   public void setNewFamille(String var1) {
      this.newFamille = var1;
   }
}
