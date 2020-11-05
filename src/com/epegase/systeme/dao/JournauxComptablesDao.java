package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.JournauxComptables;
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
import javax.faces.component.UIInput;
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

public class JournauxComptablesDao implements Serializable {
   private String maBase;
   private UtilInitHibernate utilInitHibernate;
   private int nature;
   private String lib_FR;
   private String lib_UK;
   private String lib_SP;
   private String numero;
   private String treso;

   public JournauxComptablesDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public void ajoutParDefaut(ExercicesComptable var1, String var2, Structure var3, Users var4) throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      SAXBuilder var5 = new SAXBuilder();

      try {
         File var6 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "fiscalites" + File.separator + var2 + File.separator + "PLJ_" + var2 + ".xml");
         if (var6.exists()) {
            Document var7 = var5.build(new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "fiscalites" + File.separator + var2 + File.separator + "PLJ_" + var2 + ".xml"));
            Element var8 = var7.getRootElement();
            List var9 = var8.getChildren();
            Session var10 = this.utilInitHibernate.getOpenSession(this.maBase, "JournauxComptables");
            Transaction var11 = null;

            try {
               var11 = var10.beginTransaction();

               for(int var12 = 0; var12 < var9.size(); ++var12) {
                  this.numero = ((Element)var9.get(var12)).getChild("code").getText();
                  this.lib_FR = ((Element)var9.get(var12)).getChild("lib_FR").getText();
                  this.lib_UK = ((Element)var9.get(var12)).getChild("lib_UK").getText();
                  this.lib_SP = ((Element)var9.get(var12)).getChild("lib_SP").getText();
                  this.treso = ((Element)var9.get(var12)).getChild("compteTreso").getText();
                  String var13 = ((Element)var9.get(var12)).getChild("nature").getText();
                  this.nature = Integer.parseInt(var13);
                  JournauxComptables var14 = new JournauxComptables();
                  var14.setExercice(var1);
                  var14.setPljBudjet((String)null);
                  var14.setPljChoixDevise(var3.getStrdevise());
                  var14.setPljCode(this.numero);
                  var14.setPljCompteTreso(this.treso);
                  var14.setPljDateCreat(new Date());
                  var14.setPljDateModif((Date)null);
                  var14.setPljDvAbhp(0);
                  var14.setPljDvAbsp(0);
                  var14.setPljFormatDevise(var3.getStrformatdevise());
                  var14.setPljInactif(0);
                  var14.setPljInactifFR((String)null);
                  var14.setPljLibelleFr(this.lib_FR);
                  var14.setPljLibelleSp(this.lib_SP);
                  var14.setPljLibelleUk(this.lib_UK);
                  var14.setPljModeTreso(0);
                  var14.setPljNature(this.nature);
                  var14.setPljPiece(2);
                  var14.setPljReserve(0);
                  var14.setPljScenario(0);
                  var14.setPljTypeDevise(0);
                  var14.setPljUserCreat(var4.getUsrid());
                  var14.setPljUserModif(0L);
                  var14.setUIpljCode((UIInput)null);
                  var10.save(var14);
               }

               var11.commit();
            } catch (HibernateException var20) {
               if (var11 != null) {
                  var11.rollback();
               }

               throw var20;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }
      } catch (JDOMException var22) {
      } catch (IOException var23) {
      }

   }

   public void maJJournauxComptables(JournauxComptables var1, Session var2) {
      var2.update(var1);
   }

   public JournauxComptables save(JournauxComptables var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "JournauxComptables");
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

   public JournauxComptables insert(JournauxComptables var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public JournauxComptables modif(JournauxComptables var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "JournauxComptables");
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

   public JournauxComptables modif(JournauxComptables var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(JournauxComptables var1, Session var2) {
      var2.delete(var1);
   }

   public void removeSelectedJC(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.maBase, "JournauxComptables");
      Transaction var4 = var3.beginTransaction();
      var3.createQuery("delete from JournauxComptables where pljId=:Id").setLong("Id", var1).executeUpdate();
      var4.commit();
      this.utilInitHibernate.closeSession();
   }

   public void copiertouslesJournaux(List var1, ExercicesComptable var2) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.maBase, "JournauxComptables");
      Transaction var4 = var3.beginTransaction();

      for(int var5 = 0; var5 < var1.size(); ++var5) {
         JournauxComptables var6 = (JournauxComptables)var1.get(var5);
         var6.setExercice(var2);
         var3.save(var6);
      }

      var4.commit();
      this.utilInitHibernate.closeSession();
   }

   public List chargerLesJournauxComptables(long var1, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "JournauxComptables");
         var5 = true;
      }

      Query var6 = null;
      if (var3 == 1) {
         var6 = var4.createQuery("from JournauxComptables where exercice.execpt_id=:exo and pljReserve=0 order by pljCode").setLong("exo", var1);
      } else {
         var6 = var4.createQuery("from JournauxComptables where exercice.execpt_id=:exo order by pljCode").setLong("exo", var1);
      }

      List var7 = var6.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerLesJournauxComptablesByProjet(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "JournauxComptables");
         var3 = true;
      }

      Query var4 = var2.createQuery("from JournauxComptables where pljProjet= '" + var1 + "' group by pljCode order by pljCode");
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesComptesTreso(int var1, int var2, long var3, String var5, Session var6) throws HibernateException, NamingException {
      boolean var7 = false;
      if (var6 == null) {
         var6 = this.utilInitHibernate.getOpenSession(this.maBase, "JournauxComptables");
         var7 = true;
      }

      Query var8 = null;
      if (var2 == 1) {
         var8 = var6.createQuery("FROM PlanComptable where plcNature=:nat AND plcInactif=0 and plcFiscalite=:fis AND exercicesComptable=:exo group by plcCompte").setInteger("nat", var1).setString("fis", var5).setLong("exo", var3);
      } else {
         var8 = var6.createQuery("FROM PlanComptable where plcNature=:nat AND plcInactif=0 and plcFiscalite=:fis AND exercicesComptable=:exo group by plcCompte").setInteger("nat", var1).setString("fis", var5).setLong("exo", var3);
      }

      List var9 = var8.list();
      if (var7) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public boolean existCode(String var1, long var2, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "JournauxComptables");
         var5 = true;
      }

      boolean var6 = false;
      Query var7 = var4.createQuery("from JournauxComptables ja where ja.pljCode=:cod AND  ja.exercice.execpt_id=:exo").setString("cod", var1).setLong("exo", var2);
      var7.setMaxResults(1);
      List var8 = var7.list();
      if (var8.size() > 0) {
         var6 = true;
      } else {
         var6 = false;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List verifJCExit(long var1, int var3) throws HibernateException, NamingException {
      Session var4 = this.utilInitHibernate.getOpenSession(this.maBase, "JournauxComptables");
      Query var5 = var4.createQuery("from JournauxComptables where exercice.execpt_id=:exo and pljNature=:n ").setLong("exo", var1).setInteger("n", var3);
      List var6 = var5.list();
      this.utilInitHibernate.closeSession();
      return var6;
   }

   public JournauxComptables chercherCode(String var1, long var2, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "JournauxComptables");
         var5 = true;
      }

      new JournauxComptables();
      Query var7 = null;
      if (var2 == 0L) {
         var7 = var4.createQuery("from JournauxComptables where pljCode=:cod group by pljCode").setString("cod", var1).setMaxResults(1);
      } else {
         var7 = var4.createQuery("from JournauxComptables where pljCode=:cod and exercice.execpt_id=:exo").setString("cod", var1).setLong("exo", var2).setMaxResults(1);
      }

      List var8 = var7.list();
      JournauxComptables var6;
      if (var8.size() > 0) {
         var6 = (JournauxComptables)var8.get(0);
      } else {
         var6 = null;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public JournauxComptables chercherType(int var1, long var2, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "JournauxComptables");
         var5 = true;
      }

      new JournauxComptables();
      Query var7 = null;
      if (var2 == 0L) {
         var7 = var4.createQuery("from JournauxComptables where pljNature=:cod group by pljCode").setInteger("cod", var1).setMaxResults(1);
      } else {
         var7 = var4.createQuery("from JournauxComptables where pljNature=:cod and exercice.execpt_id=:exo").setInteger("cod", var1).setLong("exo", var2).setMaxResults(1);
      }

      List var8 = var7.list();
      JournauxComptables var6;
      if (var8.size() > 0) {
         var6 = (JournauxComptables)var8.get(0);
      } else {
         var6 = null;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List mesjournauxActifs(long var1, String var3, int var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "JournauxComptables");
         var6 = true;
      }

      Query var7 = null;
      if (var3 != null && !var3.isEmpty()) {
         if (var4 == 1) {
            var7 = var5.createQuery("from JournauxComptables ja where ja.pljInactif=0 and ja.exercice.execpt_id=" + var1 + " and ja.pljCode not in(" + var3 + ") and ja.pljReserve=0 order by pljCode asc");
         } else {
            var7 = var5.createQuery("from JournauxComptables ja where ja.pljInactif=0 and ja.exercice.execpt_id=" + var1 + " and ja.pljCode not in(" + var3 + ") order by pljCode asc");
         }
      } else if (var4 == 1) {
         var7 = var5.createQuery("from JournauxComptables ja where ja.pljInactif=0 and ja.exercice.execpt_id=" + var1 + "  and ja.pljReserve=0 order by pljCode asc");
      } else {
         var7 = var5.createQuery("from JournauxComptables ja where ja.pljInactif=0 and ja.exercice.execpt_id=" + var1 + " order by pljCode asc");
      }

      List var8 = var7.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List unJournalActif(long var1, String var3, int var4, String var5, Session var6) throws HibernateException, NamingException {
      boolean var7 = false;
      if (var6 == null) {
         var6 = this.utilInitHibernate.getOpenSession(this.maBase, "JournauxComptables");
         var7 = true;
      }

      Query var8 = null;
      if (var3 != null && !var3.isEmpty()) {
         if (var4 == 1) {
            var8 = var6.createQuery("from JournauxComptables ja where ja.pljInactif=0 and ja.exercice.execpt_id=" + var1 + " and ja.pljCode not in(" + var3 + ") and ja.pljCode='" + var5 + "' and ja.pljReserve=0 order by pljCode asc");
         } else {
            var8 = var6.createQuery("from JournauxComptables ja where ja.pljInactif=0 and ja.exercice.execpt_id=" + var1 + " and ja.pljCode not in(" + var3 + ") and ja.pljCode='" + var5 + "' order by pljCode asc");
         }
      } else if (var4 == 1) {
         var8 = var6.createQuery("from JournauxComptables ja where ja.pljInactif=0 and ja.exercice.execpt_id=" + var1 + "  and ja.pljReserve=0 and ja.pljCode='" + var5 + "' order by pljCode asc");
      } else {
         var8 = var6.createQuery("from JournauxComptables ja where ja.pljInactif=0 and ja.exercice.execpt_id=" + var1 + " and ja.pljCode='" + var5 + "' order by pljCode asc");
      }

      List var9 = var8.list();
      if (var7) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public List mesjournauxActifsItems(long var1, String var3, int var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "JournauxComptables");
         var6 = true;
      }

      Query var7 = null;
      if (var3 != null && !var3.isEmpty()) {
         if (var4 == 1) {
            var7 = var5.createQuery("from JournauxComptables ja where ja.pljInactif=0 and ja.exercice.execpt_id=" + var1 + " and ja.pljCode not in(" + var3 + ") and ja.pljReserve=0 order by pljCode asc");
         } else {
            var7 = var5.createQuery("from JournauxComptables ja where ja.pljInactif=0 and ja.exercice.execpt_id=" + var1 + " and ja.pljCode not in(" + var3 + ") order by pljCode asc");
         }
      } else if (var4 == 1) {
         var7 = var5.createQuery("from JournauxComptables ja where ja.pljInactif=0 and ja.exercice.execpt_id=" + var1 + "  and ja.pljReserve=0 order by pljCode asc");
      } else {
         var7 = var5.createQuery("from JournauxComptables ja where ja.pljInactif=0 and ja.exercice.execpt_id=" + var1 + " order by pljCode asc");
      }

      List var8 = var7.list();
      ArrayList var9 = new ArrayList();
      if (var8.size() != 0) {
         for(int var10 = 0; var10 < var8.size(); ++var10) {
            new JournauxComptables();
            JournauxComptables var11 = (JournauxComptables)var8.get(var10);
            var9.add(new SelectItem(var11.getPljCode(), var11.getPljCode() + ":" + var11.getPljLibelleFr()));
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public List mesjournauxTresorerieActifs(long var1, String var3, int var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "JournauxComptables");
         var6 = true;
      }

      Query var7 = null;
      if (var3 != null && !var3.isEmpty()) {
         if (var4 == 1) {
            var7 = var5.createQuery("from JournauxComptables ja where (ja.pljNature>=7 and ja.pljNature<=10) and ja.pljInactif=0 and ja.exercice.execpt_id=" + var1 + " and ja.pljCode not in(" + var3 + ") and ja.pljReserve=0 order by ja.pljCode asc");
         } else {
            var7 = var5.createQuery("from JournauxComptables ja where (ja.pljNature>=7 and ja.pljNature<=10) and ja.pljInactif=0 and ja.exercice.execpt_id=" + var1 + " and ja.pljCode not in(" + var3 + ") order by ja.pljCode asc");
         }
      } else if (var4 == 1) {
         var7 = var5.createQuery("from JournauxComptables ja where (ja.pljNature>=7 and ja.pljNature<=10) and ja.pljInactif=0 and ja.exercice.execpt_id=" + var1 + "  and ja.pljReserve=0 order by ja.pljCode asc");
      } else {
         var7 = var5.createQuery("from JournauxComptables ja where (ja.pljNature>=7 and ja.pljNature<=10) and ja.pljInactif=0 and ja.exercice.execpt_id=" + var1 + " order by ja.pljCode asc");
      }

      List var8 = var7.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List mesjournauxBanquesActifs(long var1, String var3, int var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "JournauxComptables");
         var6 = true;
      }

      Query var7 = null;
      if (var3 != null && !var3.isEmpty()) {
         if (var4 == 1) {
            var7 = var5.createQuery("from JournauxComptables ja where (ja.pljNature>=7 and ja.pljNature<=8) and ja.pljInactif=0 and ja.exercice.execpt_id=" + var1 + " and ja.pljCode not in(" + var3 + ") and ja.pljReserve=0 order by ja.pljCode asc");
         } else {
            var7 = var5.createQuery("from JournauxComptables ja where (ja.pljNature>=7 and ja.pljNature<=8) and ja.pljInactif=0 and ja.exercice.execpt_id=" + var1 + " and ja.pljCode not in(" + var3 + ") order by ja.pljCode asc");
         }
      } else if (var4 == 1) {
         var7 = var5.createQuery("from JournauxComptables ja where (ja.pljNature>=7 and ja.pljNature<=8) and ja.pljInactif=0 and ja.exercice.execpt_id=" + var1 + "  and ja.pljReserve=0 order by ja.pljCode asc");
      } else {
         var7 = var5.createQuery("from JournauxComptables ja where (ja.pljNature>=7 and ja.pljNature<=8) and ja.pljInactif=0 and ja.exercice.execpt_id=" + var1 + " order by ja.pljCode asc");
      }

      List var8 = var7.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List mesjournauxCaissesActifs(long var1, String var3, int var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "JournauxComptables");
         var6 = true;
      }

      Query var7 = null;
      if (var3 != null && !var3.isEmpty()) {
         if (var4 == 1) {
            var7 = var5.createQuery("from JournauxComptables ja where (ja.pljNature>=9 and ja.pljNature<=10) and ja.pljInactif=0 and ja.exercice.execpt_id=" + var1 + " and ja.pljCode not in(" + var3 + ") and ja.pljReserve=0 order by ja.pljCode asc");
         } else {
            var7 = var5.createQuery("from JournauxComptables ja where (ja.pljNature>=9 and ja.pljNature<=10) and ja.pljInactif=0 and ja.exercice.execpt_id=" + var1 + " and ja.pljCode not in(" + var3 + ") order by ja.pljCode asc");
         }
      } else if (var4 == 1) {
         var7 = var5.createQuery("from JournauxComptables ja where (ja.pljNature>=9 and ja.pljNature<=10) and ja.pljInactif=0 and ja.exercice.execpt_id=" + var1 + "  and ja.pljReserve=0 order by ja.pljCode asc");
      } else {
         var7 = var5.createQuery("from JournauxComptables ja where (ja.pljNature>=9 and ja.pljNature<=10) and ja.pljInactif=0 and ja.exercice.execpt_id=" + var1 + " order by ja.pljCode asc");
      }

      List var8 = var7.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List chargerLesJournaux(ExercicesComptable var1, int var2, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "JournauxComptables");
         var5 = true;
      }

      Query var6 = null;
      Object var7 = new ArrayList();
      if (var3 == 1) {
         if (var2 == 0) {
            var6 = var4.createQuery("From JournauxComptables where exercice=:exo and pljReserve=0 and pljInactif=0 and pljNature in (9,10)").setParameter("exo", var1);
            var7 = var6.list();
         } else if (var2 == 1) {
            var6 = var4.createQuery("From JournauxComptables where exercice=:exo and pljReserve=0 and pljInactif=0 and pljNature in (7,8)").setParameter("exo", var1);
            var7 = var6.list();
         } else if (var2 == 2) {
            var6 = var4.createQuery("From JournauxComptables where exercice=:exo and pljReserve=0 and pljInactif=0 and pljNature in (7,8,9,10)").setParameter("exo", var1);
            var7 = var6.list();
         } else if (var2 == 3) {
            var6 = var4.createQuery("From JournauxComptables where exercice=:exo and pljReserve=0 and pljInactif=0 and pljNature in (3)").setParameter("exo", var1);
            var7 = var6.list();
         }
      } else if (var2 == 0) {
         var6 = var4.createQuery("From JournauxComptables where exercice=:exo and pljInactif=0 and pljNature in (9,10)").setParameter("exo", var1);
         var7 = var6.list();
      } else if (var2 == 1) {
         var6 = var4.createQuery("From JournauxComptables where exercice=:exo and pljInactif=0 and pljNature in (7,8)").setParameter("exo", var1);
         var7 = var6.list();
      } else if (var2 == 2) {
         var6 = var4.createQuery("From JournauxComptables where exercice=:exo and pljInactif=0 and pljNature in (7,8,9,10)").setParameter("exo", var1);
         var7 = var6.list();
      } else if (var2 == 3) {
         var6 = var4.createQuery("From JournauxComptables where exercice=:exo and pljInactif=0 and pljNature in (3)").setParameter("exo", var1);
         var7 = var6.list();
      }

      ArrayList var8 = new ArrayList();
      if (((List)var7).size() != 0) {
         for(int var9 = 0; var9 < ((List)var7).size(); ++var9) {
            var8.add(new SelectItem(((JournauxComptables)((List)var7).get(var9)).getPljCode() + ":" + ((JournauxComptables)((List)var7).get(var9)).getPljLibelleFr()));
         }
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List chargerLesJournaux(ExercicesComptable var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "JournauxComptables");
         var3 = true;
      }

      Query var4 = null;
      new ArrayList();
      var4 = var2.createQuery("From JournauxComptables where exercice=:exo and pljInactif=0 and pljNature in (7,8)").setParameter("exo", var1);
      List var5 = var4.list();
      ArrayList var6 = new ArrayList();
      if (var5.size() != 0) {
         for(int var7 = 0; var7 < var5.size(); ++var7) {
            var6.add(new SelectItem(((JournauxComptables)var5.get(var7)).getPljCode(), ((JournauxComptables)var5.get(var7)).getPljCode() + ":" + ((JournauxComptables)var5.get(var7)).getPljLibelleFr()));
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List touslesJounauxComptable(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "JournauxComptables");
         var3 = true;
      }

      Query var4 = null;
      if (var1 == 1) {
         var4 = var2.createQuery("from JournauxComptables ja where ja.pljReserve=0 and ja.pljInactif=0 group by pljCode order by pljCode asc");
      } else {
         var4 = var2.createQuery("from JournauxComptables ja where ja.pljInactif=0 group by pljCode order by pljCode asc");
      }

      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public JournauxComptables rechercheJCByCode(String var1, int var2, long var3, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "JournauxComptables");
         var6 = true;
      }

      Query var7 = null;
      if (var2 == 1) {
         var7 = var5.createQuery("from JournauxComptables ja where ja.pljCode=:cod AND ja.pljReserve=0 and ja.exercice.execpt_id=:exo order by pljCode asc").setString("cod", var1).setLong("exo", var3);
      } else {
         var7 = var5.createQuery("from JournauxComptables ja where ja.pljCode=:cod AND  ja.exercice.execpt_id=:exo order by pljCode asc").setString("cod", var1).setLong("exo", var3);
      }

      var7.setMaxResults(1);
      List var8 = var7.list();
      JournauxComptables var9 = new JournauxComptables();
      if (var8.size() > 0) {
         var9 = (JournauxComptables)var8.get(0);
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public JournauxComptables rechercheJCByCompte(String var1, long var2, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "JournauxComptables");
         var5 = true;
      }

      Query var6 = var4.createQuery("from JournauxComptables where pljCompteTreso=:cpte and exercice.execpt_id=:exo order by pljCode asc").setString("cpte", var1).setLong("exo", var2);
      var6.setMaxResults(1);
      List var7 = var6.list();
      new JournauxComptables();
      JournauxComptables var8;
      if (var7.size() > 0) {
         var8 = (JournauxComptables)var7.get(0);
      } else {
         var8 = null;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }
}
