package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class HabilitationDao implements Serializable {
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public HabilitationDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public Habilitation insert(Habilitation var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public Habilitation modifier(Habilitation var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(Habilitation var1, Session var2) {
      var2.delete(var1);
   }

   public List selectListVente(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Habilitation");
         var2 = true;
      }

      Query var3 = var1.createQuery("from Habilitation where habNature=8 or (habNature>=20 and habNature<=29) order by habNature asc");
      Object var4 = new ArrayList();
      if (var3.list() != null) {
         var4 = var3.list();
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var4;
   }

   public List selectListCaiss(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Habilitation");
         var2 = true;
      }

      Query var3 = var1.createQuery("from Habilitation where habNature=19 or (habNature>=60 and habNature<=69) order by habNature asc");
      Object var4 = new ArrayList();
      if (var3.list() != null) {
         var4 = var3.list();
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var4;
   }

   public List selectListAchat(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Habilitation");
         var2 = true;
      }

      Query var3 = var1.createQuery("from Habilitation where (habNature>=10 and habNature<=19) or (habNature>=30 and habNature<=39) order by habNature asc");
      Object var4 = new ArrayList();
      if (var3.list() != null) {
         var4 = var3.list();
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var4;
   }

   public List selectListMedical(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Habilitation");
         var2 = true;
      }

      Query var3 = var1.createQuery("from Habilitation where habNature>=70 and habNature<=79 order by habNature asc");
      Object var4 = new ArrayList();
      if (var3.list() != null) {
         var4 = var3.list();
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var4;
   }

   public List selectListPaye(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Habilitation");
         var2 = true;
      }

      Query var3 = var1.createQuery("from Habilitation where habNature>=80 and habNature<=89 order by habNature asc");
      Object var4 = new ArrayList();
      if (var3.list() != null) {
         var4 = var3.list();
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var4;
   }

   public Habilitation selectUnique(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Habilitation");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Habilitation where " + var1 + " order by habNature desc");
      var4.setMaxResults(1);
      Habilitation var5 = null;
      if (var4.list() != null) {
         List var6 = var4.list();
         if (var6.size() > 0) {
            var5 = (Habilitation)var6.get(0);
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public Habilitation existenceHabilitation(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Habilitation");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Habilitation where habNature=:na order by habNature desc").setInteger("na", var1).setMaxResults(1);
      Habilitation var5 = null;
      if (var4.list() != null) {
         List var6 = var4.list();
         if (var6.size() > 0) {
            var5 = (Habilitation)var6.get(0);
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public boolean selectByNature(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Habilitation");
         var3 = true;
      }

      boolean var4 = false;
      new ArrayList();
      Query var6 = var2.createQuery("from Habilitation where habNature=:nature");
      var6.setParameter("nature", var1);
      var6.setMaxResults(1);
      List var5 = var6.list();
      if (var5.size() > 0) {
         var4 = true;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }
}
