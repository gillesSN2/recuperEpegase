package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Salaries;
import com.epegase.systeme.classe.SalariesContrats;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SalariesContratsDao implements Serializable {
   private SalariesContrats salariesContrats;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public SalariesContratsDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public SalariesContrats insert(SalariesContrats var1) throws HibernateException, NamingException {
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

   public SalariesContrats insert(SalariesContrats var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public SalariesContrats modif(SalariesContrats var1) throws HibernateException, NamingException {
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

   public SalariesContrats modif(SalariesContrats var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(SalariesContrats var1) throws HibernateException, NamingException {
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

   public void delete(SalariesContrats var1, Session var2) {
      var2.delete(var1);
   }

   public List chargerlesContrats(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var2 = true;
      }

      new ArrayList();
      Query var4 = var1.createQuery("from SalariesContrats order by salconDateDebut desc");
      List var3 = var4.list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerlesContrats(Salaries var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from SalariesContrats where Salaries=:salarie order by salconDateDebut desc").setParameter("salarie", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerlesContratsSalaries(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      new ArrayList();
      String var5 = "";
      var5 = "salconEtat<=1";
      if (!var1.equals("*")) {
         var5 = var5 + " and (Salaries.salNom like '" + var1 + "%' or Salaries.salMatricule like '%" + var1 + "%')";
      }

      Query var6 = var2.createQuery("from SalariesContrats where " + var5 + " order by salconDateDebut desc");
      List var4 = var6.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerlesMetiers(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var2 = true;
      }

      new ArrayList();
      Query var4 = var1.createQuery("from SalariesContrats where (salconFonction<>'' and salconFonction is not null) group by salconFonction order by salconFonction");
      List var3 = var4.list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public SalariesContrats chargerlesContratsActif(Salaries var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      this.salariesContrats = new SalariesContrats();
      new ArrayList();
      Query var5 = var2.createQuery("from SalariesContrats where Salaries=:salarie and (salconEtat<=1 or salconEtat=9) order by salconDateDebut desc").setParameter("salarie", var1).setMaxResults(1);
      List var4 = var5.list();
      if (var4.size() != 0) {
         this.salariesContrats = (SalariesContrats)var4.get(0);
      } else {
         this.salariesContrats = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return this.salariesContrats;
   }

   public SalariesContrats chargerlesContratsActifByFeuille(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      this.salariesContrats = new SalariesContrats();
      new ArrayList();
      Query var5 = var2.createQuery("from SalariesContrats where salconFeuille=:num and (salconEtat<=1 or salconEtat=9) order by salconDateDebut desc").setString("num", var1).setMaxResults(1);
      List var4 = var5.list();
      if (var4.size() != 0) {
         this.salariesContrats = (SalariesContrats)var4.get(0);
      } else {
         this.salariesContrats = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return this.salariesContrats;
   }

   public SalariesContrats chargerlesContratsActif(Salaries var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var4 = true;
      }

      this.salariesContrats = new SalariesContrats();
      new ArrayList();
      Query var6 = null;
      if (var2 != null && !var2.isEmpty()) {
         var6 = var3.createQuery("from SalariesContrats where Salaries=:salarie and salconNum=:crt order by salconDateDebut desc").setParameter("salarie", var1).setString("crt", var2).setMaxResults(1);
      } else {
         var6 = var3.createQuery("from SalariesContrats where Salaries=:salarie order by salconDateDebut desc").setParameter("salarie", var1).setMaxResults(1);
      }

      List var5 = var6.list();
      if (var5.size() != 0) {
         this.salariesContrats = (SalariesContrats)var5.get(0);
      } else {
         this.salariesContrats = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.salariesContrats;
   }

   public SalariesContrats chargerTousLesContrats(Salaries var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      this.salariesContrats = new SalariesContrats();
      new ArrayList();
      Query var5 = var2.createQuery("from SalariesContrats where Salaries=:salarie order by salconDateDebut desc").setParameter("salarie", var1).setMaxResults(1);
      List var4 = var5.list();
      if (var4.size() != 0) {
         this.salariesContrats = (SalariesContrats)var4.get(0);
      } else {
         this.salariesContrats = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return this.salariesContrats;
   }

   public List chargerlesContratsBySalaries(Salaries var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      this.salariesContrats = new SalariesContrats();
      new ArrayList();
      Query var5 = var2.createQuery("from SalariesContrats where Salaries=:salarie and salconEtat<=1 order by salconDateDebut desc").setParameter("salarie", var1);
      List var4 = var5.list();
      ArrayList var6 = new ArrayList();
      if (var4.size() != 0) {
         for(int var7 = 0; var7 < var4.size(); ++var7) {
            var6.add(new SelectItem(((SalariesContrats)var4.get(var7)).getSalconId(), ((SalariesContrats)var4.get(var7)).getSalconNum()));
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List listelesContratsActif(Salaries var1, Date var2, Date var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var5 = true;
      }

      this.salariesContrats = new SalariesContrats();
      new ArrayList();
      ArrayList var7 = new ArrayList();
      Query var8 = var4.createQuery("from SalariesContrats where Salaries=:salarie order by salconDateDebut desc").setParameter("salarie", var1);
      List var6 = var8.list();
      if (var6.size() != 0) {
         for(int var9 = 0; var9 < var6.size(); ++var9) {
            this.salariesContrats = (SalariesContrats)var6.get(var9);
            if (this.salariesContrats.getSalconDateDebut() != null && (var2.compareTo(this.salariesContrats.getSalconDateDebut()) > 0 || this.salariesContrats.getSalconDateDebut().getMonth() == var2.getMonth() && this.salariesContrats.getSalconDateDebut().getYear() == var2.getYear())) {
               if (this.salariesContrats.getSalconDateFin() == null) {
                  var7.add(this.salariesContrats);
               } else if (var3.compareTo(this.salariesContrats.getSalconDateFin()) < 0 || this.salariesContrats.getSalconDateFin().getMonth() == var3.getMonth() && this.salariesContrats.getSalconDateFin().getYear() == var3.getYear()) {
                  var7.add(this.salariesContrats);
               }
            }
         }
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List listelesContratsActif(String var1, int var2, Date var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var6 = true;
      }

      this.salariesContrats = new SalariesContrats();
      new ArrayList();
      ArrayList var8 = new ArrayList();
      Query var9 = null;
      if (var2 == 0) {
         var9 = var5.createQuery("from SalariesContrats where salconFeuille=:feu order by Salaries.salMatricule asc").setString("feu", var1);
      } else {
         var9 = var5.createQuery("from SalariesContrats where salconFeuille=:feu order by Salaries.salNom,Salaries.salPrenom asc").setString("feu", var1);
      }

      List var7 = var9.list();
      if (var7.size() != 0) {
         for(int var10 = 0; var10 < var7.size(); ++var10) {
            this.salariesContrats = (SalariesContrats)var7.get(var10);
            if (this.salariesContrats.getSalconDateDebut() != null && (var3.compareTo(this.salariesContrats.getSalconDateDebut()) > 0 || this.salariesContrats.getSalconDateDebut().getMonth() == var3.getMonth() && this.salariesContrats.getSalconDateDebut().getYear() == var3.getYear())) {
               if (this.salariesContrats.getSalconDateFin() == null) {
                  var8.add(this.salariesContrats);
               } else if (var4.compareTo(this.salariesContrats.getSalconDateFin()) < 0 || this.salariesContrats.getSalconDateFin().getMonth() == var4.getMonth() && this.salariesContrats.getSalconDateFin().getYear() == var4.getYear()) {
                  var8.add(this.salariesContrats);
               }
            }
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List listelesContratsActif(int var1, int var2, Date var3, Date var4, String var5, String var6, String var7, String var8, String var9, String var10, String var11, String var12, long var13, Session var15) throws HibernateException, NamingException {
      boolean var16 = false;
      if (var15 == null) {
         var15 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var16 = true;
      }

      this.salariesContrats = new SalariesContrats();
      new ArrayList();
      ArrayList var18 = new ArrayList();
      Query var19 = null;
      String var20 = "";
      String var21;
      String[] var22;
      if (var7 != null && !var7.isEmpty()) {
         if (var7.equals("*****")) {
            var20 = var20 + " and (salconActivite is null or salconActivite='') ";
         } else {
            var21 = "";
            if (var7.contains(":")) {
               var22 = var7.split(":");
               var21 = var22[0];
            } else {
               var21 = var7;
            }

            var20 = var20 + " and salconActivite = '" + var21 + "'";
         }
      }

      if (var8 != null && !var8.isEmpty()) {
         if (var8.equals("*****")) {
            var20 = var20 + " and (salconService is null or salconService='') ";
         } else {
            var21 = "";
            if (var8.contains(":")) {
               var22 = var8.split(":");
               var21 = var22[0];
            } else {
               var21 = var8;
            }

            var20 = var20 + " and salconService = '" + var21 + "'";
         }
      }

      if (var9 != null && !var9.isEmpty()) {
         if (var9.equals("*****")) {
            var20 = var20 + " and (salconDepartement is null or salconDepartement='') ";
         } else {
            var21 = "";
            if (var9.contains(":")) {
               var22 = var9.split(":");
               var21 = var22[0];
            } else {
               var21 = var8;
            }

            var20 = var20 + " and salconDepartement = '" + var21 + "'";
         }
      }

      if (var10 != null && !var10.isEmpty()) {
         if (var10.equals("*****")) {
            var20 = var20 + " and (salconLocalisation is null or salconLocalisation='') ";
         } else {
            var20 = var20 + " and salconLocalisation = '" + var10 + "'";
         }
      }

      if (var11 != null && !var11.isEmpty()) {
         if (var11.equals("*****")) {
            var20 = var20 + " and (salconProjet is null or salconProjet='') ";
         } else {
            var21 = "";
            if (var11.contains(":")) {
               var22 = var11.split(":");
               var21 = var22[0];
            } else {
               var21 = var11;
            }

            var20 = var20 + " and salconProjet = '" + var21 + "'";
         }
      }

      if (var12 != null && !var12.isEmpty()) {
         var21 = "";
         if (var12.contains(":")) {
            var22 = var12.split(":");
            var21 = var22[0];
         } else {
            var21 = var12;
         }

         var20 = var20 + " and salconFeuille = '" + var21 + "'";
      }

      if (var13 != 0L) {
         var20 = var20 + " and salconIdTiers = " + var13;
      }

      if (var1 == 0) {
         if (var6 != null && !var6.isEmpty()) {
            if (var2 == 0) {
               var19 = var15.createQuery("from SalariesContrats where salconFeuille=:feu and (Salaries.salMatricule like '%" + var6 + "%' or Salaries.salNom like '%" + var6 + "%') " + var20 + " order by Salaries.salMatricule asc").setString("feu", var5);
            } else {
               var19 = var15.createQuery("from SalariesContrats where salconFeuille=:feu  and (Salaries.salMatricule like '%" + var6 + "%' or Salaries.salNom like '%" + var6 + "%') " + var20 + " order by Salaries.salNom,Salaries.salPrenom asc").setString("feu", var5);
            }
         } else if (var2 == 0) {
            var19 = var15.createQuery("from SalariesContrats where salconFeuille=:feu " + var20 + " order by Salaries.salMatricule asc").setString("feu", var5);
         } else {
            var19 = var15.createQuery("from SalariesContrats where salconFeuille=:feu  " + var20 + " order by Salaries.salNom,Salaries.salPrenom asc").setString("feu", var5);
         }
      } else if (var1 == 1) {
         if (var6 != null && !var6.isEmpty()) {
            if (var2 == 0) {
               var19 = var15.createQuery("from SalariesContrats where salconActivite=:act and (Salaries.salMatricule like '%" + var6 + "%' or Salaries.salNom like '%" + var6 + "%')  " + var20 + " order by Salaries.salMatricule asc").setString("act", var5);
            } else {
               var19 = var15.createQuery("from SalariesContrats where salconActivite=:act and (Salaries.salMatricule like '%" + var6 + "%' or Salaries.salNom like '%" + var6 + "%')  " + var20 + " order by Salaries.salNom,Salaries.salPrenom asc").setString("act", var5);
            }
         } else if (var2 == 0) {
            var19 = var15.createQuery("from SalariesContrats where salconActivite=:act  " + var20 + " order by Salaries.salMatricule asc").setString("act", var5);
         } else {
            var19 = var15.createQuery("from SalariesContrats where salconActivite=:act  " + var20 + " order by Salaries.salNom,Salaries.salPrenom asc").setString("act", var5);
         }
      } else if (var1 == 2) {
         if (var6 != null && !var6.isEmpty()) {
            if (var2 == 0) {
               var19 = var15.createQuery("from SalariesContrats where salconService=:ser and (Salaries.salMatricule like '%" + var6 + "%' or Salaries.salNom like '%" + var6 + "%')  " + var20 + " order by Salaries.salMatricule asc").setString("ser", var5);
            } else {
               var19 = var15.createQuery("from SalariesContrats where salconService=:ser and (Salaries.salMatricule like '%" + var6 + "%' or Salaries.salNom like '%" + var6 + "%')  " + var20 + " order by Salaries.salNom,Salaries.salPrenom asc").setString("ser", var5);
            }
         } else if (var2 == 0) {
            var19 = var15.createQuery("from SalariesContrats where salconService=:ser  " + var20 + " order by Salaries.salMatricule asc").setString("ser", var5);
         } else {
            var19 = var15.createQuery("from SalariesContrats where salconService=:ser  " + var20 + " order by Salaries.salNom,Salaries.salPrenom asc").setString("ser", var5);
         }
      } else if (var1 == 3) {
         if (var6 != null && !var6.isEmpty()) {
            if (var2 == 0) {
               var19 = var15.createQuery("from SalariesContrats where salconProjet=:pro and (Salaries.salMatricule like '%" + var6 + "%' or Salaries.salNom like '%" + var6 + "%')  " + var20 + " order by Salaries.salMatricule asc").setString("pro", var5);
            } else {
               var19 = var15.createQuery("from SalariesContrats where salconProjet=:pro and (Salaries.salMatricule like '%" + var6 + "%' or Salaries.salNom like '%" + var6 + "%')  " + var20 + " order by Salaries.salNom,Salaries.salPrenom asc").setString("pro", var5);
            }
         } else if (var2 == 0) {
            var19 = var15.createQuery("from SalariesContrats where salconProjet=:pro  " + var20 + " order by Salaries.salMatricule asc").setString("pro", var5);
         } else {
            var19 = var15.createQuery("from SalariesContrats where salconProjet=:pro  " + var20 + " order by Salaries.salNom,Salaries.salPrenom asc").setString("pro", var5);
         }
      } else if (var1 == 4) {
         if (var6 != null && !var6.isEmpty()) {
            if (var2 == 0) {
               var19 = var15.createQuery("from SalariesContrats where salconIdTiers=:clt and (Salaries.salMatricule like '%" + var6 + "%' or Salaries.salNom like '%" + var6 + "%')  " + var20 + " order by Salaries.salMatricule asc").setLong("clt", Long.parseLong(var5));
            } else {
               var19 = var15.createQuery("from SalariesContrats where salconIdTiers=:clt and (Salaries.salMatricule like '%" + var6 + "%' or Salaries.salNom like '%" + var6 + "%')  " + var20 + " order by Salaries.salNom,Salaries.salPrenom asc").setLong("clt", Long.parseLong(var5));
            }
         } else if (var2 == 0) {
            var19 = var15.createQuery("from SalariesContrats where salconIdTiers=:clt  " + var20 + " order by Salaries.salMatricule asc").setLong("clt", Long.parseLong(var5));
         } else {
            var19 = var15.createQuery("from SalariesContrats where salconIdTiers=:clt  " + var20 + " order by Salaries.salNom,Salaries.salPrenom asc").setLong("clt", Long.parseLong(var5));
         }
      }

      List var17 = var19.list();
      if (var17.size() != 0) {
         for(int var23 = 0; var23 < var17.size(); ++var23) {
            this.salariesContrats = (SalariesContrats)var17.get(var23);
            if (this.salariesContrats.getSalconDateDebut() != null && (var3.compareTo(this.salariesContrats.getSalconDateDebut()) > 0 || this.salariesContrats.getSalconDateDebut().getMonth() == var3.getMonth() && this.salariesContrats.getSalconDateDebut().getYear() == var3.getYear())) {
               if (this.salariesContrats.getSalconDateFin() == null) {
                  var18.add(this.salariesContrats);
               } else if (var4.compareTo(this.salariesContrats.getSalconDateFin()) < 0 || this.salariesContrats.getSalconDateFin().getMonth() == var4.getMonth() && this.salariesContrats.getSalconDateFin().getYear() == var4.getYear()) {
                  var18.add(this.salariesContrats);
               }
            }
         }
      }

      if (var16) {
         this.utilInitHibernate.closeSession();
      }

      return var18;
   }

   public List listelesContratsPeremption(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var4 = true;
      }

      this.salariesContrats = new SalariesContrats();
      new ArrayList();
      Query var6 = var3.createQuery("from SalariesContrats where salconDateFin is not null and salconDateFin>=:deb and salconDateFin<=:fin order by salconDateDebut desc").setDate("deb", var1).setDate("fin", var2);
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerlesContrats(int var1, String var2, int var3, int var4, String var5, String var6, String var7, String var8, String var9, String var10, String var11, String var12, String var13, String var14, String var15, String var16, String var17, String var18, String var19, String var20, Date var21, Session var22) throws HibernateException, NamingException {
      boolean var23 = false;
      if (var22 == null) {
         var22 = this.utilInitHibernate.getOpenSession(this.maBase, "SuiviRH");
         var23 = true;
      }

      new ArrayList();
      String var25 = "";
      if (var5 != null && !var5.isEmpty() || var6 != null && !var6.isEmpty()) {
         if (var5 != null && !var5.isEmpty()) {
            var25 = var25 + " and Salaries.salMatricule like '%" + var5 + "'";
         }

         if (var6 != null && !var6.isEmpty()) {
            var25 = var25 + " and Salaries.salNom like '%" + var6 + "%'";
         }
      }

      if (var4 == 20) {
         var25 = var25 + " and (salconType is null or salconType = '')";
      } else if (var4 == 21) {
         var25 = var25 + " and (Salaries.salMatricule is null or Salaries.salMatricule = '')";
      } else {
         if (var8 != null && !var8.isEmpty() && !var8.equals("100")) {
            var25 = var25 + " and salconType='" + var8 + "'";
         } else {
            var25 = var25 + " and salconType in (" + var2 + ")";
         }

         if (var4 != 100) {
            var25 = var25 + " and salconEtat=" + var4;
         }
      }

      if (var3 != 100) {
         var25 = var25 + " and salconEtatH=" + var3;
      }

      if (var7 != null && !var7.isEmpty() && !var7.equals("100")) {
         var25 = var25 + " and salconFeuille='" + var7 + "'";
      }

      String[] var26;
      String var27;
      if (var9 != null && !var9.isEmpty() && var9.contains(":")) {
         var26 = var9.split(":");
         var27 = var26[0];
         var25 = var25 + " and salconSite='" + var27 + "'";
      }

      if (var10 != null && !var10.isEmpty() && var10.contains(":")) {
         var26 = var10.split(":");
         var27 = var26[0];
         var25 = var25 + " and salconDepartement='" + var27 + "'";
      }

      if (var11 != null && !var11.isEmpty() && var11.contains(":")) {
         var26 = var11.split(":");
         var27 = var26[0];
         var25 = var25 + " and salconService='" + var27 + "'";
      }

      if (var12 != null && !var12.isEmpty() && var12.contains(":")) {
         var26 = var12.split(":");
         var27 = var26[0];
         var25 = var25 + " and salconProjet='" + var27 + "'";
      }

      if (var13 != null && !var13.isEmpty() && var13.contains(":")) {
         var26 = var13.split(":");
         var27 = var26[0];
         var25 = var25 + " and salconActivite='" + var27 + "'";
      }

      if (var20 != null && !var20.isEmpty() && var20.contains(":")) {
         var26 = var20.split(":");
         var27 = var26[0];
         var25 = var25 + " and salconBudget='" + var27 + "'";
      } else if (var20 != null && !var20.isEmpty() && var20.equals("101")) {
         var25 = var25 + " and (salconBudget is null or salconBudget='')";
      }

      if (var14 != null && !var14.isEmpty() && var14.contains(":")) {
         var26 = var14.split(":");
         var27 = var26[0];
         var25 = var25 + " and salconConvention='" + var27 + "'";
      }

      if (var15 != null && !var15.isEmpty() && var15.contains(":")) {
         var26 = var15.split(":");
         var27 = var26[0];
         var25 = var25 + " and salconNivEmploi='" + var27 + "'";
      }

      if (var16 != null && !var16.isEmpty() && var16.contains(":")) {
         var26 = var16.split(":");
         var27 = var26[0];
         var25 = var25 + " and salconClassement='" + var27 + "'";
      }

      if (var17 != null && !var17.isEmpty() && var17.contains(":")) {
         var26 = var17.split(":");
         var27 = var26[0];
         var25 = var25 + " and salconGrille='" + var27 + "'";
      }

      if (var18 != null && !var18.isEmpty() && var18.contains(":")) {
         var26 = var18.split(":");
         var27 = var26[0];
         var25 = var25 + " and salconCentresImpots='" + var27 + "'";
      }

      if (var19 != null && !var19.isEmpty() && var19.contains(":")) {
         var25 = var25 + " and salconLocalisation='" + var19 + "'";
      }

      if (var21 != null) {
         var25 = var25 + "salcanDateEntree is not null and salcanDateEntree <= '" + var21 + "'";
      }

      String var28 = "";
      if (var1 == 0) {
         var28 = "Salaries.salMatricule";
      } else if (var1 == 1) {
         var28 = "Salaries.salNom,Salaries.salPrenom";
      }

      Query var29 = var22.createQuery("from SalariesContrats where salconType<>'0'" + var25 + " order by " + var28);
      List var24 = var29.list();
      if (var23) {
         this.utilInitHibernate.closeSession();
      }

      return var24;
   }

   public List chargerlesContrats(int var1, String var2, int var3, int var4, String var5, String var6, String var7, String var8, String var9, String var10, String var11, String var12, String var13, String var14, String var15, String var16, String var17, String var18, String var19, String var20, long var21, Date var23, Session var24) throws HibernateException, NamingException {
      boolean var25 = false;
      if (var24 == null) {
         var24 = this.utilInitHibernate.getOpenSession(this.maBase, "SuiviRH");
         var25 = true;
      }

      new ArrayList();
      String var27 = "";
      if ((var5 == null || var5.isEmpty()) && (var6 == null || var6.isEmpty()) && var4 != 100) {
         var27 = var27 + " and salconEtat=" + var4;
      }

      if (var8 != null && !var8.isEmpty() && !var8.equals("100")) {
         var27 = var27 + " and salconType='" + var8 + "'";
      } else {
         var27 = var27 + " and salconType in (" + var2 + ")";
      }

      if (var3 != 100) {
         var27 = var27 + " and salconEtatH=" + var3;
      }

      if (var7 != null && !var7.isEmpty() && !var7.equals("100")) {
         var27 = var27 + " and salconFeuille='" + var7 + "'";
      }

      String[] var28;
      String var29;
      if (var9 != null && !var9.isEmpty() && var9.contains(":")) {
         var28 = var9.split(":");
         var29 = var28[0];
         var27 = var27 + " and salconSite='" + var29 + "'";
      }

      if (var10 != null && !var10.isEmpty() && var10.contains(":")) {
         var28 = var10.split(":");
         var29 = var28[0];
         var27 = var27 + " and salconDepartement='" + var29 + "'";
      }

      if (var11 != null && !var11.isEmpty() && var11.contains(":")) {
         var28 = var11.split(":");
         var29 = var28[0];
         var27 = var27 + " and salconService='" + var29 + "'";
      } else if (var11 != null && !var11.isEmpty() && var11.equals("101")) {
         var27 = var27 + " and (salconService is null or salconService='')";
      }

      if (var12 != null && !var12.isEmpty() && var12.contains(":")) {
         var28 = var12.split(":");
         var29 = var28[0];
         var27 = var27 + " and salconProjet='" + var29 + "'";
      } else if (var12 != null && !var12.isEmpty() && var12.equals("101")) {
         var27 = var27 + " and (salconProjet is null or salconProjet='')";
      }

      if (var13 != null && !var13.isEmpty() && var13.contains(":")) {
         var28 = var13.split(":");
         var29 = var28[0];
         var27 = var27 + " and salconActivite='" + var29 + "'";
      } else if (var13 != null && !var13.isEmpty() && var13.equals("101")) {
         var27 = var27 + " and (salconActivite is null or salconActivite='')";
      }

      if (var20 != null && !var20.isEmpty() && var20.contains(":")) {
         var28 = var20.split(":");
         var29 = var28[0];
         var27 = var27 + " and salconBudget='" + var29 + "'";
      } else if (var20 != null && !var20.isEmpty() && var20.equals("101")) {
         var27 = var27 + " and (salconBudget is null or salconBudget='')";
      }

      if (var21 > 0L) {
         var27 = var27 + " and salconIdTiers=" + var21;
      } else if (var21 < 0L) {
         var27 = var27 + " and salconIdTiers=0";
      }

      if (var14 != null && !var14.isEmpty() && var14.contains(":")) {
         var28 = var14.split(":");
         var29 = var28[0];
         var27 = var27 + " and salconConvention='" + var29 + "'";
      }

      if (var15 != null && !var15.isEmpty() && var15.contains(":")) {
         var28 = var15.split(":");
         var29 = var28[0];
         var27 = var27 + " and salconNivEmploi='" + var29 + "'";
      }

      if (var16 != null && !var16.isEmpty() && var16.contains(":")) {
         var28 = var16.split(":");
         var29 = var28[0];
         var27 = var27 + " and salconClassement='" + var29 + "'";
      }

      if (var17 != null && !var17.isEmpty() && var17.contains(":")) {
         var28 = var17.split(":");
         var29 = var28[0];
         var27 = var27 + " and salconGrille='" + var29 + "'";
      }

      if (var18 != null && !var18.isEmpty() && var18.contains(":")) {
         var28 = var18.split(":");
         var29 = var28[0];
         var27 = var27 + " and salconCentresImpots='" + var29 + "'";
      }

      if (var19 != null && !var19.isEmpty() && var19.contains(":")) {
         var27 = var27 + " and salconLocalisation='" + var19 + "'";
      }

      if (var23 != null) {
         var27 = var27 + "salcanDateEntree is not null and salcanDateEntree <= '" + var23 + "'";
      }

      String var32 = "";
      if (var1 == 0) {
         var32 = "Salaries.salMatricule";
      } else if (var1 == 1) {
         var32 = "Salaries.salNom,Salaries.salPrenom";
      }

      Query var33 = var24.createQuery("from SalariesContrats where salconId<>0" + var27 + " order by " + var32);
      Object var26 = var33.list();
      if (((List)var26).size() != 0 && (var5 != null && !var5.isEmpty() || var6 != null && !var6.isEmpty())) {
         ArrayList var30 = new ArrayList();

         for(int var31 = 0; var31 < ((List)var26).size(); ++var31) {
            if (var5 != null && !var5.isEmpty()) {
               if (((SalariesContrats)((List)var26).get(var31)).getSalaries().getSalMatricule().endsWith(var5)) {
                  var30.add(((List)var26).get(var31));
               }
            } else if (var6 != null && !var6.isEmpty() && ((SalariesContrats)((List)var26).get(var31)).getSalaries().getSalNom().contains(var6)) {
               var30.add(((List)var26).get(var31));
            }
         }

         if (var30.size() != 0) {
            var26 = var30;
         } else {
            ((List)var26).clear();
         }
      }

      if (var25) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var26;
   }

   public List chargerlesContrats(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      this.salariesContrats = new SalariesContrats();
      new ArrayList();
      Query var5 = var2.createQuery("from SalariesContrats where salcon_projet=:code order by salconDateDebut desc").setString("code", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public SalariesContrats pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var4 = true;
      }

      Query var5 = var3.createQuery("from SalariesContrats where salconId =:num").setLong("num", var1).setMaxResults(1);
      List var6 = var5.list();
      SalariesContrats var7 = null;
      if (var6.size() != 0) {
         var7 = (SalariesContrats)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerlesContratsByRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from SalariesContrats where " + var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesContratGroupCentre(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var2 = true;
      }

      new ArrayList();
      Query var4 = var1.createQuery("from SalariesContrats group by salconCentresImpots");
      List var3 = var4.list();
      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var3.size(); ++var6) {
            if (((SalariesContrats)var3.get(var6)).getSalconCentresImpots() != null && !((SalariesContrats)var3.get(var6)).getSalconCentresImpots().isEmpty()) {
               var5.add(new SelectItem(((SalariesContrats)var3.get(var6)).getSalconCentresImpots() + ":" + ((SalariesContrats)var3.get(var6)).getSalconLibCentresImpots()));
            } else {
               var5.add(new SelectItem("???:Non spécifié"));
            }
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesContratGroupCentreSecurite(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var2 = true;
      }

      new ArrayList();
      Query var4 = var1.createQuery("from SalariesContrats group by salconCentresSecurite");
      List var3 = var4.list();
      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var3.size(); ++var6) {
            if (((SalariesContrats)var3.get(var6)).getSalconCentresSecurite() != null && !((SalariesContrats)var3.get(var6)).getSalconCentresSecurite().isEmpty()) {
               var5.add(new SelectItem(((SalariesContrats)var3.get(var6)).getSalconCentresSecurite() + ":" + ((SalariesContrats)var3.get(var6)).getSalconLibCentresSecurite()));
            } else {
               var5.add(new SelectItem("???:Non spécifié"));
            }
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesContratGroupClassement(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var2 = true;
      }

      new ArrayList();
      Query var4 = var1.createQuery("from SalariesContrats group by salconClassement");
      List var3 = var4.list();
      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var3.size(); ++var6) {
            if (((SalariesContrats)var3.get(var6)).getSalconClassement() != null && !((SalariesContrats)var3.get(var6)).getSalconClassement().isEmpty()) {
               var5.add(new SelectItem(((SalariesContrats)var3.get(var6)).getSalconClassement() + ":" + ((SalariesContrats)var3.get(var6)).getSalconLibClassement()));
            } else {
               var5.add(new SelectItem("???:Non spécifié"));
            }
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesContratGroupNiveau(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var2 = true;
      }

      new ArrayList();
      Query var4 = var1.createQuery("from SalariesContrats group by salconNivEmploi");
      List var3 = var4.list();
      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var3.size(); ++var6) {
            if (((SalariesContrats)var3.get(var6)).getSalconNivEmploi() != null && !((SalariesContrats)var3.get(var6)).getSalconNivEmploi().isEmpty()) {
               var5.add(new SelectItem(((SalariesContrats)var3.get(var6)).getSalconNivEmploi() + ":" + ((SalariesContrats)var3.get(var6)).getSalconLibNivEmploi()));
            } else {
               var5.add(new SelectItem("???:Non spécifié"));
            }
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesContratGroupConvention(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var2 = true;
      }

      new ArrayList();
      Query var4 = var1.createQuery("from SalariesContrats group by salconConvention");
      List var3 = var4.list();
      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var3.size(); ++var6) {
            if (((SalariesContrats)var3.get(var6)).getSalconConvention() != null && !((SalariesContrats)var3.get(var6)).getSalconConvention().isEmpty()) {
               var5.add(new SelectItem(((SalariesContrats)var3.get(var6)).getSalconConvention() + ":" + ((SalariesContrats)var3.get(var6)).getSalconLibConvention()));
            } else {
               var5.add(new SelectItem("???:Non spécifié"));
            }
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesContratGroupGrille(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var2 = true;
      }

      new ArrayList();
      Query var4 = var1.createQuery("from SalariesContrats group by salconGrille");
      List var3 = var4.list();
      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var3.size(); ++var6) {
            if (((SalariesContrats)var3.get(var6)).getSalconGrille() != null && !((SalariesContrats)var3.get(var6)).getSalconGrille().isEmpty()) {
               var5.add(new SelectItem(((SalariesContrats)var3.get(var6)).getSalconGrille() + ":" + ((SalariesContrats)var3.get(var6)).getSalconLibGrille()));
            } else {
               var5.add(new SelectItem("???:Non spécifié"));
            }
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesContratGroupService(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var2 = true;
      }

      new ArrayList();
      Query var4 = var1.createQuery("from SalariesContrats group by salconService");
      List var3 = var4.list();
      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var3.size(); ++var6) {
            if (((SalariesContrats)var3.get(var6)).getSalconService() != null && !((SalariesContrats)var3.get(var6)).getSalconService().isEmpty()) {
               var5.add(new SelectItem(((SalariesContrats)var3.get(var6)).getSalconService() + ":" + ((SalariesContrats)var3.get(var6)).getSalconLibService()));
            } else {
               var5.add(new SelectItem("???:Non spécifié"));
            }
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesContratGroupActivite(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var2 = true;
      }

      new ArrayList();
      Query var4 = var1.createQuery("from SalariesContrats group by salconActivite");
      List var3 = var4.list();
      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var3.size(); ++var6) {
            if (((SalariesContrats)var3.get(var6)).getSalconActivite() != null && !((SalariesContrats)var3.get(var6)).getSalconActivite().isEmpty()) {
               var5.add(new SelectItem(((SalariesContrats)var3.get(var6)).getSalconActivite() + ":" + ((SalariesContrats)var3.get(var6)).getSalconLibActivite()));
            } else {
               var5.add(new SelectItem("???:Non spécifié"));
            }
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesContratGroupSite(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var2 = true;
      }

      new ArrayList();
      Query var4 = var1.createQuery("from SalariesContrats group by salconSite");
      List var3 = var4.list();
      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var3.size(); ++var6) {
            if (((SalariesContrats)var3.get(var6)).getSalconSite() != null && !((SalariesContrats)var3.get(var6)).getSalconSite().isEmpty()) {
               var5.add(new SelectItem(((SalariesContrats)var3.get(var6)).getSalconSite()));
            } else {
               var5.add(new SelectItem("???:Non spécifié"));
            }
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesContratGroupBudget(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var2 = true;
      }

      new ArrayList();
      Query var4 = var1.createQuery("from SalariesContrats group by salconBudget");
      List var3 = var4.list();
      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var3.size(); ++var6) {
            if (((SalariesContrats)var3.get(var6)).getSalconBudget() != null && !((SalariesContrats)var3.get(var6)).getSalconBudget().isEmpty()) {
               var5.add(new SelectItem(((SalariesContrats)var3.get(var6)).getSalconBudget() + ":" + ((SalariesContrats)var3.get(var6)).getSalconLibBudget()));
            } else {
               var5.add(new SelectItem("???:Non spécifié"));
            }
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesContratGroupProjet(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var2 = true;
      }

      new ArrayList();
      Query var4 = var1.createQuery("from SalariesContrats group by salconProjet");
      List var3 = var4.list();
      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var3.size(); ++var6) {
            if (((SalariesContrats)var3.get(var6)).getSalconProjet() != null && !((SalariesContrats)var3.get(var6)).getSalconProjet().isEmpty()) {
               var5.add(new SelectItem(((SalariesContrats)var3.get(var6)).getSalconProjet() + ":" + ((SalariesContrats)var3.get(var6)).getSalconLibProjet()));
            } else {
               var5.add(new SelectItem("???:Non spécifié"));
            }
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesContratGroupParc(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var2 = true;
      }

      new ArrayList();
      Query var4 = var1.createQuery("from SalariesContrats group by salconParc");
      List var3 = var4.list();
      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var3.size(); ++var6) {
            if (((SalariesContrats)var3.get(var6)).getSalconParc() != null && !((SalariesContrats)var3.get(var6)).getSalconParc().isEmpty()) {
               var5.add(new SelectItem(((SalariesContrats)var3.get(var6)).getSalconParc()));
            } else {
               var5.add(new SelectItem("???:Non spécifié"));
            }
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesContratGroupFeuille(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var2 = true;
      }

      new ArrayList();
      Query var4 = var1.createQuery("from SalariesContrats group by salconFeuille");
      List var3 = var4.list();
      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var3.size(); ++var6) {
            if (((SalariesContrats)var3.get(var6)).getSalconFeuille() != null && !((SalariesContrats)var3.get(var6)).getSalconFeuille().isEmpty()) {
               var5.add(new SelectItem(((SalariesContrats)var3.get(var6)).getSalconFeuille()));
            } else {
               var5.add(new SelectItem("???:Non spécifié"));
            }
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerlesContratsByActivites(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      this.salariesContrats = new SalariesContrats();
      new ArrayList();
      Query var5 = null;
      if (var1 != null && !var1.isEmpty() && var1.equals("1")) {
         var5 = var2.createQuery("from SalariesContrats group by salconLibActivite");
      } else {
         var5 = var2.createQuery("from SalariesContrats group by salconActivite");
      }

      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerlesContratsByServices(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      this.salariesContrats = new SalariesContrats();
      new ArrayList();
      Query var5 = null;
      if (var1 != null && !var1.isEmpty() && var1.equals("1")) {
         var5 = var2.createQuery("from SalariesContrats group by salconLibService");
      } else {
         var5 = var2.createQuery("from SalariesContrats group by salconService");
      }

      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerlesContratsByProjets(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      this.salariesContrats = new SalariesContrats();
      new ArrayList();
      Query var5 = null;
      if (var1 != null && !var1.isEmpty() && var1.equals("1")) {
         var5 = var2.createQuery("from SalariesContrats group by salconLibProjet");
      } else {
         var5 = var2.createQuery("from SalariesContrats group by salconProjet");
      }

      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }
}
