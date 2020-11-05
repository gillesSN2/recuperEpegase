package com.epegase.systeme.dao;

import com.epegase.systeme.classe.BonDecaissementAchat;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class BonDecaissementAchatDao implements Serializable {
   private BonDecaissementAchat bonDecaissementAchat;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public BonDecaissementAchatDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public BonDecaissementAchat insert(BonDecaissementAchat var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public BonDecaissementAchat ModifBon(BonDecaissementAchat var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BonDecaissementAchat");
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

   public BonDecaissementAchat ModifBon(BonDecaissementAchat var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(BonDecaissementAchat var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BonDecaissementAchat");
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

   public void delete(BonDecaissementAchat var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List selectFind(int var1, int var2, String var3, List var4, String var5, String var6, String var7, int var8, long var9, String var11, int var12, List var13, List var14, Session var15) throws HibernateException, NamingException, ParseException {
      boolean var16 = false;
      if (var15 == null) {
         var15 = this.utilInitHibernate.getOpenSession(this.mabase, "BonDecaissementAchat");
         var16 = true;
      }

      new ArrayList();
      UtilDate var18 = new UtilDate();
      Date var19 = var18.stringToDateSQL(var6 + " 00:00:00");
      Date var20 = var18.stringToDateSQL(var7 + " 23:59:59");
      Criteria var21 = var15.createCriteria(BonDecaissementAchat.class);
      var21 = var21.add(Restrictions.between("bonDate", var19, var20));
      var21 = var21.add(Restrictions.eq("bonActif", 0));
      if (!var3.equalsIgnoreCase("100")) {
         var21 = var21.add(Restrictions.eq("bonService", var3));
      }

      if (var5 != null && !var5.isEmpty() && !var5.equalsIgnoreCase("100")) {
         var21 = var21.add(Restrictions.eq("bonCodeCaisse", var5));
      } else if (var4.size() != 0 && var8 != 2) {
         var21 = var21.add(Restrictions.or(Restrictions.in("bonCodeCaisse", var4), Restrictions.isNull("bonCodeCaisse")));
      }

      if (var8 != 0) {
         if (var8 == 1) {
            var21 = var21.add(Restrictions.eq("bonUserCreat", var9));
         } else if (var8 == 2 && var14.size() != 0) {
            var21 = var21.add(Restrictions.in("bonGrp", var14));
         }
      }

      if (var12 != 0 && var12 == 1 && var13.size() != 0) {
         var21 = var21.add(Restrictions.not(Restrictions.in("bonCodeCaisse", var13)));
      }

      if (var11 != null && !var11.isEmpty()) {
         String var22 = "%" + var11 + "%";
         var21 = var21.add(Restrictions.like("bonNomTiers", var22));
      }

      if (var1 == 0) {
         var21 = var21.add(Restrictions.eq("bonEtat", var1));
      } else if (var1 == 1) {
         var21 = var21.add(Restrictions.eq("bonEtat", var1));
      } else if (var1 == 2) {
         var21 = var21.add(Restrictions.eq("bonEtat", var1));
      }

      List var17 = var21.list();
      if (var16) {
         this.utilInitHibernate.closeSession();
      }

      return var17;
   }

   public BonDecaissementAchat selectById(Long var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BonDecaissementAchat");
         var3 = true;
      }

      new BonDecaissementAchat();
      Query var5 = var2.createQuery("from BonDecaissementAchat where  bonId=:id").setLong("id", var1).setMaxResults(1);
      List var6 = var5.list();
      BonDecaissementAchat var4;
      if (var6.size() > 0) {
         var4 = (BonDecaissementAchat)var6.get(0);
      } else {
         var4 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public BonDecaissementAchat bonEncaissementBySerieAnneeDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "BonDecaissementAchat");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      Query var8 = var5.createQuery("from BonDecaissementAchat where bonSerie =:ser and year(bonDate)=" + var7 + " order by bonDate desc");
      var8.setParameter("id", var1);
      var8.setParameter("ser", var3);
      BonDecaissementAchat var9 = null;
      if (var8.list() != null) {
         var8.setMaxResults(1);
         List var10 = var8.list();
         if (var10.size() > 0) {
            var9 = (BonDecaissementAchat)var10.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public BonDecaissementAchat bonEncaissementBySerieMoisDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "BonDecaissementAchat");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      int var8 = var4.getMonth();
      Query var9 = var5.createQuery("from BonDecaissementAchat where  bonSerie =:ser and year(bonDate)=" + var7 + " and month(bonDate)=" + var8 + " order by bonDate desc");
      var9.setParameter("id", var1);
      var9.setParameter("ser", var3);
      BonDecaissementAchat var10 = null;
      if (var9.list() != null) {
         var9.setMaxResults(1);
         List var11 = var9.list();
         if (var11.size() > 0) {
            var10 = (BonDecaissementAchat)var11.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List selectNonPayer(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BonDecaissementAchat");
         var2 = true;
      }

      new ArrayList();
      Query var4 = var1.createQuery("from BonDecaissementAchat where  bonEtat=0 order by bonDate desc");
      List var3 = var4.list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List selectExecuter(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BonDecaissementAchat");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from BonDecaissementAchat where bonEtat=1 and bonDate>=:deb and bonDate<=:fin").setDate("deb", var1).setDate("fin", var2);
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectAnnuler(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BonDecaissementAchat");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from BonDecaissementAchat where bonEtat=2 and bonDate>=:deb and bonDate<=:fin").setDate("deb", var1).setDate("fin", var2);
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheBeByDoc(long var1, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BonDecaissementAchat");
         var5 = true;
      }

      new ArrayList();
      Query var7 = var4.createQuery("from BonDecaissementAchat where bonIdRef=:id and bonNatRef=:nat order by bonDate desc").setLong("id", var1).setInteger("nat", var3);
      List var6 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List selectBon(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BonDecaissementAchat");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from BonDecaissementAchat where bonDate>=:deb and bonDate<=:fin").setDate("deb", var1).setDate("fin", var2);
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
