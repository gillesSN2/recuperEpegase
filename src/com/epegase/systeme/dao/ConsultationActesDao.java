package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ConsultationActes;
import com.epegase.systeme.classe.ConsultationEnteteGene;
import com.epegase.systeme.classe.Patients;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ConsultationActesDao implements Serializable {
   private ConsultationActes consultationActes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ConsultationActesDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public ConsultationActes insert(ConsultationActes var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
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

   public ConsultationActes insert(ConsultationActes var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public ConsultationActes modif(ConsultationActes var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
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

   public ConsultationActes modif(ConsultationActes var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(ConsultationActes var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
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

   public void delete(ConsultationActes var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public void deleteAllLigne(ConsultationEnteteGene var1, Session var2) {
      var2.createQuery("delete from ConsultationActes where ConsultationEnteteGene=:id").setParameter("id", var1).executeUpdate();
   }

   public List selectConsActesByConsEnt(ConsultationEnteteGene var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("From ConsultationActes where ConsultationEnteteGene=:param").setParameter("param", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List selectConsActesByConsEnt(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("From ConsultationActes where ConsultationEnteteGene.csgId=:param").setLong("param", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public ConsultationActes selectConsActes(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("From ConsultationActes where cslactId=:param").setLong("param", var1).setMaxResults(1).list();
      this.consultationActes = new ConsultationActes();
      if (var5.size() != 0) {
         this.consultationActes = (ConsultationActes)var5.get(0);
      } else {
         this.consultationActes = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.consultationActes;
   }

   public List chargerLesMvtsDents(Patients var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
         var3 = true;
      }

      List var4 = null;
      var4 = var2.createQuery("from ConsultationActes where ConsultationEnteteGene.Patients.patId=" + var1.getPatId() + " and cslactDent is not null and cslactDent<>''").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesMvtsDate(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
         var4 = true;
      }

      List var5 = null;
      var5 = var3.createQuery("from ConsultationActes where ConsultationEnteteGene.csgDate between '" + var1 + "' and '" + var2 + "'").list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesMvtsInfirmerieDate(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from ConsultationActes where ConsultationEnteteGene.csgDate between '" + var2 + "' and '" + var3 + "' and ConsultationEnteteGene.csgService='" + var1 + "'").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesLignesActes(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from ConsultationActes where ConsultationEnteteGene.csgNum in (" + var1 + ") order by cslactLibelle").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerConsultationByRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
         var3 = true;
      }

      List var4 = null;
      var4 = var2.createQuery("from ConsultationActes where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public ConsultationActes selectByGrace(long var1, long var3, String var5, int var6, Session var7) throws HibernateException, NamingException {
      boolean var8 = false;
      if (var7 == null) {
         var7 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
         var8 = true;
      }

      Query var9 = var7.createQuery("from ConsultationActes where ConsultationEnteteGene.csgIdPatient=:idPat and ConsultationEnteteGene.csgIdMedecin=:idMed and (ConsultationEnteteGene.csgEtat<>2 and ConsultationEnteteGene.csgEtat<>3) and cslactProduit=:prd order by ConsultationEnteteGene.csgDate desc").setLong("idPat", var1).setLong("idMed", var3).setString("prd", var5).setMaxResults(1);
      List var10 = var9.list();
      new ConsultationActes();
      ConsultationActes var11;
      if (var10.size() != 0) {
         var11 = (ConsultationActes)var10.get(0);
         long var12 = (new Date()).getTime() - var11.getConsultationEnteteGene().getCsgDate().getTime();
         float var14 = (float)(var12 / 86400000L);
         if (var14 > (float)var6) {
            var11 = null;
         }
      } else {
         var11 = null;
      }

      if (var8) {
         this.utilInitHibernate.closeSession();
      }

      return var11;
   }
}
