package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Parapheur;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ParapheurDao implements Serializable {
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ParapheurDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public Parapheur insert(Parapheur var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public Parapheur modif(Parapheur var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(long var1, int var3) throws HibernateException, NamingException {
      Session var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Parapheur");
      Transaction var5 = null;

      try {
         var5 = var4.beginTransaction();
         new Parapheur();
         ParapheurDao var7 = new ParapheurDao(this.mabase, this.utilInitHibernate);
         Parapheur var6 = var7.existenceParapheur(var1, var3, var4);
         if (var6 != null) {
            var4.delete(var6);
         }

         var5.commit();
      } catch (HibernateException var11) {
         if (var5 != null) {
            var5.rollback();
         }

         throw var11;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void delete(long var1, int var3, Session var4) throws HibernateException, NamingException {
      new Parapheur();
      ParapheurDao var6 = new ParapheurDao(this.mabase, this.utilInitHibernate);
      Parapheur var5 = var6.existenceParapheur(var1, var3, var4);
      if (var5 != null) {
         var4.delete(var5);
      }

   }

   public void delete(Parapheur var1, Session var2) {
      var2.delete(var1);
   }

   public List selectList(long var1, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Parapheur");
         var5 = true;
      }

      Query var6 = var4.createQuery("from Parapheur where ((phrUser1Id=:us and phrUser1Etat=:etat) or (phrUser2Id=:us and phrUser2Etat=:etat) or (phrUser3Id=:us and phrUser3Etat=:etat) or (phrUser4Id=:us and phrUser4Etat=:etat) or (phrUser5Id=:us and phrUser5Etat=:etat) or (phrUser6Id=:us and phrUser6Etat=:etat))").setInteger("etat", var3).setLong("us", var1);
      Object var7 = new ArrayList();
      if (var6.list() != null) {
         var7 = var6.list();
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var7;
   }

   public List selectList(long var1, int var3, Date var4, Date var5, Session var6) throws HibernateException, NamingException {
      boolean var7 = false;
      if (var6 == null) {
         var6 = this.utilInitHibernate.getOpenSession(this.mabase, "Parapheur");
         var7 = true;
      }

      Query var8 = var6.createQuery("from Parapheur where ((phrUser1Id=:us and phrUser1Etat=:etat and phrUser1DteRep>=:date1 and phrUser1DteRep<=:date2) or (phrUser2Id=:us and phrUser2Etat=:etat and phrUser2DteRep>=:date1 and phrUser2DteRep<=:date2) or (phrUser3Id=:us and phrUser3Etat=:etat and phrUser3DteRep>=:date1 and phrUser3DteRep<=:date2) or (phrUser4Id=:us and phrUser4Etat=:etat and phrUser4DteRep>=:date1 and phrUser4DteRep<=:date2) or (phrUser5Id=:us and phrUser5Etat=:etat and phrUser5DteRep>=:date1 and phrUser5DteRep<=:date2) or (phrUser6Id=:us and phrUser6Etat=:etat and phrUser6DteRep>=:date1 and phrUser6DteRep<=:date2))").setInteger("etat", var3).setLong("us", var1).setDate("date1", var4).setDate("date2", var5);
      Object var9 = new ArrayList();
      if (var8.list() != null) {
         var9 = var8.list();
      }

      if (var7) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var9;
   }

   public List selectListTransfert(long var1, int var3, Date var4, Date var5, Session var6) throws HibernateException, NamingException {
      boolean var7 = false;
      if (var6 == null) {
         var6 = this.utilInitHibernate.getOpenSession(this.mabase, "Parapheur");
         var7 = true;
      }

      Query var8 = var6.createQuery("from Parapheur where ((phrUser1Id=:us and phrUser1Etat=:etat) or (phrUser2Id=:us and phrUser2Etat=:etat) or (phrUser3Id=:us and phrUser3Etat=:etat) or (phrUser4Id=:us and phrUser4Etat=:etat) or (phrUser5Id=:us and phrUser5Etat=:etat) or (phrUser6Id=:us and phrUser6Etat=:etat) and phrDate>=:date1 and phrDate<=:date2)").setInteger("etat", var3).setLong("us", var1).setDate("date1", var4).setDate("date2", var5);
      Object var9 = new ArrayList();
      if (var8.list() != null) {
         var9 = var8.list();
      }

      if (var7) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var9;
   }

   public Parapheur existenceParapheur(long var1, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Parapheur");
         var5 = true;
      }

      Query var6 = var4.createQuery("from Parapheur where phrDocId=:na and  phrNature=:nat order by phrId desc").setLong("na", var1).setInteger("nat", var3).setMaxResults(1);
      Parapheur var7 = null;
      if (var6.list() != null) {
         List var8 = var6.list();
         if (var8.size() > 0) {
            var7 = (Parapheur)var8.get(0);
         }
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List parapheurDocument(long var1, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "GestionCaisseAchats");
         var5 = true;
      }

      Query var6 = var4.createQuery("from Parapheur where phrDocId =:num and phrNature=:nat").setLong("num", var1).setInteger("nat", var3);
      List var7 = var6.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List lesParapheursIndisponibles(long var1, Session var3) {
      Query var4 = var3.createQuery("from Parapheur where (phrUser1Id=:us OR phrUser2Id=:us OR phrUser3Id=:us OR phrUser4Id=:us OR phrUser5Id=:us OR phrUser6Id=:us)");
      var4.setParameter("us", var1);
      new ArrayList();
      if (var4.list() != null) {
         List var5 = var4.list();
         return var5;
      } else {
         return null;
      }
   }

   public List lesParapheursDisponibles(long var1, Session var3) {
      Query var4 = var3.createQuery("from Parapheur where (phrPropritaire1Id=:us OR phrPropritaire2Id=:us OR phrPropritaire3Id=:us OR phrPropritaire4Id=:us OR phrPropritaire5Id=:us OR phrPropritaire6Id=:us)");
      var4.setParameter("us", var1);
      new ArrayList();
      if (var4.list() != null) {
         List var5 = var4.list();
         return var5;
      } else {
         return null;
      }
   }
}
