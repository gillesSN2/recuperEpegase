package com.epegase.systeme.dao;

import com.epegase.systeme.classe.BonEncaissementVente;
import com.epegase.systeme.classe.Patients;
import com.epegase.systeme.classe.Tiers;
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

public class BonEncaissementVenteDao implements Serializable {
   private BonEncaissementVente bonEncaissementVente;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public BonEncaissementVenteDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public BonEncaissementVente insert(BonEncaissementVente var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public BonEncaissementVente ModifBon(BonEncaissementVente var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BonEncaissementVente");
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

   public BonEncaissementVente ModifBon(BonEncaissementVente var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(BonEncaissementVente var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BonEncaissementVente");
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

   public void delete(BonEncaissementVente var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List selectFind(int var1, int var2, String var3, List var4, String var5, String var6, String var7, int var8, long var9, String var11, int var12, List var13, List var14, Session var15) throws HibernateException, NamingException, ParseException {
      boolean var16 = false;
      if (var15 == null) {
         var15 = this.utilInitHibernate.getOpenSession(this.mabase, "BonEncaissementVente");
         var16 = true;
      }

      new ArrayList();
      UtilDate var18 = new UtilDate();
      Date var19 = var18.stringToDateSQL(var6 + " 00:00:00");
      Date var20 = var18.stringToDateSQL(var7 + " 23:59:59");
      Criteria var21 = var15.createCriteria(BonEncaissementVente.class);
      var21 = var21.add(Restrictions.between("bonDate", var19, var20));
      if (!var3.equalsIgnoreCase("100")) {
         var21 = var21.add(Restrictions.or(Restrictions.eq("bonService", var3), Restrictions.eq("bonPdv", var3)));
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

   public BonEncaissementVente selectById(Long var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BonEncaissementVente");
         var3 = true;
      }

      new BonEncaissementVente();
      Query var5 = var2.createQuery("from BonEncaissementVente where bonId=:id").setLong("id", var1).setMaxResults(1);
      List var6 = var5.list();
      BonEncaissementVente var4;
      if (var6.size() > 0) {
         var4 = (BonEncaissementVente)var6.get(0);
      } else {
         var4 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public BonEncaissementVente selectByCaution(Long var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BonEncaissementVente");
         var3 = true;
      }

      new BonEncaissementVente();
      Query var5 = var2.createQuery("from BonEncaissementVente where bonIdEquipe=:id").setLong("id", var1).setMaxResults(1);
      List var6 = var5.list();
      BonEncaissementVente var4;
      if (var6.size() > 0) {
         var4 = (BonEncaissementVente)var6.get(0);
      } else {
         var4 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public BonEncaissementVente bonEncaissementBySerieAnneeDate(String var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BonEncaissementVente");
         var4 = true;
      }

      int var5 = 1900 + var2.getYear();
      Query var6 = var3.createQuery("from BonEncaissementVente where bonSerie =:ser and year(bonDate)=" + var5 + " order by bonDate desc").setParameter("ser", var1);
      BonEncaissementVente var7 = null;
      if (var6.list() != null) {
         var6.setMaxResults(1);
         List var8 = var6.list();
         if (var8.size() > 0) {
            var7 = (BonEncaissementVente)var8.get(0);
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public BonEncaissementVente bonEncaissementBySerieMoisDate(String var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BonEncaissementVente");
         var4 = true;
      }

      int var5 = 1900 + var2.getYear();
      int var6 = var2.getMonth();
      Query var7 = var3.createQuery("from BonEncaissementVente where bonSerie =:ser and year(bonDate)=" + var5 + " and month(bonDate)=" + var6 + " order by bonDate desc").setParameter("ser", var1);
      BonEncaissementVente var8 = null;
      if (var7.list() != null) {
         var7.setMaxResults(1);
         List var9 = var7.list();
         if (var9.size() > 0) {
            var8 = (BonEncaissementVente)var9.get(0);
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List selectNonPayer(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BonEncaissementVente");
         var2 = true;
      }

      new ArrayList();
      Query var4 = var1.createQuery("from BonEncaissementVente where bonEtat=0");
      List var3 = var4.list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List selectExecuter(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BonEncaissementVente");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from BonEncaissementVente where bonEtat=1 and bonDate>=:deb and bonDate<=:fin").setDate("deb", var1).setDate("fin", var2);
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectAnnuler(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BonEncaissementVente");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from BonEncaissementVente where bonEtat=2 and bonDate>=:deb and bonDate<=:fin").setDate("deb", var1).setDate("fin", var2);
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectNonPayer(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BonEncaissementVente");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from BonEncaissementVente where bonEtat=0 and bonNatRef=:ref").setInteger("ref", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List selectNonPayerMedic(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BonEncaissementVente");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from BonEncaissementVente where bonEtat=0 and (bonNatRef=71 or bonNatRef=72 or bonNatRef=73 or bonNatRef=74 or bonNatRef=76 or bonNatRef=78)");
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List rechercheBeByDoc(long var1, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BonEncaissementVente");
         var5 = true;
      }

      new ArrayList();
      Query var7 = var4.createQuery("from BonEncaissementVente where bonIdRef=:id and bonNatRef=:nat order by bonDate desc").setLong("id", var1).setInteger("nat", var3);
      List var6 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheBeByDocAppelFonds(long var1, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BonEncaissementVente");
         var5 = true;
      }

      new ArrayList();
      Query var7 = var4.createQuery("from BonEncaissementVente where bonIdRef=:id and bonNatRef=:nat and bonTypeTiers=20 and bonType=1 order by bonDate desc").setLong("id", var1).setInteger("nat", var3);
      List var6 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public BonEncaissementVente selectBeByDoc(long var1, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BonEncaissementVente");
         var5 = true;
      }

      this.bonEncaissementVente = new BonEncaissementVente();
      new ArrayList();
      Query var7 = var4.createQuery("from BonEncaissementVente where bonIdRef=:id and bonNatRef=:nat order by bonDate desc").setLong("id", var1).setInteger("nat", var3);
      List var6 = var7.list();
      if (var6.size() != 0) {
         this.bonEncaissementVente = (BonEncaissementVente)var6.get(0);
      } else {
         this.bonEncaissementVente = null;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return this.bonEncaissementVente;
   }

   public List rechercheBeByDocExercice(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BonEncaissementVente");
         var2 = true;
      }

      new ArrayList();
      Query var4 = var1.createQuery("from BonEncaissementVente where bonEtat=0 order by bonDate desc");
      List var3 = var4.list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List rechercheByTiersClient(Tiers var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BonEncaissementVente");
         var4 = true;
      }

      List var5 = var2.createQuery("from BonEncaissementVente where bonIdTiers=:tie and bonTypeTiers>=1 and bonTypeTiers<=3").setLong("tie", var1.getTieid()).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheByTiersPatient(Patients var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BonEncaissementVente");
         var4 = true;
      }

      List var5 = var2.createQuery("from BonEncaissementVente where bonIdTiers=:tie and bonTypeTiers=4").setLong("tie", var1.getPatId()).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheByTiersFournisseur(Tiers var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BonEncaissementVente");
         var4 = true;
      }

      List var5 = var2.createQuery("from BonEncaissementVente where bonIdTiers=:tie and bonTypeTiers=0").setLong("tie", var1.getTieid()).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectBon(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BonEncaissementVente");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from BonEncaissementVente where bonDate>=:deb and bonDate<=:fin").setDate("deb", var1).setDate("fin", var2);
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
