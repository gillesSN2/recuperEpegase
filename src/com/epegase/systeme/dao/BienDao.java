package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Bien;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BienDao implements Serializable {
   private Bien bien;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public BienDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public Bien insert(Bien var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
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

   public Bien insert(Bien var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public Bien modif(Bien var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
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

   public Bien modif(Bien var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(Bien var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
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

   public void delete(Bien var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List chargeBien(int var1, int var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var4 = true;
      }

      String var5 = "";
      if (var2 == 9) {
         if (var1 == 0) {
            var5 = "(bieCategorie=0 or bieCategorie=4 or bieCategorie=5)";
         } else if (var1 == 1) {
            var5 = "(bieCategorie=1 or bieCategorie=4 or bieCategorie=5 or bieCategorie=6)";
         } else if (var1 == 2) {
            var5 = "(bieCategorie=2 or bieCategorie=6)";
         } else if (var1 == 3) {
            var5 = "(bieCategorie=3 or bieCategorie=6)";
         } else {
            var5 = "bieCategorie>=0 and bieCategorie<=6";
         }
      } else if (var2 == 0) {
         if (var1 == 0) {
            var5 = "(bieCategorie=0 or bieCategorie=4 or bieCategorie=5) and bieGestion=0 and bieOccupe=0";
         } else if (var1 == 1) {
            var5 = "(bieCategorie=1 or bieCategorie=4 or bieCategorie=5 or bieCategorie=6) and bieGestion=0 and bieOccupe=0";
         } else if (var1 == 2) {
            var5 = "(bieCategorie=2 or bieCategorie=6) and bieGestion=0 and bieOccupe=0";
         } else if (var1 == 3) {
            var5 = "(bieCategorie=3 or bieCategorie=6) and bieGestion=0 and bieOccupe=0";
         } else {
            var5 = "bieCategorie>=0 and bieCategorie<=6 and bieGestion=0 and bieOccupe=0";
         }
      } else if (var2 == 1) {
         if (var1 == 0) {
            var5 = "(bieCategorie=0 or bieCategorie=4 or bieCategorie=5) and bieGestion=0 and bieOccupe=1";
         } else if (var1 == 1) {
            var5 = "(bieCategorie=1 or bieCategorie=4 or bieCategorie=5 or bieCategorie=6) and bieGestion=0 and bieOccupe=1";
         } else if (var1 == 2) {
            var5 = "(bieCategorie=2 or bieCategorie=6) and bieGestion=0 and bieOccupe=1";
         } else if (var1 == 3) {
            var5 = "(bieCategorie=3 or bieCategorie=6) and bieGestion=0 and bieOccupe=1";
         } else {
            var5 = "bieCategorie>=0 and bieCategorie<=6 and bieGestion=0 and bieOccupe=1";
         }
      } else if (var2 == 2) {
         if (var1 == 0) {
            var5 = "(bieCategorie=0 or bieCategorie=4 or bieCategorie=5) and bieGestion=0";
         } else if (var1 == 1) {
            var5 = "(bieCategorie=1 or bieCategorie=4 or bieCategorie=5 or bieCategorie=6) and bieGestion=0";
         } else if (var1 == 2) {
            var5 = "(bieCategorie=2 or bieCategorie=6) and bieGestion=0";
         } else if (var1 == 3) {
            var5 = "(bieCategorie=3 or bieCategorie=6) and bieGestion=0";
         } else {
            var5 = "bieCategorie>=0 and bieCategorie<=6 and bieGestion=0";
         }
      } else if (var2 == 3) {
         var5 = "bieEtat=0";
      } else if (var2 == 4) {
         var5 = "bieEtat=1";
      } else if (var2 == 5) {
         var5 = "bieEtat=2";
      } else if (var2 == 6) {
         var5 = "bieEtat=3";
      } else if (var2 == 7) {
         var5 = "bieEtat=4";
      } else if (var2 == 8) {
         if (var1 == 0) {
            var5 = "(bieCategorie=0 or bieCategorie=4 or bieCategorie=5) and bieGestion=1";
         } else if (var1 == 1) {
            var5 = "(bieCategorie=1 or bieCategorie=4 or bieCategorie=5 or bieCategorie=6) and bieGestion=1";
         } else if (var1 == 2) {
            var5 = "(bieCategorie=2 or bieCategorie=6) and bieGestion=1";
         } else if (var1 == 3) {
            var5 = "(bieCategorie=3 or bieCategorie=6) and bieGestion=1";
         } else {
            var5 = "bieCategorie>=0 and bieCategorie<=6 and bieGestion=1";
         }
      }

      List var6 = var3.createQuery("from Bien where " + var5).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargeBien(int var1, int var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var5 = true;
      }

      String var6 = "";
      if (var3 != null && !var3.isEmpty()) {
         if (var3.equals("*")) {
            var6 = "";
         } else if (var3.startsWith("*") && var3.length() >= 2) {
            var6 = " and (bieNum like '" + var3.substring(1) + "%' or bieNom like '%" + var3.substring(1) + "%')";
         } else {
            var6 = " and (bieNum like '" + var3 + "%' or bieNom like '%" + var3 + "%')";
         }
      }

      String var7 = "";
      if (var2 == 9) {
         if (var1 == 0) {
            var7 = "(bieCategorie=0 or bieCategorie=4 or bieCategorie=5)";
         } else if (var1 == 1) {
            var7 = "(bieCategorie=1 or bieCategorie=4 or bieCategorie=5 or bieCategorie=6)";
         } else if (var1 == 2) {
            var7 = "(bieCategorie=2 or bieCategorie=6)";
         } else if (var1 == 3) {
            var7 = "(bieCategorie=3 or bieCategorie=6)";
         } else {
            var7 = "bieCategorie>=0 and bieCategorie<=6";
         }
      } else if (var1 == 0) {
         var7 = "(bieCategorie=0 or bieCategorie=4 or bieCategorie=5) and bieGestion=" + var2;
      } else if (var1 == 1) {
         var7 = "(bieCategorie=1 or bieCategorie=4 or bieCategorie=5 or bieCategorie=6) and bieGestion=" + var2;
      } else if (var1 == 2) {
         var7 = "(bieCategorie=2 or bieCategorie=6) and bieGestion=" + var2;
      } else if (var1 == 3) {
         var7 = "(bieCategorie=3 or bieCategorie=6) and bieGestion=" + var2;
      } else {
         var7 = "bieCategorie>=0 and bieCategorie<=6 and bieGestion=" + var2;
      }

      List var8 = var4.createQuery("from Bien where " + var7 + var6).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List chargeBienSyndic(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var2 = true;
      }

      String var3 = "(bieCategorie=1 or bieCategorie=4 or bieCategorie=5 or bieCategorie=6)";
      List var4 = var1.createQuery("from Bien where " + var3).list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargeBienNegoce(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var2 = true;
      }

      String var3 = "(bieCategorie=2 or bieCategorie=6)";
      List var4 = var1.createQuery("from Bien where " + var3).list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargeBienPromoteur(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var2 = true;
      }

      String var3 = "(bieCategorie=3 or bieCategorie=6)";
      List var4 = var1.createQuery("from Bien where " + var3).list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargeBienByType(int var1, int var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var4 = true;
      }

      String var5 = "";
      if (var1 == 0) {
         var5 = "(bieCategorie=0 or bieCategorie=4 or bieCategorie=5)";
      } else if (var1 == 1) {
         var5 = "(bieCategorie=1 or bieCategorie=4 or bieCategorie=5 or bieCategorie=6)";
      } else if (var1 == 2) {
         var5 = "(bieCategorie=2 or bieCategorie=6)";
      } else if (var1 == 3) {
         var5 = "(bieCategorie=3 or bieCategorie=6)";
      } else {
         var5 = "bieCategorie>=0 and bieCategorie<=6";
      }

      List var6 = var3.createQuery("from Bien where " + var5 + " and bieType=:typ").setInteger("typ", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargeBienByTiers(int var1, Tiers var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var4 = true;
      }

      List var5 = null;
      if (var1 == 9) {
         var5 = var3.createQuery("from Bien where Tiers=:tt").setParameter("tt", var2).list();
      } else {
         String var6 = "";
         if (var1 == 0) {
            var6 = "(bieCategorie=0 or bieCategorie=4 or bieCategorie=5)";
         } else if (var1 == 1) {
            var6 = "(bieCategorie=1 or bieCategorie=4 or bieCategorie=5 or bieCategorie=6)";
         } else if (var1 == 2) {
            var6 = "(bieCategorie=2 or bieCategorie=6)";
         } else if (var1 == 3) {
            var6 = "(bieCategorie=3 or bieCategorie=6)";
         } else {
            var6 = "bieCategorie>=0 and bieCategorie<=6";
         }

         var5 = var3.createQuery("from Bien where " + var6 + " and Tiers=:tt").setParameter("tt", var2).list();
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargeBienDetail(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var4 = true;
      }

      this.bien = new Bien();
      Query var5 = var3.createQuery("from Bien where bieIdGroupe=:numero and (bieType=1 or bieType=3 or bieType=5)").setLong("numero", var1);
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public Bien logBienId(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var4 = true;
      }

      this.bien = new Bien();
      Query var5 = var3.createQuery("from Bien where bieId=:bie").setLong("bie", var1).setMaxResults(1);
      List var6 = var5.list();
      if (var6.size() != 0) {
         this.bien = (Bien)var6.get(0);
      } else {
         this.bien = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.bien;
   }

   public Bien chargeGroupe(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var3 = true;
      }

      this.bien = new Bien();
      Query var4 = var2.createQuery("from Bien where bieNum=:numero and bieType=2").setString("numero", var1).setMaxResults(1);
      List var5 = var4.list();
      if (var5.size() != 0) {
         this.bien = (Bien)var5.get(0);
      } else {
         this.bien = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return this.bien;
   }

   public Bien logBienNum(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var3 = true;
      }

      this.bien = new Bien();
      Query var4 = var2.createQuery("from Bien where bieNum=:numero").setString("numero", var1).setMaxResults(1);
      List var5 = var4.list();
      if (var5.size() != 0) {
         this.bien = (Bien)var5.get(0);
      } else {
         this.bien = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return this.bien;
   }

   public boolean logMailExiste(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Bien  where bieNum=:numero").setString("numero", var1).setMaxResults(1);
      List var5 = var4.list();
      boolean var6 = false;
      if (var5.size() != 0) {
         var6 = true;
      } else {
         var6 = false;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public boolean verifTiers(Tiers var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Bien where Tiers=:tie").setParameter("tie", var1).setMaxResults(1);
      List var5 = var4.list();
      boolean var6 = false;
      if (var5.size() != 0) {
         var6 = true;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
