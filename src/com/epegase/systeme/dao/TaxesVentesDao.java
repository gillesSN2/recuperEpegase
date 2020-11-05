package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.TaxesVentes;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class TaxesVentesDao implements Serializable {
   private TaxesVentes taxesVentes;
   private ExercicesVentes exercicesVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public TaxesVentesDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public TaxesVentes insert(TaxesVentes var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public TaxesVentes modif(TaxesVentes var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public String deletTaxesVentes(long var1, Session var3) {
      Query var4 = var3.createQuery("delete from TaxesVentes where taxvteId =:Sid");
      var4.setParameter("Sid", var1);
      var4.executeUpdate();
      return null;
   }

   public List selectTaxesVentes(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "TaxesVentes");
         var4 = true;
      }

      Query var5 = var3.createQuery("from TaxesVentes where exerciceventes=:exo order by taxvteCode").setLong("exo", var1);
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
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "TaxesVentes");
         var4 = true;
      }

      List var5 = null;
      if (var1 != 0L) {
         var5 = var3.createQuery("from TaxesVentes where exerciceventes=:exo and taxvteInactif=0 order by taxvteCode").setLong("exo", var1).list();
      } else {
         var5 = var3.createQuery("from TaxesVentes where taxvteInactif=0 group by taxvteCode").list();
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public TaxesVentes selectTva(long var1, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "TaxesVentes");
         var5 = true;
      }

      Query var6 = var4.createQuery("from TaxesVentes where exerciceventes=:exo and taxvteCode=:tax order by taxvteCode").setLong("exo", var1).setString("tax", var3).setMaxResults(1);
      List var7 = var6.list();
      TaxesVentes var8 = null;
      if (var7.size() != 0) {
         var8 = (TaxesVentes)var7.get(0);
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public boolean timbreExist(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "TaxesVentes");
         var4 = true;
      }

      Query var5 = var3.createQuery("from TaxesVentes where exerciceventes=:exo and taxvteTimbre>0").setLong("exo", var1).setMaxResults(1);
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

   public List selectActifTaxesItems(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "TaxesVentes");
         var4 = true;
      }

      List var5 = var3.createQuery("from TaxesVentes where exerciceventes=:exo and taxvteInactif=0 order by taxvteCode").setLong("exo", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var6 = new ArrayList();
      var6.add(new SelectItem(""));
      if (var5.size() != 0) {
         for(int var7 = 0; var7 < var5.size(); ++var7) {
            TaxesVentes var8 = (TaxesVentes)var5.get(var7);
            if (var8.getTaxvteCode() != null && !var8.getTaxvteCode().isEmpty()) {
               var6.add(new SelectItem(var8.getTaxvteCode()));
            }
         }
      }

      return var6;
   }
}
