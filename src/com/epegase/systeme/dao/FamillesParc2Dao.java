package com.epegase.systeme.dao;

import com.epegase.systeme.classe.FamillesParc1;
import com.epegase.systeme.classe.FamillesParc2;
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

public class FamillesParc2Dao implements Serializable {
   private FamillesParc2 famillesParc2;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public FamillesParc2Dao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public FamillesParc2 insert(FamillesParc2 var1) throws HibernateException, NamingException {
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

   public FamillesParc2 modif(FamillesParc2 var1) throws HibernateException, NamingException {
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

   public void delete(FamillesParc2 var1) throws HibernateException, NamingException {
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

   public List selectSousFamille(FamillesParc1 var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "FamilleParc");
         var3 = true;
      }

      List var4 = var2.createQuery("from FamillesParc2 where FamillesParc1=:fam order by famprc2Code asc").setParameter("fam", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesSousFamilles(FamillesParc1 var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "FamilleParc");
         var3 = true;
      }

      List var4 = var2.createQuery("from FamillesParc2 where famprc2Inactif=0 and FamillesParc1=:fam order by famprc2Code asc").setParameter("fam", var1).list();
      List var5 = var4;
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var6 = new ArrayList();
      var6.add(new SelectItem("Aucune sous-famille précisée"));
      if (var4.size() != 0) {
         for(int var7 = 0; var7 < var5.size(); ++var7) {
            var6.add(new SelectItem(((FamillesParc2)var5.get(var7)).getFamprc2Code() + ":" + ((FamillesParc2)var5.get(var7)).getFamprc2LibelleFr()));
         }
      }

      return var6;
   }

   public FamillesParc2 rechercheSousFamille(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "FamilleParc");
         var3 = true;
      }

      Query var4 = var2.createQuery("from FamillesParc2 where famprc2Code=:cod").setString("cod", var1);
      var4.setMaxResults(1);
      List var5 = var4.list();
      new FamillesParc2();
      FamillesParc2 var6;
      if (var5.size() > 0) {
         var6 = (FamillesParc2)var5.get(0);
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
      Query var5 = var2.createQuery("from FamillesParc2 where famprc2Code=:cod").setString("cod", var1);
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
