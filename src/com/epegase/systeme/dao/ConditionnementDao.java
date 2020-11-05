package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Conditionnement;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class ConditionnementDao implements Serializable {
   private Conditionnement produitsCondition;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public ConditionnementDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public Conditionnement insert(Conditionnement var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public Conditionnement modif(Conditionnement var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(Conditionnement var1, Session var2) {
      var2.delete(var1);
   }

   public List selectAll(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Unite");
         var2 = true;
      }

      Query var3 = var1.createQuery("from Conditionnement");
      Object var4 = new ArrayList();
      if (var3.list() != null) {
         var4 = var3.list();
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var4;
   }

   public List chargerLesConditionnements(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Unite");
         var2 = true;
      }

      List var3 = var1.createQuery("from Conditionnement").list();
      List var4 = var3;
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      var5.add(new SelectItem(""));
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            new Conditionnement();
            Conditionnement var7 = (Conditionnement)var4.get(var6);
            String var8 = "";
            if (var7.getCdtCodeUnite2() != null && !var7.getCdtCodeUnite2().isEmpty()) {
               var8 = var7.getCdtLibelle() + ":" + var7.getCdtCoef1() + ":" + var7.getCdtCodeUnite1() + "/" + var7.getCdtCoef2() + ":" + var7.getCdtCodeUnite2();
            } else {
               var8 = var7.getCdtLibelle() + ":" + var7.getCdtCoef1() + ":" + var7.getCdtCodeUnite1();
            }

            var5.add(new SelectItem(var8));
         }
      }

      return var5;
   }

   public Conditionnement rechercheConditionnement(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Unite");
         var3 = true;
      }

      new Conditionnement();
      List var5 = var2.createQuery("from Conditionnement where cdtLibelle=:cod").setString("cod", var1).setMaxResults(1).list();
      Conditionnement var4;
      if (var5.size() != 0) {
         var4 = (Conditionnement)var5.get(0);
      } else {
         var4 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public Conditionnement trouveConditionnement(String var1, float var2, String var3, float var4, String var5, float var6, Session var7) throws HibernateException, NamingException {
      boolean var8 = false;
      if (var7 == null) {
         var7 = this.utilInitHibernate.getOpenSession(this.maBase, "Unite");
         var8 = true;
      }

      new Conditionnement();
      List var10 = var7.createQuery("from Conditionnement where cdtLibelle=:lib and cdtCoef1=:q1 and cdtCodeUnite1=:c1 and cdtCoef2=:q2 and cdtCodeUnite2=:c2").setString("lib", var1).setFloat("q1", var2).setString("c1", var3).setFloat("q2", var4).setString("c2", var5).setMaxResults(1).list();
      Conditionnement var9;
      if (var10.size() != 0) {
         var9 = (Conditionnement)var10.get(0);
         if (var9.getCdtNb2() == 0.0F) {
            var9.setCdtNb2(var6);
         }

         if (var9.getCdtNb2() == 0.0F) {
            var9.setCdtNb2(1.0F);
         }
      } else {
         var10 = var7.createQuery("from Conditionnement where cdtLibelle=:lib and cdtCoef1=:q1 and cdtCodeUnite1=:c1 and cdtCodeUnite2=:c2").setString("lib", var1).setFloat("q1", var2).setString("c1", var3).setString("c2", var5).setMaxResults(1).list();
         if (var10.size() != 0) {
            var9 = (Conditionnement)var10.get(0);
            if (var9.getCdtNb2() == 0.0F) {
               var9.setCdtNb2(var6);
            }

            if (var9.getCdtNb2() == 0.0F) {
               var9.setCdtNb2(1.0F);
            }
         } else {
            var9 = null;
         }
      }

      if (var8) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }
}
