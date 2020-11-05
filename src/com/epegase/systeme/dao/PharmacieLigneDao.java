package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ConsultationEnteteGene;
import com.epegase.systeme.classe.Patients;
import com.epegase.systeme.classe.PharmacieEntete;
import com.epegase.systeme.classe.PharmacieLigne;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PharmacieLigneDao implements Serializable {
   private PharmacieLigne pharmacieLigne;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public PharmacieLigneDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public PharmacieLigne insert(PharmacieLigne var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PharmacieEntete");
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

   public PharmacieLigne insert(PharmacieLigne var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public PharmacieLigne modif(PharmacieLigne var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PharmacieEntete");
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

   public PharmacieLigne modif(PharmacieLigne var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(PharmacieLigne var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PharmacieEntete");
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

   public void delete(PharmacieLigne var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public void deleteAllLigne(PharmacieEntete var1, Session var2) {
      var2.createQuery("delete from PharmacieLigne where pharmacieEntete=:id").setParameter("id", var1).executeUpdate();
   }

   public List selectConsActesByConsEnt(PharmacieEntete var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PharmacieEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("From PharmacieLigne where pharmacieEntete=:param").setParameter("param", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List selectConsActesByConsEnt(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "PharmacieEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("From PharmacieLigne where pharmacieEntete.phaId=:param").setLong("param", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectConsActesByConsEnt(ConsultationEnteteGene var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PharmacieEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("From PharmacieLigne where consultationEnteteGene=:param").setParameter("param", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public PharmacieLigne selectConsActes(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "PharmacieEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("From PharmacieLigne where phaligId=:param").setLong("param", var1).setMaxResults(1).list();
      this.pharmacieLigne = new PharmacieLigne();
      if (var5.size() != 0) {
         this.pharmacieLigne = (PharmacieLigne)var5.get(0);
      } else {
         this.pharmacieLigne = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.pharmacieLigne;
   }

   public List selectConsActesByConsEnt(PharmacieEntete var1, int var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "PharmacieEntete");
         var4 = true;
      }

      new ArrayList();
      List var5;
      if (var2 == 100) {
         var5 = var3.createQuery("From PharmacieLigne where pharmacieEntete=:param").setParameter("param", var1).list();
      } else if (var2 == 11) {
         var5 = var3.createQuery("From PharmacieLigne where pharmacieEntete=:param and (phaligEtat=0 or phaligEtat=1)").setParameter("param", var1).list();
      } else {
         var5 = var3.createQuery("From PharmacieLigne where pharmacieEntete=:param and phaligEtat=:et").setParameter("param", var1).setInteger("et", var2).list();
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesMvts(String var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, Session var9) {
      List var10 = null;
      String var11 = "";
      if (var1 != null && !var1.isEmpty()) {
         var11 = var11 + " pharmacieEntete.phaSerie='" + var1 + "' and ";
      }

      if (var8 != null && !var8.isEmpty()) {
         var11 = var11 + " pharmacieEntete.patients.patDossier='" + var8 + "' and ";
      }

      if (var4 != null && !var4.isEmpty()) {
         var11 = var11 + " pharmacieEntete.phaActivite='" + var4 + "' and ";
      }

      if (var5 != null && !var5.isEmpty()) {
         var11 = var11 + " pharmacieEntete.phaService='" + var5 + "' and ";
      }

      if (var3 != null && !var3.isEmpty()) {
         var11 = var11 + " phaligDepot='" + var3 + "' and ";
      }

      if (var2 != null && !var2.isEmpty()) {
         if (var2.startsWith("(")) {
            var10 = var9.createQuery("select pharmacieEntete.phaEtat,pharmacieEntete.phaNum,pharmacieEntete.phaNomPatient,pharmacieEntete.phaDate,phaligId,phaligDepot,phaligProduit,phaligFamille,phaligLibelle,phaligQte,phaligStock,phaligPu,phaligTotal,phaligPump from PharmacieLigne where " + var11 + " phaligProduit in " + var2 + " and pharmacieEntete.phaDate>='" + var6 + "' and pharmacieEntete.phaDate<='" + var7 + "'").list();
         } else {
            var10 = var9.createQuery("select pharmacieEntete.phaEtat,pharmacieEntete.phaNum,pharmacieEntete.phaNomPatient,pharmacieEntete.phaDate,phaligId,phaligDepot,phaligProduit,phaligFamille,phaligLibelle,phaligQte,phaligStock,phaligPu,phaligTotal,phaligPump from PharmacieLigne where " + var11 + " phaligProduit='" + var2 + "' and pharmacieEntete.phaDate>='" + var6 + "' and pharmacieEntete.phaDate<='" + var7 + "'").list();
         }
      } else {
         var10 = var9.createQuery("select pharmacieEntete.phaEtat,pharmacieEntete.phaNum,pharmacieEntete.phaNomPatient,pharmacieEntete.phaDate,phaligId,phaligDepot,phaligProduit,phaligFamille,phaligLibelle,phaligQte,phaligStock,phaligPu,phaligTotal,phaligPump from PharmacieLigne where " + var11 + " pharmacieEntete.phaDate>='" + var6 + "' and pharmacieEntete.phaDate<='" + var7 + "'").list();
      }

      return var10;
   }

   public List chargerLesMvts(String var1, Session var2) {
      List var3 = null;
      var3 = var2.createQuery("from PharmacieLigne where phaligProduit='" + var1 + "'").list();
      return var3;
   }

   public List chargerLesMvtsPatients(Patients var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "PharmacieEntete");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from PharmacieLigne where pharmacieEntete.Patients.patId=" + var1.getPatId() + " and pharmacieEntete.phaDate between '" + var2 + "' and '" + var3 + "'").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesLignesProduits(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PharmacieEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from PharmacieLigne where consultationEnteteGene.csgNum in (" + var1 + ") order by phaligProduit").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignesActes(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PharmacieEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from PharmacieLigne where pharmacieEntete.phaNum in (" + var1 + ") order by phaligLibelle").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesMvtsDate(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
         var4 = true;
      }

      List var5 = null;
      var5 = var3.createQuery("from PharmacieLigne where consultationEnteteGene.csgDate between '" + var1 + "' and '" + var2 + "'").list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesMvtsInfirmerieDate(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from PharmacieLigne where consultationEnteteGene.csgDate between '" + var2 + "' and '" + var3 + "' and consultationEnteteGene.csgService='" + var1 + "'").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerPharmacieByRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PharmacieEntete");
         var3 = true;
      }

      List var4 = null;
      var4 = var2.createQuery("from PharmacieLigne where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }
}
