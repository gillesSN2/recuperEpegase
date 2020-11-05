package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ClassementMediatheque;
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

public class ClassementMediathequeDao implements Serializable {
   private ClassementMediatheque classementMediatheque;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public ClassementMediathequeDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public ClassementMediatheque insert(ClassementMediatheque var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ClassementMediatheque");
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

   public ClassementMediatheque insert(ClassementMediatheque var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public ClassementMediatheque modif(ClassementMediatheque var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ClassementMediatheque");
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

   public void delete(ClassementMediatheque var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ClassementMediatheque");
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

   public void delete(ClassementMediatheque var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List selectClassementMediatheque(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "ClassementMediatheque");
         var2 = true;
      }

      List var3 = var1.createQuery("from ClassementMediatheque order by clamedCode asc").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerLesClasses(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ClassementMediatheque");
         var3 = true;
      }

      List var4 = var2.createQuery("from ClassementMediatheque where clamedType=" + var1 + " group by clamedSujet order by clamedCode").list();
      List var5 = var4;
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var6 = new ArrayList();
      if (var4.size() != 0) {
         for(int var7 = 0; var7 < var5.size(); ++var7) {
            if (((ClassementMediatheque)var5.get(var7)).getClamedCode() != null && !((ClassementMediatheque)var5.get(var7)).getClamedCode().isEmpty()) {
               var6.add(new SelectItem(((ClassementMediatheque)var5.get(var7)).getClamedCode() + ":" + ((ClassementMediatheque)var5.get(var7)).getClamedSujet()));
            }
         }
      }

      return var6;
   }

   public List chargerLesDivisions(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ClassementMediatheque");
         var3 = true;
      }

      String var4 = var1.substring(0, 1);
      List var5 = var2.createQuery("from ClassementMediatheque where clamedType=0 and clamedCode like '" + var4 + "%' order by clamedCode").list();
      List var6 = var5;
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var7 = new ArrayList();
      if (var5.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            var7.add(new SelectItem(((ClassementMediatheque)var6.get(var8)).getClamedCode() + ":" + ((ClassementMediatheque)var6.get(var8)).getClamedTheme()));
         }
      }

      return var7;
   }

   public List chargerLesContenants(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ClassementMediatheque");
         var3 = true;
      }

      String[] var4 = var1.split(":");
      List var5 = var2.createQuery("from ClassementMediatheque where clamedType=3 order by clamedCode").list();
      List var6 = var5;
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var7 = new ArrayList();
      if (var5.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            if (var4[0].equals("WEB") && (((ClassementMediatheque)var6.get(var8)).getClamedCode().equals("MP3") || ((ClassementMediatheque)var6.get(var8)).getClamedCode().equals("MP4") || ((ClassementMediatheque)var6.get(var8)).getClamedCode().equals("SIT") || ((ClassementMediatheque)var6.get(var8)).getClamedCode().equals("PDF") || ((ClassementMediatheque)var6.get(var8)).getClamedCode().equals("IMG") || ((ClassementMediatheque)var6.get(var8)).getClamedCode().equals("FIC"))) {
               var7.add(new SelectItem(((ClassementMediatheque)var6.get(var8)).getClamedCode() + ":" + ((ClassementMediatheque)var6.get(var8)).getClamedSujet()));
            } else if (!var4[0].equals("LOC") || !((ClassementMediatheque)var6.get(var8)).getClamedCode().equals("CAS") && !((ClassementMediatheque)var6.get(var8)).getClamedCode().equals("CD") && !((ClassementMediatheque)var6.get(var8)).getClamedCode().equals("DVD") && !((ClassementMediatheque)var6.get(var8)).getClamedCode().equals("CLE") && !((ClassementMediatheque)var6.get(var8)).getClamedCode().equals("PAP") && !((ClassementMediatheque)var6.get(var8)).getClamedCode().equals("PDF") && !((ClassementMediatheque)var6.get(var8)).getClamedCode().equals("IMG") && !((ClassementMediatheque)var6.get(var8)).getClamedCode().equals("FIC") && !((ClassementMediatheque)var6.get(var8)).getClamedCode().equals("VYN")) {
               if (var4[0].equals("YTB") && (((ClassementMediatheque)var6.get(var8)).getClamedCode().equals("MP3") || ((ClassementMediatheque)var6.get(var8)).getClamedCode().equals("MP4"))) {
                  var7.add(new SelectItem(((ClassementMediatheque)var6.get(var8)).getClamedCode() + ":" + ((ClassementMediatheque)var6.get(var8)).getClamedSujet()));
               }
            } else {
               var7.add(new SelectItem(((ClassementMediatheque)var6.get(var8)).getClamedCode() + ":" + ((ClassementMediatheque)var6.get(var8)).getClamedSujet()));
            }
         }
      }

      return var7;
   }

   public ClassementMediatheque rechercheActivite(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ClassementMediatheque");
         var3 = true;
      }

      Query var4 = var2.createQuery("from ClassementMediatheque where clamedCode=:cod").setString("cod", var1).setMaxResults(1);
      List var5 = var4.list();
      new ClassementMediatheque();
      ClassementMediatheque var6;
      if (var5.size() > 0) {
         var6 = (ClassementMediatheque)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public ClassementMediatheque rechercheActivite(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "ClassementMediatheque");
         var4 = true;
      }

      Query var5 = var3.createQuery("from ClassementMediatheque ja where ja.clamedId=:id").setLong("id", var1);
      var5.setMaxResults(1);
      List var6 = var5.list();
      new ClassementMediatheque();
      ClassementMediatheque var7;
      if (var6.size() > 0) {
         var7 = (ClassementMediatheque)var6.get(0);
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
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ClassementMediatheque");
         var3 = true;
      }

      boolean var4 = false;
      Query var5 = var2.createQuery("from ClassementMediatheque ja where ja.clamedCode=:cod").setString("cod", var1);
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
