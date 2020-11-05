package com.epegase.systeme.dao;

import com.epegase.systeme.classe.CvSession;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CvAnalyseDao implements Serializable {
   private CvSession cvSession;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public CvAnalyseDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public CvSession insert(CvSession var1) throws HibernateException, NamingException {
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

   public CvSession insert(CvSession var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public CvSession modif(CvSession var1) throws HibernateException, NamingException {
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

   public CvSession modif(CvSession var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(CvSession var1) throws HibernateException, NamingException {
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

   public void delete(CvSession var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List chargerlesAnalyseCv(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "AnalyseCv");
         var4 = true;
      }

      new ArrayList();
      Query var6 = null;
      if (var1 != null && var2 != null) {
         var6 = var3.createQuery("from CvSession where cvsDateDebut>=:d1 and cvsDateDebut<=:d2 order by cvsDateDebut asc").setDate("d1", var1).setDate("d2", var2);
      } else {
         var6 = var3.createQuery("from CvSession order by cvsDateDebut asc");
      }

      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public CvSession pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "AnalyseCv");
         var4 = true;
      }

      Query var5 = var3.createQuery("from CvSession where cvsId =:num").setLong("num", var1).setMaxResults(1);
      List var6 = var5.list();
      CvSession var7 = null;
      if (var6.size() != 0) {
         var7 = (CvSession)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }
}
