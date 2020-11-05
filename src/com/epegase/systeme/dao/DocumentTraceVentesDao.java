package com.epegase.systeme.dao;

import com.epegase.systeme.classe.DocumentTraceVentes;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class DocumentTraceVentesDao implements Serializable {
   private DocumentTraceVentes documentTraceVentes;
   private ExercicesVentes exercicesVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public DocumentTraceVentesDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public DocumentTraceVentes insert(DocumentTraceVentes var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public DocumentTraceVentes modif(DocumentTraceVentes var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(DocumentTraceVentes var1, Session var2) {
      var2.delete(var1);
   }

   public List chargerLesDocumentsTrace(long var1, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "DocumentTraceVentes");
         var5 = true;
      }

      List var6 = var4.createQuery("from DocumentTraceVentes where (doctraOrgId='" + var1 + "' and doctraOrgType=" + var3 + ")  or (doctraDstId='" + var1 + "' and doctraDstType=" + var3 + ")").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesDocumentsTraceOrigine(long var1, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "DocumentTraceVentes");
         var5 = true;
      }

      List var6 = var4.createQuery("from DocumentTraceVentes where (doctraOrgId='" + var1 + "' and doctraOrgType=" + var3 + ")").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesDocumentsTraceDestination(long var1, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "DocumentTraceVentes");
         var5 = true;
      }

      List var6 = var4.createQuery("from DocumentTraceVentes where (doctraDstId='" + var1 + "' and doctraDstType=" + var3 + ")").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesDocumentsTrace(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "DocumentTraceVentes");
         var2 = true;
      }

      List var3 = var1.createQuery("from DocumentTraceVentes").list();
      new ArrayList();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public DocumentTraceVentes chercherOrigineTrace(long var1, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "DocumentTraceVentes");
         var5 = true;
      }

      List var6 = var4.createQuery("from DocumentTraceVentes where doctraOrgId='" + var1 + "' and doctraDstType=" + var3).setMaxResults(1).list();
      DocumentTraceVentes var8 = null;
      if (var6.size() != 0) {
         var8 = (DocumentTraceVentes)var6.get(0);
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public DocumentTraceVentes chercherDestinationTrace(long var1, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "DocumentTraceVentes");
         var5 = true;
      }

      List var6 = var4.createQuery("from DocumentTraceVentes where doctraDstId='" + var1 + "' and doctraDstType=" + var3).setMaxResults(1).list();
      DocumentTraceVentes var8 = null;
      if (var6.size() != 0) {
         var8 = (DocumentTraceVentes)var6.get(0);
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List chercherDestinationTraceListe(long var1, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "DocumentTraceVentes");
         var5 = true;
      }

      new ArrayList();
      List var7 = var4.createQuery("from DocumentTraceVentes where doctraDstId='" + var1 + "' and doctraDstType=" + var3).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List listeDestinationTrace(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "DocumentTraceVentes");
         var3 = true;
      }

      List var4 = var2.createQuery("from DocumentTraceVentes where doctraDstType=" + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List listeOrigineTrace(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "DocumentTraceVentes");
         var3 = true;
      }

      List var4 = var2.createQuery("from DocumentTraceVentes where doctraOrgType=" + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List nettoyageTrace(Date var1, Date var2, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "DocumentTraceVentes");
         var5 = true;
      }

      List var6 = var4.createQuery("from DocumentTraceVentes where (doctraOrgType=" + var3 + " and doctraOrgDate>=:deb and doctraOrgDate<=:fin) or (doctraDstType=" + var3 + " and doctraDstDate>=:deb and doctraDstDate<=:fin)").setDate("deb", var1).setDate("fin", var2).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
