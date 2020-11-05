package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesParc;
import com.epegase.systeme.classe.MotifEntreeParc;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class MotifEntreeParcDao implements Serializable {
   private MotifEntreeParc motifEntreeParc;
   private ExercicesParc exercicesParc;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public MotifEntreeParcDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public MotifEntreeParc insert(MotifEntreeParc var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public MotifEntreeParc modif(MotifEntreeParc var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public String delete(long var1, Session var3) {
      Query var4 = var3.createQuery("delete from MotifEntreeParc where mtpId =:Sid");
      var4.setParameter("Sid", var1);
      var4.executeUpdate();
      return null;
   }

   public List selectMotifEntreeParc(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "MotifEntreeParc");
         var2 = true;
      }

      Query var3 = var1.createQuery("from MotifEntreeParc order by mtpCode");
      Object var4 = new ArrayList();
      if (var3.list() != null) {
         var4 = var3.list();
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var4;
   }

   public List selectActifMotifentree(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "MotifEntreeParc");
         var2 = true;
      }

      List var3 = var1.createQuery("from MotifEntreeParc where mtpInactif=0 order by mtpCode").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List selectActifMotifEntreeItems(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "MotifEntreeParc");
         var3 = true;
      }

      List var4 = var2.createQuery("from MotifEntreeParc where mtpCodeType=:typ and mtpInactif=0 order by mtpCode").setInteger("typ", var1).list();
      ArrayList var5 = new ArrayList();
      if (var4.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            new MotifEntreeParc();
            MotifEntreeParc var7 = (MotifEntreeParc)var4.get(var6);
            var5.add(new SelectItem(var7.getMtpCode() + ":" + var7.getMtpLibelle()));
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public MotifEntreeParc selectUnite(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "MotifEntreeParc");
         var3 = true;
      }

      new ArrayList();
      List var4 = var2.createQuery("from MotifEntreeParc where mtpCode='" + var1 + "'").setMaxResults(1).list();
      new MotifEntreeParc();
      MotifEntreeParc var5;
      if (var4.size() != 0) {
         var5 = (MotifEntreeParc)var4.get(0);
      } else {
         var5 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
