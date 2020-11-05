package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ConsultationEnteteGene;
import com.epegase.systeme.classe.ConsultationInfirmerie;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ConsultationInfirmerieDao implements Serializable {
   private ConsultationInfirmerie consultationInfirmerie;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ConsultationInfirmerieDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public ConsultationInfirmerie insert(ConsultationInfirmerie var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
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

   public ConsultationInfirmerie insert(ConsultationInfirmerie var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public ConsultationInfirmerie modif(ConsultationInfirmerie var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
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

   public ConsultationInfirmerie modif(ConsultationInfirmerie var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(ConsultationInfirmerie var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
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

   public void delete(ConsultationInfirmerie var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public void deleteConsulInfirmerieByConsultEnt(ConsultationEnteteGene var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
      Transaction var3 = var2.beginTransaction();
      var3.begin();
      String var4 = "delete from ConsultationInfirmerie where ConsultationEnteteGene=:param";
      Query var5 = var2.createQuery(var4);
      var5.setParameter("param", var1);
      int var6 = var5.executeUpdate();
      var3.commit();
      this.utilInitHibernate.closeSession();
   }

   public void deleteConsulInfirmerieByConsultEnt(ConsultationEnteteGene var1, Session var2) throws HibernateException, NamingException {
      String var3 = "delete from ConsultationInfirmerie where ConsultationEnteteGene=:param";
      Query var4 = var2.createQuery(var3);
      var4.setParameter("param", var1);
      int var5 = var4.executeUpdate();
   }

   public ConsultationInfirmerie selectConsInfirmerieByConsEnt(ConsultationEnteteGene var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
         var3 = true;
      }

      this.consultationInfirmerie = new ConsultationInfirmerie();
      List var4 = var2.createQuery("From ConsultationInfirmerie where ConsultationEnteteGene=:param").setParameter("param", var1).setMaxResults(1).list();
      if (var4.size() != 0) {
         this.consultationInfirmerie = (ConsultationInfirmerie)var4.get(0);
      } else {
         this.consultationInfirmerie = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return this.consultationInfirmerie;
   }

   public List chargerLesMvtsDate(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
         var4 = true;
      }

      List var5 = null;
      var5 = var3.createQuery("from ConsultationInfirmerie where ConsultationEnteteGene.csgDate between '" + var1 + "' and '" + var2 + "'").list();
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
      var6 = var4.createQuery("from ConsultationInfirmerie where ConsultationEnteteGene.csgDate between '" + var2 + "' and '" + var3 + "' and ConsultationEnteteGene.csgService='" + var1 + "'").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesVaccinsPerimes(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
         var4 = true;
      }

      List var5 = null;
      var5 = var3.createQuery("from ConsultationInfirmerie where (cslaccLotDte1 is not null and cslaccLotDte1>=:d1 and cslaccLotDte1<=:d2) or (cslaccLotDte2 is not null and cslaccLotDte2>=:d1 and cslaccLotDte2<=:d2) or (cslaccLotDte3 is not null and cslaccLotDte3>=:d1 and cslaccLotDte3<=:d2) or (cslaccLotDte4 is not null and cslaccLotDte4>=:d1 and cslaccLotDte4<=:d2) or (cslaccLotDte5 is not null and cslaccLotDte5>=:d1 and cslaccLotDte5<=:d2) or (cslaccLotDte6 is not null and cslaccLotDte6>=:d1 and cslaccLotDte6<=:d2) or (cslaccLotDte7 is not null and cslaccLotDte7>=:d1 and cslaccLotDte7<=:d2) or (cslaccLotDte8 is not null and cslaccLotDte8>=:d1 and cslaccLotDte8<=:d2) or (cslaccLotDte9 is not null and cslaccLotDte9>=:d1 and cslaccLotDte9<=:d2) or (cslaccLotDte10 is not null and cslaccLotDte10>=:d1 and cslaccLotDte10<=:d2)").setDate("d1", var1).setDate("d2", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
