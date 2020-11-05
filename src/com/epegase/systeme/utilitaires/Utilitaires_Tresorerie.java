package com.epegase.systeme.utilitaires;

import com.epegase.systeme.classe.BonDecaissementAchat;
import com.epegase.systeme.classe.BonEncaissementVente;
import com.epegase.systeme.classe.BonEntreCaiss;
import com.epegase.systeme.classe.BonSortieCaiss;
import com.epegase.systeme.classe.Reglements;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.VirementInterne;
import com.epegase.systeme.dao.BonDecaissementAchatDao;
import com.epegase.systeme.dao.BonEncaissementVenteDao;
import com.epegase.systeme.dao.BonEntreCaissDao;
import com.epegase.systeme.dao.BonSortieCaissDao;
import com.epegase.systeme.dao.ReglementsDao;
import com.epegase.systeme.dao.VirementInterneDao;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class Utilitaires_Tresorerie implements Serializable {
   public void suppressionBDecaissement(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new BonDecaissementAchat();
      BonDecaissementAchatDao var9 = new BonDecaissementAchatDao(var5, var6);
      new ArrayList();
      List var10 = var9.selectBon(var1, var2, var7);
      if (var10.size() != 0) {
         for(int var11 = 0; var11 < var10.size(); ++var11) {
            BonDecaissementAchat var8 = (BonDecaissementAchat)var10.get(var11);
            var9.delete(var8, var7);
         }
      }

   }

   public void suppressionBEncaissement(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new BonEncaissementVente();
      BonEncaissementVenteDao var9 = new BonEncaissementVenteDao(var5, var6);
      new ArrayList();
      List var10 = var9.selectBon(var1, var2, var7);
      if (var10.size() != 0) {
         for(int var11 = 0; var11 < var10.size(); ++var11) {
            BonEncaissementVente var8 = (BonEncaissementVente)var10.get(var11);
            var9.delete(var8, var7);
         }
      }

   }

   public void suppressionRecu(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new Reglements();
      ReglementsDao var9 = new ReglementsDao(var5, var6);
      new ArrayList();
      UtilDate var11 = new UtilDate();
      String var12 = var11.dateToStringSQLLight(var1);
      String var13 = var11.dateToStringSQLLight(var2);
      List var10 = var9.rechercheRecus(var12, var13, var7);
      if (var10.size() != 0) {
         for(int var14 = 0; var14 < var10.size(); ++var14) {
            Reglements var8 = (Reglements)var10.get(var14);
            var9.delete(var8, var7);
         }
      }

   }

   public void suppressionRecuDeposits(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new Reglements();
      ReglementsDao var9 = new ReglementsDao(var5, var6);
      new ArrayList();
      UtilDate var11 = new UtilDate();
      String var12 = var11.dateToStringSQLLight(var1);
      String var13 = var11.dateToStringSQLLight(var2);
      List var10 = var9.rechercheRecusDeposits(var12, var13, var7);
      if (var10.size() != 0) {
         for(int var14 = 0; var14 < var10.size(); ++var14) {
            Reglements var8 = (Reglements)var10.get(var14);
            var9.delete(var8, var7);
         }
      }

   }

   public void suppressionRecuRistournes(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new Reglements();
      ReglementsDao var9 = new ReglementsDao(var5, var6);
      new ArrayList();
      UtilDate var11 = new UtilDate();
      String var12 = var11.dateToStringSQLLight(var1);
      String var13 = var11.dateToStringSQLLight(var2);
      List var10 = var9.rechercheRecusRistournes(var12, var13, var7);
      if (var10.size() != 0) {
         for(int var14 = 0; var14 < var10.size(); ++var14) {
            Reglements var8 = (Reglements)var10.get(var14);
            var9.delete(var8, var7);
         }
      }

   }

   public void suppressionBEntree(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new BonEntreCaiss();
      BonEntreCaissDao var9 = new BonEntreCaissDao(var5, var6);
      new ArrayList();
      List var10 = var9.rechercheBon(var1, var2, var7);
      if (var10.size() != 0) {
         for(int var11 = 0; var11 < var10.size(); ++var11) {
            BonEntreCaiss var8 = (BonEntreCaiss)var10.get(var11);
            var9.delete(var8, var7);
         }
      }

   }

   public void suppressionBSortie(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new BonSortieCaiss();
      BonSortieCaissDao var9 = new BonSortieCaissDao(var5, var6);
      new ArrayList();
      List var10 = var9.rechercheBon(var1, var2, var7);
      if (var10.size() != 0) {
         for(int var11 = 0; var11 < var10.size(); ++var11) {
            BonSortieCaiss var8 = (BonSortieCaiss)var10.get(var11);
            var9.delete(var8, var7);
         }
      }

   }

   public void suppressionVirement(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new VirementInterne();
      VirementInterneDao var9 = new VirementInterneDao(var5, var6);
      new ArrayList();
      List var10 = var9.rechercheBon(var1, var2, var7);
      if (var10.size() != 0) {
         for(int var11 = 0; var11 < var10.size(); ++var11) {
            VirementInterne var8 = (VirementInterne)var10.get(var11);
            var9.delete(var8, var7);
         }
      }

   }

   public void suppressionTDomiciliee(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
   }

   public void suppressionTSimplifiee(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
   }

   public void suppressionTEntreprise(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
   }
}
