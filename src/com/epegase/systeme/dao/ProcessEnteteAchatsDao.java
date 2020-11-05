package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ProcessEnteteAchats;
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

public class ProcessEnteteAchatsDao implements Serializable {
   private ProcessEnteteAchats processEntete;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public ProcessEnteteAchatsDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public ProcessEnteteAchats insert(ProcessEnteteAchats var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProcessAchats");
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

   public ProcessEnteteAchats insert(ProcessEnteteAchats var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public ProcessEnteteAchats modif(ProcessEnteteAchats var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProcessAchats");
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

   public ProcessEnteteAchats modif(ProcessEnteteAchats var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(ProcessEnteteAchats var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProcessAchats");
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

   public void delete(ProcessEnteteAchats var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List selectProcess(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "ProcessAchats");
         var2 = true;
      }

      List var3 = var1.createQuery("from ProcessEnteteAchats order by procesCode asc").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List selectProcess(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProcessAchats");
         var3 = true;
      }

      List var4 = var2.createQuery("from ProcessEnteteAchats where procesService=:srv order by procesCode asc").setString("srv", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesProcess(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "ProcessAchats");
         var2 = true;
      }

      List var3 = var1.createQuery("from ProcessEnteteAchats where procesInactif=0 order by procesCode asc").list();
      List var4 = var3;
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var5.add(new SelectItem(((ProcessEnteteAchats)var4.get(var6)).getProcesCode() + ":" + ((ProcessEnteteAchats)var4.get(var6)).getProcesLibClient()));
         }
      }

      return var5;
   }

   public List chargerLesProcessByService(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProcessAchats");
         var3 = true;
      }

      List var4 = var2.createQuery("from ProcessEnteteAchats where procesInactif=0 and procesService=:srv order by procesCode asc").setString("srv", var1).list();
      List var5 = var4;
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var6 = new ArrayList();
      if (var4.size() != 0) {
         for(int var7 = 0; var7 < var5.size(); ++var7) {
            var6.add(new SelectItem(((ProcessEnteteAchats)var5.get(var7)).getProcesCode() + ":" + ((ProcessEnteteAchats)var5.get(var7)).getProcesLibClient()));
         }
      }

      return var6;
   }

   public List chargerLesProcessSansService(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "ProcessAchats");
         var2 = true;
      }

      List var3 = var1.createQuery("from ProcessEnteteAchats where procesInactif=0 and (procesService is null or procesService='') order by procesCode asc").list();
      List var4 = var3;
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var5.add(new SelectItem(((ProcessEnteteAchats)var4.get(var6)).getProcesCode() + ":" + ((ProcessEnteteAchats)var4.get(var6)).getProcesLibClient()));
         }
      }

      return var5;
   }

   public ProcessEnteteAchats rechercheProcess(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProcessAchats");
         var3 = true;
      }

      Query var4 = var2.createQuery("from ProcessEnteteAchats where procesCode=:cod").setString("cod", var1).setMaxResults(1);
      List var5 = var4.list();
      new ProcessEnteteAchats();
      ProcessEnteteAchats var6;
      if (var5.size() > 0) {
         var6 = (ProcessEnteteAchats)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public ProcessEnteteAchats rechercheProcess(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "ProcessAchats");
         var4 = true;
      }

      Query var5 = var3.createQuery("from ProcessEnteteAchats where procesId=:id").setLong("id", var1);
      var5.setMaxResults(1);
      List var6 = var5.list();
      new ProcessEnteteAchats();
      ProcessEnteteAchats var7;
      if (var6.size() > 0) {
         var7 = (ProcessEnteteAchats)var6.get(0);
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
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProcessAchats");
         var3 = true;
      }

      boolean var4 = false;
      Query var5 = var2.createQuery("from ProcessEnteteAchats where procesCode=:cod").setString("cod", var1);
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
