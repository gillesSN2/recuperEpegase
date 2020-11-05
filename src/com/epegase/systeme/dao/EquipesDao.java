package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Equipes;
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

public class EquipesDao implements Serializable {
   private Equipes equipes;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public EquipesDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public Equipes insert(Equipes var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Equipes");
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

   public Equipes insert(Equipes var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public Equipes modif(Equipes var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Equipes");
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

   public Equipes modif(Equipes var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(Equipes var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Equipes");
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

   public void delete(Equipes var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List selectEquipes(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Equipes");
         var2 = true;
      }

      List var3 = var1.createQuery("from Equipes order by equCode asc").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerLesEquipes(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Equipes");
         var2 = true;
      }

      List var3 = var1.createQuery("from Equipes where equInactif=0").list();
      List var4 = var3;
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var5.add(new SelectItem(((Equipes)var4.get(var6)).getEquCode() + ":" + ((Equipes)var4.get(var6)).getEquNomFr()));
         }
      }

      return var5;
   }

   public List chargerLesEquipesById(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Equipes");
         var2 = true;
      }

      List var3 = var1.createQuery("from Equipes where equInactif=0").list();
      List var4 = var3;
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var5.add(new SelectItem(((Equipes)var4.get(var6)).getEquId(), ((Equipes)var4.get(var6)).getEquCode() + ":" + ((Equipes)var4.get(var6)).getEquNomFr()));
         }
      }

      return var5;
   }

   public Equipes rechercheEquipes(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Equipes");
         var4 = true;
      }

      Query var5 = var3.createQuery("from Equipes where equIdResponsable=:res").setLong("res", var1).setMaxResults(1);
      List var6 = var5.list();
      new Equipes();
      Equipes var7;
      if (var6.size() > 0) {
         var7 = (Equipes)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public Equipes rechercheEquipesByEquipe(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Equipes");
         var4 = true;
      }

      Query var5 = var3.createQuery("from Equipes where equId=:res").setLong("res", var1).setMaxResults(1);
      List var6 = var5.list();
      new Equipes();
      Equipes var7;
      if (var6.size() > 0) {
         var7 = (Equipes)var6.get(0);
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
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Equipes");
         var3 = true;
      }

      boolean var4 = false;
      Query var5 = var2.createQuery("from Equipes ja where ja.equCode=:cod").setString("cod", var1);
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
