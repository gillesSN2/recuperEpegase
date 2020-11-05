package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Baremes;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BaremesDao implements Serializable {
   private Baremes baremes;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public BaremesDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public Baremes insert(Baremes var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Baremes");
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

   public Baremes insert(Baremes var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public Baremes modif(Baremes var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Baremes");
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

   public Baremes modif(Baremes var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(Baremes var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Baremes");
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

   public void delete(Baremes var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List listBaremesByTiers(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Baremes");
         var4 = true;
      }

      List var5 = var3.createQuery("from Baremes where barIdTiers=:tie").setLong("tie", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List listBaremesByMedecins(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Baremes");
         var4 = true;
      }

      List var5 = var3.createQuery("from Baremes where barIdMedecin=:tie").setLong("tie", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List listBaremesByCategorie(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Baremes");
         var3 = true;
      }

      Object var4 = null;
      if (var1 != null && !var1.isEmpty()) {
         var4 = var2.createQuery("from Baremes where barCategorieTiers=:cat").setString("cat", var1).list();
      } else {
         var4 = new ArrayList();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var4;
   }

   public List listBaremesByProduits(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Baremes");
         var3 = true;
      }

      List var4 = var2.createQuery("from Baremes where barCodeProduit=:prd").setString("prd", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List listBaremesByProduitsTiers(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Baremes");
         var3 = true;
      }

      List var4 = null;
      if (var1 != null && !var1.isEmpty()) {
         var4 = var2.createQuery("from Baremes where barCodeProduit=:prd and barIdTiers <> 0").setString("prd", var1).list();
      } else {
         var4 = var2.createQuery("from Baremes where barCodeProduit is not null and barCodeProduit<>'' and barIdTiers <> 0").list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List listBaremesByProduitsPromo(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Baremes");
         var3 = true;
      }

      List var4 = null;
      if (var1 != null && !var1.isEmpty()) {
         var4 = var2.createQuery("from Baremes where barCodeProduit=:prd and barIdTiers = 0").setString("prd", var1).list();
      } else {
         var4 = var2.createQuery("from Baremes where barCodeProduit is not null and barCodeProduit<>'' and barIdTiers = 0").list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List selectBaremes(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Baremes");
         var2 = true;
      }

      List var3 = var1.createQuery("from Baremes order by barCode asc").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public Baremes rechercheBareme(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Baremes");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Baremes where barCode=:cod").setString("cod", var1).setMaxResults(1);
      List var5 = var4.list();
      new Baremes();
      Baremes var6;
      if (var5.size() > 0) {
         var6 = (Baremes)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public Baremes rechercheBareme(long var1, String var3, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "Baremes");
         var6 = true;
      }

      new Baremes();
      Baremes var7;
      if (var1 != 0L || var3 != null && !var3.isEmpty() || var4 != null && !var4.isEmpty()) {
         Query var8 = null;
         String var9 = "";
         if (var1 != 0L) {
            var9 = "barIdTiers = " + var1;
         }

         if (var4 != null && !var4.isEmpty() && var3 != null && !var3.isEmpty()) {
            if (var9 != null && !var9.isEmpty()) {
               var9 = var9 + " and (barCodeVte = '" + var3 + "' or barCodeProduit = '" + var4 + "')";
            } else {
               var9 = "(barCodeVte = '" + var3 + "' or barCodeProduit = '" + var4 + "')";
            }
         }

         var8 = var5.createQuery("from Baremes where " + var9).setMaxResults(1);
         List var10 = var8.list();
         if (var10.size() > 0) {
            var7 = (Baremes)var10.get(0);
         } else {
            var7 = null;
         }
      } else {
         var7 = null;
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public Baremes rechercheBaremeFamille(long var1, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Baremes");
         var5 = true;
      }

      new Baremes();
      Baremes var6;
      if (var1 != 0L || var3 != null && !var3.isEmpty()) {
         Query var7 = null;
         String var8 = "";
         if (var1 != 0L) {
            var8 = "barIdTiers = " + var1;
         }

         if (var3 != null && !var3.isEmpty()) {
            if (var8 != null && !var8.isEmpty()) {
               var8 = var8 + " and (barCodeVte = '" + var3 + "')";
            } else {
               var8 = "(barCodeVte = '" + var3 + "')";
            }
         }

         var7 = var4.createQuery("from Baremes where " + var8).setMaxResults(1);
         List var9 = var7.list();
         if (var9.size() > 0) {
            var6 = (Baremes)var9.get(0);
         } else {
            var6 = null;
         }
      } else {
         var6 = null;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheToutBaremeProduit(long var1, String var3, String var4, String var5, Session var6) throws HibernateException, NamingException {
      boolean var7 = false;
      if (var6 == null) {
         var6 = this.utilInitHibernate.getOpenSession(this.maBase, "Baremes");
         var7 = true;
      }

      Object var8 = new ArrayList();
      if (var1 != 0L || var3 != null && !var3.isEmpty()) {
         Query var9 = null;
         String var10 = "";
         String var11 = "";
         if (var5 != null && !var5.isEmpty()) {
            var10 = "(barIdTiers = " + var1 + " or (barCategorieTiers = '" + var5 + "') or barType=2)";
            var11 = "barIdTiers,barCategorieTiers,barCodeProduit,barCodeVte";
         } else {
            var10 = "((barIdTiers = " + var1 + ") or barType=2)";
            var11 = "barIdTiers,barCodeProduit,barCodeVte";
         }

         var10 = var10 + " and ((barCodeProduit = '" + var3 + "')" + " or (barCodeVte = '" + var4 + "'))";
         var9 = var6.createQuery("from Baremes where " + var10 + " order by " + var11);
         var8 = var9.list();
      }

      if (var7) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var8;
   }

   public Baremes rechercheBaremeProduit(long var1, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Baremes");
         var5 = true;
      }

      new Baremes();
      Baremes var6;
      if (var1 != 0L || var3 != null && !var3.isEmpty()) {
         Query var7 = null;
         String var8 = "";
         if (var1 != 0L) {
            var8 = "barIdTiers = " + var1;
         }

         if (var3 != null && !var3.isEmpty()) {
            if (var8 != null && !var8.isEmpty()) {
               var8 = var8 + " and (barCodeProduit = '" + var3 + "')";
            } else {
               var8 = "(barCodeProduit = '" + var3 + "')";
            }
         }

         var7 = var4.createQuery("from Baremes where " + var8).setMaxResults(1);
         List var9 = var7.list();
         if (var9.size() > 0) {
            var6 = (Baremes)var9.get(0);
         } else {
            var6 = null;
         }
      } else {
         var6 = null;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public Baremes rechercheBaremeFamille(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Baremes");
         var4 = true;
      }

      new Baremes();
      Baremes var5;
      if (var1 != null && !var1.isEmpty()) {
         Query var6 = null;
         String var7 = "barCategorieTiers = '" + var1 + "'";
         if (var2 != null && !var2.isEmpty()) {
            var7 = var7 + " and (barCodeVte = '" + var2 + "')";
         }

         var6 = var3.createQuery("from Baremes where " + var7).setMaxResults(1);
         List var8 = var6.list();
         if (var8.size() > 0) {
            var5 = (Baremes)var8.get(0);
         } else {
            var5 = null;
         }
      } else {
         var5 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public Baremes rechercheBaremeProduit(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Baremes");
         var4 = true;
      }

      new Baremes();
      Baremes var5;
      if (var1 != null && !var1.isEmpty()) {
         Query var6 = null;
         String var7 = "barCategorieTiers = '" + var1 + "'";
         if (var2 != null && !var2.isEmpty()) {
            var7 = var7 + " and (barCodeProduit = '" + var2 + "')";
         }

         var6 = var3.createQuery("from Baremes where " + var7).setMaxResults(1);
         List var8 = var6.list();
         if (var8.size() > 0) {
            var5 = (Baremes)var8.get(0);
         } else {
            var5 = null;
         }
      } else {
         var5 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public Baremes rechercheBareme(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Baremes");
         var4 = true;
      }

      Query var5 = var3.createQuery("from Baremes where barId=:id").setLong("id", var1).setMaxResults(1);
      List var6 = var5.list();
      new Baremes();
      Baremes var7;
      if (var6.size() > 0) {
         var7 = (Baremes)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public boolean existCode(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Baremes");
         var3 = true;
      }

      boolean var4 = false;
      Query var5 = var2.createQuery("from Baremes where barCode=:cod").setString("cod", var1).setMaxResults(1);
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
