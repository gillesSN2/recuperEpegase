package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Rdv;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RdvDao implements Serializable {
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public RdvDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public Rdv insert(Rdv var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
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

   public Rdv insert(Rdv var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public Rdv modif(Rdv var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
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

   public Rdv modif(Rdv var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public Rdv delete(Rdv var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
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

      return var1;
   }

   public void delete(Rdv var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public String delRdv(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
      Transaction var4 = var3.beginTransaction();
      var4.begin();
      Query var5 = var3.createQuery("delete from Rdv where Rdv_id =:bid").setLong("bid", var1);
      var5.executeUpdate();
      var4.commit();
      this.utilInitHibernate.closeSession();
      return null;
   }

   public List selectRdvMPMois(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
      List var4 = var3.createQuery("from Rdv where (rdvUsrDe=:idusersLog or users=:idusersLog) ").setLong("idusersLog", var1).list();
      this.utilInitHibernate.closeSession();
      ArrayList var5 = new ArrayList();
      new Rdv();

      for(int var7 = 0; var7 < var4.size(); ++var7) {
         Rdv var6 = (Rdv)var4.get(var7);
         var5.add(var6);
      }

      return var5;
   }

   public List selectRdvAll() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
      List var2 = var1.createQuery("from Rdv").list();
      this.utilInitHibernate.closeSession();
      Object var3 = new ArrayList();
      if (var2.size() > 0) {
         var3 = var2;
      }

      return (List)var3;
   }

   public List selectRdvAllDay(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
      List var4 = var3.createQuery("from Rdv where rdvUsrDe=:idusersLog or users=:idusersLog").setLong("idusersLog", var1).list();
      this.utilInitHibernate.closeSession();
      Object var5 = new ArrayList();
      if (var4.size() > 0) {
         var5 = var4;
      }

      return (List)var5;
   }

   public List selectRdv(long var1, Session var3) throws HibernateException, NamingException {
      Date var4 = new Date();
      SimpleDateFormat var5 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
      String var6 = var5.format(var4);
      boolean var7 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
         var7 = true;
      }

      List var8 = var3.createQuery("from Rdv where (rdvUsrDe=" + var1 + " or users=" + var1 + ") and rdv_nature!=2 and rdvDteDe=" + "'" + var6 + "'").list();
      ArrayList var9 = new ArrayList();
      new Rdv();

      for(int var11 = 0; var11 < var8.size(); ++var11) {
         Rdv var10 = (Rdv)var8.get(var11);
         var9.add(var10);
      }

      if (var7) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public List selectEvenements(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
         var4 = true;
      }

      List var5 = var3.createQuery("from Rdv where rdvUsrDe=" + var1).list();
      ArrayList var6 = new ArrayList();
      new Rdv();

      for(int var8 = 0; var8 < var5.size(); ++var8) {
         Rdv var7 = (Rdv)var5.get(var8);
         var6.add(var7);
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List selectRdvEnCours(long var1, Session var3) throws HibernateException, NamingException {
      Date var4 = new Date();
      SimpleDateFormat var5 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
      String var6 = var5.format(var4);
      boolean var7 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
         var7 = true;
      }

      List var8 = var3.createQuery("from Rdv where (rdvUsrDe=" + var1 + " or users=" + var1 + ") and rdv_nature!=2 and rdvDteDe=" + "'" + var6 + "' and rdv_etat=0").list();
      ArrayList var9 = new ArrayList();
      new Rdv();

      for(int var11 = 0; var11 < var8.size(); ++var11) {
         Rdv var10 = (Rdv)var8.get(var11);
         var9.add(var10);
      }

      if (var7) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public List selectRdv(long var1, Date var3, Date var4, int var5, String var6, Session var7) throws HibernateException, NamingException {
      boolean var8 = false;
      if (var7 == null) {
         var7 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
         var8 = true;
      }

      new Date();
      SimpleDateFormat var10 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
      String var11 = var10.format(var3);
      String var12 = var10.format(var4);
      List var13 = null;
      if (var6 != null && !var6.isEmpty()) {
         if (var6.equals("100")) {
            if (var5 == 99) {
               var13 = var7.createQuery("from Rdv where (rdvUsrDe=:idusersLog or users=:idusersLog) and rdvDteDe>='" + var11 + "'" + " and rdvDteDe<=" + "'" + var12 + "'").setLong("idusersLog", var1).list();
            } else {
               var13 = var7.createQuery("from Rdv where (rdvUsrDe=:idusersLog or users=:idusersLog) and rdv_nature=:nat and rdvDteDe>='" + var11 + "'" + " and rdvDteDe<=" + "'" + var12 + "'").setLong("idusersLog", var1).setInteger("nat", var5).list();
            }
         } else if (var6.equals("-100")) {
            if (var5 == 99) {
               var13 = var7.createQuery("from Rdv where (rdvService is  null or rdvService='') and rdvDteDe>='" + var11 + "'" + " and rdvDteDe<=" + "'" + var12 + "'").list();
            } else {
               var13 = var7.createQuery("from Rdv where (rdvService is  null or rdvService='') and rdv_nature=:nat and rdvDteDe>='" + var11 + "'" + " and rdvDteDe<=" + "'" + var12 + "'").setInteger("nat", var5).list();
            }
         } else if (var5 == 99) {
            var13 = var7.createQuery("from Rdv where rdvService='" + var6 + "' and rdvDteDe>=" + "'" + var11 + "'" + " and rdvDteDe<=" + "'" + var12 + "'").list();
         } else {
            var13 = var7.createQuery("from Rdv where rdvService='" + var6 + "' and rdv_nature=:nat and rdvDteDe>=" + "'" + var11 + "'" + " and rdvDteDe<=" + "'" + var12 + "'").setInteger("nat", var5).list();
         }
      } else if (var5 == 99) {
         var13 = var7.createQuery("from Rdv where (rdvUsrDe=:idusersLog or users=:idusersLog) and rdvDteDe>='" + var11 + "'" + " and rdvDteDe<=" + "'" + var12 + "'").setLong("idusersLog", var1).list();
      } else {
         var13 = var7.createQuery("from Rdv where (rdvUsrDe=:idusersLog or users=:idusersLog) and rdv_nature=:nat and rdvDteDe>='" + var11 + "'" + " and rdvDteDe<=" + "'" + var12 + "'").setLong("idusersLog", var1).setInteger("nat", var5).list();
      }

      ArrayList var14 = new ArrayList();
      new Rdv();

      for(int var16 = 0; var16 < var13.size(); ++var16) {
         Rdv var15 = (Rdv)var13.get(var16);
         var14.add(var15);
      }

      if (var8) {
         this.utilInitHibernate.closeSession();
      }

      return var14;
   }

   public List selectRdv(Date var1, Date var2, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
         var5 = true;
      }

      new Date();
      SimpleDateFormat var7 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
      String var8 = var7.format(var1);
      String var9 = var7.format(var2);
      List var10 = null;
      if (var3 == 99) {
         var10 = var4.createQuery("from Rdv where rdv_nature=12 and rdvDteDe>='" + var8 + "'" + " and rdvDteDe<=" + "'" + var9 + "'").list();
      } else {
         var10 = var4.createQuery("from Rdv where rdv_nature=12 and rdvDteDe>='" + var8 + "'" + " and rdvDteDe<=" + "'" + var9 + "'").list();
      }

      ArrayList var11 = new ArrayList();
      new Rdv();

      for(int var13 = 0; var13 < var10.size(); ++var13) {
         Rdv var12 = (Rdv)var10.get(var13);
         var11.add(var12);
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var11;
   }

   public List selectRdv(long var1, Date var3, int var4, String var5, Session var6) throws HibernateException, NamingException {
      SimpleDateFormat var7 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
      String var8 = var7.format(var3);
      boolean var9 = false;
      if (var6 == null) {
         var6 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
         var9 = true;
      }

      List var10 = null;
      if (var5 != null && !var5.isEmpty()) {
         if (var5.equals("100")) {
            if (var4 == 99) {
               var10 = var6.createQuery("from Rdv where (rdvUsrDe=:idusersLog or users=:idusersLog) and rdvDteDe>='" + var8 + "'").setLong("idusersLog", var1).list();
            } else {
               var10 = var6.createQuery("from Rdv where (rdvUsrDe=:idusersLog or users=:idusersLog) and rdv_nature=:nat and rdvDteDe>='" + var8 + "'").setLong("idusersLog", var1).setInteger("nat", var4).list();
            }
         } else if (var5.equals("-100")) {
            if (var4 == 99) {
               var10 = var6.createQuery("from Rdv where (rdvService is  null or rdvService='') and rdvDteDe='" + var8 + "'").list();
            } else {
               var10 = var6.createQuery("from Rdv where (rdvService is  null or rdvService='') and rdv_nature=:nat and rdvDteDe='" + var8 + "'").setInteger("nat", var4).list();
            }
         } else if (var4 == 99) {
            var10 = var6.createQuery("from Rdv where rdvService='" + var5 + "' and rdvDteDe=" + "'" + var8 + "'").list();
         } else {
            var10 = var6.createQuery("from Rdv where rdvService='" + var5 + "' and rdv_nature=:nat and rdvDteDe=" + "'" + var8 + "'").setInteger("nat", var4).list();
         }
      } else if (var4 == 99) {
         var10 = var6.createQuery("from Rdv where (rdvUsrDe=:idusersLog or users=:idusersLog)  and rdvDteDe='" + var8 + "'").setLong("idusersLog", var1).list();
      } else {
         var10 = var6.createQuery("from Rdv where (rdvUsrDe=:idusersLog or users=:idusersLog) and rdv_nature=:nat and rdvDteDe='" + var8 + "'").setLong("idusersLog", var1).setInteger("nat", var4).list();
      }

      ArrayList var11 = new ArrayList();
      new Rdv();

      for(int var13 = 0; var13 < var10.size(); ++var13) {
         Rdv var12 = (Rdv)var10.get(var13);
         var11.add(var12);
      }

      if (var9) {
         this.utilInitHibernate.closeSession();
      }

      return var11;
   }

   public List selectTdo(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
         var4 = true;
      }

      List var5 = var3.createQuery("from Rdv where users=:idusersLog and (rdv_nature=0 or rdv_nature=2 or rdv_nature=3 or rdv_nature=10) and rdv_etat=0 ").setLong("idusersLog", var1).list();
      ArrayList var6 = new ArrayList();
      new Rdv();

      for(int var8 = 0; var8 < var5.size(); ++var8) {
         Rdv var7 = (Rdv)var5.get(var8);
         var6.add(var7);
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List selectRdvLog(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
      List var4 = var3.createQuery("from Rdv where usr_id ='" + var1 + "'").list();
      this.utilInitHibernate.closeSession();
      return var4.size() > 0 ? var4 : null;
   }

   public List selectRdvLogPlan(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
      Query var4 = var3.createQuery("from Rdv where  rdv_tie_id_de='" + var1 + "'");
      this.utilInitHibernate.closeSession();
      List var5 = var4.list();
      return var5.size() > 0 ? var5 : null;
   }

   public List selectRdvLogPlanCurrent(long var1, Date var3) throws HibernateException, NamingException {
      DateFormat var4 = DateFormat.getDateInstance(3);
      Session var5 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
      List var6 = var5.createQuery("from Rdv where usr_id ='" + var1 + "'").list();
      this.utilInitHibernate.closeSession();
      ArrayList var7 = new ArrayList();
      if (var6.size() > 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            if (((Rdv)var6.get(var8)).getRdvDteDe() != null) {
               Date var9 = ((Rdv)var6.get(var8)).getRdvDteDe();
               if (var4.format(var9).equals(var4.format(var3))) {
                  var7.add((Rdv)var6.get(var8));
               }
            }
         }
      }

      return var7.size() > 0 ? var7 : null;
   }

   public List selectMesRdvPlanCurrent(long var1, Date var3) throws HibernateException, NamingException {
      java.sql.Date var5 = new java.sql.Date(var3.getTime());
      Session var6 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
      List var7 = var6.createQuery("from Rdv where rdv_tie_id_de ='" + var1 + "'").list();
      this.utilInitHibernate.closeSession();
      ArrayList var8 = new ArrayList();
      if (var7.size() > 0) {
         for(int var9 = 0; var9 < var7.size(); ++var9) {
            if (((Rdv)var7.get(var9)).getRdvDteDe() != null) {
               Date var10 = ((Rdv)var7.get(var9)).getRdvDteDe();
               if (var10.equals(var5)) {
                  var8.add((Rdv)var7.get(var9));
               }
            }
         }
      }

      return var8.size() > 0 ? var8 : null;
   }

   public Rdv logRdv(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
      List var4 = var3.createQuery("from Rdv where Rdv_id =" + var1).list();
      this.utilInitHibernate.closeSession();
      return (Rdv)var4.get(0);
   }

   public Rdv logRdv(long var1, Session var3) throws HibernateException, NamingException {
      new Rdv();
      List var5 = var3.createQuery("from Rdv where Rdv_id =" + var1).list();
      Rdv var4;
      if (var5.size() != 0) {
         var4 = (Rdv)var5.get(0);
      } else {
         var4 = null;
      }

      return var4;
   }

   public Rdv logRdvIdPrincipal(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
         var4 = true;
      }

      new Rdv();
      List var6 = var3.createQuery("from Rdv where Rdv_id_principal =" + var1).list();
      Rdv var5;
      if (var6.size() != 0) {
         var5 = (Rdv)var6.get(0);
      } else {
         var5 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public Rdv logRdvIdPrincipalRdv(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
         var4 = true;
      }

      new Rdv();
      List var6 = var3.createQuery("from Rdv where Rdv_id_principal_rdv =" + var1 + " and rdv_nature <> 2").list();
      Rdv var5;
      if (var6.size() != 0) {
         var5 = (Rdv)var6.get(0);
      } else {
         var5 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public Rdv logRdvIdPrincipalTodo(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
         var4 = true;
      }

      new Rdv();
      List var6 = var3.createQuery("from Rdv where Rdv_id_principal_rdv =" + var1 + " and rdv_nature = 2").list();
      Rdv var5;
      if (var6.size() != 0) {
         var5 = (Rdv)var6.get(0);
      } else {
         var5 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerRdvTiers(int var1, long var2, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
         var5 = true;
      }

      Query var6 = null;
      if (var1 == 99) {
         var6 = var4.createQuery("from Rdv where rdv_tie_id_de=:paramTiers").setLong("paramTiers", var2);
      } else {
         var6 = var4.createQuery("from Rdv where rdv_tie_id_de=:paramTiers and  rdvNature=:paramNat ").setLong("paramTiers", var2).setInteger("paramNat", var1);
      }

      Object var7 = new ArrayList();
      if (var6.list().size() > 0) {
         var7 = var6.list();
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var7;
   }

   public List chargerRdv(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
         var3 = true;
      }

      Query var4 = null;
      if (var1 == 99) {
         var4 = var2.createQuery("from Rdv group by rdvTieIdDe");
      } else {
         var4 = var2.createQuery("from Rdv where rdvNature=:paramNat group by rdvTieIdDe").setInteger("paramNat", var1);
      }

      Object var5 = new ArrayList();
      if (var4.list().size() > 0) {
         var5 = var4.list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var5;
   }

   public List chargerRdvUser(int var1, long var2, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
         var5 = true;
      }

      Query var6 = null;
      if (var1 == 99) {
         var6 = var4.createQuery("from Rdv where (rdv_usr_de=:paramUser or usr_id=:paramUser)").setLong("paramUser", var2);
      } else {
         var6 = var4.createQuery("from Rdv where (rdv_usr_de=:paramUser or usr_id=:paramUser) and  rdvNature=:paramNat ").setLong("paramUser", var2).setInteger("paramNat", var1);
      }

      Object var7 = new ArrayList();
      if (var6.list().size() > 0) {
         var7 = var6.list();
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var7;
   }

   public List chargerRdvInvite(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
         var4 = true;
      }

      Query var5 = var3.createQuery("from Rdv where rdv_id_principal=:invit").setLong("invit", var1);
      Object var6 = new ArrayList();
      if (var5.list().size() > 0) {
         var6 = var5.list();
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var6;
   }

   public List rechercheRdvRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Rdv where " + var1 + " order by rdvDteDe,rdvHrDe,rdvMnDe");
      Object var5 = new ArrayList();
      if (var4.list().size() > 0) {
         var5 = var4.list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var5;
   }

   public Rdv chargerRdvUser(int var1, long var2, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
         var6 = true;
      }

      Query var7 = var5.createQuery("from Rdv where (rdv_usr_de=:paramUser or usr_id=:paramUser) and rdvNature=:paramNat and rdvDteDe=:dte").setLong("paramUser", var2).setInteger("paramNat", var1).setDate("dte", var4).setMaxResults(1);
      new ArrayList();
      new Rdv();
      Rdv var9;
      if (var7.list().size() > 0) {
         List var8 = var7.list();
         if (var8.size() != 0) {
            var9 = (Rdv)var8.get(0);
         } else {
            var9 = null;
         }
      } else {
         var9 = null;
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }
}
