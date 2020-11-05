package com.epegase.systeme.dao;

import com.epegase.systeme.classe.CmaMedical;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class CmaMedicalDao implements Serializable {
   private CmaMedical cmamedical;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public CmaMedicalDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public List selectallCmaMedical(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "CmaMedical");
         var2 = true;
      }

      List var3 = var1.createQuery("from CmaMedical").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }
}
