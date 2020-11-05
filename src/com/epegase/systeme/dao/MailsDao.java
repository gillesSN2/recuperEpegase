package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Mails;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MailsDao implements Serializable {
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public MailsDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public Mails insertMail(Mails var1) throws HibernateException, NamingException {
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

   public Mails insertMail(Mails var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public String insertMail(List var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Mail");

      for(int var3 = 0; var3 < var1.size(); ++var3) {
         Transaction var4 = null;
         new Mails();
         Mails var5 = (Mails)var1.get(var3);
         var4 = var2.beginTransaction();
         var2.save(var5);
         var4.commit();
      }

      this.utilInitHibernate.closeSession();
      return "";
   }

   public Mails modifMail(Mails var1) throws HibernateException, NamingException {
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

   public Mails modifMail(Mails var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void deleteMail(Mails var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Mail");
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

   public void deleteMail(Mails var1, Session var2) {
      var2.delete(var1);
   }

   public long selectLastNum(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Mail");
         var2 = true;
      }

      Query var3 = var1.createQuery("from Mails order by maiId desc").setMaxResults(1);
      long var4 = 1L;
      if (var3.list() != null) {
         List var6 = var3.list();
         if (var6.size() > 0) {
            Mails var7 = (Mails)var6.get(0);
            var4 = 1L + var7.getMaiId();
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List tousMails() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Mail");
      List var2 = var1.createQuery("from Mails where mai_type=0").list();
      this.utilInitHibernate.closeSession();
      return var2;
   }

   public List mailsNonTraiteEnCompta() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Mail");
      List var2 = var1.createQuery("from Mails where maiType=1 and maiDateTransfert is null").list();
      this.utilInitHibernate.closeSession();
      return var2;
   }

   public List mailsDejaTraiteEnCompta() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Mail");
      List var2 = var1.createQuery("from Mails where maiType=1 and maiDateTransfert is not null").list();
      this.utilInitHibernate.closeSession();
      return var2;
   }

   public List selectLestiersMesMails(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Mail");
         var3 = true;
      }

      List var4 = var2.createQuery(var1).list();
      new ArrayList();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List tousMailsTiers(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Mail");
         var4 = true;
      }

      List var5 = var3.createQuery("from Mails where mai_type=0 and maiTiersId=" + var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List MailsLus() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Mail");
      List var2 = var1.createQuery("from Mails where mai_type=0").list();
      this.utilInitHibernate.closeSession();
      return var2;
   }

   public List MailsLusTiers(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Mail");
      List var4 = var3.createQuery("from Mails where mai_type=0 and maiTiersId=" + var1).list();
      this.utilInitHibernate.closeSession();
      return var4;
   }

   public List MailsNlus() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Mail");
      List var2 = var1.createQuery("from Mails where mai_type=0").list();
      this.utilInitHibernate.closeSession();
      return var2;
   }

   public List MailsNlusTiers(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Mail");
      List var4 = var3.createQuery("from Mails where mai_type=0 and maiTiersId=" + var1).list();
      this.utilInitHibernate.closeSession();
      return var4;
   }

   public Mails rechercheMails(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Mail");
         var3 = true;
      }

      List var4 = var2.createQuery("from Mails where mai_num='" + var1 + "'").setMaxResults(1).list();
      new ArrayList();
      new Mails();
      Mails var6;
      if (var4.size() != 0) {
         var6 = (Mails)var4.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public Mails rechercheMails(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Mail");
         var4 = true;
      }

      List var5 = var3.createQuery("from Mails where mai_id=" + var1).setMaxResults(1).list();
      new ArrayList();
      new Mails();
      Mails var7;
      if (var5.size() != 0) {
         var7 = (Mails)var5.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List MailsExtractionActivites(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Mail");
         var2 = true;
      }

      List var3 = var1.createQuery("from Mails where (mai_sens=3 or mai_sens=4) group by mai_activite").list();
      List var4 = var3;
      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            if (((Mails)var4.get(var6)).getMaiActivite() != null && !((Mails)var4.get(var6)).getMaiActivite().isEmpty()) {
               var5.add(new SelectItem(((Mails)var4.get(var6)).getMaiActivite()));
            }
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List MailsExtractionServices(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Mail");
         var2 = true;
      }

      List var3 = var1.createQuery("from Mails where (mai_sens=3 or mai_sens=4) group by mai_service").list();
      List var4 = var3;
      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            if (((Mails)var4.get(var6)).getMaiService() != null && !((Mails)var4.get(var6)).getMaiService().isEmpty()) {
               var5.add(new SelectItem(((Mails)var4.get(var6)).getMaiService()));
            }
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
