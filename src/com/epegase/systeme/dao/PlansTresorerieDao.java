package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.PlansTresorerie;
import com.epegase.systeme.classe.Projets;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PlansTresorerieDao implements Serializable {
   private PlansTresorerie plansTresorerie;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public PlansTresorerieDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public PlansTresorerie insert(PlansTresorerie var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Projets");
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

   public PlansTresorerie insert(PlansTresorerie var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public PlansTresorerie modif(PlansTresorerie var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Projets");
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

   public PlansTresorerie modif(PlansTresorerie var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(PlansTresorerie var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Projets");
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

   public void delete(PlansTresorerie var1, Session var2) {
      var2.delete(var1);
   }

   public void ordonnner(int var1, int var2, long var3, long var5) throws HibernateException, NamingException {
      Session var7 = this.utilInitHibernate.getOpenSession(this.maBase, "Projets");
      Transaction var8 = null;

      try {
         var8 = var7.beginTransaction();
         String var9 = "update PlansTresorerie pb set pb.treOrdre=:ordPrec where pb.treId=:idPlb";
         var7.createQuery(var9).setInteger("ordPrec", var1).setLong("idPlb", var3).executeUpdate();
         String var11 = "update PlansTresorerie pb set pb.treOrdre=:ord1 where pb.treId=:idPlb";
         var7.createQuery(var11).setInteger("ord1", var2).setLong("idPlb", var5).executeUpdate();
         var8.commit();
      } catch (HibernateException var16) {
         if (var8 != null) {
            var8.rollback();
         }

         throw var16;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void ordonnnerDescendant(int var1, int var2, long var3, long var5) throws HibernateException, NamingException {
      Session var7 = this.utilInitHibernate.getOpenSession(this.maBase, "Projets");
      Transaction var8 = null;

      try {
         var8 = var7.beginTransaction();
         String var9 = "update PlansTresorerie pb set pb.treOrdre=:ordSuiv where pb.treId=:idPlb";
         var7.createQuery(var9).setInteger("ordSuiv", var1).setLong("idPlb", var3).executeUpdate();
         String var11 = "update PlansTresorerie pb set pb.treOrdre=:ord1 where pb.treId=:idPlb";
         var7.createQuery(var11).setInteger("ord1", var2).setLong("idPlb", var5).executeUpdate();
         var8.commit();
      } catch (HibernateException var16) {
         if (var8 != null) {
            var8.rollback();
         }

         throw var16;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void copiertouslesPlansbudgetaires(List var1, ExercicesComptable var2) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Projets");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();

         for(int var5 = 0; var5 < var1.size(); ++var5) {
            PlansTresorerie var6 = (PlansTresorerie)var1.get(var5);
            var6.setExercicesComptable(var2);
            var3.save(var6);
         }

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

   public PlansTresorerie chargerLesPlansTresorerie(long var1, String var3, String var4, String var5, Session var6) throws HibernateException, NamingException {
      boolean var7 = false;
      if (var6 == null) {
         var6 = this.utilInitHibernate.getOpenSession(this.maBase, "Projets");
         var7 = true;
      }

      Query var8 = var6.createQuery("from PlansTresorerie where exercicesComptable=:exo and treAnnee=:ann and treProjet=:prj and treCode=:cod order by treCode").setMaxResults(1).setLong("exo", var1).setString("ann", var3).setString("prj", var4).setString("cod", var5);
      this.plansTresorerie = new PlansTresorerie();
      new ArrayList();
      List var9 = var8.list();
      if (var9.size() != 0) {
         this.plansTresorerie = (PlansTresorerie)var9.get(0);
      } else {
         this.plansTresorerie = null;
      }

      if (var7) {
         this.utilInitHibernate.closeSession();
      }

      return this.plansTresorerie;
   }

   public List chargerLesPlansTresorerie(long var1, String var3, String var4, boolean var5, Session var6) throws HibernateException, NamingException {
      boolean var7 = false;
      if (var6 == null) {
         var6 = this.utilInitHibernate.getOpenSession(this.maBase, "Projets");
         var7 = true;
      }

      Query var8 = null;
      if (!var5) {
         if (var4 != null && !var4.isEmpty()) {
            if (var3 != null && !var3.isEmpty()) {
               var8 = var6.createQuery("from PlansTresorerie where treAnnee=:ann and treProjet=:prj and treType<=2 order by treCode").setString("ann", var3).setString("prj", var4);
            } else {
               var8 = var6.createQuery("from PlansTresorerie where treProjet=:prj and treType<=2 order by treCode").setString("prj", var4);
            }
         } else if (var3 != null && !var3.isEmpty()) {
            var8 = var6.createQuery("from PlansTresorerie where treAnnee=:ann and treType<=2 order by treCode").setString("ann", var3);
         } else {
            var8 = var6.createQuery("from PlansTresorerie where and treType<=2 order by treCode");
         }
      } else if (var4 != null && !var4.isEmpty()) {
         if (var3 != null && !var3.isEmpty()) {
            var8 = var6.createQuery("from PlansTresorerie where treAnnee=:ann and treProjet=:prj order by treCode").setString("ann", var3).setString("prj", var4);
         } else {
            var8 = var6.createQuery("from PlansTresorerie where treProjet=:prj order by treCode").setString("prj", var4);
         }
      } else if (var3 != null && !var3.isEmpty()) {
         var8 = var6.createQuery("from PlansTresorerie where treAnnee=:ann order by treCode").setString("ann", var3);
      } else {
         var8 = var6.createQuery("from PlansTresorerie order by treCode");
      }

      new ArrayList();
      List var9 = var8.list();
      if (var9.size() == 0) {
         String var10 = "" + var3;
         var9.clear();
         Query var11 = null;
         var5 = false;
         if (false) {
            if (var4 != null && !var4.isEmpty()) {
               var11 = var6.createQuery("from PlansTresorerie where treAnnee=:ann and treProjet=:prj and treType<=2 order by treCode").setString("ann", var10).setString("prj", var4);
            } else {
               var11 = var6.createQuery("from PlansTresorerie where treAnnee=:ann and treType<=2 order by treCode").setString("ann", var10);
            }
         } else if (var4 != null && !var4.isEmpty()) {
            var11 = var6.createQuery("from PlansTresorerie where treAnnee=:ann and treProjet=:prj order by treCode").setString("ann", var10).setString("prj", var4);
         } else {
            var11 = var6.createQuery("from PlansTresorerie where treAnnee=:ann order by treCode").setString("ann", var10);
         }

         var9 = var11.list();
         if (var9.size() != 0) {
            for(int var12 = 0; var12 < var9.size(); ++var12) {
               this.plansTresorerie = (PlansTresorerie)var9.get(var12);
               this.plansTresorerie.setTreAnnee(var3);
            }
         }
      }

      if (var7) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public List chargerLesPlansTresorerieProjet(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Projets");
         var3 = true;
      }

      Query var4 = var2.createQuery("from PlansTresorerie where treProjet=:prj order by treCode").setString("prj", var1);
      new ArrayList();
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesBudgetTresorerie(String var1, long var2, String var4, String var5, long var6, boolean var8, Session var9) throws HibernateException, NamingException, ParseException {
      boolean var10 = false;
      if (var9 == null) {
         var9 = this.utilInitHibernate.getOpenSession(this.maBase, "Projets");
         var10 = true;
      }

      Query var11 = null;
      if (var4 != null && !var4.isEmpty() && var4.equals("*")) {
         var4 = "";
      }

      if (var2 != 0L) {
         if (var4 != null && !var4.isEmpty()) {
            var11 = var9.createQuery("from PlansTresorerie where exercicesComptable=:exo and (treCode like '" + var4 + "%' or treLibelleFr like '" + var4 + "%') order by treCode").setLong("exo", var2);
         } else {
            var11 = var9.createQuery("from PlansTresorerie where exercicesComptable=:exo order by treCode").setLong("exo", var2);
         }
      } else if (var4 != null && !var4.isEmpty()) {
         var11 = var9.createQuery("from PlansTresorerie where (treCode like '" + var4 + "%' or treLibelleFr like '" + var4 + "%') order by treCode");
      } else {
         var11 = var9.createQuery("from PlansTresorerie order by treCode");
      }

      new ArrayList();
      Object var13 = new ArrayList();
      List var12 = var11.list();
      if (var12.size() != 0 && var8) {
         String var14 = "";
         if (var1.contains(":")) {
            String[] var15 = var1.split(":");
            var14 = var15[0];
         } else {
            var14 = var1;
         }

         UtilDate var28 = new UtilDate();
         ProjetsDao var16 = new ProjetsDao(this.maBase, this.utilInitHibernate);
         new Projets();
         Projets var17;
         int var18;
         Date var21;
         Date var29;
         long var33;
         if (var14 == null || var14.isEmpty()) {
            for(var18 = 0; var18 < var12.size(); ++var18) {
               this.plansTresorerie = (PlansTresorerie)var12.get(var18);
               var17 = var16.chargerLeProjet(0, this.plansTresorerie.getTreProjet(), var9);
               if (var17 != null) {
                  Date var30 = var28.stringToDateSQLLight(var5);
                  var29 = var28.dateToSQLLight(var17.getProDateDebut());
                  var21 = var28.dateToSQLLight(var17.getProDateFin());
                  if ((var30.after(var29) && var30.before(var21) || var30.equals(var29) || var30.equals(var21)) && var17.getProIdUsers() != null && !var17.getProIdUsers().isEmpty()) {
                     if (!var17.getProIdUsers().contains(":")) {
                        long var32 = Long.parseLong(var17.getProIdUsers());
                        if (var6 == var32) {
                           ((List)var13).add(this.plansTresorerie);
                        }
                     } else {
                        String[] var31 = var17.getProIdUsers().split(":");
                        var33 = 0L;

                        for(int var25 = 0; var25 < var31.length; ++var25) {
                           String var34 = var31[var25];
                           if (var34 != null && !var34.isEmpty()) {
                              var33 = Long.parseLong(var34);
                              if (var6 == var33) {
                                 ((List)var13).add(this.plansTresorerie);
                              }
                           }
                        }
                     }
                  }
               }
            }
         } else {
            for(var18 = 0; var18 < var12.size(); ++var18) {
               this.plansTresorerie = (PlansTresorerie)var12.get(var18);
               if (this.plansTresorerie.getTreProjet().startsWith(var14) || var14.equals("99999")) {
                  String var19 = "";
                  if (var14.equals("99999")) {
                     if (this.plansTresorerie.getTreProjet().contains(":")) {
                        String[] var20 = this.plansTresorerie.getTreProjet().split(":");
                        var19 = var20[0];
                     } else {
                        var19 = this.plansTresorerie.getTreProjet();
                     }
                  } else {
                     var19 = var14;
                  }

                  var17 = var16.chargerLeProjet(0, var19, var9);
                  if (var17 != null) {
                     var29 = var28.stringToDateSQLLight(var5);
                     var21 = var28.dateToSQLLight(var17.getProDateDebut());
                     Date var22 = var28.dateToSQLLight(var17.getProDateFin());
                     if ((var29.after(var21) && var29.before(var22) || var29.equals(var21) || var29.equals(var22)) && var17.getProIdUsers() != null && !var17.getProIdUsers().isEmpty()) {
                        if (!var17.getProIdUsers().contains(":")) {
                           var33 = Long.parseLong(var17.getProIdUsers());
                           if (var6 == var33) {
                              ((List)var13).add(this.plansTresorerie);
                           }
                        } else {
                           String[] var23 = var17.getProIdUsers().split(":");
                           long var24 = 0L;

                           for(int var26 = 0; var26 < var23.length; ++var26) {
                              String var27 = var23[var26];
                              if (var27 != null && !var27.isEmpty()) {
                                 var24 = Long.parseLong(var27);
                                 if (var6 == var24) {
                                    ((List)var13).add(this.plansTresorerie);
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      } else {
         var13 = var12;
      }

      if (var10) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var13;
   }

   public List chargerLesPlansTresorerie(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Projets");
         var3 = true;
      }

      Query var4 = var2.createQuery("from PlansTresorerie where treAnnee='" + var1 + "' order by treOrdre ");
      new ArrayList();
      List var5 = var4.list();
      ArrayList var6 = new ArrayList();
      if (var5.size() != 0) {
         for(int var7 = 0; var7 < var5.size(); ++var7) {
            var6.add(new SelectItem(((PlansTresorerie)var5.get(var7)).getTreCode() + ":" + ((PlansTresorerie)var5.get(var7)).getTreLibelleFr()));
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public boolean existCode(String var1, String var2, long var3, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "Projets");
         var6 = true;
      }

      boolean var7 = false;
      Query var8 = null;
      if (var1 != null && !var1.isEmpty()) {
         var8 = var5.createQuery("from PlansTresorerie where treProjet=:pro and treCode=:cod and exercicesComptable=:exo").setString("pro", var1).setString("cod", var2).setLong("exo", var3).setMaxResults(1);
      } else {
         var8 = var5.createQuery("from PlansTresorerie where treCode=:cod and exercicesComptable=:exo").setString("cod", var2).setLong("exo", var3).setMaxResults(1);
      }

      List var9 = var8.list();
      if (var9.size() > 0) {
         var7 = true;
      } else {
         var7 = false;
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerLesPlansBudgets(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Projets");
         var2 = true;
      }

      List var3 = var1.createQuery("from PlansTresorerie order by treCode").list();
      List var4 = var3;
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var5.add(new SelectItem(((PlansTresorerie)var4.get(var6)).getTreCode() + ":" + ((PlansTresorerie)var4.get(var6)).getTreLibelleFr()));
         }
      }

      return var5;
   }

   public List chargerLesPlansTresorerieAnnee(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Projets");
         var3 = true;
      }

      Query var4 = var2.createQuery("from PlansTresorerie where treAnnee='" + var1 + "' order by treCode");
      new ArrayList();
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesPlansTresorerieAnnee(ExercicesComptable var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Projets");
         var3 = true;
      }

      Query var4 = var2.createQuery("from PlansTresorerie where exercicesComptable=:exo order by treCode").setParameter("exo", var1);
      new ArrayList();
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
