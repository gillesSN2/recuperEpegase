package com.epegase.systeme.dao;

import com.epegase.systeme.classe.CptTabNom;
import com.epegase.systeme.classe.PegTabNom;
import com.epegase.systeme.control.EtatFinancier;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CptTabNomDao implements Serializable {
   private CptTabNom cptTabNom;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public CptTabNomDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public CptTabNom insertTableau(CptTabNom var1, String var2) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.maBase, "CptTabNom");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         var1.setTablisZone(var2);
         var1.setTablisType(1);
         var1.setTablisModif(0);
         var3.save(var1);
         var4.commit();
      } catch (HibernateException var9) {
         if (var4 != null) {
            var4.rollback();
         }

         throw var9;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var1;
   }

   public CptTabNom modifTableau(CptTabNom var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "CptTabNom");
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

   public List savePegtabNom(List var1, Session var2) throws HibernateException, NamingException {
      ArrayList var3 = new ArrayList();
      var2 = this.utilInitHibernate.getOpenSession(this.maBase, "CptTabNom");
      Transaction var4 = null;

      try {
         var4 = var2.beginTransaction();

         for(int var5 = 0; var5 < var1.size(); ++var5) {
            CptTabNom var6 = new CptTabNom();
            new PegTabNom();
            PegTabNom var7 = (PegTabNom)var1.get(var5);
            var6.setTablisOldId(var7.getTablis_id());
            var6.setTablisZone(var7.getTablisZone());
            var6.setTablisType(var7.getTablisType());
            var6.setTablisModif(var7.getTablisModif());
            var6.setTablisNum(var7.getTablisNum());
            var6.setTablisCode(var7.getTablisCode());
            var6.setTablisLibFR(var7.getTablisLibFR());
            var6.setTablisLibUK(var7.getTablisLibUK());
            var6.setTablisLibSP(var7.getTablisLibSP());
            var6.setTablisModele(var7.getTablisModele());
            var6.setTablisNbCol(var7.getTablisNbCol());
            var6.setTablisAnn01(var7.getTablisAnn01());
            var6.setTablisAnn02(var7.getTablisAnn02());
            var6.setTablisAnn02(var7.getTablisAnn02());
            var6.setTablisAnn03(var7.getTablisAnn03());
            var6.setTablisAnn04(var7.getTablisAnn04());
            var6.setTablisAnn05(var7.getTablisAnn05());
            var6.setTablisAnn06(var7.getTablisAnn06());
            var6.setTablisAnn07(var7.getTablisAnn07());
            var6.setTablisAnn08(var7.getTablisAnn08());
            var6.setTablisAnn09(var7.getTablisAnn09());
            var6.setTablisAnn10(var7.getTablisAnn10());
            var6.setTablisAnn10(var7.getTablisAnn11());
            var6.setTablisAnn10(var7.getTablisAnn12());
            var6.setTablisAnn10(var7.getTablisAnn13());
            var6.setTablisAnn10(var7.getTablisAnn14());
            var6.setTablisAnn10(var7.getTablisAnn15());
            var6.setTablisAnn10(var7.getTablisAnn16());
            var6.setTablisAnn10(var7.getTablisAnn17());
            var6.setTablisAnn10(var7.getTablisAnn18());
            var6.setTablisAnn10(var7.getTablisAnn19());
            var6.setTablisAnn10(var7.getTablisAnn20());
            var6.setTablisNom01(var7.getTablisNom01());
            var6.setTablisNom02(var7.getTablisNom02());
            var6.setTablisNom03(var7.getTablisNom03());
            var6.setTablisNom04(var7.getTablisNom04());
            var6.setTablisNom05(var7.getTablisNom05());
            var6.setTablisNom06(var7.getTablisNom06());
            var6.setTablisNom07(var7.getTablisNom07());
            var6.setTablisNom08(var7.getTablisNom08());
            var6.setTablisNom09(var7.getTablisNom09());
            var6.setTablisNom10(var7.getTablisNom10());
            var6.setTablisNom11(var7.getTablisNom11());
            var6.setTablisNom12(var7.getTablisNom12());
            var6.setTablisNom13(var7.getTablisNom13());
            var6.setTablisNom14(var7.getTablisNom14());
            var6.setTablisNom15(var7.getTablisNom15());
            var6.setTablisNom16(var7.getTablisNom16());
            var6.setTablisNom17(var7.getTablisNom17());
            var6.setTablisNom18(var7.getTablisNom18());
            var6.setTablisNom19(var7.getTablisNom19());
            var6.setTablisNom20(var7.getTablisNom20());
            var6.setTablisTypeCol01(var7.getTablisTypeCol01());
            var6.setTablisTypeCol02(var7.getTablisTypeCol02());
            var6.setTablisTypeCol03(var7.getTablisTypeCol03());
            var6.setTablisTypeCol04(var7.getTablisTypeCol04());
            var6.setTablisTypeCol05(var7.getTablisTypeCol05());
            var6.setTablisTypeCol06(var7.getTablisTypeCol06());
            var6.setTablisTypeCol07(var7.getTablisTypeCol07());
            var6.setTablisTypeCol08(var7.getTablisTypeCol08());
            var6.setTablisTypeCol09(var7.getTablisTypeCol09());
            var6.setTablisTypeCol10(var7.getTablisTypeCol10());
            var6.setTablisTypeCol11(var7.getTablisTypeCol11());
            var6.setTablisTypeCol12(var7.getTablisTypeCol12());
            var6.setTablisTypeCol13(var7.getTablisTypeCol13());
            var6.setTablisTypeCol14(var7.getTablisTypeCol14());
            var6.setTablisTypeCol15(var7.getTablisTypeCol15());
            var6.setTablisTypeCol16(var7.getTablisTypeCol16());
            var6.setTablisTypeCol17(var7.getTablisTypeCol17());
            var6.setTablisTypeCol18(var7.getTablisTypeCol18());
            var6.setTablisTypeCol19(var7.getTablisTypeCol19());
            var6.setTablisTypeCol20(var7.getTablisTypeCol20());
            var6.setTablisAnneeAnte(var7.getTablisAnneeAnte());
            var2.save(var6);
            var3.add(var6);
         }

         var4.commit();
         return var3;
      } catch (HibernateException var11) {
         if (var4 != null) {
            var4.rollback();
         }

         throw var11;
      } finally {
         this.utilInitHibernate.closeSession();
      }
   }

   public EtatFinancier updateCpttabNomCol(int var1, EtatFinancier var2, CptTabNom var3) throws HibernateException, NamingException {
      Session var4 = this.utilInitHibernate.getOpenSession(this.maBase, "CptTabNom");
      Transaction var5 = null;

      try {
         var5 = var4.beginTransaction();
         if (var1 == 1) {
            var3.setTablisAnn01(var2.getPeriodeCol());
            var3.setTablisNom01(var2.getNomCol());
            var3.setTablisTypeCol01(var2.getTypeCol());
         } else if (var1 == 2) {
            var3.setTablisAnn02(var2.getPeriodeCol());
            var3.setTablisNom02(var2.getNomCol());
            var3.setTablisTypeCol02(var2.getTypeCol());
         } else if (var1 == 3) {
            var3.setTablisAnn03(var2.getPeriodeCol());
            var3.setTablisNom03(var2.getNomCol());
            var3.setTablisTypeCol03(var2.getTypeCol());
         } else if (var1 == 4) {
            var3.setTablisAnn04(var2.getPeriodeCol());
            var3.setTablisNom04(var2.getNomCol());
            var3.setTablisTypeCol04(var2.getTypeCol());
         } else if (var1 == 5) {
            var3.setTablisAnn05(var2.getPeriodeCol());
            var3.setTablisNom05(var2.getNomCol());
            var3.setTablisTypeCol05(var2.getTypeCol());
         } else if (var1 == 6) {
            var3.setTablisAnn06(var2.getPeriodeCol());
            var3.setTablisNom06(var2.getNomCol());
            var3.setTablisTypeCol06(var2.getTypeCol());
         } else if (var1 == 7) {
            var3.setTablisAnn07(var2.getPeriodeCol());
            var3.setTablisNom07(var2.getNomCol());
            var3.setTablisTypeCol07(var2.getTypeCol());
         } else if (var1 == 8) {
            var3.setTablisAnn08(var2.getPeriodeCol());
            var3.setTablisNom08(var2.getNomCol());
            var3.setTablisTypeCol08(var2.getTypeCol());
         } else if (var1 == 9) {
            var3.setTablisAnn09(var2.getPeriodeCol());
            var3.setTablisNom09(var2.getNomCol());
            var3.setTablisTypeCol09(var2.getTypeCol());
         } else if (var1 == 10) {
            var3.setTablisAnn10(var2.getPeriodeCol());
            var3.setTablisNom10(var2.getNomCol());
            var3.setTablisTypeCol10(var2.getTypeCol());
         } else if (var1 == 11) {
            var3.setTablisAnn11(var2.getPeriodeCol());
            var3.setTablisNom11(var2.getNomCol());
            var3.setTablisTypeCol11(var2.getTypeCol());
         } else if (var1 == 12) {
            var3.setTablisAnn12(var2.getPeriodeCol());
            var3.setTablisNom12(var2.getNomCol());
            var3.setTablisTypeCol12(var2.getTypeCol());
         } else if (var1 == 13) {
            var3.setTablisAnn13(var2.getPeriodeCol());
            var3.setTablisNom13(var2.getNomCol());
            var3.setTablisTypeCol13(var2.getTypeCol());
         } else if (var1 == 14) {
            var3.setTablisAnn14(var2.getPeriodeCol());
            var3.setTablisNom14(var2.getNomCol());
            var3.setTablisTypeCol14(var2.getTypeCol());
         } else if (var1 == 15) {
            var3.setTablisAnn15(var2.getPeriodeCol());
            var3.setTablisNom15(var2.getNomCol());
            var3.setTablisTypeCol15(var2.getTypeCol());
         } else if (var1 == 16) {
            var3.setTablisAnn16(var2.getPeriodeCol());
            var3.setTablisNom16(var2.getNomCol());
            var3.setTablisTypeCol16(var2.getTypeCol());
         } else if (var1 == 17) {
            var3.setTablisAnn17(var2.getPeriodeCol());
            var3.setTablisNom17(var2.getNomCol());
            var3.setTablisTypeCol17(var2.getTypeCol());
         } else if (var1 == 18) {
            var3.setTablisAnn18(var2.getPeriodeCol());
            var3.setTablisNom18(var2.getNomCol());
            var3.setTablisTypeCol18(var2.getTypeCol());
         } else if (var1 == 19) {
            var3.setTablisAnn19(var2.getPeriodeCol());
            var3.setTablisNom19(var2.getNomCol());
            var3.setTablisTypeCol19(var2.getTypeCol());
         } else if (var1 == 20) {
            var3.setTablisAnn20(var2.getPeriodeCol());
            var3.setTablisNom20(var2.getNomCol());
            var3.setTablisTypeCol20(var2.getTypeCol());
         }

         var4.update(var3);
         var5.commit();
      } catch (HibernateException var10) {
         if (var5 != null) {
            var5.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var2;
   }

   public void deletePegtabNom(String var1, Session var2) {
      String var3 = "delete from  CptTabNom where tablis_id in " + var1;
      int var4 = var2.createQuery(var3).executeUpdate();
   }

   public void deletePegtabNom(CptTabNom var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "CptTabNom");
      Transaction var3 = var2.beginTransaction();
      var2.delete(var1);
      var3.commit();
      this.utilInitHibernate.closeSession();
   }

   public void deletePegtabNom() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.maBase, "CptTabNom");
      Transaction var2 = var1.beginTransaction();
      String var3 = "delete from  CptTabNom where tablisType=:type";
      int var4 = var1.createQuery(var3).setInteger("type", 0).executeUpdate();
      var2.commit();
      this.utilInitHibernate.closeSession();
   }

   public List chargerMesTabNomConf(int var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "CptTabNom");
         var4 = true;
      }

      Query var5 = null;
      if (var1 == 0) {
         var5 = var3.createQuery("from CptTabNom where (tablisType=0 or tablisType=2 or tablisType=3 or tablisType=4 or tablisType=4 or tablisType=5 or tablisType=6) and tablisZone='" + var2 + "' order by tablisNum");
      } else if (var1 == 1) {
         var5 = var3.createQuery("from CptTabNom where tablisType=1 order by tablisNum");
      } else if (var1 == 10) {
         var5 = var3.createQuery("from CptTabNom where (tablisType=10 or tablisType=15) and tablisZone='" + var2 + "' order by tablisNum");
      }

      new ArrayList();
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerMesTabNomExp(int var1, int var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "CptTabNom");
         var5 = true;
      }

      Query var6 = null;
      if (var1 == 0) {
         var6 = var4.createQuery("from CptTabNom where tablisInactif=0 and (tablisType=0 or tablisType=2 or tablisType=3 or tablisType=4 or tablisType=5 or tablisType=6) and tablisZone='" + var3 + "' order by tablisNum");
      } else if (var1 == 1) {
         var6 = var4.createQuery("from CptTabNom where tablisInactif=0 and tablisType=1 and tablisCategorie=" + var2 + " order by tablisNum");
      } else if (var1 == 10) {
         var6 = var4.createQuery("from CptTabNom where tablisInactif=0 and (tablisType=10 or tablisType=15) and tablisZone='" + var3 + "' order by tablisNum");
      }

      new ArrayList();
      List var7 = var6.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }
}
