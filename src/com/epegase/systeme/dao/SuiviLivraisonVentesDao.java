package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.SuiviLivraisonVentes;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class SuiviLivraisonVentesDao implements Serializable {
   private SuiviLivraisonVentes suiviLivraisonVentes;
   private ExercicesVentes exercicesVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public SuiviLivraisonVentesDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public SuiviLivraisonVentes insert(SuiviLivraisonVentes var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public SuiviLivraisonVentes modif(SuiviLivraisonVentes var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public String deletSuiviLivraisonVentes(long var1, Session var3) {
      Query var4 = var3.createQuery("delete from SuiviLivraisonVentes where suivteId =:Sid");
      var4.setParameter("Sid", var1);
      var4.executeUpdate();
      return null;
   }

   public ExercicesVentes selectActuelExo(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "SuiviLivraisonVentes");
         var2 = true;
      }

      Query var3 = var1.createQuery("from ExercicesVentes order by exevteId desc");
      var3.setMaxResults(1);
      List var4 = var3.list();
      ExercicesVentes var5 = (ExercicesVentes)var4.get(0);
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectSuiviLivraisonVentes(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "SuiviLivraisonVentes");
         var4 = true;
      }

      Query var5 = var3.createQuery("from SuiviLivraisonVentes where exerciceventes=:exo").setLong("exo", var1);
      Object var6 = new ArrayList();
      if (var5.list() != null) {
         var6 = var5.list();
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var6;
   }

   public SuiviLivraisonVentes selectCode(long var1, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "SuiviLivraisonVentes");
         var5 = true;
      }

      Query var6 = var4.createQuery("from SuiviLivraisonVentes where exerciceventes=:exo and suivteCode=:cod order by suivteCode desc").setLong("exo", var1).setString("cod", var3);
      SuiviLivraisonVentes var7 = null;
      if (var6.list() != null) {
         var6.setMaxResults(1);
         List var8 = var6.list();
         if (var8.size() > 0) {
            var7 = (SuiviLivraisonVentes)var8.get(0);
         }
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }
}
