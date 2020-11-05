package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.TraiteEntete;
import com.epegase.systeme.classe.TraiteLigne;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class TraiteLigneDao implements Serializable {
   private TraiteLigne traiteLigne;
   private ExercicesVentes exercicesVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public TraiteLigneDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public TraiteLigne insert(TraiteLigne var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public TraiteLigne modif(TraiteLigne var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(TraiteLigne var1, Session var2) {
      var2.delete(var1);
   }

   public List chargerLigneTraite(TraiteEntete var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Traites");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from TraiteLigne where traiteEntete=:trt").setParameter("trt", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLigneDepot(int var1, Date var2, Session var3) throws HibernateException, NamingException, ParseException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Traites");
         var4 = true;
      }

      UtilDate var5 = new UtilDate();
      Date var6 = var5.datePremierJourMois(var2);
      Date var7 = var5.dateDernierJourMois(var2);
      new ArrayList();
      Query var9 = var3.createQuery("from TraiteLigne where traiteEntete.trtNature=:nat and traiteEntete.trtEtat=1 and ((trtligDateTheorique>=:dteDeb and trtligDateTheorique<=:dteFin) or (trtligDateReport>=:dteDeb and trtligDateReport<=:dteFin))").setInteger("nat", var1).setDate("dteDeb", var6).setDate("dteFin", var7);
      List var8 = var9.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }
}
