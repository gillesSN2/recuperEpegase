package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Unite;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class UniteDao implements Serializable {
   private Unite produitsUnite;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public UniteDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public Unite insert(Unite var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public Unite modif(Unite var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(Unite var1, Session var2) {
      var2.delete(var1);
   }

   public List selectAll(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Unite");
         var2 = true;
      }

      Query var3 = var1.createQuery("from Unite");
      Object var4 = new ArrayList();
      if (var3.list() != null) {
         var4 = var3.list();
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var4;
   }

   public Unite selectUnite(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Unite");
         var3 = true;
      }

      new ArrayList();
      List var4 = var2.createQuery("from Unite where uniLibelle='" + var1 + "'").setMaxResults(1).list();
      new Unite();
      Unite var5;
      if (var4.size() != 0) {
         var5 = (Unite)var4.get(0);
      } else {
         var5 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesUnitesItems(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Unite");
         var2 = true;
      }

      List var3 = var1.createQuery("from Unite").list();
      List var4 = var3;
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      var5.add(new SelectItem(""));
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            new Unite();
            Unite var7 = (Unite)var4.get(var6);
            String var8 = "";
            var8 = var7.getUniLibelle() + ":(" + var7.getVar_lib_echelle() + ")";
            var5.add(new SelectItem(var8));
         }
      }

      return var5;
   }
}
