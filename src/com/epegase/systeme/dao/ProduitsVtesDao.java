package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsFournisseur;
import com.epegase.systeme.classe.ProduitsHistoRef;
import com.epegase.systeme.classe.ProduitsMcles;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class ProduitsVtesDao implements Serializable {
   private Produits produits;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public ProduitsVtesDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public Produits insert(Produits var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsVtes");
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

   public Produits insert(Produits var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public Produits modifProduit(Produits var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsVtes");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         var2.update(var1);
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

   public Produits modifProduit(Produits var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void modifListProduit(List var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsVtes");
      if (var1.size() > 0) {
         Transaction var3 = var2.beginTransaction();

         for(int var4 = 0; var4 < var1.size(); ++var4) {
            var2.update(var1.get(var4));
         }

         var3.commit();
      }

      this.utilInitHibernate.closeSession();
   }

   public List selectAllProduits(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsVtes");
         var2 = true;
      }

      List var3 = var1.createQuery("from Produits where (proVteCode<>'' and proVteCode is not null) order by proCode").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List selectProduitsByLibelle(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsVtes");
         var3 = true;
      }

      List var4 = var2.createQuery("from Produits where (proVteCode<>'' and proVteCode is not null) and proLibClient like '%" + var1 + "%' order by proCode").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List selectAllProduitsSansAchat(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsVtes");
         var2 = true;
      }

      List var3 = var1.createQuery("from Produits where (proVteCode<>'' and proVteCode is not null) and (proAchCode='' or proAchCode is null)").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public boolean existCode(String var1) throws HibernateException, NamingException {
      boolean var2 = false;
      Session var3 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsVtes");
      Query var4 = var3.createQuery("from Produits pr where pr.proCode=:cod").setString("cod", var1);
      var4.setMaxResults(1);
      List var5 = var4.list();
      if (var5.size() > 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.utilInitHibernate.closeSession();
      return var2;
   }

   public List selectFindProduit(String var1, String var2, String var3, String var4, String var5, String var6, int var7, String var8, Session var9) throws HibernateException, NamingException {
      boolean var10 = false;
      if (var9 == null) {
         var9 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsVtes");
         var10 = true;
      }

      boolean var11 = true;
      String var12 = "";
      String var13 = "null";
      new ArrayList();
      Criteria var15 = var9.createCriteria(Produits.class);
      var15 = var15.add(Restrictions.ne("proVteCode", var12)).add(Restrictions.ne("proVteCode", var13)).addOrder(Order.asc("proCode"));
      String var16;
      if (var1 != null && !var1.isEmpty()) {
         var16 = "";
         if (var2.startsWith("*")) {
            var16 = "%" + var1.substring(1) + "%";
         } else {
            var16 = var1 + "%";
         }

         var15 = var15.add(Restrictions.or(Restrictions.like("proCode", var16), Restrictions.like("proBarre", var16)));
      }

      if (var2 != null && !var2.isEmpty()) {
         var16 = "";
         if (var2.startsWith("*")) {
            var16 = "%" + var2.substring(1) + "%";
         } else {
            var16 = var2 + "%";
         }

         var15 = var15.add(Restrictions.or(Restrictions.like("proLibClient", var16), Restrictions.like("proLibTech", var16)));
      }

      if (var3 != null && !var3.isEmpty()) {
         var15 = var15.add(Restrictions.eq("proVteNat", var3));
      }

      if (var4 != null && !var4.isEmpty()) {
         var15 = var15.add(Restrictions.eq("proMarque", var4));
      }

      if (var5 != null && !var5.isEmpty()) {
         var15 = var15.add(Restrictions.like("proVteCode", var5 + "%"));
         var11 = false;
      }

      if (var6 != null && !var6.isEmpty()) {
         var15 = var15.add(Restrictions.eq("proActivite", var6));
      }

      if (var7 == 0) {
         var15 = var15.add(Restrictions.eq("proInactif", 0));
      } else if (var7 == 1) {
         var15 = var15.add(Restrictions.eq("proInactif", 1));
      } else if (var7 == 2) {
         var15 = var15.add(Restrictions.eq("proInactif", 2));
      }

      if (var8 != null && !var8.isEmpty() && !var8.equals("9")) {
         if (var8.equals("0")) {
            var15 = var15.add(Restrictions.eq("proMode", 0));
         } else if (var8.equals("1")) {
            var15 = var15.add(Restrictions.eq("proMode", 1));
         } else if (var8.equals("2")) {
            var15 = var15.add(Restrictions.eq("proMode", 2));
         } else if (var8.equals("3")) {
            var15 = var15.add(Restrictions.eq("proMode", 3));
         } else if (var8.equals("4")) {
            var15 = var15.add(Restrictions.eq("proMode", 4));
         } else if (var8.equals("5")) {
            var15 = var15.add(Restrictions.eq("proMode", 5));
         }
      }

      var15 = var15.addOrder(Order.asc("proCode"));
      List var24 = var15.list();
      List var14 = var24;
      if (var11 && var1 != null && !var1.isEmpty()) {
         String var17 = "";
         if (var1.equals("*")) {
            var17 = "";
         } else if (var1.contains("*") && var1.length() >= 2) {
            String var18 = var1.substring(1);
            var17 = "and (profouRef LIKE '" + var18 + "%' or profouLib LIKE '%" + var18 + "%' or profouLib LIKE '%" + var18 + "%')";
         } else {
            var17 = "and (profouRef LIKE '" + var1 + "%' or profouLib LIKE '" + var1 + "%' or profouLib LIKE '" + var1 + "%')";
         }

         Query var23 = null;
         if (var7 == 0) {
            var23 = var9.createQuery("from ProduitsFournisseur where (produits.proVteCode<>'' and produits.proVteCode is not null) " + var17 + " and produits.proInactif=0 order by profouRef asc");
         } else if (var7 == 1) {
            var23 = var9.createQuery("from ProduitsFournisseur where (produits.proVteCode<>'' and produits.proVteCode is not null) " + var17 + " and produits.proInactif=1 order by profouRef asc");
         } else if (var7 == 2) {
            var23 = var9.createQuery("from ProduitsFournisseur where (produits.proVteCode<>'' and produits.proVteCode is not null) " + var17 + " and produits.proInactif=2 order by profouRef asc");
         }

         List var19 = var23.list();
         if (var19.size() != 0) {
            boolean var20 = false;

            for(int var21 = 0; var21 < var19.size(); ++var21) {
               if (var14.size() == 0) {
                  this.produits = ((ProduitsFournisseur)var19.get(var21)).getProduits();
                  this.produits.setProLibTech(((ProduitsFournisseur)var19.get(var21)).getProfouRef() + ":" + this.produits.getProLibTech());
                  var14.add(this.produits);
               } else {
                  for(int var22 = 0; var22 < var14.size(); ++var22) {
                     if (((Produits)var14.get(var22)).getProId() == ((ProduitsFournisseur)var19.get(var21)).getProduits().getProId()) {
                        var20 = true;
                        break;
                     }
                  }

                  if (!var20) {
                     this.produits = ((ProduitsFournisseur)var19.get(var21)).getProduits();
                     this.produits.setProLibTech(((ProduitsFournisseur)var19.get(var21)).getProfouRef() + ":" + this.produits.getProLibTech());
                     var14.add(this.produits);
                  }
               }
            }
         }
      }

      if (var10) {
         this.utilInitHibernate.closeSession();
      }

      return var14;
   }

   public List selectFindProduitMedical(String var1, String var2, String var3, String var4, String var5, String var6, int var7, Session var8) throws HibernateException, NamingException {
      boolean var9 = false;
      if (var8 == null) {
         var8 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsVtes");
         var9 = true;
      }

      boolean var10 = true;
      String var11 = "";
      String var12 = "null";
      new ArrayList();
      Criteria var14 = var8.createCriteria(Produits.class);
      var14 = var14.add(Restrictions.isNotNull("proVteCode")).add(Restrictions.ne("proVteCode", var11));
      var14 = var14.add(Restrictions.isNotNull("proVteNat")).add(Restrictions.ne("proVteNat", var11));
      var14 = var14.add(Restrictions.ne("proVteCode", var11)).add(Restrictions.ne("proVteCode", var12)).addOrder(Order.asc("proCode"));
      String var15;
      if (var1 != null && !var1.isEmpty()) {
         var15 = "";
         if (var2.startsWith("*")) {
            var15 = "%" + var1.substring(1) + "%";
         } else {
            var15 = var1 + "%";
         }

         var14 = var14.add(Restrictions.or(Restrictions.like("proCode", var15), Restrictions.like("proBarre", var15)));
      }

      if (var2 != null && !var2.isEmpty()) {
         var15 = "";
         if (var2.startsWith("*")) {
            var15 = "%" + var2.substring(1) + "%";
         } else {
            var15 = var2 + "%";
         }

         var14 = var14.add(Restrictions.or(Restrictions.like("proLibClient", var15), Restrictions.like("proLibTech", var15)));
      }

      if (var3 != null && !var3.isEmpty()) {
         var14 = var14.add(Restrictions.eq("proVteNat", var3));
      }

      if (var4 != null && !var4.isEmpty()) {
         var14 = var14.add(Restrictions.eq("proMarque", var4));
      }

      if (var5 != null && !var5.isEmpty()) {
         var14 = var14.add(Restrictions.like("proVteCode", var5 + "%"));
         var10 = false;
      }

      if (var6 != null && !var6.isEmpty()) {
         var14 = var14.add(Restrictions.eq("proActivite", var6));
      }

      if (var7 == 0) {
         var14 = var14.add(Restrictions.eq("proInactif", 0));
      } else if (var7 == 1) {
         var14 = var14.add(Restrictions.eq("proInactif", 1));
      } else if (var7 == 2) {
         var14 = var14.add(Restrictions.eq("proInactif", 2));
      }

      var14 = var14.addOrder(Order.asc("proCode"));
      List var23 = var14.list();
      List var13 = var23;
      if (var10) {
         String var16 = "";
         if (var1.equals("*")) {
            var16 = "";
         } else if (var1.contains("*") && var1.length() >= 2) {
            String var17 = var1.substring(1);
            var16 = "and (profouRef LIKE '" + var17 + "%' or profouLib LIKE '%" + var17 + "%' or profouLib LIKE '%" + var17 + "%')";
         } else {
            var16 = "and (profouRef LIKE '" + var1 + "%' or profouLib LIKE '" + var1 + "%' or profouLib LIKE '" + var1 + "%')";
         }

         Query var22 = null;
         if (var7 == 0) {
            var22 = var8.createQuery("from ProduitsFournisseur where (produits.proVteCode<>'' and produits.proVteCode is not null) " + var16 + " and produits.proInactif=0 order by profouRef asc");
         } else if (var7 == 1) {
            var22 = var8.createQuery("from ProduitsFournisseur where (produits.proVteCode<>'' and produits.proVteCode is not null) " + var16 + " and produits.proInactif=1 order by profouRef asc");
         } else if (var7 == 2) {
            var22 = var8.createQuery("from ProduitsFournisseur where (produits.proVteCode<>'' and produits.proVteCode is not null) " + var16 + " and produits.proInactif=2 order by profouRef asc");
         }

         List var18 = var22.list();
         if (var18.size() != 0) {
            boolean var19 = false;

            for(int var20 = 0; var20 < var18.size(); ++var20) {
               if (var13.size() == 0) {
                  this.produits = ((ProduitsFournisseur)var18.get(var20)).getProduits();
                  this.produits.setProLibTech(((ProduitsFournisseur)var18.get(var20)).getProfouRef() + ":" + this.produits.getProLibTech());
                  var13.add(this.produits);
               } else {
                  for(int var21 = 0; var21 < var13.size(); ++var21) {
                     if (((Produits)var13.get(var21)).getProId() == ((ProduitsFournisseur)var18.get(var20)).getProduits().getProId()) {
                        var19 = true;
                        break;
                     }
                  }

                  if (!var19) {
                     this.produits = ((ProduitsFournisseur)var18.get(var20)).getProduits();
                     this.produits.setProLibTech(((ProduitsFournisseur)var18.get(var20)).getProfouRef() + ":" + this.produits.getProLibTech());
                     var13.add(this.produits);
                  }
               }
            }
         }
      }

      if (var9) {
         this.utilInitHibernate.closeSession();
      }

      return var13;
   }

   public List selectFindProduitSer(String var1, String var2, String var3, String var4, String var5, String var6, int var7, Session var8) throws HibernateException, NamingException {
      boolean var9 = false;
      if (var8 == null) {
         var8 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsVtes");
         var9 = true;
      }

      String var10 = "";
      String var11 = "";
      String var12 = "";
      String var13 = "";
      String var14 = "";
      String var15 = "";
      String var16 = "";
      if (var1.equalsIgnoreCase("")) {
         var10 = "";
      } else {
         var10 = " and proCode='" + var1 + "' or proBarre = '" + var1 + "'";
      }

      if (var2.equalsIgnoreCase("")) {
         var11 = "";
      } else {
         var11 = " and proLibClient='" + var2 + "'";
      }

      if (var3.equalsIgnoreCase("")) {
         var12 = "";
      } else {
         var12 = " and proVteNat='" + var3 + "'";
      }

      if (var4.equalsIgnoreCase("")) {
         var13 = "";
      } else {
         var13 = " and proVteCode='" + var4 + "'";
      }

      if (var5.equalsIgnoreCase("")) {
         var14 = "";
      } else {
         var14 = " and proActivite='" + var5 + "'";
      }

      if (var7 == 0) {
         var15 = " and proInactif=0";
      } else if (var7 == 1) {
         var15 = " and proInactif=1";
      } else if (var7 == 2) {
         var15 = " and proInactif=2";
      }

      var16 = var10 + var11 + var12 + var13 + var14 + var15;
      Query var17 = var8.createQuery("from Produits where (proVteCode<>'' and proVteCode is not null) " + var16 + " and proId in " + var6 + "order by proCode asc");
      List var18 = var17.list();
      if (var9) {
         this.utilInitHibernate.closeSession();
      }

      return var18;
   }

   public List selectFindProduitSerMedical(String var1, String var2, String var3, String var4, String var5, String var6, int var7, Session var8) throws HibernateException, NamingException {
      boolean var9 = false;
      if (var8 == null) {
         var8 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsVtes");
         var9 = true;
      }

      String var10 = "";
      String var11 = "";
      String var12 = "";
      String var13 = "";
      String var14 = "";
      String var15 = "";
      String var16 = "";
      if (var1 != null && !var1.isEmpty() && !var1.equals("*")) {
         var10 = " and proCode='" + var1 + "' or proBarre = '" + var1 + "'";
      } else {
         var10 = "";
      }

      if (var2 != null && !var2.isEmpty()) {
         var11 = " and proLibClient='" + var2 + "'";
      } else {
         var11 = "";
      }

      if (var3 != null && !var3.isEmpty()) {
         var12 = " and proVteNat='" + var3 + "'";
      } else {
         var12 = "and proVteNat like '11%'";
      }

      if (var4 != null && !var4.isEmpty()) {
         var13 = " and proVteCode='" + var4 + "'";
      } else {
         var13 = "";
      }

      if (var5 != null && !var5.isEmpty()) {
         var14 = " and proActivite='" + var5 + "'";
      } else {
         var14 = "";
      }

      if (var7 == 0) {
         var15 = " and proInactif=0";
      } else if (var7 == 1) {
         var15 = " and proInactif=1";
      } else if (var7 == 2) {
         var15 = " and proInactif=2";
      }

      var16 = var10 + var11 + var12 + var13 + var14 + var15;
      Query var17 = var8.createQuery("from Produits where (proVteCode<>'' and proVteCode is not null) and (proVteNat<>'' and proVteNat is not null) " + var16 + " and proId in " + var6 + "order by proCode asc");
      List var18 = var17.list();
      if (var9) {
         this.utilInitHibernate.closeSession();
      }

      return var18;
   }

   public List selectEgalProduits(String var1, Session var2) {
      Query var3 = var2.createQuery("from Produits where (proVteCode<>'' and proVteCode is not null) and proId in " + var1);
      List var4 = var3.list();
      return var4 != null ? var4 : null;
   }

   public long lastProduit(Session var1, int var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsVtes");
         var3 = true;
      }

      Query var4 = var1.createQuery("from Produits order by proId desc").setMaxResults(1);
      List var5 = var4.list();
      long var6 = 1L;
      if (var5.size() != 0) {
         if (var2 == 2) {
            var6 = ((Produits)var5.get(0)).getProId() + 1L;
         } else if (var2 == 3) {
            var4 = (Query)var1.createQuery("SELECT COUNT(*) FROM Produits").uniqueResult();
            int var8 = Integer.parseInt(var4.toString());
            var6 = (long)(var8 + 1);
         } else if (var2 == 4) {
            var4 = var1.createQuery("from Produits order by proCode desc").setMaxResults(1);
            var5 = var4.list();
            var6 = Long.parseLong(((Produits)var5.get(0)).getProCode()) + 1L;
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesProduitsVentesByGenerique(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsVtes");
         var3 = true;
      }

      List var4 = var2.createQuery("from Produits where proLibTech=:generique and proMode<>5 and (proVteCode<>'' and proVteCode is not null) and proInactif=0 group by proCode order by proCode desc").setString("generique", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesProduitsVentesByFamille(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsVtes");
         var3 = true;
      }

      List var4 = var2.createQuery("from Produits where proVteCode=:fam order by proCode desc").setString("fam", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesProduitsVentesByMarque(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsVtes");
         var3 = true;
      }

      List var4 = var2.createQuery("from Produits where (proVteCode<>'' and proVteCode is not null) and proMarque=:mar group by proVteCode order by proVteCode").setString("mar", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesProduitsVentesByGamme(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsVtes");
         var4 = true;
      }

      List var5 = var3.createQuery("from Produits where proVteCode like '" + var1 + "%' and proMarque=:mar group by proVteCode order by proVteCode").setString("mar", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesProduitsVentesByModele(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsVtes");
         var4 = true;
      }

      List var5 = var3.createQuery("from Produits where proMarque=:mar and proVteCode=:gam order by proCode").setString("mar", var1).setString("gam", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public long lastProduitByFamille(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsVtes");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Produits where proVteCode='" + var1 + "' order by proCode desc").setMaxResults(1);
      new ArrayList();
      List var5 = var4.list();
      long var6 = 1L;
      if (var5.size() != 0) {
         String var8 = "";
         var8 = ((Produits)var5.get(0)).getProCode();
         if (var8 != null && !var8.isEmpty() && var8.contains("-")) {
            String[] var9 = var8.split("-");
            var6 = Long.parseLong(var9[1]) + 1L;
         } else {
            var6 = 1L;
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public long nbProduitByFamilleVte(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsVtes");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Produits where proVteCode='" + var1 + "' order by proCode desc");
      new ArrayList();
      List var5 = var4.list();
      long var6 = 1L;
      if (var5.size() != 0) {
         var6 = (long)(var5.size() + 1);
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public long lastProduitById(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsVtes");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Produits where proVteCode='" + var1 + "' order by proId desc");
      new ArrayList();
      List var5 = var4.list();
      long var6 = 1L;
      if (var5.size() != 0) {
         var6 = (long)(var5.size() + 1);
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesProduitsFrais(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsVtes");
         var2 = true;
      }

      List var3 = var1.createQuery("from Produits where (proVteCode<>'' and proVteCode is not null) and proVteNat=1612 order by proCode").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public Produits chargeProduit(long var1, Session var3) throws HibernateException, NamingException {
      Produits var4 = null;
      if (var1 != 0L) {
         boolean var5 = false;
         if (var3 == null) {
            var3 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsVtes");
            var5 = true;
         }

         Query var6 = var3.createQuery("from Produits where (proVteCode<>'' and proVteCode is not null) and proId='" + var1 + "'").setMaxResults(1);
         var4 = (Produits)var6.uniqueResult();
         if (var5) {
            this.utilInitHibernate.closeSession();
         }
      }

      return var4;
   }

   public Produits chargeToutProduit(long var1, Session var3) throws HibernateException, NamingException {
      Produits var4 = null;
      if (var1 != 0L) {
         boolean var5 = false;
         if (var3 == null) {
            var3 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsVtes");
            var5 = true;
         }

         Query var6 = var3.createQuery("from Produits where proId='" + var1 + "'").setMaxResults(1);
         var4 = (Produits)var6.uniqueResult();
         if (var5) {
            this.utilInitHibernate.closeSession();
         }
      }

      return var4;
   }

   public Produits chargeToutProduit(String var1, Session var2) throws HibernateException, NamingException {
      Produits var3 = null;
      if (var1 != null && !var1.isEmpty()) {
         boolean var4 = false;
         if (var2 == null) {
            var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
            var4 = true;
         }

         Query var5 = var2.createQuery("from Produits where proCode=:assu").setString("assu", var1).setMaxResults(1);
         var3 = (Produits)var5.uniqueResult();
         if (var4) {
            this.utilInitHibernate.closeSession();
         }
      }

      return var3;
   }

   public Produits chargeProduit(String var1, Session var2) throws HibernateException, NamingException {
      Produits var3 = null;
      if (var1 != null && !var1.isEmpty()) {
         boolean var4 = false;
         if (var2 == null) {
            var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsVtes");
            var4 = true;
         }

         Query var5 = var2.createQuery("from Produits where (proVteCode<>'' and proVteCode is not null) and proCode=:cod").setString("cod", var1).setMaxResults(1);
         List var6 = var5.list();
         if (var6.size() != 0) {
            var3 = (Produits)var6.get(0);
         }

         if (var4) {
            this.utilInitHibernate.closeSession();
         }
      }

      return var3;
   }

   public List selectFindProduitSer(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsVtes");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Produits where (proVteCode<>'' and proVteCode is not null) and proId in " + var1 + "order by proCode asc");
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List verifProduits(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsVtes");
         var3 = true;
      }

      String var4 = "";
      String var5 = "";
      if (var1.equals("*")) {
         var4 = "";
      } else if (var1.contains("*") && var1.length() >= 2) {
         String var6 = var1.substring(1);
         var4 = "and (p.proCode LIKE '" + var6 + "%' or p.proLibClient LIKE '%" + var6 + "%' or p.proLibTech LIKE '%" + var6 + "%')";
         var5 = "and (profouRef LIKE '" + var6 + "%' or profouLib LIKE '%" + var6 + "%' or profouLib LIKE '%" + var6 + "%')";
      } else {
         var4 = "and (p.proCode LIKE '" + var1 + "%' or p.proLibClient LIKE '" + var1 + "%' or p.proLibTech LIKE '" + var1 + "%')";
         var5 = "and (profouRef LIKE '" + var1 + "%' or profouLib LIKE '" + var1 + "%' or profouLib LIKE '" + var1 + "%')";
      }

      Query var14 = var2.createQuery("from Produits p  where (p.proVteCode<>'' and p.proVteCode is not null) " + var4 + " and p.proInactif=0 order by p.proCode asc");
      List var7 = var14.list();
      var14 = var2.createQuery("from ProduitsFournisseur where (produits.proVteCode<>'' and produits.proVteCode is not null) " + var5 + " and produits.proInactif=0 order by profouRef asc");
      List var8 = var14.list();
      int var11;
      if (var8.size() != 0) {
         boolean var9 = false;

         for(int var10 = 0; var10 < var8.size(); ++var10) {
            if (var7.size() == 0) {
               this.produits = ((ProduitsFournisseur)var8.get(var10)).getProduits();
               this.produits.setProLibTech(((ProduitsFournisseur)var8.get(var10)).getProfouRef() + ":" + this.produits.getProLibTech());
               var7.add(this.produits);
            } else {
               for(var11 = 0; var11 < var7.size(); ++var11) {
                  if (((Produits)var7.get(var11)).getProId() == ((ProduitsFournisseur)var8.get(var10)).getProduits().getProId()) {
                     var9 = true;
                     break;
                  }
               }

               if (!var9) {
                  this.produits = ((ProduitsFournisseur)var8.get(var10)).getProduits();
                  this.produits.setProLibTech(((ProduitsFournisseur)var8.get(var10)).getProfouRef() + ":" + this.produits.getProLibTech());
                  var7.add(this.produits);
               }
            }
         }
      }

      var14 = var2.createQuery("from ProduitsHistoRef where (produits.proVteCode<>'' and produits.proVteCode is not null) and prohrfReference like '" + var1 + "%' and produits.proInactif=0 order by prohrfReference asc");
      List var15 = var14.list();
      int var12;
      if (var15.size() != 0) {
         boolean var16 = false;

         for(var11 = 0; var11 < var15.size(); ++var11) {
            if (var7.size() == 0) {
               this.produits = ((ProduitsHistoRef)var15.get(var11)).getProduits();
               this.produits.setProLibTech(((ProduitsHistoRef)var15.get(var11)).getProhrfReference() + ":" + this.produits.getProLibTech());
               var7.add(this.produits);
            } else {
               for(var12 = 0; var12 < var7.size(); ++var12) {
                  if (((Produits)var7.get(var12)).getProId() == ((ProduitsHistoRef)var15.get(var11)).getProduits().getProId()) {
                     var16 = true;
                     break;
                  }
               }

               if (!var16) {
                  this.produits = ((ProduitsHistoRef)var15.get(var11)).getProduits();
                  this.produits.setProLibTech(((ProduitsHistoRef)var15.get(var11)).getProhrfReference() + ":" + this.produits.getProLibTech());
                  var7.add(this.produits);
               }
            }
         }
      }

      var14 = var2.createQuery("from ProduitsMcles where (produits.proVteCode<>'' and produits.proVteCode is not null) and promclMot like '" + var1 + "%' and produits.proInactif=0 order by promclMot asc");
      List var17 = var14.list();
      if (var17.size() != 0) {
         boolean var18 = false;

         for(var12 = 0; var12 < var17.size(); ++var12) {
            if (var7.size() == 0) {
               this.produits = ((ProduitsMcles)var17.get(var12)).getProduits();
               this.produits.setProLibTech(((ProduitsMcles)var17.get(var12)).getPromclMot() + ":" + this.produits.getProLibTech());
               var7.add(this.produits);
            } else {
               for(int var13 = 0; var13 < var7.size(); ++var13) {
                  if (((Produits)var7.get(var13)).getProId() == ((ProduitsMcles)var17.get(var12)).getProduits().getProId()) {
                     var18 = true;
                     break;
                  }
               }

               if (!var18) {
                  this.produits = ((ProduitsMcles)var17.get(var12)).getProduits();
                  this.produits.setProLibTech(((ProduitsMcles)var17.get(var12)).getPromclMot() + ":" + this.produits.getProLibTech());
                  var7.add(this.produits);
               }
            }
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List verifProduitsHorsGenerique(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsVtes");
         var3 = true;
      }

      String var4 = "";
      if (var1.equals("*")) {
         var4 = "";
      } else if (var1.contains("*") && var1.length() >= 2) {
         String var5 = var1.substring(1);
         var4 = "and (p.proCode LIKE '" + var5 + "%' or p.proVteCode LIKE '" + var5 + "%' or p.proLibClient LIKE '%" + var5 + "%' or p.proLibTech LIKE '%" + var5 + "%')";
      } else {
         var4 = "and (p.proCode LIKE '" + var1 + "%' or p.proVteCode LIKE '" + var1 + "%' or p.proLibClient LIKE '" + var1 + "%' or p.proLibTech LIKE '" + var1 + "%')";
      }

      Query var14 = var2.createQuery("from Produits p where (p.proVteCode<>'' and p.proVteCode is not null) " + var4 + " and p.proInactif=0 and p.proMode<>5 order by p.proCode asc");
      List var6 = var14.list();
      String var7 = "";
      if (var1.equals("*")) {
         var7 = "";
      } else if (var1.contains("*") && var1.length() >= 2) {
         String var8 = var1.substring(1);
         var7 = "and (profouRef LIKE '" + var8 + "%' or profouLib LIKE '%" + var8 + "%' or profouLib LIKE '%" + var8 + "%')";
      } else {
         var7 = "and (profouRef LIKE '" + var1 + "%' or profouLib LIKE '" + var1 + "%' or profouLib LIKE '" + var1 + "%')";
      }

      var14 = var2.createQuery("from ProduitsFournisseur where (produits.proVteCode<>'' and produits.proVteCode is not null) " + var7 + " and produits.proInactif=0 order by profouRef asc");
      List var15 = var14.list();
      int var11;
      if (var15.size() != 0) {
         boolean var9 = false;

         for(int var10 = 0; var10 < var15.size(); ++var10) {
            if (var6.size() == 0) {
               this.produits = ((ProduitsFournisseur)var15.get(var10)).getProduits();
               this.produits.setProLibTech(((ProduitsFournisseur)var15.get(var10)).getProfouRef() + ":" + this.produits.getProLibTech());
               var6.add(this.produits);
            } else {
               for(var11 = 0; var11 < var6.size(); ++var11) {
                  if (((Produits)var6.get(var11)).getProId() == ((ProduitsFournisseur)var15.get(var10)).getProduits().getProId()) {
                     var9 = true;
                     break;
                  }
               }

               if (!var9) {
                  this.produits = ((ProduitsFournisseur)var15.get(var10)).getProduits();
                  this.produits.setProLibTech(((ProduitsFournisseur)var15.get(var10)).getProfouRef() + ":" + this.produits.getProLibTech());
                  var6.add(this.produits);
               }
            }
         }
      }

      var14 = var2.createQuery("from ProduitsHistoRef where (produits.proVteCode<>'' and produits.proVteCode is not null) and prohrfReference like '" + var1 + "%' and produits.proInactif=0 order by prohrfReference asc");
      List var16 = var14.list();
      int var12;
      if (var16.size() != 0) {
         boolean var17 = false;

         for(var11 = 0; var11 < var16.size(); ++var11) {
            if (var6.size() == 0) {
               this.produits = ((ProduitsHistoRef)var16.get(var11)).getProduits();
               this.produits.setProLibTech(((ProduitsHistoRef)var16.get(var11)).getProhrfReference() + ":" + this.produits.getProLibTech());
               var6.add(this.produits);
            } else {
               for(var12 = 0; var12 < var6.size(); ++var12) {
                  if (((Produits)var6.get(var12)).getProId() == ((ProduitsHistoRef)var16.get(var11)).getProduits().getProId()) {
                     var17 = true;
                     break;
                  }
               }

               if (!var17) {
                  this.produits = ((ProduitsHistoRef)var16.get(var11)).getProduits();
                  this.produits.setProLibTech(((ProduitsHistoRef)var16.get(var11)).getProhrfReference() + ":" + this.produits.getProLibTech());
                  var6.add(this.produits);
               }
            }
         }
      }

      var14 = var2.createQuery("from ProduitsMcles where (produits.proVteCode<>'' and produits.proVteCode is not null) and promclMot like '" + var1 + "%' and produits.proInactif=0 order by promclMot asc");
      List var18 = var14.list();
      if (var18.size() != 0) {
         boolean var19 = false;

         for(var12 = 0; var12 < var18.size(); ++var12) {
            if (var6.size() == 0) {
               this.produits = ((ProduitsMcles)var18.get(var12)).getProduits();
               this.produits.setProLibTech(((ProduitsMcles)var18.get(var12)).getPromclMot() + ":" + this.produits.getProLibTech());
               var6.add(this.produits);
            } else {
               for(int var13 = 0; var13 < var6.size(); ++var13) {
                  if (((Produits)var6.get(var13)).getProId() == ((ProduitsMcles)var18.get(var12)).getProduits().getProId()) {
                     var19 = true;
                     break;
                  }
               }

               if (!var19) {
                  this.produits = ((ProduitsMcles)var18.get(var12)).getProduits();
                  this.produits.setProLibTech(((ProduitsMcles)var18.get(var12)).getPromclMot() + ":" + this.produits.getProLibTech());
                  var6.add(this.produits);
               }
            }
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List verifProduitsGenerique(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsVtes");
         var3 = true;
      }

      String var4 = "";
      if (var1 != null && !var1.isEmpty()) {
         if (var1.equals("*")) {
            var4 = "";
         } else if (var1.contains("*") && var1.length() >= 2) {
            String var5 = var1.substring(1);
            var4 = "and (proCode LIKE '" + var5 + "%' or proVteCode LIKE '" + var5 + "%' or proLibClient LIKE '%" + var5 + "%' or proLibTech LIKE '%" + var5 + "%')";
         } else {
            var4 = "and (proCode LIKE '" + var1 + "%' or proVteCode LIKE '" + var1 + "%' or proLibClient LIKE '" + var1 + "%' or proLibTech LIKE '" + var1 + "%')";
         }
      }

      Query var7 = var2.createQuery("from Produits where (proVteCode<>'' and proVteCode is not null) " + var4 + " and proInactif=0 and proMode=5 group by proCode order by proCode asc");
      List var6 = var7.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List verifProduitsFrais(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsVtes");
         var3 = true;
      }

      String var4 = "";
      if (var1.equals("*")) {
         var4 = "";
      } else if (var1.contains("*") && var1.length() >= 2) {
         String var5 = var1.substring(1);
         var4 = "and (proCode LIKE '" + var5 + "%' or proLibClient LIKE '%" + var5 + "%')";
      } else {
         var4 = "and (proCode LIKE '" + var1 + "%' or proLibClient LIKE '" + var1 + "%')";
      }

      Query var7 = var2.createQuery("from Produits where proVteNat='1612' " + var4 + " and proInactif=0 order by proCode asc");
      List var6 = var7.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List verifProduitsMedicaux(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsMed");
         var4 = true;
      }

      String var5 = "";
      String var6;
      if (var1.equals("*")) {
         var5 = "";
      } else if (var1.contains("*") && var1.length() >= 2) {
         var6 = var1.substring(1);
         var5 = "and (proCode LIKE '%" + var6 + "%' or proLibClient LIKE '%" + var6 + "%' or  proLibTech LIKE '%" + var6 + "%')";
      } else {
         var5 = "and (proCode LIKE '" + var1 + "%' or proLibClient LIKE '" + var1 + "%' or proLibTech LIKE '%" + var1 + "%')";
      }

      var6 = null;
      Query var8;
      if (var2 != null && !var2.isEmpty()) {
         var8 = var3.createQuery("from Produits where proVteNat='" + var2 + "' " + var5 + " and proInactif=0 order by proCode asc");
      } else {
         var8 = var3.createQuery("from Produits where proVteNat like '11%' " + var5 + " and proInactif=0 order by proCode asc");
      }

      List var7 = var8.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List verifProduitsParc(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsMed");
         var3 = true;
      }

      String var4 = "";
      if (var1.equals("*")) {
         var4 = "";
      } else if (var1.contains("*") && var1.length() >= 2) {
         String var5 = var1.substring(1);
         var4 = "and (proCode LIKE '%" + var5 + "%' or proVteCode LIKE '" + var5 + "%' or proLibClient LIKE '%" + var5 + "%' or  proLibTech LIKE '%" + var5 + "%')";
      } else {
         var4 = "and (proCode LIKE '" + var1 + "%' or proVteCode LIKE '" + var1 + "%' or proLibClient LIKE '" + var1 + "%' or proLibTech LIKE '%" + var1 + "%')";
      }

      Query var7 = var2.createQuery("from Produits where (proAchNat='0114' or proVteNat='1614') " + var4 + " and proInactif=0 order by proCode asc");
      List var6 = var7.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List verifProduitsByNature(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsVtes");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Produits where proVteNat='" + var1 + "' " + " and proInactif=0 order by proCode asc");
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesProduits20Derniers(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsVtes");
         var2 = true;
      }

      List var3 = var1.createQuery("from Produits where (proVteCode<>'' and proVteCode is not null) group by proCode order by proId desc").setMaxResults(20).list();
      new ArrayList();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public boolean existCode(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsVtes");
         var3 = true;
      }

      boolean var4 = false;
      Query var5 = var2.createQuery("from Produits pr where pr.proCode=:cod").setString("cod", var1);
      var5.setMaxResults(1);
      new ArrayList();
      List var6 = var5.list();
      if (var6.size() != 0) {
         var4 = true;
      } else {
         var4 = false;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }
}
