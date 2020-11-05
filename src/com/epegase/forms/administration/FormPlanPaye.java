package com.epegase.forms.administration;

import com.epegase.systeme.classe.ExercicesPaye;
import com.epegase.systeme.classe.FeuilleCalculRubrique;
import com.epegase.systeme.classe.PlanPaye;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.ObjetPlanPaye;
import com.epegase.systeme.dao.ActivitesDao;
import com.epegase.systeme.dao.FeuilleCalculRubriqueDao;
import com.epegase.systeme.dao.PlanPayeDao;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LecturePlanPaye;
import com.epegase.systeme.xml.OptionPaye;
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

public class FormPlanPaye implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private int var_action;
   private int nature = 9999;
   private int utilisation;
   private OptionPaye optionPaye;
   private ExercicesPaye selectedExo;
   private int var_nb_max = 100;
   private List lesPlansPaye = new ArrayList();
   private PlanPaye planPaye;
   private transient DataModel dataModelPlanPaye = new ListDataModel();
   private PlanPayeDao planPayeDao;
   private boolean afficheRubrique = false;
   private boolean showModalPanelRubrique = false;
   private boolean existeCopteDeja = false;
   private boolean inactif = false;
   private boolean afficheAjDefaut = false;
   private List lesRubCompensatrices = new ArrayList();
   private List lesRubAvantagesNature = new ArrayList();
   private ObjetPlanPaye objetPlanPaye = new ObjetPlanPaye();
   private List lesRubriques = new ArrayList();
   private transient DataModel dataModelRubriques = new ListDataModel();
   private transient DataModel dataModelRubriquesUtil = new ListDataModel();
   private transient DataModel dataModelFeuillesUtil = new ListDataModel();
   private boolean interim;
   private int rubFac;
   private List mesActivitesItems = new ArrayList();

   public void InstancesDaoUtilses() {
      this.planPayeDao = new PlanPayeDao(this.baseLog, this.utilInitHibernate);
   }

   public void initPlanPaye(Session var1) throws HibernateException, NamingException {
      if (this.optionPaye.getNbLigneMax() != null && !this.optionPaye.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionPaye.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      boolean var2 = false;
      Object var3 = var1.createQuery("SELECT COUNT(*) FROM PlanPaye").uniqueResult();
      int var5 = Integer.parseInt(var3.toString());
      if (var5 > 0) {
         this.afficheAjDefaut = false;
      } else {
         this.afficheAjDefaut = true;
      }

      this.interim = this.rechercheModule(80400);
      ActivitesDao var4 = new ActivitesDao(this.baseLog, this.utilInitHibernate);
      this.mesActivitesItems = var4.chargerLesActivitesByCode(var1);
   }

   public void defaultAdd() throws HibernateException, NamingException, ParseException {
      LecturePlanPaye var1 = new LecturePlanPaye();
      var1.setStructureLog(this.structureLog);
      new ArrayList();
      var1.recuperePaye();
      List var2 = var1.getMesPlanPaye();
      if (var2.size() != 0) {
         Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlanPaye");
         Transaction var4 = null;

         try {
            var4 = var3.beginTransaction();
            int var5 = 0;

            while(true) {
               if (var5 >= var2.size()) {
                  var4.commit();
                  break;
               }

               new PlanPaye();
               PlanPaye var6 = (PlanPaye)var2.get(var5);
               var6.setPlpDateCreat(new Date());
               var6.setPlpUserCreat(this.usersLog.getUsrid());
               var6.setPlpDateModif((Date)null);
               var6.setPlpUserModif(0L);
               var6.setExercicesPaye(this.selectedExo);
               this.planPayeDao.insert(var6, var3);
               ++var5;
            }
         } catch (HibernateException var10) {
            if (var4 != null) {
               var4.rollback();
            }

            throw var10;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.nature = 0;
         this.chargerPlanPaye();
      }

      this.afficheAjDefaut = false;
   }

   public void fusionPlp() throws NamingException {
      LecturePlanPaye var1 = new LecturePlanPaye();
      var1.setStructureLog(this.structureLog);
      new ArrayList();
      var1.recuperePaye();
      List var2 = var1.getMesPlanPaye();
      if (var2.size() != 0) {
         Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlanPaye");
         Transaction var4 = null;

         try {
            var4 = var3.beginTransaction();
            new PlanPaye();
            new PlanPaye();
            int var7 = 0;

            while(true) {
               if (var7 >= var2.size()) {
                  var4.commit();
                  break;
               }

               PlanPaye var5 = (PlanPaye)var2.get(var7);
               int var8 = var5.getPlpAnalytique();
               String var9 = var5.getPlpCalculBase();
               boolean var10 = var5.isPlpBaseAutre();
               boolean var11 = var5.isPlpBaseConges();
               boolean var12 = var5.isPlpBaseFiscale();
               boolean var13 = var5.isPlpBasePatronale();
               boolean var14 = var5.isPlpBaseSociale();
               String var15 = var5.getPlpCode();
               String var16 = var5.getPlpCodeLie();
               String var17 = var5.getPlpCommentaire();
               String var18 = var5.getPlpCompteNormal();
               String var19 = var5.getPlpComptePrestataire();
               String var20 = var5.getPlpCpNormal();
               String var21 = var5.getPlpCpPrestataire();
               String var22 = var5.getPlpFormuleFiscale();
               String var23 = var5.getPlpFormulePatronale();
               String var24 = var5.getPlpFormuleSociale();
               int var25 = var5.getPlpGroupe();
               int var26 = var5.getPlpGroupeCp();
               int var27 = var5.getPlpInactif();
               String var28 = var5.getPlpLibelleFR();
               String var29 = var5.getPlpLibelleNatureFR();
               String var30 = var5.getPlpLibelleSP();
               String var31 = var5.getPlpLibelleUK();
               int var32 = var5.getPlpNature();
               int var33 = var5.getPlpOption();
               int var34 = var5.getPlpProrataTemporis();
               int var35 = var5.getPlpProtege();
               int var36 = var5.getPlpRan();
               int var37 = var5.getPlpSens();
               float var38 = var5.getPlpTauxFiscale();
               float var39 = var5.getPlpTauxPatronal();
               float var40 = var5.getPlpTauxSociale();
               PlanPaye var6 = this.planPayeDao.chercherCode(var15, this.selectedExo.getExepayId(), var3);
               if (var6 == null) {
                  var6 = new PlanPaye();
                  var6.setPlpAnalytique(var8);
                  var6.setPlpBaseAutre(var10);
                  var6.setPlpBaseConges(var11);
                  var6.setPlpBaseFiscale(var12);
                  var6.setPlpBasePatronale(var13);
                  var6.setPlpBaseSociale(var14);
                  var6.setPlpCalculBase(var9);
                  var6.setPlpCode(var15);
                  var6.setPlpCodeLie(var16);
                  var6.setPlpCommentaire(var17);
                  var6.setPlpCompteNormal(var18);
                  var6.setPlpComptePrestataire(var19);
                  var6.setPlpCpNormal(var20);
                  var6.setPlpCpPrestataire(var21);
                  var6.setPlpFormuleFiscale(var22);
                  var6.setPlpFormulePatronale(var23);
                  var6.setPlpFormuleSociale(var24);
                  var6.setPlpGroupe(var25);
                  var6.setPlpGroupeCp(var26);
                  var6.setPlpInactif(var27);
                  var6.setPlpLibelleFR(var28);
                  var6.setPlpLibelleNatureFR(var29);
                  var6.setPlpLibelleSP(var30);
                  var6.setPlpLibelleUK(var31);
                  var6.setPlpNature(var32);
                  var6.setPlpOption(var33);
                  var6.setPlpProrataTemporis(var34);
                  var6.setPlpProtege(var35);
                  var6.setPlpRan(var36);
                  var6.setPlpSens(var37);
                  var6.setPlpTauxFiscale(var38);
                  var6.setPlpTauxPatronal(var39);
                  var6.setPlpTauxSociale(var40);
                  var6.setPlpDateCreat(new Date());
                  var6.setPlpUserCreat(this.usersLog.getUsrid());
                  var6.setPlpDateModif((Date)null);
                  var6.setPlpUserModif(0L);
                  var6.setExercicesPaye(this.selectedExo);
                  this.planPayeDao.insert(var6, var3);
               } else {
                  var6.setPlpBaseAutre(var10);
                  var6.setPlpBaseConges(var11);
                  var6.setPlpBaseFiscale(var12);
                  var6.setPlpBasePatronale(var13);
                  var6.setPlpBaseSociale(var14);
                  var6.setPlpAnalytique(var8);
                  var6.setPlpCalculBase(var9);
                  var6.setPlpCode(var15);
                  var6.setPlpCodeLie(var16);
                  var6.setPlpCommentaire(var17);
                  var6.setPlpCompteNormal(var18);
                  var6.setPlpComptePrestataire(var19);
                  var6.setPlpCpNormal(var20);
                  var6.setPlpCpPrestataire(var21);
                  var6.setPlpFormuleFiscale(var22);
                  var6.setPlpFormulePatronale(var23);
                  var6.setPlpFormuleSociale(var24);
                  var6.setPlpGroupe(var25);
                  var6.setPlpGroupeCp(var26);
                  var6.setPlpInactif(var27);
                  var6.setPlpLibelleFR(var28);
                  var6.setPlpLibelleNatureFR(var29);
                  var6.setPlpLibelleSP(var30);
                  var6.setPlpLibelleUK(var31);
                  var6.setPlpNature(var32);
                  var6.setPlpOption(var33);
                  var6.setPlpProrataTemporis(var34);
                  var6.setPlpProtege(var35);
                  var6.setPlpRan(var36);
                  var6.setPlpSens(var37);
                  var6.setPlpTauxFiscale(var38);
                  var6.setPlpTauxPatronal(var39);
                  var6.setPlpTauxSociale(var40);
                  var6.setPlpDateModif(new Date());
                  var6.setPlpUserModif(this.usersLog.getUsrid());
                  var6.setExercicesPaye(this.selectedExo);
                  this.planPayeDao.modif(var6, var3);
               }

               ++var7;
            }
         } catch (HibernateException var44) {
            if (var4 != null) {
               var4.rollback();
            }

            throw var44;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.nature = 0;
         this.chargerPlanPaye();
      }

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

   public void chargerPlanPaye() throws NamingException {
      Object var1 = new ArrayList();
      if (this.utilisation != 0) {
         FeuilleCalculRubriqueDao var2 = new FeuilleCalculRubriqueDao(this.baseLog, this.utilInitHibernate);
         var1 = var2.chargerRubriqueUtiliseesToutesFeuilles((Session)null);
      }

      new ArrayList();
      this.lesPlansPaye.clear();
      this.lesRubCompensatrices.clear();
      this.lesRubAvantagesNature.clear();
      if (this.nature != 9999) {
         List var6 = this.planPayeDao.chargerPlanPayeNature(this.selectedExo.getExepayId(), this.nature, (Session)null);
         if (var6.size() != 0) {
            int var3;
            boolean var4;
            int var5;
            if (this.utilisation == 1) {
               for(var3 = 0; var3 < var6.size(); ++var3) {
                  var4 = false;

                  for(var5 = 0; var5 < ((List)var1).size(); ++var5) {
                     if (((PlanPaye)var6.get(var3)).getPlpInactif() == 0 && ((PlanPaye)var6.get(var3)).getPlpCode().equals(((FeuilleCalculRubrique)((List)var1).get(var5)).getPlanPaye().getPlpCode())) {
                        var4 = true;
                        break;
                     }
                  }

                  if (var4) {
                     this.lesPlansPaye.add(var6.get(var3));
                  }
               }
            } else if (this.utilisation != 2) {
               for(var3 = 0; var3 < var6.size(); ++var3) {
                  this.lesPlansPaye.add(var6.get(var3));
               }
            } else {
               for(var3 = 0; var3 < var6.size(); ++var3) {
                  var4 = false;

                  for(var5 = 0; var5 < ((List)var1).size(); ++var5) {
                     if (((PlanPaye)var6.get(var3)).getPlpInactif() == 0 && ((PlanPaye)var6.get(var3)).getPlpCode().equals(((FeuilleCalculRubrique)((List)var1).get(var5)).getPlanPaye().getPlpCode())) {
                        var4 = true;
                        break;
                     }
                  }

                  if (!var4) {
                     this.lesPlansPaye.add(var6.get(var3));
                  }
               }
            }

            if (this.structureLog.getStrcodepays().equals("0077")) {
               for(var3 = 0; var3 < var6.size(); ++var3) {
                  if (((PlanPaye)var6.get(var3)).getPlpInactif() == 0) {
                     if (((PlanPaye)var6.get(var3)).getPlpNature() == 25) {
                        this.lesRubCompensatrices.add(new SelectItem(((PlanPaye)var6.get(var3)).getPlpCode(), ((PlanPaye)var6.get(var3)).getPlpCode() + ":" + ((PlanPaye)var6.get(var3)).getPlpLibelleFR()));
                     } else if (((PlanPaye)var6.get(var3)).getPlpNature() == 50) {
                        this.lesRubAvantagesNature.add(new SelectItem(((PlanPaye)var6.get(var3)).getPlpCode(), ((PlanPaye)var6.get(var3)).getPlpCode() + ":" + ((PlanPaye)var6.get(var3)).getPlpLibelleFR()));
                     }
                  }
               }
            }
         }
      }

      this.dataModelPlanPaye.setWrappedData(this.lesPlansPaye);
   }

   public void selectionLigne() throws HibernateException, NamingException {
      if (this.dataModelPlanPaye.isRowAvailable()) {
         this.planPaye = (PlanPaye)this.dataModelPlanPaye.getRowData();
         this.afficheRubrique = true;
         if (this.planPaye.getPlpInactif() != 0) {
            this.inactif = true;
         } else {
            this.inactif = false;
         }

         if (this.planPaye.isPlpFacture()) {
            this.rubFac = 1;
         } else {
            this.rubFac = 0;
         }

         this.chargerRubriquesCharges();
         this.calculeRubUtilisees();
         this.calculeAppartenance();
         this.calculeFeuilleUtilisee();
      }

   }

   public void chargerRubriquesCharges() {
      this.lesRubriques.clear();
      if (this.lesPlansPaye.size() != 0) {
         for(int var1 = 0; var1 < this.lesPlansPaye.size(); ++var1) {
            if (!((PlanPaye)this.lesPlansPaye.get(var1)).getPlpCode().equals(this.planPaye.getPlpCode())) {
               this.objetPlanPaye = new ObjetPlanPaye();
               this.objetPlanPaye.setCode(((PlanPaye)this.lesPlansPaye.get(var1)).getPlpCode());
               this.objetPlanPaye.setLibelle(((PlanPaye)this.lesPlansPaye.get(var1)).getPlpLibelleFR());
               this.objetPlanPaye.setPourcentage(0.0F);
               this.objetPlanPaye.setFormule("");
               this.objetPlanPaye.setSelect(false);
               this.objetPlanPaye.setNature(((PlanPaye)this.lesPlansPaye.get(var1)).getPlpNature());
               this.lesRubriques.add(this.objetPlanPaye);
            }
         }
      }

      this.dataModelRubriques.setWrappedData(this.lesRubriques);
   }

   public void calculeRubUtilisees() {
      if (this.planPaye.getPlpCalculBase() != null && !this.planPaye.getPlpCalculBase().isEmpty()) {
         String[] var1;
         String var4;
         if (this.planPaye.getPlpCalculBase().contains("#")) {
            var1 = this.planPaye.getPlpCalculBase().split("#");

            for(int var2 = 0; var2 < var1.length; ++var2) {
               String[] var3 = var1[var2].split(":");
               var4 = var3[0];
               float var5 = Float.parseFloat(var3[2]);
               String var6 = var3[3];

               for(int var7 = 0; var7 < this.lesRubriques.size(); ++var7) {
                  this.objetPlanPaye = (ObjetPlanPaye)this.lesRubriques.get(var7);
                  if (this.objetPlanPaye.getCode().equals(var4)) {
                     this.objetPlanPaye.setPourcentage(var5);
                     if (var6 != null && !var6.isEmpty() && !this.objetPlanPaye.getFormule().equals("null")) {
                        this.objetPlanPaye.setFormule(var6);
                     } else {
                        this.objetPlanPaye.setFormule("");
                     }

                     this.objetPlanPaye.setSelect(true);
                     break;
                  }
               }
            }
         } else if (this.planPaye.getPlpCalculBase().contains(":")) {
            var1 = this.planPaye.getPlpCalculBase().split(":");
            String var8 = var1[0];
            float var9 = Float.parseFloat(var1[2]);
            var4 = var1[3];

            for(int var10 = 0; var10 < this.lesRubriques.size(); ++var10) {
               this.objetPlanPaye = (ObjetPlanPaye)this.lesRubriques.get(var10);
               if (this.objetPlanPaye.getCode().equals(var8)) {
                  this.objetPlanPaye.setPourcentage(var9);
                  if (var4 != null && !var4.isEmpty() && !this.objetPlanPaye.getFormule().equals("null")) {
                     this.objetPlanPaye.setFormule(var4);
                  } else {
                     this.objetPlanPaye.setFormule("");
                  }

                  this.objetPlanPaye.setSelect(true);
                  break;
               }
            }
         }
      }

   }

   public void calculeAppartenance() {
      ArrayList var1 = new ArrayList();
      if (this.lesPlansPaye.size() != 0) {
         new ObjetPlanPaye();

         for(int var3 = 0; var3 < this.lesPlansPaye.size(); ++var3) {
            if (((PlanPaye)this.lesPlansPaye.get(var3)).getPlpCalculBase() != null && !((PlanPaye)this.lesPlansPaye.get(var3)).getPlpCalculBase().isEmpty() && ((PlanPaye)this.lesPlansPaye.get(var3)).getPlpCalculBase().contains(this.planPaye.getPlpCode())) {
               ObjetPlanPaye var2 = new ObjetPlanPaye();
               var2.setCode(((PlanPaye)this.lesPlansPaye.get(var3)).getPlpCode());
               var2.setFormule("");
               var2.setLibelle(((PlanPaye)this.lesPlansPaye.get(var3)).getPlpLibelleFR());
               var2.setNature(((PlanPaye)this.lesPlansPaye.get(var3)).getPlpNature());
               var2.setPourcentage(0.0F);
               var2.setSelect(true);
               var1.add(var2);
            }
         }
      }

      this.dataModelRubriquesUtil.setWrappedData(var1);
   }

   public void calculeFeuilleUtilisee() throws HibernateException, NamingException {
      ArrayList var1 = new ArrayList();
      new ArrayList();
      FeuilleCalculRubriqueDao var3 = new FeuilleCalculRubriqueDao(this.baseLog, this.utilInitHibernate);
      List var2 = var3.chargerRubriqueFeuille((String)this.planPaye.getPlpCode(), (Session)null);
      if (var2.size() != 0) {
         new ObjetPlanPaye();

         for(int var5 = 0; var5 < var2.size(); ++var5) {
            ObjetPlanPaye var4 = new ObjetPlanPaye();
            var4.setCode(((FeuilleCalculRubrique)var2.get(var5)).getFeuilleCalcul().getFeuCode());
            var4.setFormule("");
            var4.setLibelle(((FeuilleCalculRubrique)var2.get(var5)).getFeuilleCalcul().getFeuLibelleFr());
            var4.setNature(0);
            var4.setPourcentage(0.0F);
            var4.setSelect(true);
            var1.add(var4);
         }
      }

      this.dataModelFeuillesUtil.setWrappedData(var1);
   }

   public void changeLigneRub() {
      if (this.dataModelRubriques.isRowAvailable()) {
         this.objetPlanPaye = (ObjetPlanPaye)this.dataModelRubriques.getRowData();
         if (this.objetPlanPaye.isSelect()) {
            if (this.objetPlanPaye.getPourcentage() == 0.0F) {
               this.objetPlanPaye.setPourcentage(100.0F);
            }
         } else {
            this.objetPlanPaye.setPourcentage(0.0F);
            this.objetPlanPaye.setFormule("");
         }
      }

   }

   public void ajouterRubrique() {
      this.planPaye = new PlanPaye();
      this.afficheRubrique = false;
      this.existeCopteDeja = false;
      this.planPaye.setPlpNature(9999);
      this.chargerRubriquesCharges();
      this.dataModelRubriquesUtil = new ListDataModel();
      this.dataModelFeuillesUtil = new ListDataModel();
      this.showModalPanelRubrique = true;
   }

   public void modifierRubrique() {
      if (this.planPaye != null) {
         this.existeCopteDeja = false;
         this.showModalPanelRubrique = true;
      }

   }

   public void supprimerRubrique() throws HibernateException, NamingException {
      if (this.planPaye != null) {
         this.planPaye.setPlpInactif(1);
         this.planPaye = this.planPayeDao.modif(this.planPaye);
         this.inactif = true;
      }

   }

   public void reactiveRubrique() throws HibernateException, NamingException {
      if (this.planPaye != null) {
         this.planPaye.setPlpInactif(0);
         this.planPaye = this.planPayeDao.modif(this.planPaye);
         this.inactif = false;
      }

   }

   public void annulerRubrique() {
      this.afficheRubrique = false;
      this.showModalPanelRubrique = false;
   }

   public void testeUniciteRubrique() throws HibernateException, NamingException {
      this.existeCopteDeja = this.planPayeDao.existeCode(this.planPaye.getPlpCode(), this.selectedExo.getExepayId(), (Session)null);
   }

   public void validerRubrique() throws HibernateException, NamingException {
      if (this.inactif) {
         this.planPaye.setPlpInactif(1);
      } else {
         this.planPaye.setPlpInactif(0);
      }

      if (this.rubFac == 1) {
         this.planPaye.setPlpFacture(true);
      } else {
         this.planPaye.setPlpFacture(false);
      }

      this.planPaye.setPlpLibelleNatureFR(this.planPaye.getLibelleNature());
      String var1 = "";
      boolean var2 = false;
      if (this.lesRubriques.size() != 0) {
         for(int var3 = 0; var3 < this.lesRubriques.size(); ++var3) {
            this.objetPlanPaye = (ObjetPlanPaye)this.lesRubriques.get(var3);
            if (this.objetPlanPaye.isSelect()) {
               var2 = true;
               if (this.objetPlanPaye.getFormule() == null || this.objetPlanPaye.getFormule().isEmpty()) {
                  this.objetPlanPaye.setFormule("null");
               }

               if (var1 != null && !var1.isEmpty()) {
                  var1 = var1 + "#" + this.objetPlanPaye.getCode() + ":" + this.objetPlanPaye.getLibelle() + ":" + this.objetPlanPaye.getPourcentage() + ":" + this.objetPlanPaye.getFormule();
               } else {
                  var1 = this.objetPlanPaye.getCode() + ":" + this.objetPlanPaye.getLibelle() + ":" + this.objetPlanPaye.getPourcentage() + ":" + this.objetPlanPaye.getFormule();
               }
            }
         }
      }

      this.planPaye.setPlpCalculBase(var1);
      this.planPaye.setPlpBaseAutre(var2);
      if (this.planPaye.getPlpId() == 0L) {
         this.planPaye.setExercicesPaye(this.selectedExo);
         this.planPaye = this.planPayeDao.insert(this.planPaye);
         this.lesPlansPaye.add(this.planPaye);
         this.dataModelPlanPaye.setWrappedData(this.lesPlansPaye);
      } else {
         this.planPaye = this.planPayeDao.modif(this.planPaye);
      }

      if (this.planPaye.getPlpNature() == 40 || this.planPaye.getPlpNature() == 60 || this.planPaye.getPlpNature() == 61 || this.planPaye.getPlpNature() == 62 || this.planPaye.getPlpNature() == 90) {
         Session var14 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlanPaye");
         Transaction var4 = null;

         try {
            var4 = var14.beginTransaction();
            new PlanPaye();

            for(int var6 = 0; var6 < this.lesPlansPaye.size(); ++var6) {
               PlanPaye var5 = (PlanPaye)this.lesPlansPaye.get(var6);
               if (var5.getPlpNature() == this.planPaye.getPlpNature()) {
                  var5.setPlpCalculBase(this.planPaye.getPlpCalculBase());
                  var5 = this.planPayeDao.modif(var5, var14);
               }

               boolean var7 = false;

               for(int var8 = 0; var8 < this.lesRubriques.size(); ++var8) {
                  this.objetPlanPaye = (ObjetPlanPaye)this.lesRubriques.get(var8);
                  if (var5.getPlpCode().equals(this.objetPlanPaye.getCode()) && this.objetPlanPaye.isSelect()) {
                     if (this.planPaye.getPlpNature() == 40) {
                        var5.setPlpBaseConges(true);
                     } else if (this.planPaye.getPlpNature() == 60) {
                        var5.setPlpBaseFiscale(true);
                        var5.setPlpTauxFiscale(this.objetPlanPaye.getPourcentage());
                     } else if (this.planPaye.getPlpNature() == 61) {
                        var5.setPlpBaseSociale(true);
                        var5.setPlpTauxSociale(this.objetPlanPaye.getPourcentage());
                     } else if (this.planPaye.getPlpNature() == 62) {
                        var5.setPlpBaseAutre(true);
                     } else if (this.planPaye.getPlpNature() == 90) {
                        var5.setPlpBasePatronale(true);
                        var5.setPlpTauxPatronal(this.objetPlanPaye.getPourcentage());
                     }

                     var5 = this.planPayeDao.modif(var5, var14);
                     var7 = true;
                     break;
                  }
               }

               if (!var7) {
                  if (this.planPaye.getPlpNature() == 40) {
                     var5.setPlpBaseConges(false);
                  } else if (this.planPaye.getPlpNature() == 60) {
                     var5.setPlpBaseFiscale(false);
                     var5.setPlpTauxFiscale(0.0F);
                  } else if (this.planPaye.getPlpNature() == 61) {
                     var5.setPlpBaseSociale(false);
                     var5.setPlpTauxSociale(0.0F);
                  } else if (this.planPaye.getPlpNature() == 62) {
                     var5.setPlpBaseAutre(false);
                  } else if (this.planPaye.getPlpNature() == 90) {
                     var5.setPlpBasePatronale(false);
                     var5.setPlpTauxPatronal(0.0F);
                  }

                  this.planPayeDao.modif(var5, var14);
               }
            }

            var4.commit();
         } catch (HibernateException var12) {
            if (var4 != null) {
               var4.rollback();
            }

            throw var12;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.afficheRubrique = true;
      this.showModalPanelRubrique = false;
   }

   public void calculImpositionDefaut() {
      if (this.planPaye.getPlpNature() != 10 && this.planPaye.getPlpNature() != 20 && this.planPaye.getPlpNature() != 30 && this.planPaye.getPlpNature() != 40 && this.planPaye.getPlpNature() != 41 && this.planPaye.getPlpNature() != 50) {
         this.planPaye.setPlpBaseFiscale(false);
         this.planPaye.setPlpBaseSociale(false);
         this.planPaye.setPlpBasePatronale(false);
         this.planPaye.setPlpBaseAutre(false);
         this.planPaye.setPlpTauxFiscale(0.0F);
         this.planPaye.setPlpTauxSociale(0.0F);
         this.planPaye.setPlpTauxPatronal(0.0F);
         this.planPaye.setPlpFormuleFiscale("");
         this.planPaye.setPlpFormuleSociale("");
         this.planPaye.setPlpFormulePatronale("");
      } else {
         this.planPaye.setPlpBaseFiscale(true);
         this.planPaye.setPlpBaseSociale(true);
         this.planPaye.setPlpBasePatronale(true);
         this.planPaye.setPlpBaseAutre(true);
         this.planPaye.setPlpTauxFiscale(100.0F);
         this.planPaye.setPlpTauxSociale(100.0F);
         this.planPaye.setPlpTauxPatronal(100.0F);
         this.planPaye.setPlpFormuleFiscale("");
         this.planPaye.setPlpFormuleSociale("");
         this.planPaye.setPlpFormulePatronale("");
      }

   }

   public boolean isAfficheRubrique() {
      return this.afficheRubrique;
   }

   public void setAfficheRubrique(boolean var1) {
      this.afficheRubrique = var1;
   }

   public String getBaseLog() {
      return this.baseLog;
   }

   public void setBaseLog(String var1) {
      this.baseLog = var1;
   }

   public DataModel getDataModelPlanPaye() {
      return this.dataModelPlanPaye;
   }

   public void setDataModelPlanPaye(DataModel var1) {
      this.dataModelPlanPaye = var1;
   }

   public OptionPaye getOptionPaye() {
      return this.optionPaye;
   }

   public void setOptionPaye(OptionPaye var1) {
      this.optionPaye = var1;
   }

   public PlanPaye getPlanPaye() {
      return this.planPaye;
   }

   public void setPlanPaye(PlanPaye var1) {
      this.planPaye = var1;
   }

   public boolean isShowModalPanelRubrique() {
      return this.showModalPanelRubrique;
   }

   public void setShowModalPanelRubrique(boolean var1) {
      this.showModalPanelRubrique = var1;
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

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
   }

   public int getUtilisation() {
      return this.utilisation;
   }

   public void setUtilisation(int var1) {
      this.utilisation = var1;
   }

   public boolean isExisteCopteDeja() {
      return this.existeCopteDeja;
   }

   public void setExisteCopteDeja(boolean var1) {
      this.existeCopteDeja = var1;
   }

   public boolean isInactif() {
      return this.inactif;
   }

   public void setInactif(boolean var1) {
      this.inactif = var1;
   }

   public boolean isAfficheAjDefaut() {
      return this.afficheAjDefaut;
   }

   public void setAfficheAjDefaut(boolean var1) {
      this.afficheAjDefaut = var1;
   }

   public ExercicesPaye getSelectedExo() {
      return this.selectedExo;
   }

   public void setSelectedExo(ExercicesPaye var1) {
      this.selectedExo = var1;
   }

   public List getLesPlansPaye() {
      return this.lesPlansPaye;
   }

   public void setLesPlansPaye(List var1) {
      this.lesPlansPaye = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public DataModel getDataModelRubriques() {
      return this.dataModelRubriques;
   }

   public void setDataModelRubriques(DataModel var1) {
      this.dataModelRubriques = var1;
   }

   public DataModel getDataModelRubriquesUtil() {
      return this.dataModelRubriquesUtil;
   }

   public void setDataModelRubriquesUtil(DataModel var1) {
      this.dataModelRubriquesUtil = var1;
   }

   public DataModel getDataModelFeuillesUtil() {
      return this.dataModelFeuillesUtil;
   }

   public void setDataModelFeuillesUtil(DataModel var1) {
      this.dataModelFeuillesUtil = var1;
   }

   public boolean isInterim() {
      return this.interim;
   }

   public void setInterim(boolean var1) {
      this.interim = var1;
   }

   public int getRubFac() {
      return this.rubFac;
   }

   public void setRubFac(int var1) {
      this.rubFac = var1;
   }

   public List getLesRubCompensatrices() {
      return this.lesRubCompensatrices;
   }

   public void setLesRubCompensatrices(List var1) {
      this.lesRubCompensatrices = var1;
   }

   public List getLesRubAvantagesNature() {
      return this.lesRubAvantagesNature;
   }

   public void setLesRubAvantagesNature(List var1) {
      this.lesRubAvantagesNature = var1;
   }

   public List getMesActivitesItems() {
      return this.mesActivitesItems;
   }

   public void setMesActivitesItems(List var1) {
      this.mesActivitesItems = var1;
   }
}
