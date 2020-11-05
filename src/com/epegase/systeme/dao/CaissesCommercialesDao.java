package com.epegase.systeme.dao;

import com.epegase.systeme.classe.CaissesCommerciales;
import com.epegase.systeme.classe.ExercicesCaisse;
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

public class CaissesCommercialesDao implements Serializable {
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public CaissesCommercialesDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public CaissesCommerciales insert(CaissesCommerciales var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "CaisseCommerciale");
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

   public CaissesCommerciales insert(CaissesCommerciales var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public CaissesCommerciales modif(CaissesCommerciales var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "CaisseCommerciale");
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

   public CaissesCommerciales modif(CaissesCommerciales var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public String delete(CaissesCommerciales var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "CaisseCommerciale");
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

      return null;
   }

   public List selectCaisseCommerciale(long var1, int var3, Session var4) {
      Query var5 = null;
      if (var3 == 1) {
         var5 = var4.createQuery("from CaissesCommerciales where caiPrive=0 and exercicesCaisse=:exo order by caiCode").setLong("exo", var1);
      } else {
         var5 = var4.createQuery("from CaissesCommerciales where exercicesCaisse=:exo order by caiCode").setLong("exo", var1);
      }

      Object var6 = new ArrayList();
      if (var5.list() != null) {
         var6 = var5.list();
      }

      return (List)var6;
   }

   public CaissesCommerciales selectCaisseByCode(String var1, ExercicesCaisse var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "CaisseCommerciale");
         var4 = true;
      }

      new CaissesCommerciales();
      new ArrayList();
      Query var7 = var3.createQuery("from CaissesCommerciales where exercicesCaisse=:exo and caiCode=:code order by caiCode").setString("code", var1).setParameter("exo", var2).setMaxResults(1);
      List var6 = var7.list();
      CaissesCommerciales var5;
      if (var6.size() > 0) {
         var5 = (CaissesCommerciales)var6.get(0);
      } else {
         var5 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectActifCaisse(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "CaisseCommerciale");
         var3 = true;
      }

      List var4 = null;
      if (var1 == 1) {
         var4 = var2.createQuery("from CaissesCommerciales where caiInactif=0 and caiPrive=0 order by caiCode").list();
      } else {
         var4 = var2.createQuery("from CaissesCommerciales where caiInactif=0 order by caiCode").list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List selectActifCaisseItems(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "CaisseCommerciale");
         var2 = true;
      }

      List var3 = var1.createQuery("from CaissesCommerciales where caiInactif=0 order by caiCode").list();
      List var4 = var3;
      ArrayList var5 = new ArrayList();
      if (var3 != null) {
         new CaissesCommerciales();

         for(int var7 = 0; var7 < var4.size(); ++var7) {
            CaissesCommerciales var6 = (CaissesCommerciales)var4.get(var7);
            var5.add(new SelectItem(var6.getCaiCode() + ":" + var6.getCaiNom()));
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectActifCaisseItems(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "CaisseCommerciale");
         var3 = true;
      }

      List var4 = null;
      if (var1 == 1) {
         var4 = var2.createQuery("from CaissesCommerciales where caiPrive=0 and caiInactif=0 order by caiCode").list();
      } else {
         var4 = var2.createQuery("from CaissesCommerciales where caiInactif=0 order by caiCode").list();
      }

      List var5 = var4;
      ArrayList var6 = new ArrayList();
      if (var4 != null) {
         new CaissesCommerciales();

         for(int var8 = 0; var8 < var5.size(); ++var8) {
            CaissesCommerciales var7 = (CaissesCommerciales)var5.get(var8);
            var6.add(new SelectItem(var7.getCaiCode() + ":" + var7.getCaiNom()));
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List selectActifCaisse(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "CaisseCommerciale");
         var4 = true;
      }

      List var5 = var3.createQuery("from CaissesCommerciales where exercicesCaisse=:exo and caiInactif=0 order by caiCode").setLong("exo", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public CaissesCommerciales selectCaisse(long var1, String var3, Session var4) throws HibernateException, NamingException {
      new CaissesCommerciales();
      boolean var6 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "CaisseCommerciale");
         var6 = true;
      }

      Query var7 = null;
      if (var1 == 0L) {
         var7 = var4.createQuery("from CaissesCommerciales where caiCode=:cod order by caiCode").setString("cod", var3).setMaxResults(1);
      } else {
         var7 = var4.createQuery("from CaissesCommerciales where exercicesCaisse=:exo and caiCode=:cod order by caiCode").setLong("exo", var1).setString("cod", var3).setMaxResults(1);
      }

      List var8 = var7.list();
      CaissesCommerciales var5;
      if (var8.size() != 0) {
         var5 = (CaissesCommerciales)var8.get(0);
      } else {
         var5 = null;
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public CaissesCommerciales chercheCaisseDefaut(long var1, Session var3) throws HibernateException, NamingException {
      new CaissesCommerciales();
      boolean var5 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "CaisseCommerciale");
         var5 = true;
      }

      Query var6 = var3.createQuery("from CaissesCommerciales where exercicesCaisse=:exo and caiInactif=0 and (caiJrEspece is NOT NULL or caiJrCheque is NOT NULL) order by caiCode").setLong("exo", var1).setMaxResults(1);
      var6.setMaxResults(1);
      List var7 = var6.list();
      CaissesCommerciales var4;
      if (var7.size() != 0) {
         var4 = (CaissesCommerciales)var7.get(0);
      } else {
         var4 = null;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public CaissesCommerciales chercheCaisseByJournal(long var1, String var3, Session var4) throws HibernateException, NamingException {
      new CaissesCommerciales();
      boolean var6 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "CaisseCommerciale");
         var6 = true;
      }

      Query var7 = var4.createQuery("from CaissesCommerciales where exercicesCaisse=:exo and caiInactif=0 and (caiJrEspece=:jr or caiJrCheque=:jr or caiJrVirement=:jr or caiJrTraite=:jr or caiJrTpe=:jr or caiJrTransfert=:jr or caiJrePaiement=:jr or caiJrCredoc=:jr or caiJrFactor=:jr or caiJrCompense=:jr or caiJrTerme=:jr) order by caiCode").setLong("exo", var1).setString("jr", var3).setMaxResults(1).setMaxResults(1);
      List var8 = var7.list();
      CaissesCommerciales var5;
      if (var8.size() != 0) {
         var5 = (CaissesCommerciales)var8.get(0);
      } else {
         var5 = null;
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public CaissesCommerciales chercheCaisseTpe(long var1, Session var3) throws HibernateException, NamingException {
      new CaissesCommerciales();
      boolean var5 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "CaisseCommerciale");
         var5 = true;
      }

      Query var6 = var3.createQuery("from CaissesCommerciales where exercicesCaisse=:exo and caiInactif=0 and caiJrTpe is NOT NULL order by caiCode").setLong("exo", var1).setMaxResults(1);
      var6.setMaxResults(1);
      List var7 = var6.list();
      CaissesCommerciales var4;
      if (var7.size() != 0) {
         var4 = (CaissesCommerciales)var7.get(0);
      } else {
         var4 = null;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }
}
