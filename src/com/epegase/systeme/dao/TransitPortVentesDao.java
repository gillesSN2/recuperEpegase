package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.TransitPortVentes;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class TransitPortVentesDao implements Serializable {
   private TransitPortVentes transitPortVentes;
   private ExercicesVentes exercicesVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public TransitPortVentesDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public TransitPortVentes insert(TransitPortVentes var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public TransitPortVentes modif(TransitPortVentes var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public String deletTransitPortVentes(long var1, Session var3) {
      Query var4 = var3.createQuery("delete from TransitPortVentes where traprtId =:Sid");
      var4.setParameter("Sid", var1);
      var4.executeUpdate();
      return null;
   }

   public List selectTransitPortVentes(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ManifestEntete");
         var4 = true;
      }

      Query var5 = null;
      if (var1 != 0L) {
         var5 = var3.createQuery("from TransitPortVentes where exerciceventes=:exo order by traprtLibelleFr").setLong("exo", var1);
      } else {
         var5 = var3.createQuery("from TransitPortVentes");
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

   public List chargerLesPorts(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ManifestEntete");
         var4 = true;
      }

      List var5 = null;
      if (var1 != 0L) {
         var5 = var3.createQuery("from TransitPortVentes where exerciceventes=:exo order by traprtLibelleFr").setLong("exo", var1).list();
      } else {
         var5 = var3.createQuery("from TransitPortVentes order by traprtLibelleFr").list();
      }

      List var6 = var5;
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var7 = new ArrayList();
      if (var5.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            var7.add(new SelectItem(((TransitPortVentes)var6.get(var8)).getTraprtCode(), ((TransitPortVentes)var6.get(var8)).getTraprtLibelleFr()));
         }
      }

      return var7;
   }

   public List chargerLesPortsByNature(int var1, long var2, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "ManifestEntete");
         var5 = true;
      }

      List var6 = null;
      if (var1 != 0) {
         if (var2 != 0L) {
            var6 = var4.createQuery("from TransitPortVentes where exerciceventes=:exo and traprtNature=:nat order by traprtLibelleFr").setLong("exo", var2).setInteger("nat", var1).list();
         } else {
            var6 = var4.createQuery("from TransitPortVentes where traprtNature=:nat order by traprtLibelleFr").setInteger("nat", var1).list();
         }
      } else if (var2 != 0L) {
         var6 = var4.createQuery("from TransitPortVentes where exerciceventes=:exo order by traprtLibelleFr").setLong("exo", var2).list();
      } else {
         var6 = var4.createQuery("from TransitPortVentes order by traprtLibelleFr").list();
      }

      List var7 = var6;
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var8 = new ArrayList();
      if (var6.size() != 0) {
         for(int var9 = 0; var9 < var7.size(); ++var9) {
            var8.add(new SelectItem(((TransitPortVentes)var7.get(var9)).getTraprtCode(), ((TransitPortVentes)var7.get(var9)).getTraprtLibelleFr()));
         }
      }

      return var8;
   }

   public TransitPortVentes rechercherTransitPortVentes(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ManifestEntete");
         var3 = true;
      }

      Query var4 = var2.createQuery("from TransitPortVentes where traprtCode =:cod order by traprtLibelleFr").setString("cod", var1).setMaxResults(1);
      new ArrayList();
      this.transitPortVentes = null;
      if (var4.list() != null) {
         List var5 = var4.list();
         if (var5.size() != 0) {
            this.transitPortVentes = (TransitPortVentes)var5.get(0);
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return this.transitPortVentes;
   }

   public String selectTransitPortVentes(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ManifestEntete");
         var3 = true;
      }

      Query var4 = var2.createQuery("from TransitPortVentes where traprtCode =:cod order by traprtLibelleFr").setString("cod", var1).setMaxResults(1);
      new ArrayList();
      String var6 = "";
      if (var4.list() != null) {
         List var5 = var4.list();
         if (var5.size() != 0) {
            var6 = ((TransitPortVentes)var5.get(0)).getTraprtCode();
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
