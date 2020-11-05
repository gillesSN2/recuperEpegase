package com.epegase.forms.administration;

import com.epegase.systeme.classe.CabinetPeg;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.Groupe;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.StructurePeg;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersPeg;
import com.epegase.systeme.dao.CabinetDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.GroupeDao;
import com.epegase.systeme.dao.StructureDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.fileUtil.FileRep;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilMail;
import com.epegase.systeme.xml.LectureDevises;
import com.epegase.systeme.xml.LectureFormesJuridiques;
import com.epegase.systeme.xml.LectureImmatriculation;
import com.epegase.systeme.xml.LecturePays;
import com.epegase.systeme.xml.LectureTypesSocietes;
import com.epegase.systeme.xml.LectureZonesCommerciales;
import com.epegase.systeme.xml.LectureZonesFiscales;
import com.epegase.systeme.xml.LireLesoptionsGroupe;
import com.epegase.systeme.xml.ObjetImmatriculation;
import com.epegase.systeme.xml.ObjetPays;
import com.epegase.systeme.xml.OptionGroupe;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jdom.JDOMException;
import org.xml.sax.SAXException;

public class FormCabinet implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private int etat = 0;
   private String lien;
   private String pageIndex;
   private CabinetPeg cabinetPeg = new CabinetPeg();
   private boolean afficheCabinet = false;
   private StructurePeg structurePeg = new StructurePeg();
   private StructureDao structureDao;
   private List lesSocietes = new ArrayList();
   private transient DataModel dataModelLesSocietes = new ListDataModel();
   private boolean showModalPanelMandat = false;
   private boolean showModalPanelSociete = false;
   private boolean creationSociete = false;
   private List mesFormeJuridiqueItem = new ArrayList();
   private List mesTypeEntrepriseItem;
   private List mesPaysItem;
   private List lesPays;
   private List mesZoneCommercialeItem;
   private List mesZoneFiscaleItem;
   private List mesDevises;
   private ObjetImmatriculation objetImmatriculation = new ObjetImmatriculation();
   private Users users;
   private UserDao userDao;
   private Users usersFavoris;
   private List lesUsersCabinet;
   private List lesUsersAutorise;
   private transient DataModel dataModelUsersCabinet;
   private transient DataModel dataModelUsersAutorise;
   private boolean showModalPanelUsers = false;
   private String module01;
   private String module02;
   private String module03;
   private String module04;
   private String module05;
   private String module06;
   private String module07;
   private String module08;
   private String module09;
   private String module10;
   private boolean showModalPanelConfiguration = false;
   private OptionGroupe optionGroupe;
   private LireLesoptionsGroupe lireLesoptionsGroupe;

   public FormCabinet() throws IOException, SAXException, JDOMException {
      LectureFormesJuridiques var1 = new LectureFormesJuridiques();
      this.mesFormeJuridiqueItem = var1.getMesFormesJuridiquesItems();
      LectureTypesSocietes var2 = new LectureTypesSocietes();
      this.mesTypeEntrepriseItem = var2.getMesTypesSocietesItems();
      LecturePays var3 = new LecturePays();
      this.mesPaysItem = var3.getMesPaysItems();
      this.lesPays = var3.getMespays();
      LectureZonesCommerciales var4 = new LectureZonesCommerciales();
      this.mesZoneCommercialeItem = var4.getMesZonesCommercialesItems();
      LectureZonesFiscales var5 = new LectureZonesFiscales();
      this.mesZoneFiscaleItem = var5.getMesZonesFiscalesItems();
      LectureDevises var6 = new LectureDevises();
      this.mesDevises = var6.getMesDevisesItems();
      this.lesUsersCabinet = new ArrayList();
      this.lesUsersAutorise = new ArrayList();
      this.dataModelUsersCabinet = new ListDataModel();
      this.dataModelUsersAutorise = new ListDataModel();
      this.optionGroupe = new OptionGroupe();
   }

   public void InstancesDaoUtilses() {
      this.structureDao = new StructureDao(this.baseLog, this.utilInitHibernate);
      this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
   }

   public void initCabinet() throws HibernateException, NamingException {
      this.cabinetPeg = new CabinetPeg();
      new StructurePeg();
      StructureDao var2 = new StructureDao(this.utilInitHibernate);
      StructurePeg var1 = var2.logStructurePeg(this.structureLog.getStrid());
      if (var1 != null && var1.getCabinetPeg() != null) {
         CabinetDao var3 = new CabinetDao(this.utilInitHibernate);
         String var4 = " where cabId=" + var1.getCabinetPeg().getCabId();
         new ArrayList();
         List var5 = var3.chargerCabinet(var4);
         if (var5.size() != 0) {
            this.cabinetPeg = (CabinetPeg)var5.get(0);
         }
      }

      this.lireLesoptionsGroupe = new LireLesoptionsGroupe();
      this.lireLesoptionsGroupe.setStrId(this.structureLog.getStrid());
      this.optionGroupe = this.lireLesoptionsGroupe.lancer();
   }

   public List chargerSociete() throws HibernateException, NamingException {
      this.lesSocietes.clear();
      String var1 = "";
      if (this.etat < 9) {
         var1 = " and stretatmandat=" + this.etat;
      }

      String var2 = " where cabinetPeg.cabId=" + this.cabinetPeg.getCabId() + " and (strmaitrecabinet=0 or strmaitrecabinet=11 or strmaitrecabinet=12 or strmaitrecabinet=13 or strmaitrecabinet=14 or strmaitrecabinet=15)" + var1;
      this.lesSocietes = this.structureDao.selectStructureCabinet(var2);
      this.dataModelLesSocietes.setWrappedData(this.lesSocietes);
      return this.lesSocietes;
   }

   public void selectionSociete() {
      if (this.dataModelLesSocietes.isRowAvailable()) {
         this.structurePeg = (StructurePeg)this.dataModelLesSocietes.getRowData();
      } else {
         this.structurePeg = null;
      }

   }

   public void ajouterSociete() throws IOException {
      long var1 = 0L;
      if (this.lesSocietes.size() != 0) {
         for(int var3 = 0; var3 < this.lesSocietes.size(); ++var3) {
            if (((StructurePeg)this.lesSocietes.get(var3)).getStrId() > var1) {
               var1 = ((StructurePeg)this.lesSocietes.get(var3)).getStrId();
            }
         }
      }

      String var9 = "" + (var1 + 1L);
      long var4 = 0L;
      if (this.lesSocietes.size() != 0) {
         var4 = Long.parseLong(var9);
      } else {
         boolean var6 = false;
         int var10 = var9.length();
         int var7 = 10 - var10;
         String var8 = "";
         if (var7 == 1) {
            var8 = "0";
         } else if (var7 == 2) {
            var8 = "00";
         } else if (var7 == 3) {
            var8 = "000";
         } else if (var7 == 4) {
            var8 = "0000";
         } else if (var7 == 5) {
            var8 = "00000";
         } else if (var7 == 6) {
            var8 = "000000";
         } else if (var7 == 7) {
            var8 = "0000000";
         } else if (var7 == 8) {
            var8 = "00000000";
         } else if (var7 == 9) {
            var8 = "000000000";
         } else if (var7 == 10) {
            var8 = "0000000000";
         }

         var4 = Long.parseLong(this.structureLog.getStrid() + var8 + var9);
      }

      this.structurePeg = new StructurePeg();
      this.structurePeg.setStrId(var4);
      this.structurePeg.setStrdtecreat(new Date());
      this.structurePeg.setStrlangue(this.structureLog.getStrlangue());
      this.structurePeg.setStrmaitrecabinet(0);
      this.structurePeg.setStretat(1);
      this.structurePeg.setStrusercreat(this.usersLog.getUsrid());
      this.structurePeg.setStrnompays(this.structureLog.getStrnompays());
      this.structurePeg.setStrcodepays(this.structureLog.getStrcodepays());
      this.structurePeg.setStrdevise(this.structureLog.getStrdevise());
      this.structurePeg.setStrformatdevise(this.structureLog.getStrformatdevise());
      this.structurePeg.setStrtypeentreprise(this.structureLog.getStrtypeentreprise());
      this.structurePeg.setStrzonecommerciale(this.structureLog.getStrzonecommerciale());
      this.structurePeg.setStrzonefiscale(this.structureLog.getStrzonefiscale());
      this.module01 = this.structurePeg.getStrmod1();
      this.module02 = this.structurePeg.getStrmod2();
      this.module03 = this.structurePeg.getStrmod3();
      this.module04 = this.structurePeg.getStrmod4();
      this.module05 = this.structurePeg.getStrmod5();
      this.module06 = this.structurePeg.getStrmod6();
      this.module07 = this.structurePeg.getStrmod7();
      this.module08 = this.structurePeg.getStrmod8();
      this.module09 = this.structurePeg.getStrmod9();
      this.module10 = this.structurePeg.getStrmod10();
      this.creationSociete = true;
      this.calculImmatriculation();
      this.showModalPanelSociete = true;
   }

   public void modifierSociete() throws IOException {
      this.afficheCabinet = false;
      if (this.structurePeg != null) {
         long var1 = 0L;
         int var3 = 0;
         new StructurePeg();

         for(int var5 = 0; var5 < this.lesSocietes.size(); ++var5) {
            StructurePeg var4 = (StructurePeg)this.lesSocietes.get(var5);
            this.afficheCabinet = this.rechercheModuleCabinet(var4);
            if (this.afficheCabinet) {
               var1 = var4.getStrId();
               var3 = var5;
               break;
            }
         }

         if (var3 == 0 && var1 == this.structurePeg.getStrId()) {
            this.afficheCabinet = false;
         }

         this.module01 = this.structurePeg.getStrmod1();
         this.module02 = this.structurePeg.getStrmod2();
         this.module03 = this.structurePeg.getStrmod3();
         this.module04 = this.structurePeg.getStrmod4();
         this.module05 = this.structurePeg.getStrmod5();
         this.module06 = this.structurePeg.getStrmod6();
         this.module07 = this.structurePeg.getStrmod7();
         this.module08 = this.structurePeg.getStrmod8();
         this.module09 = this.structurePeg.getStrmod9();
         this.module10 = this.structurePeg.getStrmod10();
         this.calculImmatriculation();
         this.creationSociete = false;
         this.showModalPanelSociete = true;
      }

   }

   public boolean rechercheModuleCabinet(StructurePeg var1) {
      boolean var2 = false;
      if (var1.getStrmod1() != null && !var1.getStrmod1().isEmpty() && var1.getStrmod1().equals("80500")) {
         var2 = true;
      } else if (var1.getStrmod2() != null && !var1.getStrmod2().isEmpty() && var1.getStrmod2().equals("80500")) {
         var2 = true;
      } else if (var1.getStrmod3() != null && !var1.getStrmod3().isEmpty() && var1.getStrmod3().equals("80500")) {
         var2 = true;
      } else if (var1.getStrmod4() != null && !var1.getStrmod4().isEmpty() && var1.getStrmod4().equals("80500")) {
         var2 = true;
      } else if (var1.getStrmod5() != null && !var1.getStrmod5().isEmpty() && var1.getStrmod5().equals("80500")) {
         var2 = true;
      } else if (var1.getStrmod6() != null && !var1.getStrmod6().isEmpty() && var1.getStrmod6().equals("80500")) {
         var2 = true;
      } else if (var1.getStrmod7() != null && !var1.getStrmod7().isEmpty() && var1.getStrmod7().equals("80500")) {
         var2 = true;
      } else if (var1.getStrmod8() != null && !var1.getStrmod8().isEmpty() && var1.getStrmod8().equals("80500")) {
         var2 = true;
      } else if (var1.getStrmod9() != null && !var1.getStrmod9().isEmpty() && var1.getStrmod9().equals("80500")) {
         var2 = true;
      } else if (var1.getStrmod10() != null && !var1.getStrmod10().isEmpty() && var1.getStrmod10().equals("80500")) {
         var2 = true;
      }

      return var2;
   }

   public void fermerSociete() {
      this.showModalPanelSociete = false;
   }

   public void supprimerSociete() {
      if (this.structurePeg != null) {
      }

   }

   public void calculImmatriculation() throws IOException {
      if (this.structurePeg.getStrnompays() != null && !this.structurePeg.getStrnompays().isEmpty() && this.lesPays.size() != 0) {
         String var1 = "";

         for(int var2 = 0; var2 < this.lesPays.size(); ++var2) {
            new ObjetPays();
            ObjetPays var3 = (ObjetPays)this.lesPays.get(var2);
            if (var3.getNom_FR().equals(this.structurePeg.getStrnompays())) {
               var1 = var3.getIdentification();
               break;
            }
         }

         if (var1 != null && !var1.isEmpty()) {
            LectureImmatriculation var4 = new LectureImmatriculation(var1, "pmoral");
            this.objetImmatriculation = var4.getImmatriculation();
         }
      }

   }

   public void validerSociete() throws Exception {
      if (this.structurePeg.getStrraisonsociale() != null && !this.structurePeg.getStrraisonsociale().isEmpty()) {
         int var1 = 0;
         String var2 = "structure" + this.structurePeg.getStrId();
         long var3 = this.structurePeg.getStrId();
         boolean var5 = true;
         boolean var6 = true;
         Session var7 = this.utilInitHibernate.getLoginEpegase();
         SQLQuery var8 = var7.createSQLQuery("SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME='" + var2 + "'");
         List var9 = var8.list();
         this.utilInitHibernate.closeSession();
         Transaction var10;
         Transaction var11;
         if (var9.size() == 0) {
            var7 = this.utilInitHibernate.getLoginEpegase();
            var10 = null;

            try {
               var10 = var7.beginTransaction();
               var8 = var7.createSQLQuery("CREATE DATABASE IF NOT EXISTS " + var2);
               var8.executeUpdate();
               var10.commit();
            } catch (HibernateException var99) {
               var5 = false;
               if (var10 != null) {
                  var10.rollback();
               }

               throw var99;
            } finally {
               this.utilInitHibernate.closeSession();
            }

            if (var5) {
               var7 = this.utilInitHibernate.getSysteme();
               var11 = null;

               StructurePeg var12;
               try {
                  var11 = var7.beginTransaction();
                  this.structureDao = new StructureDao(this.utilInitHibernate);
                  new StructurePeg();
                  var12 = this.structureDao.logStructurePeg(this.structureLog.getStrid(), var7);
                  if (var12 != null) {
                     this.structurePeg.setCabinetPeg(var12.getCabinetPeg());
                     var1 = var12.getCabinetPeg().getCabNature() + 10;
                     this.structurePeg.setStrId(var3);
                     this.structurePeg.setStrmod1(this.module01);
                     this.structurePeg.setStrmod2(this.module02);
                     this.structurePeg.setStrmod3(this.module03);
                     this.structurePeg.setStrmod4(this.module04);
                     this.structurePeg.setStrmod5(this.module05);
                     this.structurePeg.setStrmod6(this.module06);
                     this.structurePeg.setStrmod7(this.module07);
                     this.structurePeg.setStrmod8(this.module08);
                     this.structurePeg.setStrmod9(this.module09);
                     this.structurePeg.setStrmod10(this.module10);
                     var7.save(this.structurePeg);
                     var11.commit();
                  } else {
                     var5 = false;
                  }
               } catch (HibernateException var101) {
                  var5 = false;
                  if (var11 != null) {
                     var11.rollback();
                  }

                  throw var101;
               } finally {
                  this.utilInitHibernate.closeSession();
               }

               if (var5) {
                  var7 = this.utilInitHibernate.getSysteme();
                  var12 = null;

                  try {
                     Transaction var106 = var7.beginTransaction();
                     UsersPeg var13 = new UsersPeg();
                     var13.setStructurePeg(this.structurePeg);
                     var13.setUsrdatecreat(this.usersLog.getUsrDateCreat());
                     var13.setUsrnom(this.usersLog.getUsrNom());
                     var13.setUsrprenom(this.usersLog.getUsrPrenom());
                     var13.setUsrmail(this.usersLog.getUsrMail());
                     var13.setUsrlogin(this.usersLog.getUsrLogin());
                     var13.setUsrpw(this.usersLog.getUsrPw());
                     var13.setUsrcodesecret(this.usersLog.getUsrCodeSecret());
                     var13.setUsrfonction(this.usersLog.getUsrFonction());
                     var13.setUsrcollaboration(this.usersLog.getUsrCollaboration());
                     var13.setUsretat(this.usersLog.getUsrEtat());
                     var13.setUsrsysteme(this.usersLog.getUsrSysteme());
                     var7.save(var13);
                     var106.commit();
                  } catch (HibernateException var95) {
                     var5 = false;
                     if (var12 != null) {
                        var12.rollback();
                     }

                     throw var95;
                  } finally {
                     this.utilInitHibernate.closeSession();
                  }

                  if (var5) {
                     Session var108 = this.utilInitHibernate.getOpenSession(var2);
                     Transaction var14 = null;

                     try {
                        var14 = var108.beginTransaction();
                        Structure var15 = new Structure();
                        var15.setStrid(this.structurePeg.getStrId());
                        var15.setStrnompays(this.structurePeg.getStrnompays());
                        var15.setStrcodepays(this.structurePeg.getStrcodepays());
                        var15.setStrraisonsociale(this.structurePeg.getStrraisonsociale());
                        var15.setStrsigle(this.structurePeg.getStrsigle());
                        var15.setStrformejuridique(this.structurePeg.getStrformejuridique());
                        var15.setStrtypeentreprise(this.structurePeg.getStrtypeentreprise());
                        var15.setStrzonecommerciale(this.structurePeg.getStrzonecommerciale());
                        var15.setStrzonefiscale(this.structurePeg.getStrzonefiscale());
                        var15.setStrdevise(this.structurePeg.getStrdevise());
                        var15.setStrformatdevise(this.structurePeg.getStrformatdevise());
                        var15.setStrlangue(this.structurePeg.getStrlangue());
                        var15.setStradresse(this.structurePeg.getStradresse());
                        var15.setStrville(this.structurePeg.getStrville());
                        var15.setStrrue(this.structurePeg.getStrrue());
                        var15.setStrlot(this.structurePeg.getStrlot());
                        var15.setStrporte(this.structurePeg.getStrporte());
                        var15.setStrbatiment(this.structurePeg.getStrbatiment());
                        var15.setStretage(this.structurePeg.getStretage());
                        var15.setStrquartier(this.structurePeg.getStrquartier());
                        var15.setStrcommune(this.structurePeg.getStrcommune());
                        var15.setStrzone(this.structurePeg.getStrzone());
                        var15.setStrdepartement(this.structurePeg.getStrdepartement());
                        var15.setStrcedex(this.structurePeg.getStrcedex());
                        var15.setStrbp(this.structurePeg.getStrbp());
                        var15.setStrtel1(this.structurePeg.getStrtel1());
                        var15.setStrtel2(this.structurePeg.getStrtel2());
                        var15.setStrtel3(this.structurePeg.getStrtel3());
                        var15.setStrfax(this.structurePeg.getStrfax());
                        var15.setStrtelex(this.structurePeg.getStrtelex());
                        var15.setStrdtecreat(this.structurePeg.getStrdtecreat());
                        var15.setStretat(this.structurePeg.getStretat());
                        var15.setStrmaitrecabinet(var1);
                        var15.setStrDteDebMandat(this.structurePeg.getStrdtedebmandat());
                        var15.setStrDteFinMandat(this.structurePeg.getStrdtefinmandat());
                        var15.setStrmod1(this.module01);
                        var15.setStrmod2(this.module02);
                        var15.setStrmod3(this.module03);
                        var15.setStrmod4(this.module04);
                        var15.setStrmod5(this.module05);
                        var15.setStrmod6(this.module06);
                        var15.setStrmod7(this.module07);
                        var15.setStrmod8(this.module08);
                        var15.setStrmod9(this.module09);
                        var15.setStrmod10(this.module10);
                        var15.setStrnum1(this.structurePeg.getStrnum1());
                        var15.setStrnum2(this.structurePeg.getStrnum2());
                        var15.setStrnum3(this.structurePeg.getStrnum3());
                        var15.setStrnum4(this.structurePeg.getStrnum4());
                        var15.setStrnum5(this.structurePeg.getStrnum5());
                        var15.setStrnum6(this.structurePeg.getStrnum6());
                        var15.setStrnum7(this.structurePeg.getStrnum7());
                        var15.setStrnum8(this.structurePeg.getStrnum8());
                        var15.setStrnum9(this.structurePeg.getStrnum9());
                        var15.setStrnum10(this.structurePeg.getStrnum10());
                        var15.setStrnum11(this.structurePeg.getStrnum11());
                        var15.setStrnum12(this.structurePeg.getStrnum12());
                        var15.setStrnum13(this.structurePeg.getStrnum13());
                        var15.setStrnum14(this.structurePeg.getStrnum14());
                        var15.setStrnum15(this.structurePeg.getStrnum15());
                        var15.setStrnum16(this.structurePeg.getStrnum16());
                        var15.setStrnum17(this.structurePeg.getStrnum17());
                        var15.setStrnum18(this.structurePeg.getStrnum18());
                        var15.setStrnum19(this.structurePeg.getStrnum19());
                        var15.setStrnum20(this.structurePeg.getStrnum20());
                        var15.setStrmode(this.structurePeg.getStrmode());
                        var15.setStrAddInto(1);
                        var15.setStrClusterMap(1);
                        var15.setStrHangout(1);
                        var15.setStrGoogleTraduction(1);
                        var15.setStrbistriLink((String)null);
                        var15.setStrcpteorange((String)null);
                        var15.setStrcpteuniversign((String)null);
                        var15.setStrpwuniversign((String)null);
                        var108.save(var15);
                        var15.getStrid();
                        Groupe var16 = new Groupe();
                        var16.setGrpLibelle(this.usersLog.getGroupe().getGrpLibelle());
                        var16.setGrpCode(this.usersLog.getGroupe().getGrpCode());
                        var16.setGrpModuleAch(this.usersLog.getGroupe().getGrpModuleAch());
                        var16.setGrpModuleCai(this.usersLog.getGroupe().getGrpModuleCai());
                        var16.setGrpModuleCpt(this.usersLog.getGroupe().getGrpModuleCpt());
                        var16.setGrpModuleMed(this.usersLog.getGroupe().getGrpModuleMed());
                        var16.setGrpModuleOff(this.usersLog.getGroupe().getGrpModuleOff());
                        var16.setGrpModulePay(this.usersLog.getGroupe().getGrpModulePay());
                        var16.setGrpModulePrc(this.usersLog.getGroupe().getGrpModulePrc());
                        var16.setGrpModuleStk(this.usersLog.getGroupe().getGrpModuleStk());
                        var16.setGrpModuleTie(this.usersLog.getGroupe().getGrpModuleTie());
                        var16.setGrpModuleVte(this.usersLog.getGroupe().getGrpModuleVte());
                        var16.setGrpModuleFree(0);
                        var108.save(var16);
                        Users var17 = new Users();
                        var17.setGroupe(var16);
                        var17.setUsrDateCreat(this.usersLog.getUsrDateCreat());
                        var17.setUsrNom(this.usersLog.getUsrNom());
                        var17.setUsrPrenom(this.usersLog.getUsrPrenom());
                        var17.setUsrMail(this.usersLog.getUsrMail());
                        var17.setUsrLogin(this.usersLog.getUsrLogin());
                        var17.setUsrPw(this.usersLog.getUsrPw());
                        var17.setUsrCodeSecret(this.usersLog.getUsrCodeSecret());
                        var17.setUsrFonction(this.usersLog.getUsrFonction());
                        var17.setUsrCollaboration(this.usersLog.getUsrCollaboration());
                        var17.setUsrEtat(this.usersLog.getUsrEtat());
                        var17.setUsrSysteme(this.usersLog.getUsrSysteme());
                        var108.save(var17);
                        var17.getUsrid();
                        var14.commit();
                     } catch (HibernateException var97) {
                        var5 = false;
                        if (var14 != null) {
                           var14.rollback();
                        }

                        throw var97;
                     } finally {
                        this.utilInitHibernate.closeSession();
                     }

                     if (var5) {
                        String var109 = StaticModePegase.getCheminContext();
                        File var110 = new File(var109 + File.separator + "clients" + File.separator + this.baseLog);
                        File var111 = new File(var109 + File.separator + "clients" + File.separator + var2);
                        if (!var111.exists()) {
                           FileRep.copy(var110, var111);
                        }

                        this.lesSocietes.add(this.structurePeg);
                        this.dataModelLesSocietes.setWrappedData(this.lesSocietes);
                        if (StaticModePegase.getInternet_actif() != 0) {
                           UtilMail var18 = new UtilMail(this.structureLog);
                           var18.mailCreationCabinet(this.structurePeg, this.structureLog);
                        }
                     }
                  }
               }
            }
         } else {
            var7 = this.utilInitHibernate.getSysteme();
            var10 = null;

            try {
               var10 = var7.beginTransaction();
               this.structureDao = new StructureDao(this.utilInitHibernate);
               new StructurePeg();
               StructurePeg var105 = this.structureDao.logStructurePeg(var3, var7);
               if (var105 != null) {
                  var1 = var105.getCabinetPeg().getCabNature() + 10;
                  var105.setStrmod1(this.module01);
                  var105.setStrmod2(this.module02);
                  var105.setStrmod3(this.module03);
                  var105.setStrmod4(this.module04);
                  var105.setStrmod5(this.module05);
                  var105.setStrmod6(this.module06);
                  var105.setStrmod7(this.module07);
                  var105.setStrmod8(this.module08);
                  var105.setStrmod9(this.module09);
                  var105.setStrmod10(this.module10);
                  var7.save(var105);
                  var10.commit();
                  var6 = true;
               }
            } catch (HibernateException var103) {
               var6 = false;
               if (var10 != null) {
                  var10.rollback();
               }

               throw var103;
            } finally {
               this.utilInitHibernate.closeSession();
            }

            if (var6) {
               var7 = this.utilInitHibernate.getOpenSession(var2, "");
               var11 = null;

               try {
                  var11 = var7.beginTransaction();
                  this.structureDao = new StructureDao(this.utilInitHibernate);
                  new Structure();
                  Structure var107 = this.structureDao.logStructureId(var3, var7);
                  if (var107 != null) {
                     var107.setStrnompays(this.structurePeg.getStrnompays());
                     var107.setStrcodepays(this.structurePeg.getStrcodepays());
                     var107.setStrraisonsociale(this.structurePeg.getStrraisonsociale());
                     var107.setStrdevise(this.structurePeg.getStrdevise());
                     var107.setStrformatdevise(this.structurePeg.getStrformatdevise());
                     var107.setStrlangue(this.structurePeg.getStrlangue());
                     var107.setStradresse(this.structurePeg.getStradresse());
                     var107.setStrville(this.structurePeg.getStrville());
                     var107.setStrrue(this.structurePeg.getStrrue());
                     var107.setStrlot(this.structurePeg.getStrlot());
                     var107.setStrporte(this.structurePeg.getStrporte());
                     var107.setStrbatiment(this.structurePeg.getStrbatiment());
                     var107.setStretage(this.structurePeg.getStretage());
                     var107.setStrquartier(this.structurePeg.getStrquartier());
                     var107.setStrcommune(this.structurePeg.getStrcommune());
                     var107.setStrzone(this.structurePeg.getStrzone());
                     var107.setStrdepartement(this.structurePeg.getStrdepartement());
                     var107.setStrcedex(this.structurePeg.getStrcedex());
                     var107.setStrbp(this.structurePeg.getStrbp());
                     var107.setStrtel1(this.structurePeg.getStrtel1());
                     var107.setStrtel2(this.structurePeg.getStrtel2());
                     var107.setStrtel3(this.structurePeg.getStrtel3());
                     var107.setStrfax(this.structurePeg.getStrfax());
                     var107.setStrtelex(this.structurePeg.getStrtelex());
                     var107.setStrdtecreat(this.structurePeg.getStrdtecreat());
                     var107.setStretat(this.structurePeg.getStretat());
                     var107.setStrmaitrecabinet(var1);
                     var107.setStrDteDebMandat(this.structurePeg.getStrdtedebmandat());
                     var107.setStrDteFinMandat(this.structurePeg.getStrdtefinmandat());
                     var107.setStrmod1(this.module01);
                     var107.setStrmod2(this.module02);
                     var107.setStrmod3(this.module03);
                     var107.setStrmod4(this.module04);
                     var107.setStrmod5(this.module05);
                     var107.setStrmod6(this.module06);
                     var107.setStrmod7(this.module07);
                     var107.setStrmod8(this.module08);
                     var107.setStrmod9(this.module09);
                     var107.setStrmod10(this.module10);
                     var107.setStrnum1(this.structurePeg.getStrnum1());
                     var107.setStrnum2(this.structurePeg.getStrnum2());
                     var107.setStrnum3(this.structurePeg.getStrnum3());
                     var107.setStrnum4(this.structurePeg.getStrnum4());
                     var107.setStrnum5(this.structurePeg.getStrnum5());
                     var107.setStrnum6(this.structurePeg.getStrnum6());
                     var107.setStrnum7(this.structurePeg.getStrnum7());
                     var107.setStrnum8(this.structurePeg.getStrnum8());
                     var107.setStrnum9(this.structurePeg.getStrnum9());
                     var107.setStrnum10(this.structurePeg.getStrnum10());
                     var107.setStrnum11(this.structurePeg.getStrnum11());
                     var107.setStrnum12(this.structurePeg.getStrnum12());
                     var107.setStrnum13(this.structurePeg.getStrnum13());
                     var107.setStrnum14(this.structurePeg.getStrnum14());
                     var107.setStrnum15(this.structurePeg.getStrnum15());
                     var107.setStrnum16(this.structurePeg.getStrnum16());
                     var107.setStrnum17(this.structurePeg.getStrnum17());
                     var107.setStrnum18(this.structurePeg.getStrnum18());
                     var107.setStrnum19(this.structurePeg.getStrnum19());
                     var107.setStrnum20(this.structurePeg.getStrnum20());
                     var107.setStrmode(this.structurePeg.getStrmode());
                     var7.save(var107);
                     var11.commit();
                  }
               } catch (HibernateException var93) {
                  if (var11 != null) {
                     var11.rollback();
                  }

                  throw var93;
               } finally {
                  this.utilInitHibernate.closeSession();
               }
            }
         }

         this.chargerSociete();
         this.structurePeg = new StructurePeg();
      }

      this.showModalPanelSociete = false;
   }

   public void configurationGroupe() throws IOException {
      this.optionGroupe = this.lireLesoptionsGroupe.lancerExploitation();
      this.optionGroupe.setTypeGroupe("" + this.cabinetPeg.getCabNature());
      this.optionGroupe.setIdGroupe("" + this.structureLog.getStrid());
      this.showModalPanelConfiguration = true;
   }

   public void fermerConfigurationGroupe() {
      this.showModalPanelConfiguration = false;
   }

   public void validerConfigurationGroupe() throws IOException, HibernateException, NamingException {
      this.lireLesoptionsGroupe.creerOptionGroupe(this.cabinetPeg.getCabNature());
      if (this.lesSocietes.size() != 0) {
         new Structure();
         int var2 = this.cabinetPeg.getCabNature() + 10;

         for(int var3 = 0; var3 < this.lesSocietes.size(); ++var3) {
            this.structurePeg = (StructurePeg)this.lesSocietes.get(var3);
            int var4 = this.structurePeg.getStrmode();
            int var5 = this.structurePeg.getStretat();
            String var6 = "structure" + this.structurePeg.getStrId();
            Session var7 = this.utilInitHibernate.getOpenSession(var6, "");
            Transaction var8 = null;

            try {
               var8 = var7.beginTransaction();
               Structure var1 = this.structureDao.logStructureId(this.structurePeg.getStrId(), var7);
               if (var1 != null) {
                  var1.setStrmaitrecabinet(var2);
                  var1.setStrmode(var4);
                  var1.setStretat(var5);
                  this.structureDao.modStructure(var1, var7);
               }

               var8.commit();
            } catch (HibernateException var13) {
               if (var8 != null) {
                  var8.rollback();
               }

               throw var13;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }
      }

      this.showModalPanelConfiguration = false;
   }

   public void modifierMandat() {
      if (this.structurePeg != null) {
         this.showModalPanelMandat = true;
      }

   }

   public void fermerMandat() {
      this.showModalPanelMandat = false;
   }

   public void validerMandat() throws HibernateException, NamingException {
      if (this.structurePeg != null) {
         this.structurePeg = this.structureDao.updatCrPeg(this.structurePeg);
         String var1 = "structure" + this.structurePeg.getStrId();
         StructureDao var2 = new StructureDao(var1, this.utilInitHibernate);
         new Structure();
         Structure var3 = var2.logStructureId(this.structurePeg.getStrId(), (Session)null);
         if (var3 != null) {
            var3.setStrmaitrecabinet(this.structurePeg.getStrmaitrecabinet());
            var3.setStrDteDebMandat(this.structurePeg.getStrdtedebmandat());
            var3.setStrDteFinMandat(this.structurePeg.getStrdtefinmandat());
            var3.setStrEtatMandat(this.structurePeg.getStretatmandat());
            var2.modStructure(var3);
         }
      }

      this.showModalPanelMandat = false;
   }

   public void utilisateurSociete() throws HibernateException, NamingException {
      if (this.structurePeg != null) {
         Session var1 = this.utilInitHibernate.getSysteme();
         new ArrayList();
         List var2 = this.userDao.selectLesUserPegStr(0L);
         this.utilInitHibernate.closeSession();
         this.lesUsersAutorise.clear();
         String var3 = "structure" + this.structurePeg.getStrId();
         var1 = this.utilInitHibernate.getOpenSession(var3, "");
         this.userDao = new UserDao(var3, this.utilInitHibernate);
         this.lesUsersAutorise = this.userDao.chargerLesUsers(var1);
         int var5;
         if (this.lesUsersAutorise.size() != 0) {
            new Users();

            for(var5 = 0; var5 < this.lesUsersAutorise.size(); ++var5) {
               Users var4 = (Users)this.lesUsersAutorise.get(var5);
               var4.setAccesDirect(this.verifAccesDirect(var4, var2));
            }
         }

         this.dataModelUsersAutorise.setWrappedData(this.lesUsersAutorise);
         this.utilInitHibernate.closeSession();
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         this.lesUsersCabinet.clear();
         new ArrayList();
         this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
         List var9 = this.userDao.selectUserActif(var1);
         this.utilInitHibernate.closeSession();
         if (this.lesUsersAutorise.size() == 0) {
            this.lesUsersCabinet = var9;
         } else if (var9.size() != 0) {
            for(var5 = 0; var5 < var9.size(); ++var5) {
               new Users();
               Users var6 = (Users)var9.get(var5);
               boolean var7 = false;

               for(int var8 = 0; var8 < this.lesUsersAutorise.size(); ++var8) {
                  if (((Users)this.lesUsersAutorise.get(var8)).getUsrMail() != null && !((Users)this.lesUsersAutorise.get(var8)).getUsrMail().isEmpty() && var6.getUsrMail() != null && !var6.getUsrMail().isEmpty() && ((Users)this.lesUsersAutorise.get(var8)).getUsrMail().equals(var6.getUsrMail())) {
                     var7 = true;
                  }
               }

               if (!var7) {
                  this.lesUsersCabinet.add(var6);
               }
            }
         }

         this.dataModelUsersCabinet.setWrappedData(this.lesUsersCabinet);
         this.users = new Users();
         this.usersFavoris = new Users();
         this.showModalPanelUsers = true;
      }

   }

   public String verifAccesDirect(Users var1, List var2) {
      String var3 = "sans";
      if (var1.getUsrMail() != null && !var1.getUsrMail().isEmpty() && var2.size() != 0) {
         for(int var4 = 0; var4 < var2.size(); ++var4) {
            if (((UsersPeg)var2.get(var4)).getStructurePeg().getStrId() == this.structurePeg.getStrId() && ((UsersPeg)var2.get(var4)).getUsrmail() != null && !((UsersPeg)var2.get(var4)).getUsrmail().isEmpty() && ((UsersPeg)var2.get(var4)).getUsrmail().equals(var1.getUsrMail())) {
               var3 = "AVEC";
               break;
            }
         }
      }

      return var3;
   }

   public void fermerUsers() {
      this.showModalPanelUsers = false;
   }

   public void selectionUserCabinet() {
      if (this.dataModelUsersCabinet.isRowAvailable()) {
         this.users = (Users)this.dataModelUsersCabinet.getRowData();
      }

   }

   public void selectionUserAutorise() {
      if (this.dataModelUsersAutorise.isRowAvailable()) {
         this.usersFavoris = (Users)this.dataModelUsersAutorise.getRowData();
      }

   }

   public void ajouterUser() throws HibernateException, NamingException {
      if (this.users != null && this.users.getUsrid() != 0L) {
         new Users();
         new Groupe();
         Groupe var2 = this.users.getGroupe();
         new Users();
         Users var3 = this.users;
         String var4 = "structure" + this.structurePeg.getStrId();
         Session var5 = this.utilInitHibernate.getOpenSession(var4, 0);
         Transaction var6 = null;

         Users var1;
         try {
            var6 = var5.beginTransaction();
            new Groupe();
            GroupeDao var8 = new GroupeDao(var4, this.utilInitHibernate);
            Groupe var7 = var8.groupeByCode(var2.getGrpCode(), var5);
            if (var7 == null) {
               new Groupe();
               var7 = var8.insertGroupe(var2, var5);
            }

            UserDao var9 = new UserDao(var4, this.utilInitHibernate);
            var1 = var9.selectByMailUsers(var3.getUsrMail(), var5);
            if (var1 == null) {
               new Users();
               var3.setGroupe(var7);
               var3.setUsrCollaboration(var7.getGrpCode());
               var1 = var9.insert(var3, var5);
            } else {
               var1.setUsrEtat(1);
               var1 = var9.modUser(var1, var5);
            }

            var6.commit();
         } catch (HibernateException var13) {
            if (var6 != null) {
               var6.rollback();
            }

            throw var13;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         var5 = this.utilInitHibernate.getSysteme();
         new ArrayList();
         List var15 = this.userDao.selectLesUserPegStr(0L);
         this.utilInitHibernate.closeSession();
         this.users.setAccesDirect(this.verifAccesDirect(this.users, var15));
         this.lesUsersAutorise.add(this.users);
         this.dataModelUsersAutorise.setWrappedData(this.lesUsersAutorise);
         this.lesUsersCabinet.remove(this.users);
         this.dataModelUsersCabinet.setWrappedData(this.lesUsersCabinet);
         Espion var16 = new Espion();
         EspionDao var17 = new EspionDao(this.baseLog, this.utilInitHibernate);
         var16.setUsers(this.usersLog);
         var16.setEsptype(0);
         var16.setEspdtecreat(new Date());
         var16.setEspaction("Le user " + var1.getUsrid() + " a été ajouté à la structure " + this.structurePeg.getStrId());
         var17.mAJEspion(var16);
      }

      this.users = new Users();
      this.usersFavoris = new Users();
   }

   public void supprimerUser() throws HibernateException, NamingException {
      if (this.usersFavoris != null && this.usersFavoris.getUsrid() != 0L) {
         boolean var1 = true;
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         Transaction var3 = null;

         try {
            var3 = var2.beginTransaction();
            this.users = this.userDao.selectByMailUsers(this.usersFavoris.getUsrMail(), var2);
            if (this.users != null) {
               this.lesUsersCabinet.add(this.users);
               this.dataModelUsersCabinet.setWrappedData(this.lesUsersCabinet);
            } else {
               this.users = new Users();
               this.users = this.usersFavoris;
               this.users = this.userDao.insert(this.users);
               this.lesUsersCabinet.add(this.users);
               this.dataModelUsersCabinet.setWrappedData(this.lesUsersCabinet);
            }

            this.lesUsersAutorise.remove(this.usersFavoris);
            this.dataModelUsersAutorise.setWrappedData(this.lesUsersAutorise);
            var3.commit();
         } catch (HibernateException var16) {
            var1 = false;
            if (var3 != null) {
               var3.rollback();
            }

            throw var16;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         if (var1) {
            String var4 = "structure" + this.structurePeg.getStrId();
            var2 = this.utilInitHibernate.getOpenSession(var4, "");
            Transaction var5 = null;

            try {
               var5 = var2.beginTransaction();
               this.users = this.userDao.selectByMailUsers(this.usersFavoris.getUsrMail(), var2);
               if (this.users != null) {
                  this.users.setUsrEtat(0);
                  this.users = this.userDao.modUser(this.users, var2);
               }

               var5.commit();
            } catch (HibernateException var18) {
               var1 = false;
               if (var5 != null) {
                  var5.rollback();
               }

               throw var18;
            } finally {
               this.utilInitHibernate.closeSession();
            }

            this.accesDirectSuppres();
         }

         Espion var20 = new Espion();
         EspionDao var21 = new EspionDao(this.baseLog, this.utilInitHibernate);
         var20.setUsers(this.usersLog);
         var20.setEsptype(0);
         var20.setEspdtecreat(new Date());
         var20.setEspaction("Le user " + this.users.getUsrid() + " a été enlevé de la structure " + this.structurePeg.getStrId());
         var21.mAJEspion(var20);
      }

      this.users = new Users();
      this.usersFavoris = new Users();
   }

   public void accesDirectAjout() throws HibernateException, NamingException {
      if (this.usersFavoris != null && this.usersFavoris.getUsrid() != 0L) {
         Session var1 = this.utilInitHibernate.getSysteme();
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            new UsersPeg();
            UsersPeg var3 = this.userDao.logLoginExiste(this.usersFavoris.getUsrMail(), this.structurePeg, var1);
            if (var3 != null) {
               var3.setUsretat(1);
               var1.update(var3);
            } else {
               var3 = new UsersPeg();
               var3.setCabinetPeg((CabinetPeg)null);
               var3.setStructurePeg(this.structurePeg);
               var3.setUsradresse(this.usersFavoris.getUsrAdresse());
               var3.setUsrbp(this.usersFavoris.getUsrBp());
               var3.setUsrcodesecret(this.usersFavoris.getUsrCodeSecret());
               var3.setUsrcollaboration(this.usersFavoris.getUsrCollaboration());
               var3.setUsrconnexion(this.usersFavoris.getUsrConnexion());
               var3.setUsrdatecreat(new Date());
               var3.setUsrdatemodif((Date)null);
               var3.setUsretat(1);
               var3.setUsrfonction(this.usersFavoris.getUsrFonction());
               var3.setUsrlangue(this.usersFavoris.getUsrLangue());
               var3.setUsrlogin(this.usersFavoris.getUsrLogin());
               var3.setUsrmail(this.usersFavoris.getUsrMail());
               var3.setUsrnom(this.usersFavoris.getUsrNom());
               var3.setUsrnompays(this.usersFavoris.getUsrNomPays());
               var3.setUsrprenom(this.usersFavoris.getUsrPrenom());
               var3.setUsrpw(this.usersFavoris.getUsrPw());
               var3.setUsrsysteme(this.usersFavoris.getUsrSysteme());
               var3.setUsrtelbureau(this.usersFavoris.getUsrTelBureau());
               var3.setUsrteldomicile(this.usersFavoris.getUsrTelDomicile());
               var3.setUsrville(this.usersFavoris.getUsrVille());
               var1.save(var3);
            }

            this.usersFavoris.setAccesDirect("AVEC");
            this.dataModelUsersAutorise.setWrappedData(this.lesUsersAutorise);
            var2.commit();
         } catch (HibernateException var7) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var7;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void accesDirectSuppres() throws HibernateException, NamingException {
      if (this.usersFavoris != null && this.usersFavoris.getUsrid() != 0L) {
         Session var1 = this.utilInitHibernate.getSysteme();
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            new UsersPeg();
            UsersPeg var3 = this.userDao.logLoginExiste(this.usersFavoris.getUsrMail(), this.structurePeg, var1);
            if (var3 != null) {
               var1.delete(var3);
            }

            this.usersFavoris.setAccesDirect("sans");
            this.dataModelUsersAutorise.setWrappedData(this.lesUsersAutorise);
            var2.commit();
         } catch (HibernateException var7) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var7;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public StructurePeg getStructurePeg() {
      return this.structurePeg;
   }

   public void setStructurePeg(StructurePeg var1) {
      this.structurePeg = var1;
   }

   public DataModel getDataModelLesSocietes() {
      return this.dataModelLesSocietes;
   }

   public void setDataModelLesSocietes(DataModel var1) {
      this.dataModelLesSocietes = var1;
   }

   public int getEtat() {
      return this.etat;
   }

   public void setEtat(int var1) {
      this.etat = var1;
   }

   public List getLesSocietes() {
      return this.lesSocietes;
   }

   public void setLesSocietes(List var1) {
      this.lesSocietes = var1;
   }

   public boolean isShowModalPanelMandat() {
      return this.showModalPanelMandat;
   }

   public void setShowModalPanelMandat(boolean var1) {
      this.showModalPanelMandat = var1;
   }

   public String getLien() {
      return this.lien;
   }

   public void setLien(String var1) {
      this.lien = var1;
   }

   public CabinetPeg getCabinetPeg() {
      return this.cabinetPeg;
   }

   public void setCabinetPeg(CabinetPeg var1) {
      this.cabinetPeg = var1;
   }

   public boolean isShowModalPanelSociete() {
      return this.showModalPanelSociete;
   }

   public void setShowModalPanelSociete(boolean var1) {
      this.showModalPanelSociete = var1;
   }

   public List getMesFormeJuridiqueItem() {
      return this.mesFormeJuridiqueItem;
   }

   public void setMesFormeJuridiqueItem(List var1) {
      this.mesFormeJuridiqueItem = var1;
   }

   public List getMesPaysItem() {
      return this.mesPaysItem;
   }

   public void setMesPaysItem(List var1) {
      this.mesPaysItem = var1;
   }

   public List getMesTypeEntrepriseItem() {
      return this.mesTypeEntrepriseItem;
   }

   public void setMesTypeEntrepriseItem(List var1) {
      this.mesTypeEntrepriseItem = var1;
   }

   public List getMesZoneCommercialeItem() {
      return this.mesZoneCommercialeItem;
   }

   public void setMesZoneCommercialeItem(List var1) {
      this.mesZoneCommercialeItem = var1;
   }

   public List getMesZoneFiscaleItem() {
      return this.mesZoneFiscaleItem;
   }

   public void setMesZoneFiscaleItem(List var1) {
      this.mesZoneFiscaleItem = var1;
   }

   public List getMesDevises() {
      return this.mesDevises;
   }

   public void setMesDevises(List var1) {
      this.mesDevises = var1;
   }

   public ObjetImmatriculation getObjetImmatriculation() {
      return this.objetImmatriculation;
   }

   public void setObjetImmatriculation(ObjetImmatriculation var1) {
      this.objetImmatriculation = var1;
   }

   public DataModel getDataModelUsersAutorise() {
      return this.dataModelUsersAutorise;
   }

   public void setDataModelUsersAutorise(DataModel var1) {
      this.dataModelUsersAutorise = var1;
   }

   public DataModel getDataModelUsersCabinet() {
      return this.dataModelUsersCabinet;
   }

   public void setDataModelUsersCabinet(DataModel var1) {
      this.dataModelUsersCabinet = var1;
   }

   public boolean isShowModalPanelUsers() {
      return this.showModalPanelUsers;
   }

   public void setShowModalPanelUsers(boolean var1) {
      this.showModalPanelUsers = var1;
   }

   public Users getUsers() {
      return this.users;
   }

   public void setUsers(Users var1) {
      this.users = var1;
   }

   public Users getUsersFavoris() {
      return this.usersFavoris;
   }

   public void setUsersFavoris(Users var1) {
      this.usersFavoris = var1;
   }

   public String getBaseLog() {
      return this.baseLog;
   }

   public void setBaseLog(String var1) {
      this.baseLog = var1;
   }

   public Structure getStructureLog() {
      return this.structureLog;
   }

   public void setStructureLog(Structure var1) {
      this.structureLog = var1;
   }

   public Users getUsersLog() {
      return this.usersLog;
   }

   public void setUsersLog(Users var1) {
      this.usersLog = var1;
   }

   public UtilInitHibernate getutilInitHibernate() {
      return this.utilInitHibernate;
   }

   public void setutilInitHibernate(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
   }

   public boolean isCreationSociete() {
      return this.creationSociete;
   }

   public void setCreationSociete(boolean var1) {
      this.creationSociete = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public String getModule01() {
      return this.module01;
   }

   public void setModule01(String var1) {
      this.module01 = var1;
   }

   public String getModule02() {
      return this.module02;
   }

   public void setModule02(String var1) {
      this.module02 = var1;
   }

   public String getModule03() {
      return this.module03;
   }

   public void setModule03(String var1) {
      this.module03 = var1;
   }

   public String getModule04() {
      return this.module04;
   }

   public void setModule04(String var1) {
      this.module04 = var1;
   }

   public String getModule05() {
      return this.module05;
   }

   public void setModule05(String var1) {
      this.module05 = var1;
   }

   public String getModule06() {
      return this.module06;
   }

   public void setModule06(String var1) {
      this.module06 = var1;
   }

   public String getModule07() {
      return this.module07;
   }

   public void setModule07(String var1) {
      this.module07 = var1;
   }

   public String getModule08() {
      return this.module08;
   }

   public void setModule08(String var1) {
      this.module08 = var1;
   }

   public String getModule09() {
      return this.module09;
   }

   public void setModule09(String var1) {
      this.module09 = var1;
   }

   public String getModule10() {
      return this.module10;
   }

   public void setModule10(String var1) {
      this.module10 = var1;
   }

   public OptionGroupe getOptionGroupe() {
      return this.optionGroupe;
   }

   public void setOptionGroupe(OptionGroupe var1) {
      this.optionGroupe = var1;
   }

   public boolean isShowModalPanelConfiguration() {
      return this.showModalPanelConfiguration;
   }

   public void setShowModalPanelConfiguration(boolean var1) {
      this.showModalPanelConfiguration = var1;
   }

   public boolean isAfficheCabinet() {
      return this.afficheCabinet;
   }

   public void setAfficheCabinet(boolean var1) {
      this.afficheCabinet = var1;
   }
}
