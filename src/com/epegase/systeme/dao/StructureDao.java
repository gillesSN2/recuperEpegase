package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.StructurePeg;
import com.epegase.systeme.classe.StructurePot;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StructureDao implements Serializable {
   private Structure structure;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public StructureDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public StructureDao(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
   }

   public StructurePot insertPot(StructurePot var1) throws HibernateException, NamingException {
      var1.setStrdtecreat(new Date());
      Session var2 = this.utilInitHibernate.getSystemeEPegase();
      Transaction var3 = var2.beginTransaction();
      var2.save(var1);
      var3.commit();
      this.utilInitHibernate.closeSession();
      return var1;
   }

   public Structure insertCr(Structure var1) throws HibernateException, NamingException {
      var1.setStrdtecreat(new Date());
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Structure");
      Transaction var3 = var2.beginTransaction();
      var2.save(var1);
      var3.commit();
      this.utilInitHibernate.closeSession();
      return var1;
   }

   public Structure insert(Structure var1) throws HibernateException, NamingException {
      var1.setStrdtecreat(new Date());
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Structure");
      Transaction var3 = null;
      List var4 = null;

      try {
         var3 = var2.beginTransaction();
         var2.save(var1);
         var4 = var2.createQuery("from Structure order by str_id DESC LIMIT 1").list();
         var3.commit();
      } catch (HibernateException var9) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var9;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var4.size() > 0 ? (Structure)var4.get(0) : null;
   }

   public Structure modStructure(Structure var1) throws HibernateException, NamingException {
      var1.setStrdtemodif(new Date());
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Structure");
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

   public Structure modStructure(Structure var1, Session var2) {
      var1.setStrdtemodif(new Date());
      var2.update(var1);
      return var1;
   }

   public List selectStructurePeg(String var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getSysteme();
      List var3 = var2.createQuery("from StructurePeg " + var1).list();
      this.utilInitHibernate.closeSession();
      return var3;
   }

   public List selectStructureCabinet(String var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getSysteme();
      List var3 = var2.createQuery("from StructurePeg " + var1).list();
      this.utilInitHibernate.closeSession();
      return var3;
   }

   public List selectStructure() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Structure");
      List var2 = var1.createQuery("from Structure").list();
      this.utilInitHibernate.closeSession();
      return var2;
   }

   public Structure logStructure() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Structure");
      List var2 = var1.createQuery("from Structure ").list();
      this.utilInitHibernate.closeSession();
      return (Structure)var2.get(0);
   }

   public Structure logStructureId(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Structure");
         var4 = true;
      }

      List var5 = var3.createQuery("from Structure where str_id =:id").setLong("id", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5.size() > 0 ? (Structure)var5.get(0) : null;
   }

   public Structure logStructure(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Structure");
         var2 = true;
      }

      List var3 = var1.createQuery("from Structure").setMaxResults(1).list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3.size() > 0 ? (Structure)var3.get(0) : null;
   }

   public StructurePeg insertCrPeg(StructurePeg var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getSysteme();
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

   public StructurePeg insertCrPeg(StructurePeg var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public StructurePeg updatCrPeg(StructurePeg var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getSysteme();
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

   public StructurePeg logStructurePeg(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getSysteme();
      Query var4 = var3.createQuery("from StructurePeg where strId =:id").setLong("id", var1);
      List var5 = var4.list();
      this.utilInitHibernate.closeSession();
      return var5.size() > 0 ? (StructurePeg)var5.get(0) : null;
   }

   public StructurePeg logStructurePeg(long var1, Session var3) throws HibernateException, NamingException {
      Query var4 = var3.createQuery("from StructurePeg u where u.strId =:id");
      var4.setParameter("id", var1);
      List var5 = var4.list();
      return var5.size() > 0 ? (StructurePeg)var5.get(0) : null;
   }

   public void delStructurepegByIdStr(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getSysteme();
      Transaction var4 = var3.beginTransaction();
      var4.begin();
      Query var5 = var3.createQuery("delete from  StructurePeg u where u.strId =:id");
      var5.setParameter("id", var1);
      var5.executeUpdate();
      var4.commit();
      this.utilInitHibernate.closeSession();
   }

   public String dropDataBase(String var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getSysteme();
      Transaction var3 = null;
      var3 = var2.beginTransaction();
      SQLQuery var4 = var2.createSQLQuery("DROP DATABASE IF EXISTS  " + var1);
      var4.executeUpdate();
      var3.commit();
      this.utilInitHibernate.closeSession();
      return "";
   }
}
