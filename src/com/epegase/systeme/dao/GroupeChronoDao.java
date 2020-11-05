package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Groupe;
import com.epegase.systeme.classe.GroupeChrono;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GroupeChronoDao implements Serializable {
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public GroupeChronoDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public GroupeChrono insert(GroupeChrono var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "GroupeChrono");
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

   public GroupeChrono insert(GroupeChrono var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public GroupeChrono modifier(GroupeChrono var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "GroupeChrono");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         var2.saveOrUpdate(var1);
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

   public GroupeChrono modifier(GroupeChrono var1, Session var2) throws HibernateException, NamingException {
      var2.saveOrUpdate(var1);
      return var1;
   }

   public void delete(GroupeChrono var1, Session var2) {
      var2.delete(var1);
   }

   public String delete(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "GroupeChrono");
      Transaction var4 = var3.beginTransaction();
      var4.begin();
      Query var5 = var3.createQuery("delete from GroupeChrono where grpchrId =:Sid").setLong("Sid", var1);
      var5.executeUpdate();
      var4.commit();
      this.utilInitHibernate.closeSession();
      return null;
   }

   public List selectListToutByGroupe(Groupe var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "GroupeChrono");
         var3 = true;
      }

      Query var4 = var2.createQuery("from GroupeChrono where groupe=:grp order by grpchrSerie asc").setParameter("grp", var1);
      new ArrayList();
      if (var4.list() != null) {
         List var5 = var4.list();
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return var5;
      } else {
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return null;
      }
   }

   public List selectListVente() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.mabase, "GroupeChrono");
      Query var2 = var1.createQuery("from GroupeChrono where ((grpchrNature>=8 and grpchrNature<=9) or (grpchrNature>=20 and grpchrNature<=29)) order by grpchrSerie asc");
      new ArrayList();
      if (var2.list() != null) {
         List var3 = var2.list();
         this.utilInitHibernate.closeSession();
         return var3;
      } else {
         this.utilInitHibernate.closeSession();
         return null;
      }
   }

   public List selectListVenteByGroupe(Groupe var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "GroupeChrono");
         var3 = true;
      }

      Query var4 = var2.createQuery("from GroupeChrono where groupe=:grp and ((grpchrNature>=8 and grpchrNature<=9) or (grpchrNature>=20 and grpchrNature<=29)) order by grpchrSerie asc").setParameter("grp", var1);
      new ArrayList();
      if (var4.list() != null) {
         List var5 = var4.list();
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return var5;
      } else {
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return null;
      }
   }

   public List selectListSimulationVentes(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "GroupeChrono");
         var2 = true;
      }

      Query var3 = var1.createQuery("from GroupeChrono where (grpchrNature>=8 and grpchrNature<=9) order by grpchrSerie asc");
      Object var4 = new ArrayList();
      if (var3.list() != null) {
         var4 = var3.list();
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var4;
   }

   public List selectListCaisse() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.mabase, "GroupeChrono");
      Query var2 = var1.createQuery("from GroupeChrono where grpchrNature>=60 and grpchrNature<=69 order by grpchrSerie asc");
      new ArrayList();
      if (var2.list() != null) {
         List var3 = var2.list();
         this.utilInitHibernate.closeSession();
         return var3;
      } else {
         this.utilInitHibernate.closeSession();
         return null;
      }
   }

   public List selectListCaisseByGroupe(Groupe var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "GroupeChrono");
         var3 = true;
      }

      Query var4 = var2.createQuery("from GroupeChrono where groupe=:grp and (grpchrNature>=60 and grpchrNature<=69) order by grpchrSerie asc").setParameter("grp", var1);
      new ArrayList();
      if (var4.list() != null) {
         List var5 = var4.list();
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return var5;
      } else {
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return null;
      }
   }

   public List selectListAchat() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.mabase, "GroupeChrono");
      Query var2 = var1.createQuery("from GroupeChrono where (grpchrNature>=10 and grpchrNature<=19) or (grpchrNature>=40 and grpchrNature<=49) order by grpchrSerie asc");
      new ArrayList();
      if (var2.list() != null) {
         List var3 = var2.list();
         this.utilInitHibernate.closeSession();
         return var3;
      } else {
         this.utilInitHibernate.closeSession();
         return null;
      }
   }

   public List selectListByGroupe(Groupe var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "GroupeChrono");
         var3 = true;
      }

      Query var4 = var2.createQuery("from GroupeChrono where groupe=:grp").setParameter("grp", var1);
      new ArrayList();
      if (var4.list() != null) {
         List var5 = var4.list();
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return var5;
      } else {
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return null;
      }
   }

   public List selectListByGroupeComm(Groupe var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "GroupeChrono");
         var3 = true;
      }

      Query var4 = var2.createQuery("from GroupeChrono where groupe=:grp and (grpchrNature>=10 and grpchrNature<=39) group by grpchrSerie").setParameter("grp", var1);
      new ArrayList();
      if (var4.list() != null) {
         List var5 = var4.list();
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return var5;
      } else {
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return null;
      }
   }

   public List selectListOfficeByGroupe(Groupe var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "GroupeChrono");
         var3 = true;
      }

      Query var4 = var2.createQuery("from GroupeChrono where groupe=:grp and (grpchrNature>=1 and grpchrNature<=7) order by grpchrNature asc").setParameter("grp", var1);
      new ArrayList();
      if (var4.list() != null) {
         List var5 = var4.list();
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return var5;
      } else {
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return null;
      }
   }

   public List selectListAchatByGroupe(Groupe var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "GroupeChrono");
         var3 = true;
      }

      Query var4 = var2.createQuery("from GroupeChrono where groupe=:grp and ((grpchrNature>=10 and grpchrNature<=19) or (grpchrNature>=30 and grpchrNature<=39)) order by grpchrSerie asc").setParameter("grp", var1);
      new ArrayList();
      if (var4.list() != null) {
         List var5 = var4.list();
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return var5;
      } else {
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return null;
      }
   }

   public List selectListPaye() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.mabase, "GroupeChrono");
      Query var2 = var1.createQuery("from GroupeChrono where grpchrNature>=80 and grpchrNature<=89 order by grpchrSerie asc");
      new ArrayList();
      if (var2.list() != null) {
         List var3 = var2.list();
         this.utilInitHibernate.closeSession();
         return var3;
      } else {
         this.utilInitHibernate.closeSession();
         return null;
      }
   }

   public List selectListPayeByGroupe(Groupe var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "GroupeChrono");
         var3 = true;
      }

      Query var4 = var2.createQuery("from GroupeChrono where groupe=:grp and (grpchrNature>=80 and grpchrNature<=89) order by grpchrSerie asc").setParameter("grp", var1);
      new ArrayList();
      if (var4.list() != null) {
         List var5 = var4.list();
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return var5;
      } else {
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return null;
      }
   }

   public List selectListByGroupeNat(Groupe var1, int var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "GroupeChrono");
         var4 = true;
      }

      Object var5 = new ArrayList();
      Query var6 = var3.createQuery("from GroupeChrono where groupe=:grp and grpchrNature=:na order by grpchrSerie asc").setParameter("grp", var1).setParameter("na", var2);
      if (var6.list() != null) {
         var5 = var6.list();
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var5;
   }

   public GroupeChrono selectUnique(String var1, int var2, Groupe var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "GroupeChrono");
         var5 = true;
      }

      GroupeChrono var6 = null;
      Query var7 = var4.createQuery("from GroupeChrono where groupe=:grp and grpchrSerie=:ser and grpchrNature=:na order by grpchrNature desc").setMaxResults(1).setString("ser", var1).setInteger("na", var2).setParameter("grp", var3).setMaxResults(1);
      if (var7.list() != null) {
         List var8 = var7.list();
         if (var8.size() > 0) {
            var6 = (GroupeChrono)var8.get(0);
         }
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public boolean existByGroupeNat(Groupe var1, int var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "GroupeChrono");
         var4 = true;
      }

      Query var5 = var3.createQuery("from GroupeChrono where groupe=:grp and grpchrNature=:na order by grpchrSerie asc").setParameter("grp", var1).setInteger("na", var2).setMaxResults(1);
      boolean var6 = false;
      if (var5.list().size() > 0) {
         var6 = true;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public GroupeChrono chronoByGroupeNat(Groupe var1, int var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "GroupeChrono");
         var4 = true;
      }

      new GroupeChrono();
      Query var6 = var3.createQuery("from GroupeChrono where groupe=:grp and grpchrNature=:na order by grpchrSerie asc").setParameter("grp", var1).setInteger("na", var2).setMaxResults(1);
      GroupeChrono var5;
      if (var6.list().size() > 0) {
         var5 = (GroupeChrono)var6.list().get(0);
      } else {
         var5 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
