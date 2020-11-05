package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ProduitsReponse;
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

public class ProduitsReponseDao implements Serializable {
   private String mabase;
   private ProduitsReponse produitsReponse;
   private UtilInitHibernate utilInitHibernate;

   public ProduitsReponseDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public ProduitsReponse insert(ProduitsReponse var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ProduitsMedic");
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

   public ProduitsReponse modif(ProduitsReponse var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ProduitsMedic");
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

   public void delete(ProduitsReponse var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ProduitsMedic");
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

   public void delete(ProduitsReponse var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public void ordonnnerAscendant(int var1, int var2, long var3, long var5) throws HibernateException, NamingException {
      Session var7 = this.utilInitHibernate.getOpenSession(this.mabase, "ProduitsMedic");
      Transaction var8 = null;

      try {
         var8 = var7.beginTransaction();
         String var9 = "update ProduitsReponse pb set pb.prorepOrdre=:ordPrec where pb.prorepId=:idTab";
         var7.createQuery(var9).setInteger("ordPrec", var2).setLong("idTab", var3).executeUpdate();
         String var11 = "update ProduitsReponse pb set pb.prorepOrdre=:ord1 where pb.prorepId=:idTab";
         var7.createQuery(var11).setInteger("ord1", var1).setLong("idTab", var5).executeUpdate();
         var8.commit();
      } catch (HibernateException var16) {
         if (var8 != null) {
            var8.rollback();
         }

         throw var16;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void ordonnnerDescendant(int var1, int var2, long var3, long var5) throws HibernateException, NamingException {
      Session var7 = this.utilInitHibernate.getOpenSession(this.mabase, "ProduitsMedic");
      Transaction var8 = null;

      try {
         var8 = var7.beginTransaction();
         String var9 = "update ProduitsReponse pb set pb.prorepOrdre=:ordSuiv where pb.prorepId=:idTab";
         var7.createQuery(var9).setInteger("ordSuiv", var2).setLong("idTab", var3).executeUpdate();
         String var11 = "update ProduitsReponse pb set pb.prorepOrdre=:ord1 where pb.prorepId=:idTab";
         var7.createQuery(var11).setInteger("ord1", var1).setLong("idTab", var5).executeUpdate();
         var8.commit();
      } catch (HibernateException var16) {
         if (var8 != null) {
            var8.rollback();
         }

         throw var16;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public List chargeProdReponseByProd(String var1, int var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ProduitsMedic");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from ProduitsReponse where prorepCode=:code and prorepType=:rep order by prorepOrdre").setString("code", var1);
      var6.setInteger("rep", var2);
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargeProdReponseByProd(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ProduitsMedic");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from ProduitsReponse where prorepCode=:code order by prorepOrdre").setString("code", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargeProdReponseByProd(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ProduitsMedic");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from ProduitsReponse where prorepCode=:code and prorepLibelle=:lib order by prorepOrdre").setString("code", var1).setString("lib", var2);
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargeProdReponseByProdItems(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ProduitsMedic");
         var3 = true;
      }

      new ArrayList();
      ArrayList var5 = new ArrayList();
      Query var6 = var2.createQuery("from ProduitsReponse where prorepCode=:code order by prorepOrdre").setString("code", var1);
      List var4 = var6.list();
      if (var4.size() != 0) {
         for(int var7 = 0; var7 < var4.size(); ++var7) {
            var5.add(new SelectItem(((ProduitsReponse)var4.get(var7)).getProrepId(), ((ProduitsReponse)var4.get(var7)).getProrepReponse()));
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargeProdReponseByProdItems(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ProduitsMedic");
         var4 = true;
      }

      new ArrayList();
      ArrayList var6 = new ArrayList();
      Query var7 = var3.createQuery("from ProduitsReponse where prorepCode=:code and prorepLibelle=:lib order by prorepOrdre").setString("code", var1).setString("lib", var2);
      List var5 = var7.list();
      if (var5.size() != 0) {
         for(int var8 = 0; var8 < var5.size(); ++var8) {
            var6.add(new SelectItem(((ProduitsReponse)var5.get(var8)).getProrepId(), ((ProduitsReponse)var5.get(var8)).getProrepReponse()));
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargeProdReponseByLab(long var1, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "ProduitsMedic");
         var5 = true;
      }

      new ArrayList();
      Query var7 = var4.createQuery("from ProduitsReponse where prolab_id=:id and prorepType=:rep order by prorepOrdre").setLong("id", var1).setInteger("rep", var3);
      List var6 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargeProdReponseByDet(long var1, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "ProduitsMedic");
         var5 = true;
      }

      new ArrayList();
      Query var7 = var4.createQuery("from ProduitsReponse where prodet_id=:id and prorepType=:rep order by prorepOrdre").setLong("id", var1).setInteger("rep", var3);
      List var6 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public ProduitsReponse chargeProdReponseById(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ProduitsMedic");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from ProduitsReponse where prorepId=:id").setLong("id", var1).setMaxResults(1);
      List var5 = var6.list();
      this.produitsReponse = new ProduitsReponse();
      if (var5.size() != 0) {
         this.produitsReponse = (ProduitsReponse)var5.get(0);
      } else {
         this.produitsReponse = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.produitsReponse;
   }
}
