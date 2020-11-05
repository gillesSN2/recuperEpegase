package com.epegase.systeme.dao;

import com.epegase.systeme.classe.PlanningAvicultureAchats;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PlanningAvicultureAchatsDao implements Serializable {
   private PlanningAvicultureAchats PlanningAvicultureAchats;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public PlanningAvicultureAchatsDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public PlanningAvicultureAchats insert(PlanningAvicultureAchats var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "PlanningAvicultureAchats");
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

   public PlanningAvicultureAchats insert(PlanningAvicultureAchats var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public PlanningAvicultureAchats modif(PlanningAvicultureAchats var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "PlanningAvicultureAchats");
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

   public PlanningAvicultureAchats modif(PlanningAvicultureAchats var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(PlanningAvicultureAchats var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "PlanningAvicultureAchats");
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

   public void delete(PlanningAvicultureAchats var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List chargerPlanningEntete(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "PlanningAvicultureAchats");
         var2 = true;
      }

      List var3 = var1.createQuery("from PlanningAvicultureAchats group by ppaCode order by ppaCode asc").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerFraisEnteteItem(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "PlanningAvicultureAchats");
         var2 = true;
      }

      List var3 = var1.createQuery("from PlanningAvicultureAchats group by ppaCode order by ppaCode asc").list();
      ArrayList var4 = new ArrayList();
      if (var3 != null) {
         for(int var5 = 0; var5 < var3.size(); ++var5) {
            new PlanningAvicultureAchats();
            PlanningAvicultureAchats var6 = (PlanningAvicultureAchats)var3.get(var5);
            var4.add(new SelectItem(var6.getPpaCode() + ":" + var6.getPpaFeuille()));
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerPlanningLignes(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "PlanningAvicultureAchats");
         var3 = true;
      }

      List var4 = var2.createQuery("from PlanningAvicultureAchats where ppaFeuille=:fel order by ppaOrdre").setString("fel", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerPlanningLignesCode(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "PlanningAvicultureAchats");
         var3 = true;
      }

      List var4 = var2.createQuery("from PlanningAvicultureAchats where ppaCode=:fel order by ppaOrdre").setString("fel", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }
}
