package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EspionDao implements Serializable {
   private Espion espion;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public EspionDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public void mAJEspion(Espion var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
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

   }

   public void mAJEspion(Espion var1, Session var2) {
      var2.save(var1);
   }

   public List rechercheEspion(int var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      new ArrayList();
      Session var6 = this.utilInitHibernate.getOpenSession(this.maBase, "");
      Query var7 = null;
      if (var2 != null && !var2.isEmpty()) {
         var7 = var6.createQuery("from Espion where esptype=:typ and espaction like '%" + var2 + "%' and espdtecreat between '" + var3 + "' and '" + var4 + "'").setInteger("typ", var1);
      } else {
         var7 = var6.createQuery("from Espion where esptype=:typ and espdtecreat between '" + var3 + "' and '" + var4 + "'").setInteger("typ", var1);
      }

      List var5 = var7.list();
      this.utilInitHibernate.closeSession();
      return var5;
   }

   public boolean verifUser(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.maBase, "");
      Query var4 = var3.createQuery("from Espion where users.usrid =:id").setLong("id", var1).setMaxResults(1);
      List var5 = var4.list();
      boolean var6 = false;
      if (var5.size() != 0) {
         var6 = true;
      }

      this.utilInitHibernate.closeSession();
      return var6;
   }
}
