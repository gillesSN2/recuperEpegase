package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsFournisseur;
import com.epegase.systeme.classe.ProduitsHistoRef;
import com.epegase.systeme.classe.ProduitsMcles;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class ProduitsAchsDao implements Serializable {
   private Produits produits;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public ProduitsAchsDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public Produits insert(Produits var1) throws HibernateException, NamingException {
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

   public Produits insert(Produits var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public Produits modif(Produits var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
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

   public Produits modif(Produits var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void modifListProduit(List var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         if (var1.size() > 0) {
            for(int var4 = 0; var4 < var1.size(); ++var4) {
               var2.update(var1.get(var4));
            }
         }

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

   public void delete(Produits var1, Session var2) {
      var2.delete(var1);
   }

   public List selectAllProduits(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var2 = true;
      }

      List var3 = var1.createQuery("from Produits where (proAchCode<>'' and proAchCode is not null) order by proCode asc").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public boolean existCode(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
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

   public Produits existCodeProduit(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var3 = true;
      }

      new Produits();
      new ArrayList();
      List var6 = var2.createQuery("from Produits where proCode='" + var1 + "'").setMaxResults(1).list();
      Produits var4;
      if (var6 != null) {
         if (var6.size() != 0) {
            var4 = (Produits)var6.get(0);
         } else {
            var4 = null;
         }
      } else {
         var4 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List selectFindProduit(String var1, String var2, String var3, String var4, String var5, String var6, int var7, String var8, Session var9) throws HibernateException, NamingException {
      boolean var10 = false;
      if (var9 == null) {
         var9 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var10 = true;
      }

      boolean var11 = true;
      new ArrayList();
      Criteria var13 = var9.createCriteria(Produits.class);
      String var14;
      if (var1 != null && !var1.isEmpty()) {
         var14 = "";
         if (var1.startsWith("*")) {
            var14 = "%" + var1.substring(1) + "%";
         } else {
            var14 = var1 + "%";
         }

         var13 = var13.add(Restrictions.or(Restrictions.like("proCode", var14), Restrictions.like("proBarre", var14)));
      }

      if (var2 != null && !var2.isEmpty()) {
         var14 = "";
         if (var2.startsWith("*")) {
            var14 = "%" + var2.substring(1) + "%";
         } else {
            var14 = var2 + "%";
         }

         var13 = var13.add(Restrictions.or(Restrictions.like("proLibClient", var14), Restrictions.like("proLibTech", var14)));
      }

      if (var3 != null && !var3.isEmpty()) {
         var13 = var13.add(Restrictions.or(Restrictions.eq("proAchNat", var3), Restrictions.eq("proVteNat", var3)));
      }

      if (var4 != null && !var4.isEmpty()) {
         var13 = var13.add(Restrictions.eq("proMarque", var4));
      }

      if (var5 != null && !var5.isEmpty()) {
         var13 = var13.add(Restrictions.or(Restrictions.like("proAchCode", var5 + "%"), Restrictions.like("proVteCode", var5 + "%")));
         var11 = false;
      }

      if (var6 != null && !var6.isEmpty()) {
         var13 = var13.add(Restrictions.eq("proActivite", var6));
      }

      if (var7 == 0) {
         var13 = var13.add(Restrictions.eq("proInactif", 0));
      } else if (var7 == 1) {
         var13 = var13.add(Restrictions.eq("proInactif", 1));
      } else if (var7 == 2) {
         var13 = var13.add(Restrictions.eq("proInactif", 2));
      }

      if (var8 != null && !var8.isEmpty() && !var8.equals("9")) {
         if (var8.equals("0")) {
            var13 = var13.add(Restrictions.eq("proMode", 0));
         } else if (var8.equals("1")) {
            var13 = var13.add(Restrictions.eq("proMode", 1));
         } else if (var8.equals("2")) {
            var13 = var13.add(Restrictions.eq("proMode", 2));
         } else if (var8.equals("3")) {
            var13 = var13.add(Restrictions.eq("proMode", 3));
         } else if (var8.equals("4")) {
            var13 = var13.add(Restrictions.eq("proMode", 4));
         } else if (var8.equals("5")) {
            var13 = var13.add(Restrictions.eq("proMode", 5));
         }
      }

      var13 = var13.addOrder(Order.asc("proCode"));
      List var22 = var13.list();
      List var12 = var22;
      if (var11 && var1 != null && !var1.isEmpty()) {
         String var15 = "";
         if (var1.equals("*")) {
            var15 = "";
         } else if (var1.startsWith("*") && var1.length() >= 2) {
            String var16 = var1.substring(1);
            var15 = "and (profouRef LIKE '" + var16 + "%' or profouLib LIKE '%" + var16 + "%' or profouLib LIKE '%" + var16 + "%')";
         } else {
            var15 = "and (profouRef LIKE '" + var1 + "%' or profouLib LIKE '" + var1 + "%' or profouLib LIKE '" + var1 + "%')";
         }

         Query var21 = null;
         if (var7 == 0) {
            var21 = var9.createQuery("from ProduitsFournisseur where (produits.proAchCode<>'' and produits.proAchCode is not null) " + var15 + " and produits.proInactif=0 order by profouRef asc");
         } else if (var7 == 1) {
            var21 = var9.createQuery("from ProduitsFournisseur where (produits.proAchCode<>'' and produits.proAchCode is not null) " + var15 + " and produits.proInactif=1 order by profouRef asc");
         } else if (var7 == 2) {
            var21 = var9.createQuery("from ProduitsFournisseur where (produits.proAchCode<>'' and produits.proAchCode is not null) " + var15 + " and produits.proInactif=2 order by profouRef asc");
         }

         List var17 = var21.list();
         if (var17.size() != 0) {
            boolean var18 = false;

            for(int var19 = 0; var19 < var17.size(); ++var19) {
               if (var12.size() == 0) {
                  this.produits = ((ProduitsFournisseur)var17.get(var19)).getProduits();
                  this.produits.setProLibTech(((ProduitsFournisseur)var17.get(var19)).getProfouRef() + ":" + this.produits.getProLibTech());
                  var12.add(this.produits);
               } else {
                  for(int var20 = 0; var20 < var12.size(); ++var20) {
                     if (((Produits)var12.get(var20)).getProId() == ((ProduitsFournisseur)var17.get(var19)).getProduits().getProId()) {
                        var18 = true;
                        break;
                     }
                  }

                  if (!var18) {
                     this.produits = ((ProduitsFournisseur)var17.get(var19)).getProduits();
                     this.produits.setProLibTech(((ProduitsFournisseur)var17.get(var19)).getProfouRef() + ":" + this.produits.getProLibTech());
                     var12.add(this.produits);
                  }
               }
            }
         }
      }

      if (var10) {
         this.utilInitHibernate.closeSession();
      }

      return var12;
   }

   public List selectFindProduit(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var5 = true;
      }

      String var6 = "";
      String var7 = "null";
      new ArrayList();
      Criteria var9 = var4.createCriteria(Produits.class);
      var9 = var9.add(Restrictions.ne("proAchCode", var6)).add(Restrictions.ne("proAchCode", var7)).addOrder(Order.asc("proCode"));
      if (var1 != null && !var1.isEmpty() && var2 != null && !var2.isEmpty()) {
         var9 = var9.add(Restrictions.between("proCode", var1, var2));
      }

      if (var3 != null && !var3.isEmpty() && var3.contains(":")) {
         String[] var10 = var3.split(":");
         var9 = var9.add(Restrictions.like("proAchCode", var10[0] + "%"));
      }

      var9 = var9.add(Restrictions.ne("proMode", 5));
      var9 = var9.add(Restrictions.eq("proInactif", 0));
      var9 = var9.addOrder(Order.asc("proCode"));
      List var11 = var9.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var11;
   }

   public List selectFindProduitSer(String var1, String var2, String var3, String var4, String var5, String var6, int var7, Session var8) throws HibernateException, NamingException {
      boolean var9 = false;
      if (var8 == null) {
         var8 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var9 = true;
      }

      String var10 = "";
      String var11 = "";
      String var12 = "";
      String var13 = "";
      String var14 = "";
      String var15 = "";
      String var16 = "";
      if (var1 != null && !var1.isEmpty()) {
         var10 = "";
      } else {
         var10 = " (proCode='" + var1 + "' or proBarre = '" + var1 + "') and ";
      }

      if (var2.equalsIgnoreCase("")) {
         var11 = "";
      } else {
         var11 = " proLibClient='" + var2 + "' and ";
      }

      if (var3 != null && !var3.isEmpty()) {
         var12 = "";
      } else {
         var12 = " (proAchNat='" + var3 + "' or proVteNat='" + var3 + "') and ";
      }

      if (var4 != null && !var4.isEmpty()) {
         var13 = "";
      } else {
         var13 = " (proAchCode='" + var4 + "' or proVteCode='" + var4 + "') and ";
      }

      if (var5 != null && !var5.isEmpty()) {
         var14 = "";
      } else {
         var14 = " proActivite='" + var5 + "' and ";
      }

      if (var7 == 0) {
         var15 = " proInactif=0 and ";
      } else if (var7 == 1) {
         var15 = "proInactif=1 and ";
      } else if (var7 == 2) {
         var15 = "proInactif=2 and ";
      }

      var16 = var10 + var11 + var12 + var13 + var14 + var15;
      Query var17 = var8.createQuery("from Produits where " + var16 + " proId in " + var6 + " order by proCode asc");
      List var18 = var17.list();
      if (var9) {
         this.utilInitHibernate.closeSession();
      }

      return var18;
   }

   public List chargerLesProduitsAchats(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var2 = true;
      }

      List var3 = var1.createQuery("from Produits where (proAchCode<>'' and proAchCode is not null) group by proCode order by proCode asc").list();
      new ArrayList();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerLesProduits20Derniers(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var2 = true;
      }

      List var3 = var1.createQuery("from Produits group by proCode order by proId desc").setMaxResults(20).list();
      new ArrayList();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerLesProduitsDesactive(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var2 = true;
      }

      List var3 = var1.createQuery("from Produits where proInactif=1 order by proCode asc").list();
      new ArrayList();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerLesProduitsASupprimer(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var2 = true;
      }

      List var3 = var1.createQuery("from Produits where proInactif=2 order by proCode asc").list();
      new ArrayList();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerLesProduitsAchatsByFamille(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var3 = true;
      }

      List var4 = var2.createQuery("from Produits where proAchCode=:fam order by proCode asc").setString("fam", var1).list();
      new ArrayList();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesProduitsProd(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var2 = true;
      }

      List var3 = var1.createQuery("from Produits where (proAchNat='0102' or proAchNat='0103') order by proCode asc").list();
      new ArrayList();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List selectEgalProduits(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Produits where (proAchCode<>'' and proAchCode is not null) and proId in " + var1 + " order by proCode asc");
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public long lastProduit(Session var1, int var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
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

   public long lastProduitByFamilleAch(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Produits where proAchCode='" + var1 + "' order by proCode desc").setMaxResults(1);
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

   public long nbProduitByFamilleAch(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Produits where proAchCode='" + var1 + "' order by proId desc");
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

   public long lastProduitByIdAch(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Produits where proAchCode='" + var1 + "' order by proId desc").setMaxResults(1);
      new ArrayList();
      List var5 = var4.list();
      long var6 = 1L;
      if (var5.size() != 0) {
         var6 = ((Produits)var5.get(0)).getProId() + 1L;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public long lastProduitByFamilleVte(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Produits where proVteCode='" + var1 + "' order by proCode desc").setMaxResults(1);
      new ArrayList();
      List var5 = var4.list();
      long var6 = 1L;
      if (var5.size() != 0) {
         var6 = ((Produits)var5.get(0)).getProId() + 1L;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public long nbProduitByFamilleVte(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
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

   public long lastProduitByIdVte(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Produits where proVteCode='" + var1 + "' order by proId desc").setMaxResults(1);
      new ArrayList();
      List var5 = var4.list();
      long var6 = 1L;
      if (var5.size() != 0) {
         var6 = ((Produits)var5.get(0)).getProId() + 1L;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public Produits chargeProduit(long var1, Session var3) throws HibernateException, NamingException {
      Produits var4 = null;
      if (var1 != 0L) {
         boolean var5 = false;
         if (var3 == null) {
            var3 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
            var5 = true;
         }

         Query var6 = var3.createQuery("from Produits where proId='" + var1 + "'");
         var6.setMaxResults(1);
         var4 = (Produits)var6.uniqueResult();
         if (var5) {
            this.utilInitHibernate.closeSession();
         }
      }

      return var4;
   }

   public Produits chargeProduit(String var1, Session var2) throws HibernateException, NamingException {
      Produits var3 = null;
      if (var1 != null && !var1.isEmpty()) {
         boolean var4 = false;
         if (var2 == null) {
            var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
            var4 = true;
         }

         Query var5 = var2.createQuery("from Produits where (proAchCode<>'' and proAchCode is not null) and proCode=:assu").setString("assu", var1).setMaxResults(1);
         new ArrayList();
         List var6 = var5.list();
         if (var6.size() != 0) {
            var3 = (Produits)var6.get(0);
         } else {
            var3 = null;
         }

         if (var4) {
            this.utilInitHibernate.closeSession();
         }
      }

      return var3;
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

   public Produits chargeToutProduitLibelle(String var1, Session var2) throws HibernateException, NamingException {
      Produits var3 = null;
      if (var1 != null && !var1.isEmpty()) {
         boolean var4 = false;
         if (var2 == null) {
            var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
            var4 = true;
         }

         Query var5 = var2.createQuery("from Produits where proLibClient=:assu").setString("assu", var1).setMaxResults(1);
         var3 = (Produits)var5.uniqueResult();
         if (var4) {
            this.utilInitHibernate.closeSession();
         }
      }

      return var3;
   }

   public List selectFindProduitSer(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Produits where (proAchCode<>'' and proAchCode is not null) and proId in " + var1 + "order by proCode asc");
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesProduitsByNature(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Produits where (proAchCode<>'' and proAchCode is not null) and proAchNat='" + var1 + "' order by proCode asc");
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesProduitsByNature(String var1, int var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var4 = true;
      }

      Query var5 = var3.createQuery("from Produits where (proAchCode<>'' and proAchCode is not null) and proAchNat='" + var1 + "' and proMode=" + var2 + " order by proCode asc");
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List selectFindProduitSerFrais(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Produits where proAchNat='0112' and (proAchCode<>'' and proAchCode is not null) and proId in " + var1 + "order by proCode asc");
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List verifProduits(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var3 = true;
      }

      String var4 = "";
      String var5 = "";
      if (var1.equals("*")) {
         var4 = "";
         var5 = "";
      } else if (var1.startsWith("*") && var1.length() >= 2) {
         String var6 = var1.substring(1);
         var4 = "and (proCode LIKE '" + var6 + "%' or proAchCode LIKE '" + var6 + "%' or proVteCode LIKE '" + var6 + "%' or proLibClient LIKE '%" + var6 + "%' or proLibTech LIKE '%" + var6 + "%')";
         var5 = "and (profouRef LIKE '" + var6 + "%' or profouLib LIKE '%" + var6 + "%' or profouLib LIKE '%" + var6 + "%')";
      } else {
         var4 = "and (proCode LIKE '" + var1 + "%' or proAchCode LIKE '" + var1 + "%' or proVteCode LIKE '" + var1 + "%' or proLibClient LIKE '" + var1 + "%' or proLibTech LIKE '" + var1 + "%')";
         var5 = "and (profouRef LIKE '" + var1 + "%' or profouLib LIKE '" + var1 + "%' or profouLib LIKE '" + var1 + "%')";
      }

      Query var14 = var2.createQuery("from Produits where (proAchCode<>'' and proAchCode is not null) " + var4 + " and proInactif=0 order by proCode asc");
      List var7 = var14.list();
      var14 = var2.createQuery("from ProduitsFournisseur where (produits.proAchCode<>'' and produits.proAchCode is not null) " + var5 + " and produits.proInactif=0 order by profouRef asc");
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

      var14 = var2.createQuery("from ProduitsHistoRef where (produits.proAchCode<>'' and produits.proAchCode is not null) and prohrfReference like '" + var1 + "%' and produits.proInactif=0 order by prohrfReference asc");
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

      var14 = var2.createQuery("from ProduitsMcles where (produits.proAchCode<>'' and produits.proAchCode is not null) and promclMot like '" + var1 + "%' and produits.proInactif=0 order by promclMot asc");
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

   public List verifProduitsFrais(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var3 = true;
      }

      String var4 = "";
      if (var1.equals("*")) {
         var4 = "";
      } else if (var1.startsWith("*") && var1.length() >= 2) {
         String var5 = var1.substring(1);
         var4 = "and (proCode LIKE '" + var5 + "%' or proLibClient LIKE '%" + var5 + "%')";
      } else {
         var4 = "and (proCode LIKE '" + var1 + "%' or proLibClient LIKE '" + var1 + "%')";
      }

      Query var7 = var2.createQuery("from Produits where proAchNat='0112' " + var4 + " and proInactif=0 order by proCode asc");
      List var6 = var7.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerTousProduitsAchats(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var3 = true;
      }

      String var4 = "";
      if (var1.equals("*")) {
         var4 = "";
      } else if (var1.startsWith("*") && var1.length() >= 2) {
         String var5 = var1.substring(1);
         var4 = "(proCode LIKE '" + var5 + "%' or proAchCode LIKE '" + var5 + "%' or proLibClient LIKE '%" + var5 + "%' or proLibTech LIKE '%" + var5 + "%') and ";
      } else {
         var4 = "(proCode LIKE '" + var1 + "%' or proAchCode LIKE '" + var1 + "%' or proLibClient LIKE '" + var1 + "%' or proLibTech LIKE '" + var1 + "%') and ";
      }

      Query var7 = var2.createQuery("from Produits where " + var4 + " proInactif=0 and (proAchCode<>'' and proAchCode is not null) order by proCode asc");
      List var6 = var7.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerTousProduitsAchatsVentes(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var3 = true;
      }

      String var4 = "";
      if (var1 != null && !var1.isEmpty() && var1.equals("*")) {
         var4 = "";
      } else if (var1 != null && !var1.isEmpty() && var1.startsWith("*") && var1.length() >= 2) {
         String var5 = var1.substring(1);
         var4 = "(proCode LIKE '" + var5 + "%' or proAchCode LIKE '" + var5 + "%' or proVteCode LIKE '" + var5 + "%' or proLibClient LIKE '%" + var5 + "%' or proLibTech LIKE '%" + var5 + "%') and ";
      } else if (var1 != null && !var1.isEmpty()) {
         var4 = "(proCode LIKE '" + var1 + "%' or proAchCode LIKE '" + var1 + "%' or proVteCode LIKE '" + var1 + "%' or proLibClient LIKE '" + var1 + "%' or proLibTech LIKE '" + var1 + "%') and ";
      } else {
         var4 = "proCode is not null and ";
      }

      Query var7 = var2.createQuery("from Produits where " + var4 + " proInactif=0 order by proCode asc");
      List var6 = var7.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesProduitsByRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var3 = true;
      }

      List var4 = var2.createQuery("from Produits where " + var1 + " order by proCode asc").list();
      new ArrayList();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesProduits(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Produits where (proAchCode<>'' and proAchCode is not null) and proMode=" + var1 + " order by proCode asc");
      List var5 = var4.list();
      ArrayList var6 = new ArrayList();
      if (var5.size() != 0) {
         for(int var7 = 0; var7 < var5.size(); ++var7) {
            var6.add(new SelectItem(((Produits)var5.get(var7)).getProCode(), ((Produits)var5.get(var7)).getProCode() + ":" + ((Produits)var5.get(var7)).getProLibClient()));
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List selectAllProduitsAchVte(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var2 = true;
      }

      List var3 = var1.createQuery("from Produits order by proCode asc").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List selectAllProduitsVte(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var2 = true;
      }

      List var3 = var1.createQuery("from Produits where (proVteCode<>'' and proVteCode is not null) group by proCode order by proCode asc").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List selectAllProduitsStock(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var2 = true;
      }

      List var3 = var1.createQuery("from Produits where proStock>=1 order by proCode asc").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }
}
