package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ProtocoleMedical;
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

public class ProtocoleMedicalDao implements Serializable {
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ProtocoleMedicalDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public ProtocoleMedical insert(ProtocoleMedical var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public ProtocoleMedical modif(ProtocoleMedical var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ProtocoleMedical");
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

   public ProtocoleMedical modif(ProtocoleMedical var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(ProtocoleMedical var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ProtocoleMedical");
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

   public List selectProtocoleMedical(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ProtocoleMedical");
         var4 = true;
      }

      Query var5 = var3.createQuery("from ProtocoleMedical where exerciceventes=:exo order by prtCode").setLong("exo", var1);
      new ArrayList();
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List selectActifProtocole(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ProtocoleMedical");
         var4 = true;
      }

      List var5 = var3.createQuery("from ProtocoleMedical where exerciceventes=:exo and prtInactif=0 order by prtCode").setLong("exo", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectActifProtocoleItems(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ProtocoleMedical");
         var4 = true;
      }

      List var5 = var3.createQuery("from ProtocoleMedical where exerciceventes=:exo and prtInactif=0 order by prtCode").setLong("exo", var1).list();
      ArrayList var6 = new ArrayList();
      if (var5.size() != 0) {
         for(int var7 = 0; var7 < var5.size(); ++var7) {
            new ProtocoleMedical();
            ProtocoleMedical var8 = (ProtocoleMedical)var5.get(var7);
            var6.add(new SelectItem(var8.getPrtCode() + ":" + var8.getPrtLibelle()));
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public boolean testUnicite(String var1, long var2, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      boolean var6 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "ProtocoleMedical");
         var6 = true;
      }

      List var7 = var4.createQuery("from ProtocoleMedical where exerciceventes=:exo and prtInactif=0 and prtCode=:cod").setLong("exo", var2).setString("cod", var1).setMaxResults(1).list();
      if (var7.size() != 0) {
         var5 = false;
      } else {
         var5 = true;
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public ProtocoleMedical chargeProtocole(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ProtocoleMedical");
         var3 = true;
      }

      new ProtocoleMedical();
      List var5 = var2.createQuery("from ProtocoleMedical where prtInactif=0 and prtCode=:cod").setString("cod", var1).setMaxResults(1).list();
      ProtocoleMedical var4;
      if (var5.size() != 0) {
         var4 = (ProtocoleMedical)var5.get(0);
      } else {
         var4 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }
}
