package com.epegase.systeme.dao;

import com.epegase.systeme.classe.DepotAchats;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsDepot;
import com.epegase.systeme.classe.ProduitsFournisseur;
import com.epegase.systeme.classe.ProduitsHistoRef;
import com.epegase.systeme.classe.ProduitsMcles;
import com.epegase.systeme.classe.ReceptionLigneAchats;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProduitsDepotDao implements Serializable {
   private ProduitsDepot produitsDepot;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public ProduitsDepotDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public ProduitsDepot insert(ProduitsDepot var1) throws HibernateException, NamingException {
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

   public ProduitsDepot insert(ProduitsDepot var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public ProduitsDepot modif(ProduitsDepot var1) throws HibernateException, NamingException {
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

   public ProduitsDepot modif(ProduitsDepot var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public String delete(ProduitsDepot var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
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

      return "";
   }

   public void delete(ProduitsDepot var1, Session var2) {
      var2.delete(var1);
   }

   public List selectAllProduitsDepot() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
      List var2 = var1.createQuery("from ProduitsDepot ").list();
      this.utilInitHibernate.closeSession();
      return var2;
   }

   public List selectAllProdDep(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var2 = true;
      }

      Query var3 = var1.createQuery("from ProduitsDepot where depot.dpoInactif=0");
      List var4 = var3.list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List selectProdDepByDep(DepotAchats var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var3 = true;
      }

      Query var4 = var2.createQuery("from ProduitsDepot where depot.dpoInactif=0 and depot=:dep").setParameter("dep", var1);
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectProdDepByDep(DepotAchats var1, String var2, String var3, String var4, String var5, String var6, String var7, int var8, String var9, Session var10) throws HibernateException, NamingException {
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

      Query var15 = var10.createQuery("from ProduitsDepot where depot.dpoInactif=0 " + var12 + " and depot=:dep").setParameter("dep", var1);
      List var14 = var15.list();
      if (var11) {
         this.utilInitHibernate.closeSession();
      }

      return var14;
   }

   public List selectProdDepByDepSansService(DepotAchats var1, String var2, String var3, String var4, String var5, String var6, String var7, int var8, String var9, Session var10) throws HibernateException, NamingException {
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

      Query var15 = var10.createQuery("from ProduitsDepot where depot.dpoInactif=0 " + var12 + " and depot=:dep and produits.proAvecService=false").setParameter("dep", var1);
      List var14 = var15.list();
      if (var11) {
         this.utilInitHibernate.closeSession();
      }

      return var14;
   }

   public List selectProdDepByDepAchs(String var1, String var2, DepotAchats var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var5 = true;
      }

      new Produits();
      String var7 = "";
      if (var1.equals("*")) {
         var7 = "";
      } else if (var1.contains("*") && var1.length() >= 2) {
         String var8 = var1.substring(1);
         var7 = "and (p.proCode LIKE '" + var8 + "%' or p.proVteCode LIKE '" + var8 + "%' or p.proLibClient LIKE '%" + var8 + "%' or p.proLibTech LIKE '%" + var8 + "%')";
      } else {
         var7 = "and (p.proCode LIKE '" + var1 + "%' or p.proVteCode LIKE '" + var1 + "%' or p.proLibClient LIKE '" + var1 + "%' or p.proLibTech LIKE '" + var1 + "%')";
      }

      Query var21 = var4.createQuery("from Produits p where ((p.proAchCode<>'' and p.proAchCode is not null) or (p.proVteCode<>'' and p.proVteCode is not null)) " + var7 + " and p.proInactif=0 and p.proMode<>5 order by p.proCode asc");
      List var9 = var21.list();


      String var10 = "";
      if (var1.equals("*")) {
         var10 = "";
      } else if (var1.contains("*") && var1.length() >= 2) {
         String var11 = var1.substring(1);
         var10 = "and (profouRef LIKE '" + var11 + "%' or profouLib LIKE '%" + var11 + "%' or profouLib LIKE '%" + var11 + "%')";
      } else {
         var10 = "and (profouRef LIKE '" + var1 + "%' or profouLib LIKE '" + var1 + "%' or profouLib LIKE '" + var1 + "%')";
      }

      var21 = var4.createQuery("from ProduitsFournisseur where ((produits.proAchCode<>'' and produits.proAchCode is not null) or (produits.proVteCode<>'' and produits.proVteCode is not null)) " + var10 + " and produits.proInactif=0 order by profouRef asc");
      List var22 = var21.list();
      Produits var6;
      int var14;
      if (var22.size() != 0) {
         boolean var12 = false;

         for(int var13 = 0; var13 < var22.size(); ++var13) {
            if (var9.size() == 0) {
               var6 = ((ProduitsFournisseur)var22.get(var13)).getProduits();
               var6.setProLibTech(((ProduitsFournisseur)var22.get(var13)).getProfouRef() + ":" + var6.getProLibTech());
               var9.add(var6);
            } else {
               for(var14 = 0; var14 < var9.size(); ++var14) {
                  if (((Produits)var9.get(var14)).getProId() == ((ProduitsFournisseur)var22.get(var13)).getProduits().getProId()) {
                     var12 = true;
                     break;
                  }
               }

               if (!var12) {
                  var6 = ((ProduitsFournisseur)var22.get(var13)).getProduits();
                  var6.setProLibTech(((ProduitsFournisseur)var22.get(var13)).getProfouRef() + ":" + var6.getProLibTech());
                  var9.add(var6);
               }
            }
         }
      }

      var21 = var4.createQuery("from ProduitsHistoRef where ((produits.proAchCode<>'' and produits.proAchCode is not null) or (produits.proVteCode<>'' and produits.proVteCode is not null)) and prohrfReference like '" + var1 + "%' and produits.proInactif=0 order by prohrfReference asc");
      List var23 = var21.list();
      int var15;
      if (var23.size() != 0) {
         boolean var24 = false;

         for(var14 = 0; var14 < var23.size(); ++var14) {
            if (var9.size() == 0) {
               var6 = ((ProduitsHistoRef)var23.get(var14)).getProduits();
               var6.setProLibTech(((ProduitsHistoRef)var23.get(var14)).getProhrfReference() + ":" + var6.getProLibTech());
               var9.add(var6);
            } else {
               for(var15 = 0; var15 < var9.size(); ++var15) {
                  if (((Produits)var9.get(var15)).getProId() == ((ProduitsHistoRef)var23.get(var14)).getProduits().getProId()) {
                     var24 = true;
                     break;
                  }
               }

               if (!var24) {
                  var6 = ((ProduitsHistoRef)var23.get(var14)).getProduits();
                  var6.setProLibTech(((ProduitsHistoRef)var23.get(var14)).getProhrfReference() + ":" + var6.getProLibTech());
                  var9.add(var6);
               }
            }
         }
      }

      var21 = var4.createQuery("from ProduitsMcles where ((produits.proAchCode<>'' and produits.proAchCode is not null) or (produits.proVteCode<>'' and produits.proVteCode is not null)) and promclMot like '" + var1 + "%' and produits.proInactif=0 order by promclMot asc");
      List var25 = var21.list();
      if (var25.size() != 0) {
         boolean var26 = false;

         for(var15 = 0; var15 < var25.size(); ++var15) {
            if (var9.size() == 0) {
               var6 = ((ProduitsMcles)var25.get(var15)).getProduits();
               var6.setProLibTech(((ProduitsMcles)var25.get(var15)).getPromclMot() + ":" + var6.getProLibTech());
               var9.add(var6);
            } else {
               for(int var16 = 0; var16 < var9.size(); ++var16) {
                  if (((Produits)var9.get(var16)).getProId() == ((ProduitsMcles)var25.get(var15)).getProduits().getProId()) {
                     var26 = true;
                     break;
                  }
               }

               if (!var26) {
                  var6 = ((ProduitsMcles)var25.get(var15)).getProduits();
                  var6.setProLibTech(((ProduitsMcles)var25.get(var15)).getPromclMot() + ":" + var6.getProLibTech());
                  var9.add(var6);
               }
            }
         }
      }

      String var27 = "";

      for(var15 = 0; var15 < var9.size(); ++var15) {
         if (var27 != null && !var27.isEmpty()) {
            var27 = var27 + "," + ((Produits)var9.get(var15)).getProId();
         } else {
            var27 = "" + ((Produits)var9.get(var15)).getProId();
         }
      }

      var21 = var4.createQuery("from ProduitsDepot where depot.dpoInactif=0 and depot=:dep and produits.proId in (" + var27 + ") and produits.proInactif=0").setParameter("dep", var3);
      List var29 = var21.list();
      if (var2 != null && !var2.isEmpty()) {
         ArrayList var28 = new ArrayList();
         new ArrayList();
         ReceptionLigneAchatsDao var18 = new ReceptionLigneAchatsDao(this.maBase, this.utilInitHibernate);
         List var17 = var18.chargerLesLignes(var2, var4);
         if (var17.size() != 0 && var29.size() != 0) {
            int var19;
            for(var19 = 0; var19 < var29.size(); ++var19) {
               this.produitsDepot = (ProduitsDepot)var29.get(var19);

               for(int var20 = 0; var20 < var17.size(); ++var20) {
                  if (((ReceptionLigneAchats)var17.get(var20)).getRecligCode().equals(this.produitsDepot.getProduits().getProCode())) {
                     var28.add(this.produitsDepot);
                     break;
                  }
               }
            }

            if (var28.size() != 0) {
               var29.clear();

               for(var19 = 0; var19 < var28.size(); ++var19) {
                  var29.add(var28.get(var19));
               }
            }
         } else {
            var29.clear();
         }
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var29;
   }

   public List selectProdDepByDepVtes(String var1, DepotAchats var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var4 = true;
      }

      Query var5 = null;
      if (var1.equals("*")) {
         var5 = var3.createQuery("from ProduitsDepot where depot.dpoInactif=0 and depot=:dep and produits.proVteCode<>''").setParameter("dep", var2);
      } else if (var1.startsWith("*") && var1.length() >= 2) {
         String var6 = var1.substring(1);
         var5 = var3.createQuery("from ProduitsDepot where depot.dpoInactif=0 and depot=:dep and (produits.proCode LIKE '%" + var6 + "%' or produits.proLibClient LIKE '%" + var6 + "%') and produits.proVteCode<>''").setParameter("dep", var2);
      } else {
         var5 = var3.createQuery("from ProduitsDepot where depot.dpoInactif=0 and depot=:dep and (produits.proCode LIKE '" + var1 + "%' or produits.proLibClient LIKE '" + var1 + "%') and produits.proVteCode<>''").setParameter("dep", var2);
      }

      List var17 = var5.list();
      String var7 = "";
      if (var1.equals("*")) {
         var7 = "";
      } else if (var1.startsWith("*") && var1.length() >= 2) {
         String var8 = var1.substring(1);
         var7 = "and (profouRef LIKE '" + var8 + "%' or profouLib LIKE '%" + var8 + "%' or profouLib LIKE '%" + var8 + "%')";
      } else {
         var7 = "and (profouRef LIKE '" + var1 + "%' or profouLib LIKE '" + var1 + "%' or profouLib LIKE '" + var1 + "%')";
      }

      var5 = var3.createQuery("from ProduitsFournisseur where (produits.proVteCode<>'' and produits.proVteCode is not null) " + var7 + " and produits.proInactif=0 order by profouRef asc");
      List var18 = var5.list();
      if (var18.size() != 0) {
         boolean var9 = false;
         new Produits();
         ProduitsDepotDao var11 = new ProduitsDepotDao(this.maBase, this.utilInitHibernate);
         new ArrayList();

         for(int var13 = 0; var13 < var18.size(); ++var13) {
            var9 = false;
            Produits var10;
            List var12;
            int var15;
            int var16;
            boolean var19;
            if (var17.size() == 0) {
               var10 = ((ProduitsFournisseur)var18.get(var13)).getProduits();
               var10.setProLibTech(((ProduitsFournisseur)var18.get(var13)).getProfouRef() + ":" + var10.getProLibTech());
               var12 = var11.produitDepByprodList(var1, var2.getDpoCode(), var3);
               if (var12.size() != 0) {
                  var19 = false;

                  for(var15 = 0; var15 < var12.size(); ++var15) {
                     for(var16 = 0; var16 < var17.size(); ++var16) {
                        if (((ProduitsDepot)var17.get(var16)).getProduits().getProId() == ((ProduitsDepot)var12.get(var13)).getProduits().getProId()) {
                           var19 = true;
                           break;
                        }
                     }

                     var19 = false;
                     if (false) {
                        var17.add(this.produitsDepot);
                     }
                  }
               }
            } else {
               for(int var14 = 0; var14 < var17.size(); ++var14) {
                  if (((ProduitsDepot)var17.get(var14)).getProduits().getProId() == ((ProduitsFournisseur)var18.get(var13)).getProduits().getProId()) {
                     var9 = true;
                     break;
                  }
               }

               if (!var9) {
                  var10 = ((ProduitsFournisseur)var18.get(var13)).getProduits();
                  var10.setProLibTech(((ProduitsFournisseur)var18.get(var13)).getProfouRef() + ":" + var10.getProLibTech());
                  var12 = var11.produitDepByprodList(var1, var2.getDpoCode(), var3);
                  if (var12.size() != 0) {
                     var19 = false;

                     for(var15 = 0; var15 < var12.size(); ++var15) {
                        for(var16 = 0; var16 < var17.size(); ++var16) {
                           if (((ProduitsDepot)var17.get(var16)).getProduits().getProId() == ((ProduitsDepot)var12.get(var13)).getProduits().getProId()) {
                              var19 = true;
                              break;
                           }
                        }

                        var19 = false;
                        if (false) {
                           var17.add(this.produitsDepot);
                        }
                     }
                  }
               }
            }
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var17;
   }

   public List selectProdDepByprod(Produits var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var3 = true;
      }

      Query var4 = var2.createQuery("from ProduitsDepot where depot.dpoInactif=0 and produits=:produits").setParameter("produits", var1);
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectProdDepByprod(Produits var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var4 = true;
      }

      String var5 = "";
      if (var2.contains(":")) {
         String[] var6 = var2.split(":");
         var5 = var6[0];
      } else {
         var5 = var2;
      }

      Query var8 = var3.createQuery("from ProduitsDepot where depot.dpoInactif=0 and depot.dpoService like '%" + var5 + "%' and produits=:produits").setParameter("produits", var1);
      List var7 = var8.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List selectProdDepByprod(Produits var1, int var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var4 = true;
      }

      String var5 = "";
      if (var2 != 10 && var2 != 11 && var2 != 12 && var2 != 13 && var2 != 15 && var2 != 16 && var2 != 17) {
         if (var2 == 14) {
            var5 = " depot.dpoRetourAch=1";
         } else if (var2 != 0 && var2 != 20 && var2 != 21 && var2 != 22 && var2 != 23 && var2 != 25 && var2 != 26 && var2 != 27 && var2 != 140) {
            if (var2 == 24) {
               var5 = " depot.dpoRetourVent=1";
            } else if (var2 == 28) {
               var5 = " depot.dpoMobileVent=1";
            } else if (var2 == 30) {
               var5 = " depot.dpoInventaire=1";
            } else if (var2 == 31) {
               var5 = " depot.dpoBonEntree=1";
            } else if (var2 == 32) {
               var5 = " depot.dpoBonSortie=1";
            } else if (var2 == 33) {
               var5 = " depot.dpoCession=1";
            } else if (var2 == 34) {
               var5 = " depot.dpoFabrication=1";
            } else if (var2 == 341) {
               var5 = " (depot.dpoFabrication=1 or depot.dpoLivraison=1)";
            } else if (var2 == 342) {
               var5 = " (depot.dpoFabrication=1 or depot.dpoReception=1)";
            } else if (var2 == 35) {
               var5 = " depot.dpoReachmin=1";
            } else if (var2 == 45) {
               var5 = " depot.dpoCarburant=1";
            } else if (var2 == 73) {
               var5 = " depot.dpoPharmacie=1";
            }
         } else {
            var5 = " depot.dpoLivraison=1";
         }
      } else {
         var5 = " depot.dpoReception=1";
      }

      Query var6 = null;
      if (var5 != null && !var5.isEmpty()) {
         var6 = var3.createQuery("from ProduitsDepot where depot.dpoInactif=0 and produits=:produits and " + var5).setParameter("produits", var1);
      } else {
         var6 = var3.createQuery("from ProduitsDepot where depot.dpoInactif=0 and produits=:produits").setParameter("produits", var1);
      }

      List var7 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List selectProdDepByprod(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var3 = true;
      }

      Query var4 = var2.createQuery("from ProduitsDepot where depot.dpoInactif=0 and produits.proCode=:code").setString("code", var1);
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectProdDepByprod(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var4 = true;
      }

      String var5 = var2 + ":" + var1;
      Query var6 = var3.createQuery("from ProduitsDepot where depot.dpoInactif=0 and prodepCle=:cle").setString("cle", var5);
      var6.setMaxResults(1);
      List var7 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public ProduitsDepot produitDepByprod(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var4 = true;
      }

      String var5 = var2 + ":" + var1;
      Query var6 = var3.createQuery("from ProduitsDepot where depot.dpoInactif=0 and prodepCle=:cle").setString("cle", var5).setMaxResults(1);
      List var7 = var6.list();
      ProduitsDepot var8 = null;
      if (var7.size() > 0) {
         var8 = (ProduitsDepot)var7.get(0);
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List produitDepByprodList(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var4 = true;
      }

      String var5 = var2 + ":" + var1;
      Query var6 = var3.createQuery("from ProduitsDepot where depot.dpoInactif=0 and prodepCle like '" + var5 + "'");
      List var7 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public Produits produitProdByDepot(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var4 = true;
      }

      String var5 = var2 + ":" + var1;
      Query var6 = var3.createQuery("from ProduitsDepot where depot.dpoInactif=0 and prodepCle=:cle").setString("cle", var5).setMaxResults(1);
      List var7 = var6.list();
      Produits var8 = null;
      if (var7.size() > 0) {
         ProduitsDepot var9 = (ProduitsDepot)var7.get(0);
         var8 = var9.getProduits();
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List rechercheProduitDepotRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      if (var1 != null && !var1.isEmpty()) {
         var5 = var2.createQuery("from ProduitsDepot where " + var1 + " order by produits.proCode").list();
      } else {
         var5 = var2.createQuery("from ProduitsDepot order by produits.proCode").list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheReaoppro(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      if (var1 != null && !var1.isEmpty()) {
         var5 = var2.createQuery("from ProduitsDepot where " + var1 + " and prodepQteMini<>0 order by produits.proCode").list();
      } else {
         var5 = var2.createQuery("from ProduitsDepot where prodepQteMini<>0 order by produits.proCode").list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List produitDepByprodList(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var3 = true;
      }

      Query var4 = var2.createQuery("from ProduitsDepot where depot.dpoInactif=0 and depot.dpoCode = '" + var1 + "'");
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
