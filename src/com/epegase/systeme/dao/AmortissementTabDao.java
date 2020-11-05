package com.epegase.systeme.dao;

import com.epegase.systeme.classe.AmortissementTab;
import com.epegase.systeme.classe.Amortissements;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AmortissementTabDao implements Serializable {
   private AmortissementTab amortissementTab;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public AmortissementTabDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public AmortissementTab insert(AmortissementTab var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Amortissements");
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

   public AmortissementTab insert(AmortissementTab var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public void insert(List var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Amortissements");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         if (var1.size() != 0) {
            for(int var4 = 0; var4 < var1.size(); ++var4) {
               var2.save(var1.get(var4));
            }
         }

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

   public void maj(List var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Amortissements");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         if (var1.size() != 0) {
            for(int var4 = 0; var4 < var1.size(); ++var4) {
               if (((AmortissementTab)var1.get(var4)).getAmotabId() != null && ((AmortissementTab)var1.get(var4)).getAmotabId() != 0L) {
                  var2.update(var1.get(var4));
               } else {
                  var2.save(var1.get(var4));
               }
            }
         }

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

   public void maj(List var1, Session var2) throws HibernateException, NamingException {
      if (var1.size() != 0) {
         for(int var3 = 0; var3 < var1.size(); ++var3) {
            this.amortissementTab = (AmortissementTab)var1.get(var3);
            if (this.amortissementTab.getAmotabId() != null && this.amortissementTab.getAmotabId() != 0L) {
               var2.update(this.amortissementTab);
            } else {
               var2.save(this.amortissementTab);
            }
         }
      }

   }

   public void insert(List var1, Session var2) throws HibernateException, NamingException {
      if (var1.size() != 0) {
         for(int var3 = 0; var3 < var1.size(); ++var3) {
            var2.save(var1.get(var3));
         }
      }

   }

   public AmortissementTab modif(AmortissementTab var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Amortissements");
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

   public AmortissementTab modif(AmortissementTab var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(List var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Amortissements");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         if (var1.size() != 0) {
            for(int var4 = 0; var4 < var1.size(); ++var4) {
               var2.delete(var1.get(var4));
            }
         }

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

   public void delete(List var1, Session var2) throws HibernateException, NamingException {
      if (var1.size() != 0) {
         for(int var3 = 0; var3 < var1.size(); ++var3) {
            var2.delete(var1.get(var3));
         }
      }

   }

   public void delete(AmortissementTab var1, Session var2) {
      var2.delete(var1);
   }

   public List chargeTableau(Amortissements var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Amortissements");
         var3 = true;
      }

      Query var4 = var2.createQuery("FROM AmortissementTab WHERE amortissements=:amt").setParameter("amt", var1);
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerAmotDot(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Amortissements");
         var4 = true;
      }

      Query var5 = var3.createQuery("from AmortissementTab where amotabMontant > 0 and amotabDateDeb >= '" + var1 + "' and amotabDateFin <= '" + var2 + "' and amotabValeur = 0");
      Object var6 = new ArrayList();
      if (var5.list() != null && var5.list().size() > 0) {
         var6 = var5.list();
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var6;
   }

   public List chargerAmot(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Amortissements");
         var4 = true;
      }

      Query var5 = var3.createQuery("from AmortissementTab where amotabMontant > 0 and amotabDateDeb >= '" + var1 + "' and amotabDateFin <= '" + var2 + "'");
      Object var6 = new ArrayList();
      if (var5.list() != null && var5.list().size() > 0) {
         var6 = var5.list();
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var6;
   }

   public List chargerAmotDot(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Amortissements");
         var2 = true;
      }

      Query var3 = var1.createQuery("from AmortissementTab where amotabValeur = 0");
      Object var4 = new ArrayList();
      if (var3.list() != null && var3.list().size() > 0) {
         var4 = var3.list();
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var4;
   }

   public List chargerDotation(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Amortissements");
         var2 = true;
      }

      Query var3 = var1.createQuery("from AmortissementTab where amortissements.amoTypeSortie=0");
      new ArrayList();
      List var4 = var3.list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerToutesDotations(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Amortissements");
         var2 = true;
      }

      Query var3 = var1.createQuery("from AmortissementTab");
      new ArrayList();
      List var4 = var3.list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }
}
