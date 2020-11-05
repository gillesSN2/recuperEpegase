package com.epegase.systeme.dao;

import com.epegase.systeme.classe.PegMedicemment;
import com.epegase.systeme.classe.PegMedicemmentDci;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class PegMedicammentDao implements Serializable {
   private PegMedicemment pegMedicamment;
   private PegMedicemmentDci PegMedicammentDci;
   private UtilInitHibernate utilInitHibernate;

   public PegMedicammentDao(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
   }

   public List rechercheMedicamment(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getSysteme();
         var2 = true;
      }

      Query var3 = var1.createQuery("from PegMedicemment order by med_cip");
      Object var4 = new ArrayList();
      if (var3.list() != null) {
         var4 = var3.list();
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var4;
   }

   public List rechercheDci(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getSysteme();
         var2 = true;
      }

      Query var3 = var1.createQuery("from PegMedicemmentDci order by meddci_dci");
      Object var4 = new ArrayList();
      if (var3.list() != null) {
         var4 = var3.list();
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var4;
   }
}
