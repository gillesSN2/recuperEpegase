package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Cellule;
import com.epegase.systeme.classe.Quartier;
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

public class CelluleDao implements Serializable {
   private Cellule cellule;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public CelluleDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public Cellule insert(Cellule var1) throws HibernateException, NamingException {
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

   public Cellule modif(Cellule var1) throws HibernateException, NamingException {
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

   public void delete(Cellule var1) throws HibernateException, NamingException {
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

   public String deletCelluleByQuartie(Quartier var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
      Transaction var3 = var2.beginTransaction();
      var3.begin();
      Query var4 = var2.createQuery("delete from Cellule where quartier.quaId =:qua order by celCode").setLong("qua", var1.getQuaId());
      var4.executeUpdate();
      var3.commit();
      this.utilInitHibernate.closeSession();
      return null;
   }

   public List selectCellule() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
      List var2 = var1.createQuery(" from Cellule order by celCode asc").list();
      this.utilInitHibernate.closeSession();
      return var2;
   }

   public List listCelluleByQuartier(String var1, Quartier var2, Session var3) {
      Object var4 = new ArrayList();
      if (var2 != null) {
         Query var5 = var3.createQuery("from Cellule where  ((celAnneeDebut=0 or celAnneeFin=0) or (celAnneeFin <='" + var1 + "' or celAnneeDebut >='" + var1 + "')) and celInactif =0 and quartier=:qua order by celCode").setParameter("qua", var2);
         var4 = var5.list();
      }

      return (List)var4;
   }

   public Cellule rechercheCellule(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Cellule ja where ja.celCode=:cod order by celCode").setString("cod", var1).setMaxResults(1);
      List var5 = var4.list();
      new Cellule();
      Cellule var6;
      if (var5.size() > 0) {
         var6 = (Cellule)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List logCellule(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
      List var4 = var3.createQuery("from Cellule where cel_id = '" + var1 + "'").list();
      this.utilInitHibernate.closeSession();
      return var4;
   }

   public List listCelluleByQuartierItem(Quartier var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
         var3 = true;
      }

      new ArrayList();
      ArrayList var5 = new ArrayList();
      if (var1 != null) {
         Query var6 = var2.createQuery("from Cellule where quartier=:qua order by celCode").setParameter("qua", var1);
         List var4 = var6.list();
         if (var4.size() != 0) {
            for(int var7 = 0; var7 < var4.size(); ++var7) {
               new Cellule();
               Cellule var8 = (Cellule)var4.get(var7);
               var5.add(new SelectItem(var8.getCelCode() + ":" + var8.getCelNomFr()));
            }
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List listCelluleByQuartier(Quartier var1, Session var2) throws HibernateException, NamingException {
      Object var3 = new ArrayList();
      if (var1 != null) {
         boolean var4 = false;
         if (var2 == null) {
            var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
            var4 = true;
         }

         Query var5 = var2.createQuery("from Cellule where quartier=:qua order by celCode").setParameter("qua", var1);
         var3 = var5.list();
         if (var4) {
            this.utilInitHibernate.closeSession();
         }
      }

      return (List)var3;
   }

   public List chargerLesCellule(String var1, Session var2) {
      List var3 = var2.createQuery("from Cellule where  ((celAnneeDebut=0 or celAnneeFin=0) or (celAnneeFin <='" + var1 + "' or celAnneeDebut >='" + var1 + "')) and   celInactif =0 order by celCode").list();
      return var3;
   }

   public List chargerLesCellule(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
         var2 = true;
      }

      List var3 = var1.createQuery("from Cellule where celInactif =0 order by celCode").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerLesCelluleItems(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
         var2 = true;
      }

      List var3 = var1.createQuery("from Cellule where celInactif =0 order by celCode").list();
      List var4 = var3;
      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var5.add(new SelectItem(((Cellule)var4.get(var6)).getCelCode() + ":" + ((Cellule)var4.get(var6)).getCelNomFr()));
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
      Query var5 = var2.createQuery("from Cellule ja where ja.celCode=:cod").setString("cod", var1).setMaxResults(1);
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

   public boolean existCodeByQuartier(String var1, Quartier var2) throws HibernateException, NamingException {
      boolean var3 = false;
      Session var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
      Query var5 = var4.createQuery("from Cellule where quartier.quaId=:se and celCode=:cod").setString("cod", var1).setLong("se", var2.getQuaId()).setMaxResults(1);
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
      Query var3 = var2.createQuery("from Cellule ja where ja.celCode=:cod").setString("cod", var1).setMaxResults(1);
      List var4 = var3.list();
      return var4;
   }

   public Cellule getCellule() {
      return this.cellule;
   }

   public void setCellule(Cellule var1) {
      this.cellule = var1;
   }
}
