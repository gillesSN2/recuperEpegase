package com.epegase.systeme.dao;

import com.epegase.systeme.classe.FeuilleCalcul;
import com.epegase.systeme.classe.FeuilleCalculRubrique;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FeuilleCalculRubriqueDao implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String mabase;

   public FeuilleCalculRubriqueDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public FeuilleCalculRubrique insert(FeuilleCalculRubrique var1) throws HibernateException, NamingException {
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

   public FeuilleCalculRubrique insert(FeuilleCalculRubrique var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public FeuilleCalculRubrique modif(FeuilleCalculRubrique var1) throws HibernateException, NamingException {
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

   public FeuilleCalculRubrique modif(FeuilleCalculRubrique var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(FeuilleCalculRubrique var1) throws HibernateException, NamingException {
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

   public void delete(FeuilleCalculRubrique var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List chargerRubriqueFeuille(FeuilleCalcul var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanPaye");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery(" from FeuilleCalculRubrique where feuilleCalcul=:feu order by feurubCode asc").setParameter("feu", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerRubriqueFeuilleActive(FeuilleCalcul var1, long var2, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanPaye");
         var5 = true;
      }

      new ArrayList();
      Query var7 = null;
      if (var2 != 0L) {
         var7 = var4.createQuery(" from FeuilleCalculRubrique where feuilleCalcul=:feu and planPaye.plpInactif=0 and feurubActif=true and feuilleCalcul.exercicesPaye.exepayId=:idexo order by feurubCode asc").setParameter("feu", var1).setLong("idexo", var2);
      } else {
         var7 = var4.createQuery(" from FeuilleCalculRubrique where feuilleCalcul=:feu and planPaye.plpInactif=0 and feurubActif=true order by feurubCode asc").setParameter("feu", var1);
      }

      List var6 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerRubriqueFeuilleActive(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanPaye");
         var4 = true;
      }

      new ArrayList();
      Query var6 = null;
      if (var1 != 0L) {
         var6 = var3.createQuery(" from FeuilleCalculRubrique where planPaye.plpInactif=0 and feurubActif=true and feuilleCalcul.exercicesPaye.exepayId=:idexo order by feurubCode asc").setLong("idexo", var1);
      } else {
         var6 = var3.createQuery(" from FeuilleCalculRubrique where planPaye.plpInactif=0 and feurubActif=true order by feurubCode asc");
      }

      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerRubriqueFeuilleActiveConfig(FeuilleCalcul var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanPaye");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery(" from FeuilleCalculRubrique where feuilleCalcul=:feu and planPaye.plpInactif=0 order by feurubCode asc").setParameter("feu", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerRubriqueFeuilleActive(String var1, long var2, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanPaye");
         var5 = true;
      }

      new ArrayList();
      Query var7 = null;
      if (var2 != 0L) {
         var7 = var4.createQuery(" from FeuilleCalculRubrique where feuilleCalcul.feuCode=:feu and planPaye.plpInactif=0 and feurubActif=true and feuilleCalcul.exercicesPaye.exepayId=:idexo order by feurubCode asc").setString("feu", var1).setLong("idexo", var2);
      } else {
         var7 = var4.createQuery(" from FeuilleCalculRubrique where feuilleCalcul.feuCode=:feu and planPaye.plpInactif=0 and feurubActif=true order by feurubCode asc").setString("feu", var1);
      }

      List var6 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public FeuilleCalculRubrique chargerRubriqueFeuille(FeuilleCalcul var1, String var2, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanPaye");
         var5 = true;
      }

      new FeuilleCalculRubrique();
      new ArrayList();
      Query var8 = var4.createQuery(" from FeuilleCalculRubrique where feuilleCalcul=:feu and feurubCode=:rub and feurubActif=:act order by feurub_id").setParameter("feu", var1).setString("rub", var2).setInteger("act", var3).setMaxResults(1);
      List var7 = var8.list();
      FeuilleCalculRubrique var6;
      if (var7.size() != 0) {
         var6 = (FeuilleCalculRubrique)var7.get(0);
      } else {
         var6 = null;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public FeuilleCalculRubrique chargerRubriqueFeuille(String var1, String var2, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanPaye");
         var5 = true;
      }

      String var6 = "";
      if (var1.contains("=")) {
         String[] var7 = var1.split("=");
         var6 = var7[0];
      } else {
         var6 = var1;
      }

      new FeuilleCalculRubrique();
      new ArrayList();
      Query var9 = var4.createQuery(" from FeuilleCalculRubrique where feuilleCalcul.feuCode=:feu and feurubCode=:rub and feurubActif=:act").setString("feu", var6).setString("rub", var2).setInteger("act", var3).setMaxResults(1);
      List var8 = var9.list();
      FeuilleCalculRubrique var10;
      if (var8.size() != 0) {
         var10 = (FeuilleCalculRubrique)var8.get(0);
      } else {
         var10 = null;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public FeuilleCalculRubrique chargerRubriqueFeuille(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanPaye");
         var4 = true;
      }

      new FeuilleCalculRubrique();
      new ArrayList();
      Query var7 = var3.createQuery(" from FeuilleCalculRubrique where feurub_id=:feu").setLong("feu", var1).setMaxResults(1);
      List var6 = var7.list();
      FeuilleCalculRubrique var5;
      if (var6.size() != 0) {
         var5 = (FeuilleCalculRubrique)var6.get(0);
      } else {
         var5 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public FeuilleCalculRubrique chargerRubriqueFeuille(String var1, FeuilleCalcul var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanPaye");
         var4 = true;
      }

      new FeuilleCalculRubrique();
      new ArrayList();
      Query var7 = var3.createQuery(" from FeuilleCalculRubrique where feurub_code=:cod and feuilleCalcul=:feu").setString("cod", var1).setParameter("feu", var2).setMaxResults(1);
      List var6 = var7.list();
      FeuilleCalculRubrique var5;
      if (var6.size() != 0) {
         var5 = (FeuilleCalculRubrique)var6.get(0);
      } else {
         var5 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerRubriqueToutesFeuilles(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanPaye");
         var2 = true;
      }

      new ArrayList();
      Query var4 = var1.createQuery(" from FeuilleCalculRubrique where planPaye.plpInactif=0 and feurubActif=true order by feurubCode asc");
      List var3 = var4.list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerRubriqueUtiliseesToutesFeuilles(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanPaye");
         var2 = true;
      }

      new ArrayList();
      Query var4 = var1.createQuery(" from FeuilleCalculRubrique where planPaye.plpInactif=0 and feurubActif=true and (feurubColA=:act or feurubColB=:act or feurubColC=:act or feurubColD=:act or feurubColE=:act) order by feurubCode asc").setBoolean("act", true);
      List var3 = var4.list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerRubriqueFeuille(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanPaye");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery(" from FeuilleCalculRubrique where feurubCode=:rub group by feuilleCalcul.feuCode").setString("rub", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }
}
