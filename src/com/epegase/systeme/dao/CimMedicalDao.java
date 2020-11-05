package com.epegase.systeme.dao;

import com.epegase.systeme.classe.CimMedical;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CimMedicalDao implements Serializable {
   private CimMedical cimMedical;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public CimMedicalDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public CimMedical modif(CimMedical var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "CimMedical");
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

   public List selectallCimMedical(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "CimMedical");
         var2 = true;
      }

      List var3 = var1.createQuery("from CimMedical").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List selectallCimMedical(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "CimMedical");
         var3 = true;
      }

      String var4 = "";
      var4 = "from CimMedical where cimCodeCmd= '" + var1 + "' order by cimLibelleFR";
      Query var5 = var2.createQuery(var4);
      List var6 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public CimMedical selectOneCim(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "CimMedical");
         var3 = true;
      }

      String var4 = "";
      var4 = "from CimMedical where cimCode= '" + var1 + "' order by cimLibelleFR";
      Query var5 = var2.createQuery(var4).setMaxResults(1);
      new ArrayList();
      CimMedical var7 = new CimMedical();
      List var6 = var5.list();
      if (var6.size() != 0) {
         var7 = (CimMedical)var6.get(0);
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List selectallCimMedicalDetail(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "CimMedical");
         var3 = true;
      }

      String var4 = "";
      if (var1.equals("*")) {
         var4 = "from CimMedical order by cimLibelleFR";
      } else if (var1.contains("*") && var1.length() >= 2) {
         String var5 = var1.substring(1);
         var4 = "from CimMedical where (cimLibelleFR LIKE '%" + var5 + "%' or cimCode LIKE '" + var5 + "%' or cimLibelleUK LIKE '" + var5 + "%') order by cimLibelleFR";
      } else {
         var4 = "from CimMedical where (cimLibelleFR LIKE '" + var1 + "%' or cimCode LIKE '" + var1 + "%' or cimLibelleUK LIKE '" + var1 + "%') order by cimLibelleFR";
      }

      Query var7 = var2.createQuery(var4);
      List var6 = var7.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List selectallCimMedicalSuite(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "CimMedical");
         var4 = true;
      }

      String var5 = "";
      String var6;
      if (var1 != null && !var1.isEmpty()) {
         if (var2.equals("*")) {
            var5 = "from CimMedical where cimCodeCmd = '" + var1 + "' order by cimLibelleFR";
         } else if (var2.contains("*") && var2.length() >= 2) {
            var6 = var2.substring(1);
            var5 = "from CimMedical where cimCodeCmd = '" + var1 + "' and (cimLibelleFR LIKE '%" + var6 + "%' or cimCode LIKE '" + var6 + "%' or cimLibelleUK LIKE '" + var6 + "%') order by cimLibelleFR";
         } else if (var2 != null && !var2.isEmpty()) {
            var5 = "from CimMedical where cimCodeCmd = '" + var1 + "' and (cimLibelleFR LIKE '" + var2 + "%' or cimCode LIKE '" + var2 + "%' or cimLibelleUK LIKE '" + var2 + "%') order by cimLibelleFR";
         } else {
            var5 = "from CimMedical where cimCodeCmd = '" + var1 + "' order by cimLibelleFR";
         }
      } else if (var2.equals("*")) {
         var5 = "from CimMedical order by cimLibelleFR";
      } else if (var2.contains("*") && var2.length() >= 2) {
         var6 = var2.substring(1);
         var5 = "from CimMedical where cimLibelleFR LIKE '%" + var6 + "%' or cimCode LIKE '" + var6 + "%' or cimLibelleUK LIKE '" + var6 + "%' order by cimLibelleFR";
      } else {
         var5 = "from CimMedical where cimLibelleFR LIKE '" + var2 + "%' or cimCode LIKE '" + var2 + "%' or cimLibelleUK LIKE '" + var2 + "%' order by cimLibelleFR";
      }

      Query var8 = var3.createQuery(var5);
      List var7 = var8.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }
}
