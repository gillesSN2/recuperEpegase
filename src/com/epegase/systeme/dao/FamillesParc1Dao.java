package com.epegase.systeme.dao;

import com.epegase.systeme.classe.FamillesParc1;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FamillesParc1Dao implements Serializable {
   private FamillesParc1 famillesParc1;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public FamillesParc1Dao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public FamillesParc1 insert(FamillesParc1 var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "FamilleParc");
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

   public FamillesParc1 modif(FamillesParc1 var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "FamilleParc");
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

   public void delete(FamillesParc1 var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "FamilleParc");
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

   public List selectFamille(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "FamilleParc");
         var3 = true;
      }

      List var4 = var2.createQuery("from FamillesParc1 where famprc1Nature=:nat order by famprc1Code asc").setString("nat", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List selectFamille(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "FamilleParc");
         var2 = true;
      }

      List var3 = var1.createQuery("from FamillesParc1 order by famprc1Code asc").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerLesFamilles(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "FamilleParc");
         var2 = true;
      }

      List var3 = var1.createQuery("from FamillesParc1 where famprc1Inactif=0 order by famprc1Code asc").list();
      List var4 = var3;
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var5.add(new SelectItem(((FamillesParc1)var4.get(var6)).getFamprc1Code() + ":" + ((FamillesParc1)var4.get(var6)).getFamprc1LibelleFr()));
         }
      }

      return var5;
   }

   public List chargerLesFamilles(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "FamilleParc");
         var3 = true;
      }

      List var4 = var2.createQuery("from FamillesParc1 where famprc1Nature=:nat and famprc1Inactif=0 order by famprc1Code asc").setString("nat", var1).list();
      List var5 = var4;
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var6 = new ArrayList();
      if (var4.size() != 0) {
         for(int var7 = 0; var7 < var5.size(); ++var7) {
            var6.add(new SelectItem(((FamillesParc1)var5.get(var7)).getFamprc1Code() + ":" + ((FamillesParc1)var5.get(var7)).getFamprc1LibelleFr()));
         }
      }

      return var6;
   }

   public FamillesParc1 rechercheFamille(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "FamilleParc");
         var3 = true;
      }

      Query var4 = var2.createQuery("from FamillesParc1 where famprc1Code=:cod").setString("cod", var1);
      var4.setMaxResults(1);
      List var5 = var4.list();
      new FamillesParc1();
      FamillesParc1 var6;
      if (var5.size() > 0) {
         var6 = (FamillesParc1)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public boolean existCode(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "FamilleParc");
         var3 = true;
      }

      boolean var4 = false;
      Query var5 = var2.createQuery("from FamillesParc1 where famprc1Code=:cod").setString("cod", var1);
      var5.setMaxResults(1);
      List var6 = var5.list();
      if (var6.size() > 0) {
         var4 = true;
      } else {
         var4 = false;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }
}
