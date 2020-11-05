package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Amortissements;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class AmortissementsDao implements Serializable {
   private Amortissements amortissements;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public AmortissementsDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public Amortissements insert(Amortissements var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Amortissements");
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

   public Amortissements insert(Amortissements var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public Amortissements modif(Amortissements var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Amortissements");
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

   public Amortissements modif(Amortissements var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(Amortissements var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public void miseAjourSelectedAmort(List var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Amortissements");
      Transaction var3 = var2.beginTransaction();

      for(int var4 = 0; var4 < var1.size(); ++var4) {
         Amortissements var5 = (Amortissements)var1.get(var4);
         var2.update(var5);
      }

      var3.commit();
      this.utilInitHibernate.closeSession();
   }

   public String supprimeSelectedAmort(Amortissements var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Amortissements");
      Transaction var3 = var2.beginTransaction();
      long var4 = var1.getAmoId();
      int var6 = var2.createSQLQuery("delete from cpt_amortissements where amo_id='" + var4 + "'").executeUpdate();
      var3.commit();
      this.utilInitHibernate.closeSession();
      return "ok";
   }

   public List selectAmortissement() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Amortissements");
      Query var2 = var1.createQuery("from Amortissements order by amoId desc");
      Object var3 = new ArrayList();
      if (var2.list() != null) {
         var3 = var2.list();
      }

      this.utilInitHibernate.closeSession();
      return (List)var3;
   }

   public List selectAmortissement(String var1, Date var2, Date var3, int var4, String var5, String var6, String var7, long var8, String var10, String var11, int var12, Session var13) throws HibernateException, NamingException, ParseException {
      boolean var14 = false;
      if (var13 == null) {
         var13 = this.utilInitHibernate.getOpenSession(this.mabase, "Amortissements");
         var14 = true;
      }

      new ArrayList();
      Criteria var16 = var13.createCriteria(Amortissements.class);
      UtilDate var17 = new UtilDate();
      Date var18 = var17.stringToDateSQLLight("2100-12-31");
      Date var19 = var17.stringToDateSQLLight("1900-01-01");
      String var20 = "" + (var2.getYear() + 1900);
      String var21 = "" + (var2.getYear() + 1900 - 1);
      if (!var1.equalsIgnoreCase("0")) {
         if (var1.equals("1")) {
            var18 = var17.stringToDateSQLLight(var20 + "-12-31");
            var19 = var17.stringToDateSQLLight(var20 + "-01-01");
            var16 = var16.add(Restrictions.between("amoDateAchat", var19, var18));
         } else if (var1.equalsIgnoreCase("2")) {
            var18 = var17.stringToDateSQLLight(var21 + "-12-31");
            var19 = var17.stringToDateSQLLight("1900-01-01");
            var16 = var16.add(Restrictions.between("amoDateAchat", var19, var18));
         } else if (var1.length() == 4) {
            var18 = var17.stringToDateSQLLight(var1 + "-12-31");
            var19 = var17.stringToDateSQLLight(var1 + "-01-01");
            var16 = var16.add(Restrictions.between("amoDateAchat", var19, var18));
         }
      }

      if (var5 != null && !var5.isEmpty()) {
         var16 = var16.add(Restrictions.eq("amoCompteImmo", var5));
      }

      if (var6 != null && !var6.isEmpty()) {
         if (var6.equals("****")) {
            var16 = var16.add(Restrictions.or(Restrictions.isNull("amoLocalisation"), Restrictions.eq("amoLocalisation", "")));
         } else {
            var16 = var16.add(Restrictions.eq("amoLocalisation", var6));
         }
      }

      String var22;
      if (var7 != null && !var7.isEmpty()) {
         var22 = "";
         if (var7.contains(":")) {
            String[] var23 = var7.split(":");
            var22 = var23[0];
         } else {
            var22 = var7;
         }

         var16 = var16.add(Restrictions.eq("amoActivite", var22));
      }

      if (var8 != 0L) {
         var16 = var16.add(Restrictions.eq("amoNum", var8));
      }

      if (var10 != null && !var10.isEmpty()) {
         var22 = "%" + var10 + "%";
         var16 = var16.add(Restrictions.or(Restrictions.like("amoReference", var22), Restrictions.like("amoLibelle", var22)));
      }

      if (var11 != null && !var11.isEmpty()) {
         var22 = "%" + var11 + "%";
         var16 = var16.add(Restrictions.like("amoChassis", var22));
      }

      if (var12 != 100) {
         var16 = var16.add(Restrictions.eq("amoNature", var12));
      }

      if (var4 != 100) {
         if (var4 == 0) {
            var16 = var16.add(Restrictions.eq("amoTypeSortie", 0));
         } else if (var4 == 1) {
            var16 = var16.add(Restrictions.eq("amoTypeSortie", 1));
         } else if (var4 == 2) {
            var16 = var16.add(Restrictions.eq("amoTypeSortie", 2));
         } else if (var4 == 3) {
            var16 = var16.add(Restrictions.eq("amoTypeSortie", 3));
         } else if (var4 == 4) {
            var16 = var16.add(Restrictions.eq("amoTypeSortie", 4));
         } else if (var4 == 5) {
            var16 = var16.add(Restrictions.eq("amoTypeSortie", 3)).add(Restrictions.isNull("amoDateSortie"));
         } else if (var4 == 6) {
            var16 = var16.add(Restrictions.eq("amoTypeSortie", 3)).add(Restrictions.isNotNull("amoDateSortie"));
         } else if (var4 == 7) {
            Date var24 = var17.dateDernierJourAnnee(var2);
            var16 = var16.add(Restrictions.or(Restrictions.eq("amoTypeSortie", 0), Restrictions.between("amoDateSortie", var2, var24)));
         } else if (var4 == 8) {
            var16 = var16.add(Restrictions.not(Restrictions.eq("amoTypeSortie", 4)));
            var16 = var16.add(Restrictions.or(Restrictions.isNull("amoDateSortie"), Restrictions.between("amoDateSortie", var2, var3)));
         } else if (var4 == 9) {
            var16 = var16.add(Restrictions.isNull("amoDateAchat"));
         }
      }

      var16 = var16.addOrder(Order.desc("amoNum"));
      List var25 = var16.list();
      if (var14) {
         this.utilInitHibernate.closeSession();
      }

      return var25;
   }

   public boolean verifMouvment(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Amortissements");
         var3 = true;
      }

      Query var5 = var2.createQuery("from Amortissements where amoCompteAmo='" + var1 + "'").setMaxResults(1);
      int var6 = var5.list().size();
      boolean var4;
      if (var6 > 0) {
         var4 = false;
      } else {
         var4 = true;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerAmortissementByNumCpteStartWith(Session var1, String var2) {
      Object var3 = new ArrayList();
      Query var4 = var1.createQuery("from Amortissements where amoCompteAmo like '" + var2 + "%' ");
      if (var4.list() != null) {
         var3 = var4.list();
      }

      return (List)var3;
   }

   public List chargerCompteAmoUtilise(Session var1) {
      new ArrayList();
      ArrayList var3 = new ArrayList();
      Query var4 = var1.createQuery("from Amortissements group by amoCompteAmo order by amoCompteAmo");
      if (var4.list() != null) {
         List var2 = var4.list();
         if (var2.size() != 0) {
            for(int var5 = 0; var5 < var2.size(); ++var5) {
               var3.add(new SelectItem(((Amortissements)var2.get(var5)).getAmoCompteAmo(), ((Amortissements)var2.get(var5)).getAmoCompteAmo() + ":" + this.filtreCaracteres(((Amortissements)var2.get(var5)).getAmoLibCompteAmo())));
            }
         }
      }

      return var3;
   }

   public List chargerCompteImoUtilise(Session var1) {
      new ArrayList();
      ArrayList var3 = new ArrayList();
      Query var4 = var1.createQuery("from Amortissements where (amoCompteImmo is not null or amoCompteImmo<>'') group by amoCompteImmo order by amoCompteImmo");
      if (var4.list() != null) {
         List var2 = var4.list();
         if (var2.size() != 0) {
            for(int var5 = 0; var5 < var2.size(); ++var5) {
               if (((Amortissements)var2.get(var5)).getAmoCompteImmo() != null && !((Amortissements)var2.get(var5)).getAmoCompteImmo().isEmpty()) {
                  var3.add(new SelectItem(((Amortissements)var2.get(var5)).getAmoCompteImmo(), ((Amortissements)var2.get(var5)).getAmoCompteImmo() + ":" + this.filtreCaracteres(((Amortissements)var2.get(var5)).getAmoLibCompteImo())));
               }
            }
         }
      }

      return var3;
   }

   public String filtreCaracteres(String var1) {
      String var2 = "";
      String var3 = "";
      if (var1 != null && !var1.isEmpty()) {
         for(int var4 = 0; var4 < var1.length(); ++var4) {
            var3 = (String)var1.subSequence(var4, var4 + 1);
            if (" ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890".contains(var3)) {
               var2 = var2 + var3.toUpperCase();
            }
         }
      }

      return var2;
   }

   public List chargerAnneeUtilisee(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Amortissements");
         var2 = true;
      }

      new ArrayList();
      ArrayList var4 = new ArrayList();
      Query var5 = var1.createQuery("from Amortissements where amoDateAchat is not null group by year(amoDateAchat)");
      if (var5.list() != null) {
         List var3 = var5.list();
         if (var3.size() != 0) {
            for(int var6 = 0; var6 < var3.size(); ++var6) {
               var4.add(new SelectItem(((Amortissements)var3.get(var6)).getAmoDateAchat().getYear() + 1900));
            }
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerlesImmobilisations(int var1, long var2, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Amortissements");
         var5 = true;
      }

      Object var6 = new ArrayList();
      Query var7 = null;
      if (var2 == 0L) {
         var7 = var4.createQuery("from Amortissements where amoNatureDetail=:nat").setInteger("nat", var1);
      } else {
         var7 = var4.createQuery("from Amortissements where amoNatureDetail=:nat and amoNnum=:numero").setInteger("nat", var1).setLong("numero", var2);
      }

      if (var7.list() != null) {
         var6 = var7.list();
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var6;
   }

   public List chargerlesImmobilisations(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Amortissements");
         var2 = true;
      }

      Query var3 = var1.createQuery("from Amortissements");
      new ArrayList();
      List var4 = var3.list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerlesImmobilisations(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Amortissements");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Amortissements where " + var1);
      new ArrayList();
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerlesImmobilisationsAmortis(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Amortissements");
         var2 = true;
      }

      new ArrayList();
      Query var4 = var1.createQuery("from Amortissements where amoTypeSortie>=1");
      List var3 = var4.list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public Amortissements trouverImmobilisation(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Amortissements");
         var4 = true;
      }

      this.amortissements = new Amortissements();
      new ArrayList();
      Query var6 = var3.createQuery("from Amortissements where amoId=:id").setLong("id", var1).setMaxResults(1);
      List var5 = var6.list();
      if (var5.size() != 0) {
         this.amortissements = (Amortissements)var5.get(0);
      } else {
         this.amortissements = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.amortissements;
   }

   public Amortissements trouverImmobilisationByNum(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Amortissements");
         var4 = true;
      }

      this.amortissements = new Amortissements();
      new ArrayList();
      Query var6 = var3.createQuery("from Amortissements where amoNum=:num").setLong("num", var1).setMaxResults(1);
      List var5 = var6.list();
      if (var5.size() != 0) {
         this.amortissements = (Amortissements)var5.get(0);
      } else {
         this.amortissements = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.amortissements;
   }

   public Amortissements trouverImmobilisationReception(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Amortissements");
         var4 = true;
      }

      this.amortissements = new Amortissements();
      new ArrayList();
      Query var6 = var3.createQuery("from Amortissements where amoIdReception=:id").setLong("id", var1).setMaxResults(1);
      List var5 = var6.list();
      if (var5.size() != 0) {
         this.amortissements = (Amortissements)var5.get(0);
      } else {
         this.amortissements = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.amortissements;
   }

   public Amortissements trouverOldImmobilisation(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Amortissements");
         var4 = true;
      }

      this.amortissements = new Amortissements();
      new ArrayList();
      Query var6 = var3.createQuery("from Amortissements where amoOldId=:id").setLong("id", var1).setMaxResults(1);
      List var5 = var6.list();
      if (var5.size() != 0) {
         this.amortissements = (Amortissements)var5.get(0);
      } else {
         this.amortissements = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.amortissements;
   }

   public long trouverDernier(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Amortissements");
         var2 = true;
      }

      long var3 = 0L;
      new ArrayList();
      Query var6 = var1.createQuery("from Amortissements order by amoNum DESC").setMaxResults(1);
      List var5 = var6.list();
      if (var5.size() != 0) {
         var3 = ((Amortissements)var5.get(0)).getAmoNum() + 1L;
      } else {
         var3 = 1L;
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }
}
