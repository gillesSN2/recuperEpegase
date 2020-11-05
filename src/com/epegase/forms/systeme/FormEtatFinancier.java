package com.epegase.forms.systeme;

import com.epegase.systeme.classe.PegTabElement;
import com.epegase.systeme.classe.PegTabFormule;
import com.epegase.systeme.classe.PegTabNom;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.EtatFinancier;
import com.epegase.systeme.dao.PegTabElementDao;
import com.epegase.systeme.dao.PegTabFormuleDao;
import com.epegase.systeme.dao.PegTabNomDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.LectureZonesFiscales;
import com.epegase.systeme.xml.ObjetCompte;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FormEtatFinancier implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private transient DataModel datamodelMesZones = new ListDataModel();
   private List meszone = new ArrayList();
   private ObjetCompte zone = new ObjetCompte();
   private List mesSzonesItems = new ArrayList();
   private transient DataModel datamodeltabNom = new ListDataModel();
   private List lesPegTabNom = new ArrayList();
   private PegTabNomDao pegTabNomDao;
   private PegTabNom pegTabNom = new PegTabNom();
   private PegTabNom pegTabNomMemo;
   private boolean showmodalPanelTableaux = false;
   private boolean showmodalPanelDuppiquerTableaux = false;
   private List lesNomsCol = new ArrayList();
   private transient DataModel dataModelLesNomsCol = new ListDataModel();
   private EtatFinancier etatFinancier = new EtatFinancier();
   private boolean showmodalPanelColonne = false;
   private int numLigneColonne;
   private transient DataModel datamodeltabElement = new ListDataModel();
   private List lesPegTabElements = new ArrayList();
   private PegTabElementDao pegTabElementDao;
   private PegTabElement pegTabElement = new PegTabElement();
   private boolean showmodalPanelElement = false;
   private transient DataModel datamodeltabFormule = new ListDataModel();
   private List lesPegTabFormules = new ArrayList();
   private PegTabFormuleDao pegTabFormuleDao;
   private PegTabFormule pegTabFormule = new PegTabFormule();
   private boolean showmodalPanelFormule = false;
   private String formatImpression;
   private String filtre;
   private String requete;
   private UtilPrint utilPrint;

   public FormEtatFinancier() {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
   }

   public void instancesDaoUtilisees() {
      this.pegTabNomDao = new PegTabNomDao(this.utilInitHibernate);
      this.pegTabElementDao = new PegTabElementDao(this.utilInitHibernate);
      this.pegTabFormuleDao = new PegTabFormuleDao(this.utilInitHibernate);
   }

   public void chargerMesCodes() {
      LectureZonesFiscales var1 = new LectureZonesFiscales();
      this.meszone = var1.getMesZonesFiscales();
      ObjetCompte var2 = new ObjetCompte();
      var2.setCode("");
      var2.setIndice(20);
      var2.setCode("BILAN_SOCIAL1");
      this.meszone.add(var2);
      this.datamodelMesZones.setWrappedData(this.meszone);
      this.mesSzonesItems.clear();
      if (this.meszone.size() != 0) {
         for(int var3 = 0; var3 < this.meszone.size(); ++var3) {
            this.mesSzonesItems.add(new SelectItem(((ObjetCompte)this.meszone.get(var3)).getCode()));
         }
      }

   }

   public void selectionZonefiscale() throws HibernateException, NamingException {
      this.zone = (ObjetCompte)this.datamodelMesZones.getRowData();
      this.lesPegTabNom.clear();
      this.datamodeltabNom.setWrappedData(this.meszone);
      this.lesPegTabElements.clear();
      this.datamodeltabElement.setWrappedData(this.lesPegTabElements);
      this.lesNomsCol.clear();
      this.dataModelLesNomsCol.setWrappedData(this.lesNomsCol);
      this.lesPegTabFormules.clear();
      this.datamodeltabFormule.setWrappedData(this.lesPegTabFormules);
      this.chargerMesTabNom();
   }

   public void chargerMesTabNom() throws HibernateException, NamingException {
      this.lesPegTabNom = this.pegTabNomDao.chargerMesTabNom(this.zone.getCode());
      this.datamodeltabNom.setWrappedData(this.getLesPegTabNom());
   }

   public void selectionTableaux() throws HibernateException, NamingException {
      if (this.datamodeltabNom.isRowAvailable()) {
         this.pegTabNom = (PegTabNom)this.datamodeltabNom.getRowData();
         this.chargerLesNomsCol();
         this.chargerMesTabElement();
         this.filtre = this.pegTabNom.getTablisCode() + " : " + this.pegTabNom.getTablisLibFR();
         this.requete = "tablis_code='" + this.pegTabNom.getTablisCode() + "'";
      }

   }

   public void ajouterTableaux() {
      this.pegTabNom = new PegTabNom();
      this.showmodalPanelTableaux = true;
   }

   public void modifierTableaux() {
      if (this.pegTabNom != null) {
         this.showmodalPanelTableaux = true;
      }

   }

   public void supprimerTableaux() throws HibernateException, NamingException {
      if (this.pegTabNom != null) {
         Session var1 = this.utilInitHibernate.getSysteme();
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            long var3 = this.pegTabNom.getTablis_id();
            new ArrayList();
            new ArrayList();
            List var6 = this.pegTabElementDao.chargerMesTabElement(this.pegTabNom.getTablis_id(), var1);
            if (var6.size() != 0) {
               for(int var7 = 0; var7 < var6.size(); ++var7) {
                  this.pegTabElement = (PegTabElement)var6.get(var7);
                  List var5 = this.pegTabFormuleDao.chargerMesTabFormuleElement(this.pegTabElement, var1);
                  if (var5.size() != 0) {
                     for(int var8 = 0; var8 < var5.size(); ++var8) {
                        this.pegTabFormule = (PegTabFormule)var5.get(var8);
                        this.pegTabFormuleDao.delete(this.pegTabFormule, var1);
                     }
                  }

                  this.pegTabElementDao.deletePegtabElement(this.pegTabElement, var1);
               }
            }

            this.lesPegTabNom.remove(this.pegTabNom);
            this.datamodeltabNom.setWrappedData(this.lesPegTabNom);
            this.pegTabNom = this.pegTabNomDao.chargerMesTabNom(var3, var1);
            if (this.pegTabNom != null) {
               this.pegTabNomDao.deletePegtabNom(this.pegTabNom, var1);
            }

            this.pegTabNom = new PegTabNom();
            this.pegTabElement = new PegTabElement();
            this.pegTabFormule = new PegTabFormule();
            this.lesPegTabElements.clear();
            this.datamodeltabElement.setWrappedData(this.lesPegTabElements);
            this.lesPegTabFormules.clear();
            this.datamodeltabFormule.setWrappedData(this.lesPegTabFormules);
            var2.commit();
         } catch (HibernateException var12) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var12;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void annulerTableaux() {
      this.showmodalPanelTableaux = false;
   }

   public void validerTableaux() throws HibernateException, NamingException {
      if (this.pegTabNom.getTablis_id() == 0L) {
         this.pegTabNom = this.pegTabNomDao.savePegtabNom(this.pegTabNom, this.zone.getCode());
         this.lesPegTabNom.add(this.pegTabNom);
         this.datamodeltabNom.setWrappedData(this.lesPegTabNom);
      } else {
         this.pegTabNom = this.pegTabNomDao.updatePegtabNom(this.pegTabNom);
      }

      this.showmodalPanelTableaux = false;
   }

   public void duppliquerTableaux() {
      if (this.pegTabNom != null) {
         this.pegTabNomMemo = this.pegTabNom;
         this.pegTabNom = new PegTabNom();
         this.pegTabNom.setTablisZone(this.zone.getCode());
         this.pegTabNom.setTablisAnneeAnte(this.pegTabNomMemo.getTablisAnneeAnte());
         this.pegTabNom.setTablisAnn01(this.pegTabNomMemo.getTablisAnn01());
         this.pegTabNom.setTablisAnn02(this.pegTabNomMemo.getTablisAnn02());
         this.pegTabNom.setTablisAnn03(this.pegTabNomMemo.getTablisAnn03());
         this.pegTabNom.setTablisAnn04(this.pegTabNomMemo.getTablisAnn04());
         this.pegTabNom.setTablisAnn05(this.pegTabNomMemo.getTablisAnn05());
         this.pegTabNom.setTablisAnn06(this.pegTabNomMemo.getTablisAnn06());
         this.pegTabNom.setTablisAnn07(this.pegTabNomMemo.getTablisAnn07());
         this.pegTabNom.setTablisAnn08(this.pegTabNomMemo.getTablisAnn08());
         this.pegTabNom.setTablisAnn09(this.pegTabNomMemo.getTablisAnn09());
         this.pegTabNom.setTablisAnn10(this.pegTabNomMemo.getTablisAnn10());
         this.pegTabNom.setTablisAnn11(this.pegTabNomMemo.getTablisAnn11());
         this.pegTabNom.setTablisAnn12(this.pegTabNomMemo.getTablisAnn12());
         this.pegTabNom.setTablisAnn13(this.pegTabNomMemo.getTablisAnn13());
         this.pegTabNom.setTablisAnn14(this.pegTabNomMemo.getTablisAnn14());
         this.pegTabNom.setTablisAnn15(this.pegTabNomMemo.getTablisAnn15());
         this.pegTabNom.setTablisAnn16(this.pegTabNomMemo.getTablisAnn16());
         this.pegTabNom.setTablisAnn17(this.pegTabNomMemo.getTablisAnn17());
         this.pegTabNom.setTablisAnn18(this.pegTabNomMemo.getTablisAnn18());
         this.pegTabNom.setTablisAnn19(this.pegTabNomMemo.getTablisAnn19());
         this.pegTabNom.setTablisAnn20(this.pegTabNomMemo.getTablisAnn20());
         this.pegTabNom.setTablisCode(this.pegTabNomMemo.getTablisCode());
         this.pegTabNom.setTablisInactif(this.pegTabNomMemo.isTablisInactif());
         this.pegTabNom.setTablisLibFR(this.pegTabNomMemo.getTablisLibFR());
         this.pegTabNom.setTablisLibSP(this.pegTabNomMemo.getTablisLibSP());
         this.pegTabNom.setTablisLibUK(this.pegTabNomMemo.getTablisLibUK());
         this.pegTabNom.setTablisModele(this.pegTabNomMemo.getTablisModele());
         this.pegTabNom.setTablisModif(this.pegTabNomMemo.getTablisModif());
         this.pegTabNom.setTablisNbCol(this.pegTabNomMemo.getTablisNbCol());
         this.pegTabNom.setTablisNom01(this.pegTabNomMemo.getTablisNom01());
         this.pegTabNom.setTablisNom02(this.pegTabNomMemo.getTablisNom02());
         this.pegTabNom.setTablisNom03(this.pegTabNomMemo.getTablisNom03());
         this.pegTabNom.setTablisNom04(this.pegTabNomMemo.getTablisNom04());
         this.pegTabNom.setTablisNom05(this.pegTabNomMemo.getTablisNom05());
         this.pegTabNom.setTablisNom06(this.pegTabNomMemo.getTablisNom06());
         this.pegTabNom.setTablisNom07(this.pegTabNomMemo.getTablisNom07());
         this.pegTabNom.setTablisNom08(this.pegTabNomMemo.getTablisNom08());
         this.pegTabNom.setTablisNom09(this.pegTabNomMemo.getTablisNom09());
         this.pegTabNom.setTablisNom10(this.pegTabNomMemo.getTablisNom10());
         this.pegTabNom.setTablisNom11(this.pegTabNomMemo.getTablisNom11());
         this.pegTabNom.setTablisNom12(this.pegTabNomMemo.getTablisNom12());
         this.pegTabNom.setTablisNom13(this.pegTabNomMemo.getTablisNom13());
         this.pegTabNom.setTablisNom14(this.pegTabNomMemo.getTablisNom14());
         this.pegTabNom.setTablisNom15(this.pegTabNomMemo.getTablisNom15());
         this.pegTabNom.setTablisNom16(this.pegTabNomMemo.getTablisNom16());
         this.pegTabNom.setTablisNom17(this.pegTabNomMemo.getTablisNom17());
         this.pegTabNom.setTablisNom18(this.pegTabNomMemo.getTablisNom18());
         this.pegTabNom.setTablisNom19(this.pegTabNomMemo.getTablisNom19());
         this.pegTabNom.setTablisNom20(this.pegTabNomMemo.getTablisNom20());
         this.pegTabNom.setTablisNum(this.pegTabNomMemo.getTablisNum());
         this.pegTabNom.setTablisType(this.pegTabNomMemo.getTablisType());
         this.pegTabNom.setTablisTypeCol01(this.pegTabNomMemo.getTablisTypeCol01());
         this.pegTabNom.setTablisTypeCol02(this.pegTabNomMemo.getTablisTypeCol02());
         this.pegTabNom.setTablisTypeCol03(this.pegTabNomMemo.getTablisTypeCol03());
         this.pegTabNom.setTablisTypeCol04(this.pegTabNomMemo.getTablisTypeCol04());
         this.pegTabNom.setTablisTypeCol05(this.pegTabNomMemo.getTablisTypeCol05());
         this.pegTabNom.setTablisTypeCol06(this.pegTabNomMemo.getTablisTypeCol06());
         this.pegTabNom.setTablisTypeCol07(this.pegTabNomMemo.getTablisTypeCol07());
         this.pegTabNom.setTablisTypeCol08(this.pegTabNomMemo.getTablisTypeCol08());
         this.pegTabNom.setTablisTypeCol09(this.pegTabNomMemo.getTablisTypeCol09());
         this.pegTabNom.setTablisTypeCol10(this.pegTabNomMemo.getTablisTypeCol10());
         this.pegTabNom.setTablisTypeCol11(this.pegTabNomMemo.getTablisTypeCol11());
         this.pegTabNom.setTablisTypeCol12(this.pegTabNomMemo.getTablisTypeCol12());
         this.pegTabNom.setTablisTypeCol13(this.pegTabNomMemo.getTablisTypeCol13());
         this.pegTabNom.setTablisTypeCol14(this.pegTabNomMemo.getTablisTypeCol14());
         this.pegTabNom.setTablisTypeCol15(this.pegTabNomMemo.getTablisTypeCol15());
         this.pegTabNom.setTablisTypeCol16(this.pegTabNomMemo.getTablisTypeCol16());
         this.pegTabNom.setTablisTypeCol17(this.pegTabNomMemo.getTablisTypeCol17());
         this.pegTabNom.setTablisTypeCol18(this.pegTabNomMemo.getTablisTypeCol18());
         this.pegTabNom.setTablisTypeCol19(this.pegTabNomMemo.getTablisTypeCol19());
         this.pegTabNom.setTablisTypeCol20(this.pegTabNomMemo.getTablisTypeCol20());
         this.pegTabNom.setTablisZone(this.pegTabNomMemo.getTablisZone());
         this.showmodalPanelDuppiquerTableaux = true;
      }

   }

   public void fermerDuppliquerTableaux() {
      this.showmodalPanelDuppiquerTableaux = false;
   }

   public void validerDuppliquerTableaux() throws HibernateException, NamingException {
      if (this.pegTabNomMemo != null) {
         Session var1 = this.utilInitHibernate.getSysteme();
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.pegTabNom = this.pegTabNomDao.savePegtabNom(this.pegTabNom, this.pegTabNom.getTablisZone(), var1);
            new ArrayList();
            new ArrayList();
            List var4 = this.pegTabElementDao.chargerMesTabElement(this.pegTabNomMemo.getTablis_id(), var1);
            if (var4.size() != 0) {
               PegTabFormule var5 = null;
               PegTabElement var6 = null;

               for(int var7 = 0; var7 < var4.size(); ++var7) {
                  this.pegTabElement = (PegTabElement)var4.get(var7);
                  List var3 = this.pegTabFormuleDao.chargerMesTabFormuleElement(this.pegTabElement, var1);
                  var6 = new PegTabElement();
                  var6.setPegTabNom(this.pegTabNom);
                  var6.setTabeleInactif(this.pegTabElement.isTabeleInactif());
                  var6.setTabeleLibFR(this.pegTabElement.getTabeleLibFR());
                  var6.setTabeleLibSP(this.pegTabElement.getTabeleLibSP());
                  var6.setTabeleLibUK(this.pegTabElement.getTabeleLibUK());
                  var6.setTabeleMode(this.pegTabElement.getTabeleMode());
                  var6.setTabeleNum(this.pegTabElement.getTabeleNum());
                  var6.setTabeleReference(this.pegTabElement.getTabeleReference());
                  var6.setTabeleType(this.pegTabElement.getTabeleType());
                  var6.setTabeleTypeCol01(this.pegTabElement.getTabeleTypeCol01());
                  var6.setTabeleTypeCol02(this.pegTabElement.getTabeleTypeCol02());
                  var6.setTabeleTypeCol03(this.pegTabElement.getTabeleTypeCol03());
                  var6.setTabeleTypeCol04(this.pegTabElement.getTabeleTypeCol04());
                  var6.setTabeleTypeCol05(this.pegTabElement.getTabeleTypeCol05());
                  var6.setTabeleTypeCol06(this.pegTabElement.getTabeleTypeCol06());
                  var6.setTabeleTypeCol07(this.pegTabElement.getTabeleTypeCol07());
                  var6.setTabeleTypeCol08(this.pegTabElement.getTabeleTypeCol08());
                  var6.setTabeleTypeCol09(this.pegTabElement.getTabeleTypeCol09());
                  var6.setTabeleTypeCol10(this.pegTabElement.getTabeleTypeCol10());
                  var6.setTabeleTypeCol11(this.pegTabElement.getTabeleTypeCol11());
                  var6.setTabeleTypeCol12(this.pegTabElement.getTabeleTypeCol12());
                  var6.setTabeleTypeCol13(this.pegTabElement.getTabeleTypeCol13());
                  var6.setTabeleTypeCol14(this.pegTabElement.getTabeleTypeCol14());
                  var6.setTabeleTypeCol15(this.pegTabElement.getTabeleTypeCol15());
                  var6.setTabeleTypeCol16(this.pegTabElement.getTabeleTypeCol16());
                  var6.setTabeleTypeCol17(this.pegTabElement.getTabeleTypeCol17());
                  var6.setTabeleTypeCol18(this.pegTabElement.getTabeleTypeCol18());
                  var6.setTabeleTypeCol19(this.pegTabElement.getTabeleTypeCol19());
                  var6.setTabeleTypeCol20(this.pegTabElement.getTabeleTypeCol20());
                  var6.setTabeleZone(this.pegTabElement.getTabeleZone());
                  var6 = this.pegTabElementDao.savePegtabElement(var6, this.pegTabNom, var1);
                  if (var3.size() != 0) {
                     for(int var8 = 0; var8 < var3.size(); ++var8) {
                        this.pegTabFormule = (PegTabFormule)var3.get(var8);
                        var5 = new PegTabFormule();
                        var5.setPegTabElement(var6);
                        var5.setTabforCol(this.pegTabFormule.getTabforCol());
                        var5.setTabforFormule(this.pegTabFormule.getTabforFormule());
                        var5.setTabforInactif(this.pegTabFormule.isTabforInactif());
                        var5.setTabforPeriode(this.pegTabFormule.getTabforPeriode());
                        var5.setTabforSolde(this.pegTabFormule.getTabforSolde());
                        var5.setTabforZone(this.pegTabFormule.getTabforZone());
                        this.pegTabFormuleDao.insert(var5, var1);
                     }
                  }
               }
            }

            var2.commit();
         } catch (HibernateException var12) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var12;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.showmodalPanelDuppiquerTableaux = false;
   }

   public void chargerLesNomsCol() {
      if (this.pegTabNom != null) {
         int var1 = this.pegTabNom.getTablisNbCol();
         this.lesNomsCol.clear();
         if (var1 >= 1) {
            this.etatFinancier = new EtatFinancier();
            this.etatFinancier.setPeriodeCol(this.pegTabNom.getTablisAnn01());
            this.etatFinancier.setLibPeriodeCol(this.etatFinancier.calculLibPeriode(this.pegTabNom.getTablisAnn01()));
            this.etatFinancier.setNomCol(this.getPegTabNom().getTablisNom01());
            this.etatFinancier.setNumCol("N° 1");
            this.etatFinancier.setTypeCol(this.getPegTabNom().getTablisTypeCol01());
            this.lesNomsCol.add(this.etatFinancier);
         }

         if (var1 >= 2) {
            this.etatFinancier = new EtatFinancier();
            this.etatFinancier.setPeriodeCol(this.pegTabNom.getTablisAnn02());
            this.etatFinancier.setLibPeriodeCol(this.etatFinancier.calculLibPeriode(this.pegTabNom.getTablisAnn02()));
            this.etatFinancier.setNomCol(this.getPegTabNom().getTablisNom02());
            this.etatFinancier.setNumCol("N° 2");
            this.etatFinancier.setTypeCol(this.getPegTabNom().getTablisTypeCol02());
            this.lesNomsCol.add(this.etatFinancier);
         }

         if (var1 >= 3) {
            this.etatFinancier = new EtatFinancier();
            this.etatFinancier.setPeriodeCol(this.pegTabNom.getTablisAnn03());
            this.etatFinancier.setLibPeriodeCol(this.etatFinancier.calculLibPeriode(this.pegTabNom.getTablisAnn03()));
            this.etatFinancier.setNomCol(this.getPegTabNom().getTablisNom03());
            this.etatFinancier.setNumCol("N° 3");
            this.etatFinancier.setTypeCol(this.getPegTabNom().getTablisTypeCol03());
            this.lesNomsCol.add(this.etatFinancier);
         }

         if (var1 >= 4) {
            this.etatFinancier = new EtatFinancier();
            this.etatFinancier.setPeriodeCol(this.pegTabNom.getTablisAnn04());
            this.etatFinancier.setLibPeriodeCol(this.etatFinancier.calculLibPeriode(this.pegTabNom.getTablisAnn04()));
            this.etatFinancier.setNomCol(this.getPegTabNom().getTablisNom04());
            this.etatFinancier.setNumCol("N° 4");
            this.etatFinancier.setTypeCol(this.getPegTabNom().getTablisTypeCol04());
            this.lesNomsCol.add(this.etatFinancier);
         }

         if (var1 >= 5) {
            this.etatFinancier = new EtatFinancier();
            this.etatFinancier.setPeriodeCol(this.pegTabNom.getTablisAnn05());
            this.etatFinancier.setLibPeriodeCol(this.etatFinancier.calculLibPeriode(this.pegTabNom.getTablisAnn05()));
            this.etatFinancier.setNomCol(this.getPegTabNom().getTablisNom05());
            this.etatFinancier.setNumCol("N° 5");
            this.etatFinancier.setTypeCol(this.getPegTabNom().getTablisTypeCol05());
            this.lesNomsCol.add(this.etatFinancier);
         }

         if (var1 >= 6) {
            this.etatFinancier = new EtatFinancier();
            this.etatFinancier.setPeriodeCol(this.pegTabNom.getTablisAnn06());
            this.etatFinancier.setLibPeriodeCol(this.etatFinancier.calculLibPeriode(this.pegTabNom.getTablisAnn06()));
            this.etatFinancier.setNomCol(this.getPegTabNom().getTablisNom06());
            this.etatFinancier.setNumCol("N° 6");
            this.etatFinancier.setTypeCol(this.getPegTabNom().getTablisTypeCol06());
            this.lesNomsCol.add(this.etatFinancier);
         }

         if (var1 >= 7) {
            this.etatFinancier = new EtatFinancier();
            this.etatFinancier.setPeriodeCol(this.pegTabNom.getTablisAnn07());
            this.etatFinancier.setLibPeriodeCol(this.etatFinancier.calculLibPeriode(this.pegTabNom.getTablisAnn07()));
            this.etatFinancier.setNomCol(this.getPegTabNom().getTablisNom07());
            this.etatFinancier.setNumCol("N° 7");
            this.etatFinancier.setTypeCol(this.getPegTabNom().getTablisTypeCol07());
            this.lesNomsCol.add(this.etatFinancier);
         }

         if (var1 >= 8) {
            this.etatFinancier = new EtatFinancier();
            this.etatFinancier.setPeriodeCol(this.pegTabNom.getTablisAnn08());
            this.etatFinancier.setLibPeriodeCol(this.etatFinancier.calculLibPeriode(this.pegTabNom.getTablisAnn08()));
            this.etatFinancier.setNomCol(this.getPegTabNom().getTablisNom08());
            this.etatFinancier.setNumCol("N° 8");
            this.etatFinancier.setTypeCol(this.getPegTabNom().getTablisTypeCol08());
            this.lesNomsCol.add(this.etatFinancier);
         }

         if (var1 >= 9) {
            this.etatFinancier = new EtatFinancier();
            this.etatFinancier.setPeriodeCol(this.pegTabNom.getTablisAnn09());
            this.etatFinancier.setLibPeriodeCol(this.etatFinancier.calculLibPeriode(this.pegTabNom.getTablisAnn09()));
            this.etatFinancier.setNomCol(this.getPegTabNom().getTablisNom09());
            this.etatFinancier.setNumCol("N° 9");
            this.etatFinancier.setTypeCol(this.getPegTabNom().getTablisTypeCol09());
            this.lesNomsCol.add(this.etatFinancier);
         }

         if (var1 >= 10) {
            this.etatFinancier = new EtatFinancier();
            this.etatFinancier.setPeriodeCol(this.pegTabNom.getTablisAnn10());
            this.etatFinancier.setLibPeriodeCol(this.etatFinancier.calculLibPeriode(this.pegTabNom.getTablisAnn10()));
            this.etatFinancier.setNomCol(this.getPegTabNom().getTablisNom10());
            this.etatFinancier.setNumCol("N° 10");
            this.etatFinancier.setTypeCol(this.getPegTabNom().getTablisTypeCol10());
            this.lesNomsCol.add(this.etatFinancier);
         }

         if (var1 >= 11) {
            this.etatFinancier = new EtatFinancier();
            this.etatFinancier.setPeriodeCol(this.pegTabNom.getTablisAnn11());
            this.etatFinancier.setLibPeriodeCol(this.etatFinancier.calculLibPeriode(this.pegTabNom.getTablisAnn11()));
            this.etatFinancier.setNomCol(this.getPegTabNom().getTablisNom11());
            this.etatFinancier.setNumCol("N° 11");
            this.etatFinancier.setTypeCol(this.getPegTabNom().getTablisTypeCol11());
            this.lesNomsCol.add(this.etatFinancier);
         }

         if (var1 >= 12) {
            this.etatFinancier = new EtatFinancier();
            this.etatFinancier.setPeriodeCol(this.pegTabNom.getTablisAnn12());
            this.etatFinancier.setLibPeriodeCol(this.etatFinancier.calculLibPeriode(this.pegTabNom.getTablisAnn12()));
            this.etatFinancier.setNomCol(this.getPegTabNom().getTablisNom12());
            this.etatFinancier.setNumCol("N° 12");
            this.etatFinancier.setTypeCol(this.getPegTabNom().getTablisTypeCol12());
            this.lesNomsCol.add(this.etatFinancier);
         }

         if (var1 >= 13) {
            this.etatFinancier = new EtatFinancier();
            this.etatFinancier.setPeriodeCol(this.pegTabNom.getTablisAnn13());
            this.etatFinancier.setLibPeriodeCol(this.etatFinancier.calculLibPeriode(this.pegTabNom.getTablisAnn13()));
            this.etatFinancier.setNomCol(this.getPegTabNom().getTablisNom13());
            this.etatFinancier.setNumCol("N° 13");
            this.etatFinancier.setTypeCol(this.getPegTabNom().getTablisTypeCol13());
            this.lesNomsCol.add(this.etatFinancier);
         }

         if (var1 >= 14) {
            this.etatFinancier = new EtatFinancier();
            this.etatFinancier.setPeriodeCol(this.pegTabNom.getTablisAnn14());
            this.etatFinancier.setLibPeriodeCol(this.etatFinancier.calculLibPeriode(this.pegTabNom.getTablisAnn14()));
            this.etatFinancier.setNomCol(this.getPegTabNom().getTablisNom14());
            this.etatFinancier.setNumCol("N° 14");
            this.etatFinancier.setTypeCol(this.getPegTabNom().getTablisTypeCol14());
            this.lesNomsCol.add(this.etatFinancier);
         }

         if (var1 >= 15) {
            this.etatFinancier = new EtatFinancier();
            this.etatFinancier.setPeriodeCol(this.pegTabNom.getTablisAnn15());
            this.etatFinancier.setLibPeriodeCol(this.etatFinancier.calculLibPeriode(this.pegTabNom.getTablisAnn15()));
            this.etatFinancier.setNomCol(this.getPegTabNom().getTablisNom15());
            this.etatFinancier.setNumCol("N° 15");
            this.etatFinancier.setTypeCol(this.getPegTabNom().getTablisTypeCol15());
            this.lesNomsCol.add(this.etatFinancier);
         }

         if (var1 >= 16) {
            this.etatFinancier = new EtatFinancier();
            this.etatFinancier.setPeriodeCol(this.pegTabNom.getTablisAnn16());
            this.etatFinancier.setLibPeriodeCol(this.etatFinancier.calculLibPeriode(this.pegTabNom.getTablisAnn16()));
            this.etatFinancier.setNomCol(this.getPegTabNom().getTablisNom16());
            this.etatFinancier.setNumCol("N° 16");
            this.etatFinancier.setTypeCol(this.getPegTabNom().getTablisTypeCol16());
            this.lesNomsCol.add(this.etatFinancier);
         }

         if (var1 >= 17) {
            this.etatFinancier = new EtatFinancier();
            this.etatFinancier.setPeriodeCol(this.pegTabNom.getTablisAnn17());
            this.etatFinancier.setLibPeriodeCol(this.etatFinancier.calculLibPeriode(this.pegTabNom.getTablisAnn17()));
            this.etatFinancier.setNomCol(this.getPegTabNom().getTablisNom17());
            this.etatFinancier.setNumCol("N° 17");
            this.etatFinancier.setTypeCol(this.getPegTabNom().getTablisTypeCol17());
            this.lesNomsCol.add(this.etatFinancier);
         }

         if (var1 >= 18) {
            this.etatFinancier = new EtatFinancier();
            this.etatFinancier.setPeriodeCol(this.pegTabNom.getTablisAnn18());
            this.etatFinancier.setLibPeriodeCol(this.etatFinancier.calculLibPeriode(this.pegTabNom.getTablisAnn18()));
            this.etatFinancier.setNomCol(this.getPegTabNom().getTablisNom18());
            this.etatFinancier.setNumCol("N° 18");
            this.etatFinancier.setTypeCol(this.getPegTabNom().getTablisTypeCol18());
            this.lesNomsCol.add(this.etatFinancier);
         }

         if (var1 >= 19) {
            this.etatFinancier = new EtatFinancier();
            this.etatFinancier.setPeriodeCol(this.pegTabNom.getTablisAnn19());
            this.etatFinancier.setLibPeriodeCol(this.etatFinancier.calculLibPeriode(this.pegTabNom.getTablisAnn19()));
            this.etatFinancier.setNomCol(this.getPegTabNom().getTablisNom19());
            this.etatFinancier.setNumCol("N° 19");
            this.etatFinancier.setTypeCol(this.getPegTabNom().getTablisTypeCol19());
            this.lesNomsCol.add(this.etatFinancier);
         }

         if (var1 >= 20) {
            this.etatFinancier = new EtatFinancier();
            this.etatFinancier.setPeriodeCol(this.pegTabNom.getTablisAnn20());
            this.etatFinancier.setLibPeriodeCol(this.etatFinancier.calculLibPeriode(this.pegTabNom.getTablisAnn20()));
            this.etatFinancier.setNomCol(this.getPegTabNom().getTablisNom20());
            this.etatFinancier.setNumCol("N° 20");
            this.etatFinancier.setTypeCol(this.getPegTabNom().getTablisTypeCol20());
            this.lesNomsCol.add(this.etatFinancier);
         }

         this.dataModelLesNomsCol.setWrappedData(this.lesNomsCol);
      }

   }

   public void selectionColonne() throws HibernateException, NamingException {
      if (this.dataModelLesNomsCol.isRowAvailable()) {
         this.etatFinancier = (EtatFinancier)this.dataModelLesNomsCol.getRowData();
         this.numLigneColonne = this.dataModelLesNomsCol.getRowIndex();
         this.chargerMesTabFormule();
      }

   }

   public void modifierColonne() {
      if (this.etatFinancier != null) {
         this.showmodalPanelColonne = true;
      }

   }

   public void annulerColonne() {
      this.showmodalPanelColonne = false;
   }

   public void validerColonne() throws HibernateException, NamingException {
      if (this.pegTabNom.getTablis_id() != 0L) {
         if (this.numLigneColonne == 0) {
            this.pegTabNom.setTablisNom01(this.etatFinancier.getNomCol());
            this.pegTabNom.setTablisAnn01(this.etatFinancier.getPeriodeCol());
            this.pegTabNom.setTablisTypeCol01(this.etatFinancier.getTypeCol());
         } else if (this.numLigneColonne == 1) {
            this.pegTabNom.setTablisNom02(this.etatFinancier.getNomCol());
            this.pegTabNom.setTablisAnn02(this.etatFinancier.getPeriodeCol());
            this.pegTabNom.setTablisTypeCol02(this.etatFinancier.getTypeCol());
         } else if (this.numLigneColonne == 2) {
            this.pegTabNom.setTablisNom03(this.etatFinancier.getNomCol());
            this.pegTabNom.setTablisAnn03(this.etatFinancier.getPeriodeCol());
            this.pegTabNom.setTablisTypeCol03(this.etatFinancier.getTypeCol());
         } else if (this.numLigneColonne == 3) {
            this.pegTabNom.setTablisNom04(this.etatFinancier.getNomCol());
            this.pegTabNom.setTablisAnn04(this.etatFinancier.getPeriodeCol());
            this.pegTabNom.setTablisTypeCol04(this.etatFinancier.getTypeCol());
         } else if (this.numLigneColonne == 4) {
            this.pegTabNom.setTablisNom05(this.etatFinancier.getNomCol());
            this.pegTabNom.setTablisAnn05(this.etatFinancier.getPeriodeCol());
            this.pegTabNom.setTablisTypeCol05(this.etatFinancier.getTypeCol());
         } else if (this.numLigneColonne == 5) {
            this.pegTabNom.setTablisNom06(this.etatFinancier.getNomCol());
            this.pegTabNom.setTablisAnn06(this.etatFinancier.getPeriodeCol());
            this.pegTabNom.setTablisTypeCol06(this.etatFinancier.getTypeCol());
         } else if (this.numLigneColonne == 6) {
            this.pegTabNom.setTablisNom07(this.etatFinancier.getNomCol());
            this.pegTabNom.setTablisAnn07(this.etatFinancier.getPeriodeCol());
            this.pegTabNom.setTablisTypeCol07(this.etatFinancier.getTypeCol());
         } else if (this.numLigneColonne == 7) {
            this.pegTabNom.setTablisNom08(this.etatFinancier.getNomCol());
            this.pegTabNom.setTablisAnn08(this.etatFinancier.getPeriodeCol());
            this.pegTabNom.setTablisTypeCol08(this.etatFinancier.getTypeCol());
         } else if (this.numLigneColonne == 9) {
            this.pegTabNom.setTablisNom09(this.etatFinancier.getNomCol());
            this.pegTabNom.setTablisAnn09(this.etatFinancier.getPeriodeCol());
            this.pegTabNom.setTablisTypeCol09(this.etatFinancier.getTypeCol());
         } else if (this.numLigneColonne == 9) {
            this.pegTabNom.setTablisNom10(this.etatFinancier.getNomCol());
            this.pegTabNom.setTablisAnn10(this.etatFinancier.getPeriodeCol());
            this.pegTabNom.setTablisTypeCol10(this.etatFinancier.getTypeCol());
         } else if (this.numLigneColonne == 10) {
            this.pegTabNom.setTablisNom11(this.etatFinancier.getNomCol());
            this.pegTabNom.setTablisAnn11(this.etatFinancier.getPeriodeCol());
            this.pegTabNom.setTablisTypeCol11(this.etatFinancier.getTypeCol());
         } else if (this.numLigneColonne == 11) {
            this.pegTabNom.setTablisNom12(this.etatFinancier.getNomCol());
            this.pegTabNom.setTablisAnn12(this.etatFinancier.getPeriodeCol());
            this.pegTabNom.setTablisTypeCol12(this.etatFinancier.getTypeCol());
         } else if (this.numLigneColonne == 12) {
            this.pegTabNom.setTablisNom13(this.etatFinancier.getNomCol());
            this.pegTabNom.setTablisAnn13(this.etatFinancier.getPeriodeCol());
            this.pegTabNom.setTablisTypeCol13(this.etatFinancier.getTypeCol());
         } else if (this.numLigneColonne == 13) {
            this.pegTabNom.setTablisNom14(this.etatFinancier.getNomCol());
            this.pegTabNom.setTablisAnn14(this.etatFinancier.getPeriodeCol());
            this.pegTabNom.setTablisTypeCol14(this.etatFinancier.getTypeCol());
         } else if (this.numLigneColonne == 14) {
            this.pegTabNom.setTablisNom15(this.etatFinancier.getNomCol());
            this.pegTabNom.setTablisAnn15(this.etatFinancier.getPeriodeCol());
            this.pegTabNom.setTablisTypeCol15(this.etatFinancier.getTypeCol());
         } else if (this.numLigneColonne == 15) {
            this.pegTabNom.setTablisNom16(this.etatFinancier.getNomCol());
            this.pegTabNom.setTablisAnn16(this.etatFinancier.getPeriodeCol());
            this.pegTabNom.setTablisTypeCol16(this.etatFinancier.getTypeCol());
         } else if (this.numLigneColonne == 16) {
            this.pegTabNom.setTablisNom17(this.etatFinancier.getNomCol());
            this.pegTabNom.setTablisAnn17(this.etatFinancier.getPeriodeCol());
            this.pegTabNom.setTablisTypeCol17(this.etatFinancier.getTypeCol());
         } else if (this.numLigneColonne == 17) {
            this.pegTabNom.setTablisNom18(this.etatFinancier.getNomCol());
            this.pegTabNom.setTablisAnn18(this.etatFinancier.getPeriodeCol());
            this.pegTabNom.setTablisTypeCol18(this.etatFinancier.getTypeCol());
         } else if (this.numLigneColonne == 18) {
            this.pegTabNom.setTablisNom19(this.etatFinancier.getNomCol());
            this.pegTabNom.setTablisAnn19(this.etatFinancier.getPeriodeCol());
            this.pegTabNom.setTablisTypeCol19(this.etatFinancier.getTypeCol());
         } else if (this.numLigneColonne == 19) {
            this.pegTabNom.setTablisNom20(this.etatFinancier.getNomCol());
            this.pegTabNom.setTablisAnn20(this.etatFinancier.getPeriodeCol());
            this.pegTabNom.setTablisTypeCol20(this.etatFinancier.getTypeCol());
         }

         this.pegTabNom = this.pegTabNomDao.updatePegtabNom(this.pegTabNom);
      }

      this.showmodalPanelColonne = false;
   }

   public void chargerMesTabElement() throws HibernateException, NamingException {
      this.lesPegTabElements.clear();
      this.lesPegTabElements = this.pegTabElementDao.chargerMesTabElement(this.pegTabNom.getTablis_id());
      this.datamodeltabElement.setWrappedData(this.lesPegTabElements);
   }

   public void selectionElement() throws HibernateException, NamingException {
      if (this.datamodeltabElement.isRowAvailable()) {
         this.pegTabElement = (PegTabElement)this.datamodeltabElement.getRowData();
         this.chargerMesTabFormule();
      }

   }

   public void ajouterElement() {
      this.pegTabElement = new PegTabElement();
      this.pegTabElement.setTabeleType(3);
      this.showmodalPanelElement = true;
   }

   public void modifierElement() {
      if (this.pegTabElement != null) {
         this.showmodalPanelElement = true;
      }

   }

   public void supprimerElement() throws HibernateException, NamingException {
      if (this.pegTabElement != null) {
         this.lesPegTabElements.remove(this.pegTabElement);
         this.datamodeltabElement.setWrappedData(this.lesPegTabElements);
         this.pegTabElementDao.deletePegtabElement(this.pegTabElement);
      }

   }

   public void annulerElement() {
      this.showmodalPanelElement = false;
   }

   public void validerElement() throws HibernateException, NamingException {
      if (this.pegTabElement.getTabele_id() == 0L) {
         int var1 = this.lesPegTabElements.size() + 1;
         this.pegTabElement.setTabeleNum(var1);
         this.pegTabElement.setPegTabNom(this.pegTabNom);
         this.pegTabElement = this.pegTabElementDao.savePegtabElement(this.pegTabElement, this.pegTabNom);
         this.lesPegTabElements.add(this.pegTabElement);
         this.datamodeltabElement.setWrappedData(this.lesPegTabElements);
      } else {
         this.pegTabElement = this.pegTabElementDao.updatePegtabElement(this.pegTabElement);
      }

      this.showmodalPanelElement = false;
   }

   public void chargerMesTabFormule() throws HibernateException, NamingException {
      this.lesPegTabFormules.clear();
      if (this.etatFinancier != null && this.pegTabNom != null && this.pegTabElement != null) {
         this.lesPegTabFormules = this.pegTabFormuleDao.chargerMesTabFormule(this.pegTabElement.getTabele_id(), this.numLigneColonne + 1);
      }

      this.datamodeltabFormule.setWrappedData(this.lesPegTabFormules);
   }

   public void selectionFormule() {
      if (this.datamodeltabFormule.isRowAvailable()) {
         this.pegTabFormule = (PegTabFormule)this.datamodeltabFormule.getRowData();
      }

   }

   public void ajouterFormule() {
      if (this.pegTabElement != null) {
         this.pegTabFormule = new PegTabFormule();
         if (this.etatFinancier.getPeriodeCol() != 0 && this.etatFinancier.getPeriodeCol() != 20 && this.etatFinancier.getPeriodeCol() != 40) {
            this.pegTabFormule.setTabforPeriode(0);
         } else {
            this.pegTabFormule.setTabforPeriode(this.etatFinancier.getPeriodeCol());
         }

         this.showmodalPanelFormule = true;
      }

   }

   public void modifierFormule() {
      if (this.pegTabFormule != null) {
         this.showmodalPanelFormule = true;
      }

   }

   public void supprimerFormule() throws HibernateException, NamingException {
      if (this.pegTabFormule != null) {
         this.lesPegTabFormules.remove(this.pegTabFormule);
         this.datamodeltabFormule.setWrappedData(this.lesPegTabFormules);
         this.pegTabFormuleDao.delete(this.pegTabFormule);
      }

   }

   public void annulerFormule() {
      this.showmodalPanelFormule = false;
   }

   public void validerFormule() throws HibernateException, NamingException {
      if (this.pegTabFormule.getTabforSolde() >= 6 && this.pegTabFormule.getTabforSolde() <= 9) {
         this.pegTabFormule.setTabforFormule("");
      } else if (!this.pegTabFormule.getTabforFormule().contains("COMPTE(")) {
         this.pegTabFormule.setTabforSolde(0);
      }

      if (this.pegTabFormule.getTabfor_id() == 0L) {
         this.pegTabFormule.setPegTabElement(this.pegTabElement);
         this.pegTabFormule.setTabforZone(this.zone.getCode());
         this.pegTabFormule.setTabforCol(this.numLigneColonne + 1);
         this.pegTabFormule = this.pegTabFormuleDao.insert(this.pegTabFormule);
         this.lesPegTabFormules.add(this.pegTabFormule);
         this.datamodeltabFormule.setWrappedData(this.lesPegTabFormules);
      } else {
         this.pegTabFormule = this.pegTabFormuleDao.modif(this.pegTabFormule);
      }

      if (this.pegTabElement != null) {
         if (this.numLigneColonne == 0) {
            if (this.pegTabFormule.getTabforSolde() != 6 && this.pegTabFormule.getTabforSolde() != 7 && this.pegTabFormule.getTabforSolde() != 8 && this.pegTabFormule.getTabforSolde() != 9) {
               this.pegTabElement.setTabeleTypeCol01(0);
            } else {
               this.pegTabElement.setTabeleTypeCol01(this.pegTabFormule.getTabforSolde());
            }
         } else if (this.numLigneColonne == 1) {
            if (this.pegTabFormule.getTabforSolde() != 6 && this.pegTabFormule.getTabforSolde() != 7 && this.pegTabFormule.getTabforSolde() != 8 && this.pegTabFormule.getTabforSolde() != 9) {
               this.pegTabElement.setTabeleTypeCol02(0);
            } else {
               this.pegTabElement.setTabeleTypeCol02(this.pegTabFormule.getTabforSolde());
            }
         } else if (this.numLigneColonne == 2) {
            if (this.pegTabFormule.getTabforSolde() != 6 && this.pegTabFormule.getTabforSolde() != 7 && this.pegTabFormule.getTabforSolde() != 8 && this.pegTabFormule.getTabforSolde() != 9) {
               this.pegTabElement.setTabeleTypeCol03(0);
            } else {
               this.pegTabElement.setTabeleTypeCol03(this.pegTabFormule.getTabforSolde());
            }
         } else if (this.numLigneColonne == 3) {
            if (this.pegTabFormule.getTabforSolde() != 6 && this.pegTabFormule.getTabforSolde() != 7 && this.pegTabFormule.getTabforSolde() != 8 && this.pegTabFormule.getTabforSolde() != 9) {
               this.pegTabElement.setTabeleTypeCol04(0);
            } else {
               this.pegTabElement.setTabeleTypeCol04(this.pegTabFormule.getTabforSolde());
            }
         } else if (this.numLigneColonne == 4) {
            if (this.pegTabFormule.getTabforSolde() != 6 && this.pegTabFormule.getTabforSolde() != 7 && this.pegTabFormule.getTabforSolde() != 8 && this.pegTabFormule.getTabforSolde() != 9) {
               this.pegTabElement.setTabeleTypeCol05(0);
            } else {
               this.pegTabElement.setTabeleTypeCol05(this.pegTabFormule.getTabforSolde());
            }
         } else if (this.numLigneColonne == 5) {
            if (this.pegTabFormule.getTabforSolde() != 6 && this.pegTabFormule.getTabforSolde() != 7 && this.pegTabFormule.getTabforSolde() != 8 && this.pegTabFormule.getTabforSolde() != 9) {
               this.pegTabElement.setTabeleTypeCol06(0);
            } else {
               this.pegTabElement.setTabeleTypeCol06(this.pegTabFormule.getTabforSolde());
            }
         } else if (this.numLigneColonne == 6) {
            if (this.pegTabFormule.getTabforSolde() != 6 && this.pegTabFormule.getTabforSolde() != 7 && this.pegTabFormule.getTabforSolde() != 8 && this.pegTabFormule.getTabforSolde() != 9) {
               this.pegTabElement.setTabeleTypeCol07(0);
            } else {
               this.pegTabElement.setTabeleTypeCol07(this.pegTabFormule.getTabforSolde());
            }
         } else if (this.numLigneColonne == 7) {
            if (this.pegTabFormule.getTabforSolde() != 6 && this.pegTabFormule.getTabforSolde() != 7 && this.pegTabFormule.getTabforSolde() != 8 && this.pegTabFormule.getTabforSolde() != 9) {
               this.pegTabElement.setTabeleTypeCol08(0);
            } else {
               this.pegTabElement.setTabeleTypeCol08(this.pegTabFormule.getTabforSolde());
            }
         } else if (this.numLigneColonne == 8) {
            if (this.pegTabFormule.getTabforSolde() != 6 && this.pegTabFormule.getTabforSolde() != 7 && this.pegTabFormule.getTabforSolde() != 8 && this.pegTabFormule.getTabforSolde() != 9) {
               this.pegTabElement.setTabeleTypeCol09(0);
            } else {
               this.pegTabElement.setTabeleTypeCol09(this.pegTabFormule.getTabforSolde());
            }
         } else if (this.numLigneColonne == 9) {
            if (this.pegTabFormule.getTabforSolde() != 6 && this.pegTabFormule.getTabforSolde() != 7 && this.pegTabFormule.getTabforSolde() != 8 && this.pegTabFormule.getTabforSolde() != 9) {
               this.pegTabElement.setTabeleTypeCol10(0);
            } else {
               this.pegTabElement.setTabeleTypeCol10(this.pegTabFormule.getTabforSolde());
            }
         } else if (this.numLigneColonne == 10) {
            if (this.pegTabFormule.getTabforSolde() != 6 && this.pegTabFormule.getTabforSolde() != 7 && this.pegTabFormule.getTabforSolde() != 8 && this.pegTabFormule.getTabforSolde() != 9) {
               this.pegTabElement.setTabeleTypeCol11(0);
            } else {
               this.pegTabElement.setTabeleTypeCol11(this.pegTabFormule.getTabforSolde());
            }
         } else if (this.numLigneColonne == 11) {
            if (this.pegTabFormule.getTabforSolde() != 6 && this.pegTabFormule.getTabforSolde() != 7 && this.pegTabFormule.getTabforSolde() != 8 && this.pegTabFormule.getTabforSolde() != 9) {
               this.pegTabElement.setTabeleTypeCol12(0);
            } else {
               this.pegTabElement.setTabeleTypeCol12(this.pegTabFormule.getTabforSolde());
            }
         } else if (this.numLigneColonne == 12) {
            if (this.pegTabFormule.getTabforSolde() != 6 && this.pegTabFormule.getTabforSolde() != 7 && this.pegTabFormule.getTabforSolde() != 8 && this.pegTabFormule.getTabforSolde() != 9) {
               this.pegTabElement.setTabeleTypeCol13(0);
            } else {
               this.pegTabElement.setTabeleTypeCol13(this.pegTabFormule.getTabforSolde());
            }
         } else if (this.numLigneColonne == 13) {
            if (this.pegTabFormule.getTabforSolde() != 6 && this.pegTabFormule.getTabforSolde() != 7 && this.pegTabFormule.getTabforSolde() != 8 && this.pegTabFormule.getTabforSolde() != 9) {
               this.pegTabElement.setTabeleTypeCol14(0);
            } else {
               this.pegTabElement.setTabeleTypeCol14(this.pegTabFormule.getTabforSolde());
            }
         } else if (this.numLigneColonne == 14) {
            if (this.pegTabFormule.getTabforSolde() != 6 && this.pegTabFormule.getTabforSolde() != 7 && this.pegTabFormule.getTabforSolde() != 8 && this.pegTabFormule.getTabforSolde() != 9) {
               this.pegTabElement.setTabeleTypeCol15(0);
            } else {
               this.pegTabElement.setTabeleTypeCol15(this.pegTabFormule.getTabforSolde());
            }
         } else if (this.numLigneColonne == 15) {
            if (this.pegTabFormule.getTabforSolde() != 6 && this.pegTabFormule.getTabforSolde() != 7 && this.pegTabFormule.getTabforSolde() != 8 && this.pegTabFormule.getTabforSolde() != 9) {
               this.pegTabElement.setTabeleTypeCol16(0);
            } else {
               this.pegTabElement.setTabeleTypeCol16(this.pegTabFormule.getTabforSolde());
            }
         } else if (this.numLigneColonne == 16) {
            if (this.pegTabFormule.getTabforSolde() != 6 && this.pegTabFormule.getTabforSolde() != 7 && this.pegTabFormule.getTabforSolde() != 8 && this.pegTabFormule.getTabforSolde() != 9) {
               this.pegTabElement.setTabeleTypeCol17(0);
            } else {
               this.pegTabElement.setTabeleTypeCol17(this.pegTabFormule.getTabforSolde());
            }
         } else if (this.numLigneColonne == 17) {
            if (this.pegTabFormule.getTabforSolde() != 6 && this.pegTabFormule.getTabforSolde() != 7 && this.pegTabFormule.getTabforSolde() != 8 && this.pegTabFormule.getTabforSolde() != 9) {
               this.pegTabElement.setTabeleTypeCol18(0);
            } else {
               this.pegTabElement.setTabeleTypeCol18(this.pegTabFormule.getTabforSolde());
            }
         } else if (this.numLigneColonne == 18) {
            if (this.pegTabFormule.getTabforSolde() != 6 && this.pegTabFormule.getTabforSolde() != 7 && this.pegTabFormule.getTabforSolde() != 8 && this.pegTabFormule.getTabforSolde() != 9) {
               this.pegTabElement.setTabeleTypeCol19(0);
            } else {
               this.pegTabElement.setTabeleTypeCol19(this.pegTabFormule.getTabforSolde());
            }
         } else if (this.numLigneColonne == 19) {
            if (this.pegTabFormule.getTabforSolde() != 6 && this.pegTabFormule.getTabforSolde() != 7 && this.pegTabFormule.getTabforSolde() != 8 && this.pegTabFormule.getTabforSolde() != 9) {
               this.pegTabElement.setTabeleTypeCol20(0);
            } else {
               this.pegTabElement.setTabeleTypeCol20(this.pegTabFormule.getTabforSolde());
            }
         }

         this.pegTabElement = this.pegTabElementDao.updatePegtabElement(this.pegTabElement);
      }

      this.showmodalPanelFormule = false;
   }

   public void AffecterSupp() {
      this.pegTabFormule.setTabforFormule(">");
   }

   public void AffecterSuppOrEq() {
      this.pegTabFormule.setTabforFormule(">=");
   }

   public void AffecterInf() {
      this.pegTabFormule.setTabforFormule("<");
   }

   public void AffecterEq() {
      this.pegTabFormule.setTabforFormule("=");
   }

   public void AffecterInfOrEq() {
      this.pegTabFormule.setTabforFormule("<=");
   }

   public void AffecterDiff() {
      this.pegTabFormule.setTabforFormule("<>");
   }

   public void AffecterPlus() {
      this.pegTabFormule.setTabforFormule("+");
   }

   public void AffecterMoins() {
      this.pegTabFormule.setTabforFormule("-");
   }

   public void AffecterMulti() {
      this.pegTabFormule.setTabforFormule("*");
   }

   public String AffecterDiv() {
      this.pegTabFormule.setTabforFormule("/");
      return "";
   }

   public void AffecterCel() {
      this.pegTabFormule.setTabforFormule("CEL()");
   }

   public void AffecterSomv() {
      this.pegTabFormule.setTabforFormule("SOMV()");
   }

   public void AffecterSomh() {
      this.pegTabFormule.setTabforFormule("SOMH()");
   }

   public void AffecterDifh() {
      this.pegTabFormule.setTabforFormule("DIFH()");
   }

   public void AffecterVal() {
      this.pegTabFormule.setTabforFormule("VAL()");
   }

   public void AffecterColP() {
      this.pegTabFormule.setTabforFormule("COL>0");
   }

   public void AffecterColN() {
      this.pegTabFormule.setTabforFormule("COL<0");
   }

   public void AffecterTTAB() {
      this.pegTabFormule.setTabforFormule("TTAB()");
   }

   public void AffecterVAR() {
      this.pegTabFormule.setTabforFormule("VAR()");
   }

   public void AffecterSTOT() {
      this.pegTabFormule.setTabforFormule("STOT()");
   }

   public void AffecterSit() {
      this.pegTabFormule.setTabforFormule("SIT()");
   }

   public void AffecterDep() {
      this.pegTabFormule.setTabforFormule("DEP()");
   }

   public void AffecterServ() {
      this.pegTabFormule.setTabforFormule("SER()");
   }

   public void AffecterReg() {
      this.pegTabFormule.setTabforFormule("REG()");
   }

   public void AffecterSect() {
      this.pegTabFormule.setTabforFormule("SECT()");
   }

   public void AffecterPdv() {
      this.pegTabFormule.setTabforFormule("PDV()");
   }

   public void AffecterAna1() {
      this.pegTabFormule.setTabforFormule("ANA1()");
   }

   public void AffecterAna2() {
      this.pegTabFormule.setTabforFormule("ANA2()");
   }

   public void AffecterAna3() {
      this.pegTabFormule.setTabforFormule("ANA3()");
   }

   public void AffecterAna4() {
      this.pegTabFormule.setTabforFormule("ANA4()");
   }

   public void AffecterSi() {
      this.pegTabFormule.setTabforFormule("SI");
   }

   public void AffecterNon() {
      this.pegTabFormule.setTabforFormule("SINON");
   }

   public void AffecterFin() {
      this.pegTabFormule.setTabforFormule("FIN");
   }

   public void AffecterCpt() {
      this.pegTabFormule.setTabforFormule("COMPTE()");
   }

   public void AffecterAmach() {
      this.pegTabFormule.setTabforFormule("AMACH()");
   }

   public void AffecterAmdot() {
      this.pegTabFormule.setTabforFormule("AMDOT()");
   }

   public void AffecterAmant() {
      this.pegTabFormule.setTabforFormule("AMANT()");
   }

   public void AffecterAmres() {
      this.pegTabFormule.setTabforFormule("AMRES()");
   }

   public void AffecterAmces() {
      this.pegTabFormule.setTabforFormule("AMCES()");
   }

   public void AffecterBal() {
      this.pegTabFormule.setTabforFormule("BAL()");
   }

   public void AffecterAr() {
      this.pegTabFormule.setTabforFormule("ARR()");
   }

   public void AffecterAb() {
      this.pegTabFormule.setTabforFormule("ABS()");
   }

   public void AffecterInv() {
      this.pegTabFormule.setTabforFormule("INV()");
   }

   public void AffecterInt() {
      this.pegTabFormule.setTabforFormule("INT()");
   }

   public void AffecterMod() {
      this.pegTabFormule.setTabforFormule("MOD()");
   }

   public void AffecterEcom() {
      this.pegTabFormule.setTabforFormule("&&");
   }

   public void AffecterBo() {
      this.pegTabFormule.setTabforFormule("||");
   }

   public void AffecterSalNb() {
      this.pegTabFormule.setTabforFormule("SAL_NBR()");
   }

   public void AffecterSalVl() {
      this.pegTabFormule.setTabforFormule("SAL_VAL()");
   }

   public void ordonnnerAscendant() throws HibernateException, NamingException {
      if (this.datamodeltabElement.isRowAvailable()) {
         this.pegTabElement = (PegTabElement)this.datamodeltabElement.getRowData();
         int var1 = this.pegTabElement.getTabeleNum();
         long var2 = this.pegTabElement.getTabele_id();
         new PegTabElement();
         int var5 = this.clauleNumlLigne() - 1;
         PegTabElement var4 = (PegTabElement)this.lesPegTabElements.get(var5);
         long var6 = var4.getTabele_id();
         int var8 = var4.getTabeleNum();
         this.pegTabElementDao.ordonnnerAscendant(var1, var8, var2, var6);
         this.chargerMesTabElement();
      }

   }

   public void ordonnnerDescendant() throws HibernateException, NamingException {
      if (this.datamodeltabElement.isRowAvailable()) {
         this.pegTabElement = (PegTabElement)this.datamodeltabElement.getRowData();
         int var1 = this.pegTabElement.getTabeleNum();
         long var2 = this.pegTabElement.getTabele_id();
         new PegTabElement();
         int var5 = this.clauleNumlLigne() + 1;
         PegTabElement var4 = (PegTabElement)this.lesPegTabElements.get(var5);
         long var6 = var4.getTabele_id();
         int var8 = var4.getTabeleNum();
         this.pegTabElementDao.ordonnnerDescendant(var1, var8, var2, var6);
         this.chargerMesTabElement();
      }

   }

   public int clauleNumlLigne() {
      int var1 = 0;
      if (this.lesPegTabElements.size() != 0) {
         for(int var2 = 0; var2 < this.lesPegTabElements.size(); ++var2) {
            if (this.pegTabElement.getTabele_id() == ((PegTabElement)this.lesPegTabElements.get(var2)).getTabele_id()) {
               var1 = var2;
               break;
            }
         }
      }

      return var1;
   }

   public void imprimer() throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.utilPrint.setRapport("Etat_Financier_sys");
      this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator);
      this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "sous_rapport" + File.separator);
      this.utilPrint.setEntete("Structure des Etats financiers");
      this.utilPrint.setNomMapping("systeme");
      this.utilPrint.setFiltre(this.filtre);
      this.utilPrint.setRequete(this.requete);
      this.utilPrint.setFormat(this.formatImpression);
      this.utilPrint.setTiersSelectionne((Tiers)null);
      ArrayList var1 = new ArrayList();
      JRBeanCollectionDataSource var2 = new JRBeanCollectionDataSource(var1);
      this.utilPrint.setjRBeanCollectionDataSource(var2);
      this.utilPrint.imprimeRapport();
   }

   public DataModel getDatamodelMesZones() {
      return this.datamodelMesZones;
   }

   public void setDatamodelMesZones(DataModel var1) {
      this.datamodelMesZones = var1;
   }

   public DataModel getDatamodeltabNom() {
      return this.datamodeltabNom;
   }

   public void setDatamodeltabNom(DataModel var1) {
      this.datamodeltabNom = var1;
   }

   public List getLesPegTabNom() {
      return this.lesPegTabNom;
   }

   public void setLesPegTabNom(List var1) {
      this.lesPegTabNom = var1;
   }

   public PegTabElement getPegTabElement() {
      return this.pegTabElement;
   }

   public void setPegTabElement(PegTabElement var1) {
      this.pegTabElement = var1;
   }

   public List getLesPegTabElements() {
      return this.lesPegTabElements;
   }

   public void setLesPegTabElements(List var1) {
      this.lesPegTabElements = var1;
   }

   public DataModel getDatamodeltabElement() {
      return this.datamodeltabElement;
   }

   public void setDatamodeltabElement(DataModel var1) {
      this.datamodeltabElement = var1;
   }

   public PegTabFormule getPegTabFormule() {
      return this.pegTabFormule;
   }

   public void setPegTabFormule(PegTabFormule var1) {
      this.pegTabFormule = var1;
   }

   public List getLesPegTabFormules() {
      return this.lesPegTabFormules;
   }

   public void setLesPegTabFormules(List var1) {
      this.lesPegTabFormules = var1;
   }

   public PegTabNom getPegTabNom() {
      return this.pegTabNom;
   }

   public void setPegTabNom(PegTabNom var1) {
      this.pegTabNom = var1;
   }

   public List getLesNomsCol() {
      return this.lesNomsCol;
   }

   public void setLesNomsCol(List var1) {
      this.lesNomsCol = var1;
   }

   public DataModel getDataModelLesNomsCol() {
      return this.dataModelLesNomsCol;
   }

   public void setDataModelLesNomsCol(DataModel var1) {
      this.dataModelLesNomsCol = var1;
   }

   public DataModel getDatamodeltabFormule() {
      return this.datamodeltabFormule;
   }

   public void setDatamodeltabFormule(DataModel var1) {
      this.datamodeltabFormule = var1;
   }

   public String getFormatImpression() {
      return this.formatImpression;
   }

   public void setFormatImpression(String var1) {
      this.formatImpression = var1;
   }

   public String getFiltre() {
      return this.filtre;
   }

   public void setFiltre(String var1) {
      this.filtre = var1;
   }

   public List getMeszone() {
      return this.meszone;
   }

   public void setMeszone(List var1) {
      this.meszone = var1;
   }

   public String getRequete() {
      return this.requete;
   }

   public void setRequete(String var1) {
      this.requete = var1;
   }

   public ObjetCompte getZone() {
      return this.zone;
   }

   public void setZone(ObjetCompte var1) {
      this.zone = var1;
   }

   public boolean isShowmodalPanelElement() {
      return this.showmodalPanelElement;
   }

   public void setShowmodalPanelElement(boolean var1) {
      this.showmodalPanelElement = var1;
   }

   public boolean isShowmodalPanelFormule() {
      return this.showmodalPanelFormule;
   }

   public void setShowmodalPanelFormule(boolean var1) {
      this.showmodalPanelFormule = var1;
   }

   public boolean isShowmodalPanelTableaux() {
      return this.showmodalPanelTableaux;
   }

   public void setShowmodalPanelTableaux(boolean var1) {
      this.showmodalPanelTableaux = var1;
   }

   public EtatFinancier getEtatFinancier() {
      return this.etatFinancier;
   }

   public void setEtatFinancier(EtatFinancier var1) {
      this.etatFinancier = var1;
   }

   public boolean isShowmodalPanelColonne() {
      return this.showmodalPanelColonne;
   }

   public void setShowmodalPanelColonne(boolean var1) {
      this.showmodalPanelColonne = var1;
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

   public UtilInitHibernate getUtilInitHibernate() {
      return this.utilInitHibernate;
   }

   public void setUtilInitHibernate(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public boolean isShowmodalPanelDuppiquerTableaux() {
      return this.showmodalPanelDuppiquerTableaux;
   }

   public void setShowmodalPanelDuppiquerTableaux(boolean var1) {
      this.showmodalPanelDuppiquerTableaux = var1;
   }

   public List getMesSzonesItems() {
      return this.mesSzonesItems;
   }

   public void setMesSzonesItems(List var1) {
      this.mesSzonesItems = var1;
   }
}
