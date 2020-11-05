package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Metiers;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class MetiersDao implements Serializable {
   private Metiers metiers;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;
   private String nom_fr;
   private int inactif;
   private int type;

   public MetiersDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public void ajoutParDefaut(String var1, Structure var2, Users var3) throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      SAXBuilder var4 = new SAXBuilder();

      try {
         File var5 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commun" + File.separator + "metiers.xml");
         if (var5.exists()) {
            Document var6 = var4.build(new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commun" + File.separator + "metiers.xml"));
            Element var7 = var6.getRootElement();
            List var8 = var7.getChildren();
            Session var9 = this.utilInitHibernate.getOpenSession(this.maBase, "Metiers");
            Transaction var10 = null;

            try {
               var10 = var9.beginTransaction();

               for(int var11 = 0; var11 < var8.size(); ++var11) {
                  this.nom_fr = ((Element)var8.get(var11)).getChild("nom_fr").getText();
                  String var12 = ((Element)var8.get(var11)).getChild("inactif").getText();
                  this.inactif = Integer.parseInt(var12);
                  String var13 = ((Element)var8.get(var11)).getChild("type").getText();
                  this.type = Integer.parseInt(var13);
                  this.metiers = new Metiers();
                  this.metiers.setMetDateCreat(new Date());
                  this.metiers.setMetDateModif((Date)null);
                  this.metiers.setMetNomFr(this.nom_fr);
                  this.metiers.setMetNomSp("");
                  this.metiers.setMetNomUk("");
                  this.metiers.setMetType(this.type);
                  this.metiers.setMetUserCreat(var3.getUsrid());
                  this.metiers.setMetUserModif(0L);
                  var9.save(this.metiers);
               }

               var10.commit();
            } catch (HibernateException var19) {
               if (var10 != null) {
                  var10.rollback();
               }

               throw var19;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }
      } catch (JDOMException var21) {
      } catch (IOException var22) {
      }

   }

   public Metiers insert(Metiers var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Metiers");
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

   public Metiers insert(Metiers var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public Metiers modif(Metiers var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Metiers");
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

   public void delete(Metiers var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Metiers");
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

   public void delete(Metiers var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List selectMetiers(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Metiers");
         var3 = true;
      }

      List var4 = var2.createQuery("from Metiers where metType=:typ order by metNomFr asc").setInteger("typ", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesMetiersPP(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Metiers");
         var2 = true;
      }

      List var3 = var1.createQuery("from Metiers where metInactif=0 and metType=0 order by metNomFr asc").list();
      List var4 = var3;
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var5.add(new SelectItem(((Metiers)var4.get(var6)).getMetNomFr()));
         }
      }

      return var5;
   }

   public List chargerLesMetiersPM(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Metiers");
         var2 = true;
      }

      List var3 = var1.createQuery("from Metiers where metInactif=0 and metType=1 order by metNomFr asc").list();
      List var4 = var3;
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var5.add(new SelectItem(((Metiers)var4.get(var6)).getMetNomFr()));
         }
      }

      return var5;
   }

   public List chargerLesMetiers(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Metiers");
         var3 = true;
      }

      List var4 = var2.createQuery("from Metiers where metInactif=0 order by metNomFr asc").list();
      List var5 = var4;
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var6 = new ArrayList();
      if (var4.size() != 0) {
         for(int var7 = 0; var7 < var5.size(); ++var7) {
            var6.add(new SelectItem(((Metiers)var5.get(var7)).getMetNomFr()));
         }
      }

      return var6;
   }

   public Metiers rechercheMetier(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Metiers");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Metiers ja where ja.metNomFr=:cod").setString("cod", var1);
      var4.setMaxResults(1);
      List var5 = var4.list();
      new Metiers();
      Metiers var6;
      if (var5.size() > 0) {
         var6 = (Metiers)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public Metiers rechercheMetier(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Metiers");
         var4 = true;
      }

      Query var5 = var3.createQuery("from Metiers where metId=:id").setLong("id", var1);
      var5.setMaxResults(1);
      List var6 = var5.list();
      new Metiers();
      Metiers var7;
      if (var6.size() > 0) {
         var7 = (Metiers)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public boolean existLib(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Metiers");
         var3 = true;
      }

      boolean var4 = false;
      Query var5 = var2.createQuery("from Metiers where metNomFr=:cod").setString("cod", var1);
      var5.setMaxResults(1);
      List var6 = var5.list();
      if (var6.size() > 0) {
         var4 = true;
      } else {
         var4 = false;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }
}
