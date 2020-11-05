package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FamillesProduitsVentes;
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

public class FamillesProduitsVentesDao implements Serializable {
   private FamillesProduitsVentes famillesProduitsVentes;
   private Produits produits;
   private ExercicesVentes exercicesVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public FamillesProduitsVentesDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public FamillesProduitsVentes insert(FamillesProduitsVentes var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "FamillesProduitsVentes");
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

   public FamillesProduitsVentes insert(FamillesProduitsVentes var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public FamillesProduitsVentes modif(FamillesProduitsVentes var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "FamillesProduitsVentes");
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

   public FamillesProduitsVentes modif(FamillesProduitsVentes var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(FamillesProduitsVentes var1, Session var2) {
      var2.delete(var1);
   }

   public String deletFamillesProduitsVentes(long var1, Session var3) {
      Query var4 = var3.createQuery("delete from FamillesProduitsVentes where famvteId =:Sid");
      var4.setParameter("Sid", var1);
      var4.executeUpdate();
      return null;
   }

   public FamillesProduitsVentes rechercheFamilleByProd(long var1, Produits var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "FamillesProduitsVentes");
         var5 = true;
      }

      Query var6 = var4.createQuery("from FamillesProduitsVentes where exerciceventes=:exo and famvteCode=:cod").setParameter("cod", var3.getProVteCode()).setLong("exo", var1).setMaxResults(1);
      FamillesProduitsVentes var7 = null;
      List var8 = var6.list();
      if (var8.size() > 0) {
         var7 = (FamillesProduitsVentes)var8.get(0);
      } else {
         var7 = null;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public FamillesProduitsVentes rechercheFamilleByCode(long var1, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "FamillesProduitsVentes");
         var5 = true;
      }

      String var6 = "";
      String[] var7;
      if (var3 != null && !var3.isEmpty() && var3.contains(":")) {
         var7 = var3.split(":");
         var6 = var7[0];
      } else {
         var6 = var3;
      }

      var7 = null;
      Query var10;
      if (var1 != 0L) {
         var10 = var4.createQuery("from FamillesProduitsVentes where exerciceventes=:exo and famvteCode=:cod").setString("cod", var6).setLong("exo", var1).setMaxResults(1);
      } else {
         var10 = var4.createQuery("from FamillesProduitsVentes where famvteCode=:cod").setString("cod", var6).setMaxResults(1);
      }

      new FamillesProduitsVentes();
      new ArrayList();
      List var9 = var10.list();
      FamillesProduitsVentes var8;
      if (var9.size() != 0) {
         var8 = (FamillesProduitsVentes)var9.get(0);
      } else {
         var8 = null;
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
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "FamillesProduitsVentes");
         var6 = true;
      }

      Query var7 = var4.createQuery("from FamillesProduitsVentes where exerciceventes=:exo and famvteCode=:cod");
      var7.setParameter("cod", var3);
      var7.setLong("exo", var1);
      var7.setMaxResults(1);
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

