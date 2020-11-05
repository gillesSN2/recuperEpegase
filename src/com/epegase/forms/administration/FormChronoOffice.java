package com.epegase.forms.administration;

import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.Sms;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.StructurePeg;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.SmsDao;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureNatureCourrier;
import com.epegase.systeme.xml.ObjetNatureCourrier;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jdom.JDOMException;

public class FormChronoOffice implements Serializable {
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
   private boolean visibiliteBton = false;
   private boolean var_valide = false;
   private List mesModes = new ArrayList();
   private List mesFormats = new ArrayList();
   private List chronoTmp = new ArrayList();
   private List lesPeriodesItems = new ArrayList();
   private String periode;
   private boolean modeGroupe;
   private List lesStructures = new ArrayList();
   private List mesStructuresItems = new ArrayList();
   private long var_structure;

   public void InstancesDaoUtilses() {
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
   }

   public void lesChronos(Session var1) throws HibernateException, NamingException {
      this.chronoList.clear();
      this.chronoTmp.clear();
      this.chronoTmp = this.chronoDao.selectListOffice(this.usersLog.getUsrJrxReserve(), var1);
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
      if (this.structureLog.getStrmaitrecabinet() == 2) {
         this.modeGroupe = true;
      } else {
         this.modeGroupe = false;
      }

   }

