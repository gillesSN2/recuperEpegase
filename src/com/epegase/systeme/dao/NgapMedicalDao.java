package com.epegase.systeme.dao;

import com.epegase.systeme.classe.NgapMedical;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class NgapMedicalDao implements Serializable {
   private NgapMedical ngapMedical;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public NgapMedicalDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public List selectallNgapMedical(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "CcamMedical");
         var2 = true;
      }

      List var3 = var1.createQuery("from NgapMedical").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List selectallNgapMedicalDetail(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "CcamMedical");
         var3 = true;
      }

      List var4 = var2.createQuery("from NgapMedical where ngaFamCode=:param").setParameter("param", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }
}
