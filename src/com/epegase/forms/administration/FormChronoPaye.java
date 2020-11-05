package com.epegase.forms.administration;

import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.ExercicesPaye;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.ExercicesPayeDao;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureNatureSalarie;
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

public class FormChronoPaye implements Serializable {
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
   private boolean testDoubleChrono = false;
   private List mesModes = new ArrayList();
   private List mesFormats = new ArrayList();
   private ExercicesPaye exercicesPaye;
   private ExercicesPayeDao exercicesPayeDao;
   private LectureNatureSalarie lectureNatureSalarie;
   private List lesNaturesSalariesItems = new ArrayList();
   private boolean testSelectChronoPaye = false;
   private List chronoTmp = new ArrayList();
   private List lesPeriodesItems = new ArrayList();
   private String periode;

   public void InstancesDaoUtilses() {
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
      this.exercicesPayeDao = new ExercicesPayeDao(this.baseLog, this.utilInitHibernate);
   }

   public void lesChronos(Session var1) throws HibernateException, NamingException {
      this.chronoList.clear();
      this.chronoTmp.clear();
      this.chronoTmp = this.chronoDao.selectListPaye(this.usersLog.getUsrJrxReserve(), var1);
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
      this.exercicesPaye = this.exercicesPayeDao.recupererLastExo(var1);
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
      if (this.chrono.getChrNature() == 81) {
         this.mesModes.add(new SelectItem(2, "Chrono continu"));
      } else {
         this.mesModes.add(new SelectItem(0, "Chrono Annuel"));
         this.mesModes.add(new SelectItem(1, "Chrono mensuel"));
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
      this.chrono.setChrNbCar(6);
      this.testSelectChrono = false;
      this.testDoubleChrono = false;
      this.testSelectChronoPaye = false;
      this.showModalPanel = true;
      this.calculeMesModes();
   }

   public void modifierChrono() throws IOException {
      if (this.chrono != null) {
         this.testSelectChrono = true;
         this.testDoubleChrono = true;
         this.testSelectChronoPaye = false;
         if (this.chrono.getChrNature() == 81) {
            this.lectureNatureSalarie = new LectureNatureSalarie();
            this.lectureNatureSalarie.recupereNatureSalarie();
            this.lesNaturesSalariesItems = this.lectureNatureSalarie.getMesNatureSalarieItems();
            this.testSelectChronoPaye = true;
         } else {
            this.testSelectChronoPaye = false;
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

   public void selectNature() throws IOException, HibernateException, NamingException {
      this.calculeMesModes();
      if (this.chrono.getChrNature() == 81) {
         this.chrono.setChrMode(2);
      }

      this.calculeMesFormats();
      if (this.chrono.getChrNature() != 0) {
         this.testSelectChrono = true;
         if (this.chrono.getChrNature() == 81) {
            this.lectureNatureSalarie = new LectureNatureSalarie();
            this.lectureNatureSalarie.recupereNatureSalarie();
            this.lesNaturesSalariesItems = this.lectureNatureSalarie.getMesNatureSalarieItems();
            this.testSelectChronoPaye = true;
         } else {
            this.testSelectChronoPaye = false;
            this.chrono.setChrSerie("");
         }

         this.doublon();
      } else {
         this.testSelectChrono = false;
         this.testSelectChronoPaye = false;
      }

   }

   public void calculeMode() throws HibernateException, NamingException {
      this.calculeMesFormats();
      if (this.chrono.getChrNature() == 81) {
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
         boolean var2 = false;
         if (this.chrono.getChrNature() == 81 && this.chrono.getChrSerie() != null && this.chrono.getChrSerie().contains(":")) {
            var1 = " chrSerie='" + this.chrono.getChrSerie() + "' and chrNature=" + this.chrono.getChrNature() + " and chrPeriode='" + this.chrono.getChrPeriode() + "'";
            var2 = true;
         } else if (this.chrono.getChrNature() != 81) {
            var1 = " chrNature='" + this.chrono.getChrNature() + "' and chrPeriode='" + this.chrono.getChrPeriode() + "'";
            var2 = true;
         }

         if (var2) {
            Chrono var3 = this.chronoDao.selectUnique(var1);
            if (var3 != null) {
               this.testDoubleChrono = false;
            } else {
               this.testDoubleChrono = true;
            }
         } else {
            this.testDoubleChrono = false;
         }
      } else {
         this.testDoubleChrono = false;
      }

   }

   public void saveChrono() throws HibernateException, NamingException {
      if ("".equals(this.chrono.getChrNom())) {
         this.chrono.setChrNom(this.chrono.getLibnature());
      }

      if (this.chrono.getChrMode() == 2) {
         this.chrono.setChrPeriode("");
      } else if (this.chrono.getChrPeriode() == null || this.chrono.getChrPeriode().isEmpty()) {
         this.chrono.setChrPeriode("" + this.exercicesPaye.getExepayId());
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
      this.chrono.setChrNbCar(6);
      this.chrono.setChrMode(2);
      this.chrono.setChrFormat(0);
      this.chrono.setChrPeriode("");
      this.testSelectChrono = false;
      this.testDoubleChrono = false;
      this.testSelectChronoPaye = false;
      this.showModalPanelAuto = true;
      this.calculeMesModes();
   }

   public void annuleSaisieAutomatique() {
      this.showModalPanelAuto = false;
      this.visibiliteBton = false;
   }

   public List listChrono() throws IOException {
      ArrayList var1 = new ArrayList();
      this.lectureNatureSalarie = new LectureNatureSalarie();
      this.lectureNatureSalarie.recupereNatureSalarie();
      this.lesNaturesSalariesItems = this.lectureNatureSalarie.getMesNatureSalarieItems();
      if (this.lesNaturesSalariesItems.size() != 0) {
         for(int var2 = 0; var2 < this.lesNaturesSalariesItems.size(); ++var2) {
            if (((SelectItem)this.lesNaturesSalariesItems.get(var2)).getLabel().toString().startsWith("01") || ((SelectItem)this.lesNaturesSalariesItems.get(var2)).getLabel().toString().startsWith("02") || ((SelectItem)this.lesNaturesSalariesItems.get(var2)).getLabel().toString().startsWith("03")) {
               var1.add(new SelectItem(81, ((SelectItem)this.lesNaturesSalariesItems.get(var2)).getLabel().toString()));
            }
         }
      }

      var1.add(new SelectItem(82, "Contrat"));
      var1.add(new SelectItem(83, "Attestation"));
      var1.add(new SelectItem(84, "Cursus"));
      var1.add(new SelectItem(85, "Certificat"));
      var1.add(new SelectItem(86, "Correspondance"));
      var1.add(new SelectItem(87, "Prêt (internes/externes/Manuels/Capitalisation)"));
      var1.add(new SelectItem(88, "Congés"));
      var1.add(new SelectItem(89, "Absences"));
      var1.add(new SelectItem(90, "Buuletin"));
      var1.add(new SelectItem(91, "Mission"));
      var1.add(new SelectItem(92, "Pointage"));
      var1.add(new SelectItem(93, "R.H."));
      if (this.structureLog.getStrid() == 14L) {
         var1.add(new SelectItem(99, "Analyse CV"));
      }

      return var1;
   }

   public void saveChronoAuto() throws HibernateException, NamingException, IOException {
      String var1 = this.chrono.getChrPeriode();
      int var2 = this.chrono.getChrNbCar();
      int var3 = this.chrono.getChrMode();
      int var4 = this.chrono.getChrFormat();
      String var5 = this.chrono.getChrPrefixe();
      String var6 = this.chrono.getChrSufixe();
      Session var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
      Transaction var8 = null;

      try {
         var8 = var7.beginTransaction();
         new ArrayList();
         List var9 = this.listChrono();
         if (var9.size() != 0) {
            for(int var10 = 0; var10 < var9.size(); ++var10) {
               String var11 = ((SelectItem)var9.get(var10)).getLabel().toString();
               int var12 = Integer.parseInt(((SelectItem)var9.get(var10)).getValue().toString());
               boolean var13 = false;

               for(int var14 = 0; var14 < this.chronoList.size(); ++var14) {
                  if (var12 == 81) {
                     if (var11 != null && !var11.isEmpty() && ((Chrono)this.chronoList.get(var14)).getChrSerie().equalsIgnoreCase(var11)) {
                        this.chrono = (Chrono)this.chronoList.get(var14);
                        var13 = true;
                        break;
                     }
                  } else if (((Chrono)this.chronoList.get(var14)).getChrNature() == var12) {
                     this.chrono = (Chrono)this.chronoList.get(var14);
                     var13 = true;
                     break;
                  }
               }

               if (!var13) {
                  this.chrono = new Chrono();
                  this.chrono.setChrPrive(0);
                  this.chrono.setChrJournal("");
                  this.chrono.setChrNature(Integer.parseInt(((SelectItem)var9.get(var10)).getValue().toString()));
                  if (this.chrono.getChrNature() == 81) {
                     this.chrono.setChrSerie(((SelectItem)var9.get(var10)).getLabel().toString());
                  } else {
                     this.chrono.setChrSerie("");
                  }

                  this.chrono.setChrNbCar(var2);
                  this.chrono.setChrPeriode(var1);
                  this.chrono.setChrMode(var3);
                  this.chrono.setChrFormat(var4);
                  this.chrono.setChrPrefixe(var5);
                  this.chrono.setChrSufixe(var6);
                  if ("".equals(this.chrono.getChrNom())) {
                     this.chrono.setChrNom(this.chrono.getLibnature());
                  }

                  if (this.chrono.getChrMode() == 2) {
                     this.chrono.setChrPeriode("");
                  } else if (this.chrono.getChrPeriode() == null || this.chrono.getChrPeriode().isEmpty()) {
                     this.chrono.setChrPeriode("" + this.exercicesPaye.getExepayId());
                  }

                  this.chrono = this.chronoDao.insertChrono(this.chrono, var7);
                  this.chronoList.add(this.chrono);
               } else {
                  this.chrono.setChrPrive(0);
                  this.chrono.setChrJournal("");
                  this.chrono.setChrNature(Integer.parseInt(((SelectItem)var9.get(var10)).getValue().toString()));
                  if (this.chrono.getChrNature() == 81) {
                     this.chrono.setChrSerie(((SelectItem)var9.get(var10)).getLabel().toString());
                  } else {
                     this.chrono.setChrSerie("");
                  }

                  this.chrono.setChrNbCar(var2);
                  this.chrono.setChrPeriode(var1);
                  this.chrono.setChrMode(var3);
                  this.chrono.setChrFormat(var4);
                  this.chrono.setChrPrefixe(var5);
                  this.chrono.setChrSufixe(var6);
                  if ("".equals(this.chrono.getChrNom())) {
                     this.chrono.setChrNom(this.chrono.getLibnature());
                  }

                  if (this.chrono.getChrMode() == 2) {
                     this.chrono.setChrPeriode("");
                  } else if (this.chrono.getChrPeriode() == null || this.chrono.getChrPeriode().isEmpty()) {
                     this.chrono.setChrPeriode("" + this.exercicesPaye.getExepayId());
                  }

                  this.chrono = this.chronoDao.modifierChrono(this.chrono, var7);
               }
            }
         }

         var8.commit();
      } catch (HibernateException var18) {
         if (var8 != null) {
            var8.rollback();
         }

         throw var18;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.datamodelChrono.setWrappedData(this.chronoList);
      this.showModalPanelAuto = false;
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

   public LectureNatureSalarie getLectureNatureSalarie() {
      return this.lectureNatureSalarie;
   }

   public void setLectureNatureSalarie(LectureNatureSalarie var1) {
      this.lectureNatureSalarie = var1;
   }

   public List getLesNaturesSalariesItems() {
      return this.lesNaturesSalariesItems;
   }

   public void setLesNaturesSalariesItems(List var1) {
      this.lesNaturesSalariesItems = var1;
   }

   public boolean isTestSelectChronoPaye() {
      return this.testSelectChronoPaye;
   }

   public void setTestSelectChronoPaye(boolean var1) {
      this.testSelectChronoPaye = var1;
   }

   public ExercicesPaye getExercicesPaye() {
      return this.exercicesPaye;
   }

   public void setExercicesPaye(ExercicesPaye var1) {
      this.exercicesPaye = var1;
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
}
