package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesPaye;
import com.epegase.systeme.classe.Salaries;
import com.epegase.systeme.classe.SalariesHistorique;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SalariesHistoriqueDao implements Serializable {
   private SalariesHistorique salariesHistorique;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public SalariesHistoriqueDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public SalariesHistorique insert(SalariesHistorique var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
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

   public SalariesHistorique insert(SalariesHistorique var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public SalariesHistorique modif(SalariesHistorique var1) throws HibernateException, NamingException {
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

   public SalariesHistorique modif(SalariesHistorique var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(SalariesHistorique var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
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

   public void delete(SalariesHistorique var1, Session var2) {
      var2.delete(var1);
   }

   public List chargerlesHistoriquesBySalaries(Salaries var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from SalariesHistorique where Salaries=:salarie order by salhisCode asc").setParameter("salarie", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerlesHistoriquesBySalaries(Salaries var1, String var2, ExercicesPaye var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var5 = true;
      }

      new ArrayList();
      Query var7 = null;
      if (var2 != null && !var2.isEmpty()) {
         var7 = var4.createQuery("from SalariesHistorique where Salaries=:salarie and ((salhisContrat is null or salhisContrat = '') or (salhisContrat is not null and salhisContrat=:crt)) and ExercicesPaye=:exo order by salhisCode asc").setParameter("salarie", var1).setParameter("exo", var3).setString("crt", var2);
      } else {
         var7 = var4.createQuery("from SalariesHistorique where Salaries=:salarie and ExercicesPaye=:exo order by salhisCode asc").setParameter("salarie", var1).setParameter("exo", var3);
      }

      List var6 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerlesHistoriquesByCode(Salaries var1, String var2, ExercicesPaye var3, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var6 = true;
      }

      new ArrayList();
      Query var8 = null;
      if (var2 != null && !var2.isEmpty()) {
         var8 = var5.createQuery("from SalariesHistorique where Salaries=:sal and ((salhisContrat is null or salhisContrat = '') or (salhisContrat is not null and salhisContrat=:crt)) and ExercicesPaye=:exo and salhisContrat=:cod order by salhisCode asc").setParameter("sal", var1).setParameter("exo", var3).setString("crt", var2).setString("cod", var4);
      } else {
         var8 = var5.createQuery("from SalariesHistorique where Salaries=:sal and ExercicesPaye=:exo and salhisContrat=:cod order by salhisCode asc").setParameter("sal", var1).setParameter("exo", var3).setString("crt", var2).setString("cod", var4);
      }

      List var7 = var8.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public SalariesHistorique pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var4 = true;
      }

      Query var5 = var3.createQuery("from SalariesHistorique where salhisId =:num").setLong("num", var1).setMaxResults(1);
      List var6 = var5.list();
      SalariesHistorique var7 = null;
      if (var6.size() != 0) {
         var7 = (SalariesHistorique)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public SalariesHistorique chargerlesHistoriquesByCode(Salaries var1, Date var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var5 = true;
      }

      new ArrayList();
      Query var7 = var4.createQuery("from SalariesHistorique where Salaries=:sal and salhisDate=:dte and salhisCode=:rub order by salhisCode asc").setParameter("sal", var1).setDate("dte", var2).setString("rub", var3).setMaxResults(1);
      List var6 = var7.list();
      this.salariesHistorique = new SalariesHistorique();
      if (var6.size() != 0) {
         this.salariesHistorique = (SalariesHistorique)var6.get(0);
      } else {
         this.salariesHistorique = null;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return this.salariesHistorique;
   }
}
