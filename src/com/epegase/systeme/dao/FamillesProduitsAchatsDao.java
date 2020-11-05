package com.epegase.systeme.dao;

import com.epegase.systeme.classe.FamillesProduitsAchats;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FamillesProduitsAchatsDao implements Serializable {
   private FamillesProduitsAchats famillesProduitsAchats;
   private Produits produits;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public FamillesProduitsAchatsDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public FamillesProduitsAchats insert(FamillesProduitsAchats var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public FamillesProduitsAchats modif(FamillesProduitsAchats var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(FamillesProduitsAchats var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "FamillesProduitsAchats");
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

   public void delete(FamillesProduitsAchats var1, Session var2) {
      var2.delete(var1);
   }

   public String delFamilleProd(FamillesProduitsAchats var1, Session var2) {
      Query var3 = var2.createQuery("delete from FamillesProduitsAchats where famachId =" + var1.getFamachId());
      var3.executeUpdate();
      return null;
   }

   public List selectAllFamillProd(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "FamillesProduitsAchats");
         var4 = true;
      }

      Query var5 = var3.createQuery("from FamillesProduitsAchats where exercicesAchats=:exo order by famachCode asc");
      var5.setLong("exo", var1);
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List selectAllFamillUtil(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "FamillesProduitsAchats");
         var4 = true;
      }

      Query var5 = var3.createQuery("from FamillesProduitsAchats where famachCat<90 and famachStock<>0 and exercicesAchats=:exo order by famachCode asc");
      var5.setLong("exo", var1);
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List selectAllFamillByCode(long var1, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "FamillesProduitsAchats");
         var5 = true;
      }

      Query var6 = null;
      if (var3 != null && !var3.isEmpty() && var3.contains(":")) {
         String[] var7 = var3.split(":");
         var6 = var4.createQuery("from FamillesProduitsAchats where famachCat<90 and exercicesAchats=:exo and famachCode like '" + var7[0] + "%' order by famachCode asc").setLong("exo", var1);
      } else {
         var6 = var4.createQuery("from FamillesProduitsAchats where famachCat<90 and exercicesAchats=:exo order by famachCode asc").setLong("exo", var1);
      }

      List var8 = var6.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public FamillesProduitsAchats rechercheFamilleByCode(long var1, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "FamillesProduitsAchats");
         var5 = true;
      }

      String var6 = "";
      String[] var7;
      if (var3 != null && !var3.isEmpty() && var3.contains(":")) {
         var7 = var3.split(":");
         var6 = var7[0];
      }

      var7 = null;
      Query var10;
      if (var1 != 0L) {
         var10 = var4.createQuery("from FamillesProduitsAchats where exercicesAchats=:exo and famachCode=:cod").setString("cod", var3).setLong("exo", var1).setMaxResults(1);
      } else {
         var10 = var4.createQuery("from FamillesProduitsAchats where famachCode=:cod").setString("cod", var3).setMaxResults(1);
      }

      new FamillesProduitsAchats();
      new ArrayList();
      List var9 = var10.list();
      FamillesProduitsAchats var8;
      if (var9.size() != 0) {
         var8 = (FamillesProduitsAchats)var9.get(0);
      } else {
         ++var1;
         var10 = var4.createQuery("from FamillesProduitsAchats where exercicesAchats=:exo and famachCode=:cod").setString("cod", var3).setLong("exo", var1).setMaxResults(1);
         new FamillesProduitsAchats();
         new ArrayList();
         var9 = var10.list();
         if (var9.size() != 0) {
            var8 = (FamillesProduitsAchats)var9.get(0);
         } else {
            var1 -= 2L;
            var10 = var4.createQuery("from FamillesProduitsAchats where exercicesAchats=:exo and famachCode=:cod").setString("cod", var3).setLong("exo", var1).setMaxResults(1);
            new FamillesProduitsAchats();
            new ArrayList();
            var9 = var10.list();
            if (var9.size() != 0) {
               var8 = (FamillesProduitsAchats)var9.get(0);
            } else {
               var8 = null;
            }
         }
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public boolean existCode(long var1, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      boolean var6 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "FamillesProduitsAchats");
         var6 = true;
      }

      Query var7 = var4.createQuery("from FamillesProduitsAchats where exercicesAchats=:exo and famachCode=:cod").setString("cod", var3).setLong("exo", var1).setMaxResults(1);
      List var8 = var7.list();
      if (var8.size() != 0) {
         var5 = false;
      } else {
         var5 = true;
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public FamillesProduitsAchats rechercheFamilleByProd(long var1, Produits var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "FamillesProduitsAchats");
         var5 = true;
      }

      Query var6 = var4.createQuery("from FamillesProduitsAchats where exercicesAchats=:exo and famachCode=:cod").setString("cod", var3.getProAchCode()).setLong("exo", var1).setMaxResults(1);
      List var7 = var6.list();
      FamillesProduitsAchats var8 = null;
      if (var7.size() != 0) {
         var8 = (FamillesProduitsAchats)var7.get(0);
      } else {
         var1 = var1++;
         var6 = var4.createQuery("from FamillesProduitsAchats where exercicesAchats=:exo and famachCode=:cod").setString("cod", var3.getProAchCode()).setLong("exo", var1).setMaxResults(1);
         new FamillesProduitsAchats();
         new ArrayList();
         var7 = var6.list();
         if (var7.size() != 0) {
            var8 = (FamillesProduitsAchats)var7.get(0);
         } else {
            var1 -= 2L;
            var6 = var4.createQuery("from FamillesProduitsAchats where exercicesAchats=:exo and famachCode=:cod").setString("cod", var3.getProAchCode()).setLong("exo", var1).setMaxResults(1);
            new FamillesProduitsAchats();
            new ArrayList();
            var7 = var6.list();
            if (var7.size() != 0) {
               var8 = (FamillesProduitsAchats)var7.get(0);
            } else {
               var8 = null;
            }
         }
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List chargerFamilleProduitAchatsItems(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "FamillesProduitsAchats");
         var4 = true;
      }

      Query var5 = var3.createQuery("from FamillesProduitsAchats where exercicesAchats=:exo and famachInactif=0 order by famachCode asc").setLong("exo", var1);
      Object var6 = new ArrayList();
      if (var5.list() != null) {
         var6 = var5.list();
      }

      ArrayList var7 = new ArrayList();
      if (((List)var6).size() != 0) {
         new FamillesProduitsAchats();

         for(int var9 = 0; var9 < ((List)var6).size(); ++var9) {
            FamillesProduitsAchats var8 = (FamillesProduitsAchats)((List)var6).get(var9);
            if (var8.getFamachCode() != null && !var8.getFamachCode().isEmpty()) {
               String var10 = var8.getFamachLibelleFr();
               if (var10 == null || var10.isEmpty()) {
                  var10 = "???";
               }

               var7.add(new SelectItem(var8.getFamachCode() + ":" + var10));
            }
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerFamilleProduitAchatsUtilItems(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "FamillesProduitsAchats");
         var4 = true;
      }

      Query var5 = var3.createQuery("from FamillesProduitsAchats where exercicesAchats=:exo and famachCat<=90 and famachInactif=0 order by famachCode asc");
      var5.setLong("exo", var1);
      Object var6 = new ArrayList();
      if (var5.list() != null) {
         var6 = var5.list();
      }

      ArrayList var7 = new ArrayList();
      if (((List)var6).size() != 0) {
         for(int var8 = 0; var8 < ((List)var6).size(); ++var8) {
            FamillesProduitsAchats var9 = (FamillesProduitsAchats)((List)var6).get(var8);
            if (var9.getFamachCode() != null && !var9.getFamachCode().isEmpty()) {
               String var10 = var9.getFamachLibelleFr();
               if (var10 == null || var10.isEmpty()) {
                  var10 = "???";
               }

               var7.add(new SelectItem(var9.getFamachCode() + ":" + var10));
            }
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerFamilleProduitAchatsFamItems(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "FamillesProduitsAchats");
         var4 = true;
      }

      Query var5 = var3.createQuery("from FamillesProduitsAchats where exercicesAchats=:exo and (famachCat>=90 and famachCat<=99) and famachInactif=0 order by famachCode asc");
      var5.setLong("exo", var1);
      Object var6 = new ArrayList();
      if (var5.list() != null) {
         var6 = var5.list();
      }

      ArrayList var7 = new ArrayList();
      if (((List)var6).size() != 0) {
         for(int var8 = 0; var8 < ((List)var6).size(); ++var8) {
            FamillesProduitsAchats var9 = (FamillesProduitsAchats)((List)var6).get(var8);
            if (var9.getFamachCode() != null && !var9.getFamachCode().isEmpty()) {
               String var10 = var9.getFamachLibelleFr();
               if (var10 == null || var10.isEmpty()) {
                  var10 = "???";
               }

               var7.add(new SelectItem(var9.getFamachCode() + ":" + var10));
            }
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerFamilleProduitAchatsSousFamItems(long var1, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "FamillesProduitsAchats");
         var5 = true;
      }

      Query var6 = var4.createQuery("from FamillesProduitsAchats where exercicesAchats=:exo and famachCat<=90 and (famachCode like '" + var3 + "%' or famachOrigine like '" + var3 + "')  and famachInactif=0 order by famachCode asc");
      var6.setLong("exo", var1);
      Object var7 = new ArrayList();
      if (var6.list() != null) {
         var7 = var6.list();
      }

      ArrayList var8 = new ArrayList();
      if (((List)var7).size() != 0) {
         for(int var9 = 0; var9 < ((List)var7).size(); ++var9) {
            FamillesProduitsAchats var10 = (FamillesProduitsAchats)((List)var7).get(var9);
            if (var10.getFamachCode() != null && !var10.getFamachCode().isEmpty()) {
               String var11 = var10.getFamachLibelleFr();
               if (var11 == null || var11.isEmpty()) {
                  var11 = "???";
               }

               var8.add(new SelectItem(var10.getFamachCode() + ":" + var11));
            }
         }
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }
}
