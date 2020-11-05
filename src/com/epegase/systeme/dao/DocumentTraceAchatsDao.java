package com.epegase.systeme.dao;

import com.epegase.systeme.classe.DocumentTraceAchats;
import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class DocumentTraceAchatsDao implements Serializable {
   private DocumentTraceAchats documentTraceAchats;
   private ExercicesAchats exercicesAchats;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public DocumentTraceAchatsDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public DocumentTraceAchats insert(DocumentTraceAchats var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public void delete(DocumentTraceAchats var1, Session var2) {
      var2.delete(var1);
   }

   public List chargerLesDocumentsTrace(long var1, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "DocumentTraceAchats");
         var5 = true;
      }

      List var6 = var4.createQuery("from DocumentTraceAchats where doctrfOrgId='" + var1 + "' and doctrfOrgType=" + var3).list();
      List var7 = var6;
      List var8 = var4.createQuery("from DocumentTraceAchats where doctrfDstId='" + var1 + "' and doctrfDstType=" + var3).list();
      List var9 = var8;
      ArrayList var10 = new ArrayList();
      int var11;
      DocumentTraceAchats var12;
      if (var6.size() != 0) {
         for(var11 = 0; var11 < var7.size(); ++var11) {
            new DocumentTraceAchats();
            var12 = (DocumentTraceAchats)var7.get(var11);
            var10.add(var12);
         }
      }

      if (var8.size() != 0) {
         for(var11 = 0; var11 < var9.size(); ++var11) {
            new DocumentTraceAchats();
            var12 = (DocumentTraceAchats)var9.get(var11);
            var10.add(var12);
         }
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List chargerLesDocumentsTraceDestination(long var1, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "DocumentTraceAchats");
         var5 = true;
      }

      List var6 = var4.createQuery("from DocumentTraceAchats where (doctrfDstId='" + var1 + "' and doctrfDstType=" + var3 + ")").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesDocumentsTraceOrigine(long var1, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "DocumentTraceAchats");
         var5 = true;
      }

      List var6 = var4.createQuery("from DocumentTraceAchats where (doctrfOrgId='" + var1 + "' and doctrfOrgType=" + var3 + ")").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public DocumentTraceAchats chercherOrigineTrace(long var1, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "DocumentTraceAchats");
         var5 = true;
      }

      List var6 = var4.createQuery("from DocumentTraceAchats where doctrfOrgId='" + var1 + "' and doctrfDstType=" + var3).setMaxResults(1).list();
      DocumentTraceAchats var8 = null;
      if (var6.size() != 0) {
         var8 = (DocumentTraceAchats)var6.get(0);
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public DocumentTraceAchats chercherDestinationTrace(long var1, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "DocumentTraceAchats");
         var5 = true;
      }

      List var6 = var4.createQuery("from DocumentTraceAchats where doctrfDstId='" + var1 + "' and doctrfDstType=" + var3).setMaxResults(1).list();
      DocumentTraceAchats var8 = null;
      if (var6.size() != 0) {
         var8 = (DocumentTraceAchats)var6.get(0);
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List nettoyageTrace(Date var1, Date var2, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "DocumentTraceAchats");
         var5 = true;
      }

      List var6 = var4.createQuery("from DocumentTraceAchats where (doctrfDstType=" + var3 + "abd doctrfOrgDate>=:deb and doctrfOrgDate<=:fin) or (doctrfDstType=" + var3 + "abd doctrfDstDate>=:deb and doctrfDstDate<=:fin)").setDate("deb", var1).setDate("fin", var2).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
