package com.epegase.systeme.dao;

import com.epegase.systeme.classe.PointDeVente;
import com.epegase.systeme.classe.Secteur;
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

public class PointDeVenteDao implements Serializable {
   private PointDeVente pointDeVente;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public PointDeVenteDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public PointDeVente insert(PointDeVente var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
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

   public PointDeVente modif(PointDeVente var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
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

   public void delete(PointDeVente var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
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

   public String deletPdvBySecteur(Secteur var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
      Transaction var3 = var2.beginTransaction();
      var3.begin();
      Query var4 = var2.createQuery("delete from PointDeVente where secteur.secId =:se order by pdvCode");
      var4.setParameter("se", var1.getSecId());
      var4.executeUpdate();
      var3.commit();
      this.utilInitHibernate.closeSession();
      return null;
   }

   public List selectPdv() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
      List var2 = var1.createQuery(" from PointDeVente order by pdvCode asc").list();
      this.utilInitHibernate.closeSession();
      return var2;
   }

   public List listPdvBySecteur(String var1, Secteur var2, Session var3) {
      Object var4 = new ArrayList();
      if (var2 != null) {
         Query var5 = var3.createQuery("from PointDeVente where  ((pdvAnneeDebut=0 or pdvAnneeFin=0) or (pdvAnneeFin <='" + var1 + "' or pdvAnneeDebut >='" + var1 + "')) and pdvInactif =0 and secteur=:sect order by pdvCode");
         var5.setParameter("sect", var2);
         var4 = var5.list();
      }

      return (List)var4;
   }

   public PointDeVente recherchePdv(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
         var3 = true;
      }

      Query var4 = var2.createQuery("from PointDeVente ja where ja.pdvCode=:cod order by pdvCode").setString("cod", var1);
      var4.setMaxResults(1);
      List var5 = var4.list();
      new PointDeVente();
      PointDeVente var6;
      if (var5.size() > 0) {
         var6 = (PointDeVente)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List logPdv(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
      List var4 = var3.createQuery("from PointDeVente where pdv_id = '" + var1 + "'").list();
      this.utilInitHibernate.closeSession();
      return var4;
   }

   public List listPdvBySecteurItem(Secteur var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
         var3 = true;
      }

      new ArrayList();
      ArrayList var5 = new ArrayList();
      if (var1 != null) {
         Query var6 = var2.createQuery("from PointDeVente where secteur=:secteur order by pdvCode");
         var6.setParameter("secteur", var1);
         List var4 = var6.list();
         if (var4.size() != 0) {
            for(int var7 = 0; var7 < var4.size(); ++var7) {
               new PointDeVente();
               PointDeVente var8 = (PointDeVente)var4.get(var7);
               var5.add(new SelectItem(var8.getPdvCode() + ":" + var8.getPdvNomFr()));
            }
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List listPdvBySecteur(Secteur var1, Session var2) throws HibernateException, NamingException {
      Object var3 = new ArrayList();
      if (var1 != null) {
         boolean var4 = false;
         if (var2 == null) {
            var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
            var4 = true;
         }

         Query var5 = var2.createQuery("from PointDeVente where secteur=:secteur order by pdvCode");
         var5.setParameter("secteur", var1);
         var3 = var5.list();
         if (var4) {
            this.utilInitHibernate.closeSession();
         }
      }

      return (List)var3;
   }

   public List listPdvBySecteur(String var1, Session var2) throws HibernateException, NamingException {
      Object var3 = new ArrayList();
      if (var1 != null) {
         boolean var4 = false;
         if (var2 == null) {
            var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
            var4 = true;
         }

         Query var5 = var2.createQuery("from PointDeVente where secteur.secCode=:secteur order by pdvCode").setString("secteur", var1);
         var3 = var5.list();
         if (var4) {
            this.utilInitHibernate.closeSession();
         }
      }

      return (List)var3;
   }

   public List chargerLesPointDeVente(String var1, Session var2) {
      List var3 = var2.createQuery("from PointDeVente where  ((pdvAnneeDebut=0 or pdvAnneeFin=0) or (pdvAnneeFin <='" + var1 + "' or pdvAnneeDebut >='" + var1 + "')) and   pdvInactif =0 order by pdvCode as").list();
      return var3;
   }

   public List chargerLesPointDeVente(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
         var2 = true;
      }

      List var3 = var1.createQuery("from PointDeVente where pdvInactif =0 order by pdvCode").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerLesPointDeVenteItems(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
         var2 = true;
      }

      List var3 = var1.createQuery("from PointDeVente where pdvInactif =0 order by pdvCode").list();
      List var4 = var3;
      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var5.add(new SelectItem(((PointDeVente)var4.get(var6)).getPdvCode() + ":" + ((PointDeVente)var4.get(var6)).getPdvNomFr()));
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public boolean existCode(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
         var3 = true;
      }

      boolean var4 = false;
      Query var5 = var2.createQuery("from PointDeVente ja where ja.pdvCode=:cod").setString("cod", var1);
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

   public boolean existCodeBySect(String var1, Secteur var2) throws HibernateException, NamingException {
      boolean var3 = false;
      Session var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
      Query var5 = var4.createQuery("from PointDeVente where secteur.secId=:se and pdvCode=:cod").setString("cod", var1);
      var5.setParameter("se", var2.getSecId());
      var5.setMaxResults(1);
      List var6 = var5.list();
      if (var6.size() > 0) {
         var3 = true;
      } else {
         var3 = false;
      }

      this.utilInitHibernate.closeSession();
      return var3;
   }

   public List existCodeList(String var1, Session var2) {
      Query var3 = var2.createQuery("from PointDeVente ja where ja.pdvCode=:cod").setString("cod", var1);
      var3.setMaxResults(1);
      List var4 = var3.list();
      return var4;
   }

   public PointDeVente getPointDeVente() {
      return this.pointDeVente;
   }

   public void setPointDeVente(PointDeVente var1) {
      this.pointDeVente = var1;
   }
}
