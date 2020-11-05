package com.epegase.forms.tiers;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.Eleves;
import com.epegase.systeme.classe.Patients;
import com.epegase.systeme.classe.Responsable;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.TransfertTiers;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.ElevesDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.PatientsDao;
import com.epegase.systeme.dao.ResponsableDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilExcel;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilMail;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilTdt;
import com.epegase.systeme.xml.OptionTiers;
import groovyjarjarcommonscli.ParseException;
import java.io.File;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.naming.NamingException;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FormTransfertTiers implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private OptionTiers optionTiers;
   private EspionDao espionDao;
   private int var_nb_max;
   private String pageIndex;
   private int typeVente;
   private FormRecherche formRecherche;
   private Chrono chrono;
   private ChronoDao chronoDao;
   private Tiers tiers = new Tiers();
   private TiersDao tiersDao;
   private Patients patients = new Patients();
   private PatientsDao patientsDao;
   private Eleves eleves = new Eleves();
   private ElevesDao elevesDao;
   private UtilDate utilDate = new UtilDate();
   private transient DataModel datamodelDocument = new ListDataModel();
   private List listDocument = new ArrayList();
   private boolean var_affiche_bouton = false;
   private int var_choix_importation;
   private boolean importSage;
   private boolean variableExcel;
   private List lesTransfertTiers;
   private TransfertTiers transfertTiers;
   private Chrono chronoTransfert;
   private int balance = 0;
   private transient DataModel dataModelChampTiers = new ListDataModel();
   private transient DataModel dataModelChampPatients = new ListDataModel();
   private transient DataModel dataModelChampEleves = new ListDataModel();
   private transient DataModel dataModelChampContacts = new ListDataModel();
   private UtilTdt utilTdt = new UtilTdt();
   private int var_currentValue = 0;
   private boolean var_showBarProgMaj = false;
   private String var_info;
   private String messageErreur;
   private List lesErreurs = new ArrayList();
   private String rub01 = "";
   private String rub02 = "";
   private String rub03 = "";
   private String rub04 = "";
   private String rub05 = "";
   private String rub06 = "";
   private String rub07 = "";
   private String rub08 = "";
   private String rub09 = "";
   private String rub10 = "";
   private String rub11 = "";
   private String rub12 = "";
   private String rub13 = "";
   private String rub14 = "";
   private String rub15 = "";
   private String rub16 = "";
   private String rub17 = "";
   private String rub18 = "";
   private String rub19 = "";
   private String rub20 = "";
   private String rub21 = "";
   private String rub22 = "";
   private String rub23 = "";
   private String rub24 = "";
   private String rub25 = "";
   private String rub26 = "";
   private String rub27 = "";
   private String rub28 = "";
   private String rub29 = "";
   private String rub30 = "";
   private String rub31 = "";
   private String rub32 = "";
   private String rub33 = "";
   private String rub34 = "";
   private String rub35 = "";
   private String rub36 = "";
   private String rub37 = "";
   private String rub38 = "";
   private String rub39 = "";
   private String rub40 = "";
   private UtilNombre utilNombre = new UtilNombre();
   private long idUserImport;
   private UserDao userDao;
   private Users usersImport;
   private List lesTransfertsImportes = new ArrayList();

   public void InstancesDaoUtilses() {
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      this.patientsDao = new PatientsDao(this.baseLog, this.utilInitHibernate);
      this.elevesDao = new ElevesDao(this.baseLog, this.utilInitHibernate);
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
      this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
   }

   public void initImportation() throws HibernateException, NamingException {
      this.dataModelChampTiers.setWrappedData(this.utilTdt.rubriqueTiers(this.utilInitHibernate, this.baseLog));
   }

   public void transfertImport(List var1) throws HibernateException, NamingException, ParseException, java.text.ParseException {
      boolean var2 = false;
      this.importSage = false;
      this.variableExcel = false;
      this.chrono = new Chrono();
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
      this.lesTransfertTiers = new ArrayList();
      if (var1.size() != 0) {
         for(int var3 = 0; var3 < var1.size(); ++var3) {
            String var4 = (String)var1.get(var3);
            if (var4.toString().contains(".xls:") || var4.toString().contains(".xlsx:") || var4.toString().contains(".XLS:") || var4.toString().contains(".XLSX:")) {
               this.variableExcel = true;
               String[] var8 = var4.split(":");
               this.importExcel(var8[1]);
               break;
            }

            if (var4 != null && !var4.isEmpty() && var4.startsWith("#FLG")) {
               this.importSage = true;
            }

            boolean var5 = false;
            String[] var6 = null;
            if (!this.variableExcel && var4 != null && !var4.isEmpty() && var4.contains(",")) {
               var6 = var4.split(",");
               int var7 = var6.length;
            } else {
               var5 = true;
            }
         }
      }

   }

   public void importExcel(String var1) throws HibernateException, NamingException {
      byte var2 = 0;
      UtilExcel var3 = new UtilExcel();
      File var4 = new File(var1);
      new ArrayList();
      List var5 = var3.lectureFichierTiers(var4);
      if (var5.size() != 0) {
         for(int var6 = 0; var6 < var5.size(); ++var6) {
            this.transfertTiers = (TransfertTiers)var5.get(var6);
            if ((this.transfertTiers.getTrfPeriode() == null || this.transfertTiers.getTrfPeriode().isEmpty()) && this.transfertTiers.getTrfColT00() != null && !this.transfertTiers.getTrfColT00().isEmpty() && !this.transfertTiers.getTrfColT00().equals("0")) {
               var2 = 6;
               this.lesTransfertTiers.add(this.transfertTiers);
            }
         }
      }

      this.datamodelDocument.setWrappedData(this.lesTransfertTiers);
      if (var2 == 6) {
         this.balance = 6;
      }

      this.var_affiche_bouton = true;
   }

   public double conversionTN(String var1) {
      double var2 = 0.0D;
      if (var1 != null && !var1.isEmpty()) {
         boolean var4 = false;
         String var5 = "";
         if (",".contains(var1)) {
            var1 = var1.replace(",", ".");
         } else if ("%".contains(var1)) {
            var1 = var1.replace("%", "");
         }

         for(int var6 = 0; var6 < var1.length(); ++var6) {
            var5 = (String)var1.subSequence(var6, var6 + 1);
            if (!"0123456789.".contains(var5)) {
               var4 = true;
               break;
            }
         }

         if (!var4) {
            var2 = Double.parseDouble(var1);
         }
      }

      return var2;
   }

   public void importTiersLibre() throws HibernateException, NamingException, java.text.ParseException, Exception {
      this.lesErreurs.clear();
      if (this.lesTransfertTiers.size() != 0) {
         this.var_showBarProgMaj = true;
         this.var_currentValue = 0;
         this.var_info = "Chargement des elements de base...";
         ResponsableDao var1 = new ResponsableDao(this.baseLog, this.utilInitHibernate);
         boolean var2 = false;
         String var3 = "";
         String var4 = "";
         String var5 = "";
         String var6 = "";
         String var7 = "";
         String var8 = "";
         String var9 = "";
         String var10 = "";
         String var11 = "";
         String var12 = "";
         String var13 = "";
         String var14 = "";
         String var15 = "";
         String var16 = "";
         String var17 = "";
         String var18 = "";
         String var19 = "";
         String var20 = "";
         String var21 = "";
         String var22 = "";
         String var23 = "";
         String var24 = "";
         String var25 = "";
         String var26 = "";
         String var27 = "";
         String var28 = "";
         String var29 = "";
         String var30 = "";
         String var31 = "";
         String var32 = "";
         String var33 = "";
         String var34 = "";
         String var35 = "";
         String var36 = "";
         String var37 = "";
         String var38 = "";
         String var39 = "";
         String var40 = "";
         String var41 = "";
         String var42 = "";
         String var43 = "";
         String var44 = "";
         String var45 = "";
         Session var46 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         Transaction var47 = null;

         try {
            var47 = var46.beginTransaction();
            var46.setFlushMode(FlushMode.MANUAL);

            for(int var48 = 0; var48 < this.lesTransfertTiers.size(); ++var48) {
               this.transfertTiers = (TransfertTiers)this.lesTransfertTiers.get(var48);
               this.var_info = "Element " + var48 + " - Nb elements : " + this.lesTransfertTiers.size();
               if (var48 != 0) {
                  double var49 = (double)this.lesTransfertTiers.size();
                  double var51 = this.utilNombre.myRound(var49 / (double)var48, 4);
                  double var53 = this.utilNombre.myRound(100.0D / var51, 2);
                  this.var_currentValue = (int)var53;
               }

               if (var48 == 0) {
                  var5 = this.transfertTiers.getTrfColT00();
                  var6 = this.transfertTiers.getTrfColT01();
                  var7 = this.transfertTiers.getTrfColT02();
                  var8 = this.transfertTiers.getTrfColT03();
                  var9 = this.transfertTiers.getTrfColT04();
                  var10 = this.transfertTiers.getTrfColT05();
                  var11 = this.transfertTiers.getTrfColT06();
                  var12 = this.transfertTiers.getTrfColT07();
                  var13 = this.transfertTiers.getTrfColT08();
                  var14 = this.transfertTiers.getTrfColT09();
                  var15 = this.transfertTiers.getTrfColT10();
                  var16 = this.transfertTiers.getTrfColT11();
                  var17 = this.transfertTiers.getTrfColT12();
                  var18 = this.transfertTiers.getTrfColT13();
                  var19 = this.transfertTiers.getTrfColT14();
                  var20 = this.transfertTiers.getTrfColT15();
                  var21 = this.transfertTiers.getTrfColT16();
                  var22 = this.transfertTiers.getTrfColT17();
                  var23 = this.transfertTiers.getTrfColT18();
                  var24 = this.transfertTiers.getTrfColT19();
                  var25 = this.transfertTiers.getTrfColT20();
                  var26 = this.transfertTiers.getTrfColT21();
                  var27 = this.transfertTiers.getTrfColT22();
                  var28 = this.transfertTiers.getTrfColT23();
                  var29 = this.transfertTiers.getTrfColT24();
                  var30 = this.transfertTiers.getTrfColT25();
                  var31 = this.transfertTiers.getTrfColT26();
                  var32 = this.transfertTiers.getTrfColT27();
                  var33 = this.transfertTiers.getTrfColT28();
                  var34 = this.transfertTiers.getTrfColT29();
                  var35 = this.transfertTiers.getTrfColT30();
                  var36 = this.transfertTiers.getTrfColT31();
                  var37 = this.transfertTiers.getTrfColT32();
                  var38 = this.transfertTiers.getTrfColT33();
                  var39 = this.transfertTiers.getTrfColT34();
                  var40 = this.transfertTiers.getTrfColT35();
                  var41 = this.transfertTiers.getTrfColT36();
                  var42 = this.transfertTiers.getTrfColT37();
                  var43 = this.transfertTiers.getTrfColT38();
                  var44 = this.transfertTiers.getTrfColT39();
                  var45 = this.transfertTiers.getTrfColT40();
               } else {
                  this.idUserImport = 0L;
                  this.usersImport = new Users();
                  boolean var60 = this.rechercheTiers(var5, this.transfertTiers.getTrfColT00(), var6, this.transfertTiers.getTrfColT01(), var7, this.transfertTiers.getTrfColT02(), var8, this.transfertTiers.getTrfColT03(), var46);
                  if (this.tiers != null) {
                     if (!var7.contains("tie_")) {
                        if ((var60 || !var7.contains("prodep_")) && (!var60 || !var7.contains("prodep_")) && (var60 || !var7.contains("protar_")) && (!var60 || !var7.contains("protar_")) && (var60 || !var7.contains("bar_")) && var60 && var7.contains("bar_")) {
                        }
                     } else {
                        if (var6 != null && !var6.isEmpty()) {
                           this.calculeRubTiers(var6, this.transfertTiers.getTrfColT01(), var46);
                        }

                        if (var7 != null && !var7.isEmpty()) {
                           this.calculeRubTiers(var7, this.transfertTiers.getTrfColT02(), var46);
                        }

                        if (var8 != null && !var8.isEmpty()) {
                           this.calculeRubTiers(var8, this.transfertTiers.getTrfColT03(), var46);
                        }

                        if (var9 != null && !var9.isEmpty()) {
                           this.calculeRubTiers(var9, this.transfertTiers.getTrfColT04(), var46);
                        }

                        if (var10 != null && !var10.isEmpty()) {
                           this.calculeRubTiers(var10, this.transfertTiers.getTrfColT05(), var46);
                        }

                        if (var11 != null && !var11.isEmpty()) {
                           this.calculeRubTiers(var11, this.transfertTiers.getTrfColT06(), var46);
                        }

                        if (var12 != null && !var12.isEmpty()) {
                           this.calculeRubTiers(var12, this.transfertTiers.getTrfColT07(), var46);
                        }

                        if (var13 != null && !var13.isEmpty()) {
                           this.calculeRubTiers(var13, this.transfertTiers.getTrfColT08(), var46);
                        }

                        if (var14 != null && !var14.isEmpty()) {
                           this.calculeRubTiers(var14, this.transfertTiers.getTrfColT09(), var46);
                        }

                        if (var15 != null && !var15.isEmpty()) {
                           this.calculeRubTiers(var15, this.transfertTiers.getTrfColT10(), var46);
                        }

                        if (var16 != null && !var16.isEmpty()) {
                           this.calculeRubTiers(var16, this.transfertTiers.getTrfColT11(), var46);
                        }

                        if (var17 != null && !var17.isEmpty()) {
                           this.calculeRubTiers(var17, this.transfertTiers.getTrfColT12(), var46);
                        }

                        if (var18 != null && !var18.isEmpty()) {
                           this.calculeRubTiers(var18, this.transfertTiers.getTrfColT13(), var46);
                        }

                        if (var19 != null && !var19.isEmpty()) {
                           this.calculeRubTiers(var19, this.transfertTiers.getTrfColT14(), var46);
                        }

                        if (var20 != null && !var20.isEmpty()) {
                           this.calculeRubTiers(var20, this.transfertTiers.getTrfColT15(), var46);
                        }

                        if (var21 != null && !var21.isEmpty()) {
                           this.calculeRubTiers(var21, this.transfertTiers.getTrfColT16(), var46);
                        }

                        if (var22 != null && !var22.isEmpty()) {
                           this.calculeRubTiers(var22, this.transfertTiers.getTrfColT17(), var46);
                        }

                        if (var23 != null && !var23.isEmpty()) {
                           this.calculeRubTiers(var23, this.transfertTiers.getTrfColT18(), var46);
                        }

                        if (var24 != null && !var24.isEmpty()) {
                           this.calculeRubTiers(var24, this.transfertTiers.getTrfColT19(), var46);
                        }

                        if (var25 != null && !var25.isEmpty()) {
                           this.calculeRubTiers(var25, this.transfertTiers.getTrfColT20(), var46);
                        }

                        if (var26 != null && !var26.isEmpty()) {
                           this.calculeRubTiers(var26, this.transfertTiers.getTrfColT21(), var46);
                        }

                        if (var27 != null && !var27.isEmpty()) {
                           this.calculeRubTiers(var27, this.transfertTiers.getTrfColT22(), var46);
                        }

                        if (var28 != null && !var28.isEmpty()) {
                           this.calculeRubTiers(var28, this.transfertTiers.getTrfColT23(), var46);
                        }

                        if (var29 != null && !var29.isEmpty()) {
                           this.calculeRubTiers(var29, this.transfertTiers.getTrfColT24(), var46);
                        }

                        if (var30 != null && !var30.isEmpty()) {
                           this.calculeRubTiers(var30, this.transfertTiers.getTrfColT25(), var46);
                        }

                        if (var31 != null && !var31.isEmpty()) {
                           this.calculeRubTiers(var31, this.transfertTiers.getTrfColT26(), var46);
                        }

                        if (var32 != null && !var32.isEmpty()) {
                           this.calculeRubTiers(var32, this.transfertTiers.getTrfColT27(), var46);
                        }

                        if (var33 != null && !var33.isEmpty()) {
                           this.calculeRubTiers(var33, this.transfertTiers.getTrfColT28(), var46);
                        }

                        if (var34 != null && !var34.isEmpty()) {
                           this.calculeRubTiers(var34, this.transfertTiers.getTrfColT29(), var46);
                        }

                        if (var35 != null && !var35.isEmpty()) {
                           this.calculeRubTiers(var35, this.transfertTiers.getTrfColT30(), var46);
                        }

                        if (var36 != null && !var36.isEmpty()) {
                           this.calculeRubTiers(var36, this.transfertTiers.getTrfColT31(), var46);
                        }

                        if (var37 != null && !var37.isEmpty()) {
                           this.calculeRubTiers(var37, this.transfertTiers.getTrfColT32(), var46);
                        }

                        if (var38 != null && !var38.isEmpty()) {
                           this.calculeRubTiers(var38, this.transfertTiers.getTrfColT33(), var46);
                        }

                        if (var39 != null && !var39.isEmpty()) {
                           this.calculeRubTiers(var39, this.transfertTiers.getTrfColT34(), var46);
                        }

                        if (var40 != null && !var40.isEmpty()) {
                           this.calculeRubTiers(var40, this.transfertTiers.getTrfColT35(), var46);
                        }

                        if (var41 != null && !var41.isEmpty()) {
                           this.calculeRubTiers(var41, this.transfertTiers.getTrfColT36(), var46);
                        }

                        if (var42 != null && !var42.isEmpty()) {
                           this.calculeRubTiers(var42, this.transfertTiers.getTrfColT37(), var46);
                        }

                        if (var43 != null && !var43.isEmpty()) {
                           this.calculeRubTiers(var43, this.transfertTiers.getTrfColT38(), var46);
                        }

                        if (var44 != null && !var44.isEmpty()) {
                           this.calculeRubTiers(var44, this.transfertTiers.getTrfColT39(), var46);
                        }

                        if (var45 != null && !var45.isEmpty()) {
                           this.calculeRubTiers(var45, this.transfertTiers.getTrfColT40(), var46);
                        }

                        if (this.tiers.getTiedevise() == null || this.tiers.getTiedevise().isEmpty()) {
                           this.tiers.setTieFormatDevise(0);
                           this.tiers.setTiedevise(this.structureLog.getStrdevise());
                        }

                        if (!this.tiers.getTiedevise().equalsIgnoreCase("XOF") && !this.tiers.getTiedevise().equalsIgnoreCase("XAF")) {
                           if (!this.tiers.getTiedevise().equalsIgnoreCase("EUR") && !this.tiers.getTiedevise().equalsIgnoreCase("CHF")) {
                              this.tiers.setTieFormatDevise(0);
                           } else {
                              this.tiers.setTieFormatDevise(2);
                           }
                        } else {
                           this.tiers.setTieFormatDevise(1);
                        }

                        if (this.tiers.getTietype() != null && !this.tiers.getTietype().isEmpty()) {
                           if (this.tiers.getTietype().equalsIgnoreCase("9")) {
                              this.tiers.setTievisibilite(2);
                           }
                        } else {
                           this.tiers.setTietype("3");
                           this.tiers.setTiegenre("031");
                           this.tiers.setTiecategorie("Client Société");
                        }

                        if (this.tiers.getTienompays() == null || this.tiers.getTienompays().isEmpty()) {
                           this.tiers.setTiecodepays(this.structureLog.getStrcodepays());
                           this.tiers.setTienompays(this.structureLog.getStrnompays());
                        }

                        if (!var60) {
                           if (this.tiers.getTiedatecreat() == null) {
                              this.tiers.setTiedatecreat(new Date());
                           }

                           if (this.idUserImport != 0L) {
                              this.tiers.setTieusercreat(this.idUserImport);
                           } else {
                              this.tiers.setTieusercreat(this.usersLog.getUsrid());
                           }

                           this.tiers = this.tiersDao.insert(this.tiers, var46);
                        } else {
                           this.tiers.setTiedatemodif(new Date());
                           if (this.idUserImport != 0L) {
                              this.tiers.setTieusercreat(this.idUserImport);
                           } else {
                              this.tiers.setTieusercreat(this.usersLog.getUsrid());
                           }

                           this.tiers = this.tiersDao.modif(this.tiers, var46);
                        }

                        var46.flush();
                        if (this.idUserImport != 0L) {
                           boolean var50 = false;
                           new ArrayList();
                           List var61 = var1.chargerLesResponsables(this.tiers, var46);
                           if (var61.size() != 0) {
                              for(int var52 = 0; var52 < var61.size(); ++var52) {
                                 if (((Responsable)var61.get(var52)).getRpbuserid() == this.idUserImport) {
                                    var1.delete((Responsable)var61.get(var52), var46);
                                 } else if (((Responsable)var61.get(var52)).getRpbdefaut() == 1) {
                                    var50 = true;
                                 } else {
                                    var50 = false;
                                 }
                              }
                           }

                           Responsable var62 = new Responsable();
                           var62.setTiers(this.tiers);
                           var62.setRpbuserid(this.idUserImport);
                           var62.setRpbcivilite(this.usersImport.getUsrCivilite());
                           var62.setRpbnom(this.usersImport.getUsrNom());
                           var62.setRpbprenom(this.usersImport.getUsrPatronyme());
                           var62.setRpbdatecreat(new Date());
                           var62.setRpbusercreat(this.usersLog.getUsrid());
                           if (!var50) {
                              var62.setRpbdefaut(1);
                           } else {
                              var62.setRpbdefaut(0);
                           }

                           var1.insert(var62, var46);
                           this.lesTransfertsImportes.add(this.transfertTiers);
                           var46.flush();
                        }
                     }
                  }
               }
            }

            var47.commit();
         } catch (HibernateException var58) {
            if (var47 != null) {
               var47.rollback();
            }

            throw var58;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         if (this.lesTransfertsImportes.size() != 0 && StaticModePegase.getInternet_actif() >= 1) {
            this.envoieMailApresImport(this.lesTransfertsImportes);
         }

         this.datamodelDocument.setWrappedData(this.lesErreurs);
         this.var_affiche_bouton = false;
         this.balance = 2;
         this.var_showBarProgMaj = false;
      }

   }

   public void envoieMailApresImport(List var1) throws Exception {
      ArrayList var2 = new ArrayList();

      int var6;
      for(int var3 = 0; var3 < var1.size(); ++var3) {
         String var4 = ((TransfertTiers)var1.get(var3)).getTrfColT11();
         boolean var5 = false;
         if (var2.size() != 0) {
            for(var6 = 0; var6 < var2.size(); ++var6) {
               if (((String)var2.get(var6)).equals(var4)) {
                  var5 = true;
                  break;
               }
            }
         }

         if (!var5) {
            var2.add(var4);
         }
      }

      if (var2.size() != 0) {
         UtilMail var9 = new UtilMail(this.structureLog);

         for(int var10 = 0; var10 < var2.size(); ++var10) {
            String var11 = (String)var2.get(var10);
            var6 = 0;

            for(int var7 = 0; var7 < var1.size(); ++var7) {
               if (((TransfertTiers)var1.get(var7)).getTrfColT11().equals(var11)) {
                  ++var6;
               }
            }

            String var12 = "";
            var12 = "<html><head></head><body>";
            var12 = var12 + "<p text-align:left;>";
            String var8 = "";
            if (var8.equals("")) {
               var8 = "Madame, Monsieur";
            }

            var12 = var12 + "Bonjour, " + var8 + ", <br/>" + "<br/>";
            var12 = var12 + "</p>";
            var12 = var12 + "<p>Vous avez recu " + var6 + " prospects le " + this.utilDate.dateToStringFr(new Date()) + "<br/>";
            var12 = var12 + "</p>";
            var12 = var12 + "<p>Emetteur : &nbsp; " + this.structureLog.getStrraisonsociale() + "<br/>";
            var12 = var12 + "Contact : &nbsp; " + this.usersLog.getUsrCivilite() + " " + this.usersLog.getUsrPatronyme();
            var12 = var12 + "</p>";
            var12 = var12 + "<p>Restant &agrave; votre &eacute;coute pour toutes informations compl&eacute;mentaires, veuillez agr&eacute;er, " + var8 + ", l'expressions de nos sentiments distingu&eacute;s. " + "<br/>" + "<br/>";
            if (this.usersLog.getUsrPrenom() != null && !this.usersLog.getUsrPrenom().isEmpty()) {
               var12 = var12 + "Cordialement, <br/>" + this.usersLog.getUsrPrenom() + "." + "<br/>";
            } else {
               var12 = var12 + "Cordialement, <br/>" + this.usersLog.getUsrNom() + "." + "<br/>";
            }

            var12 = var12 + "</p>";
            var12 = var12 + "<p style=\"color:red;font-weight:bold;font-size:8px;\">Ce message vous est envoy&eacute; automatiquement &agrave; partir de la plateforme de gestion e-P&eacute;gase (https://www.e-pegase.biz).</p>";
            var12 = var12 + "<p>";
            var12 = var12 + "</p>";
            var12 = var12 + "</body></html>";
            var9.mailImportProspect(var12, var11, "Importation des prospects du " + this.utilDate.dateToStringFr(new Date()));
         }
      }

   }

   public boolean rechercheTiers(String var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, Session var9) throws HibernateException, NamingException {
      boolean var10 = false;
      String var11 = "";
      String var12 = "";
      String var13 = "";
      if (var5 != null && !var5.isEmpty() && var5.equals("tie_type") && var7 != null && !var7.isEmpty() && var7.equals("tie_genre")) {
         var11 = this.enlevePoint(var6);
         var13 = this.enlevePoint(var8);
         if (var13.startsWith("000")) {
            var12 = "Artisan";
         } else if (var13.startsWith("001")) {
            var12 = "Fournisseur";
         } else if (var13.startsWith("010")) {
            var12 = "Suspect Individuel";
         } else if (var13.startsWith("011")) {
            var12 = "Suspect Société";
         } else if (var13.startsWith("020")) {
            var12 = "Prospect Individuel";
         } else if (var13.startsWith("021")) {
            var12 = "Prospect Société";
         } else if (var13.startsWith("030")) {
            var12 = "Client Individuel";
         } else if (var13.startsWith("031")) {
            var12 = "Client Société";
         } else if (var13.startsWith("099")) {
            var12 = "Divers";
         }
      } else if (var5 != null && !var5.isEmpty() && var5.equals("tie_type")) {
         var13 = this.enlevePoint(var4);
         if (var13.startsWith("0")) {
            var13 = "000";
            var11 = "0";
            var12 = "Artisan";
         } else if (var13.startsWith("1")) {
            var13 = "001";
            var11 = "0";
            var12 = "Fournisseur";
         } else if (var13.startsWith("10")) {
            var13 = "010";
            var11 = "1";
            var12 = "Suspect Individuel";
         } else if (var13.startsWith("11")) {
            var13 = "011";
            var11 = "1";
            var12 = "Suspect Société";
         } else if (var13.startsWith("20")) {
            var13 = "020";
            var11 = "2";
            var12 = "Prospect Individuel";
         } else if (var13.startsWith("21")) {
            var13 = "021";
            var11 = "2";
            var12 = "Prospect Société";
         } else if (var13.startsWith("30")) {
            var13 = "030";
            var11 = "3";
            var12 = "Client Individuel";
         } else if (var13.startsWith("31")) {
            var13 = "031";
            var11 = "3";
            var12 = "Client Société";
         } else if (var13.startsWith("99")) {
            var13 = "099";
            var11 = "9";
            var12 = "Divers";
         }
      } else {
         var13 = "099";
         var11 = "9";
         var12 = "Divers";
      }

      if (var3 != null && !var3.isEmpty() && var3.equals("tie_prenom")) {
         this.tiers = this.tiersDao.rechercheLesTiers(var13, var2, var4, var9);
      } else {
         this.tiers = this.tiersDao.rechercheLesTiers(var13, var2, var9);
      }

      if (this.tiers == null) {
         this.tiers = new Tiers();
         this.tiers.setTiegenre(var13);
         this.tiers.setTietype(var11);
         this.tiers.setTiecategorie(var12);
         this.tiers.setTieraisonsocialenom(var2);
         this.tiers.setTieprenom(var4);
         var10 = false;
      } else {
         var10 = true;
      }

      return var10;
   }

   public String enlevePoint(String var1) {
      String var2 = "";
      if (var1 != null && !var1.isEmpty() && var1.contains(".0")) {
         int var3 = var1.indexOf(".0");
         var2 = var1.substring(0, var3);
      } else {
         var2 = var1;
      }

      if (var2 != null && !var2.isEmpty()) {
         var2 = var2.replace("'", "`");
      }

      return var2;
   }

   public int conversionInteger(String var1) {
      String var2 = "";
      int var3 = 0;
      if (var1 != null && !var1.isEmpty()) {
         if (var1.contains(".0")) {
            int var4 = var1.indexOf(".0");
            var2 = var1.substring(0, var4);
         } else {
            var2 = var1;
         }

         var3 = Integer.parseInt(var2);
      }

      return var3;
   }

   public double conversionDouble(String var1) {
      String var2 = "";
      double var3 = 0.0D;
      if (var1 != null && !var1.isEmpty()) {
         var3 = Double.parseDouble(var1);
      }

      return var3;
   }

   public Boolean conversionBoolean(String var1) {
      boolean var2 = false;
      if (var1 != null && !var1.isEmpty() && (var1.equals("1") || var1.equals("true") || var1.equals("TRUE"))) {
         var2 = true;
      }

      return var2;
   }

   public long conversionLong(String var1) {
      String var2 = "";
      long var3 = 0L;
      if (var1 != null && !var1.isEmpty()) {
         if (var1.contains(".0")) {
            int var5 = var1.indexOf(".0");
            var2 = var1.substring(0, var5);
         } else {
            var2 = var1;
         }

         var3 = Long.parseLong(var2);
      }

      return var3;
   }

   public Date conversionDate(String var1) throws java.text.ParseException {
      Date var2 = null;
      if (var1 != null && !var1.isEmpty()) {
         if (var1.contains("-")) {
            if (var1.substring(4, 4).equals("-")) {
               String[] var3 = var1.split("-");
               String var4 = var3[2];
               String var5 = var3[1];
               String var6 = var3[0];
               var2 = this.utilDate.stringToDateSQLLight(var4 + "-" + var5 + "-" + var6);
            } else {
               var2 = this.utilDate.stringToDateSQLLight(var1);
            }
         } else {
            int var7 = this.conversionInteger(var1);
            if (var7 >= 10000 && var7 <= 60000) {
               GregorianCalendar var8 = new GregorianCalendar(1900, 0, 1);
               var8.add(5, var7 - 2);
               var2 = var8.getTime();
            } else {
               var2 = null;
            }
         }
      } else {
         var2 = null;
      }

      return var2;
   }

   public String conversionAnniversaire(Date var1) {
      String var2 = "";
      if (var1 != null) {
         DateFormat var3 = DateFormat.getDateInstance(3);
         var2 = var3.format(var1).substring(0, 5);
      }

      return var2;
   }

   public void calculeRubTiers(String var1, String var2, Session var3) throws java.text.ParseException, HibernateException, NamingException {
      this.messageErreur = "";
      if (var1.equalsIgnoreCase("tie_etat")) {
         if (var2 != null && !var2.isEmpty()) {
            this.tiers.setTieetat(this.conversionInteger(var2));
         }
      } else if (var1.equalsIgnoreCase("tie_raison_sociale_nom")) {
         if (var2 != null && !var2.isEmpty()) {
            this.tiers.setTieraisonsocialenom(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("tie_sigle")) {
         if (var2 != null && !var2.isEmpty()) {
            this.tiers.setTiesigle(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("tie_type")) {
         if (var2 != null && !var2.isEmpty()) {
            this.tiers.setTietype(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("tie_genre")) {
         if (var2 != null && !var2.isEmpty()) {
            this.tiers.setTiegenre(this.enlevePoint(var2));
         }
      } else if (var1.equalsIgnoreCase("tie_categorie")) {
         if (var2 != null && !var2.isEmpty()) {
            this.tiers.setTiecategorie(this.enlevePoint(var2));
         }
      } else if (var1.equalsIgnoreCase("tie_civilite")) {
         if (var2 != null && !var2.isEmpty()) {
            this.tiers.setTiecivilite(this.enlevePoint(var2));
         }
      } else if (var1.equalsIgnoreCase("tie_nom_pays")) {
         if (var2 != null && !var2.isEmpty()) {
            this.tiers.setTienompays(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("tie_code_pays")) {
         if (var2 != null && !var2.isEmpty()) {
            this.tiers.setTiecodepays(this.enlevePoint(var2));
         }
      } else if (var1.equalsIgnoreCase("tie_devise")) {
         if (var2 != null && !var2.isEmpty()) {
            this.tiers.setTiedevise(this.enlevePoint(var2));
         }
      } else if (var1.equalsIgnoreCase("tie_format_devise")) {
         if (var2 != null && !var2.isEmpty()) {
            this.tiers.setTieFormatDevise(this.conversionInteger(var2));
         }
      } else if (var1.equalsIgnoreCase("tie_langue")) {
         if (var2 != null && !var2.isEmpty()) {
            this.tiers.setTielangue(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("tie_type_adresse")) {
         if (var2 != null && !var2.isEmpty()) {
            this.tiers.setTieadresse(this.enlevePoint(var2));
         }
      } else if (var1.equalsIgnoreCase("tie_tel_dom")) {
         if (var2 != null && !var2.isEmpty()) {
            this.tiers.setTieteldom(this.enlevePoint(var2));
         }
      } else if (var1.equalsIgnoreCase("tie_cel1")) {
         if (var2 != null && !var2.isEmpty()) {
            this.tiers.setTiecel1(this.enlevePoint(var2));
         }
      } else if (var1.equalsIgnoreCase("tie_cel2")) {
         if (var2 != null && !var2.isEmpty()) {
            this.tiers.setTiecel2(this.enlevePoint(var2));
         }
      } else if (var1.equalsIgnoreCase("tie_cel3")) {
         if (var2 != null && !var2.isEmpty()) {
            this.tiers.setTiecel3(this.enlevePoint(var2));
         }
      } else if (var1.equalsIgnoreCase("tie_tel_voiture")) {
         if (var2 != null && !var2.isEmpty()) {
            this.tiers.setTietelvoiture(this.enlevePoint(var2));
         }
      } else if (var1.equalsIgnoreCase("tie_prenom")) {
         if (var2 != null && !var2.isEmpty()) {
            this.tiers.setTieprenom(this.enlevePoint(var2));
         }
      } else if (var1.equalsIgnoreCase("tie_nom_jf")) {
         if (var2 != null && !var2.isEmpty()) {
            this.tiers.setTienomjf(this.enlevePoint(var2));
         }
      } else if (var1.equalsIgnoreCase("tie_surnom")) {
         if (var2 != null && !var2.isEmpty()) {
            this.tiers.setTiesurnom(this.enlevePoint(var2));
         }
      } else if (var1.equalsIgnoreCase("tie_sexe")) {
         if (var2 != null && !var2.isEmpty()) {
            this.tiers.setTiesexe(this.conversionInteger(var2));
         }
      } else if (var1.equalsIgnoreCase("tie_date_naissance")) {
         if (var2 != null && !var2.isEmpty()) {
            this.tiers.setTiedatenaissance(this.conversionDate(var2));
            this.tiers.setTieanniversaire(this.conversionAnniversaire(this.tiers.getTiedatenaissance()));
         }
      } else if (var1.equalsIgnoreCase("tie_lieu_naissance")) {
         if (var2 != null && !var2.isEmpty()) {
            this.tiers.setTielieunaissance(this.enlevePoint(var2).toUpperCase());
         }
      } else if (!var1.equalsIgnoreCase("tie_anniversaire")) {
         if (var1.equalsIgnoreCase("tie_date_mariage")) {
            if (var2 != null && !var2.isEmpty()) {
               this.tiers.setTiedatemariage(this.conversionDate(var2));
               this.tiers.setTieanniversairemariage(this.conversionAnniversaire(this.tiers.getTiedatemariage()));
            }
         } else if (!var1.equalsIgnoreCase("tie_anniversaire_mariage")) {
            if (var1.equalsIgnoreCase("tie_date_deces")) {
               if (var2 != null && !var2.isEmpty()) {
                  this.tiers.setTiedatedeces(this.conversionDate(var2));
                  this.tiers.setTieanniversairedeces(this.conversionAnniversaire(this.tiers.getTiedatedeces()));
               }
            } else if (!var1.equalsIgnoreCase("tie_anniversaire_deces")) {
               if (var1.equalsIgnoreCase("tie_observations")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTieobservations(this.enlevePoint(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_activite1")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTieactivite1(this.enlevePoint(var2).toUpperCase());
                  }
               } else if (var1.equalsIgnoreCase("tie_activite2")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTieactivite2(this.enlevePoint(var2).toUpperCase());
                  }
               } else if (var1.equalsIgnoreCase("tie_source")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTiesource(this.enlevePoint(var2).toUpperCase());
                  }
               } else if (var1.equalsIgnoreCase("tie_visibilite")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTievisibilite(this.conversionInteger(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_visibilite_grp")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTievisibiliteGrp(this.enlevePoint(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_visibilite_user")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTievisibiliteUser((long)this.conversionInteger(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_adresse")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTieadresse(this.enlevePoint(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_rue")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTierue(this.enlevePoint(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_lot")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTielot(this.enlevePoint(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_ilot")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTieilot(this.enlevePoint(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_batiment")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTiebatiment(this.enlevePoint(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_porte")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTieporte(this.enlevePoint(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_etage")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTieetage(this.enlevePoint(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_ascensseur")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTieascensseur(this.enlevePoint(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_quartier")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTiequartier(this.enlevePoint(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_commune")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTiecommune(this.enlevePoint(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_depart")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTiedepart(this.enlevePoint(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_zone")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTiezone(this.enlevePoint(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_bp")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTiebp(this.enlevePoint(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_cedex")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTiecedex(this.enlevePoint(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_ville")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTieville(this.enlevePoint(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_bur_tel1")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTieburtel1(this.enlevePoint(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_bur_tel2")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTieburtel2(this.enlevePoint(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_bur_tel3")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTieburtel3(this.enlevePoint(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_bur_fax")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTieburfax(this.enlevePoint(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_telex")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTietelex(this.enlevePoint(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_yahoo")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTieyahoo(this.enlevePoint(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_msn")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTiemsn(this.enlevePoint(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_skype")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTieskype(this.enlevePoint(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_aol")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTieaol(this.enlevePoint(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_mail1")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTiemail1(this.enlevePoint(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_mail2")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTiemail2(this.enlevePoint(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_mail3")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTiemail3(this.enlevePoint(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_mail4")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTiemail4(this.enlevePoint(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_mail5")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTiemail5(this.enlevePoint(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_web")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTieweb(this.enlevePoint(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_mode_reg")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTiemodereg(this.enlevePoint(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_type_reg")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTietypereg(this.conversionInteger(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_nb_echeance")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTienbecheance(this.conversionInteger(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_nb_arrondi")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTienbarrondi(this.conversionInteger(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_journal_reg")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTiejournalreg(this.enlevePoint(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_condition_reg")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTieconditionreg(this.enlevePoint(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_plafond")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTieplafond(this.conversionDouble(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_depotavance")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTiedepotavance(this.conversionDouble(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_capatente")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTiecapatente(this.conversionDouble(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_plaf_patente")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTieplafpatente(this.conversionDouble(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_compte_bloque")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTiecomptebloque(this.conversionInteger(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_cheque_interdit")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTiechequeinterdit(this.conversionInteger(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_surveille")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTiesurveille(this.conversionInteger(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_nb_incident")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTienbincident(this.conversionInteger(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_nom_famille")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTienomfamille(this.enlevePoint(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_serie")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTieserie(this.enlevePoint(var2).toUpperCase());
                  }
               } else if (var1.equalsIgnoreCase("tie_exo_douane")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTieexodouane(this.conversionInteger(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_exo_tva")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTieexotva(this.conversionInteger(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_transfert_cpte")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTietransfertCpte(this.conversionInteger(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_depot")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTiedepot(this.enlevePoint(var2).toUpperCase());
                  }
               } else if (var1.equalsIgnoreCase("tie_escompte")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTieescompte((float)this.conversionDouble(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_fac_pr")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTiefacpr(this.conversionInteger(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_nom_banque")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTienombanque(this.enlevePoint(var2).toUpperCase());
                  }
               } else if (var1.equalsIgnoreCase("tie_adresse_banque")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTieadressebanque(this.enlevePoint(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_num_banque")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTienumbanque(this.enlevePoint(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_guichet_banque")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTieguichetbanque(this.enlevePoint(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_compte_banque")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTiecomptebanque(this.enlevePoint(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_cle_banque")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTieclebanque(this.enlevePoint(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_iban")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTieiban(this.enlevePoint(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_swift")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTieswift(this.enlevePoint(var2));
                  }
               } else if (var1.equalsIgnoreCase("tie_compte_0")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTiecompte0(this.enlevePoint(var2));
                     if (this.tiers.getTiecompte0() != null && !this.tiers.getTiecompte0().isEmpty() && this.tiers.getTiecompte0().equals("0")) {
                        this.tiers.setTiecompte0("");
                     }
                  }
               } else if (var1.equalsIgnoreCase("tie_compte_1")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTiecompte1(this.enlevePoint(var2));
                     if (this.tiers.getTiecompte1() != null && !this.tiers.getTiecompte1().isEmpty() && this.tiers.getTiecompte1().equals("0")) {
                        this.tiers.setTiecompte1("");
                     }
                  }
               } else if (var1.equalsIgnoreCase("tie_compte_2")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTiecompte2(this.enlevePoint(var2));
                     if (this.tiers.getTiecompte2() != null && !this.tiers.getTiecompte2().isEmpty() && this.tiers.getTiecompte2().equals("0")) {
                        this.tiers.setTiecompte2("");
                     }
                  }
               } else if (var1.equalsIgnoreCase("tie_compte_3")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTiecompte3(this.enlevePoint(var2));
                     if (this.tiers.getTiecompte3() != null && !this.tiers.getTiecompte3().isEmpty() && this.tiers.getTiecompte3().equals("0")) {
                        this.tiers.setTiecompte3("");
                     }
                  }
               } else if (var1.equalsIgnoreCase("tie_compte_4")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTiecompte4(this.enlevePoint(var2));
                     if (this.tiers.getTiecompte4() != null && !this.tiers.getTiecompte4().isEmpty() && this.tiers.getTiecompte4().equals("0")) {
                        this.tiers.setTiecompte4("");
                     }
                  }
               } else if (var1.equalsIgnoreCase("tie_compte_sage")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTiecompteSage(this.enlevePoint(var2));
                     if (this.tiers.getTiecompteSage() != null && !this.tiers.getTiecompteSage().isEmpty() && this.tiers.getTiecompteSage().equals("0")) {
                        this.tiers.setTiecompteSage("");
                     }
                  }
               } else if (var1.equalsIgnoreCase("tie_compte_etat")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.tiers.setTiecompteEtat(this.enlevePoint(var2));
                  }
               } else if (!var1.equalsIgnoreCase("tie_note_auto")) {
                  if (var1.equalsIgnoreCase("tie_note_man")) {
                     if (var2 != null && !var2.isEmpty()) {
                        this.tiers.setTienoteman(this.enlevePoint(var2));
                     }
                  } else if (!var1.equalsIgnoreCase("tie_no_use_1") && !var1.equalsIgnoreCase("tie_no_use_2")) {
                     if (var1.equalsIgnoreCase("tie_epoux")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTieepoux(this.enlevePoint(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_nom_pere")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTienompere(this.enlevePoint(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_nom_mere")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTienommere(this.enlevePoint(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_ci_num")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTiecinum(this.enlevePoint(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_ci_date")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTiecidate(this.enlevePoint(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_ci_lieu")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTiecilieu(this.enlevePoint(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_profession")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTieprofession(this.enlevePoint(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_niveau_etude")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTieniveauetude(this.enlevePoint(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_employeur")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTieemployeur(this.enlevePoint(var2).toUpperCase());
                        }
                     } else if (var1.equalsIgnoreCase("tie_adresse_employeur")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTieadresseemployeur(this.enlevePoint(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_bp_employeur")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTiebpemployeur(this.enlevePoint(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_ville_employeur")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTievilleemployeur(this.enlevePoint(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_tel_employeur")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTietelemployeur(this.enlevePoint(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_num1")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTienum1(this.enlevePoint(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_num2")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTienum2(this.enlevePoint(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_num3")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTienum3(this.enlevePoint(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_num4")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTienum4(this.enlevePoint(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_num5")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTienum5(this.enlevePoint(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_num6")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTienum6(this.enlevePoint(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_num7")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTienum7(this.enlevePoint(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_num8")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTienum8(this.enlevePoint(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_num9")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTienum9(this.enlevePoint(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_num10")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTienum10(this.enlevePoint(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_num11")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTienum11(this.enlevePoint(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_num12")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTienum12(this.enlevePoint(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_num13")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTienum13(this.enlevePoint(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_num14")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTienum14(this.enlevePoint(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_num15")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTienum15(this.enlevePoint(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_num16")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTienum16(this.enlevePoint(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_num17")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTienum17(this.enlevePoint(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_num18")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTienum18(this.enlevePoint(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_num19")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTienum19(this.enlevePoint(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_num20")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTienum20(this.enlevePoint(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_pdv")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTiepdv(this.enlevePoint(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_secteur")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTiesecteur(this.enlevePoint(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_region")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTieregion(this.enlevePoint(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_assurt1")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTieassurt1((float)this.conversionDouble(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_assurt2")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTieassurt2((double)((float)this.conversionDouble(var2)));
                        }
                     } else if (var1.equalsIgnoreCase("tie_assurt3")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTieassurt3((float)this.conversionDouble(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_bnq1")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTiebnq1(this.conversionDouble(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_bnq2")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTiebnq2((float)this.conversionDouble(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_bnq3")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTiebnq3(this.conversionDouble(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_bnq4")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTiebnq4((float)this.conversionDouble(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_bnq5")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTiebnq5(this.conversionDouble(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_bnq6")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTiebnq6((float)this.conversionDouble(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_bnq7")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTiebnq7((float)this.conversionDouble(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_photo")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTiePhoto(this.enlevePoint(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_assujettissement")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTieAssujettissement(this.conversionInteger(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_declaration_tva")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTieDeclarationTva(this.conversionInteger(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_fiscal")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTiefiscal(this.enlevePoint(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_taux_com")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTietauxcom((float)this.conversionDouble(var2));
                        }
                     } else if (var1.equalsIgnoreCase("tie_mode_com")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.tiers.setTiemodecom(this.conversionInteger(var2));
                        }
                     } else if (!var1.equalsIgnoreCase("tie_dte_reglement") && !var1.equalsIgnoreCase("tie_dte_document2") && !var1.equalsIgnoreCase("tie_dte_document3") && !var1.equalsIgnoreCase("tie_dte_document4") && !var1.equalsIgnoreCase("tie_dte_document5") && !var1.equalsIgnoreCase("tie_dte_document6") && !var1.equalsIgnoreCase("tie_dte_document7")) {
                        if (var1.equalsIgnoreCase("tie_coef_pv_medical")) {
                           if (var2 != null && !var2.isEmpty()) {
                              this.tiers.setTiecoefpvmedical((float)this.conversionDouble(var2));
                           }
                        } else if (var1.equalsIgnoreCase("tie_convention_gele")) {
                           if (var2 != null && !var2.isEmpty()) {
                              this.tiers.setTieconventiongele(this.conversionBoolean(var2));
                           }
                        } else if (var1.equalsIgnoreCase("tie_motif_gele")) {
                           if (var2 != null && !var2.isEmpty()) {
                              this.tiers.setTiemotifgele(this.enlevePoint(var2));
                           }
                        } else if (var1.equalsIgnoreCase("tie_lettre_garantie")) {
                           if (var2 != null && !var2.isEmpty()) {
                              this.tiers.setTielettregarantie(this.conversionBoolean(var2));
                           }
                        } else if (var1.equalsIgnoreCase("tie_id_groupe")) {
                           if (var2 != null && !var2.isEmpty()) {
                              this.tiers.setTieidgroupe(this.conversionLong(var2));
                           }
                        } else if (var1.equalsIgnoreCase("tie_id_old")) {
                           if (var2 != null && !var2.isEmpty()) {
                              this.tiers.setTieidold(this.conversionLong(var2));
                           }
                        } else if (var1.equalsIgnoreCase("tie_sit_fam")) {
                           if (var2 != null && !var2.isEmpty()) {
                              this.tiers.setTiesitfam(this.conversionInteger(var2));
                           }
                        } else if (var1.equalsIgnoreCase("tie_nb_charge")) {
                           if (var2 != null && !var2.isEmpty()) {
                              this.tiers.setTienbcharge(this.conversionInteger(var2));
                           }
                        } else if (var1.equalsIgnoreCase("tie_nb_enf")) {
                           if (var2 != null && !var2.isEmpty()) {
                              this.tiers.setTienbenf(this.conversionInteger(var2));
                           }
                        } else if (var1.equalsIgnoreCase("tie_habitation")) {
                           if (var2 != null && !var2.isEmpty()) {
                              this.tiers.setTiehabitation(this.conversionInteger(var2));
                           }
                        } else if (var1.equalsIgnoreCase("tie_date_demande_ouverture")) {
                           if (var2 != null && !var2.isEmpty()) {
                              this.tiers.setTiedateDemandeOuverture(this.conversionDate(var2));
                           }
                        } else if (var1.equalsIgnoreCase("tie_date_demande_reponse")) {
                           if (var2 != null && !var2.isEmpty()) {
                              this.tiers.setTiedateDemandeReponse(this.conversionDate(var2));
                           }
                        } else if (var1.equalsIgnoreCase("tie_date_demande_type")) {
                           if (var2 != null && !var2.isEmpty()) {
                              this.tiers.setTiedateDemandeType(this.conversionInteger(var2));
                           }
                        } else if (var1.equalsIgnoreCase("tie_date_demande_refus")) {
                           if (var2 != null && !var2.isEmpty()) {
                              this.tiers.setTiedateDemandeRefus(this.enlevePoint(var2));
                           }
                        } else if (var1.equalsIgnoreCase("tie_date_demande_signature")) {
                           if (var2 != null && !var2.isEmpty()) {
                              this.tiers.setTiedateDemandeSignature(this.enlevePoint(var2));
                           }
                        } else if (var1.equalsIgnoreCase("tie_interet")) {
                           if (var2 != null && !var2.isEmpty()) {
                              this.tiers.setTieinteret(this.enlevePoint(var2));
                           }
                        } else if (var1.equalsIgnoreCase("tie_date_creat")) {
                           if (var2 != null && !var2.isEmpty()) {
                              this.tiers.setTiedatecreat(this.conversionDate(var2));
                           }
                        } else if (var1.equalsIgnoreCase("responsable_mail")) {
                           this.idUserImport = 0L;
                           if (var2 != null && !var2.isEmpty()) {
                              String var4 = this.enlevePoint(var2).toLowerCase();
                              this.usersImport = this.userDao.selectByMailUsersActif(var4, var3);
                              if (this.usersImport != null) {
                                 this.idUserImport = this.usersImport.getUsrid();
                              } else {
                                 this.messageErreur = "Le mail " + var4 + " du user n`existe pas... ";
                              }
                           }
                        } else {
                           this.messageErreur = "La rubrique " + var1 + " n`existe pas...";
                        }
                     }
                  }
               }
            }
         }
      }

      if (this.messageErreur != null && !this.messageErreur.isEmpty()) {
         this.transfertTiers.setTrfNomFeuille(this.messageErreur);
         this.lesErreurs.add(this.transfertTiers);
      }

   }

   public DataModel getDatamodelDocument() {
      return this.datamodelDocument;
   }

   public void setDatamodelDocument(DataModel var1) {
      this.datamodelDocument = var1;
   }

   public List getListDocument() {
      return this.listDocument;
   }

   public void setListDocument(List var1) {
      this.listDocument = var1;
   }

   public boolean isVar_affiche_bouton() {
      return this.var_affiche_bouton;
   }

   public void setVar_affiche_bouton(boolean var1) {
      this.var_affiche_bouton = var1;
   }

   public int getVar_nb_max() {
      return this.var_nb_max;
   }

   public void setVar_nb_max(int var1) {
      this.var_nb_max = var1;
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

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public int getTypeVente() {
      return this.typeVente;
   }

   public void setTypeVente(int var1) {
      this.typeVente = var1;
   }

   public int getBalance() {
      return this.balance;
   }

   public void setBalance(int var1) {
      this.balance = var1;
   }

   public int getVar_choix_importation() {
      return this.var_choix_importation;
   }

   public void setVar_choix_importation(int var1) {
      this.var_choix_importation = var1;
   }

   public int getVar_currentValue() {
      return this.var_currentValue;
   }

   public void setVar_currentValue(int var1) {
      this.var_currentValue = var1;
   }

   public String getVar_info() {
      return this.var_info;
   }

   public void setVar_info(String var1) {
      this.var_info = var1;
   }

   public boolean isVar_showBarProgMaj() {
      return this.var_showBarProgMaj;
   }

   public void setVar_showBarProgMaj(boolean var1) {
      this.var_showBarProgMaj = var1;
   }

   public OptionTiers getOptionTiers() {
      return this.optionTiers;
   }

   public void setOptionTiers(OptionTiers var1) {
      this.optionTiers = var1;
   }

   public DataModel getDataModelChampContacts() {
      return this.dataModelChampContacts;
   }

   public void setDataModelChampContacts(DataModel var1) {
      this.dataModelChampContacts = var1;
   }

   public DataModel getDataModelChampEleves() {
      return this.dataModelChampEleves;
   }

   public void setDataModelChampEleves(DataModel var1) {
      this.dataModelChampEleves = var1;
   }

   public DataModel getDataModelChampPatients() {
      return this.dataModelChampPatients;
   }

   public void setDataModelChampPatients(DataModel var1) {
      this.dataModelChampPatients = var1;
   }

   public DataModel getDataModelChampTiers() {
      return this.dataModelChampTiers;
   }

   public void setDataModelChampTiers(DataModel var1) {
      this.dataModelChampTiers = var1;
   }
}
