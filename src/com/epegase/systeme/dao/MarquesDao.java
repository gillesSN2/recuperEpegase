package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Marques;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class MarquesDao implements Serializable {
   private Marques marques;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public MarquesDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public Marques insert(Marques var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public Marques modif(Marques var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(Marques var1, Session var2) {
      var2.delete(var1);
   }

   public List selectMarques(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Marques");
         var2 = true;
      }

      List var3 = var1.createQuery("from Marques").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerLesMarques(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Marques");
         var2 = true;
      }

      List var3 = var1.createQuery("from Marques where marInactif=0").list();
      List var4 = var3;
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var5.add(new SelectItem(((Marques)var4.get(var6)).getMarLibelleFr(), ((Marques)var4.get(var6)).getMarLibelleFr()));
         }
      }

      return var5;
   }
}
