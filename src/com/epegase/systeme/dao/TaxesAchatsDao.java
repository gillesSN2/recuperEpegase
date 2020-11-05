package com.epegase.systeme.dao;

import com.epegase.systeme.classe.TaxesAchats;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class TaxesAchatsDao implements Serializable {
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public TaxesAchatsDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public TaxesAchats insert(TaxesAchats var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public TaxesAchats modif(TaxesAchats var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(TaxesAchats var1, Session var2) {
      var2.delete(var1);
   }

   public List selectTaxesAchats(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "TaxesAchats");
         var4 = true;
      }

      Query var5 = var3.createQuery("from TaxesAchats where exercicesachats=:exo order by taxachCode").setLong("exo", var1);
      Object var6 = new ArrayList();
      if (var5.list() != null) {
         var6 = var5.list();
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var6;
   }

   public List selectActifTaxes(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "TaxesAchats");
         var4 = true;
      }

      List var5 = var3.createQuery("from TaxesAchats where exercicesachats=:exo and taxachInactif=0 order by taxachCode").setLong("exo", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public TaxesAchats selectTva(long var1, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "TaxesAchats");
         var5 = true;
      }

      Query var6 = var4.createQuery("from TaxesAchats where exercicesachats=:exo and taxachCode=:tax order by taxachCode").setLong("exo", var1).setString("tax", var3).setMaxResults(1);
      List var7 = var6.list();
      TaxesAchats var8 = null;
      if (var7.size() != 0) {
         var8 = (TaxesAchats)var7.get(0);
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public boolean timbreExist(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "TaxesAchats");
         var4 = true;
      }

      Query var5 = var3.createQuery("from TaxesAchats where exercicesachats=:exo and taxachTimbre>0").setLong("exo", var1).setMaxResults(1);
      List var6 = var5.list();
      boolean var7 = false;
      if (var6.size() != 0) {
         var7 = true;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }
}
