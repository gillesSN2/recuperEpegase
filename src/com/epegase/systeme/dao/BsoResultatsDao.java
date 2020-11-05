package com.epegase.systeme.dao;

import com.epegase.systeme.classe.BsoResultats;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BsoResultatsDao implements Serializable {
   private BsoResultats bsoResultats;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public BsoResultatsDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public void deleteTabResultat(String var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "BilanSocial");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         var2.createQuery("delete from BsoResultats where tabresCode=:pegtabCod").setString("pegtabCod", var1).executeUpdate();
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

   public void deleteTabResultatAnnee(String var1, long var2) throws HibernateException, NamingException {
      Session var4 = this.utilInitHibernate.getOpenSession(this.maBase, "BilanSocial");
      Transaction var5 = null;

      try {
         var5 = var4.beginTransaction();
         new ArrayList();
         List var6 = this.chargerMesTabResultats(var1, var2, var4);
         if (var6.size() != 0) {
            for(int var7 = 0; var7 < var6.size(); ++var7) {
               new BsoResultats();
               BsoResultats var8 = (BsoResultats)var6.get(var7);
               var4.delete(var8);
            }

            var5.commit();
         }
      } catch (HibernateException var12) {
         if (var5 != null) {
            var5.rollback();
         }

         throw var12;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public BsoResultats saveTabResulats(BsoResultats var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public void saveTabResulats(List var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "BilanSocial");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();

         for(int var4 = 0; var4 < var1.size(); ++var4) {
            new BsoResultats();
            BsoResultats var5 = (BsoResultats)var1.get(var4);
            var2.save(var5);
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

   public void delete(BsoResultats var1, Session var2) {
      var2.delete(var1);
   }

   public List chargerMesTabResultats(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "BilanSocial");
         var4 = true;
      }

      Query var5 = var3.createQuery("from BsoResultats where exercicescomptable=:exercice order by tabresNum").setLong("exercice", var1);
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerMesTabResultats(String var1, long var2, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "BilanSocial");
         var5 = true;
      }

      Query var6 = var4.createQuery("from BsoResultats where tabresCode=:codTab and exercicescomptable=:exercice order by tabresNum").setString("codTab", var1).setLong("exercice", var2);
      List var7 = var6.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public BsoResultats recuperCelTabRefCol(Session var1, long var2, String var4, String var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "BilanSocial");
         var6 = true;
      }

      new BsoResultats();
      Query var8 = var1.createQuery("from BsoResultats where tabresCode=:tableau and  tabresReference=:reference and exercicescomptable=:exercice").setLong("exercice", var2).setString("reference", var4).setString("tableau", var5).setMaxResults(1);
      List var9 = var8.list();
      BsoResultats var7;
      if (var9.size() != 0) {
         var7 = (BsoResultats)var9.get(0);
      } else {
         var7 = null;
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public BsoResultats recuperCelTabRefCol(Session var1, long var2, String var4, String var5, String var6, String var7) throws HibernateException, NamingException {
      boolean var8 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "BilanSocial");
         var8 = true;
      }

      new BsoResultats();
      Query var10 = var1.createQuery("from BsoResultats where tabresCode='" + var5 + "' and tabresReference='" + var4 + "' and tabresDateDeb>='" + var6 + "' and tabresDateDeb<='" + var7 + "'").setMaxResults(1);
      List var11 = var10.list();
      BsoResultats var9;
      if (var11.size() != 0) {
         var9 = (BsoResultats)var11.get(0);
      } else {
         var9 = null;
      }

      if (var8) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }
}
