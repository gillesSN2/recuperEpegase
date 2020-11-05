package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ComplementInformations;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ComplementInformationsDao implements Serializable {
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public ComplementInformationsDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public ComplementInformations inser(ComplementInformations var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public ComplementInformations modif(ComplementInformations var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(ComplementInformations var1, Session var2) {
      var2.delete(var1);
   }

   public void nettoyage(int var1, long var2) throws HibernateException, NamingException {
      Session var4 = this.utilInitHibernate.getOpenSession(this.maBase, "EtatFinancier");
      Transaction var5 = null;

      try {
         var5 = var4.beginTransaction();
         new ArrayList();
         Query var7 = null;
         if (var1 == 0) {
            var7 = var4.createQuery("from ComplementInformations where cplmenType=0  and exercicesComptable.execpt_id=:exo").setLong("exo", var2);
         } else {
            var7 = var4.createQuery("from ComplementInformations where cplmenType>=1  and exercicesComptable.execpt_id=:exo").setLong("exo", var2);
         }

         List var6 = var7.list();
         if (var6.size() != 0) {
            for(int var8 = 0; var8 < var6.size(); ++var8) {
               new ComplementInformations();
               ComplementInformations var9 = (ComplementInformations)var6.get(var8);
               var4.delete(var9);
            }

            var5.commit();
         }
      } catch (HibernateException var13) {
         if (var5 != null) {
            var5.rollback();
         }

         throw var13;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public List chargerMesComplements(int var1, long var2, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "EtatFinancier");
         var5 = true;
      }

      Query var6 = null;
      if (var1 == 99) {
         var6 = var4.createQuery("from ComplementInformations where exercicesComptable.execpt_id=:exo").setLong("exo", var2);
      } else {
         var6 = var4.createQuery("from ComplementInformations where cplmenType=:typ  and exercicesComptable.execpt_id=:exo").setInteger("typ", var1).setLong("exo", var2);
      }

      List var7 = var6.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }
}
