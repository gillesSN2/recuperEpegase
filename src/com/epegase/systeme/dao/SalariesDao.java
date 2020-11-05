package com.epegase.systeme.dao;

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
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class SalariesDao implements Serializable {
   private Salaries salaries;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public SalariesDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public Salaries insert(Salaries var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "SuiviPaye");
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

   public Salaries insert(Salaries var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public Salaries modif(Salaries var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "SuiviPaye");
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

   public Salaries modif(Salaries var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(Salaries var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "SuiviPaye");
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

   public void delete(Salaries var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List chargerlesSalariesActif(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "SuiviPaye");
         var2 = true;
      }

      new ArrayList();
      String var4 = "from Salaries where salEtat<=1 and (salNature='01I' or salNature='02I' or salNature='03I' or salNature='01D' or salNature='02D' or salNature='03D' or salNature='05' or salNature='13' or salNature='14' or salNature='15') order by salMatricule asc";
      Query var5 = var1.createQuery(var4);
      List var3 = var5.list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerlesSalariesTous(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "SuiviPaye");
         var2 = true;
      }

      new ArrayList();
      String var4 = "from Salaries where (salNature='01I' or salNature='02I' or salNature='03I' or salNature='01D' or salNature='02D' or salNature='03D' or salNature='05' or salNature='13' or salNature='14' or salNature='15') order by salMatricule asc";
      Query var5 = var1.createQuery(var4);
      List var3 = var5.list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerlesSalariesAll(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "SuiviPaye");
         var2 = true;
      }

      new ArrayList();
      String var4 = "from Salaries where ((salMatricule is null or salMatricule = '') or (salNature is null or salNature = '')) order by salMatricule asc";
      Query var5 = var1.createQuery(var4);
      List var3 = var5.list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerlesSalariesTous(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "SuiviPaye");
         var3 = true;
      }

      new ArrayList();
      String var5 = "";
      if (var1 != null && !var1.isEmpty() && var1.equals("*")) {
         var5 = "from Salaries order by salMatricule asc";
      } else if (var1 != null && !var1.isEmpty() && var1.equals("***")) {
         var5 = "from Salaries order by salMatricule asc";
      } else if (var1 != null && !var1.isEmpty() && var1.contains("*") && var1.length() >= 2) {
         String var6 = var1.substring(1);
         var5 = "from Salaries where ((salMatricule LIKE '%" + var6 + "') or (salNom LIKE '%" + var6 + "%') or (salPrenom LIKE '%" + var6 + "%')) order by salMatricule asc";
      } else {
         var5 = "from Salaries where ((salMatricule LIKE '%" + var1 + "') or (salNom LIKE '%" + var1 + "%')) order by salMatricule asc";
      }

      Query var7 = var2.createQuery(var5);
      List var4 = var7.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerlesSalariesActif(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "SuiviPaye");
         var3 = true;
      }

      new ArrayList();
      String var5 = "";
      if (var1 != null && !var1.isEmpty() && var1.equals("*")) {
         var5 = "from Salaries where salEtat<=1 order by salMatricule asc";
      } else if (var1 != null && !var1.isEmpty() && var1.equals("***")) {
         var5 = "from Salaries order by salMatricule asc";
      } else if (var1 != null && !var1.isEmpty() && var1.contains("*") && var1.length() >= 2) {
         String var6 = var1.substring(1);
         var5 = "from Salaries where salEtat<=1 and ((salMatricule LIKE '%" + var6 + "') or (salNom LIKE '%" + var6 + "%') or (salPrenom LIKE '%" + var6 + "%')) order by salMatricule asc";
      } else {
         var5 = "from Salaries where salEtat<=1 and ((salMatricule LIKE '%" + var1 + "') or (salNom LIKE '%" + var1 + "%')) order by salMatricule asc";
      }

      Query var7 = var2.createQuery(var5);
      List var4 = var7.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerlesSalaries(String var1, int var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "SuiviPaye");
         var4 = true;
      }

      new ArrayList();
      String var6 = "";
      if (var1 != null && !var1.isEmpty() && var1.equals("*")) {
         var6 = "from Salaries where salEtat<=1 order by salMatricule asc";
      } else if (var1 != null && !var1.isEmpty() && var1.equals("***")) {
         var6 = "from Salaries order by salMatricule asc";
      } else if (var1 != null && !var1.isEmpty() && var1.contains("*") && var1.length() >= 2) {
         String var7 = var1.substring(1);
         var6 = "from Salaries where salEtat<=1 and ((salMatricule LIKE '%" + var7 + "') or (salNom LIKE '%" + var7 + "%') or (salPrenom LIKE '%" + var7 + "%')) order by salMatricule asc";
      } else {
         var6 = "from Salaries where salEtat<=1 and ((salMatricule LIKE '%" + var1 + "') or (salNom LIKE '%" + var1 + "%')) order by salMatricule asc";
      }

      if (var2 != 100) {
         if (var2 != 0 && var2 != 1) {
            if (var2 == 2) {
               var6 = var6 + " and salEtat=2";
            } else if (var2 == 3) {
               var6 = var6 + " and salEtat=3";
            } else if (var2 == 4) {
               var6 = var6 + " and salEtat=4";
            } else if (var2 == 5) {
               var6 = var6 + " and salEtat=5";
            } else if (var2 == 6) {
               var6 = var6 + " and salEtat=6";
            } else if (var2 == 7) {
               var6 = var6 + " and salEtat=7";
            } else if (var2 == 8) {
               var6 = var6 + " and salEtat=8";
            } else if (var2 == 9) {
               var6 = var6 + " and salEtat=9";
            }
         } else {
            var6 = var6 + " and salEtat<=1";
         }
      }

      Query var8 = var3.createQuery(var6);
      List var5 = var8.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public Salaries chargerlesSalaries(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "SuiviPaye");
         var3 = true;
      }

      new ArrayList();
      String var5 = "";
      if (var1 != null && !var1.isEmpty() && var1.equals("*")) {
         var5 = "from Salaries where order by salMatricule asc";
      } else if (var1 != null && !var1.isEmpty() && var1.equals("***")) {
         var5 = "from Salaries order by salMatricule asc";
      } else if (var1 != null && !var1.isEmpty() && var1.contains("*") && var1.length() >= 2) {
         String var6 = var1.substring(1);
         var5 = "from Salaries where ((salMatricule LIKE '%" + var6 + "') or (salNom LIKE '%" + var6 + "%') or (salPrenom LIKE '%" + var6 + "%')) order by salMatricule asc";
      } else {
         var5 = "from Salaries where ((salMatricule LIKE '%" + var1 + "') or (salNom LIKE '%" + var1 + "%')) order by salMatricule asc";
      }

      Query var7 = var2.createQuery(var5).setMaxResults(1);
      List var4 = var7.list();
      this.salaries = new Salaries();
      if (var4.size() != 0) {
         this.salaries = (Salaries)var4.get(0);
      } else {
         this.salaries = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return this.salaries;
   }

   public List chargerlesSalariesActif(long var1, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "SuiviPaye");
         var5 = true;
      }

      new ArrayList();
      String var7 = "";
      if (var1 != 0L) {
         var7 = " and salIdGroupe=" + var1;
      }

      String var8 = "";
      if (var3 != null && !var3.isEmpty() && var3.equals("*")) {
         var8 = "from Salaries where salEtat<=1 " + var7 + " order by salMatricule asc";
      } else if (var3 != null && !var3.isEmpty() && var3.equals("***")) {
         if (var1 != 0L) {
            var8 = "from Salaries where salIdGroupe=" + var1 + " order by salMatricule asc";
         } else {
            var8 = "from Salaries order by salMatricule asc";
         }
      } else if (var3 != null && !var3.isEmpty() && var3.contains("*") && var3.length() >= 2) {
         String var9 = var3.substring(1);
         var8 = "from Salaries where salEtat<=1 and (salMatricule LIKE '%" + var9 + "') or (salNom LIKE '%" + var9 + "%') or (salPrenom LIKE '%" + var9 + "%')  " + var7 + " order by salMatricule asc";
      } else {
         var8 = "from Salaries where salEtat<=1 and (salMatricule LIKE '%" + var3 + "') or (salNom LIKE '%" + var3 + "%')  " + var7 + " order by salMatricule asc";
      }

      Query var10 = var4.createQuery(var8);
      List var6 = var10.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerlesSalariesActifItem(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "SuiviPaye");
         var3 = true;
      }

      ArrayList var4 = new ArrayList();
      new ArrayList();
      String var6 = "";
      if (var1 != null && !var1.isEmpty()) {
         if (var1.equals("*")) {
            var6 = "from Salaries where salEtat<=1 order by salMatricule asc";
         } else if (var1.contains("*") && var1.length() >= 2) {
            String var7 = var1.substring(1);
            var6 = "from Salaries where salEtat<=1 and (salMatricule LIKE '%" + var7 + "') or (salNom LIKE '%" + var7 + "%') or (salPrenom LIKE '%" + var7 + "%') order by salMatricule asc";
         } else {
            var6 = "from Salaries where salEtat<=1 and (salMatricule LIKE '%" + var1 + "') or (salNom LIKE '%" + var1 + "%') order by salMatricule asc";
         }
      } else {
         var6 = "from Salaries where salEtat<=1 order by salMatricule asc";
      }

      Query var9 = var2.createQuery(var6);
      List var5 = var9.list();
      if (var5.size() != 0) {
         for(int var8 = 0; var8 < var5.size(); ++var8) {
            var4.add(new SelectItem(((Salaries)var5.get(var8)).getSalId(), ((Salaries)var5.get(var8)).getSalMatricule() + ":" + ((Salaries)var5.get(var8)).getPatronyme()));
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerlesSalariesbyFeuille(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "SuiviPaye");
         var4 = true;
      }

      new ArrayList();
      Query var6 = null;
      if (var2 != null && !var2.isEmpty() && !var2.equals("*****")) {
         String var7 = "";
         if (var2.contains(":")) {
            String[] var8 = var2.split(":");
            var7 = var8[0];
         } else {
            var7 = var2;
         }

         var6 = var3.createQuery("from Salaries where salFeuille=:feu and salEtat<=1 and salService=:serv order by salMatricule desc").setString("feu", var1).setString("serv", var7);
      } else if (var2 != null && !var2.isEmpty() && var2.equals("*****")) {
         var6 = var3.createQuery("from Salaries where salFeuille=:feu and salEtat<=1 and (salService is null or salService='') order by salMatricule desc").setString("feu", var1);
      } else {
         var6 = var3.createQuery("from Salaries where salFeuille=:feu and salEtat<=1 order by salMatricule asc").setString("feu", var1);
      }

      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerlesSalariesByProfessionItem(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "SuiviPaye");
         var3 = true;
      }

      ArrayList var4 = new ArrayList();
      new ArrayList();
      String var6 = "";
      if (var1 != null && !var1.isEmpty()) {
         var6 = "from Salaries where salEtat<=1 and (salProfession LIKE '%" + var1 + "%') order by salMatricule asc";
      } else {
         var6 = "from Salaries where salEtat<=1 order by salMatricule asc";
      }

      Query var7 = var2.createQuery(var6);
      List var5 = var7.list();
      if (var5.size() != 0) {
         for(int var8 = 0; var8 < var5.size(); ++var8) {
            var4.add(new SelectItem(((Salaries)var5.get(var8)).getSalMatricule(), ((Salaries)var5.get(var8)).getSalMatricule() + ":" + ((Salaries)var5.get(var8)).getPatronyme()));
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public Salaries chercherIdSalaries(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "SuiviPaye");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from Salaries where salId=:id").setLong("id", var1).setMaxResults(1);
      List var5 = var6.list();
      new Salaries();
      Salaries var7;
      if (var5.size() != 0) {
         var7 = (Salaries)var5.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public Salaries chercherIdSalaries(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "SuiviPaye");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from Salaries where salMatricule=:id").setString("id", var1).setMaxResults(1);
      List var4 = var5.list();
      new Salaries();
      Salaries var6;
      if (var4.size() != 0) {
         var6 = (Salaries)var4.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public Salaries chercherNomPrenomSalaries(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "SuiviPaye");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from Salaries where salNom=:nm and salPrenom=:pnm").setString("nm", var1).setString("pnm", var2).setMaxResults(1);
      List var5 = var6.list();
      new Salaries();
      Salaries var7;
      if (var5.size() != 0) {
         var7 = (Salaries)var5.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List rechercheSalaries(boolean var1, int var2, String var3, int var4, String var5, String var6, String var7, String var8, String var9, String var10, String var11, String var12, String var13, String var14, String var15, String var16, String var17, Date var18, Date var19, Session var20) throws HibernateException, NamingException {
      boolean var21 = false;
      if (var20 == null) {
         var20 = this.utilInitHibernate.getOpenSession(this.maBase, "SuiviPaye");
         var21 = true;
      }

      new ArrayList();
      Criteria var23 = var20.createCriteria(Salaries.class);
      String var24;
      if (var5 != null && !var5.isEmpty()) {
         var24 = "%" + var5;
         var23 = var23.add(Restrictions.like("salMatricule", var24));
      }

      if (var6 != null && !var6.isEmpty()) {
         var24 = "%" + var6 + "%";
         var23 = var23.add(Restrictions.like("salNom", var24));
      }

      String[] var28;
      if (var4 == 20) {
         var23 = var23.add(Restrictions.or(Restrictions.isNull("salNature"), Restrictions.eq("salNature", "")));
      } else if (var4 == 21) {
         var23 = var23.add(Restrictions.or(Restrictions.isNull("salMatricule"), Restrictions.eq("salMatricule", "")));
      } else {
         if (var4 != 100 && var4 != 90) {
            var23 = var23.add(Restrictions.eq("salEtat", var4));
         }

         if (var8 != null && !var8.isEmpty() && !var8.equals("100")) {
            var23 = var23.add(Restrictions.eq("salNature", var8));
         } else if (var3.contains(",")) {
            var28 = var3.split(",");
            int var25 = var28.length;
            String[] var26 = new String[var25];

            for(int var27 = 0; var27 < var25; ++var27) {
               var26[var27] = new String(var28[var27].replace("'", ""));
            }

            var23 = var23.add(Restrictions.in("salNature", var26));
         } else {
            var23 = var23.add(Restrictions.eq("salNature", var8));
         }
      }

      if (var7 != null && !var7.isEmpty() && !var7.equals("100")) {
         var23 = var23.add(Restrictions.eq("salFeuille", var7));
      }

      String var29;
      if (var9 != null && !var9.isEmpty() && var9.contains(":")) {
         var28 = var9.split(":");
         var29 = var28[0];
         var23 = var23.add(Restrictions.eq("salSite", var29));
      }

      if (var10 != null && !var10.isEmpty() && var10.contains(":")) {
         var28 = var10.split(":");
         var29 = var28[0];
         var23 = var23.add(Restrictions.eq("salDepartement", var29));
      }

      if (var11 != null && !var11.isEmpty() && var11.contains(":")) {
         var28 = var11.split(":");
         var29 = var28[0];
         var23 = var23.add(Restrictions.eq("salService", var29));
      }

      if (var12 != null && !var12.isEmpty() && var12.contains(":")) {
         var28 = var12.split(":");
         var29 = "";
         if (var1) {
            var29 = "%" + var28[0] + "%";
            var23 = var23.add(Restrictions.like("salActivite", var29));
         } else {
            var29 = var28[0];
            var23 = var23.add(Restrictions.eq("salActivite", var29));
         }
      }

      if (var13 != null && !var13.isEmpty() && var13.contains(":")) {
         var28 = var13.split(":");
         var29 = var28[0];
         var23 = var23.add(Restrictions.eq("salConvention", var29));
      }

      if (var14 != null && !var14.isEmpty() && var14.contains(":")) {
         var28 = var14.split(":");
         var29 = var28[0];
         var23 = var23.add(Restrictions.eq("salNivEmploi", var29));
      }

      if (var15 != null && !var15.isEmpty() && var15.contains(":")) {
         var28 = var15.split(":");
         var29 = var28[0];
         var23 = var23.add(Restrictions.eq("salClassement", var29));
      }

      if (var16 != null && !var16.isEmpty() && var16.contains(":")) {
         var28 = var16.split(":");
         var29 = var28[0];
         var23 = var23.add(Restrictions.eq("salGrille", var29));
      }

      if (var17 != null && !var17.isEmpty() && var17.contains(":")) {
         var28 = var17.split(":");
         var29 = var28[0];
         var23 = var23.add(Restrictions.eq("salCentresImpots", var29));
      }

      if (var18 != null && var19 != null) {
         var23 = var23.add(Restrictions.isNotNull("salDateEntree"));
         var23 = var23.add(Restrictions.between("salDateEntree", var18, var19));
      }

      if (var2 == 0) {
         var23 = var23.addOrder(Order.asc("salMatricule"));
      } else if (var2 == 1) {
         var23 = var23.addOrder(Order.asc("salNom"));
         var23 = var23.addOrder(Order.asc("salPrenom"));
      }

      List var22 = var23.list();
      if (var21) {
         this.utilInitHibernate.closeSession();
      }

      return var22;
   }

   public List rechercheSalaries(boolean var1, int var2, String var3, int var4, String var5, String var6, String var7, String var8, String var9, String var10, String var11, String var12, String var13, String var14, String var15, String var16, String var17, long var18, Date var20, Date var21, Session var22) throws HibernateException, NamingException {
      boolean var23 = false;
      if (var22 == null) {
         var22 = this.utilInitHibernate.getOpenSession(this.maBase, "SuiviPaye");
         var23 = true;
      }

      new ArrayList();
      Criteria var25 = var22.createCriteria(Salaries.class);
      String var26;
      if (var5 != null && !var5.isEmpty()) {
         var26 = "%" + var5;
         var25 = var25.add(Restrictions.like("salMatricule", var26));
      }

      if (var6 != null && !var6.isEmpty()) {
         var26 = "%" + var6 + "%";
         var25 = var25.add(Restrictions.like("salNom", var26));
      }

      if (var4 != 100 && var4 != 90) {
         var25 = var25.add(Restrictions.eq("salEtat", var4));
      }

      if (var7 != null && !var7.isEmpty() && !var7.equals("100")) {
         var25 = var25.add(Restrictions.eq("salFeuille", var7));
      }

      String[] var30;
      if (var8 != null && !var8.isEmpty() && !var8.equals("100")) {
         var25 = var25.add(Restrictions.eq("salNature", var8));
      } else if (var3.contains(",")) {
         var30 = var3.split(",");
         int var27 = var30.length;
         String[] var28 = new String[var27];

         for(int var29 = 0; var29 < var27; ++var29) {
            var28[var29] = new String(var30[var29].replace("'", ""));
         }

         var25 = var25.add(Restrictions.in("salNature", var28));
      } else {
         var25 = var25.add(Restrictions.eq("salNature", var8));
      }

      String var31;
      if (var9 != null && !var9.isEmpty() && var9.contains(":")) {
         var30 = var9.split(":");
         var31 = var30[0];
         var25 = var25.add(Restrictions.eq("salSite", var31));
      }

      if (var10 != null && !var10.isEmpty() && var10.contains(":")) {
         var30 = var10.split(":");
         var31 = var30[0];
         var25 = var25.add(Restrictions.eq("salDepartement", var31));
      }

      if (var11 != null && !var11.isEmpty() && var11.contains(":")) {
         var30 = var11.split(":");
         var31 = var30[0];
         var25 = var25.add(Restrictions.eq("salService", var31));
      }

      if (var12 != null && !var12.isEmpty() && var12.contains(":")) {
         var30 = var12.split(":");
         var31 = "";
         if (var1) {
            var31 = "%" + var30[0] + "%";
         } else {
            var31 = var30[0];
         }

         var25 = var25.add(Restrictions.like("salActivite", var31));
      }

      if (var13 != null && !var13.isEmpty() && var13.contains(":")) {
         var30 = var13.split(":");
         var31 = var30[0];
         var25 = var25.add(Restrictions.eq("salConvention", var31));
      }

      if (var14 != null && !var14.isEmpty() && var14.contains(":")) {
         var30 = var14.split(":");
         var31 = var30[0];
         var25 = var25.add(Restrictions.eq("salNivEmploi", var31));
      }

      if (var15 != null && !var15.isEmpty() && var15.contains(":")) {
         var30 = var15.split(":");
         var31 = var30[0];
         var25 = var25.add(Restrictions.eq("salClassement", var31));
      }

      if (var16 != null && !var16.isEmpty() && var16.contains(":")) {
         var30 = var16.split(":");
         var31 = var30[0];
         var25 = var25.add(Restrictions.eq("salGrille", var31));
      }

      if (var17 != null && !var17.isEmpty() && var17.contains(":")) {
         var30 = var17.split(":");
         var31 = var30[0];
         var25 = var25.add(Restrictions.eq("salCentresImpots", var31));
      }

      if (var18 > 0L) {
         var25 = var25.add(Restrictions.eq("salIdTiers", var18));
      } else if (var18 < 0L) {
         var25 = var25.add(Restrictions.eq("salIdTiers", 0L));
      }

      if (var20 != null && var21 != null) {
         var25 = var25.add(Restrictions.isNotNull("salDateEntree"));
         var25 = var25.add(Restrictions.between("salDateEntree", var20, var21));
      }

      if (var2 == 0) {
         var25 = var25.addOrder(Order.asc("salMatricule"));
      } else if (var2 == 1) {
         var25 = var25.addOrder(Order.asc("salNom"));
         var25 = var25.addOrder(Order.asc("salPrenom"));
      }

      List var24 = var25.list();
      if (var23) {
         this.utilInitHibernate.closeSession();
      }

      return var24;
   }

   public List rechercheRoster(String var1, int var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10, String var11, String var12, String var13, String var14, String var15, Date var16, Date var17, Session var18) throws HibernateException, NamingException {
      boolean var19 = false;
      if (var18 == null) {
         var18 = this.utilInitHibernate.getOpenSession(this.maBase, "SuiviPaye");
         var19 = true;
      }

      new ArrayList();
      Criteria var21 = var18.createCriteria(Salaries.class);
      String var22;
      if (var3 != null && !var3.isEmpty()) {
         var22 = "%" + var3;
         var21 = var21.add(Restrictions.like("salMatricule", var22));
      }

      if (var4 != null && !var4.isEmpty()) {
         var22 = "%" + var4 + "%";
         var21 = var21.add(Restrictions.like("salNom", var22));
      }

      if (var2 != 100) {
         if (var2 == 90) {
            var21 = var21.add(Restrictions.or(Restrictions.eq("salEtat", 0), Restrictions.eq("salEtat", 1)));
         } else {
            var21 = var21.add(Restrictions.eq("salEtat", var2));
         }
      }

      if (!var5.equals("100")) {
         var21 = var21.add(Restrictions.eq("salNompays", var5));
      }

      String[] var26;
      if (var6 != null && !var6.isEmpty() && !var6.equals("100")) {
         var21 = var21.add(Restrictions.eq("salNature", var6));
      } else if (var1.contains(",")) {
         var26 = var1.split(",");
         int var23 = var26.length;
         String[] var24 = new String[var23];

         for(int var25 = 0; var25 < var23; ++var25) {
            var24[var25] = new String(var26[var25]);
         }

         var21 = var21.add(Restrictions.in("salNature", var24));
      } else {
         var21 = var21.add(Restrictions.eq("salNature", var6));
      }

      String var27;
      if (var9.contains(":")) {
         var26 = var9.split(":");
         var27 = var26[0];
         var21 = var21.add(Restrictions.eq("salService", var27));
      }

      if (var10.equals("1")) {
         var21 = var21.add(Restrictions.eq("salDomAct1", true));
      } else if (var10.equals("2")) {
         var21 = var21.add(Restrictions.eq("salDomAct2", true));
      } else if (var10.equals("3")) {
         var21 = var21.add(Restrictions.eq("salDomAct3", true));
      } else if (var10.equals("4")) {
         var21 = var21.add(Restrictions.eq("salDomAct4", true));
      } else if (var10.equals("5")) {
         var21 = var21.add(Restrictions.eq("salDomAct5", true));
      } else if (var10.equals("6")) {
         var21 = var21.add(Restrictions.eq("salDomAct6", true));
      } else if (var10.equals("51")) {
         var21 = var21.add(Restrictions.eq("salCompetence1", true));
      } else if (var10.equals("52")) {
         var21 = var21.add(Restrictions.eq("salCompetence2", true));
      } else if (var10.equals("53")) {
         var21 = var21.add(Restrictions.eq("salCompetence3", true));
      } else if (var10.equals("54")) {
         var21 = var21.add(Restrictions.eq("salCompetence4", true));
      } else if (var10.equals("55")) {
         var21 = var21.add(Restrictions.eq("salCompetence5", true));
      } else if (var10.equals("56")) {
         var21 = var21.add(Restrictions.eq("salCompetence6", true));
      } else if (var10.equals("57")) {
         var21 = var21.add(Restrictions.eq("salCompetence7", true));
      } else if (var10.equals("58")) {
         var21 = var21.add(Restrictions.eq("salCompetence8", true));
      } else if (var10.equals("59")) {
         var21 = var21.add(Restrictions.eq("salCompetence9", true));
      } else if (var10.equals("60")) {
         var21 = var21.add(Restrictions.eq("salCompetence10", true));
      } else if (var10.equals("61")) {
         var21 = var21.add(Restrictions.eq("salCompetence11", true));
      }

      if (var7.contains(":")) {
         var26 = var7.split(":");
         var27 = var26[0];
         var21 = var21.add(Restrictions.eq("salSite", var27));
      }

      if (var8.contains(":")) {
         var26 = var8.split(":");
         var27 = var26[0];
         var21 = var21.add(Restrictions.eq("salDepartement", var27));
      }

      if (var11.contains(":")) {
         var26 = var11.split(":");
         var27 = var26[0];
         var21 = var21.add(Restrictions.eq("salConvention", var27));
      }

      if (var12.contains(":")) {
         var26 = var12.split(":");
         var27 = var26[0];
         var21 = var21.add(Restrictions.eq("salNivEmploi", var27));
      }

      if (var13.contains(":")) {
         var26 = var13.split(":");
         var27 = var26[0];
         var21 = var21.add(Restrictions.eq("salClassement", var27));
      }

      if (var14.contains(":")) {
         var26 = var14.split(":");
         var27 = var26[0];
         var21 = var21.add(Restrictions.eq("salGrille", var27));
      }

      if (var15.contains(":")) {
         var26 = var15.split(":");
         var27 = var26[0];
         var21 = var21.add(Restrictions.eq("salCentresImpots", var27));
      }

      if (var16 != null && var17 != null) {
         var21 = var21.add(Restrictions.isNotNull("salDateEntree"));
         var21 = var21.add(Restrictions.between("salDateEntree", var16, var17));
      }

      List var20 = var21.list();
      if (var19) {
         this.utilInitHibernate.closeSession();
      }

      return var20;
   }

   public List listePaysUtil(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "SuiviPaye");
         var2 = true;
      }

      ArrayList var3 = new ArrayList();
      new ArrayList();
      Query var5 = var1.createQuery("from Salaries group by salNompays");
      List var4 = var5.list();
      if (var4.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var3.add(new SelectItem(((Salaries)var4.get(var6)).getSalNompays()));
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public boolean verifUnicite(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "SuiviPaye");
         var3 = true;
      }

      boolean var4 = false;
      new ArrayList();
      Query var6 = var2.createQuery("from Salaries where salMatricule=:mat").setString("mat", var1).setMaxResults(1);
      List var5 = var6.list();
      if (var5.size() != 0) {
         var4 = true;
      } else {
         var4 = false;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public Salaries pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var4 = true;
      }

      Query var5 = var3.createQuery("from Salaries where salId =:num").setLong("num", var1).setMaxResults(1);
      List var6 = var5.list();
      Salaries var7 = null;
      if (var6.size() != 0) {
         var7 = (Salaries)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List listeSalaries(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      Object var4 = new ArrayList();
      if (var1 != null && !var1.isEmpty()) {
         var4 = var2.createQuery(var1).list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var4;
   }

   public List chargerlesSalariesByRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from Salaries where " + var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerlesElementsByJournaliers(Date var1, int var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var5 = true;
      }

      new ArrayList();
      Query var7 = null;
      if (var2 == 0) {
         var7 = var4.createQuery("from Salaries where salFeuille=:feu and salDateEntree >=:d1 and (salDateSortie is null or (salDateSortie is not null and salDateSortie >=:d1 )) order by salMatricule asc").setString("feu", var3).setDate("d1", var1);
      } else {
         var7 = var4.createQuery("from Salaries where salFeuille=:feu salDateEntree >=:d1 and (salDateSortie is null or (salDateSortie is not null and salDateSortie >=:d1 )) order by salNom,Salaries.salPrenom asc").setString("feu", var3).setDate("d1", var1);
      }

      List var6 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public int rechercheDernierByNature(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "SuiviPaye");
         var3 = true;
      }

      boolean var4 = false;
      new ArrayList();
      Query var6 = var2.createQuery("from Salaries where salNature=:nat order by salMatricule desc").setString("nat", var1);
      List var5 = var6.list();
      int var7;
      if (var5.size() != 0) {
         var7 = Integer.parseInt(((Salaries)var5.get(0)).getSalMatricule()) + 1;
      } else {
         var7 = 1;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }
}
