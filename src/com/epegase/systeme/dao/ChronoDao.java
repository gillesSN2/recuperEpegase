package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Chrono;
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

public class ChronoDao implements Serializable {
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ChronoDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public Chrono insertChrono(Chrono var1) throws HibernateException, NamingException {
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

   public Chrono insertChrono(Chrono var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public Chrono modifierChrono(Chrono var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "");
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

   public Chrono modifierChrono(Chrono var1, Session var2) throws HibernateException, NamingException {
      if (var2 == null) {
         var1 = this.modifierChrono(var1);
      } else {
         var2.update(var1);
      }

      return var1;
   }

   public void deleteChrono(Chrono var1) throws HibernateException, NamingException {
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

   public void deleteChrono(Chrono var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public String deleteChronoNat(int var1, Session var2) {
      Query var3 = var2.createQuery("delete from Chrono where chrNature =:nat");
      var3.setParameter("nat", var1);
      var3.executeUpdate();
      return null;
   }

   public List selectListByNature(int var1, int var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var4 = true;
      }

      Query var5 = null;
      if (var2 == 1) {
         var5 = var3.createQuery("from Chrono where chrPrive=1 and chrNature=" + var1 + " group by chrSerie");
      } else {
         var5 = var3.createQuery("from Chrono where chrPrive=0 and chrNature=" + var1 + " group by chrSerie");
      }

      Object var6 = new ArrayList();
      if (var5.list() != null) {
         var6 = var5.list();
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var6;
   }

   public List selectListOffice(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var3 = true;
      }

      Query var4 = null;
      if (var1 == 1) {
         var4 = var2.createQuery("from Chrono where chrPrive=0 and ((chrNature>=1 and chrNature<=5) or (chrNature>=120 and chrNature<=129)) order by chrPeriode");
      } else {
         var4 = var2.createQuery("from Chrono where ((chrNature>=1 and chrNature<=5) or (chrNature>=120 and chrNature<=129)) order by chrPeriode");
      }

      Object var5 = new ArrayList();
      if (var4.list() != null) {
         var5 = var4.list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var5;
   }

   public List selectListTiers(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var3 = true;
      }

      Query var4 = null;
      if (var1 == 1) {
         var4 = var2.createQuery("from Chrono where chrPrive=0 and (chrNature>=300 and chrNature<=329) order by chrPeriode");
      } else {
         var4 = var2.createQuery("from Chrono where (chrNature>=300 and chrNature<=329) order by chrPeriode");
      }

      Object var5 = new ArrayList();
      if (var4.list() != null) {
         var5 = var4.list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var5;
   }

   public List selectListAchat(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var3 = true;
      }

      Query var4 = null;
      if (var1 == 1) {
         var4 = var2.createQuery("from Chrono where chrPrive=0 and ((chrNature>=10 and chrNature<=19) or (chrNature>=30 and chrNature<=39) or (chrNature>=150 and chrNature<=159)) order by chrPeriode");
      } else {
         var4 = var2.createQuery("from Chrono where ((chrNature>=10 and chrNature<=19) or (chrNature>=30 and chrNature<=39) or (chrNature>=150 and chrNature<=159)) order by chrPeriode");
      }

      Object var5 = new ArrayList();
      if (var4.list() != null) {
         var5 = var4.list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var5;
   }

   public List selectListVente(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var3 = true;
      }

      Query var4 = null;
      if (var1 == 1) {
         var4 = var2.createQuery("from Chrono where chrPrive=0 and ((chrNature>=6 and chrNature<=9) or (chrNature>=20 and chrNature<=29) or (chrNature>=140 and chrNature<=149)  or (chrNature>=250 and chrNature<=269)) order by chrPeriode");
      } else {
         var4 = var2.createQuery("from Chrono where ((chrNature>=6 and chrNature<=9) or (chrNature>=20 and chrNature<=29) or (chrNature>=140 and chrNature<=149)  or (chrNature>=250 and chrNature<=269)) order by chrPeriode");
      }

      Object var5 = new ArrayList();
      if (var4.list() != null) {
         var5 = var4.list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var5;
   }

   public List selectListParc(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var3 = true;
      }

      Query var4 = null;
      if (var1 == 1) {
         var4 = var2.createQuery("from Chrono where chrPrive=0 and (chrNature>=40 and chrNature<=49) order by chrPeriode");
      } else {
         var4 = var2.createQuery("from Chrono where (chrNature>=40 and chrNature<=49) order by chrPeriode");
      }

      Object var5 = new ArrayList();
      if (var4.list() != null) {
         var5 = var4.list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var5;
   }

   public List selectListPaye(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var3 = true;
      }

      Query var4 = null;
      if (var1 == 1) {
         var4 = var2.createQuery("from Chrono where chrPrive=0 and chrNature>=80 and chrNature<=99 order by chrPeriode");
      } else {
         var4 = var2.createQuery("from Chrono where chrNature>=80 and chrNature<=99 order by chrPeriode");
      }

      Object var5 = new ArrayList();
      if (var4.list() != null) {
         var5 = var4.list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var5;
   }

   public List selectListCompta(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var3 = true;
      }

      Query var4 = null;
      if (var1 == 1) {
         var4 = var2.createQuery("from Chrono where chrPrive=0 and ((chrNature>=50 and chrNature<=59) or (chrNature>=530 and chrNature<=539)) order by chrPeriode,chrNature");
      } else {
         var4 = var2.createQuery("from Chrono where ((chrNature>=50 and chrNature<=59) or (chrNature>=530 and chrNature<=539)) order by chrPeriode,chrNature");
      }

      Object var5 = new ArrayList();
      if (var4.list() != null) {
         var5 = var4.list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var5;
   }

   public List selectListCaisses(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var3 = true;
      }

      Query var4 = null;
      if (var1 == 1) {
         var4 = var2.createQuery("from Chrono where chrPrive=0 and (chrNature>=60 and chrNature<=69) order by chrPeriode");
      } else {
         var4 = var2.createQuery("from Chrono where (chrNature>=60 and chrNature<=69) order by chrPeriode");
      }

      Object var5 = new ArrayList();
      if (var4.list() != null) {
         var5 = var4.list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var5;
   }

   public List selectListEducation(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var3 = true;
      }

      Query var4 = null;
      if (var1 == 1) {
         var4 = var2.createQuery("from Chrono where chrPrive=0 and chrNature>=100 and chrNature<=109 order by chrPeriode");
      } else {
         var4 = var2.createQuery("from Chrono where chrNature>=100 and chrNature<=109 order by chrPeriode");
      }

      Object var5 = new ArrayList();
      if (var4.list() != null) {
         var5 = var4.list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var5;
   }

   public List selectListMedical(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var3 = true;
      }

      Query var4 = null;
      if (var1 == 1) {
         var4 = var2.createQuery("from Chrono where chrPrive=0 and ((chrNature>=70 and chrNature<=79) or chrNature=7 or chrNature=22 or (chrNature>=180 and chrNature<=189)) order by chrPeriode");
      } else {
         var4 = var2.createQuery("from Chrono where ((chrNature>=70 and chrNature<=79) or chrNature=7 or chrNature=22 or (chrNature>=180 and chrNature<=189)) order by chrPeriode");
      }

      Object var5 = new ArrayList();
      if (var4.list() != null) {
         var5 = var4.list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var5;
   }

   public List selectListImmobilier(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var3 = true;
      }

      Query var4 = null;
      if (var1 == 1) {
         var4 = var2.createQuery("from Chrono where chrPrive=0 and chrNature>=160 and chrNature<=189 order by chrPeriode");
      } else {
         var4 = var2.createQuery("from Chrono where chrNature>=160 and chrNature<=189 order by chrPeriode");
      }

      Object var5 = new ArrayList();
      if (var4.list() != null) {
         var5 = var4.list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var5;
   }

   public List selectListMicroFinance(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var3 = true;
      }

      Query var4 = null;
      if (var1 == 1) {
         var4 = var2.createQuery("from Chrono where chrPrive=0 and ((chrNature>=200 and chrNature<=229)) order by chrPeriode");
      } else {
         var4 = var2.createQuery("from Chrono where ((chrNature>=200 and chrNature<=229)) order by chrPeriode");
      }

      Object var5 = new ArrayList();
      if (var4.list() != null) {
         var5 = var4.list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var5;
   }

   public List selectListFondation(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var3 = true;
      }

      Query var4 = null;
      if (var1 == 1) {
         var4 = var2.createQuery("from Chrono where chrPrive=0 and ((chrNature>=220 and chrNature<=229)) order by chrPeriode");
      } else {
         var4 = var2.createQuery("from Chrono where ((chrNature>=220 and chrNature<=229)) order by chrPeriode");
      }

      Object var5 = new ArrayList();
      if (var4.list() != null) {
         var5 = var4.list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var5;
   }

   public Chrono chronoBySerieAch(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Chrono where chrSerie =:ser and ((chrNature>=10 and chrNature<=19) or (chrNature>=30 and chrNature<=39) or (chrNature>=150 and chrNature<=159)) order by chrId desc");
      var4.setParameter("ser", var1);
      var4.setMaxResults(1);
      List var5 = var4.list();
      Chrono var6 = null;
      if (var5.size() != 0) {
         var6 = (Chrono)var5.get(0);
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public Chrono chronoBySerieVte(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Chrono where chrSerie =:ser and ((chrNature>=6 and chrNature<=9) or (chrNature>=20 and chrNature<=29) or (chrNature>=100 and chrNature<=109) or (chrNature>=140 and chrNature<=149) or (chrNature>=160 and chrNature<=189) or (chrNature>=220 and chrNature<=229) or (chrNature>=250 and chrNature<=269)) order by chrId desc");
      var4.setParameter("ser", var1);
      var4.setMaxResults(1);
      List var5 = var4.list();
      Chrono var6 = null;
      if (var5.size() != 0) {
         var6 = (Chrono)var5.get(0);
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public Chrono chronoBySerieFdt(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Chrono where chrSerie =:ser and ((chrNature>=220 and chrNature<=229)) order by chrId desc");
      var4.setParameter("ser", var1);
      var4.setMaxResults(1);
      List var5 = var4.list();
      Chrono var6 = null;
      if (var5.size() != 0) {
         var6 = (Chrono)var5.get(0);
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public Chrono chronoBySerieNatServ(String var1, int var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var5 = true;
      }

      Query var6 = var4.createQuery("from Chrono where chrSerie=:ser and chrNature=:na and chrService=:serv order by chrId desc");
      var6.setParameter("ser", var1);
      var6.setParameter("na", var2);
      var6.setParameter("serv", var3);
      var6.setMaxResults(1);
      Chrono var7 = null;
      if (var6.list() != null) {
         List var8 = var6.list();
         if (var8.size() > 0) {
            var7 = (Chrono)var8.get(0);
         }
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public Chrono chronoBySerieNat(String var1, int var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var5 = true;
      }

      new Chrono();
      Query var7 = null;
      if (var1 != null && !var1.isEmpty()) {
         var7 = var4.createQuery("from Chrono where chrSerie=:ser and chrNature=:na and chrPeriode=:annee order by chrId desc").setString("ser", var1).setInteger("na", var2).setString("annee", var3).setMaxResults(1);
         if (var7.list().size() == 0) {
            var7 = var4.createQuery("from Chrono where chrSerie=:ser and chrNature=:na and (chrPeriode='' or chrPeriode is NULL) order by chrId desc").setString("ser", var1).setInteger("na", var2).setMaxResults(1);
            if (var7.list().size() == 0) {
               var7 = var4.createQuery("from Chrono where chrNature=:na and chrPeriode=:annee order by chrId desc").setInteger("na", var2).setString("annee", var3).setMaxResults(1);
               if (var7.list().size() == 0) {
                  var7 = var4.createQuery("from Chrono where chrNature=:na and (chrPeriode='' or chrPeriode is NULL) order by chrId desc").setInteger("na", var2).setMaxResults(1);
               }
            }
         }
      } else {
         var7 = var4.createQuery("from Chrono where chrNature=:na and chrPeriode=:annee order by chrId desc").setInteger("na", var2).setString("annee", var3).setMaxResults(1);
         if (var7.list().size() == 0) {
            var7 = var4.createQuery("from Chrono where chrNature=:na and (chrPeriode='' or chrPeriode is NULL) order by chrId desc").setInteger("na", var2).setMaxResults(1);
            if (var7.list().size() == 0) {
               var7 = var4.createQuery("from Chrono where chrNature=:na and chrPeriode=:annee order by chrId desc").setInteger("na", var2).setString("annee", var3).setMaxResults(1);
               if (var7.list().size() == 0) {
                  var7 = var4.createQuery("from Chrono where chrNature=:na and (chrPeriode='' or chrPeriode is NULL) order by chrId desc").setInteger("na", var2).setMaxResults(1);
               }
            }
         }
      }

      Chrono var6;
      if (var7.list().size() != 0) {
         List var8 = var7.list();
         var6 = (Chrono)var8.get(0);
      } else {
         var6 = null;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public Chrono chronoBySerieNatCompta(String var1, int var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var4 = true;
      }

      new Chrono();
      Query var6 = null;
      if (var1 != null && !var1.isEmpty()) {
         var6 = var3.createQuery("from Chrono where chrSerie=:ser and chrNature=:na order by chrId desc").setString("ser", var1).setInteger("na", var2).setMaxResults(1);
         if (var6.list().size() == 0) {
            var6 = var3.createQuery("from Chrono where chrNature=:na order by chrId desc").setInteger("na", var2).setMaxResults(1);
         }
      } else {
         var6 = var3.createQuery("from Chrono where chrNature=:na order by chrId desc").setInteger("na", var2).setMaxResults(1);
      }

      Chrono var5;
      if (var6.list().size() != 0) {
         List var7 = var6.list();
         var5 = (Chrono)var7.get(0);
      } else {
         var5 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public Chrono chronoBySerieNat(String var1, int var2, String var3, long var4, Session var6) throws HibernateException, NamingException {
      boolean var7 = false;
      if (var6 == null) {
         var6 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var7 = true;
      }

      new Chrono();
      Query var9 = null;
      if (var1 != null && !var1.isEmpty()) {
         var9 = var6.createQuery("from Chrono where chrSerie=:ser and chrNature=:na and chrPeriode=:annee and chrIdStr=:id order by chrId desc").setString("ser", var1).setInteger("na", var2).setString("annee", var3).setLong("id", var4).setMaxResults(1);
         if (var9.list().size() == 0) {
            var9 = var6.createQuery("from Chrono where chrSerie=:ser and chrNature=:na and (chrPeriode='' or chrPeriode is NULL) and chrIdStr=:id order by chrId desc").setString("ser", var1).setInteger("na", var2).setLong("id", var4).setMaxResults(1);
            if (var9.list().size() == 0) {
               var9 = var6.createQuery("from Chrono where chrNature=:na and chrPeriode=:annee and chrIdStr=:id order by chrId desc").setInteger("na", var2).setString("annee", var3).setLong("id", var4).setMaxResults(1);
               if (var9.list().size() == 0) {
                  var9 = var6.createQuery("from Chrono where chrNature=:na and (chrPeriode='' or chrPeriode is NULL) and chrIdStr=:id order by chrId desc").setInteger("na", var2).setLong("id", var4).setMaxResults(1);
               }
            }
         }
      } else {
         var9 = var6.createQuery("from Chrono where chrNature=:na and chrPeriode=:annee and chrIdStr=:id order by chrId desc").setInteger("na", var2).setString("annee", var3).setLong("id", var4).setMaxResults(1);
         if (var9.list().size() == 0) {
            var9 = var6.createQuery("from Chrono where chrNature=:na and (chrPeriode='' or chrPeriode is NULL) and chrIdStr=:id order by chrId desc").setInteger("na", var2).setLong("id", var4).setMaxResults(1);
            if (var9.list().size() == 0) {
               var9 = var6.createQuery("from Chrono where chrNature=:na and chrPeriode=:annee and chrIdStr=:id order by chrId desc").setInteger("na", var2).setString("annee", var3).setLong("id", var4).setMaxResults(1);
               if (var9.list().size() == 0) {
                  var9 = var6.createQuery("from Chrono where chrNature=:na and (chrPeriode='' or chrPeriode is NULL) and chrIdStr=:id order by chrId desc").setInteger("na", var2).setLong("id", var4).setMaxResults(1);
               }
            }
         }
      }

      Chrono var8;
      if (var9.list().size() != 0) {
         List var10 = var9.list();
         var8 = (Chrono)var10.get(0);
      } else {
         var8 = null;
      }

      if (var7) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public Chrono chronoBySerieNat(String var1, String var2, int var3, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var6 = true;
      }

      new Chrono();
      Query var8 = null;
      if ((var3 == 60 || var3 == 61) && var2 != null && !var2.isEmpty()) {
         if (var1 != null && !var1.isEmpty()) {
            var8 = var5.createQuery("from Chrono where chrCodeCaisse=:caisse and chrSerie=:ser and chrNature=:na and chrPeriode=:annee order by chrId desc").setString("caisse", var2).setString("ser", var1).setInteger("na", var3).setString("annee", var4).setMaxResults(1);
            if (var8.list().size() == 0) {
               var8 = var5.createQuery("from Chrono where chrCodeCaisse=:caisse and chrSerie=:ser and chrNature=:na and (chrPeriode='' or chrPeriode is NULL) order by chrId desc").setString("caisse", var2).setString("ser", var1).setInteger("na", var3).setMaxResults(1);
               if (var8.list().size() == 0) {
                  var8 = var5.createQuery("from Chrono where chrCodeCaisse=:caisse and chrNature=:na and chrPeriode=:annee order by chrId desc").setString("caisse", var2).setInteger("na", var3).setString("annee", var4).setMaxResults(1);
                  if (var8.list().size() == 0) {
                     var8 = var5.createQuery("from Chrono where chrCodeCaisse=:caisse and chrNature=:na and (chrPeriode='' or chrPeriode is NULL) order by chrId desc").setString("caisse", var2).setInteger("na", var3).setMaxResults(1);
                  }
               }
            }
         } else {
            var8 = var5.createQuery("from Chrono where chrCodeCaisse=:caisse and chrNature=:na and chrPeriode=:annee order by chrId desc").setString("caisse", var2).setInteger("na", var3).setString("annee", var4).setMaxResults(1);
            if (var8.list().size() == 0) {
               var8 = var5.createQuery("from Chrono where chrCodeCaisse=:caisse and chrNature=:na and (chrPeriode='' or chrPeriode is NULL) order by chrId desc").setString("caisse", var2).setInteger("na", var3).setMaxResults(1);
               if (var8.list().size() == 0) {
                  var8 = var5.createQuery("from Chrono where chrCodeCaisse=:caisse and chrNature=:na and chrPeriode=:annee order by chrId desc").setString("caisse", var2).setInteger("na", var3).setString("annee", var4).setMaxResults(1);
                  if (var8.list().size() == 0) {
                     var8 = var5.createQuery("from Chrono where chrCodeCaisse=:caisse and chrNature=:na and (chrPeriode='' or chrPeriode is NULL) order by chrId desc").setString("caisse", var2).setInteger("na", var3).setMaxResults(1);
                  }
               }
            }
         }
      } else if (var1 != null && !var1.isEmpty()) {
         var8 = var5.createQuery("from Chrono where chrSerie=:ser and chrNature=:na and chrPeriode=:annee order by chrId desc").setString("ser", var1).setInteger("na", var3).setString("annee", var4).setMaxResults(1);
         if (var8.list().size() == 0) {
            var8 = var5.createQuery("from Chrono where chrSerie=:ser and chrNature=:na and (chrPeriode='' or chrPeriode is NULL) order by chrId desc").setString("ser", var1).setInteger("na", var3).setMaxResults(1);
            if (var8.list().size() == 0) {
               var8 = var5.createQuery("from Chrono where chrNature=:na and chrPeriode=:annee order by chrId desc").setInteger("na", var3).setString("annee", var4).setMaxResults(1);
               if (var8.list().size() == 0) {
                  var8 = var5.createQuery("from Chrono where chrNature=:na and (chrPeriode='' or chrPeriode is NULL) order by chrId desc").setInteger("na", var3).setMaxResults(1);
               }
            }
         }
      } else {
         var8 = var5.createQuery("from Chrono where chrNature=:na and chrPeriode=:annee order by chrId desc").setInteger("na", var3).setString("annee", var4).setMaxResults(1);
         if (var8.list().size() == 0) {
            var8 = var5.createQuery("from Chrono where chrNature=:na and (chrPeriode='' or chrPeriode is NULL) order by chrId desc").setInteger("na", var3).setMaxResults(1);
            if (var8.list().size() == 0) {
               var8 = var5.createQuery("from Chrono where chrNature=:na and chrPeriode=:annee order by chrId desc").setInteger("na", var3).setString("annee", var4).setMaxResults(1);
               if (var8.list().size() == 0) {
                  var8 = var5.createQuery("from Chrono where chrNature=:na and (chrPeriode='' or chrPeriode is NULL) order by chrId desc").setInteger("na", var3).setMaxResults(1);
               }
            }
         }
      }

      Chrono var7;
      if (var8.list().size() != 0) {
         List var9 = var8.list();
         var7 = (Chrono)var9.get(0);
      } else {
         var7 = null;
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public Chrono chronoBySerieNat(String var1, String var2, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var5 = true;
      }

      new Chrono();
      Query var7 = null;
      if ((var3 == 60 || var3 == 61) && var2 != null && !var2.isEmpty()) {
         if (var1 != null && !var1.isEmpty()) {
            var7 = var4.createQuery("from Chrono where chrCodeCaisse=:caisse and chrSerie=:ser and chrNature=:na order by chrId desc").setString("caisse", var2).setString("ser", var1).setInteger("na", var3).setMaxResults(1);
            if (var7.list().size() == 0) {
               var7 = var4.createQuery("from Chrono where chrCodeCaisse=:caisse and chrSerie=:ser and chrNature=:na order by chrId desc").setString("caisse", var2).setString("ser", var1).setInteger("na", var3).setMaxResults(1);
               if (var7.list().size() == 0) {
                  var7 = var4.createQuery("from Chrono where chrCodeCaisse=:caisse and chrNature=:na order by chrId desc").setString("caisse", var2).setInteger("na", var3).setMaxResults(1);
                  if (var7.list().size() == 0) {
                     var7 = var4.createQuery("from Chrono where chrCodeCaisse=:caisse and chrNature=:na order by chrId desc").setString("caisse", var2).setInteger("na", var3).setMaxResults(1);
                  }
               }
            }
         } else {
            var7 = var4.createQuery("from Chrono where chrCodeCaisse=:caisse and chrNature=:na order by chrId desc").setString("caisse", var2).setInteger("na", var3).setMaxResults(1);
            if (var7.list().size() == 0) {
               var7 = var4.createQuery("from Chrono where chrCodeCaisse=:caisse and chrNature=:na order by chrId desc").setString("caisse", var2).setInteger("na", var3).setMaxResults(1);
               if (var7.list().size() == 0) {
                  var7 = var4.createQuery("from Chrono where chrCodeCaisse=:caisse and chrNature=:na order by chrId desc").setString("caisse", var2).setInteger("na", var3).setMaxResults(1);
                  if (var7.list().size() == 0) {
                     var7 = var4.createQuery("from Chrono where chrCodeCaisse=:caisse and chrNature=:na order by chrId desc").setString("caisse", var2).setInteger("na", var3).setMaxResults(1);
                  }
               }
            }
         }
      } else if (var1 != null && !var1.isEmpty()) {
         var7 = var4.createQuery("from Chrono where chrSerie=:ser and chrNature=:na order by chrId desc").setString("ser", var1).setInteger("na", var3).setMaxResults(1);
         if (var7.list().size() == 0) {
            var7 = var4.createQuery("from Chrono where chrSerie=:ser and chrNature=:na order by chrId desc").setString("ser", var1).setInteger("na", var3).setMaxResults(1);
            if (var7.list().size() == 0) {
               var7 = var4.createQuery("from Chrono where chrNature=:na order by chrId desc").setInteger("na", var3).setMaxResults(1);
               if (var7.list().size() == 0) {
                  var7 = var4.createQuery("from Chrono where chrNature=:na order by chrId desc").setInteger("na", var3).setMaxResults(1);
               }
            }
         }
      } else {
         var7 = var4.createQuery("from Chrono where chrNature=:na order by chrId desc").setInteger("na", var3).setMaxResults(1);
         if (var7.list().size() == 0) {
            var7 = var4.createQuery("from Chrono where chrNature=:na order by chrId desc").setInteger("na", var3).setMaxResults(1);
            if (var7.list().size() == 0) {
               var7 = var4.createQuery("from Chrono where chrNature=:na order by chrId desc").setInteger("na", var3).setMaxResults(1);
               if (var7.list().size() == 0) {
                  var7 = var4.createQuery("from Chrono where chrNature=:na order by chrId desc").setInteger("na", var3).setMaxResults(1);
               }
            }
         }
      }

      Chrono var6;
      if (var7.list().size() != 0) {
         List var8 = var7.list();
         var6 = (Chrono)var8.get(0);
      } else {
         var6 = null;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public Chrono chronoBySerieNat(String var1, int var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var4 = true;
      }

      new Chrono();
      Query var6 = var3.createQuery("from Chrono where chrSerie=:ser and chrNature=:na order by chrId desc").setString("ser", var1).setInteger("na", var2).setMaxResults(1);
      Chrono var5;
      if (var6.list().size() != 0) {
         List var7 = var6.list();
         var5 = (Chrono)var7.get(0);
      } else {
         var5 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public Chrono rechercheSalarieNature(String var1, int var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var4 = true;
      }

      String var5 = var1 + ":";
      new Chrono();
      Query var7 = var3.createQuery("from Chrono where chrSerie like '" + var5 + "%' and chrNature=:na order by chrId desc").setInteger("na", var2).setMaxResults(1);
      Chrono var6;
      if (var7.list().size() != 0) {
         List var8 = var7.list();
         var6 = (Chrono)var8.get(0);
      } else {
         var6 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public Chrono rechercheEleveNature(String var1, int var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var4 = true;
      }

      new Chrono();
      Query var6 = var3.createQuery("from Chrono where chrSerie = '" + var1 + "' and chrNature=:na order by chrId desc").setInteger("na", var2).setMaxResults(1);
      Chrono var5;
      if (var6.list().size() != 0) {
         List var7 = var6.list();
         var5 = (Chrono)var7.get(0);
      } else {
         var5 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public Chrono chronoByNat(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Chrono where chrNature=:na order by chrId desc").setInteger("na", var1).setMaxResults(1);
      Chrono var5 = null;
      if (var4.list() != null) {
         List var6 = var4.list();
         if (var6.size() > 0) {
            var5 = (Chrono)var6.get(0);
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public Chrono chronoByNatAndJournalPeriode(int var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var5 = true;
      }

      new Chrono();
      new ArrayList();
      List var7 = var4.createQuery("from Chrono where chrNature=" + var1 + " and chrJournal='" + var2 + "' and chrPeriode='" + var3 + "' order by chrId desc").setMaxResults(1).list();
      if (var7.size() == 0) {
         var7 = var4.createQuery("from Chrono where chrNature=" + var1 + " and chrJournal='" + var2 + "' and (chrPeriode='' or chrPeriode is null) order by chrId desc").setMaxResults(1).list();
      }

      Chrono var6;
      if (var7.size() != 0) {
         var6 = (Chrono)var7.get(0);
      } else {
         var6 = null;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List selectListClientItem(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var2 = true;
      }

      List var3 = var1.createQuery("from Chrono where ((chrNature>=6 and chrNature<=9) or (chrNature>=20 and chrNature<=29) or (chrNature>=100 and chrNature<=109) or (chrNature>=140 and chrNature<=149) or (chrNature>=160 and chrNature<=189) or (chrNature>=220 and chrNature<=229) or (chrNature>=250 and chrNature<=269)) order by chrNature asc").list();
      new ArrayList();
      List var4 = var3;
      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var5.add(new SelectItem(((Chrono)var4.get(var6)).getChrNature() + ":" + ((Chrono)var4.get(var6)).getChrSerie() + ":" + ((Chrono)var4.get(var6)).getLibnature() + ":" + ((Chrono)var4.get(var6)).getChrNom()));
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectListSerieItem(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var2 = true;
      }

      List var3 = var1.createQuery("from Chrono where ((chrNature>=6 and chrNature<=9) or (chrNature>=20 and chrNature<=29) or (chrNature>=140 and chrNature<=149)) or ((chrNature>=10 and chrNature<=19) or (chrNature>=30 and chrNature<=39)) group by chrSerie order by chrSerie asc").list();
      new ArrayList();
      List var4 = var3;
      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var5.add(new SelectItem(((Chrono)var4.get(var6)).getChrSerie()));
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectListCaisseItem(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var2 = true;
      }

      List var3 = var1.createQuery("from Chrono where chrNature>=60 and chrNature<=69 order by chrNature asc").list();
      new ArrayList();
      List var4 = var3;
      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         boolean var6 = false;

         for(int var7 = 0; var7 < var4.size(); ++var7) {
            var6 = false;
            int var8 = ((Chrono)var4.get(var7)).getChrNature();
            String var9 = ((Chrono)var4.get(var7)).getChrSerie();
            if (var5.size() != 0) {
               if (((Chrono)var4.get(var7)).getChrNature() != 60 && ((Chrono)var4.get(var7)).getChrNature() != 61) {
                  for(int var16 = 0; var16 < var5.size(); ++var16) {
                     String var17 = ((SelectItem)var5.get(var16)).getValue().toString();
                     String[] var18 = var17.split(":");
                     int var19 = Integer.parseInt(var18[0]);
                     String var20 = var18[1];
                     if (var8 == var19 && var9.equals(var20)) {
                        var6 = true;
                        break;
                     }
                  }
               } else {
                  String var10 = "(" + ((Chrono)var4.get(var7)).getChrCodeCaisse() + ")";

                  for(int var11 = 0; var11 < var5.size(); ++var11) {
                     String var12 = ((SelectItem)var5.get(var11)).getValue().toString();
                     String[] var13 = var12.split(":");
                     int var14 = Integer.parseInt(var13[0]);
                     String var15 = var13[1];
                     if (var8 == var14 && var9.equals(var15) && var12.contains(var10)) {
                        var6 = true;
                        break;
                     }
                  }
               }
            }

            if (!var6) {
               if (((Chrono)var4.get(var7)).getChrNature() != 60 && ((Chrono)var4.get(var7)).getChrNature() != 61) {
                  var5.add(new SelectItem(((Chrono)var4.get(var7)).getChrNature() + ":" + ((Chrono)var4.get(var7)).getChrSerie() + ":" + ((Chrono)var4.get(var7)).getLibnature() + ":" + ((Chrono)var4.get(var7)).getChrNom()));
               } else if (((Chrono)var4.get(var7)).getChrCodeCaisse() != null && !((Chrono)var4.get(var7)).getChrCodeCaisse().isEmpty()) {
                  var5.add(new SelectItem(((Chrono)var4.get(var7)).getChrNature() + ":" + ((Chrono)var4.get(var7)).getChrSerie() + ":" + ((Chrono)var4.get(var7)).getLibnature() + ":" + ((Chrono)var4.get(var7)).getChrNom() + " (" + ((Chrono)var4.get(var7)).getChrCodeCaisse() + ")"));
               }
            }
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectListPayeItem(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var2 = true;
      }

      List var3 = var1.createQuery("from Chrono where chrNature>=80 and chrNature<=99 order by chrNature asc").list();
      new ArrayList();
      List var4 = var3;
      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            if (((Chrono)var4.get(var6)).getChrNature() == 81) {
               var5.add(new SelectItem(((Chrono)var4.get(var6)).getChrNature() + ":" + ((Chrono)var4.get(var6)).getChrSerie() + ":" + ((Chrono)var4.get(var6)).getLibnature()));
            } else {
               var5.add(new SelectItem(((Chrono)var4.get(var6)).getChrNature() + ":" + ((Chrono)var4.get(var6)).getLibnature()));
            }
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectListOfficeItem(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var2 = true;
      }

      List var3 = var1.createQuery("from Chrono where ((chrNature>=1 and chrNature<=5) or (chrNature>=120 and chrNature<=129)) order by chrNature asc").list();
      new ArrayList();
      List var4 = var3;
      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var5.add(new SelectItem(((Chrono)var4.get(var6)).getChrNature() + ":" + ((Chrono)var4.get(var6)).getLibnature()));
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectListComptaItem(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var2 = true;
      }

      List var3 = var1.createQuery("from Chrono where ((chrNature>=50 and chrNature<=59) or (chrNature>=530 and chrNature<=539)) group by chrNature").list();
      new ArrayList();
      List var4 = var3;
      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var5.add(new SelectItem(((Chrono)var4.get(var6)).getChrNature() + ":" + ((Chrono)var4.get(var6)).getLibnature()));
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectListFournisseurItem(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var2 = true;
      }

      List var3 = var1.createQuery("from Chrono where ((chrNature>=10 and chrNature<=19) or (chrNature>=30 and chrNature<=39) or (chrNature>=150 and chrNature<=159)) order by chrNature asc").list();
      new ArrayList();
      List var4 = var3;
      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var5.add(new SelectItem(((Chrono)var4.get(var6)).getChrNature() + ":" + ((Chrono)var4.get(var6)).getChrSerie() + ":" + ((Chrono)var4.get(var6)).getLibnature() + ":" + ((Chrono)var4.get(var6)).getChrNom()));
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectListMedicalItem(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var2 = true;
      }

      List var3 = var1.createQuery("from Chrono where ((chrNature>=70 and chrNature<=79) or chrNature=7 or chrNature=22  or (chrNature>=180 and chrNature<=189)) order by chrNature asc").list();
      new ArrayList();
      List var4 = var3;
      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var5.add(new SelectItem(((Chrono)var4.get(var6)).getChrNature() + ":" + ((Chrono)var4.get(var6)).getChrSerie() + ":" + ((Chrono)var4.get(var6)).getLibnature() + ":" + ((Chrono)var4.get(var6)).getChrNom()));
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectListParcItem(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var2 = true;
      }

      List var3 = var1.createQuery("from Chrono where (chrNature>=40 and chrNature<=49) order by chrNature asc").list();
      new ArrayList();
      List var4 = var3;
      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var5.add(new SelectItem(((Chrono)var4.get(var6)).getChrNature() + ":" + ((Chrono)var4.get(var6)).getChrSerie() + ":" + ((Chrono)var4.get(var6)).getLibnature() + ":" + ((Chrono)var4.get(var6)).getChrNom()));
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectListEduItem(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var2 = true;
      }

      List var3 = var1.createQuery("from Chrono where chrNature>=100 and chrNature<=109 order by chrNature asc").list();
      new ArrayList();
      List var4 = var3;
      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            if (((Chrono)var4.get(var6)).getChrNature() == 81) {
               var5.add(new SelectItem(((Chrono)var4.get(var6)).getChrNature() + ":" + ((Chrono)var4.get(var6)).getChrSerie() + ":" + ((Chrono)var4.get(var6)).getLibnature()));
            } else {
               var5.add(new SelectItem(((Chrono)var4.get(var6)).getChrNature() + ":" + ((Chrono)var4.get(var6)).getLibnature()));
            }
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectListMefItem(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var2 = true;
      }

      List var3 = var1.createQuery("from Chrono where chrNature>=200 and chrNature<=229 order by chrNature asc").list();
      new ArrayList();
      List var4 = var3;
      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            if (((Chrono)var4.get(var6)).getChrNature() == 81) {
               var5.add(new SelectItem(((Chrono)var4.get(var6)).getChrNature() + ":" + ((Chrono)var4.get(var6)).getChrSerie() + ":" + ((Chrono)var4.get(var6)).getLibnature()));
            } else {
               var5.add(new SelectItem(((Chrono)var4.get(var6)).getChrNature() + ":" + ((Chrono)var4.get(var6)).getLibnature()));
            }
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public Chrono selectUnique(String var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "");
      new Chrono();
      Query var4 = var2.createQuery("from Chrono where " + var1 + " order by chrNature desc").setMaxResults(1);
      new ArrayList();
      List var5 = var4.list();
      Chrono var3;
      if (var5.size() != 0) {
         var3 = (Chrono)var5.get(0);
      } else {
         var3 = null;
      }

      this.utilInitHibernate.closeSession();
      return var3;
   }
}
