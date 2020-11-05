package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Salaries;
import com.epegase.systeme.classe.SalariesVariables;
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

public class SalariesVariablesDao implements Serializable {
   private SalariesVariables salariesVariables;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public SalariesVariablesDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public SalariesVariables insert(SalariesVariables var1) throws HibernateException, NamingException {
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

   public SalariesVariables insert(SalariesVariables var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public SalariesVariables modif(SalariesVariables var1) throws HibernateException, NamingException {
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

   public SalariesVariables modif(SalariesVariables var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(SalariesVariables var1) throws HibernateException, NamingException {
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

   public void delete(SalariesVariables var1, Session var2) {
      var2.delete(var1);
   }

   public List chargerlesVariables(Salaries var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from SalariesVariables where Salaries=:salarie order by salvarCode asc").setParameter("salarie", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerlesVariablesPeriode(Salaries var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var5 = true;
      }

      new ArrayList();
      Query var7 = null;
      if (var3 != null && !var3.isEmpty()) {
         var7 = var4.createQuery("from SalariesVariables where Salaries=:salarie and salvarPeriode=:per and (salvarContrat=:crt or salvarContrat is null or salvarContrat='') order by salvarCode asc").setParameter("salarie", var1).setString("per", var2).setString("crt", var3);
      } else {
         var7 = var4.createQuery("from SalariesVariables where Salaries=:salarie and salvarPeriode=:per order by salvarCode asc").setParameter("salarie", var1).setString("per", var2);
      }

      List var6 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerlesVariablesDate(Salaries var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from SalariesVariables where Salaries=:salarie and salvarJour=:per order by salvarCode asc").setParameter("salarie", var1).setDate("per", var2);
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerlesVariablesFeuille(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var5 = true;
      }

      new ArrayList();
      Query var7 = var4.createQuery("from SalariesVariables where Salaries.salFeuille=:feu and salvarCode=:rub and salvarPeriode=:per order by salvarCode asc").setString("feu", var2).setString("rub", var3).setString("per", var1);
      List var6 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerlesVariablesFeuille(String var1, Date var2, Date var3, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var6 = true;
      }

      new ArrayList();
      Query var8 = null;
      if (var4 != null && !var4.isEmpty()) {
         String var9 = "";
         if (var4.contains(":")) {
            String[] var10 = var4.split(":");
            var9 = var10[0];
         } else {
            var9 = var4;
         }

         var8 = var5.createQuery("from SalariesVariables where salvarFeuille=:feu and (salvarPeriode=:per or (salvarJour !=null and salvarJour>=:deb and salvarJour<=:fin)) order by salvarCode asc").setString("feu", var9).setString("per", var1).setDate("deb", var2).setDate("fin", var3);
      } else {
         var8 = var5.createQuery("from SalariesVariables where (salvarPeriode=:per or (salvarJour !=null and salvarJour>=:deb and salvarJour<=:fin)) order by salvarCode asc").setString("per", var1).setDate("deb", var2).setDate("fin", var3);
      }

      List var7 = var8.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerlesVariablesFeuille(String var1, String var2, String var3, String var4, String var5, String var6, long var7, int var9, Session var10) throws HibernateException, NamingException {
      boolean var11 = false;
      if (var10 == null) {
         var10 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var11 = true;
      }

      String var12 = "";
      if (var2.contains("=")) {
         String[] var13 = var2.split("=");
         var12 = var13[0];
      } else {
         var12 = var2;
      }

      new ArrayList();
      Query var14 = null;
      if (var5 != null && !var5.isEmpty() && !var5.equals("*****")) {
         var14 = var10.createQuery("from SalariesVariables where salvarFeuille=:feu and salvarCode=:rub and salvarPeriode=:per order by salvarCode asc").setString("feu", var5).setString("rub", var3).setString("per", var1);
      } else if (var5 != null && !var5.isEmpty() && var5.equals("*****")) {
         var14 = var10.createQuery("from SalariesVariables where salvarFeuille=:feu and salvarCode=:rub and salvarPeriode=:per and (Salaries.salService is null or Salaries.salService='') order by salvarCode asc").setString("feu", var12).setString("rub", var3).setString("per", var1);
      } else if (var4 != null && !var4.isEmpty() && !var4.equals("*****")) {
         var14 = var10.createQuery("from SalariesVariables where salvarFeuille=:feu and salvarCode=:rub and salvarPeriode=:per order by salvarCode asc").setString("feu", var4).setString("rub", var3).setString("per", var1);
      } else if (var4 != null && !var4.isEmpty() && var4.equals("*****")) {
         var14 = var10.createQuery("from SalariesVariables where salvarFeuille=:feu and salvarCode=:rub and salvarPeriode=:per and (Salaries.salActivite is null or Salaries.salActivite='') order by salvarCode asc").setString("feu", var12).setString("rub", var3).setString("per", var1);
      } else if (var6 != null && !var6.isEmpty() && !var6.equals("*****")) {
         var14 = var10.createQuery("from SalariesVariables where salvarFeuille=:feu and salvarCode=:rub and salvarPeriode=:per order by salvarCode asc").setString("feu", var6).setString("rub", var3).setString("per", var1);
      } else if (var6 != null && !var6.isEmpty() && var6.equals("*****")) {
         var14 = var10.createQuery("from SalariesVariables where salvarFeuille=:feu and salvarCode=:rub and salvarPeriode=:per and (Salaries.salProjet is null or Salaries.salProjet='') order by salvarCode asc").setString("feu", var12).setString("rub", var3).setString("per", var1);
      } else if (var7 != 0L) {
         String var15 = "" + var7;
         var14 = var10.createQuery("from SalariesVariables where salvarFeuille=:feu and salvarCode=:rub and salvarPeriode=:per order by salvarCode asc").setString("feu", var15).setString("rub", var3).setString("per", var1);
      } else {
         var14 = var10.createQuery("from SalariesVariables where salvarFeuille=:feu and salvarCode=:rub and salvarPeriode=:per order by salvarCode asc").setString("feu", var2).setString("rub", var3).setString("per", var1);
      }

      List var16 = var14.list();
      if (var11) {
         this.utilInitHibernate.closeSession();
      }

      return var16;
   }

   public List chargerlesVariablesFeuilleProjets(String var1, String var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var6 = true;
      }

      new ArrayList();
      Query var8 = var5.createQuery("from SalariesVariables where Salaries.salFeuille=:feu and salvarCode=:rub and salvarPeriode=:per and salvarContrat in " + var4 + " order by salvarCode asc").setString("feu", var2).setString("rub", var3).setString("per", var1);
      List var7 = var8.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public SalariesVariables pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var4 = true;
      }

      Query var5 = var3.createQuery("from SalariesVariables where salvarId =:num").setLong("num", var1).setMaxResults(1);
      List var6 = var5.list();
      SalariesVariables var7 = null;
      if (var6.size() != 0) {
         var7 = (SalariesVariables)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public SalariesVariables chargerlesVariablesPeriodeRubrique(Salaries var1, String var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var6 = true;
      }

      new ArrayList();
      Query var8 = null;
      if (var3 != null && !var3.isEmpty()) {
         var8 = var5.createQuery("from SalariesVariables where Salaries=:salarie and salvarPeriode=:per and salvarCode=:rub and (salvarContrat=:crt or salvarContrat is null) order by salvarCode asc").setParameter("salarie", var1).setString("per", var2).setString("rub", var4).setString("crt", var3).setMaxResults(1);
      } else {
         var8 = var5.createQuery("from SalariesVariables where Salaries=:salarie and salvarPeriode=:per and salvarCode=:rub  order by salvarCode asc").setParameter("salarie", var1).setString("per", var2).setString("rub", var4).setMaxResults(1);
      }

      List var7 = var8.list();
      this.salariesVariables = null;
      if (var7.size() != 0) {
         this.salariesVariables = (SalariesVariables)var7.get(0);
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return this.salariesVariables;
   }

   public List chargerlesVariablesARecopier(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from SalariesVariables where salvarPeriode=:per and Salaries.salId in " + var2 + " order by salvarCode asc").setString("per", var1);
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerlesVariables(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from SalariesVariables where salvarPeriode like '%" + var1 + "' order by salvarCode asc");
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerlesVariablesByExercice(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from SalariesVariables where salvarPeriode like '%" + var1 + "' order by salvarCode asc");
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerlesVariables(Salaries var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var4 = true;
      }

      String[] var5 = var2.split(":");
      String var6 = var5[1];
      new ArrayList();
      Query var8 = var3.createQuery("from SalariesVariables where salvarPeriode = '" + var2 + "' and Salaries=:salarie order by salvarCode asc").setParameter("salarie", var1);
      List var7 = var8.list();
      if (var7.size() == 0) {
         String var9 = "11:" + var6;
         var8 = var3.createQuery("from SalariesVariables where salvarPeriode = '" + var9 + "' and Salaries=:salarie order by salvarCode asc").setParameter("salarie", var1);
         var7 = var8.list();
         if (var7.size() == 0) {
            String var10 = "10:" + var6;
            var8 = var3.createQuery("from SalariesVariables where salvarPeriode = '" + var10 + "' and Salaries=:salarie order by salvarCode asc").setParameter("salarie", var1);
            var7 = var8.list();
            if (var7.size() == 0) {
               String var11 = "09:" + var6;
               var8 = var3.createQuery("from SalariesVariables where salvarPeriode = '" + var11 + "' and Salaries=:salarie order by salvarCode asc").setParameter("salarie", var1);
               var7 = var8.list();
               if (var7.size() == 0) {
                  String var12 = "08:" + var6;
                  var8 = var3.createQuery("from SalariesVariables where salvarPeriode = '" + var12 + "' and Salaries=:salarie order by salvarCode asc").setParameter("salarie", var1);
                  var7 = var8.list();
                  if (var7.size() == 0) {
                     String var13 = "07:" + var6;
                     var8 = var3.createQuery("from SalariesVariables where salvarPeriode = '" + var13 + "' and Salaries=:salarie order by salvarCode asc").setParameter("salarie", var1);
                     var7 = var8.list();
                     if (var7.size() == 0) {
                        String var14 = "06:" + var6;
                        var8 = var3.createQuery("from SalariesVariables where salvarPeriode = '" + var14 + "' and Salaries=:salarie order by salvarCode asc").setParameter("salarie", var1);
                        var7 = var8.list();
                        if (var7.size() == 0) {
                           String var15 = "06:" + var6;
                           var8 = var3.createQuery("from SalariesVariables where salvarPeriode = '" + var15 + "' and Salaries=:salarie order by salvarCode asc").setParameter("salarie", var1);
                           var7 = var8.list();
                           if (var7.size() == 0) {
                              String var16 = "05:" + var6;
                              var8 = var3.createQuery("from SalariesVariables where salvarPeriode = '" + var16 + "' and Salaries=:salarie order by salvarCode asc").setParameter("salarie", var1);
                              var7 = var8.list();
                              if (var7.size() == 0) {
                                 String var17 = "04:" + var6;
                                 var8 = var3.createQuery("from SalariesVariables where salvarPeriode = '" + var17 + "' and Salaries=:salarie order by salvarCode asc").setParameter("salarie", var1);
                                 var7 = var8.list();
                                 if (var7.size() == 0) {
                                    String var18 = "03:" + var6;
                                    var8 = var3.createQuery("from SalariesVariables where salvarPeriode = '" + var18 + "' and Salaries=:salarie order by salvarCode asc").setParameter("salarie", var1);
                                    var7 = var8.list();
                                    if (var7.size() == 0) {
                                       String var19 = "02:" + var6;
                                       var8 = var3.createQuery("from SalariesVariables where salvarPeriode = '" + var19 + "' and Salaries=:salarie order by salvarCode asc").setParameter("salarie", var1);
                                       var7 = var8.list();
                                       if (var7.size() == 0) {
                                          String var20 = "01:" + var6;
                                          var8 = var3.createQuery("from SalariesVariables where salvarPeriode = '" + var20 + "' and Salaries=:salarie order by salvarCode asc").setParameter("salarie", var1);
                                          var7 = var8.list();
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerlesVariablesByRequeteVirement(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from SalariesVariables where " + var1 + " and salvar_code ='600000' order by Salaries.salNumBanque15,Salaries.salMatricule asc");
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }
}
