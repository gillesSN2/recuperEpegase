package com.epegase.systeme.dao;

import com.epegase.systeme.classe.LivraisonLigneVentes;
import com.epegase.systeme.classe.LivraisonLivreeVentes;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class LivraisonLivreeVentesDao implements Serializable {
   private LivraisonLivreeVentes livraisonLivreeVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public LivraisonLivreeVentesDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public LivraisonLivreeVentes insertLigne(LivraisonLivreeVentes var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public LivraisonLivreeVentes modifLigne(LivraisonLivreeVentes var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void deleteLigne(List var1, Session var2) {
      for(int var3 = 0; var3 < var1.size(); ++var3) {
         this.livraisonLivreeVentes = new LivraisonLivreeVentes();
         this.livraisonLivreeVentes = (LivraisonLivreeVentes)var1.get(var3);
         var2.delete(this.livraisonLivreeVentes);
      }

   }

   public float chargerLesLignesLivree(LivraisonLigneVentes var1, Session var2) {
      float var3 = 0.0F;
      List var4 = var2.createQuery("from LivraisonLivreeVentes where livraisonLigneVentes=:ligne").setParameter("ligne", var1).list();
      List var5 = var4;
      if (var4.size() != 0) {
         for(int var6 = 0; var6 < var5.size(); ++var6) {
            var3 += ((LivraisonLivreeVentes)var5.get(var6)).getBlvlivQteLivree();
         }
      }

      return var3;
   }

   public List chargerLesLivraisons(long var1, Session var3) {
      List var4 = var3.createQuery("from LivraisonLivreeVentes where blvlivIdBl=:idBl").setLong("idBl", var1).list();
      return var4;
   }

   public List chargerLesLivraisons(LivraisonLigneVentes var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BlivraisonEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from LivraisonLivreeVentes where livraisonLigneVentes=:blLig").setParameter("blLig", var1).list();
      new ArrayList();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesMvts(String var1, String var2, long var3, String var5, String var6, String var7, String var8, Session var9) {
      List var10 = null;
      String var11 = "";
      if (var5 != null && !var5.isEmpty()) {
         var11 = var11 + " livraisonLigneVentes.livraisonEnteteVentes.blvActivite='" + var5 + "' and ";
      }

      if (var6 != null && !var6.isEmpty()) {
         var11 = var11 + " livraisonLigneVentes.livraisonEnteteVentes.blvService='" + var6 + "' and ";
      }

      if (var2 != null && !var2.isEmpty()) {
         var11 = var11 + " blvlivDepot='" + var2 + "' and ";
      }

      if (var3 != 0L) {
         var11 = var11 + " livraisonLigneVentes.livraisonEnteteVentes.blvIdEquipe=" + var3 + " and ";
      }

      var10 = var9.createQuery("from LivraisonLivreeVentes where " + var11 + " blvlivCode='" + var1 + "' and blvlivDate>='" + var7 + "' and blvlivDate<='" + var8 + "'").list();
      return var10;
   }

   public List chargerLesMvts(String var1, Session var2) {
      List var3 = null;
      var3 = var2.createQuery("from LivraisonLivreeVentes where blvlivCode='" + var1 + "'").list();
      return var3;
   }

   public List rechercheLivreeRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BlivraisonEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from LivraisonLivreeVentes where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public LivraisonLivreeVentes rechercheLivree(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BlivraisonEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      this.livraisonLivreeVentes = new LivraisonLivreeVentes();
      var6 = var3.createQuery("from LivraisonLivreeVentes where blvlivId=" + var1).setMaxResults(1).list();
      if (var6.size() != 0) {
         this.livraisonLivreeVentes = (LivraisonLivreeVentes)var6.get(0);
      } else {
         this.livraisonLivreeVentes = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.livraisonLivreeVentes;
   }
}
