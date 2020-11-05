package com.epegase.systeme.dao;

import com.epegase.systeme.classe.MotifEntreeMedical;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class MotifEntreeMedicalDao implements Serializable {
   private MotifEntreeMedical motifEntreeMedical;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public MotifEntreeMedicalDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public MotifEntreeMedical insert(MotifEntreeMedical var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public MotifEntreeMedical modif(MotifEntreeMedical var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public String delete(long var1, Session var3) {
      Query var4 = var3.createQuery("delete from MotifEntreeMedical where mteId =:Sid");
      var4.setParameter("Sid", var1);
      var4.executeUpdate();
      return null;
   }

   public List selectMotifEntreeMedical(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "MotifEntreeMedical");
         var4 = true;
      }

      Query var5 = var3.createQuery("from MotifEntreeMedical where exerciceventes=:exo order by mteCode").setLong("exo", var1);
      Object var6 = new ArrayList();
      if (var5.list() != null) {
         var6 = var5.list();
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var6;
   }

   public List selectActifMotifentree(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "MotifEntreeMedical");
         var4 = true;
      }

      List var5 = var3.createQuery("from MotifEntreeMedical where exerciceventes=:exo and mteInactif=0 order by mteCode").setLong("exo", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectActifMotifEntreeItems(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "MotifEntreeMedical");
         var4 = true;
      }

      List var5 = var3.createQuery("from MotifEntreeMedical where exerciceventes=:exo and mteInactif=0 order by mteCode").setLong("exo", var1).list();
      ArrayList var6 = new ArrayList();
      if (var5.size() != 0) {
         new MotifEntreeMedical();

         for(int var8 = 0; var8 < var5.size(); ++var8) {
            MotifEntreeMedical var7 = (MotifEntreeMedical)var5.get(var8);
            var6.add(new SelectItem(var7.getMteCode() + ":" + var7.getMteLibelle()));
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public MotifEntreeMedical selectMotifEntreeMedical(long var1, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "MotifEntreeMedical");
         var5 = true;
      }

      this.motifEntreeMedical = null;
      Query var6 = var4.createQuery("from MotifEntreeMedical where exerciceventes=:exo and mteCode=:cod").setLong("exo", var1).setString("cod", var3).setMaxResults(1);
      new ArrayList();
      if (var6.list() != null) {
         List var7 = var6.list();
         if (var7.size() != 0) {
            this.motifEntreeMedical = (MotifEntreeMedical)var7.get(0);
         }
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return this.motifEntreeMedical;
   }
}
