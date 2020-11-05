package com.epegase.systeme.dao;

import com.epegase.systeme.classe.PegTabElement;
import com.epegase.systeme.classe.PegTabNom;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PegTabElementDao implements Serializable {
   private PegTabElement pegTabElement;
   private UtilInitHibernate utilInitHibernate;

   public PegTabElementDao(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
   }

   public List chargerMesTabElement(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getSysteme();
      Query var4 = var3.createQuery("from PegTabElement pegEl where pegEl.pegTabNom=:idpegnom order by tabeleNum").setLong("idpegnom", var1);
      List var5 = var4.list();
      this.utilInitHibernate.closeSession();
      return var5;
   }

   public List chargerMesTabElement(long var1, Session var3) throws HibernateException, NamingException {
      Query var4 = var3.createQuery("from PegTabElement pegEl where pegEl.pegTabNom=:idpegnom order by tabeleNum").setLong("idpegnom", var1);
      List var5 = var4.list();
      return var5;
   }

   public List chargerMesTabElement(String var1, String var2) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getSysteme();
      Query var4 = var3.createQuery("from PegTabElement where pegTabNom.tablisCode=:codeTab and pegTabNom.tablisZone=:zonefisc order by tabeleNum").setString("codeTab", var1).setString("zonefisc", var2);
      List var5 = var4.list();
      this.utilInitHibernate.closeSession();
      return var5;
   }

   public List chargerMesTabElementByFKId(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getSysteme();
         var3 = true;
      }

      Query var4 = var2.createQuery("from PegTabElement pegEl where pegEl.pegTabNom in " + var1);
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public PegTabElement savePegtabElement(PegTabElement var1, PegTabNom var2) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getSysteme();
      Transaction var4 = var3.beginTransaction();
      var1.setPegTabNom(var2);
      var3.save(var1);
      var4.commit();
      this.utilInitHibernate.closeSession();
      return var1;
   }

   public PegTabElement savePegtabElement(PegTabElement var1, PegTabNom var2, Session var3) throws HibernateException, NamingException {
      var1.setPegTabNom(var2);
      var3.save(var1);
      return var1;
   }

   public PegTabElement updatePegtabElement(PegTabElement var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getSysteme();
      Transaction var3 = var2.beginTransaction();
      var2.update(var1);
      var3.commit();
      this.utilInitHibernate.closeSession();
      return var1;
   }

   public void deletePegtabElement(PegTabElement var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getSysteme();
      Transaction var3 = var2.beginTransaction();
      var2.delete(var1);
      var3.commit();
      this.utilInitHibernate.closeSession();
   }

   public void deletePegtabElement(PegTabElement var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public void ordonnnerAscendant(int var1, int var2, long var3, long var5) throws HibernateException, NamingException {
      Session var7 = this.utilInitHibernate.getSysteme();
      Transaction var8 = var7.beginTransaction();
      String var9 = "update PegTabElement pb set pb.tabeleNum=:ordPrec where pb.tabele_id=:idTab";
      var7.createQuery(var9).setInteger("ordPrec", var2).setLong("idTab", var3).executeUpdate();
      String var11 = "update PegTabElement pb set pb.tabeleNum=:ord1 where pb.tabele_id=:idTab";
      var7.createQuery(var11).setInteger("ord1", var1).setLong("idTab", var5).executeUpdate();
      var8.commit();
      this.utilInitHibernate.closeSession();
   }

   public void ordonnnerDescendant(int var1, int var2, long var3, long var5) throws HibernateException, NamingException {
      Session var7 = this.utilInitHibernate.getSysteme();
      Transaction var8 = var7.beginTransaction();
      String var9 = "update PegTabElement pb set pb.tabeleNum=:ordSuiv where pb.tabele_id=:idTab";
      var7.createQuery(var9).setInteger("ordSuiv", var2).setLong("idTab", var3).executeUpdate();
      String var11 = "update PegTabElement pb set pb.tabeleNum=:ord1 where pb.tabele_id=:idTab";
      var7.createQuery(var11).setInteger("ord1", var1).setLong("idTab", var5).executeUpdate();
      var8.commit();
      this.utilInitHibernate.closeSession();
   }
}
