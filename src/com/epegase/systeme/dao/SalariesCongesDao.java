package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesPaye;
import com.epegase.systeme.classe.Salaries;
import com.epegase.systeme.classe.SalariesConges;
import com.epegase.systeme.util.UtilDate;
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

public class SalariesCongesDao implements Serializable {
   private SalariesConges salariesConges;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public SalariesCongesDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public SalariesConges insert(SalariesConges var1) throws HibernateException, NamingException {
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

   public SalariesConges insert(SalariesConges var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public SalariesConges modif(SalariesConges var1) throws HibernateException, NamingException {
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

   public SalariesConges modif(SalariesConges var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(SalariesConges var1) throws HibernateException, NamingException {
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

   public void delete(SalariesConges var1, Session var2) {
      var2.delete(var1);
   }

   public List chargerTous(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var2 = true;
      }

      new ArrayList();
      Query var4 = var1.createQuery("from SalariesConges order by salcngDateDebut asc");
      List var3 = var4.list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerToutesDemandes(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var2 = true;
      }

      new ArrayList();
      Query var4 = var1.createQuery("from SalariesConges where (salcngNature=0 or salcngNature=10) order by salcngDateDebut asc");
      List var3 = var4.list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerlesConges(Salaries var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from SalariesConges where Salaries=:salarie and (salcngType=0 or (salcngType=1 and salcngNature=13)) order by salcngDateDebut asc").setParameter("salarie", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerlesAbsences(Salaries var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from SalariesConges where Salaries=:salarie and salcngType=1 order by salcngDateDebut asc").setParameter("salarie", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerlesCongesValide(Salaries var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var4 = true;
      }

      new ArrayList();
      Query var6 = null;
      if (var2 != null && !var2.isEmpty()) {
         var6 = var3.createQuery("from SalariesConges where Salaries=:salarie and ((salcngContrat is null or salcngContrat = '') or (salcngContrat is not null and salcngContrat=:crt)) and salcngType=0 and salcngEtat=1 order by salcngDateDebut asc").setParameter("salarie", var1).setString("crt", var2);
      } else {
         var6 = var3.createQuery("from SalariesConges where Salaries=:salarie and salcngType=0 and salcngEtat=1 order by salcngDateDebut asc").setParameter("salarie", var1);
      }

      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerlesAbsencesValide(Salaries var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var4 = true;
      }

      new ArrayList();
      Query var6 = null;
      if (var2 != null && !var2.isEmpty()) {
         var6 = var3.createQuery("from SalariesConges where Salaries=:salarie and ((salcngContrat is null or salcngContrat = '') or (salcngContrat is not null and salcngContrat=:crt)) and salcngType=1 and salcngEtat=1 order by salcngDateDebut asc").setParameter("salarie", var1).setString("crt", var2);
      } else {
         var6 = var3.createQuery("from SalariesConges where Salaries=:salarie and salcngType=1 and salcngEtat=1 order by salcngDateDebut asc").setParameter("salarie", var1);
      }

      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerlesAbsencesPeriode(Salaries var1, String var2, Date var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var6 = true;
      }

      new ArrayList();
      Query var8 = null;
      if (var2 != null && !var2.isEmpty()) {
         var8 = var5.createQuery("from SalariesConges where Salaries=:salarie and ((salcngContrat is null or salcngContrat = '') or (salcngContrat is not null and salcngContrat=:crt)) and salcngType=1 and ((salcngDateDebut>=:deb and salcngDateDebut<=:fin) or (salcngDateFin>=:deb and salcngDateFin<=:fin)) order by salcngDateDebut asc").setParameter("salarie", var1).setDate("deb", var3).setDate("fin", var4).setString("crt", var2);
      } else {
         var8 = var5.createQuery("from SalariesConges where Salaries=:salarie and salcngType=1 and ((salcngDateDebut>=:deb and salcngDateDebut<=:fin) or (salcngDateFin>=:deb and salcngDateFin<=:fin)) order by salcngDateDebut asc").setParameter("salarie", var1).setDate("deb", var3).setDate("fin", var4);
      }

      List var7 = var8.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerlesAbsencesValidePeriode(Salaries var1, String var2, Date var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var6 = true;
      }

      new ArrayList();
      Query var8 = null;
      if (var2 != null && !var2.isEmpty()) {
         var8 = var5.createQuery("from SalariesConges where Salaries=:salarie and ((salcngContrat is null or salcngContrat = '') or (salcngContrat is not null and salcngContrat=:crt)) and salcngType=1 and salcngEtat=1 and ((salcngDateDebut>=:deb and salcngDateDebut<=:fin) or (salcngDateFin>=:deb and salcngDateFin<=:fin)) order by salcngDateDebut asc").setParameter("salarie", var1).setDate("deb", var3).setDate("fin", var4).setString("crt", var2);
      } else {
         var8 = var5.createQuery("from SalariesConges where Salaries=:salarie and salcngType=1 and salcngEtat=1 and ((salcngDateDebut>=:deb and salcngDateDebut<=:fin) or (salcngDateFin>=:deb and salcngDateFin<=:fin)) order by salcngDateDebut asc").setParameter("salarie", var1).setDate("deb", var3).setDate("fin", var4);
      }

      List var7 = var8.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public SalariesConges pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var4 = true;
      }

      Query var5 = var3.createQuery("from SalariesConges where salcngId =:num").setLong("num", var1).setMaxResults(1);
      List var6 = var5.list();
      SalariesConges var7 = null;
      if (var6.size() != 0) {
         var7 = (SalariesConges)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerlesElementCp(Date var1, Date var2, int var3, int var4, int var5, String var6, String var7, String var8, String var9, String var10, String var11, String var12, String var13, String var14, String var15, String var16, ExercicesPaye var17, Session var18) throws HibernateException, NamingException {
      boolean var19 = false;
      if (var18 == null) {
         var18 = this.utilInitHibernate.getOpenSession(this.maBase, "SuiviRH");
         var19 = true;
      }

      new ArrayList();
      String var21 = "";
      if (var3 == 100) {
         var21 = "salcngNature >= 0 and salcngNature <= 9";
      } else if (var3 == 90) {
         var21 = "salcngNature >= 1 and salcngNature <= 7";
      } else {
         var21 = "salcngNature=" + var3;
      }

      if (var5 != 100) {
         if (var5 == 90) {
            var21 = var21 + " and (Salaries.salEtat=0 or Salaries.salEtat=1)";
         } else {
            var21 = var21 + " and Salaries.salEtat=" + var5;
         }
      }

      if (var4 != 100) {
         var21 = var21 + " and salcngEtat=" + var4;
      }

      UtilDate var22 = new UtilDate();
      String var23;
      String var24;
      if (var1 == null && var2 == null) {
         var23 = var22.dateToStringSQLLight(var17.getExepayDateDebut());
         var24 = var22.dateToStringSQLLight(var17.getExepayDateFin());
         var21 = var21 + " and ((salcngDateDebut>='" + var23 + "' and salcngDateDebut<='" + var24 + "') or (salcngDateFin>='" + var23 + "' and salcngDateFin<='" + var24 + "'))";
      } else {
         var23 = var22.dateToStringSQLLight(var1);
         var24 = var22.dateToStringSQLLight(var2);
         var21 = var21 + " and ((salcngDateDebut>='" + var23 + "' and salcngDateDebut<='" + var24 + "') or (salcngDateFin>='" + var23 + "' and salcngDateFin<='" + var24 + "'))";
      }

      if (!var6.equals("100")) {
         var21 = var21 + " and Salaries.salFeuille='" + var6 + "'";
      }

      if (!var7.equals("100")) {
         var21 = var21 + " and Salaries.salNature='" + var7 + "'";
      }

      String[] var25;
      if (var8.contains(":")) {
         var25 = var8.split(":");
         var24 = var25[0];
         var21 = var21 + " and Salaries.salSite='" + var24 + "'";
      }

      if (var9.contains(":")) {
         var25 = var9.split(":");
         var24 = var25[0];
         var21 = var21 + " and Salaries.salDepartement='" + var24 + "'";
      }

      if (var10.contains(":")) {
         var25 = var10.split(":");
         var24 = var25[0];
         var21 = var21 + " and Salaries.salService='" + var24 + "'";
      }

      if (var11.contains(":")) {
         var25 = var11.split(":");
         var24 = var25[0];
         var21 = var21 + " and Salaries.salActivite='" + var24 + "'";
      }

      if (var12.contains(":")) {
         var25 = var12.split(":");
         var24 = var25[0];
         var21 = var21 + " and Salaries.salConvention='" + var24 + "'";
      }

      if (var13.contains(":")) {
         var25 = var13.split(":");
         var24 = var25[0];
         var21 = var21 + " and Salaries.salNivEmploi='" + var24 + "'";
      }

      if (var14.contains(":")) {
         var25 = var14.split(":");
         var24 = var25[0];
         var21 = var21 + " and Salaries.salClassement='" + var24 + "'";
      }

      if (var15.contains(":")) {
         var25 = var15.split(":");
         var24 = var25[0];
         var21 = var21 + " and Salaries.salGrille='" + var24 + "'";
      }

      if (var16.contains(":")) {
         var25 = var16.split(":");
         var24 = var25[0];
         var21 = var21 + " and Salaries.salCentresImpots='" + var24 + "'";
      }

      Query var26 = var18.createQuery("from SalariesConges where " + var21);
      List var20 = var26.list();
      if (var19) {
         this.utilInitHibernate.closeSession();
      }

      return var20;
   }

   public List chargerlesElementAbs(Date var1, Date var2, int var3, int var4, int var5, String var6, String var7, String var8, String var9, String var10, String var11, String var12, String var13, String var14, String var15, String var16, ExercicesPaye var17, Session var18) throws HibernateException, NamingException {
      boolean var19 = false;
      if (var18 == null) {
         var18 = this.utilInitHibernate.getOpenSession(this.maBase, "SuiviRH");
         var19 = true;
      }

      new ArrayList();
      String var21 = "";
      if (var3 == 100) {
         var21 = "salcngNature >= 10 and salcngNature <= 20";
      } else {
         var21 = "salcngNature=" + var3;
      }

      if (var5 != 100) {
         if (var5 == 90) {
            var21 = var21 + " and (Salaries.salEtat=0 or Salaries.salEtat=1)";
         } else {
            var21 = var21 + " and Salaries.salEtat=" + var5;
         }
      }

      if (var4 != 100) {
         var21 = var21 + " and salcngEtat=" + var4;
      }

      UtilDate var22 = new UtilDate();
      String var23;
      String var24;
      if (var1 == null && var2 == null) {
         var23 = var22.dateToStringSQLLight(var17.getExepayDateDebut());
         var24 = var22.dateToStringSQLLight(var17.getExepayDateFin());
         var21 = var21 + " and ((salcngDateDebut>='" + var23 + "' and salcngDateDebut<='" + var24 + "') or (salcngDateFin>='" + var23 + "' and salcngDateFin<='" + var24 + "'))";
      } else {
         var23 = var22.dateToStringSQLLight(var1);
         var24 = var22.dateToStringSQLLight(var2);
         var21 = var21 + " and ((salcngDateDebut>='" + var23 + "' and salcngDateDebut<='" + var24 + "') or (salcngDateFin>='" + var23 + "' and salcngDateFin<='" + var24 + "'))";
      }

      if (!var6.equals("100")) {
         var21 = var21 + " and Salaries.salFeuille='" + var6 + "'";
      }

      if (!var7.equals("100")) {
         var21 = var21 + " and Salaries.salNature='" + var7 + "'";
      }

      String[] var25;
      if (var8.contains(":")) {
         var25 = var8.split(":");
         var24 = var25[0];
         var21 = var21 + " and Salaries.salSite='" + var24 + "'";
      }

      if (var9.contains(":")) {
         var25 = var9.split(":");
         var24 = var25[0];
         var21 = var21 + " and Salaries.salDepartement='" + var24 + "'";
      }

      if (var10.contains(":")) {
         var25 = var10.split(":");
         var24 = var25[0];
         var21 = var21 + " and Salaries.salService='" + var24 + "'";
      }

      if (var11.contains(":")) {
         var25 = var11.split(":");
         var24 = var25[0];
         var21 = var21 + " and Salaries.salActivite='" + var24 + "'";
      }

      if (var12.contains(":")) {
         var25 = var12.split(":");
         var24 = var25[0];
         var21 = var21 + " and Salaries.salConvention='" + var24 + "'";
      }

      if (var13.contains(":")) {
         var25 = var13.split(":");
         var24 = var25[0];
         var21 = var21 + " and Salaries.salNivEmploi='" + var24 + "'";
      }

      if (var14.contains(":")) {
         var25 = var14.split(":");
         var24 = var25[0];
         var21 = var21 + " and Salaries.salClassement='" + var24 + "'";
      }

      if (var15.contains(":")) {
         var25 = var15.split(":");
         var24 = var25[0];
         var21 = var21 + " and Salaries.salGrille='" + var24 + "'";
      }

      if (var16.contains(":")) {
         var25 = var16.split(":");
         var24 = var25[0];
         var21 = var21 + " and Salaries.salCentresImpots='" + var24 + "'";
      }

      Query var26 = var18.createQuery("from SalariesConges where " + var21);
      List var20 = var26.list();
      if (var19) {
         this.utilInitHibernate.closeSession();
      }

      return var20;
   }
}
