package com.epegase.systeme.dao;

import com.epegase.systeme.classe.SpecialitesMedical;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class SpecialitesMedicalDao implements Serializable {
   private SpecialitesMedical specialitesMedical;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public SpecialitesMedicalDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public SpecialitesMedical insert(SpecialitesMedical var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public SpecialitesMedical modif(SpecialitesMedical var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void deleteSpecialitesMedical(SpecialitesMedical var1, Session var2) {
      var2.delete(var1);
   }

   public SpecialitesMedical getSpecialitesMedicalId(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "SpecialitesMedical");
         var4 = true;
      }

      SpecialitesMedical var5 = (SpecialitesMedical)var3.get(SpecialitesMedical.class, var1);
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public SpecialitesMedical getSpecialitesMedicalCode(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "SpecialitesMedical");
         var3 = true;
      }

      Query var4 = var2.createQuery("from SpecialitesMedical where spemedCode=:cod").setString("cod", var1).setMaxResults(1);
      List var5 = var4.list();
      new SpecialitesMedical();
      SpecialitesMedical var6;
      if (var5.size() > 0) {
         var6 = (SpecialitesMedical)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List getListSpecialitesMedical(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "SpecialitesMedical");
         var2 = true;
      }

      List var3 = var1.createQuery("from SpecialitesMedical").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerLesServicesMedicauxItems(int var1, int var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "SpecialitesMedical");
         var4 = true;
      }

      List var5 = var3.createQuery("from SpecialitesMedical where (spemedType=1 or spemedType=10 or spemedType=11) and spemedInactif=" + var2 + " order by spemedCode ASC").list();
      List var6 = var5;
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var7 = new ArrayList();
      if (var1 == 0) {
         var7.add(new SelectItem("100", "Tous Services"));
      } else if (var1 == 1) {
         var7.add(new SelectItem("0", "Sélectionnez service"));
      }

      if (var5.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            var7.add(new SelectItem(((SpecialitesMedical)var6.get(var8)).getSpemedCode() + ":" + ((SpecialitesMedical)var6.get(var8)).getSpemedNom()));
         }
      }

      return var7;
   }

   public List chargerLesLaboratoiresItems(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "SpecialitesMedical");
         var3 = true;
      }

      List var4 = var2.createQuery("from SpecialitesMedical where (spemedType=0 or spemedType=1) order by spemedCode ASC").list();
      List var5 = var4;
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var6 = new ArrayList();
      if (var1 == 0) {
         var6.add(new SelectItem("100", "Tous Services"));
      } else if (var1 == 1) {
         var6.add(new SelectItem("0", "Sélectionnez laboratoire"));
      }

      if (var4.size() != 0) {
         for(int var7 = 0; var7 < var5.size(); ++var7) {
            var6.add(new SelectItem(((SpecialitesMedical)var5.get(var7)).getSpemedCode() + ":" + ((SpecialitesMedical)var5.get(var7)).getSpemedNom()));
         }
      }

      return var6;
   }

   public List chargerLesPharmaciesItems(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "SpecialitesMedical");
         var3 = true;
      }

      List var4 = var2.createQuery("from SpecialitesMedical where spemedType=12 order by spemedCode ASC").list();
      List var5 = var4;
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var6 = new ArrayList();
      if (var1 == 0) {
         var6.add(new SelectItem("100", "Tous Services"));
      } else if (var1 == 1) {
         var6.add(new SelectItem("0", "Sélectionnez pharmacie"));
      }

      if (var4.size() != 0) {
         for(int var7 = 0; var7 < var5.size(); ++var7) {
            var6.add(new SelectItem(((SpecialitesMedical)var5.get(var7)).getSpemedCode() + ":" + ((SpecialitesMedical)var5.get(var7)).getSpemedNom()));
         }
      }

      return var6;
   }

   public List chargerLesServicesItems(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "SpecialitesMedical");
         var3 = true;
      }

      List var4 = var2.createQuery("from SpecialitesMedical order by spemedCode ASC").list();
      List var5 = var4;
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var6 = new ArrayList();
      if (var1 == 0) {
         var6.add(new SelectItem("100", "Tous Services"));
      } else if (var1 == 1) {
         var6.add(new SelectItem("0", "Sélectionnez service"));
      }

      if (var4.size() != 0) {
         for(int var7 = 0; var7 < var5.size(); ++var7) {
            var6.add(new SelectItem(((SpecialitesMedical)var5.get(var7)).getSpemedCode() + ":" + ((SpecialitesMedical)var5.get(var7)).getSpemedNom()));
         }
      }

      return var6;
   }
}
