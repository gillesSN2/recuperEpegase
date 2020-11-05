package com.epegase.systeme.dao;

import com.epegase.systeme.classe.BulletinLigne;
import com.epegase.systeme.classe.BulletinSalaire;
import com.epegase.systeme.classe.ExercicesPaye;
import com.epegase.systeme.classe.Salaries;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class BulletinLigneDao implements Serializable {
   private BulletinLigne bulletinLigne;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public BulletinLigneDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public BulletinLigne insert(BulletinLigne var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public BulletinLigne modif(BulletinLigne var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
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

   public BulletinLigne modif(BulletinLigne var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(BulletinLigne var1, Session var2) {
      var2.delete(var1);
   }

   public List chargerleslignesBulletin(BulletinSalaire var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from BulletinLigne where BulletinSalaire=:bul and BulletinSalaire.bulsalPeriode<>'SIMUL' order by bulligId asc").setParameter("bul", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerleslignesBulletinSimulation(BulletinSalaire var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from BulletinLigne where BulletinSalaire=:bul and BulletinSalaire.bulsalPeriode='SIMUL' order by bulligId asc").setParameter("bul", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerleslignesbyRubriquesSalaries(String var1, Salaries var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from BulletinLigne where Salaries=:sal and bulligRubrique='" + var1 + "' and BulletinSalaire.bulsalPeriode<>'SIMUL' order by BulletinSalaire.bulsalDateDebut asc").setParameter("sal", var2);
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerleslignesbyRubriquesSalaries(String var1, String var2, Salaries var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var5 = true;
      }

      new ArrayList();
      Query var7 = var4.createQuery("from BulletinLigne where Salaries=:sal and ((bulligRubrique between '" + var1 + "' and '" + var2 + "') or bulligRubrique='" + var1 + "' or bulligRubrique='" + var2 + "') and BulletinSalaire.bulsalPeriode<>'SIMUL' order by BulletinSalaire.bulsalDateDebut asc").setParameter("sal", var3);
      List var6 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerleslignesbyRubriquesSalaries(String var1, Date var2, Date var3, Salaries var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var6 = true;
      }

      new ArrayList();
      Query var8 = null;
      if (var2 == null) {
         var8 = var5.createQuery("from BulletinLigne where Salaries=:sal and bulligRubrique='" + var1 + "' and BulletinSalaire.bulsalDateDebut<=:d2 and BulletinSalaire.bulsalPeriode<>'SIMUL' order by BulletinSalaire.bulsalDateDebut asc").setParameter("sal", var4).setDate("d2", var3);
      } else {
         var8 = var5.createQuery("from BulletinLigne where Salaries=:sal and bulligRubrique='" + var1 + "' and BulletinSalaire.bulsalDateDebut>=:d1 and BulletinSalaire.bulsalDateDebut<=:d2 and BulletinSalaire.bulsalPeriode<>'SIMUL'  order by BulletinSalaire.bulsalDateDebut asc").setParameter("sal", var4).setDate("d1", var2).setDate("d2", var3);
      }

      List var7 = var8.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerleslignesLikeRubriquesSalaries(String var1, Date var2, Date var3, Salaries var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var6 = true;
      }

      new ArrayList();
      Query var8 = null;
      if (var2 == null) {
         var8 = var5.createQuery("from BulletinLigne where Salaries=:sal and bulligRubrique in (" + var1 + ") and BulletinSalaire.bulsalDateDebut<=:d2 and BulletinSalaire.bulsalPeriode<>'SIMUL' order by BulletinSalaire.bulsalDateDebut asc").setParameter("sal", var4).setDate("d2", var3);
      } else {
         var8 = var5.createQuery("from BulletinLigne where Salaries=:sal and bulligRubrique in (" + var1 + ") and BulletinSalaire.bulsalDateDebut>=:d1 and BulletinSalaire.bulsalDateDebut<=:d2 and BulletinSalaire.bulsalPeriode<>'SIMUL' order by BulletinSalaire.bulsalDateDebut asc").setParameter("sal", var4).setDate("d1", var2).setDate("d2", var3);
      }

      List var7 = var8.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerleslignesbyRubriquesSalaries(int var1, Date var2, Date var3, Salaries var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var6 = true;
      }

      new ArrayList();
      Query var8 = null;
      if (var2 == null) {
         var8 = var5.createQuery("from BulletinLigne where Salaries=:sal and bulligNature=" + var1 + " and BulletinSalaire.bulsalDateDebut<=:d2 and BulletinSalaire.bulsalPeriode<>'SIMUL' order by BulletinSalaire.bulsalDateDebut asc").setParameter("sal", var4).setDate("d2", var3);
      } else {
         var8 = var5.createQuery("from BulletinLigne where Salaries=:sal and bulligNature=" + var1 + " and BulletinSalaire.bulsalDateDebut>=:d1 and BulletinSalaire.bulsalDateDebut<=:d2 and BulletinSalaire.bulsalPeriode<>'SIMUL'  order by BulletinSalaire.bulsalDateDebut asc").setParameter("sal", var4).setDate("d1", var2).setDate("d2", var3);
      }

      List var7 = var8.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerleslignesbyRubriquesSalaries(Date var1, Date var2, Salaries var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var5 = true;
      }

      new ArrayList();
      Query var7 = var4.createQuery("from BulletinLigne where Salaries=:sal and BulletinSalaire.bulsalDateDebut>=:d1 and BulletinSalaire.bulsalDateDebut<=:d2 and BulletinSalaire.bulsalPeriode<>'SIMUL' order by bulligRubrique asc").setParameter("sal", var3).setDate("d1", var1).setDate("d2", var2);
      List var6 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerleslignesbyRubriquesSalaries(String var1, String var2, Date var3, Date var4, Salaries var5, Session var6) throws HibernateException, NamingException {
      boolean var7 = false;
      if (var6 == null) {
         var6 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var7 = true;
      }

      new ArrayList();
      Query var9 = null;
      if (var2 != null && !var2.isEmpty()) {
         var9 = var6.createQuery("from BulletinLigne where Salaries=:sal and ((bulligRubrique between '" + var1 + "' and '" + var2 + "') or bulligRubrique='" + var1 + "' or bulligRubrique='" + var2 + "') and BulletinSalaire.bulsalDateDebut>=:d1 and BulletinSalaire.bulsalDateDebut<=:d2 and BulletinSalaire.bulsalPeriode<>'SIMUL' order by BulletinSalaire.bulsalDateDebut asc").setParameter("sal", var5).setDate("d1", var3).setDate("d2", var4);
      } else {
         var9 = var6.createQuery("from BulletinLigne where Salaries=:sal and bulligRubrique = '" + var1 + "' and BulletinSalaire.bulsalDateDebut>=:d1 and BulletinSalaire.bulsalDateDebut<=:d2 and BulletinSalaire.bulsalPeriode<>'SIMUL' order by BulletinSalaire.bulsalDateDebut asc").setParameter("sal", var5).setDate("d1", var3).setDate("d2", var4);
      }

      List var8 = var9.list();
      if (var7) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List chargerleslignesbyRubriques(String var1, Date var2, Date var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var5 = true;
      }

      new ArrayList();
      Query var7 = var4.createQuery("from BulletinLigne where bulligRubrique='" + var1 + "' and BulletinSalaire.bulsalDateDebut>=:d1 and BulletinSalaire.bulsalDateDebut<=:d2 and BulletinSalaire.bulsalPeriode<>'SIMUL' order by BulletinSalaire.bulsalDateDebut asc").setDate("d1", var2).setDate("d2", var3);
      List var6 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerleslignesbyRubriques(int var1, Date var2, Date var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var5 = true;
      }

      new ArrayList();
      Query var7 = var4.createQuery("from BulletinLigne where bulligNature=" + var1 + " and BulletinSalaire.bulsalDateDebut>=:d1 and BulletinSalaire.bulsalDateDebut<=:d2 and BulletinSalaire.bulsalPeriode<>'SIMUL' order by BulletinSalaire.bulsalDateDebut asc").setDate("d1", var2).setDate("d2", var3);
      List var6 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerleslignesbyRubriques(String var1, String var2, Date var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var6 = true;
      }

      new ArrayList();
      Query var8 = var5.createQuery("from BulletinLigne where ((bulligRubrique between '" + var1 + "' and '" + var2 + "') or bulligRubrique='" + var1 + "' or bulligRubrique='" + var2 + "') and BulletinSalaire.bulsalDateDebut>=:d1 and BulletinSalaire.bulsalDateDebut<=:d2 and BulletinSalaire.bulsalPeriode<>'SIMUL' order by BulletinSalaire.bulsalDateDebut asc").setDate("d1", var3).setDate("d2", var4);
      List var7 = var8.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerleslignesbyNatureSalaries(int var1, Date var2, Date var3, Salaries var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var6 = true;
      }

      new ArrayList();
      Query var8 = null;
      if (var1 == 159) {
         var8 = var5.createQuery("from BulletinLigne where Salaries=:sal and bulligNature<59 and BulletinSalaire.bulsalDateDebut>=:d1 and BulletinSalaire.bulsalDateDebut<=:d2 and BulletinSalaire.bulsalPeriode<>'SIMUL' order by BulletinSalaire.bulsalDateDebut asc").setParameter("sal", var4).setDate("d1", var2).setDate("d2", var3);
      } else if (var1 == 259) {
         var8 = var5.createQuery("from BulletinLigne where Salaries=:sal and (bulligNature<59 or bulligNature=60 or bulligNature=61 or bulligNature=62) and BulletinSalaire.bulsalDateDebut>=:d1 and BulletinSalaire.bulsalDateDebut<=:d2 and BulletinSalaire.bulsalPeriode<>'SIMUL' order by BulletinSalaire.bulsalDateDebut asc").setParameter("sal", var4).setDate("d1", var2).setDate("d2", var3);
      } else if (var1 == 359) {
         var8 = var5.createQuery("from BulletinLigne where Salaries=:sal and (bulligNature<>59 and bulligNature<>69 and bulligNature<>89 and bulligNature<90) and BulletinSalaire.bulsalDateDebut>=:d1 and BulletinSalaire.bulsalDateDebut<=:d2 and BulletinSalaire.bulsalPeriode<>'SIMUL' order by BulletinSalaire.bulsalDateDebut asc").setParameter("sal", var4).setDate("d1", var2).setDate("d2", var3);
      } else {
         var8 = var5.createQuery("from BulletinLigne where Salaries=:sal and bulligNature=" + var1 + " and BulletinSalaire.bulsalDateDebut>=:d1 and BulletinSalaire.bulsalDateDebut<=:d2 and BulletinSalaire.bulsalPeriode<>'SIMUL' order by BulletinSalaire.bulsalDateDebut asc").setParameter("sal", var4).setDate("d1", var2).setDate("d2", var3);
      }

      List var7 = var8.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public BulletinLigne chargerleslignesbyRubriquesPeriode(String var1, String var2, Salaries var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var5 = true;
      }

      this.bulletinLigne = new BulletinLigne();
      new ArrayList();
      Query var7 = var4.createQuery("from BulletinLigne where Salaries=:sal and bulligRubrique=:rub and BulletinSalaire.bulsalPeriode=:per and BulletinSalaire.bulsalPeriode<>'SIMUL'").setParameter("sal", var3).setString("per", var2).setString("rub", var1);
      List var6 = var7.list();
      if (var6.size() != 0) {
         this.bulletinLigne = (BulletinLigne)var6.get(0);
      } else {
         this.bulletinLigne = null;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return this.bulletinLigne;
   }

   public List chargerlesBulletinsbySalarieExercice(Salaries var1, ExercicesPaye var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from BulletinLigne where Salaries=:salarie and ExercicesPaye=:exo and (bulligNature=10 or bulligNature=40 or bulligNature=50 or bulligNature=59 or bulligNature=60 or bulligNature=61 or bulligNature=62 or bulligNature=89 or bulligNature=90) and BulletinSalaire.bulsalPeriode<>'SIMUL' order by BulletinSalaire.bulsalDateDebut asc").setParameter("salarie", var1).setParameter("exo", var2);
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerleslignesBulletinInterim(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from BulletinLigne where BulletinSalaire.bulsalId in " + var1 + " and BulletinSalaire.bulsalPeriode<>'SIMUL' order by bulligId asc");
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLigneBulletins(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from BulletinLigne where BulletinSalaire.bulsalDateDebut>=:d1 and BulletinSalaire.bulsalDateDebut<=:d2 and BulletinSalaire.bulsalPeriode<>'SIMUL' order by BulletinSalaire.bulsalDateDebut asc").setDate("d1", var1).setDate("d2", var2);
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLigneBulletinsRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from BulletinLigne where " + var1 + " order by BulletinSalaire.bulsalMatricule");
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLigneBulletinsRequeteBySalarie(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from BulletinLigne where " + var1 + " group by BulletinSalaire.bulsalMatricule");
      List var4 = var5.list();
      ArrayList var6 = new ArrayList();
      if (var4.size() != 0) {
         for(int var7 = 0; var7 < var4.size(); ++var7) {
            var6.add(((BulletinLigne)var4.get(var7)).getSalaries());
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLigneBulletinsRequeteDetail(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from BulletinLigne where " + var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesContratGroupRubique(ExercicesPaye var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from BulletinLigne where ExercicesPaye=:exo and BulletinSalaire.bulsalPeriode<>'SIMUL' group by bulligRubrique").setParameter("exo", var1);
      List var4 = var5.list();
      ArrayList var6 = new ArrayList();
      if (var4.size() != 0) {
         for(int var7 = 0; var7 < var4.size(); ++var7) {
            var6.add(new SelectItem(((BulletinLigne)var4.get(var7)).getBulligRubrique() + ":" + ((BulletinLigne)var4.get(var7)).getBulligLibelle()));
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesMvts(Date var1, Date var2, boolean var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var5 = true;
      }

      new ArrayList();
      Query var7 = null;
      if (var3) {
         var7 = var4.createQuery("from BulletinLigne where bulligNature=59 and BulletinSalaire.bulsalDateDebut>=:d1 and BulletinSalaire.bulsalDateDebut<=:d2 and BulletinSalaire.bulsalPeriode<>'SIMUL'").setDate("d1", var1).setDate("d2", var2);
      } else {
         var7 = var4.createQuery("from BulletinLigne where bulligNature=59 and BulletinSalaire.bulsalDateDebut>=:d1 and BulletinSalaire.bulsalDateDebut<=:d2 and BulletinSalaire.bulsalNature like '0%' and BulletinSalaire.bulsalPeriode<>'SIMUL'").setDate("d1", var1).setDate("d2", var2);
      }

      List var6 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesMvtsSalaries(Date var1, Date var2, boolean var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var5 = true;
      }

      new ArrayList();
      ArrayList var7 = new ArrayList();
      Query var8 = null;
      if (var3) {
         var8 = var4.createQuery("from BulletinLigne where bulligNature=59 and BulletinSalaire.bulsalDateDebut>=:d1 and BulletinSalaire.bulsalDateDebut<=:d2 and BulletinSalaire.bulsalPeriode<>'SIMUL' group by BulletinSalaire.bulsalMatricule").setDate("d1", var1).setDate("d2", var2);
      } else {
         var8 = var4.createQuery("from BulletinLigne where bulligNature=59 and BulletinSalaire.bulsalDateDebut>=:d1 and BulletinSalaire.bulsalDateDebut<=:d2 and BulletinSalaire.bulsalNature like '0%' and BulletinSalaire.bulsalPeriode<>'SIMUL' group by BulletinSalaire.bulsalMatricule").setDate("d1", var1).setDate("d2", var2);
      }

      List var6 = var8.list();
      if (var6.size() != 0) {
         for(int var9 = 0; var9 < var6.size(); ++var9) {
            var7.add(((BulletinLigne)var6.get(var9)).getSalaries());
         }
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public BulletinLigne trouvePorParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from BulletinLigne where bulligId=:id").setLong("id", var1);
      List var5 = var6.list();
      if (var5.size() != 0) {
         this.bulletinLigne = (BulletinLigne)var5.get(0);
      } else {
         this.bulletinLigne = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.bulletinLigne;
   }

   public List chargerles12BulletinsbySalarie(Date var1, Date var2, Salaries var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var5 = true;
      }

      new ArrayList();
      Query var7 = var4.createQuery("from BulletinLigne where Salaries=:salarie and bulligRubrique='299999' and BulletinSalaire.bulsalPeriode<>'SIMUL' and BulletinSalaire.bulsalDateDebut>=:dte1 and BulletinSalaire.bulsalDateDebut<=:dte2 order by BulletinSalaire.bulsalDateDebut desc").setDate("dte1", var1).setDate("dte2", var2).setParameter("salarie", var3).setMaxResults(12);
      List var6 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheBulletinReporting(Session var1, String var2, List var3, String var4, int var5, String var6, String var7, int var8, String var9, Date var10, Date var11, boolean var12, int var13, List var14, List var15, List var16, List var17, List var18, List var19, List var20, List var21, List var22, List var23) throws HibernateException, NamingException {
      boolean var24 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var24 = true;
      }

      new ArrayList();
      Criteria var26 = var1.createCriteria(BulletinLigne.class);
      var26 = var26.createAlias("BulletinSalaire", "bul", 1);
      var26 = var26.add(Restrictions.ne("bul.bulsalPeriode", "SIMUL"));
      String[] var27;
      if (var6 != null && !var6.isEmpty()) {
         if (var6.contains(":")) {
            var27 = var6.split(":");
            var26 = var26.add(Restrictions.eq("bulligRubrique", var27[0]));
         } else {
            var26 = var26.add(Restrictions.eq("bulligRubrique", var6));
         }
      }

      if (var7 != null && !var7.isEmpty()) {
         if (var7.contains(":")) {
            var27 = var7.split(":");
            var26 = var26.add(Restrictions.eq("bulligNature", Integer.parseInt(var27[0])));
         } else {
            var26 = var26.add(Restrictions.eq("bulligNature", Integer.parseInt(var7)));
         }
      }

      if (var2 == null || var2.isEmpty()) {
         var2 = "0";
      }

      if (var5 == 1) {
         var26 = var26.add(Restrictions.and(Restrictions.ne("bul.bulsalIdTiers", Long.parseLong("0")), Restrictions.ne("bul.bulsalIdTiers", Long.parseLong(var2))));
      } else {
         var26 = var26.add(Restrictions.or(Restrictions.eq("bul.bulsalIdTiers", Long.parseLong("0")), Restrictions.eq("bul.bulsalIdTiers", Long.parseLong(var2))));
      }

      var26 = var26.add(Restrictions.between("bul.bulsalDateDebut", var10, var11));
      if (var3 != null && var3.size() != 0) {
         var26 = var26.add(Restrictions.in("bul.bulsalNature", var3));
      }

      if (var4 != null && !var4.isEmpty()) {
         var26 = var26.add(Restrictions.eq("bul.bulsalFeuille", var4));
      }

      if (var8 != 99) {
         var26 = var26.add(Restrictions.eq("bul.bulsalEtat", var8));
      }

      if (var9 != null && !var9.isEmpty()) {
         var26 = var26.add(Restrictions.eq("bul.bulsalClassement", var9));
      }

      if (var12) {
         if (var15.size() != 0 && ((String)var15.get(0)).equals("[*]")) {
            var26 = var26.add(Restrictions.in("bul.bulsalActivite", var15));
         }

         if (var16.size() != 0 && ((String)var16.get(0)).equals("[*]")) {
            var26 = var26.add(Restrictions.in("bul.bulsalActivite", var16));
         }

         if (var17.size() != 0 && ((String)var17.get(0)).equals("[*]")) {
            var26 = var26.add(Restrictions.in("bul.bulsalActivite", var17));
         }
      } else if (var14.size() != 0 && ((String)var14.get(0)).equals("[*]")) {
         var26 = var26.add(Restrictions.in("bul.bulsalActivite", var14));
      }

      if (var18.size() != 0) {
         var26 = var26.add(Restrictions.in("bul.bulsalSite", var18));
      }

      if (var19.size() != 0) {
         var26 = var26.add(Restrictions.in("bul.bulsalDepartement", var19));
      }

      if (var20.size() != 0) {
         var26 = var26.add(Restrictions.in("bul.bulsalService", var20));
      }

      List var28 = var26.list();
      if (var24) {
         this.utilInitHibernate.closeSession();
      }

      return var28;
   }
}
