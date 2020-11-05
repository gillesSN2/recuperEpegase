package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Android;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class AndroidDao implements Serializable {
   private Android android;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public AndroidDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public void delete(Android var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public void majidTier(Session var1) {
      Query var2 = var1.createQuery("update Android set eveIdTie=0 where eveIdTie is null");
      var2.executeUpdate();
   }

   public List selectAndroid(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Android");
         var2 = true;
      }

      List var3 = var1.createQuery("from Android order by eveIdUser, eveHoraire").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List selectAndroidImmobilisation(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Android");
         var2 = true;
      }

      List var3 = var1.createQuery("from Android where eveCategorie=7 order by eveIdUser, eveHoraire").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }
}