   public void lesChronosTiers(Session var1) throws HibernateException, NamingException {
      this.chronoList.clear();
      this.chronoTmp.clear();
      this.chronoTmp = this.chronoDao.selectListTiers(this.usersLog.getUsrJrxReserve(), var1);
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
      if (this.structureLog.getStrmaitrecabinet() == 2) {
         this.modeGroupe = true;
      } else {
         this.modeGroupe = false;
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

   public void menuGroupeListesociete() throws HibernateException, NamingException {
      this.lesStructures.clear();
      this.mesStructuresItems.clear();
      this.var_structure = 0L;
      if (this.modeGroupe) {
         new ArrayList();
         if (this.structureLog.getStrmaitrecabinet() != 0) {
            Session var2 = this.utilInitHibernate.getLoginEpegase();
            Query var3 = var2.createQuery("from StructurePeg where strId=:idStr").setLong("idStr", this.structureLog.getStrid());
            List var1 = var3.list();
            if (var1.size() != 0) {
               long var4 = ((StructurePeg)var1.get(0)).getCabinetPeg().getCabId();
               if (var4 != 0L) {
                  var3 = var2.createQuery("from StructurePeg where cabinetPeg.cabId=:idCab)").setLong("idCab", var4);
                  this.lesStructures = var3.list();

                  for(int var6 = 0; var6 < this.lesStructures.size(); ++var6) {
                     this.mesStructuresItems.add(new SelectItem(((StructurePeg)this.lesStructures.get(var6)).getStrId(), "(" + ((StructurePeg)this.lesStructures.get(var6)).getStrId() + ")" + ((StructurePeg)this.lesStructures.get(var6)).getStrraisonsociale()));
                  }
               }
            }

            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void ajouterChrono() {
      this.chrono = new Chrono();
      this.chrono.setChrNbCar(5);
      this.chrono.setChrFormat(0);
      this.chrono.setChrMode(2);
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

   public void calculeMode() throws HibernateException, NamingException {
      this.calculeMesFormats();
      this.doublon();
   }

   public void doublon() throws HibernateException, NamingException {
      this.var_valide = false;
      if (this.chrono.getChrNature() != 0) {
         String var1 = "";
         if (this.chrono.getChrIdStr() != 0L) {
            var1 = " chrNature=" + this.chrono.getChrNature() + " and chrPeriode='" + this.chrono.getChrPeriode() + "' and chrIdStr=" + this.chrono.getChrIdStr();
         } else {
            var1 = " chrNature=" + this.chrono.getChrNature() + " and chrPeriode='" + this.chrono.getChrPeriode() + "'";
         }

         new Chrono();
         Chrono var2 = this.chronoDao.selectUnique(var1);
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
      this.chrono.setChrSerie("");
      this.chrono.setChrNom("");
      if (this.chrono.getChrMode() == 2) {
         this.chrono.setChrPeriode("");
      } else if (this.chrono.getChrPeriode() == null || this.chrono.getChrPeriode().isEmpty()) {
         int var1 = (new Date()).getYear() + 1900;
         this.chrono.setChrPeriode("" + var1);
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
         boolean var3 = false;

         for(int var2 = 0; var2 < this.lesPeriodesItems.size(); ++var2) {
            if (((SelectItem)this.lesPeriodesItems.get(var2)).getValue().toString().equals(this.chrono.getChrPeriode())) {
               var3 = true;
               break;
            }
         }

         if (!var3) {
            this.lesPeriodesItems.add(new SelectItem(this.chrono.getChrPeriode()));
         }
      }

      if (this.chrono.getChrNature() == 122) {
         Sms var4 = new Sms();
         SmsDao var5 = new SmsDao(this.baseLog, this.utilInitHibernate);
         var4.setSmsDate(new Date());
         var4.setSmsTexte("Pack SMS offert (20 sms)");
         var4.setSmsQte(20);
         var4.setSmsStatus("Ok");
         var4.setSmsTypeTiers(99);
         var4.setUsers(this.usersLog);
         var5.insert(var4);
      }

      this.showModalPanel = false;
   }

   public void majChronoAutmatique() {
      this.chrono = new Chrono();
      this.chrono.setChrNbCar(5);
      this.chrono.setChrFormat(0);
      this.chrono.setChrMode(2);
      this.chrono.setChrPeriode("");
      this.chrono.setChrSerie("A");
      this.showModalPanelAuto = true;
      this.calculeMesModes();
   }

   public void annuleSaisieAutomatique() {
      this.showModalPanelAuto = false;
      this.visibiliteBton = false;
   }

   public List listChrono() throws IOException, JDOMException {
      ArrayList var1 = new ArrayList();
      var1.add(new SelectItem(2, "Messagerie envoyée"));
      var1.add(new SelectItem(3, "Messagerie reçue"));
      var1.add(new SelectItem(4, "Messagerie autre"));
      var1.add(new SelectItem(122, "SMS"));
      var1.add(new SelectItem(5, "Réunions Internes"));
      var1.add(new SelectItem(120, "Réunions Tiers"));
      var1.add(new SelectItem(121, "Réunions Commerciales"));
      var1.add(new SelectItem(123, "Visio-conférences"));
      var1.add(new SelectItem(124, "Certification"));
      var1.add(new SelectItem(125, "Messagerie interne envoyée"));
      var1.add(new SelectItem(126, "Messagerie interne reçue"));
      var1.add(new SelectItem(127, "Porte feuille affaire"));
      var1.add(new SelectItem(128, "Imputation analytique affaire"));
      LectureNatureCourrier var2 = new LectureNatureCourrier();
      var2.setStrId(this.structureLog.getStrid());
      var2.setStructureLog(this.structureLog);
      new ArrayList();
      var2.chargerMesFamillesClientItems();
      List var3 = var2.getMesNatures();
      if (var3.size() != 0) {
         for(int var4 = 0; var4 < var3.size(); ++var4) {
            if (((ObjetNatureCourrier)var3.get(var4)).getCode() != null && !((ObjetNatureCourrier)var3.get(var4)).getCode().isEmpty() && ((ObjetNatureCourrier)var3.get(var4)).getLibelle() != null && !((ObjetNatureCourrier)var3.get(var4)).getLibelle().isEmpty()) {
               var1.add(new SelectItem(((ObjetNatureCourrier)var3.get(var4)).getCode(), ((ObjetNatureCourrier)var3.get(var4)).getLibelle()));
            }
         }
      }

      return var1;
   }

   public void saveChronoAuto() throws HibernateException, NamingException, IOException, JDOMException {
      String var1 = this.chrono.getChrPeriode();
      int var2 = this.chrono.getChrNbCar();
      int var3 = this.chrono.getChrMode();
      int var4 = this.chrono.getChrFormat();
      String var5 = this.chrono.getChrPrefixe();
      String var6 = this.chrono.getChrSufixe();
      String var7 = this.chrono.getChrSerie();
      Session var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
      Transaction var9 = null;

      try {
         var9 = var8.beginTransaction();
         new ArrayList();
         List var10 = this.listChrono();
         long var11 = 0L;
         int var13 = 0;
         ArrayList var14 = new ArrayList();
         int var25;
         if (this.modeGroupe && this.lesStructures.size() != 0) {
            for(var25 = 0; var25 < this.lesStructures.size(); ++var25) {
               var14.add(this.lesStructures.get(var25));
            }
         } else {
            StructurePeg var15 = new StructurePeg();
            var14.add(var15);
         }

         for(var25 = 0; var25 < var14.size(); ++var25) {
            var11 = ((StructurePeg)var14.get(var25)).getStrId();
            ++var13;
            if (var10.size() != 0) {
               for(int var16 = 0; var16 < var10.size(); ++var16) {
                  int var17 = Integer.parseInt(((SelectItem)var10.get(var16)).getValue().toString());
                  boolean var18 = false;

                  for(int var19 = 0; var19 < this.chronoList.size(); ++var19) {
                     if (var7 != null && !var7.isEmpty()) {
                        if (((Chrono)this.chronoList.get(var19)).getChrIdStr() == var11 && ((Chrono)this.chronoList.get(var19)).getChrNature() == var17 && ((Chrono)this.chronoList.get(var19)).getChrSerie().equalsIgnoreCase(var7)) {
                           this.chrono = (Chrono)this.chronoList.get(var19);
                           var18 = true;
                           break;
                        }
                     } else if (((Chrono)this.chronoList.get(var19)).getChrIdStr() == var11 && ((Chrono)this.chronoList.get(var19)).getChrNature() == var17) {
                        this.chrono = (Chrono)this.chronoList.get(var19);
                        var18 = true;
                        break;
                     }
                  }

                  if (!var18) {
                     this.chrono = new Chrono();
                     if (this.modeGroupe) {
                        this.chrono.setChrIdStr(var11);
                        this.chrono.setChrPrefixe("" + var13);
                     } else {
                        this.chrono.setChrIdStr(0L);
                        this.chrono.setChrPrefixe(var5);
                     }

                     this.chrono.setChrPrive(0);
                     this.chrono.setChrJournal("");
                     this.chrono.setChrNature(Integer.parseInt(((SelectItem)var10.get(var16)).getValue().toString()));
                     this.chrono.setChrSerie(var7);
                     this.chrono.setChrNbCar(var2);
                     this.chrono.setChrPeriode(var1);
                     this.chrono.setChrMode(var3);
                     this.chrono.setChrFormat(var4);
                     this.chrono.setChrSufixe(var6);
                     if (this.chrono.getChrNom() == null || this.chrono.getChrNom().isEmpty()) {
                        this.chrono.setChrNom("(" + this.chrono.getChrSerie() + ") " + this.chrono.getLibnature());
                     }

                     if (this.chrono.getChrMode() == 2) {
                        this.chrono.setChrPeriode("");
                     } else if (this.chrono.getChrPeriode() == null || this.chrono.getChrPeriode().isEmpty()) {
                        this.chrono.setChrPeriode("" + ((new Date()).getYear() + 1900));
                     }

                     this.chrono = this.chronoDao.insertChrono(this.chrono, var8);
                     this.chronoList.add(this.chrono);
                  } else {
                     if (this.modeGroupe) {
                        this.chrono.setChrIdStr(var11);
                        this.chrono.setChrPrefixe("" + var13);
                     } else {
                        this.chrono.setChrIdStr(0L);
                        this.chrono.setChrPrefixe(var5);
                     }

                     this.chrono.setChrPrive(0);
                     this.chrono.setChrJournal("");
                     this.chrono.setChrNature(Integer.parseInt(((SelectItem)var10.get(var16)).getValue().toString()));
                     this.chrono.setChrSerie(var7);
                     this.chrono.setChrNbCar(var2);
                     this.chrono.setChrPeriode(var1);
                     this.chrono.setChrMode(var3);
                     this.chrono.setChrFormat(var4);
                     this.chrono.setChrSufixe(var6);
                     if ("".equals(this.chrono.getChrNom())) {
                        this.chrono.setChrNom(this.chrono.getLibnature());
                     }

                     if (this.chrono.getChrMode() == 2) {
                        this.chrono.setChrPeriode("");
                     } else if (this.chrono.getChrPeriode() == null || this.chrono.getChrPeriode().isEmpty()) {
                        this.chrono.setChrPeriode("" + ((new Date()).getYear() + 1900));
                     }

                     this.chrono = this.chronoDao.modifierChrono(this.chrono, var8);
                  }
               }
            }
         }

         var9.commit();
      } catch (HibernateException var23) {
         if (var9 != null) {
            var9.rollback();
         }

         throw var23;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.datamodelChrono.setWrappedData(this.chronoList);
      this.showModalPanelAuto = false;
   }

   public List listChronoTiers() throws IOException, JDOMException {
      ArrayList var1 = new ArrayList();
      var1.add(new SelectItem(300, "Fournisseur"));
      var1.add(new SelectItem(301, "Suspect"));
      var1.add(new SelectItem(303, "Prospect"));
      var1.add(new SelectItem(303, "Client"));
      var1.add(new SelectItem(304, "Proprietaire"));
      var1.add(new SelectItem(305, "Copropriété"));
      var1.add(new SelectItem(306, "Locataire"));
      LectureNatureCourrier var2 = new LectureNatureCourrier();
      var2.setStrId(this.structureLog.getStrid());
      var2.setStructureLog(this.structureLog);
      new ArrayList();
      var2.chargerMesFamillesClientItems();
      List var3 = var2.getMesNatures();
      if (var3.size() != 0) {
         for(int var4 = 0; var4 < var3.size(); ++var4) {
            if (((ObjetNatureCourrier)var3.get(var4)).getCode() != null && !((ObjetNatureCourrier)var3.get(var4)).getCode().isEmpty() && ((ObjetNatureCourrier)var3.get(var4)).getLibelle() != null && !((ObjetNatureCourrier)var3.get(var4)).getLibelle().isEmpty()) {
               var1.add(new SelectItem(((ObjetNatureCourrier)var3.get(var4)).getCode(), ((ObjetNatureCourrier)var3.get(var4)).getLibelle()));
            }
         }
      }

      return var1;
   }

   public void saveChronoAutoTiers() throws HibernateException, NamingException, IOException, JDOMException {
      String var1 = this.chrono.getChrPeriode();
      int var2 = this.chrono.getChrNbCar();
      int var3 = this.chrono.getChrMode();
      int var4 = this.chrono.getChrFormat();
      String var5 = this.chrono.getChrPrefixe();
      String var6 = this.chrono.getChrSufixe();
      String var7 = this.chrono.getChrSerie();
      Session var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
      Transaction var9 = null;

      try {
         var9 = var8.beginTransaction();
         new ArrayList();
         List var10 = this.listChronoTiers();
         long var11 = 0L;
         int var13 = 0;
         ArrayList var14 = new ArrayList();
         int var25;
         if (this.modeGroupe && this.lesStructures.size() != 0) {
            for(var25 = 0; var25 < this.lesStructures.size(); ++var25) {
               var14.add(this.lesStructures.get(var25));
            }
         } else {
            StructurePeg var15 = new StructurePeg();
            var14.add(var15);
         }

         for(var25 = 0; var25 < var14.size(); ++var25) {
            var11 = ((StructurePeg)var14.get(var25)).getStrId();
            ++var13;
            if (var10.size() != 0) {
               for(int var16 = 0; var16 < var10.size(); ++var16) {
                  int var17 = Integer.parseInt(((SelectItem)var10.get(var16)).getValue().toString());
                  boolean var18 = false;

                  for(int var19 = 0; var19 < this.chronoList.size(); ++var19) {
                     if (var7 != null && !var7.isEmpty()) {
                        if (((Chrono)this.chronoList.get(var19)).getChrIdStr() == var11 && ((Chrono)this.chronoList.get(var19)).getChrNature() == var17 && ((Chrono)this.chronoList.get(var19)).getChrSerie().equalsIgnoreCase(var7)) {
                           this.chrono = (Chrono)this.chronoList.get(var19);
                           var18 = true;
                           break;
                        }
                     } else if (((Chrono)this.chronoList.get(var19)).getChrIdStr() == var11 && ((Chrono)this.chronoList.get(var19)).getChrNature() == var17) {
                        this.chrono = (Chrono)this.chronoList.get(var19);
                        var18 = true;
                        break;
                     }
                  }

                  if (!var18) {
                     this.chrono = new Chrono();
                     if (this.modeGroupe) {
                        this.chrono.setChrIdStr(var11);
                        this.chrono.setChrPrefixe("" + var13);
                     } else {
                        this.chrono.setChrIdStr(0L);
                        this.chrono.setChrPrefixe(var5);
                     }

                     this.chrono.setChrPrive(0);
                     this.chrono.setChrJournal("");
                     this.chrono.setChrNature(Integer.parseInt(((SelectItem)var10.get(var16)).getValue().toString()));
                     this.chrono.setChrSerie(var7);
                     this.chrono.setChrNbCar(var2);
                     this.chrono.setChrPeriode(var1);
                     this.chrono.setChrMode(var3);
                     this.chrono.setChrFormat(var4);
                     this.chrono.setChrSufixe(var6);
                     if (this.chrono.getChrNom() == null || this.chrono.getChrNom().isEmpty()) {
                        this.chrono.setChrNom("(" + this.chrono.getChrSerie() + ") " + this.chrono.getLibnature());
                     }

                     if (this.chrono.getChrMode() == 2) {
                        this.chrono.setChrPeriode("");
                     } else if (this.chrono.getChrPeriode() == null || this.chrono.getChrPeriode().isEmpty()) {
                        this.chrono.setChrPeriode("" + ((new Date()).getYear() + 1900));
                     }

                     this.chrono = this.chronoDao.insertChrono(this.chrono, var8);
                     this.chronoList.add(this.chrono);
                  } else {
                     if (this.modeGroupe) {
                        this.chrono.setChrIdStr(var11);
                        this.chrono.setChrPrefixe("" + var13);
                     } else {
                        this.chrono.setChrIdStr(0L);
                        this.chrono.setChrPrefixe(var5);
                     }

                     this.chrono.setChrPrive(0);
                     this.chrono.setChrJournal("");
                     this.chrono.setChrNature(Integer.parseInt(((SelectItem)var10.get(var16)).getValue().toString()));
                     this.chrono.setChrSerie(var7);
                     this.chrono.setChrNbCar(var2);
                     this.chrono.setChrPeriode(var1);
                     this.chrono.setChrMode(var3);
                     this.chrono.setChrFormat(var4);
                     this.chrono.setChrSufixe(var6);
                     if ("".equals(this.chrono.getChrNom())) {
                        this.chrono.setChrNom(this.chrono.getLibnature());
                     }

                     if (this.chrono.getChrMode() == 2) {
                        this.chrono.setChrPeriode("");
                     } else if (this.chrono.getChrPeriode() == null || this.chrono.getChrPeriode().isEmpty()) {
                        this.chrono.setChrPeriode("" + ((new Date()).getYear() + 1900));
                     }

                     this.chrono = this.chronoDao.modifierChrono(this.chrono, var8);
                  }
               }
            }
         }

         var9.commit();
      } catch (HibernateException var23) {
         if (var9 != null) {
            var9.rollback();
         }

         throw var23;
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

   public List getChronoList() {
      return this.chronoList;
   }

   public void setChronoList(List var1) {
      this.chronoList = var1;
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

   public List getMesStructuresItems() {
      return this.mesStructuresItems;
   }

   public void setMesStructuresItems(List var1) {
      this.mesStructuresItems = var1;
   }

   public boolean isModeGroupe() {
      return this.modeGroupe;
   }

   public void setModeGroupe(boolean var1) {
      this.modeGroupe = var1;
   }
}
