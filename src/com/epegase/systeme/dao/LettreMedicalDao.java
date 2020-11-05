package com.epegase.systeme.dao;

import com.epegase.systeme.classe.LettreMedical;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class LettreMedicalDao implements Serializable {
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public LettreMedicalDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public LettreMedical insert(LettreMedical var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public LettreMedical modif(LettreMedical var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public String deletLettre(long var1, Session var3) {
      Query var4 = var3.createQuery("delete from LettreMedical where letId =:Sid");
      var4.setParameter("Sid", var1);
      var4.executeUpdate();
      return null;
   }

   public List selectLettre(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "LettreMedical");
         var4 = true;
      }

      Query var5 = var3.createQuery("from LettreMedical where exerciceventes=:exo order by letLettre").setLong("exo", var1);
      Object var6 = new ArrayList();
      if (var5.list() != null) {
         var6 = var5.list();
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var6;
   }

   public List selectActifLettreItem(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "LettreMedical");
         var4 = true;
      }

      new ArrayList();
      ArrayList var6 = new ArrayList();
      List var5 = var3.createQuery("from LettreMedical where exerciceventes=:exo and letInactif=0 order by letLettre").setLong("exo", var1).list();
      if (var5.size() != 0) {
         for(int var7 = 0; var7 < var5.size(); ++var7) {
            var6.add(new SelectItem(((LettreMedical)var5.get(var7)).getLetLettre(), ((LettreMedical)var5.get(var7)).getLetLettre() + ":" + ((LettreMedical)var5.get(var7)).getLetLibelleFr()));
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List selectActifLettre(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "LettreMedical");
         var4 = true;
      }

      List var5 = var3.createQuery("from LettreMedical where exerciceventes=:exo and letInactif=0 order by letLettre").setLong("exo", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public LettreMedical selectLettre(long var1, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "LettreMedical");
         var5 = true;
      }

      Query var6 = var4.createQuery("from LettreMedical where exerciceventes=:exo and letLettre=:tax order by letLettre").setLong("exo", var1).setString("tax", var3);
      var6.setMaxResults(1);
      List var7 = var6.list();
      LettreMedical var8 = null;
      if (var7.size() != 0) {
         var8 = (LettreMedical)var7.get(0);
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }
}
