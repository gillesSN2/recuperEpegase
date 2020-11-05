package com.epegase.systeme.dao;

import com.epegase.systeme.classe.CcamMedical;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class CcamMedicalDao implements Serializable {
   private CcamMedical ccamMedical;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public CcamMedicalDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public List selectallCcamMedical(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "CcamMedical");
         var2 = true;
      }

      List var3 = var1.createQuery("from CcamMedical").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List selectallCcamMedicalSNiv(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "CcamMedical");
         var3 = true;
      }

      List var4 = var2.createQuery("from CcamMedical where ccamFamCode=:param").setParameter("param", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List selectallCcamMedicalSSNiv(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "CcamMedical");
         var4 = true;
      }

      List var5 = var3.createQuery("from CcamMedical where ccamSfamCode=:param AND ccamFamCode=:param1").setParameter("param", var2).setParameter("param1", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectallCcamMedicalSSSNiv(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "CcamMedical");
         var4 = true;
      }

      List var5 = var3.createQuery("from CcamMedical where ccamSsfamCode=:param AND ccamSfamCode=:param1").setParameter("param", var2).setParameter("param1", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectallCcamMedicalDetail(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "CcamMedical");
         var4 = true;
      }

      List var5 = var3.createQuery("from CcamMedical where ccamSssfamCode=:param AND ccamSsfamCode=:param1").setParameter("param", var2).setParameter("param1", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectallCcamMedicalActe(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "CcamMedical");
         var3 = true;
      }

      List var4 = var2.createQuery("from CcamMedical where (ccamDetCode like '%" + var1 + "' or ccamDetLibFr like '%" + var1 + "%')").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }
}
