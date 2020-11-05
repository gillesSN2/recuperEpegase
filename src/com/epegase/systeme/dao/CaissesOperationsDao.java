package com.epegase.systeme.dao;

import com.epegase.systeme.classe.CaissesOperations;
import com.epegase.systeme.classe.ExercicesCaisse;
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

public class CaissesOperationsDao implements Serializable {
   private String mabase;
   private UtilInitHibernate utilInitHibernate;
   private int cat;
   private String code;
   private String nom;
   private int trf;
   private int type;

   public CaissesOperationsDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public void ajoutParDefaut(String var1, Structure var2, Users var3) throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      SAXBuilder var4 = new SAXBuilder();

      try {
         File var5 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commun" + File.separator + "operationsCaisses.xml");
         if (var5.exists()) {
            Document var6 = var4.build(new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commun" + File.separator + "operationsCaisses.xml"));
            Element var7 = var6.getRootElement();
            List var8 = var7.getChildren();
            ExercicesCaisseDao var9 = new ExercicesCaisseDao(this.mabase, this.utilInitHibernate);
            new ExercicesCaisse();
            ExercicesCaisse var10 = var9.recupererLastExo((Session)null);
            Session var11 = this.utilInitHibernate.getOpenSession(this.mabase, "CaisseCommerciale");
            Transaction var12 = null;

            try {
               var12 = var11.beginTransaction();

               for(int var13 = 0; var13 < var8.size(); ++var13) {
                  this.code = ((Element)var8.get(var13)).getChild("code").getText();
                  this.nom = ((Element)var8.get(var13)).getChild("nom").getText();
                  String var14 = ((Element)var8.get(var13)).getChild("categorie").getText();
                  this.cat = Integer.parseInt(var14);
                  String var15 = ((Element)var8.get(var13)).getChild("transfert").getText();
                  this.trf = Integer.parseInt(var15);
                  String var16 = ((Element)var8.get(var13)).getChild("type").getText();
                  this.type = Integer.parseInt(var16);
                  CaissesOperations var17 = new CaissesOperations();
                  var17.setCaiopeCategorie(this.cat);
                  var17.setCaiopeCode(this.code);
                  var17.setCaiopeDateCreat(new Date());
                  var17.setCaiopeDateModif((Date)null);
                  var17.setCaiopeInactif(0);
                  var17.setCaiopeNom(this.nom);
                  var17.setCaiopeTransfert(this.trf);
                  var17.setCaiopeType(this.type);
                  var17.setCaiopeUserCreat(var3.getUsrid());
                  var17.setCaiopeUserModif(0L);
                  var11.save(var17);
               }

               var12.commit();
            } catch (HibernateException var23) {
               if (var12 != null) {
                  var12.rollback();
               }

               throw var23;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }
      } catch (JDOMException var25) {
      } catch (IOException var26) {
      }

   }

   public CaissesOperations insert(CaissesOperations var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "CaisseCommerciale");
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

   public CaissesOperations insert(CaissesOperations var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public CaissesOperations modif(CaissesOperations var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "CaisseCommerciale");
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

   public String delete(CaissesOperations var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "CaisseCommerciale");
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

      return null;
   }

   public List selectOperation(Session var1) {
      Query var2 = null;
      var2 = var1.createQuery("from CaissesOperations order by caiopeCode");
      Object var3 = new ArrayList();
      if (var2.list() != null) {
         var3 = var2.list();
      }

      return (List)var3;
   }

   public CaissesOperations selectOperationByCode(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "CaisseCommerciale");
         var3 = true;
      }

      new CaissesOperations();
      new ArrayList();
      Query var6 = var2.createQuery("from CaissesOperations where caiopeCode=:code order by caiopeCode").setParameter("code", var1).setMaxResults(1);
      List var5 = var6.list();
      CaissesOperations var4;
      if (var5.size() > 0) {
         var4 = (CaissesOperations)var5.get(0);
      } else {
         var4 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List selectActifOperation(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "CaisseCommerciale");
         var2 = true;
      }

      List var3 = var1.createQuery("from CaissesOperations where caiopeInactif=0 order by caiopeCode").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List selectActifOperationItems(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "CaisseCommerciale");
         var2 = true;
      }

      List var3 = var1.createQuery("from CaissesOperations where caiopeInactif=0 order by caiopeCode").list();
      List var4 = var3;
      ArrayList var5 = new ArrayList();
      if (var3 != null) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            new CaissesOperations();
            CaissesOperations var7 = (CaissesOperations)var4.get(var6);
            var5.add(new SelectItem(var7.getCaiopeCode() + ":" + var7.getCaiopeNom()));
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectActifOperation(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "CaisseCommerciale");
         var3 = true;
      }

      List var4 = null;
      if (var1 == 9) {
         var4 = var2.createQuery("from CaissesOperations where caiopeInactif=0 order by caiopeCode").list();
      } else {
         var4 = var2.createQuery("from CaissesOperations where caiopeInactif=0 and caiopeType=:typ order by caiopeCode").setInteger("typ", var1).list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public CaissesOperations selectOperation(String var1, Session var2) throws HibernateException, NamingException {
      new CaissesOperations();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "CaisseCommerciale");
         var4 = true;
      }

      Query var5 = var2.createQuery("from CaissesOperations where caiopeCode=:cod order by caiopeCode").setString("cod", var1);
      var5.setMaxResults(1);
      List var6 = var5.list();
      CaissesOperations var3;
      if (var6.size() != 0) {
         var3 = (CaissesOperations)var6.get(0);
      } else {
         var3 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }
}
