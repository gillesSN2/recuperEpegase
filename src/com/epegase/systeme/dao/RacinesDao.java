package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Racines;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RacinesDao implements Serializable {
   private String maBase;
   private UtilInitHibernate utilInitHibernate;
   private Structure structureLog;

   public RacinesDao(String var1, Structure var2, UtilInitHibernate var3) {
      this.maBase = var1;
      this.structureLog = var2;
      this.utilInitHibernate = var3;
   }

   public void saveRacineComptable(String var1, List var2) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Racines");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();

         for(int var5 = 0; var5 < var2.size(); ++var5) {
            Racines var6 = (Racines)var2.get(var5);
            var6.setRacFiscalite(var1);
            var3.save(var6);
         }

         var4.commit();
      } catch (HibernateException var10) {
         if (var4 != null) {
            var4.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }
   }

   public void removeRacine(String var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Racines");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         int var4 = var2.createQuery("delete from Racines where (racFiscalite='" + var1 + "' or (racFiscalite is null or racFiscalite = ''))").executeUpdate();
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

   public List chargerMesRacines(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Racines");
         var2 = true;
      }

      Query var3 = var1.createQuery("from Racines");
      List var4 = var3.list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerMesRacines(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Racines");
         var3 = true;
      }

      if (var1 == null || var1.isEmpty()) {
         var1 = this.structureLog.getStrzonefiscale();
      }

      Query var4 = var2.createQuery("from Racines where (racFiscalite='" + var1 + "' or (racFiscalite is null or racFiscalite =''))");
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerMesRacinesUtiles(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Racines");
         var3 = true;
      }

      if (var1 == null || var1.isEmpty()) {
         var1 = this.structureLog.getStrzonefiscale();
      }

      Query var4 = var2.createQuery("from Racines where racUtil=1 and (racFiscalite='" + var1 + "' or (racFiscalite is null or racFiscalite =''))");
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercherListeRacine(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Racines");
         var4 = true;
      }

      if (var1 == null || var1.isEmpty()) {
         var1 = this.structureLog.getStrzonefiscale();
      }

      Query var5 = var3.createQuery("from Racines where racCodenature= '" + var2 + "' and (racFiscalite='" + var1 + "' or (racFiscalite is null or racFiscalite ='')) order by racCode asc");
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public Racines rechercherCodeRacine(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Racines");
         var4 = true;
      }

      if (var1 == null || var1.isEmpty()) {
         var1 = this.structureLog.getStrzonefiscale();
      }

      Query var5 = var3.createQuery("from Racines where racCode='" + var2 + "' and (racFiscalite='" + var1 + "' or (racFiscalite is null or racFiscalite =''))").setMaxResults(1);
      List var6 = var5.list();
      new Racines();
      Racines var7;
      if (var6.size() != 0) {
         var7 = (Racines)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }
}
