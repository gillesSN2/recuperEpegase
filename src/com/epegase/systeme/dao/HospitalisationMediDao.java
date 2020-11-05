package com.epegase.systeme.dao;

import com.epegase.systeme.classe.HospitalisationEntete;
import com.epegase.systeme.classe.HospitalisationMedi;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HospitalisationMediDao implements Serializable {
   private HospitalisationMedi hospitalisationMedi;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public HospitalisationMediDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public HospitalisationMedi insert(HospitalisationMedi var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "HospitalisationEntete");
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

   public HospitalisationMedi insert(HospitalisationMedi var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public HospitalisationMedi modif(HospitalisationMedi var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "HospitalisationEntete");
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

   public HospitalisationMedi modif(HospitalisationMedi var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(HospitalisationMedi var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "HospitalisationEntete");
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

   public void delete(HospitalisationMedi var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public void deleteAllLigne(HospitalisationEntete var1, Session var2) {
      var2.createQuery("delete from HospitalisationMedi where HospitalisationEntete=:id").setParameter("id", var1).executeUpdate();
   }

   public List selectMediByEnt(HospitalisationEntete var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "HospitalisationEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("From HospitalisationMedi where HospitalisationEntete=:param").setParameter("param", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List selectMediByEnt(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "HospitalisationEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("From HospitalisationMedi where HospitalisationEntete.hosId=:param").setLong("param", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectMediByHospitSejour(HospitalisationEntete var1, long var2, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "HospitalisationEntete");
         var5 = true;
      }

      List var6 = var4.createQuery("From HospitalisationMedi where HospitalisationEntete=:param and hosmedIdSejour=:id").setParameter("param", var1).setLong("id", var2).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public HospitalisationMedi selectMedi(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "HospitalisationEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("From HospitalisationMedi where hosmedId=:param").setLong("param", var1).setMaxResults(1).list();
      this.hospitalisationMedi = new HospitalisationMedi();
      if (var5.size() != 0) {
         this.hospitalisationMedi = (HospitalisationMedi)var5.get(0);
      } else {
         this.hospitalisationMedi = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.hospitalisationMedi;
   }

   public List chargerLesMvts(String var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, Session var9) {
      List var10 = null;
      String var11 = "";
      if (var1 != null && !var1.isEmpty()) {
         var11 = var11 + " HospitalisationEntete.hosSerie='" + var1 + "' and ";
      }

      if (var8 != null && !var8.isEmpty()) {
         var11 = var11 + " HospitalisationEntete.patients.patDossier='" + var8 + "' and ";
      }

      if (var4 != null && !var4.isEmpty()) {
         var11 = var11 + " HospitalisationEntete.hosActivite='" + var4 + "' and ";
      }

      if (var5 != null && !var5.isEmpty()) {
         var11 = var11 + " hosmedService='" + var5 + "' and ";
      }

      if (var3 != null && !var3.isEmpty()) {
         var11 = var11 + " hosmedDepot='" + var3 + "' and ";
      }

      if (var2 != null && !var2.isEmpty()) {
         if (var2.startsWith("(")) {
            var10 = var9.createQuery("select HospitalisationEntete.hosEtat,HospitalisationEntete.hosNum,HospitalisationEntete.hosNomPatient,HospitalisationEntete.hosDateEntree,hosmedId,hosmedDepot,hosmedProduit,hosmedFamille,hosmedLibelle,hosmedQte,hosmedStock,hosmedPu,hosmedTotal,hosmedPump from HospitalisationMedi where " + var11 + " hosmedProduit in " + var2 + " and HospitalisationEntete.hosDateEntree>='" + var6 + "' and HospitalisationEntete.hosDateEntree<='" + var7 + "'").list();
         } else {
            var10 = var9.createQuery("select HospitalisationEntete.hosEtat,HospitalisationEntete.hosNum,HospitalisationEntete.hosNomPatient,HospitalisationEntete.hosDateEntree,hosmedId,hosmedDepot,hosmedProduit,hosmedFamille,hosmedLibelle,hosmedQte,hosmedStock,hosmedPu,hosmedTotal,hosmedPump from HospitalisationMedi where " + var11 + " hosmedProduit='" + var2 + "' and HospitalisationEntete.hosDateEntree>='" + var6 + "' and HospitalisationEntete.hosDateEntree<='" + var7 + "'").list();
         }
      } else {
         var10 = var9.createQuery("select HospitalisationEntete.hosEtat,HospitalisationEntete.hosNum,HospitalisationEntete.hosNomPatient,HospitalisationEntete.hosDateEntree,hosmedId,hosmedDepot,hosmedProduit,hosmedFamille,hosmedLibelle,hosmedQte,hosmedStock,hosmedPu,hosmedTotal,hosmedPump from HospitalisationMedi where " + var11 + " HospitalisationEntete.hosDateEntree>='" + var6 + "' and HospitalisationEntete.hosDateEntree<='" + var7 + "'").list();
      }

      return var10;
   }

   public List chargerLesLignesProduits(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "HospitalisationEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from HospitalisationMedi where HospitalisationEntete.hosNum in (" + var1 + ") order by hosmedLibelle").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerMediByRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "HospitalisationEntete");
         var3 = true;
      }

      List var4 = null;
      var4 = var2.createQuery("from HospitalisationMedi where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }
}
