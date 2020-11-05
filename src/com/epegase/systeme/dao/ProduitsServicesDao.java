package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsServices;
import com.epegase.systeme.classe.Service;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProduitsServicesDao implements Serializable {
   private ProduitsServices produitsServices;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public ProduitsServicesDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public ProduitsServices insert(ProduitsServices var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
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

   public void delete(ProduitsServices var1, Session var2) {
      var2.delete(var1);
   }

   public String deletProdService(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
      Transaction var4 = var3.beginTransaction();
      var4.begin();
      Query var5 = var3.createQuery("delete from ProduitsServices where proserId =:Sid");
      var5.setParameter("Sid", var1);
      var5.executeUpdate();
      var4.commit();
      this.utilInitHibernate.closeSession();
      return null;
   }

   public ProduitsServices insert(ProduitsServices var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public List selectProdServiceByprod(Produits var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var3 = true;
      }

      Query var4 = var2.createQuery("from ProduitsServices where pro_id=:id");
      var4.setParameter("id", var1.getProId());
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectProdServiceByservVtes(Service var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsVtes");
         var4 = true;
      }

      Query var5 = null;
      if (var2 != null && !var2.isEmpty()) {
         if (var2.equals("*")) {
            var5 = var3.createQuery("from ProduitsServices where services=:ser and produits.proVteCode<>''").setParameter("ser", var1);
         } else if (var2.contains("*") && var2.length() >= 2) {
            String var6 = var2.substring(1);
            var5 = var3.createQuery("from ProduitsServices where services=:ser and produits.proVteCode<>'' and (produits.proCode LIKE '%" + var6 + "%' or produits.proLibClient LIKE '%" + var6 + "%' or produits.proLibTech LIKE '%" + var6 + "%')").setParameter("ser", var1);
         } else {
            var5 = var3.createQuery("from ProduitsServices where services=:ser and produits.proVteCode<>'' and (produits.proCode LIKE '" + var2 + "%' or produits.proLibClient LIKE '" + var2 + "%' or produits.proLibTech LIKE '" + var2 + "%')").setParameter("ser", var1);
         }
      } else {
         var5 = var3.createQuery("from ProduitsServices where services=:ser and produits.proVteCode<>''").setParameter("ser", var1);
      }

      var5.setParameter("ser", var1);
      List var7 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List selectProdServiceByservMedical(Service var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsVtes");
         var4 = true;
      }

      Query var5 = null;
      if (var2 != null && !var2.isEmpty()) {
         if (var2.equals("*")) {
            var5 = var3.createQuery("from ProduitsServices where services=:ser and produits.proVteNat is not null and produits.proVteNat<>'' and produits.proVteCode is not null and produits.proVteCode<>''").setParameter("ser", var1);
         } else if (var2.contains("*") && var2.length() >= 2) {
            String var6 = var2.substring(1);
            var5 = var3.createQuery("from ProduitsServices where services=:ser and produits.proVteNat is not null and produits.proVteNat<>'' and produits.proVteCode<>'' and (produits.proCode LIKE '%" + var6 + "%' or produits.proLibClient LIKE '%" + var6 + "%' or produits.proLibTech LIKE '%" + var6 + "%')").setParameter("ser", var1);
         } else {
            var5 = var3.createQuery("from ProduitsServices where services=:ser and produits.proVteNat is not null and produits.proVteNat<>'' and produits.proVteCode<>'' and (produits.proCode LIKE '" + var2 + "%' or produits.proLibClient LIKE '" + var2 + "%' or produits.proLibTech LIKE '" + var2 + "%')").setParameter("ser", var1);
         }
      } else {
         var5 = var3.createQuery("from ProduitsServices where services=:ser and produits.proVteNat is not null and produits.proVteNat<>'' and produits.proVteCode is not null and produits.proVteCode<>''").setParameter("ser", var1);
      }

      var5.setParameter("ser", var1);
      List var7 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List selectProdServiceByservAchs(Service var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var5 = true;
      }

      Query var6 = null;
      String var7 = "";
      if (var3 != null && !var3.isEmpty() && !var3.equals("9")) {
         if (var3.equals("0")) {
            var7 = " and produits.proMode=0";
         } else if (var3.equals("1")) {
            var7 = " and produits.proMode=1";
         } else if (var3.equals("2")) {
            var7 = " and produits.proMode=2";
         } else if (var3.equals("3")) {
            var7 = " and produits.proMode=3";
         } else if (var3.equals("4")) {
            var7 = " and produits.proMode=4";
         } else if (var3.equals("5")) {
            var7 = " and produits.proMode=5";
         }
      }

      if (var2 != null && !var2.isEmpty()) {
         if (var2.equals("*")) {
            var6 = var4.createQuery("from ProduitsServices where services=:ser" + var7).setParameter("ser", var1);
         } else if (var2.contains("*") && var2.length() >= 2) {
            String var8 = var2.substring(1);
            var6 = var4.createQuery("from ProduitsServices where services=:ser and (produits.proCode LIKE '%" + var8 + "%' or produits.proLibClient LIKE '%" + var8 + "%')" + var7).setParameter("ser", var1);
         } else {
            var6 = var4.createQuery("from ProduitsServices where services=:ser and (produits.proCode LIKE '" + var2 + "%' or produits.proLibClient LIKE '" + var2 + "%')" + var7).setParameter("ser", var1);
         }
      } else {
         var6 = var4.createQuery("from ProduitsServices where services=:ser" + var7).setParameter("ser", var1);
      }

      List var9 = var6.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public List selectProdServiceByservAchs(Service var1, String var2, String var3, String var4, String var5, String var6, String var7, int var8, String var9, Session var10) throws HibernateException, NamingException {
      boolean var11 = false;
      if (var10 == null) {
         var10 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var11 = true;
      }

      String var12 = "";
      String var13;
      if (var2 != null && !var2.isEmpty()) {
         var13 = "";
         if (var2.startsWith("*")) {
            var13 = "%" + var2.substring(1) + "%";
         } else {
            var13 = var2 + "%";
         }

         var12 = var12 + " and produits.proCode like '" + var13 + "'";
      }

      if (var3 != null && !var3.isEmpty()) {
         var13 = "";
         if (var3.startsWith("*")) {
            var13 = "%" + var3.substring(1) + "%";
         } else {
            var13 = var3 + "%";
         }

         var12 = var12 + " and produits.proLibClient like '" + var13 + "'";
      }

      if (var4 != null && !var4.isEmpty()) {
         var12 = var12 + " and (produits.proAchNat = '" + var4 + "' or produits.proVteNat = '" + var4 + "')";
      }

      if (var5 != null && !var5.isEmpty()) {
         var12 = var12 + " and produits.proMarque = '" + var5 + "'";
      }

      if (var6 != null && !var6.isEmpty()) {
         var12 = var12 + " and (produits.proAchCode like '" + var6 + "%' or produits.proVteCode like '" + var6 + "%')";
      }

      if (var7 != null && !var7.isEmpty()) {
         var12 = var12 + " and (produits.proActivite like '" + var7 + "%'";
      }

      if (var8 == 0) {
         var12 = var12 + " and produits.proInactif=0";
      } else if (var8 == 1) {
         var12 = var12 + " and produits.proInactif=1";
      } else if (var8 == 2) {
         var12 = var12 + " and produits.proInactif=2";
      }

      if (var9 != null && !var9.isEmpty() && !var9.equals("9")) {
         if (var9.equals("0")) {
            var12 = var12 + " and produits.proMode=0";
         } else if (var9.equals("1")) {
            var12 = var12 + " and produits.proMode=1";
         } else if (var9.equals("2")) {
            var12 = var12 + " and produits.proMode=2";
         } else if (var9.equals("3")) {
            var12 = var12 + " and produits.proMode=3";
         } else if (var9.equals("4")) {
            var12 = var12 + " and produits.proMode=4";
         } else if (var9.equals("5")) {
            var12 = var12 + " and produits.proMode=5";
         }
      }

      Query var15 = var10.createQuery("from ProduitsServices where  services=:ser " + var12).setParameter("ser", var1);
      List var14 = var15.list();
      if (var11) {
         this.utilInitHibernate.closeSession();
      }

      return var14;
   }

   public List selectProdServiceByservAchs(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var2 = true;
      }

      Query var3 = var1.createQuery("from ProduitsServices");
      List var4 = var3.list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List verifProduitsMedicaux(String var1, String var2, Service var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsVtes");
         var5 = true;
      }

      String var6 = "";
      String var7;
      if (var1.equals("*")) {
         var6 = "";
      } else if (var1.contains("*") && var1.length() >= 2) {
         var7 = var1.substring(1);
         var6 = "and (produits.proCode LIKE '%" + var7 + "%' or produits.proLibClient LIKE '%" + var7 + "%' or  produits.proLibTech LIKE '%" + var7 + "%')";
      } else {
         var6 = "and (produits.proCode LIKE '" + var1 + "%' or produits.proLibClient LIKE '" + var1 + "%' or produits.proLibTech LIKE '%" + var1 + "%')";
      }

      var7 = null;
      Query var9;
      if (var2 != null && !var2.isEmpty()) {
         if (var3 != null) {
            var9 = var4.createQuery("from ProduitsServices where services=:ser and produits.proVteNat='" + var2 + "' " + var6 + " and produits.proInactif=0 order by produits.proCode asc").setParameter("ser", var3);
         } else {
            var9 = var4.createQuery("from ProduitsServices where produits.proVteNat='" + var2 + "' " + var6 + " and produits.proInactif=0 order by produits.proCode asc");
         }
      } else if (var3 != null) {
         var9 = var4.createQuery("from ProduitsServices where services=:ser and produits.proVteNat like '11%' " + var6 + " and produits.proInactif=0 order by produits.proCode asc").setParameter("ser", var3);
      } else {
         var9 = var4.createQuery("from ProduitsServices where produits.proVteNat like '11%' " + var6 + " and produits.proInactif=0 order by produits.proCode asc");
      }

      List var8 = var9.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public ProduitsServices selectCode(Produits var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var4 = true;
      }

      Query var5 = var3.createQuery("from ProduitsServices where produits=:pro and proserCode=:co order by proserCode desc").setParameter("pro", var1).setString("co", var2).setMaxResults(1);
      if (var5.list() != null) {
         List var6 = var5.list();
         if (var6.size() > 0) {
            ProduitsServices var7 = (ProduitsServices)var6.get(0);
            if (var4) {
               this.utilInitHibernate.closeSession();
            }

            return var7;
         } else {
            if (var4) {
               this.utilInitHibernate.closeSession();
            }

            return null;
         }
      } else {
         if (var4) {
            this.utilInitHibernate.closeSession();
         }

         return null;
      }
   }
}
