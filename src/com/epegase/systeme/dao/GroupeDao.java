package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Groupe;
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

public class GroupeDao implements Serializable {
   private Groupe groupe;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public GroupeDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public Groupe insertGroupe(Groupe var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
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

   public Groupe insertGroupe(Groupe var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public Groupe miseAjourGroupe(Groupe var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
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

   public void deleteGroupe(String var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
      Transaction var3 = var2.beginTransaction();
      var2.createQuery("delete from Groupe where grpCode=:cdgrp").setString("cdgrp", var1).executeUpdate();
      var3.commit();
      this.utilInitHibernate.closeSession();
   }

   public boolean existCodeGroupe(String var1) throws HibernateException, NamingException {
      boolean var2 = false;
      Session var3 = this.utilInitHibernate.getOpenSession(this.maBase, "");
      List var4 = var3.createQuery("from Groupe where grpCode=:cgrp").setString("cgrp", var1).list();
      this.utilInitHibernate.closeSession();
      if (var4.size() > 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public Groupe groupeByCode(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var3 = true;
      }

      Groupe var4 = null;
      Query var5 = var2.createQuery("from Groupe where grpCode=:cgrp order by grpCode desc").setString("cgrp", var1).setMaxResults(1);
      List var6 = var5.list();
      if (var6.size() != 0) {
         var4 = (Groupe)var6.get(0);
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List selectGroupeItems(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var2 = true;
      }

      Query var3 = var1.createQuery("from Groupe");
      List var4 = var3.list();
      ArrayList var5 = new ArrayList();
      if (var4.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var5.add(new SelectItem(((Groupe)var4.get(var6)).getGrpCode()));
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectGroupe(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var2 = true;
      }

      List var3 = var1.createQuery("from Groupe").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }
}
