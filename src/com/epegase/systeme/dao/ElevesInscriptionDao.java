package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Eleves;
import com.epegase.systeme.classe.ElevesInscription;
import com.epegase.systeme.classe.FilieresEducation;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ElevesInscriptionDao implements Serializable {
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ElevesInscriptionDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public ElevesInscription insert(ElevesInscription var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
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

   public ElevesInscription insert(ElevesInscription var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public ElevesInscription modif(ElevesInscription var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
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

   public ElevesInscription modif(ElevesInscription var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(ElevesInscription var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
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

   public void delete(ElevesInscription var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public ElevesInscription getElevesInscriptionMedById(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
      ElevesInscription var4 = (ElevesInscription)var3.get(ElevesInscription.class, var1);
      this.utilInitHibernate.closeSession();
      return var4;
   }

   public List getListElevesInscriptionMed() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
      List var2 = var1.createQuery("From ElevesInscription").list();
      this.utilInitHibernate.closeSession();
      return var2;
   }

   public List chargerLesElevesInscription(Eleves var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
         var3 = true;
      }

      List var4 = var2.createQuery("From ElevesInscription where eleves=:param").setParameter("param", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesElevesInscription(FilieresEducation var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
         var4 = true;
      }

      List var5 = var3.createQuery("From ElevesInscription where filieresEducation=:param and eleinsAnnee=:an").setParameter("param", var1).setString("an", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public ElevesInscription chargerLesElevesLastInscription(Eleves var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
         var3 = true;
      }

      new ElevesInscription();
      List var5 = var2.createQuery("From ElevesInscription where eleves.eleId=:param order by eleinsAnnee desc").setLong("param", var1.getEleId()).list();
      ElevesInscription var4;
      if (var5.size() != 0) {
         var4 = (ElevesInscription)var5.get(0);
      } else {
         var4 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public ElevesInscription chargerLesElevesById(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
         var4 = true;
      }

      new ElevesInscription();
      List var6 = var3.createQuery("From ElevesInscription where eleinsId=:param").setLong("param", var1).list();
      ElevesInscription var5;
      if (var6.size() != 0) {
         var5 = (ElevesInscription)var6.get(0);
      } else {
         var5 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
