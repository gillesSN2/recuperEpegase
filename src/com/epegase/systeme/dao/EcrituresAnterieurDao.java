package com.epegase.systeme.dao;

import com.epegase.systeme.classe.EcrituresAnterieur;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EcrituresAnterieurDao implements Serializable {
   private EcrituresAnterieur ecrituresAnterieur;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public EcrituresAnterieurDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public EcrituresAnterieur inser(EcrituresAnterieur var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "EcrituresAnterieur");
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

   public EcrituresAnterieur inser(EcrituresAnterieur var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public EcrituresAnterieur modif(EcrituresAnterieur var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "EcrituresAnterieur");
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

   public EcrituresAnterieur modif(EcrituresAnterieur var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(EcrituresAnterieur var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "EcrituresAnterieur");
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

   public void delete(EcrituresAnterieur var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List chargerAnterieur(String var1, int var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "EcrituresAnterieur");
         var4 = true;
      }

      Query var5 = var3.createQuery("from EcrituresAnterieur where ecrantType=:typ and ecrantCle1='" + var1 + "'").setInteger("typ", var2);
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerAnterieur(long var1, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "EcrituresAnterieur");
         var5 = true;
      }

      Query var6 = var4.createQuery("from EcrituresAnterieur where ecrantType=:typ and exercicesComptable=:exo").setInteger("typ", var3).setLong("exo", var1);
      List var7 = var6.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerLesEcrituresRapp(String var1, Date var2, Date var3, long var4, int var6, Session var7) throws HibernateException, NamingException, ParseException {
      boolean var8 = false;
      if (var7 == null) {
         var7 = this.utilInitHibernate.getOpenSession(this.mabase, "EcrituresAnterieur");
         var8 = true;
      }

      UtilDate var9 = new UtilDate();
      Date var10 = var9.stringToDateSQLLight(var3.getYear() + 1900 - 1 + "-12-01");
      Query var11 = null;
      if (var6 == 0) {
         var11 = var7.createQuery("from EcrituresAnterieur where ecrantType=:typ and ecrantCode=:jr and ((ecrantDteRapprochement is null and exercicesComptable=:exo and ecrantDate<=:dt ) or (ecrantDteRapprochement is not null and ecrantDteRapprochement>=:perRap))").setString("jr", var1).setInteger("typ", var6).setDate("dt", var2).setLong("exo", var4).setDate("perRap", var3);
      } else {
         var11 = var7.createQuery("from EcrituresAnterieur where ecrantType=:typ and ecrantCode=:jr and ecrantDate<=:dt and ((ecrantDteRapprochement is null and exercicesComptable=:exo) or (ecrantDteRapprochement is not null and ecrantDteRapprochement>=:perRap and ecrantDate>=:ddeb))").setString("jr", var1).setInteger("typ", var6).setDate("dt", var2).setLong("exo", var4).setDate("ddeb", var10).setDate("perRap", var3);
      }

      List var12 = var11.list();
      if (var8) {
         this.utilInitHibernate.closeSession();
      }

      return var12;
   }

   public List chargerLesEcrituresRapp(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "EcrituresAnterieur");
         var4 = true;
      }

      Query var5 = var3.createQuery("from EcrituresAnterieur e where exercicesComptable=:exo").setLong("exo", var1);
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesEcrituresRapprochees(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "EcrituresAnterieur");
         var4 = true;
      }

      Query var5 = var3.createQuery("from EcrituresAnterieur where (ecrantRapprochement is not null or ecrantRapprochement<>'') and exercicesComptable=:exo").setLong("exo", var1);
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public EcrituresAnterieur chercheAnterieur(long var1, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      boolean var5 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "EcrituresAnterieur");
         var5 = true;
      }

      Query var6 = var3.createQuery("from EcrituresAnterieur where ecrant_id=:Id").setLong("Id", var1);
      List var4 = var6.list();
      new EcrituresAnterieur();
      EcrituresAnterieur var7;
      if (var4.size() != 0) {
         var7 = (EcrituresAnterieur)var4.get(0);
      } else {
         var7 = null;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }
}
