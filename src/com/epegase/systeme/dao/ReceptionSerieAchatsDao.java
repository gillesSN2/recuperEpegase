package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ChargementLigne;
import com.epegase.systeme.classe.LivraisonEnteteVentes;
import com.epegase.systeme.classe.LivraisonLigneVentes;
import com.epegase.systeme.classe.ReceptionEnteteAchats;
import com.epegase.systeme.classe.ReceptionLigneAchats;
import com.epegase.systeme.classe.ReceptionSerieAchats;
import com.epegase.systeme.classe.RetourLigneAchats;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class ReceptionSerieAchatsDao implements Serializable {
   private ReceptionSerieAchats receptionSerieAchats;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public ReceptionSerieAchatsDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public String getMaBase() {
      return this.maBase;
   }

   public void setMaBase(String var1) {
      this.maBase = var1;
   }

   public ReceptionSerieAchats insert(ReceptionSerieAchats var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ReceptionLigne");
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

   public ReceptionSerieAchats insert(ReceptionSerieAchats var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public ReceptionSerieAchats update(ReceptionSerieAchats var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public ReceptionSerieAchats modif(ReceptionSerieAchats var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ReceptionLigne");
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

   public ReceptionSerieAchats modif(ReceptionSerieAchats var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void deleteAllSerie(List var1, Session var2) throws HibernateException, NamingException {
      if (var1.size() != 0) {
         for(int var3 = 0; var3 < var1.size(); ++var3) {
            new ReceptionSerieAchats();
            ReceptionSerieAchats var4 = (ReceptionSerieAchats)var1.get(var3);
            var2.delete(var4);
         }
      }

   }

   public void libereAllSerie(List var1, Session var2) throws HibernateException, NamingException {
      if (var1.size() != 0) {
         for(int var3 = 0; var3 < var1.size(); ++var3) {
            new ReceptionSerieAchats();
            ReceptionSerieAchats var4 = (ReceptionSerieAchats)var1.get(var3);
            var4.setRecserEtat(0);
            var4.setRecserIdLigneBl(0L);
            var4.setRecserIdTiers(0L);
            var4.setRecserNomTiers("");
            var4.setRecserNumBl("");
            var2.update(var4);
         }
      }

   }

   public void deleteSerieLigne(ReceptionSerieAchats var1, Session var2) {
      var2.delete(var1);
   }

   public List selectReceptionSerieByRecLig(ReceptionLigneAchats var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ReceptionLigne");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from ReceptionSerieAchats where recserIdLigne=:receptionLigne order by recserId").setLong("receptionLigne", var1.getRecligId());
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List selectReceptionSerieByRecEnt(ReceptionEnteteAchats var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ReceptionLigne");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from ReceptionSerieAchats where recserNum=:receptionEntete order by recserId").setString("receptionEntete", var1.getRecNum());
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List selectRetourSerieByRecLig(RetourLigneAchats var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ReceptionLigne");
         var3 = true;
      }

      Query var4 = var2.createQuery("from ReceptionSerieAchats where recserIdLigne=:receptionLigne").setLong("receptionLigne", var1.getBrfligId());
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectBlSerieByBlLig(LivraisonLigneVentes var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "BlivraisonEntete");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from ReceptionSerieAchats where recserIdLigneBl=:blLigne order by recserId").setLong("blLigne", var1.getBlvligId());
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List selectBlSerieByBlEnt(LivraisonEnteteVentes var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "blivraisonLigne");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from ReceptionSerieAchats where recserNumBl=:blEntete order by recserId").setString("blEntete", var1.getBlvNum());
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List selectChargementSerieByBlLig(ChargementLigne var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "BchargementLigne");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from ReceptionSerieAchats where recserIdLigneChargement=:chgLigne order by recserId").setLong("chgLigne", var1.getChaligId());
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List selectSerieDispo(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "ReceptionLigne");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from ReceptionSerieAchats where recserCode=:prod and recserDepot=:dep and recserEtat=0").setString("prod", var1).setString("dep", var2);
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectSerieUtil(String var1, String var2, long var3, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "ReceptionLigne");
         var6 = true;
      }

      new ArrayList();
      Query var8 = var5.createQuery("from ReceptionSerieAchats where recserCode=:prod and recserDepot=:dep and recserEtat=1 and recserIdLigneBl=:idLigne").setString("prod", var1).setString("dep", var2).setLong("idLigne", var3);
      List var7 = var8.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List selectSerieDispoByCarton(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "ReceptionLigne");
         var5 = true;
      }

      new ArrayList();
      Query var7 = var4.createQuery("from ReceptionSerieAchats where recserCode=:prod and recserDepot=:dep and recserEtat=0 and recserCarton=:cart order by recserSerie").setString("prod", var1).setString("dep", var2).setString("cart", var3);
      List var6 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List selectSerieDispoByPalette(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "ReceptionLigne");
         var5 = true;
      }

      new ArrayList();
      Query var7 = var4.createQuery("from ReceptionSerieAchats where recserCode=:prod and recserDepot=:dep and recserEtat=0 and recserPalette=:pal order by recserSerie").setString("prod", var1).setString("dep", var2).setString("pal", var3);
      List var6 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public ReceptionSerieAchats rechercheSerie(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "ReceptionLigne");
         var5 = true;
      }

      new ReceptionSerieAchats();
      Query var7 = var4.createQuery("from ReceptionSerieAchats where recserCode=:prod and recserDepot=:dep and recserSerie=:ser").setString("prod", var1).setString("dep", var2).setString("ser", var3).setMaxResults(1);
      List var8 = var7.list();
      ReceptionSerieAchats var6;
      if (var8.size() != 0) {
         var6 = (ReceptionSerieAchats)var8.get(0);
      } else {
         var6 = null;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public ReceptionSerieAchats rechercheSerieByNum(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ReceptionLigne");
         var3 = true;
      }

      new ReceptionSerieAchats();
      Query var5 = var2.createQuery("from ReceptionSerieAchats where recserSerie=:ser").setString("ser", var1).setMaxResults(1);
      List var6 = var5.list();
      ReceptionSerieAchats var4;
      if (var6.size() != 0) {
         var4 = (ReceptionSerieAchats)var6.get(0);
      } else {
         var4 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List rechercheSerieByCarton(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "ReceptionLigne");
         var4 = true;
      }

      ArrayList var5 = new ArrayList();
      Query var6 = var3.createQuery("from ReceptionSerieAchats where recserCode=:prod and recserDepot=:dep and recserEtat=0 group by recserCarton").setString("prod", var1).setString("dep", var2);
      List var7 = var6.list();
      if (var7.size() != 0) {
         new ReceptionSerieAchats();

         for(int var9 = 0; var9 < var7.size(); ++var9) {
            new ReceptionSerieAchats();
            ReceptionSerieAchats var8 = (ReceptionSerieAchats)var7.get(var9);
            if (var8.getRecserCarton() != null && !var8.getRecserCarton().isEmpty()) {
               var5.add(new SelectItem(var8.getRecserCarton()));
            }
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheSerieByPalette(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "ReceptionLigne");
         var4 = true;
      }

      ArrayList var5 = new ArrayList();
      Query var6 = var3.createQuery("from ReceptionSerieAchats where recserCode=:prod and recserDepot=:dep and recserEtat=0 group by recserPalette").setString("prod", var1).setString("dep", var2);
      List var7 = var6.list();
      if (var7.size() != 0) {
         new ReceptionSerieAchats();

         for(int var9 = 0; var9 < var7.size(); ++var9) {
            new ReceptionSerieAchats();
            ReceptionSerieAchats var8 = (ReceptionSerieAchats)var7.get(var9);
            if (var8.getRecserPalette() != null && !var8.getRecserPalette().isEmpty()) {
               var5.add(new SelectItem(var8.getRecserPalette()));
            }
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List recherche(Session var1, long var2, String var4, int var5, String var6, String var7, String var8) throws HibernateException, NamingException {
      new ArrayList();
      boolean var10 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "ReceptionLigne");
         var10 = true;
      }

      Criteria var11 = var1.createCriteria(ReceptionSerieAchats.class);
      if (var4 != null && !var4.isEmpty()) {
         String var12 = "%" + var4;
         var11 = var11.add(Restrictions.like("recserSerie", var12));
      }

      if (!var6.equals("0")) {
         var11 = var11.add(Restrictions.eq("recserCarton", var6));
      }

      if (!var7.equals("0")) {
         var11 = var11.add(Restrictions.eq("recserPalette", var7));
      }

      if (!var8.equals("0")) {
         var11 = var11.add(Restrictions.eq("recserLot", var8));
      }

      if (var5 == 0) {
         var11 = var11.add(Restrictions.or(Restrictions.eq("recserNum", ""), Restrictions.isNull("recserNum")));
      } else if (var5 == 1) {
         var11 = var11.add(Restrictions.ne("recserNum", "")).add(Restrictions.isNotNull("recserNum"));
      } else if (var5 == 2) {
         var11 = var11.add(Restrictions.or(Restrictions.eq("recserNumBl", ""), Restrictions.isNull("recserNumBl")));
      } else if (var5 == 3) {
         var11 = var11.add(Restrictions.ne("recserNumBl", "")).add(Restrictions.isNotNull("recserNumBl"));
      }

      List var13 = var11.list();
      if (var10) {
         this.utilInitHibernate.closeSession();
      }

      return var13;
   }
}
