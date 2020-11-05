package com.epegase.forms.administration;

import com.epegase.systeme.classe.AvoirLigneVentes;
import com.epegase.systeme.classe.CommandeLigneVentes;
import com.epegase.systeme.classe.DepotAchats;
import com.epegase.systeme.classe.DevisLigneVentes;
import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FactureLigneVentes;
import com.epegase.systeme.classe.FamillesProduitsVentes;
import com.epegase.systeme.classe.LivraisonLigneVentes;
import com.epegase.systeme.classe.NoteDebitLigneVentes;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsDepot;
import com.epegase.systeme.classe.ProduitsServices;
import com.epegase.systeme.classe.RetourLigneVentes;
import com.epegase.systeme.classe.Service;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.TaxesVentes;
import com.epegase.systeme.classe.Unite;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.EcrituresAnalytiqueCtrl;
import com.epegase.systeme.dao.ActivitesDao;
import com.epegase.systeme.dao.AvoirLigneVentesDao;
import com.epegase.systeme.dao.BudgetDao;
import com.epegase.systeme.dao.CommandeLigneVentesDao;
import com.epegase.systeme.dao.DepotAchatsDao;
import com.epegase.systeme.dao.DevisLigneVentesDao;
import com.epegase.systeme.dao.DouanesPositionDao;
import com.epegase.systeme.dao.ExercicesAchatsDao;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.FactureLigneVentesDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.LivraisonLigneVentesDao;
import com.epegase.systeme.dao.MarquesDao;
import com.epegase.systeme.dao.NoteDebitLigneVentesDao;
import com.epegase.systeme.dao.PlanComptableDao;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
import com.epegase.systeme.dao.ProduitsDepotDao;
import com.epegase.systeme.dao.ProduitsServicesDao;
import com.epegase.systeme.dao.ProduitsVtesDao;
import com.epegase.systeme.dao.RetourLigneVentesDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.TaxesVentesDao;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureNatureMedical;
import com.epegase.systeme.xml.LectureNatureVentes;
import com.epegase.systeme.xml.LireLesoptionsMedical;
import com.epegase.systeme.xml.LireLesoptionsVentes;
import com.epegase.systeme.xml.OptionMedical;
import com.epegase.systeme.xml.OptionVentes;
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

