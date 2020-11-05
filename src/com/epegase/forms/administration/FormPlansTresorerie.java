package com.epegase.forms.administration;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.PlanComptable;
import com.epegase.systeme.classe.PlansTresorerie;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.PlansTresorerieDao;
import com.epegase.systeme.dao.ProjetsDao;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.OptionComptabilite;
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

public class FormPlansTresorerie implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private int var_action = 0;
   private ExercicesComptable lastExercice;
   private ExercicesComptable exoSelectionne;
   private PlansTresorerie plansTresorerie = new PlansTresorerie();
   private List lesPlansTresorerie = new ArrayList();
   private transient DataModel dataModelLesPlansTresorerie = new ListDataModel();
   private boolean existCod = true;
   private boolean inactifPlb = false;
   private boolean showButtonSupp = false;
   private boolean showButtonModif = false;
   private boolean showButtonPanel = false;
   private boolean showModalPanelPlan = false;
   private boolean valideDupplication = false;
   private int ordre;
   private PlansTresorerieDao plansTresorerieDao;
   private String var_annee;
   private String var_anneeDestination;
   private List mesAnneeItems;
   private long idPrec;
   private long idSuiv;
   private long idCpte;
   private int ordreEncours;
   private int ordrePrecedent;
   private int ordreSuivant;
   private int index;
   private boolean projetPresent = false;
   private List mesProjetsItems = new ArrayList();
   private ProjetsDao projetsDao;
   private String var_projet;
   private PlanComptable planComptable = new PlanComptable();
   private FormRecherche formRecherche;
   private OptionComptabilite optionComptabilite;

   public void InstancesDaoUtilses() {
      this.plansTresorerieDao = new PlansTresorerieDao(this.baseLog, this.utilInitHibernate);
      this.projetsDao = new ProjetsDao(this.baseLog, this.utilInitHibernate);
   }

   public void calculAnnee() throws IOException, HibernateException, NamingException {
      this.mesAnneeItems = new ArrayList();
      ExercicesComptableDao var1 = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      List var2 = var1.selectExercicesCompta((Session)null);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            this.mesAnneeItems.add(new SelectItem(((ExercicesComptable)var2.get(var3)).getExecpt_id()));
            if (((ExercicesComptable)var2.get(var3)).getExecpt_id() != (long)(((ExercicesComptable)var2.get(var3)).getExecptDateFin().getYear() + 1900)) {
               long var4 = (long)(((ExercicesComptable)var2.get(var3)).getExecptDateFin().getYear() + 1900) - ((ExercicesComptable)var2.get(var3)).getExecpt_id();

               for(int var6 = 0; (long)var6 < var4; ++var6) {
                  this.mesAnneeItems.add(new SelectItem(((ExercicesComptable)var2.get(var3)).getExecpt_id() + (long)(var6 + 1)));
               }
            }
         }
      }

      this.var_action = 0;
      this.projetPresent = this.rechercheModule(40300);
   }

   public boolean rechercheModule(int var1) {
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
         String var5 = "" + var1;
         if (var5.contentEquals((CharSequence)var3.get(var4))) {
            var2 = true;
         }
      }

      return var2;
   }

   public void selectionAnnee() throws HibernateException, NamingException, ParseException {
      this.lesPlansTresorerie.clear();
      this.mesProjetsItems.clear();
      this.showButtonPanel = false;
      if (this.projetPresent && this.var_annee != null && !this.var_annee.isEmpty()) {
         this.mesProjetsItems = this.projetsDao.chargerLesProjets(0, this.var_annee, (Session)null);
         if (this.mesProjetsItems.size() != 0) {
            this.showButtonPanel = true;
         }
      } else {
         this.showButtonPanel = true;
      }

      this.dataModelLesPlansTresorerie.setWrappedData(this.lesPlansTresorerie);
   }

   public void recherche() throws HibernateException, NamingException {
      this.lesPlansTresorerie.clear();
      if (this.var_annee.length() != 4) {
         this.var_annee = "";
      }

      this.lesPlansTresorerie = this.plansTresorerieDao.chargerLesPlansTresorerie(this.exoSelectionne.getExecpt_id(), this.var_annee, this.var_projet, true, (Session)null);
      this.dataModelLesPlansTresorerie = new ListDataModel();
      this.dataModelLesPlansTresorerie.setWrappedData(this.lesPlansTresorerie);
   }

   public void selectionPlanTresorerie() throws HibernateException, NamingException {
      if (this.dataModelLesPlansTresorerie.isRowAvailable()) {
         this.plansTresorerie = (PlansTresorerie)this.dataModelLesPlansTresorerie.getRowData();
         if (this.plansTresorerie.getTreInactif() == 1) {
            this.inactifPlb = true;
         } else {
            this.inactifPlb = false;
         }

         this.showButtonModif = true;
         this.showButtonSupp = true;
      }

   }

   public void ajouterPoste() {
      this.plansTresorerie = new PlansTresorerie();
      this.existCod = true;
      this.showModalPanelPlan = true;
      this.var_action = 0;
   }

   public void modifierPoste() {
      if (this.plansTresorerie != null) {
         this.existCod = false;
         this.showModalPanelPlan = true;
         this.var_action = 0;
      }

   }

   public void supprimerPoste() throws HibernateException, NamingException {
      if (this.plansTresorerie != null) {
         this.lesPlansTresorerie.remove(this.plansTresorerie);
         this.plansTresorerieDao.delete(this.plansTresorerie);
         this.showModalPanelPlan = false;
      }

   }

   public void annulerSaisie() {
      this.var_action = 0;
      this.showModalPanelPlan = false;
   }

   public void savePlanTresorerie() throws HibernateException, NamingException {
      this.plansTresorerie.setTreAnnee(this.var_annee);
      if (this.projetPresent) {
         this.plansTresorerie.setTreProjet(this.var_projet);
      } else {
         this.plansTresorerie.setTreProjet("");
      }

      if (this.inactifPlb) {
         this.plansTresorerie.setTreInactif(1);
      } else {
         this.plansTresorerie.setTreInactif(0);
      }

      this.plansTresorerie.setTreOrdre(this.getOrdre());
      if (this.plansTresorerie.getTreId() == 0L) {
         this.plansTresorerie.setTreDateCreat(new Date());
         this.plansTresorerie.setTreUserCreat(this.usersLog.getUsrid());
         this.plansTresorerie.setExercicesComptable(this.exoSelectionne);
         this.plansTresorerie = this.plansTresorerieDao.insert(this.plansTresorerie);
         this.lesPlansTresorerie.add(this.plansTresorerie);
         this.dataModelLesPlansTresorerie.setWrappedData(this.lesPlansTresorerie);
      } else {
         this.plansTresorerie.setTreDateModif(new Date());
         this.plansTresorerie.setTreUserModif(this.usersLog.getUsrid());
         this.plansTresorerie = this.plansTresorerieDao.modif(this.plansTresorerie);
      }

      this.var_action = 0;
      this.showModalPanelPlan = false;
   }

   public void verifCode() throws HibernateException, NamingException {
      this.existCod = false;
      this.existCod = this.plansTresorerieDao.existCode(this.var_projet, this.plansTresorerie.getTreCode(), this.exoSelectionne.getExecpt_id(), (Session)null);
   }

   public void duppliquerPlanBud() {
   }

   public void validerDuppliquer() throws HibernateException, NamingException {
      new ArrayList();
      List var1 = this.plansTresorerieDao.chargerLesPlansTresorerieAnnee((String)this.var_annee, (Session)null);
      if (var1.size() != 0) {
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Projets");
         Transaction var3 = null;

         try {
            var3 = var2.beginTransaction();
            new PlansTresorerie();

            for(int var5 = 0; var5 < var1.size(); ++var5) {
               PlansTresorerie var4 = (PlansTresorerie)var1.get(var5);
               PlansTresorerie var6 = new PlansTresorerie();
               var6.setExercicesComptable(this.exoSelectionne);
               var6.setTreAnnee(this.var_anneeDestination);
               var6.setTreCode(var4.getTreCode());
               var6.setTreCompte(var4.getTreCompte());
               var6.setTreDateCreat(new Date());
               var6.setTreDateModif((Date)null);
               var6.setTreIdUsers(var4.getTreIdUsers());
               var6.setTreInactif(var4.getTreInactif());
               var6.setTreLibelleCompte(var4.getTreLibelleCompte());
               var6.setTreLibelleFr(var4.getTreLibelleFr());
               var6.setTreLibelleSp(var4.getTreLibelleSp());
               var6.setTreLibelleUk(var4.getTreLibelleUk());
               var6.setTreOrdre(var4.getTreOrdre());
               var6.setTreProjet(var4.getTreProjet());
               var6.setTreType(var4.getTreType());
               var6.setTreUserCreat(this.usersLog.getUsrid());
               var6.setTreUserModif(0L);
               this.plansTresorerieDao.insert(var6, var2);
            }

            var3.commit();
         } catch (HibernateException var10) {
            if (var3 != null) {
               var3.rollback();
            }

            throw var10;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void verifDuppliquer() {
      if (this.var_anneeDestination != null && !this.var_anneeDestination.isEmpty()) {
         if (!this.var_annee.equals(this.var_anneeDestination)) {
            this.valideDupplication = true;
         } else {
            this.valideDupplication = false;
         }
      } else {
         this.valideDupplication = false;
      }

   }

   public void recherchePlanComptable() throws JDOMException, IOException, HibernateException, NamingException {
      this.planComptable = this.formRecherche.recherchePlanComptable("", this.plansTresorerie.getTreCompte(), 537, this.exoSelectionne, 0, this.usersLog.getUsrCptInterdit(), this.optionComptabilite);
      if (this.planComptable != null) {
         if (this.planComptable.getPlcId() != 0L) {
            this.calculePlanComptable();
         } else {
            this.var_action = 10;
         }
      } else if (this.planComptable == null) {
         this.calculePlanComptable();
      }

   }

   public void recuperationPlanComptable() throws JDOMException, IOException, HibernateException, NamingException {
      this.planComptable = this.formRecherche.calculePlanComptable();
      this.calculePlanComptable();
   }

   public void calculePlanComptable() throws JDOMException, IOException {
      if (this.planComptable != null) {
         this.plansTresorerie.setTreCompte(this.planComptable.getPlcCompte());
         this.plansTresorerie.setTreLibelleCompte(this.planComptable.getPlcLibelleCpteFR());
      } else {
         this.plansTresorerie.setTreCompte("");
         this.plansTresorerie.setTreLibelleCompte("");
      }

      this.var_action = 0;
   }

   public void annulePlanComptable() {
      this.plansTresorerie.setTreCompte("");
      this.plansTresorerie.setTreLibelleCompte("");
      this.var_action = 0;
   }

   public boolean isExistCod() {
      return this.existCod;
   }

   public void setExistCod(boolean var1) {
      this.existCod = var1;
   }

   public ExercicesComptable getExoSelectionne() {
      return this.exoSelectionne;
   }

   public void setExoSelectionne(ExercicesComptable var1) {
      this.exoSelectionne = var1;
   }

   public ExercicesComptable getLastExercice() {
      return this.lastExercice;
   }

   public void setLastExercice(ExercicesComptable var1) {
      this.lastExercice = var1;
   }

   public void setPlansTresorerie(PlansTresorerie var1) {
      this.plansTresorerie = var1;
   }

   public DataModel getDataModelLesPlansTresorerie() {
      return this.dataModelLesPlansTresorerie;
   }

   public void setDataModelLesPlansTresorerie(DataModel var1) {
      this.dataModelLesPlansTresorerie = var1;
   }

   public int getOrdre() {
      return this.ordre;
   }

   public void setOrdre(int var1) {
      this.ordre = var1;
   }

   public boolean isShowButtonModif() {
      return this.showButtonModif;
   }

   public void setShowButtonModif(boolean var1) {
      this.showButtonModif = var1;
   }

   public boolean isShowButtonSupp() {
      return this.showButtonSupp;
   }

   public void setShowButtonSupp(boolean var1) {
      this.showButtonSupp = var1;
   }

   public List getMesAnneeItems() {
      return this.mesAnneeItems;
   }

   public void setMesAnneeItems(List var1) {
      this.mesAnneeItems = var1;
   }

   public String getVar_annee() {
      return this.var_annee;
   }

   public void setVar_annee(String var1) {
      this.var_annee = var1;
   }

   public PlansTresorerie getPlansTresorerie() {
      return this.plansTresorerie;
   }

   public boolean isShowButtonPanel() {
      return this.showButtonPanel;
   }

   public void setShowButtonPanel(boolean var1) {
      this.showButtonPanel = var1;
   }

   public boolean isShowModalPanelPlan() {
      return this.showModalPanelPlan;
   }

   public void setShowModalPanelPlan(boolean var1) {
      this.showModalPanelPlan = var1;
   }

   public boolean isInactifPlb() {
      return this.inactifPlb;
   }

   public void setInactifPlb(boolean var1) {
      this.inactifPlb = var1;
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

   public long getIdCpte() {
      return this.idCpte;
   }

   public void setIdCpte(long var1) {
      this.idCpte = var1;
   }

   public long getIdPrec() {
      return this.idPrec;
   }

   public void setIdPrec(long var1) {
      this.idPrec = var1;
   }

   public long getIdSuiv() {
      return this.idSuiv;
   }

   public void setIdSuiv(long var1) {
      this.idSuiv = var1;
   }

   public int getIndex() {
      return this.index;
   }

   public void setIndex(int var1) {
      this.index = var1;
   }

   public int getOrdreEncours() {
      return this.ordreEncours;
   }

   public void setOrdreEncours(int var1) {
      this.ordreEncours = var1;
   }

   public int getOrdrePrecedent() {
      return this.ordrePrecedent;
   }

   public void setOrdrePrecedent(int var1) {
      this.ordrePrecedent = var1;
   }

   public int getOrdreSuivant() {
      return this.ordreSuivant;
   }

   public void setOrdreSuivant(int var1) {
      this.ordreSuivant = var1;
   }

   public List getLesPlansTresorerie() {
      return this.lesPlansTresorerie;
   }

   public void setLesPlansTresorerie(List var1) {
      this.lesPlansTresorerie = var1;
   }

   public List getMesProjetsItems() {
      return this.mesProjetsItems;
   }

   public void setMesProjetsItems(List var1) {
      this.mesProjetsItems = var1;
   }

   public boolean isProjetPresent() {
      return this.projetPresent;
   }

   public void setProjetPresent(boolean var1) {
      this.projetPresent = var1;
   }

   public String getVar_projet() {
      return this.var_projet;
   }

   public void setVar_projet(String var1) {
      this.var_projet = var1;
   }

   public OptionComptabilite getOptionComptabilite() {
      return this.optionComptabilite;
   }

   public void setOptionComptabilite(OptionComptabilite var1) {
      this.optionComptabilite = var1;
   }

   public int getVar_action() {
      return this.var_action;
   }

   public void setVar_action(int var1) {
      this.var_action = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public boolean isValideDupplication() {
      return this.valideDupplication;
   }

   public void setValideDupplication(boolean var1) {
      this.valideDupplication = var1;
   }

   public String getVar_anneeDestination() {
      return this.var_anneeDestination;
   }

   public void setVar_anneeDestination(String var1) {
      this.var_anneeDestination = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }
}
