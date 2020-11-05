package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Contacts;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ContactDao implements Serializable {
   private Contacts contacts;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public ContactDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public Contacts insert(Contacts var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Contacts");
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

   public Contacts insert(Contacts var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public Contacts modif(Contacts var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Contacts");
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

   public Contacts modif(Contacts var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public String deletContact(Contacts var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Contacts");
      Transaction var3 = var2.beginTransaction();
      var3.begin();
      Query var4 = var2.createQuery("delete from Contacts where conid =:Id").setParameter("Id", var1.getConid());
      var4.executeUpdate();
      var3.commit();
      this.utilInitHibernate.closeSession();
      return null;
   }

   public void delete(Contacts var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Contacts");
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

   public void delete(Contacts var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List selectContacts() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Contacts");
      List var2 = var1.createQuery("from Contacts order by conpatronyme").list();
      this.utilInitHibernate.closeSession();
      return var2;
   }

   public List selectContactsEmail(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Contacts");
         var2 = true;
      }

      List var3 = var1.createQuery("from Contacts where (conmail1 like '%@%' or conmail2 like '%@%' or conmail3 like '%@%' or conmail4 like '%@%' or conmail5 like '%@%') order by conpatronyme").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public Contacts selectContactsEmail(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Contacts");
         var3 = true;
      }

      List var4 = var2.createQuery("from Contacts where conmail1 ='" + var1 + "'" + " or conmail2 =" + "'" + var1 + "'" + "  or conmail3 =" + "'" + var1 + "'" + "  or conmail4 =" + "'" + var1 + "' order by conpatronyme").list();
      Contacts var5 = new Contacts();
      if (var4.size() > 0) {
         var5 = (Contacts)var4.get(0);
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public Contacts selectContactsEspaceClient(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Contacts");
         var4 = true;
      }

      List var5 = var3.createQuery("from Contacts where (conmail1 ='" + var1 + "'" + " or conmail2 =" + "'" + var1 + "'" + "  or conmail3 =" + "'" + var1 + "'" + "  or conmail4 =" + "'" + var1 + "') and conPwEspaceClient ='" + var2 + "' order by conpatronyme").list();
      new Contacts();
      Contacts var6;
      if (var5.size() > 0) {
         var6 = (Contacts)var5.get(0);
      } else {
         var6 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List selectContactsAnniv(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var2 = true;
      }

      Date var3 = new Date();
      DateFormat var4 = DateFormat.getDateInstance(3);
      String var5 = var4.format(var3).substring(0, 5);
      List var6 = var1.createQuery("from Contacts where conanniversaire=:dt order by conpatronyme").setParameter("dt", var5).list();
      new ArrayList();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public Contacts logContacts() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Contacts");
      List var2 = var1.createQuery("from Contacts order by conpatronyme").list();
      this.utilInitHibernate.closeSession();
      return (Contacts)var2.get(0);
   }

   public List chargerLesContactsEmail(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Contacts");
         var4 = true;
      }

      List var5 = var3.createQuery("from Contacts where tiers.tieid=" + var1 + " and (conmail1 like '%@%' or conmail2 like '%@%' or conmail3 like '%@%' or conmail4 like '%@%' or conmail5 like '%@%') order by conpatronyme").list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesContacts(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Contacts");
         var4 = true;
      }

      List var5 = var3.createQuery("from Contacts where tiers.tieid=" + var1 + " order by conpatronyme").list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesContacts(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Contacts");
         var2 = true;
      }

      List var3 = var1.createQuery("from Contacts order by conpatronyme").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerLesContactsItems(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Contacts");
         var4 = true;
      }

      List var5 = var3.createQuery("from Contacts where tiers.tieid=" + var1 + " order by conpatronyme,conservice").list();
      List var6 = var5;
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var7 = new ArrayList();
      if (var5.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            Contacts var9 = (Contacts)var6.get(var8);
            if (var9.getConpatronyme() != null && !var9.getConpatronyme().isEmpty()) {
               if (var9.getConprenom() != null && !var9.getConprenom().isEmpty()) {
                  var7.add(new SelectItem(var9.getConid(), var9.getConnom() + " " + var9.getConprenom()));
               } else {
                  var7.add(new SelectItem(var9.getConid(), var9.getConnom()));
               }
            } else if (var9.getConservice() != null && !var9.getConservice().isEmpty()) {
               var7.add(new SelectItem(var9.getConid(), var9.getConservice()));
            }
         }

         if (var7.size() == 0) {
            var7.add(new SelectItem(0, ""));
         }
      } else {
         var7.add(new SelectItem(0, ""));
      }

      return var7;
   }

   public Contacts chargerLesContactsPatronyme(long var1, String var3, Session var4) {
      Query var5 = var4.createQuery("from Contacts where tiers.tieid=" + var1 + " and conpatronyme='" + var3 + "'").setMaxResults(1);
      List var6 = var5.list();
      Contacts var7 = null;
      if (var6.size() > 0) {
         var7 = (Contacts)var6.get(0);
      }

      return var7;
   }

   public Contacts chargerLesContactsById(long var1, Session var3) {
      Query var4 = var3.createQuery("from Contacts where conid=:id").setLong("id", var1).setMaxResults(1);
      List var5 = var4.list();
      Contacts var6 = null;
      if (var5.size() > 0) {
         var6 = (Contacts)var5.get(0);
      }

      return var6;
   }

   public List chargerLesContactsLettre(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Contacts");
         var3 = true;
      }

      Query var4 = null;
      if (var1 != null && !var1.isEmpty() && var1.startsWith("*")) {
         String var5 = var1.substring(1);
         var4 = var2.createQuery("from Contacts where  conpatronyme like'%" + var5 + "%' or conmail1 like '%" + var5 + "%' or conmail2 like '%" + var5 + "%' or conmail3 like '%" + var5 + "%' or conmail4 like '%" + var5 + "%'or conmail5 like '%" + var5 + "%' order by conpatronyme");
      } else {
         var4 = var2.createQuery("from Contacts where  conpatronyme like'" + var1 + "%' order by conpatronyme");
      }

      List var6 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public Contacts chargerLesContactsbyJournal(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Contacts");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Contacts where conJournal like '" + var1 + "%'").setMaxResults(1);
      List var5 = var4.list();
      Contacts var6 = null;
      if (var5.size() > 0) {
         var6 = (Contacts)var5.get(0);
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesContactsBq(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var2 = true;
      }

      List var3 = var1.createQuery("from Contacts where tiers.tietype='0' AND tiers.tiecategorie='Banque' order by conpatronyme").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerLesContactsBqItems(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var2 = true;
      }

      List var3 = var1.createQuery("from Contacts where tiers.tietype='0' AND tiers.tiecategorie='Banque' order by conpatronyme").list();
      List var4 = var3;
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      var5.add(new SelectItem(""));
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            Contacts var7 = (Contacts)var4.get(var6);
            if (var7.getTiers().getTieraisonsocialenom() != null && !var7.getTiers().getTieraisonsocialenom().isEmpty() && var7.getConcomptebanque() != null && !var7.getConcomptebanque().isEmpty()) {
               var5.add(new SelectItem(var7.getTiers().getTieraisonsocialenom() + "=" + var7.getConnumbanque() + ":" + var7.getConguichetbanque() + ":" + var7.getConcomptebanque() + ":" + var7.getConclebanque()));
            }
         }
      }

      return var5;
   }

   public Contacts chargerContactsBq(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var3 = true;
      }

      List var4 = var2.createQuery("from Contacts where tiers.tietype='0' AND tiers.tiecategorie='Banque' and tiers.tiesigle=:bnq and concomptebanque is not null").setString("bnq", var1).setMaxResults(1).list();
      if (var4.size() != 0) {
         this.contacts = (Contacts)var4.get(0);
      } else {
         this.contacts = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return this.contacts;
   }

   public List chargerLesFactors() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Contacts");
      List var2 = var1.createQuery("from Contacts where tiers.tietype='0' AND tiers.tiecategorie='Factor' order by conpatronyme").list();
      this.utilInitHibernate.closeSession();
      return var2;
   }

   public List listContactByTiers(Tiers var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      Object var4 = new ArrayList();
      if (var1 != null) {
         if (var2 == null) {
            var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Contacts");
            var3 = true;
         }

         Query var5 = var2.createQuery("from Contacts where tiers=:tiers order by conpatronyme");
         var5.setParameter("tiers", var1);
         var4 = var5.list();
         if (var3) {
            this.utilInitHibernate.closeSession();
         }
      }

      return (List)var4;
   }

   public List listContactByTiersMail(Tiers var1) throws HibernateException, NamingException {
      Object var2 = new ArrayList();
      if (var1 != null) {
         Session var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Contacts");
         Query var4 = var3.createQuery("from Contacts where tiers=:tiers AND (conmail1 LIKE '%@%' OR conmail2 LIKE '%@%' OR conmail3 LIKE '%@%' OR conmail4 LIKE '%@%' OR conmail5 LIKE '%@%') order by conpatronyme");
         var4.setParameter("tiers", var1);
         var2 = var4.list();
         this.utilInitHibernate.closeSession();
      }

      return (List)var2;
   }

   public List listContactByTiersMail(Tiers var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Contacts");
         var3 = true;
      }

      Object var4 = new ArrayList();
      if (var1 != null) {
         Query var5 = var2.createQuery("from Contacts where tiers=:tiers AND (conmail1 LIKE '%@%' OR conmail2 LIKE '%@%' OR conmail3 LIKE '%@%' OR conmail4 LIKE '%@%' OR conmail5 LIKE '%@%') order by conpatronyme");
         var5.setParameter("tiers", var1);
         var4 = var5.list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var4;
   }

   public Contacts listContactByTiersAndMail(Tiers var1, String var2) throws HibernateException, NamingException {
      Contacts var3 = new Contacts();
      new ArrayList();
      if (var1 != null) {
         Session var5 = this.utilInitHibernate.getOpenSession(this.maBase, "Contacts");
         Query var6 = var5.createQuery("from Contacts where tiers=:tiers AND (conmail1 =:mail OR conmail2=:mail OR conmail3 =:mail OR conmail4 =:mail OR conmail5 =:mail) order by conpatronyme");
         var6.setParameter("tiers", var1);
         var6.setParameter("mail", var2);
         var6.setMaxResults(1);
         List var4 = var6.list();
         if (var4.size() > 0) {
            var3 = (Contacts)var4.get(0);
         }

         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public Contacts recupererContacts(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Contacts");
         var4 = true;
      }

      Query var5 = var3.createQuery("from Contacts where conid=:id order by conpatronyme").setLong("id", var1);
      new Contacts();
      List var7 = var5.list();
      Contacts var6;
      if (var7.size() > 0) {
         var6 = (Contacts)var7.get(0);
      } else {
         var6 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List listeContacts(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Contacts");
         var3 = true;
      }

      new ArrayList();
      List var4 = var2.createQuery(var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List listContactByNom(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Contacts");
         var3 = true;
      }

      new ArrayList();
      String var5 = "from Contacts where ((connom is not null and connom<>'') or (conservice is not null and conservice<>'')) and connom<>'*' and connom<>'**' and connom<>'-' and connom<>'--' and connom<>'.' and connom<>'..'";
      var5 = var5 + " and (tiers.tietype='1' or tiers.tietype='2' or tiers.tietype='3')";
      if (var1 != null && !var1.isEmpty()) {
         if (var1.startsWith("*")) {
            String var6 = var1.substring(1);
            var5 = var5 + " and (connom LIKE" + "'%" + var6 + "%' or conprenom LIKE" + "'%" + var6 + "%' or conmail1 LIKE " + "'%" + var6 + "%' or conmail2 LIKE " + "'%" + var6 + "%' or conmail3 LIKE " + "'%" + var6 + "%' or conmail4 LIKE " + "'%" + var6 + "%' or conmail5 LIKE " + "'%" + var6 + "%')";
         } else {
            var5 = var5 + " and (connom LIKE" + "'" + var1 + "%' or conprenom LIKE" + "'" + var1 + "%' or conmail1 LIKE " + "'" + var1 + "%' or conmail2 LIKE " + "'" + var1 + "%' or conmail3 LIKE " + "'" + var1 + "%' or conmail4 LIKE " + "'" + var1 + "%' or conmail5 LIKE " + "'" + var1 + "%')";
         }
      }

      List var4 = var2.createQuery(var5).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public Contacts chargerLesContactsBq(String var1, String var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var6 = true;
      }

      List var7 = var5.createQuery("from Contacts where tiers.tietype='0' AND tiers.tiecategorie='Banque' and connumbanque='" + var1 + "' and conguichetbanque='" + var2 + "' and concomptebanque='" + var3 + "' and conclebanque='" + var4 + "' order by conpatronyme").list();
      this.contacts = new Contacts();
      if (var7.size() != 0) {
         this.contacts = (Contacts)var7.get(0);
      } else {
         this.contacts = null;
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return this.contacts;
   }
}
