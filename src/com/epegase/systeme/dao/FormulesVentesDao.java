package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FormulesVentes;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class FormulesVentesDao implements Serializable {
   private FormulesVentes formulesVentes;
   private ExercicesVentes exercicesVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public FormulesVentesDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public FormulesVentes insert(FormulesVentes var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public FormulesVentes modif(FormulesVentes var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public String deletFormulesVentes(long var1, Session var3) {
      Query var4 = var3.createQuery("delete from FormulesVentes where forvteId =:Sid");
      var4.setParameter("Sid", var1);
      var4.executeUpdate();
      return null;
   }

   public List selectFormulesVentes(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "FormulesVentes");
         var4 = true;
      }

      Query var5 = var3.createQuery("from FormulesVentes where exerciceventes=:exo").setLong("exo", var1);
      Object var6 = new ArrayList();
      if (var5.list() != null) {
         var6 = var5.list();
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var6;
   }

   public List chargerLesFormules(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "FormulesVentes");
         var4 = true;
      }

      List var5 = var3.createQuery("from FormulesVentes where exerciceventes=:exo").setLong("exo", var1).list();
      List var6 = var5;
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var7 = new ArrayList();
      if (var5.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            var7.add(new SelectItem(((FormulesVentes)var6.get(var8)).getForvteLibelleFr()));
         }
      }

      return var7;
   }

   public String selectFormulesVentes(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "FormulesVentes");
         var3 = true;
      }

      Query var4 = var2.createQuery("from FormulesVentes where forvteLibelleFr =:lib").setString("lib", var1).setMaxResults(1);
      new ArrayList();
      String var6 = "";
      if (var4.list() != null) {
         List var5 = var4.list();
         if (var5.size() != 0) {
            var6 = ((FormulesVentes)var5.get(0)).getForvteDetailFr();
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
