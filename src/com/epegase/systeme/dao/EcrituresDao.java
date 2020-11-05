package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Brouillard;
import com.epegase.systeme.classe.Ecritures;
import com.epegase.systeme.classe.EcrituresDestroy;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.PlanComptable;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.EcrituresBalance;
import com.epegase.systeme.control.EcrituresLight;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class EcrituresDao implements Serializable {
   private Users usersLog;
   private Ecritures ecritures;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public EcrituresDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public Ecritures insert(Ecritures var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
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

   public Ecritures insert(Ecritures var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public void inser(List var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();

         for(int var4 = 0; var4 < var1.size(); ++var4) {
            Ecritures var5 = (Ecritures)var1.get(var4);
            var2.save(var5);
         }

         var3.commit();
      } catch (HibernateException var9) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var9;
      } finally {
         this.utilInitHibernate.closeSession();
      }
   }

   public Ecritures modif(Ecritures var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
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

   public Ecritures modif(Ecritures var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void modif(List var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();

         for(int var4 = 0; var4 < var1.size(); ++var4) {
            Ecritures var5 = (Ecritures)var1.get(var4);
            var2.update(var5);
         }

         var3.commit();
      } catch (HibernateException var9) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var9;
      } finally {
         this.utilInitHibernate.closeSession();
      }
   }

   public void removeSelectedEC0(Ecritures var1, int var2, Session var3) {
      var3.delete(var1);
      if (var2 != 0) {
         var3.flush();
      }

   }

   public void removeSelectedEC1(List var1, String var2, int var3, Session var4) {
      if (var1.size() != 0) {
         int var5 = 0;
         new Ecritures();

         for(int var7 = 0; var7 < var1.size(); ++var7) {
            Ecritures var6 = (Ecritures)var1.get(var7);
            if (var6.getEcrPiece().equals(var2)) {
               var4.delete(var6);
               ++var5;
               if (var3 != 0 && var5 == var3) {
                  var4.flush();
                  var5 = 0;
               }
            }
         }
      }

   }

   public void removeSelectedEC2(List var1, int var2, Session var3) {
      if (var1.size() != 0) {
         int var4 = 0;
         new Ecritures();

         for(int var6 = 0; var6 < var1.size(); ++var6) {
            Ecritures var5 = (Ecritures)var1.get(var6);
            var3.delete(var5);
            ++var4;
            if (var2 != 0 && var4 == var2) {
               var3.flush();
               var4 = 0;
            }
         }
      }

   }

   public void inserEcrituresDestroyEC0(Ecritures var1, Users var2, int var3, Session var4) {
      this.convertEcrDestroy(var1, var2, var3, var4);
   }

   public void inserEcrituresDestroyEC1(List var1, String var2, Users var3, int var4, Session var5) {
      if (var1.size() != 0) {
         new Ecritures();

         for(int var7 = 0; var7 < var1.size(); ++var7) {
            Ecritures var6 = (Ecritures)var1.get(var7);
            if (var6.getEcrPiece().equals(var2)) {
               this.convertEcrDestroy(var6, var3, var4, var5);
            }
         }
      }

   }

   public void inserEcrituresDestroyEC2(List var1, Users var2, int var3, Session var4) {
      if (var1.size() != 0) {
         new Ecritures();

         for(int var6 = 0; var6 < var1.size(); ++var6) {
            Ecritures var5 = (Ecritures)var1.get(var6);
            this.convertEcrDestroy(var5, var2, var3, var4);
         }
      }

   }

   public void convertEcrDestroy(Ecritures var1, Users var2, int var3, Session var4) {
      EcrituresDestroy var5 = new EcrituresDestroy();
      var5.setEcrDateDelete(new Date());
      var5.setEcrUserDelete(var2.getUsrid());
      var5.setEcrIdGene(var1.getEcr_id());
      var5.setEcrIdOrigine(var1.getEcrIdOrigine());
      var5.setEcrTypeOrigine(var1.getEcrTypeOrigine());
      var5.setEcrCle1(var1.getEcrCle1());
      var5.setEcrCle2(var1.getEcrCle2());
      var5.setEcrDateCreat(var1.getEcrDateCreat());
      var5.setEcrDateModif(var1.getEcrDateModif());
      var5.setEcrUserCreat(var1.getEcrUserCreat());
      var5.setEcrUserModif(var1.getEcrUserModif());
      var5.setEcrCode(var1.getEcrCode());
      var5.setEcrDateSaisie(var1.getEcrDateSaisie());
      var5.setEcrPeriode(var1.getEcrPeriode());
      var5.setEcrJour(var1.getEcrJour());
      var5.setEcrAnnee(var1.getEcrAnnee());
      var5.setEcrCompte(var1.getEcrCompte());
      var5.setEcrLibCompte(var1.getEcrLibCompte());
      var5.setEcrNature(var1.getEcrNature());
      var5.setEcrClasse(var1.getEcrClasse());
      var5.setEcrContrePartie(var1.getEcrContrePartie());
      var5.setEcrDeviseSaisie(var1.getEcrDeviseSaisie());
      var5.setEcrDebitSaisie(var1.getEcrDebitSaisie());
      var5.setEcrCreditSaisie(var1.getEcrCreditSaisie());
      var5.setEcrCoefEuro(var1.getEcrCoefEuro());
      var5.setEcrDebitEuro(var1.getEcrDebitEuro());
      var5.setEcrCreditEuro(var1.getEcrCreditEuro());
      var5.setEcrDevisePays(var1.getEcrDevisePays());
      var5.setEcrCoefPays(var1.getEcrCoefPays());
      var5.setEcrDebitPays(var1.getEcrDebitPays());
      var5.setEcrCreditPays(var1.getEcrCreditPays());
      var5.setEcrDeviseGrp(var1.getEcrDeviseGrp());
      var5.setEcrCoefGrp(var1.getEcrCoefGrp());
      var5.setEcrDebitGrp(var1.getEcrDebitGrp());
      var5.setEcrCreditGrp(var1.getEcrCreditGrp());
      var5.setEcrLettrage(var1.getEcrLettrage());
      var5.setEcrPointage(var1.getEcrPointage());
      var5.setEcrRapprochement(var1.getEcrRapprochement());
      var5.setEcrCloture(var1.getEcrCloture());
      var5.setEcrDateEcheance(var1.getEcrDateEcheance());
      var5.setEcrOrigineBanque(var1.getEcrOrigineBanque());
      var5.setEcrDateValeurTheo(var1.getEcrDateValeurTheo());
      var5.setEcrDateValeurReelle(var1.getEcrDateValeurReelle());
      var5.setEcrLibelle(var1.getEcrLibelle());
      var5.setEcrPiece(var1.getEcrPiece());
      var5.setEcrReference1(var1.getEcrReference1());
      var5.setEcrReference2(var1.getEcrReference2());
      var5.setEcrTreso(var1.getEcrTreso());
      var5.setEcrDatePaiement(var1.getEcrDatePaiement());
      var5.setEcrNumIf(var1.getEcrNumIf());
      var5.setEcrOrdre(var1.getEcrOrdre());
      var5.setEcrNatureJrx(var1.getEcrNatureJrx());
      var5.setEcrReserve(var1.getEcrReserve());
      var5.setEcrAnaActif(var1.getEcrAnaActif());
      var5.setEcrEtat(var1.getEcrEtat());
      var5.setEcrBudgetTreso(var1.getEcrBudgetTreso());
      var5.setEcrPosteTreso(var1.getEcrPosteTreso());
      var5.setEcrDossier(var1.getEcrDossier());
      var5.setEcrAnaAxe01(var1.isEcrAnaAxe01());
      var5.setEcrAnaAxe02(var1.isEcrAnaAxe02());
      var5.setEcrAnaAxe03(var1.isEcrAnaAxe03());
      var5.setEcrAnaAxe03(var1.isEcrAnaAxe04());
      var5.setEcrAnaAxe04(var1.isEcrAnaAxe05());
      var5.setEcrAnaAxe05(var1.isEcrAnaAxe06());
      var5.setEcrAnaAxe06(var1.isEcrAnaAxe07());
      var5.setEcrAnaAxe07(var1.isEcrAnaAxe08());
      var5.setEcrAnaAxe08(var1.isEcrAnaAxe09());
      var5.setEcrAnaAxe09(var1.isEcrAnaAxe11());
      var5.setEcrAnaAxe11(var1.isEcrAnaAxe12());
      var5.setEcrAnaAxe12(var1.isEcrAnaAxe13());
      var5.setEcrAnaAxe13(var1.isEcrAnaAxe13());
      var4.save(var5);
   }

   public Ecritures inserRestaureDestroy(EcrituresDestroy var1, ExercicesComptable var2, Session var3) {
      this.ecritures = new Ecritures();
      this.ecritures.setExercicesComptable(var2);
      this.ecritures.setEcr_id(var1.getEcrIdGene());
      this.ecritures.setEcrIdOrigine(var1.getEcrIdOrigine());
      this.ecritures.setEcrTypeOrigine(var1.getEcrTypeOrigine());
      this.ecritures.setEcrCle1(var1.getEcrCle1());
      this.ecritures.setEcrCle2(var1.getEcrCle2());
      this.ecritures.setEcrDateCreat(var1.getEcrDateCreat());
      this.ecritures.setEcrDateModif(var1.getEcrDateModif());
      this.ecritures.setEcrUserCreat(var1.getEcrUserCreat());
      this.ecritures.setEcrUserModif(var1.getEcrUserModif());
      this.ecritures.setEcrCode(var1.getEcrCode());
      this.ecritures.setEcrDateSaisie(var1.getEcrDateSaisie());
      this.ecritures.setEcrPeriode(var1.getEcrPeriode());
      this.ecritures.setEcrJour(var1.getEcrJour());
      this.ecritures.setEcrAnnee(var1.getEcrAnnee());
      this.ecritures.setEcrCompte(var1.getEcrCompte());
      this.ecritures.setEcrLibCompte(var1.getEcrLibCompte());
      this.ecritures.setEcrNature(var1.getEcrNature());
      this.ecritures.setEcrClasse(var1.getEcrClasse());
      this.ecritures.setEcrContrePartie(var1.getEcrContrePartie());
      this.ecritures.setEcrDeviseSaisie(var1.getEcrDeviseSaisie());
      this.ecritures.setEcrDebitSaisie(var1.getEcrDebitSaisie());
      this.ecritures.setEcrCreditSaisie(var1.getEcrCreditSaisie());
      this.ecritures.setEcrCoefEuro(var1.getEcrCoefEuro());
      this.ecritures.setEcrDebitEuro(var1.getEcrDebitEuro());
      this.ecritures.setEcrCreditEuro(var1.getEcrCreditEuro());
      this.ecritures.setEcrDevisePays(var1.getEcrDevisePays());
      this.ecritures.setEcrCoefPays(var1.getEcrCoefPays());
      this.ecritures.setEcrDebitPays(var1.getEcrDebitPays());
      this.ecritures.setEcrCreditPays(var1.getEcrCreditPays());
      this.ecritures.setEcrDeviseGrp(var1.getEcrDeviseGrp());
      this.ecritures.setEcrCoefGrp(var1.getEcrCoefGrp());
      this.ecritures.setEcrDebitGrp(var1.getEcrDebitGrp());
      this.ecritures.setEcrCreditGrp(var1.getEcrCreditGrp());
      this.ecritures.setEcrLettrage(var1.getEcrLettrage());
      this.ecritures.setEcrPointage(var1.getEcrPointage());
      this.ecritures.setEcrRapprochement(var1.getEcrRapprochement());
      this.ecritures.setEcrCloture(var1.getEcrCloture());
      this.ecritures.setEcrDateEcheance(var1.getEcrDateEcheance());
      this.ecritures.setEcrOrigineBanque(var1.getEcrOrigineBanque());
      this.ecritures.setEcrDateValeurTheo(var1.getEcrDateValeurTheo());
      this.ecritures.setEcrDateValeurReelle(var1.getEcrDateValeurReelle());
      this.ecritures.setEcrLibelle(var1.getEcrLibelle());
      this.ecritures.setEcrPiece(var1.getEcrPiece());
      this.ecritures.setEcrReference1(var1.getEcrReference1());
      this.ecritures.setEcrReference2(var1.getEcrReference2());
      this.ecritures.setEcrTreso(var1.getEcrTreso());
      this.ecritures.setEcrDatePaiement(var1.getEcrDatePaiement());
      this.ecritures.setEcrNumIf(var1.getEcrNumIf());
      this.ecritures.setEcrOrdre(var1.getEcrOrdre());
      this.ecritures.setEcrNatureJrx(var1.getEcrNatureJrx());
      this.ecritures.setEcrReserve(var1.getEcrReserve());
      this.ecritures.setEcrAnaActif(var1.getEcrAnaActif());
      this.ecritures.setEcrEtat(var1.getEcrEtat());
      this.ecritures.setEcrBudgetTreso(var1.getEcrBudgetTreso());
      this.ecritures.setEcrPosteTreso(var1.getEcrPosteTreso());
      this.ecritures.setEcrDossier(var1.getEcrDossier());
      this.ecritures.setEcrAnaAxe01(var1.isEcrAnaAxe01());
      this.ecritures.setEcrAnaAxe02(var1.isEcrAnaAxe02());
      this.ecritures.setEcrAnaAxe03(var1.isEcrAnaAxe03());
      this.ecritures.setEcrAnaAxe04(var1.isEcrAnaAxe04());
      this.ecritures.setEcrAnaAxe05(var1.isEcrAnaAxe05());
      this.ecritures.setEcrAnaAxe06(var1.isEcrAnaAxe06());
      this.ecritures.setEcrAnaAxe07(var1.isEcrAnaAxe07());
      this.ecritures.setEcrAnaAxe08(var1.isEcrAnaAxe08());
      this.ecritures.setEcrAnaAxe09(var1.isEcrAnaAxe09());
      this.ecritures.setEcrAnaAxe11(var1.isEcrAnaAxe11());
      this.ecritures.setEcrAnaAxe12(var1.isEcrAnaAxe12());
      this.ecritures.setEcrAnaAxe13(var1.isEcrAnaAxe13());
      var3.save(this.ecritures);
      return this.ecritures;
   }

   public void removeDestroy(EcrituresDestroy var1, Session var2) {
      var2.delete(var1);
   }

   public boolean verifMouvmentJr(String var1, long var2) throws HibernateException, NamingException {
      Session var5 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
      Query var6 = var5.createQuery("from Ecritures e where e.ecrCode='" + var1 + "' and e.exercicesComptable=:exo").setLong("exo", var2).setMaxResults(1);
      int var7 = var6.list().size();
      boolean var4;
      if (var7 > 0) {
         var4 = false;
      } else {
         var4 = true;
      }

      this.utilInitHibernate.closeSession();
      return var4;
   }

   public List ChargerLesEcritures(String var1, int var2, long var3, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var6 = true;
      }

      Query var7 = null;
      if (var3 != 0L) {
         if (var1.startsWith("AB:")) {
            var7 = var5.createQuery("from Ecritures  where ecrCle" + var2 + "=:cle").setString("cle", var1);
         } else {
            var7 = var5.createQuery("from Ecritures  where ecrCle" + var2 + "=:cle and  exercicesComptable=:exo").setString("cle", var1).setLong("exo", var3);
         }
      } else {
         var7 = var5.createQuery("from Ecritures  where ecrCle" + var2 + "=:cle").setString("cle", var1);
      }

      List var8 = null;
      if (var7.list() != null && var7.list().size() > 0) {
         var8 = var7.list();
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List ChargerLesEcrituresPiece(String var1, String var2, int var3, long var4, Session var6) throws HibernateException, NamingException {
      boolean var7 = false;
      if (var6 == null) {
         var6 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var7 = true;
      }

      Query var8 = null;
      if (var4 != 0L) {
         if (var1.startsWith("AB:")) {
            var8 = var6.createQuery("from Ecritures  where ecrCle" + var3 + "=:cle and ecrPiece=:pc").setString("cle", var1).setString("pc", var2);
         } else {
            var8 = var6.createQuery("from Ecritures  where ecrCle" + var3 + "=:cle and  exercicesComptable=:exo and ecrPiece=:pc").setString("cle", var1).setLong("exo", var4).setString("pc", var2);
         }
      } else {
         var8 = var6.createQuery("from Ecritures  where ecrCle" + var3 + "=:cle").setString("cle", var1);
      }

      List var9 = null;
      if (var8.list() != null && var8.list().size() > 0) {
         var9 = var8.list();
      }

      if (var7) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public List ChargerLesEcrituresPiece(String var1, long var2, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var5 = true;
      }

      Query var6 = null;
      if (var2 != 0L) {
         var6 = var4.createQuery("from Ecritures  where  exercicesComptable=:exo and ecrReference1=:pc").setLong("exo", var2).setString("pc", var1);
      } else {
         var6 = var4.createQuery("from Ecritures  where ecrReference1=:pc").setString("pc", var1);
      }

      List var7 = null;
      if (var6.list() != null && var6.list().size() > 0) {
         var7 = var6.list();
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List ChargerLesEcrituresOrigine(long var1, String var3, long var4, Session var6) throws HibernateException, NamingException {
      boolean var7 = false;
      if (var6 == null) {
         var6 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var7 = true;
      }

      Query var8 = null;
      if (var4 != 0L) {
         var8 = var6.createQuery("from Ecritures  where  exercicesComptable=:exo and ecrTypeOrigine=:nat and ecrIdOrigine=:org").setLong("exo", var4).setLong("org", var1).setString("nat", var3);
      } else {
         var8 = var6.createQuery("from Ecritures  where ecrTypeOrigine=:nat and ecrIdOrigine=:org").setLong("org", var1).setString("nat", var3);
      }

      Object var9 = new ArrayList();
      if (var8.list() != null && var8.list().size() > 0) {
         var9 = var8.list();
      }

      if (var7) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var9;
   }

   public List ChargerLesEcritures(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var4 = true;
      }

      Query var5 = var3.createQuery("from Ecritures  where exercicesComptable=:exo").setLong("exo", var1);
      Object var6 = new ArrayList();
      if (var5.list() != null && var5.list().size() > 0) {
         var6 = var5.list();
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var6;
   }

   public List ChargerLesEcrituresById(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var4 = true;
      }

      Query var5 = var3.createQuery("from Ecritures  where ecr_id=:exo").setLong("exo", var1);
      Object var6 = new ArrayList();
      if (var5.list() != null && var5.list().size() > 0) {
         var6 = var5.list();
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var6;
   }

   public List ChargerLesEcrituresRapprochees(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var4 = true;
      }

      Query var5 = var3.createQuery("from Ecritures  where (ecrRapprochement is not null or ecrRapprochement <> '') and exercicesComptable=:exo").setLong("exo", var1);
      Object var6 = new ArrayList();
      if (var5.list() != null && var5.list().size() > 0) {
         var6 = var5.list();
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var6;
   }

   public List mesextraitCompte(String var1, String var2, String var3, int var4, int var5) throws HibernateException, NamingException {
      Session var6 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
      Object var7 = new ArrayList();
      Query var8;
      if (var5 == 1) {
         if (var4 == 0) {
            var8 = var6.createQuery("from Ecritures where ecrEtat<=1 and ecrDateSaisie between '" + var2 + "' and '" + var3 + "' and ecrCompte=:cpt and ecrReserve=0").setString("cpt", var1);
            var7 = var8.list();
         } else if (var4 == 1) {
            var8 = var6.createQuery("from Ecritures where ecrEtat<=1 and ecrDateSaisie between '" + var2 + "' and '" + var3 + "' and (ecrLettrage='' or ecrLettrage is NULL) and ecrCompte=:cpt and ecrReserve=0").setString("cpt", var1);
            var7 = var8.list();
         } else if (var4 == 2) {
            var8 = var6.createQuery("from Ecritures where ecrEtat<=1 and ecrDateSaisie between '" + var2 + "' and '" + var3 + "' and (ecrLettrage<>'' and ecrLettrage is non NULL) and ecrCompte=:cpt and ecrReserve=0").setString("cpt", var1);
            var7 = var8.list();
         } else if (var4 == 3) {
            var8 = var6.createQuery("from Ecritures where ecrEtat<=1 and ecrDateSaisie between '" + var2 + "' and '" + var3 + "' and  (ecrPointage='' or ecrPointage is NULL) and ecrCompte=:cpt and ecrReserve=0").setString("cpt", var1);
            var7 = var8.list();
         } else if (var4 == 4) {
            var8 = var6.createQuery("from Ecritures where ecrEtat<=1 and ecrDateSaisie between '" + var2 + "' and '" + var3 + "' (ecrPointage<>'' and ecrPointage is non NULL) and ecrCompte=:cpt and ecrReserve=0").setString("cpt", var1);
            var7 = var8.list();
         } else if (var4 == 5) {
            var8 = var6.createQuery("from Ecritures where ecrEtat<=1 and ecrDateSaisie between '" + var2 + "' and '" + var3 + "' and (ecrLettrage='' or ecrLettrage is NULL) and (ecrPointage='' or ecrPointage is null) and ecrCompte=:cpt and ecrReserve=0").setString("cpt", var1);
            var7 = var8.list();
         } else if (var4 == 6) {
            var8 = var6.createQuery("from Ecritures where ecrEtat<=1 and ecrDateSaisie between '" + var2 + "' and '" + var3 + "' and (ecrLettrage<>'' and ecrLettrage is non NULL) and (ecrPointage<>'' and ecrPointage is non null) and ecrCompte=:cpt and ecrReserve=0").setString("cpt", var1);
            var7 = var8.list();
         }
      } else if (var4 == 0) {
         var8 = var6.createQuery("from Ecritures where ecrEtat<=1 and ecrDateSaisie between '" + var2 + "' and '" + var3 + "' and ecrCompte=:cpt").setString("cpt", var1);
         var7 = var8.list();
      } else if (var4 == 1) {
         var8 = var6.createQuery("from Ecritures where ecrEtat<=1 and ecrDateSaisie between '" + var2 + "' and '" + var3 + "' and (ecrLettrage='' or ecrLettrage is NULL) and ecrCompte=:cpt").setString("cpt", var1);
         var7 = var8.list();
      } else if (var4 == 2) {
         var8 = var6.createQuery("from Ecritures where ecrEtat<=1 and ecrDateSaisie between '" + var2 + "' and '" + var3 + "' and (ecrLettrage<>'' and ecrLettrage is NOT NULL) and ecrCompte=:cpt").setString("cpt", var1);
         var7 = var8.list();
      } else if (var4 == 3) {
         var8 = var6.createQuery("from Ecritures where ecrEtat<=1 and ecrDateSaisie between '" + var2 + "' and '" + var3 + "' and  (ecrPointage='' or ecrPointage is NULL) and ecrCompte=:cpt").setString("cpt", var1);
         var7 = var8.list();
      } else if (var4 == 4) {
         var8 = var6.createQuery("from Ecritures where ecrEtat<=1 and ecrDateSaisie between '" + var2 + "' and '" + var3 + "' (ecrPointage<>'' and ecrPointage is non NULL) and ecrCompte=:cpt").setString("cpt", var1);
         var7 = var8.list();
      } else if (var4 == 5) {
         var8 = var6.createQuery("from Ecritures where ecrEtat<=1 and ecrDateSaisie between '" + var2 + "' and '" + var3 + "' and (ecrLettrage='' or ecrLettrage is NULL) and (ecrPointage='' or ecrPointage is NULL) and ecrCompte=:cpt").setString("cpt", var1);
         var7 = var8.list();
      } else if (var4 == 6) {
         var8 = var6.createQuery("from Ecritures where ecrEtat<=1 and ecrDateSaisie between '" + var2 + "' and '" + var3 + "' and (ecrLettrage<>'' and ecrLettrage is NOT NULL) and (ecrPointage<>'' and ecrPointage is NOT NULL) and ecrCompte=:cpt").setString("cpt", var1);
         var7 = var8.list();
      }

      this.utilInitHibernate.closeSession();
      return (List)var7;
   }

   public List mesextraitCompte(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var5 = true;
      }

      new ArrayList();
      Query var7 = var4.createQuery("from Ecritures where ecrDateSaisie between '" + var1 + "' and '" + var2 + "' and ecrCode = '" + var3 + "'");
      List var6 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List mesextraitTiers(String var1, int var2, String var3, String var4, ExercicesComptable var5, int var6) throws HibernateException, NamingException {
      Session var7 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
      Object var8 = new ArrayList();
      Query var9;
      if (var6 == 1) {
         if (var2 == 0) {
            var9 = var7.createQuery("from Ecritures where exercicesComptable=:exo and ecrEtat<=1 and ecrCompte in  " + var1 + " and ecrReserve=0 and ecrDateSaisie>=:debut and ecrDateSaisie<=:fin").setLong("exo", var5.getExecpt_id()).setString("debut", var3).setString("fin", var4);
            var8 = var9.list();
         } else if (var2 == 1) {
            var9 = var7.createQuery("from Ecritures where exercicesComptable=:exo and ecrEtat<=1 and (ecrLettrage='' or ecrLettrage IS NULL) and ecrCompte in " + var1 + " and ecrReserve=0 and ecrDateSaisie>=:debut and ecrDateSaisie<=:fin").setLong("exo", var5.getExecpt_id()).setString("debut", var3).setString("fin", var4);
            var8 = var9.list();
         } else if (var2 == 2) {
            var9 = var7.createQuery("from Ecritures where exercicesComptable=:exo and ecrEtat<=1 and (ecrLettrage<>'' and ecrLettrage IS NOT NULL) and ecrCompte in " + var1 + " and ecrReserve=0 and ecrDateSaisie>=:debut and ecrDateSaisie<=:fin").setLong("exo", var5.getExecpt_id()).setString("debut", var3).setString("fin", var4);
            var8 = var9.list();
         } else if (var2 == 3) {
            var9 = var7.createQuery("from Ecritures where exercicesComptable=:exo and ecrEtat<=1 and (ecrPointage='' or ecrPointage IS NULL) and ecrCompte in " + var1 + " and ecrReserve=0 and ecrDateSaisie>=:debut and ecrDateSaisie<=:fin").setLong("exo", var5.getExecpt_id()).setString("debut", var3).setString("fin", var4);
            var8 = var9.list();
         } else if (var2 == 4) {
            var9 = var7.createQuery("from Ecritures where exercicesComptable=:exo and ecrEtat<=1 and (ecrPointage<>'' and ecrPointage IS NOT NULL) and ecrCompte in " + var1 + " and ecrReserve=0 and ecrDateSaisie>=:debut and ecrDateSaisie<=:fin").setLong("exo", var5.getExecpt_id()).setString("debut", var3).setString("fin", var4);
            var8 = var9.list();
         } else if (var2 == 5) {
            var9 = var7.createQuery("from Ecritures where exercicesComptable=:exo and ecrEtat<=1 and (ecrLettrage='' or ecrLettrage IS NULL) and (ecrPointage='' or ecrPointage IS NULL) and ecrCompte in " + var1 + " and ecrReserve=0 and ecrDateSaisie>=:debut and ecrDateSaisie<=:fin").setLong("exo", var5.getExecpt_id()).setString("debut", var3).setString("fin", var4);
            var8 = var9.list();
         } else if (var2 == 6) {
            var9 = var7.createQuery("from Ecritures where exercicesComptable=:exo and ecrEtat<=1 and (ecrLettrage<>'' and ecrLettrage IS NOT NULL) and (ecrPointage<>'' and ecrPointage IS NOT NULL) and ecrCompte in " + var1 + " and ecrReserve=0 and ecrDateSaisie>=:debut and ecrDateSaisie<=:fin").setLong("exo", var5.getExecpt_id()).setString("debut", var3).setString("fin", var4);
            var8 = var9.list();
         }
      } else if (var2 == 0) {
         var9 = var7.createQuery("from Ecritures where exercicesComptable=:exo and ecrEtat<=1 and ecrCompte in  " + var1 + " and ecrDateSaisie>=:debut and ecrDateSaisie<=:fin").setLong("exo", var5.getExecpt_id()).setString("debut", var3).setString("fin", var4);
         var8 = var9.list();
      } else if (var2 == 1) {
         var9 = var7.createQuery("from Ecritures where exercicesComptable=:exo and ecrEtat<=1 and (ecrLettrage='' or ecrLettrage IS NULL) and ecrCompte in " + var1 + " and ecrDateSaisie>=:debut and ecrDateSaisie<=:fin").setLong("exo", var5.getExecpt_id()).setString("debut", var3).setString("fin", var4);
         var8 = var9.list();
      } else if (var2 == 2) {
         var9 = var7.createQuery("from Ecritures where exercicesComptable=:exo and ecrEtat<=1 and (ecrLettrage<>'' and ecrLettrage IS NOT NULL) and ecrCompte in " + var1 + " and ecrDateSaisie>=:debut and ecrDateSaisie<=:fin").setLong("exo", var5.getExecpt_id()).setString("debut", var3).setString("fin", var4);
         var8 = var9.list();
      } else if (var2 == 3) {
         var9 = var7.createQuery("from Ecritures where exercicesComptable=:exo and ecrEtat<=1 and (ecrPointage='' or ecrPointage IS NULL) and ecrCompte in " + var1 + " and ecrDateSaisie>=:debut and ecrDateSaisie<=:fin").setLong("exo", var5.getExecpt_id()).setString("debut", var3).setString("fin", var4);
         var8 = var9.list();
      } else if (var2 == 4) {
         var9 = var7.createQuery("from Ecritures where exercicesComptable=:exo and ecrEtat<=1 and (ecrPointage<>'' and ecrPointage IS NOT NULL) and ecrCompte in " + var1 + " and ecrDateSaisie>=:debut and ecrDateSaisie<=:fin").setLong("exo", var5.getExecpt_id()).setString("debut", var3).setString("fin", var4);
         var8 = var9.list();
      } else if (var2 == 5) {
         var9 = var7.createQuery("from Ecritures where exercicesComptable=:exo and ecrEtat<=1 and (ecrLettrage='' or ecrLettrage IS NULL) and (ecrPointage='' or ecrPointage IS NULL) and ecrCompte in " + var1 + " and ecrDateSaisie>=:debut and ecrDateSaisie<=:fin").setLong("exo", var5.getExecpt_id()).setString("debut", var3).setString("fin", var4);
         var8 = var9.list();
      } else if (var2 == 6) {
         var9 = var7.createQuery("from Ecritures where exercicesComptable=:exo and ecrEtat<=1 and (ecrLettrage<>'' and ecrLettrage IS NOT NULL) and (ecrPointage<>'' and ecrPointage IS NOT NULL) and ecrCompte in " + var1 + " and ecrDateSaisie>=:debut and ecrDateSaisie<=:fin").setLong("exo", var5.getExecpt_id()).setString("debut", var3).setString("fin", var4);
         var8 = var9.list();
      }

      this.utilInitHibernate.closeSession();
      return (List)var8;
   }

   public List selectLesecritures(long var1, String var3) throws HibernateException, NamingException {
      Session var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
      Query var5 = var4.createQuery("from Ecritures where exercicesComptable=:exo ecrEtat<=1 and ecrCompte not in " + var3).setLong("exo", var1);
      List var6 = var5.list();
      this.utilInitHibernate.closeSession();
      return var6;
   }

   public List selectPiece(String var1, String var2, String var3) throws HibernateException, NamingException {
      Session var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
      Query var5 = null;
      if (var2 != null && !var2.isEmpty()) {
         var5 = var4.createQuery("from Ecritures where ecrCode=:jr and ecrPiece=:pc and ecrPeriode=:per").setString("jr", var1).setString("pc", var2).setString("per", var3);
      } else {
         var5 = var4.createQuery("from Ecritures where ecrCode=:jr and ecrPeriode=:per").setString("jr", var1).setString("per", var3);
      }

      new ArrayList();
      List var6 = var5.list();
      this.utilInitHibernate.closeSession();
      return var6;
   }

   public List chargerBalanceMemorisee(String var1, String var2, String var3, boolean var4, Session var5) throws HibernateException, NamingException, ParseException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var6 = true;
      }

      Query var7 = null;
      if (!var4) {
         var7 = var5.createQuery("select ecrCompte,ecrDateSaisie,ecrDebitPays,ecrCreditPays,ecrNature,ecrNatureJrx,exercicesComptable.execpt_id from Ecritures where ecrEtat<=1 and (ecrDateSaisie between '" + var1 + "' and '" + var2 + "' or ecrDateSaisie = '" + var1 + "' or ecrDateSaisie = '" + var2 + "') and ecrNatureJrx not in " + var3 + " and ecrReserve=0 order by ecrCompte asc");
      } else {
         var7 = var5.createQuery("select ecrCompte,ecrDateSaisie,ecrDebitPays,ecrCreditPays,ecrNature,ecrNatureJrx,exercicesComptable.execpt_id from Ecritures where ecrEtat<=1 and (ecrDateSaisie between '" + var1 + "' and '" + var2 + "' or ecrDateSaisie = '" + var1 + "' or ecrDateSaisie = '" + var2 + "') and ecrNatureJrx not in " + var3 + " order by ecrCompte asc");
      }

      new LinkedList();
      List var8 = var7.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      Object[] var9 = null;
      new EcrituresLight();
      String var11 = "";
      Date var12 = null;
      String var13 = "";
      double var14 = 0.0D;
      double var16 = 0.0D;
      boolean var18 = false;
      boolean var19 = false;
      boolean var20 = false;
      UtilDate var21 = new UtilDate();
      ArrayList var22 = new ArrayList();
      if (var8.size() != 0) {
         for(int var23 = 0; var23 < var8.size(); ++var23) {
            var9 = (Object[])((Object[])var8.get(var23));
            var13 = var9[0].toString();
            var12 = var21.stringToDateSQLLight(var9[1].toString());
            var14 = Double.parseDouble(var9[2].toString());
            var16 = Double.parseDouble(var9[3].toString());
            int var25 = Integer.parseInt(var9[4].toString());
            int var26 = Integer.parseInt(var9[5].toString());
            var11 = "" + var9[6].toString();
            var20 = false;
            EcrituresLight var10;
            if (var22.size() == 0) {
               var10 = new EcrituresLight();
               var10.setEcrAnnee(var11);
               var10.setEcrDateSaisie(var12);
               var10.setEcrCompte(var13);
               var10.setEcrDebitSaisie(var14);
               var10.setEcrCreditSaisie(var16);
               var10.setEcrNature(var25);
               var10.setEcrNatureJrx(var26);
               var22.add(var10);
            } else {
               var20 = false;

               for(int var24 = 0; var24 < var22.size(); ++var24) {
                  var10 = (EcrituresLight)var22.get(var24);
                  if (var10.getEcrAnnee().equals(var11) && var10.getEcrCompte().equals(var13) && var10.getEcrNatureJrx() == var26) {
                     var14 += var10.getEcrDebitSaisie();
                     var16 += var10.getEcrCreditSaisie();
                     var10.setEcrDebitSaisie(var14);
                     var10.setEcrCreditSaisie(var16);
                     var20 = true;
                     break;
                  }
               }

               if (!var20) {
                  var10 = new EcrituresLight();
                  var10.setEcrAnnee(var11);
                  var10.setEcrDateSaisie(var12);
                  var10.setEcrCompte(var13);
                  var10.setEcrDebitSaisie(var14);
                  var10.setEcrCreditSaisie(var16);
                  var10.setEcrNature(var25);
                  var10.setEcrNatureJrx(var26);
                  var22.add(var10);
               }
            }
         }
      }

      return var22;
   }

   public List chargerEcritureMemorisee(String var1, String var2, String var3, boolean var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var6 = true;
      }

      Query var7 = null;
      if (!var4) {
         var7 = var5.createQuery("from Ecritures where ecrEtat<=1 and (ecrDateSaisie between '" + var1 + "' and '" + var2 + "' or ecrDateSaisie = '" + var1 + "' or ecrDateSaisie = '" + var2 + "') and ecrNatureJrx not in " + var3 + " and ecrReserve=0 order by ecrCompte asc");
      } else {
         var7 = var5.createQuery("from Ecritures where ecrEtat<=1 and (ecrDateSaisie between '" + var1 + "' and '" + var2 + "' or ecrDateSaisie = '" + var1 + "' or ecrDateSaisie = '" + var2 + "') and ecrNatureJrx not in " + var3 + " order by ecrCompte asc");
      }

      new Ecritures();
      new EcrituresLight();
      ArrayList var10 = new ArrayList();
      new ArrayList();
      List var11 = var7.list();
      if (var11.size() != 0) {
         for(int var12 = 0; var12 < var11.size(); ++var12) {
            Ecritures var8 = (Ecritures)var11.get(var12);
            EcrituresLight var9 = new EcrituresLight();
            var9.setEcrAnnee(var8.getEcrAnnee());
            var9.setEcrDateSaisie(var8.getEcrDateSaisie());
            var9.setEcrCompte(var8.getEcrCompte());
            var9.setEcrDebitSaisie(var8.getEcrDebitPays());
            var9.setEcrCreditSaisie(var8.getEcrCreditPays());
            var9.setEcrNature(var8.getEcrNature());
            var9.setEcrNatureJrx(var8.getEcrNatureJrx());
            var10.add(var9);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List chargerEcriturePlc(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var4 = true;
      }

      Query var5 = var3.createQuery("from Ecritures where exercicesComptable=:exo group by ecrCompte").setLong("exo", var1);
      new Ecritures();
      ArrayList var7 = new ArrayList();
      new ArrayList();
      List var8 = var5.list();
      if (var8.size() != 0) {
         for(int var9 = 0; var9 < var8.size(); ++var9) {
            Ecritures var6 = (Ecritures)var8.get(var9);
            var7.add(var6.getEcrCompte());
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List selectLesDisponibilites(long var1, Date var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var5 = true;
      }

      Query var6 = var4.createQuery("from Ecritures where exercicesComptable=:exo and ecrEtat<=1 and (ecrNature=10 or ecrNature=11) and ecrDateSaisie<='" + var3 + "'").setLong("exo", var1);
      List var7 = var6.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerAllEcr(long var1) throws HibernateException, NamingException {
      new ArrayList();
      Session var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
      Query var5 = var4.createQuery("from Ecritures where exercicesComptable=:exo and ecrEtat<=1 ").setLong("exo", var1);
      List var3 = var5.list();
      this.utilInitHibernate.closeSession();
      return var3;
   }

   public List chargerLesEcrNumCpte(long var1) throws HibernateException, NamingException {
      new ArrayList();
      Session var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
      Query var5 = var4.createQuery("select distinct ecrCompte from Ecritures where exercicesComptable=:exo and ecrEtat<=1").setLong("exo", var1);
      List var3 = var5.list();
      this.utilInitHibernate.closeSession();
      return var3;
   }

   public List chargerLesCle1(long var1) throws HibernateException, NamingException {
      new ArrayList();
      Session var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
      Query var5 = var4.createQuery("select distinct ecrCle1 from Ecritures where exercicesComptable=:exo and ecrEtat<=1").setLong("exo", var1);
      List var3 = var5.list();
      this.utilInitHibernate.closeSession();
      return var3;
   }

   public List chargerLesCle2(long var1) throws HibernateException, NamingException {
      new ArrayList();
      Session var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
      Query var5 = var4.createQuery("select distinct ecrCle2 from Ecritures where exercicesComptable=:exo and ecrEtat<=1").setLong("exo", var1);
      List var3 = var5.list();
      this.utilInitHibernate.closeSession();
      return var3;
   }

   public List chargerLesEcrituresByCodeJr(long var1, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var5 = true;
      }

      new ArrayList();
      Query var7 = var4.createQuery("from Ecritures where exercicesComptable=:exo and ecrEtat<=1 and ecrCode=:code").setLong("exo", var1).setString("code", var3);
      List var6 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public boolean verifJournal(long var1, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var5 = true;
      }

      new ArrayList();
      Query var7 = var4.createQuery("from Ecritures where exercicesComptable=:exo and ecrEtat<=1 and ecrCode=:code").setLong("exo", var1).setString("code", var3).setMaxResults(1);
      List var6 = var7.list();
      boolean var8 = false;
      if (var6.size() != 0) {
         var8 = true;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List chargerLesEcrituresLettres(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from Ecritures where exercicesComptable=:exo and (ecrLettrage<>'' and ecrLettrage IS NOT NULL)").setLong("exo", var1);
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesCodesJournaux(long var1) throws HibernateException, NamingException {
      new ArrayList();
      Session var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
      Query var5 = var4.createQuery("select distinct ecrCode from Ecritures where exercicesComptable=:exo and ecrEtat<=1").setLong("exo", var1);
      List var3 = var5.list();
      this.utilInitHibernate.closeSession();
      return var3;
   }

   public List chargerLeslettres(long var1) throws HibernateException, NamingException {
      new ArrayList();
      Session var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
      Query var5 = var4.createQuery("select distinct ecrLettrage from Ecritures where exercicesComptable=:exo and ecrEtat<=1").setLong("exo", var1);
      List var3 = var5.list();
      this.utilInitHibernate.closeSession();
      return var3;
   }

   public List chargerLesEcritureslettres(long var1, String var3, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var6 = true;
      }

      new ArrayList();
      Query var8 = null;
      if (var3 != null && !var3.isEmpty()) {
         var8 = var5.createQuery("from Ecritures where exercicesComptable=:exo and ecrEtat<=1 and ecrLettrage=:let and ecrCompte=:compte order by ecrLettrage").setString("let", var3).setString("compte", var4).setLong("exo", var1);
      } else {
         var8 = var5.createQuery("from Ecritures where exercicesComptable=:exo and ecrEtat<=1 and (ecrLettrage<>'' and ecrLettrage is not null) and ecrCompte=:compte order by ecrLettrage").setString("compte", var4).setLong("exo", var1);
      }

      List var7 = var8.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerLesEcrituresByNumCpte(long var1, String var3) throws HibernateException, NamingException {
      new ArrayList();
      Session var5 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
      Query var6 = var5.createQuery("from Ecritures where exercicesComptable=:exo and ecrEtat<=1 and ecrCompte=:compte").setString("compte", var3).setLong("exo", var1);
      List var4 = var6.list();
      this.utilInitHibernate.closeSession();
      return var4;
   }

   public List chargerLesComptes(long var1, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var5 = true;
      }

      new ArrayList();
      Query var7 = var4.createQuery("from Ecritures where exercicesComptable=:exo and ecrCompte like '" + var3 + "%' group by ecrCompte order by ecrCompte ASC").setLong("exo", var1);
      List var6 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List totalMvtscredit(String var1, int var2, long var3) throws HibernateException, NamingException {
      Session var5 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
      Query var6 = var5.createQuery("select sum(ecrCreditSaisie) from Ecritures e where ecrEtat<=1 and  e.ecrCle" + var2 + "=:cle and e.exercicesComptable=:exo").setLong("exo", var3).setString("cle", var1);
      List var7 = var6.list();
      this.utilInitHibernate.closeSession();
      return var7;
   }

   public List getLesextaits(String var1, String var2, String var3) throws HibernateException, NamingException {
      Session var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
      Query var5 = var4.createQuery("from Ecritures where ecrCompte=:num  and ecrEtat<=1 and ecrDateSaisie >=:debut and ecrDateSaisie<=:final ");
      var5.setString("num", var1);
      var5.setString("debut", var2);
      var5.setString("final", var3);
      List var6 = var5.list();
      this.utilInitHibernate.closeSession();
      return var6;
   }

   public List getLesextaitsMontOnly(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      Session var5 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
      Query var6 = var5.createQuery("from Ecritures where ecrCompte=:num  and ecrEtat<=1 and ecrDateSaisie >=:debut and ecrDateSaisie<=:final and (ecrCreditPays=:mont or ecrDebitPays=:mont)");
      var6.setString("num", var1);
      var6.setString("debut", var2);
      var6.setString("final", var3);
      var6.setParameter("mont", var4);
      List var7 = var6.list();
      this.utilInitHibernate.closeSession();
      return var7;
   }

   public List getLesextaitsLetOnly(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      Session var5 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
      Query var6 = var5.createQuery("from Ecritures where ecrCompte=:num  and ecrEtat<=1 and ecrDateSaisie >=:debut and ecrDateSaisie<=:final and  ecrLettrage=:let)");
      var6.setString("num", var1);
      var6.setString("debut", var2);
      var6.setString("final", var3);
      var6.setString("let", var4);
      List var7 = var6.list();
      this.utilInitHibernate.closeSession();
      return var7;
   }

   public List getLesextaitsLibOnly(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      Session var5 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
      Query var6 = var5.createQuery("from Ecritures where ecrCompte=:num  and ecrEtat<=1 and ecrDateSaisie >=:debut and ecrDateSaisie<=:final and  ecrLibelle=:lib");
      var6.setString("num", var1);
      var6.setString("debut", var2);
      var6.setString("final", var3);
      var6.setString("lib", var4);
      List var7 = var6.list();
      this.utilInitHibernate.closeSession();
      return var7;
   }

   public List getLesextaitsPieceOnly(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      Session var5 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
      Query var6 = var5.createQuery("from Ecritures where ecrCompte=:num  and ecrEtat<=1 and ecrDateSaisie >=:debut and ecrDateSaisie<=:final and  ecrPiece=:piece");
      var6.setString("num", var1);
      var6.setString("debut", var2);
      var6.setString("final", var3);
      var6.setString("piece", var4);
      List var7 = var6.list();
      this.utilInitHibernate.closeSession();
      return var7;
   }

   public List getLesextaitsRefOnly(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      Session var5 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
      Query var6 = var5.createQuery("from Ecritures where ecrCompte=:num  and ecrEtat<=1 and ecrDateSaisie >=:debut and ecrDateSaisie<=:final and  ecrReference=:ref");
      var6.setString("num", var1);
      var6.setString("debut", var2);
      var6.setString("final", var3);
      var6.setString("ref", var4);
      List var7 = var6.list();
      this.utilInitHibernate.closeSession();
      return var7;
   }

   public List getLesextaitsPointOnly(String var1, String var2, String var3, String var4) throws HibernateException, NamingException {
      Session var5 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
      Query var6 = var5.createQuery("from Ecritures where ecrCompte=:num  and ecrEtat<=1 and ecrDateSaisie >=:debut and ecrDateSaisie<=:final and  ecrPointage=:point");
      var6.setString("num", var1);
      var6.setString("debut", var2);
      var6.setString("final", var3);
      var6.setString("point", var4);
      List var7 = var6.list();
      this.utilInitHibernate.closeSession();
      return var7;
   }

   public List getLesextaitsAll(String var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9) throws HibernateException, NamingException {
      Session var10 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
      Query var11 = var10.createQuery("from Ecritures where ecrCompte=:num  and ecrEtat<=1 and ecrDateSaisie >=:debut and ecrDateSaisie<=:final and ecrLettrage=:let and ecrPointage=:point and ecrReference=:ref and ecrPiece=:piece and ecrLibelle=:lib and (ecrDebitPays=:mont or ecrCreditPays=:mont)");
      var11.setString("num", var1);
      var11.setString("debut", var2);
      var11.setString("final", var3);
      var11.setString("let", var5);
      var11.setString("point", var4);
      var11.setString("ref", var6);
      var11.setString("piece", var7);
      var11.setString("lib", var8);
      var11.setParameter("mont", var9);
      List var12 = var11.list();
      this.utilInitHibernate.closeSession();
      return var12;
   }

   public List getLesextaitsOption1(String var1, String var2, String var3) throws HibernateException, NamingException {
      Session var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
      Query var5 = var4.createQuery("from Ecritures where ecrEtat<=1 and ecrDateSaisie >=:debut and ecrDateSaisie<=:final");
      var5.setString("debut", var2);
      var5.setString("final", var3);
      List var6 = var5.list();
      this.utilInitHibernate.closeSession();
      return var6;
   }

   public List getLesextaitsAllOption1(String var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9) throws HibernateException, NamingException {
      Session var10 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
      Query var11 = var10.createQuery("from Ecritures where ecrEtat<=1 and ecrDateSaisie >=:debut and ecrDateSaisie<=:final and ecrLettrage=:let and ecrPointage=:point and ecrReference=:ref and ecrPiece=:piece and ecrLibelle=:lib and (ecrDebitPays=:mont or ecrCreditPays=:mont)");
      var11.setString("debut", var2);
      var11.setString("final", var3);
      var11.setString("let", var5);
      var11.setString("point", var4);
      var11.setString("ref", var6);
      var11.setString("piece", var7);
      var11.setString("lib", var8);
      var11.setString("mont", var9);
      List var12 = var11.list();
      this.utilInitHibernate.closeSession();
      return var12;
   }

   public String getLibelle(String var1, String var2, String var3) throws HibernateException, NamingException {
      Session var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
      Query var5 = var4.createQuery("from Ecritures where ecrEtat<=1 and ecrCompte=:num  and ecrDateSaisie >=:debut and ecrDateSaisie<=:final)");
      var5.setString("num", var1);
      var5.setString("debut", var2);
      var5.setString("final", var3);
      var5.setMaxResults(1);
      List var6 = var5.list();
      Ecritures var7 = (Ecritures)var5.list().get(0);
      String var8 = var7.getEcrLibelle();
      this.utilInitHibernate.closeSession();
      return var8;
   }

   public List getLesEcritures() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
      Query var2 = var1.createQuery("from Ecritures where ecrEtat<=1");
      List var3 = var2.list();
      this.utilInitHibernate.closeSession();
      return var3;
   }

   public boolean verifMouvment(String var1, long var2, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var5 = true;
      }

      Query var7 = var4.createQuery("from Ecritures where ecrCompte='" + var1 + "' and exercicesComptable=:exo").setLong("exo", var2).setMaxResults(1);
      int var8 = var7.list().size();
      boolean var6;
      if (var8 > 0) {
         var6 = false;
      } else {
         var6 = true;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public boolean verifMouvment(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var4 = true;
      }

      Query var6 = var3.createQuery("from Ecritures where ecrCode='" + var2 + "' and ecrPeriode='" + var1 + "'").setMaxResults(1);
      int var7 = var6.list().size();
      boolean var5;
      if (var7 != 0) {
         var5 = true;
      } else {
         var5 = false;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public boolean verifMouvmentBud(String var1, long var2) throws HibernateException, NamingException {
      Session var5 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
      Query var6 = var5.createQuery("from Ecritures e where e.ecrBudget='" + var1 + "'and e.exercicesComptable=:exo").setLong("exo", var2);
      var6.setMaxResults(1);
      int var7 = var6.list().size();
      boolean var4;
      if (var7 > 0) {
         var4 = false;
      } else {
         var4 = true;
      }

      this.utilInitHibernate.closeSession();
      return var4;
   }

   public boolean verifMouvmentTreso(String var1, long var2) throws HibernateException, NamingException {
      Session var5 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
      Query var6 = var5.createQuery("from Ecritures e where e.ecrTreso='" + var1 + "'and e.exercicesComptable=:exo").setLong("exo", var2);
      var6.setMaxResults(1);
      int var7 = var6.list().size();
      boolean var4;
      if (var7 > 0) {
         var4 = false;
      } else {
         var4 = true;
      }

      this.utilInitHibernate.closeSession();
      return var4;
   }

   public List getLastEcriture(String var1, long var2) throws HibernateException, NamingException {
      Session var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
      Query var5 = var4.createQuery("from Ecritures e where e.ecrCle1=:cle and e.exercicesComptable=:exo order by ecr_id desc").setLong("exo", var2).setParameter("cle", var1);
      List var6 = var5.list();
      this.utilInitHibernate.closeSession();
      return var6;
   }

   public List calculSoldeAnterieur(String var1, String var2, String var3, String var4, long var5, Session var7) throws HibernateException, NamingException {
      boolean var8 = false;
      if (var7 == null) {
         var7 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var8 = true;
      }

      Query var9 = var7.createQuery("from Ecritures where ecrEtat<=1 and ecrCompte=:compt AND ((ecrDateSaisie<'" + var2 + "' AND ecrNatureJrx NOT IN (13,15)) or (ecrPeriode=:per AND ecrNatureJrx IN (15))) AND (ecrCode ='" + var4 + "' or ecrNatureJrx IN (15)) AND exercicesComptable=:exo").setString("compt", var3).setLong("exo", var5).setString("per", var1);
      Object var10 = new ArrayList();
      if (var9.list().size() > 0) {
         var10 = var9.list();
      }

      if (var8) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var10;
   }

   public List calculSoldeJour(String var1, String var2, String var3, String var4, long var5, Session var7) throws HibernateException, NamingException {
      boolean var8 = false;
      if (var7 == null) {
         var7 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var8 = true;
      }

      Query var9 = var7.createQuery("from Ecritures where ecrEtat<=1 and ecrCompte=:compt AND ((ecrDateSaisie<='" + var2 + "' AND ecrNatureJrx NOT IN (13,15)) or (ecrPeriode=:per AND ecrNatureJrx IN (15))) AND (ecrCode ='" + var4 + "' or ecrNatureJrx IN (15)) AND exercicesComptable=:exo").setString("compt", var3).setLong("exo", var5).setString("per", var1);
      Object var10 = new ArrayList();
      if (var9.list().size() > 0) {
         var10 = var9.list();
      }

      if (var8) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var10;
   }

   public List chargerLesmouvementes(String var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
      Query var3 = var2.createQuery("from Ecritures where ecrEtat<=1 and ecrCompte='" + var1 + "'");
      var3.setMaxResults(1);
      List var4 = null;
      var4 = var3.list();
      this.utilInitHibernate.closeSession();
      return var4;
   }

   public List chargerTousLesmouvementes(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Ecritures where ecrEtat<=1 and ecrCompte='" + var1 + "'");
      List var5 = null;
      var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List ChargerLesEcrituresRapp(String var1, String var2, String var3) throws HibernateException, NamingException {
      Session var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
      Query var5 = var4.createQuery("from Ecritures e where e.ecrCode='" + var1 + "' and (e.ecrRapprochement='' or e.ecrRapprochement='" + var2 + "') and e.ecrDateSaisie<='" + var3 + "'");
      List var6 = var5.list();
      this.utilInitHibernate.closeSession();
      return var6;
   }

   public List ChargerLesEcrituresRapp(String var1, String var2, String var3, String var4, long var5, Session var7) {
      Query var8 = var7.createQuery("from Ecritures e where exercicesComptable=:exo and e.ecrCode='" + var1 + "' and (e.ecrRapprochement='' or e.ecrRapprochement is null or e.ecrRapprochement='" + var2 + "') and e.ecrDateSaisie<='" + var3 + "' and e.ecrCompte!='" + var4 + "'").setLong("exo", var5);
      List var9 = var8.list();
      return var9;
   }

   public List ChargerLesEcrituresNonRapp(long var1, Date var3, Session var4) {
      String var5 = "" + (var3.getYear() + 1900 + 1) + ":";
      Query var6 = var4.createQuery("from Ecritures where exercicesComptable=:exo and (ecrRapprochement='' or ecrRapprochement is null or ecrRapprochement like '" + var5 + "%') and ecrDateSaisie<='" + var3 + "' and ecrNature<>10 and ecrNature<>11 and ecrNatureJrx>=7 and ecrNatureJrx<=10 and ecrCode<>'....' ").setLong("exo", var1);
      List var7 = var6.list();
      return var7;
   }

   public List ChargerLesEcrituresRecherche(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Ecritures where " + var1 + " order by ecrCompte");
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public String ChargerLesEcrituresPiece(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Ecritures where " + var1 + " group by ecrPiece order by ecrPiece DESC").setMaxResults(1);
      List var5 = var4.list();
      String var6 = null;
      if (var5.size() != 0) {
         var6 = ((Ecritures)var5.get(0)).getEcrPiece();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List ChargerLesEcrituresLightRecherche(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var3 = true;
      }

      Query var4 = var2.createQuery("select ecrCompte,ecrDateSaisie,ecrDebitPays,ecrCreditPays,ecrLettrage,ecrPointage,ecrDateEcheance,ecrNatureJrx,ecrLibCompte from Ecritures where " + var1 + " order by ecrCompte");
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List totalMvt(String var1, String var2) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
      List var4 = var3.createQuery("from Ecritures e where ecrEtat<=1 and e.ecrCode='" + var1 + "' and e.ecrDateSaisie<='" + var2 + "'").list();
      this.utilInitHibernate.closeSession();
      return var4;
   }

   public List totalMvtAnterieurPeriode(String var1, String var2) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
      List var4 = var3.createQuery("from Ecritures e where ecrEtat<=1 and e.ecrCode='" + var1 + "' and e.ecrPeriode='" + var2 + "'").list();
      this.utilInitHibernate.closeSession();
      return var4;
   }

   public List mvtFinal(String var1, String var2, String var3) throws HibernateException, NamingException {
      Session var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
      List var5 = var4.createQuery("from Ecritures e where ecrEtat<=1 and e.ecrCode='" + var1 + "' and (e.ecrRapprochement='' or e.ecrRapprochement<>'" + var2 + "') and e.ecrDateSaisie<='" + var3 + "'").list();
      this.utilInitHibernate.closeSession();
      return var5;
   }

   public String effaceRapprochement(List var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
      Transaction var3 = var2.beginTransaction();

      for(int var4 = 0; var4 < var1.size(); ++var4) {
         Ecritures var5 = (Ecritures)var1.get(var4);
         String var6 = "";
         SQLQuery var7 = var2.createSQLQuery("UPDATE cpt_ecritures SET ecr_rapprochement='" + var6 + "' WHERE ecr_id=" + var5.getEcr_id() + "");
         var7.executeUpdate();
      }

      var3.commit();
      this.utilInitHibernate.closeSession();
      return "";
   }

   public String fermerLeJournalEncours(int var1, String var2) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
      Transaction var4 = var3.beginTransaction();
      SQLQuery var5 = var3.createSQLQuery("UPDATE cpt_ecritures SET ecr_cloture=" + var1 + " WHERE ecr_cle1='" + var2 + "'");
      var5.executeUpdate();
      var4.commit();
      this.utilInitHibernate.closeSession();
      return "";
   }

   public void copiertoutLesEcritures(List var1, ExercicesComptable var2) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
      Transaction var4 = var3.beginTransaction();

      for(int var5 = 0; var5 < var1.size(); ++var5) {
         Ecritures var6 = (Ecritures)var1.get(var5);
         var6.setExercicesComptable(var2);
         var3.save(var6);
      }

      var4.commit();
      this.utilInitHibernate.closeSession();
   }

   public List chargerlesNumCptesChargeProd(long var1) throws HibernateException, NamingException {
      new ArrayList();
      Session var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
      Query var5 = var4.createQuery("select distinct ecrCompte from Ecritures where exercicesComptable=:exo and ecrNature in (16,17) ").setLong("exo", var1);
      List var3 = var5.list();
      this.utilInitHibernate.closeSession();
      return var3;
   }

   public boolean verifExistBalanceAB(long var1, String var3) throws HibernateException, NamingException {
      new ArrayList();
      Session var5 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
      Query var6 = var5.createQuery("from Ecritures where exercicesComptable=:exo and ecrNatureJrx =13 and ecrCode=:ab and ecrCompte=:cpte ").setLong("exo", var1).setString("cpte", var3).setString("ab", "AB");
      List var4 = var6.list();
      this.utilInitHibernate.closeSession();
      boolean var7;
      if (var4.size() > 0) {
         var7 = true;
      } else {
         var7 = false;
      }

      return var7;
   }

   public List chargerLesEcrituresByNumCpte(String var1, long var2, String var4, String var5, String var6, Session var7) {
      new ArrayList();
      Query var9 = var7.createQuery("from Ecritures where exercicesComptable=" + var2 + " ecrEtat<=1 and ecrCompte='" + var1 + "' and (ecrDateSaisie between '" + var4 + "' and '" + var5 + "') and ecrNatureJrx not in" + var6);
      List var8 = var9.list();
      return var8;
   }

   public List chargerEcrituresEtatFinancier(String var1, long var2, String var4, String var5, String var6, Session var7) throws HibernateException, NamingException {
      boolean var8 = false;
      if (var7 == null) {
         var7 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var8 = true;
      }

      new ArrayList();
      Query var10 = var7.createQuery("from Ecritures where exercicesComptable=" + var2 + " and ecrEtat<=1 and ecrDateSaisie>='" + var4 + "' and ecrDateSaisie<='" + var5 + "' and  ecrCompte  like '" + var1 + "%' and ecrNatureJrx not in" + var6 + " order by ecrCompte ASC ");
      List var9 = var10.list();
      if (var8) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public void chargerEcrituresPourCloture(long var1, Date var3, Date var4, Session var5) {
      Query var6 = var5.createQuery("update from Ecritures set ecr_cloture=1, ecr_etat=1 where exercicesComptable=:ex and ecrEtat<=1 and ecrDateSaisie>=:d1 and ecrDateSaisie<=:d2 and ecrCloture=0").setLong("ex", var1).setDate("d1", var3).setDate("d2", var4);
      var6.executeUpdate();
   }

   public void chargerEcrituresPourDecloture(Date var1, Date var2, Session var3) {
      Query var4 = var3.createQuery("update from Ecritures set ecr_cloture=0, ecr_etat=0 where ecrDateSaisie>=:d1 and ecrDateSaisie<=:d2").setDate("d1", var1).setDate("d2", var2);
      var4.executeUpdate();
   }

   public String deleteEcrbyCle1(String var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
      Transaction var3 = var2.beginTransaction();
      int var4 = var2.createQuery("delete from Ecritures where ecrCle1 in " + var1).executeUpdate();
      var3.commit();
      var2.close();
      this.utilInitHibernate.closeSession();
      return "ok";
   }

   public List recupererSelectedECNump(String var1, String var2, Session var3) {
      new ArrayList();
      List var4 = var3.createQuery("from Ecritures where ecrPiece=:piece AND ecrEtat<=1 and ecrCle1=:cle").setString("piece", var1).setString("cle", var2).list();
      return var4;
   }

   public List recupererSelectedECByCle1(String var1, Session var2) {
      new ArrayList();
      List var3 = var2.createQuery("from Ecritures where ecrCle1=:cle and ecrEtat<=1").setString("cle", var1).list();
      return var3;
   }

   public Ecritures recupererSelectedECById(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var4 = true;
      }

      new ArrayList();
      new Ecritures();
      List var5 = var3.createQuery("from Ecritures where ecr_id=:id").setLong("id", var1).list();
      Ecritures var6;
      if (var5.size() != 0) {
         var6 = (Ecritures)var5.get(0);
      } else {
         var6 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public Ecritures recupererSelectedECByIdBrouillard(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var4 = true;
      }

      new ArrayList();
      new Ecritures();
      List var5 = var3.createQuery("from Ecritures where brouillard.bro_id=:id").setLong("id", var1).list();
      Ecritures var6;
      if (var5.size() != 0) {
         var6 = (Ecritures)var5.get(0);
      } else {
         var6 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List generationBalance(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Ecritures where " + var1 + " order by ecrCompte asc");
      ArrayList var5 = new ArrayList();
      new Ecritures();
      new EcrituresBalance();
      String var8 = "";
      String var9 = "";
      double var10 = 0.0D;
      double var12 = 0.0D;
      boolean var14 = false;
      ArrayList var15 = new ArrayList();
      new ArrayList();
      List var16 = var4.list();
      if (var16.size() != 0) {
         EcrituresBalance var7;
         for(int var17 = 0; var17 < var16.size(); ++var17) {
            Ecritures var6 = (Ecritures)var16.get(var17);
            var8 = var6.getEcrCompte();
            var9 = var6.getEcrLibCompte();
            var10 = var6.getEcrDebitPays();
            var12 = var6.getEcrCreditPays();
            var14 = false;
            if (var15.size() == 0) {
               var7 = new EcrituresBalance();
               var7.setEcrBalCompte(var8);
               var7.setEcrBalLibelle(var9);
               if (var6.getEcrNatureJrx() == 15) {
                  var7.setEcrDebitAN(var10);
                  var7.setEcrCreditAN(var12);
               } else {
                  var7.setEcrDebitMVTS(var10);
                  var7.setEcrCreditMVTS(var12);
               }

               var15.add(var7);
            } else {
               var14 = false;

               for(int var18 = 0; var18 < var15.size(); ++var18) {
                  new EcrituresBalance();
                  var7 = (EcrituresBalance)var15.get(var18);
                  if (var7.getEcrBalCompte().equals(var8)) {
                     if (var6.getEcrNatureJrx() == 15) {
                        var10 += var7.getEcrDebitAN();
                        var12 += var7.getEcrCreditAN();
                        var7.setEcrDebitAN(var10);
                        var7.setEcrCreditAN(var12);
                     } else {
                        var10 += var7.getEcrDebitMVTS();
                        var12 += var7.getEcrCreditMVTS();
                        var7.setEcrDebitMVTS(var10);
                        var7.setEcrCreditMVTS(var12);
                     }

                     var14 = true;
                     break;
                  }
               }

               if (!var14) {
                  var7 = new EcrituresBalance();
                  var7.setEcrBalCompte(var8);
                  var7.setEcrBalLibelle(var9);
                  if (var6.getEcrNatureJrx() == 15) {
                     var7.setEcrDebitAN(var10);
                     var7.setEcrCreditAN(var12);
                  } else {
                     var7.setEcrDebitMVTS(var10);
                     var7.setEcrCreditMVTS(var12);
                  }

                  var15.add(var7);
               }
            }
         }

         if (var15.size() != 0) {
            double var36 = 0.0D;
            double var19 = 0.0D;
            double var21 = 0.0D;
            double var23 = 0.0D;
            double var25 = 0.0D;
            double var27 = 0.0D;
            double var29 = 0.0D;
            double var31 = 0.0D;
            String var33 = "";
            String var34 = ((EcrituresBalance)var15.get(0)).getEcrBalCompte().substring(0, 2);

            for(int var35 = 0; var35 < var15.size(); ++var35) {
               var7 = (EcrituresBalance)var15.get(var35);
               var33 = var7.getEcrBalCompte();
               if (!var7.getEcrBalCompte().startsWith(var34)) {
                  var7 = new EcrituresBalance();
                  var7.setEcrBalCompte("");
                  var7.setEcrBalLibelle("Total classe " + var34);
                  var7.setEcrDebitAN(var21);
                  var7.setEcrCreditAN(var23);
                  var7.setEcrDebitMVTS(var25);
                  var7.setEcrCreditMVTS(var27);
                  var7.setEcrDebitSOLDE(var29);
                  var7.setEcrCreditSOLDE(var31);
                  var5.add(var7);
                  var34 = var33.substring(0, 2);
                  var21 = 0.0D;
                  var23 = 0.0D;
                  var25 = 0.0D;
                  var27 = 0.0D;
                  var29 = 0.0D;
                  var31 = 0.0D;
               }

               var7 = (EcrituresBalance)var15.get(var35);
               var36 = var7.getEcrDebitAN() + var7.getEcrDebitMVTS();
               var19 = var7.getEcrCreditAN() + var7.getEcrCreditMVTS();
               if (var36 > var19) {
                  var7.setEcrDebitSOLDE(var36 - var19);
                  var7.setEcrCreditSOLDE(0.0D);
               } else {
                  var7.setEcrDebitSOLDE(0.0D);
                  var7.setEcrCreditSOLDE(var19 - var36);
               }

               var5.add(var7);
               var21 += var7.getEcrDebitAN();
               var23 += var7.getEcrCreditAN();
               var25 += var7.getEcrDebitMVTS();
               var27 += var7.getEcrCreditMVTS();
               var29 += var7.getEcrDebitSOLDE();
               var31 += var7.getEcrCreditSOLDE();
            }

            var7 = new EcrituresBalance();
            var7.setEcrBalCompte("");
            var7.setEcrBalLibelle("Total classe " + var33);
            var7.setEcrDebitAN(var21);
            var7.setEcrCreditAN(var23);
            var7.setEcrDebitMVTS(var25);
            var7.setEcrCreditMVTS(var27);
            var7.setEcrDebitSOLDE(var29);
            var7.setEcrCreditSOLDE(var31);
            var5.add(var7);
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List generationDossierTransit(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Ecritures where " + var1 + " order by ecrDossier asc");
      ArrayList var5 = new ArrayList();
      new Ecritures();
      new EcrituresBalance();
      String var8 = "";
      String var9 = "";
      double var10 = 0.0D;
      double var12 = 0.0D;
      boolean var14 = false;
      ArrayList var15 = new ArrayList();
      new ArrayList();
      List var16 = var4.list();
      if (var16.size() != 0) {
         EcrituresBalance var7;
         for(int var17 = 0; var17 < var16.size(); ++var17) {
            Ecritures var6 = (Ecritures)var16.get(var17);
            var8 = var6.getEcrDossier();
            var9 = var6.getEcrLibCompte();
            var10 = var6.getEcrDebitPays();
            var12 = var6.getEcrCreditPays();
            var14 = false;
            if (var15.size() == 0) {
               var7 = new EcrituresBalance();
               var7.setEcrBalCompte(var8);
               var7.setEcrBalLibelle(var9);
               if (var6.getEcrNatureJrx() == 15) {
                  var7.setEcrDebitAN(var10);
                  var7.setEcrCreditAN(var12);
               } else {
                  var7.setEcrDebitMVTS(var10);
                  var7.setEcrCreditMVTS(var12);
               }

               var15.add(var7);
            } else {
               var14 = false;

               for(int var18 = 0; var18 < var15.size(); ++var18) {
                  new EcrituresBalance();
                  var7 = (EcrituresBalance)var15.get(var18);
                  if (var7.getEcrBalCompte().equals(var8)) {
                     if (var6.getEcrNatureJrx() == 15) {
                        var10 += var7.getEcrDebitAN();
                        var12 += var7.getEcrCreditAN();
                        var7.setEcrDebitAN(var10);
                        var7.setEcrCreditAN(var12);
                     } else {
                        var10 += var7.getEcrDebitMVTS();
                        var12 += var7.getEcrCreditMVTS();
                        var7.setEcrDebitMVTS(var10);
                        var7.setEcrCreditMVTS(var12);
                     }

                     var14 = true;
                     break;
                  }
               }

               if (!var14) {
                  var7 = new EcrituresBalance();
                  var7.setEcrBalCompte(var8);
                  var7.setEcrBalLibelle(var9);
                  if (var6.getEcrNatureJrx() == 15) {
                     var7.setEcrDebitAN(var10);
                     var7.setEcrCreditAN(var12);
                  } else {
                     var7.setEcrDebitMVTS(var10);
                     var7.setEcrCreditMVTS(var12);
                  }

                  var15.add(var7);
               }
            }
         }

         if (var15.size() != 0) {
            double var22 = 0.0D;
            double var19 = 0.0D;

            for(int var21 = 0; var21 < var15.size(); ++var21) {
               var7 = (EcrituresBalance)var15.get(var21);
               var22 = var7.getEcrDebitAN() + var7.getEcrDebitMVTS();
               var19 = var7.getEcrCreditAN() + var7.getEcrCreditMVTS();
               if (var22 > var19) {
                  var7.setEcrDebitSOLDE(var22 - var19);
                  var7.setEcrCreditSOLDE(0.0D);
               } else {
                  var7.setEcrDebitSOLDE(0.0D);
                  var7.setEcrCreditSOLDE(var19 - var22);
               }

               var5.add(var7);
            }
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List ChargerLesEcrituresJrPeriode(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var4 = true;
      }

      Query var5 = var3.createQuery("from Ecritures where ecrCode='" + var1 + "' and ecrPeriode='" + var2 + "'");
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List recherche(Session var1, long var2, Date var4, Date var5, boolean var6, boolean var7, List var8, String var9, String var10) throws HibernateException, NamingException {
      boolean var11 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var11 = true;
      }

      new ArrayList();
      Criteria var13 = var1.createCriteria(Ecritures.class);
      if (!var6) {
         var13 = var13.add(Restrictions.ne("ecrNatureJrx", 11));
      }

      var13 = var13.add(Restrictions.ne("ecrNatureJrx", 13));
      if (!var7) {
         var13 = var13.add(Restrictions.eq("ecrReserve", 0));
      }

      var13 = var13.add(Restrictions.between("ecrDateSaisie", var4, var5));
      if (var8.size() != 0) {
         var13 = var13.add(Restrictions.in("ecrDossier", var8));
      }

      if (var9 != null && !var9.isEmpty()) {
         var13 = var13.add(Restrictions.like("ecrCompte", var9 + "%"));
      }

      if (var10 != null && !var10.isEmpty()) {
         var13 = var13.add(Restrictions.like("ecrCompte", var10 + "%"));
      }

      List var14 = var13.list();
      if (var11) {
         this.utilInitHibernate.closeSession();
      }

      return var14;
   }

   public List chargerEcrituresBudget(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var5 = true;
      }

      new ArrayList();
      Query var7 = var4.createQuery("from Ecritures where ecrBudgetTreso=:bud and ecrDateSaisie>=:debut and ecrDateSaisie<=:final order by ecrCompte").setString("bud", var3).setString("debut", var1).setString("final", var2);
      List var6 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerEcrituresBudget(String var1, String var2, List var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var5 = true;
      }

      new ArrayList();
      String var7 = "";
      if (var3.size() != 0) {
         for(int var8 = 0; var8 < var3.size(); ++var8) {
            if (var7 != null && !var7.isEmpty()) {
               var7 = var7 + ",'" + ((String)var3.get(var8)).toString() + "'";
            } else {
               var7 = "'" + ((String)var3.get(var8)).toString() + "'";
            }
         }
      }

      Query var9 = var4.createQuery("from Ecritures where ecrCompte in (" + var7 + ") and ecrDateSaisie>=:debut and ecrDateSaisie<=:final order by ecrCompte").setString("debut", var1).setString("final", var2);
      List var6 = var9.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerEcrituresBudget(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from Ecritures where ecrBudgetTreso=:bud order by ecrCompte").setString("bud", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerEcrituresBudget(String var1, String var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var6 = true;
      }

      new ArrayList();
      Query var8 = var5.createQuery("from Ecritures where ecrBudgetTreso=:bud and ecrPosteTreso=:pos and ecrDateSaisie>=:debut and ecrDateSaisie<=:final order by ecrCompte").setString("bud", var3).setString("pos", var4).setString("debut", var1).setString("final", var2);
      List var7 = var8.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List ChargerLesEcrituresExtractCompte(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var4 = true;
      }

      Query var5 = var3.createQuery("from Ecritures  where ecrDateSaisie>=:debut and ecrDateSaisie<=:final group by ecrCompte").setString("debut", var1).setString("final", var2);
      Object var6 = new ArrayList();
      if (var5.list() != null && var5.list().size() > 0) {
         var6 = var5.list();
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var6;
   }

   public List chargerEcrituresTransit(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from Ecritures where ecrDossier=:bud order by ecrCompte").setString("bud", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesBrouillardLignes(Brouillard var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Brouillard");
      new ArrayList();
      Query var4 = var2.createQuery("from Ecritures where brouillard=:bro").setParameter("bro", var1);
      List var3 = var4.list();
      this.utilInitHibernate.closeSession();
      return var3;
   }

   public Ecritures insertBrouillard(Ecritures var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Brouillard");
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

   public Ecritures modifBrouillard(Ecritures var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Brouillard");
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

   public Ecritures modifBrouillard(Ecritures var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public Ecritures insertNoteExterne(Ecritures var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
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

   public Ecritures insertNoteExterne(Ecritures var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public Ecritures modifNoteExterne(Ecritures var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
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

   public Ecritures modifNoteExterne(Ecritures var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public List chargerExtrait(Date var1, Date var2, String var3) throws HibernateException, NamingException {
      Object var4 = new ArrayList();
      if (!var3.isEmpty()) {
         Session var5 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         Query var6 = var5.createQuery("from Ecritures where ecrCompte=:num and ecrEtat<=1 and ecrDateSaisie >=:debut and ecrDateSaisie<=:final ").setString("num", var3).setDate("debut", var1).setDate("final", var2);
         var4 = var6.list();
         this.utilInitHibernate.closeSession();
      }

      return (List)var4;
   }

   public List chargerExtrait(Date var1, Date var2, String var3, Session var4) throws HibernateException, NamingException {
      Object var5 = new ArrayList();
      if (!var3.isEmpty()) {
         boolean var6 = false;
         if (var4 == null) {
            var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
            var6 = true;
         }

         Query var7 = var4.createQuery("from Ecritures where ecrCompte=:num and ecrEtat<=1 and ecrDateSaisie >=:debut and ecrDateSaisie<=:final ").setString("num", var3).setDate("debut", var1).setDate("final", var2);
         var5 = var7.list();
         if (var6) {
            this.utilInitHibernate.closeSession();
         }
      }

      return (List)var5;
   }

   public List chargerExtraitStartWith(Date var1, Date var2, String var3) throws HibernateException, NamingException {
      Object var4 = new ArrayList();
      if (!var3.isEmpty()) {
         Session var5 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         Query var6 = var5.createQuery("from Ecritures where ecrCompte like '" + var3 + "%' and ecrEtat<=1 and ecrDateSaisie >=:debut and ecrDateSaisie<=:final ").setDate("debut", var1).setDate("final", var2);
         var4 = var6.list();
         this.utilInitHibernate.closeSession();
      }

      return (List)var4;
   }

   public List chargerExtraitCompte(Date var1, Date var2, String var3, boolean var4, boolean var5, String var6, String var7, String var8, String var9, String var10, String var11, List var12, List var13, String var14, double var15, String var17, String var18, int var19, Session var20) throws HibernateException, NamingException {
      boolean var21 = false;
      if (var20 == null) {
         var20 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var21 = true;
      }

      Object var22 = new ArrayList();
      Criteria var23 = var20.createCriteria(Ecritures.class).add(Restrictions.between("ecrDateSaisie", var1, var2));
      var23 = var23.add(Restrictions.eq("ecrCompte", var3));
      var23 = var23.add(Restrictions.ne("ecrEtat", 2));
      var23 = var23.add(Restrictions.ne("ecrNatureJrx", 14));
      if (!var4) {
         var23 = var23.add(Restrictions.ne("ecrNatureJrx", 11));
      }

      if (!var5) {
         var23 = var23.add(Restrictions.eq("ecrReserve", 0));
      }

      if (var6.equalsIgnoreCase("1")) {
         var23 = var23.add(Restrictions.or(Restrictions.eq("ecrLettrage", ""), Restrictions.isNull("ecrLettrage")));
      } else if (var6.equalsIgnoreCase("2")) {
         var23 = var23.add(Restrictions.ne("ecrLettrage", "")).add(Restrictions.isNotNull("ecrLettrage"));
      } else if (var6.equalsIgnoreCase("3")) {
         var23 = var23.add(Restrictions.or(Restrictions.eq("ecrPointage", ""), Restrictions.isNull("ecrPointage")));
      } else if (var6.equalsIgnoreCase("4")) {
         var23 = var23.add(Restrictions.ne("ecrPointage", "")).add(Restrictions.isNotNull("ecrPointage"));
      } else if (var6.equalsIgnoreCase("5")) {
         var23 = var23.add(Restrictions.or(Restrictions.eq("ecrLettrage", ""), Restrictions.isNull("ecrLettrage")));
         var23 = var23.add(Restrictions.or(Restrictions.eq("ecrPointage", ""), Restrictions.isNull("ecrPointage")));
      } else if (var6.equalsIgnoreCase("6")) {
         var23 = var23.add(Restrictions.ne("ecrLettrage", "")).add(Restrictions.isNotNull("ecrLettrage")).add(Restrictions.ne("ecrPointage", "")).add(Restrictions.isNotNull("ecrPointage"));
      }

      if (var7 != null && !var7.isEmpty()) {
         var23 = var23.add(Restrictions.like("ecrLibelle", "%" + var7 + "%"));
      }

      String[] var24;
      int var25;
      String[] var26;
      int var27;
      if (var8 != null && !var8.isEmpty()) {
         if (var8.contains(",")) {
            var24 = var8.split(",");
            var25 = var24.length;
            var26 = new String[var25];

            for(var27 = 0; var27 < var25; ++var27) {
               var26[var27] = var24[var27];
            }

            var23 = var23.add(Restrictions.in("ecrLettrage", var26));
         } else {
            var23 = var23.add(Restrictions.eq("ecrLettrage", var8));
         }
      }

      if (var9 != null && !var9.isEmpty()) {
         if (var9.contains(",")) {
            var24 = var9.split(",");
            var25 = var24.length;
            var26 = new String[var25];

            for(var27 = 0; var27 < var25; ++var27) {
               var26[var27] = var24[var27];
            }

            var23 = var23.add(Restrictions.in("ecrPointage", var26));
         } else {
            var23 = var23.add(Restrictions.eq("ecrPointage", var9));
         }
      }

      if (var10 != null && !var10.isEmpty()) {
         var23 = var23.add(Restrictions.eq("EcrReference1", var10));
      }

      if (var11 != null && !var11.isEmpty()) {
         var23 = var23.add(Restrictions.eq("ecrReference2", var11));
      }

      if (var14 != null && !var14.isEmpty()) {
         var23 = var23.add(Restrictions.eq("ecrPiece", var14));
      }

      if (var12 != null && var12.size() != 0) {
         var23 = var23.add(Restrictions.in("ecrCode", var12));
      }

      if (var13 != null && var13.size() != 0) {
         var23 = var23.add(Restrictions.in("ecrNatureJrx", var13));
      }

      if (var15 != 0.0D) {
         var23 = var23.add(Restrictions.or(Restrictions.eq("ecrCreditPays", var15), Restrictions.eq("ecrDebitPays", var15)));
      }

      if (var19 == 0) {
         var23 = var23.addOrder(Order.desc("ecrPiece"));
         var23 = var23.addOrder(Order.desc("ecrDateSaisie"));
      } else if (var19 == 1) {
         var23 = var23.addOrder(Order.desc("ecrDateSaisie"));
      } else {
         var23 = var23.addOrder(Order.desc("ecrDateSaisie"));
      }

      new ArrayList();
      List var31 = var23.list();
      if (var17 != null && !var17.isEmpty() || var18 != null && !var18.isEmpty()) {
         ArrayList var32 = new ArrayList();
         int var28;
         if (var17 != null && !var17.isEmpty()) {
            if (!var17.contains(",")) {
               var32.add(var17.replace("'", ""));
            } else {
               var26 = var17.split(",");
               var27 = var26.length;

               for(var28 = 0; var28 < var27; ++var28) {
                  var32.add(var26[var28].replace("'", ""));
               }
            }
         }

         ArrayList var33 = new ArrayList();
         int var29;
         if (var18 != null && !var18.isEmpty() && var18 != null && !var18.isEmpty()) {
            if (!var18.contains(",")) {
               var33.add(var18.replace("'", ""));
            } else {
               String[] var34 = var18.split(",");
               var28 = var34.length;

               for(var29 = 0; var29 < var28; ++var29) {
                  var33.add(var34[var29].replace("'", ""));
               }
            }
         }

         for(var27 = 0; var27 < var31.size(); ++var27) {
            this.ecritures = (Ecritures)var31.get(var27);
            boolean var35 = false;
            if (var32.size() != 0) {
               for(var29 = 0; var29 < var32.size(); ++var29) {
                  String var30 = ((String)var32.get(var29)).toString();
                  if (this.ecritures.getEcrCompte().startsWith(var30)) {
                     var35 = true;
                     break;
                  }
               }
            }

            boolean var36 = false;
            if (var33.size() != 0) {
               for(int var37 = 0; var37 < var33.size(); ++var37) {
                  if (((String)var33.get(var37)).toString().equals(this.ecritures.getEcrCode())) {
                     var36 = true;
                     break;
                  }
               }
            }

            if (!var35 && !var36) {
               ((List)var22).add(this.ecritures);
            }
         }
      } else {
         var22 = var31;
      }

      if (var21) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var22;
   }

   public List chargerExtraitDossier(int var1, Date var2, Date var3, String var4) throws HibernateException, NamingException {
      Object var5 = new ArrayList();
      if (!var4.isEmpty()) {
         Session var6 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         Query var7 = null;
         if (var1 == 0) {
            var7 = var6.createQuery("from Ecritures where ecrDossier=:num and ecrEtat<=1 and ecrDateSaisie >=:debut and ecrDateSaisie<=:final ").setString("num", var4).setDate("debut", var2).setDate("final", var3);
         } else if (var1 == 1) {
            var7 = var6.createQuery("from Ecritures where ecrDossier=:num and ecrEtat<=1 and ecrDateSaisie >=:debut and ecrDateSaisie<=:final and ecrCompte like '7%'").setString("num", var4).setDate("debut", var2).setDate("final", var3);
         } else if (var1 == 2) {
            var7 = var6.createQuery("from Ecritures where ecrDossier=:num and ecrEtat<=1 and ecrDateSaisie >=:debut and ecrDateSaisie<=:final and ecrCompte like '6%'").setString("num", var4).setDate("debut", var2).setDate("final", var3);
         } else if (var1 == 3) {
            var7 = var6.createQuery("from Ecritures where ecrDossier=:num and ecrEtat<=1 and ecrDateSaisie >=:debut and ecrDateSaisie<=:final and (ecrCompte like '47%' or ecrCompte like '60%')").setString("num", var4).setDate("debut", var2).setDate("final", var3);
         }

         var5 = var7.list();
         this.utilInitHibernate.closeSession();
      }

      return (List)var5;
   }

   public List chargerExtraitClasse(Date var1, Date var2, String var3, boolean var4, boolean var5, String var6, String var7, String var8, String var9, String var10, String var11, List var12, List var13, String var14, double var15, String var17, String var18, int var19, Session var20) throws HibernateException, NamingException {
      boolean var21 = false;
      if (var20 == null) {
         var20 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var21 = true;
      }

      Object var22 = new ArrayList();
      Criteria var23 = var20.createCriteria(Ecritures.class).add(Restrictions.between("ecrDateSaisie", var1, var2));
      var23 = var23.add(Restrictions.ne("ecrEtat", 2));
      var23 = var23.add(Restrictions.ne("ecrNatureJrx", 13));
      var23 = var23.add(Restrictions.ne("ecrNatureJrx", 14));
      if (var3 != null && !var3.isEmpty()) {
         var23 = var23.add(Restrictions.like("ecrCompte", var3 + "%"));
      }

      if (!var4) {
         var23 = var23.add(Restrictions.ne("ecrNatureJrx", 11));
      }

      if (!var5) {
         var23 = var23.add(Restrictions.eq("ecrReserve", 0));
      }

      if (var6.equalsIgnoreCase("1")) {
         var23 = var23.add(Restrictions.or(Restrictions.eq("ecrLettrage", ""), Restrictions.isNull("ecrLettrage")));
      } else if (var6.equalsIgnoreCase("2")) {
         var23 = var23.add(Restrictions.ne("ecrLettrage", "")).add(Restrictions.isNotNull("ecrLettrage"));
      } else if (var6.equalsIgnoreCase("3")) {
         var23 = var23.add(Restrictions.or(Restrictions.eq("ecrPointage", ""), Restrictions.isNull("ecrPointage")));
      } else if (var6.equalsIgnoreCase("4")) {
         var23 = var23.add(Restrictions.ne("ecrPointage", "")).add(Restrictions.isNotNull("ecrPointage"));
      } else if (var6.equalsIgnoreCase("5")) {
         var23 = var23.add(Restrictions.or(Restrictions.eq("ecrLettrage", ""), Restrictions.isNull("ecrLettrage")));
         var23 = var23.add(Restrictions.or(Restrictions.eq("ecrPointage", ""), Restrictions.isNull("ecrPointage")));
      } else if (var6.equalsIgnoreCase("6")) {
         var23 = var23.add(Restrictions.ne("ecrLettrage", "")).add(Restrictions.isNotNull("ecrLettrage")).add(Restrictions.ne("ecrPointage", "")).add(Restrictions.isNotNull("ecrPointage"));
      }

      if (var7 != null && !var7.isEmpty()) {
         var23 = var23.add(Restrictions.like("ecrLibelle", "%" + var7 + "%"));
      }

      String[] var24;
      int var25;
      String[] var26;
      int var27;
      if (var8 != null && !var8.isEmpty()) {
         if (var8.contains(",")) {
            var24 = var8.split(",");
            var25 = var24.length;
            var26 = new String[var25];

            for(var27 = 0; var27 < var25; ++var27) {
               var26[var27] = var24[var27];
            }

            var23 = var23.add(Restrictions.in("ecrLettrage", var26));
         } else {
            var23 = var23.add(Restrictions.eq("ecrLettrage", var8));
         }
      }

      if (var9 != null && !var9.isEmpty()) {
         if (var9.contains(",")) {
            var24 = var9.split(",");
            var25 = var24.length;
            var26 = new String[var25];

            for(var27 = 0; var27 < var25; ++var27) {
               var26[var27] = var24[var27];
            }

            var23 = var23.add(Restrictions.in("ecrPointage", var26));
         } else {
            var23 = var23.add(Restrictions.eq("ecrPointage", var9));
         }
      }

      if (var10 != null && !var10.isEmpty()) {
         var23 = var23.add(Restrictions.eq("ecrReference1", var10));
      }

      if (var11 != null && !var11.isEmpty()) {
         var23 = var23.add(Restrictions.eq("ecrReference2", var11));
      }

      if (var14 != null && !var14.isEmpty()) {
         var23 = var23.add(Restrictions.eq("ecrPiece", var14));
      }

      if (var12.size() != 0) {
         var23 = var23.add(Restrictions.in("ecrCode", var12));
      }

      if (var13 != null && var13.size() != 0) {
         var23 = var23.add(Restrictions.in("ecrNatureJrx", var13));
      }

      if (var15 != 0.0D) {
         var23 = var23.add(Restrictions.or(Restrictions.eq("ecrCreditPays", var15), Restrictions.eq("ecrDebitPays", var15)));
      }

      if (var19 == 0) {
         var23 = var23.addOrder(Order.desc("ecrPiece"));
         var23 = var23.addOrder(Order.desc("ecrDateSaisie"));
      } else if (var19 == 1) {
         var23 = var23.addOrder(Order.desc("ecrDateSaisie"));
      } else {
         var23 = var23.addOrder(Order.desc("ecrDateSaisie"));
      }

      new ArrayList();
      List var31 = var23.list();
      if (var17 != null && !var17.isEmpty() || var18 != null && !var18.isEmpty()) {
         ArrayList var32 = new ArrayList();
         int var28;
         if (var17 != null && !var17.isEmpty()) {
            if (!var17.contains(",")) {
               var32.add(var17.replace("'", ""));
            } else {
               var26 = var17.split(",");
               var27 = var26.length;

               for(var28 = 0; var28 < var27; ++var28) {
                  var32.add(var26[var28].replace("'", ""));
               }
            }
         }

         ArrayList var33 = new ArrayList();
         int var29;
         if (var18 != null && !var18.isEmpty() && var18 != null && !var18.isEmpty()) {
            if (!var18.contains(",")) {
               var33.add(var18.replace("'", ""));
            } else {
               String[] var34 = var18.split(",");
               var28 = var34.length;

               for(var29 = 0; var29 < var28; ++var29) {
                  var33.add(var34[var29].replace("'", ""));
               }
            }
         }

         for(var27 = 0; var27 < var31.size(); ++var27) {
            this.ecritures = (Ecritures)var31.get(var27);
            boolean var35 = false;
            if (var32.size() != 0) {
               for(var29 = 0; var29 < var32.size(); ++var29) {
                  if (((String)var32.get(var29)).toString().equals(this.ecritures.getEcrCompte())) {
                     var35 = true;
                     break;
                  }
               }
            }

            boolean var36 = false;
            if (var33.size() != 0) {
               for(int var30 = 0; var30 < var33.size(); ++var30) {
                  if (((String)var33.get(var30)).toString().equals(this.ecritures.getEcrCode())) {
                     var36 = true;
                     break;
                  }
               }
            }

            if (!var35 && !var36) {
               ((List)var22).add(this.ecritures);
            }
         }
      } else {
         var22 = var31;
      }

      if (var21) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var22;
   }

   public List ChargerRapprochement(String var1, String var2, Date var3, Date var4, long var5, int var7, Session var8) throws HibernateException, NamingException {
      boolean var9 = false;
      if (var8 == null) {
         var8 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var9 = true;
      }

      Query var10 = null;
      if (var7 == 0) {
         var10 = var8.createQuery("from Ecritures where ecrCode=:jr and ecrCompte<>:tr and ecrDateSaisie<=:dt and exercicesComptable=:exo and (ecrDteRapprochement is null or (ecrDteRapprochement is not null and ecrDteRapprochement>=:perRap))").setString("jr", var1).setString("tr", var2).setDate("dt", var3).setLong("exo", var5).setDate("perRap", var4);
      } else {
         var10 = var8.createQuery("from Ecritures where ecrCode=:jr and ecrCompte=:tr and ecrDateSaisie<=:dt and exercicesComptable=:exo and (ecrDteRapprochement is null or (ecrRapprochement is not null and ecrDteRapprochement>=:perRap))").setString("jr", var1).setString("tr", var2).setDate("dt", var3).setLong("exo", var5).setDate("perRap", var4);
      }

      new ArrayList();
      List var11 = var10.list();
      if (var9) {
         this.utilInitHibernate.closeSession();
      }

      return var11;
   }

   public List chargerEcritures(Date var1, Date var2, String var3, Session var4) throws HibernateException, NamingException {
      new ArrayList();
      Query var6 = var4.createQuery("from Ecritures where ecrCode=:jr and ecrDateSaisie>=:debut and ecrDateSaisie<=:final order by ecrCompte").setString("jr", var3).setDate("debut", var1).setDate("final", var2);
      List var5 = var6.list();
      return var5;
   }

   public List chargerEcritures(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      Query var5 = var3.createQuery("from Ecritures where ecrDateSaisie>=:debut and ecrDateSaisie<=:final order by ecrCompte").setDate("debut", var1).setDate("final", var2);
      List var4 = var5.list();
      return var4;
   }

   public List chargerCompte(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      Query var5 = var3.createQuery("from Ecritures where ecrDateSaisie>=:debut and ecrDateSaisie<=:final group by ecrCompte").setDate("debut", var1).setDate("final", var2);
      List var4 = var5.list();
      ArrayList var6 = new ArrayList();
      if (var4.size() != 0) {
         for(int var7 = 0; var7 < var4.size(); ++var7) {
            var6.add(((Ecritures)var4.get(var7)).getEcrCompte());
         }
      }

      return var6;
   }

   public List chargerJournaux(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      Query var5 = var3.createQuery("from Ecritures where ecrDateSaisie>=:debut and ecrDateSaisie<=:final group by ecrCode").setDate("debut", var1).setDate("final", var2);
      List var4 = var5.list();
      ArrayList var6 = new ArrayList();
      if (var4.size() != 0) {
         for(int var7 = 0; var7 < var4.size(); ++var7) {
            var6.add(((Ecritures)var4.get(var7)).getEcrCode());
         }
      }

      return var6;
   }

   public List chargerEcrituresByCompte(Date var1, Date var2, String var3, Session var4) throws HibernateException, NamingException {
      new ArrayList();
      Query var6 = var4.createQuery("from Ecritures where ecrCompte=:cpte and ecrDateSaisie>=:debut and ecrDateSaisie<=:final order by ecrCompte").setString("cpte", var3).setDate("debut", var1).setDate("final", var2);
      List var5 = var6.list();
      return var5;
   }

   public List chargerEcrituresByCompte(long var1, String var3, Session var4) throws HibernateException, NamingException {
      new ArrayList();
      Query var6 = var4.createQuery("from Ecritures ja where ja.exercicesComptable=:ex and ja.ecrCompte=:cpte order by ecrCompte").setLong("ex", var1).setString("cpte", var3);
      List var5 = var6.list();
      return var5;
   }

   public List chargerEcrituresTransfert(Date var1, Date var2, String var3, Session var4) throws HibernateException, NamingException {
      new ArrayList();
      Query var6 = var4.createQuery("from Ecritures where ecrCode=:jr and ecrDateSaisie>=:debut and ecrDateSaisie<=:final and ecrIdOrigine<>0 order by ecrCompte").setString("jr", var3).setDate("debut", var1).setDate("final", var2);
      List var5 = var6.list();
      return var5;
   }

   public List chargerEcrituresListJournal(Date var1, Date var2, String var3, Session var4) throws HibernateException, NamingException {
      new ArrayList();
      Query var6 = var4.createQuery("from Ecritures where ecrCode in " + var3 + " and ecrDateSaisie>=:debut and ecrDateSaisie<=:final order by ecrCompte").setDate("debut", var1).setDate("final", var2);
      List var5 = var6.list();
      return var5;
   }

   public List chargerEcrituresPeriode(String var1, String var2, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      Query var5 = var3.createQuery("from Ecritures where ecrDateSaisie>=:debut and ecrDateSaisie<=:final order by ecrCompte").setString("debut", var1).setString("final", var2);
      List var4 = var5.list();
      return var4;
   }

   public List chargerEcrituresDetruites(Date var1, Date var2, String var3, Session var4) throws HibernateException, NamingException {
      new ArrayList();
      Query var6 = var4.createQuery("from EcrituresDestroy where ecrCode=:jr and ecrDateSaisie>=:debut and ecrDateSaisie<=:final order by ecrCompte").setString("jr", var3).setDate("debut", var1).setDate("final", var2);
      List var5 = var6.list();
      return var5;
   }

   public List chargerEcrituresanalyse(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      Query var5 = var3.createQuery("from Ecritures where ecrDateSaisie>=:debut and ecrDateSaisie<=:final order by ecrCompte").setDate("debut", var1).setDate("final", var2);
      List var4 = var5.list();
      return var4;
   }

   public List chargerEcrituresanalytique(String var1, Date var2, Date var3, Session var4) throws HibernateException, NamingException {
      new ArrayList();
      Query var6 = var4.createQuery("from Ecritures where ecrDateSaisie>=:debut and ecrDateSaisie<=:final and ecrNature in (" + var1 + ") order by ecrCompte").setDate("debut", var2).setDate("final", var3);
      List var5 = var6.list();
      return var5;
   }

   public List chargerEcritures(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "ClotureCompteLight");
         var5 = true;
      }

      new ArrayList();
      Query var7 = null;
      if (var2.equals(var3)) {
         var7 = var4.createQuery("from Ecritures where ecrDateSaisie>=:debut and ecrDateSaisie<=:finalExo and ecrNatureJrx!=11 and ecrNatureJrx!=12 and ecrNatureJrx!=13 and ecrReserve=0 order by ecrCompte").setString("debut", var1).setString("finalExo", var3);
      } else {
         var7 = var4.createQuery("from Ecritures where ecrDateSaisie>=:debut and ecrDateSaisie<=(case when (ecrCompte like '38%' or ecrCompte like '4%'or ecrCompte like '5%') then '" + var3 + "' else '" + var2 + "' end) and ecrNatureJrx!=11 and ecrNatureJrx!=12 and ecrNatureJrx!=13 and ecrReserve=0 order by ecrCompte").setString("debut", var1);
      }

      List var6 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerEcrituresLight(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException, ParseException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "ClotureCompteLight");
         var5 = true;
      }

      Query var6 = null;
      if (var2.equals(var3)) {
         var6 = var4.createQuery("select ecr_id,ecrCode,ecrCompte,ecrDateSaisie,ecrNature,ecrNatureJrx,ecrReserve,ecrDeviseSaisie,ecrDeviseGrp,ecrDevisePays,ecrDebitSaisie,ecrCreditSaisie,ecrLettrage from Ecritures where ecrDateSaisie>=:debut and ecrDateSaisie<=:finalExo and ecrNatureJrx!=11 and ecrNatureJrx!=12 and ecrNatureJrx!=13 and ecrReserve=0 and ecrCode<>'....' order by ecrCompte").setString("debut", var1).setString("finalExo", var3);
      } else {
         var6 = var4.createQuery("select ecr_id,ecrCode,ecrCompte,ecrDateSaisie,ecrNature,ecrNatureJrx,ecrReserve,ecrDeviseSaisie,ecrDeviseGrp,ecrDevisePays,ecrDebitSaisie,ecrCreditSaisie,ecrLettrage from Ecritures where ecrDateSaisie>=:debut and ecrDateSaisie<=(case when (ecrCompte like '38%' or ecrCompte like '4%'or ecrCompte like '5%') then '" + var3 + "' else '" + var2 + "' end) and ecrNatureJrx!=11 and ecrNatureJrx!=12 and ecrNatureJrx!=13 and ecrReserve=0 and ecrCode<>'....' order by ecrCompte").setString("debut", var1);
      }

      new LinkedList();
      List var7 = var6.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      Object[] var8 = null;
      new EcrituresLight();
      Date var10 = null;
      long var11 = 0L;
      String var13 = "";
      String var14 = "";
      String var15 = "";
      String var16 = "";
      String var17 = "";
      String var18 = "";
      double var19 = 0.0D;
      double var21 = 0.0D;
      boolean var23 = false;
      boolean var24 = false;
      boolean var25 = false;
      UtilDate var26 = new UtilDate();
      ArrayList var27 = new ArrayList();
      if (var7.size() != 0) {
         for(int var28 = 0; var28 < var7.size(); ++var28) {
            var8 = (Object[])((Object[])var7.get(var28));
            var11 = Long.parseLong(var8[0].toString());
            var14 = var8[1].toString();
            var13 = var8[2].toString();
            var10 = var26.stringToDateSQLLight(var8[3].toString());
            int var29 = Integer.parseInt(var8[4].toString());
            int var30 = Integer.parseInt(var8[5].toString());
            int var31 = Integer.parseInt(var8[6].toString());
            var15 = var8[7].toString();
            var16 = var8[8].toString();
            var17 = var8[9].toString();
            var19 = Double.parseDouble(var8[10].toString());
            var21 = Double.parseDouble(var8[11].toString());
            if (var8[12] != null && var8[12].toString() != null && !var8[12].toString().isEmpty() && !var8[12].toString().equals("null")) {
               var18 = var8[12].toString();
            } else {
               var18 = "";
            }

            EcrituresLight var9 = new EcrituresLight();
            var9.setEcr_id(var11);
            var9.setEcrCode(var14);
            var9.setEcrCompte(var13);
            var9.setEcrDateSaisie(var10);
            var9.setEcrAnnee("" + var10.getYear() + 1900);
            var9.setEcrNature(var29);
            var9.setEcrNatureJrx(var30);
            var9.setEcrEtat(var31);
            var9.setEcrDeviseSaisie(var15);
            var9.setEcrDebitSaisie(var19);
            var9.setEcrCreditSaisie(var21);
            var9.setEcrLettrage(var18);
            var27.add(var9);
         }
      }

      return var27;
   }

   public List chargerEcrituresByClasse(String var1, String var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "ClotureCompteLight");
         var6 = true;
      }

      new ArrayList();
      Query var8 = null;
      if (var3.equals(var4)) {
         var8 = var5.createQuery("from Ecritures where ecrCompte like '" + var1 + "%' and ecrDateSaisie>=:debut and ecrDateSaisie<=:finalExo and ecrNatureJrx!=11 and ecrNatureJrx!=12 and ecrNatureJrx!=13 and ecrReserve=0 and ecrCode<>'....' order by ecrCompte").setString("debut", var2).setString("finalExo", var4);
      } else {
         var8 = var5.createQuery("from Ecritures where ecrCompte like '" + var1 + "%' and ecrDateSaisie>=:debut and ecrDateSaisie<=(case when (ecrCompte like '38%' or ecrCompte like '4%'or ecrCompte like '5%') then '" + var4 + "' else '" + var3 + "' end) and ecrNatureJrx!=11 and ecrNatureJrx!=12 and ecrNatureJrx!=13 and ecrReserve=0 and ecrCode!='....' order by ecrCompte").setString("debut", var2);
      }

      List var7 = var8.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerEcrituresByClasseLight(String var1, String var2, String var3, String var4, Session var5) throws HibernateException, NamingException, ParseException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "ClotureCompteLight");
         var6 = true;
      }

      Query var7 = null;
      if (var3.equals(var4)) {
         var7 = var5.createQuery("select ecr_id,ecrCode,ecrCompte,ecrDateSaisie,ecrNature,ecrNatureJrx,ecrReserve,ecrDeviseSaisie,ecrDeviseGrp,ecrDevisePays,ecrDebitSaisie,ecrCreditSaisie,ecrLettrage,ecrPiece,ecrReference1,ecrReference2,ecrLibelle from Ecritures where ecrCompte like '" + var1 + "%' and ecrDateSaisie>=:debut and ecrDateSaisie<=:finalExo and ecrNatureJrx!=11 and ecrNatureJrx!=12 and ecrNatureJrx!=13 and ecrReserve=0 and ecrCode!='....' order by ecrCompte").setString("debut", var2).setString("finalExo", var4);
      } else {
         var7 = var5.createQuery("select ecr_id,ecrCode,ecrCompte,ecrDateSaisie,ecrNature,ecrNatureJrx,ecrReserve,ecrDeviseSaisie,ecrDeviseGrp,ecrDevisePays,ecrDebitSaisie,ecrCreditSaisie,ecrLettrage,ecrPiece,ecrReference1,ecrReference2,ecrLibelle from Ecritures where ecrCompte like '" + var1 + "%' and ecrDateSaisie>=:debut and ecrDateSaisie<=(case when (ecrCompte like '38%' or ecrCompte like '4%'or ecrCompte like '5%') then '" + var4 + "' else '" + var3 + "' end) and ecrNatureJrx!=11 and ecrNatureJrx!=12 and ecrNatureJrx!=13 and ecrReserve=0 and ecrCode!='....' order by ecrCompte").setString("debut", var2);
      }

      new LinkedList();
      List var8 = var7.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      Object[] var9 = null;
      new EcrituresLight();
      Date var11 = null;
      long var12 = 0L;
      String var14 = "";
      String var15 = "";
      String var16 = "";
      String var17 = "";
      String var18 = "";
      String var19 = "";
      String var20 = "";
      String var21 = "";
      String var22 = "";
      String var23 = "";
      double var24 = 0.0D;
      double var26 = 0.0D;
      boolean var28 = false;
      boolean var29 = false;
      boolean var30 = false;
      UtilDate var31 = new UtilDate();
      ArrayList var32 = new ArrayList();
      if (var8.size() != 0) {
         for(int var33 = 0; var33 < var8.size(); ++var33) {
            var9 = (Object[])((Object[])var8.get(var33));
            var12 = Long.parseLong(var9[0].toString());
            var15 = var9[1].toString();
            var14 = var9[2].toString();
            var11 = var31.stringToDateSQLLight(var9[3].toString());
            int var34 = Integer.parseInt(var9[4].toString());
            int var35 = Integer.parseInt(var9[5].toString());
            int var36 = Integer.parseInt(var9[6].toString());
            var16 = var9[7].toString();
            var17 = var9[8].toString();
            var18 = var9[9].toString();
            var24 = Double.parseDouble(var9[10].toString());
            var26 = Double.parseDouble(var9[11].toString());
            if (var9[12] != null && var9[12].toString() != null && !var9[12].toString().isEmpty() && !var9[12].toString().equals("null")) {
               var23 = var9[12].toString();
            } else {
               var23 = "";
            }

            if (var9[13] != null && var9[13].toString() != null && !var9[13].toString().isEmpty() && !var9[13].toString().equals("null")) {
               var19 = var9[13].toString();
            } else {
               var19 = "";
            }

            if (var9[14] != null && var9[14].toString() != null && !var9[14].toString().isEmpty() && !var9[14].toString().equals("null")) {
               var20 = var9[14].toString();
            } else {
               var20 = "";
            }

            if (var9[15] != null && var9[15].toString() != null && !var9[15].toString().isEmpty() && !var9[15].toString().equals("null")) {
               var21 = var9[15].toString();
            } else {
               var21 = "";
            }

            if (var9[16] != null && var9[16].toString() != null && !var9[16].toString().isEmpty() && !var9[16].toString().equals("null")) {
               var22 = var9[16].toString();
            } else {
               var22 = "";
            }

            EcrituresLight var10 = new EcrituresLight();
            var10.setEcr_id(var12);
            var10.setEcrCode(var15);
            var10.setEcrCompte(var14);
            var10.setEcrDateSaisie(var11);
            var10.setEcrAnnee("" + var11.getYear() + 1900);
            var10.setEcrNature(var34);
            var10.setEcrNatureJrx(var35);
            var10.setEcrEtat(var36);
            var10.setEcrDeviseSaisie(var16);
            var10.setEcrDebitSaisie(var24);
            var10.setEcrCreditSaisie(var26);
            var10.setEcrLettrage(var23);
            var10.setEcrPiece(var19);
            var10.setEcrReference1(var20);
            var10.setEcrReference2(var21);
            var10.setEcrLibelle(var22);
            var32.add(var10);
         }
      }

      return var32;
   }

   public List chargerEcrituresByClasse(String var1, String var2, String var3, String var4, String var5, Session var6) throws HibernateException, NamingException {
      boolean var7 = false;
      if (var6 == null) {
         var6 = this.utilInitHibernate.getOpenSession(this.mabase, "ClotureCompteLight");
         var7 = true;
      }

      new ArrayList();
      Query var9 = null;
      if (var4.equals(var5)) {
         var9 = var6.createQuery("from Ecritures where ecrCompte like '" + var1 + "%' and ecrDateSaisie>=:debut and ecrDateSaisie<=:finalExo and ecrNatureJrx!=11 and ecrNatureJrx!=12 and ecrNatureJrx!=13 and ecrLettrage=:let and ecrReserve=0 order by ecrCompte").setString("debut", var3).setString("finalExo", var5).setString("let", var2);
      } else {
         var9 = var6.createQuery("from Ecritures where ecrCompte like '" + var1 + "%' and ecrDateSaisie>=:debut and ecrDateSaisie<=(case when (ecrCompte like '38%' or ecrCompte like '4%'or ecrCompte like '5%') then '" + var5 + "' else '" + var4 + "' end) and ecrNatureJrx!=11 and ecrNatureJrx!=12 and ecrNatureJrx!=13  and ecrLettrage=:let and ecrReserve=0 order by ecrCompte").setString("debut", var3).setString("let", var2);
      }

      List var8 = var9.list();
      if (var7) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List chargerEcrituresLettrage(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var5 = true;
      }

      new ArrayList();
      Query var7 = var4.createQuery("from Ecritures where ecrDateSaisie>=:debut and ecrDateSaisie<=:finalExo and ecrNatureJrx!=11 and ecrNatureJrx!=12 and ecrNatureJrx!=13 and ecrCompte like '" + var1 + "%' and ecrReserve=0 order by ecrCompte").setString("debut", var2).setString("finalExo", var3);
      List var6 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerEcrituresNonLettrees(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var5 = true;
      }

      new ArrayList();
      Query var7 = var4.createQuery("from Ecritures where ecrDateSaisie>=:debut and ecrDateSaisie<=:finalExo and ecrNatureJrx!=11 and ecrNatureJrx!=12 and ecrNatureJrx!=13 and ecrCompte like '" + var1 + "%' and (ecrLettrage is null or ecrLettrage='') and ecrReserve=0 order by ecrCompte").setString("debut", var2).setString("finalExo", var3);
      List var6 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerEcrituresCtrlLettrage(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from Ecritures where ecrDateSaisie>=:debut and ecrDateSaisie<=:finalExo and ecrNatureJrx!=11 and ecrNatureJrx!=12 and ecrNatureJrx!=13 and ecrLettrage is not null and ecrLettrage<>'' and ecrReserve=0 order by ecrCompte").setString("debut", var1).setString("finalExo", var2);
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerEcrituresCtrlLettrageLight(String var1, String var2, Session var3) throws HibernateException, NamingException, ParseException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var4 = true;
      }

      Query var5 = var3.createQuery("select ecr_id,ecrCode,ecrCompte,ecrDateSaisie,ecrNature,ecrNatureJrx,ecrReserve,ecrDeviseSaisie,ecrDeviseGrp,ecrDevisePays,ecrDebitSaisie,ecrCreditSaisie,ecrLettrage from Ecritures where ecrDateSaisie>=:debut and ecrDateSaisie<=:finalExo and ecrNatureJrx!=11 and ecrNatureJrx!=12 and ecrNatureJrx!=13 and ecrLettrage is not null and ecrLettrage<>'' and ecrReserve=0 and ecrCode<>'....'  order by ecrCompte").setString("debut", var1).setString("finalExo", var2);
      new LinkedList();
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      Object[] var7 = null;
      new EcrituresLight();
      Date var9 = null;
      long var10 = 0L;
      String var12 = "";
      String var13 = "";
      String var14 = "";
      String var15 = "";
      String var16 = "";
      String var17 = "";
      double var18 = 0.0D;
      double var20 = 0.0D;
      boolean var22 = false;
      boolean var23 = false;
      boolean var24 = false;
      UtilDate var25 = new UtilDate();
      ArrayList var26 = new ArrayList();
      if (var6.size() != 0) {
         for(int var27 = 0; var27 < var6.size(); ++var27) {
            var7 = (Object[])((Object[])var6.get(var27));
            var10 = Long.parseLong(var7[0].toString());
            var13 = var7[1].toString();
            var12 = var7[2].toString();
            var9 = var25.stringToDateSQLLight(var7[3].toString());
            int var28 = Integer.parseInt(var7[4].toString());
            int var29 = Integer.parseInt(var7[5].toString());
            int var30 = Integer.parseInt(var7[6].toString());
            var14 = var7[7].toString();
            var15 = var7[8].toString();
            var16 = var7[9].toString();
            var18 = Double.parseDouble(var7[10].toString());
            var20 = Double.parseDouble(var7[11].toString());
            if (var7[12] != null && var7[12].toString() != null && !var7[12].toString().isEmpty() && !var7[12].toString().equals("null")) {
               var17 = var7[12].toString();
            } else {
               var17 = "";
            }

            EcrituresLight var8 = new EcrituresLight();
            var8.setEcr_id(var10);
            var8.setEcrCode(var13);
            var8.setEcrCompte(var12);
            var8.setEcrDateSaisie(var9);
            var8.setEcrAnnee("" + var9.getYear() + 1900);
            var8.setEcrNature(var28);
            var8.setEcrNatureJrx(var29);
            var8.setEcrEtat(var30);
            var8.setEcrDeviseSaisie(var14);
            var8.setEcrDebitSaisie(var18);
            var8.setEcrCreditSaisie(var20);
            var8.setEcrLettrage(var17);
            var26.add(var8);
         }
      }

      return var26;
   }

   public List chargerEcrituresEffaceLettrage(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from Ecritures where ecrDateSaisie>=:debut and ecrDateSaisie<=:finalExo and ecrNatureJrx!=11 and ecrNatureJrx!=12 and ecrNatureJrx!=13 and ecrLettrage is not null and ecrLettrage<>'' and ecrCompte not like '38%' and ecrCompte not like '4%' and ecrCompte not like '5%' and ecrReserve=0 order by ecrCompte").setString("debut", var1).setString("finalExo", var2);
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerEcritures(ExercicesComptable var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from Ecritures where exercicesComptable=:exo and ecrReserve=0 order by ecrCompte").setParameter("exo", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerEcritures(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from Ecritures where ecrDateSaisie >=:debut and ecrReserve=0 order by ecrCompte").setString("debut", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerEcrituresLight(String var1, Session var2) throws HibernateException, NamingException, ParseException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Ecritures where ecrDateSaisie >=:debut and ecrReserve=0 order by ecrCompte").setString("debut", var1);
      new LinkedList();
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      Object[] var6 = null;
      new EcrituresLight();
      Date var8 = null;
      long var9 = 0L;
      String var11 = "";
      String var12 = "";
      String var13 = "";
      String var14 = "";
      String var15 = "";
      String var16 = "";
      String var17 = "";
      String var18 = "";
      String var19 = "";
      String var20 = "";
      double var21 = 0.0D;
      double var23 = 0.0D;
      boolean var25 = false;
      boolean var26 = false;
      boolean var27 = false;
      UtilDate var28 = new UtilDate();
      ArrayList var29 = new ArrayList();
      if (var5.size() != 0) {
         for(int var30 = 0; var30 < var5.size(); ++var30) {
            var6 = (Object[])((Object[])var5.get(var30));
            var9 = Long.parseLong(var6[0].toString());
            var12 = var6[1].toString();
            var11 = var6[2].toString();
            var8 = var28.stringToDateSQLLight(var6[3].toString());
            int var31 = Integer.parseInt(var6[4].toString());
            int var32 = Integer.parseInt(var6[5].toString());
            int var33 = Integer.parseInt(var6[6].toString());
            var13 = var6[7].toString();
            var14 = var6[8].toString();
            var15 = var6[9].toString();
            var21 = Double.parseDouble(var6[10].toString());
            var23 = Double.parseDouble(var6[11].toString());
            if (var6[12] != null && var6[12].toString() != null && !var6[12].toString().isEmpty() && !var6[12].toString().equals("null")) {
               var20 = var6[12].toString();
            } else {
               var20 = "";
            }

            if (var6[13] != null && var6[13].toString() != null && !var6[13].toString().isEmpty() && !var6[13].toString().equals("null")) {
               var16 = var6[13].toString();
            } else {
               var16 = "";
            }

            if (var6[14] != null && var6[14].toString() != null && !var6[14].toString().isEmpty() && !var6[14].toString().equals("null")) {
               var17 = var6[14].toString();
            } else {
               var17 = "";
            }

            if (var6[15] != null && var6[15].toString() != null && !var6[15].toString().isEmpty() && !var6[15].toString().equals("null")) {
               var18 = var6[15].toString();
            } else {
               var18 = "";
            }

            if (var6[16] != null && var6[16].toString() != null && !var6[16].toString().isEmpty() && !var6[16].toString().equals("null")) {
               var19 = var6[16].toString();
            } else {
               var19 = "";
            }

            EcrituresLight var7 = new EcrituresLight();
            var7.setEcr_id(var9);
            var7.setEcrCode(var12);
            var7.setEcrCompte(var11);
            var7.setEcrDateSaisie(var8);
            var7.setEcrAnnee("" + var8.getYear() + 1900);
            var7.setEcrNature(var31);
            var7.setEcrNatureJrx(var32);
            var7.setEcrEtat(var33);
            var7.setEcrDeviseSaisie(var13);
            var7.setEcrDebitSaisie(var21);
            var7.setEcrCreditSaisie(var23);
            var7.setEcrLettrage(var20);
            var7.setEcrPiece(var16);
            var7.setEcrReference1(var17);
            var7.setEcrReference2(var18);
            var7.setEcrLibelle(var19);
            var29.add(var7);
         }
      }

      return var29;
   }

   public List chargerComptes(Date var1, Date var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var5 = true;
      }

      new ArrayList();
      Query var7 = var4.createQuery("from Ecritures where ecrDateSaisie >=:debut and ecrDateSaisie<=:final and ecrCompte in '" + var3 + "%' and ecrReserve=0 group by ecrCompte order by ecrCompte").setDate("debut", var1).setDate("final", var2);
      List var6 = var7.list();
      ArrayList var8 = new ArrayList();
      if (var6.size() != 0) {
         for(int var9 = 0; var9 < var6.size(); ++var9) {
            var8.add(((Ecritures)var6.get(var9)).getEcrCompte());
         }
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List chargerComptesCharges(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from Ecritures where ecrDateSaisie >=:debut and ecrDateSaisie<=:final and (ecrCompte like '6%' or ecrCompte like '81%' or ecrCompte like '83%' or ecrCompte like '85%' or ecrCompte like '87%' or ecrCompte like '89%') and ecrReserve=0 and ecrCode<>'....' group by ecrCompte order by ecrCompte").setString("debut", var1).setString("final", var2);
      List var5 = var6.list();
      ArrayList var7 = new ArrayList();
      if (var5.size() != 0) {
         for(int var8 = 0; var8 < var5.size(); ++var8) {
            PlanComptable var9 = new PlanComptable();
            var9.setPlcCompte(((Ecritures)var5.get(var8)).getEcrCompte());
            var9.setPlcLibelleCpteFR(((Ecritures)var5.get(var8)).getEcrLibCompte());
            var9.setPlcNature(((Ecritures)var5.get(var8)).getEcrNature());
            var7.add(var9);
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerComptesProduits(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from Ecritures where ecrDateSaisie >=:debut and ecrDateSaisie<=:final and (ecrCompte like '7%' or ecrCompte like '80%' or ecrCompte like '82%' or ecrCompte like '84%' or ecrCompte like '86%' or ecrCompte like '88%') and ecrReserve=0 and ecrCode<>'....' group by ecrCompte order by ecrCompte").setString("debut", var1).setString("final", var2);
      List var5 = var6.list();
      ArrayList var7 = new ArrayList();
      if (var5.size() != 0) {
         for(int var8 = 0; var8 < var5.size(); ++var8) {
            PlanComptable var9 = new PlanComptable();
            var9.setPlcCompte(((Ecritures)var5.get(var8)).getEcrCompte());
            var9.setPlcLibelleCpteFR(((Ecritures)var5.get(var8)).getEcrLibCompte());
            var9.setPlcNature(((Ecritures)var5.get(var8)).getEcrNature());
            var7.add(var9);
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerComptesResultat(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var4 = true;
      }

      Query var5 = var3.createQuery("from Ecritures where ecrDateSaisie >=:debut and ecrDateSaisie<=:final and (ecrCompte like '131%' or ecrCompte like '139%') and ecrNatureJrx=15 and ecrReserve=0 and ecrCode<>'....' group by ecrCompte order by ecrCompte").setString("debut", var1).setString("final", var2);
      new ArrayList();
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerComptesClasse(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var5 = true;
      }

      new ArrayList();
      Query var7 = var4.createQuery("from Ecritures where ecrDateSaisie >=:debut and ecrDateSaisie<=:final and ecrCompte like '" + var3 + "%' and ecrReserve=0 group by ecrCompte order by ecrCompte").setString("debut", var1).setString("final", var2);
      List var6 = var7.list();
      ArrayList var8 = new ArrayList();
      if (var6.size() != 0) {
         for(int var9 = 0; var9 < var6.size(); ++var9) {
            PlanComptable var10 = new PlanComptable();
            var10.setPlcCompte(((Ecritures)var6.get(var9)).getEcrCompte());
            var10.setPlcLibelleCpteFR(((Ecritures)var6.get(var9)).getEcrLibCompte());
            var10.setPlcNature(((Ecritures)var6.get(var9)).getEcrNature());
            var8.add(var10);
         }
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public void changerExercice(String var1, ExercicesComptable var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var4 = true;
      }

      Query var5 = var3.createQuery("update Ecritures set exercicesComptable.execpt_id=" + var2.getExecpt_id() + " where ecrDateSaisie >=:debut and ecrReserve=0 and ecrCode<>'....' ").setString("debut", var1);
      var5.executeUpdate();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

   }

   public String getMabase() {
      return this.mabase;
   }

   public void setMabase(String var1) {
      this.mabase = var1;
   }

   public Users getUsersLog() {
      return this.usersLog;
   }

   public void setUsersLog(Users var1) {
      this.usersLog = var1;
   }

   public List chargerEcrituresProjet(String var1, String var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var6 = true;
      }

      new ArrayList();
      Query var8 = var5.createQuery("from Ecritures where ecrDateSaisie >=:debut and ecrDateSaisie<=:final and ecrBudgetTreso=:prj and ecrPosteTreso=:tre and ecrNatureJrx!=13 order by ecrCompte").setString("debut", var1).setString("final", var2).setString("tre", var3).setString("prj", var4);
      List var7 = var8.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerEcrituresProjet(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var5 = true;
      }

      new ArrayList();
      Query var7 = var4.createQuery("from Ecritures where ecrDateSaisie >=:debut and ecrDateSaisie<=:final and ecrBudgetTreso=:prj and ecrNatureJrx!=13 order by ecrCompte").setString("debut", var1).setString("final", var2).setString("prj", var3);
      List var6 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
