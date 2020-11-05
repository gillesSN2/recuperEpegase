package com.epegase.forms.administration;

import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.PlanComptable;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.TaxesVentes;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.PlanComptableDao;
import com.epegase.systeme.dao.TaxesVentesDao;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FormTaxesVentes implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private List lesPlanComptables;
   private TaxesVentes taxesVentes = new TaxesVentes();
   private TaxesVentesDao taxesVentesDao;
   private List taxesVentesList = new ArrayList();
   private long taxvteIdSelect;
   private transient DataModel datamodel = new ListDataModel();
   private String valImp = "false";
   private boolean visibiliteBton = false;
   private boolean inactif = false;
   private int convertionInactif;
   private boolean showModalPanel;
   private PlanComptableDao plancomptableDao;
   private List planComptablesList = new ArrayList();
   private boolean comtabiliteActive = false;
   private PlanComptable planComptable;
   private ExercicesVentes exovteSelect;
   private boolean doublon = false;
   private List mesComptesItems;
   private int choixRacine;
   private String selecFiscalite;

   public FormTaxesVentes() throws ParseException {
   }

   public void InstancesDaoUtilses() {
      this.taxesVentesDao = new TaxesVentesDao(this.baseLog, this.utilInitHibernate);
      this.plancomptableDao = new PlanComptableDao(this.baseLog, this.utilInitHibernate);
   }

   public void lesTaxesVentes(Session var1) throws HibernateException, NamingException {
      this.taxesVentesList = this.taxesVentesDao.selectTaxesVentes(this.exovteSelect.getExevteId(), var1);
      this.datamodel = new ListDataModel();
      this.datamodel.setWrappedData(this.taxesVentesList);
      this.selecFiscalite = this.structureLog.getStrzonefiscale();
   }

   public void recupererComptesItem(Session var1) throws HibernateException, NamingException, ParseException {
      this.mesComptesItems = new ArrayList();
      new ExercicesComptable();
      ExercicesComptableDao var3 = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
      ExercicesComptable var2 = var3.recupererLastExo(var1);
      if (var2 != null) {
         boolean var4 = false;
         if (this.taxesVentesList.size() != 0) {
            for(int var5 = 0; var5 < this.taxesVentesList.size(); ++var5) {
               if (((TaxesVentes)this.taxesVentesList.get(var5)).getTaxvteTimbre() != 0) {
                  var4 = true;
               }
            }
         }

         String var6 = "(9,14,15)";
         if (var4) {
            var6 = "(9,14,15,17)";
         }

         this.mesComptesItems = this.plancomptableDao.chargerPlanCmptItems(this.selecFiscalite, var2.getExecpt_id(), var6, 0, var1);
      }

   }

   public void afficheCompte() {
      this.setComtabiliteActive(true);
   }

   public void reactiverCompte() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "TaxesVentes");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.taxesVentes.setTaxvteDateModif(new Date());
         this.taxesVentes.setTaxvteUserModif(this.usersLog.getUsrid());
         this.taxesVentes.setTaxvteInactif(0);
         this.taxesVentes = this.taxesVentesDao.modif(this.taxesVentes, var1);
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

   public void removeCompte() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "TaxesVentes");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.taxesVentes.setTaxvteDateModif(new Date());
         this.taxesVentes.setTaxvteUserModif(this.usersLog.getUsrid());
         this.taxesVentes.setTaxvteInactif(2);
         this.taxesVentes = this.taxesVentesDao.modif(this.taxesVentes, var1);
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

   public void visibleAjt() {
      this.taxesVentes = new TaxesVentes();
      this.inactif = false;
      this.setDoublon(false);
      this.setShowModalPanel(true);
   }

   public void visibleMod() {
      this.setDoublon(true);
      this.setShowModalPanel(true);
   }

   public void annule() {
      this.setShowModalPanel(false);
      this.setValImp("false");
   }

   public void selectionTaxe() {
      this.annule();
      if (this.datamodel.isRowAvailable()) {
         this.taxesVentes = (TaxesVentes)this.datamodel.getRowData();
         this.setTaxvteIdSelect(this.taxesVentes.getTaxvteId());
         int var1 = this.taxesVentes.getTaxvteInactif();
         if (var1 == 2) {
            this.setVisibiliteBton(false);
         } else {
            this.setVisibiliteBton(true);
         }
      }

   }

   public void doublonCode() throws HibernateException, NamingException {
      if (this.taxesVentes.getTaxvteCode().equalsIgnoreCase("")) {
         this.setDoublon(false);
      } else {
         TaxesVentes var1 = this.taxesVentesDao.selectTva(this.exovteSelect.getExevteId(), this.taxesVentes.getTaxvteCode(), (Session)null);
         if (var1 == null) {
            this.setDoublon(true);
         } else {
            this.setDoublon(false);
         }
      }

   }

   public void saveTaxesVentes() throws HibernateException, NamingException {
      this.annule();
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "TaxesVentes");
      this.taxesVentes.setExerciceventes(this.exovteSelect);
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.taxesVentes.getTaxvteId() == 0L) {
            this.taxesVentes.setExerciceventes(this.exovteSelect);
            this.taxesVentes.setTaxvteDateCreation(new Date());
            this.taxesVentes.setTaxvteUserCreation(this.usersLog.getUsrid());
            this.taxesVentes.setTaxvteInactif(this.getConvertionInactif());
            this.taxesVentes = this.taxesVentesDao.insert(this.taxesVentes, var1);
            this.taxesVentesList.add(this.taxesVentes);
            this.datamodel.setWrappedData(this.taxesVentesList);
         } else {
            this.taxesVentes.setTaxvteDateModif(new Date());
            this.taxesVentes.setTaxvteUserModif(this.usersLog.getUsrid());
            this.taxesVentes = this.taxesVentesDao.modif(this.taxesVentes, var1);
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

      this.setVisibiliteBton(false);
   }

   public void supprimerTaxesVentes() throws HibernateException, NamingException {
      this.annule();
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "TaxesVentes");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.taxesVentesDao.deletTaxesVentes(this.getTaxvteIdSelect(), var1);
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

   public boolean isDoublon() {
      return this.doublon;
   }

   public void setDoublon(boolean var1) {
      this.doublon = var1;
   }

   public void setLesPlanComptables(List var1) {
      this.lesPlanComptables = var1;
   }

   public boolean isComtabiliteActive() {
      return this.comtabiliteActive;
   }

   public void setComtabiliteActive(boolean var1) {
      this.comtabiliteActive = var1;
   }

   public List getPlanComptablesList() {
      return this.planComptablesList;
   }

   public void setPlanComptablesList(List var1) {
      this.planComptablesList = var1;
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

   public DataModel getDatamodel() {
      return this.datamodel;
   }

   public void setDatamodel(DataModel var1) {
      this.datamodel = var1;
   }

   public TaxesVentes getTaxesVentes() {
      return this.taxesVentes;
   }

   public void setTaxesVentes(TaxesVentes var1) {
      this.taxesVentes = var1;
   }

   public List getTaxesVentesList() {
      return this.taxesVentesList;
   }

   public void setTaxesVentesList(List var1) {
      this.taxesVentesList = var1;
   }

   public long getTaxvteIdSelect() {
      return this.taxvteIdSelect;
   }

   public void setTaxvteIdSelect(long var1) {
      this.taxvteIdSelect = var1;
   }

   public String getValImp() {
      return this.valImp;
   }

   public void setValImp(String var1) {
      this.valImp = var1;
   }

   public boolean isVisibiliteBton() {
      return this.visibiliteBton;
   }

   public void setVisibiliteBton(boolean var1) {
      this.visibiliteBton = var1;
   }

   public ExercicesVentes getExovteSelect() {
      return this.exovteSelect;
   }

   public void setExovteSelect(ExercicesVentes var1) {
      this.exovteSelect = var1;
   }

   public PlanComptable getPlanComptable() {
      return this.planComptable;
   }

   public void setPlanComptable(PlanComptable var1) {
      this.planComptable = var1;
   }

   public boolean isShowModalPanel() {
      return this.showModalPanel;
   }

   public void setShowModalPanel(boolean var1) {
      this.showModalPanel = var1;
   }

   public List getMesComptesItems() {
      return this.mesComptesItems;
   }

   public void setMesComptesItems(List var1) {
      this.mesComptesItems = var1;
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
