package com.epegase.systeme.dao;

import com.epegase.systeme.classe.PegIpPays;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class PegIpPaysDao implements Serializable {
   private UtilInitHibernate utilInitHibernate;

   public PegIpPaysDao(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
   }

   public PegIpPays chercheIp(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getSystemeIp();
      Query var4 = var3.createQuery("from PegIpPays where " + var1 + " between ipDebut and ipFin").setMaxResults(1);
      List var5 = var4.list();
      new PegIpPays();
      PegIpPays var6;
      if (var5.size() > 0) {
         var6 = (PegIpPays)var5.get(0);
      } else {
         var6 = null;
      }

      this.utilInitHibernate.closeSession();
      return var6;
   }
}
