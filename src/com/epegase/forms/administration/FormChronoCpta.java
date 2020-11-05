package com.epegase.forms.administration;

import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.JournauxComptables;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.EcrituresDao;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FormChronoCpta implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private List chronoList = new ArrayList();
   private transient DataModel datamodelChrono = new ListDataModel();
   private ChronoDao chronoDao;
   private Chrono chrono = new Chrono();
   private boolean showModalPanel = false;
   private boolean showModalPanelAuto = false;
   private boolean testSelectChrono = false;
   private boolean visibiliteBton = false;
   private boolean visibiliteBtonAjt = false;
   private int nbrCaracteresSelect = 0;
   private String prefSelect = "";
   private long numSelect = 0L;
   private String sufxSelect = "";
   private int modCalcSelect = 0;
   private int formatChonoSelect = 0;
   private boolean var_desactive_format = false;
   private boolean var_desactive_mode = false;
   private boolean testSerieX = false;
   private boolean testDoubleChrono = false;
   private List mesModes = new ArrayList();
   private List mesFormats = new ArrayList();
   private ExercicesComptable exercicesComptable;
   private ExercicesComptableDao exercicesComptableDao;
   private JournauxComptablesDao journauxComptablesDao;
   private List lesCodesJournauxItems = new ArrayList();
   private ExercicesComptable selectedExo;
   private boolean testSelectChronoJouranux = false;
   private EcrituresDao ecrituresDao;
   private boolean recalculChronos;
   private List chronoTmp = new ArrayList();
   private List lesPeriodesItems = new ArrayList();
   private String periode;

   public void InstancesDaoUtilses() {
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
      this.journauxComptablesDao = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
      this.exercicesComptableDao = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
      this.ecrituresDao = new EcrituresDao(this.baseLog, this.utilInitHibernate);
   }

   public void lesChronos(Session var1) throws HibernateException, NamingException {
      this.chronoList.clear();
      this.chronoTmp.clear();
      this.chronoTmp = this.chronoDao.selectListCompta(this.usersLog.getUsrJrxReserve(), var1);
      if (this.chronoTmp.size() != 0) {
         for(int var2 = 0; var2 < this.chronoTmp.size(); ++var2) {
            this.chrono = (Chrono)this.chronoTmp.get(var2);
            if (this.chrono.getChrPeriode() != null && !this.chrono.getChrPeriode().isEmpty()) {
               if (this.lesPeriodesItems.size() == 0) {
                  this.lesPeriodesItems.add(new SelectItem(this.chrono.getChrPeriode()));
               } else {
                  boolean var3 = false;

                  for(int var4 = 0; var4 < this.lesPeriodesItems.size(); ++var4) {
                     if (((SelectItem)this.lesPeriodesItems.get(var4)).getValue().toString().equals(this.chrono.getChrPeriode())) {
                        var3 = true;
                        break;
                     }
                  }

                  if (!var3) {
                     this.lesPeriodesItems.add(new SelectItem(this.chrono.getChrPeriode()));
                  }
               }
            }
         }

         if (this.lesPeriodesItems.size() != 0) {
            this.periode = ((SelectItem)this.lesPeriodesItems.get(this.lesPeriodesItems.size() - 1)).getValue().toString();
         } else {
            this.periode = "";
         }
      }

      this.chargeChronoPeriode();
      this.exercicesComptable = this.exercicesComptableDao.recupererLastExo(var1);
      if (this.chronoList.size() == 0) {
         this.recalculChronos = true;
      } else {
         this.recalculChronos = false;
      }

   }

   public void chargeChronoPeriode() {
      this.chronoList.clear();
      if (this.chronoTmp.size() != 0) {
         for(int var1 = 0; var1 < this.chronoTmp.size(); ++var1) {
            this.chrono = (Chrono)this.chronoTmp.get(var1);
            if (this.chrono.getChrPeriode() != null && !this.chrono.getChrPeriode().isEmpty()) {
               if (this.chrono.getChrPeriode().equals(this.periode)) {
                  this.chronoList.add(this.chrono);
               }
            } else {
               this.chronoList.add(this.chrono);
            }
         }
      }

      this.datamodelChrono.setWrappedData(this.chronoList);
   }

   public void selectionChrono() {
      if (this.datamodelChrono.isRowAvailable()) {
         this.chrono = (Chrono)this.datamodelChrono.getRowData();
         this.visibiliteBton = true;
      }

   }

   public void calculeMesModes() {
      this.mesModes.clear();
      if (this.chrono.getChrNature() == 53) {
         this.mesModes.add(new SelectItem(0, "Chrono Annuel"));
         this.mesModes.add(new SelectItem(1, "Chrono mensuel"));
         this.mesModes.add(new SelectItem(2, "Chrono continu"));
      } else {
         this.mesModes.add(new SelectItem(2, "Chrono continu"));
      }

      this.calculeMesFormats();
   }

   public void calculeMesFormats() {
      this.mesFormats.clear();
      if (this.chrono.getChrMode() == 0) {
         this.mesFormats.add(new SelectItem(2, "AA+MM+Chrono"));
         this.mesFormats.add(new SelectItem(3, "Chrono/AA"));
         this.mesFormats.add(new SelectItem(9, "Chrono/MM"));
         this.mesFormats.add(new SelectItem(4, "Chrono/AAMM"));
         this.mesFormats.add(new SelectItem(6, "Chrono/MM/JR"));
         this.mesFormats.add(new SelectItem(11, "Chrono/MMJJAA"));
         this.mesFormats.add(new SelectItem(8, "AA-Chrono"));
         this.mesFormats.add(new SelectItem(10, "AAChrono"));
         this.mesFormats.add(new SelectItem(12, "AAAAChrono"));
      } else if (this.chrono.getChrMode() == 1) {
         this.mesFormats.add(new SelectItem(0, "Chrono simple"));
         this.mesFormats.add(new SelectItem(1, "MM+Chrono"));
         this.mesFormats.add(new SelectItem(2, "AA+MM+Chrono"));
         this.mesFormats.add(new SelectItem(3, "Chrono/AA"));
         this.mesFormats.add(new SelectItem(9, "Chrono/MM"));
         this.mesFormats.add(new SelectItem(4, "Chrono/AAMM"));
         this.mesFormats.add(new SelectItem(5, "Chrono/JR"));
         this.mesFormats.add(new SelectItem(6, "Chrono/MM/JR"));
         this.mesFormats.add(new SelectItem(11, "Chrono/MMJJAA"));
         this.mesFormats.add(new SelectItem(8, "AA-Chrono"));
         this.mesFormats.add(new SelectItem(10, "AAChrono"));
         this.mesFormats.add(new SelectItem(12, "AAAAChrono"));
      } else if (this.chrono.getChrMode() == 2) {
         this.mesFormats.add(new SelectItem(0, "Chrono simple"));
         this.mesFormats.add(new SelectItem(1, "MM+Chrono"));
         this.mesFormats.add(new SelectItem(2, "AA+MM+Chrono"));
         this.mesFormats.add(new SelectItem(3, "Chrono/AA"));
         this.mesFormats.add(new SelectItem(9, "Chrono/MM"));
         this.mesFormats.add(new SelectItem(4, "Chrono/AAMM"));
         this.mesFormats.add(new SelectItem(5, "Chrono/JR"));
         this.mesFormats.add(new SelectItem(6, "Chrono/MM/JR"));
         this.mesFormats.add(new SelectItem(11, "Chrono/MMJJAA"));
         this.mesFormats.add(new SelectItem(8, "AA-Chrono"));
         this.mesFormats.add(new SelectItem(10, "AAChrono"));
         this.mesFormats.add(new SelectItem(12, "AAAAChrono"));
      }

   }

   public void ajouterChrono() {
      this.chrono = new Chrono();
      this.chrono.setChrNbCar(5);
      this.testSelectChrono = false;
      this.testDoubleChrono = false;
      this.testSelectChronoJouranux = false;
      this.testSerieX = false;
      this.showModalPanel = true;
      this.calculeMesModes();
   }

   public void modifierChrono() throws HibernateException, NamingException {
      if (this.chrono != null) {
         this.testSelectChrono = true;
         this.testDoubleChrono = true;
         this.testSelectChronoJouranux = false;
         this.testSerieX = false;
         if (this.chrono.getChrNature() == 53) {
            this.lesCodesJournauxItems = this.journauxComptablesDao.mesjournauxActifsItems(this.selectedExo.getExecpt_id(), this.usersLog.getUsrJrxInterdit(), this.usersLog.getUsrJrxReserve(), (Session)null);
            this.testSelectChronoJouranux = true;
         } else {
            this.testSelectChronoJouranux = false;
         }

         this.calculeMesModes();
         this.showModalPanel = true;
      }

   }

   public void annuleSaisie() {
      this.showModalPanel = false;
      this.visibiliteBton = false;
   }

   public void supprimerChrono() throws HibernateException, NamingException, ParseException {
      if (this.chrono != null) {
         this.chronoDao.deleteChrono(this.chrono);
         this.lesChronos((Session)null);
         this.visibiliteBtonAjt = true;
      }

   }

   public void selectNature() throws HibernateException, NamingException {
      this.calculeMesModes();
      this.calculeMesFormats();
      if (this.chrono.getChrNature() != 0) {
         this.testSelectChrono = true;
         if (this.chrono.getChrNature() == 53) {
            this.lesCodesJournauxItems = this.journauxComptablesDao.mesjournauxActifsItems(this.selectedExo.getExecpt_id(), this.usersLog.getUsrJrxInterdit(), this.usersLog.getUsrJrxReserve(), (Session)null);
            if (this.lesCodesJournauxItems.size() != 0) {
               this.chrono.setChrJournal(((SelectItem)this.lesCodesJournauxItems.get(0)).getValue().toString());
               this.testSelectChronoJouranux = true;
            } else {
               this.testSelectChronoJouranux = false;
               this.chrono.setChrJournal("");
            }
         } else {
            this.testSelectChronoJouranux = false;
            this.chrono.setChrJournal("");
         }

         this.doublon();
      } else {
         this.testSelectChrono = false;
         this.testSelectChronoJouranux = false;
      }

   }

   public void calculeMode() throws HibernateException, NamingException {
      this.calculeMesFormats();
      if (this.chrono.getChrNature() == 53) {
         this.var_desactive_format = false;
         this.var_desactive_mode = false;
      } else {
         this.var_desactive_format = true;
         this.var_desactive_mode = true;
      }

      this.doublon();
   }

   public void doublon() throws HibernateException, NamingException {
      if (this.chrono.getChrNature() != 0) {
         String var1 = "";
         if (this.chrono.getChrNature() == 53) {
            var1 = "chrJournal='" + this.chrono.getChrJournal() + "' and chrNature=" + this.chrono.getChrNature() + " and chrPeriode='" + this.chrono.getChrPeriode() + "'";
         } else {
            var1 = " chrNature=" + this.chrono.getChrNature() + " and chrPeriode='" + this.chrono.getChrPeriode() + "'";
         }

         Chrono var2 = this.chronoDao.selectUnique(var1);
         if (var2 != null) {
            this.testDoubleChrono = false;
         } else {
            this.testDoubleChrono = true;
         }
      } else {
         this.testDoubleChrono = false;
      }

   }

   public void saveChrono() throws HibernateException, NamingException {
      if ("".equals(this.chrono.getChrSerie())) {
         this.chrono.setChrSerie("X");
      }

      if ("".equals(this.chrono.getChrNom())) {
         this.chrono.setChrNom(this.chrono.getLibnature());
      }

      if (this.chrono.getChrMode() == 2) {
         this.chrono.setChrPeriode("");
      } else if (this.chrono.getChrPeriode() == null || this.chrono.getChrPeriode().isEmpty()) {
         this.chrono.setChrPeriode("" + this.selectedExo.getExecpt_id());
      }

      if (this.chrono.getChrMode() == 0) {
         this.chrono.setChrNum(0L);
         this.chrono.setChrNum01(0L);
         this.chrono.setChrNum02(0L);
         this.chrono.setChrNum03(0L);
         this.chrono.setChrNum04(0L);
         this.chrono.setChrNum05(0L);
         this.chrono.setChrNum06(0L);
         this.chrono.setChrNum07(0L);
         this.chrono.setChrNum08(0L);
         this.chrono.setChrNum09(0L);
         this.chrono.setChrNum10(0L);
         this.chrono.setChrNum11(0L);
         this.chrono.setChrNum12(0L);
      } else if (this.chrono.getChrMode() == 1) {
         this.chrono.setChrNum(0L);
         this.chrono.setChrNumAn(0L);
      } else if (this.chrono.getChrMode() == 2) {
         this.chrono.setChrNumAn(0L);
         this.chrono.setChrNum01(0L);
         this.chrono.setChrNum02(0L);
         this.chrono.setChrNum03(0L);
         this.chrono.setChrNum04(0L);
         this.chrono.setChrNum05(0L);
         this.chrono.setChrNum06(0L);
         this.chrono.setChrNum07(0L);
         this.chrono.setChrNum08(0L);
         this.chrono.setChrNum09(0L);
         this.chrono.setChrNum10(0L);
         this.chrono.setChrNum11(0L);
         this.chrono.setChrNum12(0L);
      }

      if (this.chrono.getChrId() == 0L) {
         this.chrono = this.chronoDao.insertChrono(this.chrono);
         this.chronoList.add(this.chrono);
         this.chronoTmp.add(this.chrono);
         this.datamodelChrono.setWrappedData(this.chronoList);
      } else {
         this.chrono = this.chronoDao.modifierChrono(this.chrono);
      }

      if (this.chrono.getChrPeriode() != null && !this.chrono.getChrPeriode().isEmpty() && this.lesPeriodesItems.size() != 0) {
         boolean var1 = false;

         for(int var2 = 0; var2 < this.lesPeriodesItems.size(); ++var2) {
            if (((SelectItem)this.lesPeriodesItems.get(var2)).getValue().toString().equals(this.chrono.getChrPeriode())) {
               var1 = true;
               break;
            }
         }

         if (!var1) {
            this.lesPeriodesItems.add(new SelectItem(this.chrono.getChrPeriode()));
         }
      }

      this.showModalPanel = false;
   }

   public void rafraichirChrono() throws HibernateException, NamingException {
      if (this.chronoList.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = "";
            int var4 = 0;

            for(int var5 = 0; var5 < this.chronoList.size(); ++var5) {
               this.chrono = (Chrono)this.chronoList.get(var5);
               String var6 = this.chrono.getChrJournal();
               int var7 = this.chrono.getChrNature();
               if (this.chrono.getChrJournal() != null && !this.chrono.getChrJournal().isEmpty()) {
                  if (var3.equals(this.chrono.getChrJournal())) {
                     this.chronoList.remove(this.chrono);
                     this.chronoDao.deleteChrono(this.chrono, var1);
                     --var5;
                  }

                  var3 = var6;
               } else {
                  if (var4 == this.chrono.getChrNature()) {
                     this.chronoList.remove(this.chrono);
                     this.chronoDao.deleteChrono(this.chrono, var1);
                     --var5;
                  }

                  var4 = var7;
               }
            }

            this.datamodelChrono.setWrappedData(this.chronoList);
            var2.commit();
         } catch (HibernateException var11) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var11;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void majChronoAutmatique() {
      this.chrono = new Chrono();
      this.chrono.setChrNbCar(5);
      this.chrono.setChrMode(1);
      this.chrono.setChrNature(53);
      this.chrono.setChrFormat(6);
      this.chrono.setChrPeriode("" + this.selectedExo.getExecpt_id());
      this.testSelectChrono = false;
      this.testDoubleChrono = false;
      this.testSelectChronoJouranux = false;
      this.testSerieX = false;
      this.showModalPanelAuto = true;
      this.calculeMesModes();
   }

   public void annuleSaisieAutomatique() {
      this.showModalPanelAuto = false;
      this.visibiliteBton = false;
   }

   public void saveChronoAuto() throws HibernateException, NamingException, IOException {
      String var1 = this.chrono.getChrPeriode();
      int var2 = this.chrono.getChrNbCar();
      int var3 = this.chrono.getChrMode();
      int var4 = this.chrono.getChrFormat();
      String var5 = this.chrono.getChrPrefixe();
      String var6 = this.chrono.getChrSufixe();
      Session var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
      Transaction var8 = null;

      try {
         var8 = var7.beginTransaction();
         new ArrayList();
         List var9 = this.listChrono();
         if (var9.size() != 0) {
            for(int var10 = 0; var10 < var9.size(); ++var10) {
               int var11 = Integer.parseInt(((SelectItem)var9.get(var10)).getValue().toString());
               if (var11 == 53) {
                  new ArrayList();
                  List var22 = this.journauxComptablesDao.chargerLesJournauxComptables(this.selectedExo.getExecpt_id(), 0, var7);
                  if (var22.size() != 0) {
                     new JournauxComptables();

                     for(int var14 = 0; var14 < var22.size(); ++var14) {
                        JournauxComptables var23 = (JournauxComptables)var22.get(var14);
                        if (!var23.isInactif()) {
                           boolean var15 = false;

                           for(int var16 = 0; var16 < this.chronoTmp.size(); ++var16) {
                              if (((Chrono)this.chronoTmp.get(var16)).getChrJournal().equals(var23.getPljCode())) {
                                 if (((Chrono)this.chronoTmp.get(var16)).getChrPeriode() == null || ((Chrono)this.chronoTmp.get(var16)).getChrPeriode().isEmpty() || var1 == null) {
                                    this.chrono = (Chrono)this.chronoTmp.get(var16);
                                    var15 = true;
                                    break;
                                 }

                                 if (var1 != null && !var1.isEmpty() && var1.equals(((Chrono)this.chronoTmp.get(var16)).getChrPeriode())) {
                                    this.chrono = (Chrono)this.chronoTmp.get(var16);
                                    var15 = true;
                                    break;
                                 }
                              }
                           }

                           if (!var15) {
                              this.chrono = new Chrono();
                              this.chrono.setChrPrive(0);
                              this.chrono.setChrJournal(var23.getPljCode());
                              this.chrono.setChrNature(53);
                              this.chrono.setChrNbCar(var2);
                              this.chrono.setChrPeriode(var1);
                              this.chrono.setChrMode(var3);
                              this.chrono.setChrFormat(var4);
                              this.chrono.setChrPrefixe(var5);
                              this.chrono.setChrSufixe(var6);
                              if ("".equals(this.chrono.getChrSerie())) {
                                 this.chrono.setChrSerie("X");
                              }

                              if ("".equals(this.chrono.getChrNom())) {
                                 this.chrono.setChrNom(this.chrono.getLibnature());
                              }

                              if (this.chrono.getChrMode() == 2) {
                                 this.chrono.setChrPeriode("");
                              } else if (this.chrono.getChrPeriode() == null || this.chrono.getChrPeriode().isEmpty()) {
                                 this.chrono.setChrPeriode("" + this.selectedExo.getExecpt_id());
                              }

                              this.chrono = this.chronoDao.insertChrono(this.chrono, var7);
                              this.chronoList.add(this.chrono);
                           } else {
                              this.chrono.setChrPrive(0);
                              this.chrono.setChrJournal(var23.getPljCode());
                              this.chrono.setChrNature(53);
                              this.chrono.setChrNbCar(var2);
                              this.chrono.setChrPeriode(var1);
                              this.chrono.setChrMode(var3);
                              this.chrono.setChrFormat(var4);
                              this.chrono.setChrPrefixe(var5);
                              this.chrono.setChrSufixe(var6);
                              if ("".equals(this.chrono.getChrSerie())) {
                                 this.chrono.setChrSerie("X");
                              }

                              if ("".equals(this.chrono.getChrNom())) {
                                 this.chrono.setChrNom(this.chrono.getLibnature());
                              }

                              if (this.chrono.getChrMode() == 2) {
                                 this.chrono.setChrPeriode("");
                              } else if (this.chrono.getChrPeriode() == null || this.chrono.getChrPeriode().isEmpty()) {
                                 this.chrono.setChrPeriode("" + this.selectedExo.getExecpt_id());
                              }

                              this.chrono = this.chronoDao.modifierChrono(this.chrono, var7);
                           }
                        }
                     }
                  }
               } else {
                  boolean var12 = false;

                  for(int var13 = 0; var13 < this.chronoList.size(); ++var13) {
                     if (((Chrono)this.chronoList.get(var13)).getChrNature() == var11) {
                        this.chrono = (Chrono)this.chronoList.get(var13);
                        var12 = true;
                        break;
                     }
                  }

                  if (!var12) {
                     this.chrono = new Chrono();
                     this.chrono.setChrPrive(0);
                     this.chrono.setChrJournal("");
                     this.chrono.setChrNature(Integer.parseInt(((SelectItem)var9.get(var10)).getValue().toString()));
                     this.chrono.setChrSerie("");
                     this.chrono.setChrNbCar(var2);
                     this.chrono.setChrPeriode("");
                     this.chrono.setChrMode(2);
                     this.chrono.setChrFormat(0);
                     this.chrono.setChrPrefixe("");
                     this.chrono.setChrSufixe("");
                     if (this.chrono.getChrNom() == null || this.chrono.getChrNom().isEmpty()) {
                        this.chrono.setChrNom("(" + this.chrono.getChrSerie() + ") " + this.chrono.getLibnature());
                     }

                     if (this.chrono.getChrMode() == 2) {
                        this.chrono.setChrPeriode("");
                     } else if (this.chrono.getChrPeriode() == null || this.chrono.getChrPeriode().isEmpty()) {
                        this.chrono.setChrPeriode("" + this.exercicesComptable.getExecpt_id());
                     }

                     this.chrono = this.chronoDao.insertChrono(this.chrono, var7);
                     this.chronoList.add(this.chrono);
                  } else {
                     this.chrono.setChrPrive(0);
                     this.chrono.setChrJournal("");
                     this.chrono.setChrNature(Integer.parseInt(((SelectItem)var9.get(var10)).getValue().toString()));
                     this.chrono.setChrSerie("");
                     this.chrono.setChrNbCar(var2);
                     this.chrono.setChrPeriode("");
                     this.chrono.setChrMode(2);
                     this.chrono.setChrFormat(0);
                     this.chrono.setChrPrefixe("");
                     this.chrono.setChrSufixe("");
                     if ("".equals(this.chrono.getChrNom())) {
                        this.chrono.setChrNom(this.chrono.getLibnature());
                     }

                     if (this.chrono.getChrMode() == 2) {
                        this.chrono.setChrPeriode("");
                     } else if (this.chrono.getChrPeriode() == null || this.chrono.getChrPeriode().isEmpty()) {
                        this.chrono.setChrPeriode("" + this.exercicesComptable.getExecpt_id());
                     }

                     this.chrono = this.chronoDao.modifierChrono(this.chrono, var7);
                  }
               }
            }
         }

         var8.commit();
      } catch (HibernateException var20) {
         if (var8 != null) {
            var8.rollback();
         }

         throw var20;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.lesChronos((Session)null);
      this.showModalPanelAuto = false;
   }

   public List listChrono() throws IOException {
      ArrayList var1 = new ArrayList();
      var1.add(new SelectItem(50, "Loyers"));
      var1.add(new SelectItem(51, "Amortissements"));
      var1.add(new SelectItem(52, "Budgets"));
      var1.add(new SelectItem(53, "Journaux"));
      var1.add(new SelectItem(54, "Budgets Trésorerie"));
      var1.add(new SelectItem(55, "Transferts"));
      var1.add(new SelectItem(56, "Rapprochements Bancaires"));
      var1.add(new SelectItem(57, "Notes Externes"));
      var1.add(new SelectItem(531, "Brouillards Journaliers"));
      var1.add(new SelectItem(532, "Brouillards Mensuels"));
      var1.add(new SelectItem(533, "Impressions"));
      var1.add(new SelectItem(534, "Extraits Comptes"));
      var1.add(new SelectItem(535, "Extraits Analytiques"));
      var1.add(new SelectItem(536, "Extraits Budgets"));
      var1.add(new SelectItem(537, "Etats Financiers"));
      var1.add(new SelectItem(538, "Extraits Classes"));
      var1.add(new SelectItem(539, "Extraits Projets"));
      return var1;
   }

   public void majCompteurAutmatique() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.chronoList.size() != 0) {
            long var3 = 0L;

            for(int var5 = 0; var5 < this.chronoList.size(); ++var5) {
               this.chrono = (Chrono)this.chronoList.get(var5);
               if (this.chrono.getChrPeriode() != null && !this.chrono.getChrPeriode().isEmpty()) {
                  var3 = Long.parseLong(this.chrono.getChrPeriode());
               } else {
                  var3 = this.selectedExo.getExecpt_id();
               }

               if (this.chrono.getChrMode() == 0) {
                  this.chrono.setChrNum(0L);
                  this.chrono.setChrNum01(0L);
                  this.chrono.setChrNum02(0L);
                  this.chrono.setChrNum03(0L);
                  this.chrono.setChrNum04(0L);
                  this.chrono.setChrNum05(0L);
                  this.chrono.setChrNum06(0L);
                  this.chrono.setChrNum07(0L);
                  this.chrono.setChrNum08(0L);
                  this.chrono.setChrNum09(0L);
                  this.chrono.setChrNum10(0L);
                  this.chrono.setChrNum11(0L);
                  this.chrono.setChrNum12(0L);
                  this.chrono.setChrNumAn((long)this.calculePiece(this.chrono.getChrMode(), this.chrono.getChrJournal(), "" + var3, var1));
               } else if (this.chrono.getChrMode() == 1) {
                  this.chrono.setChrNum(0L);
                  this.chrono.setChrNumAn(0L);
                  this.chrono.setChrNum01((long)this.calculePiece(this.chrono.getChrMode(), this.chrono.getChrJournal(), "01:" + var3, var1));
                  this.chrono.setChrNum02((long)this.calculePiece(this.chrono.getChrMode(), this.chrono.getChrJournal(), "02:" + var3, var1));
                  this.chrono.setChrNum03((long)this.calculePiece(this.chrono.getChrMode(), this.chrono.getChrJournal(), "03:" + var3, var1));
                  this.chrono.setChrNum04((long)this.calculePiece(this.chrono.getChrMode(), this.chrono.getChrJournal(), "04:" + var3, var1));
                  this.chrono.setChrNum05((long)this.calculePiece(this.chrono.getChrMode(), this.chrono.getChrJournal(), "05:" + var3, var1));
                  this.chrono.setChrNum06((long)this.calculePiece(this.chrono.getChrMode(), this.chrono.getChrJournal(), "06:" + var3, var1));
                  this.chrono.setChrNum07((long)this.calculePiece(this.chrono.getChrMode(), this.chrono.getChrJournal(), "07:" + var3, var1));
                  this.chrono.setChrNum08((long)this.calculePiece(this.chrono.getChrMode(), this.chrono.getChrJournal(), "08:" + var3, var1));
                  this.chrono.setChrNum09((long)this.calculePiece(this.chrono.getChrMode(), this.chrono.getChrJournal(), "09:" + var3, var1));
                  this.chrono.setChrNum10((long)this.calculePiece(this.chrono.getChrMode(), this.chrono.getChrJournal(), "10:" + var3, var1));
                  this.chrono.setChrNum11((long)this.calculePiece(this.chrono.getChrMode(), this.chrono.getChrJournal(), "11:" + var3, var1));
                  this.chrono.setChrNum12((long)this.calculePiece(this.chrono.getChrMode(), this.chrono.getChrJournal(), "12:" + var3, var1));
               } else if (this.chrono.getChrMode() == 2) {
                  this.chrono.setChrNumAn(0L);
                  this.chrono.setChrNum01(0L);
                  this.chrono.setChrNum02(0L);
                  this.chrono.setChrNum03(0L);
                  this.chrono.setChrNum04(0L);
                  this.chrono.setChrNum05(0L);
                  this.chrono.setChrNum06(0L);
                  this.chrono.setChrNum07(0L);
                  this.chrono.setChrNum08(0L);
                  this.chrono.setChrNum09(0L);
                  this.chrono.setChrNum10(0L);
                  this.chrono.setChrNum11(0L);
                  this.chrono.setChrNum12(0L);
                  this.chrono.setChrNum((long)this.calculePiece(this.chrono.getChrMode(), this.chrono.getChrJournal(), "" + var3, var1));
               }

               this.chrono = this.chronoDao.modifierChrono(this.chrono, var1);
            }
         }

         var2.commit();
      } catch (HibernateException var9) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var9;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public int calculePiece(int var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      int var5 = 0;
      String var6 = "";
      String var7 = "";
      if (var1 == 1) {
         var7 = "ecrCle1 = '" + var2 + ":" + var3 + "'";
      } else {
         var7 = "ecrCode = '" + var2 + "' and ecrAnnee='" + var3 + "'";
      }

      var6 = this.ecrituresDao.ChargerLesEcrituresPiece(var7, var4);
      if (var6 != null && !var6.isEmpty()) {
         if (var6.contains("/")) {
            String[] var8 = var6.split("/");
            var5 = this.filtreNumerique(var8[0]);
         } else {
            var5 = this.filtreNumerique(var6);
         }
      }

      return var5;
   }

   public int filtreNumerique(String var1) {
      int var2 = 0;
      String var3 = "";
      String var4 = "";

      for(int var5 = 0; var5 < var1.length(); ++var5) {
         var4 = (String)var1.subSequence(var5, var5 + 1);
         if (var4 != null && !var4.isEmpty()) {
            if (var4.equals("0")) {
               var3 = var3 + var4.toUpperCase();
            } else if (var4.equals("1")) {
               var3 = var3 + var4.toUpperCase();
            } else if (var4.equals("2")) {
               var3 = var3 + var4.toUpperCase();
            } else if (var4.equals("3")) {
               var3 = var3 + var4.toUpperCase();
            } else if (var4.equals("4")) {
               var3 = var3 + var4.toUpperCase();
            } else if (var4.equals("5")) {
               var3 = var3 + var4.toUpperCase();
            } else if (var4.equals("6")) {
               var3 = var3 + var4.toUpperCase();
            } else if (var4.equals("7")) {
               var3 = var3 + var4.toUpperCase();
            } else if (var4.equals("8")) {
               var3 = var3 + var4.toUpperCase();
            } else if (var4.equals("9")) {
               var3 = var3 + var4.toUpperCase();
            }
         }
      }

      if (var3 != null && !var3.isEmpty()) {
         var2 = Integer.parseInt(var3);
      }

      return var2;
   }

   public Chrono getChrono() {
      return this.chrono;
   }

   public void setChrono(Chrono var1) {
      this.chrono = var1;
   }

   public List getChronoList() {
      return this.chronoList;
   }

   public void setChronoList(List var1) {
      this.chronoList = var1;
   }

   public DataModel getDatamodelChrono() {
      return this.datamodelChrono;
   }

   public void setDatamodelChrono(DataModel var1) {
      this.datamodelChrono = var1;
   }

   public boolean isShowModalPanel() {
      return this.showModalPanel;
   }

   public void setShowModalPanel(boolean var1) {
      this.showModalPanel = var1;
   }

   public boolean isTestSelectChrono() {
      return this.testSelectChrono;
   }

   public void setTestSelectChrono(boolean var1) {
      this.testSelectChrono = var1;
   }

   public boolean isVisibiliteBton() {
      return this.visibiliteBton;
   }

   public void setVisibiliteBton(boolean var1) {
      this.visibiliteBton = var1;
   }

   public boolean isVisibiliteBtonAjt() {
      return this.visibiliteBtonAjt;
   }

   public void setVisibiliteBtonAjt(boolean var1) {
      this.visibiliteBtonAjt = var1;
   }

   public int getFormatChonoSelect() {
      return this.formatChonoSelect;
   }

   public void setFormatChonoSelect(int var1) {
      this.formatChonoSelect = var1;
   }

   public int getModCalcSelect() {
      return this.modCalcSelect;
   }

   public void setModCalcSelect(int var1) {
      this.modCalcSelect = var1;
   }

   public int getNbrCaracteresSelect() {
      return this.nbrCaracteresSelect;
   }

   public void setNbrCaracteresSelect(int var1) {
      this.nbrCaracteresSelect = var1;
   }

   public long getNumSelect() {
      return this.numSelect;
   }

   public void setNumSelect(long var1) {
      this.numSelect = var1;
   }

   public String getPrefSelect() {
      return this.prefSelect;
   }

   public void setPrefSelect(String var1) {
      this.prefSelect = var1;
   }

   public String getSufxSelect() {
      return this.sufxSelect;
   }

   public void setSufxSelect(String var1) {
      this.sufxSelect = var1;
   }

   public boolean isTestDoubleChrono() {
      return this.testDoubleChrono;
   }

   public void setTestDoubleChrono(boolean var1) {
      this.testDoubleChrono = var1;
   }

   public boolean isTestSerieX() {
      return this.testSerieX;
   }

   public void setTestSerieX(boolean var1) {
      this.testSerieX = var1;
   }

   public List getLesCodesJournauxItems() {
      return this.lesCodesJournauxItems;
   }

   public void setLesCodesJournauxItems(List var1) {
      this.lesCodesJournauxItems = var1;
   }

   public ExercicesComptable getSelectedExo() {
      return this.selectedExo;
   }

   public void setSelectedExo(ExercicesComptable var1) {
      this.selectedExo = var1;
   }

   public boolean isTestSelectChronoJouranux() {
      return this.testSelectChronoJouranux;
   }

   public void setTestSelectChronoJouranux(boolean var1) {
      this.testSelectChronoJouranux = var1;
   }

   public boolean isVar_desactive_format() {
      return this.var_desactive_format;
   }

   public void setVar_desactive_format(boolean var1) {
      this.var_desactive_format = var1;
   }

   public boolean isVar_desactive_mode() {
      return this.var_desactive_mode;
   }

   public void setVar_desactive_mode(boolean var1) {
      this.var_desactive_mode = var1;
   }

   public List getMesFormats() {
      return this.mesFormats;
   }

   public void setMesFormats(List var1) {
      this.mesFormats = var1;
   }

   public List getMesModes() {
      return this.mesModes;
   }

   public void setMesModes(List var1) {
      this.mesModes = var1;
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

   public List getLesPeriodesItems() {
      return this.lesPeriodesItems;
   }

   public void setLesPeriodesItems(List var1) {
      this.lesPeriodesItems = var1;
   }

   public String getPeriode() {
      return this.periode;
   }

   public void setPeriode(String var1) {
      this.periode = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public boolean isShowModalPanelAuto() {
      return this.showModalPanelAuto;
   }

   public void setShowModalPanelAuto(boolean var1) {
      this.showModalPanelAuto = var1;
   }

   public boolean isRecalculChronos() {
      return this.recalculChronos;
   }

   public void setRecalculChronos(boolean var1) {
      this.recalculChronos = var1;
   }
}
