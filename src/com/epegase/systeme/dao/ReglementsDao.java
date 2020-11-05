package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Eleves;
import com.epegase.systeme.classe.ExercicesCaisse;
import com.epegase.systeme.classe.Patients;
import com.epegase.systeme.classe.Reglements;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class ReglementsDao implements Serializable {
   private Reglements reglements;
   private ExercicesCaisse exercicesCaisse;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ReglementsDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public Reglements insert(Reglements var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
      Transaction var3 = var2.beginTransaction();
      var2.save(var1);
      var3.commit();
      this.utilInitHibernate.closeSession();
      return var1;
   }

   public Reglements insert(Reglements var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public Reglements modifier(Reglements var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
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

   public Reglements modifierReg(Reglements var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public Reglements avoirReg(Reglements var1, Session var2) {
      Reglements var3 = new Reglements();
      var3.setRglActivite(var1.getRglActivite());
      var3.setRglActiviteCompte(var1.getRglActiviteCompte());
      var3.setRglActiviteExo(var1.isRglActiviteExo());
      var3.setRglActiviteTaux(var1.getRglActiviteTaux());
      var3.setRglB1(var1.getRglB1());
      var3.setRglB10(var1.getRglB10());
      var3.setRglB2(var1.getRglB2());
      var3.setRglB3(var1.getRglB3());
      var3.setRglB4(var1.getRglB4());
      var3.setRglB5(var1.getRglB5());
      var3.setRglB6(var1.getRglB6());
      var3.setRglB7(var1.getRglB7());
      var3.setRglB8(var1.getRglB8());
      var3.setRglB9(var1.getRglB9());
      var3.setRglBanqueMvt2(var1.getRglBanqueMvt2());
      var3.setRglBanqueTireur(var1.getRglBanqueTireur());
      var3.setRglBon(var1.getRglBon());
      var3.setRglBudget(var1.getRglBudget());
      var3.setRglCaisseMvt1(var1.getRglCaisseMvt1());
      var3.setRglCategorie(var1.getRglCategorie());
      var3.setRglCle1(var1.getRglCle1());
      var3.setRglCle1Repartition(var1.getRglCle1Repartition());
      var3.setRglCle2(var1.getRglCle2());
      var3.setRglCle2Repartition(var1.getRglCle2Repartition());
      var3.setRglCle3(var1.getRglCle3());
      var3.setRglCle4(var1.getRglCle4());
      var3.setRglCodeBudgetTreso(var1.getRglCodeBudgetTreso());
      var3.setRglCodeCaiss(var1.getRglCodeCaiss());
      var3.setRglCodeEmetrice(var1.getRglCodeEmetrice());
      var3.setRglCodePosteTreso(var1.getRglCodePosteTreso());
      var3.setRglCodeReceptrice(var1.getRglCodeReceptrice());
      var3.setRglCommission(var1.getRglCommission());
      var3.setRglDateCloture(var1.getRglDateCloture());
      var3.setRglDateCreation(new Date());
      var3.setRglDateEncaissement(var1.getRglDateEncaissement());
      var3.setRglDateExecBc(var1.getRglDateExecBc());
      var3.setRglDateImp((Date)null);
      var3.setRglDateModif((Date)null);
      var3.setRglDateMvt1(var1.getRglDateMvt1());
      var3.setRglDateMvt2(var1.getRglDateMvt2());
      var3.setRglDateReg(var1.getRglDateReg());
      var3.setRglDateRejet(var1.getRglDateRejet());
      var3.setRglDateTransfert((Date)null);
      var3.setRglDateValeur(var1.getRglDateValeur());
      var3.setRglDepartement(var1.getRglDepartement());
      var3.setRglDepense(var1.getRglDepense() * -1.0D);
      var3.setRglDepotTiers(var1.getRglDepotTiers());
      var3.setRglDevise(var1.getRglDevise());
      var3.setRglDocument(var1.getRglDocument());
      var3.setRglDossier(var1.getRglDossier());
      var3.setRglFormatDevise(var1.getRglFormatDevise());
      var3.setRglFrais(var1.getRglFrais() * -1.0D);
      var3.setRglIdBon(var1.getRglIdBon());
      var3.setRglIdCaissier(var1.getRglIdCaissier());
      var3.setRglIdCommercial(var1.getRglIdCommercial());
      var3.setRglIdContact(var1.getRglIdContact());
      var3.setRglIdDocument(var1.getRglIdDocument());
      var3.setRglIdEquipe(var1.getRglIdEquipe());
      var3.setRglIdResponsable(var1.getRglIdResponsable());
      var3.setRglIdTiers(var1.getRglIdTiers());
      var3.setRglImp(var1.getRglImp());
      var3.setRglInfo1(var1.getRglInfo1());
      var3.setRglInfo2(var1.getRglInfo2());
      var3.setRglInfo3(var1.getRglInfo3());
      var3.setRglInfo4(var1.getRglInfo4());
      var3.setRglInfo5(var1.getRglInfo5());
      var3.setRglInfo6(var1.getRglInfo6());
      var3.setRglInfo7(var1.getRglInfo7());
      var3.setRglInfo8(var1.getRglInfo8());
      var3.setRglInfo9(var1.getRglInfo9());
      var3.setRglInfo10(var1.getRglInfo10());
      var3.setRglLibCaiss(var1.getRglLibCaiss());
      var3.setRglLibEmetrice(var1.getRglLibEmetrice());
      var3.setRglLibReceptrice(var1.getRglLibReceptrice());
      var3.setRglLibTypReg(var1.getRglLibTypReg());
      var3.setRglLibelle(var1.getRglLibelle());
      var3.setRglMode(var1.getRglMode());
      var3.setRglModele(var1.getRglModele());
      var3.setRglNatureDoc(var1.getRglNatureDoc());
      var3.setRglNomCaissier(var1.getRglNomCaissier());
      var3.setRglNomCommercial(var1.getRglNomCommercial());
      var3.setRglNomContact(var1.getRglNomContact());
      var3.setRglNomEquipe(var1.getRglNomEquipe());
      var3.setRglNomResponsable(var1.getRglNomResponsable());
      var3.setRglNomTiers(var1.getRglNomTiers());
      var3.setRglNum(var1.getRglNum());
      var3.setRglNumChqBdx(var1.getRglNumChqBdx());
      var3.setRglNumMvt1(var1.getRglNumMvt1());
      var3.setRglNumMvt2(var1.getRglNumMvt2());
      var3.setRglNumTrf(var1.getRglNumTrf());
      var3.setRglObjet(var1.getRglObjet());
      var3.setRglOperation(var1.getRglOperation());
      var3.setRglP1(var1.getRglP1());
      var3.setRglP10(var1.getRglP10());
      var3.setRglP2(var1.getRglP2());
      var3.setRglP3(var1.getRglP3());
      var3.setRglP4(var1.getRglP4());
      var3.setRglP5(var1.getRglP5());
      var3.setRglP6(var1.getRglP6());
      var3.setRglP7(var1.getRglP7());
      var3.setRglP8(var1.getRglP8());
      var3.setRglP9(var1.getRglP9());
      var3.setRglParc(var1.getRglParc());
      var3.setRglPdv(var1.getRglPdv());
      var3.setRglPeriode(var1.getRglPeriode());
      var3.setRglRecette(var1.getRglRecette() * -1.0D);
      var3.setRglRegion(var1.getRglRegion());
      var3.setRglRendu(var1.getRglRendu());
      var3.setRglSecteur(var1.getRglSecteur());
      var3.setRglSerie(var1.getRglSerie());
      var3.setRglService(var1.getRglService());
      var3.setRglSite(var1.getRglSite());
      var3.setRglTimbre(var1.getRglTimbre() * -1.0D);
      var3.setRglTrf(0);
      var3.setRglTypeReg(var1.getRglTypeReg());
      var3.setRglTypeTiers(var1.getRglTypeTiers());
      var3.setRglUserCreat(var1.getRglUserCreat());
      var3.setRglUserModif(0L);
      var3.setExercicesCaisse(var1.getExercicesCaisse());
      var2.save(var3);
      return var1;
   }

   public void delet(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
      Transaction var4 = var3.beginTransaction();
      var4.begin();
      Query var5 = var3.createQuery("delete from Reglements where rglId =:Sid");
      var5.setParameter("Sid", var1);
      var5.executeUpdate();
      var4.commit();
      this.utilInitHibernate.closeSession();
   }

   public void delet(long var1, Session var3) {
      Query var4 = var3.createQuery("delete from Reglements where rglId =:Sid");
      var4.setParameter("Sid", var1);
      var4.executeUpdate();
   }

   public void delete(Reglements var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
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

   public void delete(Reglements var1, Session var2) {
      var2.delete(var1);
   }

   public List selectFind(String var1, String var2, List var3, String var4, String var5, String var6, String var7, String var8, int var9, long var10, int var12, List var13, List var14, double var15, Session var17) throws HibernateException, NamingException, ParseException {
      boolean var18 = false;
      if (var17 == null) {
         var17 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var18 = true;
      }

      new ArrayList();
      UtilDate var20 = new UtilDate();
      Date var21 = var20.stringToDateSQL(var7 + " 00:00:00");
      Date var22 = var20.stringToDateSQL(var8 + " 23:59:59");
      Criteria var23 = var17.createCriteria(Reglements.class);
      var23 = var23.add(Restrictions.between("rglDateReg", var21, var22));
      var23 = var23.add(Restrictions.ne("rglDepotTiers", 2));
      if (!var1.equals("100")) {
         if (var1.equals("200")) {
            var23 = var23.add(Restrictions.ne("rglRecette", 0.0D));
         } else if (var1.equals("201")) {
            var23 = var23.add(Restrictions.ne("rglDepense", 0.0D));
         } else if (var1.equals("202")) {
            var23 = var23.add(Restrictions.eq("rglOperation", "81"));
         } else if (var1.equals("203")) {
            var23 = var23.add(Restrictions.eq("rglOperation", "83"));
         } else if (var1.equals("204")) {
            var23 = var23.add(Restrictions.eq("rglTypeReg", 1));
            var23 = var23.add(Restrictions.or(Restrictions.between("rglDateMvt1", var21, var22), Restrictions.between("rglDateMvt2", var21, var22)));
            var23 = var23.add(Restrictions.and(Restrictions.isNull("rglDateEncaissement"), Restrictions.isNull("rglDateRejet")));
         } else if (var1.equals("205")) {
            var23 = var23.add(Restrictions.or(Restrictions.between("rglDateMvt1", var21, var22), Restrictions.between("rglDateMvt2", var21, var22)));
            var23 = var23.add(Restrictions.eq("rglTypeReg", 1));
            var23 = var23.add(Restrictions.or(Restrictions.isNotNull("rglDateEncaissement"), Restrictions.isNotNull("rglDateRejet")));
         } else if (var1.equals("206")) {
            var23 = var23.add(Restrictions.eq("rglOperation", "85"));
         } else if (var1.contains(":")) {
            String[] var24 = var1.split(":");
            if (var24[0].equals("0")) {
               var23 = var23.add(Restrictions.or(Restrictions.eq("rglMode", "0"), Restrictions.eq("rglMode", "11")));
            } else {
               var23 = var23.add(Restrictions.eq("rglMode", var24[0]));
            }
         } else {
            int var25 = Integer.parseInt(var1);
            var23 = var23.add(Restrictions.eq("rglCategorie", var25));
         }
      }

      if (!var2.equalsIgnoreCase("100")) {
         var23 = var23.add(Restrictions.or(Restrictions.eq("rglService", var2), Restrictions.eq("rglPdv", var2)));
      }

      if (var4 != null && !var4.isEmpty() && !var4.equalsIgnoreCase("100")) {
         var23 = var23.add(Restrictions.eq("rglCodeCaiss", var4));
      } else if (var3.size() != 0 && var9 != 2) {
         var23 = var23.add(Restrictions.or(Restrictions.in("rglCodeCaiss", var3), Restrictions.isNull("rglCodeCaiss")));
      }

      if (var9 != 0) {
         if (var9 == 1) {
            var23 = var23.add(Restrictions.eq("rglUserCreat", var10));
         } else if (var9 == 2 && var14.size() != 0) {
            var23 = var23.add(Restrictions.in("rglGrp", var14));
         }
      }

      if (var12 != 0 && var12 == 1 && var13.size() != 0) {
         var23 = var23.add(Restrictions.not(Restrictions.in("rglCodeCaiss", var13)));
      }

      if (var5 != null && !var5.isEmpty()) {
         var23 = var23.add(Restrictions.like("rglDocument", "%" + var5 + "%"));
      }

      if (var6 != null && !var6.isEmpty()) {
         var23 = var23.add(Restrictions.like("rglNum", "%" + var6 + "%"));
      }

      if (var15 != 0.0D) {
         var23 = var23.add(Restrictions.or(Restrictions.eq("rglRecette", var15), Restrictions.eq("rglDepense", var15)));
      }

      List var19 = var23.list();
      if (var18) {
         this.utilInitHibernate.closeSession();
      }

      return var19;
   }

   public Reglements selectById(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var4 = true;
      }

      Reglements var5 = new Reglements();
      Query var6 = var3.createQuery("from Reglements where rglId=:ident").setLong("ident", var1).setMaxResults(1);
      List var7 = var6.list();
      if (var7.size() > 0) {
         var5 = (Reglements)var7.get(0);
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheHistoDepot(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from Reglements  where rglIdTiers=:tt and (rglDepotTiers=1 or rglDepotTiers=2 or rglDepotTiers=3) order by rglDateReg desc").setLong("tt", var1);
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheHistoTiers(long var1, String var3, String var4, String var5, Session var6) throws HibernateException, NamingException {
      boolean var7 = false;
      if (var6 == null) {
         var6 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var7 = true;
      }

      new ArrayList();
      Query var9 = null;
      if (var5 != null && !var5.isEmpty()) {
         var9 = var6.createQuery("from Reglements  where (rglDepotTiers=0 or rglDepotTiers=3) and rglIdTiers=:tt and rglDateReg between '" + var3 + "' and '" + var4 + "' and (rglSerie in (" + var5 + ") or rglSerie is null or rglSerie = '') order by rglDateReg desc").setLong("tt", var1);
      } else {
         var9 = var6.createQuery("from Reglements  where (rglDepotTiers=0 or rglDepotTiers=3) and rglIdTiers=:tt and rglDateReg between '" + var3 + "' and '" + var4 + "' order by rglDateReg desc").setLong("tt", var1);
      }

      List var8 = var9.list();
      if (var7) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List rechercheHistoDestinataires(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var5 = true;
      }

      new ArrayList();
      Query var7 = var4.createQuery("from Reglements  where rglNomContact=:tt and rglDateReg between '" + var2 + "' and '" + var3 + "' order by rglDateReg desc").setString("tt", var1);
      List var6 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public long selectLastNum(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var2 = true;
      }

      Query var3 = var1.createQuery("from Reglements order by rglId desc").setMaxResults(1);
      if (var3.list() != null) {
         List var4 = var3.list();
         if (var4.size() > 0) {
            Reglements var5 = (Reglements)var4.get(0);
            long var6 = 1L + var5.getRglId();
            if (var2) {
               this.utilInitHibernate.closeSession();
            }

            return var6;
         } else {
            if (var2) {
               this.utilInitHibernate.closeSession();
            }

            return 1L;
         }
      } else {
         if (var2) {
            this.utilInitHibernate.closeSession();
         }

         return 1L;
      }
   }

   public List findRegByNatNum(int var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from Reglements  where rglDocument=:numero and rglNatureDoc=:nature order by rglDateReg desc").setParameter("nature", var1).setParameter("numero", var2);
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List findRegByNatRecu(int var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from Reglements  where rglNum=:numero and rglNatureDoc=:nature order by rglDateReg desc").setParameter("nature", var1).setParameter("numero", var2);
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public Reglements reglementBySerieAnneeDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      Reglements var8 = new Reglements();
      Query var9 = var5.createQuery("from Reglements where exercicesCaisse.execaiId=:id and rglSerie =:ser and year(rglDateReg)=" + var7 + " order by rglDateReg desc");
      var9.setParameter("id", var1);
      var9.setParameter("ser", var3);
      var9.setMaxResults(1);
      List var10 = var9.list();
      if (var10.size() > 0) {
         var8 = (Reglements)var10.get(0);
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public Reglements reglementBySerieMoisDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var6 = true;
      }

      new Reglements();
      int var8 = 1900 + var4.getYear();
      int var9 = var4.getMonth();
      Query var10 = var5.createQuery("from Reglements where exercicesCaisse.execaiId=:id and rglSerie =:ser and year(rglDateReg)=" + var8 + " and month(rglDateReg)=" + var9 + " order by rglDateReg desc");
      var10.setParameter("id", var1);
      var10.setParameter("ser", var3);
      var10.setMaxResults(1);
      List var11 = var10.list();
      Reglements var7;
      if (var11.size() > 0) {
         var7 = (Reglements)var11.get(0);
      } else {
         var7 = null;
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List rechercheRecu(Session var1, ExercicesCaisse var2, int var3, String var4, String var5, Date var6, Date var7) throws HibernateException, NamingException {
      boolean var8 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var8 = true;
      }

      new UtilDate();
      new ArrayList();
      Criteria var11 = var1.createCriteria(Reglements.class);
      var11 = var11.add(Restrictions.eq("exercicesCaisse", var2)).add(Restrictions.between("rglDateReg", var6, var7));
      if (var3 != 100) {
         var11 = var11.add(Restrictions.eq("rglCategorie", var3));
      }

      if (!var4.equalsIgnoreCase("100")) {
         String[] var12 = var4.split(":");
         String var13 = var12[0];
         var11 = var11.add(Restrictions.eq("rglCodeCaiss", var13));
      }

      if (!var5.equals("100")) {
         var11 = var11.add(Restrictions.eq("rglService", var5));
      }

      List var14 = var11.list();
      if (var8) {
         this.utilInitHibernate.closeSession();
      }

      return var14;
   }

   public Reglements pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var4 = true;
      }

      Query var5 = var3.createQuery("from Reglements where rglId =:num").setParameter("num", var1).setMaxResults(1);
      List var6 = var5.list();
      new Reglements();
      Reglements var7;
      if (var6.size() != 0) {
         var7 = (Reglements)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public Reglements pourParapheurByNumNat(String var1, int var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var4 = true;
      }

      Query var5 = var3.createQuery("from Reglements where rglNum =:num and rglNatureDoc =:nat").setString("num", var1).setInteger("nat", var2).setMaxResults(1);
      List var6 = var5.list();
      new Reglements();
      Reglements var7;
      if (var6.size() != 0) {
         var7 = (Reglements)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public Reglements pourParapheurByNumNatRistourne(long var1, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var5 = true;
      }

      Query var6 = var4.createQuery("from Reglements where rglIdDocument =:num and rglNatureDoc =:nat and rglDepotTiers = 2").setLong("num", var1).setInteger("nat", var3).setMaxResults(1);
      List var7 = var6.list();
      new Reglements();
      Reglements var8;
      if (var7.size() != 0) {
         var8 = (Reglements)var7.get(0);
      } else {
         var8 = null;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List reglementDocument(long var1, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var5 = true;
      }

      Query var6 = var4.createQuery("from Reglements where rglIdDocument=:num and rglNatureDoc=:nat and rglDepotTiers<>2 order by rglDateReg").setLong("num", var1).setInteger("nat", var3);
      List var7 = var6.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List reglementDocumentByRecu(String var1, int var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var4 = true;
      }

      Query var5 = var3.createQuery("from Reglements where rglNum in (" + var1 + ") and rglNatureDoc=:nat and rglDepotTiers<>2 order by rglDateReg").setInteger("nat", var2);
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List reglementJournalierAnterieur(String var1, String var2, String var3, Session var4) throws NamingException, ParseException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var5 = true;
      }

      UtilDate var6 = new UtilDate();
      new ArrayList();
      Criteria var8 = var4.createCriteria(Reglements.class);
      Date var9 = null;
      Date var10 = null;
      var9 = var6.stringToDateSQLLight(var2);
      var10 = var6.stringToDateSQLLight(var3);
      var8 = var8.add(Restrictions.eq("rglCaisse", var1));
      var8 = var8.add(Restrictions.between("rglDateReg", var9, var10));
      var8 = var8.add(Restrictions.ne("rglDepotTiers", 2));
      List var11 = var8.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var11;
   }

   public List reglementJournalier(String var1, Date var2, Session var3) throws HibernateException, NamingException, ParseException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var4 = true;
      }

      Query var5 = var3.createQuery("from Reglements where rglDateReg=:dte and (rglCle1=:cle or (rglCle3=:cle and (rglOperation='71' or rglOperation='73'))) and ((rglOperation<>'17' and rglOperation<>'27' and rglOperation<>'25') or rglOperation is null) and rglDepotTiers<>2").setString("cle", var1).setDate("dte", var2);
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List reglementJournalierBonCaisse(String var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var4 = true;
      }

      Query var5 = var3.createQuery("from Reglements where rglDateReg=:dte and rglImp=0 and rglCle1=:cle and rglOperation='25' and rglDepotTiers<>2").setString("cle", var1).setDate("dte", var2);
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List reglementJournalierEcart(String var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var4 = true;
      }

      Query var5 = var3.createQuery("from Reglements where rglDateReg=:dte and rglImp=0 and rglCle1=:cle and (rglOperation='17' or rglOperation='27') and rglDepotTiers<>2").setString("cle", var1).setDate("dte", var2);
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List reglementMensuel(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Reglements where rglCle1=:cle and ((rglOperation<>'17' and rglOperation<>'27' and rglOperation<>'25') or rglOperation is null) and rglDepotTiers<>2").setString("cle", var1);
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List reglementMensuelBonCaisse(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Reglements where rglCle1=:cle and rglImp=0 and rglOperation='25' and rglDepotTiers<>2").setString("cle", var1);
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List reglementMensuelEcart(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Reglements where rglCle1=:cle and rglImp=0 and (rglOperation='17' or rglOperation='27') and rglDepotTiers<>2").setString("cle", var1);
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheReglementATransfererCompta(String var1, String var2, String var3, String var4, String var5, int var6, int var7, boolean var8, Session var9) throws HibernateException, NamingException {
      boolean var10 = false;
      if (var9 == null) {
         var9 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var10 = true;
      }

      new ArrayList();
      List var12 = null;
      String var13 = "";
      if (var7 != 99) {
         var13 = " and rglTypeReg=" + var7;
      }

      if (var8) {
         if (var6 == 0) {
            if (var5 != null && !var5.isEmpty()) {
               var12 = var9.createQuery("from Reglements where rglTrf=0 and rglDepotTiers<>2 and rglCodeCaiss=:cai and rglDateTransfert is NULL" + var13).setString("cai", var5).list();
            } else {
               var12 = var9.createQuery("from Reglements where rglTrf=0 and rglDepotTiers<>2 and rglDateTransfert is NULL" + var13).list();
            }
         } else if (var5 != null && !var5.isEmpty()) {
            var12 = var9.createQuery("from Reglements where rglTrf=0 and rglDepotTiers<>2 and rglCodeCaiss=:cai and rglDateTransfert is NULL and (rglCategorie=:ope or rglNatureDoc=:ope)" + var13).setString("cai", var5).setInteger("ope", var6).list();
         } else {
            var12 = var9.createQuery("from Reglements where rglTrf=0 and rglDepotTiers<>2 and rglDateTransfert is NULL and (rglCategorie=:ope or rglNatureDoc=:ope)" + var13).setInteger("ope", var6).list();
         }
      } else if (var6 == 0) {
         if (var1 != null && !var1.isEmpty() && var2 != null && !var2.isEmpty()) {
            if (var5 != null && !var5.isEmpty()) {
               var12 = var9.createQuery("from Reglements where rglTrf=0 and rglDepotTiers<>2 and rglCodeCaiss=:cai and rglDateTransfert is NULL and rglDateReg>=:dte1 and rglDateReg<=:dte2 and rglNum>=:p1 and rglNum<=:p2" + var13).setString("dte1", var3).setString("dte2", var4).setString("p1", var1).setString("p2", var2).setString("cai", var5).list();
            } else {
               var12 = var9.createQuery("from Reglements where rglTrf=0 and rglDepotTiers<>2 and rglDateTransfert is NULL and rglDateReg>=:dte1 and rglDateReg<=:dte2 and rglNum>=:p1 and rglNum<=:p2" + var13).setString("dte1", var3).setString("dte2", var4).setString("p1", var1).setString("p2", var2).list();
            }
         } else if (var5 != null && !var5.isEmpty()) {
            var12 = var9.createQuery("from Reglements where rglTrf=0 and rglDepotTiers<>2 and rglCodeCaiss=:cai and rglDateTransfert is NULL and rglDateReg>=:dte1 and rglDateReg<=:dte2" + var13).setString("dte1", var3).setString("dte2", var4).setString("cai", var5).list();
         } else {
            var12 = var9.createQuery("from Reglements where rglTrf=0 and rglDepotTiers<>2 and rglDateTransfert is NULL and rglDateReg>=:dte1 and rglDateReg<=:dte2" + var13).setString("dte1", var3).setString("dte2", var4).list();
         }
      } else if (var1 != null && !var1.isEmpty() && var2 != null && !var2.isEmpty()) {
         if (var5 != null && !var5.isEmpty()) {
            var12 = var9.createQuery("from Reglements where rglTrf=0 and rglDepotTiers<>2 and rglCodeCaiss=:cai and rglDateTransfert is NULL and rglDateReg>=:dte1 and rglDateReg<=:dte2 and rglNum>=:p1 and rglNum<=:p2 and (rglCategorie=:ope or rglNatureDoc=:ope)" + var13).setString("dte1", var3).setString("dte2", var4).setString("p1", var1).setString("p2", var2).setString("cai", var5).setInteger("ope", var6).list();
         } else {
            var12 = var9.createQuery("from Reglements where rglTrf=0 and rglDepotTiers<>2 and rglDateTransfert is NULL and rglDateReg>=:dte1 and rglDateReg<=:dte2 and rglNum>=:p1 and rglNum<=:p2 and (rglCategorie=:ope or rglNatureDoc=:ope)" + var13).setString("dte1", var3).setString("dte2", var4).setString("p1", var1).setString("p2", var2).setInteger("ope", var6).list();
         }
      } else if (var5 != null && !var5.isEmpty()) {
         var12 = var9.createQuery("from Reglements where rglTrf=0 and rglDepotTiers<>2 and rglCodeCaiss=:cai and rglDateTransfert is NULL and rglDateReg>=:dte1 and rglDateReg<=:dte2 and (rglCategorie=:ope or rglNatureDoc=:ope)" + var13).setString("dte1", var3).setString("dte2", var4).setString("cai", var5).setInteger("ope", var6).list();
      } else {
         var12 = var9.createQuery("from Reglements where rglTrf=0 and rglDepotTiers<>2 and rglDateTransfert is NULL and rglDateReg>=:dte1 and rglDateReg<=:dte2 and (rglCategorie=:ope or rglNatureDoc=:ope)" + var13).setString("dte1", var3).setString("dte2", var4).setInteger("ope", var6).list();
      }

      if (var10) {
         this.utilInitHibernate.closeSession();
      }

      return var12;
   }

   public List rechercheReglementDejaTransfererCompta(Date var1, Date var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var5 = true;
      }

      new ArrayList();
      List var7 = var4.createQuery("from Reglements where rglTrf=0 and rglDepotTiers<>2 and rglDateTransfert is not NULL and rglDateReg>=:dte1 and rglDateReg<=:dte2 and rglCodeCaiss=:cai").setDate("dte1", var1).setDate("dte2", var2).setString("cai", var3).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List calculSoldeAnterieurEspeceCheque(String var1, Date var2, Date var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var5 = true;
      }

      new ArrayList();
      Query var7 = var4.createQuery("from Reglements where rglCodeCaiss=:cais and rglImp=0 and rglDateReg>:d1 and rglDateReg<:d2 and (rglTypeReg=0 or rglTypeReg=1 or rglTypeReg=11) and rglDepotTiers<>2").setString("cais", var1).setDate("d1", var2).setDate("d2", var3);
      List var6 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List calculToutSoldeAnterieur(String var1, Date var2, Date var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var5 = true;
      }

      new ArrayList();
      Query var7 = var4.createQuery("from Reglements where (rglCodeCaiss=:cais or (rglCodeReceptrice=:cais and (rglOperation='71' or rglOperation='73'))) and rglImp=0 and rglDateReg>:d1 and rglDateReg<:d2 and rglDepotTiers<>2").setString("cais", var1).setDate("d1", var2).setDate("d2", var3);
      List var6 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheVrtCaisseBnq(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var2 = true;
      }

      new ArrayList();
      List var4 = var1.createQuery("from Reglements where (rglCodeCaiss<>'' or rglCodeCaiss is not NULL) and (rglCodeEmetrice='' or rglCodeEmetrice is NULL) and (rglCodeReceptrice<>'' or rglCodeReceptrice is not NULL) and rglDepotTiers<>2").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List rechercheRecu(ExercicesCaisse var1, String var2, Date var3, Date var4, String var5, int var6, String[] var7) throws HibernateException, NamingException {
      new ArrayList();
      Session var9 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
      new Date();
      Calendar var11 = Calendar.getInstance();
      var11.setTime(var4);
      var11.add(5, 1);
      Date var10 = var11.getTime();
      Criteria var12 = var9.createCriteria(Reglements.class);
      var12 = var12.add(Restrictions.between("rglDateReg", var3, var10)).add(Restrictions.eq("exercicesCaisse", var1));
      var12 = var12.add(Restrictions.ne("rglDepotTiers", 2));
      if (var6 != 100) {
         var12 = var12.add(Restrictions.eq("rglCategorie", var6));
      }

      if (!var5.equalsIgnoreCase("100")) {
         var12 = var12.add(Restrictions.eq("rglService", var5));
      }

      if (!var2.equalsIgnoreCase("100")) {
         String[] var13 = var2.split(":");
         String var14 = var13[0];
         var12 = var12.add(Restrictions.eq("rglCodeCaiss", var14));
      }

      List var8 = var12.list();
      this.utilInitHibernate.closeSession();
      return var8;
   }

   public List chargeChequeCaisseCaisse(String var1, Date var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var5 = true;
      }

      String[] var6 = var1.split(":");
      Query var7 = var4.createQuery("from Reglements where rglCodeCaiss=:c1 and rglTypeReg=1 and rglDateReg<=:d2 and rglRecette<>0 and (rglDateMvt1 is null or (rglDateMvt1 is not null and rglNumMvt1=:b1)) and rglDepotTiers<>2 order by rglDateReg").setString("c1", var6[0]).setDate("d2", var2).setString("b1", var3);
      List var8 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List chargeChequeCaisseBanque(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var5 = true;
      }

      String var6 = "";
      String[] var7;
      if (var1.contains(":")) {
         var7 = var1.split(":");
         var6 = var7[0];
      } else {
         var6 = var1;
      }

      var7 = null;
      Query var9;
      if (var3 != null) {
         var9 = var4.createQuery("from Reglements where (rglCodeCaiss=:c1 or rglCaisseMvt1=:c1) and rglTypeReg=1 and (rglDateReg<=:d2 or rglDateMvt1<=:d2) and rglRecette<>0 and (rglDateMvt2 is null or (rglDateMvt2 is not null and rglNumMvt2=:b1)) and rglDepotTiers<>2 order by rglDateReg").setString("c1", var6).setString("d2", var2).setString("b1", var3);
      } else {
         var9 = var4.createQuery("from Reglements where (rglCodeCaiss=:c1 or rglCaisseMvt1=:c1) and rglTypeReg=1 and (rglDateReg<=:d2 or rglDateMvt1<=:d2) and rglRecette<>0 and rglDateMvt2 is null and rglDepotTiers<>2 order by rglDateReg").setString("c1", var6).setString("d2", var2);
      }

      List var8 = var9.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List chargeChequeCaisseImpression(long var1, String var3, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var6 = true;
      }

      String[] var7 = var3.split(":");
      Query var8 = var5.createQuery("from Reglements where rglCodeCaiss=:c1 and rglTypeReg=1 and rglNumMvt1=:b1 and rglDepotTiers<>2 and exercicesCaisse.execai_id=:exo order by rglDateReg").setString("c1", var7[0]).setString("b1", var4).setLong("exo", var1);
      List var9 = var8.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public List chargeChequeBanqueImpression(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var4 = true;
      }

      Query var5 = var3.createQuery("from Reglements where rglTypeReg=1 and rglNumMvt2=:b1 and rglDepotTiers<>2 order by rglDateReg").setString("b1", var2);
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargeEffetCaisseCaisse(String var1, Date var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var5 = true;
      }

      String[] var6 = var1.split(":");
      Query var7 = var4.createQuery("from Reglements where rglCodeCaiss=:c1 and rglTypeReg=3 and rglDateReg<=:d2 and (rglDateMvt1 is null or (rglDateMvt1 is not null and rglNumMvt1=:b1)) and rglDepotTiers<>2 order by rglDateReg").setString("c1", var6[0]).setDate("d2", var2).setString("b1", var3);
      List var8 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List chargeEffetCaisseBanque(String var1, Date var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var5 = true;
      }

      String[] var6 = var1.split(":");
      Query var7 = var4.createQuery("from Reglements where rglCodeCaiss=:c1 and rglTypeReg=3 and rglDateReg<=:d2 and (rglDateMvt2 is null or (rglDateMvt2 is not null and rglNumMvt2=:b1)) and rglDepotTiers<>2 order by rglDateReg").setString("c1", var6[0]).setDate("d2", var2).setString("b1", var3);
      List var8 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List chargeEffetCaisseImpression(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var4 = true;
      }

      String[] var5 = var1.split(":");
      Query var6 = var3.createQuery("from Reglements where rglCodeCaiss=:c1 and rglTypeReg=3 and rglNumMvt1=:b1 and rglDepotTiers<>2 order by rglDateReg").setString("c1", var5[0]).setString("b1", var2);
      List var7 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargeEffetBanqueImpression(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var4 = true;
      }

      String[] var5 = var1.split(":");
      Query var6 = var3.createQuery("from Reglements where rglCodeCaiss=:c1 and rglTypeReg=3 and rglNumMvt2=:b1 and rglDepotTiers<>2 order by rglDateReg").setString("c1", var5[0]).setString("b1", var2);
      List var7 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargeBonCaisseDisponible(String var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var4 = true;
      }

      if (var2 == null) {
         var2 = new Date();
      }

      String[] var5 = var1.split(":");
      Query var6 = var3.createQuery("from Reglements where rglCodeCaiss=:c1 and rglOperation=25 and rglDateReg<=:d1 and rglDateExecBc is null and rglDepotTiers<>2 order by rglDateReg").setString("c1", var5[0]).setDate("d1", var2);
      List var7 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargeRegulCaisseDisponibleRecette(String var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var4 = true;
      }

      if (var2 == null) {
         var2 = new Date();
      }

      String[] var5 = var1.split(":");
      Query var6 = var3.createQuery("from Reglements where rglCodeCaiss=:c1 and rglOperation=17 and rglDateReg<=:d1 and rglDateExecBc is null and rglDepotTiers<>2 order by rglDateReg").setString("c1", var5[0]).setDate("d1", var2);
      List var7 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargeRegulCaisseDisponibleDepense(String var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var4 = true;
      }

      if (var2 == null) {
         var2 = new Date();
      }

      String[] var5 = var1.split(":");
      Query var6 = var3.createQuery("from Reglements where rglCodeCaiss=:c1 and rglOperation=27 and rglDateReg<=:d1 and rglDateExecBc is null and rglDepotTiers<>2 order by rglDateReg").setString("c1", var5[0]).setDate("d1", var2);
      List var7 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargeChequeClient(String var1, long var2, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var5 = true;
      }

      Query var6 = null;
      if (var1 != null && !var1.isEmpty()) {
         if (var1.equals("*")) {
            var6 = var4.createQuery("from Reglements where rglRecette!=0 and rglTypeReg=1 and (rglNatureDoc>=21 and rglNatureDoc<=28) and rglDepotTiers<>2 order by rglDateReg");
         } else {
            var6 = var4.createQuery("from Reglements where rglRecette!=0 and rglTypeReg=1 and (rglNatureDoc>=21 and rglNatureDoc<=28) and (rglNumChqBdx like '" + var1 + "%' or rglNomTiers like '%" + var1 + "%' ) and rglDepotTiers<>2 order by rglDateReg");
         }
      }

      new ArrayList();
      List var7 = var6.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargeChequeImpayesClient(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var4 = true;
      }

      Query var5 = var3.createQuery("from Reglements where rglIdTiers=" + var1 + " and rglRecette<0 and rglTypeReg=1 and ((rglNatureDoc>=11 and rglNatureDoc<=18) or (rglNatureDoc>=21 and rglNatureDoc<=28)) and rglOperation='19' and rglDepotTiers<>2 order by rglDateReg");
      new ArrayList();
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheReglementsRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from Reglements where " + var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List rechercheCommissions(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      boolean var5 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var5 = true;
      }

      List var6 = var3.createQuery("from Reglements where rglDateReg>=:d1 and rglDateReg<=:d2 and rglCategorie = 20 and rglDepotTiers<>2").setDate("d1", var1).setDate("d2", var2).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheByTiersClient(Tiers var1, int var2, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      boolean var5 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var5 = true;
      }

      List var6 = null;
      if (var2 == 0) {
         var6 = var3.createQuery("from Reglements where rglIdTiers=:tie and rglTypeTiers>=0 and rglTypeTiers<=3 and rglDepotTiers<>2").setLong("tie", var1.getTieid()).list();
      } else {
         var6 = var3.createQuery("from Reglements where rglIdTiers=:tie and rglTypeTiers>=0 and rglTypeTiers<=3 and (rglDepotTiers=0 or rglDepotTiers=3) and rglDepotTiers<>2").setLong("tie", var1.getTieid()).list();
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheByTiersFournisseur(Tiers var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var4 = true;
      }

      List var5 = var2.createQuery("from Reglements where rglIdTiers=:tie and rglTypeTiers=0 and rglDepotTiers<>2").setLong("tie", var1.getTieid()).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheByTiersPatient(Patients var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var4 = true;
      }

      List var5 = var2.createQuery("from Reglements where rglIdTiers=:tie and rglTypeTiers=4 and rglDepotTiers<>2").setLong("tie", var1.getPatId()).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheByTiersEleve(Eleves var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var4 = true;
      }

      List var5 = var2.createQuery("from Reglements where rglIdTiers=:tie and rglTypeTiers=5 and rglDepotTiers<>2").setLong("tie", var1.getEleId()).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheByTiersEleve(Eleves var1, long var2, Session var4) throws HibernateException, NamingException {
      new ArrayList();
      boolean var6 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var6 = true;
      }

      List var7 = var4.createQuery("from Reglements where rglIdTiers=:tie and rglTypeTiers=5 and rglDepotTiers<>2 and rglIdDocument=:doc").setLong("tie", var1.getEleId()).setLong("doc", var2).list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargeRecuByNum(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var4 = true;
      }

      Query var5 = var3.createQuery("from Reglements where rglNum=:b1  and rglCodeCaiss=:cai and rglDepotTiers<>2 order by rglDateReg").setString("b1", var1).setString("cai", var2);
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargeRecuByNum(String var1, String var2, int var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var6 = true;
      }

      Query var7 = null;
      if (var2 != null && !var2.isEmpty()) {
         var7 = var5.createQuery("from Reglements where rglNum=:b1 and rglNatureDoc=:nat and rglDateReg=:dte and rglCodeCaiss=:cai and rglDepotTiers<>2 order by rglDateReg").setString("b1", var1).setInteger("nat", var3).setDate("dte", var4).setString("cai", var2);
      } else {
         var7 = var5.createQuery("from Reglements where rglNum=:b1 and rglNatureDoc=:nat and rglDateReg=:dte and rglDepotTiers<>2 order by rglDateReg").setString("b1", var1).setInteger("nat", var3).setDate("dte", var4);
      }

      List var8 = var7.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List chargeRecuByNum(String var1, int var2, Date var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var5 = true;
      }

      Query var6 = var4.createQuery("from Reglements where rglNum=:b1 and rglNatureDoc=:nat and rglDateReg=:dte and rglDepotTiers<>2 order by rglDateReg").setString("b1", var1).setInteger("nat", var2).setDate("dte", var3);
      List var7 = var6.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargeRecuByLettreGarantie(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Reglements where rglNumChqBdx=:b1 and rglMode=12").setString("b1", var1);
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargeDepositClientFree(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var4 = true;
      }

      Query var5 = var3.createQuery("from Reglements where rglIdTiers=" + var1 + " and rglDepotTiers=1 and rglIdDocument=0 order by rglDateReg");
      new ArrayList();
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargeDepositClient(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var4 = true;
      }

      Query var5 = var3.createQuery("from Reglements where rglIdTiers=" + var1 + " and rglDepotTiers=1 order by rglDateReg");
      new ArrayList();
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargeDepositClient(long var1, Date var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var6 = true;
      }

      Query var7 = null;
      if (var3 != null && var4 != null) {
         var7 = var5.createQuery("from Reglements where rglDateReg>=:d1 and rglDateReg<=:d2 and rglIdTiers=" + var1 + " and rglDepotTiers=1 order by rglDateReg").setDate("d1", var3).setDate("d2", var4);
      } else {
         var7 = var5.createQuery("from Reglements where rglIdTiers=" + var1 + " and rglDepotTiers=1 order by rglDateReg");
      }

      new ArrayList();
      List var8 = var7.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List chargeReglementPatient(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var4 = true;
      }

      Query var5 = var3.createQuery("from Reglements where rglIdTiers=" + var1 + " and rglTypeTiers=4 order by rglDateReg");
      new ArrayList();
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheRecu(Session var1) throws HibernateException, NamingException {
      new ArrayList();
      Criteria var3 = var1.createCriteria(Reglements.class);
      var3 = var3.add(Restrictions.or(Restrictions.isNull("rglNum"), Restrictions.eq("rglNum", "")));
      var3 = var3.add(Restrictions.eq("rglDepotTiers", 0));
      List var2 = var3.list();
      return var2;
   }

   public List rechercheTousRecus(Session var1) throws HibernateException, NamingException {
      new ArrayList();
      Criteria var3 = var1.createCriteria(Reglements.class);
      var3 = var3.add(Restrictions.ne("rglId", 0L));
      List var2 = var3.list();
      return var2;
   }

   public List rechercheRecus(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from Reglements  where rglDateReg >= '" + var1 + "' and rglDateReg <='" + var2 + "' order by rglDateReg desc");
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheRecusDeposits(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from Reglements  where rglDateReg >= '" + var1 + "' and rglDateReg <='" + var2 + "' and (rglDepotTiers=1 or rglDepotTiers=3) order by rglDateReg desc");
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheRecusRistournes(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from Reglements  where rglDateReg >= '" + var1 + "' and rglDateReg <='" + var2 + "' and (rglDepotTiers=2 or rglDepotTiers=3) order by rglDateReg desc");
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheTresoReporting(Session var1, int var2, int var3, String var4, String var5, String var6, Date var7, Date var8, boolean var9, int var10, List var11, List var12, List var13, List var14, List var15, List var16, List var17, List var18, List var19, List var20) throws HibernateException, NamingException {
      boolean var21 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var21 = true;
      }

      new ArrayList();
      Criteria var23 = var1.createCriteria(Reglements.class);
      var23 = var23.add(Restrictions.ne("rglOperation", "71"));
      var23 = var23.add(Restrictions.ne("rglOperation", "73"));
      var23 = var23.add(Restrictions.ne("rglOperation", "74"));
      var23 = var23.add(Restrictions.ne("rglOperation", "75"));
      var23 = var23.add(Restrictions.ne("rglOperation", "76"));
      var23 = var23.add(Restrictions.ne("rglOperation", "77"));
      var23 = var23.add(Restrictions.ne("rglOperation", "78"));
      var23 = var23.add(Restrictions.ne("rglOperation", "79"));
      var23 = var23.add(Restrictions.ne("rglOperation", "80"));
      var23 = var23.add(Restrictions.ne("rglOperation", "81"));
      var23 = var23.add(Restrictions.ne("rglOperation", "82"));
      var23 = var23.add(Restrictions.ne("rglOperation", "83"));
      var23 = var23.add(Restrictions.ne("rglOperation", "84"));
      var23 = var23.add(Restrictions.ne("rglOperation", "85"));
      if (var4 != null && !var4.isEmpty()) {
         var23 = var23.add(Restrictions.eq("rglCodeCaiss", var4));
      } else if (var5 != null && !var5.isEmpty()) {
         var23 = var23.add(Restrictions.eq("rglCodeEmetrice", var5));
      } else if (var6 != null && !var6.isEmpty()) {
         var23 = var23.add(Restrictions.eq("rglCodeReceptrice", var6));
      }

      var23 = var23.add(Restrictions.between("rglDateReg", var7, var8));
      if (var10 == 0) {
         var23 = var23.add(Restrictions.or(Restrictions.eq("rglTypeReg", 0), Restrictions.eq("rglTypeReg", 11)));
      } else if (var10 >= 1 && var10 <= 20) {
         var23 = var23.add(Restrictions.and(Restrictions.eq("rglTypeReg", var10), Restrictions.ne("rglTypeReg", 9)));
      }

      if (var2 != 99) {
         var23 = var23.add(Restrictions.eq("rglNatureDoc", var2));
      }

      if (var3 != 99) {
         var23 = var23.add(Restrictions.eq("rglCategorie", var3));
      }

      if (var9) {
         if (var12.size() != 0 && ((String)var12.get(0)).equals("[*]")) {
            var23 = var23.add(Restrictions.in("rglActivite", var12));
         }

         if (var13.size() != 0 && ((String)var13.get(0)).equals("[*]")) {
            var23 = var23.add(Restrictions.in("rglActivite", var13));
         }

         if (var14.size() != 0 && ((String)var14.get(0)).equals("[*]")) {
            var23 = var23.add(Restrictions.in("rglActivite", var14));
         }
      } else if (var11.size() != 0 && ((String)var11.get(0)).equals("[*]")) {
         var23 = var23.add(Restrictions.in("rglActivite", var11));
      }

      if (var15.size() != 0) {
         var23 = var23.add(Restrictions.in("rglSite", var15));
      }

      if (var16.size() != 0) {
         var23 = var23.add(Restrictions.in("rglDepartement", var16));
      }

      if (var17.size() != 0) {
         var23 = var23.add(Restrictions.in("rglService", var17));
      }

      if (var18.size() != 0) {
         var23 = var23.add(Restrictions.in("rglRegion", var18));
      }

      if (var19.size() != 0) {
         var23 = var23.add(Restrictions.in("rglSecteur", var19));
      }

      if (var20.size() != 0) {
         var23 = var23.add(Restrictions.in("rglPdv", var20));
      }

      List var24 = var23.list();
      if (var21) {
         this.utilInitHibernate.closeSession();
      }

      return var24;
   }

   public List rechercheReglementCampagne(String var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Reglements");
         var4 = true;
      }

      List var5 = var2.createQuery("from Reglements where rglSource like '" + var1 + "%'").list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
