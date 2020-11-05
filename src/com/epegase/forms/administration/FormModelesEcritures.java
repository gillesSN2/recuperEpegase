package com.epegase.forms.administration;

import com.epegase.systeme.classe.EcrituresModeles;
import com.epegase.systeme.classe.EcrituresModelesLignes;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.PlanComptable;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.EcrituresModelesDao;
import com.epegase.systeme.dao.EcrituresModelesLignesDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.PlanComptableDao;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FormModelesEcritures implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String lien;
   private boolean codelibVide = false;
   private boolean existeCode = true;
   private String pageIndex;
   private ExercicesComptable lastExercice;
   private List LesEcrituresModeles = new ArrayList();
   private transient DataModel datamodelEcrituresModeles = new ListDataModel();
   private EcrituresModeles ecrituresModeles;
   private EcrituresModelesDao ecrituresModelesDao;
   private boolean showmodelPanel = false;
   private boolean var_affiche_bouton = false;
   private boolean var_inactif = false;
   private List mesJournaux;
   private JournauxComptablesDao journauxComptablesDao;
   private List LesEcrituresModelesLines = new ArrayList();
   private transient DataModel datamodelEcrituresModelesLignes;
   private EcrituresModelesLignes ecrituresModelesLignes;
   private EcrituresModelesLignesDao ecrituresModelesLignesDao;
   private boolean showmodelPanelCompte = false;
   private List lesComptes;
   private transient DataModel dataModelPlbCompte;
   private PlanComptableDao planComptableDao;
   private PlanComptable planComptable;
   private String compte;
   private int choixCompte;
   private boolean showmodelPanelPlCompte = false;
   private String compteImmobilisation;
   private String compteAmortissement;
   private String compteDotation;
   private String compteCession;

   public FormModelesEcritures() {
      this.LesEcrituresModeles = new ArrayList();
      this.datamodelEcrituresModelesLignes = new ListDataModel();
      this.LesEcrituresModelesLines = new ArrayList();
      this.lesComptes = new ArrayList();
      this.dataModelPlbCompte = new ListDataModel();
      this.mesJournaux = new ArrayList();
   }

   public void InstancesDaoUtilses() {
      this.ecrituresModelesDao = new EcrituresModelesDao(this.baseLog, this.utilInitHibernate);
      this.ecrituresModelesLignesDao = new EcrituresModelesLignesDao(this.baseLog, this.utilInitHibernate);
      this.planComptableDao = new PlanComptableDao(this.baseLog, this.utilInitHibernate);
      this.journauxComptablesDao = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargeModeles(Session var1) throws HibernateException, NamingException {
      this.LesEcrituresModeles.clear();
      this.LesEcrituresModeles = this.ecrituresModelesDao.selectModeles(var1);
      this.datamodelEcrituresModeles.setWrappedData(this.LesEcrituresModeles);
      this.LesEcrituresModelesLines.clear();
      this.datamodelEcrituresModelesLignes.setWrappedData(this.LesEcrituresModelesLines);
      this.mesJournaux = this.journauxComptablesDao.mesjournauxActifsItems(this.lastExercice.getExecpt_id(), "", 0, var1);
   }

   public void selectionModele() throws HibernateException, NamingException {
      if (this.datamodelEcrituresModeles.isRowAvailable()) {
         this.ecrituresModeles = (EcrituresModeles)this.datamodelEcrituresModeles.getRowData();
         this.ecrituresModelesLignes = new EcrituresModelesLignes();
         this.LesEcrituresModelesLines.clear();
         this.LesEcrituresModelesLines = this.ecrituresModelesLignesDao.selectModelesLignes(this.ecrituresModeles, (Session)null);
         this.compteImmobilisation = "";
         this.compteAmortissement = "";
         this.compteDotation = "";
         this.compteCession = "";
         if (this.LesEcrituresModelesLines.size() != 0) {
            for(int var1 = 0; var1 < this.LesEcrituresModelesLines.size(); ++var1) {
               if (((EcrituresModelesLignes)this.LesEcrituresModelesLines.get(var1)).getModligNature() == 1) {
                  this.compteImmobilisation = ((EcrituresModelesLignes)this.LesEcrituresModelesLines.get(var1)).getModligCompte() + ":" + ((EcrituresModelesLignes)this.LesEcrituresModelesLines.get(var1)).getModligLibelle();
               } else if (((EcrituresModelesLignes)this.LesEcrituresModelesLines.get(var1)).getModligNature() == 2) {
                  this.compteAmortissement = ((EcrituresModelesLignes)this.LesEcrituresModelesLines.get(var1)).getModligCompte() + ":" + ((EcrituresModelesLignes)this.LesEcrituresModelesLines.get(var1)).getModligLibelle();
               } else if (((EcrituresModelesLignes)this.LesEcrituresModelesLines.get(var1)).getModligNature() == 3) {
                  this.compteDotation = ((EcrituresModelesLignes)this.LesEcrituresModelesLines.get(var1)).getModligCompte() + ":" + ((EcrituresModelesLignes)this.LesEcrituresModelesLines.get(var1)).getModligLibelle();
               } else if (((EcrituresModelesLignes)this.LesEcrituresModelesLines.get(var1)).getModligNature() == 4) {
                  this.compteCession = ((EcrituresModelesLignes)this.LesEcrituresModelesLines.get(var1)).getModligCompte() + ":" + ((EcrituresModelesLignes)this.LesEcrituresModelesLines.get(var1)).getModligLibelle();
               }
            }
         }

         this.datamodelEcrituresModelesLignes.setWrappedData(this.LesEcrituresModelesLines);
         this.var_affiche_bouton = true;
      }

   }

   public void ajouterModele() {
      this.LesEcrituresModelesLines.clear();
      this.datamodelEcrituresModelesLignes.setWrappedData(this.LesEcrituresModelesLines);
      this.compteImmobilisation = "";
      this.compteAmortissement = "";
      this.compteDotation = "";
      this.compteCession = "";
      this.ecrituresModeles = new EcrituresModeles();
      this.ecrituresModelesLignes = new EcrituresModelesLignes();
      this.var_inactif = false;
      this.codelibVide = false;
      this.existeCode = true;
      this.showmodelPanel = true;
   }

   public void modifierModele() {
      if (this.ecrituresModeles != null) {
         this.codelibVide = true;
         this.existeCode = false;
         this.showmodelPanel = true;
      }

   }

   public void supprimerModele() throws HibernateException, NamingException {
      if (this.ecrituresModeles != null) {
         if (this.LesEcrituresModelesLines.size() != 0) {
            for(int var1 = 0; var1 < this.LesEcrituresModelesLines.size(); ++var1) {
               this.ecrituresModelesLignesDao.delete(this.ecrituresModelesLignes);
            }
         }

         this.LesEcrituresModelesLines.clear();
         this.datamodelEcrituresModelesLignes.setWrappedData(this.LesEcrituresModelesLines);
         this.LesEcrituresModeles.remove(this.ecrituresModeles);
         this.datamodelEcrituresModeles.setWrappedData(this.LesEcrituresModeles);
         this.ecrituresModelesDao.delete(this.ecrituresModeles);
      }

   }

   public void annulerModele() {
      this.var_affiche_bouton = false;
      this.showmodelPanel = false;
   }

   public void saveModele() throws HibernateException, NamingException {
      this.miseAJour();
      this.showmodelPanel = false;
      this.var_affiche_bouton = false;
   }

   public void miseAJour() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.ecrituresModeles.setModCode(this.ecrituresModeles.getModCode().toUpperCase());
         this.ecrituresModeles.setModLibelle(this.ecrituresModeles.getModLibelle().toUpperCase());
         if (this.ecrituresModeles.getModType() == 1) {
            this.ecrituresModeles.setModJournal("");
         }

         if (this.ecrituresModeles.getModId() == 0L) {
            this.ecrituresModeles.setModUserCreat(this.usersLog.getUsrid());
            this.ecrituresModeles.setModDateCreat(new Date());
            this.ecrituresModeles = this.ecrituresModelesDao.insert(this.ecrituresModeles, var1);
            this.LesEcrituresModeles.add(this.ecrituresModeles);
            this.datamodelEcrituresModeles.setWrappedData(this.LesEcrituresModeles);
         } else {
            this.ecrituresModeles.setModUserModif(this.usersLog.getUsrid());
            this.ecrituresModeles.setModDateModif(new Date());
            this.ecrituresModeles = this.ecrituresModelesDao.modif(this.ecrituresModeles, var1);
         }

         if (this.ecrituresModeles.getModType() == 1) {
            new ArrayList();
            List var3 = this.ecrituresModelesLignesDao.selectModelesLignes(this.ecrituresModeles, var1);
            if (var3.size() != 0) {
               for(int var4 = 0; var4 < var3.size(); ++var4) {
                  this.ecrituresModelesLignesDao.delete((EcrituresModelesLignes)var3.get(var4), var1);
               }
            }

            if (this.compteImmobilisation != null && !this.compteImmobilisation.isEmpty()) {
               this.saveAmortissement(this.compteImmobilisation, 1, var1);
            }

            if (this.compteAmortissement != null && !this.compteAmortissement.isEmpty()) {
               this.saveAmortissement(this.compteAmortissement, 2, var1);
            }

            if (this.compteDotation != null && !this.compteDotation.isEmpty()) {
               this.saveAmortissement(this.compteDotation, 3, var1);
            }

            if (this.compteCession != null && !this.compteCession.isEmpty()) {
               this.saveAmortissement(this.compteCession, 4, var1);
            }
         }

         var2.commit();
      } catch (HibernateException var8) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var8;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void saveAmortissement(String var1, int var2, Session var3) throws HibernateException, NamingException {
      this.ecrituresModelesLignes = new EcrituresModelesLignes();
      this.ecrituresModelesLignes.setEcrituresModeles(this.ecrituresModeles);
      String[] var4 = var1.split(":");
      this.ecrituresModelesLignes.setModligCompte(var4[0]);
      this.ecrituresModelesLignes.setModligLibelle(var4[1]);
      this.ecrituresModelesLignes.setModligNature(var2);
      this.ecrituresModelesLignes.setModligSens(0);
      this.ecrituresModelesLignes = this.ecrituresModelesLignesDao.insert(this.ecrituresModelesLignes, var3);
   }

   public void verifielesSaisieCode() throws HibernateException, NamingException {
      this.existeCode = this.ecrituresModelesDao.existCode(this.ecrituresModeles.getModCode(), (Session)null);
      if (!this.existeCode) {
         this.codelibVide = false;
      } else {
         this.verifielesSaisieLibelle();
      }

   }

   public void verifielesSaisieLibelle() {
      if (this.ecrituresModeles != null && !this.ecrituresModeles.getModLibelle().isEmpty()) {
         this.codelibVide = true;
      } else {
         this.codelibVide = false;
      }

   }

   public void selectionCompte() throws HibernateException, NamingException {
      if (this.datamodelEcrituresModelesLignes.isRowAvailable()) {
         this.ecrituresModelesLignes = (EcrituresModelesLignes)this.datamodelEcrituresModelesLignes.getRowData();
         this.compte = this.ecrituresModelesLignes.getModligCompte() + ":" + this.ecrituresModelesLignes.getModligLibelle();
         this.planComptable = this.planComptableDao.trouveCompte("", 0L, this.ecrituresModelesLignes.getModligCompte(), (Session)null);
      }

   }

   public void ajouterCompte() {
      this.planComptable = new PlanComptable();
      this.lesComptes.clear();
      this.dataModelPlbCompte.setWrappedData(this.lesComptes);
      this.compte = "";
      this.compteImmobilisation = "";
      this.compteAmortissement = "";
      this.compteDotation = "";
      this.compteCession = "";
      this.showmodelPanelCompte = true;
   }

   public void modifierCompte() {
      if (this.ecrituresModelesLignes != null) {
         this.showmodelPanelCompte = true;
      }

   }

   public void saveCompte() throws HibernateException, NamingException {
      if (this.ecrituresModeles == null || this.ecrituresModeles.getModId() == 0L) {
         this.miseAJour();
      }

      if (this.ecrituresModelesLignes != null && this.planComptable != null) {
         if (this.ecrituresModelesLignes.getModligId() == 0L) {
            this.ecrituresModelesLignes.setModligCompte(this.planComptable.getPlcCompte());
            this.ecrituresModelesLignes.setModligLibelle(this.planComptable.getPlcLibelleCpteFR());
            this.ecrituresModelesLignes.setModligNature(0);
            this.ecrituresModelesLignes.setEcrituresModeles(this.ecrituresModeles);
            this.ecrituresModelesLignes = this.ecrituresModelesLignesDao.insert(this.ecrituresModelesLignes);
            this.LesEcrituresModelesLines.add(this.ecrituresModelesLignes);
            this.datamodelEcrituresModelesLignes.setWrappedData(this.LesEcrituresModelesLines);
         } else {
            this.ecrituresModelesLignes.setModligCompte(this.planComptable.getPlcCompte());
            this.ecrituresModelesLignes.setModligLibelle(this.planComptable.getPlcLibelleCpteFR());
            this.ecrituresModelesLignes.setModligNature(0);
            this.ecrituresModelesLignes.setEcrituresModeles(this.ecrituresModeles);
            this.ecrituresModelesLignes = this.ecrituresModelesLignesDao.modif(this.ecrituresModelesLignes);
         }
      }

      this.showmodelPanelCompte = false;
   }

   public void supprimerCompte() throws HibernateException, NamingException {
      if (this.ecrituresModelesLignes != null) {
         this.ecrituresModelesLignesDao.delete(this.ecrituresModelesLignes);
         this.LesEcrituresModelesLines.remove(this.ecrituresModelesLignes);
         this.datamodelEcrituresModelesLignes.setWrappedData(this.LesEcrituresModelesLines);
      }

   }

   public void annulerCompte() {
      this.showmodelPanelCompte = false;
   }

   public void rechcherCompteGene() throws ClassCastException, HibernateException, NamingException {
      this.rechcherCompte(0, this.compte);
   }

   public void rechcherCompteImmo() throws ClassCastException, HibernateException, NamingException {
      this.rechcherCompte(1, this.compteImmobilisation);
   }

   public void rechcherCompteAmo() throws ClassCastException, HibernateException, NamingException {
      this.rechcherCompte(2, this.compteAmortissement);
   }

   public void rechcherCompteDot() throws ClassCastException, HibernateException, NamingException {
      this.rechcherCompte(3, this.compteDotation);
   }

   public void rechcherCompteCes() throws ClassCastException, HibernateException, NamingException {
      this.rechcherCompte(4, this.compteCession);
   }

   public void rechcherCompte(int var1, String var2) throws ClassCastException, HibernateException, NamingException {
      this.choixCompte = var1;
      this.planComptable = new PlanComptable();
      if (var2 != null && !var2.isEmpty()) {
         this.lesComptes.clear();
         this.lesComptes = this.planComptableDao.chargerlesNumCpte(var2, (Session)null);
         if (this.lesComptes.size() != 0) {
            this.dataModelPlbCompte.setWrappedData(this.lesComptes);
            this.showmodelPanelPlCompte = true;
         }
      }

   }

   public void selectionPlCompte() {
      if (this.dataModelPlbCompte.isRowAvailable()) {
         this.planComptable = (PlanComptable)this.dataModelPlbCompte.getRowData();
      }

   }

   public void fermerCompte() {
      this.showmodelPanelPlCompte = false;
   }

   public void validerCompte() {
      if (this.planComptable != null) {
         if (this.choixCompte == 0) {
            this.compte = this.planComptable.getPlcCompte() + ":" + this.planComptable.getPlcLibelleCpteFR();
         } else if (this.choixCompte == 1) {
            this.compteImmobilisation = this.planComptable.getPlcCompte() + ":" + this.planComptable.getPlcLibelleCpteFR();
         } else if (this.choixCompte == 2) {
            this.compteAmortissement = this.planComptable.getPlcCompte() + ":" + this.planComptable.getPlcLibelleCpteFR();
         } else if (this.choixCompte == 3) {
            this.compteDotation = this.planComptable.getPlcCompte() + ":" + this.planComptable.getPlcLibelleCpteFR();
         } else if (this.choixCompte == 4) {
            this.compteCession = this.planComptable.getPlcCompte() + ":" + this.planComptable.getPlcLibelleCpteFR();
         }

         this.ecrituresModelesLignes.setModligSens(this.planComptable.getPlcSens());
      }

      this.showmodelPanelPlCompte = false;
   }

   public boolean isCodelibVide() {
      return this.codelibVide;
   }

   public void setCodelibVide(boolean var1) {
      this.codelibVide = var1;
   }

   public boolean isExisteCode() {
      return this.existeCode;
   }

   public void setExisteCode(boolean var1) {
      this.existeCode = var1;
   }

   public String getLien() {
      return this.lien;
   }

   public void setLien(String var1) {
      this.lien = var1;
   }

   public boolean isVar_affiche_bouton() {
      return this.var_affiche_bouton;
   }

   public void setVar_affiche_bouton(boolean var1) {
      this.var_affiche_bouton = var1;
   }

   public boolean isShowmodelPanel() {
      return this.showmodelPanel;
   }

   public void setShowmodelPanel(boolean var1) {
      this.showmodelPanel = var1;
   }

   public boolean isVar_inactif() {
      return this.var_inactif;
   }

   public void setVar_inactif(boolean var1) {
      this.var_inactif = var1;
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

   public List getLesEcrituresModeles() {
      return this.LesEcrituresModeles;
   }

   public void setLesEcrituresModeles(List var1) {
      this.LesEcrituresModeles = var1;
   }

   public DataModel getDatamodelEcrituresModeles() {
      return this.datamodelEcrituresModeles;
   }

   public void setDatamodelEcrituresModeles(DataModel var1) {
      this.datamodelEcrituresModeles = var1;
   }

   public DataModel getDatamodelEcrituresModelesLignes() {
      return this.datamodelEcrituresModelesLignes;
   }

   public void setDatamodelEcrituresModelesLignes(DataModel var1) {
      this.datamodelEcrituresModelesLignes = var1;
   }

   public EcrituresModeles getEcrituresModeles() {
      return this.ecrituresModeles;
   }

   public void setEcrituresModeles(EcrituresModeles var1) {
      this.ecrituresModeles = var1;
   }

   public EcrituresModelesLignes getEcrituresModelesLignes() {
      return this.ecrituresModelesLignes;
   }

   public void setEcrituresModelesLignes(EcrituresModelesLignes var1) {
      this.ecrituresModelesLignes = var1;
   }

   public String getCompteAmortissement() {
      return this.compteAmortissement;
   }

   public void setCompteAmortissement(String var1) {
      this.compteAmortissement = var1;
   }

   public String getCompteCession() {
      return this.compteCession;
   }

   public void setCompteCession(String var1) {
      this.compteCession = var1;
   }

   public String getCompteDotation() {
      return this.compteDotation;
   }

   public void setCompteDotation(String var1) {
      this.compteDotation = var1;
   }

   public String getCompteImmobilisation() {
      return this.compteImmobilisation;
   }

   public void setCompteImmobilisation(String var1) {
      this.compteImmobilisation = var1;
   }

   public boolean isShowmodelPanelCompte() {
      return this.showmodelPanelCompte;
   }

   public void setShowmodelPanelCompte(boolean var1) {
      this.showmodelPanelCompte = var1;
   }

   public String getCompte() {
      return this.compte;
   }

   public void setCompte(String var1) {
      this.compte = var1;
   }

   public DataModel getDataModelPlbCompte() {
      return this.dataModelPlbCompte;
   }

   public void setDataModelPlbCompte(DataModel var1) {
      this.dataModelPlbCompte = var1;
   }

   public boolean isShowmodelPanelPlCompte() {
      return this.showmodelPanelPlCompte;
   }

   public void setShowmodelPanelPlCompte(boolean var1) {
      this.showmodelPanelPlCompte = var1;
   }

   public PlanComptable getPlanComptable() {
      return this.planComptable;
   }

   public void setPlanComptable(PlanComptable var1) {
      this.planComptable = var1;
   }

   public List getMesJournaux() {
      return this.mesJournaux;
   }

   public void setMesJournaux(List var1) {
      this.mesJournaux = var1;
   }

   public ExercicesComptable getLastExercice() {
      return this.lastExercice;
   }

   public void setLastExercice(ExercicesComptable var1) {
      this.lastExercice = var1;
   }
}
