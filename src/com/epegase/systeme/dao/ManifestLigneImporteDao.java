package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ManifestLigneImport;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class ManifestLigneImporteDao implements Serializable {
   private ManifestLigneImport manifestLigneImport;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ManifestLigneImporteDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public ManifestLigneImport modifLigne(ManifestLigneImport var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void deleteOneLigne(ManifestLigneImport var1, Session var2) {
      var2.delete(var1);
   }

   public List chargerLesLignesGroupe(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ManifestEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from ManifestLigneImport where vtelvNumManifest=:num group by vtelvNum order by vtelvId").setString("num", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignes(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ManifestEntete");
         var3 = true;
      }

      List var4 = null;
      if (var1 != null && !var1.isEmpty()) {
         var4 = var2.createQuery("from ManifestLigneImport where vtelvNumManifest=:num order by vtelvId").setString("num", var1).list();
      } else {
         var4 = var2.createQuery("from ManifestLigneImport order by vtelvId").list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerToutesLesLignes(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "ManifestEntete");
         var2 = true;
      }

      List var3 = var1.createQuery("from ManifestLigneImport order by vtelvId").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }
}
