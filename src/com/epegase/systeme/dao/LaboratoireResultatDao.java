package com.epegase.systeme.dao;

import com.epegase.systeme.classe.LaboratoireLigne;
import com.epegase.systeme.classe.LaboratoireResultat;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LaboratoireResultatDao implements Serializable {
   private LaboratoireResultat laboratoireResultat;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public LaboratoireResultatDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public LaboratoireResultat insert(LaboratoireResultat var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "LaboratoireEntete");
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

   public LaboratoireResultat insert(LaboratoireResultat var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public LaboratoireResultat modif(LaboratoireResultat var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "LaboratoireEntete");
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

   public LaboratoireResultat modif(LaboratoireResultat var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(LaboratoireResultat var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "LaboratoireEntete");
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

   public void delete(LaboratoireResultat var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public void deleteAllLigne(String var1, Session var2) {
      var2.createQuery("delete from LaboratoireResultat where labresNum=:nul").setString("nul", var1).executeUpdate();
   }

   public List selectResultatListe(LaboratoireLigne var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "LaboratoireEntete");
         var3 = true;
      }

      new ArrayList();
      List var4 = var2.createQuery("From LaboratoireResultat where laboratoireLigne=:param").setParameter("param", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List selectResultatListe(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "LaboratoireEntete");
         var3 = true;
      }

      new ArrayList();
      List var4 = var2.createQuery("From LaboratoireResultat where labresIdLab in (" + var1 + ")").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public LaboratoireResultat selectResultat(LaboratoireLigne var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "LaboratoireEntete");
         var3 = true;
      }

      new ArrayList();
      List var4 = var2.createQuery("From LaboratoireResultat where laboratoireLigne=:param").setParameter("param", var1).setMaxResults(1).list();
      this.laboratoireResultat = new LaboratoireResultat();
      if (var4.size() != 0) {
         this.laboratoireResultat = (LaboratoireResultat)var4.get(0);
      } else {
         this.laboratoireResultat = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return this.laboratoireResultat;
   }

   public List selectHistorique(long var1, long var3, String var5, Session var6) throws HibernateException, NamingException {
      boolean var7 = false;
      if (var6 == null) {
         var6 = this.utilInitHibernate.getOpenSession(this.mabase, "LaboratoireEntete");
         var7 = true;
      }

      new ArrayList();
      List var8;
      if (var3 == 0L) {
         var8 = var6.createQuery("From LaboratoireResultat where labresIdPatient=:patient and labresCode=:prod order by laboratoireLigne.labligDateRealisee desc").setLong("patient", var1).setString("prod", var5).list();
      } else {
         var8 = var6.createQuery("From LaboratoireResultat where labresIdPatient=:patient and labresCode=:prod and labresId<>" + var3 + " order by laboratoireLigne.labligDateRealisee desc").setLong("patient", var1).setString("prod", var5).list();
      }

      if (var7) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }
}
