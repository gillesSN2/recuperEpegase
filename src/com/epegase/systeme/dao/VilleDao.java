package com.epegase.systeme.dao;

import com.epegase.systeme.classe.PointDeVente;
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

public class VilleDao implements Serializable {
   private Ville ville;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public VilleDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public Ville insert(Ville var1) throws HibernateException, NamingException {
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

   public Ville modif(Ville var1) throws HibernateException, NamingException {
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

   public void delete(Ville var1) throws HibernateException, NamingException {
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

   public String deletVilleByPdv(PointDeVente var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
      Transaction var3 = var2.beginTransaction();
      var3.begin();
      Query var4 = var2.createQuery("delete from Ville where pointDeVente.pdvId =:se order by vilCode").setLong("se", var1.getPdvId());
      var4.executeUpdate();
      var3.commit();
      this.utilInitHibernate.closeSession();
      return null;
   }

   public List selectVille() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
      List var2 = var1.createQuery(" from Ville order by vilCode asc").list();
      this.utilInitHibernate.closeSession();
      return var2;
   }

   public List listVilleByPdv(String var1, PointDeVente var2, Session var3) {
      Object var4 = new ArrayList();
      if (var2 != null) {
         Query var5 = var3.createQuery("from Ville where  ((vilAnneeDebut=0 or vilAnneeFin=0) or (vilAnneeFin <='" + var1 + "' or vilAnneeDebut >='" + var1 + "')) and vilInactif =0 and pointDeVente=:vte order by vilCode").setParameter("vte", var2);
         var4 = var5.list();
      }

      return (List)var4;
   }

   public Ville rechercheVille(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Ville ja where ja.vilCode=:cod order by vilCode").setString("cod", var1).setMaxResults(1);
      List var5 = var4.list();
      new Ville();
      Ville var6;
      if (var5.size() > 0) {
         var6 = (Ville)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List logVille(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
      List var4 = var3.createQuery("from Ville where vil_id = '" + var1 + "'").list();
      this.utilInitHibernate.closeSession();
      return var4;
   }

   public List listVilleByPdvItem(PointDeVente var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
         var3 = true;
      }

      new ArrayList();
      ArrayList var5 = new ArrayList();
      if (var1 != null) {
         Query var6 = var2.createQuery("from Ville where pointdevente=:vte order by vilCode").setParameter("vte", var1);
         List var4 = var6.list();
         if (var4.size() != 0) {
            for(int var7 = 0; var7 < var4.size(); ++var7) {
               new Ville();
               Ville var8 = (Ville)var4.get(var7);
               var5.add(new SelectItem(var8.getVilCode() + ":" + var8.getVilNomFr()));
            }
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List listVilleByPdv(PointDeVente var1, Session var2) throws HibernateException, NamingException {
      Object var3 = new ArrayList();
      if (var1 != null) {
         boolean var4 = false;
         if (var2 == null) {
            var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
            var4 = true;
         }

         Query var5 = var2.createQuery("from Ville where pointDeVente=:vte order by vilCode").setParameter("vte", var1);
         var3 = var5.list();
         if (var4) {
            this.utilInitHibernate.closeSession();
         }
      }

      return (List)var3;
   }

   public List chargerLesVille(String var1, Session var2) {
      List var3 = var2.createQuery("from Ville where  ((vilAnneeDebut=0 or vilAnneeFin=0) or (vilAnneeFin <='" + var1 + "' or vilAnneeDebut >='" + var1 + "')) and   vilInactif =0 order by vilCode").list();
      return var3;
   }

   public List chargerLesVille(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
         var2 = true;
      }

      List var3 = var1.createQuery("from Ville where vilInactif =0 order by vilCode").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerLesVilleItems(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
         var2 = true;
      }

      List var3 = var1.createQuery("from Ville where vilInactif =0 order by vilCode").list();
      List var4 = var3;
      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var5.add(new SelectItem(((Ville)var4.get(var6)).getVilCode() + ":" + ((Ville)var4.get(var6)).getVilNomFr()));
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
      Query var5 = var2.createQuery("from Ville ja where ja.vilCode=:cod").setString("cod", var1).setMaxResults(1);
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

   public boolean existCodeByPdv(String var1, PointDeVente var2) throws HibernateException, NamingException {
      boolean var3 = false;
      Session var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
      Query var5 = var4.createQuery("from Ville where pointDeVente.pdvId=:se and vilCode=:cod").setString("cod", var1).setLong("se", var2.getPdvId()).setMaxResults(1);
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
      Query var3 = var2.createQuery("from Ville ja where ja.vilCode=:cod").setString("cod", var1).setMaxResults(1);
      List var4 = var3.list();
      return var4;
   }

   public Ville getVille() {
      return this.ville;
   }

   public void setVille(Ville var1) {
      this.ville = var1;
   }
}
