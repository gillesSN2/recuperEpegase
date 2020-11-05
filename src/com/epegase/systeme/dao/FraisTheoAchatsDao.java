package com.epegase.systeme.dao;

import com.epegase.systeme.classe.FraisTheoAchats;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FraisTheoAchatsDao implements Serializable {
   private FraisTheoAchats fraisTheoAchats;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public FraisTheoAchatsDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public FraisTheoAchats insert(FraisTheoAchats var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "FraisTheoAchats");
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

   public FraisTheoAchats insert(FraisTheoAchats var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public FraisTheoAchats modif(FraisTheoAchats var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "FraisTheoAchats");
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

   public FraisTheoAchats modif(FraisTheoAchats var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(FraisTheoAchats var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "FraisTheoAchats");
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

   public void delete(FraisTheoAchats var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public FraisTheoAchats chargerFraisEntete(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "FraisTheoAchats");
         var4 = true;
      }

      new FraisTheoAchats();
      List var6 = var3.createQuery("from FraisTheoAchats where fstId=" + var1).setMaxResults(1).list();
      new ArrayList();
      FraisTheoAchats var5;
      if (var6 != null) {
         if (var6.size() != 0) {
            var5 = (FraisTheoAchats)var6.get(0);
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

   public List chargerFraisEntete(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "FraisTheoAchats");
         var2 = true;
      }

      List var3 = var1.createQuery("from FraisTheoAchats group by fstFeuille,fstMode,fstNature order by fstFeuille asc").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerFraisEnteteItem(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "FraisTheoAchats");
         var3 = true;
      }

      List var4 = var2.createQuery("from FraisTheoAchats where fstType=" + var1 + " group by fstFeuille order by fstFeuille asc").list();
      ArrayList var5 = new ArrayList();
      if (var4 != null) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            new FraisTheoAchats();
            FraisTheoAchats var7 = (FraisTheoAchats)var4.get(var6);
            var5.add(new SelectItem(var7.getFstFeuille()));
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerFraisLignes(String var1, String var2, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "FraisTheoAchats");
         var5 = true;
      }

      List var6 = null;
      if (var3 != 99) {
         if (var2 != null && !var2.isEmpty()) {
            var6 = var4.createQuery("from FraisTheoAchats where fstFeuille=:fel and fstMode='" + var2 + "'  and fstNature=" + var3 + " order by fstOrdre").setString("fel", var1).list();
         } else {
            var6 = var4.createQuery("from FraisTheoAchats where fstFeuille=:fel  and fstNature=" + var3 + " order by fstOrdre").setString("fel", var1).list();
         }
      } else if (var2 != null && !var2.isEmpty()) {
         var6 = var4.createQuery("from FraisTheoAchats where fstFeuille=:fel and fstMode='" + var2 + "' order by fstOrdre").setString("fel", var1).list();
      } else {
         var6 = var4.createQuery("from FraisTheoAchats where fstFeuille=:fel order by fstOrdre").setString("fel", var1).list();
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerFraisLignes(long var1, String var3, int var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "FraisTheoAchats");
         var6 = true;
      }

      List var7 = null;
      if (var4 != 99) {
         if (var3 != null && !var3.isEmpty()) {
            var7 = var5.createQuery("from FraisTheoAchats where fstIdTiers=:id and fstMode='" + var3 + "' and fstNature=" + var4 + " order by fstOrdre").setLong("id", var1).list();
         } else {
            var7 = var5.createQuery("from FraisTheoAchats where fstIdTiers=:id and fstNature=" + var4 + " order by fstOrdre").setLong("id", var1).list();
         }
      } else if (var3 != null && !var3.isEmpty()) {
         var7 = var5.createQuery("from FraisTheoAchats where fstIdTiers=:id and fstMode='" + var3 + "' order by fstOrdre").setLong("id", var1).list();
      } else {
         var7 = var5.createQuery("from FraisTheoAchats where fstIdTiers=:id  order by fstOrdre").setLong("id", var1).list();
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public boolean verifSimulationPrProduit(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "FraisTheoAchats");
         var2 = true;
      }

      List var3 = var1.createQuery("from FraisTheoAchats where fstType=0 group by fstFeuille order by fstFeuille asc").list();
      boolean var4 = false;
      if (var3.size() != 0) {
         var4 = true;
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public boolean verifSimulationPrCot(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "FraisTheoAchats");
         var2 = true;
      }

      List var3 = var1.createQuery("from FraisTheoAchats where fstType=1 group by fstFeuille order by fstFeuille asc").list();
      boolean var4 = false;
      if (var3.size() != 0) {
         var4 = true;
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public boolean verifSimulationPrCmd(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "FraisTheoAchats");
         var2 = true;
      }

      List var3 = var1.createQuery("from FraisTheoAchats where fstType=2 group by fstFeuille order by fstFeuille asc").list();
      boolean var4 = false;
      if (var3.size() != 0) {
         var4 = true;
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public boolean verifSimulationPrFournisseur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "FraisTheoAchats");
         var4 = true;
      }

      List var5 = var3.createQuery("from FraisTheoAchats where fstType=3 and fstIdTiers= " + var1 + " group by fstFeuille order by fstFeuille asc").list();
      boolean var6 = false;
      if (var5.size() != 0) {
         var6 = true;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
