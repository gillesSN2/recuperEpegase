package com.epegase.systeme.dao;

import com.epegase.systeme.classe.CptTabElement;
import com.epegase.systeme.classe.CptTabNom;
import com.epegase.systeme.classe.PegTabElement;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CptTabElementDao implements Serializable {
   private CptTabElement cptTabElement;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public CptTabElementDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public void deleteCpttabElement(String var1, Session var2) {
      String var3 = "delete from CptTabElement where tabele_id in " + var1;
      int var4 = var2.createQuery(var3).executeUpdate();
   }

   public List savePegtabElement(List var1, List var2, Session var3) throws HibernateException, NamingException {
      ArrayList var4 = new ArrayList();
      var3 = this.utilInitHibernate.getOpenSession(this.maBase, "CptTabNom");
      Transaction var5 = null;

      try {
         var5 = var3.beginTransaction();
         new CptTabNom();

         for(int var7 = 0; var7 < var2.size(); ++var7) {
            CptTabNom var6 = (CptTabNom)var2.get(var7);

            for(int var8 = 0; var8 < var1.size(); ++var8) {
               new PegTabElement();
               PegTabElement var9 = (PegTabElement)var1.get(var8);
               CptTabElement var10 = new CptTabElement();
               if (var6.getTablisOldId() == var9.getPegTabNom().getTablis_id()) {
                  var10.setCptTabNom(var6);
                  var10.setTabeleZone(var9.getTabeleZone());
                  var10.setTabeleReference(var9.getTabeleReference());
                  var10.setTabeleLibFR(var9.getTabeleLibFR());
                  var10.setTabeleLibSP(var9.getTabeleLibSP());
                  var10.setTabeleLibUK(var9.getTabeleLibUK());
                  var10.setTabeleNum(var9.getTabeleNum());
                  var10.setTabeleType(var9.getTabeleType());
                  var10.setTabeleMode(var9.getTabeleMode());
                  var10.setTabeleInactif(var9.isTabeleInactif());
                  var10.setTabeleOldId(var9.getTabele_id());
                  var10.setTablisOldId(var9.getPegTabNom().getTablis_id());
                  var10.setTabeleTypeCol01(var9.getTabeleTypeCol01());
                  var10.setTabeleTypeCol02(var9.getTabeleTypeCol02());
                  var10.setTabeleTypeCol03(var9.getTabeleTypeCol03());
                  var10.setTabeleTypeCol04(var9.getTabeleTypeCol04());
                  var10.setTabeleTypeCol05(var9.getTabeleTypeCol05());
                  var10.setTabeleTypeCol06(var9.getTabeleTypeCol06());
                  var10.setTabeleTypeCol07(var9.getTabeleTypeCol07());
                  var10.setTabeleTypeCol08(var9.getTabeleTypeCol08());
                  var10.setTabeleTypeCol09(var9.getTabeleTypeCol09());
                  var10.setTabeleTypeCol10(var9.getTabeleTypeCol10());
                  var10.setTabeleTypeCol11(var9.getTabeleTypeCol11());
                  var10.setTabeleTypeCol12(var9.getTabeleTypeCol12());
                  var10.setTabeleTypeCol13(var9.getTabeleTypeCol13());
                  var10.setTabeleTypeCol14(var9.getTabeleTypeCol14());
                  var10.setTabeleTypeCol15(var9.getTabeleTypeCol15());
                  var10.setTabeleTypeCol16(var9.getTabeleTypeCol16());
                  var10.setTabeleTypeCol17(var9.getTabeleTypeCol17());
                  var10.setTabeleTypeCol18(var9.getTabeleTypeCol18());
                  var10.setTabeleTypeCol19(var9.getTabeleTypeCol19());
                  var10.setTabeleTypeCol20(var9.getTabeleTypeCol20());
                  var3.save(var10);
                  var4.add(var10);
               }
            }
         }

         var5.commit();
         return var4;
      } catch (HibernateException var14) {
         if (var5 != null) {
            var5.rollback();
         }

         throw var14;
      } finally {
         this.utilInitHibernate.closeSession();
      }
   }

   public CptTabElement insertElement(CptTabElement var1, CptTabNom var2) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.maBase, "CptTabNom");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         var1.setCptTabNom(var2);
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

   public CptTabElement modifElement(CptTabElement var1) throws HibernateException, NamingException {
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

   public void deleteElement(CptTabElement var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "CptTabNom");
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

   public List chargerMesTabElement(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "CptTabNom");
         var3 = true;
      }

      Query var4 = var2.createQuery("from CptTabElement where cptTabNom in " + var1);
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public CptTabElement chargerMesTabElementByRef(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "CptTabNom");
         var4 = true;
      }

      Query var5 = var3.createQuery("from CptTabElement where tabeleLibFR is not null and tabeleLibFR <> '' and tabeleLibFR='" + var1 + "' and tabeleReference is not null and tabeleReference <> '' and tabeleReference='" + var2 + "'");
      List var6 = var5.list();
      if (var6.size() != 0) {
         this.cptTabElement = (CptTabElement)var6.get(0);
      } else {
         this.cptTabElement = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.cptTabElement;
   }

   public CptTabElement chargerMesTabElementByRef(long var1, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "CptTabNom");
         var5 = true;
      }

      Query var6 = var4.createQuery("from CptTabElement where cptTabNom.tablis_id=" + var1 + " and tabeleReference is not null and tabeleReference <> '' and tabeleReference='" + var3 + "'");
      List var7 = var6.list();
      if (var7.size() != 0) {
         this.cptTabElement = (CptTabElement)var7.get(0);
      } else {
         this.cptTabElement = null;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return this.cptTabElement;
   }

   public List chargerMesTabElement() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.maBase, "CptTabNom");
      Query var2 = var1.createQuery("from CptTabElement order by tabeleNum");
      List var3 = var2.list();
      this.utilInitHibernate.closeSession();
      return var3;
   }

   public List chargerMesTabElement(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "CptTabNom");
         var4 = true;
      }

      Query var5 = var3.createQuery("from CptTabElement where tabeleInactif=0 and cptTabNom=:tabNomid order by tabeleNum").setLong("tabNomid", var1);
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public void ordonnnerAscendant(int var1, int var2, long var3, long var5) throws HibernateException, NamingException {
      Session var7 = this.utilInitHibernate.getOpenSession(this.maBase, "CptTabNom");
      Transaction var8 = var7.beginTransaction();
      String var9 = "update CptTabElement pb set pb.tabeleNum=:ordPrec where pb.tabele_id=:idTab";
      var7.createQuery(var9).setInteger("ordPrec", var2).setLong("idTab", var3).executeUpdate();
      String var11 = "update CptTabElement pb set pb.tabeleNum=:ord1 where pb.tabele_id=:idTab";
      var7.createQuery(var11).setInteger("ord1", var1).setLong("idTab", var5).executeUpdate();
      var8.commit();
      this.utilInitHibernate.closeSession();
   }

   public void ordonnnerDescendant(int var1, int var2, long var3, long var5) throws HibernateException, NamingException {
      Session var7 = this.utilInitHibernate.getOpenSession(this.maBase, "CptTabNom");
      Transaction var8 = var7.beginTransaction();
      String var9 = "update CptTabElement pb set pb.tabeleNum=:ordSuiv where pb.tabele_id=:idTab";
      var7.createQuery(var9).setInteger("ordSuiv", var2).setLong("idTab", var3).executeUpdate();
      String var11 = "update CptTabElement pb set pb.tabeleNum=:ord1 where pb.tabele_id=:idTab";
      var7.createQuery(var11).setInteger("ord1", var1).setLong("idTab", var5).executeUpdate();
      var8.commit();
      this.utilInitHibernate.closeSession();
   }
}