   public List selectAllFamillProd(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "FamillesProduitsVentes");
         var4 = true;
      }

      Query var5 = var3.createQuery("from FamillesProduitsVentes where exerciceventes=:exo order by famvteCode asc").setLong("exo", var1);
      Object var6 = new ArrayList();
      if (var5.list() != null) {
         var6 = var5.list();
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var6;
   }

   public List selectAllFamillUtil(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "FamillesProduitsVentes");
         var4 = true;
      }

      Query var5 = var3.createQuery("from FamillesProduitsVentes where famvteCat<=90 and exerciceventes=:exo order by famvteCode asc").setLong("exo", var1);
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List selectAllFamillUtilCartes(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "FamillesProduitsVentes");
         var4 = true;
      }

      Query var5 = var3.createQuery("from FamillesProduitsVentes where famvteCat<=90 and famvteNature = '1615' and exerciceventes=:exo order by famvteCode asc").setLong("exo", var1);
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List selectAllFamillByCode(long var1, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "FamillesProduitsVentes");
         var5 = true;
      }

      Query var6 = null;
      if (var3 != null && !var3.isEmpty() && var3.contains(":")) {
         String[] var7 = var3.split(":");
         var6 = var4.createQuery("from FamillesProduitsVentes where famvteCat<=90 and exerciceventes=:exo and famvteCode like '" + var7[0] + "%' order by famvteCode asc").setLong("exo", var1);
      } else {
         var6 = var4.createQuery("from FamillesProduitsVentes where famvteCat<=90 and exerciceventes=:exo order by famvteCode asc").setLong("exo", var1);
      }

      List var8 = var6.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List chargerFamilleProduitVentesItems(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "FamillesProduitsVentes");
         var4 = true;
      }

      Query var5 = var3.createQuery("from FamillesProduitsVentes where exerciceventes=:exo and famvteInactif=0 order by famvteCode asc").setLong("exo", var1);
      Object var6 = new ArrayList();
      if (var5.list() != null) {
         var6 = var5.list();
      }

      ArrayList var7 = new ArrayList();
      if (((List)var6).size() != 0) {
         new FamillesProduitsVentes();

         for(int var9 = 0; var9 < ((List)var6).size(); ++var9) {
            FamillesProduitsVentes var8 = (FamillesProduitsVentes)((List)var6).get(var9);
            if (var8.getFamvteCode() != null && !var8.getFamvteCode().isEmpty()) {
               String var10 = var8.getFamvteLibelleFr();
               if (var10 == null || var10.isEmpty()) {
                  var10 = "???";
               }

               var7.add(new SelectItem(var8.getFamvteCode() + ":" + var10));
            }
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerFamilleProduitVentesUtilItems(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "FamillesProduitsVentes");
         var4 = true;
      }

      Query var5 = var3.createQuery("from FamillesProduitsVentes where exerciceventes=:exo and famvteCat<=90 and famvteInactif=0 order by famvteCode asc");
      var5.setLong("exo", var1);
      Object var6 = new ArrayList();
      if (var5.list() != null) {
         var6 = var5.list();
      }

      ArrayList var7 = new ArrayList();
      if (((List)var6).size() != 0) {
         new FamillesProduitsVentes();

         for(int var9 = 0; var9 < ((List)var6).size(); ++var9) {
            FamillesProduitsVentes var8 = (FamillesProduitsVentes)((List)var6).get(var9);
            if (var8.getFamvteCode() != null && !var8.getFamvteCode().isEmpty()) {
               String var10 = var8.getFamvteLibelleFr();
               if (var10 == null || var10.isEmpty()) {
                  var10 = "???";
               }

               var7.add(new SelectItem(var8.getFamvteCode() + ":" + var10));
            }
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerFamilleProduitVentesFamItems(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "FamillesProduitsVentes");
         var4 = true;
      }

      Query var5 = var3.createQuery("from FamillesProduitsVentes where exerciceventes=:exo and (famvteCat>=90 and famvteCat<=99) and famvteInactif=0 order by famvteCode asc").setLong("exo", var1);
      Object var6 = new ArrayList();
      if (var5.list() != null) {
         var6 = var5.list();
      }

      ArrayList var7 = new ArrayList();
      if (((List)var6).size() != 0) {
         new FamillesProduitsVentes();

         for(int var9 = 0; var9 < ((List)var6).size(); ++var9) {
            FamillesProduitsVentes var8 = (FamillesProduitsVentes)((List)var6).get(var9);
            if (var8.getFamvteCode() != null && !var8.getFamvteCode().isEmpty()) {
               String var10 = var8.getFamvteLibelleFr();
               if (var10 == null || var10.isEmpty()) {
                  var10 = "???";
               }

               var7.add(new SelectItem(var8.getFamvteCode() + ":" + var10));
            }
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerFamilleProduitVentesSousFamItems(long var1, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "FamillesProduitsVentes");
         var5 = true;
      }

      Query var6 = var4.createQuery("from FamillesProduitsVentes where exerciceventes=:exo and famvteCat<=90 and (famvteCode like '" + var3 + "%' or famvteOrigine like '" + var3 + "') and famvteInactif=0 order by famvteCode asc");
      var6.setLong("exo", var1);
      Object var7 = new ArrayList();
      if (var6.list() != null) {
         var7 = var6.list();
      }

      ArrayList var8 = new ArrayList();
      if (((List)var7).size() != 0) {
         new FamillesProduitsVentes();

         for(int var10 = 0; var10 < ((List)var7).size(); ++var10) {
            FamillesProduitsVentes var9 = (FamillesProduitsVentes)((List)var7).get(var10);
            if (var9.getFamvteCode() != null && !var9.getFamvteCode().isEmpty()) {
               String var11 = var9.getFamvteLibelleFr();
               if (var11 == null || var11.isEmpty()) {
                  var11 = "???";
               }

               var8.add(new SelectItem(var9.getFamvteCode() + ":" + var11));
            }
         }
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List chargerFamilleProduitActesItems(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "FamillesProduitsVentes");
         var4 = true;
      }

      Query var5 = var3.createQuery("from FamillesProduitsVentes where exerciceventes=:exo and famvteNature='1104' and famvteInactif=0 order by famvteCode asc");
      var5.setLong("exo", var1);
      Object var6 = new ArrayList();
      if (var5.list() != null) {
         var6 = var5.list();
      }

      ArrayList var7 = new ArrayList();
      if (((List)var6).size() != 0) {
         for(int var8 = 0; var8 < ((List)var6).size(); ++var8) {
            FamillesProduitsVentes var9 = (FamillesProduitsVentes)((List)var6).get(var8);
            if (var9.getFamvteCode() != null && !var9.getFamvteCode().isEmpty()) {
               String var10 = var9.getFamvteLibelleFr();
               if (var10 == null || var10.isEmpty()) {
                  var10 = "???";
               }

               var7.add(new SelectItem(var9.getFamvteCode() + ":" + var10));
            }
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerFamilleProduitMedocItems(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "FamillesProduitsVentes");
         var4 = true;
      }

      Query var5 = var3.createQuery("from FamillesProduitsVentes where exerciceventes=:exo and famvteNature='1105' and famvteInactif=0 order by famvteCode asc");
      var5.setLong("exo", var1);
      Object var6 = new ArrayList();
      if (var5.list() != null) {
         var6 = var5.list();
      }

      ArrayList var7 = new ArrayList();
      if (((List)var6).size() != 0) {
         for(int var8 = 0; var8 < ((List)var6).size(); ++var8) {
            FamillesProduitsVentes var9 = (FamillesProduitsVentes)((List)var6).get(var8);
            if (var9.getFamvteCode() != null && !var9.getFamvteCode().isEmpty()) {
               String var10 = var9.getFamvteLibelleFr();
               if (var10 == null || var10.isEmpty()) {
                  var10 = "???";
               }

               var7.add(new SelectItem(var9.getFamvteCode() + ":" + var10));
            }
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public FamillesProduitsVentes FamillesProduitsMedicalByNature(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "FamillesProduitsVentes");
         var3 = true;
      }

      Query var4 = var2.createQuery("from FamillesProduitsVentes where famvteCat<=90 and famvteNature=:nature").setString("nature", var1).setMaxResults(1);
      FamillesProduitsVentes var5 = null;
      List var6 = var4.list();
      if (var6.size() > 0) {
         var5 = (FamillesProduitsVentes)var6.get(0);
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
