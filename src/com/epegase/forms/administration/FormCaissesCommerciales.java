package com.epegase.forms.administration;

import com.epegase.systeme.classe.CaissesCommerciales;
import com.epegase.systeme.classe.CaissesOperations;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.ExercicesCaisse;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.PlanComptable;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.dao.CaissesCommercialesDao;
import com.epegase.systeme.dao.CaissesOperationsDao;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.PlanComptableDao;
import com.epegase.systeme.dao.ProjetsDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureTypeReglement;
import com.epegase.systeme.xml.ObjetCompte;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FormCaissesCommerciales implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private ExercicesCaisse exocaiSelect;
   private CaissesCommerciales caissesCommerciales = new CaissesCommerciales();
   private CaissesCommercialesDao caissesCommercialesDao;
   private List caisseList = new ArrayList();
   private transient DataModel datamodelCaisse = new ListDataModel();
   private boolean visibiliteBton = false;
   private boolean inactif = false;
   private boolean showModalPanelCaisse;
   private boolean doublon = false;
   private String var_banqueDefaut;
   private long idCaissier;
   private ExercicesComptable exerciceComptable;
   private List lesTypeReglements;
   private List mesCaissiersItems = new ArrayList();
   private Chrono chrono;
   private ChronoDao chronoDao;
   private UsersChrono usersChrono;
   private UsersChronoDao usersChronoDao;
   private List mesChronosItems;
   private List mesChronosEncaissementItems;
   private List mesChronosDecaissementItems;
   private List mesChronosEntreeItems;
   private List mesChronosSortieItems;
   private List mesChronosVirementItems;
   private List mesProjetsItems;
   private String var_journalEspece = "100";
   private String var_journalEspeceST = "100";
   private String var_journalCheque = "100";
   private String var_journalVirement = "100";
   private String var_journalTraite = "100";
   private String var_journalTpe = "100";
   private String var_journalTransfert = "100";
   private String var_journalePaiement = "100";
   private String var_journalCredoc = "100";
   private String var_journalFactor = "100";
   private String var_journalCompense = "100";
   private String var_journalTerme = "100";
   private String var_journalLettreGarantie = "100";
   private String var_journalPrelevement = "100";
   private String var_journalAlcoin = "100";
   private boolean var_afficheEspece;
   private boolean var_afficheEspeceST;
   private boolean var_afficheCheque;
   private boolean var_afficheVirement;
   private boolean var_afficheTraite;
   private boolean var_afficheTpe;
   private boolean var_afficheTransfert;
   private boolean var_afficheePaiement;
   private boolean var_afficheCredoc;
   private boolean var_afficheFactor;
   private boolean var_afficheCompense;
   private boolean var_afficheTerme;
   private boolean var_afficheLettreGarantie;
   private boolean var_affichePrelevement;
   private boolean var_afficheAlcoin;
   private List mesJouranuxCaisseItems;
   private JournauxComptablesDao journauxComptablesDao;
   private String var_compte = "100";
   private String var_compteEffet = "100";
   private PlanComptable planComptable;
   private PlanComptableDao planComptableDao;
   private List mesPlansComptableItem;
   private List mesOperationsCaisses = new ArrayList();
   private CaissesOperationsDao caissesOperationsDao;
   private List userOperationsCaisses = new ArrayList();
   private transient DataModel dataModelOperation = new ListDataModel();
   private CaissesOperations caissesOperations;
   private ProjetsDao projetsDao;
   private boolean projetActif;
   private int choixRacine;
   private String selecFiscalite;

   public FormCaissesCommerciales() throws ParseException {
   }

   public void InstancesDaoUtilses() {
      this.caissesCommercialesDao = new CaissesCommercialesDao(this.baseLog, this.utilInitHibernate);
      this.journauxComptablesDao = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
      this.planComptableDao = new PlanComptableDao(this.baseLog, this.utilInitHibernate);
      this.caissesCommercialesDao = new CaissesCommercialesDao(this.baseLog, this.utilInitHibernate);
      this.caissesOperationsDao = new CaissesOperationsDao(this.baseLog, this.utilInitHibernate);
      this.projetsDao = new ProjetsDao(this.baseLog, this.utilInitHibernate);
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
   }

   public void lesCaisses(Session var1) throws HibernateException, NamingException {
      this.caisseList = this.caissesCommercialesDao.selectCaisseCommerciale(this.exocaiSelect.getExecaiId(), this.usersLog.getUsrJrxReserve(), var1);
      this.datamodelCaisse.setWrappedData(this.caisseList);
      this.mesOperationsCaisses = this.caissesOperationsDao.selectActifOperation(var1);
   }

   public void chargerTypeReglement() {
      this.var_afficheEspece = false;
      this.var_afficheEspeceST = false;
      this.var_afficheCheque = false;
      this.var_afficheVirement = false;
      this.var_afficheTraite = false;
      this.var_afficheTpe = false;
      this.var_afficheTransfert = false;
      this.var_afficheePaiement = false;
      this.var_afficheCredoc = false;
      this.var_afficheFactor = false;
      this.var_afficheCompense = false;
      this.var_afficheTerme = false;
      this.var_afficheLettreGarantie = false;
      this.var_affichePrelevement = false;
      this.var_afficheAlcoin = false;
      LectureTypeReglement var1 = new LectureTypeReglement(this.baseLog);
      this.lesTypeReglements = var1.getMesTypeReglementItems();
      new ArrayList();
      List var2 = var1.getMesTypeReglement();
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            new ObjetCompte();
            ObjetCompte var4 = (ObjetCompte)var2.get(var3);
            if (var4.isValide()) {
               if (var4.getCode().equals("0")) {
                  this.var_afficheEspece = true;
               } else if (var4.getCode().equals("1")) {
                  this.var_afficheCheque = true;
               } else if (var4.getCode().equals("2")) {
                  this.var_afficheVirement = true;
               } else if (var4.getCode().equals("3")) {
                  this.var_afficheTraite = true;
               } else if (var4.getCode().equals("4")) {
                  this.var_afficheTpe = true;
               } else if (var4.getCode().equals("5")) {
                  this.var_afficheTransfert = true;
               } else if (var4.getCode().equals("6")) {
                  this.var_afficheePaiement = true;
               } else if (var4.getCode().equals("7")) {
                  this.var_afficheCredoc = true;
               } else if (var4.getCode().equals("8")) {
                  this.var_afficheFactor = true;
               } else if (var4.getCode().equals("9")) {
                  this.var_afficheCompense = true;
               } else if (var4.getCode().equals("10")) {
                  this.var_afficheTerme = true;
               } else if (var4.getCode().equals("11")) {
                  this.var_afficheEspeceST = true;
               } else if (var4.getCode().equals("12")) {
                  this.var_afficheLettreGarantie = true;
               } else if (var4.getCode().equals("13")) {
                  this.var_affichePrelevement = true;
               } else if (var4.getCode().equals("14")) {
                  this.var_afficheAlcoin = true;
               }
            }
         }
      }

   }

   public void chargerLesChronosItems(Session var1) throws HibernateException, NamingException {
      this.mesChronosItems = new ArrayList();
      this.mesChronosEncaissementItems = new ArrayList();
      this.mesChronosDecaissementItems = new ArrayList();
      this.mesChronosEntreeItems = new ArrayList();
      this.mesChronosSortieItems = new ArrayList();
      this.mesChronosVirementItems = new ArrayList();
      new ArrayList();
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
      List var2 = this.chronoDao.selectListCaisses(this.usersLog.getUsrJrxReserve(), var1);
      this.mesChronosItems.add(new SelectItem(""));
      this.mesChronosEncaissementItems.add(new SelectItem(""));
      this.mesChronosDecaissementItems.add(new SelectItem(""));
      this.mesChronosEntreeItems.add(new SelectItem(""));
      this.mesChronosSortieItems.add(new SelectItem(""));
      this.mesChronosVirementItems.add(new SelectItem(""));
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            String var4 = ((Chrono)var2.get(var3)).getChrSerie() + ":" + ((Chrono)var2.get(var3)).getLibnature();
            this.mesChronosItems.add(new SelectItem(var4));
            if (((Chrono)var2.get(var3)).getChrNature() == 60) {
               this.mesChronosEncaissementItems.add(new SelectItem(var4));
               this.mesChronosDecaissementItems.add(new SelectItem(var4));
            } else if (((Chrono)var2.get(var3)).getChrNature() != 61) {
               if (((Chrono)var2.get(var3)).getChrNature() == 62) {
                  this.mesChronosSortieItems.add(new SelectItem(var4));
               } else if (((Chrono)var2.get(var3)).getChrNature() == 63) {
                  this.mesChronosEntreeItems.add(new SelectItem(var4));
               } else if (((Chrono)var2.get(var3)).getChrNature() == 64) {
                  this.mesChronosVirementItems.add(new SelectItem(var4));
               }
            }
         }
      }

   }

   public void chargerLesJrCaisse(Session var1) throws HibernateException, NamingException {
      this.mesJouranuxCaisseItems = new ArrayList();
      this.mesJouranuxCaisseItems = this.journauxComptablesDao.chargerLesJournaux(this.exerciceComptable, 2, this.usersLog.getUsrJrxReserve(), var1);
   }

   public void chargerLesComptes(Session var1) throws HibernateException, NamingException {
      new ArrayList();
      this.mesPlansComptableItem = new ArrayList();
      List var2 = this.planComptableDao.chargerPlanComtableNature((String)null, this.exerciceComptable.getExecpt_id(), "12", var1);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            this.mesPlansComptableItem.add(new SelectItem(((PlanComptable)var2.get(var3)).getPlcCompte() + ":" + ((PlanComptable)var2.get(var3)).getPlcLibelleCpteFR()));
         }
      }

   }

   public void chargerLesProjets(Session var1) throws HibernateException, NamingException {
      this.projetActif = false;
      if (this.structureLog.getStrmod1() != null && !this.structureLog.getStrmod1().isEmpty() && this.structureLog.getStrmod1().equals("40300")) {
         this.projetActif = true;
      } else if (this.structureLog.getStrmod2() != null && !this.structureLog.getStrmod2().isEmpty() && this.structureLog.getStrmod2().equals("40300")) {
         this.projetActif = true;
      } else if (this.structureLog.getStrmod3() != null && !this.structureLog.getStrmod3().isEmpty() && this.structureLog.getStrmod3().equals("40300")) {
         this.projetActif = true;
      } else if (this.structureLog.getStrmod4() != null && !this.structureLog.getStrmod4().isEmpty() && this.structureLog.getStrmod4().equals("40300")) {
         this.projetActif = true;
      } else if (this.structureLog.getStrmod5() != null && !this.structureLog.getStrmod5().isEmpty() && this.structureLog.getStrmod5().equals("40300")) {
         this.projetActif = true;
      } else if (this.structureLog.getStrmod6() != null && !this.structureLog.getStrmod6().isEmpty() && this.structureLog.getStrmod6().equals("40300")) {
         this.projetActif = true;
      } else if (this.structureLog.getStrmod7() != null && !this.structureLog.getStrmod7().isEmpty() && this.structureLog.getStrmod7().equals("40300")) {
         this.projetActif = true;
      } else if (this.structureLog.getStrmod8() != null && !this.structureLog.getStrmod8().isEmpty() && this.structureLog.getStrmod8().equals("40300")) {
         this.projetActif = true;
      } else if (this.structureLog.getStrmod9() != null && !this.structureLog.getStrmod9().isEmpty() && this.structureLog.getStrmod9().equals("40300")) {
         this.projetActif = true;
      } else if (this.structureLog.getStrmod10() != null && !this.structureLog.getStrmod10().isEmpty() && this.structureLog.getStrmod10().equals("40300")) {
         this.projetActif = true;
      }

      this.mesProjetsItems = new ArrayList();
      if (this.projetActif) {
         this.mesProjetsItems = this.projetsDao.chargerLesProjets(0, var1);
      }

   }

   public void selectionCaisse() throws HibernateException, NamingException {
      this.annule();
      if (this.datamodelCaisse.isRowAvailable()) {
         this.caissesCommerciales = (CaissesCommerciales)this.datamodelCaisse.getRowData();
         this.userOperationsCaisses.clear();
         if (this.caissesCommerciales.getCaiJrEspece() != null && !this.caissesCommerciales.getCaiJrEspece().isEmpty()) {
            this.var_journalEspece = this.caissesCommerciales.getCaiJrEspece() + ":" + this.caissesCommerciales.getCaiNomJrEspece();
         } else {
            this.var_journalEspece = "100";
         }

         if (this.caissesCommerciales.getCaiJrEspeceST() != null && !this.caissesCommerciales.getCaiJrEspeceST().isEmpty()) {
            this.var_journalEspeceST = this.caissesCommerciales.getCaiJrEspeceST() + ":" + this.caissesCommerciales.getCaiNomJrEspeceST();
         } else {
            this.var_journalEspeceST = "100";
         }

         if (this.caissesCommerciales.getCaiJrCheque() != null && !this.caissesCommerciales.getCaiJrCheque().isEmpty()) {
            this.var_journalCheque = this.caissesCommerciales.getCaiJrCheque() + ":" + this.caissesCommerciales.getCaiNomJrCheque();
         } else {
            this.var_journalCheque = "100";
         }

         if (this.caissesCommerciales.getCaiJrVirement() != null && !this.caissesCommerciales.getCaiJrVirement().isEmpty()) {
            this.var_journalVirement = this.caissesCommerciales.getCaiJrVirement() + ":" + this.caissesCommerciales.getCaiNomJrVirement();
         } else {
            this.var_journalVirement = "100";
         }

         if (this.caissesCommerciales.getCaiJrTraite() != null && !this.caissesCommerciales.getCaiJrTraite().isEmpty()) {
            this.var_journalTraite = this.caissesCommerciales.getCaiJrTraite() + ":" + this.caissesCommerciales.getCaiNomJrTraite();
         } else {
            this.var_journalTraite = "100";
         }

         if (this.caissesCommerciales.getCaiJrTpe() != null && !this.caissesCommerciales.getCaiJrTpe().isEmpty()) {
            this.var_journalTpe = this.caissesCommerciales.getCaiJrTpe() + ":" + this.caissesCommerciales.getCaiNomJrTpe();
         } else {
            this.var_journalTpe = "100";
         }

         if (this.caissesCommerciales.getCaiJrTransfert() != null && !this.caissesCommerciales.getCaiJrTransfert().isEmpty()) {
            this.var_journalTransfert = this.caissesCommerciales.getCaiJrTransfert() + ":" + this.caissesCommerciales.getCaiNomJrTransfert();
         } else {
            this.var_journalTransfert = "100";
         }

         if (this.caissesCommerciales.getCaiJrePaiement() != null && !this.caissesCommerciales.getCaiJrePaiement().isEmpty()) {
            this.var_journalePaiement = this.caissesCommerciales.getCaiJrePaiement() + ":" + this.caissesCommerciales.getCaiNomJrePaiement();
         } else {
            this.var_journalePaiement = "100";
         }

         if (this.caissesCommerciales.getCaiJrCredoc() != null && !this.caissesCommerciales.getCaiJrCredoc().isEmpty()) {
            this.var_journalCredoc = this.caissesCommerciales.getCaiJrCredoc() + ":" + this.caissesCommerciales.getCaiNomJrCredoc();
         } else {
            this.var_journalCredoc = "100";
         }

         if (this.caissesCommerciales.getCaiJrFactor() != null && !this.caissesCommerciales.getCaiJrFactor().isEmpty()) {
            this.var_journalFactor = this.caissesCommerciales.getCaiJrFactor() + ":" + this.caissesCommerciales.getCaiNomJrFactor();
         } else {
            this.var_journalFactor = "100";
         }

         if (this.caissesCommerciales.getCaiJrCompense() != null && !this.caissesCommerciales.getCaiJrCompense().isEmpty()) {
            this.var_journalCompense = this.caissesCommerciales.getCaiJrCompense() + ":" + this.caissesCommerciales.getCaiNomJrCompense();
         } else {
            this.var_journalCompense = "100";
         }

         if (this.caissesCommerciales.getCaiJrTerme() != null && !this.caissesCommerciales.getCaiJrTerme().isEmpty()) {
            this.var_journalTerme = this.caissesCommerciales.getCaiJrTerme() + ":" + this.caissesCommerciales.getCaiNomJrTerme();
         } else {
            this.var_journalTerme = "100";
         }

         if (this.caissesCommerciales.getCaiJrLettreGarantie() != null && !this.caissesCommerciales.getCaiJrLettreGarantie().isEmpty()) {
            this.var_journalLettreGarantie = this.caissesCommerciales.getCaiJrLettreGarantie() + ":" + this.caissesCommerciales.getCaiNomJrLettreGarantie();
         } else {
            this.var_journalLettreGarantie = "100";
         }

         if (this.caissesCommerciales.getCaiJrPrelevement() != null && !this.caissesCommerciales.getCaiJrPrelevement().isEmpty()) {
            this.var_journalPrelevement = this.caissesCommerciales.getCaiJrPrelevement() + ":" + this.caissesCommerciales.getCaiNomJrPrelevement();
         } else {
            this.var_journalPrelevement = "100";
         }

         if (this.caissesCommerciales.getCaiJrAlcoin() != null && !this.caissesCommerciales.getCaiJrAlcoin().isEmpty()) {
            this.var_journalAlcoin = this.caissesCommerciales.getCaiJrAlcoin() + ":" + this.caissesCommerciales.getCaiNomJrAlcoin();
         } else {
            this.var_journalAlcoin = "100";
         }

         if (this.caissesCommerciales.getCaiCompteVrt() != null && !this.caissesCommerciales.getCaiCompteVrt().isEmpty()) {
            this.var_compte = this.caissesCommerciales.getCaiCompteVrt() + ":" + this.caissesCommerciales.getCaiLibCompteVrt();
         } else {
            this.var_compte = "100";
         }

         if (this.caissesCommerciales.getCaiCompteEff() != null && !this.caissesCommerciales.getCaiCompteEff().isEmpty()) {
            this.var_compteEffet = this.caissesCommerciales.getCaiCompteEff() + ":" + this.caissesCommerciales.getCaiLibCompteEff();
         } else {
            this.var_compteEffet = "100";
         }

         if (this.caissesCommerciales.getCaiCodeBanqueDefaut() != null && !this.caissesCommerciales.getCaiCodeBanqueDefaut().isEmpty()) {
            this.var_banqueDefaut = this.caissesCommerciales.getCaiCodeBanqueDefaut() + ":" + this.caissesCommerciales.getCaiNomBanqueDefaut();
         } else {
            this.var_banqueDefaut = "100";
         }

         if (this.caissesCommerciales.getCaiInactif() == 1) {
            this.inactif = true;
            this.visibiliteBton = false;
         } else {
            this.inactif = false;
            this.visibiliteBton = true;
         }

         if (this.mesOperationsCaisses.size() != 0) {
            for(int var1 = 0; var1 < this.mesOperationsCaisses.size(); ++var1) {
               this.caissesOperations = new CaissesOperations();
               this.caissesOperations = (CaissesOperations)this.mesOperationsCaisses.get(var1);
               this.caissesOperations.setSelect(false);
               this.caissesOperations.setPlafond(0.0D);
               this.userOperationsCaisses.add(this.caissesOperations);
            }

            if (this.caissesCommerciales != null && this.caissesCommerciales.getCaiOperation() != null && !this.caissesCommerciales.getCaiOperation().isEmpty()) {
               String var5 = "";
               if (!this.caissesCommerciales.getCaiOperation().contains(":")) {
                  var5 = this.caissesCommerciales.getCaiOperation();

                  for(int var6 = 0; var6 < this.userOperationsCaisses.size(); ++var6) {
                     this.caissesOperations = new CaissesOperations();
                     this.caissesOperations = (CaissesOperations)this.userOperationsCaisses.get(var6);
                     if (this.caissesOperations.getCaiopeCode().equals(var5)) {
                        this.caissesOperations.setSelect(true);
                        this.caissesOperations.setPlafond(0.0D);
                     }
                  }
               } else {
                  String[] var2 = this.caissesCommerciales.getCaiOperation().split(":");

                  for(int var3 = 0; var3 < var2.length; ++var3) {
                     var5 = var2[var3];

                     for(int var4 = 0; var4 < this.userOperationsCaisses.size(); ++var4) {
                        this.caissesOperations = new CaissesOperations();
                        this.caissesOperations = (CaissesOperations)this.userOperationsCaisses.get(var4);
                        if (this.caissesOperations.getCaiopeCode().equals(var5)) {
                           this.caissesOperations.setSelect(true);
                           this.caissesOperations.setPlafond(0.0D);
                        }
                     }
                  }
               }
            }
         }

         this.chargerLesCaissiersItems((Session)null);
         this.dataModelOperation.setWrappedData(this.userOperationsCaisses);
      }

   }

   public void chargerLesCaissiersItems(Session var1) throws HibernateException, NamingException {
      this.mesCaissiersItems.clear();
      if (this.caissesCommerciales != null && this.caissesCommerciales.getCaiCode() != null && !this.caissesCommerciales.getCaiCode().isEmpty()) {
         new ArrayList();
         List var2 = this.usersChronoDao.selectListCaisse(this.caissesCommerciales.getCaiCode(), var1);
         if (var2.size() != 0) {
            for(int var3 = 0; var3 < var2.size(); ++var3) {
               long var4 = ((UsersChrono)var2.get(var3)).getUsers().getUsrid();
               String var6 = ((UsersChrono)var2.get(var3)).getUsers().getUsrPatronyme();
               if (((UsersChrono)var2.get(var3)).getUsrchrExecution() == 1) {
                  this.mesCaissiersItems.add(new SelectItem(var4, var6 + " (Exécution)"));
               } else {
                  this.mesCaissiersItems.add(new SelectItem(var4, var6));
               }
            }
         }
      }

   }

   public void ajouterCaisse() {
      this.caissesCommerciales = new CaissesCommerciales();
      this.inactif = false;
      this.doublon = true;
      this.var_compte = "100";
      this.var_compteEffet = "100";
      this.mesCaissiersItems.clear();
      this.showModalPanelCaisse = true;
   }

   public void modifierCaisse() {
      if (this.caissesCommerciales != null) {
         this.doublon = false;
         this.showModalPanelCaisse = true;
      }

   }

   public void supprimerCaisse() throws HibernateException, NamingException {
      if (this.caissesCommerciales != null) {
         this.caisseList.remove(this.caissesCommerciales);
         this.datamodelCaisse.setWrappedData(this.caisseList);
         this.caissesCommercialesDao.delete(this.caissesCommerciales);
         this.visibiliteBton = false;
      }

   }

   public void reactiverCaisse() throws HibernateException, NamingException {
      if (this.caissesCommerciales != null) {
         this.caissesCommerciales.setCaiDateModif(new Date());
         this.caissesCommerciales.setCaiUserModif(this.usersLog.getUsrid());
         this.caissesCommerciales.setCaiInactif(0);
         this.caissesCommerciales = this.caissesCommercialesDao.modif(this.caissesCommerciales);
      }

   }

   public void annule() {
      this.showModalPanelCaisse = false;
   }

   public void doublonCode() throws HibernateException, NamingException {
      if (this.caissesCommerciales.getCaiCode() != null && !this.caissesCommerciales.getCaiCode().isEmpty()) {
         new CaissesCommerciales();
         CaissesCommerciales var1 = this.caissesCommercialesDao.selectCaisse(this.exocaiSelect.getExecaiId(), this.caissesCommerciales.getCaiCode(), (Session)null);
         if (var1 != null) {
            this.doublon = true;
         } else {
            this.doublon = false;
         }
      } else {
         this.doublon = false;
      }

   }

   public void saveCaisse() throws HibernateException, NamingException {
      String var1 = "";
      if (this.userOperationsCaisses.size() != 0) {
         new CaissesOperations();
         boolean var3 = true;

         for(int var4 = 0; var4 < this.userOperationsCaisses.size(); ++var4) {
            CaissesOperations var2 = (CaissesOperations)this.userOperationsCaisses.get(var4);
            if (var2.isSelect()) {
               if (var3) {
                  var3 = false;
                  var1 = var2.getCaiopeCode();
               } else {
                  var1 = var1 + ":" + var2.getCaiopeCode();
               }
            }
         }
      }

      this.caissesCommerciales.setCaiOperation(var1);
      String[] var13;
      if (this.var_journalEspece != null && !this.var_journalEspece.isEmpty() && this.var_journalEspece.contains(":")) {
         var13 = this.var_journalEspece.split(":");
         this.caissesCommerciales.setCaiJrEspece(var13[0]);
         this.caissesCommerciales.setCaiNomJrEspece(var13[1]);
      } else {
         this.caissesCommerciales.setCaiJrEspece("");
         this.caissesCommerciales.setCaiNomJrEspece("");
      }

      if (this.var_journalEspeceST != null && !this.var_journalEspeceST.isEmpty() && this.var_journalEspeceST.contains(":")) {
         var13 = this.var_journalEspeceST.split(":");
         this.caissesCommerciales.setCaiJrEspeceST(var13[0]);
         this.caissesCommerciales.setCaiNomJrEspeceST(var13[1]);
      } else {
         this.caissesCommerciales.setCaiJrEspeceST("");
         this.caissesCommerciales.setCaiNomJrEspeceST("");
      }

      if (this.var_journalCheque != null && !this.var_journalCheque.isEmpty() && this.var_journalCheque.contains(":")) {
         var13 = this.var_journalCheque.split(":");
         this.caissesCommerciales.setCaiJrCheque(var13[0]);
         this.caissesCommerciales.setCaiNomJrCheque(var13[1]);
      } else {
         this.caissesCommerciales.setCaiJrCheque("");
         this.caissesCommerciales.setCaiNomJrCheque("");
      }

      if (this.var_journalVirement != null && !this.var_journalVirement.isEmpty() && this.var_journalVirement.contains(":")) {
         var13 = this.var_journalVirement.split(":");
         this.caissesCommerciales.setCaiJrVirement(var13[0]);
         this.caissesCommerciales.setCaiNomJrVirement(var13[1]);
      } else {
         this.caissesCommerciales.setCaiJrVirement("");
         this.caissesCommerciales.setCaiNomJrVirement("");
      }

      if (this.var_journalTraite != null && !this.var_journalTraite.isEmpty() && this.var_journalTraite.contains(":")) {
         var13 = this.var_journalTraite.split(":");
         this.caissesCommerciales.setCaiJrTraite(var13[0]);
         this.caissesCommerciales.setCaiNomJrTraite(var13[1]);
      } else {
         this.caissesCommerciales.setCaiJrTraite("");
         this.caissesCommerciales.setCaiNomJrTraite("");
      }

      if (this.var_journalTpe != null && !this.var_journalTpe.isEmpty() && this.var_journalTpe.contains(":")) {
         var13 = this.var_journalTpe.split(":");
         this.caissesCommerciales.setCaiJrTpe(var13[0]);
         this.caissesCommerciales.setCaiNomJrTpe(var13[1]);
      } else {
         this.caissesCommerciales.setCaiJrTpe("");
         this.caissesCommerciales.setCaiNomJrTpe("");
      }

      if (this.var_journalTransfert != null && !this.var_journalTransfert.isEmpty() && this.var_journalTransfert.contains(":")) {
         var13 = this.var_journalTransfert.split(":");
         this.caissesCommerciales.setCaiJrTransfert(var13[0]);
         this.caissesCommerciales.setCaiNomJrTransfert(var13[1]);
      } else {
         this.caissesCommerciales.setCaiJrTransfert("");
         this.caissesCommerciales.setCaiNomJrTransfert("");
      }

      if (this.var_journalePaiement != null && !this.var_journalePaiement.isEmpty() && this.var_journalePaiement.contains(":")) {
         var13 = this.var_journalePaiement.split(":");
         this.caissesCommerciales.setCaiJrePaiement(var13[0]);
         this.caissesCommerciales.setCaiNomJrePaiement(var13[1]);
      } else {
         this.caissesCommerciales.setCaiJrePaiement("");
         this.caissesCommerciales.setCaiNomJrePaiement("");
      }

      if (this.var_journalCredoc != null && !this.var_journalCredoc.isEmpty() && this.var_journalCredoc.contains(":")) {
         var13 = this.var_journalCredoc.split(":");
         this.caissesCommerciales.setCaiJrCredoc(var13[0]);
         this.caissesCommerciales.setCaiNomJrCredoc(var13[1]);
      } else {
         this.caissesCommerciales.setCaiJrCredoc("");
         this.caissesCommerciales.setCaiNomJrCredoc("");
      }

      if (this.var_journalFactor != null && !this.var_journalFactor.isEmpty() && this.var_journalFactor.contains(":")) {
         var13 = this.var_journalFactor.split(":");
         this.caissesCommerciales.setCaiJrFactor(var13[0]);
         this.caissesCommerciales.setCaiNomJrFactor(var13[1]);
      } else {
         this.caissesCommerciales.setCaiJrFactor("");
         this.caissesCommerciales.setCaiNomJrFactor("");
      }

      if (this.var_journalCompense != null && !this.var_journalCompense.isEmpty() && this.var_journalCompense.contains(":")) {
         var13 = this.var_journalCompense.split(":");
         this.caissesCommerciales.setCaiJrCompense(var13[0]);
         this.caissesCommerciales.setCaiNomJrCompense(var13[1]);
      } else {
         this.caissesCommerciales.setCaiJrCompense("");
         this.caissesCommerciales.setCaiNomJrCompense("");
      }

      if (this.var_journalTerme != null && !this.var_journalTerme.isEmpty() && this.var_journalTerme.contains(":")) {
         var13 = this.var_journalTerme.split(":");
         this.caissesCommerciales.setCaiJrTerme(var13[0]);
         this.caissesCommerciales.setCaiNomJrTerme(var13[1]);
      } else {
         this.caissesCommerciales.setCaiJrTerme("");
         this.caissesCommerciales.setCaiNomJrTerme("");
      }

      if (this.var_journalLettreGarantie != null && !this.var_journalLettreGarantie.isEmpty() && this.var_journalLettreGarantie.contains(":")) {
         var13 = this.var_journalLettreGarantie.split(":");
         this.caissesCommerciales.setCaiJrLettreGarantie(var13[0]);
         this.caissesCommerciales.setCaiNomJrLettreGarantie(var13[1]);
      } else {
         this.caissesCommerciales.setCaiJrLettreGarantie("");
         this.caissesCommerciales.setCaiNomJrLettreGarantie("");
      }

      if (this.var_journalPrelevement != null && !this.var_journalPrelevement.isEmpty() && this.var_journalPrelevement.contains(":")) {
         var13 = this.var_journalPrelevement.split(":");
         this.caissesCommerciales.setCaiJrPrelevement(var13[0]);
         this.caissesCommerciales.setCaiNomJrPrelevement(var13[1]);
      } else {
         this.caissesCommerciales.setCaiJrPrelevement("");
         this.caissesCommerciales.setCaiNomJrPrelevement("");
      }

      if (this.var_journalAlcoin != null && !this.var_journalAlcoin.isEmpty() && this.var_journalAlcoin.contains(":")) {
         var13 = this.var_journalAlcoin.split(":");
         this.caissesCommerciales.setCaiJrAlcoin(var13[0]);
         this.caissesCommerciales.setCaiNomJrAlcoin(var13[1]);
      } else {
         this.caissesCommerciales.setCaiJrAlcoin("");
         this.caissesCommerciales.setCaiNomJrAlcoin("");
      }

      if (this.var_compte != null && !this.var_compte.isEmpty() && this.var_compte.contains(":")) {
         var13 = this.var_compte.split(":");
         this.caissesCommerciales.setCaiCompteVrt(var13[0]);
         this.caissesCommerciales.setCaiLibCompteVrt(var13[1]);
      } else {
         this.caissesCommerciales.setCaiCompteVrt("");
         this.caissesCommerciales.setCaiLibCompteVrt("");
      }

      if (this.var_compteEffet != null && !this.var_compteEffet.isEmpty() && this.var_compteEffet.contains(":")) {
         var13 = this.var_compteEffet.split(":");
         this.caissesCommerciales.setCaiCompteEff(var13[0]);
         this.caissesCommerciales.setCaiLibCompteEff(var13[1]);
      } else {
         this.caissesCommerciales.setCaiCompteEff("");
         this.caissesCommerciales.setCaiLibCompteEff("");
      }

      if (this.var_banqueDefaut != null && !this.var_banqueDefaut.isEmpty() && this.var_banqueDefaut.contains(":")) {
         var13 = this.var_banqueDefaut.split(":");
         this.caissesCommerciales.setCaiCodeBanqueDefaut(var13[0]);
         this.caissesCommerciales.setCaiNomBanqueDefaut(var13[1]);
      } else {
         this.caissesCommerciales.setCaiCodeBanqueDefaut("");
         this.caissesCommerciales.setCaiNomBanqueDefaut("");
      }

      if (this.inactif) {
         this.caissesCommerciales.setCaiInactif(1);
      } else {
         this.caissesCommerciales.setCaiInactif(0);
      }

      double var15 = this.caissesCommerciales.getCaiMontantInitCheque() + this.caissesCommerciales.getCaiMontantInitCompense() + this.caissesCommerciales.getCaiMontantInitCredoc() + this.caissesCommerciales.getCaiMontantInitEspece() + this.caissesCommerciales.getCaiMontantInitFactor() + this.caissesCommerciales.getCaiMontantInitTerme() + this.caissesCommerciales.getCaiMontantInitTpe() + this.caissesCommerciales.getCaiMontantInitTraite() + this.caissesCommerciales.getCaiMontantInitTransfert() + this.caissesCommerciales.getCaiMontantInitVirement() + this.caissesCommerciales.getCaiMontantInitePaiement();
      this.caissesCommerciales.setCaiMontantInit(var15);
      Session var14 = this.utilInitHibernate.getOpenSession(this.baseLog, "CaisseCommerciale");
      Transaction var5 = null;

      try {
         var5 = var14.beginTransaction();
         if (this.caissesCommerciales.getCaiId() == 0L) {
            this.caissesCommerciales.setExercicesCaisse(this.exocaiSelect);
            this.caissesCommerciales.setCaiDateCreat(new Date());
            this.caissesCommerciales.setCaiUserCreat(this.usersLog.getUsrid());
            this.caissesCommerciales = this.caissesCommercialesDao.insert(this.caissesCommerciales, var14);
            this.caisseList.add(this.caissesCommerciales);
            this.datamodelCaisse.setWrappedData(this.caisseList);
         } else {
            this.caissesCommerciales.setCaiDateModif(new Date());
            this.caissesCommerciales.setCaiUserModif(this.usersLog.getUsrid());
            this.caissesCommerciales = this.caissesCommercialesDao.modif(this.caissesCommerciales, var14);
         }

         new ArrayList();
         List var6 = this.usersChronoDao.selectListCaisse(this.caissesCommerciales.getCaiCode(), var14);
         if (var6.size() != 0) {
            for(int var7 = 0; var7 < var6.size(); ++var7) {
               this.usersChrono = (UsersChrono)var6.get(var7);
               this.usersChrono.setUsrchrCodeCaisse(this.caissesCommerciales.getCaiCode());
               this.usersChrono.setUsrchrLib(this.caissesCommerciales.getCaiNom());
               this.usersChrono.setUsrchrModeCaisse(this.caissesCommerciales.getCaiMode());
               this.usersChrono = this.usersChronoDao.modifier(this.usersChrono, var14);
            }
         }

         var5.commit();
      } catch (HibernateException var11) {
         if (var5 != null) {
            var5.rollback();
         }

         throw var11;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.visibiliteBton = false;
      this.showModalPanelCaisse = false;
   }

   public void affichageMontantInit() {
      if (this.var_journalCheque.equals("100")) {
         this.caissesCommerciales.setCaiMontantInitCheque(0.0D);
      }

      if (this.var_journalCompense.equals("100")) {
         this.caissesCommerciales.setCaiMontantInitCompense(0.0D);
      }

      if (this.var_journalCredoc.equals("100")) {
         this.caissesCommerciales.setCaiMontantInitCredoc(0.0D);
      }

      if (this.var_journalEspece.equals("100")) {
         this.caissesCommerciales.setCaiMontantInitEspece(0.0D);
      }

      if (this.var_journalFactor.equals("100")) {
         this.caissesCommerciales.setCaiMontantInitFactor(0.0D);
      }

      if (this.var_journalTerme.equals("100")) {
         this.caissesCommerciales.setCaiMontantInitTerme(0.0D);
      }

      if (this.var_journalLettreGarantie.equals("100")) {
         this.caissesCommerciales.setCaiMontantInitLettreGarantie(0.0D);
      }

      if (this.var_journalPrelevement.equals("100")) {
         this.caissesCommerciales.setCaiMontantInitPrelevement(0.0D);
      }

      if (this.var_journalAlcoin.equals("100")) {
         this.caissesCommerciales.setCaiMontantInitAlcoin(0.0D);
      }

      if (this.var_journalTpe.equals("100")) {
         this.caissesCommerciales.setCaiMontantInitTpe(0.0D);
      }

      if (this.var_journalTraite.equals("100")) {
         this.caissesCommerciales.setCaiMontantInitTraite(0.0D);
      }

      if (this.var_journalTransfert.equals("100")) {
         this.caissesCommerciales.setCaiMontantInitTransfert(0.0D);
      }

      if (this.var_journalVirement.equals("100")) {
         this.caissesCommerciales.setCaiMontantInitVirement(0.0D);
      }

      if (this.var_journalePaiement.equals("100")) {
         this.caissesCommerciales.setCaiMontantInitePaiement(0.0D);
      }

      this.calculTotalInit();
   }

   public void calculTotalInit() {
      double var1 = this.caissesCommerciales.getCaiMontantInitCheque() + this.caissesCommerciales.getCaiMontantInitCompense() + this.caissesCommerciales.getCaiMontantInitCredoc() + this.caissesCommerciales.getCaiMontantInitEspece() + this.caissesCommerciales.getCaiMontantInitFactor() + this.caissesCommerciales.getCaiMontantInitTerme() + this.caissesCommerciales.getCaiMontantInitTpe() + this.caissesCommerciales.getCaiMontantInitTraite() + this.caissesCommerciales.getCaiMontantInitTransfert() + this.caissesCommerciales.getCaiMontantInitVirement() + this.caissesCommerciales.getCaiMontantInitePaiement() + this.caissesCommerciales.getCaiMontantInitLettreGarantie();
      this.caissesCommerciales.setCaiMontantInit(var1);
   }

   public void allSelect() throws HibernateException, NamingException {
      if (this.userOperationsCaisses.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "CaisseCommerciale");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            new CaissesOperations();
            String var4 = "";
            boolean var5 = true;

            for(int var6 = 0; var6 < this.userOperationsCaisses.size(); ++var6) {
               CaissesOperations var3 = (CaissesOperations)this.userOperationsCaisses.get(var6);
               if (!var3.isSelect()) {
                  var3.setSelect(true);
                  if (var5) {
                     var5 = false;
                     var4 = var3.getCaiopeCode();
                  } else {
                     var4 = var4 + ":" + var3.getCaiopeCode();
                  }
               } else {
                  var3.setSelect(false);
               }
            }

            this.caissesCommerciales.setCaiOperation(var4);
            this.caissesCommerciales = this.caissesCommercialesDao.modif(this.caissesCommerciales, var1);
            var2.commit();
         } catch (HibernateException var10) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var10;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public boolean isDoublon() {
      return this.doublon;
   }

   public void setDoublon(boolean var1) {
      this.doublon = var1;
   }

   public boolean isInactif() {
      return this.inactif;
   }

   public void setInactif(boolean var1) {
      this.inactif = var1;
   }

   public boolean isShowModalPanelCaisse() {
      return this.showModalPanelCaisse;
   }

   public void setShowModalPanelCaisse(boolean var1) {
      this.showModalPanelCaisse = var1;
   }

   public DataModel getDatamodelCaisse() {
      return this.datamodelCaisse;
   }

   public void setDatamodelCaisse(DataModel var1) {
      this.datamodelCaisse = var1;
   }

   public boolean isVisibiliteBton() {
      return this.visibiliteBton;
   }

   public void setVisibiliteBton(boolean var1) {
      this.visibiliteBton = var1;
   }

   public List getCaisseList() {
      return this.caisseList;
   }

   public void setCaisseList(List var1) {
      this.caisseList = var1;
   }

   public CaissesCommerciales getCaissesCommerciales() {
      return this.caissesCommerciales;
   }

   public void setCaissesCommerciales(CaissesCommerciales var1) {
      this.caissesCommerciales = var1;
   }

   public ExercicesCaisse getExocaiSelect() {
      return this.exocaiSelect;
   }

   public void setExocaiSelect(ExercicesCaisse var1) {
      this.exocaiSelect = var1;
   }

   public List getMesCaissiersItems() {
      return this.mesCaissiersItems;
   }

   public void setMesCaissiersItems(List var1) {
      this.mesCaissiersItems = var1;
   }

   public Chrono getChrono() {
      return this.chrono;
   }

   public void setChrono(Chrono var1) {
      this.chrono = var1;
   }

   public List getMesChronosItems() {
      return this.mesChronosItems;
   }

   public void setMesChronosItems(List var1) {
      this.mesChronosItems = var1;
   }

   public List getLesTypeReglements() {
      return this.lesTypeReglements;
   }

   public void setLesTypeReglements(List var1) {
      this.lesTypeReglements = var1;
   }

   public ExercicesComptable getExerciceComptable() {
      return this.exerciceComptable;
   }

   public void setExerciceComptable(ExercicesComptable var1) {
      this.exerciceComptable = var1;
   }

   public List getMesJouranuxCaisseItems() {
      return this.mesJouranuxCaisseItems;
   }

   public void setMesJouranuxCaisseItems(List var1) {
      this.mesJouranuxCaisseItems = var1;
   }

   public String getVar_journalCheque() {
      return this.var_journalCheque;
   }

   public void setVar_journalCheque(String var1) {
      this.var_journalCheque = var1;
   }

   public String getVar_journalEspece() {
      return this.var_journalEspece;
   }

   public void setVar_journalEspece(String var1) {
      this.var_journalEspece = var1;
   }

   public List getMesPlansComptableItem() {
      return this.mesPlansComptableItem;
   }

   public void setMesPlansComptableItem(List var1) {
      this.mesPlansComptableItem = var1;
   }

   public PlanComptable getPlanComptable() {
      return this.planComptable;
   }

   public void setPlanComptable(PlanComptable var1) {
      this.planComptable = var1;
   }

   public String getVar_compte() {
      return this.var_compte;
   }

   public void setVar_compte(String var1) {
      this.var_compte = var1;
   }

   public List getMesChronosDecaissementItems() {
      return this.mesChronosDecaissementItems;
   }

   public void setMesChronosDecaissementItems(List var1) {
      this.mesChronosDecaissementItems = var1;
   }

   public List getMesChronosEncaissementItems() {
      return this.mesChronosEncaissementItems;
   }

   public void setMesChronosEncaissementItems(List var1) {
      this.mesChronosEncaissementItems = var1;
   }

   public List getMesChronosEntreeItems() {
      return this.mesChronosEntreeItems;
   }

   public void setMesChronosEntreeItems(List var1) {
      this.mesChronosEntreeItems = var1;
   }

   public List getMesChronosSortieItems() {
      return this.mesChronosSortieItems;
   }

   public void setMesChronosSortieItems(List var1) {
      this.mesChronosSortieItems = var1;
   }

   public List getMesChronosVirementItems() {
      return this.mesChronosVirementItems;
   }

   public void setMesChronosVirementItems(List var1) {
      this.mesChronosVirementItems = var1;
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

   public String getVar_compteEffet() {
      return this.var_compteEffet;
   }

   public void setVar_compteEffet(String var1) {
      this.var_compteEffet = var1;
   }

   public String getVar_banqueDefaut() {
      return this.var_banqueDefaut;
   }

   public void setVar_banqueDefaut(String var1) {
      this.var_banqueDefaut = var1;
   }

   public String getVar_journalCompense() {
      return this.var_journalCompense;
   }

   public void setVar_journalCompense(String var1) {
      this.var_journalCompense = var1;
   }

   public String getVar_journalCredoc() {
      return this.var_journalCredoc;
   }

   public void setVar_journalCredoc(String var1) {
      this.var_journalCredoc = var1;
   }

   public String getVar_journalFactor() {
      return this.var_journalFactor;
   }

   public void setVar_journalFactor(String var1) {
      this.var_journalFactor = var1;
   }

   public String getVar_journalTerme() {
      return this.var_journalTerme;
   }

   public void setVar_journalTerme(String var1) {
      this.var_journalTerme = var1;
   }

   public String getVar_journalTpe() {
      return this.var_journalTpe;
   }

   public void setVar_journalTpe(String var1) {
      this.var_journalTpe = var1;
   }

   public String getVar_journalTraite() {
      return this.var_journalTraite;
   }

   public void setVar_journalTraite(String var1) {
      this.var_journalTraite = var1;
   }

   public String getVar_journalTransfert() {
      return this.var_journalTransfert;
   }

   public void setVar_journalTransfert(String var1) {
      this.var_journalTransfert = var1;
   }

   public String getVar_journalVirement() {
      return this.var_journalVirement;
   }

   public void setVar_journalVirement(String var1) {
      this.var_journalVirement = var1;
   }

   public String getVar_journalePaiement() {
      return this.var_journalePaiement;
   }

   public void setVar_journalePaiement(String var1) {
      this.var_journalePaiement = var1;
   }

   public boolean isVar_afficheCheque() {
      return this.var_afficheCheque;
   }

   public void setVar_afficheCheque(boolean var1) {
      this.var_afficheCheque = var1;
   }

   public boolean isVar_afficheCompense() {
      return this.var_afficheCompense;
   }

   public void setVar_afficheCompense(boolean var1) {
      this.var_afficheCompense = var1;
   }

   public boolean isVar_afficheCredoc() {
      return this.var_afficheCredoc;
   }

   public void setVar_afficheCredoc(boolean var1) {
      this.var_afficheCredoc = var1;
   }

   public boolean isVar_afficheEspece() {
      return this.var_afficheEspece;
   }

   public void setVar_afficheEspece(boolean var1) {
      this.var_afficheEspece = var1;
   }

   public boolean isVar_afficheFactor() {
      return this.var_afficheFactor;
   }

   public void setVar_afficheFactor(boolean var1) {
      this.var_afficheFactor = var1;
   }

   public boolean isVar_afficheTerme() {
      return this.var_afficheTerme;
   }

   public void setVar_afficheTerme(boolean var1) {
      this.var_afficheTerme = var1;
   }

   public boolean isVar_afficheTpe() {
      return this.var_afficheTpe;
   }

   public void setVar_afficheTpe(boolean var1) {
      this.var_afficheTpe = var1;
   }

   public boolean isVar_afficheTraite() {
      return this.var_afficheTraite;
   }

   public void setVar_afficheTraite(boolean var1) {
      this.var_afficheTraite = var1;
   }

   public boolean isVar_afficheTransfert() {
      return this.var_afficheTransfert;
   }

   public void setVar_afficheTransfert(boolean var1) {
      this.var_afficheTransfert = var1;
   }

   public boolean isVar_afficheVirement() {
      return this.var_afficheVirement;
   }

   public void setVar_afficheVirement(boolean var1) {
      this.var_afficheVirement = var1;
   }

   public boolean isVar_afficheePaiement() {
      return this.var_afficheePaiement;
   }

   public void setVar_afficheePaiement(boolean var1) {
      this.var_afficheePaiement = var1;
   }

   public DataModel getDataModelOperation() {
      return this.dataModelOperation;
   }

   public void setDataModelOperation(DataModel var1) {
      this.dataModelOperation = var1;
   }

   public boolean isVar_afficheEspeceST() {
      return this.var_afficheEspeceST;
   }

   public void setVar_afficheEspeceST(boolean var1) {
      this.var_afficheEspeceST = var1;
   }

   public String getVar_journalEspeceST() {
      return this.var_journalEspeceST;
   }

   public void setVar_journalEspeceST(String var1) {
      this.var_journalEspeceST = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public List getMesProjetsItems() {
      return this.mesProjetsItems;
   }

   public void setMesProjetsItems(List var1) {
      this.mesProjetsItems = var1;
   }

   public boolean isProjetActif() {
      return this.projetActif;
   }

   public void setProjetActif(boolean var1) {
      this.projetActif = var1;
   }

   public boolean isVar_afficheLettreGarantie() {
      return this.var_afficheLettreGarantie;
   }

   public void setVar_afficheLettreGarantie(boolean var1) {
      this.var_afficheLettreGarantie = var1;
   }

   public String getVar_journalLettreGarantie() {
      return this.var_journalLettreGarantie;
   }

   public void setVar_journalLettreGarantie(String var1) {
      this.var_journalLettreGarantie = var1;
   }

   public long getIdCaissier() {
      return this.idCaissier;
   }

   public void setIdCaissier(long var1) {
      this.idCaissier = var1;
   }

   public boolean isVar_affichePrelevement() {
      return this.var_affichePrelevement;
   }

   public void setVar_affichePrelevement(boolean var1) {
      this.var_affichePrelevement = var1;
   }

   public String getVar_journalAlcoin() {
      return this.var_journalAlcoin;
   }

   public void setVar_journalAlcoin(String var1) {
      this.var_journalAlcoin = var1;
   }

   public String getVar_journalPrelevement() {
      return this.var_journalPrelevement;
   }

   public void setVar_journalPrelevement(String var1) {
      this.var_journalPrelevement = var1;
   }

   public boolean isVar_afficheAlcoin() {
      return this.var_afficheAlcoin;
   }

   public void setVar_afficheAlcoin(boolean var1) {
      this.var_afficheAlcoin = var1;
   }
}
