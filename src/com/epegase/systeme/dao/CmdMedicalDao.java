package com.epegase.systeme.dao;

import com.epegase.systeme.classe.CmdMedical;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class CmdMedicalDao implements Serializable {
   private CmdMedical cmdMedical;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public CmdMedicalDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public List selectallCmdMedical(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "CmdMedical");
         var2 = true;
      }

      List var3 = var1.createQuery("from CmdMedical").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List selectallCmdMedicalDetail(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "CmdMedical");
         var3 = true;
      }

      List var4 = var2.createQuery("from CmdMedical where cmdFamCode=:param").setParameter("param", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }
}
