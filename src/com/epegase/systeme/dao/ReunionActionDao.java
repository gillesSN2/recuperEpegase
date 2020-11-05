package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ReunionAction;
import com.epegase.systeme.classe.ReunionEntete;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ReunionActionDao implements Serializable {
   private ReunionAction reunionAction;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ReunionActionDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public ReunionAction insert(ReunionAction var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ReunionEntete");
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

   public ReunionAction insert(ReunionAction var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public ReunionAction modif(ReunionAction var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ReunionEntete");
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

   public ReunionAction modif(ReunionAction var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(ReunionAction var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ReunionEntete");
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

   public void deleteListe(List var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ReunionEntete");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();

         for(int var4 = 0; var4 < var1.size(); ++var4) {
            new ReunionAction();
            ReunionAction var5 = (ReunionAction)var1.get(var4);
            var2.delete(var5);
         }

         var3.commit();
      } catch (HibernateException var9) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var9;
      } finally {
         this.utilInitHibernate.closeSession();
      }
   }

   public void delete(ReunionAction var1, Session var2) {
      var2.delete(var1);
   }

   public List selectReunionActionNew(ReunionEntete var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ReunionEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from ReunionAction where reunionEntete=:id").setParameter("id", var1).list();
      new ArrayList();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List selectReunionActionOld(ReunionEntete var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ReunionEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from ReunionAction where reunionEntete.reuDate<=:dte and reunionEntete.reuService=:serv and reunionEntete.reuType=:typ and reunionEntete.reuNum!=:num and reunionEntete.reuActivite=:act and ((reuactEtat=0 or reuactEtat=4) or reuactNumExecution=:num)").setDate("dte", var1.getReuDate()).setString("serv", var1.getReuService()).setInteger("typ", var1.getReuType()).setString("act", var1.getReuActivite()).setString("num", var1.getReuNum()).list();
      new ArrayList();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }
}
