package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Ecritures;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.PlanComptable;
import com.epegase.systeme.classe.Racines;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class PlanComptableDao implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private int sens;
   private int nature;
   private String lib_FR;
   private String lib_UK;
   private String lib_SP;
   private long userCreat;
   private String numeroCompteAjout;
   private int nbrcaracte = 10;
   private String numero;
   private String inserLibNatFR;
   private String inserLibNatSP;
   private String inserLibNatUK;
   private ExercicesComptableDao exercicesComptableDao;
   private ExercicesComptable exercicesComptable;
   private PlanComptable planComptable;
   private String mabase;
   private int choixRacine;
   private String selecFiscalite;

   public PlanComptableDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public void ajoutParDefaut(String var1, int var2, ExercicesComptable var3) throws JDOMException, IOException, HibernateException, NamingException {
      SAXBuilder var4 = new SAXBuilder();

      try {
         File var5 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "fiscalites" + File.separator + var1 + File.separator + "PLC_" + var1 + ".xml");
         if (var5.exists()) {
            Document var6 = var4.build(var5);
            Element var7 = var6.getRootElement();
            List var8 = var7.getChildren();
            String var9 = "";
            String var10 = "";
            boolean var11 = false;
            Session var12 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
            Transaction var13 = null;

            try {
               var13 = var12.beginTransaction();

               for(int var14 = 0; var14 < var8.size(); ++var14) {
                  this.lib_FR = ((Element)var8.get(var14)).getChild("lib_FR").getText();
                  this.lib_UK = ((Element)var8.get(var14)).getChild("lib_UK").getText();
                  this.lib_SP = ((Element)var8.get(var14)).getChild("lib_SP").getText();
                  this.numero = ((Element)var8.get(var14)).getChild("code").getText();
                  this.planComptable = new PlanComptable();
                  String var15 = ((Element)var8.get(var14)).getChild("nature").getText();
                  this.convertNature(var15);
                  this.nature = Integer.parseInt(var15);
                  var9 = ((Element)var8.get(var14)).getChild("racine").getText();
                  var10 = ((Element)var8.get(var14)).getChild("libre").getText();
                  String var16 = ((Element)var8.get(var14)).getChild("sens").getText();
                  int var26 = Integer.parseInt(var16);
                  this.recupererComplemenNum(var2);
                  this.planComptable.setPlcFiscalite(var1);
                  this.planComptable.setPlcCompte(this.numeroCompteAjout);
                  this.planComptable.setPlcNature(this.nature);
                  this.planComptable.setPlcSens(var26);
                  this.planComptable.setPlcCodeRacine(var9);
                  this.planComptable.setPlcLibelleCpteFR(this.lib_FR);
                  this.planComptable.setPlcLibelleCpteUK(this.lib_UK);
                  this.planComptable.setPlcLibelleCpteSP(this.lib_SP);
                  this.planComptable.setPlcLibelleRacineFR(this.lib_FR);
                  this.planComptable.setPlcLibelleRacineUK(this.lib_UK);
                  this.planComptable.setPlcLibelleRacineSP(this.lib_SP);
                  this.planComptable.setPlcLibelleNatureFR(this.inserLibNatFR);
                  this.planComptable.setPlcLibelleNatureUK(this.inserLibNatUK);
                  this.planComptable.setPlcLibelleNatureSP(this.inserLibNatSP);
                  this.planComptable.setPlcLibre(this.recupererComplemenNum(var2));
                  this.planComptable.setPlcUserCreat(this.userCreat);
                  this.planComptable.setPlcDateCreat(new Date());
                  this.planComptable.setExercicesComptable(var3);
                  var12.save(this.planComptable);
               }

               var13.commit();
            } catch (HibernateException var22) {
               if (var13 != null) {
                  var13.rollback();
               }

               throw var22;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }
      } catch (JDOMException var24) {
      } catch (IOException var25) {
      }

   }

   public String recupererComplemenNum(int var1) {
      String var3 = this.numero;
      int var4 = var3.length();
      int var5 = var1 - var4;
      String var6 = "";
      if (var5 != 0) {
         String[] var7 = new String[var5];

         for(int var8 = 0; var8 < var5; ++var8) {
            var7[var8] = "0";
            var6 = var6.concat(var7[var8]);
            this.numeroCompteAjout = this.numero + var6;
         }
      } else {
         this.numeroCompteAjout = this.numero;
      }

      if (this.numeroCompteAjout.length() > var1) {
         this.numeroCompteAjout.substring(0, var1);
      }

      int var9 = var1 - this.numeroCompteAjout.length();
      String var10 = this.numeroCompteAjout;
      if (var9 == 1) {
         var10 = var10 + "0";
      } else if (var9 == 2) {
         var10 = var10 + "00";
      } else if (var9 == 3) {
         var10 = var10 + "000";
      } else if (var9 == 4) {
         var10 = var10 + "0000";
      } else if (var9 == 5) {
         var10 = var10 + "00000";
      } else if (var9 == 6) {
         var10 = var10 + "000000";
      } else if (var9 == 7) {
         var10 = var10 + "0000000";
      } else if (var9 == 8) {
         var10 = var10 + "00000000";
      } else if (var9 == 9) {
         var10 = var10 + "000000000";
      } else if (var9 == 10) {
         var10 = var10 + "0000000000";
      } else if (var9 == 11) {
         var10 = var10 + "00000000000";
      } else if (var9 == 12) {
         var10 = var10 + "000000000000";
      } else if (var9 == 13) {
         var10 = var10 + "0000000000000";
      } else if (var9 == 14) {
         var10 = var10 + "00000000000000";
      } else if (var9 == 15) {
         var10 = var10 + "000000000000000";
      } else if (var9 == 16) {
         var10 = var10 + "0000000000000000";
      } else if (var9 == 17) {
         var10 = var10 + "00000000000000000";
      } else if (var9 == 18) {
         var10 = var10 + "000000000000000000";
      } else if (var9 == 19) {
         var10 = var10 + "0000000000000000000";
      }

      return var6;
   }

   public PlanComptable ajouteCompte(String var1, int var2, String var3, String var4, ExercicesComptable var5, Structure var6, Session var7) throws NamingException {
      this.planComptable = new PlanComptable();
      new ArrayList();
      new Racines();
      RacinesDao var10 = new RacinesDao(this.mabase, var6, this.utilInitHibernate);
      List var8 = var10.chargerMesRacinesUtiles(var1, var7);
      boolean var11 = false;
      if (var8.size() != 0) {
         for(int var12 = 0; var12 < var8.size(); ++var12) {
            Racines var9 = (Racines)var8.get(var12);
            if (var3.startsWith(var9.getRacCode())) {
               this.numero = var9.getRacCode();
               this.planComptable.setPlcFiscalite(var1);
               this.planComptable.setPlcCompte(var3);
               this.planComptable.setPlcNature(Integer.parseInt(var9.getRacCodenature()));
               this.planComptable.setPlcSens(0);
               this.planComptable.setPlcCodeRacine(var9.getRacCode());
               this.planComptable.setPlcLibelleCpteFR(var4);
               this.planComptable.setPlcLibelleCpteUK("");
               this.planComptable.setPlcLibelleCpteSP("");
               this.planComptable.setPlcLibelleRacineFR(var9.getRacLibelleFr());
               this.planComptable.setPlcLibelleRacineUK(var9.getRacLibelleSp());
               this.planComptable.setPlcLibelleRacineSP(var9.getRacLibelleUk());
               this.planComptable.setPlcLibelleNatureFR(var9.getLib_nature());
               this.planComptable.setPlcLibelleNatureUK("");
               this.planComptable.setPlcLibelleNatureSP("");
               this.planComptable.setPlcLibre(this.recupererComplemenNum(var2));
               this.planComptable.setPlcUserCreat(this.userCreat);
               this.planComptable.setPlcDateCreat(new Date());
               this.planComptable.setExercicesComptable(var5);
               var7.save(this.planComptable);
               var11 = true;
               break;
            }
         }
      }

      if (!var11) {
         this.planComptable = null;
      }

      return this.planComptable;
   }

   public PlanComptable insert(PlanComptable var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
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

   public PlanComptable insert(PlanComptable var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public PlanComptable modif(PlanComptable var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
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

   public PlanComptable modif(PlanComptable var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(PlanComptable var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
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

   public void delete(PlanComptable var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public void copiertoutLeplanComptable(List var1, ExercicesComptable var2) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();

         for(int var5 = 0; var5 < var1.size(); ++var5) {
            PlanComptable var6 = (PlanComptable)var1.get(var5);
            var6.setExercicesComptable(var2);
            var3.save(var6);
         }

         var4.commit();
      } catch (HibernateException var10) {
         if (var4 != null) {
            var4.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }
   }

   public void updatePlanComptable(String var1, Session var2) throws HibernateException, NamingException {
      int var3 = var2.createQuery("update from PlanComptable set plcFiscalite ='" + var1 + "' where (plcFiscalite is null or plcFiscalite='')").executeUpdate();
   }

   public PlanComptable getFirstPC(ExercicesComptable var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
         var3 = true;
      }

      Query var4 = var2.createQuery("from PlanComptable where exercicesComptable=:ex and plcInactif=:b group by plcCompte order by plcCompte asc").setInteger("b", 0).setParameter("ex", var1).setMaxResults(1);
      List var5 = var4.list();
      new PlanComptable();
      PlanComptable var6;
      if (var5.size() > 0) {
         var6 = (PlanComptable)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public PlanComptable getLastPC(ExercicesComptable var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
         var3 = true;
      }

      Query var4 = var2.createQuery("from PlanComptable where exercicesComptable=:ex and plcInactif=:b group by plcCompte order by plcCompte desc").setInteger("b", 0).setParameter("ex", var1).setMaxResults(1);
      List var5 = var4.list();
      new PlanComptable();
      PlanComptable var6;
      if (var5.size() > 0) {
         var6 = (PlanComptable)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public PlanComptable getNextPC(String var1, ExercicesComptable var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
         var4 = true;
      }

      Query var5 = var3.createQuery("from PlanComptable where exercicesComptable=:ex and plcCompte>:numero and plcInactif=:b group by plcCompte order by plcCompte asc ").setString("numero", var1).setInteger("b", 0).setParameter("ex", var2).setMaxResults(1);
      List var6 = var5.list();
      new PlanComptable();
      PlanComptable var7;
      if (var6.size() > 0) {
         var7 = (PlanComptable)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public PlanComptable getPreviousPC(String var1, ExercicesComptable var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
         var4 = true;
      }

      Query var5 = var3.createQuery("from PlanComptable where exercicesComptable=:ex and plcCompte<:numero and plcInactif=:b group by plcCompte  order by plcCompte desc ").setString("numero", var1).setInteger("b", 0).setParameter("ex", var2).setMaxResults(1);
      List var6 = var5.list();
      new PlanComptable();
      PlanComptable var7;
      if (var6.size() > 0) {
         var7 = (PlanComptable)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerPlanComtableGene(String var1, long var2, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
         var5 = true;
      }

      Object var6 = new ArrayList();
      Query var7 = var4.createQuery(" from PlanComptable where plcNature<>6 and plcNature<>7 and plcNature<>8 and exercicesComptable=:exo and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte").setLong("exo", var2);
      if (var7.list().size() > 0) {
         var6 = var7.list();
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var6;
   }

   public List chargerPlanComtableNature(String var1, long var2, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
         var6 = true;
      }

      Object var7 = new ArrayList();
      Query var8 = null;
      if (var1 != null && !var1.isEmpty()) {
         var8 = var5.createQuery(" from PlanComptable where plcNature=:nat and exercicesComptable=:exo and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte").setString("nat", var4).setLong("exo", var2);
      } else {
         var8 = var5.createQuery(" from PlanComptable where plcNature=:nat and exercicesComptable=:exo group by plcCompte order by plcCompte").setString("nat", var4).setLong("exo", var2);
      }

      if (var8.list().size() > 0) {
         var7 = var8.list();
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var7;
   }

   public List chargerPcMvmtes(String var1, long var2, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
         var5 = true;
      }

      new ArrayList();
      EcrituresDao var7 = new EcrituresDao(this.mabase, this.utilInitHibernate);
      List var6 = var7.chargerEcriturePlc(var2, var4);
      Query var8 = var4.createQuery("from PlanComptable where exercicesComptable=:exo and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte").setLong("exo", var2);
      new ArrayList();
      ArrayList var10 = new ArrayList();
      List var9 = var8.list();

      for(int var11 = 0; var11 < var9.size(); ++var11) {
         this.planComptable = (PlanComptable)var9.get(var11);
         boolean var12 = false;

         for(int var13 = 0; var13 < var6.size(); ++var13) {
            String var14 = ((String)var6.get(var13)).toString();
            if (this.planComptable.getPlcCompte().equals(var14)) {
               var12 = true;
               break;
            }
         }

         if (var12) {
            var10.add(this.planComptable);
         }
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List chargerNatueFiscMvmtes(String var1, long var2, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
         var6 = true;
      }

      new ArrayList();
      EcrituresDao var8 = new EcrituresDao(this.mabase, this.utilInitHibernate);
      List var7 = var8.chargerEcriturePlc(var2, var5);
      String[] var9 = var4.split(":");
      String var10 = var9[0];
      int var11 = Integer.parseInt(var10);
      Query var12 = var5.createQuery("from PlanComptable where plcNature=:codFisc and exercicesComptable=:exo and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte").setLong("exo", var2).setParameter("codFisc", var11);
      new ArrayList();
      ArrayList var14 = new ArrayList();
      List var13 = var12.list();

      for(int var15 = 0; var15 < var13.size(); ++var15) {
         this.planComptable = (PlanComptable)var13.get(var15);
         boolean var16 = false;

         for(int var17 = 0; var17 < var7.size(); ++var17) {
            String var18 = ((String)var7.get(var17)).toString();
            if (this.planComptable.getPlcCompte().equals(var18)) {
               var16 = true;
               break;
            }
         }

         if (var16) {
            var14.add(this.planComptable);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var14;
   }

   public List chargerPcNonMvmtes(String var1, long var2, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
         var5 = true;
      }

      new ArrayList();
      EcrituresDao var7 = new EcrituresDao(this.mabase, this.utilInitHibernate);
      List var6 = var7.chargerEcriturePlc(var2, var4);
      Query var8 = var4.createQuery("from PlanComptable where exercicesComptable=:exo and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte").setLong("exo", var2);
      new ArrayList();
      ArrayList var10 = new ArrayList();
      List var9 = var8.list();

      for(int var11 = 0; var11 < var9.size(); ++var11) {
         this.planComptable = (PlanComptable)var9.get(var11);
         boolean var12 = false;

         for(int var13 = 0; var13 < var6.size(); ++var13) {
            String var14 = ((String)var6.get(var13)).toString();
            if (this.planComptable.getPlcCompte().equals(var14)) {
               var12 = true;
               break;
            }
         }

         if (!var12) {
            var10.add(this.planComptable);
         }
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List chargerNatueFiscNonMvmtes(String var1, long var2, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
         var6 = true;
      }

      new ArrayList();
      EcrituresDao var8 = new EcrituresDao(this.mabase, this.utilInitHibernate);
      List var7 = var8.chargerEcriturePlc(var2, var5);
      String[] var9 = var4.split(":");
      String var10 = var9[0];
      int var11 = Integer.parseInt(var10);
      Query var12 = var5.createQuery("from PlanComptable where plcNature=:codFisc and exercicesComptable=:exo and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte").setLong("exo", var2).setParameter("codFisc", var11);
      new ArrayList();
      ArrayList var14 = new ArrayList();
      List var13 = var12.list();

      for(int var15 = 0; var15 < var13.size(); ++var15) {
         this.planComptable = (PlanComptable)var13.get(var15);
         boolean var16 = false;

         for(int var17 = 0; var17 < var7.size(); ++var17) {
            String var18 = ((String)var7.get(var17)).toString();
            if (this.planComptable.getPlcCompte().equals(var18)) {
               var16 = true;
               break;
            }
         }

         if (!var16) {
            var14.add(this.planComptable);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var14;
   }

   public List chargerPlanComtableAnalytique(String var1, long var2, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
         var5 = true;
      }

      new ArrayList();
      Query var7 = var4.createQuery(" from PlanComptable where ((plcAnalCle1 is NOT NULL and plcAnalCle1<>'') or (plcAnalCle2 is NOT NULL and plcAnalCle2<>'')) and exercicesComptable=:exo  and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte").setLong("exo", var2);
      List var6 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerPlanComtableAnalytique(String var1, long var2, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
         var6 = true;
      }

      new ArrayList();
      Query var8 = var5.createQuery(" from PlanComptable where plcNature=:cod and ((plcAnalCle1 is NOT NULL and plcAnalCle1<>'') or (plcAnalCle2 is NOT NULL and plcAnalCle2<>'')) and exercicesComptable=:exo  and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte").setLong("exo", var2).setString("cod", var4);
      List var7 = var8.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public String filtreCaracteres(String var1) {
      String var2 = "";
      if (var1 != null && !var1.isEmpty()) {
         String var3 = "";

         for(int var4 = 0; var4 < var1.length(); ++var4) {
            var3 = (String)var1.subSequence(var4, var4 + 1);
            if (" ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890".contains(var3)) {
               var2 = var2 + var3.toUpperCase();
            }
         }
      }

      return var2;
   }

   public boolean existeCompte(String var1, String var2, long var3, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
         var6 = true;
      }

      boolean var7 = false;
      Query var8 = var5.createQuery("from PlanComptable where plcCompte=:cpt and exercicesComptable=:exo and plcFiscalite='" + var1 + "'").setString("cpt", var2).setLong("exo", var3).setMaxResults(1);
      new ArrayList();
      List var9 = var8.list();
      if (var9.size() > 0) {
         var7 = true;
      } else {
         var7 = false;
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public PlanComptable chercherCompte(String var1, String var2, long var3, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
         var6 = true;
      }

      new PlanComptable();
      Query var8 = null;
      if (var1 != null && !var1.isEmpty()) {
         if (var3 == 0L) {
            var8 = var5.createQuery("from PlanComptable where plcCompte like '" + var2 + "%' and plcFiscalite='" + var1 + "'").setMaxResults(1);
         } else {
            var8 = var5.createQuery("from PlanComptable where plcCompte like '" + var2 + "%' and exercicesComptable=:exo and plcFiscalite='" + var1 + "'").setLong("exo", var3).setMaxResults(1);
         }
      } else if (var3 == 0L) {
         var8 = var5.createQuery("from PlanComptable where plcCompte like '" + var2 + "%'").setMaxResults(1);
      } else {
         var8 = var5.createQuery("from PlanComptable where plcCompte like '" + var2 + "%' and exercicesComptable=:exo").setLong("exo", var3).setMaxResults(1);
      }

      new ArrayList();
      List var9 = var8.list();
      PlanComptable var7;
      if (var9.size() > 0) {
         var7 = (PlanComptable)var9.get(0);
      } else {
         var7 = null;
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public PlanComptable chercherCompteSage(String var1, String var2, String var3, long var4, Session var6) throws HibernateException, NamingException {
      boolean var7 = false;
      if (var6 == null) {
         var6 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
         var7 = true;
      }

      String var8 = var2.substring(0, 4);
      new PlanComptable();
      Query var10 = null;
      if (var1 != null && !var1.isEmpty()) {
         if (var4 == 0L) {
            var10 = var6.createQuery("from PlanComptable where plcCompte like '" + var8 + "%' and plcSage = '" + var3 + "' and plcFiscalite='" + var1 + "'").setMaxResults(1);
         } else {
            var10 = var6.createQuery("from PlanComptable where plcCompte like '" + var8 + "%' and plcSage = '" + var3 + "' and exercicesComptable=:exo and plcFiscalite='" + var1 + "'").setLong("exo", var4).setMaxResults(1);
         }
      } else if (var4 == 0L) {
         var10 = var6.createQuery("from PlanComptable where plcCompte like '" + var8 + "%' and plcSage = '" + var3 + "'").setMaxResults(1);
      } else {
         var10 = var6.createQuery("from PlanComptable where plcCompte like '" + var8 + "%' and plcSage = '" + var3 + "' and exercicesComptable=:exo").setLong("exo", var4).setMaxResults(1);
      }

      new ArrayList();
      List var11 = var10.list();
      PlanComptable var9;
      if (var11.size() > 0) {
         var9 = (PlanComptable)var11.get(0);
      } else {
         var9 = null;
      }

      if (var7) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public PlanComptable chercherCompteStartWith(String var1, String var2, long var3, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
         var6 = true;
      }

      new PlanComptable();
      Query var8 = var5.createQuery("from PlanComptable where plcCompte like '" + var2 + "%' and exercicesComptable=:exo and plcFiscalite='" + var1 + "'").setLong("exo", var3).setMaxResults(1);
      new ArrayList();
      List var9 = var8.list();
      PlanComptable var7;
      if (var9.size() > 0) {
         var7 = (PlanComptable)var9.get(0);
      } else {
         var7 = null;
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public int calculeNbCompte(String var1, String var2, long var3, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
         var6 = true;
      }

      Query var7 = var5.createQuery("from PlanComptable where plcCodeRacine like '" + var2 + "%' and exercicesComptable=:exo and plcFiscalite='" + var1 + "'").setLong("exo", var3);
      new ArrayList();
      int var9 = 0;
      List var8 = var7.list();
      if (var8.size() != 0) {
         var9 = var8.size();
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public void convertNature(String var1) {
      if (var1.equalsIgnoreCase("1")) {
         this.inserLibNatFR = "capital";
         this.inserLibNatSP = "capitalESPAGNOLE";
         this.inserLibNatUK = "capital";
      } else if (var1.equalsIgnoreCase("2")) {
         this.inserLibNatFR = "resultat";
         this.inserLibNatSP = "resultESPAGNE";
         this.inserLibNatUK = "result";
      } else if (var1.equalsIgnoreCase("3")) {
         this.inserLibNatFR = "immobilisation";
         this.inserLibNatSP = "immobilisationESPAGNE";
         this.inserLibNatUK = "immobilization";
      } else if (var1.equalsIgnoreCase("4")) {
         this.inserLibNatFR = "Amort. et prov";
         this.inserLibNatSP = "Amort. et provESPAGNE";
         this.inserLibNatUK = "Depreciation";
      } else if (var1.equalsIgnoreCase("5")) {
         this.inserLibNatFR = "Stock";
         this.inserLibNatSP = "StockESPAGNE";
         this.inserLibNatUK = "Stock";
      } else if (var1.equalsIgnoreCase("6")) {
         this.inserLibNatFR = "fournisseur";
         this.inserLibNatSP = "fournisseurESPAGNE";
         this.inserLibNatUK = "provider";
      } else if (var1.equalsIgnoreCase("7")) {
         this.inserLibNatFR = "clients";
         this.inserLibNatSP = "clientsESPAGNE";
         this.inserLibNatUK = "Customers";
      } else if (var1.equalsIgnoreCase("8")) {
         this.inserLibNatFR = "personnels";
         this.inserLibNatSP = "personnels ESPAGNE";
         this.inserLibNatUK = "Personal";
      } else if (var1.equalsIgnoreCase("9")) {
         this.inserLibNatFR = "autres tiers";
         this.inserLibNatSP = "autres tiers ESPAGNE";
         this.inserLibNatUK = "other third";
      } else if (var1.equalsIgnoreCase("10")) {
         this.inserLibNatFR = "banques";
         this.inserLibNatSP = "bancos";
         this.inserLibNatUK = "bank";
      } else if (var1.equalsIgnoreCase("11")) {
         this.inserLibNatFR = "caisses";
         this.inserLibNatSP = "caisses ESPAGNE";
         this.inserLibNatUK = "funds";
      } else if (var1.equalsIgnoreCase("12")) {
         this.inserLibNatFR = "autres trésoreries";
         this.inserLibNatSP = "autres trésoreries ESPAGNE";
         this.inserLibNatUK = "Other Treasuries";
      } else if (var1.equalsIgnoreCase("14")) {
         this.inserLibNatFR = "BRS";
         this.inserLibNatSP = "BRS en espagnol";
         this.inserLibNatUK = "BRS";
      } else if (var1.equalsIgnoreCase("13")) {
         this.inserLibNatFR = "TVA";
         this.inserLibNatSP = "TVA en espagnol";
         this.inserLibNatUK = "VAT";
      } else if (var1.equalsIgnoreCase("15")) {
         this.inserLibNatFR = "autres etats";
         this.inserLibNatSP = "autres etats en espagnol";
         this.inserLibNatUK = "Other states";
      } else if (var1.equalsIgnoreCase("16")) {
         this.inserLibNatFR = "Charges";
         this.inserLibNatSP = "Charges en espagnol";
         this.inserLibNatUK = "Fillers";
      } else if (var1.equalsIgnoreCase("17")) {
         this.inserLibNatFR = "Produits";
         this.inserLibNatSP = "Produits en espagnol";
         this.inserLibNatUK = "products";
      } else if (var1.equalsIgnoreCase("18")) {
         this.inserLibNatFR = "Dotations";
         this.inserLibNatSP = "Dotations";
         this.inserLibNatUK = "Dotations";
      } else if (var1.equalsIgnoreCase("19")) {
         this.inserLibNatFR = "Réserves";
         this.inserLibNatSP = "Réserves";
         this.inserLibNatUK = "Réserves";
      } else if (var1.equalsIgnoreCase("20")) {
         this.inserLibNatFR = "Report à nouveaux";
         this.inserLibNatSP = "Report à nouveaux";
         this.inserLibNatUK = "Report à nouveaux";
      } else if (var1.equalsIgnoreCase("21")) {
         this.inserLibNatFR = "Subventions";
         this.inserLibNatSP = "Subventions";
         this.inserLibNatUK = "Subventions";
      } else if (var1.equalsIgnoreCase("22")) {
         this.inserLibNatFR = "Emprunts et dettes";
         this.inserLibNatSP = "Emprunts et dettes";
         this.inserLibNatUK = "Emprunts et dettes";
      } else if (var1.equalsIgnoreCase("23")) {
         this.inserLibNatFR = "Produits et charges HAO";
         this.inserLibNatSP = "Produits et charges HAO";
         this.inserLibNatUK = "Produits et charges HAO";
      } else if (var1.equalsIgnoreCase("24")) {
         this.inserLibNatFR = "Résultats";
         this.inserLibNatSP = "Résultats";
         this.inserLibNatUK = "Résultats";
      } else if (var1.equalsIgnoreCase("25")) {
         this.inserLibNatFR = "Plus ou moins value de cession";
         this.inserLibNatSP = "Plus ou moins value de cession";
         this.inserLibNatUK = "Plus ou moins value de cession";
      } else if (var1.equalsIgnoreCase("26")) {
         this.inserLibNatFR = "Provisions";
         this.inserLibNatSP = "Provisions";
         this.inserLibNatUK = "Provisions";
      } else if (var1.equalsIgnoreCase("27")) {
         this.inserLibNatFR = "Dépréciation";
         this.inserLibNatSP = "Dépréciation";
         this.inserLibNatUK = "Dépréciation";
      } else if (var1.equalsIgnoreCase("28")) {
         this.inserLibNatFR = "Dettes de location et acquisition";
         this.inserLibNatSP = "Dettes de location et acquisition";
         this.inserLibNatUK = "Dettes de location et acquisition";
      } else if (var1.equalsIgnoreCase("90")) {
         this.inserLibNatFR = "Attente";
         this.inserLibNatSP = "Attente";
         this.inserLibNatUK = "Attente";
      } else if (var1.equalsIgnoreCase("99")) {
         this.inserLibNatFR = "Aucune nature";
         this.inserLibNatSP = "Aucune nature";
         this.inserLibNatUK = "Aucune nature";
      }

   }

   public List numCptePlcompte(String var1, long var2) throws HibernateException, NamingException {
      new ArrayList();
      Session var5 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
      Query var6 = var5.createQuery("select distinct  plcCompte FROM PlanComptable where exercicesComptable=:exo and plcInactif=0 and plcFiscalite='" + var1 + "'").setLong("exo", var2);
      List var4 = var6.list();
      this.utilInitHibernate.closeSession();
      return var4;
   }

   public List lesplctablesMod(String var1, int var2, String var3) throws HibernateException, NamingException {
      Session var4 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
      List var5 = var4.createQuery("FROM PlanComptable where plcNature='" + var2 + "' and plcCompte<>'" + var3 + "' and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte").list();
      this.utilInitHibernate.closeSession();
      return var5;
   }

   public void ranPlancomptable(String var1, String var2, long var3) throws HibernateException, NamingException {
      Session var5 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
      Transaction var6 = var5.beginTransaction();
      String var7 = "update PlanComptable set plcRanDetaille=:ran where exercicesComptable=:idexo  plcNature IN " + var2 + " and plcFiscalite='" + var1 + "' group by plcCompte" + var2;
      int var8 = var5.createQuery(var7).setLong("idexo", var3).setBoolean("ran", true).executeUpdate();
      var6.commit();
      this.utilInitHibernate.closeSession();
   }

   public List VerificationPlanComptable(String var1, long var2, String var4, String var5) throws HibernateException, NamingException {
      new ArrayList();
      Session var7 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
      List var6 = var7.createQuery("from PlanComptable where  plcCodeRacine  " + var5 + "  " + var4 + " and exercicesComptable=:exo and plcNature Not in(11,12) and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte").setLong("exo", var2).list();
      this.utilInitHibernate.closeSession();
      return var6;
   }

   public List chargerPlanCmptChgeOrProd(String var1, long var2, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
         var6 = true;
      }

      List var7 = var5.createQuery("from PlanComptable where plcNature IN" + var4 + " and exercicesComptable=:exo and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte").setLong("exo", var2).list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerPlanCmptItems(String var1, long var2, String var4, int var5, Session var6) throws HibernateException, NamingException {
      boolean var7 = false;
      if (var6 == null) {
         var6 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
         var7 = true;
      }

      new ArrayList();
      List var8;
      if (var5 == 0) {
         if (var1 != null && !var1.isEmpty()) {
            var8 = var6.createQuery("from PlanComptable where plcNature IN" + var4 + " and exercicesComptable=:exo and plcFiscalite='" + var1 + "' and plcInactif=0  group by plcCompte order by plcLibelleCpteFR").setLong("exo", var2).list();
         } else {
            var8 = var6.createQuery("from PlanComptable where plcNature IN" + var4 + " and exercicesComptable=:exo and plcInactif=0  group by plcCompte order by plcLibelleCpteFR").setLong("exo", var2).list();
         }
      } else if (var1 != null && !var1.isEmpty()) {
         var8 = var6.createQuery("from PlanComptable where plcNature IN" + var4 + " and exercicesComptable=:exo and plcFiscalite='" + var1 + "' group by plcCompte order by plcLibelleCpteFR").setLong("exo", var2).list();
      } else {
         var8 = var6.createQuery("from PlanComptable where plcNature IN" + var4 + " and exercicesComptable=:exo group by plcCompte order by plcLibelleCpteFR").setLong("exo", var2).list();
      }

      ArrayList var9 = new ArrayList();
      if (var8.size() != 0) {
         new PlanComptable();

         for(int var11 = 0; var11 < var8.size(); ++var11) {
            PlanComptable var10 = (PlanComptable)var8.get(var11);
            if (var10.getPlcLibelleCpteFR() != null && !var10.getPlcLibelleCpteFR().isEmpty()) {
               var9.add(new SelectItem(var10.getPlcCompte(), var10.getPlcCompte() + ":" + this.filtreCaracteres(var10.getPlcLibelleCpteFR())));
            }
         }
      }

      if (var7) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public List chargerPlanComptableImp(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
         var3 = true;
      }

      List var4 = var2.createQuery(var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerFiscalite(String var1, long var2, String var4) throws HibernateException, NamingException {
      String[] var5 = var4.split(":");
      String var6 = var5[0];
      int var7 = Integer.parseInt(var6);
      Session var8 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
      Query var9 = var8.createQuery(" from PlanComptable where plcNature=:codFisc and exercicesComptable=:exo and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte").setLong("exo", var2).setParameter("codFisc", var7);
      List var10 = null;
      if (var9.list().size() > 0) {
         var10 = var9.list();
      }

      this.utilInitHibernate.closeSession();
      return var10;
   }

   public List chargerQuiCommence(String var1, long var2, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
         var6 = true;
      }

      Query var7 = var5.createQuery(" from PlanComptable where plcCompte like '" + var4 + "%' and exercicesComptable=:exo and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte").setLong("exo", var2);
      List var8 = null;
      if (var7.list().size() > 0) {
         var8 = var7.list();
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List chargerFournisseur(String var1, long var2) throws HibernateException, NamingException {
      Session var4 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
      Query var5 = var4.createQuery(" from PlanComptable where plcNature=6 and exercicesComptable=:exo and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte").setLong("exo", var2);
      List var6 = null;
      if (var5.list().size() > 0) {
         var6 = var5.list();
      }

      this.utilInitHibernate.closeSession();
      return var6;
   }

   public List chargerClient(String var1, long var2) throws HibernateException, NamingException {
      Session var4 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
      Query var5 = var4.createQuery(" from PlanComptable where plcNature=7 and exercicesComptable=:exo and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte").setLong("exo", var2);
      List var6 = null;
      if (var5.list().size() > 0) {
         var6 = var5.list();
      }

      this.utilInitHibernate.closeSession();
      return var6;
   }

   public List chargerPersonnel(String var1, long var2) throws HibernateException, NamingException {
      Session var4 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
      Query var5 = var4.createQuery(" from PlanComptable where plcNature=7 and exercicesComptable=:exo and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte").setLong("exo", var2);
      List var6 = null;
      if (var5.list().size() > 0) {
         var6 = var5.list();
      }

      this.utilInitHibernate.closeSession();
      return var6;
   }

   public List chargerAnalytique(String var1, long var2) throws HibernateException, NamingException {
      Session var4 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
      Query var5 = var4.createQuery(" from PlanComptable where plcSite<>'' or plcAnal1<>'' or plcAnal2<>'' or plcAnal3<>'' or plcAnal4<>''  or plcRegion<>''  or plcService<>''  or plcSecteur<>''   or plcPdv<>'' or plcDepartement<>'' and exercicesComptable=:exo and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte").setLong("exo", var2);
      List var6 = var5.list();
      this.utilInitHibernate.closeSession();
      return var6;
   }

   public PlanComptable trouveCompte(String var1, long var2, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
         var6 = true;
      }

      Query var7 = null;
      if (var2 != 0L) {
         if (var1 != null && !var1.isEmpty()) {
            var7 = var5.createQuery(" from PlanComptable where plcCompte='" + var4 + "' and exercicesComptable=:exo and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte").setLong("exo", var2).setMaxResults(1);
         } else {
            var7 = var5.createQuery(" from PlanComptable where plcCompte='" + var4 + "' and exercicesComptable=:exo group by plcCompte order by plcCompte").setLong("exo", var2).setMaxResults(1);
         }
      } else if (var1 != null && !var1.isEmpty()) {
         var7 = var5.createQuery(" from PlanComptable where plcCompte='" + var4 + "' and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte").setMaxResults(1);
      } else {
         var7 = var5.createQuery(" from PlanComptable where plcCompte='" + var4 + "' group by plcCompte order by plcCompte").setMaxResults(1);
      }

      new ArrayList();
      new PlanComptable();
      PlanComptable var9;
      if (var7.list().size() > 0) {
         List var8 = var7.list();
         if (var8.size() != 0) {
            var9 = (PlanComptable)var8.get(0);
         } else {
            var9 = null;
         }
      } else {
         var9 = null;
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public List selectPlanComptable(String var1, long var2) throws HibernateException, NamingException {
      Session var4 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
      List var5 = var4.createQuery("from PlanComptable where exercicesComptable=:exo and plcNature Not in(11,12) and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte").setLong("exo", var2).list();
      this.utilInitHibernate.closeSession();
      return var5;
   }

   public List selectPlanComptable(String var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
      List var3 = var2.createQuery("from PlanComptable where plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte").list();
      this.utilInitHibernate.closeSession();
      return var3;
   }

   public String delSite(String var1, long var2) throws HibernateException, NamingException {
      Session var4 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
      Transaction var5 = var4.beginTransaction();
      var5.begin();
      Query var6 = var4.createQuery("delete from PlanComptable where plcId =" + var2 + " and plcFiscalite='" + var1 + "'");
      var6.executeUpdate();
      var5.commit();
      this.utilInitHibernate.closeSession();
      return null;
   }

   public String getBiggestPlcCompte(String var1, String var2, long var3) throws HibernateException, NamingException {
      Session var5 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
      Query var6 = var5.createQuery("from PlanComptable  where plcCodeRacine='" + var2 + "' and exercicesComptable=:exo and plcFiscalite='" + var1 + "'").setLong("exo", var3);
      List var7 = var6.list();
      int var8 = var7.size();
      this.utilInitHibernate.closeSession();
      return Integer.toString(var8);
   }

   public float recupererTauxTaxe(String var1, String var2, long var3) throws HibernateException, NamingException {
      float var5 = 0.0F;
      Session var6 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
      Query var7 = var6.createQuery("select ractaux from Racines as r where r.racCode =:codd and exercices=:exo and plcFiscalite='" + var1 + "'").setLong("exo", var3).setString("codd", var2);
      var7.setMaxResults(1);
      if (var7.list().size() > 0) {
         float var8 = (Float)var7.list().get(0);
         var5 = var8;
      }

      this.utilInitHibernate.closeSession();
      return var5;
   }

   public List chargerLesPlanscomptables(String var1, long var2, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
         var5 = true;
      }

      Query var6 = null;
      if (var2 != 0L) {
         if (var1 != null && !var1.isEmpty()) {
            var6 = var4.createQuery("FROM PlanComptable where exercicesComptable=:exo and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte").setLong("exo", var2);
         } else {
            var6 = var4.createQuery("FROM PlanComptable where exercicesComptable=:exo group by plcCompte order by plcCompte").setLong("exo", var2);
         }
      } else if (var1 != null && !var1.isEmpty()) {
         var6 = var4.createQuery("FROM PlanComptable where plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte");
      } else {
         var6 = var4.createQuery("FROM PlanComptable group by plcCompte order by plcCompte");
      }

      List var7 = var6.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List recupererPersonnel(String var1, long var2) throws HibernateException, NamingException {
      Session var4 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
      Query var5 = var4.createQuery(" from PlanComptable where plcNature=8 and exercicesComptable=:exo and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte").setLong("exo", var2);
      List var6 = var5.list();
      this.utilInitHibernate.closeSession();
      return var6;
   }

   public List chargerLesPlanComptables(String var1, String var2, long var3, Session var5) {
      Query var6 = var5.createQuery("from PlanComptable where plcInactif=0 and exercicesComptable=:exo AND plcNature NOT IN" + var2 + " and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte").setLong("exo", var3);
      List var7 = null;
      var7 = var6.list();
      return var7;
   }

   public List chargerLesPlanComptables(String var1, String var2, long var3) throws HibernateException, NamingException {
      Session var5 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
      Query var6 = var5.createQuery("from PlanComptable where plcInactif=0 and exercicesComptable=:exo AND plcNature NOT IN" + var2 + " and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte").setLong("exo", var3);
      List var7 = null;
      var7 = var6.list();
      this.utilInitHibernate.closeSession();
      return var7;
   }

   public List chargerCompteTresoLibres(String var1, long var2, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
         var5 = true;
      }

      Query var6 = var4.createQuery("from PlanComptable where plcInactif=0 and exercicesComptable=:exo AND (plcNature='10' or plcNature='11') and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte").setLong("exo", var2);
      List var7 = null;
      var7 = var6.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerLesComptesImmo(String var1, long var2) throws HibernateException, NamingException {
      Session var4 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
      Query var5 = var4.createQuery("from PlanComptable where plcInactif=0 and exercicesComptable=:exo AND plcNature =:nat and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte asc").setLong("exo", var2).setInteger("nat", 3);
      List var6 = null;
      var6 = var5.list();
      this.utilInitHibernate.closeSession();
      return var6;
   }

   public List chargerLesPlanComptables(String var1, long var2, Session var4) {
      Query var5 = var4.createQuery("from PlanComptable where plcInactif=0 and exercicesComptable=:exo and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte").setLong("exo", var2);
      List var6 = null;
      var6 = var5.list();
      return var6;
   }

   public List chargerLesPlanComptables(String var1, long var2) throws HibernateException, NamingException {
      Session var4 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
      Query var5 = var4.createQuery("from PlanComptable where plcInactif=0 and exercicesComptable=:exo and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte").setLong("exo", var2);
      List var6 = null;
      var6 = var5.list();
      this.utilInitHibernate.closeSession();
      return var6;
   }

   public List chargerLesPlanComptables(long var1, Session var3) throws HibernateException, NamingException {
      Query var4 = var3.createQuery("from PlanComptable where plcInactif=0 and exercicesComptable=:exo group by plcCompte order by plcCompte").setLong("exo", var1);
      List var5 = null;
      var5 = var4.list();
      return var5;
   }

   public List validationDuCompte(String var1, Ecritures var2, long var3) throws HibernateException, NamingException {
      Session var5 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
      Query var6 = var5.createQuery("from PlanComptable ja where ja.plcCompte=:compte AND  ja.exercicesComptable=:exo and plcFiscalite='" + var1 + "'").setString("compte", var2.getEcrCompte()).setLong("exo", var3);
      var6.setMaxResults(1);
      Object var7 = new ArrayList();
      if (var6.list().size() > 0) {
         var7 = var6.list();
      }

      this.utilInitHibernate.closeSession();
      return (List)var7;
   }

   public List validationDuCompte(String var1, Ecritures var2, long var3, Session var5) {
      Query var6 = var5.createQuery("from PlanComptable ja where ja.plcCompte=:compte AND  ja.exercicesComptable=:exo and plcFiscalite='" + var1 + "'").setString("compte", var2.getEcrCompte()).setLong("exo", var3);
      var6.setMaxResults(1);
      Object var7 = new ArrayList();
      if (var6.list().size() > 0) {
         var7 = var6.list();
      }

      return (List)var7;
   }

   public List chargerlesNumCpte(String var1, String var2, long var3, String var5, Session var6) throws ClassCastException, HibernateException, NamingException {
      boolean var7 = false;
      if (var6 == null) {
         var6 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
         var7 = true;
      }

      new ArrayList();
      Query var9 = null;
      if (var1 != null && !var1.isEmpty()) {
         if (var5 != null && !var5.isEmpty()) {
            var9 = var6.createQuery("from PlanComptable where exercicesComptable=:exo and (plcCompte like '" + var2 + "%' or plcLibelleCpteFR like '" + var2 + "%') and plcCompte not in (" + var5 + ") and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte ASC").setLong("exo", var3);
         } else {
            var9 = var6.createQuery("from PlanComptable where exercicesComptable=:exo and (plcCompte like '" + var2 + "%' or plcLibelleCpteFR like '" + var2 + "%') and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte ASC").setLong("exo", var3);
         }
      } else if (var5 != null && !var5.isEmpty()) {
         var9 = var6.createQuery("from PlanComptable where exercicesComptable=:exo and (plcCompte like '" + var2 + "%' or plcLibelleCpteFR like '" + var2 + "%') and plcCompte not in (" + var5 + ") group by plcCompte order by plcCompte ASC").setLong("exo", var3);
      } else {
         var9 = var6.createQuery("from PlanComptable where exercicesComptable=:exo and (plcCompte like '" + var2 + "%' or plcLibelleCpteFR like '" + var2 + "%') group by plcCompte order by plcCompte ASC").setLong("exo", var3);
      }

      List var8 = var9.list();
      if (var7) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List chargerlesNumCpte(String var1, String var2, String var3, long var4, String var6, Session var7) throws ClassCastException, HibernateException, NamingException {
      boolean var8 = false;
      if (var7 == null) {
         var7 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
         var8 = true;
      }

      new ArrayList();
      Query var10 = null;
      if (var2 != null && !var2.isEmpty()) {
         if (var6 != null && !var6.isEmpty()) {
            var10 = var7.createQuery("from PlanComptable where exercicesComptable=:exo and plcNature in (" + var2 + ") and (plcCompte like '" + var3 + "%' or plcLibelleCpteFR like '" + var3 + "%') and plcCompte not in (" + var6 + ") and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte ASC").setLong("exo", var4);
         } else {
            var10 = var7.createQuery("from PlanComptable where exercicesComptable=:exo and plcNature in (" + var2 + ") and (plcCompte like '" + var3 + "%' or plcLibelleCpteFR like '" + var3 + "%') and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte ASC").setLong("exo", var4);
         }
      } else if (var6 != null && !var6.isEmpty()) {
         var10 = var7.createQuery("from PlanComptable where exercicesComptable=:exo and (plcCompte like '" + var3 + "%' or plcLibelleCpteFR like '" + var3 + "%') and plcCompte not in (" + var6 + ") and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte ASC").setLong("exo", var4);
      } else {
         var10 = var7.createQuery("from PlanComptable where exercicesComptable=:exo and (plcCompte like '" + var3 + "%' or plcLibelleCpteFR like '" + var3 + "%') and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte ASC").setLong("exo", var4);
      }

      List var9 = var10.list();
      if (var8) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public List chargerlesNumCpte(String var1, Session var2) throws ClassCastException, HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from PlanComptable where (plcCompte like '" + var1 + "%' or plcLibelleCpteFR like '" + var1 + "%')  group by plcCompte order by plcCompte ASC");
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerlesNumCpteFiltre(String var1, int var2, String var3, String var4, String var5, long var6, Session var8) throws ClassCastException, HibernateException, NamingException {
      boolean var9 = false;
      if (var8 == null) {
         var8 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
         var9 = true;
      }

      new ArrayList();
      String var11 = "";
      if (var4 != null && !var4.isEmpty()) {
         if (var2 == 1) {
            var11 = "from PlanComptable where exercicesComptable=" + var6 + " and ((plcCompte like '" + var5 + "%' or plcLibelleCpteFR like '" + var5 + "%') and plcCompte not in (" + var4 + ")) and plcNature not in (7) and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte ASC";
         } else if (var2 == 2) {
            var11 = "from PlanComptable where exercicesComptable=" + var6 + " and ((plcCompte like '" + var5 + "%' or plcLibelleCpteFR like '" + var5 + "%') and plcCompte not in (" + var4 + ")) and plcNature not in (6) and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte ASC";
         } else if (var2 != 7 && var2 != 8) {
            if (var2 != 9 && var2 != 10) {
               var11 = "from PlanComptable where exercicesComptable=" + var6 + " and ((plcCompte like '" + var5 + "%' or plcLibelleCpteFR like '" + var5 + "%') and plcCompte not in (" + var4 + ")) and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte ASC";
            } else {
               var11 = "from PlanComptable where exercicesComptable=" + var6 + " and ((plcCompte like '" + var5 + "%' or plcLibelleCpteFR like '" + var5 + "%') and plcCompte not in (" + var4 + ")) and (plcNature not in (10,11) or plcCompte='" + var3 + "')  and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte ASC";
            }
         } else {
            var11 = "from PlanComptable where exercicesComptable=" + var6 + " and ((plcCompte like '" + var5 + "%' or plcLibelleCpteFR like '" + var5 + "%') and plcCompte not in (" + var4 + ")) and (plcNature not in (10,11) or plcCompte='" + var3 + "') and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte ASC";
         }
      } else if (var2 == 1) {
         var11 = "from PlanComptable where exercicesComptable=" + var6 + " and (plcCompte like '" + var5 + "%' or plcLibelleCpteFR like '" + var5 + "%') and plcNature not in (7) and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte ASC";
      } else if (var2 == 2) {
         var11 = "from PlanComptable where exercicesComptable=" + var6 + " and (plcCompte like '" + var5 + "%' or plcLibelleCpteFR like '" + var5 + "%') and plcNature not in (6) and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte ASC";
      } else if (var2 != 7 && var2 != 8) {
         if (var2 != 9 && var2 != 10) {
            var11 = "from PlanComptable where exercicesComptable=" + var6 + " and (plcCompte like '" + var5 + "%' or plcLibelleCpteFR like '" + var5 + "%') and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte ASC";
         } else {
            var11 = "from PlanComptable where exercicesComptable=" + var6 + " and (plcCompte like '" + var5 + "%' or plcLibelleCpteFR like '" + var5 + "%') and (plcNature not in (10,11) or plcCompte='" + var3 + "') and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte ASC";
         }
      } else {
         var11 = "from PlanComptable where exercicesComptable=" + var6 + " and (plcCompte like '" + var5 + "%' or plcLibelleCpteFR like '" + var5 + "%') and (plcNature not in (10,11) or plcCompte='" + var3 + "') and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte ASC";
      }

      Query var12 = var8.createQuery(var11);
      List var10 = var12.list();
      if (var9) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public String verifNumCpte(String var1, String var2, long var3, Session var5) throws ClassCastException {
      Query var6 = var5.createQuery("select distinct plcCompte from PlanComptable where exercicesComptable=:exo and plcCompte like '" + var2 + "%' and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte ASC").setLong("exo", var3).setMaxResults(1);
      new ArrayList();
      List var7 = var6.list();
      String var8 = "";
      if (var7.size() != 0) {
         int var9 = var7.toString().length();
         var8 = var7.toString().substring(1, var9 - 1);
      }

      return var8;
   }

   public List chargeNumCpte(String var1, String var2, long var3, int var5, String var6, Session var7) throws ClassCastException, HibernateException, NamingException {
      boolean var8 = false;
      if (var7 == null) {
         var7 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
         var8 = true;
      }

      Query var9 = null;
      String var10 = "";
      if (var6 != null && !var6.isEmpty() && !var6.contains("%")) {
         var10 = " and plcCompte not in (" + var6 + ")";
      }

      String var11;
      if (var1 != null && !var1.isEmpty()) {
         if (var5 == 1) {
            if (var3 != 0L) {
               if (var2.equals("*")) {
                  var9 = var7.createQuery("from PlanComptable where exercicesComptable=:exo and plcInactif=0 and plcNature<>7 " + var10 + " and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte ASC").setLong("exo", var3);
               } else if (var2.startsWith("*") && var2.length() >= 2) {
                  var11 = var2.substring(1);
                  var9 = var7.createQuery("from PlanComptable where exercicesComptable=:exo and (plcCompte like '" + var11 + "%' or plcLibelleCpteFR like '%" + var11 + "%') and plcInactif=0 and plcNature<>7  " + var10 + " and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte ASC").setLong("exo", var3);
               } else {
                  var9 = var7.createQuery("from PlanComptable where exercicesComptable=:exo and (plcCompte like '" + var2 + "%' or plcLibelleCpteFR like '" + var2 + "%') and plcInactif=0 and plcNature<>7  " + var10 + " and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte ASC").setLong("exo", var3);
               }
            } else if (var2.equals("*")) {
               var9 = var7.createQuery("from PlanComptable where plcInactif=0 and plcNature<>7  and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte ASC");
            } else if (var2.startsWith("*") && var2.length() >= 2) {
               var11 = var2.substring(1);
               var9 = var7.createQuery("from PlanComptable where (plcCompte like '" + var11 + "%' or plcLibelleCpteFR like '%" + var11 + "%') and plcInactif=0 and plcNature<>7  " + var10 + " and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte ASC");
            } else {
               var9 = var7.createQuery("from PlanComptable where (plcCompte like '" + var2 + "%' or plcLibelleCpteFR like '" + var2 + "%') and plcInactif=0 and plcNature<>7  " + var10 + " and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte ASC");
            }
         } else if (var5 == 2) {
            if (var3 != 0L) {
               if (var2.equals("*")) {
                  var9 = var7.createQuery("from PlanComptable where exercicesComptable=:exo and plcInactif=0 and plcNature<>6  " + var10 + " and plcFiscalite='" + var1 + "'  group by plcCompte order by plcCompte ASC").setLong("exo", var3);
               } else if (var2.startsWith("*") && var2.length() >= 2) {
                  var11 = var2.substring(1);
                  var9 = var7.createQuery("from PlanComptable where exercicesComptable=:exo and (plcCompte like '" + var11 + "%' or plcLibelleCpteFR like '%" + var11 + "%') and plcInactif=0 and plcNature<>6  " + var10 + " and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte ASC").setLong("exo", var3);
               } else {
                  var9 = var7.createQuery("from PlanComptable where exercicesComptable=:exo and (plcCompte like '" + var2 + "%' or plcLibelleCpteFR like '" + var2 + "%') and plcInactif=0 and plcNature<>6  " + var10 + " and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte ASC").setLong("exo", var3);
               }
            } else if (var2.equals("*")) {
               var9 = var7.createQuery("from PlanComptable where plcInactif=0 and plcNature<>6  " + var10 + " and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte ASC");
            } else if (var2.startsWith("*") && var2.length() >= 2) {
               var11 = var2.substring(1);
               var9 = var7.createQuery("from PlanComptable where (plcCompte like '" + var11 + "%' or plcLibelleCpteFR like '%" + var11 + "%') and plcInactif=0 and plcNature<>6  " + var10 + " and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte ASC");
            } else {
               var9 = var7.createQuery("from PlanComptable where (plcCompte like '" + var2 + "%' or plcLibelleCpteFR like '" + var2 + "%') and plcInactif=0 and plcNature<>6  " + var10 + " and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte ASC");
            }
         } else if (var3 != 0L) {
            if (var2.equals("*")) {
               var9 = var7.createQuery("from PlanComptable where exercicesComptable=:exo and plcInactif=0  " + var10 + " and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte ASC").setLong("exo", var3);
            } else if (var2.startsWith("*") && var2.length() >= 2) {
               var11 = var2.substring(1);
               var9 = var7.createQuery("from PlanComptable where exercicesComptable=:exo and (plcCompte like '" + var11 + "%' or plcLibelleCpteFR like '%" + var11 + "%') and plcInactif=0  " + var10 + " and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte ASC").setLong("exo", var3);
            } else {
               var9 = var7.createQuery("from PlanComptable where exercicesComptable=:exo and (plcCompte like '" + var2 + "%' or plcLibelleCpteFR like '" + var2 + "%') and plcInactif=0  " + var10 + " and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte ASC").setLong("exo", var3);
            }
         } else if (var2.equals("*")) {
            var9 = var7.createQuery("from PlanComptable where plcInactif=0  " + var10 + " and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte ASC");
         } else if (var2.startsWith("*") && var2.length() >= 2) {
            var11 = var2.substring(1);
            var9 = var7.createQuery("from PlanComptable where (plcCompte like '" + var11 + "%' or plcLibelleCpteFR like '%" + var11 + "%') and plcInactif=0  " + var10 + " and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte ASC");
         } else {
            var9 = var7.createQuery("from PlanComptable where (plcCompte like '" + var2 + "%' or plcLibelleCpteFR like '" + var2 + "%') and plcInactif=0  " + var10 + " and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte ASC");
         }
      } else if (var5 == 1) {
         if (var3 != 0L) {
            if (var2.equals("*")) {
               var9 = var7.createQuery("from PlanComptable where exercicesComptable=:exo and plcInactif=0 and plcNature<>7 " + var10 + " group by plcCompte order by plcCompte ASC").setLong("exo", var3);
            } else if (var2.startsWith("*") && var2.length() >= 2) {
               var11 = var2.substring(1);
               var9 = var7.createQuery("from PlanComptable where exercicesComptable=:exo and (plcCompte like '" + var11 + "%' or plcLibelleCpteFR like '%" + var11 + "%') and plcInactif=0 and plcNature<>7  " + var10 + " group by plcCompte order by plcCompte ASC").setLong("exo", var3);
            } else {
               var9 = var7.createQuery("from PlanComptable where exercicesComptable=:exo and (plcCompte like '" + var2 + "%' or plcLibelleCpteFR like '" + var2 + "%') and plcInactif=0 and plcNature<>7  " + var10 + " group by plcCompte order by plcCompte ASC").setLong("exo", var3);
            }
         } else if (var2.equals("*")) {
            var9 = var7.createQuery("from PlanComptable where plcInactif=0 and plcNature<>7 group by plcCompte order by plcCompte ASC");
         } else if (var2.startsWith("*") && var2.length() >= 2) {
            var11 = var2.substring(1);
            var9 = var7.createQuery("from PlanComptable where (plcCompte like '" + var11 + "%' or plcLibelleCpteFR like '%" + var11 + "%') and plcInactif=0 and plcNature<>7  " + var10 + " group by plcCompte order by plcCompte ASC");
         } else {
            var9 = var7.createQuery("from PlanComptable where (plcCompte like '" + var2 + "%' or plcLibelleCpteFR like '" + var2 + "%') and plcInactif=0 and plcNature<>7  " + var10 + " group by plcCompte order by plcCompte ASC");
         }
      } else if (var5 == 2) {
         if (var3 != 0L) {
            if (var2.equals("*")) {
               var9 = var7.createQuery("from PlanComptable where exercicesComptable=:exo and plcInactif=0 and plcNature<>6  " + var10 + " group by plcCompte order by plcCompte ASC").setLong("exo", var3);
            } else if (var2.startsWith("*") && var2.length() >= 2) {
               var11 = var2.substring(1);
               var9 = var7.createQuery("from PlanComptable where exercicesComptable=:exo and (plcCompte like '" + var11 + "%' or plcLibelleCpteFR like '%" + var11 + "%') and plcInactif=0 and plcNature<>6  " + var10 + " group by plcCompte order by plcCompte ASC").setLong("exo", var3);
            } else {
               var9 = var7.createQuery("from PlanComptable where exercicesComptable=:exo and (plcCompte like '" + var2 + "%' or plcLibelleCpteFR like '" + var2 + "%') and plcInactif=0 and plcNature<>6  " + var10 + " group by plcCompte order by plcCompte ASC").setLong("exo", var3);
            }
         } else if (var2.equals("*")) {
            var9 = var7.createQuery("from PlanComptable where plcInactif=0 and plcNature<>6  " + var10 + " and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte ASC");
         } else if (var2.startsWith("*") && var2.length() >= 2) {
            var11 = var2.substring(1);
            var9 = var7.createQuery("from PlanComptable where (plcCompte like '" + var11 + "%' or plcLibelleCpteFR like '%" + var11 + "%') and plcInactif=0 and plcNature<>6  " + var10 + " group by plcCompte order by plcCompte ASC");
         } else {
            var9 = var7.createQuery("from PlanComptable where (plcCompte like '" + var2 + "%' or plcLibelleCpteFR like '" + var2 + "%') and plcInactif=0 and plcNature<>6  " + var10 + " group by plcCompte order by plcCompte ASC");
         }
      } else if (var3 != 0L) {
         if (var2.equals("*")) {
            var9 = var7.createQuery("from PlanComptable where exercicesComptable=:exo and plcInactif=0  " + var10 + " and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte ASC").setLong("exo", var3);
         } else if (var2.startsWith("*") && var2.length() >= 2) {
            var11 = var2.substring(1);
            var9 = var7.createQuery("from PlanComptable where exercicesComptable=:exo and (plcCompte like '" + var11 + "%' or plcLibelleCpteFR like '%" + var11 + "%') and plcInactif=0  " + var10 + " group by plcCompte order by plcCompte ASC").setLong("exo", var3);
         } else {
            var9 = var7.createQuery("from PlanComptable where exercicesComptable=:exo and (plcCompte like '" + var2 + "%' or plcLibelleCpteFR like '" + var2 + "%') and plcInactif=0  " + var10 + " group by plcCompte order by plcCompte ASC").setLong("exo", var3);
         }
      } else if (var2.equals("*")) {
         var9 = var7.createQuery("from PlanComptable where plcInactif=0  " + var10 + " and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte ASC");
      } else if (var2.startsWith("*") && var2.length() >= 2) {
         var11 = var2.substring(1);
         var9 = var7.createQuery("from PlanComptable where (plcCompte like '" + var11 + "%' or plcLibelleCpteFR like '%" + var11 + "%') and plcInactif=0  " + var10 + " group by plcCompte order by plcCompte ASC");
      } else {
         var9 = var7.createQuery("from PlanComptable where (plcCompte like '" + var2 + "%' or plcLibelleCpteFR like '" + var2 + "%') and plcInactif=0  " + var10 + " group by plcCompte order by plcCompte ASC");
      }

      new ArrayList();
      Object var21 = var9.list();
      if (var6 != null && !var6.isEmpty() && var6.contains("%")) {
         ArrayList var12 = new ArrayList();
         String[] var13 = var6.split(",");
         int var14 = var13.length;

         for(int var15 = 0; var15 < var14; ++var15) {
            var12.add(var13[var15].toString().replace("'", ""));
         }

         ArrayList var22 = new ArrayList();
         boolean var16 = true;

         for(int var17 = 0; var17 < ((List)var21).size(); ++var17) {
            var16 = true;
            String var18 = ((PlanComptable)((List)var21).get(var17)).getPlcCompte();

            for(int var19 = 0; var19 < var12.size(); ++var19) {
               if (((String)var12.get(var19)).toString().contains("%")) {
                  String var20 = ((String)var12.get(var19)).toString().replace("%", "");
                  if (((PlanComptable)((List)var21).get(var17)).getPlcCompte().startsWith(var20)) {
                     var16 = false;
                     break;
                  }
               } else if (((String)var12.get(var19)).toString().equals(var18)) {
                  var16 = false;
                  break;
               }
            }

            if (var16) {
               var22.add(((List)var21).get(var17));
            }
         }

         var21 = var22;
      }

      if (var8) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var21;
   }

   public String getLibPC(String var1, String var2) throws HibernateException, NamingException {
      String var3 = "";
      if (var2 == null) {
         var3 = "";
      } else {
         Session var4 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
         Criteria var5 = var4.createCriteria(PlanComptable.class).add(Restrictions.like("plcCompte", var2 + "%"));
         var5.setMaxResults(1);
         List var6 = var5.list();
         if (var6.size() > 0) {
            PlanComptable var7 = (PlanComptable)var6.get(0);
            var3 = var7.getPlcLibelleCpteFR();
         } else {
            var3 = "";
         }

         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List getLesPC(String var1) throws HibernateException, NamingException {
      new ArrayList();
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
      Query var4 = var3.createQuery("from PlanComptable where plcInactif=:b and plcFiscalite='" + var1 + "'");
      var4.setParameter("b", 0);
      List var2 = var4.list();
      this.utilInitHibernate.closeSession();
      return var2;
   }

   public List chargerLesPlcComptables(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
         var3 = true;
      }

      Query var4 = null;
      if (var1 != null && !var1.isEmpty()) {
         var4 = var2.createQuery("from PlanComptable where plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte");
      } else {
         var4 = var2.createQuery("from PlanComptable group by plcCompte order by plcCompte");
      }

      List var5 = null;
      var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesPlcComptables(String var1, long var2, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
         var6 = true;
      }

      Query var7 = var5.createQuery("from PlanComptable where exercicesComptable=:exo and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte").setLong("exo", var2);
      new ArrayList();
      List var8 = var7.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List chargerTousLesPlcComptables(String var1, long var2, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
         var5 = true;
      }

      Query var6 = null;
      if (var1 != null && !var1.isEmpty()) {
         var6 = var4.createQuery("from PlanComptable where exercicesComptable=:exo and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte").setLong("exo", var2);
      } else {
         var6 = var4.createQuery("from PlanComptable where exercicesComptable=:exo group by plcCompte order by plcCompte").setLong("exo", var2);
      }

      new ArrayList();
      List var7 = var6.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerPlanCmptByNature(String var1, int var2) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
      Query var4 = var3.createQuery("from PlanComptable where plcNature =:nature and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte");
      var4.setParameter("nature", var2);
      List var5 = var4.list();
      this.utilInitHibernate.closeSession();
      return var5;
   }

   public List chargerListPlanByListNat(String var1, Session var2, ExercicesComptable var3, String var4, String var5) throws HibernateException, NamingException {
      new ArrayList();
      boolean var7 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
         var7 = true;
      }

      String var8 = "";
      String var9;
      if (var1 != null && !var1.isEmpty()) {
         if (var4 != null && !var4.isEmpty()) {
            if (var5.equals("*")) {
               var8 = "from PlanComptable where plcNature IN " + var4 + " and exercicesComptable=:exercice and plcFiscalite='" + var1 + "'";
            } else if (var5.contains("*") && var5.length() >= 2) {
               var9 = var5.substring(1);
               var8 = "from PlanComptable where plcNature IN " + var4 + " and (plcCompte LIKE '" + var9 + "%' or plcLibelleCpteFR LIKE '%" + var9 + "%') and exercicesComptable=:exercice and plcFiscalite='" + var1 + "'";
            } else {
               var8 = "from PlanComptable where plcNature IN " + var4 + " and (plcCompte LIKE '" + var5 + "%' or plcLibelleCpteFR LIKE '" + var5 + "%') and exercicesComptable=:exercice and plcFiscalite='" + var1 + "'";
            }
         } else if (var5.equals("*")) {
            var8 = "from PlanComptable where exercicesComptable=:exercice and plcFiscalite='" + var1 + "'";
         } else if (var5.contains("*") && var5.length() >= 2) {
            var9 = var5.substring(1);
            var8 = "from PlanComptable where (plcCompte LIKE '" + var9 + "%' or plcLibelleCpteFR LIKE '%" + var9 + "%') and exercicesComptable=:exercice and plcFiscalite='" + var1 + "'";
         } else {
            var8 = "from PlanComptable where (plcCompte LIKE '" + var5 + "%' or plcLibelleCpteFR LIKE '" + var5 + "%') and exercicesComptable=:exercice and plcFiscalite='" + var1 + "'";
         }
      } else if (var4 != null && !var4.isEmpty()) {
         if (var5.equals("*")) {
            var8 = "from PlanComptable where plcNature IN " + var4 + " and exercicesComptable=:exercice";
         } else if (var5.contains("*") && var5.length() >= 2) {
            var9 = var5.substring(1);
            var8 = "from PlanComptable where plcNature IN " + var4 + " and (plcCompte LIKE '" + var9 + "%' or plcLibelleCpteFR LIKE '%" + var9 + "%') and exercicesComptable=:exercice";
         } else {
            var8 = "from PlanComptable where plcNature IN " + var4 + " and (plcCompte LIKE '" + var5 + "%' or plcLibelleCpteFR LIKE '" + var5 + "%') and exercicesComptable=:exercice";
         }
      } else if (var5.equals("*")) {
         var8 = "from PlanComptable where exercicesComptable=:exercice";
      } else if (var5.contains("*") && var5.length() >= 2) {
         var9 = var5.substring(1);
         var8 = "from PlanComptable where (plcCompte LIKE '" + var9 + "%' or plcLibelleCpteFR LIKE '%" + var9 + "%') and exercicesComptable=:exercice";
      } else {
         var8 = "from PlanComptable where (plcCompte LIKE '" + var5 + "%' or plcLibelleCpteFR LIKE '" + var5 + "%') and exercicesComptable=:exercice";
      }

      Query var10 = var2.createQuery(var8).setParameter("exercice", var3);
      List var6 = var10.list();
      if (var7) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerlesNumCpte(String var1, String var2, long var3, Session var5) throws ClassCastException, HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanComptable");
         var6 = true;
      }

      new ArrayList();
      Query var8 = var5.createQuery("from PlanComptable where exercicesComptable=:exo and plcNature=:nat and plcFiscalite='" + var1 + "' group by plcCompte order by plcCompte ASC").setString("nat", var2).setLong("exo", var3);
      List var7 = var8.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public int getChoixRacine() {
      return this.choixRacine;
   }

   public void setChoixRacine(int var1) {
      this.choixRacine = var1;
   }

   public String getSelecFiscalite() {
      return this.selecFiscalite;
   }

   public void setSelecFiscalite(String var1) {
      this.selecFiscalite = var1;
   }
}
