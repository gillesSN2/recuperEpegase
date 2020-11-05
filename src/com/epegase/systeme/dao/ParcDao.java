package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.text.DateFormat;
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

public class ParcDao implements Serializable {
   private Parc parc;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public ParcDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public Parc insert(Parc var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Parc");
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

   public Parc insert(Parc var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public Parc modif(Parc var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Parc");
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

   public Parc modif(Parc var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public String delete(Parc var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Parc");
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

      return null;
   }

   public String delete(Parc var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
      return null;
   }

   public List selectParc() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Parc");
      List var2 = var1.createQuery(" from Parc order by prcCle asc, prcCode asc").list();
      this.utilInitHibernate.closeSession();
      return var2;
   }

   public List chargerLesParcs(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Parc");
         var2 = true;
      }

      List var3 = var1.createQuery("from Parc where prcInactif =0 order by prcImmatriculation").list();
      List var4 = var3;
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            if (((Parc)var4.get(var6)).getPrcMarque() != null && !((Parc)var4.get(var6)).getPrcMarque().isEmpty()) {
               var5.add(new SelectItem(((Parc)var4.get(var6)).getPrcImmatriculation() + ":" + ((Parc)var4.get(var6)).getPrcMarque()));
            } else if (((Parc)var4.get(var6)).getPrcNomFr() != null && !((Parc)var4.get(var6)).getPrcNomFr().isEmpty()) {
               var5.add(new SelectItem(((Parc)var4.get(var6)).getPrcImmatriculation() + ":" + ((Parc)var4.get(var6)).getPrcNomFr()));
            } else {
               var5.add(new SelectItem(((Parc)var4.get(var6)).getPrcImmatriculation() + ":" + "n.d."));
            }
         }
      }

      return var5;
   }

   public List chargerLesParcsCamions(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Parc");
         var2 = true;
      }

