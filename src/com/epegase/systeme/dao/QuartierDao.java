package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Quartier;
import com.epegase.systeme.classe.Ville;
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

public class QuartierDao implements Serializable {
   private Quartier quartier;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public QuartierDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public Quartier insert(Quartier var1) throws HibernateException, NamingException {
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

   public Quartier modif(Quartier var1) throws HibernateException, NamingException {
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

   public void delete(Quartier var1) throws HibernateException, NamingException {
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

   public String deletQuartierByVille(Ville var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
      Transaction var3 = var2.beginTransaction();
      var3.begin();
      Query var4 = var2.createQuery("delete from Quartier where ville.vilId =:vil order by quaCode").setLong("vil", var1.getVilId());
      var4.executeUpdate();
      var3.commit();
      this.utilInitHibernate.closeSession();
      return null;
   }

   public List selectQuartier() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
      List var2 = var1.createQuery(" from Quartier order by vilCode asc").list();
      this.utilInitHibernate.closeSession();
      return var2;
   }

   public List listQuartierByVille(String var1, Ville var2, Session var3) {
      Object var4 = new ArrayList();
      if (var2 != null) {
         Query var5 = var3.createQuery("from Quartier where  ((quaAnneeDebut=0 or quaAnneeFin=0) or (quaAnneeFin <='" + var1 + "' or quaAnneeDebut >='" + var1 + "')) and quaInactif =0 and ville=:vil order by quaCode").setParameter("vil", var2);
         var4 = var5.list();
      }

      return (List)var4;
   }

   public Quartier rechercheQuartier(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Quartier ja where ja.quaCode=:cod order by quaCode").setString("cod", var1).setMaxResults(1);
      List var5 = var4.list();
      new Quartier();
      Quartier var6;
      if (var5.size() > 0) {
         var6 = (Quartier)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List logQuartier(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
      List var4 = var3.createQuery("from Quartier where qua_id = '" + var1 + "'").list();
      this.utilInitHibernate.closeSession();
      return var4;
   }

   public List listQuartierByVilleItem(Ville var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
         var3 = true;
      }

      new ArrayList();
      ArrayList var5 = new ArrayList();
      if (var1 != null) {
         Query var6 = var2.createQuery("from Quartier where ville=:vil order by quaCode").setParameter("vil", var1);
         List var4 = var6.list();
         if (var4.size() != 0) {
            for(int var7 = 0; var7 < var4.size(); ++var7) {
               new Quartier();
               Quartier var8 = (Quartier)var4.get(var7);
               var5.add(new SelectItem(var8.getQuaCode() + ":" + var8.getQuaNomFr()));
            }
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List listQuartierByVille(Ville var1, Session var2) throws HibernateException, NamingException {
      Object var3 = new ArrayList();
      if (var1 != null) {
         boolean var4 = false;
         if (var2 == null) {
            var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
            var4 = true;
         }

         Query var5 = var2.createQuery("from Quartier where ville=:vil order by quaCode").setParameter("vil", var1);
         var3 = var5.list();
         if (var4) {
            this.utilInitHibernate.closeSession();
         }
      }

      return (List)var3;
   }

   public List chargerLesQuartier(String var1, Session var2) {
      List var3 = var2.createQuery("from Quartier where  ((quaAnneeDebut=0 or quaAnneeFin=0) or (quaAnneeFin <='" + var1 + "' or quaAnneeDebut >='" + var1 + "')) and   quaInactif =0 order by quaCode").list();
      return var3;
   }

   public List chargerLesQuartier(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
         var2 = true;
      }

      List var3 = var1.createQuery("from Quartier where quaInactif =0 order by quaCode").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerLesQuartierItems(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
         var2 = true;
      }

      List var3 = var1.createQuery("from Quartier where quaInactif =0 order by quaCode").list();
      List var4 = var3;
      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var5.add(new SelectItem(((Quartier)var4.get(var6)).getQuaCode() + ":" + ((Quartier)var4.get(var6)).getQuaNomFr()));
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
      Query var5 = var2.createQuery("from Quartier ja where ja.quaCode=:cod").setString("cod", var1).setMaxResults(1);
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

   public boolean existCodeByVille(String var1, Ville var2) throws HibernateException, NamingException {
      boolean var3 = false;
      Session var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
      Query var5 = var4.createQuery("from Quartier where ville.vilId=:se and quaCode=:cod").setString("cod", var1).setLong("se", var2.getVilId()).setMaxResults(1);
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
      Query var3 = var2.createQuery("from Quartier ja where ja.quaCode=:cod").setString("cod", var1).setMaxResults(1);
      List var4 = var3.list();
      return var4;
   }

   public Quartier getQuartier() {
      return this.quartier;
   }

   public void setQuartier(Quartier var1) {
      this.quartier = var1;
   }
}
