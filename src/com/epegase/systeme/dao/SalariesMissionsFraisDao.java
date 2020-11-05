package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Missions;
import com.epegase.systeme.classe.SalariesMissionsFrais;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SalariesMissionsFraisDao implements Serializable {
   private SalariesMissionsFrais salariesMissionsFrais;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public SalariesMissionsFraisDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public SalariesMissionsFrais insert(SalariesMissionsFrais var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "SuiviRH");
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

   public SalariesMissionsFrais insert(SalariesMissionsFrais var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public SalariesMissionsFrais modif(SalariesMissionsFrais var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "SuiviRH");
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

   public SalariesMissionsFrais modif(SalariesMissionsFrais var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(SalariesMissionsFrais var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "SuiviRH");
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

   public void delete(SalariesMissionsFrais var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List chargeSalariesMissionsFrais(Missions var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "SuiviRH");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery(" from SalariesMissionsFrais where Missions=:mis").setParameter("mis", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }
}
