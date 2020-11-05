package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Activites;
import com.epegase.systeme.classe.ModelesCourriers;
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

public class ModelesCourriersDao implements Serializable {
   private ModelesCourriers modelesCourriers;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public ModelesCourriersDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public Activites insert(Activites var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ModelesCourriers");
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

   public ModelesCourriers insert(ModelesCourriers var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public ModelesCourriers modif(ModelesCourriers var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ModelesCourriers");
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

   public ModelesCourriers modif(ModelesCourriers var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public String delete(ModelesCourriers var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ModelesCourriers");
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

      return null;
   }

   public void delete(ModelesCourriers var1, Session var2) {
      var2.delete(var1);
   }

   public List selectModelesPaye(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "ModelesCourriers");
         var2 = true;
      }

      List var3 = var1.createQuery("from ModelesCourriers where modNature>=80 and modNature<= 90 order by modCode asc").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerLesModelesPaye(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "ModelesCourriers");
         var2 = true;
      }

      List var3 = var1.createQuery("from ModelesCourriers where modNature>=80 and modNature<= 90 and modInactif=0").list();
      List var4 = var3;
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var5.add(new SelectItem(((ModelesCourriers)var4.get(var6)).getModCode() + ":" + ((ModelesCourriers)var4.get(var6)).getModNomFr()));
         }
      }

      return var5;
   }

   public List selectModelesVentes(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "ModelesCourriers");
         var2 = true;
      }

      List var3 = var1.createQuery("from ModelesCourriers where modNature<=24 and modInactif=0").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerLesModelesVentes(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "ModelesCourriers");
         var2 = true;
      }

      List var3 = var1.createQuery("from ModelesCourriers where modNature<=24 and modInactif=0").list();
      List var4 = var3;
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var5.add(new SelectItem(((ModelesCourriers)var4.get(var6)).getModCode() + ":" + ((ModelesCourriers)var4.get(var6)).getModNomFr()));
         }
      }

      return var5;
   }

   public List selectContratsVentes(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "ModelesCourriers");
         var2 = true;
      }

      List var3 = var1.createQuery("from ModelesCourriers where modNature=25 order by modCode asc").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerLesContratsVentes(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "ModelesCourriers");
         var2 = true;
      }

      List var3 = var1.createQuery("from ModelesCourriers where modNature=25 and modInactif=0").list();
      List var4 = var3;
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var5.add(new SelectItem(((ModelesCourriers)var4.get(var6)).getModCode() + ":" + ((ModelesCourriers)var4.get(var6)).getModNomFr()));
         }
      }

      return var5;
   }

   public List selectContratsVentesByType(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ModelesCourriers");
         var3 = true;
      }

      List var4 = var2.createQuery("from ModelesCourriers where modNature=25 and modType=:typ order by modCode asc").setInteger("typ", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesContratsVentesByType(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ModelesCourriers");
         var3 = true;
      }

      List var4 = var2.createQuery("from ModelesCourriers where modNature=25 and modType=:typ and modInactif=0").setInteger("typ", var1).list();
      List var5 = var4;
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var6 = new ArrayList();
      if (var4.size() != 0) {
         for(int var7 = 0; var7 < var5.size(); ++var7) {
            var6.add(new SelectItem(((ModelesCourriers)var5.get(var7)).getModCode() + ":" + ((ModelesCourriers)var5.get(var7)).getModNomFr()));
         }
      }

      return var6;
   }

   public List chargerLesModeles(int var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "ModelesCourriers");
         var4 = true;
      }

      boolean var5 = false;
      int var10;
      if (!var2.equals("05") && !var2.equals("11")) {
         if (!var2.equals("01D") && !var2.equals("02D") && !var2.equals("03D")) {
            if (!var2.equals("01I") && !var2.equals("02I") && !var2.equals("03I")) {
               if (!var2.equals("13") && !var2.equals("14")) {
                  if (!var2.equals("04") && !var2.equals("12") && !var2.equals("20") && !var2.equals("99")) {
                     var10 = Integer.parseInt(var2);
                  } else {
                     var10 = 4;
                  }
               } else {
                  var10 = 3;
               }
            } else {
               var10 = 2;
            }
         } else {
            var10 = 1;
         }
      } else {
         var10 = 0;
      }

      List var6 = var3.createQuery("from ModelesCourriers where modInactif=0 and modNature=:nat and modType=:typ").setInteger("nat", var1).setInteger("typ", var10).list();
      List var7 = var6;
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var8 = new ArrayList();
      if (var6.size() != 0) {
         for(int var9 = 0; var9 < var7.size(); ++var9) {
            var8.add(new SelectItem(((ModelesCourriers)var7.get(var9)).getModCode(), ((ModelesCourriers)var7.get(var9)).getModCode() + ":" + ((ModelesCourriers)var7.get(var9)).getModNomFr()));
         }
      }

      return var8;
   }

   public List chargerLesModelesDocument(int var1, int var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "ModelesCourriers");
         var4 = true;
      }

      List var5 = var3.createQuery("from ModelesCourriers where modInactif=0 and modType=:cod").setInteger("cod", var2).list();
      List var6 = var5;
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var7 = new ArrayList();
      if (var5.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            var7.add(new SelectItem(((ModelesCourriers)var6.get(var8)).getModCode(), ((ModelesCourriers)var6.get(var8)).getModCode() + ":" + ((ModelesCourriers)var6.get(var8)).getModNomFr()));
         }
      }

      return var7;
   }

   public ModelesCourriers rechercheModeles(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ModelesCourriers");
         var3 = true;
      }

      Query var4 = var2.createQuery("from ModelesCourriers where modCode=:cod").setString("cod", var1).setMaxResults(1);
      List var5 = var4.list();
      new ModelesCourriers();
      ModelesCourriers var6;
      if (var5.size() > 0) {
         var6 = (ModelesCourriers)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public boolean existCode(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ModelesCourriers");
         var3 = true;
      }

      boolean var4 = false;
      Query var5 = var2.createQuery("from ModelesCourriers  where modCode=:cod").setString("cod", var1);
      var5.setMaxResults(1);
      List var6 = var5.list();
      if (var6.size() > 0) {
         var4 = false;
      } else {
         var4 = true;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public String getMaBase() {
      return this.maBase;
   }

   public void setMaBase(String var1) {
      this.maBase = var1;
   }
}
