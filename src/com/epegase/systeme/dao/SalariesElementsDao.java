package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Salaries;
import com.epegase.systeme.classe.SalariesElements;
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

public class SalariesElementsDao implements Serializable {
   private SalariesElements salariesElements;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public SalariesElementsDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public SalariesElements insert(SalariesElements var1) throws HibernateException, NamingException {
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

   public SalariesElements insert(SalariesElements var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public SalariesElements modif(SalariesElements var1) throws HibernateException, NamingException {
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

   public SalariesElements modif(SalariesElements var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(SalariesElements var1) throws HibernateException, NamingException {
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

   public void delete(SalariesElements var1, Session var2) {
      var2.delete(var1);
   }

   public SalariesElements chargerlesVariablesPeriode(Salaries var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var5 = true;
      }

      this.salariesElements = new SalariesElements();
      new ArrayList();
      Query var7 = null;
      if (var3 != null && !var3.isEmpty()) {
         var7 = var4.createQuery("from SalariesElements where Salaries=:salarie and salelePeriode=:per and (saleleContrat=:crt or saleleContrat is null or saleleContrat='')").setParameter("salarie", var1).setString("per", var2).setString("crt", var3).setMaxResults(1);
      } else {
         var7 = var4.createQuery("from SalariesElements where Salaries=:salarie and salelePeriode=:per").setParameter("salarie", var1).setString("per", var2).setMaxResults(1);
      }

      List var6 = var7.list();
      if (var6.size() != 0) {
         this.salariesElements = (SalariesElements)var6.get(0);
      } else {
         this.salariesElements = null;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return this.salariesElements;
   }

   public SalariesElements chargerlesVariablesDate(Salaries var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var4 = true;
      }

      this.salariesElements = new SalariesElements();
      new ArrayList();
      Query var6 = var3.createQuery("from SalariesElements where Salaries=:salarie and saleleJour=:per").setParameter("salarie", var1).setDate("per", var2).setMaxResults(1);
      List var5 = var6.list();
      if (var5.size() != 0) {
         this.salariesElements = (SalariesElements)var5.get(0);
      } else {
         this.salariesElements = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.salariesElements;
   }

   public List chargerlesElementsBySalaries(String var1, String var2, Salaries var3, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var6 = true;
      }

      new ArrayList();
      Query var8 = var5.createQuery("from SalariesElements where Salaries=:sal and salelePeriode>=:d1 and salelePeriode<=:d2 and (saleleContrat=:crt or saleleContrat is null)").setParameter("sal", var3).setString("d1", var1).setString("d2", var2).setString("crt", var4);
      List var7 = var8.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
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
         var7 = var4.createQuery("from SalariesElements where saleleFeuille=:feu and saleleJour=:d1  order by Salaries.salMatricule asc").setString("feu", var3).setDate("d1", var1);
      } else {
         var7 = var4.createQuery("from SalariesElements where saleleFeuille=:feu and saleleJour=:d1  order by Salaries.salNom,Salaries.salPrenom asc").setString("feu", var3).setDate("d1", var1);
      }

      List var6 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerlesElementsByJournaliers(Salaries var1, Date var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var5 = true;
      }

      new ArrayList();
      Query var7 = var4.createQuery("from SalariesElements where Salaries=:sal and saleleFeuille=:feu and saleleJour=:d1").setParameter("sal", var1).setString("feu", var3).setDate("d1", var2);
      List var6 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerlesElementsBySalaries(Salaries var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from SalariesElements where Salaries=:sal and (saleleContrat=:crt or saleleContrat is null)").setParameter("sal", var1).setString("crt", var2);
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerlesElementsBySalaries(Salaries var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from SalariesElements where Salaries=:sal").setParameter("sal", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerlesElements(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var2 = true;
      }

      new ArrayList();
      Query var4 = var1.createQuery("from SalariesElements");
      List var3 = var4.list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public boolean testelesVariablesPeriode(Salaries var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var5 = true;
      }

      this.salariesElements = new SalariesElements();
      new ArrayList();
      Query var7 = null;
      if (var3 != null && !var3.isEmpty()) {
         var7 = var4.createQuery("from SalariesElements where Salaries=:salarie and salelePeriode=:per and (saleleContrat=:crt or saleleContrat is null or saleleContrat='')").setParameter("salarie", var1).setString("per", var2).setString("crt", var3).setMaxResults(1);
      } else {
         var7 = var4.createQuery("from SalariesElements where Salaries=:salarie and salelePeriode=:per").setParameter("salarie", var1).setString("per", var2).setMaxResults(1);
      }

      List var6 = var7.list();
      boolean var8 = false;
      if (var6.size() != 0) {
         var8 = true;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public SalariesElements pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var4 = true;
      }

      Query var5 = var3.createQuery("from SalariesElements where saleleId =:num").setLong("num", var1).setMaxResults(1);
      List var6 = var5.list();
      SalariesElements var7 = null;
      if (var6.size() != 0) {
         var7 = (SalariesElements)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public SalariesElements chargerlesDerniersElements(Salaries var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      this.salariesElements = new SalariesElements();
      new ArrayList();
      Query var5 = var2.createQuery("from SalariesElements where Salaries=:salarie order by salelePeriode desc").setParameter("salarie", var1).setMaxResults(1);
      List var4 = var5.list();
      if (var4.size() != 0) {
         this.salariesElements = (SalariesElements)var4.get(0);
      } else {
         this.salariesElements = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return this.salariesElements;
   }

   public List chargerlesElementsByBanque(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var2 = true;
      }

      new ArrayList();
      Query var4 = var1.createQuery("from SalariesElements where saleleModeReglement=2 group by saleleNumBanque order by saleleNumBanque");
      List var3 = var4.list();
      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var3.size(); ++var6) {
            if (((SalariesElements)var3.get(var6)).getSaleleNumBanque() != null && !((SalariesElements)var3.get(var6)).getSaleleNumBanque().isEmpty()) {
               var5.add(((SalariesElements)var3.get(var6)).getSaleleNumBanque());
            }
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerlesElements(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from SalariesElements where salelePeriode like '%" + var1 + "'");
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerlesElements(Salaries var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var4 = true;
      }

      String[] var5 = var2.split(":");
      String var6 = var5[1];
      new ArrayList();
      Query var8 = var3.createQuery("from SalariesElements where salelePeriode = '" + var2 + "' and Salaries=:salarie").setParameter("salarie", var1);
      List var7 = var8.list();
      if (var7.size() == 0) {
         String var9 = "10:" + var6;
         var8 = var3.createQuery("from SalariesElements where salelePeriode = '" + var9 + "' and Salaries=:salarie").setParameter("salarie", var1);
         var7 = var8.list();
         if (var7.size() == 0) {
            String var10 = "09:" + var6;
            var8 = var3.createQuery("from SalariesElements where salelePeriode = '" + var10 + "' and Salaries=:salarie").setParameter("salarie", var1);
            var7 = var8.list();
            if (var7.size() == 0) {
               String var11 = "08:" + var6;
               var8 = var3.createQuery("from SalariesElements where salelePeriode = '" + var11 + "' and Salaries=:salarie").setParameter("salarie", var1);
               var7 = var8.list();
               if (var7.size() == 0) {
                  String var12 = "07:" + var6;
                  var8 = var3.createQuery("from SalariesElements where salelePeriode = '" + var12 + "' and Salaries=:salarie").setParameter("salarie", var1);
                  var7 = var8.list();
                  if (var7.size() == 0) {
                     String var13 = "06:" + var6;
                     var8 = var3.createQuery("from SalariesElements where salelePeriode = '" + var13 + "' and Salaries=:salarie").setParameter("salarie", var1);
                     var7 = var8.list();
                     if (var7.size() == 0) {
                        String var14 = "06:" + var6;
                        var8 = var3.createQuery("from SalariesElements where salelePeriode = '" + var14 + "' and Salaries=:salarie").setParameter("salarie", var1);
                        var7 = var8.list();
                        if (var7.size() == 0) {
                           String var15 = "05:" + var6;
                           var8 = var3.createQuery("from SalariesElements where salelePeriode = '" + var15 + "' and Salaries=:salarie").setParameter("salarie", var1);
                           var7 = var8.list();
                           if (var7.size() == 0) {
                              String var16 = "04:" + var6;
                              var8 = var3.createQuery("from SalariesElements where salelePeriode = '" + var16 + "' and Salaries=:salarie").setParameter("salarie", var1);
                              var7 = var8.list();
                              if (var7.size() == 0) {
                                 String var17 = "03:" + var6;
                                 var8 = var3.createQuery("from SalariesElements where salelePeriode = '" + var17 + "' and Salaries=:salarie").setParameter("salarie", var1);
                                 var7 = var8.list();
                                 if (var7.size() == 0) {
                                    String var18 = "02:" + var6;
                                    var8 = var3.createQuery("from SalariesElements where salelePeriode = '" + var18 + "' and Salaries=:salarie").setParameter("salarie", var1);
                                    var7 = var8.list();
                                    if (var7.size() == 0) {
                                       String var19 = "01:" + var6;
                                       var8 = var3.createQuery("from SalariesElements where salelePeriode = '" + var19 + "' and Salaries=:salarie").setParameter("salarie", var1);
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

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }
}
