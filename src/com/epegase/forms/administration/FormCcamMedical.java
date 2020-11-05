package com.epegase.forms.administration;

import com.epegase.systeme.classe.CcamMedical;
import com.epegase.systeme.classe.FamillesProduitsVentes;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.CcamMedicalDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.ProduitsAchsDao;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FormCcamMedical implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private CcamMedicalDao ccamMedicalDao;
   private List listCcamMedical = new ArrayList();
   private Map mapCcamMedicalDistinct = new HashMap();
   private List listCcamMedicalDistinct = new ArrayList();
   private Map mapCcamMedicalSDistinct = new HashMap();
   private List listCcamMedicalSDistinct = new ArrayList();
   private Map mapCcamMedicalSsDistinct = new HashMap();
   private List listCcamMedicalSsDistinct = new ArrayList();
   private Map mapCcamMedicalSssDistinct = new HashMap();
   private List listCcamMedicalSssDistinct = new ArrayList();
   private Map mapCcamMedicalSsssDistinct = new HashMap();
   private List listCcamMedicalSsssDistinct = new ArrayList();
   private Map mapCcamMedicalDetail = new HashMap();
   private List listCcamMedicalDetail = new ArrayList();
   private List listCcamMedicaldetail = new ArrayList();
   private CcamMedical ccamMedical = new CcamMedical();
   private transient DataModel datamodel = new ListDataModel();
   private transient DataModel datamodelSniv = new ListDataModel();
   private transient DataModel datamodelSsniv = new ListDataModel();
   private transient DataModel datamodelSssniv = new ListDataModel();
   private transient DataModel datamodelSsssniv = new ListDataModel();
   private transient DataModel datamodeldetail = new ListDataModel();
   private CcamMedical ccamMedicalSniv = new CcamMedical();
   private CcamMedical ccamMedicalSsniv = new CcamMedical();
   private CcamMedical ccamMedicalSssniv = new CcamMedical();
   private CcamMedical ccamMedicaldetail;
   private FamillesProduitsVentesDao familleProduitsMedicalDao;
   private FamillesProduitsVentes famillesProduitsMedical;
   private ProduitsAchsDao produitsDao;

   public void InstancesDaoUtilses() {
      this.ccamMedicalDao = new CcamMedicalDao(this.baseLog, this.utilInitHibernate);
      this.produitsDao = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
      this.familleProduitsMedicalDao = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerListCcamMedical(Session var1) throws HibernateException, NamingException {
      this.mapCcamMedicalDistinct.clear();
      this.listCcamMedicalDistinct.clear();
      this.listCcamMedical = this.ccamMedicalDao.selectallCcamMedical(var1);
      if (this.datamodel == null) {
         this.datamodel = new ListDataModel();
      }

      Iterator var2 = this.listCcamMedical.iterator();

      while(var2.hasNext()) {
         CcamMedical var3 = (CcamMedical)var2.next();
         if (!this.mapCcamMedicalDistinct.containsKey(var3.getCcamFamCode())) {
            this.mapCcamMedicalDistinct.put(var3.getCcamFamCode(), var3.getCcamFamLibFr());
            this.listCcamMedicalDistinct.add(var3);
         }
      }

      this.datamodel.setWrappedData(this.listCcamMedicalDistinct);
   }

   public void initCcamMedicalSelect() throws HibernateException, NamingException {
      if (this.datamodel.isRowAvailable()) {
         this.ccamMedical = (CcamMedical)this.datamodel.getRowData();
      }

      this.setDatamodelSsniv((DataModel)null);
      this.setDatamodelSssniv((DataModel)null);
      this.setDatamodeldetail((DataModel)null);
      this.chargerListccamMedicalSniv();
   }

   public void initCcamMedicalSelectSF() throws HibernateException, NamingException {
      if (this.datamodelSniv.isRowAvailable()) {
         this.ccamMedicalSniv = (CcamMedical)this.datamodelSniv.getRowData();
      }

      this.setDatamodelSssniv((DataModel)null);
      this.setDatamodeldetail((DataModel)null);
      this.chargerListccamMedicalSsniv();
   }

   public void initCcamMedicalSelectSsF() throws HibernateException, NamingException {
      if (this.datamodelSsniv.isRowAvailable()) {
         this.ccamMedicalSsniv = (CcamMedical)this.datamodelSsniv.getRowData();
      }

      this.setDatamodeldetail((DataModel)null);
      this.chargerListccamMedicalSssniv();
   }

   public void initCcamMedicalSelectDetail() {
      if (this.datamodeldetail.isRowAvailable()) {
         this.ccamMedicaldetail = (CcamMedical)this.datamodeldetail.getRowData();
      }

   }

   public void initCcamMedicalSelectSssF() throws HibernateException, NamingException {
      if (this.datamodelSssniv.isRowAvailable()) {
         this.ccamMedicalSssniv = (CcamMedical)this.datamodelSssniv.getRowData();
      }

      this.chargerListccamMedicalDetail();
   }

   public void chargerListccamMedicalSniv() throws HibernateException, NamingException {
      this.listCcamMedicalSDistinct.clear();
      this.mapCcamMedicalSDistinct.clear();
      this.listCcamMedical = this.ccamMedicalDao.selectallCcamMedicalSNiv(this.ccamMedical.getCcamFamCode(), (Session)null);
      if (this.datamodelSniv == null) {
         this.datamodelSniv = new ListDataModel();
      }

      Iterator var1 = this.listCcamMedical.iterator();

      while(var1.hasNext()) {
         CcamMedical var2 = (CcamMedical)var1.next();
         if (!this.mapCcamMedicalSDistinct.containsKey(var2.getCcamFamCode())) {
            this.mapCcamMedicalSDistinct.put(var2.getCcamFamCode(), var2.getCcamFamLibFr());
            this.listCcamMedicalSDistinct.add(var2);
         }
      }

      this.datamodelSniv.setWrappedData(this.listCcamMedicalSDistinct);
   }

   public void chargerListccamMedicalSsniv() throws HibernateException, NamingException {
      this.listCcamMedicalSsDistinct.clear();
      this.mapCcamMedicalSsDistinct.clear();
      this.listCcamMedical = this.ccamMedicalDao.selectallCcamMedicalSSNiv(this.ccamMedical.getCcamFamCode(), this.ccamMedicalSniv.getCcamSfamCode(), (Session)null);
      if (this.datamodelSsniv == null) {
         this.datamodelSsniv = new ListDataModel();
      }

      Iterator var1 = this.listCcamMedical.iterator();

      while(var1.hasNext()) {
         CcamMedical var2 = (CcamMedical)var1.next();
         if (!this.mapCcamMedicalSsDistinct.containsKey(var2.getCcamSfamCode())) {
            this.mapCcamMedicalSsDistinct.put(var2.getCcamSfamCode(), var2.getCcamSfamLibFr());
            this.listCcamMedicalSsDistinct.add(var2);
         }
      }

      this.datamodelSsniv.setWrappedData(this.listCcamMedicalSsDistinct);
   }

   public void chargerListccamMedicalSssniv() throws HibernateException, NamingException {
      this.listCcamMedicalSssDistinct.clear();
      this.mapCcamMedicalSssDistinct.clear();
      this.listCcamMedical = this.ccamMedicalDao.selectallCcamMedicalSSSNiv(this.ccamMedicalSniv.getCcamSfamCode(), this.ccamMedicalSsniv.getCcamSsfamCode(), (Session)null);
      if (this.datamodelSssniv == null) {
         this.datamodelSssniv = new ListDataModel();
      }

      Iterator var1 = this.listCcamMedical.iterator();

      while(var1.hasNext()) {
         CcamMedical var2 = (CcamMedical)var1.next();
         if (!this.mapCcamMedicalSssDistinct.containsKey(var2.getCcamSsfamCode())) {
            this.mapCcamMedicalSssDistinct.put(var2.getCcamSsfamCode(), var2.getCcamSsfamLibFr());
            this.listCcamMedicalSssDistinct.add(var2);
         }
      }

      this.datamodelSssniv.setWrappedData(this.listCcamMedicalSssDistinct);
   }

   public void chargerListccamMedicalDetail() throws HibernateException, NamingException {
      this.mapCcamMedicalDetail.clear();
      this.listCcamMedicalDetail.clear();
      this.listCcamMedical = this.ccamMedicalDao.selectallCcamMedicalDetail(this.ccamMedicalSsniv.getCcamSsfamCode(), this.ccamMedicalSssniv.getCcamSssfamCode(), (Session)null);
      if (this.datamodeldetail == null) {
         this.datamodeldetail = new ListDataModel();
      }

      Iterator var1 = this.listCcamMedical.iterator();

      while(var1.hasNext()) {
         CcamMedical var2 = (CcamMedical)var1.next();
         if (!this.mapCcamMedicalDetail.containsKey(var2.getCcamDetCode())) {
            this.mapCcamMedicalDetail.put(var2.getCcamDetCode(), var2.getCcamDetLibFr());
            this.listCcamMedicalDetail.add(var2);
         }
      }

      this.datamodeldetail.setWrappedData(this.listCcamMedicalDetail);
   }

   public void transfCcamProduit() throws HibernateException, NamingException {
      this.produitsDao = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "CcamMedical");
      FamillesProduitsVentes var2 = this.familleProduitsMedicalDao.FamillesProduitsMedicalByNature("1104", var1);
      Transaction var3 = null;

      try {
         if (var2 != null) {
            var3 = var1.beginTransaction();
            new ArrayList();
            List var4 = this.ccamMedicalDao.selectallCcamMedical(var1);
            if (var4.size() != 0) {
               for(int var5 = 0; var5 < var4.size(); ++var5) {
                  new CcamMedical();
                  CcamMedical var6 = (CcamMedical)var4.get(var5);
                  if (var6.getCcamDetCode() != null && !var6.getCcamDetCode().isEmpty()) {
                     new Produits();
                     Produits var7 = this.produitsDao.existCodeProduit(var6.getCcamDetCode(), var1);
                     if (var7 == null) {
                        var7 = new Produits();
                        var7.setProDateCreat(new Date());
                        var7.setProUserCreat(this.usersLog.getUsrid());
                        var7.setProVteNat("1104");
                        var7.setProVteCode(var2.getFamvteCode());
                        var7.setProVteLib(var2.getFamvteLibelleFr());
                        var7.setProVteCpteZ(var2.getFamvteCompteZone());
                        var7.setProVteCpteHz(var2.getFamvteCompteExterieur());
                        var7.setProVteCpteLoc(var2.getFamvteCompteLocal());
                        var7.setProVteCptePr(var2.getFamvteCompteProduit());
                        var7.setProVteCpteSt(var2.getFamvteCompteStock());
                        var7.setProVteDouane(var2.getFamvteDouane());
                        var7.setProVteTva(var2.getFamvteTaxe());
                        var7.setProCode(var6.getCcamDetCode());
                        var7.setProLibClient(var6.getCcamDetLibFr());
                        this.produitsDao.insert(var7, var1);
                     } else {
                        var7.setProDateModif(new Date());
                        var7.setProUserModif(this.usersLog.getUsrid());
                        var7.setProVteNat("1104");
                        var7.setProVteCode(var2.getFamvteCode());
                        var7.setProVteLib(var2.getFamvteLibelleFr());
                        var7.setProVteCpteZ(var2.getFamvteCompteZone());
                        var7.setProVteCpteHz(var2.getFamvteCompteExterieur());
                        var7.setProVteCpteLoc(var2.getFamvteCompteLocal());
                        var7.setProVteCptePr(var2.getFamvteCompteProduit());
                        var7.setProVteCpteSt(var2.getFamvteCompteStock());
                        var7.setProVteDouane(var2.getFamvteDouane());
                        var7.setProVteTva(var2.getFamvteTaxe());
                        var7.setProLibClient(var6.getCcamDetLibFr());
                        this.produitsDao.modif(var7, var1);
                     }
                  }
               }
            }

            var3.commit();
         }
      } catch (HibernateException var11) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var11;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public FamillesProduitsVentes getFamillesProduitsMedical() {
      return this.famillesProduitsMedical;
   }

   public void setFamillesProduitsMedical(FamillesProduitsVentes var1) {
      this.famillesProduitsMedical = var1;
   }

   public CcamMedical getCcamMedicaldetail() {
      return this.ccamMedicaldetail;
   }

   public void setCcamMedicaldetail(CcamMedical var1) {
      this.ccamMedicaldetail = var1;
   }

   public DataModel getDatamodel() {
      return this.datamodel;
   }

   public void setDatamodel(DataModel var1) {
      this.datamodel = var1;
   }

   public DataModel getDatamodeldetail() {
      return this.datamodeldetail;
   }

   public void setDatamodeldetail(DataModel var1) {
      this.datamodeldetail = var1;
   }

   public List getListCcamMedicalDistinct() {
      return this.listCcamMedicalDistinct;
   }

   public void setListCcamMedicalDistinct(List var1) {
      this.listCcamMedicalDistinct = var1;
   }

   public Map getMapCcamMedicalDistinct() {
      return this.mapCcamMedicalDistinct;
   }

   public void setMapCcamMedicalDistinct(Map var1) {
      this.mapCcamMedicalDistinct = var1;
   }

   public CcamMedical getCcamMedical() {
      return this.ccamMedical;
   }

   public void setCcamMedical(CcamMedical var1) {
      this.ccamMedical = var1;
   }

   public DataModel getDatamodelSniv() {
      return this.datamodelSniv;
   }

   public void setDatamodelSniv(DataModel var1) {
      this.datamodelSniv = var1;
   }

   public DataModel getDatamodelSsniv() {
      return this.datamodelSsniv;
   }

   public void setDatamodelSsniv(DataModel var1) {
      this.datamodelSsniv = var1;
   }

   public DataModel getDatamodelSssniv() {
      return this.datamodelSssniv;
   }

   public void setDatamodelSssniv(DataModel var1) {
      this.datamodelSssniv = var1;
   }

   public DataModel getDatamodelSsssniv() {
      return this.datamodelSsssniv;
   }

   public void setDatamodelSsssniv(DataModel var1) {
      this.datamodelSsssniv = var1;
   }

   public List getListCcamMedical() {
      return this.listCcamMedical;
   }

   public void setListCcamMedical(List var1) {
      this.listCcamMedical = var1;
   }

   public List getListCcamMedicaldetail() {
      return this.listCcamMedicaldetail;
   }

   public void setListCcamMedicaldetail(List var1) {
      this.listCcamMedicaldetail = var1;
   }

   public List getListCcamMedicalSDistinct() {
      return this.listCcamMedicalSDistinct;
   }

   public void setListCcamMedicalSDistinct(List var1) {
      this.listCcamMedicalSDistinct = var1;
   }

   public List getListCcamMedicalSsDistinct() {
      return this.listCcamMedicalSsDistinct;
   }

   public void setListCcamMedicalSsDistinct(List var1) {
      this.listCcamMedicalSsDistinct = var1;
   }

   public List getListCcamMedicalSssDistinct() {
      return this.listCcamMedicalSssDistinct;
   }

   public void setListCcamMedicalSssDistinct(List var1) {
      this.listCcamMedicalSssDistinct = var1;
   }

   public List getListCcamMedicalSsssDistinct() {
      return this.listCcamMedicalSsssDistinct;
   }

   public void setListCcamMedicalSsssDistinct(List var1) {
      this.listCcamMedicalSsssDistinct = var1;
   }

   public Map getMapCcamMedicalSDistinct() {
      return this.mapCcamMedicalSDistinct;
   }

   public void setMapCcamMedicalSDistinct(Map var1) {
      this.mapCcamMedicalSDistinct = var1;
   }

   public Map getMapCcamMedicalSsDistinct() {
      return this.mapCcamMedicalSsDistinct;
   }

   public void setMapCcamMedicalSsDistinct(Map var1) {
      this.mapCcamMedicalSsDistinct = var1;
   }

   public Map getMapCcamMedicalSssDistinct() {
      return this.mapCcamMedicalSssDistinct;
   }

   public void setMapCcamMedicalSssDistinct(Map var1) {
      this.mapCcamMedicalSssDistinct = var1;
   }

   public Map getMapCcamMedicalSsssDistinct() {
      return this.mapCcamMedicalSsssDistinct;
   }

   public void setMapCcamMedicalSsssDistinct(Map var1) {
      this.mapCcamMedicalSsssDistinct = var1;
   }

   public List getListCcamMedicalDetail() {
      return this.listCcamMedicalDetail;
   }

   public void setListCcamMedicalDetail(List var1) {
      this.listCcamMedicalDetail = var1;
   }

   public Map getMapCcamMedicalDetail() {
      return this.mapCcamMedicalDetail;
   }

   public void setMapCcamMedicalDetail(Map var1) {
      this.mapCcamMedicalDetail = var1;
   }

   public CcamMedical getCcamMedicalSniv() {
      return this.ccamMedicalSniv;
   }

   public void setCcamMedicalSniv(CcamMedical var1) {
      this.ccamMedicalSniv = var1;
   }

   public CcamMedical getCcamMedicalSsniv() {
      return this.ccamMedicalSsniv;
   }

   public void setCcamMedicalSsniv(CcamMedical var1) {
      this.ccamMedicalSsniv = var1;
   }

   public CcamMedical getCcamMedicalSssniv() {
      return this.ccamMedicalSssniv;
   }

   public void setCcamMedicalSssniv(CcamMedical var1) {
      this.ccamMedicalSssniv = var1;
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
