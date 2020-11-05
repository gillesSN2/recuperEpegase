package com.epegase.systeme.dao;

import com.epegase.systeme.classe.DouanesPosition;
import com.epegase.systeme.classe.PegDouanesPosition;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DouanesPositionDao implements Serializable {
   private DouanesPosition douanesPosition;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public DouanesPositionDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public DouanesPosition insert(DouanesPosition var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "DouanesPosition");
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

   public DouanesPosition insert(DouanesPosition var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public DouanesPosition modif(DouanesPosition var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "DouanesPosition");
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

   public DouanesPosition modif(DouanesPosition var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(DouanesPosition var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "DouanesPosition");
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

   public void delete(DouanesPosition var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public void ajoutParDefaut(String var1) throws HibernateException, NamingException {
      new ArrayList();
      PegDouanesPositionDao var3 = new PegDouanesPositionDao(this.utilInitHibernate);
      List var2 = var3.rechecheGlobale();
      if (var2.size() != 0) {
         Session var4 = this.utilInitHibernate.getOpenSession(this.maBase, "DouanesPosition");
         Transaction var5 = null;

         try {
            var5 = var4.beginTransaction();
            DouanesPositionDao var6 = new DouanesPositionDao(this.maBase, this.utilInitHibernate);
            new PegDouanesPosition();

            for(int var8 = 0; var8 < var2.size(); ++var8) {
               PegDouanesPosition var7 = (PegDouanesPosition)var2.get(var8);
               this.douanesPosition = new DouanesPosition();
               this.douanesPosition.setDoupos46(0.0F);
               this.douanesPosition.setDoupos53(0.0F);
               this.douanesPosition.setDouposAd(var7.getDouposAd());
               if (var7.getPegDouanesChapitre().getDouchaCode().length() == 1) {
                  this.douanesPosition.setDouposCodeChapitre("0" + var7.getPegDouanesChapitre().getDouchaCode());
               } else {
                  this.douanesPosition.setDouposCodeChapitre(var7.getPegDouanesChapitre().getDouchaCode());
               }

               this.douanesPosition.setDouposChapitre(var7.getPegDouanesChapitre().getDouchaLibFR());
               this.douanesPosition.setDouposCode(var7.getDouposCode());
               if (this.douanesPosition.getDouposCode().length() == 4) {
                  this.douanesPosition.setChapitre(true);
               } else {
                  this.douanesPosition.setChapitre(false);
               }

               this.douanesPosition.setDouposCumul(var7.getDouposCumul());
               this.douanesPosition.setDouposDa(var7.getDouposDa());
               this.douanesPosition.setDouposDd(var7.getDouposDd());
               this.douanesPosition.setDouposLibFR(var7.getDouposLibFR());
               this.douanesPosition.setDouposLibSP(var7.getDouposLibSP());
               this.douanesPosition.setDouposLibUK(var7.getDouposLibUK());
               this.douanesPosition.setDouposPcs(0.0F);
               this.douanesPosition.setDouposRs(var7.getDouposRs());
               this.douanesPosition.setDouposCodeSection(var7.getPegDouanesChapitre().getPegDouanesSection().getDousecCode());
               this.douanesPosition.setDouposSection(var7.getPegDouanesChapitre().getPegDouanesSection().getDousecLibFR());
               this.douanesPosition.setDouposTva(var7.getDouposTva());
               this.douanesPosition.setDouposUnite(var7.getDouposUnite());
               this.douanesPosition.setDouposUtil(0);
               this.douanesPosition.setDouposZone(var1);
               this.douanesPosition = var6.insert(this.douanesPosition, var4);
            }

            var5.commit();
         } catch (HibernateException var12) {
            if (var5 != null) {
               var5.rollback();
            }

            throw var12;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public List listeChapitre(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "DouanesPosition");
         var3 = true;
      }

      List var4 = var2.createQuery("from DouanesPosition where douposZone=:zon group by douposCodeChapitre order by douposCodeChapitre asc").setString("zon", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesPositions(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "DouanesPosition");
         var4 = true;
      }

      List var5 = var3.createQuery("from DouanesPosition where douposZone=:zon and douposCodeChapitre= '" + var2 + "' order by douposCode asc").setString("zon", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List recherchePosition(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "DouanesPosition");
         var4 = true;
      }

      List var5 = null;
      if (var2.equals("*")) {
         var5 = var3.createQuery("from DouanesPosition where douposZone=:zon and douposUtil=1 order by douposCode asc").setString("zon", var1).list();
      } else {
         var5 = var3.createQuery("from DouanesPosition where douposZone=:zon and (douposCode like '" + var2 + "%' or douposLibFR like '%" + var2 + "%'  or douposChapitre like '" + var2 + "%') and douposUtil=1 order by douposCode asc").setString("zon", var1).list();
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheChaine(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "DouanesPosition");
         var4 = true;
      }

      List var5 = var3.createQuery("from DouanesPosition where (douposLibFR like '%" + var2 + "%' or douposCode like '" + var2 + "%') order by douposCode asc").list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List listePositionsItems(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "DouanesPosition");
         var3 = true;
      }

      List var4 = var2.createQuery("from DouanesPosition where douposZone=:zon and douposUtil=1 order by douposCode asc").setString("zon", var1).list();
      ArrayList var5 = new ArrayList();
      if (var4 != null) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            this.douanesPosition = new DouanesPosition();
            this.douanesPosition = (DouanesPosition)var4.get(var6);
            var5.add(new SelectItem(this.douanesPosition.getDouposCode(), this.douanesPosition.getDouposCode() + ":" + this.douanesPosition.getDouposLibFR()));
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public DouanesPosition trouverPosition(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "DouanesPosition");
         var4 = true;
      }

      List var5 = var3.createQuery("from DouanesPosition where douposZone=:zon and douposCode= '" + var2 + "' and douposUtil=1").setString("zon", var1).setMaxResults(1).list();
      this.douanesPosition = new DouanesPosition();
      if (var5.size() != 0) {
         this.douanesPosition = (DouanesPosition)var5.get(0);
      } else {
         this.douanesPosition = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.douanesPosition;
   }

   public DouanesPosition trouverChapitre(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "DouanesPosition");
         var4 = true;
      }

      List var5 = var3.createQuery("from DouanesPosition where douposZone=:zon and douposCode= '" + var2 + "' and douposUtil=0").setString("zon", var1).setMaxResults(1).list();
      this.douanesPosition = new DouanesPosition();
      if (var5.size() != 0) {
         this.douanesPosition = (DouanesPosition)var5.get(0);
      } else {
         this.douanesPosition = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.douanesPosition;
   }
}
