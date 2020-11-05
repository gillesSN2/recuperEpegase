package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Caracteristique;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CaracteristiqueDao implements Serializable {
   private Caracteristique caracteristique;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public CaracteristiqueDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public Caracteristique insert(Caracteristique var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "FamilleParc");
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

   public Caracteristique modif(Caracteristique var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "FamilleParc");
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

   public void delete(Caracteristique var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "FamilleParc");
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

   public List selectCaracteristiques(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "FamilleParc");
         var4 = true;
      }

      new ArrayList();
      List var5;
      if (var2 != null && !var2.isEmpty()) {
         var5 = var3.createQuery("from Caracteristique where carType=0 and carFamille=:fam and carSousFamille=:sFam order by carLibelle asc").setString("fam", var1).setString("sFam", var2).list();
      } else {
         var5 = var3.createQuery("from Caracteristique where carType=0 and carFamille=:fam order by carLibelle asc").setString("fam", var1).list();
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectInventaires(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "FamilleParc");
         var4 = true;
      }

      new ArrayList();
      List var5;
      if (var2 != null && !var2.isEmpty()) {
         var5 = var3.createQuery("from Caracteristique where carType=1 and carFamille=:fam and carSousFamille=:sFam order by carLibelle asc").setString("fam", var1).setString("sFam", var2).list();
      } else {
         var5 = var3.createQuery("from Caracteristique where carType=1 and carFamille=:fam order by carLibelle asc").setString("fam", var1).list();
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesFamilles(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "FamilleParc");
         var3 = true;
      }

      List var4 = var2.createQuery("from Caracteristique where carInactif=0 and carFamille=:fam order by carLibelle asc").setString("fam", var1).list();
      List var5 = var4;
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var6 = new ArrayList();
      if (var4.size() != 0) {
         for(int var7 = 0; var7 < var5.size(); ++var7) {
            var6.add(new SelectItem(((Caracteristique)var5.get(var7)).getCarLibelle()));
         }
      }

      return var6;
   }
}