      List var3 = var1.createQuery("from Parc where (prc_nature=1721 or prc_nature=1722 or prc_nature=1724) and prcInactif=0 order by prcImmatriculation").list();
      List var4 = var3;
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            if (((Parc)var4.get(var6)).getPrcImmatriculation() != null && !((Parc)var4.get(var6)).getPrcImmatriculation().isEmpty()) {
               if (((Parc)var4.get(var6)).getPrcMarque() != null && !((Parc)var4.get(var6)).getPrcMarque().isEmpty()) {
                  var5.add(new SelectItem(((Parc)var4.get(var6)).getPrcImmatriculation(), ((Parc)var4.get(var6)).getPrcImmatriculation() + ":" + ((Parc)var4.get(var6)).getPrcMarque()));
               } else if (((Parc)var4.get(var6)).getPrcNomFr() != null && !((Parc)var4.get(var6)).getPrcNomFr().isEmpty()) {
                  var5.add(new SelectItem(((Parc)var4.get(var6)).getPrcImmatriculation(), ((Parc)var4.get(var6)).getPrcImmatriculation() + ":" + ((Parc)var4.get(var6)).getPrcNomFr()));
               } else {
                  var5.add(new SelectItem(((Parc)var4.get(var6)).getPrcImmatriculation(), ((Parc)var4.get(var6)).getPrcImmatriculation() + ":" + ((Parc)var4.get(var6)).getPrcImmatriculation()));
               }
            }
         }
      }

      return var5;
   }

   public List chargerLesParcsVoituresCamions(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Parc");
         var2 = true;
      }

      List var3 = var1.createQuery("from Parc where (prc_nature=1701 or prc_nature=1702 or prc_nature=1703 or prc_nature=1704 or prc_nature=1711 or prc_nature=1712 or prc_nature=1713 or prc_nature=1714 or prc_nature=1715 or prc_nature=1721 or prc_nature=1722 or prc_nature=1723 or prc_nature=1724) and prcInactif=0 order by prcImmatriculation").list();
      List var4 = var3;
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            if (((Parc)var4.get(var6)).getPrcImmatriculation() != null && !((Parc)var4.get(var6)).getPrcImmatriculation().isEmpty()) {
               if (((Parc)var4.get(var6)).getPrcMarque() != null && !((Parc)var4.get(var6)).getPrcMarque().isEmpty()) {
                  var5.add(new SelectItem(((Parc)var4.get(var6)).getPrcImmatriculation(), ((Parc)var4.get(var6)).getPrcImmatriculation() + ":" + ((Parc)var4.get(var6)).getPrcMarque()));
               } else if (((Parc)var4.get(var6)).getPrcNomFr() != null && !((Parc)var4.get(var6)).getPrcNomFr().isEmpty()) {
                  var5.add(new SelectItem(((Parc)var4.get(var6)).getPrcImmatriculation(), ((Parc)var4.get(var6)).getPrcImmatriculation() + ":" + ((Parc)var4.get(var6)).getPrcNomFr()));
               } else {
                  var5.add(new SelectItem(((Parc)var4.get(var6)).getPrcImmatriculation(), ((Parc)var4.get(var6)).getPrcImmatriculation() + ":" + ((Parc)var4.get(var6)).getPrcImmatriculation()));
               }
            }
         }
      }

      return var5;
   }

   public List chargerLesParcsRemorques(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Parc");
         var2 = true;
      }

      List var3 = var1.createQuery("from Parc where prc_nature=1725 and prcInactif=0 order by prcImmatriculation").list();
      List var4 = var3;
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            if (((Parc)var4.get(var6)).getPrcImmatriculation() != null && !((Parc)var4.get(var6)).getPrcImmatriculation().isEmpty()) {
               if (((Parc)var4.get(var6)).getPrcMarque() != null && !((Parc)var4.get(var6)).getPrcMarque().isEmpty()) {
                  var5.add(new SelectItem(((Parc)var4.get(var6)).getPrcImmatriculation(), ((Parc)var4.get(var6)).getPrcImmatriculation() + ":" + ((Parc)var4.get(var6)).getPrcMarque()));
               } else if (((Parc)var4.get(var6)).getPrcNomFr() != null && !((Parc)var4.get(var6)).getPrcNomFr().isEmpty()) {
                  var5.add(new SelectItem(((Parc)var4.get(var6)).getPrcImmatriculation(), ((Parc)var4.get(var6)).getPrcImmatriculation() + ":" + ((Parc)var4.get(var6)).getPrcNomFr()));
               } else {
                  var5.add(new SelectItem(((Parc)var4.get(var6)).getPrcImmatriculation(), ((Parc)var4.get(var6)).getPrcImmatriculation() + ":" + ((Parc)var4.get(var6)).getPrcImmatriculation()));
               }
            }
         }
      }

      return var5;
   }

   public List chargerLesParcsTrains(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Parc");
         var2 = true;
      }

      List var3 = var1.createQuery("from Parc where prc_nature>=1731 and prc_nature<=1739 and prcInactif=0 order by prcImmatriculation").list();
      List var4 = var3;
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            if (((Parc)var4.get(var6)).getPrcImmatriculation() != null && !((Parc)var4.get(var6)).getPrcImmatriculation().isEmpty()) {
               if (((Parc)var4.get(var6)).getPrcMarque() != null && !((Parc)var4.get(var6)).getPrcMarque().isEmpty()) {
                  var5.add(new SelectItem(((Parc)var4.get(var6)).getPrcImmatriculation(), ((Parc)var4.get(var6)).getPrcImmatriculation() + ":" + ((Parc)var4.get(var6)).getPrcMarque()));
               } else if (((Parc)var4.get(var6)).getPrcNomFr() != null && !((Parc)var4.get(var6)).getPrcNomFr().isEmpty()) {
                  var5.add(new SelectItem(((Parc)var4.get(var6)).getPrcImmatriculation(), ((Parc)var4.get(var6)).getPrcImmatriculation() + ":" + ((Parc)var4.get(var6)).getPrcNomFr()));
               } else {
                  var5.add(new SelectItem(((Parc)var4.get(var6)).getPrcImmatriculation(), ((Parc)var4.get(var6)).getPrcImmatriculation() + ":" + ((Parc)var4.get(var6)).getPrcImmatriculation()));
               }
            }
         }
      }

      return var5;
   }

   public List chargerLesParcsBateaux(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Parc");
         var2 = true;
      }

      List var3 = var1.createQuery("from Parc where prc_nature>=1741 and prc_nature<=1749 and prcInactif=0 order by prcImmatriculation").list();
      List var4 = var3;
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            if (((Parc)var4.get(var6)).getPrcImmatriculation() != null && !((Parc)var4.get(var6)).getPrcImmatriculation().isEmpty()) {
               if (((Parc)var4.get(var6)).getPrcMarque() != null && !((Parc)var4.get(var6)).getPrcMarque().isEmpty()) {
                  var5.add(new SelectItem(((Parc)var4.get(var6)).getPrcImmatriculation(), ((Parc)var4.get(var6)).getPrcImmatriculation() + ":" + ((Parc)var4.get(var6)).getPrcMarque()));
               } else if (((Parc)var4.get(var6)).getPrcNomFr() != null && !((Parc)var4.get(var6)).getPrcNomFr().isEmpty()) {
                  var5.add(new SelectItem(((Parc)var4.get(var6)).getPrcImmatriculation(), ((Parc)var4.get(var6)).getPrcImmatriculation() + ":" + ((Parc)var4.get(var6)).getPrcNomFr()));
               } else {
                  var5.add(new SelectItem(((Parc)var4.get(var6)).getPrcImmatriculation(), ((Parc)var4.get(var6)).getPrcImmatriculation() + ":" + ((Parc)var4.get(var6)).getPrcImmatriculation()));
               }
            }
         }
      }

      return var5;
   }

   public List chargerLesParcsAvions(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Parc");
         var2 = true;
      }

      List var3 = var1.createQuery("from Parc where prc_nature>=1751 and prc_nature<=1759 and prcInactif=0 order by prcImmatriculation").list();
      List var4 = var3;
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            if (((Parc)var4.get(var6)).getPrcImmatriculation() != null && !((Parc)var4.get(var6)).getPrcImmatriculation().isEmpty()) {
               if (((Parc)var4.get(var6)).getPrcMarque() != null && !((Parc)var4.get(var6)).getPrcMarque().isEmpty()) {
                  var5.add(new SelectItem(((Parc)var4.get(var6)).getPrcImmatriculation(), ((Parc)var4.get(var6)).getPrcImmatriculation() + ":" + ((Parc)var4.get(var6)).getPrcMarque()));
               } else if (((Parc)var4.get(var6)).getPrcNomFr() != null && !((Parc)var4.get(var6)).getPrcNomFr().isEmpty()) {
                  var5.add(new SelectItem(((Parc)var4.get(var6)).getPrcImmatriculation(), ((Parc)var4.get(var6)).getPrcImmatriculation() + ":" + ((Parc)var4.get(var6)).getPrcNomFr()));
               } else {
                  var5.add(new SelectItem(((Parc)var4.get(var6)).getPrcImmatriculation(), ((Parc)var4.get(var6)).getPrcImmatriculation() + ":" + ((Parc)var4.get(var6)).getPrcImmatriculation()));
               }
            }
         }
      }

      return var5;
   }

   public List chargerLesParcsConteneurs(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Parc");
         var2 = true;
      }

      List var3 = var1.createQuery("from Parc where prc_nature=1726 and prcInactif=0 order by prcImmatriculation").list();
      List var4 = var3;
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            if (((Parc)var4.get(var6)).getPrcImmatriculation() != null && !((Parc)var4.get(var6)).getPrcImmatriculation().isEmpty()) {
               if (((Parc)var4.get(var6)).getPrcMarque() != null && !((Parc)var4.get(var6)).getPrcMarque().isEmpty()) {
                  var5.add(new SelectItem(((Parc)var4.get(var6)).getPrcImmatriculation(), ((Parc)var4.get(var6)).getPrcImmatriculation() + ":" + ((Parc)var4.get(var6)).getPrcMarque()));
               } else if (((Parc)var4.get(var6)).getPrcNomFr() != null && !((Parc)var4.get(var6)).getPrcNomFr().isEmpty()) {
                  var5.add(new SelectItem(((Parc)var4.get(var6)).getPrcImmatriculation(), ((Parc)var4.get(var6)).getPrcImmatriculation() + ":" + ((Parc)var4.get(var6)).getPrcNomFr()));
               } else {
                  var5.add(new SelectItem(((Parc)var4.get(var6)).getPrcImmatriculation(), ((Parc)var4.get(var6)).getPrcImmatriculation() + ":" + ((Parc)var4.get(var6)).getPrcImmatriculation()));
               }
            }
         }
      }

      return var5;
   }

   public List chargerLesParcs(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Parc");
         var4 = true;
      }

      List var5 = var3.createQuery("from Parc where prcInactif=0 and prcIdTiers=:tie order by prcImmatriculation").setLong("tie", var1).list();
      List var6 = var5;
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var7 = new ArrayList();
      if (var5.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            if (((Parc)var6.get(var8)).getPrcImmatriculation() != null && !((Parc)var6.get(var8)).getPrcImmatriculation().isEmpty() && ((Parc)var6.get(var8)).getPrcMarque() != null && !((Parc)var6.get(var8)).getPrcMarque().isEmpty()) {
               var7.add(new SelectItem(((Parc)var6.get(var8)).getPrcImmatriculation() + ":" + ((Parc)var6.get(var8)).getPrcMarque()));
            }
         }
      }

      return var7;
   }

   public List selectLesParcs(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Parc");
         var2 = true;
      }

      List var3 = var1.createQuery("from Parc  order by prcImmatriculation").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List rechercheParc(String var1, String var2, String var3, String var4, String var5, String var6, Session var7) throws HibernateException, NamingException {
      boolean var8 = false;
      if (var7 == null) {
         var7 = this.utilInitHibernate.getOpenSession(this.maBase, "Parc");
         var8 = true;
      }

      new ArrayList();
      Criteria var10 = var7.createCriteria(Parc.class);
      if (var1 != null && !var1.isEmpty()) {
         String var11 = "%" + var1 + "%";
         var10 = var10.add(Restrictions.like("prcImmatriculation", var11));
      }

      String[] var13;
      if (var2 != null && !var2.isEmpty() && var2.contains(":")) {
         var13 = var2.split(":");
         int var12 = Integer.parseInt(var13[0]);
         var10 = var10.add(Restrictions.like("prcNature", var12));
      }

      if (var3 != null && !var3.isEmpty() && var3.contains(":")) {
         var13 = var3.split(":");
         var10 = var10.add(Restrictions.like("prcFamille", var13[0]));
      }

      int var14;
      if (var4 != null && !var4.isEmpty() && !var4.equals("100")) {
         var14 = Integer.parseInt(var4);
         var10 = var10.add(Restrictions.like("prcOrigine", var14));
      }

      if (var5 != null && !var5.isEmpty() && !var5.equals("100")) {
         var14 = Integer.parseInt(var5);
         var10 = var10.add(Restrictions.like("prcFonction", var14));
      }

      if (var6 != null && !var6.isEmpty() && var6.contains(":")) {
         var13 = var6.split(":");
         var10 = var10.add(Restrictions.like("prcService", var13[0]));
      }

      var10 = var10.addOrder(Order.asc("prcImmatriculation"));
      List var9 = var10.list();
      if (var8) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public Parc rechercheParc(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Parc");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Parc where prcImmatriculation=:cod").setString("cod", var1);
      var4.setMaxResults(1);
      List var5 = var4.list();
      new Parc();
      Parc var6;
      if (var5.size() > 0) {
         var6 = (Parc)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public boolean existCode(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Parc");
         var3 = true;
      }

      boolean var4 = false;
      Query var5 = var2.createQuery("from Parc where prcImmatriculation=:cod").setString("cod", var1);
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

   public List selectAchatsAnniv(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var2 = true;
      }

      Date var3 = new Date();
      DateFormat var4 = DateFormat.getDateInstance(3);
      String var5 = var4.format(var3).substring(0, 5);
      List var6 = var1.createQuery("from Parc where prcAnniversaire=:dt ").setParameter("dt", var5).list();
      new ArrayList();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List selectParc(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Parc");
         var3 = true;
      }

      Query var4 = null;
      List var5 = null;
      if (var1 != null) {
         if (var1.equals("*")) {
            var4 = var2.createQuery("from Parc where prcEtat=0");
         } else if (var1.length() >= 2 && var1.contains("*")) {
            String var6 = var1.substring(1);
            var4 = var2.createQuery("from Parc where (prcImmatriculation LIKE '%" + var6 + "%' or prcNomFr LIKE '%" + var6 + "%') and prcEtat=0");
         } else {
            var4 = var2.createQuery("from Parc where (prcImmatriculation LIKE'" + var1 + "%' or prcNomFr LIKE'" + var1 + "%') and prcEtat=0");
         }

         var5 = var4.list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesParcsUsine(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Parc");
         var2 = true;
      }

      List var3 = var1.createQuery("from Parc where prcInactif=0 and ((prcNature>=1760 and prcNature<=1769) or (prcNature>=1770 and prcNature<=1779))").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerLesParcsLaboratoire(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Parc");
         var2 = true;
      }

      List var3 = var1.createQuery("from Parc where prcInactif=0 and (prcNature>=1790 and prcNature<=1799)").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerLesMarques(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Parc");
         var2 = true;
      }

      List var3 = var1.createQuery("from Parc where prcInactif=0 group by prcMarque order by prcMarque").list();
      List var4 = var3;
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            if (((Parc)var4.get(var6)).getPrcMarque() != null && !((Parc)var4.get(var6)).getPrcMarque().isEmpty()) {
               var5.add(new SelectItem(((Parc)var4.get(var6)).getPrcMarque()));
            }
         }
      }

      return var5;
   }
}
