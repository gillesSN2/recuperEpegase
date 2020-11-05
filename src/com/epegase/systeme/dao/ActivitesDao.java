package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Activites;
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

public class ActivitesDao implements Serializable {
   private Activites activites;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public ActivitesDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public Activites insert(Activites var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Activites");
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

   public Activites insert(Activites var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public Activites modif(Activites var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Activites");
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

   public void delete(Activites var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Activites");
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

   public void delete(Activites var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List selectActivites(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Activites");
         var2 = true;
      }

      List var3 = var1.createQuery("from Activites order by actCode asc").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List selectActivites(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Activites");
         var3 = true;
      }

      List var4 = var2.createQuery("from Activites where actColonne='" + var1 + "' order by actCode asc").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List selectActivitesByCode(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Activites");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Activites where actCode like '" + var1 + "%'");
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesActivites(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Activites");
         var2 = true;
      }

      List var3 = var1.createQuery("from Activites where actInactif=0 order by actCode asc").list();
      List var4 = var3;
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var5.add(new SelectItem(((Activites)var4.get(var6)).getActCode() + ":" + ((Activites)var4.get(var6)).getActNomFr()));
         }
      }

      return var5;
   }

   public List chargerLesActivitesByCode(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Activites");
         var2 = true;
      }

      List var3 = var1.createQuery("from Activites where actInactif=0 order by actCode asc").list();
      List var4 = var3;
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var5.add(new SelectItem(((Activites)var4.get(var6)).getActCode(), ((Activites)var4.get(var6)).getActCode() + ":" + ((Activites)var4.get(var6)).getActNomFr()));
         }
      }

      return var5;
   }

   public List chargerLesDecoupages(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Activites");
         var3 = true;
      }

      List var4 = var2.createQuery("from Activites where actInactif=0 and actColonne='" + var1 + "' order by actCode asc").list();
      List var5 = var4;
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var6 = new ArrayList();
      if (var4.size() != 0) {
         for(int var7 = 0; var7 < var5.size(); ++var7) {
            var6.add(new SelectItem(((Activites)var5.get(var7)).getActCode() + ":" + ((Activites)var5.get(var7)).getActNomFr()));
         }
      }

      return var6;
   }

   public List chargerLesDecoupagesLies(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Activites");
         var4 = true;
      }

      String var5 = "";
      String[] var6;
      if (var2 != null && !var2.isEmpty()) {
         if (var2.contains(":")) {
            var6 = var2.split(":");
            var5 = var6[0];
         } else {
            var5 = var2;
         }
      } else {
         var5 = "";
      }

      var6 = null;
      List var10;
      if (var5 != null && !var5.isEmpty()) {
         var10 = var3.createQuery("from Activites where actInactif=0 and actColonne='" + var1 + "' and actCode like '" + var5 + "-%' order by actCode asc").list();
      } else {
         var10 = var3.createQuery("from Activites where actInactif=0 and actColonne='" + var1 + "' order by actCode asc").list();
      }

      List var7 = var10;
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var8 = new ArrayList();
      if (var10.size() != 0) {
         for(int var9 = 0; var9 < var7.size(); ++var9) {
            var8.add(new SelectItem(((Activites)var7.get(var9)).getActCode() + ":" + ((Activites)var7.get(var9)).getActNomFr()));
         }
      }

      return var8;
   }

   public List chargerLesActivites(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Activites");
         var3 = true;
      }

      List var4 = var2.createQuery("from Activites where actCle in(0,1) and ((actAnneeDebut=0 or actAnneeFin=0) or (actAnneeFin <='" + var1 + "' or actAnneeDebut >='" + var1 + "')) and actInactif=0 order by actCle asc, actCode asc").list();
      List var5 = var4;
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var6 = new ArrayList();
      if (var4.size() != 0) {
         for(int var7 = 0; var7 < var5.size(); ++var7) {
            var6.add(new SelectItem(((Activites)var5.get(var7)).getActCode() + ":" + ((Activites)var5.get(var7)).getActNomFr()));
         }
      }

      return var6;
   }

   public Activites rechercheActivite(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Activites");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Activites where actCode=:cod").setString("cod", var1).setMaxResults(1);
      List var5 = var4.list();
      new Activites();
      Activites var6;
      if (var5.size() > 0) {
         var6 = (Activites)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public Activites rechercheActivite(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Activites");
         var4 = true;
      }

      Query var5 = var3.createQuery("from Activites ja where ja.actId=:id").setLong("id", var1);
      var5.setMaxResults(1);
      List var6 = var5.list();
      new Activites();
      Activites var7;
      if (var6.size() > 0) {
         var7 = (Activites)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public boolean existCode(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Activites");
         var3 = true;
      }

      boolean var4 = false;
      Query var5 = var2.createQuery("from Activites ja where ja.actCode=:cod").setString("cod", var1);
      var5.setMaxResults(1);
      List var6 = var5.list();
      if (var6.size() > 0) {
         var4 = true;
      } else {
         var4 = false;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }
}
