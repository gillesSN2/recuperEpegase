package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.ExercicesPaye;
import com.epegase.systeme.classe.PlanComptable;
import com.epegase.systeme.classe.PlanPaye;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class PlanPayeDao implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private int sens;
   private int nature;
   private String lib_FR;
   private String lib_UK;
   private String lib_SP;
   private long userCreat;
   private String numero;
   private String inserLibNatFR;
   private String inserLibNatSP;
   private String inserLibNatUK;
   private ExercicesComptableDao exercicesComptableDao;
   private ExercicesComptable exercicesComptable;
   private PlanComptable planComptable;
   private String mabase;

   public PlanPayeDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public void ajoutParDefaut(String var1) throws JDOMException, IOException, HibernateException, NamingException {
      SAXBuilder var2 = new SAXBuilder();

      try {
         Document var3 = var2.build(new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "paye" + File.separator + "planPaye" + File.separator + "PLP_" + var1 + ".xml"));
         Element var4 = var3.getRootElement();
         List var5 = var4.getChildren();
         this.exercicesComptableDao = new ExercicesComptableDao(this.mabase, this.utilInitHibernate);
         this.exercicesComptable = new ExercicesComptable();
         this.exercicesComptable = this.exercicesComptableDao.recupererLastExo((Session)null);
         String var6 = "";
         String var7 = "";
         boolean var8 = false;
         Session var9 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanPaye");
         Transaction var10 = null;

         try {
            var10 = var9.beginTransaction();

            for(int var11 = 0; var11 < var5.size(); ++var11) {
               this.lib_FR = ((Element)var5.get(var11)).getChild("lib_FR").getText();
               this.lib_UK = ((Element)var5.get(var11)).getChild("lib_UK").getText();
               this.lib_SP = ((Element)var5.get(var11)).getChild("lib_SP").getText();
               this.numero = ((Element)var5.get(var11)).getChild("code").getText();
               this.planComptable = new PlanComptable();
               String var12 = ((Element)var5.get(var11)).getChild("nature").getText();
               this.nature = Integer.parseInt(var12);
               var6 = ((Element)var5.get(var11)).getChild("racine").getText();
               var7 = ((Element)var5.get(var11)).getChild("libre").getText();
               String var13 = ((Element)var5.get(var11)).getChild("sens").getText();
               int var23 = Integer.parseInt(var13);
               this.planComptable.setPlcDateCreat(new Date());
               this.planComptable.setPlcNature(this.nature);
               this.planComptable.setPlcSens(var23);
               this.planComptable.setPlcCodeRacine(var6);
               this.planComptable.setPlcLibelleCpteFR(this.lib_FR);
               this.planComptable.setPlcLibelleCpteUK(this.lib_UK);
               this.planComptable.setPlcLibelleCpteSP(this.lib_SP);
               this.planComptable.setPlcLibelleRacineFR(this.lib_FR);
               this.planComptable.setPlcLibelleRacineUK(this.lib_UK);
               this.planComptable.setPlcLibelleRacineSP(this.lib_SP);
               this.planComptable.setPlcLibelleNatureFR(this.inserLibNatFR);
               this.planComptable.setPlcLibelleNatureUK(this.inserLibNatUK);
               this.planComptable.setPlcLibelleNatureSP(this.inserLibNatSP);
               this.planComptable.setPlcCodeRacine(var6);
               this.planComptable.setPlcUserCreat(this.userCreat);
               this.planComptable.setPlcDateCreat(new Date());
               this.planComptable.setExercicesComptable(this.exercicesComptable);
               var9.save(this.planComptable);
            }

            var10.commit();
         } catch (HibernateException var19) {
            if (var10 != null) {
               var10.rollback();
            }

            throw var19;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      } catch (JDOMException var21) {
      } catch (IOException var22) {
      }

   }

   public PlanPaye insert(PlanPaye var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanPaye");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         var2.save(var1);
         var3.commit();
      } catch (HibernateException var8) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var8;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var1;
   }

   public PlanPaye insert(PlanPaye var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public PlanPaye modif(PlanPaye var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanPaye");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         var2.update(var1);
         var3.commit();
      } catch (HibernateException var8) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var8;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var1;
   }

   public PlanPaye modif(PlanPaye var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(PlanPaye var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanPaye");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         var2.delete(var1);
         var3.commit();
      } catch (HibernateException var8) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var8;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void copiertoutLeplanPaye(List var1, ExercicesPaye var2) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanPaye");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();

         for(int var5 = 0; var5 < var1.size(); ++var5) {
            PlanPaye var6 = (PlanPaye)var1.get(var5);
            var6.setExercicesPaye(var2);
            var3.save(var6);
         }

         var4.commit();
      } catch (HibernateException var10) {
         if (var4 != null) {
            var4.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }
   }

   public List chargerPlanPaye(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanPaye");
         var4 = true;
      }

      Object var5 = new ArrayList();
      Query var6 = var3.createQuery(" from PlanPaye where exercicesPaye=:exo group by plpCode order by plpCode").setLong("exo", var1);
      if (var6.list().size() > 0) {
         var5 = var6.list();
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var5;
   }

   public List chargerPlanPayeItems(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanPaye");
         var4 = true;
      }

      ArrayList var5 = new ArrayList();
      new ArrayList();
      Query var7 = var3.createQuery(" from PlanPaye where exercicesPaye=:exo group by plpCode order by plpCode").setLong("exo", var1);
      if (var7.list().size() > 0) {
         List var6 = var7.list();
         if (var6.size() != 0) {
            for(int var8 = 0; var8 < var6.size(); ++var8) {
               var5.add(new SelectItem(((PlanPaye)var6.get(var8)).getPlpCode(), ((PlanPaye)var6.get(var8)).getPlpCode() + ":" + ((PlanPaye)var6.get(var8)).getPlpLibelleFR()));
            }
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerPlanPayeNature(long var1, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanPaye");
         var5 = true;
      }

      Object var6 = new ArrayList();
      Query var7 = null;
      if (var3 == 0) {
         var7 = var4.createQuery(" from PlanPaye where exercicesPaye=:exo group by plpCode order by plpCode").setLong("exo", var1);
      } else {
         var7 = var4.createQuery(" from PlanPaye where plpNature=:nat and exercicesPaye=:exo group by plpCode order by plpCode").setInteger("nat", var3).setLong("exo", var1);
      }

      if (var7 != null) {
         var6 = var7.list();
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var6;
   }

   public List chargerPlanPayeNatureItems(long var1, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanPaye");
         var5 = true;
      }

      new ArrayList();
      ArrayList var7 = new ArrayList();
      Query var8 = null;
      var8 = var4.createQuery(" from PlanPaye where plpNature=:nat and exercicesPaye=:exo group by plpCode order by plpCode").setInteger("nat", var3).setLong("exo", var1);
      if (var8 != null) {
         List var6 = var8.list();
         if (var6.size() > 0) {
            for(int var9 = 0; var9 < var6.size(); ++var9) {
               var7.add(new SelectItem(((PlanPaye)var6.get(var9)).getPlpCode(), ((PlanPaye)var6.get(var9)).getPlpCode() + ":" + ((PlanPaye)var6.get(var9)).getPlpLibelleFR()));
            }
         }
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public boolean existeCode(String var1, long var2, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanPaye");
         var5 = true;
      }

      boolean var6 = false;
      Query var7 = var4.createQuery("from PlanPaye where plpCode=:cpt and exercicesPaye=:exo").setString("cpt", var1).setLong("exo", var2).setMaxResults(1);
      new ArrayList();
      List var8 = var7.list();
      if (var8.size() > 0) {
         var6 = true;
      } else {
         var6 = false;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public PlanPaye chercherCode(String var1, long var2, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanPaye");
         var5 = true;
      }

      new PlanPaye();
      Query var7 = null;
      if (var2 != 0L) {
         var7 = var4.createQuery("from PlanPaye where plpCode=:cpt and exercicesPaye=:exo").setString("cpt", var1).setLong("exo", var2).setMaxResults(1);
      } else {
         var7 = var4.createQuery("from PlanPaye where plpCode=:cpt").setString("cpt", var1).setMaxResults(1);
      }

      new ArrayList();
      List var8 = var7.list();
      PlanPaye var6;
      if (var8.size() > 0) {
         var6 = (PlanPaye)var8.get(0);
      } else {
         var6 = null;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public PlanPaye chercherCode(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanPaye");
         var4 = true;
      }

      new PlanPaye();
      Query var6 = var3.createQuery("from PlanPaye where plpId=:id").setLong("id", var1).setMaxResults(1);
      new ArrayList();
      List var7 = var6.list();
      PlanPaye var5;
      if (var7.size() > 0) {
         var5 = (PlanPaye)var7.get(0);
      } else {
         var5 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
