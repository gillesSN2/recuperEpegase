package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Mails;
import com.epegase.systeme.classe.MailsPj;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MailsPJDao implements Serializable {
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public MailsPJDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public MailsPj insertMailPj(MailsPj var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Mail");
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

   public MailsPj insertMailPj(MailsPj var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public String deleteMailPj(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Mail");
      Transaction var4 = var3.beginTransaction();
      var4.begin();
      Query var5 = var3.createQuery("delete from MailsPj where  maipjId =" + var1);
      var5.executeUpdate();
      var4.commit();
      this.utilInitHibernate.closeSession();
      return null;
   }

   public void deleteMailPj(List var1, Session var2) {
      if (var1.size() != 0) {
         for(int var3 = 0; var3 < var1.size(); ++var3) {
            new MailsPj();
            MailsPj var4 = (MailsPj)var1.get(var3);
            var2.delete(var4);
         }
      }

   }

   public List chargerMailsPJ(Mails var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Mail");
         var3 = true;
      }

      List var4 = var2.createQuery("from MailsPj where mails=:mm").setParameter("mm", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }
}