public class FormFamilleProduitsVentes implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private ExercicesVentes exercicesVentes;
   private FamillesProduitsVentes famillesProduitsVentes = new FamillesProduitsVentes();
   private FamillesProduitsVentesDao famillesProduitsVentesDao;
   private List famillesProduitsVentesList = new ArrayList();
   private long famvteIdSelect;
   private transient DataModel datamodel = new ListDataModel();
   private String valAjt = "false";
   private String valMod = "false";
   private String valSup = "false";
   private String valImp = "false";
   private boolean inactif;
   private int convertionInactif;
   private boolean visibiliteBton;
   private boolean showModalPanel;
   private LectureNatureVentes naturesFamillesProdVentes;
   private List lesNaturesFamillesProdVentes = new ArrayList();
   private List mesnaturesItems = new ArrayList();
   private List mesTaxesItems;
   private List mesVteLocalItems;
   private List mesVteZoneItems;
   private List mesVteHorsZoneItems;
   private List mesVteStockItems;
   private List mesVteProduitItems;
   private List mesVteCaissesItems;
   private List mesDouanesItems;
   private boolean existCod = true;
   private String inpNatureModif;
   private String inpNature;
   private String var_onglet;
   private LireLesoptionsVentes lireLesoptionsVentes;
   private OptionVentes optionVentes;
   private LireLesoptionsMedical lireLesoptionsMedical;
   private OptionMedical optionMedical;
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
   private ProduitsVtesDao produitsVtesDao;
   private List mesDepotsVentes = new ArrayList();
   private String inpPosTarif;
   private String inpPosTarifModif;
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

   public FormFamilleProduitsVentes() throws JDOMException, IOException {
   }

   public void InstancesDaoUtilses() {
      this.famillesProduitsVentesDao = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
      this.produitsVtesDao = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
   }

   public void elementsBase(int var1, Session var2) throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.recupererMesnaturesItems(var1);
      this.recupererMesDepotsItems(var2);
      this.recupererActivitesItems(var2);
      this.recupererClesItems(var2);
      this.recupererServicesItems(var2);
      this.recupererMarquesItems(var1, var2);
      this.recupererBudgetItem(var2);
      this.recupererDossierItem(var2);
      this.recupererParcItem(var2);
      this.recupererTaxesItem(var2);
      this.recupererComptesItem(var2);
      this.recupererDouanesItem(var2);
      this.recupOptionsVentes(var1);
   }

   public void lesFamillesProduitsVentes(Session var1) throws IOException, JDOMException, HibernateException, NamingException, ParseException {
      this.famillesProduitsVentesList.clear();
      this.famillesProduitsVentesList = this.famillesProduitsVentesDao.selectAllFamillProd(this.exercicesVentes.getExevteId(), var1);
      String var2 = "";
      if (this.famillesProduitsVentesList.size() != 0) {
         for(int var3 = 0; var3 < this.famillesProduitsVentesList.size(); ++var3) {
            this.famillesProduitsVentes = (FamillesProduitsVentes)this.famillesProduitsVentesList.get(var3);
            if (this.famillesProduitsVentes.getFamvteCat() == 99) {
               var2 = this.famillesProduitsVentes.getFamvteCode();
            } else {
               this.famillesProduitsVentes.setFamvteOrigine(var2);
               this.famillesProduitsVentes = this.famillesProduitsVentesDao.modif(this.famillesProduitsVentes, var1);
            }
         }
      }

      this.datamodel.setWrappedData(this.famillesProduitsVentesList);
   }

   public void recupererMesnaturesItems(int var1) throws JDOMException, IOException {
      if (var1 == 85) {
         LectureNatureMedical var2 = new LectureNatureMedical();
         this.mesnaturesItems = var2.getMesNatureMedicalItems();
      } else {
         LectureNatureVentes var3 = new LectureNatureVentes();
         this.mesnaturesItems = var3.getMesNatureVentesItems();
      }

   }

   public void recupererMesDepotsItems(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.mesDepotsVentes.clear();
      DepotAchatsDao var2 = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
      this.mesDepotsVentes = var2.selectActifDepotItems(23, var1);
   }

   public void recupOptionsVentes(int var1) throws IOException {
      if (var1 == 85) {
         this.lireLesoptionsMedical = new LireLesoptionsMedical();
         this.lireLesoptionsMedical.setStrId(this.structureLog.getStrid());
         this.lireLesoptionsMedical.lancer();
         this.optionMedical = this.lireLesoptionsMedical.getOptionMedical();
      } else {
         this.lireLesoptionsVentes = new LireLesoptionsVentes();
         this.lireLesoptionsVentes.setStrId(this.structureLog.getStrid());
         this.lireLesoptionsVentes.lancer();
         this.optionVentes = this.lireLesoptionsVentes.getOptionsVentes();
      }

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

   public void recupererMarquesItems(int var1, Session var2) throws HibernateException, NamingException {
      this.mesMarquesItems = new ArrayList();
      if (var1 != 85) {
         MarquesDao var3 = new MarquesDao(this.baseLog, this.utilInitHibernate);
         this.mesMarquesItems = var3.chargerLesMarques(var2);
      }

   }

   public void recupererBudgetItem(Session var1) throws HibernateException, NamingException {
      this.mesBudgetsItems = new ArrayList();
      BudgetDao var2 = new BudgetDao(this.baseLog, this.utilInitHibernate);
      this.mesBudgetsItems = var2.selectAllBudget(this.exercicesVentes.getExevteId(), var1);
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
      TaxesVentesDao var2 = new TaxesVentesDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      List var3 = var2.selectActifTaxes(this.exercicesVentes.getExevteId(), var1);
      if (var3.size() != 0) {
         for(int var4 = 0; var4 < var3.size(); ++var4) {
            TaxesVentes var5 = (TaxesVentes)var3.get(var4);
            if (var5.getTaxvteCode() != null && !var5.getTaxvteCode().isEmpty()) {
               this.mesTaxesItems.add(new SelectItem(var5.getTaxvteCode(), var5.getTaxvteCode() + ":" + var5.getTaxvteTaux()));
            }
         }
      }

   }

   public void recupererDouanesItem(Session var1) throws HibernateException, NamingException {
      this.mesDouanesItems = new ArrayList();
      DouanesPositionDao var2 = new DouanesPositionDao(this.baseLog, this.utilInitHibernate);
      this.mesDouanesItems = var2.listePositionsItems(this.structureLog.getStrzonecommerciale(), var1);
   }

   public void recupererComptesItem(Session var1) throws HibernateException, NamingException, ParseException {
      this.mesVteLocalItems = new ArrayList();
      this.mesVteZoneItems = new ArrayList();
      this.mesVteHorsZoneItems = new ArrayList();
      this.mesVteStockItems = new ArrayList();
      this.mesVteProduitItems = new ArrayList();
      this.mesVteCaissesItems = new ArrayList();
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

         this.mesVteLocalItems = var4.chargerPlanCmptItems(this.selecFiscalite, var2.getExecpt_id(), "(9,17)", 0, var1);
         this.mesVteZoneItems = var4.chargerPlanCmptItems(this.selecFiscalite, var2.getExecpt_id(), "(9,17)", 0, var1);
         this.mesVteHorsZoneItems = var4.chargerPlanCmptItems(this.selecFiscalite, var2.getExecpt_id(), "(9,17)", 0, var1);
         this.mesVteStockItems = var4.chargerPlanCmptItems(this.selecFiscalite, var2.getExecpt_id(), "(5,9,16)", 0, var1);
         this.mesVteProduitItems = var4.chargerPlanCmptItems(this.selecFiscalite, var2.getExecpt_id(), "(9,17)", 0, var1);
         this.mesVteCaissesItems = var4.chargerPlanCmptItems(this.selecFiscalite, var2.getExecpt_id(), "(11)", 0, var1);
      }

   }

   public void chargerDetailanalytique() {
      this.totalImputation = 0.0D;
      this.soldeImputation = 0.0D;
      this.lesDecoupagesActivites.clear();
      if (this.decoupageActivite && this.famillesProduitsVentes.getFamvteActivite() != null && !this.famillesProduitsVentes.getFamvteActivite().isEmpty() && this.famillesProduitsVentes.getFamvteActivite().contains(":")) {
         String[] var1 = null;
         if (!this.famillesProduitsVentes.getFamvteActivite().contains("#")) {
            var1 = this.famillesProduitsVentes.getFamvteActivite().split(":");
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
            String[] var2 = this.famillesProduitsVentes.getFamvteActivite().split("#");

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
      this.famillesProduitsVentes = new FamillesProduitsVentes();
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
      if (this.famillesProduitsVentes != null) {
         this.existCod = true;
         this.var_aff_maj = false;
         this.var_maj_prod = false;
         this.var_onglet = "general";
         this.setShowModalPanel(true);
      }

   }

   public void reactiverCompte() throws HibernateException, NamingException {
      if (this.famillesProduitsVentes == null) {
         this.selectionFamille();
      }

      if (this.famillesProduitsVentes != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FamillesProduitsVentes");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.famillesProduitsVentes.setFamvteDateModif(new Date());
            this.famillesProduitsVentes.setFamvteUserModif(this.usersLog.getUsrid());
            this.famillesProduitsVentes.setFamvteInactif(0);
            this.famillesProduitsVentes = this.famillesProduitsVentesDao.modif(this.famillesProduitsVentes, var1);
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
      if (this.famillesProduitsVentes != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FamillesProduitsVentes");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.lesProduits = new ArrayList();
            this.lesProduits = this.produitsVtesDao.chargerLesProduitsVentesByFamille(this.famillesProduitsVentes.getFamvteCode(), var1);
            if (this.lesProduits.size() == 0) {
               this.famillesProduitsVentesDao.delete(this.famillesProduitsVentes, var1);
               this.famillesProduitsVentesList.remove(this.famillesProduitsVentes);
            } else {
               this.famillesProduitsVentes.setFamvteDateModif(new Date());
               this.famillesProduitsVentes.setFamvteUserModif(this.usersLog.getUsrid());
               this.famillesProduitsVentes.setFamvteInactif(2);
               this.famillesProduitsVentes = this.famillesProduitsVentesDao.modif(this.famillesProduitsVentes, var1);
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
      this.famillesProduitsVentes = new FamillesProduitsVentes();
      this.annule();
      if (this.datamodel.isRowAvailable()) {
         this.famillesProduitsVentes = (FamillesProduitsVentes)this.datamodel.getRowData();
         this.famvteIdSelect = this.famillesProduitsVentes.getFamvteId();
         this.inpNature = this.famillesProduitsVentes.getFamvteNature() + ":" + this.famillesProduitsVentes.getFamvteLibNature();
         String[] var1;
         if (this.famillesProduitsVentes.getFamvteCompteExterieur() != null && !this.famillesProduitsVentes.getFamvteCompteExterieur().isEmpty() && this.famillesProduitsVentes.getFamvteCompteExterieur().contains(":")) {
            var1 = this.famillesProduitsVentes.getFamvteCompteExterieur().split(":");
            this.famillesProduitsVentes.setFamvteCompteExterieur(var1[0]);
         }

         if (this.famillesProduitsVentes.getFamvteCompteLocal() != null && !this.famillesProduitsVentes.getFamvteCompteLocal().isEmpty() && this.famillesProduitsVentes.getFamvteCompteLocal().contains(":")) {
            var1 = this.famillesProduitsVentes.getFamvteCompteLocal().split(":");
            this.famillesProduitsVentes.setFamvteCompteLocal(var1[0]);
         }

         if (this.famillesProduitsVentes.getFamvteCompteNonTaxable() != null && !this.famillesProduitsVentes.getFamvteCompteNonTaxable().isEmpty() && this.famillesProduitsVentes.getFamvteCompteNonTaxable().contains(":")) {
            var1 = this.famillesProduitsVentes.getFamvteCompteNonTaxable().split(":");
            this.famillesProduitsVentes.setFamvteCompteNonTaxable(var1[0]);
         }

         if (this.famillesProduitsVentes.getFamvteCompteProduit() != null && !this.famillesProduitsVentes.getFamvteCompteProduit().isEmpty() && this.famillesProduitsVentes.getFamvteCompteProduit().contains(":")) {
            var1 = this.famillesProduitsVentes.getFamvteCompteProduit().split(":");
            this.famillesProduitsVentes.setFamvteCompteProduit(var1[0]);
         }

         if (this.famillesProduitsVentes.getFamvteCompteStock() != null && !this.famillesProduitsVentes.getFamvteCompteStock().isEmpty() && this.famillesProduitsVentes.getFamvteCompteStock().contains(":")) {
            var1 = this.famillesProduitsVentes.getFamvteCompteStock().split(":");
            this.famillesProduitsVentes.setFamvteCompteStock(var1[0]);
         }

         if (this.famillesProduitsVentes.getFamvteCompteZone() != null && !this.famillesProduitsVentes.getFamvteCompteZone().isEmpty() && this.famillesProduitsVentes.getFamvteCompteZone().contains(":")) {
            var1 = this.famillesProduitsVentes.getFamvteCompteZone().split(":");
            this.famillesProduitsVentes.setFamvteCompteZone(var1[0]);
         }

         if (this.famillesProduitsVentes.getFamvteInactif() == 2) {
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
      this.lesProduits.clear();
      if (this.famillesProduitsVentes.getFamvteCode() != null && !this.famillesProduitsVentes.getFamvteCode().isEmpty()) {
         this.lesProduits = this.produitsVtesDao.chargerLesProduitsVentesByFamille(this.famillesProduitsVentes.getFamvteCode(), (Session)null);
      }

      if (this.lesProduits.size() != 0) {
         this.var_aff_maj = true;
         this.var_maj_prod = false;
      }

   }

   public void recalculMvts() throws HibernateException, NamingException {
      if (this.lesProduits.size() != 0) {
         UtilDate var1 = new UtilDate();
         String var2 = var1.dateToStringSQL(this.exercicesVentes.getExevteDateDebut());
         String var3 = var1.dateToStringSQL(this.exercicesVentes.getExevteDateFin());
         Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "CalculMouvementStock");
         Transaction var5 = null;

         try {
            var5 = var4.beginTransaction();

            for(int var6 = 0; var6 < this.lesProduits.size(); ++var6) {
               new Produits();
               Produits var7 = (Produits)this.lesProduits.get(var6);
               new DevisLigneVentes();
               new ArrayList();
               DevisLigneVentesDao var10 = new DevisLigneVentesDao(this.baseLog, this.utilInitHibernate);
               List var9 = var10.chargerLesMvts("", var7.getProCode(), 0L, "", "", var2, var3, var4);
               if (var9.size() != 0) {
                  for(int var11 = 0; var11 < var9.size(); ++var11) {
                     new DevisLigneVentes();
                     DevisLigneVentes var8 = (DevisLigneVentes)var9.get(var11);
                     var8.setDvsligFamille(var7.getProVteCode());
                     var10.modifLigne(var8, var4);
                  }
               }

               new CommandeLigneVentes();
               new ArrayList();
               CommandeLigneVentesDao var13 = new CommandeLigneVentesDao(this.baseLog, this.utilInitHibernate);
               List var12 = var13.chargerLesMvts("", var7.getProCode(), "", 0L, "", "", var2, var3, var4);
               if (var12.size() != 0) {
                  for(int var14 = 0; var14 < var12.size(); ++var14) {
                     new CommandeLigneVentes();
                     CommandeLigneVentes var35 = (CommandeLigneVentes)var12.get(var14);
                     var35.setBcmligFamille(var7.getProVteCode());
                     var13.modifLigne(var35, var4);
                  }
               }

               new LivraisonLigneVentes();
               new ArrayList();
               LivraisonLigneVentesDao var16 = new LivraisonLigneVentesDao(this.baseLog, this.utilInitHibernate);
               List var15 = var16.chargerLesMvts("", var7.getProCode(), "", 0L, "", "", var2, var3, "", var4);
               if (var15.size() != 0) {
                  for(int var17 = 0; var17 < var15.size(); ++var17) {
                     new LivraisonLigneVentes();
                     LivraisonLigneVentes var36 = (LivraisonLigneVentes)var15.get(var17);
                     var36.setBlvligFamille(var7.getProVteCode());
                     var16.modif(var36, var4);
                  }
               }

               new RetourLigneVentes();
               new ArrayList();
               RetourLigneVentesDao var19 = new RetourLigneVentesDao(this.baseLog, this.utilInitHibernate);
               List var18 = var19.chargerLesMvts("", var7.getProCode(), "", 0L, "", "", var2, var3, "", var4);
               if (var18.size() != 0) {
                  for(int var20 = 0; var20 < var18.size(); ++var20) {
                     new RetourLigneVentes();
                     RetourLigneVentes var37 = (RetourLigneVentes)var18.get(var20);
                     var37.setBrtligFamille(var7.getProVteCode());
                     var19.modifLigne(var37, var4);
                  }
               }

               new FactureLigneVentes();
               new ArrayList();
               FactureLigneVentesDao var22 = new FactureLigneVentesDao(this.baseLog, this.utilInitHibernate);
               List var21 = var22.chargerLesMvts("", var7.getProCode(), "", 0L, "", "", var2, var3, "", var4);
               if (var21.size() != 0) {
                  for(int var23 = 0; var23 < var21.size(); ++var23) {
                     new FactureLigneVentes();
                     FactureLigneVentes var38 = (FactureLigneVentes)var21.get(var23);
                     var38.setFacligFamille(var7.getProVteCode());
                     var22.modifLigne(var38, var4);
                  }
               }

               new NoteDebitLigneVentes();
               new ArrayList();
               NoteDebitLigneVentesDao var25 = new NoteDebitLigneVentesDao(this.baseLog, this.utilInitHibernate);
               List var24 = var25.chargerLesMvts("", var7.getProCode(), 0L, "", "", var2, var3, "", var4);
               if (var24.size() != 0) {
                  for(int var26 = 0; var26 < var24.size(); ++var26) {
                     new NoteDebitLigneVentes();
                     NoteDebitLigneVentes var39 = (NoteDebitLigneVentes)var24.get(var26);
                     var39.setNdbligFamille(var7.getProVteCode());
                     var25.modifLigne(var39, var4);
                  }
               }

               new AvoirLigneVentes();
               new ArrayList();
               AvoirLigneVentesDao var28 = new AvoirLigneVentesDao(this.baseLog, this.utilInitHibernate);
               List var27 = var28.chargerLesMvts("", var7.getProCode(), 0L, "", "", var2, var3, "", var4);
               if (var27.size() != 0) {
                  for(int var29 = 0; var29 < var27.size(); ++var29) {
                     new AvoirLigneVentes();
                     AvoirLigneVentes var40 = (AvoirLigneVentes)var27.get(var29);
                     var40.setAvrligFamille(var7.getProVteCode());
                     var28.modifLigne(var40, var4);
                  }
               }
            }

            var5.commit();
         } catch (HibernateException var33) {
            if (var5 != null) {
               var5.rollback();
            }

            throw var33;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void saveFamilles() throws HibernateException, NamingException {
      this.annule();
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FamillesProduitsVentes");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.decoupageCode();
         if (this.famillesProduitsVentes.getFamvteCat() <= 2 && this.famillesProduitsVentes.getFamvteStock() == 0 && this.famillesProduitsVentes.getFamvteDepotVte() != null && !this.famillesProduitsVentes.getFamvteDepotVte().isEmpty() && this.famillesProduitsVentes.getFamvteDepotVte().contains(":")) {
            this.famillesProduitsVentes.setFamvteStock(1);
         } else if (this.famillesProduitsVentes.getFamvteCat() == 3) {
            this.famillesProduitsVentes.setFamvteStock(0);
            this.famillesProduitsVentes.setFamvteDepotVte("");
         }

         if (this.decoupageActivite) {
            String var3 = "";
            boolean var4 = true;
            if (this.lesDecoupagesActivites.size() != 0) {
               for(int var5 = 0; var5 < this.lesDecoupagesActivites.size(); ++var5) {
                  this.ecrituresAnalytiqueCtrl = (EcrituresAnalytiqueCtrl)this.lesDecoupagesActivites.get(var5);
                  if (this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() != 0.0F) {
                     if (var4) {
                        var3 = this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaPourcentage();
                        var4 = false;
                     } else {
                        var3 = var3 + "#" + this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaPourcentage();
                     }
                  }
               }
            }

            this.famillesProduitsVentes.setFamvteActivite(var3);
         }

         if (this.famillesProduitsVentes.getFamvteId() == 0L) {
            this.famillesProduitsVentes.setExerciceventes(this.exercicesVentes);
            this.famillesProduitsVentes.setFamvteDateCreation(new Date());
            this.famillesProduitsVentes.setFamvteUserCreation(this.usersLog.getUsrid());
            this.famillesProduitsVentes.setFamvteInactif(this.getConvertionInactif());
            this.famillesProduitsVentes = this.famillesProduitsVentesDao.insert(this.famillesProduitsVentes, var1);
            this.famillesProduitsVentesList.add(this.famillesProduitsVentes);
            this.datamodel.setWrappedData(this.famillesProduitsVentesList);
         } else {
            this.famillesProduitsVentes.setFamvteDateModif(new Date());
            this.famillesProduitsVentes.setFamvteUserModif(this.usersLog.getUsrid());
            this.famillesProduitsVentes.setFamvteInactif(this.getConvertionInactif());
            this.famillesProduitsVentes = this.famillesProduitsVentesDao.modif(this.famillesProduitsVentes, var1);
         }

         if (this.var_maj_prod && this.lesProduits.size() != 0) {
            for(int var17 = 0; var17 < this.lesProduits.size(); ++var17) {
               new Produits();
               Produits var18 = (Produits)this.lesProduits.get(var17);
               var18.setProVteNat(this.famillesProduitsVentes.getFamvteNature());
               var18.setProVteLib(this.famillesProduitsVentes.getFamvteLibelleFr());
               var18.setProStock(this.famillesProduitsVentes.getFamvteStock());
               var18.setProVteTva(this.famillesProduitsVentes.getFamvteTaxe());
               var18.setProVteCptePr(this.famillesProduitsVentes.getFamvteCompteProduit());
               var18.setProVteCpteHz(this.famillesProduitsVentes.getFamvteCompteExterieur());
               var18.setProVteCpteLoc(this.famillesProduitsVentes.getFamvteCompteLocal());
               var18.setProVteCpteSt(this.famillesProduitsVentes.getFamvteCompteStock());
               var18.setProVteCpteZ(this.famillesProduitsVentes.getFamvteCompteZone());
               var18.setProDepotVte(this.famillesProduitsVentes.getFamvteDepotVte());
               this.produitsVtesDao.modifProduit(var18, var1);
            }

            String[] var23;
            if (this.famillesProduitsVentes.getFamvteDepotVte() != null && !this.famillesProduitsVentes.getFamvteDepotVte().isEmpty() && this.famillesProduitsVentes.getFamvteDepotVte().contains(":")) {
               new DepotAchats();
               DepotAchatsDao var20 = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
               var23 = this.famillesProduitsVentes.getFamvteDepotVte().split(":");
               new ExercicesAchats();
               ExercicesAchatsDao var7 = new ExercicesAchatsDao(this.baseLog, this.utilInitHibernate);
               ExercicesAchats var6 = var7.recupererLastExo(var1);
               if (var6 != null) {
                  DepotAchats var19 = var20.trouveDepot(var23[0], var1);
                  if (var19 != null) {
                     ProduitsDepotDao var8 = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
                     new ProduitsDepot();

                     for(int var10 = 0; var10 < this.lesProduits.size(); ++var10) {
                        new Produits();
                        Produits var11 = (Produits)this.lesProduits.get(var10);
                        ProduitsDepot var9 = var8.produitDepByprod(var11.getProCode(), var23[0], var1);
                        if (var9 == null) {
                           var9 = new ProduitsDepot();
                           var9.setProduits(var11);
                           var9.setUnite((Unite)null);
                           var9.setDepot(var19);
                           var9.setProdepCle(var19.getDpoCode() + ":" + var11.getProCode());
                           var9.setProdepCle2(var9.getProdepGroupe() + ":" + var11.getProCode());
                           var8.insert(var9, var1);
                        }
                     }
                  }
               }
            }

            if (this.famillesProduitsVentes.getFamvteService() != null && !this.famillesProduitsVentes.getFamvteService().isEmpty() && this.famillesProduitsVentes.getFamvteService().contains(":")) {
               new Service();
               ServiceDao var22 = new ServiceDao(this.baseLog, this.utilInitHibernate);
               var23 = this.famillesProduitsVentes.getFamvteService().split(":");
               Service var21 = var22.chargerLeServiceCode(var23[0], var1);
               if (var21 != null) {
                  ProduitsServicesDao var24 = new ProduitsServicesDao(this.baseLog, this.utilInitHibernate);
                  new ProduitsServices();

                  for(int var26 = 0; var26 < this.lesProduits.size(); ++var26) {
                     new Produits();
                     Produits var27 = (Produits)this.lesProduits.get(var26);
                     ProduitsServices var25 = var24.selectCode(var27, var23[0], var1);
                     if (var25 == null) {
                        var25 = new ProduitsServices();
                        var25.setProduits(var27);
                        var25.setServices(var21);
                        var25.setProserCode(var21.getSerCode());
                        var25.setProserNomFr(var21.getSerNomFr());
                        var24.insert(var25, var1);
                     }
                  }
               }
            }
         }

         var2.commit();
      } catch (HibernateException var15) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var15;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.setVisibiliteBton(false);
      this.setShowModalPanel(false);
   }

   public void supprimerFamillesProduitsVentes() throws IOException, JDOMException, HibernateException, NamingException, ParseException {
      this.annule();
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FamillesProduitsVentes");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.famillesProduitsVentesDao.deletFamillesProduitsVentes(this.getFamvteIdSelect(), var1);
         var2.commit();
      } catch (HibernateException var7) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var7;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.lesFamillesProduitsVentes((Session)null);
   }

   public void decoupageCode() {
      if (this.getInpNature() != null && !this.getInpNature().isEmpty() && this.getInpNature().contains(":")) {
         String[] var1 = this.getInpNature().split(":");
         this.famillesProduitsVentes.setFamvteNature(var1[0]);
         this.famillesProduitsVentes.setFamvteLibNature(var1[1]);
      }

   }

   public void verifCode() throws HibernateException, NamingException {
      if (this.famillesProduitsVentes.getFamvteCode() != null && !this.famillesProduitsVentes.getFamvteCode().isEmpty()) {
         this.existCod = this.famillesProduitsVentesDao.existCode(this.exercicesVentes.getExevteId(), this.famillesProduitsVentes.getFamvteCode(), (Session)null);
      } else {
         this.existCod = false;
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

   public FamillesProduitsVentes getFamillesProduitsVentes() {
      return this.famillesProduitsVentes;
   }

   public void setFamillesProduitsVentes(FamillesProduitsVentes var1) {
      this.famillesProduitsVentes = var1;
   }

   public List getFamillesProduitsVentesList() {
      return this.famillesProduitsVentesList;
   }

   public void setFamillesProduitsVentesList(List var1) {
      this.famillesProduitsVentesList = var1;
   }

   public long getFamvteIdSelect() {
      return this.famvteIdSelect;
   }

   public void setFamvteIdSelect(long var1) {
      this.famvteIdSelect = var1;
   }

   public List getMesnaturesItems() {
      return this.mesnaturesItems;
   }

   public void setMesnaturesItems(List var1) {
      this.mesnaturesItems = var1;
   }

   public List getLesNaturesFamillesProdVentes() {
      return this.lesNaturesFamillesProdVentes;
   }

   public void setLesNaturesFamillesProdVentes(List var1) {
      this.lesNaturesFamillesProdVentes = var1;
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

   public ExercicesVentes getExercicesVentes() {
      return this.exercicesVentes;
   }

   public void setExercicesVentes(ExercicesVentes var1) {
      this.exercicesVentes = var1;
   }

   public LectureNatureVentes getNaturesFamillesProdVentes() {
      return this.naturesFamillesProdVentes;
   }

   public void setNaturesFamillesProdVentes(LectureNatureVentes var1) {
      this.naturesFamillesProdVentes = var1;
   }

   public boolean isShowModalPanel() {
      return this.showModalPanel;
   }

   public void setShowModalPanel(boolean var1) {
      this.showModalPanel = var1;
   }

   public OptionVentes getOptionVentes() {
      return this.optionVentes;
   }

   public void setOptionVentes(OptionVentes var1) {
      this.optionVentes = var1;
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

   public List getMesVteHorsZoneItems() {
      return this.mesVteHorsZoneItems;
   }

   public void setMesVteHorsZoneItems(List var1) {
      this.mesVteHorsZoneItems = var1;
   }

   public List getMesVteLocalItems() {
      return this.mesVteLocalItems;
   }

   public void setMesVteLocalItems(List var1) {
      this.mesVteLocalItems = var1;
   }

   public List getMesVteProduitItems() {
      return this.mesVteProduitItems;
   }

   public void setMesVteProduitItems(List var1) {
      this.mesVteProduitItems = var1;
   }

   public List getMesVteStockItems() {
      return this.mesVteStockItems;
   }

   public void setMesVteStockItems(List var1) {
      this.mesVteStockItems = var1;
   }

   public List getMesVteZoneItems() {
      return this.mesVteZoneItems;
   }

   public void setMesVteZoneItems(List var1) {
      this.mesVteZoneItems = var1;
   }

   public List getLesProduits() {
      return this.lesProduits;
   }

   public void setLesProduits(List var1) {
      this.lesProduits = var1;
   }

   public List getMesDepotsVentes() {
      return this.mesDepotsVentes;
   }

   public void setMesDepotsVentes(List var1) {
      this.mesDepotsVentes = var1;
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

   public List getMesVteCaissesItems() {
      return this.mesVteCaissesItems;
   }

   public void setMesVteCaissesItems(List var1) {
      this.mesVteCaissesItems = var1;
   }

   public OptionMedical getOptionMedical() {
      return this.optionMedical;
   }

   public void setOptionMedical(OptionMedical var1) {
      this.optionMedical = var1;
   }
}
