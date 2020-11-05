package com.epegase.systeme.dao;

import com.epegase.systeme.classe.BsoTabElement;
import com.epegase.systeme.classe.BsoTabFormule;
import com.epegase.systeme.classe.BsoTabNom;
import com.epegase.systeme.classe.PegTabFormule;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BsoTabFormuleDao implements Serializable {
   private String maBase;
   private BsoTabFormule bsoTabFormule;
   private UtilInitHibernate utilInitHibernate;

   public BsoTabFormuleDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public void savePegtabFormule(List var1, List var2, Session var3) throws HibernateException, NamingException {
      var3 = this.utilInitHibernate.getOpenSession(this.maBase, "BsoTabNom");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         new BsoTabElement();

         for(int var6 = 0; var6 < var2.size(); ++var6) {
            BsoTabElement var5 = (BsoTabElement)var2.get(var6);

            for(int var7 = 0; var7 < var1.size(); ++var7) {
               new PegTabFormule();
               PegTabFormule var8 = (PegTabFormule)var1.get(var7);
               BsoTabFormule var9 = new BsoTabFormule();
               if (var5.getTabeleOldId() == var8.getPegTabElement().getTabele_id()) {
                  var9.setBsoTabElement(var5);
                  var9.setTabforCol(var8.getTabforCol());
                  var9.setTabforZone(var8.getTabforZone());
                  var9.setTabforFormule(var8.getTabforFormule());
                  var9.setTabforSolde(var8.getTabforSolde());
                  var9.setTabforPeriode(var8.getTabforPeriode());
                  if (var8.isTabforInactif()) {
                     var9.setTabforInactif(1);
                  } else {
                     var9.setTabforInactif(0);
                  }

                  var9.setTabforOldId(var8.getPegTabElement().getTabele_id());
                  var3.save(var9);
               }
            }
         }

         var4.commit();
      } catch (HibernateException var13) {
         if (var4 != null) {
            var4.rollback();
         }

         throw var13;
      } finally {
         this.utilInitHibernate.closeSession();
      }
   }

   public void deleteCpttabFormule(String var1, Session var2) {
      String var3 = "delete from BsoTabFormule where tabfor_id in " + var1;
      int var4 = var2.createQuery(var3).executeUpdate();
   }

   public BsoTabFormule insertFormule(BsoTabFormule var1, BsoTabElement var2, String var3, int var4, BsoTabNom var5) throws HibernateException, NamingException {
      Session var6 = this.utilInitHibernate.getOpenSession(this.maBase, "BsoTabNom");
      Transaction var7 = null;

      try {
         var7 = var6.beginTransaction();
         var1.setBsoTabElement(var2);
         var1.setTabforZone(var3);
         var1.setTabforCol(var4);
         if (var5 != null) {
            if (var4 == 1) {
               var1.setTabforPeriode(var5.getTablisAnn01());
            } else if (var4 == 2) {
               var1.setTabforPeriode(var5.getTablisAnn02());
            } else if (var4 == 3) {
               var1.setTabforPeriode(var5.getTablisAnn03());
            } else if (var4 == 4) {
               var1.setTabforPeriode(var5.getTablisAnn04());
            } else if (var4 == 5) {
               var1.setTabforPeriode(var5.getTablisAnn05());
            } else if (var4 == 6) {
               var1.setTabforPeriode(var5.getTablisAnn06());
            } else if (var4 == 7) {
               var1.setTabforPeriode(var5.getTablisAnn07());
            } else if (var4 == 8) {
               var1.setTabforPeriode(var5.getTablisAnn08());
            } else if (var4 == 9) {
               var1.setTabforPeriode(var5.getTablisAnn09());
            } else if (var4 == 10) {
               var1.setTabforPeriode(var5.getTablisAnn10());
            } else if (var4 == 11) {
               var1.setTabforPeriode(var5.getTablisAnn11());
            } else if (var4 == 12) {
               var1.setTabforPeriode(var5.getTablisAnn12());
            } else if (var4 == 13) {
               var1.setTabforPeriode(var5.getTablisAnn13());
            } else if (var4 == 14) {
               var1.setTabforPeriode(var5.getTablisAnn14());
            } else if (var4 == 15) {
               var1.setTabforPeriode(var5.getTablisAnn15());
            } else if (var4 == 16) {
               var1.setTabforPeriode(var5.getTablisAnn16());
            } else if (var4 == 17) {
               var1.setTabforPeriode(var5.getTablisAnn17());
            } else if (var4 == 18) {
               var1.setTabforPeriode(var5.getTablisAnn18());
            } else if (var4 == 19) {
               var1.setTabforPeriode(var5.getTablisAnn19());
            } else if (var4 == 20) {
               var1.setTabforPeriode(var5.getTablisAnn20());
            }
         }

         var6.save(var1);
         var7.commit();
      } catch (HibernateException var12) {
         if (var7 != null) {
            var7.rollback();
         }

         throw var12;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var1;
   }

   public BsoTabFormule modifFormule(BsoTabFormule var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "BsoTabNom");
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

   public void deleteFormule(BsoTabFormule var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "BsoTabNom");
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

   public List chargerMesTabFormule(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "BsoTabNom");
         var3 = true;
      }

      Query var4 = var2.createQuery("from BsoTabFormule where bsoTabElement in " + var1);
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerMesTabFormule(long var1, int var3) throws HibernateException, NamingException {
      Session var4 = this.utilInitHibernate.getOpenSession(this.maBase, "BsoTabNom");
      Query var5 = var4.createQuery("from BsoTabFormule as pF where tabforInactif=0 and pF.bsoTabElement=:idpegElm and pF.tabforCol=:index order by tabfor_id").setLong("idpegElm", var1).setInteger("index", var3);
      List var6 = var5.list();
      this.utilInitHibernate.closeSession();
      return var6;
   }

   public List chargerMesTabFormule(long var1, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "BsoTabNom");
         var5 = true;
      }

      Query var6 = var4.createQuery("from BsoTabFormule where tabforInactif=0 and bsoTabElement.tabele_id=:idpegElm and tabforCol=:index order by tabfor_id").setLong("idpegElm", var1).setInteger("index", var3);
      List var7 = var6.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerMesTabFormule(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "BsoTabNom");
         var4 = true;
      }

      Query var5 = var3.createQuery("from BsoTabFormule where tabforInactif=0 and bsoTabElement.tabele_id=:idpegElm order by tabfor_id").setLong("idpegElm", var1);
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
