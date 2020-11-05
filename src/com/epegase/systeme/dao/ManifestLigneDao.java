package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ManifestEntete;
import com.epegase.systeme.classe.ManifestLigne;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ManifestLigneDao implements Serializable {
   private ManifestLigne manifestLigne;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ManifestLigneDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public ManifestLigne insertLigne(ManifestLigne var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ManifestEntete");
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

   public ManifestLigne insertLigne(ManifestLigne var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public ManifestLigne modifLigne(ManifestLigne var1, Session var2) {
      var2.saveOrUpdate(var1);
      return var1;
   }

   public void deleteAllLigne(ManifestEntete var1, Session var2) {
      var2.createQuery("delete from ManifestLigne where manifestEntete=:id").setLong("id", var1.getVtemanId()).executeUpdate();
   }

   public String deleteOneLigne(ManifestLigne var1, Session var2) {
      Query var3 = var2.createQuery("delete from ManifestLigne where vtelvId =" + var1.getVtelvId());
      var3.executeUpdate();
      return "";
   }

   public List chargerLesLignesGroupe(ManifestEntete var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ManifestEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from ManifestLigne where (manifestEntete=:idfk or vtelvNumManifest=:num) group by vtelvNum order by vtelvId").setLong("idfk", var1.getVtemanId()).setString("num", var1.getVtemanNum()).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignes(ManifestEntete var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ManifestEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from ManifestLigne where (manifestEntete=:idfk or vtelvNumManifest=:num) order by vtelvId").setLong("idfk", var1.getVtemanId()).setString("num", var1.getVtemanNum()).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignesByLv(ManifestEntete var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ManifestEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("from ManifestLigne where (manifestEntete=:idfk or vtelvNumManifest=:num) and vtelvNum=:numLv order by vtelvId").setLong("idfk", var1.getVtemanId()).setString("num", var1.getVtemanNum()).setString("numLv", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesLignesManifeste(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ManifestEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from ManifestLigne where manifestEntete.vtemanNum in (" + var1 + ") order by vtelvId").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public ManifestLigne chargerLaLigne(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ManifestEntete");
         var4 = true;
      }

      this.manifestLigne = new ManifestLigne();
      List var5 = var3.createQuery("from ManifestLigne where vtelvId=:idfk").setLong("idfk", var1).list();
      if (var5.size() != 0) {
         this.manifestLigne = (ManifestLigne)var5.get(0);
      } else {
         this.manifestLigne = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.manifestLigne;
   }

   public ManifestLigne chargerLaLigne(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ManifestEntete");
         var4 = true;
      }

      this.manifestLigne = new ManifestLigne();
      List var5 = var3.createQuery("from ManifestLigne where vtelvNumManifest=:nMan and vtelvNum=:nLv").setString("nMan", var1).setString("nLv", var2).setMaxResults(1).list();
      if (var5.size() != 0) {
         this.manifestLigne = (ManifestLigne)var5.get(0);
      } else {
         this.manifestLigne = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.manifestLigne;
   }

   public List chargerLesMvts(String var1, Session var2) {
      List var3 = null;
      var3 = var2.createQuery("from ManifestLigne where vtelvRefTypeColis='" + var1 + "'").list();
      return var3;
   }

   public List rechercheManifesteRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ManifestEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from ManifestLigne where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
