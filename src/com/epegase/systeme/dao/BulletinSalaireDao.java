package com.epegase.systeme.dao;

import com.epegase.systeme.classe.BulletinSalaire;
import com.epegase.systeme.classe.ExercicesPaye;
import com.epegase.systeme.classe.Salaries;
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

public class BulletinSalaireDao implements Serializable {
   private BulletinSalaire bulletinSalaire;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public BulletinSalaireDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public BulletinSalaire insert(BulletinSalaire var1) throws HibernateException, NamingException {
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

   public BulletinSalaire insert(BulletinSalaire var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public BulletinSalaire modif(BulletinSalaire var1) throws HibernateException, NamingException {
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

   public BulletinSalaire modif(BulletinSalaire var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void modifMultiple(String var1, UtilDate var2) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         String var5 = var2.dateToStringSQLLight(new Date());
         Query var6 = var3.createQuery("update from BulletinSalaire set bulsal_date_impression='" + var5 + "', bulsal_etat_bulletin=true  where bulsal_id in (" + var1 + ") and bulsal_date_impression is null");
         var6.executeUpdate();
         var4.commit();
      } catch (HibernateException var10) {
         if (var4 != null) {
            var4.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void modifLot(String var1, int var2, UtilDate var3) throws HibernateException, NamingException {
      Session var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
      Transaction var5 = null;

      try {
         var5 = var4.beginTransaction();
         String var6 = var3.dateToStringSQLLight(new Date());
         Query var7 = var4.createQuery("update from BulletinSalaire set bulsalDateImpression='" + var6 + "', bulsalLot=" + var2 + ", bulsalEtatBulletin=true where bulsalId in (" + var1 + ") and bulsalLot=0");
         var7.executeUpdate();
         var5.commit();
      } catch (HibernateException var11) {
         if (var5 != null) {
            var5.rollback();
         }

         throw var11;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void delete(BulletinSalaire var1) throws HibernateException, NamingException {
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

   public void delete(BulletinSalaire var1, Session var2) {
      var2.delete(var1);
   }

   public List chargerlesBulletinsbySalarie(Salaries var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from BulletinSalaire where Salaries=:salarie and bulsalPeriode<>'SIMUL' order by bulsalDateDebut asc").setParameter("salarie", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerlesBulletinsbySalarie(Salaries var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from BulletinSalaire where Salaries=:salarie and bulsalPeriode<>'SIMUL' order by bulsalDateDebut asc").setParameter("salarie", var1);
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerDernierBulletinsbySalarie(long var1, Salaries var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var6 = true;
      }

      new ArrayList();
      Query var8 = var5.createQuery("from BulletinSalaire where Salaries=:salarie and bulsalDateDebut<:dte and ExercicesPaye.exepayId=:exo and bulsalPeriode<>'SIMUL' order by bulsalDateDebut desc").setParameter("salarie", var3).setDate("dte", var4).setLong("exo", var1).setMaxResults(1);
      List var7 = var8.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerlesBulletinsbySalarieExercice(Salaries var1, ExercicesPaye var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from BulletinSalaire where Salaries=:salarie and ExercicesPaye=:exo and bulsalPeriode<>'SIMUL' order by bulsalDateDebut asc").setParameter("salarie", var1).setParameter("exo", var2);
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerlesBulletinsPeriode(int var1, String var2, int var3, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var6 = true;
      }

      new ArrayList();
      Query var8 = null;
      if (var3 == 0) {
         if (var1 == 0) {
            var8 = var5.createQuery("from BulletinSalaire where bulsalFeuille=:feu and bulsalPeriode=:per order by bulsalMatricule asc").setString("feu", var4).setString("per", var2);
         } else if (var1 == 1) {
            var8 = var5.createQuery("from BulletinSalaire where bulsalActivite=:act and bulsalPeriode=:per order by bulsalMatricule asc").setString("act", var4).setString("per", var2);
         } else if (var1 == 2) {
            var8 = var5.createQuery("from BulletinSalaire where bulsalService=:ser and bulsalPeriode=:per order by bulsalMatricule asc").setString("ser", var4).setString("per", var2);
         } else if (var1 == 3) {
            var8 = var5.createQuery("from BulletinSalaire where bulsalProjet=:pro and bulsalPeriode=:per order by bulsalMatricule asc").setString("pro", var4).setString("per", var2);
         }
      } else if (var1 == 0) {
         var8 = var5.createQuery("from BulletinSalaire where bulsalFeuille=:feu and bulsalPeriode=:per order by Salaries.salNom, Salaries.salPrenom asc").setString("feu", var4).setString("per", var2);
      } else if (var1 == 1) {
         var8 = var5.createQuery("from BulletinSalaire where bulsalActivite=:act and bulsalPeriode=:per order by Salaries.salNom, Salaries.salPrenom asc").setString("act", var4).setString("per", var2);
      } else if (var1 == 2) {
         var8 = var5.createQuery("from BulletinSalaire where bulsalService=:ser and bulsalPeriode=:per order by Salaries.salNom, Salaries.salPrenom asc").setString("ser", var4).setString("per", var2);
      } else if (var1 == 3) {
         var8 = var5.createQuery("from BulletinSalaire where bulsalProjet=:pro and bulsalPeriode=:per order by Salaries.salNom, Salaries.salPrenom asc").setString("pro", var4).setString("per", var2);
      }

      List var7 = var8.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List listelesBulletin(int var1, int var2, Date var3, Date var4, String var5, String var6, String var7, String var8, String var9, String var10, String var11, String var12, String var13, long var14, String var16, Session var17) throws HibernateException, NamingException {
      boolean var18 = false;
      if (var17 == null) {
         var17 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var18 = true;
      }

      this.bulletinSalaire = new BulletinSalaire();
      new ArrayList();
      Query var20 = null;
      String var21 = "";
      String var22;
      String[] var23;
      if (var8 != null && !var8.isEmpty()) {
         if (var8.equals("*****")) {
            var21 = var21 + " and (bulsalActivite is null or bulsalActivite='') ";
         } else {
            var22 = "";
            if (var8.contains(":")) {
               var23 = var8.split(":");
               var22 = var23[0];
            } else {
               var22 = var8;
            }

            var21 = var21 + " and bulsalActivite = '" + var22 + "'";
         }
      }

      if (var9 != null && !var9.isEmpty()) {
         if (var9.equals("*****")) {
            var21 = var21 + " and (bulsalService is null or bulsalService='') ";
         } else {
            var22 = "";
            if (var9.contains(":")) {
               var23 = var9.split(":");
               var22 = var23[0];
            } else {
               var22 = var9;
            }

            var21 = var21 + " and bulsalService = '" + var22 + "'";
         }
      }

      if (var10 != null && !var10.isEmpty()) {
         if (var10.equals("*****")) {
            var21 = var21 + " and (bulsalDepartement is null or bulsalDepartement='') ";
         } else {
            var22 = "";
            if (var10.contains(":")) {
               var23 = var10.split(":");
               var22 = var23[0];
            } else {
               var22 = var9;
            }

            var21 = var21 + " and bulsalDepartement = '" + var22 + "'";
         }
      }

      if (var11 != null && !var11.isEmpty()) {
         if (var11.equals("*****")) {
            var21 = var21 + " and (bulsalLocalisation is null or bulsalLocalisation='') ";
         } else {
            var21 = var21 + " and bulsalLocalisation = '" + var11 + "'";
         }
      }

      if (var16 != null && !var16.isEmpty()) {
         if (var16.equals("*****")) {
            var21 = var21 + " and (bulsalLot=0) ";
         } else {
            var21 = var21 + " and bulsalLot = " + Integer.parseInt(var16);
         }
      }

      if (var12 != null && !var12.isEmpty()) {
         if (var12.equals("*****")) {
            var21 = var21 + " and (bulsalProjet is null or bulsalProjet='') ";
         } else {
            var22 = "";
            if (var12.contains(":")) {
               var23 = var12.split(":");
               var22 = var23[0];
            } else {
               var22 = var12;
            }

            var21 = var21 + " and bulsalProjet = '" + var22 + "'";
         }
      }

      if (var13 != null && !var13.isEmpty()) {
         var22 = "";
         if (var13.contains(":")) {
            var23 = var13.split(":");
            var22 = var23[0];
         } else {
            var22 = var13;
         }

         var21 = var21 + " and bulsalFeuille = '" + var22 + "'";
      }

      if (var14 != 0L) {
         var21 = var21 + " and bulsalIdTiers = " + var14;
      }

      if (var1 == 0) {
         if (var7 != null && !var7.isEmpty()) {
            if (var2 == 0) {
               var20 = var17.createQuery("from BulletinSalaire where bulsalPeriode=:per and bulsalFeuille=:feu and (Salaries.salMatricule like '%" + var7 + "%' or Salaries.salNom like '%" + var7 + "%') " + var21 + " and bulsalPeriode<>'SIMUL' order by Salaries.salMatricule asc").setString("feu", var5).setString("per", var6);
            } else {
               var20 = var17.createQuery("from BulletinSalaire where bulsalPeriode=:per and bulsalFeuille=:feu  and (Salaries.salMatricule like '%" + var7 + "%' or Salaries.salNom like '%" + var7 + "%') " + var21 + "  and bulsalPeriode<>'SIMUL' order by Salaries.salNom,Salaries.salPrenom asc").setString("feu", var5).setString("per", var6);
            }
         } else if (var2 == 0) {
            var20 = var17.createQuery("from BulletinSalaire where bulsalPeriode=:per and bulsalFeuille=:feu " + var21 + "  and bulsalPeriode<>'SIMUL' order by Salaries.salMatricule asc").setString("feu", var5).setString("per", var6);
         } else {
            var20 = var17.createQuery("from BulletinSalaire where bulsalPeriode=:per and bulsalFeuille=:feu  " + var21 + "  and bulsalPeriode<>'SIMUL' order by Salaries.salNom,Salaries.salPrenom asc").setString("feu", var5).setString("per", var6);
         }
      } else if (var1 == 1) {
         if (var7 != null && !var7.isEmpty()) {
            if (var2 == 0) {
               var20 = var17.createQuery("from BulletinSalaire where bulsalPeriode=:per and bulsalActivite=:act and (Salaries.salMatricule like '%" + var7 + "%' or Salaries.salNom like '%" + var7 + "%')  " + var21 + "  and bulsalPeriode<>'SIMUL' order by Salaries.salMatricule asc").setString("act", var5).setString("per", var6);
            } else {
               var20 = var17.createQuery("from BulletinSalaire where bulsalPeriode=:per and bulsalActivite=:act and (Salaries.salMatricule like '%" + var7 + "%' or Salaries.salNom like '%" + var7 + "%')  " + var21 + "  and bulsalPeriode<>'SIMUL' order by Salaries.salNom,Salaries.salPrenom asc").setString("act", var5).setString("per", var6);
            }
         } else if (var2 == 0) {
            var20 = var17.createQuery("from BulletinSalaire where bulsalPeriode=:per and bulsalActivite=:act  " + var21 + "  and bulsalPeriode<>'SIMUL' order by Salaries.salMatricule asc").setString("act", var5).setString("per", var6);
         } else {
            var20 = var17.createQuery("from BulletinSalaire where bulsalPeriode=:per and bulsalActivite=:act  " + var21 + "  and bulsalPeriode<>'SIMUL' order by Salaries.salNom,Salaries.salPrenom asc").setString("act", var5).setString("per", var6);
         }
      } else if (var1 == 2) {
         if (var7 != null && !var7.isEmpty()) {
            if (var2 == 0) {
               var20 = var17.createQuery("from BulletinSalaire where bulsalPeriode=:per and bulsalService=:ser and (Salaries.salMatricule like '%" + var7 + "%' or Salaries.salNom like '%" + var7 + "%')  " + var21 + "  and bulsalPeriode<>'SIMUL' order by Salaries.salMatricule asc").setString("ser", var5).setString("per", var6);
            } else {
               var20 = var17.createQuery("from BulletinSalaire where bulsalPeriode=:per and bulsalService=:ser and (Salaries.salMatricule like '%" + var7 + "%' or Salaries.salNom like '%" + var7 + "%')  " + var21 + "  and bulsalPeriode<>'SIMUL' order by Salaries.salNom,Salaries.salPrenom asc").setString("ser", var5).setString("per", var6);
            }
         } else if (var2 == 0) {
            var20 = var17.createQuery("from BulletinSalaire where bulsalPeriode=:per and bulsalService=:ser  " + var21 + "  and bulsalPeriode<>'SIMUL' order by Salaries.salMatricule asc").setString("ser", var5).setString("per", var6);
         } else {
            var20 = var17.createQuery("from BulletinSalaire where bulsalPeriode=:per and bulsalService=:ser  " + var21 + "  and bulsalPeriode<>'SIMUL' order by Salaries.salNom,Salaries.salPrenom asc").setString("ser", var5).setString("per", var6);
         }
      } else if (var1 == 3) {
         if (var7 != null && !var7.isEmpty()) {
            if (var2 == 0) {
               var20 = var17.createQuery("from BulletinSalaire where bulsalPeriode=:per and bulsalProjet=:pro and (Salaries.salMatricule like '%" + var7 + "%' or Salaries.salNom like '%" + var7 + "%')  " + var21 + "  and bulsalPeriode<>'SIMUL' order by Salaries.salMatricule asc").setString("pro", var5).setString("per", var6);
            } else {
               var20 = var17.createQuery("from BulletinSalaire where bulsalPeriode=:per and bulsalProjet=:pro and (Salaries.salMatricule like '%" + var7 + "%' or Salaries.salNom like '%" + var7 + "%')  " + var21 + "  and bulsalPeriode<>'SIMUL' order by Salaries.salNom,Salaries.salPrenom asc").setString("pro", var5).setString("per", var6);
            }
         } else if (var2 == 0) {
            var20 = var17.createQuery("from BulletinSalaire where bulsalPeriode=:per and bulsalProjet=:pro  " + var21 + "  and bulsalPeriode<>'SIMUL' order by Salaries.salMatricule asc").setString("pro", var5).setString("per", var6);
         } else {
            var20 = var17.createQuery("from BulletinSalaire where bulsalPeriode=:per and bulsalProjet=:pro  " + var21 + "  and bulsalPeriode<>'SIMUL' order by Salaries.salNom,Salaries.salPrenom asc").setString("pro", var5).setString("per", var6);
         }
      } else if (var1 == 4) {
         if (var7 != null && !var7.isEmpty()) {
            if (var2 == 0) {
               var20 = var17.createQuery("from BulletinSalaire where bulsalPeriode=:per and bulsalIdTiers=:clt and (Salaries.salMatricule like '%" + var7 + "%' or Salaries.salNom like '%" + var7 + "%')  " + var21 + "  and bulsalPeriode<>'SIMUL' order by Salaries.salMatricule asc").setLong("clt", Long.parseLong(var5)).setString("per", var6);
            } else {
               var20 = var17.createQuery("from BulletinSalaire where bulsalPeriode=:per and bulsalIdTiers=:clt and (Salaries.salMatricule like '%" + var7 + "%' or Salaries.salNom like '%" + var7 + "%')  " + var21 + "  and bulsalPeriode<>'SIMUL' order by Salaries.salNom,Salaries.salPrenom asc").setLong("clt", Long.parseLong(var5)).setString("per", var6);
            }
         } else if (var2 == 0) {
            var20 = var17.createQuery("from BulletinSalaire where bulsalPeriode=:per and bulsalIdTiers=:clt  " + var21 + "  and bulsalPeriode<>'SIMUL' order by Salaries.salMatricule asc").setLong("clt", Long.parseLong(var5)).setString("per", var6);
         } else {
            var20 = var17.createQuery("from BulletinSalaire where bulsalPeriode=:per and bulsalIdTiers=:clt  " + var21 + "  and bulsalPeriode<>'SIMUL' order by Salaries.salNom,Salaries.salPrenom asc").setLong("clt", Long.parseLong(var5)).setString("per", var6);
         }
      }

      List var19 = var20.list();
      if (var18) {
         this.utilInitHibernate.closeSession();
      }

      return var19;
   }

   public List chargerlesBulletinsbyFeuilleJour(String var1, int var2, Date var3, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var6 = true;
      }

      new ArrayList();
      Query var8 = null;
      String var9;
      String[] var10;
      if (var2 == 0) {
         if (var4 != null && !var4.isEmpty()) {
            var9 = "";
            if (var4.contains(":")) {
               var10 = var4.split(":");
               var9 = var10[0];
            } else {
               var9 = var4;
            }

            var8 = var5.createQuery("from BulletinSalaire where bulsalFeuille=:feu and bulsalDateDebut=:per and busalService=:serv and bulsalPeriode<>'SIMUL' order by bulsalMatricule asc").setString("feu", var1).setDate("per", var3).setString("serv", var9);
         } else if (var4 != null && !var4.isEmpty() && var4.equals("*****")) {
            var8 = var5.createQuery("from BulletinSalaire where bulsalFeuille=:feu and bulsalDateDebut=:per and (bulsalService is null or bulsalService='') and bulsalPeriode<>'SIMUL' order by bulsalMatricule asc").setString("feu", var1).setDate("per", var3);
         } else {
            var8 = var5.createQuery("from BulletinSalaire where bulsalFeuille=:feu and bulsalDateDebut=:per and bulsalPeriode<>'SIMUL' order by bulsalMatricule asc").setString("feu", var1).setDate("per", var3);
         }
      } else if (var4 != null && !var4.isEmpty()) {
         var9 = "";
         if (var4.contains(":")) {
            var10 = var4.split(":");
            var9 = var10[0];
         } else {
            var9 = var4;
         }

         var8 = var5.createQuery("from BulletinSalaire where bulsalFeuille=:feu and bulsalDateDebut=:per and busalService=:serv and bulsalPeriode<>'SIMUL' order by Salaries.salNom, Salaries.salPrenom asc").setString("feu", var1).setDate("per", var3).setString("serv", var9);
      } else if (var4 != null && !var4.isEmpty() && var4.equals("*****")) {
         var8 = var5.createQuery("from BulletinSalaire where bulsalFeuille=:feu and bulsalDateDebut=:per and (bulsalService is null or bulsalService='') and bulsalPeriode<>'SIMUL' order by Salaries.salNom, Salaries.salPrenom asc").setString("feu", var1).setDate("per", var3);
      } else {
         var8 = var5.createQuery("from BulletinSalaire where bulsalFeuille=:feu and bulsalDateDebut=:per and bulsalPeriode<>'SIMUL' order by Salaries.salNom, Salaries.salPrenom asc").setString("feu", var1).setDate("per", var3);
      }

      List var7 = var8.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerlesBulletinsbyFeuilleProjetJour(String var1, int var2, Date var3, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var6 = true;
      }

      new ArrayList();
      Query var8 = null;
      String var9;
      String[] var10;
      if (var2 == 0) {
         if (var4 != null && !var4.isEmpty()) {
            var9 = "";
            if (var4.contains(":")) {
               var10 = var4.split(":");
               var9 = var10[0];
            } else {
               var9 = var4;
            }

            var8 = var5.createQuery("from BulletinSalaire where bulsalFeuille=:feu and bulsalDateDebut=:per and bulsalProjet=:serv and bulsalPeriode<>'SIMUL' order by bulsalMatricule asc").setString("feu", var1).setDate("per", var3).setString("serv", var9);
         } else if (var4 != null && !var4.isEmpty() && var4.equals("*****")) {
            var8 = var5.createQuery("from BulletinSalaire where bulsalFeuille=:feu and bulsalDateDebut=:per and (bulsalProjet is null or bulsalProjet='') and bulsalPeriode<>'SIMUL' order by bulsalMatricule asc").setString("feu", var1).setDate("per", var3);
         } else {
            var8 = var5.createQuery("from BulletinSalaire where bulsalFeuille=:feu and bulsalDateDebut=:per and bulsalPeriode<>'SIMUL' order by bulsalMatricule asc").setString("feu", var1).setDate("per", var3);
         }
      } else if (var4 != null && !var4.isEmpty()) {
         var9 = "";
         if (var4.contains(":")) {
            var10 = var4.split(":");
            var9 = var10[0];
         } else {
            var9 = var4;
         }

         var8 = var5.createQuery("from BulletinSalaire where bulsalFeuille=:feu and bulsalDateDebut=:per and bulsalProjet=:serv and bulsalPeriode<>'SIMUL' order by Salaries.salNom, Salaries.salPrenom asc").setString("feu", var1).setDate("per", var3).setString("serv", var9);
      } else if (var4 != null && !var4.isEmpty() && var4.equals("*****")) {
         var8 = var5.createQuery("from BulletinSalaire where bulsalFeuille=:feu and bulsalDateDebut=:per and (bulsalProjet is null or bulsalProjet='') and bulsalPeriode<>'SIMUL' order by Salaries.salNom, Salaries.salPrenom asc").setString("feu", var1).setDate("per", var3);
      } else {
         var8 = var5.createQuery("from BulletinSalaire where bulsalFeuille=:feu and bulsalDateDebut=:per and bulsalPeriode<>'SIMUL' order by Salaries.salNom, Salaries.salPrenom asc").setString("feu", var1).setDate("per", var3);
      }

      List var7 = var8.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerlesBulletinsbyTiersPeriode(long var1, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var5 = true;
      }

      new ArrayList();
      Query var7 = var4.createQuery("from BulletinSalaire where bulsalIdTiers=:id and bulsalPeriode=:per order by bulsalMatricule asc").setLong("id", var1).setString("per", var3);
      List var6 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public BulletinSalaire rechercheBulletinSalariePeriode(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var4 = true;
      }

      Query var5 = var3.createQuery("from BulletinSalaire where bulsalMatricule=:mat and bulsalPeriode=:per and bulsalPeriode<>'SIMUL'").setString("mat", var1).setString("per", var2).setMaxResults(1);
      List var6 = var5.list();
      BulletinSalaire var7 = null;
      if (var6.size() != 0) {
         var7 = (BulletinSalaire)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public BulletinSalaire rechercheBulletinSalariePeriode(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var5 = true;
      }

      Query var6 = var4.createQuery("from BulletinSalaire where bulsalMatricule=:mat and bulsalContrat=:crt and bulsalPeriode=:per").setString("mat", var1).setString("crt", var2).setString("per", var3).setMaxResults(1);
      List var7 = var6.list();
      BulletinSalaire var8 = null;
      if (var7.size() != 0) {
         var8 = (BulletinSalaire)var7.get(0);
      } else {
         var8 = null;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public BulletinSalaire rechercheBulletinSalarieDernier(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      Query var4 = var2.createQuery("from BulletinSalaire where bulsalMatricule=:mat and bulsalPeriode<>'SIMUL' order by bulsalDateDebut desc").setString("mat", var1).setMaxResults(1);
      List var5 = var4.list();
      BulletinSalaire var6 = null;
      if (var5.size() != 0) {
         var6 = (BulletinSalaire)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public BulletinSalaire pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var4 = true;
      }

      Query var5 = var3.createQuery("from BulletinSalaire where bulsalId =:num").setLong("num", var1).setMaxResults(1);
      List var6 = var5.list();
      BulletinSalaire var7 = null;
      if (var6.size() != 0) {
         var7 = (BulletinSalaire)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List rechercheBulletinATransfererCompta(int var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var5 = true;
      }

      new ArrayList();
      Query var7 = null;
      if (var1 == 0) {
         if (var2 != null && !var2.isEmpty()) {
            var7 = var4.createQuery("from BulletinSalaire where bulsalFeuille=:feu and bulsalPeriode=:per and (bulsalDateTransfert is null or bulsalDateTransfert='') and bulsalPeriode<>'SIMUL' order by bulsalMatricule asc").setString("feu", var2).setString("per", var3);
         } else {
            var7 = var4.createQuery("from BulletinSalaire where bulsalPeriode=:per and (bulsalDateTransfert is null or bulsalDateTransfert='') and bulsalPeriode<>'SIMUL' order by bulsalMatricule asc").setString("per", var3);
         }
      } else if (var1 == 1) {
         if (var2 != null && !var2.isEmpty()) {
            var7 = var4.createQuery("from BulletinSalaire where bulsalActivite=:act and bulsalPeriode=:per and (bulsalDateTransfert is null or bulsalDateTransfert='') and bulsalPeriode<>'SIMUL' order by bulsalMatricule asc").setString("act", var2).setString("per", var3);
         } else {
            var7 = var4.createQuery("from BulletinSalaire where bulsalPeriode=:per and (bulsalDateTransfert is null or bulsalDateTransfert='') and bulsalPeriode<>'SIMUL' order by bulsalMatricule asc").setString("per", var3);
         }
      } else if (var1 == 2) {
         if (var2 != null && !var2.isEmpty()) {
            var7 = var4.createQuery("from BulletinSalaire where bulsalService=:ser and bulsalPeriode=:per and (bulsalDateTransfert is null or bulsalDateTransfert='') and bulsalPeriode<>'SIMUL' order by bulsalMatricule asc").setString("ser", var2).setString("per", var3);
         } else {
            var7 = var4.createQuery("from BulletinSalaire where bulsalPeriode=:per and (bulsalDateTransfert is null or bulsalDateTransfert='') and bulsalPeriode<>'SIMUL' order by bulsalMatricule asc").setString("per", var3);
         }
      } else if (var1 == 3) {
         if (var2 != null && !var2.isEmpty()) {
            var7 = var4.createQuery("from BulletinSalaire where bulsalProjet=:pro and bulsalPeriode=:per and (bulsalDateTransfert is null or bulsalDateTransfert='') and bulsalPeriode<>'SIMUL' order by bulsalMatricule asc").setString("pro", var2).setString("per", var3);
         } else {
            var7 = var4.createQuery("from BulletinSalaire where bulsalPeriode=:per and (bulsalDateTransfert is null or bulsalDateTransfert='') and bulsalPeriode<>'SIMUL' order by bulsalMatricule asc").setString("per", var3);
         }
      } else if (var1 == 4) {
         if (var2 != null && !var2.isEmpty()) {
            long var8 = Long.parseLong(var2);
            var7 = var4.createQuery("from BulletinSalaire where bulsalIdTiers=:pro and bulsalPeriode=:per and (bulsalDateTransfert is null or bulsalDateTransfert='') and bulsalPeriode<>'SIMUL' order by bulsalMatricule asc").setLong("pro", var8).setString("per", var3);
         } else {
            var7 = var4.createQuery("from BulletinSalaire where bulsalPeriode=:per and (bulsalDateTransfert is null or bulsalDateTransfert='') and bulsalPeriode<>'SIMUL' order by bulsalMatricule asc").setString("per", var3);
         }
      }

      List var6 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerlesBulletins(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var2 = true;
      }

      new ArrayList();
      Query var4 = var1.createQuery("from BulletinSalaire where bulsalPeriode<>'SIMUL'order by bulsalMatricule asc");
      List var3 = var4.list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerlesBulletinsDate(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from BulletinSalaire where bulsalDateDebut>=:d1 and bulsalDateDebut<=:d2 and bulsalPeriode<>'SIMUL' order by bulsalMatricule,bulsalDateDebut  asc").setDate("d1", var1).setDate("d2", var2);
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerles12BulletinsbySalarie(Date var1, Salaries var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from BulletinSalaire where Salaries=:salarie and bulsalDateDebut<=:dte and bulsalPeriode<>'SIMUL' order by bulsalDateDebut desc").setDate("dte", var1).setParameter("salarie", var2).setMaxResults(12);
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesBulletinsByMatricule(String var1, Date var2, Date var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var5 = true;
      }

      List var6 = var4.createQuery("from BulletinSalaire where bulsalDateDebut>=:d1 and bulsalDateDebut<=:d2 and bulsalMatricule in (" + var1 + ") and bulsalPeriode<>'SIMUL' order by bulsalMatricule,bulsalDateDebut  asc").setDate("d1", var2).setDate("d2", var3).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesBulletinsByMatricule(Salaries var1, Date var2, Date var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var5 = true;
      }

      List var6 = var4.createQuery("from BulletinSalaire where Salaries=:salarie and bulsalDateDebut>=:d1 and bulsalDateDebut<=:d2 and bulsalPeriode<>'SIMUL' order by bulsalMatricule,bulsalDateDebut  asc").setDate("d1", var2).setDate("d2", var3).setParameter("salarie", var1).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerlesBulletinsByRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from BulletinSalaire where " + var1 + " and bulsalPeriode<>'SIMUL' order by bulsalMatricule,bulsalDateDebut  asc");
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerlesBulletinsByRequeteVirement(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from BulletinSalaire where " + var1 + " order by bulsalNumBanque,bulsalMatricule,bulsalDateDebut asc");
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List suppressionlesBulletinsDate(ExercicesPaye var1, Date var2, Date var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var5 = true;
      }

      new ArrayList();
      Query var7 = null;
      if (var2.getMonth() + 1 == 1 && var3.getMonth() + 1 == 12 && var2.getYear() + 1900 == var3.getYear() + 1900) {
         var7 = var4.createQuery("from BulletinSalaire where ExercicesPaye=:exo order by bulsalMatricule,bulsalDateDebut  asc").setParameter("exo", var1);
      } else {
         var7 = var4.createQuery("from BulletinSalaire where (bulsalDateDebut>=:d1 and bulsalDateDebut<=:d2) order by bulsalMatricule,bulsalDateDebut  asc").setDate("d1", var2).setDate("d2", var3);
      }

      List var6 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public boolean verifMouvment(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var4 = true;
      }

      Query var6 = var3.createQuery("from BulletinSalaire where bulsalFeuille='" + var2 + "' and bulsalPeriode='" + var1 + "'").setMaxResults(1);
      int var7 = var6.list().size();
      boolean var5;
      if (var7 != 0) {
         var5 = true;
      } else {
         var5 = false;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
