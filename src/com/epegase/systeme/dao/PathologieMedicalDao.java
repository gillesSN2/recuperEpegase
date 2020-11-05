package com.epegase.systeme.dao;

import com.epegase.systeme.classe.PathologieMedical;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class PathologieMedicalDao implements Serializable {
   private PathologieMedical pathologieMedical;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public PathologieMedicalDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
   }

   public PathologieMedical insert(PathologieMedical var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public PathologieMedical modif(PathologieMedical var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public String delete(long var1, Session var3) {
      Query var4 = var3.createQuery("delete from PathologieMedical where phlId =:Sid");
      var4.setParameter("Sid", var1);
      var4.executeUpdate();
      return null;
   }

   public List selectPathologieMedical(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "PathologieMedical");
         var4 = true;
      }

      Query var5 = var3.createQuery("from PathologieMedical where exerciceventes=:exo order by phlCode").setLong("exo", var1);
      Object var6 = new ArrayList();
      if (var5.list() != null) {
         var6 = var5.list();
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var6;
   }

   public List selectActifPathologie(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "PathologieMedical");
         var4 = true;
      }

      List var5 = var3.createQuery("from PathologieMedical where exerciceventes=:exo and phlInactif=0 order by phlCode").setLong("exo", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectActifPathologieItems(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "PathologieMedical");
         var4 = true;
      }

      List var5 = var3.createQuery("from PathologieMedical where exerciceventes=:exo and phlInactif=0 order by phlCode").setLong("exo", var1).list();
      ArrayList var6 = new ArrayList();
      if (var5.size() != 0) {
         for(int var7 = 0; var7 < var5.size(); ++var7) {
            new PathologieMedical();
            PathologieMedical var8 = (PathologieMedical)var5.get(var7);
            var6.add(new SelectItem(var8.getPhlLibelle()));
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
