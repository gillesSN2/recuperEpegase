package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Mails;
import com.epegase.systeme.classe.MailsLu;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MailsLusDao implements Serializable {
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public MailsLusDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public MailsLu insertMail(MailsLu var1) throws HibernateException, NamingException {
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

   public MailsLu insertMail(MailsLu var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public MailsLu modifMail(MailsLu var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Mail");
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

   public String deleteMailLus(long var1, long var3) throws HibernateException, NamingException {
      Session var5 = this.utilInitHibernate.getOpenSession(this.mabase, "Mail");
      Transaction var6 = var5.beginTransaction();
      var6.begin();
      Query var7 = var5.createQuery("delete from MailsLu where mails=:ml and users=:usr").setLong("ml", var1).setLong("usr", var3);
      var7.executeUpdate();
      var6.commit();
      this.utilInitHibernate.closeSession();
      return null;
   }

   public void deleteMailLus(long var1, long var3, Session var5) throws HibernateException, NamingException {
      Query var6 = var5.createQuery("delete from MailsLu where mails=:ml and users=:usr").setLong("ml", var1).setLong("usr", var3);
      var6.executeUpdate();
   }

   public void deleteMailLus(List var1, Session var2) {
      if (var1.size() != 0) {
         for(int var3 = 0; var3 < var1.size(); ++var3) {
            new MailsLu();
            MailsLu var4 = (MailsLu)var1.get(var3);
            var2.delete(var4);
         }
      }

   }

   public MailsLu MailsLusExiste(long var1, long var3, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "Mail");
         var6 = true;
      }

      List var7 = var5.createQuery("from MailsLu where mails=:ml and users=:usr").setLong("ml", var1).setLong("usr", var3).list();
      MailsLu var9 = null;
      if (var7.size() > 0) {
         var9 = (MailsLu)var7.get(0);
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public List MailsLus(Mails var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Mail");
         var3 = true;
      }

      List var4 = var2.createQuery("from MailsLu where mails=:ml").setParameter("ml", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }
}
