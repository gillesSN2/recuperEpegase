package com.epegase.forms.administration;

import com.epegase.systeme.classe.BudgetTresorerie;
import com.epegase.systeme.classe.Ecritures;
import com.epegase.systeme.classe.PlansTresorerie;
import com.epegase.systeme.classe.Projets;
import com.epegase.systeme.classe.SalariesContrats;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.LibDate;
import com.epegase.systeme.dao.BudgetTresorerieDao;
import com.epegase.systeme.dao.EcrituresDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.PlansTresorerieDao;
import com.epegase.systeme.dao.ProjetsDao;
import com.epegase.systeme.dao.SalariesContratsDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FormPlanProjets implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private String lien;
   private boolean codelibVide = false;
   private boolean existeCode = true;
   private UtilDate utilDate = new UtilDate();
   private UtilNombre utilNombre = new UtilNombre();
   private List projetsList = new ArrayList();
   private transient DataModel datamodelProjets;
   private Projets projets;
   private ProjetsDao projetsDao;
   private boolean showmodelPanel = false;
   private boolean var_affiche_bouton = false;
   private boolean var_inactif = false;
   private List mesResponsable = new ArrayList();
   private UserDao userDao;
   private List lesTranches = new ArrayList();
   private transient DataModel dataModelTranches = new ListDataModel();
   private double total_echeance;
   private double ecart;
   private List lesPostes = new ArrayList();
   private transient DataModel dataModelPostes = new ListDataModel();
   private BudgetTresorerieDao budgetTresorerieDao;
   private List lesTreso = new ArrayList();
   private transient DataModel dataModelTresorerie = new ListDataModel();
   private PlansTresorerieDao plansTresorerieDao;
   private List lesUsersHabilites = new ArrayList();
   private transient DataModel dataModelUsersHabilites = new ListDataModel();
   private List lesJrx = new ArrayList();
   private transient DataModel dataModelJrx = new ListDataModel();
   private JournauxComptablesDao journauxComptablesDao;
   private List lesContrats = new ArrayList();
   private transient DataModel dataModelContrat = new ListDataModel();
   private SalariesContratsDao salariesContratsDao;
   private PlansTresorerie plansTresorerie;
   private boolean showModalPanelChangeCode = false;
   private String nouveauCode;
   private String ancienCode;

   public void InstancesDaoUtilses() {
      this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.projetsDao = new ProjetsDao(this.baseLog, this.utilInitHibernate);
      this.budgetTresorerieDao = new BudgetTresorerieDao(this.baseLog, this.utilInitHibernate);
      this.plansTresorerieDao = new PlansTresorerieDao(this.baseLog, this.utilInitHibernate);
      this.journauxComptablesDao = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
      this.salariesContratsDao = new SalariesContratsDao(this.baseLog, this.utilInitHibernate);
   }

   public void lesProjets(Session var1) throws HibernateException, NamingException {
      this.datamodelProjets = new ListDataModel();
      this.projetsList = new ArrayList();
      this.projetsList = this.projetsDao.selectAllProjets(0, var1);
      this.datamodelProjets.setWrappedData(this.projetsList);
      this.mesResponsable.clear();
      this.lesUsersHabilites.clear();
      new ArrayList();
      List var2 = this.userDao.chargerLesSignataires("TOUS", (Session)null);
      if (var2.size() != 0) {
         this.mesResponsable.add(new SelectItem(0, ""));

         for(int var3 = 0; var3 < var2.size(); ++var3) {
            new Users();
            Users var4 = (Users)var2.get(var3);
            this.mesResponsable.add(new SelectItem(var4.getUsrid(), var4.getUsrNom() + ":" + var4.getUsrPrenom()));
            this.lesUsersHabilites.add(var4);
         }
      }

      this.dataModelUsersHabilites.setWrappedData(this.lesUsersHabilites);
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

   public void selectionProjets() throws NamingException, ParseException {
      if (this.datamodelProjets.isRowAvailable()) {
         this.projets = (Projets)this.datamodelProjets.getRowData();
         if (this.projets.getProInactif() == 1) {
            this.var_inactif = true;
         } else {
            this.var_inactif = false;
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Projets");
         this.lesTranches.clear();
         this.calculeTranches();
         String[] var5;
         if (this.lesTranches.size() != 0 && this.projets.getProDateEcheanceDeb() != null && !this.projets.getProDateEcheanceDeb().isEmpty()) {
            if (!this.projets.getProDateEcheanceDeb().contains(":")) {
               new LibDate();
               LibDate var2 = (LibDate)this.lesTranches.get(0);
               var2.setDateDeb(this.utilDate.stringToDateSQLLight(this.projets.getProDateEcheanceDeb()));
               var2.setDateFin(this.utilDate.stringToDateSQLLight(this.projets.getProDateEcheanceFin()));
               var2.setMontant(Double.parseDouble(this.projets.getProMontantEcheance()));
               var2.setLibelle(this.projets.getProObsEcheance());
            } else {
               String[] var15 = this.projets.getProDateEcheanceDeb().split(":");
               String[] var3 = this.projets.getProDateEcheanceFin().split(":");
               String[] var4 = this.projets.getProMontantEcheance().split(":");
               var5 = this.projets.getProObsEcheance().split(":");
               Date var6 = null;
               Date var7 = null;
               double var8 = 0.0D;
               String var10 = "";

               int var11;
               String var12;
               int var13;
               LibDate var14;
               for(var11 = 0; var11 < var15.length; ++var11) {
                  var12 = var15[var11];
                  if (var12 != null && !var12.isEmpty() && !var12.equals("null")) {
                     var6 = this.utilDate.stringToDateSQLLight(var12);
                  } else {
                     var12 = null;
                     var6 = null;
                  }

                  var12 = var3[var11];
                  if (var12 != null && !var12.isEmpty() && !var12.equals("null")) {
                     var7 = this.utilDate.stringToDateSQLLight(var12);
                  } else {
                     var12 = null;
                     var7 = null;
                  }

                  for(var13 = 0; var13 < this.lesTranches.size(); ++var13) {
                     if (var11 == var13) {
                        new LibDate();
                        var14 = (LibDate)this.lesTranches.get(var13);
                        var14.setDateDeb(var6);
                        var14.setDateFin(var7);
                        break;
                     }
                  }
               }

               for(var11 = 0; var11 < var4.length; ++var11) {
                  var12 = var4[var11];
                  if (var12 == null || var12.isEmpty()) {
                     var12 = "0";
                  }

                  var8 = Double.parseDouble(var12);

                  for(var13 = 0; var13 < this.lesTranches.size(); ++var13) {
                     if (var11 == var13) {
                        new LibDate();
                        var14 = (LibDate)this.lesTranches.get(var13);
                        var14.setMontant(var8);
                        break;
                     }
                  }
               }

               for(var11 = 0; var11 < var5.length; ++var11) {
                  var10 = var5[var11];

                  for(int var23 = 0; var23 < this.lesTranches.size(); ++var23) {
                     if (var11 == var23) {
                        new LibDate();
                        LibDate var24 = (LibDate)this.lesTranches.get(var23);
                        var24.setLibelle(var10);
                        break;
                     }
                  }
               }
            }

            this.dataModelTranches.setWrappedData(this.lesTranches);
            this.cumulEcheance();
         }

         this.lesPostes.clear();
         String var16 = this.projets.getProCode() + ":" + this.projets.getProNomFR();
         this.lesPostes = this.budgetTresorerieDao.chargerLesBudgetTresoreries(var16, (String)null, (String)null, true, var1);
         this.dataModelPostes.setWrappedData(this.lesPostes);
         if (this.lesUsersHabilites.size() != 0) {
            int var17;
            Users var18;
            for(var17 = 0; var17 < this.lesUsersHabilites.size(); ++var17) {
               new Users();
               var18 = (Users)this.lesUsersHabilites.get(var17);
               var18.setSelectUser(false);
            }

            var17 = 0;

            while(true) {
               if (var17 >= this.lesUsersHabilites.size()) {
                  this.dataModelUsersHabilites.setWrappedData(this.lesUsersHabilites);
                  break;
               }

               new Users();
               var18 = (Users)this.lesUsersHabilites.get(var17);
               if (this.projets.getProIdUsers() != null && !this.projets.getProIdUsers().isEmpty()) {
                  if (!this.projets.getProIdUsers().contains(":")) {
                     long var20 = Long.parseLong(this.projets.getProIdUsers());
                     if (var18.getUsrid() == var20) {
                        var18.setSelectUser(true);
                     }
                  } else {
                     var5 = this.projets.getProIdUsers().split(":");
                     long var21 = 0L;

                     for(int var22 = 0; var22 < var5.length; ++var22) {
                        String var9 = var5[var22];
                        if (var9 != null && !var9.isEmpty()) {
                           var21 = Long.parseLong(var9);
                           if (var18.getUsrid() == var21) {
                              var18.setSelectUser(true);
                           }
                        }
                     }
                  }
               }

               ++var17;
            }
         }

         this.lesTreso.clear();
         this.lesTreso = this.plansTresorerieDao.chargerLesPlansTresorerieProjet(var16, var1);
         this.dataModelTresorerie.setWrappedData(this.lesTreso);
         this.plansTresorerie = null;
         String var19 = this.projets.getProCode() + ":" + this.projets.getProNomFR();
         this.lesJrx = this.journauxComptablesDao.chargerLesJournauxComptablesByProjet(var19, var1);
         this.dataModelJrx.setWrappedData(this.lesJrx);
         this.lesContrats = this.salariesContratsDao.chargerlesContrats(this.projets.getProCode(), var1);
         this.dataModelContrat.setWrappedData(this.lesContrats);
         this.utilInitHibernate.closeSession();
         this.var_affiche_bouton = true;
      }

   }

   public void ajouterProjets() {
      this.projets = new Projets();
      this.var_inactif = false;
      this.codelibVide = false;
      this.existeCode = true;
      this.showmodelPanel = true;
      this.lesTranches.clear();
      this.calculeTranches();
      this.lesPostes.clear();
      if (this.mesResponsable.size() == 0) {
         this.mesResponsable.add(new SelectItem(this.usersLog.getUsrid(), this.usersLog.getUsrNom() + ":" + this.usersLog.getUsrPrenom()));
      }

      this.dataModelPostes.setWrappedData(this.lesPostes);
   }

   public void modifierProjets() {
      if (this.projets != null) {
         this.codelibVide = true;
         this.existeCode = false;
         this.showmodelPanel = true;
      }

   }

   public void supprimerProjets() throws HibernateException, NamingException {
      if (this.projets != null) {
         this.projetsList.remove(this.projets);
         this.datamodelProjets.setWrappedData(this.projetsList);
         this.projetsDao.delete(this.projets);
      }

   }

   public void annulerProjets() {
      this.var_affiche_bouton = false;
      this.showmodelPanel = false;
   }

   public void calculeTranches() {
      int var1;
      LibDate var2;
      if (this.lesTranches.size() == 0) {
         this.lesTranches.clear();
         if (this.projets.getProNbTranche() != 0) {
            for(var1 = 0; var1 < this.projets.getProNbTranche(); ++var1) {
               var2 = new LibDate();
               this.lesTranches.add(var2);
            }
         }

         this.dataModelTranches.setWrappedData(this.lesTranches);
         this.total_echeance = 0.0D;
         this.ecart = 0.0D;
      } else if (this.lesTranches.size() < this.projets.getProNbTranche()) {
         var1 = this.projets.getProNbTranche() - this.lesTranches.size();

         for(int var4 = 0; var4 < var1; ++var4) {
            LibDate var3 = new LibDate();
            this.lesTranches.add(var3);
         }

         this.dataModelTranches.setWrappedData(this.lesTranches);
      } else if (this.lesTranches.size() > this.projets.getProNbTranche()) {
         this.lesTranches.clear();
         if (this.projets.getProNbTranche() != 0) {
            for(var1 = 0; var1 < this.projets.getProNbTranche(); ++var1) {
               var2 = new LibDate();
               this.lesTranches.add(var2);
            }
         }

         this.dataModelTranches.setWrappedData(this.lesTranches);
      }

   }

   public void cumulEcheance() {
      this.total_echeance = 0.0D;
      this.ecart = 0.0D;
      if (this.lesTranches.size() != 0) {
         for(int var1 = 0; var1 < this.lesTranches.size(); ++var1) {
            this.total_echeance += ((LibDate)this.lesTranches.get(var1)).getMontant();
         }

         this.ecart = this.projets.getProMontantPays() - this.total_echeance;
      }

   }

   public void saveProjets() throws HibernateException, NamingException, ParseException {
      if (this.projets.getProIdResponsable() != 0L) {
         new Users();
         Users var1 = this.userDao.selectByIdUsers(this.projets.getProIdResponsable(), (Session)null);
         if (var1 != null) {
            this.projets.setProNomResponsable(var1.getUsrPatronyme());
         } else {
            this.projets.setProNomResponsable("");
         }
      } else {
         this.projets.setProNomResponsable("");
      }

      int var14 = 0;
      GregorianCalendar var4;
      if (this.projets.getProDateDebut() != null && this.projets.getProDateFin() != null) {
         SimpleDateFormat var2 = new SimpleDateFormat("dd-MM-yyyy");
         Date var3 = var2.parse(this.utilDate.dateToStringFr(this.projets.getProDateDebut()));
         var4 = new GregorianCalendar();
         var4.setTime(var3);
         Date var5 = var2.parse(this.utilDate.dateToStringFr(this.projets.getProDateFin()));
         GregorianCalendar var6 = new GregorianCalendar();
         var6.setTime(var5);
         var4.add(2, 1);

         while(var4.compareTo(var6) <= 0) {
            ++var14;
            var4.add(2, 1);
         }
      }

      this.projets.setProDuree(var14 + 1);
      if (this.projets.getProDateDebut() != null) {
         this.projets.setProAnnee("" + (this.projets.getProDateDebut().getYear() + 1900));
      } else {
         this.projets.setProAnnee("");
      }

      if (this.var_inactif) {
         this.projets.setProInactif(1);
      } else {
         this.projets.setProInactif(0);
      }

      if (this.lesTranches.size() != 0) {
         boolean var15 = true;
         String var17 = "";
         String var18 = "";
         String var20 = "";
         String var23 = "";

         for(int var7 = 0; var7 < this.lesTranches.size(); ++var7) {
            new LibDate();
            LibDate var8 = (LibDate)this.lesTranches.get(var7);
            if (var15) {
               var15 = false;
               if (var8.getDateDeb() != null) {
                  var17 = this.utilDate.dateToStringSQLLight(var8.getDateDeb());
                  var18 = this.utilDate.dateToStringSQLLight(var8.getDateFin());
               } else {
                  var17 = null;
                  var18 = null;
               }

               var20 = "" + var8.getMontant();
               if (var8.getLibelle() != null && !var8.getLibelle().isEmpty()) {
                  var23 = var8.getLibelle();
               } else {
                  var23 = " ";
               }
            } else {
               if (var8.getDateDeb() != null) {
                  var17 = var17 + ":" + this.utilDate.dateToStringSQLLight(var8.getDateDeb());
                  var18 = var18 + ":" + this.utilDate.dateToStringSQLLight(var8.getDateFin());
               } else {
                  var17 = var17 + ":" + null;
                  var18 = var18 + ":" + null;
               }

               var20 = var20 + ":" + var8.getMontant();
               if (var8.getLibelle() != null && !var8.getLibelle().isEmpty()) {
                  var23 = var23 + ":" + var8.getLibelle();
               } else {
                  var23 = var23 + ":" + " ";
               }
            }
         }

         this.projets.setProDateEcheanceDeb(var17);
         this.projets.setProDateEcheanceFin(var18);
         this.projets.setProMontantEcheance(var20);
         this.projets.setProObsEcheance(var23);
      } else {
         this.projets.setProDateEcheanceDeb("");
         this.projets.setProDateEcheanceFin("");
         this.projets.setProMontantEcheance("");
         this.projets.setProObsEcheance("");
      }

      String var16 = "";
      if (this.lesUsersHabilites.size() != 0) {
         boolean var19 = true;

         for(int var22 = 0; var22 < this.lesUsersHabilites.size(); ++var22) {
            new Users();
            Users var24 = (Users)this.lesUsersHabilites.get(var22);
            if (var19) {
               var19 = false;
               if (var24.isSelectUser()) {
                  var16 = "" + var24.getUsrid();
               }
            } else if (var24.isSelectUser()) {
               var16 = var16 + ":" + var24.getUsrid();
            }
         }
      }

      this.projets.setProIdUsers(var16);
      if (this.projets.getProId() == 0L) {
         this.projets.setProUserCreat(this.usersLog.getUsrid());
         this.projets.setProDateCreat(new Date());
         this.projets = this.projetsDao.insert(this.projets);
         this.projetsList.add(this.projets);
         this.datamodelProjets.setWrappedData(this.projetsList);
      } else {
         this.projets.setProUserModif(this.usersLog.getUsrid());
         this.projets.setProDateModif(new Date());
         this.projets = this.projetsDao.miseAjourProjet(this.projets);
         this.lesContrats = this.salariesContratsDao.chargerlesContrats((String)this.projets.getProCode(), (Session)null);
         if (this.lesContrats.size() != 0) {
            Session var21 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
            var4 = null;

            try {
               Transaction var26 = var21.beginTransaction();
               new SalariesContrats();

               for(int var27 = 0; var27 < this.lesContrats.size(); ++var27) {
                  SalariesContrats var25 = (SalariesContrats)this.lesContrats.get(var27);
                  var25.setSalconDateDebut(this.projets.getProDateDebut());
                  var25.setSalconDateFin(this.projets.getProDateFin());
                  this.salariesContratsDao.modif(var25, var21);
               }

               var26.commit();
            } catch (HibernateException var12) {
               if (var4 != null) {
                  var4.rollback();
               }

               throw var12;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }
      }

      this.showmodelPanel = false;
      this.var_affiche_bouton = false;
   }

   public void verifielesSaisieCodeAct() throws HibernateException, NamingException {
      this.existeCode = this.projetsDao.existCode(0, this.getProjets().getProCode());
      if (!this.getProjets().getProCode().equals("") && !this.getProjets().getProNomFR().equals("")) {
         this.codelibVide = true;
      } else {
         this.codelibVide = false;
      }

   }

   public void verifielesSaisieLibelleAct() {
      if (this.getProjets().getProNomFR().equals("")) {
         this.codelibVide = false;
      } else {
         this.codelibVide = true;
      }

   }

   public void selectionPoste() {
      if (this.dataModelTresorerie.isRowAvailable()) {
         this.plansTresorerie = (PlansTresorerie)this.dataModelTresorerie.getRowData();
         this.ancienCode = this.plansTresorerie.getTreCode();
      }

   }

   public void changerCode() {
      if (this.plansTresorerie != null) {
         this.nouveauCode = "";
         this.showModalPanelChangeCode = true;
      }

   }

   public void fermerChangerCode() {
      this.showModalPanelChangeCode = false;
   }

   public void validerChangerCode() throws HibernateException, NamingException {
      if (this.nouveauCode != null && !this.nouveauCode.isEmpty()) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Budget");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.lesTreso.size() != 0) {
               for(int var3 = 0; var3 < this.lesTreso.size(); ++var3) {
                  this.plansTresorerie = (PlansTresorerie)this.lesTreso.get(var3);
                  if (this.plansTresorerie.getTreCode() != null && !this.plansTresorerie.getTreCode().isEmpty() && this.plansTresorerie.getTreCode().equals(this.ancienCode)) {
                     this.plansTresorerie.setTreCode(this.nouveauCode);
                     this.plansTresorerie = this.plansTresorerieDao.modif(this.plansTresorerie, var1);
                     break;
                  }
               }
            }

            if (this.lesPostes.size() != 0) {
               new BudgetTresorerie();

               for(int var4 = 0; var4 < this.lesPostes.size(); ++var4) {
                  BudgetTresorerie var12 = (BudgetTresorerie)this.lesPostes.get(var4);
                  if (var12.getBudCode() != null && !var12.getBudCode().isEmpty() && var12.getBudCode().equals(this.ancienCode)) {
                     var12.setBudCode(this.nouveauCode);
                     this.budgetTresorerieDao.modif(var12, var1);
                     break;
                  }
               }
            }

            new ArrayList();
            EcrituresDao var14 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
            List var13 = var14.chargerEcrituresBudget(this.projets.getProCode(), var1);
            if (var13.size() != 0) {
               new Ecritures();

               for(int var6 = 0; var6 < var13.size(); ++var6) {
                  Ecritures var5 = (Ecritures)var13.get(var6);
                  if (var5.getEcrPosteTreso() != null && !var5.getEcrPosteTreso().isEmpty() && var5.getEcrPosteTreso().equals(this.ancienCode)) {
                     var5.setEcrPosteTreso(this.nouveauCode);
                     var14.modif(var5, var1);
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
      }

      this.showModalPanelChangeCode = false;
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

   public List getProjetsList() {
      return this.projetsList;
   }

   public void setProjetsList(List var1) {
      this.projetsList = var1;
   }

   public Projets getProjets() {
      return this.projets;
   }

   public void setProjets(Projets var1) {
      this.projets = var1;
   }

   public boolean isVar_affiche_bouton() {
      return this.var_affiche_bouton;
   }

   public void setVar_affiche_bouton(boolean var1) {
      this.var_affiche_bouton = var1;
   }

   public DataModel getDatamodelProjets() {
      return this.datamodelProjets;
   }

   public void setDatamodelProjets(DataModel var1) {
      this.datamodelProjets = var1;
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

   public List getMesResponsable() {
      return this.mesResponsable;
   }

   public void setMesResponsable(List var1) {
      this.mesResponsable = var1;
   }

   public DataModel getDataModelTranches() {
      return this.dataModelTranches;
   }

   public void setDataModelTranches(DataModel var1) {
      this.dataModelTranches = var1;
   }

   public double getEcart() {
      return this.ecart;
   }

   public void setEcart(double var1) {
      this.ecart = var1;
   }

   public double getTotal_echeance() {
      return this.total_echeance;
   }

   public void setTotal_echeance(double var1) {
      this.total_echeance = var1;
   }

   public DataModel getDataModelPostes() {
      return this.dataModelPostes;
   }

   public void setDataModelPostes(DataModel var1) {
      this.dataModelPostes = var1;
   }

   public DataModel getDataModelUsersHabilites() {
      return this.dataModelUsersHabilites;
   }

   public void setDataModelUsersHabilites(DataModel var1) {
      this.dataModelUsersHabilites = var1;
   }

   public DataModel getDataModelTresorerie() {
      return this.dataModelTresorerie;
   }

   public void setDataModelTresorerie(DataModel var1) {
      this.dataModelTresorerie = var1;
   }

   public DataModel getDataModelJrx() {
      return this.dataModelJrx;
   }

   public void setDataModelJrx(DataModel var1) {
      this.dataModelJrx = var1;
   }

   public DataModel getDataModelContrat() {
      return this.dataModelContrat;
   }

   public void setDataModelContrat(DataModel var1) {
      this.dataModelContrat = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public boolean isShowModalPanelChangeCode() {
      return this.showModalPanelChangeCode;
   }

   public void setShowModalPanelChangeCode(boolean var1) {
      this.showModalPanelChangeCode = var1;
   }

   public String getNouveauCode() {
      return this.nouveauCode;
   }

   public void setNouveauCode(String var1) {
      this.nouveauCode = var1;
   }

   public String getAncienCode() {
      return this.ancienCode;
   }

   public void setAncienCode(String var1) {
      this.ancienCode = var1;
   }
}
