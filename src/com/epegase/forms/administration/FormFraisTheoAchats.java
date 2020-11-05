package com.epegase.forms.administration;

import com.epegase.systeme.classe.FraisTheoAchats;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.ObjetTarif;
import com.epegase.systeme.dao.DeviseDao;
import com.epegase.systeme.dao.FraisTheoAchatsDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.LireLesoptionsAchats;
import com.epegase.systeme.xml.OptionAchats;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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

public class FormFraisTheoAchats implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private UserDao userDao;
   private List fraisEnteteList = new ArrayList();
   private List fraisLigneList = new ArrayList();
   private transient DataModel datamodelFraisEntete = new ListDataModel();
   private transient DataModel datamodelFraisLigne = new ListDataModel();
   private FraisTheoAchats fraisTheoAchats;
   private FraisTheoAchatsDao fraisTheoAchatsDao;
   private boolean showModalPanelFeuille = false;
   private boolean showModalPanelDetail = false;
   private boolean var_affiche_bouton = false;
   private String var_nom_feuille;
   private String var_mode;
   private int var_nature;
   private int var_type_feuille;
   private boolean var_mode_feuille = false;
   private boolean var_mode_detail = false;
   private boolean affichageTranche = false;
   private boolean showModalPanelTranche = false;
   private String formuleEnCours;
   private long var_id_fournisseur;
   private List listTiersItems = new ArrayList();
   private TiersDao tiersDao;
   private transient DataModel datamodelTranche = new ListDataModel();
   private boolean visibiliteBtonTranche = false;
   private ObjetTarif objetTarif;
   private List listeTranche = new ArrayList();
   private int etatTranche;
   private boolean showModalPanelCalculTranche = false;
   private List mesDevisesItems = new ArrayList();
   private OptionAchats optionAchats;
   private boolean frsPrp1 = false;
   private boolean frsPrp2 = false;
   private boolean frsPrp3 = false;
   private String format;
   private UtilPrint utilPrint;

   public void InstancesDaoUtilses() {
      this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.fraisTheoAchatsDao = new FraisTheoAchatsDao(this.baseLog, this.utilInitHibernate);
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerFeuille(Session var1) throws HibernateException, NamingException {
      this.fraisEnteteList = this.fraisTheoAchatsDao.chargerFraisEntete(var1);
      this.datamodelFraisEntete.setWrappedData(this.fraisEnteteList);
      this.var_id_fournisseur = 0L;
      this.listTiersItems = this.tiersDao.chargerLesTransitaireTransporteurByIdItems(var1);
      this.mesDevisesItems.clear();
      DeviseDao var2 = new DeviseDao(this.baseLog, this.utilInitHibernate);
      this.mesDevisesItems = var2.chargerLesDevisesUtiliseesItem(this.structureLog, var1);
      this.optionAchats = new OptionAchats();
      LireLesoptionsAchats var3 = new LireLesoptionsAchats();
      var3.setStrId(this.structureLog.getStrid());
      var3.lancer();
      this.optionAchats = var3.getOptionAchats();
      if (this.optionAchats.getFraisPrp1() != null && !this.optionAchats.getFraisPrp1().isEmpty()) {
         this.frsPrp1 = true;
      } else {
         this.frsPrp1 = false;
      }

      if (this.optionAchats.getFraisPrp2() != null && !this.optionAchats.getFraisPrp2().isEmpty()) {
         this.frsPrp2 = true;
      } else {
         this.frsPrp2 = false;
      }

      if (this.optionAchats.getFraisPrp3() != null && !this.optionAchats.getFraisPrp3().isEmpty()) {
         this.frsPrp3 = true;
      } else {
         this.frsPrp3 = false;
      }

   }

   public void selectionFeuille() throws HibernateException, NamingException {
      if (this.datamodelFraisEntete.isRowAvailable()) {
         this.fraisTheoAchats = (FraisTheoAchats)this.datamodelFraisEntete.getRowData();
         this.var_nom_feuille = this.fraisTheoAchats.getFstFeuille();
         this.var_type_feuille = this.fraisTheoAchats.getFstType();
         this.var_mode = this.fraisTheoAchats.getFstMode();
         this.var_nature = this.fraisTheoAchats.getFstNature();
         this.var_id_fournisseur = this.fraisTheoAchats.getFstIdTiers();
         this.fraisLigneList.clear();
         if (this.var_id_fournisseur != 0L) {
            this.fraisLigneList = this.fraisTheoAchatsDao.chargerFraisLignes(this.var_id_fournisseur, this.var_mode, this.var_nature, (Session)null);
         } else {
            this.fraisLigneList = this.fraisTheoAchatsDao.chargerFraisLignes(this.var_nom_feuille, this.var_mode, this.var_nature, (Session)null);
         }

         this.datamodelFraisLigne.setWrappedData(this.fraisLigneList);
         this.var_affiche_bouton = true;
      }

   }

   public void ajouterFeuille() {
      this.fraisTheoAchats = new FraisTheoAchats();
      this.var_nom_feuille = "";
      this.var_type_feuille = 0;
      this.var_mode_feuille = false;
      this.fraisLigneList.clear();
      this.formuleEnCours = "";
      this.datamodelFraisLigne.setWrappedData(this.fraisLigneList);
      this.showModalPanelFeuille = true;
   }

   public void duppliquerFeuille() {
      if (this.fraisTheoAchats != null) {
         this.var_mode = this.fraisTheoAchats.getFstMode() + "(copie)";
         if (this.fraisLigneList.size() != 0) {
            ArrayList var1 = new ArrayList();
            this.fraisTheoAchats = new FraisTheoAchats();

            int var2;
            for(var2 = 0; var2 < this.fraisLigneList.size(); ++var2) {
               this.fraisTheoAchats = (FraisTheoAchats)this.fraisLigneList.get(var2);
               FraisTheoAchats var3 = new FraisTheoAchats();
               var3.setFstCategorie(this.fraisTheoAchats.getFstCategorie());
               var3.setFstCode(this.fraisTheoAchats.getFstCode());
               var3.setFstColType(this.fraisTheoAchats.getFstColType());
               var3.setFstDateCreat(new Date());
               var3.setFstDateModif((Date)null);
               var3.setFstDecimalA(this.fraisTheoAchats.getFstDecimalA());
               var3.setFstDecimalB(this.fraisTheoAchats.getFstDecimalB());
               var3.setFstDecimalC(this.fraisTheoAchats.getFstDecimalC());
               var3.setFstDecimalD(this.fraisTheoAchats.getFstDecimalD());
               var3.setFstDecimalE(this.fraisTheoAchats.getFstDecimalE());
               var3.setFstDecimalF(this.fraisTheoAchats.getFstDecimalF());
               var3.setFstDevise(this.fraisTheoAchats.getFstDevise());
               var3.setFstFeuille(this.fraisTheoAchats.getFstFeuille());
               var3.setFstFormuleA(this.fraisTheoAchats.getFstFormuleA());
               var3.setFstFormuleB(this.fraisTheoAchats.getFstFormuleB());
               var3.setFstFormuleC(this.fraisTheoAchats.getFstFormuleC());
               var3.setFstFormuleD(this.fraisTheoAchats.getFstFormuleD());
               var3.setFstFormuleE(this.fraisTheoAchats.getFstFormuleE());
               var3.setFstFormuleF(this.fraisTheoAchats.getFstFormuleF());
               var3.setFstIdTiers(this.fraisTheoAchats.getFstIdTiers());
               var3.setFstInactif(this.fraisTheoAchats.getFstInactif());
               var3.setFstMode(this.fraisTheoAchats.getFstMode());
               var3.setFstNature(this.fraisTheoAchats.getFstNature());
               var3.setFstNomFr(this.fraisTheoAchats.getFstNomFr());
               var3.setFstNomSp(this.fraisTheoAchats.getFstNomSp());
               var3.setFstNomUk(this.fraisTheoAchats.getFstNomUk());
               var3.setFstOrdre(this.fraisTheoAchats.getFstOrdre());
               var3.setFstReponse(this.fraisTheoAchats.getFstReponse());
               var3.setFstRubrique(this.fraisTheoAchats.getFstRubrique());
               var3.setFstTranche(this.fraisTheoAchats.getFstTranche());
               var3.setFstTrancheA(this.fraisTheoAchats.getFstTrancheA());
               var3.setFstTrancheB(this.fraisTheoAchats.getFstTrancheB());
               var3.setFstTrancheC(this.fraisTheoAchats.getFstTrancheC());
               var3.setFstTrancheD(this.fraisTheoAchats.getFstTrancheD());
               var3.setFstTrancheE(this.fraisTheoAchats.getFstTrancheE());
               var3.setFstTrancheF(this.fraisTheoAchats.getFstTrancheF());
               var3.setFstUserCreat(this.usersLog.getUsrid());
               var3.setFstUserModif(0L);
               var1.add(var3);
            }

            if (var1.size() != 0) {
               this.fraisLigneList.clear();

               for(var2 = 0; var2 < var1.size(); ++var2) {
                  this.fraisLigneList.add(var1.get(var2));
               }
            }
         }

         this.var_mode_feuille = true;
         this.showModalPanelFeuille = true;
      }

   }

   public void modifierFeuille() {
      if (this.fraisTheoAchats != null) {
         this.var_mode_feuille = true;
         this.showModalPanelFeuille = true;
      }

   }

   public void supprimerFeuille() throws HibernateException, NamingException {
      if (this.fraisTheoAchats != null && this.fraisLigneList.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FraisTheoAchats");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            new FraisTheoAchats();

            for(int var4 = 0; var4 < this.fraisLigneList.size(); ++var4) {
               FraisTheoAchats var3 = (FraisTheoAchats)this.fraisLigneList.get(var4);
               this.fraisTheoAchatsDao.delete(var3, var1);
            }

            var2.commit();
         } catch (HibernateException var8) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var8;
         } finally {
            this.utilInitHibernate.closeSession();
            this.fraisEnteteList.remove(this.fraisTheoAchats);
            this.datamodelFraisEntete.setWrappedData(this.fraisEnteteList);
            this.fraisLigneList.clear();
            this.datamodelFraisLigne.setWrappedData(this.fraisLigneList);
            this.var_affiche_bouton = false;
         }
      }

   }

   public void annulerFeuille() {
      this.var_affiche_bouton = false;
      this.showModalPanelFeuille = false;
   }

   public void saveFeuille() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FraisTheoAchats");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.fraisLigneList.size() != 0) {
            this.fraisTheoAchats = new FraisTheoAchats();

            int var3;
            for(var3 = 0; var3 < this.fraisLigneList.size(); ++var3) {
               this.fraisTheoAchats = (FraisTheoAchats)this.fraisLigneList.get(var3);
               if (this.fraisTheoAchats.getFstId() != 0L) {
                  this.fraisTheoAchatsDao.delete(this.fraisTheoAchats, var1);
               }
            }

            var3 = 0;

            while(true) {
               if (var3 >= this.fraisLigneList.size()) {
                  if (!this.var_mode_feuille) {
                     this.fraisEnteteList.add(this.fraisTheoAchats);
                  }

                  this.datamodelFraisEntete.setWrappedData(this.fraisEnteteList);
                  break;
               }

               this.fraisTheoAchats = new FraisTheoAchats();
               this.fraisTheoAchats = (FraisTheoAchats)this.fraisLigneList.get(var3);
               this.fraisTheoAchats.setFstUserCreat(this.usersLog.getUsrid());
               this.fraisTheoAchats.setFstDateCreat(new Date());
               this.fraisTheoAchats.setFstType(this.var_type_feuille);
               this.fraisTheoAchats.setFstMode(this.var_mode);
               this.fraisTheoAchats.setFstNature(this.var_nature);
               if (this.var_id_fournisseur == 0L) {
                  this.fraisTheoAchats.setFstIdTiers(0L);
                  this.fraisTheoAchats.setFstFeuille(this.var_nom_feuille);
               } else {
                  this.fraisTheoAchats.setFstIdTiers(this.var_id_fournisseur);
                  String var4 = "";

                  for(int var5 = 0; var5 < this.listTiersItems.size(); ++var5) {
                     long var6 = Long.parseLong(((SelectItem)this.listTiersItems.get(var5)).getValue().toString());
                     if (var6 == this.var_id_fournisseur) {
                        var4 = ((SelectItem)this.listTiersItems.get(var5)).getLabel().toUpperCase();
                        break;
                     }
                  }

                  this.fraisTheoAchats.setFstFeuille(var4);
               }

               this.fraisTheoAchats.setFstOrdre(var3);
               this.fraisTheoAchats = this.fraisTheoAchatsDao.insert(this.fraisTheoAchats, var1);
               ++var3;
            }
         }

         var2.commit();
      } catch (HibernateException var11) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var11;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.fraisEnteteList = this.fraisTheoAchatsDao.chargerFraisEntete((Session)null);
      this.datamodelFraisEntete.setWrappedData(this.fraisEnteteList);
      this.showModalPanelFeuille = false;
      this.var_affiche_bouton = false;
   }

   public void colonneA() {
      this.formuleEnCours = "A";
      this.controleTranche();
   }

   public void colonneB() {
      this.formuleEnCours = "B";
      this.controleTranche();
   }

   public void colonneC() {
      this.formuleEnCours = "C";
      this.controleTranche();
   }

   public void colonneD() {
      this.formuleEnCours = "D";
      this.controleTranche();
   }

   public void colonneE() {
      this.formuleEnCours = "E";
      this.controleTranche();
   }

   public void colonneF() {
      this.formuleEnCours = "F";
      this.controleTranche();
   }

   public void controleTranche() {
      if (this.fraisTheoAchats.getFstFormuleA() != null && !this.fraisTheoAchats.getFstFormuleA().isEmpty() && this.fraisTheoAchats.getFstFormuleA().startsWith("TRANCHE(")) {
         this.affichageTranche = true;
      } else if (this.fraisTheoAchats.getFstFormuleB() != null && !this.fraisTheoAchats.getFstFormuleB().isEmpty() && this.fraisTheoAchats.getFstFormuleB().startsWith("TRANCHE(")) {
         this.affichageTranche = true;
      } else if (this.fraisTheoAchats.getFstFormuleC() != null && !this.fraisTheoAchats.getFstFormuleC().isEmpty() && this.fraisTheoAchats.getFstFormuleC().startsWith("TRANCHE(")) {
         this.affichageTranche = true;
      } else if (this.fraisTheoAchats.getFstFormuleD() != null && !this.fraisTheoAchats.getFstFormuleD().isEmpty() && this.fraisTheoAchats.getFstFormuleD().startsWith("TRANCHE(")) {
         this.affichageTranche = true;
      } else if (this.fraisTheoAchats.getFstFormuleE() != null && !this.fraisTheoAchats.getFstFormuleE().isEmpty() && this.fraisTheoAchats.getFstFormuleE().startsWith("TRANCHE(")) {
         this.affichageTranche = true;
      } else if (this.fraisTheoAchats.getFstFormuleF() != null && !this.fraisTheoAchats.getFstFormuleF().isEmpty() && this.fraisTheoAchats.getFstFormuleF().startsWith("TRANCHE(")) {
         this.affichageTranche = true;
      } else {
         this.affichageTranche = false;
      }

   }

   public void ouvrirTranche() {
      if (this.fraisTheoAchats != null && this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         this.listeTranche.clear();
         if (this.formuleEnCours.equals("A")) {
            this.analyseTranche(this.fraisTheoAchats.getFstTrancheA());
         } else if (this.formuleEnCours.equals("B")) {
            this.analyseTranche(this.fraisTheoAchats.getFstTrancheB());
         } else if (this.formuleEnCours.equals("C")) {
            this.analyseTranche(this.fraisTheoAchats.getFstTrancheC());
         } else if (this.formuleEnCours.equals("D")) {
            this.analyseTranche(this.fraisTheoAchats.getFstTrancheD());
         } else if (this.formuleEnCours.equals("E")) {
            this.analyseTranche(this.fraisTheoAchats.getFstTrancheE());
         } else if (this.formuleEnCours.equals("F")) {
            this.analyseTranche(this.fraisTheoAchats.getFstTrancheF());
         }

         this.datamodelTranche.setWrappedData(this.listeTranche);
         this.showModalPanelTranche = true;
      }

   }

   public void analyseTranche(String var1) {
      if (var1 != null && !var1.isEmpty()) {
         String[] var2;
         if (!var1.contains("#")) {
            var2 = var1.split(":");
            this.objetTarif = new ObjetTarif();
            float var3 = Float.parseFloat(var2[0]);
            this.objetTarif.setQteDebut(var3);
            float var4 = Float.parseFloat(var2[1]);
            this.objetTarif.setQteFin(var4);
            double var5 = Double.parseDouble(var2[2]);
            this.objetTarif.setPrix(var5);
            this.listeTranche.add(this.objetTarif);
         } else {
            var2 = var1.split("#");
            int var10 = var2.length;

            for(int var11 = 0; var11 < var10; ++var11) {
               String[] var12 = var2[var11].split(":");
               this.objetTarif = new ObjetTarif();
               float var6 = Float.parseFloat(var12[0]);
               this.objetTarif.setQteDebut(var6);
               float var7 = Float.parseFloat(var12[1]);
               this.objetTarif.setQteFin(var7);
               double var8 = Double.parseDouble(var12[2]);
               this.objetTarif.setPrix(var8);
               this.listeTranche.add(this.objetTarif);
            }
         }
      }

   }

   public void fermerTranche() {
      this.showModalPanelTranche = false;
   }

   public void validerTranche() {
      if (this.fraisTheoAchats != null) {
         if (this.listeTranche.size() != 0) {
            String var1 = "";

            for(int var2 = 0; var2 < this.listeTranche.size(); ++var2) {
               this.objetTarif = (ObjetTarif)this.listeTranche.get(var2);
               if (var1 != null && !var1.isEmpty()) {
                  var1 = var1 + "#" + this.objetTarif.getQteDebut() + ":" + this.objetTarif.getQteFin() + ":" + this.objetTarif.getPrix();
               } else {
                  var1 = this.objetTarif.getQteDebut() + ":" + this.objetTarif.getQteFin() + ":" + this.objetTarif.getPrix();
               }
            }

            if (this.formuleEnCours.equals("A")) {
               this.fraisTheoAchats.setFstTrancheA(var1);
            } else if (this.formuleEnCours.equals("B")) {
               this.fraisTheoAchats.setFstTrancheB(var1);
            } else if (this.formuleEnCours.equals("C")) {
               this.fraisTheoAchats.setFstTrancheC(var1);
            } else if (this.formuleEnCours.equals("D")) {
               this.fraisTheoAchats.setFstTrancheD(var1);
            } else if (this.formuleEnCours.equals("E")) {
               this.fraisTheoAchats.setFstTrancheD(var1);
            } else if (this.formuleEnCours.equals("F")) {
               this.fraisTheoAchats.setFstTrancheD(var1);
            }
         } else if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstTrancheA("");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstTrancheB("");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstTrancheC("");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstTrancheD("");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstTrancheD("");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstTrancheD("");
         }
      }

      this.showModalPanelTranche = false;
   }

   public void fourmuleVal() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            if (this.fraisTheoAchats.getFstFormuleA() != null && !this.fraisTheoAchats.getFstFormuleA().isEmpty()) {
               this.fraisTheoAchats.setFstFormuleA(this.fraisTheoAchats.getFstFormuleA() + "VAL(0)");
            } else {
               this.fraisTheoAchats.setFstFormuleA("VAL(0)");
            }
         } else if (this.formuleEnCours.equals("B")) {
            if (this.fraisTheoAchats.getFstFormuleB() != null && !this.fraisTheoAchats.getFstFormuleB().isEmpty()) {
               this.fraisTheoAchats.setFstFormuleB(this.fraisTheoAchats.getFstFormuleB() + "VAL(0)");
            } else {
               this.fraisTheoAchats.setFstFormuleB("VAL(0)");
            }
         } else if (this.formuleEnCours.equals("C")) {
            if (this.fraisTheoAchats.getFstFormuleC() != null && !this.fraisTheoAchats.getFstFormuleC().isEmpty()) {
               this.fraisTheoAchats.setFstFormuleC(this.fraisTheoAchats.getFstFormuleC() + "VAL(0)");
            } else {
               this.fraisTheoAchats.setFstFormuleC("VAL(0)");
            }
         } else if (this.formuleEnCours.equals("D")) {
            if (this.fraisTheoAchats.getFstFormuleD() != null && !this.fraisTheoAchats.getFstFormuleD().isEmpty()) {
               this.fraisTheoAchats.setFstFormuleD(this.fraisTheoAchats.getFstFormuleD() + "VAL(0)");
            } else {
               this.fraisTheoAchats.setFstFormuleD("VAL(0)");
            }
         } else if (this.formuleEnCours.equals("E")) {
            if (this.fraisTheoAchats.getFstFormuleE() != null && !this.fraisTheoAchats.getFstFormuleE().isEmpty()) {
               this.fraisTheoAchats.setFstFormuleE(this.fraisTheoAchats.getFstFormuleE() + "VAL(0)");
            } else {
               this.fraisTheoAchats.setFstFormuleE("VAL(0)");
            }
         } else if (this.formuleEnCours.equals("F")) {
            if (this.fraisTheoAchats.getFstFormuleF() != null && !this.fraisTheoAchats.getFstFormuleF().isEmpty()) {
               this.fraisTheoAchats.setFstFormuleF(this.fraisTheoAchats.getFstFormuleF() + "VAL(0)");
            } else {
               this.fraisTheoAchats.setFstFormuleF("VAL(0)");
            }
         }
      }

   }

   public void fourmuleVar() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            if (this.fraisTheoAchats.getFstFormuleA() != null && !this.fraisTheoAchats.getFstFormuleA().isEmpty()) {
               this.fraisTheoAchats.setFstFormuleA(this.fraisTheoAchats.getFstFormuleA() + "VAR()");
            } else {
               this.fraisTheoAchats.setFstFormuleA("VAR()");
            }
         } else if (this.formuleEnCours.equals("B")) {
            if (this.fraisTheoAchats.getFstFormuleB() != null && !this.fraisTheoAchats.getFstFormuleB().isEmpty()) {
               this.fraisTheoAchats.setFstFormuleB(this.fraisTheoAchats.getFstFormuleB() + "VAR()");
            } else {
               this.fraisTheoAchats.setFstFormuleB("VAR()");
            }
         } else if (this.formuleEnCours.equals("C")) {
            if (this.fraisTheoAchats.getFstFormuleC() != null && !this.fraisTheoAchats.getFstFormuleC().isEmpty()) {
               this.fraisTheoAchats.setFstFormuleC(this.fraisTheoAchats.getFstFormuleC() + "VAR()");
            } else {
               this.fraisTheoAchats.setFstFormuleC("VAR()");
            }
         } else if (this.formuleEnCours.equals("D")) {
            if (this.fraisTheoAchats.getFstFormuleD() != null && !this.fraisTheoAchats.getFstFormuleD().isEmpty()) {
               this.fraisTheoAchats.setFstFormuleD(this.fraisTheoAchats.getFstFormuleD() + "VAR()");
            } else {
               this.fraisTheoAchats.setFstFormuleD("VAR()");
            }
         } else if (this.formuleEnCours.equals("E")) {
            if (this.fraisTheoAchats.getFstFormuleE() != null && !this.fraisTheoAchats.getFstFormuleE().isEmpty()) {
               this.fraisTheoAchats.setFstFormuleE(this.fraisTheoAchats.getFstFormuleE() + "VAR()");
            } else {
               this.fraisTheoAchats.setFstFormuleE("VAR()");
            }
         } else if (this.formuleEnCours.equals("F")) {
            if (this.fraisTheoAchats.getFstFormuleF() != null && !this.fraisTheoAchats.getFstFormuleF().isEmpty()) {
               this.fraisTheoAchats.setFstFormuleF(this.fraisTheoAchats.getFstFormuleF() + "VAR()");
            } else {
               this.fraisTheoAchats.setFstFormuleF("VAR()");
            }
         }
      }

   }

   public void fourmuleRub() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            if (this.fraisTheoAchats.getFstFormuleA() != null && !this.fraisTheoAchats.getFstFormuleA().isEmpty()) {
               this.fraisTheoAchats.setFstFormuleA(this.fraisTheoAchats.getFstFormuleA() + "RUB()");
            } else {
               this.fraisTheoAchats.setFstFormuleA("RUB()");
            }
         } else if (this.formuleEnCours.equals("B")) {
            if (this.fraisTheoAchats.getFstFormuleB() != null && !this.fraisTheoAchats.getFstFormuleB().isEmpty()) {
               this.fraisTheoAchats.setFstFormuleB(this.fraisTheoAchats.getFstFormuleB() + "RUB()");
            } else {
               this.fraisTheoAchats.setFstFormuleB("RUB()");
            }
         } else if (this.formuleEnCours.equals("C")) {
            if (this.fraisTheoAchats.getFstFormuleC() != null && !this.fraisTheoAchats.getFstFormuleC().isEmpty()) {
               this.fraisTheoAchats.setFstFormuleC(this.fraisTheoAchats.getFstFormuleC() + "RUB()");
            } else {
               this.fraisTheoAchats.setFstFormuleC("RUB()");
            }
         } else if (this.formuleEnCours.equals("D")) {
            if (this.fraisTheoAchats.getFstFormuleD() != null && !this.fraisTheoAchats.getFstFormuleD().isEmpty()) {
               this.fraisTheoAchats.setFstFormuleD(this.fraisTheoAchats.getFstFormuleD() + "RUB()");
            } else {
               this.fraisTheoAchats.setFstFormuleD("RUB()");
            }
         } else if (this.formuleEnCours.equals("E")) {
            if (this.fraisTheoAchats.getFstFormuleE() != null && !this.fraisTheoAchats.getFstFormuleE().isEmpty()) {
               this.fraisTheoAchats.setFstFormuleE(this.fraisTheoAchats.getFstFormuleE() + "RUB()");
            } else {
               this.fraisTheoAchats.setFstFormuleE("RUB()");
            }
         } else if (this.formuleEnCours.equals("F")) {
            if (this.fraisTheoAchats.getFstFormuleF() != null && !this.fraisTheoAchats.getFstFormuleF().isEmpty()) {
               this.fraisTheoAchats.setFstFormuleF(this.fraisTheoAchats.getFstFormuleF() + "RUB()");
            } else {
               this.fraisTheoAchats.setFstFormuleF("RUB()");
            }
         }
      }

   }

   public void fourmuleTot() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            if (this.fraisTheoAchats.getFstFormuleA() != null && !this.fraisTheoAchats.getFstFormuleA().isEmpty()) {
               this.fraisTheoAchats.setFstFormuleA(this.fraisTheoAchats.getFstFormuleA() + "TOT()");
            } else {
               this.fraisTheoAchats.setFstFormuleA("TOT()");
            }
         } else if (this.formuleEnCours.equals("B")) {
            if (this.fraisTheoAchats.getFstFormuleB() != null && !this.fraisTheoAchats.getFstFormuleB().isEmpty()) {
               this.fraisTheoAchats.setFstFormuleB(this.fraisTheoAchats.getFstFormuleB() + "TOT()");
            } else {
               this.fraisTheoAchats.setFstFormuleB("TOT()");
            }
         } else if (this.formuleEnCours.equals("C")) {
            if (this.fraisTheoAchats.getFstFormuleC() != null && !this.fraisTheoAchats.getFstFormuleC().isEmpty()) {
               this.fraisTheoAchats.setFstFormuleC(this.fraisTheoAchats.getFstFormuleC() + "TOT()");
            } else {
               this.fraisTheoAchats.setFstFormuleC("TOT()");
            }
         } else if (this.formuleEnCours.equals("D")) {
            if (this.fraisTheoAchats.getFstFormuleD() != null && !this.fraisTheoAchats.getFstFormuleD().isEmpty()) {
               this.fraisTheoAchats.setFstFormuleD(this.fraisTheoAchats.getFstFormuleD() + "TOT()");
            } else {
               this.fraisTheoAchats.setFstFormuleD("TOT()");
            }
         } else if (this.formuleEnCours.equals("E")) {
            if (this.fraisTheoAchats.getFstFormuleE() != null && !this.fraisTheoAchats.getFstFormuleE().isEmpty()) {
               this.fraisTheoAchats.setFstFormuleE(this.fraisTheoAchats.getFstFormuleE() + "TOT()");
            } else {
               this.fraisTheoAchats.setFstFormuleE("TOT()");
            }
         } else if (this.formuleEnCours.equals("F")) {
            if (this.fraisTheoAchats.getFstFormuleF() != null && !this.fraisTheoAchats.getFstFormuleF().isEmpty()) {
               this.fraisTheoAchats.setFstFormuleF(this.fraisTheoAchats.getFstFormuleF() + "TOT()");
            } else {
               this.fraisTheoAchats.setFstFormuleF("TOT()");
            }
         }
      }

   }

   public void fourmuleTranche() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("TRANCHE()");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("TRANCHE()");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("TRANCHE()");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("TRANCHE()");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("TRANCHE()");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("TRANCHE()");
         }

         this.controleTranche();
      }

   }

   public void fourmuleSi() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            if (this.fraisTheoAchats.getFstFormuleA() != null && !this.fraisTheoAchats.getFstFormuleA().isEmpty()) {
               this.fraisTheoAchats.setFstFormuleA(this.fraisTheoAchats.getFstFormuleA() + "SI()");
            } else {
               this.fraisTheoAchats.setFstFormuleA("SI()");
            }
         } else if (this.formuleEnCours.equals("B")) {
            if (this.fraisTheoAchats.getFstFormuleB() != null && !this.fraisTheoAchats.getFstFormuleB().isEmpty()) {
               this.fraisTheoAchats.setFstFormuleB(this.fraisTheoAchats.getFstFormuleB() + "SI()");
            } else {
               this.fraisTheoAchats.setFstFormuleB("SI()");
            }
         } else if (this.formuleEnCours.equals("C")) {
            if (this.fraisTheoAchats.getFstFormuleC() != null && !this.fraisTheoAchats.getFstFormuleC().isEmpty()) {
               this.fraisTheoAchats.setFstFormuleC(this.fraisTheoAchats.getFstFormuleC() + "SI()");
            } else {
               this.fraisTheoAchats.setFstFormuleC("SI()");
            }
         } else if (this.formuleEnCours.equals("D")) {
            if (this.fraisTheoAchats.getFstFormuleD() != null && !this.fraisTheoAchats.getFstFormuleD().isEmpty()) {
               this.fraisTheoAchats.setFstFormuleD(this.fraisTheoAchats.getFstFormuleD() + "SI()");
            } else {
               this.fraisTheoAchats.setFstFormuleD("SI()");
            }
         } else if (this.formuleEnCours.equals("E")) {
            if (this.fraisTheoAchats.getFstFormuleE() != null && !this.fraisTheoAchats.getFstFormuleE().isEmpty()) {
               this.fraisTheoAchats.setFstFormuleE(this.fraisTheoAchats.getFstFormuleE() + "SI()");
            } else {
               this.fraisTheoAchats.setFstFormuleE("SI()");
            }
         } else if (this.formuleEnCours.equals("F")) {
            if (this.fraisTheoAchats.getFstFormuleF() != null && !this.fraisTheoAchats.getFstFormuleF().isEmpty()) {
               this.fraisTheoAchats.setFstFormuleF(this.fraisTheoAchats.getFstFormuleF() + "SI()");
            } else {
               this.fraisTheoAchats.setFstFormuleF("SI()");
            }
         }
      }

   }

   public void fourmuleCot1() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("COT(DEVISE_TAUX)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("COT(DEVISE_TAUX)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("COT(DEVISE_TAUX)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("COT(DEVISE_TAUX)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("COT(DEVISE_TAUX)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("COT(DEVISE_TAUX)");
         }
      }

   }

   public void fourmuleCot2() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("COT(POIDS)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("COT(POIDS)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("COT(POIDS)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("COT(POIDS)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("COT(POIDS)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("COT(POIDS)");
         }
      }

   }

   public void fourmuleCot3() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("COT(QUANTITE)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("COT(QUANTITE)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("COT(QUANTITE)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("COT(QUANTITE)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("COT(QUANTITE)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("COT(QUANTITE)");
         }
      }

   }

   public void fourmuleCot4() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("PRP(DEVISE_TAUX)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("PRP(DEVISE_TAUX)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("PRP(DEVISE_TAUX)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("PRP(DEVISE_TAUX)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("PRP(DEVISE_TAUX)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("PRP(DEVISE_TAUX)");
         }
      }

   }

   public void fourmuleCmd1() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("CMD(TOTAL_DEVISE)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("CMD(TOTAL_DEVISE)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("CMD(TOTAL_DEVISE)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("CMD(TOTAL_DEVISE)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("CMD(TOTAL_DEVISE)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("CMD(TOTAL_DEVISE)");
         }
      }

   }

   public void fourmuleCmd2() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("CMD(TOTAL_LOCAL)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("CMD(TOTAL_LOCAL)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("CMD(TOTAL_LOCAL)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("CMD(TOTAL_LOCAL)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("CMD(TOTAL_LOCAL)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("CMD(TOTAL_LOCAL)");
         }
      }

   }

   public void fourmuleCmd3() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("CMD(DEVISE_TAUX)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("CMD(DEVISE_TAUX)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("CMD(DEVISE_TAUX)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("CMD(DEVISE_TAUX)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("CMD(DEVISE_TAUX)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("CMD(DEVISE_TAUX)");
         }
      }

   }

   public void fourmuleCmd4() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("CMD(POIDS)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("CMD(POIDS)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("CMD(POIDS)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("CMD(POIDS)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("CMD(POIDS)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("CMD(POIDS)");
         }
      }

   }

   public void fourmuleCmd5() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("CMD(QUANTITE)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("CMD(QUANTITE)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("CMD(QUANTITE)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("CMD(QUANTITE)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("CMD(QUANTITE)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("CMD(QUANTITE)");
         }
      }

   }

   public void fourmuleCmd6() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("CMD(FRET_LOCAL)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("CMD(FRET_LOCAL)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("CMD(FRET_LOCAL)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("CMD(FRET_LOCAL)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("CMD(FRET_LOCAL)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("CMD(FRET_LOCAL)");
         }
      }

   }

   public void fourmuleCmd7() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("CMD(ASSURANCE_LOCAL)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("CMD(ASSURANCE_LOCAL)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("CMD(ASSURANCE_LOCAL)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("CMD(ASSURANCE_LOCAL)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("CMD(ASSURANCE_LOCAL)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("CMD(ASSURANCE_LOCAL)");
         }
      }

   }

   public void fourmuleCmd8() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("CMD(CAF_LOCAL)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("CMD(CAF_LOCAL)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("CMD(CAF_LOCAL)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("CMD(CAF_LOCAL)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("CMD(CAF_LOCAL)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("CMD(CAF_LOCAL)");
         }
      }

   }

   public void fourmuleCmd9() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("PRP(TOTAL_DEVISE)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("PRP(TOTAL_DEVISE)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("PRP(TOTAL_DEVISE)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("PRP(TOTAL_DEVISE)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("PRP(TOTAL_DEVISE)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("PRP(TOTAL_DEVISE)");
         }
      }

   }

   public void fourmuleDoc1() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("DOC(HT)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("DOC(HT)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("DOC(HT)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("DOC(HT)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("DOC(HT)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("DOC(HT)");
         }
      }

   }

   public void fourmuleDoc2() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("DOC(DEVISE_TAUX)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("DOC(DEVISE_TAUX)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("DOC(DEVISE_TAUX)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("DOC(DEVISE_TAUX)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("DOC(DEVISE_TAUX)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("DOC(DEVISE_TAUX)");
         }
      }

   }

   public void fourmuleDoc3() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("DOC(QUANTITE)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("DOC(QUANTITE)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("DOC(QUANTITE)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("DOC(QUANTITE)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("DOC(QUANTITE)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("DOC(QUANTITE)");
         }
      }

   }

   public void fourmuleDoc4() {
   }

   public void fourmuleDoc5() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("DOC(POIDS_KG)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("DOC(POIDS_KG)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("DOC(POIDS_KG)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("DOC(POIDS_KG)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("DOC(POIDS_KG)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("DOC(POIDS_KG)");
         }
      }

   }

   public void fourmuleDoc6() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("DOC(VOLUME)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("DOC(VOLUME)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("DOC(VOLUME)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("DOC(VOLUME)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("DOC(VOLUME)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("DOC(VOLUME)");
         }
      }

   }

   public void fourmuleDoc7() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("DOC(CONTENER)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("DOC(CONTENER)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("DOC(CONTENER)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("DOC(CONTENER)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("DOC(CONTENER)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("DOC(CONTENER)");
         }
      }

   }

   public void fourmuleDoc9() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("DOC(T1-DDI)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("DOC(T1-DDI)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("DOC(T1-DDI)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("DOC(T1-DDI)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("DOC(T1-DDI)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("DOC(T1-DDI)");
         }
      }

   }

   public void fourmuleDoc10() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("DOC(T3-TCI)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("DOC(T3-TCI)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("DOC(T3-TCI)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("DOC(T3-TCI)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("DOC(T3-TCI)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("DOC(T3-TCI)");
         }
      }

   }

   public void fourmuleDoc11() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("DOC(T10-CCI)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("DOC(T10-CCI)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("DOC(T10-CCI)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("DOC(T10-CCI)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("DOC(T10-CCI)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("DOC(T10-CCI)");
         }
      }

   }

   public void fourmuleDoc12() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("DOC(T30-OAD)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("DOC(T30-OAD)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("DOC(T30-OAD)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("DOC(T30-OAD)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("DOC(T30-OAD)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("DOC(T30-OAD)");
         }
      }

   }

   public void fourmuleDoc13() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("DOC(T5-TVA)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("DOC(T5-TVA)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("DOC(T5-TVA)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("DOC(T5-TVA)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("DOC(T5-TVA)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("DOC(T5-TVA)");
         }
      }

   }

   public void fourmuleDoc14() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("DOC(T31-CSS)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("DOC(T31-CSS)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("DOC(T31-CSS)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("DOC(T31-CSS)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("DOC(T31-CSS)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("DOC(T31-CSS)");
         }
      }

   }

   public void fourmuleDoc15() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("DOC(DOUANES)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("DOC(DOUANES)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("DOC(DOUANES)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("DOC(DOUANES)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("DOC(DOUANES)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("DOC(DOUANES)");
         }
      }

   }

   public void fourmuleDoc16() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("DOC(FOB)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("DOC(FOB)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("DOC(FOB)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("DOC(FOB)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("DOC(FOB)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("DOC(FOB)");
         }
      }

   }

   public void fourmuleDoc17() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("DOC(FRET)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("DOC(FRET)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("DOC(FRET)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("DOC(FRET)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("DOC(FRET)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("DOC(FRET)");
         }
      }

   }

   public void fourmuleDoc18() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("DOC(ASSURANCE)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("DOC(ASSURANCE)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("DOC(ASSURANCE)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("DOC(ASSURANCE)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("DOC(ASSURANCE)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("DOC(ASSURANCE)");
         }
      }

   }

   public void fourmuleDoc19() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("DOC(NB_CONTENER)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("DOC(NB_CONTENER)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("DOC(NB_CONTENER)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("DOC(NB_CONTENER)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("DOC(NB_CONTENER)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("DOC(NB_CONTENER)");
         }
      }

   }

   public void fourmuleDoc20() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("DOC(NB_BL)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("DOC(NB_BL)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("DOC(NB_BL)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("DOC(NB_BL)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("DOC(NB_BL)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("DOC(NB_BL)");
         }
      }

   }

   public void fourmuleDoc21() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("DOC(ZONE)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("DOC(ZONE)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("DOC(ZONE)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("DOC(ZONE)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("DOC(ZONE)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("DOC(ZONE)");
         }
      }

   }

   public void fourmuleDoc22() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("DOC(NB_DECLARATION)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("DOC(NB_DECLARATION)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("DOC(NB_DECLARATION)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("DOC(NB_DECLARATION)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("DOC(NB_DECLARATION)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("DOC(NB_DECLARATION)");
         }
      }

   }

   public void fourmuleDoc23() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("DOC(NB_EXPEDITION)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("DOC(NB_EXPEDITION)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("DOC(NB_EXPEDITION)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("DOC(NB_EXPEDITION)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("DOC(NB_EXPEDITION)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("DOC(NB_EXPEDITION)");
         }
      }

   }

   public void fourmuleDoc24() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("DOC(NB_DOSSIER)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("DOC(NB_DOSSIER)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("DOC(NB_DOSSIER)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("DOC(NB_DOSSIER)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("DOC(NB_DOSSIER)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("DOC(NB_DOSSIER)");
         }
      }

   }

   public void fourmuleDoc25() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("DOC(CAF)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("DOC(CAF)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("DOC(CAF)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("DOC(CAF)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("DOC(CAF)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("DOC(CAF)");
         }
      }

   }

   public void fourmuleDoc26() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("DOC(FRS1)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("DOC(FRS1)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("DOC(FRS1)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("DOC(FRS1)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("DOC(FRS1)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("DOC(FRS1)");
         }
      }

   }

   public void fourmuleDoc27() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("DOC(FRS2)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("DOC(FRS2)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("DOC(FRS2)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("DOC(FRS2)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("DOC(FRS2)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("DOC(FRS2)");
         }
      }

   }

   public void fourmuleDoc28() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("DOC(FRS3)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("DOC(FRS3)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("DOC(FRS3)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("DOC(FRS3)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("DOC(FRS3)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("DOC(FRS3)");
         }
      }

   }

   public void fourmuleDoc29() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("DOC(POIDS_T)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("DOC(POIDS_T)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("DOC(POIDS_T)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("DOC(POIDS_T)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("DOC(POIDS_T)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("DOC(POIDS_T)");
         }
      }

   }

   public void fourmuleDoc30() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("DOC(UNITE_PAYANTE)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("DOC(UNITE_PAYANTE)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("DOC(UNITE_PAYANTE)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("DOC(UNITE_PAYANTE)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("DOC(UNITE_PAYANTE)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("DOC(UNITE_PAYANTE)");
         }
      }

   }

   public void fourmuleDoc31() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("DOC(SORTIE_USINE)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("DOC(SORTIE_USINE)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("DOC(SORTIE_USINE)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("DOC(SORTIE_USINE)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("DOC(SORTIE_USINE)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("DOC(SORTIE_USINE)");
         }
      }

   }

   public void fourmuleDoc32() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("TOT(DEBOURS)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("TOT(DEBOURS)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("TOT(DEBOURS)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("TOT(DEBOURS)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("TOT(DEBOURS)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("TOT(DEBOURS)");
         }
      }

   }

   public void fourmuleDoc33() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("TOT(DOUANES)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("TOT(DOUANES)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("TOT(DOUANES)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("TOT(DOUANES)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("TOT(DOUANES)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("TOT(DOUANES)");
         }
      }

   }

   public void fourmuleDoc34() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("TOT(PRESTATIONS)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("TOT(PRESTATIONS)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("TOT(PRESTATIONS)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("TOT(PRESTATIONS)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("TOT(PRESTATIONS)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("TOT(PRESTATIONS)");
         }
      }

   }

   public void fourmuleDoc35() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("TOT(AUTRES_FRAIS)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("TOT(AUTRES_FRAIS)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("TOT(AUTRES_FRAIS)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("TOT(AUTRES_FRAIS)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("TOT(AUTRES_FRAIS)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("TOT(AUTRES_FRAIS)");
         }
      }

   }

   public void fourmuleDoc36() {
      if (this.formuleEnCours != null && !this.formuleEnCours.isEmpty()) {
         if (this.formuleEnCours.equals("A")) {
            this.fraisTheoAchats.setFstFormuleA("DOC(FRET_DHL)");
         } else if (this.formuleEnCours.equals("B")) {
            this.fraisTheoAchats.setFstFormuleB("DOC(FRET_DHL)");
         } else if (this.formuleEnCours.equals("C")) {
            this.fraisTheoAchats.setFstFormuleC("DOC(FRET_DHL)");
         } else if (this.formuleEnCours.equals("D")) {
            this.fraisTheoAchats.setFstFormuleD("DOC(FRET_DHL)");
         } else if (this.formuleEnCours.equals("E")) {
            this.fraisTheoAchats.setFstFormuleE("DOC(FRET_DHL)");
         } else if (this.formuleEnCours.equals("F")) {
            this.fraisTheoAchats.setFstFormuleF("DOC(FRET_DHL)");
         }
      }

   }

   public void selectionDetail() {
      if (this.datamodelFraisLigne.isRowAvailable()) {
         this.fraisTheoAchats = (FraisTheoAchats)this.datamodelFraisLigne.getRowData();
      } else {
         this.fraisTheoAchats = null;
      }

   }

   public void ajouterDetail() {
      this.fraisTheoAchats = new FraisTheoAchats();
      this.var_mode_detail = false;
      this.showModalPanelDetail = true;
   }

   public void modifierDetail() {
      if (this.fraisTheoAchats != null) {
         this.var_mode_detail = true;
         this.showModalPanelDetail = true;
      }

   }

   public void supprimerDetail() throws HibernateException, NamingException {
      if (this.fraisTheoAchats != null) {
         this.fraisLigneList.remove(this.fraisTheoAchats);
         this.fraisTheoAchatsDao.delete(this.fraisTheoAchats);
         this.datamodelFraisLigne.setWrappedData(this.fraisLigneList);
      }

   }

   public void saveDetail() {
      this.fraisTheoAchats.setFstMode(this.var_mode);
      this.fraisTheoAchats.setFstNature(this.var_nature);
      if (!this.var_mode_detail) {
         this.fraisTheoAchats.setFstOrdre(this.fraisLigneList.size());
         this.fraisLigneList.add(this.fraisTheoAchats);
      }

      this.datamodelFraisLigne.setWrappedData(this.fraisLigneList);
      this.showModalPanelDetail = false;
   }

   public void descendre() throws HibernateException, NamingException {
      this.selectionDetail();
      if (this.fraisTheoAchats != null) {
         int var1 = this.calculeNumlLigne() + 1;
         if (var1 < this.fraisLigneList.size()) {
            this.fraisLigneList.remove(this.fraisTheoAchats);
            this.fraisLigneList.add(var1, this.fraisTheoAchats);
            this.datamodelFraisLigne.setWrappedData(this.fraisLigneList);
         }
      }

   }

   public void monter() throws HibernateException, NamingException {
      this.selectionDetail();
      if (this.fraisTheoAchats != null) {
         int var1 = this.calculeNumlLigne() - 1;
         if (var1 >= 0) {
            this.fraisLigneList.remove(this.fraisTheoAchats);
            this.fraisLigneList.add(var1, this.fraisTheoAchats);
            this.datamodelFraisLigne.setWrappedData(this.fraisLigneList);
         }
      }

   }

   public int calculeNumlLigne() {
      int var1 = 0;
      if (this.fraisLigneList.size() != 0) {
         for(int var2 = 0; var2 < this.fraisLigneList.size(); ++var2) {
            if (this.fraisTheoAchats.getFstId() == ((FraisTheoAchats)this.fraisLigneList.get(var2)).getFstId()) {
               var1 = var2;
               break;
            }
         }
      }

      return var1;
   }

   public void annulerDetail() {
      this.showModalPanelDetail = false;
   }

   public void selectionTranche() {
      if (this.datamodelTranche.isRowAvailable()) {
         this.objetTarif = (ObjetTarif)this.datamodelTranche.getRowData();
         this.visibiliteBtonTranche = true;
      }

   }

   public void ajouterCalculTranche() {
      this.objetTarif = new ObjetTarif();
      this.visibiliteBtonTranche = false;
      this.etatTranche = 0;
      this.showModalPanelCalculTranche = true;
   }

   public void modifierCalculTranche() {
      if (this.objetTarif != null) {
         this.etatTranche = 1;
         this.visibiliteBtonTranche = false;
         this.showModalPanelCalculTranche = true;
      }

   }

   public void supprimerCalculTranche() {
      if (this.objetTarif != null) {
         this.listeTranche.remove(this.objetTarif);
         this.datamodelTranche.setWrappedData(this.listeTranche);
         this.visibiliteBtonTranche = false;
      }

   }

   public void validerCalculTranche() {
      if (this.objetTarif != null && this.etatTranche == 0) {
         this.listeTranche.add(this.objetTarif);
         this.datamodelTranche.setWrappedData(this.listeTranche);
      }

      this.showModalPanelCalculTranche = false;
   }

   public void fermerCalculTranche() {
      this.visibiliteBtonTranche = false;
      this.showModalPanelCalculTranche = false;
   }

   public void imprimerPRT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "PRT";
      this.imprimer();
   }

   public void imprimerJRV() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "JRV";
      this.imprimer();
   }

   public void imprimerPDF() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "PDF";
      this.imprimer();
   }

   public void imprimerODT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "ODT";
      this.imprimer();
   }

   public void imprimerXLS() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "XLS";
      this.imprimer();
   }

   public void imprimerDOC() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "DOC";
      this.imprimer();
   }

   public void imprimerHTML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "HTML";
      this.imprimer();
   }

   public void imprimerXML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "XML";
      this.imprimer();
   }

   public void imprimer() throws JRException, IOException, SQLException, ClassNotFoundException, Exception {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.utilPrint.setBaseLog(this.baseLog);
      this.utilPrint.setStructureLog(this.structureLog);
      this.utilPrint.setUsersLog(this.usersLog);
      this.utilPrint.setFormat(this.format);
      this.utilPrint.setTiersSelectionne((Tiers)null);
      JRBeanCollectionDataSource var1 = null;
      this.utilPrint.setRapport("StructureFrais");
      this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator);
      this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "sous_rapport" + File.separator);
      this.utilPrint.setEntete("Structure des frais: " + this.fraisTheoAchats.getFstMode() + " " + this.fraisTheoAchats.getFstFeuille());
      var1 = new JRBeanCollectionDataSource(this.fraisLigneList);
      this.utilPrint.setjRBeanCollectionDataSource(var1);
      this.utilPrint.imprimeRapport();
   }

   public boolean isVar_affiche_bouton() {
      return this.var_affiche_bouton;
   }

   public void setVar_affiche_bouton(boolean var1) {
      this.var_affiche_bouton = var1;
   }

   public boolean isShowModalPanelDetail() {
      return this.showModalPanelDetail;
   }

   public void setShowModalPanelDetail(boolean var1) {
      this.showModalPanelDetail = var1;
   }

   public boolean isShowModalPanelFeuille() {
      return this.showModalPanelFeuille;
   }

   public void setShowModalPanelFeuille(boolean var1) {
      this.showModalPanelFeuille = var1;
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

   public DataModel getDatamodelFraisEntete() {
      return this.datamodelFraisEntete;
   }

   public void setDatamodelFraisEntete(DataModel var1) {
      this.datamodelFraisEntete = var1;
   }

   public DataModel getDatamodelFraisLigne() {
      return this.datamodelFraisLigne;
   }

   public void setDatamodelFraisLigne(DataModel var1) {
      this.datamodelFraisLigne = var1;
   }

   public FraisTheoAchats getFraisTheoAchats() {
      return this.fraisTheoAchats;
   }

   public void setFraisTheoAchats(FraisTheoAchats var1) {
      this.fraisTheoAchats = var1;
   }

   public String getVar_nom_feuille() {
      return this.var_nom_feuille;
   }

   public void setVar_nom_feuille(String var1) {
      this.var_nom_feuille = var1;
   }

   public int getVar_type_feuille() {
      return this.var_type_feuille;
   }

   public void setVar_type_feuille(int var1) {
      this.var_type_feuille = var1;
   }

   public List getFraisLigneList() {
      return this.fraisLigneList;
   }

   public void setFraisLigneList(List var1) {
      this.fraisLigneList = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public List getFraisEnteteList() {
      return this.fraisEnteteList;
   }

   public void setFraisEnteteList(List var1) {
      this.fraisEnteteList = var1;
   }

   public boolean isAffichageTranche() {
      return this.affichageTranche;
   }

   public void setAffichageTranche(boolean var1) {
      this.affichageTranche = var1;
   }

   public boolean isShowModalPanelTranche() {
      return this.showModalPanelTranche;
   }

   public void setShowModalPanelTranche(boolean var1) {
      this.showModalPanelTranche = var1;
   }

   public long getVar_id_fournisseur() {
      return this.var_id_fournisseur;
   }

   public void setVar_id_fournisseur(long var1) {
      this.var_id_fournisseur = var1;
   }

   public List getListTiersItems() {
      return this.listTiersItems;
   }

   public void setListTiersItems(List var1) {
      this.listTiersItems = var1;
   }

   public DataModel getDatamodelTranche() {
      return this.datamodelTranche;
   }

   public void setDatamodelTranche(DataModel var1) {
      this.datamodelTranche = var1;
   }

   public boolean isShowModalPanelCalculTranche() {
      return this.showModalPanelCalculTranche;
   }

   public void setShowModalPanelCalculTranche(boolean var1) {
      this.showModalPanelCalculTranche = var1;
   }

   public boolean isVisibiliteBtonTranche() {
      return this.visibiliteBtonTranche;
   }

   public void setVisibiliteBtonTranche(boolean var1) {
      this.visibiliteBtonTranche = var1;
   }

   public ObjetTarif getObjetTarif() {
      return this.objetTarif;
   }

   public void setObjetTarif(ObjetTarif var1) {
      this.objetTarif = var1;
   }

   public String getVar_mode() {
      return this.var_mode;
   }

   public void setVar_mode(String var1) {
      this.var_mode = var1;
   }

   public int getVar_nature() {
      return this.var_nature;
   }

   public void setVar_nature(int var1) {
      this.var_nature = var1;
   }

   public List getMesDevisesItems() {
      return this.mesDevisesItems;
   }

   public void setMesDevisesItems(List var1) {
      this.mesDevisesItems = var1;
   }

   public boolean isFrsPrp1() {
      return this.frsPrp1;
   }

   public void setFrsPrp1(boolean var1) {
      this.frsPrp1 = var1;
   }

   public boolean isFrsPrp2() {
      return this.frsPrp2;
   }

   public void setFrsPrp2(boolean var1) {
      this.frsPrp2 = var1;
   }

   public boolean isFrsPrp3() {
      return this.frsPrp3;
   }

   public void setFrsPrp3(boolean var1) {
      this.frsPrp3 = var1;
   }

   public OptionAchats getOptionAchats() {
      return this.optionAchats;
   }

   public void setOptionAchats(OptionAchats var1) {
      this.optionAchats = var1;
   }
}
