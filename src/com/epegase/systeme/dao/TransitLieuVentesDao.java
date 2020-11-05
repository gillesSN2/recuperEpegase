package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.TransitLieuVentes;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class TransitLieuVentesDao implements Serializable {
   private TransitLieuVentes transitLieuVentes;
   private ExercicesVentes exercicesVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public TransitLieuVentesDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public TransitLieuVentes insert(TransitLieuVentes var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public TransitLieuVentes modif(TransitLieuVentes var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public String deletTransitLieuVentes(long var1, Session var3) {
      Query var4 = var3.createQuery("delete from TransitLieuVentes where tralieId =:Sid");
      var4.setParameter("Sid", var1);
      var4.executeUpdate();
      return null;
   }

   public List selectTransitLieuVentes(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ManifestEntete");
         var4 = true;
      }

      Query var5 = null;
      if (var1 != 0L) {
         var5 = var3.createQuery("from TransitLieuVentes where exerciceventes=:exo").setLong("exo", var1);
      } else {
         var5 = var3.createQuery("from TransitLieuVentes");
      }

      Object var6 = new ArrayList();
      if (var5.list() != null) {
         var6 = var5.list();
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var6;
   }

   public List chargerLesLieux(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ManifestEntete");
         var4 = true;
      }

      List var5 = null;
      if (var1 != 0L) {
         var5 = var3.createQuery("from TransitLieuVentes where exerciceventes=:exo").setLong("exo", var1).list();
      } else {
         var5 = var3.createQuery("from TransitLieuVentes").list();
      }

      List var6 = var5;
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var7 = new ArrayList();
      if (var5.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            var7.add(new SelectItem(((TransitLieuVentes)var6.get(var8)).getTralieCode(), ((TransitLieuVentes)var6.get(var8)).getTralieLibelleFr()));
         }
      }

      return var7;
   }

   public List chargerLesLieux(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ManifestEntete");
         var3 = true;
      }

      List var4 = null;
      if (var1 != null && !var1.isEmpty()) {
         var4 = var2.createQuery("from TransitLieuVentes where (traliePort=:prt or traliePort is null or traliePort='')").setString("prt", var1).list();
      } else {
         var4 = var2.createQuery("from TransitLieuVentes (traliePort is null or traliePort='')").list();
      }

      List var5 = var4;
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var6 = new ArrayList();
      if (var4.size() != 0) {
         for(int var7 = 0; var7 < var5.size(); ++var7) {
            var6.add(new SelectItem(((TransitLieuVentes)var5.get(var7)).getTralieCode(), ((TransitLieuVentes)var5.get(var7)).getTralieLibelleFr()));
         }
      }

      return var6;
   }

   public TransitLieuVentes rechercherTransitLieuVentes(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ManifestEntete");
         var3 = true;
      }

      Query var4 = var2.createQuery("from TransitLieuVentes where tralieCode =:cod").setString("cod", var1).setMaxResults(1);
      new ArrayList();
      this.transitLieuVentes = null;
      if (var4.list() != null) {
         List var5 = var4.list();
         if (var5.size() != 0) {
            this.transitLieuVentes = (TransitLieuVentes)var5.get(0);
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return this.transitLieuVentes;
   }

   public String selectTransitLieuVentes(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ManifestEntete");
         var3 = true;
      }

      Query var4 = var2.createQuery("from TransitLieuVentes where tralieCode =:cod").setString("cod", var1).setMaxResults(1);
      new ArrayList();
      String var6 = "";
      if (var4.list() != null) {
         List var5 = var4.list();
         if (var5.size() != 0) {
            var6 = ((TransitLieuVentes)var5.get(0)).getTralieCode();
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
