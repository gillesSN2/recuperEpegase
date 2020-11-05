package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ManifestLigne;
import com.epegase.systeme.classe.ManifestProduit;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class ManifestProduitDao implements Serializable {
   private ManifestProduit manifestProduit;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ManifestProduitDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public ManifestProduit insertLigne(ManifestProduit var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public ManifestProduit modifLigne(ManifestProduit var1, Session var2) {
      var2.saveOrUpdate(var1);
      return var1;
   }

   public void deleteAllLigne(ManifestLigne var1, Session var2) {
      var2.createQuery("delete from ManifestProduit where manifestLigne=:id").setLong("id", var1.getVtelvId()).executeUpdate();
   }

   public void deleteAllLigne(String var1, Session var2) {
      var2.createQuery("delete from ManifestProduit where vteprdNumManifest=:num").setString("num", var1).executeUpdate();
   }

   public String deleteOneLigne(ManifestProduit var1, Session var2) {
      Query var3 = var2.createQuery("delete from ManifestProduit where vteprdId =" + var1.getVteprdId());
      var3.executeUpdate();
      return "";
   }

   public List chargerLesLignes(ManifestLigne var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ManifestEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from ManifestProduit where vteprdNum=:nLv and vteprdNumManifest=:nMan").setString("nLv", var1.getVtelvNum()).setString("nMan", var1.getVtelvNumManifest()).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesProduitsManifeste(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ManifestEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from ManifestProduit where vteprdNumManifest = '" + var1 + "' order by vteprdId").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public ManifestProduit chargerLesProduitsManifeste(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "ManifestEntete");
         var5 = true;
      }

      List var6 = var4.createQuery("from ManifestProduit where vteprdNumManifest = '" + var1 + "' and vteprdNum = '" + var2 + "' and vteprdRefTypeColis = '" + var3 + "' order by vteprdId").setMaxResults(1).list();
      this.manifestProduit = new ManifestProduit();
      if (var6.size() != 0) {
         this.manifestProduit = (ManifestProduit)var6.get(0);
      } else {
         this.manifestProduit = null;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return this.manifestProduit;
   }

   public ManifestProduit chargerLaLigne(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ManifestEntete");
         var4 = true;
      }

      this.manifestProduit = new ManifestProduit();
      List var5 = var3.createQuery("from ManifestProduit where vteprdId=:idfk").setLong("idfk", var1).list();
      if (var5.size() != 0) {
         this.manifestProduit = (ManifestProduit)var5.get(0);
      } else {
         this.manifestProduit = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.manifestProduit;
   }

   public List rechercheManifesteRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ManifestEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from ManifestProduit where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
