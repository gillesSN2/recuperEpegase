package com.epegase.systeme.dao;

import com.epegase.systeme.classe.PegTabNom;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PegTabNomDao implements Serializable {
   private PegTabNom pegTabNom;
   private UtilInitHibernate utilInitHibernate;

   public PegTabNomDao(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
   }

   public List chargerMesTabNom(String var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getSysteme();
      Query var3 = var2.createQuery("from PegTabNom as tabnom where tabnom.tablisZone=:tabzone").setString("tabzone", var1);
      List var4 = var3.list();
      this.utilInitHibernate.closeSession();
      return var4;
   }

   public PegTabNom chargerMesTabNom(long var1, Session var3) throws HibernateException, NamingException {
      Query var4 = var3.createQuery("from PegTabNom as tabnom where tabnom.tablis_id=:id").setLong("id", var1);
      List var5 = var4.list();
      this.pegTabNom = new PegTabNom();
      if (var5.size() != 0) {
         this.pegTabNom = (PegTabNom)var5.get(0);
      } else {
         this.pegTabNom = null;
      }

      return this.pegTabNom;
   }

   public PegTabNom savePegtabNom(PegTabNom var1, String var2) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getSysteme();
      Transaction var4 = var3.beginTransaction();
      var1.setTablisZone(var2);
      var3.save(var1);
      var4.commit();
      this.utilInitHibernate.closeSession();
      return var1;
   }

   public PegTabNom savePegtabNom(PegTabNom var1, String var2, Session var3) throws HibernateException, NamingException {
      var1.setTablisZone(var2);
      var3.save(var1);
      return var1;
   }

   public PegTabNom updatePegtabNom(PegTabNom var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getSysteme();
      Transaction var3 = var2.beginTransaction();
      var2.update(var1);
      var3.commit();
      this.utilInitHibernate.closeSession();
      return var1;
   }

   public void deletePegtabNom(PegTabNom var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getSysteme();
      Transaction var3 = var2.beginTransaction();
      var2.delete(var1);
      var3.commit();
      this.utilInitHibernate.closeSession();
   }

   public void deletePegtabNom(PegTabNom var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public void updatePegtabNomCol(long var1, int var3, String var4, int var5, String var6) throws HibernateException, NamingException {
      Session var7 = this.utilInitHibernate.getSysteme();
      Transaction var8 = var7.beginTransaction();
      String var9 = "update PegTabNom b set b.tablisNom" + var6 + "=:nom ,b.tablisAnn" + var6 + "=:ann ,b.tablisTypeCol" + var6 + "=:type where b.tablis_id=:idPegNom";
      var7.createQuery(var9).setLong("idPegNom", var1).setInteger("ann", var3).setString("nom", var4).setInteger("type", var5).executeUpdate();
      var8.commit();
      this.utilInitHibernate.closeSession();
   }

   public List chargerMesTabNomEF(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getSysteme();
         var3 = true;
      }

      Query var4 = var2.createQuery("from PegTabNom where tablisZone=:tabzone and tablisInactif=0").setString("tabzone", var1);
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
