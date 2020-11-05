package com.epegase.forms.systeme;

import com.epegase.systeme.classe.CabinetPeg;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.StructurePeg;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.CabinetDao;
import com.epegase.systeme.dao.StructureDao;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.jdom.JDOMException;
import org.xml.sax.SAXException;

public class FormSystemCabinet implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private int etat = 9;
   private int mode = 9;
   private CabinetPeg cabinetPeg = new CabinetPeg();
   private CabinetDao cabinetDao;
   private List lesCabinetsPeg = new ArrayList();
   private transient DataModel dataModelLesCabinetsPeg = new ListDataModel();
   private boolean showModalPanelCabinet = false;
   private StructurePeg structurePeg = new StructurePeg();
   private StructureDao structureDao;
   private List lesSocietes = new ArrayList();
   private transient DataModel dataModelLesSocites = new ListDataModel();
   private boolean showModalPanelMandat = false;
   private List lesSocietesRecherchees = new ArrayList();
   private transient DataModel dataModelLesRecherches = new ListDataModel();
   private boolean showModalPanelSociete = false;

   public FormSystemCabinet() throws IOException, SAXException, JDOMException {
   }

   public void instancesDaoUtilisees() {
      this.cabinetDao = new CabinetDao(this.utilInitHibernate);
      this.structureDao = new StructureDao(this.utilInitHibernate);
   }

   public void chargerLesCabinets() throws HibernateException, NamingException {
      String var1 = " where cabId> 0";
      if (this.etat != 9) {
         var1 = var1 + " and cabEtat=" + this.etat;
      }

      if (this.mode != 9) {
         var1 = var1 + " and  cabNature=" + this.mode;
      }

      this.lesCabinetsPeg.clear();
      this.lesCabinetsPeg = this.cabinetDao.chargerCabinet(var1);
      this.dataModelLesCabinetsPeg.setWrappedData(this.lesCabinetsPeg);
      this.cabinetPeg = new CabinetPeg();
   }

   public void selectionCabinet() throws HibernateException, NamingException {
      if (this.dataModelLesCabinetsPeg.isRowAvailable()) {
         this.cabinetPeg = (CabinetPeg)this.dataModelLesCabinetsPeg.getRowData();
         this.lesSocietes.clear();
         String var1 = " where cabinetPeg.cabId=" + this.cabinetPeg.getCabId();
         this.lesSocietes = this.structureDao.selectStructureCabinet(var1);
         this.dataModelLesSocites.setWrappedData(this.lesSocietes);
         this.structurePeg = new StructurePeg();
      }

   }

   public void ajouterCabinet() {
      this.cabinetPeg = new CabinetPeg();
      this.showModalPanelCabinet = true;
   }

   public void modifierCabinet() {
      this.showModalPanelCabinet = true;
   }

   public void supprimerCabinet() {
   }

   public void fermerCabinet() {
      this.showModalPanelCabinet = false;
   }

   public void saveCabinet() throws HibernateException, NamingException {
      if (this.cabinetPeg.getCabId() == 0L) {
         this.cabinetPeg.setCabDteCreat(new Date());
         this.cabinetPeg = this.cabinetDao.insertPeg(this.cabinetPeg);
         this.lesCabinetsPeg.add(this.cabinetPeg);
         this.dataModelLesCabinetsPeg.setWrappedData(this.lesCabinetsPeg);
      } else {
         this.cabinetPeg = this.cabinetDao.modifPeg(this.cabinetPeg);
      }

      this.showModalPanelCabinet = false;
   }

   public void selectionSociete() {
      if (this.dataModelLesSocites.isRowAvailable()) {
         this.structurePeg = (StructurePeg)this.dataModelLesSocites.getRowData();
      } else {
         this.structurePeg = null;
      }

   }

   public void chargerSociete() throws HibernateException, NamingException {
      this.lesSocietesRecherchees.clear();
      String var1 = " where cabinetPeg is null ";
      this.lesSocietesRecherchees = this.structureDao.selectStructureCabinet(var1);
      this.dataModelLesRecherches.setWrappedData(this.lesSocietesRecherchees);
      this.showModalPanelSociete = true;
   }

   public void selectionRecherche() {
      if (this.dataModelLesRecherches.isRowAvailable()) {
         this.structurePeg = (StructurePeg)this.dataModelLesRecherches.getRowData();
      } else {
         this.structurePeg = null;
      }

   }

   public void fermerSociete() {
      this.showModalPanelSociete = false;
   }

   public void valideSociete() throws HibernateException, NamingException {
      if (this.structurePeg != null) {
         if (this.lesSocietes.size() == 0) {
            this.structurePeg.setStrmaitrecabinet(this.cabinetPeg.getCabNature());
         } else {
            this.structurePeg.setStrmaitrecabinet(0);
         }

         this.structurePeg.setCabinetPeg(this.cabinetPeg);
         this.structurePeg = this.structureDao.updatCrPeg(this.structurePeg);
         this.lesSocietes.add(this.structurePeg);
         this.dataModelLesSocites.setWrappedData(this.lesSocietes);
         String var1 = "structure" + this.structurePeg.getStrId();
         StructureDao var2 = new StructureDao(var1, this.utilInitHibernate);
         new Structure();
         Structure var3 = var2.logStructureId(this.structurePeg.getStrId(), (Session)null);
         if (var3 != null) {
            var3.setStrmaitrecabinet(this.structurePeg.getStrmaitrecabinet());
            var3.setStrDteDebMandat(this.structurePeg.getStrdtedebmandat());
            var3.setStrDteFinMandat(this.structurePeg.getStrdtefinmandat());
            var3.setStrEtatMandat(this.structurePeg.getStretatmandat());
            var2.modStructure(var3);
         }
      }

      this.showModalPanelSociete = false;
   }

   public void supprimerAffectation() throws HibernateException, NamingException {
      if (this.structurePeg != null) {
         this.structurePeg.setCabinetPeg((CabinetPeg)null);
         this.structurePeg.setStrmaitrecabinet(0);
         this.structurePeg.setStrdtedebmandat((Date)null);
         this.structurePeg.setStrdtefinmandat((Date)null);
         this.structurePeg = this.structureDao.updatCrPeg(this.structurePeg);
         this.lesSocietes.remove(this.structurePeg);
         String var1 = "structure" + this.structurePeg.getStrId();
         StructureDao var2 = new StructureDao(var1, this.utilInitHibernate);
         new Structure();
         Structure var3 = var2.logStructureId(this.structurePeg.getStrId(), (Session)null);
         if (var3 != null) {
            var3.setStrmaitrecabinet(0);
            var3.setStrDteDebMandat((Date)null);
            var3.setStrDteFinMandat((Date)null);
            var3.setStrEtatMandat(0);
            var2.modStructure(var3);
         }
      }

   }

   public void modifierMandat() {
      this.showModalPanelMandat = true;
   }

   public void fermerMandat() {
      this.showModalPanelMandat = false;
   }

   public void validerMandat() throws HibernateException, NamingException {
      if (this.structurePeg != null) {
         this.structurePeg = this.structureDao.updatCrPeg(this.structurePeg);
         String var1 = "structure" + this.structurePeg.getStrId();
         StructureDao var2 = new StructureDao(var1, this.utilInitHibernate);
         new Structure();
         Structure var3 = var2.logStructureId(this.structurePeg.getStrId(), (Session)null);
         if (var3 != null) {
            var3.setStrmaitrecabinet(this.structurePeg.getStrmaitrecabinet());
            var3.setStrDteDebMandat(this.structurePeg.getStrdtedebmandat());
            var3.setStrDteFinMandat(this.structurePeg.getStrdtefinmandat());
            var3.setStrEtatMandat(this.structurePeg.getStretatmandat());
            var2.modStructure(var3);
         }
      }

      this.showModalPanelMandat = false;
   }

   public StructurePeg getStructurePeg() {
      return this.structurePeg;
   }

   public void setStructurePeg(StructurePeg var1) {
      this.structurePeg = var1;
   }

   public DataModel getDataModelLesSocites() {
      return this.dataModelLesSocites;
   }

   public void setDataModelLesSocites(DataModel var1) {
      this.dataModelLesSocites = var1;
   }

   public int getEtat() {
      return this.etat;
   }

   public void setEtat(int var1) {
      this.etat = var1;
   }

   public int getMode() {
      return this.mode;
   }

   public void setMode(int var1) {
      this.mode = var1;
   }

   public List getLesSocietes() {
      return this.lesSocietes;
   }

   public void setLesSocietes(List var1) {
      this.lesSocietes = var1;
   }

   public DataModel getDataModelLesCabinetsPeg() {
      return this.dataModelLesCabinetsPeg;
   }

   public void setDataModelLesCabinetsPeg(DataModel var1) {
      this.dataModelLesCabinetsPeg = var1;
   }

   public CabinetPeg getCabinetPeg() {
      return this.cabinetPeg;
   }

   public void setCabinetPeg(CabinetPeg var1) {
      this.cabinetPeg = var1;
   }

   public boolean isShowModalPanelCabinet() {
      return this.showModalPanelCabinet;
   }

   public void setShowModalPanelCabinet(boolean var1) {
      this.showModalPanelCabinet = var1;
   }

   public DataModel getDataModelLesRecherches() {
      return this.dataModelLesRecherches;
   }

   public void setDataModelLesRecherches(DataModel var1) {
      this.dataModelLesRecherches = var1;
   }

   public boolean isShowModalPanelSociete() {
      return this.showModalPanelSociete;
   }

   public void setShowModalPanelSociete(boolean var1) {
      this.showModalPanelSociete = var1;
   }

   public boolean isShowModalPanelMandat() {
      return this.showModalPanelMandat;
   }

   public void setShowModalPanelMandat(boolean var1) {
      this.showModalPanelMandat = var1;
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

   public UtilInitHibernate getUtilInitHibernate() {
      return this.utilInitHibernate;
   }

   public void setUtilInitHibernate(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }
}
