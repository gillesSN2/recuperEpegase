package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Ecritures;
import com.epegase.systeme.classe.EcrituresAnalytique;
import com.epegase.systeme.classe.EcrituresDestroy;
import com.epegase.systeme.classe.Ecrituresanalytiquesdestroy;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class EcrituresAnalytiquesDao implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private Structure structureLog;
   private Users usersLog;
   private String maBase;
   private EcrituresAnalytique ecrituresAnalytique;

   public EcrituresAnalytiquesDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public EcrituresAnalytique inserEcritureAnalytiques(Session var1, EcrituresAnalytique var2) {
      var1.save(var2);
      return var2;
   }

   public EcrituresAnalytique modifEcritureAnalytiques(Session var1, EcrituresAnalytique var2) {
      var1.update(var2);
      return var2;
   }

   public void miseAJourAnalytiqueByEcriture(String var1, Ecritures var2, List var3, Session var4) {
      if (var3.size() != 0) {
         this.ecrituresAnalytique = new EcrituresAnalytique();

         for(int var5 = 0; var5 < var3.size(); ++var5) {
            this.ecrituresAnalytique = (EcrituresAnalytique)var3.get(var5);
            this.ecrituresAnalytique.setEcranaCle(var1);
            this.ecrituresAnalytique.setEcranaClasse(var2.getEcrClasse());
            this.ecrituresAnalytique.setEcranaCle1(var2.getEcrCle1());
            this.ecrituresAnalytique.setEcranaCle2(var2.getEcrCle2());
            this.ecrituresAnalytique.setEcranaCode(var2.getEcrCode());
            this.ecrituresAnalytique.setEcranaCompte(var2.getEcrCompte());
            this.ecrituresAnalytique.setEcranaDateSaisie(var2.getEcrDateSaisie());
            this.ecrituresAnalytique.setEcranaIdOrigine(var2.getEcrIdOrigine());
            this.ecrituresAnalytique.setEcranaTypeOrigine(var2.getEcrTypeOrigine());
            this.ecrituresAnalytique.setEcranaLibelle(var2.getEcrLibelle());
            this.ecrituresAnalytique.setEcranaNature(var2.getEcrNature());
            this.ecrituresAnalytique.setEcranaNatureJrx(var2.getEcrNatureJrx());
            this.ecrituresAnalytique.setEcranaReserve(var2.getEcrReserve());
            this.ecrituresAnalytique.setEcranaOrdre((long)var5);
            this.ecrituresAnalytique.setEcranaPeriode(var2.getEcrPeriode());
            this.ecrituresAnalytique.setEcranaPiece(var2.getEcrPiece());
            this.ecrituresAnalytique.setEcranaReference1(var2.getEcrReference1());
            this.ecrituresAnalytique.setEcranaReference2(var2.getEcrReference2());
            this.ecrituresAnalytique.setEcritures(var2);
            if (this.ecrituresAnalytique.getEcranaPourcentage() != 0.0F && this.ecrituresAnalytique.getEcranaMontantSaisie() == 0.0D) {
               Double var6 = this.ecrituresAnalytique.getEcritures().getEcrDebitPays() + this.ecrituresAnalytique.getEcritures().getEcrCreditPays();
               Double var7 = var6 * (double)this.ecrituresAnalytique.getEcranaPourcentage() / 100.0D;
               this.ecrituresAnalytique.setEcranaMontantSaisie(var7);
            }

            if (this.ecrituresAnalytique.getEcritures().getEcrDebitSaisie() != 0.0D && this.ecrituresAnalytique.getEcritures().getEcrCreditSaisie() == 0.0D) {
               if (this.ecrituresAnalytique.getEcritures().getEcrDebitSaisie() < 0.0D) {
                  this.ecrituresAnalytique.setEcranaSens(1);
               } else {
                  this.ecrituresAnalytique.setEcranaSens(0);
               }
            } else if (this.ecrituresAnalytique.getEcritures().getEcrCreditSaisie() < 0.0D) {
               this.ecrituresAnalytique.setEcranaSens(0);
            } else {
               this.ecrituresAnalytique.setEcranaSens(1);
            }

            double var8 = Math.abs(this.ecrituresAnalytique.getEcranaMontantSaisie());
            this.ecrituresAnalytique.setEcranaMontantSaisie(var8);
            if (this.ecrituresAnalytique.getEcranaMontantSaisie() != 0.0D) {
               var4.save(this.ecrituresAnalytique);
            }
         }
      }

   }

   public void inserEcritureAnalytiquesDestroy(List var1, Users var2, Session var3) {
      new EcrituresAnalytique();

      for(int var5 = 0; var5 < var1.size(); ++var5) {
         EcrituresAnalytique var4 = (EcrituresAnalytique)var1.get(var5);
         Ecrituresanalytiquesdestroy var6 = new Ecrituresanalytiquesdestroy();
         var6.setEcranaDateDelete(new Date());
         var6.setEcranaUserDelete(var2.getUsrid());
         var6.setEcrId(var4.getEcritures().getEcr_id());
         var6.setEcranaCode(var4.getEcranaCode());
         var6.setEcranaDateSaisie(var4.getEcranaDateSaisie());
         var6.setEcranaPeriode(var4.getEcranaPeriode());
         var6.setEcranaNature(var4.getEcranaNature());
         var6.setEcranaMontantSaisie(var4.getEcranaMontantSaisie());
         var6.setEcranaOrdre(var4.getEcranaOrdre());
         var6.setEcranaLibelle(var4.getEcranaLibelle());
         var6.setEcranaSite(var4.getEcranaSite());
         var6.setEcranaSiteLib(var4.getEcranaSiteLib());
         var6.setEcranaDepartement(var4.getEcranaDepartement());
         var6.setEcranaDepartementLib(var4.getEcranaDepartementLib());
         var6.setEcranaService(var4.getEcranaService());
         var6.setEcranaServiceLib(var4.getEcranaServiceLib());
         var6.setEcranaRegion(var4.getEcranaRegion());
         var6.setEcranaRegionLib(var4.getEcranaRegionLib());
         var6.setEcranaSecteur(var4.getEcranaSecteur());
         var6.setEcranaSecteurLib(var4.getEcranaSecteurLib());
         var6.setEcranaPdv(var4.getEcranaPdv());
         var6.setEcranaPdvLib(var4.getEcranaPdvLib());
         var6.setEcranaAnal1(var4.getEcranaAnal1());
         var6.setEcranaAnal1Lib(var4.getEcranaAnal1Lib());
         var6.setEcranaAnal2(var4.getEcranaAnal2());
         var6.setEcranaAnal2Lib(var4.getEcranaAnal2Lib());
         var6.setEcranaAnal3(var4.getEcranaAnal3());
         var6.setEcranaAnal3Lib(var4.getEcranaAnal3Lib());
         var6.setEcranaAnal4(var4.getEcranaAnal4());
         var6.setEcranaAnal4Lib(var4.getEcranaAnal4Lib());
         var6.setEcranaActivite(var4.getEcranaActivite());
         var6.setEcranaActiviteLib(var4.getEcranaActiviteLib());
         var6.setEcranaStr(var4.getEcranaStr());
         var6.setEcranaStrLib(var4.getEcranaStrLib());
         var6.setEcranaAgent(var4.getEcranaAgent());
         var6.setEcranaAgentLib(var4.getEcranaAgentLib());
         var6.setEcranaCompte(var4.getEcranaCompte());
         var6.setEcranaCle1(var4.getEcranaCle1());
         var6.setEcranaCle2(var4.getEcranaCle2());
         var6.setEcranaClasse(var4.getEcranaClasse());
         var6.setEcranaPiece(var4.getEcranaPiece());
         var6.setEcranaReference1(var4.getEcranaReference1());
         var6.setEcranaReference2(var4.getEcranaReference2());
         var6.setEcranaNatureJrx(var4.getEcranaNatureJrx());
         var6.setEcranaReserve(var4.getEcranaReserve());
         var6.setEcranaPourcentage(var4.getEcranaPourcentage());
         var6.setEcranaSens(var4.getEcranaSens());
         var6.setEcranaAgent(var4.getEcranaAgent());
         var6.setEcranaAgentLib(var4.getEcranaAgentLib());
         var6.setEcranaStr(var4.getEcranaStr());
         var6.setEcranaStrLib(var4.getEcranaStrLib());
         var6.setEcranaStrCle(var4.getEcranaStrCle());
         var6.setEcranaRepCle(var4.getEcranaRepCle());
         var6.setEcranaTypeCle(var4.getEcranaTypeCle());
         var3.save(var6);
      }

   }

   public void nettoyageAnalytiqueByEcriture(List var1, Session var2) {
      if (var1.size() != 0) {
         this.ecrituresAnalytique = new EcrituresAnalytique();

         for(int var3 = 0; var3 < var1.size(); ++var3) {
            this.ecrituresAnalytique = (EcrituresAnalytique)var1.get(var3);
            var2.delete(this.ecrituresAnalytique);
         }

         var2.flush();
      }

   }

   public void inserRestaureAnalytiquesDestroy(List var1, Ecritures var2, Session var3) {
      new Ecrituresanalytiquesdestroy();

      for(int var5 = 0; var5 < var1.size(); ++var5) {
         Ecrituresanalytiquesdestroy var4 = (Ecrituresanalytiquesdestroy)var1.get(var5);
         EcrituresAnalytique var6 = new EcrituresAnalytique();
         var6.setEcritures(var2);
         var6.setEcranaCode(var4.getEcranaCode());
         var6.setEcranaDateSaisie(var4.getEcranaDateSaisie());
         var6.setEcranaPeriode(var4.getEcranaPeriode());
         var6.setEcranaNature(var4.getEcranaNature());
         var6.setEcranaMontantSaisie(var4.getEcranaMontantSaisie());
         var6.setEcranaOrdre(var4.getEcranaOrdre());
         var6.setEcranaLibelle(var4.getEcranaLibelle());
         var6.setEcranaSite(var4.getEcranaSite());
         var6.setEcranaSiteLib(var4.getEcranaSiteLib());
         var6.setEcranaDepartement(var4.getEcranaDepartement());
         var6.setEcranaDepartementLib(var4.getEcranaDepartementLib());
         var6.setEcranaService(var4.getEcranaService());
         var6.setEcranaServiceLib(var4.getEcranaServiceLib());
         var6.setEcranaRegion(var4.getEcranaRegion());
         var6.setEcranaRegionLib(var4.getEcranaRegionLib());
         var6.setEcranaSecteur(var4.getEcranaSecteur());
         var6.setEcranaSecteurLib(var4.getEcranaSecteurLib());
         var6.setEcranaPdv(var4.getEcranaPdv());
         var6.setEcranaPdvLib(var4.getEcranaPdvLib());
         var6.setEcranaAnal1(var4.getEcranaAnal1());
         var6.setEcranaAnal1Lib(var4.getEcranaAnal1Lib());
         var6.setEcranaAnal2(var4.getEcranaAnal2());
         var6.setEcranaAnal2Lib(var4.getEcranaAnal2Lib());
         var6.setEcranaAnal3(var4.getEcranaAnal3());
         var6.setEcranaAnal3Lib(var4.getEcranaAnal3Lib());
         var6.setEcranaAnal4(var4.getEcranaAnal4());
         var6.setEcranaAnal4Lib(var4.getEcranaAnal4Lib());
         var6.setEcranaActivite(var4.getEcranaActivite());
         var6.setEcranaActiviteLib(var4.getEcranaActiviteLib());
         var6.setEcranaStr(var4.getEcranaStr());
         var6.setEcranaStrLib(var4.getEcranaStrLib());
         var6.setEcranaAgent(var4.getEcranaAgent());
         var6.setEcranaAgentLib(var4.getEcranaAgentLib());
         var6.setEcranaCompte(var4.getEcranaCompte());
         var6.setEcranaCle1(var4.getEcranaCle1());
         var6.setEcranaCle2(var4.getEcranaCle2());
         var6.setEcranaClasse(var4.getEcranaClasse());
         var6.setEcranaPiece(var4.getEcranaPiece());
         var6.setEcranaReference1(var4.getEcranaReference1());
         var6.setEcranaReference2(var4.getEcranaReference2());
         var6.setEcranaNatureJrx(var4.getEcranaNatureJrx());
         var6.setEcranaReserve(var4.getEcranaReserve());
         var6.setEcranaPourcentage(var4.getEcranaPourcentage());
         var6.setEcranaSens(var4.getEcranaSens());
         var6.setEcranaAgent(var4.getEcranaAgent());
         var6.setEcranaAgentLib(var4.getEcranaAgentLib());
         var6.setEcranaStr(var4.getEcranaStr());
         var6.setEcranaStrLib(var4.getEcranaStrLib());
         var6.setEcranaStrCle(var4.getEcranaStrCle());
         var6.setEcranaRepCle(var4.getEcranaRepCle());
         var6.setEcranaTypeCle(var4.getEcranaTypeCle());
         var3.save(var6);
      }

   }

   public void nettoyageAnalytiqueDestroy(List var1, Session var2) {
      if (var1.size() != 0) {
         new Ecrituresanalytiquesdestroy();

         for(int var4 = 0; var4 < var1.size(); ++var4) {
            Ecrituresanalytiquesdestroy var3 = (Ecrituresanalytiquesdestroy)var1.get(var4);
            var2.delete(var3);
         }
      }

   }

   public void nettoyageAnalytique(EcrituresAnalytique var1, Session var2) {
      var2.delete(var1);
   }

   public void nettoyageAnalytique(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Ecritures");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         Query var5 = var3.createQuery("delete from EcrituresAnalytique where ecranaId =:Sid");
         var5.setParameter("Sid", var1);
         var5.executeUpdate();
         var4.commit();
      } catch (HibernateException var9) {
         if (var4 != null) {
            var4.rollback();
         }

         throw var9;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public List chargerLesEcrituresAnalytiques(Ecritures var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Ecritures");
         var3 = true;
      }

      List var4 = var2.createQuery("from EcrituresAnalytique where ecritures.ecr_id=:ecrId order by ecrana_cle").setLong("ecrId", var1.getEcr_id()).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesEcrituresAnalytiques(Ecritures var1, int var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Ecritures");
         var4 = true;
      }

      List var5 = var3.createQuery("from EcrituresAnalytique where ecritures.ecr_id=:ecrId order by ecrana_cle").setLong("ecrId", var1.getEcr_id()).list();
      ArrayList var6 = new ArrayList();
      if (var5.size() != 0) {
         for(int var7 = 0; var7 < var5.size(); ++var7) {
            if (var2 == 1) {
               if (((EcrituresAnalytique)var5.get(var7)).getEcranaProjet() != null && !((EcrituresAnalytique)var5.get(var7)).getEcranaProjet().isEmpty()) {
                  var6.add(var5.get(var7));
               }
            } else if (((EcrituresAnalytique)var5.get(var7)).getEcranaProjet() == null || ((EcrituresAnalytique)var5.get(var7)).getEcranaProjet().isEmpty()) {
               var6.add(var5.get(var7));
            }
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public boolean exsitLesEcrituresAnalytiques(Ecritures var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Ecritures");
         var3 = true;
      }

      List var4 = var2.createQuery("from EcrituresAnalytique where ecritures.ecr_id=:ecrId order by ecrana_cle").setLong("ecrId", var1.getEcr_id()).setMaxResults(1).list();
      boolean var5 = false;
      if (var4.size() != 0) {
         var5 = true;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public EcrituresAnalytique trouverEcritureAnalytiques(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Ecritures");
         var4 = true;
      }

      List var5 = var3.createQuery("from EcrituresAnalytique where ecranaId=:ecrId").setLong("ecrId", var1).setMaxResults(1).list();
      this.ecrituresAnalytique = null;
      if (var5.size() != 0) {
         this.ecrituresAnalytique = (EcrituresAnalytique)var5.get(0);
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.ecrituresAnalytique;
   }

   public List chargerLesEcrituresAnalytiquesByPiece(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Ecritures");
         var5 = true;
      }

      List var6 = var4.createQuery("from EcrituresAnalytique where ecranaPiece=:pc and ecranaPeriode=:per and ecranaCode=:jr").setString("pc", var1).setString("per", var2).setString("jr", var3).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesEcrituresAnalytiquesByJournal(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Ecritures");
         var4 = true;
      }

      List var5 = var3.createQuery("from EcrituresAnalytique where ecranaPeriode=:per and ecranaCode=:jr").setString("per", var1).setString("jr", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesEcrituresAnalytiquesByJournal(Date var1, Date var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Ecritures");
         var5 = true;
      }

      List var6 = var4.createQuery("from EcrituresAnalytique where ecranaDateSaisie>=:dDeb and ecranaDateSaisie<=:dFin and ecranaCode=:jr").setDate("dDeb", var1).setDate("dFin", var2).setString("jr", var3).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesEcrituresAnalytiquesByJournalTransfert(Date var1, Date var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Ecritures");
         var5 = true;
      }

      List var6 = var4.createQuery("from EcrituresAnalytique where ecranaDateSaisie>=:dDeb and ecranaDateSaisie<=:dFin and ecranaCode=:jr and ecranaIdOrigine<>0").setDate("dDeb", var1).setDate("dFin", var2).setString("jr", var3).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesEcrituresAnalytiquesByListJournal(Date var1, Date var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Ecritures");
         var5 = true;
      }

      List var6 = var4.createQuery("from EcrituresAnalytique where ecranaDateSaisie>=:dDeb and ecranaDateSaisie<=:dFin and ecranaCode in " + var3).setDate("dDeb", var1).setDate("dFin", var2).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesEcrituresAnalytiquesByDate(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Ecritures");
         var4 = true;
      }

      List var5 = var3.createQuery("from EcrituresAnalytique where ecranaDateSaisie>=:dDeb and ecranaDateSaisie<=:dFin").setDate("dDeb", var1).setDate("dFin", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesEcrituresAnalytiques(Date var1, Date var2, String var3, boolean var4, boolean var5, String var6, String var7, String var8, String var9, String var10, String var11, String var12, String var13, String var14, String var15, String var16, String var17, String var18, String var19, Session var20) throws HibernateException, NamingException {
      boolean var21 = false;
      if (var20 == null) {
         var20 = this.utilInitHibernate.getOpenSession(this.maBase, "Ecritures");
         var21 = true;
      }

      new ArrayList();
      Criteria var23 = var20.createCriteria(EcrituresAnalytique.class).add(Restrictions.between("ecrDateSaisie", var1, var2));
      var23 = var23.add(Restrictions.eq("ecranaCompte", var3));
      var23 = var23.add(Restrictions.ne("ecritures.ecrEtat", 2));
      var23 = var23.add(Restrictions.ne("ecranaNatureJrx", 13));
      var23 = var23.add(Restrictions.ne("ecranaNatureJrx", 14));
      if (!var4) {
         var23 = var23.add(Restrictions.ne("ecranaNatureJrx", 11));
      }

      if (!var5) {
         var23 = var23.add(Restrictions.eq("ecranaReserve", 0));
      }

      if (var6 != null && !var6.isEmpty()) {
         var23 = var23.add(Restrictions.eq("ecranaSite", var6));
      }

      if (var7 != null && !var7.isEmpty()) {
         var23 = var23.add(Restrictions.eq("ecranaDepartement", var7));
      }

      if (var8 != null && !var8.isEmpty()) {
         var23 = var23.add(Restrictions.eq("ecranaService", var8));
      }

      if (var9 != null && !var9.isEmpty()) {
         var23 = var23.add(Restrictions.eq("ecranaRegion", var9));
      }

      if (var10 != null && !var10.isEmpty()) {
         var23 = var23.add(Restrictions.eq("ecranaSecteur", var10));
      }

      if (var11 != null && !var11.isEmpty()) {
         var23 = var23.add(Restrictions.eq("ecranaPdv", var11));
      }

      if (var12 != null && !var12.isEmpty()) {
         var23 = var23.add(Restrictions.eq("ecranaLigne", var12));
      }

      if (var13 != null && !var13.isEmpty()) {
         var23 = var23.add(Restrictions.eq("ecranaAtelier", var13));
      }

      if (var14 != null && !var14.isEmpty()) {
         var23 = var23.add(Restrictions.eq("ecranaAnal1", var14));
      }

      if (var15 != null && !var15.isEmpty()) {
         var23 = var23.add(Restrictions.eq("ecranaAnal2", var15));
      }

      if (var16 != null && !var16.isEmpty()) {
         var23 = var23.add(Restrictions.eq("ecranaAnal3", var16));
      }

      if (var17 != null && !var17.isEmpty()) {
         var23 = var23.add(Restrictions.eq("ecranaAnal4", var17));
      }

      if (var18 != null && !var18.isEmpty()) {
         var23 = var23.add(Restrictions.eq("ecranaActivite", var18));
      }

      if (var19 != null && !var19.isEmpty()) {
         var23 = var23.add(Restrictions.eq("ecranaProjet", var19));
      }

      new ArrayList();
      List var24 = var23.list();
      if (var21) {
         this.utilInitHibernate.closeSession();
      }

      return var24;
   }

   public List chargerEcrituresAnalytiques(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Ecritures");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from EcrituresAnalytique where ecranaDateSaisie >=:debut order by ecranaCode").setString("debut", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List ChargerLesEcrituresanalytiquesRecherche(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Ecritures");
         var3 = true;
      }

      Query var4 = var2.createQuery("from EcrituresAnalytique where " + var1 + " order by ecranaCode");
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public boolean verifMouvmentBud(String var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Ecritures");
      Transaction var4 = var3.beginTransaction();
      Query var5 = var3.createQuery("from EcrituresAnalytique e where e.ecranaBudget='" + var1 + "'");
      var5.setMaxResults(1);
      int var6 = var5.list().size();
      boolean var2;
      if (var6 > 0) {
         var2 = false;
      } else {
         var2 = true;
      }

      var4.commit();
      this.utilInitHibernate.closeSession();
      return var2;
   }

   public List recherche(Session var1, long var2, Date var4, Date var5, boolean var6, boolean var7, boolean var8, List var9, List var10, List var11, List var12, List var13, List var14, List var15, List var16, List var17, List var18, List var19, List var20, List var21, List var22, List var23, List var24, String var25, String var26, List var27, List var28, List var29, List var30) throws HibernateException, NamingException {
      boolean var31 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Ecritures");
         var31 = true;
      }

      new ArrayList();
      Criteria var33 = var1.createCriteria(EcrituresAnalytique.class);
      if (!var6) {
         var33 = var33.add(Restrictions.ne("ecranaNatureJrx", 11));
      }

      var33 = var33.add(Restrictions.ne("ecranaNatureJrx", 13));
      if (!var7) {
         var33 = var33.add(Restrictions.eq("ecranaReserve", 0));
      }

      var33 = var33.add(Restrictions.between("ecranaDateSaisie", var4, var5));
      if (var8) {
         if (var10.size() != 0) {
            var33 = var33.add(Restrictions.in("ecranaActivite", var10));
         }

         if (var11.size() != 0) {
            var33 = var33.add(Restrictions.in("ecranaAnal1", var11));
         }

         if (var12.size() != 0) {
            var33 = var33.add(Restrictions.in("ecranaAnal3", var12));
         }
      } else if (var9.size() != 0) {
         var33 = var33.add(Restrictions.in("ecranaActivite", var9));
      }

      if (var13.size() != 0) {
         var33 = var33.add(Restrictions.in("ecranaSite", var13));
      }

      if (var14.size() != 0) {
         var33 = var33.add(Restrictions.in("ecranaDepartement", var14));
      }

      if (var15.size() != 0) {
         var33 = var33.add(Restrictions.in("ecranaService", var15));
      }

      if (var16.size() != 0) {
         var33 = var33.add(Restrictions.in("ecranaRegion", var16));
      }

      if (var17.size() != 0) {
         var33 = var33.add(Restrictions.in("ecranaSecteur", var17));
      }

      if (var18.size() != 0) {
         var33 = var33.add(Restrictions.in("ecranaPdv", var18));
      }

      if (var19.size() != 0) {
         var33 = var33.add(Restrictions.in("ecranaSite", var19));
      }

      if (var20.size() != 0) {
         var33 = var33.add(Restrictions.in("ecranaLigne", var20));
      }

      if (var21.size() != 0) {
         var33 = var33.add(Restrictions.in("ecranaAtelier", var21));
      }

      if (var29.size() != 0) {
         var33 = var33.add(Restrictions.in("ecranaAnal1", var29));
      }

      if (var23.size() != 0) {
         var33 = var33.add(Restrictions.in("ecranaAnal2", var23));
      }

      if (var30.size() != 0) {
         var33 = var33.add(Restrictions.in("ecranaAnal3", var30));
      }

      if (var22.size() != 0) {
         var33 = var33.add(Restrictions.in("ecranaAnal4", var22));
      }

      if (var24.size() != 0) {
         var33 = var33.add(Restrictions.in("ecranaAgent", var24));
      }

      if (var27.size() != 0) {
         var33 = var33.add(Restrictions.in("ecranaStrCle", var27));
      }

      if (var28.size() != 0) {
         var33 = var33.add(Restrictions.in("ecranaStr", var28));
      }

      if (var25 != null && !var25.isEmpty()) {
         var33 = var33.add(Restrictions.like("ecranaCompte", var25 + "%"));
      }

      if (var26 != null && !var26.isEmpty()) {
         var33 = var33.add(Restrictions.like("ecranaCompte", var26 + "%"));
      }

      List var34 = var33.list();
      if (var31) {
         this.utilInitHibernate.closeSession();
      }

      return var34;
   }

   public List chargerLesEcrituresAnalytiquesDetruites(EcrituresDestroy var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Ecritures");
         var3 = true;
      }

      List var4 = var2.createQuery("from Ecrituresanalytiquesdestroy where ecrId=:ecrId").setLong("ecrId", var1.getEcrId()).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerEcrituresProjet(String var1, String var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "Ecritures");
         var6 = true;
      }

      new ArrayList();
      Query var8 = var5.createQuery("from EcrituresAnalytique where ecranaDateSaisie >=:debut and ecranaDateSaisie<=:final and ecranaProjet=:prj and ecranaPoste=:tre and ecranaNatureJrx!=13 order by ecranaCompte").setString("debut", var1).setString("final", var2).setString("tre", var3).setString("prj", var4);
      List var7 = var8.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerEcrituresBudget(String var1, String var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "Ecritures");
         var6 = true;
      }

      new ArrayList();
      Query var8 = var5.createQuery("from EcrituresAnalytique where ecranaDateSaisie >=:debut and ecranaDateSaisie<=:final and ecranaProjet=:bud and ecranaPoste=:pos and ecranaNatureJrx!=13 order by ecranaCompte").setString("debut", var1).setString("final", var2).setString("bud", var3).setString("pos", var4);
      List var7 = var8.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerEcrituresProjet(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Ecritures");
         var5 = true;
      }

      new ArrayList();
      Query var7 = var4.createQuery("from EcrituresAnalytique where ecranaDateSaisie >=:debut and ecranaDateSaisie<=:final and ecranaProjet=:prj and ecranaNatureJrx!=13 order by ecranaCompte").setString("debut", var1).setString("final", var2).setString("prj", var3);
      List var6 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerEcrituresEntite(String var1, String var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "Ecritures");
         var6 = true;
      }

      new ArrayList();
      Query var8 = var5.createQuery("from EcrituresAnalytique where ecranaDateSaisie >=:debut and ecranaDateSaisie<=:final and ecranaProjet=:prj and ecranaEntite=:ent and ecranaNatureJrx!=13 order by ecranaCompte").setString("debut", var1).setString("final", var2).setString("prj", var3).setString("ent", var4);
      List var7 = var8.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerEcrituresEntite(String var1, String var2, String var3, String var4, String var5, Session var6) throws HibernateException, NamingException {
      boolean var7 = false;
      if (var6 == null) {
         var6 = this.utilInitHibernate.getOpenSession(this.maBase, "Ecritures");
         var7 = true;
      }

      new ArrayList();
      Query var9 = var6.createQuery("from EcrituresAnalytique where ecranaDateSaisie >=:debut and ecranaDateSaisie<=:final and ecranaProjet=:prj and ecranaPoste=:pos and ecranaEntite=:ent and ecranaNatureJrx!=13 order by ecranaCompte").setString("debut", var1).setString("final", var2).setString("prj", var3).setString("pos", var4).setString("ent", var5);
      List var8 = var9.list();
      if (var7) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public String getMaBase() {
      return this.maBase;
   }

   public void setMaBase(String var1) {
      this.maBase = var1;
   }

   public Structure getStructureLog() {
      return this.structureLog;
   }

   public void setStructureLog(Structure var1) {
      this.structureLog = var1;
   }

   public Users getUsersLog() {
      return this.usersLog;
   }

   public void setUsersLog(Users var1) {
      this.usersLog = var1;
   }
}
