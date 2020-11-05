package com.epegase.forms.administration;

import com.epegase.systeme.classe.CaissesCommerciales;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.ExercicesCaisse;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.CaissesCommercialesDao;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.ExercicesCaisseDao;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureTypeReglement;
import com.epegase.systeme.xml.ObjetCompte;
import com.epegase.systeme.xml.OptionCaisses;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FormChronoCaisses implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private OptionCaisses optionCaisses;
   private List chronoList = new ArrayList();
   private transient DataModel datamodelChrono = new ListDataModel();
   private ChronoDao chronoDao;
   private Chrono chrono = new Chrono();
   private boolean showModalPanel = false;
   private boolean showModalPanelAuto = false;
   private boolean visibiliteBton = false;
   private boolean var_valide = false;
   private List mesModes = new ArrayList();
   private List mesFormats = new ArrayList();
   private ExercicesCaisse exercicesCaisse = new ExercicesCaisse();
   private ExercicesCaisseDao exercicesCaisseDao;
   private List mesCaissesItems = new ArrayList();
   private String var_caisse;
   private LectureTypeReglement lectureTypeReglement;
   private List lesModeReglement = new ArrayList();
   private boolean type0 = false;
   private boolean type1 = false;
   private boolean type2 = false;
   private boolean type3 = false;
   private boolean type4 = false;
   private boolean type5 = false;
   private boolean type6 = false;
   private boolean type7 = false;
   private boolean type8 = false;
   private boolean type9 = false;
   private boolean type10 = false;
   private List chronoTmp = new ArrayList();
   private List lesPeriodesItems = new ArrayList();
   private String periode;

   public void InstancesDaoUtilses() {
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
      this.exercicesCaisseDao = new ExercicesCaisseDao(this.baseLog, this.utilInitHibernate);
   }

   public void lesChronos(Session var1) throws HibernateException, NamingException {
      this.chronoList.clear();
      this.chronoTmp.clear();
      this.chronoTmp = this.chronoDao.selectListCaisses(this.usersLog.getUsrJrxReserve(), var1);
      int var2;
      if (this.chronoTmp.size() != 0) {
         for(var2 = 0; var2 < this.chronoTmp.size(); ++var2) {
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

      this.lectureTypeReglement = new LectureTypeReglement(this.baseLog);
      this.lesModeReglement = this.lectureTypeReglement.getMesTypeReglement();
      if (this.lesModeReglement.size() != 0) {
         for(var2 = 0; var2 < this.lesModeReglement.size(); ++var2) {
            if ((((ObjetCompte)this.lesModeReglement.get(var2)).getCode().equals("0") || ((ObjetCompte)this.lesModeReglement.get(var2)).getCode().equals("11")) && ((ObjetCompte)this.lesModeReglement.get(var2)).isValide()) {
               this.type0 = true;
            } else if (((ObjetCompte)this.lesModeReglement.get(var2)).getCode().equals("1") && ((ObjetCompte)this.lesModeReglement.get(var2)).isValide()) {
               this.type1 = true;
            } else if (((ObjetCompte)this.lesModeReglement.get(var2)).getCode().equals("2") && ((ObjetCompte)this.lesModeReglement.get(var2)).isValide()) {
               this.type2 = true;
            } else if (((ObjetCompte)this.lesModeReglement.get(var2)).getCode().equals("3") && ((ObjetCompte)this.lesModeReglement.get(var2)).isValide()) {
               this.type3 = true;
            } else if (((ObjetCompte)this.lesModeReglement.get(var2)).getCode().equals("4") && ((ObjetCompte)this.lesModeReglement.get(var2)).isValide()) {
               this.type4 = true;
            } else if (((ObjetCompte)this.lesModeReglement.get(var2)).getCode().equals("5") && ((ObjetCompte)this.lesModeReglement.get(var2)).isValide()) {
               this.type5 = true;
            } else if (((ObjetCompte)this.lesModeReglement.get(var2)).getCode().equals("6") && ((ObjetCompte)this.lesModeReglement.get(var2)).isValide()) {
               this.type6 = true;
            } else if (((ObjetCompte)this.lesModeReglement.get(var2)).getCode().equals("7") && ((ObjetCompte)this.lesModeReglement.get(var2)).isValide()) {
               this.type7 = true;
            } else if (((ObjetCompte)this.lesModeReglement.get(var2)).getCode().equals("8") && ((ObjetCompte)this.lesModeReglement.get(var2)).isValide()) {
               this.type8 = true;
            } else if (((ObjetCompte)this.lesModeReglement.get(var2)).getCode().equals("9") && ((ObjetCompte)this.lesModeReglement.get(var2)).isValide()) {
               this.type9 = true;
            } else if (((ObjetCompte)this.lesModeReglement.get(var2)).getCode().equals("10") && ((ObjetCompte)this.lesModeReglement.get(var2)).isValide()) {
               this.type10 = true;
            }
         }
      }

      this.chargeChronoPeriode();
      this.exercicesCaisse = this.exercicesCaisseDao.recupererLastExo(var1);
      CaissesCommercialesDao var5 = new CaissesCommercialesDao(this.baseLog, this.utilInitHibernate);
      this.mesCaissesItems = var5.selectActifCaisseItems(var1);
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
         if (this.chrono.getChrNature() != 60 && this.chrono.getChrNature() != 61) {
            this.var_caisse = "";
         } else {
            this.var_caisse = "";
            if (this.chrono.getChrCodeCaisse() != null && !this.chrono.getChrCodeCaisse().isEmpty()) {
               for(int var1 = 0; var1 < this.mesCaissesItems.size(); ++var1) {
                  if (((SelectItem)this.mesCaissesItems.get(var1)).getValue().toString().startsWith(this.chrono.getChrCodeCaisse())) {
                     this.var_caisse = ((SelectItem)this.mesCaissesItems.get(var1)).getValue().toString();
                     break;
                  }
               }
            }
         }

         this.visibiliteBton = true;
      }

   }

   public void calculeMesModes() {
      this.mesModes.clear();
      this.mesModes.add(new SelectItem(0, "Chrono Annuel"));
      this.mesModes.add(new SelectItem(1, "Chrono mensuel"));
      this.mesModes.add(new SelectItem(2, "Chrono continu"));
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
         this.mesFormats.add(new SelectItem(7, "AAAAMMJJChrono"));
         this.mesFormats.add(new SelectItem(8, "AA-Chrono"));
         this.mesFormats.add(new SelectItem(10, "AAChrono"));
         this.mesFormats.add(new SelectItem(12, "AAAAChrono"));
      } else if (this.chrono.getChrMode() == 1) {
         this.mesFormats.add(new SelectItem(1, "MM+Chrono"));
         this.mesFormats.add(new SelectItem(2, "AA+MM+Chrono"));
         this.mesFormats.add(new SelectItem(3, "Chrono/AA"));
         this.mesFormats.add(new SelectItem(9, "Chrono/MM"));
         this.mesFormats.add(new SelectItem(4, "Chrono/AAMM"));
         this.mesFormats.add(new SelectItem(11, "Chrono/MMJJAA"));
         this.mesFormats.add(new SelectItem(7, "AAAAMMJJChrono"));
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
      this.var_valide = false;
      this.calculeMesModes();
      this.showModalPanel = true;
   }

   public void modifierChrono() {
      if (this.chrono != null) {
         this.var_valide = true;
         this.calculeMesModes();
         this.showModalPanel = true;
      }

   }

   public void annuleSaisie() {
      this.showModalPanel = false;
      this.visibiliteBton = false;
   }

   public void supprimerChrono() throws HibernateException, NamingException {
      if (this.chrono != null) {
         this.chronoDao.deleteChrono(this.chrono);
         this.lesChronos((Session)null);
         this.visibiliteBton = false;
      }

   }

   public void selectNature() throws HibernateException, NamingException {
      this.calculeMesModes();
      this.calculeMesFormats();
      this.doublon();
   }

   public void selectCaisse() {
      if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
         String[] var1 = this.var_caisse.split(":");
         this.chrono.setChrCodeCaisse(var1[0]);
         if (this.chrono.getChrNature() == 61) {
            this.chrono.setChrNom("Reçu " + var1[1]);
         } else {
            this.chrono.setChrNom(var1[1]);
         }
      }

   }

   public void calculeMode() throws HibernateException, NamingException {
      this.calculeMesFormats();
      this.doublon();
   }

   public void doublon() throws HibernateException, NamingException {
      this.var_valide = false;
      String var1;
      Chrono var2;
      if ((this.chrono.getChrNature() == 60 || this.chrono.getChrNature() == 61) && this.chrono.getChrSerie() != null && !this.chrono.getChrSerie().isEmpty() && this.chrono.getChrCodeCaisse() != null && !this.chrono.getChrCodeCaisse().isEmpty()) {
         var1 = "chrSerie='" + this.chrono.getChrSerie() + "' and chrNature=" + this.chrono.getChrNature() + " and chrPeriode='" + this.chrono.getChrPeriode() + "' and chrCodeCaisse='" + this.chrono.getChrCodeCaisse() + "'";
         new Chrono();
         var2 = this.chronoDao.selectUnique(var1);
         if (var2 != null) {
            this.var_valide = false;
         } else {
            this.var_valide = true;
         }
      } else if (this.chrono.getChrNature() >= 62 && this.chrono.getChrNature() <= 69 && this.chrono.getChrSerie() != null && !this.chrono.getChrSerie().isEmpty()) {
         var1 = "chrSerie='" + this.chrono.getChrSerie() + "' and chrNature=" + this.chrono.getChrNature() + " and chrPeriode='" + this.chrono.getChrPeriode() + "'";
         new Chrono();
         var2 = this.chronoDao.selectUnique(var1);
         if (var2 != null) {
            this.var_valide = false;
         } else {
            this.var_valide = true;
         }
      } else {
         this.var_valide = false;
      }

   }

   public void saveChrono() throws HibernateException, NamingException {
      if (this.chrono.getChrSerie() == null || this.chrono.getChrSerie().isEmpty()) {
         this.chrono.setChrSerie("X");
      }

      if (this.chrono.getChrNom() == null || this.chrono.getChrNom().isEmpty()) {
         this.chrono.setChrNom("(" + this.chrono.getChrSerie() + ") " + this.chrono.getLibnature());
      }

      if (this.chrono.getChrMode() == 2) {
         this.chrono.setChrPeriode("");
      } else if (this.chrono.getChrPeriode() == null || this.chrono.getChrPeriode().isEmpty()) {
         this.chrono.setChrPeriode("" + this.exercicesCaisse.getExecaiId());
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

   public void majChronoAutmatique() {
      this.chrono = new Chrono();
      this.chrono.setChrNbCar(5);
      this.chrono.setChrMode(0);
      this.chrono.setChrFormat(9);
      this.chrono.setChrPeriode("" + this.exercicesCaisse.getExecaiId());
      this.chrono.setChrSerie("A");
      this.showModalPanelAuto = true;
      this.calculeMesModes();
   }

   public void annuleSaisieAutomatique() {
      this.showModalPanelAuto = false;
      this.visibiliteBton = false;
   }

   public List listChrono() throws IOException {
      ArrayList var1 = new ArrayList();
      var1.add(new SelectItem(60, "Caisse"));
      var1.add(new SelectItem(61, "Reçu (règlement)"));
      var1.add(new SelectItem(62, "Bon de sortie"));
      var1.add(new SelectItem(63, "Bon d`entrée"));
      var1.add(new SelectItem(64, "Virement interne"));
      var1.add(new SelectItem(65, "Traites Domiciliée"));
      var1.add(new SelectItem(66, "Traites Simplifiées"));
      var1.add(new SelectItem(67, "Traites Entreprise"));
      var1.add(new SelectItem(68, "Inventaire caisse"));
      var1.add(new SelectItem(69, "Prévisionnel"));
      return var1;
   }

   public void saveChronoAuto() throws HibernateException, NamingException, IOException {
      String var1 = this.chrono.getChrPeriode();
      int var2 = this.chrono.getChrNbCar();
      int var3 = this.chrono.getChrMode();
      int var4 = this.chrono.getChrFormat();
      String var5 = this.chrono.getChrPrefixe();
      String var6 = this.chrono.getChrSufixe();
      String var7 = this.chrono.getChrSerie();
      new ArrayList();
      CaissesCommercialesDao var9 = new CaissesCommercialesDao(this.baseLog, this.utilInitHibernate);
      List var8 = var9.selectActifCaisse(0, (Session)null);
      Session var10 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
      Transaction var11 = null;

      try {
         var11 = var10.beginTransaction();
         new ArrayList();
         List var12 = this.listChrono();
         if (var12.size() != 0) {
            String var13 = "";
            boolean var14 = false;

            for(int var15 = 0; var15 < var12.size(); ++var15) {
               int var16 = Integer.parseInt(((SelectItem)var12.get(var15)).getValue().toString());
               boolean var17 = false;
               int var18;
               if (var16 != 60 && var16 != 61) {
                  var13 = "";
                  byte var26 = 0;

                  for(var18 = 0; var18 < this.chronoList.size(); ++var18) {
                     if (var7 != null && !var7.isEmpty()) {
                        if (((Chrono)this.chronoList.get(var18)).getChrNature() == var16 && ((Chrono)this.chronoList.get(var18)).getChrSerie().equalsIgnoreCase(var7)) {
                           this.chrono = (Chrono)this.chronoList.get(var18);
                           var17 = true;
                           break;
                        }
                     } else if (((Chrono)this.chronoList.get(var18)).getChrNature() == var16) {
                        this.chrono = (Chrono)this.chronoList.get(var18);
                        var17 = true;
                        break;
                     }
                  }

                  this.creationLigneChrono(var17, var7, var16, var2, var1, var3, var4, var5, var6, var13, var26, var10);
               } else {
                  for(var18 = 0; var18 < var8.size(); ++var18) {
                     var13 = ((CaissesCommerciales)var8.get(var18)).getCaiCode();
                     int var25 = ((CaissesCommerciales)var8.get(var18)).getCaiMode();
                     var17 = false;
                     if (this.chronoList.size() == 0) {
                        this.creationLigneChrono(var17, var7, var16, var2, var1, var3, var4, var5, var6, var13, var25, var10);
                     } else {
                        for(int var19 = 0; var19 < this.chronoList.size(); ++var19) {
                           if (var13 != null && !var13.isEmpty() && ((Chrono)this.chronoList.get(var19)).getChrNature() == var16 && ((Chrono)this.chronoList.get(var19)).getChrSerie().equalsIgnoreCase(var7) && ((Chrono)this.chronoList.get(var19)).getChrCodeCaisse() != null && !((Chrono)this.chronoList.get(var19)).getChrCodeCaisse().isEmpty() && ((Chrono)this.chronoList.get(var19)).getChrCodeCaisse().equals(var13)) {
                              this.chrono = (Chrono)this.chronoList.get(var19);
                              var17 = true;
                              break;
                           }
                        }

                        this.creationLigneChrono(var17, var7, var16, var2, var1, var3, var4, var5, var6, var13, var25, var10);
                     }
                  }
               }
            }
         }

         var11.commit();
      } catch (HibernateException var23) {
         if (var11 != null) {
            var11.rollback();
         }

         throw var23;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.datamodelChrono.setWrappedData(this.chronoList);
      this.showModalPanelAuto = false;
   }

   public void creationLigneChrono(Boolean var1, String var2, int var3, int var4, String var5, int var6, int var7, String var8, String var9, String var10, int var11, Session var12) throws HibernateException, NamingException {
      if (!var1) {
         this.chrono = new Chrono();
         this.chrono.setChrPrive(0);
         this.chrono.setChrJournal("");
         this.chrono.setChrNature(var3);
         this.chrono.setChrSerie(var2);
         this.chrono.setChrNbCar(var4);
         this.chrono.setChrPeriode(var5);
         this.chrono.setChrMode(var6);
         this.chrono.setChrFormat(var7);
         this.chrono.setChrPrefixe(var8);
         this.chrono.setChrSufixe(var9);
         if (this.chrono.getChrNom() == null || this.chrono.getChrNom().isEmpty()) {
            this.chrono.setChrNom("(" + this.chrono.getChrSerie() + ") " + this.chrono.getLibnature());
         }

         if (this.chrono.getChrMode() == 2) {
            this.chrono.setChrPeriode("");
         } else if (this.chrono.getChrPeriode() == null || this.chrono.getChrPeriode().isEmpty()) {
            this.chrono.setChrPeriode("" + this.exercicesCaisse.getExecaiId());
         }

         this.chrono.setChrCodeCaisse(var10);
         this.chrono.setChrModeCaisse(var11);
         this.chrono = this.chronoDao.insertChrono(this.chrono, var12);
         this.chronoList.add(this.chrono);
      } else {
         this.chrono.setChrPrive(0);
         this.chrono.setChrJournal("");
         this.chrono.setChrNature(var3);
         this.chrono.setChrSerie(var2);
         this.chrono.setChrNbCar(var4);
         this.chrono.setChrPeriode(var5);
         this.chrono.setChrMode(var6);
         this.chrono.setChrFormat(var7);
         this.chrono.setChrPrefixe(var8);
         this.chrono.setChrSufixe(var9);
         if ("".equals(this.chrono.getChrNom())) {
            this.chrono.setChrNom(this.chrono.getLibnature());
         }

         if (this.chrono.getChrMode() == 2) {
            this.chrono.setChrPeriode("");
         } else if (this.chrono.getChrPeriode() == null || this.chrono.getChrPeriode().isEmpty()) {
            this.chrono.setChrPeriode("" + this.exercicesCaisse.getExecaiId());
         }

         this.chrono.setChrCodeCaisse(var10);
         this.chrono.setChrModeCaisse(var11);
         this.chrono = this.chronoDao.modifierChrono(this.chrono, var12);
      }

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

   public boolean isVisibiliteBton() {
      return this.visibiliteBton;
   }

   public void setVisibiliteBton(boolean var1) {
      this.visibiliteBton = var1;
   }

   public boolean isVar_valide() {
      return this.var_valide;
   }

   public void setVar_valide(boolean var1) {
      this.var_valide = var1;
   }

   public ExercicesCaisse getExercicesCaisse() {
      return this.exercicesCaisse;
   }

   public void setExercicesCaisse(ExercicesCaisse var1) {
      this.exercicesCaisse = var1;
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

   public OptionCaisses getOptionCaisses() {
      return this.optionCaisses;
   }

   public void setOptionCaisses(OptionCaisses var1) {
      this.optionCaisses = var1;
   }

   public boolean isType1() {
      return this.type1;
   }

   public void setType1(boolean var1) {
      this.type1 = var1;
   }

   public boolean isType10() {
      return this.type10;
   }

   public void setType10(boolean var1) {
      this.type10 = var1;
   }

   public boolean isType2() {
      return this.type2;
   }

   public void setType2(boolean var1) {
      this.type2 = var1;
   }

   public boolean isType3() {
      return this.type3;
   }

   public void setType3(boolean var1) {
      this.type3 = var1;
   }

   public boolean isType4() {
      return this.type4;
   }

   public void setType4(boolean var1) {
      this.type4 = var1;
   }

   public boolean isType5() {
      return this.type5;
   }

   public void setType5(boolean var1) {
      this.type5 = var1;
   }

   public boolean isType6() {
      return this.type6;
   }

   public void setType6(boolean var1) {
      this.type6 = var1;
   }

   public boolean isType7() {
      return this.type7;
   }

   public void setType7(boolean var1) {
      this.type7 = var1;
   }

   public boolean isType8() {
      return this.type8;
   }

   public void setType8(boolean var1) {
      this.type8 = var1;
   }

   public boolean isType9() {
      return this.type9;
   }

   public void setType9(boolean var1) {
      this.type9 = var1;
   }

   public boolean isType0() {
      return this.type0;
   }

   public void setType0(boolean var1) {
      this.type0 = var1;
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

   public List getMesCaissesItems() {
      return this.mesCaissesItems;
   }

   public void setMesCaissesItems(List var1) {
      this.mesCaissesItems = var1;
   }

   public String getVar_caisse() {
      return this.var_caisse;
   }

   public void setVar_caisse(String var1) {
      this.var_caisse = var1;
   }
}
