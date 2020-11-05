package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Groupe;
import com.epegase.systeme.classe.GroupeFavoris;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class GroupeFavorisDao implements Serializable {
   private GroupeFavoris groupeFavoris;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public GroupeFavorisDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public void creationAutorisation(List var1, Session var2) throws HibernateException, NamingException {
      if (var1.size() != 0) {
         for(int var3 = 0; var3 < var1.size(); ++var3) {
            new GroupeFavoris();
            GroupeFavoris var4 = (GroupeFavoris)var1.get(var3);
            var2.save(var4);
         }
      }

   }

   public void suppressionAutorisation(String var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      List var3 = this.selectGroupeRepertoire(var1, var2);
      if (var3.size() != 0) {
         for(int var4 = 0; var4 < var3.size(); ++var4) {
            new GroupeFavoris();
            GroupeFavoris var5 = (GroupeFavoris)var3.get(var4);
            var2.delete(var5);
         }
      }

   }

   public List selectGroupe(Groupe var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Accueil");
         var3 = true;
      }

      List var4 = var2.createQuery("from GroupeFavoris where groupe=:grp").setParameter("grp", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List selectGroupeRepertoire(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Accueil");
         var3 = true;
      }

      List var4 = var2.createQuery("from GroupeFavoris where grpfavRepertoire=:rep").setString("rep", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }
}
