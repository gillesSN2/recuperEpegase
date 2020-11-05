package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
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

public class UsersChronoDao implements Serializable {
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public UsersChronoDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public UsersChrono insert(UsersChrono var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "");
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

   public UsersChrono insert(UsersChrono var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public UsersChrono modifier(UsersChrono var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         var2.saveOrUpdate(var1);
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

   public UsersChrono modifier(UsersChrono var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(UsersChrono var1, Session var2) {
      var2.delete(var1);
   }

   public String delete(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "");
      Transaction var4 = var3.beginTransaction();
      var4.begin();
      Query var5 = var3.createQuery("delete from UsersChrono where usrchrId =:Sid").setLong("Sid", var1);
      var5.executeUpdate();
      var4.commit();
      this.utilInitHibernate.closeSession();
      return null;
   }

   public void delete(UsersChrono var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "");
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

   public List selectListToutByUser(Users var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var3 = true;
      }

      Query var4 = var2.createQuery("from UsersChrono where users=:use order by usrchrSerie asc").setParameter("use", var1);
      new ArrayList();
      if (var4.list() != null) {
         List var5 = var4.list();
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return var5;
      } else {
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return null;
      }
   }

   public List selectListVente() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.mabase, "");
      Query var2 = var1.createQuery("from UsersChrono where ((usrchrNature>=6 and usrchrNature<=9) or (usrchrNature>=20 and usrchrNature<=29) or (usrchrNature>=100 and usrchrNature<=109) or (usrchrNature>=140 and usrchrNature<=149) or (usrchrNature>=160 and usrchrNature<=169 or (usrchrNature>=220 and usrchrNature<=229) or (usrchrNature>=250 and usrchrNature<=269)) order by usrchrSerie asc");
      new ArrayList();
      if (var2.list() != null) {
         List var3 = var2.list();
         this.utilInitHibernate.closeSession();
         return var3;
      } else {
         this.utilInitHibernate.closeSession();
         return null;
      }
   }

   public List selectListVenteByUser(Users var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var3 = true;
      }

      Query var4 = var2.createQuery("from UsersChrono where users=:use and ((usrchrNature>=6 and usrchrNature<=9) or (usrchrNature>=20 and usrchrNature<=29) or (usrchrNature>=100 and usrchrNature<=109) or (usrchrNature>=140 and usrchrNature<=149) or (usrchrNature>=160 and usrchrNature<=169) or (usrchrNature>=220 and usrchrNature<=229) or (usrchrNature>=250 and usrchrNature<=269)) order by usrchrSerie asc").setParameter("use", var1);
      new ArrayList();
      if (var4.list() != null) {
         List var5 = var4.list();
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return var5;
      } else {
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return null;
      }
   }

   public List selectListSimulationVentes(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var2 = true;
      }

      Query var3 = var1.createQuery("from UsersChrono where (usrchrNature>=6 and usrchrNature<=9) order by usrchrSerie asc");
      Object var4 = new ArrayList();
      if (var3.list() != null) {
         var4 = var3.list();
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var4;
   }

   public List selectListCaisse() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.mabase, "");
      Query var2 = var1.createQuery("from UsersChrono where usrchrNature>=60 and usrchrNature<=69 order by usrchrCodeCaisse asc");
      new ArrayList();
      if (var2.list() != null) {
         List var3 = var2.list();
         this.utilInitHibernate.closeSession();
         return var3;
      } else {
         this.utilInitHibernate.closeSession();
         return null;
      }
   }

   public List selectListCaisse(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var3 = true;
      }

      Query var4 = var2.createQuery("from UsersChrono where usrchrCodeCaisse=:code and usrchrNature>=60 and usrchrNature<=69 order by users.usrPatronyme asc").setString("code", var1);
      new ArrayList();
      if (var4.list() != null) {
         List var5 = var4.list();
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return var5;
      } else {
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return null;
      }
   }

   public List selectListCaisseByUser(Users var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var3 = true;
      }

      Query var4 = var2.createQuery("from UsersChrono where users=:use and (usrchrNature>=60 and usrchrNature<=69) order by usrchrCodeCaisse asc").setParameter("use", var1);
      new ArrayList();
      if (var4.list() != null) {
         List var5 = var4.list();
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return var5;
      } else {
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return null;
      }
   }

   public List selectListRecuByUser(Users var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var3 = true;
      }

      Query var4 = var2.createQuery("from UsersChrono where users=:use and usrchrNature=61 order by usrchrCodeCaisse asc").setParameter("use", var1);
      new ArrayList();
      if (var4.list() != null) {
         List var5 = var4.list();
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return var5;
      } else {
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return null;
      }
   }

   public List selectListAchat() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.mabase, "");
      Query var2 = var1.createQuery("from UsersChrono where ((usrchrNature>=10 and usrchrNature<=19) or (usrchrNature>=40 and usrchrNature<=49)) order by usrchrSerie asc");
      new ArrayList();
      if (var2.list() != null) {
         List var3 = var2.list();
         this.utilInitHibernate.closeSession();
         return var3;
      } else {
         this.utilInitHibernate.closeSession();
         return null;
      }
   }

   public List selectListByUser(Users var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var3 = true;
      }

      Query var4 = var2.createQuery("from UsersChrono where users=:use");
      var4.setParameter("use", var1);
      new ArrayList();
      if (var4.list() != null) {
         List var5 = var4.list();
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return var5;
      } else {
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return null;
      }
   }

   public List selectListByUserComm(Users var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var3 = true;
      }

      Query var4 = var2.createQuery("from UsersChrono where users=:use and (usrchrNature>=10 and usrchrNature<=39) group by usrchrSerie");
      var4.setParameter("use", var1);
      new ArrayList();
      if (var4.list() != null) {
         List var5 = var4.list();
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return var5;
      } else {
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return null;
      }
   }

   public List selectListOfficeByUser(Users var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var3 = true;
      }

      Query var4 = var2.createQuery("from UsersChrono where users=:use and ((usrchrNature>=1 and usrchrNature<=5) or (usrchrNature>=120 and usrchrNature<=129)) order by usrchrNature asc").setParameter("use", var1);
      new ArrayList();
      if (var4.list() != null) {
         List var5 = var4.list();
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return var5;
      } else {
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return null;
      }
   }

   public List selectListComptaByUser(Users var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var3 = true;
      }

      Query var4 = var2.createQuery("from UsersChrono where users=:use and ((usrchrNature>=50 and usrchrNature<=59) or (usrchrNature>=531 and usrchrNature<=539)) order by usrchrNature asc").setParameter("use", var1);
      new ArrayList();
      if (var4.list() != null) {
         List var5 = var4.list();
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return var5;
      } else {
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return null;
      }
   }

   public List selectListAchatByUser(Users var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var3 = true;
      }

      Query var4 = var2.createQuery("from UsersChrono where users=:use and ((usrchrNature>=10 and usrchrNature<=19) or (usrchrNature>=30 and usrchrNature<=39)) order by usrchrSerie asc").setParameter("use", var1);
      new ArrayList();
      if (var4.list() != null) {
         List var5 = var4.list();
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return var5;
      } else {
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return null;
      }
   }

   public List selectListPaye() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.mabase, "");
      Query var2 = var1.createQuery("from UsersChrono where usrchrNature>=80 and usrchrNature<=99 order by usrchrSerie asc");
      new ArrayList();
      if (var2.list() != null) {
         List var3 = var2.list();
         this.utilInitHibernate.closeSession();
         return var3;
      } else {
         this.utilInitHibernate.closeSession();
         return null;
      }
   }

   public List selectListPayeByUser(Users var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var3 = true;
      }

      Query var4 = var2.createQuery("from UsersChrono where users=:use and (usrchrNature>=80 and usrchrNature<=99) order by usrchrSerie asc").setParameter("use", var1);
      new ArrayList();
      if (var4.list() != null) {
         List var5 = var4.list();
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return var5;
      } else {
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return null;
      }
   }

   public List selectListByUserNat(Users var1, int var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var4 = true;
      }

      Object var5 = new ArrayList();
      Query var6 = var3.createQuery("from UsersChrono where users=:use and usrchrNature=:na order by usrchrSerie asc").setParameter("use", var1).setParameter("na", var2);
      if (var6.list() != null) {
         var5 = var6.list();
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var5;
   }

   public List selectListMedical() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.mabase, "");
      Query var2 = var1.createQuery("from UsersChrono where ((usrchrNature>=70 and usrchrNature<=79) or usrchrNature=7 or (usrchrNature>=180 and usrchrNature<=189)) order by usrchrSerie asc");
      new ArrayList();
      if (var2.list() != null) {
         List var3 = var2.list();
         this.utilInitHibernate.closeSession();
         return var3;
      } else {
         this.utilInitHibernate.closeSession();
         return null;
      }
   }

   public List selectListMedicalByUser(Users var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var3 = true;
      }

      Query var4 = var2.createQuery("from UsersChrono where users=:use and ((usrchrNature>=70 and usrchrNature<=79) or usrchrNature=7 or (usrchrNature>=180 and usrchrNature<=189)) order by usrchrSerie asc").setParameter("use", var1);
      new ArrayList();
      if (var4.list() != null) {
         List var5 = var4.list();
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return var5;
      } else {
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return null;
      }
   }

   public List selectListParc() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.mabase, "");
      Query var2 = var1.createQuery("from UsersChrono where usrchrNature>=40 and usrchrNature<=49 order by usrchrSerie asc");
      new ArrayList();
      if (var2.list() != null) {
         List var3 = var2.list();
         this.utilInitHibernate.closeSession();
         return var3;
      } else {
         this.utilInitHibernate.closeSession();
         return null;
      }
   }

   public List selectListParcByUser(Users var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var3 = true;
      }

      Query var4 = var2.createQuery("from UsersChrono where users=:use and (usrchrNature>=40 and usrchrNature<=49) order by usrchrSerie asc").setParameter("use", var1);
      new ArrayList();
      if (var4.list() != null) {
         List var5 = var4.list();
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return var5;
      } else {
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return null;
      }
   }

   public UsersChrono selectUnique(String var1, int var2, Users var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var5 = true;
      }

      UsersChrono var6 = null;
      Query var7 = null;
      if (var1 != null && !var1.isEmpty()) {
         var7 = var4.createQuery("from UsersChrono where users=:usr and usrchrSerie=:ser and usrchrNature=:na order by usrchrNature desc").setString("ser", var1).setInteger("na", var2).setParameter("usr", var3).setMaxResults(1);
      } else {
         var7 = var4.createQuery("from UsersChrono where users=:usr and usrchrNature=:na order by usrchrNature desc").setInteger("na", var2).setParameter("usr", var3).setMaxResults(1);
      }

      List var8 = var7.list();
      if (var8.size() != 0) {
         var6 = (UsersChrono)var8.get(0);
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public UsersChrono selectUnique(String var1, String var2, int var3, Users var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var6 = true;
      }

      UsersChrono var7 = null;
      Query var8 = null;
      if (var1 != null && !var1.isEmpty()) {
         var8 = var5.createQuery("from UsersChrono where users=:usr and usrchrSerie=:ser and usrchrNature=:na and usrchrCodeCaisse=:caisse order by usrchrNature desc").setString("ser", var1).setInteger("na", var3).setString("caisse", var2).setParameter("usr", var4).setMaxResults(1);
      } else {
         var8 = var5.createQuery("from UsersChrono where users=:usr and usrchrNature=:na and usrchrCodeCaisse=:caisse order by usrchrNature desc").setInteger("na", var3).setParameter("usr", var4).setString("caisse", var2).setMaxResults(1);
      }

      List var9 = var8.list();
      if (var9.size() != 0) {
         var7 = (UsersChrono)var9.get(0);
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public boolean existByUserNat(Users var1, int var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var4 = true;
      }

      Query var5 = var3.createQuery("from UsersChrono where users=:use and usrchrNature=:na order by usrchrSerie asc").setParameter("use", var1).setInteger("na", var2).setMaxResults(1);
      boolean var6 = false;
      if (var5.list().size() > 0) {
         var6 = true;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public UsersChrono chronoByUserNat(Users var1, int var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var4 = true;
      }

      new UsersChrono();
      Query var6 = var3.createQuery("from UsersChrono where users=:use and usrchrNature=:na order by usrchrSerie asc").setParameter("use", var1).setInteger("na", var2).setMaxResults(1);
      UsersChrono var5;
      if (var6.list().size() > 0) {
         var5 = (UsersChrono)var6.list().get(0);
      } else {
         var5 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectChronoByUserNat(Users var1, int var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var4 = true;
      }

      new UsersChrono();
      Query var6 = var3.createQuery("from UsersChrono where users=:use and usrchrNature=:na order by usrchrSerie asc").setParameter("use", var1).setInteger("na", var2);
      new ArrayList();
      List var7 = var6.list();
      ArrayList var8 = new ArrayList();
      if (var7.size() != 0) {
         for(int var9 = 0; var9 < var7.size(); ++var9) {
            var8.add(new SelectItem(((UsersChrono)var7.get(var9)).getUsrchrCodeCaisse() + ":" + ((UsersChrono)var7.get(var9)).getUsrchrLib()));
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List selectSerieByUserAchats(Users var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var3 = true;
      }

      new UsersChrono();
      Query var5 = var2.createQuery("from UsersChrono where users=:use and ((usrchrNature>=10 and usrchrNature<=19) or (usrchrNature>=40 and usrchrNature<=49)) group by usrchrSerie order by usrchrSerie asc").setParameter("use", var1);
      new ArrayList();
      List var6 = var5.list();
      ArrayList var7 = new ArrayList();
      if (var6.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            var7.add(new SelectItem(((UsersChrono)var6.get(var8)).getUsrchrSerie()));
         }

         if (var6.size() >= 2) {
            var7.add(new SelectItem("*"));
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List selectSerieByUserVentes(Users var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var3 = true;
      }

      new UsersChrono();
      Query var5 = var2.createQuery("from UsersChrono where users=:use and ((usrchrNature>=6 and usrchrNature<=9) or (usrchrNature>=20 and usrchrNature<=29) or (usrchrNature>=100 and usrchrNature<=109) or (usrchrNature>=140 and usrchrNature<=149) or (usrchrNature>=160 and usrchrNature<=169) or (usrchrNature>=220 and usrchrNature<=229) or (usrchrNature>=250 and usrchrNature<=269)) group by usrchrSerie order by usrchrSerie asc").setParameter("use", var1);
      new ArrayList();
      List var6 = var5.list();
      ArrayList var7 = new ArrayList();
      if (var6.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            var7.add(new SelectItem(((UsersChrono)var6.get(var8)).getUsrchrSerie()));
         }

         if (var6.size() >= 2) {
            var7.add(new SelectItem("*"));
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List selectChronoByUserNat(Users var1, int var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var5 = true;
      }

      new UsersChrono();
      Query var7 = null;
      if (var3 != null && !var3.isEmpty()) {
         var7 = var4.createQuery("from UsersChrono where users=:use and usrchrNature=:na and usrchrSerie=:ser order by usrchrSerie,usrchrCodeCaisse asc").setParameter("use", var1).setInteger("na", var2).setString("ser", var3);
      } else {
         var7 = var4.createQuery("from UsersChrono where users=:use and usrchrNature=:na order by usrchrSerie,usrchrCodeCaisse asc").setParameter("use", var1).setInteger("na", var2);
      }

      new ArrayList();
      List var8 = var7.list();
      ArrayList var9 = new ArrayList();
      if (var8.size() != 0) {
         for(int var10 = 0; var10 < var8.size(); ++var10) {
            var9.add(new SelectItem(((UsersChrono)var8.get(var10)).getUsrchrCodeCaisse() + ":" + ((UsersChrono)var8.get(var10)).getUsrchrLib()));
         }
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public UsersChrono chronoByUserNat(long var1, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var5 = true;
      }

      new UsersChrono();
      Query var7 = var4.createQuery("from UsersChrono where users.usrid=:use and usrchrNature=:na order by usrchrSerie asc").setLong("use", var1).setInteger("na", var3).setMaxResults(1);
      UsersChrono var6;
      if (var7.list().size() > 0) {
         var6 = (UsersChrono)var7.list().get(0);
      } else {
         var6 = null;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public UsersChrono chronoByUserNat(long var1, int var3, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var6 = true;
      }

      new UsersChrono();
      Query var8 = var5.createQuery("from UsersChrono where users.usrid=:use and usrchrNature=:na and usrchrCodeCaisse=:caisse order by usrchrSerie asc").setLong("use", var1).setInteger("na", var3).setString("caisse", var4).setMaxResults(1);
      UsersChrono var7;
      if (var8.list().size() > 0) {
         var7 = (UsersChrono)var8.list().get(0);
      } else {
         var7 = null;
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }
}
