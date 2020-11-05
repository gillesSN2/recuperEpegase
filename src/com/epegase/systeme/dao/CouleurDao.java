package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Couleur;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class CouleurDao implements Serializable {
   private Couleur couleur;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public CouleurDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public Couleur insert(Couleur var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public Couleur modif(Couleur var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(Couleur var1, Session var2) {
      var2.delete(var1);
   }

   public List selectCouleur(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Couleur");
         var2 = true;
      }

      List var3 = var1.createQuery("from Couleur").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerLesCouleurs(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Couleur");
         var2 = true;
      }

      List var3 = var1.createQuery("from Couleur order by couLibelleFr").list();
      List var4 = var3;
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var5.add(new SelectItem(((Couleur)var4.get(var6)).getCouLibelleFr(), ((Couleur)var4.get(var6)).getCouLibelleFr()));
         }
      }

      return var5;
   }
}
