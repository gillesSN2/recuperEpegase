package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ProduitsDci;
import com.epegase.systeme.classe.ProduitsMedicamment;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class ProduitsMedicammentDao implements Serializable {
   private ProduitsMedicamment medicamment;
   private ProduitsDci produitsDci;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ProduitsMedicammentDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public ProduitsMedicamment insertMed(ProduitsMedicamment var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public ProduitsMedicamment modifMed(ProduitsMedicamment var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void deleteMed(ProduitsMedicamment var1, Session var2) {
      var2.delete(var1);
   }

   public ProduitsDci insertDci(ProduitsDci var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public ProduitsDci modifDci(ProduitsDci var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void deleteDci(ProduitsDci var1, Session var2) {
      var2.delete(var1);
   }

   public List selectAllMedicammentMedical(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "MedicammentPublic");
         var2 = true;
      }

      Query var3 = var1.createQuery("from ProduitsMedicamment order by promdcCodeCip");
      Object var4 = new ArrayList();
      if (var3.list() != null) {
         var4 = var3.list();
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var4;
   }

   public List selectAllDciMedical(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "MedicammentPublic");
         var2 = true;
      }

      Query var3 = var1.createQuery("from ProduitsDci order by prodciCode");
      Object var4 = new ArrayList();
      if (var3.list() != null) {
         var4 = var3.list();
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var4;
   }

   public List listeDciItems(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "MedicammentPublic");
         var3 = true;
      }

      new ArrayList();
      ArrayList var5 = new ArrayList();
      if (var1 != 100) {
         Query var6 = var2.createQuery("from ProduitsDci where prodciType = " + var1 + " order by prodciCode");
         if (var6.list() != null) {
            List var4 = var6.list();
            if (var4.size() != 0) {
               for(int var7 = 0; var7 < var4.size(); ++var7) {
                  var5.add(new SelectItem(((ProduitsDci)var4.get(var7)).getProdciCode()));
               }
            }
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List listeClasseItems(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "MedicammentPublic");
         var3 = true;
      }

      new ArrayList();
      ArrayList var5 = new ArrayList();
      if (var1 != 100) {
         Query var6 = var2.createQuery("from ProduitsMedicamment where promdcType = " + var1 + " group by promdcClasse order by promdcClasse");
         if (var6.list() != null) {
            List var4 = var6.list();
            if (var4.size() != 0) {
               for(int var7 = 0; var7 < var4.size(); ++var7) {
                  var5.add(new SelectItem(((ProduitsMedicamment)var4.get(var7)).getPromdcClasse()));
               }
            }
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheMedicamments(int var1, String var2, String var3, String var4, String var5, Session var6) throws HibernateException, NamingException {
      boolean var7 = false;
      if (var6 == null) {
         var6 = this.utilInitHibernate.getOpenSession(this.mabase, "MedicammentPublic");
         var7 = true;
      }

      Object var8 = new ArrayList();
      if (var1 != 100) {
         String var9 = "";
         if (var2 != null && !var2.isEmpty()) {
            var9 = var9 + " and promdcCodeCip LIKE '" + var2 + "%'";
         }

         if (var3 != null && !var3.isEmpty()) {
            var9 = var9 + " and  promdcSpecialite LIKE '" + var3 + "%'";
         }

         if (var4 != null && !var4.isEmpty()) {
            var9 = var9 + " and promdcCodeDci LIKE '" + var4 + "%'";
         }

         if (var5 != null && !var5.isEmpty()) {
            var9 = var9 + " and promdcClasse LIKE '" + var5 + "%'";
         }

         Query var10 = var6.createQuery("from ProduitsMedicamment where promdcType = " + var1 + var9 + " order by promdcCodeCip");
         if (var10.list() != null) {
            var8 = var10.list();
         }
      }

      if (var7) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var8;
   }

   public List rechercheMedicamments(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "MedicammentPublic");
         var3 = true;
      }

      Object var4 = new ArrayList();
      String var5 = "";
      if (var1.equals("*")) {
         var1 = "";
      }

      if (var1 != null && !var1.isEmpty()) {
         var5 = var5 + " (promdcCodeCip LIKE '" + var1 + "%' or  promdcSpecialite LIKE '" + var1 + "%' or promdcCodeDci LIKE '" + var1 + "%' or promdcClasse LIKE '" + var1 + "%')";
      }

      if (var5 == null || var5.isEmpty()) {
         var5 = "promdcId>=1";
      }

      Query var6 = var2.createQuery("from ProduitsMedicamment where " + var5 + " order by promdcCodeCip");
      if (var6.list() != null) {
         var4 = var6.list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var4;
   }

   public ProduitsMedicamment rechercheSpecialite(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "MedicammentPublic");
         var3 = true;
      }

      new ArrayList();
      new ProduitsMedicamment();
      Query var6 = var2.createQuery("from ProduitsMedicamment where promdcSpecialite ='" + var1 + "' order by promdcCodeCip").setMaxResults(1);
      ProduitsMedicamment var5;
      if (var6.list() != null) {
         List var4 = var6.list();
         if (var4.size() != 0) {
            var5 = (ProduitsMedicamment)var4.get(0);
         } else {
            var5 = null;
         }
      } else {
         var5 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public ProduitsDci rechercheDci(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "MedicammentPublic");
         var3 = true;
      }

      new ProduitsDci();
      Query var5 = var2.createQuery("from ProduitsDci where prodciCode='" + var1 + "'").setMaxResults(1);
      new ArrayList();
      List var6 = var5.list();
      ProduitsDci var4;
      if (var6.size() != 0) {
         var4 = (ProduitsDci)var6.get(0);
      } else {
         var4 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public ProduitsMedicamment rechercheById(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "MedicammentPublic");
         var4 = true;
      }

      new ArrayList();
      new ProduitsMedicamment();
      Query var7 = var3.createQuery("from ProduitsMedicamment where promdcId ='" + var1 + "'").setMaxResults(1);
      ProduitsMedicamment var6;
      if (var7.list() != null) {
         List var5 = var7.list();
         if (var5.size() != 0) {
            var6 = (ProduitsMedicamment)var5.get(0);
         } else {
            var6 = null;
         }
      } else {
         var6 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
