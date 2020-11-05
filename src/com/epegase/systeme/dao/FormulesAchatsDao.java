package com.epegase.systeme.dao;

import com.epegase.systeme.classe.FormulesAchats;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class FormulesAchatsDao implements Serializable {
   private FormulesAchats formulesAchats;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public FormulesAchatsDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public FormulesAchats insert(FormulesAchats var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public FormulesAchats modif(FormulesAchats var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(FormulesAchats var1, Session var2) {
      var2.delete(var1);
   }

   public List selectFormulesAchats(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "FormulesAchats");
         var4 = true;
      }

      List var5 = var3.createQuery("from FormulesAchats").list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesFormules(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "FormulesAchats");
         var4 = true;
      }

      List var5 = var3.createQuery("from FormulesAchats where exercicesAchats=:exo").setLong("exo", var1).list();
      List var6 = var5;
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var7 = new ArrayList();
      if (var5.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            var7.add(new SelectItem(((FormulesAchats)var6.get(var8)).getForachLibelleFr()));
         }
      }

      return var7;
   }

   public String selectFormulesAchats(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "FormulesAchats");
         var3 = true;
      }

      Query var4 = var2.createQuery("from FormulesAchats where forachLibelleFr =:lib").setString("lib", var1).setMaxResults(1);
      new ArrayList();
      String var6 = "";
      if (var4.list() != null) {
         List var5 = var4.list();
         if (var5.size() != 0) {
            var6 = ((FormulesAchats)var5.get(0)).getForachDetailFr();
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
