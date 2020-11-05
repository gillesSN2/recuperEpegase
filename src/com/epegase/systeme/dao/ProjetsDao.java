package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Projets;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class ProjetsDao implements Serializable {
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public ProjetsDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public Projets insert(Projets var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Projets");
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

   public Projets insert(Projets var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public Projets miseAjourProjet(Projets var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Projets");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         var2.saveOrUpdate(var1);
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

   public void delete(Projets var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Projets");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         var2.delete(var1);
         var3.commit();
      } catch (HibernateException var8) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var8;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void delete(Projets var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List selectAllProjets(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Projets");
         var3 = true;
      }

      Query var4 = var2.createQuery("FROM Projets where proChoixBudget=" + var1 + "order by proCode");
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectAllProjets(int var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Projets");
         var4 = true;
      }

      Query var5 = null;
      if (var2 == null || var2.isEmpty()) {
         var2 = "*";
      }

      if (var2.equals("*")) {
         var5 = var3.createQuery("FROM Projets where proChoixBudget=" + var1 + " order by proCode");
      } else {
         var5 = var3.createQuery("FROM Projets where proCode=:cod and proChoixBudget=:prj order by proCode").setString("cod", var2).setInteger("prj", var1);
      }

      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public boolean existCode(int var1, String var2) throws HibernateException, NamingException {
      boolean var3 = false;
      Session var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Projets");
      Criteria var5 = var4.createCriteria(Projets.class).add(Restrictions.eq("proCode", var2)).add(Restrictions.eq("proChoixBudget", var1));
      List var6 = var5.list();
      int var7 = var6.size();
      if (var7 > 0) {
         var3 = true;
      } else {
         var3 = false;
      }

      this.utilInitHibernate.closeSession();
      return var3;
   }

   public List chargerLesProjets(int var1, String var2, Session var3) throws HibernateException, NamingException, ParseException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Projets");
         var4 = true;
      }

      List var5 = var3.createQuery("from Projets where proInactif=0 and proChoixBudget=" + var1 + " order by proCode").list();
      List var6 = var5;
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var7 = new ArrayList();
      if (var5.size() != 0) {
         UtilDate var8 = new UtilDate();

         for(int var9 = 0; var9 < var6.size(); ++var9) {
            new Projets();
            Projets var10 = (Projets)var6.get(var9);
            boolean var11 = false;
            if (var10.getProAnnee().equals(var2)) {
               var11 = true;
            } else if (var10.getProDateEcheanceDeb() != null && !var10.getProDateEcheanceDeb().isEmpty()) {
               if (var10.getProDateEcheanceDeb().contains(":")) {
                  String[] var17 = var10.getProDateEcheanceDeb().split(":");

                  for(int var18 = 0; var18 < var17.length; ++var18) {
                     String var14 = var17[var18];
                     Date var15 = var8.stringToDateSQLLight(var14);
                     String var16 = "" + (var15.getYear() + 1900);
                     if (var16.equals(var2)) {
                        var11 = true;
                        break;
                     }
                  }
               } else {
                  Date var12 = var8.stringToDateSQLLight(var10.getProDateEcheanceDeb());
                  String var13 = "" + (var12.getYear() + 1900);
                  if (var13.equals(var2)) {
                     var11 = true;
                  }
               }
            }

            if (var11) {
               var7.add(new SelectItem(var10.getProCode() + ":" + var10.getProNomFR()));
            }
         }
      }

      return var7;
   }

   public List chargerLesProjets(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Projets");
         var3 = true;
      }

      List var4 = var2.createQuery("from Projets where proInactif=0 and proChoixBudget=" + var1 + " order by proCode").list();
      List var5 = var4;
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var6 = new ArrayList();
      if (var4.size() != 0) {
         for(int var7 = 0; var7 < var5.size(); ++var7) {
            var6.add(new SelectItem(((Projets)var5.get(var7)).getProCode() + ":" + ((Projets)var5.get(var7)).getProNomFR()));
         }
      }

      return var6;
   }

   public Projets chargerLeProjet(int var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Projets");
         var4 = true;
      }

      String var5 = "";
      if (var2 != null && !var2.isEmpty() && var2.contains(":")) {
         String[] var6 = var2.split(":");
         var5 = var6[0];
      } else {
         var5 = var2;
      }

      new Projets();
      List var7 = var3.createQuery("from Projets where proInactif=0 and proCode=:cod and proChoixBudget=:prj order by proCode").setString("cod", var5).setInteger("prj", var1).setMaxResults(1).list();
      Projets var9;
      if (var7.size() != 0) {
         var9 = (Projets)var7.get(0);
      } else {
         var9 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }
}
