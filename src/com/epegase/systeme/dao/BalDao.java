package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Bal;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BalDao implements Serializable {
   private Bal bal;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public BalDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public Bal insert(Bal var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "");
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

   public Bal modif(Bal var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "");
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

   public Bal modif(Bal var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(Bal var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "");
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

   public List selectBal() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.mabase, "");
      List var2 = var1.createQuery("from Bal").list();
      this.utilInitHibernate.closeSession();
      return var2;
   }

   public List selectBalLog(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var4 = true;
      }

      Query var5 = var3.createQuery("from Bal where balStructure =:idstr").setLong("idstr", var1);
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List selectBalLogActif(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var4 = true;
      }

      Query var5 = var3.createQuery("from Bal where balinactif=0 and balStructure=:idstr").setLong("idstr", var1);
      new ArrayList();
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List selectBalGrpLog(String var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "");
      Query var3 = var2.createQuery("from Bal where balGroupe =:idgrp").setString("idgrp", var1);
      List var4 = var3.list();
      this.utilInitHibernate.closeSession();
      return var4;
   }

   public List selectBalGrpLogActif(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Bal where balinactif=0 and balGroupe=:idgrp").setString("idgrp", var1);
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectBalUserLog(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var4 = true;
      }

      Query var5 = var3.createQuery("from Bal where balUser=:idusr").setLong("idusr", var1);
      new ArrayList();
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List selectBalUserLogActif(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var4 = true;
      }

      Query var5 = var3.createQuery("from Bal where balinactif=0 and balUser=:idusr").setLong("idusr", var1);
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public Bal logBal(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "");
      List var4 = var3.createQuery("from Bal where bal_id =" + var1).list();
      this.utilInitHibernate.closeSession();
      return (Bal)var4.get(0);
   }

   public Bal logMailExiste(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Bal  where baladressemail =:email").setString("email", var1).setMaxResults(1);
      List var5 = var4.list();
      new Bal();
      Bal var6;
      if (var5.size() > 0) {
         var6 = (Bal)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public Bal chargeMailSociete(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var4 = true;
      }

      Query var5 = var3.createQuery("from Bal where balStructure =:str").setLong("str", var1).setMaxResults(1);
      List var6 = var5.list();
      new Bal();
      Bal var7;
      if (var6.size() > 0) {
         var7 = (Bal)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }
}
