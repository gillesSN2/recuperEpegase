package com.epegase.systeme.dao;

import com.epegase.systeme.classe.CvAgents;
import com.epegase.systeme.classe.CvSession;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CvAgentsDao implements Serializable {
   private CvAgents cvAgents;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public CvAgentsDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public CvAgents insert(CvAgents var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "AnalyseCv");
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

   public CvAgents insert(CvAgents var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public CvAgents modif(CvAgents var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "AnalyseCv");
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

   public CvAgents modif(CvAgents var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(CvAgents var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "AnalyseCv");
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

   public void delete(CvAgents var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List chargerlesAgentsBySession(CvSession var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "AnalyseCv");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from CvAgents where CvSession=:cvs order by cvaAgent asc").setParameter("cvs", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public CvAgents pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "AnalyseCv");
         var4 = true;
      }

      Query var5 = var3.createQuery("from CvAgents where cvaId =:num").setLong("num", var1).setMaxResults(1);
      List var6 = var5.list();
      CvAgents var7 = null;
      if (var6.size() != 0) {
         var7 = (CvAgents)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }
}
