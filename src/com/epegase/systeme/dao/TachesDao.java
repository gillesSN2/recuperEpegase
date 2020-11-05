package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Taches;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TachesDao implements Serializable {
   private Taches taches;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public TachesDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public Taches insert(Taches var1) throws HibernateException, NamingException {
      var1.setTacDateCreat(new Date());
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Taches");
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

   public Taches insert(Taches var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public Taches modif(Taches var1) throws HibernateException, NamingException {
      var1.setTacDateModif(new Date());
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Taches");
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

   public Taches modif(Taches var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public Taches deletetache(Taches var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Taches");
      Transaction var3 = var2.beginTransaction();
      var2.createQuery("delete from Taches where tacId=:id").setLong("id", var1.getTacId()).executeUpdate();
      var3.commit();
      this.utilInitHibernate.closeSession();
      return var1;
   }

   public List selectTaches(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Taches");
         var2 = true;
      }

      List var3 = var1.createQuery("from Taches where tacInactif=:inac").setInteger("inac", 0).list();
      new ArrayList();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List selectUserTaches(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Taches");
         var4 = true;
      }

      List var5 = var3.createQuery("from Taches where tacCode not in (select usrtacCode from UsersTaches where users=:id ) and tacInactif=:inac").setInteger("inac", 0).setLong("id", var1).list();
      new ArrayList();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectTachesActif(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Taches");
         var2 = true;
      }

      List var3 = var1.createQuery("from Taches ").list();
      new ArrayList();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List selectTachesActif(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Taches");
         var3 = true;
      }

      List var4 = null;
      if (var1.equals("*")) {
         var4 = var2.createQuery("from Taches where tacInactif=0 order by tacCode").list();
      } else if (var1 != null && !var1.isEmpty() && !var1.equals("*")) {
         var4 = var2.createQuery("from Taches where (tacNomFr like '" + var1 + "%' or tacCode= '" + var1 + "%') and tacInactif=0 order by tacCode").list();
      }

      new ArrayList();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List selectTachesActifItem(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Taches");
         var2 = true;
      }

      List var3 = var1.createQuery("from Taches ").list();
      new ArrayList();
      List var4 = var3;
      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var5.add(new SelectItem(((Taches)var4.get(var6)).getTacCode(), ((Taches)var4.get(var6)).getTacCode() + ":" + ((Taches)var4.get(var6)).getTacNomFr()));
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public boolean existCode(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Taches");
         var3 = true;
      }

      boolean var4 = false;
      Query var5 = var2.createQuery("from Taches ja where ja.tacCode=:cod ").setString("cod", var1);
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

   public Taches rechercheTache(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Taches");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Taches ja where ja.tacCode=:cod ").setString("cod", var1);
      var4.setMaxResults(1);
      List var5 = var4.list();
      Taches var6 = new Taches();
      if (var5.size() > 0) {
         var6 = (Taches)var5.get(0);
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List selectMissionTaches(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Taches");
         var3 = true;
      }

      List var4 = var2.createQuery("from Taches where tacMission=:mis and tacInactif=:inac").setInteger("inac", 0).setString("mis", var1).list();
      new ArrayList();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }
}
