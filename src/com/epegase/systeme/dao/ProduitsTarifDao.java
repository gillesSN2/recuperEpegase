package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsTarif;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProduitsTarifDao implements Serializable {
   private ProduitsTarif produitsTarif;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public ProduitsTarifDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public ProduitsTarif insert(ProduitsTarif var1) throws HibernateException, NamingException {
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

   public ProduitsTarif insert(ProduitsTarif var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public ProduitsTarif modif(ProduitsTarif var1) throws HibernateException, NamingException {
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

   public ProduitsTarif modif(ProduitsTarif var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(ProduitsTarif var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsVtes");
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

   public void delete(ProduitsTarif var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List selectAllProduitsTarif(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsTarif");
         var2 = true;
      }

      List var3 = var1.createQuery("from ProduitsTarif ").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List selectProdTarifByprod(Produits var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsTarif");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from ProduitsTarif where produits.proId=:id").setLong("id", var1.getProId());
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public ProduitsTarif selectProdTarifByprodCat(Produits var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsTarif");
         var4 = true;
      }

      new ArrayList();
      new ProduitsTarif();
      Query var7 = var3.createQuery("from ProduitsTarif where produits.proId=:id and protarClient=:client").setLong("id", var1.getProId()).setString("client", var2).setMaxResults(1);
      List var5 = var7.list();
      ProduitsTarif var6;
      if (var5.size() != 0) {
         var6 = (ProduitsTarif)var5.get(0);
      } else {
         if (var2 != null && !var2.isEmpty()) {
            if (var2.equals("CNAMGS")) {
               var2 = "Non Assuré";
            } else if (var2.equals("Société")) {
               var2 = "Assuré";
            }
         } else {
            var2 = "UNIQUE";
         }

         var7 = var3.createQuery("from ProduitsTarif where produits.proId=:id and protarClient='" + var2 + "'").setLong("id", var1.getProId()).setMaxResults(1);
         var5 = var7.list();
         if (var5.size() != 0) {
            var6 = (ProduitsTarif)var5.get(0);
         } else {
            var7 = var3.createQuery("from ProduitsTarif where produits.proId=:id and protarClient='UNIQUE'").setLong("id", var1.getProId()).setMaxResults(1);
            var5 = var7.list();
            if (var5.size() != 0) {
               var6 = (ProduitsTarif)var5.get(0);
            } else {
               var6 = null;
            }
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public ProduitsTarif selectProdTarifByLettre(String var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsTarif");
      ProduitsTarif var3 = (ProduitsTarif)var2.createQuery("from ProduitsTarif where protarLettre=:param").setParameter("param", var1);
      this.utilInitHibernate.closeSession();
      return var3;
   }

   public ProduitsTarif selectProdTarifByLettreCategorie(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsTarif");
         var4 = true;
      }

      ProduitsTarif var5 = (ProduitsTarif)var3.createQuery("from ProduitsTarif where protarLettre=:param1 and protarClient=:param2").setString("param1", var1).setString("param2", var2).uniqueResult();
      if (var5 == null) {
         var5 = (ProduitsTarif)var3.createQuery("from ProduitsTarif where protarLettre=:param1 and protarClient='UNIQUE'").setString("param1", var1).uniqueResult();
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public ProduitsTarif prixUnitaireCorrespond(long var1, String var3, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsTarif");
         var6 = true;
      }

      Query var7 = null;
      ProduitsTarif var8 = null;
      List var9 = null;
      if (var1 != 0L) {
         if (var4 != null && !var4.isEmpty()) {
            if (var3 != null && !var3.isEmpty()) {
               var7 = var5.createQuery("from ProduitsTarif where produits.proId=" + var1 + " AND protarClient='" + var3 + "' and protarCondit='" + var4 + "'").setMaxResults(1);
            } else {
               var7 = var5.createQuery("from ProduitsTarif where produits.proId=" + var1 + " and protarCondit='" + var4 + "'").setMaxResults(1);
            }

            var9 = var7.list();
            if (var9.size() == 0) {
               if (var3 != null && !var3.isEmpty()) {
                  var7 = var5.createQuery("from ProduitsTarif where produits.proId=" + var1 + " AND protarClient='" + var3 + "'").setMaxResults(1);
               } else {
                  var7 = var5.createQuery("from ProduitsTarif where produits.proId=" + var1).setMaxResults(1);
               }

               var9 = var7.list();
               if (var9.size() > 0) {
                  var8 = (ProduitsTarif)var9.get(0);
               }
            } else {
               var8 = (ProduitsTarif)var9.get(0);
            }
         } else {
            if (var3 != null && !var3.isEmpty()) {
               var7 = var5.createQuery("from ProduitsTarif where produits.proId=" + var1 + " AND protarClient='" + var3 + "'").setMaxResults(1);
            } else {
               var7 = var5.createQuery("from ProduitsTarif where produits.proId=" + var1).setMaxResults(1);
            }

            var9 = var7.list();
            if (var9.size() > 0) {
               var8 = (ProduitsTarif)var9.get(0);
            } else {
               var7 = var5.createQuery("from ProduitsTarif where produits.proId=" + var1).setMaxResults(1);
               var9 = var7.list();
               if (var9.size() > 0) {
                  var8 = (ProduitsTarif)var9.get(0);
               }
            }
         }
      }

      if (var9.size() == 0) {
         if (var4 != null && !var4.isEmpty()) {
            var7 = var5.createQuery("from ProduitsTarif where produits.proId=" + var1 + " AND protarClient='UNIQUE' and protarCondit='" + var4 + "'").setMaxResults(1);
            var9 = var7.list();
            if (var9.size() == 0) {
               var7 = var5.createQuery("from ProduitsTarif where produits.proId=" + var1 + " AND protarClient='UNIQUE'").setMaxResults(1);
               var9 = var7.list();
               if (var9.size() > 0) {
                  var8 = (ProduitsTarif)var9.get(0);
               }
            } else {
               var8 = (ProduitsTarif)var9.get(0);
            }
         } else {
            var7 = var5.createQuery("from ProduitsTarif where produits.proId=" + var1 + " AND protarClient='UNIQUE'").setMaxResults(1);
            var9 = var7.list();
            if (var9.size() > 0) {
               var8 = (ProduitsTarif)var9.get(0);
            }
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }
}
