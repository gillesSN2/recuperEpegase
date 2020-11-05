package com.epegase.systeme.dao;

import com.epegase.systeme.classe.DocumentMediatheque;
import com.epegase.systeme.util.UtilInitHibernate;
import groovyjarjarcommonscli.ParseException;
import java.io.Serializable;
import java.util.ArrayList;
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

public class DocumentMediathequeDao implements Serializable {
   private DocumentMediatheque documentMediatheque;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public DocumentMediathequeDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public DocumentMediatheque insert(DocumentMediatheque var1) throws HibernateException, NamingException {
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

   public DocumentMediatheque insert(DocumentMediatheque var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public DocumentMediatheque modif(DocumentMediatheque var1) throws HibernateException, NamingException {
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

   public DocumentMediatheque modif(DocumentMediatheque var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(DocumentMediatheque var1) throws HibernateException, NamingException {
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

   public void delete(DocumentMediatheque var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List recherche(Session var1, String var2, String var3, String var4, String var5, String var6) throws HibernateException, NamingException, ParseException {
      boolean var7 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "ClassementMediatheque");
         var7 = true;
      }

      new ArrayList();
      Criteria var9 = var1.createCriteria(DocumentMediatheque.class);
      String[] var10;
      String var11;
      if (var2 != null && !var2.isEmpty()) {
         var10 = var2.split(":");
         var11 = var10[0] + "%";
         var9 = var9.add(Restrictions.like("docmedClasse", var11));
      }

      if (var3 != null && !var3.isEmpty()) {
         var10 = var3.split(":");
         var11 = var10[0] + "%";
         var9 = var9.add(Restrictions.like("docmedDivision", var11));
      }

      if (var4 != null && !var4.isEmpty()) {
         var10 = var4.split(":");
         var11 = var10[0] + "%";
         var9 = var9.add(Restrictions.like("docmedSupport", var11));
      }

      if (var5 != null && !var5.isEmpty()) {
         var10 = var5.split(":");
         var11 = var10[0] + "%";
         var9 = var9.add(Restrictions.like("docmedContenant", var11));
      }

      if (var6 != null && !var6.isEmpty()) {
         var10 = var6.split(":");
         var11 = var10[0] + "%";
         var9 = var9.add(Restrictions.like("docmedType", var11));
      }

      var9 = var9.addOrder(Order.desc("docmedNum"));
      List var8 = var9.list();
      if (var7) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List selectDocumentMediatheque(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "ClassementMediatheque");
         var2 = true;
      }

      List var3 = var1.createQuery("from DocumentMediatheque order by docmedNum asc").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerLesDocumentMediatheque(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "ClassementMediatheque");
         var2 = true;
      }

      List var3 = var1.createQuery("from DocumentMediatheque order by docmedNum asc").list();
      List var4 = var3;
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var5.add(new SelectItem(((DocumentMediatheque)var4.get(var6)).getDocmedNum() + ":" + ((DocumentMediatheque)var4.get(var6)).getDocmedTitre()));
         }
      }

      return var5;
   }

   public List chargerLesClasses(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "ClassementMediatheque");
         var2 = true;
      }

      List var3 = var1.createQuery("from DocumentMediatheque group by docmedClasse order by docmedCode").list();
      List var4 = var3;
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            if (((DocumentMediatheque)var4.get(var6)).getDocmedClasse() != null && !((DocumentMediatheque)var4.get(var6)).getDocmedClasse().isEmpty()) {
               var5.add(new SelectItem(((DocumentMediatheque)var4.get(var6)).getDocmedClasse()));
            }
         }
      }

      return var5;
   }

   public List chargerLesDivisions(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "ClassementMediatheque");
         var2 = true;
      }

      List var3 = var1.createQuery("from DocumentMediatheque where docmedDivision is not null and docmedDivision<> '' group by docmedDivision order by docmedCode").list();
      List var4 = var3;
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            if (((DocumentMediatheque)var4.get(var6)).getDocmedDivision() != null && !((DocumentMediatheque)var4.get(var6)).getDocmedDivision().isEmpty()) {
               var5.add(new SelectItem(((DocumentMediatheque)var4.get(var6)).getDocmedDivision()));
            }
         }
      }

      return var5;
   }

   public List chargerLesDivisions(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ClassementMediatheque");
         var3 = true;
      }

      List var4 = var2.createQuery("from DocumentMediatheque where docmedCode=:cd order by docmedCode").setString("cd", var1).list();
      List var5 = var4;
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var6 = new ArrayList();
      if (var4.size() != 0) {
         for(int var7 = 0; var7 < var5.size(); ++var7) {
            var6.add(new SelectItem(((DocumentMediatheque)var5.get(var7)).getDocmedDivision()));
         }
      }

      return var6;
   }

   public List chargerLesTypes(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "ClassementMediatheque");
         var2 = true;
      }

      List var3 = var1.createQuery("from DocumentMediatheque where docmedType is not null and docmedType<>'' group by docmedType").list();
      List var4 = var3;
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            if (((DocumentMediatheque)var4.get(var6)).getDocmedType() != null && !((DocumentMediatheque)var4.get(var6)).getDocmedType().isEmpty()) {
               var5.add(new SelectItem(((DocumentMediatheque)var4.get(var6)).getDocmedType()));
            }
         }
      }

      return var5;
   }

   public List chargerLesSupports(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "ClassementMediatheque");
         var2 = true;
      }

      List var3 = var1.createQuery("from DocumentMediatheque where docmedSupport is not null and docmedSupport<>'' group by docmedSupport").list();
      List var4 = var3;
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            if (((DocumentMediatheque)var4.get(var6)).getDocmedSupport() != null && !((DocumentMediatheque)var4.get(var6)).getDocmedSupport().isEmpty()) {
               var5.add(new SelectItem(((DocumentMediatheque)var4.get(var6)).getDocmedSupport()));
            }
         }
      }

      return var5;
   }

   public List chargerLesContenants(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "ClassementMediatheque");
         var2 = true;
      }

      List var3 = var1.createQuery("from DocumentMediatheque where docmedContenant is not null and docmedContenant<>'' group by docmedContenant").list();
      List var4 = var3;
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            if (((DocumentMediatheque)var4.get(var6)).getDocmedContenant() != null && !((DocumentMediatheque)var4.get(var6)).getDocmedContenant().isEmpty()) {
               var5.add(new SelectItem(((DocumentMediatheque)var4.get(var6)).getDocmedContenant()));
            }
         }
      }

      return var5;
   }

   public DocumentMediatheque rechercheActivite(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ClassementMediatheque");
         var3 = true;
      }

      Query var4 = var2.createQuery("from DocumentMediatheque where docmedNum=:cod").setString("cod", var1).setMaxResults(1);
      List var5 = var4.list();
      new DocumentMediatheque();
      DocumentMediatheque var6;
      if (var5.size() > 0) {
         var6 = (DocumentMediatheque)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public DocumentMediatheque rechercheActivite(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "ClassementMediatheque");
         var4 = true;
      }

      Query var5 = var3.createQuery("from DocumentMediatheque ja where ja.docmedId=:id").setLong("id", var1);
      var5.setMaxResults(1);
      List var6 = var5.list();
      new DocumentMediatheque();
      DocumentMediatheque var7;
      if (var6.size() > 0) {
         var7 = (DocumentMediatheque)var6.get(0);
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
      Query var5 = var2.createQuery("from DocumentMediatheque ja where ja.docmedNum=:cod").setString("cod", var1);
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
